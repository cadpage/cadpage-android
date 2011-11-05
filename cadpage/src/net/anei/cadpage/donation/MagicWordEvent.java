package net.anei.cadpage.donation;

import java.util.Date;

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
    
    // Check for two kinds of daily magic words
    int type = DonationManager.validateAuthCode(input);
    
    // Type one set the exempt date, which turns off release checks until
    // the next release is loaded
    if (type == 1) {
      ManagePreferences.setExemptDate();
      return true;
    }
    
    // Type 2 sets the min install date to today, granting another 30 days
    // do trial demo
    if (type == 2) {
      ManagePreferences.setMinInstallDate(new Date());
      return true;
    }
    
    String code = activity.getString(R.string.min_install_magic_word);
    if (input.equalsIgnoreCase(code)) {
      ManagePreferences.setMinInstallDate(activity.getString(R.string.min_install_date_2));
      return true;
    }

    // Look for old fashioned Cyprus Creek VFD authorization code
    code = activity.getString(R.string.release_magic_word2);
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
