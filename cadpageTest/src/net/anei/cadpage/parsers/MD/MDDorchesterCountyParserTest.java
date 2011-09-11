package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDDorchesterCountyParser;

import org.junit.Test;


public class MDDorchesterCountyParserTest extends BaseParserTest {
  
  public MDDorchesterCountyParserTest() {
    setParser(new MDDorchesterCountyParser(), "DORCHESTER COUNTY", "MD");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "DOR911:CT:COMMERCIAL FIRE ALAR 2715 OCEAN GTWY @HOLIDAY INN CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC",
        "CALL:COMMERCIAL FIRE ALAR",
        "ADDR:2715 OCEAN GTWY",
        "PLACE:HOLIDAY INN",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:EN1-1 EN1-2");

    doTest("T2",
        "DOR911:CT:GAS LEAK OUTSIDE 513 RACE ST CAMB BOX:1-2 DUE: EN1-1 EN1-2 :DC",
        "CALL:GAS LEAK OUTSIDE",
        "ADDR:513 RACE ST",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:EN1-1 EN1-2");
    
    doTest("T3",
        "DOR911:CT:VEHICLE FIRE HARDEES @800 WOODS RD CAMB BOX:1-1 DUE:EN1-3 EN1-4 :DC",
        "CALL:VEHICLE FIRE HARDEES",
        "ADDR:800 WOODS RD",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:EN1-3 EN1-4");
    
    doTest("T4",
        "DOR911:CT:STRUCTURE FIRE 118 VIRGINIA AVE CAMB BOX:1-1 DUE: EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100 :DC",
        "CALL:STRUCTURE FIRE",
        "ADDR:118 VIRGINIA AVE",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100");
    
    doTest("T5",
        "DOR911:CT:SICK PERSON 5226 WOODS RD @CAMBRIDGE CLUB APT 6 APT 6127 CAMB BOX:1-1 DUE: P101 RS1-1 :DC",
        "CALL:SICK PERSON",
        "ADDR:5226 WOODS RD",
        "PLACE:CAMBRIDGE CLUB APT 6",
        "APT:6127",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P101 RS1-1");
    
  }
}