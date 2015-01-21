package net.anei.cadpage.parsers.NJ;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class NJMorrisCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER_PTN = 
    Pattern.compile("(.*?) \\[([-A-Za-z ]+)(?:\\.*\\d+)?\\] \\(([-A-Z0-9\\\\/ ]+)\\) - (.*)", Pattern.DOTALL);
  
  private static final Pattern ADDR_ZIP_PTN = Pattern.compile("(.*), *\\d{5}");
  private static final Pattern PLACE_CODE_PTN = Pattern.compile("\\(\\d+\\)");
  private static final Pattern ID_TIME_PTN = Pattern.compile("\\b(?:([A-Z]\\d{6,}) +)?(\\d\\d:\\d\\d)$");
  
  public NJMorrisCountyParser() {
    super(OOC_CITY_LIST, "MORRIS COUNTY", "NJ");
    setFieldList("PLACE APT ADDR CITY CALL UNIT INFO CODE ID TIME");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@co.morris.nj.us,mcdispatch@optimum.net,iamresponding.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    
    String sAddress = match.group(1).trim();
    String city = match.group(2).trim();
    data.strCall = match.group(3).trim();
    String sExtra = match.group(4);
    
    int pt = sAddress.indexOf('\n');
    if (pt >= 0) {
      data.strCall = append(data.strCall, " - ", sAddress.substring(0,pt).trim());
      sAddress = sAddress.substring(pt+1).trim();
    }
    
    sAddress = stripFieldStart(sAddress, "***");
    
    // Strip off trailing zip code
    match = ADDR_ZIP_PTN.matcher(sAddress);
    if (match.matches()) sAddress = match.group(1).trim();
    
    Parser p = new Parser(sAddress);
    data.strPlace = p.getOptional(',');
    Matcher match2 = PLACE_CODE_PTN.matcher(data.strPlace);
    if (match2.find()) { 
      data.strApt = data.strPlace.substring(match2.end()).trim();
      data.strPlace = data.strPlace.substring(0,match2.start()).trim();
    }
    data.strApt = append(data.strApt, " - ", p.getOptional(','));
    data.strApt = append(data.strApt, " - ", p.getLastOptional(" BLDG "));
    parseAddress(p.get(), data);
    
    // A numeric place name is probably a street number that got separated from
    // it's street name
    if (data.strPlace.length() > 0 && NUMERIC.matcher(data.strPlace).matches()) {
      if (data.strAddress.length() == 0 || !Character.isDigit(data.strAddress.charAt(0))) {
        data.strAddress = append(data.strPlace, " ", data.strAddress);
        data.strPlace = "";
      }
    }

    // Clean up the city name
    city = stripFieldEnd(city, " Boro");
    city = stripFieldEnd(city, " Bor");
    data.strCity = convertCodes(city,  CITY_CODES);
    
    // Special handling required for OOC mutual aid calls
    if (data.strAddress.endsWith(" COUNTY") && data.strPlace.length() > 0) {
      
      // Address is really in the place field, and usually ends with city
      // name.  But city name may or may not be in are precompiled list of
      // cities
      String county = data.strAddress;
      data.strAddress = "";
      data.strCity = "";
      String addr = data.strPlace;
      data.strPlace = "";
      if (addr.startsWith("APT")) {
        p = new Parser(addr.substring(3).trim());
        data.strApt = p.get(' ');
        addr = p.get();
      }
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, addr, data);
      if (data.strCity.length() == 0) {
        data.strAddress = "";
        parseAddress(StartType.START_ADDR, addr, data);
        data.strCity = getLeft();
        if (data.strCity.length() == 0) data.strCity = county;
      }
      if (data.strCity.equals("SANDSTON")) data.strCity = "SANDYSTON";
      else if (data.strCity.equals("FREEDON")) data.strCity = "FREDON";
    }
    if (data.strCity.endsWith(" Co")) data.strCity += "unty";
    
    
    // Strip ID and time from end extra data
    match = ID_TIME_PTN.matcher(sExtra);
    if (match.find()) {
      sExtra = sExtra.substring(0,match.start()).trim();
      data.strCallId = getOptGroup(match.group(1));
      data.strTime = match.group(2);
    }
    
    String[] flds = sExtra.split("\n");
    if (flds.length > 1) {
      data.strUnit = flds[0].trim();
      int last = flds.length-1;
      if (last > 0) {
        String line = flds[last];
        if (line.startsWith("Response Code: ")) {
          data.strCode = line.substring(15).trim();
          last--;
        }
      }
      for (int ndx = 1; ndx <= last; ndx++) {
        data.strSupp = append(data.strSupp, " / ", flds[ndx].trim());
      }
    }
    
    else {
      p = new Parser(sExtra);
      data.strUnit = p.getLastOptional(" - ");
      data.strSupp = p.get();
    }
    return true;
  }
  
  private static final String[] OOC_CITY_LIST = new String[]{
    
    // Essex County
    "LIVINGSTON",
    
    // Sussex County
    "ANDOVER TWP",
    "FREEDON",    // dispatch typos
    "FREDON",
    "LAFAYETTE TWP",
    "HOPATCONG",
    "SANDSTON",   // dispatch typo
    "SANDYSTON",
    "SPARTA",
    "WANTAGE",
    
    // Union County
    "BERKLEY HEIGHTS",
    "NEW PROVIDENCE",
    
    // Warren County
    "FRANKLIN TWP",
    "FRELINGHUYSEN",
    "INDEPENDENCE TWP",
    "PHILLIPSBURG"
  };
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "Morris Plns",    "Morris Plains",
      "MtArlington",    "Mt Arlington"
  });
}
