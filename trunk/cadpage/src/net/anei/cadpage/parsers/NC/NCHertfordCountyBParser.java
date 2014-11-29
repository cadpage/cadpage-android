
package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

public class NCHertfordCountyBParser extends DispatchSouthernParser {

  public NCHertfordCountyBParser() {
    super(CITY_LIST, "HERTFORD COUNTY", "NC", DSFLAG_UNIT);
  }
  
  @Override
  public String getFilter() {
    return "chiltonal911@gmail.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strAddress.startsWith("LANDING ZONE ")) {
      data.strPlace = append("LANDING ZONE", " - ", data.strPlace);
      data.strAddress = data.strAddress.substring(13).trim();
    }
    if (data.strApt.startsWith("-")) {
      data.strMap = data.strApt.substring(2).trim();
      data.strApt = "";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("APT", "APT MAP");
  }

  private static final String[] CITY_LIST = new String[]{
    "AHOSKIE",
    "COFIELD",
    "COMO",
    "HARRELLSVILLE",
    "MURFREESBORO",
    "WINTON"
  };
}
