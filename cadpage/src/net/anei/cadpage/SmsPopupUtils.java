package net.anei.cadpage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.telephony.SmsMessage;

public class SmsPopupUtils {
  //Content URIs for SMS app, these may change in future SDK
  public static final Uri MMS_SMS_CONTENT_URI = Uri.parse("content://mms-sms/");
  public static final Uri THREAD_ID_CONTENT_URI =
    Uri.withAppendedPath(MMS_SMS_CONTENT_URI, "threadID");
  public static final Uri CONVERSATION_CONTENT_URI =
    Uri.withAppendedPath(MMS_SMS_CONTENT_URI, "conversations");
  public static final String SMSTO_URI = "smsto:";

  public static final Uri SMS_CONTENT_URI = Uri.parse("content://sms");
  public static final Uri SMS_INBOX_CONTENT_URI = Uri.withAppendedPath(SMS_CONTENT_URI, "inbox");

  public static final Uri MMS_CONTENT_URI = Uri.parse("content://mms");
  public static final Uri MMS_INBOX_CONTENT_URI = Uri.withAppendedPath(MMS_CONTENT_URI, "inbox");

  public static final String SMSMMS_ID = "_id";
  public static final String SMS_MIME_TYPE = "vnd.android-dir/mms-sms";
  public static final int READ_THREAD = 1;
  public static final int MESSAGE_TYPE_SMS = 1;
  public static final int MESSAGE_TYPE_MMS = 2;

  public static final int CONTACT_PHOTO_PLACEHOLDER = android.R.drawable.ic_dialog_info;

  // The size of the contact photo thumbnail on the popup
  public static final int CONTACT_PHOTO_THUMBSIZE = 96;

  // The max size of either the width or height of the contact photo
  public static final int CONTACT_PHOTO_MAXSIZE = 1024;

  public static final Uri DONATE_PAYPAL_URI =
    Uri.parse("Not Available Yet");
  public static final Uri DONATE_MARKET_URI =
    Uri.parse("Not Available Yet");
  
  
  private static String nameVersion = null;
  public static String getNameVersion(Context context) {

    if (nameVersion == null) {
      //Try and find app version number
      String version;
      PackageManager pm = context.getPackageManager();
      try {
        //Get version number, not sure if there is a better way to do this
        version = " v" +
        pm.getPackageInfo(
          SmsPopupConfigActivity.class.getPackage().getName(), 0).versionName;
      } catch (NameNotFoundException e) {
        version = "";
      }
      
      nameVersion = context.getString(R.string.app_name) + version;
    }
    return nameVersion;
  }

  public static String getMmsAddress(Context context, long messageId) {
    final String[] projection =  new String[] { "address", "contact_id", "charset", "type" };
    final String selection = "type=137"; // "type="+ PduHeaders.FROM,

    Uri.Builder builder = MMS_CONTENT_URI.buildUpon();
    builder.appendPath(String.valueOf(messageId)).appendPath("addr");

    Cursor cursor = context.getContentResolver().query(
        builder.build(),
        projection,
        selection,
        null, null);

    if (cursor != null) {
      try {
        if (cursor.moveToFirst()) {
          // Apparently contact_id is always empty in this table so we can't get it from here

          // Just return the address
          return cursor.getString(0);
        }
      } finally {
        cursor.close();
      }
    }

    return context.getString(android.R.string.unknownName);
  }

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
  public static void enableSMSPopup(Context context, boolean enable) {
    PackageManager pm = context.getPackageManager();
    ComponentName cn = new ComponentName(context, SmsReceiver.class);

    // Update preference so it reflects in the preference activity
    SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    SharedPreferences.Editor settings = myPrefs.edit();
    settings.putBoolean(context.getString(R.string.pref_enabled_key), enable);
    settings.commit();

    if (enable) {
      if (Log.DEBUG) Log.v("SMSPopup receiver is enabled");
      pm.setComponentEnabledSetting(cn,
          PackageManager.COMPONENT_ENABLED_STATE_DEFAULT,
          PackageManager.DONT_KILL_APP);

    } else {
      if (Log.DEBUG) Log.v("SMSPopup receiver is disabled");
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
  public static void  mapMessage(Context context, SmsMsgInfo info)  {
    if (Log.DEBUG) Log.v("Request Received to Map Call");
    if (haveNet(context)) {
        String searchStr = info.getMapAddress();
        String coords = parseGPSCoords(searchStr);
        if (coords != null) {
          searchStr = coords;
        } else {
          searchStr = Uri.encode(searchStr);
        }
        Uri uri = Uri.parse("geo:0,0?q=" + searchStr);
        if (Log.DEBUG) Log.v("mapMessage: SearchStr=" + searchStr);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Log.e("Could not find com.google.android.maps.Maps activity");
        }
        
    } else {
      if (Log.DEBUG) Log.v("Error: No Network Connection.");
      Dialog locationError = new AlertDialog.Builder(context)
          .setIcon(0).setTitle("Error").setPositiveButton("Ok", null)
          .setMessage("Unable to Map Address due to Network Failure.")
          .create();
      locationError.show();
    }
  }

  /**
   * Determine if we have Internet connectivity
   * @param context current context
   * @return true if Internet connectivity is established
   */
  private static boolean haveNet(Context context){

    NetworkInfo info = (NetworkInfo) ((ConnectivityManager) 
        context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

    if (info == null || !info.isConnected()) {
      return false;
    }
    if (info.isRoaming()) {
      // here is the roaming option you can change it if you want to
      // disable Internet while roaming, just return false
      return false;
    }
    return true;

  }


  /**
   * Look for GPS coordinates in address line.  If found, parse them into a
   * set of coordinates that Google Maps will recognize
   */
  private static String parseGPSCoords(String address) {
    Matcher match = GPSPattern.matcher(address);
    if (!match.find()) return null;

    String latitude = match.group(1);
    String longitude = match.group(2);
    if (Character.isDigit(longitude.charAt(0))) longitude = "-" + longitude;
    return latitude + "," + longitude;
  }
  private static final Pattern GPSPattern = 
    Pattern.compile("\\b([+-]?[0-9]+\\.[0-9]+)\\W+([+-]?[0-9]+\\.[0-9]+)\\b");

  /**
   * Determine if message address matches address filter
   * @param sAddress message address
   * @param sFilter address filter
   * @return true if message address satisfies filter
   */
  public static boolean matchFilter(String sAddress, String sFilter) {
    
    if (sFilter == null) return true;
    
    // A filter with length of 0 or 1 is invalid and is always passed
    if (sFilter.length() <= 1) return true;
    
    // Filter can consist of multiple address filters separated by comas
    for (String tFilter : sFilter.split(",")) {
      tFilter = tFilter.trim();
      
      // A subfilter with length of 0 or 1 is invalid and is ignored
      // Doing otherwise makes it too difficult to determine whether or not
      // an active filter is in lplace
      if (tFilter.length() <= 1) continue;
      
      // Otherwise filter is passed if it matches any substring in the address
      // Check should be case insensitive, which we accomplish by downshifting
      // both the address and the filter
      if (sAddress.toLowerCase().contains(tFilter.toLowerCase())) return true;
    }
    return false;
  }
}