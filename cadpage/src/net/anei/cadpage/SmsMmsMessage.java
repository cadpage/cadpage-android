package net.anei.cadpage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.Serializable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.*;
import android.telephony.SmsMessage.MessageClass;
import android.text.format.DateUtils;

public class SmsMmsMessage implements Serializable {

  // Serialized object version code
  private static final long serialVersionUID = 1L;
  
  // Private EXTRAS strings
  private static final String PREFIX = "net.anei.cadpage.";
  private static final String EXTRAS_FROM_ADDRESS   = PREFIX + "EXTRAS_FROM_ADDRESS";
  private static final String EXTRAS_MESSAGE_BODY   = PREFIX + "EXTRAS_MESSAGE_BODY";
  private static final String EXTRAS_MESSAGE_FULL   = PREFIX + "EXTRAS_MESSAGE_FULL";
  private static final String EXTRAS_TIMESTAMP      = PREFIX + "EXTRAS_TIMESTAMP";
  private static final String EXTRAS_MESSAGE_TYPE   = PREFIX + "EXTRAS_MESSAGE_TYPE";
  private static final String EXTRAS_EMAIL_GATEWAY  = PREFIX + "EXTRAS_EMAIL_GATEWAY";
  private static final String EXTRAS_READ           = PREFIX + "EXTRAS_READ";
  private static final String EXTRAS_LOCKED         = PREFIX + "EXTRAS_LOCKED";

  // Message types
  public static final int MESSAGE_TYPE_SMS = 0;
  public static final int MESSAGE_TYPE_MMS = 1;
  public static final int MESSAGE_TYPE_MESSAGE = 2;

  // Timestamp compare buffer for incoming messages
  public static final int MESSAGE_COMPARE_TIME_BUFFER = 5000; // 5 seconds

  // Main message object private vars
  private transient Context context;           // Can't be serialized, restore afterwards
  private String fromAddress = null;
  private String messageBody = null;
  private String messageFull = null;
  private long timestamp = 0;
  private int messageType = 0;
  private boolean fromEmailGateway = false;
  private MessageClass messageClass = null;
  private boolean read = false;             
  private boolean locked = false;
  
  
  public boolean isRead() {
    return read;
  }
  
  public void setRead(boolean read) {
    this.read = read;
  }
  
  public boolean isLocked() {
    return locked;
  }
  
  public void setLocked(boolean locked) {
    this.locked = locked;
  }


  /**
   * Construct SmsMmsMessage given a raw message (created from pdu), used for when
   * a message is initially received via the network.
   */
  public SmsMmsMessage(Context _context, SmsMessage[] messages, long _timestamp) {
    SmsMessage sms = messages[0];

    context = _context;
    timestamp = _timestamp;
    messageType = MESSAGE_TYPE_SMS;

    /*
     * Fetch data from raw SMS
     */
    fromAddress = sms.getDisplayOriginatingAddress();
    fromEmailGateway = sms.isEmail();
    messageClass = sms.getMessageClass();

    String body;
    if (messages.length == 1 || sms.isReplace()) {
      body = sms.getDisplayMessageBody();
      messageFull = sms.getMessageBody();
    } else {
      StringBuilder bodyText = new StringBuilder();
      for (int i = 0; i < messages.length; i++) {
        bodyText.append(messages[i].getMessageBody());
      }
      body = bodyText.toString();
      messageFull = body;
    }
    messageBody = body;
  }


/**
   * Construct SmsMmsMessage for getMmsDetails() - fetched from the MMS database table
   * @return
   */
  public SmsMmsMessage(Context _context,
      long _timestamp, String _messageBody, int _messageType) {

    context = _context;
    timestamp = _timestamp;
    messageBody = _messageBody;
    messageType = _messageType;

    fromAddress = SmsPopupUtils.getMmsAddress(context, 0);

    //ContactIdentification contactIdentify = null;

    if (PhoneNumberUtils.isWellFormedSmsAddress(fromAddress)) {
   //   contactIdentify = SmsPopupUtils.getPersonIdFromPhoneNumber(context, fromAddress);
    //  contactName = PhoneNumberUtils.formatNumber(fromAddress);
    //  fromEmailGateway = false;
    } else {
    //  contactIdentify = SmsPopupUtils.getPersonIdFromEmail(context, fromAddress);
    //  contactName = fromAddress.trim();
    //  fromEmailGateway = true;
    }

 
  }

  /**
   * Construct SmsMmsMessage for getSmsDetails() - info fetched from the SMS
   * database table
   */
  public SmsMmsMessage(Context _context, String _fromAddress, String _messageBody,
      long _timestamp, int _messageType) {

    context = _context;
    fromAddress = _fromAddress;
    messageBody = _messageBody;
    timestamp = _timestamp;
    messageType = _messageType;
  }

  /**
   * Construct SmsMmsMessage from an extras bundle
   */
  public SmsMmsMessage(Context _context, Intent i) {
    context = _context;
    Bundle b = i.getExtras();
    fromAddress = b.getString(EXTRAS_FROM_ADDRESS);
    messageBody = b.getString(EXTRAS_MESSAGE_BODY);
    messageFull = b.getString(EXTRAS_MESSAGE_FULL);
    timestamp = b.getLong(EXTRAS_TIMESTAMP);
    messageType = b.getInt(EXTRAS_MESSAGE_TYPE, MESSAGE_TYPE_SMS);
    fromEmailGateway = b.getBoolean(EXTRAS_EMAIL_GATEWAY, false);
    read = b.getBoolean(EXTRAS_READ, false);
    locked = b.getBoolean(EXTRAS_LOCKED, false);
  }

  /**
   * Attach all SmsMmsMessage data to an intent
   */
  public void addToIntent(Intent i) {
    i.putExtra(EXTRAS_FROM_ADDRESS, fromAddress);
    i.putExtra(EXTRAS_MESSAGE_BODY, messageBody);
    i.putExtra(EXTRAS_MESSAGE_FULL, messageFull);
    i.putExtra(EXTRAS_TIMESTAMP, timestamp);
    i.putExtra(EXTRAS_MESSAGE_TYPE, messageType);
    i.putExtra(EXTRAS_EMAIL_GATEWAY, fromEmailGateway);
    i.putExtra(EXTRAS_READ, read);
    i.putExtra(EXTRAS_LOCKED, locked);
  }

  public Intent getPopupIntent() {
    Intent popup = new Intent(context, SmsPopupActivity.class);
    popup.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
    addToIntent(popup);
    return popup;
  }

//  /**
//   * Fetch the "reply to" message intent
//   * 
//   * @param replyToThread whether or not to reply using the message threadId or using the
//   * sender address
//   * 
//   * @return the intent to pass to startActivity()
//   */
//  public Intent getReplyIntent(boolean replyToThread) {
//    if (messageType == MESSAGE_TYPE_MMS) {
//      locateThreadId();
//      return SmsPopupUtils.getSmsToIntent(context, threadId);
//    } else if (messageType == MESSAGE_TYPE_SMS) {
//      locateThreadId();
//      /*
//       * There are two ways to reply to a message, by "viewing" the threadId or by
//       * sending a new message to the address.  In most cases we should just execute
//       * the former, but in some cases its better to send a new message to an address
//       * (apps like Google Voice will intercept this intent as they don't seem to look
//       * at the threadId).
//       */
//      if (replyToThread && threadId > 0) {
//        if (Log.DEBUG) Log.v("Replying by threadId: " + threadId);
//        return SmsPopupUtils.getSmsToIntent(context, threadId);
//      } else {
//        if (Log.DEBUG) Log.v("Replying by address: " + fromAddress);
//        return SmsPopupUtils.getSmsToIntent(context, fromAddress);
//      }
//    }
//    return null;
//  }
//
//  public Intent getReplyIntent() {
//    return getReplyIntent(true);
//  }

  public long getTimestamp() {
    return timestamp;
  }

  public MessageClass getMessageClass() {
    return messageClass;
  }

  public CharSequence getFormattedTimestamp() {
    return DateUtils.formatDateTime(context, timestamp, DateUtils.FORMAT_SHOW_TIME);
  }

  public String getMessageBody() {
    if (messageBody == null) {
      messageBody = "";
    }
    return messageBody;
  }

  public String getMessageFull() {
	    if (messageFull == null) {
	      messageFull = "";
	    }
	    return messageFull;
	  }
  public int getMessageType() {
    return messageType;
  }

  public String getAddress() {
    return fromAddress;
  }

  public boolean isEmail() {
    return fromEmailGateway;
  }

//  /**
//   * Sned a reply to this message
//   * 
//   * @param quickreply the message to send
//   * @return true of the message was sent, false otherwise
//   */
//  public boolean replyToMessage(String quickReply) {
//
//    // Mark the message we're replying to as read
//    setMessageRead();
//
//    // Send new message
//    SmsMessageSender sender =
//      new SmsMessageSender(context, new String[] {fromAddress}, quickReply, 0);
//
//    return sender.sendMessage();
//  }
  
  /**
   * Read serialized SmsMmsMessage object from Object input stream
   */
  public static SmsMmsMessage readObject(Context context, ObjectInputStream is) 
  throws OptionalDataException, ClassNotFoundException, IOException {
    SmsMmsMessage message = (SmsMmsMessage)is.readObject();
    if (message != null) message.context = context;
    return message;

  }

}