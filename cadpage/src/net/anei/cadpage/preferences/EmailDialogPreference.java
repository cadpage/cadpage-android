package net.anei.cadpage.preferences;

import net.anei.cadpage.SmsPopupUtils;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.util.AttributeSet;

public class EmailDialogPreference extends DialogPreference {
  Context context;

  public EmailDialogPreference(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.context = context;
  }

  public EmailDialogPreference(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    this.context = context;
  }

  @Override
  public void onClick(DialogInterface dialog, int which) {
    super.onClick(dialog, which);
    SmsPopupUtils.launchEmailToIntent(context, "general comment", 
                                      which == DialogInterface.BUTTON_POSITIVE, null);
  }
}
