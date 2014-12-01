package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.dispatch.DispatchA1Parser;



public class PAMonroevilleParser extends DispatchA1Parser {
  
  public PAMonroevilleParser() {
    super("MONROEVILLE", "PA");
  }
  
  @Override
  public String getFilter() {
    return "alertts@monroeville.pa.us";
  }
}
