package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NYNassauCountyElmontParser extends FieldProgramParser {
  
  private static final String[] CITY_LIST = new String[]{
    "ELMONT", "NO VALLEY STREAM", "ALDEN MANOR", "FLORAL PARK", "SO FLORAL PARK", 
    "STEWART MANOR", "MALVERNE", "FRANKLIN SQUARE", "WEST HEMPSTEAD", "HEMPSTEAD",
    "LYNBROOK", "BELLEROSE", "BELLEROSE TERRACE", "VALLEY STREAM"
  };
  
  private static final Pattern MAP_ZONE_PTN =
    Pattern.compile("\\b(MAP \\d{1,2}|\\d{1,2}-[A-Z]\\d), (ZONE \\d)$");

  public NYNassauCountyElmontParser() {
    super(CITY_LIST, "NASSAU COUNTY", "NY", 
           "Call:CALL! Sub:ADDR/SC! Cross:INFO");
  }
  
  @Override
  public String getFilter() {
    return "Elmont@Alarms.com";
  }
  
  private class MyInfoField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = MAP_ZONE_PTN.matcher(field);
      if (match.find()) {
        data.strMap = match.group(1);
        data.strUnit = match.group(2);
        field = field.substring(0, match.start()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO MAP UNIT";
    }
    
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
