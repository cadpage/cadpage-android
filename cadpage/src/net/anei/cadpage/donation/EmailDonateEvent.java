package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.EmailDeveloperActivity;
import net.anei.cadpage.R;

/**
 * This is the nice top level donation event that appears when user is on
 * the free rider donate list
 */
public class EmailDonateEvent extends DonateEvent {
  
  public EmailDonateEvent() {
    super(null, R.string.donate_email_title);
  }

  @Override
  protected void doEvent(Activity activity) {
    EmailDeveloperActivity.sendWrongUserEmail(activity);
    closeEvents(activity);
  }
  
  private static final EmailDonateEvent instance = new EmailDonateEvent();
  
  public static EmailDonateEvent instance() {
    return instance;
  }

}
