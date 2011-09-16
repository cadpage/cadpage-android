package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class INMarshallCountyParserTest extends BaseParserTest {
  
  public INMarshallCountyParserTest() {
    setParser(new INMarshallCountyParser(), "MARSHALL COUNTY", "IN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:FYI: ;702 S WASHINGTON ST;BREM;E RAYMOND ST;ALARM CO DETECTOR;08/23/2011 10:17:48",
        "ADDR:702 S WASHINGTON ST",
        "CITY:BREMEN",
        "X:E RAYMOND ST",
        "CALL:ALARM CO DETECTOR");

    doTest("T2",
        "CAD:FYI: ;200 W FLORENCE ST;BOUR;N THOMPSON ST;FIRE ALARM;08/23/2011 10:34:48",
        "ADDR:200 W FLORENCE ST",
        "CITY:BOURBON",
        "X:N THOMPSON ST",
        "CALL:FIRE ALARM");

    doTest("T3",
        "CAD:FYI: ;601 S BOURBON ST;BOUR;W FRANK ST;FIRE STRUCTURE;08/21/2011 21:30:37",
        "ADDR:601 S BOURBON ST",
        "CITY:BOURBON",
        "X:W FRANK ST",
        "CALL:FIRE STRUCTURE");

    doTest("T4",
        "CAD:FYI: ;SR 110/ELM RD;TIPP;FIRE GRASS;08/21/2011 19:17:18",
        "ADDR:SR 110 & ELM RD",
        "CITY:TIPPECANOE",
        "CALL:FIRE GRASS");

    doTest("T5",
        "Update: ;625-33 OAKHILL AVE;PLYM;NURSERY ST;S SECOND ST;MEDICAL CALL;08/19/2011 20:52:25",
        "ADDR:625-33 OAKHILL AVE",
        "CITY:PLYMOUTH",
        "X:NURSERY ST & S SECOND ST",
        "CALL:MEDICAL CALL");

    doTest("T6",
        "CAD:FYI: ;DIST: 143.99 FT;422 E CENTER ST;BOUR;N LINCOLN ST;E OLD US 30;ACCIDENT PI OR UNK;08/26/2011 20:38:55",
        "PLACE:DIST: 143.99 FT",
        "ADDR:422 E CENTER ST",
        "CITY:BOURBON",
        "X:N LINCOLN ST & E OLD US 30",
        "CALL:ACCIDENT PI OR UNK");
 }
  
  public static void main(String[] args) {
    new INMarshallCountyParserTest().generateTests("T1");
  }
}