package net.anei.cadpage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.telephony.SmsMessage.MessageClass;

public class SmsReceiver extends BroadcastReceiver {
  
  private static final String ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

  @Override
  public synchronized void onReceive(Context context, Intent intent) {
    Log.v("SMSReceiver: onReceive()");
    ContentQuery.dumpIntent(intent);
    
    // If initialization failure in progress, shut down without doing anything
    if (TopExceptionHandler.isInitFailure()) return;
    
    // Otherwise convert Intent into an SMS/MSS message
    SmsMmsMessage message = null;
    if (ACTION_SMS_RECEIVED.equals(intent.getAction())) {
      SmsMessage[] messages = getMessagesFromIntent(intent);
      if (messages == null) return;
      message = new SmsMmsMessage( messages,System.currentTimeMillis());
      if (message.getMessageBody().length() == 0) return;
      
      // See if this is a vendor discovery query.  If it is, make it go away
      if (message.isDiscoveryQuery(context)) {
        abortBroadcast();
        return;
      }
      
      // Save message for future test or error reporting use
      // If message is rejected as duplicate, don't do anything except call
      // abortbroadcast to keep it from going to anyone else
      if (! SmsMsgLogBuffer.getInstance().add(message)) {
        if (! ManagePreferences.smspassthru()) abortBroadcast();
        return;
      }
    }
    
    // If we didn't get a message, bail out
    if (message == null) return;
    
    // If this was an incomplete MMS message picked up by the process last
    // message option, bail out
    if (message.getMessageBody() == null) return;
    
    // Class 0 SMS, let the system handle this
    if (message.getMessageType() == SmsMmsMessage.MESSAGE_TYPE_SMS &&
        message.getMessageClass() == MessageClass.CLASS_0) return;
    
    // Pass message to accumulator
    // If the accumulator accepted it, and we aren't passing messages to the
    // default messaging app, abort broadcast to any further receivers
    boolean grabbed = SmsMsgAccumulator.instance().addMsg(context, message);
    if (grabbed) {
      FilterOptions options = message.getFilterOptions();
      if (options.blockTextMsgEnabled()) abortBroadcast();
    }
    
    // That is all we have to do.  SmsMsgAccumulator passes complete
    // messages to processCadPage when it has them
  }

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
   * Final Cadpage processing. Called by any message processor once it is
   * determined this is a real Cadpage alert
   * @param message Cadpage message
   */
  public static void processCadPage(final SmsMmsMessage message) {
    
    // We can be called on different working threads and need to find a 
    // context and get back on the working thread.
    CadPageApplication.runOnMainThread(new Runnable(){
      @Override
      public void run() {
        SmsReceiver.processCadPage(CadPageApplication.getContext(), message);
      }
    });
  }

  /**
   * Final process of message once we have determined it is a CAD page message
   * This will be called by MmsTransactionService to handle MMS messages
   * @param context current context
   * @param message message to be processed
   */
  private static void processCadPage(Context context, SmsMmsMessage message) {
    
    // If we are ignoring this message, drop out
    FilterOptions options = message.getFilterOptions();
    if (!options.historyEnabled()) return;
    
    // Add new message to the message queue
    SmsMessageQueue.getInstance().addNewMsg(message);
    
    // Publish message contents if so requested
    if (ManagePreferences.publishPages()) message.broadcastIntent(context, false);
  
    // See if any notifications are enabled
    boolean notify = options.noticeEnabled();
    
    // Determine if application should pop up right now
    boolean process = startApp(context, options);
    
    // If either a screen display or notification was generated by this
    // message, it is time to acquire a wakelock to keep the device awake  
    if (process ||  notify) ManageWakeLock.acquireFull(context);

    // And finally, launch the main application screen
    if (process) {
      CallHistoryActivity.launchActivity(context, notify, message);
    }
    
    // If we did not launch the application screen, do the notification stuff
    // that is not going to be performed by the main app activity
    else if (notify) {
      ManageNotification.show(context, message);
      launchScanner(context);
    }
  }

  public static void launchScanner(Context context) {
    if (! ManagePreferences.activeScanner()) return;
    Intent scanIntent = ManagePreferences.scannerIntent();
    if (scanIntent == null) return;
    Log.v("Launching Scanner");
    scanIntent.putExtra("caller", "cadpage");
    ContentQuery.dumpIntent(scanIntent);
    context.sendBroadcast(scanIntent);
  }

  /**
   * Determine if application should be launched when CAD page is received
   * @param context
   * @return
   */
  private static boolean startApp(Context context, FilterOptions options) {
    

    // If popup isn't enabled, this is as afar as we go
    if (! options.popupEnabled()) return false;

    // Fetch call state, if the user is in a call or the phone is ringing we don't want to show the popup
    if (ManagePreferences.noShowInCall()) {
      TelephonyManager mTM = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
      boolean callStateIdle = mTM.getCallState() == TelephonyManager.CALL_STATE_IDLE;
      if (!callStateIdle) return false;
    }
    
    // Otherwise OK
    return true;
  }
}

