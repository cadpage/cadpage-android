package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;


public class OHMahoningCountyParser extends DispatchEmergitechParser {
  
  public OHMahoningCountyParser() {
    super("", null, CITY_LIST, "MAHONING COUNTY", "OH");
    setupMultiWordStreets("COLUMBIANA CANFIELD");
  }

  @Override
  public String getFilter() {
    return "anoble@ci.canfield.oh.us";
  }
  
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) subject = "666";
    if (!body.startsWith("- ")) body = "- " + body;
    body = '[' + subject + "]" + body;
    if (!super.parseMsg(body,  data)) return false;
    data.strUnit = "";
    return true;
  }

  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "ALLIANCE",
    "CAMPBELL",
    "CANFIELD",
    "COLUMBIANA",
    "SALEM",
    "STRUTHERS",
    "YOUNGSTOWN",

    // Villages
    "BELOIT",
    "CRAIG BEACH",
    "LOWELLVILLE",
    "NEW MIDDLETOWN",
    "POLAND",
    "SEBRING",
    "WASHINGTONVILLE",

    // Townships
    "AUSTINTOWN TWP",
    "BEAVER TWP",
    "BERLIN TWP",
    "BOARDMAN TWP",
    "CANFIELD TWP",
    "COITSVILLE TWP",
    "ELLSWORTH TWP",
    "GOSHEN TWP",
    "GREEN TWP",
    "JACKSON TWP",
    "MILTON TWP",
    "POLAND TWP",
    "SMITH TWP",
    "SPRINGFIELD TWP",

    // Census-designated places
    "AUSTINTOWN",
    "BOARDMAN",
    "MAPLE RIDGE",
    "MINERAL RIDGE",
  
    //Other communities
    "DAMASCUS",
    "ELLSWORTH",
    "GREENFORD",
    "LAKE MILTON",
    "NEW SPRINGFIELD",
    "NORTH BENTON",
    "NORTH JACKSON",
    "NORTH LIMA",
    "PETERSBURG",

  };
}
