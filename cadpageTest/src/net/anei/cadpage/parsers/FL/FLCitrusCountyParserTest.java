package net.anei.cadpage.parsers.FL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Citrus County, FL (replace)
Contact: "Martin Giles" <mgiles@crystalriverfl.org>
Sender: 777

CITRUS COUNTY FIRE DEPARTMENT Unit:E001A Status:Dispatched 41F - ALARM FIRE 11F 9450 W MARK CT N CITRUS AVE / N GARY PT Crystal River  fire alarm  This is a commercial alarm  Business name is: d TXT STOP to opt-out\r
CITRUS COUNTY FIRE DEPARTMENT Unit:T001 Status:Dispatched 25S - STRUCTURE FIRE 32D 3549 SAUNDERS WAY W SOVEREIGN PATH / S LECANTO HWY Lecanto EOC TXT STOP to opt-out
CITRUS COUNTY FIRE DEPARTMENT Unit:T001 Status:Dispatched 25S - STRUCTURE FIRE 28B 14351 W EBBTIDE CT DEAD END / S OZELLO TRL Crystal River  Structure type: RESD  Structure is occupied  TRAILER is on TXT STOP to opt-out

 */

public class FLCitrusCountyParserTest extends BaseParserTest {
  
  public FLCitrusCountyParserTest() {
    setParser(new FLCitrusCountyParser(), "CITRUS COUNTY", "FL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CITRUS COUNTY FIRE DEPARTMENT Unit:E001A Status:Dispatched 41F - ALARM FIRE 11F 9450 W MARK CT N CITRUS AVE / N GARY PT Crystal River  fire alarm  This is a commercial alarm  Business name is: d TXT STOP to opt-out\r",
        "UNIT:E001A",
        "CODE:41F",
        "CALL:ALARM FIRE",
        "MAP:11F",
        "ADDR:9450 W MARK CT N",
        "X:CITRUS AVE / N GARY PT",
        "CITY:Crystal River",
        "INFO:fire alarm  This is a commercial alarm  Business name is: d");

    doTest("T2",
        "CITRUS COUNTY FIRE DEPARTMENT Unit:T001 Status:Dispatched 25S - STRUCTURE FIRE 32D 3549 SAUNDERS WAY W SOVEREIGN PATH / S LECANTO HWY Lecanto EOC TXT STOP to opt-out",
        "UNIT:T001",
        "CODE:25S",
        "CALL:STRUCTURE FIRE",
        "MAP:32D",
        "ADDR:3549 SAUNDERS WAY W",
        "X:SOVEREIGN PATH / S LECANTO HWY",
        "CITY:Lecanto",
        "INFO:EOC");

    doTest("T3",
        "CITRUS COUNTY FIRE DEPARTMENT Unit:T001 Status:Dispatched 25S - STRUCTURE FIRE 28B 14351 W EBBTIDE CT DEAD END / S OZELLO TRL Crystal River  Structure type: RESD  Structure is occupied  TRAILER is on TXT STOP to opt-out",
        "UNIT:T001",
        "CODE:25S",
        "CALL:STRUCTURE FIRE",
        "MAP:28B",
        "ADDR:14351 W EBBTIDE CT",
        "X:DEAD END / S OZELLO TRL",
        "CITY:Crystal River",
        "INFO:Structure type: RESD  Structure is occupied  TRAILER is on");

  }
  
  public static void main(String[] args) {
    new FLCitrusCountyParserTest().generateTests("T1");
  }
}
  