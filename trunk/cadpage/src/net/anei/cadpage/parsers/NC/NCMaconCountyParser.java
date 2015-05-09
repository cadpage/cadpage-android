package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class NCMaconCountyParser extends DispatchB2Parser {
  
  private static final String PRIMARY_PREFIX = "MACON 911 MACON911:";
  private static Pattern ALT_PREFIX_PTN = Pattern.compile("911 CENTER:|MACON911:");
 
  public NCMaconCountyParser() {
    super(PRIMARY_PREFIX, CITY_LIST, "MACON COUNTY", "NC");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = ALT_PREFIX_PTN.matcher(body);
    if (match.lookingAt()) {
      body = PRIMARY_PREFIX + body.substring(match.end());
    }
    body = stripFieldEnd(body, " Stop");
    return super.parseMsg(body, data);
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
