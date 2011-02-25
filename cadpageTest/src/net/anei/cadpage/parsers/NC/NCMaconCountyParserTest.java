package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NC.NCMaconCountyParser;

import org.junit.Test;


public class NCMaconCountyParserTest extends BaseParserTest {
  
  public NCMaconCountyParserTest() {
    setParser(new NCMaconCountyParser(), "MACON COUNTY", "NC");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "911 CENTER:88S >STRUCTURE FIRE REPORTED AT 1650 WIDE HORIZON DR FRANKLIN AAAAA, AAAAA 5555559999 Map: Grids:0,0",
        "CALL:STRUCTURE FIRE",
        "ADDR:1650 WIDE HORIZON DR",
        "CITY:FRANKLIN",
        "NAME:AAAAA, AAAAA",
        "PHONE:5555559999");
    
    doTest("T2",
        "911 CENTER:90F >FIRE ALARM 120 RIVERVIEW ST FRANKLIN ANGEL MEDICAL CENTER 5555558411 Map: Grids:0,0",
        "CALL:FIRE ALARM",
        "ADDR:120 RIVERVIEW ST",
        "CITY:FRANKLIN",
        "NAME:ANGEL MEDICAL CENTER",
        "PHONE:5555558411");
    
    doTest("T3",
        "911 CENTER:88S >STRUCTURE FIRE REPORTED AT 289 SUTTON LN FRANKLIN AAAAA, AAAAAAA& AAAAAA 5555559999 Map: Grids:0,0",
        "CALL:STRUCTURE FIRE",
        "ADDR:289 SUTTON LN",
        "CITY:FRANKLIN",
        "NAME:AAAAA, AAAAAAA & AAAAAA",
        "PHONE:5555559999");
        
    doTest("T4",
        "911 CENTER:MED >EMERGENCY RUN 248 HARRISON AVE XS: W MAIN ST TO BRYSON CITY RD FRANKLIN AAAAAA, CHARMAYNE 5555559999 Map: Grids:0,0",
        "CALL:EMERGENCY RUN",
        "ADDR:248 HARRISON AVE",
        "X:W MAIN ST TO BRYSON CITY RD",
        "CITY:FRANKLIN",
        "NAME:AAAAAA, CHARMAYNE",
        "PHONE:5555559999");
    
    doTest("T5",
        "911 CENTER:C1 >EMERGENCY RUN 31 SCROGGS RD XS: LOUISA CHAPEL @ 1020 FRANKLIN VERIZON WIRELESS 8283713353 Map: Grids:0,0",
        "CALL:EMERGENCY RUN",
        "ADDR:31 SCROGGS RD",
        "X:LOUISA CHAPEL @ 1020",
        "CITY:FRANKLIN",
        "NAME:VERIZON WIRELESS",
        "PHONE:8283713353");

    doTest("T15",
        "911 CENTER:C1 >EMERGENCY RUN 730 LAKESHORE DR FRANKLIN CHRISTIAN, JOHN SMITH 8285249999 Map: Grids:0,0",
        "CALL:EMERGENCY RUN",
        "ADDR:730 LAKESHORE DR",
        "CITY:FRANKLIN",
        "NAME:CHRISTIAN, JOHN SMITH",
        "PHONE:8285249999");

    doTest("T16",
        "911 CENTER:50 >VEHICLE ACCIDENT 428 COWEETA CHURCH RD OTTO SMITH, J 8283699999 Map: Grids:0,0",
        "CALL:VEHICLE ACCIDENT",
        "ADDR:428 COWEETA CHURCH RD",
        "CITY:OTTO",
        "NAME:SMITH, J",
        "PHONE:8283699999");
  }
}
