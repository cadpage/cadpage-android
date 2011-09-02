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

public class CustomLEDPatternListPreference extends ListPreference {
  private Context context;
  private String flashLedPattern;
  private String flashLedPatternCustom;
  private int[] led_pattern;

  public CustomLEDPatternListPreference(Context c) {
    super(c);
    context = c;
  }

  public CustomLEDPatternListPreference(Context c, AttributeSet attrs) {
    super(c, attrs);
    context = c;
  }


  @Override
  protected void onDialogClosed(boolean positiveResult) {
    super.onDialogClosed(positiveResult);

    if (positiveResult) {
      getPrefs();
      if (context.getString(R.string.pref_custom_val).equals(flashLedPattern)) {
        showDialog();
      }
    }
  }

  private void getPrefs() {

    flashLedPattern = ManagePreferences.ledPattern();
    flashLedPatternCustom = ManagePreferences.ledPatternCustom();

    led_pattern = null;

    if (context.getString(R.string.pref_custom_val).equals(flashLedPattern)) {
      led_pattern = ManageNotification.parseLEDPattern(flashLedPatternCustom);
    } else {
      led_pattern = ManageNotification.parseLEDPattern(flashLedPattern);
    }

    if (led_pattern == null) {
      led_pattern = ManageNotification.parseLEDPattern(context.getString(R.string.pref_flashled_pattern_default));
    }
  }

  private void showDialog() {
    LayoutInflater inflater =
      (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View v = inflater.inflate(R.layout.ledpatterndialog, null);

    final EditText onEditText = (EditText) v.findViewById(R.id.LEDOnEditText);
    final EditText offEditText = (EditText) v.findViewById(R.id.LEDOffEditText);

    onEditText.setText(String.valueOf(led_pattern[0]));
    offEditText.setText(String.valueOf(led_pattern[1]));

    new AlertDialog.Builder(context)
    .setIcon(android.R.drawable.ic_dialog_info)
    .setTitle(R.string.pref_flashled_pattern_title)
    .setView(v)
    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int whichButton) {
        String stringPattern = onEditText.getText() + "," + offEditText.getText();

        if (ManageNotification.parseLEDPattern(stringPattern) != null) {
          ManagePreferences.setLedPatternCustom(stringPattern);
  
          Toast.makeText(context, context.getString(R.string.pref_flashled_pattern_ok),
              Toast.LENGTH_LONG).show();

        } else {

          Toast.makeText(context, context.getString(R.string.pref_flashled_pattern_bad),
              Toast.LENGTH_LONG).show();
        }
      }
    }).show();
  }
}