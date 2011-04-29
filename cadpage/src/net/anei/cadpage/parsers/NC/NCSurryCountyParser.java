package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/* 
Surry County, NC
Contact: Zackary Welch <zwelch85@gmail.com>
Sender: SC911-CallAlert!!@co.surry.nc.us

S: M:SC911 - Call Alert!!:Call Number - 110425-043* Address - 105 DUTCH LN* City - MOUNT AIRY* Call Type - CARDIAC D* *﻿
S: M:SC911 - Call Alert!!:Call Number - 110424-196* Address - 1642 S MAIN ST* City - MOUNT AIRY* Call Type - RESP DIS D* *﻿
S: M:SC911 - Call Alert!!:Call Number - 110424-100* Address - 120 W PINE ST* City - MOUNT AIRY* Call Type - UNRESPONSIVE* *﻿
S: M:SC911 - Call Alert!!:Call Number - 110420-120* Address - 70 MAYBERRY MALL RD* City - MOUNT AIRY* Call Type - FALL* *﻿
S: M:SC911 - Call Alert!!:Call Number - 110419-061* Address - 908 REEVES DR* City - MOUNT AIRY* Call Type - CARD ARR E* *﻿
S: M:SC911 - Call Alert!!:Call Number - 110419-291* Address - 1053 N MAIN ST* City - MOUNT AIRY* Call Type - SICK C* *﻿

*/

public class NCSurryCountyParser extends SmsMsgParser {
  
  private static final Pattern MASTER = 
    Pattern.compile("SC911 - Call Alert!!:Call Number - (.+)\\* Address - (.+)\\* City - (.*)\\* Call Type - (.*)\\* \\*﻿");
  
  public NCSurryCountyParser() {
    super("SURRY COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "SC911-CallAlert!!@co.surry.nc.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    data.strCallId = match.group(1);
    parseAddress(match.group(2), data);
    data.strCity = match.group(3);
    data.strCall = match.group(4);
    
    return true;
  }
}
