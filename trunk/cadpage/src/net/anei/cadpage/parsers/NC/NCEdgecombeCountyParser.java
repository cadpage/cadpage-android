package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NCEdgecombeCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("Edgecombe(?:911|Central):(.*?)(?: +CODE (\\d+))? +([A-Z0-9,]+)");
  
  public NCEdgecombeCountyParser() {
    super(CITY_LIST, "EDGECOMBE COUNTY", "NC");
    setFieldList("ADDR APT CITY CALL PRI UNIT");
  }
  
  @Override
  public String getFilter() {
    return "@co.edgecombe.nc.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    body = match.group(1).trim();
    data.strPriority = getOptGroup(match.group(2));
    data.strUnit = match.group(3);
    
    parseAddress(StartType.START_ADDR, body, data);
    data.strCall = getLeft();
    return (data.strCall.length() > 0);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return CH_PTN.matcher(addr).replaceAll("CHURCH");
  }
  private static final Pattern CH_PTN = Pattern.compile("\\bCH\\b");
  
  private static final String[] CITY_LIST = new String[]{
    "BATTLEBORO",
    "CONETOE",
    "LEGGETT",
    "MACCLESFIELD",
    "PINETOPS",
    "PRINCEVILLE",
    "ROCKY MOUNT",
    "SHARPSBURG",
    "SPEED",
    "TARBORO",
    "WHITAKERS",
    "HOUSEVILLE",
    
    "TARBORO TWP",
    "LOWER CONETOE TWP",
    "UPPER CONETOE TWP",
    "DEEP CREEK TWP",
    "LOWER FISHING CREEK TWP",
    "UPPER FISHING CREEK TWP",
    "SWIFT CREEK TWP",
    "SPARTA TWP",
    "OTTER CREEK TWP",
    "LOWER TOWN CREEK TWP",
    "WALNUT CREEK TWP",
    "ROCKY MOUNT TWP",
    "COKEY TWP",
    "UPPER TOWN CREEK TWP"
  };
}
