package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Wadsworth, OH (In Medina County)
System: Sundance

Contact:  Mike Banks <mbanks@wadsworthcity.org>
Sender: info@sundance-sys.com

BRTH-DIF BREATHING,587 HIGHLAND AV,WADSWORTH,85 YOM SHORTNESS OF BREATH, 
STRK-STROKE,1160 WILLIAMS RESERVE BV 1,WADS DIALYSIS FRESENIUS,WADSWORTH,ELDERLY FEMALE POSSIBLE STROKE, LEFT ARM WEAKNESS,
STRK-STROKE,190 MAIN ST LOBBY,WADS TOWERS,WADSWORTH,53 YOM POSS STROKE, CONFUSED, HEADACHE,
WEAK-GENERAL ILLNESS,175 GREAT OAKS TR,BUEHLERS GROCERY STORE,WADSWORTH,MALE PATIENT IN STAT CARE ABOUT TO PASS OUT,
FALL-FALL ,468 MEADOW DR,WADSWORTH,FEMALE FALL VICTIM, SEMI CONSCIOUS,
WEAK-GENERAL ILLNESS,253 BROAD ST D,WADSWORTH,FEMALE FEELS LIKE SHE IS GOING TO PASS OUT,
MVA-MVA (EMS) (INJURY),0 BROUSE DR/HIGH ST,BROUSE DR/HIGH ST,WADSWORTH,2 CARS INVOLVED,
FALL-FALL ,281 DEEPWOOD DR,WADSWORTH,72 YOF FELL UNK INJ,
BLED-BLEEDING,357 DEEPWOOD DR,WADSWORTH,69 YOM BLEEDING FROM HERNIA SURGERY SITE,
STRK-STROKE,315 WESTVIEW AV,WADSWORTH,97 YOM POSSIBLE STROKE,
DIAB-DIABETIC ,0 MILLS ST/S PARDEE ST,MILLS ST/S PARDEE ST,WADSWORTH,MALE DIABETIC PROBLEMS PD ON SCENE,

Contact: Active911
Agency name: Wadsworth Fire EMS
Location: Wadsworth, OH, United States
Sender: info@sundance-sys.com

(From: WadsTextSender) jneforos: FALL-FALL ,190 MAIN ST,WADS TOWERS,WADSWORTH,MALE FELL IN PARKING LOT NOW IN LOBBY,\n
(From: WadsTextSender) FALL-FALL ,190 MAIN ST,WADS TOWERS,WADSWORTH,,\n
(From: WadsTextSender) FALL-FALL ,160 HALL DR,WADSWORTH,81 YOM FALL VICTIM POSS BROKEN HIP,\n
(From: WadsTextSender) mbanks: WEAK-GENERAL ILLNESS,143 MEADOWCREEK DR A, MANPOWER ASSIST CODE RED FOR LIFTING\n
(From: WadsTextSender) mbanks: WEAK-GENERAL ILLNESS,815 BROAD ST,CIRCLE K EAST,WADSWORTH,POSSIBLE SUICIDE ATTEMPT - STANDBY FOR PD,\n
(From: WadsTextSender) WEAK-GENERAL ILLNESS,815 BROAD ST,CIRCLE K EAST,WADSWORTH,POSSIBLE SUICIDE ATTEMPT - STANDBY FOR PD,\n
(From: WadsTextSender) PAIN-PAIN,250 SMOKERISE DR,LIBERTY RESIDENCE,WADSWORTH,91 YOF IN PAIN, UNABLE TO MOVE,\n
(From: WadsTextSender) FALL-FALL ,1054 FREEDOM DR 103,LIBERTY RESIDENCE II,WADSWORTH,91 YOF FALL VICTIM,\n
(From: WadsTextSender) DIAB-DIABETIC ,540 GREAT OAKS TR 311R,WADS POINTE,WADSWORTH,HIGH BLOOD SUGAR,\n
(From: WadsTextSender) BRTH-DIF BREATHING,531 HIGH ST 3,MENWA APTS,WADSWORTH,,\n
(From: WadsTextSender) PAIN-PAIN,1054 FREEDOM DR 109,LIBERTY RESIDENCE II,WADSWORTH,ELDERLY FEMALE STOMACH PAIN,\n
(From: WadsTextSender) INJ-INJURY,1371 HIGH ST 114,PARK TERRACE APTS,WADSWORTH,23 YOM FELL ON ICE, LEFT ANKLE FX,\n
(From: WadsTextSender) hsonntag: FALL-FALL ,774 RENEE DR,WADSWORTH,87,87 YOM WITH BROKEN RIBS REQ LIFT ASSIST,\n
(From: WadsTextSender) STRK-STROKE,897 LONGBROOK DR,WADSWORTH,87 YOF POSSIBLE STROKE,\n
(From: WadsTextSender) FALL-FALL ,774 RENEE DR,WADSWORTH,87 YOM FALL VICTIM,\n
(From: WadsTextSender) WEAK-GENERAL ILLNESS,569 BROAD ST,WADSWORTH,ELDERLY MALE WEAK CATH PROBLEMS,\n
(From: WadsTextSender) WEAK-GENERAL ILLNESS,922 DEVONWOOD DR,WADSWORTH,80 YOM WEAK WITH DEMI,\n
(From: WadsTextSender) KBROWN: UNKW-UNKNOWN,540 MAIN ST,WADSWORTH,MEDICAL ALARM - UNKNOWN PROBLEM, UNABLE TO MAKE CONTACT WITH PATIENT,NO KEY LOCATION LISTED,\n
(From: WadsTextSender) BLED-BLEEDING,531 HIGH ST 11,MENWA APTS,WADSWORTH,FEMALE BLEEDING BADLY FROM LEG,\n
(From: WadsTextSender) FALL-FALL ,468 MEADOW DR,WADSWORTH,FEMALE FALL VICTIM, SEMI CONSCIOUS,\n
(From: WadsTextSender) WEAK-GENERAL ILLNESS,1160 WILLIAMS RESERVE BV 1,WADS DIALYSIS FRESENIUS,WADSWORTH,FEMALE / DIZZY / SLURED SPEECH,\n
(From: WadsTextSender) mbanks: SEIZ-SEIZURE,482 DURLING DR,WADSWORTH,38 YOM HAVING A SEIZURE,\n
(From: WadsTextSender) HART-HEART,587 WEST ST,WADSWORTH,,\n
(From: WadsTextSender) UNRE-UNRESPONSE,2275 COVINGTON,,3 YOF UNRESPONSIVE, HX OF SEIZURES, HIGH TEMP,\n

Contact: Mike Banks <mbanks@wadsworthcity.org>
Sender: info@sundance-sys.com
(From: WadsTextSender) BRTH-DIF BREATHING,1160 WILLIAMS RESERVE BV 1,WADS DIALYSIS FRESENIUS,WADSWORTH,ELDERLY MALE DIALYSIS PT - DIFFICULTY BREATHING AND NAU
(From: WadsTextSender) SEIZ-SEIZURE,7981 RIDGE RD,WADSWORTH,MALE IN SEIZURE, FELL DOWN 6 STEPS, INCOHERENT,

Contact: Active911
Agency name: Copley Fire Department
Location: Copley, OH, United States
Sender: alerts@inspironlogistics.com

(Alert Notification) cmitchen: F 3/4 PER PD UNITS ON SCENE 1520 COLLIER RD,COPLEY,GRN COLORED VEH SPUN AROUND AND NOW IN THE DITCH, POSS HIT THE TELEPHONE POLE,2ND CALL, NEG 32,PER<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) tlajko: F5-MEDICAL,3890 MEDINA RD A,CHIPOTLE,COPLEY,CUSTOMER PASSED OUT,<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) tlajko: F5-MEDICAL,850 SUMNER PARKWAY 116,COPLEY, PER OIC FAIRLAWN RESPONDING W/ SQUAD<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) tlajko: F1-CARDIAC,1850 JACOBY RD,COPLEY,CHEST PAIN, HX OF 3 LEAKING HEART VALVES,<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) tlajko: F13CD-ALARM DROP - COMMERCIAL,1315 CLEVE-MASS RD,GRAVES LUMBER CO,COPLEY,RETAIL SMOKE DETECTOR,<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) tlajko: F5-MEDICAL,1275 OH DR,ROADWAY EXPRESS,COPLEY DRI W/ HIGH BLOOD PRESSURE. FAIRLAWN RESPONDING W/SQUAD<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) tlajko: F5-MEDICAL,120 BROOKMONT RD 314,WINDSONG CARE CENTER,COPLEY,FEMALE PASSING LARGE BLOOD CLOTS,<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) tlajko: F5-MEDICAL,808 WALLWOOD DR,COPLEY,73 YO MALE LOW BLOOD PRESSURE,PT HAS OXYGEN MASK, BREATHING IS SHALLOW,<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) tlajko: F3-INJURY,828 DOGWOOD TER,,COME IN THRU BACK DOOR.,INJURY FROM FALL,<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) cmitchen: F5-MEDICAL,3127 HEMPHILL RD,COPLEY,87 YR OLD MALE LETHARGIC,<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) cmitchen: F13CD-ALARM DROP - COMMERCIAL,2110 COPLEY RD 2,EZ ACCEPTANCE BUILDERS INC,AKRON,SMOKE ALARM BASEMENT,NO ANSWER @ BUSINESS. WILL ATTEMPT AN EC,<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) grafferty: F3-INJURY,4573 ROCKRIDGE WAY,COPLEY,93 YOA FEMALE FALL INJURY.,<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) memerson: F2-RESPIRATORY,170 MONTROSE WEST AVE,STUDIO PLUS,COPLEY,SHORTNESS BREATHING IN THE MAIN LOBBY.,<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) mferrar: F1-CARDIAC,2836 CLIFFSIDE DR,COPLEY,58 YOM WITH CHEST PAINS,<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) sjustice: F5-MEDICAL,3808 FAIRWAY PARK DR 108,COPLEY,SEVERE NOSE BLEED.,<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n
(Alert Notification) dmarsi: F7-MUTUAL AID - EMS,575 CLEVE MASS RD 217,THE ARBOR'S OF FAIRLAWN,,GI BLEED,SQUAD AND MANPOWER,<br /><br/>\n\nThe enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n

 */

public class OHSummitCountyBParserTest extends BaseParserTest {
  
  public OHSummitCountyBParserTest() {
    setParser(new OHSummitCountyBParser(), "SUMMIT COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "BRTH-DIF BREATHING,587 HIGHLAND AV,WADSWORTH,85 YOM SHORTNESS OF BREATH, ",
        "CALL:BRTH-DIF BREATHING",
        "ADDR:587 HIGHLAND AV",
        "MADDR:587 HIGHLAND AVE",
        "CITY:WADSWORTH",
        "INFO:85 YOM SHORTNESS OF BREATH");

    doTest("T2",
        "STRK-STROKE,1160 WILLIAMS RESERVE BV 1,WADS DIALYSIS FRESENIUS,WADSWORTH,ELDERLY FEMALE POSSIBLE STROKE, LEFT ARM WEAKNESS,",
        "CALL:STRK-STROKE",
        "ADDR:1160 WILLIAMS RESERVE BV 1",
        "PLACE:WADS DIALYSIS FRESENIUS",
        "CITY:WADSWORTH",
        "INFO:ELDERLY FEMALE POSSIBLE STROKE / LEFT ARM WEAKNESS");

    doTest("T3",
        "STRK-STROKE,190 MAIN ST LOBBY,WADS TOWERS,WADSWORTH,53 YOM POSS STROKE, CONFUSED, HEADACHE,",
        "CALL:STRK-STROKE",
        "ADDR:190 MAIN ST LOBBY",
        "MADDR:190 MAIN ST",
        "PLACE:WADS TOWERS",
        "CITY:WADSWORTH",
        "INFO:53 YOM POSS STROKE / CONFUSED / HEADACHE");

    doTest("T4",
        "WEAK-GENERAL ILLNESS,175 GREAT OAKS TR,BUEHLERS GROCERY STORE,WADSWORTH,MALE PATIENT IN STAT CARE ABOUT TO PASS OUT,",
        "CALL:WEAK-GENERAL ILLNESS",
        "ADDR:175 GREAT OAKS TR",
        "PLACE:BUEHLERS GROCERY STORE",
        "CITY:WADSWORTH",
        "INFO:MALE PATIENT IN STAT CARE ABOUT TO PASS OUT");

    doTest("T5",
        "FALL-FALL ,468 MEADOW DR,WADSWORTH,FEMALE FALL VICTIM, SEMI CONSCIOUS,",
        "CALL:FALL-FALL",
        "ADDR:468 MEADOW DR",
        "CITY:WADSWORTH",
        "INFO:FEMALE FALL VICTIM / SEMI CONSCIOUS");

    doTest("T6",
        "WEAK-GENERAL ILLNESS,253 BROAD ST D,WADSWORTH,FEMALE FEELS LIKE SHE IS GOING TO PASS OUT,",
        "CALL:WEAK-GENERAL ILLNESS",
        "ADDR:253 BROAD ST D",
        "CITY:WADSWORTH",
        "INFO:FEMALE FEELS LIKE SHE IS GOING TO PASS OUT");

    doTest("T7",
        "MVA-MVA (EMS) (INJURY),0 BROUSE DR/HIGH ST,BROUSE DR/HIGH ST,WADSWORTH,2 CARS INVOLVED,",
        "CALL:MVA-MVA (EMS) (INJURY)",
        "ADDR:BROUSE DR & HIGH ST",
        "CITY:WADSWORTH",
        "INFO:2 CARS INVOLVED");

    doTest("T8",
        "FALL-FALL ,281 DEEPWOOD DR,WADSWORTH,72 YOF FELL UNK INJ,",
        "CALL:FALL-FALL",
        "ADDR:281 DEEPWOOD DR",
        "CITY:WADSWORTH",
        "INFO:72 YOF FELL UNK INJ");

    doTest("T9",
        "BLED-BLEEDING,357 DEEPWOOD DR,WADSWORTH,69 YOM BLEEDING FROM HERNIA SURGERY SITE,",
        "CALL:BLED-BLEEDING",
        "ADDR:357 DEEPWOOD DR",
        "CITY:WADSWORTH",
        "INFO:69 YOM BLEEDING FROM HERNIA SURGERY SITE");

    doTest("T10",
        "STRK-STROKE,315 WESTVIEW AV,WADSWORTH,97 YOM POSSIBLE STROKE,",
        "CALL:STRK-STROKE",
        "ADDR:315 WESTVIEW AV",
        "MADDR:315 WESTVIEW AVE",
        "CITY:WADSWORTH",
        "INFO:97 YOM POSSIBLE STROKE");

    doTest("T11",
        "DIAB-DIABETIC ,0 MILLS ST/S PARDEE ST,MILLS ST/S PARDEE ST,WADSWORTH,MALE DIABETIC PROBLEMS PD ON SCENE,",
        "CALL:DIAB-DIABETIC",
        "ADDR:MILLS ST & S PARDEE ST",
        "CITY:WADSWORTH",
        "INFO:MALE DIABETIC PROBLEMS PD ON SCENE");

  }
  
  @Test
  public void testWadsworthFireEMS() {

    doTest("T1",
        "(From: WadsTextSender) jneforos: FALL-FALL ,190 MAIN ST,WADS TOWERS,WADSWORTH,MALE FELL IN PARKING LOT NOW IN LOBBY,\n",
        "CALL:FALL-FALL",
        "ADDR:190 MAIN ST",
        "CITY:WADSWORTH",
        "PLACE:WADS TOWERS",
        "INFO:MALE FELL IN PARKING LOT NOW IN LOBBY");

    doTest("T2",
        "(From: WadsTextSender) FALL-FALL ,190 MAIN ST,WADS TOWERS,WADSWORTH,,\n",
        "CALL:FALL-FALL",
        "ADDR:190 MAIN ST",
        "CITY:WADSWORTH",
        "PLACE:WADS TOWERS");

    doTest("T3",
        "(From: WadsTextSender) FALL-FALL ,160 HALL DR,WADSWORTH,81 YOM FALL VICTIM POSS BROKEN HIP,\n",
        "CALL:FALL-FALL",
        "ADDR:160 HALL DR",
        "CITY:WADSWORTH",
        "INFO:81 YOM FALL VICTIM POSS BROKEN HIP");

    doTest("T4",
        "(From: WadsTextSender) mbanks: WEAK-GENERAL ILLNESS,143 MEADOWCREEK DR A, MANPOWER ASSIST CODE RED FOR LIFTING\n",
        "CALL:WEAK-GENERAL ILLNESS",
        "ADDR:143 MEADOWCREEK DR A",
        "INFO:MANPOWER ASSIST CODE RED FOR LIFTING");

    doTest("T5",
        "(From: WadsTextSender) mbanks: WEAK-GENERAL ILLNESS,815 BROAD ST,CIRCLE K EAST,WADSWORTH,POSSIBLE SUICIDE ATTEMPT - STANDBY FOR PD,\n",
        "CALL:WEAK-GENERAL ILLNESS",
        "ADDR:815 BROAD ST",
        "CITY:WADSWORTH",
        "PLACE:CIRCLE K EAST",
        "INFO:POSSIBLE SUICIDE ATTEMPT - STANDBY FOR PD");

    doTest("T6",
        "(From: WadsTextSender) WEAK-GENERAL ILLNESS,815 BROAD ST,CIRCLE K EAST,WADSWORTH,POSSIBLE SUICIDE ATTEMPT - STANDBY FOR PD,\n",
        "CALL:WEAK-GENERAL ILLNESS",
        "ADDR:815 BROAD ST",
        "CITY:WADSWORTH",
        "PLACE:CIRCLE K EAST",
        "INFO:POSSIBLE SUICIDE ATTEMPT - STANDBY FOR PD");

    doTest("T7",
        "(From: WadsTextSender) PAIN-PAIN,250 SMOKERISE DR,LIBERTY RESIDENCE,WADSWORTH,91 YOF IN PAIN, UNABLE TO MOVE,\n",
        "CALL:PAIN-PAIN",
        "ADDR:250 SMOKERISE DR",
        "CITY:WADSWORTH",
        "PLACE:LIBERTY RESIDENCE",
        "INFO:91 YOF IN PAIN / UNABLE TO MOVE");

    doTest("T8",
        "(From: WadsTextSender) FALL-FALL ,1054 FREEDOM DR 103,LIBERTY RESIDENCE II,WADSWORTH,91 YOF FALL VICTIM,\n",
        "CALL:FALL-FALL",
        "ADDR:1054 FREEDOM DR 103",
        "CITY:WADSWORTH",
        "PLACE:LIBERTY RESIDENCE II",
        "INFO:91 YOF FALL VICTIM");

    doTest("T9",
        "(From: WadsTextSender) DIAB-DIABETIC ,540 GREAT OAKS TR 311R,WADS POINTE,WADSWORTH,HIGH BLOOD SUGAR,\n",
        "CALL:DIAB-DIABETIC",
        "ADDR:540 GREAT OAKS TR 311R",
        "CITY:WADSWORTH",
        "PLACE:WADS POINTE",
        "INFO:HIGH BLOOD SUGAR");

    doTest("T10",
        "(From: WadsTextSender) BRTH-DIF BREATHING,531 HIGH ST 3,MENWA APTS,WADSWORTH,,\n",
        "CALL:BRTH-DIF BREATHING",
        "ADDR:531 HIGH ST 3",
        "CITY:WADSWORTH",
        "PLACE:MENWA APTS");

    doTest("T11",
        "(From: WadsTextSender) PAIN-PAIN,1054 FREEDOM DR 109,LIBERTY RESIDENCE II,WADSWORTH,ELDERLY FEMALE STOMACH PAIN,\n",
        "CALL:PAIN-PAIN",
        "ADDR:1054 FREEDOM DR 109",
        "CITY:WADSWORTH",
        "PLACE:LIBERTY RESIDENCE II",
        "INFO:ELDERLY FEMALE STOMACH PAIN");

    doTest("T12",
        "(From: WadsTextSender) INJ-INJURY,1371 HIGH ST 114,PARK TERRACE APTS,WADSWORTH,23 YOM FELL ON ICE, LEFT ANKLE FX,\n",
        "CALL:INJ-INJURY",
        "ADDR:1371 HIGH ST 114",
        "CITY:WADSWORTH",
        "PLACE:PARK TERRACE APTS",
        "INFO:23 YOM FELL ON ICE / LEFT ANKLE FX");

    doTest("T13",
        "(From: WadsTextSender) hsonntag: FALL-FALL ,774 RENEE DR,WADSWORTH,87,87 YOM WITH BROKEN RIBS REQ LIFT ASSIST,\n",
        "CALL:FALL-FALL",
        "ADDR:774 RENEE DR",
        "CITY:WADSWORTH",
        "INFO:87 / 87 YOM WITH BROKEN RIBS REQ LIFT ASSIST");

    doTest("T14",
        "(From: WadsTextSender) STRK-STROKE,897 LONGBROOK DR,WADSWORTH,87 YOF POSSIBLE STROKE,\n",
        "CALL:STRK-STROKE",
        "ADDR:897 LONGBROOK DR",
        "CITY:WADSWORTH",
        "INFO:87 YOF POSSIBLE STROKE");

    doTest("T15",
        "(From: WadsTextSender) FALL-FALL ,774 RENEE DR,WADSWORTH,87 YOM FALL VICTIM,\n",
        "CALL:FALL-FALL",
        "ADDR:774 RENEE DR",
        "CITY:WADSWORTH",
        "INFO:87 YOM FALL VICTIM");

    doTest("T16",
        "(From: WadsTextSender) WEAK-GENERAL ILLNESS,569 BROAD ST,WADSWORTH,ELDERLY MALE WEAK CATH PROBLEMS,\n",
        "CALL:WEAK-GENERAL ILLNESS",
        "ADDR:569 BROAD ST",
        "CITY:WADSWORTH",
        "INFO:ELDERLY MALE WEAK CATH PROBLEMS");

    doTest("T17",
        "(From: WadsTextSender) WEAK-GENERAL ILLNESS,922 DEVONWOOD DR,WADSWORTH,80 YOM WEAK WITH DEMI,\n",
        "CALL:WEAK-GENERAL ILLNESS",
        "ADDR:922 DEVONWOOD DR",
        "CITY:WADSWORTH",
        "INFO:80 YOM WEAK WITH DEMI");

    doTest("T18",
        "(From: WadsTextSender) KBROWN: UNKW-UNKNOWN,540 MAIN ST,WADSWORTH,MEDICAL ALARM - UNKNOWN PROBLEM, UNABLE TO MAKE CONTACT WITH PATIENT,NO KEY LOCATION LISTED,\n",
        "CALL:UNKW-UNKNOWN",
        "ADDR:540 MAIN ST",
        "CITY:WADSWORTH",
        "INFO:MEDICAL ALARM - UNKNOWN PROBLEM / UNABLE TO MAKE CONTACT WITH PATIENT / NO KEY LOCATION LISTED");

    doTest("T19",
        "(From: WadsTextSender) BLED-BLEEDING,531 HIGH ST 11,MENWA APTS,WADSWORTH,FEMALE BLEEDING BADLY FROM LEG,\n",
        "CALL:BLED-BLEEDING",
        "ADDR:531 HIGH ST 11",
        "CITY:WADSWORTH",
        "PLACE:MENWA APTS",
        "INFO:FEMALE BLEEDING BADLY FROM LEG");

    doTest("T20",
        "(From: WadsTextSender) FALL-FALL ,468 MEADOW DR,WADSWORTH,FEMALE FALL VICTIM, SEMI CONSCIOUS,\n",
        "CALL:FALL-FALL",
        "ADDR:468 MEADOW DR",
        "CITY:WADSWORTH",
        "INFO:FEMALE FALL VICTIM / SEMI CONSCIOUS");

    doTest("T21",
        "(From: WadsTextSender) WEAK-GENERAL ILLNESS,1160 WILLIAMS RESERVE BV 1,WADS DIALYSIS FRESENIUS,WADSWORTH,FEMALE / DIZZY / SLURED SPEECH,\n",
        "CALL:WEAK-GENERAL ILLNESS",
        "ADDR:1160 WILLIAMS RESERVE BV 1",
        "CITY:WADSWORTH",
        "PLACE:WADS DIALYSIS FRESENIUS",
        "INFO:FEMALE / DIZZY / SLURED SPEECH");

    doTest("T22",
        "(From: WadsTextSender) mbanks: SEIZ-SEIZURE,482 DURLING DR,WADSWORTH,38 YOM HAVING A SEIZURE,\n",
        "CALL:SEIZ-SEIZURE",
        "ADDR:482 DURLING DR",
        "CITY:WADSWORTH",
        "INFO:38 YOM HAVING A SEIZURE");

    doTest("T23",
        "(From: WadsTextSender) HART-HEART,587 WEST ST,WADSWORTH,,\n",
        "CALL:HART-HEART",
        "ADDR:587 WEST ST",
        "CITY:WADSWORTH");

    doTest("T24",
        "(From: WadsTextSender) UNRE-UNRESPONSE,2275 COVINGTON,,3 YOF UNRESPONSIVE, HX OF SEIZURES, HIGH TEMP,\n",
        "CALL:UNRE-UNRESPONSE",
        "ADDR:2275 COVINGTON",
        "INFO:3 YOF UNRESPONSIVE / HX OF SEIZURES / HIGH TEMP");
  }
  
  @Test
  public void testMikeBanks() {
    
    doTest("T1",
        "(From: WadsTextSender) BRTH-DIF BREATHING,1160 WILLIAMS RESERVE BV 1,WADS DIALYSIS FRESENIUS,WADSWORTH,ELDERLY MALE DIALYSIS PT - DIFFICULTY BREATHING AND NAU",
        "CALL:BRTH-DIF BREATHING",
        "ADDR:1160 WILLIAMS RESERVE BV 1",
        "CITY:WADSWORTH",
        "PLACE:WADS DIALYSIS FRESENIUS",
        "INFO:ELDERLY MALE DIALYSIS PT - DIFFICULTY BREATHING AND NAU");

    doTest("T2",
        "(From: WadsTextSender) SEIZ-SEIZURE,7981 RIDGE RD,WADSWORTH,MALE IN SEIZURE, FELL DOWN 6 STEPS, INCOHERENT,",
        "CALL:SEIZ-SEIZURE",
        "ADDR:7981 RIDGE RD",
        "CITY:WADSWORTH",
        "INFO:MALE IN SEIZURE / FELL DOWN 6 STEPS / INCOHERENT");

  }
  
  @Test
  public void testCopleyFire() {

    doTest("T1",
        "(Alert Notification) cmitchen: F 3/4 PER PD UNITS ON SCENE 1520 COLLIER RD,COPLEY,GRN COLORED VEH SPUN AROUND AND NOW IN THE DITCH, POSS HIT THE TELEPHONE POLE,2ND CALL, NEG 32,PER<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F 3/4 PER PD UNITS ON SCENE",
        "ADDR:1520 COLLIER RD",
        "CITY:COPLEY",
        "INFO:GRN COLORED VEH SPUN AROUND AND NOW IN THE DITCH / POSS HIT THE TELEPHONE POLE / 2ND CALL / NEG 32 / PER");

    doTest("T2",
        "(Alert Notification) tlajko: F5-MEDICAL,3890 MEDINA RD A,CHIPOTLE,COPLEY,CUSTOMER PASSED OUT,<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F5-MEDICAL",
        "ADDR:3890 MEDINA RD A",
        "CITY:COPLEY",
        "PLACE:CHIPOTLE",
        "INFO:CUSTOMER PASSED OUT");

    doTest("T3",
        "(Alert Notification) tlajko: F5-MEDICAL,850 SUMNER PARKWAY 116,COPLEY, PER OIC FAIRLAWN RESPONDING W/ SQUAD<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F5-MEDICAL",
        "ADDR:850 SUMNER PARKWAY 116",
        "CITY:COPLEY",
        "INFO:PER OIC FAIRLAWN RESPONDING W/ SQUAD");

    doTest("T4",
        "(Alert Notification) tlajko: F1-CARDIAC,1850 JACOBY RD,COPLEY,CHEST PAIN, HX OF 3 LEAKING HEART VALVES,<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F1-CARDIAC",
        "ADDR:1850 JACOBY RD",
        "CITY:COPLEY",
        "INFO:CHEST PAIN / HX OF 3 LEAKING HEART VALVES");

    doTest("T5",
        "(Alert Notification) tlajko: F13CD-ALARM DROP - COMMERCIAL,1315 CLEVE-MASS RD,GRAVES LUMBER CO,COPLEY,RETAIL SMOKE DETECTOR,<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F13CD-ALARM DROP - COMMERCIAL",
        "ADDR:1315 CLEVE-MASS RD",
        "MADDR:1315 CLEVELAND MASSILON RD",
        "CITY:COPLEY",
        "PLACE:GRAVES LUMBER CO",
        "INFO:RETAIL SMOKE DETECTOR");

    doTest("T6",
        "(Alert Notification) tlajko: F5-MEDICAL,1275 OH DR,ROADWAY EXPRESS,COPLEY DRI W/ HIGH BLOOD PRESSURE. FAIRLAWN RESPONDING W/SQUAD<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F5-MEDICAL",
        "ADDR:1275 OH DR",
        "INFO:ROADWAY EXPRESS / COPLEY DRI W/ HIGH BLOOD PRESSURE. FAIRLAWN RESPONDING W/SQUAD");

    doTest("T7",
        "(Alert Notification) tlajko: F5-MEDICAL,120 BROOKMONT RD 314,WINDSONG CARE CENTER,COPLEY,FEMALE PASSING LARGE BLOOD CLOTS,<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F5-MEDICAL",
        "ADDR:120 BROOKMONT RD 314",
        "CITY:COPLEY",
        "PLACE:WINDSONG CARE CENTER",
        "INFO:FEMALE PASSING LARGE BLOOD CLOTS");

    doTest("T8",
        "(Alert Notification) tlajko: F5-MEDICAL,808 WALLWOOD DR,COPLEY,73 YO MALE LOW BLOOD PRESSURE,PT HAS OXYGEN MASK, BREATHING IS SHALLOW,<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F5-MEDICAL",
        "ADDR:808 WALLWOOD DR",
        "CITY:COPLEY",
        "INFO:73 YO MALE LOW BLOOD PRESSURE / PT HAS OXYGEN MASK / BREATHING IS SHALLOW");

    doTest("T9",
        "(Alert Notification) tlajko: F3-INJURY,828 DOGWOOD TER,,COME IN THRU BACK DOOR.,INJURY FROM FALL,<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F3-INJURY",
        "ADDR:828 DOGWOOD TER",
        "INFO:COME IN THRU BACK DOOR. / INJURY FROM FALL");

    doTest("T10",
        "(Alert Notification) cmitchen: F5-MEDICAL,3127 HEMPHILL RD,COPLEY,87 YR OLD MALE LETHARGIC,<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F5-MEDICAL",
        "ADDR:3127 HEMPHILL RD",
        "CITY:COPLEY",
        "INFO:87 YR OLD MALE LETHARGIC");

    doTest("T11",
        "(Alert Notification) cmitchen: F13CD-ALARM DROP - COMMERCIAL,2110 COPLEY RD 2,EZ ACCEPTANCE BUILDERS INC,AKRON,SMOKE ALARM BASEMENT,NO ANSWER @ BUSINESS. WILL ATTEMPT AN EC,<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F13CD-ALARM DROP - COMMERCIAL",
        "ADDR:2110 COPLEY RD 2",
        "CITY:AKRON",
        "PLACE:EZ ACCEPTANCE BUILDERS INC",
        "INFO:SMOKE ALARM BASEMENT / NO ANSWER @ BUSINESS. WILL ATTEMPT AN EC");

    doTest("T12",
        "(Alert Notification) grafferty: F3-INJURY,4573 ROCKRIDGE WAY,COPLEY,93 YOA FEMALE FALL INJURY.,<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F3-INJURY",
        "ADDR:4573 ROCKRIDGE WAY",
        "CITY:COPLEY",
        "INFO:93 YOA FEMALE FALL INJURY.");

    doTest("T13",
        "(Alert Notification) memerson: F2-RESPIRATORY,170 MONTROSE WEST AVE,STUDIO PLUS,COPLEY,SHORTNESS BREATHING IN THE MAIN LOBBY.,<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F2-RESPIRATORY",
        "ADDR:170 MONTROSE WEST AVE",
        "CITY:COPLEY",
        "PLACE:STUDIO PLUS",
        "INFO:SHORTNESS BREATHING IN THE MAIN LOBBY.");

    doTest("T14",
        "(Alert Notification) mferrar: F1-CARDIAC,2836 CLIFFSIDE DR,COPLEY,58 YOM WITH CHEST PAINS,<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F1-CARDIAC",
        "ADDR:2836 CLIFFSIDE DR",
        "CITY:COPLEY",
        "INFO:58 YOM WITH CHEST PAINS");

    doTest("T15",
        "(Alert Notification) sjustice: F5-MEDICAL,3808 FAIRWAY PARK DR 108,COPLEY,SEVERE NOSE BLEED.,<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F5-MEDICAL",
        "ADDR:3808 FAIRWAY PARK DR 108",
        "CITY:COPLEY",
        "INFO:SEVERE NOSE BLEED.");

    doTest("T16",
        "(Alert Notification) dmarsi: F7-MUTUAL AID - EMS,575 CLEVE MASS RD 217,THE ARBOR'S OF FAIRLAWN,,GI BLEED,SQUAD AND MANPOWER,<br /><br/>\n\n" +
        "The enclosed information is STRICTLY CONFIDENTIAL and is intended for the use of the addressee only. Summit County, Oh and its affiliates disclaim any responsibility for unauthorized disclosure of this information other than the addressee. To unsubscribe, please email stop to remove@wensnetwork.com.\n",

        "CALL:F7-MUTUAL AID - EMS",
        "ADDR:575 CLEVE MASS RD 217",
        "INFO:THE ARBOR'S OF FAIRLAWN / GI BLEED / SQUAD AND MANPOWER");

  }
  
  public static void main(String[] args) {
    new OHSummitCountyBParserTest().generateTests("T1");
  }
}