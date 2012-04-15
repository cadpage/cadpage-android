package net.anei.cadpage.parsers.MO;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Jasper County, MO
Contact: "C. Virgin F. F. 452" <cjfpd452@yahoo.com>
Sender: @jasco.org
System: Integraph (changing to QSSI in August)

S: M:LONE ELM/ESTATE LN- ROLLOVER\n
S: M:1725B Redbud dr- 87 yom fall - back pain\n
S: M:VEHICLE FIRE FIR AND BLACK CAT\n
S: M:6653 PARK CIR APTD - 87 YOM FELL\n
S: M:3169 N MISSOURI 20 DAY OLD DIFF BREATING DELTA MBP 51C\n\n\n\n\n\n
S: M:302 KEENEY DR - CJ JUNIOR HIGH - POSSIBLE SEIZURE\n
S: M:25589 TABOR MAIN - DIFF BREATHING\n

*/

public class MOJasperCountyParser extends SmartAddressParser {
 
  public MOJasperCountyParser() {
    super("JASPER COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "@jasco.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Really aren't any definitive markers, so we have to county on something
    // else identifying this as a CAD page
    if (!isPositiveId()) return false;
    
    // Not much to go on.  a "- " separator marks an address and call description
    int pt = body.indexOf("- ");
    if (pt >= 0) {
      parseAddress(body.substring(0,pt).trim(), data);
      data.strCall = body.substring(pt+2).trim();
    }
    
    else {
      parseAddress(StartType.START_CALL, body, data);
      String tail = getLeft();
      if (data.strCall.length() == 0) {
        data.strCall = tail;
      } else {
        data.strSupp = tail;
      }
    }
    return true;
  }
}