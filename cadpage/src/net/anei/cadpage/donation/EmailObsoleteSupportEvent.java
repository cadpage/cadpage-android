package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.EmailDeveloperActivity;
import net.anei.cadpage.EmailDeveloperActivity.EmailType;
import net.anei.cadpage.R;
import net.anei.cadpage.SmsMmsMessage;

/**
 * Report Problem
 */
public class EmailObsoleteSupportEvent extends DonateEvent {
  
  public EmailObsoleteSupportEvent() {
    super(null, R.string.donate_email_support_text);
  }

  @Override
  protected void doEvent(Activity activity, SmsMmsMessage msg) {
    EmailDeveloperActivity.sendEmailRequest(activity, EmailType.OLD_SUPPORT, false, 0, true);
    closeEvents(activity);
  }
  
  private static final EmailObsoleteSupportEvent instance = new EmailObsoleteSupportEvent();
  
  public static EmailObsoleteSupportEvent instance() {
    return instance;
  }
}
