package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Montgomery County, VA
 */
public class VAMontgomeryCountyParser extends DispatchSouthernParser {
    
  public VAMontgomeryCountyParser() {
    super(CITY_LIST, "MONTGOMERY COUNTY", "VA", DSFLAG_FOLLOW_CROSS);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ALLEGHANY SPRINGS",
    "BLACKSBURG",
    "BRADSHAW",
    "CHILDRESS",
    "CHRISTIANSBURG",
    "ELLETT",
    "ELLISTON-LAFAYETTE",
    "GRAYSONTOWN",
    "IRONTO",
    "LONG SHOP",
    "LUSTERS GATE",
    "MERRIMAC",
    "MCCOY",
    "MCDONALDS MILL",
    "PILOT",
    "PRICES FORK",
    "RINER",
    "ROGERS",
    "SHAWSVILLE",
    "SUGAR GROVE",
    "VICKER",
    "WALTON",
    "TOM'S CREEK",
    "YELLOW SULPHUR SPRINGS",
    "PLUM CREEK"
  };
}