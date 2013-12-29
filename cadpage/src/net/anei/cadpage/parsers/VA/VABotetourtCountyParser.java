package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Botetourt County, VA
 */
public class VABotetourtCountyParser extends DispatchSouthernParser {
  
  public VABotetourtCountyParser() {
    super(CALL_SET, CITY_LIST, "BOTETOURT COUNTY", "VA", DSFLAG_DISPATCH_ID | DSFLAG_LEAD_PLACE);
  }

  @Override
  public String getFilter() {
    return "@botetourtva.us";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BLUE RIDGE",
    "BUCHANAN",
    "CLOVERDALE",
    "DALEVILLE",
    "EAGLE ROCK",
    "FINCASTLE",
    "HOLLINS",
    "ORISKANY",
    "ROANOKE",
    "SPRINGWOOD",
    "TROUTVILLE"
  }; 
  
  private static final CodeSet CALL_SET = new CodeSet(
      "F - AIRPLANE CRASH",
      "F - BRUSH/GRASS FIRE",
      "F - BRUSH / GRASS FIRE",
      "F - BURN ILLEGALLY",
      "F - CARBON MONOXIDE",
      "F - DUMPSTER FIRE",
      "F - ELEVATOR RESCUE",
      "F - FIRE ALARM",
      "F - FIRE SERVICE CALL ",
      "F - FIRE STANDBY",
      "F - HAZMAT",
      "F - NAT'L GAS LEAK",
      "F - OTHER FIRE",
      "F - SMOKE REPORT",
      "F - STRUCTURE FIRE",
      "F - TRAIN DERAILMENT",
      "F - VEHICLE FIRE",
      "F - WEATHER",
      "F - WIRE DOWN/TRANSFORMER",
      "F - WIRES DOWN/TRANSFORMER",
      "F - WORKING FIRE",
      "MVC - ENTRAPMENT",
      "MVC - INJURY",
      "MVC - PROPERTY (NO PI)",
      "MVC -MCI/BUS",
      "MVC - MCI/BUS",
      "SOTT - SEARCH & RESCUE",
      "SOTT - TECHNICAL RESCUE",
      "SOTT - WATER RESCUE",
      "ALS - ABDOMINAL",
      "ALS - ALLERGIC REACTION",
      "ALS - ANIMAL BITE",
      "ALS - BACK  PAIN",
      "ALS - BREATHING DIFF",
      "ALS - BURN",
      "ALS - CARDIAC ",
      "ALS - CHILD BIRTH / OBGYN",
      "ALS - CHOKING",
      "ALS - DECREASED LOC",
      "ALS - DIABETIC",
      "ALS- DROWNING/WATER INJURY",
      "ALS - DROWNING/WATER INJURY",
      "ALS- ENVIRONMENTAL EMERG.",
      "ALS - ENVIRONMENTAL EMERG.",
      "ALS - FALL",
      "ALS - FRACTURE",
      "ALS- GYN/MISCARRIAGE",
      "ALS - GYN/MISCARRIAGE",
      "ALS - HEAD INJURY",
      "ALS - HEADACHE",
      "ALS - INDUSTRIAL ACCIDENT",
      "ALS - LACERATION",
      "ALS - MISC ILLNESS",
      "ALS - OVERDOSE",
      "ALS - POISONING",
      "ALS - SEIZURE",
      "ALS- SEVERE BLEED (NON-TRAUMATIC)",
      "ALS - STROKE",
      "ALS- TRAUMATIC INJURY",
      "ALS - UNCONSCIOUS",
      "ALSC - CODE BLUE",
      "ALSC - STAB/GUNSHOT WOUND",
      "BLS - ABDOMINAL ",
      "BLS - ALLERGIC REACTION",
      "BLS - ANIMAL BITE",
      "BLS - BACK  PAIN",
      "BLS - BURN",
      "BLS - CARDIAC",
      "BLS - CHILDBIRTH / OBGYN",
      "BLS - CHOKING",
      "BLS - DIABETIC",
      "BLS- DROWNING/WATER INJURY",
      "BLS - DROWNING/WATER INJURY",
      "BLS- ENVIRONMENTAL EMERG.",
      "BLS - ENVIRONMENTAL EMERG.",
      "BLS - FALL",
      "BLS - FRACTURE",
      "BLS- GYN/MISCARRIAGE",
      "BLS - GYN/MISCARRIAGE",
      "BLS - HEAD INJURY",
      "BLS - HEADACHE",
      "BLS - INDUSTRIAL ACCIDENT",
      "BLS - LACERATION",
      "BLS - MEDICAL ALARM",
      "BLS - MEDICAL SERVICE CALL ",
      "BLS - MEDICAL STANDBY",
      "BLS - MISC ILLNESS",
      "BLS - NON-EMERGENCY TRANSPORT",
      "BLS - OVERDOSE",
      "BLS - POISONING",
      "BLS - SEIZURE",
      "BLS - SEVERE BLEED (NON-TRAUMATIC)",
      "BLS - STROKE",
      
      "ACCIDENT 10-50 NB",
      "CARDIAC",
      "FLUE FIRE",
      "MISC ILLNESS",
      "SOTT - SEARCH AND RESCUE"
  );
}
