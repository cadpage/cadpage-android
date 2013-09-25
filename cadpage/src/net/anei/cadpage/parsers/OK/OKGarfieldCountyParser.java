package net.anei.cadpage.parsers.OK;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchA30Parser;


public class OKGarfieldCountyParser extends DispatchA30Parser {
  
  
  public OKGarfieldCountyParser() {
    super(CITY_LIST, "F", "GARFIELD COUNTY", "OK");
  }
  
  @Override
  public String getFilter() {
    return "911firedispatch@enid.org";
  }
  
  @Override
  public String adjustMapAddress(String address) {
    return HWY412_PTN.matcher(address).replaceAll("US 412");
  }
  private static final Pattern HWY412_PTN = Pattern.compile("\\bHWY *412\\b", Pattern.CASE_INSENSITIVE);
  
  private static final String[] CITY_LIST = new String[]{
    "BISON",
    "BRECKENRIDGE",
    "CARRIER",
    "COVINGTON",
    "DOUGLAS",
    "DRUMMOND",
    "ENID",
    "FAIRMONT",
    "GARBER",
    "HILLSDALE",
    "HUNTER",
    "KREMLIN",
    "LAHOMA",
    "NORTH ENID",
    "WAUKOMIS",
    
    "GARFIELD COUNTY"
  };

}
