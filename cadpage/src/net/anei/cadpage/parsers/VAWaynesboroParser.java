package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Waynesboro, VA (Augusta County)
Contact: Bruce C <rescue5medic@gmail.com>
Sender: Dispatch2@ci.waynesboro.va.us or Dispatch@ci.waynesboro.va.us

Dispatch2:RESPOND SEIZURES 14 FRONTIER RIDGE CT, AP1302 SARS 1
Dispatch2:MVC, HEAD ON COLLISION MAIN-ROSSER-BROAD
Dispatch:RESPOND - 2ND CALL - CHEST PAIN - 1142 NEW HOPE RD, AP3
Dispatch:RESPOND GENERAL ILLNESS 1429 2ND ST MEDICAL ALARM ACTIVATION
Dispatch:RESPOND 2ND CALL 216 ELKIN CIR CHEST PAINS
Dispatch:RESPOND - 809 GRAYSON AVE - VEH OVER AN EMBANKMENT
Dispatch:300 BLK PATTON FARM RD - SQAUD 2 REQUESTED - PRI1 PT WITH ENTRAPMENT - OPERATE COUNTY 1
 */


public class VAWaynesboroParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "VA";
  private static final String DEF_CITY = "WAYNESBORO";
  
  public VAWaynesboroParser() {
    super(DEF_STATE);
  }
  
  @Override
  public String getFilter() {
    return "Dispatch2@ci.waynesboro.va.us,Dispatch@ci.waynesboro.va.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    data.defState = DEF_STATE;
    data.defCity = DEF_CITY;
    
    // Strip everything in from of colon
    int ipt = body.indexOf(':');
    if (ipt >= 0) body = body.substring(ipt+1).trim();
    
    if (body.startsWith("RESPOND ")) {
      body = body.substring(7).trim();
    }
    if (body.startsWith("- ")) {
      body = body.substring(2).trim();
    }
    
    // All commas must go
    body = body.replaceAll(",", "");
    
    // This is about as good as we are going to get
    parseAddress(StartType.START_CALL, body, data);
    data.strSupp = getLeft();
    
    if (data.strCall.endsWith(" -")) {
      data.strCall = data.strCall.substring(0, data.strCall.length()-2).trim();
    }
    if (data.strSupp.startsWith("- ") || data.strSupp.startsWith(", ")) {
      data.strSupp = data.strSupp.substring(2).trim();
    }
    if (data.strCall.length() == 0) {
      data.strCall = data.strSupp;
      data.strSupp = "";
    }
    
    return true;
  }    
}


