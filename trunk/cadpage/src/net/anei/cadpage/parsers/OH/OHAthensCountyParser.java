package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHAthensCountyParser extends DispatchEmergitechParser {
  
  public OHAthensCountyParser() {
    super("911_Dispatch:", 73, CITY_LIST, "ATHENS COUNTY", "OH");
    addSpecialWords("COLUMBUS");
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
