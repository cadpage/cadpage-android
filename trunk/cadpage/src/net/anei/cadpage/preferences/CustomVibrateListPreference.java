package net.anei.cadpage.preferences;

import net.anei.cadpage.ManageNotification;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CustomVibrateListPreference extends ListPreference {
  private Context context;
  private String vibrate_pattern_custom;

  public CustomVibrateListPreference(Context c) {
    super(c);
    context = c;
  }

  public CustomVibrateListPreference(Context c, AttributeSet attrs) {
    super(c, attrs);
    context = c;
  }

  @Override
  protected void onDialogClosed(boolean positiveResult) {
    super.onDialogClosed(positiveResult);

    if (positiveResult) {
      getPrefs();
    }
  }

  private void getPrefs() {

    vibrate_pattern_custom = ManagePreferences.vibratePatternCustom();


    if (vibrate_pattern_custom == null) {
      vibrate_pattern_custom = context.getString(R.string.pref_vibrate_pattern_default);
    }
  }

  private void showDialog() {
    LayoutInflater inflater =
      (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View v = inflater.inflate(R.layout.vibratepatterndialog, null);

    final EditText et = (EditText) v.findViewById(R.id.CustomVibrateEditText);

    et.setText(vibrate_pattern_custom);

    new AlertDialog.Builder(context)
    .setIcon(android.R.drawable.ic_dialog_info)
    .setTitle(R.string.pref_vibrate_pattern_title)
    .setView(v)
    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int whichButton) {
        String new_pattern = et.getText().toString();

        if (ManageNotification.parseVibratePattern(et.getText().toString()) != null) {
          ManagePreferences.setVibratePatternCustom(new_pattern);

          Toast.makeText(context, context.getString(R.string.pref_vibrate_pattern_ok),
              Toast.LENGTH_LONG).show();

        } else {

          /*
           * No need to store anything if the contact pattern is invalid (just leave it
           * as the last good value).
           */
          /*
          if (contactId == null) { // Default notifications
            mPrefs.putString(
                R.string.pref_vibrate_pattern_custom_key,
                context.getString(R.string.pref_vibrate_pattern_default),
                SmsPopupDbAdapter.KEY_VIBRATE_PATTERN_CUSTOM);
          } else { // Contact specific notifications
            mPrefs.putString(
                R.string.c_pref_vibrate_pattern_custom_key,
                context.getString(R.string.pref_vibrate_pattern_default),
                SmsPopupDbAdapter.KEY_VIBRATE_PATTERN_CUSTOM);
          }
           */

          Toast.makeText(context, context.getString(R.string.pref_vibrate_pattern_bad),
              Toast.LENGTH_LONG).show();
        }
      }
    })
    .show();
  }
}
