package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;


public class PATiogaCountyParser extends DispatchBParser {

  public PATiogaCountyParser() {
    super(CITY_LIST, "TIOGA COUNTY", "PA");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("TC911:");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.endsWith(" BORO")) {
      data.strCity = data.strCity.substring(0, data.strCity.length()-5).trim();
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BLOSSBURG BORO",
    "ELKLAND BORO",
    "KNOXVILLE BORO",
    "LAWRENCEVILLE BORO",
    "LIBERTY BORO",
    "MANSFIELD BORO",
    "ROSEVILLE BORO",
    "TIOGA BORO",
    "WELLSBORO BORO",
    "WESTFIELD BORO",

    "BLOSS TWP",
    "BROOKFIELD TWP",
    "CHARLESTON TWP",
    "CHATHAM TWP",
    "CLYMER TWP",
    "COVINGTON TWP",
    "DEERFIELD TWP",
    "DELMAR TWP",
    "DUNCAN TWP",
    "ELK TWP",
    "FARMINGTON TWP",
    "GAINES TWP",
    "HAMILTON TWP",
    "JACKSON TWP",
    "LAWRENCE TWP",
    "LIBERTY TWP",
    "MIDDLEBURY TWP",
    "MORRIS TWP",
    "NELSON TWP",
    "OSCEOLA TWP",
    "PUTNAM TWP",
    "RICHMOND TWP",
    "RUTLAND TWP",
    "SHIPPEN TWP",
    "SULLIVAN TWP",
    "TIOGA TWP",
    "UNION TWP",
    "WARD TWP",
    "WESTFIELD TWP"
  };
}
