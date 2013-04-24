package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchGlobalDispatchParser;



public class MOOsageCountyParser extends DispatchGlobalDispatchParser {
  
  private static final Pattern UNIT_PTN = Pattern.compile("(?: +(?:[A-Z]+\\d+|RDC|RDL|RDL \\d|701|8[89]\\d|[A-Z]{1,4}FD))+$");
  private static final Pattern DASH_DIR_PTN = Pattern.compile("- *([NSEW]|[NS][EW])\\b");
  private static final Pattern CROSS_UNIT_PTN = Pattern.compile("(.* (?:[NSEW]|[NS][EW]))\\b *(.*)");
  
  public MOOsageCountyParser() {
    super(CITY_LIST, "OSAGE COUNTY", "MO", PLACE_FOLLOWS_ADDR);
  }
  
  @Override
  public String getFilter() {
    return "central@fidmail.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.trim().equals("Osage County EOC")) return false;
    if (!body.contains(" CrossStreets:")) {
      Matcher match = UNIT_PTN.matcher(body);
      if (match.find()) {
        data.strUnit = match.group().trim();
        body = body.substring(0,match.start());
      }
    }
    
    body = DASH_DIR_PTN.matcher(body).replaceAll("$1");
    
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equals("OSAGE COUNTY")) data.strCity = "";
    
    // Split off unit info from cross street
    Matcher match = CROSS_UNIT_PTN.matcher(data.strCross);
    String sUnit;
    if (match.matches()) {
      data.strCross = match.group(1);
      sUnit = match.group(2);
    } else {
      sUnit = data.strCross;
      data.strCross = "";
    }
    data.strUnit = append(data.strUnit, " ", sUnit);
    
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ARGYLE",
    "BELLE",
    "BONNOTS MILL",
    "CHAMOIS",
    "FOLK",
    "FRANKENSTEIN",
    "FREEBURG",
    "KOELTZTOWN",
    "LINN",
    "LOOSE CREEK",
    "META",
    "RICH FOUNTAIN",
    "WESTPHALIA",
    
    "OSAGE COUNTY"
  };
}
