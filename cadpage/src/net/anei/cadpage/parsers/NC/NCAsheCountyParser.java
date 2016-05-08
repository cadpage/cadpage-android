
package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

public class NCAsheCountyParser extends DispatchSouthernParser {

  public NCAsheCountyParser() {
    super(CITY_LIST, "ASHE COUNTY", "NC", 0);
  }

  private static final String[] CITY_LIST = new String[]{
      //Towns

      "JEFFERSON",
      "LANSING",
      "WEST JEFFERSON",

  //Townships

      "CHESTNUT HILL",
      "CLIFTON",
      "CRESTON",
      "ELK",
      "GRASSY CREEK",
      "HELTON",
      "HORSE CREEK",
      "HURRICANE",
      "JEFFERSON",
      "LAUREL",
      "LAUREL SPRINGS",
      "NORTH FORK",
      "OBIDS",
      "OLD FIELDS",
      "PEAK CREEK",
      "PINE SWAMP",
      "PINEY CREEK",
      "POND MOUNTAIN",
      "WALNUT HILL",
      "WEST JEFFERSON",

  //Unincorporated Communities

      "BEAVER CREEK",
      "BINA",
      "CHESTNUT HILL",
      "CLIFTON",
      "COMET",
      "CRESTON",
      "CRUMPLER",
      "FIG",
      "FLEETWOOD",
      "GLENDALE SPRINGS",
      "GRASSY CREEK",
      "GRAYSON",
      "HELTON",
      "PARKER",
      "SCOTTVILLE",
      "STURGILLS",
      "TODD",
      "WARRENSVILLE"


  };
}
