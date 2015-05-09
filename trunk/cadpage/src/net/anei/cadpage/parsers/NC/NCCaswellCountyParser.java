

package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Chattam County, NC
 */
public class NCCaswellCountyParser extends DispatchSouthernParser {

  public NCCaswellCountyParser() {
    super(CITY_LIST, "CASWELL COUNTY", "NC", DSFLAG_OPT_DISPATCH_ID | DSFLAG_NO_NAME_PHONE);
    
    
  }
  @Override
  public String getFilter() {
    return "@caswellcountync.gov";
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = EXT_PTN.matcher(addr).replaceAll("EXD");
    addr = addr.replace("GATEWOOD RD EXD", "GATEWOOD EXD");
    return super.adjustMapAddress(addr);
  }
  private static final Pattern EXT_PTN = Pattern.compile("\\bEXT\\b", Pattern.CASE_INSENSITIVE);
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "MILTON",
    "YANCEYVILLE",
    
    // Townships
    "ANDERSON TWP",
    "HIGHTOWERS TWP",
    "LEASBURG TWP",
    "LOCUST HILL TWP",
    "PROVIDENCE TWP",
    "MILTON TWP",
    "PELHAM TWP",
    "STONEY CREEK TWP",
    "YANCEYVILLE TWP",

    // Unincorporated
    "CASVILLE",
    "LEASBURG",
    "PELHAM",
    "PROSPECT HILL",
    "PROVIDENCE",
    "PURLEY",
    "SEMORA",
    "CHERRY GROVE",
    "BLANCH"
  };
}
