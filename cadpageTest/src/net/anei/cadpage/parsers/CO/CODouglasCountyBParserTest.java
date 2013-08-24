package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Douglas County, CO
Contact: (Q) D George-Nichols <D_George-Nichols@q.com>
Sender: Group_Page_Notification@usamobility.net

w/West Douglas: 01/18 16:54 AJ-16-C 491 S 67 Hwy SPRUCEWOOD INN MVA - INJURIES WDF3,M39,E39,BC34
w/West Douglas: 01/18 12:39 AF-21-B 7279 Piute Dr SICK PARTY WDF3,M46,E39,BC34
w/West Douglas: 12/30 09:41 AG-22-B 4062 N 67 Hwy STANDBY IN THE AREA WDF3,M39,E39,BC34
w/West Douglas: 09/07 15:49 AF-27-B 1395 Waverton Ranch Rd ALARM - RESIDENTIAL FIRE WDF1
w/West Douglas: 12/19 11:45 AD-22-C 6625 Lambert Ranch Crossing ALARM - COMMERCIAL FIRE WDF2
w/West Douglas: 12/03 10:52 AE-21-D 7250 Rainbow Creek Rd BREATHING PROBLEMS WDF3,M39,E39,BC34
w/West Douglas: 07/05 15:09 AD-24-D 5068 Plum Ave JOHNSON & SONS CONSTRUCTION RESCUE - ANIMAL WDF3
From: Group_Page_Notification@usamobility.net w/West Douglas:01/28 18:28 AE-24-A 4909 Woodley Ave LOCK OUT EMERGENT WDF2,M39,E39,BC34 Received: Mon Jan 28, 6:28 pm
From: Group_Page_Notification@usamobility.net w/West Douglas: 01/18 16:54 AJ-16-C 491 S 67 Hwy SPRUCEWOOD INN MVA – INJURIES WDF3,M39,E39,BC34 Received Fri Jan 18, 4:54 pm
From: Group_Page_Notification@usamobility.net w/West Douglas: 01/15 21:11 AJ-14-B 128 Hill Dr ALARM – CO NO SICK PARTIES WDF3  Received Tue Jan 15, 9:11 pm
From: Group_Page_Notification@usamobility.net w/West Douglas: 01/18 12:39 AF-21-B 7270 Piute Dr SICK PARTY WDF3,M46,E39,BC34 Received Fri Jan 1, 12:40 pm
From: Group_Page_Notification@usamobility.net w/West Douglas: 01/13 20:20 AF-22-C 3522 Winnebago Dr SICK PARTY WDF2,E39,M39,BC34 Received: Sun Jan 13, 8:21 pm
From: Group_Page_Notification@usamobility.net w/West Douglas: 12/03 15:00 AH-21-B Oak Valley Rd INVESTIGATION – SMOKE OUTSIDE WDF3 Received: Mon Dec 3, 3:01 pm
From: Group_Page_Notification@usamobility.net w/West Douglas: 12/03 10:52 AE-21-D 7250 Rainbow Creek Rd BREATHING PROBLEMS WDF3,M39,E39,BC34 Received: Mon Dec 3, 1052 am
From: Group_Page_Notification@usamobility.net w/West Douglas: 08/01 15:29 AF-23-A N 67 Hwy / Rainbow Creek Rd CHEST PAIN WDF1, M39, E39 Received: Mon Dec 3, 1052 am
From: Group_Page_Notification@usamobility.net w/West Douglas: 08/18 12:26 AH-17-D N 67 Hwy / N Rampart Range Rd MVA – INJURIES WDF3, M39, E39 Received: Mon Dec 3, 1052 am

 */

public class CODouglasCountyBParserTest extends BaseParserTest {
  
  public CODouglasCountyBParserTest() {
    setParser(new CODouglasCountyBParser(), "DOUGLAS COUNTY", "CO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "w/West Douglas: 01/18 16:54 AJ-16-C 491 S 67 Hwy SPRUCEWOOD INN MVA - INJURIES WDF3,M39,E39,BC34",
        "SRC:w/West Douglas",
        "DATE:01/18",
        "TIME:16:54",
        "CODE:AJ-16-C",
        "ADDR:491 S 67 Hwy",
        "MADDR:491 S Hwy 67",
        "CALL:SPRUCEWOOD INN MVA - INJURIES",
        "UNIT:WDF3,M39,E39,BC34");

    doTest("T2",
        "w/West Douglas: 01/18 12:39 AF-21-B 7279 Piute Dr SICK PARTY WDF3,M46,E39,BC34",
        "SRC:w/West Douglas",
        "DATE:01/18",
        "TIME:12:39",
        "CODE:AF-21-B",
        "ADDR:7279 Piute Dr",
        "CALL:SICK PARTY",
        "UNIT:WDF3,M46,E39,BC34");

    doTest("T3",
        "w/West Douglas: 12/30 09:41 AG-22-B 4062 N 67 Hwy STANDBY IN THE AREA WDF3,M39,E39,BC34",
        "SRC:w/West Douglas",
        "DATE:12/30",
        "TIME:09:41",
        "CODE:AG-22-B",
        "ADDR:4062 N 67 Hwy",
        "MADDR:4062 N Hwy 67",
        "CALL:STANDBY IN THE AREA",
        "UNIT:WDF3,M39,E39,BC34");

    doTest("T4",
        "w/West Douglas: 09/07 15:49 AF-27-B 1395 Waverton Ranch Rd ALARM - RESIDENTIAL FIRE WDF1",
        "SRC:w/West Douglas",
        "DATE:09/07",
        "TIME:15:49",
        "CODE:AF-27-B",
        "ADDR:1395 Waverton Ranch Rd",
        "CALL:ALARM - RESIDENTIAL FIRE",
        "UNIT:WDF1");

    doTest("T5",
        "w/West Douglas: 12/19 11:45 AD-22-C 6625 Lambert Ranch Crossing ALARM - COMMERCIAL FIRE WDF2",
        "SRC:w/West Douglas",
        "DATE:12/19",
        "TIME:11:45",
        "CODE:AD-22-C",
        "ADDR:6625 Lambert Ranch Crossing",  // Google fins Lambert Ranch Trail
        "CALL:ALARM - COMMERCIAL FIRE",
        "UNIT:WDF2");

    doTest("T6",
        "w/West Douglas: 12/03 10:52 AE-21-D 7250 Rainbow Creek Rd BREATHING PROBLEMS WDF3,M39,E39,BC34",
        "SRC:w/West Douglas",
        "DATE:12/03",
        "TIME:10:52",
        "CODE:AE-21-D",
        "ADDR:7250 Rainbow Creek Rd",
        "CALL:BREATHING PROBLEMS",
        "UNIT:WDF3,M39,E39,BC34");

    doTest("T7",
        "w/West Douglas: 07/05 15:09 AD-24-D 5068 Plum Ave JOHNSON & SONS CONSTRUCTION RESCUE - ANIMAL WDF3",
        "SRC:w/West Douglas",
        "DATE:07/05",
        "TIME:15:09",
        "CODE:AD-24-D",
        "ADDR:5068 Plum Ave",
        "CALL:JOHNSON & SONS CONSTRUCTION RESCUE - ANIMAL",
        "UNIT:WDF3");

    doTest("T8",
        "From: Group_Page_Notification@usamobility.net w/West Douglas:01/28 18:28 AE-24-A 4909 Woodley Ave LOCK OUT EMERGENT WDF2,M39,E39,BC34 Received: Mon Jan 28, 6:28 pm",
        "SRC:w/West Douglas",
        "DATE:01/28",
        "TIME:18:28",
        "CODE:AE-24-A",
        "ADDR:4909 Woodley Ave",
        "CALL:LOCK OUT EMERGENT",
        "UNIT:WDF2,M39,E39,BC34");

    doTest("T9",
        "From: Group_Page_Notification@usamobility.net w/West Douglas: 01/18 16:54 AJ-16-C 491 S 67 Hwy SPRUCEWOOD INN MVA – INJURIES WDF3,M39,E39,BC34 Received Fri Jan 18, 4:54 pm",
        "SRC:w/West Douglas",
        "DATE:01/18",
        "TIME:16:54",
        "CODE:AJ-16-C",
        "ADDR:491 S 67 Hwy",
        "MADDR:491 S Hwy 67",
        "CALL:SPRUCEWOOD INN MVA – INJURIES",
        "UNIT:WDF3,M39,E39,BC34");

    doTest("T10",
        "From: Group_Page_Notification@usamobility.net w/West Douglas: 01/15 21:11 AJ-14-B 128 Hill Dr ALARM – CO NO SICK PARTIES WDF3  Received Tue Jan 15, 9:11 pm",
        "SRC:w/West Douglas",
        "DATE:01/15",
        "TIME:21:11",
        "CODE:AJ-14-B",
        "ADDR:128 Hill Dr",
        "CALL:ALARM – CO NO SICK PARTIES",
        "UNIT:WDF3");

    doTest("T11",
        "From: Group_Page_Notification@usamobility.net w/West Douglas: 01/18 12:39 AF-21-B 7270 Piute Dr SICK PARTY WDF3,M46,E39,BC34 Received Fri Jan 1, 12:40 pm",
        "SRC:w/West Douglas",
        "DATE:01/18",
        "TIME:12:39",
        "CODE:AF-21-B",
        "ADDR:7270 Piute Dr",
        "CALL:SICK PARTY",
        "UNIT:WDF3,M46,E39,BC34");

    doTest("T12",
        "From: Group_Page_Notification@usamobility.net w/West Douglas: 01/13 20:20 AF-22-C 3522 Winnebago Dr SICK PARTY WDF2,E39,M39,BC34 Received: Sun Jan 13, 8:21 pm",
        "SRC:w/West Douglas",
        "DATE:01/13",
        "TIME:20:20",
        "CODE:AF-22-C",
        "ADDR:3522 Winnebago Dr",
        "CALL:SICK PARTY",
        "UNIT:WDF2,E39,M39,BC34");

    doTest("T13",
        "From: Group_Page_Notification@usamobility.net w/West Douglas: 12/03 15:00 AH-21-B Oak Valley Rd INVESTIGATION – SMOKE OUTSIDE WDF3 Received: Mon Dec 3, 3:01 pm",
        "SRC:w/West Douglas",
        "DATE:12/03",
        "TIME:15:00",
        "CODE:AH-21-B",
        "ADDR:Oak Valley Rd",
        "CALL:INVESTIGATION – SMOKE OUTSIDE",
        "UNIT:WDF3");

    doTest("T14",
        "From: Group_Page_Notification@usamobility.net w/West Douglas: 12/03 10:52 AE-21-D 7250 Rainbow Creek Rd BREATHING PROBLEMS WDF3,M39,E39,BC34 Received: Mon Dec 3, 1052 am",
        "SRC:w/West Douglas",
        "DATE:12/03",
        "TIME:10:52",
        "CODE:AE-21-D",
        "ADDR:7250 Rainbow Creek Rd",
        "CALL:BREATHING PROBLEMS",
        "UNIT:WDF3,M39,E39,BC34");

    doTest("T15",
        "From: Group_Page_Notification@usamobility.net w/West Douglas: 08/01 15:29 AF-23-A N 67 Hwy / Rainbow Creek Rd CHEST PAIN WDF1, M39, E39 Received: Mon Dec 3, 1052 am",
        "SRC:w/West Douglas",
        "DATE:08/01",
        "TIME:15:29",
        "CODE:AF-23-A",
        "ADDR:N 67 Hwy & Rainbow Creek Rd",
        "MADDR:N Hwy 67 & Rainbow Creek Rd",
        "CALL:CHEST PAIN WDF1, M39,",
        "UNIT:E39");

    doTest("T16",
        "From: Group_Page_Notification@usamobility.net w/West Douglas: 08/18 12:26 AH-17-D N 67 Hwy / N Rampart Range Rd MVA – INJURIES WDF3, M39, E39 Received: Mon Dec 3, 1052 am",
        "SRC:w/West Douglas",
        "DATE:08/18",
        "TIME:12:26",
        "CODE:AH-17-D",
        "ADDR:N 67 Hwy & N Rampart Range Rd",
        "MADDR:N Hwy 67 & N Rampart Range Rd",
        "CALL:MVA – INJURIES WDF3, M39,",
        "UNIT:E39");

  }
  
  public static void main(String[] args) {
    new CODouglasCountyBParserTest().generateTests("T1");
  }
}