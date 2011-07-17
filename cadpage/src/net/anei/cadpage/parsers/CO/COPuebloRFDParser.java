package net.anei.cadpage.parsers.CO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Pueblo RFD, CO
Contact: Steven Passig <giz5312@gmail.com>
Sender: surepage@wdsl.us
System: Spillman mobile
(Page ) 12:43PM 11/28 RURAL FIRE in the area of 1543 Cooper Pl report of heavy smoke no flames showing...kr
(Page ) 04:26PM 12/13 rural fire:  hwy 50 & 27th ln; north side, 10 ft fire...tdb
(Page ) 04:52PM 11/27 ATTN RURAL FIRE: 28141 south rd....male poss overdose...jaa
(Page ) 09:18AM 12/11 rural fire  33550 hwy 96 E Lot 379 35 yof convulsions
(Page ) 11:45PM 11/15 ATTN RURAL FIRE: 1917 n santa fe ave...at the car wash....39yof...seizure...jaa


Not supported yet!
Contact: Giz <passig5312@hotmail.com>
(Page ) rural fire...23090 gale rd female with chest pain


*/


public class COPuebloRFDParser extends SmartAddressParser {
  
  private static final Pattern TIME_MARK = Pattern.compile("^\\d\\d:\\d\\d[A-Z][A-Z] \\d\\d/\\d\\d ");
  private static final Pattern DELIM = Pattern.compile(" *\\.{2,} *");
    
  public COPuebloRFDParser() {
    super("PUEBLO COUNTY", "CO");
  }
  
  @Override
  public String getFilter() {
    return "surepage@wdsl.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    if (!subject.equals("Page")) return false;
    Matcher match = TIME_MARK.matcher(body);
    if (! match.find()) return false;
    body = body.substring(match.end()).trim().replaceAll(";", "");
    
    String[] flds = DELIM.split(body);
    int fldCnt = flds.length;
    if (flds[fldCnt-1].length() <= 3) fldCnt--;
    if (fldCnt == 0) return false;
    
    
    parseAddress(StartType.START_CALL, flds[0], data);
    data.strSupp = getLeft();
    
    for (int jj = 1; jj<fldCnt; jj++) {
      if (data.strSupp.length() > 0) data.strSupp += " / ";
      data.strSupp += flds[jj];
    }

    return true;
  }
}
