package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MI.MIMuskegonCountyParser;

import org.junit.Test;


public class MIMuskegonCountyParserTest extends BaseParserTest {
  
  public MIMuskegonCountyParserTest() {
	  setParser(new MIMuskegonCountyParser(), "MUSKEGON COUNTY", "MI");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "CAD:FYI: ;7610 EASY ST;BENSTON RD;WHITEHALL RD;MED1",
        "CALL:Unkown",
        "ADDR:7610 EASY ST",
        "X:BENSTON RD/WHITEHALL RD",
        "INFO:MED1");

    doTest("T2",
        "CAD:FYI: ;322 E MUSKEGON AV;S LIVINGSTON ST;S BALDWIN ST;WIRED",
        "CALL:Unkown",
        "ADDR:322 E MUSKEGON AV",
        "X:S LIVINGSTON ST/S BALDWIN ST",
        "INFO:WIRED");
    
    doTest("T3",
        "CAD:FYI: ;1387 W HOLTON WHITEHALL RD;AUTOMOBILE RD;HYDE PARK RD;MED1",
        "CALL:Unkown",
        "ADDR:1387 W HOLTON WHITEHALL RD",
        "X:AUTOMOBILE RD/HYDE PARK RD",
        "INFO:MED1");
        
    doTest("T4",
        "CAD:FYI: ;823 S LIVINGSTON ST;E MUSKEGON AV;E LEWIS ST;MED1",
        "CALL:Unkown",
        "ADDR:823 S LIVINGSTON ST",
        "X:E MUSKEGON AV/E LEWIS ST",
        "INFO:MED1"
        );
        
    doTest("T5",
        "CAD:FYI: ;2715 N WEBER RD;DULEY DR;W MCMILLAN RD;FGRAS",
        "CALL:Unkown",
        "ADDR:2715 N WEBER RD",
        "X:DULEY DR/W MCMILLAN RD",
        "INFO:FGRAS"
        );
    doTest("T6",
        "CAD:FYI: ;N WEBER RD/W MICHILLINDA RD;PI1",
        "CALL:Unkown",
        "ADDR:N WEBER RD & W MICHILLINDA RD",
        "INFO:PI1");
 }
}
