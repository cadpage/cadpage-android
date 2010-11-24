package net.anei.cadpage.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;

/* 
Belmore, NY
Contact: Timothy Beuth <tbeuth@gmail.com>
Sender: paging@alpinesoftware.com
In Nassau county, next to Suffolk COunty

RESCUE at 2438 BEDFORD PLACE. . 11:34:04
AUTO ACCIDENT at intersection of BELTAGH AVENUE and BELLMORE AVENUE. . 15:03:39
AUTO ACCIDENT at 2971 LEE PLACE. . 04:08:29
MUTUAL AID RESCUE at 3015 CHERYL ROAD. . 19:12:04
AUTOMATIC ALARM BUILDING . . UNREGISTERED ALARM at 609 SUNRISE HIGHWAY. . 11:46:13
HAZMAT - NATURAL GAS INTERIOR . . ODOR INSIDE at 1 SUNRISE HIGHWAY. . 05:07:37
HOUSE FIRE . . SMOKE IN THE HOUSE at 2764 MARTIN AVENUE. . 17:09:53
6011 IS OUT OF SERVICE
6011 IS BACK IN SERVICE 
*/

public class NYBelmoreParser extends SmsMsgParser {
  
  private static final Pattern EOL_MARK = Pattern.compile(". . \\d\\d:\\d\\d:\\d\\d *$");

    @Override
    public boolean isPageMsg(String body) {
      if (! body.contains(" at ")) return false;
      return EOL_MARK.matcher(body).find();
    }

  @Override
  protected void parse(String body, Data data) {

    data.defState="NY";
    data.defCity="BELMORE";
    
    // Strip off trailing time mark
    Matcher match = EOL_MARK.matcher(body);
    if (! match.find()) return;
    body = body.substring(0, match.start()).trim();
    
    Parser p = new Parser(body);
    data.strCall = p.getOptional(". . ");
    String call = p.get(" at ");
    if (data.strCall.length() == 0) {
      data.strCall = call;
    } else {
      data.strSupp = call;
    }
    
    data.strAddress = p.get();
    if (data.strAddress.startsWith("intersection of ")) {
      data.strAddress = data.strAddress.substring(16).trim();
    }
  }
}
