package net.anei.cadpage.parsers;

import org.junit.Test;


public class PAMifflinCountyParserTest extends BaseParserTest {
  
  public PAMifflinCountyParserTest() {
    setParser(new PAMifflinCountyParser(), "MIFFLIN COUNTY", "PA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "(CAD Page for CFS 111710-43) ALS - Uncon/Syncope\n1 DERRY PARK DR\nApt:\nBURNHAM\nCross Streets : 400-412  S LOGAN BLVD",
        "ID:111710-43",
        "CALL:ALS - Uncon/Syncope",
        "ADDR:1 DERRY PARK DR",
        "CITY:BURNHAM",
        "X:400-412  S LOGAN BLVD");

    doTest("T2",
        "(CAD Page for CFS 111710-42) URG - Ment/Emot/Psych\n41 INDUSTRIAL PARK RD\nApt: A\nGRANVILLE\nCross Streets : 708-924  LOOP RD * 2120-2456 MIDDLE RD",
        "ID:111710-42",
        "CALL:URG - Ment/Emot/Psych",
        "ADDR:41 INDUSTRIAL PARK RD",
        "APT:A",
        "CITY:GRANVILLE TWP",
        "X:708-924  LOOP RD * 2120-2456 MIDDLE RD");
    
    doTest("T3",
        "(CAD Page for CFS 111710-37) ALS - Breathing Difficulty\n27 ANDERSON ST\nApt:\nBRATTON\nCross Streets : 1-19  MATTAWANA BLVD",
        "ID:111710-37",
        "CALL:ALS - Breathing Difficulty",
        "ADDR:27 ANDERSON ST",
        "CITY:BRATTON TWP",
        "X:1-19  MATTAWANA BLVD");
    
    doTest("T4",
        "(CAD Page for CFS 111710-2) ALS - Motor Vehicle Accident\nROSEWOOD AVE and US HIGHWAY 522 NORTH\nApt: //\nDERRY\nCross Streets : 1-24  ROSEWOOD AVE",
        "ID:111710-2",
        "CALL:ALS - Motor Vehicle Accident",
        "ADDR:ROSEWOOD AVE and US HIGHWAY 522 NORTH",
        "CITY:DERRY TWP",
        "X:1-24  ROSEWOOD AVE");
    
    doTest("T5",
        "(CAD Page for CFS 111610-52) ALS - Breathing Difficulty\n163 SUMMIT DR\nApt:\nDERRY\nCross Streets : 400-406  SIXTH ST * 1-14 CASTLE CT",
        "ID:111610-52",
        "CALL:ALS - Breathing Difficulty",
        "ADDR:163 SUMMIT DR",
        "CITY:DERRY TWP",
        "X:400-406  SIXTH ST * 1-14 CASTLE CT");
    
    doTest("T6",
        "(CAD Page for CFS 111510-56) ALS - Diabetic\n7 MAPLE ST\nApt: ////\nKISTLER\nCross Streets : 150-198  N RIVERSIDE DR * 142-148 PARK RD",
        "ID:111510-56",
        "CALL:ALS - Diabetic",
        "ADDR:7 MAPLE ST",
        "CITY:KISTLER",
        "X:150-198  N RIVERSIDE DR * 142-148 PARK RD");
 }
}