package net.anei.cadpage.parsers.WI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class WIEauClaireParserTest extends BaseParserTest {
  
  public WIEauClaireParserTest() {
    setParser(new WIEauClaireParser(), "EAU CLAIRE", "WI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[Case# 11-253]  @5:23:16 AM // Brunswick // W2250 Rim Rock Rd // Vehicle Fire // vehicle fire, no exposures",
        "ID:11-253",
        "CITY:Brunswick",
        "ADDR:W2250 Rim Rock Rd",
        "CALL:Vehicle Fire",
        "INFO:vehicle fire, no exposures");

    doTest("T2",
        "[Case# 11-252]  @7:21:18 PM // Washington // 4940 Meadowbrook Ln // Sounding Fire Alarm // sounding fire alarm, showing 1st & 2nd floor smoke detector",
        "ID:11-252",
        "CITY:Washington",
        "ADDR:4940 Meadowbrook Ln",
        "CALL:Sounding Fire Alarm",
        "INFO:sounding fire alarm, showing 1st & 2nd floor smoke detector");

    doTest("T3",
        "[Case# 11-251]  @4:03:35 PM // Washington // 4400 blk South Lowes creek  rd // Fire //",
        "ID:11-251",
        "CITY:Washington",
        "ADDR:4400 blk South Lowes creek  rd",
        "CALL:Fire");

    doTest("T4",
        "[Case# 11-250]  @12:48:10 PM // Union // HWY 12 & N. Crossing // Motorvehicle Collision // 10/50 PI",
        "ID:11-250",
        "CITY:Union",
        "ADDR:HWY 12 & N Crossing",
        "CALL:Motorvehicle Collision",
        "INFO:10/50 PI");

    doTest("T5",
        "[Case# 11-249]  @1:04:04 PM // Brunswick // W2601 HWY 37 // Electrical/Powerline Emergency // powerline is down and pole is on fire",
        "ID:11-249",
        "CITY:Brunswick",
        "ADDR:W2601 HWY 37",
        "CALL:Electrical/Powerline Emergency",
        "INFO:powerline is down and pole is on fire");

    doTest("T6",
        "[Case# 11-248]  @4:48:14 PM // Union // I-94, 59mm, Westbound // Motorvehicle Collision // 10/50 PI",
        "ID:11-248",
        "CITY:Union",
        "ADDR:I-94, 59mm, Westbound",
        "CALL:Motorvehicle Collision",
        "INFO:10/50 PI");

    doTest("T7",
        "[Case# 11-244]  @1:01:11 PM // Brunswick // Jopke Rd & HWY 37 // Motorvehicle Collision // 10/50 PI",
        "ID:11-244",
        "CITY:Brunswick",
        "ADDR:Jopke Rd & HWY 37",
        "CALL:Motorvehicle Collision",
        "INFO:10/50 PI");

    doTest("T8",
        "[Case# 11-241]  @10:25:42 AM // Washington // I94 WB Mile Marke 65 // Rescue/Medical Assist // 61 y/o male poss stroke",
        "ID:11-241",
        "CITY:Washington",
        "ADDR:I94 WB Mile Marke 65",
        "CALL:Rescue/Medical Assist",
        "INFO:61 y/o male poss stroke");
    
  }
  
  public static void main(String[] args) {
    new WIEauClaireParserTest().generateTests("T1");
  }
}