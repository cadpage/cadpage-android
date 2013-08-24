package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Keller, TX (in Tarrent County)
Contact: Active911
Agency name: Colleyville Fire Department Location: Colleyville, TX
Sender: crimes@cityofkeller.com 

(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7401 WINDSWEPT TRL, Colleyville\nBANDIT TRL//\n Fire Box = 2310
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Walgreens Glade Rd- 3830 Glade Rd,Box308 Colleyville\nHERITAGE AVE//COPPERGLEN CIR\n Fire Box = 2241
(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n--  HALL JOHNSON RD, Colleyville\nSYCAMORE DR//\n Fire Box = 2129
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5101 BLUEBONNET DR, Colleyville\nRIVERWALK DR//\n Fire Box = 2137
(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n--  PLEASANT RUN, Colleyville\n//\n Fire Box = 2136
(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 921 SHADY LAKE DR - BEDFORD, Colleyville\n//\n Fire Box =
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 3708 BRIARHAVEN LN, Colleyville\nGREENBRIAR LN//NULL\n Fire Box = 2153
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4008 WINDVIEW DR, Colleyville\nCHEEK SPARGER RD//\n Fire Box = 2156
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4904 JIM MITCHELL TRL E, Colleyville\nGLADE RD//NULL\n Fire Box = 2249
(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 4002 ELMWOOD CT, Colleyville\nPLANTATION DR S//NULL\n Fire Box = 2154
(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 213 WHITE DR, Colleyville\nWESTCOAT DR//\n Fire Box = 2319
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4608 JIM MITCHELL TRL W, Colleyville\nGLADE RD//NULL\n Fire Box = 2249
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 219 CHEEK SPARGER RD, Colleyville\nFELPS DR//STEEPLECHASE DR\n Fire Box = 2153
(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 7212 STILTON CT, Colleyville\nCOLLINS PATH//NULL\n Fire Box = 2114
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4801 SHADYCREEK LN, Colleyville\nMEADOWVIEW DR//\n Fire Box = 2249
(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 1912 Shenandoah Dr Gpv, Colleyville\n//\n Fire Box =
(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n--  Merlot Grapevine, Colleyville\n//\n Fire Box =
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n--  PLEASANT RUN RD, Colleyville\nMAIN ST//NULL\n Fire Box = 2128
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5500 VALLEY VIEW DR W, Colleyville\nVALLEY VIEW DR S//NULL\n Fire Box = 2134

Contact: Active911
Agency name: Southlake Fire Services
Location: Southlake, TX, United States
Sender: crimes@cityofkeller.com

(GRASS FIRE) \nGRASS FIRE\n-- 5108 KAYS CT, Colleyville\n//\n Fire Box =
(LOCKOUT OCCUPIED) \nLOCKOUT OCCUPIED\n-Gymboree- 110 STATE ST, Southlake\nE FM 1709//FOUNTAIN PL\n Fire Box = 41200614
(STRUCTURE FIRE) \nSTRUCTURE FIRE\n-- 6016 L D LOCKETT RD, Colleyville\n//\n Fire Box =
(LOCKOUT UNOCCUPIED) \nLOCKOUT UNOCCUPIED\n-Deloitte University and Conf Ctr 1- 1 DELOITTE WAY, Westlake\n//\n Fire Box =
(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n--  N PEARSON LN, Southlake\nW FM 1709//JORDAN DR\n Fire Box = 42100607
(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 604 BRIDLEWOOD N, Colleyville\n//\n Fire Box =
(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n--  Hwy 360 Nb-grapevine, Colleyville\n//\n Fire Box =
(FIRE ALARM - COMMERCIAL) \nFIRE ALARM - COMMERCIAL\n-- 172 STATE ST, Southlake\nFOUNTAIN PL//MAIN ST\n Fire Box = 41200714
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 1035 CARROLL MEADOWS CT, Southlake\nN CARROLL AVE//EOP\n Fire Box = 41201014
(GRASS FIRE) \nGRASS FIRE\n--  CROOKED LN, Southlake\nMIRACLE POINTE DR//BROOKSHIRE DR\n Fire Box = 41200516
(VEHICLE FIRE) \nVEHICLE FIRE\n-- 120 N PEYTONVILLE AVE, Southlake\nW FM 1709//CORPORATE CIR\n Fire Box = 42100709
(NATURAL GAS INSIDE) \nNATURAL GAS INSIDE\n-- 2102 ROCK ROSE CT, WestLake\n//\n Fire Box =
(STRUCTURE FIRE) \nSTRUCTURE FIRE\n-- 1244 ROBIN DR, Keller\nJACKSON RD//WOODS DR\n Fire Box = 52430804
(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 301 BRIDLEWOOD S, Colleyville\n//\n Fire Box =
(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 172 STATE ST, Southlake\nFOUNTAIN PL//MAIN ST\n Fire Box = 41200714
(MUTUAL AID - MEDICAL) \nMUTUAL AID - MEDICAL\n-- 303 Ridge Road   Grapevine, \n//\n Fire Box =
(SMOKE INVESTIGATION) \nSMOKE INVESTIGATION\n-EECU- 1460 W FM 1709, Southlake\nSOUTHRIDGE LAKES PKWY//CORPORATE CIR\n Fire Box = 42100710
(GRASS FIRE) \nGRASS FIRE\n-- 1460 W FM 1709, Southlake\nSOUTHRIDGE LAKES PKWY//CORPORATE CIR\n Fire Box = 42100710
(MEDICAL ALARM) \nMEDICAL ALARM\n-- 1205 OAKWOOD TRL, Southlake\nW CONTINENTAL BLVD//OAKHURST DR\n Fire Box = 42100510
(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n--  CROOKED LN, Southlake\nMIRACLE POINTE DR//BROOKSHIRE DR\n Fire Box = 41200516

Contact: Active911
Agency name: City of Lufkin
Location: Lufkin, TX, United States
Sender: samhouston@cityoflufkin.com

(F Motor Vehicle Accident) \nF Motor Vehicle Accident\n--  PERSHING AVE, \n//\n Fire Box =\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Active Fire alarm) \nF Active Fire alarm\n-- 1906 REDBUD LN, Lufkin\nS JOHN REDDITT DR//MEDICAL CENTER BLVD\n Fire Box = 402\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Smoke in area) \nF Smoke in area\n--  Fm/1818/ 844, \n//\n Fire Box =\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Poweline/Transformer) \nF Poweline/Transformer\n-- 602 JOYCE LN, Lufkin\nE DENMAN AVE//OAKWOOD DR\n Fire Box = 601\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Unknown Odor) \nF Unknown Odor\n--  Fm841/loves, \n//\n Fire Box =\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Unknown Odor) \nF Unknown Odor\n-- 807 PICARDY LN, Lufkin\nSOUTHWOOD DR//ROSENEATH ST\n Fire Box = 401\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Smoke in area) \nF Smoke in area\n-- 1335 Fm 3124/monterey Park, \n//\n Fire Box =\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F HAZMAT Incident) \nF HAZMAT Incident\n-ANGELINA COLLEGE- 3500 S FIRST ST, Lufkin\nDANIEL MCCALL DR//COLLEGE DR\n Fire Box = 602\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Active Fire alarm) \nF Active Fire alarm\n-- 607 VIVION ST, Lufkin\nJORDAN AVE//JOHNSON AVE\n Fire Box = 402\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Vehicle Fire) \nF Vehicle Fire\n-- 107 OKLAHOMA ST, \n//\n Fire Box =\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.

*/

public class TXKellerParserTest extends BaseParserTest {
  
  public TXKellerParserTest() {
    setParser(new TXKellerParser(), "TARRANT COUNTY", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7401 WINDSWEPT TRL, Colleyville\nBANDIT TRL//\n Fire Box = 2310",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:7401 WINDSWEPT TRL",
        "CITY:Colleyville",
        "X:BANDIT TRL",
        "BOX:2310");

    doTest("T2",
        "(MEDICAL EMERGENCY) \n" +
        "MEDICAL EMERGENCY\n" +
        "-Walgreens Glade Rd- 3830 Glade Rd,Box308 Colleyville\n" +
        "HERITAGE AVE//COPPERGLEN CIR\n" +
        " Fire Box = 2241",

        "CALL:MEDICAL EMERGENCY",
        "PLACE:Walgreens Glade Rd",
        "ADDR:3830 Glade Rd, Box 308",
        "MADDR:3830 Glade Rd",
        "CITY:Colleyville",
        "X:HERITAGE AVE/COPPERGLEN CIR",
        "BOX:2241");

    doTest("T3",
        "(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n--  HALL JOHNSON RD, Colleyville\nSYCAMORE DR//\n Fire Box = 2129",
        "CALL:MAJOR ACCIDENT",
        "ADDR:HALL JOHNSON RD",
        "MADDR:HALL JOHNSON RD & SYCAMORE DR",
        "CITY:Colleyville",
        "X:SYCAMORE DR",
        "BOX:2129");

    doTest("T4",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5101 BLUEBONNET DR, Colleyville\nRIVERWALK DR//\n Fire Box = 2137",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:5101 BLUEBONNET DR",
        "CITY:Colleyville",
        "X:RIVERWALK DR",
        "BOX:2137");

    doTest("T5",
        "(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n--  PLEASANT RUN, Colleyville\n//\n Fire Box = 2136",
        "CALL:MAJOR ACCIDENT",
        "ADDR:PLEASANT RUN",
        "CITY:Colleyville",
        "BOX:2136");

    doTest("T6",
        "(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 921 SHADY LAKE DR - BEDFORD, Colleyville\n//\n Fire Box =",
        "CALL:MUTUAL AID - FIRE",
        "ADDR:921 SHADY LAKE DR",
        "CITY:BEDFORD");

    doTest("T7",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 3708 BRIARHAVEN LN, Colleyville\nGREENBRIAR LN//NULL\n Fire Box = 2153",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:3708 BRIARHAVEN LN",
        "CITY:Colleyville",
        "X:GREENBRIAR LN",
        "BOX:2153");

    doTest("T8",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4008 WINDVIEW DR, Colleyville\nCHEEK SPARGER RD//\n Fire Box = 2156",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4008 WINDVIEW DR",
        "CITY:Colleyville",
        "X:CHEEK SPARGER RD",
        "BOX:2156");

    doTest("T9",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4904 JIM MITCHELL TRL E, Colleyville\nGLADE RD//NULL\n Fire Box = 2249",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4904 JIM MITCHELL TRL E",
        "CITY:Colleyville",
        "X:GLADE RD",
        "BOX:2249");

    doTest("T10",
        "(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 4002 ELMWOOD CT, Colleyville\nPLANTATION DR S//NULL\n Fire Box = 2154",
        "CALL:FIRE ALARM - RESIDENTIAL",
        "ADDR:4002 ELMWOOD CT",
        "CITY:Colleyville",
        "X:PLANTATION DR S",
        "BOX:2154");

    doTest("T11",
        "(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 213 WHITE DR, Colleyville\nWESTCOAT DR//\n Fire Box = 2319",
        "CALL:PUBLIC SERVICE",
        "ADDR:213 WHITE DR",
        "CITY:Colleyville",
        "X:WESTCOAT DR",
        "BOX:2319");

    doTest("T12",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4608 JIM MITCHELL TRL W, Colleyville\nGLADE RD//NULL\n Fire Box = 2249",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4608 JIM MITCHELL TRL W",
        "CITY:Colleyville",
        "X:GLADE RD",
        "BOX:2249");

    doTest("T13",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 219 CHEEK SPARGER RD, Colleyville\nFELPS DR//STEEPLECHASE DR\n Fire Box = 2153",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:219 CHEEK SPARGER RD",
        "CITY:Colleyville",
        "X:FELPS DR/STEEPLECHASE DR",
        "BOX:2153");

    doTest("T14",
        "(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 7212 STILTON CT, Colleyville\nCOLLINS PATH//NULL\n Fire Box = 2114",
        "CALL:FIRE ALARM - RESIDENTIAL",
        "ADDR:7212 STILTON CT",
        "CITY:Colleyville",
        "X:COLLINS PATH",
        "BOX:2114");

    doTest("T15",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4801 SHADYCREEK LN, Colleyville\nMEADOWVIEW DR//\n Fire Box = 2249",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4801 SHADYCREEK LN",
        "CITY:Colleyville",
        "X:MEADOWVIEW DR",
        "BOX:2249");

    doTest("T16",
        "(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 1912 Shenandoah Dr Gpv, Colleyville\n//\n Fire Box =",
        "CALL:MUTUAL AID - FIRE",
        "ADDR:1912 Shenandoah Dr Gpv",
        "CITY:Colleyville");

    doTest("T17",
        "(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n--  Merlot Grapevine, Colleyville\n//\n Fire Box =",
        "CALL:MUTUAL AID - FIRE",
        "ADDR:Merlot Grapevine",
        "CITY:Colleyville");

    doTest("T18",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n--  PLEASANT RUN RD, Colleyville\nMAIN ST//NULL\n Fire Box = 2128",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:PLEASANT RUN RD",
        "MADDR:PLEASANT RUN RD & MAIN ST",
        "CITY:Colleyville",
        "X:MAIN ST",
        "BOX:2128");

    doTest("T19",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5500 VALLEY VIEW DR W, Colleyville\nVALLEY VIEW DR S//NULL\n Fire Box = 2134",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:5500 VALLEY VIEW DR W",
        "CITY:Colleyville",
        "X:VALLEY VIEW DR S",
        "BOX:2134");

  }
  
  @Test
  public void testSouthlakeFire() {

    doTest("T1",
        "(GRASS FIRE) \nGRASS FIRE\n-- 5108 KAYS CT, Colleyville\n//\n Fire Box =",
        "CALL:GRASS FIRE",
        "ADDR:5108 KAYS CT",
        "CITY:Colleyville");

    doTest("T2",
        "(LOCKOUT OCCUPIED) \nLOCKOUT OCCUPIED\n-Gymboree- 110 STATE ST, Southlake\nE FM 1709//FOUNTAIN PL\n Fire Box = 41200614",
        "CALL:LOCKOUT OCCUPIED",
        "PLACE:Gymboree",
        "ADDR:110 STATE ST",
        "CITY:Southlake",
        "X:E FM 1709/FOUNTAIN PL",
        "BOX:41200614");

    doTest("T3",
        "(STRUCTURE FIRE) \nSTRUCTURE FIRE\n-- 6016 L D LOCKETT RD, Colleyville\n//\n Fire Box =",
        "CALL:STRUCTURE FIRE",
        "ADDR:6016 L D LOCKETT RD",
        "CITY:Colleyville");

    doTest("T4",
        "(LOCKOUT UNOCCUPIED) \nLOCKOUT UNOCCUPIED\n-Deloitte University and Conf Ctr 1- 1 DELOITTE WAY, Westlake\n//\n Fire Box =",
        "CALL:LOCKOUT UNOCCUPIED",
        "PLACE:Deloitte University and Conf Ctr 1",
        "ADDR:1 DELOITTE WAY",
        "CITY:Westlake");

    doTest("T5",
        "(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n--  N PEARSON LN, Southlake\nW FM 1709//JORDAN DR\n Fire Box = 42100607",
        "CALL:MAJOR ACCIDENT",
        "ADDR:N PEARSON LN",
        "MADDR:N PEARSON LN & W FM 1709",
        "CITY:Southlake",
        "X:W FM 1709/JORDAN DR",
        "BOX:42100607");

    doTest("T6",
        "(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 604 BRIDLEWOOD N, Colleyville\n//\n Fire Box =",
        "CALL:FIRE ALARM - RESIDENTIAL",
        "ADDR:604 BRIDLEWOOD N",
        "CITY:Colleyville");

    doTest("T7",
        "(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n--  Hwy 360 Nb-grapevine, Colleyville\n//\n Fire Box =",
        "CALL:MUTUAL AID - FIRE",
        "ADDR:Hwy 360 Nb",
        "MADDR:Hwy 360",
        "CITY:grapevine");

    doTest("T8",
        "(FIRE ALARM - COMMERCIAL) \nFIRE ALARM - COMMERCIAL\n-- 172 STATE ST, Southlake\nFOUNTAIN PL//MAIN ST\n Fire Box = 41200714",
        "CALL:FIRE ALARM - COMMERCIAL",
        "ADDR:172 STATE ST",
        "CITY:Southlake",
        "X:FOUNTAIN PL/MAIN ST",
        "BOX:41200714");

    doTest("T9",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 1035 CARROLL MEADOWS CT, Southlake\nN CARROLL AVE//EOP\n Fire Box = 41201014",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:1035 CARROLL MEADOWS CT",
        "CITY:Southlake",
        "X:N CARROLL AVE/EOP",
        "BOX:41201014");

    doTest("T10",
        "(GRASS FIRE) \nGRASS FIRE\n--  CROOKED LN, Southlake\nMIRACLE POINTE DR//BROOKSHIRE DR\n Fire Box = 41200516",
        "CALL:GRASS FIRE",
        "ADDR:CROOKED LN",
        "MADDR:CROOKED LN & MIRACLE POINTE DR",
        "CITY:Southlake",
        "X:MIRACLE POINTE DR/BROOKSHIRE DR",
        "BOX:41200516");

    doTest("T11",
        "(VEHICLE FIRE) \nVEHICLE FIRE\n-- 120 N PEYTONVILLE AVE, Southlake\nW FM 1709//CORPORATE CIR\n Fire Box = 42100709",
        "CALL:VEHICLE FIRE",
        "ADDR:120 N PEYTONVILLE AVE",
        "CITY:Southlake",
        "X:W FM 1709/CORPORATE CIR",
        "BOX:42100709");

    doTest("T12",
        "(NATURAL GAS INSIDE) \nNATURAL GAS INSIDE\n-- 2102 ROCK ROSE CT, WestLake\n//\n Fire Box =",
        "CALL:NATURAL GAS INSIDE",
        "ADDR:2102 ROCK ROSE CT",  // Not mapping
        "CITY:WestLake");

    doTest("T13",
        "(STRUCTURE FIRE) \nSTRUCTURE FIRE\n-- 1244 ROBIN DR, Keller\nJACKSON RD//WOODS DR\n Fire Box = 52430804",
        "CALL:STRUCTURE FIRE",
        "ADDR:1244 ROBIN DR",
        "CITY:Keller",
        "X:JACKSON RD/WOODS DR",
        "BOX:52430804");

    doTest("T14",
        "(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 301 BRIDLEWOOD S, Colleyville\n//\n Fire Box =",
        "CALL:FIRE ALARM - RESIDENTIAL",
        "ADDR:301 BRIDLEWOOD S",
        "CITY:Colleyville");

    doTest("T15",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 172 STATE ST, Southlake\nFOUNTAIN PL//MAIN ST\n Fire Box = 41200714",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:172 STATE ST",
        "CITY:Southlake",
        "X:FOUNTAIN PL/MAIN ST",
        "BOX:41200714");

    doTest("T16",
        "(MUTUAL AID - MEDICAL) \nMUTUAL AID - MEDICAL\n-- 303 Ridge Road   Grapevine, \n//\n Fire Box =",
        "CALL:MUTUAL AID - MEDICAL",
        "ADDR:303 Ridge Road   Grapevine");  // Dispatch typo??

    doTest("T17",
        "(SMOKE INVESTIGATION) \n" +
        "SMOKE INVESTIGATION\n" +
        "-EECU- 1460 W FM 1709, Southlake\n" +
        "SOUTHRIDGE LAKES PKWY//CORPORATE CIR\n" +
        " Fire Box = 42100710",

        "CALL:SMOKE INVESTIGATION",
        "PLACE:EECU",
        "ADDR:1460 W FM 1709",
        "CITY:Southlake",
        "X:SOUTHRIDGE LAKES PKWY/CORPORATE CIR",
        "BOX:42100710");

    doTest("T18",
        "(GRASS FIRE) \nGRASS FIRE\n-- 1460 W FM 1709, Southlake\nSOUTHRIDGE LAKES PKWY//CORPORATE CIR\n Fire Box = 42100710",
        "CALL:GRASS FIRE",
        "ADDR:1460 W FM 1709",
        "CITY:Southlake",
        "X:SOUTHRIDGE LAKES PKWY/CORPORATE CIR",
        "BOX:42100710");

    doTest("T19",
        "(MEDICAL ALARM) \nMEDICAL ALARM\n-- 1205 OAKWOOD TRL, Southlake\nW CONTINENTAL BLVD//OAKHURST DR\n Fire Box = 42100510",
        "CALL:MEDICAL ALARM",
        "ADDR:1205 OAKWOOD TRL",
        "CITY:Southlake",
        "X:W CONTINENTAL BLVD/OAKHURST DR",
        "BOX:42100510");

    doTest("T20",
        "(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n--  CROOKED LN, Southlake\nMIRACLE POINTE DR//BROOKSHIRE DR\n Fire Box = 41200516",
        "CALL:MAJOR ACCIDENT",
        "ADDR:CROOKED LN",
        "MADDR:CROOKED LN & MIRACLE POINTE DR",
        "CITY:Southlake",
        "X:MIRACLE POINTE DR/BROOKSHIRE DR",
        "BOX:41200516");
  
  }
  
  public static void main(String[] args) {
    new TXKellerParserTest().generateTests("T1");
  }
}
