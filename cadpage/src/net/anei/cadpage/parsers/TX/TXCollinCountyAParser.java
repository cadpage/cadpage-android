package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Collin County, TX
 */
public class TXCollinCountyAParser extends FieldProgramParser {

  private static final Pattern TRAIL_JUNK_PTN = Pattern.compile("(?:\\[[^\\[\\]]*)?\\{[^\\{]*\\}?$");
  private static final Pattern CFS_ID_PTN = Pattern.compile(" CFS (\\d{8})\\b");
  private static final Pattern LEAD_DASH_PTN = Pattern.compile("^[ -]+");
  private static final Pattern DIST_GRID_PTN = Pattern.compile("\\[([A-Z]+) .*?GRID: ([A-Z]*\\d*[A-Z]?) *\\]");
  
  private static final String[] DOUBLE_CITY_LIST = new String[] {
    "ANNA",
    "AUBREY",
    "BLUE RIDGE",
    "CELINA",
    "COLLIN COUNTY",
    "COLONY",
    "DENTON",
    "FRISCO",
    "LEWISVILLE",
    "LITTLE ELM",
    "LOWRY CROSSING",
    "MC KINNEY",
    "MELISSA",
    "PILOT POINT",
    "PRINCETON",
    "ROYSE CITY",
    "ST PAUL",
    "VAN ALSTYNE"
  };
  
  public TXCollinCountyAParser() {
    this("COLLIN COUNTY", "TX");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  protected TXCollinCountyAParser(String defCity, String defState) {
    super(defCity, defState,
          "MASH UNITS:UNIT ST_RMK:INFO CFS_RMK:INFO");
    setupCallList(CALL_LIST);
    setupGpsLookupTable(GPS_LOOKUP_TABLE);
  }
  
  @Override
  public String getFilter() {
    return "ccsodispatch@co.collin.tx.us,DispatchSMS@coppelltx.gov";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    String alert = null;
    if (body.startsWith("Message From Dispatch ")) {
      body = body.substring(22).trim();
      if (body.startsWith("MUTUAL AID")) {
        Matcher match  = CFS_ID_PTN.matcher(body);
        if (match.find()) {
          data.strCallId = match.group(1);
          parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, body.substring(0,match.start()).trim(), data);
          String sInfo = body.substring(match.end());
          match = LEAD_DASH_PTN.matcher(sInfo);
          if (match.find()) sInfo = sInfo.substring(match.end());
          data.strSupp = sInfo;
          return true;
        }
        
        parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, body, data);
        return true;
      }
      
      alert = body;
    }

    // Remove trailing ID
    Matcher match = TRAIL_JUNK_PTN.matcher(body);
    if (match.find()) body = body.substring(0,match.start()).trim();
    
    // Some variants include the source and map code in square brackets
    // If this is one of those, extract that information and remove the
    // square bracket construct
    match = DIST_GRID_PTN.matcher(body);
    if (match.find()) {
      data.strSource = match.group(1).trim();
      data.strMap = match.group(2).trim();
      body = body.substring(0,match.start()) + body.substring(match.end());
    }
    
    int pt = body.indexOf("CFS No: ");
    if (pt >= 0) {
      data.strSupp = body.substring(0,pt).trim();
      body = body.substring(pt+8).trim();
    }
    
    // It seems that the original dispatch message uses double blanks as field
    // delimiters, but that some helpful? forwarding services are eliminating
    // the redundant blanks.  If this text message has the original double
    // blank delimiters, we can call parseFields to finsh things off
    body = body.replace("CFS RMK ", "CFS RMK: ");
    body = body.replaceAll(" +/ +", " / ");
    if (super.parseMsg(body, data)) {
      
      if (data.strCity.equalsIgnoreCase("COLLIN COUNTY")) data.strCity = "";
      if (data.strAddress.length() > 0) return true;
    }
    
    if (alert != null) return data.parseGeneralAlert(this, alert);
    return false;
  }
  
  @Override
  public String getProgram() {
    return "ID CALL ADDR CITY PLACE X SRC MAP UNIT INFO TIME";
  }
  
  // Parse a mashup of ID, CALL, ADDR, CITY, and Cross streets all of which might
  // or might not be separated by double blank delimiters
  private static final Pattern ID_PTN = Pattern.compile("^(\\d{8}) +");
  private static final Pattern BRACKET_PTN = Pattern.compile(" +\\{(.*?)\\} *");
  private static final Pattern STANDBY_PTN = Pattern.compile("^STANDBY(?: AT THIS TIME)?  +");
  private static final Pattern IN_PTN = Pattern.compile(" +IN +", Pattern.CASE_INSENSITIVE);
  private class MashField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      
      // Start with easy stuff.  ID is always the first token
      Matcher match = ID_PTN.matcher(field);
      if (!match.find()) abort();
      data.strCallId = match.group(1);
      field = field.substring(match.end());
      
      // A field in {} is considered a place name
      match = BRACKET_PTN.matcher(field);
      if (match.find()) {
        data.strPlace = match.group(1);
        field = field.substring(0,match.start()) + "  " + field.substring(match.end());
      }
      
      // If first phrase is a standby request, combine it with second term
      field = STANDBY_PTN.matcher(field).replaceFirst("STANDBY ");
      
      // Break up what is left by any double blank delimiters and see what we have to work with
      String[] flds = field.split("  +");
      switch (flds.length) {
      
      case 1:
        
        parseAddr(CALL | CROSS, flds[0], data);
        return;
        
      case 2:
        
        // Two fields is ambiguous, we don't know if if the break is call/address and cross
        // or call and address/cross.  We'll check both for an IN keyword, which
        // would mark the address
        if (parseAddr(OPTIONAL | CROSS, flds[1], data)) {
          data.strCall = flds[0];
          return;
        }
        
        if (parseAddr(OPTIONAL | CALL, flds[0], data)) {
          data.strCross = flds[1];
          return;
        }
        
        break;
        
      case 3:
        
        // Three fields breaks into call, address/city and cross
        data.strCall = flds[0];
        parseAddr(0, flds[1], data);
        data.strCross = flds[2];
        return;
        
      // More than 3 fields, we haven't a clue what to do.  
      default:
        abort();
      }
    }
    
    private static final int OPTIONAL = 1;
    private static final int CALL = 2;
    private static final int CROSS = 4;
    private boolean parseAddr(int flags, String sAddress, Data data) {
      
      // Break out flag options
      boolean optional = (flags & OPTIONAL) != 0;
      boolean call = (flags & CALL) != 0;
      boolean cross = (flags & CROSS) != 0;
      
      int parseFlags = 0;
      StartType st = StartType.START_ADDR;
      if (call) {
        st = StartType.START_CALL;
        parseFlags |= FLAG_START_FLD_REQ; 
      }
      
      // Next, see if address contains an IN keyword separated call/address from city/cross
      Matcher match = IN_PTN.matcher(sAddress);
      if (match.find()) {
        
        // Check, use smart parser to split call and address
        parseAddress(st, parseFlags | FLAG_ANCHOR_END, sAddress.substring(0,match.start()), data);
        
        // Now lets look at the right side of the IN keyword
        // If we aren't handling cross streets, it is all city
        String tail = sAddress.substring(match.end());
        if (!cross) {
          data.strCity = tail;
          return true;
        }
        
        // Otherwise, see if it starts with a two word city, if it does
        // use that city to break tail into city and cross streets
        String tail2 = tail.toUpperCase();
        for (String tc : DOUBLE_CITY_LIST) {
          if (tail2.startsWith(tc)) {
            data.strCity = tail.substring(0,tc.length());
            data.strCross = tail.substring(tc.length()).trim();
            return true;
          }
        }
        
        // Otherwise first word of tail is city, rest is cross
        Parser p = new Parser(tail);
        data.strCity = p.get(' ');
        data.strCross = p.get();
        return true;
      }
      
      // No IN keyword, if this was an optional parse, return failure
      if (optional) return false;
      
      // no IN keyword, which we assume means no city
      // Use smart address parser to separate call, adddress, and cross
      if (!cross) parseFlags |= FLAG_ANCHOR_END;
      parseAddress(st, parseFlags, sAddress, data);
      if (cross) data.strCross = getLeft();
      return true;
    }
    
    @Override
    public String getFieldNames() {
      return "ID CALL ADDR APT CITY X";
    }
  }
  
  private static final Pattern INFO_TIME_PTN = Pattern.compile("^(\\d\\d:\\d\\d)\\b");
  private static final Pattern INFO_NONE_PTN = Pattern.compile(" *<NO(?:NE|.* COMMENTS|.* REMARKS)> *");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_TIME_PTN.matcher(field);
      if (match.find()) {
        data.strTime = match.group(1);
        field = field.substring(match.end()).trim();
      }
      field = INFO_NONE_PTN.matcher(field).replaceAll(" ").trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "TIME INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MASH")) return new MashField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties GPS_LOOKUP_TABLE = buildCodeTable(new String[]{
      "980-110 S COIT RD",  "33.223826,-96.768216",
      "980-111 S COIT RD",  "33.223826,-96.768216",
      "980-112 S COIT RD",  "33.223826,-96.768216",
      "980-113 S COIT RD",  "33.223826,-96.768216",
      "980-114 S COIT RD",  "33.223826,-96.768216",
      "980-115 S COIT RD",  "33.223826,-96.768216",
      "980-116 S COIT RD",  "33.223826,-96.768216",
      "980-117 S COIT RD",  "33.223826,-96.768216",
      "980-120 S COIT RD",  "33.223826,-96.768216",
      "980-121 S COIT RD",  "33.223826,-96.768216",
      "980-122 S COIT RD",  "33.223826,-96.768216",
      "980-123 S COIT RD",  "33.223826,-96.768216",
      "980-124 S COIT RD",  "33.223826,-96.768216",
      "980-125 S COIT RD",  "33.223826,-96.768216",
      "980-126 S COIT RD",  "33.223826,-96.768216",
      "980-127 S COIT RD",  "33.223826,-96.768216",
      "980-130 S COIT RD",  "33.223826,-96.768216",
      "980-131 S COIT RD",  "33.223826,-96.768216",
      "980-132 S COIT RD",  "33.223826,-96.768216",
      "980-133 S COIT RD",  "33.223826,-96.768216",
      "980-134 S COIT RD",  "33.223826,-96.768216",
      "980-135 S COIT RD",  "33.223826,-96.768216",
      "980-136 S COIT RD",  "33.223826,-96.768216",
      "980-137 S COIT RD",  "33.223826,-96.768216",
      "980-210 S COIT RD",  "33.223507,-96.768533",
      "980-211 S COIT RD",  "33.223507,-96.768533",
      "980-212 S COIT RD",  "33.223507,-96.768533",
      "980-213 S COIT RD",  "33.223507,-96.768533",
      "980-214 S COIT RD",  "33.223507,-96.768533",
      "980-215 S COIT RD",  "33.223507,-96.768533",
      "980-216 S COIT RD",  "33.223507,-96.768533",
      "980-217 S COIT RD",  "33.223507,-96.768533",
      "980-220 S COIT RD",  "33.223507,-96.768533",
      "980-221 S COIT RD",  "33.223507,-96.768533",
      "980-222 S COIT RD",  "33.223507,-96.768533",
      "980-223 S COIT RD",  "33.223507,-96.768533",
      "980-224 S COIT RD",  "33.223507,-96.768533",
      "980-225 S COIT RD",  "33.223507,-96.768533",
      "980-226 S COIT RD",  "33.223507,-96.768533",
      "980-227 S COIT RD",  "33.223507,-96.768533",
      "980-230 S COIT RD",  "33.223507,-96.768533",
      "980-231 S COIT RD",  "33.223507,-96.768533",
      "980-232 S COIT RD",  "33.223507,-96.768533",
      "980-233 S COIT RD",  "33.223507,-96.768533",
      "980-234 S COIT RD",  "33.223507,-96.768533",
      "980-235 S COIT RD",  "33.223507,-96.768533",
      "980-236 S COIT RD",  "33.223507,-96.768533",
      "980-237 S COIT RD",  "33.223507,-96.768533",
      "980-310 S COIT RD",  "33.223409,-96.769037",
      "980-311 S COIT RD",  "33.223409,-96.769037",
      "980-312 S COIT RD",  "33.223409,-96.769037",
      "980-313 S COIT RD",  "33.223409,-96.769037",
      "980-314 S COIT RD",  "33.223409,-96.769037",
      "980-315 S COIT RD",  "33.223409,-96.769037",
      "980-316 S COIT RD",  "33.223409,-96.769037",
      "980-317 S COIT RD",  "33.223409,-96.769037",
      "980-320 S COIT RD",  "33.223409,-96.769037",
      "980-321 S COIT RD",  "33.223409,-96.769037",
      "980-322 S COIT RD",  "33.223409,-96.769037",
      "980-323 S COIT RD",  "33.223409,-96.769037",
      "980-324 S COIT RD",  "33.223409,-96.769037",
      "980-325 S COIT RD",  "33.223409,-96.769037",
      "980-326 S COIT RD",  "33.223409,-96.769037",
      "980-327 S COIT RD",  "33.223409,-96.769037",
      "980-330 S COIT RD",  "33.223409,-96.769037",
      "980-331 S COIT RD",  "33.223409,-96.769037",
      "980-332 S COIT RD",  "33.223409,-96.769037",
      "980-333 S COIT RD",  "33.223409,-96.769037",
      "980-334 S COIT RD",  "33.223409,-96.769037",
      "980-335 S COIT RD",  "33.223409,-96.769037",
      "980-336 S COIT RD",  "33.223409,-96.769037",
      "980-337 S COIT RD",  "33.223409,-96.769037",
      "980-410 S COIT RD",  "33.223826,-96.769445",
      "980-411 S COIT RD",  "33.223826,-96.769445",
      "980-412 S COIT RD",  "33.223826,-96.769445",
      "980-413 S COIT RD",  "33.223826,-96.769445",
      "980-414 S COIT RD",  "33.223826,-96.769445",
      "980-415 S COIT RD",  "33.223826,-96.769445",
      "980-416 S COIT RD",  "33.223826,-96.769445",
      "980-417 S COIT RD",  "33.223826,-96.769445",
      "980-420 S COIT RD",  "33.223826,-96.769445",
      "980-421 S COIT RD",  "33.223826,-96.769445",
      "980-422 S COIT RD",  "33.223826,-96.769445",
      "980-423 S COIT RD",  "33.223826,-96.769445",
      "980-424 S COIT RD",  "33.223826,-96.769445",
      "980-425 S COIT RD",  "33.223826,-96.769445",
      "980-426 S COIT RD",  "33.223826,-96.769445",
      "980-427 S COIT RD",  "33.223826,-96.769445",
      "980-430 S COIT RD",  "33.223826,-96.769445",
      "980-431 S COIT RD",  "33.223826,-96.769445",
      "980-432 S COIT RD",  "33.223826,-96.769445",
      "980-433 S COIT RD",  "33.223826,-96.769445",
      "980-434 S COIT RD",  "33.223826,-96.769445",
      "980-435 S COIT RD",  "33.223826,-96.769445",
      "980-436 S COIT RD",  "33.223826,-96.769445",
      "980-437 S COIT RD",  "33.223826,-96.769445",
      "980-510 S COIT RD",  "33.223503,-96.770191",
      "980-511 S COIT RD",  "33.223503,-96.770191",
      "980-512 S COIT RD",  "33.223503,-96.770191",
      "980-513 S COIT RD",  "33.223503,-96.770191",
      "980-514 S COIT RD",  "33.223503,-96.770191",
      "980-515 S COIT RD",  "33.223503,-96.770191",
      "980-516 S COIT RD",  "33.223503,-96.770191",
      "980-517 S COIT RD",  "33.223503,-96.770191",
      "980-520 S COIT RD",  "33.223503,-96.770191",
      "980-521 S COIT RD",  "33.223503,-96.770191",
      "980-522 S COIT RD",  "33.223503,-96.770191",
      "980-523 S COIT RD",  "33.223503,-96.770191",
      "980-524 S COIT RD",  "33.223503,-96.770191",
      "980-525 S COIT RD",  "33.223503,-96.770191",
      "980-526 S COIT RD",  "33.223503,-96.770191",
      "980-527 S COIT RD",  "33.223503,-96.770191",
      "980-530 S COIT RD",  "33.223503,-96.770191",
      "980-531 S COIT RD",  "33.223503,-96.770191",
      "980-532 S COIT RD",  "33.223503,-96.770191",
      "980-533 S COIT RD",  "33.223503,-96.770191",
      "980-534 S COIT RD",  "33.223503,-96.770191",
      "980-535 S COIT RD",  "33.223503,-96.770191",
      "980-536 S COIT RD",  "33.223503,-96.770191",
      "980-537 S COIT RD",  "33.223503,-96.770191",
      "980-610 S COIT RD",  "33.223072,-96.76981",
      "980-611 S COIT RD",  "33.223072,-96.76981",
      "980-612 S COIT RD",  "33.223072,-96.76981",
      "980-613 S COIT RD",  "33.223072,-96.76981",
      "980-614 S COIT RD",  "33.223072,-96.76981",
      "980-615 S COIT RD",  "33.223072,-96.76981",
      "980-616 S COIT RD",  "33.223072,-96.76981",
      "980-617 S COIT RD",  "33.223072,-96.76981",
      "980-620 S COIT RD",  "33.223072,-96.76981",
      "980-621 S COIT RD",  "33.223072,-96.76981",
      "980-622 S COIT RD",  "33.223072,-96.76981",
      "980-623 S COIT RD",  "33.223072,-96.76981",
      "980-624 S COIT RD",  "33.223072,-96.76981",
      "980-625 S COIT RD",  "33.223072,-96.76981",
      "980-626 S COIT RD",  "33.223072,-96.76981",
      "980-627 S COIT RD",  "33.223072,-96.76981",
      "980-630 S COIT RD",  "33.223072,-96.76981",
      "980-631 S COIT RD",  "33.223072,-96.76981",
      "980-632 S COIT RD",  "33.223072,-96.76981",
      "980-633 S COIT RD",  "33.223072,-96.76981",
      "980-634 S COIT RD",  "33.223072,-96.76981",
      "980-635 S COIT RD",  "33.223072,-96.76981",
      "980-636 S COIT RD",  "33.223072,-96.76981",
      "980-637 S COIT RD",  "33.223072,-96.76981",
      "980-710 S COIT RD",  "33.222825,-96.769584",
      "980-711 S COIT RD",  "33.222825,-96.769584",
      "980-712 S COIT RD",  "33.222825,-96.769584",
      "980-713 S COIT RD",  "33.222825,-96.769584",
      "980-714 S COIT RD",  "33.222825,-96.769584",
      "980-715 S COIT RD",  "33.222825,-96.769584",
      "980-716 S COIT RD",  "33.222825,-96.769584",
      "980-717 S COIT RD",  "33.222825,-96.769584",
      "980-720 S COIT RD",  "33.222825,-96.769584",
      "980-721 S COIT RD",  "33.222825,-96.769584",
      "980-722 S COIT RD",  "33.222825,-96.769584",
      "980-723 S COIT RD",  "33.222825,-96.769584",
      "980-724 S COIT RD",  "33.222825,-96.769584",
      "980-725 S COIT RD",  "33.222825,-96.769584",
      "980-726 S COIT RD",  "33.222825,-96.769584",
      "980-727 S COIT RD",  "33.222825,-96.769584",
      "980-730 S COIT RD",  "33.222825,-96.769584",
      "980-731 S COIT RD",  "33.222825,-96.769584",
      "980-732 S COIT RD",  "33.222825,-96.769584",
      "980-733 S COIT RD",  "33.222825,-96.769584",
      "980-734 S COIT RD",  "33.222825,-96.769584",
      "980-735 S COIT RD",  "33.222825,-96.769584",
      "980-736 S COIT RD",  "33.222825,-96.769584",
      "980-737 S COIT RD",  "33.222825,-96.769584",
      "980-810 S COIT RD",  "33.223104,-96.770695",
      "980-811 S COIT RD",  "33.223104,-96.770695",
      "980-812 S COIT RD",  "33.223104,-96.770695",
      "980-813 S COIT RD",  "33.223104,-96.770695",
      "980-814 S COIT RD",  "33.223104,-96.770695",
      "980-815 S COIT RD",  "33.223104,-96.770695",
      "980-816 S COIT RD",  "33.223104,-96.770695",
      "980-817 S COIT RD",  "33.223104,-96.770695",
      "980-820 S COIT RD",  "33.223104,-96.770695",
      "980-821 S COIT RD",  "33.223104,-96.770695",
      "980-822 S COIT RD",  "33.223104,-96.770695",
      "980-823 S COIT RD",  "33.223104,-96.770695",
      "980-824 S COIT RD",  "33.223104,-96.770695",
      "980-825 S COIT RD",  "33.223104,-96.770695",
      "980-826 S COIT RD",  "33.223104,-96.770695",
      "980-827 S COIT RD",  "33.223104,-96.770695",
      "980-830 S COIT RD",  "33.223104,-96.770695",
      "980-831 S COIT RD",  "33.223104,-96.770695",
      "980-832 S COIT RD",  "33.223104,-96.770695",
      "980-833 S COIT RD",  "33.223104,-96.770695",
      "980-834 S COIT RD",  "33.223104,-96.770695",
      "980-835 S COIT RD",  "33.223104,-96.770695",
      "980-836 S COIT RD",  "33.223104,-96.770695",
      "980-837 S COIT RD",  "33.223104,-96.770695",
      "980-910 S COIT RD",  "33.222727,-96.770335",
      "980-911 S COIT RD",  "33.222727,-96.770335",
      "980-912 S COIT RD",  "33.222727,-96.770335",
      "980-913 S COIT RD",  "33.222727,-96.770335",
      "980-914 S COIT RD",  "33.222727,-96.770335",
      "980-915 S COIT RD",  "33.222727,-96.770335",
      "980-916 S COIT RD",  "33.222727,-96.770335",
      "980-917 S COIT RD",  "33.222727,-96.770335",
      "980-920 S COIT RD",  "33.222727,-96.770335",
      "980-921 S COIT RD",  "33.222727,-96.770335",
      "980-922 S COIT RD",  "33.222727,-96.770335",
      "980-923 S COIT RD",  "33.222727,-96.770335",
      "980-924 S COIT RD",  "33.222727,-96.770335",
      "980-925 S COIT RD",  "33.222727,-96.770335",
      "980-926 S COIT RD",  "33.222727,-96.770335",
      "980-927 S COIT RD",  "33.222727,-96.770335",
      "980-930 S COIT RD",  "33.222727,-96.770335",
      "980-931 S COIT RD",  "33.222727,-96.770335",
      "980-932 S COIT RD",  "33.222727,-96.770335",
      "980-933 S COIT RD",  "33.222727,-96.770335",
      "980-934 S COIT RD",  "33.222727,-96.770335",
      "980-935 S COIT RD",  "33.222727,-96.770335",
      "980-936 S COIT RD",  "33.222727,-96.770335",
      "980-937 S COIT RD",  "33.222727,-96.770335",
      "980-1010 S COIT RD",  "33.222444,-96.77011",
      "980-1011 S COIT RD",  "33.222444,-96.77011",
      "980-1012 S COIT RD",  "33.222444,-96.77011",
      "980-1013 S COIT RD",  "33.222444,-96.77011",
      "980-1014 S COIT RD",  "33.222444,-96.77011",
      "980-1015 S COIT RD",  "33.222444,-96.77011",
      "980-1016 S COIT RD",  "33.222444,-96.77011",
      "980-1017 S COIT RD",  "33.222444,-96.77011",
      "980-1020 S COIT RD",  "33.222444,-96.77011",
      "980-1021 S COIT RD",  "33.222444,-96.77011",
      "980-1022 S COIT RD",  "33.222444,-96.77011",
      "980-1023 S COIT RD",  "33.222444,-96.77011",
      "980-1024 S COIT RD",  "33.222444,-96.77011",
      "980-1025 S COIT RD",  "33.222444,-96.77011",
      "980-1026 S COIT RD",  "33.222444,-96.77011",
      "980-1027 S COIT RD",  "33.222444,-96.77011",
      "980-1030 S COIT RD",  "33.222444,-96.77011",
      "980-1031 S COIT RD",  "33.222444,-96.77011",
      "980-1032 S COIT RD",  "33.222444,-96.77011",
      "980-1033 S COIT RD",  "33.222444,-96.77011",
      "980-1034 S COIT RD",  "33.222444,-96.77011",
      "980-1035 S COIT RD",  "33.222444,-96.77011",
      "980-1036 S COIT RD",  "33.222444,-96.77011",
      "980-1037 S COIT RD",  "33.222444,-96.77011",
      "980-1110 S COIT RD",  "33.222852,-96.771172",
      "980-1111 S COIT RD",  "33.222852,-96.771172",
      "980-1112 S COIT RD",  "33.222852,-96.771172",
      "980-1113 S COIT RD",  "33.222852,-96.771172",
      "980-1114 S COIT RD",  "33.222852,-96.771172",
      "980-1115 S COIT RD",  "33.222852,-96.771172",
      "980-1116 S COIT RD",  "33.222852,-96.771172",
      "980-1117 S COIT RD",  "33.222852,-96.771172",
      "980-1120 S COIT RD",  "33.222852,-96.771172",
      "980-1121 S COIT RD",  "33.222852,-96.771172",
      "980-1122 S COIT RD",  "33.222852,-96.771172",
      "980-1123 S COIT RD",  "33.222852,-96.771172",
      "980-1124 S COIT RD",  "33.222852,-96.771172",
      "980-1125 S COIT RD",  "33.222852,-96.771172",
      "980-1126 S COIT RD",  "33.222852,-96.771172",
      "980-1127 S COIT RD",  "33.222852,-96.771172",
      "980-1130 S COIT RD",  "33.222852,-96.771172",
      "980-1131 S COIT RD",  "33.222852,-96.771172",
      "980-1132 S COIT RD",  "33.222852,-96.771172",
      "980-1133 S COIT RD",  "33.222852,-96.771172",
      "980-1134 S COIT RD",  "33.222852,-96.771172",
      "980-1135 S COIT RD",  "33.222852,-96.771172",
      "980-1136 S COIT RD",  "33.222852,-96.771172",
      "980-1137 S COIT RD",  "33.222852,-96.771172",
      "980-1210 S COIT RD",  "33.222354,-96.770652",
      "980-1211 S COIT RD",  "33.222354,-96.770652",
      "980-1212 S COIT RD",  "33.222354,-96.770652",
      "980-1213 S COIT RD",  "33.222354,-96.770652",
      "980-1214 S COIT RD",  "33.222354,-96.770652",
      "980-1215 S COIT RD",  "33.222354,-96.770652",
      "980-1216 S COIT RD",  "33.222354,-96.770652",
      "980-1217 S COIT RD",  "33.222354,-96.770652",
      "980-1220 S COIT RD",  "33.222354,-96.770652",
      "980-1221 S COIT RD",  "33.222354,-96.770652",
      "980-1222 S COIT RD",  "33.222354,-96.770652",
      "980-1223 S COIT RD",  "33.222354,-96.770652",
      "980-1224 S COIT RD",  "33.222354,-96.770652",
      "980-1225 S COIT RD",  "33.222354,-96.770652",
      "980-1226 S COIT RD",  "33.222354,-96.770652",
      "980-1227 S COIT RD",  "33.222354,-96.770652",
      "980-1230 S COIT RD",  "33.222354,-96.770652",
      "980-1231 S COIT RD",  "33.222354,-96.770652",
      "980-1232 S COIT RD",  "33.222354,-96.770652",
      "980-1233 S COIT RD",  "33.222354,-96.770652",
      "980-1234 S COIT RD",  "33.222354,-96.770652",
      "980-1235 S COIT RD",  "33.222354,-96.770652",
      "980-1236 S COIT RD",  "33.222354,-96.770652",
      "980-1237 S COIT RD",  "33.222354,-96.770652",
      "980-1310 S COIT RD",  "33.222592,-96.771559",
      "980-1311 S COIT RD",  "33.222592,-96.771559",
      "980-1312 S COIT RD",  "33.222592,-96.771559",
      "980-1313 S COIT RD",  "33.222592,-96.771559",
      "980-1314 S COIT RD",  "33.222592,-96.771559",
      "980-1315 S COIT RD",  "33.222592,-96.771559",
      "980-1316 S COIT RD",  "33.222592,-96.771559",
      "980-1317 S COIT RD",  "33.222592,-96.771559",
      "980-1320 S COIT RD",  "33.222592,-96.771559",
      "980-1321 S COIT RD",  "33.222592,-96.771559",
      "980-1322 S COIT RD",  "33.222592,-96.771559",
      "980-1323 S COIT RD",  "33.222592,-96.771559",
      "980-1324 S COIT RD",  "33.222592,-96.771559",
      "980-1325 S COIT RD",  "33.222592,-96.771559",
      "980-1326 S COIT RD",  "33.222592,-96.771559",
      "980-1327 S COIT RD",  "33.222592,-96.771559",
      "980-1330 S COIT RD",  "33.222592,-96.771559",
      "980-1331 S COIT RD",  "33.222592,-96.771559",
      "980-1332 S COIT RD",  "33.222592,-96.771559",
      "980-1333 S COIT RD",  "33.222592,-96.771559",
      "980-1334 S COIT RD",  "33.222592,-96.771559",
      "980-1335 S COIT RD",  "33.222592,-96.771559",
      "980-1336 S COIT RD",  "33.222592,-96.771559",
      "980-1337 S COIT RD",  "33.222592,-96.771559",
      "980-1410 S COIT RD",  "33.22217,-96.771859",
      "980-1411 S COIT RD",  "33.22217,-96.771859",
      "980-1412 S COIT RD",  "33.22217,-96.771859",
      "980-1413 S COIT RD",  "33.22217,-96.771859",
      "980-1414 S COIT RD",  "33.22217,-96.771859",
      "980-1415 S COIT RD",  "33.22217,-96.771859",
      "980-1416 S COIT RD",  "33.22217,-96.771859",
      "980-1417 S COIT RD",  "33.22217,-96.771859",
      "980-1420 S COIT RD",  "33.22217,-96.771859",
      "980-1421 S COIT RD",  "33.22217,-96.771859",
      "980-1422 S COIT RD",  "33.22217,-96.771859",
      "980-1423 S COIT RD",  "33.22217,-96.771859",
      "980-1424 S COIT RD",  "33.22217,-96.771859",
      "980-1425 S COIT RD",  "33.22217,-96.771859",
      "980-1426 S COIT RD",  "33.22217,-96.771859",
      "980-1427 S COIT RD",  "33.22217,-96.771859",
      "980-1430 S COIT RD",  "33.22217,-96.771859",
      "980-1431 S COIT RD",  "33.22217,-96.771859",
      "980-1432 S COIT RD",  "33.22217,-96.771859",
      "980-1433 S COIT RD",  "33.22217,-96.771859",
      "980-1434 S COIT RD",  "33.22217,-96.771859",
      "980-1435 S COIT RD",  "33.22217,-96.771859",
      "980-1436 S COIT RD",  "33.22217,-96.771859",
      "980-1437 S COIT RD",  "33.22217,-96.771859"
  });
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "COMERCIAL FIRE ALARM",
      "DUMPSTER FIRE",
      "DRIVING WHILE INTOXICATED",
      "EMERGENCY MEDICAL CALL",
      "FIRE ALARM",
      "FIRE PUBLIC ASSIST",
      "FIRST RESPONDERS",
      "GRASS FIRE",
      "INJURED PERSON",
      "INVESTIGATION-UNKNOWN SIT.",
      "MAJOR ACCIDENT 10/50",
      "MINOR ACCIDENT 10/50",
      "MEDICAL EMERGENCY",
      "MEDICATION OVERDOSE",
      "MUTUAL AID GRASS FIRE",
      "MUTUAL AID SFIRE",
      "MUTUAL AID STRUCTURE FIRE",
      "PROPERTY PUBLIC ASSIST",
      "RESCUE-TRAPED PERSON(S)",
      "RESIDENTIAL FIRE ALARM",
      "STANDBY ELECTRICAL FIRE",
      "STRUCTURE FIRE",
      "TEST CALL",
      "TRAFIC HAZARD",
      "TRASH FIRE",
      "UNAUTHORZED BURN",
      "UNKNOWN FIRE",
      "VEHICLE FIRE",
      "WELFARE CHECK"
  );
}
