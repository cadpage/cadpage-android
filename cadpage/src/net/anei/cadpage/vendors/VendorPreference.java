package net.anei.cadpage.vendors;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.preference.Preference;

class VendorPreference extends CheckBoxPreference {
  
  private Vendor vendor;
  
  VendorPreference(Context context, Vendor vendor) {
    super(context);
    
    // Initialize preference
    this.vendor = vendor;
    setTitle(vendor.getTitleId());
    int summary = vendor.getSummaryId();
    if (summary > 0) setSummary(summary);
    setChecked(vendor.isEnabled());
    
    // Onchange listener that always returns false.  User cannot actually
    // change the preference setting directly
    setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
      }
    });
    
    setOnPreferenceClickListener(new OnPreferenceClickListener(){
      @Override
      public boolean onPreferenceClick(Preference preference) {
        VendorActivity.launchActivity(getContext(), VendorPreference.this.vendor);
        return true;
      }
    });
  }
}
