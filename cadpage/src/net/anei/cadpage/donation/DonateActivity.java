package net.anei.cadpage.donation;

import net.anei.cadpage.Safe40Activity;
import net.anei.cadpage.SmsMessageQueue;
import net.anei.cadpage.SmsMmsMessage;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class DonateActivity extends Safe40Activity {
  
  private static final String EXTRA_SCREEN_NAME = "net.anei.cadpage.DonateActivty.SCREEN_NAME";
  private static final String EXTRA_MSG_ID =      "net.anei.cadpage.DonateActivity.MSG_ID";

  private DonateScreenBaseEvent event;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String classname = getIntent().getStringExtra(EXTRA_SCREEN_NAME);
    event = DonateScreenEvent.getScreenEvent(classname);
    int msgId = getIntent().getIntExtra(EXTRA_MSG_ID, -1);
    SmsMmsMessage msg = msgId<0 ? null : SmsMessageQueue.getInstance().getMessage(msgId);
    event.create(this, msg);
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
    if (isFinishing()) return null;
    return event.createDialog(this, id);
  }


  /**
   * Create intent that can be used to launch this activity
   * @param context current context
   * @param event event to to displayed
   * @param msg message associated with this event
   */
  public static void launchActivity(Context context, DonateScreenBaseEvent event, SmsMmsMessage msg) {
    Intent popup = new Intent(context, DonateActivity.class);
    popup.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
    popup.putExtra(EXTRA_SCREEN_NAME, event.getClass().getName());
    if (msg != null) popup.putExtra(EXTRA_MSG_ID, msg.getMsgId());
    if (context instanceof Activity) ((Activity)context).startActivityForResult(popup, 0);
    else context.startActivity(popup);
  }
}
