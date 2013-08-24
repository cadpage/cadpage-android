package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Dade County, GA
Contact: toptech82 <toptech82@gmail.com>
Sender: E911@dadega.com
 1 of 2\nFRM:E911@dadega.com\nSUBJ:!\nMSG:Brush, Grass, Field, Woods 220 HOOKER CEMETERY RD DEAD END / HWY 299 WILDWOOD     BRUSH FIRE ON BOTH SIDES\n(Con't) 2 of 2\nOF THE RAILRIAD TRACKS  06/26/12 20:35(End)
 1 of 2\nFRM:E911@dadega.com\nSUBJ:!\nMSG:Convulsions/Seizures 93 MARCH LN DEAD END / HARRIS RD SLYGO     12 YOM, HAVING A SEIZURE, HISTORY OF\n(Con't) 2 of 2\nSEIZURE, HAS NOT COME  06/28/12 00:47(End)
FRM:E911@dadega.com\nSUBJ:!\nMSG:Fall 650 HWY 299 WILDWOOD    Pilot Travel Center #254 E911 Info - Class of Service: BUSN  06/29/12 08:32

Dade County, GA
Contact: Dennis Kelley <fowkta@gmail.com>
Sender: E911@dadega.com

(!) Fracture/Dislocation 4454 HWY 136 W PAGE AVE / BACK VALLEY RD TRENTON    Kabani Enterprises, SpurVERIZON WIRELESS FEMALE BROKEN ARM & BLEEDING  E911
(!) Blood Pressure Problems 501 N POPLAR ST CANARY AVE / DOVE AVE TRENTON    GIFFORD  85 yof bp is 199/103 is very weak needs to be checked out.  E911 Info - Class
(!) Medical Alarm  15345 HWY 11 N 4 HARTFORD LN / LEE ST TRENTON    francis kesler  lifeline 888/289/2018, 57 yof unable to make contact got the alarm from the peda
(!) Allergic Reaction 112 CRIMSON DR DEAD END / HWY 136 W TRENTON    Bi Lo MAROON JEEP CHEROKEE, 20 YOF, ALLERGIC REACTION, TROUBLE SWALLOWING, BREATHIGN OK AT 09/3
(!) Fracture/Dislocation 4454 HWY 136 W PAGE AVE / BACK VALLEY RD   TRENTON    Kabani Enterprises, SpurVERIZON WIRELESS             FEMALE BROKEN ARM & BLEEDING  E911
(!) Vehicle Fire 12000 I 59 N UNKNOWN / I 59 RAMP TRENTON     just north of trenton exit, vehicle fire  09/28/12 09:23
(!) Allergic Reaction 60 MORGAN RD HWY 11 N / MAINE AVE TRENTON    ashley morris  29 yom poss allergic reaction to nuts  E911 Info - Class of Service: WPH2  09/28/1

Contact: Active911
Agency name: West Brow Fire  Rescue
Location: Lookout Mtn, GA, United States
Sender: E911@dadega.com

(!) Diabetic Problems 206 EARL DR DEAD END / VARNELL RD, LINGERFELT RD WEST BROW    MICHAEL  HAS BEEN DRINKING, HAS PASSED OUT AND VOMITED AND AWAKE AT THIS TIME  60 YOM,. BLOOD 12/01/12 18:50
(!) Sick Call 125 HUISMAN LN GRIFFIN RD / DEAD END WEST BROW    july  72yom dissy blured sight is a dibetic has a broken hip about 2 months ago  address i 11/30/12 10:14
(!) Suicide  206 EARL DR DEAD END / VARNELL RD, LINGERFELT RD WEST BROW    MARKUS  PER ANGEL FEMALE TOOK 2 TO 3 PILLS ...SHE LIVES IN CAMPER BEHIND YELLOW HOUSE ...  A 11/25/12 01:34
(!) Chest Pains 43 PLEASANT HILL RD SCENIC HWY / DEAD END WEST BROW    lisa veal  43 yof, chest and back pain w/ breathing radiating into her arms  11/23/12 23:02
(!) Accident - Multi/Entrapment 1502 SCENIC HWY BEAR CREEK DR / FAWN DAWN DR, HWY 136 E NEW SALEM    LINDA BLEVINS  Will Bradford called this in and there is motorcycle that is hurt, 423-413-2264  COM 11/19/12 15:53
(!) Fall 425 APOLLO RD DIANA LN / APPOLO WAY WEST BROW    JOHN SIMMONS  90 YOF FALLEN AND HIT HER HEAD SHE IS CONCIOUS AND ALERT AT THIS TIME,  11/18/12 00:26
(!) Structure Fire - Residential  43 PLEASANT HILL RD SCENIC HWY / DEAD END WEST BROW    Mason Allison  caller from 43 pleasant hill rd, advised they where burning leaves and it spread to  11/14/12 17:07
(!) Structure Fire - Residential  PLEASANT HILL RD SCENIC HWY WEST BROW    Mason Allison  house fire in the area  E911 Info - Class of Service: WPH2  11/14/12 17:07
(!) Brush, Grass, Field, Woods 16 FOX TRAIL RD SCENIC HWY / DEAD END WEST BROW    Jeff Barr  brush fire got out of control, is close to houses  E911 Info - Class of Service: WPH 11/10/12 11:10
(!) Sick Call 10165 SCENIC HWY BOLUS CIR / PHILLIPS RD WEST BROW    GEORGE DOUGLAS  54 YOF SICK WOULD LIKE TO BE CHECKED OUT, GREY HOUSE  11/09/12 06:44
(!) Convulsions/Seizures 14049 SCENIC HWY 5 UNKNOWN / FRONTIER BLUFF RD WEST BROW    COVENANT COLLEGEHOLLY  24 YOF, HAVING SEIZURE ,, HX OF SEIZURES  11/08/12 18:40
(!) Sick Call 33 WOOTEN DR SCENIC HWY / DEAD END WEST BROW    FRANKS  53YOF FEELING WEAK AND BP IS HIGH  E911 Info - Class of Service: RESD  11/03/12 19:11
(!) Fire - Alarm 14049 SCENIC HWY UNKNOWN / FRONTIER BLUFF RD WEST BROW    COVENANT COLLEGEDAVE BROWN  ADV THAT THE FIRE ALARM IS GOING OFF AT THE CHAPEL,UNKNOWN WHY  10/31/12 06:28
(!) Breathing Problems 194 DOGWOOD RD MOORE RD / COSMIC WAY WEST BROW    elezabeth payner  female called said she was having breathing problems and hung up no phone number cou 10/30/12 11:55
(!) Illegal Burn 53 BAILEY RD SCENIC HWY / DEAD END WEST BROW    RICHARD ANNIS  HE ADVISED THAT THEY ARE PUTTING IT OUT NOW.  HE ADVISED THAT IT IS NOT WOOD.  Dispa 10/25/12 18:59
(!) Suicide  206 EARL DR DEAD END / VARNELL RD, LINGERFELT RD WEST BROW    REBECCA MASSEY  800-715-4225  MELONY-W/ GA CRISIS CENTER, ADV THEY HAD A CALL FROM REBECCA  MASSEY,  10/22/12 23:16
(!) Sick Call 123 ARVLE YORK CIR SCENIC HWY / SCENIC HWY WEST BROW    CANDANCE  40 YOM, CLAMY FEELING, CHEST HURTING,, ABOUT 30 MINS AGO GOT TO HOT  E911 Info - Cla 10/21/12 14:55
(!) Breathing Problems 14142 SCENIC HWY FRONTIER BLUFF RD / DIANA LN, APOLLO RD WEST BROW    MRS PERSINGER  84 YOM DIFFICULTY BREATHING  E911 Info - Class of Service: VOIP  10/17/12 11:21
(!) Fire - Alarm Comm/Indust 13024 N MAIN ST INDUSTRIAL BLVD N / CANARY AVE TRENTON    AccellentACCELLANT  ADS SECURITY- COMMERCIAL FIRE ALARM- BACK DOOR PULL STATION- 800-866-6486 -OPER 81  10/14/12 21:01
(!) Smoke in Structure 3960 SCENIC HWY DURHAM RD / CASCADES DR NEW SALEM    MARTHA  ADVISED HER TO GET EVERYONE OUT OF HOUSE.  HOUSE FULL OF SMOKE  HOUSE FULL OF SMOKE, 10/08/12 12:38
(!) Fire - Alarm Comm/Indust 14049 SCENIC HWY UNKNOWN / FRONTIER BLUFF RD WEST BROW    COVENANT COLLEGE             fire alarm, andreas hall  E911 Info - Class of Service: BUSN  10/08/12 09:06
(!) Chest Pains 74 CRAIG RD SCENIC HWY / DEAD END WEST BROW    mrs marton  75yof chest pains. diff breathing. adv her bp is high. request no ligjts or sirens.  10/04/12 16:02
(!) Unconscious/Fainting 14049 SCENIC HWY UNKNOWN / FRONTIER BLUFF RD WEST BROW    porcella  E911 Info - Class of Service: WRLS  10/03/12 09:51
(!) Chest Pains 8428 SCENIC HWY POWELL RD / BURKHALTER GAP RD WEST BROW    ROGER WILLIAMS  64 YOA FEMALE.  CHEST PAINS AND HURTING IN BACK.  HISTORY OF STINTS.  E911 Info - Cl 10/02/12 14:59
(!) Chest Pains 553 FRONTIER BLUFF RD DEAD END / APOLLO RD WEST BROW    GIGI  HOUSE WITH LONG DRIVEWAY  57YOM CHEST PAINS, POSSIBLE HEART ATTACK, DOES HAVE HX  E9 10/02/12 01:15
(!) Heart Problem 61 OLLIE VEAL RD GRIFFIN RD / DEAD END WEST BROW    CHRISTINA GERNAGIN  61 YOF THINKS HER BYPASS HAS COLLAPESED  DOUBLE WIDE  10/01/12 20:47
(!) Chest Pains 53 BAILEY RD SCENIC HWY / DEAD END WEST BROW    Karen Dickerson  45 yof having a heart attack with history  E911 Info - Class of Service: WRLS  09/30/12 07:54
(!) Aircraft Incident 7938 SCENIC HWY BURKHALTER GAP RD / POWELL RD WEST BROW    CLARK CHRISTINE  called compt back and its a female and poss just a broke arm  PAGED NEW SALEM AGAIN  09/29/12 16:32
(!) Fall 206 EARL DR DEAD END / VARNELL RD, LINGERFELT RD WEST BROW    rebecca massey  29 yof adv she fell off a ladder thursday. adv she is having chest pains. pain in ba 09/29/12 12:06

(!) Convulsions/Seizures 14049 SCENIC HWY 2 UNKNOWN / FRONTIER BLUFF RD WEST BROW    COVENANT COLLEGEMR SEHEUMCATH  54YOF HAVINF SEIZURE, DOES HAVE HX, WILL BE IN THE GUEST COTTAGES  E911 Info - Class 12/03/12 06:44
(!) Convulsions/Seizures 14049 SCENIC HWY 2 UNKNOWN / FRONTIER BLUFF RD WEST BROW    MR SEHEUMCATH  54YOF HAVINF SEIZURE, DOES HAVE HX, WILL BE IN THE GUEST COTTAGES  E911 Info - Class 12/03/12 06:44
(!) Convulsions/Seizures 14049 SCENIC HWY UNKNOWN / FRONTIER BLUFF RD WEST BROW    COVENANT COLLEGEMR SEHEUMCATH  54YOF HAVINF SEIZURE, DOES HAVE HX, WILL BE IN THE GUEST COTTAGES  E911 Info - Class 12/03/12 06:44

*/

public class GADadeCountyParserTest extends BaseParserTest {
  
  public GADadeCountyParserTest() {
    setParser(new GADadeCountyParser(), "DADE COUNTY", "GA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        " 1 of 2\n" +
        "FRM:E911@dadega.com\n" +
        "SUBJ:!\n" +
        "MSG:Brush, Grass, Field, Woods 220 HOOKER CEMETERY RD DEAD END / HWY 299 WILDWOOD     BRUSH FIRE ON BOTH SIDES\n" +
        "(Con't) 2 of 2\n" +
        "OF THE RAILRIAD TRACKS  06/26/12 20:35(End)",

        "CALL:Brush, Grass, Field, Woods",
        "ADDR:220 HOOKER CEMETERY RD",
        "X:DEAD END / HWY 299",
        "CITY:WILDWOOD",
        "INFO:BRUSH FIRE ON BOTH SIDES OF THE RAILRIAD TRACKS",
        "DATE:06/26/12",
        "TIME:20:35");

    doTest("T2",
        " 1 of 2\n" +
        "FRM:E911@dadega.com\n" +
        "SUBJ:!\n" +
        "MSG:Convulsions/Seizures 93 MARCH LN DEAD END / HARRIS RD SLYGO     12 YOM, HAVING A SEIZURE, HISTORY OF\n" +
        "(Con't) 2 of 2\n" +
        "SEIZURE, HAS NOT COME  06/28/12 00:47(End)",

        "CALL:Convulsions/Seizures",
        "ADDR:93 MARCH LN",
        "X:DEAD END / HARRIS RD",
        "PLACE:SLYGO",
        "CITY:TRENTON",
        "INFO:12 YOM, HAVING A SEIZURE, HISTORY OF SEIZURE, HAS NOT COME",
        "DATE:06/28/12",
        "TIME:00:47");

    doTest("T3",
        "FRM:E911@dadega.com\n" +
        "SUBJ:!\n" +
        "MSG:Fall 650 HWY 299 WILDWOOD    Pilot Travel Center #254 E911 Info - Class of Service: BUSN  06/29/12 08:32",

        "CALL:Fall",
        "ADDR:650 HWY 299",
        "CITY:WILDWOOD",
        "INFO:Pilot Travel Center #254 E911 Info - Class of Service: BUSN",
        "DATE:06/29/12",
        "TIME:08:32");

  }
  
  @Test
  public void testDennisKelley() {

    doTest("T1",
        "(!) Fracture/Dislocation 4454 HWY 136 W PAGE AVE / BACK VALLEY RD TRENTON    Kabani Enterprises, SpurVERIZON WIRELESS FEMALE BROKEN ARM & BLEEDING  E911",
        "CALL:Fracture/Dislocation",
        "ADDR:4454 HWY 136 W",
        "X:PAGE AVE / BACK VALLEY RD",
        "CITY:TRENTON",
        "INFO:Kabani Enterprises, SpurVERIZON WIRELESS FEMALE BROKEN ARM & BLEEDING  E911");

    doTest("T2",
        "(!) Blood Pressure Problems 501 N POPLAR ST CANARY AVE / DOVE AVE TRENTON    GIFFORD  85 yof bp is 199/103 is very weak needs to be checked out.  E911 Info - Class",
        "CALL:Blood Pressure Problems",
        "ADDR:501 N POPLAR ST",
        "X:CANARY AVE / DOVE AVE",
        "CITY:TRENTON",
        "INFO:GIFFORD  85 yof bp is 199/103 is very weak needs to be checked out.  E911 Info - Class");

    doTest("T3",
        "(!) Medical Alarm  15345 HWY 11 N 4 HARTFORD LN / LEE ST TRENTON    francis kesler  lifeline 888/289/2018, 57 yof unable to make contact got the alarm from the peda",
        "CALL:Medical Alarm",
        "ADDR:15345 HWY 11 N",
        "APT:4",
        "X:HARTFORD LN / LEE ST",
        "CITY:TRENTON",
        "INFO:francis kesler  lifeline 888/289/2018, 57 yof unable to make contact got the alarm from the peda");

    doTest("T4",
        "(!) Allergic Reaction 112 CRIMSON DR DEAD END / HWY 136 W TRENTON    Bi Lo MAROON JEEP CHEROKEE, 20 YOF, ALLERGIC REACTION, TROUBLE SWALLOWING, BREATHIGN OK AT 09/3",
        "CALL:Allergic Reaction",
        "ADDR:112 CRIMSON DR",
        "X:DEAD END / HWY 136 W",
        "CITY:TRENTON",
        "INFO:Bi Lo MAROON JEEP CHEROKEE, 20 YOF, ALLERGIC REACTION, TROUBLE SWALLOWING, BREATHIGN OK AT 09/3");

    doTest("T5",
        "(!) Fracture/Dislocation 4454 HWY 136 W PAGE AVE / BACK VALLEY RD   TRENTON    Kabani Enterprises, SpurVERIZON WIRELESS             FEMALE BROKEN ARM & BLEEDING  E911",
        "CALL:Fracture/Dislocation",
        "ADDR:4454 HWY 136 W",
        "X:PAGE AVE / BACK VALLEY RD",
        "INFO:TRENTON    Kabani Enterprises, SpurVERIZON WIRELESS             FEMALE BROKEN ARM & BLEEDING  E911");

    doTest("T6",
        "(!) Vehicle Fire 12000 I 59 N UNKNOWN / I 59 RAMP TRENTON     just north of trenton exit, vehicle fire  09/28/12 09:23",
        "CALL:Vehicle Fire",
        "ADDR:12000 I 59 N",
        "X:UNKNOWN / I 59 RAMP",
        "CITY:TRENTON",
        "INFO:just north of trenton exit, vehicle fire",
        "DATE:09/28/12",
        "TIME:09:23");

    doTest("T7",
        "(!) Allergic Reaction 60 MORGAN RD HWY 11 N / MAINE AVE TRENTON    ashley morris  29 yom poss allergic reaction to nuts  E911 Info - Class of Service: WPH2  09/28/1",
        "CALL:Allergic Reaction",
        "ADDR:60 MORGAN RD",
        "X:HWY 11 N / MAINE AVE",
        "CITY:TRENTON",
        "INFO:ashley morris  29 yom poss allergic reaction to nuts  E911 Info - Class of Service: WPH2  09/28/1");

  }
  
  @Test
  public void testWestBrow() {

    doTest("T1",
        "(!) Diabetic Problems 206 EARL DR DEAD END / VARNELL RD, LINGERFELT RD WEST BROW    MICHAEL  HAS BEEN DRINKING, HAS PASSED OUT AND VOMITED AND AWAKE AT THIS TIME  60 YOM,. BLOOD 12/01/12 18:50",
        "CALL:Diabetic Problems",
        "ADDR:206 EARL DR",
        "X:DEAD END / VARNELL RD, LINGERFELT RD",
        "PLACE:WEST BROW",
        "INFO:MICHAEL  HAS BEEN DRINKING, HAS PASSED OUT AND VOMITED AND AWAKE AT THIS TIME  60 YOM,. BLOOD",
        "DATE:12/01/12",
        "TIME:18:50");

    doTest("T2",
        "(!) Sick Call 125 HUISMAN LN GRIFFIN RD / DEAD END WEST BROW    july  72yom dissy blured sight is a dibetic has a broken hip about 2 months ago  address i 11/30/12 10:14",
        "CALL:Sick Call",
        "ADDR:125 HUISMAN LN",
        "X:GRIFFIN RD / DEAD END",
        "PLACE:WEST BROW",
        "INFO:july  72yom dissy blured sight is a dibetic has a broken hip about 2 months ago  address i",
        "DATE:11/30/12",
        "TIME:10:14");

    doTest("T3",
        "(!) Suicide  206 EARL DR DEAD END / VARNELL RD, LINGERFELT RD WEST BROW    MARKUS  PER ANGEL FEMALE TOOK 2 TO 3 PILLS ...SHE LIVES IN CAMPER BEHIND YELLOW HOUSE ...  A 11/25/12 01:34",
        "CALL:Suicide",
        "ADDR:206 EARL DR",
        "X:DEAD END / VARNELL RD, LINGERFELT RD",
        "PLACE:WEST BROW",
        "INFO:MARKUS  PER ANGEL FEMALE TOOK 2 TO 3 PILLS ...SHE LIVES IN CAMPER BEHIND YELLOW HOUSE ...  A",
        "DATE:11/25/12",
        "TIME:01:34");

    doTest("T4",
        "(!) Chest Pains 43 PLEASANT HILL RD SCENIC HWY / DEAD END WEST BROW    lisa veal  43 yof, chest and back pain w/ breathing radiating into her arms  11/23/12 23:02",
        "CALL:Chest Pains",
        "ADDR:43 PLEASANT HILL RD",
        "X:SCENIC HWY / DEAD END",
        "PLACE:WEST BROW",
        "INFO:lisa veal  43 yof, chest and back pain w/ breathing radiating into her arms",
        "DATE:11/23/12",
        "TIME:23:02");

    doTest("T5",
        "(!) Accident - Multi/Entrapment 1502 SCENIC HWY BEAR CREEK DR / FAWN DAWN DR, HWY 136 E NEW SALEM    LINDA BLEVINS  Will Bradford called this in and there is motorcycle that is hurt, 423-413-2264  COM 11/19/12 15:53",
        "CALL:Accident - Multi/Entrapment",
        "ADDR:1502 SCENIC HWY",
        "X:BEAR CREEK DR / FAWN DAWN DR, HWY 136 E",
        "PLACE:NEW SALEM",
        "INFO:LINDA BLEVINS  Will Bradford called this in and there is motorcycle that is hurt, 423-413-2264  COM",
        "DATE:11/19/12",
        "TIME:15:53");

    doTest("T6",
        "(!) Fall 425 APOLLO RD DIANA LN / APPOLO WAY WEST BROW    JOHN SIMMONS  90 YOF FALLEN AND HIT HER HEAD SHE IS CONCIOUS AND ALERT AT THIS TIME,  11/18/12 00:26",
        "CALL:Fall",
        "ADDR:425 APOLLO RD",
        "X:DIANA LN / APPOLO WAY",
        "PLACE:WEST BROW",
        "INFO:JOHN SIMMONS  90 YOF FALLEN AND HIT HER HEAD SHE IS CONCIOUS AND ALERT AT THIS TIME,",
        "DATE:11/18/12",
        "TIME:00:26");

    doTest("T7",
        "(!) Structure Fire - Residential  43 PLEASANT HILL RD SCENIC HWY / DEAD END WEST BROW    Mason Allison  caller from 43 pleasant hill rd, advised they where burning leaves and it spread to  11/14/12 17:07",
        "CALL:Structure Fire - Residential",
        "ADDR:43 PLEASANT HILL RD",
        "X:SCENIC HWY / DEAD END",
        "PLACE:WEST BROW",
        "INFO:Mason Allison  caller from 43 pleasant hill rd, advised they where burning leaves and it spread to",
        "DATE:11/14/12",
        "TIME:17:07");

    doTest("T8",
        "(!) Structure Fire - Residential  PLEASANT HILL RD SCENIC HWY WEST BROW    Mason Allison  house fire in the area  E911 Info - Class of Service: WPH2  11/14/12 17:07",
        "CALL:Structure Fire - Residential",
        "ADDR:PLEASANT HILL RD",
        "MADDR:PLEASANT HILL RD & SCENIC HWY",
        "X:SCENIC HWY",
        "PLACE:WEST BROW",
        "INFO:Mason Allison  house fire in the area  E911 Info - Class of Service: WPH2",
        "DATE:11/14/12",
        "TIME:17:07");

    doTest("T9",
        "(!) Brush, Grass, Field, Woods 16 FOX TRAIL RD SCENIC HWY / DEAD END WEST BROW    Jeff Barr  brush fire got out of control, is close to houses  E911 Info - Class of Service: WPH 11/10/12 11:10",
        "CALL:Brush, Grass, Field, Woods",
        "ADDR:16 FOX TRAIL RD",
        "X:SCENIC HWY / DEAD END",
        "PLACE:WEST BROW",
        "INFO:Jeff Barr  brush fire got out of control, is close to houses  E911 Info - Class of Service: WPH",
        "DATE:11/10/12",
        "TIME:11:10");

    doTest("T10",
        "(!) Sick Call 10165 SCENIC HWY BOLUS CIR / PHILLIPS RD WEST BROW    GEORGE DOUGLAS  54 YOF SICK WOULD LIKE TO BE CHECKED OUT, GREY HOUSE  11/09/12 06:44",
        "CALL:Sick Call",
        "ADDR:10165 SCENIC HWY",
        "X:BOLUS CIR / PHILLIPS RD",
        "PLACE:WEST BROW",
        "INFO:GEORGE DOUGLAS  54 YOF SICK WOULD LIKE TO BE CHECKED OUT, GREY HOUSE",
        "DATE:11/09/12",
        "TIME:06:44");

    doTest("T11",
        "(!) Convulsions/Seizures 14049 SCENIC HWY 5 UNKNOWN / FRONTIER BLUFF RD WEST BROW    COVENANT COLLEGEHOLLY  24 YOF, HAVING SEIZURE ,, HX OF SEIZURES  11/08/12 18:40",
        "CALL:Convulsions/Seizures",
        "ADDR:14049 SCENIC HWY",
        "APT:5",
        "X:UNKNOWN / FRONTIER BLUFF RD",
        "PLACE:WEST BROW",
        "INFO:COVENANT COLLEGEHOLLY  24 YOF, HAVING SEIZURE ,, HX OF SEIZURES",
        "DATE:11/08/12",
        "TIME:18:40");

    doTest("T12",
        "(!) Sick Call 33 WOOTEN DR SCENIC HWY / DEAD END WEST BROW    FRANKS  53YOF FEELING WEAK AND BP IS HIGH  E911 Info - Class of Service: RESD  11/03/12 19:11",
        "CALL:Sick Call",
        "ADDR:33 WOOTEN DR",
        "X:SCENIC HWY / DEAD END",
        "PLACE:WEST BROW",
        "INFO:FRANKS  53YOF FEELING WEAK AND BP IS HIGH  E911 Info - Class of Service: RESD",
        "DATE:11/03/12",
        "TIME:19:11");

    doTest("T13",
        "(!) Fire - Alarm 14049 SCENIC HWY UNKNOWN / FRONTIER BLUFF RD WEST BROW    COVENANT COLLEGEDAVE BROWN  ADV THAT THE FIRE ALARM IS GOING OFF AT THE CHAPEL,UNKNOWN WHY  10/31/12 06:28",
        "CALL:Fire - Alarm",
        "ADDR:14049 SCENIC HWY",
        "X:UNKNOWN / FRONTIER BLUFF RD",
        "PLACE:WEST BROW",
        "INFO:COVENANT COLLEGEDAVE BROWN  ADV THAT THE FIRE ALARM IS GOING OFF AT THE CHAPEL,UNKNOWN WHY",
        "DATE:10/31/12",
        "TIME:06:28");

    doTest("T14",
        "(!) Breathing Problems 194 DOGWOOD RD MOORE RD / COSMIC WAY WEST BROW    elezabeth payner  female called said she was having breathing problems and hung up no phone number cou 10/30/12 11:55",
        "CALL:Breathing Problems",
        "ADDR:194 DOGWOOD RD",
        "X:MOORE RD / COSMIC WAY",
        "PLACE:WEST BROW",
        "INFO:elezabeth payner  female called said she was having breathing problems and hung up no phone number cou",
        "DATE:10/30/12",
        "TIME:11:55");

    doTest("T15",
        "(!) Illegal Burn 53 BAILEY RD SCENIC HWY / DEAD END WEST BROW    RICHARD ANNIS  HE ADVISED THAT THEY ARE PUTTING IT OUT NOW.  HE ADVISED THAT IT IS NOT WOOD.  Dispa 10/25/12 18:59",
        "CALL:Illegal Burn",
        "ADDR:53 BAILEY RD",
        "X:SCENIC HWY / DEAD END",
        "PLACE:WEST BROW",
        "INFO:RICHARD ANNIS  HE ADVISED THAT THEY ARE PUTTING IT OUT NOW.  HE ADVISED THAT IT IS NOT WOOD.  Dispa",
        "DATE:10/25/12",
        "TIME:18:59");

    doTest("T16",
        "(!) Suicide  206 EARL DR DEAD END / VARNELL RD, LINGERFELT RD WEST BROW    REBECCA MASSEY  800-715-4225  MELONY-W/ GA CRISIS CENTER, ADV THEY HAD A CALL FROM REBECCA  MASSEY,  10/22/12 23:16",
        "CALL:Suicide",
        "ADDR:206 EARL DR",
        "X:DEAD END / VARNELL RD, LINGERFELT RD",
        "PLACE:WEST BROW",
        "INFO:REBECCA MASSEY  800-715-4225  MELONY-W/ GA CRISIS CENTER, ADV THEY HAD A CALL FROM REBECCA  MASSEY,",
        "DATE:10/22/12",
        "TIME:23:16");

    doTest("T17",
        "(!) Sick Call 123 ARVLE YORK CIR SCENIC HWY / SCENIC HWY WEST BROW    CANDANCE  40 YOM, CLAMY FEELING, CHEST HURTING,, ABOUT 30 MINS AGO GOT TO HOT  E911 Info - Cla 10/21/12 14:55",
        "CALL:Sick Call",
        "ADDR:123 ARVLE YORK CIR",
        "X:SCENIC HWY / SCENIC HWY",
        "PLACE:WEST BROW",
        "INFO:CANDANCE  40 YOM, CLAMY FEELING, CHEST HURTING,, ABOUT 30 MINS AGO GOT TO HOT  E911 Info - Cla",
        "DATE:10/21/12",
        "TIME:14:55");

    doTest("T18",
        "(!) Breathing Problems 14142 SCENIC HWY FRONTIER BLUFF RD / DIANA LN, APOLLO RD WEST BROW    MRS PERSINGER  84 YOM DIFFICULTY BREATHING  E911 Info - Class of Service: VOIP  10/17/12 11:21",
        "CALL:Breathing Problems",
        "ADDR:14142 SCENIC HWY",
        "X:FRONTIER BLUFF RD / DIANA LN, APOLLO RD",
        "PLACE:WEST BROW",
        "INFO:MRS PERSINGER  84 YOM DIFFICULTY BREATHING  E911 Info - Class of Service: VOIP",
        "DATE:10/17/12",
        "TIME:11:21");

    doTest("T19",
        "(!) Fire - Alarm Comm/Indust 13024 N MAIN ST INDUSTRIAL BLVD N / CANARY AVE TRENTON    AccellentACCELLANT  ADS SECURITY- COMMERCIAL FIRE ALARM- BACK DOOR PULL STATION- 800-866-6486 -OPER 81  10/14/12 21:01",
        "CALL:Fire - Alarm Comm/Indust",
        "ADDR:13024 N MAIN ST",
        "X:INDUSTRIAL BLVD N / CANARY AVE",
        "CITY:TRENTON",
        "INFO:AccellentACCELLANT  ADS SECURITY- COMMERCIAL FIRE ALARM- BACK DOOR PULL STATION- 800-866-6486 -OPER 81",
        "DATE:10/14/12",
        "TIME:21:01");

    doTest("T20",
        "(!) Smoke in Structure 3960 SCENIC HWY DURHAM RD / CASCADES DR NEW SALEM    MARTHA  ADVISED HER TO GET EVERYONE OUT OF HOUSE.  HOUSE FULL OF SMOKE  HOUSE FULL OF SMOKE, 10/08/12 12:38",
        "CALL:Smoke in Structure",
        "ADDR:3960 SCENIC HWY",
        "X:DURHAM RD / CASCADES DR",
        "PLACE:NEW SALEM",
        "INFO:MARTHA  ADVISED HER TO GET EVERYONE OUT OF HOUSE.  HOUSE FULL OF SMOKE  HOUSE FULL OF SMOKE,",
        "DATE:10/08/12",
        "TIME:12:38");

    doTest("T21",
        "(!) Fire - Alarm Comm/Indust 14049 SCENIC HWY UNKNOWN / FRONTIER BLUFF RD WEST BROW    COVENANT COLLEGE             fire alarm, andreas hall  E911 Info - Class of Service: BUSN  10/08/12 09:06",
        "CALL:Fire - Alarm Comm/Indust",
        "ADDR:14049 SCENIC HWY",
        "X:UNKNOWN / FRONTIER BLUFF RD",
        "PLACE:WEST BROW",
        "INFO:COVENANT COLLEGE             fire alarm, andreas hall  E911 Info - Class of Service: BUSN",
        "DATE:10/08/12",
        "TIME:09:06");

    doTest("T22",
        "(!) Chest Pains 74 CRAIG RD SCENIC HWY / DEAD END WEST BROW    mrs marton  75yof chest pains. diff breathing. adv her bp is high. request no ligjts or sirens.  10/04/12 16:02",
        "CALL:Chest Pains",
        "ADDR:74 CRAIG RD",
        "X:SCENIC HWY / DEAD END",
        "PLACE:WEST BROW",
        "INFO:mrs marton  75yof chest pains. diff breathing. adv her bp is high. request no ligjts or sirens.",
        "DATE:10/04/12",
        "TIME:16:02");

    doTest("T23",
        "(!) Unconscious/Fainting 14049 SCENIC HWY UNKNOWN / FRONTIER BLUFF RD WEST BROW    porcella  E911 Info - Class of Service: WRLS  10/03/12 09:51",
        "CALL:Unconscious/Fainting",
        "ADDR:14049 SCENIC HWY",
        "X:UNKNOWN / FRONTIER BLUFF RD",
        "PLACE:WEST BROW",
        "INFO:porcella  E911 Info - Class of Service: WRLS",
        "DATE:10/03/12",
        "TIME:09:51");

    doTest("T24",
        "(!) Chest Pains 8428 SCENIC HWY POWELL RD / BURKHALTER GAP RD WEST BROW    ROGER WILLIAMS  64 YOA FEMALE.  CHEST PAINS AND HURTING IN BACK.  HISTORY OF STINTS.  E911 Info - Cl 10/02/12 14:59",
        "CALL:Chest Pains",
        "ADDR:8428 SCENIC HWY",
        "X:POWELL RD / BURKHALTER GAP RD",
        "PLACE:WEST BROW",
        "INFO:ROGER WILLIAMS  64 YOA FEMALE.  CHEST PAINS AND HURTING IN BACK.  HISTORY OF STINTS.  E911 Info - Cl",
        "DATE:10/02/12",
        "TIME:14:59");

    doTest("T25",
        "(!) Chest Pains 553 FRONTIER BLUFF RD DEAD END / APOLLO RD WEST BROW    GIGI  HOUSE WITH LONG DRIVEWAY  57YOM CHEST PAINS, POSSIBLE HEART ATTACK, DOES HAVE HX  E9 10/02/12 01:15",
        "CALL:Chest Pains",
        "ADDR:553 FRONTIER BLUFF RD",
        "X:DEAD END / APOLLO RD",
        "PLACE:WEST BROW",
        "INFO:GIGI  HOUSE WITH LONG DRIVEWAY  57YOM CHEST PAINS, POSSIBLE HEART ATTACK, DOES HAVE HX  E9",
        "DATE:10/02/12",
        "TIME:01:15");

    doTest("T26",
        "(!) Heart Problem 61 OLLIE VEAL RD GRIFFIN RD / DEAD END WEST BROW    CHRISTINA GERNAGIN  61 YOF THINKS HER BYPASS HAS COLLAPESED  DOUBLE WIDE  10/01/12 20:47",
        "CALL:Heart Problem",
        "ADDR:61 OLLIE VEAL RD",
        "X:GRIFFIN RD / DEAD END",
        "PLACE:WEST BROW",
        "INFO:CHRISTINA GERNAGIN  61 YOF THINKS HER BYPASS HAS COLLAPESED  DOUBLE WIDE",
        "DATE:10/01/12",
        "TIME:20:47");

    doTest("T27",
        "(!) Chest Pains 53 BAILEY RD SCENIC HWY / DEAD END WEST BROW    Karen Dickerson  45 yof having a heart attack with history  E911 Info - Class of Service: WRLS  09/30/12 07:54",
        "CALL:Chest Pains",
        "ADDR:53 BAILEY RD",
        "X:SCENIC HWY / DEAD END",
        "PLACE:WEST BROW",
        "INFO:Karen Dickerson  45 yof having a heart attack with history  E911 Info - Class of Service: WRLS",
        "DATE:09/30/12",
        "TIME:07:54");

    doTest("T28",
        "(!) Aircraft Incident 7938 SCENIC HWY BURKHALTER GAP RD / POWELL RD WEST BROW    CLARK CHRISTINE  called compt back and its a female and poss just a broke arm  PAGED NEW SALEM AGAIN  09/29/12 16:32",
        "CALL:Aircraft Incident",
        "ADDR:7938 SCENIC HWY",
        "X:BURKHALTER GAP RD / POWELL RD",
        "PLACE:WEST BROW",
        "INFO:CLARK CHRISTINE  called compt back and its a female and poss just a broke arm  PAGED NEW SALEM AGAIN",
        "DATE:09/29/12",
        "TIME:16:32");

    doTest("T29",
        "(!) Fall 206 EARL DR DEAD END / VARNELL RD, LINGERFELT RD WEST BROW    rebecca massey  29 yof adv she fell off a ladder thursday. adv she is having chest pains. pain in ba 09/29/12 12:06",
        "CALL:Fall",
        "ADDR:206 EARL DR",
        "X:DEAD END / VARNELL RD, LINGERFELT RD",
        "PLACE:WEST BROW",
        "INFO:rebecca massey  29 yof adv she fell off a ladder thursday. adv she is having chest pains. pain in ba",
        "DATE:09/29/12",
        "TIME:12:06");

    doTest("T30",
        "(!) Convulsions/Seizures 14049 SCENIC HWY 2 UNKNOWN / FRONTIER BLUFF RD WEST BROW    COVENANT COLLEGEMR SEHEUMCATH  54YOF HAVINF SEIZURE, DOES HAVE HX, WILL BE IN THE GUEST COTTAGES  E911 Info - Class 12/03/12 06:44",
        "CALL:Convulsions/Seizures",
        "ADDR:14049 SCENIC HWY",
        "APT:2",
        "X:UNKNOWN / FRONTIER BLUFF RD",
        "PLACE:WEST BROW",
        "INFO:COVENANT COLLEGEMR SEHEUMCATH  54YOF HAVINF SEIZURE, DOES HAVE HX, WILL BE IN THE GUEST COTTAGES  E911 Info - Class",
        "DATE:12/03/12",
        "TIME:06:44");

  }
  
  public static void main(String[] args) {
    new GADadeCountyParserTest().generateTests("T1");
  }
}