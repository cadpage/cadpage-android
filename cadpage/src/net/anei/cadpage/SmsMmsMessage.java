package net.anei.cadpage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.Serializable;

import android.content.Context;
import android.telephony.*;
import android.telephony.SmsMessage.MessageClass;
import android.text.format.DateUtils;

public class SmsMmsMessage implements Serializable {

  // Serialized object version code
  private static final long serialVersionUID = 1L;

  // Message types
  public static final int MESSAGE_TYPE_SMS = 0;
  public static final int MESSAGE_TYPE_MMS = 1;
  public static final int MESSAGE_TYPE_MESSAGE = 2;

  // Timestamp compare buffer for incoming messages
  public static final int MESSAGE_COMPARE_TIME_BUFFER = 5000; // 5 seconds

  // Main message object private vars
  private String fromAddress = null;
  private String messageBody = null;
  private String messageFull = null;
  private long timestamp = 0;
  private int messageType = 0;
  private boolean fromEmailGateway = false;
  private MessageClass messageClass = null;
  private boolean read = false;             
  private boolean locked = false;
  private transient String call = null;
  private int msgId = 0;
  
  
  public boolean isRead() {
    return read;
  }
  
  public void setRead(boolean read) {
    if (read == this.read) return;
    this.read = read;
    reportDataChange();
  }
  
  public boolean isLocked() {
    return locked;
  }
  
  public void setLocked(boolean locked) {
    if (locked == this.locked) return;
    this.locked = locked;
    reportDataChange();
  }
  
  public int getMsgId() {
    return msgId;
  }
  
  public void setMsgId(int msgId) {
    this.msgId = msgId;
  }
  
  private void reportDataChange() {
    if (msgId > 0) SmsMessageQueue.getInstance().notifyDataChange();
  }


  /**
   * Construct SmsMmsMessage given a raw message (created from pdu), used for when
   * a message is initially received via the network.
   */
  public SmsMmsMessage(SmsMessage[] messages, long _timestamp) {
    SmsMessage sms = messages[0];

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
  public SmsMmsMessage(Context context,
      long _timestamp, String _messageBody, int _messageType) {

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
  public SmsMmsMessage(String _fromAddress, String _messageBody,
      long _timestamp, int _messageType) {

    fromAddress = _fromAddress;
    messageBody = _messageBody;
    timestamp = _timestamp;
    messageType = _messageType;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public MessageClass getMessageClass() {
    return messageClass;
  }

  public CharSequence getFormattedTimestamp(Context context) {
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
  
  public String getCall() {
    if (call == null) {
      call = new SmsMsgParser(getMessageFull()).getCall();
    }
    return call;
  }
    
  /**
   * Read serialized SmsMmsMessage object from Object input stream
   */
  public static SmsMmsMessage readObject(ObjectInputStream is) 
  throws OptionalDataException, ClassNotFoundException, IOException {
    SmsMmsMessage message = (SmsMmsMessage)is.readObject();
    return message;

  }

}