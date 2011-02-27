package net.anei.cadpage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmsMsgParser;

import android.app.Activity;
import android.content.Context;
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
  
  // List of messages appended to original message
  // Yes it would have made more sense to put the original message in the list
  // as well, but then we would loose backward compatibility with messages
  // saved before the extra message list was added.
  private List<String> extraMsgBody = null;
  private long timestamp = 0;
  private int messageType = 0;
  private boolean fromEmailGateway = false;
  private MessageClass messageClass = null;
  private boolean read = false;             
  private boolean locked = false;
  private transient SmsMsgInfo info = null;
  private int msgId = 0;
  private String location = null;
  
  private transient String parseAddress = null;
  private transient String parseSubject = null;
  private transient String parseMessageBody = null;
  private transient boolean expectMore = false;
  
  // Temporary fields being monitored to see if they will be of any
  // use in identifying multi-part messages
  private long sentTime = 0L;
  private int iccIndex = 0;

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
    sentTime = sms.getTimestampMillis();
    iccIndex = sms.getIndexOnIcc();

    String body;
    if (messages.length == 1 || sms.isReplace()) {
      body = sms.getDisplayMessageBody();
    } else {
      StringBuilder bodyText = new StringBuilder();
      for (int i = 0; i < messages.length; i++) {
        bodyText.append(messages[i].getMessageBody());
      }
      body = bodyText.toString();
    }
    messageBody = body;
    
    // Calculate the from address and body to be used for parsing purposes
    getParseInfo();

  }

  /**
   * Construct dummy SmsMmsMessage test notifications 
   */
  public SmsMmsMessage(String fromAddress, String subject, String messageBody,
      long timestamp, int messageType) {

    this.fromAddress = fromAddress;
    this.messageBody = messageBody;
    this.timestamp = timestamp;
    this.messageType = messageType;
    this.location = "GeneralAlert";
    
    this.parseAddress = fromAddress;
    this.parseSubject =subject;
    this.parseMessageBody = messageBody;
  }

  /**
   * Construct test SmsMmsMessage message to check getParseInfo() logic 
   */
  public SmsMmsMessage(String fromAddress, String messageBody,
      long timestamp, int messageType) {

    this.fromAddress = fromAddress;
    this.messageBody = messageBody;
    this.timestamp = timestamp;
    this.messageType = messageType;
    this.location = "GeneralAlert";
    
    getParseInfo();
  }

  /**
   * Merge parsed data from a subsequent text message
   * @param message subsequent text message
   */
  public void merge(SmsMmsMessage message) {
    if (extraMsgBody == null) extraMsgBody = new ArrayList<String>();
    extraMsgBody.add(message.messageBody);
    parseMessageBody = parseMessageBody + " " + message.parseMessageBody;
    expectMore = message.expectMore;
  }
  
  /**
   * Read serialized SmsMmsMessage object from Object input stream
   */
  private void readObject(java.io.ObjectInputStream stream)
  throws IOException, ClassNotFoundException {
    stream.defaultReadObject();
    getParseInfo();
    if (extraMsgBody != null) {
      for (String msgBody : extraMsgBody) {
        String saveAddress = parseAddress;
        String saveSubject = parseSubject;
        String saveBody = parseMessageBody;
        expectMore = false;
        getParseInfo(msgBody);
        parseAddress = saveAddress;
        parseSubject = saveSubject;
        parseMessageBody = saveBody + " " + parseMessageBody;
      }
    }
  }
  
  // Patterns used to perform front end descrambling
  private static final Pattern[] MSG_HEADER_PTNS = new Pattern[]{
    Pattern.compile("^(000\\d)/(000\\d)\\b"),
    Pattern.compile("^(\\d)of(\\d):"),
    Pattern.compile("^\\((\\d)/(\\d)\\)")
  };
  private static final Pattern PAGECOPY_PATTERN = Pattern.compile("Pagecopy-Fr:(\\S*)\\s");
  private static final Pattern EMAIL_PATTERN = 
    Pattern.compile("^([\\w\\.]+@[\\w\\.]+)( / / )");
  private static final Pattern S_M_PATTERN = Pattern.compile("^S: *([^:]*) +M:");
  
  /**
   * Perform any front end unscrambling required to recover the original text
   * message sent by dispatch for parsing purposes.
   */
  private void getParseInfo() {
    getParseInfo(messageBody);
  }
  
  private void getParseInfo(String body) {
    
    // Set message body to empty string if we don't have one
    if (body == null) body = "";
    
    // Start by decoding common HTML sequences
    body = body.replaceAll("&nbsp;",  " ").replaceAll("&amp;",  "&")
               .replaceAll("<br>", "\n").replaceAll("&gt;", ">").replaceAll("&lt;", "<");
    
    // default address and subject to obvious values
    parseAddress = fromAddress;
    parseSubject = "";
    
    // Dummy loop we can break out of
    do {
      
      // Check the message header pattern,these contain a msg number and total
      // counts.  If the values don't match, set the flag indicating more data
      // is expected
      Matcher match = null;
      boolean found = false;
      for (Pattern ptn : MSG_HEADER_PTNS) {
        match = ptn.matcher(body);
        found = match.find();
        if (found) break;
      }
      if (found) {
        if (! match.group(1).equals(match.group(2))) expectMore = true;
        body = body.substring(match.end()).trim();
        break;
      }
      
      /* Decode patterns that look like this.....
      1 of 3
      FRM:CAD@livingstoncounty.livco
      SUBJ:DO NOT REPLY
      MSG:CAD:FYI: ;CITAF;5579 E GRAND RIVER;WILDWOOD DR;Event spawned from CITIZEN ASSIST LAW. [12/10/10
      (Con't) 2 of 3
      20:08:59 SPHILLIPS] CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAINBREAK [12/10/10 20:04:40 HROSSNER] CALLER ADV OF A WATER MAIN
      (Con 3 of 3
      BREAK(End)
      
      Or This
      
      FRM:e@fireblitz.com <Body%3AFRM%3Ae@fireblitz.com>
      MSG:48: TOWNHOUSE FIRE
      E818 BO802
      9903 BREEZY KNOLL CT [DEAD END & GREEN HAVEN RD]
      12/23 23:32
      http://fireblitz.com/18/8.shtm
      */
      int pt1 = -1;
      int pt2 = -1;
      if (body.startsWith("FRM:")) {
        pt1 = 0;
        pt2 = 4;
      } else {
        pt1 = body.indexOf("\nFRM:");
        pt2 = pt1 + 5;
      }
      if (pt1 >= 0) {
        int pt3 = body.indexOf('\n', pt2);
        if (pt3 >= 0) {
          parseAddress = body.substring(pt2, pt3).trim();
          pt1 = pt3;
          pt3 = body.indexOf("\nSUBJ:", pt1);
          parseSubject = "";
          if (pt3 >= 0) {
            pt1 = pt3;
            pt2 = pt3 + 6;
            pt3 = body.indexOf('\n', pt2);
            if (pt3 >= 0) {
              parseSubject = body.substring(pt2, pt3);
              pt1 = pt3;
            }
          }
          pt3 = body.indexOf("\nMSG:", pt1);
          if (pt3 >= 0) {
            pt1 = pt3;
            pt2 = pt1 + 5;
            if (body.length() > pt2 && Character.isWhitespace(body.charAt(pt2))) pt2++;
            StringBuilder sb = new StringBuilder();
            boolean skipBreak = false;
            for (String line : body.substring(pt2).split("\n")) {
              if (line.startsWith("(Con")) {
                skipBreak = true;
              } else {
                if (sb.length() > 0) {
                  sb.append(skipBreak ? ' ' : '\n');
                }
                sb.append(line);
                skipBreak = false;
              }
            }
            int len = sb.length()-5;
            if (len >= 0 && sb.substring(len).equals("(End)")) sb.setLength(len);
            body = sb.toString().trim();
            break;
          }
        }
      }
      
      /* Decode patterns that look like this 
      CommCenter@ccems.com <Body%3ACommCenter@ccems.com> [] TAP OUT (SAL)
       */
      int ipt = body.indexOf(" [] ");
      if (ipt >= 0) {
        parseAddress = body.substring(0, ipt).trim();
        if (parseAddress.contains("@")) {
          parseSubject = "";
          body = body.substring(ipt+4).trim();
          break;
        }
      }
      
      /* Decode patterns that look like this
      Subject:HCCAD\nEOC:F03 WIRES >WIRES/POLE SHAWNEE DR&WALTERS MILL RD XS: WALTERS MILL RD FOREST HILL NOT ENTERED Cad: 2010-000019169
      */
      if (body.startsWith("Subject:")) {
        ipt = body.indexOf('\n');
        if (ipt >= 0) {
          parseSubject = body.substring(8,ipt).trim();
          body = body.substring(ipt+1).trim();
          break;
        }
      }
      
      /* Decode patterns that look like this
        Dispatch@ci.waynesboro.va.us <Body%3ADispatch@ci.waynesboro.va.us> Msg: Dispatch:2ND CALL 1001 HOPEMAN PKWY, ZAP12 INJURIES FROM PREVIOUS MVA
      */
      ipt = body.indexOf(" Msg:");
      if (ipt >= 0) {
        String addr = body.substring(0,ipt).trim();
        if (addr.contains("@") && ! addr.contains(":")) {
          parseAddress = addr;
          body = body.substring(ipt+5).trim();
          break;
        }
      }
      
      /* Decode patterns that look like this
       * Pagecopy-Fr:CAD@livingstoncounty.livco\nCAD:FYI: ;OVDOSE;4676 KENMORE DR;[Medical Priority Info] RESPONSE: P1 STA 1
       */
      match = PAGECOPY_PATTERN.matcher(body);
      if (match.find()) {
        parseAddress = match.group(1);
        body = body.substring(match.end()).trim();
        break;
      }
      
      /* Decode patterns that look like
       * S:subject M:msg
       */
      match = S_M_PATTERN.matcher(body);
      if (match.find()) {
        parseSubject = match.group(1);
        body = body.substring(match.end()).trim();
        break;
      }
      
      /* Decode patterns that match EMAIL_PATTERN, which is basically an email address
       * followed by one of a set of known delimiters
       */
      match = EMAIL_PATTERN.matcher(body);
      if (match.find()) {
        parseAddress = body.substring(0, match.end(1));
        body = body.substring(match.end()).trim();
        break;
      }

    } while (false);
    
    // Finally, leading values in square or round brackets are turned into
    // message subjects.  There may be more than one of these, in which case
    // only the last is retained
    int pt1 = 0;
    while (pt1 < body.length()) {
      while (pt1 < body.length() && body.charAt(pt1) == ' ') pt1++;
      if (pt1 >= body.length()) break;
      
      char d1 = body.charAt(pt1);
      if (d1 != '(' && d1 != '[') break;
      
      char d2 = (d1 == '(' ? ')' : ']');
      int level = 0;
      int pt2;
      for (pt2 = pt1; pt2 < body.length(); pt2++) {
        char c = body.charAt(pt2);
        if (c == d1) level++;
        if (c == d2) level--;
        if (level == 0) {
          parseSubject = body.substring(pt1+1, pt2).trim();
          pt1 = pt2+1;
          break;
        }
      }
      if (pt2 >= body.length()) break;
    }
    
    parseMessageBody = body.substring(pt1);
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
  
  public String getSubject() {
    return parseSubject;
  }

  public String getMessageBody() {
    return parseMessageBody;
  }
  
  public int getMessageType() {
    return messageType;
  }

  public String getAddress() {
    return parseAddress;
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
  
  public boolean isExpectMore() {
    if (expectMore) return true;
    if (info != null) return info.isExpectMore();
    return false;
  }
  
  public SmsMsgInfo getInfo() {
    
    // Some special logic if the previous location was General
    // And the current location code preference is not general
    // And this message text is a valid message for this location code
    // then use the results of the new location code.
    // NOTE: Our location and info members will be set as a side effect of
    // a successful isPageMsg call
    if (location != null && location.startsWith("General")) {
      String curLocCode = ManagePreferences.location();
      if (! curLocCode.startsWith("General")) {
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

    sb.append("\nEff From:");
    sb.append(parseAddress);
    
    sb.append("\nType:");
    sb.append(messageType);
    
    sb.append("\nClass:");
    sb.append(messageClass);
    
    sb.append("\nGateway:");
    sb.append(fromEmailGateway);
    
    sb.append("\nSubject:");
    sb.append(parseSubject);
    
    sb.append("\nBody:");
    sb.append(escape(messageBody));
    if (extraMsgBody != null) {
      for (String body : extraMsgBody) {
        sb.append("\nBody:");
        sb.append(escape(body));
      }
    }
    
    sb.append("\nEff Body:");
    sb.append(parseMessageBody);
    
    sb.append("\nLocation:");
    sb.append(location);
    
    sb.append("\nExpectMore:");
    sb.append(expectMore);
    
    sb.append("\nSend time:");
    sb.append(sentTime);
    sb.append("\nRec time: ");
    sb.append(timestamp);
    sb.append("\nICC Index:");
    sb.append(iccIndex);
    
    
    sb.append('\n');
  }

  /**
   * Escape a string containing tabs, newlines, or multiple spaces so it
   * will better survive transmission through an email message
   * @param message message to be escaped
   * @return escaped message
   */
  private static final Pattern MULT_SPACES = Pattern.compile(" {2,}");
  static String escape(String message) {
    message = message.replaceAll("\t", "\\\\t");
    message = message.replaceAll("\n", "\\\\n\n");
    Matcher match = MULT_SPACES.matcher(message);
    if (match.find()) {
      StringBuffer sb = new StringBuffer();
      do {
        match.appendReplacement(sb, "\\\\" + (match.end()-match.start()) + "s");
      } while (match.find());
      match.appendTail(sb);
      message = sb.toString();
    }
    return message;
  }

  /**
   * Fix any obsolete location codes
   * @param context current context
   */
  public void fixOldLocation(Context context) {
    if (location != null) location = ManagePreferences.convertOldLocationCode(context, location);
  }

  
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof SmsMmsMessage)) return false;
    SmsMmsMessage msg = (SmsMmsMessage)obj;
    return (match(fromAddress, msg.fromAddress) &&
             match(messageBody, msg.messageBody));
  }
  
  private boolean match(String s1, String s2) {
    if (s1 == null && s2 == null) return true;
    if (s1 == null || s2 == null) return false;
    return s1.equals(s2);
  }
}