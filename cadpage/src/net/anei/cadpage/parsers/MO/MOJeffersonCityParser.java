package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;




public class MOJeffersonCityParser extends SmartAddressParser {
  
  private static final Pattern LEAD_TIME_PTN = Pattern.compile("^(\\d\\d:\\d\\d) +");
  private static final Pattern TRAIL_TIME_PTN = Pattern.compile(" +(\\d\\d:\\d\\d)$");
  private static final Pattern TRAIL_NAME_PTN = Pattern.compile("(?:(?: +-)?(?: +|^)[A-Z]?[a-z]+,?)? +[A-Z]?[a-z]+$");
  private static final Pattern UNIT_PTN = Pattern.compile("(?: +(?:\\d{3,4}|[A-Z]{2}Pager|[A-Z]\\d+|Batt\\d+))+$");
  private static final Pattern EXTRA_SPACE_PTN = Pattern.compile("((?:\\d+[-A-Z0-9]* )?[NSEW])  +(.*)");
  private static final Pattern CROSS_ST_MARK_PTN = Pattern.compile("(?:[- ]+(?:Closest Intersections|Cross Streets)-?|  +)");
  
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
    
    // For some odd reason they always include an extra blank after the
    // first direction in a street name.  Try to get rid of that
    body = p.get();
    match = EXTRA_SPACE_PTN.matcher(body);
    if (match.matches()) body = match.group(1) + ' ' + match.group(2);
    
    // Once that is taken care of, we can (hopefully) count on a double
    // blank terminating the address.  Except for very old calls where 
    // a cross street terminator can be counted on
    String addr;
    match = CROSS_ST_MARK_PTN.matcher(body);
    if (match.find()) {
      addr = body.substring(0,match.start());
      String info = body.substring(match.end());
      String cross = "";
      if (match.group().trim().length() > 0) {
        int pt = info.indexOf(" -");
        if (pt >= 0) {
          cross = info.substring(0,pt).trim();
          info = info.substring(pt+2).trim();
        } else {
          cross = info.trim();
          info = "";
        }
      }
      cross = stripFieldEnd(cross, "-");
      if (cross.equals("No Cross Streets Found")) cross = "";
      data.strCross = cross;
      data.strSupp = info;
    } else {
      addr = body;
    }
    parseAddress(StartType.START_ADDR, FLAG_IMPLIED_INTERSECT | FLAG_RECHECK_APT | FLAG_ANCHOR_END, addr, data);
    return true;
  }
}
