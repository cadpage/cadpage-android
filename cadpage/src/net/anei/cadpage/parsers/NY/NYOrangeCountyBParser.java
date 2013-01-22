package net.anei.cadpage.parsers.NY;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;



public class NYOrangeCountyBParser extends DispatchPrintrakParser {
  
  private static final Properties CITY_TABLE = buildCodeTable(new String[]{
  });
  
  public NYOrangeCountyBParser() {
    super(CITY_TABLE, "ORANGE COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "OC911@,messaging@iamresponding.com,@oc911.smartmsg.com";
  }
  
  @Override
  public int getMapFlags() {
    // Keep EXT markers
    return MAP_FLG_SUPPR_EXT;
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    body = cleanExtendedChars(body);
    if (!super.parseMsg(body, data)) return false;
    
    // Special handling for Ulster county calls
    if (data.strCity.length() == 0 && data.strName.equals("ULSTER 911")) {
      data.strCity = "ULSTER COUNTY";
    }
    
    // Drop village indicator
    if (data.strCity.endsWith(" V")) {
      data.strCity = data.strCity.substring(0, data.strCity.length()-2).trim();
    }
    return true;
  }
}
