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
  
  private int initCityIndex = 0;
  private  String[] cityIndex = null;
  
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
  }
  
  /**
   * Parse the strange address fields that are the hallmark of the A7 vendor pages
   * @param sAddr Address field to be parsed
   * @param data MsgInfo.Data object
   */
  protected void parseAddressA7(String sAddr, Data data) {
    
    // There are several unrelated markers identifying a cross street
    Matcher match = CROSS_MARK.matcher(sAddr);
    if (match.find()) {
      data.strCross = sAddr.substring(match.end()).trim();
      sAddr = sAddr.substring(0,match.start());
    }
    
    int pt = sAddr.indexOf(" at ");
    if (pt >= 0) {
      data.strPlace = sAddr.substring(0,pt).trim();
      sAddr = sAddr.substring(pt+4).trim();
      pt = data.strPlace.indexOf(',');
      if (pt >= 0) data.strPlace = data.strPlace.substring(0,pt).trim();
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
      match = CITY_CODE_PTN.matcher(city);
      if (match.matches()) {
        data.strCity = getCity(match.group(1));
      } else {
        data.strCity = city;
      }
    }
  }
  private static final Pattern CROSS_MARK = Pattern.compile(" X/| s?btwn[: ]");
  private static final Pattern PLACE_MARK = Pattern.compile(" -+ ");
  private static final Pattern CITY_CODE_PTN = Pattern.compile("(\\d{2})\\b.*");

  /**
   * Convert numeric city code to a city name
   * @param cityCode numeric city code
   * @return name of city
   */
  protected String getCity(String cityCode) {
    int iCity = Integer.parseInt(cityCode);
    iCity = iCity - initCityIndex;
    if (iCity < 0 || iCity >= cityIndex.length) return "";
    return cityIndex[iCity];
  }
}
