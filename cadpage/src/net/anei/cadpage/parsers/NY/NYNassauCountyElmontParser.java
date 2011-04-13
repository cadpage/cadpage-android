package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Nassau County, NY (Elmont)
Contact: Edward mccormack <emccorma42@gmail.com>
Contact: HOLEY MOLEY <efd6012@aol.com>
Sender: Elmont@Alarms.com

Subject:4/4/2011 03:24\nCall: SPILL Sub: SPILL LINDEN BLVD ELMONT Cross: ELMONT ROAD &  11-A6, ZONE 5
(4/7/2011 10:37) Call:  Sub: RESC 2095 DUTCH BROADWAY ELMONT Cross: GLAFIL ST & ELMONT ROADMALE WITH HAND STUCK IN BOX CRUSHER 12-B5, ZONE 5
(4/11/2011 16:24) Call: MVAFIRE Sub: MVA 2095 DUTCH BROADWAY ELMONT Cross: GLAFIL ST & ELMONT ROADCAR INTO POLE CAR SMOKING 12-B5, ZONE 5
(4/11/2011 13:33) Call: GENERAL Sub: AUTO 2150 HEMPSTEAD TPK ELMONT Cross: CROSS ISLAND PKWY & PLAINFIELD AVE MAP 21, ZONE 1
(4/11/2011 13:32) Call: GENERAL Sub: AUTO 1835 CENTRAL AVE NO VALLEY STREAM Cross: FENWOOD DR & STUART AVENO PERMIT 16-B7, ZONE 5
(4/11/2011 05:46) Call:  Sub: AMBU 333 BILTMORE AVE ELMONT Cross: BONTA ST & MURRAY HILL STMALE RESP DISTRESS/ CODE 91 7-A4, ZONE 1

*/
public class NYNassauCountyElmontParser extends FieldProgramParser {
  
  private static final String[] CITY_LIST = new String[]{
    "ELMONT", "NO VALLEY STREAM", "ALDEN MANOR", "FLORAL PARK", "SO FLORAL PARK", 
    "STEWART MANOR", "MALVERNE", "FRANKLIN SQUARE", "WEST HEMPSTEAD", "HEMPSTEAD",
    "LYNBROOK", "BELLEROSE", "BELLEROSE TERRACE"
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
