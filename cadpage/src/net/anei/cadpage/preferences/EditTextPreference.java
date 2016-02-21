package net.anei.cadpage.preferences;

import android.content.Context;
import android.util.AttributeSet;

public class EditTextPreference extends android.preference.EditTextPreference {

  private String origSummary;
  private OnDialogClosedListener dialogClosedListener = null;

  public EditTextPreference(Context context) {
    super(context);
    origSummary = getSummary().toString().replace("%%", "%");
  }

  public EditTextPreference(Context context, AttributeSet attrs) {
    super(context, attrs);
    origSummary = getSummary().toString().replace("%%", "%");
  }
  
  public void setDialogClosedListener(OnDialogClosedListener dialogClosedListener) {
    this.dialogClosedListener = dialogClosedListener;
  }

  @Override
  protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
    super.onSetInitialValue(restoreValue, defaultValue);
    refreshSummary();
  }

  @Override
  protected void onDialogClosed(boolean positiveResult) {
    super.onDialogClosed(positiveResult);
    if (dialogClosedListener != null) dialogClosedListener.onDialogClosed(positiveResult); 
    if (positiveResult) refreshSummary();
  }

  @Override
  public void setText(String value) {
    super.setText(value);
    refreshSummary();
  }
  
  public void refreshSummary() {
    refreshSummary(getText());
  }

  public void refreshSummary(String newValue) {
    if (origSummary == null) origSummary = getSummary().toString().replace("%%", "%");
    if (origSummary != null) {
      setSummary(String.format(origSummary, newValue));
    }
  }
}
