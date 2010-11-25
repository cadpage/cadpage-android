package net.anei.cadpage;

import java.io.File;

import net.anei.cadpage.preferences.AppEnabledCheckBoxPreference;
import net.anei.cadpage.preferences.DialogPreference;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.Preference.OnPreferenceClickListener;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SmsPopupConfigActivity extends PreferenceActivity {
  private static final int DIALOG_DONATE = Menu.FIRST;
  private Preference donateDialogPref = null;

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

    // Split long messages preference (for some CDMA carriers like Verizon)
    CheckBoxPreference splitLongMessagesPref =
      (CheckBoxPreference) findPreference(getString(R.string.pref_split_message_key));

    // This pref is only shown for CDMA phones
    if (splitLongMessagesPref != null) {
      TelephonyManager mTM = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
      if (mTM.getPhoneType() != TelephonyManager.PHONE_TYPE_CDMA) {
        PreferenceCategory quickreplyPrefCategory =
          (PreferenceCategory) findPreference(getString(R.string.pref_quickreply_cat_key));
        quickreplyPrefCategory.removePreference(splitLongMessagesPref);
        splitLongMessagesPref = null;
      }
    }

    // Opening and closing the database will trigger the update or create
    // TODO: this should be done on a separate thread to prevent "not responding" messages
    SmsPopupDbAdapter mDbAdapter = new SmsPopupDbAdapter(this);
    mDbAdapter.open(true); // Open database read-only
    mDbAdapter.close();

    installNotification();
    // Eula.show(this);

    //    for (int i=0; i<1000; i++) {
    //      new SmsMessageSender(this, new String[] {"12345"}, "message " + i, 10).sendMessage();
    //    }
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

       
        Button donatePaypalButton = (Button) donateView.findViewById(R.id.DonatePaypalButton);
        donatePaypalButton.setOnClickListener(new OnClickListener() {
          public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(SmsPopupUtils.DONATE_PAYPAL_URI);
            SmsPopupConfigActivity.this.startActivity(i);
          }
        });

        return new AlertDialog.Builder(this)
        .setIcon(R.drawable.cadpage_icon)
        .setTitle(R.string.pref_donate_title)
        .setView(donateView)
        .setPositiveButton(android.R.string.ok, null)
        .create();
    }
    return super.onCreateDialog(id);
  }
  
  // If location code changes durring this session, force a rebuild of
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

  private void installNotification() {
		File fAlert = new File("/sdcard/media/audio/notifications/generalquarter.wav");
		if (fAlert.exists()){
			if (Log.DEBUG) {Log.v("Notification File Already exists. Not Installing");}
		} else {
			if (Log.DEBUG) {Log.v("Installing Notofication.");}
			utils myutils = new utils();
				myutils.saveas(this,R.raw.generalquarter);

			 
		}
	}

}