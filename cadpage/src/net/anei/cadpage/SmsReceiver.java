package net.anei.cadpage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.telephony.SmsMessage.MessageClass;

public class SmsReceiver extends BroadcastReceiver {
  
  private static String MSG_FILENAME = "last.msg";
  private static String EXTRA_REPEAT_LAST = "net.anei.cadpage.SmsReceive.REPEAT_LAST";

  @Override
  public void onReceive(Context context, Intent intent) {
    if (Log.DEBUG) Log.v("SMSReceiver: onReceive()");

    SmsMmsMessage message = null;
    
    // If repeat_last flag is set, this is a fake intent instructing us
    // to reprocess the most recently recieved message (that passed the 
    // sender address filter
    if (intent.getBooleanExtra(EXTRA_REPEAT_LAST, false)) {
      message = getLastMessage(context);
    }
    // Otherwise convert Intent into an SMS/MSS message
    else {
      SmsMessage[] messages = SmsPopupUtils.getMessagesFromIntent(intent);
      if (messages == null) return;
      message = new SmsMmsMessage( messages,System.currentTimeMillis());
    }

    // And determine if this is a CAD Page call
    if (message != null && cadPageCall(context, message)){
    	
      // If it is, and we are not configured to do otherwise, 
      // abort broadcast to any other receivers
      if (! ManagePreferences.smspassthru()) abortBroadcast();

      // Add new message to the message queue
      SmsMessageQueue.getInstance().addNewMsg(message);
    
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
  }

  /**
   * Determine if this intent message is a CAD page call
   * @param context message context
   * @param intent Intent
   * @return true if message is a CAD page call that should be processed further
   */
  private boolean cadPageCall(Context context, SmsMmsMessage message){

    String strMessage = message.getMessageFull();
    
    // Class 0 SMS, let the system handle this
    if (message.getMessageType() == SmsMmsMessage.MESSAGE_TYPE_SMS &&
        message.getMessageClass() == MessageClass.CLASS_0) return false;

    // First look at from Filter.
    String sFilter = ManagePreferences.filter();
    String sAddress = message.getAddress();
    if (! match(sAddress, sFilter)) return false;
    if (Log.DEBUG) Log.v("SMSReceiver/CadPageCall: Filter Matches checking call Location -" + sFilter);
    
    // Save message to file for future test use
    ObjectOutputStream os = null;
    try {
      os = new ObjectOutputStream(
        context.openFileOutput(MSG_FILENAME, Context.MODE_PRIVATE));
      os.writeObject(message);
    } catch (IOException ex) {
      Log.e(ex);
    } finally {
      if (os != null) try {os.close();} catch (IOException ex) {}
    }
    
    return SmsMsgParser.isPageMsg(strMessage);
  }

  private boolean match(String address, String filter) {
    return (filter == null || filter.length() == 0 ||
             filter.equals("*")  || address.contains(filter));
  }


  /**
   * Determine if application should be launched when CAD page is received
   * @param context
   * @return
   */
  private boolean startApp(Context context) {

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

  /**
   * Retrieve most recently processed message
   * @param context current context
   * @return most recently processed message if found, null otherwise
   */
  public static SmsMmsMessage getLastMessage(Context context) {
    SmsMmsMessage msg = null;
    ObjectInputStream is = null;
    try {
      is = new ObjectInputStream(
        context.openFileInput(MSG_FILENAME));
      msg = SmsMmsMessage.readObject(is);
    } catch (FileNotFoundException ex) {
    } catch (Exception ex) {
      Log.e(ex);
    } finally {
      if (is != null) try {is.close();} catch (IOException ex) {}
    }
    return msg;
  }
}

