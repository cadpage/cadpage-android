package net.anei.cadpage.parsers.MS;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MSMarionCountyParserTest extends BaseParserTest {
  
  public MSMarionCountyParserTest() {
    setParser(new MSMarionCountyParser(), "MARION COUNTY", "MS");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "-  - 911-CENTER:SFIRE >STRUCTURE FIRE 1129 PICKWICK RD FOXWORTH FORBES, WILLEASE Map: Grids:, Cad: 2012-0000001317\n",
        "CALL:STRUCTURE FIRE",
        "ADDR:1129 PICKWICK RD",
        "CITY:FOXWORTH",
        "NAME:FORBES, WILLEASE",
        "ID:2012-0000001317");

    doTest("T2",
        "-  - 911-CENTER:SIG72 >MEDICAL CALL 577 MT CARMEL CHURCH RD FOXWORTH AT&T MOBILITY Map: Grids:, Cad: 2012-0000001285\n",
        "CALL:MEDICAL CALL",
        "ADDR:577 MT CARMEL CHURCH RD",
        "CITY:FOXWORTH",
        "NAME:AT&T MOBILITY",
        "ID:2012-0000001285");

    doTest("T3",
        "-  - 911-CENTER:SIG72 >MEDICAL CALL 244 SPRING HILL CHURCH RD SANDY HOOK AT&T MOBILITY Map: Grids:, Cad: 2012-0000001188\n",
        "CALL:MEDICAL CALL",
        "ADDR:244 SPRING HILL CHURCH RD",
        "CITY:SANDY HOOK",
        "NAME:AT&T MOBILITY",
        "ID:2012-0000001188");

    doTest("T4",
        "-  - 911-CENTER:EVENT: SIG72 LOC:185 SHILOH FIRETOWER RD Cad: 2012-0000000979 ENR >22:42 1023 >22:44 1024 >23:22 PATIENT REF TRANS\n",
        "CALL:SIG72",
        "ADDR:185 SHILOH FIRETOWER RD",
        "ID:2012-0000000979");

    doTest("T5",
        "-  - 911-CENTER:SIG72 >MEDICAL CALL 185 SHILOH FIRETOWER RD FOXWORTH BROOM, PAUL & MARTHA Map: Grids:, Cad: 2012-0000000979",
        "CALL:MEDICAL CALL",
        "ADDR:185 SHILOH FIRETOWER RD",
        "CITY:FOXWORTH",
        "NAME:BROOM, PAUL & MARTHA",
        "ID:2012-0000000979");

    doTest("T6",
        "-  - 911-CENTER:EVENT: SIG2F LOC:109 HWY 98 E Cad: 2012-0000000949 ENR >14:14 1024 >15:00\n",
        "CALL:SIG2F",
        "ADDR:109 HWY 98 E",
        "ID:2012-0000000949");

    doTest("T7",
        "-  - 911-CENTER:SIG2F >ALARM FIRE 109 HWY 98 E COLUMBIA Map: Grids:, Cad: 2012-0000000949\n",
        "CALL:ALARM FIRE",
        "ADDR:109 HWY 98 E",
        "CITY:COLUMBIA",
        "ID:2012-0000000949");

    doTest("T8",
        "-  - 911-CENTER:SIG72 >MEDICAL CALL 491 JOHNSON RD SANDY HOOK MINGO, KAREN Map: Grids:, Cad: 2012-0000000646\n",
        "CALL:MEDICAL CALL",
        "ADDR:491 JOHNSON RD",
        "CITY:SANDY HOOK",
        "NAME:MINGO, KAREN",
        "ID:2012-0000000646");

    doTest("T9",
        "-  - 911-CENTER:EVENT: SIG1S LOC:HWY 98 W Cad: 2012-0000000479 1023 >04:52 1024 >14:57\n",
        "CALL:SIG1S",
        "ADDR:HWY 98 W",
        "ID:2012-0000000479");

    doTest("T10",
        "-  - 911-CENTER:EVENT: SIG80 LOC:191 STOGNER RD Cad: 2012-0000000431 ENR >20:45 1023 >21:05 1024 >23:17\n",
        "CALL:SIG80",
        "ADDR:191 STOGNER RD",
        "ID:2012-0000000431");

    doTest("T11",
        "-  - 911-CENTER:SIG80 >MISSING PERSON / RUNAWAY 191 STOGNER RD FOXWORTH CELLULAR SOUTH Map: Grids:, Cad: 2012-0000000431\n",
        "CALL:MISSING PERSON/RUNAWAY",
        "ADDR:191 STOGNER RD",
        "CITY:FOXWORTH",
        "NAME:CELLULAR SOUTH",
        "ID:2012-0000000431");

    doTest("T12",
        "-  - 911-CENTER:EVENT: SIG1 LOC:115 KOKOMO RD Cad: 2012-0000000429 1023 >18:21 1024 >19:28\n",
        "CALL:SIG1",
        "ADDR:115 KOKOMO RD",
        "ID:2012-0000000429");

    doTest("T13",
        "-  - 911-CENTER:SIG1 >MVA 115 KOKOMO RD KOKOMO TONEY, JACK Map: Grids:, Cad: 2012-0000000429\n",
        "CALL:MVA",
        "ADDR:115 KOKOMO RD",
        "CITY:KOKOMO",
        "NAME:TONEY, JACK",
        "ID:2012-0000000429");

    doTest("T14",
        "-  - 911-CENTER:SIG72 >MEDICAL CALL 91 HURRICANE CREEK RD SANDY HOOK CELLULAR SOUTH Map: Grids:, Cad: 2012-0000000390\n",
        "CALL:MEDICAL CALL",
        "ADDR:91 HURRICANE CREEK RD",
        "CITY:SANDY HOOK",
        "NAME:CELLULAR SOUTH",
        "ID:2012-0000000390");

    doTest("T15",
        "-  - 911-CENTER:SIG72 >MEDICAL CALL 244 SPRING HILL CHURCH RD SANDY HOOK LEWIS, MARY Map: Grids:, Cad: 2012-0000001643\n",
        "CALL:MEDICAL CALL",
        "ADDR:244 SPRING HILL CHURCH RD",
        "CITY:SANDY HOOK",
        "NAME:LEWIS, MARY",
        "ID:2012-0000001643");

    doTest("T16",
        "-  - 911-CENTER:SIG72 >MEDICAL CALL 240 BRANTON BAY RD TYLERTOWN AT&T MOBILITY Map: Grids:, Cad: 2012-0000001839\n",
        "CALL:MEDICAL CALL",
        "ADDR:240 BRANTON BAY RD",
        "NAME:TYLERTOWN AT&T MOBILITY",
        "ID:2012-0000001839");

    doTest("T17",
        "-  - 911-CENTER:EVENT: SIG72 LOC:37 STRINGER BULLOCK RD Cad: 2012-0000001996 ENR >21:01 1023 >21:15 1024 >21:41\n",
        "CALL:SIG72",
        "ADDR:37 STRINGER BULLOCK RD",
        "ID:2012-0000001996");

    doTest("T18",
        "-  - 911-CENTER:EVENT: SIG1 LOC:283 MAYS CREEK RD Cad: 2012-0000002303 1023 >22:12 1024 >22:43\n",
        "CALL:SIG1",
        "ADDR:283 MAYS CREEK RD",
        "ID:2012-0000002303");

    doTest("T19",
        "-  - 911-CENTER:EVENT: SFIRE LOC:31 OILFIELD CUT OFF RD Cad: 2012-0000002674 ENR >03:33 1023 >03:39 1024 >07:10\n",
        "CALL:SFIRE",
        "ADDR:31 OILFIELD CUT OFF RD",
        "ID:2012-0000002674");

  }
  
  public static void main(String[] args) {
    new MSMarionCountyParserTest().generateTests("T1", "CALL ADDR X CITY NAME PHONE MAP ID");
  }
}