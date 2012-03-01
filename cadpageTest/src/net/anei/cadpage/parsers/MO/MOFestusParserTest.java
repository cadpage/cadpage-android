package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOFestusParserTest extends BaseParserTest {
  
  public MOFestusParserTest() {
    setParser(new MOFestusParser(), "FETUS", "MO");
  }

 
  
  @Test
  public void testParser() {

    doTest("T1",
        "(call) FIRE / BRUSH / 2819 NORTH SELMA ROAD JEFFCO/R7 /DOOLING HO /EMS /6610 /jpad brush with exposer R-7 FD720146 /JPAD 603031",
        "CALL:FIRE / BRUSH",
        "ADDR:2819 NORTH SELMA ROAD",
        "CITY:JEFFERSON COUNTY",
        "SRC:R7",
        "X:DOOLING HO",
        "INFO:EMS / jpad brush with exposer R-7 FD720146",
        "UNIT:6610");

    doTest("T2",
        "(call) FIRE/10-50 J-2/ STATE RD CC JEFFCO/FESTUS FIRE / HWY 67 /FIRE DEP /H4 FI H1 FESTUS  FD66651 / JPAD H4 FI H1",
        "CALL:FIRE / 10-50 J-2",
        "ADDR:STATE RD CC",
        "MADDR:STATE CC & HWY 67",
        "CITY:JEFFERSON COUNTY",
        "SRC:FESTUS FIRE",
        "X:HWY 67",
        "INFO:FIRE DEP",
        "UNIT:H4 FI H1 FESTUS  FD66651");

    doTest("T3",
        "S:Call M:FIRE / MUTUAL AID / 12532 STATE RD TT JEFFCO/R-7 / R7SCHOOLRD / EMS / H3 FI H1 / BRUSH ENDANGERING A STRUCTURE/ 66 14 6037 \n" +
        "R-7 FD720096 / JPAD H3 FI H1\n",

        "CALL:FIRE / MUTUAL AID",
        "ADDR:12532 STATE RD TT",
        "MADDR:12532 STATE TT",
        "CITY:JEFFERSON COUNTY",
        "SRC:R-7",
        "X:R7SCHOOLRD",
        "INFO:EMS / BRUSH ENDANGERING A STRUCTURE / 66 14 6037 \nR-7 FD720096",
        "UNIT:H3 FI H1");

  }
  
  public static void main(String[] args) {
    new MOFestusParserTest().generateTests("T1");
  }
}