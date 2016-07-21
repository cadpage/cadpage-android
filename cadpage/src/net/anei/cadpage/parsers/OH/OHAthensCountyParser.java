package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHAthensCountyParser extends DispatchEmergitechParser {
  
  public OHAthensCountyParser() {
<<<<<<< HEAD
    super("911_Dispatch:", 60, CITY_LIST, "ATHENS COUNTY", "OH", TrailAddrType.INFO);
    addSpecialWords("COLUMBUS");
    setupMultiWordStreets("LIGHTFRITZ RIDGE");
    setupSpecialStreets("LIGHTFRITZ RIDGE");
=======
    super("911_Dispatch:", true, 0, CITY_LIST, "ATHENS COUNTY", "OH");
    setupMultiWordStreets(MWORD_STREET_LIST);
    setupSpecialStreets("OREGON RIDGE");
>>>>>>> master
  }
  
  @Override
  public String getFilter() {
    return "911_Dispatch@athensoh.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strApt.startsWith("CALLBK=")) {
      data.strPhone = data.strApt.substring(7).trim();
      data.strApt = "";
    }
    if (data.strSupp.length() == 0) {
      data.strSupp = data.strName;
      data.strName = "";
    }
    return true;
  }
  
  private static final String[] MWORD_STREET_LIST = new String[]{
    "ANGEL RIDGE",
    "BIG BAILEY RUN",
    "BIG RUN",
    "CANAANVILLE HILLS",
    "CIRCLE 33",
    "COOLVILLE RIDGE",
    "ELM ROCK",
    "FOUR MILE CREEK",
    "GLOUSTER GLEN",
    "GRAHAM CHAPEL",
    "GUN CLUB",
    "HAMLEY RUN",
    "JENKINS DAM",
    "JEWELL HOLLOW",
    "JOHN LLOYD EVANS MEMORIAL",
    "LADD RIDGE",
    "LONG RUN",
    "M E",
    "MILL SCHOOL",
    "MT ST MARY",
    "PEACH RIDGE",
    "PERRY RIDGE",
    "PLEASANT HILL",
    "ROCK RUN",
    "SAND RIDGE",
    "TEN SPOT",
    "VORE RIDGE"
   
  };

  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "ATHENS",
    "NELSONVILLE",
    
    // Villages
    "ALBANY",
    "AMESVILLE",
    "BUCHTEL",
    "CHAUNCEY",
    "COOLVILLE",
    "GLOUSTER",
    "JACKSONVILLE",
    "TRIMBLE",
    
    // Townships
    "ALEXANDER TWP",
    "AMES TWP",
    "ATHENS TWP",
    "BERN TWP",
    "CANAAN TWP",
    "CARTHAGE TWP",
    "DOVER TWP",
    "LEE TWP",
    "LODI TWP",
    "ROME TWP",
    "TRIMBLE TWP",
    "TROY TWP",
    "WATERLOO TWP",
    "YORK TWP",

    // Census-designated place
    "THE PLAINS",

    // Other Communities
    "BEEBE",
    "CANAANVILLE",
    "CARBONDALE",
    "DOANVILLE",
    "ENTERPRISE",
    "FROST",
    "GUYSVILLE",
    "HEBBARDSVILLE",
    "HOCKINGPORT",
    "IMPERIAL",
    "KILVERT",
    "MILLFIELD",
    "MINERAL",
    "NEW ENGLAND",
    "NEW FLOODWOOD",
    "NEW MARSHFIELD",
    "REDTOWN",
    "SHADE",
    "SHARPSBURG",
    "STEWART"
  };
}
