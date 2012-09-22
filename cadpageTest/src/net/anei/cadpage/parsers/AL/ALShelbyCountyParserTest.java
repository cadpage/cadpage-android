package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.AL.ALShelbyCountyParserTest;

import org.junit.Test;

/*
Shelby County, AL
Contact: John Yancey <johnyancey7@gmail.com>
Sender: arns@shelby911.org

 1 of 2\nFRM:arns@shelby911.org\nSUBJ:SHELBY911 ARNS ALERT\nMSG:\r\n5/17/2012 10:39:27 AM\r\nFIRE1208398\r\nCAH_VALY - STA181\r\nSEIZURE-\r\nTACO BELL - HWY\n(Con't) 2 of 2\n280\r\n4623 280 HWY @ CAHABA PARK CIR / CAHABA PARK CIR\r\n: @TACO BELL - HWY 280\r\nBHAM FIRE(End)
 1 of 2\nFRM:arns@shelby911.org\nSUBJ:SHELBY911 ARNS ALERT\nMSG:\r\n5/17/2012 10:04:50 AM\r\nFIRE1208395\r\nCAH_VALY - STA181\r\nBLEEDING-\r\n\r\n5433 280 HWY @\n(Con't) 2 of 2\nWALT DR / TURTLE LAKE DR\r\n: 309\r\nSPRINT PCS WIRELESS(End)
 1 of 2\nFRM:arns@shelby911.org\nSUBJ:SHELBY911 ARNS ALERT\nMSG:\r\n5/17/2012 9:40:01 AM\r\nFIRE1208391\r\nCAH_VALY - STA184\r\nALARM-FIRE\r\n\r\n5116 LIBERTY\n(Con't) 2 of 2\nPKWY @ URBAN CENTER PKWY / URBAN CENTER PKWY\r\n\r\nBHM FD(End)
 1 of 2\nFRM:arns@shelby911.org\nSUBJ:SHELBY911 ARNS ALERT\nMSG:\r\n5/17/2012 6:19:47 AM\r\nFIRE1208383\r\nCAH_VALY - STA184\r\nBREATHING-\r\n\r\n1085 OLD MILL\n(Con't) 2 of 2\nRUN @ OLD MILL CIR / \r\n\r\nHUBERT, LAWSON(End)

*/

public class ALShelbyCountyParserTest extends BaseParserTest {
  
  public ALShelbyCountyParserTest() {
    setParser(new ALShelbyCountyParser(), "SHELBY COUNTY", "AL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        " 1 of 2\n" +
        "FRM:arns@shelby911.org\n" +
        "SUBJ:SHELBY911 ARNS ALERT\n" +
        "MSG:\r\n" +
        "5/17/2012 10:39:27 AM\r\n" +
        "FIRE1208398\r\n" +
        "CAH_VALY - STA181\r\n" +
        "SEIZURE-\r\n" +
        "TACO BELL - HWY\n" +
        "(Con't) 2 of 2\n" +
        "280\r\n" +
        "4623 280 HWY @ CAHABA PARK CIR / CAHABA PARK CIR\r\n" +
        ": @TACO BELL - HWY 280\r\n" +
        "BHAM FIRE(End)",

        "DATE:5/17/2012",
        "TIME:10:39:27",
        "ID:FIRE1208398",
        "SRC:CAH_VALY - STA181",
        "CALL:SEIZURE",
        "PLACE:TACO BELL - HWY 280",
        "ADDR:4623 280 HWY",
        "MADDR:4623 HWY 280",
        "X:CAHABA PARK CIR / CAHABA PARK CIR",
        "INFO:BHAM FIRE");

    doTest("T2",
        " 1 of 2\n" +
        "FRM:arns@shelby911.org\n" +
        "SUBJ:SHELBY911 ARNS ALERT\n" +
        "MSG:\r\n" +
        "5/17/2012 10:04:50 AM\r\n" +
        "FIRE1208395\r\n" +
        "CAH_VALY - STA181\r\n" +
        "BLEEDING-\r\n" +
        "\r\n" +
        "5433 280 HWY @\n" +
        "(Con't) 2 of 2\n" +
        "WALT DR / TURTLE LAKE DR\r\n" +
        ": 309\r\n" +
        "SPRINT PCS WIRELESS(End)",

        "DATE:5/17/2012",
        "TIME:10:04:50",
        "ID:FIRE1208395",
        "SRC:CAH_VALY - STA181",
        "CALL:BLEEDING",
        "ADDR:5433 280 HWY",
        "MADDR:5433 HWY 280",
        "X:WALT DR / TURTLE LAKE DR",
        "APT:309",
        "INFO:SPRINT PCS WIRELESS");

    doTest("T3",
        " 1 of 2\n" +
        "FRM:arns@shelby911.org\n" +
        "SUBJ:SHELBY911 ARNS ALERT\n" +
        "MSG:\r\n" +
        "5/17/2012 9:40:01 AM\r\n" +
        "FIRE1208391\r\n" +
        "CAH_VALY - STA184\r\n" +
        "ALARM-FIRE\r\n" +
        "\r\n" +
        "5116 LIBERTY\n" +
        "(Con't) 2 of 2\n" +
        "PKWY @ URBAN CENTER PKWY / URBAN CENTER PKWY\r\n" +
        "\r\n" +
        "BHM FD(End)",

        "DATE:5/17/2012",
        "TIME:09:40:01",
        "ID:FIRE1208391",
        "SRC:CAH_VALY - STA184",
        "CALL:ALARM-FIRE",
        "ADDR:5116 LIBERTY PKWY",
        "X:URBAN CENTER PKWY / URBAN CENTER PKWY",
        "INFO:BHM FD");

    doTest("T4",
        " 1 of 2\n" +
        "FRM:arns@shelby911.org\n" +
        "SUBJ:SHELBY911 ARNS ALERT\n" +
        "MSG:\r\n" +
        "5/17/2012 6:19:47 AM\r\n" +
        "FIRE1208383\r\n" +
        "CAH_VALY - STA184\r\n" +
        "BREATHING-\r\n" +
        "\r\n" +
        "1085 OLD MILL\n" +
        "(Con't) 2 of 2\n" +
        "RUN @ OLD MILL CIR / \r\n" +
        "\r\n" +
        "HUBERT, LAWSON(End)",

        "DATE:5/17/2012",
        "TIME:06:19:47",
        "ID:FIRE1208383",
        "SRC:CAH_VALY - STA184",
        "CALL:BREATHING",
        "ADDR:1085 OLD MILL RUN",
        "X:OLD MILL CIR",
        "INFO:HUBERT, LAWSON");

  }
  
  public static void main(String[] args) {
    new ALShelbyCountyParserTest().generateTests("T1");
  }
}