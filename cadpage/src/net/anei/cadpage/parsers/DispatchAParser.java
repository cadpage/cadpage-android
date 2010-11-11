package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/**
 * This class parses messages from some as yet unidentified CAD software vendor
 **/

/*
Smyrna, GA
Contact: "Dustin Davey" <ddavey@ci.smyrna.ga.us>
Sender: cad@ci.smyrna.ga.us
CAD:FYI: ;STRUCTURE FIRE;2501 WOODLANDS DR SE;FLAMES INSIDE FUSE BOX INSIDE CALLERS APARTMENT. SMELLS WIRES BURNING. [08/08/10 22:53:28 DTHACKER];103157
CAD:Update: ;VEHICLE FIRE;S COBB DR SE/BOURNE DR SE;METRO PCS;OWNER OF VEH CALLED --- ADV ON 280 AT WH [10/11/10 17:46:52 ABERRY] blk dodge charger on fire [10/
CAD:FYI: ;VEHICLE FIRE;WINDY HILL RD SE/S COBB DR SE;METRO PCS;blk dodge charger on fire [10/11/10 17:46:16 DSNIVELY] ;104107
CAD:Update: ;STRUCTURE FIRE;501 WALTON WAY SE;S COBB DR SE;apt 501 [09/23/10 15:17:59 MBAGNATO] ;103832
CAD:FYI: ;FIRE GENERAL;4586-W VALLEY PKWY SE;S COBB DR SE;ASHLEY;heavy smoke [10/09/10 03:49:27 SMAHAMA] smoke coming from the unit below her [10/09/10 03:48:51


Livingston County, MI
CAD:FYI: ;ALARMF;11555 PLEASANT VIEW DR;INDIAN TRL;SMOKE ALARMS GOING OFF IN THE HOUSE FOR THE LAST 30 MIN ON AND OFF/ NO SMOKE OR SMOKE SHOWING [09/24/10 04:17:07 ECOOK]
CAD:FYI: ;UNKACC;E M36/PETTYS RD;VEHICLE HIT A POLE/ MALE RUNNING E/B FROM SCENE [09/23/10 21:45:06 ECOOK]
CAD:FYI: ;CHSTPN;8422 PAWNEE TRL;SHOSHONI PASS;[Medical Priority Info] RESPONSE: P1 STA 1 4 5 6 7 8 FC FT RESPONDER SCRIPT: 72 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. Cal
CAD:FYI: ;UNCON;8732 RIVER VALLEY RD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 63 year old, Female, Conscious, Breathing. Unconscious / Fainting (Near). Not alert. Caller Statement: UNCON.

Pagecopy-Fr:CAD@lc911\nCAD:FYI: ;CHSTPN;7251 HAMBURG RD;WELLE RD;[Medical Priority Info] RESPONSE: P1 STA 1 3 4 5 6 7 8 FC FT RESPONDER S
*/

public class DispatchAParser extends SmsMsgParser {
  
  private String defCity;
  private String defState;
  
  public void setDefaults(String defCity, String defState) {
    this.defCity = defCity;
    this.defState = defState;
  }

  @Override
  public boolean isPageMsg(String body) {
    int pt = body.indexOf("CAD:");
    if (pt < 0) return false;
    return (pt == 0 || body.charAt(pt-1) == '\n');
  }

  @Override
  protected void parse(String body, Data data) {
    data.defState=defState;
    data.defCity = defCity;
    
    body = body.trim();
    String[] AData = body.split(";");
    
    if (AData.length <= 1) return;
    data.strCall = AData[1].trim();
    
    if (AData.length <= 2) return;
    parseAddress(AData[2].replace("-", " "), data);
    
    int ndx = 3;
    while (ndx < AData.length) {
       String fld = AData[ndx].trim();
       int pt = fld.indexOf('[');
       if (pt >= 0) {
         data.strSupp = fld.substring(0,pt).trim();
         break;
       }
       if (data.strCross.length() > 0) data.strCross += " & ";
       data.strCross += fld;
       ndx++;
    }
  }
}
