package net.anei.cadpage.parsers;

import net.anei.cadpage.Log;
import net.anei.cadpage.SmsMsgInfo.Data;
/*
Tipton County, IN (or TN?)
reporting email: Amy Lane <ammlane@gmail.com>
sender: CAD@tipco.com
CAD:A5,R45,T43,E42,E41,T46;STRUCTURE FIRE RESIDENTIAL;4003;3000 N US 31 NB
CAD:WEATHER;SEVERE WEATHER;CITY;121-A W MADISON ST
CAD:G49;OUTSIDE FIRE-FIELD/WOODS;6001;6500 N 400 E
CAD:A5,R45;INJURED IN FALL;4000;E VINE ST/S WASHINGTON ST;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: You are responding to a patient involved in a fall
CAD:A5,R45;UNKNOWN MEDICAL PROBLEM;4004;3421 N SR 19;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: You are responding to a patient with an unknown problem
CAD:A5,R45;INJURED IN FALL;4002;304 E 625 N;hx of dementia [10/06/10 18:51:56 DARCIR] [Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: You are responding to
CAD:G49;OUTSIDE FIRE-FIELD/WOODS;6001;6500 N 400 E
Notes: 4 digit number between description and address should be ignored
*/

public class INTiptonCountyParser extends SmsMsgParserLegacy {
  
  @Override
  public String getFilter() {
    return "CAD@tipco.com";
  }

  @Override
  public boolean isPageMsg(String body) {
    return body.startsWith("CAD:");
  }

  @Override
  protected void parse(String body, Data data) {
    Log.v("decodeTiptonPage: Message Body of:" + body);
    data.defState = "IN";
    data.defCity = "TIPTON COUNTY";
    
    if (body.length() < 4) return;
    String[] lines = body.substring(4).split(";");
    data.strUnit = lines[0];
    if (lines.length > 1) data.strCall = lines[1];
    if (lines.length > 3) parseAddress(lines[3], data);
  }
}
