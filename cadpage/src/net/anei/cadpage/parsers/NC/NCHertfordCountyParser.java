package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernPlusParser;
/**
 * Hertford County, NC
 */
public class NCHertfordCountyParser extends DispatchSouthernPlusParser {
  
  public NCHertfordCountyParser() {
    super(CITY_LIST, "HERTFORD COUNTY", "NC", DSFLAG_DISPATCH_ID | DSFLAG_LEAD_PLACE);
  }
  
  @Override
  public String getFilter() {
    return "@hertfordcountync.gov";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    
    // Look for sector in address or apt fields
    data.strAddress = stripSector(data.strAddress, data);
    data.strApt = stripSector(data.strApt, data);
    return true;
  }
  
  private static String stripSector(String field, Data data) {
    if (data.strMap.length() > 0) return field;
    int pt = field.indexOf(" - ");
    if (pt >= 0) {
      data.strMap = field.substring(pt+3).trim();
      field = field.substring(0,pt).trim();
    }
    
    if (data.strCity.equals("UNION")) {
      data.strPlace = append(data.strPlace, " - ", data.strCity);
      data.strCity = "AHOSKIE";
    }
    return field;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY", "MAP CITY");
  }

  @Override
  protected void parseExtra(String sExtra, Data data) {
    data.strCall = sExtra;
  }

  private static final String[] CITY_LIST = new String[]{
    "AHOSKIE",
      "ST JOHN",
      "UNION",
    "COFIELD",
    "COMO",
    "HARRELLSVILLE",
    "MURFREESBORO",
    "WINTON",
    
    // Bertie County
    "COLERAIN",
    
    // Northampton County
    "WOODLAND"
  };

}
