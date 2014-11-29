package net.anei.cadpage.parsers.NJ;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class NJMorrisCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER_PTN = 
    Pattern.compile("(?:((?:Recall|Cancel) Reason: .*|\\*Completed\\*)\n)?(.*?) \\[([-A-Za-z ]+)(?:\\.*\\d+)?\\] \\(([-A-Z0-9\\\\/ ]+)\\) - (.*)", Pattern.DOTALL);
  
  private static final Pattern PLACE_CODE_PTN = Pattern.compile("\\(\\d+\\)");
  private static final Pattern ID_TIME_PTN = Pattern.compile("([A-Z]\\d{6,}) +(\\d\\d:\\d\\d)");
  
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
    
    String sRecall = getOptGroup(match.group(1));
    String sAddress = match.group(2).trim();
    if (sAddress.startsWith("***")) sAddress = sAddress.substring(3).trim();
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
    
    String city = match.group(3).trim();
    city = stripFieldEnd(city, " Boro");
    city = stripFieldEnd(city, " Bor");
    data.strCity = convertCodes(city,  CITY_CODES);
    data.strCall = append(match.group(4).trim(), " - ", sRecall);
    String sExtra = match.group(5);
    
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
    
    String[] flds = sExtra.split("\n");
    if (flds.length > 1) {
      data.strUnit = flds[0].trim();
      int last = flds.length-1;
      match = ID_TIME_PTN.matcher(flds[last].trim());
      if (match.matches()) {
        data.strCallId = match.group(1);
        data.strTime =match.group(2);
        last--;
      }
      if (last > 0) {
        String line = flds[last];
        if (line.startsWith("Response Code: ")) {
          data.strCode = line.substring(15).trim();
          last--;
        }
      }
      for (int ndx = 1; ndx <= last; ndx++) {
        String fld = flds[ndx].trim();
        if (fld.length() > 0) {
          data.strSupp = append(data.strSupp, " / ", fld);
        }
      }
    }
    
    else {
      p = new Parser(sExtra);
      sExtra = p.getLastOptional(" - ");
      data.strSupp = p.get();
      p = new Parser(sExtra);
      data.strUnit = p.get(' ');
      data.strTime = p.get();
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
