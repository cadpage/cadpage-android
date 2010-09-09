package net.anei.cadpage;

import net.anei.cadpage.ManagePreferences.Defaults;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.telephony.SmsMessage.MessageClass;

public class SmsReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    if (Log.DEBUG) Log.v("SMSReceiver: onReceive()");
    intent.setClass(context, SmsReceiverService.class);
    intent.putExtra("result", getResultCode());

    // Convert Intent into an SMS/MSS message
    SmsMessage[] messages = SmsPopupUtils.getMessagesFromIntent(intent);
    SmsMmsMessage message = new SmsMmsMessage(context, messages,System.currentTimeMillis());

    // And determine if this is a CAD Page call
    if (message != null && cadPageCall(context, message)){
      
      // If it is, abort broadcast to any other receivers
      // add add the messaging information to the intent
      // and forward it to SmsReceiverService
      abortBroadcast();
      message.addToIntent(intent);
      SmsReceiverService.beginStartingService(context, intent);
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
    ManagePreferences mPrefs = new ManagePreferences(context, message.getContactId());
    String sFilter = mPrefs.getString(R.string.pref_filter_key,Defaults.PREFS_FILTER);
    String sAddress = message.getAddress();
    if (! match(sAddress, sFilter)) return false;

    if (Log.DEBUG) Log.v("SMSReceiver/CadPageCall: Filter Matches checking call Location -" + sFilter);

    // Next look up location code and use it to see if this message contains the trigger phrase
    String sLocation = mPrefs.getString(R.string.pref_location,Defaults.PREFS_LOCATION);
    if (sLocation.contains("Loudoun")){
      sLocation="1";
    }
    int iLocation = Integer.parseInt(sLocation);
    String[] phrases = new String[]{"Call:", "TYPE:", "Map:", "(Corvallis Alert)"};
    if (iLocation > phrases.length) return false;
    return (strMessage.indexOf(phrases[iLocation-1]) >= 0);
  }

  /**
   * See if message sender matches filter
   * @param address message sender address
   * @param filter message sender filter
   * @return true if sender matches filter
   */
  private boolean match(String address, String filter) {
    if (filter == null || filter.length() == 0) return true;

    // Convert the filter expression into a regular expression
    filter = filter.replaceAll(".", "\\.").replaceAll("?", ".").replaceAll("*", ".*");
    return address.matches(filter);
  }
}

