package net.anei.cadpage.preferences;


import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;

public class ExtendedCheckBoxPreference extends CheckBoxPreference {
  
  OnDataChangeListener listener = null;

  public ExtendedCheckBoxPreference(Context c) {
    super(c);
  }

  public ExtendedCheckBoxPreference(Context c, AttributeSet attrs) {
    super(c, attrs);
  }

  public ExtendedCheckBoxPreference(Context c, AttributeSet attrs, int defStyle) {
    super(c, attrs, defStyle);
  }
  
  public void setOnDataChangeListener(net.anei.cadpage.preferences.OnDataChangeListener onDataChangeListener) {
    this.listener = onDataChangeListener;
  }

  @Override
  protected void notifyChanged() {
    super.notifyChanged();
    if (listener != null) listener.onDataChange(this);
  }
}
