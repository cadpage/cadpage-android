package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernPlusParser;


public class TNSevierCountyParser extends DispatchSouthernPlusParser {
  
  
  public TNSevierCountyParser() {
    super(CITY_LIST, "SEVIER COUNTY", "TN", DSFLAG_LEAD_PLACE | DSFLAG_FOLLOW_CROSS );
  }
  
  @Override
  public String getFilter() {
    return "Central_Dispatch@mydomain.com";
  }
  
  private static final String[] CITY_LIST = new String[]{

    "ALDER BRANCH",
    "BEECH SPRINGS",
    "BOYDS CREEK",
    "CATLETTSBURG",
    "CATON",
    "CHEROKEE HILLS",
    "COUNTRY CASCADES",
    "COSBY",
    "DUPONT",
    "GATLINBURG",
    "KODAK",
    "LAUREL",
    "OLDHAM",
    "PIGEON FORGE",
    "PITTMAN CENTER",
    "REAGANTOWN",
    "SEVIERVILLE",
    "SEYMOUR",
    "SHADY GROVE",
    "STRAWBERRY PLAINS",
    "TRUNDLES CROSSROADS",
    "WEARS VALLEY"
    
  };

}
