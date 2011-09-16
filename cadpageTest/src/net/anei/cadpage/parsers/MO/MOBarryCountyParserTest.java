package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOBarryCountyParserTest extends BaseParserTest {
  
  public MOBarryCountyParserTest() {
    setParser(new MOBarryCountyParser(), "BARRY COUNTY", "MO");
  }

 
  
  @Test
  public void testParser() {

    doTest("T1",
        "BC911:ALM >ALARMS 23544 FARM ROAD 2040 BARRY COUNTY JULIE KEENER 8775350563 Map: Grids:0,0 Cad: 2011-0000015066",
        "CALL:ALARMS",
        "ADDR:23544 FARM ROAD 2040",
        "NAME:JULIE KEENER",
        "PHONE:8775350563",
        "ID:2011-0000015066");

    doTest("T2",
        "BC911:MVAUNK>MOTOR VEH ACC UNKNOWN INJ STATE HIGHWAY 39 JENKINS VERIZON WIRELESS Cad: 2011-0000009418",
        "CALL:MOTOR VEH ACC UNKNOWN INJ",
        "ADDR:STATE HIGHWAY 39",
        "CITY:JENKINS",
        "NAME:VERIZON WIRELESS",
        "ID:2011-0000009418");

    doTest("T3",
        "BC911:FIRES >STRUCTURE FIRE 23270 STATE HIGHWAY TT BARRY COUNTY CAHD REAVIS 3350036 Map: Grids:0,0 Cad: 2011-0000015655",
        "CALL:STRUCTURE FIRE",
        "ADDR:23270 STATE HIGHWAY TT",
        "NAME:CAHD REAVIS",
        "PHONE:3350036",
        "ID:2011-0000015655");
  }
  
  public static void main(String[] args) {
    new MOBarryCountyParserTest().generateTests("T1", "CALL ADDR X CITY NAME PHONE MAP PLACE ID");
  }
}