package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.EmailDeveloperActivity;
import net.anei.cadpage.R;

/**
 * Generate an email to the developers
 */
public class EmailSobStoryEvent extends DonateEvent {
  
  public EmailSobStoryEvent() {
    super(null, R.string.donate_email_title);
  }

  @Override
  protected void doEvent(Activity activity) {
    EmailDeveloperActivity.sendSobStoryEmail(activity);
    closeEvents(activity);
  }
  
  private static final EmailSobStoryEvent instance = new EmailSobStoryEvent();
  
  public static EmailSobStoryEvent instance() {
    return instance;
  }
}
