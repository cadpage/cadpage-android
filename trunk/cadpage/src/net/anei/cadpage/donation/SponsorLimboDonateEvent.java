package net.anei.cadpage.donation;

import java.text.DateFormat;
import java.util.Date;

import net.anei.cadpage.R;

/**
  
%s sponsorship has expired

Your using a service sponsored by %1$s that expired on %2$s.  You can continue to 
use Cadpage as long as you do not install a release published after that date.  Please
contact %1$s about renewing their Cadpage sponsorship.

 */
public class SponsorLimboDonateEvent extends DonateScreenEvent {
  
  public SponsorLimboDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_sponsor_limbo_title, R.string.donate_sponsor_limbo_text,
           ReqMoneyGroup.instance(), 
           MagicWordEvent.instance(),
           DonateWhatsUpEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.SPONSOR_LIMBO);
  }

  @Override
  protected Object[] getTextParms(int type) {
    
    switch (type) {
      
    case PARM_TITLE:
      return new Object[]{
          DonationManager.instance().sponsor()
      };
      
    case PARM_TEXT:
      Date expireDate = DonationManager.instance().expireDate();
      String sDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(expireDate);
      return new Object[]{
          DonationManager.instance().sponsor(),
          sDate
      };

    default:
      return null;
    }
  }
  
  private static final SponsorLimboDonateEvent instance = new SponsorLimboDonateEvent();
  
  public static SponsorLimboDonateEvent instance() {
    return instance;
  }

}
