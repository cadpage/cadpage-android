package net.anei.cadpage.parsers.CA;

import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * Shasta County, CA
 */
public class CAShastaCountyAParser extends SmartAddressParser {

  private static final Pattern GPS_PTN = Pattern.compile(" <a href=\"http://maps.google.com/\\?q=([-+]?\\d+\\.\\d{4,},[-+]?\\d+\\.\\d{4,})\"");
  private static final String GPS_STR = " <a href=\"http://maps.google.com/?q=40.618995,-122.436166\">Map</a>";
  
  public CAShastaCountyAParser() {
    super("SHASTA COUNTY", "CA");
    setFieldList("CALL PLACE ADDR APT SRC CITY X MAP ID UNIT INFO GPS");
  }
  
  @Override
  public String getFilter() {
    return "vtext.com@gmail.com,5304482408,5304109246,shucad@fire.ca.gov";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA | MAP_FLG_PREFER_GPS;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Strip GPS or partial GPS URL from end of text
    Matcher match = GPS_PTN.matcher(body);
    if (match.find()) {
      setGPSLoc(match.group(1), data);
      body = body.substring(0,match.start()).trim();
    } else {
      int pt = body.lastIndexOf(" <a");
      if (pt >= 0) {
        String part = body.substring(pt);
        if (GPS_STR.startsWith(part) || part.startsWith(GPS_STR)) {
          body = body.substring(0,pt).trim();
        }
      }
    }
    
    String[] flds = body.replace('\n', ' ').trim().split(" *; *");
    if (flds.length < 6) return false;
    
    String[] addressList = new String[3];
    
    data.strCall = flds[0];
    String addr =  flds[1];
    if (addr.endsWith(")")) {
      int pt = addr.lastIndexOf('(');
      if (pt < 0) return false;
      data.strPlace = addr.substring(pt+1, addr.length()-1).trim();
      addr = addr.substring(0,pt).trim();
    }
    Parser p = new Parser(addr);
    data.strPlace = append(p.getOptional('@'), " - ", data.strPlace);
    String src = p.getLastOptional(',');
    if (src.length() == 0) return false;
    if (src.startsWith("STA")) {
      data.strSource = src;
    } else {
      data.strCity = convertCodes(src, CITY_CODES);
    }
    addressList[0] = p.get();
    addressList[1] = flds[2];
    addressList[2] = flds[3];
    
    // Life gets complicated, we have three address fields, but the best address
    // is not necessarily the first.  Sort them by address quality, the first
    // one will be the address, others will be cross streets
    AddrStat[] statList = new AddrStat[3];
    for (int j = 0; j< 3; j++) {
      statList[j] = new AddrStat(addressList[j]);
    }
    Arrays.sort(statList);
    parseAddress(statList[0].address, data);
    data.strCross = append(statList[1].address, " & ", statList[2].address);
    
    // Parse rest of fields
    if (!flds[4].startsWith("Map:")) return false;
    data.strMap = flds[4].substring(5).trim();
    
    if (!flds[5].startsWith("Inc# ")) return false;
    data.strCallId = flds[5].substring(5).trim();
    
    if (flds.length <= 6) return true;
    data.strUnit = flds[6];
    
    if (flds.length <= 7) return true;
    data.strSupp =flds[7];
    
    return true;
  }
  
  private class AddrStat implements Comparable<AddrStat>{
    String address;
    int status;
    
    AddrStat(String address) {
      this.address = address;
      this.status = -1;
      if (address.length() == 0) return;
      
      this.status = checkAddress(address);
      if (!address.contains("BLK")) this.status += 100;
      if (!address.contains("/")) this.status += 10;
    }

    @Override
    public int compareTo(AddrStat adst) {
      return -(this.status - adst.status);
    }
  }

  @Override
  public String adjustMapCity(String city) {
    city = convertCodes(city, CITY_MAP);
    return super.adjustMapCity(city);
  }
  
  private static final Properties CITY_MAP = buildCodeTable(new String[]{
      "CENTERVILLE",      "REDDING",
      "JONES VALLEY",     "REDDING",
      "KESWICK",          "REDDING",
      "SHASTA COLLEGE",   "REDDING",
      "SHASTA LAKE",      "REDDING",
      "WEST VALLEY",      "ANDERSON",
      "WNPS",             "SHASTA"
  });
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BELLAVISTA",   "BELLA VISTA",
      "JONESVALLEY",  "JONES VALLEY",
      "MONTGOMERYCK", "MONTGOMERY CREEK",
      "MTNGATE",      "MOUNTAIN GATE",
      "PALOCEDRO",    "PALO CEDRO",
      "REDDINGCTY",   "REDDING",
      "SHASTACOLL",   "SHASTA COLLEGE",
      "SHASTALKCTY",  "SHASTA LAKE",
      "WESTVALLEY",   "WEST VALLEY"
  });
}
