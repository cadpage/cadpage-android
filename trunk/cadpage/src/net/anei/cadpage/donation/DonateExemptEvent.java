package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/*
Exempt from release checks

You are exempt from any demo or subscription limits until the next Cadpage
version update which must be done in the next %d days.
 */
public class DonateExemptEvent extends DonateScreenEvent {

  protected DonateExemptEvent() {
    super(AlertStatus.YELLOW, R.string.donate_exempt_title, R.string.donate_exempt_text,
           Vendor2Event.instance(),
           DonateResetMarketEvent.instance(),
           MagicWordEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return DonationManager.instance().status() == DonationManager.DonationStatus.EXEMPT;
  }

  @Override
  protected Object[] getTextParms(int type) {
    
    switch (type) {
      
    case PARM_TEXT:
      return new Object[]{DonationManager.instance().daysTillExpire()};

    default:
      return null;
    }
  }
  
  private static final DonateExemptEvent instance = new DonateExemptEvent();
  public static DonateExemptEvent instance() {
    return instance;
  }

}
