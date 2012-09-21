package net.anei.cadpage.parsers.GA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Dade County, GA
Contact: toptech82 <toptech82@gmail.com>
Sender: E911@dadega.com
 1 of 2\nFRM:E911@dadega.com\nSUBJ:!\nMSG:Brush, Grass, Field, Woods 220 HOOKER CEMETERY RD DEAD END / HWY 299 WILDWOOD     BRUSH FIRE ON BOTH SIDES\n(Con't) 2 of 2\nOF THE RAILRIAD TRACKS  06/26/12 20:35(End)
 1 of 2\nFRM:E911@dadega.com\nSUBJ:!\nMSG:Convulsions/Seizures 93 MARCH LN DEAD END / HARRIS RD SLYGO     12 YOM, HAVING A SEIZURE, HISTORY OF\n(Con't) 2 of 2\nSEIZURE, HAS NOT COME  06/28/12 00:47(End)
FRM:E911@dadega.com\nSUBJ:!\nMSG:Fall 650 HWY 299 WILDWOOD    Pilot Travel Center #254 E911 Info - Class of Service: BUSN  06/29/12 08:32

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
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_ANCHOR_END | FLAG_PAD_FIELD, match.group(1), data);
    data.strCross = getPadField();
    String city = PLACE_CITY_XREF.getProperty(data.strCity);
    if (city != null) {
      data.strPlace = data.strCity;
      data.strCity = city;
    }
    
    data.strSupp = match.group(2);
    data.strDate = match.group(3);
    data.strTime = match.group(4);
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
