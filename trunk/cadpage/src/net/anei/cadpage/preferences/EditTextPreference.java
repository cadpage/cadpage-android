package net.anei.cadpage.preferences;

import android.content.Context;
import android.util.AttributeSet;

public class EditTextPreference extends android.preference.EditTextPreference {

  private CharSequence origSummary;
  private OnDialogClosedListener dialogClosedListener = null;

  public EditTextPreference(Context context) {
    super(context);
    origSummary = getSummary();
  }

  public EditTextPreference(Context context, AttributeSet attrs) {
    super(context, attrs);
    origSummary = getSummary();
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
  
  public void refreshSummary() {
    refreshSummary(getText());
  }

  public void refreshSummary(String newValue) {
    if (origSummary == null) origSummary = getSummary();
    if (origSummary != null) {
      setSummary(String.format(origSummary.toString(), newValue));
    }
  }
}
