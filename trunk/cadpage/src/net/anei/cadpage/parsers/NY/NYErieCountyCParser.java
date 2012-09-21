package net.anei.cadpage.parsers.NY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Erie County, NY (Variant C)
Contact: "joshkunch@msn.com" <joshkunch@msn.com>
Contact: Peter <pputnam1@verizon.net>

Erie_Alert EDEN 2097 SHERMAN- 1 YOA MALE CHOKING 15 TO HALL NEED 1 ADD'L  <NOREPLY>
Erie_Alert MES/NCEMS: ALL MEMBERS PARTICIPATING IN THE MEMORIAL DAY PARADE MEET @ HALL ON MON 5/28 @ 0815 HRS IN FULL DRESS UNIFORM  <NOREPLY>
Erie_Alert ANIMAL INJURY  TN OF EDEN EDEN 805+707 TO REESPOND COLD TO 2880 BELKNAP FOR INJURED ANIMAL EXTRACTION  <NOREPLY>
Erie_Alert FIRST AID 2209 EDEN EVANS CNTR RD EDEN 76/F TROUBLE BREATHING CONCIOUS AND ALERT 55+13+M1 TO HALL  <NOREPLY>
Erie_Alert EMS: MHL 9.41 transport - Assemble a crew at the squad hall & wait for patrol to secure the scene - BLS cold response - 11, 27, 37, 55 
Erie_Alert Working  Fire: working structure fire front of house on fire across from 2833 e church st at 2833 E CHURCH ST, Eden  c/s: HAMMOND DR . . ... 
Erie_Alert FIRST AID 2724 W CHURCH ST EDEN 60/F FELL INSIDE THE BUILDING. CONSCIOUS AND ALERT. 49 TO THE HALL. MEDIC ONE TO THE SCE  <NOREPLY>
Erie_Alert FIRST AID. MEET WITH PATROL FOR A 20/F ARM INJ FROM AN ACCIDENT CLARKSBURG/NEW OREGON 63/72 TO THE HALL  <NOREPLY>
Erie_Alert 8202 E EDEN RD APT: 3 EDEN UPPER- USE DOOR ON LEFT SIDE OF BLDG,  FEMALE- BREATHING BUT UNRESPONSIVE-35, 41 TO HALL NEE  <NOREPLY>

 */


public class NYErieCountyCParser extends SmartAddressParser {
  
  private static final Pattern TRAIL_JUNK = Pattern.compile("[\\. ]+$");
  
  public NYErieCountyCParser() {
    super("ERIE COUNTY", "NY");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (! body.startsWith("Erie_Alert ")) return false;
    body = body.substring(11).trim();
    if (body.endsWith("<NOREPLY>")) body = body.substring(0,body.length()-9).trim();
    body = TRAIL_JUNK.matcher(body).replaceAll("");
    
    String saveBody = body;
    
    int pt = body.indexOf(" c/s:");
    if (pt >= 0) {
      data.strCross = body.substring(pt+5).trim();
      body = body.substring(0,pt).trim();
    }
    
    parseAddress(StartType.START_CALL, FLAG_IGNORE_AT, body, data);
    data.strSupp = getLeft();
    if (getStatus() == 0) {
      return data.parseGeneralAlert(saveBody);
    }
    
    pt = data.strCall.indexOf(':');
    if (pt >= 0) {
      data.strSupp = append(data.strCall.substring(pt+1).trim(), " / ", data.strSupp);
      data.strCall = data.strCall.substring(0,pt).trim();
    }
    
    return true;
  }
}
