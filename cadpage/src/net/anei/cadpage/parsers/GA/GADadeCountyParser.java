package net.anei.cadpage.parsers.GA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * Dade County, GA
 */
public class GADadeCountyParser extends SmartAddressParser {

  private static final Pattern MASTER = Pattern.compile("(.*?) {3,}(.*?) +(\\d\\d/\\d\\d/\\d\\d) +(\\d\\d:\\d\\d)");
  
  public GADadeCountyParser() {
    super(CITY_LIST, "DADE COUNTY", "GA");
  }
  
  @Override
  public String getFilter() {
    return "E911@dadega.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("!")) return false;
    Matcher match = MASTER.matcher(body);
    String sAddr;
    if (match.matches()) {
      sAddr = match.group(1);
      data.strSupp = match.group(2);
      data.strDate = match.group(3);
      data.strTime = match.group(4);
    }
    
    else {
      int pt = body.indexOf("   ");
      if (pt < 0) return false;
      sAddr = body.substring(0,pt);
      data.strSupp = body.substring(pt+3).trim();
    }
    
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_ANCHOR_END | FLAG_PAD_FIELD, sAddr, data);
    data.strCross = getPadField();
    String city = PLACE_CITY_XREF.getProperty(data.strCity);
    if (city != null) {
      data.strPlace = data.strCity;
      data.strCity = city;
    }
    
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "NEW ENGLAND",
    "RISING FAWN",
    "TRENTON",
    "WILDWOOD",
    
    "SLYGO"
  };
  
  private static final Properties PLACE_CITY_XREF = buildCodeTable(new String[]{
      "SLYGO",       "TRENTON"
  }); 
}
