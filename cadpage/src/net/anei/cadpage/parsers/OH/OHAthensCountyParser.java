package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHAthensCountyParser extends DispatchEmergitechParser {
  
  public OHAthensCountyParser() {
    super("911_Dispatch", 73, CITY_LIST, "ATHENS COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "911_Dispatch@athensoh.org";
  }
  
  
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // If preparser removed the dispatch unit, put it back
    if (subject.length() > 0) body = '[' + subject + "]" + body; 
    return super.parseMsg(body, data);
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
