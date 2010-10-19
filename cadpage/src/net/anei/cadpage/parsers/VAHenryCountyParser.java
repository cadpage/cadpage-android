package net.anei.cadpage.parsers;

import net.anei.cadpage.Log;
import net.anei.cadpage.SmsMsgInfo.Data;
/*
Henry County, VA (class I)
reporting email: Lieutenant Pruitt <rdvrs602@ridgewayrescue.com>
sender:  *@ridgewayrescue.com

(CAD Call) 2010094339\nR2-(1) DIFFICULTY BREATHING\n999 MORGAN FORD RD RIDGEWAY
(CAD Call) 2010094406\nRFA-(3) FALL / FRACTURE\n247 DEVONSHIRE DR RIDGEWAY\nALTERED MENTAL STATUS
(CAD Call) 2010094372\n1 LEE FORD CAMP RD RIDGEWAY\n@ 220 - TK & SUV
(CAD Call) 2010094604\nRSI-(2) SICK UNKNOWN MEDICAL\n 89 DAYLIGHT DR RIDGEWAY
(CAD Call) 2010095255\nMOTOR VEHICLE CRASH\nHENRY COUNTY PLYWOOD CO. 1580 PHOSPHO SPRINGS RD RIDGEWAY
(CAD Call) 2010095057\nRSI-(2) SICK UNKNOWN MEDICAL\n129 KIRK ST 4 MARTINSVILLE
(CAD Call) 2010095041\nMOTOR VEHICLE CRASH\n3 MARHILL DR RIDGEWAY
(CAD Call) 2010095011\nR2-(1) DIFFICULTY BREATHING\n999 MORGAN FORD RD RIDGEWAY
*/

public class VAHenryCountyParser extends SmsMsgParser {

  @Override
  public boolean isPageMsg(String body) {
    return body.startsWith("(CAD Call)");
  }

  @Override
  protected void parse(String body, Data data) {
    Log.v("DecodeHenryCountyPage: Message Body of:" + body);
    data.defState="VA";
    data.defCity="HENRY COUNTY";
    
    String[] lines = body.split("\n");
    String tmp = lines[0];
    if (tmp.startsWith("(CAD Call)")) tmp = tmp.substring(10);
    data.strCallId = tmp.trim();
    
    if (lines.length <= 1) return;
    tmp = lines[1];
    int pt = tmp.indexOf(' ');
    if (pt >= 0) {
      String tmp2 = tmp.substring(0, pt);
      if (tmp2.contains("-(")) {
        data.strUnit = tmp2.trim();
        tmp = tmp.substring(pt);
      }
    }
    data.strCall = tmp.trim();
    
    if (lines.length <= 2) return;
    tmp = lines[2].trim();
    pt = tmp.lastIndexOf(" ");
    if (pt >= 0) {
      data.strCity= tmp.substring(pt+1);
      tmp = tmp.substring(0, pt).trim();
    }
    parseAddress(tmp, data);
  }
}
