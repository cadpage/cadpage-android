package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class VAHanoverCountyParserTest extends BaseParserTest {
  
  public VAHanoverCountyParserTest() {
    setParser(new VAHanoverCountyParser(), "HANOVER COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:(21777) a\n" +
        "Unit:E12 UnitSts: Inc#:2010-00000919 Inc:MVANoInj Loc:36 S INTERSTATE 295 MapRef:R Map 1591 VEH VS DEER, NO INJS, H",

        "ID:2010-00000919",
        "UNIT:E12",
        "CALL:MVANoInj",
        "ADDR:36 S INTERSTATE 295",
        "MAP:R Map 1591",
        "INFO:VEH VS DEER, NO INJS, H");

    doTest("T2",
        "(16407]  a ) Unit:E07 UnitSts: Inc#:2012-00031976 Inc:DifBreathn Loc:7103 NEW HUNTER RD MapRef:R Map 1593 APT 1011 Addtl:DIFF BREATHING",
        "ID:2012-00031976",
        "UNIT:E07",
        "CALL:DifBreathn",
        "ADDR:7103 NEW HUNTER RD",
        "MAP:R Map 1593",
        "INFO:APT 1011 -DIFF BREATHING");

    doTest("T3",
        "(12716a ) Unit:E07 UnitSts: Inc#:2012-00031961 Inc:Unconscous Loc:7052 MECHANICSVILLE TP MapRef:R Map 1592 PASSED OUT Addtl:",
        "ID:2012-00031961",
        "UNIT:E07",
        "CALL:Unconscous",
        "ADDR:7052 MECHANICSVILLE TP",
        "MADDR:7052 MECHANICSVILLE TPK",
        "MAP:R Map 1592",
        "INFO:PASSED OUT");

    doTest("T4",
        "[(7584]  a ) Unit:E07 UnitSts: Inc#:2012-00031934 Inc:VehFire Loc:MECHANICSVILLE TP/BELL CREEK MapRef:R Map 1592 Addtl:IN TURNING LANE, ON FIRE",
        "ID:2012-00031934",
        "UNIT:E07",
        "CALL:VehFire",
        "ADDR:MECHANICSVILLE TP & BELL CREEK",
        "MADDR:MECHANICSVILLE TPK & BELL CREEK",
        "MAP:R Map 1592",
        "INFO:IN TURNING LANE, ON FIRE");

    doTest("T5",
        "(5677 a ) Unit:E07 UnitSts: Inc#:2012-00000667 Inc:OutSmall Loc:BELLFLOWER CR/TIFFANY MapRef:R Map 1503 Addtl:WPH2:",
        "ID:2012-00000667",
        "UNIT:E07",
        "CALL:OutSmall",
        "ADDR:BELLFLOWER CR & TIFFANY",
        "MADDR:BELLFLOWER CIR & TIFFANY",
        "MAP:R Map 1503",
        "INFO:WPH2:");

    doTest("T6",
        "[(5243]  a ) Unit:E07 UnitSts: Inc#:2012-00031927 Inc:VehCrash Loc:COLD HARBOR RD/BELL CREEK MapRef:R Map 1594 3 VEH MVA, UNKNW INJURIES Addtl:ONE ON RIGHT",
        "ID:2012-00031927",
        "UNIT:E07",
        "CALL:VehCrash",
        "ADDR:COLD HARBOR RD & BELL CREEK",
        "MAP:R Map 1594",
        "INFO:3 VEH MVA, UNKNW INJURIES -ONE ON RIGHT");

    doTest("T7",
        "[(3875]  a ) Unit:E07 UnitSts: Inc#:2012-00031920 Inc:OutSmall Loc:MECHANICSVILLE TP/COLONY MapRef:R Map 1592   IN THE MEDIAN SMOKING Addtl:",
        "ID:2012-00031920",
        "UNIT:E07",
        "CALL:OutSmall",
        "ADDR:MECHANICSVILLE TP & COLONY",
        "MADDR:MECHANICSVILLE TPK & COLONY",
        "MAP:R Map 1592",
        "INFO:IN THE MEDIAN SMOKING");
  }
  
  public static void main(String[] args) {
    new VAHanoverCountyParserTest().generateTests("T1");
  }
}