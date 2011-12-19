package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import net.anei.cadpage.SmsPopupUtils;
import net.anei.cadpage.billing.BillingManager;

/**
Recalculate Purchase Status
 */
public class DonateResetMarketEvent extends DonateEvent {
  
  public DonateResetMarketEvent() {
    super(AlertStatus.YELLOW, R.string.donate_reset_market_title);
  }

  @Override
  protected void doEvent(Activity activity) {
    
    // Don't do anything if we aren't hooked to network
    if (!SmsPopupUtils.haveNet(activity)) return;
    
    // Reset Android purchase information
    ManagePreferences.setInitBilling(false);
    BillingManager.instance().initialize(activity);
    
    // Request status reload from server
    UserAcctManager.instance().reloadStatus(activity);
    
    // Close donation screens
    closeEvents(activity);
  }
  
  private static final DonateResetMarketEvent instance = new DonateResetMarketEvent();
  
  public static DonateResetMarketEvent instance() {
    return instance;
  }

}
