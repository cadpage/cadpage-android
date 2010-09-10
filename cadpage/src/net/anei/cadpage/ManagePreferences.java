package net.anei.cadpage;

import net.anei.cadpage.preferences.ButtonListPreference;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ManagePreferences {
  
  private static ManagePreferences prefs;

  /**
   * Initialize the ManagePreferences class
   * @param context
   */
  public static void setupPreferences(Context context) {
    prefs = new ManagePreferences(context);
  }
  
  /**
   * @return value of UseGoogleMappApp preference
   */
  public static boolean useGoogleMapApp() {
    return prefs.getBoolean(R.string.pref_useGoogleMapApp_key);
  }
  
  public static boolean privacyMode() {
    return prefs.getBoolean(R.string.pref_privacy_key);
  }
  
  public static String location() {
    return prefs.getString(R.string.pref_location);
  }
  
  public static boolean autoRotate() {
    return prefs.getBoolean(R.string.pref_autorotate_key);
  }
  
  public static String filter() {
    return prefs.getString(R.string.pref_filter_key);
  }

  
  
  
  private Context context;
  private SharedPreferences mPrefs;
  
  /**
   * private constructor
   * @param _context context
   */
  private ManagePreferences(Context _context) {
    context = _context;
    mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
  }
  
  private boolean getBoolean(int resPrefId) {
    return mPrefs.getBoolean(context.getString(resPrefId), false);
  }
  
  private String getString(int resPrefId) {
    String result = mPrefs.getString(context.getString(resPrefId), null);
    if (result == null) throw new RuntimeException("No configured preference value found");
    return result;
  }

  /*
   * Define all default preferences in this static class.  Unfortunately these are also
   * stored in the resource xml files for use by the preference xml so they should be
   * updated in both places if a change is required.
   * 
   * All of this is deprecated. New logic doesn't code defaults that would only
   * take effect if the code requests a preference for an ID that isn't defined
   * in the preference configuration.  New static method logic tries to throw
   * an exception if this situation occurs.
   * 
   */
  public static final class Defaults {
    public static final boolean PREFS_SHOW_BUTTONS = true;
    public static final String PREFS_BUTTON1 = String.valueOf(ButtonListPreference.BUTTON_MAP);
    public static final String PREFS_BUTTON2 = String.valueOf(ButtonListPreference.BUTTON_DELETE);
    public static final String PREFS_BUTTON3 = String.valueOf(ButtonListPreference.BUTTON_CLOSE);
    public static final boolean PREFS_SHOW_POPUP = true;
    public static final boolean PREFS_ONLY_SHOW_ON_KEYGUARD = false;
    public static final boolean PREFS_NOTIF_ENABLED = true;
    public static final boolean PREFS_NOTIF_OVERRIDE = false;
    public static final boolean PREFS_VIBRATE_ENABLED = true;
    public static final String PREFS_VIBRATE_PATTERN = "0,1200";
    public static final boolean PREFS_LED_ENABLED = true;
    public static final String PREFS_LED_PATTERN = "1000,1000";
    public static final String PREFS_LED_COLOR = "Yellow";
    public static final boolean PREFS_REPLY_TO_THREAD = true;
  }
  
  // All of the following methods are deprecated, but we only officially
  // flag the constructor

  /**
   * @deprecated - Preferred alternatives is to set up and use the static methods
   * to retrieve preference values 
   */
  public ManagePreferences(Context _context, String _contactId) {
    this(_context);
  }

  public boolean getBoolean(int resPrefId, int resDefaultId, int dbColumnNum) {
    return getBoolean(resPrefId, resDefaultId);
  }

  public boolean getBoolean(int resPrefId, boolean prefDefault, int dbColumnNum) {
    return getBoolean(resPrefId, prefDefault);
  }

  public boolean getBoolean(int resPrefId, int resDefaultId) {
    return mPrefs.getBoolean(context.getString(resPrefId),
        Boolean.parseBoolean(context.getString(resDefaultId)));
  }

  public boolean getBoolean(int resPrefId, boolean prefDefault) {
    return mPrefs.getBoolean(context.getString(resPrefId), prefDefault);
  }

  public String getString(int resPrefId, int resDefaultId, int dbColumnNum) {
    return getString(resPrefId, resDefaultId);
  }

  public String getString(int resPrefId, String defaultVal, int dbColumnNum) {
    return mPrefs.getString(context.getString(resPrefId), defaultVal);
  }

  public String getString(int resPrefId, int resDefaultId) {
    return mPrefs.getString(context.getString(resPrefId), context.getString(resDefaultId));
  }

  public String getString(int resPrefId, String defaultVal) {
    return mPrefs.getString(context.getString(resPrefId), defaultVal);
  }

  public void putString(int resPrefId, String newVal, String dbColumnNum) {
    SharedPreferences.Editor settings = mPrefs.edit();
    settings.putString(context.getString(resPrefId), newVal);
    settings.commit();
  }

  public int getInt(String pref, int defaultVal) {
    return mPrefs.getInt(pref, defaultVal);
  }

  public void close() {}
}
