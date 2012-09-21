package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYJeffersonCountyParser;

import org.junit.Test;


public class NYJeffersonCountyParserTest extends BaseParserTest {
  
  public NYJeffersonCountyParserTest() {
    setParser(new NYJeffersonCountyParser(), "JEFFERSON COUNTY", "NY");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "BREATHING PROBL|18077 REED POINT RD:ORLEANS(T)|77 YO MALE DIFF BREATHING",
        "CALL:BREATHING PROBL",
        "ADDR:18077 REED POINT RD",
        "CITY:ORLEANS",
        "INFO:77 YO MALE DIFF BREATHING");

    doTest("T2",
        "ABDOMINAL PAIN|18081 REED POINT RD:ORLEANS(T)|79F  :ProQA Medical Case Entry Finished You are responding to a patient with abdominal pain.  The patient is a  79-year-old female, who is conscious and breathing.  Abdominal Pain / Problems.  Caller Statement: ABDOMINAL PAIN.",
        "CALL:ABDOMINAL PAIN",
        "ADDR:18081 REED POINT RD",
        "CITY:ORLEANS",
        "INFO:79F");

    doTest("T3",
        "ASSIST-EMS|I 81 MM 176 N:ALEXANDRIA(T)|1 mile south of 50 in the north bound lane   vehicle appears to be stuck in mediun    unkn9ow if occupied  :3D63 REQUESTING EMS RESPOND.  ONE FEMALE OCCUPANT COMPLAINING OF WRIST PAIN.",
        "CALL:ASSIST-EMS",
        "ADDR:I 81 MM 176 N",
        "CITY:ALEXANDRIA",
        "INFO:1 mile south of 50 in the north bound lane vehicle appears to be stuck in mediun unkn9ow if occupied :3D63 REQUESTING EMS RESPOND. ONE FEMALE OCCUPANT COMPLAINING OF WRIST PAIN.");

    doTest("T4",
        "CHEST PAIN|622 JOHN ST:CLAYTON(V)|59 FEMALE/CARDIAC ISSUES",
        "CALL:CHEST PAIN",
        "ADDR:622 JOHN ST",
        "CITY:CLAYTON",
        "INFO:59 FEMALE/CARDIAC ISSUES");

    doTest("T5",
        "MVA-PI|SHIMEL RD & STATE ROUTE 411:ORLEANS(T)|1 VEH OFF ROAD - MINOR INJURY",
        "CALL:MVA-PI",
        "ADDR:SHIMEL RD & STATE ROUTE 411",
        "MADDR:SHIMEL RD & STATE 411",
        "CITY:ORLEANS",
        "INFO:1 VEH OFF ROAD - MINOR INJURY");

    doTest("T6",
        "FIRE ALARM|37382 ORLEANS CEMETERY RD:ORLEANS(T)|CAPUTO RESIDENCE GENERAL SMOKE ALARM",
        "CALL:FIRE ALARM",
        "ADDR:37382 ORLEANS CEMETERY RD",
        "CITY:ORLEANS",
        "INFO:CAPUTO RESIDENCE GENERAL SMOKE ALARM");

    doTest("T7",
        "(DISPATCH:4392) MVA-PI|I 81 MM 176 N:ALEXANDRIA(T)|SPUN OUT IN THE MIDDLE OF DRIVING LANE YELLOW SEDAN NORTHBOUND LANE. CALL",
        "CALL:MVA-PI",
        "ADDR:I 81 MM 176 N",
        "CITY:ALEXANDRIA",
        "INFO:SPUN OUT IN THE MIDDLE OF DRIVING LANE YELLOW SEDAN NORTHBOUND LANE. CALL");

    doTest("T8",
        "FALL|34226 CARTER STREET RD:ORLEANS(T)|  CALLBACK=(315)489-3188 LAT=  LON=",
        "CALL:FALL",
        "ADDR:34226 CARTER STREET RD",
        "CITY:ORLEANS",
        "PHONE:(315)489-3188");

    doTest("T9",
        "((LVFD) DISPATCH:4391,27FR) SICK PERSON|30950 STATE ROUTE 180  ;NORTHER NY AGRICULTRUAL MUSEUM:ORLEANS(T)|",
        "CALL:SICK PERSON",
        "ADDR:30950 STATE ROUTE 180",
        "MADDR:30950 STATE 180",
        "PLACE:NORTHER NY AGRICULTRUAL MUSEUM",
        "CITY:ORLEANS");

    doTest("T10",
        "sentto-76513067-101-1314862564-3159559896=vtext.com@returns.groups.yahoo.com ([carthageambulance] DISPATCH:1191) FALL|1045 WEST ST:CARTHAGE(V)|83 Y/F FELL OUT OF BED BROKEN NOSE AN",
        "CALL:FALL",
        "ADDR:1045 WEST ST",
        "CITY:CARTHAGE",
        "INFO:83 Y/F FELL OUT OF BED BROKEN NOSE AN");
 }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(DISPATCH:1) CHIMNEY FIRE|12636 COUNTY ROUTE 66:ADAMS(T)|CHIMNEY FIRE   CALLBACK=(315)783-7406 LAT=  LON= UNC=    05315-783-7406 03/08 13:43:40  086CAUTION:  WIRELESS CALL         WIRELESS-AT&amp;T MOBILITY(TCS) WPH1   18864         CADY RD                                        ADAMS CENTER                  NYCELL = 3034  SECTOR = 3                             LAT:+043.910222  LON:-075.996056ELV:+00000 COF:0         COP:000MTN:315-511-4609       CPF:ATTMO-911ai.com-            ESN:00888                                VERIFY PD                       VERIFY FD                       VERIFY EMS",
        "CALL:CHIMNEY FIRE",
        "ADDR:12636 COUNTY ROUTE 66",
        "CITY:ADAMS",
        "INFO:CHIMNEY FIRE",
        "PHONE:(315)783-7406",
        "GPS:+043.910222 -075.996056");

    doTest("T1",
        "(DISPATCH:29,1) TEST-FIRE/EMS|310 S MAIN ST; MANNSVILLE MANOR FIRE DEPART:MANNSVILLE(V)|",
        "CALL:TEST-FIRE/EMS",
        "ADDR:310 S MAIN ST",
        "PLACE:MANNSVILLE MANOR FIRE DEPART",
        "CITY:MANNSVILLE");

  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "(DISPATCH:GEMS,7FR) UNCONS/FAINTING|19853 STATE ROUTE 12F:HOUNSFIELD(T)|male passed out in vehicle been there approx 30 min    they pounded on windows  he appears to be breathing      tn plate maroon car      02315-786-0812 07/30 21:05:37  032                                NICE-N-EASY GROCERY SHOPPE  BUSN   19853         STATE ROUTE 12F                                HOUNSFIELD                    NY                                                    LAT:             LON:           ELV:       COF:          COP:   MTN:315-786-0812       CPF:VERIZ-911ai.com-            ESN:01304                                SHERIFF/STATE POLICE            BROWNVILLE FIRE                 DEXTER AMBULANCE",
        "CALL:UNCONS/FAINTING",
        "ADDR:19853 STATE ROUTE 12F",
        "CITY:HOUNSFIELD",
        "INFO:male passed out in vehicle been there approx 30 min they pounded on windows he appears to be breathing tn plate maroon car 02315-786-0812 07/30 21:05:37 032 NICE-N-EASY GROCERY SHOPPE BUSN 19853 STATE ROUTE 12F HOUNSFIELD NY");

    doTest("T2",
        "(DISPATCH:7,40) VEHICLE FIRE|I 81 MM 151 N:WATERTOWN(T)|TRACTOR TRAILER TOWING TANKER ON FIRE  VEH IS PULLED OVER TO THE SIDE  CALLBACK=(440)654-7000 LAT=  LON= UNC=    01440-654-7000 07/30 21:07:48  035CAUTION:  WIRELESS CALL         T-MOBILE USA                WPH1   17726         OLD ROME RD (RT 81)                            Watertown                     NY                                                    LAT:+043.926719  LON:-075.972433ELV:+00000 COF:9546      COP:090MTN:315-511-4696       CPF:TMOB -911ai.com-            ESN:01315                                Verify PD                       Verify FD                       Verify EMS             :46-0-1 EN ROUTE",
        "CALL:VEHICLE FIRE",
        "ADDR:I 81 MM 151 N",
        "CITY:WATERTOWN",
        "INFO:TRACTOR TRAILER TOWING TANKER ON FIRE VEH IS PULLED OVER TO THE SIDE",
        "PHONE:(440)654-7000",
        "GPS:+043.926719 -075.972433");

    doTest("T3",
        "(DISPATCH:7,17,20,34,24) OUTDOOR FIRE|13650 COUNTY ROUTE 76:ADAMS(T)|CR 76 DOWN THE ROAD FROM CR 75 LARGE GRASS FIRE JUST BEFORE KEVIN SIMPSON'S RESIDENCE   CALLBACK=(315)286-9652 LAT=  LON= UNC=    04315-286-9652 07/31 13:23:16  012CAUTION:  WIRELESS CALL         WIRELESS-AT&T MOBILITY(TCS) WPH1   10435         COUNTY ROUTE 77                                ADAMS                         NYCELL = 3005  SECTOR = 1                             LAT:+043.820333  LON:-076.087806ELV:+00000 COF:0         COP:000MTN:315-511-4606       CPF:ATTMO-911ai.com-            ESN:00888                                VERIFY PD                       VERIFY FD                       VERIFY EMS             :4103 REQUESTING ADAMS AND BELVILLE FIRE :4103 REQUEST ADAMS CENTER WITH THEIR BRUSH TRUCK :4103 ON SCENE LARAGE GRASS FIRE REQUESTING TANKERS AND BRUSH TRUCK FROM T/WATERTOWN AND HENDERSON FIRE :271 AND 252 EN :541 EN REQUESTING ADD MP TO STATION FOR TANKER :2ND ACT FOR BELVILLE FIRE :HENDERSON BRUCH TRUCK EN :4131 ON SC\n" +
        " ENE :2ND ACT FOR ADAMS FIRE :4601 EN TO SCENE :ADAMS CENTER ON SCENE :4671 EN W/3 4652 EN W/1 :541 ON SCENE :4101 REQUEST CAR 1 TO THE SCENE :4104 REQUEST 2ND ENGINE FROM ADAMS TO SET UP FILL SITE AT CLYDEBORG CONSTRUCTION :CLYDEBORG CONSTRUCTION IS ON 77 :KLEIBOER CONSTRUCTION 11103 COUNTY ROUTE 77 :PER 4104 APPROX 75 ACRES BURNING FIRE IS MOVING :ADAMS FIRE IS EN W/2ND ENGINE TO FILL SITE AT CLYDBORG CONSTRUCTION :4601 ON SCENE :PER 4101 HAVE CC1 RESPOND PRIORITY 1 :4652 ON SCENE :4104 REQUEST EVERY BRUSH TRUCK IN THE SOUTHERN AREA TO RESPOND INCLUDING SANDY CREEK :ALSO REQUEST FOREST RANGER CREW FIRE RUNNING AT 100-15 MILES PER HOUR :PER CC1 FORT DRUM CHECKING THEIR GROUND RESOURCES NEGATIVE ON AVIATION RESOURCES :PHONE NUMBER FOR FOREST RANGERS AT SOB NO LONGER IN SERVICE :CONTACTED DISPATCH 518-891-0235 :4101 REQUEST ALL TERRAIN VEH FROM LORRAINE FIRE :2ND ACT FOR SACKETS FIRE BRUCH TRUCK :PER DISPATCH NO ONE ON IN JEFFERSON COUNTY :LORRAINE COPIED AND WILL BE EN SHORTL\n" +
        " Y :LORRAINE EN WITH UTV AND TANKER :FOREST RANGERS 518-8971300  LT NOWALK  STATES HE WILL START THE CLOSEST RANGER WHO IS ABOUT 45MIN AWAY :161 EN. :ONLY ACK FROM SANDY CREEK AT THIS TIME",

        "CALL:OUTDOOR FIRE",
        "ADDR:13650 COUNTY ROUTE 76",  // Google is just having trouble with this
        "CITY:ADAMS",
        "INFO:CR 76 DOWN THE ROAD FROM CR 75 LARGE GRASS FIRE JUST BEFORE KEVIN SIMPSON'S RESIDENCE",
        "PHONE:(315)286-9652",
        "GPS:+043.820333 -076.087806");

    doTest("T4",
        "(DISPATCH:GEMS,7FR) BREATHING PROBL|201 FRANKLIN ST:BROWNVILLE(V)|  02315-782-2016 08/03 02:18:14  020                                CHEAL, TERESA H             RESD     201         FRANKLIN                                       BROWNVILLE VILLAGE            NY                                                    LAT:             LON:           ELV:       COF:          COP:   MTN:315-782-2016       CPF:VERIZ-911ai.com-            ESN:00841                                TRI VILLAGE POLICE              BROWNVILLE FIRE                 DEXTER AMBULANCE",
        "CALL:BREATHING PROBL",
        "ADDR:201 FRANKLIN ST",
        "CITY:BROWNVILLE",
        "INFO:02315-782-2016 08/03 02:18:14 020 CHEAL, TERESA H RESD 201 FRANKLIN BROWNVILLE VILLAGE NY");

    doTest("T5",
        "(DISPATCH:7,23) FIRE ALARM|104 ST LAWRENCE AVE W; JRC:BROWNVILLE(V)|FIRE ALARM 1ST FLOOR",
        "CALL:FIRE ALARM",
        "ADDR:104 ST LAWRENCE AVE W",
        "PLACE:JRC",
        "CITY:BROWNVILLE",
        "INFO:FIRE ALARM 1ST FLOOR");

    doTest("T6",
        "(DISPATCH:7FR) ALLERGIES/ENVEN|14568 MIDDLE RD:BROWNVILLE(T)|62/M STUNG BY BEE IS SHAKING  CALLBACK=(315)767-1721 LAT=  LON= UNC=    04315-767-1721 08/03 11:50:25  0 0                                Verizon Wireless            WPH123875            NYS Route 180 - W Sector                       Dexter                        NY                                                    LAT:+044.011874  LON:-076.046891ELV:+00000 COF:1709      COP:100MTN:315-511-4647       CPF:VZW  -911ai.com-            ESN:01315             :ProQA Medical Case 12-070137 Aborted: TOT GEMS  :SHOLETTE RES  LARGE WHITE TRACTOR TRLR  :TOWARD THE B ADAMS RD :OUTSIDE THE RES :1703 EN BLS  :PER 1703 DO NOT REACTIVATE :1703 AS :1703 REQ GEMS9 EXPEDITE",
        "CALL:ALLERGIES/ENVEN",
        "ADDR:14568 MIDDLE RD",
        "CITY:BROWNVILLE",
        "INFO:62/M STUNG BY BEE IS SHAKING",
        "PHONE:(315)767-1721",
        "GPS:+044.011874 -076.046891");

    doTest("T7",
        "(DISPATCH:40,46,7FAST,DEPC) STRUCTURE FIRE|STATE ROUTE 180 & MILITARY RD:HOUNSFIELD(T)|  CALLBACK=(315)783-8034 LAT=+043.972231 LON=-076.047256 UNC=   03315-783-8034 08/03 20:57:11  066                                Verizon Wireless            WPH223875            NYS Route 180 - SE Sector                      Dexter                        NY                                                    LAT:+043.972231  LON:-076.047256ELV:+00000 COF:36        COP:095MTN:315-511-4642       CPF:VZW  -911ai.com-            ESN:01315",
        "CALL:STRUCTURE FIRE",
        "ADDR:STATE ROUTE 180 & MILITARY RD",
        "MADDR:STATE 180 & MILITARY RD",
        "CITY:HOUNSFIELD",
        "PHONE:(315)783-8034",
        "GPS:+043.972231 -076.047256");

    doTest("T8",
        "(DISPATCH:GEMS3,7FR) BREATHING PROBL|24272 PERCH LAKE RD:BROWNVILLE(T)|18 YEAR OLD FEMALE ASTHMA ATTACK  CALLBACK=(315)771-2309 LAT=  LON= UNC=    06315-771-2309 08/03 21:44:23  010                                Verizon Wireless            WPH1                 Salmon Run Mall Road - NW Sector               Watertown                     NY                                                    LAT:+043.984301  LON:-075.947843ELV:+00000 COF:1709      COP:100MTN:315-511-4649       CPF:VZW  -911ai.com-            ESN:01315",
        "CALL:BREATHING PROBL",
        "ADDR:24272 PERCH LAKE RD",
        "CITY:BROWNVILLE",
        "INFO:18 YEAR OLD FEMALE ASTHMA ATTACK",
        "PHONE:(315)771-2309",
        "GPS:+043.984301 -075.947843");

    doTest("T9",
        "(DISPATCH:7) WIRES/TREE DOWN|24883 COUNTY ROUTE 54:BROWNVILLE(T)|TREE BRANCH LAYING ON A PRIMARY LINE",
        "CALL:WIRES/TREE DOWN",
        "ADDR:24883 COUNTY ROUTE 54",
        "CITY:BROWNVILLE",
        "INFO:TREE BRANCH LAYING ON A PRIMARY LINE");

    doTest("T10",
        "(DISPATCH:GEMS,7FR) UNCONS/FAINTING|SR 12E & BUTTS:BROWNVILLE(T)|C1 PASSERBY STATED SUBJECT LAYING FACE DOWN IN GRAVEL PARKING LOT  BLUE TRUCK IN PRKING LOT  CALLBACK=(315)681-0124 LAT=  LON= UNC=    01315-681-0124 08/07 06:12:35  091CAUTION:  WIRELESS CALL         WIRELESS-AT&T MOBILITY(TCS) WPH1   24278         NY STATE ROUTE 12                              WATERTOWN                     NYCELL = 3006  SECTOR = 3                             LAT:+044.020528  LON:-075.918472ELV:+00000 COF:0         COP:000MTN:315-511-4612       CPF:ATTMO-911ai.com-            ESN:00888                                VERIFY PD                       VERIFY FD                       VERIFY EMS             :ProQA Medical Case 12-071488 Aborted: GEMS",
        "CALL:UNCONS/FAINTING",
        "ADDR:SR 12E & BUTTS",
        "MADDR:NY 12E & BUTTS",
        "CITY:BROWNVILLE",
        "INFO:C1 PASSERBY STATED SUBJECT LAYING FACE DOWN IN GRAVEL PARKING LOT BLUE TRUCK IN PRKING LOT",
        "PHONE:(315)681-0124",
        "GPS:+044.020528 -075.918472");

    doTest("T11",
        "(DISPATCH:39,21,7FAST,DEPC) STRUCTURE FIRE|21149 STAPLIN RD:RUTLAND(T)|BARN ON FIRE.  WHOLE THINGS IS GONE, FULL OF COWS.  CALLBACK=(315)408-6712 LAT=  LON= UNC=    01315-408-6712 08/08 04:02:42  078                                Verizon Wireless            WPH1                 Route 126, State Street Hill - NE Sector       Watertown                     NY                                                    LAT:+043.953670  LON:-075.842400ELV:+00000 COF:1709      COP:100MTN:315-511-4634       CPF:VZW  -911ai.com-            ESN:01315             :CLOSE TO FREESTYLE BARN AND HOUSE",
        "CALL:STRUCTURE FIRE",
        "ADDR:21149 STAPLIN RD",
        "CITY:RUTLAND",
        "INFO:BARN ON FIRE. WHOLE THINGS IS GONE, FULL OF COWS.",
        "PHONE:(315)408-6712",
        "GPS:+043.953670 -075.842400");

    doTest("T12",
        "(DISPATCH:7) POLE FIRE|OLD ROME RD & STATE ROUTE 12F:HOUNSFIELD(T)|POLE ARCING SECOND POLE IN FROM ROUTE 12F.  NOTHING ON THE WIRE AND NO TRANSFORMER THERE.  CALLBACK=(315)777-7493 LAT=+043.989687 LON=-075.947199 UNC=   01315-777-7493 08/08 04:37:18  085                                Verizon Wireless            WPH2                 Salmon Run Mall Road - NE Sector               Watertown                     NY                                                    LAT:+043.989687  LON:-075.947199ELV:+00000 COF:19        COP:095MTN:315-511-4666       CPF:VZW  -911ai.com-            ESN:01315",
        "CALL:POLE FIRE",
        "ADDR:OLD ROME RD & STATE ROUTE 12F",
        "CITY:HOUNSFIELD",
        "INFO:POLE ARCING SECOND POLE IN FROM ROUTE 12F. NOTHING ON THE WIRE AND NO TRANSFORMER THERE.",
        "PHONE:(315)777-7493",
        "GPS:+043.989687 -075.947199");

    doTest("T13",
        "(DISPATCH:17,7) CHEST PAIN|23129 OLD STATE RD:HOUNSFIELD(T)|JUSTIN SPENCER RESD -- 38Y/M -- SEVERE CHEST PAIN RADIATIING DOWN HIS ARM 639-6389 :ProQA Medical Recommended Dispatch Level = 10D04 You are responding to a patient with chest pain.  The patient is a 38-year-old  male, who is conscious and breathing. Clammy.  Chest Pain (Non-Traumatic).  Caller Statement: CHEST PAIN RADIATING DOWN ARM.  1. He is completely alert (responding appropriately).  2. It's not known if he is breathing normally.  3. He is not changing color.  4. He is clammy.\n" +
        " :ProQA Medical KQ Finished You are responding to a patient with chest pain.  The patient is a 38-year-old  male, who is conscious and breathing. Clammy.  Chest Pain (Non-Traumatic).  Caller Statement: CHEST PAIN RADIATING DOWN ARM.  1. He is completely alert (responding appropriately).  2. It's not known if he is breathing normally.  3. He is not changing color.  4. He is clammy.  5. He has not had a heart attack or angina (heart pains) before.  6. He \n" +
        " took a prescribed medication in the past 12hrs: REGULAR MEDS AND VICODIN  -Comments: REGULAR MEDS AND VICODIN-\n" +
        " :ProQA Medical Case 12-071957 Complete :2ND ACT FOR 17FR :GEMS9 REQUEST DEXTER AND BROWNVILLE BE ACTIVATED FOR LIFTING",

        "CALL:CHEST PAIN",
        "ADDR:23129 OLD STATE RD",
        "CITY:HOUNSFIELD",
        "INFO:JUSTIN SPENCER RESD -- 38Y/M -- SEVERE CHEST PAIN RADIATIING DOWN HIS ARM 639-6389");

  }
  
  public static void main(String[] args) {
    new NYJeffersonCountyParserTest().generateTests("T1");
  }
}