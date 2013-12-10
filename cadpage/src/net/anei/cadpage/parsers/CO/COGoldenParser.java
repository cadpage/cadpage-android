package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA34Parser;

/**
 * Golden, CO
 */
public class COGoldenParser extends DispatchA34Parser {
  
  public COGoldenParser() {
    super("GOLDEN", "CO");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com,CADTOFIRE@CITYOFGOLDEN.NET";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Golden Fire") && !subject.startsWith("CAD call ")) return false;
    return super.parseMsg(body, data);
  }
}
