package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;


/**
 * Calaveras County, CA
 */
public class CACalaverasCountyParser extends MsgParser {
  
  private static final Pattern MASTER = 
      Pattern.compile("Inc# (\\d+):(?:([^@]+)@)?(.+?), *([A-Z_]+) *:Map  ([^:]*):(?: :)? LAT/LONG X: ([-+]?\\d+) (\\d+\\.\\d+) +Y: ([-+]?\\d+) (\\d+\\.\\d+): ([^:]*:[^:]+):(.*)");
  
  public CACalaverasCountyParser() {
    super("CALAVERAS COUNTY", "CA");
  }
  
  @Override
  public String getFilter() {
    return "tcucad@FIRE.CA.GOV";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD Page")) return false;
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1);
    data.strPlace = getOptGroup(match.group(2));
    parseAddress(match.group(3).trim(), data);
    data.strCity = match.group(4).replace('_', ' ').trim();
    data.strMap = match.group(5).trim();
    data.strGPSLoc = cvtGPSCoord(match.group(6), match.group(7)) + ' ' + cvtGPSCoord(match.group(8), match.group(9));
    data.strCall = match.group(10).trim();
    data.strUnit = match.group(11).trim();
    
    return true;
  }

  private String cvtGPSCoord(String degree, String minute) {
    double dDegree = (float)Integer.parseInt(degree);
    double dMinute = Double.parseDouble(minute);
    double value = dDegree + Math.signum(dDegree)*dMinute/60.;
    return String.format("%8.6f", value);
  }
}
