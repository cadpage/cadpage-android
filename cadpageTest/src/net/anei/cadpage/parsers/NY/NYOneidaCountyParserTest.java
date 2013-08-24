package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*    
Oneida County, NY
Contact: jim humphreys <jimmycrack79@gmail.com>
Contact: Gary Reese <greese7169@yahoo.com>
Contact: brad white <wfdcar1@gmail.com>
Contact: James Brown <landscapesunlimitedcny@gmail.com>
Contact: james rouillier jr <scaredtwo@gmail.com>
Contact: eric roux <eroux33@gmail.com>
Contact: Michael Delong <mike.delong.392@gmail.com>
Contact: James Griffiths <griffballs72@gmail.com>
Contact: David Kennett <kennett.d.24@gmail.com>
Contact: daved1260@gmail.com" <daved1260@gmail.com>
Sender: dispatch@ocgov.net,dispatch@oc911.org

o;?WHIF:2010:0648\nDispatched\nEMS/BREATHING PROBLEMS\n111 HARDCASTLE AVE, WHITESBORO VILLAGE (MERITON DR/PERIMETER RD)
o;?WHIF:2010:0641\nDispatched\nEMS/DIABETIC PROBLEM\n31 MOHAWK ST, WHITESBORO VILLAGE (/SAUQUOIT STNear:AMERICAN LEGION POST
o;?WHIF:2010:0636\nDispatched\nINVESTIGATE\n124 HARTS HILL TERR, WHITESTOWN (GILBERT RD/Near:HARTS HILL INN)
o;?WHIF:2010:0644\nDispatched\nMVA-PI\nHUGHES ST, WHITESBORO VILLAGE/ WEST ST, WHITESBORO VILLAGE
o;?WHIF:2010:0677\nDispatched\nEMS/PSYCHIATRIC/SUICIDE ATTEMPT\n19 ELLMORE DR, WHITESBORO VILLAGE (SAUQUOIT ST/WIND PL)
i>¿WEVF:2010:0170\nDispatched\nEMS/STROKE/CVA\n9132 MAIN ST, WESTERN (GIFFORD HILL RD/GEORGE STNear:WOODS VALLEY
i>¿WEVF:2010:0171\nDispatchedWIRES DOWN/BURNHILLSIDE RD, WESTERN
i>¿WEVF:2010:0169\nDispatched\nFIRE STRUCTURE7893 GIFFORD HILL RD, WESTERN (CAMRODEN RD/ROUTE 46)
o;?WHIF:2010:0704>Dispatched>EMS/ABDOMINAL PAIN>20 MOHAWK ST, WHITESBORO VILLAGE (SAUQUOIT ST/FERNBANK CIR; Near:AMERICAN LEGION POST 1113)
¿WEVF:2010:0182Dispatched31D02 - UNCONSCIOUS -- EFFECTIVE BREATHING9725 N STEUBEN RD, STEUBEN (STARR HILL RD/LEWIS RD;)
i>¿WEVF:2011:0010DispatchedFIRE STRUCTURE8801 CAMRODEN RD, WESTERN (EVANS RD/TOWNLINE RD; Near:INGERSOLL TRAILER PARK)
i>¿WEMF:2011:0089Dispatched17A03 - PUBLIC ASSIST (NO INJURIES AND NO PRIORITY SYMPTOMS)7700 STONE RD, WESTMORELAND (PECKVILLE RD/STOP 7 RD;)
MSG:i>¿DURF:2011:0013DispatchedALARM EMS5593 ROUTE 46, VERONA (ROUTE 31/FOX ST;)
MSG:i>¿DURF:2011:0013DispatchedALARM EMS5593 ROUTE 46, VERONA (ROUTE 31/FOX ST;)
?LECF:2011:0085>Dispatched\n>17A03 - PUBLIC ASSIST (NO INJURIES AND NO PRIORITY SYMPTOMS)\n>5368 SLONE RD, LEE (LEE CENTER TABERG RD/SKINNER RD;)
?WEMF:2011:0144>Dispatched\n>ASSIST\n>6471 W CARTER RD, WESTMORELAND, NY
?DEEF:2011:0075>Dispatched\n>WIRES DOWN/BURN\n>6352 WALKER RD, DEERFIELD (CRUIKSHANK RD/MILLER RD;)
?LADF:2011:0165>Dispatched\n>FIRE STRUCTURE\n>8428 DAWN DR, ROME OUTSIDE (EVENING RD/;)
?VEOF:2011:0407>Dispatched\n>ALARM FIRE\n>5218 PATRICK RD (COUNTY ROUTE 48A), VERONA (VERONA, ROUTE 365/SNYDER RD; Near:TURNING STONE CASINO)
WATA:2011:0305 >Dispatched >EMS CALL >358 MADISON ST, WATERVILLE VILLAGE (/TERRY MEADOWS DR; Near:WATERVILLE HIGH SCHOOL)

Contact: Llewellyn Owens <bcsbeaverslew@yahoo.com>
Sender: messaging@iamresponding.com
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0356 &gt;Dispatched &gt;32B03 - UNKNOWN STATUS/OTHER CODES NOT APPLICABLE &gt;9218 MAIN ST N BROOKFIELD
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0354 &gt;Dispatched &gt;26A11 - VOMITING &gt;97 STAFFORD AVE N, WATERVILLE VILLAGE (W BACON ST, E BACON ST/
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0353 &gt;Dispatched &gt;17B03 - UNKNOWN STATUS/OTHER CODES NOT APPLICABLE &gt;774 ROUTE 12, SANGERFIELD (CR
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0352 &gt;Dispatched &gt;TRANSPORT &gt;@HARDINGS NURSING HOME  (220 TOWER ST), WATERVILLE VILLAGE
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0351 &gt;Dispatched &gt;EMS CALL &gt;@WATERVILLE MEMORIAL PARK ELEMENTARY SCHOOL  (145 E BACON ST), WATERVI
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0350 &gt;Dispatched &gt;EMS CALL &gt;ONEIDA  COUNTY
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0349 &gt;Dispatched &gt;17B01 - POSSIBLY DANGEROUS BODY AREA &gt;2522 ROUTE 315, MARSHALL (CALIFORNIA RD/HU
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0348 &gt;Dispatched &gt;06C01-ABNORMAL BREATHING &gt;144 HUNTINGTON PL, WATERVILLE VILLAGE (/TOWER ST) #MID

Contact: Laura Eaton <alightwenton@gmail.com>
(Bridgewater Fire) &#239;&#187;&#191;BRIA:2012:0001 &gt;Dispatched &gt;28C05 - SUDDEN PARALYSIS OR FACIAL DROOP (ONE SIDE) &gt;130 ELMWOOD AVE N, WATERV

Contact: David Ambrose <nhfd127@yahoo.com>
Sender: messaging@iamresponding.com
(New Hartford Fire) Dispatched >EMS CALL >@NH Post Office  (40 CAMPION RD), NEW HARTFORD
(New Hartford Fire) Dispatched &gt;MVA-UNKNOWN &gt;@K-Mart  (4645 COMMERCIAL DR), NEW HARTFORD
(New Hartford Fire) Dispatched  INVESTIGATE  50 COURT KNLS, NEW HARTFORD (/ROYAL CT)

Contact: "bcsbeaverslew@yahoo.com" <bcsbeaverslew@yahoo.com>
Sender: 777121901640
.... (Waterville Amb) &#239;&#187;&#191;WATA:2012:0010 &gt;Dispatched &gt;EMS CALL &gt;141 SANGER AVE, WATERVILLE VILLAGE (PARK PL/MADISON ST)

Contact: ryan legacy <rlegacy63@gmail.com>
Sender:messaging@iamresponding.com
(Oriskany Falls Fire) ORFA:2012:0067  Dispatched  EMS CALL  @OLIVERAPTS #APT 103  (124 COOPER ST), ORISKANY FALLS VILLA

Contact: Joseph Morosco <yfd120@gmail.com>
Sender: messaging@iamresponding.com
(Yorkville Fire) YORF:2012:0096 Dispatched EMS CALL 43 MAIN ST, YORKVILLE VILLAGE (/COMMERCIAL DR Near:YORKVILLE AUTO SALES) #APT 3 BACK

Contact: opie286 <opie286@gmail.com>
Sender: messaging@iamresponding.com
(Vernon Fire/Rescue) VENF:2012:0079 ;Dispatched ;19C04 - CARDIAC HISTORY ;4500 BEAVER MEADOW RD, VERNON (COOPER ST/ROUTE 5)

Contact: CHRIS HANNAN <fire56ch@yahoo.com>
Sender: messaging@iamresponding.com
FRM:messaging@iamresponding.com\nSUBJ:CANFD\nMSG:CANFD:2012:171\r\nDispatched\r\nPole/Wires\r\nN MAIN , CANASTOTA VILLAGE

Contact: "Steve" <sxv700r6@aol.com>
Sender: 777212238766
.... (Deansboro Fire) ???DEAF:2012:0069 >Dispatched >EMS CALL >2033 BROTHERTOWN RD (COUNTY ROUTE 8A), MARSHALL (ROUTE 315/VAN HYNING RD)

Contact: thomasmbox162 <thomasmbox162@gmail.com>
Sender: messaging@iamresponding.com
(COCVAC) COCA:2013:0304 >Dispatched >21B01 - POSSIBLY DANGEROUS HEMORRHAGE >5555 WALTER RD, WHITESTOWN  (/HUMPHREY RD)

** NOT IMPLEMENTED **
FRM:dispatch@oc911.org\nMSG:???WEMF:2011:0346AcknowledgeMVA-UNKNOWNROUTE 233, WESTMORELAND/W MAIN ST (COUNTY ROUTE 23), WESTMORELAND
???STIF:2011:0140Dispatched30B01 - POSSIBLY DANGEROUS BODY AREA8533 CHAMINADE RD, MARCY (OLD RIVER RD/ORISKANY RD; Near:VINCES U PULL IT)

Contact: Active911
Agency name: Central Oneida County Volunteer Ambulance Corps
Location: Clinton, NY, United States
Sender: messaging@iamresponding.com

(COCVAC) :2012:3421 >Dispatched >MVA-UNKNOWN >8062 LIMBERLOST RD, KIRKLAND (UTICA RD/ROUTE 5)
(COCVAC) :2012:3420 >Dispatched >TRANSPORT >ROUTE 12, PARIS/PELKEY RD, KIRKLAND
(COCVAC) :2012:3419 >Dispatched >EMS CALL >@ALTERRA CLAIRE BRIDGE COTTAGES  (115 BROOKSIDE DR), KIRKLAND
(COCVAC) :2012:3418 >Dispatched >25B00 - OVERRIDE >5535 EUREKA RD, WESTMORELAND (/ROUTE 233)
(COCVAC) :2012:3417 >Dispatched >TRANSPORT >ST LUKES
(COCVAC) :2012:3415 >Dispatched >26A09 - TRANSPORTATION ONLY >@OC JAIL  (6075 JUDD RD), WHITESTOWN
(COCVAC) :2012:3416 >Dispatched >EMS CALL >245 OXFORD RD (COUNTY ROUTE 26A), NEW HARTFORD (HILLSIDE GARDEN APTS/ROMAN RD; Near:HILLSIDE GARDEN APTS)
(COCVAC) :2012:3415 >Dispatched >26A09 - TRANSPORTATION ONLY >@OC JAIL  (6075 JUDD RD), WHITESTOWN
(COCVAC) :2012:3413 >Dispatched >EMS CALL >3 PAZDUR BLVD E, WESTMORELAND (PAZDUR BLVD S/CAMELOT BLVD, HILLCREST DR)
(COCVAC) :2012:3412 >Dispatched >09E01-NOT BREATHING AT ALL >99 BROOKSIDE DR, KIRKLAND (/KELLOGG ST; Near:ALTERRA VILLAS OF SHERMAN BROOK)

*/

public class NYOneidaCountyParserTest extends BaseParserTest {
  
  public NYOneidaCountyParserTest() {
    setParser(new NYOneidaCountyParser(), "ONEIDA COUNTY", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "o;?WHIF:2010:0648\nDispatched\nEMS/BREATHING PROBLEMS\n111 HARDCASTLE AVE, WHITESBORO VILLAGE (MERITON DR/PERIMETER RD)",
        "ID:2010:0648",
        "SRC:WHIF",
        "CALL:EMS/BREATHING PROBLEMS",
        "ADDR:111 HARDCASTLE AVE",
        "CITY:WHITESBORO",
        "X:MERITON DR/PERIMETER RD");

    doTest("T2",
        "o;?WHIF:2010:0641\nDispatched\nEMS/DIABETIC PROBLEM\n31 MOHAWK ST, WHITESBORO VILLAGE (/SAUQUOIT STNear:AMERICAN LEGION POST",
        "SRC:WHIF",
        "ID:2010:0641",
        "CALL:EMS/DIABETIC PROBLEM",
        "ADDR:31 MOHAWK ST",
        "CITY:WHITESBORO",
        "X:SAUQUOIT ST",
        "INFO:Near:AMERICAN LEGION POST");
    
    doTest("T3",
        "o;?WHIF:2010:0636\nDispatched\nINVESTIGATE\n124 HARTS HILL TERR, WHITESTOWN (GILBERT RD/Near:HARTS HILL INN)",
        "SRC:WHIF",
        "ID:2010:0636",
        "CALL:INVESTIGATE",
        "ADDR:124 HARTS HILL TERR",
        "CITY:WHITESTOWN",
        "X:GILBERT RD",
        "INFO:Near:HARTS HILL INN");
    
    doTest("T4",
        "o;?WHIF:2010:0644\nDispatched\nMVA-PI\nHUGHES ST, WHITESBORO VILLAGE/ WEST ST, WHITESBORO VILLAGE",
        "SRC:WHIF",
        "ID:2010:0644",
        "CALL:MVA-PI",
        "ADDR:HUGHES ST",
        "MADDR:HUGHES ST & WEST ST",
        "CITY:WHITESBORO",
        "X:WEST ST");
    
    doTest("T5",
        "o;?WHIF:2010:0677\nDispatched\nEMS/PSYCHIATRIC/SUICIDE ATTEMPT\n19 ELLMORE DR, WHITESBORO VILLAGE (SAUQUOIT ST/WIND PL)",
        "SRC:WHIF",
        "ID:2010:0677",
        "CALL:EMS/PSYCHIATRIC/SUICIDE ATTEMPT",
        "ADDR:19 ELLMORE DR",
        "CITY:WHITESBORO",
        "X:SAUQUOIT ST/WIND PL");
    
    doTest("T6",
        "i>¿WEVF:2010:0170\nDispatched\nEMS/STROKE/CVA\n9132 MAIN ST, WESTERN (GIFFORD HILL RD/GEORGE STNear:WOODS VALLEY",
        "SRC:WEVF",
        "ID:2010:0170",
        "CALL:EMS/STROKE/CVA",
        "ADDR:9132 MAIN ST",
        "CITY:WESTERN",
        "X:GIFFORD HILL RD/GEORGE ST",
        "INFO:Near:WOODS VALLEY");
    
    doTest("T7",
        "o;?WHIF:2010:0704>Dispatched>EMS/ABDOMINAL PAIN>20 MOHAWK ST, WHITESBORO VILLAGE (SAUQUOIT ST/FERNBANK CIR; Near:AMERICAN LEGION POST 1113)",
        "SRC:WHIF",
        "ID:2010:0704",
        "CALL:EMS/ABDOMINAL PAIN",
        "ADDR:20 MOHAWK ST",
        "CITY:WHITESBORO",
        "X:SAUQUOIT ST/FERNBANK CIR",
        "INFO:Near:AMERICAN LEGION POST 1113");

    doTest("T8",
        "?LECF:2011:0085>Dispatched\n>17A03 - PUBLIC ASSIST (NO INJURIES AND NO PRIORITY SYMPTOMS)\n>5368 SLONE RD, LEE (LEE CENTER TABERG RD/SKINNER RD;)",
        "SRC:LECF",
        "ID:2011:0085",
        "CODE:17A03",
        "CALL:PUBLIC ASSIST (NO INJURIES AND NO PRIORITY SYMPTOMS)",
        "ADDR:5368 SLONE RD",
        "CITY:LEE",
        "X:LEE CENTER TABERG RD/SKINNER RD");

    doTest("T9",
        "Body:?DEEF:2011:0075>Dispatched\n>WIRES DOWN/BURN\n>6352 WALKER RD, DEERFIELD (CRUIKSHANK RD/MILLER RD;)",
        "SRC:DEEF",
        "ID:2011:0075",
        "CALL:WIRES DOWN/BURN",
        "ADDR:6352 WALKER RD",
        "CITY:DEERFIELD",
        "X:CRUIKSHANK RD/MILLER RD");

    doTest("T10",
        "?LADF:2011:0165>Dispatched\n>FIRE STRUCTURE\n>8428 DAWN DR, ROME (EVENING RD/;)",
        "ID:2011:0165",
        "SRC:LADF",
        "CALL:FIRE STRUCTURE",
        "ADDR:8428 DAWN DR",
        "CITY:ROME",
        "X:EVENING RD");

    doTest("T11",
        "?VEOF:2011:0407>Dispatched\n>ALARM FIRE\n>5218 PATRICK RD (COUNTY ROUTE 48A), VERONA (VERONA, ROUTE 365/SNYDER RD; Near:TURNING STONE CASINO)",
        "SRC:VEOF",
        "ID:2011:0407",
        "CALL:ALARM FIRE",
        "ADDR:5218 PATRICK RD",
        "CITY:VERONA",
        "X:COUNTY ROUTE 48A/ROUTE 365/SNYDER RD",
        "INFO:Near:TURNING STONE CASINO");

    doTest("T12",
        "WATA:2011:0305 >Dispatched >EMS CALL >358 MADISON ST, WATERVILLE VILLAGE (/TERRY MEADOWS DR; Near:WATERVILLE HIGH SCHOOL)",
        "SRC:WATA",
        "ID:2011:0305",
        "CALL:EMS CALL",
        "ADDR:358 MADISON ST",
        "CITY:WATERVILLE",
        "X:TERRY MEADOWS DR",
        "INFO:Near:WATERVILLE HIGH SCHOOL");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0356 &gt;Dispatched &gt;32B03 - UNKNOWN STATUS/OTHER CODES NOT APPLICABLE &gt;9218 MAIN ST N BROOKFIELD",
        "SRC:WATA",
        "ID:2011:0356",
        "CODE:32B03",
        "CALL:UNKNOWN STATUS/OTHER CODES NOT APPLICABLE",
        "ADDR:9218 MAIN ST",
        "CITY:N BROOKFIELD");

    doTest("T2",
        "[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0354 &gt;Dispatched &gt;26A11 - VOMITING &gt;97 STAFFORD AVE N, WATERVILLE VILLAGE (W BACON ST, E BACON ST/",
        "SRC:WATA",
        "ID:2011:0354",
        "CODE:26A11",
        "CALL:VOMITING",
        "ADDR:97 STAFFORD AVE N",
        "CITY:WATERVILLE",
        "X:W BACON ST/E BACON ST");

    doTest("T3",
        "[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0353 &gt;Dispatched &gt;17B03 - UNKNOWN STATUS/OTHER CODES NOT APPLICABLE &gt;774 ROUTE 12, SANGERFIELD (CR",
        "SRC:WATA",
        "ID:2011:0353",
        "CODE:17B03",
        "CALL:UNKNOWN STATUS/OTHER CODES NOT APPLICABLE",
        "ADDR:774 ROUTE 12",
        "CITY:SANGERFIELD",
        "X:CR");

    doTest("T4",
        "[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0352 &gt;Dispatched &gt;TRANSPORT &gt;@HARDINGS NURSING HOME  (220 TOWER ST), WATERVILLE VILLAGE",
        "ID:2011:0352",
        "SRC:WATA",
        "CALL:TRANSPORT",
        "PLACE:HARDINGS NURSING HOME",
        "ADDR:220 TOWER ST",
        "CITY:WATERVILLE");

    doTest("T5",
        "[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0351 &gt;Dispatched &gt;EMS CALL &gt;@WATERVILLE MEMORIAL PARK ELEMENTARY SCHOOL  (145 E BACON ST), WATERVI",
        "ID:2011:0351",
        "SRC:WATA",
        "CALL:EMS CALL",
        "PLACE:WATERVILLE MEMORIAL PARK ELEMENTARY SCHOOL",
        "ADDR:145 E BACON ST",
        "CITY:WATERVILLE");

    doTest("T6",
        "[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0350 &gt;Dispatched &gt;EMS CALL &gt;ONEIDA  COUNTY",
        "ID:2011:0350",
        "SRC:WATA",
        "CALL:EMS CALL",
        "ADDR:ONEIDA COUNTY");

    doTest("T7",
        "[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0349 &gt;Dispatched &gt;17B01 - POSSIBLY DANGEROUS BODY AREA &gt;2522 ROUTE 315, MARSHALL (CALIFORNIA RD/HU",
        "ID:2011:0349",
        "SRC:WATA",
        "CODE:17B01",
        "CALL:POSSIBLY DANGEROUS BODY AREA",
        "ADDR:2522 ROUTE 315",
        "CITY:MARSHALL",
        "X:CALIFORNIA RD/HU");

    doTest("T8",
        "[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0348 &gt;Dispatched &gt;06C01-ABNORMAL BREATHING &gt;144 HUNTINGTON PL, WATERVILLE VILLAGE (/TOWER ST) #MID",
        "ID:2011:0348",
        "SRC:WATA",
        "CODE:06C01",
        "CALL:ABNORMAL BREATHING",
        "ADDR:144 HUNTINGTON PL",
        "CITY:WATERVILLE",
        "X:TOWER ST",
        "APT:MID");
    
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "(Bridgewater Fire) &#239;&#187;&#191;BRIA:2012:0001 &gt;Dispatched &gt;28C05 - SUDDEN PARALYSIS OR FACIAL DROOP (ONE SIDE) &gt;130 ELMWOOD AVE N, WATERV",
        "SRC:BRIA",
        "ID:2012:0001",
        "CODE:28C05",
        "CALL:SUDDEN PARALYSIS OR FACIAL DROOP (ONE SIDE)",
        "ADDR:130 ELMWOOD AVE N",
        "CITY:WATERVILLE");
  }
  
  @Test
  public void testParser4() {

    doTest("T1",
        "(New Hartford Fire) Dispatched >EMS CALL >@NH Post Office  (40 CAMPION RD), NEW HARTFORD",
        "SRC:New Hartford Fire",
        "CALL:EMS CALL",
        "PLACE:NH Post Office",
        "ADDR:40 CAMPION RD",
        "CITY:NEW HARTFORD");

    doTest("T2",
        "(New Hartford Fire) Dispatched &gt;MVA-UNKNOWN &gt;@K-Mart  (4645 COMMERCIAL DR), NEW HARTFORD",
        "SRC:New Hartford Fire",
        "CALL:MVA-UNKNOWN",
        "PLACE:K-Mart",
        "ADDR:4645 COMMERCIAL DR",
        "CITY:NEW HARTFORD");

    doTest("T3",
        "(New Hartford Fire) Dispatched  INVESTIGATE  50 COURT KNLS, NEW HARTFORD (/ROYAL CT)",
        "SRC:New Hartford Fire",
        "CALL:INVESTIGATE",
        "ADDR:50 COURT KNOLLE",
        "CITY:NEW HARTFORD",
        "X:ROYAL CT");
  }
  
  @Test
  public void testParser5() {

    doTest("T1",
        ".... (Waterville Amb) &#239;&#187;&#191;WATA:2012:0010 &gt;Dispatched &gt;EMS CALL &gt;141 SANGER AVE, WATERVILLE VILLAGE (PARK PL/MADISON ST)",
        "SRC:WATA",
        "ID:2012:0010",
        "CALL:EMS CALL",
        "ADDR:141 SANGER AVE",
        "CITY:WATERVILLE",
        "X:PARK PL/MADISON ST");

  }
  
  @Test
  public void testRyanLegacy() {

    doTest("T1",
        "(Oriskany Falls Fire) ORFA:2012:0067  Dispatched  EMS CALL  @OLIVERAPTS #APT 103  (124 COOPER ST), ORISKANY FALLS VILLA",
        "SRC:ORFA",
        "ID:2012:0067",
        "CALL:EMS CALL",
        "PLACE:OLIVERAPTS",
        "APT:103",
        "ADDR:124 COOPER ST",
        "CITY:ORISKANY FALLS");
    
  }
  
  @Test
  public void testJosephMororsco() {

    doTest("T1",
        "(Yorkville Fire) YORF:2012:0096 Dispatched EMS CALL 43 MAIN ST, YORKVILLE VILLAGE (/COMMERCIAL DR Near:YORKVILLE AUTO SALES) #APT 3 BACK",
        "SRC:YORF",
        "ID:2012:0096",
        "CALL:EMS CALL",
        "ADDR:43 MAIN ST",
        "CITY:YORKVILLE",
        "X:COMMERCIAL DR",
        "INFO:Near:YORKVILLE AUTO SALES",
        "APT:3 BACK");

  }
  
  @Test
  public void testOpie2() {

    doTest("T1",
        "(Vernon Fire/Rescue) VENF:2012:0079 ;Dispatched ;19C04 - CARDIAC HISTORY ;4500 BEAVER MEADOW RD, VERNON (COOPER ST/ROUTE 5)",
        "SRC:VENF",
        "ID:2012:0079",
        "CODE:19C04",
        "CALL:CARDIAC HISTORY",
        "ADDR:4500 BEAVER MEADOW RD",
        "CITY:VERNON",
        "X:COOPER ST/ROUTE 5");
  }
  
  @Test
  public void testChrisHannon() {

    doTest("T1",
        "FRM:messaging@iamresponding.com\nSUBJ:CANFD\nMSG:CANFD:2012:171\r\nDispatched\r\nPole/Wires\r\nN MAIN , CANASTOTA VILLAGE",
        "SRC:CANFD",
        "ID:2012:171",
        "CALL:Pole/Wires",
        "ADDR:N MAIN",
        "CITY:CANASTOTA");
    
  }
  
  @Test
  public void testSteve() {

    doTest("T1",
        ".... (Deansboro Fire) ???DEAF:2012:0069 >Dispatched >EMS CALL >2033 BROTHERTOWN RD (COUNTY ROUTE 8A), MARSHALL (ROUTE 315/VAN HYNING RD)",
        "SRC:DEAF",
        "ID:2012:0069",
        "CALL:EMS CALL",
        "ADDR:2033 BROTHERTOWN RD",
        "CITY:MARSHALL",
        "X:COUNTY ROUTE 8A/ROUTE 315/VAN HYNING RD");
    
  }
  
  @Test
  public void testThomasmbox162() {

    doTest("T1",
        "(COCVAC) COCA:2013:0304 >Dispatched >21B01 - POSSIBLY DANGEROUS HEMORRHAGE >5555 WALTER RD, WHITESTOWN  (/HUMPHREY RD)",
        "CODE:21B01",
        "SRC:COCA",
        "ID:2013:0304",
        "CALL:POSSIBLY DANGEROUS HEMORRHAGE",
        "ADDR:5555 WALTER RD",
        "CITY:WHITESTOWN",
        "X:HUMPHREY RD");
  
  }
  
  @Test
  public void testCentralOneidaCountyVolunteerAmbulance() {

    doTest("T1",
        "(COCVAC) :2012:3421 >Dispatched >MVA-UNKNOWN >8062 LIMBERLOST RD, KIRKLAND (UTICA RD/ROUTE 5)",
        "SRC:COCVAC",
        "ID:2012:3421",
        "CALL:MVA-UNKNOWN",
        "ADDR:8062 LIMBERLOST RD",
        "CITY:KIRKLAND",
        "X:UTICA RD/ROUTE 5");

    doTest("T2",
        "(COCVAC) :2012:3420 >Dispatched >TRANSPORT >ROUTE 12, PARIS/PELKEY RD, KIRKLAND",
        "SRC:COCVAC",
        "ID:2012:3420",
        "CALL:TRANSPORT",
        "ADDR:ROUTE 12",
        "MADDR:ROUTE 12 & PARIS",
        "CITY:KIRKLAND",
        "X:PARIS/PELKEY RD");

    doTest("T3",
        "(COCVAC) :2012:3419 >Dispatched >EMS CALL >@ALTERRA CLAIRE BRIDGE COTTAGES  (115 BROOKSIDE DR), KIRKLAND",
        "SRC:COCVAC",
        "ID:2012:3419",
        "CALL:EMS CALL",
        "PLACE:ALTERRA CLAIRE BRIDGE COTTAGES",
        "ADDR:115 BROOKSIDE DR",
        "CITY:KIRKLAND");

    doTest("T4",
        "(COCVAC) :2012:3418 >Dispatched >25B00 - OVERRIDE >5535 EUREKA RD, WESTMORELAND (/ROUTE 233)",
        "SRC:COCVAC",
        "ID:2012:3418",
        "CODE:25B00",
        "CALL:OVERRIDE",
        "ADDR:5535 EUREKA RD",
        "CITY:WESTMORELAND",
        "X:ROUTE 233");

    doTest("T5",
        "(COCVAC) :2012:3417 >Dispatched >TRANSPORT >ST LUKES",
        "SRC:COCVAC",
        "ID:2012:3417",
        "CALL:TRANSPORT",
        "ADDR:ST LUKES");

    doTest("T6",
        "(COCVAC) :2012:3415 >Dispatched >26A09 - TRANSPORTATION ONLY >@OC JAIL  (6075 JUDD RD), WHITESTOWN",
        "SRC:COCVAC",
        "ID:2012:3415",
        "CODE:26A09",
        "CALL:TRANSPORTATION ONLY",
        "PLACE:OC JAIL",
        "ADDR:6075 JUDD RD",
        "CITY:WHITESTOWN");

    doTest("T7",
        "(COCVAC) :2012:3416 >Dispatched >EMS CALL >245 OXFORD RD (COUNTY ROUTE 26A), NEW HARTFORD (HILLSIDE GARDEN APTS/ROMAN RD; Near:HILLSIDE GARDEN APTS)",
        "SRC:COCVAC",
        "ID:2012:3416",
        "CALL:EMS CALL",
        "ADDR:245 OXFORD RD",
        "CITY:NEW HARTFORD",
        "X:COUNTY ROUTE 26A/HILLSIDE GARDEN APTS/ROMAN RD",
        "INFO:Near:HILLSIDE GARDEN APTS");

    doTest("T8",
        "(COCVAC) :2012:3415 >Dispatched >26A09 - TRANSPORTATION ONLY >@OC JAIL  (6075 JUDD RD), WHITESTOWN",
        "SRC:COCVAC",
        "ID:2012:3415",
        "CODE:26A09",
        "CALL:TRANSPORTATION ONLY",
        "PLACE:OC JAIL",
        "ADDR:6075 JUDD RD",
        "CITY:WHITESTOWN");

    doTest("T9",
        "(COCVAC) :2012:3413 >Dispatched >EMS CALL >3 PAZDUR BLVD E, WESTMORELAND (PAZDUR BLVD S/CAMELOT BLVD, HILLCREST DR)",
        "SRC:COCVAC",
        "ID:2012:3413",
        "CALL:EMS CALL",
        "ADDR:3 PAZDUR BLVD E",
        "CITY:WESTMORELAND",
        "X:PAZDUR BLVD S/CAMELOT BLVD/HILLCREST DR");

    doTest("T10",
        "(COCVAC) :2012:3412 >Dispatched >09E01-NOT BREATHING AT ALL >99 BROOKSIDE DR, KIRKLAND (/KELLOGG ST; Near:ALTERRA VILLAS OF SHERMAN BROOK)",
        "SRC:COCVAC",
        "ID:2012:3412",
        "CODE:09E01",
        "CALL:NOT BREATHING AT ALL",
        "ADDR:99 BROOKSIDE DR",
        "CITY:KIRKLAND",
        "X:KELLOGG ST",
        "INFO:Near:ALTERRA VILLAS OF SHERMAN BROOK");

  }
  
  public static void main(String[] args) {
    new NYOneidaCountyParserTest().generateTests("T1");
  }
}
