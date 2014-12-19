package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class NYMadisonCountyGLASParser extends FieldProgramParser {
  
  private static final Pattern WIERD_CHAR_PTN = Pattern.compile("=(?:20|EF|BB|BF)");
  private static final Pattern DELIM = Pattern.compile("\n+");
  private static final Pattern MASTER = Pattern.compile("(.*?)\n+(.*?)(?: *, (.*?))?(?: \\((.*?)\\)?)?");
  
  public NYMadisonCountyGLASParser() {
    super(CITY_LIST, "MADISON COUNTY", "NY",
          "( Address:ADDR/SXP! Response_Type:CALL! | Number:ID? Free_Format_Address:ADDR! Type:CALL! )");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Greater Lenox")) return false;
    body = WIERD_CHAR_PTN.matcher(body).replaceAll("").trim();
    
    if (body.startsWith("Number:") || body.startsWith("Free Format Address:") ||
        body.endsWith("GLAS Dispatch")) {
      return super.parseFields(DELIM.split(body), data);
    }
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    setFieldList("CALL PLACE ADDR APT CITY X");
    data.strCall = match.group(1).trim();
    String sPart1 = match.group(2).trim();
    String sPart2 = getOptGroup(match.group(3));
    String sPart3 = getOptGroup(match.group(4));
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
    } else {
      parseAddress(sPart1.replace("\\", "&"), data);
      data.strCity = sPart2;
      if (sPart3.startsWith("/")) sPart3 = sPart3.substring(1).trim();
      if (sPart3.startsWith(",")) {
        data.strCity = sPart3.substring(1).trim();
      } else {
        data.strCross = sPart3;
      }
    }
    
    // Check for truncated VILLAGE following city
    int pt = data.strCity.lastIndexOf(' ');
    if (pt >= 0) {
      String last = data.strCity.substring(pt+1).trim().toUpperCase();
      for (String city : new String[]{"VILLAGE", "INSIDE"}) {
        if (city.equals(last)) break;
        if (city.startsWith(last)) {
          data.strCity = data.strCity.substring(0,pt+1) + city;
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
  
  private static final Pattern MAP_PTN = Pattern.compile("\\b-([A-Z]*\\d+|SUNY)\\b");
  private static final Pattern CITY_TRAIL_PTN = Pattern.compile("(?:VILLAGE|CITY|HAMLET)\\b *");
  private static final Pattern APT_PTN = Pattern.compile("(?:APT|#) *([^ ]+) *");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      int pt = field.lastIndexOf(';');
      if (pt >= 0) field = field.substring(0,pt).trim();
      
      String extra = null;
      Matcher match = MAP_PTN.matcher(field);
      if (match.find()) {
        extra = '(' + match.group(1) + ')';
        field = append(field.substring(0,match.start()), " ", field.substring(match.end()));
      }
      parseAddress(StartType.START_ADDR, FLAG_CROSS_FOLLOWS, field, data);
      
      if (extra != null) data.strAddress = append(data.strAddress, " ", extra);
      
      String left = getLeft();
      if (data.strCity.length() > 0) {
        match = CITY_TRAIL_PTN.matcher(left);
        if (match.lookingAt()) left = left.substring(match.end());
        
        String city = PLACE_CITY_TABLE.getProperty(data.strCity);
        if (city != null) {
          data.strPlace = data.strCity;
          data.strCity = city;
        }

      }
      
      match = APT_PTN.matcher(left);
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
  
  private static final Properties PLACE_CITY_TABLE = buildCodeTable(new String[]{
      "SOUTH HALL",        "MORRISVILLE"
  });
}
	