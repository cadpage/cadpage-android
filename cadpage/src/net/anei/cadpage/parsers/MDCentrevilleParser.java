package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/******************************************************************************
Centreville, MD Sample messages
Contact: Contact: David baker <baker.davidm@gmail.com> ?
qac911:*D 4-2 COMMERCIAL BLDG FIRE DUNKIN DONUTS @500 CHURCH HILL RD COMMERCIAL BOX Q04
qac911:*D 4-5 MVC W/ENTRAPMENT RT301NB / RT304 RESCUE BOX Q04
qac911:*D 5-1 LG BRUSH/GRASS FIRE RT405 / WINDSWEPT FARM LN BRUSH BOX Q05
qac911:*D 4-5 UNCONSCIOUS/FAINTING RT301NB / ROLLING BRIDGE RD UNCONSCIOUS Q04
qac911:*D 5-2 MVC W/ROLLOVER RT301NB / HAYDEN RD RESCUE BOX Q05
qac911:*D 4-7 MVC W/ROLLOVER 1627 RUTHSBURG RD RESCUE BOX Q04
(text message) qac911:*D 4-2 CO ALARM 212 NORTHFIELD WAY LOCAL BOX Q04
******************************************************************************/

public class MDCentrevilleParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "MD";
  private static final String DEF_CITY = "CENTREVILLE";
  
  public MDCentrevilleParser() {
    super(DEF_CITY, DEF_STATE);
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    int ipt = body.indexOf("qac911:*D ");
    if (ipt < 0) return false;
    body = body.substring(ipt+10);
    
    // OK, go do your magic!!
    parseAddress(StartType.START_CALL, body, data);
    return true;
  }
}
