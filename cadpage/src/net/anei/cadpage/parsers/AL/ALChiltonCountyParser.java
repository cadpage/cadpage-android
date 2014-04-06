
package net.anei.cadpage.parsers.AL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernPlusParser;

/**
 * Chilton County, AL
 */

public class ALChiltonCountyParser extends DispatchSouthernPlusParser {
  
  private static final Pattern GENERAL_ALERT_PTN = Pattern.compile("Unit ([ A-Za-z0-9]+) Status Note: .* - (\\d+) -.*");
  private static final Pattern ADDR_EXIT_PTN = Pattern.compile("(\\d+ +EXIT) +(.*)");

  public ALChiltonCountyParser() {
    super(CITY_LIST, "CHILTON COUNTY", "AL", DSFLAG_LEAD_PLACE);
    setupMultiWordStreets(
        "COUNTRY CLUB",
        "POPLAR SPRINGS");
    
    
  }
  @Override
  public String getFilter() {
    return "dispatch@chiltoncounty.org,dispatch@dispatch.ccso911.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = GENERAL_ALERT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "GENERAL ALERT";
      data.strUnit = match.group(1).trim();
      data.strCallId = match.group(2);
      data.strPlace = body;
      return true;
    }
    
    body = body.replace('\\', '/');
    body = body.replaceAll("\\bCOUNTY RD\\b", "CO");
    if (body.startsWith("/")) body = body.substring(1).trim();
    if (! super.parseMsg(subject, body, data)) return false;
    
    data.strAddress = data.strAddress.replaceAll("\\bCO\\b", "COUNTY RD");
    
    match = ADDR_EXIT_PTN.matcher(data.strAddress);
    if (match.matches()) {
      data.strPlace = append(data.strPlace, " ", match.group(1));
      data.strAddress = match.group(2).trim();
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "CLANTON",
    "ISABELLA",
    "JEMISON",
    "MAPLESVILLE",
    "MOUNTAIN CREEK",
    "STANTON",
    "THORSBY",
    "VERBENA",
    "BILLINGSLEY", 
    
    // Autauga County
    "MARBURY",
    
    // Bibb County
    "RANDOLPH",
    
    // Shelby County
    "CALERA",
    "MONTEVALLO"
  };
}
