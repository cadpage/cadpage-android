package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Decatur, TX
Contact: Michael Richardson <grizzly.richardson@gmail.com>
Sender: messaging@iamresponding.com
System: Cardinal CAD SE

(Decatur FD) MEDICAL EMERGENCY, 800 MEDICAL CENTER DR #C,  - DPD 221\n\nDr Swaims office
(Decatur FD) MAJOR ACCIDENT,  730 S 287,  - DPD 221 \n\n2 vehs
(Decatur FD) STRUCTURE FIRE, 2905 MURVIL,  - DPD 207 \n\nNO SMOKE OR FLAMES BUT CAN SMELL BURNING WIRES
(Decatur FD) OTHERS, 1500 STATE ST S #31,  - DPD 211 \n\nComp smells natural gas
(Decatur FD) MEDICAL EMERGENCY, 2150 FM 51 HWY S,  - DPD 207 \n\n10:36:45 ---- MALE HIGH BLOOD PRESSURE
(Decatur FD) MEDICAL EMERGENCY, 500 COTTONWOOD E,  - DPD 207 \n\n09:29:13 ---- SHOLLOW BREATHING \n\n09:29:17 ---- 1 YOA MALE\n\n09:29:23 ---- WONT WAKE UP
(Decatur FD) MEDICAL EMERGENCY, 201 THOMPSON ST E #E 139, HATCHER,  - DPD 112
(Decatur FD) MEDICAL EMERGENCY, 147 CR 3131,  - DPD 112

*/

public class TXDecaturParserTest extends BaseParserTest {
  
  public TXDecaturParserTest() {
    setParser(new TXDecaturParser(), "DECATUR", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Decatur FD) MEDICAL EMERGENCY, 800 MEDICAL CENTER DR #C,  - DPD 221\n\nDr Swaims office",
        "SRC:Decatur FD",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:800 MEDICAL CENTER DR",
        "APT:C",
        "UNIT:DPD 221",
        "INFO:Dr Swaims office");

    doTest("T2",
        "(Decatur FD) MAJOR ACCIDENT,  730 S 287,  - DPD 221 \n\n2 vehs",
        "SRC:Decatur FD",
        "CALL:MAJOR ACCIDENT",
        "ADDR:730 S 287",
        "UNIT:DPD 221",
        "INFO:2 vehs");

    doTest("T3",
        "(Decatur FD) STRUCTURE FIRE, 2905 MURVIL,  - DPD 207 \n\nNO SMOKE OR FLAMES BUT CAN SMELL BURNING WIRES",
        "SRC:Decatur FD",
        "CALL:STRUCTURE FIRE",
        "ADDR:2905 MURVIL",
        "UNIT:DPD 207",
        "INFO:NO SMOKE OR FLAMES BUT CAN SMELL BURNING WIRES");

    doTest("T4",
        "(Decatur FD) OTHERS, 1500 STATE ST S #31,  - DPD 211 \n\nComp smells natural gas",
        "SRC:Decatur FD",
        "CALL:OTHERS",
        "ADDR:1500 STATE ST S",
        "APT:31",
        "UNIT:DPD 211",
        "INFO:Comp smells natural gas");

    doTest("T5",
        "(Decatur FD) MEDICAL EMERGENCY, 2150 FM 51 HWY S,  - DPD 207 \n\n10:36:45 ---- MALE HIGH BLOOD PRESSURE",
        "SRC:Decatur FD",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:2150 FM 51 HWY S",
        "MADDR:2150 FM 51 S",
        "UNIT:DPD 207",
        "INFO:10:36:45 ---- MALE HIGH BLOOD PRESSURE");

    doTest("T6",
        "(Decatur FD) MEDICAL EMERGENCY, 500 COTTONWOOD E,  - DPD 207 \n\n" +
        "09:29:13 ---- SHOLLOW BREATHING \n\n" +
        "09:29:17 ---- 1 YOA MALE\n\n" +
        "09:29:23 ---- WONT WAKE UP",

        "SRC:Decatur FD",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:500 COTTONWOOD E",
        "UNIT:DPD 207",
        "INFO:09:29:13 ---- SHOLLOW BREATHING \n\n09:29:17 ---- 1 YOA MALE\n\n09:29:23 ---- WONT WAKE UP");

    doTest("T7",
        "(Decatur FD) MEDICAL EMERGENCY, 201 THOMPSON ST E #E 139, HATCHER,  - DPD 112",
        "SRC:Decatur FD",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:201 THOMPSON ST E",
        "APT:E 139",
        "X:HATCHER",
        "UNIT:DPD 112");

    doTest("T8",
        "(Decatur FD) MEDICAL EMERGENCY, 147 CR 3131,  - DPD 112",
        "SRC:Decatur FD",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:147 CR 3131",
        "MADDR:147 COUNTY ROAD 3131",
        "UNIT:DPD 112");

  }
  
  public static void main(String[] args) {
    new TXDecaturParserTest().generateTests("T1");
  }
}
