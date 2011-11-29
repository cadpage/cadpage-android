package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MDWorcesterCountyBParserTest extends BaseParserTest {
  
  public MDWorcesterCountyBParserTest() {
    setParser(new MDWorcesterCountyBParser(), "WORCESTER COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Chief ALT) [800 Fire] -- Traffic Transportation Acc --  -- Worcester Hwy & peerless Rd Showell MD, 21862",
        "SRC:800 Fire",
        "CALL:Traffic Transportation Acc",
        "ADDR:Worcester Hwy & peerless Rd",
        "CITY:Showell");

    doTest("T2",
        "(Chief ALT) [800 Fire] -- Traffic Transportation Acc -- On Rt 90 West Of Rt 113 -- Ocean Expy & worcester Hwy Berlin MD, 21811",
        "SRC:800 Fire",
        "CALL:Traffic Transportation Acc",
        "PLACE:On Rt 90 West Of Rt 113",
        "ADDR:Ocean Expy & worcester Hwy",
        "CITY:Berlin");

    doTest("T3",
        "(Chief ALT) [800 Fire] -- Structure Fire Extinguished -- White Horse Trailer Park -- 11647-1 Beauchamp Rd Berlin MD, 21811",
        "SRC:800 Fire",
        "CALL:Structure Fire Extinguished",
        "PLACE:White Horse Trailer Park",
        "ADDR:11647-1 Beauchamp Rd",
        "MADDR:11647 Beauchamp Rd",
        "CITY:Berlin");

    doTest("T4",
        "(Chief ALT) [800 Fire] -- Traffic Transportation Acc -- (s)newport (n) -- Ocean Pkwy & newport Dr Berlin MD, 21811",
        "SRC:800 Fire",
        "CALL:Traffic Transportation Acc",
        "PLACE:(s)newport (n)",
        "ADDR:Ocean Pkwy & newport Dr",
        "CITY:Berlin");

    doTest("T5",
        "(Chief ALT) [800 Fire] -- Fire Alarm -- (s)teal Bay (n) -- 8 Waters Edge Ct Berlin MD, 21811",
        "SRC:800 Fire",
        "CALL:Fire Alarm",
        "PLACE:(s)teal Bay (n)",
        "ADDR:8 Waters Edge Ct",
        "CITY:Berlin");
  }
  
  public static void main(String[] args) {
    new MDWorcesterCountyBParserTest().generateTests("T1");
  }
}