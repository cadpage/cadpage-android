package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.IA.IABlackHawkCountyParser;

import org.junit.Test;


public class IABlackHawkCountyParserTest extends BaseParserTest {
  
  public IABlackHawkCountyParserTest() {
    setParser(new IABlackHawkCountyParser(), "BLACK HAWK COUNTY", "IA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "10-127299 MVA ROLLOVER/20 HWY SERGEANT RD WATERLOO",
        "ID:10-127299",
        "CALL:MVA ROLLOVER /",
        "ADDR:20 HWY SERGEANT RD",
        "CITY:WATERLOO");
    
    doTest("T2",
        "10-124880 MVA ROLLOVER 1941 W 6TH ST EUREKA/ MITCHELL/WATERLOO",
        "ID:10-124880",
        "CALL:MVA ROLLOVER",
        "ADDR:1941 W 6TH ST",
        "X:EUREKA / MITCHELL",
        "CITY:WATERLOO");
   
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[] (Dispatch) 12-092660 ALLERGIES/HIVES/STING/MEDREACT \r\n" +
        "Reported: 09/03/2012 14:41:50 \r\n" +
        "6615 LAFAYETTE RD \r\n" +
        "4TH ST / 3 RD ST (RA/YMOND RD \r\n" +
        "JOE THOME TRUCKING RAYMO\r\n",

        "ID:12-092660",
        "CALL:ALLERGIES/HIVES/STING/MEDREACT",
        "DATE:09/03/2012",
        "TIME:14:41:50",
        "ADDR:6615 LAFAYETTE RD",
        "X:4TH ST / 3 RD ST (RA/YMOND RD",
        "PLACE:JOE THOME TRUCKING",
        "CITY:RAYMOND");

    doTest("T2",
        "[] (Dispatch) 12-087578 BURNING COMPLAINT\r\n" +
        "Reported: 08/21/2012 17:21:39\r\n" +
        "504 S 3RD ST\r\n" +
        "DUBUQUE / S S CT/\r\n" +
        "MARSHALL,DAVID M3407  LID 6661 RAYMOND\r\n" +
        "921\r\n",

        "ID:12-087578",
        "CALL:BURNING COMPLAINT",
        "DATE:08/21/2012",
        "TIME:17:21:39",
        "ADDR:504 S 3RD ST",
        "X:DUBUQUE / S S CT/",
        "PLACE:MARSHALL,DAVID M3407  LID 6661",
        "CITY:RAYMOND",
        "UNIT:921");

  }
  
  public static void main(String[] args) {
    new IABlackHawkCountyParserTest().generateTests("T1");
  }
}