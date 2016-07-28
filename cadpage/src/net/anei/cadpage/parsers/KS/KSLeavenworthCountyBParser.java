package net.anei.cadpage.parsers.KS;

import java.util.Properties;
import net.anei.cadpage.parsers.dispatch.DispatchH02Parser;

public class KSLeavenworthCountyBParser extends DispatchH02Parser {
  
  public KSLeavenworthCountyBParser() {
    super(CITY_CODES, "LEAVENWORTH COUNTY", "KS");
  }
  
  @Override
  public String getFilter() {
    return "CAD@LEAVENWORTHCOUNTY.ORG";
  }

  static final Properties CITY_CODES = buildCodeTable(new String[]{
//i was going to fill this in when i pulled cities from the test parser. but.

  });
}
