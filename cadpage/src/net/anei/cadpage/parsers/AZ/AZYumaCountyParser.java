package net.anei.cadpage.parsers.AZ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

public class AZYumaCountyParser extends MsgParser {
  
  public AZYumaCountyParser() {
    super("YUMA COUNTY", "AZ");
    setFieldList("CH UNIT ADDR PLACE CALL");
  }
  
  @Override
  public String getFilter() {
    return "yumacomm@rmetro.com";
  }
  
  private static final Pattern MASTER1 = Pattern.compile("(CH\\d+ [A-Z]+) ASSIGN: *([A-Z0-9, ]+) - ([^,]*)(?:, *(.*))? (?i)FOR REPORT OF (.*)");
  private static final Pattern MASTER2 = Pattern.compile("(CH\\d+ [A-Z]+) ASSIGN FOR ([A-Z0-9, ]+) AREA OF (.*?) / (.*)");
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int pt = body.indexOf("\n***");
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    Matcher match = MASTER1.matcher(body);
    if (match.matches()) {
      data.strChannel = match.group(1);
      data.strUnit = match.group(2).trim();
      parseAddress(match.group(3).trim(), data);
      data.strPlace = getOptGroup(match.group(4));
      data.strCall = match.group(5).trim();
      return true;
    }
    
    if ((match = MASTER2.matcher(body)).matches()) {
      data.strChannel = match.group(1);
      data.strUnit = match.group(2).trim();
      parseAddress(match.group(3).trim(), data);
      data.strCall = match.group(4).trim();
      return true;
    }
    
    return false;
  }
}
