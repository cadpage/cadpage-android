package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchShieldwareParser;



public class VAWinchesterParser extends DispatchShieldwareParser {
    
  
  public VAWinchesterParser() {
    super(CITY_LIST, "WINCHESTER", "VA");
  }
  
  @Override
  public String getFilter() {
    return "winecc@ci.winchester.va.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.equals("Winchester ECC info")) return false;
    if (!super.parseMsg(body, data)) return false;
    if (data.strPlace.endsWith(" RESIDENCE")) {
      data.strName = data.strPlace.substring(0,data.strPlace.length()-10).trim();
      data.strPlace = "";
    }
    if (data.strCity.endsWith(" CO")) data.strCity += "UNTY";
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("PLACE", "NAME PLACE");
  }
  
  private static final String[] CITY_LIST = new String[]{
    "FREDERICK CO",
    "WINCHESTER"
  };
}
