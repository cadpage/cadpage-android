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
(CAD Call) 2010098333\nSUSPICIOUS CIRCUMSTANCES\nDOLLAR GENERAL (MOREHEAD AVE)\n390 MOREHEAD AVE RIDGEWAY\nWHT MALE, DARK SHIRT
*/

public class VAHenryCountyParser extends SmsMsgParser {
  
  private static final MatchList cityList = 
    new MatchList(new String[]
      {"RIDGEWAY", "MARTINSVILLE", "SPENCER", "BASSETT", "COLLINSVILLE", "FIELDALE", "AXTON"}); 

  @Override
  public boolean isPageMsg(String body) {
    return body.startsWith("(CAD Call)");
  }

  @Override
  protected void parse(String body, Data data) {
    Log.v("DecodeHenryCountyPage: Message Body of:" + body);
    data.defState="VA";
    data.defCity="HENRY COUNTY";

    String addressLine = null;
    int ndx = 0;
    for (String line : body.split("\n")) {
      line = line.trim();
      ndx++;
      
      // First line always contains call ID
      if (ndx == 1) {
        if (line.startsWith("(CAD Call)")) line = line.substring(10);
        data.strCallId = line.trim();
      }
      
      else {
        
        // Beyond that, an address line can occur anywhere, so we always
        // have to check it.  Address line identified when last token matches
        // one of our cities, and is always the last thing we process
        int pt = line.lastIndexOf(' ');
        if (pt >= 0) {
          String token = line.substring(pt+1);
          if (cityList.contains(token)) {
            line = stripAddressName(line.substring(0, pt));
            parseAddress(line, data);
            data.strCity = token;
            break;
          }
        }
        
        // If not address line, line 2 contains the unit and call description
        if (ndx == 2) {
          pt = line.indexOf(' ');
          if (pt >= 0) {
            String tmp = line.substring(0, pt);
            if (tmp.contains("-(")) {
              data.strUnit = tmp.trim();
              line = line.substring(pt);
            }
          }
          data.strCall = line.trim();
        }
        
        // Line 3 contains the tentative address line we will use if we don't
        // find a real address line
        else if (ndx == 3) {
          addressLine = line;
        }
      }
    }
    
    // If we didn't find a definitive address line, parse the tentative address line
    if (data.strCity.length() == 0 && addressLine != null) {
      parseAddress(stripAddressName(addressLine), data);
    }
  }
}
