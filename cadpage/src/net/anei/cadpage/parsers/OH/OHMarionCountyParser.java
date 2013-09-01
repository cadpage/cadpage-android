package net.anei.cadpage.parsers.OH;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class OHMarionCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("UNIT +([0-9A-Z ]+)  (\\d\\d?/\\d\\d?/\\d{4}) (\\d\\d:\\d\\d:\\d\\d) +(\\d\\d-\\d{6}) +(.*)");

  public OHMarionCountyParser() {
    super(CITY_CODES, "MARION COUNTY", "OH");
    setFieldList("UNIT DATE TIME ID CALL ADDR APT CITY X");
  }
  
  @Override
  public String getFilter() {
    return "MCSO@CO.MARION.OH.US";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD Page")) return false;
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strUnit = match.group(1).trim();
    data.strDate = match.group(2);
    data.strTime = match.group(3);
    data.strCallId = match.group(4);
    String addr = match.group(5);
    
    addr = addr.replace('@', '&');
    addr = expandAbbreviations(addr);
    
    // Many calls descriptions start with SQUAD CALL followed by a number that is
    // is mistaken for a house number.  
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_CROSS_FOLLOWS, addr, data); 
    addr = getLeft();
    parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, addr, data);

    return true;
  }
  
  private String expandAbbreviations(String address) {
    for (ExpandElement exp : EXPAND_TABLE) {
      address = exp.expand(address);
    }
    return address;
  }
  
  private static ExpandElement[] EXPAND_TABLE;
  
  
  private static class ExpandElement {
    
    private Pattern pattern;
    private String replacement;
    
    public ExpandElement(String pattern, String replacement) {
      this.pattern = Pattern.compile("\\b" + pattern + "\\b");
      this.replacement = replacement;
    }
    
    public String expand(String text) {
      return pattern.matcher(text).replaceAll(replacement);
    }
  }
  
  static private void setupExpandTable(String ... args) {
    List<ExpandElement> expandList = new ArrayList<ExpandElement>();
    for (int ndx = 0; ndx < args.length; ndx += 2) {
      expandList.add(new ExpandElement(args[ndx], args[ndx+1]));
    }
    EXPAND_TABLE = expandList.toArray(new ExpandElement[expandList.size()]);
  }
  
  static {
    setupExpandTable(
    "POLE LANE",              "POLE LANE RD",
    "POL LN",                 "POLE LANE RD",
    "WHETS RIV",              "WHETSTONE RIVER RD"
    
//    "MRN WMPORT",
//    "EAST WOOD VALL"
    );
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CL",  "CALEDONIA",
      "GAL", "GAL",
      "PL",  "PLEASANT TWP",
      "PP",  "PP"
      
  });
}
