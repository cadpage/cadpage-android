package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYCortlandCountyParserTest extends BaseParserTest {
  
  public NYCortlandCountyParserTest() {
    setParser(new NYCortlandCountyParser(), "CORTLAND COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(3609 PLEASANTVIEW DR) 17:28 , EMS ONLY , 80 YO FEMALE - SUFFERS A BROKEN BACK- UNABLE TO EAT OR DRINK\n RECENTLY RELEASED FROM THE HOSPITAL FO ,",
        "ADDR:3609 PLEASANTVIEW DR",
        "CALL:EMS ONLY",
        "INFO:80 YO FEMALE - SUFFERS A BROKEN BACK- UNABLE TO EAT OR DRINK RECENTLY RELEASED FROM THE HOSPITAL FO");

    doTest("T2",
        "(839 BENNIE RD) 18:32 , EMS ONLY , 85 YO MALE- DIFF BREATHING\nASPEN WAY UNIT\n\n\n\n,",
        "ADDR:839 BENNIE RD",
        "CALL:EMS ONLY",
        "INFO:85 YO MALE- DIFF BREATHING ASPEN WAY UNIT");

    doTest("T3",
        "(697 MCLEAN RD) 15:50 , CO DETECTOR , CARBON MONOXIDE DETECTOR GOING OFF\nNEWLY BUILT HOUSE\n\n\n\n,",
        "ADDR:697 MCLEAN RD",
        "CALL:CO DETECTOR",
        "INFO:CARBON MONOXIDE DETECTOR GOING OFF NEWLY BUILT HOUSE");

    doTest("T4",
        "(3643 STHY 281) 12:31 , EMS ONLY , PARKING LOT B LARGE OVERHEAD DOOR, 27 Y/O MALE DOWN\nSYNCOPAL EPISODE\n\n\n\n,",
        "ADDR:3643 STHY 281",
        "MADDR:3643 ST 281",
        "CALL:EMS ONLY",
        "INFO:PARKING LOT B LARGE OVERHEAD DOOR, 27 Y/O MALE DOWN SYNCOPAL EPISODE");

    doTest("T5",
        "(839 BENNIE RD) 08:24 , EMS ONLY , 81 MALE IN LEGASEY COURT NOT ALERT PER NORMAL\n\n\n\n,",
        "ADDR:839 BENNIE RD",
        "CALL:EMS ONLY",
        "INFO:81 MALE IN LEGASEY COURT NOT ALERT PER NORMAL");
  }
  
  public static void main(String[] args) {
    new NYCortlandCountyParserTest().generateTests("T1", "ADDR CALL INFO");
  }
}