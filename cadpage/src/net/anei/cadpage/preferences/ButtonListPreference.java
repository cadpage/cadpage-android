package net.anei.cadpage.preferences;

import net.anei.cadpage.R;
import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;

public class ButtonListPreference extends ListPreference {

  private Context mContext;

  public ButtonListPreference(Context context) {
    super(context);
    mContext = context;
  }

  public ButtonListPreference(Context context, AttributeSet attrs) {
    super(context, attrs);
    mContext = context;
  }

  @Override
  protected void onDialogClosed(boolean positiveResult) {
    super.onDialogClosed(positiveResult);
    if (positiveResult) {
      refreshSummary();
    }
  }

  public void refreshSummary() {
    setSummary(mContext.getString(R.string.pref_button_summary, getEntry()));
  }
}
