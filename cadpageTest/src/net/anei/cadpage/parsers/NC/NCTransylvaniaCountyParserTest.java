package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCTransylvaniaCountyParserTest extends BaseParserTest {
  
  public NCTransylvaniaCountyParserTest() {
    setParser(new NCTransylvaniaCountyParser(), "TRANSYLVANIA COUNTY", "NC");
  }
  
  @Test
  public void testParser1() {

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
  
  @Test
  public void testParser2() {

    doTest("T1",
        "8595 GREENVILLE HWY CONNESTEE 2011-026771 16:02:18 CHEST PAIN 67 YO FEMALE, POSSIBLY HAVING A HEART ATTACK. 1ST HOUSE ON LT PAST CEDAR MTN HOUSE",
        "ADDR:8595 GREENVILLE HWY",
        "PLACE:CONNESTEE",
        "ID:2011-026771",
        "INFO:CHEST PAIN 67 YO FEMALE, POSSIBLY HAVING A HEART ATTACK. 1ST HOUSE ON LT PAST CEDAR MTN HOUSE");

    doTest("T2",
        "313 KNOB RD BREVARD 2011-027203 18:23:45 STRUCTURE FIRE ELECTRICAL FIRE. SECOND HOUSE ON THE LEFT.",
        "ADDR:313 KNOB RD",
        "PLACE:BREVARD",
        "ID:2011-027203",
        "INFO:STRUCTURE FIRE ELECTRICAL FIRE. SECOND HOUSE ON THE LEFT.");

    doTest("T3",
        "21 HONDAH BLVD LAKE HONDAH 2011-027194 17:28:49 STRUCTURE FIRE CALLER ADV A LOT OF SMOKE COMING FROM HIS NEIGHBORS HOUSE.",
        "ADDR:21 HONDAH BLVD",
        "PLACE:LAKE HONDAH",
        "ID:2011-027194",
        "INFO:STRUCTURE FIRE CALLER ADV A LOT OF SMOKE COMING FROM HIS NEIGHBORS HOUSE.");

    doTest("T4",
        "1 CONNESTEE RD CONNESTEE 2011-027031 14:04:11 HEAD INJURY REF 9 YO HAD BICYCLE ACCIDENT IN FRONT OF THE CHURCH, POSSIBLE HEAD AND ARM INJURY",
        "ADDR:1 CONNESTEE RD",
        "PLACE:CONNESTEE",
        "ID:2011-027031",
        "INFO:HEAD INJURY REF 9 YO HAD BICYCLE ACCIDENT IN FRONT OF THE CHURCH, POSSIBLE HEAD AND ARM INJURY");

    doTest("T5",
        "11 SHERWOOD RIDGE RD SHERWOOD FOREST 2011-027139 10:23:11 UNCONSCIOUS/UNRESPONSIVE female unresp dob 04/07/21 winnie seale",
        "ADDR:11 SHERWOOD RIDGE RD",
        "PLACE:SHERWOOD FOREST",
        "ID:2011-027139",
        "INFO:UNCONSCIOUS/UNRESPONSIVE female unresp dob 04/07/21 winnie seale");

  }
  

  public static void main(String[] args) {
    new NCTransylvaniaCountyParserTest().generateTests("T1", "ADDR CITY PLACE CODE ID CALL INFO");
  }
}
