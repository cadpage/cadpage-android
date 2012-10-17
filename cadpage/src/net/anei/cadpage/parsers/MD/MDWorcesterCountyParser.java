package net.anei.cadpage.parsers.MD;

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
    "WHITEON"
  };
}
