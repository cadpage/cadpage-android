package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCRowanCountyParserTest extends BaseParserTest {
  
  public NCRowanCountyParserTest() {
    setParser(new NCRowanCountyParser(), "ROWAN COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:10C4 CHEST PAIN;201 N FRANKLIN ST;SWINK ST;PARK ST;CHGV;4301;RFG1",
        "CALL:10C4 CHEST PAIN",
        "ADDR:201 N FRANKLIN ST",
        "X:SWINK ST & PARK ST",
        "CITY:CHINA GROVE",
        "INFO:4301 / RFG1");

    doTest("T2",
        "CAD:FIRE DEPT SERVICE ASSIGNMENT;213 WASHINGTON ST;KLONDALE ST;CHGV;4301",
        "CALL:FIRE DEPT SERVICE ASSIGNMENT",
        "ADDR:213 WASHINGTON ST",
        "X:KLONDALE ST",
        "CITY:CHINA GROVE",
        "INFO:4301");

    doTest("T3",
        "CAD:13D1 DIABETIC PROBLEM;1075 DEAL RD;KARRIKER FARMS RD;FIELD TRACE RD;MOOR;CARE INN RETIREMENT CENTER;4002;RFG4",
        "CALL:13D1 DIABETIC PROBLEM",
        "ADDR:1075 DEAL RD",
        "X:KARRIKER FARMS RD & FIELD TRACE RD",
        "CITY:MOORESVILLE",
        "PLACE:CARE INN RETIREMENT CENTER",
        "INFO:4002 / RFG4");

    doTest("T4",
        "CAD:RFD COMMAND ESTABLISHED;2470 E NC 152 HWY; CHGV",
        "CALL:RFD COMMAND ESTABLISHED",
        "ADDR:2470 E NC 152 HWY",
        "CITY:CHINA GROVE");

    doTest("T5",
        "CAD:29B1 TRAFFIC ACCIDENT WITH INJ;E NC 152 HWY/S I 85;CHGV;4123;RFG2",
        "CALL:29B1 TRAFFIC ACCIDENT WITH INJ",
        "ADDR:E NC 152 HWY & S I 85",
        "CITY:CHINA GROVE",
        "INFO:4123 / RFG2");

    doTest("T6",
        "CAD:RFD COMMAND ESTABLISHED;E NC 152 HWY/S I 85; CHGV",
        "CALL:RFD COMMAND ESTABLISHED",
        "ADDR:E NC 152 HWY & S I 85",
        "CITY:CHINA GROVE");

    doTest("T7",
        "CAD:STRUCTURE FIRE;625 SIDES RD;GOLD KNOB RD;GOLD KNOB RD;SALS;7106;RFG1",
        "CALL:STRUCTURE FIRE",
        "ADDR:625 SIDES RD",
        "X:GOLD KNOB RD & GOLD KNOB RD",
        "CITY:SALISBURY",
        "INFO:7106 / RFG1");

    doTest("T8",
        "CAD:13D1 DIABETIC PROBLEM;3035 STOKES FERRY RD;EDZELL DR;EARNHARDT RD;SALS;7604;RFG4",
        "CALL:13D1 DIABETIC PROBLEM",
        "ADDR:3035 STOKES FERRY RD",
        "X:EDZELL DR & EARNHARDT RD",
        "CITY:SALISBURY",
        "INFO:7604 / RFG4");

    doTest("T9",
        "CAD:10D1 CHEST PAIN;6235 FISH POND RD;SWANNER PARK DR;ODDIE RD;SALS;7605;RFG1",
        "CALL:10D1 CHEST PAIN",
        "ADDR:6235 FISH POND RD",
        "X:SWANNER PARK DR & ODDIE RD",
        "CITY:SALISBURY",
        "INFO:7605 / RFG1");

    doTest("T10",
        "CAD:6C1 BREATHING PROBLEMS;140 PARTRIDGE TR;PALOMINO DR;DEER RD;SALS;7603;RFG1",
        "CALL:6C1 BREATHING PROBLEMS",
        "ADDR:140 PARTRIDGE TR",
        "X:PALOMINO DR & DEER RD",
        "CITY:SALISBURY",
        "INFO:7603 / RFG1");

    doTest("T11",
        "CAD:FIRE ALARM;1190 LONG FERRY RD;N LONG FERRY OFF;WILLOW CREEK DR;SALS;RUSHCO (LIBERTY) STATION #18;6401;RFG1",
        "CALL:FIRE ALARM",
        "ADDR:1190 LONG FERRY RD",
        "X:N LONG FERRY OFF & WILLOW CREEK DR",
        "CITY:SALISBURY",
        "PLACE:RUSHCO (LIBERTY) STATION #18",
        "INFO:6401 / RFG1");
  }
  

  public static void main(String[] args) {
    new NCRowanCountyParserTest().generateTests("T9");
  }
}
