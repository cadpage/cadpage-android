package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchA47Parser;


public class OHCentervilleParser extends DispatchA47Parser {
  
  public OHCentervilleParser() {
    super("DISPATCH CFS INFO", CITY_LIST, "CENTERVILLE", "OH");
  }
  
  @Override
  public String getFilter() {
    return "SWMail@centervilleohio.gov";
  }

  private static final String[] CITY_LIST =new String[]{
    "CENTERVILLE",
    "WEST CARROLLTON"
  };
}
