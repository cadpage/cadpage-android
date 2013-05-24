package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class MOJeffersonCityParser extends MsgParser {
  
  private static final Pattern MASTER_PTN = 
    Pattern.compile("(.*?)((?: [A-Za-z]+\\d+)+)  (.*) - Closest Intersection\\b(.*?) - (.*)");
  private static final Pattern TRAIL_NAME_PTN = Pattern.compile("(?:(?: +-)?(?: +|^)[A-Z][a-z]+,?)? +[A-Z][a-z]+$");
  
  public MOJeffersonCityParser() {
    super("JEFFERSON CITY", "MO");
    setFieldList("CALL UNIT ADDR APT X INFO");
  }
  
  @Override
  public String getFilter() {
    return "paging@jeffcitymo.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_DIRO;
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("DONOTREPLY")) return false;
    body = body.replace('\n', ' ');
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    
    data.strCall = match.group(1).trim();
    data.strUnit = match.group(2).trim();
    parseAddress(match.group(3).trim(), data);
    data.strCross = match.group(4).trim();
    String info = match.group(5).trim();
    match = TRAIL_NAME_PTN.matcher(info);
    if (match.find()) {
      info = info.substring(0,match.start());
    }
    data.strSupp = info;
    return true;
  }
}
