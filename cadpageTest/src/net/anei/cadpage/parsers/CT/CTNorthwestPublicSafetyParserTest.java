package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Roxbury, CT
Contact: Mike Josefson <mikejosefson@gmail.com>
Sender: globalpaging@nowestps.org

FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:FLAG SWAMP RD & SOUTH ST  ROXBURY MVA EMS ROX AMB RO EMSX RO ENG12 ROX RES9 ROX FD1 Primary Incident: 040734\n\n(End)
FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:39 TRANSYLVANIA RD  ROXBURY CHOKING ABNORM BREATH (PARTIAL OBSTRUCT) ROX AMB RO EMSX Primary Incident: 040410\n\n(End)
FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:102 PAINTER HILL RD  ROXBURY FAINTING/SYNCOPE ROX AMB RO EMSX Primary Incident: 040378\n\n(End)
FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:314 PAINTER HILL RD  ROXBURY FIRE ALARM RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1 Primary Incident: 00120\n\n(End)
FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:71 SOUTH ST  ROXBURY FIRE ALARM RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1 Primary Incident: 00119\n\n\n(End)
FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:BOTSFORD HILL RD & GOLDEN HARVEST RD  ROXBURY WIRES DOWN/FIRE ROX RES9 ROX FD1 Primary Incident: 00109

Seymour, CT
Contact: support@active911.com
Sender: globalpaging@nowestps.org
(From Northwest) 21 LANTERN DR  SEYMOUR PSYCHIATRIC PROBLEM TANGO 5 SEY 1ST Primary Incident: 012658 21 LANTERN DR
(From Northwest) 15 SHARI DR, Apt. B  SEYMOUR DIFFICULTY BREATHING, SOB TANGO 5 SEY 1ST Primary Incident: 012581 15 SHARI DR, Apt. B
(From Northwest) 1 ELMWOOD DR  SEYMOUR CONVULSION/SEIZURE CONT/MULTI SEIZURES TANGO 5 SEY 1ST Primary Incident: 012603 1 ELMWOOD DR
(From Northwest) DE*FOREST ST & MAIN ST  SEYMOUR MVA PEDESTRIAN TANGO 6 SEY 1ST Primary Incident: 012610 DE*FOREST ST & MAIN ST

Roxbury, CT
Contact: Active911
Agency name: Roxbury EMS Location: Roxbury, CT 
Sender: globalpaging@nowestps.org
(From Northwest) CHURCH HILL RD & CALHOUN ST  WASHINGTON MVA EMS RX AMB 2 Primary Incident: 041432 CHURCH HILL RD & CALHOUN ST
(From Northwest) 191 RIVER RD  ROXBURY FIRE ALARM RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1 Primary Incident: 00091 191 RIVER RD
(From Northwest) 43 MINE HILL RD  ROXBURY FALLS POSS DANGER BODY AREA ROX AMB RO EMSX Primary Incident: 041718 43 MINE HILL RD
(From Northwest) 102 PAINTER HILL RD  ROXBURY FIRE ALARM RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1 Primary Incident: 00093 102 PAINTER HILL RD

*/

public class CTNorthwestPublicSafetyParserTest extends BaseParserTest {
  
  public CTNorthwestPublicSafetyParserTest() {
    setParser(new CTNorthwestPublicSafetyParser(), "", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:FLAG SWAMP RD & SOUTH ST  ROXBURY MVA EMS ROX AMB RO EMSX RO ENG12 ROX RES9 ROX FD1 Primary Incident: 040734\n\n(End)",
        "ADDR:FLAG SWAMP RD & SOUTH ST",
        "CITY:ROXBURY",
        "CALL:MVA EMS",
        "UNIT:ROX AMB RO EMSX RO ENG12 ROX RES9 ROX FD1",
        "ID:040734");

    doTest("T2",
        "FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:39 TRANSYLVANIA RD  ROXBURY CHOKING ABNORM BREATH (PARTIAL OBSTRUCT) ROX AMB RO EMSX Primary Incident: 040410\n\n(End)",
        "ADDR:39 TRANSYLVANIA RD",
        "CITY:ROXBURY",
        "CALL:CHOKING ABNORM BREATH (PARTIAL OBSTRUCT)",
        "UNIT:ROX AMB RO EMSX",
        "ID:040410");

    doTest("T3",
        "FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:102 PAINTER HILL RD  ROXBURY FAINTING/SYNCOPE ROX AMB RO EMSX Primary Incident: 040378\n\n(End)",
        "ADDR:102 PAINTER HILL RD",
        "CITY:ROXBURY",
        "CALL:FAINTING / SYNCOPE",
        "UNIT:ROX AMB RO EMSX",
        "ID:040378");

    doTest("T4",
        "FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:314 PAINTER HILL RD  ROXBURY FIRE ALARM RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1 Primary Incident: 00120\n\n(End)",
        "ADDR:314 PAINTER HILL RD",
        "CITY:ROXBURY",
        "CALL:FIRE ALARM",
        "UNIT:RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1",
        "ID:00120");

    doTest("T5",
        "FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:71 SOUTH ST  ROXBURY FIRE ALARM RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1 Primary Incident: 00119\n\n\n(End)",
        "ADDR:71 SOUTH ST",
        "CITY:ROXBURY",
        "CALL:FIRE ALARM",
        "UNIT:RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1",
        "ID:00119");

    doTest("T6",
        "FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:BOTSFORD HILL RD & GOLDEN HARVEST RD  ROXBURY WIRES DOWN/FIRE ROX RES9 ROX FD1 Primary Incident: 00109",
        "ADDR:BOTSFORD HILL RD & GOLDEN HARVEST RD",
        "CITY:ROXBURY",
        "CALL:WIRES DOWN / FIRE",
        "UNIT:ROX RES9 ROX FD1",
        "ID:00109");
    
  }
  
  @Test
  public void testSeymour() {

    doTest("T1",
        "(From Northwest) 21 LANTERN DR  SEYMOUR PSYCHIATRIC PROBLEM TANGO 5 SEY 1ST Primary Incident: 012658 21 LANTERN DR",
        "ADDR:21 LANTERN DR",
        "CITY:SEYMOUR",
        "CALL:PSYCHIATRIC PROBLEM",
        "UNIT:TANGO 5 SEY 1ST",
        "ID:012658");

    doTest("T2",
        "(From Northwest) 15 SHARI DR, Apt. B  SEYMOUR DIFFICULTY BREATHING, SOB TANGO 5 SEY 1ST Primary Incident: 012581 15 SHARI DR, Apt. B",
        "ADDR:15 SHARI DR",
        "APT:B",
        "CITY:SEYMOUR",
        "CALL:DIFFICULTY BREATHING SOB",
        "UNIT:TANGO 5 SEY 1ST",
        "ID:012581");

    doTest("T3",
        "(From Northwest) 1 ELMWOOD DR  SEYMOUR CONVULSION/SEIZURE CONT/MULTI SEIZURES TANGO 5 SEY 1ST Primary Incident: 012603 1 ELMWOOD DR",
        "ADDR:1 ELMWOOD DR",
        "CITY:SEYMOUR",
        "CALL:CONVULSION / SEIZURE CONT / MULTI SEIZURES",
        "UNIT:TANGO 5 SEY 1ST",
        "ID:012603");

    doTest("T4",
        "(From Northwest) DE*FOREST ST & MAIN ST  SEYMOUR MVA PEDESTRIAN TANGO 6 SEY 1ST Primary Incident: 012610 DE*FOREST ST & MAIN ST",
        "ADDR:DE*FOREST ST & MAIN ST",
        "CITY:SEYMOUR",
        "CALL:MVA PEDESTRIAN",
        "UNIT:TANGO 6 SEY 1ST",
        "ID:012610");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(From Northwest) CHURCH HILL RD & CALHOUN ST  WASHINGTON MVA EMS RX AMB 2 Primary Incident: 041432 CHURCH HILL RD & CALHOUN ST",
        "ADDR:CHURCH HILL RD & CALHOUN ST",
        "CITY:WASHINGTON",
        "CALL:MVA EMS RX AMB 2",
        "ID:041432");

    doTest("T2",
        "(From Northwest) 191 RIVER RD  ROXBURY FIRE ALARM RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1 Primary Incident: 00091 191 RIVER RD",
        "ADDR:191 RIVER RD",
        "CITY:ROXBURY",
        "CALL:FIRE ALARM",
        "UNIT:RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1",
        "ID:00091");

    doTest("T3",
        "(From Northwest) 43 MINE HILL RD  ROXBURY FALLS POSS DANGER BODY AREA ROX AMB RO EMSX Primary Incident: 041718 43 MINE HILL RD",
        "ADDR:43 MINE HILL RD",
        "CITY:ROXBURY",
        "CALL:FALLS POSS DANGER BODY AREA",
        "UNIT:ROX AMB RO EMSX",
        "ID:041718");

    doTest("T4",
        "(From Northwest) 102 PAINTER HILL RD  ROXBURY FIRE ALARM RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1 Primary Incident: 00093 102 PAINTER HILL RD",
        "ADDR:102 PAINTER HILL RD",
        "CITY:ROXBURY",
        "CALL:FIRE ALARM",
        "UNIT:RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1",
        "ID:00093");

  }
  
  public static void main(String[] args) {
    new CTNorthwestPublicSafetyParserTest().generateTests("T1", "ADDR CITY CALL UNIT ID");
  }
}