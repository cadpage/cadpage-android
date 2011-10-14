package net.anei.cadpage.donation;

import net.anei.cadpage.CadPageApplication;
import net.anei.cadpage.R;
import net.anei.cadpage.billing.BillingManager;

/**
Donate through Android Market

For technical reasons, you cannot make Android Market purchases from a beta
release of Cadpage.  You will have to wait until you install an official
release of Cadpage from the Android Market.
 */
public class AndroidDonateBetaEvent extends DonateScreenEvent {
  
  public AndroidDonateBetaEvent() {
    super(AlertStatus.YELLOW, R.string.donate_android_title, R.string.donate_android_beta_text);
  }

  @Override
  public boolean isEnabled() {
    return BillingManager.instance().isSupported() && CadPageApplication.isBetaRelease();
  }
  
  private static final AndroidDonateBetaEvent instance = new AndroidDonateBetaEvent();
  
  public static AndroidDonateBetaEvent instance() {
    return instance;
  }

}
