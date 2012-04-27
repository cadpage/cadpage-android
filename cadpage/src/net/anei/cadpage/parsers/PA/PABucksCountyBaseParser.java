package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Bucks County, PA
Base parser with methods needed by all Bucks COunty Parsers

 */


public class PABucksCountyBaseParser extends FieldProgramParser {
  
  public PABucksCountyBaseParser(String program) {
    super(CITY_LIST, "BUCKS COUNTY", "PA", program);
  }
  
  @Override
  protected void parseAddress(String sAddr, Data data) {
    
    // There are several unrelated markers identifying a cross street
    Matcher match = CROSS_MARK.matcher(sAddr);
    if (match.find()) {
      data.strCross = sAddr.substring(match.end()).trim();
      sAddr = sAddr.substring(0,match.start());
    }
    
    Parser p = new Parser(sAddr);
    data.strPlace = p.getOptional(" at ");
    int pt = data.strPlace.indexOf(',');
    if (pt >= 0) data.strPlace = data.strPlace.substring(0,pt).trim();
    data.strPlace = append(data.strPlace, " - ", p.getLastOptional(" -- "));
    String city = p.getLastOptional(',');
    sAddr = p.get();
    
    // Clean up dispatch boo boos
    sAddr = sAddr.replace("FRIER RD", "FREIER RD");
    sAddr = sAddr.replace("WHITE BRIAR", "WHITEBRIAR");
    sAddr = expandStreet("COLD SPRING CREAMERY", sAddr);
    sAddr = expandStreet("FALLSINGTON TULLYTOWN", sAddr);
    
    // Look for city code
    // If no city, use smart parser to identify out of county locations
    if (city.length() == 0) {
      super.parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sAddr, data);
    }
    
    else {
      super.parseAddress(sAddr, data);
      match = CITY_CODE_PTN.matcher(city);
      if (match.matches()) {
        data.strCity = getCity(match.group(1));
        data.strPlace = append(data.strPlace, " - ", match.group(2).trim());
      } else {
        data.strCity = city;
      }
    }
  }
  private static final Pattern CROSS_MARK = Pattern.compile(" X/| s?btwn[: ]");
  private static final Pattern CITY_CODE_PTN = Pattern.compile("(\\d{2})[- ]*(.*)");

 
  private static String expandStreet(String fullName, String field) {
    int trigLen  = fullName.lastIndexOf(' ');
    if (trigLen < 0) return field;
    trigLen += 2;
    if (trigLen > fullName.length()) return field;
    String trigger = fullName.substring(0,trigLen);
    int pt1 = 0;
    while (true) {
      int pt2 = field.indexOf(trigger, pt1);
      if (pt2 < 0) break;
      int pt3 = field.indexOf(' ', pt2+trigLen);
      if (pt3 < 0) pt3 = field.length();
      if (fullName.startsWith(field.substring(pt2,pt3))) {
        field = field.substring(0,pt2) + fullName + field.substring(pt3);
      }
      pt1 = pt3;
    }
    return field;
  }

  /**
   * Convert Bucks county city code to a city name
   * @param cityCode numeric city code
   * @return name of city
   */
  static String getCity(String cityCode) {
    int iCity = Integer.parseInt(cityCode);
    iCity = iCity - INIT_TOWN_CODE;
    if (iCity < 0 || iCity >= TOWN_CODES.length) return "";
    return TOWN_CODES[iCity];
  }

  private static final int INIT_TOWN_CODE = 21;
  private static final String[] TOWN_CODES = new String[]{
  /*21*/ "BEDMINSTER TWP",
  /*22*/ "BENSALEM TWP",
  /*23*/ "BRIDGETON TWP",
  /*24*/ "BRISTOL",
  /*25*/ "BRISTOL TWP",
  /*26*/ "BUCKINGHAM TWP",
  /*27*/ "CHALFONT",
  /*28*/ "DOYLESTOWN",
  /*29*/ "DOYLESTOWN TWP",
  /*30*/ "",
  /*31*/ "DUBLIN",
  /*32*/ "DURHAM TWP",
  /*33*/ "EAST ROCKHILL",
  /*34*/ "FALLS TWP",
  /*35*/ "HAYCOCK TWP",
  /*36*/ "HILLTOWN TWP",
  /*37*/ "HULMEVILLE",
  /*38*/ "IVYLAND",
  /*39*/ "LANGHORNE",
  /*40*/ "",
  /*41*/ "LANGHORNE MANOR",
  /*42*/ "LOWER MAKEFIELD TWP",
  /*43*/ "LOWER SOUTHAMPTON TWP",
  /*44*/ "MIDDLETOWN TWP",
  /*45*/ "MILFORD TWP",
  /*46*/ "MORRISVILLE",
  /*47*/ "NEW BRITAIN",
  /*48*/ "NEW BRITAIN TWP",
  /*49*/ "NEW HOPE",
  /*50*/ "",
  /*51*/ "NEWTOWN",
  /*52*/ "NEWTOWN TWP",
  /*53*/ "NOCKAMIXON TWP",
  /*54*/ "NORTHAMPTON TWP",
  /*55*/ "PENNDEL",
  /*56*/ "PERKASIE",
  /*57*/ "PLUMSTEAD TWP",
  /*58*/ "QUAKERTOWN",
  /*59*/ "RICHLAND TWP",
  /*60*/ "",
  /*61*/ "RICHLANDTOWN",
  /*62*/ "RIEGELSVILLE",
  /*63*/ "SELLERSVILLE",
  /*64*/ "SILVERDALE",
  /*65*/ "SOLEBURY TWP",
  /*66*/ "SPRINGFIELD TWP",
  /*67*/ "TELFORD",
  /*68*/ "TINICUM TWP",
  /*69*/ "TRUMBAUERSVILLE",
  /*70*/ "",
  /*71*/ "TULLYTOWN",
  /*72*/ "UPPER MAKEFIELD TWP",
  /*73*/ "UPPER SOUTHAMPTON TWP",
  /*74*/ "WARMINSTER TWP",
  /*75*/ "WARRINGTON TWP",
  /*76*/ "WARWICK TWP",
  /*77*/ "WEST ROCKHILL TWP",
  /*78*/ "WRIGHTSTOWN TWP",
  /*79*/ "YARDLEY"
  };
  
  // City list is only used for out of county mutual aid calls
  private static final String[] CITY_LIST = new String[]{
    "MONTGOMERY TWP"
  };
}
