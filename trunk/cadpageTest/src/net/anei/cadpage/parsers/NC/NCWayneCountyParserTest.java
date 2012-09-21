package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCWayneCountyParserTest extends BaseParserTest {
  
  public NCWayneCountyParserTest() {
    setParser(new NCWayneCountyParser(), "WAYNE COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Structure Fire  117,S RUNNING DEER CIR ;DUDLEY  DUDLEY [76]",
        "CALL:Structure Fire",
        "ADDR:117 S RUNNING DEER CIR",
        "SRC:DUDLEY",
        "CITY:DUDLEY",
        "ID:76");

    doTest("T2",
        "Traffic Accident-Inj    1574,    DURHAM LAKE RD ; DUDLEY  DUDLEY    [68]",
        "CALL:Traffic Accident-Inj",
        "ADDR:1574 DURHAM LAKE RD",
        "SRC:DUDLEY",
        "CITY:DUDLEY   ",
        "ID:68");

    doTest("T3",
        "Gas Leak        105,    ROLLINGWOOD CT ;  DUDLEY    DUDLEY    [71]",
        "CALL:Gas Leak",
        "ADDR:105 ROLLINGWOOD CT",
        "SRC:DUDLEY",
        "CITY:DUDLEY   ",
        "ID:71");

    doTest("T4",
        "TRaffic Accident-Inj    3944,     US 117 ALT ;      DUDLEY    DUDLEY    [67]",
        "CALL:TRaffic Accident-Inj",
        "ADDR:3944 US 117 ALT",
        "SRC:DUDLEY",
        "CITY:DUDLEY   ",
        "ID:67");

    doTest("T5",
        "Gas Leak        1104,   S CHURCH ST     MOUNT OLIVE  MOUNT OLIVE  [70]",
        "CALL:Gas Leak",
        "ADDR:1104 S CHURCH ST",
        "SRC:MOUNT OLIVE",
        "CITY:MOUNT OLIVE ",
        "ID:70");

    doTest("T6",
        "Traffic Accident-Inj      1493,   EMMAUS CHURCH RD ;  DUDLEY    DUDLEY    [69]",
        "CALL:Traffic Accident-Inj",
        "ADDR:1493 EMMAUS CHURCH RD",
        "SRC:DUDLEY",
        "CITY:DUDLEY   ",
        "ID:69");

    doTest("T7",
        "Traffic Accident-Inj    1574,     DURHAM LAKE RD ;  DUDLEY  DUDLEY    [68]",
        "CALL:Traffic Accident-Inj",
        "ADDR:1574 DURHAM LAKE RD",
        "SRC:DUDLEY",
        "CITY:DUDLEY   ",
        "ID:68");

  }

  public static void main(String[] args) {
    new NCWayneCountyParserTest().generateTests("T1", "CALL ADDR SRC CITY ID");
  }
}
