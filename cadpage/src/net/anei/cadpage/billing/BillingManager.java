package net.anei.cadpage.billing;

import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.billing.BillingService.RequestPurchase;
import net.anei.cadpage.billing.BillingService.RestoreTransactions;
import net.anei.cadpage.billing.Consts.PurchaseState;
import net.anei.cadpage.billing.Consts.ResponseCode;


public class BillingManager {
  
  private BillingService mService = null;
  private boolean reload = false;
  
  private boolean supported = false;
  
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
   * @param activity main activity
   */
  public void initialize(Context context) {
    reload = ! ManagePreferences.initBilling();
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
   * @return true if the current year item is available for purchase
   */
  public boolean isPurchaseAvail() {
    if (!supported) return false;
    if (isPurchased()) return false;
    return true;
  }
  
  public boolean isPurchased() {
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
    
    // If subscription has already purchased, use the previous
    // purchase date.  Unless user subscription has expired, in 
    // which case we will give them a break and ignore the 
    // previous expired subscription
    if (curYear > 0) {
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
      if (mService != null && reload && supported) mService.restoreTransactions();
    }

    @Override
    public void onPurchaseStateChange(PurchaseState purchaseState,
                                       String itemId, long purchaseTime, 
                                       String payload) {
      if (itemId.startsWith("cadpage_")) {
        int year = Integer.parseInt(itemId.substring(8));
        ManagePreferences.setPaidYear(year, purchaseState == PurchaseState.PURCHASED);
        if (payload != null) ManagePreferences.setPurchaseDateString(payload);
        ManagePreferences.setFreeSub(false);
        ManagePreferences.setSponsor(null);
      }
    }

    @Override
    public void onRequestPurchaseResponse(RequestPurchase request,
        ResponseCode responseCode) {
    }

    @Override
    public void onRestoreTransactionsResponse(RestoreTransactions request,
                                               ResponseCode responseCode) {
      if (responseCode == ResponseCode.RESULT_OK) {
        reload = false;
        ManagePreferences.setInitBilling();
      }
    }
    
  }
  
  private static BillingManager instance = new BillingManager();
  
  public static BillingManager instance() {
    return instance;
  }

}
