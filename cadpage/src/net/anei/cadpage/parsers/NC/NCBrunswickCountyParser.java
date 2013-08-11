package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernPlusParser;
/**
 * Brunswick County, NC
 */
public class NCBrunswickCountyParser extends DispatchSouthernPlusParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("\\d+:(\\d\\d-\\d{6}), +(.*)");
  
  public NCBrunswickCountyParser() {
    super(CITY_LIST, "BRUNSWICK COUNTY", "NC", 
          DSFLAG_OPT_DISPATCH_ID | DSFLAG_LEAD_PLACE | DSFLAG_NO_NAME_PHONE);
  }
  
  @Override
  public String getFilter() {
    return "pagegate@brunswickes.com,vtext.com@returns.groups.yahoo.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    subject = subject.trim();
    if (subject.startsWith("[") && subject.endsWith("]")) {
      data.strSource = subject.substring(1,subject.length()-1).trim();
      subject = "";
    }
    
    Matcher match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strCallId = match.group(1);
      data.strPlace = match.group(2);
      return true;
    }
    
    return super.parseMsg(subject, body,  data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private static final String[] CITY_LIST = new String[]{
    "LOCKWOODS FOLLY",
    "NORTHWEST",
    "SHALLOTTE",
    "SMITHVILLE",
    "TOWN CREEK",
    "WACCAMAW",

    "BALD HEAD ISLAND",
    "BELVILLE",
    "BOILING SPRING LAKES           ",
    "BOLIVIA",
    "CALABASH",
    "CAROLINA SHORES",
    "CASWELL BEACH",
    "HOLDEN BEACH",
    "LELAND",
    "NAVASSA",
    "NORTHWEST",
    "OAK ISLAND",
    "OCEAN ISLE BEACH",
    "SANDY CREEK",
    "SHALLOTTE",
    "SOUTHPORT",
    "ST JAMES",
    "SUNSET BEACH",
    "VARNAMTOWN",

    "ANTIOCH",
    "ASH",
    "BATARORA",
    "BELL SWAMP",
    "BISHOP",
    "BIVEN",
    "BONAPARTE LANDING",
    "BOONES NECK",
    "BOWENSVILLE",
    "BRUNSWICK STATION",
    "CAMP BRANCH",
    "CEDAR GROVE",
    "CEDAR HILL",
    "CIVIETOWN",
    "CLAIRMONT",
    "CLARENDON",
    "COOLVALE",
    "DOE CREEK",
    "EASTBROOK",
    "EASY HILL",
    "PINEY GROVE",
    "SUPPLY",
    "SUNSET HARBOR",
    "WINNABOW",
  };

}
