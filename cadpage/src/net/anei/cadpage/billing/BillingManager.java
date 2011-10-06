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
    int year = Calendar.getInstance().get(Calendar.YEAR);
    return year == ManagePreferences.paidYear();
  }
  
  /**
   * Request purchase of current year product
   * @param activity
   */
  public void startPurchase(Activity activity) {
    int year = Calendar.getInstance().get(Calendar.YEAR);
    String item = "cadpage_" + year;
    String payload = ManagePreferences.purchaseDateString();
    mService.requestPurchase(activity, item, payload); 
  }
  

  private class CadpageObserver extends PurchaseObserver {

    @Override
    public void onBillingSupported(boolean supported) {
      BillingManager.this.supported = supported;
      if (reload && supported) mService.restoreTransactions();
    }

    @Override
    public void onPurchaseStateChange(PurchaseState purchaseState,
                                       String itemId, long purchaseTime, 
                                       String payload) {
      if (itemId.startsWith("cadpage_")) {
        int year = Integer.parseInt(itemId.substring(8));
        ManagePreferences.setPaidYear(year, purchaseState == PurchaseState.PURCHASED);
        if (payload != null) ManagePreferences.setPurchaseDateString(payload);
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
