package net.anei.cadpage.parsers.IN;


import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchA29Parser;

/**
 * Starke County, IN
 */
public class INStarkeCountyParser extends DispatchA29Parser {
  
  public INStarkeCountyParser() {
    super(CITY_LIST, "STARKE COUNTY", "IN");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "HAMLET INDUSTRIAL",
        "ST LOUIS"
    );
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@co.starke.in.us,messaging@iamresponding.com";
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "8030 FOLLOW-UP INVESTIGATION",
      "8040 RESCUE/AMBULANCE",
      "8044 FIRE-BRUSH",
      "8045 FIRE-GENERAL",
      "8045 FIRE-GENERAL MOUND",
      "8045 FIRE-GENERAL SANDBAR",
      "8048 FIRE-STRUCTURE",
      "8048 FIRE-STRUCTURE MOUND AND MCGILL",
      "8049 FIRE-VEHICLE",
      "8050 FIRE ALARM",
      "8050 FIRE ALARM KNOX ELEMENTARY",
      "8050 FIRE ALARM SELECT FURNITURE",
      "8067 MISSING PERSON",
      "8073 RAPE",
      "8088 TRAFFIC ACCIDENT-INJURIES",
      "8089 TRAFFIC ACCIDENT-PROPERTY DAMAGE",
      "8097 911 HANG UP/ MISDIAL",
      "8145 GAS ODOR",
      "8146 GAS SPILL",
      "8161 MEDICAL",
      "8187 MEDICAL TRANSFER",
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
    
    // Marshall County
    "CULVER",
    "PLYMOUTH",
    
    // Pulaski County
    "MONTEREY"
      
  };
}
