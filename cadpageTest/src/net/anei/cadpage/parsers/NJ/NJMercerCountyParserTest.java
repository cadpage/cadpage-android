package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Mercer County, NJ

Contact: Robert Trzepizur <rtrzepizur@yahoo.com>
Sender: noreply_lifecomm@verizon.net
UNIT: 792 ; CALL: Sick Person - ALS ; PLACE: Princeton House ; ADDR: 905 Herrontown Rd ; BLDG: WING 3 ; APT: ; CITY: Princeton Township ; XSTREETS: Dea

Contact: Active911
Agency name: Capital Health
Location: Trenton, NJ, United States
Sender: noreply_lifecomm@verizon.net

11132012-0051953; Disp:12:55; Resp:12:57; Scene:13:12; Depart:13:14; Hosp:13:26; Avail:13:41 (msg12) (#1\r\n
ID: 11132012-0051953; Rec: 12:53; Disp: 12:55; Resp: 12:57; Scene: 13:12; Depart: 13:14; Hosp: 13:26 (msg17) (#1\r\n
UNIT: 795 ; RESPONSE CHECK ;YOU HAVE AN ASSIGNMENT - CONTACT LIFECOMM ; (#1\r\n
UNIT: LS6 ; LATE TURN-AROUND ;PLEASE CALL LIFECOMM WITH YOUR STATUS ; (#1\r\n

UNIT: 794 ; CALL: Seizures - ALS ; PLACE: MC Junior Senior Hig; ADDR: 1050 Edinburg Rd ; BLDG: ; APT: ; CITY: Hamilton ; XSTREETS: Hughes Dr/Dead End ; ID: 11132012-0051953 ; DATE: 11/13; TIME: 12:55; (msg11)\r\n
UNIT: 793 ; CALL: Trauma - ALS ; PLACE: ; ADDR: 23 Bittner Rd ; BLDG: ; APT: ; CITY: Millstone (So) ; XSTREETS: Dead End/Robbins Rd ; ID: 11132012-0051957 ; DATE: 11/13; TIME: 13:37; (msg11)\r\n
UNIT: 793 ; CALL: Stroke/CVA - ALS ; PLACE: ARCADIA NURSING HOME; ADDR: 1503 State Hwy 33 ; BLDG: ; APT: 221B ; CITY: Hamilton ; XSTREETS: Endicott Rd/Crest Ave ; ID: 11132012-0051950 ; DATE: 11/13; TIME: 12:30; (msg11)\r\n
UNIT: 795 ; CALL: Respiratory - ALS ; PLACE: ; ADDR: 50 Centre St ; BLDG: ; APT: 1 ; CITY: Trenton ; XSTREETS: US Hwy 1 N MM 0.55/Ferry St ; ID: 11132012-0051954 ; DATE: 11/13; TIME: 13:05; (msg11)\r\n
UNIT: 791 ; CALL: Bleeding - ALS ; PLACE: ; ADDR: 612 N Olden Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: St Joes Ave/St Joes Ave ; ID: 11132012-0051947 ; DATE: 11/13; TIME: 12:20; (msg11)\r\n
UNIT: 795 ; CALL: Bleeding - ALS ; PLACE: ; ADDR: 612 N Olden Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: St Joes Ave/St Joes Ave ; ID: 11132012-0051947 ; DATE: 11/13; TIME: 12:19; (msg11)\r\n
UNIT: 791 ; CALL: MVC - ALS ; PLACE: ; ADDR: New Village Rd & Baxter Pl ; BLDG: ; APT: ; CITY: West Windsor ; XSTREETS: ; ID: 11132012-0051941 ; DATE: 11/13; TIME: 12:12; (msg11)\r\n
UNIT: 791 ; CALL: Cardiac Arrest ; PLACE: ; ADDR: 735 Southard St ; BLDG: ; APT: FLR ; CITY: Trenton ; XSTREETS: Proctor Ave/Burton Ave ; ID: 11132012-0051934 ; DATE: 11/13; TIME: 11:36; (msg11)\r\n
UNIT: 792 ; CALL: Seizures - ALS ; PLACE: WALMART E.WINDSOR P; ADDR: 839 Us Hwy 130 ; BLDG: ; APT: ; CITY: East Windsor ; XSTREETS: Dead End/STATE HWY 33 ; ID: 11132012-0051931 ; DATE: 11/13; TIME: 11:07; (msg11)\r\n
UNIT: 793 ; CALL: Respiratory - ALS ; PLACE: Hamilton YMCA ; ADDR: 1315 Whitehorse Mercerville Rd ; BLDG: ; APT: ; CITY: Hamilton ; XSTREETS: Justice Samuel Alito Jr Way/De; ID: 11132012-0051925 ; DATE: 11/13; TIME: 10:54; (msg11)\r\n
UNIT: 794 ; CALL: Trauma - ALS ; PLACE: ; ADDR: Deer Run Dr & Monmouth Rd ; BLDG: ; APT: ; CITY: Millstone (So) ; XSTREETS: ; ID: 11132012-0051911 ; DATE: 11/13; TIME: 09:21; (msg11)\r\n
UNIT: 791 ; CALL: Unconscious / Fainting - ALS ; PLACE: PELLETERI HOMES IN ; ADDR: 615 S Clinton Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Elmer St/Mott St ; ID: 11132012-0051924 ; DATE: 11/13; TIME: 10:38; (msg11)\r\n
UNIT: 793 ; CALL: Cardiac - ALS ; PLACE: ; ADDR: 2222 State Hwy 33 ; BLDG: ; APT: Ste H; CITY: Hamilton ; XSTREETS: Limewood Dr/Dead End ; ID: 11132012-0051918 ; DATE: 11/13; TIME: 09:51; (msg11)\r\n
UNIT: 795 ; CALL: Cardiac - ALS ; PLACE: ; ADDR: 636 Hoffman Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Eisenhower Ave/Oliver Ave ; ID: 11132012-0051917 ; DATE: 11/13; TIME: 09:42; (msg11)\r\n
UNIT: 791 ; CALL: Respiratory - ALS ; PLACE: ; ADDR: 84 Sloan Ave ; BLDG: ; APT: FLR ; CITY: Hamilton ; XSTREETS: Saint Clair Ave/Douglas Ave ; ID: 11132012-0051916 ; DATE: 11/13; TIME: 09:35; (msg11)\r\n
UNIT: 795 ; CALL: Cardiac - ALS ; PLACE: Royal Healthgate Nur; ADDR: 1314 Brunswick Ave ; BLDG: ; APT: 219 ; CITY: Trenton ; XSTREETS: Lanning Ave/Plum St ; ID: 11132012-0051910 ; DATE: 11/13; TIME: 09:07; (msg11)\r\n
UNIT: 793 ; CALL: Seizures - ALS ; PLACE: RWJ Wellness Center/; ADDR: 3100 Quakerbridge Rd ; BLDG: ; APT: ; CITY: Hamilton ; XSTREETS: Collins Rd/Brookwood Rd ; ID: 11132012-0051909 ; DATE: 11/13; TIME: 08:54; (msg11)\r\n
UNIT: 791 ; CALL: Unconscious / Fainting - ALS ; PLACE: Bo Robinson ; ADDR: 377 Enterprise Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Dead End/2nd Ave ; ID: 11132012-0051907 ; DATE: 11/13; TIME: 08:35; (msg11)\r\n
UNIT: 793 ; CALL: Unconscious / Fainting - ALS ; PLACE: Bo Robinson ; ADDR: 377 Enterprise Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Dead End/2nd Ave ; ID: 11132012-0051907 ; DATE: 11/13; TIME: 08:33; (msg11)\r\n
UNIT: 795 ; CALL: Respiratory - ALS ; PLACE: ; ADDR: 623 Lamberton St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Federal St/Lexington St ; ID: 11132012-0051906 ; DATE: 11/13; TIME: 08:22; (msg11)\r\n
UNIT: 791 ; CALL: Respiratory - ALS ; PLACE: Dialysis ; ADDR: 40 Fuld St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: New York Ave/Brunswick Ave ; ID: 11132012-0051902 ; DATE: 11/13; TIME: 07:56; (msg11)\r\n
UNIT: 795 ; CALL: Cardiac - ALS ; PLACE: ; ADDR: 911 Country Ln ; BLDG: ; APT: ; CITY: Ewing ; XSTREETS: River Rd/River Rd ; ID: 11132012-0051901 ; DATE: 11/13; TIME: 07:48; (msg11)\r\n
UNIT: 794 ; CALL: Respiratory - ALS ; PLACE: Meadow Lakes Nursing; ADDR: 200 Etra Rd ; BLDG: ; APT: B9 ; CITY: East Windsor ; XSTREETS: Meadow Lk/Ward St ; ID: 11132012-0051894 ; DATE: 11/13; TIME: 05:49; (msg11)\r\n
UNIT: 791 ; CALL: Standby, Fire Inc - Entrapment; PLACE: ; ADDR: 26 Race St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Unnamed Street/Martin Luther K; ID: 11132012-0051892 ; DATE: 11/13; TIME: 05:27; (msg11)\r\n
UNIT: 793 ; CALL: Cardiac - ALS ; PLACE: ; ADDR: 25 Iorio Dr ; BLDG: ; APT: FLR ; CITY: Hamilton ; XSTREETS: Twig Ln/Woodside Ave ; ID: 11132012-0051888 ; DATE: 11/13; TIME: 04:44; (msg11)\r\n
UNIT: CHS 1 ; CALL: Scheduled Transport - BLS ; PLACE: Capital Health - Mer; ADDR: 446 Bellevue Ave ; BLDG: ; APT: SED ; CITY: Trenton ; XSTREETS: Private Road/Bessemer Aly ; ID: 05292013-0024202 ; DATE: 05/29; TIME: 20:43; INFO: [Pick Up][Premise] Any emergency call for a patient inside 446 Bellevue Avenue should be accessed from the employee entrance.,82 KILOS, Any emergency call for a patient inside 446 Bellevue Avenue should be accessed from the employee entrance.
UNIT: CHS 1 ; CALL: Scheduled Transport - BLS ; PLACE: Capital Health Regio; ADDR: 750 Brunswick Ave ; BLDG: ; APT: 276A ; CITY: Trenton ; XSTREETS: Miller St/Fosket St ; ID: 05292013-0024118 ; DATE: 05/29; TIME: 20:02; INFO:
UNIT: CHS 1 ; CALL: Scheduled Transport - BLS ; PLACE: Capital Health Medic; ADDR: 1 CAPITAL WAY ; BLDG: ; APT: 6130 ; CITY: Hopewell Township ; XSTREETS: SCOTCH RD/Dead End ; ID: 05292013-0024117 ; DATE: 05/29; TIME: 19:02; INFO:

Contact: Active911
Agency name: Ewing Ems
Location: Ewing, NJ, United States
Sender: noreply_lifecomm@verizon.net

UNIT: A1391 ; CALL: Fall Victim - BLS ; PLACE: ; ADDR: 10 Shelburne Dr ; BLDG: ; APT: FLR ; CITY: Ewing ; XSTREETS: Ewingville Rd/Stoneham Rd ; ID: 11132012-0051963 ; DATE: 11/13; TIME: 14:14; (msg11)\r\n
UNIT: A1391 ; CALL: Psychiatric Problem ; PLACE: ; ADDR: 123 Mountainview Rd ; BLDG: ; APT: ; CITY: Ewing ; XSTREETS: Tina Dr/Dead End ; ID: 11132012-0051938 ; DATE: 11/13; TIME: 11:52; (msg11)\r\n
UNIT: A1391 ; CALL: Sick Person - BLS ; PLACE: Located behind All's; ADDR: 630 Bear Tavern Rd ; BLDG: ; APT: FLR ; CITY: Ewing ; XSTREETS: W Upper Ferry Rd/Cardinal Dr ; ID: 11132012-0051928 ; DATE: 11/13; TIME: 11:04; (msg11)\r\n
UNIT: A1391 ; CALL: Psychiatric Problem ; PLACE: ; ADDR: 123 Mountainview Rd ; BLDG: ; APT: ; CITY: Ewing ; XSTREETS: Tina Dr/Dead End ; ID: 11132012-0051912 ; DATE: 11/13; TIME: 09:21; (msg11)\r\n
UNIT: A1391 ; CALL: Cardiac - ALS ; PLACE: ; ADDR: 911 Country Ln ; BLDG: ; APT: ; CITY: Ewing ; XSTREETS: River Rd/River Rd ; ID: 11132012-0051901 ; DATE: 11/13; TIME: 07:48; (msg11)\r\n
UNIT: A1391 ; CALL: Choking - BLS ; PLACE: ; ADDR: 442 Masterson Ct ; BLDG: ; APT: ; CITY: Ewing ; XSTREETS: Lower Ferry Rd/Lower Ferry Rd ; ID: 11132012-0051899 ; DATE: 11/13; TIME: 07:15; (msg11)\r\n

Contact: Active911
Agency name: Trenton EMS
Location: Trenton, NJ, United States
Sender: noreply_lifecomm@verizon.net

UNIT: City ; CALL: Sick Person - BLS ; PLACE: ROMAN TOWERS ; ADDR: 620 W State St ; BLDG: ; APT: 10 F ; CITY: Trenton ; XSTREETS: Murray St/Colonial Ave ; ID: 06262013-0028961 ; DATE: 06/26; TIME: 13:28; INFO: 21 Y/O FEMALE HAD AN ABORTION YESTERDAY TODAY IS HAVING ABDOMINAL PAIN,
UNIT:North ; CALL:ADDRESS UPDATE; PLACE: ; ADDR:Mulberry St & Pages Aly ; BLDG: ; APT: ; CITY:Trenton ; ID:06262013-0028957 ; DATE:06/26; TIME:13:10(#1
UNIT: Rescue; CALL: Sick Person - BLS ; PLACE: ROMAN TOWERS ; ADDR: 620 W State St ; BLDG: ; APT: 10 F ; CITY: Trenton ; XSTREETS: Murray St/Colonial Ave ; ID: 06262013-0028961 ; DATE: 06/26; TIME: 13:27; INFO:
UNIT: North ; CALL: Overdose / Poisoning - BLS ; PLACE: ; ADDR: Pages Aly ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Indiana Ave/Dead End ; ID: 06262013-0028957 ; DATE: 06/26; TIME: 13:10; INFO: TRENTON PD 609 989-4170,TRENTON COMM BUREAU,1724,MALE WELL KNOWN TO EMS INTOXICATED LYING DOWN.,
UNIT: City ; CALL: Overdose / Poisoning - BLS ; PLACE: ; ADDR: Pages Aly ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Indiana Ave/Dead End ; ID: 06262013-0028957 ; DATE: 06/26; TIME: 13:10; INFO: TRENTON PD 609 989-4170,TRENTON COMM BUREAU,1724,
UNIT: North ; CALL: Sick Person - BLS ; PLACE: ; ADDR: 26 W Hanover St ; BLDG: ; APT: 312 ; CITY: Trenton ; XSTREETS: Hanover Pl/Barnes St ; ID: 06262013-0028953 ; DATE: 06/26; TIME: 12:36; INFO:
UNIT: Rescue; CALL: Seizures - BLS ; PLACE: MERCER CO ARC ADULT ; ADDR: 801 NEW YORK AVE ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: UNNAMED STREET/PINE ST ; ID: 06262013-0028949 ; DATE: 06/26; TIME: 12:09; INFO: ELDERLY FEMALE H/X OF SEIZURES SINGLE SEIZURE LASTING 2 MINS,
UNIT: City ; CALL: Assault - BLS ; PLACE: ; ADDR: 137 Monmouth St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Monmouth Pl/Unnamed Street ; ID: 06262013-0028948 ; DATE: 06/26; TIME: 12:02; INFO:
UNIT: City ; CALL: Respiratory - ALS ; PLACE: MVC ; ADDR: 225 E State St ; BLDG: ; APT: 7 eas; CITY: Trenton ; XSTREETS: N Montgomery St/N Stockton St ; ID: 06262013-0028941 ; DATE: 06/26; TIME: 11:21; INFO: TRENTON FD 609 989-4000,TRENTON PD 609 989-4170,TRENTON COMM BUREAU,
UNIT: South ; CALL: Eye Injury ; PLACE: ; ADDR: 140 Jersey St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Tremont St/Smith St ; ID: 06262013-0028940 ; DATE: 06/26; TIME: 11:15; INFO: TRENTON PD 609 989-4170,TRENTON COMM BUREAU,1724,
UNIT: Rescue; CALL: Unconscious / Fainting - ALS ; PLACE: ; ADDR: 176 Rosemont Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: N Hermitage Ave/Hoffman Ave ; ID: 06262013-0028936 ; DATE: 06/26; TIME: 10:32; INFO:
UNIT: North ; CALL: Unconscious / Fainting - ALS ; PLACE: ; ADDR: 176 Rosemont Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: N Hermitage Ave/Hoffman Ave ; ID: 06262013-0028936 ; DATE: 06/26; TIME: 10:31; INFO:
UNIT: City ; CALL: Sick Person - BLS ; PLACE: ; ADDR: 136 Locust St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Monmouth St/Chambers St ; ID: 06262013-0028932 ; DATE: 06/26; TIME: 10:18; INFO: TRENTON PD 609 989-4170,TRENTON COMM BUREAU,1724,74 YOM UNABLE TO WALK.......HX OF C/A,
UNIT: City ; CALL: Sick Person - BLS ; PLACE: ; ADDR: 590 New York Ave ; BLDG: ; APT: r-217; CITY: Trenton ; XSTREETS: Unnamed Street/N Olden Ave ; ID: 06262013-0028929 ; DATE: 06/26; TIME: 10:07; INFO:
UNIT: North ; CALL: Unknown / Person Down ; PLACE: ; ADDR: 158 Walnut Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Monmouth St/Chambers St ; ID: 06262013-0028922 ; DATE: 06/26; TIME: 09:13; INFO: Dr's office unable to contact with patient. they requested welfare check.,
UNIT: South ; CALL: Unknown / Person Down ; PLACE: ; ADDR: 158 Walnut Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Monmouth St/Chambers St ; ID: 06262013-0028922 ; DATE: 06/26; TIME: 09:13; INFO:
UNIT: Rescue; CALL: Unconscious / Fainting - ALS ; PLACE: new horizon treatmen; ADDR: 132 Perry St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: N Broad St/N Montgomery St ; ID: 06262013-0028921 ; DATE: 06/26; TIME: 09:10; INFO: Longitude: -074.769167,Latitude: +040.226667,TRENTON CITY PD 609 F1=BUCKS CO 911 PA 215 493-4011 F2=W WINDSOR PD 609 538-9203,55 y/o female unresponsive,,pt may have taken unknown drugs.,
UNIT: North ; CALL: Unconscious / Fainting - ALS ; PLACE: new horizon treatmen; ADDR: 132 Perry St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: N Broad St/N Montgomery St ; ID: 06262013-0028921 ; DATE: 06/26; TIME: 09:09; INFO: Longitude: -074.769167,Latitude: +040.226667,TRENTON CITY PD 609 F1=BUCKS CO 911 PA 215 493-4011 F2=W WINDSOR PD 609 538-9203,55 y/o female unresponsive,,
UNIT: South ; CALL: Respiratory - ALS ; PLACE: ; ADDR: 829 Division St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Rusling St/Woodland St ; ID: 06262013-0028920 ; DATE: 06/26; TIME: 08:50; INFO: Longitude: -074.744750,Latitude: +040.212222,TRENTON CITY PD 609 F1=BUCKS CO 911 PA 215 493-4011 F2=W WINDSOR PD 609 538-9203,
UNIT: North ; CALL: MVC - BLS ; PLACE: ; ADDR: 458 Walnut Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: S Cook Ave/Cuyler Ave ; ID: 06262013-0028919 ; DATE: 06/26; TIME: 08:29; INFO: PT WITH BACK AND LEG PAINS,

 */

public class NJMercerCountyParserTest extends BaseParserTest {
  
  public NJMercerCountyParserTest() {
    setParser(new NJMercerCountyParser(), "MERCER COUNTY", "NJ");
  }
  
  @Test
  public void testRobertTrzepizur() {

    doTest("T1",
        "UNIT: 792 ; CALL: Sick Person - ALS ; PLACE: Princeton House ; ADDR: 905 Herrontown Rd ; BLDG: WING 3 ; APT: ; CITY: Princeton Township ; XSTREETS: Dea",
        "UNIT:792",
        "CALL:Sick Person - ALS",
        "PLACE:Princeton House",
        "ADDR:905 Herrontown Rd",
        "APT:WING 3",
        "CITY:Princeton Township",
        "X:Dea");
  
  }
  
  @Test
  public void testRunReport() {

    doTest("T1",
        "11132012-0051953; Disp:12:55; Resp:12:57; Scene:13:12; Depart:13:14; Hosp:13:26; Avail:13:41 (msg12) (#1\r\n",
        "CALL:RUN REPORT",
        "PLACE:11132012-0051953; Disp:12:55; Resp:12:57; Scene:13:12; Depart:13:14; Hosp:13:26; Avail:13:41 (msg12) (#1");

    doTest("T2",
        "ID: 11132012-0051953; Rec: 12:53; Disp: 12:55; Resp: 12:57; Scene: 13:12; Depart: 13:14; Hosp: 13:26 (msg17) (#1\r\n",
        "CALL:RUN REPORT",
        "PLACE:ID: 11132012-0051953; Rec: 12:53; Disp: 12:55; Resp: 12:57; Scene: 13:12; Depart: 13:14; Hosp: 13:26 (msg17) (#1");

    doTest("T3",
        "UNIT: 795 ; RESPONSE CHECK ;YOU HAVE AN ASSIGNMENT - CONTACT LIFECOMM ; (#1\r\n",
        "CALL:GENERAL ALERT",
        "UNIT:795",
        "PLACE:RESPONSE CHECK ;YOU HAVE AN ASSIGNMENT - CONTACT LIFECOMM ; (#1");

    doTest("T4",
        "UNIT: LS6 ; LATE TURN-AROUND ;PLEASE CALL LIFECOMM WITH YOUR STATUS ; (#1\r\n",
        "UNIT:LS6",
        "CALL:GENERAL ALERT",
        "PLACE:LATE TURN-AROUND ;PLEASE CALL LIFECOMM WITH YOUR STATUS ; (#1");

  }
  
  @Test
  public void testCapitalHealth() {

    doTest("T1",
        "UNIT: 794 ; CALL: Seizures - ALS ; PLACE: MC Junior Senior Hig; ADDR: 1050 Edinburg Rd ; BLDG: ; APT: ; CITY: Hamilton ; XSTREETS: Hughes Dr/Dead End ; ID: 11132012-0051953 ; DATE: 11/13; TIME: 12:55; (msg11)\r\n",
        "UNIT:794",
        "CALL:Seizures - ALS",
        "PLACE:MC Junior Senior Hig",
        "ADDR:1050 Edinburg Rd",
        "CITY:Hamilton",
        "X:Hughes Dr/Dead End",
        "ID:11132012-0051953",
        "DATE:11/13",
        "TIME:12:55");

    doTest("T2",
        "UNIT: 793 ; CALL: Trauma - ALS ; PLACE: ; ADDR: 23 Bittner Rd ; BLDG: ; APT: ; CITY: Millstone (So) ; XSTREETS: Dead End/Robbins Rd ; ID: 11132012-0051957 ; DATE: 11/13; TIME: 13:37; (msg11)\r\n",
        "UNIT:793",
        "CALL:Trauma - ALS",
        "ADDR:23 Bittner Rd",
        "CITY:Millstone (So)",
        "X:Dead End/Robbins Rd",
        "ID:11132012-0051957",
        "DATE:11/13",
        "TIME:13:37");

    doTest("T3",
        "UNIT: 793 ; CALL: Stroke/CVA - ALS ; PLACE: ARCADIA NURSING HOME; ADDR: 1503 State Hwy 33 ; BLDG: ; APT: 221B ; CITY: Hamilton ; XSTREETS: Endicott Rd/Crest Ave ; ID: 11132012-0051950 ; DATE: 11/13; TIME: 12:30; (msg11)\r\n",
        "UNIT:793",
        "CALL:Stroke/CVA - ALS",
        "PLACE:ARCADIA NURSING HOME",
        "ADDR:1503 State Hwy 33",
        "MADDR:1503 STATE 33",
        "APT:221B",
        "CITY:Hamilton",
        "X:Endicott Rd/Crest Ave",
        "ID:11132012-0051950",
        "DATE:11/13",
        "TIME:12:30");

    doTest("T4",
        "UNIT: 795 ; CALL: Respiratory - ALS ; PLACE: ; ADDR: 50 Centre St ; BLDG: ; APT: 1 ; CITY: Trenton ; XSTREETS: US Hwy 1 N MM 0.55/Ferry St ; ID: 11132012-0051954 ; DATE: 11/13; TIME: 13:05; (msg11)\r\n",
        "UNIT:795",
        "CALL:Respiratory - ALS",
        "ADDR:50 Centre St",
        "APT:1",
        "CITY:Trenton",
        "X:US Hwy 1 N MM 0.55/Ferry St",
        "ID:11132012-0051954",
        "DATE:11/13",
        "TIME:13:05");

    doTest("T5",
        "UNIT: 791 ; CALL: Bleeding - ALS ; PLACE: ; ADDR: 612 N Olden Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: St Joes Ave/St Joes Ave ; ID: 11132012-0051947 ; DATE: 11/13; TIME: 12:20; (msg11)\r\n",
        "UNIT:791",
        "CALL:Bleeding - ALS",
        "ADDR:612 N Olden Ave",
        "CITY:Trenton",
        "X:St Joes Ave/St Joes Ave",
        "ID:11132012-0051947",
        "DATE:11/13",
        "TIME:12:20");

    doTest("T6",
        "UNIT: 795 ; CALL: Bleeding - ALS ; PLACE: ; ADDR: 612 N Olden Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: St Joes Ave/St Joes Ave ; ID: 11132012-0051947 ; DATE: 11/13; TIME: 12:19; (msg11)\r\n",
        "UNIT:795",
        "CALL:Bleeding - ALS",
        "ADDR:612 N Olden Ave",
        "CITY:Trenton",
        "X:St Joes Ave/St Joes Ave",
        "ID:11132012-0051947",
        "DATE:11/13",
        "TIME:12:19");

    doTest("T7",
        "UNIT: 791 ; CALL: MVC - ALS ; PLACE: ; ADDR: New Village Rd & Baxter Pl ; BLDG: ; APT: ; CITY: West Windsor ; XSTREETS: ; ID: 11132012-0051941 ; DATE: 11/13; TIME: 12:12; (msg11)\r\n",
        "UNIT:791",
        "CALL:MVC - ALS",
        "ADDR:New Village Rd & Baxter Pl",
        "CITY:West Windsor",
        "ID:11132012-0051941",
        "DATE:11/13",
        "TIME:12:12");

    doTest("T8",
        "UNIT: 791 ; CALL: Cardiac Arrest ; PLACE: ; ADDR: 735 Southard St ; BLDG: ; APT: FLR ; CITY: Trenton ; XSTREETS: Proctor Ave/Burton Ave ; ID: 11132012-0051934 ; DATE: 11/13; TIME: 11:36; (msg11)\r\n",
        "UNIT:791",
        "CALL:Cardiac Arrest",
        "ADDR:735 Southard St",
        "APT:FLR",
        "CITY:Trenton",
        "X:Proctor Ave/Burton Ave",
        "ID:11132012-0051934",
        "DATE:11/13",
        "TIME:11:36");

    doTest("T9",
        "UNIT: 792 ; CALL: Seizures - ALS ; PLACE: WALMART E.WINDSOR P; ADDR: 839 Us Hwy 130 ; BLDG: ; APT: ; CITY: East Windsor ; XSTREETS: Dead End/STATE HWY 33 ; ID: 11132012-0051931 ; DATE: 11/13; TIME: 11:07; (msg11)\r\n",
        "UNIT:792",
        "CALL:Seizures - ALS",
        "PLACE:WALMART E.WINDSOR P",
        "ADDR:839 Us Hwy 130",
        "MADDR:839 US 130",
        "CITY:East Windsor",
        "X:Dead End/STATE HWY 33",
        "ID:11132012-0051931",
        "DATE:11/13",
        "TIME:11:07");

    doTest("T10",
        "UNIT: 793 ; CALL: Respiratory - ALS ; PLACE: Hamilton YMCA ; ADDR: 1315 Whitehorse Mercerville Rd ; BLDG: ; APT: ; CITY: Hamilton ; XSTREETS: Justice Samuel Alito Jr Way/De; ID: 11132012-0051925 ; DATE: 11/13; TIME: 10:54; (msg11)\r\n",
        "UNIT:793",
        "CALL:Respiratory - ALS",
        "PLACE:Hamilton YMCA",
        "ADDR:1315 Whitehorse Mercerville Rd",
        "CITY:Hamilton",
        "X:Justice Samuel Alito Jr Way/De",
        "ID:11132012-0051925",
        "DATE:11/13",
        "TIME:10:54");

    doTest("T11",
        "UNIT: 794 ; CALL: Trauma - ALS ; PLACE: ; ADDR: Deer Run Dr & Monmouth Rd ; BLDG: ; APT: ; CITY: Millstone (So) ; XSTREETS: ; ID: 11132012-0051911 ; DATE: 11/13; TIME: 09:21; (msg11)\r\n",
        "UNIT:794",
        "CALL:Trauma - ALS",
        "ADDR:Deer Run Dr & Monmouth Rd",
        "CITY:Millstone (So)",
        "ID:11132012-0051911",
        "DATE:11/13",
        "TIME:09:21");

    doTest("T12",
        "UNIT: 791 ; CALL: Unconscious / Fainting - ALS ; PLACE: PELLETERI HOMES IN ; ADDR: 615 S Clinton Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Elmer St/Mott St ; ID: 11132012-0051924 ; DATE: 11/13; TIME: 10:38; (msg11)\r\n",
        "UNIT:791",
        "CALL:Unconscious / Fainting - ALS",
        "PLACE:PELLETERI HOMES IN",
        "ADDR:615 S Clinton Ave",
        "CITY:Trenton",
        "X:Elmer St/Mott St",
        "ID:11132012-0051924",
        "DATE:11/13",
        "TIME:10:38");

    doTest("T13",
        "UNIT: 793 ; CALL: Cardiac - ALS ; PLACE: ; ADDR: 2222 State Hwy 33 ; BLDG: ; APT: Ste H; CITY: Hamilton ; XSTREETS: Limewood Dr/Dead End ; ID: 11132012-0051918 ; DATE: 11/13; TIME: 09:51; (msg11)\r\n",
        "UNIT:793",
        "CALL:Cardiac - ALS",
        "ADDR:2222 State Hwy 33",
        "MADDR:2222 STATE 33",
        "APT:Ste H",
        "CITY:Hamilton",
        "X:Limewood Dr/Dead End",
        "ID:11132012-0051918",
        "DATE:11/13",
        "TIME:09:51");

    doTest("T14",
        "UNIT: 795 ; CALL: Cardiac - ALS ; PLACE: ; ADDR: 636 Hoffman Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Eisenhower Ave/Oliver Ave ; ID: 11132012-0051917 ; DATE: 11/13; TIME: 09:42; (msg11)\r\n",
        "UNIT:795",
        "CALL:Cardiac - ALS",
        "ADDR:636 Hoffman Ave",
        "CITY:Trenton",
        "X:Eisenhower Ave/Oliver Ave",
        "ID:11132012-0051917",
        "DATE:11/13",
        "TIME:09:42");

    doTest("T15",
        "UNIT: 791 ; CALL: Respiratory - ALS ; PLACE: ; ADDR: 84 Sloan Ave ; BLDG: ; APT: FLR ; CITY: Hamilton ; XSTREETS: Saint Clair Ave/Douglas Ave ; ID: 11132012-0051916 ; DATE: 11/13; TIME: 09:35; (msg11)\r\n",
        "UNIT:791",
        "CALL:Respiratory - ALS",
        "ADDR:84 Sloan Ave",
        "APT:FLR",
        "CITY:Hamilton",
        "X:Saint Clair Ave/Douglas Ave",
        "ID:11132012-0051916",
        "DATE:11/13",
        "TIME:09:35");

    doTest("T16",
        "UNIT: 795 ; CALL: Cardiac - ALS ; PLACE: Royal Healthgate Nur; ADDR: 1314 Brunswick Ave ; BLDG: ; APT: 219 ; CITY: Trenton ; XSTREETS: Lanning Ave/Plum St ; ID: 11132012-0051910 ; DATE: 11/13; TIME: 09:07; (msg11)\r\n",
        "UNIT:795",
        "CALL:Cardiac - ALS",
        "PLACE:Royal Healthgate Nur",
        "ADDR:1314 Brunswick Ave",
        "APT:219",
        "CITY:Trenton",
        "X:Lanning Ave/Plum St",
        "ID:11132012-0051910",
        "DATE:11/13",
        "TIME:09:07");

    doTest("T17",
        "UNIT: 793 ; CALL: Seizures - ALS ; PLACE: RWJ Wellness Center/; ADDR: 3100 Quakerbridge Rd ; BLDG: ; APT: ; CITY: Hamilton ; XSTREETS: Collins Rd/Brookwood Rd ; ID: 11132012-0051909 ; DATE: 11/13; TIME: 08:54; (msg11)\r\n",
        "UNIT:793",
        "CALL:Seizures - ALS",
        "PLACE:RWJ Wellness Center/",
        "ADDR:3100 Quakerbridge Rd",
        "CITY:Hamilton",
        "X:Collins Rd/Brookwood Rd",
        "ID:11132012-0051909",
        "DATE:11/13",
        "TIME:08:54");

    doTest("T18",
        "UNIT: 791 ; CALL: Unconscious / Fainting - ALS ; PLACE: Bo Robinson ; ADDR: 377 Enterprise Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Dead End/2nd Ave ; ID: 11132012-0051907 ; DATE: 11/13; TIME: 08:35; (msg11)\r\n",
        "UNIT:791",
        "CALL:Unconscious / Fainting - ALS",
        "PLACE:Bo Robinson",
        "ADDR:377 Enterprise Ave",
        "CITY:Trenton",
        "X:Dead End/2nd Ave",
        "ID:11132012-0051907",
        "DATE:11/13",
        "TIME:08:35");

    doTest("T19",
        "UNIT: 793 ; CALL: Unconscious / Fainting - ALS ; PLACE: Bo Robinson ; ADDR: 377 Enterprise Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Dead End/2nd Ave ; ID: 11132012-0051907 ; DATE: 11/13; TIME: 08:33; (msg11)\r\n",
        "UNIT:793",
        "CALL:Unconscious / Fainting - ALS",
        "PLACE:Bo Robinson",
        "ADDR:377 Enterprise Ave",
        "CITY:Trenton",
        "X:Dead End/2nd Ave",
        "ID:11132012-0051907",
        "DATE:11/13",
        "TIME:08:33");

    doTest("T20",
        "UNIT: 795 ; CALL: Respiratory - ALS ; PLACE: ; ADDR: 623 Lamberton St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Federal St/Lexington St ; ID: 11132012-0051906 ; DATE: 11/13; TIME: 08:22; (msg11)\r\n",
        "UNIT:795",
        "CALL:Respiratory - ALS",
        "ADDR:623 Lamberton St",
        "CITY:Trenton",
        "X:Federal St/Lexington St",
        "ID:11132012-0051906",
        "DATE:11/13",
        "TIME:08:22");

    doTest("T21",
        "UNIT: 791 ; CALL: Respiratory - ALS ; PLACE: Dialysis ; ADDR: 40 Fuld St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: New York Ave/Brunswick Ave ; ID: 11132012-0051902 ; DATE: 11/13; TIME: 07:56; (msg11)\r\n",
        "UNIT:791",
        "CALL:Respiratory - ALS",
        "PLACE:Dialysis",
        "ADDR:40 Fuld St",
        "CITY:Trenton",
        "X:New York Ave/Brunswick Ave",
        "ID:11132012-0051902",
        "DATE:11/13",
        "TIME:07:56");

    doTest("T22",
        "UNIT: 795 ; CALL: Cardiac - ALS ; PLACE: ; ADDR: 911 Country Ln ; BLDG: ; APT: ; CITY: Ewing ; XSTREETS: River Rd/River Rd ; ID: 11132012-0051901 ; DATE: 11/13; TIME: 07:48; (msg11)\r\n",
        "UNIT:795",
        "CALL:Cardiac - ALS",
        "ADDR:911 Country Ln",
        "CITY:Ewing",
        "X:River Rd/River Rd",
        "ID:11132012-0051901",
        "DATE:11/13",
        "TIME:07:48");

    doTest("T23",
        "UNIT: 794 ; CALL: Respiratory - ALS ; PLACE: Meadow Lakes Nursing; ADDR: 200 Etra Rd ; BLDG: ; APT: B9 ; CITY: East Windsor ; XSTREETS: Meadow Lk/Ward St ; ID: 11132012-0051894 ; DATE: 11/13; TIME: 05:49; (msg11)\r\n",
        "UNIT:794",
        "CALL:Respiratory - ALS",
        "PLACE:Meadow Lakes Nursing",
        "ADDR:200 Etra Rd",
        "APT:B9",
        "CITY:East Windsor",
        "X:Meadow Lk/Ward St",
        "ID:11132012-0051894",
        "DATE:11/13",
        "TIME:05:49");

    doTest("T24",
        "UNIT: 791 ; CALL: Standby, Fire Inc - Entrapment; PLACE: ; ADDR: 26 Race St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Unnamed Street/Martin Luther K; ID: 11132012-0051892 ; DATE: 11/13; TIME: 05:27; (msg11)\r\n",
        "UNIT:791",
        "CALL:Standby, Fire Inc - Entrapment",
        "ADDR:26 Race St",
        "CITY:Trenton",
        "X:Unnamed Street/Martin Luther K",
        "ID:11132012-0051892",
        "DATE:11/13",
        "TIME:05:27");

    doTest("T25",
        "UNIT: 793 ; CALL: Cardiac - ALS ; PLACE: ; ADDR: 25 Iorio Dr ; BLDG: ; APT: FLR ; CITY: Hamilton ; XSTREETS: Twig Ln/Woodside Ave ; ID: 11132012-0051888 ; DATE: 11/13; TIME: 04:44; (msg11)\r\n",
        "UNIT:793",
        "CALL:Cardiac - ALS",
        "ADDR:25 Iorio Dr",
        "APT:FLR",
        "CITY:Hamilton",
        "X:Twig Ln/Woodside Ave",
        "ID:11132012-0051888",
        "DATE:11/13",
        "TIME:04:44");

  }
  
  @Test
  public void testEwingEMS() {

    doTest("T1",
        "UNIT: A1391 ; CALL: Fall Victim - BLS ; PLACE: ; ADDR: 10 Shelburne Dr ; BLDG: ; APT: FLR ; CITY: Ewing ; XSTREETS: Ewingville Rd/Stoneham Rd ; ID: 11132012-0051963 ; DATE: 11/13; TIME: 14:14; (msg11)\r\n",
        "UNIT:A1391",
        "CALL:Fall Victim - BLS",
        "ADDR:10 Shelburne Dr",
        "APT:FLR",
        "CITY:Ewing",
        "X:Ewingville Rd/Stoneham Rd",
        "ID:11132012-0051963",
        "DATE:11/13",
        "TIME:14:14");

    doTest("T2",
        "UNIT: A1391 ; CALL: Psychiatric Problem ; PLACE: ; ADDR: 123 Mountainview Rd ; BLDG: ; APT: ; CITY: Ewing ; XSTREETS: Tina Dr/Dead End ; ID: 11132012-0051938 ; DATE: 11/13; TIME: 11:52; (msg11)\r\n",
        "UNIT:A1391",
        "CALL:Psychiatric Problem",
        "ADDR:123 Mountainview Rd",
        "CITY:Ewing",
        "X:Tina Dr/Dead End",
        "ID:11132012-0051938",
        "DATE:11/13",
        "TIME:11:52");

    doTest("T3",
        "UNIT: A1391 ; CALL: Sick Person - BLS ; PLACE: Located behind All's; ADDR: 630 Bear Tavern Rd ; BLDG: ; APT: FLR ; CITY: Ewing ; XSTREETS: W Upper Ferry Rd/Cardinal Dr ; ID: 11132012-0051928 ; DATE: 11/13; TIME: 11:04; (msg11)\r\n",
        "UNIT:A1391",
        "CALL:Sick Person - BLS",
        "PLACE:Located behind All's",
        "ADDR:630 Bear Tavern Rd",
        "APT:FLR",
        "CITY:Ewing",
        "X:W Upper Ferry Rd/Cardinal Dr",
        "ID:11132012-0051928",
        "DATE:11/13",
        "TIME:11:04");

    doTest("T4",
        "UNIT: A1391 ; CALL: Psychiatric Problem ; PLACE: ; ADDR: 123 Mountainview Rd ; BLDG: ; APT: ; CITY: Ewing ; XSTREETS: Tina Dr/Dead End ; ID: 11132012-0051912 ; DATE: 11/13; TIME: 09:21; (msg11)\r\n",
        "UNIT:A1391",
        "CALL:Psychiatric Problem",
        "ADDR:123 Mountainview Rd",
        "CITY:Ewing",
        "X:Tina Dr/Dead End",
        "ID:11132012-0051912",
        "DATE:11/13",
        "TIME:09:21");

    doTest("T5",
        "UNIT: A1391 ; CALL: Cardiac - ALS ; PLACE: ; ADDR: 911 Country Ln ; BLDG: ; APT: ; CITY: Ewing ; XSTREETS: River Rd/River Rd ; ID: 11132012-0051901 ; DATE: 11/13; TIME: 07:48; (msg11)\r\n",
        "UNIT:A1391",
        "CALL:Cardiac - ALS",
        "ADDR:911 Country Ln",
        "CITY:Ewing",
        "X:River Rd/River Rd",
        "ID:11132012-0051901",
        "DATE:11/13",
        "TIME:07:48");

    doTest("T6",
        "UNIT: A1391 ; CALL: Choking - BLS ; PLACE: ; ADDR: 442 Masterson Ct ; BLDG: ; APT: ; CITY: Ewing ; XSTREETS: Lower Ferry Rd/Lower Ferry Rd ; ID: 11132012-0051899 ; DATE: 11/13; TIME: 07:15; (msg11)\r\n",
        "UNIT:A1391",
        "CALL:Choking - BLS",
        "ADDR:442 Masterson Ct",
        "CITY:Ewing",
        "X:Lower Ferry Rd/Lower Ferry Rd",
        "ID:11132012-0051899",
        "DATE:11/13",
        "TIME:07:15");

  }
  
  @Test
  public void testTrentonEMS() {

    doTest("T1",
        "UNIT: City ; CALL: Sick Person - BLS ; PLACE: ROMAN TOWERS ; ADDR: 620 W State St ; BLDG: ; APT: 10 F ; CITY: Trenton ; XSTREETS: Murray St/Colonial Ave ; ID: 06262013-0028961 ; DATE: 06/26; TIME: 13:28; INFO: 21 Y/O FEMALE HAD AN ABORTION YESTERDAY TODAY IS HAVING ABDOMINAL PAIN,",
        "UNIT:City",
        "CALL:Sick Person - BLS",
        "PLACE:ROMAN TOWERS",
        "ADDR:620 W State St",
        "APT:10 F",
        "CITY:Trenton",
        "X:Murray St/Colonial Ave",
        "ID:06262013-0028961",
        "DATE:06/26",
        "TIME:13:28",
        "INFO:21 Y/O FEMALE HAD AN ABORTION YESTERDAY TODAY IS HAVING ABDOMINAL PAIN,");

    doTest("T2",
        "UNIT:North ; CALL:ADDRESS UPDATE; PLACE: ; ADDR:Mulberry St & Pages Aly ; BLDG: ; APT: ; CITY:Trenton ; ID:06262013-0028957 ; DATE:06/26; TIME:13:10(#1",
        "UNIT:North",
        "CALL:ADDRESS UPDATE",
        "ADDR:Mulberry St & Pages Aly",
        "CITY:Trenton",
        "ID:06262013-0028957",
        "DATE:06/26",
        "TIME:13:10");

    doTest("T3",
        "UNIT: Rescue; CALL: Sick Person - BLS ; PLACE: ROMAN TOWERS ; ADDR: 620 W State St ; BLDG: ; APT: 10 F ; CITY: Trenton ; XSTREETS: Murray St/Colonial Ave ; ID: 06262013-0028961 ; DATE: 06/26; TIME: 13:27; INFO:",
        "UNIT:Rescue",
        "CALL:Sick Person - BLS",
        "PLACE:ROMAN TOWERS",
        "ADDR:620 W State St",
        "APT:10 F",
        "CITY:Trenton",
        "X:Murray St/Colonial Ave",
        "ID:06262013-0028961",
        "DATE:06/26",
        "TIME:13:27");

    doTest("T4",
        "UNIT: North ; CALL: Overdose / Poisoning - BLS ; PLACE: ; ADDR: Pages Aly ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Indiana Ave/Dead End ; ID: 06262013-0028957 ; DATE: 06/26; TIME: 13:10; INFO: TRENTON PD 609 989-4170,TRENTON COMM BUREAU,1724,MALE WELL KNOWN TO EMS INTOXICATED LYING DOWN.,",
        "UNIT:North",
        "CALL:Overdose / Poisoning - BLS",
        "ADDR:Pages Aly",
        "MADDR:Pages Aly & Indiana Ave",
        "CITY:Trenton",
        "X:Indiana Ave/Dead End",
        "ID:06262013-0028957",
        "DATE:06/26",
        "TIME:13:10",
        "INFO:TRENTON PD 609 989-4170,TRENTON COMM BUREAU,1724,MALE WELL KNOWN TO EMS INTOXICATED LYING DOWN.,");

    doTest("T5",
        "UNIT: City ; CALL: Overdose / Poisoning - BLS ; PLACE: ; ADDR: Pages Aly ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Indiana Ave/Dead End ; ID: 06262013-0028957 ; DATE: 06/26; TIME: 13:10; INFO: TRENTON PD 609 989-4170,TRENTON COMM BUREAU,1724,",
        "UNIT:City",
        "CALL:Overdose / Poisoning - BLS",
        "ADDR:Pages Aly",
        "MADDR:Pages Aly & Indiana Ave",
        "CITY:Trenton",
        "X:Indiana Ave/Dead End",
        "ID:06262013-0028957",
        "DATE:06/26",
        "TIME:13:10",
        "INFO:TRENTON PD 609 989-4170,TRENTON COMM BUREAU,1724,");

    doTest("T6",
        "UNIT: North ; CALL: Sick Person - BLS ; PLACE: ; ADDR: 26 W Hanover St ; BLDG: ; APT: 312 ; CITY: Trenton ; XSTREETS: Hanover Pl/Barnes St ; ID: 06262013-0028953 ; DATE: 06/26; TIME: 12:36; INFO:",
        "UNIT:North",
        "CALL:Sick Person - BLS",
        "ADDR:26 W Hanover St",
        "APT:312",
        "CITY:Trenton",
        "X:Hanover Pl/Barnes St",
        "ID:06262013-0028953",
        "DATE:06/26",
        "TIME:12:36");

    doTest("T7",
        "UNIT: Rescue; CALL: Seizures - BLS ; PLACE: MERCER CO ARC ADULT ; ADDR: 801 NEW YORK AVE ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: UNNAMED STREET/PINE ST ; ID: 06262013-0028949 ; DATE: 06/26; TIME: 12:09; INFO: ELDERLY FEMALE H/X OF SEIZURES SINGLE SEIZURE LASTING 2 MINS,",
        "UNIT:Rescue",
        "CALL:Seizures - BLS",
        "PLACE:MERCER CO ARC ADULT",
        "ADDR:801 NEW YORK AVE",
        "CITY:Trenton",
        "X:UNNAMED STREET/PINE ST",
        "ID:06262013-0028949",
        "DATE:06/26",
        "TIME:12:09",
        "INFO:ELDERLY FEMALE H/X OF SEIZURES SINGLE SEIZURE LASTING 2 MINS,");

    doTest("T8",
        "UNIT: City ; CALL: Assault - BLS ; PLACE: ; ADDR: 137 Monmouth St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Monmouth Pl/Unnamed Street ; ID: 06262013-0028948 ; DATE: 06/26; TIME: 12:02; INFO:",
        "UNIT:City",
        "CALL:Assault - BLS",
        "ADDR:137 Monmouth St",
        "CITY:Trenton",
        "X:Monmouth Pl/Unnamed Street",
        "ID:06262013-0028948",
        "DATE:06/26",
        "TIME:12:02");

    doTest("T9",
        "UNIT: City ; CALL: Respiratory - ALS ; PLACE: MVC ; ADDR: 225 E State St ; BLDG: ; APT: 7 eas; CITY: Trenton ; XSTREETS: N Montgomery St/N Stockton St ; ID: 06262013-0028941 ; DATE: 06/26; TIME: 11:21; INFO: TRENTON FD 609 989-4000,TRENTON PD 609 989-4170,TRENTON COMM BUREAU,",
        "UNIT:City",
        "CALL:Respiratory - ALS",
        "PLACE:MVC",
        "ADDR:225 E State St",
        "APT:7 eas",
        "CITY:Trenton",
        "X:N Montgomery St/N Stockton St",
        "ID:06262013-0028941",
        "DATE:06/26",
        "TIME:11:21",
        "INFO:TRENTON FD 609 989-4000,TRENTON PD 609 989-4170,TRENTON COMM BUREAU,");

    doTest("T10",
        "UNIT: South ; CALL: Eye Injury ; PLACE: ; ADDR: 140 Jersey St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Tremont St/Smith St ; ID: 06262013-0028940 ; DATE: 06/26; TIME: 11:15; INFO: TRENTON PD 609 989-4170,TRENTON COMM BUREAU,1724,",
        "UNIT:South",
        "CALL:Eye Injury",
        "ADDR:140 Jersey St",
        "CITY:Trenton",
        "X:Tremont St/Smith St",
        "ID:06262013-0028940",
        "DATE:06/26",
        "TIME:11:15",
        "INFO:TRENTON PD 609 989-4170,TRENTON COMM BUREAU,1724,");

    doTest("T11",
        "UNIT: Rescue; CALL: Unconscious / Fainting - ALS ; PLACE: ; ADDR: 176 Rosemont Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: N Hermitage Ave/Hoffman Ave ; ID: 06262013-0028936 ; DATE: 06/26; TIME: 10:32; INFO:",
        "UNIT:Rescue",
        "CALL:Unconscious / Fainting - ALS",
        "ADDR:176 Rosemont Ave",
        "CITY:Trenton",
        "X:N Hermitage Ave/Hoffman Ave",
        "ID:06262013-0028936",
        "DATE:06/26",
        "TIME:10:32");

    doTest("T12",
        "UNIT: North ; CALL: Unconscious / Fainting - ALS ; PLACE: ; ADDR: 176 Rosemont Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: N Hermitage Ave/Hoffman Ave ; ID: 06262013-0028936 ; DATE: 06/26; TIME: 10:31; INFO:",
        "UNIT:North",
        "CALL:Unconscious / Fainting - ALS",
        "ADDR:176 Rosemont Ave",
        "CITY:Trenton",
        "X:N Hermitage Ave/Hoffman Ave",
        "ID:06262013-0028936",
        "DATE:06/26",
        "TIME:10:31");

    doTest("T13",
        "UNIT: City ; CALL: Sick Person - BLS ; PLACE: ; ADDR: 136 Locust St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Monmouth St/Chambers St ; ID: 06262013-0028932 ; DATE: 06/26; TIME: 10:18; INFO: TRENTON PD 609 989-4170,TRENTON COMM BUREAU,1724,74 YOM UNABLE TO WALK.......HX OF C/A,",
        "UNIT:City",
        "CALL:Sick Person - BLS",
        "ADDR:136 Locust St",
        "CITY:Trenton",
        "X:Monmouth St/Chambers St",
        "ID:06262013-0028932",
        "DATE:06/26",
        "TIME:10:18",
        "INFO:TRENTON PD 609 989-4170,TRENTON COMM BUREAU,1724,74 YOM UNABLE TO WALK.......HX OF C/A,");

    doTest("T14",
        "UNIT: City ; CALL: Sick Person - BLS ; PLACE: ; ADDR: 590 New York Ave ; BLDG: ; APT: r-217; CITY: Trenton ; XSTREETS: Unnamed Street/N Olden Ave ; ID: 06262013-0028929 ; DATE: 06/26; TIME: 10:07; INFO:",
        "UNIT:City",
        "CALL:Sick Person - BLS",
        "ADDR:590 New York Ave",
        "APT:r-217",
        "CITY:Trenton",
        "X:Unnamed Street/N Olden Ave",
        "ID:06262013-0028929",
        "DATE:06/26",
        "TIME:10:07");

    doTest("T15",
        "UNIT: North ; CALL: Unknown / Person Down ; PLACE: ; ADDR: 158 Walnut Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Monmouth St/Chambers St ; ID: 06262013-0028922 ; DATE: 06/26; TIME: 09:13; INFO: Dr's office unable to contact with patient. they requested welfare check.,",
        "UNIT:North",
        "CALL:Unknown / Person Down",
        "ADDR:158 Walnut Ave",
        "CITY:Trenton",
        "X:Monmouth St/Chambers St",
        "ID:06262013-0028922",
        "DATE:06/26",
        "TIME:09:13",
        "INFO:Dr's office unable to contact with patient. they requested welfare check.,");

    doTest("T16",
        "UNIT: South ; CALL: Unknown / Person Down ; PLACE: ; ADDR: 158 Walnut Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Monmouth St/Chambers St ; ID: 06262013-0028922 ; DATE: 06/26; TIME: 09:13; INFO:",
        "UNIT:South",
        "CALL:Unknown / Person Down",
        "ADDR:158 Walnut Ave",
        "CITY:Trenton",
        "X:Monmouth St/Chambers St",
        "ID:06262013-0028922",
        "DATE:06/26",
        "TIME:09:13");

    doTest("T17",
        "UNIT: Rescue; CALL: Unconscious / Fainting - ALS ; PLACE: new horizon treatmen; ADDR: 132 Perry St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: N Broad St/N Montgomery St ; ID: 06262013-0028921 ; DATE: 06/26; TIME: 09:10; INFO: Longitude: -074.769167,Latitude: +040.226667,TRENTON CITY PD 609 F1=BUCKS CO 911 PA 215 493-4011 F2=W WINDSOR PD 609 538-9203,55 y/o female unresponsive,,pt may have taken unknown drugs.,",
        "UNIT:Rescue",
        "CALL:Unconscious / Fainting - ALS",
        "PLACE:new horizon treatmen",
        "ADDR:132 Perry St",
        "CITY:Trenton",
        "X:N Broad St/N Montgomery St",
        "ID:06262013-0028921",
        "DATE:06/26",
        "TIME:09:10",
        "GPS:+40.226667,-74.769167",
        "INFO:TRENTON CITY PD 609 F1=BUCKS CO 911 PA 215 493-4011 F2=W WINDSOR PD 609 538-9203,55 y/o female unresponsive,,pt may have taken unknown drugs.,");

    doTest("T18",
        "UNIT: North ; CALL: Unconscious / Fainting - ALS ; PLACE: new horizon treatmen; ADDR: 132 Perry St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: N Broad St/N Montgomery St ; ID: 06262013-0028921 ; DATE: 06/26; TIME: 09:09; INFO: Longitude: -074.769167,Latitude: +040.226667,TRENTON CITY PD 609 F1=BUCKS CO 911 PA 215 493-4011 F2=W WINDSOR PD 609 538-9203,55 y/o female unresponsive,,",
        "UNIT:North",
        "CALL:Unconscious / Fainting - ALS",
        "PLACE:new horizon treatmen",
        "ADDR:132 Perry St",
        "CITY:Trenton",
        "X:N Broad St/N Montgomery St",
        "ID:06262013-0028921",
        "DATE:06/26",
        "TIME:09:09",
        "GPS:+40.226667,-74.769167",
        "INFO:TRENTON CITY PD 609 F1=BUCKS CO 911 PA 215 493-4011 F2=W WINDSOR PD 609 538-9203,55 y/o female unresponsive,,");

    doTest("T19",
        "UNIT: South ; CALL: Respiratory - ALS ; PLACE: ; ADDR: 829 Division St ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: Rusling St/Woodland St ; ID: 06262013-0028920 ; DATE: 06/26; TIME: 08:50; INFO: Longitude: -074.744750,Latitude: +040.212222,TRENTON CITY PD 609 F1=BUCKS CO 911 PA 215 493-4011 F2=W WINDSOR PD 609 538-9203,",
        "UNIT:South",
        "CALL:Respiratory - ALS",
        "ADDR:829 Division St",
        "CITY:Trenton",
        "X:Rusling St/Woodland St",
        "ID:06262013-0028920",
        "DATE:06/26",
        "TIME:08:50",
        "GPS:+40.212222,-74.744750",
        "INFO:TRENTON CITY PD 609 F1=BUCKS CO 911 PA 215 493-4011 F2=W WINDSOR PD 609 538-9203,");

    doTest("T20",
        "UNIT: North ; CALL: MVC - BLS ; PLACE: ; ADDR: 458 Walnut Ave ; BLDG: ; APT: ; CITY: Trenton ; XSTREETS: S Cook Ave/Cuyler Ave ; ID: 06262013-0028919 ; DATE: 06/26; TIME: 08:29; INFO: PT WITH BACK AND LEG PAINS,",
        "UNIT:North",
        "CALL:MVC - BLS",
        "ADDR:458 Walnut Ave",
        "CITY:Trenton",
        "X:S Cook Ave/Cuyler Ave",
        "ID:06262013-0028919",
        "DATE:06/26",
        "TIME:08:29",
        "INFO:PT WITH BACK AND LEG PAINS,");

  }
  
  public static void main(String[] args) {
    new NJMercerCountyParserTest().generateTests("T1");
  }
}
