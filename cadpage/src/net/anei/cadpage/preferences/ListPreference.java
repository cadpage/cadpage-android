package net.anei.cadpage.preferences;

import android.content.Context;
import android.util.AttributeSet;

public class ListPreference extends android.preference.ListPreference {

  String origSummary;

  public ListPreference(Context context) {
    super(context);
    origSummary = getSummary().toString().replace("%%", "%");
  }

  public ListPreference(Context context, AttributeSet attrs) {
    super(context, attrs);
    origSummary = getSummary().toString().replace("%%", "%");
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

  @Override
  public void setValue(String value) {
    super.setValue(value);
    refreshSummary();
    
    OnPreferenceChangeListener listener = getOnPreferenceChangeListener();
    if (listener != null) listener.onPreferenceChange(this, value);
  }

  public void refreshSummary() {
    if (origSummary == null) origSummary = getSummary().toString().replace("%%", "%");
    if (origSummary != null) {
      setSummary(String.format(origSummary, getEntry()));
    }
  }
}
