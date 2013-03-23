package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class CTTollandCountyParser extends SmartAddressParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("[A-Z]+");
  private static final Pattern TIME_PTN = Pattern.compile("\\b\\d\\d: \\d\\d\\b");
  private static final Pattern ID_PTN = Pattern.compile("\\b\\d{4}-\\d{8}$");
  
  public CTTollandCountyParser() {
    super(CITY_LIST, "TOLLAND COUNTY", "CT");
    setFieldList("SRC ADDR APT CITY CALL X ID");
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
      
      return false;
    } while (false);
    
    // We are invoking the smart address parser strictly to find city, it
    // shouldn't have to do much parsing.  If it doesn't find a city, bail out.
    // The slash confuses the parse logic, so switch it to something unusual
    // Ditto for parrens
    body = escape(body);
    parseAddress(StartType.START_ADDR, body, data);
    if (data.strCity.length() == 0) return false;
    String sAddr = unescape(data.strAddress);
    data.strApt = unescape(data.strApt);
    body = unescape(getLeft());
    
    // Address always has a slash, which the address parser turned to an ampersand
    // What is in front of that becomes the address
    int pt = sAddr.indexOf('/');
    if (pt >= 0) {
      data.strAddress = sAddr.substring(0,pt).trim();
      sAddr = sAddr.substring(pt+1).trim();
      
      // if what comes after the slash is a street name, append it to address
      // If not, put it in the apt field
      Result res = parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sAddr);
      if (res.getStatus() > 0) {
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
      if (pt < 0) return false;
      data.strApt = append(data.strApt.substring(0,pt).trim(), " - ", data.strApt.substring(pt+1).trim());
    }
    
    // Everything from city to time field is the call description
    if (body.startsWith("*")) body = body.substring(1).trim();
    Matcher match = TIME_PTN.matcher(body);
    if (!match.find()) {
      data.strCall = body;
      return true;
    }
    data.strCall = body.substring(0,match.start()).trim();
    body = body.substring(match.end()).trim();
    
    // What is left should be a cross street
    if (body.startsWith("Cross Street ")) body = body.substring(13).trim();
    
    // Strip ID from end of what is left
    match = ID_PTN.matcher(body);
    if (match.find()) {
      data.strCallId = match.group();
      body = body.substring(0,match.start()).trim();
    }
    
    data.strCross = body;
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
  
  private static final String[] CITY_LIST = new String[]{
    "ANDOVER",
    "BOLTON",
    "COLUMBIA",
    "COVENTRY",
    "ELLINGTON",
    "HEBRON",
    "MANSFIELD",
    "SOMERS",
    "STAFFORD",
    "TOLLAND",
    "UNION",
    "VERNON",
    "WILLINGTON",

    "COVENTRY LAKE",
    "SOUTH COVENTRY",
    "CRYSTAL LAKE",
    "STAFFORD SPRINGS",
    "STORRS",
    "CENTRAL SOMERS",
    "ROCKVILLE",
    "MASHAPAUG",
    
    "WAREHOUSE POINT",

    "UCONN",
    
    // Windham county
    "ASHFORD",
    "WILLIMANTIC",
    "WINDHAM",
    
    // Hartford County
    "BROAD BROOK"
  };

}
