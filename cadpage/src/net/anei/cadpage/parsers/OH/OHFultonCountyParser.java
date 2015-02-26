package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

public class OHFultonCountyParser extends DispatchEmergitechParser {
  
  public OHFultonCountyParser() {
    super(0, CITY_LIST, "FULTON COUNTY", "OH");
  }
 
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    body = subject + ':' + body;
    return super.parseMsg(body, data);
  }

  private static final String[] CITY_LIST = new String[]{
    //CITY
    "WAUSEON",
    
    //VILLAGES
    "ARCHBOLD",
    "DELTA",
    "FAYETTE",
    "LYONS",
    "METAMORA",
    "SWANTON",

    //TOWNSHIPS
    "AMBOY TWP",
    "CHESTERFIELD TWP",
    "CLINTON TWP",
    "DOVER TWP",
    "FRANKLIN TWP",
    "FULTON TWP",
    "GERMAN TWP",
    "GORHAM TWP",
    "PIKE TWP",
    "ROYALTON TWP",
    "SWAN CREEK TWP",
    "YORK TWP",

   //OTHER
    "PETTISVILLE",
    "TEDROW",
    
    // Williams County
    "ALVORDTON",
    "MILL CREEK TWP"
  };
}
