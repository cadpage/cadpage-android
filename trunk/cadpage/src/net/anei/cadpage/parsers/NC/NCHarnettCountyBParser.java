package net.anei.cadpage.parsers.NC;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCHarnettCountyBParser extends DispatchSouthernParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("\\b\\d{1,2}:\\d\\d:\\d\\d \\d\\d/\\d\\d/\\d\\d\\b|\\bGINO\\(EN\\)");
  
  public NCHarnettCountyBParser() {
    super(NCHarnettCountyParser.CITY_LIST, "HARNETT COUNTY", "NC", 
           DSFLAG_OPT_DISPATCH_ID | DSFLAG_LEAD_PLACE | DSFLAG_CROSS_NAME_PHONE | DSFLAG_ID_OPTIONAL);
  }

  @Override
  public String getFilter() {
    return "GINO@southernsoftware.net";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (RUN_REPORT_PTN.matcher(body).find()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    return super.parseMsg(body, data);
  }
}