package net.anei.cadpage.parsers.WV;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class WVMarionCountyParser extends DispatchB2Parser {
  
  public WVMarionCountyParser() {
    super("MARION_CO_911:", CITY_LIST, "MARION COUNTY", "WV");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "1/2 GASTON",
        "1/2 SPEEDWAY",
        "BEECHLICK RUN",
        "BIG INDIAN RUN",
        "BLUE HERON",
        "BRICK HILL",
        "BUNNERS RUN",
        "CAMP RUN",
        "COUNTRY CLUB",
        "DAVIS RIDGE",
        "EAST GRAFTON",
        "EAST RUN",
        "FOUR STATES",
        "GRASSY RUN",
        "HELENS RUN",
        "HILL - TANK HILL",
        "KOONS RUN",
        "MODS RUN",
        "ODELLS KNOB",
        "PARRISH RUN",
        "RADYPECK HOLLOW",
        "ST BARBARAS",
        "SUGAR CAMP",
        "SUNNY CROFT",
        "TYGART MALL",
        "WHITE HALL",
        "WOLFPIT RUN"
    );
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.endsWith(" CO"))  data.strCity += "UNTY";
    data.strCity = stripFieldEnd(data.strCity, " HARRCO");
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ANMOORE",
    "ARLINGTON",
    "BARRACKVILLE",
    "BAXTER",
    "BEVERLEY HILLS",
    "BIG RUN",
    "BOOTHSVILLE TWP",
    "BOOTHSVILLE",
    "CAROLINA",
    "CLARKSBURG",
    "DESPARD",
    "ENTERPRISE",
    "FAIRMONT",
    "FAIRVIEW",
    "FARMINGTON",
    "FOUR STATES",
    "GLEN FALLS",
    "GRANT TOWN",
    "GRAYS FLAT",
    "GYPSY",
    "HEBRON",
    "JIMTOWN",
    "LOST CREEK",
    "LUMBERPORT",
    "MANNINGTON",
    "METZ",
    "MONONGAH",
    "NUTTER FORT",
    "PINE GROVE",
    "PLEASANT VALLEY",
    "RIVESVILLE",
    "SALEM",
    "SHINNSTON",
    "STONEWOOD",
    "STRINGTOWN",
    "WEST MILFORD",
    "WHITE HALL",
    "WHITEHALL",
    "WORTHINGTON",
    "WYATT",
    
    "HARRISON COUNTY",
    "HARRISON CO",
    "HARRISON",
    "LUMBERPORT HARRCO",
    
    "MARION COUNTY",
    "MARION CO",
    "MARION",
    
    "MONONGALIA COUNTY",
    "MONONGALIA CO",
    "MONONGALIA",
    
    "TAYLOR COUNTY",
    "TAYLOR CO",
    "TAYLOR",
    
    "WETZEL COUNNTY",
    "WETZEL CO",
    "WETZEL"
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
