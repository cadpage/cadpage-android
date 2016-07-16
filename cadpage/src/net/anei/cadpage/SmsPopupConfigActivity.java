package net.anei.cadpage;

import net.anei.cadpage.donation.DeveloperToolsManager;
import net.anei.cadpage.donation.DonationManager;
import net.anei.cadpage.donation.MainDonateEvent;
import net.anei.cadpage.parsers.ManageParsers;
import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.ParserList;
import net.anei.cadpage.parsers.ParserList.ParserCategory;
import net.anei.cadpage.parsers.ParserList.ParserEntry;
import net.anei.cadpage.parsers.SplitMsgOptions;
import net.anei.cadpage.preferences.DialogPreference;
import net.anei.cadpage.preferences.EditTextPreference;
import net.anei.cadpage.preferences.ExtendedCheckBoxPreference;
import net.anei.cadpage.preferences.LocationCheckBoxPreference;
import net.anei.cadpage.preferences.LocationListPreference;
import net.anei.cadpage.preferences.LocationManager;
import net.anei.cadpage.preferences.OnDataChangeListener;
import net.anei.cadpage.preferences.OnDialogClosedListener;
import net.anei.cadpage.vendors.VendorManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.view.KeyEvent;
import android.widget.BaseAdapter;

public class SmsPopupConfigActivity extends PreferenceActivity {
  
  private static final int REQ_SCANNER_CHANNEL = 1;
  
  private static final String EXTRA_INITIALIZE = "PreferenceActivity.INITIALIZE";
  
  private PermissionManager permMgr = new PermissionManager(this);
  
  private String parserFilter = "";
  private String parserDefCity = "";
  private String parserDefState = "";
  private CheckBoxPreference overrideFilterPref;
  private net.anei.cadpage.preferences.EditTextPreference filterPref;
  
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
    
    ManagePreferences.setPermissionManager(permMgr);
    
    // Build preference tree
    addPreferencesFromResource(R.xml.preferences);

    // Set preferences initialized flag
    ManagePreferences.setInitialized(true);
    
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
        
        if (!ManagePreferences.checkPermEnableMsgType((ListPreference)preference, (String)newValue)) return false;
        
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

    filterPref = (net.anei.cadpage.preferences.EditTextPreference)
        findPreference(getString(R.string.pref_filter_key));
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
          } catch (Exception ex) {
            
            if (! (ex instanceof ActivityNotFoundException)) Log.e(ex);
            
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
                  try {
                    SmsPopupConfigActivity.this.startActivity(intent);
                  } catch (ActivityNotFoundException ex) {
                    Log.e(ex);
                  }
                }
              })
              .setNegativeButton(R.string.donate_btn_no, null)
              .create().show();

          }
          return true;
        }
      });
    }
    
    // Location tracking preference needs location permission
    pref = findPreference(getString(R.string.pref_report_position_key));
    pref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (!ManagePreferences.checkReportPosition((ListPreference)preference, (String)newValue)) return false;
        return true;
      }
    });
    
    // mapping app preference only includes Waze if Waze is installed
    boolean wazeInstalled = false;
    PackageManager pkgMgr = getPackageManager();
    String pkgName = "com.waze";
    try {
      pkgMgr.getPackageInfo(pkgName, 0);
      wazeInstalled = true;
    } catch (PackageManager.NameNotFoundException ex2) {}

    ListPreference appMapPref = (ListPreference)findPreference(getString(R.string.pref_app_map_option_key));
    String oldVal = appMapPref.getValue();
    appMapPref.setEntryValues(wazeInstalled ? R.array.pref_waze_app_map_option_values : R.array.pref_app_map_option_values);
    appMapPref.setEntries(wazeInstalled ? R.array.pref_waze_app_map_option_entries : R.array.pref_app_map_option_entries);
    if (!wazeInstalled && oldVal.equals("Waze")) oldVal = "Google";
    appMapPref.setValue(oldVal);
    
    // Set up the response button preferences
    PreferenceScreen parent = (PreferenceScreen)findPreference(getString(R.string.pref_resp_button_config_key));
    setupResponseButtonConfig(parent, 1, R.string.pref_callback1_screen_key, R.string.pref_callback1_type_key, R.string.pref_callback1_title_key, R.string.pref_callback1_key);
    setupResponseButtonConfig(parent, 2, R.string.pref_callback2_screen_key, R.string.pref_callback2_type_key, R.string.pref_callback2_title_key, R.string.pref_callback2_key);
    setupResponseButtonConfig(parent, 3, R.string.pref_callback3_screen_key, R.string.pref_callback3_type_key, R.string.pref_callback3_title_key, R.string.pref_callback3_key);
    setupResponseButtonConfig(parent, 4, R.string.pref_callback4_screen_key, R.string.pref_callback4_type_key, R.string.pref_callback4_title_key, R.string.pref_callback4_key);
    setupResponseButtonConfig(parent, 5, R.string.pref_callback5_screen_key, R.string.pref_callback5_type_key, R.string.pref_callback5_title_key, R.string.pref_callback5_key);
    setupResponseButtonConfig(parent, 6, R.string.pref_callback6_screen_key, R.string.pref_callback6_type_key, R.string.pref_callback6_title_key, R.string.pref_callback6_key);
    
    // The No Show In Call preference requires the READ_PHONE_STATE permission
    pref = findPreference(getString(R.string.pref_noShowInCall_key));
    pref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        return ManagePreferences.checkNoShowInCall((CheckBoxPreference)preference, (Boolean)newValue);
      }
    });
    
    final CheckBoxPreference overrideSoundPref = (CheckBoxPreference)findPreference(getString(R.string.pref_notif_override_sound_key));
    overrideSoundPref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        return ManagePreferences.checkOverrideNotifySound((CheckBoxPreference) preference, (Boolean)newValue);
      }
    });
    
    ExtendedCheckBoxPreference notifyOverridePref = (ExtendedCheckBoxPreference)findPreference(getString(R.string.pref_notif_override_key));
    notifyOverridePref.setOnDataChangeListener(new OnDataChangeListener(){
      @Override
      public void onDataChange(Preference preference) {
        ManagePreferences.checkOverrideNotifySound(overrideSoundPref);
      }
    });

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
    if (DonationManager.instance().isFreeVersion()) {
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
  
  /**
   * Setup correlations between the different response button preferences
   * @param screenResId ID of response button screen preference
   * @param typeResId ID of response button type preference
   * @param descResId ID of response button description preference
   * @param codeResId ID of response button phone/code preference
   */
  private void setupResponseButtonConfig(final PreferenceScreen parent, final int button, 
                                         int screenResId, int typeResId, int descResId, int codeResId) {
    
    // Find all of the preferences
    final PreferenceScreen screenPref = (PreferenceScreen)findPreference(getString(screenResId));
    final ListPreference typePref = (ListPreference)findPreference(getString(typeResId));
    final EditTextPreference descPref = (EditTextPreference)findPreference(getString(descResId));
    final EditTextPreference codePref = (EditTextPreference)findPreference(getString(codeResId));
    
    // Lock screen summary to value of description preference
    screenPref.setSummary(descPref.getText());
    descPref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        screenPref.setSummary(newValue.toString());
        
        // Required to actually force display change :(
        ((BaseAdapter)parent.getRootAdapter()).notifyDataSetChanged();
        return true;
      }
    });
    
    // Code field is only enabled if response type is set to something
    codePref.setEnabled(typePref.getValue().length() > 0);
    typePref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object value) {
        
        // Check if we have appropriate permission
        if (!ManagePreferences.checkResponseType(button, (ListPreference)preference, value.toString())) return false; 
          
        codePref.setEnabled(value.toString().length() > 0);
        return true;
      }
    });
  }
  
  @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] granted) {
    ManagePreferences.onRequestPermissionsResult(requestCode, permissions, granted);
  }
  
  @Override
  protected void onDestroy() {
    MainDonateEvent.instance().setPreference(null, null);
    ManagePreferences.releasePermissionManager(permMgr);
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
      
      ManagePreferences.setScannerChannel(description);
      scannerPref.setSummary(description);
      ManagePreferences.setScannerIntent(scanIntent);
      return;
    }
    
    if (resultCode >= ManageBluetooth.BLUETOOTH_REQ) {
      if (ManageBluetooth.instance().onActivityResult(this, requestCode, resultCode)) return;
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
    }
    
    // If there is no parser filter, the override box is disabled but forced to true
    // the general alert box is enabled only if the user filter
    else {
      overrideFilterPref.setEnabled(false);
      overrideFilterPref.setChecked(true);
      filterPref.setEnabled(true);
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
    
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    activityActive = true; 

  }
  
  // If location code changes during this session, force a rebuild of
  // the call history data on the off chance that a general format message
  // can use the new location code.
  // Ditto if history screen text size changes
  private String oldLocation = null;
  private String oldTextSize =null;
  private boolean oldSplitBlank = false;
  private boolean oldSplitKeepLeadBreak = false;
  private boolean oldRevMsgOrder = false;
  private boolean oldMixedMsgOrder = false;
  
  
  @Override
  protected void onStart() {
    
    // Save the setting that might be important if they change
    oldLocation = ManagePreferences.location();
    oldTextSize = ManagePreferences.textSize();
    
    SplitMsgOptions options = ManagePreferences.getDefaultSplitMsgOptions();
    oldSplitBlank = options.splitBlankIns();
    oldSplitKeepLeadBreak = options.splitKeepLeadBreak();
    oldRevMsgOrder = options.revMsgOrder();
    oldMixedMsgOrder = options.mixedMsgOrder();
    
    // If this was an initialization call to initialize settings
    // finish it before it become visible
    
    Intent intent = getIntent();
    if (intent.getBooleanExtra(EXTRA_INITIALIZE, false)) finish();
    
    super.onStart();
  }
  
  @Override
  protected void onStop() {
    super.onStop();

    // If any of the split message options have changed, reparse any possibly affected calls
    SplitMsgOptions options = ManagePreferences.getDefaultSplitMsgOptions();
    boolean splitBlank = options.splitBlankIns();
    boolean splitKeepLeadBreak = options.splitKeepLeadBreak();
    boolean revMsgOrder = options.revMsgOrder();
    boolean mixedMsgOrder = options.mixedMsgOrder();
    int changeCode;
    if (revMsgOrder != oldRevMsgOrder || mixedMsgOrder != oldMixedMsgOrder) changeCode = 3;
    else if (splitBlank != oldSplitBlank) changeCode = 2; 
    else if (splitKeepLeadBreak != oldSplitKeepLeadBreak) changeCode = 1;
    else changeCode = 0;
    if (changeCode > 0) SmsMessageQueue.getInstance().splitOptionChange(changeCode);

    
    String location = ManagePreferences.location();
    if (!location.equals(oldLocation)) {
      SmsMessageQueue.getInstance().reparseGeneral();
    }
    
    String textSize = ManagePreferences.textSize();
    if (! textSize.equals(oldTextSize)) {
      SmsMessageQueue.getInstance().notifyDataChange();
    }
  }

  /**
   * Set up location menu tree
   * @param resId resource ID of the preference screen to be constructed
   * @param multi true if we are building a multi-location preference tree
   * false if we are building a normal single location preference tree
   */
  private void setupLocationMenu(int resId, boolean multi, LocationManager locMgr) {
    
    // Get the preference screen we will be building
    Resources res = getResources();
    PreferenceScreen main = (PreferenceScreen)findPreference(res.getString(resId));
    buildLocationMenu(ParserList.MASTER_LIST, main, multi, locMgr);
  }
 
  /**
   * Construct a preference screen corresponding to a configured parser category    
   * @param parserCategory parser category 
   * @param screen preference screen being set up
   * @param multi true if we are setting up a mutiple location selection menu
   * @param locMgr Location manager
   */
  private void buildLocationMenu(ParserCategory parserCategory, PreferenceScreen screen, boolean multi, LocationManager locMgr) {
    for (ParserEntry entry : parserCategory.getParserList()) {
      if (!entry.isCategory()) throw new RuntimeException("Top level parser entry " + entry.getParserName() + " must be a category");
      Preference pref = buildLocationItem(entry.getCategory(), screen, multi, locMgr);
      screen.addPreference(pref);
    }
  }

  /**
   * Construct a prefence item corresponding to a single parser entry 
   * @param category root preference category
   * @param parent parent preference screen
   * @param multi true if we are setting up multiple location selection menu
   * @param locMgr location manager
   * @return constructed preference
   */
  private Preference buildLocationItem(ParserCategory category, PreferenceScreen parent, boolean multi, LocationManager locMgr) {
    
    // Current rules are that category must contain only  subcategory or only parser entries.  See which this is
    String catName = category.getName();
    ParserEntry[] entries = category.getParserList();
    boolean subcat = false;
    boolean plist = false;
    for (ParserEntry entry : entries) {
      if (entry.isCategory()) subcat = true;
      else plist = true;
    }
    if (subcat && plist) throw new RuntimeException("Parser group " + catName + " mixes parser and category entries"); 
    if (!subcat && !plist) throw new RuntimeException("Parser group " + catName + " is empty");
    
    // If it only contains subcategories, build a new preference screen with them
    if (subcat) {
      PreferenceScreen sub = getPreferenceManager().createPreferenceScreen(this);
      sub.setTitle(catName);
      buildLocationMenu(category, sub, multi, locMgr);
      return sub;
    }
    
    // Otherwise we are handing a parser list
    // What we do next depends on whether this is a single or multiple selection menu
    
    // If we are doing multiple selections, create a new preference screen and fill it
    // a location checkbox for each parser entry
    if (multi) {
      PreferenceScreen sub = getPreferenceManager().createPreferenceScreen(this);
      sub.setTitle(catName);
      for (ParserEntry entry : entries) {
        sub.addPreference(
            new LocationCheckBoxPreference(this, entry.getParserName(), 
                                           stripStateAbbrv(entry.getLocName()), 
                                           locMgr)
        );
      }
      return sub;
    }
    
    // If we are doing single location selections, build a list preference
    // that can select from any of the parsers in this category
    LocationListPreference list = new LocationListPreference(this, locMgr, parent);
    list.setTitle(catName);
    list.setDialogTitle(catName);
    
    String[] values = new String[entries.length];
    String[] names = new String[entries.length];
    for (int ndx = 0; ndx < entries.length; ndx++) {
      ParserEntry entry = entries[ndx];
      values[ndx] = entry.getParserName();
      names[ndx] = stripStateAbbrv(entry.getLocName());
    }
    list.setEntryValues(values);
    list.setEntries(names);
    return list;
  }
  
  private static String stripStateAbbrv(String name) {
    int pt = name.indexOf(',');
    if (pt >= 0) name = name.substring(0,pt);
    return name;
  }

  // This is all supposed to work around a bug causing crashes for
  // java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState
  
  private boolean activityActive = false;
  
  protected void onPause() { 
     super.onPause(); 
     activityActive = false; 
  } 
  
  public boolean onKeyUp(int keyCode, KeyEvent event)  { 
     if (!activityActive) return false;
     return super.onKeyUp(keyCode, event);
  } 
  
  public boolean onKeyDown(int keyCode, KeyEvent event) { 
     if (!activityActive) return false;
     return super.onKeyDown(keyCode, event);
  }
 
  
  
  @Override
  protected void onSaveInstanceState(Bundle outState) {

    outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
    super.onSaveInstanceState(outState);
  }
  
  /**
   * Create and destroy a settings screen, which has the effect of initializing 
   * all settings to their default values 
   * @param activity current activity
   */
  public static void initializePreferences(Activity activity) {
    Intent intent = new Intent(activity, SmsPopupConfigActivity.class);
    intent.putExtra(EXTRA_INITIALIZE, true);
    activity.startActivity(intent);
  }
}