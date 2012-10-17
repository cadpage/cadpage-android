package net.anei.cadpage.parsers.MD;


import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MDAnneArundelCountyEMSParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "MD";
  private static final String DEF_CITY = "ANNE ARUNDEL COUNTY";
  
  private static final Pattern MARKER = Pattern.compile("^\\*?(?:MEDICAL|Medical|Local|HazMat|Still|Box) (?:BOX|Box|Alarm) (\\d{1,2}-[A-Z0-9]{1,3}) ");
  private static final Pattern T_MARKER = Pattern.compile("\\[\\d{1,2}/\\d{1,3}\\]");
  private static final Pattern OPEN_DELIM = Pattern.compile("\\(|\\[");
  private static final Pattern MAP1 = Pattern.compile(" (\\d{1,2}-[A-Z]\\d{1,2}) ");
  private static final Pattern MAP2 = Pattern.compile("\\d{1,2}-[A-Z]\\d{1,2}");
  private static final Pattern MAP3 = Pattern.compile("\\d{2,4}[A-Z]\\d");
  private static final Pattern T_MARKER2 = Pattern.compile(";? (\\d{4})\\b");

  public MDAnneArundelCountyEMSParser() {
    super(DEF_CITY, DEF_STATE);
  }
  
  @Override
  public String getFilter() {
    return "@aacounty.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Check for starting signature
    Matcher match = MARKER.matcher(body);
    if (! match.find()) return false;
    data.strBox = match.group(1);
    body = body.substring(match.end()).trim();
    
    // End signature is optional, but we need to get rid of it lest it
    // confuse the bracket logic that follows
    match = T_MARKER.matcher(body);
    if (match.find()) body = body.substring(0, match.start()).trim();
    
    // OK, there are two ways to go from here.  If we find a open paren or square 
    // bracket, that definitively marks the end of the address.  Exception, 
    // ignore (HOT) or (COLD) indicators that presumably part of the description
    match = OPEN_DELIM.matcher(body);
    boolean found = match.find();
    if (found) {
      String test = body.substring(match.start());
      if (test.startsWith("(HOT)") || test.startsWith("(COLD)")) found = false;
    }
    if (found) {
      int ipt = match.start();
      String sAddr = body.substring(0,ipt).trim();
      int pt = sAddr.indexOf("- btwn ");
      if (pt >= 0) {
        data.strCross = sAddr.substring(pt+7).trim();
        sAddr = sAddr.substring(0,pt).trim();
      }
      parseAddrCity(sAddr, data);
      body = body.substring(ipt);
      
      // Following the address, we may find a place name in square brackets or
      // a cross street in parenthesis.  In either order
      while (body.length() > 0) {
        char stch = body.charAt(0);
        char endch = 0;
        if (stch == '(') endch=')';
        else if (stch == '[') endch = ']';
        else break;
        Parser p = new Parser(body.substring(1));
        String fld = p.get(endch).trim();
        body = p.get();
        
        if (stch == '(') {
          if (MAP3.matcher(fld).matches()) {
            data.strMap = fld;
          } else {
            data.strCross = append(data.strCross, " & ", fld);
          }
        } else {
          if (fld.startsWith("Unit ")) {
            data.strApt = fld.substring(5).trim();
          } else {
            data.strPlace = append(data.strPlace," - ", fld);
          }
        }
      }
    }
    
    // No brackets, maybe we can find a map indicator, which would mark the end
    // of the address
    else if ((match = MAP1.matcher(body)).find()) {
      parseAddrCity(body.substring(0,match.start()).trim(), data);
      body = body.substring(match.start()).trim();
    }
    
    // If we didn't find a bracket terminator or map code, we will have to rely
    // on the smart parser to find the address
    else {
      parseAddress(StartType.START_ADDR, body, data);
      body = getLeft();
      if (body.startsWith(",")) {
        body = body.substring(2).trim();
        int pt = body.indexOf(' ');
        if (pt < 0) pt = body.length();
        data.strCity = convertCodes(body.substring(0,pt).trim(), CITY_CODES);
        body = body.substring(pt+1).trim();
      }
    }
    
    // We aren't done yet.
    // This might be followed by map code, or by a camel case priority
    // In any case the next item will be a unit designation
    // We'll identify the camel case name if the second character is lower case
    Parser p = new Parser(body);
    String token = p.get(' ');
    if ((match = MAP2.matcher(token)).matches()) {
      data.strMap = token;
      token = p.get(' ');
    }
    
    if (token.length() >= 2 && Character.isLowerCase(token.charAt(1))) {
      data.strChannel = token;
      token = p.get(' ');
    }
    data.strUnit = token;
    body = p.get();
    
    // Anything left up to a possible trailing marker is the call description
    match = T_MARKER2.matcher(body);
    if (match.find()) {
      String sTime = match.group(1);
      data.strTime = sTime.substring(0,2) + ":" + sTime.substring(2,4);
      data.strSupp = new Parser(body.substring(match.end()).trim()).get('[');
      if (data.strSupp.equals("...")) data.strSupp = "";
      body = body.substring(0, match.start()).trim();
    }
    data.strCall = body;

    return true;
  }

  /**
   * Parse address and city
   * @param sAddr address and city line
   * @param data data object
   */
  private void parseAddrCity(String sAddr, Data data) {
    int pt = sAddr.lastIndexOf(',');
    if (pt >= 0) {
      data.strCity = convertCodes(sAddr.substring(pt+1).trim(), CITY_CODES);
      sAddr = sAddr.substring(0,pt).trim();
    }
    parseAddress(sAddr, data);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CR", "CROFTON",
      "CV", "CROWNSVILLE",
      "DV", "DAVIDSONVILLE",
      "GM", "GAMBRILLS",
      "HA", "HANOVER",
      "HN", "HANOVER",
      "MV", "MILLERSVILLE",
      "OD", "ODENTON",
      "SV", "SEVENRN",
  });
}
