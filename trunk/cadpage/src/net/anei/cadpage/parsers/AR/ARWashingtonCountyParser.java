package net.anei.cadpage.parsers.AR;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA34Parser;

/**
 * Washington County, AR
 */
public class ARWashingtonCountyParser extends DispatchA34Parser {
  
  public ARWashingtonCountyParser() {
    super("WASHINGTON COUNTY", "AR");
  }
  
  @Override
  public String getFilter() {
    return "DONOTREPLY@SPRINGDALEAR.GOV";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("CAD call ")) return false;
    return super.parseMsg(body, data);
  }
}
