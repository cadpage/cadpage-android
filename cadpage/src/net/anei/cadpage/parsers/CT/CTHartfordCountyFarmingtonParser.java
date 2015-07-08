package net.anei.cadpage.parsers.CT;

import java.util.Properties;


public class CTHartfordCountyFarmingtonParser extends CTNewHavenCountyBParser {
  
  public CTHartfordCountyFarmingtonParser() {
    super(CITY_LIST, CITY_CODES, "HARTFORD COUNTY", "CT");
  }
  
  @Override
  public String getFilter() {
    return "pdpaging@farmington-ct.org,paging@cantonfireandems.org";
  }
  
  private static final String[] CITY_LIST = new  String[]{

    // Cities
    "BRISTOL",
    "HARTFORD",
    "NEW BRITAIN",

    // Towns
    "AVON",
    "BERLIN",
    "BLOOMFIELD",
    "BURLINGTON",
    "CANTON",
    "EAST GRANBY",
    "EAST HARTFORD",
    "EAST WINDSOR",
    "ENFIELD",
    "FARMINGTON",
    "GLASTONBURY",
    "GRANBY",
    "HARTLAND",
    "MANCHESTER",
    "MARLBOROUGH",
    "NEWINGTON",
    "PLAINVILLE",
    "ROCKY HILL",
    "SIMSBURY",
    "SOUTH WINDSOR",
    "SOUTHINGTON",
    "SUFFIELD",
    "UNIONVILLE",
    "WEST HARTFORD",
    "WETHERSFIELD",
    "WINDSOR",
    "WINDSOR LOCKS"
  };
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
     "FARM", "FARMINGTON",
     "UNVL", "UNIONVILLE",
     "WLFD", "WALLINGFORD"
  });

}
