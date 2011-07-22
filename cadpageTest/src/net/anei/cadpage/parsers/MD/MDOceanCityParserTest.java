package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MDOceanCityParserTest extends BaseParserTest {
  
  public MDOceanCityParserTest() {
    setParser(new MDOceanCityParser(), "OCEAN CITY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Chief ALT) [700 Auto] - Nature:Auto Alarm - LOC:2500 Baltimore Ave - Crystal Beach Hotel - ADD:(s) (n)boardwalk OCMD - Cross STS:26th St & 25th St",
        "SRC:700 Auto",
        "CALL:Auto Alarm",
        "ADDR:2500 Baltimore Ave",
        "PLACE:Crystal Beach Hotel",
        "X:26th St & 25th St");

    doTest("T2",
        "(Chief ALT) [STA:700] - Nature:Vehicle Fire - ADD:8878 Stephen Decatur Hwy OCMD - Cross STS:Clark Rd & Landings Blvd",
        "SRC:STA:700",
        "CALL:Vehicle Fire",
        "ADDR:8878 Stephen Decatur Hwy",
        "X:Clark Rd & Landings Blvd");

    doTest("T3",
        "[Chief ALT]  [STA:700] - Nature:Mutual Aid Fire - ADD:1 W Indian St OCMD - Cross STS:Bay St & E Indian St",
        "SRC:STA:700",
        "CALL:Mutual Aid Fire",
        "ADDR:1 W Indian St",
        "X:Bay St & E Indian St");

    doTest("T4",
        "(Chief ALT) [700 Service] - Nature:Public Service - ADD:24 White Crane Dr OCMD - Cross STS:Misty Shore Dr & Mystic Harbour Blvd",
        "SRC:700 Service",
        "CALL:Public Service",
        "ADDR:24 White Crane Dr",
        "X:Misty Shore Dr & Mystic Harbour Blvd");

    doTest("T5",
        "(Chief ALT) [700 Auto] - Nature:Auto Alarm - ADD:4 Hidden Cove Way OCMD - Cross STS:Fountain Dr W & Sunset Island Dr",
        "SRC:700 Auto",
        "CALL:Auto Alarm",
        "ADDR:4 Hidden Cove Way",
        "X:Fountain Dr W & Sunset Island Dr");

    doTest("T6",
        "[Chief ALT]  [STA:700] - Nature:Gas Leak - LOC:Coins - ADD:2820 Philadelphia Ave OCMD - Cross STS:29th St & 28th St",
        "SRC:STA:700",
        "CALL:Gas Leak",
        "ADDR:2820 Philadelphia Ave",
        "PLACE:Coins",
        "X:29th St & 28th St");

    doTest("T7",
        "[Chief ALT]  [700 Auto] - Nature:Auto Alarm - LOC:Sakura Japanese Steak House - ADD:12741 Ocean Gtwy OCMD - Cross STS:Golf Course Rd & Keyser Point Rd",
        "SRC:700 Auto",
        "CALL:Auto Alarm",
        "ADDR:12741 Ocean Gtwy",
        "PLACE:Sakura Japanese Steak House",
        "X:Golf Course Rd & Keyser Point Rd");

    doTest("T8",
        "(Chief ALT) [700 Auto] - Nature:Auto Alarm - LOC:1208 Baltimore Ave - Beach Break - ADD:(s) (n)boardwalk OCMD - Cross STS:Woods Ln & 12th St",
        "SRC:700 Auto",
        "CALL:Auto Alarm",
        "ADDR:1208 Baltimore Ave",
        "PLACE:Beach Break",
        "X:Woods Ln & 12th St");

    doTest("T9",
        "(Chief ALT) [STA:700] - Nature:Building Fire - LOC:408 Baltimore Ave - Tidelands Caribbean Annex Bldg - ADD:(s) (n)boardwalk OCMD - Cross STS:5th St & 4th St",
        "SRC:STA:700",
        "CALL:Building Fire",
        "ADDR:408 Baltimore Ave",
        "PLACE:Tidelands Caribbean Annex Bldg",
        "X:5th St & 4th St");

    doTest("T10",
        "(Chief ALT) [700 Auto] - Nature:Auto Alarm - LOC:2700 Baltimore Ave - Dunes Motel - ADD:(s) (n)boardwalk OCMD - Cross STS:28th St & 27th St",
        "SRC:700 Auto",
        "CALL:Auto Alarm",
        "ADDR:2700 Baltimore Ave",
        "PLACE:Dunes Motel",
        "X:28th St & 27th St");

    doTest("T11",
        "[Chief ALT]  [700 Auto] - Nature:Auto Alarm - LOC:1701 Atlantic Ave - Holiday Inn Hotel & Suites - ADD:(s) (n)boardwalk OCMD - Cross STS:18th St & 17th St",
        "SRC:700 Auto",
        "CALL:Auto Alarm",
        "ADDR:1701 Atlantic Ave",
        "PLACE:Holiday Inn Hotel & Suites",
        "X:18th St & 17th St");
  }
  
  public static void main(String[] args) {
    new MDOceanCityParserTest().generateTests("T1");
  }
}