package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXBexarCountyParserTest extends BaseParserTest {
  
  public TXBexarCountyParserTest() {
    setParser(new TXBexarCountyParser(), "BEXAR COUNTY", "TX");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "Fire - Structure     - Stockport / Chipping           - 585E1 - comp states a house is on fire[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0105711,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000502. [Shared],Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000571. [Shared],Automatic Case Number(s) issued for Converse FD: CONV-2012-000000420. [Shared],Automatic Case Number(s) issued for Kirby FD: KIRB-2012-000000372. [Shared],",
        "CALL:Fire - Structure",
        "ADDR:Stockport & Chipping",
        "MAP:585E1",
        "ID:BCSO-2012-0105711",
        "INFO:comp states a house is on fire");

    doTest("T2",
        "Med - Sick Person         - 17694 Shepherd Rd              - 711F7   -  31 yo female...knee pain cause by past injury pt says it's a cut[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0107603,[BCLE] has closed their incident [BCSO-2012-0107603],Automatic Case Number(s) issued for Lytle FD: LYTL-2012-000000122. [Shared],This incident LYTL-2012-0010282 has been sent to ACADIAN via the CAD2CAD Interface",
        "CALL:Med - Sick Person",
        "ADDR:17694 Shepherd Rd",
        "MAP:711F7",
        "ID:BCSO-2012-0107603",
        "INFO:31 yo female...knee pain cause by past injury pt says it's a cut");

    doTest("T3",
        "Fire - Vehicle            Ih 10 W / Tarpon Dr            - 447A2   - engine smoking c has pulled to the side of the road...tan f350...wb on 10..doesn't seem to be leaking fluid[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:3511  AT&T MOBILITY-SE SECTOR-QF 446F.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:3511  AT&T MOBILITY-SE SECTOR-QF",
        "CALL:Fire - Vehicle",
        "ADDR:I 10 W & Tarpon Dr",
        "MAP:447A2",
        "INFO:engine smoking c has pulled to the side of the road...tan f350...wb on 10..doesn't seem to be leaking fluid");

    doTest("T4",
        "Fire - Structure     - Stockport / Chipping           - 585E1 - comp states a house is on fire[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0105711,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000502. [Shared],Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000571. [Shared],Automatic Case Number(s) issued for Converse FD: CONV-2012-000000420. [Shared],Automatic Case Number(s) issued for Kirby FD: KIRB-2012-000000372. [Shared]",
        "CALL:Fire - Structure",
        "ADDR:Stockport & Chipping",
        "MAP:585E1",
        "ID:BCSO-2012-0105711",
        "INFO:comp states a house is on fire");

    doTest("T5",
        "MVC                             W Loop 1604 S / Spurs Ranch     646B1    GVIL-2012-000001006  - crash, injuries, one car roll over.  On the access rd, sb side.[Shared],Invalid address received:61  SPRINT-N SECTOR-QF 646C4.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0107458,C is an off-duty officer with SAPD.  thinks the guy involved in crash is okay..but would like him checked out [Shared],Automatic Case Number(s)",
        "CALL:MVC",
        "ADDR:W Loop 1604 S & Spurs Ranch",
        "MAP:646B1",
        "ID:GVIL-2012-000001006",
        "INFO:crash, injuries, one car roll over.  On the access rd, sb side.,C is an off-duty officer with SAPD.  thinks the guy involved in crash is okay..but would like him checked out");

    doTest("T6",
        "Fire - Unauthorized Burn  9279 Aqua Dr                   - 447A3   - Unauth BUrning  to the left of location,Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000283.",
        "CALL:Fire - Unauthorized Burn",
        "ADDR:9279 Aqua Dr",
        "MAP:447A3",
        "ID:LSPR-2012-000000283",
        "INFO:Unauth BUrning  to the left of location");

    doTest("T7",
        "04/28 06:28 am - Med - Diabetic Problems   - 4455 Twin Valley            - 748E6   - C states her mother 72yo has low blood sugar..acad notifed[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0109820,Automatic Case Number(s) issued for Somerset FD: SOM-2012-000000292. [Shared],",
        "DATE:04/28",
        "TIME:06:28:00",
        "CALL:Med - Diabetic Problems",
        "ADDR:4455 Twin Valley",
        "MAP:748E6",
        "ID:BCSO-2012-0109820",
        "INFO:C states her mother 72yo has low blood sugar..acad notifed");

    doTest("T8",
        "MED - ASSAULT        - 7246 GLEN HILL                 - SA585 - ACADIAN: Unit:    740         9941959,ACADIAN: The cross street was verified by caller.,ACADIAN: Law enforcement on scene; it is safe for the crew to enter.,ACADIAN: assult to head unk age male,ACADIAN: [ProQA Session Aborted] Medical Professional,Transferred incident: Remote   Reference Number: 20120428-ZN16-0222 by Jacobs, Angela From ACADIAN,Interface has sent an ack message for CAM-2012-0010500 to the",
        "CALL:MED - ASSAULT",
        "ADDR:7246 GLEN HILL",
        "MAP:SA585",
        "ID:CAM-2012-0010500",
        "UNIT:740",
        "INFO:9941959,The cross street was verified by caller.,Law enforcement on scene; it is safe for the crew to enter.,assult to head unk age male, Angela From ACADIAN");

    doTest("T9",
        "Med - Unconscious Pe - 7838 Sun Forest                -       - 585C1   - 24 yo female went over to comps resd to visit his son; comp states female started drinking some wine and passed out; comp states she is breathing - does not know what to do with female[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0109700,This incident WIND-2012-0010491 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120428-ZN16-0059 [Shared],Unit - 76",
        "CALL:Med - Unconscious Pe",
        "ADDR:7838 Sun Forest",
        "MAP:585C1",
        "ID:BCSO-2012-0109700",
        "INFO:24 yo female went over to comps resd to visit his son; comp states female started drinking some wine and passed out; comp states she is breathing - does not know what to do with female,Unit - 76");

    doTest("T10",
        "Med - Sick Person    - 8216 Glen Boro                 - 553F8 - 50 YO F HAVING CHEST PAINS[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0109833,[BCLE] has closed their incident [BCSO-2012-0109833],Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000521. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:8216 Glen Boro",
        "MAP:553F8",
        "ID:BCSO-2012-0109833",
        "INFO:50 YO F HAVING CHEST PAINS");

    doTest("T11",
        "Fire                            6126 Kimble Mill                577D3    GVIL-2012-000001031  - C thinks the grease fire in his pit is getting out of hand.  in his backyard[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110061,C has turned off burners [Shared],Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001031. [Shared],",
        "CALL:Fire",
        "ADDR:6126 Kimble Mill",
        "MAP:577D3",
        "ID:GVIL-2012-000001031",
        "INFO:C thinks the grease fire in his pit is getting out of hand.  in his backyard,C has turned off burners");

    doTest("T12",
        "* BCFA Medical Emergency  - Ih 35 S Nb / Sb Ih 35 S Onrp S - 712A5   - unk where other fighters went[Shared],they have been drinking[Shared],no weapons[Shared],C says at los amigos there was a fight, three people are on the ground, req ems[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110791,Automatic Case Number(s) issued for Jarret FD: JARR-2012-000000207. [Shared],",
        "CALL:BCFA Medical Emergency",
        "ADDR:I 35 S Nb & Sb I 35 S Onrp S",
        "MADDR:I 35 S & I 35 S Onrp S",
        "MAP:712A5",
        "ID:BCSO-2012-0110791",
        "INFO:unk where other fighters went,they have been drinking,no weapons,C says at los amigos there was a fight, three people are on the ground, req ems");

    doTest("T13",
        "Med - Possible Stroke           12446 Modena Bay                577D6    GVIL-2012-000001047  - 66 yom- poss stroke- acad advised[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110913,This incident GVIL-2012-0010627 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120429-ZN16-1184 [Shared],Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001047. [Shared],",
        "CALL:Med - Possible Stroke",
        "ADDR:12446 Modena Bay",
        "MAP:577D6",
        "ID:GVIL-2012-000001047",
        "INFO:66 yom- poss stroke- acad advised");

    doTest("T14",
        "MVC                       - 23101 - 24511 Campbellton - HICKORY WAY/RANCH TRAIL RD               - 783D1 - small dark colored suv[Shared],going north on cambellton, it will be on the left[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:1453  TMOBILE-SE SECTOR-QF 751A2.[Shared],C disconnected[Shared],C says there is a car, unoccupied, flipped over.[Shared],Invalid address received:1453  TMOBILE-SE SECTOR-QF 751A2.[Shared],A cellular re-bid has occurre",
        "CALL:MVC",
        "ADDR:23101-24511 Campbellton",
        "MADDR:23101 Campbellton",
        "X:HICKORY WAY/RANCH TRAIL RD",
        "MAP:783D1",
        "INFO:small dark colored suv,going north on cambellton, it will be on the left,C disconnected,C says there is a car, unoccupied, flipped over");

    doTest("T15",
        "Med - Sick Person    - 6739 Glen Fair                 - 553E7 - C says her niece had a seizure, 34 yo.  fell onto concrete[Shared],Invalid address received:343  SPRINT-E SECTOR-QF 553C8.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110931,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000525. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:6739 Glen Fair",
        "MAP:553E7",
        "ID:BCSO-2012-0110931",
        "INFO:C says her niece had a seizure, 34 yo.  fell onto concrete");

    doTest("T16",
        "Alarm - Fire         - 9503 Millers Rdg               -       - 553E7   - POE;SMOKE DETECTOR;JOHN GILG @ 653-7947[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0111024,Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000599. [Shared],Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000527. [Shared],Automatic Case Number(s) issued for Converse FD: CONV-2012-000000442. [Shared],",
        "CALL:Alarm - Fire",
        "ADDR:9503 Millers Rdg",
        "MAP:553E7",
        "ID:BCSO-2012-0111024",
        "INFO:POE;SMOKE DETECTOR;JOHN GILG @ 653-7947");

    doTest("T17",
        "Med - Sick Person         - 16927 Ih 35 S Sb               - 711E6   -  23 YOF POSSIBLE BROKEN FOOT/FELL DOWN[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0112109,[BCLE] has closed their incident [BCSO-2012-0112109],Automatic Case Number(s) issued for Lytle FD: LYTL-2012-000000126. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:16927 I 35 S Sb",
        "MADDR:16927 I 35 S",
        "MAP:711E6",
        "ID:BCSO-2012-0112109",
        "INFO:23 YOF POSSIBLE BROKEN FOOT/FELL DOWN");

    doTest("T18",
        "Alarm                - 8210 Ih 35 N                  -       - 552E8   Dept-E108,C145,E145B,120A - Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000612.,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000547.,FIRE ALARM-RED LOBSTERS REST.,Backed up C145 with E145B,SINGLE STORY LIGHT SMOKE SHOWING AND SMOKE IN KITCHEN,Automatic Case Number(s) issued for Gardendale FD: GARD-2012-000000134.,",
        "CALL:Alarm",
        "ADDR:8210 I 35 N",
        "MAP:552E8",
        "ID:WIND-2012-000000612",
        "UNIT:E108,C145,E145B,120A",
        "INFO:FIRE ALARM-RED LOBSTERS REST.,Backed up C145 with E145B,SINGLE STORY LIGHT SMOKE SHOWING AND SMOKE IN KITCHEN");

    doTest("T19",
        "Med - Sick Person               9615 Rainbow Crk                612C5      GVIL-2012-000001138  Dept-123C - Multi-Agency BCLE Incident #: BCSO-2012-0118460,Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001138. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:9615 Rainbow Crk",
        "MAP:612C5",
        "ID:GVIL-2012-000001138",
        "UNIT:123C");

    doTest("T20",
        "Med - Sick Person         - 1460 Martinez Losoya           # SRST  - 717B8 Dept-141E - 6 YO F BROKE ARM[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0118435,Automatic Case Number(s) issued for South Bexar FD: SOBX-2012-000000251. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:1460 Martinez Losoya",
        "APT:SRST",
        "MAP:717B8",
        "ID:BCSO-2012-0118435",
        "UNIT:141E",
        "INFO:6 YO F BROKE ARM");

    doTest("T21",
        "Alarm - Fire              - 7406 Scintilla                 - 413F8   Dept-133A,126E,SPK activated general fire alarm,borene pd called this one in,Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000339.,Automatic Case Number(s) issued for Grey Forest FD: GRYF-2012-000000169.,",
        "CALL:Alarm - Fire",
        "ADDR:7406 Scintilla",
        "MAP:413F8",
        "ID:LSPR-2012-000000339",
        "UNIT:133A,126E,SPK",
        "INFO:activated general fire alarm,borene pd called this one in");

    doTest("T22",
        "Med - Diabetic Problems   - 14085 Ih 35 S                  - 713B2   Dept-130C 67 yof diabetic feeling light headed[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0119030,This incident JARR-2012-0011429 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120508-ZN16-0205 [Shared],Unit - 709, status change to STATUS_DISPATCHED by ACADIAN at 05/08/2012 04:33:59 [Shared],trlr 15 [Shared],[BCLE] has closed their incident [BCSO-2012-011903",
        "CALL:Med - Diabetic Problems",
        "ADDR:14085 I 35 S",
        "MAP:713B2",
        "ID:BCSO-2012-0119030",
        "UNIT:130C",
        "INFO:67 yof diabetic feeling light headed,Unit - 709,trlr 15");

    doTest("T23",
        "Med - Cardiac Arrest            2918 FISHERS GLADE              SA612/F8   GVIL-2012-000001157  Dept-123B - ACADIAN: Unit:    734         9963763,Transferred incident: Remote   Reference Number: 20120508-ZN16-0370 by Brunson, Savannah L. From ACADIAN,Interface has sent an ack message for GVIL-2012-0011432 to the remote CAD,9963763,This incident 20120508-ZN16-0370 has been sent to BCFA via the CAD2CAD Interface.,Unit - 734, status change to STATUS_RESPONDING by ACADIAN at 05/08/2012 06:25:35,Automatic Case Number",
        "CALL:Med - Cardiac Arrest",
        "ADDR:2918 FISHERS GLADE",
        "MAP:SA612/F8",
        "ID:GVIL-2012-000001157",
        "UNIT:123B 734",
        "INFO:9963763 - Savannah L. From ACADIAN,9963763,Unit - 734");

    doTest("T24",
        "Med - Sick Person    - 8510 WINDY CROSS               -       - SA553/C Dept-145D - ACADIAN: Unit:    735         9975423,Transferred incident: Remote   Reference Number: 20120513-ZN16-0481 by Reed, Juliana E. From ACADIAN,Interface has sent an ack message for WIND-2012-0011843 to the remote CAD,9975423,This incident 20120513-ZN16-0481 has been sent to BCFA via the CAD2CAD Interface.,ACADIAN HAS CHANGED the CALL BACK PHONE# to:,Automatic Case Number(s) issued for Windcrest FD: WIND-2012-0",
        "CALL:Med - Sick Person",
        "ADDR:8510 WINDY CROSS",
        "MAP:SA553/C",
        "ID:WIND-2012-0011843",
        "UNIT:145D 735",
        "INFO:9975423, Juliana E. From ACADIAN,9975423");

    doTest("T25",
        "Med - Heart Problems - 8835 WILLMON WAY               -       - SA552/F Dept-145A - ACADIAN: The cross street was verified by caller.,ACADIAN: Unit:    733         9975214,ACADIAN: The patient's weight is below 300 pounds.,ACADIAN: [ProQA Script] Dispatch code: 19D02  You are responding to a patient  with heart problems.  The patient is a  66-year-old female, who is    conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  Heart Problems / A.I.C.D..  DIFFICULTY SPE,AKING BETWEEN",
        "CALL:Med - Heart Problems",
        "ADDR:8835 WILLMON WAY",
        "MAP:SA552/F",
        "CODE:19D02",
        "UNIT:145A 733",
        "INFO:The cross street was verified by caller - 9975214,The patient's weight is below 300 pounds - You are responding to a patient - with heart problems - The patient is a - 66-year-old female, who is - conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  Heart Problems / A.I.C.D..  DIFFICULTY SPE,AKING BETWEEN");

  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "07:37 - Med - Sick Person              - 206 Donella Dr                           -           -Case - HPK-2012-000000230   - 69 YO F FELL AND CANT GET UP[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0138384,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000230. [Shared],",
        "TIME:07:37",
        "CALL:Med - Sick Person",
        "ADDR:206 Donella Dr",
        "X:- -Case & HPK-2012-000000230 & 69 YO F FELL AND CANT GET UP[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0138384,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000230. [Shared],");

    doTest("T2",
        "07:42 - Assist - Law Enforcement       - Sun Way Dr / El Cerrito Cir              -           -Case - HPK-2012-000000231   - 9217s  thousand oaks/us hwy 281 egg and i restaraunt[Shared],9217s  looking around us hwy 281/mecca. person said heading towards 1604 bleeding from head[Shared],SUBJ STATED HE STARTED A NEW MEDS AND HE IS TRYING TO FIND HIS PARENTS HOUSE[Shared],W/M/DK HAIR/SHIRT BLK/SHORT RED/SANDLES. COMP STATES THAT THE SUBJ CAME UP TO HER AND STATED HE LOST HIS GLASSES AND IS CONFUSED. WALKING TOWARDS US HWY 281[Shared",
        "TIME:07:42",
        "CALL:Assist - Law Enforcement",
        "ADDR:Sun Way Dr & El Cerrito Cir",
        "X:- -Case & HPK-2012-000000231 & 9217s  thousand oaks/us hwy 281 egg and i restaraunt[Shared],9217s  looking around us hwy 281/mecca. person said heading towards 1604 bleeding from head[Shared],SUBJ STATED HE STARTED A NEW MEDS AND HE IS TRYING TO FIND HIS PARENTS HOUSE[Shared],W/M/DK HAIR/SHIRT BLK/SHORT RED/SANDLES. COMP STATES THAT THE SUBJ CAME UP TO HER AND STATED HE LOST HIS GLASSES AND IS CONFUSED. WALKING TOWARDS US HWY 281[Shared");

    doTest("T3",
        "17:26 - Assist - Lift                  - 339 Donella Dr                           -           -Case - HPK-2012-000000229   - 98 yo female...lift assist only[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0137362,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000229. [Shared],",
        "TIME:17:26",
        "CALL:Assist - Lift",
        "ADDR:339 Donella Dr",
        "X:- -Case & HPK-2012-000000229 & 98 yo female...lift assist only[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0137362,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000229. [Shared],");

    doTest("T4",
        "Alarm - Fire                    3920 Beckwood Dr                                      484B5 - HPK-2012-000000232   Dept-104D,129E,SPK - AUD. \"FAWCETT, TOM GRACE\" POE: GEN FIRE. 210-402-0240 NO ADD INFO[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0139715,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000679. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000232. [Shared],",
        "CALL:Alarm - Fire",
        "ADDR:3920 Beckwood Dr",
        "MAP:484B5",
        "ID:HPK-2012-000000232",
        "UNIT:104D,129E,SPK",
        "INFO:AUD. \"FAWCETT, TOM GRACE\" POE: GEN FIRE. 210-402-0240 NO ADD INFO");

    doTest("T5",
        "Alarm - Fire         - 9311 Durham Trace              - 546A6   - GVIL-2012-000001346  - 115B,128E,122E   05:02 pm",
        "CALL:Alarm - Fire",
        "ADDR:9311 Durham Trace",
        "MAP:546A6",
        "ID:GVIL-2012-000001346",
        "INFO:115B,128E,122E   05:02 pm");

    doTest("T6",
        "18:38 - Alarm - Fire                   - 155 William Classen Dr                   -           -Case - BBUL-2012-000000681  - Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000233.,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000681.,",
        "TIME:18:38",
        "CALL:Alarm - Fire",
        "ADDR:155 William Classen Dr",
        "X:- -Case & BBUL-2012-000000681 & Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000233.,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000681.,");

    doTest("T7",
        "Fire                            3606 Sausalito Fern                                   452A8 - HPK-2012-000000234   Dept-129A,104D - comp says she sees smoke coming from wash room area. said not washer or dryer can smell the smoke[Shared],Invalid address received:83  SPRINT-NE SECTOR-QF 483D2.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0140833,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000682. [Shared],Automatic Case Number(s) issu",
        "CALL:Fire",
        "ADDR:3606 Sausalito Fern",
        "MAP:452A8",
        "ID:HPK-2012-000000234",
        "UNIT:129A,104D",
        "INFO:comp says she sees smoke coming from wash room area. said not washer or dryer can smell the smoke");

    doTest("T8",
        "15:47 - Med - Back Pain                - 30 Amber Forest                          -           -Case - HPK-2012-000000235   - 36 YOM- HURT BACK- NOT ABLE TO GET OUT OF CHAIR[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:3117  AT&T MOBILITY-N SECTOR-QF 581D4.[Shared],Invalid address received:3117  AT&T MOBILITY-N SECTOR-QF 581D4.[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0142020,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000235. [Shared],",
        "TIME:15:47",
        "CALL:Med - Back Pain",
        "ADDR:30 Amber Forest",
        "X:- -Case & HPK-2012-000000235 & 36 YOM- HURT BACK- NOT ABLE TO GET OUT OF CHAIR[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:3117  AT&T MOBILITY-N SECTOR-QF 581D4.[Shared],Invalid address received:3117  AT&T MOBILITY-N SECTOR-QF 581D4.[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0142020,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000235. [Shared],");

    doTest("T9",
        "15:54 - Alarm - Fire                   - 16315 Us Hwy 281 N                       -           -Case - BBUL-2012-000000692  - Multi-Agency BCLE Incident #: HPPD-2012-0142027,comm fire alarm...poe/general fire alarm...bus/Holiday Inn...bus./210-402-3300 [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000236. [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000692. [Shared],",
        "TIME:15:54",
        "CALL:Alarm - Fire",
        "ADDR:16315 Us Hwy 281 N",
        "MADDR:16315 Us 281 N",
        "X:- -Case & BBUL-2012-000000692 & Multi-Agency BCLE Incident #: HPPD-2012-0142027,comm fire alarm...poe/general fire alarm...bus/Holiday Inn...bus./210-402-3300 [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000236. [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000692. [Shared],");

    doTest("T10",
        "23:41 - Med - Sick Person              - 328 El Portal                            -           -Case - HPK-2012-000000237   - 75 YOF HAVING HEART PAINS[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0142337,This incident HPK-2012-0013604 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120601-ZN16-2014 [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000237. [Shared],Unit - 776, status change to STATUS_DISPATCHED by ACADIAN at 06/01/2012 23:41:17 [Sha",
        "TIME:23:41",
        "CALL:Med - Sick Person",
        "ADDR:328 El Portal",
        "X:- -Case & HPK-2012-000000237 & 75 YOF HAVING HEART PAINS[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0142337,This incident HPK-2012-0013604 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120601-ZN16-2014 [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000237. [Shared],Unit & 776, status change to STATUS_DISPATCHED by ACADIAN at 06/01/2012 23:41:17 [Sha");

    doTest("T11",
        "Alarm - Fire                    25630 Indian Summer                                   450D8 - HPK-2012-000000238   Dept-103C,129E,SPK - Phone #:210-481-3208[Shared],Name of the resident:Glen & Barbara Johnson.[Shared],Fire alarm.  Smoke detector.  unk location.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0142845,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000695. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000238. [Shared],",
        "CALL:Alarm - Fire",
        "ADDR:25630 Indian Summer",
        "MAP:450D8",
        "ID:HPK-2012-000000238",
        "UNIT:103C,129E,SPK",
        "INFO:Phone #:210-481-3208,Name of the resident:Glen & Barbara Johnson.,Fire alarm.  Smoke detector.  unk location");

    doTest("T12",
        "18:56 - Alarm - Medical                - 131 SUN WAY DR                           -           -Case - HPK-2012-000000239   - ACADIAN: The cross street was verified by caller.,ACADIAN: Unit:    740         10039768,Transferred incident: Remote   Reference Number: 20120602-ZN16-1270 by Barron, Ricardo From ACADIAN,Interface has sent an ack message for HPK-2012-0013670 to the remote CAD,10039768,This incident 20120602-ZN16-1270 has been sent to BCFA via the CAD2CAD Interface.,unknown medical alarm,ACADIAN HAS CHANGED CALLER to:Acad",
        "TIME:18:56",
        "CALL:Alarm - Medical",
        "ADDR:131 SUN WAY DR",
        "X:- -Case & HPK-2012-000000239 & ACADIAN: The cross street was verified by caller.,ACADIAN: Unit: 740 & 10039768,Transferred incident: Remote   Reference Number: 20120602-ZN16-1270 by Barron, Ricardo From ACADIAN,Interface has sent an ack message for HPK-2012-0013670 to the remote CAD,10039768,This incident 20120602-ZN16-1270 has been sent to BCFA via the CAD2CAD Interface.,unknown medical alarm,ACADIAN HAS CHANGED CALLER to:Acad");

    doTest("T13",
        "Alarm - Fire                   ; 28300 Us Hwy 281  N                           ;       ; 451E2 ; HPK-2012-000000240   Dept-103D,129E,SPK ;  Activated Fire Alarm,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000700.,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000240.,",
        "CALL:Alarm - Fire",
        "ADDR:28300 Us Hwy 281  N",
        "MADDR:28300 Us 281  N",
        "MAP:451E2",
        "ID:HPK-2012-000000240",
        "UNIT:103D,129E,SPK",
        "INFO:Activated Fire Alarm");

    doTest("T14",
        "16:06 - MED - ASSAULT                  - 310 Yosemite                             -           -Case - HPK-2012-000000241   - DISTURBANCE[Shared],subj is outside loc[Shared],c states w/f- grey shirt and jeans told c that her son ranaway- subj has been wandering around in the neighborhood looking for him- c states subj has asthma and is over heated- ref ems req ofc[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0144505,SCENE IS NOT SECURE,EMS ENROUTE [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-0000002",
        "TIME:16:06",
        "CALL:MED - ASSAULT",
        "ADDR:310 Yosemite",
        "X:- -Case & HPK-2012-000000241 & DISTURBANCE[Shared],subj is outside loc[Shared],c states w/f- grey shirt and jeans told c that her son ranaway- subj has been wandering around in the neighborhood looking for him- c states subj has asthma and is over heated- ref ems req ofc[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0144505,SCENE IS NOT SECURE,EMS ENROUTE [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-0000002");

    doTest("T15",
        "17:22 - Med - Sick Person              - 17319 Us Hwy 281 N                       - SUITE 400 -Case - HPK-2012-000000242   - comp is not with the pt[Shared],60 yof complaining of a headache and high blood sugar; comp states the pt is breathing heavily[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0144554,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000242. [Shared],",
        "TIME:17:22",
        "CALL:Med - Sick Person",
        "ADDR:17319 Us Hwy 281 N",
        "MADDR:17319 Us 281 N",
        "X:SUITE 400 -Case & HPK-2012-000000242 & comp is not with the pt[Shared],60 yof complaining of a headache and high blood sugar; comp states the pt is breathing heavily[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0144554,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000242. [Shared],");

    doTest("T16",
        "Med - Chest Pain               - 144 BLUET LN                             -            - 12:34-Case - HPK-2012-000000243   - ACADIAN: Unit:    738         10044990,ACADIAN: The patient's weight is below 300 pounds.  83 yo male,ACADIAN: home health nurse is on scene,ACADIAN: 160/94  pt has taken 1 nitro,Transferred incident: Remote   Reference Number: 20120605-ZN16-1057 by Brunson, Savannah L. From ACADIAN,Interface has sent an ack message for BCFAO-2012-0013893 to the remote CAD,This incident 20120605-ZN16-1057 has been sent to",
        "CALL:Med - Chest Pain",
        "ADDR:144 BLUET LN",
        "X:12:34-Case & HPK-2012-000000243 & ACADIAN: Unit: 738 & 10044990,ACADIAN: The patient's weight is below 300 pounds.  83 yo male,ACADIAN: home health nurse is on scene,ACADIAN: 160/94  pt has taken 1 nitro,Transferred incident: Remote   Reference Number: 20120605-ZN16-1057 by Brunson, Savannah L. From ACADIAN,Interface has sent an ack message for BCFAO-2012-0013893 to the remote CAD,This incident 20120605-ZN16-1057 has been sent to");

    doTest("T17",
        "Med - Sick Person              - 700 EL PORTAL                            -            - 07:53-Case - HPK-2012-000000244   - voyt park inj child[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0145967,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000244. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:700 EL PORTAL",
        "X:07:53-Case & HPK-2012-000000244 & voyt park inj child[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0145967,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000244. [Shared],");

    doTest("T18",
        "Alarm - Fire         - 25302 Miranda Rdg              : 446A8   Dept 132E,126C,128E 01:25 pm - bedroom #4[Shared],childs resd aud 210-557-1420 poe gas alarm[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0146472,Automatic Case Number(s) issued for Grey Forest FD: GRYF-2012-000000200. [Shared],Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000430. [Shared],Automatic Case Nu",
        "CALL:Alarm - Fire",
        "ADDR:25302 Miranda Rdg",
        "X:: 446A8 & Dept 132E,126C,128E 01:25 pm & bedroom #4[Shared],childs resd aud 210-557-1420 poe gas alarm[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0146472,Automatic Case Number(s) issued for Grey Forest FD: GRYF-2012-000000200. [Shared],Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000430. [Shared],Automatic Case Nu");

    doTest("T19",
        "MVC                            - N Loop 1604 E / Stone Oak Pkwy           -            - 20:08-Case - HPK-2012-000000245   - mv ped acc........valero plot........chevy tahoe......unk lp...>[Shared][Shared],Multi-Agency SAFD Incident #: 120606-0390,caller stated tosapd, this will be in the pklot of valero, which is in hollywood park,Secondary Location for 3130B: ON INFO.... [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000245. [Shared],",
        "CALL:MVC",
        "ADDR:N Loop 1604 E & Stone Oak Pkwy",
        "X:20:08-Case & HPK-2012-000000245 & mv ped acc........valero plot........chevy tahoe......unk lp...>[Shared][Shared],Multi-Agency SAFD Incident #: 120606-0390,caller stated tosapd, this will be in the pklot of valero, which is in hollywood park,Secondary Location for 3130B: ON INFO.... [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000245. [Shared],");

    doTest("T20",
        "Alarm - Medical                - 104 Garrapata Ln                         -            - 10:04-Case - HPK-2012-000000247   - Multi-Agency BCLE Incident #: HPPD-2012-0147298,aud  medical alarm res/martha falke #4948180  83 yoa  [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000247. [Shared],",
        "CALL:Alarm - Medical",
        "ADDR:104 Garrapata Ln",
        "X:10:04-Case & HPK-2012-000000247 & Multi-Agency BCLE Incident #: HPPD-2012-0147298,aud  medical alarm res/martha falke #4948180  83 yoa  [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000247. [Shared],");

    doTest("T21",
        "Alarm - Fire                   - 155 William Classen Dr                   -            - 11:11-Case - BBUL-2012-000000719  - Multi-Agency BCLE Incident #: HPPD-2012-0147396,AUD   BUS/GURINSKY JEWELRY #7222776  POE/FIRE ALARM DOWNSTAIRS SMOKE [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000248. [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000719. [Shared],",
        "CALL:Alarm - Fire",
        "ADDR:155 William Classen Dr",
        "X:11:11-Case & BBUL-2012-000000719 & Multi-Agency BCLE Incident #: HPPD-2012-0147396,AUD   BUS/GURINSKY JEWELRY #7222776  POE/FIRE ALARM DOWNSTAIRS SMOKE [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000248. [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000719. [Shared],");

    doTest("T22",
        "Alarm - Fire         - 10734 Shaenview                - 546B6   - GVIL-2012-000001421  - 115C,128E,122E   04:26 pm",
        "CALL:Alarm - Fire",
        "ADDR:10734 Shaenview",
        "MAP:546B6",
        "ID:GVIL-2012-000001421",
        "INFO:115C,128E,122E   04:26 pm");

    doTest("T23",
        "Alarm - Fire                    5819 Culberson Mill             577C4      HELO-2012-000000095  Dept-115E,122C,128E - aud. fire alarm. flores,marvin. 830-255-0398. no answer on call back[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0148428,Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001427. [Shared],Automatic Case Number(s) issued for District 7 FD: D7FR-2012-000000421. [Shared],Automatic Case Number(s) issued for Helotes FD: HELO-2012-000000095. [Shared],",
        "CALL:Alarm - Fire",
        "ADDR:5819 Culberson Mill",
        "MAP:577C4",
        "ID:HELO-2012-000000095",
        "UNIT:115E,122C,128E",
        "INFO:aud. fire alarm. flores,marvin. 830-255-0398. no answer on call back");

    doTest("T24",
        "Alarm - Fire                   ; 24811 Bogey Rdg                               ;Apt      ; 482F1 ; HPK-2012-000000249   Dept 103D,129E,SPK ;  Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000726.,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000249.,",
        "CALL:Alarm - Fire",
        "ADDR:24811 Bogey Rdg",
        "MAP:482F1",
        "ID:HPK-2012-000000249",
        "UNIT:103D,129E,SPK");

    doTest("T25",
        "Alarm - Fire                   ; 26003 Scenic Pass                             ;Apt      ; 450D6 ; HPK-2012-000000250   Dept 103B,129E,SPK ;  Bradley and Erin Machik  #830-438-6869[Shared],Fire panic alarm[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149032,ref 08723751 [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000728. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000250. [Shared],",
        "CALL:Alarm - Fire",
        "ADDR:26003 Scenic Pass",
        "MAP:450D6",
        "ID:HPK-2012-000000250",
        "UNIT:103B,129E,SPK",
        "INFO:Bradley and Erin Machik  #830-438-6869,Fire panic alarm,ref 08723751");

    doTest("T26",
        "Med - Sick Person              - 319 Yosemite                             -            - 05:18-Case - HPK-2012-000000251   - Multi-Agency BCLE Incident #: HPPD-2012-0149261,60yr old heart patient...bleeding from the biopsy from the bone marrow he had [Shared],This incident HPK-2012-0014258 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120609-ZN16-0283 [Shared],Unit - 731, status change to STATUS_DISPATCHED by ACADIAN at 06/09/2012 05:18:30 [Shared],Automatic Case Number(s) i",
        "CALL:Med - Sick Person",
        "ADDR:319 Yosemite",
        "X:05:18-Case & HPK-2012-000000251 & Multi-Agency BCLE Incident #: HPPD-2012-0149261,60yr old heart patient...bleeding from the biopsy from the bone marrow he had [Shared],This incident HPK-2012-0014258 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120609-ZN16-0283 [Shared],Unit & 731, status change to STATUS_DISPATCHED by ACADIAN at 06/09/2012 05:18:30 [Shared],Automatic Case Number(s) i");

    doTest("T27",
        "Med - Breathing Problems       - 153 Grand Oak                            -            - 22:01-Case - HPK-2012-000000252   - C is having trouble breathing, 88 yo female.[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0149710,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000252. [Shared],",
        "CALL:Med - Breathing Problems",
        "ADDR:153 Grand Oak",
        "X:22:01-Case & HPK-2012-000000252 & C is having trouble breathing, 88 yo female.[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0149710,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000252. [Shared],");

    doTest("T28",
        "Med - Fall                     - 230 Yosemite                             -            - 23:27-Case - HPK-2012-000000253   - fell coming out of the shower[Shared],female fell bump back of head[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0149768,88yo [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000253. [Shared],",
        "CALL:Med - Fall",
        "ADDR:230 Yosemite",
        "X:23:27-Case & HPK-2012-000000253 & fell coming out of the shower[Shared],female fell bump back of head[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0149768,88yo [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000253. [Shared],");

  }
  
  @Test
  public void testNewParser() {

    doTest("T1",
        "Med - Sick Person              ; 21746 Thunder Basin                           ;       ; 485B5 ; BBUL-2012-000000701  Dept-104B ;  mother is Emma Gardley, 90 yo.[Shared],C says his mother is mentally unstable, possibly violent, he cannot control her.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143660,This incident BBUL-2012-0013756 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120603-ZN16-1062 [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000701",
        "CALL:Med - Sick Person",
        "ADDR:21746 Thunder Basin",
        "MAP:485B5",
        "ID:BBUL-2012-000000701",
        "UNIT:104B",
        "INFO:mother is Emma Gardley, 90 yo.,C says his mother is mentally unstable, possibly violent, he cannot control her");

    doTest("T2",
        "MVC                            ; Us Hwy 281 N / Bulverde Rd                    ;       ; 451D6 ; BBUL-2012-000000702  Dept-103D ;  sb side gold tahoe vs blk car /female with neck pain[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143974,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000702. [Shared],unk age of female [Shared],",
        "CALL:MVC",
        "ADDR:Us Hwy 281 N & Bulverde Rd",
        "MADDR:Us 281 N & Bulverde Rd",
        "MAP:451D6",
        "ID:BBUL-2012-000000702",
        "UNIT:103D",
        "INFO:sb side gold tahoe vs blk car /female with neck pain,unk age of female");

    doTest("T3",
        "Med - Choking                  ; 734 Ottawa Way St                             ;       ; 451A4 ; BBUL-2012-000000699  Dept-103D ;  35 yo.[Shared],C says that her father has a bone in his throat, choking.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143557,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000699. [Shared],",
        "CALL:Med - Choking",
        "ADDR:734 Ottawa Way St",
        "MAP:451A4",
        "ID:BBUL-2012-000000699",
        "UNIT:103D",
        "INFO:35 yo.,C says that her father has a bone in his throat, choking");

    doTest("T4",
        "MVC - OTV                      ; 21415 Battle Crk                              ;       ; 484E6 ; BBUL-2012-000000698  Dept-104A ;  C says a pickup truck crashed, behind loc.  unk injuries.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143514,white pickup [Shared],the vehicle crashed into some trees, vehicle is turned over [Shared],C says he may be trapped in the vehicle, people are attempting to get him out [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000698. [Shared],",
        "CALL:MVC - OTV",
        "ADDR:21415 Battle Crk",
        "MAP:484E6",
        "ID:BBUL-2012-000000698",
        "UNIT:104A",
        "INFO:C says a pickup truck crashed, behind loc.  unk injuries.,white pickup ,the vehicle crashed into some trees, vehicle is turned over ,C says he may be trapped in the vehicle, people are attempting to get him out");

    doTest("T5",
        "Med - Sick Person              ; 849 Pine Eagle Ln                             ;       ; 451A4 ; BBUL-2012-000000704  Dept 103D ;  female trouble breathing 64yo[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0144879,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000704. [Shared],This incident BBUL-2012-0013867 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:849 Pine Eagle Ln",
        "MAP:451A4",
        "ID:BBUL-2012-000000704",
        "UNIT:103D",
        "INFO:female trouble breathing 64yo");

    doTest("T6",
        "Med - Fall                     ; 855 Tecumseh Dr                               ;       ; 451A3 ; BBUL-2012-000000708  Dept 103C ;  68 yo female...fall now has sever body pain...170lb[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0145684,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000708. [Shared], ",
        "CALL:Med - Fall",
        "ADDR:855 Tecumseh Dr",
        "MAP:451A3",
        "ID:BBUL-2012-000000708",
        "UNIT:103C",
        "INFO:68 yo female...fall now has sever body pain...170lb");

    doTest("T7",
        "Med - Sick Person              ; 23238 Bison Canyon                            ;Apt      ; 484B3 ; BBUL-2012-000000723  Dept 104A ;  50 yom fell; and is sweating[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0148106,acadian notified [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000723. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:23238 Bison Canyon",
        "MAP:484B3",
        "ID:BBUL-2012-000000723",
        "UNIT:104A",
        "INFO:50 yom fell; and is sweating,acadian notified");

    doTest("T8",
        "Alarm - Fire                   ; 24811 Bogey Rdg                               ;Apt      ; 482F1 ; HPK-2012-000000249   Dept 103D,129E,SPK ;  Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000726.,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000249.,",
        "CALL:Alarm - Fire",
        "ADDR:24811 Bogey Rdg",
        "MAP:482F1",
        "ID:HPK-2012-000000249",
        "UNIT:103D,129E,SPK");

    doTest("T9",
        "Med - Chest Pain               ; 24539 Glass Canyon                            ;Apt      ; 482F1 ; BBUL-2012-000000729  Dept 104B ;  41 yo male, having chest pains.[Shared],Invalid address received:1  VERIZON-SE SECTOR-QF 450E7.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149066,awake and responsive [Shared],This incident BBUL-2012-0014236 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120608-ZN16-2020",
        "CALL:Med - Chest Pain",
        "ADDR:24539 Glass Canyon",
        "MAP:482F1",
        "ID:BBUL-2012-000000729",
        "UNIT:104B",
        "INFO:41 yo male, having chest pains.,awake and responsive");

    doTest("T10",
        "Med - Seizure                  ; 4527 Echo Grove                               ;Apt      ; 484D6 ; BBUL-2012-000000730  Dept 104E ;  29 yoa female seizure[Shared],Invalid address received:3073  AT&T MOBILITY-SW SECTOR-QF 550F.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149117,starting to come out of it [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000730. [Shared],",
        "CALL:Med - Seizure",
        "ADDR:4527 Echo Grove",  // Not mapping
        "MAP:484D6",
        "ID:BBUL-2012-000000730",
        "UNIT:104E",
        "INFO:29 yoa female seizure,starting to come out of it");

    doTest("T11",
        "Alarm - Medical                ; 838 Emerald Bay                               ;Apt      ; 482F1 ; BBUL-2012-000000732  Dept 103C ;  Multi-Agency BCLE Incident #: BCSO-2012-0149257,aud/medicl/res; analisa diaz/res'; 210-648-3962 [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000732. [Shared],",
        "CALL:Alarm - Medical",
        "ADDR:838 Emerald Bay",
        "MAP:482F1",
        "ID:BBUL-2012-000000732",
        "UNIT:103C",
        "INFO:aud/medicl/res; analisa diaz/res'; 210-648-3962");

    doTest("T12",
        "Med - Sick Person              ; 25675 Overlook Pkwy                           ;Apt2708  ; 451C8 ; BBUL-2012-000000731  Dept 104B ;  [Premise:  25675 OVERLOOK PKWY] [Medium] [Criminal Trespass Warning] VAN, SAMUEL JONES B/M DOB:09-04-1966 REFERENCE CASE 2011-BCSO-023624[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149230,[Premise:  25675 Overlook Pkwy] VAN, SAMUEL JONES B/M DOB:09-04-1966 REFERENCE CASE 2011-BCSO-023624,26yr old female was drinking alcohol and now has rapid heart rate, feels like her throat is closing [Shared],This",
        "CALL:Med - Sick Person",
        "ADDR:25675 Overlook Pkwy",
        "APT:2708",
        "MAP:451C8",
        "ID:BBUL-2012-000000731",
        "UNIT:104B",
        "INFO:[Premise:  25675 OVERLOOK PKWY] [Medium] [Criminal Trespass Warning] VAN, SAMUEL JONES B/M DOB:09-04-1966 REFERENCE CASE 2011-BCSO-023624,[Premise:  25675 Overlook Pkwy] VAN, SAMUEL JONES B/M DOB:09-04-1966 REFERENCE CASE 2011-BCSO-023624,26yr old female was drinking alcohol and now has rapid heart rate, feels like her throat is closing ,This");

    doTest("T13",
        "MVC                            ; BULVERDE RD / US HWY 281 N                    ;Apt      ; 451D6 ; BBUL-2012-000000733  Dept 103C ;  major[Shared],nb[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149352,acad notified [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000733. [Shared],",
        "CALL:MVC",
        "ADDR:BULVERDE RD & US HWY 281 N",
        "MADDR:BULVERDE RD & US 281 N",
        "MAP:451D6",
        "ID:BBUL-2012-000000733",
        "UNIT:103C",
        "INFO:major,nb,acad notified");

    doTest("T14",
        "Alarm - Smoke                  ; 510 Reenie Way                                ;Apt      ; 482F2 ; BBUL-2012-000000735  Dept 104E ;  c states smoke detectors will not turn off- took out batteries and replaced them and alarm is still beeping[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149659,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000735. [Shared],",
        "CALL:Alarm - Smoke",
        "ADDR:510 Reenie Way",
        "MAP:482F2",
        "ID:BBUL-2012-000000735",
        "UNIT:104E",
        "INFO:c states smoke detectors will not turn off- took out batteries and replaced them and alarm is still beeping");

    doTest("T15",
        "Med - Unconscious Person       ; 23808 Resort Pkwy                             ;Apt      ; 484E2 ; BBUL-2012-000000734  Dept 104A ;  [Premise:  23808 RESORT PKWY] [Medium] [Location Note] LOSS PREVENTION SECURITY FOR THE MARRIOTT 210-483-6660, THEY ARE FIRST RESPONDERS TO THIS LOCATION[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149578,[Premise:  23808 Resort Pkwy] LOSS PREVENTION SECURITY FOR THE MARRIOTT 210-483-6660, THEY ARE FIRST RESPONDERS TO THIS LOCATION,c/rprts they have a guest who has gone unconscious while by the swimmi",
        "CALL:Med - Unconscious Person",
        "ADDR:23808 Resort Pkwy",
        "MAP:484E2",
        "ID:BBUL-2012-000000734",
        "UNIT:104A",
        "INFO:[Premise:  23808 RESORT PKWY] [Medium] [Location Note] LOSS PREVENTION SECURITY FOR THE MARRIOTT 210-483-6660, THEY ARE FIRST RESPONDERS TO THIS LOCATION,[Premise:  23808 Resort Pkwy] LOSS PREVENTION SECURITY FOR THE MARRIOTT 210-483-6660, THEY ARE FIRST RESPONDERS TO THIS LOCATION,c/rprts they have a guest who has gone unconscious while by the swimmi");

    doTest("T16",
        "MED - PYSCHIATRIC PROBLEMS     ; 1219 Wilder Pond                              ;Apt      ; 451A6 ; BBUL-2012-000000738  Dept 103C ;  C BELIEVES MALE IS AT ABV RESIDENTS ;C HAS BEEN TRYIN TO CALL MALE -NO ANSWER.... [Shared][Shared],C RECV TEXT FROM SHAWN MC DONALD FROM CELL #210-771-5167-----TEXTING HE WAS GOIN TO END IT ALL ---JUST TOOK 25 PILLS OF TEMAZEPAM =ANTI ANX  WITH WHISKEY AND NOW FEELING SLEEPY.....C RQ OFCR TO CALL BACK W/ OUTCOME...  .UNK WPN / INTOX[Shared][Shared],Multi-Agency BCLE Incident #: BCSO-2012-0150265,Add Agency",
        "CALL:MED - PYSCHIATRIC PROBLEMS",
        "ADDR:1219 Wilder Pond",
        "MAP:451A6",
        "ID:BBUL-2012-000000738",
        "UNIT:103C",
        "INFO:C BELIEVES MALE IS AT ABV RESIDENTS ;C HAS BEEN TRYIN TO CALL MALE -NO ANSWER.... ,C RECV TEXT FROM SHAWN MC DONALD FROM CELL #210-771-5167-----TEXTING HE WAS GOIN TO END IT ALL ---JUST TOOK 25 PILLS OF TEMAZEPAM =ANTI ANX  WITH WHISKEY AND NOW FEELING SLEEPY.....C RQ OFCR TO CALL BACK W/ OUTCOME...  .UNK WPN / INTOX,Add Agency");

    doTest("T17",
        "Alarm - Fire                   ; 3040 Single Peak                              ;Apt      ; 451F4 ; HPK-2012-000000254   Dept 104B,129E,SPK ;  fire alarm...upstairs smoke detector...williamson residence...830-438-7561..gate code 0011[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0150233,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000737. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000254. [Shared],",
        "CALL:Alarm - Fire",
        "ADDR:3040 Single Peak",
        "MAP:451F4",
        "ID:HPK-2012-000000254",
        "UNIT:104B,129E,SPK",
        "INFO:fire alarm...upstairs smoke detector...williamson residence...830-438-7561..gate code 0011");

    doTest("T18",
        "MED - TOX INGEST - INTENTIONAL ; 1234 Wilder Pond                              ;Apt      ; 451B6 ; BBUL-2012-000000736  Dept 103D ;  Multi-Agency BCLE Incident #: BCSO-2012-0150168,36 yo female...prozac and other pills pt breathing somewhat responding [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000736. [Shared],",
        "CALL:MED - TOX INGEST - INTENTIONAL",
        "ADDR:1234 Wilder Pond",
        "MAP:451B6",
        "ID:BBUL-2012-000000736",
        "UNIT:103D",
        "INFO:36 yo female...prozac and other pills pt breathing somewhat responding");

  }
  
  @Test
  public void testNewParser2() {

    doTest("T1",
        "Med - Fall           - 8502 GLEN BREEZE               - 553F8 Dept-108B - ACADIAN: Unit:    731         10041536,Transferred incident: Remote   Reference Number: 20120603-ZN16-1180 by Stinson, Nathaniel T. From ACADIAN,Interface has sent an ack message for CAM-2012-0013763 to the remote CAD,10041536,This incident 20120603-ZN16-1180 has been sent to BCFA via the CAD2CAD Interface.,Unit - 731, status change to STATUS_RESPONDING by ACADIAN at 06/03/2012 23:07:18,ACADIAN HAS CHANGED",
        "CALL:Med - Fall",
        "ADDR:8502 GLEN BREEZE",
        "MAP:553F8",
        "ID:CAM-2012-0013763",
        "UNIT:108B 731",
        "INFO:10041536 - Nathaniel T. From ACADIAN,10041536,Unit - 731,ACADIAN HAS CHANGED");

    doTest("T2",
        "Fire-Authorized Burn      - 24440 Loma Verde          - RED GATE DR/TOPALA DR                    - 783B3  Dept-138B - unk what is burning[Shared],C says she sees smoke coming from her neighbors yard.  Unk address.[Shared],Invalid address received:220  VERIZON-E SECTOR-QF 783A4.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0142874,Automatic Case Number(s) issued for Sandy Oaks FD: SOAK-2012-000000498. [Shared],",
        "CALL:Fire-Authorized Burn",
        "ADDR:24440 Loma Verde",
        "X:RED GATE DR/TOPALA DR",
        "MAP:783B3",
        "ID:BCSO-2012-0142874",
        "UNIT:138B",
        "INFO:unk what is burning,C says she sees smoke coming from her neighbors yard.  Unk address");

  }
  
  public static void main(String[] args) {
    new TXBexarCountyParserTest().generateTests("T1");
  }
}
