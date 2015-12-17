package net.anei.cadpage.parsers.WI;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA41Parser;

public class WIFondDuLacCountyParser extends DispatchA41Parser {

  public WIFondDuLacCountyParser() {
    super("CALLALERT:", CITY_CODES, "FOND DU LAC COUNTY", "WI", "F[AFPS]");
  }
  
  @Override
  public String getFilter() {
    return "cadmail@fdlco.wi.gov";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    data.strSource = data.strChannel;
    data.strChannel = "";
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CH", "SRC");
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "FDL", "FOND DU LAC",
  });
}
