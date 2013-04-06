package net.anei.cadpage.parsers.ND;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NDCassCountyParser extends SmartAddressParser {
  
  private static final Pattern DATE_TIME_CFS_PTN = Pattern.compile("(\\d\\d/\\d\\d/\\d\\d) (\\d\\d:\\d\\d) CFS #: (\\d+) ");
  private static final Pattern UNIT_PTN = Pattern.compile("(?: \\d{3}| \\d{4}-[A-Z]+)+$");
 
  public NDCassCountyParser() {
    super(CITY_CODES, "CASS COUNTY", "ND");
    setFieldList("CALL ADDR APT CITY PLACE DATE TIME ID INFO UNIT");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@rrrdc.or";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = DATE_TIME_CFS_PTN.matcher(body);
    if (!match.find()) return false;
    data.strDate = match.group(1);
    data.strTime = match.group(2);
    data.strCallId = match.group(3);
    String sAddr = body.substring(0,match.start()).trim();
    String sInfo = body.substring(match.end()).trim();
    
    parseAddress(StartType.START_CALL, FLAG_IMPLIED_INTERSECT, sAddr, data);
    String sPlace = getLeft();
    int pt = sPlace.indexOf(" - ");
    if (pt >= 0) sPlace = sPlace.substring(0,pt).trim();
    if (sPlace.length() <= 1) sPlace = "";
    data.strPlace = sPlace;
    
    match = UNIT_PTN.matcher(sInfo);
    if (match.find()) {
      data.strUnit = match.group().trim();
      sInfo = sInfo.substring(0,match.start()).trim();
    }
    for (String info : sInfo.split("Nature Of Call:")) {
      info = info.trim();
      if (info.length() > data.strSupp.length()) data.strSupp = info;
    }
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AMEN",  "AMENIA",
      "CAST", "CASSELTON",
      "CHAF", "CHAFFEE",
      "LEON", "LEONARD",
      "WHEA", "WHEATLAND",
      
      "CASS", ""

  });
}
