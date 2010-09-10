package net.anei.cadpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.*;
import android.telephony.SmsMessage.MessageClass;
import android.text.format.DateUtils;

public class SmsMmsMessage {
  // Private EXTRAS strings
  private static final String PREFIX = "net.anei.cadpage.";
  private static final String EXTRAS_FROM_ADDRESS   = PREFIX + "EXTRAS_FROM_ADDRESS";
  private static final String EXTRAS_MESSAGE_BODY   = PREFIX + "EXTRAS_MESSAGE_BODY";
  private static final String EXTRAS_MESSAGE_FULL   = PREFIX + "EXTRAS_MESSAGE_FULL";
  private static final String EXTRAS_TIMESTAMP      = PREFIX + "EXTRAS_TIMESTAMP";
  private static final String EXTRAS_UNREAD_COUNT   = PREFIX + "EXTRAS_UNREAD_COUNT";
  private static final String EXTRAS_THREAD_ID      = PREFIX + "EXTRAS_THREAD_ID";
  private static final String EXTRAS_CONTACT_ID     = PREFIX + "EXTRAS_CONTACT_ID";
  private static final String EXTRAS_CONTACT_LOOKUP = PREFIX + "EXTRAS_CONTACT_LOOKUP";
  private static final String EXTRAS_CONTACT_NAME   = PREFIX + "EXTRAS_CONTACT_NAME";
  private static final String EXTRAS_MESSAGE_TYPE   = PREFIX + "EXTRAS_MESSAGE_TYPE";
  private static final String EXTRAS_MESSAGE_ID     = PREFIX + "EXTRAS_MESSAGE_ID";
  private static final String EXTRAS_EMAIL_GATEWAY  = PREFIX + "EXTRAS_EMAIL_GATEWAY";
  private static final String EXTRAS_NOTIFY         = PREFIX + "EXTRAS_NOTIFY";

  // Public EXTRAS strings
  public static final String EXTRAS_REMINDER_COUNT = PREFIX + "EXTRAS_REMINDER_COUNT";
  public static final String EXTRAS_REPLYING       = PREFIX + "EXTRAS_REPLYING";
  public static final String EXTRAS_QUICKREPLY     = PREFIX + "EXTRAS_QUICKREPLY";

  // Message types
  public static final int MESSAGE_TYPE_SMS = 0;
  public static final int MESSAGE_TYPE_MMS = 1;
  public static final int MESSAGE_TYPE_MESSAGE = 2;

  // Timestamp compare buffer for incoming messages
  public static final int MESSAGE_COMPARE_TIME_BUFFER = 5000; // 5 seconds

  // Main message object private vars
  private Context context;
  private String fromAddress = null;
  private String messageBody = null;
  private String messageFull = null;
  private long timestamp = 0;
  private int unreadCount = 0;
  private long threadId = 0;
  private String contactId = null;
  private String contactLookupKey = null;
  private String contactName = null;
  private int messageType = 0;
  private boolean notify = true;
  private int reminderCount = 0;
  private long messageId = 0;
  private boolean fromEmailGateway = false;
  private MessageClass messageClass = null;


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
     

    

    /*
     * Lookup the rest of the info from the system db
     */
/* WE DON'T Use the rest here.
    ContactIdentification contactIdentify = null;

    // If this SMS is from an email gateway then lookup contactId by email address
    if (fromEmailGateway) {
      if (Log.DEBUG) Log.v("Sms came from email gateway");
      contactIdentify = SmsPopupUtils.getPersonIdFromEmail(context, fromAddress);
      contactName = fromAddress;
    } else { // Else lookup contactId by phone number
      if (Log.DEBUG) Log.v("Sms did NOT come from email gateway");
      contactIdentify = SmsPopupUtils.getPersonIdFromPhoneNumber(context, fromAddress);
      contactName = PhoneNumberUtils.formatNumber(fromAddress);
    }

    if (contactIdentify != null) {
      contactId = contactIdentify.contactId;
      contactLookupKey = contactIdentify.contactLookup;
      contactName = contactIdentify.contactName;
    }

    //contactName = SmsPopupUtils.getPersonName(context, contactId, fromAddress);
    unreadCount = SmsPopupUtils.getUnreadMessagesCount(context, timestamp, messageBody);

    if (contactName == null) {
      contactName = context.getString(android.R.string.unknownName);
    }
    */
  }


/**
   * Construct SmsMmsMessage for getMmsDetails() - fetched from the MMS database table
   * @return
   */
  public SmsMmsMessage(Context _context, long _messageId, long _threadId,
      long _timestamp, String _messageBody, int _unreadCount, int _messageType) {

    context = _context;
    messageId = _messageId;
    threadId = _threadId;
    timestamp = _timestamp;
    messageBody = _messageBody;
    unreadCount = _unreadCount;
    messageType = _messageType;

    fromAddress = SmsPopupUtils.getMmsAddress(context, messageId);

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
      long _timestamp, long _threadId, int _unreadCount, long _messageId, int _messageType) {

    context = _context;
    fromAddress = _fromAddress;
    messageBody = _messageBody;
    timestamp = _timestamp;
    messageType = _messageType;

   

  
    unreadCount = _unreadCount;
    threadId = _threadId;
    messageId = _messageId;

    if (contactName == null) {
      contactName = context.getString(android.R.string.unknownName);
    }
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
    contactId = b.getString(EXTRAS_CONTACT_ID);
    contactLookupKey = b.getString(EXTRAS_CONTACT_LOOKUP);
    contactName = b.getString(EXTRAS_CONTACT_NAME);
    unreadCount = b.getInt(EXTRAS_UNREAD_COUNT, 1);
    threadId = b.getLong(EXTRAS_THREAD_ID, 0);
    messageType = b.getInt(EXTRAS_MESSAGE_TYPE, MESSAGE_TYPE_SMS);
    notify = b.getBoolean(EXTRAS_NOTIFY, false);
    reminderCount = b.getInt(EXTRAS_REMINDER_COUNT, 0);
    messageId = b.getLong(EXTRAS_MESSAGE_ID, 0);
    fromEmailGateway = b.getBoolean(EXTRAS_EMAIL_GATEWAY, false);
  }

  /**
   * Construct SmsMmsMessage by specifying all data, only used for testing the
   * notification from the preferences screen
   */
  public SmsMmsMessage(Context _context, String _fromAddress, String _messageBody,
      long _timestamp, String _contactId, String _contactLookup, String _contactName,
      int _unreadCount, long _threadId, int _messageType) {
    context = _context;
    fromAddress = _fromAddress;
    messageBody = _messageBody;
    timestamp = _timestamp;
    contactId = _contactId;
    contactLookupKey = _contactLookup;
    contactName = _contactName;
    unreadCount = _unreadCount;
    threadId = _threadId;
    messageType = _messageType;
  }

  /**
   * Attach all SmsMmsMessage data to an intent
   */
  public void addToIntent(Intent i) {
    i.putExtra(EXTRAS_FROM_ADDRESS, fromAddress);
    i.putExtra(EXTRAS_MESSAGE_BODY, messageBody);
    i.putExtra(EXTRAS_MESSAGE_FULL, messageFull);
    i.putExtra(EXTRAS_TIMESTAMP, timestamp);
    i.putExtra(EXTRAS_CONTACT_ID, contactId);
    i.putExtra(EXTRAS_CONTACT_LOOKUP, contactLookupKey);
    i.putExtra(EXTRAS_CONTACT_NAME, contactName);
    i.putExtra(EXTRAS_UNREAD_COUNT, unreadCount);
    i.putExtra(EXTRAS_THREAD_ID, threadId);
    i.putExtra(EXTRAS_MESSAGE_TYPE, messageType);
    i.putExtra(EXTRAS_NOTIFY, notify);
    i.putExtra(EXTRAS_REMINDER_COUNT, reminderCount);
    i.putExtra(EXTRAS_MESSAGE_ID, messageId);
    i.putExtra(EXTRAS_EMAIL_GATEWAY, fromEmailGateway);
  }

  public Intent getPopupIntent() {
    Intent popup = new Intent(context, SmsPopupActivity.class);
    popup.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
    addToIntent(popup);
    return popup;
  }

  /**
   * Fetch the "reply to" message intent
   * 
   * @param replyToThread whether or not to reply using the message threadId or using the
   * sender address
   * 
   * @return the intent to pass to startActivity()
   */
  public Intent getReplyIntent(boolean replyToThread) {
    if (messageType == MESSAGE_TYPE_MMS) {
      locateThreadId();
      return SmsPopupUtils.getSmsToIntent(context, threadId);
    } else if (messageType == MESSAGE_TYPE_SMS) {
      locateThreadId();
      /*
       * There are two ways to reply to a message, by "viewing" the threadId or by
       * sending a new message to the address.  In most cases we should just execute
       * the former, but in some cases its better to send a new message to an address
       * (apps like Google Voice will intercept this intent as they don't seem to look
       * at the threadId).
       */
      if (replyToThread && threadId > 0) {
        if (Log.DEBUG) Log.v("Replying by threadId: " + threadId);
        return SmsPopupUtils.getSmsToIntent(context, threadId);
      } else {
        if (Log.DEBUG) Log.v("Replying by address: " + fromAddress);
        return SmsPopupUtils.getSmsToIntent(context, fromAddress);
      }
    }
    return null;
  }

  public Intent getReplyIntent() {
    return getReplyIntent(true);
  }

  public void setThreadRead() {
    locateThreadId();
    SmsPopupUtils.setThreadRead(context, threadId);
  }

  public void setMessageRead() {
    locateMessageId();
    SmsPopupUtils.setMessageRead(context, messageId, messageType);
  }

  public void setUnreadCount(int _unreadCount) {
    unreadCount = _unreadCount;
  }

  public int getUnreadCount() {
    return unreadCount;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public MessageClass getMessageClass() {
    return messageClass;
  }

  public CharSequence getFormattedTimestamp() {
    return DateUtils.formatDateTime(context, timestamp, DateUtils.FORMAT_SHOW_TIME);
  }

  public String getContactName() {
    if (contactName == null) {
      contactName = context.getString(android.R.string.unknownName);
    }
    return contactName;
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

  public boolean getNotify() {
    if (Log.DEBUG) Log.v("getNotify() - notify is " + notify);
    return notify;
  }
  
  public void resetNotify() {
    notify = false;
  }

  public int getReminderCount() {
    return reminderCount;
  }

  public void updateReminderCount(int count) {
    reminderCount = count;
  }

  public void incrementReminderCount() {
    reminderCount++;
  }

  public void delete() {
    SmsPopupUtils.deleteMessage(context, getMessageId(), threadId, messageType);
  }

  public void locateThreadId() {
    if (threadId == 0) {
     // threadId = SmsPopupUtils.findThreadIdFromAddress(context, fromAddress);
    }
  }

  public long getThreadId() {
    locateThreadId();
    return threadId;
  }

  public void locateMessageId() {
    if (messageId == 0) {
      if (threadId == 0) {
        locateThreadId();
      }
      messageId =
        SmsPopupUtils.findMessageId(context, threadId, timestamp, messageBody, messageType);
    }
  }

  public long getMessageId() {
    locateMessageId();
    return messageId;
  }

  public String getContactId() {
    return contactId;
  }

  public String getContactLookupKey() {
    return contactLookupKey;
  }

  public String getAddress() {
    return fromAddress;
  }

  public boolean isEmail() {
    return fromEmailGateway;
  }

  /**
   * Sned a reply to this message
   * 
   * @param quickreply the message to send
   * @return true of the message was sent, false otherwise
   */
  public boolean replyToMessage(String quickReply) {

    // Mark the message we're replying to as read
    setMessageRead();

    // Send new message
    SmsMessageSender sender =
      new SmsMessageSender(context, new String[] {fromAddress}, quickReply, getThreadId());

    return sender.sendMessage();
  }

}