package net.anei.cadpage.donation;

import java.text.DateFormat;
import java.util.Date;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import net.anei.cadpage.vendors.VendorManager;

/**
Your Cadpage subscription has expired

Your current Cadpage subscription expired on %s
 */
public class PaidExpireDonateEvent extends DonateScreenEvent {
  
  public PaidExpireDonateEvent() {
    super(AlertStatus.RED, R.string.donate_paid_expire_title, R.string.donate_paid_expire_text,
           ReqMoneyGroup.instance(),
           DonateExtraDayEvent.instance(),
           MagicWordEvent.instance(),
           DonateWhatsUpEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.PAID_EXPIRE &&
            !VendorManager.instance().isPaidSubRequired());
  }

  @Override
  protected Object[] getTextParms(int type) {
    
    String subType = ManagePreferences.subscriptionType();
   
    switch (type) {
    
    case PARM_TITLE:
      return new Object[]{subType};
      
    case PARM_TEXT:
      Date expireDate = DonationManager.instance().expireDate();
      String sDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(expireDate);
      return new Object[]{subType, sDate};

    default:
      return null;
    }
  }
  
  private static final PaidExpireDonateEvent instance = new PaidExpireDonateEvent();
  
  public static PaidExpireDonateEvent instance() {
    return instance;
  }

}
