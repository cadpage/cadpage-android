package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Peoria County, IL
12/23/10 1223 N MURPHY RD CO :(12100) W JO DAN CT JUST N OF HERE, SEES ALOT OF BLK SMOKE 1137,006
12/26/10 2800 S ZESSIN RD CO :(20200) W MC DONALD RD 84 YOM CARRYING SOMETHING IN GARAGE, FELL BACKWARD, HIT HEAD ON CONCRETE, C/A/B OK
12/27/10 533 N BRAD CT HC :( 600) N PEKIN LN 82 YO MALE FELL HAS HEAD AND HIP INJ NO BLEEDING 1527,004
12/28/10 501 N MAIN ST HC :(12700) W LOGAN ST 74YOM C/A/B HAS A STAPLE EMBEDDED IN HER LEFT KNEE UNK TO PULL OUT
12/28/10 {10301}W LANCASTER RD CO :( 5500) S HARKERS CORNER RD ROLL OVER 1300,006
01/14/11 4712 W FARMINGTON RD CO :( 900) N SUNSET DR LAUNDRYMAT ON FIRE PEOPLE INSIDE BLDG UPSTAIRS IN AN APT OD WPEO FIREMAN SEES SMOKE
01/16/11 9726 W WHITTINGHAM PT CO :( 9700) W LAKE LANCELOT DR FEM FELL HR AGO CRACKED NOW VOMITING NOT ALERT ALSO IS A DIABETC 30 YR FEM
01/18/11 715 N MORAN RD CO :(19100) W FARMINGTON RD 72YOF PASSED OUT NOT ALERT BUT BREATH CARDIAC HX 0817,005
01/18/11 2922 S TURBETT RD CO :(12100) W SMITHVILLE RD FEM IN 20S FELL OUTSIDE UNC/B NEAR FORD EXPLORER 1505,005
01/19/11 13911 W SMITHVILLE RD CO :( 2500) S HANNA CITY-GLASFORD RD FEM DIFF BREATH 62 YOA CONSC/ALERT COME TO BACK DOOR
01/20/11 9508 W LAKE CAMELOT DR CO :( 4500) S TEWKESBURY RD 78YO MALE UNRESPONSIVE W/SHALLOW BREATH 0914,005
01/20/11 16327 W RIEKENA RD CO :(16300) W SMITHVILLE RD 72 YO MALE JST RELEASED FRM HOSP TODAY FRM BYPASS HAS AN1513,005 INCISION ON CHEST SERIOUS BLEEDING HAS SOAKED THRU TSHIRT1513,005 C/A/B OK RIGHT NOW 1513,005 (02/02)
S: M:10/03/11 415 W BUTTERNUT ST EL :( 400) N MORGAN ST MALE W/BAD HEADACHE FELL ON SAT AND WAS CKED OUT THEN BUT NOW REQ TRANSP BACK TO HOSP 94 Y (01/02)\n\n

St Joseph County, IN
Subject:CAD\n[!] ^ 11425 MCKINLEY HW PE :(55231) BELAIR STGAS LEAK FROM PUTING IN A POST 1626,006NIPSCO 1627,014PEN4A\n
Subject:CAD\n[!] ^ 17 RIVERCREST DR OS :( 600) N BEECH RDFROM MEDICAL ALARM COMP UNK MED 1617,006CALL BACK # TO ALARM COMP 800-325-17\n
Subject:CAD\n[!] CRASH021 ^ 2 BYPASS HW PE :(60000) ELM RD2 VEH UNK INJ 0613,010ME10 ,PENN1 
Subject:CAD\n[!] COMAL021 ^ 55693 ASH RD PE :(10000) ELSIE HWDUNGARVIN - COMMERCIAL FIRE ALARM - MANUAL 1233,014NOVI 800-877-3624 PRE 
Subject:CAD\n[!] RESAL021 ^ 54895 MONTPELLIER DR PE :(11500) BOISE RUN STRESIDENTIAL FIRE ALARM - HALLWAY SMOKE DETECTOR 0813,014PENN 
Subject:CAD\n[!] ^ 56375 CURRANT RD PE :(13402) ESTHER AVM. HEAD INJ FROM ASSULT 2147,014ME12 ,PENN2 
(NC)[!] INVES 03/23/12 POPPY LN :( ) OBTAIN MORE LOCATION INFOBETWEEN HICKORY AND HOLLY - UNKNOWN TYPE FIRE
(NC)[!] CRASH009 G-453 03/23/12 30750 SR 2 HW NC :(56000) LARRISON DRPI
(NC)[!] COMAL009 G-428 03/23/12 31869 CHICAGO TR NC :(51452) HAMILTON TRGENERAL FIRE-SIMPLEX SECURITY

*/


public class DispatchA6Parser extends SmartAddressParser {
  
  public DispatchA6Parser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState);
  }
  
  private static final Pattern LEAD_DATE_PAT = Pattern.compile("^(?:([- A-Z0-9]+) )?(?:\\d\\d/\\d\\d/\\d\\d|\\^) ");
  private static final Pattern TRAIL_TIME_PAT = Pattern.compile(" \\d{4},\\d{3} *$");
  private static final Pattern MID_ID_PAT = Pattern.compile(" :\\( *(\\d*) *\\) ");
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = LEAD_DATE_PAT.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    data.strCall = getOptGroup(match.group(1));
    
    match = TRAIL_TIME_PAT.matcher(body);
    if (match.find()) body = body.substring(0, match.start()).trim();
    
    match = MID_ID_PAT.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    
    String sAddr = body.substring(0,match.start()).replace('{', ' ').replace('}', ' ').trim();
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sAddr, data);
    body = body.substring(match.end()).trim();
    
    Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, body);
    if (res.getStatus() > 0) {
      res.getData(data);
      data.strSupp = res.getLeft();
    } else {
      data.strSupp = body;
    }
    
    return true;
  }
}
