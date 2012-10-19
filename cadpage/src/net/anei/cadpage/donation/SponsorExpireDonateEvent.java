package net.anei.cadpage.donation;

import java.text.DateFormat;
import java.util.Date;

import net.anei.cadpage.R;

/**
Your Cadpage subscription has expired

Your current Cadpage subscription expired on %s
 */
public class SponsorExpireDonateEvent extends DonateScreenEvent {
  
  public SponsorExpireDonateEvent() {
    super(AlertStatus.RED, R.string.donate_sponsor_expire_title, R.string.donate_sponsor_expire_text,
           ReqMoneyGroup.instance(),
           DonateExtraDayEvent.instance(),
           MagicWordEvent.instance(),
           DonateWhatsUpEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.SPONSOR_EXPIRE);
  }

  @Override
  protected Object[] getTextParms(int type) {
    
    switch (type) {
      
    case PARM_TEXT:
      Date expireDate = DonationManager.instance().expireDate();
      String sDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(expireDate);
      return new Object[]{
          DonationManager.instance().sponsor(),
          sDate
      };

    default:
      return new Object[]{DonationManager.instance().sponsor()};
    }
  }
  
  private static final SponsorExpireDonateEvent instance = new SponsorExpireDonateEvent();
  
  public static SponsorExpireDonateEvent instance() {
    return instance;
  }

}
