package net.anei.cadpage.parsers.MD;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.anei.cadpage.parsers.GroupBestParser;


public class MDWorcesterCountyParser extends GroupBestParser {
 
  public MDWorcesterCountyParser() {
    super(new MDWorcesterCountyAParser(), new MDWorcesterCountyBParser());
  }
  
  public static final String[] CITY_LIST = new String[]{
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
    "HORNTOWN",
    "NEW CHURCH",
    "OAK HALL"
  };
  
  public static final Set<String> VA_CITY_SET = new HashSet<String>(Arrays.asList(new String[]{
      "HORNTOWN",
      "NEW CHURCH",
      "OAK HALL"
  }));
}
