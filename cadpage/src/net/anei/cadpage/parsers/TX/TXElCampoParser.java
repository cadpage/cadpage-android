
package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchA53Parser;


public class TXElCampoParser extends DispatchA53Parser {

  public TXElCampoParser() {
    super("EL CAMPO", "TX");
  }
  
  @Override
  public String getFilter() {
    return "@cityofelcampo.org";
  }
}
