package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


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
