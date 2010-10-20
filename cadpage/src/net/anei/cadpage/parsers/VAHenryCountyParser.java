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
    
    int ndx = 0;
    for (String line : body.split("\n")) {
      ndx++;
      switch (ndx) {
      
      case 1:
        if (line.startsWith("(CAD Call)")) line = line.substring(10);
        data.strCallId = line.trim();
        break;
        
      case 2:
        if (line.contains("RIDGEWAY") || line.contains("MARTINSVILLE")) {
          ndx++;
          // Fall through to case 3
        } else {
          int pt = line.indexOf(' ');
          if (pt >= 0) {
            String tmp = line.substring(0, pt);
            if (tmp.contains("-(")) {
              data.strUnit = tmp.trim();
              line = line.substring(pt);
            }
          }
          data.strCall = line.trim();
          break;
        }
        
      case 3:
        
        line = stripAddressName(line).trim();
        int pt = line.lastIndexOf(" ");
        if (pt >= 0) {
          data.strCity= line.substring(pt+1);
          line = line.substring(0, pt).trim();
        }
        parseAddress(line, data);
        break;
      }
    }
  }
}
