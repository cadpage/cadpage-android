package net.anei.cadpage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.telephony.SmsMessage.MessageClass;
import net.anei.cadpage.wrappers.MyDBAdapter;

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
      StoreRaw(context,message);
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
    String sFilter = ManagePreferences.filter();
    String sAddress = message.getAddress();
    if (! match(sAddress, sFilter)) return false;
    if (Log.DEBUG) Log.v("SMSReceiver/CadPageCall: Filter Matches checking call Location -" + sFilter);

    // Next look up location code and use it to see if this message contains the trigger phrase
    String sLocation = ManagePreferences.location();
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
  private void StoreRaw(Context context,SmsMmsMessage message){
	  MyDBAdapter DB = new MyDBAdapter(context);
      DB.open();
      long lRes = DB.insertCall(message.toString());
      if (Log.DEBUG) Log.v("SMSReceiver/onReceive: Inserted Raw call to DB  Result-" + lRes);
      DB.close();
  }
  private boolean match(String address, String filter) {
    return (filter == null || filter.length() == 0 ||
             filter.equals("*")  || address.contains(filter));
  }
}

