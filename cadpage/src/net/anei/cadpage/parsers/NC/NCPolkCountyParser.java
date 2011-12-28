

package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/*
Polk County, NC
Contact: Charles Green <chuckgreen@windstream.net>
Sender: polkcounty911@polknc.org
System: Southern

polkcounty911:767 THERMAL VIEW DR TRYON SMITH 828817313307:38:26 FALL VICTIM 89 YO FEMALE FROM STORY RD TO SKYUKA RD
polkcounty911:1426 HAYES RD COLUMBUS 07:20:59 TREE DOWN CONTS FROM S PEAK ST TO PENIEL RD
polkcounty911:418 S PEAK ST COLUMBUS EARLY, DORIS 8288948807 13:09:13 MEDICAL EMERGEN 86 YO VERY WEAK FROM E MILLS ST AND CONTS AS HAYES RD
polkcounty911:429 LOCKHART RD TRYON RHONDA 828859020509:57:24 MEDICAL EMERGEN 38 YO LEFT LEG PAINNUMB FOOT FROM W HOWARD ST TO LANIER LN
polkcounty911:86 GREENVILLE ST SALUDA PAT 8287494411 13:49:40 CHOKING FEMALE CHOKING FOR PAST HOUR//PALE
polkcounty911:159 LANIER DR COLUMBUS John 8643030507 08:08:08 UNCONSCIOUS 75 yo man with cancer.
polkcounty911:1 GREEN RIVER COVE RD mill spring carol 8288179441 09:52:03 DOWN POWER LINE FROM S NC 9 HWY TO RUTHERFORD CO LINE
Polkcounty911:1733 E US 74 HWY before pea ridge rd MILL SPRING 423637001121:49:01 10-50. June 9, 9:48 PM
polkcounty911:26 KELLY LN MILL SPRING 8288948141 16:50:54 SEIZURES 25 Y/O MALE SEIZING FROM CHIMNEY ROCK RD TO DEAD END. June 10 4:50 PM.
polkcounty911:935 POLK COUNTY LINE RD RUTHERFORDTON BAILY, PHILLIP 8287489222 14:23:05 VEHICLE FIRE 18 WHEELER LOADED WITH LUMBER ON FIRE FROM ROCK SPRINGS. June 11, 2:21 PM.
polkcounty911:4861 E NC 108 HWY MILL SPRING SLIMPLEX GRENELL 888746753911:28:38 FIRE ALARM BUILDING ONE FROM HOUSTON RD/WALKER ST TO RUTHERFORD CO LINE. June 14, 11:29 AM.
polkcounty911:620 BURT BLACKWELL RD MILL SPRING QUANDT, LEONARD & CRYSTAL 8288946023 13:27:52 SMOKE COMPLAINT ACROSS FROM THE ABOVE ADDRESS NEAR DUKE POWER. June 15, 1:28 PM
polkcounty911:1 COLUMBUS FIRE DEPT 2201 17:54:26 STANDBY REQUEST MSFD STANDBY FOR THEM REF RESOURCES DEPLETED. June 18, 5:55 PM
polkcounty911:1 GREEN RIVER COVE RD mill spring carol 8288179441 09:52:03 DOWN POWER LINE FROM S NC 9 HWY TO RUTHERFORD CO LINE. June 19 9:53 AM.

*/

public class NCPolkCountyParser extends DispatchSouthernParser {
  
  private static final String[] CITY_LIST = new String[]{
    "COLUMBUS",
    "MILL SPRING",
    "RUTHERFORDTON",
    "SALUDA",
    "TRYON"
  };
  
  private static final Pattern ID_TIME_PTN = Pattern.compile("\\b(\\d{10})(\\d\\d:\\d\\d:\\d\\d)\\b");

  public NCPolkCountyParser() {
    super(CITY_LIST, "POLK COUNTY", "NC", DSFLAG_DISPATCH_ID | DSFLAG_ID_OPTIONAL);
  }
  
  @Override
  public String getFilter() {
    return "polkcounty911@polknc.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    // Sometimes an ID and time run together, in which case we need to split them apart
    Matcher match = ID_TIME_PTN.matcher(body);
    if (match.find()) {
      body = body.substring(0, match.end(1)) + " " + body.substring(match.start(2));
    }
    if (!super.parseMsg(body, data)) return false;
    
    int pt = data.strAddress.toLowerCase().indexOf(" before ");
    if (pt >= 0) {
      data.strCross = data.strAddress.substring(pt+8).trim();
      data.strAddress = data.strAddress.substring(0,pt).trim();
    }
    
    // Fix some after market additions
    data.strName = data.strPlace;
    data.strPlace = "";
    
    Parser p = new Parser(data.strSupp);
    p.getLastOptional(". ");
    data.strCross = append(data.strCross, " / ", p.getLastOptional(" FROM "));
    data.strSupp = p.get();
    return true;
  }
  

}
