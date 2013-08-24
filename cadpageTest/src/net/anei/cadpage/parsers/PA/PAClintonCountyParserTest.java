package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Clinton County, PA
Contact: woolrichvolfireco@comcast.net
Sender: Message.CC_PSAP@clintoncountypa.com

'MVA w/Entp   RTE 220 N MC TO AV 117   Wayne   MVA W/PERSON UNDER VEHICLE   2012-00000206'
'801   Alarm   1059 VALLEY VIEW RD   Pine Creek   FIRST FLOOR SMOKE DETECTOR   2012-00000211   CHARLES RESIDENCE'
'1202   Local   2161 WOODWARD AVE   Pine Creek   WIRE ARCING, POSSIBLE DOWN   2012-00000195'
'1201   BLSE   439 PARK AVE   Pine Creek   62 Y/O MALE NECK PAIN FROM A BULDGING DISK   2012-00000194'
'1202   MVA w/Inj   ISLAND RD/HARLEY   Pine Creek   ONE VEHICLE WITH INURIES   2012-00000188'
'1202   MVA w/n In   1491 DUTCH HOLLOW RD   Pine Creek   MVA WITH ROLEOVER, NO ONE AROUND THE VEHICLE   2012-00000182   VW JETTA'
'1201   MVA w/Inj   419 PARK AVE   Pine Creek   CAR INTO A TREE   2012-00000170'
'1001   Alarm   612 MCELHATTAN DR   Wayne   ZONE 13 SMOKE DETECTOR   2012-00000199   BALD EAGLE TRUCK STOP'
'1205   Service   668 LITTLE PLUM RUN RD   Dunnstable   FALL VICTIM, LIFT ASSISTANCE   2012-00000203'

*/

public class PAClintonCountyParserTest extends BaseParserTest {
  
  public PAClintonCountyParserTest() {
    setParser(new PAClintonCountyParser(), "CLINTON COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "'MVA w/Entp   RTE 220 N MC TO AV 117   Wayne   MVA W/PERSON UNDER VEHICLE   2012-00000206'",
        "ADDR:RTE 220 N MC TO AV 117",
        "MADDR:RTE 220 N MC TO AVE 117",  // What does this mean???
        "CITY:Wayne",
        "CALL:MVA W/PERSON UNDER VEHICLE",
        "ID:2012-00000206");

    doTest("T2",
        "'801   Alarm   1059 VALLEY VIEW RD   Pine Creek   FIRST FLOOR SMOKE DETECTOR   2012-00000211   CHARLES RESIDENCE'",
        "UNIT:801",
        "ADDR:1059 VALLEY VIEW RD",
        "CITY:Pine Creek",
        "CALL:FIRST FLOOR SMOKE DETECTOR",
        "ID:2012-00000211",
        "INFO:CHARLES RESIDENCE");

    doTest("T3",
        "'1202   Local   2161 WOODWARD AVE   Pine Creek   WIRE ARCING, POSSIBLE DOWN   2012-00000195'",
        "UNIT:1202",
        "ADDR:2161 WOODWARD AVE",
        "CITY:Pine Creek",
        "CALL:WIRE ARCING, POSSIBLE DOWN",
        "ID:2012-00000195");

    doTest("T4",
        "'1201   BLSE   439 PARK AVE   Pine Creek   62 Y/O MALE NECK PAIN FROM A BULDGING DISK   2012-00000194'",
        "UNIT:1201",
        "ADDR:439 PARK AVE",
        "CITY:Pine Creek",
        "CALL:62 Y/O MALE NECK PAIN FROM A BULDGING DISK",
        "ID:2012-00000194");

    doTest("T5",
        "'1202   MVA w/Inj   ISLAND RD/HARLEY   Pine Creek   ONE VEHICLE WITH INURIES   2012-00000188'",
        "UNIT:1202",
        "ADDR:ISLAND RD & HARLEY",
        "CITY:Pine Creek",
        "CALL:ONE VEHICLE WITH INURIES",
        "ID:2012-00000188");

    doTest("T6",
        "'1202   MVA w/n In   1491 DUTCH HOLLOW RD   Pine Creek   MVA WITH ROLEOVER, NO ONE AROUND THE VEHICLE   2012-00000182   VW JETTA'",
        "UNIT:1202",
        "ADDR:1491 DUTCH HOLLOW RD",
        "CITY:Pine Creek",
        "CALL:MVA WITH ROLEOVER, NO ONE AROUND THE VEHICLE",
        "ID:2012-00000182",
        "INFO:VW JETTA");

    doTest("T7",
        "'1201   MVA w/Inj   419 PARK AVE   Pine Creek   CAR INTO A TREE   2012-00000170'",
        "UNIT:1201",
        "ADDR:419 PARK AVE",
        "CITY:Pine Creek",
        "CALL:CAR INTO A TREE",
        "ID:2012-00000170");

    doTest("T8",
        "'1001   Alarm   612 MCELHATTAN DR   Wayne   ZONE 13 SMOKE DETECTOR   2012-00000199   BALD EAGLE TRUCK STOP'",
        "UNIT:1001",
        "ADDR:612 MCELHATTAN DR",
        "CITY:Wayne",
        "CALL:ZONE 13 SMOKE DETECTOR",
        "ID:2012-00000199",
        "INFO:BALD EAGLE TRUCK STOP");

    doTest("T9",
        "'1205   Service   668 LITTLE PLUM RUN RD   Dunnstable   FALL VICTIM, LIFT ASSISTANCE   2012-00000203'",
        "UNIT:1205",
        "ADDR:668 LITTLE PLUM RUN RD",
        "CITY:Dunnstable",
        "CALL:FALL VICTIM, LIFT ASSISTANCE",
        "ID:2012-00000203");

  }
  
  public static void main(String[] args) {
    new PAClintonCountyParserTest().generateTests("T1");
  }
  
}
