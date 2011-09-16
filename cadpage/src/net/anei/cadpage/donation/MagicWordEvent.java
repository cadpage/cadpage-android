package net.anei.cadpage.donation;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import android.app.Activity;

public class MagicWordEvent extends DonateQueryEvent {
  
  private static final String LOCATION = "TXCyCreekCommCenter";
  private static final String ORG = "Cypress Creek VFD";
  
  public MagicWordEvent() {
    super(null, R.string.donate_magic_word_title, R.string.donate_magic_word_text);
  }

  @Override
  public boolean isEnabled() {
    return LOCATION.equals(ManagePreferences.location()) &&
            !LOCATION.equals(ManagePreferences.authLocation());
  }

  @Override
  protected boolean process(Activity activity, String input) {
    String code = activity.getString(R.string.release_magic_word2);
    if (input.equals(code)) {
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
