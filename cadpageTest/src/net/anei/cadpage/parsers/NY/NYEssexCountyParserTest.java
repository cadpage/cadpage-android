package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Essex County, NY
Contact: Keron Charles <keron.charles001@gmail.com>

(Jay) JVFD:2013:12\nDISPATCHED\nEMS\n1, mile SW int. of AuSable Dr. & SR 86 - NW ;Jay N
[Jay]  JVFD:2013:10\nDISPATCHED\nAlarm-Fire
[Jay]  JVFD:2013:9\nDISPATCHED\nFire-Fire
(Jay) JVFD:2013:13\nDISPATCHED\nFire\nAUSABLE
(Jay) JVFD:2013:15\nDISPATCHED\nFire\n70 BEECH ST

*/

public class NYEssexCountyParserTest extends BaseParserTest {
  
  public NYEssexCountyParserTest() {
    setParser(new NYEssexCountyParser(), "ESSEX COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Jay) JVFD:2013:12\nDISPATCHED\nEMS\n1, mile SW int. of AuSable Dr. & SR 86 - NW ;Jay N",
        "SRC:JVFD",
        "ID:2013:12",
        "CALL:EMS",
        "ADDR:1",
        "CITY:mile SW int. of AuSable Dr. & SR 86 - NW ;Jay N");

    doTest("T2",
        "[Jay]  JVFD:2013:10\nDISPATCHED\nAlarm-Fire",
        "SRC:JVFD",
        "ID:2013:10",
        "CALL:Alarm-Fire");

    doTest("T3",
        "[Jay]  JVFD:2013:9\nDISPATCHED\nFire-Fire",
        "SRC:JVFD",
        "ID:2013:9",
        "CALL:Fire-Fire");

    doTest("T4",
        "(Jay) JVFD:2013:13\nDISPATCHED\nFire\nAUSABLE",
        "SRC:JVFD",
        "ID:2013:13",
        "CALL:Fire",
        "ADDR:AUSABLE");

    doTest("T5",
        "(Jay) JVFD:2013:15\nDISPATCHED\nFire\n70 BEECH ST",
        "SRC:JVFD",
        "ID:2013:15",
        "CALL:Fire",
        "ADDR:70 BEECH ST");

  }
  
  public static void main(String[] args) {
    new NYEssexCountyParserTest().generateTests("T1");
  }
}