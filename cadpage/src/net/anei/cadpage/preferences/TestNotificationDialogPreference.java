package net.anei.cadpage.preferences;

import net.anei.cadpage.ManageNotification;
import net.anei.cadpage.R;
import net.anei.cadpage.SmsMmsMessage;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;

public class TestNotificationDialogPreference extends DialogPreference {
  private Context context;

  public TestNotificationDialogPreference(Context _context, AttributeSet attrs) {
    super(_context, attrs);
    context = _context;
  }

  public TestNotificationDialogPreference(Context _context, AttributeSet attrs, int defStyle) {
    super(_context, attrs, defStyle);
    context = _context;
  }

  @Override
  public void onDismiss(DialogInterface dialog) {
    super.onDismiss(dialog);
    ManageNotification.clear(context);
  }

  @Override
  protected View onCreateDialogView() {

    // Create a test SmsMmsMessage
    String testPhone = "123-456-7890";
 //   SmsPopupDbAdapter mDbAdapter = new SmsPopupDbAdapter(context);

  

    SmsMmsMessage message =
      new SmsMmsMessage(testPhone, "", context.getString(R.string.pref_notif_test_title),
          0, SmsMmsMessage.MESSAGE_TYPE_SMS);

    // Show notification
    ManageNotification.show(context, message);

    return super.onCreateDialogView();
  }

}
