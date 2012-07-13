package net.anei.cadpage.donation;

/*
Thank you for your support

You have free access to Cadpage as a member of\n
%s\n
Thank you for your support
 */
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;

public class AuthDonateEvent extends DonateScreenEvent {

  protected AuthDonateEvent() {
    super(AlertStatus.GREEN, R.string.donate_auth_title, R.string.donate_auth_text,
           ReqMoneyGroup.instance(),
           DonateWhatsUpEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.AUTH_DEPT);
  }

  @Override
  protected Object[] getTextParms(int type) {
    
    switch (type) {
      
    case PARM_TEXT:
      return new Object[]{ManagePreferences.authOrganization()};

    default:
      return null;
    }
  }
  
  private static final AuthDonateEvent instance = new AuthDonateEvent();
  public static AuthDonateEvent instance() {
    return instance;
  }

}
