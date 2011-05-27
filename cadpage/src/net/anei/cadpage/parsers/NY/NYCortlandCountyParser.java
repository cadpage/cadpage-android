package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Cortland County, NY
Contact: jared gebel <jgebel83@gmail.com>
Sender: cville@fdcms.com

(3609 PLEASANTVIEW DR) 17:28 , EMS ONLY , 80 YO FEMALE - SUFFERS A BROKEN BACK- UNABLE TO EAT OR DRINK\n RECENTLY RELEASED FROM THE HOSPITAL FO ,
(839 BENNIE RD) 18:32 , EMS ONLY , 85 YO MALE- DIFF BREATHING\nASPEN WAY UNIT\n\n\n\n,
(697 MCLEAN RD) 15:50 , CO DETECTOR , CARBON MONOXIDE DETECTOR GOING OFF\nNEWLY BUILT HOUSE\n\n\n\n,
(3643 STHY 281) 12:31 , EMS ONLY , PARKING LOT B LARGE OVERHEAD DOOR, 27 Y/O MALE DOWN\nSYNCOPAL EPISODE\n\n\n\n,
(839 BENNIE RD) 08:24 , EMS ONLY , 81 MALE IN LEGASEY COURT NOT ALERT PER NORMAL\n\n\n\n,

*/

public class NYCortlandCountyParser extends SmsMsgParser {
  
  private static Pattern MARKER = Pattern.compile("^\\d\\d:\\d\\d , ");
  
  public NYCortlandCountyParser() {
    super("CORTLAND COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "cville@fdcms.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.length() == 0) return false;
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    
    parseAddress(subject, data);
    
    body = body.substring(match.end()).trim();
    body = body.replaceAll("\\s+", " ");
    if (body.endsWith(",")) body = body.substring(0,body.length()-1).trim();
    Parser p = new Parser(body);
    data.strCall = p.get(',');
    data.strSupp = p.get();
    return true;
  }

}
