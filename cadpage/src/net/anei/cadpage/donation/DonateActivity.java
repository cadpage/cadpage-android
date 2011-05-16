package net.anei.cadpage.donation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class DonateActivity extends Activity {
  
  private static final String EXTRA_SCREEN_NAME = "net.anei.cadpage.DonateActivty.SCREEN_NAME";

  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String classname = getIntent().getStringExtra(EXTRA_SCREEN_NAME);
    DonateScreenEvent event = DonateScreenEvent.getScreenEvent(classname);
    event.create(this);
  }


  /**
   * Create intent that can be used to launch this activity
   * @param context context
   * @param message message to be displayed
   * @return
   */
  public static void launchActivity(Context context, DonateScreenEvent event) {
    Intent popup = new Intent(context, DonateActivity.class);
    popup.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
    popup.putExtra(EXTRA_SCREEN_NAME, event.getClass().getName());
    context.startActivity(popup);
  }
}
