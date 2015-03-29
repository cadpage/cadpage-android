package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.dispatch.DispatchA54Parser;


public class MOStoneCountyAParser extends DispatchA54Parser {
  
  public MOStoneCountyAParser() {
    super("STONE COUNTY", "MO", DataType.INFO, "417");
  }
  
  public String getFilter() {
    return "cad@sces911.org";
  }
}
