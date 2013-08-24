package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Windham County, CT (variant B)
Contact: Active911
Agency name: WCMH
Location: Willimantic, CT, United States
Sender: wpdpaging@gmail.com

1300000897 ALS EMS RESPONSE  00080  GILEAD ST  HEBRON  130118 17:40   ALT MENTAL STATUS 6 Y/O
1300000896 ALS EMS RESPONSE  00184  CHEWINK RD  CHAPLIN  130118 16:41   DIFF BREATHING
1300000876 ALS EMS RESPONSE  00022  HUSKY CIRCLE   STORRS  130118 11:43   ALERGIC REACTION,APT 210
1300000867 ALS EMS RESPONSE  RT 66 /WEST ST  COLUMBIA  130118 07:49,MVA WITH ENTRAPMENT
1300000809 ALS EMS RESPONSE  00140  WESTFORD RD  ASHFORD  130117 09:33  ASHFORD SCHOOL, SYNCOPE
1300000775 ALS EMS RESPONSE  00100  WARREN CIR S  EAGLEVILLE RD MANSFIELD  130116 12:40   ALTERED MENTAL STATUS
1300000764 ALS EMS RESPONSE  00085  SECKAR RD  ASHFORD  130116 09:09, 

*/


public class CTWindhamCountyBParserTest extends BaseParserTest {
  
  public CTWindhamCountyBParserTest() {
    setParser(new CTWindhamCountyBParser(), "WINDHAM COUNTY", "CT");
  }
  
  @Test
  public void testWMH() {

    doTest("T1",
        "1300000897 ALS EMS RESPONSE  00080  GILEAD ST  HEBRON  130118 17:40   ALT MENTAL STATUS 6 Y/O",
        "ID:1300000897",
        "CALL:ALS EMS RESPONSE",
        "ADDR:80 GILEAD ST",
        "CITY:HEBRON",
        "DATE:01/18/13",
        "TIME:17:40",
        "INFO:ALT MENTAL STATUS 6 Y/O");

    doTest("T2",
        "1300000896 ALS EMS RESPONSE  00184  CHEWINK RD  CHAPLIN  130118 16:41   DIFF BREATHING",
        "ID:1300000896",
        "CALL:ALS EMS RESPONSE",
        "ADDR:184 CHEWINK RD",
        "CITY:CHAPLIN",
        "DATE:01/18/13",
        "TIME:16:41",
        "INFO:DIFF BREATHING");

    doTest("T3",
        "1300000876 ALS EMS RESPONSE  00022  HUSKY CIRCLE   STORRS  130118 11:43   ALERGIC REACTION,APT 210",
        "ID:1300000876",
        "CALL:ALS EMS RESPONSE",
        "ADDR:22 HUSKY CIRCLE",
        "CITY:STORRS",
        "DATE:01/18/13",
        "TIME:11:43",
        "INFO:ALERGIC REACTION,APT 210");

    doTest("T4",
        "1300000867 ALS EMS RESPONSE  RT 66 /WEST ST  COLUMBIA  130118 07:49,MVA WITH ENTRAPMENT",
        "ID:1300000867",
        "CALL:ALS EMS RESPONSE",
        "ADDR:RT 66 & WEST ST",
        "CITY:COLUMBIA",
        "DATE:01/18/13",
        "TIME:07:49",
        "INFO:MVA WITH ENTRAPMENT");

    doTest("T5",
        "1300000809 ALS EMS RESPONSE  00140  WESTFORD RD  ASHFORD  130117 09:33  ASHFORD SCHOOL, SYNCOPE",
        "ID:1300000809",
        "CALL:ALS EMS RESPONSE",
        "ADDR:140 WESTFORD RD",
        "CITY:ASHFORD",
        "DATE:01/17/13",
        "TIME:09:33",
        "INFO:ASHFORD SCHOOL, SYNCOPE");

    doTest("T6",
        "1300000775 ALS EMS RESPONSE  00100  WARREN CIR S  EAGLEVILLE RD MANSFIELD  130116 12:40   ALTERED MENTAL STATUS",
        "ID:1300000775",
        "CALL:ALS EMS RESPONSE",
        "ADDR:100 WARREN CIR",
        "X:S EAGLEVILLE RD",
        "CITY:MANSFIELD",
        "DATE:01/16/13",
        "TIME:12:40",
        "INFO:ALTERED MENTAL STATUS");

    doTest("T7",
        "1300000764 ALS EMS RESPONSE  00085  SECKAR RD  ASHFORD  130116 09:09, ",
        "ID:1300000764",
        "CALL:ALS EMS RESPONSE",
        "ADDR:85 SECKAR RD",
        "CITY:ASHFORD",
        "DATE:01/16/13",
        "TIME:09:09");

  }
  
  public static void main(String[] args) {
    new CTWindhamCountyBParserTest().generateTests("T1");
  }
}