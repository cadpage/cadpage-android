package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/**
Your Cadpage subscription is about to expire

Your current Cadpage subscription will expire in %d days
 */
public class PaidWarnDonateEvent extends DonateScreenEvent {
  
  public PaidWarnDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_paid_warn_title, R.string.donate_paid_warn_text,
           ReqMoneyGroup.instance(), MagicWordEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return (DonationManager.status() == DonationManager.DonationStatus.PAID_WARN);
  }

  @Override
  protected Object[] getTextParms(int type) {
    
    switch (type) {
      
    case PARM_TEXT:
      return new Object[]{DonationManager.daysTillExpire()};

    default:
      return null;
    }
  }
  
  private static final PaidWarnDonateEvent instance = new PaidWarnDonateEvent();
  
  public static PaidWarnDonateEvent instance() {
    return instance;
  }

}
