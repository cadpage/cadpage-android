package net.anei.cadpage.donation;

import java.text.DateFormat;
import java.util.Date;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import net.anei.cadpage.vendors.VendorManager;

/**
  
  Your %s Cadpage subscription has expired
  
    Your %1$s Cadpage subscription expired on %2$s.  Cadpage Paging Service is
    suspended.

 */
public class PaidExpireRequiredDonateEvent extends DonateScreenEvent {
  
  public PaidExpireRequiredDonateEvent() {
    super(AlertStatus.RED, R.string.donate_paid_expire_required_title, R.string.donate_paid_expire_required_text,
        AndroidDonateEvent.instance(), 
        DonateAndroidUnsuportedEvent.instance(), 
        AndroidDonateBetaEvent.instance(),
        AndroidDonateProblemEvent.instance(),
        DonateResetMarketEvent.instance(),
        Android16DonateEvent.instance(),
        NoUserDonateEvent.instance(), 
        WrongUserDonateEvent.instance(),
        CadpageServiceEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.PAID_EXPIRE &&
            VendorManager.instance().isPaidSubRequired());
  }

  @Override
  protected Object[] getTextParms(int type) {
    
    String subType = ManagePreferences.subscriptionType();
   
    switch (type) {
    
    case PARM_TITLE:
      return new Object[]{subType};
      
    case PARM_TEXT:
      Date expireDate = DonationManager.instance().expireDate();
      String sDate = expireDate == null ? "" : DateFormat.getDateInstance(DateFormat.MEDIUM).format(expireDate);
      return new Object[]{subType, sDate};

    default:
      return null;
    }
  }
  
  private static final PaidExpireRequiredDonateEvent instance = new PaidExpireRequiredDonateEvent();
  
  public static PaidExpireRequiredDonateEvent instance() {
    return instance;
  }

}
