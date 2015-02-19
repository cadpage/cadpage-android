package net.anei.cadpage.parsers.IN;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA29Parser;

/**
 * Starke County, IN
 */
public class INStarkeCountyParser extends DispatchA29Parser {
  
  private static final Pattern ADDR_HALF_PTN = Pattern.compile("[ /](\\d+ 1/2), *");

  public INStarkeCountyParser() {
    super(CITY_LIST, "STARKE COUNTY", "IN");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "HAMLET INDUSTRIAL",
        "LONG LANE",
        "RANNELLS E",
        "ST LOUIS"
    );
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@co.starke.in.us,messaging@iamresponding.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // The put commas following 1/2 street numbers, which really messes up the address parsing
    body = ADDR_HALF_PTN.matcher(body).replaceFirst(" $1 ");
    return super.parseMsg(body, data);
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "8017 CO2 DETECTOR ALARM",
      "8030 FOLLOW-UP INVESTIGATION",
      "8036 HARRASSMENT",
      "8040 RESCUE/AMBULANCE",
      "8044 FIRE-BRUSH",
      "8045 FIRE-GENERAL",
      "8048 FIRE-STRUCTURE",
      "8049 FIRE-VEHICLE",
      "8050 FIRE ALARM",
      "8067 MISSING PERSON",
      "8073 RAPE",
      "8083 SUSPICIOUS CIRCUMSTANCES",
      "8088 TRAFFIC ACCIDENT-INJURIES",
      "8089 TRAFFIC ACCIDENT-PROPERTY DAMAGE",
      "8115 BURN COMPLAINT",
      "8125 911 CELLPHONE CALL",
      "8090 TRAFFIC COMPLAINT",
      "8097 911 HANG UP/ MISDIAL",
      "8145 GAS ODOR",
      "8146 GAS SPILL",
      "8161 MEDICAL",
      "8187 MEDICAL TRANSFER",
      "8190 CONTROL BURN",
      "8203 DECEASED PERSON",
      "8217 TRAFFIC ACCIDENT SLIDE OFF NO DAMAGE",
      "8218 TRAFFIC ACCIDENT UNKNOWN",
      "9999 FIRE PAGER MESSAGE"
  );
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities and towns
    "HAMLET",
    "KNOX",
    "NORTH JUDSON",
 
    // Unincorporated towns
    "BASS LAKE",
    "ENGLISH LAKE",
    "GROVERTOWN",
    "KOONTZ LAKE",
    "ORA",
    "SAN PIERRE",
 
    // Townships
    "CALIFORNIA TWP",
    "CENTER TWP",
    "DAVIS TWP",
    "JACKSON TWP",
    "NORTH BEND TWP",
    "OREGON TWP",
    "RAILROAD TWP",
    "WASHINGTON TWP",
    "WAYNE TWP",
    
    // Jasper County
    "WHEATFIELD",
    
    // Joseph County
    "WALKERTON",
    
    // LaPorte County
    "LAPORTE",
    
    // Marshall County
    "CULVER",
    "PLYMOUTH",
    
    // Pulaski County
    "MONTEREY"
      
  };
}
