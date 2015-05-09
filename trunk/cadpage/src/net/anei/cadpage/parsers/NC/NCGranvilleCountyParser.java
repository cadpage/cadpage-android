package net.anei.cadpage.parsers.NC;


import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCGranvilleCountyParser extends DispatchSouthernParser {
  
  public NCGranvilleCountyParser() {
    super(CITY_LIST, "GRANVILLE COUNTY", "NC", 
           DSFLAG_DISPATCH_ID | DSFLAG_CROSS_NAME_PHONE | DSFLAG_LEAD_PLACE | DSFLAG_ID_OPTIONAL);
  }

  @Override
  public String getFilter() {
    return "@granvillecounty.org";
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities and towns
    "BUTNER",
    "CREEDMOOR",
    "OXFORD",
    "STEM",
    "STOVALL",
    
    // Unincorporated communities
    "BEREA",
    "BRASSFIELD",
    "BRAGGTOWN",
    "BULLOCK",
    "CULBRETH",
    "GRISSOM",
    "LEWIS",
    "SHAKE RAG",
    "SHOOFLY",
    "TALLY HO",
    "WILTON",
    
    // Franklin County
    "FRANKLINTON"
  };
}