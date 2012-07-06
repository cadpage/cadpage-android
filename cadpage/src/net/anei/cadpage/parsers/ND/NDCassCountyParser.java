package net.anei.cadpage.parsers.ND;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Cass County, ND
Contact: scott mcconnell <mcconnellscooter@gmail.com>,7014297950@vzwpix.com
Sender: dispatch@rrrdc.org

Accident - Injury 15605 29 ST SE CAST 02/10/12 16:21 CFS #: 430 10-50 ROLLOVER I  Nature Of Call: 10-50 ROLLOVER I  Nature Of Call: 10-50 ROLLOVER  9500-CASTFIR 6611-CASTAMB 608 8800-CASSRES
Accident - Injury 102 LANGER AVE S CAST CENEX PETRO SERVE - 102 LANGER AVE S - CAST04/03/12 12:15 CFS #: 967 MEDICAL  Dispatch received by unit 3523 Dispatch received by unit 3518  M WAS HIT BY HIS OWN VEH  Nature Of Call: MEDICAL  9500-CASTFIR 6611-CASTAMB 609 8800-CASSRES
Residential Fire 321 8 AVE N CAST 03/27/12 20:57 CFS #: 787 RESIDENTIAL FIRE  SMELLS HOT UP IN COMPS DAUGHTERS ROOM  Nature Of Call: RESIDENTIAL FIRE  9501-CASTFIR
Residential Fire 411 8 AVE S CAST 06/24/12 13:52 CFS #: 963 RESIDENTIAL FIRE  Nature Of Call: RESIDENTIAL FIRE  ELEMENT IN BASEMENT IT ON FIRE, CAN NOT TURN IT OFF  Nature Of Call: RMF  9500-CASTFIR
Grass Fire 15556 37 ST SE CAST GORDYS - 15556 37 ST SE - CAST06/27/12 21:32 CFS #: 962 GRASS FIRE  Nature Of Call: GRASS FIRE  9500-CASTFIR
Vehicle Fire CAST 322 mm I94 CASS W06/18/12 09:15 CFS #: 277 VEH ON FIRE  BLAZER  NO HAZMAT IN VEH.  UNSURE EXACTLY WHICH EXIT.  THINKS 324, BUT COULD BE 322  ON WB OFF RAMP.    FLAMES IN ENG  Nature Of Call: VEH ON FIRE  

*/

public class NDCassCountyParser extends SmartAddressParser {
  
  private static final Pattern DATE_TIME_CFS_PTN = Pattern.compile("(\\d\\d/\\d\\d/\\d\\d) (\\d\\d:\\d\\d) CFS #: (\\d+) ");
  private static final Pattern UNIT_PTN = Pattern.compile("(?: \\d{3}| \\d{4}-[A-Z]+)+$");
 
  public NDCassCountyParser() {
    super(CITY_CODES, "CASS COUNTY", "ND");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@rrrdc.or";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = DATE_TIME_CFS_PTN.matcher(body);
    if (!match.find()) return false;
    data.strDate = match.group(1);
    data.strTime = match.group(2);
    data.strCallId = match.group(3);
    String sAddr = body.substring(0,match.start()).trim();
    String sInfo = body.substring(match.end()).trim();
    
    parseAddress(StartType.START_CALL, sAddr, data);
    String sPlace = getLeft();
    int pt = sPlace.indexOf(" - ");
    if (pt >= 0) sPlace = sPlace.substring(0,pt).trim();
    if (sPlace.length() <= 1) sPlace = "";
    data.strPlace = sPlace;
    
    match = UNIT_PTN.matcher(sInfo);
    if (match.find()) {
      data.strUnit = match.group().trim();
      sInfo = sInfo.substring(0,match.start()).trim();
    }
    for (String info : sInfo.split("Nature Of Call:")) {
      info = info.trim();
      if (info.length() > data.strSupp.length()) data.strSupp = info;
    }
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CAST", "CASSELTON",
      "CASS", ""
  });
}
