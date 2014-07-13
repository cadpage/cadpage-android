package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class NCWilkesCountyParser extends DispatchOSSIParser {
  
  public NCWilkesCountyParser() {
    super("WILKES COUNTY", "NC",
           "SRC ID DATETIME CALL ADDR!");
  }
  
  @Override
  public String getFilter() {
    return "CAD@wilkes.nc.local,CAD@wilkescounty.net";
  }
  
  @Override
  public String adjustMapAddress(String address) {
    address = NO_EXT_PTN.matcher(address).replaceAll("$1");
    address = EXT_EXD_PTN.matcher(address).replaceAll("$1 EXD");
    return super.adjustMapAddress(address);
  }
  private static final Pattern NO_EXT_PTN = Pattern.compile("\\b(WINKLER MILL RD) EXT", Pattern.CASE_INSENSITIVE);
  private static final Pattern EXT_EXD_PTN = Pattern.compile("\\b(COUNTRY CLUB RD) EXT", Pattern.CASE_INSENSITIVE);
}
