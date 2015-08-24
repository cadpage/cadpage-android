package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchA48Parser;


public class PATiogaCountyParser extends DispatchA48Parser {

  public PATiogaCountyParser() {
    super(CITY_LIST, "TIOGA COUNTY", "PA", FieldType.NONE, A48_NO_CODE);
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "AMEIGH VALLEY",
        "BAKER CREST",
        "LAUREL HILL",
        "WHISPERING PINES"
    );
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "ABDOMINAL PAIN",
      "BREATHING PROBLEMS - ASTHMA - DIFF SPKING BETWEEN BREATHS",
      "BREATHING PROBLEMS - CHANGING COLOR",
      "CHEST PAIN - CLAMMY",
      "FALLS - CHEST OR NECK INJURY WITH DIFF BREATHING - STILL ON THE GROUND",
      "FALLS - LONG FALL",
      "FALLS - NOT DANGEROUS BODY AREA - STILL ON THE GROUND",
      "MEDICAL",
      "MVA",
      "SICK PERSON - NO PRIORITY SYMPTOMS - TRANSPORTATION ONLY",
      "SICK PERSON - NO PRIORITY SYMPTOMS - UNWELL/ILL",
      "SMOKE INVESTIGATION",
      "STRUCTURE FIRE",
      "UNCONSCIOUS/FAINTING - NOT ALERT",
      "UNCONSCIOUS/FAINTING - UNCONSCIOUS - EFFECTIVE BREATHING",
      "UNKNOWN CONDITIONS",
      "VEHICLE FIRE"
  );
  
  private static final String[] CITY_LIST = new String[]{
    "BLOSSBURG BORO",
    "ELKLAND BORO",
    "KNOXVILLE BORO",
    "LAWRENCEVILLE BORO",
    "LIBERTY BORO",
    "MANSFIELD BORO",
    "ROSEVILLE BORO",
    "TIOGA BORO",
    "WELLSBORO BORO",
    "WESTFIELD BORO",

    "BLOSS TWP",
    "BROOKFIELD TWP",
    "CHARLESTON TWP",
    "CHATHAM TWP",
    "CLYMER TWP",
    "COVINGTON TWP",
    "DEERFIELD TWP",
    "DELMAR TWP",
    "DUNCAN TWP",
    "ELK TWP",
    "FARMINGTON TWP",
    "GAINES TWP",
    "HAMILTON TWP",
    "JACKSON TWP",
    "LAWRENCE TWP",
    "LIBERTY TWP",
    "MIDDLEBURY TWP",
    "MORRIS TWP",
    "NELSON TWP",
    "OSCEOLA TWP",
    "PUTNAM TWP",
    "RICHMOND TWP",
    "RUTLAND TWP",
    "SHIPPEN TWP",
    "SULLIVAN TWP",
    "TIOGA TWP",
    "UNION TWP",
    "WARD TWP",
    "WESTFIELD TWP",
    
    // Bradford County
    "WELLS TWP",
    
    // Potter County
    "HEBRON TWP"
  };
}
