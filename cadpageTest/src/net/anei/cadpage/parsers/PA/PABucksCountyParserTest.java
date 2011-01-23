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
        "CALL:BINJ - INJURY",
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
        "ADDR:2343 BETHLEHEM PK #312",
        "PLACE:DOCK MEADOWS NH",
        "CITY:HILLTOWN TWP",
        "X:UNIONVILLE PK & CHURCH RD",
        "INFO:GO TO CHURCH RD NORTH ENTRANCE",
        "BOX:60063",
        "MAP:3032E3",
        "ID:ED1042598");
        
  }
}