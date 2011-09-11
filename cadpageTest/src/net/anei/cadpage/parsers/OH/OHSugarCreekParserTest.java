package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.OH.OHSugarCreekParser;

import org.junit.Test;


public class OHSugarCreekParserTest extends BaseParserTest {
  
  public OHSugarCreekParserTest() {
    setParser(new OHSugarCreekParser(), "SugarCreek", "OH");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "Ct:EMS MINOR       Loc:4336 STATE RT 725            Apt:      XSt:BAYBERRY COVE D LAKEMAN DR      Grid:003F Units:72                                        Rmk:",
        "CALL:EMS MINOR",
        "X:BAYBERRY COVE D LAKEMAN DR",
        "MAP:003F",
        "ADDR:4336 STATE RT 725",
        "UNIT:72"
        );

    doTest("T2",
        "Ct:FIRE ALARM - RE Loc:4334 KILLIAN CT              Apt:      XSt:BELFAST DR                      Grid:0001 Units:M71   B70   P219                          Rmk:",
        "CALL:FIRE ALARM - RE",
        "MAP:0001",
        "X:BELFAST DR",
        "UNIT:M71 B70 P219",
        "ADDR:4334 KILLIAN CT"
        );
    
    doTest("T3",
        "Ct:EMS MINOR       Loc:I 675 N/8MM                  Apt:      XSt:WILMINGTON PIKE FEEDWIRE RD     Grid:0045 Units:72                                        Rmk:",
        "CALL:EMS MINOR",
        "ADDR:I 675 N & 8MM",
        "X:WILMINGTON PIKE FEEDWIRE RD",
        "MAP:0045",
        "UNIT:72"
        );
    
    doTest("T4",
        "Ct:TRAFFIC ACCIDEN Loc:FEEDWIRE RD/WINSHIRE TER     Apt:      XSt:LITTLE SUGARCRE LEDGESTONE BLVD Grid:0002 Units:C70   B70   E71   M72   P228              Rmk:",
        "CALL:TRAFFIC ACCIDEN",
        "ADDR:FEEDWIRE RD & WINSHIRE TER",
        "X:LITTLE SUGARCRE LEDGESTONE BLVD",
        "MAP:0002",
        "UNIT:C70 B70 E71 M72 P228"
        );
    
    doTest("T5",
        "Ct:OTHER FIRE      Loc:5980 WILMINGTON PIKE         Apt:      XSt:CLYO RD         WILMINGTON PIKE Grid:003A Units:72                                        Rmk:",
        "CALL:OTHER FIRE",
        "X:CLYO RD & WILMINGTON PIKE",
        "MAP:003A",
        "ADDR:5980 WILMINGTON PIKE",
        "UNIT:72"
        );
    
    doTest("T6",
        "Ct:EMS MINOR       Loc:6244 WILMINGTON PIKE         Apt:      XSt:CLYO RD         CENTER POINT DR Grid:003B Units:E74   M72   R70   P241",
        "CALL:EMS MINOR",
        "X:CLYO RD & CENTER POINT DR",
        "MAP:003B",
        "ADDR:6244 WILMINGTON PIKE",
        "UNIT:E74 M72 R70 P241");
        
    
  }
}
