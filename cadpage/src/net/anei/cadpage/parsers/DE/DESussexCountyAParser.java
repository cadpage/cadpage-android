package net.anei.cadpage.parsers.DE;

import java.util.Properties;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class DESussexCountyAParser extends SmartAddressParser {
  
  public DESussexCountyAParser() {
    super(CITY_LIST, "SUSSEX COUNTY", "DE");
    setFieldList("SRC CALL ADDR CITY PLACE");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    String[] subjects = subject.split("\\|");
    if (subjects.length > 2) return false;
    if (subjects.length == 2) {
      if (!subjects[0].equals("Chief ALT")) return false;
      subject = subjects[1];
    }
    data.strSource = subject;
    
    if (!body.startsWith("-- ")) return false;
    body = body.substring(3).trim();

    // First divide up the call
    String strBody[] = body.split(" *-- *");
    if (strBody.length < 2) return false;

    // field 0 - the call description
    data.strCall = strBody[0].trim();

    // See how many fields we have
    int fldCnt = strBody.length;

    // If more than 2 and the last fields starts with "INC ", ignore it
    if (fldCnt > 2 && strBody[fldCnt-1].trim().startsWith("INC ")) fldCnt--;

    // If we are down to 2 fields, the last one is the address line and
    // nothing needs to be worried about
    Result result;
    if (fldCnt == 2) {
      result = parseAddress(strBody[1]);
    }

    // Otherwise we have big problems, one of lines 3 and 4 is the address
    // line and one is a place name.  But we don't know which is which.
    else {
      Result res2 = parseAddress(strBody[1]);
      Result res3 = parseAddress(strBody[2]);
      if (res2.getStatus() >= res3.getStatus()) {
        result = res2;
        data.strPlace = strBody[2];
      } else {
        result = res3;
        data.strPlace = strBody[1];
      }
    }

    if (result.getStatus() == 0) return false;
    result.getData(data);
    
    // Hopefully it found a city, if not we will have to parse one out
    // of what is left
    if (data.strCity.length() == 0) {
      
      // If the last token in what is left is a 5 digit zip code, strip it off
      String sAddress = result.getLeft();
      Parser p = new Parser(sAddress);
      String last = p.getLastOptional(' ');
      if (last.length() == 5 && NUMERIC.matcher(last).matches()) sAddress = p.get();
      
      // If last character is a comma, get rid of it
      
      // If the new last token is "DE" with or without a trailing comma, strip it off 
      p = new Parser(sAddress);
      last = p.getLastOptional(' ');
      if (last.endsWith(",")) last = last.substring(0, last.length()-1);
      if (last.equalsIgnoreCase("DE")) sAddress = p.get();
    
      // Whatever is left is our city
      data.strCity = sAddress;
    }
    
    // Some city names are subdivisons or apartment complexes
    String city = PLACE_NAMES.getProperty(data.strCity.toUpperCase());
    if (city != null) {
      data.strPlace = append(data.strPlace, " - ", data.strCity);
      data.strCity = city;
    }

    return true;
  }
  
  private Result parseAddress(String address) {
    address = address.trim();
    if (address.startsWith("0 ")) address = address.substring(2).trim();
    return parseAddress(StartType.START_ADDR, address);
  }
  
  private static final String[] CITY_LIST = new String[] {
    "BETHANY BEACH", 
    "BETHEL", 
    "BLADES", 
    "BRIDGEVILLE", 
    "DAGSBORO", 
    "DELMAR",
    "DEWEY BEACH", 
    "ELENDALE", 
    "FENWICK ISLAND", 
    "FRANKFORD", 
    "GEORGETOWN",
    "GREENWOOD", 
    "HENLOPEN ACRES", 
    "LAUREL", 
    "LEWES", 
    "MILFORD", 
    "MILLSBORO",
    "MILLVILLE", 
    "MILTON", 
    "OCEAN VIEW", 
    "REHOBOTH BEACH", 
    "SEAFORD", 
    "SELBYVILLE",
    "SLAUGHTER BEACH", 
    "SOUTH BETHANY",
    
    "ASPEN MEADOWS",
    "SHADY GROVE"
  };
  
  private static final Properties PLACE_NAMES = buildCodeTable(new String[]{
      "ANGOLA CREST",                 "LEWE",
      "ANGOLA ESTATES",               "LEWE",
      "ANGOLA NECK PARK",             "LEWE",
      "ANN ACRES",                    "REHOBOTH BEACH",
      "ARNELL CREEK",                 "REHOBOTH BEACH",
      "ASPEN MEADOWS",                "REHOBOTH BEACH",
      "BAY HARBOR",                   "REHOBOTH BEACH",
      "BAY POINTE",                   "LEWE",
      "BEACHFIELD",                   "REHOBOTH BEACH",
      "BALD EAGLE VILLAGE",           "REHOBOTH BEACH",
      "BAY FRONT",                    "LEWE",
      "BAY OAKS",                     "LEWE",
      "BAY RIDGE WOODS",              "LEWE",
      "BAY VISTA",                    "REHOBOTH BEACH",
      "BELLA VISTA",                  "REHOBOTH BEACH",
      "BLUE POINT VILLAS",            "REHOBOTH BEACH",
      "BOOKHAMMER",                   "LEWE",
      "BOOKHAMMER ESTATES",           "LEWE",
      "BEACH HAVEN",                  "REHOBOTH BEACH",
      "BREAKWATER ESTATES",           "REHOBOTH BEACH",
      "BREEZEWOOD",                   "REHOBOTH BEACH",
      "BURTON VILLAGE",               "REHOBOTH BEACH",
      "CAMELOT",                      "REHOBOTH BEACH",
      "CANAL CORKRAN",                "REHOBOTH BEACH",
      "CANAL POINT",                  "REHOBOTH BEACH",
      "CAPTIVA SANDS",                "REHOBOTH BEACH",
      "CEDAR VALLEY",                 "REHOBOTH BEACH",
      "CHERRY CREEK VALLEY",          "LEWE",
      "CHERRY WALK",                  "LEWE",
      "COUNTRY MANOR",                "REHOBOTH BEACH",
      "CREEKWOOD",                    "REHOBOTH BEACH",
      "DOLLYS",                       "LEWE",
      "EAGLES LANDING",               "REHOBOTH BEACH",
      "EDGEWATER PARK",               "REHOBOTH BEACH",
      "ESTATES OF SEA CHASE",         "REHOBOTH BEACH",
      "FIELDWOOD",                    "REHOBOTH BEACH",
      "HAPPY GO LUCKY",               "LEWE",
      "HARMON BAY",                   "REHOBOTH BEACH",
      "HENLOPEN ACRES",               "REHOBOTH BEACH",
      "HENLOPEN KEYS",                "REHOBOTH BEACH",
      "HERRING LANDING",              "LEWE",
      "HOLLAND GLADE",                "REHOBOTH BEACH",
      "HOLLY OAK ACRES",              "LEWE",
      "HOLLY WOOD",                   "LEWE",
      "INDIAN BEACH",                 "REHOBOTH BEACH",
      "JOY BEACH",                    "LEWE",
      "KEYS OF MARSH HARBOR",         "REHOBOTH BEACH",
      "KINGS CREEK",                  "REHOBOTH BEACH",
      "KINSALE GLEN",                 "REHOBOTH BEACH",
      "KYRIE ESTATES",                "REHOBOTH BEACH",
      "LAZY PINE RETREAT",            "LEWE",
      "LOVE CREEK",                   "LEWE",
      "LOVE CREEK WOODS",             "LEWE",
      "MASTEN HEIGHTS",               "REHOBOTH BEACH",
      "MULBERRY KNOLL",               "LEWE",
      "OLD LANDING",                  "REHOBOTH BEACH",
      "OLD LANDING WOODS",            "REHOBOTH BEACH",
      "PINE VALLEY",                  "REHOBOTH BEACH",
      "PINEY GLADE",                  "REHOBOTH BEACH",
      "PORT DELMARVA",                "REHOBOTH BEACH",
      "RBYCC",                        "REHOBOTH BEACH",
      "REHOBOTH BAY",                 "REHOBOTH BEACH",
      "REHOBOTH BEACH GARDENS",       "REHOBOTH BEACH",
      "REHOBOTH CROSSING",            "REHOBOTH BEACH",
      "REHOBOTH MANOR",               "REHOBOTH BEACH",
      "REHOBOTH SHORE ESTATES",       "REHOBOTH BEACH",
      "SANDALWOOD",                   "REHOBOTH BEACH",
      "SANIBEL VILLAGE",              "REHOBOTH BEACH",
      "SAWGRASS",                     "REHOBOTH BEACH",
      "SEA AIR VILLAGE",              "REHOBOTH BEACH",
      "SEA CHASE",                    "REHOBOTH BEACH",
      "SEA COAST COURTS",             "REHOBOTH BEACH",
      "SEABRIGHT",                    "REHOBOTH BEACH",
      "SHADY RIDGE",                  "REHOBOTH BEACH",
      "SHADY GROVE",                  "REHOBOTH BEACH",
      "SILVER LAKE MANOR",            "REHOBOTH BEACH",
      "SILVER LAKE SHORES",           "REHOBOTH BEACH",
      "SILVER VIEW",                  "REHOBOTH BEACH",
      "SPRING LAKE",                  "REHOBOTH BEACH",
      "ST MICHAELS PLACE",            "REHOBOTH BEACH",
      "STABLE FARM",                  "REHOBOTH BEACH",
      "STONEWOOD CHASE",              "REHOBOTH BEACH",
      "TALL PINES",                   "LEWE",
      "THE AVENUE",                   "REHOBOTH BEACH",
      "THE CHANCELLERY",              "REHOBOTH BEACH",
      "THE COVE",                     "LEWE",
      "THE LANDING",                  "REHOBOTH BEACH",
      "THE SEASONS",                  "REHOBOTH BEACH",
      "THE PALMS OF REHOBOTH",        "REHOBOTH BEACH",
      "THE TIDES",                    "REHOBOTH BEACH",
      "THE VILLAGES AT HERRING CREEK","LEWE",
      "THE VILLAGES OF OLD LANDING",  "REHOBOTH BEACH",
      "THE WOODS AT SEASIDE",         "REHOBOTH BEACH",
      "TRU VALE ACRES",               "REHOBOTH BEACH",
      "VILLAGES AT HERRING CREEK",    "LEWE",
      "WASHINGTON HEIGHTS",           "REHOBOTH BEACH",
      "WEST BAY PARK",                "LEWE"
  });
  
}


