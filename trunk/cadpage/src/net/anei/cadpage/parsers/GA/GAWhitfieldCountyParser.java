package net.anei.cadpage.parsers.GA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Whitefield County, GA
Contact: Mike Cady <mikecadyga@gmail.com>
Sender: 7064632252

WHITFIELD CO. 911:F12 SF-COMMERCIAL/INDUSTRIAL/SCHOO 1812 KIMBERLY PARK DR 4237188927 ALARM ASSIGN 3
WHITFIELD CO. 911:50I M.V. ACCIDENT W/INJURIES I 75 SB MM 333 6789341809
WHITFIELD CO. 911:F15 FIRE ALARM 1220 BROADRICK DR 7062758899 ALARM ASSIGN 1-3
WHITFIELD CO. 911:F15 FIRE ALARM 511 CALLAHAN RD SE 7062776288 ALARM ASSIGN 2
WHITFIELD CO. 911:F15 FIRE ALARM 1104 WILLOWDALE RD NW 7062758665 ALARM ASSIGN 3
WHITFIELD CO. 911:50I M.V. ACCIDENT W/INJURIES ANTIOCH / BEAR CREEK 7064284979
WHITFIELD CO. 911:50I M.V. ACCIDENT W/INJURIES 2125 ANTIOCH RD 7066187892 4,8,5,3,1,7,9,2,6,10
WHITFIELD CO. 911:50I M.V. ACCIDENT W/INJURIES 75 SB @ N OF 339 7063174144
WHITFIELD CO. 911:50I M.V. ACCIDENT W/INJURIES WARING AT RRX 7062598533 1,2,3,7,10,8,6,9,4,5
WHITFIELD CO. 911:50I M.V. ACCIDENT W/INJURIES RAYBURN SR @ BOWERS RD 7064838978
WHITFIELD CO. 911:F15 FIRE ALARM 1500 MANLEY ST 7062788757 ALARM ASSIGN 1-3

*/

public class GAWhitfieldCountyParser extends SmartAddressParser {
  
  private static final String[] CALL_LIST = new String[]{
    "50I M.V. ACCIDENT W/INJURIES ",
    "F12 SF-COMMERCIAL/INDUSTRIAL/SCHOO ",
    "F15 FIRE ALARM "
  };
  
  private static final Pattern PHONE_PTN = Pattern.compile("\\b\\d{10}\\b");
  
  public GAWhitfieldCountyParser() {
    super("WHITFIELD COUNTY", "GA");
  }
  
  @Override
  public String getFilter() {
    return "7064632252";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!body.startsWith("WHITFIELD CO. 911:")) return false;
    body = body.substring(18).trim();
    
    data.strCall = "";
    for (String call : CALL_LIST) {
      if (body.startsWith(call)) {
        data.strCall = call.trim();
        body = body.substring(call.length());
        break;
      }
    }
    Matcher match = PHONE_PTN.matcher(body);
    if (match.find()) {
      data.strPhone = match.group();
      String sAddr = body.substring(0,match.start()).trim();
      sAddr = sAddr.replace('@', '&');
      if (data.strCall.length() != 0) {
        parseAddress(sAddr, data);
      } else {
        parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, sAddr, data);
        data.strPhone = match.group();
      }
      data.strSupp = body.substring(match.end()).trim();
    } else {
      StartType startType = data.strCall.length() == 0 ? StartType.START_ADDR : StartType.START_CALL;
      parseAddress(startType, body, data);
      data.strSupp = getLeft();
    }
    
    return true;
  }

}
