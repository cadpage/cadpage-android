package net.anei.cadpage.parsers.OK;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OKTulsaParserTest extends BaseParserTest {
  
  public OKTulsaParserTest() {
    setParser(new OKTulsaParser(), "TULSA", "OK");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "PAGE-OUT / 09:11PM Tue 05/10/2011 2200 N HWY167NB EXPY; UNK WHAT IS ON FIRE CS7 ENR PUBLIC SAFETY COMMUNICATIONS",
        "CALL:EXPY",
        "ADDR:2200 N HWY-167",
        "INFO:UNK WHAT IS ON FIRE CS7 ENR PUBLIC SAFETY COMMUNICATIONS");

    doTest("T2",
        "PAGE-OUT / 10:40PM Tue 05/10/2011 ***MED EMERG / FALL*** 314 N CHEROKEE ST /// PAFFORD ENRT PUBLIC SAFETY COMMUNICATIONS",
        "CALL:MED EMERG / FALL",
        "ADDR:314 N CHEROKEE ST",
        "INFO:PAFFORD ENRT PUBLIC SAFETY COMMUNICATIONS");

    doTest("T3",
        "02:42AM Wed 05/11/2011 back pain....303 n joanna st, mp 1771....42 yof post back surgery....pafford enr from catoosa..eot PUBLIC SAFETY COMMUNICATIONS",
        "CALL:back pain",
        "ADDR:303 n joanna st",
        "INFO:mp 1771; 42 yof post back surgery; pafford enr from catoosa; eot PUBLIC SAFETY COMMUNICATIONS");

    doTest("T4",
        "PAGE-OUT / 08:15PM Wed 05/11/2011 MEDICAL / 17835 E Pine St, Lot 6 / not alert PUBLIC SAFETY COMMUNICATIONS",
        "CALL:MEDICAL /",
        "ADDR:17835 E Pine St",
        "INFO:Lot 6 / not alert PUBLIC SAFETY COMMUNICATIONS");

    doTest("T5",
        "PAGE-OUT / 06:13PM Wed 05/11/2011 MVA AT 17700 E I44WB EXP; OHP/PAFFORD ENR PUBLIC SAFETY COMMUNICATIONS",
        "CALL:MVA",
        "ADDR:17700 E I-44",
        "INFO:EXP; OHP/PAFFORD ENR PUBLIC SAFETY COMMUNICATIONS");

    doTest("T6",
        "03:50PM Wed 05/11/2011 ***MED EMERG / CP (POST DOM)*** CHEROKEE CASINO LOT D //// PAFFORD ENRT... CASINO WILL HAVE WAIVER AT LIGHT PUBLIC SAFETY COMMUNICATIONS",
        "CALL:GENERAL ALERT",
        "MADDR:***MED EMERG / CP (POST DOM)*** CHEROKEE CASINO LOT D ; PAFFORD ENRT; CASINO WILL HAVE WAIVER AT LIGHT PUBLIC SAFETY COMMUNICATIONS",
        "PLACE:***MED EMERG / CP (POST DOM)*** CHEROKEE CASINO LOT D ; PAFFORD ENRT; CASINO WILL HAVE WAIVER AT LIGHT PUBLIC SAFETY COMMUNICATIONS");

    doTest("T7",
        "03:24PM Mon 05/16/2011 Please Call Ramella Hitchcock at 918 261 3786. ref: burning trash at 203 Riter Rd PUBLIC SAFETY COMMUNICATIONS",
        "CALL:Please Call Ramella Hitchcock at 918 261 3786 ref: burning trash",
        "ADDR:203 Riter Rd",
        "INFO:PUBLIC SAFETY COMMUNICATIONS");

    doTest("T8",
        "12:25PM Tue 05/17/2011 MEDICAL EMERGENCY.. SYNCOPAL.. WELLS MIDDLE SCHOOL 2000 S CHEROKEE ST... 14 YR OLD MALE.. PAFFORD ENRT.. EOT PUBLIC SAFETY COMMUNICATIONS",
        "CALL:WELLS MIDDLE SCHOOL",
        "ADDR:2000 S CHEROKEE ST",
        "INFO:14 YR OLD MALE; PAFFORD ENRT; EOT PUBLIC SAFETY COMMUNICATIONS");

    doTest("T9",
        "12:40PM Tue 05/17/2011 catoosa chief call dispatch re:citizen burn permit...918 596 9977, thank you..eot PUBLIC SAFETY COMMUNICATIONS",
        "CALL:GENERAL ALERT",
        "PLACE:catoosa chief call dispatch re:citizen burn permit;918 596 9977, thank you;eot PUBLIC SAFETY COMMUNICATIONS");

    doTest("T10",
        "PAGE-OUT / 01:24PM Tue 05/17/2011 catoosa chief please call dispatch 596 9977, re burn ban...eot PUBLIC SAFETY COMMUNICATIONS",
        "CALL:GENERAL ALERT",
        "PLACE:catoosa chief please call dispatch 596 9977, re burn ban;eot PUBLIC SAFETY COMMUNICATIONS");

    doTest("T11",
        "03:18PM Tue 05/17/2011 MEDICAL EMER 20132 E 4 ST  67YOF SEVERE PAIN AND LAC TO LEG THAT IS INFECTED PAFFORD ENRT PUBLIC SAFETY COMMUNICATIONS",
        "CALL:MEDICAL EMER",
        "ADDR:20132 E 4 ST",
        "INFO:67YOF SEVERE PAIN AND LAC TO LEG THAT IS INFECTED PAFFORD ENRT PUBLIC SAFETY COMMUNICATIONS");

    doTest("T12",
        "PAGE-OUT / 11:26PM Tue 05/17/2011 TFD WAVED OFF BY PAFFORD, SAYS CATOOSA CAN CANCEL AS WELL. PUBLIC SAFETY COMMUNICATIONS",
        "CALL:GENERAL ALERT",
        "PLACE:TFD WAVED OFF BY PAFFORD, SAYS CATOOSA CAN CANCEL AS WELL. PUBLIC SAFETY COMMUNICATIONS");

    doTest("T13",
        "11:29PM Tue 05/17/2011 MEDICAL 777 W CHEROKEE ST. REC 2316 HRS, DISP 2316, CR ENR 2323, CANCELED BY PAFFORD AT 2326  PUBLIC SAFETY COMMUNICATIONS",
        "CALL:MEDICAL",
        "ADDR:777 W CHEROKEE ST",
        "INFO:REC 2316 HRS, DISP 2316, CR ENR 2323, CANCELED BY PAFFORD AT 2326  PUBLIC SAFETY COMMUNICATIONS");

    doTest("T14",
        "12:48PM Thu 05/19/2011 me / od 2000 s cherokee st, 13 yom down between bldgs/ pafford enrt eot PUBLIC SAFETY COMMUNICATIONS",
        "CALL:me/od",
        "ADDR:2000 s cherokee st",
        "INFO:13 yom down between bldgs/ pafford enrt eot PUBLIC SAFETY COMMUNICATIONS");

    doTest("T15",
        "04:07PM Thu 05/19/2011 MED EMERG FEMALE W/ CP. 19300 E PINE ST SONIC RESTAURANT. PAFFORD ENRT. EOT  PUBLIC SAFETY COMMUNICATIONS",
        "CALL:MED EMERG FEMALE W/CP",
        "ADDR:19300 E PINE ST",
        "INFO:SONIC RESTAURANT PAFFORD ENRT EOT PUBLIC SAFETY COMMUNICATIONS");

    doTest("T16",
        "PAGE-OUT / 04:44PM Fri 05/20/2011 777 W CHEROKEE;MCDONALDS;37 YOF INSIDE HAVING CHEST PAINS PUBLIC SAFETY COMMUNICATIONS",
        "CALL:GENERAL ALERT",
        "PLACE:777 W CHEROKEE;MCDONALDS;37 YOF INSIDE HAVING CHEST PAINS PUBLIC SAFETY COMMUNICATIONS");

    doTest("T17",
        "PAGE-OUT / 05:32PM Fri 05/20/2011 MEDICAL 19525 E 2 ST S;13 YOM ASLTED; CAT PD ON SCENE PUBLIC SAFETY COMMUNICATIONS",
        "CALL:MEDICAL",
        "ADDR:19525 E 2 ST S",
        "INFO:13 YOM ASLTED; CAT PD ON SCENE PUBLIC SAFETY COMMUNICATIONS");

    doTest("T18",
        "07:40PM Fri 05/20/2011 MED EMERG, CASINO, 50 YOF FELL, HEAD INJURY, TFD E30 ENRT, PAFFORD ENRT  PUBLIC SAFETY COMMUNICATIONS",
        "CALL:GENERAL ALERT",
        "PLACE:MED EMERG, CASINO, 50 YOF FELL, HEAD INJURY, TFD E30 ENRT, PAFFORD ENRT  PUBLIC SAFETY COMMUNICATIONS");

    doTest("T19",
        "11:46AM Sat 05/21/2011 SOMEONE FROM CATOOSA FD PLEASE CALL ALARM OFFICE FOR BURN PERMIT 178 SPUNKYCREEK DR PUBLIC SAFETY COMMUNICATIONS",
        "CALL:SOMEONE FROM CATOOSA FD PLEASE CALL ALARM OFFICE FOR BURN PERMIT",
        "ADDR:178 SPUNKYCREEK DR",
        "INFO:PUBLIC SAFETY COMMUNICATIONS");
     
  }
  
  public static void main(String[] args) {
    new OKTulsaParserTest().generateTests("T1", "CALL ADDR X PHONE NAME ID INFO PLACE");
  }
}