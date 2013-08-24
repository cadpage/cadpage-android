package net.anei.cadpage.parsers;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/**

Contact: Active911
CALL:CHARLIE HEART PROBLEM - UNKNOWN STATUS\nPLACE:\nADDR:2467 CANDLEWICK CT\nDATE: 07/01/2013\nTIME: 11:15:48\nCITY:LOWER MACUNGIE TWP\nDST:PA\nX:2458 LANTERN LN\nSRC:ST6600\nUNIT:FD/ST66 FD/A6681, ST6600\nINFO:58 YOM / CHEST PAINS - PAIN IN MIDDLE OF CHEST RAD INTO THE BACK - NAUSUE\nNAME: HARDING JAMES G\nPARSER: PALehighCounty\n\nAlert + 03:58 Update: \n   New units: FD/A6683, ST6600\n

 */
public class Active911ParserTest extends BaseParserTest {
  
  public Active911ParserTest() {
    setParser(new Active911Parser(), "", "");
  }
  
  @Test
  public void testActive911() {
    
    setDefaults("", "PA");
    setExpMapCode("PALehighCounty");
    doTest("T1",
        "CALL:CHARLIE HEART PROBLEM - UNKNOWN STATUS\nPLACE:\nADDR:2467 CANDLEWICK CT\nDATE: 07/01/2013\nTIME: 11:15:48\nCITY:LOWER MACUNGIE TWP\nDST:PA\nX:2458 LANTERN LN\nSRC:ST6600\nUNIT:FD/ST66 FD/A6681, ST6600\nINFO:58 YOM / CHEST PAINS - PAIN IN MIDDLE OF CHEST RAD INTO THE BACK - NAUSUE\nNAME: HARDING JAMES G\nPARSER: PALehighCounty\n\nAlert + 03:58 Update: \n   New units: FD/A6683, ST6600\n",
        "CALL:CHARLIE HEART PROBLEM - UNKNOWN STATUS",
        "ADDR:2467 CANDLEWICK CT",
        "DATE:07/01/2013",
        "TIME:11:15:48",
        "CITY:LOWER MACUNGIE TWP",
        "X:2458 LANTERN LN",
        "SRC:ST6600",
        "UNIT:FD/ST66 FD/A6681, ST6600",
        "INFO:58 YOM / CHEST PAINS - PAIN IN MIDDLE OF CHEST RAD INTO THE BACK - NAUSUE\nAlert + 03:58 Update: \n   New units: FD/A6683, ST6600",
        "NAME:HARDING JAMES G");

  }
  
  public static void main(String[] args) {
 //   new Cadpage2ParserTest().generateTests("T1", "CALL PLACE ADDR CITY ID PRI DATE TIME MAP UNIT INFO");
  }
}