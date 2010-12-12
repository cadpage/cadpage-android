package net.anei.cadpage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.Serializable;

import net.anei.cadpage.parsers.SmsMsgParser;

import android.app.Activity;
import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsMessage;
import android.telephony.SmsMessage.MessageClass;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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
  private transient SmsMsgInfo info = null;
  private int msgId = 0;
  private String location = null;

  
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
  
  public void toggleLocked() {
    setLocked(! isLocked());
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
    messageFull = _messageBody;
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
   * Construct dummy SmsMmsMessage test notifications 
   */
  public SmsMmsMessage(String _fromAddress, String _messageBody,
      long _timestamp, int _messageType) {

    fromAddress = _fromAddress;
    messageBody = _messageBody;
    messageFull = _messageBody;
    timestamp = _timestamp;
    messageType = _messageType;
    location = "GeneralAlert";
  }
  

  public void setParserInfo(String location, SmsMsgInfo info) {
    this.location = location;
    this.info = info;
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
    return getInfo().getCall();
  }
  
  public String getLocation() {
    return location;
  }
  
  public SmsMsgInfo getInfo() {
    
    // Some special logic if the previous location was General
    // And the current location code preference is not general
    // And this message text is a valid message for this location code
    // then use the results of the new location code.
    // NOTE: Our location and info members will be set as a side effect of
    // a successful isPageMsg call
    if (location != null && location.equals("General")) {
      String curLocCode = ManagePreferences.location();
      if (! curLocCode.equals("General")) {
        if (ManageParsers.getInstance().getParser(curLocCode).isPageMsg(this)) {
          return info;
        }
      }
    }
    
    // If we don't have an info object, get a new one
    // If we have a historical location code, use it
    // Otherwise use the current configured location code.
    // Again, location and info members are set as a side effect of a successful
    // isPageMsg method call
    if (info == null) {
      SmsMsgParser parser = ManageParsers.getInstance().getParser(location);
      if (! parser.isPageMsg(this)) {
        
        // It is almost impossible for the the parser call to fail for a
        // message where it previously succeeded.  But if it happens
        // try again with the general alert parser, which will never fail
        parser = ManageParsers.getInstance().getAlertParser();
        parser.isPageMsg(this);
      }
    }
    return info;
  }
  
  /**
   * Create option or context menu for message
   * @param context current context
   * @param menu menu to be constructed
   * @param display true if called from popup menu display
   */
  public static void createMenu(Activity context, Menu menu, boolean display) {
    MenuInflater inflater = context.getMenuInflater();
    inflater.inflate(R.menu.message_menu, menu);
    if (display) {
      menu.removeItem(R.id.open_item);
    } else {
      menu.removeItem(R.id.close_item);
    }
  }
  
  public void prepareMenu(Activity context, Menu menu) {
    for (int ndx = 0; ndx < menu.size(); ndx++) {
      final MenuItem item = menu.getItem(ndx);
      prepareItem(new ItemObject() {
        
        @Override
        public int getId() {
          return item.getItemId();
        }

        @Override
        public void setEnabled(boolean enabled) {
          item.setEnabled(enabled);
        }

        @Override
        public void setTitle(int resId) {
          item.setTitle(resId);
        }

        @Override
        public void setVisible(boolean visible) {
          item.setVisible(visible);
        }
        
      });
    }
  }
  
  public void prepareButton(int itemId, Button button) {
    final int fItemId = itemId;
    final Button fBtn = button;
    prepareItem(new ItemObject(){
      
      @Override
      public int getId() {
        return fItemId;
      }

      @Override
      public void setEnabled(boolean enabled) {
        fBtn.setEnabled(enabled);
      }

      @Override
      public void setTitle(int resId) {
        fBtn.setText(resId);
      }

      @Override
      public void setVisible(boolean visible) {
        fBtn.setVisibility(visible ? View.VISIBLE : View.GONE);
      }
    });
  }
  
  private interface ItemObject {
    public int getId();
    public void setTitle(int resId);
    public void setEnabled(boolean enabled);
    public void setVisible(boolean visible);
  }
  
  private void prepareItem(ItemObject item) {
    
    switch (item.getId()) {
    
    // Disabled button is never visible
    case 0:
      item.setVisible(false);
      break;
    
    // Disable map item if we have no address
    case R.id.map_item:
      item.setEnabled(getInfo().getAddress().length() > 0);
      break;
    
    // Change label on toggle lock item depending on current lock state
    case  R.id.toggle_lock_item:
      item.setTitle(isLocked() ? R.string.unlock_item_text : R.string.lock_item_text);
      break;
      
    // Delete is only enabled if message has been read and is not locked
    case R.id.delete_item:
      item.setEnabled(read && ! locked);
      break;
    }
  }

  /**
   * Handle a menu selection concerning this message
   * @param context current context
   * @param itemId Selected Menu ID
   * @param display true if called from message display dialog
   * @return true if menu item processed, false otherwise
   */
  public boolean menuItemSelected(Activity context, int itemId, boolean display) {
    switch (itemId) {
    case R.id.open_item:
      SmsPopupActivity.launchActivity(context, this);
      return true;
      
    case R.id.ack_item:
      // Doesn't do anything yet (except clear notification)
      return true;
      
    case R.id.map_item:
      SmsPopupUtils.mapMessage(context, getInfo());
      return true;
      
    case R.id.toggle_lock_item:
      toggleLocked();
      return true;
      
    case R.id.delete_item:
      SmsMessageQueue.getInstance().deleteMessage(this);
      if (display) context.finish();
      return true;
      
    case R.id.close_item:
      context.finish();
      return true;
      
    case R.id.email_item:
      EmailDeveloperActivity.sendMessageEmail(context,  msgId);
      return true;
    
    default:
      return false;
    }
  }


  /**
   * Append message information to support message under construction
   * @param sb String builder holding message being constructed
   */
  public void addMessageInfo(Context context, StringBuilder sb) {
    sb.append("\n\nMessage Contents\n");
    
    sb.append("Time:");
    sb.append(DateFormat.getLongDateFormat(context).format(timestamp));
    sb.append(" ");
    sb.append(DateFormat.getTimeFormat(context).format(timestamp));

    sb.append("\nFrom:");
    sb.append(fromAddress);
    
    sb.append("\nType:");
    sb.append(messageType);
    
    sb.append("\nClass:");
    sb.append(messageClass);
    
    sb.append("\nGateway:");
    sb.append(fromEmailGateway);
    
    sb.append("\nBody:");
    sb.append(messageBody);
    
    sb.append("\nFull Text:");
    sb.append(messageFull);
    
    sb.append("\nLocation:");
    sb.append(location);
    sb.append('\n');
  }
   
  /**
   * Read serialized SmsMmsMessage object from Object input stream
   */
  public static SmsMmsMessage readObject(ObjectInputStream is) 
  throws OptionalDataException, ClassNotFoundException, IOException {
    SmsMmsMessage message = (SmsMmsMessage)is.readObject();
    return message;

  }

  /**
   * Fix any obsolete location codes
   * @param context current context
   */
  public void fixOldLocation(Context context) {
    if (location != null) location = ManagePreferences.convertOldLocationCode(context, location);
  }
}