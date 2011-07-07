package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Jefferson City, MO
Contact: Jake Holee <jakeholee@gmail.com>
Contact: Scott Kempker <jcfd133@gmail.com>
Contact: "jacobholee04@pm.sprint.com" <jacobholee04@pm.sprint.com>
Sender: paging@jeffcitymo.org

Subject:DONOTREPLY\nSnyder, Jodi 14:00 Medical Emergency 718 MICHIGAN -Cross Streets- LOUISIANA AVE / MISSOURI BLVD E1   CONSCIOUS  OUTSID
Subject:DONOTREPLY\nE4  14:28 Line Down  - 1505 SOUTHWEST -Cross Streets- CEDAR RIDGE RD / EDGEWOOD DR   LIMB IS ON A POWER LINE \n
Subject:DONOTREPLY\nMcDowell, Shelley 13:40 Medical Emergency 301 HIGH -Cross Streets- BROADWAY ST / RAMP OFF RAMP, RAMP ON RAMP E1   FEMA
Subject:DONOTREPLY\nBatt12 E1 L1 E3 S5  13:31 Fire Alarm - 1303 EDMONDS -Cross Streets- MONTANA ST / MYRTLE AVE   OPER 38  UNKNOWN ROOM  3 
Subject:DONOTREPLY\nL1  12:02 Accident with Injuries - 1300 5463 BLK -Cross Streets- RAMP 25, HWY 54 E / RAMP 26   CCEMS EN ROUTE  NEED EX 
Subject:DONOTREPLY\nMcDowell, Shelley 10:07 Medical Emergency 1705 CHRISTY -Cross Streets- CHRISTY CT / ELLIS BLVD E4   SUITE 208 \n
Subject:DONOTREPLY\nMcDowell, Shelley 09:40 Medical Emergency 1434 NOTTING HILL -Cross Streets- DEAD END / PORTABELLO PLACE DR S5   EMS EN 
Subject:DONOTREPLY\nMcDowell, Shelley 08:30 Medical Emergency 424 STADIUM -Cross Streets- ADAMS ST / YMCA DR, JACKSON ST E4   ELDERLY MALE 
Subject:DONOTREPLY\nStiefermann, Angela 02:32 Medical Alarm 10 JACKSON 704 -Address Between- DEAD END / E STATE ST E1   \n
Subject:DONOTREPLY\nE1  16:32 Assist Citizen Fire - MYRTLE EDMONDS -Cross Streets-   MALE WAS ROLLING BACKWARDS UNTIL CALLERS SON JUMPED O
FRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Aston, Nora 22:35 Medical Alarm 10 JACKSON 207 -Address Between- DEAD END / E STATE ST E1 EMS NOTIFIED \n


*/


public class MOJeffersonCityParser extends SmsMsgParser {
  
  private static final Pattern MASTER_PTN = 
    Pattern.compile(" \\d\\d:\\d\\d (.*) (?:-Cross Streets-|-Address Between-) (.*)$");
  private static final Pattern NUMBER_PTN = Pattern.compile("\\b\\d{2,}\\b");
  
  public MOJeffersonCityParser() {
    super("JEFFERSON CITY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "paging@jeffcitymo.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("DONOTREPLY")) return false;
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.find()) return false;
    String sPart1 = match.group(1).trim();
    String sPart2 = match.group(2);
    
    int pt = sPart1.indexOf(" - ");
    if (pt >= 0) {
      data.strCall = sPart1.substring(0,pt).trim();
      parseAddress(sPart1.substring(pt+3).trim(), data);
    } else if ((match = NUMBER_PTN.matcher(sPart1)).find()) {
      data.strCall = sPart1.substring(0,match.start()).trim();
      parseAddress(sPart1.substring(match.start()), data);
    } else return false;
    
    Parser p = new Parser(sPart2);
    data.strCross = p.get("  ");
    data.strSupp = p.get();
    return true;
  }
}
