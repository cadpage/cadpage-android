package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
 Tolland County, CT
 Contact: Tabby Muniz <tabbymuniz@ymail.com>
 Contact: leanne buden <lbuden38@gmail.com>
 Sender: TN@TollandCounty911.org

 (TN Alert) 10 COTTAGE ST / UNIT D Vernon ALS Difficulty Breathing 21:14 Cross Street ST BERNARDS TER / SCHOOL ST 2011-00001770
 [TN Alert]  DOBSON RD / CAMPBELL AVE Vernon Vehicle Accident 2ND AMB  12:59 Cross Street 2011-00001773
 [TN Alert]  32 FRANKLIN PARK E / Vernon ALS DIFF BREATHING 09:07 Cross Street DEAD END / FRANKLIN ST 2011-00001772
 [TN Alert]  140 WINDSORVILLE RD / Vernon BLS back pain 02:21 Cross Street PENFIELD AVE / SEPTIC TREATMENT PLANT 2011-00001771
 [TN Alert]  DOBSON RD / CAMPBELL AVE Vernon Vehicle Accident 12:59 Cross Street 2011-00001773
 [TN Alert]  95 HARTFORD TPKE / Vernon * Golf Land Vehicle Accident MINOR INJURIES - EVALUATION
 [TN Alert]  67 BLUE RIDGE DR / Vernon Tree/Wires Down 14:38 Cross Street HICKORY HL / AUTUMN WOOD LN 2011-00001775
 (TN Alert) 155 W   MAIN ST 317 / Vernon ALS DIFFICULTY BREATHING 14:03 Cross Street ORCHARD ST, SPRING ST / WARD ST 2011-00001981
 (TN Alert) 36 GARDNER ST / Warehouse Point Fire Alarm 17:11 Cross Street PLEASANT ST / BRIDGE ST 2011-00000190
 (TN Alert) 69 BROOKLYN ST / (CLERKS OFC) Vernon BLS SICK- ELDERLY FEMALE  13:20 Cross Street COURT ST / VERNON AVE 2011-00002812
 (TN Alert) 34 CAMPBELL AVE / Vernon ALS abdominal pain 01:29 Cross Street DEAD END / DOBSON RD 2012-00001475
 [TN Alert] 10 PITKIN RD / Vernon Smoke/Odor Investigation STOP AND SHOP 12:07 Cross Street STOP AND SHOP PLAZA / DOBSON RD 2012-00001471 

 Contact: Jason Carlton <jcarlton19@gmail.com>
 (TN Alert) 29 BRACE RD / Somers ALS ARM INJURY, BLEEDING 22:42 Cross Street GEORGE WOOD RD / HALL HILL RD 2011-00000821
 (TN Alert) 69 COLTON RD / Somers ALS ? CVA 18:34 Cross Street PARSONS ST / SOKOL RD 2011-00000820

 Contact: R R <rlandry0769@gmail.com>
 (TN Alert) 234 JAMES RD / Ashford BLS Fall 15:25 Cross Street HORSE HILL RD / WESTFORD RD 2011-00001969

 Contact: Stuart Cobb <scobb213@gmail.com>
 (TN Alert) 140 RIVER RD / Willington * Lyon Manor BLS Commital 06:29 Cross Street DEPOT RD / VILLAGE ST 2011-00000860

 Contact: Peter Krawetzky <pkrawetzky@gmail.com>
 Sender: north-coventry@tollandcounty911.com
 (TN Alert) 957 N  RIVER RD / Coventry ALS DIFF BREATHING 17:59 Cross Street MERROW RD / GOOSE LN 2012-00000183

 Contact: "Grant Genlot" <grant.videography@gmail.com>
 [05/13/2012 10:35] tn@tollandcounty911.com:  TN Alert / TOLLAND COUNTY DIVERS SERVICE CALL: IF AVAILABLE MEET AT STATION 8 AT 1300.
 [05/13/2012 11:28] tn@tollandcounty911.com:  TN Alert / NO DIVE IN COVENTRY TODAY. REPEAT DIVE CANCELLED!

 Contact: Peter Krawetzky <pkrawetzky@gmail.com>
 Sender: Administrator@tollandcounty911.com
 (TN Alert) 664 SILVER ST / APT B Coventry ALS SICK/ALT.MENT.STAT. 18:38 Cross Street LOVE LN / SOUTH ST 2012-00000205

 Contact: Bernard Hoffman <bernardhoffman@gmail.com>
 Sender: Administrator@tollandcounty911.com
 (TN Alert) 573 CRYSTAL LAKE RD / Tolland Vehicle Accident CAR VS TREE, ? DOA 03:26 Cross Street WEBBER RD / ROLLING MEADOW DR, WILLOW CREEK DR 20

 Contact: Gina Vanwingerden <ginavanwingerden@gmail.com>
 Sender: TN@TollandCounty911.com
 Subject:TN Alert\n24 HAAS RD / Somers ALS CARDIAC ARREST  10:22 Cross Street MOUNTAIN RD / ROOT RD 2012-00000817\r

 Contact: Active911
 Agency name: Coventry Fire
 Location: Coventry, CT, United States
 Sender: messaging@iamresponding.com

 (CVFA) 2152 BOSTON TPKE / Coventry Coventry MotorcarBLS Sick 22:24 Cross Street SWAMP RD / MARK DR 2013-00000070
 (CVFA) 1548 MAIN ST / Coventry ALS HIGH FEVER/LETHARGIC(2 Y/O)COVENTRY KID'S CENTER 13:49 Cross Street SPRINGDALE AVE / ST. MARY'S CHURCH 2013-00000141
 (CVFA) 1946 BOSTON TPKE / Coventry BLS RETONE / LEG PAIN 10:01 Cross Street SILVER ST / LATHROP DR 2013-00000069
 (CVFA) 60 MIDLAND RD / Coventry BLS RETONE: FALL ON ICE/ BACK INJ.  07:21 Cross Street WOODMERE DR / DEAD END 2013-00000139
 (CVFA) 298 MERROW RD / Coventry BLS 55 Y/O F - FALL/EVAL - RETONE AMB 05:25 Cross Street BRIGHAM TAVERN RD / RIDGEBROOK DR 2013-00000067
 (CVFA) 136 WALL ST / Coventry Fire Alarm 15:49 Cross Street MASON ST / MONUMENT HILL RD 2013-00000137
 (CVFA) 137 TOLLAND TPKE / Coventry ALS CHEST/SHOULDER PAIN(48 Y/O MALE) 13:33 Cross Street TOLLAND TOWN LINE / DIMOCK RD, JONES CROSSING RD 2013-00000065
 (CVFA) 132 SKYVIEW DR / Coventry BLS RETONE- FALL- ENTER FROM GARAGE  12:38 Cross Street DUNN RD / DEAD END 2013-00000064
 (CVFA) 136 WALL ST / Coventry Fire Alarm 11:36 Cross Street MASON ST / MONUMENT HILL RD 2013-00000134
 (CVFA) 97 TWIN HILLS DR / Coventry BLS FALL/BLEEDING 15:43 Cross Street BOSTON TPKE / NEVILLE ST 2013-00000062
 (CVFA) 1630 MAIN ST Apt 33 / Coventry Orchard Hill EstatesBLS Medical Alarm Person Fell 22:27 Cross Street ELDERLY HOUSING / ST. MARY'S CHURCH 2013-00000145

 Contact: Active911
 Agency name: Broad Brook Fire
 Location: Broad Brook, CT, United States
 Sender: TN@TollandCounty911.com

 (TN Alert) 53 RICE RD / Broad Brook ALS Overdose 01:57 Cross Street HARRINGTON RD / NORTH RD 2013-00000130
 (TN Alert) 53 RICE RD / Broad Brook ALS Swallowed Razor blade 00:42 Cross Street HARRINGTON RD / NORTH RD 2013-00000129
 (TN Alert) 35 MILL ST / B Broad Brook ALS Altered Mental Status / Diabetic 17:33 Cross Street BROOKSIDE DR / CHURCH ST 2013-00000128
 (TN Alert) 215 S  MAIN ST / Warehouse Point Fire Alarm MERCURY EXCELLIUM(WATERFLOW)ET139 13:19 Cross Street ABBE RD / STOUGHTON RD 2013-00000083
 (TN Alert) 27 PLEASANT ST / Warehouse Point Fire Alarm UNIT 14B(BROAD BROOK ET139) 20:48 Cross Street GRANDVIEW TER / ENFIELD TOWN LINE 2013-00000082
 (TN Alert) 139 MAIN ST / Broad Brook ALS MEET THE PD / ASSAULT / PT NOW UNRESP. 00:28 Cross Street HIGHLAND AVE / WINDSORVILLE RD, RYE ST 2013-00000500
 (TN Alert) 1 HARTFIELD BLVD / Warehouse Point Smoke/Odor Investigation IN BLDG 21:38 Cross Street BRIDGE ST / DEAD END 2013-00000081
 (TN Alert) 39 CHURCH ST / Broad Brook Vehicle Accident CAR VS POLE CL&P LEVEL 3 23:13 Cross Street HARVEST DR / MAIN ST 2013-00000122
 (TN Alert) NORTH RD / HARRINGTON RD Broad Brook Vehicle Accident 18:06 Cross Street 2013-00000121
 (TN Alert) 21 ROLOCUT RD / Broad Brook ALS seizure 08:46 Cross Street WELLS RD / NORTH RD 2013-00000120

Agency name: Ashford Fire Department
Location: Ashford, CT, United States
Contact: Active911
Sender: TN@TollandCounty911.com

(TN Alert) 149 ASHFORD CENTER RD C3 / Ashford Birch Hill CondosBLS STAGE---PSYC EVAL 21:53 Cross Street WESTFORD RD, POMPEY HOLLOW RD, MANSFIELD RD / PUMPKIN HILL RD 2013-00000128
(TN Alert) 360 NORTH RD / Ashford ALS HYPERTENSION / DIF BREATHING 14:40 Cross Street SUMMER LN / WESTVIEW DR 2013-00000127
(TN Alert) 8 ASHFORD DR / Ashford ALS Diff Breathing 15:08 Cross Street FERENCE RD / PINE HILL DR 2013-00000126
(TN Alert) 91 WATERFALL RD / Ashford ALS Unresponsive- ADDITIONAL MANPOWER 11:46 Cross Street HNATH RD / TURNPIKE RD 2013-00000125
(TN Alert) 91 WATERFALL RD / Ashford ALS Unresponsive 11:46 Cross Street HNATH RD / TURNPIKE RD 2013-00000125
(TN Alert) 80 BICKNELL RD Apt23 / Ashford Woodlawn AptsBLS Psych Evaluation / Stage for CSP\n  * * RETONE * *  18:58 Cross Street BEBBINGTON RD / MANSFIELD RD 2013-00000124
(TN Alert) 80 BICKNELL RD Apt23 / Ashford Woodlawn AptsBLS Psych Evaluation / Stage for CSP 18:58 Cross Street BEBBINGTON RD / MANSFIELD RD 2013-00000124
(TN Alert) 111 MANSFIELD RD / Ashford ALS unresponsive 15:04 Cross Street SLADE RD / BICKNELL RD 2013-00000123
(TN Alert) 54 FITTS RD / Ashford BLS 58 Y/O MALE FALL  10:23 Cross Street ASHFORD CENTER RD / DEAD END 2013-00000122
(TN Alert) 76 COUNTY RD / Eastford ALS AMB - TROUBLE BREATHING 07:59 Cross Street MILL BRIDGE RD / BARLOW CEMETERY RD 2013-00000121
(TN Alert) 217 POMPEY HOLLOW RD / Ashford Wooden Spoon RestaurantBLS FALL  14:08 Cross Street POMPEY RD / SQUAW HOLLOW RD, NOTT HWY 2013-00000120
(TN Alert) 4 KIDDER BROOK RD / Ashford Fire Alarm 07:52 Cross Street TURNPIKE RD / CHATEY RD 2013-00000119
(TN Alert) 440 WESTFORD RD / Ashford Ashford SchoolALS ALLERGIC REACTION 13:40 Cross Street WESTFORD HILL RD / OAKES RD 2013-00000118
(TN Alert) 195 PILFERSHIRE RD / Eastford Structure Fire AMB 520 ONLY REQUESTED 18:32 Cross Street UNKNOWN / FAYETTE RD 2013-00000117
(TN Alert) NOTT HWY / POMPEY HOLLOW RD Ashford Vehicle Accident W/O Injuries FIRE POLICE NEEDED 12:54 Cross Street 2013-00000116
(TN Alert) 181 WESTFORD RD / Eastford BLS Sick Person 15:32 Cross Street ASHFORD RD / CRYSTAL POND RD 2013-00000115
(TN Alert) 370 SQUAW HOLLOW RD / Ashford CO No Symptoms 13:14 Cross Street KNOWLTON HILL RD / HOWARD RD 2013-00000114
(TN Alert) 181 WESTFORD RD / Eastford BLS Headache Result of a Fall\n    * * RE-TONE * * 18:40 Cross Street ASHFORD RD / CRYSTAL POND RD 2013-00000113
(TN Alert) 181 WESTFORD RD / Eastford BLS Headache Result of a Fall 18:40 Cross Street ASHFORD RD / CRYSTAL POND RD 2013-00000113
(TN Alert) 24 BRADWAY RD / Union Structure Fire Barn 15:38 Cross Street GEORGE HECK RD / OLD BROWN RD 2013-00000025
(TN Alert) 195 PILFERSHIRE RD / Eastford Structure Fire A520 NEEDED TO EASTFORD 22:08 Cross Street UNKNOWN / FAYETTE RD 2013-00000110
(TN Alert) 195 PILFERSHIRE RD / Eastford Structure Fire RETONE FOR AMBULANCE 22:08 Cross Street UNKNOWN / FAYETTE RD 2013-00000110
(TN Alert) 26 ASHFORD MOTEL RD / Ashford ASHFORD MOTELBLS INJURED PERSON(PREVIOUS MVA)UNIT8 22:09 Cross Street DEAD END / FISH POINT RD 2013-00000111
(TN Alert) 195 PILFERSHIRE RD / Eastford Structure Fire ASHFORD TO EASTFORD 22:08 Cross Street UNKNOWN / FAYETTE RD 2013-00000110
 
 */

public class CTTollandCountyAParserTest extends BaseParserTest {

  public CTTollandCountyAParserTest() {
    setParser(new CTTollandCountyAParser(), "TOLLAND COUNTY", "CT");
  }

  @Test
  public void testParser() {

    doTest(
        "T1",
        "(TN Alert) 10 COTTAGE ST / UNIT D Vernon ALS Difficulty Breathing 21:14 Cross Street ST BERNARDS TER / SCHOOL ST 2011-00001770",
        "ADDR:10 COTTAGE ST",
        "APT:UNIT D",
        "CITY:Vernon",
        "CALL:ALS Difficulty Breathing",
        "TIME:21:14",
        "X:ST BERNARDS TER / SCHOOL ST",
        "ID:2011-00001770");

    doTest(
        "T2",
        "[TN Alert]  DOBSON RD / CAMPBELL AVE Vernon Vehicle Accident 2ND AMB  12:59 Cross Street 2011-00001773",
        "ADDR:DOBSON RD & CAMPBELL AVE",
        "CITY:Vernon",
        "CALL:Vehicle Accident 2ND AMB",
        "TIME:12:59",
        "ID:2011-00001773");

    doTest(
        "T3",
        "[TN Alert]  32 FRANKLIN PARK E / Vernon ALS DIFF BREATHING 09:07 Cross Street DEAD END / FRANKLIN ST 2011-00001772",
        "ADDR:32 FRANKLIN PARK E",
        "CITY:Vernon",
        "CALL:ALS DIFF BREATHING",
        "TIME:09:07",
        "X:DEAD END / FRANKLIN ST",
        "ID:2011-00001772");

    doTest(
        "T4",
        "[TN Alert]  140 WINDSORVILLE RD / Vernon BLS back pain 02:21 Cross Street PENFIELD AVE / SEPTIC TREATMENT PLANT 2011-00001771",
        "ADDR:140 WINDSORVILLE RD",
        "CITY:Vernon",
        "CALL:BLS back pain",
        "TIME:02:21",
        "X:PENFIELD AVE / SEPTIC TREATMENT PLANT",
        "ID:2011-00001771");

    doTest(
        "T5",
        "[TN Alert]  DOBSON RD / CAMPBELL AVE Vernon Vehicle Accident 12:59 Cross Street 2011-00001773",
        "ADDR:DOBSON RD & CAMPBELL AVE",
        "CITY:Vernon",
        "TIME:12:59",
        "CALL:Vehicle Accident",
        "ID:2011-00001773");

    doTest(
        "T6",
        "[TN Alert]  95 HARTFORD TPKE / Vernon * Golf Land Vehicle Accident MINOR INJURIES - EVALUATION",
        "ADDR:95 HARTFORD TPKE",
        "CITY:Vernon",
        "CALL:Golf Land Vehicle Accident MINOR INJURIES - EVALUATION");

    doTest(
        "T7",
        "[TN Alert]  67 BLUE RIDGE DR / Vernon Tree/Wires Down 14:38 Cross Street HICKORY HL / AUTUMN WOOD LN 2011-00001775",
        "ADDR:67 BLUE RIDGE DR",
        "CITY:Vernon",
        "CALL:Tree/Wires Down",
        "TIME:14:38",
        "X:HICKORY HL / AUTUMN WOOD LN",
        "ID:2011-00001775");

    doTest(
        "T8",
        "(TN Alert) 155 W   MAIN ST 317 / Vernon ALS DIFFICULTY BREATHING 14:03 Cross Street ORCHARD ST, SPRING ST / WARD ST 2011-00001981",
        "ADDR:155 W MAIN ST",
        "APT:317",
        "CITY:Vernon",
        "CALL:ALS DIFFICULTY BREATHING",
        "TIME:14:03",
        "X:ORCHARD ST, SPRING ST / WARD ST",
        "ID:2011-00001981");

    doTest(
        "T9",
        "(TN Alert) 36 GARDNER ST / Warehouse Point Fire Alarm 17:11 Cross Street PLEASANT ST / BRIDGE ST 2011-00000190",
        "ADDR:36 GARDNER ST",
        "CITY:Warehouse Point",
        "CALL:Fire Alarm",
        "TIME:17:11",
        "X:PLEASANT ST / BRIDGE ST",
        "ID:2011-00000190");

    doTest(
        "T10",
        "(TN Alert) 69 BROOKLYN ST / (CLERKS OFC) Vernon BLS SICK- ELDERLY FEMALE  13:20 Cross Street COURT ST / VERNON AVE 2011-00002812",
        "ADDR:69 BROOKLYN ST",
        "APT:(CLERKS OFC)",
        "CITY:Vernon",
        "CALL:BLS SICK- ELDERLY FEMALE",
        "TIME:13:20",
        "X:COURT ST / VERNON AVE",
        "ID:2011-00002812");

    doTest(
        "T11",
        "(TN Alert) 29 BRACE RD / Somers ALS ARM INJURY, BLEEDING 22:42 Cross Street GEORGE WOOD RD / HALL HILL RD 2011-00000821",
        "ADDR:29 BRACE RD",
        "CITY:Somers",
        "CALL:ALS ARM INJURY, BLEEDING",
        "TIME:22:42",
        "X:GEORGE WOOD RD / HALL HILL RD",
        "ID:2011-00000821");

    doTest(
        "T12",
        "(TN Alert) 69 COLTON RD / Somers ALS ? CVA 18:34 Cross Street PARSONS ST / SOKOL RD 2011-00000820",
        "ADDR:69 COLTON RD",
        "CITY:Somers",
        "CALL:ALS ? CVA",
        "TIME:18:34",
        "X:PARSONS ST / SOKOL RD",
        "ID:2011-00000820");

    doTest(
        "T13",
        "(TN Alert) 234 JAMES RD / Ashford BLS Fall 15:25 Cross Street HORSE HILL RD / WESTFORD RD 2011-00001969",
        "ADDR:234 JAMES RD",
        "CITY:Ashford",
        "CALL:BLS Fall",
        "TIME:15:25",
        "X:HORSE HILL RD / WESTFORD RD",
        "ID:2011-00001969");

    doTest(
        "T14",
        "(TN Alert) 140 RIVER RD / Willington * Lyon Manor BLS Commital 06:29 Cross Street DEPOT RD / VILLAGE ST 2011-00000860",
        "ADDR:140 RIVER RD",
        "CITY:Willington",
        "CALL:Lyon Manor BLS Commital",
        "TIME:06:29",
        "X:DEPOT RD / VILLAGE ST",
        "ID:2011-00000860");

    doTest(
        "T15",
        "(TN Alert) 957 N  RIVER RD / Coventry ALS DIFF BREATHING 17:59 Cross Street MERROW RD / GOOSE LN 2012-00000183",
        "ADDR:957 N RIVER RD",
        "CITY:Coventry",
        "CALL:ALS DIFF BREATHING",
        "TIME:17:59",
        "X:MERROW RD / GOOSE LN",
        "ID:2012-00000183");

    doTest(
        "T16",
        "(TN Alert) 34 CAMPBELL AVE / Vernon ALS abdominal pain 01:29 Cross Street DEAD END / DOBSON RD 2012-00001475",
        "ADDR:34 CAMPBELL AVE",
        "CITY:Vernon",
        "CALL:ALS abdominal pain",
        "TIME:01:29",
        "X:DEAD END / DOBSON RD",
        "ID:2012-00001475");

    doTest(
        "T17",
        "[TN Alert] 10 PITKIN RD / Vernon Smoke/Odor Investigation STOP AND SHOP 12:07 Cross Street STOP AND SHOP PLAZA / DOBSON RD 2012-00001471 ",
        "ADDR:10 PITKIN RD",
        "CITY:Vernon",
        "CALL:Smoke/Odor Investigation STOP AND SHOP",
        "TIME:12:07",
        "X:STOP AND SHOP PLAZA / DOBSON RD",
        "ID:2012-00001471");

    doTest(
        "T18",
        "(TN Alert) 664 SILVER ST / APT B Coventry ALS SICK/ALT.MENT.STAT. 18:38 Cross Street LOVE LN / SOUTH ST 2012-00000205",
        "ADDR:664 SILVER ST",
        "APT:B",
        "CITY:Coventry",
        "CALL:ALS SICK/ALT.MENT.STAT.",
        "TIME:18:38",
        "X:LOVE LN / SOUTH ST",
        "ID:2012-00000205");

    doTest(
        "T19",
        "(TN Alert) 573 CRYSTAL LAKE RD / Tolland Vehicle Accident CAR VS TREE, ? DOA 03:26 Cross Street WEBBER RD / ROLLING MEADOW DR, WILLOW CREEK DR 20",
        "ADDR:573 CRYSTAL LAKE RD",
        "CITY:Tolland",
        "CALL:Vehicle Accident CAR VS TREE, ? DOA",
        "TIME:03:26",
        "X:WEBBER RD / ROLLING MEADOW DR, WILLOW CREEK DR 20");

    doTest(
        "T20",
        "Subject:TN Alert\n24 HAAS RD / Somers ALS CARDIAC ARREST  10:22 Cross Street MOUNTAIN RD / ROOT RD 2012-00000817\r",
        "ADDR:24 HAAS RD",
        "CITY:Somers",
        "CALL:ALS CARDIAC ARREST",
        "TIME:10:22",
        "X:MOUNTAIN RD / ROOT RD",
        "ID:2012-00000817");

  }

  @Test
  public void testCoventryFire() {

    doTest(
        "T1",
        "(CVFA) 2152 BOSTON TPKE / Coventry Coventry MotorcarBLS Sick 22:24 Cross Street SWAMP RD / MARK DR 2013-00000070",
        "SRC:CVFA",
        "ADDR:2152 BOSTON TPKE",
        "CITY:Coventry",
        "CALL:Coventry MotorcarBLS Sick",
        "TIME:22:24",
        "X:SWAMP RD / MARK DR",
        "ID:2013-00000070");

    doTest(
        "T2",
        "(CVFA) 1548 MAIN ST / Coventry ALS HIGH FEVER/LETHARGIC(2 Y/O)COVENTRY KID'S CENTER 13:49 Cross Street SPRINGDALE AVE / ST. MARY'S CHURCH 2013-00000141",
        "SRC:CVFA",
        "ADDR:1548 MAIN ST",
        "CITY:Coventry",
        "CALL:ALS HIGH FEVER/LETHARGIC(2 Y/O)COVENTRY KID'S CENTER",
        "TIME:13:49",
        "X:SPRINGDALE AVE / ST. MARY'S CHURCH",
        "ID:2013-00000141");

    doTest(
        "T3",
        "(CVFA) 1946 BOSTON TPKE / Coventry BLS RETONE / LEG PAIN 10:01 Cross Street SILVER ST / LATHROP DR 2013-00000069",
        "SRC:CVFA",
        "ADDR:1946 BOSTON TPKE",
        "CITY:Coventry",
        "CALL:BLS RETONE / LEG PAIN",
        "TIME:10:01",
        "X:SILVER ST / LATHROP DR",
        "ID:2013-00000069");

    doTest(
        "T4",
        "(CVFA) 60 MIDLAND RD / Coventry BLS RETONE: FALL ON ICE/ BACK INJ.  07:21 Cross Street WOODMERE DR / DEAD END 2013-00000139",
        "SRC:CVFA",
        "ADDR:60 MIDLAND RD",
        "CITY:Coventry",
        "CALL:BLS RETONE: FALL ON ICE/ BACK INJ.",
        "TIME:07:21",
        "X:WOODMERE DR / DEAD END",
        "ID:2013-00000139");

    doTest(
        "T5",
        "(CVFA) 298 MERROW RD / Coventry BLS 55 Y/O F - FALL/EVAL - RETONE AMB 05:25 Cross Street BRIGHAM TAVERN RD / RIDGEBROOK DR 2013-00000067",
        "SRC:CVFA",
        "ADDR:298 MERROW RD",
        "CITY:Coventry",
        "CALL:BLS 55 Y/O F - FALL/EVAL - RETONE AMB",
        "TIME:05:25",
        "X:BRIGHAM TAVERN RD / RIDGEBROOK DR",
        "ID:2013-00000067");

    doTest(
        "T6",
        "(CVFA) 136 WALL ST / Coventry Fire Alarm 15:49 Cross Street MASON ST / MONUMENT HILL RD 2013-00000137",
        "SRC:CVFA",
        "ADDR:136 WALL ST",
        "CITY:Coventry",
        "CALL:Fire Alarm",
        "TIME:15:49",
        "X:MASON ST / MONUMENT HILL RD",
        "ID:2013-00000137");

    doTest(
        "T7",
        "(CVFA) 137 TOLLAND TPKE / Coventry ALS CHEST/SHOULDER PAIN(48 Y/O MALE) 13:33 Cross Street TOLLAND TOWN LINE / DIMOCK RD, JONES CROSSING RD 2013-00000065",
        "SRC:CVFA",
        "ADDR:137 TOLLAND TPKE",
        "CITY:Coventry",
        "CALL:ALS CHEST/SHOULDER PAIN(48 Y/O MALE)",
        "TIME:13:33",
        "X:TOLLAND TOWN LINE / DIMOCK RD, JONES CROSSING RD",
        "ID:2013-00000065");

    doTest(
        "T8",
        "(CVFA) 132 SKYVIEW DR / Coventry BLS RETONE- FALL- ENTER FROM GARAGE  12:38 Cross Street DUNN RD / DEAD END 2013-00000064",
        "SRC:CVFA",
        "ADDR:132 SKYVIEW DR",
        "CITY:Coventry",
        "CALL:BLS RETONE- FALL- ENTER FROM GARAGE",
        "TIME:12:38",
        "X:DUNN RD / DEAD END",
        "ID:2013-00000064");

    doTest(
        "T9",
        "(CVFA) 136 WALL ST / Coventry Fire Alarm 11:36 Cross Street MASON ST / MONUMENT HILL RD 2013-00000134",
        "SRC:CVFA",
        "ADDR:136 WALL ST",
        "CITY:Coventry",
        "CALL:Fire Alarm",
        "TIME:11:36",
        "X:MASON ST / MONUMENT HILL RD",
        "ID:2013-00000134");

    doTest(
        "T10",
        "(CVFA) 97 TWIN HILLS DR / Coventry BLS FALL/BLEEDING 15:43 Cross Street BOSTON TPKE / NEVILLE ST 2013-00000062",
        "SRC:CVFA",
        "ADDR:97 TWIN HILLS DR",
        "CITY:Coventry",
        "CALL:BLS FALL/BLEEDING",
        "TIME:15:43",
        "X:BOSTON TPKE / NEVILLE ST",
        "ID:2013-00000062");

    doTest(
        "T11",
        "(CVFA) 1630 MAIN ST Apt 33 / Coventry Orchard Hill EstatesBLS Medical Alarm Person Fell 22:27 Cross Street ELDERLY HOUSING / ST. MARY'S CHURCH 2013-00000145",
        "SRC:CVFA",
        "ADDR:1630 MAIN ST",
        "APT:33",
        "CITY:Coventry",
        "CALL:Orchard Hill EstatesBLS Medical Alarm Person Fell",
        "TIME:22:27",
        "X:ELDERLY HOUSING / ST. MARY'S CHURCH",
        "ID:2013-00000145");

  }

  @Test
  public void testBroadBrookFire() {

    doTest("T1",
        "(TN Alert) 53 RICE RD / Broad Brook ALS Overdose 01:57 Cross Street HARRINGTON RD / NORTH RD 2013-00000130",
        "ADDR:53 RICE RD",
        "CITY:Broad Brook",
        "CALL:ALS Overdose",
        "TIME:01:57",
        "X:HARRINGTON RD / NORTH RD",
        "ID:2013-00000130");

    doTest("T2",
        "(TN Alert) 53 RICE RD / Broad Brook ALS Swallowed Razor blade 00:42 Cross Street HARRINGTON RD / NORTH RD 2013-00000129",
        "ADDR:53 RICE RD",
        "CITY:Broad Brook",
        "CALL:ALS Swallowed Razor blade",
        "TIME:00:42",
        "X:HARRINGTON RD / NORTH RD",
        "ID:2013-00000129");

    doTest("T3",
        "(TN Alert) 35 MILL ST / B Broad Brook ALS Altered Mental Status / Diabetic 17:33 Cross Street BROOKSIDE DR / CHURCH ST 2013-00000128",
        "ADDR:35 MILL ST",
        "APT:B",
        "CITY:Broad Brook",
        "CALL:ALS Altered Mental Status / Diabetic",
        "TIME:17:33",
        "X:BROOKSIDE DR / CHURCH ST",
        "ID:2013-00000128");

    doTest("T4",
        "(TN Alert) 215 S  MAIN ST / Warehouse Point Fire Alarm MERCURY EXCELLIUM(WATERFLOW)ET139 13:19 Cross Street ABBE RD / STOUGHTON RD 2013-00000083",
        "ADDR:215 S MAIN ST",
        "CITY:Warehouse Point",
        "CALL:Fire Alarm MERCURY EXCELLIUM(WATERFLOW)ET139",
        "TIME:13:19",
        "X:ABBE RD / STOUGHTON RD",
        "ID:2013-00000083");

    doTest("T5",
        "(TN Alert) 27 PLEASANT ST / Warehouse Point Fire Alarm UNIT 14B(BROAD BROOK ET139) 20:48 Cross Street GRANDVIEW TER / ENFIELD TOWN LINE 2013-00000082",
        "ADDR:27 PLEASANT ST",
        "CITY:Warehouse Point",
        "CALL:Fire Alarm UNIT 14B(BROAD BROOK ET139)",
        "TIME:20:48",
        "X:GRANDVIEW TER / ENFIELD TOWN LINE",
        "ID:2013-00000082");

    doTest("T6",
        "(TN Alert) 139 MAIN ST / Broad Brook ALS MEET THE PD / ASSAULT / PT NOW UNRESP. 00:28 Cross Street HIGHLAND AVE / WINDSORVILLE RD, RYE ST 2013-00000500",
        "ADDR:139 MAIN ST",
        "CITY:Broad Brook",
        "CALL:ALS MEET THE PD / ASSAULT / PT NOW UNRESP.",
        "TIME:00:28",
        "X:HIGHLAND AVE / WINDSORVILLE RD, RYE ST",
        "ID:2013-00000500");

    doTest("T7",
        "(TN Alert) 1 HARTFIELD BLVD / Warehouse Point Smoke/Odor Investigation IN BLDG 21:38 Cross Street BRIDGE ST / DEAD END 2013-00000081",
        "ADDR:1 HARTFIELD BLVD",
        "CITY:Warehouse Point",
        "CALL:Smoke/Odor Investigation IN BLDG",
        "TIME:21:38",
        "X:BRIDGE ST / DEAD END",
        "ID:2013-00000081");

    doTest("T8",
        "(TN Alert) 39 CHURCH ST / Broad Brook Vehicle Accident CAR VS POLE CL&P LEVEL 3 23:13 Cross Street HARVEST DR / MAIN ST 2013-00000122",
        "ADDR:39 CHURCH ST",
        "CITY:Broad Brook",
        "CALL:Vehicle Accident CAR VS POLE CL&P LEVEL 3",
        "TIME:23:13",
        "X:HARVEST DR / MAIN ST",
        "ID:2013-00000122");

    doTest("T9",
        "(TN Alert) NORTH RD / HARRINGTON RD Broad Brook Vehicle Accident 18:06 Cross Street 2013-00000121",
        "ADDR:NORTH RD & HARRINGTON RD",
        "CITY:Broad Brook",
        "CALL:Vehicle Accident",
        "TIME:18:06",
        "ID:2013-00000121");

    doTest("T10",
        "(TN Alert) 21 ROLOCUT RD / Broad Brook ALS seizure 08:46 Cross Street WELLS RD / NORTH RD 2013-00000120",
        "ADDR:21 ROLOCUT RD",
        "CITY:Broad Brook",
        "CALL:ALS seizure",
        "X:WELLS RD / NORTH RD",
        "TIME:08:46",
        "ID:2013-00000120");

  }
  
  @Test
  public void testAshlandFire() {

    doTest("T1",
        "(TN Alert) 149 ASHFORD CENTER RD C3 / Ashford Birch Hill CondosBLS STAGE---PSYC EVAL 21:53 Cross Street WESTFORD RD, POMPEY HOLLOW RD, MANSFIELD RD / PUMPKIN HILL RD 2013-00000128",
        "ADDR:149 ASHFORD CENTER RD",
        "APT:C3",
        "CITY:Ashford",
        "CALL:Birch Hill CondosBLS STAGE---PSYC EVAL",
        "TIME:21:53",
        "X:WESTFORD RD, POMPEY HOLLOW RD, MANSFIELD RD / PUMPKIN HILL RD",
        "ID:2013-00000128");

    doTest("T2",
        "(TN Alert) 360 NORTH RD / Ashford ALS HYPERTENSION / DIF BREATHING 14:40 Cross Street SUMMER LN / WESTVIEW DR 2013-00000127",
        "ADDR:360 NORTH RD",
        "CITY:Ashford",
        "CALL:ALS HYPERTENSION / DIF BREATHING",
        "TIME:14:40",
        "X:SUMMER LN / WESTVIEW DR",
        "ID:2013-00000127");

    doTest("T3",
        "(TN Alert) 8 ASHFORD DR / Ashford ALS Diff Breathing 15:08 Cross Street FERENCE RD / PINE HILL DR 2013-00000126",
        "ADDR:8 ASHFORD DR",
        "CITY:Ashford",
        "CALL:ALS Diff Breathing",
        "TIME:15:08",
        "X:FERENCE RD / PINE HILL DR",
        "ID:2013-00000126");

    doTest("T4",
        "(TN Alert) 91 WATERFALL RD / Ashford ALS Unresponsive- ADDITIONAL MANPOWER 11:46 Cross Street HNATH RD / TURNPIKE RD 2013-00000125",
        "ADDR:91 WATERFALL RD",
        "CITY:Ashford",
        "CALL:ALS Unresponsive- ADDITIONAL MANPOWER",
        "TIME:11:46",
        "X:HNATH RD / TURNPIKE RD",
        "ID:2013-00000125");

    doTest("T5",
        "(TN Alert) 91 WATERFALL RD / Ashford ALS Unresponsive 11:46 Cross Street HNATH RD / TURNPIKE RD 2013-00000125",
        "ADDR:91 WATERFALL RD",
        "CITY:Ashford",
        "CALL:ALS Unresponsive",
        "TIME:11:46",
        "X:HNATH RD / TURNPIKE RD",
        "ID:2013-00000125");

    doTest("T6",
        "(TN Alert) 80 BICKNELL RD Apt23 / Ashford Woodlawn AptsBLS Psych Evaluation / Stage for CSP\n" +
        "  * * RETONE * *  18:58 Cross Street BEBBINGTON RD / MANSFIELD RD 2013-00000124",

        "ADDR:80 BICKNELL RD",
        "APT:23",
        "CITY:Ashford",
        "CALL:Woodlawn AptsBLS Psych Evaluation / Stage for CSP\n  * * RETONE * *",
        "TIME:18:58",
        "X:BEBBINGTON RD / MANSFIELD RD",
        "ID:2013-00000124");

    doTest("T7",
        "(TN Alert) 80 BICKNELL RD Apt23 / Ashford Woodlawn AptsBLS Psych Evaluation / Stage for CSP 18:58 Cross Street BEBBINGTON RD / MANSFIELD RD 2013-00000124",
        "ADDR:80 BICKNELL RD",
        "APT:23",
        "CITY:Ashford",
        "CALL:Woodlawn AptsBLS Psych Evaluation / Stage for CSP",
        "TIME:18:58",
        "X:BEBBINGTON RD / MANSFIELD RD",
        "ID:2013-00000124");

    doTest("T8",
        "(TN Alert) 111 MANSFIELD RD / Ashford ALS unresponsive 15:04 Cross Street SLADE RD / BICKNELL RD 2013-00000123",
        "ADDR:111 MANSFIELD RD",
        "CITY:Ashford",
        "CALL:ALS unresponsive",
        "TIME:15:04",
        "X:SLADE RD / BICKNELL RD",
        "ID:2013-00000123");

    doTest("T9",
        "(TN Alert) 54 FITTS RD / Ashford BLS 58 Y/O MALE FALL  10:23 Cross Street ASHFORD CENTER RD / DEAD END 2013-00000122",
        "ADDR:54 FITTS RD",
        "CITY:Ashford",
        "CALL:BLS 58 Y/O MALE FALL",
        "TIME:10:23",
        "X:ASHFORD CENTER RD / DEAD END",
        "ID:2013-00000122");

    doTest("T10",
        "(TN Alert) 76 COUNTY RD / Eastford ALS AMB - TROUBLE BREATHING 07:59 Cross Street MILL BRIDGE RD / BARLOW CEMETERY RD 2013-00000121",
        "ADDR:76 COUNTY RD",
        "CITY:Eastford",
        "CALL:ALS AMB - TROUBLE BREATHING",
        "TIME:07:59",
        "X:MILL BRIDGE RD / BARLOW CEMETERY RD",
        "ID:2013-00000121");

    doTest("T11",
        "(TN Alert) 217 POMPEY HOLLOW RD / Ashford Wooden Spoon RestaurantBLS FALL  14:08 Cross Street POMPEY RD / SQUAW HOLLOW RD, NOTT HWY 2013-00000120",
        "ADDR:217 POMPEY HOLLOW RD",
        "CITY:Ashford",
        "CALL:Wooden Spoon RestaurantBLS FALL",
        "TIME:14:08",
        "X:POMPEY RD / SQUAW HOLLOW RD, NOTT HWY",
        "ID:2013-00000120");

    doTest("T12",
        "(TN Alert) 4 KIDDER BROOK RD / Ashford Fire Alarm 07:52 Cross Street TURNPIKE RD / CHATEY RD 2013-00000119",
        "ADDR:4 KIDDER BROOK RD",
        "CITY:Ashford",
        "CALL:Fire Alarm",
        "TIME:07:52",
        "X:TURNPIKE RD / CHATEY RD",
        "ID:2013-00000119");

    doTest("T13",
        "(TN Alert) 440 WESTFORD RD / Ashford Ashford SchoolALS ALLERGIC REACTION 13:40 Cross Street WESTFORD HILL RD / OAKES RD 2013-00000118",
        "ADDR:440 WESTFORD RD",
        "CITY:Ashford",
        "CALL:Ashford SchoolALS ALLERGIC REACTION",
        "TIME:13:40",
        "X:WESTFORD HILL RD / OAKES RD",
        "ID:2013-00000118");

    doTest("T14",
        "(TN Alert) 195 PILFERSHIRE RD / Eastford Structure Fire AMB 520 ONLY REQUESTED 18:32 Cross Street UNKNOWN / FAYETTE RD 2013-00000117",
        "ADDR:195 PILFERSHIRE RD",
        "CITY:Eastford",
        "CALL:Structure Fire AMB 520 ONLY REQUESTED",
        "TIME:18:32",
        "X:UNKNOWN / FAYETTE RD",
        "ID:2013-00000117");

    doTest("T15",
        "(TN Alert) NOTT HWY / POMPEY HOLLOW RD Ashford Vehicle Accident W/O Injuries FIRE POLICE NEEDED 12:54 Cross Street 2013-00000116",
        "ADDR:NOTT HWY & POMPEY HOLLOW RD",
        "CITY:Ashford",
        "CALL:Vehicle Accident W/O Injuries FIRE POLICE NEEDED",
        "TIME:12:54",
        "ID:2013-00000116");

    doTest("T16",
        "(TN Alert) 181 WESTFORD RD / Eastford BLS Sick Person 15:32 Cross Street ASHFORD RD / CRYSTAL POND RD 2013-00000115",
        "ADDR:181 WESTFORD RD",
        "CITY:Eastford",
        "CALL:BLS Sick Person",
        "TIME:15:32",
        "X:ASHFORD RD / CRYSTAL POND RD",
        "ID:2013-00000115");

    doTest("T17",
        "(TN Alert) 370 SQUAW HOLLOW RD / Ashford CO No Symptoms 13:14 Cross Street KNOWLTON HILL RD / HOWARD RD 2013-00000114",
        "ADDR:370 SQUAW HOLLOW RD",
        "CITY:Ashford",
        "CALL:CO No Symptoms",
        "TIME:13:14",
        "X:KNOWLTON HILL RD / HOWARD RD",
        "ID:2013-00000114");

    doTest("T18",
        "(TN Alert) 181 WESTFORD RD / Eastford BLS Headache Result of a Fall\n" +
        "    * * RE-TONE * * 18:40 Cross Street ASHFORD RD / CRYSTAL POND RD 2013-00000113",

        "ADDR:181 WESTFORD RD",
        "CITY:Eastford",
        "CALL:BLS Headache Result of a Fall\n    * * RE-TONE * *",
        "TIME:18:40",
        "X:ASHFORD RD / CRYSTAL POND RD",
        "ID:2013-00000113");

    doTest("T19",
        "(TN Alert) 181 WESTFORD RD / Eastford BLS Headache Result of a Fall 18:40 Cross Street ASHFORD RD / CRYSTAL POND RD 2013-00000113",
        "ADDR:181 WESTFORD RD",
        "CITY:Eastford",
        "CALL:BLS Headache Result of a Fall",
        "TIME:18:40",
        "X:ASHFORD RD / CRYSTAL POND RD",
        "ID:2013-00000113");

    doTest("T20",
        "(TN Alert) 24 BRADWAY RD / Union Structure Fire Barn 15:38 Cross Street GEORGE HECK RD / OLD BROWN RD 2013-00000025",
        "ADDR:24 BRADWAY RD",
        "CITY:Union",
        "CALL:Structure Fire Barn",
        "TIME:15:38",
        "X:GEORGE HECK RD / OLD BROWN RD",
        "ID:2013-00000025");

    doTest("T21",
        "(TN Alert) 195 PILFERSHIRE RD / Eastford Structure Fire A520 NEEDED TO EASTFORD 22:08 Cross Street UNKNOWN / FAYETTE RD 2013-00000110",
        "ADDR:195 PILFERSHIRE RD",
        "CITY:Eastford",
        "CALL:Structure Fire A520 NEEDED TO EASTFORD",
        "TIME:22:08",
        "X:UNKNOWN / FAYETTE RD",
        "ID:2013-00000110");

    doTest("T22",
        "(TN Alert) 195 PILFERSHIRE RD / Eastford Structure Fire RETONE FOR AMBULANCE 22:08 Cross Street UNKNOWN / FAYETTE RD 2013-00000110",
        "ADDR:195 PILFERSHIRE RD",
        "CITY:Eastford",
        "CALL:Structure Fire RETONE FOR AMBULANCE",
        "TIME:22:08",
        "X:UNKNOWN / FAYETTE RD",
        "ID:2013-00000110");

    doTest("T23",
        "(TN Alert) 26 ASHFORD MOTEL RD / Ashford ASHFORD MOTELBLS INJURED PERSON(PREVIOUS MVA)UNIT8 22:09 Cross Street DEAD END / FISH POINT RD 2013-00000111",
        "ADDR:26 ASHFORD MOTEL RD",
        "CITY:Ashford",
        "CALL:ASHFORD MOTELBLS INJURED PERSON(PREVIOUS MVA)UNIT8",
        "TIME:22:09",
        "X:DEAD END / FISH POINT RD",
        "ID:2013-00000111");

    doTest("T24",
        "(TN Alert) 195 PILFERSHIRE RD / Eastford Structure Fire ASHFORD TO EASTFORD 22:08 Cross Street UNKNOWN / FAYETTE RD 2013-00000110",
        "ADDR:195 PILFERSHIRE RD",
        "CITY:Eastford",
        "CALL:Structure Fire ASHFORD TO EASTFORD",
        "TIME:22:08",
        "X:UNKNOWN / FAYETTE RD",
        "ID:2013-00000110");

  }

  public static void main(String[] args) {
    new CTTollandCountyAParserTest().generateTests("T1");
  }
}