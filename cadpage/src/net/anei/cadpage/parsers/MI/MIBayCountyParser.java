package net.anei.cadpage.parsers.MI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;


public class MIBayCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("(.+?)  ([^,]+?), (.+?)  (.*?)(1?\\d/\\d\\d?.\\d{4} \\d\\d?:\\d\\d?:\\d\\d [AP]M)");
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
  
  public MIBayCountyParser() {
    super("BAY COUNTY", "MI");
    setFieldList("CALL ADDR APT CITY INFO DATE TIME");
  }
  
  @Override
  public String getFilter() {
    return "911@baycounty.net";
  }
  
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace('\n', ' ');
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    data.strCall = match.group(1).trim();
    parseAddress(match.group(2).trim(), data);
    data.strCity = match.group(3).trim();
    data.strSupp = match.group(4).trim();
    setDateTime(DATE_TIME_FMT, match.group(5), data);
    
    return true;
  }
}
