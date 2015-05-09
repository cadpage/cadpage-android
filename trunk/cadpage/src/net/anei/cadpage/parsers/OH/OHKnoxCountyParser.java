package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHKnoxCountyParser extends DispatchEmergitechParser {
  
  public OHKnoxCountyParser() {
    super(null, new int[]{59,60}, CITY_LIST, "KNOX COUNTY", "OH");
    addSpecialWords("HYATT");
    
  }

  @Override
  public String getFilter() {
    return "Dispatch@smtp-server.Columbus.rr.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // We have to do a lot of massaging to get the message back to standard form
    // including recovering a square bracket unit that might have been interpreted
    // as the message subject
    if (body.startsWith("Dispatch:")) {
      body = body.substring(9).trim();
      body = stripFieldStart(body, "MSG:");
      body = stripFieldStart(body, "-");
    }
    else if (subject.length() > 0) body = '[' + subject + ']' + body;
    
    // Fix some word breaks the basic logic won't catch
    body = body.replace(" SP ARTA ", " SPARTA ");
    body = body.replace(" FREDERICKTOW N ", " FREDERICKTOWN ");
    
    // M/A for mutual aid tends to get into the address, which messes things up
    body = body.replace(" M/A ", " MA ");

    if (!super.parseMsg(body, data)) return false;
    
    // Access instructions end up in the name field
    if (data.strCross.length() == 0 && data.strName.startsWith("ACCESS ")) {
      data.strCross = data.strName;
      data.strName = "";
    }
    
    // Address needs a lot of repair work.
    // The never appear to put a place name in front of the address, so if we find one
    // merge it back into the address
    if (data.strPlace.length() > 0) {
      String addr = append(data.strPlace, " ", data.strAddress);
      data.strPlace = "";
      data.strAddress = "";
      parseAddress(addr, data);
    }
    
    // And township and county road numbers tend to fall into the apartment field
    if (ADDR_TWP_RD_PTN.matcher(data.strAddress).matches()) {
      Matcher match = APT_TWP_RD_PTN.matcher(data.strApt);
      if (match.matches()) {
        data.strAddress = data.strAddress + ' ' +  match.group(1);
        data.strApt = match.group(2);
      }
    }
    
    // If Mutual aid got into address, move it to call
    if (data.strAddress.endsWith(" MA")) {
      data.strAddress = data.strAddress.substring(0, data.strAddress.length()-3).trim();
      data.strCall = "MA - " + data.strCall;
    }
    
    // If we did not find a proper city, see if we can get one from the start of the info section
    if (data.strCity.length() == 0) {
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, data.strSupp, data);
    }
    
    return true;
  }
  
  private static final Pattern ADDR_TWP_RD_PTN = Pattern.compile("\\d+ +(?:TWP +)?RD");
  private static final Pattern APT_TWP_RD_PTN = Pattern.compile("(\\d+)\\b *(.*)");
  
  private static final String[] CITY_LIST = new String[]{

    "MOUNT VERNON",
    "MT VERNON",

    "CENTERBURG",
    "DANVILLE",
    "FREDERICKTOWN",
    "GAMBIER",
    "GANN",
    "MARTINSBURG",
    "UTICA",

    "BERLIN TWP",
    "BROWN TWP",
    "BUTLER TWP",
    "CLAY TWP",
    "CLINTON TWP",
    "COLLEGE TWP",
    "HARRISON TWP",
    "HILLIAR TWP",
    "HOWARD TWP",
    "JACKSON TWP",
    "JEFFERSON TWP",
    "LIBERTY TWP",
    "MIDDLEBURY TWP",
    "MILFORD TWP",
    "MILLER TWP",
    "MONROE TWP",
    "MORGAN TWP",
    "MORRIS TWP",
    "PIKE TWP",
    "PLEASANT TWP",
    "UNION TWP",
    "WAYNE TWP",

    "BANGS",
    "BLADENSBURG",
    "HOWARD",
    "MOUNT LIBERTY",
    
    // Richland County
    "PERRY TWP",
    
    // Coshocton County
    "BEDFORD TWP",
    
    // Licking County
    "HARTFORD",
    
    // Counties
    "ASHLAND COUNTY",
    "COSHOCTON COUNTY",
    "DELAWARE COUNTY",
    "HOLEMS COUNTY",
    "LICKING COUNTY",
    "MORROW COUNTY",
    "RICHLAND COUNTY"
  };
}
