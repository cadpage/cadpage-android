package net.anei.cadpage.donation;

import java.text.DateFormat;
import java.util.Date;

import net.anei.cadpage.R;

/**
Your Cadpage subscription will expire in %d days

Your current Cadpage subscription expired on %s.  You can continue to 
use Cadpage beyond that date as long as you do not install a release
published after that date.

 */
public class PaidLimboDonateEvent extends DonateScreenEvent {
  
  public PaidLimboDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_paid_limbo_title, R.string.donate_paid_limbo_text,
           ReqMoneyGroup.instance(), 
           MagicWordEvent.instance(),
           DonateWhatsUpEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.PAID_LIMBO);
  }

  @Override
  protected Object[] getTextParms(int type) {
    
    switch (type) {
      
    case PARM_TITLE:
      return new Object[]{DonationManager.instance().daysTillExpire()};
      
    case PARM_TEXT:
      Date expireDate = DonationManager.instance().expireDate();
      String sDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(expireDate);
      return new Object[]{sDate};

    default:
      return null;
    }
  }
  
  private static final PaidLimboDonateEvent instance = new PaidLimboDonateEvent();
  
  public static PaidLimboDonateEvent instance() {
    return instance;
  }

}
