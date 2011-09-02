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


Contact: Giz <passig5312@hotmail.com>
(Page ) rural fire...23090 gale rd female with chest pain
(Page ) 328 avondale blvd; 16 yom passed out earlier today, cant talk now... go in side door...smb
(Page ) Attn Rural Fire...27767 Hwy 50 E.... 89 yof passed out...rach
(Page ) RURAL  75 yof breathing diff  1130 WAGO DR
(Page ) attn pueblo rural fire 27025 tourchey way female dizzy and not feeling good
(Page ) 31918 hwy 96 e; loaf & jug; fem dizzy; almost fainted...tdb

Contact: Willie Martin <willismart84@gmail.com>
Sender: surepage@wdsl.us
(Page ) 2027 zinno blvd; medical alarm on 71 yof c/o diff breathing. fem has copd and on oxygen. kcq

*/


public class COPuebloCountyParser extends SmartAddressParser {
  
  private static final Pattern TIME_MARK = Pattern.compile("^\\d\\d:\\d\\d[A-Z][A-Z] \\d\\d/\\d\\d ");
  private static final Pattern DELIM = Pattern.compile(" *(?:\\.{2,}|;) *");
    
  public COPuebloCountyParser() {
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
    if (match.find()) body = body.substring(match.end()).trim();
    
    String[] flds = DELIM.split(body);
    int fldCnt = flds.length;
    if (flds[fldCnt-1].length() <= 4) fldCnt--;
    if (fldCnt == 0) return false;
    
    for (int ndx = 0; ndx < fldCnt; ndx++) {
      String fld = flds[ndx];
      if (data.strAddress.length() == 0) {
        if (data.strCall.length() == 0) {
          parseAddress(StartType.START_CALL, fld, data);
        } else {
          parseAddress(StartType.START_ADDR, fld, data);
        }
        data.strSupp = getLeft();
      }
      
      else {
        data.strSupp = append(data.strSupp, " / ", fld);
      }
    }
    return true;
  }
}
