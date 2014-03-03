package net.anei.cadpage.parsers.dispatch;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

import java.util.Properties;
import java.util.regex.*;

// Every subclass must implement public String getDispatchID()
//    to return the portion of the msg left of the 1st ":"
// In addition, subclasses should override getParseAddressFlags() to provide
// any additional flags for parseAddress()
//
abstract public class DispatchA37Parser extends SmartAddressParser {
  // pList is list of patterns to pull address fields from variously formatted Message: fields
  // Each has 1 group to contain the address field
  private String prefix = null;
  
  public DispatchA37Parser(String prefix, String city, String state) {
    this(prefix, null, city, state);
  }
  
  public DispatchA37Parser(String prefix, Properties cityCodes, String city, String state) {
    super(cityCodes, city, state);
    this.prefix = prefix;
    setFieldList("ID CALL CODE DATE TIME");
  }

  // Separate and parse DispatchID, CALLID, CALL, DATE, TIME and Location/Message fields
  private static final Pattern MASTER_PATTERN
    = Pattern.compile("([^:]+):\\s*(?:Call\\s*\\#\\s*((?:\\d{2}-)?[\\d]+?))?\\s*(?:\\-\\s*(.+?)\\-\\s+)?\\s*(\\d\\d?\\/\\d\\d?\\/\\d{4})\\s+(\\d{2}\\:\\d{2}\\:\\d{2})\\s*(?:(Location|Message)\\:\\s*(.*?))?");
  public boolean parseMsg(String body, Data data) {
    Matcher m = MASTER_PATTERN.matcher(body);
    if (!m.matches()) return false;
    if (!m.group(1).equals(prefix)) return false;
    data.strCallId = getOptGroup(m.group(2));
    parseCallField(getOptGroup(m.group(3)), data);
    data.strDate = m.group(4);
    data.strTime = m.group(5);
    return parseDataField(m.group(6), getOptGroup(m.group(7)), data);
  }

  // Call field is a call type followed by optional call code
  private static final Pattern CALL_PATTERN = Pattern.compile("(.*?)\\s+([A-Z]\\-\\d{1,3}[A-Z]?)?");
  private void parseCallField(String field, Data data) {
    Matcher m = CALL_PATTERN.matcher(field);
    if (m.matches()) {
      data.strCall = m.group(1);
      data.strCode = m.group(2);
    } else
      data.strCall = field;
  }

  // Parses Location: and Message: fields
  private boolean parseDataField(String fieldType, String field, Data data) {
    if (fieldType == null) return false;
    if (fieldType.equals("Location")) return parseLocationField(field, data);
    if (fieldType.equals("Message")) return parseMessageField(field, data);
    return false;
  }

  /**
   * Process Location: field.  May be overridden by subclasses that need to
   * do something more sophisticated then just parse an address
   * @param field data field
   * @param data Data object where parsed fields are returned
   * @return true if successful
   */
  protected boolean parseLocationField(String field, Data data) {
    parseAddress(field, data);
    return true;
 }
  
  abstract protected boolean parseMessageField(String field, Data data);
}
