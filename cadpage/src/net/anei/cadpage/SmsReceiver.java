package net.anei.cadpage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.telephony.SmsMessage.MessageClass;

public class SmsReceiver extends BroadcastReceiver {
  
  private static final String ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
  
  private static final String EXTRA_TIMEOUT = "net.anei.cadpage.SmsReceive.MSG_TIMEOUT";
  private static final String EXTRA_REPEAT_LAST = "net.anei.cadpage.SmsReceive.REPEAT_LAST";
  
  // Stored text message in the process of being reconstructed
  // Technically, this should be persisted in case application is shut down
  // between the receipt of multiple messages, but the time interval that we need
  // to keep it is pretty small, so we'll just take our chances
  private static SmsMmsMessage bufferMsg = null;

  @Override
  public synchronized void onReceive(Context context, Intent intent) {
    if (Log.DEBUG) Log.v("SMSReceiver: onReceive()");
    
    // If initialization failure in progress, shut down without doing anything
    if (TopExceptionHandler.isInitFailure()) return;

    SmsMmsMessage message = null;

    boolean timeout = intent.getBooleanExtra(EXTRA_TIMEOUT, false);
    boolean repeat = intent.getBooleanExtra(EXTRA_REPEAT_LAST, false);
    
    // If buffered message has timed out, get ready to process it
    // We don't cancel the alarm when the buffered message does get processed
    // so when the alarm goes off, we need to check if it is still active.
    if (timeout) {
      message = bufferMsg;
      bufferMsg = null;
      if (message == null) return;
    }
    // If repeat_last flag is set, this is a fake intent instructing us
    // to reprocess the most recently received message (that passed the 
    // sender address filter
    else if (repeat) {
      message = SmsMsgLogBuffer.getInstance().getLastMessage();
      if (message != null) message.setRead(false);
    }
     
    // Otherwise convert Intent into an SMS/MSS message
    else if (ACTION_SMS_RECEIVED.equals(intent.getAction())) {
      SmsMessage[] messages = SmsPopupUtils.getMessagesFromIntent(intent);
      if (messages == null) return;
      message = new SmsMmsMessage( messages,System.currentTimeMillis());
    }
    
    if (message == null) return;
    
    // Class 0 SMS, let the system handle this
    if (message.getMessageType() == SmsMmsMessage.MESSAGE_TYPE_SMS &&
        message.getMessageClass() == MessageClass.CLASS_0) return;
    
    // If we are processing a timed out buffered message, the message has
    // already been checked and logged and we can skip all kinds of stuff
    if (! timeout) {
        
      // Collect the important preference settings
      boolean overrideFilter = ManagePreferences.overrideFilter();
      String sFilter = (overrideFilter ? ManagePreferences.filter() : "");
      int msgTimeout = ManagePreferences.partMsgTimeout();
  
      // If we are reconstructing a multiple text page, The only requirement is
      // that this message has to come from the same sender
      // If it passes that, merge the two together.
      if (bufferMsg != null) {
        if (!bufferMsg.getFromAddress().equals(message.getAddress())) return;
      }
      
      // Otherwise if the parser filter has been overridden, see if this passes the
      // user sender filter
      else {
        if (overrideFilter) {
          String sAddress = message.getAddress();
          if (! SmsPopupUtils.matchFilter(sAddress, sFilter)) return;
        }
        if (Log.DEBUG) Log.v("SMSReceiver/CadPageCall: Filter Matches checking call Location -" + sFilter);
      }
      
      // Save message for future test or error reporting use
      // If message is rejected as duplicate, and it wasn't a requested repeat
      // don't do anything except call
      // abortbroadcast to keep it from going to anyone else
      if (! SmsMsgLogBuffer.getInstance().add(message) && !repeat) {
        if (! ManagePreferences.smspassthru()) abortBroadcast();
        return;
      }
      
      // If we have a buffered message, merge this one into it
      if (bufferMsg != null) {
        bufferMsg.merge(message);
        message = bufferMsg;
        bufferMsg = null;
      }
      
      // See if the current parser will handle this message
      boolean genAlert = ManagePreferences.genAlert();
      boolean isPage = 
          ManageParsers.getInstance().getParser(null).isPageMsg(message, overrideFilter, genAlert);
      
      // If it didn't, see if we can accept this as a general page
      // which only happens if the general alert config settings is set and there
      // is an active user filter
      if (! isPage && genAlert && sFilter.length()>1) {
        isPage = ManageParsers.getInstance().getAlertParser().isPageMsg(message, overrideFilter, genAlert);
      }
      
      // If not a cad page, we're done with this
      if (! isPage) return;
    	
      // If it is, and we are not configured to do otherwise, 
      // abort broadcast to any other receivers
      if (! ManagePreferences.smspassthru()) abortBroadcast();
      
      // If parser expect a message continuation, save this one and return
      if (msgTimeout > 0 && (message.isExpectMore() || message.msgCount()<ManagePreferences.splitMinMsg())) {
        if (bufferMsg == null) {
          bufferMsg = message;
          setReminder(context, msgTimeout);
        }
        return;
      }
    }

    // Finish up CAD page processing
    processCadPage(context, message);
  }


  /**
   * Set up an alarm to timeout and process a reconstructed message if the
   * expected other parts of the page never show up
   * @param msgTimeout timeout interval in seconds
   */
  private void setReminder(Context context, int msgTimeout) {
    
    AlarmManager myAM = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

    Intent intent = new Intent("android.provider.Telephony.SMS_RECEIVED");
    intent.setClass(context, SmsReceiver.class);
    intent.putExtra(EXTRA_TIMEOUT, true);

    PendingIntent reminderPendingIntent =
      PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

    long triggerTime = System.currentTimeMillis() + (msgTimeout * 1000);
    myAM.set(AlarmManager.RTC_WAKEUP, triggerTime, reminderPendingIntent);
  }


  /**
   * Final process of message once we have determined it is a CAD page message
   * This will be called by MmsTransactionService to handle MMS messages
   * @param context current context
   * @param message message to be processed
   */
  public static void processCadPage(Context context, SmsMmsMessage message) {
    // Add new message to the message queue
    SmsMessageQueue.getInstance().addNewMsg(message);
    
    // Publish message contents if so requested
    if (ManagePreferences.publishPages()) message.broadcastIntent(context, false);
  
    // Notify user if so configured
    boolean notify = ManageNotification.show(context, message);
    
    // Determine if application should pop up right now
    boolean process = startApp(context);
    
    // If either a screen display or notification was generated by this
    // message, it is time to wake up the device.
    // After which we can release the power lock that kept the power on
    // until we got this far
    if (process ||  notify) ManageWakeLock.acquireFull(context);

    // And finally, launch the main application screen
    if (process) CallHistoryActivity.launchActivity(context, message);
  }

  /**
   * Determine if application should be launched when CAD page is received
   * @param context
   * @return
   */
  private static boolean startApp(Context context) {

    // If popup isn't enabled, this is as afar as we go
    if (! ManagePreferences.popupEnabled()) return false;

    // Should popup should only show when keyguard is on
    if (ManagePreferences.onlyShowOnKeyguard()) {
      ManageKeyguard.initialize(context);
      if (! ManageKeyguard.inKeyguardRestrictedInputMode()) return false;
    }

    // Fetch call state, if the user is in a call or the phone is ringing we don't want to show the popup
    if (ManagePreferences.noShowInCall()) {
      TelephonyManager mTM = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
      boolean callStateIdle = mTM.getCallState() == TelephonyManager.CALL_STATE_IDLE;
      if (!callStateIdle) return false;
    }
    
    // Otherwise OK
    return true;
  }
  
  /**
   * Request most recently received page be reprocessed
   * @param context requesting context
   */
  public static void repeatLastPage(Context context) {
    Intent intent = new Intent("android.provider.Telephony.SMS_RECEIVED");
    intent.setClass(context, SmsReceiver.class);
    intent.putExtra(EXTRA_REPEAT_LAST, true);
    context.sendOrderedBroadcast(intent, null);
  }
}

