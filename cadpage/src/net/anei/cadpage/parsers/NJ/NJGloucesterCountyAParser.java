package net.anei.cadpage.parsers.NJ;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProphoenixParser;

/**
 * Gloucester County, NJ (version A)
 */
public class NJGloucesterCountyAParser extends DispatchProphoenixParser {
  
  public NJGloucesterCountyAParser() {
    super(CITY_CODES, "GLOUCESTER COUNTY", "NJ");
  }
 
  @Override
  public String getFilter() {
    return "gccad@co.gloucester.nj.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equals("ROWAN")) {
      data.strPlace = data.strCity;
      data.strCity = "GLASSBORO";
    }
    return true;
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "A", "CLAYTON",
      "B", "DEPTFORD",
      "C", "EAST GREENWICH TWP",
      "D", "ELK TWP",
      "E", "FRANKLIN TWP",
      "F", "GLASSBORO",
      "G", "GIBBSTOWN",
      "H", "HARRISON TWP",
      "I", "LOGAN TWP",
      "J", "MANTUA TWP",
      "K", "MONROE TWP ",
      "L", "NATIONAL PARK",
      "M", "NEWFIELD",
      "N", "PAULSBORO",
      "O", "PITMAN",
      "P", "SOUTH HARRISON TWP",
      "Q", "SWEDESBORO",
      "R", "WASHINGTON TWP",
      "S", "WENONAH",
      "T", "WEST DEPTFORD TWP",
      "U", "WESTVILLE BORO",
      "V", "WOODBURY CITY",
      "Y", "ROWAN"
  });
}
