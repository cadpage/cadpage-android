package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Ashtabula County, OH
Contact: "Shane Gregory" <lsgregoryshane@fairpoint.net>
Sender: Sheriffadmin@ashtabulacounty.us

FIRE, 320 EAST MAIN ST ORWELL, EASTON RD,ORWELL//LEFFINGWELL DR,ORWELL, HEAVY SMOKE COMING FROM A RESIDENCE BEHIND MIDWAY 
FIRE, 4396 MONTGOMERY RD WINDSOR TWP, MONTGOMERY RD,ORWELL TWP//WINDSOR-MECHANICSVILLE RD,WINDSOR TWP, HEAVY SMOKE IN THE AREA OF THIS LOCATION THAT
FIRE, 3595 US RT 322 ORWELL TWP, PARKER RD,ORWELL TWP//, LARGE BON FIRE IN A FIELD ACROSS THE STREET FROM THIS ADDRESS, APPEARS UNATTENDED, NEAR A S
INJURY CRASH, 862 US RT 322  W COLEBROOK TWP, FEE RD,COLEBROOK TWP//ST RT 46,COLEBROOK TWP, 1 VEHICLE MVA, DRIVER IS IN THE DITCH, UNRESPONSIVE, IS 
FIRE, 7437 ST RT 45 ORWELL TWP, HAGUE RD,ORWELL TWP//NEW HUDSON RD,ORWELL TWP, SOMEONE BURNING TRASH SOUTH OF THIS LOCATION
FIRE, 6091 ST RT 86 WINDSOR TWP, HYDE RD,WINDSOR TWP//STONEVILLE RD,WINDSOR TWP, POSSIBLE FIELD FIRE
ALARM DROP, 8789 ST RT 45 ORWELL TWP, WATERS RD,ORWELL TWP//WINTERS RD,ORWELL TWP, GENERAL FIRE ALARM, KINGS STORAGE GARAGE
FIRE, 6410 US RT 322 WINDSOR TWP, COX RD,WINDSOR TWP//WISWELL RD,WINDSOR TWP, BRUSH FIRE APPROX 100 FEET OFF THE ROAD
FIRE,  ST RT 46/WINDSOR RD W COLEBROOK TWP, //,

 */


public class OHAshtabulaCountyParser extends FieldProgramParser {

  private MyCrossField crossField; 

  public OHAshtabulaCountyParser() {
    super(CITY_LIST, "ASHTABULA COUNTY", "OH",
           "CALL ADDR/S X!+? INFO+");
  }
  
  @Override
  public String getFilter() {
    crossField.reset();
    return "Sheriffadmin@ashtabulacounty.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    crossField.reset();
    return parseFields(body.split(","), data);
  }
  
  // Complicated cross field processing results from the unfortunate fact that
  // the separate up to two cross streets into a cross street and city name
  // separated by a comma.  But we use comma as a field separator, so what should
  // be one fairly simple cross street field becomes up two 3 different state fields
  // that must be processed as a state engine
  private class MyCrossField extends CrossField {
    private int state = 0;
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    public void reset() {
      state = 0;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // Switch on current state
      switch (state) {
      
      case 0:  // First cross field

        // Normally the first field contains the first cross
        // street and does not contain a double //
        if (!field.contains("//")) {
          data.strCross = field;
          state = 1;
          break;
        }

        // Otherwise, this really the second field
        // so drop into secodn field processing
        state = 1;
      
      case 1:  // Second cross field
        
        // This has to contain a double // that splits this field into two parts
        int pt = field.indexOf("//");
        if (pt < 0) abort();
        String part1 = field.substring(0,pt).trim();
        String part2 = field.substring(pt+2).trim();
        
        // If we have a cross street, part1 is the cross street city and can be skipped
        // If we don't, part 1 is the first cross street
        if (part1.length() > 0) {
          if (data.strCross.length() == 0) data.strCross = part1;
        }
        
        // If there is no part2, then there is no second part street and we are finished
        if (part2.length() == 0) {
          state = 3;
        }
        
        // Otherwise part2 is the cross street and we have to skip over another  city field
        data.strCross = append(data.strCross, " & ", part2);
        state = 2;
        break;
        
      case 2: // Third cross field
        
        // We expect the second street city to be the same as the main address city
        // If it isn't, treat this as not being a cross street
        state = 3;
        if (!field.equals(data.strCity)) return false;
        break;
        
      case 3: // All fields processed
        return false;
      }
      
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, ", ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return (crossField != null ? crossField : (crossField = new MyCrossField()));
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{

    // Cities
    "ASHTABULA",
    "CONNEAUT",
    "GENEVA",
    
    // Vilages
    "ANDOVER",
    "GENEVA-ON-THE-LAKE",
    "JEFFERSON",
    "NORTH KINGSVILLE",
    "ORWELL",
    "ROAMING SHORES",
    "ROCK CREEK",

    // Townships
    "ANDOVER TWP",
    "ASHTABULA TWP",
    "AUSTINBURG TWP",
    "CHERRY VALLEY TWP",
    "COLEBROOK TWP",
    "DENMARK TWP",
    "DORSET TWP",
    "GENEVA TWP",
    "HARPERSFIELD TWP",
    "HARTSGROVE TWP",
    "JEFFERSON TWP",
    "KINGSVILLE TWP",
    "LENOX TWP",
    "MONROE TWP",
    "MORGAN TWP",
    "NEW LYME TWP",
    "ORWELL TWP",
    "PIERPONT TWP",
    "PLYMOUTH TWP",
    "RICHMOND TWP",
    "ROME TWP",
    "SAYBROOK TWP",
    "SHEFFIELD TWP",
    "TRUMBULL TWP",
    "WAYNE TWP",
    "WILLIAMSFIELD TWP",
    "WINDSOR TWP",
    
    // Census designated places
    "EDGEWOOD",
    
    // Other communities
    "AUSTINBURG",
    "DORSET",
    "EAGLEVILLE",
    "FOOTVILLE",
    "KINGSVILLE",
    "PIERPONT",
    "UNIONVILLE"
  };
}
