package net.anei.cadpage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.donation.DonationManager;
import net.anei.cadpage.parsers.MsgInfo;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.telephony.SmsMessage;

public class SmsPopupUtils {

  public static final Pattern GPSPattern = 
    Pattern.compile("\\b([+-]?[0-9]+\\.[0-9]{4,}|[+-]?[0-9]+:[0-9]+:[0-9]+\\.[0-9]{4,})[,\\W]\\W*([+-]?[0-9]+\\.[0-9]{4,}|[+-]?[0-9]+:[0-9]+:[0-9]+\\.[0-9]{4,})\\b");


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
    enableComponent(context, C2DMReceiver.class, enable.contains("C") && !DonationManager.instance().isFreeVersion());
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
   * Request map location for message
   */
  public static void  mapMessage(Context context, MsgInfo info, boolean useGPS)  {
    if (Log.DEBUG) Log.v("Request Received to Map Call");
    if (haveNet(context)) {
        String searchStr = null;
        if (useGPS) searchStr = parseGPSCoords(info.getGPSLoc());
        if (searchStr == null) searchStr = parseGPSCoords(info.getMapAddress());
        if (searchStr == null) searchStr = Uri.encode(info.getMapAddress());
        Uri uri = Uri.parse("geo:0,0?q=" + searchStr);
        if (Log.DEBUG) Log.v("mapMessage: SearchStr=" + searchStr);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Log.e("Could not find com.google.android.maps.Maps activity");
        }
    }
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


  /**
   * Look for GPS coordinates in address line.  If found, parse them into a
   * set of coordinates that Google Maps will recognize
   */
  private static String parseGPSCoords(String address) {
    Matcher match = GPSPattern.matcher(address);
    if (!match.find()) return null;

    double c1 = cvtGpsCoord(match.group(1));
    double c2 = cvtGpsCoord(match.group(2));
    
    // There isn't a consistent standard as to which is latitude and
    // which is longitude, so we will have to make some guesses.
    double latitude, longitude;
    if (c1 < 0) {
      latitude = c2;
      longitude = c1;
    } else if (c2 < 0) {
      latitude = c1;
      longitude = c2;
    } else if (c1 > c2) {
      latitude = c2;
      longitude = -c1;
    } else {
      latitude = c1;
      longitude = -c2;
    }
    return "" + latitude + "," + longitude;
  }

  /**
   * Convert GPS coordinate in degree:min:sec form to strait degrees
   */
  private static double cvtGpsCoord(String coord) {
    int pt1 = coord.indexOf(':');
    if (pt1 < 0) return Double.parseDouble(coord);
    int pt2 = coord.indexOf(':', pt1+1);
    String sDeg = coord.substring(0, pt1);
    char sgn = sDeg.charAt(0);
    boolean neg = (sgn == '-');
    if (neg || sgn == '+') sDeg = sDeg.substring(1);
    int deg = Integer.parseInt(sDeg);
    int min = Integer.parseInt(coord.substring(pt1+1,pt2));
    double sec = Double.parseDouble(coord.substring(pt2+1));
    double result = deg + min/60. + sec/3600.;
    if (neg) result = -result;
    return result;
  }
}