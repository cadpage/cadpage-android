package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernPlusParser;

/**
 * Carteret county, NC
 */
public class NCCarteretCountyParser extends DispatchSouthernPlusParser {
  
  public NCCarteretCountyParser() {
    super(CITY_LIST, "CARTERET COUNTY", "NC", 
          DSFLAG_DISPATCH_ID | DSFLAG_NO_NAME_PHONE | DSFLAG_ID_OPTIONAL);
  }
  
  @Override
  public String getFilter() {
    return "cec@carteretcountygov.org,@sealevelfire-rescue.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {

    if (!super.parseMsg(subject, body, data)) return false;
    
    // Sometimes city name is duplicated in address
    // which ends up as the place name
    if (data.strCity.equals(data.strPlace)) data.strPlace = "";
    return true;
  }
  

  private static final String[] CITY_LIST = new String[]{
    "ATLANTIC BEACH",
    "BEAUFORT",
    "BOGUE",
    "CAPE CARTERET",
    "CEDAR POINT",
    "EMERALD ISLE",
    "INDIAN BEACH",
    "MOREHEAD CITY",
    "NEWPORT",
    "PELETIER",
    "PINE KNOLL SHORES",
    
    "ATLANTIC",
    "BETTIE",
    "BROAD CREEK",
    "CEDAR ISLAND",
    "DAVIS",
    "GALES CREEK",
    "GLOUCESTER",
    "HARKERS ISLAND",
    "HARLOWE",
    "LOLA",
    "MARSHALLBERG",
    "MERRIMON",
    "MILL CREEK",
    "NORTH RIVER",
    "OCEAN",
    "OTWAY",
    "SALTER PATH",
    "SEA GATE",
    "SEA LEVEL",
    "STACY",
    "STELLA",
    "STRAITS",
    "SMYRNA",
    "WILDWOOD",
    "WILLISTON",
    "WIREGRASS"
   
  };

}
