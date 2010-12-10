package net.anei.cadpage.preferences;

import android.content.Context;
import android.util.AttributeSet;

public class EditTextPreference extends android.preference.EditTextPreference {

  CharSequence origSummary;

  public EditTextPreference(Context context) {
    super(context);
    origSummary = getSummary();
  }

  public EditTextPreference(Context context, AttributeSet attrs) {
    super(context, attrs);
    origSummary = getSummary();
  }

  @Override
  protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
    super.onSetInitialValue(restoreValue, defaultValue);
    refreshSummary();
  }

  @Override
  protected void onDialogClosed(boolean positiveResult) {
    super.onDialogClosed(positiveResult);
    if (positiveResult) {
      refreshSummary();
    }
  }

  public void refreshSummary() {
    if (origSummary == null) origSummary = getSummary();
    if (origSummary != null) {
      setSummary(String.format(origSummary.toString(), getText()));
    }
  }
}
