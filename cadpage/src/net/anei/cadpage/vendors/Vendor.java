package net.anei.cadpage.vendors;

import java.text.DateFormat;
import java.util.Date;

import net.anei.cadpage.C2DMService;
import net.anei.cadpage.CadPageApplication;
import net.anei.cadpage.ContentQuery;
import net.anei.cadpage.EmailDeveloperActivity;
import net.anei.cadpage.HttpService;
import net.anei.cadpage.Log;
import net.anei.cadpage.NoticeActivity;
import net.anei.cadpage.SmsPopupUtils;
import net.anei.cadpage.HttpService.HttpRequest;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import net.anei.cadpage.donation.DonationManager;
import net.anei.cadpage.donation.MainDonateEvent;
import net.anei.cadpage.donation.PagingProfileEvent;
import net.anei.cadpage.donation.UserAcctManager;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import net.anei.cadpage.BroadcastBindings;

abstract class Vendor {

  // Vendor accounts go inactive if no alerts are received
  // within 60 days of last alert, or if no alert received
  // within 30 days of last successful registration
  private static final long ONE_DAY_MSECS = 24*60*60*1000;
  private static final long LAST_CONTACT_TIMEOUT = 60*ONE_DAY_MSECS;
  private static final long LAST_REGISTER_TIMEOUT = 30*ONE_DAY_MSECS;

  private String vendorCode;
  private int titleId;
  private int summaryId;
  private int textId;
  private int iconId;
  private int logoId;
  private Uri baseURI;
  private String triggerCode;
  private String supportEmail;
  
  private String title = null;
  
  private Uri discoverUri = null;;
  
  private SharedPreferences prefs;
  
  // True if vendor is active (ie has successfully registered with server
  private boolean enabled = false;
  
  // True if we have have identified text pages coming from this vendor
  private boolean textPage = false;
  
  // When user asks to disable text page checking, it only works until they
  // install the next release.  The disabled release ID is stored here
  private boolean disableTextPageCheck = false;
  
  // True if we are in processing of registering with vendor server
  private boolean inProgress = false;
  
  // dispatch email address
  private String emailAddress = null;
  
  // Account and security token used to identify user account to vendor
  private String account;
  private String token;
  
  private boolean inactive = false;
  
  // Vendor preference that may need to be updated when status changes
  private VendorPreference preference = null;
  
  // Vendor Activity that may need to be updated when status changes
  private VendorActivity activity = null;
  
  // Client version code
  private String clientVersion = null;
  
  
  Vendor(int titleId, int summaryId, int textId, int iconId, int logoId,
         String urlString, String triggerCode, String supportEmail) {
    
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
    this.logoId = logoId; 
    this.baseURI = Uri.parse(urlString);
    this.triggerCode = triggerCode;
    this.supportEmail = supportEmail;
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
   * @return vendor logo resource ID
   */
  int getLogoId() {
    return logoId;
  }
  
  /**
   * @return vendor code by which this vendor is recognized
   */
  String getVendorCode() {
    return vendorCode;
  }
  
  /**
   * @param request type of request this will be used for
   * @return base vendor URI that we use to communicate with this vendor
   */
  Uri getBaseURI(String req) {
    return getBaseURI();
  }
  
  /**
   * @return base vendor URI that we use to communicate with this vendor
   */
  Uri getBaseURI() {
    return baseURI;
  }
  
  /**
   * @return trigger code at beginning of SMS text page that identifies this vendor
   */
  String getTrigerCode() {
    return triggerCode;
  }
  
  /**
   * Determine if the sender address of a messages indicates that it originated with this vendor
   * @param address  message sender addres
   * @return true if this address is associated with this vendor
   */
  boolean isVendorAddress(String address) {
    // Always return false.  Vendor classes usually override this to add their own logic
    return false;
  }
  
  /**
   * @return dispatch email address
   */
  String getEmailAddress() {
    return emailAddress;
  }
  
  /**
   * @return email email address
   */
  String getSupportEmail() {
    return supportEmail;
  }

  /**
   * get custom response menu for a given index
   * @param index requested index
   * @return custom response menu if defined, null otherwise
   */
  String getResponseMenu(int index) {
    return null;
  }

  /**
   * @return true if users registered with this vendor are sponsored by the agency
   */
  boolean isSponsored() {
    return false;
  }
  
  /**
   * @return true if service is up and running and should be available for everyone,
   * false if should only be available for developers
   */
  boolean isAvailable() {
    return false;
  }
  
  /**
   * @return interface version id - generally used to determine which response menus are available
   */
  int getVersion() {
    return 2;
  }
  
  /**
   * @return client version code
   */
  String getClientVersion() {
    if (clientVersion == null) {
      clientVersion = "" + getVersion() + "-" + CadPageApplication.getVersionCode();
    }
    return clientVersion;
  }
  
  /**
   * @return true if user is allowed to set up a button configuration with no More Info button
   */
  public boolean infoButtonOptional() {
    return false;
  }

  /**
   * Return vendor specific text label to use for the More Info button
   * @return resource ID of button title or 0 if not specified
   */
  int getMoreInfoResId() {
    return 0;
  }

  /**
   * Send a reset email address request
   * @param context current context
   */
  void resetEmailReq(Context context) {
    Uri uri = buildRequestUri("reset", ManagePreferences.registrationId());
    HttpService.addHttpRequest(context, new HttpRequest(uri){

      @Override
      protected void processBody(String content) {
        if (content.startsWith("200 ")) {
          emailAddress = content.substring(4).trim();
          saveStatus();
          PagingProfileEvent.instance().open(CadPageApplication.getContext());
        }
      }
    });
  }

  /**
   * Register VendorPreference associated with this vendor
   * @param preference Vendor preference object
   */
  void registerPreference(VendorPreference preference) {
    this.preference = preference;
  }
  
  /**
   * Register Activity associated with this vendor
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
    title = context.getString(titleId);
    prefs = context.getSharedPreferences(vendorCode + "Vendor", Context.MODE_PRIVATE);
    enabled = prefs.getBoolean("enabled", false);
    account = prefs.getString("account", null);
    token = prefs.getString("token", null);
    emailAddress = prefs.getString("dispatchEmail", null);
    
    textPage = prefs.getBoolean("textPage", false);
    disableTextPageCheck = prefs.getBoolean("disableTextPageCheck", false);
    
    inactive = prefs.getBoolean("inactive", false);
    
    if (enabled) {
      long registerTime = prefs.getLong("lastRegisterTime", 0L);
      long lastTime = prefs.getLong("lastContactTime", 0L);
      if (registerTime == 0 && lastTime == 0) updateLastRegisterTime();
    }
    
    // See if we need to switch vendor to inactive status
    if (enabled) {
      if (isActiveSponsor(account, token)) {
        if (inactive) {
          inactive = false;
          saveStatus();
        }
      }
      
      else if (!inactive) {
        long curTime = new Date().getTime();
        long expTime = 0L;
        long tmp = prefs.getLong("lastContactTime", 0L);
        if (tmp > 0L) expTime = tmp + LAST_CONTACT_TIMEOUT;
        else {
          tmp = prefs.getLong("lastRegisterTime",  0L);
          if (tmp > 0L) expTime = tmp + LAST_REGISTER_TIMEOUT;
        }
        if (expTime > 0L && curTime > expTime) {
          inactive = true;
          saveStatus();
          
          // If this is a sponsored vendor, going inactive may drop the sponsored
          // payment status, so reset the demo period to give them another 30 days
          // for an alert to come in.
          if (isSponsored()) {
            ManagePreferences.setAuthRunDays(0);
          }
        }
      }
    }
    
    publishAccountInfo(context);
  }
  
  /**
   * @param account account information
   * @param token token information
   * @return true if confirmed active sponsor
   */
  protected boolean isActiveSponsor(String account, String token) {
    return false;
  }

  /**
   * @return Name of sponsoring agency if an active vendor is sponsoring Cadpage
   */
  String getSponsor() {
    if (isSponsored() && isEnabled() && !isInactive()) return title;
    return null;
  }
  
  /**
   * @return Name of sponsoring agency if an inactive vendor is sponsoring Cadpage
   */
  String getInactiveSponsor() {
    if (isSponsored() && isEnabled() && isInactive()) return title;
    return null;
  }
  
  /**
   * Save the critical status members to persistent storage
   */
  private void saveStatus() {
    SharedPreferences.Editor editor = prefs.edit();
    editor.putBoolean("enabled", enabled);
    editor.putString("account", account);
    editor.putString("token", token);
    editor.putString("dispatchEmail", emailAddress);
    editor.putBoolean("inactive", inactive);
    editor.commit();
  }
  
  /**
   * Check to see if this is a vendor generated test message
   * @param msg received alert message
   * @return true if this is a vendor generated test message
   */
  protected boolean isTestMsg(String msg) {
    return false;
  }
  
  void updateLastContactTime(String msg) {
    
    if (msg != null && isTestMsg(msg)) return;
    
    SharedPreferences.Editor editor = prefs.edit();
    editor.putLong("lastContactTime", new Date().getTime()); 
    boolean reactivate = inactive;
    if (reactivate) {
      inactive = false;
      editor.putBoolean("inactive", inactive);
    }
    editor.commit();
    
    if (reactivate) reportStatusChange();
  }
  
  void updateLastRegisterTime() {
    SharedPreferences.Editor editor = prefs.edit();
    editor.putLong("lastRegisterTime", new Date().getTime());
    editor.putLong("lastContactTime", 0L);
    editor.commit();
  }
  
  /**
   * Set the text page received flag to selected value
   * @param textPage new value
   */
  void setTextPage(boolean textPage) {
    if (enabled) return;
    if (textPage == this.textPage) return;
    this.textPage = textPage;
    SharedPreferences.Editor editor = prefs.edit();
    editor.putBoolean("textPage", textPage);
    editor.commit();
  }
  
  /**
   * Called when users asks us not to bug them about text paging status
   */
  void setDisableTextPageCheck(boolean disableTextPageCheck) {
    if (disableTextPageCheck == this.disableTextPageCheck) return;
    if (disableTextPageCheck && !textPage) return;
    this.disableTextPageCheck = disableTextPageCheck;
    SharedPreferences.Editor editor = prefs.edit();
    if (textPage) {
      textPage = false;
      editor.putBoolean("textPage", textPage);
    }
    editor.putBoolean("disableTextPageCheck", disableTextPageCheck);
    editor.commit();
  }
  
  /**
   * Append vendor status info to logging buffer 
   * @param sb String buffer accumulated log information
   */
  void addStatusInfo(StringBuilder sb) {
    sb.append("\n\nVendor:" + vendorCode);
    sb.append("\nenabled:" + enabled);
    sb.append("\ninactive:" + inactive);
    sb.append("\ntextPage:" + textPage);
    sb.append("\ndisableTextPageCheck:" + disableTextPageCheck);
    sb.append("\naccount:" + account);
    sb.append("\ntoken:" + token);
    if (emailAddress != null) sb.append("\ndispatchEmail:" + emailAddress);
    
    long lastContactTime = prefs.getLong("lastContactTime", 0L);
    String timeStr = "NEVER";
    if (lastContactTime > 0) {
      timeStr = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date(lastContactTime));
    }
    sb.append("\nlastContactTime:" + timeStr);
    
    long lastRegisterTime = prefs.getLong("lastRegisterTime", 0L);
    timeStr = "NEVER";
    if (lastRegisterTime > 0) {
      timeStr = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date(lastRegisterTime));
    }
    sb.append("\nlastRegisterTime:" + timeStr);
  }

  /**
   * @return enabled status of vendor
   */
  boolean isEnabled() {
    return enabled;
  }
  
  /**
   * @return inactive status of vendor
   */
  boolean isInactive() {
    return inactive;
  }
  
  /**
   * @param status context of request
   *         0 - return raw status
   *         1 - should we show startup register screen
   *         2 - should we show register screen in donation menus
   * @return text page status of vendor
   */
  boolean isTextPage(int status) {
    
    // If we haven't see a text page then the answer is always no
    if (!textPage) return false;
    
    // If vendor is enabled, answer is always no
    if (enabled) return false;
    
    // If startup request, return true unless user has asked us not to
    if (status == 1) return !disableTextPageCheck;
    
    // If donation menu, return true if vendor is sponsored
    if (status == 2) return isSponsored();
    
    // Otherwise, always return true
    return true;
  }

  /**
   * Process user request for more information about vendor
   * @param context current context
   */
  void moreInfoReq(Context context) {
    if (!SmsPopupUtils.haveNet(context)) return;
    Uri uri = getBaseURI("info").buildUpon().appendQueryParameter("req", "info").build();
    viewPage(context, uri);
  }

  /**
   * Process user request vendor user profile
   * @param context current context
   */
  void profileReq(Activity context) {
    if (!SmsPopupUtils.haveNet(context)) return;
    Uri uri = buildRequestUri("profile", ManagePreferences.registrationId());
    viewPage(context, uri);
  }

  /**
   * Process user request to register with vendor
   * @param context Current context
   */
  void registerReq(Context context) {
    registerReq(context, null);
  }

  /**
   * Process vendor discovery request
   * @param context current context
   * @param uri URI included in discover request or null if user request
   */
  void registerReq(Context context, Uri uri) {
    
    // If already enabled, we don't have to do anything
    if (enabled) {
      sendReregister(context, ManagePreferences.registrationId(), true, false);
      return;
    }

    // Make sure we have network connectivity
    if (!SmsPopupUtils.haveNet(context)) return;
    
    // Turn on direct paging error reporting
    ManagePreferences.setDirectPageActive(true);

    // Set registration in progress flag
    // and save the discovery URI
    inProgress = true;
    discoverUri = uri;
    
    // See if we already have a registration ID, if we do, use it to send
    // registration request to vendor server
    // But we also will refresh the registration ID, just in case it has
    // gotten stale from long periods of unuse.
    String regId = ManagePreferences.registrationId();
    if (regId != null) {
      registerC2DMId(context, regId, true, false);
      C2DMService.register(context, true);
    }
    
    // If we don't request one and and send the request to the server when
    // it comes back in
    else {
      if (!C2DMService.register(context, uri != null)) showNotice(context, R.string.vendor_reg_failure_msg, null);
    }
  }

  /**
   * Process user request to unregister from this service
   * @param context current context
   */
  void unregisterReq(Context context) {
    
    if (!enabled) return;
    
    Log.v("User initiated disconnect from " + title);
    
    // Disable access and save that status change
    enabled = false;
    saveStatus();
    reportStatusChange();
    
    // Send an unregister request to the vendor server
    // we really don't care how it responds
    Uri uri = buildRequestUri("unregister", ManagePreferences.registrationId(), true);
    HttpService.addHttpRequest(context, new HttpRequest(uri){});
    
    // Finally unregister from Google C2DM service.  If there are other vendor
    // services that are still active, they will request a new registration ID
    C2DMService.unregister(context);

    // If the user is loosing a sponsored payment status, reset the 30 day evaluation period
    if (isSponsored()) {
      ManagePreferences.setAuthRunDays(0);
      DonationManager.instance().reset();
      MainDonateEvent.instance().refreshStatus();
    }
  }
  
  /**
   * Called when a new or changed C2DM registration ID is reported
   * @param context current context
   * @param registrationId registration ID
   * @param userReq true if user requested this action
   * @param transfer cadpage configuration has been transfered from another device
   * @return true if we actually did anything
   */
  boolean registerC2DMId(final Context context, String registrationId, boolean userReq, boolean transfer) {
    
    // If we are in process of registering with server, send the web registration request
    if (inProgress) {
      
      sendRegisterReq(context, registrationId);
      inProgress = false;
      discoverUri = null;
      return true;
    }
    
    // Otherwise, if we are registered with this server, pass the new registration
    // ID to them
    else if (enabled) {
      sendReregister(context, registrationId, userReq, transfer);
      return true;
    }
    
    // Otherwise we have nothing to do
    return false;
  }

  /**
   * Send C2DM Register request to vendor server
   * @param context current context
   * @param registrationId registration ID
   */
  void sendRegisterReq(final Context context, String registrationId) {
    // If we got a discovery URI from the vendor, send directly to that
    // It isn't our problem if it isn't accepted
    if (discoverUri != null) {
      Uri uri = discoverUri.buildUpon()
          .appendQueryParameter("type", "GCM")
          .appendQueryParameter("CadpageRegId", registrationId)
          .build();
      HttpService.addHttpRequest(context, new HttpRequest(uri){});
    } 
    
    // Otherwise build a registration URL and display it in the web browser 
    else {
      Uri uri = buildRequestUri("register", registrationId);
      viewPage(context, uri);
    }
  }

  /**
   * Check that a vendor from whom we have received a direct page is really fully
   * registered
   */
  boolean checkVendorStatus(Context context) {
    return true;
  }
  
  /**
   * Send reregister request to vendor
   * @param context current context
   * @param registrationId registration ID
   * @param userReq true if user requested this action
   * @param transfer cadpage configuration has been transfered from another device
   */
  private void sendReregister(final Context context, String registrationId, boolean userReq, boolean transfer) {
    Uri uri = buildRequestUri("reregister", registrationId, userReq);
    Uri.Builder b = uri.buildUpon();
    b.appendQueryParameter("userReq", (userReq ? "Y" : "N"));
    if (transfer) b.appendQueryParameter("transfer", "Y");
    uri = b.build();
    HttpService.addHttpRequest(context, new HttpService.HttpRequest(uri){
      
      @Override
      protected void processContent(String content) {
        processError(200, null);
      }

      @Override
      public void processError(int status, String result) {
        
        // Don't know what negative result means, but lets ignore it
        if (status < 0) return;
        
        // A 299 response indicates that the server has been having trouble with our registration ID
        // and we should request another one.
        if (status == 299) C2DMService.register(context, true);
        
        // A 400 request indicates that the device we have tried to register is no longer valid
        if (status == 400) {
          enabled = false;
          saveStatus();
          reportStatusChange();
        }
        
        // That is all we have to do.  The GCM protocol, it has it's own way of 
        // getting the new registration ID to our servers.  So we don't have to do anything 
        // drastic if the reregister request fails
        return;
      }});
  }

  /**
   * Handle vendor register/unregister request
   * @param context current context
   * @param type REGISTER/UNREGISTER request type
   * @param account vendor account
   * @param token vendor security token
   * @param emailAddress dispatch Email address
   */
  void vendorRequest(Context context, String type, String account, String token, String emailAddress) {
    
    boolean register = type.equals("REGISTER");
    boolean change = (this.enabled != register);
    boolean changeEmail = (emailAddress != null && !emailAddress.equals(this.emailAddress));
    this.enabled = register;
    if (register) this.inactive = false;
    this.account = account;
    this.token = token;
    this.emailAddress = emailAddress;
    saveStatus();
    if (enabled) publishAccountInfo(context);
    
    boolean showProfile = (enabled && changeEmail); 
    if (showProfile) PagingProfileEvent.instance().open(context);
    if (change) {
      reportStatusChange();
      if (!showProfile) showNotice(context, register ? R.string.vendor_connect_msg : R.string.vendor_disconnect_msg, null);
      if (register) {
        setTextPage(false);
        updateLastRegisterTime();
      }
      else {
        C2DMService.unregister(context);
        ManagePreferences.setAuthRunDays(0);
        DonationManager.instance().reset();
        MainDonateEvent.instance().refreshStatus();
      }
      
      if (!register) EmailDeveloperActivity.logSnapshot(context, "Vendor initiated disconnect");
    }
  }
  
  void publishAccountInfo(Context context) {
    if (!enabled) return;
    Intent intent = new Intent("net.anei.cadpage.ACCOUNT_INFO." + vendorCode);
    intent.putExtra("account", account);
    intent.putExtra("token", token);
    Log.w("Publish Account Info");
    ContentQuery.dumpIntent(intent);
    context.sendBroadcast(intent, BroadcastBindings.PERMISSION);
  }

  /**
   * Perform any vendor specific location code conversions
   * @param location location code
   * @return two element string array.  First element contains the converted
   * location code.  The second lists any parser elements that could not be
   * converted
   */
  String[] convertLocationCode(String location) {
    return new String[]{location, null};
  }
  
  /**
   * Update Cadpage services status.
   * Called when either the activation status or expiration date has changed
   * and should be reported to servers
   * @param context current context
   */
  void updateCadpageStatus(Context context) {
  }
  
  /**
   * Called when a direct page alert is received to determine if we are in
   * a consistent state when messages should be received
   * @param context current context
   * @return true if everything is OK, false if message should be suppressed.
   */
  boolean checkPagingStatus(Context context) {
    return true;
  }

  /**
   * Report enabled status change to all interested parties
   */
  private void reportStatusChange() {
    CadPageApplication.runOnMainThread(new Runnable(){
      @Override
      public void run() {
        DonationManager.instance().reset();
        MainDonateEvent.instance().refreshStatus();
        
        if (preference != null) preference.update();
        if (activity != null) activity.update();
     }
    });
  }

  /**
   * Build a request URI
   * @param req request type
   * @param registrationId registration ID
   * @return request URI
   */
  protected Uri buildRequestUri(String req, String registrationId) {
    return buildRequestUri(req, registrationId, false);
  }

  /**
   * Build a request URI
   * @param req request type
   * @param registrationId registration ID
   * @param force force account and token information to be included even when
   * vendor is not currently registered
   * @return request URI
   */
  private Uri buildRequestUri(String req, String registrationId, boolean force) {

    String phone = UserAcctManager.instance().getPhoneNumber();
    Uri.Builder builder = getBaseURI(req).buildUpon();
    builder = builder.appendQueryParameter("req", req);
    builder = builder.appendQueryParameter("vendor", getVendorCode());
    if (force || enabled) builder = addAccountInfo(builder);
    if (phone != null) builder = builder.appendQueryParameter("phone", phone);
    builder = builder.appendQueryParameter("type", "GCM");
    if (registrationId != null) builder = builder.appendQueryParameter("CadpageRegId", registrationId);
    builder.appendQueryParameter("version", getClientVersion());
    
    // Add random seed to register request to defeat any browser cache
    if (req.equals("register")) builder = builder.appendQueryParameter("seed", "" + System.currentTimeMillis() % 10000);
    return builder.build();
  }
  
  /**
   * Add user account identification to Uri under construction
   * @param builder URI builder
   * @return updated URI builder
   */
  Uri.Builder addAccountInfo(Uri.Builder builder) {
    if (account != null) builder = builder.appendQueryParameter("account", account);
    if (token != null) builder = builder.appendQueryParameter("token", token);
    return builder;
  }
  
  /**
   * Display direct paging notification to user
   * @param context current context
   * @param msgId message resource ID
   */
  private void showNotice(Context context, int msgId, String extra) {
    String title = context.getString(titleId);
    String message = context.getString(msgId, title, extra);
    NoticeActivity.showVendorNotice(context, message);
  }
  
  /**
   * Display selected URI in web viewer
   * @param context current context
   * @param uri URI to be displayed
   */
  private void viewPage(Context context, Uri uri) {
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    Log.w("View web page");
    ContentQuery.dumpIntent(intent);
    try {
      context.startActivity(intent);
    } catch (ActivityNotFoundException ex) {
      showNotice(context, R.string.vendor_no_web_viewer_error, null);
    }
  }
}
