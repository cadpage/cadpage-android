package net.anei.cadpage;

import java.util.regex.Pattern;

import net.anei.cadpage.donation.DonationManager;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.telephony.SmsMessage;

public class SmsPopupUtils {

  public static final Pattern NAME_ADDR_EMAIL_PATTERN =
    Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");

  public static final Pattern QUOTED_STRING_PATTERN =
    Pattern.compile("\\s*\"([^\"]*)\"\\s*");

  /**
   * Read the PDUs out of an {@link #SMS_RECEIVED_ACTION} or a
   * {@link #DATA_SMS_RECEIVED_ACTION} intent.
   * 
   * @param intent
   *           the intent to read from
   * @return an array of SmsMessages for the PDUs
   */
  public static final SmsMessage[] getMessagesFromIntent(Intent intent) {
    Object[] messages = (Object[]) intent.getSerializableExtra("pdus");
    if (messages == null) {
      return null;
    }
    if (messages.length == 0) {
      return null;
    }

    byte[][] pduObjs = new byte[messages.length][];

    for (int i = 0; i < messages.length; i++) {
      pduObjs[i] = (byte[]) messages[i];
    }
    byte[][] pdus = new byte[pduObjs.length][];
    int pduCount = pdus.length;
    SmsMessage[] msgs = new SmsMessage[pduCount];
    for (int i = 0; i < pduCount; i++) {
      pdus[i] = pduObjs[i];
      msgs[i] = SmsMessage.createFromPdu(pdus[i]);
    }
    return msgs;
  }

  /**
   * Enables or disables the main SMS receiver
   */
  public static void enableSMSPopup(Context context, String enable) {
    enableComponent(context, SmsReceiver.class, enable.contains("S"));
    enableComponent(context, PushReceiver.class, enable.contains("M"));
  }

  private static void enableComponent(Context context, Class<?> cls, boolean enable) {
    PackageManager pm = context.getPackageManager();
    ComponentName cn = new ComponentName(context, cls);

    // Update preference so it reflects in the preference activity
    SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    SharedPreferences.Editor settings = myPrefs.edit();
    settings.commit();

    if (enable) {
      pm.setComponentEnabledSetting(cn,
          PackageManager.COMPONENT_ENABLED_STATE_DEFAULT,
          PackageManager.DONT_KILL_APP);

    } else {
      pm.setComponentEnabledSetting(cn,
          PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
          PackageManager.DONT_KILL_APP);
    }
  }

  /**
   * Fetch the current device Android OS platform number.
   * 
   * TODO: once Cupcake support is no longer needed the system var
   * android.os.Build.VERSION.SDK_INT can be used instead.
   * 
   * @return SDK version number
   */
  public static int getSDKVersionNumber() {
    int version_sdk;
    try {
      version_sdk = Integer.valueOf(android.os.Build.VERSION.SDK);
    } catch (NumberFormatException e){
      version_sdk = 0;
    }
    return version_sdk;
  }

  /**
   * Determine if we have Internet connectivity
   * @param context current context
   * @return true if Internet connectivity is established
   */
  public static boolean haveNet(Context context){

    // If configured to always map request, return true
    char checkNetwork = ManagePreferences.mapNetworkChk().charAt(0);
    if (checkNetwork == 'A') return true;

    // Otherwise, check to see if we have connectivity
    // If we don't return false
    ConnectivityManager mgr = ((ConnectivityManager) 
        context.getSystemService(Context.CONNECTIVITY_SERVICE));
    NetworkInfo info = mgr.getActiveNetworkInfo();
    if (info == null || !info.isConnected()) {
      showNetworkFailure(context, R.string.network_err_not_connected);
      return false;
    }
    
    // If we don't care about the roaming status, return true;
    if (checkNetwork == 'R') return true;
    
    // Otherwise return true if we are not currently roaming
    if (info.isRoaming()) {
      showNetworkFailure(context, R.string.network_err_roaming);
      return false;
    }
    return true;
  }
  
  private static void showNetworkFailure(Context context, int resId) {
    new AlertDialog.Builder(context)
    .setIcon(R.drawable.ic_launcher).setTitle(R.string.network_err_title)
    .setPositiveButton(R.string.donate_btn_OK, null)
    .setMessage(resId)
    .create().show();
  }
}