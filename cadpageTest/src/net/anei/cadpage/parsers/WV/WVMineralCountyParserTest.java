package net.anei.cadpage.parsers.WV;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Mineral County, WV
Contact: Chris Green <mediccgreen@gmail.com>
Sender: xdc@mineralcounty911.com

S: M: ??? PFD:2012:0140 >2012-06-17 21:14:30 >ALERTED >ODOR UNKNOWN >47 WEST HAMPSHIRE ST, PIEDMONT
S: M: ??? PFD:2012:0143 >2012-06-24 12:47:25 >ALERTED >CARBON MONOXIDE/ETC-8 >49 1/2 THIRD STREET
S: M: ??? PFD:2012:0142 >2012-06-23 11:27:29 >ALERTED >TREE DOWN >119 RIORDIN RD WESTERNPORT
S: M: ??? PFD:2012:0144 >2012-06-25 18:45:52 >ALERTED >MVA W/INJURIES >RT 46, BETWEEN KEYSER& PIEDMONT
S: M: ??? PFD:2012:0145 >2012-06-28 18:43:10 >ALERTED >STAND BY >CO 20 STATION
S: M: ??? PFD:2012:0155 >2012-07-01 11:46:49 >ALERTED >TREE DOWN >322 GREEN ST WESTERNPORT
S: M: ??? PFD:2012:0154 >2012-07-01 10:46:31 >ALERTED >FIRE GARAGE >OFF OF PLUM RUN RD TO ROGERS DRIVE; 1641 RIDGELEY, RIDGELEY, MNRL WV
S: M: ??? PFD:2012:0153 >2012-07-01 10:34:47 >ALERTED >UNCONSC/FAINT-31 >57 ERIN ST, PIEDMONT (;)

Contact: Active911
Agency name: New Creek Volunteer Fire Department
Location: New Creek, WV, United States
Sender: xdc@mineralcounty911.com

ï»¿<HTML><body>NCFD:2012:0544<br />2012-12-26 13:54:55<br />ALERTED<br />CONVULSIONS/SEIZURES-12<br />1036 TRENUM DRIVE OFF PINE SWAMP ROAD</body></HTML>
ï»¿<HTML><body>NCFD:2012:0543<br />2012-12-24 20:15:44<br />ALERTED<br />MVA<br />ACROSS FROM SUNNYSIDE CHURCH ON RT 50, BROWN BRICK HOUSE, KIMBLE RES</body></HTML>
ï»¿<HTML><body>NCFD:2012:0542<br />2012-12-24 15:21:09<br />ALERTED<br />MVA<br />RT 972, IN FRONT OF CO 38</body></HTML>
ï»¿<HTML><body>NCFD:2012:0541<br />2012-12-24 15:13:30<br />ALERTED<br />MVA<br />RT 50, NEXT TO RT 972 INTERSECTION</body></HTML>
ï»¿<HTML><body>NCFD:2012:0539<br />2012-12-24 14:37:08<br />ALERTED<br />MVA<br />RT 50, OUTSIDE OF KEYSER ON RT 220, MORGAN RD &amp; RT 220 INTERSECTION</body></HTML>
ï»¿<HTML><body>NCFD:2012:0538<br />2012-12-24 13:51:57<br />ALERTED<br />MVA<br />1 HERSHEY HOLLOW RD, KEYSER (;)</body></HTML>
ï»¿<HTML><body>NCFD:2012:0537<br />2012-12-23 18:32:31<br />ALERTED<br />OVERDOSE/POISONING-23<br />PINE POINT SUDIVISION</body></HTML>
ï»¿<HTML><body>KEMS:2012:0987<br />2012-12-23 08:40:03<br />ALERTED<br />FALLS-17<br />182 FORT AVE, KEYSER; KEN MURPHY RES</body></HTML>
ï»¿<HTML><body>KEMS:2012:0986<br />2012-12-22 13:47:42<br />ALERTED<br />CHEST PAINS-10<br />135 SOUTHERN DR, MAIN DOOR TO THE RIGHT AT NURSES STATION</body></HTML>
ï»¿<HTML><body>NCFD:2012:0536<br />2012-12-21 22:47:42<br />ALERTED<br />MVA<br />SUNNYSIDE CHURCH, RT 50</body></HTML>
ï»¿<HTML><body>NCFD:2012:0535<br />2012-12-21 04:03:19<br />ALERTED<br />UNCONSC/FAINT-31<br />21219 BURKE HILL RD MCCOOLE</body></HTML>
ï»¿<HTML><body>NCFD:2012:0534<br />2012-12-21 02:44:57<br />ALERTED<br />CHEST PAINS-10<br />NEW CRK, NEW CREEK, MNRL WV</body></HTML>
ï»¿<HTML><body>EDA:2012:0208<br />2012-12-18 08:06:17<br />ALERTED<br />ABDOMINAL PAIN/PROBLEMS-1<br />melvin dunnivan residence 1/2 mile down on shady side road; white hse. w/ blk shutters</body></HTML>
ï»¿<HTML><body>NCFD:2012:0533<br />2012-12-17 21:47:19<br />ALERTED<br />MVA<br />KEYSER WALMART NEAR THE GAS STATION</body></HTML>
ï»¿<HTML><body>NCFD:2012:0533<br />2012-12-17 21:47:19<br />ALERTED<br />MVA<br />KEYSER WALMART</body></HTML>
ï»¿<HTML><body>SPFD:2012:0001<br />2012-12-17 16:56:36<br />ALERTED<br />FALLS-17<br />OFF PINE SWAMP ROAD, HICKORY KNOLLS SUBD, BLACK TOP ROAD, GO STRAIGHT, TO END THEN TURN RIGHT, ALL THE WAY TO TOP, BEIGE SIDING WITH BROWN SHINGLES, MINER RES</body></HTML>
ï»¿<HTML><body>NCFD:2012:0532<br />2012-12-17 11:07:04<br />ALERTED<br />SICK PERSON (SPECIFIC DIAGNOSIS)-26<br />OPTIMA GAS STATION</body></HTML>
ï»¿<HTML><body>KEMS:2012:0975<br />2012-12-17 09:47:09<br />ALERTED<br />BACK PAIN-5<br />15 A STREET, KEYSER</body></HTML>
ï»¿<HTML><body>NCFD:2012:0531<br />2012-12-17 00:19:50<br />ALERTED<br />BREATHING PROBLEMS-6<br />8057 BAYBERRY</body></HTML>
ï»¿<HTML><body>NCFD:2012:0530<br />2012-12-13 12:45:45<br />ALERTED<br />FALLS-17<br />225 BOBWHITE DR, KEYSER</body></HTML>
ï»¿<HTML><body>NCFD:2012:0529<br />2012-12-13 07:21:14<br />ALERTED<br />OVERDOSE/POISONING-23<br />402 HOLLOW RD OFF OF SUNNYDALE</body></HTML>
ï»¿<HTML><body>KEMS:2012:0953<br />2012-12-12 06:29:56<br />ALERTED<br />SICK PERSON (SPECIFIC DIAGNOSIS)-26<br />1325 CORNELL ST, KEYSER  MANNS RESIDENCE</body></HTML>
ï»¿<HTML><body>KEMS:2012:0946<br />2012-12-11 03:59:18<br />ALERTED<br />ASSISTANCE<br />75 THIRD ST, KEYSER</body></HTML>
ï»¿<HTML><body>NCFD:2012:0528<br />2012-12-11 00:46:45<br />ALERTED<br />CHEST PAINS-10<br />PINESWAMP RD SCOTT HORTON RES</body></HTML>
ï»¿<HTML><body>EDA:2012:0204<br />2012-12-08 22:37:57<br />ALERTED<br />ABDOMINAL PAIN/PROBLEMS-1<br />2ND HSE ON RIGHT ON PAUGHTOWN RD, PAUGH</body></HTML>
ï»¿<HTML><body>KEMS:2012:0933<br />2012-12-08 07:18:58<br />ALERTED<br />BREATHING PROBLEMS-6<br />345 MAPLE AVE LOT 215 AKA 215 PEARL ALLEY, KEYSER THE OWENS RES. TAKE LEFT ON MAPLE; FOLLOW UNTIL PEARL ALLEY. TRAILER FACING PEARL.\nRES. IS ON THE RIGHT.</body></HTML>
ï»¿<HTML><body>NCFD:2012:0527<br />2012-12-07 10:57:53<br />ALERTED<br />FALLS-17<br />1036 TRENUM DRIVE</body></HTML>
ï»¿<HTML><body>NCFD:2012:0526<br />2012-12-06 12:37:28<br />ALERTED<br />SICK PERSON (SPECIFIC DIAGNOSIS)-26<br />RT 972 5TH ABOVE FIREHALL</body></HTML>
ï»¿<HTML><body>NCFD:2012:0525<br />2012-12-05 15:31:03<br />ALERTED<br />ABDOMINAL PAIN/PROBLEMS-1<br />TRENUM DRIVE, 2ND HSE ON THE RIGHT, LINDA LILLER RES</body></HTML>
ï»¿<HTML><body>NCFD:2012:0523<br />2012-12-04 15:00:33<br />ALERTED<br />HEMORRHAGE/LACERATIONS-21<br />1015B TRENUM DRIVE, NEW CREEK HEIGHTS(EVELYN HARMAN RES), WHERE IT VEERS OFF, VEER TO RIGHT, WHITE TRAILER</body></HTML>
ï»¿<HTML><body>NCFD:2012:0522<br />2012-12-04 12:16:40<br />ALERTED<br />SICK PERSON (SPECIFIC DIAGNOSIS)-26<br />CUTOFF RD, 7/10 MILES UP ON RIGHT(2ND RES)DAVID SNYDER RES</body></HTML>
ï»¿<HTML><body>NCFD:2012:0520<br />2012-12-03 09:51:42<br />ALERTED<br />BREATHING PROBLEMS-6<br />1015 B TRENUM DR ON RGT EVELYN HARMAN RES WHT TRLR</body></HTML>
ï»¿<HTML><body>NCFD:2012:0519<br />2012-12-01 16:32:01<br />ALERTED<br />MVA<br />RT 220 NEAR WALMART, IN FRONT OF COLDWELL BANKER</body></HTML>
ï»¿<HTML><body>NCFD:2012:0518<br />2012-12-01 10:27:03<br />ALERTED<br />STAND BY<br />TRI-TOWNS CO 50</body></HTML>
ï»¿<HTML><body>BFD:2012:0411<br />2012-12-01 01:35:45<br />ALERTED<br />MVA<br />PATTERSON CRK 4 MILES SOUTH OF RT 50 ACROSS FROM KESSEL MULCH</body></HTML>
ï»¿<HTML><body>KEMS:2012:0912<br />2012-11-30 20:39:35<br />ALERTED<br />CONVULSIONS/SEIZURES-12<br />500 CARSKADON LN, KEYSER APT 201</body></HTML>
ï»¿<HTML><body>NCFD:2012:0517<br />2012-11-30 11:28:16<br />ALERTED<br />ALARM SOUNDING<br />1061 TRENUM DRIVE; WHT HSE W/HORSESHOE DRIVEWAY</body></HTML>
ï»¿<HTML><body>NCFD:2012:0516<br />2012-11-29 16:41:06<br />ALERTED<br />FALLS-17<br />7045 BAYBERRY DRIVE, GO STRAIGHT BACK TO THE RIGHT</body></HTML>
ï»¿<HTML><body>KEMS:2012:0908<br />2012-11-29 08:53:15<br />ALERTED<br />HEADACHE-18<br />STONEY RUN ROAD FROM RT. 220 1/8 MILE ON THE RIGHT. MAROON AND GRAY RED BLAZER IN DRIVE; ARNOLD AND BARBARA EVANS</body></HTML>
ï»¿<HTML><body>GRANT:2012:0028<br />2012-11-28 17:14:22<br />ALERTED<br />MVA<br />RT 50 1 MILE OUTSIDE OF MOUNT STORM</body></HTML>
ï»¿<HTML><body>NCFD:2012:0515<br />2012-11-28 11:15:02<br />ALERTED<br />CHEST PAINS-10<br />147 MAPLESIDE COURT, HEARLY HGTS, DROPPLEMAN RES</body></HTML>
ï»¿<HTML><body>BFD:2012:0404<br />2012-11-27 10:12:13<br />ALERTED<br />FIRE FLUE<br />SHIRLEY'S LANE OFF RT. 50 2 MILES IN ON LEFT; DOMAN RESIDENCE</body></HTML>

Contact: Active911
Agency name: Tri-Towns Fire Co # 1
Location: Piedmont, WV, United States
Sender: xdc@mineralcounty911.com

ï»¿<HTML><body>PFD:2012:0228<br />2012-12-26 20:02:12<br />ALERTED<br />MVA<br />OFF RT 46 ONTO THE MINING RD, ELK GARDEN</body></HTML>
ï»¿<HTML><body>PFD:2012:0227<br />2012-12-26 14:54:12<br />ALERTED<br />GAS EMERGENCY<br />WEST HAMPSHIRE STREET FRANCINE GARLAND RES.</body></HTML>
ï»¿<HTML><body>PFD:2012:0226<br />2012-12-25 12:20:18<br />ALERTED<br />FIRE ALARM COMMERCIAL<br />25 JONES STREET</body></HTML>
ï»¿<HTML><body>PFD:2012:0225<br />2012-12-24 09:52:40<br />ALERTED<br />MVA<br />RT 46, PIEDMONT SIDE OF RILEY'S HSE</body></HTML>
ï»¿<HTML><body>PFD:2012:0224<br />2012-12-23 20:23:39<br />ALERTED<br />SMOKE IN RESIDENCE<br />81 ERIN STREET PIEDMONT</body></HTML>
ï»¿<HTML><body>PFD:2012:0223<br />2012-12-18 00:07:47<br />ALERTED<br />FIRE RESIDENTIAL<br />21ST BRIDGE ROAD  MCOOLE</body></HTML>
ï»¿<HTML><body>PFD:2012:0220<br />2012-12-12 17:15:29<br />ALERTED<br />FIRE FLUE<br />307 VINE ST</body></HTML>
ï»¿<HTML><body>PFD:2012:0218<br />2012-12-09 00:29:02<br />ALERTED<br />MUTUAL AID<br />110 SOUTH BROADWAY FROST BURG</body></HTML>

*/

public class WVMineralCountyParserTest extends BaseParserTest {
  
  public WVMineralCountyParserTest() {
    setParser(new WVMineralCountyParser(), "MINERAL COUNTY", "WV");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "S: M: ??? PFD:2012:0140 >2012-06-17 21:14:30 >ALERTED >ODOR UNKNOWN >47 WEST HAMPSHIRE ST, PIEDMONT",
        "SRC:PFD",
        "ID:2012:0140",
        "DATE:06/17/2012",
        "TIME:21:14:30",
        "CALL:ODOR UNKNOWN",
        "ADDR:47 WEST HAMPSHIRE ST",
        "CITY:PIEDMONT");

    doTest("T2",
        "S: M: ??? PFD:2012:0143 >2012-06-24 12:47:25 >ALERTED >CARBON MONOXIDE/ETC-8 >49 1/2 THIRD STREET",
        "SRC:PFD",
        "ID:2012:0143",
        "DATE:06/24/2012",
        "TIME:12:47:25",
        "CALL:CARBON MONOXIDE/ETC-8",
        "ADDR:49 1/2 THIRD STREET");

    doTest("T3",
        "S: M: ??? PFD:2012:0142 >2012-06-23 11:27:29 >ALERTED >TREE DOWN >119 RIORDIN RD WESTERNPORT",
        "SRC:PFD",
        "ID:2012:0142",
        "DATE:06/23/2012",
        "TIME:11:27:29",
        "CALL:TREE DOWN",
        "ADDR:119 RIORDIN RD",
        "CITY:WESTERNPORT",
        "ST:MD");

    doTest("T4",
        "S: M: ??? PFD:2012:0144 >2012-06-25 18:45:52 >ALERTED >MVA W/INJURIES >RT 46, BETWEEN KEYSER& PIEDMONT",
        "SRC:PFD",
        "ID:2012:0144",
        "DATE:06/25/2012",
        "TIME:18:45:52",
        "CALL:MVA W/INJURIES",
        "ADDR:RT 46",
        "MADDR:RT 46 & KEYSER",
        "X:KEYSER& PIEDMONT");

    doTest("T5",
        "S: M: ??? PFD:2012:0145 >2012-06-28 18:43:10 >ALERTED >STAND BY >CO 20 STATION",
        "SRC:PFD",
        "ID:2012:0145",
        "DATE:06/28/2012",
        "TIME:18:43:10",
        "CALL:STAND BY",
        "ADDR:CO 20",
        "MADDR:COUNTY ROAD 20",
        "INFO:STATION");

    doTest("T6",
        "S: M: ??? PFD:2012:0155 >2012-07-01 11:46:49 >ALERTED >TREE DOWN >322 GREEN ST WESTERNPORT",
        "SRC:PFD",
        "ID:2012:0155",
        "DATE:07/01/2012",
        "TIME:11:46:49",
        "CALL:TREE DOWN",
        "ADDR:322 GREEN ST",
        "CITY:WESTERNPORT",
        "ST:MD");

    doTest("T7",
        "S: M: ??? PFD:2012:0154 >2012-07-01 10:46:31 >ALERTED >FIRE GARAGE >OFF OF PLUM RUN RD TO ROGERS DRIVE; 1641 RIDGELEY, RIDGELEY, MNRL WV",
        "SRC:PFD",
        "ID:2012:0154",
        "DATE:07/01/2012",
        "TIME:10:46:31",
        "CALL:FIRE GARAGE",
        "ADDR:OFF OF PLUM RUN RD TO ROGERS DRIVE",
        "MADDR:& OF PLUM RUN RD TO ROGERS DRIVE",
        "CITY:RIDGELEY",
        "INFO:1641 RIDGELEY");

    doTest("T8",
        "S: M: ??? PFD:2012:0153 >2012-07-01 10:34:47 >ALERTED >UNCONSC/FAINT-31 >57 ERIN ST, PIEDMONT (;)",
        "SRC:PFD",
        "ID:2012:0153",
        "DATE:07/01/2012",
        "TIME:10:34:47",
        "CALL:UNCONSC/FAINT-31",
        "ADDR:57 ERIN ST",
        "CITY:PIEDMONT");

  }
  
  @Test
  public void testNewCreekFire() {

    doTest("T1",
        "ï»¿<HTML><body>NCFD:2012:0544<br />2012-12-26 13:54:55<br />ALERTED<br />CONVULSIONS/SEIZURES-12<br />1036 TRENUM DRIVE OFF PINE SWAMP ROAD</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0544",
        "DATE:12/26/2012",
        "TIME:13:54:55",
        "CALL:CONVULSIONS/SEIZURES-12",
        "ADDR:1036 TRENUM DRIVE",
        "INFO:OFF PINE SWAMP ROAD");

    doTest("T2",
        "ï»¿<HTML><body>NCFD:2012:0543<br />2012-12-24 20:15:44<br />ALERTED<br />MVA<br />ACROSS FROM SUNNYSIDE CHURCH ON RT 50, BROWN BRICK HOUSE, KIMBLE RES</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0543",
        "DATE:12/24/2012",
        "TIME:20:15:44",
        "CALL:MVA",
        "ADDR:ACROSS FROM SUNNYSIDE CHURCH ON RT 50",
        "INFO:BROWN BRICK HOUSE / KIMBLE RES");

    doTest("T3",
        "ï»¿<HTML><body>NCFD:2012:0542<br />2012-12-24 15:21:09<br />ALERTED<br />MVA<br />RT 972, IN FRONT OF CO 38</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0542",
        "DATE:12/24/2012",
        "TIME:15:21:09",
        "CALL:MVA",
        "ADDR:RT 972",
        "INFO:IN FRONT OF CO 38");

    doTest("T4",
        "ï»¿<HTML><body>NCFD:2012:0541<br />2012-12-24 15:13:30<br />ALERTED<br />MVA<br />RT 50, NEXT TO RT 972 INTERSECTION</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0541",
        "DATE:12/24/2012",
        "TIME:15:13:30",
        "CALL:MVA",
        "ADDR:RT 50 & RT 972");

    doTest("T5",
        "ï»¿<HTML><body>NCFD:2012:0539<br />2012-12-24 14:37:08<br />ALERTED<br />MVA<br />RT 50, OUTSIDE OF KEYSER ON RT 220, MORGAN RD &amp; RT 220 INTERSECTION</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0539",
        "DATE:12/24/2012",
        "TIME:14:37:08",
        "CALL:MVA",
        "ADDR:RT 50",
        "INFO:OUTSIDE OF KEYSER ON RT 220 / MORGAN RD & RT 220 INTERSECTION");

    doTest("T6",
        "ï»¿<HTML><body>NCFD:2012:0538<br />2012-12-24 13:51:57<br />ALERTED<br />MVA<br />1 HERSHEY HOLLOW RD, KEYSER (;)</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0538",
        "DATE:12/24/2012",
        "TIME:13:51:57",
        "CALL:MVA",
        "ADDR:1 HERSHEY HOLLOW RD",
        "CITY:KEYSER");

    doTest("T7",
        "ï»¿<HTML><body>NCFD:2012:0537<br />2012-12-23 18:32:31<br />ALERTED<br />OVERDOSE/POISONING-23<br />PINE POINT SUDIVISION</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0537",
        "DATE:12/23/2012",
        "TIME:18:32:31",
        "CALL:OVERDOSE/POISONING-23",
        "ADDR:PINE POINT SUDIVISION");

    doTest("T8",
        "ï»¿<HTML><body>KEMS:2012:0987<br />2012-12-23 08:40:03<br />ALERTED<br />FALLS-17<br />182 FORT AVE, KEYSER; KEN MURPHY RES</body></HTML>",
        "SRC:KEMS",
        "ID:2012:0987",
        "DATE:12/23/2012",
        "TIME:08:40:03",
        "CALL:FALLS-17",
        "ADDR:182 FORT AVE",
        "CITY:KEYSER",
        "INFO:KEN MURPHY RES");

    doTest("T9",
        "ï»¿<HTML><body>KEMS:2012:0986<br />2012-12-22 13:47:42<br />ALERTED<br />CHEST PAINS-10<br />135 SOUTHERN DR, MAIN DOOR TO THE RIGHT AT NURSES STATION</body></HTML>",
        "SRC:KEMS",
        "ID:2012:0986",
        "DATE:12/22/2012",
        "TIME:13:47:42",
        "CALL:CHEST PAINS-10",
        "ADDR:135 SOUTHERN DR",
        "INFO:MAIN DOOR TO THE RIGHT AT NURSES STATION");

    doTest("T10",
        "ï»¿<HTML><body>NCFD:2012:0536<br />2012-12-21 22:47:42<br />ALERTED<br />MVA<br />SUNNYSIDE CHURCH, RT 50</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0536",
        "DATE:12/21/2012",
        "TIME:22:47:42",
        "CALL:MVA",
        "PLACE:SUNNYSIDE CHURCH",
        "ADDR:RT 50");

    doTest("T11",
        "ï»¿<HTML><body>NCFD:2012:0535<br />2012-12-21 04:03:19<br />ALERTED<br />UNCONSC/FAINT-31<br />21219 BURKE HILL RD MCCOOLE</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0535",
        "DATE:12/21/2012",
        "TIME:04:03:19",
        "CALL:UNCONSC/FAINT-31",
        "ADDR:21219 BURKE HILL RD",
        "CITY:MCCOOLE",
        "ST:MD");

    doTest("T12",
        "ï»¿<HTML><body>NCFD:2012:0534<br />2012-12-21 02:44:57<br />ALERTED<br />CHEST PAINS-10<br />NEW CRK, NEW CREEK, MNRL WV</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0534",
        "DATE:12/21/2012",
        "TIME:02:44:57",
        "CALL:CHEST PAINS-10",
        "ADDR:NEW CRK",
        "CITY:NEW CREEK");

    doTest("T13",
        "ï»¿<HTML><body>EDA:2012:0208<br />2012-12-18 08:06:17<br />ALERTED<br />ABDOMINAL PAIN/PROBLEMS-1<br />melvin dunnivan residence 1/2 mile down on shady side road; white hse. w/ blk shutters</body></HTML>",
        "SRC:EDA",
        "ID:2012:0208",
        "DATE:12/18/2012",
        "TIME:08:06:17",
        "CALL:ABDOMINAL PAIN/PROBLEMS-1",
        "ADDR:melvin dunnivan residence 1/2 mile down on shady side road",
        "INFO:white hse. w/ blk shutters");

    doTest("T14",
        "ï»¿<HTML><body>NCFD:2012:0533<br />2012-12-17 21:47:19<br />ALERTED<br />MVA<br />KEYSER WALMART NEAR THE GAS STATION</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0533",
        "DATE:12/17/2012",
        "TIME:21:47:19",
        "CALL:MVA",
        "ADDR:KEYSER WALMART NEAR THE GAS STATION",
        "MADDR:KEYSER WALMART & THE GAS STATION");


    doTest("T15",
        "ï»¿<HTML><body>NCFD:2012:0533<br />2012-12-17 21:47:19<br />ALERTED<br />MVA<br />KEYSER WALMART</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0533",
        "DATE:12/17/2012",
        "TIME:21:47:19",
        "CALL:MVA",
        "ADDR:KEYSER WALMART");

    doTest("T16",
        "ï»¿<HTML><body>SPFD:2012:0001<br />2012-12-17 16:56:36<br />ALERTED<br />FALLS-17<br />OFF PINE SWAMP ROAD, HICKORY KNOLLS SUBD, BLACK TOP ROAD, GO STRAIGHT, TO END THEN TURN RIGHT, ALL THE WAY TO TOP, BEIGE SIDING WITH BROWN SHINGLES, MINER RES</body></HTML>",
        "SRC:SPFD",
        "ID:2012:0001",
        "DATE:12/17/2012",
        "TIME:16:56:36",
        "CALL:FALLS-17",
        "ADDR:OFF PINE SWAMP ROAD",
        "MADDR:& PINE SWAMP ROAD",
        "INFO:HICKORY KNOLLS SUBD / BLACK TOP ROAD / GO STRAIGHT / TO END THEN TURN RIGHT / ALL THE WAY TO TOP / BEIGE SIDING WITH BROWN SHINGLES / MINER RES");

    doTest("T17",
        "ï»¿<HTML><body>NCFD:2012:0532<br />2012-12-17 11:07:04<br />ALERTED<br />SICK PERSON (SPECIFIC DIAGNOSIS)-26<br />OPTIMA GAS STATION</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0532",
        "DATE:12/17/2012",
        "TIME:11:07:04",
        "CALL:SICK PERSON (SPECIFIC DIAGNOSIS)-26",
        "ADDR:OPTIMA GAS STATION");

    doTest("T18",
        "ï»¿<HTML><body>KEMS:2012:0975<br />2012-12-17 09:47:09<br />ALERTED<br />BACK PAIN-5<br />15 A STREET, KEYSER</body></HTML>",
        "SRC:KEMS",
        "ID:2012:0975",
        "DATE:12/17/2012",
        "TIME:09:47:09",
        "CALL:BACK PAIN-5",
        "ADDR:15 A STREET",
        "CITY:KEYSER");

    doTest("T19",
        "ï»¿<HTML><body>NCFD:2012:0531<br />2012-12-17 00:19:50<br />ALERTED<br />BREATHING PROBLEMS-6<br />8057 BAYBERRY</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0531",
        "DATE:12/17/2012",
        "TIME:00:19:50",
        "CALL:BREATHING PROBLEMS-6",
        "ADDR:8057 BAYBERRY");

    doTest("T20",
        "ï»¿<HTML><body>NCFD:2012:0530<br />2012-12-13 12:45:45<br />ALERTED<br />FALLS-17<br />225 BOBWHITE DR, KEYSER</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0530",
        "DATE:12/13/2012",
        "TIME:12:45:45",
        "CALL:FALLS-17",
        "ADDR:225 BOBWHITE DR",
        "CITY:KEYSER");

    doTest("T21",
        "ï»¿<HTML><body>NCFD:2012:0529<br />2012-12-13 07:21:14<br />ALERTED<br />OVERDOSE/POISONING-23<br />402 HOLLOW RD OFF OF SUNNYDALE</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0529",
        "DATE:12/13/2012",
        "TIME:07:21:14",
        "CALL:OVERDOSE/POISONING-23",
        "ADDR:402 HOLLOW RD",
        "INFO:OFF OF SUNNYDALE");

    doTest("T22",
        "ï»¿<HTML><body>KEMS:2012:0953<br />2012-12-12 06:29:56<br />ALERTED<br />SICK PERSON (SPECIFIC DIAGNOSIS)-26<br />1325 CORNELL ST, KEYSER  MANNS RESIDENCE</body></HTML>",
        "SRC:KEMS",
        "ID:2012:0953",
        "DATE:12/12/2012",
        "TIME:06:29:56",
        "CALL:SICK PERSON (SPECIFIC DIAGNOSIS)-26",
        "ADDR:1325 CORNELL ST",
        "INFO:KEYSER  MANNS RESIDENCE");

    doTest("T23",
        "ï»¿<HTML><body>KEMS:2012:0946<br />2012-12-11 03:59:18<br />ALERTED<br />ASSISTANCE<br />75 THIRD ST, KEYSER</body></HTML>",
        "SRC:KEMS",
        "ID:2012:0946",
        "DATE:12/11/2012",
        "TIME:03:59:18",
        "CALL:ASSISTANCE",
        "ADDR:75 THIRD ST",
        "CITY:KEYSER");

    doTest("T24",
        "ï»¿<HTML><body>NCFD:2012:0528<br />2012-12-11 00:46:45<br />ALERTED<br />CHEST PAINS-10<br />PINESWAMP RD SCOTT HORTON RES</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0528",
        "DATE:12/11/2012",
        "TIME:00:46:45",
        "CALL:CHEST PAINS-10",
        "ADDR:PINESWAMP RD",
        "INFO:SCOTT HORTON RES");

    doTest("T25",
        "ï»¿<HTML><body>EDA:2012:0204<br />2012-12-08 22:37:57<br />ALERTED<br />ABDOMINAL PAIN/PROBLEMS-1<br />2ND HSE ON RIGHT ON PAUGHTOWN RD, PAUGH</body></HTML>",
        "SRC:EDA",
        "ID:2012:0204",
        "DATE:12/08/2012",
        "TIME:22:37:57",
        "CALL:ABDOMINAL PAIN/PROBLEMS-1",
        "ADDR:2ND HSE ON RIGHT ON PAUGHTOWN RD",
        "INFO:PAUGH");

    doTest("T26",
        "ï»¿<HTML><body>KEMS:2012:0933<br />2012-12-08 07:18:58<br />ALERTED<br />BREATHING PROBLEMS-6<br />345 MAPLE AVE LOT 215 AKA 215 PEARL ALLEY, KEYSER THE OWENS RES. TAKE LEFT ON MAPLE; FOLLOW UNTIL PEARL ALLEY. TRAILER FACING PEARL.\n" +
        "RES. IS ON THE RIGHT.</body></HTML>",

        "SRC:KEMS",
        "ID:2012:0933",
        "DATE:12/08/2012",
        "TIME:07:18:58",
        "CALL:BREATHING PROBLEMS-6",
        "ADDR:345 MAPLE AVE",
        "APT:215",
        "INFO:AKA 215 PEARL ALLEY / KEYSER THE OWENS RES. TAKE LEFT ON MAPLE / FOLLOW UNTIL PEARL ALLEY. TRAILER FACING PEARL.");

    doTest("T27",
        "ï»¿<HTML><body>NCFD:2012:0527<br />2012-12-07 10:57:53<br />ALERTED<br />FALLS-17<br />1036 TRENUM DRIVE</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0527",
        "DATE:12/07/2012",
        "TIME:10:57:53",
        "CALL:FALLS-17",
        "ADDR:1036 TRENUM DRIVE");

    doTest("T28",
        "ï»¿<HTML><body>NCFD:2012:0526<br />2012-12-06 12:37:28<br />ALERTED<br />SICK PERSON (SPECIFIC DIAGNOSIS)-26<br />RT 972 5TH ABOVE FIREHALL</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0526",
        "DATE:12/06/2012",
        "TIME:12:37:28",
        "CALL:SICK PERSON (SPECIFIC DIAGNOSIS)-26",
        "ADDR:RT 972",
        "APT:5TH",
        "INFO:ABOVE FIREHALL");

    doTest("T29",
        "ï»¿<HTML><body>NCFD:2012:0525<br />2012-12-05 15:31:03<br />ALERTED<br />ABDOMINAL PAIN/PROBLEMS-1<br />TRENUM DRIVE, 2ND HSE ON THE RIGHT, LINDA LILLER RES</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0525",
        "DATE:12/05/2012",
        "TIME:15:31:03",
        "CALL:ABDOMINAL PAIN/PROBLEMS-1",
        "ADDR:TRENUM DRIVE",
        "INFO:2ND HSE ON THE RIGHT / LINDA LILLER RES");

    doTest("T30",
        "ï»¿<HTML><body>NCFD:2012:0523<br />2012-12-04 15:00:33<br />ALERTED<br />HEMORRHAGE/LACERATIONS-21<br />1015B TRENUM DRIVE, NEW CREEK HEIGHTS(EVELYN HARMAN RES), WHERE IT VEERS OFF, VEER TO RIGHT, WHITE TRAILER</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0523",
        "DATE:12/04/2012",
        "TIME:15:00:33",
        "CALL:HEMORRHAGE/LACERATIONS-21",
        "ADDR:1015B TRENUM DRIVE",
        "INFO:NEW CREEK HEIGHTS(EVELYN HARMAN RES) / WHERE IT VEERS OFF / VEER TO RIGHT / WHITE TRAILER");

    doTest("T31",
        "ï»¿<HTML><body>NCFD:2012:0522<br />2012-12-04 12:16:40<br />ALERTED<br />SICK PERSON (SPECIFIC DIAGNOSIS)-26<br />CUTOFF RD, 7/10 MILES UP ON RIGHT(2ND RES)DAVID SNYDER RES</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0522",
        "DATE:12/04/2012",
        "TIME:12:16:40",
        "CALL:SICK PERSON (SPECIFIC DIAGNOSIS)-26",
        "ADDR:CUTOFF RD",
        "INFO:7/10 MILES UP ON RIGHT(2ND RES)DAVID SNYDER RES");

    doTest("T32",
        "ï»¿<HTML><body>NCFD:2012:0520<br />2012-12-03 09:51:42<br />ALERTED<br />BREATHING PROBLEMS-6<br />1015 B TRENUM DR ON RGT EVELYN HARMAN RES WHT TRLR</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0520",
        "DATE:12/03/2012",
        "TIME:09:51:42",
        "CALL:BREATHING PROBLEMS-6",
        "ADDR:1015 B TRENUM DR",
        "INFO:ON RGT EVELYN HARMAN RES WHT TRLR");

    doTest("T33",
        "ï»¿<HTML><body>NCFD:2012:0519<br />2012-12-01 16:32:01<br />ALERTED<br />MVA<br />RT 220 NEAR WALMART, IN FRONT OF COLDWELL BANKER</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0519",
        "DATE:12/01/2012",
        "TIME:16:32:01",
        "CALL:MVA",
        "ADDR:RT 220",
        "INFO:NEAR WALMART / IN FRONT OF COLDWELL BANKER");

    doTest("T34",
        "ï»¿<HTML><body>NCFD:2012:0518<br />2012-12-01 10:27:03<br />ALERTED<br />STAND BY<br />TRI-TOWNS CO 50</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0518",
        "DATE:12/01/2012",
        "TIME:10:27:03",
        "CALL:STAND BY",
        "ADDR:TRI-TOWNS CO 50",
        "MADDR:TRI-TOWNS COUNTY ROAD 50");

    doTest("T35",
        "ï»¿<HTML><body>BFD:2012:0411<br />2012-12-01 01:35:45<br />ALERTED<br />MVA<br />PATTERSON CRK 4 MILES SOUTH OF RT 50 ACROSS FROM KESSEL MULCH</body></HTML>",
        "SRC:BFD",
        "ID:2012:0411",
        "DATE:12/01/2012",
        "TIME:01:35:45",
        "CALL:MVA",
        "ADDR:PATTERSON CRK 4 MILES SOUTH OF RT 50 ACROSS FROM KESSEL MULCH",
        "MADDR:PATTERSON CRK 4 MILES & RT 50 ACROSS FROM KESSEL MULCH");

    doTest("T36",
        "ï»¿<HTML><body>KEMS:2012:0912<br />2012-11-30 20:39:35<br />ALERTED<br />CONVULSIONS/SEIZURES-12<br />500 CARSKADON LN, KEYSER APT 201</body></HTML>",
        "SRC:KEMS",
        "ID:2012:0912",
        "DATE:11/30/2012",
        "TIME:20:39:35",
        "CALL:CONVULSIONS/SEIZURES-12",
        "ADDR:500 CARSKADON LN",
        "INFO:KEYSER APT 201");

    doTest("T37",
        "ï»¿<HTML><body>NCFD:2012:0517<br />2012-11-30 11:28:16<br />ALERTED<br />ALARM SOUNDING<br />1061 TRENUM DRIVE; WHT HSE W/HORSESHOE DRIVEWAY</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0517",
        "DATE:11/30/2012",
        "TIME:11:28:16",
        "CALL:ALARM SOUNDING",
        "ADDR:1061 TRENUM DRIVE",
        "INFO:WHT HSE W/HORSESHOE DRIVEWAY");

    doTest("T38",
        "ï»¿<HTML><body>NCFD:2012:0516<br />2012-11-29 16:41:06<br />ALERTED<br />FALLS-17<br />7045 BAYBERRY DRIVE, GO STRAIGHT BACK TO THE RIGHT</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0516",
        "DATE:11/29/2012",
        "TIME:16:41:06",
        "CALL:FALLS-17",
        "ADDR:7045 BAYBERRY DRIVE",
        "INFO:GO STRAIGHT BACK TO THE RIGHT");

    doTest("T39",
        "ï»¿<HTML><body>KEMS:2012:0908<br />2012-11-29 08:53:15<br />ALERTED<br />HEADACHE-18<br />STONEY RUN ROAD FROM RT. 220 1/8 MILE ON THE RIGHT. MAROON AND GRAY RED BLAZER IN DRIVE; ARNOLD AND BARBARA EVANS</body></HTML>",
        "SRC:KEMS",
        "ID:2012:0908",
        "DATE:11/29/2012",
        "TIME:08:53:15",
        "CALL:HEADACHE-18",
        "ADDR:STONEY RUN ROAD",
        "INFO:FROM RT. 220 1/8 MILE ON THE RIGHT. MAROON AND GRAY RED BLAZER IN DRIVE / ARNOLD AND BARBARA EVANS");

    doTest("T40",
        "ï»¿<HTML><body>GRANT:2012:0028<br />2012-11-28 17:14:22<br />ALERTED<br />MVA<br />RT 50 1 MILE OUTSIDE OF MOUNT STORM</body></HTML>",
        "SRC:GRANT",
        "ID:2012:0028",
        "DATE:11/28/2012",
        "TIME:17:14:22",
        "CALL:MVA",
        "ADDR:RT 50",
        "APT:1",
        "INFO:MILE OUTSIDE OF MOUNT STORM");

    doTest("T41",
        "ï»¿<HTML><body>NCFD:2012:0515<br />2012-11-28 11:15:02<br />ALERTED<br />CHEST PAINS-10<br />147 MAPLESIDE COURT, HEARLY HGTS, DROPPLEMAN RES</body></HTML>",
        "SRC:NCFD",
        "ID:2012:0515",
        "DATE:11/28/2012",
        "TIME:11:15:02",
        "CALL:CHEST PAINS-10",
        "ADDR:147 MAPLESIDE COURT",
        "INFO:HEARLY HGTS / DROPPLEMAN RES");

    doTest("T42",
        "ï»¿<HTML><body>BFD:2012:0404<br />2012-11-27 10:12:13<br />ALERTED<br />FIRE FLUE<br />SHIRLEY'S LANE OFF RT. 50 2 MILES IN ON LEFT; DOMAN RESIDENCE</body></HTML>",
        "SRC:BFD",
        "ID:2012:0404",
        "DATE:11/27/2012",
        "TIME:10:12:13",
        "CALL:FIRE FLUE",
        "ADDR:SHIRLEY'S LANE",
        "INFO:OFF RT. 50 2 MILES IN ON LEFT / DOMAN RESIDENCE");

  }
  
  @Test
  public void testTriTownsFire() {

    doTest("T1",
        "ï»¿<HTML><body>PFD:2012:0228<br />2012-12-26 20:02:12<br />ALERTED<br />MVA<br />OFF RT 46 ONTO THE MINING RD, ELK GARDEN</body></HTML>",
        "SRC:PFD",
        "ID:2012:0228",
        "DATE:12/26/2012",
        "TIME:20:02:12",
        "CALL:MVA",
        "ADDR:OFF RT 46 ONTO THE MINING RD",
        "MADDR:& RT 46 ONTO THE MINING RD",
        "CITY:ELK GARDEN");

    doTest("T2",
        "ï»¿<HTML><body>PFD:2012:0227<br />2012-12-26 14:54:12<br />ALERTED<br />GAS EMERGENCY<br />WEST HAMPSHIRE STREET FRANCINE GARLAND RES.</body></HTML>",
        "SRC:PFD",
        "ID:2012:0227",
        "DATE:12/26/2012",
        "TIME:14:54:12",
        "CALL:GAS EMERGENCY",
        "ADDR:WEST HAMPSHIRE STREET",
        "INFO:FRANCINE GARLAND RES.");

    doTest("T3",
        "ï»¿<HTML><body>PFD:2012:0226<br />2012-12-25 12:20:18<br />ALERTED<br />FIRE ALARM COMMERCIAL<br />25 JONES STREET</body></HTML>",
        "SRC:PFD",
        "ID:2012:0226",
        "DATE:12/25/2012",
        "TIME:12:20:18",
        "CALL:FIRE ALARM COMMERCIAL",
        "ADDR:25 JONES STREET");

    doTest("T4",
        "ï»¿<HTML><body>PFD:2012:0225<br />2012-12-24 09:52:40<br />ALERTED<br />MVA<br />RT 46, PIEDMONT SIDE OF RILEY'S HSE</body></HTML>",
        "SRC:PFD",
        "ID:2012:0225",
        "DATE:12/24/2012",
        "TIME:09:52:40",
        "CALL:MVA",
        "ADDR:RT 46",
        "INFO:PIEDMONT SIDE OF RILEY'S HSE");

    doTest("T5",
        "ï»¿<HTML><body>PFD:2012:0224<br />2012-12-23 20:23:39<br />ALERTED<br />SMOKE IN RESIDENCE<br />81 ERIN STREET PIEDMONT</body></HTML>",
        "SRC:PFD",
        "ID:2012:0224",
        "DATE:12/23/2012",
        "TIME:20:23:39",
        "CALL:SMOKE IN RESIDENCE",
        "ADDR:81 ERIN STREET",
        "CITY:PIEDMONT");

    doTest("T6",
        "ï»¿<HTML><body>PFD:2012:0223<br />2012-12-18 00:07:47<br />ALERTED<br />FIRE RESIDENTIAL<br />21ST BRIDGE ROAD  MCOOLE</body></HTML>",
        "SRC:PFD",
        "ID:2012:0223",
        "DATE:12/18/2012",
        "TIME:00:07:47",
        "CALL:FIRE RESIDENTIAL",
        "ADDR:21ST BRIDGE ROAD",
        "CITY:MCCOOLE",
        "ST:MD");

    doTest("T7",
        "ï»¿<HTML><body>PFD:2012:0220<br />2012-12-12 17:15:29<br />ALERTED<br />FIRE FLUE<br />307 VINE ST</body></HTML>",
        "SRC:PFD",
        "ID:2012:0220",
        "DATE:12/12/2012",
        "TIME:17:15:29",
        "CALL:FIRE FLUE",
        "ADDR:307 VINE ST");

    doTest("T8",
        "ï»¿<HTML><body>PFD:2012:0218<br />2012-12-09 00:29:02<br />ALERTED<br />MUTUAL AID<br />110 SOUTH BROADWAY FROST BURG</body></HTML>",
        "SRC:PFD",
        "ID:2012:0218",
        "DATE:12/09/2012",
        "TIME:00:29:02",
        "CALL:MUTUAL AID",
        "ADDR:110 SOUTH BROADWAY",
        "CITY:FROSTBURG",
        "ST:MD");
   
  }
  
  public static void main(String[] args) {
    new WVMineralCountyParserTest().generateTests("T1");
  }
}