package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Lebanon County, PA
 */
public class PALebanonCountyParser extends SmartAddressParser {
  
  private static final Pattern COUNTY_PREFIX_PTN = Pattern.compile("^(DAUPHIN|LANCASTER)(?: CO(?:UNTY)?)?[ /]", Pattern.CASE_INSENSITIVE);
  private static final Pattern[] CITY_PTNS = new Pattern[]{
    Pattern.compile("^(.* Township)[ =]", Pattern.CASE_INSENSITIVE),
    Pattern.compile("^(.* Twp)[ =]", Pattern.CASE_INSENSITIVE),
    Pattern.compile("^City of ([^ ]*)[ =]", Pattern.CASE_INSENSITIVE),
    Pattern.compile("^(.*) Borough[ =]", Pattern.CASE_INSENSITIVE),
    Pattern.compile("^(.*) Boro[ =]", Pattern.CASE_INSENSITIVE)
  };
  private static final Pattern SPECIAL_CITY_PTN = Pattern.compile("^((?:(?:NORTH|SOUTH|EAST|WEST) )?[A-Z]+)[ =]", Pattern.CASE_INSENSITIVE);
  private static final Pattern CALL_PREFIX_PTN =
      Pattern.compile(" (?:Med Class(\\d) |([A-Z]{2,6} ?- ?))");
  private static final Pattern BOX_PTN = 
      Pattern.compile(" (?:(?:Box|BOX) ?([0-9\\-]+)|Fire-Box ([0-9\\-]+) EMS-Box ([0-9\\-]+)|Fire-Box EMS-Box)");
  private static final Pattern TAIL_CLASS_PTN = Pattern.compile("^Class (\\d) for EMS ");
  private static final Pattern UNIT_PTN = Pattern.compile(" +([A-Z]+[0-9]+(?:-[0-9]+){0,2}|[0-9]+[A-Z]+|FG[ -]?\\d)$", Pattern.CASE_INSENSITIVE);

  public PALebanonCountyParser() {
    super("LEBANON COUNTY", "PA");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_ADD_DEFAULT_CNTY;
  }

  @Override 
  public boolean parseMsg(String body, Data data) {
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    // See if a county has been specified
    String county = null;
    Matcher match = COUNTY_PREFIX_PTN.matcher(body);
    if (match.find()) {
      county = match.group(1);
      body = body.substring(match.end());
    }

    
    // Look for city, borough, or township at start of text
    String city = "";
    if (data.strCity.length() == 0) {
      for (Pattern ptn : CITY_PTNS) {
        match = ptn.matcher(body);
        if (match.find()) {
          city = match.group(1);
          body = body.substring(match.end()).trim();
          break;
        }
      }
    }
    
    // If we found something, see if it is followed by a county qualifier
    if (city.length() > 0) {
      if (county == null) {
        match = COUNTY_PREFIX_PTN.matcher(body);
        if (match.find()) {
          county = match.group(1);
          body = body.substring(match.end()).trim();
        }
      }
    }
    
    // if we did not find a city, but there was a county prefix in front of it
    // we get a bit less strict about what qualifies as a city
    else if (county != null) {
      match = SPECIAL_CITY_PTN.matcher(body);
      if (match.find()) {
        city = match.group(1);
        body = body.substring(match.end()).trim();
      }
    }
    
    // Finally put it all together
    if (county != null) {
      city = append(city, ", ", county + " COUNTY");
    }
    data.strCity = city.toUpperCase();
    
    match = CALL_PREFIX_PTN.matcher(body);
    if (!match.find()) return false;
    String sAddress = body.substring(0,match.start()).trim();
    data.strPriority = getOptGroup(match.group(1));
    String sCallPfx = match.group(2);
    String sTail = body.substring(match.end());

    String sCall;
    match = BOX_PTN.matcher(sTail);
    if (! match.find()) {
      sCall = sTail;
      sTail = "";
    } else {
      sCall = sTail.substring(0,match.start()).trim();
      String sBox = match.group(1);
      if (sBox == null) {
        sBox = match.group(2);
        if (sBox != null) {
          sBox = "Fire:" + match.group(2) + " EMS:" + match.group(3);
        } else {
          sBox = "";
        }
      }
      data.strBox = sBox;
      sTail = sTail.substring(match.end()).trim();
    }
    data.strCall = (sCallPfx == null ? "" : sCallPfx) + sCall;
    
    pt = sAddress.indexOf('=');
    if (pt >= 0) {
      data.strPlace = sAddress.substring(pt+1).trim();
      sAddress = sAddress.substring(0,pt).trim();
      parseAddress(StartType.START_ADDR, FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, sAddress, data);
    } else {
      parseAddress(StartType.START_ADDR, FLAG_IMPLIED_INTERSECT, sAddress, data);
      data.strPlace = getLeft();
    }
    if (data.strPlace.startsWith ("AT ")) {
      data.strCross = data.strPlace.substring(3).trim();
      data.strPlace = "";
    } else if (data.strPlace.startsWith("* ")) {
      data.strPlace = data.strPlace.substring(2).trim();
    }
    
    match = TAIL_CLASS_PTN.matcher(sTail);
    if (match.find()) {
      data.strPriority = match.group(1);
      sTail = sTail.substring(match.end()).trim();
    }
    data.strUnit = sTail;
    
    // If there was no unit specified in tail section, try extracting it from end
    // of call description
    if (data.strUnit.length() == 0) {
      while (true) {
        match = UNIT_PTN.matcher(data.strCall);
        if (!match.find()) break;
        data.strUnit = append(match.group(1).toUpperCase(), " ", data.strUnit);
        data.strCall = data.strCall.substring(0,match.start()).trim();
      }
    }
    
    return true;
  }

}
