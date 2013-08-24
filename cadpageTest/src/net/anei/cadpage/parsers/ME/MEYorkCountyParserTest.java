package net.anei.cadpage.parsers.ME;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
York County, ME (replacement)
Contact: Sean Perkins <sperkins@waterborofire.org>
Sender: dispatch@sanfordmaine.org

(Sanford RCC Page) MEDICAL EMERGENCY\n47\nGOODWINS ACRES \nDAYTON\nFire District: DAY\n4/25/2012 08:26
(Sanford RCC Page) MOTOR VEHICLE ACCIDENT-PI/HAZ\n47\nGOODWINS ACRES \nDAYTON\nFire District: DAY\n4/25/2012 07:18
(Sanford RCC Page) MEDICAL EMERGENCY\n2 EVERGREEN DR \nWaterboro\nFire District: WATF3\n4/24/2012 20:22
(Sanford RCC Page) MEDICAL EMERGENCY\n22 COYNE RD \nWaterboro\nFire District: WATF4\n4/24/2012 10:37
(Sanford RCC Page) MEDICAL EMERGENCY\n10 HUMMINGBIRD LN \nWaterboro\nFire District: WATF\n4/24/2012 07:29

Contact: "Adam J. Mason" <adam.j.mason@gmail.com>
Sender: dispatch@sanfordmaine.org
Sender: 2159700406
S:Sanford RCC Page M:MEDICAL EMERGENCY\n139 WASHINGTON ST \nLimerick\nDistrict: LIM\n12/2/2012 18:57\n\n
SANFORD RCC (Sanford RCC Page) MOTOR VEHICLE ACCIDENT-PI/HAZ\n(CAUTION VOIP CALL)\n139 SOKOKIS TRL \nLimerick\nDistrict: LIM\n5/7/2013 17:48 UNSUBSCRIBE
 
*/

public class MEYorkCountyParserTest extends BaseParserTest {
  
  public MEYorkCountyParserTest() {
    setParser(new MEYorkCountyParser(), "YORK COUNTY", "ME");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "(Sanford RCC Page) MEDICAL EMERGENCY\n47\nGOODWINS ACRES \nDAYTON\nFire District: DAY\n4/25/2012 08:26",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:47",
        "ADDR:GOODWINS ACRES",
        "CITY:DAYTON",
        "SRC:DAY",
        "DATE:4/25/2012",
        "TIME:08:26");

    doTest("T2",
        "(Sanford RCC Page) MOTOR VEHICLE ACCIDENT-PI/HAZ\n47\nGOODWINS ACRES \nDAYTON\nFire District: DAY\n4/25/2012 07:18",
        "CALL:MOTOR VEHICLE ACCIDENT-PI/HAZ",
        "PLACE:47",
        "ADDR:GOODWINS ACRES",
        "CITY:DAYTON",
        "SRC:DAY",
        "DATE:4/25/2012",
        "TIME:07:18");

    doTest("T3",
        "(Sanford RCC Page) MEDICAL EMERGENCY\n2 EVERGREEN DR \nWaterboro\nFire District: WATF3\n4/24/2012 20:22",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:2 EVERGREEN DR",
        "CITY:Waterboro",
        "SRC:WATF3",
        "DATE:4/24/2012",
        "TIME:20:22");

    doTest("T4",
        "(Sanford RCC Page) MEDICAL EMERGENCY\n22 COYNE RD \nWaterboro\nFire District: WATF4\n4/24/2012 10:37",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:22 COYNE RD",
        "CITY:Waterboro",
        "SRC:WATF4",
        "DATE:4/24/2012",
        "TIME:10:37");

    doTest("T5",
        "(Sanford RCC Page) MEDICAL EMERGENCY\n10 HUMMINGBIRD LN \nWaterboro\nFire District: WATF\n4/24/2012 07:29",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:10 HUMMINGBIRD LN",
        "CITY:Waterboro",
        "SRC:WATF",
        "DATE:4/24/2012",
        "TIME:07:29");

  }
  
  @Test
  public void testAdamJMason() {

    doTest("T1",
        "S:Sanford RCC Page M:MEDICAL EMERGENCY\n139 WASHINGTON ST \nLimerick\nDistrict: LIM\n12/2/2012 18:57\n\n",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:139 WASHINGTON ST",
        "CITY:Limerick",
        "SRC:LIM",
        "DATE:12/2/2012",
        "TIME:18:57");

    doTest("T2",
        "SANFORD RCC (Sanford RCC Page) MOTOR VEHICLE ACCIDENT-PI/HAZ\n" +
        "(CAUTION VOIP CALL)\n" +
        "139 SOKOKIS TRL \n" +
        "Limerick\n" +
        "District: LIM\n" +
        "5/7/2013 17:48 UNSUBSCRIBE",

        "CALL:TOR VEHICLE ACCIDENT-PI/HAZ",
        "PLACE:(CAUTION VOIP CALL)",
        "ADDR:139 SOKOKIS TRL",
        "CITY:Limerick",
        "SRC:LIM",
        "DATE:5/7/2013",
        "TIME:17:48");
  
  }
  
  public static void main(String[] args) {
    new MEYorkCountyParserTest().generateTests("T1");
  }
}