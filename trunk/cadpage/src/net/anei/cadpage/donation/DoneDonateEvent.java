package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.R;

/**
 * Base event that displays a "Done" button, and closes the donation menu 
 * tree when pressed
 */
public class DoneDonateEvent extends DonateEvent {
  
  public DoneDonateEvent() {
    super(null, R.string.donate_btn_done);
  }

  @Override
  protected void doEvent(Activity activity) {
    activity.setResult(Activity.RESULT_OK);
    activity.finish();
  }
  
  private static final DoneDonateEvent instance = new DoneDonateEvent();
  
  public static DoneDonateEvent instance() {
    return instance;
  }

}
