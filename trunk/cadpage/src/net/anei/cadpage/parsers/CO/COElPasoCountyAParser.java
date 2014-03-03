package net.anei.cadpage.parsers.CO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;



public class COElPasoCountyAParser extends MsgParser {
  
  private static final Pattern MASTER = 
      Pattern.compile("\\[([-A-Z0-9 ]+): *([^\\]]+?)\\] *([^~]+?)~([^~]+?)~([^#\\.]+?)\\.?#([^~]*?)~([^~]*?)~(?:x:([^~]*?)(?:   +~?|~))?([-A-Z0-9]+) *~*");
  
  public COElPasoCountyAParser() {
    super("EL PASO COUNTY", "CO");
  }
  
  @Override
  public String getFilter() {
    return "ept@ept911.info";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Square bracket got turned into a subject and needs to be turned back
    if (subject.length() > 0) body = '[' + subject + "] " + body;
    
    // Not everyone is using it, but see if this is the new standard dispatch format
    Matcher match = MASTER.matcher(body);
    if (match.matches()) {
      setFieldList("SRC MAP UNIT CALL ADDR APT PLACE X ID");
      data.strSource = match.group(1).trim();
      data.strMap = match.group(2).trim();
      data.strUnit = match.group(3).trim();
      data.strCall = match.group(4).trim();
      String addr = match.group(5).trim();
      if (addr.startsWith("0 ")) addr =  addr.substring(2).trim();
      parseAddress(addr, data);
      data.strApt = match.group(6).trim();
      data.strPlace = match.group(7).trim();
      data.strCross = getOptGroup(match.group(8));
      data.strCallId = match.group(9);
      return true;
    }
    
    // There are (at least) three different fixed length formats used by 
    // three different agencies.  So I guess we just have to figure out
    // which one to use
    
    if (body.length() >= 69 &&
        body.charAt(4) == '-' &&
        body.substring(30,34).equals("APT-") &&
        body.substring(65,69).equals("DET-")) {

      setFieldList("SRC ADDR APT CALL INFO");
      data.strSource = body.substring(0,4).trim();
      parseAddress(body.substring(5,30).trim(), data);
      data.strApt = body.substring(34,40).trim();
      data.strCall = body.substring(40,65).trim();
      data.strSupp = body.substring(69);
      return true;
    }
    
    
    if (body.length() >= 30 &&
        body.substring(6,9).equals(" - ")) {
      
      setFieldList("SRC CALL ADDR APT PLACE SUPP");
      data.strSource = body.substring(0,6).trim();
      data.strCall = substring(body, 9, 29);
      parseAddress(substring(body, 29, 59), data);
      data.strPlace = substring(body, 59, 74);
      data.strSupp = substring(body, 74);
      return true;
    }
    
    if (body.length() >= 80 &&
        body.charAt(4) == ' ' && 
        body.charAt(5) == 'D' &&
        Character.isDigit(body.charAt(6)) &&
        body.substring(7,13).trim().length() == 0) {
      
      setFieldList("SRC PRI CALL ADDR APT INFO");
      data.strSource = body.substring(0,4).trim();
      data.strPriority = body.substring(5,7); 
      data.strCall = body.substring(13,43).trim();
      parseAddress(body.substring(43,78).trim(), data);
      data.strSupp = substring(body, 78);
      return true;
    }
    
    return false;
  }
}
