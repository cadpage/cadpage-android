package net.anei.cadpage.parsers.MO;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchGlobalDispatchParser;



public class MOGasconadeCountyParser extends DispatchGlobalDispatchParser {
  
  private static final String[] CITY_TABLE = new String[]{
    "BLAND",
    "BELLE",
    "GASCONADE",
    "HERMANN",
    "MORRISON",
    "MT STERLING",
    "OWENSVILLE",
    "ROSEBUD",
    "GASCONADE COUNTY",
    "OUT OF COUNTY"
  };
  
  private static final Pattern UNIT_PTN = Pattern.compile("(?:[GOM]|MT)?\\d{3}");
  
  public MOGasconadeCountyParser() {
    super(CITY_TABLE, "", "MO", null, UNIT_PTN);
  }
  
  @Override
  public String getFilter() {
    return "central@fidmail.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (body.startsWith("MESSAGE / ")) body = body.substring(10).trim();
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equals("GASCONADE COUNTY")) data.strCity = "";
    return true;
  }
}
