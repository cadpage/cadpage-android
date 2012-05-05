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
        "TIME:06:28 am",
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
        "INFO:Unit: - 740 - 9941959,The cross street was verified by caller.,Law enforcement on scene; it is safe for the crew to enter.,assult to head unk age male, Angela From ACADIAN");

    doTest("T9",
        "Med - Unconscious Pe - 7838 Sun Forest                -       - 585C1   - 24 yo female went over to comps resd to visit his son; comp states female started drinking some wine and passed out; comp states she is breathing ; does not know what to do with female[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0109700,This incident WIND-2012-0010491 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120428-ZN16-0059 [Shared],Unit - 76",
        "CALL:Med - Unconscious Pe",
        "ADDR:7838 Sun Forest",
        "MAP:585C1",
        "ID:BCSO-2012-0109700",
        "INFO:24 yo female went over to comps resd to visit his son; comp states female started drinking some wine and passed out; comp states she is breathing ; does not know what to do with female,Unit - 76");

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
        "CALL:MVC - 23101",
        "ADDR:24511 Campbellton",
        "APT:HICKORY WAY/RANCH TRAIL RD",
        "MAP:783D1",
        "INFO:small dark colored suv,going north on cambellton, it will be on the left,C disconnected,C says there is a car, unoccupied, flipped over.");

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
        "INFO:Dept-E108,C145,E145B,120A - FIRE ALARM-RED LOBSTERS REST.,Backed up C145 with E145B,SINGLE STORY LIGHT SMOKE SHOWING AND SMOKE IN KITCHEN");

  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "07:35 pm   10410 Stallion Bay             :Rspnd for: Med - Sick Person    - 546C6   - D7FR-2012-000000330\r",
        "TIME:07:35 pm",
        "CALL:Med - Sick Person",
        "ADDR:10410 Stallion Bay",
        "ID:D7FR-2012-000000330",
        "CODE:546C6");
    
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "Respond For MVC                           @30000 Smithson Valley Rd                     ;      ;                              Cross- VOGEL VALLEY/FM 1863                                                            ;418D7;BBUL-2012-000000497 ;Multi-Agency BCLE Incident #: BCSO-2012-0104123,e veh roll over, injuries [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000497. [Shared]",
        "CALL:Respond For MVC",
        "ADDR:30000 Smithson Valley Rd",
        "MAP:418D7",
        "ID:BBUL-2012-000000497",
        "X:VOGEL VALLEY/FM 1863",
        "INFO:e veh roll over, injuries");

    doTest("T2",
        "Respond For Med - Sick Person             @25715 Fan Flower                             ;      ;                              Cross- Dead End/BEAUTYBERRY                                                            ;452B7;BBUL-2012-000000532 ;C said a woman came by her house,is now seizing, 24 yo.[Shared],Invalid address received:520  AT&T MOBILITY -SE SECTOR-QF 451.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110748,Automatic Case Number(s) issued for Bexa",
        "CALL:Respond For Med - Sick Person",
        "ADDR:25715 Fan Flower",
        "MAP:452B7",
        "ID:BBUL-2012-000000532",
        "X:Dead End/BEAUTYBERRY",
        "INFO:C said a woman came by her house,is now seizing, 24 yo.");
    
  }
  
  public static void main(String[] args) {
    new TXBexarCountyParserTest().generateTests("T1");
  }
}
