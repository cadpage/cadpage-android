package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;



public class NYMadisonCountyGLASParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("(.*?)\r?\n(.*?)(?: *, (.*?))?(?: \\((.*?)\\)?)?");
  
  public NYMadisonCountyGLASParser() {
    super("MADISON COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Greater Lenox")) return false;
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1).trim();
    String sPart1 = match.group(2).trim();
    String sPart2 = getOptGroup(match.group(3));
    String sPart3 = getOptGroup(match.group(4));
    if (sPart1.startsWith("@")) {
     data.strPlace = sPart1.substring(1).trim(); 
     if (sPart2.length() > 0) {
       parseAddress(sPart2.replace("\\", "&"), data);
       data.strCross = sPart3;
     } else {
       Parser p = new Parser(sPart3);
       parseAddress(p.get('(').replace("\\", "&"), data);
       data.strCity = p.get(')');
     }
    } else {
      parseAddress(sPart1.replace("\\", "&"), data);
      data.strCity = sPart2;
      if (sPart3.startsWith("/")) sPart3 = sPart3.substring(1).trim();
      if (sPart3.startsWith(",")) {
        data.strCity = sPart3.substring(1).trim();
      } else {
        data.strCross = sPart3;
      }
    }
    
    // Check for truncated VILLAGE following city
    int pt = data.strCity.lastIndexOf(' ');
    if (pt >= 0) {
      String last = data.strCity.substring(pt+1).trim().toUpperCase();
      for (String city : new String[]{"VILLAGE", "INSIDE"}) {
        if (city.equals(last)) break;
        if (city.startsWith(last)) {
          data.strCity = data.strCity.substring(0,pt+1) + city;
          break;
        }
      }
    }
    return true;
  }
}
	