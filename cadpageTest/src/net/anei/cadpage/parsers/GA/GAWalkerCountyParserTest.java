package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Walker County, GA
System: New WOrld CAD System

Contact: Chad Payne <firepolice210@gmail.com>
Sender: dispatch@walkerga.org
(!) Smoke In Area 600 CHICKAMAUGA AVE AREA LEINBACH RD, CLARK ST / E GORDON AVE ROSSVILLE   SUNSET MARKET ROSSVILLE CHECK AREA FOR SMOKE IN WOODS BEHIND LOOKOUT
(!) Lift Assist 715 RICHMOND AVE DALE ST / E SHORT ST ROSSVILLE    ELDERLY FEMALE OUT OF FLOOR  06/29/13 12:06
(!) Breathing Problems 601 WASHINGTON ST DEAD END / INDIAN AVE ROSSVILLE   ROSSVILLE APTS WASHINGTON  APT 6104  DIFF BREATHING...HX OF COPD AND HIGH BLOOD PRESSURE
(!) Chest Pains 115 W OAK ST LOGAN AVE / BROWN AVE ROSSVILLE    Dispatch received by unit WM6  38 YOF CHEST PAIN  06/24/13 21:35
(!) Chest Pains 314 E GORDON AVE CLARK ST / HICKS ST ROSSVILLE    Dispatch received by unit WM7  61 YOA MALE  06/24/13 13:26
(!) Waste Fire, Dump, Dumpster 104 A BEECH ST BAILEY AVE / MCFARLAND AVE ROSSVILLE    06/24/13 11:30
(!) Diabetic Problems 54 BREEZY TRL MOHAWK ST / MOHAWK ST ROSSVILLE    Dispatch received by unit WM2  Dispatch received by unit WM 06/23/13 21:54
(!) Breathing Problems 826 HENDERSON AVE CHERRY ST / CEDAR ST ROSSVILLE    64 YOA FEMALE BREATHING PROBLEMS SWELLING IN FEET 06/23/13 13:34
(!) Breathing Problems 718 CARDEN AVE CHERRY ST / MAPLE ST ROSSVILLE    43 YOM DIFF BREATHING CANT WALK FELL OFF LADDER  06/22/13 01:09

Contact: William Narmore <narmore.we@gmail.com>
Sender: dispatch@walkerga.org
(!) Accident - W/Injuries 208 S CHATTANOOGA ST THOMPSON ST / W PATTON ST LAFAYETTE    BICYCLE RECK WITH INJURIES  06/29/13 14:38
(!) Laceration 64 FITZPATRICK DR PLEDGER ST / DEAD END LAFAYETTE    06/30/13 13:06
(!) Accident - W/Injuries HENDRIX ST N  MAIN ST LAFAYETTE    Dispatch received by unit WM7  2 CAR   MINNOR INJURIES    N 06/27/13 15:23
(!) Medical Alarm 1201 W NORTH MAIN ST 204 N MAIN ST / CAMPBELL AVE LAFAYETTE   WOODLAND VILLAGE  WILL BE SOMEONE ON SCENE TO LET THEM IN  69 YOF HAS HAS FAL
(!) Chest Pains 115 W OAK ST LOGAN AVE / BROWN AVE ROSSVILLE    Dispatch received by unit WM6  38 YOF CHEST PAIN  06/24/13 21:35

Contact: Chad Payne <firepolice210@gmail.com>
Sender: dispatch@walkerga.org
(!) RFD  RFD 809 LEE AVE ROSSVILLE Chest Pains 2013-00004536
(!) WM7 RFD  800 WALKER AVE 8409 ROSSVILLE Chest Pains 2013-00004490
(!) RFD  RFD 1209 INDIAN AVE E1 HAPPY VALLEY APTS ROSSVILLE Convulsions/Seizures 2013-00000345
(!) RFD  RFD 809 LEE AVE ROSSVILLE Chest Pains 2013-00004536
(!) RFD  RFD 110 HOGAN RD ROSSVILLE Breathing Problems 2013-00004512
(!) RFD  RFD 520 CHICKAMAUGA AVE BOSS VANROSSVILLE Accident - No
(!) RFD  4103 DAYTON BLVD Fire Mutual Aid 2013-00000346

*/

public class GAWalkerCountyParserTest extends BaseParserTest {
  
  public GAWalkerCountyParserTest() {
    setParser(new GAWalkerCountyParser(), "WALKER COUNTY", "GA");
  }
  
  @Test
  public void testChadPayne() {

    doTest("T1",
        "(!) Smoke In Area 600 CHICKAMAUGA AVE AREA LEINBACH RD, CLARK ST / E GORDON AVE ROSSVILLE   SUNSET MARKET ROSSVILLE CHECK AREA FOR SMOKE IN WOODS BEHIND LOOKOUT",
        "CALL:Smoke In Area",
        "ADDR:600 CHICKAMAUGA AVE",
        "X:AREA LEINBACH RD, CLARK ST / E GORDON AVE",
        "CITY:ROSSVILLE",
        "INFO:SUNSET MARKET ROSSVILLE CHECK AREA FOR SMOKE IN WOODS BEHIND LOOKOUT");

    doTest("T2",
        "(!) Lift Assist 715 RICHMOND AVE DALE ST / E SHORT ST ROSSVILLE    ELDERLY FEMALE OUT OF FLOOR  06/29/13 12:06",
        "CALL:Lift Assist",
        "ADDR:715 RICHMOND AVE",
        "X:DALE ST / E SHORT ST",
        "CITY:ROSSVILLE",
        "INFO:ELDERLY FEMALE OUT OF FLOOR",
        "DATE:06/29/13",
        "TIME:12:06");

    doTest("T3",
        "(!) Breathing Problems 601 WASHINGTON ST DEAD END / INDIAN AVE ROSSVILLE   ROSSVILLE APTS WASHINGTON  APT 6104  DIFF BREATHING...HX OF COPD AND HIGH BLOOD PRESSURE",
        "CALL:Breathing Problems",
        "ADDR:601 WASHINGTON ST",
        "X:DEAD END / INDIAN AVE",
        "CITY:ROSSVILLE",
        "INFO:ROSSVILLE APTS WASHINGTON  APT 6104  DIFF BREATHING...HX OF COPD AND HIGH BLOOD PRESSURE");

    doTest("T4",
        "(!) Chest Pains 115 W OAK ST LOGAN AVE / BROWN AVE ROSSVILLE    Dispatch received by unit WM6  38 YOF CHEST PAIN  06/24/13 21:35",
        "CALL:Chest Pains",
        "ADDR:115 W OAK ST",
        "X:LOGAN AVE / BROWN AVE",
        "CITY:ROSSVILLE",
        "UNIT:WM6",
        "INFO:38 YOF CHEST PAIN",
        "DATE:06/24/13",
        "TIME:21:35");

    doTest("T5",
        "(!) Chest Pains 314 E GORDON AVE CLARK ST / HICKS ST ROSSVILLE    Dispatch received by unit WM7  61 YOA MALE  06/24/13 13:26",
        "CALL:Chest Pains",
        "ADDR:314 E GORDON AVE",
        "X:CLARK ST / HICKS ST",
        "CITY:ROSSVILLE",
        "UNIT:WM7",
        "INFO:61 YOA MALE",
        "DATE:06/24/13",
        "TIME:13:26");

    doTest("T6",
        "(!) Waste Fire, Dump, Dumpster 104 A BEECH ST BAILEY AVE / MCFARLAND AVE ROSSVILLE    06/24/13 11:30",
        "CALL:Waste Fire, Dump, Dumpster",
        "ADDR:104 A BEECH ST",
        "X:BAILEY AVE / MCFARLAND AVE",
        "CITY:ROSSVILLE",
        "INFO:06/24/13 11:30");

    doTest("T7",
        "(!) Diabetic Problems 54 BREEZY TRL MOHAWK ST / MOHAWK ST ROSSVILLE    Dispatch received by unit WM2  Dispatch received by unit WM 06/23/13 21:54",
        "CALL:Diabetic Problems",
        "ADDR:54 BREEZY TRL",  // Not mapping
        "X:MOHAWK ST / MOHAWK ST",
        "CITY:ROSSVILLE",
        "UNIT:WM2 WM",
        "DATE:06/23/13",
        "TIME:21:54");

    doTest("T8",
        "(!) Breathing Problems 826 HENDERSON AVE CHERRY ST / CEDAR ST ROSSVILLE    64 YOA FEMALE BREATHING PROBLEMS SWELLING IN FEET 06/23/13 13:34",
        "CALL:Breathing Problems",
        "ADDR:826 HENDERSON AVE",
        "X:CHERRY ST / CEDAR ST",
        "CITY:ROSSVILLE",
        "INFO:64 YOA FEMALE BREATHING PROBLEMS SWELLING IN FEET",
        "DATE:06/23/13",
        "TIME:13:34");

    doTest("T9",
        "(!) Breathing Problems 718 CARDEN AVE CHERRY ST / MAPLE ST ROSSVILLE    43 YOM DIFF BREATHING CANT WALK FELL OFF LADDER  06/22/13 01:09",
        "CALL:Breathing Problems",
        "ADDR:718 CARDEN AVE",
        "X:CHERRY ST / MAPLE ST",
        "CITY:ROSSVILLE",
        "INFO:43 YOM DIFF BREATHING CANT WALK FELL OFF LADDER",
        "DATE:06/22/13",
        "TIME:01:09");
  
  }
  
  @Test
  public void testWilliamNarmore() {

    doTest("T1",
        "(!) Accident - W/Injuries 208 S CHATTANOOGA ST THOMPSON ST / W PATTON ST LAFAYETTE    BICYCLE RECK WITH INJURIES  06/29/13 14:38",
        "CALL:Accident - W/Injuries",
        "ADDR:208 S CHATTANOOGA ST",
        "X:THOMPSON ST / W PATTON ST",
        "CITY:LAFAYETTE",
        "INFO:BICYCLE RECK WITH INJURIES",
        "DATE:06/29/13",
        "TIME:14:38");

    doTest("T2",
        "(!) Laceration 64 FITZPATRICK DR PLEDGER ST / DEAD END LAFAYETTE    06/30/13 13:06",
        "CALL:Laceration",
        "ADDR:64 FITZPATRICK DR",
        "X:PLEDGER ST / DEAD END",
        "CITY:LAFAYETTE",
        "INFO:06/30/13 13:06");

    doTest("T3",
        "(!) Accident - W/Injuries HENDRIX ST N  MAIN ST LAFAYETTE    Dispatch received by unit WM7  2 CAR   MINNOR INJURIES    N 06/27/13 15:23",
        "CALL:Accident - W/Injuries",
        "ADDR:HENDRIX ST N",
        "MADDR:HENDRIX ST N & MAIN ST",
        "X:MAIN ST",
        "CITY:LAFAYETTE",
        "UNIT:WM7",
        "INFO:2 CAR   MINNOR INJURIES    N",
        "DATE:06/27/13",
        "TIME:15:23");

    doTest("T4",
        "(!) Medical Alarm 1201 W NORTH MAIN ST 204 N MAIN ST / CAMPBELL AVE LAFAYETTE   WOODLAND VILLAGE  WILL BE SOMEONE ON SCENE TO LET THEM IN  69 YOF HAS HAS FAL",
        "CALL:Medical Alarm",
        "ADDR:1201 W NORTH MAIN ST",
        "APT:204",
        "X:N MAIN ST / CAMPBELL AVE",
        "CITY:LAFAYETTE",
        "INFO:WOODLAND VILLAGE  WILL BE SOMEONE ON SCENE TO LET THEM IN  69 YOF HAS HAS FAL");

    doTest("T5",
        "(!) Chest Pains 115 W OAK ST LOGAN AVE / BROWN AVE ROSSVILLE    Dispatch received by unit WM6  38 YOF CHEST PAIN  06/24/13 21:35",
        "CALL:Chest Pains",
        "ADDR:115 W OAK ST",
        "X:LOGAN AVE / BROWN AVE",
        "CITY:ROSSVILLE",
        "UNIT:WM6",
        "INFO:38 YOF CHEST PAIN",
        "DATE:06/24/13",
        "TIME:21:35");
 
  }
  
  @Test
  public void testChadPayne2() {

    doTest("T1",
        "(!) RFD  RFD 809 LEE AVE ROSSVILLE Chest Pains 2013-00004536",
        "UNIT:RFD",
        "SRC:RFD",
        "ADDR:809 LEE AVE",
        "CITY:ROSSVILLE",
        "CALL:Chest Pains",
        "ID:2013-00004536");

    doTest("T2",
        "(!) WM7 RFD  800 WALKER AVE 8409 ROSSVILLE Chest Pains 2013-00004490",
        "UNIT:WM7",
        "SRC:RFD",
        "ADDR:800 WALKER AVE",
        "APT:8409",
        "CITY:ROSSVILLE",
        "CALL:Chest Pains",
        "ID:2013-00004490");

    doTest("T3",
        "(!) RFD  RFD 1209 INDIAN AVE E1 HAPPY VALLEY APTS ROSSVILLE Convulsions/Seizures 2013-00000345",
        "UNIT:RFD",
        "SRC:RFD",
        "ADDR:1209 INDIAN AVE",
        "PLACE:E1 HAPPY VALLEY APTS",
        "CITY:ROSSVILLE",
        "CALL:Convulsions/Seizures",
        "ID:2013-00000345");

    doTest("T4",
        "(!) RFD  RFD 809 LEE AVE ROSSVILLE Chest Pains 2013-00004536",
        "UNIT:RFD",
        "SRC:RFD",
        "ADDR:809 LEE AVE",
        "CITY:ROSSVILLE",
        "CALL:Chest Pains",
        "ID:2013-00004536");

    doTest("T5",
        "(!) RFD  RFD 110 HOGAN RD ROSSVILLE Breathing Problems 2013-00004512",
        "UNIT:RFD",
        "SRC:RFD",
        "ADDR:110 HOGAN RD",
        "CITY:ROSSVILLE",
        "CALL:Breathing Problems",
        "ID:2013-00004512");

    doTest("T6",
        "(!) RFD  RFD 520 CHICKAMAUGA AVE BOSS VANROSSVILLE Accident - No",
        "UNIT:RFD",
        "SRC:RFD",
        "ADDR:520 CHICKAMAUGA AVE",
        "PLACE:BOSS VAN",
        "CITY:ROSSVILLE",
        "CALL:Accident - No");

    doTest("T7",
        "(!) RFD  4103 DAYTON BLVD Fire Mutual Aid 2013-00000346",
        "SRC:4103",
        "ADDR:4103 DAYTON BLVD",
        "CALL:Fire Mutual Aid",
        "ID:2013-00000346");
   
  }
  
  public static void main(String[] args) {
    new GAWalkerCountyParserTest().generateTests("T1");
  }
}
