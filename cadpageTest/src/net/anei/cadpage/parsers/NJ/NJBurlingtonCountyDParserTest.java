package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJBurlingtonCountyDParserTest extends BaseParserTest {
  
  public NJBurlingtonCountyDParserTest() {
    setParser(new NJBurlingtonCountyDParser(), "BURLINGTON COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

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
        "ADDR:1570 E RT38",  // not mapping correctly
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
  
  public static void main(String[] args) {
    new NJBurlingtonCountyDParserTest().generateTests("T1");
  }
}