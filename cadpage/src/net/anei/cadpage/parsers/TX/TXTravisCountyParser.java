package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;
/**
 * Travis County, TX
 */
public class TXTravisCountyParser extends MsgParser {
  
  private static final Pattern COMMENT_PTN = Pattern.compile("Comment: (.*?), (From - .*?)(?: From - .*)?");
  
  private static final Pattern MASTER1 = 
      Pattern.compile("From -([A-Z0-9]+) Dispatch - ?\\d?ALARM -(.*?) - BOX -([-A-Z0-9]*) On -([ A-Z0-9]*) - AT -(.+?) - INC# =>(\\d+) Case Num:([-A-Z0-9]*) For -([A-Z0-9,]+)");
  
  private static final Pattern MASTER2 = 
      Pattern.compile("From - ([A-Z0-9]+) - \\d Alarm / (.*?) (?:Box|BOX|\\| RAP) - ([-A-Z0-9]*) @ (.*?) (?:\\| )?XStreets: *(.*?) (?:\\| )?On - ([ A-Z0-9]*) (?:\\| )?Time: (?:\\| )?(?:(\\d\\d:\\d\\d:\\d\\d)|\\d\\d:\\d\\d [AP]M) (?:\\| )?Inc# (\\d+) (?:Case Num:([-A-Z0-9]*) )?(?:\\| )?For - ([A-Z0-9,]+)");
  
  private static final Pattern CROSS_PTN = Pattern.compile("(?:(?:N?o )?CrossStreet Found)?/?(.*?)/?(?:No CrossStreet Found)?");

  public TXTravisCountyParser() {
    super("TRAVIS COUNTY", "TX");
  }
  
  public String getFilter() {
    return "PublicSafety@austintexas.gov";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
 
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = COMMENT_PTN.matcher(body);
    if (match.matches()) {
      data.strSupp = match.group(1).trim();
      body = match.group(2).trim();
    }
    match = MASTER1.matcher(body);
    if (match.matches()) {
      setFieldList("INFO SRC CALL BOX CH ADDR APT ID UNIT");
      
      data.strSource = match.group(1);
      data.strCall = match.group(2).trim();
      data.strBox = match.group(3).trim();
      data.strChannel = match.group(4).trim();
      parseAddress(match.group(5).trim(), data);
      data.strCallId = append(match.group(7), "/", match.group(6));
      data.strUnit = match.group(8);
      
      return true;
    }
    
    match = MASTER2.matcher(body);
    if (match.matches()) {
      setFieldList("INFO SRC CALL BOX ADDR APT X CH TIME ID UNIT");
      
      data.strSource = match.group(1);
      data.strCall = match.group(2).trim();
      data.strBox = match.group(3).trim();
      parseAddress(match.group(4).trim(), data);
      String cross  = match.group(5).trim();
      data.strChannel = match.group(6);
      data.strTime = getOptGroup(match.group(7));
      data.strCallId = append(getOptGroup(match.group(9)), "/", match.group(8));
      data.strUnit = match.group(10);
      match = CROSS_PTN.matcher(cross);
      if (match.matches()) cross = match.group(1);
      data.strCross = cross;
      
      return true;
      
    }
    
    return false;
  }
}
