package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA23Parser;



public class PACumberlandCountyParser extends DispatchA23Parser {
  
  public PACumberlandCountyParser() {
    super(CITY_CODES, "CUMBERLAND COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "ccpaeoc@comcast.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.startsWith("[DISPATCH]")) subject = subject.substring(10).trim();
    if (!super.parseMsg(subject,  body, data)) return false;
    
    // Lots of special handling goes into mutual aid calls
    if (data.strCall.startsWith("MUTUAL AID") && data.strAddress.length() <= 3) {
      String addr = data.strPlace;
      String place = data.strPlace = "";
      int pt = addr.indexOf(" - ");
      if (pt >= 0) {
        place = addr.substring(pt+3).trim();
        addr = addr.substring(0,pt).trim();
      }
      data.strAddress = "";
      pt = addr.indexOf(',');
      String city;
      if (pt >= 0) {
        city = addr.substring(0,pt).trim();
        parseAddress(addr.substring(pt+1).trim(), data);
      } else {
        parseAddress(StartType.START_PLACE, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, addr, data);
        city = data.strPlace;
      }
      data.strPlace = place;
      if (data.strAddress.length() == 0) {
        parseAddress(city, data);
      } else {
        if (city.endsWith(" BORO")) {
          city = city.substring(0,city.length()-5).trim();
        } else if (city.startsWith("BORO OF ")) {
          city = city.substring(8).trim();
        } else if (city.startsWith("BORO ")) {
          city = city.substring(5).trim();
        } else if (city.equals("SUSQ TWP")) {
          city = "SUSQUEHANNA TWP";
        }
        data.strCity = convertCodes(city, CITY_CODES2);
      }
    }
    return true;
  }
  
  @Override
  public String adjustMapAddress(String address) {
    address = GD_PTN.matcher(address).replaceAll("GARDEN");
    address = ES_PTN.matcher(address).replaceAll("ESTATES");
    address = HGWY_PTN.matcher(address).replaceAll("HWY");
    address = BY_PTN.matcher(address).replaceAll("BYPASS");
    return address;
  }
  private static final Pattern GD_PTN = Pattern.compile("\\bGD\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern ES_PTN = Pattern.compile("\\bES\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern HGWY_PTN = Pattern.compile("\\bHGWY\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern BY_PTN = Pattern.compile("\\bBY\\b", Pattern.CASE_INSENSITIVE);

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CA CU", "CARLISLE",
      "CH CU", "CAMP HILL",
      "DK CU", "DICKINSON TWP",
      "EP CU", "EAST PENNSBORO TWP",
      "HM CU", "HAMPDEN TWP",
      "HW CU", "HOPEWELL TWP",
      "LA CU", "LOWER ALLEN TWP",
      "LB CU", "LEMOYNE",
      "LF CU", "LOWER FRANKFORD TWP",
      "MB CU", "MECHANICSBURG",
      "MH CU", "MT HOLLY SPRINGS",
      "MX CU", "MIDDLESEX TWP",
      "NB CU", "NEWBURG",
      "NM CU", "NORTH MIDDLETON TWP",
      "SB CU", "SHIPPENSBURG",
      "SF CU", "SHIPPENSBURG",
      "SH CU", "SHIPPENSBURG",
      "SM CU", "SOUTH MIDDLETON TWP",
      "SN CU", "SOUTH NEWTON TWP",
      "ST CU", "SHIPPENSBURG",
      "SR CU", "SHIREMANSTOWN",
      "UA CU", "UPPER ALLEN TWP",
      "UF CU", "UPPER FRANKFORD TWP",
      "WB CU", "WORMLEYSBURG",
      "WP CU", "WEST PENNSBORO TWP",
      
      "DC DC", "DAUPHIN COUNTY",
      "FCR",   "FRANKLIN COUNTY",
      "FC FR", "FRANKLIN COUNTY",
      "PC PC", "PERRY COUNTY",
  });

  private static final Properties CITY_CODES2 = buildCodeTable(new String[]{
      "S HAMP", "SOUTHAMPTON TWP",
      "SH TWP", "SOUTHAMPTON TWP",
      "SHAMP",  "SOUTHAMPTON TWP",
      "SHP",    "SHIPPENSBURG"
  });

}
