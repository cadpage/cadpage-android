package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.AL.ALDothanParserTest;

import org.junit.Test;

/*
Dothan AL
Contact: "hassain3738@gmail.com" <hassain3738@gmail.com>
Contact: Tracy Faulkner <ycartf@gmail.com>
Contact: Chad Proctor <xyi9130@gmail.com>
Contact: Rita <7965975rita228@gmail.com>
Contact: Russell Smith <rsmedic1@gmail.com>
Contact: "JP" <jp230rfd@aol.com>
Contact: Ben turner <bald7genie@gmail.com>
Contact: Donald Harbison <donald63harbison@gmail.com>
Sender: Robot.ALERT@dothan.org
 
15:49:38/SC-Service Call Non-Emergency/801 E LAFAYETTE ST/DOTHAN/14523968/ref lines fell at front door, see c404/
16:31:23/SC-Service Call Non-Emergency/401 W INEZ RD/DOTHAN/TANGLEWOOD APARTMENTS/24135869/POWER LINES DOWN AT ENTRANCE, POSS SPARKING, RELAYED BY/
18:35:57/MAID-Mutual Aid Request/5499 MONTGOMERY HWY INTERSECTN/DOTHAN/JOHN D ODOM RD/63981245/ECHO RESCUE --/
18:43:58/S38B-Medical Call-Code III-Emergy/107 RIDGE RD/DOTHAN/95163482/63 YOM HEAD INJURY, S24/
19:03:20/S22CF-Assault-Code II/1486 KINSEY RD/DOTHAN/51943628/ARM HURT, WAS PUSHED/
19:08:26/S38B-Medical Call-Code III-Emergy/1303 SUMMIT ST/DOTHAN/14529368/WEAKNESS, PAIN/
19:17:49/OF-Outdoor Fire-Level 1/1241 KINSEY RD APT186/DOTHAN/JOHNSON 186/51943628/SPARKS SHOOTING FROM POLE/
19:58:39/SC-Service Call Non-Emergency/175 BUFORD LN/DOTHAN/LAKEWOOD FIRE STATION/24318569/A/O -- DO NOT RESPOND/
20:11:48/S8BF-MVC-Code III/2299 JOHN D ODOM RD INTERSECTN/DOTHAN/MURPHY MILL RD/63891245/unk further~~ pr disconnected/
20:15:39/S38B-Medical Call-Code III-Emergy/403 S APPLETREE ST APTJ31/DOTHAN/MARVIN LEWIS J31/14523968/pt low sugar/
20:14:11/S38B-Medical Call-Code III-Emergy/210 N SAINT ANDREWS ST/DOTHAN/CRIMINAL JUSTICE BUILDING/15439268/INMATE -- 31 YOM CP -- HX: 2 HEART SURGERIES/
11:22:21/SC-Service Call Non-Emergency/200 S APPLETREE ST APT3/DOTHAN/14523968/47 YOF, PT FELL,REQUEST LIFT ASSISTANCE/
12:49:37/S8CF-MVC-Code II/3800 ROSS CLARK CIR INTERSECTN/DOTHAN/DENTON RD/39618452/VEHS PULLED INTO P/L OF THE OLD FOOD WORLD P/L/
15:53:10/S8BF-MVC-Code III/2399 S PARK AVE INTERSECTN/DOTHAN/WOODLAND DR/24135869/pt c/o of neck pain...inv s5/
18:04:21/S38A-Medical Call-Code III Crit-Emg/1 SAWGRASS DR INTERSECTN/DOTHAN/WESTBROOK RD/83621945/53 YOF C/O CHEST PAIN, N/V, SHAKING ~ OCCP >>>/
18:09:20/S38B-Medical Call-Code III-Emergy/6007 W MAIN ST STE1/DOTHAN/WIREGRASS SHRINE CLUB/83621945/REF FEMALE PT FALLEN~FROM STANDING POSITION~~BLEEDING FR
18:51:49/S22CF-Assault-Code II/2233 WESTGATE PKY APTL81/DOTHAN/WESTGATE VILLAGE L81/96315842/INV JUVS --- 6 YOM, BLEEDING FROM NOSE/
20:52:18/S38B-Medical Call-Code III-Emergy/4310 MONTGOMERY HWY STE1/DOTHAN/WALMART NS/63981245/26 yom fallen on water / c/o back pain //
21:37:04/S38A-Medical Call-Code III Crit-Emg/2031 THIRD AVE APTK51/DOTHAN/GRADYS WALK K51/41253896/58 YOF C/O HEAD PAIN, RADIATING THRU NECK & LEFT SHOULDER
23:20:14/S22BF-Assault-Code III/1304 CORNELL AVE APTE26/DOTHAN/ROCK CREEK E26/36198425/pr refused/
00:07:44/S38B-Medical Call-Code III-Emergy/102 JOHNSON CIR APT34/DOTHAN/JOHNSON 34/51943628/48 YOF POSS STROKE...FALLEN FROM STANDING POSITION/
00:07:44/S38B-Medical Call-Code III-Emergy/102 JOHNSON CIR APT34/DOTHAN/JOHNSON 34/51943628/48 YOF POSS STROKE...FALLEN FROM STANDING POSITION/
05:04:51/MAID-Mutual Aid Request/5028 REEVES ST INTERSECTN/DOTHAN/CITY LIMITS/95163482/ref s38b 49 yom actively seizing, 1040 w/abbeville rescue/
10:25:33/S8CF-MVC-Code II/1 COLUMBIA HWY INTERSECTN/DOTHAN/E MAIN ST/15439268/
14:52:12/S8BF-MVC-Code III/2410 ROSS CLARK CIR INTERSECTN/DOTHAN/S PARK AVE/24135869/PT JUST RELEASED FROM HOSPITAL, UNK IF INJURIED/
11:15:34/S38B-Medical Call-Code III-Emergy/6726 E HIGHWAY 134/DOTHAN/769381254/elderly male appears disoriented ~~ 10-5 by ozark/dale co/
09:48:02/S38B-Medical Call-Code III-Emergy/101 LOCKWYNN TRC/DOTHAN/68392145/20YOF SWEATING UNK FURTHER RELAYED BY THIRD PARTY/
14:33:21/S38B-Medical Call-Code III-Emergy/342 S SAINT ANDREWS ST APT216/DOTHAN/VAUGHN TOWERS 216/14523968/58YOF  PAIN ALL OVER/
00:30:09/MAID-Mutual Aid Request/17230 E STATE HWY 52 BLK/COLUMBIA/COFDA/F-COFD/
16:52:57/OF-Outdoor Fire-Level 1/100 PEMCO DR/DOTHAN/PEMCO/769381254/BEHIND HANGER 15 GRASS IN FIELD.. TRANSFORMER BLOWN/
15:21:59/S38C-Medical Call-Code II-Non Emgy/115 W ADAMS ST STE2/DOTHAN/MAGISTRATES/DOTHAN/15394628/
12:52:08/S38A-Medical Call-Code III Crit-Emg/25 GOVERNOR DR/DOTHAN/WALLACE COLLEGE/769381254/PREGNANT PT ~~ LIGHT HEADED ~~ WALLACE HALL BLDG 25 UNK AGE/
19:52:43/S8BE-MVC-Code III/915 MURBO RD INTERSECTN/COTTONWOOD/FLETCHER SMITH RD/CWRSB/VEH VS MOTORCYLE/
10:01:23/S38BE-Medical Call-Code III-Emergy/986 EDWIN REYNOLDS RD/LOVETOWN/CWRSC/14 yom poss broken collar bone from bicycle accident/
17:43:59/S38BE-Medical Call-Code III-Emergy/9001 S U S 231/HODGESVILLE/RRSA/68 yom diff breathing/
14:06:05/S8AE-MVC-Code III Critical/15809 S U S 231/MADRID/RACEWAY/RRSB/2 veh .../
11:59:20/S38C-Medical Call-Code II-Non Emgy/3118 E MAIN ST/DOTHAN/AMERICAN INN/45129368/pd on scene ref s50 subj/
15:51:56/S8BF-MVC-Code III/3998 W MAIN ST INTERSECTN/DOTHAN/N SHADY LN/38619245/BLK NISS PATHFINDER 1092 ON 2ND VEH UNK INJ S33/
11:06:53/S38AE-Medical Call-Code III Crit-Em/235 MALVERN RD/REHOBETH/REHOBETH FIRE & RESCUE (NEW)/RRSA/TEST CALL ONLY--DO NOT RESPOND/
12:43:12/S38B-Medical Call-Code III-Emergy/803 CHINOOK ST/DOTHAN/13956428/MALE SUBJ SOB/
10:32:23/S38B-Medical Call-Code III-Emergy/4100 S OATES ST LOTE804/DOTHAN/PECAN POINT E804/24135869/ELDERLY FEMALE CHEST PAIN/

Contact: Active911
Agency name: Dothan Fire Dept
Location: Dothan, AL, United States

19:33:17/S38B-Medical Call-Code III-Emergy/101 HODGESVILLE RD APTA1/DOTHAN/GRANADA A1/42513896/69 YOM -- HYPERGLOCEMIA --/
19:23:25/SF-Structure Fire-Level 3/507 MILL CREEK CIR/DOTHAN/38621945/SMOKE VISIBLE FROM DRYER -- NO FLAMES --/
19:05:04/S38B-Medical Call-Code III-Emergy/101 ARROWHEAD DR/DOTHAN/45123986/74 YOF -- BP 200/100 -- CP/
19:02:38/S38B-Medical Call-Code III-Emergy/210 N SAINT ANDREWS ST/DOTHAN/CRIMINAL JUSTICE BUILDING/15439268/33 YOF INMATE C/P CP/
18:18:51/S38B-Medical Call-Code III-Emergy/1106 N CHERRY ST/DOTHAN/15934682/81 YOM -- DEC LOC -- UNABLE TO STAND -- WEAKNESS --/

*/

public class ALDothanParserTest extends BaseParserTest {
  
  public ALDothanParserTest() {
    setParser(new ALDothanParser(), "DOTHAN", "AL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "15:49:38/SC-Service Call Non-Emergency/801 E LAFAYETTE ST/DOTHAN/14523968/ref lines fell at front door, see c404/",
        "TIME:15:49:38",
        "CALL:SC-Service Call Non-Emergency",
        "ADDR:801 E LAFAYETTE ST",
        "CITY:DOTHAN",
        "ID:14523968",
        "INFO:ref lines fell at front door, see c404");

    doTest("T2",
        "16:31:23/SC-Service Call Non-Emergency/401 W INEZ RD/DOTHAN/TANGLEWOOD APARTMENTS/24135869/POWER LINES DOWN AT ENTRANCE, POSS SPARKING, RELAYED BY/",
        "TIME:16:31:23",
        "CALL:SC-Service Call Non-Emergency",
        "ADDR:401 W INEZ RD",
        "CITY:DOTHAN",
        "PLACE:TANGLEWOOD APARTMENTS",
        "ID:24135869",
        "INFO:POWER LINES DOWN AT ENTRANCE, POSS SPARKING, RELAYED BY");

    doTest("T3",
        "18:35:57/MAID-Mutual Aid Request/5499 MONTGOMERY HWY INTERSECTN/DOTHAN/JOHN D ODOM RD/63981245/ECHO RESCUE --/",
        "TIME:18:35:57",
        "CALL:MAID-Mutual Aid Request",
        "ADDR:5499 MONTGOMERY HWY",
        "CITY:DOTHAN",
        "X:JOHN D ODOM RD",
        "ID:63981245",
        "INFO:ECHO RESCUE --");

    doTest("T4",
        "18:43:58/S38B-Medical Call-Code III-Emergy/107 RIDGE RD/DOTHAN/95163482/63 YOM HEAD INJURY, S24/",
        "TIME:18:43:58",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:107 RIDGE RD",
        "CITY:DOTHAN",
        "ID:95163482",
        "INFO:63 YOM HEAD INJURY, S24");

    doTest("T5",
        "19:03:20/S22CF-Assault-Code II/1486 KINSEY RD/DOTHAN/51943628/ARM HURT, WAS PUSHED/",
        "TIME:19:03:20",
        "CALL:S22CF-Assault-Code II",
        "ADDR:1486 KINSEY RD",
        "CITY:DOTHAN",
        "ID:51943628",
        "INFO:ARM HURT, WAS PUSHED");

    doTest("T6",
        "19:08:26/S38B-Medical Call-Code III-Emergy/1303 SUMMIT ST/DOTHAN/14529368/WEAKNESS, PAIN/",
        "TIME:19:08:26",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:1303 SUMMIT ST",
        "CITY:DOTHAN",
        "ID:14529368",
        "INFO:WEAKNESS, PAIN");

    doTest("T7",
        "19:17:49/OF-Outdoor Fire-Level 1/1241 KINSEY RD APT186/DOTHAN/JOHNSON 186/51943628/SPARKS SHOOTING FROM POLE/",
        "TIME:19:17:49",
        "CALL:OF-Outdoor Fire-Level 1",
        "ADDR:1241 KINSEY RD",
        "APT:186",
        "CITY:DOTHAN",
        "PLACE:JOHNSON 186",
        "ID:51943628",
        "INFO:SPARKS SHOOTING FROM POLE");

    doTest("T8",
        "19:58:39/SC-Service Call Non-Emergency/175 BUFORD LN/DOTHAN/LAKEWOOD FIRE STATION/24318569/A/O -- DO NOT RESPOND/",
        "TIME:19:58:39",
        "CALL:SC-Service Call Non-Emergency",
        "ADDR:175 BUFORD LN",
        "CITY:DOTHAN",
        "PLACE:LAKEWOOD FIRE STATION",
        "ID:24318569",
        "INFO:A / O -- DO NOT RESPOND");

    doTest("T9",
        "20:11:48/S8BF-MVC-Code III/2299 JOHN D ODOM RD INTERSECTN/DOTHAN/MURPHY MILL RD/63891245/unk further~~ pr disconnected/",
        "TIME:20:11:48",
        "CALL:S8BF-MVC-Code III",
        "ADDR:2299 JOHN D ODOM RD",
        "CITY:DOTHAN",
        "X:MURPHY MILL RD",
        "ID:63891245",
        "INFO:unk further~~ pr disconnected");

    doTest("T10",
        "20:15:39/S38B-Medical Call-Code III-Emergy/403 S APPLETREE ST APTJ31/DOTHAN/MARVIN LEWIS J31/14523968/pt low sugar/",
        "TIME:20:15:39",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:403 S APPLETREE ST",
        "APT:J31",
        "CITY:DOTHAN",
        "PLACE:MARVIN LEWIS J31",
        "ID:14523968",
        "INFO:pt low sugar");

    doTest("T11",
        "20:14:11/S38B-Medical Call-Code III-Emergy/210 N SAINT ANDREWS ST/DOTHAN/CRIMINAL JUSTICE BUILDING/15439268/INMATE -- 31 YOM CP -- HX: 2 HEART SURGERIES/",
        "TIME:20:14:11",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:210 N SAINT ANDREWS ST",
        "CITY:DOTHAN",
        "PLACE:CRIMINAL JUSTICE BUILDING",
        "ID:15439268",
        "INFO:INMATE -- 31 YOM CP -- HX: 2 HEART SURGERIES");

    doTest("T12",
        "11:22:21/SC-Service Call Non-Emergency/200 S APPLETREE ST APT3/DOTHAN/14523968/47 YOF, PT FELL,REQUEST LIFT ASSISTANCE/",
        "TIME:11:22:21",
        "CALL:SC-Service Call Non-Emergency",
        "ADDR:200 S APPLETREE ST",
        "APT:3",
        "CITY:DOTHAN",
        "ID:14523968",
        "INFO:47 YOF, PT FELL,REQUEST LIFT ASSISTANCE");

    doTest("T13",
        "12:49:37/S8CF-MVC-Code II/3800 ROSS CLARK CIR INTERSECTN/DOTHAN/DENTON RD/39618452/VEHS PULLED INTO P/L OF THE OLD FOOD WORLD P/L/",
        "TIME:12:49:37",
        "CALL:S8CF-MVC-Code II",
        "ADDR:3800 ROSS CLARK CIR",
        "CITY:DOTHAN",
        "X:DENTON RD",
        "ID:39618452",
        "INFO:VEHS PULLED INTO P / L OF THE OLD FOOD WORLD P / L");

    doTest("T14",
        "15:53:10/S8BF-MVC-Code III/2399 S PARK AVE INTERSECTN/DOTHAN/WOODLAND DR/24135869/pt c/o of neck pain...inv s5/",
        "TIME:15:53:10",
        "CALL:S8BF-MVC-Code III",
        "ADDR:2399 S PARK AVE",
        "CITY:DOTHAN",
        "X:WOODLAND DR",
        "ID:24135869",
        "INFO:pt c / o of neck pain...inv s5");

    doTest("T15",
        "18:04:21/S38A-Medical Call-Code III Crit-Emg/1 SAWGRASS DR INTERSECTN/DOTHAN/WESTBROOK RD/83621945/53 YOF C/O CHEST PAIN, N/V, SHAKING ~ OCCP >>>/",
        "TIME:18:04:21",
        "CALL:S38A-Medical Call-Code III Crit-Emg",
        "ADDR:1 SAWGRASS DR",
        "CITY:DOTHAN",
        "X:WESTBROOK RD",
        "ID:83621945",
        "INFO:53 YOF C / O CHEST PAIN, N / V, SHAKING ~ OCCP >>>");

    doTest("T16",
        "18:09:20/S38B-Medical Call-Code III-Emergy/6007 W MAIN ST STE1/DOTHAN/WIREGRASS SHRINE CLUB/83621945/REF FEMALE PT FALLEN~FROM STANDING POSITION~~BLEEDING FR",
        "TIME:18:09:20",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:6007 W MAIN ST",
        "APT:1",
        "CITY:DOTHAN",
        "PLACE:WIREGRASS SHRINE CLUB",
        "ID:83621945",
        "INFO:REF FEMALE PT FALLEN~FROM STANDING POSITION~~BLEEDING FR");

    doTest("T17",
        "18:51:49/S22CF-Assault-Code II/2233 WESTGATE PKY APTL81/DOTHAN/WESTGATE VILLAGE L81/96315842/INV JUVS --- 6 YOM, BLEEDING FROM NOSE/",
        "TIME:18:51:49",
        "CALL:S22CF-Assault-Code II",
        "ADDR:2233 WESTGATE PKY",
        "MADDR:2233 WESTGATE PKWY",
        "APT:L81",
        "CITY:DOTHAN",
        "PLACE:WESTGATE VILLAGE L81",
        "ID:96315842",
        "INFO:INV JUVS --- 6 YOM, BLEEDING FROM NOSE");

    doTest("T18",
        "20:52:18/S38B-Medical Call-Code III-Emergy/4310 MONTGOMERY HWY STE1/DOTHAN/WALMART NS/63981245/26 yom fallen on water / c/o back pain //",
        "TIME:20:52:18",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:4310 MONTGOMERY HWY",
        "APT:1",
        "CITY:DOTHAN",
        "PLACE:WALMART NS",
        "ID:63981245",
        "INFO:26 yom fallen on water / c / o back pain");

    doTest("T19",
        "21:37:04/S38A-Medical Call-Code III Crit-Emg/2031 THIRD AVE APTK51/DOTHAN/GRADYS WALK K51/41253896/58 YOF C/O HEAD PAIN, RADIATING THRU NECK & LEFT SHOULDER",
        "TIME:21:37:04",
        "CALL:S38A-Medical Call-Code III Crit-Emg",
        "ADDR:2031 THIRD AVE",
        "APT:K51",
        "CITY:DOTHAN",
        "PLACE:GRADYS WALK K51",
        "ID:41253896",
        "INFO:58 YOF C / O HEAD PAIN, RADIATING THRU NECK & LEFT SHOULDER");

    doTest("T20",
        "23:20:14/S22BF-Assault-Code III/1304 CORNELL AVE APTE26/DOTHAN/ROCK CREEK E26/36198425/pr refused/",
        "TIME:23:20:14",
        "CALL:S22BF-Assault-Code III",
        "ADDR:1304 CORNELL AVE",
        "APT:E26",
        "CITY:DOTHAN",
        "PLACE:ROCK CREEK E26",
        "ID:36198425",
        "INFO:pr refused");

    doTest("T21",
        "00:07:44/S38B-Medical Call-Code III-Emergy/102 JOHNSON CIR APT34/DOTHAN/JOHNSON 34/51943628/48 YOF POSS STROKE...FALLEN FROM STANDING POSITION/",
        "TIME:00:07:44",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:102 JOHNSON CIR",
        "APT:34",
        "CITY:DOTHAN",
        "PLACE:JOHNSON 34",
        "ID:51943628",
        "INFO:48 YOF POSS STROKE...FALLEN FROM STANDING POSITION");

    doTest("T22",
        "00:07:44/S38B-Medical Call-Code III-Emergy/102 JOHNSON CIR APT34/DOTHAN/JOHNSON 34/51943628/48 YOF POSS STROKE...FALLEN FROM STANDING POSITION/",
        "TIME:00:07:44",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:102 JOHNSON CIR",
        "APT:34",
        "CITY:DOTHAN",
        "PLACE:JOHNSON 34",
        "ID:51943628",
        "INFO:48 YOF POSS STROKE...FALLEN FROM STANDING POSITION");

    doTest("T23",
        "05:04:51/MAID-Mutual Aid Request/5028 REEVES ST INTERSECTN/DOTHAN/CITY LIMITS/95163482/ref s38b 49 yom actively seizing, 1040 w/abbeville rescue/",
        "TIME:05:04:51",
        "CALL:MAID-Mutual Aid Request",
        "ADDR:5028 REEVES ST",
        "CITY:DOTHAN",
        "PLACE:CITY LIMITS",
        "ID:95163482",
        "INFO:ref s38b 49 yom actively seizing, 1040 w / abbeville rescue");

    doTest("T24",
        "10:25:33/S8CF-MVC-Code II/1 COLUMBIA HWY INTERSECTN/DOTHAN/E MAIN ST/15439268/",
        "TIME:10:25:33",
        "CALL:S8CF-MVC-Code II",
        "ADDR:1 COLUMBIA HWY",
        "CITY:DOTHAN",
        "X:E MAIN ST",
        "ID:15439268");

    doTest("T25",
        "14:52:12/S8BF-MVC-Code III/2410 ROSS CLARK CIR INTERSECTN/DOTHAN/S PARK AVE/24135869/PT JUST RELEASED FROM HOSPITAL, UNK IF INJURIED/",
        "TIME:14:52:12",
        "CALL:S8BF-MVC-Code III",
        "ADDR:2410 ROSS CLARK CIR",
        "CITY:DOTHAN",
        "X:S PARK AVE",
        "ID:24135869",
        "INFO:PT JUST RELEASED FROM HOSPITAL, UNK IF INJURIED");

    doTest("T26",
        "11:15:34/S38B-Medical Call-Code III-Emergy/6726 E HIGHWAY 134/DOTHAN/769381254/elderly male appears disoriented ~~ 10-5 by ozark/dale co/",
        "TIME:11:15:34",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:6726 E HIGHWAY 134",
        "CITY:DOTHAN",
        "ID:769381254",
        "INFO:elderly male appears disoriented ~~ 10-5 by ozark / dale co");

    doTest("T27",
        "09:48:02/S38B-Medical Call-Code III-Emergy/101 LOCKWYNN TRC/DOTHAN/68392145/20YOF SWEATING UNK FURTHER RELAYED BY THIRD PARTY/",
        "TIME:09:48:02",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:101 LOCKWYNN TRC",
        "MADDR:101 LOCKWYNN TRCE",
        "CITY:DOTHAN",
        "ID:68392145",
        "INFO:20YOF SWEATING UNK FURTHER RELAYED BY THIRD PARTY");

    doTest("T28",
        "14:33:21/S38B-Medical Call-Code III-Emergy/342 S SAINT ANDREWS ST APT216/DOTHAN/VAUGHN TOWERS 216/14523968/58YOF  PAIN ALL OVER/",
        "TIME:14:33:21",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:342 S SAINT ANDREWS ST",
        "APT:216",
        "CITY:DOTHAN",
        "PLACE:VAUGHN TOWERS 216",
        "ID:14523968",
        "INFO:58YOF  PAIN ALL OVER");

    doTest("T29",
        "00:30:09/MAID-Mutual Aid Request/17230 E STATE HWY 52 BLK/COLUMBIA/COFDA/F-COFD/",
        "TIME:00:30:09",
        "CALL:MAID-Mutual Aid Request",
        "ADDR:17230 E STATE HWY 52",
        "MADDR:17230 E STATE 52",
        "APT:BLK",
        "CITY:COLUMBIA",
        "PLACE:COFDA/F-COFD");

    doTest("T30",
        "16:52:57/OF-Outdoor Fire-Level 1/100 PEMCO DR/DOTHAN/PEMCO/769381254/BEHIND HANGER 15 GRASS IN FIELD.. TRANSFORMER BLOWN/",
        "TIME:16:52:57",
        "CALL:OF-Outdoor Fire-Level 1",
        "ADDR:100 PEMCO DR",
        "CITY:DOTHAN",
        "PLACE:PEMCO",
        "ID:769381254",
        "INFO:BEHIND HANGER 15 GRASS IN FIELD.. TRANSFORMER BLOWN");

    doTest("T31",
        "15:21:59/S38C-Medical Call-Code II-Non Emgy/115 W ADAMS ST STE2/DOTHAN/MAGISTRATES/DOTHAN/15394628/",
        "TIME:15:21:59",
        "CALL:S38C-Medical Call-Code II-Non Emgy",
        "ADDR:115 W ADAMS ST",
        "APT:2",
        "CITY:DOTHAN",
        "PLACE:MAGISTRATES/DOTHAN",
        "ID:15394628");

    doTest("T32",
        "12:52:08/S38A-Medical Call-Code III Crit-Emg/25 GOVERNOR DR/DOTHAN/WALLACE COLLEGE/769381254/PREGNANT PT ~~ LIGHT HEADED ~~ WALLACE HALL BLDG 25 UNK AGE/",
        "TIME:12:52:08",
        "CALL:S38A-Medical Call-Code III Crit-Emg",
        "ADDR:25 GOVERNOR DR",
        "CITY:DOTHAN",
        "PLACE:WALLACE COLLEGE",
        "ID:769381254",
        "INFO:PREGNANT PT ~~ LIGHT HEADED ~~ WALLACE HALL BLDG 25 UNK AGE");

    doTest("T33",
        "19:52:43/S8BE-MVC-Code III/915 MURBO RD INTERSECTN/COTTONWOOD/FLETCHER SMITH RD/CWRSB/VEH VS MOTORCYLE/",
        "TIME:19:52:43",
        "CALL:S8BE-MVC-Code III",
        "ADDR:915 MURBO RD",
        "CITY:COTTONWOOD",
        "X:FLETCHER SMITH RD",
        "PLACE:CWRSB/VEH VS MOTORCYLE");

    doTest("T34",
        "10:01:23/S38BE-Medical Call-Code III-Emergy/986 EDWIN REYNOLDS RD/LOVETOWN/CWRSC/14 yom poss broken collar bone from bicycle accident/",
        "TIME:10:01:23",
        "CALL:S38BE-Medical Call-Code III-Emergy",
        "ADDR:986 EDWIN REYNOLDS RD",
        "CITY:LOVETOWN",
        "PLACE:CWRSC/14 yom poss broken collar bone from bicycle accident");

    doTest("T35",
        "17:43:59/S38BE-Medical Call-Code III-Emergy/9001 S U S 231/HODGESVILLE/RRSA/68 yom diff breathing/",
        "TIME:17:43:59",
        "CALL:S38BE-Medical Call-Code III-Emergy",
        "ADDR:9001 S US 231",
        "CITY:HODGESVILLE",
        "PLACE:RRSA/68 yom diff breathing");

    doTest("T36",
        "14:06:05/S8AE-MVC-Code III Critical/15809 S U S 231/MADRID/RACEWAY/RRSB/2 veh .../",
        "TIME:14:06:05",
        "CALL:S8AE-MVC-Code III Critical",
        "ADDR:15809 S US 231",
        "CITY:MADRID",
        "PLACE:RACEWAY/RRSB/2 veh ...");

    doTest("T37",
        "11:59:20/S38C-Medical Call-Code II-Non Emgy/3118 E MAIN ST/DOTHAN/AMERICAN INN/45129368/pd on scene ref s50 subj/",
        "TIME:11:59:20",
        "CALL:S38C-Medical Call-Code II-Non Emgy",
        "ADDR:3118 E MAIN ST",
        "CITY:DOTHAN",
        "PLACE:AMERICAN INN",
        "ID:45129368",
        "INFO:pd on scene ref s50 subj");

    doTest("T38",
        "15:51:56/S8BF-MVC-Code III/3998 W MAIN ST INTERSECTN/DOTHAN/N SHADY LN/38619245/BLK NISS PATHFINDER 1092 ON 2ND VEH UNK INJ S33/",
        "TIME:15:51:56",
        "CALL:S8BF-MVC-Code III",
        "ADDR:3998 W MAIN ST",
        "CITY:DOTHAN",
        "X:N SHADY LN",
        "ID:38619245",
        "INFO:BLK NISS PATHFINDER 1092 ON 2ND VEH UNK INJ S33");

    doTest("T39",
        "11:06:53/S38AE-Medical Call-Code III Crit-Em/235 MALVERN RD/REHOBETH/REHOBETH FIRE & RESCUE (NEW)/RRSA/TEST CALL ONLY--DO NOT RESPOND/",
        "TIME:11:06:53",
        "CALL:S38AE-Medical Call-Code III Crit-Em",
        "ADDR:235 MALVERN RD",
        "CITY:REHOBETH",
        "PLACE:REHOBETH FIRE & RESCUE (NEW)/RRSA/TEST CALL ONLY--DO NOT RESPOND");

    doTest("T40",
        "12:43:12/S38B-Medical Call-Code III-Emergy/803 CHINOOK ST/DOTHAN/13956428/MALE SUBJ SOB/",
        "TIME:12:43:12",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:803 CHINOOK ST",
        "CITY:DOTHAN",
        "ID:13956428",
        "INFO:MALE SUBJ SOB");

    doTest("T41",
        "10:32:23/S38B-Medical Call-Code III-Emergy/4100 S OATES ST LOTE804/DOTHAN/PECAN POINT E804/24135869/ELDERLY FEMALE CHEST PAIN/",
        "TIME:10:32:23",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:4100 S OATES ST",
        "APT:LOTE804",
        "CITY:DOTHAN",
        "PLACE:PECAN POINT E804",
        "ID:24135869",
        "INFO:ELDERLY FEMALE CHEST PAIN");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "19:33:17/S38B-Medical Call-Code III-Emergy/101 HODGESVILLE RD APTA1/DOTHAN/GRANADA A1/42513896/69 YOM -- HYPERGLOCEMIA --/",
        "TIME:19:33:17",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:101 HODGESVILLE RD",
        "APT:A1",
        "CITY:DOTHAN",
        "PLACE:GRANADA A1",
        "ID:42513896",
        "INFO:69 YOM -- HYPERGLOCEMIA --");

    doTest("T2",
        "19:23:25/SF-Structure Fire-Level 3/507 MILL CREEK CIR/DOTHAN/38621945/SMOKE VISIBLE FROM DRYER -- NO FLAMES --/",
        "TIME:19:23:25",
        "CALL:SF-Structure Fire-Level 3",
        "ADDR:507 MILL CREEK CIR",
        "CITY:DOTHAN",
        "ID:38621945",
        "INFO:SMOKE VISIBLE FROM DRYER -- NO FLAMES --");

    doTest("T3",
        "19:05:04/S38B-Medical Call-Code III-Emergy/101 ARROWHEAD DR/DOTHAN/45123986/74 YOF -- BP 200/100 -- CP/",
        "TIME:19:05:04",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:101 ARROWHEAD DR",
        "CITY:DOTHAN",
        "ID:45123986",
        "INFO:74 YOF -- BP 200 / 100 -- CP");

    doTest("T4",
        "19:02:38/S38B-Medical Call-Code III-Emergy/210 N SAINT ANDREWS ST/DOTHAN/CRIMINAL JUSTICE BUILDING/15439268/33 YOF INMATE C/P CP/",
        "TIME:19:02:38",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:210 N SAINT ANDREWS ST",
        "CITY:DOTHAN",
        "PLACE:CRIMINAL JUSTICE BUILDING",
        "ID:15439268",
        "INFO:33 YOF INMATE C / P CP");

    doTest("T5",
        "18:18:51/S38B-Medical Call-Code III-Emergy/1106 N CHERRY ST/DOTHAN/15934682/81 YOM -- DEC LOC -- UNABLE TO STAND -- WEAKNESS --/",
        "TIME:18:18:51",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:1106 N CHERRY ST",
        "CITY:DOTHAN",
        "ID:15934682",
        "INFO:81 YOM -- DEC LOC -- UNABLE TO STAND -- WEAKNESS --");
   
  }
  
  public static void main(String[] args) {
    new ALDothanParserTest().generateTests("T1");
  }
}