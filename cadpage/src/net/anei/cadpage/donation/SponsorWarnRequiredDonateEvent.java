package net.anei.cadpage.donation;

import java.text.DateFormat;
import java.util.Date;

import net.anei.cadpage.R;
import net.anei.cadpage.vendors.VendorManager;

/**
 *   
  %1$s sponsorship will expire in %2$d days

  You are using a service sponsored by %1$s that will expire on %2$s.  Please contact %1$s
  about renewing their Cadpage sponsorship.  The Cadpage Paging
  service subscription has no grace period.  Pages will stop being forwarded
  as soon as your subscription expires.
  
 */
public class SponsorWarnRequiredDonateEvent extends DonateScreenEvent {
  
  public SponsorWarnRequiredDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_sponsor_warn_required_title, R.string.donate_sponsor_warn_required_text,
           ReqMoneyGroup.instance(), 
           MagicWordEvent.instance(),
           DonateWhatsUpEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.SPONSOR_WARN &&
            VendorManager.instance().isPaidSubRequired());
  }

  @Override
  protected Object[] getTextParms(int type) {
    
    switch (type) {
      
    case PARM_TITLE:
      return new Object[]{
          DonationManager.instance().sponsor(),
          DonationManager.instance().daysTillExpire()
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
  
  private static final SponsorWarnRequiredDonateEvent instance = new SponsorWarnRequiredDonateEvent();
  
  public static SponsorWarnRequiredDonateEvent instance() {
    return instance;
  }

}
