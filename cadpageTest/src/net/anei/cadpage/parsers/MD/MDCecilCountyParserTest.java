package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MDCecilCountyParserTest extends BaseParserTest {
  
  public MDCecilCountyParserTest() {
    setParser(new MDCecilCountyParser(), "CECIL COUNTY", "MD");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "0833*HEART RELATED*37 LILLIAN CIR*BARNES CORNER RD*HOPEWELL RD*RS*11:04:07*10023098",
        "BOX:0833",
        "CALL:HEART RELATED",
        "ADDR:37 LILLIAN CIR",
        "X:BARNES CORNER RD & HOPEWELL RD",
        "CITY:RISING SUN",
        "ID:10023098");
    
    doTest("T2",
        "0841*SICK PERSON*480 HARRISVILLE RD*THRUWAY DR*WYATT LN*COLO*13:46:15*10023234",
        "BOX:0841",
        "CALL:SICK PERSON",
        "ADDR:480 HARRISVILLE RD",
        "X:THRUWAY DR & WYATT LN",
        "CITY:COLORA",
        "ID:10023234");

    doTest("T3",
        "1401*FUEL SPILL*SINGERLY RD / BIG ELK CHAPEL R*ELK*02:18:39*10023699",
        "BOX:1401",
        "CALL:FUEL SPILL",
        "ADDR:SINGERLY RD & BIG ELK CHAPEL R",
        "CITY:ELKTON",
        "ID:10023699");

    doTest("T4",
        "0800*HEADACHE*201 STONE RUN DR*RS*17:09:11*10023738",
        "BOX:0800",
        "CALL:HEADACHE",
        "ADDR:201 STONE RUN DR",
        "CITY:RISING SUN",
        "ID:10023738");

    doTest("T5",
        "0800*MOTOR VEHICLE ACC*UNCLE WILLYS RESTAUR @325 W MA*RS*21:15:42*10023751",
        "BOX:0800",
        "CALL:MOTOR VEHICLE ACC",
        "PLACE:UNCLE WILLYS RESTAUR",
        "ADDR:325 W MA",
        "CITY:RISING SUN",
        "ID:10023751");

    setDefaults("", "");
    doTest("T20",
        "OOC*AMBO CALL*WARE VILLAGE 7 E LOCUST*01:13:01*10023819",
        "CALL:AMBO CALL",
        "ADDR:WARE VILLAGE 7 E LOCUST",
        "ID:10023819");
    
    doTest("T21",
        "OOC*HOUSE FIRE*207 SHEFFEILD LN*12:03:09*11001029",
        "CALL:HOUSE FIRE",
        "ADDR:207 SHEFFEILD LN",
        "ID:11001029");
    
  }
}