package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHKnoxCountyParser extends DispatchEmergitechParser {
  
  public OHKnoxCountyParser() {
    super("Dispatch:", 69, CITY_LIST, "KNOX COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@smtp-server.Columbus.rr.com";
  }
  
  private static final String[] CITY_LIST = new String[]{

    "MOUNT VERNON",

    "CENTERBURG",
    "DANVILLE",
    "FREDERICKTOWN",
    "GAMBIER",
    "GANN",
    "MARTINSBURG",
    "UTICA",

    "BERLIN TWP",
    "BROWN TWP",
    "BUTLER TWP",
    "CLAY TWP",
    "CLINTON TWP",
    "COLLEGE TWP",
    "HARRISON TWP",
    "HILLIAR TWP",
    "HOWARD TWP",
    "JACKSON TWP",
    "JEFFERSON TWP",
    "LIBERTY TWP",
    "MIDDLEBURY TWP",
    "MILFORD TWP",
    "MILLER TWP",
    "MONROE TWP",
    "MORGAN TWP",
    "MORRIS TWP",
    "PIKE TWP",
    "PLEASANT TWP",
    "UNION TWP",
    "WAYNE TWP",

    "BANGS",
    "BLADENSBURG",
    "HOWARD",
    "MOUNT LIBERTY",
  };
}
