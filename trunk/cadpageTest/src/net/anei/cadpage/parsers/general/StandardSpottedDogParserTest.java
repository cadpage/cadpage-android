package net.anei.cadpage.parsers.general;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Spotted Dog Technolgoies
Hanover County, VA
Contact: Mike Ishler <mjishler@gmail.com>
Sender: shlandfire@response.spotteddogtech.com

E01|VehCrash|97 N INTERSTATE 95 , Ashland, VA|R Map 83-3 SINGLE VEH ACCIDENT INTO THE WOODS IN THE |MEDIAN; BLU SMALL 2D COUPE; UNK INJ/LEAK
E01|Cardiac|12789 MOUNT HERMON RD , Ashland, VA|R Map 98-2 HUSBAND POSS DEAD |VOIP:
E01|StrComm|113 N WASHINGTON HW SUITE A , Ashland, VA|R Map 83-3 ACTIVE FIRE / EVACUATING |
E01|AlmResd|14494 RIVERSIDE DR , Ashland, VA|R Map 65 KOYA | FIRE ALARM , BONUS ROOM HEAT AND SMOKE RESD BRUTON/7526862
E01|DifBreathn|421 HENRY ST ROOM 14 , Ashland, VA|R Map 82-4 STUDENT ON CAMPUS DIFF BREATHING, TURNING |PALE, EXCRUTIATING PAIN ON R SIDE, C
E01|DifBreathn|650 N WASHINGTON HW , Ashland, VA|R Map 83-2 DIFF BRTH HAS DEFIBULATOR |

 */
public class StandardSpottedDogParserTest extends BaseParserTest {
  
  public StandardSpottedDogParserTest() {
    setParser(new StandardSpottedDogParser(), "", "");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "E01|VehCrash|97 N INTERSTATE 95 , Ashland, VA|R Map 83-3 SINGLE VEH ACCIDENT INTO THE WOODS IN THE |MEDIAN; BLU SMALL 2D COUPE; UNK INJ/LEAK",
        "UNIT:E01",
        "CALL:VehCrash",
        "ADDR:97 N INTERSTATE 95",
        "CITY:Ashland",
        "ST:VA",
        "MAP:83-3",
        "INFO:SINGLE VEH ACCIDENT INTO THE WOODS IN THE / MEDIAN; BLU SMALL 2D COUPE; UNK INJ/LEAK");

    doTest("T2",
        "E01|Cardiac|12789 MOUNT HERMON RD , Ashland, VA|R Map 98-2 HUSBAND POSS DEAD |VOIP:",
        "UNIT:E01",
        "CALL:Cardiac",
        "ADDR:12789 MOUNT HERMON RD",
        "CITY:Ashland",
        "ST:VA",
        "MAP:98-2",
        "INFO:HUSBAND POSS DEAD / VOIP:");

    doTest("T3",
        "E01|StrComm|113 N WASHINGTON HW SUITE A , Ashland, VA|R Map 83-3 ACTIVE FIRE / EVACUATING |",
        "UNIT:E01",
        "CALL:StrComm",
        "ADDR:113 N WASHINGTON HW",
        "MADDR:113 N WASHINGTON HWY",
        "APT:A",
        "CITY:Ashland",
        "ST:VA",
        "MAP:83-3",
        "INFO:ACTIVE FIRE / EVACUATING");

    doTest("T4",
        "E01|AlmResd|14494 RIVERSIDE DR , Ashland, VA|R Map 65 KOYA | FIRE ALARM , BONUS ROOM HEAT AND SMOKE RESD BRUTON/7526862",
        "UNIT:E01",
        "CALL:AlmResd",
        "ADDR:14494 RIVERSIDE DR",
        "CITY:Ashland",
        "ST:VA",
        "MAP:65",
        "INFO:KOYA / FIRE ALARM , BONUS ROOM HEAT AND SMOKE RESD BRUTON/7526862");

    doTest("T5",
        "E01|DifBreathn|421 HENRY ST ROOM 14 , Ashland, VA|R Map 82-4 STUDENT ON CAMPUS DIFF BREATHING, TURNING |PALE, EXCRUTIATING PAIN ON R SIDE, C",
        "UNIT:E01",
        "CALL:DifBreathn",
        "ADDR:421 HENRY ST",
        "APT:14",
        "CITY:Ashland",
        "ST:VA",
        "MAP:82-4",
        "INFO:STUDENT ON CAMPUS DIFF BREATHING, TURNING / PALE, EXCRUTIATING PAIN ON R SIDE, C");

    doTest("T6",
        "E01|DifBreathn|650 N WASHINGTON HW , Ashland, VA|R Map 83-2 DIFF BRTH HAS DEFIBULATOR |",
        "UNIT:E01",
        "CALL:DifBreathn",
        "ADDR:650 N WASHINGTON HW",
        "MADDR:650 N WASHINGTON HWY",
        "CITY:Ashland",
        "ST:VA",
        "MAP:83-2",
        "INFO:DIFF BRTH HAS DEFIBULATOR");

  }
  
  public static void main(String[] args) {
    new StandardSpottedDogParserTest().generateTests("T1");
  }
}