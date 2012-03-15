package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
St Louis County, MO
Contact: Mikey Bowman <mikeyb4307@gmail.com>, 3144132049@vtext.com
Sender: nccfas@ncc911.org

IN AREA, 224 S HARVEY AV (RES) - - 3014,3025,4310,3615,4610,3016,3017 19:57
MONROE AV / OAKRIDGE DR (MISC) - WIRES DOWN - 4310 09:04
6721 THURSTON AV (MISC) - WIRES DOWN - 4310 00:22
BROTHERTON LN (RES) - HOUSE ON BROTHERTON - 3025,4310,4610,3615,4210,3016,3017 22:27
KIPD, 5990 MONROE AV (LIFE) - 21 YOF WITH CHEST PAINS - 4310,4617 11:03 
EVERGREEN BLVD / JANUARY AV (RES) - HSE FIRE ON CORNER - 3615,3620,3014,4310,3602 07:47
8006 COURTNEY AV (FALLS) - 69 year old, Female, Conscious, Breathing. Falls. Caller Statement: FALLEN. GARAGE DOOR CODE 6008 - 3717,4310 12:44
8026 WESLEY AV (DIF BREATH) - 65 year old, Female, Conscious, Breathing. Breathing Problems. Caller Statement: DIFF BREATHING. - 4310,3017 13:33

*/

public class MOStLouisCountyAParser extends MsgParser {
  
  private static final Pattern TIME_STAMP = Pattern.compile("\\d\\d:\\d\\d");
  private static final Pattern CALL_PTN = Pattern.compile("(\\([A-Z ]+\\) - *.*) - ");

  public MOStLouisCountyAParser() {
    super("ST LOUIS COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "nccfas@ncc911.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.contains(") - ")) return false;
    
    // Last token in message body should be a time stamp.  If it is, strip it
    // off the message body.  If not, set the expect more data flag
    int pt = body.lastIndexOf(' ');
    if (pt >= 0) {
      String token = body.substring(pt+1);
      if (TIME_STAMP.matcher(token).matches()) {
        body = body.substring(0,pt).trim();
      } else {
        data.expectMore = true;
      }
    }
    
    Matcher match = CALL_PTN.matcher(body);
    if (!match.find()) return false;
    data.strCall = match.group(1);
    data.strUnit = body.substring(match.end()).trim();
    Parser p = new Parser(body.substring(0,match.start()).trim());
    data.strPlace = p.getOptional(',');
    parseAddress(p.get(), data);
    
    return true;
  }

}
