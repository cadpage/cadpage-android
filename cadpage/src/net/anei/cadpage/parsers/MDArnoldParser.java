package net.anei.cadpage.parsers;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


import net.anei.cadpage.SmsMsgInfo.Data;

/* Sample Arnold Pages.
 * 
 * *MEDICAL Box 17-7 1236 JONES STATION RD  [MT CALVARY UNITED METH CHURCH] E171,PM17 TASER PATIENT; 1145 [1/49]  /4m-5/ 
Box Alarm 12-19 540 BENFIELD RD (CENTER DR) Echo E12,QNT30,E18,E171,QNT23,TK26,SQ23,PM12,BC2,SCA ODOR GAS IN STRUCTURE (HOT); 1351 [2/50]
Local Alarm 17-12 24 CASCADE RD (GRANDVIEW RD) E171 ALARMS/NON HIGH LIFE (HOT); 1705 [3/51] 
*MEDICAL BOX 23-5 831 RITCHIE HWY N  [Unit 307A]  [KRIS LEIGH CATERED LIVING] QNT23,PM17,TRO CARDIAC ARREST; 0548 [2/42]  /2d-96/
*MEDICAL Box 23-12 1244 RITCHIE HWY S  [Unit 18]  [SEVERN COMMERCE CENTER] QNT23,PM17 STROKE; 0921 [3/43]  /lm-2/ 
*Medical Box 40-83 RT50 W/JENNIFER RD MU40,E40,E171 MVC; 1517 [4/44]  /18d-19/ 
Box Alarm 23-15 812 WINDSOR RD (FOREST LN) Echo QNT23,E171,E19,TW40,QNT30,SQ23,PM17,BC2,SCA STRUCTURE/BARN/GARAGE (HOT); 1607 [5/45] 
MEDICAL Box 19-5 1604 ORCHARD WAY (HARMONY ACRES LN) E172,MU39 STROKE; 1643 [6/46] 
MEDICAL Box 40-26 1724 VINEYARD TRL (RAMSHORN TRL) TW40,PM17 SEIZURES; 0035 [1/41]

 */

public class MDArnoldParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "MD";
  private static final String DEF_CITY = "Arnold";
  
  public MDArnoldParser() {
    super(DEF_STATE);
  }

  @Override
  public boolean isPageMsg(String body) {
    body = body.toUpperCase();
    return body.contains("BOX");
  }

  @Override
  protected void parse(String body, Data data) {

    data.defState=DEF_STATE;
    data.defCity=DEF_CITY;
    String sBox = body;
    Pattern BOX = Pattern.compile("\\s\\d\\d-[a-zA-Z0-9][a-zA-Z0-9]\\s");
    Matcher match = BOX.matcher(sBox);
    if (match.find()) {
      sBox = sBox.substring(match.start(),match.end());
      data.strCall = body.substring(match.start());
    }
    data.strBox = sBox;
    // Delete after ;
    int ipt = body.indexOf(';');
    if (ipt >= 0) body = body.substring(0,ipt).trim();
   // Properties props = parseMessage(body, new String[]{"CALL","CITY"});
    // Now try to find call description and address
    parseAddress(StartType.START_CALL,  body, data);
    body = getLeft();
    if (body.startsWith("(")) { body = body.substring(body.indexOf(")")+1); }
    body = body.trim();
    int indx = body.indexOf(" ");
    if (indx > 0) {
      data.strUnit = body.substring(0,indx);
      data.strSupp = body.substring(indx);
    } else {
    data.strSupp = body;
    }
  }
}
