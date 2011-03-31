package net.anei.cadpage.parsers.NY;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Nassau County, NY (Version A)
Contact: "rhfd48@optonline.net" <rhfd48@optonline.net>
Contact: 5163697556@vtext.com
Contact: Jeff Laureano  516-369-7556
System: Red Alert Apline Software

***SIG 9***  AMBU  27 PINE DR N [ROSLYN] c/s: PINE (S) DR/VERITY LA ADTNL: DIFF BREATHING GRID: K-14 TOA: 21:16 11/30/2010
***CHIEF***  AUTO BAR FRITES 400 WHEATLEY PLAZ [GREENVALE] c/s: GLEN COVE ROAD/NORTHERN BLVD ADTNL: ZONE 20 GRID: M-13 TOA: 18:28 11/30/2010
***SIG 9***  AMBU BURGER KING 110 NORTHERN BLVD [GREENVALE] c/s: TOWN PATH/GLEN COVE ROAD ADTNL: FEMALE FEELING FAINT GRID: M-13 TOA: 16:19 11/30/2010
***MVA***  SERVICE ROAD N [OLD WESTBURY] c/s: RED GROUND ROAD/ ADTNL:  GRID: N-15 TOA: 15:45 11/30/2010
***SIG 8***  AUTO HARBOR HILLS PHARMACY 310 GLEN COVE ROAD [EAST HILLS] c/s: KENNEDY ROAD/RED GROUND ROAD ADTNL: WATERFLOW/565375563 GRID: N-14 TOA: 13:25
***SIG 8***  PROP  15 POPLAR DR [EAST HILLS] c/s: CHESTNUT DR/APPLETREE LA ADTNL: BBQ NEXT TO DECK GRID: L-14 TOA: 18:10 11/29/2010
***SIG 8***  AUTO  27 WAGON ROAD [EAST HILLS] c/s: SALEM ROAD/WINTHROP ROAD ADTNL: 56A2582/ GOLDFETTER RES GRID: M-14 TOA: 21:24 12/04/2010
***SIG 9***  AMBU SUN HARBOR MANOR HEALTH FACILITY 255 WARNER AVE [ROSLYN] c/s: .CARLYLE PL/.ST MARKS PL ADTNL: 3RD FL-3 NORTH-CHEST PAINS GRID: L-15 TOA:
***CHIEF***  AUTO  1506 OLD NORTHERN BLVD [ROSLYN] c/s: BRYANT AVE/NORTHERN BLVD ADTNL: FRATELLI MARKET PL-5612934-SMK DET GRID: L-13 TOA: 16:59 12/04/201
***GENERAL***  BUIL GREAT SHAPES 190 MINEOLA AVE [ROSLYN HEIGHTS] c/s: HIGH ST/POWERHOUSE ROAD ADTNL: ODOR OF BURNING IN BLD-GREAT SHAPES GRID: K-15 TOA:
***SIG 8***  AUTO PIERCE DAY CAMP 37 MINEOLA AVE [ROSLYN] c/s: REGENT PL/GLEN AVE ADTNL: MANSION/NO PERMIT GRID: K-14 TOA: 08:32 12/07/2010
***CHIEF***  INVES  52 THE HEMLOCKS [ROSLYN ESTATES] c/s: SOUTH BRANCH/THE PINES ADTNL: SOMETHING BEEPING IN HOUSE GRID: J-15 TOA: 08:07 12/07/2010
***MUTUAID***  MAF SUNY 223 STORE HILL ROAD N [OLD WESTBURY] c/s: B GATE ROAD/ ADTNL: FAS TRUCK--WANG HALL TOA: 06:17 12/18/2010

 */


public class NYNassauCountyAParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "NY";
  private static final String DEF_CITY = "NASSAU COUNTY";
  
  private static final String[] KEYWORDS = new String[]{"LOC", "c/s", "ADTNL", "GRID", "TOA"};

  public NYNassauCountyAParser() {
    super(DEF_CITY, DEF_STATE);
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int pt1 = body.indexOf("***");
    if (pt1 < 0) return false;
    pt1 += 3;
    int pt2 = body.indexOf("*** ", pt1);
    if (pt2 < 0) return false;
    data.strCall = body.substring(pt1, pt2).trim();
    
    body = "LOC:" + body.substring(pt2+4).trim();
    Properties props = parseMessage(body, KEYWORDS);
    
    // The c/s: keyword is required to distinguish this text format from
    // the Nassau County version D
    String sCross = props.getProperty("c/s");
    if (sCross == null) return false;
    data.strCross = sCross;

    
    String sAddr = props.getProperty("LOC", "");
    Parser p = new Parser(sAddr);
    data.strCall = data.strCall + " - " + p.get(' ');
    sAddr = p.get('[');
    data.strCity = p.get(']');
    if (data.strCity.length() == 0) return false;
    parseAddress(StartType.START_PLACE, FLAG_ANCHOR_END, sAddr, data);
    
    data.strSupp = props.getProperty("ADTNL", "");
    data.strMap = props.getProperty("GRID", "");

    return true;
  }
}


