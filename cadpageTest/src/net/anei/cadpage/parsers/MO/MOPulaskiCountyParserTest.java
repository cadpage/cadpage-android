package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Pulaski County, MO (and Laclede County)
Contact: "Mike Garrett" <hfpd.1835@yahoo.com>
Sender:911dispatch@embarqmail.com

There is code to unscramble these in MILivingstonCountyParser.  Move it to base
parser class.
Units will be 4 digits, or xFDn or Mnn.  Break at first one found

 1 of 3\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway\n(Con't) 2 of 3\n17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call\n(Con't) 3 of 3\nReceived Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29(End)

STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway 17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29
STRUCTURE FIRE RESIDENTIAL  27465 SINGLE DR UNIT PULASKI COUNTY CrossStreets: Highway AA 0.30 mi N HFD1 Call Received Time: 12/13/2010 5:05:49 Dispatch: 12/13/2010 5:07:30
BREATHING DIFFICULTY  32064 ROUTE 66   CrossStreets: HFD1 Call Received Time: 12/8/2010 03:01:30 Dispatch: 12/8/2010 03:01:49
MOTOR VEHICLE ACCIDENT WITH INJURY  150 I-44 EAST UNIT PULASKI COUNTY CrossStreets: HFD2 Call Received Time: 12/6/2010 22:25:49 Dispatch: 12/6/2010 22:28:11
STRUCTURE FIRE RESIDENTIAL  30684 HIGHWAY AB - V2W UNIT RICHLAND CrossStreets: HFD1 Call Received Time: 12/5/2010 03:31:42 Dispatch: 12/5/2010 03:34:35
VEHICLE FIRE  28795 HIGHWAY 17  PULASKI COUNTY CrossStreets: Sassafras Ln 0.12 mi SHighway AB 0.27 mi NE HFD1 Call Received Time: 12/3/2010 02:07:51 Dispatch: 12/3/2010 02:08:38

Contact: Doug Yurecko <dyurecko5u@gmail.com>
Sender: 911dispatch@embarqmail.com
 1 of 2\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:MOTOR VEHICLE ACCIDENT WITH INJURY  DYER ST & W HISTORIC 66, Apt. UNIT WAYNESVILLE\n(Con't) 2 of 2\nCrossStreets: WPD M25 WRFD1 Call Received Time: 6/8/2012 07:44:22 Dispatch: 6/8/2012 07:46:06\r\n\r\n\r\n\r\n(End)
 1 of 2\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:NATURAL COVER FIRE  TEMPORAL RD, Apt. UNIT PULASKI COUNTY CrossStreets: WRFD1 Call\n(Con't) 2 of 2\nReceived Time: 6/6/2012 11:27:42 Dispatch: 6/6/2012 11:30:25\r\n\r\n\r\n\r\n(End)
 1 of 2\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:FALLS/ ACCIDENTS  LONGVIEW LN & HIGHWAY 17 PULASKI COUNTY CrossStreets: M22 WRFD1\n(Con't) 2 of 2\nCall Received Time: 6/6/2012 07:10:40 Dispatch: 6/6/2012 07:16:16\r\n\r\n\r\n\r\n(End)
 1 of 3\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:UNCONSCIOUS/UNRESPONSIVE  21501 HIGHWAY 28, Apt. UNIT PULASKI COUNTY CrossStreets:\n(Con't) 2 of 3\nHawk Dr 0.01 mi NE Private Dr 0.16 mi NW M22 WRFD1 Call Received Time: 6/10/2012 09:19:51 Dispatch: 6/10/2012 09:21:29 Dispatch:\n(Con't) 3 of 3\n6/10/2012 09:21:29\r\n\r\n\r\n\r\n(End)
 1 of 2\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:MOTOR VEHICLE ACCIDENT WITH INJURY  101 DISCOVERY DR, Apt. UNIT WAYNESVILLE\n(Con't) 2 of 2\nCrossStreets: Lowe Av 0.02 mi N 707 WRFD1 Call Received Time: 6/13/2012 18:59:14 Dispatch: 6/13/2012 19:01:33\r\n\r\n\r\n\r\n(End)
 1 of 2\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:NATURAL COVER FIRE  15365 TOP DR PULASKI COUNTY CrossStreets: Turkey Dr 0.10 mi SE\n(Con't) 2 of 2\nTrue Rd 0.24 mi SW WRFD1 Call Received Time: 7/1/2012 21:38:25 Dispatch: 7/1/2012 21:40:28\r\n\r\n\r\n\r\n(End)

Contact: Active911
[DO NOT REPLY] Call Number: 266654 \r\nMOTOR VEHICLE ACCIDENT WITH INJURY \r\nDispatch: 8/3/2012 22:09:56 \r\nAckldge: 22:10:03 \r\n\r\n\r\n\r\n\r\nClear: 23:40:44 \r\nComplete: 23:51:16\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] Call Number: 266893 \r\nDIABETIC \r\nDispatch: 8/5/2012 16:39:31 \r\nAckldge: 16:39:33 \r\nEnroute: 16:45:08 \r\nOnScene: 16:46:40 \r\n\r\n\r\nClear: 16:51:31 \r\nComplete: 16:54:29\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] Call Number: 266943 \r\nSTRUCTURE FIRE RESIDENTIAL \r\nDispatch: 8/6/2012 00:19:09 \r\nAckldge: 0:20:18 \r\n\r\n\r\n\r\n\r\n\r\nComplete: 0:32:53\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] Call Number: 266964 \r\nNATURAL COVER FIRE \r\nDispatch: 8/6/2012 10:20:06 \r\nAckldge: 10:24:09 \r\nEnroute: 10:29:19 \r\n\r\n\r\n\r\nClear: 11:13:41 \r\nComplete: 11:13:42\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] MOTOR VEHICLE ACCIDENT WITH INJURY  MARIES COUNTY 630 MARIES COUNTY CrossStreets: MARIES MSHP1 MSHP2 DAD DFD1 Call Received Time: 8/3/2012 21:43:40 Dispatch: 8/3/2012 22:09:56\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] NATURAL COVER FIRE  11000 CYPRESS RD PULASKI COUNTY CrossStreets: N Highway 133 0.01 mi N Conway Rd 0.14 mi W DFD1 Call Received Time: 8/4/2012 02:48:10 Dispatch: 8/4/2012 02:49:49\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] FIRE ALARM - COMMERCIAL  11752 HIGHWAY MM PULASKI COUNTY CrossStreets: Highway 28 0.55 mi NW Private Dr 1.10 mi SE DFD1 Call Received Time: 8/4/2012 06:27:56 Dispatch: 8/4/2012 06:29:17\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] DIABETIC  204 SUNSET RD DIXON CrossStreets: Dale Ln 0.05 mi E Lang St 0.07 mi W DAD M31 DFD1 Call Received Time: 8/5/2012 16:27:13 Dispatch: 8/5/2012 16:39:31\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] STRUCTURE FIRE RESIDENTIAL  16202 BUTTERCUP RD PULASKI COUNTY CrossStreets: Bangor Rd 0.28 mi S Highway HH 0.63 mi NE M23 CFD1 TCFD1 PCSD1 1501 1552 1351 1562 1361 WRFD1 DFD1 Call Received Time: 8/6/2012 00:03:55 Dispatch: 8/6/2012 00:19:09\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] NATURAL COVER FIRE  HIGHWAY 28 PULASKI COUNTY CrossStreets: DFD1 Call Received Time: 8/6/2012 10:18:26 Dispatch: 8/6/2012 10:20:06\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] OVERDOSE/POISONING  208 WILLOW ALY, Apt. A DIXON CrossStreets: N Walnut st 6332.73 mi W N Oak St 6332.82 mi W DAD M31 DFD1 Call Received Time: 8/6/2012 19:18:17 Dispatch: 8/6/2012 19:43:03\r\n\r\n\r\n\r\n\r\n\r\n

Contact: jchurch9914 <jchurch9914@gmail.com>
Sender: 911dispatch@embarqmail.com
Subject:DO NOT REPLY\nFIRE ALARM - COMMERCIAL MASONIC LODGE - WAYNESVILLE 1409 OUSLEY RD WAYNESVILLE CrossStreets: E Historic 66 0.04\r
Subject:DO NOT REPLY\nGAS ODOR  23198 SPRUCE RD, Apt. 202 WAYNESVILLE CrossStreets: Sampler Ln 0.01 mi NW Savannah Ln 0.08 mi E WRFD1\r
Subject:DO NOT REPLY\nFIRE ALARM - COMMERCIAL WESTSIDE BAPTIST CHURCH 801 HIST RT 66 W WAYNESVILLE CrossStreets: WRFD1 Call Received \r

*/

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
        "X:Highway 17 0.42 mi W",
        "UNIT:CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1",
        "DATE:12/6/2010",
        "TIME:21:50:29");

    doTest("T2",
        "STRUCTURE FIRE RESIDENTIAL  27465 SINGLE DR UNIT PULASKI COUNTY CrossStreets: Highway AA 0.30 mi N HFD1 Call Received Time: 12/13/2010 5:05:49 Dispatch: 12/13/2010 5:07:30",
        "CALL:STRUCTURE FIRE RESIDENTIAL",
        "ADDR:27465 SINGLE DR",
        "X:Highway AA 0.30 mi N",
        "UNIT:HFD1",
        "DATE:12/13/2010",
        "TIME:5:07:30");

    doTest("T3",
        "BREATHING DIFFICULTY  32064 ROUTE 66   CrossStreets: HFD1 Call Received Time: 12/8/2010 03:01:30 Dispatch: 12/8/2010 03:01:49",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:32064 ROUTE 66",
        "UNIT:HFD1",
        "DATE:12/8/2010",
        "TIME:03:01:49");

    doTest("T4",
        "MOTOR VEHICLE ACCIDENT WITH INJURY  150 I-44 EAST UNIT PULASKI COUNTY CrossStreets: HFD2 Call Received Time: 12/6/2010 22:25:49 Dispatch: 12/6/2010 22:28:11",
        "CALL:MOTOR VEHICLE ACCIDENT WITH INJURY",
        "ADDR:150 I-44 EAST",
        "MADDR:150 I 44 EAST",
        "UNIT:HFD2",
        "DATE:12/6/2010",
        "TIME:22:28:11");

    doTest("T5",
        "STRUCTURE FIRE RESIDENTIAL  30684 HIGHWAY AB - V2W UNIT RICHLAND CrossStreets: HFD1 Call Received Time: 12/5/2010 03:31:42 Dispatch: 12/5/2010 03:34:35",
        "CALL:STRUCTURE FIRE RESIDENTIAL",
        "ADDR:30684 HIGHWAY AB",
        "PLACE:V2W",
        "CITY:RICHLAND",
        "UNIT:HFD1",
        "DATE:12/5/2010",
        "TIME:03:34:35");

    doTest("T6",
        "VEHICLE FIRE  28795 HIGHWAY 17  PULASKI COUNTY CrossStreets: Sassafras Ln 0.12 mi SHighway AB 0.27 mi NE HFD1 Call Received Time: 12/3/2010 02:07:51 Dispatch: 12/3/2010 02:08:38",
        "CALL:VEHICLE FIRE",
        "ADDR:28795 HIGHWAY 17",
        "X:Sassafras Ln 0.12 mi SHighway AB 0.27 mi NE",
        "UNIT:HFD1",
        "DATE:12/3/2010",
        "TIME:02:08:38");
        
  }
  
  @Test
  public void testDescrambler() {

    doTest("T1",
        " 1 of 3\n" +
        "FRM:911dispatch@embarqmail.com\n" +
        "SUBJ:DO NOT REPLY\n" +
        "MSG:STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway\n" +
        "(Con't) 2 of 3\n" +
        "17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call\n" +
        "(Con't) 3 of 3\n" +
        "Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29(End)",

        "CALL:STRUCTURE FIRE RESIDENTIAL",
        "ADDR:11280 BATTLE LN",
        "X:Highway 17 0.42 mi W",
        "UNIT:CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1",
        "DATE:12/6/2010",
        "TIME:21:50:29");
  }
  
  @Test
  public void testDougYourecko() {

    doTest("T1",
        " 1 of 2\n" +
        "FRM:911dispatch@embarqmail.com\n" +
        "SUBJ:DO NOT REPLY\n" +
        "MSG:MOTOR VEHICLE ACCIDENT WITH INJURY  DYER ST & W HISTORIC 66, Apt. UNIT WAYNESVILLE\n" +
        "(Con't) 2 of 2\n" +
        "CrossStreets: WPD M25 WRFD1 Call Received Time: 6/8/2012 07:44:22 Dispatch: 6/8/2012 07:46:06\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "(End)",

        "CALL:MOTOR VEHICLE ACCIDENT WITH INJURY",
        "ADDR:DYER ST & W HISTORIC 66",
        "CITY:WAYNESVILLE",
        "UNIT:WPD M25 WRFD1",
        "DATE:6/8/2012",
        "TIME:07:46:06");

    doTest("T2",
        " 1 of 2\n" +
        "FRM:911dispatch@embarqmail.com\n" +
        "SUBJ:DO NOT REPLY\n" +
        "MSG:NATURAL COVER FIRE  TEMPORAL RD, Apt. UNIT PULASKI COUNTY CrossStreets: WRFD1 Call\n" +
        "(Con't) 2 of 2\n" +
        "Received Time: 6/6/2012 11:27:42 Dispatch: 6/6/2012 11:30:25\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "(End)",

        "CALL:NATURAL COVER FIRE",
        "ADDR:TEMPORAL RD",
        "UNIT:WRFD1",
        "DATE:6/6/2012",
        "TIME:11:30:25");

    doTest("T3",
        " 1 of 2\n" +
        "FRM:911dispatch@embarqmail.com\n" +
        "SUBJ:DO NOT REPLY\n" +
        "MSG:FALLS/ ACCIDENTS  LONGVIEW LN & HIGHWAY 17 PULASKI COUNTY CrossStreets: M22 WRFD1\n" +
        "(Con't) 2 of 2\n" +
        "Call Received Time: 6/6/2012 07:10:40 Dispatch: 6/6/2012 07:16:16\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "(End)",

        "CALL:FALLS/ ACCIDENTS",
        "ADDR:LONGVIEW LN & HIGHWAY 17",  // Longview Road & Highway 17 do not intersect
        "UNIT:M22 WRFD1",
        "DATE:6/6/2012",
        "TIME:07:16:16");

    doTest("T4",
        " 1 of 3\n" +
        "FRM:911dispatch@embarqmail.com\n" +
        "SUBJ:DO NOT REPLY\n" +
        "MSG:UNCONSCIOUS/UNRESPONSIVE  21501 HIGHWAY 28, Apt. UNIT PULASKI COUNTY CrossStreets:\n" +
        "(Con't) 2 of 3\n" +
        "Hawk Dr 0.01 mi NE Private Dr 0.16 mi NW M22 WRFD1 Call Received Time: 6/10/2012 09:19:51 Dispatch: 6/10/2012 09:21:29 Dispatch:\n" +
        "(Con't) 3 of 3\n" +
        "6/10/2012 09:21:29\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "(End)",

        "CALL:UNCONSCIOUS/UNRESPONSIVE",
        "ADDR:21501 HIGHWAY 28",
        "X:Hawk Dr 0.01 mi NE Private Dr 0.16 mi NW",
        "UNIT:M22 WRFD1",
        "DATE:6/10/2012",
        "TIME:09:21:29");

    doTest("T5",
        " 1 of 2\n" +
        "FRM:911dispatch@embarqmail.com\n" +
        "SUBJ:DO NOT REPLY\n" +
        "MSG:MOTOR VEHICLE ACCIDENT WITH INJURY  101 DISCOVERY DR, Apt. UNIT WAYNESVILLE\n" +
        "(Con't) 2 of 2\n" +
        "CrossStreets: Lowe Av 0.02 mi N 707 WRFD1 Call Received Time: 6/13/2012 18:59:14 Dispatch: 6/13/2012 19:01:33\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "(End)",

        "CALL:MOTOR VEHICLE ACCIDENT WITH INJURY",
        "ADDR:101 DISCOVERY DR",
        "CITY:WAYNESVILLE",
        "X:Lowe Av 0.02 mi N 707",
        "UNIT:WRFD1",
        "DATE:6/13/2012",
        "TIME:19:01:33");

    doTest("T6",
        " 1 of 2\n" +
        "FRM:911dispatch@embarqmail.com\n" +
        "SUBJ:DO NOT REPLY\n" +
        "MSG:NATURAL COVER FIRE  15365 TOP DR PULASKI COUNTY CrossStreets: Turkey Dr 0.10 mi SE\n" +
        "(Con't) 2 of 2\n" +
        "True Rd 0.24 mi SW WRFD1 Call Received Time: 7/1/2012 21:38:25 Dispatch: 7/1/2012 21:40:28\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "(End)",

        "CALL:NATURAL COVER FIRE",
        "ADDR:15365 TOP DR",
        "X:Turkey Dr 0.10 mi SE True Rd 0.24 mi SW",
        "UNIT:WRFD1",
        "DATE:7/1/2012",
        "TIME:21:40:28");

  }
  
  @Test
  public void testActive911RunReport() {

    doTest("T1",
        "[DO NOT REPLY] Call Number: 266654 \r\n" +
        "MOTOR VEHICLE ACCIDENT WITH INJURY \r\n" +
        "Dispatch: 8/3/2012 22:09:56 \r\n" +
        "Ackldge: 22:10:03 \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Clear: 23:40:44 \r\n" +
        "Complete: 23:51:16\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:RUN REPORT",
        "PLACE:Call Number: 266654 \nMOTOR VEHICLE ACCIDENT WITH INJURY \nDispatch: 8/3/2012 22:09:56 \nAckldge: 22:10:03 \n\n\n\n\nClear: 23:40:44 \nComplete: 23:51:16");

    doTest("T2",
        "[DO NOT REPLY] Call Number: 266893 \r\n" +
        "DIABETIC \r\n" +
        "Dispatch: 8/5/2012 16:39:31 \r\n" +
        "Ackldge: 16:39:33 \r\n" +
        "Enroute: 16:45:08 \r\n" +
        "OnScene: 16:46:40 \r\n" +
        "\r\n" +
        "\r\n" +
        "Clear: 16:51:31 \r\n" +
        "Complete: 16:54:29\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:RUN REPORT",
        "PLACE:Call Number: 266893 \nDIABETIC \nDispatch: 8/5/2012 16:39:31 \nAckldge: 16:39:33 \nEnroute: 16:45:08 \nOnScene: 16:46:40 \n\n\nClear: 16:51:31 \nComplete: 16:54:29");

    doTest("T3",
        "[DO NOT REPLY] Call Number: 266943 \r\n" +
        "STRUCTURE FIRE RESIDENTIAL \r\n" +
        "Dispatch: 8/6/2012 00:19:09 \r\n" +
        "Ackldge: 0:20:18 \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Complete: 0:32:53\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:RUN REPORT",
        "PLACE:Call Number: 266943 \nSTRUCTURE FIRE RESIDENTIAL \nDispatch: 8/6/2012 00:19:09 \nAckldge: 0:20:18 \n\n\n\n\n\nComplete: 0:32:53");

    doTest("T4",
        "[DO NOT REPLY] Call Number: 266964 \r\n" +
        "NATURAL COVER FIRE \r\n" +
        "Dispatch: 8/6/2012 10:20:06 \r\n" +
        "Ackldge: 10:24:09 \r\n" +
        "Enroute: 10:29:19 \r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "Clear: 11:13:41 \r\n" +
        "Complete: 11:13:42\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:RUN REPORT",
        "PLACE:Call Number: 266964 \nNATURAL COVER FIRE \nDispatch: 8/6/2012 10:20:06 \nAckldge: 10:24:09 \nEnroute: 10:29:19 \n\n\n\nClear: 11:13:41 \nComplete: 11:13:42");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[DO NOT REPLY] MOTOR VEHICLE ACCIDENT WITH INJURY  MARIES COUNTY 630 MARIES COUNTY CrossStreets: MARIES MSHP1 MSHP2 DAD DFD1 Call Received Time: 8/3/2012 21:43:40 Dispatch: 8/3/2012 22:09:56\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:MOTOR VEHICLE ACCIDENT WITH INJURY",
        "ADDR:MARIES COUNTY 630 MARIES COUNTY",
        "MADDR:MARIES COUNTY ROAD 630 MARIES COUNTY",
        "UNIT:MARIES MSHP1 MSHP2 DAD DFD1",
        "DATE:8/3/2012",
        "TIME:22:09:56");

    doTest("T2",
        "[DO NOT REPLY] NATURAL COVER FIRE  11000 CYPRESS RD PULASKI COUNTY CrossStreets: N Highway 133 0.01 mi N Conway Rd 0.14 mi W DFD1 Call Received Time: 8/4/2012 02:48:10 Dispatch: 8/4/2012 02:49:49\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:NATURAL COVER FIRE",
        "ADDR:11000 CYPRESS RD",
        "X:N Highway 133 0.01 mi N Conway Rd 0.14 mi W",
        "UNIT:DFD1",
        "DATE:8/4/2012",
        "TIME:02:49:49");

    doTest("T3",
        "[DO NOT REPLY] FIRE ALARM - COMMERCIAL  11752 HIGHWAY MM PULASKI COUNTY CrossStreets: Highway 28 0.55 mi NW Private Dr 1.10 mi SE DFD1 Call Received Time: 8/4/2012 06:27:56 Dispatch: 8/4/2012 06:29:17\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:FIRE ALARM - COMMERCIAL",
        "ADDR:11752 HIGHWAY MM",
        "X:Highway 28 0.55 mi NW Private Dr 1.10 mi SE",
        "UNIT:DFD1",
        "DATE:8/4/2012",
        "TIME:06:29:17");

    doTest("T4",
        "[DO NOT REPLY] DIABETIC  204 SUNSET RD DIXON CrossStreets: Dale Ln 0.05 mi E Lang St 0.07 mi W DAD M31 DFD1 Call Received Time: 8/5/2012 16:27:13 Dispatch: 8/5/2012 16:39:31\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:DIABETIC",
        "ADDR:204 SUNSET RD",
        "CITY:DIXON",
        "X:Dale Ln 0.05 mi E Lang St 0.07 mi W",
        "UNIT:DAD M31 DFD1",
        "DATE:8/5/2012",
        "TIME:16:39:31");

    doTest("T5",
        "[DO NOT REPLY] STRUCTURE FIRE RESIDENTIAL  16202 BUTTERCUP RD PULASKI COUNTY CrossStreets: Bangor Rd 0.28 mi S Highway HH 0.63 mi NE M23 CFD1 TCFD1 PCSD1 1501 1552 1351 1562 1361 WRFD1 DFD1 Call Received Time: 8/6/2012 00:03:55 Dispatch: 8/6/2012 00:19:09\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:STRUCTURE FIRE RESIDENTIAL",
        "ADDR:16202 BUTTERCUP RD",
        "X:Bangor Rd 0.28 mi S Highway HH 0.63 mi NE",
        "UNIT:M23 CFD1 TCFD1 PCSD1 1501 1552 1351 1562 1361 WRFD1 DFD1",
        "DATE:8/6/2012",
        "TIME:00:19:09");

    doTest("T6",
        "[DO NOT REPLY] NATURAL COVER FIRE  HIGHWAY 28 PULASKI COUNTY CrossStreets: DFD1 Call Received Time: 8/6/2012 10:18:26 Dispatch: 8/6/2012 10:20:06\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:NATURAL COVER FIRE",
        "ADDR:HIGHWAY 28",
        "UNIT:DFD1",
        "DATE:8/6/2012",
        "TIME:10:20:06");

    doTest("T7",
        "[DO NOT REPLY] OVERDOSE/POISONING  208 WILLOW ALY, Apt. A DIXON CrossStreets: N Walnut st 6332.73 mi W N Oak St 6332.82 mi W DAD M31 DFD1 Call Received Time: 8/6/2012 19:18:17 Dispatch: 8/6/2012 19:43:03\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:OVERDOSE/POISONING",
        "ADDR:208 WILLOW ALY",  // Not mapping
        "APT:A",
        "CITY:DIXON",
        "X:N Walnut st 6332.73 mi W N Oak St 6332.82 mi W",
        "UNIT:DAD M31 DFD1",
        "DATE:8/6/2012",
        "TIME:19:43:03");

  }
  
  @Test
  public void testJChurch() {

    doTest("T1",
        "Subject:DO NOT REPLY\n" +
        "FIRE ALARM - COMMERCIAL MASONIC LODGE - WAYNESVILLE 1409 OUSLEY RD WAYNESVILLE CrossStreets: E Historic 66 0.04\r",

        "CALL:FIRE ALARM - COMMERCIAL MASONIC LODGE - WAYNESVILLE",
        "ADDR:1409 OUSLEY RD",
        "CITY:WAYNESVILLE",
        "X:E Historic 66 0.04");

    doTest("T2",
        "Subject:DO NOT REPLY\n" +
        "GAS ODOR  23198 SPRUCE RD, Apt. 202 WAYNESVILLE CrossStreets: Sampler Ln 0.01 mi NW Savannah Ln 0.08 mi E WRFD1\r",

        "CALL:GAS ODOR",
        "ADDR:23198 SPRUCE RD",
        "APT:202",
        "CITY:WAYNESVILLE",
        "X:Sampler Ln 0.01 mi NW Savannah Ln 0.08 mi E",
        "UNIT:WRFD1");

    doTest("T3",
        "Subject:DO NOT REPLY\n" +
        "FIRE ALARM - COMMERCIAL WESTSIDE BAPTIST CHURCH 801 HIST RT 66 W WAYNESVILLE CrossStreets: WRFD1 Call Received \r",

        "CALL:FIRE ALARM - COMMERCIAL WESTSIDE BAPTIST CHURCH",
        "ADDR:801 HIST RT 66 W",
        "MADDR:801 HISTORIC US 66 W",
        "CITY:WAYNESVILLE",
        "UNIT:WRFD1");

  }
  
  public static void main(String[] args) {
    new MOPulaskiCountyParserTest().generateTests("T1");
  }
}
