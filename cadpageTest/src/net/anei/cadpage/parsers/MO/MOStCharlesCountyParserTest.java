package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOStCharlesCountyParserTest extends BaseParserTest {
  
  public MOStCharlesCountyParserTest() {
    setParser(new MOStCharlesCountyParser(), "ST CHARLES COUNTY", "MO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "081411-29063        05 Back Pain (No Trauma) 161 Our Ln                                        ~/HIGHWAY 94 N           APT:                X ST:HIGHWAY 94 N/Dead End         MAP:M 6-22         Rivers Pointe B2",
        "ID:081411-29063",
        "CALL:05 Back Pain (No Trauma)",
        "ADDR:161 Our Ln",
        "PLACE:~/HIGHWAY 94 N",
        "X:HIGHWAY 94 N/Dead End",
        "MAP:M 6-22",
        "SRC:Rivers Pointe B2");

    doTest("T2",
        "072611-26676        23 Overdose QD           308 Donald Ave                                    PRAIRIE HOMES ADDN/HWY V APT:                X ST:SUSAN AVE/RUTH AVE            MAP:BB 8-19        Orchard Farm B2",
        "ID:072611-26676",
        "CALL:23 Overdose QD",
        "ADDR:308 Donald Ave",
        "PLACE:PRAIRIE HOMES ADDN/HWY V",
        "X:SUSAN AVE/RUTH AVE",
        "MAP:BB 8-19",
        "SRC:Orchard Farm B2");

    doTest("T3",
        "081911-29644        29 Motor Vehicle Accident4795 Highway 94 N                                 CHU Trinity Lutheran ChurAPT:                X ST:CHURCH RD/HIGHWAY H           MAP:Z 10-19        Orchard Farm B2",
        "ID:081911-29644",
        "CALL:29 Motor Vehicle Accident",
        "ADDR:4795 Highway 94 N",
        "PLACE:CHU Trinity Lutheran Chur",
        "X:CHURCH RD/HIGHWAY H",
        "MAP:Z 10-19",
        "SRC:Orchard Farm B2");

    doTest("T4",
        "080811-28362        29 Motor Vehicle AccidentHighway 94 N & Highway V                                                   APT:                X ST:                              MAP:Y 7-19         Orchard Farm B2",
        "ID:080811-28362",
        "CALL:29 Motor Vehicle Accident",
        "ADDR:Highway 94 N & Highway V",
        "MAP:Y 7-19",
        "SRC:Orchard Farm B2");

    doTest("T5",
        "082211-30048        32 Unknown EMS Problem QD14801 Highway 67 S                                south of the Clark BridgeAPT:                X ST:MISSISSIPPI RIV/Dead End      MAP:F 8-24         Rivers Pointe B2",
        "ID:082211-30048",
        "CALL:32 Unknown EMS Problem QD",
        "ADDR:14801 Highway 67 S",
        "PLACE:south of the Clark Bridge",
        "X:MISSISSIPPI RIV/Dead End",
        "MAP:F 8-24",
        "SRC:Rivers Pointe B2");

    doTest("T6",
        "080811-28362        29 Motor Vehicle AccidentHighway 94 N & Highway V                                                   APT:                X ST:                              MAP:Y 7-19         Orchard Farm B2",
        "ID:080811-28362",
        "CALL:29 Motor Vehicle Accident",
        "ADDR:Highway 94 N & Highway V",
        "MAP:Y 7-19",
        "SRC:Orchard Farm B2");

    doTest("T7",
        "080111-27420        17D3 Fall Not Alert      4297 Highway 94 N                                                          APT:                X ST:LAGO VISTA DR/WIEDEY RD       MAP:Z 11-35        Orchard Farm B2",
        "ID:080111-27420",
        "CALL:17D3 Fall Not Alert",
        "ADDR:4297 Highway 94 N",
        "X:LAGO VISTA DR/WIEDEY RD",
        "MAP:Z 11-35",
        "SRC:Orchard Farm B2");

    doTest("T8",
        "080111-27413        29B4 MVA Unknown Status  Orchard Farm Rd & Washeon Rd                                               APT:                X ST:                              MAP:CC 7-18        Orchard Farm B2",
        "ID:080111-27413",
        "CALL:29B4 MVA Unknown Status",
        "ADDR:Orchard Farm Rd & Washeon Rd",
        "MAP:CC 7-18",
        "SRC:Orchard Farm B2");

    doTest("T9",
        "072911-27066        29B4 MVA Unk Status Unk P22100 I 70 W                                      WB EO 79                 APT:                X ST:Dead End/DARDENNE CRK         MAP:NN 16-47       CCFR",
        "ID:072911-27066",
        "CALL:29B4 MVA Unk Status Unk P",
        "ADDR:22100 I 70 W",
        "PLACE:WB EO 79",
        "X:Dead End/DARDENNE CRK",
        "MAP:NN 16-47",
        "SRC:CCFR");

    doTest("T10",
        "072811-26894        Alarm - Commercial       2165 Highway V                                    SCH Orchard Farm Middle  APT:                X ST:HIGHWAY 94 N/UNNAMED STREET   MAP:Z 7-19         Orchard Farm B2",
        "ID:072811-26894",
        "CALL:Alarm - Commercial",
        "ADDR:2165 Highway V",
        "PLACE:SCH Orchard Farm Middle",
        "X:HIGHWAY 94 N/UNNAMED STREET",
        "MAP:Z 7-19",
        "SRC:Orchard Farm B2");

    doTest("T11",
        "080811-28275        Assist - Police (EMS)    14000 Highway 67 N                                GAS Pit Stop             APT:                X ST:RED SCHOOL RD/HIGHWAY 94      MAP:I 10-23        Rivers Pointe B2",
        "ID:080811-28275",
        "CALL:Assist - Police (EMS)",
        "ADDR:14000 Highway 67 N",
        "PLACE:GAS Pit Stop",
        "X:RED SCHOOL RD/HIGHWAY 94",
        "MAP:I 10-23",
        "SRC:Rivers Pointe B2");

    doTest("T12",
        "080311-27759        10 Chest Pain QD         15052 Main St                                     /HIGHWAY 94              APT:                X ST:SAINT LOUIS ST/Dead End       MAP:I 10-23        Rivers Pointe B2",
        "ID:080311-27759",
        "CALL:10 Chest Pain QD",
        "ADDR:15052 Main St",
        "PLACE:/HIGHWAY 94",
        "X:SAINT LOUIS ST/Dead End",
        "MAP:I 10-23",
        "SRC:Rivers Pointe B2");

    doTest("T13",
        "072611-26676        23C3 Overdose Antidepress308 Donald Ave                                    PRAIRIE HOMES ADDN/HWY V APT:                X ST:SUSAN AVE/RUTH AVE            MAP:BB 8-19        Orchard Farm B2",
        "ID:072611-26676",
        "CALL:23C3 Overdose Antidepress",
        "ADDR:308 Donald Ave",
        "PLACE:PRAIRIE HOMES ADDN/HWY V",
        "X:SUSAN AVE/RUTH AVE",
        "MAP:BB 8-19",
        "SRC:Orchard Farm B2");
  }
  
  public static void main(String[] args) {
    new MOStCharlesCountyParserTest().generateTests("T1", "ID INFO CALL ADDR PLACE APT X MAP SRC");
  }
}