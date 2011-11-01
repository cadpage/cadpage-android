package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/*
Henry County, VA
Contact: Hamp Ingram <emt.basics@gmail.com>
Sender: MHC911@co.henry.va.us

480 LEWIS RD MARTINSVILLE 2011095252 12:30:03 RFA-(3) FALL - FRACTURE
2900 DILLONS FORK RD FIELDALE 2011095631 08:16:38 ROV-(2) OVERDOSE
2487 SPRUCE ST MARTINSVILLE 2011095614 06:57:08 RFA-(3) FALL - FRACTURE
1890 DANIELS CREEK RD COLLINSVILLE 2011095584 22:15:45 RSI-(2) SICK
2630 VIRGINIA AVE COLLINSVILLE 2011095480 11:35:03 RDZ-(3) DIZZINESS, WEAKNESS
1385 WINGFIELD ORCHARD RD MARTINSVILLE 2011095447 07:31:58 R3-(1) CHEST PAINS

Contact: Bob Phillips <bobphillips2685@gmail.com>
904 MOUNTAIN RD 11 MARTINSVILLE 2011097764 21:12:40 R3-(1) CHEST PAINS

*/

public class VAHenryCountyParser extends DispatchSouthernParser {
  
  private static final String[] CITY_LIST = new String[]
     {"RIDGEWAY", "MARTINSVILLE", "SPENCER", "BASSETT", "COLLINSVILLE", "FIELDALE", "AXTON"}; 
  
  public VAHenryCountyParser() {
    super(CITY_LIST, "HENRY COUNTY", "VA", DSFLAG_UNIT);
  }

  @Override
  public String getFilter() {
    return "MHC911@co.henry.va.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    // Dispatch - Google spat
    data.strAddress = data.strAddress.replace("WILLIAM F STONE PARK ", "WILLIAM F STONE ");
    return true;
  }
}
