package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class ORMarionCountyNParserTest extends BaseParserTest {
  
  public ORMarionCountyNParserTest() {
    setParser(new ORMarionCountyNParser(), "MARION COUNTY", "OR");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[(49962]  : ) TONE:  819::RAILWAY:AV:::::3030:VTON,STAF,:SAFE COM STA1@1830/APP CKS@1900 EMS@1945 STA1:20110302:174858",
        "ID:49962",
        "CALL:TONE",
        "ADDR:819 RAILWAY AVE",
        "MAP:3030",
        "UNIT:VTON,STAF",
        "INFO:SAFE COM STA1@1830/APP CKS@1900 EMS@1945 STA1");

    doTest("T2",
        "[(45354]  : ) CVA: 1732::PINE:ST:9::::3029:M24,R404,D411,STAF,N7,:35 Y M C/B/A LEFT SIDE PARALYSIS:20110223:110234",
        "ID:45354",
        "CALL:CVA",
        "ADDR:1732 PINE ST",
        "APT:9",
        "MAP:3029",
        "UNIT:M24,R404,D411,STAF,N7",
        "INFO:35 Y M C/B/A LEFT SIDE PARALYSIS");

    doTest("T3",
        "[(47486]  : ) STRC:::ABIQUA:RD:::HW 213::2833:E435,E485,E405,E415,D411,T489,T418,T419,R484,PGE,TIME,STAF,N7,:LARGE FLAMES APPX 2 MILES EAST:20110226:183324",
        "ID:47486",
        "CALL:STRC",
        "ADDR:ABIQUA RD & HWY 213",
        "MAP:2833",
        "UNIT:E435,E485,E405,E415,D411,T489,T418,T419,R484,PGE,TIME,STAF,N7",
        "INFO:LARGE FLAMES APPX 2 MILES EAST");

    doTest("T4",
        "[(48144]  : ) SICK: 5024::CROOKED FINGER:RD:::::3340:E485,D411,:75YOM C/B/A DIZZY:20110228:043844",
        "ID:48144",
        "CALL:SICK",
        "ADDR:5024 CROOKED FINGER RD",
        "MAP:3340",
        "UNIT:E485,D411",
        "INFO:75YOM C/B/A DIZZY");

    doTest("T5",
        "[(50323]  : ) BREA:12884::MASCHER:RD:::::3230:E415,D411,STAF,:85YOF C/A/SOB FAST HEART RATE/150:20110303:140259",
        "ID:50323",
        "CALL:BREA",
        "ADDR:12884 MASCHER RD",
        "MAP:3230",
        "UNIT:E415,D411,STAF",
        "INFO:85YOF C/A/SOB FAST HEART RATE/150");

    doTest("T6",
        "[(50791]  : ) FALL:  930::OAK:ST:130::::3031:M23,R404,D411,N7,:99YOF C/A/B GLF R HIP PAIN:20110304:073911",
        "ID:50791",
        "CALL:FALL",
        "ADDR:930 OAK ST",
        "APT:130",
        "MAP:3031",
        "UNIT:M23,R404,D411,N7",
        "INFO:99YOF C/A/B GLF R HIP PAIN");

    doTest("T7",
        "[(52678]  : ) ALM: 1106::PINE:ST:::::3030:E405,D411,N7,:CO2 DETECTOR ALRM AT COMM LOC:20110306:215554",
        "ID:52678",
        "CALL:ALM",
        "ADDR:1106 PINE ST",
        "MAP:3030",
        "UNIT:E405,D411,N7",
        "INFO:CO2 DETECTOR ALRM AT COMM LOC");

    doTest("T8",
        "[(52806]  : ) UNC: 5870::VALLEY VIEW:RD:::::3032:M24,R404,D411,N7,:65YOM UNC/NOT BREA:20110307:073728",
        "ID:52806",
        "CALL:UNC",
        "ADDR:5870 VALLEY VIEW RD",
        "MAP:3032",
        "UNIT:M24,R404,D411,N7",
        "INFO:65YOM UNC/NOT BREA");

    doTest("T9",
        "[(53886]  : ) MISC:12622::SILVERTON:RD:::::3030:E415,D411,N7,:FLAMES SEEN FROM FIELD NEAR BY:20110308:190734",
        "ID:53886",
        "CALL:MISC",
        "ADDR:12622 SILVERTON RD",
        "MAP:3030",
        "UNIT:E415,D411,N7",
        "INFO:FLAMES SEEN FROM FIELD NEAR BY");

    doTest("T10",
        "[(53944]  : ) SUIC: 1418::PINE:ST:D::::3030:M24,R404,D411,N7,:64YOF/C/B/SUIC ATTEMPT, SLASHED WRISTS:20110308:194443",
        "ID:53944",
        "CALL:SUIC",
        "ADDR:1418 PINE ST",
        "APT:D",
        "MAP:3030",
        "UNIT:M24,R404,D411,N7",
        "INFO:64YOF/C/B/SUIC ATTEMPT, SLASHED WRISTS");

    doTest("T11",
        "[(54072]  : ) MVA:  918:N:FIRST:ST:::::3031:E405,E435,R404,D411,M23,N7,:ONE VEH ROLLOVER IFO ROTHS STORE:20110309:022055",
        "ID:54072",
        "CALL:MVA",
        "ADDR:918 N FIRST ST",
        "MAP:3031",
        "UNIT:E405,E435,R404,D411,M23,N7",
        "INFO:ONE VEH ROLLOVER IFO ROTHS STORE");

    doTest("T12",
        "[(45886]  : ) MVA:::CASCADE:HW:::STATE:ST:3630:E425,D411,R404,M31,SBLE,SBLR,PGE,E415,LAW,N7,:SINGLE VEH ROLLOVER/ENTRAPMENT, NO INJ:20110224:063549",
        "ID:45886",
        "CALL:MVA",
        "ADDR:CASCADE HWY & STATE ST",
        "MAP:3630",
        "UNIT:E425,D411,R404,M31,SBLE,SBLR,PGE,E415,LAW,N7",
        "INFO:SINGLE VEH ROLLOVER/ENTRAPMENT, NO INJ");

  }
  
  public static void main(String[] args) {
    new ORMarionCountyNParserTest().generateTests("T1");
  }
}