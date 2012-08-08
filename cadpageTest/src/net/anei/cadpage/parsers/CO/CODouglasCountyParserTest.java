package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CODouglasCountyParserTest extends BaseParserTest {
  
  public CODouglasCountyParserTest() {
    setParser(new CODouglasCountyParser(), "DOUGLAS COUNTY", "CO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Dispatch) Call: F MED ASSIST Location: 6287 OLD DIVIDE TRL / Map: AD35C Units: MED181 E184 XXX184  HOSPITALITY PL / GREEN CT Common Name: Time: 08/25/.",
        "CALL:F MED ASSIST",
        "ADDR:6287 OLD DIVIDE TRL",
        "MAP:AD35C",
        "UNIT:MED181 E184 XXX184",
        "X:HOSPITALITY PL / GREEN CT");

    doTest("T2",
        "(Dispatch) Call: F MED ASSIST Location: 11710 PONDEROSA LN / Map: AF40D Units: E184 MED181 XXX184  PONDEROSA RD / ELKHORN DR Common Name: Time: 08/25/1",
        "CALL:F MED ASSIST",
        "ADDR:11710 PONDEROSA LN",
        "MAP:AF40D",
        "UNIT:E184 MED181 XXX184",
        "X:PONDEROSA RD / ELKHORN DR");

    doTest("T3",
        "(Dispatch) Call: F GAS LP OUTSIDE Location: DEERFIELD RD / S  WHITE TAIL DR I Map: AI38D Units: E181 XXX181  Common Name: Time: 08/25/11 20:07 Narrativ",
        "CALL:F GAS LP OUTSIDE",
        "ADDR:DEERFIELD RD & S  WHITE TAIL DR I",
        "MAP:AI38D",
        "UNIT:E181 XXX181",
        "DATE:08/25/11",
        "TIME:20:07");

    doTest("T4",
        "(Dispatch) Call: F MED ASSIST Location: 2535 BURNT OAK DR / Map: AG37A Units: E181 MED181 XXX181  BURNING TREE TRL / DEAD END Common Name: Time: 08/25/",
        "CALL:F MED ASSIST",
        "ADDR:2535 BURNT OAK DR",
        "MAP:AG37A",
        "UNIT:E181 MED181 XXX181",
        "X:BURNING TREE TRL / DEAD END");
  }
  
  @Test
  public void testElbertCounty() {

    doTest("T1",
        "(Dispatch) Call: F MED ASSIST Location: S PINE ST / SPRUCE ST Map: AJ44 Units: MED271 E273 XXX271  Common Name: Time: 09/20/11 17:13 Narrative:  PER LE 473 PINE",
        "CALL:F MED ASSIST",
        "ADDR:S PINE ST & SPRUCE ST",
        "MAP:AJ44",
        "UNIT:MED271 E273 XXX271",
        "DATE:09/20/11",
        "TIME:17:13",
        "INFO:PER LE 473 PINE");

    doTest("T2",
        "(Dispatch) Call: F MED ASSIST Location: CR 136 / PADDOCK ST EOPS1 Map: AJ44 Units: MED271 E271 XXX272  Common Name: Time: 09/23/11 13:06 Narrative:  Nature Of Ca",
        "CALL:F MED ASSIST",
        "ADDR:CR 136 & PADDOCK ST",
        "MADDR:COUNTY ROAD 136 & PADDOCK ST",
        "CH:EOPS1",
        "MAP:AJ44",
        "UNIT:MED271 E271 XXX272",
        "DATE:09/23/11",
        "TIME:13:06");

    doTest("T3",
        "Subject:Dispatch\n" +
        "Call: F LIGHTNING Location: STATE HIGHWAY 86 / CHEROKEE TRL Map: AJ42 Units: E271 XXX271  Common Name: Time: 06/13/12 21:06",

        "CALL:F LIGHTNING",
        "ADDR:STATE HIGHWAY 86 & CHEROKEE TRL",
        "MADDR:STATE 86 & CHEROKEE TRL",
        "MAP:AJ42",
        "UNIT:E271 XXX271",
        "DATE:06/13/12",
        "TIME:21:06");
    

    doTest("T4",
        "Subject:Dispatch\n" +
        "Call: F BRUSH (T) Location: 4495 W KIOWA CREEK RD / Map: AV44 Units: XXX231 XXX271  BADGER LN / PUMA DR Common Name: Time:",

        "CALL:F BRUSH (T)",
        "ADDR:4495 W KIOWA CREEK RD",
        "MAP:AV44",
        "UNIT:XXX231 XXX271",
        "X:BADGER LN / PUMA DR");

  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "[FW: Dispatch] \n\n" +
        "-----Original Message-----\n" +
        "From: Norris Croom [mailto:NCroom@crgov.com] \n" +
        "Sent: Tuesday, July 03, 2012 5:02 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Tuesday, July 03, 2012 5:02:16 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F LIFT ASSIST Location: 1050 HIGHLAND RIDGE WAY 101 / Map: AH29D2 Units: E154 XXX154  HIGHLAND VISTA AVE / HIGHLAND VISTA AVE Common Name: Time: 07/03/12 05:01 Narrative:  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002042",

        "CALL:F LIFT ASSIST",
        "ADDR:1050 HIGHLAND RIDGE WAY 101",  // Not mapping
        "MAP:AH29D2",
        "UNIT:E154 XXX154",
        "X:HIGHLAND VISTA AVE / HIGHLAND VISTA AVE",
        "DATE:07/03/12",
        "TIME:05:01",
        "INFO:Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE",
        "ID:2012-00002042");

    doTest("T2",
        "[FW: Dispatch] \n\n" +
        "-----Original Message-----\n" +
        "From: Norris Croom [mailto:NCroom@crgov.com] \n" +
        "Sent: Tuesday, July 03, 2012 9:12 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Tuesday, July 03, 2012 9:12:05 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 1470 CLEAR SKY WAY / Map: AH28C Units: E154 MED154 XXX154  AVERY WAY / CONNER CT Common Name: CLEAR SKY ELEMENTARY SCHOOLTime: 07/03/12 09:11 Narrative:  E911 Info - Class of Service: BUSN Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FIRE  2012-00002044",

        "CALL:F MED ASSIST",
        "ADDR:1470 CLEAR SKY WAY",
        "MAP:AH28C",
        "UNIT:E154 MED154 XXX154",
        "X:AVERY WAY / CONNER CT",
        "PLACE:CLEAR SKY ELEMENTARY SCHOOL",
        "DATE:07/03/12",
        "TIME:09:11",
        "INFO:Class of Service: BUSN Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FIRE",
        "ID:2012-00002044");

    doTest("T3",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Tuesday, July 03, 2012 10:46:13 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F GAS LP OUTSIDE Location: 5650 ALLEN WAY / Map: AF30A Units: E154 E151 XXX155  DEAD END / W ALLEN ST, E ALLEN ST Common Name: MICHAELS 5650 ALLEN WAYTime: 07/03/12 10:45 Narrative:  2012-00002045",

        "CALL:F GAS LP OUTSIDE",
        "ADDR:5650 ALLEN WAY",
        "MAP:AF30A",
        "UNIT:E154 E151 XXX155",
        "X:DEAD END / W ALLEN ST, E ALLEN ST",
        "PLACE:MICHAELS",
        "DATE:07/03/12",
        "TIME:10:45",
        "ID:2012-00002045");

    doTest("T4",
        "[FW: Dispatch] \n\n" +
        "-----Original Message-----\n" +
        "From: Norris Croom [mailto:NCroom@crgov.com] \n" +
        "Sent: Tuesday, July 03, 2012 10:46 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Tuesday, July 03, 2012 10:46:13 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F GAS LP OUTSIDE Location: 5650 ALLEN WAY / Map: AF30A Units: E154 E151 XXX155  DEAD END / W ALLEN ST, E ALLEN ST Common Name: MICHAELS 5650 ALLEN WAYTime: 07/03/12 10:45 Narrative:  2012-00002045",

        "CALL:F GAS LP OUTSIDE",
        "ADDR:5650 ALLEN WAY",
        "MAP:AF30A",
        "UNIT:E154 E151 XXX155",
        "X:DEAD END / W ALLEN ST, E ALLEN ST",
        "PLACE:MICHAELS",
        "DATE:07/03/12",
        "TIME:10:45",
        "ID:2012-00002045");

    doTest("T5",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Tuesday, July 03, 2012 2:58:09 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Tuesday, July 03, 2012 2:58:04 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F BRUSH (NT) Location: 41000 COMANCHE CREEK RD / EOPS3 Map: AB58 Units: XXX224 XXX253  COUNTY RD 166 / COUNTY RD 150 Common Name: Time: 07/03/12 14:55 Narrative:  Nature Of Call: EOPS3  2012-00000133",

        "CALL:F BRUSH (NT)",
        "ADDR:41000 COMANCHE CREEK RD",  // Not mapping
        "CH:EOPS3",
        "MAP:AB58",
        "UNIT:XXX224 XXX253",
        "X:COUNTY RD 166 / COUNTY RD 150",
        "DATE:07/03/12",
        "TIME:14:55",
        "ID:2012-00000133");

    doTest("T6",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Tuesday, July 03, 2012 3:22:34 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Tuesday, July 03, 2012 3:22:31 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 5050 FACTORY SHOPS BLVD UNIT 37 / Map: AF29B1 Units: E154 MED154 XXX154  NEW BEALE ST / N CASTLETON DR, MEADOWS PKWY Common Name: Time: 07/03/12 15:21 Narrative:  UNK IF BREATHING  4 TO 5 YR OLD CHILD PASSED OUT  AEORPASTLE STORE  E911 Info - Class of Service: B 2012-00002046",

        "CALL:F MED ASSIST",
        "ADDR:5050 FACTORY SHOPS BLVD",
        "APT:37",
        "MAP:AF29B1",
        "UNIT:E154 MED154 XXX154",
        "X:NEW BEALE ST / N CASTLETON DR, MEADOWS PKWY",
        "DATE:07/03/12",
        "TIME:15:21",
        "INFO:UNK IF BREATHING  4 TO 5 YR OLD CHILD PASSED OUT  AEORPASTLE STORE  Class of Service: B",
        "ID:2012-00002046");

    doTest("T7",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Tuesday, July 03, 2012 5:47:15 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Tuesday, July 03, 2012 5:47:12 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F COMMERCIAL ALA Location: 2294 CASTLEGATE DR NO / Map: AE29C1 Units: E154 E39 XXX154  No Cross Streets Found Common Name: Time: 07/03/12 17:46 Narrative:  2012-00002047",

        "CALL:F COMMERCIAL ALA",
        "ADDR:2294 CASTLEGATE DR NO",
        "MAP:AE29C1",
        "UNIT:E154 E39 XXX154",
        "DATE:07/03/12",
        "TIME:17:46",
        "ID:2012-00002047");

    doTest("T8",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Wednesday, July 04, 2012 1:03:35 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Wednesday, July 04, 2012 1:03:31 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 5418 FAWN RIDGE WAY / Map: AL31D Units: E151 MED151 XXX151  ECHO HOLLOW ST / DEAD END Common Name: Time: 07/04/12 01:03 Narrative:  2012-00002051",

        "CALL:F MED ASSIST",
        "ADDR:5418 FAWN RIDGE WAY",
        "MAP:AL31D",
        "UNIT:E151 MED151 XXX151",
        "X:ECHO HOLLOW ST / DEAD END",
        "DATE:07/04/12",
        "TIME:01:03",
        "ID:2012-00002051");

    doTest("T9",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Wednesday, July 04, 2012 2:10:44 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Wednesday, July 04, 2012 2:10:42 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F COMMERCIAL ALA Location: 4830 CASTLETON WAY / Map: AF30C Units: E154 Q155 XXX154  N CASTLETON CT, W CASTLETON RD / DEAD END Common Name: HAMPTON INN 4830 CASTLETON WAYTime: 07/04/12 02:10 Narrative:  2012-00002053",

        "CALL:F COMMERCIAL ALA",
        "ADDR:4830 CASTLETON WAY",
        "MAP:AF30C",
        "UNIT:E154 Q155 XXX154",
        "X:N CASTLETON CT, W CASTLETON RD / DEAD END",
        "PLACE:HAMPTON INN",
        "DATE:07/04/12",
        "TIME:02:10",
        "ID:2012-00002053");

    doTest("T10",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Wednesday, July 04, 2012 9:52:43 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Wednesday, July 04, 2012 9:52:41 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F BRUSH (NT) Location: / EOPS3 Map: AK84 Units: XXX291  I70 COUNTY RD 134 RAMP, INTERSTATE 70 / I70 HWY 86 RAMP, INTERSTATE 70 Common Name: I70 MM350 EBTime: 07/04/12 09:51 Narrative:  S SIDE OF RD  Nature Of Call: EOPS3  40 FEET OF GRASS FIRE  2012-00000060",

        "CALL:F BRUSH (NT)",
        "CH:EOPS3",
        "MAP:AK84",
        "UNIT:XXX291",
        "X:I70 COUNTY RD 134 RAMP, INTERSTATE 70 / I70 HWY 86 RAMP, INTERSTATE 70",
        "PLACE:I70 MM350 EB",
        "DATE:07/04/12",
        "TIME:09:51",
        "INFO:S SIDE OF RD / 40 FEET OF GRASS FIRE",
        "ID:2012-00000060");

    doTest("T11",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Wednesday, July 04, 2012 12:35:38 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Wednesday, July 04, 2012 12:35:36 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F COMMERCIAL ALA Location: 5650 ALLEN WAY 119 / Map: AF30A Units: Q155 E154 XXX155  DEAD END / W ALLEN ST, E ALLEN ST Common Name: Time: 07/04/12 12:34 Narrative:  2012-00002055",

        "CALL:F COMMERCIAL ALA",
        "ADDR:5650 ALLEN WAY 119",
        "MAP:AF30A",
        "UNIT:Q155 E154 XXX155",
        "X:DEAD END / W ALLEN ST, E ALLEN ST",
        "DATE:07/04/12",
        "TIME:12:34",
        "ID:2012-00002055");

    doTest("T12",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Wednesday, July 04, 2012 12:56:38 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Wednesday, July 04, 2012 12:56:36 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F SMOKE INV OUT Location: E STATE HIGHWAY 86 / N  RIDGE RD Map: AH32C Units: E153 XXX153  Common Name: Time: 07/04/12 12:55 Narrative:  SMELLS AND SEES SMOKE IN THE AREA  2012-00002056",

        "CALL:F SMOKE INV OUT",
        "ADDR:E STATE HIGHWAY 86 & N  RIDGE RD",
        "MADDR:E STATE 86 & N  RIDGE RD",
        "MAP:AH32C",
        "UNIT:E153 XXX153",
        "DATE:07/04/12",
        "TIME:12:55",
        "INFO:SMELLS AND SEES SMOKE IN THE AREA",
        "ID:2012-00002056");

    doTest("T13",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Wednesday, July 04, 2012 9:50:14 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Wednesday, July 04, 2012 9:50:11 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F BRUSH (NT) Location: COUNTY RD 21 / COUNTY RD 114 SEOF EOPS1 Map: AP46 Units: B271 B181 T271 XXX271  Common Name: Time: 07/04/12 21:47 Narrative:  Nature Of Call: EOPS1  2012-00000474",

        "CALL:F BRUSH (NT)",
        "ADDR:COUNTY RD 21 & COUNTY RD 114 SEOF",
        "CH:EOPS1",
        "MAP:AP46",
        "UNIT:B271 B181 T271 XXX271",
        "DATE:07/04/12",
        "TIME:21:47",
        "ID:2012-00000474");

    doTest("T14",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Wednesday, July 04, 2012 10:43:43 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Wednesday, July 04, 2012 10:43:40 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F RES STRUC Location: 40074 MARGARET DR / 2 HSES NOF EOPS1 Map: AC44 Units: E273 E271 T273 T271 MED271 XXX274  DEAD END / FERNS RD Common Name: Time: 07/04/12 22:41 Narrative:  Nature Of Call: EOPS1  RP THINKS THE FLAMES ARE COMING FROM THE HSE  CAN SEE FLAMES  RP SAW LIGHTNI 2012-00000475",

        "CALL:F RES STRUC",
        "ADDR:40074 MARGARET DR & 2 HSES NOF",
        "MADDR:40074 MARGARET DR",   // Not mapping
        "CH:EOPS1",
        "MAP:AC44",
        "UNIT:E273 E271 T273 T271 MED271 XXX274",
        "X:DEAD END / FERNS RD",
        "DATE:07/04/12",
        "TIME:22:41",
        "INFO:RP THINKS THE FLAMES ARE COMING FROM THE HSE  CAN SEE FLAMES  RP SAW LIGHTNI",
        "ID:2012-00000475");

    doTest("T15",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 12:04:54 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 12:04:50 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 1280 S  RIDGE RD / Map: AK33A Units: E153 MED151 XXX153  UNKNOWN / WILLOW CREEK RD Common Name: Time: 07/05/12 00:04 Narrative:  STANDBY  2012-00002057",

        "CALL:F MED ASSIST",
        "ADDR:1280 S  RIDGE RD",
        "MAP:AK33A",
        "UNIT:E153 MED151 XXX153",
        "X:UNKNOWN / WILLOW CREEK RD",
        "DATE:07/05/12",
        "TIME:00:04",
        "INFO:STANDBY",
        "ID:2012-00002057");

    doTest("T16",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 3:32:45 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 3:32:41 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F CO ALA NO SYMP Location: 1030 HIGHLAND VISTA AVE 105 / Map: AH29D2 Units: E154 XXX154  HIGHLAND RIDGE WAY / HIGHLAND RIDGE WAY Common Name: Time: 07/05/12 03:32 Narrative:  ALARM GOING OFF  2012-00002058",

        "CALL:F CO ALA NO SYMP",
        "ADDR:1030 HIGHLAND VISTA AVE 105",
        "MAP:AH29D2",
        "UNIT:E154 XXX154",
        "X:HIGHLAND RIDGE WAY / HIGHLAND RIDGE WAY",
        "DATE:07/05/12",
        "TIME:03:32",
        "INFO:ALARM GOING OFF",
        "ID:2012-00002058");

    doTest("T17",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 3:47:17 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 3:47:08 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 750 N  RIDGE RD / Map: AI32A Units: E153 MED151 XXX153  E STATE HIGHWAY 86 / FIFTH ST, FOUNDERS PKWY, E STATE HIGHWAY 86 Common Name: KING SOOPERS 750 RIDGE RDTime: 07/05/12 03:46 Narrative:  2012-00002059",

        "CALL:F MED ASSIST",
        "ADDR:750 N  RIDGE RD",
        "MAP:AI32A",
        "UNIT:E153 MED151 XXX153",
        "X:E STATE HIGHWAY 86 / FIFTH ST, FOUNDERS PKWY, E STATE HIGHWAY 86",
        "PLACE:KING SOOPERS 750 RIDGE RD",
        "DATE:07/05/12",
        "TIME:03:46",
        "ID:2012-00002059");

    doTest("T18",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 5:57:40 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 5:57:37 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F BRUSH (NT) Location: COUNTY RD 86 / W  KIOWA CREEK RD EOPS3 Map: AV45 Units: XXX231 XXX271  Common Name: Time: 07/05/12 05:55 Narrative:  SMOKE FROM TREE IN AREA  Nature Of Call: EOPS3  E911 Info - Class of Service: VOIP Special Response 2012-00000068",

        "CALL:F BRUSH (NT)",
        "ADDR:COUNTY RD 86 & W  KIOWA CREEK RD",  // Not mapping - Elbert County
        "CH:EOPS3",
        "MAP:AV45",
        "UNIT:XXX231 XXX271",
        "DATE:07/05/12",
        "TIME:05:55",
        "INFO:SMOKE FROM TREE IN AREA / Class of Service: VOIP Special Response",
        "ID:2012-00000068");

    doTest("T19",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 6:25:46 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 6:25:42 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 2775 MOUNTAIN SKY DR / Map: AK31D Units: E151 MED151 XXX152  EAGLE RIDGE WAY, HEATHERGLENN LN / DEER VALLEY DR Common Name: Time: 07/05/12 06:24 Narrative:  85 YOF BREATHING PROBLEMS IS CON  2012-00002060",

        "CALL:F MED ASSIST",
        "ADDR:2775 MOUNTAIN SKY DR",
        "MAP:AK31D",
        "UNIT:E151 MED151 XXX152",
        "X:EAGLE RIDGE WAY, HEATHERGLENN LN / DEER VALLEY DR",
        "DATE:07/05/12",
        "TIME:06:24",
        "INFO:85 YOF BREATHING PROBLEMS IS CON",
        "ID:2012-00002060");

    doTest("T20",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 6:33:24 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 6:33:21 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 5760 CALEY LN / Map: AI33B Units: E153 MED154 XXX153  N BEDFORD AVE / ROCKAWAY AVE Common Name: Time: 07/05/12 06:32 Narrative:  2012-00002061",

        "CALL:F MED ASSIST",
        "ADDR:5760 CALEY LN",  // Google knows this a E CALEY LN
        "MAP:AI33B",
        "UNIT:E153 MED154 XXX153",
        "X:N BEDFORD AVE / ROCKAWAY AVE",
        "DATE:07/05/12",
        "TIME:06:32",
        "ID:2012-00002061");

    doTest("T21",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 7:07:54 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 7:07:51 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F LIFT ASSIST Location: 501 SCOTT BLVD / Map: AG30D1 Units: E151 XXX151  FRONT ST / FRONT ST Common Name: Time: 07/05/12 07:06 Narrative:  68 YOM WITH BAD HIP / FELL FROM BED  E911 Info - Class of Service: WPH2 Special Response Info: PSAP 2012-00002062",

        "CALL:F LIFT ASSIST",
        "ADDR:501 SCOTT BLVD",
        "MAP:AG30D1",
        "UNIT:E151 XXX151",
        "X:FRONT ST / FRONT ST",
        "DATE:07/05/12",
        "TIME:07:06",
        "INFO:68 YOM WITH BAD HIP / FELL FROM BED  Class of Service: WPH2 Special Response Info: PSAP",
        "ID:2012-00002062");

    doTest("T22",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 11:21:02 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 11:21:00 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 3856 RAWHIDE CIR / Map: AG30B Units: Q155 MED154 XXX155  No Cross Streets Found Common Name: Time: 07/05/12 11:20 Narrative:  CON AND BRE  54 YR OLD FEMALE  E911 Info - Class of Service: VOIP Special Response Info: PSAP=CASTL 2012-00002063",

        "CALL:F MED ASSIST",
        "ADDR:3856 RAWHIDE CIR",
        "MAP:AG30B",
        "UNIT:Q155 MED154 XXX155",
        "DATE:07/05/12",
        "TIME:11:20",
        "INFO:CON AND BRE  54 YR OLD FEMALE  Class of Service: VOIP Special Response Info: PSAP=CASTL",
        "ID:2012-00002063");

    doTest("T23",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 2:30:00 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 2:29:47 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 4901 N  CASTLETON DR / Map: AF29D Units: E154 MED154 XXX154  MEADOWS PKWY / W CASTLETON RD, GENOA WAY Common Name: LOAF AND JUG 4901 N CASTLETON DRTime: 07/05/12 14:29 Narrative:  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002064",

        "CALL:F MED ASSIST",
        "ADDR:4901 N  CASTLETON DR",
        "MAP:AF29D",
        "UNIT:E154 MED154 XXX154",
        "X:MEADOWS PKWY / W CASTLETON RD, GENOA WAY",
        "PLACE:LOAF AND JUG 4901 N CASTLETON DR",
        "DATE:07/05/12",
        "TIME:14:29",
        "INFO:Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE",
        "ID:2012-00002064");

    doTest("T24",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 3:29:36 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 3:29:31 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F BRUSH (NT) Location: MEADOWS PKWY / N  US HIGHWAY 85 Map: AF29D Units: B154 B155 E154 T36 BA151 XXX154  Common Name: Time: 07/05/12 15:28 Narrative:  2012-00002065",

        "CALL:F BRUSH (NT)",
        "ADDR:MEADOWS PKWY & N  US HIGHWAY 85",
        "MADDR:MEADOWS PKWY & N  US 85",
        "MAP:AF29D",
        "UNIT:B154 B155 E154 T36 BA151 XXX154",
        "DATE:07/05/12",
        "TIME:15:28",
        "ID:2012-00002065");

    doTest("T25",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 3:30:32 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 3:30:25 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F BRUSH (NT) Location: MEADOWS PKWY / N  US HIGHWAY 85 N Map: AF29D Units:  Common Name: Time: 07/05/12 15:28 Narrative:  ABOUT 20X10FT ON FIRE  Nature Of Call: N  RP SEES 1-3 FT FLAMES  DIDN'T ACTUALLY SEE FLAMES  ON THE 2012-00002065",

        "CALL:F BRUSH (NT)",
        "ADDR:MEADOWS PKWY & N  US HIGHWAY 85 N",
        "MADDR:MEADOWS PKWY & N  US 85 N",
        "MAP:AF29D",
        "DATE:07/05/12",
        "TIME:15:28",
        "INFO:ABOUT 20X10FT ON FIRE / N  RP SEES 1-3 FT FLAMES  DIDN'T ACTUALLY SEE FLAMES  ON THE",
        "ID:2012-00002065");

    doTest("T26",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 6:07:16 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 6:07:14 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 1548 SUNCREST RD / Map: AH32C Units: E153 MED151 XXX153  CLIFF VIEW CT, WILD BLOSSOM WAY / WILD STAR WAY, BLACK PINE DR Common Name: Time: 07/05/12 18:06 Narrative:  80 YOF/FELL FROM STANDING,C AND B  2012-00002066",

        "CALL:F MED ASSIST",
        "ADDR:1548 SUNCREST RD",
        "MAP:AH32C",
        "UNIT:E153 MED151 XXX153",
        "X:CLIFF VIEW CT, WILD BLOSSOM WAY / WILD STAR WAY, BLACK PINE DR",
        "DATE:07/05/12",
        "TIME:18:06",
        "INFO:80 YOF/FELL FROM STANDING,C AND B",
        "ID:2012-00002066");

    doTest("T27",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 7:48:19 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 7:48:17 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 403 N  PERRY ST / Map: AI30A Units: E151 MED151 XXX152  FOURTH ST / FIFTH ST Common Name: REYN ROCK ASSISTED LIVING 403 PERRY STTime: 07/05/12 19:47 Narrative:  2012-00002068",

        "CALL:F MED ASSIST",
        "ADDR:403 N  PERRY ST",  // Google knows this as PERRY ST
        "MAP:AI30A",
        "UNIT:E151 MED151 XXX152",
        "X:FOURTH ST / FIFTH ST",
        "PLACE:REYN ROCK ASSISTED LIVING 403 PERRY ST",
        "DATE:07/05/12",
        "TIME:19:47",
        "ID:2012-00002068");

    doTest("T28",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 8:01:34 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 8:01:32 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 383 E ALLEN ST 21 / Map: AF30C2 Units: Q155 MED154 XXX155  METZLER WAY / REID TRL Common Name: Time: 07/05/12 20:00 Narrative:  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002069",

        "CALL:F MED ASSIST",
        "ADDR:383 E ALLEN ST 21",
        "MAP:AF30C2",
        "UNIT:Q155 MED154 XXX155",
        "X:METZLER WAY / REID TRL",
        "DATE:07/05/12",
        "TIME:20:00",
        "INFO:Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE",
        "ID:2012-00002069");

    doTest("T29",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 8:59:04 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 8:59:02 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 1080 HIGHLAND BLUFF DR 3101 / Map: AH29D2 Units: E154 MED154 XXX154  HIGHLAND RIDGE WAY / AUBURN DR, MILLBROOK CIR Common Name: Time: 07/05/12 20:58 Narrative:  E911 Info - Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002070",

        "CALL:F MED ASSIST",
        "ADDR:1080 HIGHLAND BLUFF DR 3101",
        "MAP:AH29D2",
        "UNIT:E154 MED154 XXX154",
        "X:HIGHLAND RIDGE WAY / AUBURN DR, MILLBROOK CIR",
        "DATE:07/05/12",
        "TIME:20:58",
        "INFO:Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE",
        "ID:2012-00002070");

    doTest("T30",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Thursday, July 05, 2012 9:59:09 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Thursday, July 05, 2012 9:59:07 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 645 SPRINGVALE RD / Map: AI34C Units: E153 MED151 XXX153  GARDNER ST / TURNSTONE AVE Common Name: Time: 07/05/12 21:58 Narrative:  FEM IS ON HER SIDE  GASPING FOR AIR  LIPS ARE BLUE  FEM DROOLING OUT OF HER MOUTH/IS BREATHING  E91 2012-00002071",

        "CALL:F MED ASSIST",
        "ADDR:645 SPRINGVALE RD",
        "MAP:AI34C",
        "UNIT:E153 MED151 XXX153",
        "X:GARDNER ST / TURNSTONE AVE",
        "DATE:07/05/12",
        "TIME:21:58",
        "INFO:FEM IS ON HER SIDE  GASPING FOR AIR  LIPS ARE BLUE  FEM DROOLING OUT OF HER MOUTH/IS BREATHING  E91",
        "ID:2012-00002071");

    doTest("T31",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 1:16:00 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 1:15:58 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 645 SPRINGVALE RD / Map: AI34C Units: E153 MED151 XXX153  GARDNER ST / TURNSTONE AVE Common Name: Time: 07/06/12 01:15 Narrative:  35yof/SEISURES  E911 Info - Class of Service: RESD Special Response Info: PSAP=CRPD CRPD  CASTLE RO 2012-00002072",

        "CALL:F MED ASSIST",
        "ADDR:645 SPRINGVALE RD",
        "MAP:AI34C",
        "UNIT:E153 MED151 XXX153",
        "X:GARDNER ST / TURNSTONE AVE",
        "DATE:07/06/12",
        "TIME:01:15",
        "INFO:35yof/SEISURES  Class of Service: RESD Special Response Info: PSAP=CRPD CRPD  CASTLE RO",
        "ID:2012-00002072");

    doTest("T32",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 2:01:46 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 2:01:43 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F CO ALA NO SYMP Location: 5825 E PALMER DR / Map: AH33D Units: E153 XXX153  N BURLINGTON DR / N TABOR DR Common Name: Time: 07/06/12 02:00 Narrative:  NO SYMPTOMS  CO ALA WAS GOING OFF  2012-00002073",

        "CALL:F CO ALA NO SYMP",
        "ADDR:5825 E PALMER DR",
        "MAP:AH33D",
        "UNIT:E153 XXX153",
        "X:N BURLINGTON DR / N TABOR DR",
        "DATE:07/06/12",
        "TIME:02:00",
        "INFO:NO SYMPTOMS  CO ALA WAS GOING OFF",
        "ID:2012-00002073");

    doTest("T33",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 6:33:02 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 6:33:00 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F COMMERCIAL ALA Location: 1354 PARK ST / Map: AH30C Units: E151 E154 XXX151  MALIBU ST / PARK CT Common Name: CASTLE ACADEMY 1354 N PARK STTime: 07/06/12 06:32 Narrative:  2012-00002074",

        "CALL:F COMMERCIAL ALA",
        "ADDR:1354 PARK ST",
        "MAP:AH30C",
        "UNIT:E151 E154 XXX151",
        "X:MALIBU ST / PARK CT",
        "PLACE:CASTLE ACADEMY 1354 N PARK ST",
        "DATE:07/06/12",
        "TIME:06:32",
        "ID:2012-00002074");

    doTest("T34",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 9:01:44 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 9:01:41 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 3950 LAZY K DR / Map: AG30B Units: Q155 MED154 XXX155  BLACK FEATHER TRL / STAMPEDE DR Common Name: Time: 07/06/12 09:01 Narrative:  SPANISH SPEAKER ONLY/SAYING NEEDS AMBULANCE/UNKWN PROBLEM  2012-00002075",

        "CALL:F MED ASSIST",
        "ADDR:3950 LAZY K DR",
        "MAP:AG30B",
        "UNIT:Q155 MED154 XXX155",
        "X:BLACK FEATHER TRL / STAMPEDE DR",
        "DATE:07/06/12",
        "TIME:09:01",
        "INFO:SPANISH SPEAKER ONLY/SAYING NEEDS AMBULANCE/UNKWN PROBLEM",
        "ID:2012-00002075");

    doTest("T35",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 9:06:20 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 9:06:16 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F BRUSH (T) Location: 10625 NEVINS PT / EOPS3 Map: BI66 Units: XXX211  FUNK RD / DEAD END Common Name: Time: 07/06/12 09:02 Narrative:  REQ SIMLA FD  Nature Of Call: EOPS3  RESPONDING WITH CALAHN  AND TRI COUNTY  GRASS FIRE NEAR HOUSE  2012-00001030",

        "CALL:F BRUSH (T)",
        "ADDR:10625 NEVINS PT",
        "CH:EOPS3",
        "MAP:BI66",
        "UNIT:XXX211",
        "X:FUNK RD / DEAD END",
        "DATE:07/06/12",
        "TIME:09:02",
        "INFO:REQ SIMLA FD / RESPONDING WITH CALAHN  AND TRI COUNTY  GRASS FIRE NEAR HOUSE",
        "ID:2012-00001030");

    doTest("T36",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 11:25:03 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 11:25:01 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 1020 PARK ST / Map: AH30C Units: E151 MED151 XXX152  WOLFENSBERGER RD / MALIBU ST Common Name: SUPER 8 MOTEL 1020 N PARK STTime: 07/06/12 11:24 Narrative:  2012-00002076",

        "CALL:F MED ASSIST",
        "ADDR:1020 PARK ST",
        "MAP:AH30C",
        "UNIT:E151 MED151 XXX152",
        "X:WOLFENSBERGER RD / MALIBU ST",
        "PLACE:SUPER 8 MOTEL 1020 N PARK ST",
        "DATE:07/06/12",
        "TIME:11:24",
        "ID:2012-00002076");

    doTest("T37",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 11:56:17 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 11:56:12 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 94 N BEDFORD AVE / Map: AI33B Units: E153 MED151 XXX153  CALEY LN / WHITECHAPEL ST Common Name: Time: 07/06/12 11:55 Narrative:  E911 Info - Class of Service: RESD Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FIRE  2012-00002077",

        "CALL:F MED ASSIST",
        "ADDR:94 N BEDFORD AVE",
        "MAP:AI33B",
        "UNIT:E153 MED151 XXX153",
        "X:CALEY LN / WHITECHAPEL ST",
        "DATE:07/06/12",
        "TIME:11:55",
        "INFO:Class of Service: RESD Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FIRE",
        "ID:2012-00002077");

    doTest("T38",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 12:09:09 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 12:09:05 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F COMMERCIAL ALA Location: 5050 FACTORY SHOPS BLVD / Map: AF29B1 Units: E154 Q155 XXX154  NEW BEALE ST / N CASTLETON DR, MEADOWS PKWY Common Name: Time: 07/06/12 12:07 Narrative:  OPER LOGAN - WESTERN STATES - 877-206-9141  SHOWING GENERAL FIRE ALARM  FOOD COURT  2012-00002078",

        "CALL:F COMMERCIAL ALA",
        "ADDR:5050 FACTORY SHOPS BLVD",
        "MAP:AF29B1",
        "UNIT:E154 Q155 XXX154",
        "X:NEW BEALE ST / N CASTLETON DR, MEADOWS PKWY",
        "DATE:07/06/12",
        "TIME:12:07",
        "INFO:OPER LOGAN - WESTERN STATES - 877-206-9141  SHOWING GENERAL FIRE ALARM  FOOD COURT",
        "ID:2012-00002078");

    doTest("T39",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 12:17:44 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 12:17:37 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 3 OAKWOOD PARK / Map: AH30D Units: MED151 XXX151  SUNSET DR / SUNSET DR Common Name: CASTLE ROCK MEDICAL CLINIC 3 OAKWOOD PARKTime: 07/06/12 12:17 Narrative:  FEELS DIZZY VOMITING  77 YOM CON BREATHING  E911 Info - Class of Service: CNTX Special Response Inf 2012-00002079",

        "CALL:F MED ASSIST",
        "ADDR:3 OAKWOOD PARK",
        "MAP:AH30D",
        "UNIT:MED151 XXX151",
        "X:SUNSET DR / SUNSET DR",
        "PLACE:CASTLE ROCK MEDICAL CLINIC",
        "DATE:07/06/12",
        "TIME:12:17",
        "INFO:FEELS DIZZY VOMITING  77 YOM CON BREATHING  Class of Service: CNTX Special Response Inf",
        "ID:2012-00002079");

    doTest("T40",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 12:45:50 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 12:45:46 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 129 S PEMBROOK ST / Map: AI33C Units: E153 MED151 XXX153  CASCADE AVE / E BARRINGTON AVE Common Name: Time: 07/06/12 12:45 Narrative:  E911 Info - Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002080",

        "CALL:F MED ASSIST",
        "ADDR:129 S PEMBROOK ST",
        "MAP:AI33C",
        "UNIT:E153 MED151 XXX153",
        "X:CASCADE AVE / E BARRINGTON AVE",
        "DATE:07/06/12",
        "TIME:12:45",
        "INFO:Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE",
        "ID:2012-00002080");

    doTest("T41",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 2:40:16 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 2:40:11 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F BRUSH (NT) Location: / WOF JELLYSTONE Map: AQ28B Units:  SPRUCE MOUNTAIN RD / INTERSTATE 25 FRONTAGE Common Name: I25 MM173 NBTime: 07/06/12 14:33 Narrative:  B165 HEAVY SMOKE SHOWING 1 MILE OUT / URBAN INTERFACE FIRE  2ND RP/SAW LIGHTNING HIT AND SMOKE STAR 2012-00000390",

        "CALL:F BRUSH (NT)",
        "ADDR:WOF JELLYSTONE",
        "MADDR:I25 MM173 NB,WOF JELLYSTONE",
        "MAP:AQ28B",
        "UNIT:SPRUCE MOUNTAIN RD / INTERSTATE 25 FRONTAGE",
        "PLACE:I25 MM173 NB",
        "DATE:07/06/12",
        "TIME:14:33",
        "INFO:B165 HEAVY SMOKE SHOWING 1 MILE OUT / URBAN INTERFACE FIRE  2ND RP/SAW LIGHTNING HIT AND SMOKE STAR",
        "ID:2012-00000390");

    doTest("T42",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 3:49:40 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 3:49:38 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F LIGHTNING Location: 3471 BEAR CANYON CIR / Map: AJ25D Units: XXX141 MED151 XXX154  CHRISTY RIDGE RD / CHRISTY RIDGE RD Common Name: Time: 07/06/12 15:48 Narrative:  WOOD STOVE  SMOKE COMING FROM WINDOWS AND FROM STOVE ITSELF  E911 Info - Class of Service: WPH2 Spe 2012-00000084",

        "CALL:F LIGHTNING",
        "ADDR:3471 BEAR CANYON CIR",
        "MAP:AJ25D",
        "UNIT:XXX141 MED151 XXX154",
        "X:CHRISTY RIDGE RD / CHRISTY RIDGE RD",
        "DATE:07/06/12",
        "TIME:15:48",
        "INFO:WOOD STOVE  SMOKE COMING FROM WINDOWS AND FROM STOVE ITSELF  Class of Service: WPH2 Spe",
        "ID:2012-00000084");

    doTest("T43",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 3:53:24 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 3:53:20 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F RES ALA Location: 3951 EVENINGGLOW WAY / Map: AK30D Units: E151 E154 XXX152  CRYSTAL VALLEY PKWY, STARSTONE LN / EVENINGSONG DR Common Name: Time: 07/06/12 15:48 Narrative:  2012-00002083",

        "CALL:F RES ALA",
        "ADDR:3951 EVENINGGLOW WAY",
        "MAP:AK30D",
        "UNIT:E151 E154 XXX152",
        "X:CRYSTAL VALLEY PKWY, STARSTONE LN / EVENINGSONG DR",
        "DATE:07/06/12",
        "TIME:15:48",
        "ID:2012-00002083");

    doTest("T44",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 4:02:29 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 4:02:26 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F COMMERCIAL ALA Location: 1297 S  PERRY ST / Map: AJ30A Units: E154 E153 XXX151  RIO GRANDE DR / INTERSTATE 25 FRONTAGE Common Name: BROOKSIDE INN 1297 S PERRY STTime: 07/06/12 16:01 Narrative:  GENERAL FIRE ALARM  2012-00002084",

        "CALL:F COMMERCIAL ALA",
        "ADDR:1297 S  PERRY ST",
        "MAP:AJ30A",
        "UNIT:E154 E153 XXX151",
        "X:RIO GRANDE DR / INTERSTATE 25 FRONTAGE",
        "PLACE:BROOKSIDE INN 1297 S PERRY ST",
        "DATE:07/06/12",
        "TIME:16:01",
        "INFO:GENERAL FIRE ALARM",
        "ID:2012-00002084");

    doTest("T45",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 4:26:50 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 4:26:47 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F LIGHTNING Location: 35 PEABODY ST / Map: AI34A Units: E153 E151 XXX153  GROVETON AVE / STOCKWELL ST Common Name: Time: 07/06/12 16:26 Narrative:  E911 Info - Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002085",

        "CALL:F LIGHTNING",
        "ADDR:35 PEABODY ST",
        "MAP:AI34A",
        "UNIT:E153 E151 XXX153",
        "X:GROVETON AVE / STOCKWELL ST",
        "DATE:07/06/12",
        "TIME:16:26",
        "INFO:Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE",
        "ID:2012-00002085");

    doTest("T46",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 4:29:11 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 4:29:08 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F LIGHTNING Location: 122 ELM AVE / Map: AJ31A Units: E154 Q155 XXX152  PARK DR / SELLERS DR Common Name: Time: 07/06/12 16:27 Narrative:  RP CAN SMELL SMOKE WHEN SHE GOES TO HER WINDOW  2012-00002086",

        "CALL:F LIGHTNING",
        "ADDR:122 ELM AVE",
        "MAP:AJ31A",
        "UNIT:E154 Q155 XXX152",
        "X:PARK DR / SELLERS DR",
        "DATE:07/06/12",
        "TIME:16:27",
        "INFO:RP CAN SMELL SMOKE WHEN SHE GOES TO HER WINDOW",
        "ID:2012-00002086");

    doTest("T47",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 4:46:15 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 4:46:13 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F LIGHTNING Location: 1711 WILD RYE CT / Map: AH29C Units: E151 Q155 XXX154  DEAD END / THATCH CIR Common Name: Time: 07/06/12 16:45 Narrative:  DO NOT SEE OR SMELL ANYTHING  2012-00002087",

        "CALL:F LIGHTNING",
        "ADDR:1711 WILD RYE CT",
        "MAP:AH29C",
        "UNIT:E151 Q155 XXX154",
        "X:DEAD END / THATCH CIR",
        "DATE:07/06/12",
        "TIME:16:45",
        "INFO:DO NOT SEE OR SMELL ANYTHING",
        "ID:2012-00002087");

    doTest("T48",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 4:59:21 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 4:59:18 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F LIGHTNING Location: 4378 W SAWMILL CT / Map: AF27D Units: E154 Q155 XXX154  DEAD END / S ROCK CREEK DR Common Name: Time: 07/06/12 16:58 Narrative:  2012-00002088",

        "CALL:F LIGHTNING",
        "ADDR:4378 W SAWMILL CT",
        "MAP:AF27D",
        "UNIT:E154 Q155 XXX154",
        "X:DEAD END / S ROCK CREEK DR",
        "DATE:07/06/12",
        "TIME:16:58",
        "ID:2012-00002088");

    doTest("T49",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 5:00:15 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 5:00:13 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MVA UNK INJ Location: / Map: AH30C Units: E39 MED151 XXX151  N INTERSTATE 25 / N INTERSTATE 25 Common Name: I25 MM182 NBTime: 07/06/12 16:57 Narrative:  CHEST HURTS/KNEE HURTS  SEES SMOKE BUT THINKS ITS FROM THE AIRBAGS DEPLOYING  AIRBAGS DEPLOYED/RP T 2012-00001041",

        "CALL:F MVA UNK INJ",
        "MAP:AH30C",
        "UNIT:E39 MED151 XXX151",
        "X:N INTERSTATE 25 / N INTERSTATE 25",
        "PLACE:I25 MM182 NB",
        "DATE:07/06/12",
        "TIME:16:57",
        "INFO:CHEST HURTS/KNEE HURTS  SEES SMOKE BUT THINKS ITS FROM THE AIRBAGS DEPLOYING  AIRBAGS DEPLOYED/RP T",
        "ID:2012-00001041");

    doTest("T50",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 5:13:53 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 5:13:51 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F RES STRUC Location: 4378 W SAWMILL CT / Y Map: AF27D Units:  DEAD END / S ROCK CREEK DR Common Name: Time: 07/06/12 16:58 Narrative:  CMD 2 ST/NO SHOW/NO EVAC/OPS5/SAWMILL CMD  RP IS GOING TO WAIT IN HOUSE  Nature Of Call: Y  SAW A L 2012-00002088",

        "CALL:F RES STRUC",
        "ADDR:4378 W SAWMILL CT & Y",
        "MADDR:4378 W SAWMILL CT",
        "MAP:AF27D",
        "UNIT:DEAD END / S ROCK CREEK DR",
        "DATE:07/06/12",
        "TIME:16:58",
        "INFO:CMD 2 ST/NO SHOW/NO EVAC/OPS5/SAWMILL CMD  RP IS GOING TO WAIT IN HOUSE / Y  SAW A L",
        "ID:2012-00002088");

    doTest("T51",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 5:14:13 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 5:14:11 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F RES STRUC Location: 4378 W SAWMILL CT / Y Map: AF27D Units: E39 MED154 BA151 DVC151 XXX154  DEAD END / S ROCK CREEK DR Common Name: Time: 07/06/12 16:58 Narrative:  SAWMILL / UPGRADE  CMD 2 ST/NO SHOW/NO EVAC/OPS5/SAWMILL CMD  RP IS GOING TO WAIT IN HOUSE  Nature  2012-00002088",

        "CALL:F RES STRUC",
        "ADDR:4378 W SAWMILL CT & Y",
        "MADDR:4378 W SAWMILL CT",
        "MAP:AF27D",
        "UNIT:E39 MED154 BA151 DVC151 XXX154",
        "X:DEAD END / S ROCK CREEK DR",
        "DATE:07/06/12",
        "TIME:16:58",
        "INFO:SAWMILL / UPGRADE  CMD 2 ST/NO SHOW/NO EVAC/OPS5/SAWMILL CMD  RP IS GOING TO WAIT IN HOUSE",
        "ID:2012-00002088");

    doTest("T52",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 5:25:01 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 5:24:59 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F LIGHTNING Location: 2951 CLIFF VIEW CT / Map: AH31D Units: E153 E151 XXX153  DEAD END / SUNCREST RD, WILD BLOSSOM WAY Common Name: Time: 07/06/12 17:24 Narrative:  HOUSE HIT BY LIGHTENING  2012-00002090",

        "CALL:F LIGHTNING",
        "ADDR:2951 CLIFF VIEW CT",
        "MAP:AH31D",
        "UNIT:E153 E151 XXX153",
        "X:DEAD END / SUNCREST RD, WILD BLOSSOM WAY",
        "DATE:07/06/12",
        "TIME:17:24",
        "INFO:HOUSE HIT BY LIGHTENING",
        "ID:2012-00002090");

    doTest("T53",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 5:28:06 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 5:28:03 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MVA UNK INJ Location: / Map: AI30C Units: E39 MED151 XXX152  S INTERSTATE 25, N INTERSTATE 25 / S INTERSTATE 25 Common Name: I25 MM181 NBTime: 07/06/12 17:26 Narrative:  2 VEH INVOLVED  NO INJURIES  BLOCKING FAR LEFT LANE  2012-00001043",

        "CALL:F MVA UNK INJ",
        "MAP:AI30C",
        "UNIT:E39 MED151 XXX152",
        "X:S INTERSTATE 25, N INTERSTATE 25 / S INTERSTATE 25",
        "PLACE:I25 MM181 NB",
        "DATE:07/06/12",
        "TIME:17:26",
        "INFO:2 VEH INVOLVED  NO INJURIES  BLOCKING FAR LEFT LANE",
        "ID:2012-00001043");

    doTest("T54",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 5:57:22 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 5:57:20 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F BRUSH (T) Location: 13687 WILDERNESS DR / EOPS1\n" +
        " Map: AM54 Units: XXX221 XXX271  RANGE VEIW PL / HAWKEYE RD Common Name: Time: 07/06/12 17:54 Narrative:  Nature Of Call: EOPS1  FROM A LIGHTNING STRIKE  ABOUT 100YARDS FROM THE HSE  2012-00000138",

        "CALL:F BRUSH (T)",
        "ADDR:13687 WILDERNESS DR",
        "CH:EOPS1",
        "MAP:AM54",
        "UNIT:XXX221 XXX271",
        "X:RANGE VEIW PL / HAWKEYE RD",
        "DATE:07/06/12",
        "TIME:17:54",
        "INFO:FROM A LIGHTNING STRIKE  ABOUT 100YARDS FROM THE HSE",
        "ID:2012-00000138");

    doTest("T55",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 8:09:44 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 8:09:42 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F COMMERCIAL ALA Location: 1100 E PLUM CREEK PKWY / Map: AJ30B3 Units: E151 E154 XXX151  EMERALD DR / FAIRGROUNDS DR Common Name: THE LINKS APARTMENTS 1100 PLUM CREEK PKWYTime: 07/06/12 20:09 Narrative:  2012-00002092",

        "CALL:F COMMERCIAL ALA",
        "ADDR:1100 E PLUM CREEK PKWY",
        "MAP:AJ30B3",
        "UNIT:E151 E154 XXX151",
        "X:EMERALD DR / FAIRGROUNDS DR",
        "PLACE:THE LINKS APARTMENTS 1100 PLUM CREEK PKWY",
        "DATE:07/06/12",
        "TIME:20:09",
        "ID:2012-00002092");

    doTest("T56",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Friday, July 06, 2012 10:11:22 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Friday, July 06, 2012 10:11:20 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F CO ALA NO SYMP Location: 1947 AMBER SUN CT / Map: AH32A Units: E153 XXX153  DEAD END / AMBER SUN CIR Common Name: Time: 07/06/12 22:10 Narrative:  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002093",

        "CALL:F CO ALA NO SYMP",
        "ADDR:1947 AMBER SUN CT",
        "MAP:AH32A",
        "UNIT:E153 XXX153",
        "X:DEAD END / AMBER SUN CIR",
        "DATE:07/06/12",
        "TIME:22:10",
        "INFO:Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE",
        "ID:2012-00002093");

    doTest("T57",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 12:02:15 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 12:02:13 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 481 OMAN RD F / Map: AI30D2 Units: E151 MED151 XXX152  S GILBERT ST / SOUTH ST Common Name: Time: 07/07/12 00:01 Narrative:  49YOF/C&B/MEDICAL EVAL  2012-00002094",

        "CALL:F MED ASSIST",
        "ADDR:481 OMAN RD F",
        "MAP:AI30D2",
        "UNIT:E151 MED151 XXX152",
        "X:S GILBERT ST / SOUTH ST",
        "DATE:07/07/12",
        "TIME:00:01",
        "INFO:49YOF/C&B/MEDICAL EVAL",
        "ID:2012-00002094");

    doTest("T58",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 1:48:49 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 1:47:33 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 579 OAKWOOD DR 3 / Map: AH30B Units: E151 MED151 XXX151  MOUNTAIN VIEW, BARBI CT / FRONT ST Common Name: Time: 07/07/12 01:47 Narrative:  104.5  RPS HUSB JUST WOKE UP W/ A HIGH FEVER  E911 Info - Class of Service: VOIP Special Response I 2012-00002095",

        "CALL:F MED ASSIST",
        "ADDR:579 OAKWOOD DR 3",
        "MAP:AH30B",
        "UNIT:E151 MED151 XXX151",
        "X:MOUNTAIN VIEW, BARBI CT / FRONT ST",
        "DATE:07/07/12",
        "TIME:01:47",
        "INFO:104.5  RPS HUSB JUST WOKE UP W/ A HIGH FEVER  Class of Service: VOIP Special Response I",
        "ID:2012-00002095");

    doTest("T59",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 2:22:07 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 2:08:51 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 1461 FAIRFAX CT / Map: AJ33B Units: E153 MED154 XXX153  MIDDLETON AVE / DEAD END Common Name: Time: 07/07/12 02:08 Narrative:  E911 Info - Class of Service: RESD Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FIRE  2012-00002096",

        "CALL:F MED ASSIST",
        "ADDR:1461 FAIRFAX CT",
        "MAP:AJ33B",
        "UNIT:E153 MED154 XXX153",
        "X:MIDDLETON AVE / DEAD END",
        "DATE:07/07/12",
        "TIME:02:08",
        "INFO:Class of Service: RESD Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FIRE",
        "ID:2012-00002096");

    doTest("T60",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 5:23:38 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 5:23:34 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F RES ALA Location: 2490 TRAILBLAZER WAY / Map: AH28A Units: E154 E151 XXX154  BROADLEAF LOOP / BELLAVISTA ST Common Name: Time: 07/07/12 05:22 Narrative:  RP CANNOT SEE SMOKE OR FLAMES//HAS BEEN SOUNDING FOR ABOUT 10 MINS  E911 Info - Class of Service: R 2012-00002097",

        "CALL:F RES ALA",
        "ADDR:2490 TRAILBLAZER WAY",
        "MAP:AH28A",
        "UNIT:E154 E151 XXX154",
        "X:BROADLEAF LOOP / BELLAVISTA ST",
        "DATE:07/07/12",
        "TIME:05:22",
        "INFO:RP CANNOT SEE SMOKE OR FLAMES//HAS BEEN SOUNDING FOR ABOUT 10 MINS  Class of Service: R",
        "ID:2012-00002097");

    doTest("T61",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 6:41:22 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 6:41:20 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 102 BALDWIN RANCH RD / Map: AJ31A Units: E151 MED151 XXX152  S GILBERT ST / BALDWIN CT Common Name: Time: 07/07/12 06:40 Narrative:  50YOF/SICK CASE/CON AND BRE  E911 Info - Class of Service: RESD Special Response Info: PSAP=CRPD CR 2012-00002098",

        "CALL:F MED ASSIST",
        "ADDR:102 BALDWIN RANCH RD",
        "MAP:AJ31A",
        "UNIT:E151 MED151 XXX152",
        "X:S GILBERT ST / BALDWIN CT",
        "DATE:07/07/12",
        "TIME:06:40",
        "INFO:50YOF/SICK CASE/CON AND BRE  Class of Service: RESD Special Response Info: PSAP=CRPD CR",
        "ID:2012-00002098");

    doTest("T62",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 9:58:13 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 9:58:11 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F LIGHTNING Location: 5185 S MEADOW LARK DR / Map: AF27D Units: E154 Q155 XXX154  BOBOLINK CT, BOBOLINK DR / APACHE CREEK RD Common Name: Time: 07/07/12 09:57 Narrative:  2012-00002099",

        "CALL:F LIGHTNING",
        "ADDR:5185 S MEADOW LARK DR",
        "MAP:AF27D",
        "UNIT:E154 Q155 XXX154",
        "X:BOBOLINK CT, BOBOLINK DR / APACHE CREEK RD",
        "DATE:07/07/12",
        "TIME:09:57",
        "ID:2012-00002099");

    doTest("T63",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 10:42:13 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 10:42:10 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MVA UNK INJ Location: WOLFENSBERGER RD / PARK ST Map: AH30C Units: E151 MED151 XXX151  Common Name: Time: 07/07/12 10:41 Narrative:  2012-00002100",

        "CALL:F MVA UNK INJ",
        "ADDR:WOLFENSBERGER RD & PARK ST",
        "MAP:AH30C",
        "UNIT:E151 MED151 XXX151",
        "DATE:07/07/12",
        "TIME:10:41",
        "ID:2012-00002100");

    doTest("T64",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 10:42:15 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 10:42:13 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MVA INJ Location: WOLFENSBERGER RD / PARK ST Map: AH30C Units:  Common Name: Time: 07/07/12 10:41 Narrative:  2012-00002100",

        "CALL:F MVA INJ",
        "ADDR:WOLFENSBERGER RD & PARK ST",
        "MAP:AH30C",
        "DATE:07/07/12",
        "TIME:10:41",
        "ID:2012-00002100");

    doTest("T65",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 11:05:21 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 11:05:17 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 6285 SAPPHIRE POINTE BLVD / Map: AE31C Units: Q155 MED154 XXX155  DEAD END / MARBLE LN Common Name: Time: 07/07/12 11:05 Narrative:  E911 Info - Class of Service: RESD Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FIRE  2012-00002101",

        "CALL:F MED ASSIST",
        "ADDR:6285 SAPPHIRE POINTE BLVD",
        "MAP:AE31C",
        "UNIT:Q155 MED154 XXX155",
        "X:DEAD END / MARBLE LN",
        "DATE:07/07/12",
        "TIME:11:05",
        "INFO:Class of Service: RESD Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FIRE",
        "ID:2012-00002101");

    doTest("T66",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 12:11:38 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 12:11:36 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F LIGHTNING Location: 4422 ANDOVER AVE / Map: AI32D Units: E153 E151 XXX153  BENNINGTON AVE / BENNINGTON AVE Common Name: Time: 07/07/12 12:11 Narrative:  2012-00002102",

        "CALL:F LIGHTNING",
        "ADDR:4422 ANDOVER AVE",
        "MAP:AI32D",
        "UNIT:E153 E151 XXX153",
        "X:BENNINGTON AVE / BENNINGTON AVE",
        "DATE:07/07/12",
        "TIME:12:11",
        "ID:2012-00002102");

    doTest("T67",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 2:15:01 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 2:14:59 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 1656 MARSH HAWK CIR / Map: AH29D Units: E154 MED154 XXX154  SURLYN CT / THATCH CIR Common Name: Time: 07/07/12 14:14 Narrative:  E911 Info - Class of Service: RESD Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FIRE  2012-00002103",

        "CALL:F MED ASSIST",
        "ADDR:1656 MARSH HAWK CIR",
        "MAP:AH29D",
        "UNIT:E154 MED154 XXX154",
        "X:SURLYN CT / THATCH CIR",
        "DATE:07/07/12",
        "TIME:14:14",
        "INFO:Class of Service: RESD Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FIRE",
        "ID:2012-00002103");

    doTest("T68",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 2:30:08 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 2:30:05 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MVA INJ Location: 4000 JUSTICE WAY / Map: AG30A Units: E154 MED154 XXX154  CASTLETON CT / HIGHWAY 85 Common Name: PD DOUGLAS COUNTY SHERIFF'S OFFICETime: 07/07/12 14:29 Narrative:  FEM INJURED IN ACCIDENT IN PLOT  2012-00002104",

        "CALL:F MVA INJ",
        "ADDR:4000 JUSTICE WAY",
        "MAP:AG30A",
        "UNIT:E154 MED154 XXX154",
        "X:CASTLETON CT / HIGHWAY 85",
        "PLACE:PD DOUGLAS COUNTY SHERIFF'S OFFICE",
        "DATE:07/07/12",
        "TIME:14:29",
        "INFO:FEM INJURED IN ACCIDENT IN PLOT",
        "ID:2012-00002104");

    doTest("T69",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 4:30:12 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 4:30:00 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F RES ALA Location: 177 CHENEY PL / Map: AK30A Units: E151 E154 XXX152  DEAD END / PLUM CREEK BLVD Common Name: Time: 07/07/12 16:29 Narrative:  2012-00002105",

        "CALL:F RES ALA",
        "ADDR:177 CHENEY PL",
        "MAP:AK30A",
        "UNIT:E151 E154 XXX152",
        "X:DEAD END / PLUM CREEK BLVD",
        "DATE:07/07/12",
        "TIME:16:29",
        "ID:2012-00002105");

    doTest("T70",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 4:35:05 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 4:35:02 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F EXPLOSION NO FIRE Location: E PLUM CREEK PKWY / S  GILBERT ST Map: AJ31A Units: Q155 E153 E154 MED151 BA151 DVC151 XXX151  Common Name: Time: 07/07/12 16:32 Narrative:  TRANSFORMER EXPLODED  2012-00002106",

        "CALL:F EXPLOSION NO FIRE",
        "ADDR:E PLUM CREEK PKWY & S  GILBERT ST",
        "MAP:AJ31A",
        "UNIT:Q155 E153 E154 MED151 BA151 DVC151 XXX151",
        "DATE:07/07/12",
        "TIME:16:32",
        "INFO:TRANSFORMER EXPLODED",
        "ID:2012-00002106");

    doTest("T71",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 4:46:52 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 4:46:47 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F ALA RESET Location: 1604 ROSEMARY CT / Map: AH29A Units: E154 XXX154  DEAD END / ROSEMARY DR Common Name: Time: 07/07/12 16:45 Narrative:  DOES NOT SMELL ANY SMOKE OR SEE ANYFLAMES  RP DOES NOT THINK THE HOUSE WAS HIT BY LIGHTENING  ALL F 2012-00002107",

        "CALL:F ALA RESET",
        "ADDR:1604 ROSEMARY CT",
        "MAP:AH29A",
        "UNIT:E154 XXX154",
        "X:DEAD END / ROSEMARY DR",
        "DATE:07/07/12",
        "TIME:16:45",
        "INFO:DOES NOT SMELL ANY SMOKE OR SEE ANYFLAMES  RP DOES NOT THINK THE HOUSE WAS HIT BY LIGHTENING  ALL F",
        "ID:2012-00002107");

    doTest("T72",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 5:10:29 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 5:10:26 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F GAS LP OUTSIDE Location: CROWFOOT VALLEY RD / DIAMOND RIDGE PKWY Map: AF31A Units: Q155 E151 XXX155  Common Name: Time: 07/07/12 17:09 Narrative:  OVERWHELMING SMELL OF NAT GAS AT INT  2012-00002108",

        "CALL:F GAS LP OUTSIDE",
        "ADDR:CROWFOOT VALLEY RD & DIAMOND RIDGE PKWY",
        "MAP:AF31A",
        "UNIT:Q155 E151 XXX155",
        "DATE:07/07/12",
        "TIME:17:09",
        "INFO:OVERWHELMING SMELL OF NAT GAS AT INT",
        "ID:2012-00002108");

    doTest("T73",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 5:32:38 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 5:32:34 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MEDICAL ALA Location: 988 EATON ST / Map: AJ31B Units: E151 MED151 XXX152  SANDHURST DR / BEACHAM DR Common Name: Time: 07/07/12 17:32 Narrative:  2012-00002109",

        "CALL:F MEDICAL ALA",
        "ADDR:988 EATON ST",
        "MAP:AJ31B",
        "UNIT:E151 MED151 XXX152",
        "X:SANDHURST DR / BEACHAM DR",
        "DATE:07/07/12",
        "TIME:17:32",
        "ID:2012-00002109");

    doTest("T74",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 6:31:11 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 6:31:07 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 479 BLACK FEATHER LOOP / Map: AG30A Units: Q155 MED154 XXX155  FRONT ST / BLACK FEATHER TRL, TRAIL BOSS LN Common Name: Time: 07/07/12 18:30 Narrative:  2012-00002110",

        "CALL:F MED ASSIST",
        "ADDR:479 BLACK FEATHER LOOP",
        "MAP:AG30A",
        "UNIT:Q155 MED154 XXX155",
        "X:FRONT ST / BLACK FEATHER TRL, TRAIL BOSS LN",
        "DATE:07/07/12",
        "TIME:18:30",
        "ID:2012-00002110");

    doTest("T75",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 6:51:37 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 6:51:35 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 958 OAKWOOD DR / Map: AH30D Units: E151 MED151 XXX151  CANYON DR / PARK VIEW PL Common Name: Time: 07/07/12 18:51 Narrative:  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002111",

        "CALL:F MED ASSIST",
        "ADDR:958 OAKWOOD DR",
        "MAP:AH30D",
        "UNIT:E151 MED151 XXX151",
        "X:CANYON DR / PARK VIEW PL",
        "DATE:07/07/12",
        "TIME:18:51",
        "INFO:Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE",
        "ID:2012-00002111");

    doTest("T76",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Saturday, July 07, 2012 7:21:54 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Saturday, July 07, 2012 7:21:51 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MVA UNK INJ Location: / NB Map: AH30C Units: E151 MED154 XXX152  N WILCOX ST, WOLFENSBERGER RD / N INTERSTATE 25 Common Name: INT I25 WOLFENSBERGERTime: 07/07/12 19:21 Narrative:  WHI STATION WAGON VS MEDIAN  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=DCSO--D 2012-00002114",

        "CALL:F MVA UNK INJ",
        "ADDR:NB",
        "MADDR:& N WILCOX ST",
        "MAP:AH30C",
        "UNIT:E151 MED154 XXX152",
        "X:N WILCOX ST, WOLFENSBERGER RD / N INTERSTATE 25",
        "PLACE:INT I25 WOLFENSBERGER",
        "DATE:07/07/12",
        "TIME:19:21",
        "INFO:WHI STATION WAGON VS MEDIAN  Class of Service: WPH2 Special Response Info: PSAP=DCSO--D",
        "ID:2012-00002114");

    doTest("T77",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 12:48:39 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 12:48:36 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F GAS LP OUTSIDE Location: CROWFOOT VALLEY RD / DIAMOND RIDGE PKWY Map: AF31A Units: Q155 E154 XXX155  Common Name: Time: 07/08/12 00:47 Narrative:  2012-00002115",

        "CALL:F GAS LP OUTSIDE",
        "ADDR:CROWFOOT VALLEY RD & DIAMOND RIDGE PKWY",
        "MAP:AF31A",
        "UNIT:Q155 E154 XXX155",
        "DATE:07/08/12",
        "TIME:00:47",
        "ID:2012-00002115");

    doTest("T78",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 2:33:41 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 2:33:38 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: N  US HIGHWAY 85 / CASTLEGATE DR NO Map: AF28B Units: E154 MED154 XXX154  Common Name: Time: 07/08/12 02:32 Narrative:  FOR A PANIC ATTACK ON A TRAFFIC STOP  2012-00002116",

        "CALL:F MED ASSIST",
        "ADDR:N  US HIGHWAY 85 & CASTLEGATE DR NO",
        "MADDR:N  US 85 & CASTLEGATE DR NO",
        "MAP:AF28B",
        "UNIT:E154 MED154 XXX154",
        "DATE:07/08/12",
        "TIME:02:32",
        "INFO:FOR A PANIC ATTACK ON A TRAFFIC STOP",
        "ID:2012-00002116");

    doTest("T79",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 8:31:21 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 8:31:20 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F RES STRUC Location: 5125 S MEADOW LARK DR / Map: AF27D Units: Q155 E154 E151 MED154 BA151 DVC151 XXX154  BOBOLINK CT, BOBOLINK DR / APACHE CREEK RD Common Name: Time: 07/08/12 08:30 Narrative:  2012-00002117",

        "CALL:F RES STRUC",
        "ADDR:5125 S MEADOW LARK DR",
        "MAP:AF27D",
        "UNIT:Q155 E154 E151 MED154 BA151 DVC151 XXX154",
        "X:BOBOLINK CT, BOBOLINK DR / APACHE CREEK RD",
        "DATE:07/08/12",
        "TIME:08:30",
        "ID:2012-00002117");

    doTest("T80",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 8:31:38 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 8:31:37 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F RES STRUC Location: 5125 S MEADOW LARK DR / Map: AF27D Units: Q155 E154 E151 MED154 BA151 DVC151 XXX154  BOBOLINK CT, BOBOLINK DR / APACHE CREEK RD Common Name: Time: 07/08/12 08:30 Narrative:  2012-00002117",

        "CALL:F RES STRUC",
        "ADDR:5125 S MEADOW LARK DR",
        "MAP:AF27D",
        "UNIT:Q155 E154 E151 MED154 BA151 DVC151 XXX154",
        "X:BOBOLINK CT, BOBOLINK DR / APACHE CREEK RD",
        "DATE:07/08/12",
        "TIME:08:30",
        "ID:2012-00002117");

    doTest("T81",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 8:32:18 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 8:32:18 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 4001 HOME ST / Map: AE29D1 Units: E153 MED151 XXX155  EVALENA RD / EVALENA RD Common Name: CASTLE ROCK CARE CENTER 4001 HOME STTime: 07/08/12 08:30 Narrative:  RESP TO MAIN ENRT, DOWN TO SILVER SPRINGS  C AND B  83 YOF, GI BLEED  E911 Info - Class of Service: 2012-00002118",

        "CALL:F MED ASSIST",
        "ADDR:4001 HOME ST",
        "MAP:AE29D1",
        "UNIT:E153 MED151 XXX155",
        "X:EVALENA RD / EVALENA RD",
        "PLACE:CASTLE ROCK CARE CENTER",
        "DATE:07/08/12",
        "TIME:08:30",
        "INFO:RESP TO MAIN ENRT, DOWN TO SILVER SPRINGS  C AND B  83 YOF, GI BLEED  Class of Service:",
        "ID:2012-00002118");

    doTest("T82",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 8:38:03 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 8:38:02 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F RES STRUC Location: 7555 PATRICK TRL / Map: V49 Units: XXX251 XXX274  BECKY CIR / COUNTY RD 194 Common Name: Time: 07/08/12 08:35 Narrative:  RP WAS COOKING BACON ON STOVE, GREASE FIRE STARTED  E911 Info - Class of Service: RESD Special Resp 2012-00000133",

        "CALL:F RES STRUC",
        "ADDR:7555 PATRICK TRL",
        "MAP:V49",
        "UNIT:XXX251 XXX274",
        "X:BECKY CIR / COUNTY RD 194",
        "DATE:07/08/12",
        "TIME:08:35",
        "INFO:RP WAS COOKING BACON ON STOVE, GREASE FIRE STARTED  Class of Service: RESD Special Resp",
        "ID:2012-00000133");

    doTest("T83",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 8:43:12 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 8:43:12 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F RES STRUC Location: 5125 S MEADOW LARK DR / Map: AF27D Units:  BOBOLINK CT, BOBOLINK DR / APACHE CREEK RD Common Name: Time: 07/08/12 08:30 Narrative:  BA151 MEADOW LARK CMD, SLOW INCOMING UNITS TO NON EMERG  PER CRPD CODE 9  CRPD ON SCN NOTHING SHOWI 2012-00002117",

        "CALL:F RES STRUC",
        "ADDR:5125 S MEADOW LARK DR",
        "MAP:AF27D",
        "UNIT:BOBOLINK CT, BOBOLINK DR / APACHE CREEK RD",
        "DATE:07/08/12",
        "TIME:08:30",
        "INFO:BA151 MEADOW LARK CMD, SLOW INCOMING UNITS TO NON EMERG  PER CRPD CODE 9  CRPD ON SCN NOTHING SHOWI",
        "ID:2012-00002117");

    doTest("T84",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 8:44:35 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 8:44:34 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F RES STRUC Location: 7555 PATRICK TRL / EOPS2 Map: V49 Units:  BECKY CIR / COUNTY RD 194 Common Name: Time: 07/08/12 08:35 Narrative:  RP STATES MEDICAL NOT NEEDED FOR BURN TO HAND  HUSBAND HAS BURN ON HAND  ALL PARTIES EVACUATED  RP  2012-00000133",

        "CALL:F RES STRUC",
        "ADDR:7555 PATRICK TRL",
        "CH:EOPS2",
        "MAP:V49",
        "UNIT:BECKY CIR / COUNTY RD 194",
        "DATE:07/08/12",
        "TIME:08:35",
        "INFO:RP STATES MEDICAL NOT NEEDED FOR BURN TO HAND  HUSBAND HAS BURN ON HAND  ALL PARTIES EVACUATED  RP",
        "ID:2012-00000133");

    doTest("T85",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 9:27:52 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 9:27:51 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 2301 WOODLANDS BLVD FRONT O / Map: AH30B Units: E151 MED154 XXX151  SCOTT BLVD / RAMBLEWOOD DR Common Name: CASTLE ROCK RECREATION CENTER 2301 WOODLANDS BLVDTime: 07/08/12 09:27 Narrative:  35YOM/DISLOCATED KNEE/C&B/  E911 Info - Class of Service: PBXB Special Response Info: PSAP=CRPD CRP 2012-00002119",

        "CALL:F MED ASSIST",
        "ADDR:2301 WOODLANDS BLVD FRONT O",
        "MAP:AH30B",
        "UNIT:E151 MED154 XXX151",
        "X:SCOTT BLVD / RAMBLEWOOD DR",
        "PLACE:CASTLE ROCK RECREATION CENTER 2301 WOODLANDS BLVD",
        "DATE:07/08/12",
        "TIME:09:27",
        "INFO:35YOM/DISLOCATED KNEE/C&B/  Class of Service: PBXB Special Response Info: PSAP=CRPD CRP",
        "ID:2012-00002119");

    doTest("T86",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 10:11:26 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 10:10:52 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F ALA RESET Location: 579 OAKWOOD DR 5 / Map: AH30B Units: E151 XXX152  MOUNTAIN VIEW, BARBI CT / FRONT ST Common Name: Time: 07/08/12 10:08 Narrative:  2012-00002120",

        "CALL:F ALA RESET",
        "ADDR:579 OAKWOOD DR 5",
        "MAP:AH30B",
        "UNIT:E151 XXX152",
        "X:MOUNTAIN VIEW, BARBI CT / FRONT ST",
        "DATE:07/08/12",
        "TIME:10:08",
        "ID:2012-00002120");

    doTest("T87",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 1:44:03 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 1:44:05 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 1368 N STRATTON AVE / Map: AH33C Units: E153 MED151 XXX153  E MONUMENT DR / N MONUMENT DR Common Name: Time: 07/08/12 13:43 Narrative:  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002121",

        "CALL:F MED ASSIST",
        "ADDR:1368 N STRATTON AVE",
        "MAP:AH33C",
        "UNIT:E153 MED151 XXX153",
        "X:E MONUMENT DR / N MONUMENT DR",
        "DATE:07/08/12",
        "TIME:13:43",
        "INFO:Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE",
        "ID:2012-00002121");

    doTest("T88",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 2:06:47 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 2:06:50 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 750 N  RIDGE RD / Map: AI32A Units: E153 MED154 XXX153  E STATE HIGHWAY 86 / FIFTH ST, FOUNDERS PKWY, E STATE HIGHWAY 86 Common Name: KING SOOPERS 750 RIDGE RDTime: 07/08/12 14:05 Narrative:  E911 Info - Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002122",

        "CALL:F MED ASSIST",
        "ADDR:750 N  RIDGE RD",
        "MAP:AI32A",
        "UNIT:E153 MED154 XXX153",
        "X:E STATE HIGHWAY 86 / FIFTH ST, FOUNDERS PKWY, E STATE HIGHWAY 86",
        "PLACE:KING SOOPERS 750 RIDGE RD",
        "DATE:07/08/12",
        "TIME:14:05",
        "INFO:Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE",
        "ID:2012-00002122");

    doTest("T89",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 2:08:57 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 2:09:00 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MVA INJ Location: E PLUM CREEK PKWY / N  RIDGE RD Map: AI32D Units: E151 MED181 XXX153  Common Name: Time: 07/08/12 14:07 Narrative:  MC ROLLOVER/  E911 Info - Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS 2012-00002123",

        "CALL:F MVA INJ",
        "ADDR:E PLUM CREEK PKWY & N  RIDGE RD",
        "MAP:AI32D",
        "UNIT:E151 MED181 XXX153",
        "DATE:07/08/12",
        "TIME:14:07",
        "INFO:MC ROLLOVER/  Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS",
        "ID:2012-00002123");

    doTest("T90",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 2:36:47 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 2:36:50 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 460 JOHNSON DR / Map: AI31B Units: E151 MED159 XXX151  GORDON DR / N VALLEY DR Common Name: Time: 07/08/12 14:36 Narrative:  83YOM/CON/BRE/CAN'T WALK  E911 Info - Class of Service: VOIP Special Response Info: PSAP=CASTLE ROC 2012-00002124",

        "CALL:F MED ASSIST",
        "ADDR:460 JOHNSON DR",
        "MAP:AI31B",
        "UNIT:E151 MED159 XXX151",
        "X:GORDON DR / N VALLEY DR",
        "DATE:07/08/12",
        "TIME:14:36",
        "INFO:83YOM/CON/BRE/CAN'T WALK  Class of Service: VOIP Special Response Info: PSAP=CASTLE ROC",
        "ID:2012-00002124");

    doTest("T91",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 6:42:15 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 6:42:15 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 745 N  WILCOX ST / Map: AH30C Units: E151 MED151 XXX152  EIGHTH ST / SEVENTH ST Common Name: EL MESON RESTAURANT 745 N WILCOX STTime: 07/08/12 18:40 Narrative:  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002126",

        "CALL:F MED ASSIST",
        "ADDR:745 N  WILCOX ST",
        "MAP:AH30C",
        "UNIT:E151 MED151 XXX152",
        "X:EIGHTH ST / SEVENTH ST",
        "PLACE:EL MESON RESTAURANT 745 N WILCOX ST",
        "DATE:07/08/12",
        "TIME:18:40",
        "INFO:Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE",
        "ID:2012-00002126");

    doTest("T92",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 7:48:19 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 7:48:18 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MVA UNK INJ Location: / Map: AE29D Units: E39 MED39 XXX155  MEADOWS PKWY / E HAPPY CANYON RD Common Name: I25 MM184 SB NOFTime: 07/08/12 19:48 Narrative:  Call Number 126 was created from Call Number 124(Jul  8 2012  7:44PM)  CSP REQ SEND MEDICAL  RP DOE 2012-00001064",

        "CALL:F MVA UNK INJ",
        "MAP:AE29D",
        "UNIT:E39 MED39 XXX155",
        "X:MEADOWS PKWY / E HAPPY CANYON RD",
        "PLACE:I25 MM184 SB NOF",
        "DATE:07/08/12",
        "TIME:19:48",
        "INFO:Call Number 126 was created from Call Number 124(Jul  8 2012  7:44PM)  CSP REQ SEND MEDICAL  RP DOE",
        "ID:2012-00001064");

    doTest("T93",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 7:49:55 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 7:49:55 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 20 N  WILCOX ST / Y Map: AI30A Units: E151 MED151 XXX151  FIRST ST / SOUTH ST, S WILCOX ST Common Name: CASTLE ROCK LIQUORS 20 WILCOX STTime: 07/08/12 19:49 Narrative:  Nature Of Call: Y  ALCOHOL EVAL  2012-00002128",

        "CALL:F MED ASSIST",
        "ADDR:20 N  WILCOX ST & Y",
        "MADDR:20 N  WILCOX ST",
        "MAP:AI30A",
        "UNIT:E151 MED151 XXX151",
        "X:FIRST ST / SOUTH ST, S WILCOX ST",
        "PLACE:CASTLE ROCK LIQUORS 20 WILCOX ST",
        "DATE:07/08/12",
        "TIME:19:49",
        "INFO:Y  ALCOHOL EVAL",
        "ID:2012-00002128");

    doTest("T94",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 8:06:17 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 8:06:17 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MISC Location: 1470 FRONT ST / Map: AH30D Units: E154 XXX152  CANYON DR / N PERRY ST Common Name: PARK ROCK PARKTime: 07/08/12 20:03 Narrative:  PER CRPD THREE PARTIES ARE TRYING TO GET OFF THE ROCK IN THE RAIN  ON TOP OF THE ROCK  2012-00002129",

        "CALL:F MISC",
        "ADDR:1470 FRONT ST",
        "MAP:AH30D",
        "UNIT:E154 XXX152",
        "X:CANYON DR / N PERRY ST",
        "PLACE:PARK ROCK PARK",
        "DATE:07/08/12",
        "TIME:20:03",
        "INFO:PER CRPD THREE PARTIES ARE TRYING TO GET OFF THE ROCK IN THE RAIN  ON TOP OF THE ROCK",
        "ID:2012-00002129");

    doTest("T95",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 8:25:34 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 8:25:34 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F RES STRUC Location: 8556 STATE HIGHWAY 86 / EOPS1 Map: AJ49 Units: XXX221 XXX271  COUNTY RD 37 / COUNTY RD 33 Common Name: Time: 07/08/12 20:21 Narrative:  Nature Of Call: EOPS1  HOUSE ON FIRE/ FLAMES OUT OF WINDOW  E911 Info - Class of Service: VOIP Spec 2012-00000141",

        "CALL:F RES STRUC",
        "ADDR:8556 STATE HIGHWAY 86",
        "MADDR:8556 STATE 86",
        "CH:EOPS1",
        "MAP:AJ49",
        "UNIT:XXX221 XXX271",
        "X:COUNTY RD 37 / COUNTY RD 33",
        "DATE:07/08/12",
        "TIME:20:21",
        "INFO:HOUSE ON FIRE/ FLAMES OUT OF WINDOW  Class of Service: VOIP Spec",
        "ID:2012-00000141");

    doTest("T96",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Sunday, July 08, 2012 11:39:37 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Sunday, July 08, 2012 11:39:07 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 541 STAFFORD CIR / Map: AJ30D Units: E151 MED151 XXX151  MALTON CT / BRIERLY CT Common Name: Time: 07/08/12 23:38 Narrative:  SICK CASE  E911 Info - Class of Service: RESD Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FI 2012-00002131",

        "CALL:F MED ASSIST",
        "ADDR:541 STAFFORD CIR",
        "MAP:AJ30D",
        "UNIT:E151 MED151 XXX151",
        "X:MALTON CT / BRIERLY CT",
        "DATE:07/08/12",
        "TIME:23:38",
        "INFO:SICK CASE  Class of Service: RESD Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FI",
        "ID:2012-00002131");

    doTest("T97",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 1:14:25 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 1:14:19 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 6361 MILLBRIDGE AVE / Map: AI33D Units: E153 MED151 XXX153  BRANTLY AVE / BRANTLY AVE, MILLBRIDGE CT Common Name: Time: 07/09/12 01:13 Narrative:  2012-00002132",

        "CALL:F MED ASSIST",
        "ADDR:6361 MILLBRIDGE AVE",
        "MAP:AI33D",
        "UNIT:E153 MED151 XXX153",
        "X:BRANTLY AVE / BRANTLY AVE, MILLBRIDGE CT",
        "DATE:07/09/12",
        "TIME:01:13",
        "ID:2012-00002132");

    doTest("T98",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 1:52:55 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 1:52:51 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 19 N  CANTRIL ST / Map: AI30B Units: E151 MED151 XXX152  FIRST ST / SOUTH ST, S CANTRIL ST Common Name: CASTLE COURT APARTMENTS 19 N CANTRIL STTime: 07/09/12 01:52 Narrative:  2012-00002133",

        "CALL:F MED ASSIST",
        "ADDR:19 N  CANTRIL ST",
        "MAP:AI30B",
        "UNIT:E151 MED151 XXX152",
        "X:FIRST ST / SOUTH ST, S CANTRIL ST",
        "PLACE:CASTLE COURT APARTMENTS 19 N CANTRIL ST",
        "DATE:07/09/12",
        "TIME:01:52",
        "ID:2012-00002133");

    doTest("T99",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 6:37:47 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 6:37:45 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 1002 PARK VIEW CT / Map: AH30B Units: E151 MED151 XXX151  PARK VIEW, OAKWOOD DR / DEAD END Common Name: Time: 07/09/12 06:37 Narrative:  E911 Info - Class of Service: VOIP Special Response Info: PSAP=CASTLE ROCK VOIP   VOIP 911 CALL  VE 2012-00002134",

        "CALL:F MED ASSIST",
        "ADDR:1002 PARK VIEW CT",
        "MAP:AH30B",
        "UNIT:E151 MED151 XXX151",
        "X:PARK VIEW, OAKWOOD DR / DEAD END",
        "DATE:07/09/12",
        "TIME:06:37",
        "INFO:Class of Service: VOIP Special Response Info: PSAP=CASTLE ROCK VOIP   VOIP 911 CALL  VE",
        "ID:2012-00002134");

    doTest("T100",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 6:42:37 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 6:42:34 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F LIFT ASSIST Location: 221 N  CANTRIL ST / Map: AI30B Units: E154 XXX152  THIRD ST / SECOND ST Common Name: CANTRIL HOUSE 221 N CANTRIL STTime: 07/09/12 06:42 Narrative:  E911 Info - Class of Service: CNTX Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FIRE  2012-00002135",

        "CALL:F LIFT ASSIST",
        "ADDR:221 N  CANTRIL ST",
        "MAP:AI30B",
        "UNIT:E154 XXX152",
        "X:THIRD ST / SECOND ST",
        "PLACE:CANTRIL HOUSE 221 N CANTRIL ST",
        "DATE:07/09/12",
        "TIME:06:42",
        "INFO:Class of Service: CNTX Special Response Info: PSAP=CRPD CRPD  CASTLE ROCK FIRE",
        "ID:2012-00002135");

    doTest("T101",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 7:24:33 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 7:24:29 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 564 VISTA DR / Map: AI30B Units: E154 MED159 XXX151  SIXTH ST / ANDERSON ST Common Name: Time: 07/09/12 07:23 Narrative:  POSS FELL OFF THE BED, DOESNT APPEAR INJ  DAD ON THE GROUND/HALLUCINATING/C&B/71 YO  E911 Info - Cl 2012-00002136",

        "CALL:F MED ASSIST",
        "ADDR:564 VISTA DR",
        "MAP:AI30B",
        "UNIT:E154 MED159 XXX151",
        "X:SIXTH ST / ANDERSON ST",
        "DATE:07/09/12",
        "TIME:07:23",
        "INFO:POSS FELL OFF THE BED, DOESNT APPEAR INJ  DAD ON THE GROUND/HALLUCINATING/C&B/71 YO  Cl",
        "ID:2012-00002136");

    doTest("T102",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 8:52:39 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 8:52:36 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 1120 EATON CIR CALLBK= / Map: AJ31B2 Units: E151 MED151 XXX152  DEAD END / E PLUM CREEK PKWY, EATON ST Common Name: Time: 07/09/12 08:51 Narrative:  62YOM/CON/DIFF BREATHING  E911 Info - Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUG 2012-00002137",

        "CALL:F MED ASSIST",
        "ADDR:1120 EATON CIR CALLBK=",
        "MAP:AJ31B2",
        "UNIT:E151 MED151 XXX152",
        "X:DEAD END / E PLUM CREEK PKWY, EATON ST",
        "DATE:07/09/12",
        "TIME:08:51",
        "INFO:62YOM/CON/DIFF BREATHING  Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUG",
        "ID:2012-00002137");

    doTest("T103",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 10:51:38 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 10:51:28 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MVA UNK INJ Location: CROWFOOT VALLEY RD / FOUNDERS PKWY Map: AF31C Units: Q155 MED154 XXX155  Common Name: Time: 07/09/12 10:50 Narrative:  2012-00002139",

        "CALL:F MVA UNK INJ",
        "ADDR:CROWFOOT VALLEY RD & FOUNDERS PKWY",
        "MAP:AF31C",
        "UNIT:Q155 MED154 XXX155",
        "DATE:07/09/12",
        "TIME:10:50",
        "ID:2012-00002139");

    doTest("T104",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 11:06:30 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 11:06:21 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F COMMERCIAL ALA Location: 930 E PLUM CREEK PKWY / Map: AJ30B1 Units: E151 E154 XXX151  FAIRGROUNDS DR / PLUM CREEK BLVD, FAIRGROUNDS RD Common Name: Time: 07/09/12 11:05 Narrative:  ZONE 2 GENERAL FIRE ALARM  2012-00002140",

        "CALL:F COMMERCIAL ALA",
        "ADDR:930 E PLUM CREEK PKWY",
        "MAP:AJ30B1",
        "UNIT:E151 E154 XXX151",
        "X:FAIRGROUNDS DR / PLUM CREEK BLVD, FAIRGROUNDS RD",
        "DATE:07/09/12",
        "TIME:11:05",
        "INFO:ZONE 2 GENERAL FIRE ALARM",
        "ID:2012-00002140");

    doTest("T105",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 11:23:02 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 11:22:37 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 220 DOUGLAS FIR AVE / Map: AI31C Units: E153 MED154 XXX152  PARK DR / SELLERS DR Common Name: Time: 07/09/12 11:21 Narrative:  2012-00002141",

        "CALL:F MED ASSIST",
        "ADDR:220 DOUGLAS FIR AVE",
        "MAP:AI31C",
        "UNIT:E153 MED154 XXX152",
        "X:PARK DR / SELLERS DR",
        "DATE:07/09/12",
        "TIME:11:21",
        "ID:2012-00002141");

    doTest("T106",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 11:37:50 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 11:37:24 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 3 OAKWOOD PARK / Map: AH30D Units: MED39 XXX151  SUNSET DR / SUNSET DR Common Name: Time: 07/09/12 11:36 Narrative:  PATIENT NEEDS TO GO TO ER  E911 Info - Class of Service: CNTX Special Response Info: PSAP=CRPD CRPD 2012-00001073",

        "CALL:F MED ASSIST",
        "ADDR:3 OAKWOOD PARK",
        "MAP:AH30D",
        "UNIT:MED39 XXX151",
        "X:SUNSET DR / SUNSET DR",
        "DATE:07/09/12",
        "TIME:11:36",
        "INFO:PATIENT NEEDS TO GO TO ER  Class of Service: CNTX Special Response Info: PSAP=CRPD CRPD",
        "ID:2012-00001073");

    doTest("T107",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 1:03:51 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 1:03:48 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 355 E  ALLEN ST 15 / Map: AF30C2 Units: Q155 MED154 XXX155  METZLER WAY / REID TRL Common Name: Time: 07/09/12 13:03 Narrative:  E911 Info - Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002144",

        "CALL:F MED ASSIST",
        "ADDR:355 E  ALLEN ST 15",
        "MAP:AF30C2",
        "UNIT:Q155 MED154 XXX155",
        "X:METZLER WAY / REID TRL",
        "DATE:07/09/12",
        "TIME:13:03",
        "INFO:Class of Service: WPH1 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE",
        "ID:2012-00002144");

    doTest("T108",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 1:25:34 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 1:25:31 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F BRUSH (NT) Location: / EOPS3 Map: AH82 Units: XXX291  INTERSTATE 70, I70 COUNTY RD 134 RAMP / COUNTY RD 162, INTERSTATE 70 Common Name: I70 MM346 EBTime: 07/09/12 13:22 Narrative:  ABOUT THE SIZE OF A CAR  RP DIDNT STOP  Nature Of Call: EOPS3  BRUSH FIRE IN THE MEDIAN  JWOF 146   2012-00000062",

        "CALL:F BRUSH (NT)",
        "CH:EOPS3",
        "MAP:AH82",
        "UNIT:XXX291",
        "X:INTERSTATE 70, I70 COUNTY RD 134 RAMP / COUNTY RD 162, INTERSTATE 70",
        "PLACE:I70 MM346 EB",
        "DATE:07/09/12",
        "TIME:13:22",
        "INFO:ABOUT THE SIZE OF A CAR  RP DIDNT STOP / BRUSH FIRE IN THE MEDIAN  JWOF 146",
        "ID:2012-00000062");

    doTest("T109",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 1:58:19 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 1:58:16 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 1175 S PERRY ST 200 / Map: AJ30A Units: MED151 XXX152  RIO GRANDE DR / INTERSTATE 25 FRONTAGE Common Name: DOUGLAS FAMILY MEDICINE 1175 S PERRY ST # 200Time: 07/09/12 13:57 Narrative:  83YOF/CON/BRE/FATIGUED/DEHYDRATED/ABD PAIN  E911 Info - Class of Service: BUSN Special Response Inf 2012-00002145",

        "CALL:F MED ASSIST",
        "ADDR:1175 S PERRY ST 200",
        "MAP:AJ30A",
        "UNIT:MED151 XXX152",
        "X:RIO GRANDE DR / INTERSTATE 25 FRONTAGE",
        "PLACE:DOUGLAS FAMILY MEDICINE 1175 S PERRY ST # 200",
        "DATE:07/09/12",
        "TIME:13:57",
        "INFO:83YOF/CON/BRE/FATIGUED/DEHYDRATED/ABD PAIN  Class of Service: BUSN Special Response Inf",
        "ID:2012-00002145");

    doTest("T110",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 2:24:13 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 2:24:07 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: TERRITORIAL RD / DOUGLAS LN Map: AK29C Units: E151 MED154 XXX151  Common Name: Time: 07/09/12 14:23 Narrative:  2012-00002146",

        "CALL:F MED ASSIST",
        "ADDR:TERRITORIAL RD & DOUGLAS LN",
        "MAP:AK29C",
        "UNIT:E151 MED154 XXX151",
        "DATE:07/09/12",
        "TIME:14:23",
        "ID:2012-00002146");

    doTest("T111",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 3:13:41 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 3:13:38 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 100 N  PERRY ST / Map: AI30B Units: E151 MED151 XXX152  SECOND ST / SOUTH ST, S PERRY ST Common Name: PD CASTLE ROCK POLICE DEPARTMENTTime: 07/09/12 15:12 Narrative:  40 YOF, C AND B  DIABETIC IN THE LOBBY  2012-00002147",

        "CALL:F MED ASSIST",
        "ADDR:100 N  PERRY ST",
        "MAP:AI30B",
        "UNIT:E151 MED151 XXX152",
        "X:SECOND ST / SOUTH ST, S PERRY ST",
        "PLACE:PD CASTLE ROCK POLICE DEPARTMENT",
        "DATE:07/09/12",
        "TIME:15:12",
        "INFO:40 YOF, C AND B  DIABETIC IN THE LOBBY",
        "ID:2012-00002147");

    doTest("T112",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 3:14:28 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 3:14:25 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 205 CEDAR AVE / Map: AI31C Units: E153 MED154 XXX151  BIRCH AVE / SELLERS DR Common Name: Time: 07/09/12 15:13 Narrative:  ELDERLY FEMELAE DISPRIENRTED, C AND B  CRPD ON SCN  2012-00002148",

        "CALL:F MED ASSIST",
        "ADDR:205 CEDAR AVE",
        "MAP:AI31C",
        "UNIT:E153 MED154 XXX151",
        "X:BIRCH AVE / SELLERS DR",
        "DATE:07/09/12",
        "TIME:15:13",
        "INFO:ELDERLY FEMELAE DISPRIENRTED, C AND B  CRPD ON SCN",
        "ID:2012-00002148");

    doTest("T113",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 7:49:37 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 7:49:34 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: N US HIGHWAY 85 CALLBK= / MEADOWS PKWY Map: AF29D Units: E154 MED154 XXX154  Common Name: Time: 07/09/12 19:49 Narrative:  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002149",

        "CALL:F MED ASSIST",
        "ADDR:N US HIGHWAY 85 CALLBK= & MEADOWS PKWY",
        "MADDR:N US 85 CALLBK= & MEADOWS PKWY",
        "MAP:AF29D",
        "UNIT:E154 MED154 XXX154",
        "DATE:07/09/12",
        "TIME:19:49",
        "INFO:Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE",
        "ID:2012-00002149");

    doTest("T114",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 7:49:49 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 7:49:46 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MVA UNK INJ Location: N US HIGHWAY 85 CALLBK= / MEADOWS PKWY Map: AF29D Units:  Common Name: Time: 07/09/12 19:49 Narrative:  35 YOM, CON/BRE, KNE INJ  VEH VS MC  E911 Info - Class of Service: WPH2 Special Response Info: PSAP 2012-00002149",

        "CALL:F MVA UNK INJ",
        "ADDR:N US HIGHWAY 85 CALLBK= & MEADOWS PKWY",
        "MADDR:N US 85 CALLBK= & MEADOWS PKWY",
        "MAP:AF29D",
        "DATE:07/09/12",
        "TIME:19:49",
        "INFO:35 YOM, CON/BRE, KNE INJ  VEH VS MC  Class of Service: WPH2 Special Response Info: PSAP",
        "ID:2012-00002149");

    doTest("T115",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Monday, July 09, 2012 7:49:58 PM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Monday, July 09, 2012 7:49:56 PM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MVA INJ Location: N US HIGHWAY 85 CALLBK= / MEADOWS PKWY Map: AF29D Units:  Common Name: Time: 07/09/12 19:49 Narrative:  RIDER STILL DOWN/NO HELMET  BLK SEDAN  35 YOM, CON/BRE, KNE INJ  VEH VS MC  E911 Info - Class of Se 2012-00002149",

        "CALL:F MVA INJ",
        "ADDR:N US HIGHWAY 85 CALLBK= & MEADOWS PKWY",
        "MADDR:N US 85 CALLBK= & MEADOWS PKWY",
        "MAP:AF29D",
        "DATE:07/09/12",
        "TIME:19:49",
        "INFO:RIDER STILL DOWN/NO HELMET  BLK SEDAN  35 YOM, CON/BRE, KNE INJ  VEH VS MC  Class of Se",
        "ID:2012-00002149");

    doTest("T116",
        "[FW: Dispatch] \n" +
        "-------------------------------------------\n" +
        "From: Norris Croom[SMTP:NCROOM@CRGOV.COM]\n" +
        "Sent: Tuesday, July 10, 2012 2:04:21 AM\n" +
        "To: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\n" +
        "Subject: FW: Dispatch\n" +
        "Auto forwarded by a Rule\n\n\n" +
        "-------------------------------------------\n" +
        "From: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\n" +
        "Sent: Tuesday, July 10, 2012 2:04:18 AM\n" +
        "To: Norris Croom\n" +
        "Subject: Dispatch\n" +
        "Auto forwarded by a Rule\n\n" +
        "Call: F MED ASSIST Location: 6005 CASTLEGATE DR WE / SW CRNR Map: AE29C1 Units: E154 MED154 XXX154  No Cross Streets Found Common Name: Time: 07/10/12 02:03 Narrative:  **STANDBY ** MED EVAL ON MALE PARTY WHO HAS BEEN TASED / ALSO FOR FEM WITH BLOOD ON HER  2012-00002150",

        "CALL:F MED ASSIST",
        "ADDR:6005 CASTLEGATE DR WE & SW CRNR",
        "MADDR:6005 CASTLEGATE DR WE",
        "MAP:AE29C1",
        "UNIT:E154 MED154 XXX154",
        "DATE:07/10/12",
        "TIME:02:03",
        "INFO:**STANDBY ** MED EVAL ON MALE PARTY WHO HAS BEEN TASED / ALSO FOR FEM WITH BLOOD ON HER",
        "ID:2012-00002150");

  }
  
  public static void main(String[] args) {
    new CODouglasCountyParserTest().generateTests("T1");
  }
}