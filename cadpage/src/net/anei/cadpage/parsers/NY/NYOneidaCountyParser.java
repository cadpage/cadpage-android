package net.anei.cadpage.parsers.NY;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYOneidaCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("(?:\\b(\\d+:\\d+\\b)[^A-Z0-9]+)?\\bDispatched([^A-Z0-9]{1,3})(?=[A-Z0-9])");
  private static final Pattern CODE_PTN = Pattern.compile("^(\\d\\d[A-Z]\\d\\d) ?- ?");
  private static final Pattern NY_PTN = Pattern.compile(", *NY$");
  private static final Pattern OUTSIDE = Pattern.compile("\\bOUTSIDE\\b");
  private static final Pattern KNLS = Pattern.compile("\\bKNLS\\b", Pattern.CASE_INSENSITIVE);
  
  public NYOneidaCountyParser() {
    super(CITY_LIST, "ONEIDA COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@ocgov.net,@oc911.org,messaging@iamresponding.com,777,888";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    data.strSource = subject;

    // Format usually, but not always, has some field delimiters, but they
    // seem to change with the phase of the moon. There is always a "Dispatched"
    // field followed by a delimiter, followed (hopefully) by a alphnumeric character.
    // so we use this pattern to find and identify the delimiter
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = getOptGroup(match.group(1));
    String delim = match.group(2);
    body = body.substring(match.end());
    
    // If we identified a delimiter that is something other than a single
    // blank, use it to break the rest of the page into a call and an address
    // portion
    String sCall, sAddr;
    if (!delim.equals(" ")) {
      int pt = body.indexOf(delim);
      if (pt < 0) return false;
      sCall = body.substring(0,pt).trim();
      sAddr = body.substring(pt+delim.length()).trim();
    }

    // If the identified delimiter was a single blank, we will use the smart
    // address parser to find the break between the call and the first address
    else {
      int pt = body.indexOf('@');
      if (pt >= 0) {
        sCall = body.substring(0,pt).trim();
        sAddr = body.substring(pt).trim();
      } else {
        pt = body.indexOf(',');
        int pt2 = body.indexOf('(');
        if (pt < 0) pt = body.length();
        if (pt2 < 0) pt2 = body.length();
        pt = Math.min(pt, pt2);
        while (pt > 0 && body.charAt(pt-1) == ' ') pt--;
        sAddr = body.substring(0,pt);
        String sExtra = body.substring(pt);
        Result res = parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, sAddr);
        if (res.getStatus() == 0) return false;
        sCall = res.getAddressPrefix();
        sAddr = res.getFullAddress();
        if (sCall == null || sAddr == null) return false;
        sAddr = sAddr + sExtra;
      }
    } 
    
    match = CODE_PTN.matcher(sCall);
    if (match.find()) {
      data.strCode = match.group(1);
      sCall = sCall.substring(match.end()).trim();
    }
    data.strCall = sCall;
    
    // Break address field into stuff before, inside, and after two sets of parenthesis
    Parser p = new Parser(sAddr);
    String sPart1 = p.get('(');
    String sPart2 = p.get(')');
    String sPart3 = p.get('(');
    String sPart4 = p.get(')');
    String sPart5 = p.get();
    
    // If first part starts with @, it contains a place name
    // and the second part is the address
    if (sPart1.startsWith("@")) {
      data.strPlace = sPart1.substring(1).trim();
      parseAddress(sPart2, data);
    }
    
    // Otherwise, first part is the address and city
    else {
      match = NY_PTN.matcher(sPart1);
      if (match.find()) sPart1 = sPart1.substring(0, match.start()).trim();
      sPart1 = KNLS.matcher(sPart1).replaceAll("KNOLLE");
      int pt = sPart1.indexOf(',');
      if (pt >= 0) {
        data.strCity = sPart1.substring(pt+1).trim();
        sPart1 = sPart1.substring(0,pt).trim();
        pt = data.strCity.indexOf('/');
        if (pt >= 0) {
          data.strCross = data.strCity.substring(pt+1).trim();
          data.strCity = data.strCity.substring(0,pt).trim();
        }
        parseAddress(sPart1, data);
      } else {
        parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sPart1, data);
      }
      
      // Second part is generally the cross street
      // It may have a New: place name and may have leading or trailing slash
      // or semicolon characters that need to be removed
      pt = sPart2.indexOf("Near:");
      if (pt >= 0) {
        data.strSupp = sPart2.substring(pt);
        sPart2 = sPart2.substring(0,pt).trim();
      }
      if (sPart2.startsWith("/")) sPart2 = sPart2.substring(1).trim();
      if (sPart2.endsWith(";")) sPart2 = sPart2.substring(0,sPart2.length()-1).trim();
      if (sPart2.endsWith("/")) sPart2 = sPart2.substring(0,sPart2.length()-1).trim();
      data.strCross = append(data.strCross, " & ", sPart2);
    }
    
    // If we get this far, part 3 contains a city if it starts with a comma
    // otherwise it contains additional information, as does part 4
    // With some safeguards against a truncated city name
    if (sPart3.startsWith(",")) {
      sPart3 = sPart3.substring(1).trim();
      if (data.strCity.length() == 0) data.strCity = sPart3;
      else data.strSupp = append(data.strSupp, " / ", sPart3);
    }
    data.strSupp = append(data.strSupp, " / ", sPart4);
    data.strSupp = append(data.strSupp, " / ", sPart5);
    
    // Check for and remove OUTSIDE from city
    match = OUTSIDE.matcher(data.strCity);
    if (match.find()) data.strCity = data.strCity.substring(0,match.start()).trim();
    data.strCity = expandCity(data.strCity);
    
    data.strCross = data.strCross.replace(",", " /").trim();
    return true;
  }
  
  /**
   * Expand a possibly abbreviated city
   * @param sPart3 possibly abbreviated city
   * @return restored city
   */
  private String expandCity(String city) {
    if (city.length() == 0) return city;
    city = city.toUpperCase();
    SortedSet<String> set = CITY_SET.tailSet(city);
    if (set.isEmpty()) return city;
    String result = set.first();
    if (!result.startsWith(city)) return city;
    return result;
  }
  
  private TreeSet<String> CITY_SET = new TreeSet<String>(Arrays.asList(CITY_LIST));

  private static final String[] CITY_LIST = new String[]{
    "ANNSVILLE",
    "AUGUSTA",
    "AVA",
    "BARNEVELD VILLAGE",
    "BOONVILLE",
    "BOONVILLE VILLAGE",
    "BRIDGEWATER",
    "BRIDGEWATER VILLAGE",
    "BROOKFIELD",
    "CAMDEN",
    "CAMDEN VILLAGE",
    "CLARK MILLS",
    "CLAYVILLE VILLAGE",
    "CLINTON VILLAGE",
    "DEERFIELD",
    "FLORENCE",
    "FLOYD",
    "FORESTPORT",
    "HOLLAND PATENT VILLAGE",
    "KIRKLAND",
    "LEE",
    "MARCY",
    "MARSHALL",
    "MCCONNELLSVILLE VILLAGE",
    "N BROOKFIELD",
    "NEW HARTFORD VILLAGE",
    "NEW HARTFORD",
    "NEW YORK MILLS VILLAGE",
    "ONEIDA CASTLE VILLAGE",
    "ORISKANY VILLAGE",
    "ORISKANY FALLS VILLAGE",
    "PARIS",
    "PROSPECT VILLAGE",
    "REMSEN VILLAGE",
    "REMSEN",
    "ROME",
    "SANGERFIELD",
    "SHERRILL",
    "STEUBEN",
    "SYLVAN BEACH VILLAGE",
    "TRENTON",
    "UTICA",
    "VERNON VILLAGE",
    "VERNON",
    "VERONA",
    "VIENNA",
    "WATERVILLE VILLAGE",
    "WESTERN",
    "WESTMORELAND",
    "WHITESBORO VILLAGE",
    "WHITESTOWN",
    "YORKVILLE VILLAGE",
    
    "ONEIDA COUNTY"
  };
}
