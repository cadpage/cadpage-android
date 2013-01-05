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
  
  private static final Pattern MARKER = Pattern.compile("(?:(.*?)([^A-Z0-9]{1,3}))?\\bDispatched([^A-Z0-9]{1,3})(?=[A-Z0-9])");
  private static final Pattern CODE_PTN = Pattern.compile("^(\\d\\d[A-Z]\\d\\d) ?- ?");
  private static final Pattern OUTSIDE = Pattern.compile("\\bOUTSIDE\\b");
  private static final Pattern KNLS = Pattern.compile("\\bKNLS\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern NEAR_PTN = Pattern.compile("[/;]? *(Near:.*)");
  
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

    // Format always has some field delimiters, but they
    // seem to change with the phase of the moon. There is always a "Dispatched"
    // field followed by a delimiter, followed (hopefully) by a alphnumeric character.
    // so we use this pattern to find and identify the delimiter
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    
    // The delimiter preceding and following the Dispatched term should be the same
    // If they are not, see if we can reduce them to a common delimiter by removing
    // whitespace.  If we cannot do that, return failure
    String delimA = match.group(2);
    String delim = match.group(3);
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
      int maxFlds = body.startsWith("Dispatched") ? 3 : 4;
      flds = body.split(delim, maxFlds);
    }

    // If the identified delimiter was a single blank, we will use the smart
    // address parser to find the break between the call and the first address
    else {
      
      List<String> fldList = new ArrayList<String>();
      String prefix = match.group(1);
      if (prefix != null) fldList.add(prefix.trim());
      fldList.add("Dispatched");
      
      String sCall, sAddr;
      body = body.substring(match.end()).trim();
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

    
    // Check for and remove OUTSIDE from city
    match = OUTSIDE.matcher(data.strCity);
    if (match.find()) data.strCity = data.strCity.substring(0,match.start()).trim();
    data.strCity = expandCity(data.strCity);
    if (data.strCity.endsWith(" VILLAGE")) data.strCity = data.strCity.substring(0,data.strCity.length()-8).trim();
    if (data.strCity.equals("ONEIDA COUNTY")) data.strCity = "";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "CODE " + super.getProgram() + " INFO";
  }
    
  /*
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
    
    data.strCross = data.strCross.replace(",", " /").trim();
    return true;
  */
  
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
