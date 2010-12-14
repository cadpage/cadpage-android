package net.anei.cadpage.parsers;

import org.junit.Test;


public class MDPrinceGeorgesCountyParserTest extends BaseParserTest {
  
  public MDPrinceGeorgesCountyParserTest() {
    setParser(new MDPrinceGeorgesCountyParser(), "PRINCE GEORGES COUNTY", "MD");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "55: BUILDING FIRE\nE809 TK809 BO804\n4637 37TH ST (ALLISON ST & DEAD END)\n12/07 04:51\nhttp://fireblitz.com/09/9.html",
        "SRC:55",
        "CALL:BUILDING FIRE",
        "UNIT:E809 TK809 BO804",
        "ADDR:4637 37TH ST",
        "X:ALLISON ST & DEAD END");
        
    doTest("T2",
        "0-2 H12: PI\nS11 R11\nPG INDIAN HEAD HWY/FARMINGTON RD WEST\nNotes: WANTS ENGINE AND AMBULANCE FROM STATION 11\n12/07 06:14\nhttp://fireblitz.com/11/0.html",
        "SRC:0",
        "MAP:2 H12",
        "CALL:PI",
        "UNIT:S11 R11",
        "ADDR:INDIAN HEAD HWY & FARMINGTON RD WEST",
        "INFO:WANTS ENGINE AND AMBULANCE FROM STATION 11");
    
    doTest("T3",
        "26: INVESTIGATION\nE817\n6036 PARKLAND CT (OLD SILVER HILL RD & OLD SILVER HILL RD)\n12/06 22:40\nhttp://fireblitz.com/17/9.html",
        "SRC:26",
        "CALL:INVESTIGATION",
        "UNIT:E817",
        "ADDR:6036 PARKLAND CT",
        "X:OLD SILVER HILL RD & OLD SILVER HILL RD");
      
    doTest("T4",
        "48: FD ACCIDENT\nSQ818 B802\nANNAPOLIS RD/PRINCESS GARDEN PY (9006 ANNAPOLIS RD/5900 PRINCESS GARD\n12/07 07:02\nhttp://fireblitz.com/18/6.html",
        "SRC:48",
        "CALL:FD ACCIDENT",
        "UNIT:SQ818 B802",
        "ADDR:ANNAPOLIS RD & PRINCESS GARDEN PY",
        "X:9006 ANNAPOLIS RD/5900 PRINCESS GARD");
      
    doTest("T5",
        "24: OVERDOSE - ALS\nA824 MD847, CHARLIE OD/NOT ALRT\n1605 AIRPORT LN (SCHALL RD & BERRY RD)\n12/07 07:14\nhttp://fireblitz.com/24/8.html",
        "SRC:24",
        "CALL:OVERDOSE - ALS",
        "UNIT:A824 MD847",
        "ADDR:1605 AIRPORT LN",
        "X:SCHALL RD & BERRY RD");
      
    doTest("T6",
        "27: INJURED/SICK\nA827\n6304 MAXWELL DR #4 (CARSWELL AV & MORRIS AV)\n12/07 05:14\nhttp://fireblitz.com/27/2.html",
        "SRC:27",
        "CALL:INJURED/SICK",
        "UNIT:A827",
        "ADDR:6304 MAXWELL DR #4",
        "X:CARSWELL AV & MORRIS AV");
      
    doTest("T7",
        "46: BUILDING FIRE\nE833 TK833 BO802\n1200 CAPITAL CENTER BL (BLVD AT THE CAP CTR)\n12/07 00:51\nhttp://fireblitz.com/33/9.html",
        "SRC:46",
        "CALL:BUILDING FIRE",
        "UNIT:E833 TK833 BO802",
        "ADDR:1200 CAPITAL CENTER BL",
        "X:BLVD AT THE CAP CTR");
      
    doTest("T8",
        "46: BUILDING FIRE\nE837 TK837 BO802\n1200 CAPITAL CENTER BL (BLVD AT THE CAP CTR)\n12/07 00:51\nhttp://fireblitz.com/37/5.html",
        "SRC:46",
        "CALL:BUILDING FIRE",
        "UNIT:E837 TK837 BO802",
        "ADDR:1200 CAPITAL CENTER BL",
        "X:BLVD AT THE CAP CTR");
      
    doTest("T9",
        "49: MEDIC LOCAL\nA849\n13218 DEERFIELD RD (DEAD END & MATTHEWS CT)\n12/06 23:00\nhttp://fireblitz.com/49/1.html",
        "SRC:49",
        "CALL:MEDIC LOCAL",
        "UNIT:A849",
        "ADDR:13218 DEERFIELD RD",
        "X:DEAD END & MATTHEWS CT");
 }
}