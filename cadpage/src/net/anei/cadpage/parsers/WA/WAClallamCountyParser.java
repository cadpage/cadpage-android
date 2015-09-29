package net.anei.cadpage.parsers.WA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

public class WAClallamCountyParser extends MsgParser {
  
  public WAClallamCountyParser() {
    super("CLALLAM COUNTY", "WA");
    setFieldList("DATE TIME CALL UNIT ADDR APT ID INFO");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@co.clallam.wa.us";
  }
  
  private static final Pattern MASTER = Pattern.compile("(\\d\\d/\\d\\d/\\d\\d) (\\d\\d:\\d\\d) (\\S+)((?: \\S+)*)  (?:(.*?) )?(\\d{4}-\\d{8}) *(.*)");
  private static final Pattern INFO_JUNK_PTN = Pattern.compile("\\bDispatch received by unit \\S+\\b|\\bCall Number \\d+ was created from Call Number \\d+(?:\\([A-za-z0-9 :]*\\))?|(?:  |^)E911 Info.*");
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Incident")) return false;
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strDate = match.group(1);
    data.strTime = match.group(2);
    data.strCall = match.group(3);
    data.strUnit = match.group(4).trim();
    String addr = getOptGroup(match.group(5)).replaceAll("  +", " "); 
    parseAddress(addr, data);
    data.strCallId = match.group(6);
    String info = match.group(7);
    info = INFO_JUNK_PTN.matcher(info).replaceAll("");
    info = info.replaceAll("  +", "").trim();
    data.strSupp = info;
    return true;
  }

}
