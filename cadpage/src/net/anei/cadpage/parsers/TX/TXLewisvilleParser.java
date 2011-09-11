package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/* 
Lewisville, TX (in Denton County)
Contact: Curtis Birt <cbirt@cityofcorinth.com>
Sender: 6245,lpd@[10.10.1.64]

*101 E CORPORATE DR*****MAJOR ACC****B160,CHIEF,E163,M163,T167*316****
*1725 SHUFORDS CT*****FIRE****B160,CHIEF,E164,E165,M163,Q163,T167*300****
*251 N I35E SBFR*****FIRE****B160,CHIEF,E161,E164,M161,Q162,T167*127****
SMALL FIRE COMING FROM THE STOVE
*4900 BLAIR OAKS DR*****MA FILL-IN****CHIEF,E166*947****
11072508*1077 N GARDEN RIDGE BLVD*****FIRE****B160,CHIEF,E163,E164,M163,Q162,T167

*/

public class TXLewisvilleParser extends FieldProgramParser {
  
  public TXLewisvilleParser() {
    super("LEWISVILLE", "TX",
        "ID ADDR CALL UNIT");
  }
  
  public String getFilter() {
    return "6245,lpd@[10.10.1.64]";
  }
  
  public boolean parseMsg(String body, Data data) {
    String[] flds = body.split("\\*+");
    if (flds.length < 4) return false;
    return parseFields(flds, data);
  }
}
