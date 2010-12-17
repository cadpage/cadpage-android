package net.anei.cadpage.preferences;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.preference.ListPreference;

public class LocationListPreference extends ListPreference {
  
  private LocationManager locMgr;

  public LocationListPreference(Context context, LocationManager locMgr) {
    super(context);
    this.locMgr = locMgr;
  }

  @Override
  protected void onPrepareDialogBuilder(Builder builder) {
    
    setValue(locMgr.getLocSetting());
    super.onPrepareDialogBuilder(builder);
  }

  @Override
  protected void onDialogClosed(boolean positiveResult) {
    super.onDialogClosed(positiveResult);
    if (positiveResult) locMgr.setNewLocation(getValue(), getEntry().toString());
  }
}
