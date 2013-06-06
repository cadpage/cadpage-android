package net.anei.cadpage.parsers.CT;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class CTNewHavenCountyBParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^(\\d{10}) +");
  private static final Pattern DATE_TIME_PTN = Pattern.compile(" +(\\d{6}) (\\d\\d:\\d\\d)(?:[ ,]|$)"); 
  private static final Pattern TRUNC_DATE_TIME_PTN = Pattern.compile(" +\\d{6} [\\d:]+$| +\\d{1,6}$"); 
  private static final Pattern ADDR_END_MARKER = Pattern.compile(",|Apt ?#:");
  private static final Pattern MAP_PFX_PTN =Pattern.compile("^(?:Prem )?Map -");
  private static final Pattern MAP_PTN = Pattern.compile("^\\d{1,2}(?: *[A-Z]{2} *\\d{1,3})?\\b");
  private static final Pattern MAP_EXTRA_PTN = Pattern.compile("\\(Prem Map (.*?)\\)");
  private static final Pattern LEAD_ZERO_PTN = Pattern.compile("^0+(?=\\d)");
  
  private static final String FIELD_LIST = "ID CALL ADDR APT CITY MAP X UNIT DATE TIME";
  
  private Properties cityCodes = null;
  
  public CTNewHavenCountyBParser() {
    this(CITY_LIST, CITY_CODES, "NORTH BRANFORD", "CT");
  }
  
  public CTNewHavenCountyBParser(String defCity, String defState) {
    super(defCity, defState);
    setFieldList(FIELD_LIST);
  }
  
  public CTNewHavenCountyBParser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState);
    setFieldList(FIELD_LIST);
  }
  
  public CTNewHavenCountyBParser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState);
    setFieldList(FIELD_LIST);
  }
  
  public CTNewHavenCountyBParser(String[] cityList, Properties cityCodes, String defCity, String defState) {
    super(cityList, defCity, defState);
    this.cityCodes = cityCodes;
    setFieldList(FIELD_LIST);
  }
  
  @Override
  public String getFilter() {
    return "paging@nbpolicect.org,paging@easthavenfire.com,pdpaging@farmington-ct.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(match.end());
    
    match =  DATE_TIME_PTN.matcher(body);
    if (match.find()) {
      String date = match.group(1);
      data.strDate = date.substring(2,4) + "/" + date.substring(4,6) + "/" + date.substring(0,2);
      data.strTime = match.group(2);
      data.strSupp = body.substring(match.end()).trim();
      body = body.substring(0,match.start());
    } else {
      match = TRUNC_DATE_TIME_PTN.matcher(body);
      if (match.find()) body = body.substring(0,match.start());
    }
    
    String sExtra;
    boolean noCross = false;
    match = ADDR_END_MARKER.matcher(body);
    if (match.find()) {
      sExtra = body.substring(match.end()).trim();
      String addr = body.substring(0,match.start()).trim();
      Parser p = new Parser(sExtra);
      String token = p.get(' ');
      sExtra = p.get();
      if (match.group().equals(",")) {
        data.strCity = token;
      } else {
        data.strApt = token;
      }
      parseAddress(StartType.START_CALL, FLAG_PAD_FIELD | FLAG_CROSS_FOLLOWS | FLAG_ANCHOR_END | FLAG_START_FLD_REQ, addr, data);
    }
    
    else {
      parseAddress(StartType.START_CALL, FLAG_PAD_FIELD | FLAG_CROSS_FOLLOWS | FLAG_START_FLD_REQ, body, data);
      sExtra = getLeft();
      noCross = isMBlankLeft();
    }
    
    // If there is a pad field, treat it as a place or cross street
    String pad = getPadField();
    if (checkAddress(pad) > 0) data.strCross = append(data.strCross, " / ", pad);
    else data.strPlace = pad;
    
    match = MAP_PFX_PTN.matcher(sExtra);
    if (match.find()) {
      sExtra = sExtra.substring(match.end());
      noCross = sExtra.startsWith("   ");
      sExtra = sExtra.trim();
      match = MAP_PTN.matcher(sExtra);
      if (match.find()) {
        data.strMap = match.group();
        sExtra = sExtra.substring(match.end());
        noCross = sExtra.startsWith("  ");
        sExtra = sExtra.trim();
      }
    }
    
    // Now we have to split what is left into a cross street and unit
    // If there is a premium map marker between them, things get easy
    if (sExtra.startsWith("/")) sExtra = sExtra.substring(1).trim();
    match = MAP_EXTRA_PTN.matcher(sExtra);
    if (match.find()) {
      data.strCross = append(data.strCross, " / ", sExtra.substring(0, match.start()).trim());
      data.strUnit = sExtra.substring(match.end()).trim();
      if (data.strMap.length() == 0) data.strMap = match.group(1).trim();
    }
    
    // If not, our best approach is to looking for the first multiple blank delimiter.
    // which is a heck of a lot easier to do now that double blanks are preserved by
    // the getLeft() method.
    else {
      if (noCross) {
        data.strUnit = sExtra;
      } else {
        int pt = sExtra.indexOf("  ");
        if (pt >= 0) {
          data.strCross = append(data.strCross, " / ", sExtra.substring(0,pt));
          data.strUnit = sExtra.substring(pt+2).trim();
        }
        
        // If we didn't find one, we will have to use the smart address parser to figure out where
        // the cross street information ends
        else {
          Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, sExtra);
          if (res.getStatus() > 0) {
            res.getData(data);
            data.strUnit = res.getLeft();
          } else {
            data.strUnit = sExtra;
          }
        }
      }
    }
    data.strUnit = data.strUnit.replaceAll("  +", " ");
    
    match = LEAD_ZERO_PTN.matcher(data.strAddress);
    if (match.find()) {
      data.strAddress = data.strAddress.substring(match.end()).trim();
    }
    
    if (cityCodes != null) data.strCity = convertCodes(data.strCity, cityCodes);
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "GUILFORD",
    "WALLINGFORD",
    "WLFD"
  };
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
    "WLFD", "WALLINGFORD"
  });

}
