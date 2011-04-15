package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Anne Arundel County, MD (EMS)
Contact: Michael Brown <mike.a.brown09@gmail.com>
Sender: fd500942@aacounty.org

*Medical Box 28-8 1496 ANNAPOLIS RD  [BLOCKBUSTER VIDEO] 12-F1 E281,MU29 MVC; 2306 [14/81]  /lm-33/
*MEDICAL Box 28-13 TELEGRAPH RD/JACKSON GROVE RD 6-K13 E283,MU4 FAINTING; 1328 [9/90]  14m-2
Medical Box 34-5 7390 BALTO ANNAP BLVD  [MTA LIGHT RAIL CROMWELL] 7-J1 TK33,MU21,A28 ABDOM PAIN; 1256 [8/89]
*MEDICAL Box 5-22 1325 GREYSWOOD RD (CHAPELVIEW DR) 12-H6 E283,MU6 BREATHING PROB; 1145 [7/88]  22d-20
*Medical Box 28-8 1496 ANNAPOLIS RD  [BLOCKBUSTER VIDEO] 12-F1 E281,MU29 MVC; 2306 [14/81]  lm-33
*Medical Box 28-27 PINEY ORCHARD PKWY/RIVERSCAPE RD 12-E7 E281,PM26 MVC; 1415 [6/91]  lm-8
MEDICAL Box 28-27 RIVERSCAPE RD/RUNNING WOLF TRL 12-F8 E283,MU21 CHEST PAIN; 2010 [13/78]
Local Box 28-27 2615 LOTUSWOOD CT (RIVERSCAPE RD) 12-E7 E283 SERVICE CALL (COLD); 1740 [9/293]
*MEDICAL Box 28-27 8718 THORNBROOK DR (RIVERSCAPE RD) 12-E7 E281,MU6 HEADACHE; BURNING INSIDE  2001 [15/297]  41m-1
*MEDICAL Box 28-27 8700 NATURES TRAIL CT  [Unit 304] (RIVERSCAPE RD) 12-E8 A28,PM5 BREATHING PROB; 0524 [4/313]  6m-5
*Medical Box 28-6 2012 BEALMEAR MILL LN  [Unit 7208] (COWMAN CT) 12-G1 E281,MU29 BACK PAIN; 0539 [1/68]  25d-2

*/

public class MDAnneArundelCountyEMSParser extends SmsMsgParser {
  
  private static final Pattern MASTER_PTN =
    Pattern.compile("\\*?(?:Medical|MEDICAL|Local) Box (\\d{1,2}-\\d{1,2}) +(.+?) +(?:\\[(.*)\\] *)?(?:\\((.*)\\) *)?(\\d{1,2}-[A-Z]\\d{1,2}) ([^ ]+) (.*) \\d{4} .*");

  public MDAnneArundelCountyEMSParser() {
    super("ANNE ARUNDEL COUNTY", "MD");
  }
  
  @Override
  public String getFilter() {
    return "fd500942@aacounty.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strBox = match.group(1);
    parseAddress(match.group(2).trim(), data);
    data.strPlace = null2Empty(match.group(3));
    data.strCross = null2Empty(match.group(4));
    data.strMap = match.group(5);
    data.strUnit = match.group(6);
    data.strCall = match.group(7).trim().replace(";", "");
    
    return true;
  }
  
  private static String null2Empty(String str) {
    return (str == null ? "" : str.trim());
  }

}
