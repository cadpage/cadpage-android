package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.dispatch.DispatchA44Parser;

public class NJMarlboroParser extends DispatchA44Parser {

  public NJMarlboroParser() {
    super("MARLBORO", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "ripandrun@marlboropd.org";
  }
}
