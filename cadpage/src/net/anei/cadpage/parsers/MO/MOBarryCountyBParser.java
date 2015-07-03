package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA48Parser;

/**
 * Barry County, MO (B)
 */
public class MOBarryCountyBParser extends DispatchA48Parser {
  
  public MOBarryCountyBParser() {
    super(MOBarryCountyParser.CITY_LIST, "BARRY COUNTY", "MO", FieldType.DATE_TIME_INFO, A48_ONE_WORD_CODE);
    setupGpsLookupTable(MOBarryCountyParser.GPS_LOOKUP_TABLE);
  }
  
  @Override
  protected String adjustGpsLookupAddress(String address, String apt) {
    return MOBarryCountyParser.fixGpsLookupAddress(address, apt);
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    if (data.strCity.equalsIgnoreCase("COUNTY")) data.strCity = "BARRY COUNTY";
    return true;
  }
}
