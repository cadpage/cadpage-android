package net.anei.cadpage.billing;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import net.anei.cadpage.Log;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.billing.BillingService.RequestPurchase;
import net.anei.cadpage.billing.BillingService.RestoreTransactions;
import net.anei.cadpage.billing.Consts.PurchaseState;
import net.anei.cadpage.billing.Consts.ResponseCode;
import net.anei.cadpage.donation.DonationManager;


public class BillingManager {
  
  private BillingService mService = null;
  
  private boolean supported = false;
  
  private List<Runnable> eventQueue = null;
  
  /**
   * @return true if In-app billing is supported for this system
   */
  public boolean isSupported() {
    return supported;
  }
  
  private BillingManager() {
    ResponseHandler.register(new CadpageObserver());
  }
  
  /**
   * Initialize billing manager and associate it with an activity
   * @param context current context
   * @return true if transaction request was queued.  False if billing
   * is not currently active
   */
  public void initialize(Context context) {
    mService = new BillingService();
    mService.setContext(context);
    mService.checkBillingSupported();
  }
  
  /**
   * Shutdown billing manager
   */
  public void destroy() {
    if (mService != null) mService.unbind();
    mService = null;
  }
  
  /**
   * Queue runnable event to be run when billing is up and running
   * @param event Runnable event to be run when billing is supported
   * @return true if event was run or will be run in the forseable future,
   * false if it just isn't going to happen
   */
  public boolean runWhenSupported(Runnable event) {
    if (isSupported()) {
      event.run();
      return true;
    }
    else {
      if (eventQueue == null) eventQueue = new ArrayList<Runnable>();
      eventQueue.add(event);
      return mService.checkBillingSupported();
    }
  }
  
  /**
   * Request transaction history restore
   * @return true if successful
   */
  public boolean restoreTransactions() {
    if (!supported) return false;
    Log.v("Restore Billing Transactions");
    mService.restoreTransactions();
    return true;
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
  public void startPurchase(Activity activity) {
    if (mService == null) return;
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
    mService.requestPurchase(activity, item, payload); 
  }
  

  private class CadpageObserver extends PurchaseObserver {

    @Override
    public void onBillingSupported(boolean supported) {
      BillingManager.this.supported = supported;
      if (mService != null && supported && eventQueue != null) {
        for (Runnable event : eventQueue) event.run();
      }
      eventQueue = null;
    }

    @Override
    public void onPurchaseStateChange(PurchaseState purchaseState,
                                       String itemId, long purchaseTime, 
                                       String payload) {
      Log.v("PurchaseState:" + purchaseState + "  Item:" + itemId + "  Payload:" + payload);
      if (itemId.startsWith("cadpage_")) {
        String year = itemId.substring(8);
        if (purchaseState == PurchaseState.PURCHASED) {
          DonationManager.processSubscription(year, payload, null);
        } else { 
          ManagePreferences.setPaidYear(Integer.parseInt(year), false);
        }
      }
    }

    @Override
    public void onRequestPurchaseResponse(RequestPurchase request, ResponseCode responseCode) {
      Log.v("Request Purchase Complete: " + responseCode);
    }

    @Override
    public void onRestoreTransactionsResponse(RestoreTransactions request,
                                               ResponseCode responseCode) {
      Log.v("Restore Transactions Complete: " + responseCode);
    }
  }
  
  private static BillingManager instance = new BillingManager();
  
  public static BillingManager instance() {
    return instance;
  }

}
