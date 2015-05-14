package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.dispatch.DispatchA44Parser;

public class NJOceanCityParser extends DispatchA44Parser {

  public NJOceanCityParser() {
    super("OCEAN CITY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "ocpd@ocnj.us";
  }

}
