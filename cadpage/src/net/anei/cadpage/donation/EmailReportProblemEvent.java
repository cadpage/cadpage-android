package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.EmailDeveloperActivity;
import net.anei.cadpage.EmailDeveloperActivity.EmailType;
import net.anei.cadpage.R;
import net.anei.cadpage.SmsMmsMessage;

/**
 * Report Problem
 */
public class EmailReportProblemEvent extends DonateEvent {
  
  public EmailReportProblemEvent() {
    super(null, R.string.email_item_text);
  }

  @Override
  protected void doEvent(Activity activity, SmsMmsMessage msg) {
    EmailDeveloperActivity.sendEmailRequest(activity, EmailType.MESSAGE, true, msg.getMsgId(), false);
    closeEvents(activity);
  }
  
  private static final EmailReportProblemEvent instance = new EmailReportProblemEvent();
  
  public static EmailReportProblemEvent instance() {
    return instance;
  }
}
