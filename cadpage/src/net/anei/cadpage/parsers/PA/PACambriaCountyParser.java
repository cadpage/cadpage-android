package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Cambria County, PA
Contact: jacob berkey <jwb932@gmail.com>
Sender: alerts@cambria.ealertgov.com
JO-JOHNTOWN

[29] 11 Time: 15:02:29 Nature: 17A01G-Alpha FALL Location: 216 MAIN ST-JO | Sta 35
[29] 11 Time: 11:54:47 Nature: 29B01-Bravo VEH ACC WITH INJURIES Location: 110 PLAZA DR-LY | Sta 30, Sta 23, Sta 35
[29] 11 Time: 08:03:01 Nature: 10C02-Charlie CHEST PAIN Location: 315 LOCUST ST-JO | Sta 35 
[29] 11 Time: 06:45:29 Nature: 17B03G-Bravo FALL Location: WALNUT ST-JO/MAIN ST-JO | Sta 35
[28] 11 Time: 21:39:31 Nature: 06D03A-Delta BREATHING PROBLEMS Location: 205 CHANDLER AVE-JO | Sta 35, Sta 21, Sta 36

Contact: Ben Smith <cnfederatediesel@gmail.com>
Date: 06/02/11\nTime: 20:47:52\nNature: 10C01-Charlie CHEST PAIN\nLocation: 1518 W 2ND ST-CR\n| Sta 75
Date: 06/04/11\nTime: 11:03:04\nNature: 06D02-Delta\2sBREATHING PROBLEMS\nLocation: 908 SHORT AVE-CR\n| Sta 75
Date: 06/04/11\nTime: 17:24:03\nNature: STB-STAND BY\nLocation: 721 MAIN ST-PORB\n| Sta 73

*/

public class PACambriaCountyParser extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CR",   "CARROLLTOWN",
      "JO",   "JOHNSTOWN",
      "PORB", "PORTAGE"
  });
  
  private static final Pattern MARKER1 = Pattern.compile("\\d\\d");
  private static final Pattern MARKER2 = Pattern.compile("^\\d\\d ");
  private static final Pattern MARKER3 = Pattern.compile("^Date: \\d\\d/\\d\\d/\\d\\d\n");
  
  public PACambriaCountyParser() {
    super(CITY_CODES, "CAMBRIA COUNTY", "PA",
           "Time:SKIP! Nature:CALL! Location:ADDR/y! Sta:UNIT!");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Check for multiple signatures
    Matcher match;
    do {
      // Signature 1
      if (MARKER1.matcher(subject).matches()) {
        match = MARKER2.matcher(body);
        if (match.find())break;
      }
      
      // Signature 2
      if ((match = MARKER3.matcher(body)).find()) break;
      
      // No go
      return false;
    } while (false);
    
    body = body.substring(match.end()).trim();
    body = body.replace('\n', ' ').replace(" | ", " Sta: ");
    return super.parseMsg(body, data);
  }
}
