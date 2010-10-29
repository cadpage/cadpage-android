package net.anei.cadpage.parsers;

import net.anei.cadpage.Log;
import net.anei.cadpage.SmsMsgInfo.Data;
/*
Northglenn and Comerce City (Adams County), CO
contact: Brad Jones <brad@jones.name>
sender: dispatch@northglennambulance.com
- part 1 of 1 / RC:Run# 10174/6211 OLIVE ST///Pregnancy / Childbirth/
- part 1 of 1 / RC:Run# 9913/5541 E 67TH AVE//med alarm/Not Available/
- part 1 of 1 / RC:Run# 9911/7373 BIRCH ST///Unconscious / Fainting/
- part 1 of 1 / RC:Run# 10172/8810 E 88TH AVE///Assault/
- part 1 of 1 / RC:Run# 10119/E 60TH AVE & DAHLIA ST//./Unconscious / Fainting/
*/

public class COAdamsCountyParser extends SmsMsgParser {

  @Override
  public boolean isPageMsg(String body) {
    return body.contains("RC:Run# ");
  }

  @Override
  protected void parse(String body, Data data) {
    Log.v("DecodeAdamsCountyPage: Message Body of:" + body);
    data.defState="CO";
    data.defCity = "ADAMS COUNTY";
    
    int pt = body.indexOf("RC:Run# ");
    if (pt < 0) return;
    body = body.substring(pt+8);
    int ndx = 0;
    for (String line : body.split("/+")) {
      ndx++;
      switch (ndx) {
      case 1:
        data.strCallId = line.trim();
        break;
        
      case 2:
        data.strAddress = line.trim();
        break;
        
      default:
        line = line.trim();
        if (line.length() > 1) {
          if (data.strCall.length() > 0) data.strCall += " / ";
          data.strCall += line;
        }
        break;
      }
    }
  }
}
