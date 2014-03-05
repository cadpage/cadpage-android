package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;


/**
 * Madison County, IL
 */
public class ILMadisonCountyParser extends DispatchA9Parser {
  
  public ILMadisonCountyParser() {
    super(null, "MADISON COUNTY", "IL");
  }
  
  @Override
  public String getFilter() {
    return "glentelecom@glen-carbon.il.us";
  }
  
}
