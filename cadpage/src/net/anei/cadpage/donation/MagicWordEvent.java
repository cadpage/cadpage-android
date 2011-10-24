package net.anei.cadpage.donation;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import android.app.Activity;

/*
I have an authorization code

Enter authorization code
 */
public class MagicWordEvent extends DonateQueryEvent {
  
  private static final String LOCATION = "TXCyCreekCommCenter";
  private static final String ORG = "Cypress Creek VFD";
  
  public MagicWordEvent() {
    super(null, R.string.donate_magic_word_title, R.string.donate_magic_word_text);
  }

  @Override
  public boolean isEnabled() {
    DonationManager.DonationStatus status = DonationManager.instance().status();
    return status != DonationManager.DonationStatus.FREE &&
            status != DonationManager.DonationStatus.PAID &&
            status != DonationManager.DonationStatus.AUTH_DEPT;
  }

  @Override
  protected boolean process(Activity activity, String input) {
    
    if (DonationManager.validateAuthCode(input)) {
      ManagePreferences.setExemptDate();
      return true;
    }

    String code = activity.getString(R.string.release_magic_word2);
    if (input.equalsIgnoreCase(code)) {
      ManagePreferences.setAuthLocation(LOCATION);
      ManagePreferences.setAuthOrganization(ORG);
      return true;
    }
    
    activity.showDialog(R.string.donate_magic_word_reject);
    return false;
  }
  
  private static final MagicWordEvent instance = new MagicWordEvent();
  
  public static MagicWordEvent instance() {
    return instance;
  }

}
