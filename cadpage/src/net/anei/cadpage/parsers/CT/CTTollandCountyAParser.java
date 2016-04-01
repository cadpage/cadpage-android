package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class CTTollandCountyAParser extends SmartAddressParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("[A-Z]+");
  private static final Pattern TIME_PTN = Pattern.compile("\\b\\d\\d:\\d\\d\\b");
  private static final Pattern ID_PTN = Pattern.compile("\\b\\d{4}-\\d{8}$");
  
  public CTTollandCountyAParser() {
    super(CTTollandCountyParser.CITY_LIST, "TOLLAND COUNTY", "CT");
    setFieldList("SRC ADDR APT CITY PLACE CALL TIME X ID");
    removeWords("COURT", "ROAD", "STREET", "TERRACE");
  }
  
  @Override
  public String getFilter() {
    return "@TollandCounty911.org,@TollandCounty911.com,messaging@iamresponding.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    do {
      
      if (subject.equals("TN Alert")) break;
      
      if (SUBJECT_PTN.matcher(subject).matches()) {
        data.strSource = subject;
        break;
      }
      
      if (body.startsWith("TN Alert / ")) {
        body = body.substring(11);
        break;
      }
      
      return false;
    } while (false);
    
    // We are invoking the smart address parser strictly to find city, it
    // shouldn't have to do much parsing.  If it doesn't find a city, bail out.
    // The slash confuses the parse logic, so switch it to something unusual
    // Ditto for parrens
    body = escape(body);
    parseAddress(StartType.START_ADDR, FLAG_EMPTY_ADDR_OK, body, data);
    if (data.strCity.length() == 0) return false;
    String sAddr = unescape(data.strAddress);
    data.strApt = unescape(data.strApt);
    body = unescape(getLeft());
    
    // Address always has a slash, which the address parser turned to an ampersand
    // What is in front of that becomes the address
    int pt = sAddr.indexOf('/');
    if (pt >= 0) {
      
      // Use smart address parser to extract trailing apt
      parseAddress(StartType.START_ADDR, FLAG_NO_CITY, sAddr.substring(0,pt).trim(), data);
      data.strApt = append(data.strApt, " - ", getLeft());
      
      sAddr = sAddr.substring(pt+1).trim();
      
      // if what comes after the slash is a street name, append it to address
      // If not, put it in the apt field
      Result res = parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sAddr);
      if (res.isValid()) {
        data.strAddress = append(data.strAddress, " & ", sAddr);
      } else {
        data.strApt = append(data.strApt, " - ", sAddr);
      }
    }
    
    // Once in a blue moon, the slash ends up in the apartment field
    else if (data.strApt.endsWith("/")) {
      data.strApt = data.strApt.substring(0,data.strApt.length()-1).trim();
    } else {
      pt = data.strApt.indexOf('/');
      if (pt >= 0) {
        data.strApt = append(data.strApt.substring(0,pt).trim(), " - ", data.strApt.substring(pt+1).trim());
      }
    }
    
    // Everything from city to time field is the call description
    body = stripFieldStart(body, "*");
    Matcher match = TIME_PTN.matcher(body);
    if (match.find()) {
      data.strTime = match.group().replace(" ", "");
      String cross = body.substring(match.end()).trim();
      body = body.substring(0,match.start()).trim();
      
      // What is left should be a cross street
      cross = stripFieldStart(cross, "Cross Street ");
      
      // Strip ID from end of what is left
      match = ID_PTN.matcher(cross);
      if (match.find()) {
        data.strCallId = match.group();
        cross = cross.substring(0,match.start()).trim();
      }
      
      if (!cross.equals("No Cross Streets Found")) data.strCross = cross;
    }
    
    // See if we can split the remaining body into place name, call, and info
    for (int j = 0; j<body.length()-2; j++) {
      if (Character.isLetter(body.charAt(j))) {
        String call = CALL_LIST.getCode(body.substring(j));
        if (call != null) {
          data.strPlace = stripFieldEnd(body.substring(0,j).trim(), "<New Call>");
          data.strCall = body.substring(j);
          return true;
        }
      }
    }
    
    // No go, just assign everything as the call description
    data.strCall = body;
    return true;
  }
  
  private static final String[] ESCAPE_CODES = new String[]{
    "/", "\\s",
    "(", "\\lp",
    ")", "\\rp",
    "[", "\\lb",
    "]", "\\rb"
  };
  
  private static String escape(String fld) {
    for (int j = 0; j<ESCAPE_CODES.length; j+=2) {
      fld = fld.replace(ESCAPE_CODES[j], ESCAPE_CODES[j+1]);
    }
    return fld;
  }
  
  private static String unescape(String fld) {
    for (int j = 0; j<ESCAPE_CODES.length; j+=2) {
      fld = fld.replace(ESCAPE_CODES[j+1], ESCAPE_CODES[j]);
    }
    return fld;
  }
  
  @Override
  public CodeSet getCallList() {
    return CALL_LIST;
  }

  private static final CodeSet CALL_LIST = new CodeSet(
      "Active Violence/Shooter",
      "Aircraft Accident",
      "ALS",
      "Appliance Fire",
      "BLS",
      "Bomb Threat",
      "Brush Fire",
      "CARDIAC ARREST",
      "Chimney Fire",
      "CO No Symptoms",
      "CO With Symptoms",
      "Cover Assignment",
      "Dumpster/Debris Fire",
      "Electrical Fire",
      "Fire Alarm",
      "Fuel Spill",
      "Hazardous Materials",
      "Lift Assist",
      "Machinery Entrapment",
      "Mutual Aid Fire",
      "Natural Gas/Propane Leak",
      "Officer Call",
      "Outside Fire",
      "Search and Rescue",
      "Service Call",
      "Smoke Detector Activation",
      "Smoke In Building",
      "Smoke/Odor Investigation",
      "Standby",
      "Structure Fire",
      "Tree/Wires Down",
      "Unknown Type Fire",
      "Vehicle Accident W/O Injuries",
      "Vehicle Accident",
      "Vehicle Accident/HeadOn",
      "Vehicle Fire",
      "Wires Burning/Arcing"
  );
}
