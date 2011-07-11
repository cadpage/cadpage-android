package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCTransylvaniaCountyParserTest extends BaseParserTest {
  
  public NCTransylvaniaCountyParserTest() {
    setParser(new NCTransylvaniaCountyParser(), "TRANSYLVANIA COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "911CENTER:45 OAK PARK DR BREVARD CITY 2011-019677 10:43:54 ALARM FIRE (10-37) alarm fire",
        "ADDR:45 OAK PARK DR",
        "CITY:BREVARD CITY",
        "ID:2011-019677",
        "CALL:ALARM FIRE",
        "INFO:(10-37) alarm fire");

    doTest("T2",
        "911CENTER:2725 RESERVE RD LITTLE RIVER 2011-019735 16:20:13 ALARM FIRE (10-37) FOGLE, JOHN 8288775516 FIRE ALARM SMOKE DETECTOR",
        "ADDR:2725 RESERVE RD",
        "CITY:LITTLE RIVER",
        "ID:2011-019735",
        "CALL:ALARM FIRE",
        "INFO:(10-37) FOGLE, JOHN 8288775516 FIRE ALARM SMOKE DETECTOR");

    doTest("T3",
        "911CENTER:1 WHITMIRE ST BREVARD CITY 2011-019863 13:34:30 STRUCTURE FIRE OUTBUILDING ON FIRE",
        "ADDR:1 WHITMIRE ST",
        "CITY:BREVARD CITY",
        "ID:2011-019863",
        "INFO:STRUCTURE FIRE OUTBUILDING ON FIRE");

    doTest("T4",
        "911CENTER:1 N BROAD ST BREVARD CITY 2011-019978 10:22:32 HAZARDOUS MATERIAL INCIDENT GREEN RANGE ROVER LEAKING GAS AT PUMP #7",
        "ADDR:1 N BROAD ST",
        "CITY:BREVARD CITY",
        "ID:2011-019978",
        "INFO:HAZARDOUS MATERIAL INCIDENT GREEN RANGE ROVER LEAKING GAS AT PUMP #7");

    doTest("T5",
        "911CENTER:400 ASHEVILLE HWY BREVARD CITY 2011-020259 13:35:26 BRUSH FIRE MULCH FIRE IN FRONT OF DOMINOS PIZZA",
        "ADDR:400 ASHEVILLE HWY",
        "CITY:BREVARD CITY",
        "ID:2011-020259",
        "INFO:BRUSH FIRE MULCH FIRE IN FRONT OF DOMINOS PIZZA");

    doTest("T6",
        "911CENTER:1 ISLAND COVE RD LITTLE RIVER 2011-020447 21:09:42 STRUCTURE FIRE BLACK SMOKE ON ISLAND COVE RD",
        "ADDR:1 ISLAND COVE RD",
        "CITY:LITTLE RIVER",
        "ID:2011-020447",
        "INFO:STRUCTURE FIRE BLACK SMOKE ON ISLAND COVE RD");
  }
  

  public static void main(String[] args) {
    new NCTransylvaniaCountyParserTest().generateTests("T1", "ADDR CITY PLACE CODE ID CALL INFO");
  }
}
