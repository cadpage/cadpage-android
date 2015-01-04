package net.anei.cadpage.parsers.WV;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class WVMarionCountyParser extends DispatchB2Parser {
  
  public WVMarionCountyParser() {
    super("MARION_CO_911:", CITY_LIST, "MARION COUNTY", "WV");
    setupCallList(CALL_LIST);
  }
  private static final String[] CITY_LIST = new String[]{

    "BARRACKVILLE",
    "BAXTER",
    "BEVERLEY HILLS",
    "BIG RUN",
    "BAXTER",
    "BEVERLEY HILLS",
    "BIG RUN",
    "BOOTHSVILLE",
    "BOOTHSVILLE TOWNSHIP",
    "FAIRMONT",
    "FAIRVIEW",
    "FARMINGTON",
    "GRANT TOWN",
    "GRAYS FLAT",
    "HEBRON",
    "MANNINGTON",
    "MONONGAH",
    "PINE GROVE",
    "PLEASANT VALLEY",
    "RIVESVILLE",
    "STRINGTOWN",
    "WHITEHALL",
    "WORTHINGTON"
  };
  private static final CodeSet CALL_LIST = new CodeSet(
      "ANIMAL COMPLAINT",
      "AUTO FIRE ALARM COMMERCIAL",
      "AUTO FIRE ALARM NON COMMERCIAL",
      "BRUSH FIRE",
      "CARDIAC ARREST",
      "CHEST PAINS",
      "CHIMNEY FIRE",
      "CO ALARM",
      "CVA",
      "DETAIL",
      "DIABETIC PROBLEM",
      "DIFFICULTY IN BREATHING",
      "DOMESTIC",
      "EMERGENCY TRANSFER",
      "GENERAL ILLNESS CALL",
      "HEMORRHAGE",
      "LIFELINE CALL",
      "LOADING ASSISTANCE",
      "MAN/WOMAN DOWN",
      "MEDICAL PROBLEM",
      "ON THE AIR",
      "OVERDOSE",
      "PIA-FALL",
      "PIA-PERSONAL INJURY ACCIDENT",
      "POSSIBLE CARDIAC",
      "POWERLINES DOWN",
      "ROCK SLIDE",
      "SEIZURES",
      "STRUCTURE FIRE",
      "TRAINING-FIRE",
      "TREE DOWN",
      "UNCONSCIOUS PATIENT",
      "UNRESPONSIVE PATIENT",
      "VEHICLE ACCIDENT WITH ENTRAP",
      "VEHICLE ACCIDENT WITH INJURY",
      "VEHICLE FIRE WITH EXPOSURE",
      "WELL-BEING CHECK"
      
 );

}
