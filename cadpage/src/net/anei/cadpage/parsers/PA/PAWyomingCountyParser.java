package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Wyoming County, PA
 */
public class PAWyomingCountyParser extends DispatchOSSIParser {
  public PAWyomingCountyParser() {
    super(CITY_CODE, "WYOMING COUNTY", "PA",
        // DON'T KNOW WHY THIS DOESN'T WORK
        //   "CALL ADDR ( PLACE CITY | PLACE | CITY ) ( X/Z X/Z UNIT | X/Z UNIT | UNIT ) INFO");
        // I think this should probably work, too.
        // "CALL ADDR ( PLACE/Z CITY X/Z X/Z UNIT | PLACE/Z CITY X/Z UNIT | PLACE/Z CITY UNIT "+
        // "| CITY X/Z X/Z UNIT | CITY X/Z UNIT | CITY UNIT ) INFO");
        // this one doesn't work with a PLACE and no CITY but you can't make the CITY optional.
//        "CAD:CALL! ( ADDR PLACE/Z CITY? ( X/Z X/Z UNIT! | X/Z UNIT! | UNIT! ) INFO | ADDR! UNIT! INFO )");

        // this doesn't work either.
//        "CALL ADDR ( PLACE/Z CITY X/Z X/Z UNIT! | PLACE/Z CITY X/Z UNIT! | PLACE/Z CITY UNIT! "
//        + " | PLACE/Z X/Z X/Z UNIT! | PLACE/Z X/Z UNIT! | PLACE/Z UNIT! | CITY X/Z X/Z UNIT!  "
//        + " | CITY X/Z UNIT! | CITY UNIT! | X/Z X/Z UNIT! | X/Z UNIT! | UNIT! ) INFO");
        "CAD:CALL! ADDR ( PLACE/Z CITY! ( UNIT! | X/Z UNIT! | X/Z X/Z UNIT! ) INFO+ | "
       +"UNIT! INFO+ | PLACE/Z UNIT! INFO+ | PLACE/Z X/Z X/Z UNIT! INFO+ )");
  }

  @Override
  public String getFilter() {
    return "CAD@wycopa911.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    return parseFields(body.split(";"), data);
  }
  
  private static final String UNIT_PATTERN_S
    = "[A-Z]{1,5}(?:\\d{1,3}(?:[A-Z]\\d{0,2})?)?";
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new UnitField(UNIT_PATTERN_S+"(?:,"+UNIT_PATTERN_S+")*,?", true);
    if (name.equals("CITY")) return new CityField("[A-Z]+", true);
    return super.getField(name);
  }
  
  private static final Properties CITY_CODE = buildCodeTable(new String[] {
    // Populated places in Wyoming County - from pennsylvania.hometownlocator.com
/*
    "",                   "ALDOVIN",
    "",                   "AVERY",
    "",                   "BARDWELL",
    "",                   "BEAUMONT",
    "",                   "BELLASYLVA",
    "",                   "BOWMAN CREEK",
    "",                   "BROOKSIDE",
    "",                   "CARPENTER HOLLOW",
    "",                   "CENTER MORELAND",
    "",                   "COOPER CORNERS",
    */
    "DALL",               "DALLAS",
    "DALT",               "DALTON",
    "DIST",               "FALLS",
    /*
    "",                   "DIXON",
    "",                   "EAST LEMON",
    "",                   "EATONVILLE",
    "",                   "EVANS FALLS",
    */
    "FACT",               "FACTORYVILLE",
    "FALL",               "FALLS",
    "FORK",               "FORKSTON",
    "HARG",               "PITTSTON",
    "GLENBURN",           "GLENBURN",
    "HARV",               "HARVEYS LAKE",
    /*
    "",                   "HETTESHEIMER CORNERS",
    "",                   "HOBAN HEIGHTS",
    */
    "HOPB",               "HOP BOTTOM",
    /*
    "",                   "JENKS",
    "",                   "JENNINGSVILLE",
    "",                   "KAISERVILLE",
    "",                   "KASSON BROOK",
    "",                   "KEELERSBURG",
    "",                   "LAKE CAREY",
    */
    "LARKSVILLE",         "LARKSVILLE",
    /*
    "",                   "LEMON",
    "",                   "LOCKVILLE",
    "",                   "LOVELTON",
    "",                   "MARCY",
    */
    "MEHO",               "MEHOOPANY",
    /*
    "",                   "MILL CITY",
    */
    "MONT",               "MONTROSE",
    /*
    "",                   "MYOBEACH",
    "",                   "NORTH MEHOOPANY",
    */
    "NOXE",               "NOXEN",
    /*
    "",                   "OSTERHOUT",
    */
    "PITT",               "PITTSTON",
    /*
    "",                   "ROCKY FOREST",
    "",                   "ROSENGRANT",
    "",                   "RUGGLES",
    "",                   "SCOTTSVILLE",
    "",                   "SCRANTON CORNERS",
    "",                   "SKINNERS EDDY",
    "",                   "SOUTH EATON",
    "",                   "STARKVILLE",
    "",                   "STOWELL",
    "",                   "STULL",
    "",                   "VERNON",
    "",                   "VOSBURG",
    "",                   "WEST NICHOLSON",
    "",                   "WYOANNA",
    */
    "WYAL",               "WYALUSING",
    "WYOM",               "WYOMING",
    
//      BOROUGHS
    "LACE",               "LACEYVILLE",
    "MESH",               "MESHOPPEN",
    "NICH",               "NICHOLSON",
    "TUNK",               "TUNKHANNOCK",
    
//  TOWNSHIPS
    /*
      "BRAINTRIM",
      "CLINTON",
      "DALLAS TWP",         "DALLAS TOWNSHIP",
      "EATON",
      "EXETER",
      "FALLS",
      "FORKSTON",
      "LEMON",
      "LA PLUME",
      "MEHOOPANY",
      "MESHOPPEN",
      "MONROE",
      "NORTH BRANCH",
      "NORTHMORELAND",
      "OVERFIELD",
      "WASHINGTON",
      "WINDHAM",
*/

//  CENSUS-DESIGNATED PLACES
    /*
      "LAKE WINOLA",
      "WEST FALLS",
    */
   });
 }
