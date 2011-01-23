package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.SmsMsgInfo.Data;
/*
Lancaster County, PA
Contact: Benjamin Herskowitz <bherskowitz@gmail.com>
Sender: 911@lcwc911.us
(VEH ACCIDENT-STANDBY) MANHEIM TWP~LITITZ PIKE / PETERSBURG RD~~ENG271,SQ27~20:19:57^
(VEH ACCIDENT-MASS TRANSIT-1A) MANHEIM TWP~2475 OREGON PIKE~WHITEMARSH DR~VALLEY RD~ENG271~08:13:50^
(SPILL CONTROL) EAST DONEGAL TWP~1158 RIVER RD~N BANK ST~ANDERSON FERRY RD~HAZ291~11:55:37^
(AUTO ALARM-HIGH OCCUPANCY) MANHEIM TWP~115 BLUE STREAK BLVD~SCHOOL RD~VALLEY RD~ENG271,ENG272~15:12:34^
(HAZ MAT INCIDENT-1A) LANC CITY~753 S PLUM ST~17 ALY~JUNIATA ST~HAZ291~08:19:13^

The Text in the parentheses is the call nature.  Next, the municipality,
then a tilde symbol then the location. Intersections are shown as to roads
separated by a forward slash. Next is another tilde symbol followed by the
nearest cross street then a tilde symbol then the next closest cross street.
(note intersections page do not have cross streets) Next, is another a tilde
symbol followed by the units separated by commas.  Lastly a tilde symbol
then the time of dispatch.
*/
import net.anei.cadpage.parsers.SmsMsgParser;

public class PALancasterCountyParser extends SmsMsgParser {
  
  public PALancasterCountyParser() {
    super("LANCASTER COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "911@lcwc911.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.length() == 0 || ! body.contains("~")) return false;
    data.strCall = subject;
    
    int ndx = 0;
    for (String line : body.split("~")) {
      ndx++;
      line = line.trim();
      switch (ndx) {
      
      case 1:
        data.strCity = line;
        if (data.strCity.contains("LANC")) data.strCity = "LANCASTER";
        break;
        
      case 2:
        parseAddress(line, data);
        break;
        
      case 3:
        data.strCross = line;
        break;
        
      case 4:
        // Could be second cross st, or if there wasn't a cross street, this
        // would be the unit field
        if (line.length() == 0) break;
        if (data.strCross.length() > 0) {
          data.strCross += " & " + line;
          break;
        }
        ndx++;
        // fall through to case 5
    
      case 5:
        data.strUnit = line;
        break;
      }
    }
    return true;
  }
}
