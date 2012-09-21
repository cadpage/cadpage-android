package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

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

 
Contact: Eric Taylor <ericferretttt@gmail.com>
Dispatch2@ci.waynesboro.va.us Msg: Dispatch2:RESPOND 368 WALNUT AVE FALL, BACK INJURY
Dispatch2@ci.waynesboro.va.us Msg: Dispatch2:RESPOND LIFELINE ACTIVATION - FALL SPRINGDALE APTS 300 S WAYNE AVE APT 12
Dispatch@ci.waynesboro.va.us Msg: Dispatch:RESPOND 142 PHEASANT RUN HEADACHE, DIFFICULTY , 14 Y/O COUNTY 1

Contacat: Gary Critzer <wemsdir1@gmail.com>
Sender: eocdir@ci.waynesboro.va.us
eocdir@ci.waynesboro.va.us Msg: eocdir:respond chest pain 250 S Wayne ave
eocdir@ci.waynesboro.va.us Msg: eocdir:chest pain, 401 wayneridge rd, medic

 */


public class VAWaynesboroParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "VA";
  private static final String DEF_CITY = "WAYNESBORO";
  
  private static final Pattern MARKER = Pattern.compile("^(?:Dispatch\\d?|eocdir):");
  
  public VAWaynesboroParser() {
    super(DEF_CITY, DEF_STATE);
  }
  
  @Override
  public String getFilter() {
    return "@ci.waynesboro.va.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    
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
    if (getStatus() == 0) return false;
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


