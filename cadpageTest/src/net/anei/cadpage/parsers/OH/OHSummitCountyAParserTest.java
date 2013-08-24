package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Wadsworth, OH (in Medina County)
System: Sundance
Contact: Ralph Copley <rcopley@wadsworthcity.org>
Sender: info@sundance-sys.com
(From: WadsTextSender) 0,,COLLEGE/MAIN,WADSWORTHMVA,MVA (EMS) (INJURY)MVA...NECK PAIN
(From: WadsTextSender) 194,BALDWIN ST,,WADSWORTH  HART,HEART67 YOF CHEST PAINS
(From: WadsTextSender) 250,SMOKERISE DR,LIBERTY RESIDENCE,WADSWORTHPAIN,PAINRM 124   STOMACH PAIN   LIBERTY ONE
(From: WadsTextSender) 230,GREAT OAKS TR,101WHITE OAK VILLAGE,WADSWORTHASST,INV. ASSIST80 YOF GENERAL PAIN / NOT FEELING WELL / PMHX CVA - MEDICAL ALARM
(From: WadsTextSender) 295,WALL RD,,WADSWORTH  GRAS,GRASS/TREE/BRUSH FIRESGRASS FIRE
(From: WadsTextSender) 269,E WALNUT ,,WADSWORTH WEAK,WEAKNESSFEMALE WEAK / HISTORY OF STROKES

Contact: Dave Cleckner <dcleckner@gmail.com>
(From: WadsTextSender) 100,HIGH ST,,WADSWORTH  PAIN,PAINFEMALE CHEST PAIN 66 YOF

Summit County, OH
Contact: Active911
Agency name: Bath Fire Department Location: Bath, OH 
Sender: alerts@inspironlogistics.com

(Alert Notification) 1246,Cleve-Mass Rd (N),BATH ELEMENTARY SCHOOL,AKRONF13,SERVICE CALL DISP, S1D1 TEST PAGE DO NOT RESPOND<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 2075,Glengary Rd,,Akron 1,ABDOMINAL PROBLEMS 12, S1D256 YOF ABDOMINAL PAIN<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 4894,Everett Rd,,Akron 26,SICK PERSON DISP, S1D1 USE GARAGE DOOR ProQA - 66 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis).<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 3535,Granger Rd,GHENT FAMILY PRACTICE,Bath6,BREATHING PROBLEMS 12, S1D36 YOF DIFF BREATING<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 4321,Granger Rd,Poor, Joseph A,Bath17,FALLS DISP, S1D3 ELDERLY MALE C/B HEAD INJURY W/BLEEDING ProQA - 70 year old, Male, Conscious, Breathing. Falls.<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 826,Cleve-Mass Rd (N),LANNINGS RESTAURANT,Bath31,UNCONSCIOUS / FAINTING DISP, S1D357 yof passing out c/b at this time ProQA - 57 year old, Female, Conscious, B<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 195,Provence Pointe,,Akron 32,UNKNOWN PROBLEM DISP, S2D3 ProQA - 76 year old, Male, Conscious, Breathing. Unknown Problem (Man Down).<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 602,Highlands Dr,,Akron F13,SERVICE CALL DISP, S1D4CO dector going off<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 3465,Green Dr,Sutherland, Richard/Beverly,Bath26,SICK PERSON DISP, S2D4 82 YOM DIZZY SPELLS DR IS CONCERNED<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 2563,Olentangy Dr,,Akron F13,SERVICE CALL DISP, S1D4ODOR INVESTIGATION - SMELLS LIKE BURNING WIRES<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 2563,Olentangy Dr,,Akron F13,SERVICE CALL DISP, S1D4ODOR INVESTIGATION - SMELLS LIKE BURNING WIRES<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 101,Cleve-Mass Rd (N),BROOKDALE SENIOR LIVING,BathF13CD,COMMERCIAL ALARM DROP DISP, S2D4 general drop<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 0,Norton City,NORTON CITY,BathF14,REPORT TO STATION DISP, S1D3Tender request 3428 Wadsworth Rd<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 0,Copley Township,COPLEY TOWNSHIP,COPLEYF13ARC,AUTO RESPONSE - COPLEY DISP, S1D3 734 SALISBURY WAY STOVE FIRE<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 4455,Granger Rd,Brown, Patricia A,Bath26,SICK PERSON 12, S1D363 YOF POST SURGERY LEG SWELLING<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 3420,Everett Rd,REVERE HIGH SCHOOL,Bath30,TRAUMATIC INJURY 12, S1D2football field. dislocated shoulder ProQA - 15 year old, Male, Conscious, Breathing. Trauma<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 101,Cleve-Mass Rd (N),BROOKDALE SENIOR LIVING,Bath26,SICK PERSON DISP, S2D4 79 YOF C/B VERY THIN BLOOD COUNT (WARFARIN) ProQA - 79 year old, Female, Conscious,<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 250,Cleve-Mass Rd (N),INFOCISION 250 CMR,Bath6,BREATHING PROBLEMS 12, S2D330 YOM BREATHING DIFF. USE FRONT DOOR<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 4765,Ranchwood Rd,,Akron F40,SPECIAL DETAIL - INVALID ASSIST DISP, S1D3MEDICAL ALARM. INVALID ASSIST. NO INJURY. KEY ON PORCH IN THERMOMETER. MEDICAL ON REFRI<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 5091,Tulip Dr,,Akron F13AD,RESIDENTIAL ALARM DROP DISP, S2D3Fire alarm R-1502 S-1503 Owner: Larry Saltis ps<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 4025,North Shore Dr,,Akron F40,SPECIAL DETAIL - INVALID ASSIST DISP, S2D384 yr old male<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 3864,Bath Rd (W),BATH TOWNSHIP SAFETY BUILDING,BathF25,WEATHER ADVISORY 1256 WEEKLY TONES AND TEXTING TEST<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 0,Copley Township,COPLEY TOWNSHIP,COPLEYF13ARC,AUTO RESPONSE - COPLEY DISP, S1D34387 WEDGEWOOD - STOVE EXPLOSION<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 0,Copley Township,COPLEY TOWNSHIP,COPLEYF13ARC,AUTO RESPONSE - COPLEY 12214387 WEDGEWOOD - STOVE EXPLOSION<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 0,2800-B YELLOW CREEK RD,2800-B YELLOW CREEK RD,Bath29,TRAFFIC ACCIDENT DISP, S1D4CRASH UNK INJURY<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 0,1000-B CLEVE-MASS RD (N),1000-B CLEVE-MASS RD (N),Akron29,TRAFFIC ACCIDENT DISP, S1D3MULTI VEHICLE ACCIDENT<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 4263,Derrwood Dr,,Akron F13AD,RESIDENTIAL ALARM DROP 12, S1D1BASEMENT SMOKE R-1428 S-1430 330-664-0602<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 1992,Kemery Rd,,Akron 10,CHEST PAIN 12, S1D252 YOM CHEST PAIN<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 101,Cleve-Mass Rd (N),BROOKDALE SENIOR LIVING,Bath10,CHEST PAIN DISP, S2D4 ProQA - 79 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic).<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 1588,Hametown Rd (N),Nichols, Amy Jean,BathF90,NO ADDITIONAL MANPOWER DISP, S1D1CO DET - NO FURTHER<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 900,Ghent Ridge Dr,Parhizgar, Shahrokh,Bath1,ABDOMINAL PROBLEMS 12, S1D370 YOM ABDOMINAL PAIN - SUNROOM DOOR<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 4765,Ranchwood Rd,,Akron F40,SPECIAL DETAIL - INVALID ASSIST DISP, S1D3<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 101,Cleve-Mass Rd (N),BROOKDALE SENIOR LIVING,Bath26,SICK PERSON DISP, S2D476 YOM ROOM 326 ProQA - 76 year old, Male, Conscious, Breathing. Sick Person (Speci<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 3977,Medina Rd,JO ANN STORE INC,BathF13CD,COMMERCIAL ALARM DROP DISP, S2D3Manual pull dock area R:2347 S:2348<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 3925,Embassy Pkwy,CRYSTAL CLINIC EAST,BathF90,NO ADDITIONAL MANPOWER 1212, 1204 1212 HANDLING INVALID ASSIST AND 1210 REMAINS IN SVC<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 4125,Medina Rd,AGMC HEALTH AND WELLNESS CENTER,Bath17,FALLS DISP, S2D3 C/B on ground, collapsed unknown reason ProQA - 70 year old, Male, Consciousness unknow<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 4765,Ranchwood Rd,,Akron F40,SPECIAL DETAIL - INVALID ASSIST DISP, S1D3 Lift Assist - Holtzapple, Bobbie - fell, not hurt or bleeding, needs help getting her<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 1845,Cleve-Mass Rd (N),,Akron 17,FALLS DISP, S1D2 legs gave out in bathroom<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 1318,Partridge Ln,,Akron 6,BREATHING PROBLEMS DISP, S1D2 Not responding properly ProQA - DIFFICULTY SPEAKING BETWEEN BREATHS. 1.She is completely alert (res<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 4875,Arbour Green Dr,,Akron F40,SPECIAL DETAIL - INVALID ASSIST DISP, S2D380 yom stuck on steps<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 0,Fairlawn City,FAIRLAWN CITY,BathF14,REPORT TO STATION 12, S1D4321 CALEDONIA AVE. 89 YOM UNABLE TO VOID BLADDER. MAN AND SQUAD. SANDRUN PKWY AND DURRAN<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 3979,Medina Rd,ACME FRESH MARKET 15,Bath21,HEMORRHAGE / LACERATIONS DISP, S2D3by deli - female bleeding from fall<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 656,Timbercreek Dr,Papich, Kosta,Bath26,SICK PERSON DISP, S1D3 80 YOF UNCONTROLABLE VOMITING ProQA - 80 year old, Female, Conscious, Breathing. Sick Person (S<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) 3864,Bath Rd (W),BATH TOWNSHIP SAFETY BUILDING,AKRONF25,WEATHER ADVISORY 1236 WEEKLY TONES AND TEXT TEST<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.

**NOT IMPLEMENTED **
(From: WadsTextSender) * FireMVA,MVA (EMS) (INJURY) * 0,STATE ROUTE 57/GREENWICH RD, * STATE ROUTE 57/GREENWICH RD,WADSWORTH * MVA W/ INJURIES 3 CARS
(From: WadsTextSender) * EMSWEAK,WEAKNESS * 147,GARFIELD AV, * ALTERCARE,WADSWORTH * PATIENT CODING ON FLOOR IN 400 HALL
(Alert Notification) * bathfire DISREGARD F13ARC,AUTO RESPONSE - COPLEY<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.
(Alert Notification) * bathfireupgrade to full arrest 6,BREATHING PROBLEMS * 250,Cleve-Mass Rd (N), * INFOCISION 250 CMR,Bath * 30 YOM BREATHING DIFF. USE FRONT DOOR<br /><br/>\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.


 */

public class OHSummitCountyAParserTest extends BaseParserTest {
  
  public OHSummitCountyAParserTest() {
    setParser(new OHSummitCountyAParser(), "SUMMIT COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(From: WadsTextSender) 0,,COLLEGE/MAIN,WADSWORTHMVA,MVA (EMS) (INJURY)MVA...NECK PAIN",
        "ADDR:COLLEGE & MAIN",
        "CITY:WADSWORTH",
        "CALL:MVA (EMS) (INJURY)MVA...NECK PAIN");

    doTest("T2",
        "(From: WadsTextSender) 194,BALDWIN ST,,WADSWORTH  HART,HEART67 YOF CHEST PAINS",
        "ADDR:194 BALDWIN ST",
        "CITY:WADSWORTH",
        "CALL:HEART67 YOF CHEST PAINS");

    doTest("T3",
        "(From: WadsTextSender) 250,SMOKERISE DR,LIBERTY RESIDENCE,WADSWORTHPAIN,PAINRM 124   STOMACH PAIN   LIBERTY ONE",
        "ADDR:250 SMOKERISE DR",
        "PLACE:LIBERTY RESIDENCE",
        "CITY:WADSWORTH",
        "CALL:PAINRM 124   STOMACH PAIN   LIBERTY ONE");

    doTest("T4",
        "(From: WadsTextSender) 230,GREAT OAKS TR,101WHITE OAK VILLAGE,WADSWORTHASST,INV. ASSIST80 YOF GENERAL PAIN / NOT FEELING WELL / PMHX CVA - MEDICAL ALARM",
        "ADDR:230 GREAT OAKS TR",
        "PLACE:101WHITE OAK VILLAGE",
        "CITY:WADSWORTH",
        "CALL:INV. ASSIST80 YOF GENERAL PAIN / NOT FEELING WELL / PMHX CVA - MEDICAL ALARM");

    doTest("T5",
        "(From: WadsTextSender) 295,WALL RD,,WADSWORTH  GRAS,GRASS/TREE/BRUSH FIRESGRASS FIRE",
        "ADDR:295 WALL RD",
        "CITY:WADSWORTH",
        "CALL:GRASS/TREE/BRUSH FIRESGRASS FIRE");

    doTest("T6",
        "(From: WadsTextSender) 269,E WALNUT ,,WADSWORTH WEAK,WEAKNESSFEMALE WEAK / HISTORY OF STROKES",
        "ADDR:269 E WALNUT",
        "CITY:WADSWORTH",
        "CALL:WEAKNESSFEMALE WEAK / HISTORY OF STROKES");

    doTest("T7",
        "(From: WadsTextSender) 100,HIGH ST,,WADSWORTH  PAIN,PAINFEMALE CHEST PAIN 66 YOF",
        "ADDR:100 HIGH ST",
        "CITY:WADSWORTH",
        "CALL:PAINFEMALE CHEST PAIN 66 YOF");
  }
  
  @Test
  public void testBathTwp() {

    doTest("T1",
        "(Alert Notification) 1246,Cleve-Mass Rd (N),BATH ELEMENTARY SCHOOL,AKRONF13,SERVICE CALL DISP, S1D1 TEST PAGE DO NOT RESPOND<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:1246 Cleve-Mass Rd (N)",
        "MADDR:1246 N CLEVELAND MASSILON Rd",
        "PLACE:BATH ELEMENTARY SCHOOL",
        "CITY:AKRON",
        "UNIT:F13",
        "CALL:SERVICE CALL DISP",
        "MAP:S1D1",
        "INFO:TEST PAGE DO NOT RESPOND");

    doTest("T2",
        "(Alert Notification) 2075,Glengary Rd,,Akron 1,ABDOMINAL PROBLEMS 12, S1D256 YOF ABDOMINAL PAIN<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:2075 Glengary Rd",
        "CITY:Akron",
        "UNIT:1",
        "CALL:ABDOMINAL PROBLEMS 12",
        "MAP:S1D2",
        "INFO:56 YOF ABDOMINAL PAIN");

    doTest("T3",
        "(Alert Notification) 4894,Everett Rd,,Akron 26,SICK PERSON DISP, S1D1 USE GARAGE DOOR ProQA - 66 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis).<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:4894 Everett Rd",
        "CITY:Akron",
        "UNIT:26",
        "CALL:SICK PERSON DISP",
        "MAP:S1D1",
        "INFO:USE GARAGE DOOR ProQA - 66 year old");

    doTest("T4",
        "(Alert Notification) 3535,Granger Rd,GHENT FAMILY PRACTICE,Bath6,BREATHING PROBLEMS 12, S1D36 YOF DIFF BREATING<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:3535 Granger Rd",
        "PLACE:GHENT FAMILY PRACTICE",
        "CITY:Bath",
        "UNIT:6",
        "CALL:BREATHING PROBLEMS 12",
        "MAP:S1D3",
        "INFO:6 YOF DIFF BREATING");

    doTest("T5",
        "(Alert Notification) 4321,Granger Rd,Poor, Joseph A,Bath17,FALLS DISP, S1D3 ELDERLY MALE C/B HEAD INJURY W/BLEEDING ProQA - 70 year old, Male, Conscious, Breathing. Falls.<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:4321 Granger Rd",
        "NAME:Poor, Joseph A",
        "CITY:Bath",
        "UNIT:17",
        "CALL:FALLS DISP",
        "MAP:S1D3",
        "INFO:ELDERLY MALE C/B HEAD INJURY W/BLEEDING ProQA - 70 year old");

    doTest("T6",
        "(Alert Notification) 826,Cleve-Mass Rd (N),LANNINGS RESTAURANT,Bath31,UNCONSCIOUS / FAINTING DISP, S1D357 yof passing out c/b at this time ProQA - 57 year old, Female, Conscious, B<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:826 Cleve-Mass Rd (N)",
        "MADDR:826 N CLEVELAND MASSILON Rd",
        "PLACE:LANNINGS RESTAURANT",
        "CITY:Bath",
        "UNIT:31",
        "CALL:UNCONSCIOUS / FAINTING DISP",
        "MAP:S1D3",
        "INFO:57 yof passing out c/b at this time ProQA - 57 year old");

    doTest("T7",
        "(Alert Notification) 195,Provence Pointe,,Akron 32,UNKNOWN PROBLEM DISP, S2D3 ProQA - 76 year old, Male, Conscious, Breathing. Unknown Problem (Man Down).<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:195 Provence Pointe",
        "CITY:Akron",
        "UNIT:32",
        "CALL:UNKNOWN PROBLEM DISP",
        "MAP:S2D3",
        "INFO:ProQA - 76 year old");

    doTest("T8",
        "(Alert Notification) 602,Highlands Dr,,Akron F13,SERVICE CALL DISP, S1D4CO dector going off<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:602 Highlands Dr",
        "CITY:Akron",
        "UNIT:F13",
        "CALL:SERVICE CALL DISP",
        "MAP:S1D4",
        "INFO:CO dector going off");

    doTest("T9",
        "(Alert Notification) 3465,Green Dr,Sutherland, Richard/Beverly,Bath26,SICK PERSON DISP, S2D4 82 YOM DIZZY SPELLS DR IS CONCERNED<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:3465 Green Dr",
        "NAME:Sutherland, Richard/Beverly",
        "CITY:Bath",
        "UNIT:26",
        "CALL:SICK PERSON DISP",
        "MAP:S2D4",
        "INFO:82 YOM DIZZY SPELLS DR IS CONCERNED");

    doTest("T10",
        "(Alert Notification) 2563,Olentangy Dr,,Akron F13,SERVICE CALL DISP, S1D4ODOR INVESTIGATION - SMELLS LIKE BURNING WIRES<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:2563 Olentangy Dr",
        "CITY:Akron",
        "UNIT:F13",
        "CALL:SERVICE CALL DISP",
        "MAP:S1D4",
        "INFO:ODOR INVESTIGATION - SMELLS LIKE BURNING WIRES");

    doTest("T11",
        "(Alert Notification) 2563,Olentangy Dr,,Akron F13,SERVICE CALL DISP, S1D4ODOR INVESTIGATION - SMELLS LIKE BURNING WIRES<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:2563 Olentangy Dr",
        "CITY:Akron",
        "UNIT:F13",
        "CALL:SERVICE CALL DISP",
        "MAP:S1D4",
        "INFO:ODOR INVESTIGATION - SMELLS LIKE BURNING WIRES");

    doTest("T12",
        "(Alert Notification) 101,Cleve-Mass Rd (N),BROOKDALE SENIOR LIVING,BathF13CD,COMMERCIAL ALARM DROP DISP, S2D4 general drop<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:101 Cleve-Mass Rd (N)",
        "MADDR:101 N CLEVELAND MASSILON Rd",
        "PLACE:BROOKDALE SENIOR LIVING",
        "CITY:Bath",
        "UNIT:F13CD",
        "CALL:COMMERCIAL ALARM DROP DISP",
        "MAP:S2D4",
        "INFO:general drop");

    doTest("T13",
        "(Alert Notification) 0,Norton City,NORTON CITY,BathF14,REPORT TO STATION DISP, S1D3Tender request 3428 Wadsworth Rd<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:3428 Wadsworth Rd",
        "CITY:Norton",
        "UNIT:F14",
        "CALL:REPORT TO STATION DISP",
        "MAP:S1D3",
        "INFO:Tender request");

    doTest("T14",
        "(Alert Notification) 0,Copley Township,COPLEY TOWNSHIP,COPLEYF13ARC,AUTO RESPONSE - COPLEY DISP, S1D3 734 SALISBURY WAY STOVE FIRE<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:734 SALISBURY WAY",
        "CITY:Copley",
        "UNIT:F13ARC",
        "CALL:AUTO RESPONSE - COPLEY DISP",
        "MAP:S1D3",
        "INFO:STOVE FIRE");

    doTest("T15",
        "(Alert Notification) 4455,Granger Rd,Brown, Patricia A,Bath26,SICK PERSON 12, S1D363 YOF POST SURGERY LEG SWELLING<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:4455 Granger Rd",
        "NAME:Brown, Patricia A",
        "CITY:Bath",
        "UNIT:26",
        "CALL:SICK PERSON 12",
        "MAP:S1D3",
        "INFO:63 YOF POST SURGERY LEG SWELLING");

    doTest("T16",
        "(Alert Notification) 3420,Everett Rd,REVERE HIGH SCHOOL,Bath30,TRAUMATIC INJURY 12, S1D2football field. dislocated shoulder ProQA - 15 year old, Male, Conscious, Breathing. Trauma<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:3420 Everett Rd",
        "PLACE:REVERE HIGH SCHOOL",
        "CITY:Bath",
        "UNIT:30",
        "CALL:TRAUMATIC INJURY 12",
        "MAP:S1D2",
        "INFO:football field. dislocated shoulder ProQA - 15 year old");

    doTest("T17",
        "(Alert Notification) 101,Cleve-Mass Rd (N),BROOKDALE SENIOR LIVING,Bath26,SICK PERSON DISP, S2D4 79 YOF C/B VERY THIN BLOOD COUNT (WARFARIN) ProQA - 79 year old, Female, Conscious,<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:101 Cleve-Mass Rd (N)",
        "MADDR:101 N CLEVELAND MASSILON Rd",
        "PLACE:BROOKDALE SENIOR LIVING",
        "CITY:Bath",
        "UNIT:26",
        "CALL:SICK PERSON DISP",
        "MAP:S2D4",
        "INFO:79 YOF C/B VERY THIN BLOOD COUNT (WARFARIN) ProQA - 79 year old");

    doTest("T18",
        "(Alert Notification) 250,Cleve-Mass Rd (N),INFOCISION 250 CMR,Bath6,BREATHING PROBLEMS 12, S2D330 YOM BREATHING DIFF. USE FRONT DOOR<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:250 Cleve-Mass Rd (N)",
        "MADDR:250 N CLEVELAND MASSILON Rd",
        "PLACE:INFOCISION 250 CMR",
        "CITY:Bath",
        "UNIT:6",
        "CALL:BREATHING PROBLEMS 12",
        "MAP:S2D3",
        "INFO:30 YOM BREATHING DIFF. USE FRONT DOOR");

    doTest("T19",
        "(Alert Notification) 4765,Ranchwood Rd,,Akron F40,SPECIAL DETAIL - INVALID ASSIST DISP, S1D3MEDICAL ALARM. INVALID ASSIST. NO INJURY. KEY ON PORCH IN THERMOMETER. MEDICAL ON REFRI<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:4765 Ranchwood Rd",
        "CITY:Akron",
        "UNIT:F40",
        "CALL:SPECIAL DETAIL - INVALID ASSIST DISP",
        "MAP:S1D3",
        "INFO:MEDICAL ALARM. INVALID ASSIST. NO INJURY. KEY ON PORCH IN THERMOMETER. MEDICAL ON REFRI");

    doTest("T20",
        "(Alert Notification) 5091,Tulip Dr,,Akron F13AD,RESIDENTIAL ALARM DROP DISP, S2D3Fire alarm R-1502 S-1503 Owner: Larry Saltis ps<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:5091 Tulip Dr",
        "CITY:Akron",
        "UNIT:F13AD",
        "CALL:RESIDENTIAL ALARM DROP DISP",
        "MAP:S2D3",
        "INFO:Fire alarm R-1502 S-1503 Owner: Larry Saltis ps");

    doTest("T21",
        "(Alert Notification) 4025,North Shore Dr,,Akron F40,SPECIAL DETAIL - INVALID ASSIST DISP, S2D384 yr old male<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:4025 North Shore Dr",
        "CITY:Akron",
        "UNIT:F40",
        "CALL:SPECIAL DETAIL - INVALID ASSIST DISP",
        "MAP:S2D3",
        "INFO:84 yr old male");

    doTest("T22",
        "(Alert Notification) 3864,Bath Rd (W),BATH TOWNSHIP SAFETY BUILDING,BathF25,WEATHER ADVISORY 1256 WEEKLY TONES AND TEXTING TEST<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:3864 Bath Rd (W)",
        "MADDR:3864 W Bath Rd",
        "PLACE:BATH TOWNSHIP SAFETY BUILDING",
        "CITY:Bath",
        "UNIT:F25",
        "CALL:WEATHER ADVISORY 1256 WEEKLY TONES AND TEXTING TEST");

    doTest("T23",
        "(Alert Notification) 0,Copley Township,COPLEY TOWNSHIP,COPLEYF13ARC,AUTO RESPONSE - COPLEY DISP, S1D34387 WEDGEWOOD - STOVE EXPLOSION<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:4387 WEDGEWOOD",
        "CITY:COPLEY",
        "UNIT:F13ARC",
        "CALL:AUTO RESPONSE - COPLEY DISP",
        "MAP:S1D3",
        "INFO:STOVE EXPLOSION");

    doTest("T24",
        "(Alert Notification) 0,Copley Township,COPLEY TOWNSHIP,COPLEYF13ARC,AUTO RESPONSE - COPLEY 12214387 WEDGEWOOD - STOVE EXPLOSION<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:12214387 WEDGEWOOD - STOVE EXPLOSION",
        "CITY:COPLEY",
        "UNIT:F13ARC",
        "CALL:AUTO RESPONSE - COPLEY");

    doTest("T25",
        "(Alert Notification) 0,2800-B YELLOW CREEK RD,2800-B YELLOW CREEK RD,Bath29,TRAFFIC ACCIDENT DISP, S1D4CRASH UNK INJURY<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:2800-B YELLOW CREEK RD",
        "MADDR:2800 YELLOW CREEK RD",
        "PLACE:2800-B YELLOW CREEK RD",
        "CITY:Bath",
        "UNIT:29",
        "CALL:TRAFFIC ACCIDENT DISP",
        "MAP:S1D4",
        "INFO:CRASH UNK INJURY");

    doTest("T26",
        "(Alert Notification) 0,1000-B CLEVE-MASS RD (N),1000-B CLEVE-MASS RD (N),Akron29,TRAFFIC ACCIDENT DISP, S1D3MULTI VEHICLE ACCIDENT<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:1000-B CLEVE-MASS RD (N)",
        "MADDR:1000 N CLEVELAND MASSILON RD",
        "PLACE:1000-B CLEVE-MASS RD (N)",
        "CITY:Akron",
        "UNIT:29",
        "CALL:TRAFFIC ACCIDENT DISP",
        "MAP:S1D3",
        "INFO:MULTI VEHICLE ACCIDENT");

    doTest("T27",
        "(Alert Notification) 4263,Derrwood Dr,,Akron F13AD,RESIDENTIAL ALARM DROP 12, S1D1BASEMENT SMOKE R-1428 S-1430 330-664-0602<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:4263 Derrwood Dr",
        "CITY:Akron",
        "UNIT:F13AD",
        "CALL:RESIDENTIAL ALARM DROP 12",
        "MAP:S1D1",
        "INFO:BASEMENT SMOKE R-1428 S-1430 330-664-0602");

    doTest("T28",
        "(Alert Notification) 1992,Kemery Rd,,Akron 10,CHEST PAIN 12, S1D252 YOM CHEST PAIN<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:1992 Kemery Rd",
        "CITY:Akron",
        "UNIT:10",
        "CALL:CHEST PAIN 12",
        "MAP:S1D2",
        "INFO:52 YOM CHEST PAIN");

    doTest("T29",
        "(Alert Notification) 101,Cleve-Mass Rd (N),BROOKDALE SENIOR LIVING,Bath10,CHEST PAIN DISP, S2D4 ProQA - 79 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic).<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:101 Cleve-Mass Rd (N)",
        "MADDR:101 N CLEVELAND MASSILON Rd",
        "PLACE:BROOKDALE SENIOR LIVING",
        "CITY:Bath",
        "UNIT:10",
        "CALL:CHEST PAIN DISP",
        "MAP:S2D4",
        "INFO:ProQA - 79 year old");

    doTest("T30",
        "(Alert Notification) 1588,Hametown Rd (N),Nichols, Amy Jean,BathF90,NO ADDITIONAL MANPOWER DISP, S1D1CO DET - NO FURTHER<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:1588 Hametown Rd (N)",
        "MADDR:1588 N Hametown Rd",
        "NAME:Nichols, Amy Jean",
        "CITY:Bath",
        "UNIT:F90",
        "CALL:NO ADDITIONAL MANPOWER DISP",
        "MAP:S1D1",
        "INFO:CO DET - NO FURTHER");

    doTest("T31",
        "(Alert Notification) 900,Ghent Ridge Dr,Parhizgar, Shahrokh,Bath1,ABDOMINAL PROBLEMS 12, S1D370 YOM ABDOMINAL PAIN - SUNROOM DOOR<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:900 Ghent Ridge Dr",
        "NAME:Parhizgar, Shahrokh",
        "CITY:Bath",
        "UNIT:1",
        "CALL:ABDOMINAL PROBLEMS 12",
        "MAP:S1D3",
        "INFO:70 YOM ABDOMINAL PAIN - SUNROOM DOOR");

    doTest("T32",
        "(Alert Notification) 4765,Ranchwood Rd,,Akron F40,SPECIAL DETAIL - INVALID ASSIST DISP, S1D3<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:4765 Ranchwood Rd",
        "CITY:Akron",
        "UNIT:F40",
        "CALL:SPECIAL DETAIL - INVALID ASSIST DISP",
        "MAP:S1D3");

    doTest("T33",
        "(Alert Notification) 101,Cleve-Mass Rd (N),BROOKDALE SENIOR LIVING,Bath26,SICK PERSON DISP, S2D476 YOM ROOM 326 ProQA - 76 year old, Male, Conscious, Breathing. Sick Person (Speci<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:101 Cleve-Mass Rd (N)",
        "MADDR:101 N CLEVELAND MASSILON Rd",
        "PLACE:BROOKDALE SENIOR LIVING",
        "CITY:Bath",
        "UNIT:26",
        "CALL:SICK PERSON DISP",
        "MAP:S2D4",
        "INFO:76 YOM ROOM 326 ProQA - 76 year old");

    doTest("T34",
        "(Alert Notification) 3977,Medina Rd,JO ANN STORE INC,BathF13CD,COMMERCIAL ALARM DROP DISP, S2D3Manual pull dock area R:2347 S:2348<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:3977 Medina Rd",
        "PLACE:JO ANN STORE INC",
        "CITY:Bath",
        "UNIT:F13CD",
        "CALL:COMMERCIAL ALARM DROP DISP",
        "MAP:S2D3",
        "INFO:Manual pull dock area R:2347 S:2348");

    doTest("T35",
        "(Alert Notification) 3925,Embassy Pkwy,CRYSTAL CLINIC EAST,BathF90,NO ADDITIONAL MANPOWER 1212, 1204 1212 HANDLING INVALID ASSIST AND 1210 REMAINS IN SVC<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:3925 Embassy Pkwy",
        "PLACE:CRYSTAL CLINIC EAST",
        "CITY:Bath",
        "UNIT:F90",
        "CALL:NO ADDITIONAL MANPOWER 1212",
        "INFO:1204 1212 HANDLING INVALID ASSIST AND 1210 REMAINS IN SVC");

    doTest("T36",
        "(Alert Notification) 4125,Medina Rd,AGMC HEALTH AND WELLNESS CENTER,Bath17,FALLS DISP, S2D3 C/B on ground, collapsed unknown reason ProQA - 70 year old, Male, Consciousness unknow<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:4125 Medina Rd",
        "PLACE:AGMC HEALTH AND WELLNESS CENTER",
        "CITY:Bath",
        "UNIT:17",
        "CALL:FALLS DISP",
        "MAP:S2D3",
        "INFO:C/B on ground");

    doTest("T37",
        "(Alert Notification) 4765,Ranchwood Rd,,Akron F40,SPECIAL DETAIL - INVALID ASSIST DISP, S1D3 Lift Assist - Holtzapple, Bobbie - fell, not hurt or bleeding, needs help getting her<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:4765 Ranchwood Rd",
        "CITY:Akron",
        "UNIT:F40",
        "CALL:SPECIAL DETAIL - INVALID ASSIST DISP",
        "MAP:S1D3",
        "INFO:Lift Assist - Holtzapple");

    doTest("T38",
        "(Alert Notification) 1845,Cleve-Mass Rd (N),,Akron 17,FALLS DISP, S1D2 legs gave out in bathroom<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:1845 Cleve-Mass Rd (N)",
        "MADDR:1845 N CLEVELAND MASSILON Rd",
        "CITY:Akron",
        "UNIT:17",
        "CALL:FALLS DISP",
        "MAP:S1D2",
        "INFO:legs gave out in bathroom");

    doTest("T39",
        "(Alert Notification) 1318,Partridge Ln,,Akron 6,BREATHING PROBLEMS DISP, S1D2 Not responding properly ProQA - DIFFICULTY SPEAKING BETWEEN BREATHS. 1.She is completely alert (res<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:1318 Partridge Ln",
        "CITY:Akron",
        "UNIT:6",
        "CALL:BREATHING PROBLEMS DISP",
        "MAP:S1D2",
        "INFO:Not responding properly ProQA - DIFFICULTY SPEAKING BETWEEN BREATHS. 1.She is completely alert (res");

    doTest("T40",
        "(Alert Notification) 4875,Arbour Green Dr,,Akron F40,SPECIAL DETAIL - INVALID ASSIST DISP, S2D380 yom stuck on steps<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:4875 Arbour Green Dr",
        "CITY:Akron",
        "UNIT:F40",
        "CALL:SPECIAL DETAIL - INVALID ASSIST DISP",
        "MAP:S2D3",
        "INFO:80 yom stuck on steps");

    doTest("T41",
        "(Alert Notification) 0,Fairlawn City,FAIRLAWN CITY,BathF14,REPORT TO STATION 12, S1D4321 CALEDONIA AVE. 89 YOM UNABLE TO VOID BLADDER. MAN AND SQUAD. SANDRUN PKWY AND DURRAN<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:321 CALEDONIA AVE",  // Google thinks this is CALADONIA AVE
        "CITY:Fairlawn",
        "UNIT:F14",
        "CALL:REPORT TO STATION 12",
        "MAP:S1D4",
        "INFO:89 YOM UNABLE TO VOID BLADDER. MAN AND SQUAD. SANDRUN PKWY AND DURRAN");

    doTest("T42",
        "(Alert Notification) 3979,Medina Rd,ACME FRESH MARKET 15,Bath21,HEMORRHAGE / LACERATIONS DISP, S2D3by deli - female bleeding from fall<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:3979 Medina Rd",
        "PLACE:ACME FRESH MARKET 15",
        "CITY:Bath",
        "UNIT:21",
        "CALL:HEMORRHAGE / LACERATIONS DISP",
        "MAP:S2D3",
        "INFO:by deli - female bleeding from fall");

    doTest("T43",
        "(Alert Notification) 656,Timbercreek Dr,Papich, Kosta,Bath26,SICK PERSON DISP, S1D3 80 YOF UNCONTROLABLE VOMITING ProQA - 80 year old, Female, Conscious, Breathing. Sick Person (S<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:656 Timbercreek Dr",
        "NAME:Papich, Kosta",
        "CITY:Bath",
        "UNIT:26",
        "CALL:SICK PERSON DISP",
        "MAP:S1D3",
        "INFO:80 YOF UNCONTROLABLE VOMITING ProQA - 80 year old");

    doTest("T44",
        "(Alert Notification) 3864,Bath Rd (W),BATH TOWNSHIP SAFETY BUILDING,AKRONF25,WEATHER ADVISORY 1236 WEEKLY TONES AND TEXT TEST<br /><br/>\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.",

        "ADDR:3864 Bath Rd (W)",
        "MADDR:3864 W Bath Rd",
        "PLACE:BATH TOWNSHIP SAFETY BUILDING",
        "CITY:AKRON",
        "UNIT:F25",
        "CALL:WEATHER ADVISORY 1236 WEEKLY TONES AND TEXT TEST");

  }
  
  @Test
  public void testCopleyFire() {
    
  }
  
  public static void main(String[] args) {
    new OHSummitCountyAParserTest().generateTests("T1");
  }
}