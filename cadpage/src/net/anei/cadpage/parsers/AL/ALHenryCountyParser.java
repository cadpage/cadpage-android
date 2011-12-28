
package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Henry County, AL
Contact: Jarrod Dozier <captnjd5@gmail.com>
Sender: Janet.Toliver@comcast.net

MEDICAL EMERGENCY CO.RD. 405 @ CO.RD. 49 SOUTH OF 134 EAST FEMALE SUBJ FALLEN FROM HORSE... HAVING DIFFICULTY BREATHING
MEDICAL CALL 5526 CO. RD. 73 IN NEWVILLE 14 YO TOOK 15 TREDONE SUBJ. IS CONCIOUS AT THIS TIME.
FIRE ALARM ACTIVATION 506 HOLLY LANE SMOKE AND THERMAL HEAT DETECTOR DOES NOT ADV. SPECIFIC AREA INSIDE RESIDENCE.
MEDICAL EMERG. 707 MITCHELL ST. DIARRHEA, VOMITING, FEVER, HISTORY DIABETES, HEART PROBLEMS.
MEDICAL CALL 509 TERRACE DR. IN HEADLAND MALE PAT. DIFF. BREATHING FEEL AS IF HE IS ABOUT TO PASS OUT.,

*/


public class ALHenryCountyParser extends SmartAddressParser {

  public ALHenryCountyParser() {
    super("HENRY COUNTY", "AL");
    
    
  }
  @Override
  public String getFilter() {
    return "Janet.Toliver@comcast.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Highly promiscuous parser.  So we better make sure that the caller
    // has identified this as a dispatch page
    if (!isPositiveId()) return false;
    
    body = body.replace('@', '&').replace('.', ' ');
    parseAddress(StartType.START_CALL, FLAG_IGNORE_AT, body, data);
    data.strSupp = getLeft();
    Parser p = new Parser(data.strSupp);
    if (p.get(' ').equals("IN")) {
      data.strCity = p.get(' ');
      data.strSupp = p.get();
    }
    return data.strAddress.length() > 0;
  }
}
