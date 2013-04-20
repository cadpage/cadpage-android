package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class MOJeffersonCityParser extends MsgParser {
  
  private static final Pattern MASTER_PTN = 
    Pattern.compile("(?:(.*)\\b(\\d\\d:\\d\\d) )?(.*) (?:-Cross Streets-|-Address Between-) (.*)");
  private static final Pattern NUMBER_PTN = Pattern.compile("\\b\\d{2,}\\b");
  private static final Pattern UNIT_PTN = Pattern.compile("(?:(?: |^)[A-Z]+\\d+)+$", Pattern.CASE_INSENSITIVE);
  private static final Pattern UNIT2_PTN = Pattern.compile("(?:(?: |^)[A-Z]+\\d+)+ ", Pattern.CASE_INSENSITIVE);
  private static final Pattern TRAIL_NAME_PTN = Pattern.compile("(?: *-)?((?: +[A-Z][a-z]+,?)? +[A-Z][a-z]+)$");
  
  public MOJeffersonCityParser() {
    super("JEFFERSON CITY", "MO");
    setFieldList("UNIT NAME TIME CALL ADDR CITY X INFO");
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
    if (!match.find()) return false;
    
    String sPrefix = getOptGroup(match.group(1));
    if (sPrefix.contains(",")) {
      data.strName = sPrefix;
    } else {
      data.strUnit = sPrefix;
    }
    data.strTime = getOptGroup(match.group(2));
    String sPart1 = match.group(3).trim();
    String sPart2 = match.group(4);
    
    int pt = sPart1.lastIndexOf(',');
    if (pt >= 0) {
      data.strCity = sPart1.substring(pt+1).trim();
      sPart1 = sPart1.substring(0,pt).trim();
    }
    else if (sPart1.endsWith(" JEFFERSON CITY")) {
      sPart1 = sPart1.substring(0,sPart1.length()-15);
    }
    pt = sPart1.indexOf(" - ");
    if (pt >= 0) {
      data.strCall = sPart1.substring(0,pt).trim();
      parseAddress(sPart1.substring(pt+3).trim(), data);
    } else if ((match = NUMBER_PTN.matcher(sPart1)).find()) {
      data.strCall = sPart1.substring(0,match.start()).trim();
      parseAddress(sPart1.substring(match.start()), data);
    } else return false;
    
    Parser p = new Parser(sPart2);
    String sCross = p.get("  ");
    String info = p.get();
    match = TRAIL_NAME_PTN.matcher(info);
    if (match.find()) {
      data.strName = append(data.strName, " / ", match.group(1).trim());
      info = info.substring(0,match.start());
    }
    data.strSupp = info;
    
    match = UNIT_PTN.matcher(sCross);
    if (match.find()) {
      data.strUnit = match.group().trim();
      sCross = sCross.substring(0,match.start()).trim();
    }
    
    if (data.strUnit.length() == 0 && data.strSupp.length() == 0) {
      match = UNIT2_PTN.matcher(sCross);
      if (match.find()) {
        data.strUnit = match.group().trim();
        data.strSupp = sCross.substring(match.end()).trim();
        sCross = sCross.substring(0,match.start()).trim();
      }
    }
    data.strCross = sCross;
    
    if (data.strUnit.length() > 0 && data.strSupp.length() > 0) {
      if (data.strSupp.endsWith(data.strUnit)) {
        data.strSupp = data.strSupp.substring(0,data.strSupp.length()-data.strUnit.length()).trim();
      }
    }
    return true;
  }
}
