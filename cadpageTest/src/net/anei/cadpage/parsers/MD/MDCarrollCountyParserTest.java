package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MDCarrollCountyParserTest extends BaseParserTest {
  
  public MDCarrollCountyParserTest() {
    setParser(new MDCarrollCountyParser(), "CARROLL COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Co12) [!] CT:UC 6513 CARROLL HIGHLANDS RD SYKE BOX:1211 DUE:X127 E123 [66]",
        "SRC:Co12",
        "CALL:UC",
        "ADDR:6513 CARROLL HIGHLANDS RD",
        "CITY:SYKESVILLE",
        "BOX:1211",
        "UNIT:X127 E123");

    doTest("T2",
        "(Co12) [!] CT:BLS SHOPPERS FOOD WHSE @6300 GEORGETOWN BLVD SYKE BOX:1224 DUE:X128 [69]",
        "SRC:Co12",
        "CALL:BLS",
        "PLACE:SHOPPERS FOOD WHSE",
        "ADDR:6300 GEORGETOWN BLVD",
        "CITY:SYKESVILLE",
        "BOX:1224",
        "UNIT:X128");

    doTest("T3",
        "(Co12) [!] CT:BLS 5584 COMPTON LA SYKE BOX:1214 DUE:X129 [70]",
        "SRC:Co12",
        "CALL:BLS",
        "ADDR:5584 COMPTON LA",
        "CITY:SYKESVILLE",
        "BOX:1214",
        "UNIT:X129");

    doTest("T4",
        "[Co12] [!] CT:INVEST KABIK CT / RAILROAD DR E WOOD BOX:1204 DUE:B125 [68]",
        "SRC:Co12",
        "CALL:INVEST",
        "ADDR:KABIK CT & RAILROAD DR E",
        "CITY:WOODBINE",
        "BOX:1204",
        "UNIT:B125");

    doTest("T5",
        "(Co12) [!] CT:ALS 1820 VINCENZA DR @MARVIN GARDENS APT C SYKE BOX:1232 DUE:X128 [71]",
        "SRC:Co12",
        "CALL:ALS",
        "ADDR:1820 VINCENZA DR",
        "PLACE:MARVIN GARDENS",
        "APT:C",
        "CITY:SYKESVILLE",
        "BOX:1232",
        "UNIT:X128");

    doTest("T6",
        "[Co14] [!] CT:SERVICE 3215 HOOPERS DELIGHT RD NWIN BOX:1411 DUE:U14 [18]",
        "SRC:Co14",
        "CALL:SERVICE",
        "ADDR:3215 HOOPERS DELIGHT RD",
        "CITY:NEW WINDSOR",
        "BOX:1411",
        "UNIT:U14");

    doTest("T7",
        "(Co14) [!] CT:BLS 5401 ENTERPRISE ST ; ALLEGRA PRINT SYKE BOX:1416 DUE:X149 [33]",
        "SRC:Co14",
        "CALL:BLS",
        "ADDR:5401 ENTERPRISE ST",
        "PLACE:ALLEGRA PRINT",
        "CITY:SYKESVILLE",
        "BOX:1416",
        "UNIT:X149");

    doTest("T8",
        "(Co2) [!] CT:MA BOX 60-18 19907 YORK RD VCR TG44 BOX:BC DUE:T2 [41]",
        "SRC:Co2",
        "CALL:MA",
        "BOX:60-18",
        "ADDR:19907 YORK RD VCR",
        "CITY:TG44",
        "BOX:BC",
        "UNIT:T2");
  }
  
  public static void main(String[] args) {
    new MDCarrollCountyParserTest().generateTests("T8");
  }
}