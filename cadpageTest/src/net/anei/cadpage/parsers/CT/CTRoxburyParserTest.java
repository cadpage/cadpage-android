package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CTRoxburyParserTest extends BaseParserTest {
  
  public CTRoxburyParserTest() {
    setParser(new CTRoxburyParser(), "ROXBURY", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:FLAG SWAMP RD & SOUTH ST  ROXBURY MVA EMS ROX AMB RO EMSX RO ENG12 ROX RES9 ROX FD1 Primary Incident: 040734\n\n(End)",
        "ADDR:FLAG SWAMP RD & SOUTH ST",
        "CITY:ROXBURY",
        "CALL:MVA EMS ",
        "UNIT:ROX AMB RO EMSX RO ENG12 ROX RES9 ROX FD1",
        "ID:040734");

    doTest("T2",
        "FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:39 TRANSYLVANIA RD  ROXBURY CHOKING ABNORM BREATH (PARTIAL OBSTRUCT) ROX AMB RO EMSX Primary Incident: 040410\n\n(End)",
        "ADDR:39 TRANSYLVANIA RD",
        "CITY:ROXBURY",
        "CALL:CHOKING ABNORM BREATH (PARTIAL OBSTRUCT) ",
        "UNIT:ROX AMB RO EMSX",
        "ID:040410");

    doTest("T3",
        "FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:102 PAINTER HILL RD  ROXBURY FAINTING/SYNCOPE ROX AMB RO EMSX Primary Incident: 040378\n\n(End)",
        "ADDR:102 PAINTER HILL RD",
        "CITY:ROXBURY",
        "CALL:FAINTING / SYNCOPE ",
        "UNIT:ROX AMB RO EMSX",
        "ID:040378");

    doTest("T4",
        "FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:314 PAINTER HILL RD  ROXBURY FIRE ALARM RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1 Primary Incident: 00120\n\n(End)",
        "ADDR:314 PAINTER HILL RD",
        "CITY:ROXBURY",
        "CALL:FIRE ALARM ",
        "UNIT:RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1",
        "ID:00120");

    doTest("T5",
        "FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:71 SOUTH ST  ROXBURY FIRE ALARM RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1 Primary Incident: 00119\n\n\n(End)",
        "ADDR:71 SOUTH ST",
        "CITY:ROXBURY",
        "CALL:FIRE ALARM ",
        "UNIT:RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1",
        "ID:00119");

    doTest("T6",
        "FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:BOTSFORD HILL RD & GOLDEN HARVEST RD  ROXBURY WIRES DOWN/FIRE ROX RES9 ROX FD1 Primary Incident: 00109",
        "ADDR:BOTSFORD HILL RD & GOLDEN HARVEST RD",
        "CITY:ROXBURY",
        "CALL:WIRES DOWN / FIRE ",
        "UNIT:ROX RES9 ROX FD1",
        "ID:00109");
    
  }
  
  public static void main(String[] args) {
    new CTRoxburyParserTest().generateTests("T1", "ADDR CITY CALL UNIT ID");
  }
}