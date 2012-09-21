package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJBurlingtonCountyDParserTest extends BaseParserTest {
  
  public NJBurlingtonCountyDParserTest() {
    setParser(new NJBurlingtonCountyDParser(), "BURLINGTON COUNTY", "NJ");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(Messenger 911) Call Time: 11:58:04\n" +
        "Incident #: 03272         S\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Quadrant: 3410\n" +
        "Location: 1 STUDENT DR\n" +
        "Located Btwn: WOODLANE RD/DEAD END\n" +
        "Nature: JUV FELL OFF JUNGLE GYM",

        "TIME:11:58:04",
        "ID:03272",
        "CALL:EMS E EMS Call",
        "MAP:3410",
        "ADDR:1 STUDENT DR",
        "X:WOODLANE RD/DEAD END",
        "INFO:JUV FELL OFF JUNGLE GYM");

    doTest("T2",
        "(Messenger 911) Call Time: 17:34:50\n" +
        "Incident #: 03131         S\n" +
        "Incident Type: 16 F Alarms\n" +
        "Quadrant: 1340\n" +
        "Location: 1570 E RT38\n" +
        "Located Btwn: MT HOLLY BP/MAIN ST\n" +
        "Nature: FIRE ALARM//BASEMENT SMOKE DET",

        "TIME:17:34:50",
        "ID:03131",
        "CALL:16 F Alarms",
        "MAP:1340",
        "ADDR:1570 E RT38",
        "MADDR:1570 E RT 38",
        "X:MT HOLLY BP/MAIN ST",
        "INFO:FIRE ALARM//BASEMENT SMOKE DET");

    doTest("T3",
        "(Messenger 911) Call Time: 18:41:40\n" +
        "Incident #: 03272         S\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Quadrant: 2731\n" +
        "Location: 71 FIELDCREST DR\n" +
        "Located Btwn: WILDBERRY DR/SHARPLESS BV\n" +
        "Nature: MALE SLID OFF BED ONTO FLOOR",

        "TIME:18:41:40",
        "ID:03272",
        "CALL:EMS E EMS Call",
        "MAP:2731",
        "ADDR:71 FIELDCREST DR",
        "X:WILDBERRY DR/SHARPLESS BV",
        "INFO:MALE SLID OFF BED ONTO FLOOR");

    doTest("T4",
        "(Messenger 911) Call Time: 12:03:04\n" +
        "Incident #: E509          S\n" +
        "Incident Type: 106 E Breathin\n" +
        "Quadrant: 5030\n" +
        "Location: 7 SAUL PL\n" +
        "Located Btwn: LEVIS DR/DEAD END\n" +
        "Nature: 78 Y/O M//RESP DISTRESS/HENRY ",

        "TIME:12:03:04",
        "ID:E509",
        "CALL:106 E Breathin",
        "MAP:5030",
        "ADDR:7 SAUL PL",
        "X:LEVIS DR/DEAD END",
        "INFO:78 Y/O M//RESP DISTRESS/HENRY");

    doTest("T5",
        "(Messenger 911) Call Time: 13:30:23\n" +
        "Incident #: 03272         S\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Quadrant: 2731\n" +
        "Location: SPRINGSIDE RD\n" +
        "Located Btwn: IKEA DR\n" +
        "Nature: MVA/INJURIES",

        "TIME:13:30:23",
        "ID:03272",
        "CALL:EMS E EMS Call",
        "MAP:2731",
        "ADDR:SPRINGSIDE RD",
        "MADDR:SPRINGSIDE RD & IKEA DR",
        "X:IKEA DR",
        "INFO:MVA/INJURIES");

    doTest("T6",
        "(Messenger 911) Call Time: 19:34:17\n" +
        "Incident #: 03272         S\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Quadrant: 3401\n" +
        "Location: 26 W RAILROAD AV\n" +
        "Located Btwn: LAKE DR/HAND LA\n" +
        "Nature: CARL BUTLER / SCIP TRANSPORT",

        "TIME:19:34:17",
        "ID:03272",
        "CALL:EMS E EMS Call",
        "MAP:3401",
        "ADDR:26 W RAILROAD AV",
        "MADDR:26 W RAILROAD AVE",
        "X:LAKE DR/HAND LA",
        "INFO:CARL BUTLER / SCIP TRANSPORT");

    doTest("T7",
        "(Messenger 911) Call Time: 18:42:15\n" +
        "Incident #: 03272         S\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Quadrant: 2721\n" +
        "Location: BURLINGTON MT HOLLY RD\n" +
        "Located Btwn: WOODLANE RD\n" +
        "Nature: MVA W/INJ",

        "TIME:18:42:15",
        "ID:03272",
        "CALL:EMS E EMS Call",
        "MAP:2721",
        "ADDR:BURLINGTON MT HOLLY RD",
        "MADDR:BURLINGTON MT HOLLY RD & WOODLANE RD",
        "X:WOODLANE RD",
        "INFO:MVA W/INJ");

    doTest("T8",
        "(Messenger 911) Call Time: 07:02:12\n" +
        "Incident #: 03272         S\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Quadrant: 2721\n" +
        "Location: 1012 HOLLY LA\n" +
        "Located Btwn: OGDEN DR/HOWELL DR\n" +
        "Nature: CONFUSED ELDERLY FEMALE",

        "TIME:07:02:12",
        "ID:03272",
        "CALL:EMS E EMS Call",
        "MAP:2721",
        "ADDR:1012 HOLLY LA",
        "MADDR:1012 HOLLY LN",
        "X:OGDEN DR/HOWELL DR",
        "INFO:CONFUSED ELDERLY FEMALE");

    doTest("T9",
        "(Messenger 911) Call Time: 08:57:48\n" +
        "Incident #: 03272         S\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Quadrant: 3401\n" +
        "Location: MILL CREEK RD\n" +
        "Located Btwn: POWELL RD/E MILL CREEK RD\n" +
        "Nature: JUV/ASTHMA ATTACK",

        "TIME:08:57:48",
        "ID:03272",
        "CALL:EMS E EMS Call",
        "MAP:3401",
        "ADDR:MILL CREEK RD",
        "MADDR:MILL CREEK RD & POWELL RD",
        "X:POWELL RD/E MILL CREEK RD",
        "INFO:JUV/ASTHMA ATTACK");

    doTest("T10",
        "(Messenger 911) Call Time: 14:35:08\n" +
        "Incident #: 03161         S\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Quadrant: 1603\n" +
        "Location: 6 GUNNER LA\n" +
        "Located Btwn: GRAMERCY LA/GENESEE LA\n" +
        "Nature: KITCHEN FIRE",

        "TIME:14:35:08",
        "ID:03161",
        "CALL:FIRE F Fire Call",
        "MAP:1603",
        "ADDR:6 GUNNER LA",
        "MADDR:6 GUNNER LN",
        "X:GRAMERCY LA/GENESEE LA",
        "INFO:KITCHEN FIRE");

    doTest("T11",
        "(Messenger 911) Call Time: 16:00:37\n" +
        "Incident #: 03272         S\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Quadrant: 2721\n" +
        "Location: 700 RANCOCAS RD\n" +
        "Located Btwn: MUNICIPAL DR/IRICK RD\n" +
        "Nature: ACT GENERAL FIRE ALARM//WILL N",

        "TIME:16:00:37",
        "ID:03272",
        "CALL:FIRE F Fire Call",
        "MAP:2721",
        "ADDR:700 RANCOCAS RD",
        "X:MUNICIPAL DR/IRICK RD",
        "INFO:ACT GENERAL FIRE ALARM//WILL N");

    doTest("T12",
        "(Messenger 911) Call Time: 20:20:30\n" +
        "Incident #: 03272         S\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Quadrant: 3402\n" +
        "Location: 1 JESS CT\n" +
        "Located Btwn: JOE RD/DEAD END\n" +
        "Nature: FEMALE NOT BREATHING",

        "TIME:20:20:30",
        "ID:03272",
        "CALL:EMS E EMS Call",
        "MAP:3402",
        "ADDR:1 JESS CT",
        "X:JOE RD/DEAD END",
        "INFO:FEMALE NOT BREATHING");

    doTest("T13",
        "(Messenger 911) Call Time: 00:41:36\n" +
        "Incident #: 03272         S\n" +
        "Incident Type: 132 E UnkMedEmrg\n" +
        "Quadrant: 3401\n" +
        "Location: 26 W RAILROAD AV\n" +
        "Located Btwn: LAKE DR/HAND LA\n" +
        "Nature: CHANGE IN MEMTAL STATUS",

        "TIME:00:41:36",
        "ID:03272",
        "CALL:132 E UnkMedEmrg",
        "MAP:3401",
        "ADDR:26 W RAILROAD AV",
        "MADDR:26 W RAILROAD AVE",
        "X:LAKE DR/HAND LA",
        "INFO:CHANGE IN MEMTAL STATUS");
 
  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "(Messenger 911) Call Time: 00:02:10\n" +
        "Incident #: 2012-00000854\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 9 VILLAGE CT\n" +
        "Located Btwn: OAK KNOLL DR/DEAD END\n" +
        "Nature: DIABETIC EMERG\n" +
        "Quadrant: 2516",

        "TIME:00:02:10",
        "ID:2012-00000854",
        "CALL:EMS E EMS Call",
        "X:OAK KNOLL DR/DEAD END",
        "INFO:DIABETIC EMERG",
        "ADDR:9 VILLAGE CT");

    doTest("T2",
        "(Messenger 911) Call Time: 22:20:02\n" +
        "Incident #: 2012-00000378\n" +
        "Incident Type: 44 F Wires\n" +
        "Location: CENTENNIAL AV\n" +
        "Located Btwn: GOTTLIEBS FIELD RD\n" +
        "Nature: TRANSFORMER ARCING\n" +
        "Quadrant: 2521",

        "TIME:22:20:02",
        "ID:2012-00000378",
        "CALL:44 F Wires",
        "X:GOTTLIEBS FIELD RD",
        "INFO:TRANSFORMER ARCING",
        "ADDR:CENTENNIAL AV",
        "MADDR:CENTENNIAL AVE & GOTTLIEBS FIELD RD");

    doTest("T3",
        "(Messenger 911) Call Time: 23:39:10\n" +
        "Incident #: 2012-00000853\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 52 TURTLE CREEK DR\n" +
        "Located Btwn: EAVES MILL RD/EAVES MILL RD\n" +
        "Nature: MALE IN PAIN\n" +
        "Quadrant: 2514",

        "TIME:23:39:10",
        "ID:2012-00000853",
        "CALL:EMS E EMS Call",
        "X:EAVES MILL RD/EAVES MILL RD",
        "INFO:MALE IN PAIN",
        "ADDR:52 TURTLE CREEK DR");

    doTest("T4",
        "(Messenger 911) Call Time: 20:55:02\n" +
        "Incident #: 2012-00000543\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 335 RED LION RD\n" +
        "Located Btwn: NEW FREEDOM RD/HILLIARDS BRIDG\n" +
        "Nature: CALLER REPORTING VEH ON TOP OF\n" +
        "Quadrant: 1712",

        "TIME:20:55:02",
        "ID:2012-00000543",
        "CALL:EMS E EMS Call",
        "X:NEW FREEDOM RD/HILLIARDS BRIDG",
        "INFO:CALLER REPORTING VEH ON TOP OF",
        "ADDR:335 RED LION RD");

    doTest("T5",
        "(Messenger 911) [Update]\n" +
        "Call Time: 20:55:02\n" +
        "Incident #: 2012-00000543\n" +
        "Incident Type: 133 E TrfcEntp\n" +
        "Location: 335 RED LION RD\n" +
        "Located Btwn: NEW FREEDOM RD/HILLIARDS BRIDG\n" +
        "Nature: CALLER REPORTING VEH ON TOP OF\n" +
        "Quadrant: 1712",

        "TIME:20:55:02",
        "ID:2012-00000543",
        "CALL:133 E TrfcEntp",
        "X:NEW FREEDOM RD/HILLIARDS BRIDG",
        "INFO:CALLER REPORTING VEH ON TOP OF",
        "ADDR:335 RED LION RD");

    doTest("T6",
        "(Messenger 911) Call Time: 15:38:21\n" +
        "Incident #: 2012-00000850\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 8 BROOKSIDE DR\n" +
        "Located Btwn: SE LAKESIDE DR/BIRCHWOOD DR\n" +
        "Nature: DIFF BREATHING FOR 4 DAYS\n" +
        "Quadrant: 2512",

        "TIME:15:38:21",
        "ID:2012-00000850",
        "CALL:EMS E EMS Call",
        "X:SE LAKESIDE DR/BIRCHWOOD DR",
        "INFO:DIFF BREATHING FOR 4 DAYS",
        "ADDR:8 BROOKSIDE DR");

    doTest("T7",
        "(Messenger 911) Call Time: 08:12:15\n" +
        "Incident #: 2012-00000161\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Location: 1414 OLD INDIAN MILLS RD\n" +
        "Located Btwn: TUCKERTON RD/RT206\n" +
        "Nature: ELECTRIC FIRE IN HOUSE\n" +
        "Quadrant: 2810",

        "TIME:08:12:15",
        "ID:2012-00000161",
        "CALL:FIRE F Fire Call",
        "X:TUCKERTON RD/RT206",
        "INFO:ELECTRIC FIRE IN HOUSE",
        "ADDR:1414 OLD INDIAN MILLS RD");

    doTest("T8",
        "(Messenger 911) [Update]\n" +
        "Call Time: 08:12:15\n" +
        "Incident #: 2012-00000161\n" +
        "Incident Type: 11 F StrctrFire\n" +
        "Location: 1414 OLD INDIAN MILLS RD\n" +
        "Located Btwn: TUCKERTON RD/RT206\n" +
        "Nature: ELECTRIC FIRE IN HOUSE\n" +
        "Quadrant: 2810",

        "TIME:08:12:15",
        "ID:2012-00000161",
        "CALL:11 F StrctrFire",
        "X:TUCKERTON RD/RT206",
        "INFO:ELECTRIC FIRE IN HOUSE",
        "ADDR:1414 OLD INDIAN MILLS RD");

    doTest("T9",
        "(Messenger 911) Call Time: 08:32:49\n" +
        "Incident #: 2012-00000162\n" +
        "Incident Type: 57 F Cover Sta\n" +
        "Location: 48 WILLOW GROVE RD\n" +
        "Located Btwn: INDIAN MILLS RD/BURNT HOUSE RD\n" +
        "Nature: COVER ASSIGNMENT\n" +
        "Quadrant: 2810",

        "TIME:08:32:49",
        "ID:2012-00000162",
        "CALL:57 F Cover Sta",
        "X:INDIAN MILLS RD/BURNT HOUSE RD",
        "INFO:COVER ASSIGNMENT",
        "ADDR:48 WILLOW GROVE RD");

    doTest("T10",
        "(Messenger 911) Call Time: 11:32:54\n" +
        "Incident #: 2012-00000116\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 31 HIAWATHA TR\n" +
        "Located Btwn: OSWEGO TR/KOSOTO TR\n" +
        "Nature: 89YOA FEM DEHYDRATED/FLU LIKE \n" +
        "Quadrant: 3711",

        "TIME:11:32:54",
        "ID:2012-00000116",
        "CALL:EMS E EMS Call",
        "X:OSWEGO TR/KOSOTO TR",
        "INFO:89YOA FEM DEHYDRATED/FLU LIKE",
        "ADDR:31 HIAWATHA TR");

    doTest("T11",
        "(Messenger 911) Call Time: 18:12:30\n" +
        "Incident #: 2012-00000851\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 53 N MAIN ST\n" +
        "Located Btwn: BRANCH ST/RAILROAD AV\n" +
        "Nature: 1 VEHL INTO TREE IFO RESD\n" +
        "Quadrant: 2513",

        "TIME:18:12:30",
        "ID:2012-00000851",
        "CALL:EMS E EMS Call",
        "X:BRANCH ST/RAILROAD AV",
        "INFO:1 VEHL INTO TREE IFO RESD",
        "ADDR:53 N MAIN ST");

    doTest("T12",
        "(Messenger 911) [Update]\n" +
        "Call Time: 18:12:30\n" +
        "Incident #: 2012-00000851\n" +
        "Incident Type: 129F E Mva/Fire\n" +
        "Location: 53 N MAIN ST\n" +
        "Located Btwn: BRANCH ST/RAILROAD AV\n" +
        "Nature: 1 VEHL INTO TREE IFO RESD\n" +
        "Quadrant: 2513",

        "TIME:18:12:30",
        "ID:2012-00000851",
        "CALL:129F E Mva/Fire",
        "X:BRANCH ST/RAILROAD AV",
        "INFO:1 VEHL INTO TREE IFO RESD",
        "ADDR:53 N MAIN ST");

    doTest("T13",
        "(Messenger 911) Call Time: 09:01:18\n" +
        "Incident #: 2012-00000087\n" +
        "Incident Type: 15 F Rubbish\n" +
        "Location: HIAWATHA TR\n" +
        "Located Btwn: LENAPE TR\n" +
        "Nature: SMELL OF SMOKE IN THE AIR/UNK \n" +
        "Quadrant: 3711",

        "TIME:09:01:18",
        "ID:2012-00000087",
        "CALL:15 F Rubbish",
        "X:LENAPE TR",
        "INFO:SMELL OF SMOKE IN THE AIR/UNK",
        "ADDR:HIAWATHA TR",
        "MADDR:HIAWATHA TR & LENAPE TR");

    doTest("T14",
        "(Messenger 911) Call Time: 21:42:31\n" +
        "Incident #: 2012-00000846\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 3 CORKERY LA\n" +
        "Located Btwn: CROPWELL LA/DEAD END\n" +
        "Nature: HAVING SOME TYPE OF REACTION P\n" +
        "Quadrant: 2514",

        "TIME:21:42:31",
        "ID:2012-00000846",
        "CALL:EMS E EMS Call",
        "X:CROPWELL LA/DEAD END",
        "INFO:HAVING SOME TYPE OF REACTION P",
        "ADDR:3 CORKERY LA",
        "MADDR:3 CORKERY LN");

    doTest("T15",
        "(Messenger 911) [Update]\n" +
        "Call Time: 21:42:31\n" +
        "Incident #: 2012-00000846\n" +
        "Incident Type: 132 E UnkMedEmrg\n" +
        "Location: 3 CORKERY LA\n" +
        "Located Btwn: CROPWELL LA/DEAD END\n" +
        "Nature: HAVING SOME TYPE OF REACTION P\n" +
        "Quadrant: 2514",

        "TIME:21:42:31",
        "ID:2012-00000846",
        "CALL:132 E UnkMedEmrg",
        "X:CROPWELL LA/DEAD END",
        "INFO:HAVING SOME TYPE OF REACTION P",
        "ADDR:3 CORKERY LA",
        "MADDR:3 CORKERY LN");

    doTest("T16",
        "(Messenger 911) Call Time: 04:17:58\n" +
        "Incident #: 2012-00001827\n" +
        "Incident Type: 106 E Breathin\n" +
        "Location: 870 E RT70\n" +
        "Located Btwn: TROTH RD/MEDFORD TWP LINE\n" +
        "Nature: 86F RESP DISTRESS, SYNCOPAL EP\n" +
        "Quadrant: 2223",

        "TIME:04:17:58",
        "ID:2012-00001827",
        "CALL:106 E Breathin",
        "X:TROTH RD/MEDFORD TWP LINE",
        "INFO:86F RESP DISTRESS, SYNCOPAL EP",
        "ADDR:870 E RT70",
        "MADDR:870 E RT 70");

    doTest("T17",
        "(Messenger 911) [Update]\n" +
        "Call Time: 17:01:23\n" +
        "Incident #: 2012-00000373\n" +
        "Incident Type: 15 F Rubbish\n" +
        "Location: 710 HAYNES RUN CL\n" +
        "Located Btwn: RT70/EAYRESTOWN RD\n" +
        "Nature: DUMPSTER FIRE\n" +
        "Quadrant: 2513",

        "TIME:17:01:23",
        "ID:2012-00000373",
        "CALL:15 F Rubbish",
        "X:RT70/EAYRESTOWN RD",
        "INFO:DUMPSTER FIRE",
        "ADDR:710 HAYNES RUN CL",
        "MADDR:710 HAYNES RUN");

    doTest("T18",
        "(Messenger 911) [Update]\n" +
        "Call Time: 15:15:35\n" +
        "Incident #: 2012-00000372\n" +
        "Incident Type: 16 F Alarms\n" +
        "Location: 6 MAGNOLIA CT\n" +
        "Located Btwn: HOPEWELL RD/DEAD END\n" +
        "Nature: DIRENZO RESD GEN FIRE........8\n" +
        "Quadrant: 2520",

        "TIME:15:15:35",
        "ID:2012-00000372",
        "CALL:16 F Alarms",
        "X:HOPEWELL RD/DEAD END",
        "INFO:DIRENZO RESD GEN FIRE........8",
        "ADDR:6 MAGNOLIA CT");

    doTest("T19",
        "(Messenger 911) Call Time: 17:01:23\n" +
        "Incident #: 2012-00000373\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Location: 407 HAYNES RUN CL UNIT B\n" +
        "Located Btwn: RT70/EAYRESTOWN RD\n" +
        "Nature: DUMPSTER FIRE\n" +
        "Quadrant: 2513",

        "TIME:17:01:23",
        "ID:2012-00000373",
        "CALL:FIRE F Fire Call",
        "X:RT70/EAYRESTOWN RD",
        "INFO:DUMPSTER FIRE",
        "APT:B",
        "ADDR:407 HAYNES RUN CL",
        "MADDR:407 HAYNES RUN");   // The CL is confusing things

    doTest("T20",
        "(Messenger 911) Call Time: 15:15:35\n" +
        "Incident #: 2012-00000372\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Location: 6 MAGNOLIA CT\n" +
        "Located Btwn: HOPEWELL RD/DEAD END\n" +
        "Nature: DIRENZO RESD GEN FIRE........8\n" +
        "Quadrant: 2520",

        "TIME:15:15:35",
        "ID:2012-00000372",
        "CALL:FIRE F Fire Call",
        "X:HOPEWELL RD/DEAD END",
        "INFO:DIRENZO RESD GEN FIRE........8",
        "ADDR:6 MAGNOLIA CT");

    doTest("T21",
        "(Messenger 911) Call Time: 10:55:12\n" +
        "Incident #: 2012-00000857\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 155 RT70\n" +
        "Located Btwn: HARTFORD RD/EUGENIA DR\n" +
        "Nature: POSS APPENDICITIS\n" +
        "Quadrant: 2514",

        "TIME:10:55:12",
        "ID:2012-00000857",
        "CALL:EMS E EMS Call",
        "X:HARTFORD RD/EUGENIA DR",
        "INFO:POSS APPENDICITIS",
        "ADDR:155 RT70",
        "MADDR:155 RT 70");

    doTest("T22",
        "(Messenger 911) [Update]\n" +
        "Call Time: 10:55:12\n" +
        "Incident #: 2012-00000857\n" +
        "Incident Type: 101 E AbdmPain\n" +
        "Location: 155 RT70\n" +
        "Located Btwn: HARTFORD RD/EUGENIA DR\n" +
        "Nature: POSS APPENDICITIS\n" +
        "Quadrant: 2514",

        "TIME:10:55:12",
        "ID:2012-00000857",
        "CALL:101 E AbdmPain",
        "X:HARTFORD RD/EUGENIA DR",
        "INFO:POSS APPENDICITIS",
        "ADDR:155 RT70",
        "MADDR:155 RT 70");

    doTest("T23",
        "(Messenger 911) Call Time: 11:32:49\n" +
        "Incident #: 2012-00000858\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 1 MEDFORD LEAS WY\n" +
        "Located Btwn: RT70/NEW FREEDOM RD\n" +
        "Nature: 90YOF// SOB AND CHEST PAINS\n" +
        "Quadrant: 2500",

        "TIME:11:32:49",
        "ID:2012-00000858",
        "CALL:EMS E EMS Call",
        "X:RT70/NEW FREEDOM RD",
        "INFO:90YOF// SOB AND CHEST PAINS",
        "ADDR:1 MEDFORD LEAS WY");

    doTest("T24",
        "(Messenger 911) [Update]\n" +
        "Call Time: 11:32:49\n" +
        "Incident #: 2012-00000858\n" +
        "Incident Type: 110 E ChestPain\n" +
        "Location: 1 MEDFORD LEAS WY\n" +
        "Located Btwn: RT70/NEW FREEDOM RD\n" +
        "Nature: 90YOF// SOB AND CHEST PAINS\n" +
        "Quadrant: 2500",

        "TIME:11:32:49",
        "ID:2012-00000858",
        "CALL:110 E ChestPain",
        "X:RT70/NEW FREEDOM RD",
        "INFO:90YOF// SOB AND CHEST PAINS",
        "ADDR:1 MEDFORD LEAS WY");

    doTest("T25",
        "(Messenger 911) Call Time: 12:16:43\n" +
        "Incident #: 2012-00000859\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 185 TUCKERTON RD FLR 1\n" +
        "Located Btwn: MAINE TR/TAUNTON RD\n" +
        "Nature: 86M VICTIM HEAD INJS\n" +
        "Quadrant: 2525",

        "TIME:12:16:43",
        "ID:2012-00000859",
        "CALL:EMS E EMS Call",
        "X:MAINE TR/TAUNTON RD",
        "INFO:86M VICTIM HEAD INJS",
        "ADDR:185 TUCKERTON RD",
        "APT:FLR 1");

    doTest("T26",
        "(Messenger 911) [Update]\n" +
        "Call Time: 12:16:43\n" +
        "Incident #: 2012-00000859\n" +
        "Incident Type: 117 E Falls\n" +
        "Location: 185 TUCKERTON RD FLR 1\n" +
        "Located Btwn: MAINE TR/TAUNTON RD\n" +
        "Nature: 86YOA MALE/FALL/HEAD LACERATIO\n" +
        "Quadrant: 2525",

        "TIME:12:16:43",
        "ID:2012-00000859",
        "CALL:117 E Falls",
        "X:MAINE TR/TAUNTON RD",
        "INFO:86YOA MALE/FALL/HEAD LACERATIO",
        "ADDR:185 TUCKERTON RD",
        "APT:FLR 1");

    doTest("T27",
        "(Messenger 911) Call Time: 18:02:20\n" +
        "Incident #: 2012-00000860\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 3 GOLDEN CLUB DR\n" +
        "Located Btwn: W CENTENNIAL DR/WATERLILY CT\n" +
        "Nature: 57F INTOX\n" +
        "Quadrant: 2521",

        "TIME:18:02:20",
        "ID:2012-00000860",
        "CALL:EMS E EMS Call",
        "X:W CENTENNIAL DR/WATERLILY CT",
        "INFO:57F INTOX",
        "ADDR:3 GOLDEN CLUB DR");

    doTest("T28",
        "(Messenger 911) Call Time: 00:15:26\n" +
        "Incident #: 2012-00000861\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 1 LINCOLNDALE CT\n" +
        "Located Btwn: WRENTHAM DR/DEAD END\n" +
        "Nature: VERGARA,MAUREEN/609-257-3003/R\n" +
        "Quadrant: 2524",

        "TIME:00:15:26",
        "ID:2012-00000861",
        "CALL:EMS E EMS Call",
        "X:WRENTHAM DR/DEAD END",
        "INFO:VERGARA,MAUREEN/609-257-3003/R",
        "ADDR:1 LINCOLNDALE CT");

    doTest("T29",
        "(Messenger 911) [Update]\n" +
        "Call Time: 00:15:26\n" +
        "Incident #: 2012-00000861\n" +
        "Incident Type: 106 E Breathin\n" +
        "Location: 1 LINCOLNDALE CT\n" +
        "Located Btwn: WRENTHAM DR/DEAD END\n" +
        "Nature: VERGARA,MAUREEN/609-257-3003/R\n" +
        "Quadrant: 2524",

        "TIME:00:15:26",
        "ID:2012-00000861",
        "CALL:106 E Breathin",
        "X:WRENTHAM DR/DEAD END",
        "INFO:VERGARA,MAUREEN/609-257-3003/R",
        "ADDR:1 LINCOLNDALE CT");

    doTest("T30",
        "(Messenger 911) Call Time: 08:11:10\n" +
        "Incident #: 2012-00000862\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 13 CAROL JOY RD\n" +
        "Located Btwn: JACKSON RD/MEADOW WOOD CT\n" +
        "Nature: 77YOF// PARKINSONS PATIENT// I\n" +
        "Quadrant: 2512",

        "TIME:08:11:10",
        "ID:2012-00000862",
        "CALL:EMS E EMS Call",
        "X:JACKSON RD/MEADOW WOOD CT",
        "INFO:77YOF// PARKINSONS PATIENT// I",
        "ADDR:13 CAROL JOY RD");

    doTest("T31",
        "(Messenger 911) Call Time: 11:34:02\n" +
        "Incident #: 2012-00000379\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Location: 6 MUIRFIELD CT\n" +
        "Located Btwn: OLD MARLTON PK/BELLWETHER CT\n" +
        "Nature: CHEMICAL SMELL OUTSIDE\n" +
        "Quadrant: 2513",

        "TIME:11:34:02",
        "ID:2012-00000379",
        "CALL:FIRE F Fire Call",
        "X:OLD MARLTON PK/BELLWETHER CT",
        "INFO:CHEMICAL SMELL OUTSIDE",
        "ADDR:6 MUIRFIELD CT");

    doTest("T32",
        "(Messenger 911) Call Time: 11:52:21\n" +
        "Incident #: 2012-00000863\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 1911 CEDAR DR\n" +
        "Located Btwn: EUGENIA DR/DEAD END\n" +
        "Nature: FEMALE UNABLE TO STAND OR BEAR\n" +
        "Quadrant: 2514",

        "TIME:11:52:21",
        "ID:2012-00000863",
        "CALL:EMS E EMS Call",
        "X:EUGENIA DR/DEAD END",
        "INFO:FEMALE UNABLE TO STAND OR BEAR",
        "ADDR:1911 CEDAR DR");

    doTest("T33",
        "(Messenger 911) Call Time: 13:01:35\n" +
        "Incident #: 2012-00000864\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 208 RT70\n" +
        "Located Btwn: CHARLES ST/HAYNES CREEK LA\n" +
        "Nature: PASSED OUT IS CONSCIOUS AT PRE\n" +
        "Quadrant: 2513",

        "TIME:13:01:35",
        "ID:2012-00000864",
        "CALL:EMS E EMS Call",
        "X:CHARLES ST/HAYNES CREEK LA",
        "INFO:PASSED OUT IS CONSCIOUS AT PRE",
        "ADDR:208 RT70",
        "MADDR:208 RT 70");

    doTest("T34",
        "(Messenger 911) Call Time: 15:51:09\n" +
        "Incident #: 2012-00000865\n" +
        "Incident Type: 106 E Breathin\n" +
        "Location: 120 S MAIN ST\n" +
        "Located Btwn: MILL ST/TRIMBLE ST\n" +
        "Nature: RESP\n" +
        "Quadrant: 2513",

        "TIME:15:51:09",
        "ID:2012-00000865",
        "CALL:106 E Breathin",
        "X:MILL ST/TRIMBLE ST",
        "INFO:RESP",
        "ADDR:120 S MAIN ST");

    doTest("T35",
        "(Messenger 911) Call Time: 07:31:14\n" +
        "Incident #: 2012-00000867\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 808 HAYNES RUN CL\n" +
        "Located Btwn: RT70/EAYRESTOWN RD\n" +
        "Nature: FEMALE SHARP HEAD PAIN SAME HI\n" +
        "Quadrant: 2513",

        "TIME:07:31:14",
        "ID:2012-00000867",
        "CALL:EMS E EMS Call",
        "X:RT70/EAYRESTOWN RD",
        "INFO:FEMALE SHARP HEAD PAIN SAME HI",
        "ADDR:808 HAYNES RUN CL",
        "MADDR:808 HAYNES RUN");

    doTest("T36",
        "(Messenger 911) Call Time: 10:17:01\n" +
        "Incident #: 2012-00000868\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 128 RT70\n" +
        "Located Btwn: EVESBORO MEDFORD RD/HARTFORD R\n" +
        "Nature: SUBJECT UNCON\n" +
        "Quadrant: 2513",

        "TIME:10:17:01",
        "ID:2012-00000868",
        "CALL:EMS E EMS Call",
        "X:EVESBORO MEDFORD RD/HARTFORD R",
        "INFO:SUBJECT UNCON",
        "ADDR:128 RT70",
        "MADDR:128 RT 70");

    doTest("T37",
        "(Messenger 911) Call Time: 11:39:08\n" +
        "Incident #: 2012-00000118\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 136 HIAWATHA TR\n" +
        "Located Btwn: KAWESEA TR/MUDJEKEEWIS TR\n" +
        "Nature: FEM PATIENT DIFF BREATHING\n" +
        "Quadrant: 3711",

        "TIME:11:39:08",
        "ID:2012-00000118",
        "CALL:EMS E EMS Call",
        "X:KAWESEA TR/MUDJEKEEWIS TR",
        "INFO:FEM PATIENT DIFF BREATHING",
        "ADDR:136 HIAWATHA TR");

    doTest("T38",
        "(Messenger 911) Call Time: 14:39:28\n" +
        "Incident #: 2012-00000871\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 24 ALLEN AV\n" +
        "Located Btwn: UNION ST/GILL RD\n" +
        "Nature: CHILD PASSED OUT\n" +
        "Quadrant: 2513",

        "TIME:14:39:28",
        "ID:2012-00000871",
        "CALL:EMS E EMS Call",
        "X:UNION ST/GILL RD",
        "INFO:CHILD PASSED OUT",
        "ADDR:24 ALLEN AV",
        "MADDR:24 ALLEN AVE");

    doTest("T39",
        "(Messenger 911) Call Time: 15:45:05\n" +
        "Incident #: 2012-00000384\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Location: MT HOLLY RD\n" +
        "Located Btwn: RT70/TURTLE CREEK DR\n" +
        "Nature: TRANSFORMER FIRE\n" +
        "Quadrant: 2514",

        "TIME:15:45:05",
        "ID:2012-00000384",
        "CALL:FIRE F Fire Call",
        "X:RT70/TURTLE CREEK DR",
        "INFO:TRANSFORMER FIRE",
        "ADDR:MT HOLLY RD",
        "MADDR:MT HOLLY RD & RT 70");

    doTest("T40",
        "(Messenger 911) Call Time: 15:59:37\n" +
        "Incident #: 2012-00000385\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Location: 109 SKEET RD\n" +
        "Located Btwn: MAPLE ST/HAWKIN RD\n" +
        "Nature: TRANSFORMER BLEW UP\n" +
        "Quadrant: 2510",

        "TIME:15:59:37",
        "ID:2012-00000385",
        "CALL:FIRE F Fire Call",
        "X:MAPLE ST/HAWKIN RD",
        "INFO:TRANSFORMER BLEW UP",
        "ADDR:109 SKEET RD");

    doTest("T41",
        "(Messenger 911) Call Time: 19:12:01\n" +
        "Incident #: 2012-00000386\n" +
        "Incident Type: 16 F Alarms\n" +
        "Location: 196 RT70\n" +
        "Located Btwn: JONES RD/N MAIN ST\n" +
        "Nature: AUDIBLE GFA//654-2546\n" +
        "Quadrant: 2513",

        "TIME:19:12:01",
        "ID:2012-00000386",
        "CALL:16 F Alarms",
        "X:JONES RD/N MAIN ST",
        "INFO:AUDIBLE GFA//654-2546",
        "ADDR:196 RT70",
        "MADDR:196 RT 70");

    doTest("T42",
        "(Messenger 911) Call Time: 20:46:31\n" +
        "Incident #: 2012-00000387\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Location: TUCKERTON RD\n" +
        "Located Btwn: ROBIN HOOD DR\n" +
        "Nature: BLOWN TRANSFORMER\n" +
        "Quadrant: 2524",

        "TIME:20:46:31",
        "ID:2012-00000387",
        "CALL:FIRE F Fire Call",
        "X:ROBIN HOOD DR",
        "INFO:BLOWN TRANSFORMER",
        "ADDR:TUCKERTON RD",
        "MADDR:TUCKERTON RD & ROBIN HOOD DR");

    doTest("T43",
        "(Messenger 911) Call Time: 21:09:55\n" +
        "Incident #: 2012-00000388\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Location: HARTFORD RD\n" +
        "Located Btwn: COOPER TOMLINSON RD\n" +
        "Nature: WURES\n" +
        "Quadrant: 2512",

        "TIME:21:09:55",
        "ID:2012-00000388",
        "CALL:FIRE F Fire Call",
        "X:COOPER TOMLINSON RD",
        "INFO:WURES",
        "ADDR:HARTFORD RD",
        "MADDR:HARTFORD RD & COOPER TOMLINSON RD");

    doTest("T44",
        "(Messenger 911) Call Time: 00:19:19\n" +
        "Incident #: 2012-00000872\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: EAYRESTOWN RD\n" +
        "Located Btwn: RT70\n" +
        "Nature: MVA .. VEHICLE STRUCK POLE  ..\n" +
        "Quadrant: 2514",

        "TIME:00:19:19",
        "ID:2012-00000872",
        "CALL:EMS E EMS Call",
        "X:RT70",
        "INFO:MVA .. VEHICLE STRUCK POLE  ..",
        "ADDR:EAYRESTOWN RD",
        "MADDR:EAYRESTOWN RD & RT 70");

    doTest("T45",
        "(Messenger 911) Call Time: 09:47:08\n" +
        "Incident #: 2012-00000873\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 1 RIDGE CT\n" +
        "Located Btwn: MCKENDIMEN RD/DEAD END\n" +
        "Nature: EMOTIONAL BREAK DOWN\n" +
        "Quadrant: 2510",

        "TIME:09:47:08",
        "ID:2012-00000873",
        "CALL:EMS E EMS Call",
        "X:MCKENDIMEN RD/DEAD END",
        "INFO:EMOTIONAL BREAK DOWN",
        "ADDR:1 RIDGE CT");

    doTest("T46",
        "(Messenger 911) Call Time: 12:24:48\n" +
        "Incident #: 2012-00000874\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 16 SKEET RD\n" +
        "Located Btwn: DIXONTOWN RD/HAWKIN RD\n" +
        "Nature: NUMBNESS IN LEG/ABDOMINAL PAIN\n" +
        "Quadrant: 2510",

        "TIME:12:24:48",
        "ID:2012-00000874",
        "CALL:EMS E EMS Call",
        "X:DIXONTOWN RD/HAWKIN RD",
        "INFO:NUMBNESS IN LEG/ABDOMINAL PAIN",
        "ADDR:16 SKEET RD");

    doTest("T47",
        "(Messenger 911) Call Time: 15:29:54\n" +
        "Incident #: 2012-00000875\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 1 UTAH TR\n" +
        "Located Btwn: CHRISTOPHER MILL RD/BAYAU TR\n" +
        "Nature: ADULT MALE CHOKING\n" +
        "Quadrant: 2512",

        "TIME:15:29:54",
        "ID:2012-00000875",
        "CALL:EMS E EMS Call",
        "X:CHRISTOPHER MILL RD/BAYAU TR",
        "INFO:ADULT MALE CHOKING",
        "ADDR:1 UTAH TR");

    doTest("T48",
        "(Messenger 911) Call Time: 22:49:55\n" +
        "Incident #: 2012-00000877\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 211 BRANDYWINE CT\n" +
        "Located Btwn: WILLIAMSBURG CL/WILLIAMSBURG C\n" +
        "Nature: BROTHER HAS A KNIFE AND IS LOC\n" +
        "Quadrant: 2522",

        "TIME:22:49:55",
        "ID:2012-00000877",
        "CALL:EMS E EMS Call",
        "X:WILLIAMSBURG CL/WILLIAMSBURG C",
        "INFO:BROTHER HAS A KNIFE AND IS LOC",
        "ADDR:211 BRANDYWINE CT");

    doTest("T49",
        "(Messenger 911) Call Time: 07:46:29\n" +
        "Incident #: 2012-00000878\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 56 HAWKIN RD\n" +
        "Located Btwn: SKEET RD/SOUTHAMPTON TWP LINE\n" +
        "Nature: FEMALE HAVING TROUBLE BREATHIN\n" +
        "Quadrant: 2510",

        "TIME:07:46:29",
        "ID:2012-00000878",
        "CALL:EMS E EMS Call",
        "X:SKEET RD/SOUTHAMPTON TWP LINE",
        "INFO:FEMALE HAVING TROUBLE BREATHIN",
        "ADDR:56 HAWKIN RD");

    doTest("T50",
        "(Messenger 911) Call Time: 09:36:02\n" +
        "Incident #: 2012-00000879\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: CHURCH RD\n" +
        "Located Btwn: HARTFORD RD\n" +
        "Nature: CHEST PAINS\n" +
        "Quadrant: 2515",

        "TIME:09:36:02",
        "ID:2012-00000879",
        "CALL:EMS E EMS Call",
        "X:HARTFORD RD",
        "INFO:CHEST PAINS",
        "ADDR:CHURCH RD",
        "MADDR:CHURCH RD & HARTFORD RD");

    doTest("T51",
        "(Messenger 911) Call Time: 13:25:53\n" +
        "Incident #: 2012-00000880\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 180 RT70\n" +
        "Located Btwn: JONES RD/N MAIN ST\n" +
        "Nature: VERTIGO/UNABLE TO STAND\n" +
        "Quadrant: 2513",

        "TIME:13:25:53",
        "ID:2012-00000880",
        "CALL:EMS E EMS Call",
        "X:JONES RD/N MAIN ST",
        "INFO:VERTIGO/UNABLE TO STAND",
        "ADDR:180 RT70",
        "MADDR:180 RT 70");

    doTest("T52",
        "(Messenger 911) Call Time: 15:13:58\n" +
        "Incident #: 2012-00000881\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: TUCKERTON RD\n" +
        "Located Btwn: HEATH RD\n" +
        "Nature: NECK AND BACK PAIN DUE TO MVA\n" +
        "Quadrant: 2520",

        "TIME:15:13:58",
        "ID:2012-00000881",
        "CALL:EMS E EMS Call",
        "X:HEATH RD",
        "INFO:NECK AND BACK PAIN DUE TO MVA",
        "ADDR:TUCKERTON RD",
        "MADDR:TUCKERTON RD & HEATH RD");  // Google can't find - reported

    doTest("T53",
        "(Messenger 911) Call Time: 15:15:36\n" +
        "Incident #: 2012-00000882\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 9 PINECREST DR\n" +
        "Located Btwn: TUCKERTON RD/DEAD END\n" +
        "Nature: 83F/CHEST PAINS\n" +
        "Quadrant: 2516",

        "TIME:15:15:36",
        "ID:2012-00000882",
        "CALL:EMS E EMS Call",
        "X:TUCKERTON RD/DEAD END",
        "INFO:83F/CHEST PAINS",
        "ADDR:9 PINECREST DR");

    doTest("T54",
        "(Messenger 911) Call Time: 16:32:40\n" +
        "Incident #: 2012-00000390\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Location: 34 S MAIN ST\n" +
        "Located Btwn: FRIENDS AV/ALLEN AV\n" +
        "Nature: ACTIVATED FIRE ALARM//NOTHING \n" +
        "Quadrant: 2513",

        "TIME:16:32:40",
        "ID:2012-00000390",
        "CALL:FIRE F Fire Call",
        "X:FRIENDS AV/ALLEN AV",
        "INFO:ACTIVATED FIRE ALARM//NOTHING",
        "ADDR:34 S MAIN ST");

    doTest("T55",
        "(Messenger 911) Call Time: 19:59:36\n" +
        "Incident #: 2012-00000883\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 300 JACKSON RD\n" +
        "Located Btwn: MACCLESFIELD DR/BLUE HERON CT\n" +
        "Nature: FEM CALLER STD HUSBAND TOOK VA\n" +
        "Quadrant: 2523",

        "TIME:19:59:36",
        "ID:2012-00000883",
        "CALL:EMS E EMS Call",
        "X:MACCLESFIELD DR/BLUE HERON CT",
        "INFO:FEM CALLER STD HUSBAND TOOK VA",
        "ADDR:300 JACKSON RD");

    doTest("T56",
        "(Messenger 911) Call Time: 20:13:09\n" +
        "Incident #: 2012-00000392\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Location: 267 HARTFORD RD\n" +
        "Located Btwn: CHURCH RD/MT LAUREL TWP LINE\n" +
        "Nature: ACTIVATED ALARM - GENERAL\n" +
        "Quadrant: 2515",

        "TIME:20:13:09",
        "ID:2012-00000392",
        "CALL:FIRE F Fire Call",
        "X:CHURCH RD/MT LAUREL TWP LINE",
        "INFO:ACTIVATED ALARM - GENERAL",
        "ADDR:267 HARTFORD RD");

    doTest("T57",
        "(Messenger 911) Call Time: 22:50:20\n" +
        "Incident #: 2012-00000884\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 11 ARKANSAS TR\n" +
        "Located Btwn: MISSISSIPPI TR/MAINE TR\n" +
        "Nature: ABDOMINAL PAIN\n" +
        "Quadrant: 2512",

        "TIME:22:50:20",
        "ID:2012-00000884",
        "CALL:EMS E EMS Call",
        "X:MISSISSIPPI TR/MAINE TR",
        "INFO:ABDOMINAL PAIN",
        "ADDR:11 ARKANSAS TR");

    doTest("T58",
        "(Messenger 911) Call Time: 08:46:17\n" +
        "Incident #: 2012-00000886\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 1 MEDFORD LEAS WY\n" +
        "Located Btwn: RT70/NEW FREEDOM RD\n" +
        "Nature: 91 YROM STOMACH PAINS\n" +
        "Quadrant: 2500",

        "TIME:08:46:17",
        "ID:2012-00000886",
        "CALL:EMS E EMS Call",
        "X:RT70/NEW FREEDOM RD",
        "INFO:91 YROM STOMACH PAINS",
        "ADDR:1 MEDFORD LEAS WY");

    doTest("T59",
        "(Messenger 911) Call Time: 16:15:17\n" +
        "Incident #: 2012-00000395\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Location: 36 SW LAKESIDE DR\n" +
        "Located Btwn: JACKSON RD/ELM DR\n" +
        "Nature: FIRE ALARM//TRIGG,HARRY//SMOKE\n" +
        "Quadrant: 2512",

        "TIME:16:15:17",
        "ID:2012-00000395",
        "CALL:FIRE F Fire Call",
        "X:JACKSON RD/ELM DR",
        "INFO:FIRE ALARM//TRIGG,HARRY//SMOKE",
        "ADDR:36 SW LAKESIDE DR");

    doTest("T60",
        "(Messenger 911) Call Time: 08:01:00\n" +
        "Incident #: 2012-00000122\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 160 PAUPUKKEEWIS TR\n" +
        "Located Btwn: ASKORAN TR/MIGAZEE TR\n" +
        "Nature: 78 YROF FALL VICTIM\n" +
        "Quadrant: 3711",

        "TIME:08:01:00",
        "ID:2012-00000122",
        "CALL:EMS E EMS Call",
        "X:ASKORAN TR/MIGAZEE TR",
        "INFO:78 YROF FALL VICTIM",
        "ADDR:160 PAUPUKKEEWIS TR");

    doTest("T61",
        "(Messenger 911) Call Time: 11:04:23\n" +
        "Incident #: 2012-00000390\n" +
        "Incident Type: AOS F Alarm OOS\n" +
        "Location: 25-2 CAROL JOY RD\n" +
        "Located Btwn: /\n" +
        "Nature: FM25",

        "TIME:11:04:23",
        "ID:2012-00000390",
        "CALL:AOS F Alarm OOS",
        "X:/",
        "INFO:FM25",
        "ADDR:25-2 CAROL JOY RD",
        "MADDR:25 CAROL JOY RD");

    doTest("T62",
        "(Messenger 911) Call Time: 11:22:26\n" +
        "Incident #: 2012-00000889\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 23 MEDFORD LEAS WY\n" +
        "Located Btwn: RT70/NEW FREEDOM RD\n" +
        "Nature: 81YRO FM/FALL VICTIM /HEAD INJ\n" +
        "Quadrant: 2500",

        "TIME:11:22:26",
        "ID:2012-00000889",
        "CALL:EMS E EMS Call",
        "X:RT70/NEW FREEDOM RD",
        "INFO:81YRO FM/FALL VICTIM /HEAD INJ",
        "ADDR:23 MEDFORD LEAS WY");

    doTest("T63",
        "(Messenger 911) Call Time: 17:13:19\n" +
        "Incident #: 2012-00000890\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 5 TAMARAC LA\n" +
        "Located Btwn: E WOODTHRUSH TR/HEATH RD\n" +
        "Nature: FM/CHEST PAINS\n" +
        "Quadrant: 2520",

        "TIME:17:13:19",
        "ID:2012-00000890",
        "CALL:EMS E EMS Call",
        "X:E WOODTHRUSH TR/HEATH RD",
        "INFO:FM/CHEST PAINS",
        "ADDR:5 TAMARAC LA",
        "MADDR:5 TAMARAC LN");

    doTest("T64",
        "(Messenger 911) Call Time: 18:56:53\n" +
        "Incident #: 2012-00000891\n" +
        "Incident Type: 106 E Breathin\n" +
        "Location: 205 TUCKERTON RD 1ST FLOOR\n" +
        "Located Btwn: MAINE TR/TAUNTON RD\n" +
        "Nature: SUBJECT W/PNUEMONIA HAVING RES\n" +
        "Quadrant: 2520",

        "TIME:18:56:53",
        "ID:2012-00000891",
        "CALL:106 E Breathin",
        "X:MAINE TR/TAUNTON RD",
        "INFO:SUBJECT W/PNUEMONIA HAVING RES",
        "ADDR:205 TUCKERTON RD 1ST FLOOR");

    doTest("T65",
        "(Messenger 911) Call Time: 18:57:41\n" +
        "Incident #: 2012-00000892\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 7 BRADFORD CT\n" +
        "Located Btwn: BROOKWOOD DR/DEAD END\n" +
        "Nature: 8 YROF FELL DOWN STAIRS/TROUBL\n" +
        "Quadrant: 2521",

        "TIME:18:57:41",
        "ID:2012-00000892",
        "CALL:EMS E EMS Call",
        "X:BROOKWOOD DR/DEAD END",
        "INFO:8 YROF FELL DOWN STAIRS/TROUBL",
        "ADDR:7 BRADFORD CT");

    doTest("T66",
        "(Messenger 911) Call Time: 09:58:42\n" +
        "Incident #: 2012-00000893\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 48 MULBERRY ST\n" +
        "Located Btwn: FILBERT ST/MCCLAIN AV\n" +
        "Nature: FEMALE FALL VIC\n" +
        "Quadrant: 2513",

        "TIME:09:58:42",
        "ID:2012-00000893",
        "CALL:EMS E EMS Call",
        "X:FILBERT ST/MCCLAIN AV",
        "INFO:FEMALE FALL VIC",
        "ADDR:48 MULBERRY ST");

    doTest("T67",
        "(Messenger 911) Call Time: 10:55:24\n" +
        "Incident #: 2012-00000894\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 103 OLD MARLTON PK SUITE 103\n" +
        "Located Btwn: JONES RD/CHESTER AV\n" +
        "Nature: STROKE VICTIM\n" +
        "Quadrant: 2513",

        "TIME:10:55:24",
        "ID:2012-00000894",
        "CALL:EMS E EMS Call",
        "X:JONES RD/CHESTER AV",
        "INFO:STROKE VICTIM",
        "APT:103",
        "ADDR:103 OLD MARLTON PK",
        "MADDR:103 OLD MARLTON PIKE");

    doTest("T68",
        "(Messenger 911) Call Time: 12:41:25\n" +
        "Incident #: 2012-00000895\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 133 CHURCH RD\n" +
        "Located Btwn: HARTFORD RD/ARK RD\n" +
        "Nature: MALE JUVL FELL IN ANIMAL PEN, \n" +
        "Quadrant: 2514",

        "TIME:12:41:25",
        "ID:2012-00000895",
        "CALL:EMS E EMS Call",
        "X:HARTFORD RD/ARK RD",
        "INFO:MALE JUVL FELL IN ANIMAL PEN,",
        "ADDR:133 CHURCH RD");

    doTest("T69",
        "(Messenger 911) Call Time: 14:59:01\n" +
        "Incident #: 2012-00000897\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: RT541 (MT HOLLY RD)\n" +
        "Located Btwn: RT70\n" +
        "Nature: HEAD INJ DUE TO MVA\n" +
        "Quadrant: 2514",

        "TIME:14:59:01",
        "ID:2012-00000897",
        "CALL:EMS E EMS Call",
        "X:RT70",
        "INFO:HEAD INJ DUE TO MVA",
        "ADDR:RT541 (MT HOLLY RD)",
        "MADDR:RT 541 & RT 70");

    doTest("T70",
        "(Messenger 911) Call Time: 23:29:05\n" +
        "Incident #: 2012-00000898\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 3 CEDAR ST\n" +
        "Located Btwn: N MAIN ST/CHERRY ST\n" +
        "Nature: MALE/VOMITING,DEHYDRATED\n" +
        "Quadrant: 2513",

        "TIME:23:29:05",
        "ID:2012-00000898",
        "CALL:EMS E EMS Call",
        "X:N MAIN ST/CHERRY ST",
        "INFO:MALE/VOMITING,DEHYDRATED",
        "ADDR:3 CEDAR ST");

    doTest("T71",
        "(Messenger 911) Call Time: 08:54:53\n" +
        "Incident #: 2012-00000899\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 112 PINE VALLEY DR\n" +
        "Located Btwn: SCHOOL HOUSE DR/DEAD END\n" +
        "Nature: F HER FACE IS DROOPING AND NOT\n" +
        "Quadrant: 2519",

        "TIME:08:54:53",
        "ID:2012-00000899",
        "CALL:EMS E EMS Call",
        "X:SCHOOL HOUSE DR/DEAD END",
        "INFO:F HER FACE IS DROOPING AND NOT",
        "ADDR:112 PINE VALLEY DR");

    doTest("T72",
        "(Messenger 911) Call Time: 10:49:53\n" +
        "Incident #: 2012-00000397\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Location: 179 RT70\n" +
        "Located Btwn: JENNINGS RD/MT HOLLY RD\n" +
        "Nature: 2 MONTH OLD LOCKED IN VEH\n" +
        "Quadrant: 2514",

        "TIME:10:49:53",
        "ID:2012-00000397",
        "CALL:FIRE F Fire Call",
        "X:JENNINGS RD/MT HOLLY RD",
        "INFO:2 MONTH OLD LOCKED IN VEH",
        "ADDR:179 RT70",
        "MADDR:179 RT 70");

    doTest("T73",
        "(Messenger 911) Call Time: 14:08:38\n" +
        "Incident #: 2012-00000398\n" +
        "Incident Type: FIRE F Fire Call\n" +
        "Location: 124 W CENTENNIAL DR\n" +
        "Located Btwn: CENTENNIAL DAM RD/TEABERRY DR\n" +
        "Nature: SILVER RESD SMOKE DETECTOR ACT\n" +
        "Quadrant: 2521",

        "TIME:14:08:38",
        "ID:2012-00000398",
        "CALL:FIRE F Fire Call",
        "X:CENTENNIAL DAM RD/TEABERRY DR",
        "INFO:SILVER RESD SMOKE DETECTOR ACT",
        "ADDR:124 W CENTENNIAL DR");

    doTest("T74",
        "(Messenger 911) Call Time: 10:24:38\n" +
        "Incident #: 2012-00000901\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 240 TAUNTON BV\n" +
        "Located Btwn: CHESTNUT RD/TOMLINSON MILL RD\n" +
        "Nature: MVA/NECK AND BACK PAIN\n" +
        "Quadrant: 2520",

        "TIME:10:24:38",
        "ID:2012-00000901",
        "CALL:EMS E EMS Call",
        "X:CHESTNUT RD/TOMLINSON MILL RD",
        "INFO:MVA/NECK AND BACK PAIN",
        "ADDR:240 TAUNTON BV");

    doTest("T75",
        "(Messenger 911) Call Time: 11:45:13\n" +
        "Incident #: 2012-00000902\n" +
        "Incident Type: EMS E EMS Call\n" +
        "Location: 1 MEDFORD LEAS WY\n" +
        "Located Btwn: RT70/NEW FREEDOM RD\n" +
        "Nature: 77 Y/OF ABDOMINAL PAIN AND HYP\n" +
        "Quadrant: 2500",

        "TIME:11:45:13",
        "ID:2012-00000902",
        "CALL:EMS E EMS Call",
        "X:RT70/NEW FREEDOM RD",
        "INFO:77 Y/OF ABDOMINAL PAIN AND HYP",
        "ADDR:1 MEDFORD LEAS WY");

  }
  
  public static void main(String[] args) {
    new NJBurlingtonCountyDParserTest().generateTests("T1");
  }
}