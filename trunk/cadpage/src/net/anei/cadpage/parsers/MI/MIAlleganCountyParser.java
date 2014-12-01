package net.anei.cadpage.parsers.MI;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;


/**
 * Allegan County, MI
 */
public class MIAlleganCountyParser extends DispatchA9Parser {
  
  public MIAlleganCountyParser() {
    super(null, "ALLEGAN COUNTY", "MI");
    setupGpsLookupTable(GPS_LOOKUP_TABLE);
  }
  
  @Override
  public String getFilter() {
    return "centraldispatch@allegancounty.org";
  }
  
  @Override
  protected String adjustGpsLookupAddress(String address) {
    return stripFieldEnd(address, " HWY");
  }

  private static final Properties GPS_LOOKUP_TABLE = buildCodeTable(new String[]{
      "34 NB I 196", "42.59336,-86.21648",
      "34 SB I 196", "42.59336,-86.21688",
      "35 NB I 196", "42.60745,-86.21864",
      "35 SB I 196", "42.60745,-86.21900",
      "36 NB I 196", "42.62398,-86.21078",
      "36 SB I 196", "42.62398,-86.21128",
      "37 NB I 196", "42.63197,-86.19904",
      "37 SB I 196", "42.63197,-86.19955",
      "38 NB I 196", "42.64425,-86.18860",
      "38 SB I 196", "42.64425,-86.18897",
      "39 NB I 196", "42.65541,-86.18390",
      "39 SB I 196", "42.65541,-86.18426",
      "40 NB I 196", "42.66707,-86.17190",
      "40 SB I 196", "42.66707,-86.17292",
      "41 NB I 196", "42.68180,-86.16984",
      "41 SB I 196", "42.68180,-86.17020",
  });
  
}
