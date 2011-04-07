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

    doTest("T7",
        "501 FALL- PERSON FELL FRENE VALLEY HEALTHCARE SOUTH 1016 W HIGHWAY 28 OWENSVILLE MapRegions: OFD SECTOR 1, PAGE 072 CrossStreets: HIGHWAY Y 0.05 mi N S L&D DR 0.44 mi SW Description: 96 YOA FALL BROKEN WRIST Dispatch: 4/3/2011 06:00:43",
        "CALL:501 FALL- PERSON FELL FRENE VALLEY HEALTHCARE SOUTH",
        "ADDR:1016 W HIGHWAY 28",
        "CITY:OWENSVILLE",
        "MAP:OFD SECTOR 1, PAGE 072",
        "X:HIGHWAY Y 0.05 mi N S L&D DR 0.44 mi SW",
        "INFO:96 YOA FALL BROKEN WRIST");

    doTest("T8",
        "Body: 1 of 2\nFRM:central@fidmail.com\nSUBJ:MESSAGE\nMSG:\n501 ACCIDENTAL INJURY  1009 SPRINGFIELD RD, Apt. APT 21 OWENSVILLE MapRegions: OFD SECTOR 1,\n(Con't) 2 of 2\nPAGE 065, PAGE 122 CrossStreets: CHERRY AVE 0.06 mi SE INDUSTRIAL DR 0.22 mi NE Description:  Dispatch: 4/6/2011 12:08:04\n\n\n\n(End)",
        "CALL:501 ACCIDENTAL INJURY",
        "ADDR:1009 SPRINGFIELD RD Apt",
        "APT:21",
        "CITY:OWENSVILLE",
        "MAP:OFD SECTOR 1, PAGE 065, PAGE 122",
        "X:CHERRY AVE 0.06 mi SE INDUSTRIAL DR 0.22 mi NE");
  }

  public static void main(String[] args) {
    new MOGasconadeCountyParserTest().generateTests("T8");
  }
}
