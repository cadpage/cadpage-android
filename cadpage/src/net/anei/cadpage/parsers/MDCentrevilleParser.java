package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/******************************************************************************
Centreville, MD Sample messages
qac911:*D 4-2 COMMERCIAL BLDG FIRE DUNKIN DONUTS @500 CHURCH HILL RD COMMERCIAL BOX Q04
qac911:*D 4-5 MVC W/ENTRAPMENT RT301NB / RT304 RESCUE BOX Q04
qac911:*D 5-1 LG BRUSH/GRASS FIRE RT405 / WINDSWEPT FARM LN BRUSH BOX Q05
qac911:*D 4-5 UNCONSCIOUS/FAINTING RT301NB / ROLLING BRIDGE RD UNCONSCIOUS Q04
qac911:*D 5-2 MVC W/ROLLOVER RT301NB / HAYDEN RD RESCUE BOX Q05
qac911:*D 4-7 MVC W/ROLLOVER 1627 RUTHSBURG RD RESCUE BOX Q04
******************************************************************************/

public class MDCentrevilleParser extends SmartAddressParser {

  @Override
  public boolean isPageMsg(String body) {
    return body.startsWith("qac911:*D ");
  }

  @Override
  protected void parse(String body, Data data) {

    data.defState="MD";
    data.defCity="CENTREVILLE";
    
    // Strip off prefix
    if (body.length() <= 10) return;
    body = body.substring(10);
    
    // Sometimes that use an @ to mark the start of the address
    // in which case life gets a lot easier
    StartType sType;
    int ipt = body.indexOf('@');
    if (ipt >= 0) {
      
      data.strCall = body.substring(0, ipt).trim();
      body = body.substring(ipt+1);
      sType = StartType.START_ADDR;
    }
    
    // Otherwise the address parser will have to find the address start
    else {
      sType = StartType.START_CALL;
    }
    
    // OK, go do your magic!!
    parseAddress(sType, body, data);
  }
}
