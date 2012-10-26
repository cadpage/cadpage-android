package net.anei.cadpage.parsers.NC;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCHaywoodCountyParser extends DispatchSouthernParser {
  
  public NCHaywoodCountyParser() {
    super(CITY_LIST, "HAYWOOD COUNTY", "NC", DSFLAG_LEAD_PLACE | DSFLAG_FOLLOW_CROSS | DSFLAG_ID_OPTIONAL);
  }

  @Override
  public String getFilter() {
    return "CAD@haywoodnc.net";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("CAD:")) return false;
    body = body.substring(4).trim();
    return super.parseMsg(body, data);
  }
  
  private static String[] CITY_LIST = new String[]{
    "CANTON",
    "CLYDE",
    "LAKE JUNALUSKA",
    "MAGGIE VALLEY",
    "WAYNESVILLE",
    "WEST CANTON"
  };
  
}