package net.anei.cadpage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.anei.cadpage.donation.DonationManager;
import net.anei.cadpage.donation.MainDonateEvent;
import net.anei.cadpage.parsers.ManageParsers;
import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.vendors.VendorManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class ManagePreferences {
  
  // Preference version.  This needs to be incremented every time a new
  // configuration setting is added to force it to initialize properly
  // when the new release is first run.
  // (OK, if you know what you are doing, and the only new settings added
  // are boolean settings that default to false, you can get away with not
  // changing this)
  private static final int PREFERENCE_VERSION = 33;
  
  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MMddyyyy");
  
  private static ManagePreferences prefs;
  private static String freeSubType;
  private static String paidSubType;

  /**
   * Initialize the ManagePreferences class
   * @param context
   */
  public static void setupPreferences(Context context) {
    
    // Initialize the preference object
    prefs = new ManagePreferences(context);
    
    Object oldMergeOption = prefs.getPreference(R.string.pref_resp_merge_key);
    if (oldMergeOption instanceof Boolean) {
      String newMergeOption = ((Boolean)oldMergeOption ? "A" : "R");
      prefs.putString(R.string.pref_resp_merge_key, newMergeOption);
    }

    // Before we do anything else, see what the old preference version number was
    int oldVersion = prefs.getInt(R.string.pref_version_key, 0);

    // If the old version doesn't match the current version, we need to reload
    // the preference defaults and update the preference version
    if (oldVersion != PREFERENCE_VERSION) {
      PreferenceManager.setDefaultValues(context, R.xml.preferences, true);
      prefs.putInt(R.string.pref_version_key, PREFERENCE_VERSION);
    }
    
    // If old version was < 21, we need to reset the popup button configuration settings
    if (oldVersion < 21) {
      prefs.putString(R.string.pref_button1_key, context.getString(R.string.pref_button1_default));
      prefs.putString(R.string.pref_button2_key, context.getString(R.string.pref_button2_default));
      prefs.putString(R.string.pref_button3_key, context.getString(R.string.pref_button3_default));
      prefs.putString(R.string.pref_button4_key, context.getString(R.string.pref_button4_default));
      prefs.putString(R.string.pref_button5_key, context.getString(R.string.pref_button5_default));
      prefs.putString(R.string.pref_button6_key, context.getString(R.string.pref_button6_default));
    }
    
    // If old version < 17, add a 'C' to message type preference
    if (oldVersion < 17) {
      String msgType = enableMsgType();
      if (! msgType.startsWith("C")) {
        prefs.putString(R.string.pref_enable_msg_type_key, "C" + msgType);
      }
    }
    
    // Ditto if is a newer parser code that has been renamed,
    String location = location();
    String newLocation = convertOldLocationCode(context, location);
    if (! location.equals(newLocation)) {
      setLocation(newLocation);
      if (location.equals("MDCentreville")) {
        if (!overrideDefaults()) {
          setOverrideDefaults(true);
          setDefaultCity("Centreville");
          setDefaultState("MD");
        }
      }
    }
    
    // Set the install date if it hasn't already been set
    setInstallDate();
    
    // Clear GCM registration in progress flag
    if (registerReqActive()) setRegisterReqActive(false);
    
    // Finally set the application enable status
    String enableStr = (enabled() ? enableMsgType() : "");
    SmsPopupUtils.enableSMSPopup(context, enableStr);
    
    // Reallyfinally,while we hav a context, look up the paid/free subscription
    // titles
    freeSubType = context.getString(R.string.free_subtype);
    paidSubType = context.getString(R.string.paid_subtype);
  }
  
  /**
   * Convert any old obsolete location codes to new equivalent
   * @param current context
   * @param location location to be checked
   * @return the new location that should be used
   */
  public static String convertOldLocationCode(Context context, String location) {
    
    // Scan through all of the location codes looking to see if any of thm
    // match an old code
    String[] locs = location.split(",");
    boolean bad = false;
    for (String loc : locs) {
      if (!loc.equals(ManageParsers.convertLocationCode(loc))) {
        bad = true;
        break;
      }
    }
    
    // If not, the usual case, return the original location string
    if (!bad) return location;
    
    ArrayList<String> locList = new ArrayList<String>();
    for (String loc : locs) {
      loc = ManageParsers.convertLocationCode(loc);
      if (!locList.contains(loc)) locList.add(loc);
    }
    
    Collections.sort(locList);
    StringBuilder sb = new StringBuilder();
    for (String loc : locList) {
      if (sb.length() > 0) sb.append(',');
      sb.append(loc);
    }
    return sb.toString();
  }
  
  /**
   * Backdoor allows test classes to substitute their own ManagerPreference object
   * for the standard one
   * @param prefs custom ManagerPreference object
   */
  protected static void setTestPreference(ManagePreferences prefs) {
    ManagePreferences.prefs = prefs;
  }
  
  public static void setScreenSize(String newVal) {
    prefs.putString(R.string.pref_screen_size_key, newVal);
  }
  
  public static boolean initialized() {
    return prefs.getBoolean(R.string.pref_initialized_key);
  }
  
  public static void setInitialized(boolean newVal) {
    prefs.putBoolean(R.string.pref_initialized_key, newVal);
  }
  
  public static boolean initBilling() {
    return prefs.getBoolean(R.string.pref_init_billing_key);
  }
  
  public static void setInitBilling() {
    setInitBilling(true);
  }
  
  public static void setInitBilling(boolean newVal) {
    prefs.putBoolean(R.string.pref_init_billing_key, newVal);
  }
  
  public static boolean enabled() {
    return prefs.getBoolean(R.string.pref_enabled_key);
  }
  
  public static void setEnabled(boolean newVal) {
    prefs.putBoolean(R.string.pref_enabled_key, newVal);
  }
  
  public static String release() {
    return prefs.getString(R.string.pref_release_key, "");
  }
  
  public static void setRelease(String newRelease) {
    prefs.putString(R.string.pref_release_key, newRelease);
  }
  
  public static String enableMsgType() {
    return prefs.getString(R.string.pref_enable_msg_type_key);
  }
  
  public static int mmsTimeout() {
    return prefs.getIntValue(R.string.pref_mms_timeout_key);
  }
  
  public static String location() {
    return prefs.getString(R.string.pref_location_key, "General");
  }
  
  public static void setLocation(String newLocation) {
    prefs.putString(R.string.pref_location_key, newLocation);
  }
  
  public static MsgParser getCurrentParser() {
    try {
      return ManageParsers.getInstance().getParser(location());
    } catch (RuntimeException ex) {
      setLocation("General");
      throw ex;
    }
  }
  
  public static boolean overrideFilter() {
    return prefs.getBoolean(R.string.pref_override_filter_key);
  }
  
  public static String filter() {
    return prefs.getString(R.string.pref_filter_key);
  }
  
  public static boolean genAlert() {
    return prefs.getBoolean(R.string.pref_gen_alert_key);
  }
  
  public static boolean showSource() {
    return prefs.getBoolean(R.string.pref_show_source_key);
  }
  
  public static boolean overrideDefaults() {
    return prefs.getBoolean(R.string.pref_override_default_key);
  }
  
  private static void setOverrideDefaults(boolean newVal) {
    prefs.putBoolean(R.string.pref_override_default_key, newVal);
  }
  
  public static String defaultCity() {
    return prefs.getString(R.string.pref_defcity_key);
  }
  
  private static void setDefaultCity(String newVal) {
    prefs.putString(R.string.pref_defcity_key, newVal);
  }
  
  public static String defaultState() {
    return prefs.getString(R.string.pref_defstate_key);
  }
  
  private static void setDefaultState(String newVal) {
    prefs.putString(R.string.pref_defstate_key, newVal);
  }
  
  public static int logLimit() {
    return prefs.getIntValue(R.string.pref_loglimit_key);
  }
  
  public static int partMsgTimeout() {
    return prefs.getIntValue(R.string.pref_msgtimeout_key);
  }
  
  public static int splitMinMsg() {
    return prefs.getIntValue(R.string.pref_split_min_msg_key);
  }
  
  public static boolean splitBlankIns() {
    return prefs.getBoolean(R.string.pref_split_blank_ins_key);
  }
  
  public static boolean splitChkSender() {
    return prefs.getBoolean(R.string.pref_split_chk_sender_key);
  }
  
  public static boolean splitKeepLeadBreak() {
    return prefs.getBoolean(R.string.pref_split_keep_lead_break_key);
  }
  
  public static boolean revMsgOrder() {
    return prefs.getBoolean(R.string.pref_rev_msg_order_key);
  }
  
  public static boolean suppressDupMsg() {
    return prefs.getBoolean(R.string.pref_suppress_dup_msg_key);
  }
  
  public static boolean overrideVendorLoc() {
    return prefs.getBoolean(R.string.pref_override_vendor_loc_key);
  }
  
  public static boolean activeScanner() {
    return prefs.getBoolean(R.string.pref_activate_scanner_key);
  }
  
  public static String scannerChannel() {
    String channel = prefs.getString(R.string.pref_scanner_channel_key, null);
    if (channel == null) channel = "<None Selected>";
    return channel;
  }
  
  public static void setScannerChannel(String newVal) {
    prefs.putString(R.string.pref_scanner_channel_key, newVal);
  }
  
  public static Intent scannerIntent() {
    String value = prefs.getString(R.string.pref_scanner_channel_app_node_key, null);
    if (value == null) return null;
    if (!value.startsWith(SCAN_VERSION)) return null;
    value = value.substring(SCAN_VERSION.length());
    String[] fields = value.split(SCAN_FLD_DELIM);
    if (fields.length != 4) return null;
    Intent intent = new Intent(fields[0]);
    Bundle bundle = new Bundle();
    bundle.putString(SCAN_ACTION_KEY, fields[1]);
    bundle.putString(SCAN_DESCRIPTION_KEY, fields[2]);
    bundle.putString(SCAN_LOCALE_KEY, fields[3]);
    intent.putExtra(SCAN_BUNDLE_KEY, bundle);
    return intent;
  }
  
  public static void setScannerIntent(Intent playIntent) {
    String newVal = null;
    String action = playIntent.getAction();
    Bundle bundle = playIntent.getBundleExtra(SCAN_BUNDLE_KEY);
    if (bundle != null) {
      String action2 = bundle.getString(SCAN_ACTION_KEY);
      String description = bundle.getString(SCAN_DESCRIPTION_KEY);
      String locale = bundle.getString(SCAN_LOCALE_KEY);
      if (action != null && action2 != null && description != null && locale != null) {
        newVal = SCAN_VERSION + action + SCAN_FLD_DELIM + action2 + SCAN_FLD_DELIM + description + SCAN_FLD_DELIM + locale;
      }
    }
    prefs.putString(R.string.pref_scanner_channel_app_node_key, newVal);
  }
  
  private static final String SCAN_VERSION = "00";
  private static final String SCAN_BUNDLE_KEY = "com.twofortyfouram.locale.intent.extra.BUNDLE";
  private static final String SCAN_ACTION_KEY = "action";
  private static final String SCAN_DESCRIPTION_KEY = "description";
  private static final String SCAN_LOCALE_KEY = "localeDirectoryLine";
  private static final String SCAN_FLD_DELIM = "<!>";
  
  public static boolean publishPages() {
    return prefs.getBoolean(R.string.pref_publish_pages_key);
  }
  
  public static boolean notifyEnabled() {
    return prefs.getBoolean(R.string.pref_notif_enabled_key);
  }
  
  public static void setNotifyEnabled(boolean newVal) {
    prefs.putBoolean(R.string.pref_notif_enabled_key, newVal);
  }
  
  public static boolean notifyOverride() {
    return prefs.getBoolean(R.string.pref_notif_override_key);
  }
  
  public static String notifySound() {
    return prefs.getString(R.string.pref_notif_sound_key);
  }
  
  public static int notifyTimeout() {
    return prefs.getIntValue(R.string.pref_notif_timeout_key);
  }
  
  public static boolean vibrate() {
    return prefs.getBoolean(R.string.pref_vibrate_key);
  }
  
  public static String vibratePattern() {
    return prefs.getString(R.string.pref_vibrate_pattern_key);
  }

  public static void setVibratePatternCustom(String pattern) {
    prefs.putString(R.string.pref_vibrate_pattern_custom_key, pattern);
  }
  
  public static String vibratePatternCustom() {
    if ( prefs.getString(R.string.pref_vibrate_pattern_custom_key) == null){
      return prefs.getString(R.string.pref_vibrate_pattern_key);
    }
    return prefs.getString(R.string.pref_vibrate_pattern_custom_key);
  }
  
  public static boolean flashLED() {
    return prefs.getBoolean(R.string.pref_flashled_key);
  }
  
  public static String flashLEDColor() {
    return prefs.getString(R.string.pref_flashled_color_key);
  }
  
  public static String textSize() {
   return  prefs.getString(R.string.pref_textsize_key);
  }
  
  public static String flashLEDColorCustom() {
    if (prefs.getString(R.string.pref_flashled_color_custom_key)==null){
      return prefs.getString(R.string.pref_flashled_color_key);
    }
    return prefs.getString(R.string.pref_flashled_color_custom_key);
  }
  
  public static String flashLEDPattern() {
    return prefs.getString(R.string.pref_flashled_pattern_key);
  }
  
  public static String flashLEDPatternCustom() {
    if (prefs.getString(R.string.pref_flashled_pattern_custom_key)==null){
      return prefs.getString(R.string.pref_flashled_pattern_key);
    }
    return prefs.getString(R.string.pref_flashled_pattern_custom_key);
  }
  
  public static boolean notifyRepeat() {
    return prefs.getBoolean(R.string.pref_notif_repeat_key);
  }
  
  public static int repeatInterval() {
    return prefs.getIntValue(R.string.pref_notif_repeat_interval_key);
  }
  
  public static boolean popupEnabled() {
    return prefs.getBoolean(R.string.pref_popup_enabled_key);
  }
  
  public static void setPopupEnabled(boolean newVal) {
    prefs.putBoolean(R.string.pref_popup_enabled_key, newVal);
  }
  
  public static boolean noShowInCall() {
    return prefs.getBoolean(R.string.pref_noShowInCall_key);
  }

  public static boolean smspassthru() {
    // If donation status is disabled, we never block messages from falling
    // through to regular processor.
    if (!DonationManager.instance().isEnabled()) return true;
    return prefs.getBoolean(R.string.pref_passthrusms_key);
  }
  
  public static boolean screenOn() {
    return prefs.getBoolean(R.string.pref_screen_on_key);
  }
  
  public static int timeout() {
    return prefs.getIntValue(R.string.pref_timeout_key);
  }
  
  public static boolean dimScreen() {
    return prefs.getBoolean(R.string.pref_dimscreen_key);
  }
  
  public static boolean privacyMode() {
    return prefs.getBoolean(R.string.pref_privacy_key);
  }
  
  public static boolean showPersonal() {
    return prefs.getBoolean(R.string.pref_show_personal_key);
  }
  
  public static boolean deleteUnopen() {
    return prefs.getBoolean(R.string.pref_delete_unopen_key);
  }
  
  public static String mapNetworkChk() {
    return prefs.getString(R.string.pref_map_network_chk_key);
  }
  
  public static int gpsMapOption() {
    String val = prefs.getString(R.string.pref_gps_map_option_key);
    return val.charAt(0) - '0';
  }
  
  public static String reportPosition() {
    return prefs.getString(R.string.pref_report_position_key);
  }
  
  public static void setReportPosition(String newVal) {
    prefs.putString(R.string.pref_report_position_key, newVal);
  }

  public static int historyCount() {
    return prefs.getIntValue(R.string.pref_history_limit_key);
  }
  
  public static String responseType() {
    return prefs.getString(R.string.pref_resp_type_key);
  }
  
  public static String responseMerge() {
    return prefs.getString(R.string.pref_resp_merge_key);
  }
  
  private static final int[] POPUP_BUTTON_IDS = new int[]{
    R.string.pref_button1_key,
    R.string.pref_button2_key,
    R.string.pref_button3_key,
    R.string.pref_button4_key,
    R.string.pref_button5_key,
    R.string.pref_button6_key
  };
  
  public static final int POPUP_BUTTON_CNT = POPUP_BUTTON_IDS.length;
  public static int popupButton(int button) {
    String val =  prefs.getString(POPUP_BUTTON_IDS[button-1]);
    if (val.length() == 0) return 0;
    return Integer.parseInt(val);
  }
  
  private static final int[] CALLBACK_TITLE_IDS = new int[]{
    R.string.pref_callback1_title_key,
    R.string.pref_callback2_title_key,
    R.string.pref_callback3_title_key,
    R.string.pref_callback4_title_key,
    R.string.pref_callback5_title_key,
    R.string.pref_callback6_title_key,
  };
  
  public static final int CALLBACK_BUTTON_CNT = CALLBACK_TITLE_IDS.length;
  public static String callbackButtonTitle(int button) {
    return prefs.getString(CALLBACK_TITLE_IDS[button-1]);
  }
  
  private static final int[] CALLBACK_CODE_IDS = new int[]{
    R.string.pref_callback1_key,
    R.string.pref_callback2_key,
    R.string.pref_callback3_key,
    R.string.pref_callback4_key,
    R.string.pref_callback5_key,
    R.string.pref_callback6_key,
  };
  
  public static String callbackButtonCode(int button) {
    return prefs.getString(CALLBACK_CODE_IDS[button-1]);
  }
  
  private static final int[] EXTRA_BUTTON_IDS = new int[]{
    R.string.pref_xtra_resp_button1_key,
    R.string.pref_xtra_resp_button2_key,
    R.string.pref_xtra_resp_button3_key
  };
  
  public static final int EXTRA_BUTTON_CNT = EXTRA_BUTTON_IDS.length;
  public static int extraButton(int button) {
    String val =  prefs.getString(EXTRA_BUTTON_IDS[button-1]);
    if (val.length() == 0) return 0;
    return Integer.parseInt(val);
  }
  
  public static Date installDate() {
    String dateStr = prefs.getString(R.string.pref_install_date_key);
    try {
      return DATE_FORMAT.parse(dateStr);
    } catch (ParseException ex) {
      throw new RuntimeException(ex);
    }
  }
  
  public static void setInstallDate() {
    if (prefs.getString(R.string.pref_install_date_key, null) != null) return;
    setInstallDate(new Date());
  }
  
  public static void setInstallDate(Date date) {
    String dateStr = DATE_FORMAT.format(date);
    prefs.putString(R.string.pref_install_date_key, dateStr);
    DonationManager.instance().reset();
    MainDonateEvent.instance().refreshStatus();
  }
  
  public static int paidYear() {
    return prefs.getInt(R.string.pref_paid_year_key, 0);
  }
  
  public static void setPaidYear(int year) {
    prefs.putInt(R.string.pref_paid_year_key, year);
  }
  
  public static void setPaidYear(int year, boolean set) {
    int curYear = paidYear();
    if (set) {
      if (year > curYear) {
        prefs.putInt(R.string.pref_prev_year_key, curYear);
        prefs.putInt(R.string.pref_paid_year_key, year);
        prefs.putString(R.string.pref_prev_purchase_date_key, purchaseDateString());
      }
    } else {
      if (year == curYear) {
        int prevYear = prefs.getInt(R.string.pref_prev_year_key, 0);
        prefs.putInt(R.string.pref_paid_year_key, prevYear);
        prefs.putInt(R.string.pref_prev_year_key, 0);
        setPurchaseDateString(prefs.getString(R.string.pref_prev_purchase_date_key, ""));
        prefs.putString(R.string.pref_prev_purchase_date_key, "");
      }
    }
  }
  
  public static Date purchaseDate() {
    String dateStr = prefs.getString(R.string.pref_purchase_date_key, null);
    if (dateStr == null) return null;
    try {
      return DATE_FORMAT.parse(dateStr);
    } catch (ParseException ex) {
      throw new RuntimeException(ex);
    }
  }
  
  public static void setPurchaseDate(Date date) {
    String dateStr = DATE_FORMAT.format(date);
    prefs.putString(R.string.pref_purchase_date_key, dateStr);
  }
  
  public static String purchaseDateString() {
    String dateStr = prefs.getString(R.string.pref_purchase_date_key, null);
    if (dateStr == null) dateStr = currentDateString();
    return dateStr;
  }
  
  public static String currentDateString() {
    return DATE_FORMAT.format(new Date());
  }
  
  public static void setPurchaseDateString(String  sDate) {
    prefs.putString(R.string.pref_purchase_date_key, sDate);
  }
  
  public static String sponsor() {
    return prefs.getString(R.string.pref_sponsor_key, null);
  }
  
  public static void setSponsor(String sponsor) {
    String oldSponsor = sponsor();
    if (oldSponsor == null && sponsor == null) return;
    prefs.putString(R.string.pref_sponsor_key, sponsor);
  }
  
  public static boolean freeRider() {
    return prefs.getBoolean(R.string.pref_free_rider_key);
  }
  
  public static void setFreeRider(boolean newVal) {
    if (newVal == freeRider()) return;
    prefs.putBoolean(R.string.pref_free_rider_key, newVal);
  }
  
  public static boolean freeSub() {
    return prefs.getBoolean(R.string.pref_free_sub_key);
  }
  
  public static void setFreeSub(boolean newVal) {
    if (newVal == freeSub()) return;
    prefs.putBoolean(R.string.pref_free_sub_key, newVal);
  }
  
  public static String subscriptionType() {
    return ManagePreferences.freeSub() ? freeSubType : paidSubType;
  }

  public static String authLocation() {
    return prefs.getString(R.string.pref_auth_location_key, "");
  }
  
  public static void setAuthLocation(String newVal) {
    if (newVal != null && newVal.equals(authLocation())) return;
    prefs.putString(R.string.pref_auth_location_key, newVal);
  }
  
  public static String authOrganization() {
    return prefs.getString(R.string.pref_auth_organization_key, "");
  }
  
  public static void setAuthOrganization(String newVal) {
    prefs.putString(R.string.pref_auth_organization_key, newVal);
  }
  
  public static Date authExtraDate() {
    String dateStr = prefs.getString(R.string.pref_auth_extra_date_key, null);
    if (dateStr == null) return null;
    try {
      return DATE_FORMAT.parse(dateStr);
    } catch (ParseException ex) {
      return null;
    }
  }
  
  public static int authExtraCnt() {
    return prefs.getInt(R.string.pref_auth_extra_cnt_key, 0);
  }
  
  public static void resetAuthExtra() {
    prefs.putString(R.string.pref_auth_extra_date_key, null);
    prefs.putInt(R.string.pref_auth_extra_cnt_key, 0);
  }
  
  public static void authExtraDay() {
    String sDate = DATE_FORMAT.format(new Date());
    prefs.putString(R.string.pref_auth_extra_date_key, sDate);
    int cnt = authExtraCnt();
    prefs.putInt(R.string.pref_auth_extra_cnt_key, cnt+1);
  }
  
  public static Date authExemptDate() {
    String exemptDate =  prefs.getString(R.string.pref_auth_exempt_date_key, null);
    if (exemptDate == null) return null;
    if (!exemptDate.equals(prefs.context.getString(R.string.release_date))) return null;
    try {
      return DATE_FORMAT.parse(exemptDate);
    } catch (ParseException e) {
      return null;
    }
  }
  
  public static void setExemptDate() {
    setExemptDate(prefs.context.getString(R.string.release_date));
    DonationManager.instance().reset();
    MainDonateEvent.instance().refreshStatus();
  }
  
  public static Date releaseDate() {
    String sDate = prefs.context.getString(R.string.release_date);
    try {
      return DATE_FORMAT.parse(sDate);
    } catch (ParseException e) {
      return null;
    }
  }
  
  public static void setExemptDate(String newVal) {
    prefs.putString(R.string.pref_auth_exempt_date_key, newVal);
  }
  
  public static void setAuthExemptDate(String newVal) {
    prefs.putString(R.string.pref_auth_exempt_date_key, newVal); 
  }
  
  public static int calcAuthRunDays(Date date) {
    if (date == null) {
      prefs.putString(R.string.pref_auth_last_date_key, null);
      return 0;
    }
    int days = prefs.getInt(R.string.pref_auth_run_days_key, 0);
    String curDate = DATE_FORMAT.format(date);
    String lastDate = prefs.getString(R.string.pref_auth_last_date_key, null);
    if (lastDate == null || ! lastDate.equals(curDate)) {
      prefs.putString(R.string.pref_auth_last_date_key, curDate);
      if (lastDate != null) {
        days++;
        prefs.putInt(R.string.pref_auth_run_days_key, days);
      }
    }
    return days;
  }
  
  public static void setAuthRunDays(int days) {
    prefs.putInt(R.string.pref_auth_run_days_key, days);
    prefs.putString(R.string.pref_auth_last_date_key, null);
  }
  
  public static void rollLastAuthDate(String dateStr) {
    if (prefs.getString(R.string.pref_auth_last_date_key, null) != null) {
      prefs.putString(R.string.pref_auth_last_date_key, dateStr);
    }
  }
  
  public static long authLastCheckTime() {
    return prefs.getLong(R.string.pref_auth_last_check_time_key, 0L);
  }
  
  public static void setAuthLastCheckTime() {
    setAuthLastCheckTime(System.currentTimeMillis());
  }
  
  public static void setAuthLastCheckTime(long newVal) {
    prefs.putLong(R.string.pref_auth_last_check_time_key, newVal);
  }
  
  public static String registrationId() {
    return prefs.getString(R.string.pref_registration_id_key, null);
  }
  
  public static boolean setRegistrationId(String regId) {
    String oldRegId = registrationId();
    prefs.putString(R.string.pref_prev_registration_id_key, oldRegId);
    prefs.putString(R.string.pref_registration_id_key, regId);
    if (regId == null) return (oldRegId == null);
    else return !regId.equals(oldRegId);
  }
  
  public static boolean newVersion(int versionCode) {
    int prevVersion = prefs.getInt(R.string.pref_prev_version_code, 0);
    if (versionCode == prevVersion) return false;
    prefs.putInt(R.string.pref_prev_version_code, versionCode);
    return true;
  }
  
  public static boolean registerReqActive() {
    return prefs.getBoolean(R.string.pref_register_req_active_key);
  }
  
  public static void setRegisterReqActive(boolean newVal) {
    prefs.putBoolean(R.string.pref_register_req_active_key, newVal);
  }
  
  public static int registerReq() {
    return prefs.getInt(R.string.pref_register_req_key, 0);
  }
  
  public static void setRegisterReq(int newVal) {
    prefs.putInt(R.string.pref_register_req_key, newVal);
  }
  
  public static int reregisterDelay() {
    return prefs.getInt(R.string.pref_reregister_delay_key, 0);
  }
  
  public static void setReregisterDelay(int newVal) {
    prefs.putInt(R.string.pref_reregister_delay_key, newVal);
  }
  
  public static Date registerDate() {
    String dateStr = prefs.getString(R.string.pref_register_date_key, null);
    if (dateStr == null) return null;
    try {
      return DATE_FORMAT.parse(dateStr);
    } catch (ParseException ex) {
      throw new RuntimeException(ex);
    }
  }
  
  public static void setRegisterDate() {
    Date curDate = new Date();
    setRegisterDate(curDate);
  }
  
  public static void setRegisterDate(Date date) {
    String dateStr = DATE_FORMAT.format(date);
    prefs.putString(R.string.pref_register_date_key, dateStr);
  }
  
  public static boolean reconnect() {
    return prefs.getBoolean(R.string.pref_reconnect_key);
  }
  
  public static void setReconnect(boolean newVal) {
    prefs.putBoolean(R.string.pref_reconnect_key, newVal);
  }
  
  public static String ledColor() {
    return prefs.getString(R.string.pref_flashled_color_key, R.string.pref_flashled_color_default);
  }
  
  public static String ledColorCustom() {
    return prefs.getString(R.string.pref_flashled_color_custom_key, R.string.pref_flashled_color_default);
  }

  public static void setLedColorCustom(int color) {
    prefs.putString(R.string.pref_flashled_color_custom_key, "#" + Integer.toHexString(color));
  }
  
  public static String ledPattern() {
    return prefs.getString(R.string.pref_flashled_pattern_key, R.string.pref_flashled_pattern_default);
  }
  
  public static String ledPatternCustom() {
    return prefs.getString(R.string.pref_flashled_pattern_custom_key, R.string.pref_flashled_pattern_default);
  }

  public static void setLedPatternCustom(String pattern) {
    prefs.putString(R.string.pref_flashled_pattern_custom_key, pattern);
  }
  
  public static long lastLocTime() {
    return prefs.getLong(R.string.pref_last_loc_time_key, 0L);
  }
  
  public static void setLastLocTime(long newVal) {
    prefs.putLong(R.string.pref_last_loc_time_key, newVal);
  }
  
  public static float lastLocAcc() {
    return prefs.getFloat(R.string.pref_last_loc_acc_key, 1.E30F);
  }
  
  public static void setLastLocAcc(float newVal) {
    prefs.putFloat(R.string.pref_last_loc_acc_key, newVal);
  }
  
  public static boolean directPageActive() {
    return prefs.getBoolean(R.string.pref_direct_page_active_key);
  }
  
  public static void setDirectPageActive(boolean newVal) {
    prefs.putBoolean(R.string.pref_direct_page_active_key, newVal);
  }
  
  public static long lastGcmEventTime() {
    return prefs.getLong(R.string.pref_last_gcm_event_time_key, 0L);
  }
  
  public static void setLastGcmEventTime(long newVal) {
    prefs.putLong(R.string.pref_last_gcm_event_time_key, newVal);
  }
  
  public static String lastGcmEventType() {
    return prefs.getString(R.string.pref_last_gcm_event_type_key, null);
  }
  
  public static void setLastGcmEventType(String newVal) {
    prefs.putString(R.string.pref_last_gcm_event_type_key, newVal);
  }
  
  public static void clearAll() {
    SharedPreferences.Editor settings = prefs.mPrefs.edit();
    settings.clear();
    settings.commit();
  }

  /**
   * Append configuration information to constructed message
   * @param context active context
   * @param sb StringBuilder object where message is constructed
   */
  public static void addConfigInfo(Context context, StringBuilder sb) {
    sb.append(String.format("\n\n----------\nSysinfo - %s\nModel: %s\nStatus: %s\n\n",
        Build.FINGERPRINT, Build.MODEL, DonationManager.instance().status().toString()));
    
    sb.append("Preference Configuration:\n");

    // Array of preference keys to include in email
    final int[] pref_keys = {
        R.string.pref_screen_size_key,
        R.string.pref_initialized_key,
        R.string.pref_enabled_key,
        
        R.string.pref_location_key,
        R.string.pref_override_filter_key,
        R.string.pref_filter_key,
        R.string.pref_gen_alert_key,
        R.string.pref_show_source_key,
        R.string.pref_override_default_key,
        R.string.pref_defcity_key,
        R.string.pref_defstate_key,
        R.string.pref_enable_msg_type_key,
        R.string.pref_timeout_key,
        R.string.pref_mms_timeout_key,
        R.string.pref_loglimit_key,
        R.string.pref_msgtimeout_key,
        R.string.pref_split_min_msg_key,
        R.string.pref_rev_msg_order_key,
        R.string.pref_split_blank_ins_key,
        R.string.pref_split_chk_sender_key,
        R.string.pref_split_keep_lead_break_key,
        R.string.pref_suppress_dup_msg_key,
        R.string.pref_override_vendor_loc_key,
        R.string.pref_activate_scanner_key,
        R.string.pref_scanner_channel_key,
        R.string.pref_scanner_channel_app_node_key,
        R.string.pref_publish_pages_key,
        
        R.string.pref_notif_enabled_key,
        R.string.pref_notif_override_key,
        R.string.pref_notif_sound_key,
        
        R.string.pref_vibrate_key,
        R.string.pref_vibrate_pattern_key,
        R.string.pref_vibrate_pattern_custom_key,
        
        R.string.pref_flashled_key,
        R.string.pref_flashled_color_key,
        R.string.pref_flashled_color_custom_key,
        R.string.pref_flashled_pattern_key,
        R.string.pref_flashled_pattern_custom_key,

        R.string.pref_notif_repeat_key,
        R.string.pref_notif_repeat_interval_key,
        R.string.pref_notif_timeout_key,

        R.string.pref_history_limit_key,
        R.string.pref_delete_unopen_key,
        R.string.pref_map_network_chk_key,
        R.string.pref_gps_map_option_key,
        R.string.pref_report_position_key,
        
        R.string.pref_popup_enabled_key,
        R.string.pref_noShowInCall_key,
        R.string.pref_passthrusms_key,
        
        R.string.pref_screen_on_key,
        R.string.pref_textsize_key,
        R.string.pref_dimscreen_key,
        R.string.pref_privacy_key,
        R.string.pref_show_personal_key,
        
        R.string.pref_button1_key,
        R.string.pref_button2_key,
        R.string.pref_button3_key,
        R.string.pref_button4_key,
        R.string.pref_button5_key,
        R.string.pref_button6_key,
        
        R.string.pref_resp_type_key,
        R.string.pref_resp_merge_key,
        R.string.pref_callback1_title_key,
        R.string.pref_callback1_key,
        R.string.pref_callback2_title_key,
        R.string.pref_callback2_key,
        R.string.pref_callback3_title_key,
        R.string.pref_callback3_key,
        R.string.pref_callback4_title_key,
        R.string.pref_callback4_key,
        R.string.pref_callback5_title_key,
        R.string.pref_callback5_key,
        R.string.pref_callback6_title_key,
        R.string.pref_callback6_key,
        
        R.string.pref_xtra_resp_button1_key,
        R.string.pref_xtra_resp_button2_key,
        R.string.pref_xtra_resp_button3_key,

        R.string.pref_paid_year_key,
        R.string.pref_install_date_key,
        R.string.pref_purchase_date_key,
        R.string.pref_free_rider_key,
        R.string.pref_sponsor_key,
        R.string.pref_free_sub_key,
        R.string.pref_auth_location_key,
        R.string.pref_auth_extra_date_key,
        R.string.pref_auth_extra_cnt_key,
        R.string.pref_auth_exempt_date_key,
        R.string.pref_auth_last_date_key,
        R.string.pref_auth_run_days_key,
        R.string.pref_auth_last_check_time_key,
        R.string.pref_prev_year_key,
        R.string.pref_prev_purchase_date_key,
        
        R.string.pref_registration_id_key,
        R.string.pref_prev_registration_id_key,
        R.string.pref_prev_version_code,
        R.string.pref_register_req_active_key,
        R.string.pref_register_req_key,
        R.string.pref_reregister_delay_key,
        R.string.pref_register_date_key,
        R.string.pref_reconnect_key,
        
        R.string.pref_last_loc_time_key,
        R.string.pref_last_loc_acc_key,
        
        R.string.pref_direct_page_active_key,
        R.string.pref_last_gcm_event_type_key,
        R.string.pref_last_gcm_event_time_key
    };

    Map<String, ?> map = prefs.mPrefs.getAll();
    
    Object regId = null;
    for (int key : pref_keys) {
      String keyName = context.getString(key);
      Object value = map.get(keyName);
      if (key == R.string.pref_registration_id_key) regId = value;
      if (key == R.string.pref_prev_registration_id_key) {
        if (value != null && value.equals(regId)) value = "< Same >";
      }
      if (key == R.string.pref_last_gcm_event_time_key){
        try {
          long time = (Long)value;
          if (time > 0) {
            value = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS").format(time);
          }
        } catch (Exception ex) {
          value = null;
        }
      }
      sb.append(String.format("%s: %s\n", keyName, value));
    }

    // Add locale info
    sb.append(String.format("locale: %s\n",
        context.getResources().getConfiguration().locale.getDisplayName()));
    
    // Add Vendor config info
    VendorManager.instance().addStatusInfo(sb);
  }

  
  private Context context;
  private SharedPreferences mPrefs;
  
  private interface PreferenceChangeListener {
    public void preferenceChanged(String key, Object newVal);
  }
  private Map<String, PreferenceChangeListener>listenerMap = 
      new HashMap<String, PreferenceChangeListener>();

  // Dummy default construct used to create a test preferences object for test purposes
  protected ManagePreferences() {}

  
  private ManagePreferences(Context _context) {
    this.context = _context;
    mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    
    registerListener(R.string.pref_enabled_key, new PreferenceChangeListener(){
      @Override
      public void preferenceChanged(String key, Object newVal) {
        boolean enabled = (Boolean)newVal;
        String enableStr = (enabled ? enableMsgType() : "");
        SmsPopupUtils.enableSMSPopup(context, enableStr);
        CadPageWidget.update(context);
      }
    });
    
    registerListener(R.string.pref_enable_msg_type_key, new PreferenceChangeListener(){
      @Override
      public void preferenceChanged(String key, Object newVal) {
        String enableMsgType = (String)newVal;
        if (enabled()) SmsPopupUtils.enableSMSPopup(context, enableMsgType);
      }
    });
    
    registerListener(R.string.pref_notif_enabled_key, new PreferenceChangeListener(){
      @Override
      public void preferenceChanged(String key, Object newVal) {
        CadPageWidget.update(context);
      }
    });

    registerListener(R.string.pref_popup_enabled_key, new PreferenceChangeListener(){
      @Override
      public void preferenceChanged(String key, Object newVal) {
        CadPageWidget.update(context);
      }
    });
  }
  
  private void registerListener(int resId, PreferenceChangeListener listener) {
    listenerMap.put(context.getString(resId), listener);
  }
  
  protected Object getPreference(int resPrefId) {
    return mPrefs.getAll().get(context.getString(resPrefId));
  }
  
  protected boolean getBoolean(int resPrefId) {
    return mPrefs.getBoolean(context.getString(resPrefId), false);
  }
  
  protected String getString(int resPrefId) {
    String result = mPrefs.getString(context.getString(resPrefId), null);
    if (result == null) throw new RuntimeException("No configured preference value found");
    return result;
  }

  protected String getString(int resPrefId, int resDefaultId) {
    return mPrefs.getString(context.getString(resPrefId), context.getString(resDefaultId));
  }

  protected String getString(int resPrefId, String defaultVal) {
    return mPrefs.getString(context.getString(resPrefId), defaultVal);
  }
  
  protected int getIntValue(int resPrefId) {
    return getIntValue(resPrefId, 0);
  }
  
  protected int getIntValue(int resPrefId, int defValue) {
    String val = getString(resPrefId, "");
    if (val.length() == 0) return defValue;
    return Integer.parseInt(val);
  }
  
  protected int getInt(int resPrefId, int defValue) {
    return mPrefs.getInt(context.getString(resPrefId), defValue);
  }
  
  protected int getInt(int resPrefId) {
    int result = mPrefs.getInt(context.getString(resPrefId), Integer.MAX_VALUE);
    if (result == Integer.MAX_VALUE) throw new RuntimeException("No configured preference value found");
    return result;
  }
  
  protected long getLong(int resPrefId, long defValue) {
    return mPrefs.getLong(context.getString(resPrefId), defValue);
  }
  
  protected long getLong(int resPrefId) {
    long result = mPrefs.getLong(context.getString(resPrefId), Long.MAX_VALUE);
    if (result == Long.MAX_VALUE) throw new RuntimeException("No configured preference value found");
    return result;
  }
  
  protected float getFloat(int resPrefId, float defValue) {
    return mPrefs.getFloat(context.getString(resPrefId), defValue);
  }
  
  protected float getFloat(int resPrefId) {
    float result = getFloat(resPrefId, Float.MAX_VALUE);
    if (result == Float.MAX_VALUE) throw new RuntimeException("No configured preference value found");
    return result;
  }
  
  protected void putBoolean(int resPrefId, boolean newVal) {
    SharedPreferences.Editor settings = mPrefs.edit();
    String key = context.getString(resPrefId);
    settings.putBoolean(key, newVal);
    settings.commit();
    notifyListeners(key);
  }

  protected void putString(int resPrefId, String newVal) {
    SharedPreferences.Editor settings = mPrefs.edit();
    String key = context.getString(resPrefId);
    settings.putString(key, newVal);
    settings.commit();
    notifyListeners(key);
  }

  protected void putInt(int resPrefId, int newVal) {
    SharedPreferences.Editor settings = mPrefs.edit();
    String key = context.getString(resPrefId);
    settings.putInt(key, newVal);
    settings.commit();
    notifyListeners(key);
  }

  protected void putLong(int resPrefId, long newVal) {
    SharedPreferences.Editor settings = mPrefs.edit();
    String key = context.getString(resPrefId);
    settings.putLong(key, newVal);
    settings.commit();
    notifyListeners(key);
  }
  
  protected void putFloat(int resPrefId, float newVal) {
    SharedPreferences.Editor settings = mPrefs.edit();
    String key = context.getString(resPrefId);
    settings.putFloat(key, newVal);
    settings.commit();
    notifyListeners(key);
  }

  private void notifyListeners(String key) {
    PreferenceChangeListener listener = listenerMap.get(key);
    if (listener != null) {
      listener.preferenceChanged(key, mPrefs.getAll().get(key));
    }
  }
  
}
