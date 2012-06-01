package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.AL.ALBaldwinCountyParserTest;

import org.junit.Test;


public class ALBaldwinCountyParserTest extends BaseParserTest {
  
  public ALBaldwinCountyParserTest() {
    setParser(new ALBaldwinCountyParser(), "BALDWIN COUNTY", "AL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "- E911 Notification - Elberta VFD - 05-20-12 13:43: Station STA31 dispatched to Incident ID 290161 (Stroke) at 25855 WILLOW RIDGE R",
        "SRC:Elberta VFD",
        "DATE:05/20/2012",
        "TIME:13:43",
        "UNIT:STA31",
        "ID:290161",
        "CALL:Stroke",
        "ADDR:25855 WILLOW RIDGE R");

    doTest("T2",
        "- E911 Notification - Elberta VFD - 05-21-12 15:35: Station STA31 dispatched to Incident ID 290600 (Fire - Grass) at 17305 JOE GOTTLER RD",
        "SRC:Elberta VFD",
        "DATE:05/21/2012",
        "TIME:15:35",
        "UNIT:STA31",
        "ID:290600",
        "CALL:Fire - Grass",
        "ADDR:17305 JOE GOTTLER RD");

    doTest("T3",
        "- E911 Notification - Elberta VFD - 05-24-12 08:48: Station STA31 dispatched to Incident ID 291543 (Auto Accident) at 14850 87\n",
        "SRC:Elberta VFD",
        "DATE:05/24/2012",
        "TIME:08:48",
        "UNIT:STA31",
        "ID:291543",
        "CALL:Auto Accident",
        "ADDR:14850 RT 87");

    doTest("T4",
        "- E911 Notification - Elberta VFD - 05-26-12 08:04: Station STA31 dispatched to Incident ID 292420 (Auto Accident) at US HWY 98 @ SANDY LN",
        "SRC:Elberta VFD",
        "DATE:05/26/2012",
        "TIME:08:04",
        "UNIT:STA31",
        "ID:292420",
        "CALL:Auto Accident",
        "ADDR:US HWY 98 & SANDY LN",
        "MADDR:US 98 & SANDY LN");

    doTest("T5",
        "- E911 Notification - Elberta VFD - 05-26-12 16:24: Station STA31 dispatched to Incident ID 292625 (Auto Accident) at HWY98 @ CORD9",
        "SRC:Elberta VFD",
        "DATE:05/26/2012",
        "TIME:16:24",
        "UNIT:STA31",
        "ID:292625",
        "CALL:Auto Accident",
        "ADDR:HWY98 & CORD9",
        "MADDR:HWY 98 & COUNTY ROAD 9");

  }
  
  public static void main(String[] args) {
    new ALBaldwinCountyParserTest().generateTests("T1", "SRC DATE TIME UNIT ID CALL ADDR");
  }
}