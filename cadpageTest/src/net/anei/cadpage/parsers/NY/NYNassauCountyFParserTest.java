package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYNassauCountyFParserTest extends BaseParserTest {
  
  public NYNassauCountyFParserTest() {
    setParser(new NYNassauCountyFParser(), "NASSAU COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(* ) RESCUE\n7:29 PM\n181 MEADOWBROOK ROAD\nMERRICK\nAKEL CT\nWILLIS AVE\nMALE IN PAIN/PREVIOUS MVA\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:19:29:00",
        "ADDR:181 MEADOWBROOK ROAD",
        "CITY:MERRICK",
        "X:AKEL CT & WILLIS AVE",
        "INFO:MALE IN PAIN/PREVIOUS MVA",
        "PHONE:1-516-324-2379");

    doTest("T2",
        "(*) RESCUE\r\n" +
        "12:06 PM\r\n" +
        "128 HEWLETT AVE N\r\n" +
        "MERRICK\r\n" +
        "SMITH ST\r\n" +
        "LOINES AVE\r\n" +
        "DR GOLDSTEINS OFFICE-CHEST PAIN\r\n" +
        "1-516-324-2379   pport@2sig.com",

        "CALL:RESCUE",
        "TIME:12:06:00",
        "ADDR:128 HEWLETT AVE N",
        "CITY:MERRICK",
        "X:SMITH ST & LOINES AVE",
        "INFO:DR GOLDSTEINS OFFICE-CHEST PAIN",
        "PHONE:1-516-324-2379   pport@2sig.com");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(*) RESCUE\n11:06 AM\n1815 CAMP AVE\nNO MERRICK\nRHODE AVE\nMAEDER AVE\nKNEE PAIN\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:11:06:00",
        "ADDR:1815 CAMP AVE",
        "CITY:NO MERRICK",
        "X:RHODE AVE & MAEDER AVE",
        "INFO:KNEE PAIN",
        "PHONE:1-516-324-2379");

    doTest("T2",
        "(*) RESCUE\n11:26 AM\n1409 BELLMORE AVE\nNO BELLMORE\nWALLEN LA\nWARING ST\nSICK FEMALE\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:11:26:00",
        "ADDR:1409 BELLMORE AVE",
        "CITY:NO BELLMORE",
        "X:WALLEN LA & WARING ST",
        "INFO:SICK FEMALE",
        "PHONE:1-516-324-2379");

    doTest("T3",
        "(*) RESCUE\n3:29 PM\n404 LINDEN ST\nBELLMORE\nTHE CREEK\nNEWBRIDGE ROAD\n91/M STROKE\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:15:29:00",
        "ADDR:404 LINDEN ST",
        "CITY:BELLMORE",
        "X:THE CREEK & NEWBRIDGE ROAD",
        "INFO:91/M STROKE",
        "PHONE:1-516-324-2379");

    doTest("T4",
        "(*) RESCUE\n12:25 AM\n2199 BENEFIT ST\nNO MERRICK\nHENDRICKSON AVE\nSTEVENS AVE\nCATHETER PROBLEM\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:00:25:00",
        "ADDR:2199 BENEFIT ST",
        "CITY:NO MERRICK",
        "X:HENDRICKSON AVE & STEVENS AVE",
        "INFO:CATHETER PROBLEM",
        "PHONE:1-516-324-2379");

    doTest("T5",
        "(*) MULTIPL\n1:04 AM\n246 PARK AVE\nNO MERRICK\nBIRCH ST\nHOWES ST\n\n1-516-324-2379   support@2sig.com",
        "CALL:MULTIPL",
        "TIME:01:04:00",
        "ADDR:246 PARK AVE",
        "CITY:NO MERRICK",
        "X:BIRCH ST & HOWES ST",
        "PHONE:1-516-324-2379");

    doTest("T6",
        "(*) RESCUE\n6:41 AM\n2496 RAMONA ST\nEAST MEADOW\nNEWBRIDGE ROAD\nMIDVALE AVE\nBACK PAIN\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:06:41:00",
        "ADDR:2496 RAMONA ST",
        "CITY:EAST MEADOW",
        "X:NEWBRIDGE ROAD & MIDVALE AVE",
        "INFO:BACK PAIN",
        "PHONE:1-516-324-2379");

    doTest("T7",
        "(*) RESCUE\n7:59 PM\n2909 BEACH DR\nMERRICK\nANN ROAD\nALEXIS ROAD\nSICK MALE\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:19:59:00",
        "ADDR:2909 BEACH DR",
        "CITY:MERRICK",
        "X:ANN ROAD & ALEXIS ROAD",
        "INFO:SICK MALE",
        "PHONE:1-516-324-2379");

    doTest("T8",
        "(*) MUTUAID\n" +
        "8:40 PM\n" +
        "320 MERRICK ROAD W\n" +
        "FREEPORT\n" +
        "WASHINGTON ST\n" +
        "BAYVIEW (S) AVE\n" +
        "RM228A/UNRESPONSIVE FEMALE\n" +
        "1-516-324-2379   support@2sig.com",

        "CALL:MUTUAID",
        "TIME:20:40:00",
        "ADDR:320 MERRICK ROAD W",
        "CITY:FREEPORT",
        "X:WASHINGTON ST & BAYVIEW (S) AVE",
        "INFO:RM228A/UNRESPONSIVE FEMALE",
        "PHONE:1-516-324-2379");

    doTest("T9",
        "(*) RESCUE\n2:04 AM\n2561 NATTA BLVD\nBELLMORE\nMARTIN PL\nHERBERT CT\nCATHETER PROBLEM\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:02:04:00",
        "ADDR:2561 NATTA BLVD",
        "CITY:BELLMORE",
        "X:MARTIN PL & HERBERT CT",
        "INFO:CATHETER PROBLEM",
        "PHONE:1-516-324-2379");

    doTest("T10",
        "(*) RESCUE\n3:45 PM\n2060 FREEMAN AVE\nBELLMORE\nWOODBINE AVE\nSWENSON PL\nSICK FEMALE\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:15:45:00",
        "ADDR:2060 FREEMAN AVE",
        "CITY:BELLMORE",
        "X:WOODBINE AVE & SWENSON PL",
        "INFO:SICK FEMALE",
        "PHONE:1-516-324-2379");

    doTest("T11",
        "(*) RESCUE\n8:34 AM\n1051 ADRIENNE DR\nNO BELLMORE\nOLD BRITTON ROAD\nMELISSA LA\nELD MALE CANT WALK\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:08:34:00",
        "ADDR:1051 ADRIENNE DR",
        "CITY:NO BELLMORE",
        "X:OLD BRITTON ROAD & MELISSA LA",
        "INFO:ELD MALE CANT WALK",
        "PHONE:1-516-324-2379");

    doTest("T12",
        "(*) RESCUE\n5:29 AM\n1217 RAYMOND ROAD\nNO BELLMORE\nJERUSALEM AVE\nSAWMILL ROAD\nSICK FEM\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:05:29:00",
        "ADDR:1217 RAYMOND ROAD",
        "CITY:NO BELLMORE",
        "X:JERUSALEM AVE & SAWMILL ROAD",
        "INFO:SICK FEM",
        "PHONE:1-516-324-2379");

    doTest("T13",
        "(*) RESCUE\n" +
        "12:06 PM\n" +
        "128 HEWLETT AVE N\n" +
        "MERRICK\n" +
        "SMITH ST\n" +
        "LOINES AVE\n" +
        "DR GOLDSTEINS OFFICE-CHEST PAIN\n" +
        "1-516-324-2379   support@2sig.com",

        "CALL:RESCUE",
        "TIME:12:06:00",
        "ADDR:128 HEWLETT AVE N",
        "CITY:MERRICK",
        "X:SMITH ST & LOINES AVE",
        "INFO:DR GOLDSTEINS OFFICE-CHEST PAIN",
        "PHONE:1-516-324-2379");

    doTest("T14",
        "(*) AUTOACC\n11:53 PM\nMERRICK ROAD\nMERRICK\n\n\n\n1-516-324-2379   support@2sig.com",
        "CALL:AUTOACC",
        "TIME:23:53:00",
        "ADDR:MERRICK ROAD",
        "CITY:MERRICK",
        "PHONE:1-516-324-2379");

    doTest("T15",
        "(*) RESCUE\n" +
        "3:14 AM\n" +
        "632 MIDVALE AVE\n" +
        "EAST MEADOW\n" +
        "TONQUIN ST\n" +
        "NORTH JERUSALEM ROAD\n" +
        "55F DIZZY/TINGLING IN LEGS\n" +
        "1-516-324-2379   support@2sig.com",

        "CALL:RESCUE",
        "TIME:03:14:00",
        "ADDR:632 MIDVALE AVE",
        "CITY:EAST MEADOW",
        "X:TONQUIN ST & NORTH JERUSALEM ROAD",
        "INFO:55F DIZZY/TINGLING IN LEGS",
        "PHONE:1-516-324-2379");

    doTest("T16",
        "(*) RESCUE\n" +
        "12:09 PM\n" +
        "2189 CUSTOM VILLAGE CT\n" +
        "NO BELLMORE\n" +
        "NEWBRIDGE ROAD\n" +
        "-DEAD END-\n" +
        "FEMALE PASSED OUT\n" +
        "1-516-324-2379   support@2sig.com",

        "CALL:RESCUE",
        "TIME:12:09:00",
        "ADDR:2189 CUSTOM VILLAGE CT",
        "CITY:NO BELLMORE",
        "X:NEWBRIDGE ROAD & -DEAD END-",
        "INFO:FEMALE PASSED OUT",
        "PHONE:1-516-324-2379");

    doTest("T17",
        "(*) RESCUE\n7:56 AM\n2941 HOLIDAY PARK DR\nMERRICK\nALEXIS ROAD\nCLUBHOUSE ROAD\nSICK MALE\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:07:56:00",
        "ADDR:2941 HOLIDAY PARK DR",
        "CITY:MERRICK",
        "X:ALEXIS ROAD & CLUBHOUSE ROAD",
        "INFO:SICK MALE",
        "PHONE:1-516-324-2379");

    doTest("T18",
        "(*) MUTUAID\n1:42 PM\n88 RUTLAND ROAD\nFREEPORT\nPARSONS AVE\nREMSEN AVE\nDIABETIC\n1-516-324-2379   support@2sig.com",
        "CALL:MUTUAID",
        "TIME:13:42:00",
        "ADDR:88 RUTLAND ROAD",
        "CITY:FREEPORT",
        "X:PARSONS AVE & REMSEN AVE",
        "INFO:DIABETIC",
        "PHONE:1-516-324-2379");

    doTest("T19",
        "(*) RESCUE\n6:50 PM\n1563 STEVENS AVE\nNO MERRICK\nGROVE ST\n-DEAD END-\nCHEST PAIN\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:18:50:00",
        "ADDR:1563 STEVENS AVE",
        "CITY:NO MERRICK",
        "X:GROVE ST & -DEAD END-",
        "INFO:CHEST PAIN",
        "PHONE:1-516-324-2379");

    doTest("T20",
        "(*) RESCUE\n12:50 AM\n2426 COTTAGE CT\nBELLMORE\nHEWLETT LA\n-DEAD END-\nSICK FEMALE\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:00:50:00",
        "ADDR:2426 COTTAGE CT",
        "CITY:BELLMORE",
        "X:HEWLETT LA & -DEAD END-",
        "INFO:SICK FEMALE",
        "PHONE:1-516-324-2379");

    doTest("T21",
        "(*) RESCUE\n6:10 AM\n2476 ARMY PL\nBELLMORE\nSHORE ROAD\nLEGION ST\n\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:06:10:00",
        "ADDR:2476 ARMY PL",
        "CITY:BELLMORE",
        "X:SHORE ROAD & LEGION ST",
        "PHONE:1-516-324-2379");

    doTest("T22",
        "(*) RESCUE\n7:07 AM\n1920 CLEMONS ST\nBELLMORE\nNATTA BLVD\n-DEAD END-\nFM BLEEDING\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:07:07:00",
        "ADDR:1920 CLEMONS ST",
        "CITY:BELLMORE",
        "X:NATTA BLVD & -DEAD END-",
        "INFO:FM BLEEDING",
        "PHONE:1-516-324-2379");

    doTest("T23",
        "(*) RESCUE\n1:25 PM\n2988 LONNI LA\nMERRICK\nSTANLEY DR\nGLENN LA\nFEMALE FELL\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:13:25:00",
        "ADDR:2988 LONNI LA",
        "MADDR:2988 LONNI LN",
        "CITY:MERRICK",
        "X:STANLEY DR & GLENN LA",
        "INFO:FEMALE FELL",
        "PHONE:1-516-324-2379");

    doTest("T24",
        "(*) RESCUE\n" +
        "2:50 PM\n" +
        "951 MERRICK AVE\n" +
        "NO MERRICK\n" +
        "NORTH JERUSALEM ROAD\n" +
        "SHIRLEY CT\n" +
        "ASTHMA/DIFF BREATHING\n" +
        "1-516-324-2379   support@2sig.com",

        "CALL:RESCUE",
        "TIME:14:50:00",
        "ADDR:951 MERRICK AVE",
        "CITY:NO MERRICK",
        "X:NORTH JERUSALEM ROAD & SHIRLEY CT",
        "INFO:ASTHMA/DIFF BREATHING",
        "PHONE:1-516-324-2379");

    doTest("T25",
        "(*) RESCUE\n8:01 AM\n968 SIEMS CT\nNO BELLMORE\nNORWOOD AVE\nLOCUST AVE\nARM LACERATION\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:08:01:00",
        "ADDR:968 SIEMS CT",
        "CITY:NO BELLMORE",
        "X:NORWOOD AVE & LOCUST AVE",
        "INFO:ARM LACERATION",
        "PHONE:1-516-324-2379");

    doTest("T26",
        "(*) RESCUE\n8:35 AM\n1802 NEWBRIDGE ROAD\nNO BELLMORE\nCATHERINE PL\nKENNETH AVE\nSICK FM\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:08:35:00",
        "ADDR:1802 NEWBRIDGE ROAD",
        "CITY:NO BELLMORE",
        "X:CATHERINE PL & KENNETH AVE",
        "INFO:SICK FM",
        "PHONE:1-516-324-2379");

    doTest("T27",
        "(*) RESCUE\n12:18 PM\n2336 NEWBRIDGE ROAD\nBELLMORE\nSUNRISE HWY\nORANGE ST -\nOVERDOSE\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:12:18:00",
        "ADDR:2336 NEWBRIDGE ROAD",
        "CITY:BELLMORE",
        "X:SUNRISE HWY & ORANGE ST -",
        "INFO:OVERDOSE",
        "PHONE:1-516-324-2379");

    doTest("T28",
        "(*) MUTUAID\n4:12 PM\nGRAND AVE\nFREEPORT\n\n\nMALE PASSED OUT AGAINST FENCE\n1-516-324-2379   support@2sig.com",
        "CALL:MUTUAID",
        "TIME:16:12:00",
        "ADDR:GRAND AVE",
        "CITY:FREEPORT",
        "INFO:MALE PASSED OUT AGAINST FENCE",
        "PHONE:1-516-324-2379");

    doTest("T29",
        "(*) RESCUE\n12:45 PM\n2760 BELTAGH AVE\nBELLMORE\nBELLMORE AVE\nBRIGGS ST -\n76 Y/O MALE PASSING OUT\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:12:45:00",
        "ADDR:2760 BELTAGH AVE",
        "CITY:BELLMORE",
        "X:BELLMORE AVE & BRIGGS ST -",
        "INFO:76 Y/O MALE PASSING OUT",
        "PHONE:1-516-324-2379");

    doTest("T30",
        "(*) MUTUAID\n4:29 AM\n295 MAIN ST S\nFREEPORT\nFRANKLIN SQ\nARCHER ST -\nMAIN OFFICE-MALE BLEEDING\n1-516-324-2379   support@2sig.com",
        "CALL:MUTUAID",
        "TIME:04:29:00",
        "ADDR:295 MAIN ST S",
        "CITY:FREEPORT",
        "X:FRANKLIN SQ & ARCHER ST -",
        "INFO:MAIN OFFICE-MALE BLEEDING",
        "PHONE:1-516-324-2379");

    doTest("T31",
        "(*) AUTOACC\n10:54 AM\nSUNRISE HWY\nBELLMORE\n\n\nIFO PC RICHARD\n1-516-324-2379   support@2sig.com",
        "CALL:AUTOACC",
        "TIME:10:54:00",
        "ADDR:SUNRISE HWY",
        "CITY:BELLMORE",
        "INFO:IFO PC RICHARD",
        "PHONE:1-516-324-2379");

    doTest("T32",
        "(*) RESCUE\n11:48 AM\n2120 SKIPPER CT\nBELLMORE\nSWENSON PL\n-DEAD END-\nMALE PNEMONIA\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:11:48:00",
        "ADDR:2120 SKIPPER CT",
        "CITY:BELLMORE",
        "X:SWENSON PL & -DEAD END-",
        "INFO:MALE PNEMONIA",
        "PHONE:1-516-324-2379");

    doTest("T33",
        "(*) RESCUE\n4:40 PM\n1563 STEVENS AVE\nNO MERRICK\nGROVE ST\n-DEAD END-\nFM WEAK\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:16:40:00",
        "ADDR:1563 STEVENS AVE",
        "CITY:NO MERRICK",
        "X:GROVE ST & -DEAD END-",
        "INFO:FM WEAK",
        "PHONE:1-516-324-2379");

    doTest("T34",
        "(*) RESCUE\n3:34 AM\n801 NEWBRIDGE ROAD\nNO BELLMORE\nBELMOND AVE\nCOLUMBUS AVE\nUNRESP FEMALE\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:03:34:00",
        "ADDR:801 NEWBRIDGE ROAD",
        "CITY:NO BELLMORE",
        "X:BELMOND AVE & COLUMBUS AVE",
        "INFO:UNRESP FEMALE",
        "PHONE:1-516-324-2379");

    doTest("T35",
        "(*) RESCUE\n11:24 AM\n1479 TADMOR ST\nNO MERRICK\nJERUSALEM AVE\nORION CT\nPREGNANT FM SEVERE CRAMPS\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:11:24:00",
        "ADDR:1479 TADMOR ST",
        "CITY:NO MERRICK",
        "X:JERUSALEM AVE & ORION CT",
        "INFO:PREGNANT FM SEVERE CRAMPS",
        "PHONE:1-516-324-2379");

    doTest("T36",
        "(*) RESCUE\n" +
        "10:30 PM\n" +
        "2625 JERUSALEM AVE\n" +
        "NO BELLMORE\n" +
        "EILEEN CT\n" +
        "BELLMORE ROAD\n" +
        "21 Y/O FEMALE-MENTAL AIDED\n" +
        "1-516-324-2379   support@2sig.com",

        "CALL:RESCUE",
        "TIME:22:30:00",
        "ADDR:2625 JERUSALEM AVE",
        "CITY:NO BELLMORE",
        "X:EILEEN CT & BELLMORE ROAD",
        "INFO:21 Y/O FEMALE-MENTAL AIDED",
        "PHONE:1-516-324-2379");

    doTest("T37",
        "(*) MUTUAID\n2:44 AM\n148 PINE ST\nFREEPORT\nBERGEN (S) PL\nLONG BEACH (S) AVE\nSTOMACH PAINS-C9\n1-516-324-2379   support@2sig.com",
        "CALL:MUTUAID",
        "TIME:02:44:00",
        "ADDR:148 PINE ST",
        "CITY:FREEPORT",
        "X:BERGEN (S) PL & LONG BEACH (S) AVE",
        "INFO:STOMACH PAINS-C9",
        "PHONE:1-516-324-2379");

    doTest("T38",
        "(*) 01  TRAN\n5:06 PM\n2162 REDMOND ROAD\nNO MERRICK\nWHITTIER AVE\nTAFT AVE\nF/FELL\n1-516-324-2379   support@2sig.com",
        "CALL:01  TRAN",
        "TIME:17:06:00",
        "ADDR:2162 REDMOND ROAD",
        "CITY:NO MERRICK",
        "X:WHITTIER AVE & TAFT AVE",
        "INFO:F/FELL",
        "PHONE:1-516-324-2379");

    doTest("T39",
        "(*) MUTUAID\n5:53 PM\n58 SHONNARD AVE\nFREEPORT\nCOMMERCIAL ST\nPARSONS AVE\n\n1-516-324-2379   support@2sig.com",
        "CALL:MUTUAID",
        "TIME:17:53:00",
        "ADDR:58 SHONNARD AVE",
        "CITY:FREEPORT",
        "X:COMMERCIAL ST & PARSONS AVE",
        "PHONE:1-516-324-2379");

    doTest("T40",
        "(*) MULTIPL\n5:58 PM\n1802 NEWBRIDGE ROAD\nNO BELLMORE\nCATHERINE PL\nKENNETH AVE\nSTOMACH PAINS\n1-516-324-2379   support@2sig.com",
        "CALL:MULTIPL",
        "TIME:17:58:00",
        "ADDR:1802 NEWBRIDGE ROAD",
        "CITY:NO BELLMORE",
        "X:CATHERINE PL & KENNETH AVE",
        "INFO:STOMACH PAINS",
        "PHONE:1-516-324-2379");

    doTest("T41",
        "(*) RESCUE\n7:42 PM\n1667 CENTRAL AVE\nNO MERRICK\n3RD AVE\n2ND AVE\nSICK FEMALE\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:19:42:00",
        "ADDR:1667 CENTRAL AVE",
        "CITY:NO MERRICK",
        "X:3RD AVE & 2ND AVE",
        "INFO:SICK FEMALE",
        "PHONE:1-516-324-2379");

    doTest("T42",
        "(*) RESCUE\n2:45 PM\n19 JUNIPER AVE\nMERRICK\nALFRED (W) ROAD\nALFRED (E) ROAD\nWEAK FEMALE\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:14:45:00",
        "ADDR:19 JUNIPER AVE",
        "CITY:MERRICK",
        "X:ALFRED (W) ROAD & ALFRED (E) ROAD",
        "INFO:WEAK FEMALE",
        "PHONE:1-516-324-2379");

    doTest("T43",
        "(*) RESCUE\n10:08 AM\n1667 CENTRAL AVE\nNO MERRICK\n3RD AVE\n2ND AVE\nSEIZURES\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:10:08:00",
        "ADDR:1667 CENTRAL AVE",
        "CITY:NO MERRICK",
        "X:3RD AVE & 2ND AVE",
        "INFO:SEIZURES",
        "PHONE:1-516-324-2379");

    doTest("T44",
        "(*) MULTIPL\n10:36 AM\n1150 LITTLE WHALENECK ROAD\nNO MERRICK\nWILSON AVE\nSUFFOLK DR\nDIFF BREATHING\n1-516-324-2379   support@2sig.com",
        "CALL:MULTIPL",
        "TIME:10:36:00",
        "ADDR:1150 LITTLE WHALENECK ROAD",
        "CITY:NO MERRICK",
        "X:WILSON AVE & SUFFOLK DR",
        "INFO:DIFF BREATHING",
        "PHONE:1-516-324-2379");

    doTest("T45",
        "(*) RESCUE\n10:05 AM\n2065 FREEMAN AVE\nBELLMORE\nWOODBINE AVE\nSWENSON PL\nSICK FEMALE\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:10:05:00",
        "ADDR:2065 FREEMAN AVE",
        "CITY:BELLMORE",
        "X:WOODBINE AVE & SWENSON PL",
        "INFO:SICK FEMALE",
        "PHONE:1-516-324-2379");

    doTest("T46",
        "(*) RESCUE\n11:37 PM\n165 STUYVESANT AVE\nMERRICK\nMADISON ST\nBABYLON TPK\nBACK PAIN\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:23:37:00",
        "ADDR:165 STUYVESANT AVE",
        "CITY:MERRICK",
        "X:MADISON ST & BABYLON TPK",
        "INFO:BACK PAIN",
        "PHONE:1-516-324-2379");

    doTest("T47",
        "(*) RESCUE\n" +
        "9:35 AM\n" +
        "1802 NEWBRIDGE ROAD\n" +
        "NO BELLMORE\n" +
        "CATHERINE PL\n" +
        "KENNETH AVE\n" +
        "CHEST PAINS/SICK FEMALE\n" +
        "1-516-324-2379   support@2sig.com",

        "CALL:RESCUE",
        "TIME:09:35:00",
        "ADDR:1802 NEWBRIDGE ROAD",
        "CITY:NO BELLMORE",
        "X:CATHERINE PL & KENNETH AVE",
        "INFO:CHEST PAINS/SICK FEMALE",
        "PHONE:1-516-324-2379");

    doTest("T48",
        "(*) RESCUE\n12:13 PM\n2065 FREEMAN AVE\nBELLMORE\nWOODBINE AVE\nSWENSON PL\nSICK FEMALE\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:12:13:00",
        "ADDR:2065 FREEMAN AVE",
        "CITY:BELLMORE",
        "X:WOODBINE AVE & SWENSON PL",
        "INFO:SICK FEMALE",
        "PHONE:1-516-324-2379");

    doTest("T49",
        "(*) RESCUE\n3:20 PM\n2809 SCHOOL ST\nBELLMORE\nBELLMORE AVE\nST MARKS (S) AVE\nUNABLE TO URINATE\n1-516-324-2379   support@2sig.com",
        "CALL:RESCUE",
        "TIME:15:20:00",
        "ADDR:2809 SCHOOL ST",
        "CITY:BELLMORE",
        "X:BELLMORE AVE & ST MARKS (S) AVE",
        "INFO:UNABLE TO URINATE",
        "PHONE:1-516-324-2379");

    doTest("T50",
        "(*) RESCUE\n9:28 PM\n2908 CHERYL ROAD\nMERRICK\nWYNSUM AVE\nJUDITH DR\nUNRESP FEMALE\n1-516-324-2379   support@2sig.com\n\n",
        "CALL:RESCUE",
        "TIME:21:28:00",
        "ADDR:2908 CHERYL ROAD",
        "CITY:MERRICK",
        "X:WYNSUM AVE & JUDITH DR",
        "INFO:UNRESP FEMALE",
        "PHONE:1-516-324-2379");
   
  }
  
  public static void main(String[] args) {
    new NYNassauCountyFParserTest().generateTests("T1");
  }
}