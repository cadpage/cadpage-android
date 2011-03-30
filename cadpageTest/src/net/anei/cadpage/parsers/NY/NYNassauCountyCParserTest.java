package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYNassauCountyCParserTest extends BaseParserTest {
  
  public NYNassauCountyCParserTest() {
    setParser(new NYNassauCountyCParser(), "NASSAU COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "SIG 14- SIGNAL 8 - FOR AFA  WESTBURY MIDDLE SCHOOL 455 ROCKLAND ST CS: LINDEN PLACE / SCHOOL ST TOA: 13:36 03/27",
        "CALL:SIG 14- SIGNAL 8 - FOR AFA",
        "PLACE:WESTBURY MIDDLE SCHOOL",
        "ADDR:455 ROCKLAND ST",
        "X:LINDEN PLACE / SCHOOL ST");

    doTest("T2",
        "SIG 16- AFA  THE SOURCE MALL 1504 OLD COUNTRY ROAD CS: MERCHANTS CONCOURSE / ZECKENDORF BOULEVARD TOA: 06:03 03/27/11",
        "CALL:SIG 16- AFA",
        "PLACE:THE SOURCE MALL",
        "ADDR:1504 OLD COUNTRY ROAD",
        "X:MERCHANTS CONCOURSE / ZECKENDORF BOULEVARD");

    doTest("T3",
        "SIG 4- SIGNAL 9   CABRERA, TULIO 362 WINTHROP STREET CS: POST AVENUE  / LINDEN AVENUE TOA: 11:33 03/26/11",
        "CALL:SIG 4- SIGNAL 9",
        "PLACE:CABRERA, TULIO",
        "ADDR:362 WINTHROP STREET",
        "X:POST AVENUE  / LINDEN AVENUE");

    doTest("T4",
        "SIG 3- AUTO ACCIDENT W/AIDED  BOND STREET & OLD COUNTRY ROAD  BOND STREET CS: OLD COUNTRY ROAD TOA: 11:49 03/25/11",
        "CALL:SIG 3- AUTO ACCIDENT W/AIDED",
        "ADDR:BOND STREET & OLD COUNTRY ROAD",
        "PLACE:BOND STREET",
        "X:OLD COUNTRY ROAD");

    doTest("T5",
        "SIG 1- STRUCTURE FIRE   RITE AID 210 POST AVENUE CS: MAPLE AVENUE  / MADISON AVENUE TOA: 10:30 03/24/11",
        "CALL:SIG 1- STRUCTURE FIRE",
        "PLACE:RITE AID",
        "ADDR:210 POST AVENUE",
        "X:MAPLE AVENUE  / MADISON AVENUE");

    doTest("T6",
        "SIG 3- AUTO ACCIDENT/ HURST TOOL   BENIHANA RESAURANT 920 MERCHANTS CONCOURSE CS: TAYLOR AVENUE  / PRIVADO ROAD TOA: 12:56 03/24/11",
        "CALL:SIG 3- AUTO ACCIDENT/ HURST TOOL",
        "PLACE:BENIHANA RESAURANT",
        "ADDR:920 MERCHANTS CONCOURSE",
        "X:TAYLOR AVENUE  / PRIVADO ROAD");

    doTest("T7",
        "SIG 14- SIGNAL 8 - FOR AFA  WESTBURY MIDDLE SCHOOL 455 ROCKLAND STREET CS: LINDEN PLACE  / SCHOOL STREET TOA: 13:36 03/27/11",
        "CALL:SIG 14- SIGNAL 8 - FOR AFA",
        "PLACE:WESTBURY MIDDLE SCHOOL",
        "ADDR:455 ROCKLAND STREET",
        "X:LINDEN PLACE  / SCHOOL STREET");
  }
  
  public static void main(String[] args) {
    new NYNassauCountyCParserTest().generateTests("T1");
  }
}