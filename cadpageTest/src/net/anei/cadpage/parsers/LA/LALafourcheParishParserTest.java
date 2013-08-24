package net.anei.cadpage.parsers.LA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*

Lafourche Parish, LA
Contact: Active911
Agency name: Lafourche Fire District #1
Location: Raceland, LA, United States
Sender: no-reply@ledsportal.com

(13-24233 - 52A : Fire Alarm) 4221 HWY 308, RACELAND
(13-22344 - 52A : Fire Alarm) 3737 HWY 308, RACELAND NOTE: THIS IS JUST ANOTHER TEST PAGE!
(13-20338 - 52F : Fire) 1234 HIGHWAY 1, THIBODAUX THIS IS A TEST PAGE. THIS SHOULD BE THE LAST PAGE. WILL NOTIFY SHORTLY.
(13-22246 - 24 : Medical Emergency) 201 SYLVESTER AVE, RACELAND, LA NOTE: THIS IS A TEST PAGE
(13-22376 - 20 : Crash) Intersection of HWY 1 and AYO ST, RACELAND\n\nTHIS IS JUST A TEST PAGE
(13-22344 - 52A : Fire Alarm) 3737 HWY 308, RACELAND\nPLEASE NOTE - THIS IS JUST A TEST PAGE
(13-22479 - 21D : Dispatcher/Call Taker Info) COMMUNICATIONS\nThis is a test page
(13-22246 - 24 : Medical Emergency MEDICAL CALL OUT) 201 SYLVESTER AVE, RACELAND, LA ACADAIN AMBULANCE REQUESTING FIRST RESPONDERS TO 201 SYLVESTER AVE FOR HEAVY LIFT
(13-21156 - 18A : Abandoned Vehicle) 662 AYO ST, RACELAND, LAGASOLINE LEAK FROM A VEHICLE AT 662 AYO STREET
(13-20505 - 52F : Fire) LEFORT BYPASS RD, THIBODAUX, LA TO LEFORT BYPASS RD A FIELD ON FIRE
(13-20337 - 52F : Fire) 1321 HWY 1, THIBODAUX, LAHOUSE FIRE BY LAFOURCHE CROSSING
(13-20217 - 52A : Fire Alarm) 220 ST PHILLIP ST, RACELAND, LA GENERAL FIRE ALARM ACTIVATED
(13-19750 - 52A : Fire Alarm) 3500 HWY 1, RACELAND
(13-19716 - 24 : Medical Emergency) 3339 HWY 1, RACELAND
(13-19325 - 52A : Fire Alarm) 3500 HIGHWAY 1, RACELAND FIRE ALARM AT ST MARY CHURCH
(FIRE ALARM) 4229 HWY 308 GENERAL FIRE ALARM
(13-18688 - 52A : Fire Alarm) 3737 hwy 308, RACELANDfire alarm
(13-18526 - 52A : Fire Alarm) 4560 HIGHWAY 1 SUITE 3, RACELANDFIRE ALARM AT STAGE
(13-18347 - 24 : Medical Emergency) 576 ST LOUIS ST, RACELAND FEMALE IN CARDIAC ARREST AND CPR IS IN PROGRESS
(13-17647 - 52A : Fire Alarm) 2755 HIGHWAY 308, RACELAND THIS IS ANOTHER TEST PAGE
(13-17643 - 21L : Lock Job) 3112 HWY 308, RACELAND, LA THIS IS JUST A TEST PAGE
(13-17181 - 52A : Fire Alarm) 103 ACADIA DR FIRE ALARM
(13-17051 - 52F : Fire) HIGHWAY 182, RACELAND
(13-16975 - 52F : Fire) Intersection of HWY 182 and RANGE, RACELANDNEAR THE LPSO RANGE ABOUT 200 YARDS AWAY
(13-16715 - 20 : Crash) Intersection of HWY 90 W and HWY 182 FIRST EXIT, RACELAND\ AUTO CRASH EXTRICATION NEEDED
(13-16458 - 52F : Fire) Intersection of HIGHWAY 1 and HIGHWAY 90, RACELANDJUST NORTH OF THIS INTERSECTION, BLACK HEAVY SMOKE, UNKNOWN FURTHER
(13-15728 - 52F : Fire) HWY 182 AND NORTH SERVICE RD., R POLE ON FIRE
(13-15560 - 52F : Fire) Intersection of HWY 182 and HWY 90, RACELAND GRASS FIRE
(13-15511 - 52F : Fire) Intersection of HIGHWAY 182 and HIGHWAY 653, RACELAND GRASS FIRE
(13-15501 - 52F : Fire) HIGHWAY 182, RACELAND GRASS FIRE
(13-06215 - 52A : Fire Alarm) 867 LAFORT BYPASS, THIBODAUX FIRE ALARM
(FIRE ALARM) RACELAND MANOR


Contact: Active911
Agency name: St. John Vol. Fire Dept.
Location: Thibodaux, LA, United States
Sender: no-reply@ledsportal.com

(13-45411 - 52F : Fire) 172 BENTLY DR, THIBODAUX, LA
(HOUSE FIRE) HOUSE FIRE 205 CALDWELL PLANTATION RD
(13-43765 - 52F : Fire) 200 PLYMOUTH ST, THIBODAUX, LA HOUSE FIRE
(13-42090 - 52F : Fire) 301 EAUCLAIR DR, THIBODAUX, LASMOKE VISABLE POSSIBLE, POSSIBLE HOUSE FIRE
(13-39533 - 52F : Fire) CALDWELL SUGARS, THIBODAUXTREE ON FIRE
(13-39351 -) vehicle fire at 207 s HIDALGO LN IN THE DRIVEWAY
(13-38907 - 24 : Medical Emergency) 2001 HIGHWAY 307, KRAEMER
(13-37279 - 52F : Fire) 720 BARBIER AV, THIBODAUX, LASMOKE IN LIVING ROOM AND KITCHEN, SMELLS BURNT IN RESIDENCE, EVERYONE OUT
(13-36457 - 52F : Fire) LA 1 PASSED WAVERLY ESTATES, THIBODAUXTHICK BLACK SMOKE PASSED WAVERLY ESTATES
(13-36304 - 52A : Fire Alarm) 2464 TALBOT AV, THIBODAUX, LA

Contact: Active911
Agency name: Vacherie-Gheens Vol. Fire Company
Location: Gheens, LA, United States
Sender: no-reply@ledsportal.com

(13-44285 - 24 : Medical Emergency MEDICAL CALL) 2100 HIGHWAY 654, GHEENS TO 2100 HWY 654 REFERENCE TO AN ELDERLY FEMALE NOT FEELING WELL
(13-43275 - 24 : Medical EmergencyMEDICAL CALL OUT) 1917 HWY 654, GHEENS TO 1917 HWY 654  REFERENCE TO A 98 YEAR OLD FEMALE WHO FELL

Contact: Active911
Agency name: Lafourche Crossing 308 Vol Fire Dept.
Location: Thibodaux, LA, United States
Sender: no-reply@ledsportal.com

(13-41393 - 20 : Crash) HWY 308 2 MILES SOUTH OF LAUREL VALLEY, THIBODAUX

 */
public class LALafourcheParishParserTest extends BaseParserTest {
  
  public LALafourcheParishParserTest() {
    setParser(new LALafourcheParishParser(), "LAFOURCHE PARISH", "LA");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "(13-24233 - 52A : Fire Alarm) 4221 HWY 308, RACELAND",
        "ID:13-24233",
        "CODE:52A",
        "CALL:Fire Alarm",
        "ADDR:4221 HWY 308",
        "CITY:RACELAND");

    doTest("T2",
        "(13-22344 - 52A : Fire Alarm) 3737 HWY 308, RACELAND NOTE: THIS IS JUST ANOTHER TEST PAGE!",
        "ID:13-22344",
        "CODE:52A",
        "CALL:Fire Alarm",
        "ADDR:3737 HWY 308",
        "CITY:RACELAND",
        "INFO:NOTE: THIS IS JUST ANOTHER TEST PAGE!");

    doTest("T3",
        "(13-20338 - 52F : Fire) 1234 HIGHWAY 1, THIBODAUX THIS IS A TEST PAGE. THIS SHOULD BE THE LAST PAGE. WILL NOTIFY SHORTLY.",
        "ID:13-20338",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:1234 HIGHWAY 1",
        "CITY:THIBODAUX",
        "INFO:THIS IS A TEST PAGE. THIS SHOULD BE THE LAST PAGE. WILL NOTIFY SHORTLY.");

    doTest("T4",
        "(13-22246 - 24 : Medical Emergency) 201 SYLVESTER AVE, RACELAND, LA NOTE: THIS IS A TEST PAGE",
        "ID:13-22246",
        "CODE:24",
        "CALL:Medical Emergency",
        "ADDR:201 SYLVESTER AVE",
        "CITY:RACELAND",
        "INFO:NOTE: THIS IS A TEST PAGE");

    doTest("T5",
        "(13-22376 - 20 : Crash) Intersection of HWY 1 and AYO ST, RACELAND\n\nTHIS IS JUST A TEST PAGE",
        "ID:13-22376",
        "CODE:20",
        "CALL:Crash",
        "ADDR:HWY 1 and AYO ST",
        "MADDR:HWY 1 & AYO ST",
        "CITY:RACELAND",
        "INFO:THIS IS JUST A TEST PAGE");

    doTest("T6",
        "(13-22344 - 52A : Fire Alarm) 3737 HWY 308, RACELAND\nPLEASE NOTE - THIS IS JUST A TEST PAGE",
        "ID:13-22344",
        "CODE:52A",
        "CALL:Fire Alarm",
        "ADDR:3737 HWY 308",
        "CITY:RACELAND",
        "INFO:PLEASE NOTE - THIS IS JUST A TEST PAGE");

    doTest("T7",
        "(13-22479 - 21D : Dispatcher/Call Taker Info) COMMUNICATIONS\nThis is a test page",
        "ID:13-22479",
        "CODE:21D",
        "CALL:Dispatcher/Call Taker Info",
        "ADDR:COMMUNICATIONS This is a test page");

    doTest("T8",
        "(13-22246 - 24 : Medical Emergency MEDICAL CALL OUT) 201 SYLVESTER AVE, RACELAND, LA ACADAIN AMBULANCE REQUESTING FIRST RESPONDERS TO 201 SYLVESTER AVE FOR HEAVY LIFT",
        "ID:13-22246",
        "CODE:24",
        "CALL:Medical Emergency MEDICAL CALL OUT",
        "ADDR:201 SYLVESTER AVE",
        "CITY:RACELAND",
        "INFO:ACADAIN AMBULANCE REQUESTING FIRST RESPONDERS TO 201 SYLVESTER AVE FOR HEAVY LIFT");

    doTest("T9",
        "(13-21156 - 18A : Abandoned Vehicle) 662 AYO ST, RACELAND, LAGASOLINE LEAK FROM A VEHICLE AT 662 AYO STREET",
        "ID:13-21156",
        "CODE:18A",
        "CALL:Abandoned Vehicle",
        "ADDR:662 AYO ST",
        "CITY:RACELAND",
        "INFO:GASOLINE LEAK FROM A VEHICLE AT 662 AYO STREET");

    doTest("T10",
        "(13-20505 - 52F : Fire) LEFORT BYPASS RD, THIBODAUX, LA TO LEFORT BYPASS RD A FIELD ON FIRE",
        "ID:13-20505",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:LEFORT BYPASS RD",
        "CITY:THIBODAUX",
        "INFO:TO LEFORT BYPASS RD A FIELD ON FIRE");

    doTest("T11",
        "(13-20337 - 52F : Fire) 1321 HWY 1, THIBODAUX, LAHOUSE FIRE BY LAFOURCHE CROSSING",
        "ID:13-20337",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:1321 HWY 1",
        "CITY:THIBODAUX",
        "INFO:HOUSE FIRE BY LAFOURCHE CROSSING");

    doTest("T12",
        "(13-20217 - 52A : Fire Alarm) 220 ST PHILLIP ST, RACELAND, LA GENERAL FIRE ALARM ACTIVATED",
        "ID:13-20217",
        "CODE:52A",
        "CALL:Fire Alarm",
        "ADDR:220 ST PHILLIP ST",
        "CITY:RACELAND",
        "INFO:GENERAL FIRE ALARM ACTIVATED");

    doTest("T13",
        "(13-19750 - 52A : Fire Alarm) 3500 HWY 1, RACELAND",
        "ID:13-19750",
        "CODE:52A",
        "CALL:Fire Alarm",
        "ADDR:3500 HWY 1",
        "CITY:RACELAND");

    doTest("T14",
        "(13-19716 - 24 : Medical Emergency) 3339 HWY 1, RACELAND",
        "ID:13-19716",
        "CODE:24",
        "CALL:Medical Emergency",
        "ADDR:3339 HWY 1",
        "CITY:RACELAND");

    doTest("T15",
        "(13-19325 - 52A : Fire Alarm) 3500 HIGHWAY 1, RACELAND FIRE ALARM AT ST MARY CHURCH",
        "ID:13-19325",
        "CODE:52A",
        "CALL:Fire Alarm",
        "ADDR:3500 HIGHWAY 1",
        "CITY:RACELAND",
        "INFO:FIRE ALARM AT ST MARY CHURCH");

    doTest("T16",
        "(FIRE ALARM) 4229 HWY 308 GENERAL FIRE ALARM",
        "CALL:FIRE ALARM",
        "ADDR:4229 HWY 308",
        "INFO:GENERAL FIRE ALARM");

    doTest("T17",
        "(13-18688 - 52A : Fire Alarm) 3737 hwy 308, RACELANDfire alarm",
        "ID:13-18688",
        "CODE:52A",
        "CALL:Fire Alarm",
        "ADDR:3737 hwy 308",
        "CITY:RACELAND",
        "INFO:fire alarm");

    doTest("T18",
        "(13-18526 - 52A : Fire Alarm) 4560 HIGHWAY 1 SUITE 3, RACELANDFIRE ALARM AT STAGE",
        "ID:13-18526",
        "CODE:52A",
        "CALL:Fire Alarm",
        "ADDR:4560 HIGHWAY 1",
        "APT:3",
        "CITY:RACELAND",
        "INFO:FIRE ALARM AT STAGE");

    doTest("T19",
        "(13-18347 - 24 : Medical Emergency) 576 ST LOUIS ST, RACELAND FEMALE IN CARDIAC ARREST AND CPR IS IN PROGRESS",
        "ID:13-18347",
        "CODE:24",
        "CALL:Medical Emergency",
        "ADDR:576 ST LOUIS ST",
        "CITY:RACELAND",
        "INFO:FEMALE IN CARDIAC ARREST AND CPR IS IN PROGRESS");

    doTest("T20",
        "(13-17647 - 52A : Fire Alarm) 2755 HIGHWAY 308, RACELAND THIS IS ANOTHER TEST PAGE",
        "ID:13-17647",
        "CODE:52A",
        "CALL:Fire Alarm",
        "ADDR:2755 HIGHWAY 308",
        "CITY:RACELAND",
        "INFO:THIS IS ANOTHER TEST PAGE");

    doTest("T21",
        "(13-17643 - 21L : Lock Job) 3112 HWY 308, RACELAND, LA THIS IS JUST A TEST PAGE",
        "ID:13-17643",
        "CODE:21L",
        "CALL:Lock Job",
        "ADDR:3112 HWY 308",
        "CITY:RACELAND",
        "INFO:THIS IS JUST A TEST PAGE");

    doTest("T22",
        "(13-17181 - 52A : Fire Alarm) 103 ACADIA DR FIRE ALARM",
        "ID:13-17181",
        "CODE:52A",
        "CALL:Fire Alarm",
        "ADDR:103 ACADIA DR",
        "INFO:FIRE ALARM");

    doTest("T23",
        "(13-17051 - 52F : Fire) HIGHWAY 182, RACELAND",
        "ID:13-17051",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:HIGHWAY 182",
        "CITY:RACELAND");

    doTest("T24",
        "(13-16975 - 52F : Fire) Intersection of HWY 182 and RANGE, RACELANDNEAR THE LPSO RANGE ABOUT 200 YARDS AWAY",
        "ID:13-16975",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:HWY 182 and RANGE",
        "MADDR:HWY 182 & RANGE",
        "CITY:RACELAND",
        "INFO:NEAR THE LPSO RANGE ABOUT 200 YARDS AWAY");

    doTest("T25",
        "(13-16715 - 20 : Crash) Intersection of HWY 90 W and HWY 182 FIRST EXIT, RACELAND\\ AUTO CRASH EXTRICATION NEEDED",
        "ID:13-16715",
        "CODE:20",
        "CALL:Crash",
        "ADDR:HWY 90 W and HWY 182 FIRST EXIT",
        "MADDR:HWY 90 W & HWY 182 FIRST EXIT",
        "CITY:RACELAND",
        "INFO:\\ AUTO CRASH EXTRICATION NEEDED");

    doTest("T26",
        "(13-16458 - 52F : Fire) Intersection of HIGHWAY 1 and HIGHWAY 90, RACELANDJUST NORTH OF THIS INTERSECTION, BLACK HEAVY SMOKE, UNKNOWN FURTHER",
        "ID:13-16458",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:HIGHWAY 1 and HIGHWAY 90",
        "MADDR:HIGHWAY 1 & HIGHWAY 90",
        "CITY:RACELAND",
        "INFO:JUST NORTH OF THIS INTERSECTION, BLACK HEAVY SMOKE, UNKNOWN FURTHER");

    doTest("T27",
        "(13-15728 - 52F : Fire) HWY 182 AND NORTH SERVICE RD., R POLE ON FIRE",
        "ID:13-15728",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:HWY 182 AND NORTH SERVICE RD",
        "MADDR:HWY 182 & NORTH SERVICE RD",
        "INFO:R POLE ON FIRE");

    doTest("T28",
        "(13-15560 - 52F : Fire) Intersection of HWY 182 and HWY 90, RACELAND GRASS FIRE",
        "ID:13-15560",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:HWY 182 and HWY 90",
        "MADDR:HWY 182 & HWY 90",
        "CITY:RACELAND",
        "INFO:GRASS FIRE");

    doTest("T29",
        "(13-15511 - 52F : Fire) Intersection of HIGHWAY 182 and HIGHWAY 653, RACELAND GRASS FIRE",
        "ID:13-15511",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:HIGHWAY 182 and HIGHWAY 653",
        "MADDR:HIGHWAY 182 & HIGHWAY 653",
        "CITY:RACELAND",
        "INFO:GRASS FIRE");

    doTest("T30",
        "(13-15501 - 52F : Fire) HIGHWAY 182, RACELAND GRASS FIRE",
        "ID:13-15501",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:HIGHWAY 182",
        "CITY:RACELAND",
        "INFO:GRASS FIRE");

    doTest("T31",
        "(13-06215 - 52A : Fire Alarm) 867 LAFORT BYPASS, THIBODAUX FIRE ALARM",
        "ID:13-06215",
        "CODE:52A",
        "CALL:Fire Alarm",
        "ADDR:867 LAFORT BYPASS",
        "CITY:THIBODAUX",
        "INFO:FIRE ALARM");

    doTest("T31",
        "(FIRE ALARM) RACELAND MANOR",
        "CALL:FIRE ALARM",
        "ADDR:RACELAND MANOR");

  }
  
  @Test
  public void testStJohnVolFireDept() {

    doTest("T1",
        "(13-45411 - 52F : Fire) 172 BENTLY DR, THIBODAUX, LA",
        "ID:13-45411",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:172 BENTLY DR",
        "CITY:THIBODAUX");

    doTest("T2",
        "(HOUSE FIRE) HOUSE FIRE 205 CALDWELL PLANTATION RD",
        "CALL:HOUSE FIRE",
        "ADDR:205 CALDWELL PLANTATION RD");

    doTest("T3",
        "(13-43765 - 52F : Fire) 200 PLYMOUTH ST, THIBODAUX, LA HOUSE FIRE",
        "ID:13-43765",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:200 PLYMOUTH ST",
        "CITY:THIBODAUX",
        "INFO:HOUSE FIRE");

    doTest("T4",
        "(13-42090 - 52F : Fire) 301 EAUCLAIR DR, THIBODAUX, LASMOKE VISABLE POSSIBLE, POSSIBLE HOUSE FIRE",
        "ID:13-42090",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:301 EAUCLAIR DR",
        "CITY:THIBODAUX",
        "INFO:SMOKE VISABLE POSSIBLE, POSSIBLE HOUSE FIRE");

    doTest("T5",
        "(13-39533 - 52F : Fire) CALDWELL SUGARS, THIBODAUXTREE ON FIRE",
        "ID:13-39533",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:CALDWELL SUGARS",
        "CITY:THIBODAUX",
        "INFO:TREE ON FIRE");

    doTest("T6",
        "(13-39351 -) vehicle fire at 207 s HIDALGO LN IN THE DRIVEWAY",
        "ID:13-39351",
        "CALL:vehicle fire",
        "ADDR:207 s HIDALGO LN",
        "INFO:IN THE DRIVEWAY");

    doTest("T7",
        "(13-38907 - 24 : Medical Emergency) 2001 HIGHWAY 307, KRAEMER",
        "ID:13-38907",
        "CODE:24",
        "CALL:Medical Emergency",
        "ADDR:2001 HIGHWAY 307",
        "INFO:KRAEMER");

    doTest("T8",
        "(13-37279 - 52F : Fire) 720 BARBIER AV, THIBODAUX, LASMOKE IN LIVING ROOM AND KITCHEN, SMELLS BURNT IN RESIDENCE, EVERYONE OUT",
        "ID:13-37279",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:720 BARBIER AV",
        "MADDR:720 BARBIER AVE",
        "CITY:THIBODAUX",
        "INFO:SMOKE IN LIVING ROOM AND KITCHEN, SMELLS BURNT IN RESIDENCE, EVERYONE OUT");

    doTest("T9",
        "(13-36457 - 52F : Fire) LA 1 PASSED WAVERLY ESTATES, THIBODAUXTHICK BLACK SMOKE PASSED WAVERLY ESTATES",
        "ID:13-36457",
        "CODE:52F",
        "CALL:Fire",
        "ADDR:LA 1 PASSED WAVERLY ESTATES",
        "CITY:THIBODAUX",
        "INFO:THICK BLACK SMOKE PASSED WAVERLY ESTATES");

    doTest("T10",
        "(13-36304 - 52A : Fire Alarm) 2464 TALBOT AV, THIBODAUX, LA",
        "ID:13-36304",
        "CODE:52A",
        "CALL:Fire Alarm",
        "ADDR:2464 TALBOT AV",
        "MADDR:2464 TALBOT AVE",
        "CITY:THIBODAUX");

  }
  
  @Test
  public void testVacherieGheensVolFireCompany() {

     doTest("T1",
         "(13-44285 - 24 : Medical Emergency MEDICAL CALL) 2100 HIGHWAY 654, GHEENS TO 2100 HWY 654 REFERENCE TO AN ELDERLY FEMALE NOT FEELING WELL",
         "ID:13-44285",
         "CODE:24",
         "CALL:Medical Emergency MEDICAL CALL",
         "ADDR:2100 HIGHWAY 654",
         "CITY:GHEENS",
         "INFO:TO 2100 HWY 654 REFERENCE TO AN ELDERLY FEMALE NOT FEELING WELL");

     doTest("T2",
         "(13-43275 - 24 : Medical EmergencyMEDICAL CALL OUT) 1917 HWY 654, GHEENS TO 1917 HWY 654  REFERENCE TO A 98 YEAR OLD FEMALE WHO FELL",
         "ID:13-43275",
         "CODE:24",
         "CALL:Medical EmergencyMEDICAL CALL OUT",
         "ADDR:1917 HWY 654",
         "CITY:GHEENS",
         "INFO:TO 1917 HWY 654  REFERENCE TO A 98 YEAR OLD FEMALE WHO FELL");
 
  }
  
  @Test
  public void testLafourcheCrossing308VolFireDept() {

    doTest("T1",
        "(13-41393 - 20 : Crash) HWY 308 2 MILES SOUTH OF LAUREL VALLEY, THIBODAUX",
        "ID:13-41393",
        "CODE:20",
        "CALL:Crash",
        "ADDR:HWY 308 2 MILES SOUTH OF LAUREL VALLEY",
        "MADDR:HWY 308 2 MILES & LAUREL VALLEY",
        "CITY:THIBODAUX");
   
  }
  
  public static void main(String[] args) {
    new LALafourcheParishParserTest().generateTests("T1");
  }
}