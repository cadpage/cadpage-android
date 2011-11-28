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
        "ADDR:7610 EASY ST",
        "X:BENSTON RD & WHITEHALL RD",
        "CALL:MED1");

    doTest("T2",
        "CAD:FYI: ;322 E MUSKEGON AV;S LIVINGSTON ST;S BALDWIN ST;WIRED",
        "ADDR:322 E MUSKEGON AV",
        "MADDR:322 E MUSKEGON AVE",
        "X:S LIVINGSTON ST & S BALDWIN ST",
        "CALL:WIRED");
    
    doTest("T3",
        "CAD:FYI: ;1387 W HOLTON WHITEHALL RD;AUTOMOBILE RD;HYDE PARK RD;MED1",
        "CALL:Unkown",
        "ADDR:1387 W HOLTON WHITEHALL RD",
        "X:AUTOMOBILE RD & HYDE PARK RD",
        "CALL:MED1");
        
    doTest("T4",
        "CAD:FYI: ;823 S LIVINGSTON ST;E MUSKEGON AV;E LEWIS ST;MED1",
        "ADDR:823 S LIVINGSTON ST",
        "X:E MUSKEGON AV & E LEWIS ST",
        "CALL:MED1"
        );
        
    doTest("T5",
        "CAD:FYI: ;2715 N WEBER RD;DULEY DR;W MCMILLAN RD;FGRAS",
        "ADDR:2715 N WEBER RD",
        "X:DULEY DR & W MCMILLAN RD",
        "CALL:FGRAS"
        );
    doTest("T6",
        "CAD:FYI: ;N WEBER RD/W MICHILLINDA RD;PI1",
        "ADDR:N WEBER RD & W MICHILLINDA RD",
        "CALL:PI1");
    doTest("T7",
        "CAD:FYI: ;ADMIRAL PETROLEUM CO;1007 E COLBY ST;S HALL ST;PETERSON RD;PI1",
        "PLACE:ADMIRAL PETROLEUM CO",
        "ADDR:1007 E COLBY ST",
        "X:S HALL ST & PETERSON RD",
        "CALL:PI1");

    doTest("T8",
        "CAD:FYI: ;180 W ASHLAND ST;AUBURN RD;CENTRAL RD;MED1",
        "ADDR:180 W ASHLAND ST",
        "X:AUBURN RD & CENTRAL RD",
        "CALL:MED1");
  }
  
  public static void main(String[] args) {
    new MIMuskegonCountyParserTest().generateTests("T8", "PLACE ADDR X CALL");
  }
}
