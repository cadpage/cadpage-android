package net.anei.cadpage.donation;

import net.anei.cadpage.R;
import net.anei.cadpage.billing.BillingManager;

/**
Donate through Android Market

The Android Market app reports that in-app purchases are not supported.
You may need to upgrade the Market app to the latest version.  Or you may
need to give it a valid Google account (Select menu > Accounts in the Market
app) 

 */
public class DonateAndroidUnsuportedEvent extends DonateScreenEvent {
  
  public DonateAndroidUnsuportedEvent() {
    super(AlertStatus.YELLOW, R.string.donate_android_title, R.string.donate_android_unsupported_text,
           DonateResetMarketEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return !BillingManager.instance().isSupported();
  }
  
  private static final DonateAndroidUnsuportedEvent instance = new DonateAndroidUnsuportedEvent();
  
  public static DonateAndroidUnsuportedEvent instance() {
    return instance;
  }

}
