package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/**
 * Amelia County, VA
 */
public class VARockbridgeCountyParser extends DispatchDAPROParser {
  
  public VARockbridgeCountyParser() {
    super(CITY_CODE_TABLE, "ROCKBRIDGE COUNTY", "VA");
    setupCallList(CALL_SET);
    setupMultiWordStreets(
        "MAURY RIVER",
        "MOUNTAIN VIEW",
        "OLD BUENA VISTA");
  }
  
  @Override
  public String getFilter() {
    return "MAILBOX@Rockregional911.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Parser p = new Parser(subject);
    data.strUnit = p.getLast(' ');
    String source = p.get();
    if (!super.parseMsg(body,  data)) return false;
    data.strBox = data.strSource;
    data.strSource = source;
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC UNIT BOX " + super.getProgram();
  }
  
  private static final CodeSet CALL_SET = new CodeSet(
      "ABDOMINAL PAIN",
      "ACCIDENT NO INJURY",
      "ACCIDENT WITH INJURY",
      "BRUSH FIRE GREATER THAN 50' AW",
      "CHEST PAINS/CARDIAC",
      "CHIMNEY FIRE",
      "COMMERCIAL NATURAL GAS/PROPANE",
      "COMMERCIAL VEHICLE FIRE",
      "DIABETIC",
      "DIZZY, SICK, ETC.",
      "EMS SERVICE CALL",
      "FALL",
      "FIRE ALARM",
      "FIRE SERVICE CALL",
      "FLUID LEAK FROM VEHICLE NO INJ",
      "HAZARDOUS MATERIALS CALL",
      "MEDICAL ALARM/LIFELINE ALARM",
      "PAIN NOT RESULTING FORM AN INJ",
      "SERVICE CALL",
      "SHORT OF BREATH/DIFF BREATHING",
      "STRUCTURE FIRE",
      "SWIFT WATER TEAM CALL",
      "TECHNICAL RESCUE CALL",
      "TEST CALL FOR ECC",
      "UNKNOWN MEDICAL EMERGENCY",
      "UNRESPONSIVE",
      "VEHICLE FIRE"
      
  );
  
  private static final Properties CITY_CODE_TABLE =
    buildCodeTable(new String[]{
        "BUE", "BUENA VISTA",
        "LEX", "LEXINGTON",
        "GOS", "GOSHEN",
        "GLA", "GLASGOW",
        "FAI", "FAIRFIELD",
        "NAT", "NATURAL BRIDGE",
        "RAP", "RAPHINE",
        "BRO", "BROWNSBURG"
    });
}