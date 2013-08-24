package net.anei.cadpage.parsers.NH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Hanover, NH (in Grafton County)
Contact: "Daniel A. Perry (Student)" <DAP634@students.jwu.edu>
Contact: Zachary Lang <zacharymichaellang@gmail.com>,8024613731@vtext.com
Sender: DISPATCH@HANOVER.PD

(_) MEDU 72 Y M FALLEN\nHUNTINGTON APARTMENTS\n493 S MAIN ST \nBRADFORD\n2/9/2012 18:54
(_) FD- STILL MV FIRE\nMAIN ST \nBRADFORD\n12/4/2011 19:19
(_) ACCIDENT (WITH INJURY)\nON RAMP\nI-91 S\nBRADFORD\n12/5/2011 06:40
(_) AMBULANCE ASSIST\n33 S MAIN ST APT 4\nBRADFORD\n11/25/2011 23:53
(_) FDS CO DETECTOR ACTIVATION\n5003 SOUTH RD\nBRADFORD\n10/30/2011 19:24
(_) FDS FUEL SPILL\n286 WAITS RIVER RD\nBRADFORD\n10/24/2011 09:05
(_) FIRE CALL - FIRE ALARM\n378 N MAIN ST\nBRADFORD\n10/22/2011 16:09
(_) FDS POWER LINES DOWN\n1025 GOSHEN RD\nBRADFORD\n10/15/2011 16:26
(_) FIRE CALL - FIRE ALARM\n378 N MAIN ST\nBRADFORD\n10/13/2011 21:18
[_]  MEDU - DIFF BREATHING\nOXBOW HIGH SCHOOL\n36 OXBOW DR\nBRADFORD\n1/30/2012 09:59
[_]  MEDU\nVALLEY VISTA\n23 UPPER PLAIN\nBRADFORD\n1/30/2012 13:19
[_]  MEDU- 57 YO M DIFF BREATHING\n101 ERWIN RD\nBRADFORD\n1/30/2012 20:48
[_]  FD- STILL\n1176 FAIRGROUND RD\nBRADFORD\n2/2/2012 11:01
[_]  MEDU 80 YO MALE FEELING ILL\n613 UPPER PLAIN\nBRADFORD\n2/2/2012 18:37
[_]  MEDU 30 Y M MENTAL HEALTH PROB\n245 S MAIN ST APT 5\nBRADFORD\n2/2/2012 21:44
[_]  MEDU 56 Y M FALLEN BACK INJ\nCLEAR MEADOW LN\nBRADFORD\n2/3/2012 14:47
[_]  MEDU\nBRADFORD MINI MART\n530 WAIT'S RIVER RD\nBRADFORD\n2/4/2012 19:33
[_]  MEDU76 F LETHARGIC CHEST PAIN\n1022 LOWER PLAIN\nBRADFORD\n2/5/2012 09:25
[_]  MEDU - 87 F LOW O2 LEVELS\nGILBERT RESD - FARMERS EXCHG BLDG\n245 S MAIN ST APT 2\nBRADFORD\n2/6/2012 16:53
(_)  MEDU 72 Y M FALLEN\nHUNTINGTON APARTMENTS\n493 S MAIN ST\nBRADFORD\n2/9/2012 18:54
(_) FD- STILL-SMOKE INVEST\nS PLEASANT ST\nBRADFORD\nFire District: F20\n6/15/2012 13:43
(_) MUTUAL AID FIRE/AMB CALL\nHAVERHILL CORNER STATION\nHAVERHILL\nWITH ENGINE AND TANKER FOR COVERAGE\n6/10/2012 17:05

Contact: Active911
Agency name: Hollis Fire Department
Location: Hollis, NH, United States
Sender: "HDISPATCH@HOLLISNH.ORG" <hdispatch@hollisnh.org>

(HCC) MEDICAL SERVICE CALL\nLEBLANC, LEON AND JREIGE LEBLANC, NADIA\n102 LONG HILL RD \nHollis\nDistrict: 005\n3/23/2013 12:42\n\n\n
(HCC) FIRE / ALARM\nRYDSTROM, LORIN AND NANCI\n124 DOW RD \nHollis\nUnder control\n\n\n
(HCC) FIRE / ALARM\nRYDSTROM, LORIN AND NANCI\n124 DOW RD \nHollis\nDistrict: 001\n3/23/2013 07:05\n\n\n
(HCC) M V A UNKNOWN INJURY\n305 ROUTE 13 AND 196 OLD MILFORD RD \nBrookline\nDistrict: 505\n3/22/2013 23:24\n\n\n
(HCC) MEDICAL EMERGENCY\nDUNN, RUTH\n8 RAIL WAY \nHollis\nDistrict: 004\n3/22/2013 01:16\n\n\n
(HCC) M V A UNKNOWN INJURY\nOROURKE, MICHAEL\n151 FARLEY RD \nHollis\nDistrict: 030\n3/20/2013 09:55\n\n\n
(HCC) M V A UNKNOWN INJURY\nCOOK, PETER AND JUDY\n10 MAIN ST \nBrookline\nDistrict: 501\n3/19/2013 15:38\n\n\n
(HCC) M V A UNKNOWN INJURY\nGLOVER, MARGARET ( HONI )\n52 NEVINS RD \nHollis\nHFD under control at this time\n\n\n
(HCC) M V A UNKNOWN INJURY\nGLOVER, MARGARET ( HONI )\n52 NEVINS RD \nHollis\nDistrict: 042\n3/19/2013 12:23\n\n\n
(HCC) MEDICAL EMERGENCY\nGARRITY, JOHN AND RACHEL\n189 WHEELER RD \nHollis\nDistrict: 035\n3/19/2013 12:08\n\n\n
(HCC) MEDICAL EMERGENCY\nBURTT, JEFFREY AND LISA\n35 N PEPPERELL RD \nHollis\nDistrict: 012\n3/18/2013 21:54\n\n\n
(HCC) MEDICAL MUTUAL AID\nNH AVE, NASHUA\nHollis\nDistrict: OUT\n3/18/2013 17:09\n\n\n
(HCC) MEDICAL SERVICE CALL\nWARREN, MARIAN\n5 N PEPPERELL RD \nHollis\nDistrict: 012\n3/18/2013 12:00\n\n\n
(HCC) MEDICAL EMERGENCY\nGEDDES, DAVID AND MABLE\n318 S MERRIMACK RD \nHollis\nDistrict: 045\n3/17/2013 19:40\n\n\n
(HCC) MEDICAL EMERGENCY\nTOWN HALL\n7 MONUMENT SQ \nHollis\nDistrict: 007\n3/17/2013 14:59\n\n\n
(HCC) M V A UNKNOWN INJURY\n165 FARLEY RD AND 1 SWALLOW DR \nHollis / UNDER CONTROL, NO TX.\n\n
(HCC) M V A UNKNOWN INJURY\n165 FARLEY RD AND 1 SWALLOW DR \nHollis\nDistrict: 030\n3/16/2013 19:23\n\n\n
(HCC) MEDICAL EMERGENCY\nBRUSON, RICHARD AND KAREN\n48 LONG HILL RD \nHollis\nunder control \n3/16/2013 06:54\n\n\n
(HCC) MEDICAL EMERGENCY\nBRUSON, RICHARD AND KAREN\n48 LONG HILL RD \nHollis\nDistrict: 005\n3/16/2013 06:54\n\n\n
(HCC) MEDICAL EMERGENCY\nOVERLOOK COUNTRY CLUB\n5 OVERLOOK DR \nHollis\nDistrict: 003\n3/16/2013 01:38\n\n\n

Contact: Active911
Agency name: Hollis Fire Department
Location: Hollis, NH, United States
Sender: hdispatch@hollisnh.org

(HCC) MEDICAL EMERGENCY\nFERNALD, ROSEL & PORTER, BARBARA\n198 FARLEY RD \nHollis\nDistrict: 042\n3/28/2013 14:44
(HCC) MEDICAL EMERGENCY\nHELLMER, ROLAND AND ANGELIKA\n16 TODDY BROOK RD \nHollis\nDistrict: 038\n3/27/2013 12:57
(HCC) MEDICAL EMERGENCY\nREDES, PETER AND SHARON\n77 WHEELER RD \nHollis\nUnder control sufficient help\n3/27/2013 03:29
(HCC) MEDICAL EMERGENCY\nREDES, PETER AND SHARON\n77 WHEELER RD \nHollis\nDistrict: 035\n3/27/2013 03:29
(HCC) FIRE / ALARM\nCUNNINGHAM, JOHN AND JANE  ( TENANTS )\n25 MEADOW DR \nHollis\nDistrict: 043\n3/27/2013 00:04
(HCC) MEDICAL EMERGENCY\nGALLANT, FAYONE  ( TENANT )\n6 MARKET PL APT 1 B\nHollis\n13A1 UNDER CONTROL
(HCC) MEDICAL EMERGENCY\nGALLANT, FAYONE  ( TENANT )\n6 MARKET PL APT 1 B\nHollis\nDistrict: 008\n3/26/2013 14:34
(HCC) MEDICAL EMERGENCY\nLAGANAS, PENI\n176 FARLEY RD \nHollis\nUnder control sufficient help on the scene\nLIFT ASSIST
(HCC) MEDICAL EMERGENCY\nLAGANAS, PENI\n176 FARLEY RD \nHollis\nDistrict: 030\n3/26/2013 11:37
(HCC) MEDICAL LIFT ASSIST\nCOLE, HOWARD AND JOAN\n54 WHEELER RD \nHollis\n13A1 under control\n3/25/2013 22:35
(HCC) MEDICAL LIFT ASSIST\nCOLE, HOWARD AND JOAN\n54 WHEELER RD \nHollis\nDistrict: 035\n3/25/2013 22:35
(HCC) MEDICAL EMERGENCY\nBOSOWSKI, JOSEPH AND FRANCESCA\n71 IRENE DR \nHollis\nDistrict: 011\n3/24/2013 16:59\nCommand placing the call under control
(HCC) MEDICAL EMERGENCY\nBOSOWSKI, JOSEPH AND FRANCESCA\n71 IRENE DR \nHollis\nDistrict: 011\n3/24/2013 16:59
(HCC) M V A WITH INJURY\nTESTA, JOHN\n118 WHEELER RD \nHollis\nplacing call under control\n3/24/2013 04:11
(HCC) M V A WITH INJURY\nTESTA, JOHN\n118 WHEELER RD \nHollis\nDistrict: 035\n3/24/2013 04:11
(HCC) MEDICAL SERVICE CALL\nLEBLANC, LEON AND JREIGE LEBLANC, NADIA\n102 LONG HILL RD \nHollis\nDistrict: 005\n3/23/2013 12:42
(HCC) FIRE / ALARM\nRYDSTROM, LORIN AND NANCI\n124 DOW RD \nHollis\nUnder control
(HCC) FIRE / ALARM\nRYDSTROM, LORIN AND NANCI\n124 DOW RD \nHollis\nDistrict: 001\n3/23/2013 07:05
(HCC) M V A UNKNOWN INJURY\n305 ROUTE 13 AND 196 OLD MILFORD RD \nBrookline\nDistrict: 505\n3/22/2013 23:24
(HCC) MEDICAL EMERGENCY\nDUNN, RUTH\n8 RAIL WAY \nHollis\nDistrict: 004\n3/22/2013 01:16

Agency name: Amherst Fire Department
Location: Amherst, NH, United States
Contact: Active911

(Amherst Fire) ACCIDENT W/ INJURY\nWALTS SHELL\n148 AMHERST ST \nAMHERST\nDistrict: DIST2\n03/29/2013 11:44
(Amherst Fire) ACCIDENT W/ INJURY\n98 SPRING RD AND 2 SAWMILL LN \nAMHERST\nDistrict: DIST4\n03/29/2013 11:39
(Amherst Fire) ACCIDENT W/ INJURY\n179 HOLLIS RD \nAMHERST\nDistrict: DIST6\n03/27/2013 12:58
(Amherst Fire) FIRE, CHIMNEY\nGAGNON, SCOTT\n18 MIDDLE ST \nAMHERST\nDistrict: DIST2\n3/27/2013 10:47
(Amherst Fire) ACCIDENT W/ INJURY\n344 BOSTON POST RD AND 13 CRICKET CORNER RD \nAMHERST\nDistrict: DIST4\n03/26/2013 17:20
(Amherst Fire) FIRE, MUTUAL AID\n42 COURTLAND DR \nBEDFORD\nDistrict: DIST2\n03/18/2013 21:24

Contact: Active911
Agency name: Norwich Fire Department
Location: Norwich, NH, United States
Sender: hanoverpaging@hanovernh.org

(_) FD- STILL-WIRES DOWN\n287 BLOOD HILL RD EAST \nNORWICH\nDistrict: N2\n6/24/2013 17:09
(_) 82 Y F SOB, HX CHF\nFALZARINO, BARBARA\n625 RT 5 N \nNORWICH\nDistrict: N1\n6/22/2013 23:21
(_) 82 Y F SOB, HX CHF\nFALZARINO, BARBARA\n625 RT 5 N \nNORWICH\nDistrict: N1\n6/22/2013 23:21
(_) 82 Y F SOB, HX CHF\nFALZARINO, BARBARA\n625 RT 5 N \nNORWICH\nDistrict: N1\n6/22/2013 23:21
(_) 82 Y F SOB, HX CHF\nFALZARINO, BARBARA\n625 RT 5 N \nNORWICH\nDistrict: N1\n6/22/2013 23:21
(_) MEDU-ELD F FELL, RIB PAIN\nCROWE, GLORIA\n96 UPPER TURNPIKE RD \nNORWICH\nDistrict: N2\n6/17/2013 18:31
(_) MEDU - MEDICAL ALARM\nCROWE, GLORIA\n96 UPPER TURNPIKE RD \nNORWICH\nDistrict: N2\n6/17/2013 01:43
(_) FD- STILL- CO DET ACTIVATION\n117 DOUGLAS RD \nNORWICH\nDistrict: N2\n6/16/2013 09:54
(_) 93 Y F MEDICAL ALARM\nNORWICH SENIOR HOUSING BUILDING 28\n28 DORRANCE DR APT 18\nNORWICH\nDistrict: N1\n6/15/2013 19:10
(_) FIRE CALL - FIRE ALARM\nREICHBERT, BETH\n180 BIRCH HILL LN \nNORWICH\nDistrict: N2\n6/14/2013 13:10
(_) MEDU 88 F FALLEN\nDZIELAK, HILDA\n54 CARPENTER ST \nNORWICH\nDistrict: N1\n6/14/2013 07:00
(_) MEDU 75 F BLOOD IN URINE\n70 CAMPBELL FLAT RD \nNORWICH\nDistrict: N3\n6/13/2013 09:16
(_) HANOVER PLAYING... PLS RESPOND\nTRACY HALL\n300 MAIN ST \nNORWICH\nDistrict: N1\n6/12/2013 14:03
(_) FD- STILL TEST PAGE\nNORWICH FIRE STATION\n11 FIREHOUSE LN \nNORWICH\nDistrict: N1\n6/12/2013 11:08
(_) MED - ASSIST UP STAIRS\nGROTH\n217 TOWN FARM RD \nNORWICH\nDistrict: N2\n6/11/2013 12:39
(_) FD- STILL- TREE ON LINES\n1035 RT 5 N AND 125 FARRELL FARM RD \nNORWICH\nDistrict: N2\n6/8/2013 07:48
(_) MEDU ABDOMINAL PAIN\nNORWICH SENIOR HOUSING BUILDING 4\n4 DORRANCE DR APT 5\nNORWICH\nDistrict: N1\n6/7/2013 05:22
(_) MEDU POSS HEART ATTACK\nI-91 \nNORWICH\nDistrict: N9\n6/6/2013 11:57
(_) MEDU PERSON IN SHOCK\nPATCHINS POINT\nRT 5 \nNORWICH\nDistrict: N1\n6/5/2013 18:16
(_) MEDU-MALE PASSED OUT\nDAN AND WHIT'S STORE\n319 MAIN ST \nNORWICH\nDistrict: N1\n6/3/2013 14:34
(_) MEDU- 90M, GROIN AND BACK PAIN\nGROTH\n217 TOWN FARM RD \nNORWICH\nDistrict: N2\n6/3/2013 09:27
(_) FD- STILL- TREES/WIRES DOWN\n214 KENDALL STATION RD \nNORWICH\nDistrict: N3\n6/2/2013 17:38

*/

public class NHHanoverParserTest extends BaseParserTest {
  
  public NHHanoverParserTest() {
    setParser(new NHHanoverParser(), "HANOVER", "NH");
  }
  
  @Test
  public void testParserVT() {
    
    setDefaults("HANOVER", "VT");

    doTest("T1",
        "(_) MEDU 72 Y M FALLEN\nHUNTINGTON APARTMENTS\n493 S MAIN ST \nBRADFORD\n2/9/2012 18:54",
        "CALL:MEDU 72 Y M FALLEN",
        "PLACE:HUNTINGTON APARTMENTS",
        "ADDR:493 S MAIN ST",
        "CITY:BRADFORD",
        "DATE:2/9/2012",
        "TIME:18:54");

    doTest("T2",
        "(_) FD- STILL MV FIRE\nMAIN ST \nBRADFORD\n12/4/2011 19:19",
        "CALL:FD- STILL MV FIRE",
        "ADDR:MAIN ST",
        "CITY:BRADFORD",
        "DATE:12/4/2011",
        "TIME:19:19");

    doTest("T3",
        "(_) ACCIDENT (WITH INJURY)\nON RAMP\nI-91 S\nBRADFORD\n12/5/2011 06:40",
        "CALL:ACCIDENT (WITH INJURY)",
        "PLACE:ON RAMP",
        "ADDR:I-91 S",
        "MADDR:I 91 S",
        "CITY:BRADFORD",
        "DATE:12/5/2011",
        "TIME:06:40");

    doTest("T4",
        "(_) AMBULANCE ASSIST\n33 S MAIN ST APT 4\nBRADFORD\n11/25/2011 23:53",
        "CALL:AMBULANCE ASSIST",
        "ADDR:33 S MAIN ST",
        "APT:4",
        "CITY:BRADFORD",
        "DATE:11/25/2011",
        "TIME:23:53");

    doTest("T5",
        "(_) FDS CO DETECTOR ACTIVATION\n5003 SOUTH RD\nBRADFORD\n10/30/2011 19:24",
        "CALL:FDS CO DETECTOR ACTIVATION",
        "ADDR:5003 SOUTH RD",
        "CITY:BRADFORD",
        "DATE:10/30/2011",
        "TIME:19:24");

    doTest("T6",
        "(_) FDS FUEL SPILL\n286 WAITS RIVER RD\nBRADFORD\n10/24/2011 09:05",
        "CALL:FDS FUEL SPILL",
        "ADDR:286 WAITS RIVER RD",
        "CITY:BRADFORD",
        "DATE:10/24/2011",
        "TIME:09:05");

    doTest("T7",
        "(_) FIRE CALL - FIRE ALARM\n378 N MAIN ST\nBRADFORD\n10/22/2011 16:09",
        "CALL:FIRE CALL - FIRE ALARM",
        "ADDR:378 N MAIN ST",
        "CITY:BRADFORD",
        "DATE:10/22/2011",
        "TIME:16:09");

    doTest("T8",
        "(_) FDS POWER LINES DOWN\n1025 GOSHEN RD\nBRADFORD\n10/15/2011 16:26",
        "CALL:FDS POWER LINES DOWN",
        "ADDR:1025 GOSHEN RD",
        "CITY:BRADFORD",
        "DATE:10/15/2011",
        "TIME:16:26");

    doTest("T9",
        "(_) FIRE CALL - FIRE ALARM\n378 N MAIN ST\nBRADFORD\n10/13/2011 21:18",
        "CALL:FIRE CALL - FIRE ALARM",
        "ADDR:378 N MAIN ST",
        "CITY:BRADFORD",
        "DATE:10/13/2011",
        "TIME:21:18");

    doTest("T10",
        "(_) FIRE CALL - FIRE ALARM\n378 N MAIN ST\nBRADFORD\n10/13/2011 21:18",
        "CALL:FIRE CALL - FIRE ALARM",
        "ADDR:378 N MAIN ST",
        "CITY:BRADFORD",
        "DATE:10/13/2011",
        "TIME:21:18");

    doTest("T11",
        "[_]  MEDU - DIFF BREATHING\nOXBOW HIGH SCHOOL\n36 OXBOW DR\nBRADFORD\n1/30/2012 09:59",
        "CALL:MEDU - DIFF BREATHING",
        "PLACE:OXBOW HIGH SCHOOL",
        "ADDR:36 OXBOW DR",
        "CITY:BRADFORD",
        "DATE:1/30/2012",
        "TIME:09:59");

    doTest("T12",
        "[_]  MEDU\nVALLEY VISTA\n23 UPPER PLAIN\nBRADFORD\n1/30/2012 13:19",
        "CALL:MEDU",
        "PLACE:VALLEY VISTA",
        "ADDR:23 UPPER PLAIN",
        "CITY:BRADFORD",
        "DATE:1/30/2012",
        "TIME:13:19");

    doTest("T13",
        "[_]  MEDU- 57 YO M DIFF BREATHING\n101 ERWIN RD\nBRADFORD\n1/30/2012 20:48",
        "CALL:MEDU- 57 YO M DIFF BREATHING",
        "ADDR:101 ERWIN RD",
        "CITY:BRADFORD",
        "DATE:1/30/2012",
        "TIME:20:48");

    doTest("T14",
        "[_]  FD- STILL\n1176 FAIRGROUND RD\nBRADFORD\n2/2/2012 11:01",
        "CALL:FD- STILL",
        "ADDR:1176 FAIRGROUND RD",
        "CITY:BRADFORD",
        "DATE:2/2/2012",
        "TIME:11:01");

    doTest("T15",
        "[_]  MEDU 80 YO MALE FEELING ILL\n613 UPPER PLAIN\nBRADFORD\n2/2/2012 18:37",
        "CALL:MEDU 80 YO MALE FEELING ILL",
        "ADDR:613 UPPER PLAIN",
        "CITY:BRADFORD",
        "DATE:2/2/2012",
        "TIME:18:37");

    doTest("T16",
        "[_]  MEDU 30 Y M MENTAL HEALTH PROB\n245 S MAIN ST APT 5\nBRADFORD\n2/2/2012 21:44",
        "CALL:MEDU 30 Y M MENTAL HEALTH PROB",
        "ADDR:245 S MAIN ST",
        "APT:5",
        "CITY:BRADFORD",
        "DATE:2/2/2012",
        "TIME:21:44");

    doTest("T17",
        "[_]  MEDU 56 Y M FALLEN BACK INJ\nCLEAR MEADOW LN\nBRADFORD\n2/3/2012 14:47",
        "CALL:MEDU 56 Y M FALLEN BACK INJ",
        "ADDR:CLEAR MEADOW LN",
        "CITY:BRADFORD",
        "DATE:2/3/2012",
        "TIME:14:47");

    doTest("T18",
        "[_]  MEDU\nBRADFORD MINI MART\n530 WAIT'S RIVER RD\nBRADFORD\n2/4/2012 19:33",
        "CALL:MEDU",
        "PLACE:BRADFORD MINI MART",
        "ADDR:530 WAIT'S RIVER RD",
        "CITY:BRADFORD",
        "DATE:2/4/2012",
        "TIME:19:33");

    doTest("T19",
        "[_]  MEDU76 F LETHARGIC CHEST PAIN\n1022 LOWER PLAIN\nBRADFORD\n2/5/2012 09:25",
        "CALL:MEDU76 F LETHARGIC CHEST PAIN",
        "ADDR:1022 LOWER PLAIN",
        "CITY:BRADFORD",
        "DATE:2/5/2012",
        "TIME:09:25");

    doTest("T20",
        "[_]  MEDU - 87 F LOW O2 LEVELS\nGILBERT RESD - FARMERS EXCHG BLDG\n245 S MAIN ST APT 2\nBRADFORD\n2/6/2012 16:53",
        "CALL:MEDU - 87 F LOW O2 LEVELS",
        "PLACE:GILBERT RESD - FARMERS EXCHG BLDG",
        "ADDR:245 S MAIN ST",
        "APT:2",
        "CITY:BRADFORD",
        "DATE:2/6/2012",
        "TIME:16:53");

    doTest("T21",
        "(_)  MEDU 72 Y M FALLEN\nHUNTINGTON APARTMENTS\n493 S MAIN ST\nBRADFORD\n2/9/2012 18:54",
        "CALL:MEDU 72 Y M FALLEN",
        "PLACE:HUNTINGTON APARTMENTS",
        "ADDR:493 S MAIN ST",
        "CITY:BRADFORD",
        "DATE:2/9/2012",
        "TIME:18:54");

    doTest("T22",
        "(_) FD- STILL-SMOKE INVEST\nS PLEASANT ST\nBRADFORD\nFire District: F20\n6/15/2012 13:43",
        "CALL:FD- STILL-SMOKE INVEST",
        "ADDR:S PLEASANT ST",
        "CITY:BRADFORD",
        "INFO:Fire District: F20",
        "DATE:6/15/2012",
        "TIME:13:43");
    
  }
  
  @Test
  public void testParserNH() {

    doTest("T1",
        "(_) MUTUAL AID FIRE/AMB CALL\nHAVERHILL CORNER STATION\nHAVERHILL\nWITH ENGINE AND TANKER FOR COVERAGE\n6/10/2012 17:05",
        "CALL:MUTUAL AID FIRE/AMB CALL",
        "ADDR:HAVERHILL CORNER STATION",
        "CITY:HAVERHILL",
        "INFO:WITH ENGINE AND TANKER FOR COVERAGE",
        "DATE:6/10/2012",
        "TIME:17:05");
  }
  
  @Test
  public void testHollisFireDepartment() {

    doTest("T1",
        "(HCC) MEDICAL SERVICE CALL\nLEBLANC, LEON AND JREIGE LEBLANC, NADIA\n102 LONG HILL RD \nHollis\nDistrict: 005\n3/23/2013 12:42\n\n\n",
        "SRC:HCC",
        "CALL:MEDICAL SERVICE CALL",
        "PLACE:LEBLANC, LEON AND JREIGE LEBLANC, NADIA",
        "ADDR:102 LONG HILL RD",
        "CITY:Hollis",
        "MAP:005",
        "DATE:3/23/2013",
        "TIME:12:42");

    doTest("T2",
        "(HCC) FIRE / ALARM\nRYDSTROM, LORIN AND NANCI\n124 DOW RD \nHollis\nUnder control\n\n\n",
        "SRC:HCC",
        "CALL:FIRE / ALARM",
        "PLACE:RYDSTROM, LORIN AND NANCI",
        "ADDR:124 DOW RD",
        "CITY:Hollis",
        "INFO:Under control");

    doTest("T3",
        "(HCC) FIRE / ALARM\nRYDSTROM, LORIN AND NANCI\n124 DOW RD \nHollis\nDistrict: 001\n3/23/2013 07:05\n\n\n",
        "SRC:HCC",
        "CALL:FIRE / ALARM",
        "PLACE:RYDSTROM, LORIN AND NANCI",
        "ADDR:124 DOW RD",
        "CITY:Hollis",
        "MAP:001",
        "DATE:3/23/2013",
        "TIME:07:05");

    doTest("T4",
        "(HCC) M V A UNKNOWN INJURY\n305 ROUTE 13 AND 196 OLD MILFORD RD \nBrookline\nDistrict: 505\n3/22/2013 23:24\n\n\n",
        "SRC:HCC",
        "CALL:M V A UNKNOWN INJURY",
        "ADDR:305 ROUTE 13 AND 196 OLD MILFORD RD",
        "MADDR:305 ROUTE 13",
        "CITY:Brookline",
        "MAP:505",
        "DATE:3/22/2013",
        "TIME:23:24");

    doTest("T5",
        "(HCC) MEDICAL EMERGENCY\nDUNN, RUTH\n8 RAIL WAY \nHollis\nDistrict: 004\n3/22/2013 01:16\n\n\n",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:DUNN, RUTH",
        "ADDR:8 RAIL WAY",
        "CITY:Hollis",
        "MAP:004",
        "DATE:3/22/2013",
        "TIME:01:16");

    doTest("T6",
        "(HCC) M V A UNKNOWN INJURY\nOROURKE, MICHAEL\n151 FARLEY RD \nHollis\nDistrict: 030\n3/20/2013 09:55\n\n\n",
        "SRC:HCC",
        "CALL:M V A UNKNOWN INJURY",
        "PLACE:OROURKE, MICHAEL",
        "ADDR:151 FARLEY RD",
        "CITY:Hollis",
        "MAP:030",
        "DATE:3/20/2013",
        "TIME:09:55");

    doTest("T7",
        "(HCC) M V A UNKNOWN INJURY\nCOOK, PETER AND JUDY\n10 MAIN ST \nBrookline\nDistrict: 501\n3/19/2013 15:38\n\n\n",
        "SRC:HCC",
        "CALL:M V A UNKNOWN INJURY",
        "PLACE:COOK, PETER AND JUDY",
        "ADDR:10 MAIN ST",
        "CITY:Brookline",
        "MAP:501",
        "DATE:3/19/2013",
        "TIME:15:38");

    doTest("T8",
        "(HCC) M V A UNKNOWN INJURY\nGLOVER, MARGARET ( HONI )\n52 NEVINS RD \nHollis\nHFD under control at this time\n\n\n",
        "SRC:HCC",
        "CALL:M V A UNKNOWN INJURY",
        "PLACE:GLOVER, MARGARET ( HONI )",
        "ADDR:52 NEVINS RD",
        "CITY:Hollis",
        "INFO:HFD under control at this time");

    doTest("T9",
        "(HCC) M V A UNKNOWN INJURY\nGLOVER, MARGARET ( HONI )\n52 NEVINS RD \nHollis\nDistrict: 042\n3/19/2013 12:23\n\n\n",
        "SRC:HCC",
        "CALL:M V A UNKNOWN INJURY",
        "PLACE:GLOVER, MARGARET ( HONI )",
        "ADDR:52 NEVINS RD",
        "CITY:Hollis",
        "MAP:042",
        "DATE:3/19/2013",
        "TIME:12:23");

    doTest("T10",
        "(HCC) MEDICAL EMERGENCY\nGARRITY, JOHN AND RACHEL\n189 WHEELER RD \nHollis\nDistrict: 035\n3/19/2013 12:08\n\n\n",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:GARRITY, JOHN AND RACHEL",
        "ADDR:189 WHEELER RD",
        "CITY:Hollis",
        "MAP:035",
        "DATE:3/19/2013",
        "TIME:12:08");

    doTest("T11",
        "(HCC) MEDICAL EMERGENCY\nBURTT, JEFFREY AND LISA\n35 N PEPPERELL RD \nHollis\nDistrict: 012\n3/18/2013 21:54\n\n\n",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:BURTT, JEFFREY AND LISA",
        "ADDR:35 N PEPPERELL RD",
        "CITY:Hollis",
        "MAP:012",
        "DATE:3/18/2013",
        "TIME:21:54");

    doTest("T12",
        "(HCC) MEDICAL MUTUAL AID\nNH AVE, NASHUA\nHollis\nDistrict: OUT\n3/18/2013 17:09\n\n\n",
        "SRC:HCC",
        "CALL:MEDICAL MUTUAL AID",
        "ADDR:NH AVE, NASHUA",
        "CITY:Hollis",
        "MAP:OUT",
        "DATE:3/18/2013",
        "TIME:17:09");

    doTest("T13",
        "(HCC) MEDICAL SERVICE CALL\nWARREN, MARIAN\n5 N PEPPERELL RD \nHollis\nDistrict: 012\n3/18/2013 12:00\n\n\n",
        "SRC:HCC",
        "CALL:MEDICAL SERVICE CALL",
        "PLACE:WARREN, MARIAN",
        "ADDR:5 N PEPPERELL RD",
        "CITY:Hollis",
        "MAP:012",
        "DATE:3/18/2013",
        "TIME:12:00");

    doTest("T14",
        "(HCC) MEDICAL EMERGENCY\nGEDDES, DAVID AND MABLE\n318 S MERRIMACK RD \nHollis\nDistrict: 045\n3/17/2013 19:40\n\n\n",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:GEDDES, DAVID AND MABLE",
        "ADDR:318 S MERRIMACK RD",
        "CITY:Hollis",
        "MAP:045",
        "DATE:3/17/2013",
        "TIME:19:40");

    doTest("T15",
        "(HCC) MEDICAL EMERGENCY\nTOWN HALL\n7 MONUMENT SQ \nHollis\nDistrict: 007\n3/17/2013 14:59\n\n\n",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:TOWN HALL",
        "ADDR:7 MONUMENT SQ",
        "CITY:Hollis",
        "MAP:007",
        "DATE:3/17/2013",
        "TIME:14:59");

    doTest("T16",
        "(HCC) M V A UNKNOWN INJURY\n165 FARLEY RD AND 1 SWALLOW DR \nHollis / UNDER CONTROL, NO TX.\n\n",
        "SRC:HCC",
        "CALL:M V A UNKNOWN INJURY",
        "ADDR:165 FARLEY RD AND 1 SWALLOW DR",
        "MADDR:165 FARLEY RD",
        "CITY:Hollis",
        "INFO:UNDER CONTROL, NO TX.");

    doTest("T17",
        "(HCC) M V A UNKNOWN INJURY\n165 FARLEY RD AND 1 SWALLOW DR \nHollis\nDistrict: 030\n3/16/2013 19:23\n\n\n",
        "SRC:HCC",
        "CALL:M V A UNKNOWN INJURY",
        "ADDR:165 FARLEY RD AND 1 SWALLOW DR",
        "MADDR:165 FARLEY RD",
        "CITY:Hollis",
        "MAP:030",
        "DATE:3/16/2013",
        "TIME:19:23");

    doTest("T18",
        "(HCC) MEDICAL EMERGENCY\nBRUSON, RICHARD AND KAREN\n48 LONG HILL RD \nHollis\nunder control \n3/16/2013 06:54\n\n\n",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:BRUSON, RICHARD AND KAREN",
        "ADDR:48 LONG HILL RD",
        "CITY:Hollis",
        "INFO:under control",
        "DATE:3/16/2013",
        "TIME:06:54");

    doTest("T19",
        "(HCC) MEDICAL EMERGENCY\nBRUSON, RICHARD AND KAREN\n48 LONG HILL RD \nHollis\nDistrict: 005\n3/16/2013 06:54\n\n\n",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:BRUSON, RICHARD AND KAREN",
        "ADDR:48 LONG HILL RD",
        "CITY:Hollis",
        "MAP:005",
        "DATE:3/16/2013",
        "TIME:06:54");

    doTest("T20",
        "(HCC) MEDICAL EMERGENCY\nOVERLOOK COUNTRY CLUB\n5 OVERLOOK DR \nHollis\nDistrict: 003\n3/16/2013 01:38\n\n\n",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:OVERLOOK COUNTRY CLUB",
        "ADDR:5 OVERLOOK DR",
        "CITY:Hollis",
        "MAP:003",
        "DATE:3/16/2013",
        "TIME:01:38");

  }
  
  @Test
  public void testHollisFireDept2() {

    doTest("T1",
        "(HCC) MEDICAL EMERGENCY\nFERNALD, ROSEL & PORTER, BARBARA\n198 FARLEY RD \nHollis\nDistrict: 042\n3/28/2013 14:44",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:FERNALD, ROSEL & PORTER, BARBARA",
        "ADDR:198 FARLEY RD",
        "CITY:Hollis",
        "MAP:042",
        "DATE:3/28/2013",
        "TIME:14:44");

    doTest("T2",
        "(HCC) MEDICAL EMERGENCY\nHELLMER, ROLAND AND ANGELIKA\n16 TODDY BROOK RD \nHollis\nDistrict: 038\n3/27/2013 12:57",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:HELLMER, ROLAND AND ANGELIKA",
        "ADDR:16 TODDY BROOK RD",
        "CITY:Hollis",
        "MAP:038",
        "DATE:3/27/2013",
        "TIME:12:57");

    doTest("T3",
        "(HCC) MEDICAL EMERGENCY\nREDES, PETER AND SHARON\n77 WHEELER RD \nHollis\nUnder control sufficient help\n3/27/2013 03:29",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:REDES, PETER AND SHARON",
        "ADDR:77 WHEELER RD",
        "CITY:Hollis",
        "INFO:Under control sufficient help",
        "DATE:3/27/2013",
        "TIME:03:29");

    doTest("T4",
        "(HCC) MEDICAL EMERGENCY\nREDES, PETER AND SHARON\n77 WHEELER RD \nHollis\nDistrict: 035\n3/27/2013 03:29",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:REDES, PETER AND SHARON",
        "ADDR:77 WHEELER RD",
        "CITY:Hollis",
        "MAP:035",
        "DATE:3/27/2013",
        "TIME:03:29");

    doTest("T5",
        "(HCC) FIRE / ALARM\nCUNNINGHAM, JOHN AND JANE  ( TENANTS )\n25 MEADOW DR \nHollis\nDistrict: 043\n3/27/2013 00:04",
        "SRC:HCC",
        "CALL:FIRE / ALARM",
        "PLACE:CUNNINGHAM, JOHN AND JANE  ( TENANTS )",
        "ADDR:25 MEADOW DR",
        "CITY:Hollis",
        "MAP:043",
        "DATE:3/27/2013",
        "TIME:00:04");

    doTest("T6",
        "(HCC) MEDICAL EMERGENCY\nGALLANT, FAYONE  ( TENANT )\n6 MARKET PL APT 1 B\nHollis\n13A1 UNDER CONTROL",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:GALLANT, FAYONE  ( TENANT )",
        "ADDR:6 MARKET PL",
        "APT:1 B",
        "CITY:Hollis",
        "INFO:13A1 UNDER CONTROL");

    doTest("T7",
        "(HCC) MEDICAL EMERGENCY\nGALLANT, FAYONE  ( TENANT )\n6 MARKET PL APT 1 B\nHollis\nDistrict: 008\n3/26/2013 14:34",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:GALLANT, FAYONE  ( TENANT )",
        "ADDR:6 MARKET PL",
        "APT:1 B",
        "CITY:Hollis",
        "MAP:008",
        "DATE:3/26/2013",
        "TIME:14:34");

    doTest("T8",
        "(HCC) MEDICAL EMERGENCY\nLAGANAS, PENI\n176 FARLEY RD \nHollis\nUnder control sufficient help on the scene\nLIFT ASSIST",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:LAGANAS, PENI",
        "ADDR:176 FARLEY RD",
        "CITY:Hollis",
        "INFO:Under control sufficient help on the scene / LIFT ASSIST");

    doTest("T9",
        "(HCC) MEDICAL EMERGENCY\nLAGANAS, PENI\n176 FARLEY RD \nHollis\nDistrict: 030\n3/26/2013 11:37",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:LAGANAS, PENI",
        "ADDR:176 FARLEY RD",
        "CITY:Hollis",
        "MAP:030",
        "DATE:3/26/2013",
        "TIME:11:37");

    doTest("T10",
        "(HCC) MEDICAL LIFT ASSIST\nCOLE, HOWARD AND JOAN\n54 WHEELER RD \nHollis\n13A1 under control\n3/25/2013 22:35",
        "SRC:HCC",
        "CALL:MEDICAL LIFT ASSIST",
        "PLACE:COLE, HOWARD AND JOAN",
        "ADDR:54 WHEELER RD",
        "CITY:Hollis",
        "INFO:13A1 under control",
        "DATE:3/25/2013",
        "TIME:22:35");

    doTest("T11",
        "(HCC) MEDICAL LIFT ASSIST\nCOLE, HOWARD AND JOAN\n54 WHEELER RD \nHollis\nDistrict: 035\n3/25/2013 22:35",
        "SRC:HCC",
        "CALL:MEDICAL LIFT ASSIST",
        "PLACE:COLE, HOWARD AND JOAN",
        "ADDR:54 WHEELER RD",
        "CITY:Hollis",
        "MAP:035",
        "DATE:3/25/2013",
        "TIME:22:35");

    doTest("T12",
        "(HCC) MEDICAL EMERGENCY\n" +
        "BOSOWSKI, JOSEPH AND FRANCESCA\n" +
        "71 IRENE DR \n" +
        "Hollis\n" +
        "District: 011\n" +
        "3/24/2013 16:59\n" +
        "Command placing the call under control",

        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:BOSOWSKI, JOSEPH AND FRANCESCA",
        "ADDR:71 IRENE DR",
        "CITY:Hollis",
        "INFO:Command placing the call under control",
        "MAP:011",
        "DATE:3/24/2013",
        "TIME:16:59");

    doTest("T13",
        "(HCC) MEDICAL EMERGENCY\nBOSOWSKI, JOSEPH AND FRANCESCA\n71 IRENE DR \nHollis\nDistrict: 011\n3/24/2013 16:59",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:BOSOWSKI, JOSEPH AND FRANCESCA",
        "ADDR:71 IRENE DR",
        "CITY:Hollis",
        "MAP:011",
        "DATE:3/24/2013",
        "TIME:16:59");

    doTest("T14",
        "(HCC) M V A WITH INJURY\nTESTA, JOHN\n118 WHEELER RD \nHollis\nplacing call under control\n3/24/2013 04:11",
        "SRC:HCC",
        "CALL:M V A WITH INJURY",
        "PLACE:TESTA, JOHN",
        "ADDR:118 WHEELER RD",
        "CITY:Hollis",
        "INFO:placing call under control",
        "DATE:3/24/2013",
        "TIME:04:11");

    doTest("T15",
        "(HCC) M V A WITH INJURY\nTESTA, JOHN\n118 WHEELER RD \nHollis\nDistrict: 035\n3/24/2013 04:11",
        "SRC:HCC",
        "CALL:M V A WITH INJURY",
        "PLACE:TESTA, JOHN",
        "ADDR:118 WHEELER RD",
        "CITY:Hollis",
        "MAP:035",
        "DATE:3/24/2013",
        "TIME:04:11");

    doTest("T16",
        "(HCC) MEDICAL SERVICE CALL\nLEBLANC, LEON AND JREIGE LEBLANC, NADIA\n102 LONG HILL RD \nHollis\nDistrict: 005\n3/23/2013 12:42",
        "SRC:HCC",
        "CALL:MEDICAL SERVICE CALL",
        "PLACE:LEBLANC, LEON AND JREIGE LEBLANC, NADIA",
        "ADDR:102 LONG HILL RD",
        "CITY:Hollis",
        "MAP:005",
        "DATE:3/23/2013",
        "TIME:12:42");

    doTest("T17",
        "(HCC) FIRE / ALARM\nRYDSTROM, LORIN AND NANCI\n124 DOW RD \nHollis\nUnder control",
        "SRC:HCC",
        "CALL:FIRE / ALARM",
        "PLACE:RYDSTROM, LORIN AND NANCI",
        "ADDR:124 DOW RD",
        "CITY:Hollis",
        "INFO:Under control");

    doTest("T18",
        "(HCC) FIRE / ALARM\nRYDSTROM, LORIN AND NANCI\n124 DOW RD \nHollis\nDistrict: 001\n3/23/2013 07:05",
        "SRC:HCC",
        "CALL:FIRE / ALARM",
        "PLACE:RYDSTROM, LORIN AND NANCI",
        "ADDR:124 DOW RD",
        "CITY:Hollis",
        "MAP:001",
        "DATE:3/23/2013",
        "TIME:07:05");

    doTest("T19",
        "(HCC) M V A UNKNOWN INJURY\n305 ROUTE 13 AND 196 OLD MILFORD RD \nBrookline\nDistrict: 505\n3/22/2013 23:24",
        "SRC:HCC",
        "CALL:M V A UNKNOWN INJURY",
        "ADDR:305 ROUTE 13 AND 196 OLD MILFORD RD",
        "MADDR:305 ROUTE 13",
        "CITY:Brookline",
        "MAP:505",
        "DATE:3/22/2013",
        "TIME:23:24");

    doTest("T20",
        "(HCC) MEDICAL EMERGENCY\nDUNN, RUTH\n8 RAIL WAY \nHollis\nDistrict: 004\n3/22/2013 01:16",
        "SRC:HCC",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:DUNN, RUTH",
        "ADDR:8 RAIL WAY",
        "CITY:Hollis",
        "MAP:004",
        "DATE:3/22/2013",
        "TIME:01:16");
 
  }
  
  @Test
  public void testAmherstFireDeparatment() {

    doTest("T1",
        "(Amherst Fire) ACCIDENT W/ INJURY\nWALTS SHELL\n148 AMHERST ST \nAMHERST\nDistrict: DIST2\n03/29/2013 11:44",
        "SRC:Amherst Fire",
        "CALL:ACCIDENT W/ INJURY",
        "PLACE:WALTS SHELL",
        "ADDR:148 AMHERST ST",
        "CITY:AMHERST",
        "MAP:DIST2",
        "DATE:03/29/2013",
        "TIME:11:44");

    doTest("T2",
        "(Amherst Fire) ACCIDENT W/ INJURY\n98 SPRING RD AND 2 SAWMILL LN \nAMHERST\nDistrict: DIST4\n03/29/2013 11:39",
        "SRC:Amherst Fire",
        "CALL:ACCIDENT W/ INJURY",
        "ADDR:98 SPRING RD AND 2 SAWMILL LN",
        "MADDR:98 SPRING RD",
        "CITY:AMHERST",
        "MAP:DIST4",
        "DATE:03/29/2013",
        "TIME:11:39");

    doTest("T3",
        "(Amherst Fire) ACCIDENT W/ INJURY\n179 HOLLIS RD \nAMHERST\nDistrict: DIST6\n03/27/2013 12:58",
        "SRC:Amherst Fire",
        "CALL:ACCIDENT W/ INJURY",
        "ADDR:179 HOLLIS RD",
        "CITY:AMHERST",
        "MAP:DIST6",
        "DATE:03/27/2013",
        "TIME:12:58");

    doTest("T4",
        "(Amherst Fire) FIRE, CHIMNEY\nGAGNON, SCOTT\n18 MIDDLE ST \nAMHERST\nDistrict: DIST2\n3/27/2013 10:47",
        "SRC:Amherst Fire",
        "CALL:FIRE, CHIMNEY",
        "PLACE:GAGNON, SCOTT",
        "ADDR:18 MIDDLE ST",
        "CITY:AMHERST",
        "MAP:DIST2",
        "DATE:3/27/2013",
        "TIME:10:47");

    doTest("T5",
        "(Amherst Fire) ACCIDENT W/ INJURY\n344 BOSTON POST RD AND 13 CRICKET CORNER RD \nAMHERST\nDistrict: DIST4\n03/26/2013 17:20",
        "SRC:Amherst Fire",
        "CALL:ACCIDENT W/ INJURY",
        "ADDR:344 BOSTON POST RD AND 13 CRICKET CORNER RD",
        "MADDR:344 BOSTON POST RD",
        "CITY:AMHERST",
        "MAP:DIST4",
        "DATE:03/26/2013",
        "TIME:17:20");

    doTest("T6",
        "(Amherst Fire) FIRE, MUTUAL AID\n42 COURTLAND DR \nBEDFORD\nDistrict: DIST2\n03/18/2013 21:24",
        "SRC:Amherst Fire",
        "CALL:FIRE, MUTUAL AID",
        "ADDR:42 COURTLAND DR",
        "CITY:BEDFORD",
        "MAP:DIST2",
        "DATE:03/18/2013",
        "TIME:21:24");
  
  }
  
  @Test
  public void testNorwichFireDepartment() {
    
    setDefaults("HANOVER", "VT");

    doTest("T1",
        "(_) FD- STILL-WIRES DOWN\n287 BLOOD HILL RD EAST \nNORWICH\nDistrict: N2\n6/24/2013 17:09",
        "CALL:FD- STILL-WIRES DOWN",
        "ADDR:287 BLOOD HILL RD EAST",
        "CITY:NORWICH",
        "MAP:N2",
        "DATE:6/24/2013",
        "TIME:17:09");

    doTest("T2",
        "(_) 82 Y F SOB, HX CHF\nFALZARINO, BARBARA\n625 RT 5 N \nNORWICH\nDistrict: N1\n6/22/2013 23:21",
        "CALL:82 Y F SOB, HX CHF",
        "PLACE:FALZARINO, BARBARA",
        "ADDR:625 RT 5 N",
        "CITY:NORWICH",
        "MAP:N1",
        "DATE:6/22/2013",
        "TIME:23:21");

    doTest("T3",
        "(_) 82 Y F SOB, HX CHF\nFALZARINO, BARBARA\n625 RT 5 N \nNORWICH\nDistrict: N1\n6/22/2013 23:21",
        "CALL:82 Y F SOB, HX CHF",
        "PLACE:FALZARINO, BARBARA",
        "ADDR:625 RT 5 N",
        "CITY:NORWICH",
        "MAP:N1",
        "DATE:6/22/2013",
        "TIME:23:21");

    doTest("T4",
        "(_) 82 Y F SOB, HX CHF\nFALZARINO, BARBARA\n625 RT 5 N \nNORWICH\nDistrict: N1\n6/22/2013 23:21",
        "CALL:82 Y F SOB, HX CHF",
        "PLACE:FALZARINO, BARBARA",
        "ADDR:625 RT 5 N",
        "CITY:NORWICH",
        "MAP:N1",
        "DATE:6/22/2013",
        "TIME:23:21");

    doTest("T5",
        "(_) 82 Y F SOB, HX CHF\nFALZARINO, BARBARA\n625 RT 5 N \nNORWICH\nDistrict: N1\n6/22/2013 23:21",
        "CALL:82 Y F SOB, HX CHF",
        "PLACE:FALZARINO, BARBARA",
        "ADDR:625 RT 5 N",
        "CITY:NORWICH",
        "MAP:N1",
        "DATE:6/22/2013",
        "TIME:23:21");

    doTest("T6",
        "(_) MEDU-ELD F FELL, RIB PAIN\nCROWE, GLORIA\n96 UPPER TURNPIKE RD \nNORWICH\nDistrict: N2\n6/17/2013 18:31",
        "CALL:MEDU-ELD F FELL, RIB PAIN",
        "PLACE:CROWE, GLORIA",
        "ADDR:96 UPPER TURNPIKE RD",
        "CITY:NORWICH",
        "MAP:N2",
        "DATE:6/17/2013",
        "TIME:18:31");

    doTest("T7",
        "(_) MEDU - MEDICAL ALARM\nCROWE, GLORIA\n96 UPPER TURNPIKE RD \nNORWICH\nDistrict: N2\n6/17/2013 01:43",
        "CALL:MEDU - MEDICAL ALARM",
        "PLACE:CROWE, GLORIA",
        "ADDR:96 UPPER TURNPIKE RD",
        "CITY:NORWICH",
        "MAP:N2",
        "DATE:6/17/2013",
        "TIME:01:43");

    doTest("T8",
        "(_) FD- STILL- CO DET ACTIVATION\n117 DOUGLAS RD \nNORWICH\nDistrict: N2\n6/16/2013 09:54",
        "CALL:FD- STILL- CO DET ACTIVATION",
        "ADDR:117 DOUGLAS RD",
        "CITY:NORWICH",
        "MAP:N2",
        "DATE:6/16/2013",
        "TIME:09:54");

    doTest("T9",
        "(_) 93 Y F MEDICAL ALARM\nNORWICH SENIOR HOUSING BUILDING 28\n28 DORRANCE DR APT 18\nNORWICH\nDistrict: N1\n6/15/2013 19:10",
        "CALL:93 Y F MEDICAL ALARM",
        "PLACE:NORWICH SENIOR HOUSING BUILDING 28",
        "ADDR:28 DORRANCE DR",
        "APT:18",
        "CITY:NORWICH",
        "MAP:N1",
        "DATE:6/15/2013",
        "TIME:19:10");

    doTest("T10",
        "(_) FIRE CALL - FIRE ALARM\nREICHBERT, BETH\n180 BIRCH HILL LN \nNORWICH\nDistrict: N2\n6/14/2013 13:10",
        "CALL:FIRE CALL - FIRE ALARM",
        "PLACE:REICHBERT, BETH",
        "ADDR:180 BIRCH HILL LN",
        "CITY:NORWICH",
        "MAP:N2",
        "DATE:6/14/2013",
        "TIME:13:10");

    doTest("T11",
        "(_) MEDU 88 F FALLEN\nDZIELAK, HILDA\n54 CARPENTER ST \nNORWICH\nDistrict: N1\n6/14/2013 07:00",
        "CALL:MEDU 88 F FALLEN",
        "PLACE:DZIELAK, HILDA",
        "ADDR:54 CARPENTER ST",
        "CITY:NORWICH",
        "MAP:N1",
        "DATE:6/14/2013",
        "TIME:07:00");

    doTest("T12",
        "(_) MEDU 75 F BLOOD IN URINE\n70 CAMPBELL FLAT RD \nNORWICH\nDistrict: N3\n6/13/2013 09:16",
        "CALL:MEDU 75 F BLOOD IN URINE",
        "ADDR:70 CAMPBELL FLAT RD",
        "CITY:NORWICH",
        "MAP:N3",
        "DATE:6/13/2013",
        "TIME:09:16");

    doTest("T13",
        "(_) HANOVER PLAYING... PLS RESPOND\nTRACY HALL\n300 MAIN ST \nNORWICH\nDistrict: N1\n6/12/2013 14:03",
        "CALL:HANOVER PLAYING... PLS RESPOND",
        "PLACE:TRACY HALL",
        "ADDR:300 MAIN ST",
        "CITY:NORWICH",
        "MAP:N1",
        "DATE:6/12/2013",
        "TIME:14:03");

    doTest("T14",
        "(_) FD- STILL TEST PAGE\nNORWICH FIRE STATION\n11 FIREHOUSE LN \nNORWICH\nDistrict: N1\n6/12/2013 11:08",
        "CALL:FD- STILL TEST PAGE",
        "PLACE:NORWICH FIRE STATION",
        "ADDR:11 FIREHOUSE LN",
        "CITY:NORWICH",
        "MAP:N1",
        "DATE:6/12/2013",
        "TIME:11:08");

    doTest("T15",
        "(_) MED - ASSIST UP STAIRS\nGROTH\n217 TOWN FARM RD \nNORWICH\nDistrict: N2\n6/11/2013 12:39",
        "CALL:MED - ASSIST UP STAIRS",
        "PLACE:GROTH",
        "ADDR:217 TOWN FARM RD",
        "CITY:NORWICH",
        "MAP:N2",
        "DATE:6/11/2013",
        "TIME:12:39");

    doTest("T16",
        "(_) FD- STILL- TREE ON LINES\n1035 RT 5 N AND 125 FARRELL FARM RD \nNORWICH\nDistrict: N2\n6/8/2013 07:48",
        "CALL:FD- STILL- TREE ON LINES",
        "ADDR:1035 RT 5 N AND 125 FARRELL FARM RD",
        "MADDR:1035 RT 5 N",
        "CITY:NORWICH",
        "MAP:N2",
        "DATE:6/8/2013",
        "TIME:07:48");

    doTest("T17",
        "(_) MEDU ABDOMINAL PAIN\nNORWICH SENIOR HOUSING BUILDING 4\n4 DORRANCE DR APT 5\nNORWICH\nDistrict: N1\n6/7/2013 05:22",
        "CALL:MEDU ABDOMINAL PAIN",
        "PLACE:NORWICH SENIOR HOUSING BUILDING 4",
        "ADDR:4 DORRANCE DR",
        "APT:5",
        "CITY:NORWICH",
        "MAP:N1",
        "DATE:6/7/2013",
        "TIME:05:22");

    doTest("T18",
        "(_) MEDU POSS HEART ATTACK\nI-91 \nNORWICH\nDistrict: N9\n6/6/2013 11:57",
        "CALL:MEDU POSS HEART ATTACK",
        "ADDR:I-91",
        "MADDR:I 91",
        "CITY:NORWICH",
        "MAP:N9",
        "DATE:6/6/2013",
        "TIME:11:57");

    doTest("T19",
        "(_) MEDU PERSON IN SHOCK\nPATCHINS POINT\nRT 5 \nNORWICH\nDistrict: N1\n6/5/2013 18:16",
        "CALL:MEDU PERSON IN SHOCK",
        "PLACE:PATCHINS POINT",
        "ADDR:RT 5",
        "CITY:NORWICH",
        "MAP:N1",
        "DATE:6/5/2013",
        "TIME:18:16");

    doTest("T20",
        "(_) MEDU-MALE PASSED OUT\nDAN AND WHIT'S STORE\n319 MAIN ST \nNORWICH\nDistrict: N1\n6/3/2013 14:34",
        "CALL:MEDU-MALE PASSED OUT",
        "PLACE:DAN AND WHIT'S STORE",
        "ADDR:319 MAIN ST",
        "CITY:NORWICH",
        "MAP:N1",
        "DATE:6/3/2013",
        "TIME:14:34");

    doTest("T21",
        "(_) MEDU- 90M, GROIN AND BACK PAIN\nGROTH\n217 TOWN FARM RD \nNORWICH\nDistrict: N2\n6/3/2013 09:27",
        "CALL:MEDU- 90M, GROIN AND BACK PAIN",
        "PLACE:GROTH",
        "ADDR:217 TOWN FARM RD",
        "CITY:NORWICH",
        "MAP:N2",
        "DATE:6/3/2013",
        "TIME:09:27");

    doTest("T22",
        "(_) FD- STILL- TREES/WIRES DOWN\n214 KENDALL STATION RD \nNORWICH\nDistrict: N3\n6/2/2013 17:38",
        "CALL:FD- STILL- TREES/WIRES DOWN",
        "ADDR:214 KENDALL STATION RD",
        "CITY:NORWICH",
        "MAP:N3",
        "DATE:6/2/2013",
        "TIME:17:38");

  }

  public static void main(String[] args) {
    new NHHanoverParserTest().generateTests("T1");
  }
}
