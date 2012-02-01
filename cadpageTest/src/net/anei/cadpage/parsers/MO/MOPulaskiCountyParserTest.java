package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOPulaskiCountyParserTest extends BaseParserTest {
  
  public MOPulaskiCountyParserTest() {
    setParser(new MOPulaskiCountyParser(), "PULASKI COUNTY", "MO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway 17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29",
        "CALL:STRUCTURE FIRE RESIDENTIAL",
        "ADDR:11280 BATTLE LN",
        "CITY:PULASKI COUNTY",
        "X:Highway 17 0.42 mi W",
        "UNIT:CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1");

    doTest("T2",
        "STRUCTURE FIRE RESIDENTIAL  27465 SINGLE DR UNIT PULASKI COUNTY CrossStreets: Highway AA 0.30 mi N HFD1 Call Received Time: 12/13/2010 5:05:49 Dispatch: 12/13/2010 5:07:30",
        "CALL:STRUCTURE FIRE RESIDENTIAL",
        "ADDR:27465 SINGLE DR",
        "CITY:PULASKI COUNTY",
        "X:Highway AA 0.30 mi N",
        "UNIT:HFD1");
        
    doTest("T3",
        "BREATHING DIFFICULTY  32064 ROUTE 66   CrossStreets: HFD1 Call Received Time: 12/8/2010 03:01:30 Dispatch: 12/8/2010 03:01:49",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:32064 ROUTE 66",
        "UNIT:HFD1");

    doTest("T4",
        "MOTOR VEHICLE ACCIDENT WITH INJURY  150 I-44 EAST UNIT PULASKI COUNTY CrossStreets: HFD2 Call Received Time: 12/6/2010 22:25:49 Dispatch: 12/6/2010 22:28:11",
        "CALL:MOTOR VEHICLE ACCIDENT WITH INJURY",
        "ADDR:150 I-44 EAST",
        "MADDR:150 I 44 EAST",
        "CITY:PULASKI COUNTY",
        "UNIT:HFD2");

    doTest("T5",
        "STRUCTURE FIRE RESIDENTIAL  30684 HIGHWAY AB - V2W UNIT RICHLAND CrossStreets: HFD1 Call Received Time: 12/5/2010 03:31:42 Dispatch: 12/5/2010 03:34:35",
        "CALL:STRUCTURE FIRE RESIDENTIAL",
        "ADDR:30684 HIGHWAY AB",
        "CITY:RICHLAND",
        "UNIT:HFD1");

    doTest("T6",
        "VEHICLE FIRE  28795 HIGHWAY 17  PULASKI COUNTY CrossStreets: Sassafras Ln 0.12 mi SHighway AB 0.27 mi NE HFD1 Call Received Time: 12/3/2010 02:07:51 Dispatch: 12/3/2010 02:08:38",
        "CALL:VEHICLE FIRE",
        "ADDR:28795 HIGHWAY 17",
        "CITY:PULASKI COUNTY",
        "X:Sassafras Ln 0.12 mi SHighway AB 0.27 mi NE",
        "UNIT:HFD1");
        
  }
  
  @Test
  public void testDescrambler() {
    doTest("T1",
        "1 of 3\n" +
        "FRM:911dispatch@embarqmail.com\n" + 
        "SUBJ:DO NOT REPLY\n" +
        "MSG:STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway\n" +
        "(Con't) 2 of 3\n" +
        "17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call\n" +
        "(Con't) 3 of 3\n" +
        "Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29(End)",
        "CALL:STRUCTURE FIRE RESIDENTIAL",
        "ADDR:11280 BATTLE LN",
        "CITY:PULASKI COUNTY",
        "X:Highway 17 0.42 mi W",
        "UNIT:CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1");
  }
}
