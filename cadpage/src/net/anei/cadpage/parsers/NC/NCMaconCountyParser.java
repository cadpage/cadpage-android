package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class NCMaconCountyParser extends DispatchB2Parser {
  
  private static final String PRIMARY_PREFIX = "MACON 911 MACON911:||MACON 911: MACON911:||911 CENTER:||MACON911:";
 
  public NCMaconCountyParser() {
    super(PRIMARY_PREFIX, CITY_LIST, "MACON COUNTY", "NC");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = stripFieldEnd(body, " Stop");
    if (! super.parseMsg(body, data)) return false;
    data.strCross = data.strCross.replace('@', '/');
    return true;
  }


  private static final String[] CITY_LIST = new String[]{
    "FRANKLIN", 
    "HIGHLANDS", 
    "OTTO",
    "FRANKLIN TWP", 
    "HIGHLANDS TWP", 
    "SUGARFORK TWP", 
    "BURNINGTOWN TWP",
    "CARTOOGECHAYE TWP", 
    "ELLIJAY TWP", 
    "MILLSHOAL TWP",
    "NANTAHALA TWP", 
    "SMITHBRIDGE TWP",
  };
}
