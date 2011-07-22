package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PANorthamptonCountyParser;

import org.junit.Test;


public class PANorthamptonCountyParserTest extends BaseParserTest {
  
  public PANorthamptonCountyParserTest() {
    setParser(new PANorthamptonCountyParser(), "NORTHAMPTON COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[e49]ALS >ADVANCED LIFE SUPPORT CALL 602 E 21ST ST Apt: 119 Bldg NORTHAMPTON DIANE ECK Map: Grids:0,0 Cad: 2011-0000086714",
        "UNIT:e49",
        "CALL:ADVANCED LIFE SUPPORT",
        "ADDR:602 E 21ST ST",
        "APT:119 Bldg",
        "CITY:NORTHAMPTON",
        "NAME:DIANE ECK",
        "ID:2011-0000086714");

    doTest("T2",
        "[e49]BLS >BASIC LIFE SUPPORT CALL 1323 NEWPORT AVE Apt: REAR Bldg NORTHAMPTON TONY FERRERA Map: Grids:0,0 Cad: 2011-00000",
        "UNIT:e49",
        "CALL:BASIC LIFE SUPPORT",
        "ADDR:1323 NEWPORT AVE",
        "APT:REAR Bldg",
        "CITY:NORTHAMPTON",
        "NAME:TONY FERRERA",
        "ID:2011-00000");

    doTest("T3",
        "[e49]MVAI >MVA WITH INJURIES 248 AT PENNSVILLE LIGHT LEHIGH TWP NATALIE BRODIANO Cad: 2011-0000086361",
        "UNIT:e49",
        "CALL:MVA WITH INJURIES 248",
        "ADDR:PENNSVILLE LIGHT",
        "CITY:LEHIGH TWP",
        "NAME:NATALIE BRODIANO",
        "ID:2011-0000086361");

    doTest("T4",
        "[e49]ALS >ADVANCED LIFE SUPPORT CALL 612 E 10TH ST NORTHAMPTON ROBERTS PAMELA Map: Grids:0,0 Cad: 2011-0000086262",
        "UNIT:e49",
        "CALL:ADVANCED LIFE SUPPORT",
        "ADDR:612 E 10TH ST",
        "CITY:NORTHAMPTON",
        "NAME:ROBERTS PAMELA",
        "ID:2011-0000086262");

    doTest("T5",
        "[e49]BLS >BASIC LIFE SUPPORT CALL 1001 WASHINGTON AVE Apt: 105 Bldg NORTHAMPTON MEGAN MOREY Map: Grids:0,0 Cad: 2011-000008",
        "UNIT:e49",
        "CALL:BASIC LIFE SUPPORT",
        "ADDR:1001 WASHINGTON AVE",
        "APT:105 Bldg",
        "CITY:NORTHAMPTON",
        "NAME:MEGAN MOREY",
        "ID:2011-000008");

    doTest("T6",
        "[e49]ALS >ADVANCED LIFE SUPPORT CALL 5962 KEYSTONE DR EAST ALLEN CHRISTINA WIGMER Map: Grids:0,0 Cad: 2011-0000086103",
        "UNIT:e49",
        "CALL:ADVANCED LIFE SUPPORT",
        "ADDR:5962 KEYSTONE DR",
        "CITY:EAST ALLEN",
        "NAME:CHRISTINA WIGMER",
        "ID:2011-0000086103");

    doTest("T7",
        "[e49]BLS >BASIC LIFE SUPPORT CALL 1323 NEWPORT AVE NORTHAMPTON TONY CABRERA Map: Grids:0,0 Cad: 2011-0000086010",
        "UNIT:e49",
        "CALL:BASIC LIFE SUPPORT",
        "ADDR:1323 NEWPORT AVE",
        "CITY:NORTHAMPTON",
        "NAME:TONY CABRERA",
        "ID:2011-0000086010");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "Subject:#6550\n[f14]MVAU >MVA WITH UNKNOW INJUIRIES WILLOW PARK RD BETHLEHEM TWP P1736 Map: Grids:0,0 Cad: 2011-0000131105",
        "UNIT:f14",
        "CALL:MVA WITH UNKNOW INJUIRIES",
        "ADDR:WILLOW PARK RD",
        "CITY:BETHLEHEM TWP",
        "NAME:P1736",
        "ID:2011-0000131105");
   
  }
  
  public static void main(String[] args) {
    new PANorthamptonCountyParserTest().generateTests("T1", "UNIT CALL ADDR APT CITY NAME MAP ID");
  }
}

