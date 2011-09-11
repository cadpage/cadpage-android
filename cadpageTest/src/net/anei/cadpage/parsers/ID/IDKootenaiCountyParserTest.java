package net.anei.cadpage.parsers.ID;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.ID.IDKootenaiCountyParserTest;

import org.junit.Test;


public class IDKootenaiCountyParserTest extends BaseParserTest {
  
  public IDKootenaiCountyParserTest() {
    setParser(new IDKootenaiCountyParser(), "KOOTENAI COUNTY", "ID");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "KOOTENAI COUNTY SHERIFF KCFR\nFIRE STRUCTURE \n1576 W TUALATIN DR\nF1A  \nF1V\nOPS1 \nVISIBLE FLAMES    IN GARAGE\n13:12:17 04/30/2011 - T.TAYLOR\nRES IS UNOCC\n13:12:50 04/30/2011 - T.TAYLOR\nVEH IN GARAGE    RP SAYS HER HOUSE IS GOING TO BLOW UP\n13:13:00 04/30/2011 - D.WILSON       \nFLAME\nSent by CLI  Sat Apr 30 13:16:15 2011\n0000 Confirm 0001 Refuse TXT STOP to opt-out",
        "SRC:KCFR",
        "CALL:FIRE STRUCTURE",
        "ADDR:1576 W TUALATIN DR",
        "UNIT:F1V",
        "CH:OPS1",
        "INFO:VISIBLE FLAMES    IN GARAGE / 13:12:17 04/30/2011 - T.TAYLOR / RES IS UNOCC / 13:12:50 04/30/2011 - T.TAYLOR / VEH IN GARAGE    RP SAYS HER HOUSE IS GOING TO BLOW UP / 13:13:00 04/30/2011 - D.WILSON / FLAME");

    doTest("T2",
        "HAUS\nACCIDENT INJURY\nN WATERFORD LOOP & N HAUSER LAKE RD\nGW7A \nB751\nOPS4 \nMC ACCIDENT    WENT OFF RDWY    CAB    POSS BROKEN COLLARS     CUTS ON FACE   \nCONTROLLED",
        "SRC:HAUS",
        "CALL:ACCIDENT INJURY",
        "ADDR:N WATERFORD LOOP & N HAUSER LAKE RD",
        "UNIT:B751",
        "CH:OPS4",
        "INFO:MC ACCIDENT    WENT OFF RDWY    CAB    POSS BROKEN COLLARS     CUTS ON FACE / CONTROLLED");

    doTest("T3",
        "KCFR\nFIRE STRUCTURE \nN SMITH LN & E MULLAN AVE\nF1C  \nF1V\nOPS1 \nTRAILER FULLY ENGULFED ON SMITH RD JUST OFF MULLAN   FLAMES FROM WINDOWS AND\nROOF \n10:49:32 05/28/20",
        "SRC:KCFR",
        "CALL:FIRE STRUCTURE",
        "ADDR:N SMITH LN & E MULLAN AVE",
        "UNIT:F1V",
        "CH:OPS1",
        "INFO:TRAILER FULLY ENGULFED ON SMITH RD JUST OFF MULLAN   FLAMES FROM WINDOWS AND / ROOF / 10:49:32 05/28/20");
 

  }
  
  public static void main(String[] args) {
    new IDKootenaiCountyParserTest().generateTests("T1", "SRC CALL ADDR UNIT CH INFO");
  }
}