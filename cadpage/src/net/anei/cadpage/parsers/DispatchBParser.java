package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Herkimer County, NY 
(EMS   >EMS CALL) 185 GUIDEBOARD RD XS: DAIRY HILL RD NORWAY AAAAAAA AAAAAAA 3150000000 Map: Grids:, Cad: 2010-0000049305
(MVA   >MOTOR VEHICLE ACCIDENT) 5781 STHY 28 XS: TOWN LINE NEWPORT AAAAAA AAAAA 3150000000 Map: Grids:, Cad: 2010-0000049651
(EMS   >EMS CALL) 808 OLD STATE RD NEWPORT AAAAAAAA 8880000000 Map: Grids:, Cad: 2010-0000049432
(EMS   >EMS CALL) 3141 MECHANIC ST XS: MAIN ST NEWPORT VILLAGE JOHN 3157179999 Map: Grids:, Cad: 2010-0000058093
(EMS   >EMS CALL) 3746 BLACK CREEK RD Apt: C Bldg XS: TAYLOR BROOK RD RUSSIA SMITH, E 3158265805 Map: Grids:,Cad: 2010-0000058750
(FIREST>STRUCTURE FIRE) 1316 HARD SCRABBLE RD XS: BEGIN ESN 029 FAIRFIELD JONES, CORA 3158913818 Map: Grids:, Cad: 2010-0000060399
(LIFT  >LIFT ASSIST/NON EMER EMS) 3746 BLACK CREEK RD Apt: LOTC Bldg XS: TAYLOR BROOK RD RUSSIA JOHN SMITH 3158265805 Map: Grids:, Cad: 2010-0000064384
(EMS>EMS CALL) 112 N Main St\nGrids:,, NY X:Fairfield St\nMiddleville Village Smith, John\n5419991234 MAP:
(EMS>EMS CALL) 54 Fairfield St\nGrids:,, NY X:Fairfield St\nMiddleville Village Smith, John\n5419991234 MAP:
(LIFT>LIFT ASSIST/NON EMER EMS)\n112 N Main St Grids:,, NY\nX:Fairfield St Smith, John\n5419991234 MAP:

Macon County, NC
911 CENTER:88S >STRUCTURE FIRE REPORTED AT 1650 WIDE HORIZON DR FRANKLIN AAAAA, AAAAA 5555559999 Map: Grids:0,0
911 CENTER:90F >FIRE ALARM 120 RIVERVIEW ST FRANKLIN ANGEL MEDICAL CENTER 5555558411 Map: Grids:0,0
911 CENTER:88S >STRUCTURE FIRE REPORTED AT 289 SUTTON LN FRANKLIN AAAAA, AAAAAAA& AAAAAA 5555559999 Map: Grids:0,0
911 CENTER:MED >EMERGENCY RUN 248 HARRISON AVE XS: W MAIN ST TO BRYSON CITY RD FRANKLIN AAAAAA, CHARMAYNE 5555559999 Map: Grids:0,0
911 CENTER:C1 >EMERGENCY RUN 11 CHATTACHOEE LN FRANKLIN VERIZON WIRELESS 5555559999
911 CENTER:C1 >EMERGENCY RUN 236 PAULINE AVE XS: ULCO DR FRANKLIN AAAAA, AAAAAAA P 5555559999 Map: Grids:0,0
911 CENTER:88S >STRUCTURE FIRE REPORTED AT 1682 LEATHERMAN GAP RD FRANKLIN  AAA, ANGIE 5555559999 Map: Grids:0,0
911 CENTER:50 >VEHICLE ACCIDENT 837 GEORGIA RD FRANKLIN AAAAA 5555558237 Map: Grids:0,0
911 CENTER:C1 >EMERGENCY RUN 730 LAKESHORE DR FRANKLIN CHRISTIAN, JOHN SMITH 8285249999 Map: Grids:0,0
911 CENTER:88B >BRUSH FIRE REPORTED AT RADIO HILL RD FRANKLIN BLACKSTONE, SHORE 8285249991 Map: Grids:0,0
911 CENTER:C1 >EMERGENCY RUN 31 SCROGGS RD XS: LOUISA CHAPEL @ 1020 FRANKLIN VERIZON WIRELESS 8283713353 Map: Grids:0,0
911 CENTER:50 >VEHICLE ACCIDENT 428 COWEETA CHURCH RD OTTO SMITH, J 828369999 Map: Grids:0,0

Harford, MD
[!] EOC:A1091 UNC >UNCONSCIOUS 2200 CHANNEL RD XS: X BIG BRANCH BRDG #127 PYLESVILLE CRIZER,KIM BOX: N08 Cad: 2010-0000162717
[!] EOC:A1091 SICK >SICK PERSON 1606 SCOTT RD XS: X FAWN GROVE RD PYLESVILLE BATCHELDER,MICHELLE BOX: N04 Cad: 2010-0000162427
[!] EOC:A1091 DIAB >DIABETIC EMRG. 2145 HARKINS RD XS: SAINT PAULS CHURCH RD PYLESVILLE ROHREAUGH,KEN BOX: N04 Cad: 2010-0000162445
[!] EOC:E1011 MISC >MISC 4873 CAREA RD XS: X WALNUT SPRING CT WHITE HALL SHERBS,ROBERT BOX: N08 Cad: 2010-0000162395
[!] EOC:A1091 MVA >MV ACCIDENT W/INJURY SRT24&SAINT MARYS RD XS: SAINT MARYS RD PYLESVILLE DEDRICK.PATTI Cad: 2010-0000162161
[!] EOC:E1011 MVA >MV ACCIDENT W/INJURY SRT24&SAINT MARYS RD XS: SAINT MARYS RD PYLESVILLE DEDRICK.PATTI Cad: 2010-0000162161
[!] EOC:F03 BUILD >BUILDING FIRE 21 EASTERN AVE XS: S MAIN ST BEL AIR LEBRUN,MARLEEN BOX: 302 Cad: 2010-0000195539
Subject:HCCAD\n[!] EOC:F03 WIRES >WIRES/POLE SHAWNEE DR&WALTERS MILL RD XS: WALTERS MILL RD FOREST HILL NOT ENTERED Cad: 2010-000019169

Greene County, NY
GREENE 911:WIRES >WIRES DOWN / ARCING 117 RIVER RD ATHENS BRAUMULLER, HELENE Map: Grids:0,0 Cad: 2010-0000033052
GREENE 911:ALARMF>FIRE ALARM 558 SLEEPY HOLLOW RD ATHENS ADT SECURITY-OP ANDREA- Map:62 Grids:0,0 Cad: 2010-0000033344




*/

public class DispatchBParser extends SmartAddressParser {
  
  private String defCity;
  private String defState;
  
  private static final String[] FIXED_KEYWORDS = new String[]{"Map", "Grids", "Cad"};
  private static final String[] KEYWORDS = 
    new String[]{"Loc", "BOX", "Map:", "Grids", "Cad"};
  
  public DispatchBParser(String[] cityList, String defCity, String defState) {
    super(cityList, defState);
    this.defCity = defCity;
    this.defState = defState;
  }
  
  /**
   * Determines if this is a CAD page (may be overridden by subclasses)
   * @param body
   * @return
   */
  protected boolean isPageMsg(String body) {
    return isPageMsg(body, FIXED_KEYWORDS);
  }
  
  /**
   * Processes the complicated first address field
   * Will usually be overridden by subclasses
   * @param field first address field
   * @param data message information data object
   * @return true if parse was successful
   */
  protected boolean parseAddrField(String field, Data data) {
    // Default is to ignore everything up to the first '>'
    int ipt = field.indexOf('>');
    if (ipt >= 0) field = field.substring(ipt+1);
    parseAddress(StartType.START_CALL, field, data);
    return true;
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (! isPageMsg(body)) return false;
    
    data.defState=defState;
    data.defCity = defCity;
    
    body = "Loc: " + body;
    Properties props = parseMessage(body, KEYWORDS);
    
    parseAddrField(props.getProperty("Loc", ""), data);
    
    data.strBox = props.getProperty("BOX", "");
    data.strMap = props.getProperty("Map", "");
    // Not using the Grids: keyword for now
    data.strCallId = props.getProperty("Cad", "");
    
    return true;
  }
}
