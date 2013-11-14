  package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Bucks County, PA
 */

public class PABucksCountyBParser extends PABucksCountyBaseParser {
  
  public PABucksCountyBParser() {
    super();
  }
  
  @Override
  public String getFilter() {
    return "8276,@bnn.us,iamresponding.com,Bucks RSAN,@alert.bucksema.org";
  }
  
  private static final Pattern SRC_PTN = Pattern.compile("TO INT1 FROM [A-Z0-9]+ +: *\n?(.*?)(?=\n)");
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = SRC_PTN.matcher(body);
    if (!match.find()) return false;
    data.strSource = match.group(1).trim();
    body = body.substring(match.end());
    return super.parseMsg(body, data);
  }
}
