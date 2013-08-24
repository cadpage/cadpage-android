package net.anei.cadpage.parsers.WI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Calumet County, WI
Contact: Tom Macco <tmacco1@gmail.com>
Sender: zoll@goldcross.org
(Gold Cross Alert - part 1 of 1) RC:W824 RUSCH RD//BRILLION/Non Emergency/Hemorhage / Laceration//<None>/Run# 9652/18:21/911 Call (County)//
(Gold Cross Alert - part 1 of 1) RC:723 S MAIN ST//BRILLION/Emergency/Heart Problems//<None>/Run# 9888/06:05/911 Call (County)//
(Gold Cross Alert - part 1 of 1) RC:W2377 USHY 10//BRILLION/Non Emergency/Sick Person//<None>/Run# 10629/20:58/911 Call (County)//
(Gold Cross Alert - part 1 of 1) RC:220 ACHIEVEMENT DR//BRILLION/Non Emergency/Fall Victim//<None>/Run# 10637/04:21/911 Call (County)//
(Gold Cross Alert - part 1 of 1) RC:130 CALUMET ST//BRILLION/Non Emergency/Allergies/walk in w/ bee sting/ does not want to be transported by ambulance/<None>/Ru
(Gold Cross Alert - part 1 of 1) RC:306 N MAIN ST//BRILLION/Non Emergency/Sick Person//<None>/Run# 11405/02:22/911 Call (County)//
(Gold Cross Alert - part 1 of 1) RC:210 S PARKWAY DR//BRILLION/Non Emergency/Sick Person/NON-EMERGENCY/FEMALE DIFFICULTY BREATHING 81YOA/<None>/Run# 16362/16:28/

** Not Parsing **
(Gold Cross Alert - part 1 of 1) RC:Job# 0028-A (Run# 12637) Alert: Special Instructions: DOES NOT GEOCODE - RESPONSE ZONE IS 34-CITY OF

*/

public class WICalumetCountyBParserTest extends BaseParserTest {
  
  public WICalumetCountyBParserTest() {
    setParser(new WICalumetCountyBParser(), "CALUMET COUNTY", "WI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Gold Cross Alert - part 1 of 1) RC:W824 RUSCH RD//BRILLION/Non Emergency/Hemorhage / Laceration//<None>/Run# 9652/18:21/911 Call (County)//",
        "ADDR:W824 RUSCH RD",
        "MADDR:824 RUSCH RD",
        "CITY:BRILLION",
        "CALL:Non Emergency / Hemorhage / Laceration",
        "ID:9652",
        "TIME:18:21");

    doTest("T2",
        "(Gold Cross Alert - part 1 of 1) RC:723 S MAIN ST//BRILLION/Emergency/Heart Problems//<None>/Run# 9888/06:05/911 Call (County)//",
        "ADDR:723 S MAIN ST",
        "CITY:BRILLION",
        "CALL:Emergency / Heart Problems",
        "ID:9888",
        "TIME:06:05");

    doTest("T3",
        "(Gold Cross Alert - part 1 of 1) RC:W2377 USHY 10//BRILLION/Non Emergency/Sick Person//<None>/Run# 10629/20:58/911 Call (County)//",
        "ADDR:W2377 USHY 10",
        "MADDR:2377 US 10",
        "CITY:BRILLION",
        "CALL:Non Emergency / Sick Person",
        "ID:10629",
        "TIME:20:58");

    doTest("T4",
        "(Gold Cross Alert - part 1 of 1) RC:220 ACHIEVEMENT DR//BRILLION/Non Emergency/Fall Victim//<None>/Run# 10637/04:21/911 Call (County)//",
        "ADDR:220 ACHIEVEMENT DR",
        "CITY:BRILLION",
        "CALL:Non Emergency / Fall Victim",
        "ID:10637",
        "TIME:04:21");

    doTest("T5",
        "(Gold Cross Alert - part 1 of 1) RC:130 CALUMET ST//BRILLION/Non Emergency/Allergies/walk in w/ bee sting/ does not want to be transported by ambulance/<None>/Ru",
        "ADDR:130 CALUMET ST",
        "CITY:BRILLION",
        "CALL:Non Emergency / Allergies / walk in w / bee sting / does not want to be transported by ambulance");

    doTest("T6",
        "(Gold Cross Alert - part 1 of 1) RC:306 N MAIN ST//BRILLION/Non Emergency/Sick Person//<None>/Run# 11405/02:22/911 Call (County)//",
        "ADDR:306 N MAIN ST",
        "CITY:BRILLION",
        "CALL:Non Emergency / Sick Person",
        "ID:11405",
        "TIME:02:22");

    doTest("T7",
        "(Gold Cross Alert - part 1 of 1) RC:210 S PARKWAY DR//BRILLION/Non Emergency/Sick Person/NON-EMERGENCY/FEMALE DIFFICULTY BREATHING 81YOA/<None>/Run# 16362/16:28/",
        "ADDR:210 S PARKWAY DR",
        "CITY:BRILLION",
        "CALL:Non Emergency / Sick Person / NON-EMERGENCY / FEMALE DIFFICULTY BREATHING 81YOA",
        "ID:16362",
        "TIME:16:28");

  }
  
  public static void main(String[] args) {
    new WICalumetCountyBParserTest().generateTests("T1");
  }
}