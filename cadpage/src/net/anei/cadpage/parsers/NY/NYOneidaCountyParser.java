package net.anei.cadpage.parsers.NY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;



public class NYOneidaCountyParser extends DispatchA13Parser {
  
  private static final Pattern REMSEN_FIRE_PTN1 = Pattern.compile("\\d{4} >.*");
  private static final Pattern MARKER = Pattern.compile("(?:(.*?)([^A-Z0-9]{1,3}))?\\b(Dispatched|Acknowledge|Enroute|En Route Hosp|On +Scene)([^A-Z0-9]{1,3})(?=[A-Z0-9])");
  private static final Pattern CODE_PTN = Pattern.compile("^(\\d\\d[A-Z]\\d\\d) ?- ?");
  private static final Pattern KNLS = Pattern.compile("\\bKNLS\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern NEAR_PTN = Pattern.compile("[/;]? *(Near:.*)");
  private static final Pattern REAL_APT_PTN = Pattern.compile("(?:FLR|BLDG).*");
  
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
    
    body = stripFieldEnd(body, "#[0-0]");
    
    // Check for truncated city at end of line
    int pt = body.lastIndexOf(',');
    String newCity = body.substring(pt+1).trim();
    newCity = expandCity(newCity);
    if (newCity != null) body = body.substring(0,pt+1) + ' ' + newCity;
    
    // As if things weren't bad enough, we also have to deal with IAR alterations
    // Fortunately this all seems to be limited to one agency for now
    if (body.startsWith(">")) body = "Dispatched " + body;
    else if (subject.equals("Remsen Fire")) {
      if (REMSEN_FIRE_PTN1.matcher(body).matches()) body = ':' + body;
      else if (body.startsWith("d >")) body = "Dispatche" + body;
      else if (body.contains(" >")) body = "Dispatched >" + body;
    }

    // Format always has some field delimiters, but they
    // seem to change with the phase of the moon. There is always a "Dispatched"
    // field followed by a delimiter, followed (hopefully) by a alphanumeric character.
    // so we use this pattern to find and identify the delimiter
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    
    // The delimiter preceding and following the Dispatched term should be the same
    // If they are not, see if we can reduce them to a common delimiter by removing
    // whitespace.  If we cannot do that, return failure
    String delimA = match.group(2);
    String status = match.group(3);
    String delim = match.group(4);
    if (delimA != null && !delimA.equals(delim)) {
      delimA = delimA.trim();
      delim = delim.trim();
      if (delim.length() == 0 || !delim.equals(delimA)) return false;
    }
    
    // If we identified a delimiter that is something other than a single
    // blank, use it to break the rest of the page into a call and an address
    // portion
    String[] flds;
    if (!delim.equals(" ")) {
      int maxFlds = body.startsWith(status) ? 3 : 4;
      flds = body.split(delim, maxFlds);
    }

    // If the identified delimiter was a single blank, we will use the smart
    // address parser to find the break between the call and the first address
    else {
      
      List<String> fldList = new ArrayList<String>();
      String prefix = match.group(1);
      if (prefix != null) fldList.add(prefix.trim());
      fldList.add(status);
      
      String sCall, sAddr;
      body = body.substring(match.end()).trim();
      pt = body.indexOf('@');
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
      
      fldList.add(sCall);
      fldList.add(sAddr);
      flds = fldList.toArray(new String[fldList.size()]);
    } 
    
    if (!parseFields(flds, data)) return false;
    
    // Separate call code from call field
    match = CODE_PTN.matcher(data.strCall);
    if (match.find()) {
      data.strCode = match.group(1);
      data.strCall = data.strCall.substring(match.end()).trim();
    }
    
    // Clean up address
    data.strAddress = KNLS.matcher(data.strAddress).replaceAll("KNOLLE");
    
    // They sometimes put near: info in cross street field
    match = NEAR_PTN.matcher(data.strCross);
    if (match.find()) {
      data.strCross = data.strCross.substring(0,match.start()).trim();
      data.strSupp = match.group(1);
    }
    
    // See if the apt field looks more like a place name
    if (data.strPlace.length() == 0 && data.strApt.length() >= 8 &&
        !REAL_APT_PTN.matcher(data.strApt).matches()) {
      data.strPlace = data.strApt;
      data.strApt = "";
    }

    
    // Check for and remove OUTSIDE from city
    data.strCity = stripFieldEnd(data.strCity, " NY");
    data.strCity = stripFieldEnd(data.strCity, " VILLAGE");
    data.strCity = stripFieldEnd(data.strCity, " VILLA");
    data.strCity = stripFieldEnd(data.strCity, " OUTSIDE");
    data.strCity = stripFieldEnd(data.strCity, " INSIDE");
    if (data.strCity.equals("ONEIDA COUNTY")) data.strCity = "";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC CODE " + super.getProgram() + " INFO";
  }
  
  /**
   * Expand a possibly abbreviated city
   * @param sPart3 possibly abbreviated city
   * @return restored city
   */
  private String expandCity(String city) {
    if (city.length() == 0) return null;
    city = city.toUpperCase();
    SortedSet<String> set = CITY_SET.tailSet(city);
    if (set.isEmpty()) return null;
    String result = set.first();
    if (!result.startsWith(city)) return null;
    if (result.length() == city.length()) return null;
    return result;
  }
  
  private TreeSet<String> CITY_SET = new TreeSet<String>(Arrays.asList(CITY_LIST));

  private static final String[] CITY_LIST = new String[]{
    "ANNSVILLE",
    "AUGUSTA",
    "AVA",
    "BARNEVELD",
    "BARNEVELD VILLAGE",
    "BOONVILLE",
    "BOONVILLE VILLAGE",
    "BRIDGEWATER",
    "BRIDGEWATER VILLAGE",
    "BROOKFIELD",
    "CAMDEN",
    "CAMDEN VILLAGE",
    "CLARK MILLS",
    "CLAYVILLE",
    "CLAYVILLE VILLAGE",
    "CLINTON",
    "CLINTON VILLAGE",
    "DEERFIELD",
    "FLORENCE",
    "FLOYD",
    "FORESTPORT",
    "HOLLAND PATENT",
    "HOLLAND PATENT VILLA",
    "HOLLAND PATENT VILLAGE",
    "KIRKLAND",
    "LEE",
    "MARCY",
    "MARSHALL",
    "MCCONNELLSVILLE",
    "MCCONNELLSVILLE VILLAGE",
    "N BROOKFIELD",
    "NEW HARTFORD",
    "NEW HARTFORD VILLAGE",
    "NEW YORK MILLS",
    "NEW YORK MILLS VILLAGE",
    "ONEIDA CASTLE",
    "ONEIDA CASTLE VILLAGE",
    "ORISKANY",
    "ORISKANY VILLAGE",
    "ORISKANY FALLS",
    "ORISKANY FALLS VILLAGE",
    "PARIS",
    "PROSPECT",
    "PROSPECT VILLAGE",
    "REMSEN",
    "REMSEN VILLAGE",
    "ROME",
    "ROME INSIDE",
    "ROME OUTSIDE",
    "SANGERFIELD",
    "SHERRILL",
    "SHERRILL CITY",
    "STEUBEN",
    "SYLVAN BEACH",
    "SYLVAN BEACH VILLAGE",
    "TRENTON",
    "UTICA",
    "VERNON",
    "VERNON VILLAGE",
    "VERONA",
    "VIENNA",
    "WATERVILLE",
    "WATERVILLE VILLAGE",
    "WESTERN",
    "WESTMORELAND",
    "WHITESBORO",
    "WHITESBORO VILLAGE",
    "WHITESTOWN",
    "YORKVILLE",
    "YORKVILLE VILLAGE",
    
    "ANNSVILLE NY",
    "AUGUSTA NY",
    "AVA NY",
    "BARNEVELD NY",
    "BARNEVELD VILLAGE NY",
    "BOONVILLE NY",
    "BOONVILLE VILLAGE NY",
    "BRIDGEWATER NY",
    "BRIDGEWATER VILLAGE NY",
    "BROOKFIELD NY",
    "CAMDEN NY",
    "CAMDEN VILLAGE NY",
    "CLARK MILLS NY",
    "CLAYVILLE NY",
    "CLAYVILLE VILLAGE NY",
    "CLINTON NY",
    "CLINTON VILLAGE NY",
    "DEERFIELD NY",
    "FLORENCE NY",
    "FLOYD NY",
    "FORESTPORT NY",
    "HOLLAND PATENT NY",
    "HOLLAND PATENT VILLA NY",
    "HOLLAND PATENT VILLAGE NY",
    "KIRKLAND NY",
    "LEE NY",
    "MARCY NY",
    "MARSHALL NY",
    "MCCONNELLSVILLE NY",
    "MCCONNELLSVILLE VILLAGE NY",
    "N BROOKFIELD NY",
    "NEW HARTFORD NY",
    "NEW HARTFORD VILLAGE NY",
    "NEW YORK MILLS NY",
    "NEW YORK MILLS VILLAGE NY",
    "ONEIDA CASTLE NY",
    "ONEIDA CASTLE VILLAGE NY",
    "ORISKANY NY",
    "ORISKANY VILLAGE NY",
    "ORISKANY FALLS NY",
    "ORISKANY FALLS VILLAGE NY",
    "PARIS NY",
    "PROSPECT NY",
    "PROSPECT VILLAGE NY",
    "REMSEN NY",
    "REMSEN VILLAGE NY",
    "ROME NY",
    "ROME INSIDE NY",
    "ROME OUTSIDE NY",
    "SANGERFIELD NY",
    "SHERRILL NY",
    "SHERRILL CITY NY",
    "STEUBEN NY",
    "SYLVAN BEACH NY",
    "SYLVAN BEACH VILLAGE NY",
    "TRENTON NY",
    "UTICA NY",
    "VERNON NY",
    "VERNON VILLAGE NY",
    "VERONA NY",
    "VIENNA NY",
    "WATERVILLE NY",
    "WATERVILLE VILLAGE NY",
    "WESTERN NY",
    "WESTMORELAND NY",
    "WHITESBORO NY",
    "WHITESBORO VILLAGE NY",
    "WHITESTOWN NY",
    "YORKVILLE NY",
    "YORKVILLE VILLAGE NY",
    
    // Madison County
    "CANASTOTA VILLAGE"
  };
}
