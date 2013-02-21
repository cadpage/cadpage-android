package net.anei.cadpage;

import java.text.SimpleDateFormat;

import net.anei.cadpage.HttpService.HttpRequest;
import net.anei.cadpage.donation.DonationManager;
import net.anei.cadpage.donation.UserAcctManager;
import net.anei.cadpage.donation.DonationManager.DonationStatus;
import net.anei.cadpage.vendors.VendorManager;
import android.app.Activity;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;

public class C2DMService extends IntentService {
  
  private static final String ACTION_C2DM_REGISTER = "com.google.android.c2dm.intent.REGISTER";
  private static final String ACTION_C2DM_UNREGISTER = "com.google.android.c2dm.intent.UNREGISTER";
  private static final String ACTION_C2DM_REGISTERED = "com.google.android.c2dm.intent.REGISTRATION";
  private static final String ACTION_C2DM_RECEIVE = "com.google.android.c2dm.intent.RECEIVE";
  private static final String GCM_PROJECT_ID = "1027194726673";

  // wakelock
  private static final String WAKELOCK_KEY = "C2DMService";
  private static PowerManager.WakeLock sWakeLock;

  // Activity that should display any alerts or warnings
  private static Activity curActivity = null;

  public C2DMService() {
    super("C2DMService");
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    
    try {
      if (Log.DEBUG) Log.v("C2DMReceiver: onReceive()");
      
      if (ACTION_C2DM_REGISTERED.equals(intent.getAction())) {
        handleRegistration(intent);
      }
      
      else if (ACTION_C2DM_RECEIVE.equals(intent.getAction())) {
        handleMessage(intent);
      }
    }
    
    finally {
      
      // Release the power lock, so phone can get back to sleep.
      // The lock is reference-counted by default, so multiple
      // messages are ok.
      Log.v("C2DMServce Releasing wakelock");
      sWakeLock.release();
    }
 }
  
  private void handleRegistration(final Intent intent) {
    
    // Dump intent info
    Log.w("Processing C2DM Registration");
    ContentQuery.dumpIntent(intent);
    
    // VendorManager calls may hit the UI, so we need to jump back to the UI thread
    CadPageApplication.getMainHandler().post(new Runnable(){
      @Override
      public void run() {
        
        String error = intent.getStringExtra("error");
        if (error != null) {
          Log.w("C2DM registration failed: " + error);
          ManagePreferences.setRegistrationId(null);
          VendorManager.instance().failureC2DMId(C2DMService.this, error);
          return;
        }
        
        String regId = intent.getStringExtra("unregistered");
        if (regId != null) {
          Log.w("C2DM registration cancelled: " + regId);
          ManagePreferences.setRegistrationId(null);
          VendorManager.instance().unregisterC2DMId(C2DMService.this, regId);
          return;
        }
        
        regId = intent.getStringExtra("registration_id");
        if (regId != null) {
          Log.w("C2DM registration succeeded: " + regId);
          ManagePreferences.setRegistrationId(regId);
          VendorManager.instance().registerC2DMId(C2DMService.this, regId);
          return;
        }
      }
    });
  }

  private void handleMessage(final Intent intent) {
    
    try {
      
      // If registration has been canceled, all C2DM messages should be ignored
      if (ManagePreferences.registrationId() == null) return;
      
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
        return;
      }
      
      // Register and unregister requests are handled by VendorManager
      // which must be done on the main UI thread
      if (type.equals("REGISTER") || type.equals("UNREGISTER")) {
        final String type2 = type;
        final String vendorCode2 = vendorCode;
        final String account = intent.getStringExtra("account");
        final String token = intent.getStringExtra("token");
        CadPageApplication.getMainHandler().post(new Runnable(){
          @Override
          public void run() {
            VendorManager.instance().vendorRequest(C2DMService.this, type2, vendorCode2, account, token);
          }
        });
        sendAutoAck(intent, vendorCode);
        return;
      }
      
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
    String ackReq = intent.getStringExtra("ack_req");
    String ackURL = intent.getStringExtra("ack_url");
    sendResponseMsg(this, ackReq, ackURL, "AUTO", vendorCode);
  }
    
  private void processContent(Intent intent, String content, long timestamp) {
    
    // Reconstruct message from data from intent fields
    String from = intent.getStringExtra("sender");
    if (from == null) from = "GCM";
    String subject = intent.getStringExtra("subject");
    if (subject == null) subject = "";
    String location = intent.getStringExtra("format");
    if (location != null) {
      if (location.equals("Active911")) location = "Cadpage";
    }
    String vendorCode = intent.getStringExtra("vendor");
    if (vendorCode == null) vendorCode = intent.getStringExtra("sponsor");
    
    // Get the acknowledge URL and request code
    String ackURL = intent.getStringExtra("ack_url");
    String ackReq = intent.getStringExtra("ack_req");
    if (vendorCode == null && ackURL != null) {
      vendorCode = VendorManager.instance().findVendorCodeFromUrl(ackURL);
    }
    if (ackURL == null) ackReq = null;
    if (ackReq == null) ackReq = "";
    
    String callId = intent.getStringExtra("call_id");
    String serverTime = intent.getStringExtra("unix_time");
    String infoUrl = intent.getStringExtra("info_url"); 
    
    final SmsMmsMessage message = 
      new SmsMmsMessage(from, subject, content, timestamp,
                        location, vendorCode, ackReq, ackURL, 
                        callId, serverTime, infoUrl);
    
    // Add to log buffer
    if (!SmsMsgLogBuffer.getInstance().add(message)) return;
    
    // See if the current parser will accept this as a CAD page
    boolean isPage = message.isPageMsg(SmsMmsMessage.PARSE_FLG_FORCE);
    
    // This should never happen, 
    if (!isPage) return;
    
    // Process the message on the main thread
    CadPageApplication.getMainHandler().post(new Runnable(){
      @Override
      public void run() {
        SmsReceiver.processCadPage(C2DMService.this, message);
      }
    });
  }

  /**
   * Called from the broadcast receiver.
   * <p>
   * Will process the received intent, call handleMessage(), registered(),
   * etc. in background threads, with a wake lock, while keeping the service
   * alive.
   */
  static void runIntentInService(Context context, Intent intent) {
      synchronized (C2DMService.class) {
          if (sWakeLock == null) {
              PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
              sWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, WAKELOCK_KEY);
          }
      }
      Log.v("C2DMService Acquiring wakelock");
      sWakeLock.acquire();
      intent.setClass(context, C2DMService.class);
      context.startService(intent);
  }
  
  /**
   * Register activity to be used to generate any alert dialogs
   * @param activity
   */
  public static void registerActivity(Activity activity) {
    curActivity = activity;
  }
  
  /**
   * Unregister activity previously registered for any generated alert dialogs
   * @param activity
   */
  public static void unregisterActivity(Activity activity) {
    if (curActivity == activity) curActivity = null;
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
      String expireDate;
      if (status == DonationManager.DonationStatus.LIFE) {
        paid = "YES";
        expireDate = "LIFE";
      } else if (ManagePreferences.freeSub()) {
        paid = "NO";
        expireDate = null;
      } else if (status == DonationStatus.PAID || status == DonationStatus.PAID_WARN) {
        paid = "YES";
        expireDate = DATE_FORMAT.format(DonationManager.instance().expireDate());
      } else {
        paid = "NO";
        expireDate = null;
      }
      bld.appendQueryParameter("paid_status", paid);
      if (expireDate != null) bld.appendQueryParameter("paid_expire_date", expireDate);
      
      // also add phone number.  CodeMessaging wants this to identify users who 
      // are getting text and direct pages
      String phone = UserAcctManager.instance().getPhoneNumber();
      if (phone != null) bld.appendQueryParameter("phone", phone);
    }
    
    // If a vendor code was specified, return status and version code assoicated with vendor
    if (vendorCode != null) {
      
      VendorManager vm = VendorManager.instance();
      if (!vm.isVendorDefined(vendorCode)) {
        bld.appendQueryParameter("vendor_status", "undefined");
      } else {
        bld.appendQueryParameter("vendor_status", vm.isRegistered(vendorCode) ? "registered" : "not_registered");
        
        // Add version code
        bld.appendQueryParameter("version", vm.getClientVersion(vendorCode));
      }
      
      // Add version code
      bld.appendQueryParameter("version", VendorManager.instance().getClientVersion(vendorCode));
    }
    
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
    Intent intent = new Intent(ACTION_C2DM_REGISTER);
    intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
    intent.putExtra("sender", GCM_PROJECT_ID);
    return context.startService(intent) != null;
  }

  
  /**
   * Request that current C2DM registration be dropped
   * @param context current context
   */
  public static boolean unregister(Context context) {
    ManagePreferences.setRegistrationId(null);
    Intent intent = new Intent(ACTION_C2DM_UNREGISTER);
    intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
    return context.startService(intent) != null;
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
    context.startActivity(Intent.createChooser(
        intent, context.getString(R.string.pref_sendemail_title)));
  }

}
