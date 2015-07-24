package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.dispatch.DispatchA33Parser;

public class COGunnisonCountyParser extends DispatchA33Parser {


  public COGunnisonCountyParser() {
    super("GUNNISON COUNTY", "CO", "Closed");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCHCENTER@CITYOFGUNNISON-CO.GOV";
  }
}
