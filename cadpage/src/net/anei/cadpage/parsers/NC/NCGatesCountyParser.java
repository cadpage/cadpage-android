package net.anei.cadpage.parsers.NC;


import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Gates County, NC
 */

public class NCGatesCountyParser extends DispatchSouthernParser {
  
  public NCGatesCountyParser() {
    super(CALL_LIST, CITY_LIST, "GATES COUNTY", "NC", DSFLAG_CROSS_NAME_PHONE | DSFLAG_FOLLOW_CROSS);
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("0 ")) body = body.substring(2).trim();
    return super.parseMsg(body, data);
  }

  @Override
  public String adjustMapAddress(String addr) {
    return addr.replace(" TRLR PARK", " TR PARK");
  }


  private static final String[] CITY_LIST = new String[] {
    //City
    "GATESVILLE",
    
    // Townships
    "GATESVILLE",
    "HALL",
    "REYNOLDSON",
    "HASLETT",
    "HOLLY GROVE",
    "HUNTERS MILL",
    "MINTONSVILLE",
    
    // County Districts
    "GATESVILLE",
    "EURE",
    "GATES",
    "SUNBURY",
    "HOBBSVILLE",
    
    // Unincorporated  
    "CORAPEAKE",
    "EASON CROSSROADS",
    "EURE",
    "HOFLERS FORK",
    "GATES",
    "MINTONSVILLE",
    "SELWIN",
    "TARHEEL",
    
    // Perquimans County
    "BELVIDERE",
    "HERTFORD",
    "WINFALL",
    
    // Chowan County
    "EDENTON"
    
  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "Breathing Problems",
      "Diabetic",
      "Fall",
      "Fire",
      "Medical",
      "MVC with Injury",
      "Non Emergency Transport",
      "Vehicle Fire"
  );
}
