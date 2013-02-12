package net.anei.cadpage.donation;

import net.anei.cadpage.Safe40Activity;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

public class DonateActivity extends Safe40Activity {
  
  private static final String EXTRA_SCREEN_NAME = "net.anei.cadpage.DonateActivty.SCREEN_NAME";

  private DonateScreenBaseEvent event;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String classname = getIntent().getStringExtra(EXTRA_SCREEN_NAME);
    event = DonateScreenEvent.getScreenEvent(classname);
    event.create(this);
  }


  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_OK) {
      setResult(RESULT_OK);
      finish();
    }
  }


  @Override
  protected Dialog onCreateDialog(int id) {
    if (!isFinishing()) return null;
    return event.createDialog(this, id);
  }


  /**
   * Create intent that can be used to launch this activity
   * @param activity Parent activity
   * @param message message to be displayed
   */
  public static void launchActivity(Activity activity, DonateScreenBaseEvent event) {
    Intent popup = new Intent(activity, DonateActivity.class);
    popup.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
    popup.putExtra(EXTRA_SCREEN_NAME, event.getClass().getName());
    activity.startActivityForResult(popup, 0);
  }
}
