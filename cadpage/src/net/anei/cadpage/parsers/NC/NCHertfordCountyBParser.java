
package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

public class NCHertfordCountyBParser extends DispatchSouthernParser {

  public NCHertfordCountyBParser() {
    super(CITY_LIST, "HERTFORD COUNTY", "NC", 0);
    setupCallList(CALL_LIST);
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strAddress.startsWith("LANDING ZONE ")) {
      data.strPlace = append("LANDING ZONE", " - ", data.strPlace);
      data.strAddress = data.strAddress.substring(13).trim();
    }
    data.strAddress = stripSector(data.strAddress, data);
    data.strApt = stripSector(data.strApt, data);
    if (data.strCity.equalsIgnoreCase("AHOSIE")) data.strCity = "AHOSKIE";
    return true;
  }
  
  private static String stripSector(String field, Data data) {
    if (data.strMap.length() > 0) return field;
    int pt = field.indexOf(" - ");
    if (pt >= 0) {
      data.strMap = field.substring(pt+3).trim();
      return field.substring(0,pt).trim();
    }
    if (field.startsWith("- ")) {
      data.strMap = field.substring(2).trim();
      return "";
    }
    return field;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY", "MAP CITY");
  }
  
  @Override
  public String adjustMapCity(String city) {
    if (city.equalsIgnoreCase("UNION")) return "AHOSKIE";
    return city;
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "050 ACCIDENT",
      "077 FIRE CALL",
      "078 ALARM",
      "137 HELICOPTER",
      "EMS",
      "FIRE",
      "FIRE SMOKE ALARM"
  );

  private static final String[] CITY_LIST = new String[]{
    
    "AHOSKIE",
    "AHOSIE",   // Misspelled
      "ST JOHN",
      "UNION",
    "COFIELD",
    "COMO",
    "HARRELLSVILLE",
    "MILLENNIUM",
    "MURFREESBORO",
    "WINTON",
    
    // Bertie County
    "AULANDER",
    "COLERAIN",
    
    // Northampton County
    "WOODLAND"

  };
}
