package net.anei.cadpage.vendors;

import net.anei.cadpage.C2DMReceiver;
import net.anei.cadpage.HttpService;
import net.anei.cadpage.HttpService.HttpRequest;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import net.anei.cadpage.donation.UserAcctManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

abstract class Vendor {

  private String vendorCode;
  private int titleId;
  private int summaryId;
  private int textId;
  private int iconId;
  private Uri baseURI;
  private String triggerCode;
  
  private SharedPreferences prefs;
  
  // True if vendor is active (ie has successfully registered with server
  private boolean enabled = false;
  
  // True if we are in processing of registering with vendor server
  private boolean inProgress = false;
  
  // Account and security token used to identify user account to vendor
  private String account;
  private String token;
  
  // Vendor Activity that may need to be updated when status changes
  private VendorActivity activity;
  
  
  Vendor(int titleId, int summaryId, int textId, int iconId, 
         String urlString, String triggerCode) {
    
    // Calculate vendor code by stripping "Vendor" off the end of the class name
    String clsName = this.getClass().getName();
    int pt = clsName.lastIndexOf('.');
    clsName = clsName.substring(pt+1);
    pt = clsName.indexOf("Vendor");
    vendorCode = clsName.substring(0,pt);
    
    this.titleId = titleId;
    this.summaryId = summaryId;
    this.textId = textId;
    this.iconId = iconId;
    this.baseURI = Uri.parse(urlString);
    this.triggerCode = triggerCode;
  }
  
  /**
   * @return resource ID of text string name of this vendor
   */
  int getTitleId() {
    return titleId;
  }

  /**
   * @return resource ID of text summary description of this vendor
   */
  int getSummaryId() {
    return summaryId;
  }
  
  /**
   * @return vendor text description resource ID
   */
  int getTextId() {
    return textId;
  }
  
  /**
   * @return vendor Icon resource ID
   */
  int getIconId() {
    return iconId;
  }
  
  /**
   * @return vendor code by which this vendor is recognized
   */
  String getVendorCode() {
    return vendorCode;
  }
  
  /**
   * @return trigger code at beginning of SMS text page that identifies this vendor
   */
  String getTrigerCode() {
    return triggerCode;
  }
  
  /**
   * Register Activity assoicated with this vendor
   * @param activity vendor activity
   */
  void registerActivity(VendorActivity activity) {
    this.activity = activity;
  }
  
  /**
   * Perform initial setup that requires a context
   * @param context current context
   */
  void setup(Context context) {
    prefs = context.getSharedPreferences(vendorCode + "Vendor", Context.MODE_PRIVATE);
    enabled = prefs.getBoolean("enabled", false);
    account = prefs.getString("account", null);
    token = prefs.getString("token", null);
  }
  
  /**
   * Save the critical status members to persistant storage
   */
  private void saveStatus() {
    SharedPreferences.Editor editor = prefs.edit();
    editor.putBoolean("enabled", enabled);
    editor.putString("account", account);
    editor.putString("token", token);
    editor.commit();
  }
  
  /**
   * Append vendor status info to logging buffer 
   * @param sb String buffer accumulated log information
   */
  void addStatusInfo(StringBuffer sb) {
    sb.append("\n\nVendor:" + vendorCode);
    sb.append("\nenabled:" + enabled);
    if (enabled) {
      sb.append("\naccount:" + account);
      sb.append("\ntoken:" + token);
    }
  }

  /**
   * @return enabled status of vendor
   */
  boolean isEnabled() {
    return enabled;
  }

  /**
   * set enabled status of vendor
   * @param enabled new enabled status
   */
  void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  /**
   * Process user request for more information about vendor
   * @param vendorActivity
   */
  void moreInfoReq(VendorActivity vendorActivity) {
    Uri uri = baseURI.buildUpon().appendQueryParameter("req", "info").build();
    viewPage(vendorActivity, uri);
  }

  void registerReq(VendorActivity vendorActivity) {
    
    // Set registration in progress flag
    inProgress = true;
    
    // See if we already have a registration ID, if we do, use it to send
    // registration request to vendor server
    String regId = ManagePreferences.registrationId();
    if (regId != null) {
      registerC2DMId(vendorActivity, regId);
    }
    
    // If we don't request one and and send the request to the server when
    // it comes back in
    else {
      C2DMReceiver.register(vendorActivity);
    }
  }

  /**
   * Process user request to unregister from this service
   * @param context current context
   */
  void unregisterReq(Context context) {
    
    // Disable access and save that status change
    enabled = false;
    saveStatus();
    
    // Send an unregister request to the vendor server
    // we really don't care how it responds
    Uri uri = buildRequestUri("unregister", ManagePreferences.registrationId());
    HttpService.addHttpRequest(context, new HttpRequest(uri){
      @Override
      public void processResponse(int status, String result) {}
    });
    
    // Finally unregister from Google C2DM service.  If there are other vendor
    // services that are still active, they will request a new registration ID
    C2DMReceiver.unregister(context);
  }
  
  /**
   * Called when a new or changed C2DM registration ID is reported
   * @param context current context
   * @param registrationId registration ID
   */
  void registerC2DMId(final Context context, String registrationId) {
    
    // If we are in process of registering with server, send the web registration request
    if (inProgress) {
      Uri uri = buildRequestUri("register", registrationId);
      viewPage(context, uri);
      inProgress = false;
    }
    
    // Otherwise, if we are registered with this server, pass the new registration
    // ID to them
    else if (enabled) {
      Uri uri = buildRequestUri("reregister", registrationId);
      HttpService.addHttpRequest(context, new HttpService.HttpRequest(uri){
        @Override
        public void processResponse(int status, String result) {
          
          // If response was successful, we don't care about any details
          if (status % 100 == 2) return;
          showNotice(context, R.string.vendor_register_err_msg, result);
          
          // Otherwise, tell the user we have lost contact with this vendor
          
        }});            
    }
  }

  /**
   * Handle vendor register/unregister request
   * @param context current context
   * @param type REGISTER/UNREGISTER request type
   * @param account vendor account
   * @param token vendor security token
   */
  void vendorRequest(Context context, String type, String account, String token) {
    
    boolean register = type.equals("REGISTER");
    
    boolean change = (this.enabled != register);
    this.enabled = register;
    this.account = account;
    this.token = token;
    saveStatus();
    
    if (change) {
      if (activity != null) activity.update();
      showNotice(context, register ? R.string.vendor_connect_msg : R.string.vendor_disconnect_msg, null);
      if (! register) C2DMReceiver.unregister(context);
    }
  }

  /**
   * Build a request URI
   * @param req request type
   * @param registrationId registration ID
   * @return request URI
   */
  private Uri buildRequestUri(String req, String registrationId) {
    String phone = UserAcctManager.instance().getPhoneNumber();
    Uri.Builder builder = baseURI.buildUpon();
    builder = builder.appendQueryParameter("req", req);
    if (account != null) builder = builder.appendQueryParameter("account", account);
    if (token != null) builder = builder.appendQueryParameter("token", token);
    if (phone != null) builder = builder.appendQueryParameter("phone", phone);
    if (registrationId != null) builder = builder.appendQueryParameter("CadpageRegId", registrationId);
    return builder.build();
  }
  
  /**
   * Display direct paging notification to user
   * @param context current context
   * @param msgId message resource ID
   */
  private void showNotice(Context context, int msgId, String extra) {
    String title = context.getString(titleId);
    String message = context.getString(msgId, title, extra);
    NoticeActivity.showNotice(context, message);
  }
  
  /**
   * Display selected URI in web viewer
   * @param context current context
   * @param uri URI to be displayed
   */
  private void viewPage(Context context, Uri uri) {
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    context.startActivity(intent);
  }
}
