package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYCayugaCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER1 = Pattern.compile(" +(\\d\\d/\\d\\d/\\d\\d) (\\d\\d:\\d\\d) (\\d{4}-\\d{8}) ([A-Z ]+)$", Pattern.CASE_INSENSITIVE);
  private static final Pattern MARKER2 = Pattern.compile("^(\\d\\d/\\d\\d/\\d\\d) (\\d\\d:\\d\\d) +");
  private static final Pattern MISSED_BLANK_PTN = Pattern.compile("([^ ])(SENNETT )", Pattern.CASE_INSENSITIVE);
  private static final Pattern PLACE_PTN = Pattern.compile("^[ A-Z]*[A-Z](?=\\d)");

  public NYCayugaCountyParser() {
    super(CITY_LIST, "CAYUGA COUNTY", "NY");
    setupMultiWordStreets("WEST LAKE", "GRANT AVENUE");
  }
  
  @Override
  public String getFilter() {
    return "cayuga911@co.cayuga.ny.us,cayuga911@nameservices.net,cayuga911@www.cayugacounty.us,messaging@iamresponding.com,dspingler@cayugacounty.us,911cad@cayugacounty.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // First try to parse older format page
    Matcher match = MARKER2.matcher(body);
    if (match.find()) {
      setFieldList("DATE TIME PLACE ADDR CITY CALL X INFO");
      
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      body = body.substring(match.end());
      
      // They do not leave spaces between place names and street numbers :(
      StartType st = StartType.START_PLACE;
      match = PLACE_PTN.matcher(body);
      if (match.find()) {
        data.strPlace = match.group();
        body = body.substring(match.end());
        st = StartType.START_ADDR;
      }
      
      // See if we can split off a cross street keyword
      String cross = null;
      int pt = body.indexOf(" BETWEEN ");
      if (pt >= 0) {
        cross = body.substring(pt+9).trim();
        body = body.substring(0,pt).trim();
      }
      
      // See if there is a comma separating the address from the city.
      // If what follows the comma is not a recognized city, assume it is extraneous
      String extra = "";
      pt = body.indexOf(',');
      if (pt >= 0) {
        Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, body.substring(pt+1).trim());
        if (res.getStatus() > 0) {
          parseAddress(st, FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, body.substring(0,pt).trim(), data);
          res.getData(data);
          extra = res.getLeft();
        } else {
          pt = -1;
        }
      } 
      
      if (pt < 0) { 
        parseAddress(st, FLAG_IMPLIED_INTERSECT, body, data);
        extra = getLeft();
      }
      
      // Things change if we have identified a cross street segment
      // What is left of extra is the call description
      // what follows the BETWEEN keyword is a cross street and supplemental info
      if (cross != null) {
        data.strCall = extra;
        pt = cross.indexOf(',');
        if (pt >= 0) {
          data.strCross = cross.substring(0,pt).trim();
          data.strSupp = cross.substring(pt+1).trim();
        } else {
          parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, cross);
          data.strSupp = getLeft();
        }
      }
      
      // Otherwise Try to split extra into call description and supp info
      else {
        getCallInfoFields(extra, data);
      }
      
      cleanCityName(data);
      return true;
    }
    
    // Try to parse new format page
    boolean good;
    String saveBody = body;
    match = MARKER1.matcher(body);
    if (match.find()) {
      good = true;
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      data.strCallId = match.group(3);
      data.strName = match.group(4).trim();
      
      body = body.substring(0,match.start());
      if (body.endsWith(" Uncertainty:  Confidence:")) {
        body = body.substring(0,body.length()-26).trim();
      }
    } else {
      good = subject.equals("From 911 Center") || subject.equals("From911Center");
    }
    
    if (good) {
      setFieldList("ADDR APT PLACE CITY X CALL INFO DATE TIME ID NAME");

      // Sometimes blanks are missing between address and city name :(
      body = MISSED_BLANK_PTN.matcher(body).replaceFirst("$1 $2");
      
      // Warning extreme ugliness ahead
      // The occasionally include a place name between the address and
      // the city, which would normally be handled by a pad field.  But
      // they also routinely drop the street suffix.  Which really messes
      // things up if we are searching for a pad field.
      
      // SO, we will do an initial parse address without the pad field
      // then try to reparse the parsed address field to see if we
      // can find a place name in it
      parseAddress(StartType.START_ADDR, FLAG_CROSS_FOLLOWS, body, data);
      if (data.strCity.length() == 0) {
        data.parseGeneralAlert(this, saveBody);
        return true;
      }
      body = getLeft();
      
      String address = data.strAddress;
      data.strAddress = "";
      parseAddress(StartType.START_ADDR, address, data);
      data.strPlace = getLeft();
      
      // Next come cross street information, which might come in multiple parts
      // separated by a comma
      String cross = "";
      while (true) {
        int pt = body.indexOf(',');
        if (pt < 0) break;
        String tmp = body.substring(0,pt).trim();
        if (checkAddress(tmp) == 0) break;
        cross = append(cross, ", ", tmp);
        body = body.substring(pt+1).trim();
      }
      Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_NO_CITY, body);
      if (res.getStatus() > 0) {
        res.getData(data);
        body = res.getLeft();
      }
      data.strCross = append(cross, ", ", data.strCross);
      
      // Get call description 
      getCallInfoFields(body, data);
      
      // Clean up city name issues
      cleanCityName(data);
      
      return true;
    }
    
    return false;
  }

  /**
   * Extract call and info fields from long call description
   * @param field long call description field
   * @param data parsed data information object
   */
  private void getCallInfoFields(String field, Data data) {
    int pt;
    pt = field.indexOf("  ");
    if (pt >= 0 && pt <= 30) {
      data.strCall = field.substring(0,pt);
      data.strSupp = field.substring(pt+2).trim();
    } else if (field.length() <= 30) {
      data.strCall = field;
    } else {
      data.strSupp = field;
    }
    
    data.strSupp = data.strSupp.replaceAll("   +", "  ");
  }

  /**
   * Cleanup up city name issues
   * @param data parsed data information object
   */
  private void cleanCityName(Data data) {
    if (data.strCity.toUpperCase().endsWith(" ONONDAGA COUNTY")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-16).trim();
    }
  }
  
  private static final String[] CITY_LIST = new String[]{
    "AUBURN",
    "AURELIUS", 
    "CAYUGA",
    "BRUTUS", 
    "WEEDSPORT",
    "CATO", 
    "MERIDIAN",
    "CONQUEST", 
    "FLEMING",
    "GENOA",
    "IRA",
    "LEDYARD", 
    "AURORA",
    "LOCKE",
    "MENTZ", 
    "PORT BYRON",
    "MONTEZUMA",
    "MORAVIA", 
    "NILES", 
    "OWASCO",
    "SCIPIO",
    "SEMPRONIUS",
    "SENNETT",
    "SPRINGPORT", 
    "UNION SPRINGS",
    "STERLING", 
    "FAIR HAVEN",
    "SUMMERHILL",
    "THROOP",
    "VENICE",
    "VICTORY",
    
    "ONONDAGA COUNTY",
    "SKANEATELES",
    "SKANEATELES ONONDAGA COUNTY",
    
    "WAYNE COUNTY"
  };
}
	