package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA47Parser;


public class IAJasperCountyParser extends DispatchA47Parser {
  
  public IAJasperCountyParser() {
    super("Dispatch Info", CITY_LIST, "JASPER COUNTY", "IA");
  }
  
  @Override
  public String getFilter() {
    return "jasper911";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    if (data.strPlace.startsWith("R") && data.strPlace.substring(1).equals(data.strAddress)) data.strPlace = "";
    return true;
  }

  private static final String[] CITY_LIST =new String[]{
    // Cities
    "BAXTER",
    "COLFAX",
    "KELLOGG",
    "LAMBS GROVE",
    "LYNNVILLE",
    "MINGO",
    "MITCHELLVILLE",
    "MONROE",
    "NEWTON",
    "OAKLAND ACRES",
    "PRAIRIE CITY",
    "REASNOR",
    "SULLY",
    "VALERIA",

    // Unincorporated communities
    "IRA",
    "KILLDUFF",
    "RUSHVILLE"
  };
}
