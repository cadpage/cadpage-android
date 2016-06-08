package net.anei.cadpage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import net.anei.cadpage.HttpService.HttpRequest;
import net.anei.cadpage.donation.DonationManager;
import net.anei.cadpage.donation.UserAcctManager;
import net.anei.cadpage.donation.DonationManager.DonationStatus;
import net.anei.cadpage.vendors.VendorManager;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.os.SystemClock;

public class C2DMService extends IntentService {
  
  // Minimum and maximum time periods we will delay before asking Google's overloaded server
  // for another registration ID
  private static final int INIT_REREGISTER_DELAY = 3000;  // 3 seconds
  private static final int MAX_REREGISTER_DELAY = 3600000;  // 1 Hour
  
  // Refresh ID timeout.  We will automatically request a new registration ID if
  // nothing is received for this amount of time
  private static final int REFRESH_ID_TIMEOUT = 24*60*60*1000; // 1 day
  private static final int REGISTER_LOCK_TIMEOUT = 60*1000;    // 1 min
  
  private static final String GSF_PACKAGE = "com.google.android.gsf";
  private static final String ACTION_C2DM_REGISTER = "com.google.android.c2dm.intent.REGISTER";
  private static final String ACTION_C2DM_UNREGISTER = "com.google.android.c2dm.intent.UNREGISTER";
  private static final String ACTION_C2DM_REGISTERED = "com.google.android.c2dm.intent.REGISTRATION";
  private static final String ACTION_C2DM_RECEIVE = "com.google.android.c2dm.intent.RECEIVE";
  private static final String ACTION_RETRY_REGISTER = "net.anei.cadpage.RETRY_REGISTER";
  private static final String ACTION_REFRESH_ID = "net.anei.cadpage.REFRESH_ID";
  private static final String GCM_PROJECT_ID = "1027194726673";

  // wakelock
  private static PowerManager.WakeLock sWakeLock;

  private static final Random RANDOM = new Random();
  
  private static GoogleCloudMessaging gcm = null; 

  public C2DMService() {
    super("C2DMService");
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    if (flags != 0) holdPowerLock(this);
    super.onStartCommand(intent, flags, startId);
    return Service.START_REDELIVER_INTENT;
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    
    Log.v("C2DMService: onHandleIntent()");
    
    if (ACTION_RETRY_REGISTER.equals(intent.getAction())) {
      retryRegisterRequest(intent);
    }
    
    if (isNewGCMActive(this)) {
      String type = getGCM().getMessageType(intent);
      if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(type)) {
        handleMessage(intent);
      }
    }
    
    else {
      
      if (ACTION_C2DM_REGISTERED.equals(intent.getAction())) {
        handleRegistration(intent);
      }
      
      else if (ACTION_C2DM_RECEIVE.equals(intent.getAction())) {
        handleMessage(intent);
      }
    }
  }

  /**
   * Handle registration status intent.  These only happen with the old GCM protocol
   * @param intent received intent
   */
  private void handleRegistration(final Intent intent) {
    
    // Dump intent info
    Log.w("Processing C2DM Registration");
    ContentQuery.dumpIntent(intent);
    
    // VendorManager calls may hit the UI, so we need to jump back to the UI thread
    CadPageApplication.runOnMainThread(new Runnable(){
      @Override
      public void run() {
        
        String error = intent.getStringExtra("error");
        if (error != null) {
          registrationFailure(error);
          return;
        }
        
        String regId = intent.getStringExtra("unregistered");
        if (regId != null) {
          registrationCancelled();
          return;
        }
        
        regId = intent.getStringExtra("registration_id");
        if (regId != null) {
          registrationSuccess(regId);
          return;
        }
      }
    });
  }

  private void handleMessage(final Intent intent) {
    
    try {
      
      // Likewise if Cadpage is disabled
      if (!ManagePreferences.enabled()) return;
      
      // Dump intent info
      Log.w("Processing C2DM Message");
      ContentQuery.dumpIntent(intent);
      
      // Get the vendor code
      String vendorCode = intent.getStringExtra("vendor");
      if (vendorCode == null) vendorCode = intent.getStringExtra("sponsor");
      
      // See what kind of message this is
      String type = intent.getStringExtra("type");
      if (type == null) type = "PAGE";
      
      // Ping just needs to be acknowledged
      if (type.equals("PING")) {
        sendAutoAck(intent, vendorCode);
        VendorManager.instance().checkVendorStatus(this, vendorCode);
        resetRefreshIDTimer(this, "PING");
        return;
      }
      
      // Register and unregister requests are handled by VendorManager
      // which must be done on the main UI thread
      if (type.equals("REGISTER") || type.equals("UNREGISTER")) {
        final String type2 = type;
        final String vendorCode2 = vendorCode;
        final String account = intent.getStringExtra("account");
        final String token = intent.getStringExtra("token");
        final String dispatchEmail = intent.getStringExtra("dispatchEmail");
        CadPageApplication.runOnMainThread(new Runnable(){
          @Override
          public void run() {
            VendorManager.instance().vendorRequest(C2DMService.this, type2, vendorCode2, account, token, dispatchEmail);
          }
        });
        sendAutoAck(intent, vendorCode);
        resetRefreshIDTimer(this, "VENDOR_" + type);
        return;
      }

      // Check vendor enabled status
      if (!VendorManager.instance().checkVendorStatus(this, vendorCode)) return;

      // Save timestamp
      final long timestamp = System.currentTimeMillis();
      
      // Retrieve message content from intent for from URL
      String content = intent.getStringExtra("content");
      if (content != null) {
        processContent(intent, content, timestamp);
        sendAutoAck(intent, vendorCode);
        return;
      }
      
      String contentURL = intent.getStringExtra("content_url");
      if (contentURL != null) {
        HttpService.addHttpRequest(this, new HttpRequest(Uri.parse(contentURL)){
          @Override
          public void processBody(String body) {
            C2DMService.this.processContent(intent, body, timestamp);
          }
        });
        return;
      }
      Log.w("C2DM message has no content");
    }
    
    // Any exceptions that get thrown should be rethrown on the dispatch thread
    catch (final Exception ex) {
      TopExceptionHandler.reportException(ex);
    }
  }
  
  /**
   * Send auto acknowledgment when message is received
   * @param context current context
   * @param intent received intent
   */
  private void sendAutoAck(Intent intent, String vendorCode) {
    String ackURL = intent.getStringExtra("ack_url");
    sendResponseMsg(this, "", ackURL, "AUTO", vendorCode);
  }
    
  private void processContent(Intent intent, String content, long timestamp) {
    
    resetRefreshIDTimer(this, "PAGE");
    
    // Reconstruct message from data from intent fields
    String from = intent.getStringExtra("sender");
    if (from == null) from = intent.getStringExtra("from");
    if (from == null) from = intent.getStringExtra("originally_from");
    if (from == null) from = "GCM";
    String subject = intent.getStringExtra("subject");
    if (subject == null) subject = "";
    String location = intent.getStringExtra("format");
    if (location != null && location.equals("unknown")) location = null;
    
    // Get vendor code
    String vendorCode = intent.getStringExtra("vendor");
    if (vendorCode == null) vendorCode = intent.getStringExtra("sponsor");
    
    // Whatever it is, update vendor contact time
    VendorManager.instance().updateLastContactTime(vendorCode, content);
    
    // Send receive notice to vendor app running on this device
    if (vendorCode != null) {
      String action = "net.anei.cadpage.RECEIVE." + vendorCode;
      Intent sendIntent = new Intent(action);
      Log.w("Broadcasting direct page alert");
      ContentQuery.dumpIntent(sendIntent);
      this.sendBroadcast(sendIntent);
    }
    
    // Get the acknowledge URL and request code
    String ackURL = intent.getStringExtra("ack_url");
    String ackReq = intent.getStringExtra("ack_req");
    if (vendorCode == null && ackURL != null) {
      vendorCode = VendorManager.instance().findVendorCodeFromUrl(ackURL);
    }
    if (ackURL == null) ackReq = null;
    if (ackReq == null) ackReq = "";
    
    String callId = intent.getStringExtra("call_id");
    if (callId == null) callId = intent.getStringExtra("id");
    String serverTime = intent.getStringExtra("unix_time");
    if (serverTime ==  null) serverTime = intent.getStringExtra("unix_timestamp");
    if (serverTime == null) serverTime = intent.getStringExtra("date");
    // agency code = intent.getStringExtra("agency_code");
    String infoUrl = intent.getStringExtra("info_url"); 
    
    // If page includes a server receive time, and page has arrived within
    // a reasonable window of that time, reset the refresh ID timer.
    // If there is no server receive time, always reset the refresh ID timer
    
    final SmsMmsMessage message = 
      new SmsMmsMessage(from, subject, content, timestamp,
                        location, vendorCode, ackReq, ackURL, 
                        callId, serverTime, infoUrl);
    
    // Add to log buffer
    if (!SmsMsgLogBuffer.getInstance().add(message)) return;
    
    // If we are checking for split direct pages, pass this to the message accumulator
    // It will be responsible for calling SmsReceiver.processCadPage()
    if (message.getSplitMsgOptions().splitDirectPage()) {
      SmsMsgAccumulator.instance().addMsg(this, message, true);
    }
    
    // See if the current parser will accept this as a CAD page
    else {
      boolean isPage = message.isPageMsg(SmsMmsMessage.PARSE_FLG_FORCE);
      
      // This should never happen, 
      if (!isPage) return;
      
      // Process the message on the main thread
      SmsReceiver.processCadPage(message);
    }
  }
  
  @Override
  public void onDestroy() {
    Log.v("Shutting down C2DMService");
    if (sWakeLock != null) sWakeLock.release();
  }

  /**
   * Called from the broadcast receiver.
   * <p>
   * Will process the received intent, call handleMessage(), registered(),
   * etc. in background threads, with a wake lock, while keeping the service
   * alive.
   */
  static void runIntentInService(Context context, Intent intent) {

    // The refresh action request is handled by a static method, 
    // so there really is no need to go through the overhead of
    // starting a service to handle it
    if (ACTION_REFRESH_ID.equals(intent.getAction())) {
      
      // Do NOT perform refresh if no direct paging vendors are enabled
      if (!VendorManager.instance().isRegistered()) return;
      
      Log.w("Processing C2DM registration refresh request");
      register(context, true);
      return;
    }

    // Otherwise, hold a power lock for the duration and
    // start the service to handle the intent
    holdPowerLock(context);
    intent.setClass(context, C2DMService.class);
    context.startService(intent);
  }

  private static void holdPowerLock(Context context) {
    synchronized (C2DMService.class) {
      if (sWakeLock == null) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        sWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, Log.LOGTAG+".C2DMService");
        sWakeLock.setReferenceCounted(false);
      }
      if(!sWakeLock.isHeld()) sWakeLock.acquire();
    }
  }

  /**
   * send response messages
   * @param context current context
   * @param ackReq acknowledge request code
   * @param ackURL acknowledge URL
   * @param type request type to be sent 
   */
  public static void sendResponseMsg(Context context, String ackReq, String ackURL, String type,
                                       String vendorCode) {
    if (ackURL == null) return;
    if (ackReq == null) ackReq = "";
    Uri.Builder bld = Uri.parse(ackURL).buildUpon().appendQueryParameter("type", type);
    
    // Add paid status if requested
    if (ackReq.contains("P")) {
      DonationStatus status = DonationManager.instance().status(); 
      String paid;
      String expireDate = null;
      if (status == DonationManager.DonationStatus.LIFE) {
        paid = "YES";
        expireDate = "LIFE";
      } else if (ManagePreferences.freeSub()) {
        paid = "NO";
      } else if (status == DonationStatus.PAID || status == DonationStatus.PAID_WARN) {
        paid = "YES";
        Date expDate = DonationManager.instance().expireDate();
        if (expDate != null) expireDate = DATE_FORMAT.format(expDate);
      } else {
        paid = "NO";
      }
      bld.appendQueryParameter("paid_status", paid);
      if (expireDate != null) bld.appendQueryParameter("paid_expire_date", expireDate);
      
      // also add phone number.  CodeMessaging wants this to identify users who 
      // are getting text and direct pages
      String phone = UserAcctManager.instance().getPhoneNumber();
      if (phone != null) bld.appendQueryParameter("phone", phone);
    }
    
    // If a vendor code was specified, return status and version code associated with vendor
    VendorManager vm = VendorManager.instance();
    if (vendorCode != null) {
      if (!vm.isVendorDefined(vendorCode)) {
        bld.appendQueryParameter("vendor_status", "undefined");
      } else {
        bld.appendQueryParameter("vendor_status", vm.isRegistered(vendorCode) ? "registered" : "not_registered");
      }
    }
    
    // Add version code
    bld.appendQueryParameter("version", vm.getClientVersion(vendorCode));
    
    
    // Send the request
    HttpService.addHttpRequest(context, new HttpRequest(bld.build()));
  }
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
  
  
  /**
   * Request a new C2DM registration ID
   * @param context current context
   * @return true if register request was initiated, false if there is not
   * component to handle C2DM registrations
   */
  public static boolean register(Context context) {
    return register(context, false);
  }
  
  /**
   * Request a new C2DM registration ID
   * @param context current context
   * @param auto true if this is an automatically generated registration request
   * @return true if register request was initiated, false if there is no
   * component to handle C2DM registrations
   */
  public static boolean register(Context context, boolean auto) {
    Log.w("GCM Register Request");
    return startRegisterRequest(context, 1, auto);
  }

  /**
   * Request that current C2DM registration be dropped
   * @param context current context
   */
  public static boolean unregister(Context context) {
    Log.w("GCM Unregister request");
    ManagePreferences.setRegistrationId(null);
    boolean result = startRegisterRequest(context, 2, true);
    EmailDeveloperActivity.logSnapshot(context, "General Unregister Request");
    return result;
  }
  
  /**
   * Launch initial GCM register/unregister request
   * @param context current context
   * @param reqCode 1 - register, 2 - unregister
   * @param auto true if this is an automatically generated registration request
   * @return true if request was initiated by user
   */
  private static boolean startRegisterRequest(Context context, int reqCode, boolean auto) {
    
    if (reqCode == 1) resetRefreshIDTimer(context, "REGISTER");
    
    // Don't do anything if we already have an active ongoing request for this type
    if (!ManagePreferences.registerReqLock(reqCode, REGISTER_LOCK_TIMEOUT)) return true;
    
    // Launch the request
    return startRegisterRequest(context, reqCode, (auto ? INIT_REREGISTER_DELAY : 0));
  }
  
  /**
   * Launch initial or repeat GCM register/unregister request
   * @param context current context
   * @param reqCode 1 - register, 2 - unregister
   * @param delayMS If request fails for any reason, delay for this amount of time before issuing a second request
   * @return true if request was initiated
   */
  private static boolean startRegisterRequest(Context context, int reqCode, int delayMS) {

    if (Log.DEBUG) Log.v("startRegisterRequest:" + reqCode + " - " + delayMS);
    ManagePreferences.setReregisterDelay(delayMS);
    
    if (isNewGCMActive(context)) {
      
      // Register and Unregister are blocking methods that must be run 
      // off of the UI thread
      new AsyncTask<Integer, Void, String>() {
        @Override
        protected String doInBackground(Integer... parms) {
          try {
            switch (parms[0]) {
            case 1:
              String regid = getGCM().register(GCM_PROJECT_ID);
              return "REG:" + regid;
              
            case 2:
              getGCM().unregister();
              return "URG:";
            }
          } catch (IOException ex) {
            return "FAI:" + ex.getMessage();
          }
          return "???";
        }

        @Override
        protected void onPostExecute(String result) {
          if (result.startsWith("REG:")) {
            registrationSuccess(result.substring(4));
          } else if (result.startsWith("URG:")) {
            registrationCancelled();
          } else if (result.startsWith("FAI:")) {
            registrationFailure(result.substring(4));
          }
        }
      }.execute(reqCode);
      return true;
    }
      
    else {
      Intent intent = null;
      switch (reqCode) {
      case 1:
        intent = new Intent(ACTION_C2DM_REGISTER);
        intent.putExtra("sender", GCM_PROJECT_ID);
        break;
        
      case 2:
        intent = new Intent(ACTION_C2DM_UNREGISTER);
        break;
      }
      
      if (intent == null) return false;
      intent.setPackage(GSF_PACKAGE);
      Log.v("C2DMService sending registration request");
      ContentQuery.dumpIntent(intent);
      intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
      ComponentName name = context.startService(intent);
      Log.v("Processed by " + name);
      return name != null;
    }
  }
  
  /**
   * Check to make sure everything is Kopesetic with the new Play Services based
   * GCM protocol
   * @param context current context
   * @return true if everything is OK.  false to use old fallback protocol
   */
  private static boolean isNewGCMActive(Context context) {
    if (ManagePreferences.useOldGcm()) return false;
    return (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) ==  ConnectionResult.SUCCESS);
  }

  private static void registrationSuccess(String regId) {
    Log.w("C2DM registration succeeded: " + regId);
    boolean change = ManagePreferences.setRegistrationId(regId);
    ManagePreferences.registerReqRelease();
    VendorManager.instance().registerC2DMId(CadPageApplication.getContext(), change, regId);
  }

  private static void registrationCancelled() {
    Log.w("C2DM registration cancelled");
    Context context = CadPageApplication.getContext();
    ManagePreferences.setRegistrationId(null);
    ManagePreferences.registerReqRelease();
    VendorManager.instance().unregisterC2DMId(context);
    EmailDeveloperActivity.logSnapshot(context, "GCM Registration unregister report");
  }

  private static void registrationFailure(String error) {
    Log.w("C2DM registration failed: " + error);
    Context context = CadPageApplication.getContext();
    error = retryRegistration(error);
    if (error != null) {
      ManagePreferences.setRegistrationId(null);
      ManagePreferences.registerReqRelease();
      VendorManager.instance().failureC2DMId(context, error);
    }
    EmailDeveloperActivity.logSnapshot(context, "GCM Registration failure report");
  }

  private static synchronized GoogleCloudMessaging getGCM() {
    if (gcm == null) gcm = GoogleCloudMessaging.getInstance(CadPageApplication.getContext());
    return gcm;
  }
  
  /**
   * Called after a registration error has been reported
   * @param error
   * @return error status to be reported to user or null if request
   * has been rescheduled and no error status should be reported
   */
  private static String retryRegistration(String error) {
    
    // We can only recover from the SERVICE_NOT_AVAILABLE error
    // Lately PHONE_REGISTRATION_ERROR appears to be a recoverable error
    // But we can at least check to make sure there is an identifiable user account
    // Google is having problems with some systems returning AUTHENTICATION_FAILED status for unknown
    // reasons, so we will try to generate a bug report to help them out
    if (!error.equals("SERVICE_NOT_AVAILABLE")) {
      if (!error.equals("PHONE_REGISTRATION_ERROR")) {
        if (error.equals("AUTHENTICATION_FAILED")) BugReportGenerator.generate();
        return error;
      }
      if (UserAcctManager.instance().getUser() == null) return "AUTHENTICATION_FAILED";
    }
    
    // See if request should be rescheduled
    int req = ManagePreferences.registerReq();
    int delayMS = ManagePreferences.reregisterDelay();
    if (req == 0 || delayMS == 0) return error;

    // Since PHONE_REGISTRATION_ERROR isn't really recoverable, 
    // we will give up on it when we hit the maximum delay time
    if (delayMS == MAX_REREGISTER_DELAY && error.equals("PHONE_REGISTRATION_ERROR")) {
      Log.v("C2DMService terminating registration retries");
      ManagePreferences.setRegisterReq(0);
      ManagePreferences.setReregisterDelay(0);
      return error + "_HARD";
    }
    
    // If it should compute how long to delay before reissuing the request.  Since we are
    // potentially running in synch with thousands of other requesters trying to overload
    // Google's server, we add a randomizing factor into the actual delay time so we don't
    // all hit it at once.
    Context context = CadPageApplication.getContext();
    int realDelayMS = delayMS/2 + RANDOM.nextInt(delayMS); 
    Intent retryIntent = new Intent(ACTION_RETRY_REGISTER);
    retryIntent.setClass(context, C2DMRetryReceiver.class);
    PendingIntent retryPendingIntent = PendingIntent.getBroadcast(context, 0, retryIntent, 0);
    AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
    am.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + realDelayMS, retryPendingIntent);
    Log.v("Rescheduling request in " + realDelayMS + " / " + delayMS + " msecs");
    ContentQuery.dumpIntent(retryIntent);
    return null;
  }

  /**
   * Called when the retry register event scheduled by retryRegistration() goes off.
   * This is where we actually do the followup registration request
   */
  private void retryRegisterRequest(Intent intent) {
    Log.w("Processing C2DM Retry request");
    ContentQuery.dumpIntent(intent);

    // Get the registration information
    int req = ManagePreferences.registerReq();
    int delayMS = ManagePreferences.reregisterDelay();
    if (req == 0 || delayMS == 0) return;
    
    // Double the delay that will be invoked if this request also fails
    // subject to an absolute maximum value
    delayMS *= 2;
    if (delayMS > MAX_REREGISTER_DELAY) delayMS = MAX_REREGISTER_DELAY;
    
    // Fire off the request
    startRegisterRequest(this, req, delayMS);
  }
  
  /**
   * Reset the refresh registration ID timer, rescheduling the next refresh event
   * until REFRESH_ID_TIMEOUT msecs in the future
   * @param context current context
   * @param eventType Event type responsible for reset request
   */
  private static void resetRefreshIDTimer(Context context, String eventType) {
    
    long curTime = System.currentTimeMillis();
    ManagePreferences.setLastGcmEventType(eventType);
    ManagePreferences.setLastGcmEventTime(curTime);
    
    Log.v("Scheduling refresh event in " + REFRESH_ID_TIMEOUT + " msecs");
    
    AlarmManager myAM = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

    Intent refreshIntent = new Intent(context, C2DMRetryReceiver.class);
    refreshIntent.setAction(ACTION_REFRESH_ID);

    PendingIntent refreshPendingIntent =
      PendingIntent.getBroadcast(context, 0, refreshIntent, PendingIntent.FLAG_UPDATE_CURRENT);

    long triggerTime = curTime + REFRESH_ID_TIMEOUT;
    myAM.set(AlarmManager.RTC_WAKEUP, triggerTime, refreshPendingIntent);
   
  }

  /**
   * Generate an Email message with the current registration ID
   * @param context current context
   */
  public static void emailRegistrationId(Context context) {
    
    // Build send email intent and launch it
    String type = "GCM";
    Intent intent = new Intent(Intent.ACTION_SEND);
    String emailSubject = CadPageApplication.getNameVersion() + " " + type + " registrion ID";
    intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
    intent.putExtra(Intent.EXTRA_TEXT, "My " + type + " registration ID is " + ManagePreferences.registrationId());
    intent.setType("message/rfc822");
    try {
      context.startActivity(Intent.createChooser(intent, context.getString(R.string.pref_sendemail_title)));
    } catch (ActivityNotFoundException ex) {
      Log.e(ex);
    }
  }
}
