package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXHarrisCountyESD1BParserTest extends BaseParserTest {
  
  public TXHarrisCountyESD1BParserTest() {
    setParser(new TXHarrisCountyESD1BParser(), "HARRIS COUNTY", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "ID#:11-06-20658 - - 29A1 MOTOR VEHICLE A - East Fwy / Delldale - Apt: - Bldg: - Key Map: 498E - Cross Streets: - Box #:2004",
        "ID:11-06-20658",
        "CALL:29A1 MOTOR VEHICLE A",
        "ADDR:East Fwy & Delldale",
        "MAP:498E",
        "BOX:2004");

    doTest("T2",
        "ID#:11-06-20685 - - TRASH FIRE - 111 Bayou Dr - Apt:C - Bldg: - Key Map: 498D - Cross Streets:EAST FWY/MARKET - Box #:2002",
        "ID:11-06-20685",
        "CALL:TRASH FIRE",
        "ADDR:111 Bayou Dr",
        "APT:C",
        "MAP:498D",
        "X:EAST FWY/MARKET",
        "BOX:2002");

    doTest("T3",
        "ID#:11-06-20710 - - FIRE - PreAlert - 16217 Ridlon - Apt: - Bldg: intra SERVICES - Key Map: 498C - Cross Streets:SHEILA LN/WOODLAND D",
        "ID:11-06-20710",
        "CALL:FIRE - PreAlert",
        "ADDR:16217 Ridlon",
        "APT:intra SERVICES",
        "MAP:498C",
        "X:SHEILA LN/WOODLAND D");
   
  }

public static void main(String[] args) {
    new TXHarrisCountyESD1BParserTest().generateTests("T1");
  }

}