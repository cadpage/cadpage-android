package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


/**
 * San Joaquin County, CA
 */
public class CASanJoaquinCountyParser extends SmartAddressParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile(".*? Dispatched:.*?Enroute:.*?On Scene:.*?AOR:.*");
  private static final Pattern MASTER1 = Pattern.compile("(?:([-A-Z0-9]+) +)?([A-Z]{3}-\\d{6})  +(.*?)  +(.*?)(?:  +(.*?))? *Bldg: *(.*?) *Apt: *(.*)");
  private static final Pattern MASTER2 = Pattern.compile("(?:([-A-Z0-9]+) +)?(\\d{8}) {5}([^ ].*)");
  
  public CASanJoaquinCountyParser() {
    super("SAN JOAQUIN COUNTY", "CA");
  }
  
  @Override
  public String getFilter() {
    return "LifecomCellPaging@amr.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // First see if this looks like a run report
    if (RUN_REPORT_PTN.matcher(body).matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    // There are two types of CAD page, check for the first one
    Matcher match = MASTER1.matcher(body);
    if (match.matches()) {
      data.strUnit = getOptGroup(match.group(1));
      data.strCallId = match.group(2);
      data.strCall = match.group(3).trim();
      parseAddress(match.group(4).trim(), data);
      data.strCross = getOptGroup(match.group(5));
      data.strPlace = match.group(6).trim();
      data.strApt = match.group(7).trim();
      return true;
    }
    
    //  See if this matches the second pattern
    match = MASTER2.matcher(body);
    if (match.matches()) {
      data.strUnit = getOptGroup(match.group(1));
      data.strCallId = match.group(2);
      String sAddr = match.group(3).trim();
      if (sAddr.length() <= 20) return false;
      data.strCall = sAddr.substring(0,16).trim();
      Parser p = new Parser(sAddr.substring(16).trim());
      String sUnit = p.getLastOptional("Assigned Units:");
      if (sUnit.length() > 0) data.strUnit = sUnit;
      data.strMap = p.getLast(' ');
      data.strCross = p.getLastOptional("  ");
      sAddr = p.get();
      if (data.strCross.length() > 0) {
        parseAddress(sAddr, data);
      } else {
        parseAddress(StartType.START_ADDR, FLAG_CROSS_FOLLOWS, sAddr, data);
        data.strCross = getLeft();
      }
      return true;
    }
    
    return false;
  }
}
