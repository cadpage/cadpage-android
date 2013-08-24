package net.anei.cadpage.parsers.ID;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.ID.IDShoshoneCountyParserTest;

import org.junit.Test;

/*
Shoshone County, ID
Contact: Bill Holstein <waholstein@yahoo.com>
Sender: administrator@shoshoneso.com

(Imc Solutions Page) MEDICAL EMERGENCY\n6111 OLD RIVER RD \nKINGSTON\nDistrict: D2\n2/28/2013 12:01
(Imc Solutions Page) MEDICAL EMERGENCY\n911 MAIN ST \nWARDNER\nDistrict: D2\n2/28/2013 01:40
(Imc Solutions Page) MEDICAL EMERGENCY\n1518 W POLARIS AVE \nOsburn\nDistrict: D1\n2/26/2013 21:08
(Imc Solutions Page) MEDICAL EMERGENCY\n214 CYPRESS AVE \nWALLACE\nDistrict: D1\n2/26/2013 18:55
(Imc Solutions Page) MEDICAL EMERGENCY\n127 KELLOGG AVE \nKellogg\nDistrict: D2\n2/26/2013 17:54
(Imc Solutions Page) MEDICAL EMERGENCY\n501 UNDERWOOD AVE \nPinehurst\nDistrict: D2\n2/26/2013 01:50
(Imc Solutions Page) MVA WITH INJURIES\n60 I90 \nWALLACE\nDistrict: D1\n2/25/2013 10:16
(Imc Solutions Page) MEDICAL EMERGENCY\n444 LOWER PAGE RD \nSmelterville\nDistrict: D2\n2/23/2013 21:26
(Imc Solutions Page) MEDICAL EMERGENCY\n6111 OLD RIVER RD \nKINGSTON\nDistrict: D2\n2/28/2013 12:01
*/

public class IDShoshoneCountyParserTest extends BaseParserTest {
  
  public IDShoshoneCountyParserTest() {
    setParser(new IDShoshoneCountyParser(), "SHOSHONE COUNTY", "ID");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Imc Solutions Page) MEDICAL EMERGENCY\n6111 OLD RIVER RD \nKINGSTON\nDistrict: D2\n2/28/2013 12:01",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:6111 OLD RIVER RD",
        "CITY:KINGSTON",
        "UNIT:D2",
        "DATE:2/28/2013",
        "TIME:12:01");

    doTest("T2",
        "(Imc Solutions Page) MEDICAL EMERGENCY\n911 MAIN ST \nWARDNER\nDistrict: D2\n2/28/2013 01:40",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:911 MAIN ST",
        "CITY:WARDNER",
        "UNIT:D2",
        "DATE:2/28/2013",
        "TIME:01:40");

    doTest("T3",
        "(Imc Solutions Page) MEDICAL EMERGENCY\n1518 W POLARIS AVE \nOsburn\nDistrict: D1\n2/26/2013 21:08",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:1518 W POLARIS AVE",
        "CITY:Osburn",
        "UNIT:D1",
        "DATE:2/26/2013",
        "TIME:21:08");

    doTest("T4",
        "(Imc Solutions Page) MEDICAL EMERGENCY\n214 CYPRESS AVE \nWALLACE\nDistrict: D1\n2/26/2013 18:55",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:214 CYPRESS AVE",
        "CITY:WALLACE",
        "UNIT:D1",
        "DATE:2/26/2013",
        "TIME:18:55");

    doTest("T5",
        "(Imc Solutions Page) MEDICAL EMERGENCY\n127 KELLOGG AVE \nKellogg\nDistrict: D2\n2/26/2013 17:54",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:127 KELLOGG AVE",
        "CITY:Kellogg",
        "UNIT:D2",
        "DATE:2/26/2013",
        "TIME:17:54");

    doTest("T6",
        "(Imc Solutions Page) MEDICAL EMERGENCY\n501 UNDERWOOD AVE \nPinehurst\nDistrict: D2\n2/26/2013 01:50",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:501 UNDERWOOD AVE",
        "CITY:Pinehurst",
        "UNIT:D2",
        "DATE:2/26/2013",
        "TIME:01:50");

    doTest("T7",
        "(Imc Solutions Page) MVA WITH INJURIES\n60 I90 \nWALLACE\nDistrict: D1\n2/25/2013 10:16",
        "CALL:MVA WITH INJURIES",
        "ADDR:60 I-90",
        "MADDR:60 I 90",
        "CITY:WALLACE",
        "UNIT:D1",
        "DATE:2/25/2013",
        "TIME:10:16");

    doTest("T8",
        "(Imc Solutions Page) MEDICAL EMERGENCY\n444 LOWER PAGE RD \nSmelterville\nDistrict: D2\n2/23/2013 21:26",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:444 LOWER PAGE RD",
        "CITY:Smelterville",
        "UNIT:D2",
        "DATE:2/23/2013",
        "TIME:21:26");

  }
  
  public static void main(String[] args) {
    new IDShoshoneCountyParserTest().generateTests("T1");
  }
}