package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Franklin County, VA
 */
public class VAFranklinCountyBParser extends DispatchSouthernParser {
  
  public VAFranklinCountyBParser() {
    super(CITY_LIST, "FRANKLIN COUNTY", "VA", DSFLAG_FOLLOW_CROSS | DSFLAG_LEAD_UNIT, "(?:CO|SQ)\\d+");
  }
      
  
  @Override
  public String getFilter() {
    return "911@FCSO.COM";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  private static String[] CITY_LIST = new String[]{

    // Cities
    "BOONES MILL",
    "ROCKY MOUNT",

    // Unincorporated communities
    "BENT MOUNTAIN",
    "CALLAWAY",
    "FERRUM",
    "GLADE HILL",
    "HALES FORD",
    "HARDY",
    "NORTH SHORE",
    "PENHOOK",
    "REDWOOD",
    "SNOW CREEK",
    "UNION HALL",
    "WESTLAKE CORNER",
    "WIRTZ",
    
    // Bedford County
    "BEDFORD",
    "BIG ISLAND",
    "CHAMBLISSBURG",
    "FOREST",
    "GOODE",
    "HARDY",
    "HUDDLESTON",
    "MONETA",
    "MONTVALE",
    "NEW LONDON",
    "STEWARTSVILLE",
    "THAXTON",
    
    // Floyd County
    "ALUM RIDGE",
    "BURKS FORK",
    "CARTHAGE",
    "CHECK",
    "CONNERS GROVE",
    "COPPER HILL",
    "COPPER VALLEY",
    "COURT HOUSE",
    "DUNCAN",
    "FLOYD",
    "HAYCOCK",
    "HEMLOCK",
    "HUFFVILLE",
    "INDIAN VALLEY",
    "LAUREL BRANCH",
    "LITTLE RIVER",
    "LOCUST VALLEY",
    "MABRY MILL",
    "MARTINSVILLE",
    "PIZARRO",
    "POFF",
    "SHELORS MILL",
    "SIMPSONS",
    "SMART",
    "SOWERS",
    "TERRYS FORK",
    "TURTLE ROCK",
    "UNION",
    "WILLIS",
    
    // Henry County
    "AXTON",
    "BASSETT",
    "CHATMOSS",
    "COLLINSVILLE",
    "FIELDALE",
    "HENRY",
    "HORSEPASTURE",
    "LAUREL PARK",
    "OAK LEVEL",
    "RIDGEWAY",
    "SANDY LEVEL",
    "SPENCER",
    "STANLEYTOWN",
    "VILLA HEIGHTS",
    
    // Patrick County
    "ARARAT",
    "CLAUDVILLE",
    "CRITZ",
    "FAIRYSTONE",
    "MAYBERRY",
    "MEADOWS OF DAN",
    "PATRICK SPRINGS",
    "PENNS STORE",
    "REYNOLDS HOMESTEAD",
    "RUSSELL CREEK",
    "STUART",
    "VESTA",
    "WOOLWINE",
    
    // Bachelors Hall
    "BACHELORS HALL",
    "BLAIRS",
    "BROSVILLE",
    "CHALK LEVEL",
    "CHATHAM",
    "CLIMAX",      //?
    "DRY FORK",
    "GRETNA",      //?
    "GRIT",
    "HURT",                //+
    "KEELING",
    "MOUNT AIRY",
    "MT HERMON",
    "PICKERAL'S CROSSING",
    "PITTSVILLE",
    "RENAN",
    "RINGGOLD",
    "SONANS",
    "STRAIGHTSTONE",
    "TIGHTSQUEEZE",
    "WHITTLES DEPOT",
    
    // Roanoke County
    "BACK CREEK",
    "BENT MOUNTAIN",
    "BONSACK",
    "CATAWBA",
    "CAVE SPRING",
    "CLEARBROOK",
    "FORT LEWIS",
    "GLENVAR",
    "HANGING ROCK",
    "HOLLINS",
    "MASONS COVE",
    "MOUNT PLEASANT",
    "OAK GROVE",
    "PENN FOREST",
    "POAGES MILL",
    "READ MOUNTAIN",
    "VINTON",


  };

}