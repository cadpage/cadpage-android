package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/**
 * This is the nice top level donation event that appears when user is on
 * the free rider donate list
 */
public class PaidWarnDonateEvent extends DonateScreenEvent {
  
  public PaidWarnDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_paid_warn_title, R.string.donate_paid_warn_text,
           AndroidDonateEvent.instance(), PaypalDonateEvent.instance(), MagicWordEvent.instance());
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
