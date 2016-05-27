package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.EmailDeveloperActivity;
import net.anei.cadpage.R;

/**
 * Generate an email to the developers
 */
public class EmailInactiveSponsorEvent extends DonateEvent {
  
  public EmailInactiveSponsorEvent() {
    super(null, R.string.donate_email_title);
  }

  @Override
  protected void doEvent(Activity activity) {
    EmailDeveloperActivity.sendInactiveSponsorEmail(activity);
    closeEvents(activity);
  }
  
  private static final EmailInactiveSponsorEvent instance = new EmailInactiveSponsorEvent();
  
  public static EmailInactiveSponsorEvent instance() {
    return instance;
  }

}
