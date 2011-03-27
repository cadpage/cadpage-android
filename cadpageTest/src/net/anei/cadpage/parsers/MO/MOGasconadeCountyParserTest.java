package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOGasconadeCountyParserTest extends BaseParserTest {
  
  public MOGasconadeCountyParserTest() {
    setParser(new MOGasconadeCountyParser(), "", "MO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MESSAGE / M50 CHEST PAIN  4449 MARIES CR 426 OUT OF COUNTY MapRegions:  CrossStreets: Description:  Dispatch: 3/25/2011 03:51:43\n\n\n\n\n",
        "CALL:M50 CHEST PAIN",
        "ADDR:4449 MARIES CR 426",
        "CITY:OUT OF COUNTY");

    doTest("T2",
        "MESSAGE / M51 MOTOR VEHICLE ACCIDENT-INJURIES  HWY 89  MapRegions:  CrossStreets: Description:  Dispatch: 3/26/2011 11:29:32\n\n\n\n\n",
        "CALL:M51 MOTOR VEHICLE ACCIDENT-INJURIES",
        "ADDR:HWY 89");

    doTest("T3",
        "MESSAGE / M51 MOTOR VEHICLE ACCIDENT-UNKNOWN INJ  HWY 89  MapRegions:  CrossStreets: Description:  Dispatch: 3/26/2011 11:39:53\n\n\n\n\n",
        "CALL:M51 MOTOR VEHICLE ACCIDENT-UNKNOWN INJ",
        "ADDR:HWY 89");

    doTest("T4",
        "M51 FALL- PERSON FELL 408 N ALVARADO AVE BELLE MapRegions: CrossStreets: E BELAIR AVE 0.03 mi S E ROHRER DR 0.13 mi N Description: Dispatch: 3/24/2011 11:47:54",
        "CALL:M51 FALL- PERSON FELL",
        "ADDR:408 N ALVARADO AVE",
        "CITY:BELLE",
        "X:E BELAIR AVE 0.03 mi S E ROHRER DR 0.13 mi N");

    doTest("T5",
        "M50 SICK PERSON- SICK CASE 4644 HIGHWAY B, Apt. BOX 14 GASCONADE COUNTY MapRegions: PAGE 103 CrossStreets: ELK HEAD RD 0.08 mi SW RED BIRD RD 0.46 mi N Description: HALF MILE SOUTH OF REDBIRD RD Dispatch: 3/24/2011 11:25:45",
        "CALL:M50 SICK PERSON- SICK CASE",
        "ADDR:4644 HIGHWAY B",
        "APT:BOX 14",
        "MAP:PAGE 103",
        "X:ELK HEAD RD 0.08 mi SW RED BIRD RD 0.46 mi N",
        "INFO:HALF MILE SOUTH OF REDBIRD RD");

    doTest("T6",
        "M50 SICK PERSON- SICK CASE 901 W EIGHTH ST BELLE MapRegions: CrossStreets: S SHOCKLEY AVE 0.01 mi NE S APPLE AVE 0.19 mi E Description: Dispatch: 3/24/2011 21:05:48",
        "CALL:M50 SICK PERSON- SICK CASE",
        "ADDR:901 W EIGHTH ST",
        "CITY:BELLE",
        "X:S SHOCKLEY AVE 0.01 mi NE S APPLE AVE 0.19 mi E");
        
  }

  public static void main(String[] args) {
    new MOGasconadeCountyParserTest().generateTests("T1");
  }
}
