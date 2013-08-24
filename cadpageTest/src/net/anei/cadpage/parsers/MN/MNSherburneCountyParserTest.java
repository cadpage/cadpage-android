package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Sherburne County, MN
Contact: Active911
Agency name: Elk River Fire Department
Location: Elk River, MN, United States
Sender: pro.prophoenix@co.sherburne.mn.us

(Phoenix Notification) 2012000364 {11/18/2012 12:38:02}\r\nFIRGR    - 9604 Fire-Grass{1}\r\n9046 Ohland Ave NE;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} 3234 3    grass fire   getting close to house  \r\n
(Phoenix Notification) 2012000363 {11/16/2012 15:02:06}\r\nACCPI    - 9420 Accident - MV - Personal Injury{1}\r\n19100BLK Us Highway 169 NW;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} 3240-4  3 veh crash nb lanes/unk inj, parties exiting vehs \r\n
(Phoenix Notification) 2012000362 {11/15/2012 15:15:51}\r\nFIROT    - 9600 Fire-Other{1}\r\n9201 Quaday Ave NE,A;ER\r\nUnits:\r\n    EREN1   ERCH2   ERCH1   \r\nComments:\r\n 3232 1 pty rptng a dumpster fire at abv loc  \r\n
(Phoenix Notification) 2012000361 {11/12/2012 12:33:35}\r\nALMFR    - 9609 Alarm - Fire{1}\r\n4405 Sterling Dr;BL\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} 3243-4  blue house next to abv address, sale sign in yard, house vacant \r\n
(Phoenix Notification) 2012000360 {11/10/2012 22:35:32}\r\nALMFR    - 9609 Alarm - Fire{1}\r\n9474 Naber Ave NE;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} 3238-4   zone 167 and abu\r\nGENERAL FIRE \r\n
(Phoenix Notification) 2012000358 {11/10/2012 22:24:06}\r\nFIRAS    - 9840 Fire Assist{2}\r\n9200 Quaday Ave NE;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} 3239-1    stuck elevator \r\n
(Phoenix Notification) 2012000357 {11/10/2012 11:47:00}\r\nFIROT    - 9600 Fire-Other{1}\r\n11554 193rd Ave NW;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} 3232 3 smell of burning wires inside store  \r\n
(Phoenix Notification) 2012000356 {11/09/2012 22:50:39}\r\nGAS      - 9611 Gas Leak/Smell{2}\r\n714 Auburn Pl NW;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} \r\n
(Phoenix Notification) 2012000355 {11/09/2012 11:24:03}\r\nALMFR    - 9609 Alarm - Fire{1}\r\n9952 Us Highway 10 NW;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} 3233/2    fire alrm cov zone 9 panel room door contacts usa 888 872 3640 \r\n
(Phoenix Notification) 2012000127 {11/09/2012 09:02:43}\r\nALMFR    - 9609 Alarm - Fire{1}\r\n1111 School St NW,BLDG;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} 3233/2  fire alrms going off at abv \r\n
(Phoenix Notification) 2012000126 {11/09/2012 08:11:52}\r\nFIROT    - 9600 Fire-Other{1}\r\n10653 172nd Ave NW,BLDG;ER\r\nUnits:\r\n    \r\nComments:\r\n Inspection of locked exterior door. \r\n
(Phoenix Notification) 2012000125 {11/08/2012 14:58:33}\r\nACCPI    - 9420 Accident - MV - Personal Injury{1}\r\nState Highway 101 NE/River Rd NE;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} 3234 3   dump truck rolled over nb lane \r\n
(Phoenix Notification) 2012000124 {11/04/2012 21:12:09}\r\nALMFR    - 9609 Alarm - Fire{1}\r\n11875 193rd Ln NW;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} 3242/2 main level smoke detector.  \r\n
(Phoenix Notification) 2012000123 {11/03/2012 14:17:50}\r\nFIRGR    - 9604 Fire-Grass{1}\r\n1920 Main St NW;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} \r\n
(Phoenix Notification) 2012000122 {11/03/2012 10:35:43}\r\nFIRCO    - 9602 Fire-Commercial{1}\r\n19600 Evans St NW;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} Large amount of smoke coming from trailer parked on property\r\nrpted by passerby on hwy 169 \r\n
(Phoenix Notification) 2012000121 {11/02/2012 18:54:21}\r\nGAS      - 9611 Gas Leak/Smell{1}\r\n900 School St NW;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} 3240-4  smell of natural gas near front door \r\n
(Phoenix Notification) 2012000120 {11/02/2012 16:04:18}\r\nALMCO    - 9612 Alarm - Carbon Monoxide{1}\r\n480 Fern St,BLDG;BL\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} \r\n
(Phoenix Notification) 2012000119 {10/31/2012 14:28:22}\r\nFIRCO    - 9602 Fire-Commercial{1}\r\n17560 Tyler St NW;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} Dust collector in the shop on fire \r\n
(Phoenix Notification) 2012000118 {10/29/2012 19:00:09}\r\nALMFR    - 9609 Alarm - Fire{1}\r\n900 School St NW;ER\r\nUnits:\r\n    \r\nComments:\r\n Station Dispatched : {ERF} 3238-3   FIRE ALARM   GENERAL\r\nJOHNSON CONTROLS 800 753 4524   REF # 11004777 \r\n

*/

public class MNSherburneCountyParserTest extends BaseParserTest {
  
  public MNSherburneCountyParserTest() {
    setParser(new MNSherburneCountyParser(), "SHERBURNE COUNTY", "MN");
  }
  
  @Test
  public void testElkRiverFire() {

    doTest("T1",
        "(Phoenix Notification) 2012000364 {11/18/2012 12:38:02}\r\n" +
        "FIRGR    - 9604 Fire-Grass{1}\r\n" +
        "9046 Ohland Ave NE;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} 3234 3    grass fire   getting close to house  \r\n",

        "ID:2012000364",
        "DATE:11/18/2012",
        "TIME:12:38:02",
        "CODE:FIRGR",
        "CALL:9604 Fire-Grass",
        "PRI:1",
        "ADDR:9046 Ohland Ave NE",
        "UNIT:ERF",
        "MAP:3234-3",
        "INFO:grass fire   getting close to house");

    doTest("T2",
        "(Phoenix Notification) 2012000363 {11/16/2012 15:02:06}\r\n" +
        "ACCPI    - 9420 Accident - MV - Personal Injury{1}\r\n" +
        "19100BLK Us Highway 169 NW;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} 3240-4  3 veh crash nb lanes/unk inj, parties exiting vehs \r\n",

        "ID:2012000363",
        "DATE:11/16/2012",
        "TIME:15:02:06",
        "CODE:ACCPI",
        "CALL:9420 Accident - MV - Personal Injury",
        "PRI:1",
        "ADDR:19100BLK Us Highway 169 NW",
        "MADDR:19100 US 169 NW",
        "UNIT:ERF",
        "MAP:3240-4",
        "INFO:3 veh crash nb lanes/unk inj, parties exiting vehs");

    doTest("T3",
        "(Phoenix Notification) 2012000362 {11/15/2012 15:15:51}\r\n" +
        "FIROT    - 9600 Fire-Other{1}\r\n" +
        "9201 Quaday Ave NE,A;ER\r\n" +
        "Units:\r\n" +
        "    EREN1   ERCH2   ERCH1   \r\n" +
        "Comments:\r\n" +
        " 3232 1 pty rptng a dumpster fire at abv loc  \r\n",

        "ID:2012000362",
        "DATE:11/15/2012",
        "TIME:15:15:51",
        "CODE:FIROT",
        "CALL:9600 Fire-Other",
        "PRI:1",
        "ADDR:9201 Quaday Ave NE",
        "APT:A",
        "UNIT:EREN1 ERCH2 ERCH1",
        "MAP:3232-1",
        "INFO:pty rptng a dumpster fire at abv loc");

    doTest("T4",
        "(Phoenix Notification) 2012000361 {11/12/2012 12:33:35}\r\n" +
        "ALMFR    - 9609 Alarm - Fire{1}\r\n" +
        "4405 Sterling Dr;BL\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} 3243-4  blue house next to abv address, sale sign in yard, house vacant \r\n",

        "ID:2012000361",
        "DATE:11/12/2012",
        "TIME:12:33:35",
        "CODE:ALMFR",
        "CALL:9609 Alarm - Fire",
        "PRI:1",
        "ADDR:4405 Sterling Dr",
        "UNIT:ERF",
        "MAP:3243-4",
        "INFO:blue house next to abv address, sale sign in yard, house vacant");

    doTest("T5",
        "(Phoenix Notification) 2012000360 {11/10/2012 22:35:32}\r\n" +
        "ALMFR    - 9609 Alarm - Fire{1}\r\n" +
        "9474 Naber Ave NE;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} 3238-4   zone 167 and abu\r\n" +
        "GENERAL FIRE \r\n",

        "ID:2012000360",
        "DATE:11/10/2012",
        "TIME:22:35:32",
        "CODE:ALMFR",
        "CALL:9609 Alarm - Fire",
        "PRI:1",
        "ADDR:9474 Naber Ave NE",
        "UNIT:ERF",
        "MAP:3238-4",
        "INFO:zone 167 and abu\nGENERAL FIRE");

    doTest("T6",
        "(Phoenix Notification) 2012000358 {11/10/2012 22:24:06}\r\n" +
        "FIRAS    - 9840 Fire Assist{2}\r\n" +
        "9200 Quaday Ave NE;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} 3239-1    stuck elevator \r\n",

        "ID:2012000358",
        "DATE:11/10/2012",
        "TIME:22:24:06",
        "CODE:FIRAS",
        "CALL:9840 Fire Assist",
        "PRI:2",
        "ADDR:9200 Quaday Ave NE",
        "UNIT:ERF",
        "MAP:3239-1",
        "INFO:stuck elevator");

    doTest("T7",
        "(Phoenix Notification) 2012000357 {11/10/2012 11:47:00}\r\n" +
        "FIROT    - 9600 Fire-Other{1}\r\n" +
        "11554 193rd Ave NW;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} 3232 3 smell of burning wires inside store  \r\n",

        "ID:2012000357",
        "DATE:11/10/2012",
        "TIME:11:47:00",
        "CODE:FIROT",
        "CALL:9600 Fire-Other",
        "PRI:1",
        "ADDR:11554 193rd Ave NW",
        "UNIT:ERF",
        "MAP:3232-3",
        "INFO:smell of burning wires inside store");

    doTest("T8",
        "(Phoenix Notification) 2012000356 {11/09/2012 22:50:39}\r\n" +
        "GAS      - 9611 Gas Leak/Smell{2}\r\n" +
        "714 Auburn Pl NW;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} \r\n",

        "ID:2012000356",
        "DATE:11/09/2012",
        "TIME:22:50:39",
        "CODE:GAS",
        "CALL:9611 Gas Leak/Smell",
        "PRI:2",
        "ADDR:714 Auburn Pl NW",
        "UNIT:ERF");

    doTest("T9",
        "(Phoenix Notification) 2012000355 {11/09/2012 11:24:03}\r\n" +
        "ALMFR    - 9609 Alarm - Fire{1}\r\n" +
        "9952 Us Highway 10 NW;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} 3233/2    fire alrm cov zone 9 panel room door contacts usa 888 872 3640 \r\n",

        "ID:2012000355",
        "DATE:11/09/2012",
        "TIME:11:24:03",
        "CODE:ALMFR",
        "CALL:9609 Alarm - Fire",
        "PRI:1",
        "ADDR:9952 Us Highway 10 NW",
        "MADDR:9952 US 10 NW",
        "UNIT:ERF",
        "MAP:3233/2",
        "INFO:fire alrm cov zone 9 panel room door contacts usa 888 872 3640");

    doTest("T10",
        "(Phoenix Notification) 2012000127 {11/09/2012 09:02:43}\r\n" +
        "ALMFR    - 9609 Alarm - Fire{1}\r\n" +
        "1111 School St NW,BLDG;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} 3233/2  fire alrms going off at abv \r\n",

        "ID:2012000127",
        "DATE:11/09/2012",
        "TIME:09:02:43",
        "CODE:ALMFR",
        "CALL:9609 Alarm - Fire",
        "PRI:1",
        "ADDR:1111 School St NW",
        "APT:BLDG",
        "UNIT:ERF",
        "MAP:3233/2",
        "INFO:fire alrms going off at abv");

    doTest("T11",
        "(Phoenix Notification) 2012000126 {11/09/2012 08:11:52}\r\n" +
        "FIROT    - 9600 Fire-Other{1}\r\n" +
        "10653 172nd Ave NW,BLDG;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Inspection of locked exterior door. \r\n",

        "ID:2012000126",
        "DATE:11/09/2012",
        "TIME:08:11:52",
        "CODE:FIROT",
        "CALL:9600 Fire-Other",
        "PRI:1",
        "ADDR:10653 172nd Ave NW",
        "APT:BLDG",
        "INFO:Inspection of locked exterior door.");

    doTest("T12",
        "(Phoenix Notification) 2012000125 {11/08/2012 14:58:33}\r\n" +
        "ACCPI    - 9420 Accident - MV - Personal Injury{1}\r\n" +
        "State Highway 101 NE/River Rd NE;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} 3234 3   dump truck rolled over nb lane \r\n",

        "ID:2012000125",
        "DATE:11/08/2012",
        "TIME:14:58:33",
        "CODE:ACCPI",
        "CALL:9420 Accident - MV - Personal Injury",
        "PRI:1",
        "ADDR:State Highway 101 NE & River Rd NE",
        "MADDR:STATE 101 NE & River Rd NE",   // Not mapping
        "UNIT:ERF",
        "MAP:3234-3",
        "INFO:dump truck rolled over nb lane");

    doTest("T13",
        "(Phoenix Notification) 2012000124 {11/04/2012 21:12:09}\r\n" +
        "ALMFR    - 9609 Alarm - Fire{1}\r\n" +
        "11875 193rd Ln NW;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} 3242/2 main level smoke detector.  \r\n",

        "ID:2012000124",
        "DATE:11/04/2012",
        "TIME:21:12:09",
        "CODE:ALMFR",
        "CALL:9609 Alarm - Fire",
        "PRI:1",
        "ADDR:11875 193rd Ln NW",
        "UNIT:ERF",
        "MAP:3242/2",
        "INFO:main level smoke detector.");

    doTest("T14",
        "(Phoenix Notification) 2012000123 {11/03/2012 14:17:50}\r\n" +
        "FIRGR    - 9604 Fire-Grass{1}\r\n" +
        "1920 Main St NW;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} \r\n",

        "ID:2012000123",
        "DATE:11/03/2012",
        "TIME:14:17:50",
        "CODE:FIRGR",
        "CALL:9604 Fire-Grass",
        "PRI:1",
        "ADDR:1920 Main St NW",
        "UNIT:ERF");

    doTest("T15",
        "(Phoenix Notification) 2012000122 {11/03/2012 10:35:43}\r\n" +
        "FIRCO    - 9602 Fire-Commercial{1}\r\n" +
        "19600 Evans St NW;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} Large amount of smoke coming from trailer parked on property\r\n" +
        "rpted by passerby on hwy 169 \r\n",

        "ID:2012000122",
        "DATE:11/03/2012",
        "TIME:10:35:43",
        "CODE:FIRCO",
        "CALL:9602 Fire-Commercial",
        "PRI:1",
        "ADDR:19600 Evans St NW",
        "UNIT:ERF",
        "INFO:Large amount of smoke coming from trailer parked on property\nrpted by passerby on hwy 169");

    doTest("T16",
        "(Phoenix Notification) 2012000121 {11/02/2012 18:54:21}\r\n" +
        "GAS      - 9611 Gas Leak/Smell{1}\r\n" +
        "900 School St NW;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} 3240-4  smell of natural gas near front door \r\n",

        "ID:2012000121",
        "DATE:11/02/2012",
        "TIME:18:54:21",
        "CODE:GAS",
        "CALL:9611 Gas Leak/Smell",
        "PRI:1",
        "ADDR:900 School St NW",
        "UNIT:ERF",
        "MAP:3240-4",
        "INFO:smell of natural gas near front door");

    doTest("T17",
        "(Phoenix Notification) 2012000120 {11/02/2012 16:04:18}\r\n" +
        "ALMCO    - 9612 Alarm - Carbon Monoxide{1}\r\n" +
        "480 Fern St,BLDG;BL\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} \r\n",

        "ID:2012000120",
        "DATE:11/02/2012",
        "TIME:16:04:18",
        "CODE:ALMCO",
        "CALL:9612 Alarm - Carbon Monoxide",
        "PRI:1",
        "ADDR:480 Fern St",
        "APT:BLDG",
        "UNIT:ERF");

    doTest("T18",
        "(Phoenix Notification) 2012000119 {10/31/2012 14:28:22}\r\n" +
        "FIRCO    - 9602 Fire-Commercial{1}\r\n" +
        "17560 Tyler St NW;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} Dust collector in the shop on fire \r\n",

        "ID:2012000119",
        "DATE:10/31/2012",
        "TIME:14:28:22",
        "CODE:FIRCO",
        "CALL:9602 Fire-Commercial",
        "PRI:1",
        "ADDR:17560 Tyler St NW",
        "UNIT:ERF",
        "INFO:Dust collector in the shop on fire");

    doTest("T19",
        "(Phoenix Notification) 2012000118 {10/29/2012 19:00:09}\r\n" +
        "ALMFR    - 9609 Alarm - Fire{1}\r\n" +
        "900 School St NW;ER\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Station Dispatched : {ERF} 3238-3   FIRE ALARM   GENERAL\r\n" +
        "JOHNSON CONTROLS 800 753 4524   REF # 11004777 \r\n",

        "ID:2012000118",
        "DATE:10/29/2012",
        "TIME:19:00:09",
        "CODE:ALMFR",
        "CALL:9609 Alarm - Fire",
        "PRI:1",
        "ADDR:900 School St NW",
        "UNIT:ERF",
        "MAP:3238-3",
        "INFO:FIRE ALARM   GENERAL\nJOHNSON CONTROLS 800 753 4524   REF # 11004777");

  }
  
  public static void main(String[] args) {
    new MNSherburneCountyParserTest().generateTests("T1");
  }
}