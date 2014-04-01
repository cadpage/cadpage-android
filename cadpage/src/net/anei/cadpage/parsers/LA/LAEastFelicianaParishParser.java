package net.anei.cadpage.parsers.LA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * E Feliciana Parish, LA
 */
public class LAEastFelicianaParishParser extends SmartAddressParser {
  
  private static final Pattern SUBJECT_PATTERN = Pattern.compile("(Disp|Clr)\\:\\s*\\b([A-Z]+)\\b\\s*(\\d{5} +\\d{4}\\-\\d{1,2}\\-\\d+)");
  private static final Pattern SUBJECT_PATTERN2 = Pattern.compile("Case # (\\d{4}-\\d{1,2}-\\d+)");
  
  private static final String
    UNIT_PATTERN_STRING = "\\d{1,2}(?:\\-[A-Z])?|[A-Z]{2}|MISC|TEST",
    DATE_PATTERN_STRING = "\\d{1,2}\\/\\d{1,2}\\/\\d{4}",
    TIME_PATTERN_STRING = "\\d{1,2}\\:\\d{2}\\:\\d{2}",
    GOOGLE_MAP_PATTERN_STRING = "http\\:\\/\\/maps\\.google\\.com\\/maps\\?q=(\\d+\\.\\d+,\\+\\-\\d+\\.\\d+)";
  private static final Pattern BODY_PATTERN_2
    = Pattern.compile("("+UNIT_PATTERN_STRING+")?"
+                     "\\s*Date +Recv +("+DATE_PATTERN_STRING+")"
+                     " +("+TIME_PATTERN_STRING+")"
+                     "\\s*(.*?)(?:"+GOOGLE_MAP_PATTERN_STRING+")?");
  private static final Pattern BODY_PATTERN_3 = Pattern.compile("(.*?)\\b((?:225|318)(?: +\\d{3}\\-\\d{4})?| {3})\\b(.*)");
  private static final Pattern DASH_PTN = Pattern.compile("--+");
  
  public LAEastFelicianaParishParser() {
    super(CITY_LIST, "EAST FELICIANA PARISH", "LA");
    setFieldList("SRC ID DATE TIME CALL UNIT ADDR X CITY GPS NAME PHONE");
  }
  
  @Override
  public String getFilter() {
    return "eastfelicianaLa@ez911mail.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    Matcher m = SUBJECT_PATTERN2.matcher(subject);
    if (m.matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      data.strCallId = m.group(1);
      return true;
    }

    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    m = SUBJECT_PATTERN.matcher(subject);
    if (!m.matches()) return false;
    data.strSource = m.group(2);
    data.strCallId = m.group(3);
    if (m.group(1).equals("Clr")) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    m = BODY_PATTERN_2.matcher(body);
    if (!m.matches()) return false;
    data.strUnit = getOptGroup(m.group(1));
    data.strDate = m.group(2);
    data.strTime = m.group(3);
    body = m.group(4).trim();
    setGPSLoc(getOptGroup(m.group(5)).replace("+-", "-"), data);

    m = BODY_PATTERN_3.matcher(body);
    if (m.matches()) {
      data.strPhone = m.group(2).trim();
      if (data.strPhone.length() == 3) data.strPhone = "";
      return parseAddressFields(m.group(1).trim(), m.group(3).trim(), data);
    }
    
    // No phone number break, just parse this as the first data field
    body = DASH_PTN.matcher(body).replaceAll("   ");
    return parseAddressCrossCallField(body, data, null);
  }
  
  /**
   * Parse two part address field successfully split by a phone number
   * @param fld1 First part of address field
   * @param fld2 Second part of address field
   * @param data data object
   * @return true if successful
   */
  private boolean parseAddressFields(String fld1, String fld2, Data data) {
    
    // Fix some of the dumb things dispatchers do to addresses
    fld1 = fixAddress(fld1);
    fld2 = fixAddress(fld2);
    
    // Address is duplicated in both parts, but is entered separately and not
    // always identical.  The second piece is more reliable, so we will tackle
    // it first
    parseAddress(StartType.START_ADDR, FLAG_AT_MEANS_CROSS, fld2, data);
    data.strName = cleanWirelessCarrier(getLeft());
    if (getStatus() == 0) return false;
    
    // If that works, try to trip off the name and city fields and see if
    // part 1 starts with the same address.  If it does, strip off the 
    // address and parse what is left
    fld2 = stripFieldEnd(fld2, data.strName);
    fld2 = stripFieldEnd(fld2, data.strCity);
    if (fld1.toUpperCase().startsWith(fld2.toUpperCase())) {
      fld1 = fld1.substring(fld2.length()).trim();
      return parseCrossCall(fld1, data);
    }
    
    // No luck there, we will have to try parsing the address from the
    // first section and discard it.
    return parseAddressCrossCallField(fld1, data, fld2);
  }

  /**
   * Parser address, cross, and call field from text field
   * @param field text field
   * @param data data object
   * @param addr previously identified address, or null if none
   * @return true if successful
   */
  private boolean parseAddressCrossCallField(String field, Data data, String addr) {
    
    // If we can identify an address at start of field, use that
    // If we do have an address from the other address field, discard this one
    Result r = parseAddress(StartType.START_ADDR, FLAG_AT_MEANS_CROSS | FLAG_CROSS_FOLLOWS, field);
    if (r.getStatus() > 0) {
      if (addr == null) r.getData(data);
      field = r.getLeft();
    } 
    
    // If no address could be identified, and we do not have a primary address
    // bye bye
    else if (addr == null) return false;
    
    // If we do have a primary address, use it to remove matching words
    // from the beginning of this field
    else {
      Parser p = new Parser(field);
      String fldWord = p.get(' ');
      for (String addrWord : addr.split(" +")) {
        if (fldWord.equalsIgnoreCase(addrWord)) fldWord = p.get(' ');
      }
      field = append(fldWord, " ", p.get());
    }
    
    // However we got here, use what is left to parse the cross street and call description
    return parseCrossCall(field, data);
  }

  /**
   * Parse cross street and call description from text field
   * @param field text field
   * @param data data object
   * @return true if successful
   */
  private boolean parseCrossCall(String field, Data data) {
    Result r = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, field);
    if (r.getStatus() > 0) {
      r.getData(data);
      field = r.getLeft();
    }
    data.strCall = field;
    return true;
  }
  
  /**
   * Fix dump dispatch address mistakes
   * @param addr address field
   * @return fixed up address field
   */
  private String fixAddress(String addr) {
    addr = HWY_PTN.matcher(addr).replaceAll("HWY");
    return addr;
  }
  private static final Pattern HWY_PTN = Pattern.compile("\\bHYW\\b");
  
  private static final String[] CITY_LIST = {
    "CLINTON",
    "JACKSON",
    "NORWOOD",
    "SLAUGHTER",
    "WILSON",
    "ETHEL"
  };
}
