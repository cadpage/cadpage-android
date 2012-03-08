package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

/* 
Decatur, TX
Contact: Michael Richardson <grizzly.richardson@gmail.com>
Sender: messaging@iamresponding.com
System: Cardinal CAD SE

(Decatur FD) MEDICAL EMERGENCY, 800 MEDICAL CENTER DR #C,  - DPD 221\n\nDr Swaims office
(Decatur FD) MAJOR ACCIDENT,  730 S 287,  - DPD 221 \n\n2 vehs
(Decatur FD) STRUCTURE FIRE, 2905 MURVIL,  - DPD 207 \n\nNO SMOKE OR FLAMES BUT CAN SMELL BURNING WIRES
(Decatur FD) OTHERS, 1500 STATE ST S #31,  - DPD 211 \n\nComp smells natural gas
(Decatur FD) MEDICAL EMERGENCY, 2150 FM 51 HWY S,  - DPD 207 \n\n10:36:45 ---- MALE HIGH BLOOD PRESSURE
(Decatur FD) MEDICAL EMERGENCY, 500 COTTONWOOD E,  - DPD 207 \n\n09:29:13 ---- SHOLLOW BREATHING \n\n09:29:17 ---- 1 YOA MALE\n\n09:29:23 ---- WONT WAKE UP
(Decatur FD) MEDICAL EMERGENCY, 201 THOMPSON ST E #E 139, HATCHER,  - DPD 112
(Decatur FD) MEDICAL EMERGENCY, 147 CR 3131,  - DPD 112

*/

public class TXDecaturParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("([^,]*), ([^,]*)(?:, (.*))?,  - (.*)");
  
  public TXDecaturParser() {
    super("DECATUR", "TX");
  }
  
  public String getFilter() {
    return "messaging@iamresponding.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.endsWith(" FD")) return false;
    data.strSource = subject;
    
    int pt = body.indexOf("\n\n");
    if (pt >= 0) {
      data.strSupp = body.substring(pt+2).trim();
      body = body.substring(0,pt).trim();
    }
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    data.strCall = match.group(1).trim();
    parseAddress(match.group(2).trim(), data);
    data.strCross = getOptGroup(match.group(3));
    data.strUnit = match.group(4).trim();
    return true;
  }
}
