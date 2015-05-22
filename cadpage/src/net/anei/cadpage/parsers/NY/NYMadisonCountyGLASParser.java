package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class NYMadisonCountyGLASParser extends FieldProgramParser {
  
  private static final Pattern WIERD_CHAR_PTN = Pattern.compile("=(?:20|EF|BB|BF)");
  private static final Pattern DELIM = Pattern.compile("\n+");
  private static final Pattern MASTER = Pattern.compile("(.*?)\n+(.*?)(?: \\((.*?)\\)?)?");
  private static final Pattern CITY_APT_PTN = Pattern.compile("(.*?)(?:(?:VILLAGE|HAMLET))?(?:(?: +APT| *#) *([^ ]+))?");

  public NYMadisonCountyGLASParser() {
    super(CITY_LIST, "MADISON COUNTY", "NY",
          "Number:ID? Address:ADDR! Type:CALL!");
    setupMultiWordStreets(
        "DITCH BANK",
        "INDIAN OPENING",
        "INGALLS CORNERS",
        "LELAND G WRIGHT",
        "MOUNT PLEASANT",
        "NORTH COURT",
        "ONEIDA LAKE",
        "SOUTH CIRCLE",
        "SOUTH PETERBORO",
        "WILLIAMS CORNERS"
    );
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Greater Lenox")) return false;
    body = WIERD_CHAR_PTN.matcher(body).replaceAll("").trim();
    body = body.replace("Free Format Address:","Address:");
    body = body.replace("Response Type:", "Type:");
    
    if (body.startsWith("Number:") || body.startsWith("Address:")) {
      return super.parseFields(DELIM.split(body), data);
    }
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    setFieldList("CALL NAME PLACE ADDR APT CITY X");
    data.strCall = match.group(1).trim();
    String sPart1 = match.group(2).trim();
    String sPart3 = getOptGroup(match.group(3));
    String sPart2 = "";
    int pt = sPart1.lastIndexOf(", ");
    if (pt >= 0) {
      sPart2 = sPart1.substring(pt+2).trim();
      sPart1 = sPart1.substring(0,pt).trim();
    }
    
    if (sPart1.startsWith("@")) {
     data.strPlace = sPart1.substring(1).trim(); 
     if (sPart2.length() > 0) {
       parseAddress(sPart2.replace("\\", "&"), data);
       data.strCross = sPart3;
     } else {
       Parser p = new Parser(sPart3);
       parseAddress(p.get('(').replace("\\", "&"), data);
       data.strCity = p.get(')');
     }
    } else if (sPart2.length() == 0 && sPart3.length() == 0) {
      pt = sPart1.indexOf('#');
      if (pt >= 0) {
        parseAddress(StartType.START_OTHER, FLAG_ANCHOR_END, sPart1.substring(0,pt).trim(), data);
        data.strName = getStart();
        data.strCross = sPart1.substring(pt+1).trim();
      } else {
        parseAddress(StartType.START_OTHER, FLAG_CROSS_FOLLOWS, sPart1, data);
        data.strName = getStart();
        String left = getLeft();
        if (data.strCity.length() > 0) left = stripFieldStart(left, "VILLAGE ");
        data.strCross = left;
      }
    } else {
      parseAddress(StartType.START_OTHER, FLAG_ANCHOR_END, sPart1.replace("\\", "&"), data);
      data.strName = getStart();
      
      match = CITY_APT_PTN.matcher(sPart2);
      if (match.matches()) {
        sPart2 = match.group(1).trim();
        String apt = match.group(2);
        if (apt != null) {
          data.strApt = append(data.strApt, "-", apt);
        }
      }
      data.strCity = sPart2;
      
      if (sPart3.startsWith("/")) sPart3 = sPart3.substring(1).trim();
      if (sPart3.startsWith(",")) {
        data.strCity = sPart3.substring(1).trim();
      } else {
        data.strCross = sPart3;
      }
    }
    
    // If name but no address, convert name as address
    if (data.strName.length() > 0 && data.strAddress.length() == 0) {
      parseAddress(data.strName, data);
      data.strName = "";
    }
    
    if (data.strName.length() > 0 && data.strPlace.length() == 0 &&
        checkPlace(data.strName)) {
      data.strPlace = data.strName;
      data.strName = "";
    }
    
    // Check for truncated VILLAGE following city
    pt = data.strCity.lastIndexOf(' ');
    if (pt >= 0) {
      String last = data.strCity.substring(pt+1).trim().toUpperCase();
      for (String city : new String[]{"VILLAGE", "INSIDE", "HAMLET"}) {
        if (city.startsWith(last)) {
          data.strCity = data.strCity.substring(0,pt).trim();
          break;
        }
      }
    }
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("GLAS:(\\d{4}:\\d{6})");
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Pattern ADDR_MAP_PTN = Pattern.compile("\\b-([A-Z]*\\d+|SUNY)\\b");
  private static final Pattern ADDR_CITY_TRAIL_PTN = Pattern.compile("(?:VILLAGE|HAMLET)\\b *");
  private static final Pattern ADDR_APT_PTN = Pattern.compile("(?:APT|#) *([^ ]+) *");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      int pt = field.lastIndexOf(';');
      if (pt >= 0) field = field.substring(0,pt).trim();
      
      String extra = null;
      Matcher match = ADDR_MAP_PTN.matcher(field);
      if (match.find()) {
        extra = '(' + match.group(1) + ')';
        field = append(field.substring(0,match.start()), " ", field.substring(match.end()));
      }
      parseAddress(StartType.START_ADDR, FLAG_CROSS_FOLLOWS, field, data);
      
      if (extra != null) data.strAddress = append(data.strAddress, " ", extra);
      
      String left = getLeft();
      if (data.strCity.length() > 0) {
        match = ADDR_CITY_TRAIL_PTN.matcher(left);
        if (match.lookingAt()) left = left.substring(match.end());
      }
      
      match = ADDR_APT_PTN.matcher(left);
      if (match.lookingAt()) {
        data.strApt = append(data.strApt, " ", match.group(1));
        left = left.substring(match.end());
      }
      left = stripFieldStart(left, "/");
      left = stripFieldEnd(left, "/");
      data.strCross = left;
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT PLACE CITY X";
    }
  }
  
  @Override
  public String adjustMapCity(String city) {
    return convertCodes(city.toUpperCase(), MAP_CITY_TABLE);
  }
  
  private static final Properties MAP_CITY_TABLE = buildCodeTable(new String[]{
      "SOUTH HALL",        "MORRISVILLE"
  });
  
  private static final String[] CITY_LIST = new String[]{
    "BRIDGEPORT",
    "BROOKFIELD",
    "CANASTOTA",
    "CAZENOVIA",
    "CHITTENANGO",
    "DERUYTER",
    "EARLVILLE",
    "EATON",
    "FENNER",
    "GEORGETOWN",
    "HAMILTON",
    "LEBANON",
    "LENOX",
    "LINCOLN",
    "MADISON",
    "MORRISVILLE",
    "MUNNSVILLE",
    "NELSON",
    "ONEIDA",
    "SMITHFIELD",
    "SOUTH HALL",
    "STOCKBRIDGE",
    "SULLIVAN",
    "WAMPSVILLE"
  };
}
	