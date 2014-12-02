package net.anei.cadpage.billing;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import net.anei.cadpage.Log;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.donation.DonationCalculator;
import net.anei.cadpage.billing.IabHelper;
import net.anei.cadpage.billing.IabResult;


public class BillingManager {

  // The helper object
  private IabHelper mHelper;
  
  private static final Object LOCK = new Object();
  
  private boolean supported = false;
  
  private boolean inProgress = false;
  
  private List<Runnable> eventQueue = null;
  
  /**
   * @return true if In-app billing is supported for this system
   */
  public boolean isSupported() {
    return supported;
  }
  
  /**
   * Initialize billing manager and associate it with an activity
   * @param context current context
   * @return true if transaction request was queued.  False if billing
   * is not currently active
   */
  public void initialize(Context context) {
    String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqFWE1ScDZE5AG6Hjolnned1BEfz0kWDw6R1Jx23LZnxBqysK7e7fp+rq+LEOso9DHfZd0xMF2DI895Y/DrWIFMRfVBwpNdDd9NJv5JBr92oVVs1VmmAOgRZlBR5puZL94LWYz6YsonmmvU7HOIlk8GKiv+zpcSIvVlyl9/J572YOw5Eyah/2aWU5R7YmDO6oar8+/n/0k0zPSF79Qjlo5u/Ph+T7izfVzzBecfn8mxUoeS6Ax6V/WXR2L/YXxiEXbvEDBPFFPHAzb+oG+LOFtu5KLOfXX8HZlPCs0YjhApXyIIn+UewBMVqUMy5yuPSTp6SpLb8Pglf/q0JDZgYD6wIDAQAB";

    // Create the helper, passing it our context and the public key to verify signatures with
    mHelper = new IabHelper(context, base64EncodedPublicKey);

    // enable debug logging (for a production application, you should set this to false).
    mHelper.enableDebugLogging(true, Log.LOGTAG);

    // Start setup. This is asynchronous and the specified listener
    // will be called once setup completes.
    if (Log.DEBUG) Log.v("Starting billing setup.");
    supported = false;
    inProgress = true;
    mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
      public void onIabSetupFinished(IabResult result) {
        inProgress = false;
        if (Log.DEBUG) Log.v("Billing setup finished.");

        if (!result.isSuccess()) {
          Log.e("Problem setting up in-app billing: " + result);
          return;
        }
        
        if (mHelper == null) return;

        // OK, everything s up
        
        synchronized (LOCK) {
          supported = true;
  
          // Run any events that have been queued waiting for this to happen
          if (eventQueue != null) {
            for (Runnable event : eventQueue) event.run();
          }
          eventQueue = null;
        }
      }

      @Override
      public void onIabSetupDisconnected() {
        synchronized (LOCK) {
          supported = false;
        }
      }
    });
    
    // Restore transactions when billing connection is established
    // Queue event to restore our purchase status
    restoreTransactions();
  }
  
  /**
   * Shutdown billing manager
   */
  public void destroy() {
    supported = false;
    if (mHelper != null) {
      if (Log.DEBUG) Log.v("Destroying Billing helper.");
      mHelper.dispose();
      mHelper = null;
    }
  }
  
  /**
   * Queue runnable event to be run when billing is up and running
   * @param event Runnable event to be run when billing is supported
   * @return true if event was run or will be run in the forseable future,
   * false if it just isn't going to happen
   */
  public boolean runWhenSupported(Runnable event) {
    synchronized (LOCK) {
      if (supported) {
        event.run();
        return true;
      }
      else {
        if (eventQueue == null) eventQueue = new ArrayList<Runnable>();
        eventQueue.add(event);
        return true;
      }
    }
  }
  
  /**
   * Request transaction history restore
   * @return true if successful
   */
  public void restoreTransactions() {
    if (mHelper == null) return;
    
    Log.v("Queue Restore Billing Transactions");
    runWhenSupported(new Runnable(){
      @Override
      public void run() {
        Log.v("Restore Billing Transactions");
        inProgress = true;
        mHelper.queryInventoryAsync(false, null, new IabHelper.QueryInventoryFinishedListener(){
          @Override
          public void onQueryInventoryFinished(IabResult result, Inventory inventory) {

            inProgress = false;
            if (mHelper == null) return;

            if (result.isFailure()) {
                Log.e("Failed to query inventory: " + result);
                if (!supported && result.isRemoteFailure()) {
                  Log.e("Requeing restore transaction request");
                  restoreTransactions();
                }
                return;
            }

            DonationCalculator calc = new DonationCalculator(1);
            for (Purchase purchase : inventory.getAllPurchases()) {
              registerPurchaseState(purchase, calc);
            }
            calc.save();
          }
        });
      }
    });
  }

  /**
   * @return true if the current year item is available for purchase
   */
  public boolean isPurchaseAvail() {
    if (!supported) return false;
    if (isPurchased()) return false;
    return true;
  }
  
  public boolean isPurchased() {
    if (ManagePreferences.freeSub()) return false;
    Calendar cal = Calendar.getInstance(); 
    int year = cal.get(Calendar.YEAR);
    int paidYear = ManagePreferences.paidYear();
    if (paidYear > year) return true;
    if (paidYear == year && cal.get(Calendar.MONTH) < Calendar.DECEMBER) return true;
    return false;
  }
  
  /**
   * Request purchase of current year product
   * @param activity
   */
  public void startPurchase(BillingActivity activity) {
    if (mHelper == null) return;
    if (!supported) return;
    if (inProgress) return;
    
    if (activity == null) return;
    if (activity.isFinishing()) return;
    
    int curYear = ManagePreferences.paidYear();
    String year = null;
    String purchaseDate = null;
    String curDate = ManagePreferences.currentDateString();
    
    // If paid subscription has already purchased, use the previous
    // purchase date.  Unless user subscription has expired, in 
    // which case we will give them a break and ignore the 
    // previous expired subscription
    if (curYear > 0 && !ManagePreferences.freeSub()) {
      year = Integer.toString(curYear + 1);
      purchaseDate = ManagePreferences.purchaseDateString();
      if (purchaseDate == null) purchaseDate = ManagePreferences.currentDateString();
      String expDateYMD = year + purchaseDate.substring(0,4);
      String curDateYMD = curDate.substring(4) + curDate.substring(0,4);
      if (curDateYMD.compareTo(expDateYMD) > 0) purchaseDate = null;
    } 
    
    // If there was no previous subscription, or we are ignoring it
    // because it has expired, use current date to compute things
    if (purchaseDate ==  null) {
      purchaseDate = curDate;
      year = purchaseDate.substring(4);
    }
    
    String item = "cadpage_" + year;
    String payload = purchaseDate;
    
    Log.v("Purchase request for " + item + " payload:" + payload);

    inProgress = true;
    mHelper.launchPurchaseFlow(activity, item, 10001,
      new IabHelper.OnIabPurchaseFinishedListener(){
        @Override
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
          inProgress = false;
          if (mHelper == null) return;
          if (result.isFailure()) {
            Log.e("Purchase failure " + result);
            return;
          }
          DonationCalculator calc = new DonationCalculator(1);
          calc.load();
          registerPurchaseState(purchase, calc);
          calc.save();
        }
      }, payload);
  }

  private void registerPurchaseState(Purchase purchase, DonationCalculator calc) {
    int purchaseState = purchase.getPurchaseState();
    String itemId = purchase.getSku();
    String payload = purchase.getDeveloperPayload();
    if (Log.DEBUG) Log.v("PurchaseState:" + purchaseState + "  Item:" + itemId + "  Payload:" + payload);
    if (itemId.startsWith("cadpage_")) {
      String year = itemId.substring(8);
      if (purchaseState == IabHelper.BILLING_RESPONSE_RESULT_OK) {
        calc.subscription(year, payload, null);
      }
    }
  }

  public boolean handleActivityResult(int requestCode, int resultCode, Intent data) {
    
    Log.v("Billing request result: req:" + requestCode + " result:" + resultCode);
    
    if (mHelper == null) return false;
    if (!isSupported()) return false;

    // Pass on the activity result to the helper for handling
    return mHelper.handleActivityResult(requestCode, resultCode, data);
  }
  
  /**
   * Clear out the complete inventory of purchasable items.  This is only 
   * used to assist developer testing
   */
  public void clearPurchaseInventory() {
    
    if (mHelper == null) return;
    if (!supported) return;
    if (inProgress) return;
    
    Log.v("Clear purchase inventory");
    mHelper.queryInventoryAsync(new IabHelper.QueryInventoryFinishedListener(){
      @Override
      public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
        inProgress = false;
        if (mHelper == null) return;

        if (result.isFailure()) {
            Log.e("Failed to query inventory: " + result);
            return;
        }

        for (Purchase purchase : inventory.getAllPurchases()) {
          if (purchase.getSku().startsWith("cadpage_")) {
            if (purchase.getItemType().equals(IabHelper.ITEM_TYPE_INAPP)) {
              inProgress = true;
              mHelper.consumeAsync(purchase, new IabHelper.OnConsumeFinishedListener(){
                @Override
                public void onConsumeFinished(Purchase purchase, IabResult result) {
                  inProgress = false;
                  Log.v("Consuming " + purchase.getSku() + " result:" + result);
                }
              });
            }
          }
        }
      }
    });
  }
  
  private static BillingManager instance = new BillingManager();
  
  public static BillingManager instance() {
    return instance;
  }
}
