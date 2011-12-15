package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import net.anei.cadpage.SmsPopupUtils;
import net.anei.cadpage.billing.BillingManager;

/**
Donate through PayPal
 */
public class DonateResetMarketEvent extends DonateEvent {
  
  public DonateResetMarketEvent() {
    super(AlertStatus.YELLOW, R.string.donate_reset_market_title);
  }

  @Override
  protected void doEvent(Activity activity) {
    if (!SmsPopupUtils.haveNet(activity)) return;
    ManagePreferences.setInitBilling(false);
    BillingManager.instance().initialize(activity);
    closeEvents(activity);
  }
  
  private static final DonateResetMarketEvent instance = new DonateResetMarketEvent();
  
  public static DonateResetMarketEvent instance() {
    return instance;
  }

}
