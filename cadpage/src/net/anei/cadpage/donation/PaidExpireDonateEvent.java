package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/**
 * This is the nice top level donation event that appears when user is on
 * the free rider donate list
 */
public class PaidExpireDonateEvent extends DonateScreenEvent {
  
  public PaidExpireDonateEvent() {
    super(AlertStatus.RED, R.string.donate_paid_expire_title, R.string.donate_paid_expire_text,
           AndroidDonateEvent.instance(), PaypalDonateEvent.instance(), MagicWordEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return (DonationManager.status() == DonationManager.DonationStatus.PAID_EXPIRE);
  }

  @Override
  protected Object[] getTextParms(int type) {
    
    switch (type) {
      
    case PARM_TEXT:
      return new Object[]{-DonationManager.daysTillExpire()};

    default:
      return null;
    }
  }
  
  private static final PaidExpireDonateEvent instance = new PaidExpireDonateEvent();
  
  public static PaidExpireDonateEvent instance() {
    return instance;
  }

}
