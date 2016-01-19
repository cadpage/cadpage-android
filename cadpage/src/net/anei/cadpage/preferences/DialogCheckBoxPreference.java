package net.anei.cadpage.preferences;


import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;

public class DialogCheckBoxPreference extends CheckBoxPreference {
  Context context;

  public DialogCheckBoxPreference(Context c) {
    super(c);
    context = c;
  }

  public DialogCheckBoxPreference(Context c, AttributeSet attrs) {
    super(c, attrs);
    context = c;
  }

  public DialogCheckBoxPreference(Context c, AttributeSet attrs, int defStyle) {
    super(c, attrs, defStyle);
    context = c;
  }

  @Override
  protected void onClick() {
    super.onClick();
  }
}
