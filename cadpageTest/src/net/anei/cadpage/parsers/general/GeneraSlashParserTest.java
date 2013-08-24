package net.anei.cadpage.parsers.general;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.general.GeneralSlashParser;

import org.junit.Test;


public class GeneraSlashParserTest extends BaseParserTest {
  
  public GeneraSlashParserTest() {
    setParser(new GeneralSlashParser(), "", "");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "(- part 1 of 1) RC:Run# 4581/General Transport/STUBBS/ JAMES/1718 S I  ST//ER-10//TACOMA/773 G6/11315 BRIDGEPORT WAY SW",
        "ID:4581",
        "CALL:JAMES",
        "ADDR:1718 S I ST",
        "INFO:ER-10 / TACOMA / 773 G6",
        "X:11315 BRIDGEPORT WAY SW");
    
    doTest("T2",
        "S:Dispatch Center M:11-004682 GENERAL MEDICAL/AMBULANCE\n208 N 12 ST\nSTATE ST / PARK ST/\nMEDICAL ASSOCIATES OF BELLEVUE  BELLEVUE\nBEA1\n\n\n",
        "CALL:AMBULANCE",
        "ADDR:208 N 12 ST",
        "X:STATE ST & PARK ST",
        "INFO:MEDICAL ASSOCIATES OF BELLEVUE BELLEVUE",
        "UNIT:BEA1");

  }
}