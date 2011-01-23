package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDCambridgeParser;

import org.junit.Test;


public class MDCambridgeParserTest extends BaseParserTest {
  
  public MDCambridgeParserTest() {
    setParser(new MDCambridgeParser(), "CAMBRIDGE", "MD");
  }
  
  @Test
  public void testParser() {
        
    doTest("T1",
        "DOR911:CT:COMMERCIAL FIRE ALAR 2715 OCEAN GTWY @HOLIDAY INN CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC" ,
        "CALL:COMMERCIAL FIRE ALAR",
        "ADDR:2715 OCEAN GTWY",
        "CITY:Cambridge",
        "PLACE:HOLIDAY INN",
        "BOX:1-1",
        "UNIT:EN1-1 EN1-2"
        );
    doTest("T2",
        "DOR911:CT:GAS LEAK OUTSIDE 513 RACE ST CAMB BOX:1-2 DUE: EN1-1 EN1-2 :DC" ,
        "CALL:GAS LEAK OUTSIDE",
        "ADDR:513 RACE ST",
        "CITY:Cambridge",
        "BOX:1-2",
        "UNIT:EN1-1 EN1-2"
        );
    doTest("T3",
        "DOR911:CT:VEHICLE FIRE HARDEES @800 WOODS RD CAMB BOX:1-1 DUE:EN1-3 EN1-4 :DC" ,
        "CALL:VEHICLE FIRE HARDEES",
        "ADDR:800 WOODS RD",
        "CITY:Cambridge",
        "BOX:1-1",
        "UNIT:EN1-3 EN1-4"
        );
   
  }
}