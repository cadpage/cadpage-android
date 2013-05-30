package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class MOJeffersonCityParser extends MsgParser {
  
  private static final Pattern LEAD_TIME_PTN = Pattern.compile("^(\\d\\d:\\d\\d) +");
  private static final Pattern TRAIL_TIME_PTN = Pattern.compile(" +(\\d\\d:\\d\\d)$");
  private static final Pattern TRAIL_NAME_PTN = Pattern.compile("(?:(?: +-)?(?: +|^)[A-Z][a-z]+,?)? +[A-Z][a-z]+$");
  private static final Pattern UNIT_PTN = Pattern.compile("(?: +(?:\\d{3,4}|[A-Z]{2}Pager))+$");
  private static final Pattern CROSS_ST_MARK_PTN = Pattern.compile("(?: -?Cross Streets-?| -)(?= |$)");
  
  public MOJeffersonCityParser() {
    super("JEFFERSON CITY", "MO");
    setFieldList("TIME CALL UNIT ADDR APT X INFO");
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
    
    // Time can be in front or in back of text
    Matcher match = LEAD_TIME_PTN.matcher(body);
    if (match.find()) {
      data.strTime = match.group(1);
      body = body.substring(match.end());
    } else {
      match = TRAIL_TIME_PTN.matcher(body);
      if (match.find()) {
        data.strTime = match.group(1);
        body = body.substring(0,match.start());
      }
    }
    
    // Check for trailing dispatcher name 
    match =  TRAIL_NAME_PTN.matcher(body);
    if (match.find()) {
      body = body.substring(0,match.start());
    }
    
    // Time to set up Parser object
    Parser p = new Parser(body);
    
    // Get call description and optional units
    String call =  p.get("  ");
    match = UNIT_PTN.matcher(call);
    if (match.find()) {
      data.strUnit = match.group().trim();
      call = call.substring(0,match.start());
    }
    data.strCall = call;
    
    // Get address & cross street
    String addr = "";
    do {
      String addr2 = p.get("  ");
      if (addr2.length() == 0) return false;
      addr = append(addr, " ", addr2);
      match = CROSS_ST_MARK_PTN.matcher(addr);
    } while (!match.find());
    String cross = addr.substring(match.end()).trim();
    if (cross.endsWith("-")) cross = cross.substring(0,cross.length()-1).trim();
    if (cross.equals("No Cross Streets Found")) cross = "";
    data.strCross = cross;
    addr = addr.substring(0,match.start()).trim();
    if (addr.startsWith("-")) addr = addr.substring(1).trim();
    parseAddress(addr, data);
    
    // Everything else is info
    data.strSupp = p.get();
    return true;
  }
}
