package net.anei.cadpage;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.donation.UserAcctManager;
import net.anei.cadpage.parsers.ManageParsers;
import net.anei.cadpage.parsers.Message;
import net.anei.cadpage.parsers.MessageBuilder;
import net.anei.cadpage.parsers.MsgInfo;
import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.SplitMsgOptions;
import net.anei.cadpage.vendors.VendorManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsMessage;
import android.telephony.SmsMessage.MessageClass;
import android.text.format.DateUtils;
import static net.anei.cadpage.BroadcastBindings.*;



public class SmsMmsMessage implements Serializable {

  // Serialized object version code
  private static final long serialVersionUID = 1L;

  // Message types
  public static final int MESSAGE_TYPE_SMS = 0;
  public static final int MESSAGE_TYPE_MMS = 1;
  public static final int MESSAGE_TYPE_C2DM = 2;
  
  public static final int PARSE_FLG_FORCE = 1;

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
  private MessageClass messageClass = null;
  private boolean read = false;             
  private boolean locked = false;
  private transient Date incidentDate = null;
  private int msgId = 0;
  private String location = null;
  
  // Content location for MMS messages
  private String contentLoc = null;
  private String mmsMsgId = null;
  private String subject = null;
  
  // Location code and sponsor C2DM messages
  private String reqLocation = null;
  private String vendorCode = null;
  
  // Tracking configured Active911 parsers that we do not yet support
  private String missingParsers = null;
  
  // Dead member replaced by vendor
  private String sponsor = null;
  
  // C2DM page information
  private String ackReq = null;
  private String ackURL = null;
  private boolean ackNeeded = false;
  private String infoURL = null;
  private String callId = null;
  private String serverTime = null;
  
  // custom response menu
  private String responseMenu = null;
  private boolean responseMenuVisible = true;
  
  // Flag indicating location tracking has been activated
  private boolean tracking = false;
  
  // Temporary fields being monitored to see if they will be of any
  // use in identifying multi-part messages
  private long sentTime = 0L;
  
  private transient Message parseInfo = null;
  
  private transient SplitMsgOptions splitMsgOptions = null;
  
  private transient String effReqLocation = null;

  /**
   * Copy constructor
   * Copies everything but message content which has to be handled separately
   * @param msg source message
   */
  private SmsMmsMessage(SmsMmsMessage msg) {
    this.fromAddress = msg.fromAddress;
    this.timestamp = msg.timestamp;
    this.messageType = msg.messageType;
    this.messageClass = msg.messageClass;
    this.read = msg.read;
    this.locked = msg.locked;
    this.incidentDate = msg.incidentDate;
    this.location = msg.location;
    this.contentLoc = msg.contentLoc;
    this.mmsMsgId = msg.mmsMsgId;
    this.subject = msg.subject;
    this.reqLocation = msg.reqLocation;
    this.effReqLocation = msg.effReqLocation;
    this.vendorCode = msg.vendorCode;
    this.missingParsers = msg.missingParsers;
    this.ackReq = msg.ackReq;
    this.ackURL = msg.ackURL;
    this.ackNeeded = msg.ackNeeded;
    this.infoURL = msg.infoURL;
    this.callId = msg.callId;
    this.serverTime = msg.serverTime;
    this.responseMenu = msg.responseMenu;
    this.sentTime = msg.sentTime;
    this.splitMsgOptions = msg.splitMsgOptions;
  }
 
  /**
   * @return the split message configuration options to be used for handling
   * this message.
   */
  public SplitMsgOptions getSplitMsgOptions() {
    if (splitMsgOptions == null) {
      splitMsgOptions = ManagePreferences.getDefaultSplitMsgOptions();
    }
    return splitMsgOptions;
  }

  public boolean isRead() {
    return read;
  }
  
  public void setRead(boolean read) {
    if (read == this.read) return;
    this.read = read;
    reportDataChange();
    SmsMessageQueue.getInstance().calcNewCallCount();
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
  
  /**
   * @return true if this message can be deleted
   */
  public boolean canDelete() {
    
    // Can only be deleted if read and not locked
    // Config setting allows unread messages to be deleted
    return (read || ManagePreferences.deleteUnopen()) && ! locked;
  }
  
  public int getMsgId() {
    return msgId;
  }
  
  public void setMsgId(int msgId) {
    this.msgId = msgId;
  }
  
  public String getAckReq() {
    return ackReq;
  }
  
  public String getResponseMenu() {
    return responseMenu;
  }
  
  public boolean isResponseMenuVisible() {
    return responseMenuVisible;
  }
  
  public void setResponseMenuVisible(boolean responseMenuVisible) {
    if (this.responseMenuVisible == responseMenuVisible) return;
    this.responseMenuVisible = responseMenuVisible;
    reportDataChange();
  }
  
  public String getAckURL() {
    if (ackURL == null) return null;
    return VendorManager.instance().addAccountInfo(vendorCode, ackURL);
  }
  
  public FilterOptions getFilterOptions() {
    MsgInfo info = getInfo();
    if (info == null)  return ManagePreferences.genAlertOptions();
    MsgInfo.MsgType msgType = info.getMsgType();
    if (msgType == MsgInfo.MsgType.GEN_ALERT) return ManagePreferences.genAlertOptions();
    if (msgType == MsgInfo.MsgType.RUN_REPORT) return ManagePreferences.runReportOptions();
    return new FilterOptions();
  }
  

  /**
   * @return true if message was parsed with Active911 parser
   */
  public boolean isActive911ParsedMsg() {
    
    // All we do is check the parsed message parser code is Active911.
    // Active911 always sends us this parser code, but if the original message
    // was parsed with a Cadpage parser, the message will contain its own
    // parser code override, which will override the "Active911" value.
    MsgInfo info = getInfo();
    if (info == null) return false;
    MsgParser parser = info.getParser();
    if (parser == null) return false;
    String parserCode = parser.getParserCode();
    return parserCode != null && parserCode.equals("Active911");
  }
  
  /**
   * @return Active911 message ID if appropriate, null otherwise
   */
  public String getActive911MsgCode() {
    String tmp = getAckURL();
    if (tmp == null) return null;
    Matcher match = ACTIVE911_CODE_PTN.matcher(tmp);
    if (!match.find()) return null;
    return match.group(1);
  }
  private static final Pattern ACTIVE911_CODE_PTN = Pattern.compile("[&\\?]q=([A-Za-z0-9]+)\\b");
  
  private void reportDataChange() {
    if (msgId > 0) SmsMessageQueue.getInstance().notifyDataChange();
  }

  /**
   * Construct SMS SmsMmsMessage given a raw message (created from pdu), used for when
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
    if (fromAddress == null) fromAddress = "";
    try {
      messageClass = sms.getMessageClass();
    } catch (NullPointerException ex) {}
    sentTime = sms.getTimestampMillis();

    String body;
    if (messages.length == 1 || sms.isReplace()) {
      body = sms.getDisplayMessageBody();
    } else {
      StringBuilder bodyText = new StringBuilder();
      for (int i = 0; i < messages.length; i++) {
        // getMessageBody has been throwing exceptions on occasion :(
        try {
          bodyText.append(messages[i].getMessageBody());
        } catch (NullPointerException ex) {Log.e(ex);}
      }
      body = bodyText.toString();
    }
    messageBody = body;
    
    // Calculate the from address and body to be used for parsing purposes
    parseInfo = bldParseInfo();
  }
  

  /**
   * Construct MMS SmsMmsMessage given a raw message (created from pdu), used for when
   * a message is initially received via the network.
   */
  public SmsMmsMessage(MessageClass messageClass, String fromAddress, 
                        String subject, String contentLoc, String mmsMsgId,
                        long timestamp) {
    this.timestamp = timestamp;
    messageType = MESSAGE_TYPE_MMS;
    this.messageClass = messageClass;
    this.fromAddress = fromAddress;
    this.subject = (subject == null ? "" : subject);
    this.contentLoc = contentLoc;
    this.mmsMsgId = mmsMsgId;
    this.messageBody = null;
  }
  
  /**
   * Set the message body for an MMS type message when it is finally retrieved
   * @param messageBody new message body text
   */
  public void setMessageBody(String messageBody) {
    this.messageBody = messageBody;
    
    // Calculate the from address and body to be used for parsing purposes
    parseInfo = bldParseInfo();
  }

  /**
   * Create a timeout marker message.  This servers no purpose other than
   * to mark an MMS message timeout in the log buffer
   * @return timeout marker message to be logged
   */
  public SmsMmsMessage timeoutMarker() {
    SmsMmsMessage result = 
          new SmsMmsMessage(messageClass, fromAddress, subject, contentLoc, 
                            mmsMsgId, System.currentTimeMillis());
    result.messageBody = "*** Content Timeout ***";
    return result;
  }
  
  /**
   * Construct SmsMmsMessage from information received in a C2DM message 
   * @param from message sender
   * @param subject message subject
   * @param messageBody message body
   * @param timestamp received times tamp
   * @param reqLocation requested location code
   * @param vendorCode vendor code
   * @param ackReq acknowledge request code
   * @param ackURL acknowledge URL
   */
  public SmsMmsMessage(String from, String subject, String messageBody,
                        long timestamp, String reqLocation, String vendorCode, 
                        String ackReq, String ackURL, 
                        String callId, String serverTime, String infoURL) {
    this.messageType = MESSAGE_TYPE_C2DM;
    this.fromAddress = from;
    this.subject = subject;
    this.messageBody = messageBody;
    this.timestamp = timestamp;
    this.reqLocation = reqLocation;
    this.vendorCode = vendorCode;
    this.ackURL = ackURL;
    this.callId = callId;
    this.serverTime = serverTime;
    this.infoURL = infoURL;
    this.ackNeeded = ackReq.contains("A");
    
    calcSplitMsgOptions();
    
    
    this.parseInfo = bldParseInfo();
    
    // If request code contains a custom menu, separate that out
    Matcher match = SQ_BRACKETS.matcher(ackReq);
    if (match.find()) {
      this.responseMenu = match.group(1);
      ackReq = ackReq.substring(0,match.start()) + ackReq.substring(match.end());
    }
    
    // Check for a predefined custom response menu
    else {
      match = NUMBER.matcher(ackReq);
      if (match.find()) {
        int code = Integer.parseInt(match.group());
        this.responseMenu = VendorManager.instance().getResponseMenu(vendorCode, code);
      }
    }
    this.ackReq = ackReq;

  }
  private static final Pattern NUMBER = Pattern.compile("\\d+");
  private static final Pattern SQ_BRACKETS = Pattern.compile("\\[(.*)\\]");
  

  /**
   * Recalculate transient members from the non-transient C2DM requested location
   * This needs to be done as soon as the object is created before we try to do
   * anything that might require the parser code or split message options
   */
  private void calcSplitMsgOptions() {
    
    // If specific location was requested with a Active911 page message, convert it
    // to normal Cadpage parser codes.  We need to do this ASAP before anything
    // tries to reference any of the split message options
    if (reqLocation != null) {
      try {
        if (reqLocation.contains("/") || reqLocation.equals("Active911Summary")) {
          String[] results = VendorManager.instance().convertLocationCode(vendorCode, reqLocation);
          effReqLocation = results[0];
          missingParsers = results[1];
        } else {
          effReqLocation = reqLocation;
        }
        if (vendorCode != null && vendorCode.equals("Active911")) {
          MsgParser parser = ManageParsers.getInstance().getParser(effReqLocation);
          if (!ManagePreferences.overrideActive911SplitOptions() && parser != null) {
            splitMsgOptions = parser.getActive911SplitMsgOptions();
          }
        }
      } catch (RuntimeException ex) {
        ex.printStackTrace(System.out);
        Log.e(ex);
      }
    }
  }

  /**
   * Construct dummy SmsMmsMessage test notifications 
   */
  public SmsMmsMessage(String fromAddress, String subject, String messageBody,
                        long timestamp, int messageType) {

    this.fromAddress = fromAddress;
    this.subject = subject;
    this.messageBody = messageBody;
    this.timestamp = timestamp;
    this.messageType = messageType;
    this.location = "GeneralAlert";
    this.parseInfo = bldParseInfo(false, subject, messageBody);
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
    
    parseInfo = bldParseInfo();
  }

  /**
   * Construct combined message from a list of individual text messages
   * @param firstMsg the initially received message
   * @param list list of text messages
   */
  public SmsMmsMessage(SmsMmsMessage firstMsg, List<SmsMmsMessage> list) {
    this(firstMsg);

    for (SmsMmsMessage msg : list) {
      if (msg != null) {
        if (this.messageBody == null) {
          this.messageBody = msg.messageBody;
        } else {
          if (extraMsgBody == null) extraMsgBody = new ArrayList<String>();
          extraMsgBody.add(msg.messageBody);
        }
      }
    }
    buildParseInfo();
  }
  
  /**
   * Check if message is a vendor discovery query.  This should be called as 
   * soon as the SmsMmsMessage object is constructed form an SMS or MMS message
   * @param context current context
   * @return true if this was a vendor discovery message that should not
   * be processed further by anyone
   */
  public boolean isDiscoveryQuery(Context context) {
    if (messageBody == null) return false;
    messageBody = VendorManager.instance().discoverQuery(context, fromAddress, messageBody);
    return (messageBody == null);
  }

  /**
   * Read serialized SmsMmsMessage object from Object input stream
   */
  private void readObject(java.io.ObjectInputStream stream)
  throws IOException, ClassNotFoundException {
    stream.defaultReadObject();
    
    // Retrieve vendor Code from old Sponsor code
    if (vendorCode == null) vendorCode = sponsor;
    
    // Rebuild parsed message information
    buildParseInfo();
  }
  
  /**
   * Rebuild parse information (if necessary) after the insert blanks between
   * split message option has changed
   * @param changeCode Level of split message option change<br>
   * 0 - No Change<br>
   * 1 - keep lead break option change<br>
   * 2 - insert blank option change<br>
   * 3 - merge message option change
   * @return true if message parse information may have changed
   */
  public boolean splitOptionChange(int changeCode) {
    
    // If nothing changed, nothing needs to be done
    
    if (changeCode == 0) return false;
    
    // if this is a merged alert, we need to reparse it
    // Otherwise ask the Message class if call needs to be reparsed
    if (extraMsgBody == null) {
      if (!Message.splitMsgOptionChange(changeCode, messageBody)) return false;
    }
    
    // Otherwise rebuild the reparse parse message body
    buildParseInfo();
    return true;
  }

  /**
   * Construct parseInfo message object
   */
  private void buildParseInfo() {
    parseInfo = bldParseInfo();
    if (extraMsgBody != null) {
      boolean lock = getMsgCount() > 0;
      Message[] msgParts = new Message[extraMsgBody.size()+1];
      msgParts[0] = parseInfo;
      for (int jj = 0; jj<extraMsgBody.size(); jj++) {
        msgParts[jj+1] = bldParseInfo(true, subject, extraMsgBody.get(jj));
      }
      MsgParser parser = getParser();
      parseInfo = new MessageBuilder(parser, getSplitMsgOptions()).buildMessage(msgParts, lock);
      MsgInfo info = parseInfo.getInfo();
      if (info != null) location = info.getParserCode();
    }
  }
  
  private Message bldParseInfo() {
    return bldParseInfo(true, subject, messageBody);
  }
  
  private Message bldParseInfo(boolean preParse, String msgSubject, String body) {
    return new Message(preParse, fromAddress, msgSubject, body, getSplitMsgOptions());
  }

  public boolean isPageMsg() {
    return isPageMsg(0);
  }
  
  /**
   * Perform a standalone trial parse of a particular message text
   * and return the result
   * @param body text message body to be parsed
   * @param flags parse flags
   * @return Parsed information object
   */
  public Message trialParse(String body, int flags) {
    SmsMmsMessage tmpMsg = new SmsMmsMessage(this);
    tmpMsg.messageBody = body;
    tmpMsg.isPageMsg(flags);
    return tmpMsg.parseInfo;
  }
  
  /**
   * Try to parse this message as a CAD page
   * @param flags parse flags
   * @return true if this has been identified and parsed as either a CAD page
   * or a general alert
   */
  public boolean isPageMsg(int flags) {
    
    boolean force = (flags & PARSE_FLG_FORCE) != 0;
    
    int parserFlags = 0;
    
    // First step is to check for an override sender filter
    if (!force && ManagePreferences.overrideFilter()) {
      String filter = ManagePreferences.filter();
      if (filter.length() > 1) {
        if (!MsgParser.matchFilter(getFromAddress(), filter)) return false;
        parserFlags |= MsgParser.PARSE_FLG_POSITIVE_ID;
      }
      parserFlags |= MsgParser.PARSE_FLG_SKIP_FILTER;
    }
    
    // If we don't have a parse message, this is as far as we can go.  This
    // happens for MMS messages that come in with an address but we have not
    // yet downloaded the message body
    if (parseInfo == null) return true;
    
    // Set up parser flags  We will process general alerts if we do anything
    // at all with general alerts
    if (force) parserFlags |= MsgParser.PARSE_FLG_FORCE;
    
    // OK, that is it for flags, now lets see about getting the right parser
    MsgParser parser = getParser();
    
    // OK, parser gets to do its thing
    boolean ok = parser.isPageMsg(parseInfo, parserFlags);
    if (ok) location = parseInfo.getInfo().getParserCode();
    return ok;
  }

  /**
   * @return parser to be used to parse this message
   */
  private MsgParser getParser() {
    
    // If specific location was requested with a C2DM message, use it to get
    // a parser.  This is one of the only times we will ignore a bad location
    // code
    MsgParser parser = null;
    if (effReqLocation != null && !ManagePreferences.overrideVendorLoc()) {
      try {
        parser = ManageParsers.getInstance().getParser(effReqLocation);
      } catch (RuntimeException ex) {
        Log.e(ex);
      }
    }
    
    // If that didn't work, get the default location parser
    if (parser == null) {
      parser = ManagePreferences.getCurrentParser();
    }
    return parser;
  }
  
  /**
   * Get a parsed information object calculated by a previous call to isPageMsg()
   * This can be called on a reconstructed message that previously was accepted
   * by isPageMsg() to reconstruct the parsed message information.  It should
   * not be called when a message is first constructed from received information.
   * isPageMsg should be called in those cases.
   * @return the parsed information object
   */
  public MsgInfo getInfo() {
    
    // If we didn't build a parse message info object when this was constructed
    // we never will have and parsed message information
    if (parseInfo == null) return null;

    // If we have already parsed the information, just return that
    MsgInfo info = parseInfo.getInfo();
    if (info != null) return info;
    
    // Early versions of the Cadpage parser were setting location to the secondary 
    // parser name which is cause subsequent attempt to parse the information with the
    // wrong parser to fail.  We don't do that anymore, but we do want to fix calls
    // that were parsed with that version.
    if (reqLocation != null && reqLocation.startsWith("Cadpage")) location = reqLocation;

    // Recalculate transient member information
    calcSplitMsgOptions();

    // Try reparsing any calls parsed with the general location parser
    if (reparseGeneral()) return parseInfo.getInfo();
    
    // Getting here with location still set to null almost certainly means
    // that a developer screwed up and called this method before calling
    // isPageMsg().  But just in case there are some as yet unknown exceptions
    // we only throw an exception if a developer is running this, otherwise
    // we preserve previous functionality
    if (location == null) {
      if (UserAcctManager.instance().isDeveloper()) {
        throw new RuntimeException("getInfo() called for unparsed msg");
      } else {
        return null;
      }
    }
    
    MsgParser parser =  ManageParsers.getInstance().getParser(location, messageBody);
    parser.isPageMsg(parseInfo, MsgParser.PARSE_FLG_POSITIVE_ID | MsgParser.PARSE_FLG_SKIP_FILTER);
    return parseInfo.getInfo();
  }
  
  /**
   * Call to repare general location messages when the parse location setting has changed
   * @return true if a general location message was succesfully reparsed
   */
  public boolean reparseGeneral() {
    
    // We only are interested in calls parsed by one of the general location parsers
    if (location == null || ! location.startsWith("General")) return false;
  
    
    // The effective location code is the vendor requested parser code if there is one, otherwise
    // get the current location code
    String tmpLocCode = effReqLocation != null ? effReqLocation : ManagePreferences.location();
    
    // If new code is another General parser, no point in trying to fix things
    if (tmpLocCode.startsWith("General") && ! tmpLocCode.contains(",")) return false;

    // Otherwise, try reparsing this call with the current parser code.
    // Might be a bad location code from direct vendor, so don't abort if we do not find a parser
    boolean good;
    try {
      good = (ManageParsers.getInstance().getParser(tmpLocCode).isPageMsg(parseInfo, MsgParser.PARSE_FLG_SKIP_FILTER | MsgParser.PARSE_FLG_REPARSE));
    } catch (RuntimeException ex) {
      return false;
    }
    if (good) location = parseInfo.getInfo().getParserCode();
    return good;
  }

  public long getTimestamp() {
    return timestamp;
  }
  
  public long getSentTime() {
    return sentTime;
  }
  
  public Date getIncidentDate() {
    
    // Return cached incident date if we have it
    if (incidentDate != null) return incidentDate;
    
    // Try to calculate date from parsed dispatch date/time
    incidentDate = calcDispatchDate();
    if (incidentDate != null) return incidentDate;
    
    // No go, try to calculate incident date from server time
    incidentDate = calcServerDate();
    if (incidentDate != null) return incidentDate;
    
    // Still no go, use message received timestamp
    incidentDate = new Date(timestamp);
    return incidentDate;
  }
  
  private Date calcDispatchDate() {
    
    // Parse the info object and retrieve the parsed date & time
    // If there is no parsed time just return null
    MsgInfo info = getInfo();
    if (info == null) return null;
    int[] dateArry = splitDateTime(info.getDate());
    int[] timeArry = splitTime(info.getTime());
    if (timeArry == null) return null;
    
    // Set result fields from parsed time field
    Calendar cal = new GregorianCalendar();
    cal.setTime(new Date(timestamp));
    Calendar origCal = new GregorianCalendar();
    origCal.setTime(cal.getTime());
    cal.set(Calendar.HOUR_OF_DAY, timeArry[0]);
    cal.set(Calendar.MINUTE, timeArry[1]);
    cal.set(Calendar.SECOND, (timeArry[2]>=0 ? timeArry[2] : 0));
    cal.set(Calendar.MILLISECOND, 0);
    
    // If there is no date field, retain the date from the time received
    // unless the parsed time is greater than the received time, in which 
    // case we assume the incident date must have been yesterday.  Except
    // we will allow a 5 minute discrepancy between system clocks
    if (dateArry == null) {
      long delta = origCal.getTimeInMillis() - cal.getTimeInMillis();
      if (delta < -300000L) cal.add(Calendar.DAY_OF_YEAR, -1);
    }
    
    // If there was a date field, use information from it
    else {
      cal.set(Calendar.MONTH, dateArry[0]-1);
      cal.set(Calendar.DAY_OF_MONTH, dateArry[1]);
      int year = dateArry[2];
      
      // If year was specified, use it.  If it was a 2 digit year
      // turn it to a 4 digit year
      if (year > 0) {
        if (year < 100) year += 2000;
        cal.set(Calendar.YEAR, year);
      } 
      
      // If no year was specified, retain received timestamp year
      // Unless this leads to result greater than the received time
      // in which case roll the year back
      else {
        long delta = origCal.getTimeInMillis() - cal.getTimeInMillis();
        if (delta < 0) cal.add(Calendar.YEAR, -1);
      }
    }
    return cal.getTime();
  }
  
  private static int[] splitTime(String field) {
    int pt = field.indexOf(' ');
    String marker = null;
    if (pt >= 0) {
      marker = field.substring(pt+1).trim().toUpperCase();
      field = field.substring(0,pt);
      if (!marker.equals("AM") && !marker.equals("PM")) return null;
    }
    int[] result = splitDateTime(field);
    if (result != null && marker != null) {
      if (result[0] > 12) return null;
      if (marker.equals("PM")) result[0] += 12;
    }
    return result;
  }
  
  /**
   * Split up an entered date or time field into component integer parts
   * @param field date/time field to be parsed
   * @return 3 element field containing component parts.  First two will have
   * values, last one will be -1 if it was not present.  Returns null if
   * field is not a valid date/time string
   */
  private static final Pattern DATE_TIME_DELIM = Pattern.compile("[/:-]");
  private static int[] splitDateTime(String field) {
    if (field.length() == 0) return null;
    String[] parts = DATE_TIME_DELIM.split(field);
    if (parts.length != 2 && parts.length != 3) return null;
    int[] result = new int[3];
    result[2] = -1;
    for (int ndx = 0; ndx < parts.length; ndx++) {
      try {
        result[ndx] = Integer.parseInt(parts[ndx]);
      } catch (NumberFormatException ex) {
        return null;
      }
    }
    return result;
  }
  
  /**
   * @return incident calculated from server time or null if not available
   */
  private Date calcServerDate() {
    
    if (serverTime ==  null ||  serverTime.length() == 0) return null;
    
    // Different vendors use different formats :(
    // Try to parse as a numeric long integer
    try {
      long time = Long.parseLong(serverTime);
      
      // Numeric time could be in seconds or in msecs
      if (time < 1000000000000L) time *= 1000L;
      
      // very broad reasonableness checks
      if (time < 1000000000000L) return null;
      if (time > 2000000000000L) return null;
      
      // Looks good
      return new Date(time);
    } catch (NumberFormatException ex) {}
    
    // No go, try as UMT Date/time
    try {
      return SERVER_DATE_FMT.parse(serverTime);
    } catch (ParseException ex) {}
    
    return null;
      
  }
  
  private static final DateFormat SERVER_DATE_FMT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  static {
    SERVER_DATE_FMT.setTimeZone(new SimpleTimeZone(0, "UMT"));
  }

  public MessageClass getMessageClass() {
    return messageClass;
  }

  public CharSequence getFormattedTimestamp(Context context) {
    long time = getIncidentDate().getTime();
    return DateUtils.formatDateTime(context, time, DateUtils.FORMAT_SHOW_TIME);
  }
  
  public String getSubject() {
    return (parseInfo == null ? subject : parseInfo.getSubject());
  }

  public String getMessageBody() {
    if (parseInfo == null) {
      if (messageBody == null) return "";
      return messageBody;
    }
    return parseInfo.getMessageBody();
  }
  
  public int getMessageType() {
    return messageType;
  }
  
  public String getFromAddress() {
    if (parseInfo != null) return parseInfo.getFromAddress();
    return fromAddress;
  }
  
  public String getLocation() {
    return location;
  }
  
  public String getContentLoc() {
    return contentLoc;
  }
  
  public String getMmsMsgId() {
    return mmsMsgId;
  }
  
  public int getMsgIndex() {
    return (parseInfo == null ? -1 : parseInfo.getMsgIndex());
  }
  
  public int getMsgCount() {
    return (parseInfo == null ? -1 : parseInfo.getMsgCount());
  }
  
  public String getReqLocation() {
    return reqLocation;
  }
  
  public String getVendorCode() {
    return vendorCode;
  }
  
  public String getMissingParsers() {
    return missingParsers;
  }
  
  /**
   * Get the extra information URL.  If we don't have one at this level, 
   * look for one in the parsed message information
   * @return extra information URL
   */
  public String getInfoURL() {
    if (infoURL != null) return VendorManager.instance().addAccountInfo(vendorCode, infoURL);
    MsgInfo info = getInfo();
    if (info == null) return null;
    String url = info.getInfoURL();
    if (url.length() > 0) return url;
    return null;
  }
  
  /**
   * @return true if user is allowed to set up a button configuration with no More Info button
   */
  public boolean infoButtonOptional() {
    if (vendorCode != null) {
      return VendorManager.instance().infoButtonOptional(vendorCode);
    } 
    return false;
  }

  /**
   * Get the "More Info" button title resource ID specific to this message
   * @return the title resource ID
   */
  public int getInfoTitle() {
    if (vendorCode != null && infoURL != null) {
      int resId = VendorManager.instance().getMoreInfoResId(vendorCode);
      if (resId > 0) return resId;
    }
    return  R.string.more_info_item_text;
  }
  
  /**
   * @return true if GPS coordinate mapping should be preferred
   */
  public boolean isPreferGPSLoc() {
    
    int gpsMapOption = ManagePreferences.gpsMapOption();
    if (gpsMapOption == 2) return false;
    if (gpsMapOption == 3) return true;
    
    MsgInfo info = getInfo();
    if (info == null) return false;
    return info.isPreferGPSLoc();
  }
  
  /**
   * @return true if parser can return map pages
   */
  public MsgParser.MapPageStatus getMapPageStatus() {
    MsgInfo info = getInfo();
    if (info == null) return null;
    return info.getMapPageStatus();
  }
  
  /**
   * @return message title text
   */
  public String getTitle() {
    MsgInfo info = getInfo();
    if (info != null) return info.getTitle();
    if (messageBody != null) return messageBody;
    return "";
  }
  
  /**
   * @return message address information
   */
  public String getAddress() {
    MsgInfo info = getInfo();
    if (info == null) return "";
    return info.getAddress();
  }
  
  /**
   * @return true if message expects more information to follow
   */
  public boolean isExpectMore() {
    MsgInfo info = getInfo();
    if (info == null) return false;
    return info.isExpectMore();
  }
  
  /**
   * @return map page URL or null if one does not exist
   */
  public String getMapPageURL() {
    MsgInfo info = getInfo();
    if (info == null) return null;
    return info.getMapPageURL();
  }
  
  /**
   * Called when the user has done anything to indicate they are aware of the page
   * @param context current context
   */
  public void acknowledge(Context context) {
    if (ackNeeded) {
      C2DMService.sendResponseMsg(context, ackReq, getAckURL(), "ACK", vendorCode);
      ackNeeded = false;
      reportDataChange();
    }
  }
  
  /**
   * Send response code by to vendor
   * @param context current context
   * @param respCode response code to be sent
   */
  public void sendResponse(Context context, String respCode) {
    C2DMService.sendResponseMsg(context, ackReq, getAckURL(), respCode, vendorCode);
    ackNeeded = false;
    
    // A response code of anything other than 'N' will be taken as an 
    // active response which can start the location tracking logic
    if (!respCode.startsWith("N")) triggerTracking(context);
  }
  
  /**
   * User has performed an action that could trigger a location tracking request from the server
   * See if it should happen
   */
  private void triggerTracking(Context context) {
    
    // If tracking has already been initiated, don't check again
    if (tracking) return;
    tracking = true;
    
    // Has sender requested location tracking
    OptionReader or = new OptionReader();
    if (!or.init('L')) return;
    int limit = Math.min(30, or.getParm(5));
    int minTime = or.getParm(10);
    int minDist = or.getParm(10);
    
    // See how long tracking is last following message receipt.  If time is 
    // up, don't do anything
    long delta = timestamp + limit * 60000L - System.currentTimeMillis();
    
    if (delta <= 0) return;
    
    // We are good to go with tracking request
    TrackingPromptActivity.addLocationRequest(context, getAckURL(), (int)delta, minDist, minTime);
    
  }
  
  /**
   * Display web page with additional information if there is one
   * @param context current context
   */
  public void showMoreInfo(Context context) {
    String url = getInfoURL();
    if (url == null) return;
    
    if (! SmsPopupUtils.haveNet(context)) return;
    
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    
    try {
      context.startActivity(intent);
    } catch (ActivityNotFoundException ex) {
      Log.e(ex);
    }

  }

  /**
   * Compute map search address use the default GPS map option
   */
  public String getMapAddress() {
    return getMapAddress(true, false);
  }

  /**
   * Compute map search address
   * @param useGPS true to use GPS location in preference to regular address
   * @return map search string or null if not available
   */
  public String getMapAddress(boolean useGPS) {
    return getMapAddress(false, useGPS);
  }

  /**
   * Compute map search address
   * @param defUseGPS true to use default GPS preference option.  If this is
   * true, useGPS is ignored. 
   * @param useGPS true to use GPS location in preference to regular address
   * @return map search string or null if not available
   */
  private String getMapAddress(boolean defUseGPS, boolean useGPS) {
    
    if (parseInfo == null) return null;
    MsgInfo info = parseInfo.getInfo();
    if (info == null) return null;
    
    String defCity = null;
    String defState = null;
    if (ManagePreferences.overrideDefaults()) {
      defCity = ManagePreferences.defaultCity();
      defState = ManagePreferences.defaultState();
    }
    if (defUseGPS) return info.getMapAddress(defCity, defState);
    return info.getMapAddress(useGPS, defCity, defState);
  }
  
  /**
   * Broadcast message information for 3rd party apps
   * @param context broadcast context
   * @param republish true if this is a republish event
   */
  public void broadcastIntent(Context context, boolean republish) {
    Intent intent = new Intent(ACTION);
    intent.putExtra(EXTRA_MSG_ID, msgId);
    intent.putExtra(EXTRA_REPUBLISH, republish);
    putExtraString(intent, EXTRA_FROM, getFromAddress());
    putExtraString(intent, EXTRA_SUBJECT, getSubject());
    putExtraString(intent, EXTRA_MESSAGE, getMessageBody());
    intent.putExtra(EXTRA_TIME, timestamp);
    putExtraString(intent, EXTRA_LOC_CODE, location);
    
    FilterOptions options = getFilterOptions();
    intent.putExtra(EXTRA_QUIET_MODE, 
         !(options.noticeEnabled() || options.popupEnabled()));
    
    MsgInfo info = getInfo();
    if (info != null) {
      putExtraString(intent, EXTRA_LOC_CITY, info.getDefCity());
      putExtraString(intent, EXTRA_LOC_STATE, info.getDefState());
      putExtraString(intent, EXTRA_PARSE_CALL_CODE, info.getCode());
      putExtraString(intent, EXTRA_PARSE_CALL, info.getExtendedCall());
      putExtraString(intent, EXTRA_PARSE_INFO, info.getSupp());
      putExtraString(intent, EXTRA_PARSE_PLACE, info.getPlace());
      putExtraString(intent, EXTRA_PARSE_ADDRESS, info.getAddress());
      putExtraString(intent, EXTRA_PARSE_CITY, info.getCity());
      putExtraString(intent, EXTRA_PARSE_STATE, info.getState());
      String mapAddress = getMapAddress();
      if (mapAddress != null) {
        putExtraString(intent, EXTRA_PARSE_MAP_ADDRESS, mapAddress);
      }
      putExtraString(intent, EXTRA_PARSE_APT, info.getApt());
      putExtraString(intent, EXTRA_PARSE_MAP, info.getMap());
      putExtraString(intent, EXTRA_PARSE_BOX, info.getBox());
      putExtraString(intent, EXTRA_PARSE_AGENCY, info.getSource());
      putExtraString(intent, EXTRA_PARSE_UNIT, info.getUnit());
      putExtraString(intent, EXTRA_PARSE_CALL_ID, info.getCallId());
      putExtraString(intent, EXTRA_PARSE_NAME, info.getName());
      putExtraString(intent, EXTRA_PARSE_PHONE, info.getPhone());
      putExtraString(intent, EXTRA_PARSE_PRIORITY, info.getPriority());
      putExtraString(intent, EXTRA_PARSE_CHANNEL, info.getChannel());
      putExtraString(intent, EXTRA_PARSE_GPSLOC, info.getGPSLoc());
      putExtraString(intent, EXTRA_PARSE_DISP_DATE, info.getDate());
      putExtraString(intent, EXTRA_PARSE_DISP_TIME, info.getTime());
      putExtraString(intent, EXTRA_PARSE_INFO_URL, info.getInfoURL());
      intent.putExtra(EXTRA_PREFER_GPS, info.isPreferGPSLoc());
      MsgParser.MapPageStatus mapPageStatus = info.getMapPageStatus();
      if (mapPageStatus != null) {
        putExtraString(intent, EXTRA_MAP_PAGE_STATUS, mapPageStatus.toString());
      }
      putExtraString(intent, EXTRA_MAP_PAGE_URL, info.getMapPageURL());
    }
    
    Log.v("Broadcasting intent");
    ContentQuery.dumpIntent(intent);
    context.sendBroadcast(intent, PERMISSION);
  }
  
  private static void putExtraString(Intent intent, String key, String value) {
    if (value != null && value.length() > 0) intent.putExtra(key, value);
  }


  /**
   * Append message information to support message under construction
   * @param sb String builder holding message being constructed
   */
  public void addMessageInfo(Context context, StringBuilder sb) {
    sb.append("\n\nMessage_Contents:\n");
    
    sb.append("Time:");
    sb.append(DATE_TIME_FMT.format(timestamp));

    sb.append("\nFrom:");
    sb.append(fromAddress);

    sb.append("\nEff_From:");
    sb.append(getFromAddress());
    
    sb.append("\nType:");
    sb.append(messageType);
    
    sb.append("\nClass:");
    sb.append(messageClass);
    
    sb.append("\nSubject:");
    sb.append(subject);
    sb.append("\nEff_Subject:");
    sb.append(getSubject());
    
    sb.append("\nBody:");
    sb.append(Message.escape(messageBody));
    if (extraMsgBody != null) {
      for (String body : extraMsgBody) {
        sb.append("\nBody:");
        sb.append(Message.escape(body));
      }
    }
    
    sb.append("\nEff_Body:");
    sb.append(getMessageBody());
    
    sb.append("\nLocation:");
    sb.append(location);
    
    sb.append("\nContentLoc:");
    sb.append(contentLoc);
    sb.append("\nmmsMsgId:");
    sb.append(mmsMsgId);
    
    sb.append("\nC2DM_Loc:");
    sb.append(reqLocation);
    
    sb.append("\nVendorCode:");
    sb.append(vendorCode);
    if (missingParsers != null) {
      sb.append("\nMissing_Active911_Parsers:");
      sb.append(missingParsers);
    }
    
    sb.append("\nackReq:");
    sb.append(ackReq);
    sb.append("\nackURL");
    sb.append(ackURL);
    sb.append("\nresponseMenu:");
    sb.append(responseMenu);
    sb.append("\nresponseMenuActive:");
    sb.append(responseMenuVisible);
    
    sb.append("\ninfoURL:");
    sb.append(infoURL);
    
    sb.append("\nCall_ID:");
    sb.append(callId);
    sb.append("\nServer_Time:");
    sb.append(serverTime);
    
    if (getMsgCount() >= 0) {
      sb.append("\nMsgIndex:");
      sb.append(getMsgIndex());
      sb.append(" of ");
      sb.append(getMsgCount());
    }
    
    sb.append("\nSend_time:");
    sb.append(sentTime);
    sb.append("\nRec_time: ");
    sb.append(timestamp);
    
    sb.append('\n');
  }
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");
 
  public boolean duplicate(SmsMmsMessage msg) {
    if (messageType == MESSAGE_TYPE_MMS) {
      return msg.messageType == MESSAGE_TYPE_MMS &&
             match(contentLoc, msg.contentLoc) &&
             match(mmsMsgId, msg.mmsMsgId);
    } else {
      return match(subject, msg.subject) && match(messageBody, msg.messageBody); 
    }
  }
  
  private boolean match(String s1, String s2) {
    if (s1 == null && s2 == null) return true;
    if (s1 == null || s2 == null) return false;
    return s1.equals(s2);
  }
  
  Message getParseInfo() {
    return parseInfo;
  }

  public boolean expectMore() {
    if (parseInfo == null) return false;
    return parseInfo.expectMore(getSplitMsgOptions());
  }
  
  /**
   * Class to interpret numeric subparameter from acknowledgment request string
   * Number parameters must follow a single letter parameter that keys them.  Multiple
   * numeric parameters can be separated with slashes
   */
  private class OptionReader {
    private int pt = -1;

    /**
     * Initialize reader starting with particular characater key
     * @param chr desired character key
     * @return true if character key is present, false otherwise
     */
    public boolean init(char chr) {
      if (ackReq == null) return false;
      pt = ackReq.indexOf(chr);
      if (pt < 0) return false;
      pt++;
      return true;
    }
    
    /**
     * Return next number parameter following initial character key
     * @param defValue value to return if no number is specified
     * @return number parameter or default value
     */
    public int getParm(int defValue) {
      if (pt < 0 || pt >= ackReq.length()) return defValue;
      int result = defValue;
      char chr = ackReq.charAt(pt);
      if (Character.isDigit(chr)) {
        result = 0;
        do {
          result = result*10 + (chr-'0');
          if (++pt >= ackReq.length()) chr = 'X';
          else chr = ackReq.charAt(pt);
        } while (Character.isDigit(chr));
      }
      if (chr == '/') pt++;
      return result;
    }
  }
}