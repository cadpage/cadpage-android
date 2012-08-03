package net.anei.cadpage.parsers.NY;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Orange County, NY 
Contact: CodeMessaging

[sCAD] ALS MEDICAL CALL |14 MAPLE AVE |CORNWALL /MFELL DOWN THE STAIRS 12 STEPS 55 YEAR OLD FEMALE CONSCIOUS BREATHING 1)THIS HAPPENED NOW (LESS THAN 6HRS AGO) 2)THE FALL WAS LESS THAN 10FT/ XST: 237 HUDSON ST
[sCAD] VEHICLE FIRE |85 DUNCAN AVE |CORNWALL /CALLER STATED HE CAN SEE A VEHICLE ON FIRE IN FRONT OF LOCATION // |CORNWALL XST: AQUEDUCT LN /29 STILLMAN AVE
[sCAD] AUTOMATIC FIRE ALARM |114 BAY VIEW AVE |CORNWALL /GENERAL FIRE - PREMISE 534-7900 KEY ATTEMPT |CAMP OLMSTED XST: 1 TAFT PL /1 WINTERVIEW LN
[sCAD] ELECTRICAL FIRE |152 HUDSON ST |CORNWALL /ELECTRICAL BURNING SMELL - SEE NO SMOKE OR FIRE - NO DECTECTORS GOING OFF |CORNWALL V XST: 1 BAY VIEW AVE/RIVERSIDE DR
[sCAD] BRUSH FIRE |BAY VIEW AVE&MOUNTAIN HOUSE LN |CORNWALL /BRUSH FIRE IN THE AREA OF THE OVERLOOK |NEWBURGH C message has been scanned for malware.
[sCAD] ALS MEDICAL CALL |19 IDLEWILD PARK DR |CORNWALL /MPOSSIBLE HEART ATTACK AGE UNKNOWN GENDER UNKNOWN CONSCIOUSNESS UNKNOWN BREATHING STATUS UNKNOWN MULTIPLE PATIENTS INVOLVED: 55) 1)THEY ARE C XST: 25 CURIE RD
[sCAD] ALS MEDICAL CALL |374 HUDSON ST |CORNWALL /MFALL UNCONSCIOUS 50 YEAR OLD MALE UNCONSCIOUS BREATHING 1)HIS BREA THING IS NOT COMPLETELY NORMAL 2)THE CALLER IS UNABLE TO ASSESS THEPATI XST: 10 KELLY LN /27 FIRST ST
[sCAD] ALS MEDICAL CALL |7 PARTRIDGE RD |CORNWALL /86YOF//AWAKE AND BREATHING//PT IS ALERT//BREATHING NORMALLY//SUDDEN SPEEC H PROBLEMS//STARTED APPX AN HOUR AGO//NO HISTORY OF STROKE XST: 219 MOUNTAIN RD
[sCAD] AUTOMATIC FIRE ALARM |314 MOUNTAIN RD |CORNWALL /AUTOMATIC ALARM |STORM KING SCHOOL XST: 41 DEER HILL RD /US RTE 9W
[sCAD] AUTOMATIC FIRE ALARM |146 BAY VIEW AVE |CORNWALL /BUSINESS - KIRK WOOD HOUSE - ZONE 5 THIRD FLOOR - NO CONTACT - 845-534-39 76 XST: 1 TAFT PL /1 WINTERVIEW LN
[sCAD] CARBON MONOXIDE DETR APT: 9 |289 HUDSON ST |CORNWALL /CO ALARM SOUNDED |CORNWALL V XST: 5 COLUMBUS AVE /7 COLONIAL PL


*/

public class NYOrangeCountyDParser extends FieldProgramParser {
  
  public NYOrangeCountyDParser() {
    super("ORANGE COUNTY", "NY",
        "CALL! ADDR! CITY! XST:X");
  }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }

  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("sCAD")) return false;
    body = body.replace("XST:", "|XST:");
    if (!parseFields(body.split("\\|"), data)) return false; 
    return true;
  }
    private class MyCityField extends CityField {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('/');
      if (pt > 0) {
        data.strSupp = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CITY INFO";
    }
  }
     
    @Override
    protected Field getField(String name) {
      if (name.equals("CITY")) return new MyCityField();
      return super.getField(name);
    }
}

