package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Franklin, OH (in Clearmont County but dispatched separately)
Contact: Christopher Rauh <crauh@franklinohio.org>
Contact: Scott Rauh <srauh2290@yahoo.com>
Sender: rc.282@cmsg.net

(CAD) [!] F-STRUCTURE FIRE LOCATION: 818 UNION RD FRANKLIN TWP BETWEEN ROBERTS DR/SHAKER RD COMMENTS: X-084.304747 Y+039.552894 CF95 U ZUNCFIRE IN ATTIC EVERYONE EVACUATED
(CAD) [!] F-POLICE ASSIST LOCATION: 235 INDUSTRIAL DR FRANKLIN BETWEEN N SR RT 123/SHAKER RD COMMENTS: VEH STRUCK A POLE/ APPEARS THAT THE WIRES ARE ALL STILL CONNECTED REQ FFD
(CAD) [!] F-CARBON MONOXIDE INCIDENT LOCATION: 201 E 2ND ST FRANKLIN BETWEEN LOCUST ST / ALLEN ST COMMENTS: POSSIBLE CO LEAK BY STEPS SO POSSIBLY BASEMENT
(CAD) [!] F-UTILITY POLE-TRANSFORMER FIRE LOCATION: 850 N MAIN ST FRANKLIN BETWEEN KENNETH KOONS BLVD / PENNYROYAL RD COMMENTS; WIRE DOWN / LINE ARCHING
(CAD) [!] AUTO CRASH/SINGLE ENGINE LOCATION: 36 NB I-75 FRANKLIN BETWEEN SHAKER RD / SR 123 ST COMMENTS: X-084.284963 Y+039.562293 CFO U Z ZUNCSEMI TRUCK CRASHED DUMPING FUEL IN ROADWAY
(CAD) [!] F-HAZMAT LEAK SPILL NO FIRE LOCATION: 501 SHOTWELL DR FRANKLIN BETWEEN N SR RT 123 / DEAD END COMMENTS: X Y CF U Z ZUNCBOTTLE OF ACCETYLINE LEAKING HEAVILY INSIDE THE BACK OF BUILDING
(CAD) [!] F-OUTDOOR FIRE INVESTIGATION LOCATION: 324 PENNYROYAL RD FRANKLIN TWP BETWEEN CLEARCREEK FRANKLIN RD / HOMESTEAD DR COMMENTS: NEIGHBOR HAVING A VERY LARGE FIRE IN THEIR YARD/ REQ FFD COME CHECK IT
(CAD) [!] F-ANIMAL RESCUE LOCATION: 5709 S DIXIE HWY FRANKLIN COMMENTS: ANIMAL SANCTUARY PERSON IS AT PROPERTY REQ ANIMAL RESCUE FOR POT BELLY PIG 
(CAD) [!] F-FIRE ALARM LOCATION: 2301 COMMERCE CENTER DR FRANKLIN BETWEEN E 2ND ST / HERITAGE DR COMMENTS: SHOWING ZONE 47 / EMPLOYEE MANUAL PULL
(CAD) [!] F-GENERAL RECALL LOCATION: 45 E 4TH ST FRANKLIN BETWEEN RILEY ST / ANDERSON ST
(CAD) [!] AUTO CRASH WITH ENTRAPMENT LOCATION: 38 NB I-75 FRANKLIN BETWEEN SR 123 / SR 73 COMMENTS: X-084.261703 Y+039.568226 CF0 U Z ZUNC
(CAD) [!] PRIVATE PROPERTY ACCIDENT W/ INJURY LOCATION: 8201 CLAUDE THOMAS RD FRANKLIN BETWEEN COMMERCE CENTER DR / DEAD END DR COMMENTS: PPA W/ INJURY
(CAD) [!] F-FIRE ALARM LOCATION: 228 S MAIN ST FRANKLIN BETWEEN E 2ND ST / E 3RD ST

Contact: Active911
Agency name: City of Franklin FireEMS
Location: Franklin, OH, United States
Sender: rc.282@c-msg.net

F-STRUCTURE FIRE LOCATION: 216 COLUMUBS L EBANON COMMENTS: ENGINE FOR STRUCTURE FIRE MONROE RD TO CO LUMBUS TAC 3 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 319 E 4TH ST FRANKLIN BETWEEN HILL AVE / SUNNYBROOK DR C OMMENTS: WIRE ON THE GROUND BETWEEN PROPERTIES 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: N MAIN ST / WARREN AV FRANKLIN COMMENTS: LINE DOWN, ON SI DEWALK AND THE STREET 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 118 MORGAN CT FRANKLIN BETWEEN VICTORIA DR / CUL DE SAC COMMENTS: LOW HANGING WIRES 
TEST TEST TEST/PHONE LOCATION: 523 S RILEY BLVD FRANKLIN BETWEEN E 5TH  \nST / E 6TH ST COMMENTS: WIRE JUST FELL IN FRONT OF RESIDENCE 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 523 S RILEY BLVD FRANKLIN BETWEEN E 5TH ST / E 6TH ST CO MMENTS: WIRE JUST FELL IN FRONT OF RESIDENCE 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 523 S RILEY BLVD FRANKLIN BETWEEN E 5TH ST / E 6TH ST 
F-ABDOMINAL PAIN LOCATION: 622 LAKE AV FR ANKLIN BETWEEN CHESTNUT ST / CEDAR ST COMMENTS: X Y CF U Z ZUNC79 YO F STOMACH PAIN / SP BRAIN SURGERY REQ TR TO KETTERING 
F-SERVICE CALL LOCATION: 7600 SHARTS RD F RANKLIN TWP BETWEEN KENNY LN / SPRINBORO LIMITS tree dow n blocking road 
F-VEHICLE FIRE LOCATION: 222 E BRYANT AV FRANKLIN BETWEEN LARRY DR / JUDY DR COMMENTS: X Y CF U Z ZUNC 
F-VEHICLE FIRE LOCATION: 227 E BRYANT AV FRANKLIN BETWEEN LARRY DR / JUDY DR 
F-UNKNOWN MEDICAL PROBLEM LOCATION: 519 A NDERSON ST FRANKLIN BETWEEN E 5TH ST / E 6TH ST 71 yoa m ale feeling faint 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 1200 S RIVER ST FRANKLIN BETWEEN BROWN ST / DEAD END 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: SYCAMORE ST / PARK AV FRANKLIN 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 804 HARRISON AV FRANKLIN BETWEEN ROBERTS AVE / DEAD END 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 7263 MENTZ RD FRANKLIN TWP BETWEEN SHAKER RD / SHAKER RD COMMENTS: WIRES DOWN IN THE ROADWAY 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: UNION RD / SHAKER RD FRANKLIN TWP COMMENTS: X-084.306657 Y+039.531447 CF90 U Z ZUN CNEAR THE CURVE PAST SHAKER MEADOWS - TX THE CALLER TO WC CC 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 32 E 4TH ST FRANKLIN BETWEEN S MAIN ST / S RILEY BLVD CO MMENTS: WIRE HANGING IN HER FRONT YARD- POLE TO HOUSE 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: PENNYROYAL RD / N DIXIE HWY FRANKLIN TWP COMMENTS: WIRES ACROSS THE ROADWAY 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 9999 LAKE AV FRANKLIN COMMENTS: ON THE HILL THAT GOES OVE R THE LEVYTORE DOWN SOME CABLE OR PHONE WIRES 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: LAKE AV / ELM ST FRANKLIN COMMENTS: WIRE DOWN ACROSS THE ROADWAY 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 43 MIAMI AV FRANKLIN BETWEEN CARLISLE LIMITS / LAKE AVE COMMENTS: TREE TOOK DOWN A LINE 
F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 9999 N CHESTNUT ST FRANKLIN COMMENTS: CROSS OF LAKE AND S PRINGWIRES DOWN IN THE ROADWAY 
F-FLUSH FUEL / ROADWAY LOCATION: 6901 N S T RT 123 FRANKLIN BETWEEN SPRING DR / I-75 OVERPASS COMMENT S: X Y CF U Z ZUNCDRIVER PULLED LEVER OFF PUMP, GAS LEAKING 
AUTO CRASH WITH ENTRAPMENT LOCATION: 38 S B I-75 FRANKLIN BETWEEN SR123 / SR73 COMMENTS: BY DAYTON DA ILY NEWS ENTRAPPED IN ROLL OVER BUT NOT INJURED IN FRONT DAYTON DAILY 
F-CHEST PAINS / HEART PROBLEMS LOCATION: 1275 E 2ND ST FRANKLIN COMMENTS: X Y CF U Z ZUNCCHEST PAINS 24 YEAR O LD FEMALE IN MANGERS OFFICE 
F-NOTIFICATION LOCATION: 45 E 4TH ST FRAN KLIN BETWEEN RILEY ST / ANDERSON ST COMMENTS: WINTER STORM WARNING IN EFFECT FROM 11 AM THIS MORNING TO 1 PM WEDNESDAYSNOW ACCUMULATION OF 4 TO 6 INCHES ALONG WITH SOME SLEET R AIN WILL SPREAD INTO THE AREA THIS MORNING AND WILL IX WITH SNOW LATER IN THE AFTERNOON AND QUICKLY CHANGE TO ALL SNOW T HIS EVENING - HEAVIEST SNOW IS EXPECTED THIS EVENING AND LI GHT ADDT'L ACCUMULATIONS ARE EXPECTED OVERNIGHT PAGE SENT 
F-LIFT ASSIST LOCATION: 7091 ELLENRIDGE D R FRANKLIN TWP BETWEEN GLENDELL DR / DEAD END COMMENTS: JEM S ON SCENE REQ ENGINE FOR LIFT ASSIST 
F-LIFT ASSIST LOCATION: 35 BOULDER DR FRA NKLIN BETWEEN EMERALD WAY / EMERALD WAY COMMENTS: 66 YO FEM ALE FELL NO INJURIES JUST NEEDS LIFT ASSIST/ KEY ON PORCH U NDER A CAT 
F-FALL / INJURUES LOCATION: 35 BOULDER DR FRANKLIN BETWEEN EMERALD WAY / EMERALD WAY COMMENTS: 66 YO FEMALE FELL NO INJURIES JUST NEEDS LIFT ASSIST/ KEY ON POR CH UNDER A CAT 
F-NOTIFICATION LOCATION: 400 ANDERSON ST FRANKLIN BETWEEN EAST ST / E 4TH ST COMMENTS: WINTER STORM WARNING IN EFFECT FROM 11AM TUESDAY TO 1PM WEDNESDAY/ SNOW A ND SLEET ACCUMULATIONS OF 6-8 INCHES WILL BEGIN LATE TUESDA Y MORNING 
F-UNKNOWN MEDICAL PROBLEM LOCATION: 259 V ICTORY LN FRANKLIN BETWEEN E 2ND ST / CUL DE SAC COMMENTS: X-084.289469 Y+039.561263 CF63 U Z ZUNCMALE WITH ILLNESS 
F-STRUCTURE FIRE LOCATION: S RIVER ST / W 8TH ST FRANKLIN COMMENTS: X-084.306056 Y+039.551124 CF0 U Z ZUNCHOUSE BETWEEN SOU TH POINT AND 8TH 

 */

public class OHFranklinParserTest extends BaseParserTest {
  
  public OHFranklinParserTest() {
    setParser(new OHFranklinParser(), "FRANKLIN", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(CAD) [!] F-STRUCTURE FIRE LOCATION: 818 UNION RD FRANKLIN TWP BETWEEN ROBERTS DR/SHAKER RD COMMENTS: X-084.304747 Y+039.552894 CF95 U ZUNCFIRE IN ATTIC EVERYONE EVACUATED",
        "CALL:F-STRUCTURE FIRE",
        "ADDR:818 UNION RD",
        "CITY:FRANKLIN TWP",
        "X:ROBERTS DR/SHAKER RD",
        "GPS:+39.552894,-84.304747",
        "INFO:CF95 U ZUNCFIRE IN ATTIC EVERYONE EVACUATED");

    doTest("T2",
        "(CAD) [!] F-POLICE ASSIST LOCATION: 235 INDUSTRIAL DR FRANKLIN BETWEEN N SR RT 123/SHAKER RD COMMENTS: VEH STRUCK A POLE/ APPEARS THAT THE WIRES ARE ALL STILL CONNECTED REQ FFD",
        "CALL:F-POLICE ASSIST",
        "ADDR:235 INDUSTRIAL DR",
        "CITY:FRANKLIN",
        "X:N SR RT 123/SHAKER RD",
        "INFO:VEH STRUCK A POLE/ APPEARS THAT THE WIRES ARE ALL STILL CONNECTED REQ FFD");

    doTest("T3",
        "(CAD) [!] F-CARBON MONOXIDE INCIDENT LOCATION: 201 E 2ND ST FRANKLIN BETWEEN LOCUST ST / ALLEN ST COMMENTS: POSSIBLE CO LEAK BY STEPS SO POSSIBLY BASEMENT",
        "CALL:F-CARBON MONOXIDE INCIDENT",
        "ADDR:201 E 2ND ST",
        "CITY:FRANKLIN",
        "X:LOCUST ST / ALLEN ST",
        "INFO:POSSIBLE CO LEAK BY STEPS SO POSSIBLY BASEMENT");

    doTest("T4",
        "(CAD) [!] F-UTILITY POLE-TRANSFORMER FIRE LOCATION: 850 N MAIN ST FRANKLIN BETWEEN KENNETH KOONS BLVD / PENNYROYAL RD COMMENTS; WIRE DOWN / LINE ARCHING",
        "CALL:F-UTILITY POLE-TRANSFORMER FIRE",
        "ADDR:850 N MAIN ST",
        "CITY:FRANKLIN",
        "X:KENNETH KOONS BLVD / PENNYROYAL RD COMMENTS; WIRE DOWN / LINE ARCHING");

    doTest("T5",
        "(CAD) [!] AUTO CRASH/SINGLE ENGINE LOCATION: 36 NB I-75 FRANKLIN BETWEEN SHAKER RD / SR 123 ST COMMENTS: X-084.284963 Y+039.562293 CFO U Z ZUNCSEMI TRUCK CRASHED DUMPING FUEL IN ROADWAY",
        "CALL:AUTO CRASH/SINGLE ENGINE",
        "ADDR:36 NB I-75",
        "MADDR:36 I 75",
        "CITY:FRANKLIN",
        "X:SHAKER RD / SR 123 ST",
        "GPS:+39.562293,-84.284963",
        "INFO:CFO U Z ZUNCSEMI TRUCK CRASHED DUMPING FUEL IN ROADWAY");

    doTest("T6",
        "(CAD) [!] F-HAZMAT LEAK SPILL NO FIRE LOCATION: 501 SHOTWELL DR FRANKLIN BETWEEN N SR RT 123 / DEAD END COMMENTS: X Y CF U Z ZUNCBOTTLE OF ACCETYLINE LEAKING HEAVILY INSIDE THE BACK OF BUILDING",
        "CALL:F-HAZMAT LEAK SPILL NO FIRE",
        "ADDR:501 SHOTWELL DR",
        "CITY:FRANKLIN",
        "X:N SR RT 123 / DEAD END",
        "INFO:X Y CF U Z ZUNCBOTTLE OF ACCETYLINE LEAKING HEAVILY INSIDE THE BACK OF BUILDING");

    doTest("T7",
        "(CAD) [!] F-OUTDOOR FIRE INVESTIGATION LOCATION: 324 PENNYROYAL RD FRANKLIN TWP BETWEEN CLEARCREEK FRANKLIN RD / HOMESTEAD DR COMMENTS: NEIGHBOR HAVING A VERY LARGE FIRE IN THEIR YARD/ REQ FFD COME CHECK IT",
        "CALL:F-OUTDOOR FIRE INVESTIGATION",
        "ADDR:324 PENNYROYAL RD",
        "CITY:FRANKLIN TWP",
        "X:CLEARCREEK FRANKLIN RD / HOMESTEAD DR",
        "INFO:NEIGHBOR HAVING A VERY LARGE FIRE IN THEIR YARD/ REQ FFD COME CHECK IT");

    doTest("T8",
        "(CAD) [!] F-ANIMAL RESCUE LOCATION: 5709 S DIXIE HWY FRANKLIN COMMENTS: ANIMAL SANCTUARY PERSON IS AT PROPERTY REQ ANIMAL RESCUE FOR POT BELLY PIG ",
        "CALL:F-ANIMAL RESCUE",
        "ADDR:5709 S DIXIE HWY",
        "CITY:FRANKLIN",
        "INFO:ANIMAL SANCTUARY PERSON IS AT PROPERTY REQ ANIMAL RESCUE FOR POT BELLY PIG");

    doTest("T9",
        "(CAD) [!] F-FIRE ALARM LOCATION: 2301 COMMERCE CENTER DR FRANKLIN BETWEEN E 2ND ST / HERITAGE DR COMMENTS: SHOWING ZONE 47 / EMPLOYEE MANUAL PULL",
        "CALL:F-FIRE ALARM",
        "ADDR:2301 COMMERCE CENTER DR",
        "CITY:FRANKLIN",
        "X:E 2ND ST / HERITAGE DR",
        "INFO:SHOWING ZONE 47 / EMPLOYEE MANUAL PULL");

    doTest("T10",
        "(CAD) [!] F-GENERAL RECALL LOCATION: 45 E 4TH ST FRANKLIN BETWEEN RILEY ST / ANDERSON ST",
        "CALL:F-GENERAL RECALL",
        "ADDR:45 E 4TH ST",
        "CITY:FRANKLIN",
        "X:RILEY ST / ANDERSON ST");

    doTest("T11",
        "(CAD) [!] AUTO CRASH WITH ENTRAPMENT LOCATION: 38 NB I-75 FRANKLIN BETWEEN SR 123 / SR 73 COMMENTS: X-084.261703 Y+039.568226 CF0 U Z ZUNC",
        "CALL:AUTO CRASH WITH ENTRAPMENT",
        "ADDR:38 NB I-75",
        "MADDR:38 I 75",
        "CITY:FRANKLIN",
        "X:SR 123 / SR 73",
        "GPS:+39.568226,-84.261703",
        "INFO:CF0 U Z ZUNC");
       

    doTest("T12",
        "(CAD) [!] PRIVATE PROPERTY ACCIDENT W/ INJURY LOCATION: 8201 CLAUDE THOMAS RD FRANKLIN BETWEEN COMMERCE CENTER DR / DEAD END DR COMMENTS: PPA W/ INJURY",
        "CALL:PRIVATE PROPERTY ACCIDENT W/ INJURY",
        "ADDR:8201 CLAUDE THOMAS RD",
        "CITY:FRANKLIN",
        "X:COMMERCE CENTER DR / DEAD END DR",
        "INFO:PPA W/ INJURY");

    doTest("T13",
        "(CAD) [!] F-FIRE ALARM LOCATION: 228 S MAIN ST FRANKLIN BETWEEN E 2ND ST / E 3RD ST",
        "CALL:F-FIRE ALARM",
        "ADDR:228 S MAIN ST",
        "CITY:FRANKLIN",
        "X:E 2ND ST / E 3RD ST");
  }
  
  @Test
  public void testCityOfFranklin() {

    doTest("T1",
        "F-STRUCTURE FIRE LOCATION: 216 COLUMUBS L EBANON COMMENTS: ENGINE FOR STRUCTURE FIRE MONROE RD TO CO LUMBUS TAC 3 ",
        "CALL:F-STRUCTURE FIRE",
        "ADDR:216 COLUMUBS",
        "CITY:LEBANON",
        "INFO:ENGINE FOR STRUCTURE FIRE MONROE RD TO CO LUMBUS TAC 3");

    doTest("T2",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 319 E 4TH ST FRANKLIN BETWEEN HILL AVE / SUNNYBROOK DR C OMMENTS: WIRE ON THE GROUND BETWEEN PROPERTIES ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:319 E 4TH ST",
        "CITY:FRANKLIN",
        "X:HILL AVE / SUNNYBROOK DR",
        "INFO:WIRE ON THE GROUND BETWEEN: PROPERTIES");

    doTest("T3",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: N MAIN ST / WARREN AV FRANKLIN COMMENTS: LINE DOWN, ON SI DEWALK AND THE STREET ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:N MAIN ST & WARREN AV",
        "MADDR:N MAIN ST & WARREN AVE",
        "CITY:FRANKLIN",
        "INFO:LINE DOWN, ON SI DEWALK AND THE STREET");

    doTest("T4",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 118 MORGAN CT FRANKLIN BETWEEN VICTORIA DR / CUL DE SAC COMMENTS: LOW HANGING WIRES ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:118 MORGAN CT",
        "CITY:FRANKLIN",
        "X:VICTORIA DR / CUL DE SAC",
        "INFO:LOW HANGING WIRES");

    doTest("T5",
        "TEST TEST TEST/PHONE LOCATION: 523 S RILEY BLVD FRANKLIN BETWEEN E 5TH  \n" +
        "ST / E 6TH ST COMMENTS: WIRE JUST FELL IN FRONT OF RESIDENCE ",

        "CALL:TEST TEST TEST/PHONE",
        "ADDR:523 S RILEY BLVD",
        "CITY:FRANKLIN",
        "X:E 5TH  \nST / E 6TH ST",
        "INFO:WIRE JUST FELL IN FRONT OF RESIDENCE");

    doTest("T6",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 523 S RILEY BLVD FRANKLIN BETWEEN E 5TH ST / E 6TH ST CO MMENTS: WIRE JUST FELL IN FRONT OF RESIDENCE ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:523 S RILEY BLVD",
        "CITY:FRANKLIN",
        "X:E 5TH ST / E 6TH ST",
        "INFO:WIRE JUST FELL IN FRONT OF RESIDENCE");

    doTest("T7",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 523 S RILEY BLVD FRANKLIN BETWEEN E 5TH ST / E 6TH ST ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:523 S RILEY BLVD",
        "CITY:FRANKLIN",
        "X:E 5TH ST / E 6TH ST");

    doTest("T8",
        "F-ABDOMINAL PAIN LOCATION: 622 LAKE AV FR ANKLIN BETWEEN CHESTNUT ST / CEDAR ST COMMENTS: X Y CF U Z ZUNC79 YO F STOMACH PAIN / SP BRAIN SURGERY REQ TR TO KETTERING ",
        "CALL:F-ABDOMINAL PAIN",
        "ADDR:622 LAKE AV",
        "MADDR:622 LAKE AVE",
        "CITY:FRANKLIN",
        "X:CHESTNUT ST / CEDAR ST",
        "INFO:X Y CF U Z ZUNC79 YO F STOMACH PAIN / SP BRAIN SURGERY REQ TR TO KETTERING");

    doTest("T9",
        "F-SERVICE CALL LOCATION: 7600 SHARTS RD F RANKLIN TWP BETWEEN KENNY LN / SPRINBORO LIMITS tree dow n blocking road ",
        "CALL:F-SERVICE CALL",
        "ADDR:7600 SHARTS RD",
        "CITY:FRANKLIN TWP",
        "X:KENNY LN / SPRINBORO LIMITS tree dow n blocking road");

    doTest("T10",
        "F-VEHICLE FIRE LOCATION: 222 E BRYANT AV FRANKLIN BETWEEN LARRY DR / JUDY DR COMMENTS: X Y CF U Z ZUNC ",
        "CALL:F-VEHICLE FIRE",
        "ADDR:222 E BRYANT AV",
        "MADDR:222 E BRYANT AVE",
        "CITY:FRANKLIN",
        "X:LARRY DR / JUDY DR",
        "INFO:X Y CF U Z ZUNC");

    doTest("T11",
        "F-VEHICLE FIRE LOCATION: 227 E BRYANT AV FRANKLIN BETWEEN LARRY DR / JUDY DR ",
        "CALL:F-VEHICLE FIRE",
        "ADDR:227 E BRYANT AV",
        "MADDR:227 E BRYANT AVE",
        "CITY:FRANKLIN",
        "X:LARRY DR / JUDY DR");

    doTest("T12",
        "F-UNKNOWN MEDICAL PROBLEM LOCATION: 519 A NDERSON ST FRANKLIN BETWEEN E 5TH ST / E 6TH ST 71 yoa m ale feeling faint ",
        "CALL:F-UNKNOWN MEDICAL PROBLEM",
        "ADDR:519 ANDERSON ST",
        "CITY:FRANKLIN",
        "X:E 5TH ST / E 6TH ST 71 yoa m ale feeling faint");

    doTest("T13",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 1200 S RIVER ST FRANKLIN BETWEEN BROWN ST / DEAD END ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:1200 S RIVER ST",
        "CITY:FRANKLIN",
        "X:BROWN ST / DEAD END");

    doTest("T14",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: SYCAMORE ST / PARK AV FRANKLIN ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:SYCAMORE ST & PARK AV",
        "MADDR:SYCAMORE ST & PARK AVE",
        "CITY:FRANKLIN");

    doTest("T15",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 804 HARRISON AV FRANKLIN BETWEEN ROBERTS AVE / DEAD END ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:804 HARRISON AV",
        "MADDR:804 HARRISON AVE",
        "CITY:FRANKLIN",
        "X:ROBERTS AVE / DEAD END");

    doTest("T16",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 7263 MENTZ RD FRANKLIN TWP BETWEEN SHAKER RD / SHAKER RD COMMENTS: WIRES DOWN IN THE ROADWAY ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:7263 MENTZ RD",
        "CITY:FRANKLIN TWP",
        "X:SHAKER RD / SHAKER RD",
        "INFO:WIRES DOWN IN THE ROADWAY");

    doTest("T17",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: UNION RD / SHAKER RD FRANKLIN TWP COMMENTS: X-084.306657 Y+039.531447 CF90 U Z ZUN CNEAR THE CURVE PAST SHAKER MEADOWS - TX THE CALLER TO WC CC ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:UNION RD & SHAKER RD",
        "CITY:FRANKLIN TWP",
        "GPS:+39.531447,-84.306657",
        "INFO:CF90 U Z ZUN CNEAR THE CURVE PAST SHAKER MEADOWS - TX THE CALLER TO WC CC");

    doTest("T18",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 32 E 4TH ST FRANKLIN BETWEEN S MAIN ST / S RILEY BLVD CO MMENTS: WIRE HANGING IN HER FRONT YARD- POLE TO HOUSE ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:32 E 4TH ST",
        "CITY:FRANKLIN",
        "X:S MAIN ST / S RILEY BLVD",
        "INFO:WIRE HANGING IN HER FRONT YARD- POLE TO HOUSE");

    doTest("T19",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: PENNYROYAL RD / N DIXIE HWY FRANKLIN TWP COMMENTS: WIRES ACROSS THE ROADWAY ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:PENNYROYAL RD & N DIXIE HWY",
        "CITY:FRANKLIN TWP",
        "INFO:WIRES ACROSS THE ROADWAY");

    doTest("T20",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 9999 LAKE AV FRANKLIN COMMENTS: ON THE HILL THAT GOES OVE R THE LEVYTORE DOWN SOME CABLE OR PHONE WIRES ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:9999 LAKE AV",
        "MADDR:9999 LAKE AVE",
        "CITY:FRANKLIN",
        "INFO:ON THE HILL THAT GOES OVE R THE LEVYTORE DOWN SOME CABLE OR PHONE WIRES");

    doTest("T21",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: LAKE AV / ELM ST FRANKLIN COMMENTS: WIRE DOWN ACROSS THE ROADWAY ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:LAKE AV & ELM ST",
        "MADDR:LAKE AVE & ELM ST",
        "CITY:FRANKLIN",
        "INFO:WIRE DOWN ACROSS THE ROADWAY");

    doTest("T22",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 43 MIAMI AV FRANKLIN BETWEEN CARLISLE LIMITS / LAKE AVE COMMENTS: TREE TOOK DOWN A LINE ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:43 MIAMI AV",
        "MADDR:43 MIAMI AVE",
        "CITY:FRANKLIN",
        "X:CARLISLE LIMITS / LAKE AVE",
        "INFO:TREE TOOK DOWN A LINE");

    doTest("T23",
        "F-WIRES DOWN-ELECTRIC/CABLE/PHONE LOCATIO N: 9999 N CHESTNUT ST FRANKLIN COMMENTS: CROSS OF LAKE AND S PRINGWIRES DOWN IN THE ROADWAY ",
        "CALL:F-WIRES DOWN-ELECTRIC/CABLE/PHONE",
        "ADDR:9999 N CHESTNUT ST",
        "CITY:FRANKLIN",
        "INFO:CROSS OF LAKE AND S PRINGWIRES DOWN IN THE ROADWAY");

    doTest("T24",
        "F-FLUSH FUEL / ROADWAY LOCATION: 6901 N S T RT 123 FRANKLIN BETWEEN SPRING DR / I-75 OVERPASS COMMENT S: X Y CF U Z ZUNCDRIVER PULLED LEVER OFF PUMP, GAS LEAKING ",
        "CALL:F-FLUSH FUEL / ROADWAY",
        "ADDR:6901 N S T RT 123",
        "CITY:FRANKLIN",
        "X:SPRING DR / I-75 OVERPASS",
        "INFO:X Y CF U Z ZUNCDRIVER PULLED LEVER OFF PUMP, GAS LEAKING");

    doTest("T25",
        "AUTO CRASH WITH ENTRAPMENT LOCATION: 38 S B I-75 FRANKLIN BETWEEN SR123 / SR73 COMMENTS: BY DAYTON DA ILY NEWS ENTRAPPED IN ROLL OVER BUT NOT INJURED IN FRONT DAYTON DAILY ",
        "CALL:AUTO CRASH WITH ENTRAPMENT",
        "ADDR:38 S B I-75",
        "MADDR:38 S B I 75",
        "CITY:FRANKLIN",
        "X:SR123 / SR73",
        "INFO:BY DAYTON DA ILY NEWS ENTRAPPED IN ROLL OVER BUT NOT INJURED IN FRONT DAYTON DAILY");

    doTest("T26",
        "F-CHEST PAINS / HEART PROBLEMS LOCATION: 1275 E 2ND ST FRANKLIN COMMENTS: X Y CF U Z ZUNCCHEST PAINS 24 YEAR O LD FEMALE IN MANGERS OFFICE ",
        "CALL:F-CHEST PAINS / HEART PROBLEMS",
        "ADDR:1275 E 2ND ST",
        "CITY:FRANKLIN",
        "INFO:X Y CF U Z ZUNCCHEST PAINS 24 YEAR O LD FEMALE IN MANGERS OFFICE");

    doTest("T27",
        "F-NOTIFICATION LOCATION: 45 E 4TH ST FRAN KLIN BETWEEN RILEY ST / ANDERSON ST COMMENTS: WINTER STORM WARNING IN EFFECT FROM 11 AM THIS MORNING TO 1 PM WEDNESDAYSNOW ACCUMULATION OF 4 TO 6 INCHES ALONG WITH SOME SLEET R AIN WILL SPREAD INTO THE AREA THIS MORNING AND WILL IX WITH SNOW LATER IN THE AFTERNOON AND QUICKLY CHANGE TO ALL SNOW T HIS EVENING - HEAVIEST SNOW IS EXPECTED THIS EVENING AND LI GHT ADDT'L ACCUMULATIONS ARE EXPECTED OVERNIGHT PAGE SENT ",
        "CALL:F-NOTIFICATION",
        "ADDR:45 E 4TH ST",
        "CITY:FRANKLIN",
        "X:RILEY ST / ANDERSON ST",
        "INFO:WINTER STORM WARNING IN EFFECT FROM 11 AM THIS MORNING TO 1 PM WEDNESDAYSNOW ACCUMULATION OF 4 TO 6 INCHES ALONG WITH SOME SLEET R AIN WILL SPREAD INTO THE AREA THIS MORNING AND WILL IX WITH SNOW LATER IN THE AFTERNOON AND QUICKLY CHANGE TO ALL SNOW T HIS EVENING - HEAVIEST SNOW IS EXPECTED THIS EVENING AND LI GHT ADDT'L ACCUMULATIONS ARE EXPECTED OVERNIGHT PAGE SENT");

    doTest("T28",
        "F-LIFT ASSIST LOCATION: 7091 ELLENRIDGE D R FRANKLIN TWP BETWEEN GLENDELL DR / DEAD END COMMENTS: JEM S ON SCENE REQ ENGINE FOR LIFT ASSIST ",
        "CALL:F-LIFT ASSIST",
        "ADDR:7091 ELLENRIDGE DR",
        "CITY:FRANKLIN TWP",
        "X:GLENDELL DR / DEAD END",
        "INFO:JEM S ON SCENE REQ ENGINE FOR LIFT ASSIST");

    doTest("T29",
        "F-LIFT ASSIST LOCATION: 35 BOULDER DR FRA NKLIN BETWEEN EMERALD WAY / EMERALD WAY COMMENTS: 66 YO FEM ALE FELL NO INJURIES JUST NEEDS LIFT ASSIST/ KEY ON PORCH U NDER A CAT ",
        "CALL:F-LIFT ASSIST",
        "ADDR:35 BOULDER DR",
        "CITY:FRANKLIN",
        "X:EMERALD WAY / EMERALD WAY",
        "INFO:66 YO FEM ALE FELL NO INJURIES JUST NEEDS LIFT ASSIST/ KEY ON PORCH U NDER A CAT");

    doTest("T30",
        "F-FALL / INJURUES LOCATION: 35 BOULDER DR FRANKLIN BETWEEN EMERALD WAY / EMERALD WAY COMMENTS: 66 YO FEMALE FELL NO INJURIES JUST NEEDS LIFT ASSIST/ KEY ON POR CH UNDER A CAT ",
        "CALL:F-FALL / INJURUES",
        "ADDR:35 BOULDER DR",
        "CITY:FRANKLIN",
        "X:EMERALD WAY / EMERALD WAY",
        "INFO:66 YO FEMALE FELL NO INJURIES JUST NEEDS LIFT ASSIST/ KEY ON POR CH UNDER A CAT");

    doTest("T31",
        "F-NOTIFICATION LOCATION: 400 ANDERSON ST FRANKLIN BETWEEN EAST ST / E 4TH ST COMMENTS: WINTER STORM WARNING IN EFFECT FROM 11AM TUESDAY TO 1PM WEDNESDAY/ SNOW A ND SLEET ACCUMULATIONS OF 6-8 INCHES WILL BEGIN LATE TUESDA Y MORNING ",
        "CALL:F-NOTIFICATION",
        "ADDR:400 ANDERSON ST",
        "CITY:FRANKLIN",
        "X:EAST ST / E 4TH ST",
        "INFO:WINTER STORM WARNING IN EFFECT FROM 11AM TUESDAY TO 1PM WEDNESDAY/ SNOW A ND SLEET ACCUMULATIONS OF 6-8 INCHES WILL BEGIN LATE TUESDA Y MORNING");

    doTest("T32",
        "F-UNKNOWN MEDICAL PROBLEM LOCATION: 259 V ICTORY LN FRANKLIN BETWEEN E 2ND ST / CUL DE SAC COMMENTS: X-084.289469 Y+039.561263 CF63 U Z ZUNCMALE WITH ILLNESS ",
        "CALL:F-UNKNOWN MEDICAL PROBLEM",
        "ADDR:259 VICTORY LN",
        "CITY:FRANKLIN",
        "X:E 2ND ST / CUL DE SAC",
        "GPS:+39.561263,-84.289469",
        "INFO:CF63 U Z ZUNCMALE WITH ILLNESS");

    doTest("T33",
        "F-STRUCTURE FIRE LOCATION: S RIVER ST / W 8TH ST FRANKLIN COMMENTS: X-084.306056 Y+039.551124 CF0 U Z ZUNCHOUSE BETWEEN SOU TH POINT AND 8TH ",
        "CALL:F-STRUCTURE FIRE",
        "ADDR:S RIVER ST & W 8TH ST",
        "CITY:FRANKLIN",
        "GPS:+39.551124,-84.306056",
        "INFO:CF0 U Z ZUNCHOUSE BETWEEN: SOU TH POINT AND 8TH");
 
  }
  
  public static void main(String[] args) {
    new OHFranklinParserTest().generateTests("T1");
  }
}