package net.anei.cadpage.parsers.WY;

import net.anei.cadpage.parsers.dispatch.DispatchA20Parser;

/**
 * Park County, OR
 */
public class WYParkCountyParser extends DispatchA20Parser {
  
  public WYParkCountyParser() {
    super("PARK COUNTY", "WY");
  }
  
  @Override
  public String getFilter() {
    return "MMCCLAIN@parkcounty.us,JSCHMIDTBE@parkcounty.us,HORN@parkcounty.us,PPARISI@parkcounty.us,TBREWER@parkcounty.us,JSUMMERS@parkcounty.us,LMATHESS@parkcounty.us,CBAUGHER@parkcounty.us";
  }

}
