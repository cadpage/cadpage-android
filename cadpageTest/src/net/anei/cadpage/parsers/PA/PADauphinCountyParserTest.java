package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PADauphinCountyParserTest extends BaseParserTest {
  
  public PADauphinCountyParserTest() {
    setParser(new PADauphinCountyParser(), "DAUPHIN COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(29CAD) [!] Box:29-1 Loc:31 S RIVER RD HFT DAUP XSts:PETERS MOUNTAIN RD ,SYCAMORE AV Event Type:OVERDOSE / POISONING (INGESTION) Class: 1 Disp: P29",
        "SRC:29CAD",
        "BOX:29-1",
        "ADDR:31 S RIVER RD",
        "CITY:HALIFAX TWP",
        "X:PETERS MOUNTAIN RD / SYCAMORE AV",
        "CALL:OVERDOSE / POISONING (INGESTION)",
        "PRI:1",
        "UNIT:P29");

    doTest("T2",
        "(29CAD) [!] Box:29-6 Loc:100 S FOURTH ST HFX DAUP: @BEER AND SODA PLUS XSts:RISE ST ,PETERS MOUNTAIN RD Event Type:TRAFFIC / TRANSPORTATION ACCIDENT INJURIES Class: Disp: E29-1",
        "SRC:29CAD",
        "BOX:29-6",
        "ADDR:100 S FOURTH ST",
        "CITY:HALIFAX",
        "PLACE:BEER AND SODA PLUS",
        "X:RISE ST / PETERS MOUNTAIN RD",
        "CALL:TRAFFIC / TRANSPORTATION ACCIDENT INJURIES",
        "UNIT:E29-1");

    doTest("T3",
        "(29CAD) [!] Box:29-6 Loc:123 RIVERVIEW DR HFT DAUP Event Type:CHEST PAIN Class: 1 Disp: 13-2,6-4",
        "SRC:29CAD",
        "BOX:29-6",
        "ADDR:123 RIVERVIEW DR",
        "CITY:HALIFAX TWP",
        "CALL:CHEST PAIN",
        "PRI:1",
        "UNIT:13-2,6-4");

    doTest("T4",
        "(29CAD) [!] Box:29-6 XSts:MARKET ST ,S THIRD ST Event Type:UNCONSCIOUS / FAINTING (NEAR) Class: 2 Disp: 13-1",
        "SRC:29CAD",
        "BOX:29-6",
        "ADDR:MARKET ST & S THIRD ST",
        "CALL:UNCONSCIOUS / FAINTING (NEAR)",
        "PRI:2",
        "UNIT:13-1");

    doTest("T5",
        "(29CAD) [!] Box:29-4 Loc:388 DUNKEL SCHOOL RD HFT DAUP XSts:HILLTOP RD ,ROUNDTOP DR Event Type:ASSIST / SERVICE CALLS SELECT SUB-TYPE IF APPROPRIATE Class: Disp: P29",
        "SRC:29CAD",
        "BOX:29-4",
        "ADDR:388 DUNKEL SCHOOL RD",
        "CITY:HALIFAX TWP",
        "X:HILLTOP RD / ROUNDTOP DR",
        "CALL:ASSIST / SERVICE CALLS SELECT SUB-TYPE IF APPROPRIATE",
        "UNIT:P29");

    doTest("T6",
        "(29CAD) [!] Box:29-1 Loc:499 S RIVER RD HFT DAUP XSts:AMITY LN ,SHAMOS SCHOOL RD Event Type:PSYCHIATRIC / SUICIDE ATTEMPT Class: 2 Disp: 13-1",
        "SRC:29CAD",
        "BOX:29-1",
        "ADDR:499 S RIVER RD",
        "CITY:HALIFAX TWP",
        "X:AMITY LN / SHAMOS SCHOOL RD",
        "CALL:PSYCHIATRIC / SUICIDE ATTEMPT",
        "PRI:2",
        "UNIT:13-1");

    doTest("T7",
        "(29CAD) [!] Box:29-1 Loc:3188 PETERS MOUNTAIN RD HFT DAUP XSts:HILL DR ,ROADCAP LN Event Type:ABDOMINAL PAINS / PROBLEMS Class: 1 Disp: 13-1,6-4",
        "SRC:29CAD",
        "BOX:29-1",
        "ADDR:3188 PETERS MOUNTAIN RD",
        "CITY:HALIFAX TWP",
        "X:HILL DR / ROADCAP LN",
        "CALL:ABDOMINAL PAINS / PROBLEMS",
        "PRI:1",
        "UNIT:13-1,6-4");

    doTest("T8",
        "(29CAD) [!] Box:29-6 Loc:502 N SECOND ST HFT DAUP XSts:GREEN ST ,LOCUST ST Event Type:HEART PROBLEMS / A.I.C.D. Class: 1 Disp: 13-2,6-4",
        "SRC:29CAD",
        "BOX:29-6",
        "ADDR:502 N SECOND ST",
        "CITY:HALIFAX TWP",
        "X:GREEN ST / LOCUST ST",
        "CALL:HEART PROBLEMS / A.I.C.D.",
        "PRI:1",
        "UNIT:13-2,6-4");

    doTest("T9",
        "(29CAD) [!] Box:29-1 Loc:3777 PETERS MOUNTAIN RD HFT DAUP: @GIANT XSts:LEISURE LN ,SWEIGARD DR Event Type:CONVULSIONS / SEIZURES Class: 1 Disp: 13-2,6-5",
        "SRC:29CAD",
        "BOX:29-1",
        "ADDR:3777 PETERS MOUNTAIN RD",
        "CITY:HALIFAX TWP",
        "PLACE:GIANT",
        "X:LEISURE LN / SWEIGARD DR",
        "CALL:CONVULSIONS / SEIZURES",
        "PRI:1",
        "UNIT:13-2,6-5");

    doTest("T10",
        "(29CAD) [!] Box:29-5 Loc:123 BRUBAKER RD RDT DAUP XSts:S RIVER RD ,MOUNTAIN RD Event Type:BREATHING PROBLEMS Class: 1 Disp: 13-2",
        "SRC:29CAD",
        "BOX:29-5",
        "ADDR:123 BRUBAKER RD",
        "CITY:REED TWP",
        "X:S RIVER RD / MOUNTAIN RD",
        "CALL:BREATHING PROBLEMS",
        "PRI:1",
        "UNIT:13-2");

    doTest("T11",
        "(29CAD) [!] Box:29-5 Loc:S RIVER RD RDT DAUP XSts:INGLENOOK RD ,RAMP Event Type:TRAFFIC / TRANSPORTATION ACCIDENT INJURIES Class: Disp: E29-1",
        "SRC:29CAD",
        "BOX:29-5",
        "ADDR:S RIVER RD",
        "MADDR:S RIVER RD & INGLENOOK RD",
        "CITY:REED TWP",
        "X:INGLENOOK RD / RAMP",
        "CALL:TRAFFIC / TRANSPORTATION ACCIDENT INJURIES",
        "UNIT:E29-1");

    doTest("T12",
        "(29CAD) [!] Box:29-4 XSts:N RIVER RD ,MCCLELLAN RD Event Type:SMOKE INVESTIGATION Class: 3 Disp: X29",
        "SRC:29CAD",
        "BOX:29-4",
        "ADDR:N RIVER RD & MCCLELLAN RD",
        "CALL:SMOKE INVESTIGATION",
        "PRI:3",
        "UNIT:X29");

    doTest("T13",
        "(29CAD) [!] Box:29-1 Loc:176 DUSTY TRAIL RD HFT DAUP XSts:CREEK SIDE DR ,DEAD END Event Type:OUTSIDE FIRE NATURAL COVER Class: 1 Disp: E29-1,A20",
        "SRC:29CAD",
        "BOX:29-1",
        "ADDR:176 DUSTY TRAIL RD",
        "CITY:HALIFAX TWP",
        "X:CREEK SIDE DR / DEAD END",
        "CALL:OUTSIDE FIRE NATURAL COVER",
        "PRI:1",
        "UNIT:E29-1,A20");

    doTest("T14",
        "(29CAD) [!] Box:29-6 Loc:117 ARMSTRONG ST HFX DAUP XSts:N FRONT ST ,FISHER ST Event Type:CARDIAC OR RESPIRATORY ARREST / DEATH AED RESPONSE Class: 1 Disp: P29",
        "SRC:29CAD",
        "BOX:29-6",
        "ADDR:117 ARMSTRONG ST",
        "CITY:HALIFAX",
        "X:N FRONT ST / FISHER ST",
        "CALL:CARDIAC OR RESPIRATORY ARREST / DEATH AED RESPONSE",
        "PRI:1",
        "UNIT:P29");

    doTest("T15",
        "(29CAD) [!] Box:29-6 Loc:201 MARKET ST HFX DAUP XSts:S SECOND ST ,S THIRD ST Event Type:CHEST PAIN Class: Disp: M/PC81,13-1,20-2",
        "SRC:29CAD",
        "BOX:29-6",
        "ADDR:201 MARKET ST",
        "CITY:HALIFAX",
        "X:S SECOND ST / S THIRD ST",
        "CALL:CHEST PAIN",
        "UNIT:M/PC81,13-1,20-2");

    doTest("T16",
        "(29CAD) [!] Box:29-2 Loc:676 DUNKEL SCHOOL RD HFT DAUP XSts:CATERPILLAR LN ,KEIFFER RD Event Type:BREATHING PROBLEMS Class: 1 Disp: 13-2,6-5",
        "SRC:29CAD",
        "BOX:29-2",
        "ADDR:676 DUNKEL SCHOOL RD",
        "CITY:HALIFAX TWP",
        "X:CATERPILLAR LN / KEIFFER RD",
        "CALL:BREATHING PROBLEMS",
        "PRI:1",
        "UNIT:13-2,6-5");

    doTest("T17",
        "(21CAD) [!] Box:21-4 Loc:179 WOLFE RD WST DAUP XSts:RAKERS MILL RD ,HENNINGER RD Event Type:BREATHING PROBLEMS Class: 1 Disp: P21",
        "SRC:21CAD",
        "BOX:21-4",
        "ADDR:179 WOLFE RD",
        "CITY:WASHINTON TWP",
        "X:RAKERS MILL RD / HENNINGER RD",
        "CALL:BREATHING PROBLEMS",
        "PRI:1",
        "UNIT:P21");
 }
  
  public static void main(String[] args) {
    new PADauphinCountyParserTest().generateTests("T1");
  }
}
