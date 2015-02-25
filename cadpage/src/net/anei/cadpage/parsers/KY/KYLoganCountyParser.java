package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class KYLoganCountyParser extends DispatchB2Parser {
  
  public KYLoganCountyParser() {
    super("911-CENTER:",CITY_LIST, "LOGAN COUNTY", "KY");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@logancounty.ky.gov";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ADAIRVILLE",
    "AUBURN",
    "LEWISBURG",
    "OLMSTEAD",
    "RUSSELLVILLE"
    };

  @Override
  protected CodeSet buildCallList() {
    return new CodeSet(
        
        "?",        "UNKNOWN",
        "304",      "ALARM",
        "1045",     "AUTOMOBILE ACCIDENT",
        "1046",     "AUTOMOBILE ACCIDENT W/INJURIES",
        "F1",       "FIRE BRUSH",
        "LA",       "LIFTING ASSISTANCE",
        "M01",      "CHEST PAIN",
        "M05",      "DIFF BREATHING",
        "M10",      "MEDICAL / ALL OTHER",
        "SMOKEI",   "SMOKE INVESTIGATION"

    );
  }
}
