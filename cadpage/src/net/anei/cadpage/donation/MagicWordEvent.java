package net.anei.cadpage.donation;

import net.anei.cadpage.C2DMReceiver;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import android.app.Activity;
import android.widget.Toast;

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
//
//  @Override
//  public boolean isEnabled() {
//    DonationManager.DonationStatus status = DonationManager.instance().status();
//    return status != DonationManager.DonationStatus.LIFE &&
//            status != DonationManager.DonationStatus.PAID &&
//            status != DonationManager.DonationStatus.AUTH_DEPT &&
//            status != DonationManager.DonationStatus.SPONSOR;
//  }

  @Override
  protected boolean process(Activity activity, String input) {
    
    // Special word that nobody knows about that will reset the C2DM registration code
    if (input.equalsIgnoreCase("ZAPIT")) {
      C2DMReceiver.unregister(activity);
      return true;
    }
    
    // More special words to enable and disable GCM registration
    if (input.equalsIgnoreCase("GCMON")) {
      ManagePreferences.setGcmEnabled(true);
      Toast.makeText(activity, "GCM Enabled", Toast.LENGTH_LONG).show();
      C2DMReceiver.register(activity);
      return true;
    }
    if (input.equalsIgnoreCase("GCMOFF")) {
      ManagePreferences.setGcmEnabled(false);
      Toast.makeText(activity, "GCM Disabled", Toast.LENGTH_LONG).show();
      C2DMReceiver.register(activity);
      return true;
    }
    
    // Check for two kinds of daily magic words
    int type = DonationManager.validateAuthCode(input);
    
    // Type one set the exempt date, which turns off release checks until
    // the next release is loaded
    if (type == 1) {
      ManagePreferences.setExemptDate();
      return true;
    }
    
    // Type 2 sets the authorized run days to zero, resetting the demo count
    // do trial demo
    if (type == 2) {
      ManagePreferences.setAuthRunDays(0);
      return true;
    }

    // Look for old fashioned Cyprus Creek VFD authorization code
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
