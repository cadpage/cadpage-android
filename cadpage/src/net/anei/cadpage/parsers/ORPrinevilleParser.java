package net.anei.cadpage.parsers;

import net.anei.cadpage.Log;
import net.anei.cadpage.SmsMsgInfo.Data;
/*
Prineville, OR
Reporting email: 5414603655@vzwpix.com
Sender:dispatch@prinevillepd.org

Neither of these maps, sloppy addresses
(PPD) 6:01 PM\nNEW EVENT PFD\nMED1\n1201: 1271\n228 SW MEADOWLAKES DR\nPRINEVILLE
(PPD) 3:17 PM\nNEW EVENT PFD\nMVA\n1201: 1273 / 1225\nLAMONTA/PIONEER CUTSTOCK\nPRINEVILLE
*/

public class ORPrinevilleParser extends SmsMsgParser {

  @Override
  public boolean isPageMsg(String body) {
    return body.startsWith("(PPD)");
  }

  @Override
  protected void parse(String body, Data data) {
    Log.v("decodePrinevillePage: Message Body of:" + body);
    data.defState = "OR";
    data.defCity = "PRINEVILLE";
    
    String[] lines = body.split("\n");
    if (lines.length > 2) data.strCall = lines[2];
    if (lines.length > 4) parseAddress(lines[4], data);
    if (lines.length > 5) data.strCity = lines[5];
  }
}
