package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA25Parser;


public class MOLincolnCountyParser extends DispatchA25Parser {
  
  public MOLincolnCountyParser() {
    super("LINCOLN COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "EnterpolAlerts@PikeCountySO.org,lincolncounty911@LC911Dispatch.org,messaging@iamresponding.com";
  }
}
