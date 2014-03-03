package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class OHSummitCountyCParser extends SmartAddressParser {
  
  private static final Pattern SPACE_PTN = Pattern.compile("  +");
  private static final Pattern MASTER = Pattern.compile("(EMS|FIRE|POL) +(\\d\\d-\\d{5}) +(\\d\\d/\\d\\d/\\d\\d) +(\\d\\d:\\d\\d:\\d\\d) +(.*?) +(?:between +(.*?) +)?>> *(.*?) *<< *(.*?) *(?:\\bMap: *(.*))?");

  public OHSummitCountyCParser() {
    super("SUMMIT COUNTY", "OH");
    setFieldList("ID DATE TIME ADDR APT X CALL UNIT MAP");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@stow.oh.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER.matcher(SPACE_PTN.matcher(body).replaceAll(" "));
    if (!match.matches()) return false;
    
    data.strCall = append(match.group(1), " - ", match.group(7));
    data.strCallId = match.group(2);
    data.strDate = match.group(3);
    data.strTime = match.group(4);
    String addr = match.group(5).replace(" at ", " & ");
    parseAddress(StartType.START_ADDR, addr, data);
    data.strApt = append(data.strApt, "-", getLeft());
    String cross = getOptGroup(match.group(6));
    if (cross.startsWith("&")) cross = cross.substring(1).trim();
    if (cross.endsWith("&")) cross = cross.substring(0,cross.length()-1).trim();
    data.strCross = cross;
    data.strUnit = getOptGroup(match.group(8));
    data.strMap = getOptGroup(match.group(9));
    return true;
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return CR_PTN.matcher(addr).replaceAll("CIR");
  }
  private static final Pattern CR_PTN = Pattern.compile("\\bCR\\b");
}
