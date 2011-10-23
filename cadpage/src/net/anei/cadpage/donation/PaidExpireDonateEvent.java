package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/**
Your Cadpage subscription has expired

Your current Cadpage subscription expired %d days ago
 */
public class PaidExpireDonateEvent extends DonateScreenEvent {
  
  public PaidExpireDonateEvent() {
    super(AlertStatus.RED, R.string.donate_paid_expire_title, R.string.donate_paid_expire_text,
           ReqMoneyGroup.instance(),
           DonateExtraDayEvent.instance(),
           MagicWordEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.PAID_EXPIRE);
  }

  @Override
  protected Object[] getTextParms(int type) {
    
    switch (type) {
      
    case PARM_TEXT:
      return new Object[]{-DonationManager.instance().daysTillExpire()};

    default:
      return null;
    }
  }
  
  private static final PaidExpireDonateEvent instance = new PaidExpireDonateEvent();
  
  public static PaidExpireDonateEvent instance() {
    return instance;
  }

}
