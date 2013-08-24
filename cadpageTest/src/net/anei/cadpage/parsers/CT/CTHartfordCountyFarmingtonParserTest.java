package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Farmington, CT
Contact: "J. Neves" <jneves@effd.org>
Contact: Vincenzo <vgarcia1322@comcast.net>
Sender: pdpaging@farmington-ct.org

1100024685 MEDICAL CALL CHARLIE RESPONSE 00088  SCOTT SWAMP RD   UM1 XXFF AMR1 111117 15:13
1200006652 FIRE - BRUSH FIRE 01825 FARMINGTON AVE Prem Map -  PARK POND PL/SOUTH MAIN ST  XXTH 120409 11:05\r\n\r
1200006665 FIRE - MV  00270 FARMINGTON AVE Prem Map -  TALCOTT NOTCH RD/PARK DR  EXOG UE1 XXEF 120409 15:40\r\n\r
1200006659 FIRE - BRUSH FIRE SPIELMAN HWY/ MOUNTAIN SPRING RD   LC1 XXBF 120409 13:26\r\n\r
1200006653 MEDICAL CALL BRAVO RESPONSE 00204 MAIN ST BIDWELL SQ/ROURKE PL  XXFF AMR1 120409 11:12\r\n\r
1200006626 FIRE - SMOKE/GAS INVEST OUTSIDE 00339 MEADOW RD SOMERSBY WAY/JUDSON LA  EXSW XXFF 120409 00:12\r\n\r
1200006038 MEDICAL CALL CHARLIE RESPONSE 00051 LITCHFIELD RD PLAINVILLE AVE/BIRCH ST  UM1 XXTH AMR1 120330 20:14\r\n\r

Contact: Active911
Agency name: Canton Fire and EMS
Location: Canton, CT, United States
Sender: paging@cantonfireandems.org

1200007908 FIRE - GENERAL ALARM 00021  Dowd AVE Apt #: 15 MAPLE AV/CANTON HOLLOW  FDT1  202  121019 19:13\r\n\r\n
1200007788 FIRE - TREE ON/DOWNED WIRES ROUTE 202 /POWDER MILL RD   FDT1  201  121016 13:25\r\n\r\n
1200007774 FIRE - GENERAL ALARM 00098  NORTH MOUNTAIN RD PINE ACRES DR/CHRISTMAS TREE HILL RD  FDT1  121015 19:31\r\n\r\n
1200007698 FIRE - GENERAL ALARM 00102  Dyer AVE BIRCH KNOLL RD/SPOONWOOD DR  FDT1  121014 06:36\r\n\r\n
1200007634 FIRE - GENERAL ALARM 00021  Dowd AVE Apt #: 34 MAPLE AV/CANTON HOLLOW  FDT1  202  121012 16:20\r\n\r\n
1200007576 FIRE - CO ALARM W/ NO ILL EFFECTS 00018  Old Albany TPKE END/FOREST LN  C10  FDT1  202  121011 15:03\r\n\r\n
1200007471 FIRE - VEHICLE ACCIDENT (INJURIES) 00060 Lovely ST (CATI) Prem Map -    202  207  C10  FDT1  121008 17:35\r\n\r\n
1200007456 FIRE - SMOKE INVESTIGATION (IN BUILDING) 00050  East Hill RD Apt #: 6C COLONY RD/ALBANY TPKE  FDT1  207  5  121007 21:40\r\n\r\n
1200007397 FIRE-MISC 00045 RIVER RD Prem Map -    FDT1  121006 08:35\r\n\r\n

*/

public class CTHartfordCountyFarmingtonParserTest extends BaseParserTest {
  
  public CTHartfordCountyFarmingtonParserTest() {
    setParser(new CTHartfordCountyFarmingtonParser(), "HARTFORD COUNTY", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "1100024685 MEDICAL CALL CHARLIE RESPONSE 00088  SCOTT SWAMP RD   UM1 XXFF AMR1 111117 15:13",
        "ID:1100024685",
        "CALL:MEDICAL CALL CHARLIE RESPONSE",
        "ADDR:88 SCOTT SWAMP RD",
        "UNIT:UM1 XXFF AMR1",
        "DATE:11/17/11",
        "TIME:15:13");

    doTest("T2",
        "1200006652 FIRE - BRUSH FIRE 01825 FARMINGTON AVE Prem Map -  PARK POND PL/SOUTH MAIN ST  XXTH 120409 11:05\r\n\r",
        "ID:1200006652",
        "CALL:FIRE - BRUSH FIRE",
        "ADDR:1825 FARMINGTON AVE",
        "X:PARK POND PL/SOUTH MAIN ST",
        "UNIT:XXTH",
        "DATE:04/09/12",
        "TIME:11:05");

    doTest("T3",
        "1200006665 FIRE - MV  00270 FARMINGTON AVE Prem Map -  TALCOTT NOTCH RD/PARK DR  EXOG UE1 XXEF 120409 15:40\r\n\r",
        "ID:1200006665",
        "CALL:FIRE - MV",
        "ADDR:270 FARMINGTON AVE",
        "X:TALCOTT NOTCH RD/PARK DR",
        "UNIT:EXOG UE1 XXEF",
        "DATE:04/09/12",
        "TIME:15:40");

    doTest("T4",
        "1200006659 FIRE - BRUSH FIRE SPIELMAN HWY/ MOUNTAIN SPRING RD   LC1 XXBF 120409 13:26\r\n\r",
        "ID:1200006659",
        "CALL:FIRE - BRUSH FIRE",
        "ADDR:SPIELMAN HWY & MOUNTAIN SPRING RD",
        "UNIT:LC1 XXBF",
        "DATE:04/09/12",
        "TIME:13:26");

    doTest("T5",
        "1200006653 MEDICAL CALL BRAVO RESPONSE 00204 MAIN ST BIDWELL SQ/ROURKE PL  XXFF AMR1 120409 11:12\r\n\r",
        "ID:1200006653",
        "CALL:MEDICAL CALL BRAVO RESPONSE",
        "ADDR:204 MAIN ST",
        "X:BIDWELL SQ/ROURKE PL",
        "UNIT:XXFF AMR1",
        "DATE:04/09/12",
        "TIME:11:12");

    doTest("T6",
        "1200006626 FIRE - SMOKE/GAS INVEST OUTSIDE 00339 MEADOW RD SOMERSBY WAY/JUDSON LA  EXSW XXFF 120409 00:12\r\n\r",
        "ID:1200006626",
        "CALL:FIRE - SMOKE/GAS INVEST OUTSIDE",
        "ADDR:339 MEADOW RD",
        "X:SOMERSBY WAY/JUDSON LA",
        "UNIT:EXSW XXFF",
        "DATE:04/09/12",
        "TIME:00:12");

    doTest("T7",
        "1200006038 MEDICAL CALL CHARLIE RESPONSE 00051 LITCHFIELD RD PLAINVILLE AVE/BIRCH ST  UM1 XXTH AMR1 120330 20:14\r\n\r",
        "ID:1200006038",
        "CALL:MEDICAL CALL CHARLIE RESPONSE",
        "ADDR:51 LITCHFIELD RD",
        "X:PLAINVILLE AVE/BIRCH ST",
        "UNIT:UM1 XXTH AMR1",
        "DATE:03/30/12",
        "TIME:20:14");

  }
  
  @Test
  public void testCantonFire() {

    doTest("T1",
        "1200007908 FIRE - GENERAL ALARM 00021  Dowd AVE Apt #: 15 MAPLE AV/CANTON HOLLOW  FDT1  202  121019 19:13\r\n\r\n",
        "ID:1200007908",
        "CALL:FIRE - GENERAL ALARM",
        "ADDR:21 Dowd AVE",
        "APT:15",
        "X:MAPLE AV/CANTON HOLLOW",
        "UNIT:FDT1 202",
        "DATE:10/19/12",
        "TIME:19:13");

    doTest("T2",
        "1200007788 FIRE - TREE ON/DOWNED WIRES ROUTE 202 /POWDER MILL RD   FDT1  201  121016 13:25\r\n\r\n",
        "ID:1200007788",
        "CALL:FIRE - TREE ON/DOWNED WIRES",
        "ADDR:ROUTE 202 & POWDER MILL RD",
        "UNIT:FDT1 201",
        "DATE:10/16/12",
        "TIME:13:25");

    doTest("T3",
        "1200007774 FIRE - GENERAL ALARM 00098  NORTH MOUNTAIN RD PINE ACRES DR/CHRISTMAS TREE HILL RD  FDT1  121015 19:31\r\n\r\n",
        "ID:1200007774",
        "CALL:FIRE - GENERAL ALARM",
        "ADDR:98 NORTH MOUNTAIN RD",
        "X:PINE ACRES DR/CHRISTMAS TREE HILL RD",
        "UNIT:FDT1",
        "DATE:10/15/12",
        "TIME:19:31");

    doTest("T4",
        "1200007698 FIRE - GENERAL ALARM 00102  Dyer AVE BIRCH KNOLL RD/SPOONWOOD DR  FDT1  121014 06:36\r\n\r\n",
        "ID:1200007698",
        "CALL:FIRE - GENERAL ALARM",
        "ADDR:102 Dyer AVE",
        "X:BIRCH KNOLL RD/SPOONWOOD DR",
        "UNIT:FDT1",
        "DATE:10/14/12",
        "TIME:06:36");

    doTest("T5",
        "1200007634 FIRE - GENERAL ALARM 00021  Dowd AVE Apt #: 34 MAPLE AV/CANTON HOLLOW  FDT1  202  121012 16:20\r\n\r\n",
        "ID:1200007634",
        "CALL:FIRE - GENERAL ALARM",
        "ADDR:21 Dowd AVE",
        "APT:34",
        "X:MAPLE AV/CANTON HOLLOW",
        "UNIT:FDT1 202",
        "DATE:10/12/12",
        "TIME:16:20");

    doTest("T6",
        "1200007576 FIRE - CO ALARM W/ NO ILL EFFECTS 00018  Old Albany TPKE END/FOREST LN  C10  FDT1  202  121011 15:03\r\n\r\n",
        "ID:1200007576",
        "CALL:FIRE - CO ALARM W/ NO ILL EFFECTS",
        "ADDR:18 Old Albany TPKE",
        "X:END/FOREST LN",
        "UNIT:C10 FDT1 202",
        "DATE:10/11/12",
        "TIME:15:03");

    doTest("T7",
        "1200007471 FIRE - VEHICLE ACCIDENT (INJURIES) 00060 Lovely ST (CATI) Prem Map -    202  207  C10  FDT1  121008 17:35\r\n\r\n",
        "ID:1200007471",
        "CALL:FIRE - VEHICLE ACCIDENT (INJURIES)",
        "ADDR:60 Lovely ST",
        "PLACE:(CATI)",
        "UNIT:202 207 C10 FDT1",
        "DATE:10/08/12",
        "TIME:17:35");

    doTest("T8",
        "1200007456 FIRE - SMOKE INVESTIGATION (IN BUILDING) 00050  East Hill RD Apt #: 6C COLONY RD/ALBANY TPKE  FDT1  207  5  121007 21:40\r\n" +
        "\r\n",

        "ID:1200007456",
        "CALL:FIRE - SMOKE INVESTIGATION (IN BUILDING)",
        "ADDR:50 East Hill RD",
        "APT:6C",
        "X:COLONY RD/ALBANY TPKE",
        "UNIT:FDT1 207 5",
        "DATE:10/07/12",
        "TIME:21:40");

    doTest("T9",
        "1200007397 FIRE-MISC 00045 RIVER RD Prem Map -    FDT1  121006 08:35\r\n\r\n",
        "ID:1200007397",
        "CALL:FIRE-MISC",
        "ADDR:45 RIVER RD",
        "UNIT:FDT1",
        "DATE:10/06/12",
        "TIME:08:35");

  }
  
  public static void main(String[] args) {
    new CTHartfordCountyFarmingtonParserTest().generateTests("T1");
  }
}