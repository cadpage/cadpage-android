package net.anei.cadpage.parsers.MD;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import net.anei.cadpage.parsers.GroupBestParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MDWorcesterCountyParser extends GroupBestParser {
 
  public MDWorcesterCountyParser() {
    super(new MDWorcesterCountyAParser(), new MDWorcesterCountyBParser());
  }
  
  public static void fixCity(Data data) {
    data.strCity = convertCodes(data.strCity, FIX_CITY_TABLE);
    if (VA_CITY_SET.contains(data.strCity.toUpperCase())) {
      data.strState = "VA";
    }
  }
  
  public static final String[] CITY_LIST = new String[]{
    "POCO",       // Typo
    "POCOMOK",    // Typo
    "POCOMOKE",
    "BERLIN",
    "OCEAN CITY",
    "SNOW HILL",
    "BISHOPVILLE",
    "GIRDLETREE",
    "NEWARK",
    "OCEAN PINES",
    "SHOWELL",
    "STOCKTON",
    "WEST OCEAN CITY",
    "WHALEYVILLE",
    "BOXION",
    "CEDARTOWN",
    "FRIENDSHIP",
    "GERMANTOWN",
    "GOODWILL",
    "KLEJ GRANGE",
    "LIBERTOWN",
    "NASSAWANGO HILLS",
    "POPLARTOWN",
    "PUBLIC LANDING",
    "SINNEPUXENT",
    "SOUTH POINT",
    "TAYLORVILLE",
    "WHITEON",
    
    // Somerset County
    "WESTOVER",
    "PRINCESS ANNE",
    
    // Accomack County, VA
    "HORTOWN",     // typo
    "HORNTOWN",
    "NEW CHURCH",
    "OAK HALL",
    "PARKSL",
    "PARKSLEY"
  };
  
  private static final Properties FIX_CITY_TABLE = buildCodeTable(new String[]{
      "HORTOWN",    "HORNTOWN",
      "PARKSL",     "PARKSLEY",
      "POCO",       "POCOMOKE",
      "POCOMOK",    "POCOMOKE",
  });
  
  private static final Set<String> VA_CITY_SET = new HashSet<String>(Arrays.asList(new String[]{
      "HORNTOWN",
      "NEW CHURCH",
      "OAK HALL",
      "PARKSLEY"
  }));
}
