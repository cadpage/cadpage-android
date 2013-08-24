package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
La Plata County, CO
Contact: Active911
Agency name: Durango Fire Rescue
Location: Durango, CO, United States
Sender: hiplink@ci.durango.co.us 

(Message from HipLink) DFRA\nD5   \nF-SMOKE OUTSD  \n101 CR 248 ; 1/4 OF M NE OF THIS ADDRESS\nDF5\nSPARKS FROM ELECTRICAL POLE ; POSS FLAMES ; WENT OUT AND THEN CAME BACK \n\n13DF-1876\n06/20/2013 22:58
(Message from HipLink) DFRA\nD2   \nE-SICK         \n296 E PARK AV\nDF2 M2\nFEM CONC/BREA CANT SEE ANYTHING; UNK PROBLEM\n\n13DF-1875\n06/20/2013 22:27
(Message from HipLink) DFRA\nD3   \nE-CHEST PAIN   \n1700 CR 203; APT 203\nDF3 M1\n40 YOM ; CON/DIFF ; CHEST PAIN \n17:28:29 06/20/2013 - Gonzales Y V\nDIZZY ; LEFT ARM IS NUMB \n\n13DF-1874\n06/20/2013 17:28
(Message from HipLink) DFRA\nD6   \nE-CHEST PAIN   \n55 ANIMOSA CIR; 32230 HWY 550 N\nDF6 M3\n89YOF ; CON/DIFF BREA ; CHEST PAIN \n\n13DF-1873\n06/20/2013 16:43
(Message from HipLink) DFRA\nD2   \nE-TRAUMA       \n2416 W 2ND AV\nDF2 M2\n25 YOF ; CONS/BREA ; SMASHED HEAD ; UNABLE TO EXPLAIN FURTHER ; SEEMS CONFUSED \n\n13DF-1872\n06/20/2013 16:41
(Message from HipLink) DFRA\nD7   \nE-SEIZURE/CONV \n1 MERCADO ST; THREE SPRINGS; STE 100\nDF7 M1\nFEM ; SEIZING ; RP NOT WITH THE PATIENT IN THE LOBBY\n\n13DF-1871\n06/20/2013 15:39
(Message from HipLink) DFRA\nD2   \nE-FALLS        \n713 MAIN AV\nDF2 M2\nMALE SUBJ ; CON/BREA ; FELL HIT HIS HEAD\n15:31:26 06/20/2013 - Gonzales Y V   \n  INTOX SUBJ\n\n13DF-1870\n06/20/2013 15:31
(Message from HipLink) DFRA\nD3   \nE-TRAFF ACC    \nFLORIDA RD / CR 250\nDF3 M3\n2 MVA ACCIDENDT HEAD ON ; UNK INJ ; VAN VS SM SED ; ONE DRIVER NOT GETTING OUT\nOF VEH\n14:08:20 06/20/2013 - Gonzales Y V\nONE VEH LEAKING FLUID \n\n13DF-1869\n06/20/2013 14:08
(Message from HipLink) DFRA\nD2   \nF-CO DETECTOR  \n20979 HWY 160 W ; RM 201 FOUR WINDS MOTEL\nDF2\nCO DETECTOR GOING OFF ; RM EVACUATED \n\n13DF-1868\n06/20/2013 13:26
(Message from HipLink) DFRA\nD2   \nF-ALARM        \n1480 E 8TH AV\nDF2\nGENERAL FIRE ZONE 196, ADVD ALARM 8665995051, 0835 / 0837 WILL CONTACT\n\n13DF-1867\nTALON LN & E CAMPUS CT\n06/20/2013 08:38
(Message from HipLink) DFRA\nD3   \nE-SICK         \n2701 MAIN AV; WALGREENS DRUG STORE\nDF3 M3\n43YOF ; CONC/BREATH ; HAVING ANXIETY ATTACK ; \n05:07:19 06/20/2013 - KIMBALL K A\nF SAID M WAS BEING ABUSIVE ; M NOT ON SCENE\n05:07:24 06/20/2013 - KIMBALL K A\nF\n13DF-1866\n06/20/2013 05:07
(Message from HipLink) DFRA\nD9   \nF-OTHER        \n17800 HWY 160 W ; LAST TRAILER\nDF9\nSMELL OF BURNING ; NO SMOKE ; NO FLAMES\n\n13DF-1865\n06/20/2013 01:02
(Message from HipLink) DFRA\nD2   \nE-ALLERGY/STING\n1050 AVENIDA DEL SOL; HILLTOP HOUSE\nDF2 M1\n53YOM ; CONC/DIFF BREATH ; ALLERGIC REACTION ; VOMITING ; DRY MOUTH ; DIAHREA ;\nPALE MED IS COLCRYS; RP AT EXT 10\n\n13DF-1864\nELLA VITA CT\n06/19/2013 21:45
(Message from HipLink) DFRA\nD3   \nE-TRAFF ACC    \nFLORIDA RD / CR 250\nDF3 M2\nFEM CONC/BREA HIT STEERING WHEEL; PD ON SCENE\n\n13DF-1863\n06/19/2013 21:30
(Message from HipLink) DFRA\nD6   \nE-HEMOR/LAC    \n32222 HWY 550 N; 14\nDF6 M3\n59YOM ; CONC/BREATH ; 4 INCH GASH ON HEAD\n\n13DF-1862\n06/19/2013 21:15
(Message from HipLink) DFRA\nD2   \nE-TRAUMA       \n600 E 1ST ST\nDF2 M2\nFEM CONC/BREA TOE INJURY\n\n13DF-1861\n06/19/2013 20:40
(Message from HipLink) DFRA\nD3   \nE-TRAUMA       \n3141 MAIN AV; SPANISH TRAILS FRONT OFFICE\nDF3 M3\n58YOM CONC/BREA HIP OUT OF SOCKET\n\n13DF-1860\nE 31ST ST, W 31ST ST & E 32ND ST, W 32ND ST\n06/19/2013 18:35
(Message from HipLink) DFRA\nD2   \nE-SICK         \n633 ARROYO DR ; 102\nDF2 M2\n29YOF ; CONC/BREATH ; GOING THROUGH ALCOHOL WITHDRAWL \n18:13:32 06/19/2013 - KIMBALL K A\nPT IS STEPHANIE \n\n13DF-1859\n06/19/2013 18:13
(Message from HipLink) DFRA\nD2   \nE-MAN DOWN UNK \nSANTA RITA DR / S CAMINO DEL RIO\nDF2 M2\nELDERLY MALE SUBJ ON BIKE; SLUMPED OVER THE CONCRETE BARRIER; UNK FURTHER\n\n13DF-1858\nIntersection of: SANTA RITA DR & S CAMINO DEL RIO\n06/19/2013 17:49
(Message from HipLink) DFRA\nD1   \nF-MUTUAL AID   \nAID KIRTLAND NM\nDF1\n\n13DF-1857\n06/19/2013 16:52
(Message from HipLink) DFRA\nD14  \nE-SEIZURE/CONV \n238 N TAMARRON DR; GLACIER CLUB @ TAMARRON; 2ND HOLE\nDF14 M15\n72YOF UNCONC/BREATH ;SEIZURE \n\n13DF-1855\n06/19/2013 13:02
(Message from HipLink) DFRA\nD2   \nE-MAN DOWN UNK \n1100 AVENIDA DEL SOL\nDF2 M2\nMALE UNK CONC/UNK BREATH ;RP ADVD HE FOUND A MAN IN A TENT WITH HIS FEET\nSTICKING OUT ; WAS ON A TRAIL\nNEAR THE NEW HOMES THAT ARE BEING BUILT BY MANNA ;RP REF AND DISCONNECT\n13DF-1854\n06/19/2013 12:43
(Message from HipLink) DFRA\nD2   \nE-TRAFF ACC    \n300 E 7TH ST\nDF2 M3\n60 YOF ; CON/BREA ; NECK INJ FROM MVA\n\n13DF-1853\n06/19/2013 11:59
(Message from HipLink) DFRA\nD2   \nE-SICK         \n633 ARROYO DR ; 102\nDF2A M3\n29YOF ;CONS/BREA ; DIFF TALKING BETWEEN BREATHS; FEELING SICK ; SOUND\nDISORIENTED \n\n13DF-1851\n06/19/2013 10:52
(Message from HipLink) DFRA\nD2   \nE-OD/POISON    \n311 W COLLEGE DR; ALBERTSONS\nDF2 M2\nMALE ; UNCONS/BREA ; INTOX ; PD ON SCENE ; BEHIND ALBERTSONS ON STAIRS TO RIVER\nTRAIL\n\n13DF-1850\n06/19/2013 10:23
(Message from HipLink) DFRA\nD2   \nE-BREATHING    \n633 ARROYO DR; # 102\nDF2 M2\n29 YOF CONC/DIFF BREA \n03:41:28 06/19/2013 - CASTRO C\nSUBJ IS INTOX \n\n13DF-1848\n06/19/2013 03:41
(Message from HipLink) DFRA\nD2   \nE-FALLS        \n633 ARROYO DR\nDF2 M2\n29 YOF ; INTOX ; FELL FROM STANDING KNEE PAIN \n\n13DF-1847\n06/19/2013 03:01
(Message from HipLink) DFRA\nD2   \nE-FALLS        \n600 MAIN AV\nDF2 M2\n35YOM; UNCON/BRE FELL, INTOX \n\n13DF-1846\nW COLLEGE DR, E COLLEGE DR & E 7TH ST, W 7TH ST\n06/18/2013 23:55
(Message from HipLink) DFRA\nD2   \nF-BRUSH        \n21800 HWY 160 W  ; ABOVE DOG PARK\nDF2\nFLAMES VISIBLE ON SMELTER ; 1/3 UP THE HILL ABOVE DOG PARK\n\n13DF-1844\n06/18/2013 21:04
(Message from HipLink) DFRA\nD1   \nE-ABDOM PAIN   \n742 TURNER DR\nDF1 M1\n20 YOF ; CON/BRE ; STOMACH PAIN\n18:07:19 06/18/2013 - Meyers S D     \nCOME TO SALLY PORT ;\n\n13DF-1843\nBODO DR\n06/18/2013 18:07

Contact: Active911
Agency name: Fort Lewis Mesa Fire Protection District
Location: Hesperus, CO, United States
Sender: hiplink@ci.durango.co.us

(Message from HipLink) FLM \nFLM1 \nE-STAB/GUNSHOT \n2808 CR 129\nFLM1\n40YOF ; CONC/BREA ; JUST STABBED BY MALE SUBJ \n16:43:21 06/18/2013 - Harr K L\nMALE STILL ON SCNE \n16:43:37 06/18/2013 - Harr K L\nMALE IS FEM'S HUSBAND \n\n13FL-0082\n06/18/2013 16:43
(Message from HipLink) FLM \nFLM2 \nF-SMOKE OUTSD  \n5038 CR 124; 10600BLK HWY 160 W\nFLM2\nSMELL OF SMOKE IN CANYON ; NO VISUAL \n\n13FL-0081\n06/18/2013 07:30
(Message from HipLink) FLM \nFLM2 \nE-SUICIDE/CIT  \n21351 HWY 140; 4\nFLM2 M1\nFEM BARRICARED IN ROOM W KNIFE; SO REQ MEDS STAGE\n\n13FL-0080\n06/16/2013 20:14
(Message from HipLink) FLM \nFLM1 \nF-SMOKE OUTSD  \n100 CR 113\nFLM1\nLARGE AMOUNT OF BLK SMOKE IN AREA ; JUST STARTED ; UNK WHAT'S BURNING \n\n13FL-0079\n06/16/2013 14:42
(Message from HipLink) FLM \nFLM1 \nF-BRUSH        \nCR 110 / CR 100\nFLM1\n2 LIGHTENING STRIKES\n\n13FL-0078\n06/15/2013 17:31
(Message from HipLink) FLM \nFLM2 \nF-VEHICLE      \n9000 HWY 160 W\nFLM2\nVEH ON FIRE ; FULLY ENGULFED ; NO ONE IN THE VEH \n\n13FL-0077\n06/14/2013 21:52
(Message from HipLink) FLM \nFLM2 \nF-SMOKE OUTSD  \n5000 HWY 160 W ; IN THE AREA OF\nFLM2\nSMOKE VISIBLE ; UNK FURTHER \n\n13FL-0075\n06/13/2013 15:39
(Message from HipLink) FLM \nFLM2 \nE-TRAFF ACC    \n8000 HWY 160 W; MM 70\nFLM2 M1\nVEH VS DEER ; RP ADV POSS INJUR ONE OF THE DEER CAME THROUGH THE WINDSHIELD ;\nDRIVER IS CONC / BREA OUT OF VEH POSS BROKEN HAND  \n\n13FL-0074\n06/10/2013 21:21
(Message from HipLink) FLM \nFLM2 \nE-TRAFF ACC    \n16000 HWY 140\nFLM2 M1\n2MVA ; REAR END ACCIDET ; 1 FEM CON/BREA BACK PAIN ; MALE CON/BREA BACK PAIN \n18:49:57 06/08/2013 - Gonzales Y V   \n  NOT BLOCKING TRAFFIC\n\n13FL-0073\n06/08/2013 18:50
(Message from HipLink) FLM \nFLM2 \nE-TRAFF ACC    \n9848 HWY 160 W; HESPERUS SKI AREA\nFLM2 M1\n1MVA ; ROLLOVER \n\n13FL-0072\n06/08/2013 14:29
(Message from HipLink) FLM \nFLM1 \nE-SUICIDE/CIT  \n550 ALKALI GULCH RD; 2215 CR 119\nEMS1\n\n13DF-1688\n06/08/2013 00:26
(Message from HipLink) FLM \nFLM2 \nE-TRAFF ACC    \nCR 120 / CR 123\nFLM2\nPOSS ROLL OVER ; NO ONE AROUND ; AIR BAGS DEPOLYED BLOOD ON THE SEAT AND AIR BAG\nCO/809HDC \n01:42:56 06/02/2013 - CASTRO C\nLOTS OF FRONT END DAMAGE POSS HIT OAK TREES\n01:43:33 06/02\n13FL-0070\n06/02/2013 01:44
(Message from HipLink) FLM \nFLM1 \nF-STRUCTURE    \nCR 128 / CR 126 ; IN B/T CR 129 AND 126 ON CR 128\nFLM1 DFMA\nRESI ON FIRE \n\n13FL-0069\n06/01/2013 01:41
(Message from HipLink) FLM \nFLM1 \nF-BRUSH        \n0 HWY 140\nFLM1\nBRUSH FIRE, UNK WHICH SIDE OF STATE LINE, BURNING ALONG SIDE OF HWY\n\n13FL-0068\n05/31/2013 12:34
(Message from HipLink) FLM \nFLM1 \nE-FALLS        \n1560 CR 133\nFLM1\nMALE PT ; CONS/BREA  ; FELL \n\n13FL-0067\n05/30/2013 15:35
(Message from HipLink) FLM \nFLM2 \nE-SEIZURE/CONV \n11951 CR 120\nFLM2 M1\n67YOF ; CONC/BREA ; WAS SEIZING\n\n13FL-0066\n05/27/2013 14:31
(Message from HipLink) FLM \nFLM1 \nF-SMOKE OUTSD  \nCR 128 / CR 129\nFLM1\nBLK SMOKE SHOWING IN AREA ; CONT BURN AT 1240 CR 128 BUT UTC RP  \n\n13FL-0065\n05/27/2013 09:51
(Message from HipLink) FLM \nFLM2 \nF-MUTUAL AID   \n615 CR 120\nDFMA\n\n13DF-1475\n05/23/2013 12:04
(Message from HipLink) FLM \nFLM2 \nF-MUTUAL AID   \n615 CR 120\nDFMA\nBRUSH TRUCK REQUEST FOR TREE ON FIRE\n\n13DF-1474\n05/23/2013 11:42
(Message from HipLink) FLM \nFLM2 \nF-BRUSH        \n615 CR 120\nFLM2\nCOTTONWOOD TREE ON FIRE; NO CLOSE TO STRUCTURES; TRL PARK ON  \n\n13FL-0064\n05/23/2013 11:36
(Message from HipLink) FLM \nFLM2 \nE-SEIZURE/CONV \nMANCOS HILL; 1 HWY 160 E @ COUNTYLINE\nFLM2 M1\n56YOM CONC/BREATH ;POSS SEIZURE ;RENDEVOUS\n17:32:10 05/17/2013 - Blakstad W M\nRP THINKS IT IS A PETTY MAUL SIEZURE\n\n13FL-0063\n05/17/2013 17:32
(Message from HipLink) FLM \nFLM1 \nF-ALARM        \n11274 HWY 140\nFLM1\nGEN FIRE ALARM ; CENT SEC OP 5 CB 8004413662 ; 1026/1029 \n\n13FL-0062\nCR 119 & CR 130A, CR 130\n05/17/2013 10:29
(Message from HipLink) FLM \nFLM2 \nF-ALARM        \n11846 HWY 160 W\nFLM2\nFIRE ALARM ZONE 1; DURANGO ELECTRIC\n\n13FL-0061\n05/16/2013 18:27
(Message from HipLink) FLM \nFLM2 \nE-TRAFF ACC    \n6000 HWY 160 W; MP 68\nFLM2\n30YM CONS, BRE;SHOULDER PAIN; 2ND HAND RP ALREADY EMD WITH CSP \n\n13FL-0060\n05/14/2013 11:29
(Message from HipLink) FLM \nFLM1 \nF-BRUSH        \n2000 CR 119\nFLM1\nCONTROLLED BURN ONLY PARTIALLY IN CONTROL ; UNATTENDED\n\n13FL-0059\n05/08/2013 17:30
(Message from HipLink) FLM \nFLM1 \nF-BRUSH        \nCR 119; IN THE AREA OF\nFLM1\nFIRE IN THE AREA\n\n13FL-0058\n05/08/2013 14:03
(Message from HipLink) FLM \nFLM2 \nF-ALARM        \n3674 CR 125; 21500 HWY 140\nFLM2\nAUD SHOWING SMOKE AND HEAT ;ALARM RELAY CB 8007629964 ;OPER CRYSTAL ;1253/1255\n;WILL ATTEMPT\n\n13FL-0057\n05/05/2013 12:56
(Message from HipLink) FLM \nFLM2 \nF-VEHICLE      \n0 HWY 160 W\nFLM2\n462EHL; FIRE IS OUT BUT VEH IS HOT \n\n13FL-0056\n05/04/2013 16:37
(Message from HipLink) FLM \nFLM1 \nF-GAS ODR INSD \n950 CR 104\nFLM1\nSTRONG ODOR OF PROPANE IN RESI ; RESI EVAC ; NO ONE SICK OF BUSY ; RP WAITING\nOUTSIDE IN VEH THAT IS ALREADY RUNNING \n\n13FL-0055\n04/26/2013 20:57
(Message from HipLink) FLM \nFLM1 \nE-SICK         \n65 CR 103\nFLM1 M2\n58 YOM SEMI-CONS; DIFF BRE; SWEATING ; POSS INTOX \n20:35:21 04/21/2013 - CASTRO C\nMAKING MOANING NOISES \n\n13FL-0054\n04/21/2013 20:35

 */

public class COLaPlataCountyParserTest extends BaseParserTest {
  
  public COLaPlataCountyParserTest() {
    setParser(new COLaPlataCountyParser(), "LA PLATA COUNTY", "CO");
  }
  
  @Test
  public void testDurangoFireRescue() {

    doTest("T1",
        "(Message from HipLink) DFRA\n" +
        "D5   \n" +
        "F-SMOKE OUTSD  \n" +
        "101 CR 248 ; 1/4 OF M NE OF THIS ADDRESS\n" +
        "DF5\n" +
        "SPARKS FROM ELECTRICAL POLE ; POSS FLAMES ; WENT OUT AND THEN CAME BACK \n\n" +
        "13DF-1876\n" +
        "06/20/2013 22:58",

        "SRC:DFRA",
        "UNIT:DF5",
        "CALL:F-SMOKE OUTSD",
        "ADDR:101 CR 248",
        "MADDR:101 COUNTY ROAD 248",
        "PLACE:1/4 OF M NE OF THIS ADDRESS",
        "ID:13DF-1876",
        "DATE:06/20/2013",
        "TIME:22:58",
        "INFO:SPARKS FROM ELECTRICAL POLE ; POSS FLAMES ; WENT OUT AND THEN CAME BACK");

    doTest("T2",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "E-SICK         \n" +
        "296 E PARK AV\n" +
        "DF2 M2\n" +
        "FEM CONC/BREA CANT SEE ANYTHING; UNK PROBLEM\n\n" +
        "13DF-1875\n" +
        "06/20/2013 22:27",

        "SRC:DFRA",
        "UNIT:DF2 M2",
        "CALL:E-SICK",
        "ADDR:296 E PARK AV",
        "MADDR:296 E PARK AVE",
        "ID:13DF-1875",
        "DATE:06/20/2013",
        "TIME:22:27",
        "INFO:FEM CONC/BREA CANT SEE ANYTHING; UNK PROBLEM");

    doTest("T3",
        "(Message from HipLink) DFRA\n" +
        "D3   \n" +
        "E-CHEST PAIN   \n" +
        "1700 CR 203; APT 203\n" +
        "DF3 M1\n" +
        "40 YOM ; CON/DIFF ; CHEST PAIN \n" +
        "17:28:29 06/20/2013 - Gonzales Y V\n" +
        "DIZZY ; LEFT ARM IS NUMB \n\n" +
        "13DF-1874\n" +
        "06/20/2013 17:28",

        "SRC:DFRA",
        "UNIT:DF3 M1",
        "CALL:E-CHEST PAIN",
        "ADDR:1700 CR 203",
        "MADDR:1700 COUNTY ROAD 203",
        "APT:203",
        "ID:13DF-1874",
        "DATE:06/20/2013",
        "TIME:17:28:29",
        "INFO:40 YOM ; CON/DIFF ; CHEST PAIN / - Gonzales Y V / DIZZY ; LEFT ARM IS NUMB");

    doTest("T4",
        "(Message from HipLink) DFRA\n" +
        "D6   \n" +
        "E-CHEST PAIN   \n" +
        "55 ANIMOSA CIR; 32230 HWY 550 N\n" +
        "DF6 M3\n" +
        "89YOF ; CON/DIFF BREA ; CHEST PAIN \n\n" +
        "13DF-1873\n" +
        "06/20/2013 16:43",

        "SRC:DFRA",
        "UNIT:DF6 M3",
        "CALL:E-CHEST PAIN",
        "ADDR:55 ANIMOSA CIR",
        "X:32230 HWY 550 N",
        "ID:13DF-1873",
        "DATE:06/20/2013",
        "TIME:16:43",
        "INFO:89YOF ; CON/DIFF BREA ; CHEST PAIN");

    doTest("T5",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "E-TRAUMA       \n" +
        "2416 W 2ND AV\n" +
        "DF2 M2\n" +
        "25 YOF ; CONS/BREA ; SMASHED HEAD ; UNABLE TO EXPLAIN FURTHER ; SEEMS CONFUSED \n\n" +
        "13DF-1872\n" +
        "06/20/2013 16:41",

        "SRC:DFRA",
        "UNIT:DF2 M2",
        "CALL:E-TRAUMA",
        "ADDR:2416 W 2ND AV",
        "MADDR:2416 W 2ND AVE",
        "ID:13DF-1872",
        "DATE:06/20/2013",
        "TIME:16:41",
        "INFO:25 YOF ; CONS/BREA ; SMASHED HEAD ; UNABLE TO EXPLAIN FURTHER ; SEEMS CONFUSED");

    doTest("T6",
        "(Message from HipLink) DFRA\n" +
        "D7   \n" +
        "E-SEIZURE/CONV \n" +
        "1 MERCADO ST; THREE SPRINGS; STE 100\n" +
        "DF7 M1\n" +
        "FEM ; SEIZING ; RP NOT WITH THE PATIENT IN THE LOBBY\n\n" +
        "13DF-1871\n" +
        "06/20/2013 15:39",

        "SRC:DFRA",
        "UNIT:DF7 M1",
        "CALL:E-SEIZURE/CONV",
        "ADDR:1 MERCADO ST",
        "APT:100",
        "PLACE:THREE SPRINGS",
        "ID:13DF-1871",
        "DATE:06/20/2013",
        "TIME:15:39",
        "INFO:FEM ; SEIZING ; RP NOT WITH THE PATIENT IN THE LOBBY");

    doTest("T7",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "E-FALLS        \n" +
        "713 MAIN AV\n" +
        "DF2 M2\n" +
        "MALE SUBJ ; CON/BREA ; FELL HIT HIS HEAD\n" +
        "15:31:26 06/20/2013 - Gonzales Y V   \n" +
        "  INTOX SUBJ\n\n" +
        "13DF-1870\n" +
        "06/20/2013 15:31",

        "SRC:DFRA",
        "UNIT:DF2 M2",
        "CALL:E-FALLS",
        "ADDR:713 MAIN AV",
        "MADDR:713 MAIN AVE",
        "ID:13DF-1870",
        "DATE:06/20/2013",
        "TIME:15:31:26",
        "INFO:MALE SUBJ ; CON/BREA ; FELL HIT HIS HEAD / - Gonzales Y V / INTOX SUBJ");

    doTest("T8",
        "(Message from HipLink) DFRA\n" +
        "D3   \n" +
        "E-TRAFF ACC    \n" +
        "FLORIDA RD / CR 250\n" +
        "DF3 M3\n" +
        "2 MVA ACCIDENDT HEAD ON ; UNK INJ ; VAN VS SM SED ; ONE DRIVER NOT GETTING OUT\n" +
        "OF VEH\n" +
        "14:08:20 06/20/2013 - Gonzales Y V\n" +
        "ONE VEH LEAKING FLUID \n\n" +
        "13DF-1869\n" +
        "06/20/2013 14:08",

        "SRC:DFRA",
        "UNIT:DF3 M3",
        "CALL:E-TRAFF ACC",
        "ADDR:FLORIDA RD & CR 250",
        "MADDR:FLORIDA RD & COUNTY ROAD 250",
        "ID:13DF-1869",
        "DATE:06/20/2013",
        "TIME:14:08:20",
        "INFO:2 MVA ACCIDENDT HEAD ON ; UNK INJ ; VAN VS SM SED ; ONE DRIVER NOT GETTING OUT / OF VEH / - Gonzales Y V / ONE VEH LEAKING FLUID");

    doTest("T9",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "F-CO DETECTOR  \n" +
        "20979 HWY 160 W ; RM 201 FOUR WINDS MOTEL\n" +
        "DF2\n" +
        "CO DETECTOR GOING OFF ; RM EVACUATED \n\n" +
        "13DF-1868\n" +
        "06/20/2013 13:26",

        "SRC:DFRA",
        "UNIT:DF2",
        "CALL:F-CO DETECTOR",
        "ADDR:20979 HWY 160 W",
        "APT:201",
        "PLACE:FOUR WINDS MOTEL",
        "ID:13DF-1868",
        "DATE:06/20/2013",
        "TIME:13:26",
        "INFO:CO DETECTOR GOING OFF ; RM EVACUATED");

    doTest("T10",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "F-ALARM        \n" +
        "1480 E 8TH AV\n" +
        "DF2\n" +
        "GENERAL FIRE ZONE 196, ADVD ALARM 8665995051, 0835 / 0837 WILL CONTACT\n\n" +
        "13DF-1867\n" +
        "TALON LN & E CAMPUS CT\n" +
        "06/20/2013 08:38",

        "SRC:DFRA",
        "UNIT:DF2",
        "CALL:F-ALARM",
        "ADDR:1480 E 8TH AV",
        "MADDR:1480 E 8TH AVE",
        "ID:13DF-1867",
        "DATE:06/20/2013",
        "TIME:08:38",
        "INFO:GENERAL FIRE ZONE 196, ADVD ALARM 8665995051, 0835 / 0837 WILL CONTACT",
        "X:TALON LN & E CAMPUS CT");

    doTest("T11",
        "(Message from HipLink) DFRA\n" +
        "D3   \n" +
        "E-SICK         \n" +
        "2701 MAIN AV; WALGREENS DRUG STORE\n" +
        "DF3 M3\n" +
        "43YOF ; CONC/BREATH ; HAVING ANXIETY ATTACK ; \n" +
        "05:07:19 06/20/2013 - KIMBALL K A\n" +
        "F SAID M WAS BEING ABUSIVE ; M NOT ON SCENE\n" +
        "05:07:24 06/20/2013 - KIMBALL K A\n" +
        "F\n" +
        "13DF-1866\n" +
        "06/20/2013 05:07",

        "SRC:DFRA",
        "UNIT:DF3 M3",
        "CALL:E-SICK",
        "ADDR:2701 MAIN AV",
        "MADDR:2701 MAIN AVE",
        "PLACE:WALGREENS DRUG STORE",
        "ID:13DF-1866",
        "DATE:06/20/2013",
        "TIME:05:07:19",
        "INFO:43YOF ; CONC/BREATH ; HAVING ANXIETY ATTACK ; / - KIMBALL K A / F SAID M WAS BEING ABUSIVE ; M NOT ON SCENE / - KIMBALL K A / F");

    doTest("T12",
        "(Message from HipLink) DFRA\n" +
        "D9   \n" +
        "F-OTHER        \n" +
        "17800 HWY 160 W ; LAST TRAILER\n" +
        "DF9\n" +
        "SMELL OF BURNING ; NO SMOKE ; NO FLAMES\n\n" +
        "13DF-1865\n" +
        "06/20/2013 01:02",

        "SRC:DFRA",
        "UNIT:DF9",
        "CALL:F-OTHER",
        "ADDR:17800 HWY 160 W",
        "PLACE:LAST TRAILER",
        "ID:13DF-1865",
        "DATE:06/20/2013",
        "TIME:01:02",
        "INFO:SMELL OF BURNING ; NO SMOKE ; NO FLAMES");

    doTest("T13",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "E-ALLERGY/STING\n" +
        "1050 AVENIDA DEL SOL; HILLTOP HOUSE\n" +
        "DF2 M1\n" +
        "53YOM ; CONC/DIFF BREATH ; ALLERGIC REACTION ; VOMITING ; DRY MOUTH ; DIAHREA ;\n" +
        "PALE MED IS COLCRYS; RP AT EXT 10\n\n" +
        "13DF-1864\n" +
        "ELLA VITA CT\n" +
        "06/19/2013 21:45",

        "SRC:DFRA",
        "UNIT:DF2 M1",
        "CALL:E-ALLERGY/STING",
        "ADDR:1050 AVENIDA DEL SOL",
        "PLACE:HILLTOP HOUSE",
        "ID:13DF-1864",
        "DATE:06/19/2013",
        "TIME:21:45",
        "INFO:53YOM ; CONC/DIFF BREATH ; ALLERGIC REACTION ; VOMITING ; DRY MOUTH ; DIAHREA ; / PALE MED IS COLCRYS; RP AT EXT 10",
        "X:ELLA VITA CT");

    doTest("T14",
        "(Message from HipLink) DFRA\n" +
        "D3   \n" +
        "E-TRAFF ACC    \n" +
        "FLORIDA RD / CR 250\n" +
        "DF3 M2\n" +
        "FEM CONC/BREA HIT STEERING WHEEL; PD ON SCENE\n\n" +
        "13DF-1863\n" +
        "06/19/2013 21:30",

        "SRC:DFRA",
        "UNIT:DF3 M2",
        "CALL:E-TRAFF ACC",
        "ADDR:FLORIDA RD & CR 250",
        "MADDR:FLORIDA RD & COUNTY ROAD 250",
        "ID:13DF-1863",
        "DATE:06/19/2013",
        "TIME:21:30",
        "INFO:FEM CONC/BREA HIT STEERING WHEEL; PD ON SCENE");

    doTest("T15",
        "(Message from HipLink) DFRA\n" +
        "D6   \n" +
        "E-HEMOR/LAC    \n" +
        "32222 HWY 550 N; 14\n" +
        "DF6 M3\n" +
        "59YOM ; CONC/BREATH ; 4 INCH GASH ON HEAD\n\n" +
        "13DF-1862\n" +
        "06/19/2013 21:15",

        "SRC:DFRA",
        "UNIT:DF6 M3",
        "CALL:E-HEMOR/LAC",
        "ADDR:32222 HWY 550 N",
        "APT:14",
        "ID:13DF-1862",
        "DATE:06/19/2013",
        "TIME:21:15",
        "INFO:59YOM ; CONC/BREATH ; 4 INCH GASH ON HEAD");

    doTest("T16",
        "(Message from HipLink) DFRA\nD2   \nE-TRAUMA       \n600 E 1ST ST\nDF2 M2\nFEM CONC/BREA TOE INJURY\n\n13DF-1861\n06/19/2013 20:40",
        "SRC:DFRA",
        "UNIT:DF2 M2",
        "CALL:E-TRAUMA",
        "ADDR:600 E 1ST ST",
        "ID:13DF-1861",
        "DATE:06/19/2013",
        "TIME:20:40",
        "INFO:FEM CONC/BREA TOE INJURY");

    doTest("T17",
        "(Message from HipLink) DFRA\n" +
        "D3   \n" +
        "E-TRAUMA       \n" +
        "3141 MAIN AV; SPANISH TRAILS FRONT OFFICE\n" +
        "DF3 M3\n" +
        "58YOM CONC/BREA HIP OUT OF SOCKET\n\n" +
        "13DF-1860\n" +
        "E 31ST ST, W 31ST ST & E 32ND ST, W 32ND ST\n" +
        "06/19/2013 18:35",

        "SRC:DFRA",
        "UNIT:DF3 M3",
        "CALL:E-TRAUMA",
        "ADDR:3141 MAIN AV",
        "MADDR:3141 MAIN AVE",
        "PLACE:SPANISH TRAILS FRONT OFFICE",
        "ID:13DF-1860",
        "DATE:06/19/2013",
        "TIME:18:35",
        "INFO:58YOM CONC/BREA HIP OUT OF SOCKET / E 31ST ST, W 31ST ST & E 32ND ST, W 32ND ST");

    doTest("T18",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "E-SICK         \n" +
        "633 ARROYO DR ; 102\n" +
        "DF2 M2\n" +
        "29YOF ; CONC/BREATH ; GOING THROUGH ALCOHOL WITHDRAWL \n" +
        "18:13:32 06/19/2013 - KIMBALL K A\n" +
        "PT IS STEPHANIE \n\n" +
        "13DF-1859\n" +
        "06/19/2013 18:13",

        "SRC:DFRA",
        "UNIT:DF2 M2",
        "CALL:E-SICK",
        "ADDR:633 ARROYO DR",
        "APT:102",
        "ID:13DF-1859",
        "DATE:06/19/2013",
        "TIME:18:13:32",
        "INFO:29YOF ; CONC/BREATH ; GOING THROUGH ALCOHOL WITHDRAWL / - KIMBALL K A / PT IS STEPHANIE");

    doTest("T19",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "E-MAN DOWN UNK \n" +
        "SANTA RITA DR / S CAMINO DEL RIO\n" +
        "DF2 M2\n" +
        "ELDERLY MALE SUBJ ON BIKE; SLUMPED OVER THE CONCRETE BARRIER; UNK FURTHER\n\n" +
        "13DF-1858\n" +
        "Intersection of: SANTA RITA DR & S CAMINO DEL RIO\n" +
        "06/19/2013 17:49",

        "SRC:DFRA",
        "UNIT:DF2 M2",
        "CALL:E-MAN DOWN UNK",
        "ADDR:SANTA RITA DR & S CAMINO DEL RIO",
        "ID:13DF-1858",
        "DATE:06/19/2013",
        "TIME:17:49",
        "INFO:ELDERLY MALE SUBJ ON BIKE; SLUMPED OVER THE CONCRETE BARRIER; UNK FURTHER / Intersection of: SANTA RITA DR & S CAMINO DEL RIO");

    doTest("T20",
        "(Message from HipLink) DFRA\nD1   \nF-MUTUAL AID   \nAID KIRTLAND NM\nDF1\n\n13DF-1857\n06/19/2013 16:52",
        "SRC:DFRA",
        "UNIT:DF1",
        "CALL:F-MUTUAL AID",
        "ADDR:AID KIRTLAND NM",
        "ID:13DF-1857",
        "DATE:06/19/2013",
        "TIME:16:52");

    doTest("T21",
        "(Message from HipLink) DFRA\n" +
        "D14  \n" +
        "E-SEIZURE/CONV \n" +
        "238 N TAMARRON DR; GLACIER CLUB @ TAMARRON; 2ND HOLE\n" +
        "DF14 M15\n" +
        "72YOF UNCONC/BREATH ;SEIZURE \n\n" +
        "13DF-1855\n" +
        "06/19/2013 13:02",

        "SRC:DFRA",
        "UNIT:DF14 M15",
        "CALL:E-SEIZURE/CONV",
        "ADDR:238 N TAMARRON DR",
        "PLACE:GLACIER CLUB @ TAMARRON - 2ND HOLE",
        "ID:13DF-1855",
        "DATE:06/19/2013",
        "TIME:13:02",
        "INFO:72YOF UNCONC/BREATH ;SEIZURE");

    doTest("T22",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "E-MAN DOWN UNK \n" +
        "1100 AVENIDA DEL SOL\n" +
        "DF2 M2\n" +
        "MALE UNK CONC/UNK BREATH ;RP ADVD HE FOUND A MAN IN A TENT WITH HIS FEET\n" +
        "STICKING OUT ; WAS ON A TRAIL\n" +
        "NEAR THE NEW HOMES THAT ARE BEING BUILT BY MANNA ;RP REF AND DISCONNECT\n" +
        "13DF-1854\n" +
        "06/19/2013 12:43",

        "SRC:DFRA",
        "UNIT:DF2 M2",
        "CALL:E-MAN DOWN UNK",
        "ADDR:1100 AVENIDA DEL SOL",
        "ID:13DF-1854",
        "DATE:06/19/2013",
        "TIME:12:43",
        "INFO:MALE UNK CONC/UNK BREATH ;RP ADVD HE FOUND A MAN IN A TENT WITH HIS FEET / STICKING OUT ; WAS ON A TRAIL / NEAR THE NEW HOMES THAT ARE BEING BUILT BY MANNA ;RP REF AND DISCONNECT");

    doTest("T23",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "E-TRAFF ACC    \n" +
        "300 E 7TH ST\n" +
        "DF2 M3\n" +
        "60 YOF ; CON/BREA ; NECK INJ FROM MVA\n\n" +
        "13DF-1853\n" +
        "06/19/2013 11:59",

        "SRC:DFRA",
        "UNIT:DF2 M3",
        "CALL:E-TRAFF ACC",
        "ADDR:300 E 7TH ST",
        "ID:13DF-1853",
        "DATE:06/19/2013",
        "TIME:11:59",
        "INFO:60 YOF ; CON/BREA ; NECK INJ FROM MVA");

    doTest("T24",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "E-SICK         \n" +
        "633 ARROYO DR ; 102\n" +
        "DF2A M3\n" +
        "29YOF ;CONS/BREA ; DIFF TALKING BETWEEN BREATHS; FEELING SICK ; SOUND\n" +
        "DISORIENTED \n\n" +
        "13DF-1851\n" +
        "06/19/2013 10:52",

        "SRC:DFRA",
        "UNIT:D2",
        "CALL:E-SICK",
        "ADDR:633 ARROYO DR",
        "APT:102",
        "ID:13DF-1851",
        "DATE:06/19/2013",
        "TIME:10:52",
        "INFO:DF2A M3 / 29YOF ;CONS/BREA ; DIFF TALKING BETWEEN BREATHS; FEELING SICK ; SOUND / DISORIENTED");

    doTest("T25",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "E-OD/POISON    \n" +
        "311 W COLLEGE DR; ALBERTSONS\n" +
        "DF2 M2\n" +
        "MALE ; UNCONS/BREA ; INTOX ; PD ON SCENE ; BEHIND ALBERTSONS ON STAIRS TO RIVER\n" +
        "TRAIL\n\n" +
        "13DF-1850\n" +
        "06/19/2013 10:23",

        "SRC:DFRA",
        "UNIT:DF2 M2",
        "CALL:E-OD/POISON",
        "ADDR:311 W COLLEGE DR",
        "PLACE:ALBERTSONS",
        "ID:13DF-1850",
        "DATE:06/19/2013",
        "TIME:10:23",
        "INFO:MALE ; UNCONS/BREA ; INTOX ; PD ON SCENE ; BEHIND ALBERTSONS ON STAIRS TO RIVER / TRAIL");

    doTest("T26",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "E-BREATHING    \n" +
        "633 ARROYO DR; # 102\n" +
        "DF2 M2\n" +
        "29 YOF CONC/DIFF BREA \n" +
        "03:41:28 06/19/2013 - CASTRO C\n" +
        "SUBJ IS INTOX \n\n" +
        "13DF-1848\n" +
        "06/19/2013 03:41",

        "SRC:DFRA",
        "UNIT:DF2 M2",
        "CALL:E-BREATHING",
        "ADDR:633 ARROYO DR",
        "PLACE:# 102",
        "ID:13DF-1848",
        "DATE:06/19/2013",
        "TIME:03:41:28",
        "INFO:29 YOF CONC/DIFF BREA / - CASTRO C / SUBJ IS INTOX");

    doTest("T27",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "E-FALLS        \n" +
        "633 ARROYO DR\n" +
        "DF2 M2\n" +
        "29 YOF ; INTOX ; FELL FROM STANDING KNEE PAIN \n\n" +
        "13DF-1847\n" +
        "06/19/2013 03:01",

        "SRC:DFRA",
        "UNIT:DF2 M2",
        "CALL:E-FALLS",
        "ADDR:633 ARROYO DR",
        "ID:13DF-1847",
        "DATE:06/19/2013",
        "TIME:03:01",
        "INFO:29 YOF ; INTOX ; FELL FROM STANDING KNEE PAIN");

    doTest("T28",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "E-FALLS        \n" +
        "600 MAIN AV\n" +
        "DF2 M2\n" +
        "35YOM; UNCON/BRE FELL, INTOX \n\n" +
        "13DF-1846\n" +
        "W COLLEGE DR, E COLLEGE DR & E 7TH ST, W 7TH ST\n" +
        "06/18/2013 23:55",

        "SRC:DFRA",
        "UNIT:DF2 M2",
        "CALL:E-FALLS",
        "ADDR:600 MAIN AV",
        "MADDR:600 MAIN AVE",
        "ID:13DF-1846",
        "DATE:06/18/2013",
        "TIME:23:55",
        "INFO:35YOM; UNCON/BRE FELL, INTOX / W COLLEGE DR, E COLLEGE DR & E 7TH ST, W 7TH ST");

    doTest("T29",
        "(Message from HipLink) DFRA\n" +
        "D2   \n" +
        "F-BRUSH        \n" +
        "21800 HWY 160 W  ; ABOVE DOG PARK\n" +
        "DF2\n" +
        "FLAMES VISIBLE ON SMELTER ; 1/3 UP THE HILL ABOVE DOG PARK\n\n" +
        "13DF-1844\n" +
        "06/18/2013 21:04",

        "SRC:DFRA",
        "UNIT:DF2",
        "CALL:F-BRUSH",
        "ADDR:21800 HWY 160 W",
        "PLACE:ABOVE DOG PARK",
        "ID:13DF-1844",
        "DATE:06/18/2013",
        "TIME:21:04",
        "INFO:FLAMES VISIBLE ON SMELTER ; 1/3 UP THE HILL ABOVE DOG PARK");

    doTest("T30",
        "(Message from HipLink) DFRA\n" +
        "D1   \n" +
        "E-ABDOM PAIN   \n" +
        "742 TURNER DR\n" +
        "DF1 M1\n" +
        "20 YOF ; CON/BRE ; STOMACH PAIN\n" +
        "18:07:19 06/18/2013 - Meyers S D     \n" +
        "COME TO SALLY PORT ;\n\n" +
        "13DF-1843\n" +
        "BODO DR\n" +
        "06/18/2013 18:07",

        "SRC:DFRA",
        "UNIT:DF1 M1",
        "CALL:E-ABDOM PAIN",
        "ADDR:742 TURNER DR",
        "ID:13DF-1843",
        "DATE:06/18/2013",
        "TIME:18:07:19",
        "INFO:20 YOF ; CON/BRE ; STOMACH PAIN / - Meyers S D / COME TO SALLY PORT ;",
        "X:BODO DR");

  }
  
  @Test
  public void testFortLewisMesaFire() {

    doTest("T1",
        "(Message from HipLink) FLM \n" +
        "FLM1 \n" +
        "E-STAB/GUNSHOT \n" +
        "2808 CR 129\n" +
        "FLM1\n" +
        "40YOF ; CONC/BREA ; JUST STABBED BY MALE SUBJ \n" +
        "16:43:21 06/18/2013 - Harr K L\n" +
        "MALE STILL ON SCNE \n" +
        "16:43:37 06/18/2013 - Harr K L\n" +
        "MALE IS FEM'S HUSBAND \n\n" +
        "13FL-0082\n" +
        "06/18/2013 16:43",

        "SRC:FLM",
        "UNIT:FLM1",
        "CALL:E-STAB/GUNSHOT",
        "ADDR:2808 CR 129",
        "MADDR:2808 COUNTY ROAD 129",
        "ID:13FL-0082",
        "DATE:06/18/2013",
        "TIME:16:43:21",
        "INFO:40YOF ; CONC/BREA ; JUST STABBED BY MALE SUBJ / - Harr K L / MALE STILL ON SCNE / - Harr K L / MALE IS FEM'S HUSBAND");

    doTest("T2",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "F-SMOKE OUTSD  \n" +
        "5038 CR 124; 10600BLK HWY 160 W\n" +
        "FLM2\n" +
        "SMELL OF SMOKE IN CANYON ; NO VISUAL \n\n" +
        "13FL-0081\n" +
        "06/18/2013 07:30",

        "SRC:FLM",
        "UNIT:FLM2",
        "CALL:F-SMOKE OUTSD",
        "ADDR:5038 CR 124",
        "MADDR:5038 COUNTY ROAD 124",
        "X:10600BLK HWY 160 W",
        "ID:13FL-0081",
        "DATE:06/18/2013",
        "TIME:07:30",
        "INFO:SMELL OF SMOKE IN CANYON ; NO VISUAL");

    doTest("T3",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "E-SUICIDE/CIT  \n" +
        "21351 HWY 140; 4\n" +
        "FLM2 M1\n" +
        "FEM BARRICARED IN ROOM W KNIFE; SO REQ MEDS STAGE\n\n" +
        "13FL-0080\n" +
        "06/16/2013 20:14",

        "SRC:FLM",
        "UNIT:FLM2 M1",
        "CALL:E-SUICIDE/CIT",
        "ADDR:21351 HWY 140",
        "APT:4",
        "ID:13FL-0080",
        "DATE:06/16/2013",
        "TIME:20:14",
        "INFO:FEM BARRICARED IN ROOM W KNIFE; SO REQ MEDS STAGE");

    doTest("T4",
        "(Message from HipLink) FLM \n" +
        "FLM1 \n" +
        "F-SMOKE OUTSD  \n" +
        "100 CR 113\n" +
        "FLM1\n" +
        "LARGE AMOUNT OF BLK SMOKE IN AREA ; JUST STARTED ; UNK WHAT'S BURNING \n\n" +
        "13FL-0079\n" +
        "06/16/2013 14:42",

        "SRC:FLM",
        "UNIT:FLM1",
        "CALL:F-SMOKE OUTSD",
        "ADDR:100 CR 113",
        "MADDR:100 COUNTY ROAD 113",
        "ID:13FL-0079",
        "DATE:06/16/2013",
        "TIME:14:42",
        "INFO:LARGE AMOUNT OF BLK SMOKE IN AREA ; JUST STARTED ; UNK WHAT'S BURNING");

    doTest("T5",
        "(Message from HipLink) FLM \nFLM1 \nF-BRUSH        \nCR 110 / CR 100\nFLM1\n2 LIGHTENING STRIKES\n\n13FL-0078\n06/15/2013 17:31",
        "SRC:FLM",
        "UNIT:FLM1",
        "CALL:F-BRUSH",
        "ADDR:CR 110 & CR 100",
        "MADDR:COUNTY ROAD 110 & COUNTY ROAD 100",
        "ID:13FL-0078",
        "DATE:06/15/2013",
        "TIME:17:31",
        "INFO:2 LIGHTENING STRIKES");

    doTest("T6",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "F-VEHICLE      \n" +
        "9000 HWY 160 W\n" +
        "FLM2\n" +
        "VEH ON FIRE ; FULLY ENGULFED ; NO ONE IN THE VEH \n\n" +
        "13FL-0077\n" +
        "06/14/2013 21:52",

        "SRC:FLM",
        "UNIT:FLM2",
        "CALL:F-VEHICLE",
        "ADDR:9000 HWY 160 W",
        "ID:13FL-0077",
        "DATE:06/14/2013",
        "TIME:21:52",
        "INFO:VEH ON FIRE ; FULLY ENGULFED ; NO ONE IN THE VEH");

    doTest("T7",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "F-SMOKE OUTSD  \n" +
        "5000 HWY 160 W ; IN THE AREA OF\n" +
        "FLM2\n" +
        "SMOKE VISIBLE ; UNK FURTHER \n\n" +
        "13FL-0075\n" +
        "06/13/2013 15:39",

        "SRC:FLM",
        "UNIT:FLM2",
        "CALL:F-SMOKE OUTSD",
        "ADDR:5000 HWY 160 W",
        "PLACE:IN THE AREA OF",
        "ID:13FL-0075",
        "DATE:06/13/2013",
        "TIME:15:39",
        "INFO:SMOKE VISIBLE ; UNK FURTHER");

    doTest("T8",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "E-TRAFF ACC    \n" +
        "8000 HWY 160 W; MM 70\n" +
        "FLM2 M1\n" +
        "VEH VS DEER ; RP ADV POSS INJUR ONE OF THE DEER CAME THROUGH THE WINDSHIELD ;\n" +
        "DRIVER IS CONC / BREA OUT OF VEH POSS BROKEN HAND  \n\n" +
        "13FL-0074\n" +
        "06/10/2013 21:21",

        "SRC:FLM",
        "UNIT:FLM2 M1",
        "CALL:E-TRAFF ACC",
        "ADDR:8000 HWY 160 W",
        "PLACE:MM 70",
        "ID:13FL-0074",
        "DATE:06/10/2013",
        "TIME:21:21",
        "INFO:VEH VS DEER ; RP ADV POSS INJUR ONE OF THE DEER CAME THROUGH THE WINDSHIELD ; / DRIVER IS CONC / BREA OUT OF VEH POSS BROKEN HAND");

    doTest("T9",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "E-TRAFF ACC    \n" +
        "16000 HWY 140\n" +
        "FLM2 M1\n" +
        "2MVA ; REAR END ACCIDET ; 1 FEM CON/BREA BACK PAIN ; MALE CON/BREA BACK PAIN \n" +
        "18:49:57 06/08/2013 - Gonzales Y V   \n" +
        "  NOT BLOCKING TRAFFIC\n\n" +
        "13FL-0073\n" +
        "06/08/2013 18:50",

        "SRC:FLM",
        "UNIT:FLM2 M1",
        "CALL:E-TRAFF ACC",
        "ADDR:16000 HWY 140",
        "ID:13FL-0073",
        "DATE:06/08/2013",
        "TIME:18:49:57",
        "INFO:2MVA ; REAR END ACCIDET ; 1 FEM CON/BREA BACK PAIN ; MALE CON/BREA BACK PAIN / - Gonzales Y V / NOT BLOCKING TRAFFIC");

    doTest("T10",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "E-TRAFF ACC    \n" +
        "9848 HWY 160 W; HESPERUS SKI AREA\n" +
        "FLM2 M1\n" +
        "1MVA ; ROLLOVER \n\n" +
        "13FL-0072\n" +
        "06/08/2013 14:29",

        "SRC:FLM",
        "UNIT:FLM2 M1",
        "CALL:E-TRAFF ACC",
        "ADDR:9848 HWY 160 W",
        "PLACE:HESPERUS SKI AREA",
        "ID:13FL-0072",
        "DATE:06/08/2013",
        "TIME:14:29",
        "INFO:1MVA ; ROLLOVER");

    doTest("T11",
        "(Message from HipLink) FLM \nFLM1 \nE-SUICIDE/CIT  \n550 ALKALI GULCH RD; 2215 CR 119\nEMS1\n\n13DF-1688\n06/08/2013 00:26",
        "SRC:FLM",
        "UNIT:EMS1",
        "CALL:E-SUICIDE/CIT",
        "ADDR:550 ALKALI GULCH RD",
        "X:2215 CR 119",
        "ID:13DF-1688",
        "DATE:06/08/2013",
        "TIME:00:26");

    doTest("T12",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "E-TRAFF ACC    \n" +
        "CR 120 / CR 123\n" +
        "FLM2\n" +
        "POSS ROLL OVER ; NO ONE AROUND ; AIR BAGS DEPOLYED BLOOD ON THE SEAT AND AIR BAG\n" +
        "CO/809HDC \n" +
        "01:42:56 06/02/2013 - CASTRO C\n" +
        "LOTS OF FRONT END DAMAGE POSS HIT OAK TREES\n" +
        "01:43:33 06/02\n" +
        "13FL-0070\n" +
        "06/02/2013 01:44",

        "SRC:FLM",
        "UNIT:FLM2",
        "CALL:E-TRAFF ACC",
        "ADDR:CR 120 & CR 123",
        "MADDR:COUNTY ROAD 120 & COUNTY ROAD 123",
        "ID:13FL-0070",
        "DATE:06/02/2013",
        "TIME:01:42:56",
        "INFO:POSS ROLL OVER ; NO ONE AROUND ; AIR BAGS DEPOLYED BLOOD ON THE SEAT AND AIR BAG / CO/809HDC / - CASTRO C / LOTS OF FRONT END DAMAGE POSS HIT OAK TREES / 01:43:33 06/02");

    doTest("T13",
        "(Message from HipLink) FLM \n" +
        "FLM1 \n" +
        "F-STRUCTURE    \n" +
        "CR 128 / CR 126 ; IN B/T CR 129 AND 126 ON CR 128\n" +
        "FLM1 DFMA\n" +
        "RESI ON FIRE \n\n" +
        "13FL-0069\n" +
        "06/01/2013 01:41",

        "SRC:FLM",
        "UNIT:FLM1 DFMA",
        "CALL:F-STRUCTURE",
        "ADDR:CR 128 & CR 126",
        "MADDR:COUNTY ROAD 128 & COUNTY ROAD 126",
        "PLACE:IN B/T CR 129 AND 126 ON CR 128",
        "ID:13FL-0069",
        "DATE:06/01/2013",
        "TIME:01:41",
        "INFO:RESI ON FIRE");

    doTest("T14",
        "(Message from HipLink) FLM \n" +
        "FLM1 \n" +
        "F-BRUSH        \n" +
        "0 HWY 140\n" +
        "FLM1\n" +
        "BRUSH FIRE, UNK WHICH SIDE OF STATE LINE, BURNING ALONG SIDE OF HWY\n\n" +
        "13FL-0068\n" +
        "05/31/2013 12:34",

        "SRC:FLM",
        "UNIT:FLM1",
        "CALL:F-BRUSH",
        "ADDR:HWY 140",
        "ID:13FL-0068",
        "DATE:05/31/2013",
        "TIME:12:34",
        "INFO:BRUSH FIRE, UNK WHICH SIDE OF STATE LINE, BURNING ALONG SIDE OF HWY");

    doTest("T15",
        "(Message from HipLink) FLM \nFLM1 \nE-FALLS        \n1560 CR 133\nFLM1\nMALE PT ; CONS/BREA  ; FELL \n\n13FL-0067\n05/30/2013 15:35",
        "SRC:FLM",
        "UNIT:FLM1",
        "CALL:E-FALLS",
        "ADDR:1560 CR 133",
        "MADDR:1560 COUNTY ROAD 133",
        "ID:13FL-0067",
        "DATE:05/30/2013",
        "TIME:15:35",
        "INFO:MALE PT ; CONS/BREA  ; FELL");

    doTest("T16",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "E-SEIZURE/CONV \n" +
        "11951 CR 120\n" +
        "FLM2 M1\n" +
        "67YOF ; CONC/BREA ; WAS SEIZING\n\n" +
        "13FL-0066\n" +
        "05/27/2013 14:31",

        "SRC:FLM",
        "UNIT:FLM2 M1",
        "CALL:E-SEIZURE/CONV",
        "ADDR:11951 CR 120",
        "MADDR:11951 COUNTY ROAD 120",
        "ID:13FL-0066",
        "DATE:05/27/2013",
        "TIME:14:31",
        "INFO:67YOF ; CONC/BREA ; WAS SEIZING");

    doTest("T17",
        "(Message from HipLink) FLM \n" +
        "FLM1 \n" +
        "F-SMOKE OUTSD  \n" +
        "CR 128 / CR 129\n" +
        "FLM1\n" +
        "BLK SMOKE SHOWING IN AREA ; CONT BURN AT 1240 CR 128 BUT UTC RP  \n\n" +
        "13FL-0065\n" +
        "05/27/2013 09:51",

        "SRC:FLM",
        "UNIT:FLM1",
        "CALL:F-SMOKE OUTSD",
        "ADDR:CR 128 & CR 129",
        "MADDR:COUNTY ROAD 128 & COUNTY ROAD 129",
        "ID:13FL-0065",
        "DATE:05/27/2013",
        "TIME:09:51",
        "INFO:BLK SMOKE SHOWING IN AREA ; CONT BURN AT 1240 CR 128 BUT UTC RP");

    doTest("T18",
        "(Message from HipLink) FLM \nFLM2 \nF-MUTUAL AID   \n615 CR 120\nDFMA\n\n13DF-1475\n05/23/2013 12:04",
        "SRC:FLM",
        "UNIT:FLM2",
        "CALL:F-MUTUAL AID",
        "ADDR:615 CR 120",
        "MADDR:615 COUNTY ROAD 120",
        "ID:13DF-1475",
        "DATE:05/23/2013",
        "TIME:12:04",
        "INFO:DFMA");

    doTest("T19",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "F-MUTUAL AID   \n" +
        "615 CR 120\n" +
        "DFMA\n" +
        "BRUSH TRUCK REQUEST FOR TREE ON FIRE\n\n" +
        "13DF-1474\n" +
        "05/23/2013 11:42",

        "SRC:FLM",
        "UNIT:FLM2",
        "CALL:F-MUTUAL AID",
        "ADDR:615 CR 120",
        "MADDR:615 COUNTY ROAD 120",
        "ID:13DF-1474",
        "DATE:05/23/2013",
        "TIME:11:42",
        "INFO:DFMA / BRUSH TRUCK REQUEST FOR TREE ON FIRE");

    doTest("T20",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "F-BRUSH        \n" +
        "615 CR 120\n" +
        "FLM2\n" +
        "COTTONWOOD TREE ON FIRE; NO CLOSE TO STRUCTURES; TRL PARK ON  \n\n" +
        "13FL-0064\n" +
        "05/23/2013 11:36",

        "SRC:FLM",
        "UNIT:FLM2",
        "CALL:F-BRUSH",
        "ADDR:615 CR 120",
        "MADDR:615 COUNTY ROAD 120",
        "ID:13FL-0064",
        "DATE:05/23/2013",
        "TIME:11:36",
        "INFO:COTTONWOOD TREE ON FIRE; NO CLOSE TO STRUCTURES; TRL PARK ON");

    doTest("T21",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "E-SEIZURE/CONV \n" +
        "MANCOS HILL; 1 HWY 160 E @ COUNTYLINE\n" +
        "FLM2 M1\n" +
        "56YOM CONC/BREATH ;POSS SEIZURE ;RENDEVOUS\n" +
        "17:32:10 05/17/2013 - Blakstad W M\n" +
        "RP THINKS IT IS A PETTY MAUL SIEZURE\n\n" +
        "13FL-0063\n" +
        "05/17/2013 17:32",

        "SRC:FLM",
        "UNIT:FLM2 M1",
        "CALL:E-SEIZURE/CONV",
        "ADDR:MANCOS HILL",
        "PLACE:1 HWY 160 E @ COUNTYLINE",
        "ID:13FL-0063",
        "DATE:05/17/2013",
        "TIME:17:32:10",
        "INFO:56YOM CONC/BREATH ;POSS SEIZURE ;RENDEVOUS / - Blakstad W M / RP THINKS IT IS A PETTY MAUL SIEZURE");

    doTest("T22",
        "(Message from HipLink) FLM \n" +
        "FLM1 \n" +
        "F-ALARM        \n" +
        "11274 HWY 140\n" +
        "FLM1\n" +
        "GEN FIRE ALARM ; CENT SEC OP 5 CB 8004413662 ; 1026/1029 \n\n" +
        "13FL-0062\n" +
        "CR 119 & CR 130A, CR 130\n" +
        "05/17/2013 10:29",

        "SRC:FLM",
        "UNIT:FLM1",
        "CALL:F-ALARM",
        "ADDR:11274 HWY 140",
        "X:CR 119 & CR 130A, CR 130",
        "ID:13FL-0062",
        "DATE:05/17/2013",
        "TIME:10:29",
        "INFO:GEN FIRE ALARM ; CENT SEC OP 5 CB 8004413662 ; 1026/1029");

    doTest("T23",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "F-ALARM        \n" +
        "11846 HWY 160 W\n" +
        "FLM2\n" +
        "FIRE ALARM ZONE 1; DURANGO ELECTRIC\n\n" +
        "13FL-0061\n" +
        "05/16/2013 18:27",

        "SRC:FLM",
        "UNIT:FLM2",
        "CALL:F-ALARM",
        "ADDR:11846 HWY 160 W",
        "ID:13FL-0061",
        "DATE:05/16/2013",
        "TIME:18:27",
        "INFO:FIRE ALARM ZONE 1; DURANGO ELECTRIC");

    doTest("T24",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "E-TRAFF ACC    \n" +
        "6000 HWY 160 W; MP 68\n" +
        "FLM2\n" +
        "30YM CONS, BRE;SHOULDER PAIN; 2ND HAND RP ALREADY EMD WITH CSP \n\n" +
        "13FL-0060\n" +
        "05/14/2013 11:29",

        "SRC:FLM",
        "UNIT:FLM2",
        "CALL:E-TRAFF ACC",
        "ADDR:6000 HWY 160 W",
        "PLACE:MP 68",
        "ID:13FL-0060",
        "DATE:05/14/2013",
        "TIME:11:29",
        "INFO:30YM CONS, BRE;SHOULDER PAIN; 2ND HAND RP ALREADY EMD WITH CSP");

    doTest("T25",
        "(Message from HipLink) FLM \n" +
        "FLM1 \n" +
        "F-BRUSH        \n" +
        "2000 CR 119\n" +
        "FLM1\n" +
        "CONTROLLED BURN ONLY PARTIALLY IN CONTROL ; UNATTENDED\n\n" +
        "13FL-0059\n" +
        "05/08/2013 17:30",

        "SRC:FLM",
        "UNIT:FLM1",
        "CALL:F-BRUSH",
        "ADDR:2000 CR 119",
        "MADDR:2000 COUNTY ROAD 119",
        "ID:13FL-0059",
        "DATE:05/08/2013",
        "TIME:17:30",
        "INFO:CONTROLLED BURN ONLY PARTIALLY IN CONTROL ; UNATTENDED");

    doTest("T26",
        "(Message from HipLink) FLM \nFLM1 \nF-BRUSH        \nCR 119; IN THE AREA OF\nFLM1\nFIRE IN THE AREA\n\n13FL-0058\n05/08/2013 14:03",
        "SRC:FLM",
        "UNIT:FLM1",
        "CALL:F-BRUSH",
        "ADDR:CR 119",
        "MADDR:COUNTY ROAD 119",
        "PLACE:IN THE AREA OF",
        "ID:13FL-0058",
        "DATE:05/08/2013",
        "TIME:14:03",
        "INFO:FIRE IN THE AREA");

    doTest("T27",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "F-ALARM        \n" +
        "3674 CR 125; 21500 HWY 140\n" +
        "FLM2\n" +
        "AUD SHOWING SMOKE AND HEAT ;ALARM RELAY CB 8007629964 ;OPER CRYSTAL ;1253/1255\n" +
        ";WILL ATTEMPT\n\n" +
        "13FL-0057\n" +
        "05/05/2013 12:56",

        "SRC:FLM",
        "UNIT:FLM2",
        "CALL:F-ALARM",
        "ADDR:3674 CR 125",
        "MADDR:3674 COUNTY ROAD 125",
        "X:21500 HWY 140",
        "ID:13FL-0057",
        "DATE:05/05/2013",
        "TIME:12:56",
        "INFO:AUD SHOWING SMOKE AND HEAT ;ALARM RELAY CB 8007629964 ;OPER CRYSTAL ;1253/1255 / ;WILL ATTEMPT");

    doTest("T28",
        "(Message from HipLink) FLM \n" +
        "FLM2 \n" +
        "F-VEHICLE      \n" +
        "0 HWY 160 W\n" +
        "FLM2\n" +
        "462EHL; FIRE IS OUT BUT VEH IS HOT \n\n" +
        "13FL-0056\n" +
        "05/04/2013 16:37",

        "SRC:FLM",
        "UNIT:FLM2",
        "CALL:F-VEHICLE",
        "ADDR:HWY 160 W",
        "ID:13FL-0056",
        "DATE:05/04/2013",
        "TIME:16:37",
        "INFO:462EHL; FIRE IS OUT BUT VEH IS HOT");

    doTest("T29",
        "(Message from HipLink) FLM \n" +
        "FLM1 \n" +
        "F-GAS ODR INSD \n" +
        "950 CR 104\n" +
        "FLM1\n" +
        "STRONG ODOR OF PROPANE IN RESI ; RESI EVAC ; NO ONE SICK OF BUSY ; RP WAITING\n" +
        "OUTSIDE IN VEH THAT IS ALREADY RUNNING \n\n" +
        "13FL-0055\n" +
        "04/26/2013 20:57",

        "SRC:FLM",
        "UNIT:FLM1",
        "CALL:F-GAS ODR INSD",
        "ADDR:950 CR 104",
        "MADDR:950 COUNTY ROAD 104",
        "ID:13FL-0055",
        "DATE:04/26/2013",
        "TIME:20:57",
        "INFO:STRONG ODOR OF PROPANE IN RESI ; RESI EVAC ; NO ONE SICK OF BUSY ; RP WAITING / OUTSIDE IN VEH THAT IS ALREADY RUNNING");

    doTest("T30",
        "(Message from HipLink) FLM \n" +
        "FLM1 \n" +
        "E-SICK         \n" +
        "65 CR 103\n" +
        "FLM1 M2\n" +
        "58 YOM SEMI-CONS; DIFF BRE; SWEATING ; POSS INTOX \n" +
        "20:35:21 04/21/2013 - CASTRO C\n" +
        "MAKING MOANING NOISES \n\n" +
        "13FL-0054\n" +
        "04/21/2013 20:35",

        "SRC:FLM",
        "UNIT:FLM1 M2",
        "CALL:E-SICK",
        "ADDR:65 CR 103",
        "MADDR:65 COUNTY ROAD 103",
        "ID:13FL-0054",
        "DATE:04/21/2013",
        "TIME:20:35:21",
        "INFO:58 YOM SEMI-CONS; DIFF BRE; SWEATING ; POSS INTOX / - CASTRO C / MAKING MOANING NOISES");

  }
  
  public static void main(String[] args) {
    new COLaPlataCountyParserTest().generateTests("T1");
  }
}