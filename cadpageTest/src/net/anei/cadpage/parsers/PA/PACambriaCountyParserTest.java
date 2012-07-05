package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PACambriaCountyParserTest;

import org.junit.Test;

public class PACambriaCountyParserTest extends BaseParserTest {
  
  public PACambriaCountyParserTest() {
    setParser(new PACambriaCountyParser(), "CAMBRIA COUNTY", "PA");
  }

  @Test
  public void testBadMsg() {
    doBadTest("Aww how bad");
  }
 
  
  @Test
  public void testParser1() {

    doTest("T1",
        "[29] 11 Time: 15:02:29 Nature: 17A01G-Alpha FALL Location: 216 MAIN ST-JO | Sta 35",
        "TIME:15:02:29",
        "CALL:17A01G-Alpha FALL",
        "ADDR:216 MAIN ST",
        "CITY:JOHNSTOWN",
        "UNIT:Sta 35");

    doTest("T2",
        "[29] 11 Time: 11:54:47 Nature: 29B01-Bravo VEH ACC WITH INJURIES Location: 110 PLAZA DR-LY | Sta 30, Sta 23, Sta 35",
        "TIME:11:54:47",
        "CALL:29B01-Bravo VEH ACC WITH INJURIES",
        "ADDR:110 PLAZA DR",
        "CITY:LOWER YODER TWP",
        "UNIT:Sta 30, Sta 23, Sta 35");

    doTest("T3",
        "[29] 11 Time: 08:03:01 Nature: 10C02-Charlie CHEST PAIN Location: 315 LOCUST ST-JO | Sta 35 ",
        "TIME:08:03:01",
        "CALL:10C02-Charlie CHEST PAIN",
        "ADDR:315 LOCUST ST",
        "CITY:JOHNSTOWN",
        "UNIT:Sta 35");

    doTest("T4",
        "[29] 11 Time: 06:45:29 Nature: 17B03G-Bravo FALL Location: WALNUT ST-JO/MAIN ST-JO | Sta 35",
        "TIME:06:45:29",
        "CALL:17B03G-Bravo FALL",
        "ADDR:WALNUT ST & MAIN ST",
        "CITY:JOHNSTOWN",
        "UNIT:Sta 35");

    doTest("T5",
        "[28] 11 Time: 21:39:31 Nature: 06D03A-Delta BREATHING PROBLEMS Location: 205 CHANDLER AVE-JO | Sta 35, Sta 21, Sta 36",
        "TIME:21:39:31",
        "CALL:06D03A-Delta BREATHING PROBLEMS",
        "ADDR:205 CHANDLER AVE",
        "CITY:JOHNSTOWN",
        "UNIT:Sta 35, Sta 21, Sta 36");
 
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "Date: 06/02/11\nTime: 20:47:52\nNature: 10C01-Charlie CHEST PAIN\nLocation: 1518 W 2ND ST-CR\n| Sta 75",
        "DATE:06/02/11",
        "TIME:20:47:52",
        "CALL:10C01-Charlie CHEST PAIN",
        "ADDR:1518 W 2ND ST",
        "CITY:CRESSON TWP",
        "UNIT:Sta 75");

    doTest("T2",
        "Date: 06/04/11\nTime: 11:03:04\nNature: 06D02-Delta  BREATHING PROBLEMS\nLocation: 908 SHORT AVE-CR\n| Sta 75",
        "DATE:06/04/11",
        "TIME:11:03:04",
        "CALL:06D02-Delta  BREATHING PROBLEMS",
        "ADDR:908 SHORT AVE",
        "CITY:CRESSON TWP",
        "UNIT:Sta 75");

    doTest("T3",
        "Date: 06/04/11\nTime: 17:24:03\nNature: STB-STAND BY\nLocation: 721 MAIN ST-PORB\n| Sta 73",
        "DATE:06/04/11",
        "TIME:17:24:03",
        "CALL:STB-STAND BY",
        "ADDR:721 MAIN ST",
        "CITY:PORTAGE",
        "UNIT:Sta 73");

    doTest("T4",
        "Date: 06/05/11\nTime: 18:00:42\nNature: 52C04G-Charlie FIRE ALARM\nLocation: 111 ASHCROFT AVE-CB\n| Sta 70",
        "DATE:06/05/11",
        "TIME:18:00:42",
        "CALL:52C04G-Charlie FIRE ALARM",
        "ADDR:111 ASHCROFT AVE",
        "CITY:CRESSON",
        "UNIT:Sta 70");

    doTest("T5",
        "Date: 06/13/11\nTime: 15:53:48\nNature: 02D02-Delta  ALLERGIC REACTION\nLocation: 1237 ST AUGUSTINE RD-CF\n| Sta 60, Sta 67",
        "TIME:15:53:48",
        "DATE:06/13/11",
        "CALL:02D02-Delta  ALLERGIC REACTION",
        "ADDR:1237 ST AUGUSTINE RD",
        "CITY:CLEARFIELD TWP",
        "UNIT:Sta 60, Sta 67");

  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "FRM:Cambria 9-1-1\nMSG:Date: 11/07/11\nTime: 18:02:55\nNature: 10C01-Charlie CHEST PAIN\nLocation: 349 VO TECH DR-RI\n|",
        "DATE:11/07/11",
        "TIME:18:02:55",
        "CALL:10C01-Charlie CHEST PAIN",
        "ADDR:349 VO TECH DR",
        "CITY:RICHLAND TWP");

    doTest("T2",
        "Date: 01/24/12\nTime: 18:02:50\nNature: 69D03-Delta STRUCTURE FIRE\nLocation: 7458 ADMIRAL PEARY HWY-CB\nSta 70, Sta 71, Sta 72, Sta 75",
        "DATE:01/24/12",
        "TIME:18:02:50",
        "CALL:69D03-Delta STRUCTURE FIRE",
        "ADDR:7458 ADMIRAL PEARY HWY",
        "CITY:CRESSON",
        "UNIT:Sta 70, Sta 71, Sta 72, Sta 75");

  }
  
  @Test
  public void testParser4() {

    doTest("T1",
        "DATE: 06/13/12\r\n" +
        " | 13:21:53\r\n" +
        " | 25B06V-BRAVO PSYCHIATRIC PROBLEM\r\n" +
        " | 1109 DEVEAUX ST-WC\r\n" +
        " | NUMBER 1 RD-WC FRAZIER ST-WC\r\n" +
        " | Sta 64",

        "DATE:06/13/12",
        "TIME:13:21:53",
        "CALL:25B06V-BRAVO PSYCHIATRIC PROBLEM",
        "ADDR:1109 DEVEAUX ST",
        "CITY:WEST CARROLL TWP",
        "X:NUMBER 1 RD & FRAZIER ST",
        "UNIT:Sta 64");

    doTest("T2",
        "DATE: 06/13/12\r\n | 13:08:24\r\n | 17A01G-ALPHA FALL\r\n | 180 WOOD AVE-CM\r\n | BELAIR ST-CM EDSEL ST\r\n | Sta 48",
        "DATE:06/13/12",
        "TIME:13:08:24",
        "CALL:17A01G-ALPHA FALL",
        "ADDR:180 WOOD AVE",
        "CITY:CAMBRIA TWP",
        "X:BELAIR ST & EDSEL ST",
        "UNIT:Sta 48");

    doTest("T3",
        "DATE: 06/12/12\r\n | 20:34:38\r\n | SS-EMS STATION STILL\r\n | 100 N CAROLINE ST-EB\r\n | E HIGH ST-EB\r\n | Sta 48",
        "DATE:06/12/12",
        "TIME:20:34:38",
        "CALL:SS-EMS STATION STILL",
        "ADDR:100 N CAROLINE ST",
        "CITY:EBENSBURG",
        "X:E HIGH ST",
        "UNIT:Sta 48");

    doTest("T4",
        "DATE: 06/12/12\r\n | 18:55:55\r\n | 26A01-ALPHA  SICK PERSON\r\n | 700 N CENTER ST-EB\r\n | BOLTON ST-EB W HIGHLAND AVE-EB\r\n | Sta 48",
        "DATE:06/12/12",
        "TIME:18:55:55",
        "CALL:26A01-ALPHA  SICK PERSON",
        "ADDR:700 N CENTER ST",
        "CITY:EBENSBURG",
        "X:BOLTON ST & W HIGHLAND AVE",
        "UNIT:Sta 48");

    doTest("T5",
        "DATE: 06/12/12\r\n | 18:55:55\r\n | 26A01-ALPHA  SICK PERSON\r\n | 700 N CENTER ST-EB\r\n | BOLTON ST-EB W HIGHLAND AVE-EB\r\n | Sta 48",
        "DATE:06/12/12",
        "TIME:18:55:55",
        "CALL:26A01-ALPHA  SICK PERSON",
        "ADDR:700 N CENTER ST",
        "CITY:EBENSBURG",
        "X:BOLTON ST & W HIGHLAND AVE",
        "UNIT:Sta 48");

    doTest("T6",
        "DATE: 06/12/12\r\n | 18:35:37\r\n | BLS-BLS EMS CALL\r\n | 121 UNION ST-CM\r\n | DEAD END TRIPOLI RD-CM\r\n | Sta 40, Sta 48",
        "DATE:06/12/12",
        "TIME:18:35:37",
        "CALL:BLS-BLS EMS CALL",
        "ADDR:121 UNION ST",
        "CITY:CAMBRIA TWP",
        "X:DEAD END TRIPOLI RD",
        "UNIT:Sta 40, Sta 48");

    doTest("T7",
        "DATE: 06/12/12\r\n | 11:14:25\r\n | 10C01-CHARLIE CHEST PAIN\r\n | 1100 W HIGH ST-CM\r\n | MYERS ST-CM NEW GERMANY RD-CM\r\n | Sta 48",
        "DATE:06/12/12",
        "TIME:11:14:25",
        "CALL:10C01-CHARLIE CHEST PAIN",
        "ADDR:1100 W HIGH ST",
        "CITY:CAMBRIA TWP",
        "X:MYERS ST & NEW GERMANY RD",
        "UNIT:Sta 48");

    doTest("T8",
        "DATE: 06/12/12\r\n" +
        " | 09:56:39\r\n" +
        " | 52C03S-CHARLIE SMOKE DETECTOR ALARM\r\n" +
        " | 140 E CARROLL ST-CL\r\n" +
        " | BEDE ST-CL N CHURCH ST-CL\r\n" +
        " | Sta 5",

        "DATE:06/12/12",
        "TIME:09:56:39",
        "CALL:52C03S-CHARLIE SMOKE DETECTOR ALARM",
        "ADDR:140 E CARROLL ST",
        "CITY:CARROLLTOWN",
        "X:BEDE ST & N CHURCH ST",
        "UNIT:Sta 5");

    doTest("T9",
        "DATE: 06/11/12\r\n | 23:56:26\r\n | 28C03L-CHARLIE STROKE\r\n | 429 MANOR DR-CM\r\n | WINDY VALLEY RD-CM\r\n | Sta 48",
        "DATE:06/11/12",
        "TIME:23:56:26",
        "CALL:28C03L-CHARLIE STROKE",
        "ADDR:429 MANOR DR",
        "CITY:CAMBRIA TWP",
        "X:WINDY VALLEY RD",
        "UNIT:Sta 48");

    doTest("T10",
        "DATE: 06/13/12\r\n | 15:52:42\r\n | 18C05-CHARLIE  HEADACHE\r\n | 236 JAMESWAY RD-CM\r\n | WALMART DR-CM ADMIRAL PEARY HWY-CM\r\n | Sta 48",
        "DATE:06/13/12",
        "TIME:15:52:42",
        "CALL:18C05-CHARLIE  HEADACHE",
        "ADDR:236 JAMESWAY RD",
        "CITY:CAMBRIA TWP",
        "X:WALMART DR & ADMIRAL PEARY HWY",
        "UNIT:Sta 48");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[CAD incident] Date: 07/02/12\n" +
        "Time: 16:18:01\n" +
        "Nature: STB-STAND BY\n" +
        "Add: 237 LINCOLN ST-JO\n" +
        "Cross: WALNUT ST-JO MORRELL PL-JO DOWNTOW\n" +
        "9",

        "DATE:07/02/12",
        "TIME:16:18:01",
        "CALL:STB-STAND BY",
        "ADDR:237 LINCOLN ST", 
        "CITY:JOHNSTOWN",
        "X:WALNUT ST & MORRELL PL & DOWNTOW",
        "UNIT:9");

    doTest("T2",
        "[CAD incident] Date: 07/02/12\n" +
        "Time: 17:05:40\n" +
        "Nature: 01A01-Alpha  ABDOMINAL PAIN\n" +
        "Add: 207 OTTAWA ST-RI\n" +
        "Cross: ARBUTUS AVE-RI WESLEY DR-RI ZONE 2\n" +
        "9",

        "DATE:07/02/12",
        "TIME:17:05:40",
        "CALL:01A01-Alpha  ABDOMINAL PAIN",
        "ADDR:207 OTTAWA ST",
        "CITY:RICHLAND TWP",
        "X:ARBUTUS AVE & WESLEY DR & ZONE 2",
        "UNIT:9");

    doTest("T3",
        "[CAD incident] Date: 07/02/12\n" +
        "Time: 18:46:33\n" +
        "Nature: 26A10-Alpha  SICK PERSON\n" +
        "Add: 428 BELLA VISTA DR-RI\n" +
        "Cross: GREENWICH RD-RI PAWNEE RD-RI ZONE\n" +
        "9",

        "DATE:07/02/12",
        "TIME:18:46:33",
        "CALL:26A10-Alpha  SICK PERSON",
        "ADDR:428 BELLA VISTA DR",
        "CITY:RICHLAND TWP",
        "X:GREENWICH RD & PAWNEE RD & ZONE",
        "UNIT:9");

    doTest("T4",
        "[CAD incident] Date: 07/02/12\n" +
        "Time: 20:34:15\n" +
        "Nature: 17D03-Delta FALL\n" +
        "Add: 3324 ELTON RD-RI\n" +
        "Cross: GIBBY LN-RI HOOVER ST-RI ZONE 1\n" +
        "9",

        "DATE:07/02/12",
        "TIME:20:34:15",
        "CALL:17D03-Delta FALL",
        "ADDR:3324 ELTON RD",
        "CITY:RICHLAND TWP",
        "X:GIBBY LN & HOOVER ST & ZONE 1",
        "UNIT:9");

    doTest("T5",
        "[CAD incident] Date: 07/02/12\nTime: 20:46:25\nNature: ALS-ALS EMS CALL\nAdd: 663 BUNKERHILL RD CENTRAL CITY\nCross: \n9",
        "DATE:07/02/12",
        "TIME:20:46:25",
        "CALL:ALS-ALS EMS CALL",
        "ADDR:663 BUNKERHILL RD",
        "CITY:CENTRAL CITY",
        "UNIT:9");

    doTest("T6",
        "[CAD incident] Date: 07/02/12\n" +
        "Time: 20:49:13\n" +
        "Nature: 09E01-Echo CARDIAC ARREST\n" +
        "Add: 349 VO TECH DR-RI\n" +
        "Cross: ELTON RD-RI SCHOOLHOUSE RD-RI ZONE\n" +
        "9, M381, 3",

        "DATE:07/02/12",
        "TIME:20:49:13",
        "CALL:09E01-Echo CARDIAC ARREST",
        "ADDR:349 VO TECH DR",
        "CITY:RICHLAND TWP",
        "X:ELTON RD & SCHOOLHOUSE RD & ZONE",
        "UNIT:9, M381, 3");

    doTest("T7",
        "[CAD incident] Date: 07/03/12\nTime: 01:15:05\nNature: NET-NON EMERGENCY TRANSFER\nAdd: LOCAL TRANSFER - A91\nCross: \n9",
        "DATE:07/03/12",
        "TIME:01:15:05",
        "CALL:NET-NON EMERGENCY TRANSFER",
        "ADDR:LOCAL TRANSFER",
        "CITY:A91",
        "UNIT:9");

    doTest("T8",
        "[CAD incident] Date: 07/03/12\n" +
        "Time: 05:18:10\n" +
        "Nature: 30B01-Bravo TRAUMATIC INJURY\n" +
        "Add: 429 INDUSTRIAL PARK RD-RI\n" +
        "Cross: OAKRIDGE DR-RI ALLENBILL DR-RI ZON\n" +
        "9",

        "DATE:07/03/12",
        "TIME:05:18:10",
        "CALL:30B01-Bravo TRAUMATIC INJURY",
        "ADDR:429 INDUSTRIAL PARK RD",
        "CITY:RICHLAND TWP",
        "X:OAKRIDGE DR & ALLENBILL DR & ZON",
        "UNIT:9");

    doTest("T9",
        "[CAD incident] Date: 07/03/12\n" +
        "Time: 06:57:07\n" +
        "Nature: 26D01-Delta  SICK PERSON\n" +
        "Add: 134 KINZEY ST-GE\n" +
        "Cross: ALFRED ST-GE BENTWOOD AVE-GE\n" +
        "9",

        "DATE:07/03/12",
        "TIME:06:57:07",
        "CALL:26D01-Delta  SICK PERSON",
        "ADDR:134 KINZEY ST",
        "CITY:GEISTOWN",
        "X:ALFRED ST & BENTWOOD AVE",
        "UNIT:9");

    doTest("T10",
        "[CAD incident] Date: 07/03/12\n" +
        "Time: 07:16:15\n" +
        "Nature: 10D01-Delta CHEST PAIN\n" +
        "Add: 202 HUFF ST-ADAM\n" +
        "Cross: THOMPSON AVE-ADAM ROBERTS AVE-ADAM\n" +
        "Sta 78, 9",

        "DATE:07/03/12",
        "TIME:07:16:15",
        "CALL:10D01-Delta CHEST PAIN",
        "ADDR:202 HUFF ST",
        "CITY:ADAMS TWP",
        "X:THOMPSON AVE-ADAM ROBERTS AVE-ADAM",
        "UNIT:Sta 78, 9");

    doTest("T11",
        "[CAD incident] Date: 07/03/12\nTime: 12:44:20\nNature: NET-NON EMERGENCY TRANSFER\nAdd: LOCAL TRANSFER - A93\nCross: \n9",
        "DATE:07/03/12",
        "TIME:12:44:20",
        "CALL:NET-NON EMERGENCY TRANSFER",
        "ADDR:LOCAL TRANSFER",
        "CITY:A93",
        "UNIT:9");

    doTest("T12",
        "[CAD incident] Date: 07/03/12\n" +
        "Time: 13:09:09\n" +
        "Nature: 25A01-Alpha  PSYCHIATRIC PROBLEM\n" +
        "Add: 207 STONEHEDGE CT-RI\n" +
        "Cross: WALTERS AVE-RI WALTERS AVE-RI ZONE\n" +
        "9",

        "DATE:07/03/12",
        "TIME:13:09:09",
        "CALL:25A01-Alpha  PSYCHIATRIC PROBLEM",
        "ADDR:207 STONEHEDGE CT",
        "CITY:RICHLAND TWP",
        "X:WALTERS AVE & WALTERS AVE & ZONE",
        "UNIT:9");

    doTest("T13",
        "[CAD incident] Date: 07/03/12\n" +
        "Time: 15:20:30\n" +
        "Nature: 25A02-Alpha PSYCHIATRIC PROBLEM\n" +
        "Add: 1425 SCALP AVE-RI\n" +
        "Cross: EISENHOWER BLVD-RI DWIGHT DR-RI ZO\n" +
        "9",

        "DATE:07/03/12",
        "TIME:15:20:30",
        "CALL:25A02-Alpha PSYCHIATRIC PROBLEM",
        "ADDR:1425 SCALP AVE",
        "CITY:RICHLAND TWP",
        "X:EISENHOWER BLVD & DWIGHT DR & ZO",
        "UNIT:9");

    doTest("T14",
        "[CAD incident] Date: 07/03/12\n" +
        "Time: 15:25:52\n" +
        "Nature: 12D04-Delta SEIZURES\n" +
        "Add: 101 CLAIR ST-LO\n" +
        "Cross: TERRY ST-LO OHIO ST-LO LORAIN BORO\n" +
        "9, M381",

        "DATE:07/03/12",
        "TIME:15:25:52",
        "CALL:12D04-Delta SEIZURES",
        "ADDR:101 CLAIR ST",
        "CITY:LORAIN",
        "X:TERRY ST & OHIO ST & LORAIN BORO",
        "UNIT:9, M381");

    doTest("T15",
        "[CAD incident] Date: 07/03/12\n" +
        "Time: 18:40:18\n" +
        "Nature: 26A10-Alpha  SICK PERSON\n" +
        "Add: 349 VO TECH DR-RI\n" +
        "Cross: ELTON RD-RI SCHOOLHOUSE RD-RI ZONE\n" +
        "9",

        "DATE:07/03/12",
        "TIME:18:40:18",
        "CALL:26A10-Alpha  SICK PERSON",
        "ADDR:349 VO TECH DR",
        "CITY:RICHLAND TWP",
        "X:ELTON RD & SCHOOLHOUSE RD & ZONE",
        "UNIT:9");

    doTest("T16",
        "[CAD incident] Date: 07/03/12\n" +
        "Time: 21:52:49\n" +
        "Nature: SS-EMS STATION STILL\n" +
        "Add: 500 GALLERIA DR-RI\n" +
        "Cross: RT219 NORTH ON RAMP-RI OAKRIDGE DR\n" +
        "9",

        "DATE:07/03/12",
        "TIME:21:52:49",
        "CALL:SS-EMS STATION STILL",
        "ADDR:500 GALLERIA DR",
        "CITY:RICHLAND TWP",
        "X:RT219 NORTH ON RAMP & OAKRIDGE DR",
        "UNIT:9");

    doTest("T17",
        "[CAD incident] Date: 07/03/12\n" +
        "Time: 22:00:08\n" +
        "Nature: 28C10G-Charlie STROKE\n" +
        "Add: 122 CARWYN DR-RI\n" +
        "Cross: WORK DR-RI SCALP AVE-RI ZONE 2\n" +
        "9",

        "DATE:07/03/12",
        "TIME:22:00:08",
        "CALL:28C10G-Charlie STROKE",
        "ADDR:122 CARWYN DR",
        "CITY:RICHLAND TWP",
        "X:WORK DR & SCALP AVE & ZONE 2",
        "UNIT:9");
   
  }
  
  
  public static void main(String[] args) {
    new PACambriaCountyParserTest().generateTests("T1");
  }
}
