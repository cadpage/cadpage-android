package net.anei.cadpage;

import net.anei.cadpage.donation.DeveloperToolsManager;
import net.anei.cadpage.donation.DonationManager;
import net.anei.cadpage.donation.MainDonateEvent;
import net.anei.cadpage.parsers.ManageParsers;
import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.preferences.DialogPreference;
import net.anei.cadpage.preferences.EditTextPreference;
import net.anei.cadpage.preferences.LocationCheckBoxPreference;
import net.anei.cadpage.preferences.LocationListPreference;
import net.anei.cadpage.preferences.LocationManager;
import net.anei.cadpage.preferences.OnDialogClosedListener;
import net.anei.cadpage.vendors.VendorManager;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;

public class SmsPopupConfigActivity extends PreferenceActivity {
  
  private static final int REQ_SCANNER_CHANNEL = 1;
  
  private String parserFilter = "";
  private String parserDefCity = "";
  private String parserDefState = "";
  private CheckBoxPreference overrideFilterPref;
  private net.anei.cadpage.preferences.EditTextPreference filterPref;
  private CheckBoxPreference genAlertPref;
  
  private CheckBoxPreference overrideDefaultPref;
  private EditTextPreference defCityPref;
  private EditTextPreference defStatePref;
  
  private Preference scannerPref;
  
  private String saveLocation;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    // Save location so we can tell when it changes
    saveLocation = ManagePreferences.location();
    
    // Build preference tree
    addPreferencesFromResource(R.xml.preferences);

    // Set preferences initialized flag
    SharedPreferences.Editor editor = 
        PreferenceManager.getDefaultSharedPreferences(this).edit();
    editor.putBoolean(getString(R.string.pref_initialized_key), true);
    editor.commit();
    
    // Set up the two enable components preferences
    Preference pref = findPreference(getString(R.string.pref_enabled_key));
    pref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        boolean enabled = (Boolean)newValue;
        String enableStr = (enabled ? ManagePreferences.enableMsgType() : "");
        SmsPopupUtils.enableSMSPopup(SmsPopupConfigActivity.this, enableStr);
        CadPageWidget.update(SmsPopupConfigActivity.this);
        return true;
      }
    });
    pref = findPreference(getString(R.string.pref_enable_msg_type_key));
    pref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        SmsPopupUtils.enableSMSPopup(SmsPopupConfigActivity.this, (String)newValue);
        return true;
      }
    });
    
    // Two other preferences should update the widget display
    pref = findPreference(getString(R.string.pref_notif_enabled_key));
    pref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        CadPageWidget.update(SmsPopupConfigActivity.this);
        return true;
      }
    });
    pref = findPreference(getString(R.string.pref_popup_enabled_key));
    pref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        CadPageWidget.update(SmsPopupConfigActivity.this);
        return true;
      }
    });

    // Set the version number in the about dialog preference
    final DialogPreference aboutPref =
      (DialogPreference) findPreference(getString(R.string.pref_about_key));
    aboutPref.setDialogTitle(CadPageApplication.getNameVersion());
    aboutPref.setDialogLayoutResource(R.layout.about);
    
    // Set up the payment status tracking screens
    Preference donate = (Preference)findPreference(getString(R.string.pref_payment_status_key));
    MainDonateEvent.instance().setPreference(this, donate);
    
    // Set up the two location preference screens
    Preference descPreference = findPreference(getString(R.string.pref_loc_desc_key));
    LocationManager locMgr = new LocationManager(this, descPreference);
    setupLocationMenu(R.string.pref_location_tree_key, false, locMgr);
    setupLocationMenu(R.string.pref_location_mtree_key, true, locMgr);
    locMgr.updateDisplay();
    
    // The location, filter override checkbox, and filter edit box have a complex
    // relationship.  The override checkbox is enabled only when the location parser
    // has a default parser to override.  If it doesn't then it is disabled by forced
    // to true.  The filter is enabled when the override box is checked, whether it
    // is enabled or not.  We have to do this ourselves because the Android dependency
    // logic considers the value to be false if it isn't enabled.
    
    // On top of all that, the general alert box is enabled only if the current
    // parser has a default filter OR a user filter has been specified

    genAlertPref = (CheckBoxPreference)
        findPreference(getString(R.string.pref_gen_alert_key));
    filterPref = (net.anei.cadpage.preferences.EditTextPreference)
        findPreference(getString(R.string.pref_filter_key));
    filterPref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        String filter = (String)newValue;
        genAlertPref.setEnabled(filter.length() > 1 || parserFilter.length() > 0);
        return true;
      }
    });
    filterPref.setDialogClosedListener(new OnDialogClosedListener(){
      @Override
      public void onDialogClosed(boolean positiveResult) {
        if (positiveResult) {
          if ("General".equals(saveLocation)) {
            DonationManager.instance().reset();
            MainDonateEvent.instance().refreshStatus();
          }
        }
      }
    });

    overrideFilterPref = (CheckBoxPreference)
        findPreference(getString(R.string.pref_override_filter_key));
    filterPref.setEnabled(overrideFilterPref.isChecked());
    overrideFilterPref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        filterPref.setEnabled((Boolean)newValue);
        return true;
      }
    });
    
    adjustLocationChange(ManagePreferences.location(), false);
    locMgr.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        adjustLocationChange((String)newValue, true);
        return true;
      }
    });

    // Have to play some games with the override default settings
    // If the override defaults is turned on, enable the default city and state items
    // If it is turned off, force the default city and state to the current parser
    // defaults and disable them.
    overrideDefaultPref = (CheckBoxPreference)
        findPreference(getString(R.string.pref_override_default_key));
    defCityPref = (EditTextPreference) 
        findPreference(getString(R.string.pref_defcity_key));
    defStatePref = (EditTextPreference)
        findPreference(getString(R.string.pref_defstate_key));
    
    overrideDefaultPref = (CheckBoxPreference)
        findPreference(getString(R.string.pref_override_default_key));
    overrideDefaultPref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        boolean value = ((Boolean)newValue).booleanValue();
        if (! value) {
          defCityPref.setText(parserDefCity);
          defCityPref.refreshSummary();
          defStatePref.setText(parserDefState);
          defStatePref.refreshSummary();
        }
        defCityPref.setEnabled(value);
        defStatePref.setEnabled(value);
        return true;
      }});
    
    // Make an initial call to our preference change listener to set up the
    // correct default summary displays
    overrideDefaultPref.getOnPreferenceChangeListener().
        onPreferenceChange(overrideDefaultPref, ManagePreferences.overrideDefaults());
    
    // Set up Scanner channel selection preference
    scannerPref = findPreference(getString(R.string.pref_scanner_channel_key));
    if (scannerPref != null) {
      String channel = ManagePreferences.scannerChannel();
      scannerPref.setSummary(channel);
      scannerPref.setOnPreferenceClickListener(new OnPreferenceClickListener(){
        @Override
        public boolean onPreferenceClick(Preference pref) {
          
          // When clicked, ask the scanner app to select a favorite channel
          Intent intent = new Intent("com.scannerradio.intent.action.ACTION_PICK");
          try {
            startActivityForResult(intent, REQ_SCANNER_CHANNEL);
          } catch (ActivityNotFoundException ex) {
            
            // Scanner radio either isn't installed, or isn't responding to the ACTION_PICK
            // request.  Check the package manager to which, if any, are currently installed
            PackageManager pkgMgr = getPackageManager();
            String pkgName = "com.scannerradio_pro";
            boolean installed = false;
            try {
              pkgMgr.getPackageInfo(pkgName, 0);
              installed = true;
            } catch (PackageManager.NameNotFoundException ex2) {}
            if (! installed) {
              pkgName = "com.scannerradio";
              try {
                pkgMgr.getPackageInfo(pkgName, 0);
                installed = true;
              } catch (PackageManager.NameNotFoundException ex2) {}
            }
            
            // OK, show a dialog box asking if they want to install Scanner Radio
            final String pkgName2 = pkgName;
            new AlertDialog.Builder(SmsPopupConfigActivity.this)
              .setMessage(installed ? R.string.scanner_not_current : R.string.scanner_not_installed)
              .setPositiveButton(R.string.donate_btn_yes, new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + pkgName2));
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  SmsPopupConfigActivity.this.startActivity(intent);
                }
              })
              .setNegativeButton(R.string.donate_btn_no, null)
              .create().show();

          }
          return true;
        }
      });
    }
    
    // Email developer response
    Preference emailPref = findPreference(getString(R.string.pref_email_key));
    emailPref.setOnPreferenceClickListener(new OnPreferenceClickListener(){
      @Override
      public boolean onPreferenceClick(Preference preference) {
        EmailDeveloperActivity.sendGeneralEmail(SmsPopupConfigActivity.this);
        return true;
      }});
    
    // Set up C2DM vendor preference screen
    PreferenceScreen vendorPref = (PreferenceScreen)findPreference(getString(R.string.pref_direct_paging_key));
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.FROYO ||
        DonationManager.instance().isFreeVersion()) {
      vendorPref.setEnabled(false);
    } else {
      VendorManager.instance().setupPreference(this, vendorPref);
    }
    
    // If free version, switch release notes text to free release notes text
    if (DonationManager.instance().isFreeVersion()) {
      DialogPreference dlg = (DialogPreference)findPreference(getString(R.string.pref_releasenotes_key));
      dlg.setDialogMessage(R.string.free_release_text);
    }
    // Add developer dialog preference if appropriate
    DeveloperToolsManager.instance().addPreference(this, getPreferenceScreen());
  }

  @Override
  protected void onDestroy() {
    MainDonateEvent.instance().setPreference(null, null);
    super.onDestroy();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == REQ_SCANNER_CHANNEL) {
      if (resultCode != RESULT_OK || data == null) return;
      Log.v("onActivityResult()");
      ContentQuery.dumpIntent(data);
      String description = data.getStringExtra("description");
      Intent scanIntent = data.getParcelableExtra("playIntent");
      if (description == null || scanIntent == null) return;
      ContentQuery.dumpIntent(scanIntent);
      String action = scanIntent.getAction();
      int node = scanIntent.getIntExtra("node", -1);
      if (action == null || node < 0) return;
      
      ManagePreferences.setScannerChannel(description);
      scannerPref.setSummary(description);
      ManagePreferences.setScannerChannelAppNode(action + ':' + node);
      return;
    }
    super.onActivityResult(requestCode, resultCode, data);
  }
  


  /**
   * Make any necessary adjustments necessary
   * when the location preference is changed
   * @param location new location preference value
   * @param change true if location value has been changed
   */
  private void adjustLocationChange(String location, boolean change) {

    // If location changes, recalculate the donation status
    if (!location.equals(saveLocation)) {
      saveLocation = location;
      DonationManager.instance().reset();
      MainDonateEvent.instance().refreshStatus();
    }
 
    // Get the parser and see if it has a default filter
    // Save it in parserFilter so other preferences know what it is
    MsgParser parser = ManageParsers.getInstance().getParser(location);
    parserFilter = parser.getFilter();
    parserDefCity = parser.getDefaultCity();
    parserDefState = parser.getDefaultState();
    
    // If the parser has a filter, enable the override checkbox, set its value to true
    // And insert the default filter value in the summary off message
    // And unilaterally enable the general alert box
    if (parserFilter.length() > 0) {
      overrideFilterPref.setEnabled(true);
      if (change) overrideFilterPref.setChecked(false);
      overrideFilterPref.setSummaryOff(getString(R.string.pref_override_filter_summaryoff, parserFilter));
      filterPref.setEnabled(overrideFilterPref.isChecked());
      genAlertPref.setEnabled(true);
    }
    
    // If there is no parser filter, the override box is disabled but forced to true
    // the general alert box is enabled only if the user filter
    else {
      overrideFilterPref.setEnabled(false);
      overrideFilterPref.setChecked(true);
      filterPref.setEnabled(true);
      String filter = filterPref.getText();
      genAlertPref.setEnabled(filter.length() > 1);
    }
    
    // Any time the location parser changes, reset the override default loc setting
    // OK, its a little more complicated than that.  If the override default setting
    // is on, we can just turn it off and let the onPreferenceChange listener take
    // care of things.  If it is already off, we have to call the onPreferenceChange
    // listener ourselves so it will update the propert summary displays
    // If that isn't complicated enough, the overrideDefaultPref setting won't
    // be initialized the first time we are called, but that first call has the
    // change parameter set to false, so this logic gets skipped.
    if (change) {
      if (overrideDefaultPref.isChecked()) {
        overrideDefaultPref.setChecked(false);
      } else {
        overrideDefaultPref.getOnPreferenceChangeListener().onPreferenceChange(overrideDefaultPref, false);
      }
    }
  }

  @Override
  protected void onResume() {
    super.onResume();

    SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(this);

    /*
     * This is quite hacky - in case the app was enabled or disabled externally (by
     * ExternalEventReceiver) this will refresh the checkbox that is visible to the user
     */
    CheckBoxPreference mEnabledPreference =
      (CheckBoxPreference) findPreference(getString(R.string.pref_enabled_key));

    boolean enabled = myPrefs.getBoolean(getString(R.string.pref_enabled_key), true);
    mEnabledPreference.setChecked(enabled);
  }
  
  // If location code changes during this session, force a rebuild of
  // the call history data on the off chance that a general format message
  // can use the new location code.
  // Ditto if history screen text size changes
  private String oldLocation = null;
  private String oldTextSize =null;
  private boolean oldSplitBlank = false;
  
  
  @Override
  protected void onStart() {
    
    C2DMReceiver.registerActivity(this);
    
    oldLocation = ManagePreferences.location();
    oldTextSize = ManagePreferences.textSize();
    oldSplitBlank = ManagePreferences.splitBlankIns();
    super.onStart();
  }
  
  @Override
  protected void onStop() {
    super.onStop();
    String location = ManagePreferences.location();
    String textSize = ManagePreferences.textSize();
    boolean splitBlank = ManagePreferences.splitBlankIns();
    if (splitBlank != oldSplitBlank) SmsMessageQueue.getInstance().splitDelimChange();
    if (!location.equals(oldLocation) || ! textSize.equals(oldTextSize)) {
      SmsMessageQueue.getInstance().notifyDataChange();
    }
    
    C2DMReceiver.unregisterActivity(this);
  }
  
  /**
   * Set up location menu tree
   * @param resId resource ID of the preference screen to be constructed
   * @param multi true if we are building a multi-location preference tree
   * false if we are building a normal single location preference tree
   */
  private void setupLocationMenu(int resId, boolean multi, LocationManager locMgr) {
    
    // Get a list of all of the location codes and state names.
    Resources res = getResources();
    String[] stateNames = res.getStringArray(R.array.pref_state_names);
    String[] locValues = res.getStringArray(R.array.pref_location_values);
    String[] locNames = res.getStringArray(R.array.pref_location_options);
    
    // Get the preference screen we will be building
    PreferenceScreen main = (PreferenceScreen)findPreference(res.getString(resId));
    int stNdx = 0;
    String stCode = null;
    int startNdx = -1;
    for (int ndx = 0; ndx <= locValues.length; ndx++) {
      String locValue = (ndx < locValues.length ? locValues[ndx] : "******");
      int len = 2;
      if (locValue.startsWith("Z")) {
        len++;
        if (locValue.startsWith("ZCA")) len += 2;
      }
      String stPrefix = locValue.substring(0,len);
      if (stPrefix.equals("St")) stPrefix = "Ge";  // Standard parsers go in General parser group
      if (stCode == null || ! stCode.equals(stPrefix)) {
        if (stCode != null) {
          String stName = stateNames[stNdx++];
          if (! stName.startsWith(stCode)) {
            throw new RuntimeException("Found state " + stName + " while looking for " + stCode);
          }
          if (! multi) {
            LocationListPreference list = new LocationListPreference(this, locMgr, main);
            int pt = stName.indexOf(' ');
            String state = stName.substring(pt+1);
            list.setTitle(state);
            list.setDialogTitle(state);
            int locCnt = ndx - startNdx;
            String[] values = new String[locCnt];
            String[] options = new String[locCnt];
            System.arraycopy(locValues, startNdx, values, 0, locCnt);
            System.arraycopy(locNames, startNdx, options, 0, locCnt);
            for (int ii = 0; ii<locCnt; ii++) {
              options[ii] = stripStateAbbrv(options[ii]);
            }
            list.setEntryValues(values);
            list.setEntries(options);
          
            main.addPreference(list);
          } else {
            PreferenceScreen sub = getPreferenceManager().createPreferenceScreen(this);
            sub.setTitle(stName.substring(3));
            for (int ii = startNdx; ii<ndx; ii++) {
              sub.addPreference(
                  new LocationCheckBoxPreference(this, locValues[ii], 
                                                 stripStateAbbrv(locNames[ii]), 
                                                 locMgr)
              );
            }
            
            main.addPreference(sub);
          }
        }
        if (ndx >= locValues.length) break;

        startNdx = ndx;
        stCode = stPrefix;
      }
    }
  }
  
  private static String stripStateAbbrv(String name) {
    int pt = name.indexOf(',');
    if (pt >= 0) name = name.substring(0,pt);
    return name;
  }

  // This is supposed to work around a bug causing crashes for
  // java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState
  @Override
  protected void onSaveInstanceState(Bundle outState) {
    outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
    super.onSaveInstanceState(outState);
  }

}