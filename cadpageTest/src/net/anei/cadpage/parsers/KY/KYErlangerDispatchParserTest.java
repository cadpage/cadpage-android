package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Erlanger Dispatch, KY (in Kenton County)
Contact: "Jeremy Sheehan" <jsheehan@elsmerefd.com>
Sender: pscc@ci.erlanger.ky.us
Sender: administrator@erlangerpd.com

(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n709 ORCHARD ST\nELSMERE\nBTWN: MAIN ST & LYTLE AV\n\nRCVD AS E-911 Call\n\nCOM:\nSMOKE FILLED BASEMENT\nHEARD A POP\n\nCT:\n22-
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n3812 HARVEST WY\nELSMERE\nBTWN: HARVEST LN & N/A
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n416 ELKEN PL\nELSMERE\nBTWN: MAPLE AV & CALDWELL DR
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n1028 CAPITOL AV\n1\nELSMERE\nBTWN: GALVIN ST & N/A
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nELSMERE FIRE DEPARTMENT\n401 GARVEY AV\nELSMERE\nBTWN: ASH ST & PALACE AV
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nLANIGAN'S\n4409 DIXIE HW\nELSMERE\nBTWN: N/A & N/A
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n631 WILLOW ST\nELSMERE\nBTWN: KENTON ST & MAIN ST
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nWOODCREST MANOR CARE CENTER\n3876 TURKEYFOOT RD\nELSMERE\nBTWN: TURKEYFOOT RD & INDUSTRIAL RD
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n120 SPARROW DR\nELSMERE\nBTWN: N/A & ROBIN DR
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n430 FOX ST\nELSMERE\nBTWN: GARVEY AV & MAIN ST
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nSIGNODE PLASTIC RECYCLING ALLIANCE\n7080 INDUSTRIAL RD\nELSMERE\nBTWN: NEW BUFFINGTON RD & VULACN DR
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nALLENDALE MOBILE HOME PARK\n1150 EDWARDS RD\nELSMERE\nBTWN: LYTLE AV & N/A

pscc@ci.erlanger.ky.us\nSUBJ:Alert: Unconscious / Unresponsive\nMSG:\nALRM LVL: 1\nLOC:\n32 DUDLEY RD\nEDGEWOOD\nBTWN: MAPLE LN & WILDROSE DR\n\nRCVD AS E-911 Call\n\nCOM:\nSUBJ FELL IN BATHROOM\nUNK IF BREATHING\nBETWEEN THE TOILET AND BATH TUB\n\nCT:\n22-RCA at POS 03\n

Contact: Contact: 18599160944@tmomail.net
(Alert: Non Specific Diagnosis/Illne) ALRM LVL: 1\nLOC:\nDUDLEY RD/MADONNA DR\nEDGEWOOD\nBTWN: MADONNA DR & LEE LN\n\nRCVD AS E-911 Call\n\nCOM:\nRUN VEHICLE SMALL BLACK FORD TRUCK\n236LRB KY\nFORD RANGER\nHEADED DOWN MADONNA\nNO INJURIES\nLAST SEEN IN THE BACK YARD 3122 ROYAL WINDSOR KNOCKING DOWN FENCES\nVICTIM PULLED OFF ONTO MADONNA\n8594661682\nHIDDEN ON MARMIL CR BETWEEN THE LAST TWO HOUSES\nLIC/236LRB KY EXPIRES: 20120930 \nDEC/P446149 \n1991 FORD PK BRO \nVIN/1FTCR10X5MTA07455 \nHORNSBY, JAMES DAVID SOC/404969231 \n27 1/2 HIGH ST, NEWPORT KY 41071 \nDATE REGISTERED/20110325 \nTITLE/110840190084 \nINSURANCE/VERIFY PROOF OF INSURANCE \nREMARKS/ \n\n900 BLK OF DUDLEY, VEH CRASHED, SUSPECT FLED\nFLED NORTH UP INTO THE WOODS\nCH1 SECURE 1626\nCRASHED IN 900 BLOCK OF DUDLEY\n333 ENROUTE WITH K9\nHIT AND RUN, ALSO FLEEING AND EVADING\n913 SET UP BY STATE FARM/ CORNER OF DUDLEY AND 17\n913-EnRoute to-DUDLEY /17<13,10>\n521 IN THE AREA OF THE WATER TOWER\n330 OUT WITH SUBJ DUDLEY AND WINDING TRAIL\nTRYING TO VERIFY IF THIS IS SUSPECT\n330-On Scene at-958 DUDLEY IN BACK YARD\n512-On Scene at-958 DUDLEY IN BACK YARD\nBLACK HAIR GOATEE\nSON DAN KLOTTS 5135204432\nOUT WITH WITNESS, NOT SUSPECT\nSUBJ RAN NORTH IN WOODS BEHIND 958 DUDLEY\n1422-EnRoute to-AREA OF WATER TOWER\n339 RESPONDING TO SCENE OF ACCIDENT, PASSENGER STILL ON SCENE\n333 OUT WITH K9, 330 WITH HIM\n527 WITH THE 2ND HIT AND RUN AT 797 DUDLEY\n527-On Scene at-797 DUDLEY, SCENE OF 2ND ACCIDENT\n330-On Scene at-958 DUDLEY\n333-On Scene at-958 DUDLEY\nK9 OUT AT 1635\n913 WITH M/W IN ALL BLK BEHIND 998 DUDLEY\nRUNNING TOWARDS MADISON PK\nM/W BRO HAIR, WEARING ALL BLK\nTASER DEPLOYED 1637\nOVER THE FENCE, IN THE CEMETARY\nUNDER CONTROL BY TASER\nCOME THRU LOT BY STATE FARM BEHIND THE OLD HOUSE\n527 OUT WITH 913\n330/333 COME TO TOP OF CEMETARY\nGO BEHIND THE HOUSE AND COME THRU GATE\n512 REQUESTING SQUAD 1639\n330-On Scene at-DUDLEY /MADISON, AT CEMETARY\n333-On Scene at-DUDLEY /MADISON, AT CEMETARY\n512-On Scene at-DUDLEY /MADISON, AT CEMETARY\n527-On Scene at-DUDLEY /MADISON, AT CEMETARY\n913-On Scene at-DUDLEY /MADISON, AT CEMETARY\n926-On Scene at-DUDLEY /MADISON, AT CEMETARY\nSUBJ IN CUSTODY AT 1639\nHAVE SQUAD COME TO THE HOUSE BEHIND STATE FARM\n330-On Scene at-970 DUDLEY\n333-On Scene at-970 DUDLEY\n339-On Scene at-970 DUDLEY\n512-On Scene at-970 DUDLEY\n527-On Scene at-970 DUDLEY\n913-On Scene at-970 DUDLEY\n\nCT:\n22-SP at POS 04

Contact: support@active911.com
Sender: pscc@ci.erlanger.ky.us
(Alert: Non Specific Diagnosis/Illness) ALRM LVL: 1\r\nLOC:\r\n1717 CHOCTAW TL\r\nELSMERE\r\nBTWN: COMANCHE TL & SIOUX TL\r\n\r\nRCVD AS E-911 Call\r\n\r\nCOM:\r\nFEMALE HAVING LEG SPASIMS\r\nFEMALE HAS CARDIO VASCULAR DISEASE\r\n71 FEMALE\r\n\r\nCT:\r\n22-DLP at POS 05\r\n
(Alert: Bleeding / Lacerations) ALRM LVL: 1\r\nLOC:\r\n7673 IRONBRIDGE CT\r\nELSMERE\r\nBTWN: COVERED BRIDGE DR & N/A\r\n\r\nRCVD AS E-911 Call\r\n\r\nCOM:\r\nREFUSING MEDICAL\r\nDOG BIT CHILD AT THE EAST COVERED BRIDGE PARK\r\nBROWN DOG\r\nPOSS PIT BULL\r\nWRIST AND HAND\r\n\r\nCT:\r\n22-DLP at POS 01\r\n

*/

public class KYErlangerDispatchParserTest extends BaseParserTest {
  
  public KYErlangerDispatchParserTest() {
    setParser(new KYErlangerDispatchParser(), "KENTON COUNTY", "KY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n709 ORCHARD ST\nELSMERE\nBTWN: MAIN ST & LYTLE AV\n\nRCVD AS E-911 Call\n\nCOM:\nSMOKE FILLED BASEMENT\nHEARD A POP\n\nCT:\n22-",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:709 ORCHARD ST",
        "CITY:ELSMERE",
        "X:MAIN ST & LYTLE AV",
        "INFO:SMOKE FILLED BASEMENT / HEARD A POP / 22-");

    doTest("T2",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n3812 HARVEST WY\nELSMERE\nBTWN: HARVEST LN & N/A",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:3812 HARVEST WY",
        "CITY:ELSMERE",
        "X:HARVEST LN");

    doTest("T3",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n416 ELKEN PL\nELSMERE\nBTWN: MAPLE AV & CALDWELL DR",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:416 ELKEN PL",
        "CITY:ELSMERE",
        "X:MAPLE AV & CALDWELL DR");

    doTest("T4",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n1028 CAPITOL AV\n1\nELSMERE\nBTWN: GALVIN ST & N/A",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:1028 CAPITOL AV",
        "MADDR:1028 CAPITOL AVE",
        "APT:1",
        "CITY:ELSMERE",
        "X:GALVIN ST");

    doTest("T5",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nELSMERE FIRE DEPARTMENT\n401 GARVEY AV\nELSMERE\nBTWN: ASH ST & PALACE AV",
        "CALL:Fire Structure",
        "PRI:1",
        "PLACE:ELSMERE FIRE DEPARTMENT",
        "ADDR:401 GARVEY AV",
        "MADDR:401 GARVEY AVE",
        "CITY:ELSMERE",
        "X:ASH ST & PALACE AV");

    doTest("T6",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nLANIGAN'S\n4409 DIXIE HW\nELSMERE\nBTWN: N/A & N/A",
        "CALL:Fire Structure",
        "PRI:1",
        "PLACE:LANIGAN'S",
        "ADDR:4409 DIXIE HW",
        "MADDR:4409 DIXIE HWY",
        "CITY:ELSMERE");

    doTest("T7",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n631 WILLOW ST\nELSMERE\nBTWN: KENTON ST & MAIN ST",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:631 WILLOW ST",
        "CITY:ELSMERE",
        "X:KENTON ST & MAIN ST");

    doTest("T8",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nWOODCREST MANOR CARE CENTER\n3876 TURKEYFOOT RD\nELSMERE\nBTWN: TURKEYFOOT RD & INDUSTRIAL RD",
        "CALL:Fire Structure",
        "PRI:1",
        "PLACE:WOODCREST MANOR CARE CENTER",
        "ADDR:3876 TURKEYFOOT RD",
        "CITY:ELSMERE",
        "X:TURKEYFOOT RD & INDUSTRIAL RD");

    doTest("T9",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n120 SPARROW DR\nELSMERE\nBTWN: N/A & ROBIN DR",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:120 SPARROW DR",
        "CITY:ELSMERE",
        "X:ROBIN DR");

    doTest("T10",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n430 FOX ST\nELSMERE\nBTWN: GARVEY AV & MAIN ST",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:430 FOX ST",
        "CITY:ELSMERE",
        "X:GARVEY AV & MAIN ST");

    doTest("T11",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nSIGNODE PLASTIC RECYCLING ALLIANCE\n7080 INDUSTRIAL RD\nELSMERE\nBTWN: NEW BUFFINGTON RD & VULACN DR",
        "CALL:Fire Structure",
        "PRI:1",
        "PLACE:SIGNODE PLASTIC RECYCLING ALLIANCE",
        "ADDR:7080 INDUSTRIAL RD",
        "CITY:ELSMERE",
        "X:NEW BUFFINGTON RD & VULACN DR");

    doTest("T12",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nALLENDALE MOBILE HOME PARK\n1150 EDWARDS RD\nELSMERE\nBTWN: LYTLE AV & N/A",
        "CALL:Fire Structure",
        "PRI:1",
        "PLACE:ALLENDALE MOBILE HOME PARK",
        "ADDR:1150 EDWARDS RD",
        "CITY:ELSMERE",
        "X:LYTLE AV");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "pscc@ci.erlanger.ky.us\nSUBJ:Alert: Unconscious / Unresponsive\nMSG:\nALRM LVL: 1\nLOC:\n32 DUDLEY RD\nEDGEWOOD\nBTWN: MAPLE LN & WILDROSE DR\n\nRCVD AS E-911 Call\n\nCOM:\nSUBJ FELL IN BATHROOM\nUNK IF BREATHING\nBETWEEN THE TOILET AND BATH TUB\n\nCT:\n22-RCA at POS 03\n",
        "CALL:Unconscious / Unresponsive",
        "PRI:1",
        "ADDR:32 DUDLEY RD",
        "CITY:EDGEWOOD",
        "X:MAPLE LN & WILDROSE DR",
        "INFO:SUBJ FELL IN BATHROOM / UNK IF BREATHING / BETWEEN THE TOILET AND BATH TUB / 22-RCA at POS 03");

    doTest("T2",
        "(Alert: Non Specific Diagnosis/Illne) ALRM LVL: 1\n" +
        "LOC:\n" +
        "DUDLEY RD/MADONNA DR\n" +
        "EDGEWOOD\n" +
        "BTWN: MADONNA DR & LEE LN\n\n" +
        "RCVD AS E-911 Call\n\n" +
        "COM:\n" +
        "RUN VEHICLE SMALL BLACK FORD TRUCK\n" +
        "236LRB KY\n" +
        "FORD RANGER\n" +
        "HEADED DOWN MADONNA\n" +
        "NO INJURIES\n" +
        "LAST SEEN IN THE BACK YARD 3122 ROYAL WINDSOR KNOCKING DOWN FENCES\n" +
        "VICTIM PULLED OFF ONTO MADONNA\n" +
        "8594661682\n" +
        "HIDDEN ON MARMIL CR BETWEEN THE LAST TWO HOUSES\n" +
        "LIC/236LRB KY EXPIRES: 20120930 \n" +
        "DEC/P446149 \n" +
        "1991 FORD PK BRO \n" +
        "VIN/1FTCR10X5MTA07455 \n" +
        "HORNSBY, JAMES DAVID SOC/404969231 \n" +
        "27 1/2 HIGH ST, NEWPORT KY 41071 \n" +
        "DATE REGISTERED/20110325 \n" +
        "TITLE/110840190084 \n" +
        "INSURANCE/VERIFY PROOF OF INSURANCE \n" +
        "REMARKS/ \n\n" +
        "900 BLK OF DUDLEY, VEH CRASHED, SUSPECT FLED\n" +
        "FLED NORTH UP INTO THE WOODS\n" +
        "CH1 SECURE 1626\n" +
        "CRASHED IN 900 BLOCK OF DUDLEY\n" +
        "333 ENROUTE WITH K9\n" +
        "HIT AND RUN, ALSO FLEEING AND EVADING\n" +
        "913 SET UP BY STATE FARM/ CORNER OF DUDLEY AND 17\n" +
        "913-EnRoute to-DUDLEY /17<13,10>\n" +
        "521 IN THE AREA OF THE WATER TOWER\n" +
        "330 OUT WITH SUBJ DUDLEY AND WINDING TRAIL\n" +
        "TRYING TO VERIFY IF THIS IS SUSPECT\n" +
        "330-On Scene at-958 DUDLEY IN BACK YARD\n" +
        "512-On Scene at-958 DUDLEY IN BACK YARD\n" +
        "BLACK HAIR GOATEE\n" +
        "SON DAN KLOTTS 5135204432\n" +
        "OUT WITH WITNESS, NOT SUSPECT\n" +
        "SUBJ RAN NORTH IN WOODS BEHIND 958 DUDLEY\n" +
        "1422-EnRoute to-AREA OF WATER TOWER\n" +
        "339 RESPONDING TO SCENE OF ACCIDENT, PASSENGER STILL ON SCENE\n" +
        "333 OUT WITH K9, 330 WITH HIM\n" +
        "527 WITH THE 2ND HIT AND RUN AT 797 DUDLEY\n" +
        "527-On Scene at-797 DUDLEY, SCENE OF 2ND ACCIDENT\n" +
        "330-On Scene at-958 DUDLEY\n" +
        "333-On Scene at-958 DUDLEY\n" +
        "K9 OUT AT 1635\n" +
        "913 WITH M/W IN ALL BLK BEHIND 998 DUDLEY\n" +
        "RUNNING TOWARDS MADISON PK\n" +
        "M/W BRO HAIR, WEARING ALL BLK\n" +
        "TASER DEPLOYED 1637\n" +
        "OVER THE FENCE, IN THE CEMETARY\n" +
        "UNDER CONTROL BY TASER\n" +
        "COME THRU LOT BY STATE FARM BEHIND THE OLD HOUSE\n" +
        "527 OUT WITH 913\n" +
        "330/333 COME TO TOP OF CEMETARY\n" +
        "GO BEHIND THE HOUSE AND COME THRU GATE\n" +
        "512 REQUESTING SQUAD 1639\n" +
        "330-On Scene at-DUDLEY /MADISON, AT CEMETARY\n" +
        "333-On Scene at-DUDLEY /MADISON, AT CEMETARY\n" +
        "512-On Scene at-DUDLEY /MADISON, AT CEMETARY\n" +
        "527-On Scene at-DUDLEY /MADISON, AT CEMETARY\n" +
        "913-On Scene at-DUDLEY /MADISON, AT CEMETARY\n" +
        "926-On Scene at-DUDLEY /MADISON, AT CEMETARY\n" +
        "SUBJ IN CUSTODY AT 1639\n" +
        "HAVE SQUAD COME TO THE HOUSE BEHIND STATE FARM\n" +
        "330-On Scene at-970 DUDLEY\n" +
        "333-On Scene at-970 DUDLEY\n" +
        "339-On Scene at-970 DUDLEY\n" +
        "512-On Scene at-970 DUDLEY\n" +
        "527-On Scene at-970 DUDLEY\n" +
        "913-On Scene at-970 DUDLEY\n\n" +
        "CT:\n" +
        "22-SP at POS 04",

        "CALL:Non Specific Diagnosis/Illne",
        "PRI:1",
        "ADDR:DUDLEY RD & MADONNA DR",
        "CITY:EDGEWOOD",
        "X:MADONNA DR & LEE LN",
        "INFO:RUN VEHICLE SMALL BLACK FORD TRUCK / 236LRB KY / FORD RANGER / HEADED DOWN MADONNA / NO INJURIES / LAST SEEN IN THE BACK YARD 3122 ROYAL WINDSOR KNOCKING DOWN FENCES / VICTIM PULLED OFF ONTO MADONNA / 8594661682 / HIDDEN ON MARMIL CR BETWEEN THE LAST TWO HOUSES / LIC/236LRB KY EXPIRES: 20120930 / DEC/P446149 / 1991 FORD PK BRO / VIN/1FTCR10X5MTA07455 / HORNSBY, JAMES DAVID SOC/404969231 / 27 1/2 HIGH ST, NEWPORT KY 41071 / DATE REGISTERED/20110325 / TITLE/110840190084 / INSURANCE/VERIFY PROOF OF INSURANCE / REMARKS/ / 22-SP at POS 04");
    
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "(Alert: Non Specific Diagnosis/Illness) ALRM LVL: 1\r\n" +
        "LOC:\r\n" +
        "1717 CHOCTAW TL\r\n" +
        "ELSMERE\r\n" +
        "BTWN: COMANCHE TL & SIOUX TL\r\n" +
        "\r\n" +
        "RCVD AS E-911 Call\r\n" +
        "\r\n" +
        "COM:\r\n" +
        "FEMALE HAVING LEG SPASIMS\r\n" +
        "FEMALE HAS CARDIO VASCULAR DISEASE\r\n" +
        "71 FEMALE\r\n" +
        "\r\n" +
        "CT:\r\n" +
        "22-DLP at POS 05\r\n",

        "CALL:Non Specific Diagnosis/Illness",
        "PRI:1",
        "ADDR:1717 CHOCTAW TL",
        "MADDR:1717 CHOCTAW TRL",
        "CITY:ELSMERE",
        "X:COMANCHE TL & SIOUX TL",
        "INFO:FEMALE HAVING LEG SPASIMS / FEMALE HAS CARDIO VASCULAR DISEASE / 71 FEMALE / 22-DLP at POS 05");

    doTest("T2",
        "(Alert: Bleeding / Lacerations) ALRM LVL: 1\r\n" +
        "LOC:\r\n" +
        "7673 IRONBRIDGE CT\r\n" +
        "ELSMERE\r\n" +
        "BTWN: COVERED BRIDGE DR & N/A\r\n" +
        "\r\n" +
        "RCVD AS E-911 Call\r\n" +
        "\r\n" +
        "COM:\r\n" +
        "REFUSING MEDICAL\r\n" +
        "DOG BIT CHILD AT THE EAST COVERED BRIDGE PARK\r\n" +
        "BROWN DOG\r\n" +
        "POSS PIT BULL\r\n" +
        "WRIST AND HAND\r\n" +
        "\r\n" +
        "CT:\r\n" +
        "22-DLP at POS 01\r\n",

        "CALL:Bleeding / Lacerations",
        "PRI:1",
        "ADDR:7673 IRONBRIDGE CT",
        "CITY:ELSMERE",
        "X:COVERED BRIDGE DR",
        "INFO:REFUSING MEDICAL / DOG BIT CHILD AT THE EAST COVERED BRIDGE PARK / BROWN DOG / POSS PIT BULL / WRIST AND HAND / 22-DLP at POS 01");

  }
  
  public static void main(String[] args) {
    new KYErlangerDispatchParserTest().generateTests("T1");
  }
}