package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class INHancockCountyParserTest extends BaseParserTest {
  
  public INHancockCountyParserTest() {
    setParser(new INHancockCountyParser(), "HANCOCK COUNTY", "IN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Vehicle Accident - PI/4100 N 600W GREENFIELD & W AIRPORT BLV/52/ E71 M71 FG1 BCFP1/gate 2A",
        "CALL:Vehicle Accident - PI",
        "ADDR:4100 N 600W",
        "CITY:GREENFIELD",
        "X:W AIRPORT BLV",
        "MAP:52",
        "UNIT:E71 M71 FG1 BCFP1",
        "INFO:gate 2A");

    doTest("T2",
        "Structure #ALARM#/7935 W 600N MCCORDSVILLE R12B12089 OAKLANDON/N 700W & N 800W/52/ E71 E72 L71 M71 FG1 BCFP1/General fire alarm",
        "CALL:Structure #ALARM#",
        "ADDR:7935 W 600N",
        "CITY:MCCORDSVILLE",
        "PLACE:R12B12089 OAKLANDON",
        "X:N 700W & N 800W",
        "MAP:52",
        "UNIT:E71 E72 L71 M71 FG1 BCFP1",
        "INFO:General fire alarm");

    doTest("T3",
        "Vehicle Accident - PI/3600 N 600W GREENFIELD/W 350N & W STONER DR/17/ E71 M71 FG3 BCFP1",
        "CALL:Vehicle Accident - PI",
        "ADDR:3600 N 600W",
        "CITY:GREENFIELD",
        "X:W 350N & W STONER DR",
        "MAP:17",
        "UNIT:E71 M71 FG3 BCFP1");

    doTest("T4",
        "Sick / Ill Person/2500 N 700W GREENFIELD/W 200N & W 300N/53/ E71 M71 FG1 BCFP1/LE on traffic stop; requesting check out",
        "CALL:Sick / Ill Person",
        "ADDR:2500 N 700W",
        "CITY:GREENFIELD",
        "X:W 200N & W 300N",
        "MAP:53",
        "UNIT:E71 M71 FG1 BCFP1",
        "INFO:LE on traffic stop; requesting check out");

    doTest("T5",
        "Aircraft Down/5881 W AIRPORT BLV GREENFIELD FUEL DEPOT/N AVIATION WAY & N 600W/18/ T71 BCFP1/Aircraft into a cart; Vietest building",
        "CALL:Aircraft Down",
        "ADDR:5881 W AIRPORT BLV",
        "MADDR:5881 W AIRPORT BLVD",
        "CITY:GREENFIELD",
        "PLACE:FUEL DEPOT",
        "X:N AVIATION WAY & N 600W",
        "MAP:18",
        "UNIT:T71 BCFP1",
        "INFO:Aircraft into a cart; Vietest building");
  }
  
  public static void main(String[] args) {
    new INHancockCountyParserTest().generateTests("T1");
  }
}