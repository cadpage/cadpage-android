package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*    
Baltimore County, MD
Contact: Emma Schneider <ejschneider41@verizon.net>
Sender: postmaster@sparkgroup.net

(Station 41 ALERT!!) UNCONSCIOUS DIABETIC\n046-04\nE461 E18 M465 IV415 CCM129 EMS5\n9341 EDWAY CI\n\nIncident Number (120911179)
(Station 41 ALERT!!) FALL INJURY NON DANGEROUS\n041-21\nIV415\n300 CANTATA CT APT 302, 21136, MD\n\nIncident Number (120911036)
(Station 41 ALERT!!) BUILDING FIRE\n056-06\nBC21 E56 E412 E311 E401 T313 T404\n11602 REISTERSTOWN RD, 21136, MD\n\nIncident Number (120910568)
(Station 41 ALERT!!) UNKNOWN ILLNESS OR INJURY\n041-21\nA415 M56\n300 CANTATA CT APT 314, 21136, MD\n\nIncident Number (120910566)
(Station 41 ALERT!!) CP  CLAMMY\n041-06\nM415 CCM139\n744 COCKEYS MILL RD, 21136, MD\n\nIncident Number (120910541)
(Station 41 ALERT!!) STROKE  NOT ALERT\n049-10\nM395 M415\n14032 CUBA RD\n\nIncident Number (120901630)
(Station 41 ALERT!!) FALL  POSS DANGEROUS AREA\n056-06\nA415 IV465\n11722 REISTERSTOWN RD, 21136, MD\n\nIncident Number (120901441)
(Station 41 ALERT!!) INJ-DANGROUS BDY AREA\n041-03\nM56 SU418\nSTOCKSDALE AV & POWER LINE, 21136, MD\n\nIncident Number (120901111)
(Station 41 ALERT!!) SICK SUBJECT NOT ALERT\n041-01\nM415 M56\n10 VILLAGE CENTER RD, 21136, MD\n\nIncident Number (120901433)
(Station 41 ALERT!!) 1050PI\n041-01\nA415 M315 E413\nFRANKLIN ES @  33 COCKEYS MILL RD, 21136, MD\n\nIncident Number (120900817)
(Station 41 ALERT!!) 1050PI ROLL-OVER\n041-20\nA415 M315 E413\nI795 & WESTMINSTER PK, 21136, MD\n\nIncident Number (120900400)
(Station 41 ALERT!!) TRBR-W/DIFF SPEAKING\n056-05\nIV415 M2 EMS5\n300 STONECASTLE AV, 21136, MD\n\nIncident Number (120911287)
(Station 41 ALERT!!) ABD PAIN  NOT ALERT\n056-08\nA315 IV415\n111 EMBLETON RD, 21117, MD\n\nIncident Number (120911354)
(Station 41 ALERT!!) 1050PI ROLL-OVER\n041-08\nA415 M56 E412\n5 BRIAN DANIEL CT, 21136, MD\n\nIncident Number (120920186)
(Station 41 ALERT!!) BLEEDING SUBJ W/TRBR\n056-06\nM415 M19\n11 WOODENBRIDGE CT, 21136, MD\n\nIncident Number (120921328)
(Station 41 ALERT!!) FALL INJURY NON DANGEROUS\n041-21\nA415 M56\n300 CANTATA CT APT 302, 21136, MD\n\nIncident Number (120921264)
(Station 41 ALERT!!) FALL INJURY NON DANGEROUS\n056-04\nE56 A415 IV505\n828 IVYDALE AV, 21136, MD\n\nIncident Number (120951716)
(Station 41 ALERT!!) LOCK OUT DETAIL/NON EMERG\n041-23\nE412\n505 DEACON BROOK CI, 21136, MD\n\nIncident Number (120980427)
(Station 41 ALERT!!) BUILDING FIRE\nCAR-43\nE432 S414 T404 E412\n643 LUCABAUGH MILL RD\n\nIncident Number (120971868)
(Station 41 ALERT!!) EMOT ILL CONS/BREATHING\n041-23\nM415 M315\n400 VALLEY MEADOW CI APT B1, 21136, MD\n\nIncident Number (120990430)
(Station 41 ALERT!!) FAINTING  ALERT W/TRBR\n041-23\nM415 M56\n406 DEACON BROOK CI, 21136, MD\n\nIncident Number (120990933)
(Station 41 ALERT!!) 1050PI\n043-03\nA435 E432 CCM28 A415 M56 EMS7\nRT 30 & DOVER RD, 21155, MD\nIncident Number (121111313)

Contact: Active911
Agency name: Manchester Fire Co.
Location: Manchester, MD, United States (in Carroll County)
Sender: fast@md-carroll-04.fastalerting.com

(Station 04 ALERT!!)\r\nBLS MEDICAL CALL\r\n0412\r\nX49\r\n3416 WAREHIME RD, Manchester, MD\r\nIncident Number (12014545)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!)\r\nMUTUAL AID ALARM\r\nYC\r\nET73  ET44  E43\r\n52-2 3599 BAUMGARDENER ROAD STRUCTURE FIRE OPS10\r\nIncident Number (12014542)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!)\r\nMUTUAL AID ALARM\r\nYC\r\nE72  E43\r\n52-2 3599 BAUMGARDENER ROAD STRUCTURE FIRE OPS10\r\nIncident Number (12014542)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!)\r\nUNCONSCIOUS SUBJECT\r\n0405\r\nX49  E43\r\n3332 MAIN ST @LONG VIEW NH ; ROOM 104, Manchester, MD\r\nIncident Number (12014540)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!)\r\nALS MEDICAL CALL\r\n0410\r\nX49  E43\r\n2320 HANOVER PKE @WAL MART, Hampstead, MD\r\nIncident Number (12014524)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!)\r\nALS MEDICAL CALL\r\n0410\r\nX49\r\n2320 HANOVER PKE @WAL MART, Hampstead, MD\r\nIncident Number (12014524)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nMUTUAL AID ALARM\r\nYC\r\nE43\r\nPLEASANT HILL VFD @ BOX 52-14 YC52 /\r\nIncident Number (12015197)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nALS MEDICAL CALL\r\n0417\r\nX49  YA52-1\r\n2213 SCENIC VIEW DR, Manchester, MD\r\nIncident Number (12015186)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nBLS MEDICAL CALL\r\n0401\r\nX49\r\n2800 HILLTOP DR, Manchester, MD\r\nIncident Number (12015182)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nVEHICLE COLLISION\r\n0408\r\nX49  E43\r\nOLD FORT SCHOOLHOU RD / RT 27, Hampstead, MD\r\nIncident Number (12015156)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nBLS MEDICAL CALL\r\n0217\r\nBM435 FR2  X49\r\nMCDONALDS @4225 NORTH WOODS TRL, Hampstead, MD\r\nIncident Number (12015148)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nBLS MEDICAL CALL\r\n0419\r\nX49\r\n1170 DINGUS DR, Westminster, MD\r\nIncident Number (12015138)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nBLS MEDICAL CALL\r\n0404\r\nX49\r\nSHEETZ @3281 MAIN ST, Manchester, MD\r\nIncident Number (12015097)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nALS MEDICAL CALL\r\n0412\r\nX49  X28\r\n3416 WAREHIME RD, Manchester, MD\r\nIncident Number (12015069)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nPATIENT ASSIST\r\n0415\r\nX49\r\n1953 BACHMANS VALLEY RD, Manchester, MD\r\nIncident Number (12015039)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nBLS MEDICAL CALL\r\n0701\r\nX79  X49  FR7\r\n4601 BAUGHMAN MILL RD, Lineboro, MD\r\nIncident Number (12015024)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nBLS MEDICAL CALL\r\n0701\r\nX49  FR7\r\n4601 BAUGHMAN MILL RD, Lineboro, MD\r\nIncident Number (12015003)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nBLS MEDICAL CALL\r\n0704\r\nX49  FR7\r\n4761 GRAVE RUN RD, Lineboro, MD\r\nIncident Number (12015002)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nMUTUAL AID ALARM\r\nYC\r\nRS4\r\n59-14 3686 STICKS RD VC\r\nIncident Number (12015000)\r\n\r\n\r\n\r\n
(Station 04 ALERT!!) \r\nCO W/SICK PERSON\r\n0403\r\nX49  E43\r\n2845 CHAUNCEY HILL DR, Manchester, MD\r\nIncident Number (12014998)\r\n\r\n\r\n\r\n

Contact: Active911
Agency name: Manchester Fire Co.
Location: Manchester, MD, United States
Sender: "FASTalert System" <fast@md-carroll-04.fastalerting.com>

(Station 04 ALERT!! (12018659)) \nUNCONSCIOUS SUBJECT\n0221\nX28  E23  E43\n3488 WOODHOLME DR, Hampstead, MD
(Station 04 ALERT!! (12018652)) \nBLS MEDICAL CALL\n0421\nX49\n1238 FRIDINGER MILL RD @SUNNY WOODS                  APT 1, Westminster, MD
(Station 04 ALERT!! (12018642)) \nCO DETECTOR SOUNDING\n0405\nB46\n3223 MOREFIELD CT, Manchester, MD
(Station 04 ALERT!! (12018612)) \nPEDESTRIAN STRUCK\n0328\nX49  FR3  E31\nWAL MART @280 WOODWARD RD, Westminster, MD
(Station 04 ALERT!! (12018607)) \nBLS MEDICAL CALL\n0404\nX49\n3316 WILHELM LA @NORTH PINES CARE, Manchester, MD
(Station 04 ALERT!! (12018572)) \nALS MEDICAL CALL\n0405\nX79  FR4\n3439 AUGUSTA RD, Manchester, MD
(Station 04 ALERT!! (12018571)) \nALS MEDICAL CALL\n0405\nX49\n3332 MAIN ST @LONG VIEW NH                           APT 106-B, Manchester, MD
(Station 04 ALERT!! (12018539)) \nVEHICLE COLLISION\n0411\nX49  E43  RS4\nCHARMIL DR / RT 30, Manchester, MD
(Station 04 ALERT!! (12018539)) \nVEHICLE COLLISION\n0411\nX49  E43\nCHARMIL DR / RT 30, Manchester, MD
(Station 04 ALERT!! (12018535)) \nBLS MEDICAL CALL\n0403\nX49  U4\n2811 CHAUNCEY HILL DR, Manchester, MD
(Station 04 ALERT!! (12018535)) \nBLS MEDICAL CALL\n0403\nX49\n2811 CHAUNCEY HILL DR, Manchester, MD
(Station 04 ALERT!! (12018520)) \nBLS MEDICAL CALL\n0404\nX49\n3316 WILHELM LA @NORTH PINES CARE, Manchester, MD
(Station 04 ALERT!! (12018510)) \nPATIENT ASSIST\n0403\nX49\n2811 CHAUNCEY HILL DR, Manchester, MD
(Station 04 ALERT!! (12018501)) \nBLS MEDICAL CALL\n0409\nX49\n3308 SAINT GEORGES CT, Hampstead, MD
(Station 04 ALERT!! (12018475)) \nVC RESCUE\n0423\nX49  E43  RS4\nSNYDERSBURG RD / SULLIVAN RD, Westminster, MD
(Station 04 ALERT!! (12018417)) \nBLS MEDICAL CALL\n0404\nX49\n3253 CHESTNUT ST, Manchester, MD
(Station 04 ALERT!! (12018404)) \nALS MEDICAL CALL\n0411\nX49  X28\nST BARTHOLOMEW CH @2930 HANOVER PKE, Manchester, MD
(Station 04 ALERT!! (12018394)) \nRES FIRE ALARM\n0413\nE43\n4438 MILLERS STATION RD, Hampstead, MD
(Station 04 ALERT!! (12018373)) \nSTRUCTURE ALARM\n0208\nE23  E43  T2\nHAMPSTEAD CAR WASH @1600 N MAIN ST, Hampstead, MD
(Station 04 ALERT!! (12018367)) \nALS MEDICAL CALL\n0217\nBM435 FR2  X49\n4846 HILLOCK LA, Hampstead, MD

Contact: Active911
Agency name: Manchester Fire Co.
Location: Manchester, MD, United States
Sender: "FASTalert System" <fast@md-carroll-04.fastalerting.com>

(Station 04 ALERT!! (13001221)) \nBLS MEDICAL CALL\nX49  FR2\n0218\n3941 SHILOH AV, Hampstead, MD\nP HEADACHE CHEST PAIN ;25 YEAR OLD, FEMALE, CONSCIOUS, BREATHING.  CCN:10 DL:10A01 P
(Station 04 ALERT!! (13001212)) \nBLS MEDICAL CALL\nX49\n0419\n3535 BACKWOODS RD, Westminster, MD\nP BACK PAIN ;97 YEAR OLD, FEMALE, CONSCIOUS, BREATHING. -COMMENTS: X-  CCN:5 DL:05A01 P
(Station 04 ALERT!! (13001199)) \nVEHICLE COLLISION\nX49  E43\n0410\nWAL MART @2320 HANOVER PKE, Hampstead, MD\n.
(Station 04 ALERT!! (13001191)) \nALS MEDICAL CALL\nX49\n0401\n2973 MANCHESTER RD @MANCHESTER FAM MED, Manchester, MD\nP CHEST PAIN ;72 YEAR OLD, MALE, CONSCIOUS, BREATHING.  CCN:10 DL:10C04 P
(Station 04 ALERT!! (13001175)) \nALS MEDICAL CALL\nYA52-1 X79  FR4\n0419\n4030 RINEHART RD, Westminster, MD\n.
(Station 04 ALERT!! (13001173)) \nVC RESCUE\nX69  X49  E61  RS6\n0603\n250 E DEEP RUN RD, Westminster, MD\n.
(Station 04 ALERT!! (13001169)) \nALS MEDICAL CALL\nX49\n0402\n3295 CHARMIL DR, Manchester, MD\nP SHARP PAIN IN THE BACK  ;55 YEAR OLD, MALE, CONSCIOUS, BREATHING. -COMMENTS: SHARP SHOOTING PAIN-  CCN:5 DL:05C03 P
(Station 04 ALERT!! (13001143)) \nMUTUAL AID ALARM\nE72  ET73  T2   X79  CAPT7 CF7  ET44  ET24  B46\nYC\n5333 TRUMP RD/BLOOMING GROVE STRUC 7-28              APT A-8\n.
(Station 04 ALERT!! (13001143)) \nMUTUAL AID ALARM\nE72  ET73  T2   X79  CAPT7 CF7  ET44  ET24\nYC\n5333 TRUMP RD/BLOOMING GROVE STRUC 7-28              APT A-8\n.
(Station 04 ALERT!! (13001131)) \nALS MEDICAL CALL\nX49  YA52-1\n0418\n706 LAKE DR, Westminster, MD\nP T/B, LOWER GI BLEED ;66 YEAR OLD, FEMALE, CONSCIOUS, BREATHING.  CCN:6 DL:06D04 P
(Station 04 ALERT!! (13001109)) \nCO DETECTOR SOUNDING\nB25  ET44\n0206\n1805 UPPER FORDE LA, Hampstead, MD\n.
(Station 04 ALERT!! (13001108)) \nBUILDING FIRE\nE23  BE432 E43  BE422 E91  T2   BT404 TO3  X29      CS4\n0217\n1003 SCARLET OAK CT                                  APT 1B, Hampstead, MD\nPF SMOKE INSIDE APT ;STRUCTURE FIRE. CCN:69 DL:69D05 PF
(Station 04 ALERT!! (13001089)) \nALS MEDICAL CALL\nX49\n0405\n3332 MAIN ST @LONG VIEW NH                           APT 224B, Manchester, MD\nP CHEST PAIN ;83 YEAR OLD, MALE, CONSCIOUS, BREATHING.  CCN:10 DL:10D01 P
(Station 04 ALERT!! (13001082)) \nBLS MEDICAL CALL\nX49\n0410\nWAL MART @2320 HANOVER PKE ; OUTSIDE IN PARKING LOT, Hampstead, MD\nP FELL IN PARKING LOT ;60 YEAR OLD, FEMALE, CONSCIOUS, BREATHING.  CCN:17 DL:17A01 DL SUF:G P
(Station 04 ALERT!! (13001051)) \nALS MEDICAL CALL\nX49  YA52-1\n0417\n2213 SCENIC VIEW DR, Manchester, MD\nP SEIZURE ;22 YEAR OLD, FEMALE, UNCONSCIOUS, BREATHING.  CCN:12 DL:12D02 DL SUF:E P
(Station 04 ALERT!! (13001029)) \nLOCAL ALARM\nE43  YE52-1\n0419\n3921 BIXLER CHURCH RD ; ACROSS THE STREET, Westminster, MD\nPF BRUSH FIRE ;OUTSIDE FIRE. CCN:67 DL:67D03 PF
(Station 04 ALERT!! (13001027)) \nMUTUAL AID ALARM\nX49  E23\nBC\n43-6//4017 BLACKROCK RD // FALL //WEST\n.
(Station 04 ALERT!! (13001018)) \nBLS MEDICAL CALL\nX49  FR2\n0220\n1211 N MAIN ST @RESIDENCE@HAMP SCHOL                 APT 405, Hampstead, MD\nP FALL 80YOM  ;80 YEAR OLD, MALE, CONSCIOUS, BREATHING.  CCN:17 DL:17B01 P
(Station 04 ALERT!! (13001004)) \nCARDIAC ARREST\nX49  X29  E43\n0403\n2612 WASHINGTON WY, Manchester, MD\nP UNCONSCIOUS ;47 YEAR OLD, MALE, UNCONSCIOUS, NOT BREATHING.  CCN:9 DL:09E01 P
(Station 04 ALERT!! (13000979)) \nALS MEDICAL CALL\nX49\n0412\n3003 WAREHIME RD, Manchester, MD\nP HEART RACING, HX OF HEART ATTACK ;59 YEAR OLD, MALE, CONSCIOUS, BREATHING.  CCN:19 DL:19D04 P
(Station 04 ALERT!! (13000968)) \nBLS MEDICAL CALL\nX49\n0409\n2309 ALBERT RILL RD, Westminster, MD\n.

*/

public class MDBaltimoreCountyAParserTest extends BaseParserTest {
  
  public MDBaltimoreCountyAParserTest() {
    setParser(new MDBaltimoreCountyAParser(), "BALTIMORE COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Station 41 ALERT!!) UNCONSCIOUS DIABETIC\n046-04\nE461 E18 M465 IV415 CCM129 EMS5\n9341 EDWAY CI\n\nIncident Number (120911179)",
        "SRC:41",
        "CALL:UNCONSCIOUS DIABETIC",
        "MAP:046-04",
        "UNIT:E461 E18 M465 IV415 CCM129 EMS5",
        "ADDR:9341 EDWAY CI",
        "MADDR:9341 EDWAY CIR",
        "ID:120911179");

    doTest("T2",
        "(Station 41 ALERT!!) FALL INJURY NON DANGEROUS\n041-21\nIV415\n300 CANTATA CT APT 302, 21136, MD\n\nIncident Number (120911036)",
        "SRC:41",
        "CALL:FALL INJURY NON DANGEROUS",
        "MAP:041-21",
        "UNIT:IV415",
        "ADDR:300 CANTATA CT",
        "APT:302",
        "CITY:21136",
        "ID:120911036");

    doTest("T3",
        "(Station 41 ALERT!!) BUILDING FIRE\n" +
        "056-06\n" +
        "BC21 E56 E412 E311 E401 T313 T404\n" +
        "11602 REISTERSTOWN RD, 21136, MD\n\n" +
        "Incident Number (120910568)",

        "SRC:41",
        "CALL:BUILDING FIRE",
        "MAP:056-06",
        "UNIT:BC21 E56 E412 E311 E401 T313 T404",
        "ADDR:11602 REISTERSTOWN RD",
        "CITY:21136",
        "ID:120910568");

    doTest("T4",
        "(Station 41 ALERT!!) UNKNOWN ILLNESS OR INJURY\n041-21\nA415 M56\n300 CANTATA CT APT 314, 21136, MD\n\nIncident Number (120910566)",
        "SRC:41",
        "CALL:UNKNOWN ILLNESS OR INJURY",
        "MAP:041-21",
        "UNIT:A415 M56",
        "ADDR:300 CANTATA CT",
        "APT:314",
        "CITY:21136",
        "ID:120910566");

    doTest("T5",
        "(Station 41 ALERT!!) CP  CLAMMY\n041-06\nM415 CCM139\n744 COCKEYS MILL RD, 21136, MD\n\nIncident Number (120910541)",
        "SRC:41",
        "CALL:CP  CLAMMY",
        "MAP:041-06",
        "UNIT:M415 CCM139",
        "ADDR:744 COCKEYS MILL RD",
        "CITY:21136",
        "ID:120910541");

    doTest("T6",
        "(Station 41 ALERT!!) STROKE  NOT ALERT\n049-10\nM395 M415\n14032 CUBA RD\n\nIncident Number (120901630)",
        "SRC:41",
        "CALL:STROKE  NOT ALERT",
        "MAP:049-10",
        "UNIT:M395 M415",
        "ADDR:14032 CUBA RD",
        "ID:120901630");

    doTest("T7",
        "(Station 41 ALERT!!) FALL  POSS DANGEROUS AREA\n056-06\nA415 IV465\n11722 REISTERSTOWN RD, 21136, MD\n\nIncident Number (120901441)",
        "SRC:41",
        "CALL:FALL  POSS DANGEROUS AREA",
        "MAP:056-06",
        "UNIT:A415 IV465",
        "ADDR:11722 REISTERSTOWN RD",
        "CITY:21136",
        "ID:120901441");

    doTest("T8",
        "(Station 41 ALERT!!) INJ-DANGROUS BDY AREA\n041-03\nM56 SU418\nSTOCKSDALE AV & POWER LINE, 21136, MD\n\nIncident Number (120901111)",
        "SRC:41",
        "CALL:INJ-DANGROUS BDY AREA",
        "MAP:041-03",
        "UNIT:M56 SU418",
        "ADDR:STOCKSDALE AV & POWER LINE",
        "MADDR:STOCKSDALE AVE & POWER LINE",
        "CITY:21136",
        "ID:120901111");

    doTest("T9",
        "(Station 41 ALERT!!) SICK SUBJECT NOT ALERT\n041-01\nM415 M56\n10 VILLAGE CENTER RD, 21136, MD\n\nIncident Number (120901433)",
        "SRC:41",
        "CALL:SICK SUBJECT NOT ALERT",
        "MAP:041-01",
        "UNIT:M415 M56",
        "ADDR:10 VILLAGE CENTER RD",
        "CITY:21136",
        "ID:120901433");

    doTest("T10",
        "(Station 41 ALERT!!) 1050PI\n041-01\nA415 M315 E413\nFRANKLIN ES @  33 COCKEYS MILL RD, 21136, MD\n\nIncident Number (120900817)",
        "SRC:41",
        "CALL:1050PI",
        "MAP:041-01",
        "UNIT:A415 M315 E413",
        "PLACE:FRANKLIN ES",
        "ADDR:33 COCKEYS MILL RD",
        "CITY:21136",
        "ID:120900817");

    doTest("T11",
        "(Station 41 ALERT!!) 1050PI ROLL-OVER\n041-20\nA415 M315 E413\nI795 & WESTMINSTER PK, 21136, MD\n\nIncident Number (120900400)",
        "SRC:41",
        "CALL:1050PI ROLL-OVER",
        "MAP:041-20",
        "UNIT:A415 M315 E413",
        "ADDR:I-795 & WESTMINSTER PK",
        "MADDR:I 795 & WESTMINSTER PIKE",
        "CITY:21136",
        "ID:120900400");

    doTest("T12",
        "(Station 41 ALERT!!) TRBR-W/DIFF SPEAKING\n056-05\nIV415 M2 EMS5\n300 STONECASTLE AV, 21136, MD\n\nIncident Number (120911287)",
        "SRC:41",
        "CALL:TRBR-W/DIFF SPEAKING",
        "MAP:056-05",
        "UNIT:IV415 M2 EMS5",
        "ADDR:300 STONECASTLE AV",
        "MADDR:300 STONECASTLE AVE",
        "CITY:21136",
        "ID:120911287");

    doTest("T13",
        "(Station 41 ALERT!!) ABD PAIN  NOT ALERT\n056-08\nA315 IV415\n111 EMBLETON RD, 21117, MD\n\nIncident Number (120911354)",
        "SRC:41",
        "CALL:ABD PAIN  NOT ALERT",
        "MAP:056-08",
        "UNIT:A315 IV415",
        "ADDR:111 EMBLETON RD",
        "CITY:21117",
        "ID:120911354");

    doTest("T14",
        "(Station 41 ALERT!!) 1050PI ROLL-OVER\n041-08\nA415 M56 E412\n5 BRIAN DANIEL CT, 21136, MD\n\nIncident Number (120920186)",
        "SRC:41",
        "CALL:1050PI ROLL-OVER",
        "MAP:041-08",
        "UNIT:A415 M56 E412",
        "ADDR:5 BRIAN DANIEL CT",
        "CITY:21136",
        "ID:120920186");

    doTest("T15",
        "(Station 41 ALERT!!) BLEEDING SUBJ W/TRBR\n056-06\nM415 M19\n11 WOODENBRIDGE CT, 21136, MD\n\nIncident Number (120921328)",
        "SRC:41",
        "CALL:BLEEDING SUBJ W/TRBR",
        "MAP:056-06",
        "UNIT:M415 M19",
        "ADDR:11 WOODENBRIDGE CT",
        "CITY:21136",
        "ID:120921328");

    doTest("T16",
        "(Station 41 ALERT!!) FALL INJURY NON DANGEROUS\n041-21\nA415 M56\n300 CANTATA CT APT 302, 21136, MD\n\nIncident Number (120921264)",
        "SRC:41",
        "CALL:FALL INJURY NON DANGEROUS",
        "MAP:041-21",
        "UNIT:A415 M56",
        "ADDR:300 CANTATA CT",
        "APT:302",
        "CITY:21136",
        "ID:120921264");

    doTest("T17",
        "(Station 41 ALERT!!) FALL INJURY NON DANGEROUS\n056-04\nE56 A415 IV505\n828 IVYDALE AV, 21136, MD\n\nIncident Number (120951716)",
        "SRC:41",
        "CALL:FALL INJURY NON DANGEROUS",
        "MAP:056-04",
        "UNIT:E56 A415 IV505",
        "ADDR:828 IVYDALE AV",
        "MADDR:828 IVYDALE AVE",
        "CITY:21136",
        "ID:120951716");

    doTest("T18",
        "(Station 41 ALERT!!) LOCK OUT DETAIL/NON EMERG\n041-23\nE412\n505 DEACON BROOK CI, 21136, MD\n\nIncident Number (120980427)",
        "SRC:41",
        "CALL:LOCK OUT DETAIL/NON EMERG",
        "MAP:041-23",
        "UNIT:E412",
        "ADDR:505 DEACON BROOK CI",
        "MADDR:505 DEACON BROOK CIR",
        "CITY:21136",
        "ID:120980427");

    doTest("T19",
        "(Station 41 ALERT!!) BUILDING FIRE\nCAR-43\nE432 S414 T404 E412\n643 LUCABAUGH MILL RD\n\nIncident Number (120971868)",
        "SRC:41",
        "CALL:BUILDING FIRE",
        "MAP:CAR-43",
        "UNIT:E432 S414 T404 E412",
        "ADDR:643 LUCABAUGH MILL RD",
        "ID:120971868");

    doTest("T20",
        "(Station 41 ALERT!!) EMOT ILL CONS/BREATHING\n041-23\nM415 M315\n400 VALLEY MEADOW CI APT B1, 21136, MD\n\nIncident Number (120990430)",
        "SRC:41",
        "CALL:EMOT ILL CONS/BREATHING",
        "MAP:041-23",
        "UNIT:M415 M315",
        "ADDR:400 VALLEY MEADOW CI",
        "MADDR:400 VALLEY MEADOW CIR",
        "APT:B1",
        "CITY:21136",
        "ID:120990430");

    doTest("T21",
        "(Station 41 ALERT!!) FAINTING  ALERT W/TRBR\n041-23\nM415 M56\n406 DEACON BROOK CI, 21136, MD\n\nIncident Number (120990933)",
        "SRC:41",
        "CALL:FAINTING  ALERT W/TRBR",
        "MAP:041-23",
        "UNIT:M415 M56",
        "ADDR:406 DEACON BROOK CI",
        "MADDR:406 DEACON BROOK CIR",
        "CITY:21136",
        "ID:120990933");

    doTest("T22",
        "(Station 41 ALERT!!) 1050PI\n043-03\nA435 E432 CCM28 A415 M56 EMS7\nRT 30 & DOVER RD, 21155, MD\nIncident Number (121111313)",
        "SRC:41",
        "CALL:1050PI",
        "MAP:043-03",
        "UNIT:A435 E432 CCM28 A415 M56 EMS7",
        "ADDR:RT 30 & DOVER RD",
        "CITY:21155",
        "ID:121111313");
  }
  
  @Test
  public void testManchesterFire1() {

    doTest("T1",
        "(Station 04 ALERT!!)\r\nBLS MEDICAL CALL\r\n0412\r\nX49\r\n3416 WAREHIME RD, Manchester, MD\r\nIncident Number (12014545)\r\n\r\n\r\n\r\n",
        "SRC:04",
        "CALL:BLS MEDICAL CALL",
        "MAP:0412",
        "UNIT:X49",
        "ADDR:3416 WAREHIME RD",
        "CITY:Manchester",
        "ID:12014545");

    doTest("T2",
        "(Station 04 ALERT!!)\r\n" +
        "MUTUAL AID ALARM\r\n" +
        "YC\r\n" +
        "ET73 ET44 E43\r\n" +
        "52-2 3599 BAUMGARDENER ROAD STRUCTURE FIRE OPS10\r\n" +
        "Incident Number (12014542)\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "SRC:04",
        "CALL:MUTUAL AID ALARM 52-2 STRUCTURE FIRE",
        "MAP:YC",
        "UNIT:ET73 ET44 E43",
        "ADDR:3599 BAUMGARDENER ROAD",
        "CH:OPS10",
        "ID:12014542");

    doTest("T3",
        "(Station 04 ALERT!!)\r\n" +
        "MUTUAL AID ALARM\r\n" +
        "YC\r\n" +
        "E72  E43\r\n" +
        "52-2 3599 BAUMGARDENER ROAD STRUCTURE FIRE OPS10\r\n" +
        "Incident Number (12014542)\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "SRC:04",
        "CALL:MUTUAL AID ALARM 52-2 STRUCTURE FIRE",
        "MAP:YC",
        "UNIT:E72 E43",
        "ADDR:3599 BAUMGARDENER ROAD",
        "CH:OPS10",
        "ID:12014542");

    doTest("T4",
        "(Station 04 ALERT!!)\r\n" +
        "UNCONSCIOUS SUBJECT\r\n" +
        "0405\r\n" +
        "X49  E43\r\n" +
        "3332 MAIN ST @LONG VIEW NH ; ROOM 104, Manchester, MD\r\n" +
        "Incident Number (12014540)\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "SRC:04",
        "CALL:UNCONSCIOUS SUBJECT",
        "MAP:0405",
        "UNIT:X49 E43",
        "ADDR:3332 MAIN ST",
        "PLACE:LONG VIEW NH",
        "APT:104",
        "CITY:Manchester",
        "ID:12014540");

    doTest("T5",
        "(Station 04 ALERT!!)\r\n" +
        "ALS MEDICAL CALL\r\n" +
        "0410\r\n" +
        "X49  E43\r\n" +
        "2320 HANOVER PKE @WAL MART, Hampstead, MD\r\n" +
        "Incident Number (12014524)\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "SRC:04",
        "CALL:ALS MEDICAL CALL",
        "MAP:0410",
        "UNIT:X49 E43",
        "ADDR:2320 HANOVER PKE",
        "MADDR:2320 HANOVER PIKE",
        "PLACE:WAL MART",
        "CITY:Hampstead",
        "ID:12014524");

    doTest("T6",
        "(Station 04 ALERT!!)\r\nALS MEDICAL CALL\r\n0410\r\nX49\r\n2320 HANOVER PKE @WAL MART, Hampstead, MD\r\nIncident Number (12014524)\r\n\r\n\r\n\r\n",
        "SRC:04",
        "CALL:ALS MEDICAL CALL",
        "MAP:0410",
        "UNIT:X49",
        "ADDR:2320 HANOVER PKE",
        "MADDR:2320 HANOVER PIKE",
        "PLACE:WAL MART",
        "CITY:Hampstead",
        "ID:12014524");

    doTest("T7",
        "(Station 04 ALERT!!) \r\nMUTUAL AID ALARM\r\nYC\r\nE43\r\nPLEASANT HILL VFD @ BOX 52-14 YC52 /\r\nIncident Number (12015197)\r\n\r\n\r\n\r\n",
        "SRC:04",
        "CALL:MUTUAL AID ALARM",
        "MAP:YC",
        "UNIT:E43",
        "ADDR:PLEASANT HILL VFD @ BOX 52-14 YC52 &",
        "ID:12015197");

    doTest("T8",
        "(Station 04 ALERT!!) \r\n" +
        "ALS MEDICAL CALL\r\n" +
        "0417\r\n" +
        "X49  YA52-1\r\n" +
        "2213 SCENIC VIEW DR, Manchester, MD\r\n" +
        "Incident Number (12015186)\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "SRC:04",
        "CALL:ALS MEDICAL CALL",
        "MAP:0417",
        "UNIT:X49 YA52-1",
        "ADDR:2213 SCENIC VIEW DR",
        "CITY:Manchester",
        "ID:12015186");

    doTest("T9",
        "(Station 04 ALERT!!) \r\nBLS MEDICAL CALL\r\n0401\r\nX49\r\n2800 HILLTOP DR, Manchester, MD\r\nIncident Number (12015182)\r\n\r\n\r\n\r\n",
        "SRC:04",
        "CALL:BLS MEDICAL CALL",
        "MAP:0401",
        "UNIT:X49",
        "ADDR:2800 HILLTOP DR",
        "CITY:Manchester",
        "ID:12015182");

    doTest("T10",
        "(Station 04 ALERT!!) \r\n" +
        "VEHICLE COLLISION\r\n" +
        "0408\r\n" +
        "X49  E43\r\n" +
        "OLD FORT SCHOOLHOU RD / RT 27, Hampstead, MD\r\n" +
        "Incident Number (12015156)\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "SRC:04",
        "CALL:VEHICLE COLLISION",
        "MAP:0408",
        "UNIT:X49 E43",
        "ADDR:OLD FORT SCHOOLHOU RD & RT 27",
        "CITY:Hampstead",
        "ID:12015156");

    doTest("T11",
        "(Station 04 ALERT!!) \r\n" +
        "BLS MEDICAL CALL\r\n" +
        "0217\r\n" +
        "BM435 FR2  X49\r\n" +
        "MCDONALDS @4225 NORTH WOODS TRL, Hampstead, MD\r\n" +
        "Incident Number (12015148)\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "SRC:04",
        "CALL:BLS MEDICAL CALL",
        "MAP:0217",
        "UNIT:BM435 FR2 X49",
        "PLACE:MCDONALDS",
        "ADDR:4225 NORTH WOODS TRL",
        "CITY:Hampstead",
        "ID:12015148");

    doTest("T12",
        "(Station 04 ALERT!!) \r\nBLS MEDICAL CALL\r\n0419\r\nX49\r\n1170 DINGUS DR, Westminster, MD\r\nIncident Number (12015138)\r\n\r\n\r\n\r\n",
        "SRC:04",
        "CALL:BLS MEDICAL CALL",
        "MAP:0419",
        "UNIT:X49",
        "ADDR:1170 DINGUS DR",
        "CITY:Westminster",
        "ID:12015138");

    doTest("T13",
        "(Station 04 ALERT!!) \r\nBLS MEDICAL CALL\r\n0404\r\nX49\r\nSHEETZ @3281 MAIN ST, Manchester, MD\r\nIncident Number (12015097)\r\n\r\n\r\n\r\n",
        "SRC:04",
        "CALL:BLS MEDICAL CALL",
        "MAP:0404",
        "UNIT:X49",
        "PLACE:SHEETZ",
        "ADDR:3281 MAIN ST",
        "CITY:Manchester",
        "ID:12015097");

    doTest("T14",
        "(Station 04 ALERT!!) \r\nALS MEDICAL CALL\r\n0412\r\nX49  X28\r\n3416 WAREHIME RD, Manchester, MD\r\nIncident Number (12015069)\r\n\r\n\r\n\r\n",
        "SRC:04",
        "CALL:ALS MEDICAL CALL",
        "MAP:0412",
        "UNIT:X49 X28",
        "ADDR:3416 WAREHIME RD",
        "CITY:Manchester",
        "ID:12015069");

    doTest("T15",
        "(Station 04 ALERT!!) \r\nPATIENT ASSIST\r\n0415\r\nX49\r\n1953 BACHMANS VALLEY RD, Manchester, MD\r\nIncident Number (12015039)\r\n\r\n\r\n\r\n",
        "SRC:04",
        "CALL:PATIENT ASSIST",
        "MAP:0415",
        "UNIT:X49",
        "ADDR:1953 BACHMANS VALLEY RD",
        "CITY:Manchester",
        "ID:12015039");

    doTest("T16",
        "(Station 04 ALERT!!) \r\n" +
        "BLS MEDICAL CALL\r\n" +
        "0701\r\n" +
        "X79  X49  FR7\r\n" +
        "4601 BAUGHMAN MILL RD, Lineboro, MD\r\n" +
        "Incident Number (12015024)\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "SRC:04",
        "CALL:BLS MEDICAL CALL",
        "MAP:0701",
        "UNIT:X79 X49 FR7",
        "ADDR:4601 BAUGHMAN MILL RD",
        "CITY:Lineboro",
        "ID:12015024");

    doTest("T17",
        "(Station 04 ALERT!!) \r\nBLS MEDICAL CALL\r\n0701\r\nX49  FR7\r\n4601 BAUGHMAN MILL RD, Lineboro, MD\r\nIncident Number (12015003)\r\n\r\n\r\n\r\n",
        "SRC:04",
        "CALL:BLS MEDICAL CALL",
        "MAP:0701",
        "UNIT:X49 FR7",
        "ADDR:4601 BAUGHMAN MILL RD",
        "CITY:Lineboro",
        "ID:12015003");

    doTest("T18",
        "(Station 04 ALERT!!) \r\nBLS MEDICAL CALL\r\n0704\r\nX49  FR7\r\n4761 GRAVE RUN RD, Lineboro, MD\r\nIncident Number (12015002)\r\n\r\n\r\n\r\n",
        "SRC:04",
        "CALL:BLS MEDICAL CALL",
        "MAP:0704",
        "UNIT:X49 FR7",
        "ADDR:4761 GRAVE RUN RD",
        "CITY:Lineboro",
        "ID:12015002");

    doTest("T19",
        "(Station 04 ALERT!!) \r\nMUTUAL AID ALARM\r\nYC\r\nRS4\r\n59-14 3686 STICKS RD VC\r\nIncident Number (12015000)\r\n\r\n\r\n\r\n",
        "SRC:04",
        "CALL:MUTUAL AID ALARM 59-14 VC",
        "MAP:YC",
        "UNIT:RS4",
        "ADDR:3686 STICKS RD",
        "ID:12015000");

    doTest("T20",
        "(Station 04 ALERT!!) \r\n" +
        "CO W/SICK PERSON\r\n" +
        "0403\r\n" +
        "X49  E43\r\n" +
        "2845 CHAUNCEY HILL DR, Manchester, MD\r\n" +
        "Incident Number (12014998)\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "SRC:04",
        "CALL:CO W/SICK PERSON",
        "MAP:0403",
        "UNIT:X49 E43",
        "ADDR:2845 CHAUNCEY HILL DR",
        "CITY:Manchester",
        "ID:12014998");

  }
  
  @Test
  public void testManchesterFire2() {

    doTest("T1",
        "(Station 04 ALERT!! (12018659)) \nUNCONSCIOUS SUBJECT\n0221\nX28  E23  E43\n3488 WOODHOLME DR, Hampstead, MD",
        "SRC:04",
        "ID:12018659",
        "CALL:UNCONSCIOUS SUBJECT",
        "MAP:0221",
        "UNIT:X28 E23 E43",
        "ADDR:3488 WOODHOLME DR", // Google says this is WOODHOLM DR
        "CITY:Hampstead");

    doTest("T2",
        "(Station 04 ALERT!! (12018652)) \n" +
        "BLS MEDICAL CALL\n" +
        "0421\n" +
        "X49\n" +
        "1238 FRIDINGER MILL RD @SUNNY WOODS                  APT 1, Westminster, MD",

        "SRC:04",
        "ID:12018652",
        "CALL:BLS MEDICAL CALL",
        "MAP:0421",
        "UNIT:X49",
        "PLACE:SUNNY WOODS",
        "ADDR:1238 FRIDINGER MILL RD",
        "APT:1",
        "CITY:Westminster");

    doTest("T3",
        "(Station 04 ALERT!! (12018642)) \nCO DETECTOR SOUNDING\n0405\nB46\n3223 MOREFIELD CT, Manchester, MD",
        "SRC:04",
        "ID:12018642",
        "CALL:CO DETECTOR SOUNDING",
        "MAP:0405",
        "UNIT:B46",
        "ADDR:3223 MOREFIELD CT",
        "CITY:Manchester");

    doTest("T4",
        "(Station 04 ALERT!! (12018612)) \nPEDESTRIAN STRUCK\n0328\nX49  FR3  E31\nWAL MART @280 WOODWARD RD, Westminster, MD",
        "SRC:04",
        "ID:12018612",
        "CALL:PEDESTRIAN STRUCK",
        "MAP:0328",
        "UNIT:X49 FR3 E31",
        "PLACE:WAL MART",
        "ADDR:280 WOODWARD RD",
        "CITY:Westminster");

    doTest("T5",
        "(Station 04 ALERT!! (12018607)) \nBLS MEDICAL CALL\n0404\nX49\n3316 WILHELM LA @NORTH PINES CARE, Manchester, MD",
        "SRC:04",
        "ID:12018607",
        "CALL:BLS MEDICAL CALL",
        "MAP:0404",
        "UNIT:X49",
        "PLACE:NORTH PINES CARE",
        "ADDR:3316 WILHELM LA",
        "MADDR:3316 WILHELM LN",
        "CITY:Manchester");

    doTest("T6",
        "(Station 04 ALERT!! (12018572)) \nALS MEDICAL CALL\n0405\nX79  FR4\n3439 AUGUSTA RD, Manchester, MD",
        "SRC:04",
        "ID:12018572",
        "CALL:ALS MEDICAL CALL",
        "MAP:0405",
        "UNIT:X79 FR4",
        "ADDR:3439 AUGUSTA RD",
        "CITY:Manchester");

    doTest("T7",
        "(Station 04 ALERT!! (12018571)) \n" +
        "ALS MEDICAL CALL\n" +
        "0405\n" +
        "X49\n" +
        "3332 MAIN ST @LONG VIEW NH                           APT 106-B, Manchester, MD",

        "SRC:04",
        "ID:12018571",
        "CALL:ALS MEDICAL CALL",
        "MAP:0405",
        "UNIT:X49",
        "PLACE:LONG VIEW NH",
        "ADDR:3332 MAIN ST",
        "APT:106-B",
        "CITY:Manchester");

    doTest("T8",
        "(Station 04 ALERT!! (12018539)) \nVEHICLE COLLISION\n0411\nX49  E43  RS4\nCHARMIL DR / RT 30, Manchester, MD",
        "SRC:04",
        "ID:12018539",
        "CALL:VEHICLE COLLISION",
        "MAP:0411",
        "UNIT:X49 E43 RS4",
        "ADDR:CHARMIL DR & RT 30",
        "CITY:Manchester");

    doTest("T9",
        "(Station 04 ALERT!! (12018539)) \nVEHICLE COLLISION\n0411\nX49  E43\nCHARMIL DR / RT 30, Manchester, MD",
        "SRC:04",
        "ID:12018539",
        "CALL:VEHICLE COLLISION",
        "MAP:0411",
        "UNIT:X49 E43",
        "ADDR:CHARMIL DR & RT 30",
        "CITY:Manchester");

    doTest("T10",
        "(Station 04 ALERT!! (12018535)) \nBLS MEDICAL CALL\n0403\nX49  U4\n2811 CHAUNCEY HILL DR, Manchester, MD",
        "SRC:04",
        "ID:12018535",
        "CALL:BLS MEDICAL CALL",
        "MAP:0403",
        "UNIT:X49 U4",
        "ADDR:2811 CHAUNCEY HILL DR",
        "CITY:Manchester");

    doTest("T11",
        "(Station 04 ALERT!! (12018535)) \nBLS MEDICAL CALL\n0403\nX49\n2811 CHAUNCEY HILL DR, Manchester, MD",
        "SRC:04",
        "ID:12018535",
        "CALL:BLS MEDICAL CALL",
        "MAP:0403",
        "UNIT:X49",
        "ADDR:2811 CHAUNCEY HILL DR",  // Not mapping
        "CITY:Manchester");

    doTest("T12",
        "(Station 04 ALERT!! (12018520)) \nBLS MEDICAL CALL\n0404\nX49\n3316 WILHELM LA @NORTH PINES CARE, Manchester, MD",
        "SRC:04",
        "ID:12018520",
        "CALL:BLS MEDICAL CALL",
        "MAP:0404",
        "UNIT:X49",
        "PLACE:NORTH PINES CARE",
        "ADDR:3316 WILHELM LA",
        "MADDR:3316 WILHELM LN",
        "CITY:Manchester");

    doTest("T13",
        "(Station 04 ALERT!! (12018510)) \nPATIENT ASSIST\n0403\nX49\n2811 CHAUNCEY HILL DR, Manchester, MD",
        "SRC:04",
        "ID:12018510",
        "CALL:PATIENT ASSIST",
        "MAP:0403",
        "UNIT:X49",
        "ADDR:2811 CHAUNCEY HILL DR",
        "CITY:Manchester");

    doTest("T14",
        "(Station 04 ALERT!! (12018501)) \nBLS MEDICAL CALL\n0409\nX49\n3308 SAINT GEORGES CT, Hampstead, MD",
        "SRC:04",
        "ID:12018501",
        "CALL:BLS MEDICAL CALL",
        "MAP:0409",
        "UNIT:X49",
        "ADDR:3308 SAINT GEORGES CT",
        "CITY:Hampstead");

    doTest("T15",
        "(Station 04 ALERT!! (12018475)) \nVC RESCUE\n0423\nX49  E43  RS4\nSNYDERSBURG RD / SULLIVAN RD, Westminster, MD",
        "SRC:04",
        "ID:12018475",
        "CALL:VC RESCUE",
        "MAP:0423",
        "UNIT:X49 E43 RS4",
        "ADDR:SNYDERSBURG RD & SULLIVAN RD", // Google says this is in manchester
        "CITY:Westminster");

    doTest("T16",
        "(Station 04 ALERT!! (12018417)) \nBLS MEDICAL CALL\n0404\nX49\n3253 CHESTNUT ST, Manchester, MD",
        "SRC:04",
        "ID:12018417",
        "CALL:BLS MEDICAL CALL",
        "MAP:0404",
        "UNIT:X49",
        "ADDR:3253 CHESTNUT ST",
        "CITY:Manchester");

    doTest("T17",
        "(Station 04 ALERT!! (12018404)) \nALS MEDICAL CALL\n0411\nX49  X28\nST BARTHOLOMEW CH @2930 HANOVER PKE, Manchester, MD",
        "SRC:04",
        "ID:12018404",
        "CALL:ALS MEDICAL CALL",
        "MAP:0411",
        "UNIT:X49 X28",
        "PLACE:ST BARTHOLOMEW CH",
        "ADDR:2930 HANOVER PKE",
        "MADDR:2930 HANOVER PIKE",
        "CITY:Manchester");

    doTest("T18",
        "(Station 04 ALERT!! (12018394)) \nRES FIRE ALARM\n0413\nE43\n4438 MILLERS STATION RD, Hampstead, MD",
        "SRC:04",
        "ID:12018394",
        "CALL:RES FIRE ALARM",
        "MAP:0413",
        "UNIT:E43",
        "ADDR:4438 MILLERS STATION RD",
        "CITY:Hampstead");

    doTest("T19",
        "(Station 04 ALERT!! (12018373)) \nSTRUCTURE ALARM\n0208\nE23  E43  T2\nHAMPSTEAD CAR WASH @1600 N MAIN ST, Hampstead, MD",
        "SRC:04",
        "ID:12018373",
        "CALL:STRUCTURE ALARM",
        "MAP:0208",
        "UNIT:E23 E43 T2",
        "PLACE:HAMPSTEAD CAR WASH",
        "ADDR:1600 N MAIN ST",
        "CITY:Hampstead");

    doTest("T20",
        "(Station 04 ALERT!! (12018367)) \nALS MEDICAL CALL\n0217\nBM435 FR2  X49\n4846 HILLOCK LA, Hampstead, MD",
        "SRC:04",
        "ID:12018367",
        "CALL:ALS MEDICAL CALL",
        "MAP:0217",
        "UNIT:BM435 FR2 X49",
        "ADDR:4846 HILLOCK LA",
        "MADDR:4846 HILLOCK LN",
        "CITY:Hampstead");
    
  }
  
  @Test
  public void testManchesterFire3() {

    doTest("T1",
        "(Station 04 ALERT!! (13001221)) \n" +
        "BLS MEDICAL CALL\n" +
        "X49  FR2\n" +
        "0218\n" +
        "3941 SHILOH AV, Hampstead, MD\n" +
        "P HEADACHE CHEST PAIN ;25 YEAR OLD, FEMALE, CONSCIOUS, BREATHING.  CCN:10 DL:10A01 P",

        "SRC:04",
        "ID:13001221",
        "CALL:BLS MEDICAL CALL",
        "UNIT:X49 FR2",
        "MAP:0218",
        "ADDR:3941 SHILOH AV",
        "MADDR:3941 SHILOH AVE",
        "CITY:Hampstead",
        "INFO:P HEADACHE CHEST PAIN ;25 YEAR OLD, FEMALE, CONSCIOUS, BREATHING.  CCN:10 DL:10A01 P");

    doTest("T2",
        "(Station 04 ALERT!! (13001212)) \n" +
        "BLS MEDICAL CALL\n" +
        "X49\n" +
        "0419\n" +
        "3535 BACKWOODS RD, Westminster, MD\n" +
        "P BACK PAIN ;97 YEAR OLD, FEMALE, CONSCIOUS, BREATHING. -COMMENTS: X-  CCN:5 DL:05A01 P",

        "SRC:04",
        "ID:13001212",
        "CALL:BLS MEDICAL CALL",
        "UNIT:X49",
        "MAP:0419",
        "ADDR:3535 BACKWOODS RD",
        "CITY:Westminster",
        "INFO:P BACK PAIN ;97 YEAR OLD, FEMALE, CONSCIOUS, BREATHING. -COMMENTS: X-  CCN:5 DL:05A01 P");

    doTest("T3",
        "(Station 04 ALERT!! (13001199)) \nVEHICLE COLLISION\nX49  E43\n0410\nWAL MART @2320 HANOVER PKE, Hampstead, MD\n.",
        "SRC:04",
        "ID:13001199",
        "CALL:VEHICLE COLLISION",
        "UNIT:X49 E43",
        "MAP:0410",
        "PLACE:WAL MART",
        "ADDR:2320 HANOVER PKE",
        "MADDR:2320 HANOVER PIKE",
        "CITY:Hampstead");

    doTest("T4",
        "(Station 04 ALERT!! (13001191)) \n" +
        "ALS MEDICAL CALL\n" +
        "X49\n" +
        "0401\n" +
        "2973 MANCHESTER RD @MANCHESTER FAM MED, Manchester, MD\n" +
        "P CHEST PAIN ;72 YEAR OLD, MALE, CONSCIOUS, BREATHING.  CCN:10 DL:10C04 P",

        "SRC:04",
        "ID:13001191",
        "CALL:ALS MEDICAL CALL",
        "UNIT:X49",
        "MAP:0401",
        "PLACE:MANCHESTER FAM MED",
        "ADDR:2973 MANCHESTER RD",
        "CITY:Manchester",
        "INFO:P CHEST PAIN ;72 YEAR OLD, MALE, CONSCIOUS, BREATHING.  CCN:10 DL:10C04 P");

    doTest("T5",
        "(Station 04 ALERT!! (13001175)) \nALS MEDICAL CALL\nYA52-1 X79  FR4\n0419\n4030 RINEHART RD, Westminster, MD\n.",
        "SRC:04",
        "ID:13001175",
        "CALL:ALS MEDICAL CALL",
        "UNIT:YA52-1 X79 FR4",
        "MAP:0419",
        "ADDR:4030 RINEHART RD",
        "CITY:Westminster");

    doTest("T6",
        "(Station 04 ALERT!! (13001173)) \nVC RESCUE\nX69  X49  E61  RS6\n0603\n250 E DEEP RUN RD, Westminster, MD\n.",
        "SRC:04",
        "ID:13001173",
        "CALL:VC RESCUE",
        "UNIT:X69 X49 E61 RS6",
        "MAP:0603",
        "ADDR:250 E DEEP RUN RD",
        "CITY:Westminster");

    doTest("T7",
        "(Station 04 ALERT!! (13001169)) \n" +
        "ALS MEDICAL CALL\n" +
        "X49\n" +
        "0402\n" +
        "3295 CHARMIL DR, Manchester, MD\n" +
        "P SHARP PAIN IN THE BACK  ;55 YEAR OLD, MALE, CONSCIOUS, BREATHING. -COMMENTS: SHARP SHOOTING PAIN-  CCN:5 DL:05C03 P",

        "SRC:04",
        "ID:13001169",
        "CALL:ALS MEDICAL CALL",
        "UNIT:X49",
        "MAP:0402",
        "ADDR:3295 CHARMIL DR",
        "CITY:Manchester",
        "INFO:P SHARP PAIN IN THE BACK  ;55 YEAR OLD, MALE, CONSCIOUS, BREATHING. -COMMENTS: SHARP SHOOTING PAIN-  CCN:5 DL:05C03 P");

    doTest("T8",
        "(Station 04 ALERT!! (13001143)) \n" +
        "MUTUAL AID ALARM\n" +
        "E72  ET73  T2   X79  CAPT7 CF7  ET44  ET24  B46\n" +
        "YC\n" +
        "5333 TRUMP RD/BLOOMING GROVE STRUC 7-28              APT A-8\n" +
        ".",

        "SRC:04",
        "ID:13001143",
        "CALL:MUTUAL AID ALARM /BLOOMING GROVE STRUC 7-28",
        "APT:A-8",
        "UNIT:E72 ET73 T2 X79 CAPT7 CF7 ET44 ET24 B46",
        "MAP:YC",
        "ADDR:5333 TRUMP RD");

    doTest("T9",
        "(Station 04 ALERT!! (13001143)) \n" +
        "MUTUAL AID ALARM\n" +
        "E72  ET73  T2   X79  CAPT7 CF7  ET44  ET24\n" +
        "YC\n" +
        "5333 TRUMP RD/BLOOMING GROVE STRUC 7-28              APT A-8\n" +
        ".",

        "SRC:04",
        "ID:13001143",
        "CALL:MUTUAL AID ALARM /BLOOMING GROVE STRUC 7-28",
        "APT:A-8",
        "UNIT:E72 ET73 T2 X79 CAPT7 CF7 ET44 ET24",
        "MAP:YC",
        "ADDR:5333 TRUMP RD");

    doTest("T10",
        "(Station 04 ALERT!! (13001131)) \n" +
        "ALS MEDICAL CALL\n" +
        "X49  YA52-1\n" +
        "0418\n" +
        "706 LAKE DR, Westminster, MD\n" +
        "P T/B, LOWER GI BLEED ;66 YEAR OLD, FEMALE, CONSCIOUS, BREATHING.  CCN:6 DL:06D04 P",

        "SRC:04",
        "ID:13001131",
        "CALL:ALS MEDICAL CALL",
        "UNIT:X49 YA52-1",
        "MAP:0418",
        "ADDR:706 LAKE DR",
        "CITY:Westminster",
        "INFO:P T/B, LOWER GI BLEED ;66 YEAR OLD, FEMALE, CONSCIOUS, BREATHING.  CCN:6 DL:06D04 P");

    doTest("T11",
        "(Station 04 ALERT!! (13001109)) \nCO DETECTOR SOUNDING\nB25  ET44\n0206\n1805 UPPER FORDE LA, Hampstead, MD\n.",
        "SRC:04",
        "ID:13001109",
        "CALL:CO DETECTOR SOUNDING",
        "UNIT:B25 ET44",
        "MAP:0206",
        "ADDR:1805 UPPER FORDE LA",
        "MADDR:1805 UPPER FORDE LN",
        "CITY:Hampstead");

    doTest("T12",
        "(Station 04 ALERT!! (13001108)) \n" +
        "BUILDING FIRE\n" +
        "E23  BE432 E43  BE422 E91  T2   BT404 TO3  X29      CS4\n" +
        "0217\n" +
        "1003 SCARLET OAK CT                                  APT 1B, Hampstead, MD\n" +
        "PF SMOKE INSIDE APT ;STRUCTURE FIRE. CCN:69 DL:69D05 PF",

        "SRC:04",
        "ID:13001108",
        "CALL:BUILDING FIRE",
        "UNIT:E23 BE432 E43 BE422 E91 T2 BT404 TO3 X29 CS4",
        "MAP:0217",
        "ADDR:1003 SCARLET OAK CT",
        "APT:1B",
        "CITY:Hampstead",
        "INFO:PF SMOKE INSIDE APT ;STRUCTURE FIRE. CCN:69 DL:69D05 PF");

    doTest("T13",
        "(Station 04 ALERT!! (13001089)) \n" +
        "ALS MEDICAL CALL\n" +
        "X49\n" +
        "0405\n" +
        "3332 MAIN ST @LONG VIEW NH                           APT 224B, Manchester, MD\n" +
        "P CHEST PAIN ;83 YEAR OLD, MALE, CONSCIOUS, BREATHING.  CCN:10 DL:10D01 P",

        "SRC:04",
        "ID:13001089",
        "CALL:ALS MEDICAL CALL",
        "UNIT:X49",
        "MAP:0405",
        "PLACE:LONG VIEW NH",
        "ADDR:3332 MAIN ST",
        "APT:224B",
        "CITY:Manchester",
        "INFO:P CHEST PAIN ;83 YEAR OLD, MALE, CONSCIOUS, BREATHING.  CCN:10 DL:10D01 P");

    doTest("T14",
        "(Station 04 ALERT!! (13001082)) \n" +
        "BLS MEDICAL CALL\n" +
        "X49\n" +
        "0410\n" +
        "WAL MART @2320 HANOVER PKE ; OUTSIDE IN PARKING LOT, Hampstead, MD\n" +
        "P FELL IN PARKING LOT ;60 YEAR OLD, FEMALE, CONSCIOUS, BREATHING.  CCN:17 DL:17A01 DL SUF:G P",

        "SRC:04",
        "ID:13001082",
        "CALL:BLS MEDICAL CALL",
        "UNIT:X49",
        "MAP:0410",
        "PLACE:WAL MART",
        "ADDR:2320 HANOVER PKE",
        "MADDR:2320 HANOVER PIKE",
        "CITY:Hampstead",
        "INFO:OUTSIDE IN PARKING LOT / P FELL IN PARKING LOT ;60 YEAR OLD, FEMALE, CONSCIOUS, BREATHING.  CCN:17 DL:17A01 DL SUF:G P");

    doTest("T15",
        "(Station 04 ALERT!! (13001051)) \n" +
        "ALS MEDICAL CALL\n" +
        "X49  YA52-1\n" +
        "0417\n" +
        "2213 SCENIC VIEW DR, Manchester, MD\n" +
        "P SEIZURE ;22 YEAR OLD, FEMALE, UNCONSCIOUS, BREATHING.  CCN:12 DL:12D02 DL SUF:E P",

        "SRC:04",
        "ID:13001051",
        "CALL:ALS MEDICAL CALL",
        "UNIT:X49 YA52-1",
        "MAP:0417",
        "ADDR:2213 SCENIC VIEW DR",
        "CITY:Manchester",
        "INFO:P SEIZURE ;22 YEAR OLD, FEMALE, UNCONSCIOUS, BREATHING.  CCN:12 DL:12D02 DL SUF:E P");

    doTest("T16",
        "(Station 04 ALERT!! (13001029)) \n" +
        "LOCAL ALARM\n" +
        "E43  YE52-1\n" +
        "0419\n" +
        "3921 BIXLER CHURCH RD ; ACROSS THE STREET, Westminster, MD\n" +
        "PF BRUSH FIRE ;OUTSIDE FIRE. CCN:67 DL:67D03 PF",

        "SRC:04",
        "ID:13001029",
        "CALL:LOCAL ALARM",
        "UNIT:E43 YE52-1",
        "MAP:0419",
        "ADDR:3921 BIXLER CHURCH RD",
        "CITY:Westminster",
        "INFO:ACROSS THE STREET / PF BRUSH FIRE ;OUTSIDE FIRE. CCN:67 DL:67D03 PF");

    doTest("T17",
        "(Station 04 ALERT!! (13001027)) \nMUTUAL AID ALARM\nX49  E23\nBC\n43-6//4017 BLACKROCK RD // FALL //WEST\n.",
        "SRC:04",
        "ID:13001027",
        "CALL:MUTUAL AID ALARM 43-6 FALL WEST",
        "UNIT:X49 E23",
        "MAP:BC",
        "ADDR:4017 BLACKROCK RD");

    doTest("T18",
        "(Station 04 ALERT!! (13001018)) \n" +
        "BLS MEDICAL CALL\n" +
        "X49  FR2\n" +
        "0220\n" +
        "1211 N MAIN ST @RESIDENCE@HAMP SCHOL                 APT 405, Hampstead, MD\n" +
        "P FALL 80YOM  ;80 YEAR OLD, MALE, CONSCIOUS, BREATHING.  CCN:17 DL:17B01 P",

        "SRC:04",
        "ID:13001018",
        "CALL:BLS MEDICAL CALL",
        "UNIT:X49 FR2",
        "MAP:0220",
        "PLACE:RESIDENCE@HAMP SCHOL",
        "ADDR:1211 N MAIN ST",
        "APT:405",
        "CITY:Hampstead",
        "INFO:P FALL 80YOM  ;80 YEAR OLD, MALE, CONSCIOUS, BREATHING.  CCN:17 DL:17B01 P");

    doTest("T19",
        "(Station 04 ALERT!! (13001004)) \n" +
        "CARDIAC ARREST\n" +
        "X49  X29  E43\n" +
        "0403\n" +
        "2612 WASHINGTON WY, Manchester, MD\n" +
        "P UNCONSCIOUS ;47 YEAR OLD, MALE, UNCONSCIOUS, NOT BREATHING.  CCN:9 DL:09E01 P",

        "SRC:04",
        "ID:13001004",
        "CALL:CARDIAC ARREST",
        "UNIT:X49 X29 E43",
        "MAP:0403",
        "ADDR:2612 WASHINGTON WY",
        "CITY:Manchester",
        "INFO:P UNCONSCIOUS ;47 YEAR OLD, MALE, UNCONSCIOUS, NOT BREATHING.  CCN:9 DL:09E01 P");

    doTest("T20",
        "(Station 04 ALERT!! (13000979)) \n" +
        "ALS MEDICAL CALL\n" +
        "X49\n" +
        "0412\n" +
        "3003 WAREHIME RD, Manchester, MD\n" +
        "P HEART RACING, HX OF HEART ATTACK ;59 YEAR OLD, MALE, CONSCIOUS, BREATHING.  CCN:19 DL:19D04 P",

        "SRC:04",
        "ID:13000979",
        "CALL:ALS MEDICAL CALL",
        "UNIT:X49",
        "MAP:0412",
        "ADDR:3003 WAREHIME RD",
        "CITY:Manchester",
        "INFO:P HEART RACING, HX OF HEART ATTACK ;59 YEAR OLD, MALE, CONSCIOUS, BREATHING.  CCN:19 DL:19D04 P");

    doTest("T21",
        "(Station 04 ALERT!! (13000968)) \nBLS MEDICAL CALL\nX49\n0409\n2309 ALBERT RILL RD, Westminster, MD\n.",
        "SRC:04",
        "ID:13000968",
        "CALL:BLS MEDICAL CALL",
        "UNIT:X49",
        "MAP:0409",
        "ADDR:2309 ALBERT RILL RD",
        "CITY:Westminster");

  }
 
  public static void main(String[] args) {
    new MDBaltimoreCountyAParserTest().generateTests("T1");
  }
}