package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Lebanon County, PA
Contact: Loren Miller <lmiller05@gmail.com>
Sender: 7176798487

Current call logs available at http://lebanonema.org/pager/html/monitor.html

Heidelberg Township 3 GLASSMOYER LN WF - Wildfire/Brush Fire Box 35-05 FG3 A160
City of Lebanon 541 SPRUCE ST Med Class1 Hemorrhage Box 190-2 199MU
Cornwall Borough 113 WENGER ST Med Class3 Fall Victim BOX 190-6 A192
City of Lebanon 437 NEW ST Med Class1 Abdominal Pain Box190-2 BC190
City of Lebanon 220 E WEIDMAN ST Med Class1 ALOC Box 190-2 A193 M12-3
South Lebanon Township 590 S 5TH AVE * Cedar Haven ROOM 313F Med Class1 Heart Problem Box 190-3 193MU
Palmyra Borough 101 S RAILROAD ST * Palmyra Interfaith Manor AFA - Auto Fire Alarm BOX 1-01 FG 3 W1 E2
North Cornwall Township 900 TUCK ST * Manor Care Med Class1 Altered Mental Status Box 190-8 193MU
City of Lebanon LEHMAN ST N 7TH ST MV - Accident w/Injuries Box 15-06 E15-2 R24 AmbCo190
City of Lebanon S 7TH ST CHESTNUT ST MV - Accident w/Injuries Box 15-03 E15-1 SQ22 R24 AmbCo190
City of Lebanon 544 N 8TH ST Med Class3 302 Commitment Assist MHMR Box 190-2 A198 
Heidelberg Township 3 GLASSMOYER LN WF - Wildfire/Brush Fire Box 35-05 FG3 **Second Alert** A160 
Swatara Township 68 SUPERVISORS DR AREA OF WF - Wildfire/Brush Fire Box 47-05 FG-3 E10 R47 AT47 PT47 AmbCo190 
South Lebanon Township 518 S 5TH ST SUPPORTIVE CONCEPTS Med Class3 Abdominal Pain Box 190-4 A198

Contact: Clinton Masr <mastclinton@gmail.com>
Sender: km911alert@gmail.com
(FASP@20:13) City of Lebanon CUMBERLAND ST N 9TH ST MV - Accident w/Injuries Pedestrian Struck Box 15-04 Class 1 for EMS BC190 \n\nTo unsubscribe reply STOP

*/

public class PALebanonCountyParser extends SmartAddressParser {
  
  private static final Pattern[] CITY_PTNS = new Pattern[]{
    Pattern.compile("^(.* Township) "),
    Pattern.compile("^City of ([^ ]*) "),
    Pattern.compile("^(.*) Borough ")
  };
  private static final Pattern CALL_BOX_PTN = 
    Pattern.compile(" ((?:Med Class|[A-Z]{2,3} - ).*) (?:Box|BOX) ?([0-9\\-]+) ");

  public PALebanonCountyParser() {
    super("LEBANON COUNTY", "PA");
  }
  
  @Override 
  public boolean parseMsg(String body, Data data) {

    // Look for city, borough, or township at start of text
    for (Pattern ptn : CITY_PTNS) {
      Matcher match = ptn.matcher(body);
      if (match.find()) {
        data.strCity = match.group(1).toUpperCase();
        body = body.substring(match.end()).trim();
        break;
      }
    }
    if (data.strCity.length() == 0) return false;
    
    Matcher match = CALL_BOX_PTN.matcher(body);
    if (!match.find()) return false;
    String sAddress = body.substring(0,match.start()).trim();
    data.strCall = match.group(1);
    data.strBox = match.group(2);
    data.strUnit = body.substring(match.end()).trim();
    
    parseAddress(StartType.START_ADDR, FLAG_IMPLIED_INTERSECT, sAddress, data);
    data.strPlace = getLeft();
    if (data.strPlace.startsWith("* ")) data.strPlace = data.strPlace.substring(2).trim();
    
    return true;
  }

}
