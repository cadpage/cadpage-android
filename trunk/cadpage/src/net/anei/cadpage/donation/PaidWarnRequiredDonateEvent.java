package net.anei.cadpage.donation;

import java.text.DateFormat;
import java.util.Date;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import net.anei.cadpage.vendors.VendorManager;

/**
  
  Your %1$s subscription will expire in %2$d days

  Your %1$s Cadpage subscription will expire on %2$s.  The Cadpage Paging
  service subscrption has no grace period.  Pages will stop being forwarded
  as soon as your subscription expires.

 */
public class PaidWarnRequiredDonateEvent extends DonateScreenEvent {
  
  public PaidWarnRequiredDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_paid_warn_required_title, R.string.donate_paid_warn_required_text,
        AndroidDonateEvent.instance(), 
        DonateAndroidUnsuportedEvent.instance(), 
        AndroidDonateBetaEvent.instance(),
        AndroidDonateProblemEvent.instance(),
        DonateResetMarketEvent.instance(),
        Android16DonateEvent.instance(),
        NoUserDonateEvent.instance(), 
        WrongUserDonateEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.PAID_WARN &&
            VendorManager.instance().isPaidSubRequired());
  }

  @Override
  protected Object[] getTextParms(int type) {
    
    String subType = ManagePreferences.subscriptionType();

    switch (type) {
      
    case PARM_TITLE:
      return new Object[]{subType, DonationManager.instance().daysTillExpire()};
      
    case PARM_TEXT:
      Date expireDate = DonationManager.instance().expireDate();
      String sDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(expireDate);
      return new Object[]{subType, sDate};

    default:
      return null;
    }
  }
  
  private static final PaidWarnRequiredDonateEvent instance = new PaidWarnRequiredDonateEvent();
  
  public static PaidWarnRequiredDonateEvent instance() {
    return instance;
  }

}
