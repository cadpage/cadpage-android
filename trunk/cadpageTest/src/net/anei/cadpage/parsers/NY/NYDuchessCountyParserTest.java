package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYDuchessCountyParserTest extends BaseParserTest {
  
  public NYDuchessCountyParserTest() {
    setParser(new NYDuchessCountyParser(), "DUCHESS COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "PV-1: Type:EMS P2 |Address: 923 SALT POINT TRNPK, PLEASANT VALLEY, New York |Nature: 17 YOM FEELING DIZZY |Cross:BLOSSOM HILL - WEST ",
        "SRC:PV-1",
        "CALL:EMS P2 / 17 YOM FEELING DIZZY",
        "ADDR:923 SALT POINT TRNPK",
        "CITY:PLEASANT VALLEY",
        "X:BLOSSOM HILL / WEST");

    doTest("T2",
        "PV-1: Type:EMS P4 |Address: 1434 ROUTE 44 , PLEASANT VALLEY, New York  |Nature: 57YOM FELL ,SHOULDER PAIN FATHER FELL |Cross:WILBUR RD",
        "SRC:PV-1",
        "CALL:EMS P4 / 57YOM FELL ,SHOULDER PAIN FATHER FELL",
        "ADDR:1434 ROUTE 44",
        "CITY:PLEASANT VALLEY",
        "X:WILBUR RD");

    doTest("T3",
        "PV-1: Type:Alarm Fire |Address: 1903 ROUTE 44 , PLEASANT VALLEY, New York |Nature: AFA -2ND FLOOR PULL-WEST SIDE |Cross:BREWSTER LN -",
        "SRC:PV-1",
        "CALL:Alarm Fire / AFA -2ND FLOOR PULL-WEST SIDE",
        "ADDR:1903 ROUTE 44",
        "CITY:PLEASANT VALLEY",
        "X:BREWSTER LN");

    doTest("T4",
        "PV-1: Type:EMS P3 |Address: 11 WALNUT DR , PLEASANT VALLEY, New York  |Nature: 59 YOM ABDOMINAL-POST SURGICAL COMPLICATIONS |Cross:WAT ",
        "SRC:PV-1",
        "CALL:EMS P3 / 59 YOM ABDOMINAL-POST SURGICAL COMPLICATIONS",
        "ADDR:11 WALNUT DR",
        "CITY:PLEASANT VALLEY",
        "X:WAT");

    doTest("T5",
        "PV-1: Type:EMS P1 |Address: 7 BRISTOL DR , PLEASANT VALLEY, New York |Nature: 70 YOF CHEST AND BACK PAIN |Cross:FREEDOM RD - FOREST V",
        "SRC:PV-1",
        "CALL:EMS P1 / 70 YOF CHEST AND BACK PAIN",
        "ADDR:7 BRISTOL DR",
        "CITY:PLEASANT VALLEY",
        "X:FREEDOM RD / FOREST V");

  }
  
  public static void main(String[] args) {
    new NYDuchessCountyParserTest().generateTests("T1");
  }
}