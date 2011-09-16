package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MDAlleganyCountyParserOldTest extends BaseParserTest {
  
  public MDAlleganyCountyParserOldTest() {
    setParser(new MDAlleganyCountyOldParser(), "ALLEGANY COUNTY", "MD");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 100110-96\nMSG:UNCONCIOUS/UNRESPONSIVE 91 S BROADWAY\nUnits: A53 CO16",
        "ID:100110-96",
        "CALL:UNCONCIOUS/UNRESPONSIVE",
        "ADDR:91 S BROADWAY",
        "UNIT:A53 CO16");
  
    doTest("T2",
        "FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 100710-102\nMSG:AUTOMATIC HOUSE ALARM 106 SUNSET DR\nUnits: CO2 ENG9 A52 TR16",
        "ID:100710-102",
        "CALL:AUTOMATIC HOUSE ALARM",
        "ADDR:106 SUNSET DR",
        "UNIT:CO2 ENG9 A52 TR16");
    
    doTest("T3",
        "FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 101310-67\nMSG:HOUSE FIRE           147 ORMAND ST\nUnits: ENG16 TR16 ENG17",
        "ID:101310-67",
        "CALL:HOUSE FIRE",
        "ADDR:147 ORMAND ST",
        "UNIT:ENG16 TR16 ENG17");
    
    doTest("T4",
        "FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 101510-80\nMSG:HOUSE FIRE           72 HOSPITAL ROAD\nUnits: ENG16 TR16 ENG17",
        "ID:101510-80",
        "CALL:HOUSE FIRE",
        "ADDR:72 HOSPITAL ROAD",
        "UNIT:ENG16 TR16 ENG17");
    
    doTest("T5",
        "FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 100210-88\nMSG:SMOKE INVESTIGATION  U:LOWER CONSEL RD\nUnits: CO16",
        "ID:100210-88",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:LOWER CONSEL RD",
        "UNIT:CO16");
    
    doTest("T6",
        "FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 110510-132\nMSG:AUTOMATIC HOUSE ALARM 150 MAPLE ST\tUnits: ENG16 TR16 ENG17",
        "ID:110510-132",
        "CALL:AUTOMATIC HOUSE ALARM",
        "ADDR:150 MAPLE ST",
        "UNIT:ENG16 TR16 ENG17");

    doTest("T7",
        "LogiSYSCAD S:CAD Page for CFS 051211-55 M:SERVICE CALL NOT LISTED NEW CREEK                                       Units: A50     \n",
        "ID:051211-55",
        "CALL:SERVICE CALL NOT LISTED NEW CREEK",
        "UNIT:A50");

    doTest("T8",
        "LogiSYS  S:CAD Page for CFS 060811-52 M:CHEST PAINS/HEART PROBLEMS 81 E MECHANIC ST                                Units: 355     \n\n",
        "ID:060811-52",
        "CALL:CHEST PAINS/HEART PROBLEMS",
        "ADDR:81 E MECHANIC ST",
        "UNIT:355");
  }
  
  public static void main(String[] args) {
    new MDAlleganyCountyParserOldTest().generateTests("T8");
  }
}