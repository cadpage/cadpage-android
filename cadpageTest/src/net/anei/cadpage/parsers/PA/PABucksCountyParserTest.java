package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PABucksCountyParser;

import org.junit.Test;


public class PABucksCountyParserTest extends BaseParserTest {
  
  public PABucksCountyParserTest() {
    setParser(new PABucksCountyParser(), "BUCKS COUNTY", "PA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "911:SQ134  type:BTAI    adr:S LIMEKILN PK/UPPER STATE RD ,48  aai:  box:74064  map:3033F7  tm:21:05:23  ED1042264",
        "SRC:SQ134",
        "CALL:BTAI - BLS TRAFFIC ACCIDENT (MINOR INJURIES)",
        "ADDR:S LIMEKILN PK & UPPER STATE RD",
        "CITY:NEW BRITAIN TWP",
        "BOX:74064",
        "MAP:3033F7",
        "ID:ED1042264");

    doTest("T2",
        "911:SQ134  type:ARESP   adr:4217 HORSESHOE WY ,36  btwn BERRY BROW DR &amp; SPARROW WY  aai:  box:60002  map:2921B10  tm:05:02:04  ED1042293",  
        "SRC:SQ134",
        "CALL:ARESP - RESPIRATORY DISTRESS",
        "ADDR:4217 HORSESHOE WY",
        "CITY:HILLTOWN TWP",
        "X:BERRY BROW DR & SPARROW WY",
        "BOX:60002",
        "MAP:2921B10",
        "ID:ED1042293");
        
    doTest("T3",
        "911:SQ134  type:ARESP   adr:221 HAMPSHIRE DR ,48  btwn CORNWALL DR &amp; SURREY RD  aai:  box:74062  map:3033E6  tm:14:06:02  ED1042334",  
        "SRC:SQ134",
        "CALL:ARESP - RESPIRATORY DISTRESS",
        "ADDR:221 HAMPSHIRE DR",
        "CITY:NEW BRITAIN TWP",
        "X:CORNWALL DR & SURREY RD",
        "BOX:74062",
        "MAP:3033E6",
        "ID:ED1042334");
        
    doTest("T4",
        "911:SQ134  type:AFAINT  adr:1553 LOWER STATE RD ,29  btwn BRISTOL RD &amp; OLD NEW RD  aai:  box:78054  map:3034E7  tm:20:28:45  ED1042385",  
        "SRC:SQ134",
        "CALL:AFAINT - SYNCOPAL EPISODE",
        "ADDR:1553 LOWER STATE RD",
        "CITY:DOYLESTOWN TWP",
        "X:BRISTOL RD & OLD NEW RD",
        "BOX:78054",
        "MAP:3034E7",
        "ID:ED1042385");
        
    doTest("T5",
        "911:SQ134  type:BTAI    adr:1235 S TOWNSHIP LINE RD ,36  btwn CHALFONT RD &amp; LIMEKILN PK  aai:  box:61003  map:2921D10  tm:12:02:56  ED1042577",  
        "SRC:SQ134",
        "CALL:BTAI - BLS TRAFFIC ACCIDENT (MINOR INJURIES)",
        "ADDR:1235 S TOWNSHIP LINE RD",
        "CITY:HILLTOWN TWP",
        "X:CHALFONT RD & LIMEKILN PK",
        "BOX:61003",
        "MAP:2921D10",
        "ID:ED1042577");
        
    doTest("T6",
        "911:SQ134  type:BBLED   adr:102 HARRISON FORGE CT ,48  btwn E FAIRWOOD DR &amp; CUL DE SAC  aai:  box:34030  map:3033H1  tm:14:38:26  ED1042595",  
        "SRC:SQ134",
        "CALL:BBLED - BLEEDING (NON TRAUMATIC)",
        "ADDR:102 HARRISON FORGE CT",
        "CITY:NEW BRITAIN TWP",
        "X:E FAIRWOOD DR & CUL DE SAC",
        "BOX:34030",
        "MAP:3033H1",
        "ID:ED1042595");
        
    doTest("T7",
        "911:SQ134  type:BINJ    adr:BARC HOUSE ,47 at 80 PUEBLO RD ,47 btwn LENAPE DR &amp; UTE RD  aai:DOWNSTAIRS  box:34033  map:3033J2  tm:16:57:04  ED1043086",  
        "SRC:SQ134",
        "CALL:BINJ - MINOR INJURY - NON CRITICAL",
        "PLACE:BARC HOUSE",
        "ADDR:80 PUEBLO RD",
        "CITY:NEW BRITAIN",
        "X:LENAPE DR & UTE RD",
        "INFO:DOWNSTAIRS",
        "BOX:34033",
        "MAP:3033J2",
        "ID:ED1043086");
        
    doTest("T8",
        "911:STA19  type:FALRM   adr:DTH ,29 at 595 W STATE ST ,29 btwn PROGRESS DR &amp; RT 611 BY  aai:215 345-2200  box:19051  map:3034G2  tm:12:37:42  FD101999",
        "SRC:STA19",
        "CALL:FALRM - FIRE ALARM (LOC)",
        "PLACE:DTH",
        "ADDR:595 W STATE ST",
        "CITY:DOYLESTOWN TWP",
        "X:PROGRESS DR & RT 611 BY",
        "INFO:215 345-2200",
        "BOX:19051",
        "MAP:3034G2",
        "ID:FD101999");
        
    doTest("T9",
        "911:SQ134  type:ASEIZ   adr:BRISTOL RD/UPPER STATE RD ,29  aai:AT ENTR TO BLOOMING GLEN  box:34041  map:3033K5  tm:11:01:28  ED1043679",
        "SRC:SQ134",
        "CALL:ASEIZ - SEIZURES - ACTIVE",
        "ADDR:BRISTOL RD & UPPER STATE RD",
        "CITY:DOYLESTOWN TWP",
        "INFO:AT ENTR TO BLOOMING GLEN",
        "BOX:34041",
        "MAP:3033K5",
        "ID:ED1043679");
        
    doTest("T10",
        "911:SQ134  type:ATRAN   adr:2343 BETHLEHEM PK #312 ,36 -- DOCK MEADOWS NH btwn UNIONVILLE PK &amp; CHURCH RD  aai:GO TO CHURCH RD NORTH ENTRANCE box:60063 map:3032E3 &nbsp;tm:14:48:06 ED1042598&nbsp;",
        "SRC:SQ134",
        "CALL:ATRAN - ALS/UNSPECIFIED EMERGENCY",
        "ADDR:2343 BETHLEHEM PK",
        "APT:312",
        "PLACE:DOCK MEADOWS NH",
        "CITY:HILLTOWN TWP",
        "X:UNIONVILLE PK & CHURCH RD",
        "INFO:GO TO CHURCH RD NORTH ENTRANCE",
        "BOX:60063",
        "MAP:3032E3",
        "ID:ED1042598");

    doTest("T11",
        "911: STA57  stype:FTAI    adr:FRIER RD/MILL RD ,45  aai:  box:57002  map:  tm:13:51:38  FD1104463    Run: E57",
        "SRC:STA57",
        "CALL:FTAI - ACCIDENT W/FIRE & INJ (LOC)",
        "ADDR:FRIER RD & MILL RD",
        "CITY:MILFORD TWP",
        "BOX:57002",
        "ID:FD1104463",
        "UNIT:E57");

    doTest("T12",
        "911: STA4  type:RAUTO   adr:PHILMONT AV/E STREET RD ,43  aai:PHILMONT SO STREET  box:04003  map:3261B8  tm:10:21:22  FD1104774    Run: R4 R6 E1",
        "SRC:STA4",
        "CALL:RAUTO - AUTO EXTRICATION",
        "ADDR:PHILMONT AV & E STREET RD",
        "CITY:LOWER SOUTHAMPTON TWP",
        "INFO:PHILMONT SO STREET",
        "BOX:04003",
        "MAP:3261B8",
        "ID:FD1104774",
        "UNIT:R4 R6 E1");

    doTest("T13",
        "911: STA53  type:RMAR    adr:LIONS PARK ,24 at 102 SAMUEL CLIFT ST ,24 btwn MILL ST & MARKET ST  aai:  box:51012  map:3375D5  tm:00:59:10  FD1105678 Run: R53 M53 M11",
        "SRC:STA53",
        "CALL:RMAR - MARINE RESCUE",
        "ADDR:102 SAMUEL CLIFT ST",
        "PLACE:LIONS PARK",
        "CITY:BRISTOL",
        "X:MILL ST & MARKET ST",
        "BOX:51012",
        "MAP:3375D5",
        "ID:FD1105678",
        "UNIT:R53 M53 M11");

    doTest("T14",
        "911: STA53  type:WIREIN  adr:2218 TRENTON AV ,24  btwn BARRY PL & TAFT ST  aai:  box:53034  map:3375F2  tm:11:40:15  FD1104667    Run: L25 Q51 E50 E52",
        "SRC:STA53",
        "CALL:WIREIN - WIRES IN DWELLING",
        "ADDR:2218 TRENTON AV",
        "CITY:BRISTOL",
        "X:BARRY PL & TAFT ST",
        "BOX:53034",
        "MAP:3375F2",
        "ID:FD1104667",
        "UNIT:L25 Q51 E50 E52");

    doTest("T15",
        "911: STA53  stype:RAUTO   adr:NEW FALLS RD/PINE AV ,25  aai:  box:12044  map:3262G9  tm:21:30:34  FD1107837    Run: R13 R53 E82",
        "SRC:STA53",
        "CALL:RAUTO - AUTO EXTRICATION",
        "ADDR:NEW FALLS RD & PINE AV",
        "CITY:BRISTOL TWP",
        "BOX:12044",
        "MAP:3262G9",
        "ID:FD1107837",
        "UNIT:R13 R53 E82");

    doTest("T16",
        "911: STA19  type:FUNK    adr:EDISON RD/RT 611 ,29  aai:  box:79028  map:3034K5  tm:12:44:52  FD1108375    Run: E79    \n",
        "SRC:STA19",
        "CALL:FUNK - UNKNOWN TYPE FIRE",
        "ADDR:EDISON RD & RT 611",
        "CITY:DOYLESTOWN TWP",
        "BOX:79028",
        "MAP:3034K5",
        "ID:FD1108375",
        "UNIT:E79");

    doTest("T17",
        "911: STA19  type:WATER   adr:EIGHTEENFOURTEEN H ,28 at 50 S MAIN ST ,28 btwn W OAKLAND AV & TAYLOR AV  aai:  box:19022  map:2922J10  tm:02:29:07  FD11",
        "SRC:STA19",
        "CALL:WATER - WATER FLOW",
        "PLACE:EIGHTEENFOURTEEN H",
        "ADDR:50 S MAIN ST",
        "CITY:DOYLESTOWN",
        "X:W OAKLAND AV & TAYLOR AV",
        "BOX:19022",
        "MAP:2922J10",
        "ID:FD11");

    doTest("T18",
        "911: STA19  type:RVBLD   adr:LOBSTER CLAW ,57 at 800 N EASTON RD ,57 btwn BKHAM TWP LINE & CROSS KEYS DR  aai:  box:20001  map:2922J6  tm:16:03:22  FD",
        "SRC:STA19",
        "CALL:RVBLD - VEHICLE INTO A BUILDING",
        "PLACE:LOBSTER CLAW",
        "ADDR:800 N EASTON RD",
        "CITY:PLUMSTEAD TWP",
        "X:BKHAM TWP LINE & CROSS KEYS DR",
        "BOX:20001",
        "MAP:2922J6",
        "ID:FD");

    doTest("T19",
        "911: STA58  type:FBLD    adr:121 PARK AV ,58  btwn FRONT ST & S 2ND ST  aai:QUAKERTOWN ASSOCIATES 215-901-8033  box:17001  map:2695H10  tm:17:44:38   FD1110887    Run: L57 SQ18 E36 R18 R58",
        "SRC:STA58",
        "CALL:FBLD - BUILDING FIRE (BOX)",
        "ADDR:121 PARK AV",
        "CITY:QUAKERTOWN TWP",
        "X:FRONT ST & S 2ND ST",
        "INFO:QUAKERTOWN ASSOCIATES 215-901-8033",
        "BOX:17001",
        "MAP:2695H10",
        "ID:FD1110887",
        "UNIT:L57 SQ18 E36 R18 R58");

    doTest("T20",
        "911: STA14  type:EXBLD   adr:3501 BRISTOL OXF VALLEY RD #1107 ,25 -- AVALON COURT APT btwn LESLIE DR & BORDER  aai:  box:82015  map:3263A9  tm:22:06:28  FD1110945  Run: TW14 E12",
        "SRC:STA14",
        "CALL:EXBLD - EXTINGUISHED STRUCTURE (TAC)",
        "PLACE:AVALON COURT APT",
        "ADDR:3501 BRISTOL OXF VALLEY RD",
        "CITY:BRISTOL TWP",
        "X:LESLIE DR & BORDER",
        "APT:1107",
        "BOX:82015",
        "MAP:3263A9",
        "ID:FD1110945",
        "UNIT:TW14 E12");

    doTest("T21",
        "911: SQ134  type:APOSXP  adr:307 W BUTLER AV ,48  btwn BRITTANY DR & SURREY RD  aai:NE SECTOR  box:74062  map:3033E6  tm:07:24:51  ED1126192",
        "SRC:SQ134",
        "CALL:APOSXP - POSSIBLE EXPIRATION",
        "ADDR:307 W BUTLER AV",
        "CITY:NEW BRITAIN TWP",
        "X:BRITTANY DR & SURREY RD",
        "INFO:NE SECTOR",
        "BOX:74062",
        "MAP:3033E6",
        "ID:ED1126192");

    doTest("T22",
        "911: STA4  type:APOSXP  adr:3449 AZALEA AV ,22  btwn TRAILWOOD DR & VALLEY RD  aai:  box:04007  map:3261E8  tm:05:29:00  ED1126324",
        "SRC:STA4",
        "CALL:APOSXP - POSSIBLE EXPIRATION",
        "ADDR:3449 AZALEA AV",
        "CITY:BENSALEM TWP",
        "X:TRAILWOOD DR & VALLEY RD",
        "BOX:04007",
        "MAP:3261E8",
        "ID:ED1126324");

    doTest("T23",
        "911: SQ134  type:AASSLT  adr:STADIUM BAR & GRIL ,36 at 1903 BETHLEHEM PK ,36 btwn SWARTLEY RD & MILL RD aai:  box:60063  map:3032F3  tm:02:33:13  ED1127778",
        "SRC:SQ134",
        "CALL:AASSLT - ASSAULT W/ TRAUMA",
        "PLACE:STADIUM BAR & GRIL",
        "ADDR:1903 BETHLEHEM PK",
        "CITY:HILLTOWN TWP",
        "X:SWARTLEY RD & MILL RD",
        "BOX:60063",
        "MAP:3032F3",
        "ID:ED1127778");

    doTest("T24",
        "911: STA4  type:RDOM    adr:NESHA STATE PARK ,22 at 3401 STATE RD ,22 btwn DUNKSFERRY RD & WINKS LA  aai:NEXT TO POOL AREA AT PICNIC AREA  box:37023  map:3374C7  tm:12:52:17  FD1111780    Run: R16 SQ37 R4",
        "SRC:STA4",
        "CALL:RDOM - DOMESTIC RESCUE",
        "PLACE:NESHA STATE PARK",
        "ADDR:3401 STATE RD",
        "CITY:BENSALEM TWP",
        "X:DUNKSFERRY RD & WINKS LA",
        "INFO:NEXT TO POOL AREA AT PICNIC AREA",
        "BOX:37023",
        "MAP:3374C7",
        "ID:FD1111780",
        "UNIT:R16 SQ37 R4");

    doTest("T25",
        "911: SQ134  type:ATRAN   adr:CENTER SQUARE TOWR #823-A ,28 at 555 BROAD ST #823-A ,28 btwn ATKINSON DR & VETE  aai:  box:19052  map:2922H10 tm:18:18:15  ED1127865",
        "SRC:SQ134",
        "CALL:ATRAN - ALS/UNSPECIFIED EMERGENCY",
        "PLACE:CENTER SQUARE TOWR #823-A",
        "ADDR:555 BROAD ST",
        "APT:823-A",
        "CITY:DOYLESTOWN",
        "X:ATKINSON DR & VETE",
        "BOX:19052",
        "MAP:2922H10",
        "ID:ED1127865");

    doTest("T26",
        "STA19  type:FALRM   adr:LINDEN ELEM SCH ,28 at 480 LINDEN AV ,28 btwn EAST ST & ROHR DR  aai:  box:19093  map:2923A10  tm:20:27:42  FD1111756\4s",
        "SRC:STA19",
        "CALL:FALRM - FIRE ALARM (LOC)",
        "PLACE:LINDEN ELEM SCH",
        "ADDR:480 LINDEN AV",
        "CITY:DOYLESTOWN",
        "X:EAST ST & ROHR DR",
        "BOX:19093",
        "MAP:2923A10",
        "ID:FD1111756\4s");

    doTest("T27",
        "911: STA19  type:GALRM   adr:6 FLINT CI ,29  btwn WINDSOR WY & CUL DE SAC  aai:  box:79020  map:3034H5  tm:23:32:45  FD1112459\4sRun: E79\4s\n",
        "SRC:STA19",
        "CALL:GALRM - GENERAL ALARM",
        "ADDR:6 FLINT CI",
        "CITY:DOYLESTOWN TWP",
        "X:WINDSOR WY & CUL DE SAC",
        "BOX:79020",
        "MAP:3034H5",
        "ID:E79\4s");

    doTest("T28",
        "911: SQ122  type:ESPEC   adr:HARTS FIRE CO ,74 at 1195 YORK RD ,74 btwn OLD YORK RD & BRISTOL RD  aai:  box:93030  map:3147E4  tm:05:04:12  ED1131511",
        "SRC:SQ122",
        "CALL:ESPEC - STANDBY / SPECIAL ASSIGNMENT (EMS)",
        "PLACE:HARTS FIRE CO",
        "ADDR:1195 YORK RD",
        "CITY:WARMINSTER TWP",
        "X:OLD YORK RD & BRISTOL RD",
        "BOX:93030",
        "MAP:3147E4",
        "ID:ED1131511");

    doTest("T29",
        "911: SQ134  type:BASSLT  adr:248 INVERNESS CI ,48  btwn BONNIE LARK CT & CUL DE SAC  aai:  box:74059  map:3033F7  tm:16:38:31  ED1133930",
        "SRC:SQ134",
        "CALL:BASSLT - ASSAULT - NON CRITICAL",
        "ADDR:248 INVERNESS CI",
        "CITY:NEW BRITAIN TWP",
        "X:BONNIE LARK CT & CUL DE SAC",
        "BOX:74059",
        "MAP:3033F7",
        "ID:ED1133930");
  }
  
  public static void main(String[] args) {
    new PABucksCountyParserTest().generateTests("T30");
  }
}