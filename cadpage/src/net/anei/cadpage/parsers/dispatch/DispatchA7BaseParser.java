package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
 * Base class for processing some unknown CAD vendor pages.  The vendor produces a fairly consistent
 * but very long page that is seldom seen in its entirety.  More often we get different variations of
 * the original fields.  The most distinguishing characteristic is an unusual address field that we
 * will handle in this class
 */


public class DispatchA7BaseParser extends FieldProgramParser {
  
  private int initCityIndex = -1;
  private  String[] cityIndex = null;
  private Properties cityCodes = null;
  
  public DispatchA7BaseParser(int initCityIndex, String[] cityIndex, 
                                  String defCity, String defState, String program) {
    super(defCity, defState, program);
    this.initCityIndex = initCityIndex;
    this.cityIndex = cityIndex;
  }
  
  public DispatchA7BaseParser(int initCityIndex, String[] cityIndex, String[] cityList, 
                                  String defCity, String defState, String program) {
    super(cityList, defCity, defState, program);
    this.initCityIndex = initCityIndex;
    this.cityIndex = cityIndex;
  }
  
  public DispatchA7BaseParser(int initCityIndex, String[] cityIndex, Properties cityCodes, 
                                  String defCity, String defState, String program) {
    super(cityCodes, defCity, defState, program);
    this.initCityIndex = initCityIndex;
    this.cityIndex = cityIndex;
    this.cityCodes = cityCodes;
  }
  
  public DispatchA7BaseParser(Properties cityCodes, String defCity, String defState, String program) {
    super(cityCodes, defCity, defState, program);
    this.cityCodes = cityCodes;
  }
  
  /**
   * Parse the strange address fields that are the hallmark of the A7 vendor pages
   * @param sAddr Address field to be parsed
   * @param data MsgInfo.Data object
   */
  protected void parseAddressA7(String sAddr, Data data) {
    
    // Strip the odd parren trailer
    Matcher match = ADDR_TRAIL_MARK.matcher(sAddr);
    if (match.find()) sAddr = sAddr.substring(0,match.start());
    if (sAddr.endsWith(",")) sAddr = sAddr.substring(0,sAddr.length()-1).trim();
    
    // There are several unrelated markers identifying a cross street
    match = CROSS_MARK.matcher(sAddr);
    if (match.find()) {
      data.strCross = sAddr.substring(match.end()).trim();
      sAddr = sAddr.substring(0,match.start());
    }
    
    int pt = sAddr.indexOf(" at ");
    if (pt >= 0) {
      String place = sAddr.substring(0,pt).trim();
      sAddr = sAddr.substring(pt+4).trim();
      pt = place.indexOf(',');
      if (pt >= 0) place = place.substring(0,pt).trim();
      match = APT_MARK.matcher(place);
      if (match.find()) {
        data.strApt = match.group(1);
        place = place.substring(0,match.start());
      }
      data.strPlace = place;
    }
    
    match = APT_MARK.matcher(sAddr);
    if (match.find()) {
      data.strApt = match.group(1);
      sAddr = sAddr.substring(0,match.start());
    }
    
    match = PLACE_MARK.matcher(sAddr);
    if (match.find()) {
      data.strPlace = append(data.strPlace, " - ", sAddr.substring(match.end()).trim());
      sAddr = sAddr.substring(0,match.start()).trim();
    }
    
    String city = "";
    pt = sAddr.lastIndexOf(',');
    if (pt >= 0) { 
      city = sAddr.substring(pt+1).trim();
      sAddr = sAddr.substring(0,pt).trim();
    }
    
    // Look for city code
    // If no city, use smart parser to identify out of county locations
    if (city.length() == 0) {
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sAddr, data);
    }
    
    else {
      parseAddress(sAddr, data);
      data.strCity = getCity(city);
    }
  }
  private static final Pattern ADDR_TRAIL_MARK = Pattern.compile(" *\\([A-Z]{1,2}\\)$");
  private static final Pattern CROSS_MARK = Pattern.compile(" X/| s?btwn[: ]");
  private static final Pattern APT_MARK = Pattern.compile(" *-? *\\bAPT(?!S) *#? *([^ ]+)$");
  private static final Pattern PLACE_MARK = Pattern.compile(" -+ ");

  /**
   * Convert city code to a city name
   * @param cityCode numeric city code
   * @return name of city
   */
  protected String getCity(String cityCode) {
    if (cityIndex != null) {
      Matcher match = CITY_CODE_PTN.matcher(cityCode);
      if (match.matches()) {
        int iCity = Integer.parseInt(match.group(1));
        iCity = iCity - initCityIndex;
        if (iCity < 0 || iCity >= cityIndex.length) return "";
        return cityIndex[iCity];
      }
    }
    if (cityCodes != null) return convertCodes(cityCode, cityCodes);
    return cityCode;
  }
  private static final Pattern CITY_CODE_PTN = Pattern.compile("(\\d{2})\\b.*");
  
  private class A7AddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      parseAddressA7(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY PLACE X";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new A7AddressField();
    return super.getField(name);
  }
}
