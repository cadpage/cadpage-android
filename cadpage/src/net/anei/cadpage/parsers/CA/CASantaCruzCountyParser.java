package net.anei.cadpage.parsers.CA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;

/**
 * Warren County, OH
 */
public class CASantaCruzCountyParser extends DispatchPrintrakParser {
  
  private static final Pattern CITY_AREA_PTN = Pattern.compile("BIG REDWOOD PRK|MISSION SPRINGS|PASATIEMPO|ZAYANTE|.* AREA?|.* AR|.* BYPASS|.* CORR?IDOR");
  
  public CASantaCruzCountyParser() {
    super("SANTA CRUZ COUNTY", "CA");
  }
  
  @Override
  public String getFilter() {
    return "SCR911_CAD@scr911.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
 
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    data.strSource = "";
    
    // Place sometimes duplicates address
    if (data.strPlace.equals(data.strAddress)) data.strPlace = "";
    
    // And there are a lot of city names that describe broad areas rather than 
    // something Google recognizes.  If this looks like one, move it to place
    // field.
    if (CITY_AREA_PTN.matcher(data.strCity).matches()) {
      data.strPlace = append(data.strPlace, " - ", data.strCity);
      data.strCity = "";
    }
    
    // And some just plain wrong city names
    else if (data.strCity.equals("AP/LA SELVA")) data.strCity = "APTOS";
    
    return true;
  }
}
