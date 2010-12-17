package net.anei.cadpage;

import com.paypal.android.MEP.CheckoutButton;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.PayPalPayment;
import com.paypal.android.MEP.PayPalReceiverDetails;

import net.anei.cadpage.parsers.SmsMsgParser;
import net.anei.cadpage.preferences.AppEnabledCheckBoxPreference;
import net.anei.cadpage.preferences.DialogPreference;
import net.anei.cadpage.preferences.EditTextPreference;
import net.anei.cadpage.preferences.LocationCheckBoxPreference;
import net.anei.cadpage.preferences.LocationListPreference;
import net.anei.cadpage.preferences.LocationManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SmsPopupConfigActivity extends PreferenceActivity {
  private static final int DIALOG_DONATE = Menu.FIRST;
  private Preference donateDialogPref = null;
  
  private String parserFilter = "";
  private CheckBoxPreference overrideFilterPref;
  private EditTextPreference filterPref;
  private CheckBoxPreference genAlertPref;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    addPreferencesFromResource(R.xml.preferences);

    // Set preferences initialized flag
    SharedPreferences.Editor editor = 
        PreferenceManager.getDefaultSharedPreferences(this).edit();
    editor.putBoolean(getString(R.string.pref_initialized_key), true);
    editor.commit();

    // Set the version number in the about dialog preference
    final DialogPreference aboutPref =
      (DialogPreference) findPreference(getString(R.string.pref_about_key));
    aboutPref.setDialogTitle(SmsPopupUtils.getNameVersion(this));
    aboutPref.setDialogLayoutResource(R.layout.about);
    
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
    filterPref = (EditTextPreference)findPreference(getString(R.string.pref_filter_key));
    filterPref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        String filter = (String)newValue;
        genAlertPref.setEnabled(filter.length() > 1 || parserFilter.length() > 0);
        return true;
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

    // Test message response
    Preference testmsgPref = findPreference(getString(R.string.pref_testmsg_key));
    testmsgPref.setOnPreferenceClickListener(new OnPreferenceClickListener(){
      @Override
      public boolean onPreferenceClick(Preference preference) {
        SmsReceiver.repeatLastPage(SmsPopupConfigActivity.this);
        return true;
      }});
    
    // Email developer response
    Preference emailPref = findPreference(getString(R.string.pref_email_key));
    emailPref.setOnPreferenceClickListener(new OnPreferenceClickListener(){
      @Override
      public boolean onPreferenceClick(Preference preference) {
        EmailDeveloperActivity.sendGeneralEmail(SmsPopupConfigActivity.this);
        return true;
      }});
    
    // Donate dialog preference
    donateDialogPref = findPreference(getString(R.string.pref_donate_key));
    if (donateDialogPref != null) {
      donateDialogPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
        public boolean onPreferenceClick(Preference preference) {
          SmsPopupConfigActivity.this.showDialog(DIALOG_DONATE);
          return true;
        }
      });
    }
  }

  /**
   * Make any necessary adjustments necessary
   * when the location preference is changed
   * @param location new location preference value
   * @param change true if location value has been changed
   */
  private void adjustLocationChange(String location, boolean change) {
    
    // Get the parser and see if it has a default filter
    // Save it in parserFilter so other preferences know what it is
    SmsMsgParser parser = ManageParsers.getInstance().getParser(location);
    parserFilter = parser.getFilter();
    
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
  }

  @Override
  protected void onResume() {
    super.onResume();

    SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(this);

    // Donate Dialog
    if (donateDialogPref != null) {
      boolean donated = myPrefs.getBoolean(this.getString(R.string.pref_donated_key), false);
      // boolean donated = true;
      if (donated) {
        PreferenceCategory otherPrefCategory =
          (PreferenceCategory) findPreference(getString(R.string.pref_other_key));
        otherPrefCategory.removePreference(donateDialogPref);
        donateDialogPref = null;
      }
    }

    /*
     * This is quite hacky - in case the app was enabled or disabled externally (by
     * ExternalEventReceiver) this will refresh the checkbox that is visible to the user
     */
    AppEnabledCheckBoxPreference mEnabledPreference =
      (AppEnabledCheckBoxPreference) findPreference(getString(R.string.pref_enabled_key));

    boolean enabled = myPrefs.getBoolean(getString(R.string.pref_enabled_key), true);
    mEnabledPreference.setChecked(enabled);
  }

  @Override
  protected Dialog onCreateDialog(int id) {
    switch (id) {

      case DIALOG_DONATE:
        LayoutInflater factory = getLayoutInflater();
        final View donateView = factory.inflate(R.layout.donate, null);

        PayPal ppObj = PayPal.initWithAppID(this, "APP-80W284485P519543T", PayPal.ENV_NONE);
        CheckoutButton launchPayPalButton = ppObj.getCheckoutButton(this, PayPal.BUTTON_278x43, CheckoutButton.TEXT_DONATE);
        
        //launchPayPalButton = (Button) donateView.findViewById(R.id.DonatePaypalButton);
        launchPayPalButton.setOnClickListener(new OnClickListener() {
          public void onClick(View v) {
           // Intent i = new Intent(Intent.ACTION_VIEW);
           // i.setData(SmsPopupUtils.DONATE_PAYPAL_URI);
           // SmsPopupConfigActivity.this.startActivity(i);
            
            PayPalPayment newPayment = new PayPalPayment();
            newPayment.setCurrencyType("USD");
            newPayment.setRecipient("support@cadpage.org");
            Intent checkoutIntent = PayPal.getInstance().checkout(newPayment, getBaseContext());
            checkoutIntent.putExtra(PayPalActivity.EXTRA_PAYMENT_INFO, newPayment);
            startActivityForResult(checkoutIntent, 1);
          }

          public void onActivityResults(int requestCode, int resultCode, Intent data) {
            switch(resultCode) {
            case Activity.RESULT_OK:
            break;
            case Activity.RESULT_CANCELED:
            break;
            case PayPalActivity.RESULT_FAILURE:
            }
          }
        });

        return new AlertDialog.Builder(this)
        .setIcon(R.drawable.ic_launcher)
        .setTitle(R.string.pref_donate_title)
        .setView(donateView)
        .setPositiveButton(android.R.string.ok, null)
        .create();
    }
    return super.onCreateDialog(id);
  }
  
  // If location code changes during this session, force a rebuild of
  // the call history data on the off chance that a general format message
  // can use the new location code.
  private String oldLocation = null;
  @Override
  protected void onStart() {
    oldLocation = ManagePreferences.location();
    super.onStart();
  }
  
  @Override
  protected void onStop() {
    super.onStop();
    String location = ManagePreferences.location();
    if (! location.equals(oldLocation)) {
      SmsMessageQueue.getInstance().notifyDataChange();
    }
  }
  

  /**
   * Set up location menu tree
   * @param resId resource ID of the preference screen to be constructd
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
      String stPrefix = (ndx < locValues.length ? locValues[ndx].substring(0,2) : "**");
      if (stCode == null || ! stCode.equals(stPrefix)) {
        if (stCode != null) {
          String stName = stateNames[stNdx++];
          if (! stName.startsWith(stCode)) {
            throw new RuntimeException("Found state " + stName + " while looking for " + stCode);
          }
          if (! multi) {
            LocationListPreference list = new LocationListPreference(this, locMgr);
            list.setTitle(stName.substring(3));
            int locCnt = ndx - startNdx;
            String[] values = new String[locCnt];
            String[] options = new String[locCnt];
            System.arraycopy(locValues, startNdx, values, 0, locCnt);
            System.arraycopy(locNames, startNdx, options, 0, locCnt);
            list.setEntryValues(values);
            list.setEntries(options);
          
            main.addPreference(list);
          } else {
            PreferenceScreen sub = getPreferenceManager().createPreferenceScreen(this);
            sub.setTitle(stName.substring(3));
            for (int ii = startNdx; ii<ndx; ii++) {
              sub.addPreference(
                  new LocationCheckBoxPreference(this, locValues[ii], 
                                                 locNames[ii], locMgr)
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

}