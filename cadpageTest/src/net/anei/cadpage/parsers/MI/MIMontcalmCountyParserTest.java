package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Montcalm County, MI
Contact: Randy Kibilko <mcsert15@gmail.com>
Sender: cad@mydomain.com

CAD:FYI: ;06/22/2012 01:39:53;4566 S GREENVILLE RD;Event spawned from STRUCTURE FIRE. [06/22/2012 01:38:55 TMORTENSEN]
CAD:FYI: ;06/29/2012 14:52:54;215 N STATE ST;wire across the roadway [06/29/12 14:53:21 AHIRKAWAY]    
CAD:Update: ;06/29/2012 14:52:54;300 N STATE ST;PHONE AND CABLE WIRES, TIRED OFF [06/29/12 15:10:51 JJOURDAN] wire across the roadway [06/29/12 14:53:21 AHIRKAWAY]
CAD:FYI: ;07/03/2012 18:09:20;N LINCOLN ST/E DAY ST;LINE HANGING LOW - POLE TO HOUSE [07/03/12 18:10:19 MROSE] In the city of stanton mi.
CAD:FYI: ;07/05/2012 02:30:55;3720 EAST SHORE DR;POWER LINES DOWN-NO POWER IN THE AREA [07/05/12 02:32:30 TLARSON]
CAD:FYI: ;07/05/2012 02:36:07;96 W EVERGREEN RD;POWER LINES ARCING AND SPARKING [07/05/12 02:38:06 TLARSON]
CAD:FYI: ;07/05/2012 03:05:45;S STAINES RD/E SIDNEY RD;POWER LINES DOWN IN THE ROADWAY NORTH OF INTERSECTION [07/05/12 03:06:40 TMORTENSEN]
CAD:FYI: ;07/05/2012 03:06:43;5201 W HILLIS RD;TREE DOWN AND LINES ON FIRE [07/05/12 03:07:14 TMORTENSEN]
CAD:FYI: ;07/05/2012 03:09:06;2700 S NEVINS RD;3 POWER LINES [07/05/12 03:10:12 TMORTENSEN]
CAD:FYI: ;07/05/2012 03:21:54;S SHERIDAN RD/E PAKES RD;TREES DOWN/WIRES ACROSS THE ROADWAY [07/05/12 03:22:13 SDAVIS]
CAD:FYI: ;07/05/2012 03:24:52;147 E SIDNEY RD;LINES DOWN IN THE DRIVEWAY OF THE CALLERS ADDRESS [07/05/12 03:25:46 TLARSON] POWER LINES DOWN- [07/05/12
CAD:FYI: ;07/05/2012 03:53:11;588 W SIDNEY RD;TREES ON POWER LINES AT THE ABOVE LOCATION-REPORTED BY TRUCK 7 FROM STANTON FIRE [07/05/12 03:53:47

Contact: Dwight C <dwightsright@gmail.com>
Sender: CAD@mydomain.com
CAD:6300 N DOUGLAS RD;1204703;[Medical Priority Info] Key Questions Complete RESPONSE: Amb & Rescue RESPONDER SCRIPT: -Comments: TOOK A NITRO ABOUT 5 MINS AGO-NO R
CAD:216 W LAKE ST;1204713;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 70 year old, Male, Unconscious, Breathing. Unconscious -- AGONAL/INEFFEC
CAD:10522 E BOYER RD;1204741;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 48 year old, Male, Consciousness unknown, Breathing status unknown. A
CAD:213 E SHERMAN ST;1204747;foot ball game [08/28/12 17:57:06 JPYLE]
CAD:501 S ROCK LAKE DR;1204801;REQUEST FOR RESCUE [08/30/12 21:45:45 SDAVIS] 17-A-3 [08/30/12 21:44:40 SDAVIS] [Medical Priority Info] Key Questions Complete RESPO
CAD:10522 E BOYER RD;1204802
CAD:FYI: ;08/26/2012 11:01:49;E STANTON RD/S MT HOPE RD;MT HOPE E STANTON RD JUST TO THE EAST SMELLS REALLY BAD OF NATURAL GAS [08/26/12 11:02:10 BDOOD]
CAD:620-119 N SECOND ST;1204810;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 77 year old, Male, Unconscious, Breathing. Unconscious -- Effectiv
CAD:320-15 JUNIPER ST;1204817;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 70 year old, Female, Conscious, Breathing. POSSIBLY DANGEROUS body a
CAD:7925 PENNY LANE;1204819;PAGED R23 SECOND TIME [08/31/12 15:29:55 KBAILEY] aired over primary [08/31/12 15:24:59 JPYLE] [Medical Priority Info] RESPONSE: Amb &
CAD:118 E PINE ST;1204821;[Medical Priority Info] Key Questions Complete RESPONSE: Amb & Rescue RESPONDER SCRIPT: 81 year old, Female, Conscious, Breathing. [08/31
CAD:503 GARY ST;1204825;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 21 year old, Male, Unconscious, Breathing. CONTINUOUS or MULTIPLE seizures
CAD:620 N SECOND ST;1204826;[Medical Priority Info] Key Questions Complete RESPONSE: Amb & Rescue RESPONDER SCRIPT: 81 year old, Male, Conscious, Breathing. [09/01
CAD:4401 E DEANER RD;1204828;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 45 year old, Male, Unconscious, Breathing status unknown. Unconscious
CAD:620-103 S SECOND ST;1204832;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 79 year old, Male, Conscious, Breathing. NON-RECENT (=> 6hrs) inju 

 */

public class MIMontcalmCountyParserTest extends BaseParserTest {
  
  public MIMontcalmCountyParserTest() {
	  setParser(new MIMontcalmCountyParser(), "MONTCALM COUNTY", "MI");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "CAD:FYI: ;06/22/2012 01:39:53;4566 S GREENVILLE RD;Event spawned from STRUCTURE FIRE. [06/22/2012 01:38:55 TMORTENSEN]",
        "DATE:06/22/2012",
        "TIME:01:39:53",
        "ADDR:4566 S GREENVILLE RD",
        "CALL:STRUCTURE FIRE.");

    doTest("T2",
        "CAD:FYI: ;06/29/2012 14:52:54;215 N STATE ST;wire across the roadway [06/29/12 14:53:21 AHIRKAWAY]    ",
        "DATE:06/29/2012",
        "TIME:14:52:54",
        "ADDR:215 N STATE ST",
        "CALL:wire across the roadway");

    doTest("T3",
        "CAD:Update: ;06/29/2012 14:52:54;300 N STATE ST;PHONE AND CABLE WIRES, TIRED OFF [06/29/12 15:10:51 JJOURDAN] wire across the roadway [06/29/12 14:53:21 AHIRKAWAY]",
        "DATE:06/29/2012",
        "TIME:14:52:54",
        "ADDR:300 N STATE ST",
        "CALL:PHONE AND CABLE WIRES, TIRED OFF",
        "INFO:wire across the roadway");

    doTest("T4",
        "CAD:FYI: ;07/03/2012 18:09:20;N LINCOLN ST/E DAY ST;LINE HANGING LOW - POLE TO HOUSE [07/03/12 18:10:19 MROSE] In the city of stanton mi.",
        "DATE:07/03/2012",
        "TIME:18:09:20",
        "ADDR:N LINCOLN ST & E DAY ST",
        "CALL:LINE HANGING LOW - POLE TO HOUSE",
        "INFO:In the city of stanton mi.");

    doTest("T5",
        "CAD:FYI: ;07/05/2012 02:30:55;3720 EAST SHORE DR;POWER LINES DOWN-NO POWER IN THE AREA [07/05/12 02:32:30 TLARSON]",
        "DATE:07/05/2012",
        "TIME:02:30:55",
        "ADDR:3720 EAST SHORE DR",
        "CALL:POWER LINES DOWN-NO POWER IN THE AREA");

    doTest("T6",
        "CAD:FYI: ;07/05/2012 02:36:07;96 W EVERGREEN RD;POWER LINES ARCING AND SPARKING [07/05/12 02:38:06 TLARSON]",
        "DATE:07/05/2012",
        "TIME:02:36:07",
        "ADDR:96 W EVERGREEN RD",
        "CALL:POWER LINES ARCING AND SPARKING");

    doTest("T7",
        "CAD:FYI: ;07/05/2012 03:05:45;S STAINES RD/E SIDNEY RD;POWER LINES DOWN IN THE ROADWAY NORTH OF INTERSECTION [07/05/12 03:06:40 TMORTENSEN]",
        "DATE:07/05/2012",
        "TIME:03:05:45",
        "ADDR:S STAINES RD & E SIDNEY RD",
        "CALL:POWER LINES DOWN IN THE ROADWAY NORTH OF INTERSECTION");

    doTest("T8",
        "CAD:FYI: ;07/05/2012 03:06:43;5201 W HILLIS RD;TREE DOWN AND LINES ON FIRE [07/05/12 03:07:14 TMORTENSEN]",
        "DATE:07/05/2012",
        "TIME:03:06:43",
        "ADDR:5201 W HILLIS RD",
        "CALL:TREE DOWN AND LINES ON FIRE");

    doTest("T9",
        "CAD:FYI: ;07/05/2012 03:09:06;2700 S NEVINS RD;3 POWER LINES [07/05/12 03:10:12 TMORTENSEN]",
        "DATE:07/05/2012",
        "TIME:03:09:06",
        "ADDR:2700 S NEVINS RD",
        "CALL:3 POWER LINES");

    doTest("T10",
        "CAD:FYI: ;07/05/2012 03:21:54;S SHERIDAN RD/E PAKES RD;TREES DOWN/WIRES ACROSS THE ROADWAY [07/05/12 03:22:13 SDAVIS]",
        "DATE:07/05/2012",
        "TIME:03:21:54",
        "ADDR:S SHERIDAN RD & E PAKES RD",
        "CALL:TREES DOWN/WIRES ACROSS THE ROADWAY");

    doTest("T11",
        "CAD:FYI: ;07/05/2012 03:24:52;147 E SIDNEY RD;LINES DOWN IN THE DRIVEWAY OF THE CALLERS ADDRESS [07/05/12 03:25:46 TLARSON] POWER LINES DOWN- [07/05/12",
        "DATE:07/05/2012",
        "TIME:03:24:52",
        "ADDR:147 E SIDNEY RD",
        "CALL:LINES DOWN IN THE DRIVEWAY OF THE CALLERS ADDRESS",
        "INFO:POWER LINES DOWN-");

    doTest("T12",
        "CAD:FYI: ;07/05/2012 03:53:11;588 W SIDNEY RD;TREES ON POWER LINES AT THE ABOVE LOCATION-REPORTED BY TRUCK 7 FROM STANTON FIRE [07/05/12 03:53:47",
        "DATE:07/05/2012",
        "TIME:03:53:11",
        "ADDR:588 W SIDNEY RD",
        "CALL:TREES ON POWER LINES AT THE ABOVE LOCATION-REPORTED BY TRUCK 7 FROM STANTON FIRE");

  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "CAD:6300 N DOUGLAS RD;1204703;[Medical Priority Info] Key Questions Complete RESPONSE: Amb & Rescue RESPONDER SCRIPT: -Comments: TOOK A NITRO ABOUT 5 MINS AGO-NO R",
        "ADDR:6300 N DOUGLAS RD",
        "CALL:EMS ALERT",
        "ID:1204703",
        "INFO:TOOK A NITRO ABOUT 5 MINS AGO-NO R");

    doTest("T2",
        "CAD:216 W LAKE ST;1204713;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 70 year old, Male, Unconscious, Breathing. Unconscious -- AGONAL/INEFFEC",
        "ADDR:216 W LAKE ST",
        "CALL:EMS ALERT",
        "ID:1204713",
        "INFO:70 year old, Male, Unconscious, Breathing. Unconscious -- AGONAL/INEFFEC");

    doTest("T3",
        "CAD:10522 E BOYER RD;1204741;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 48 year old, Male, Consciousness unknown, Breathing status unknown. A",
        "ADDR:10522 E BOYER RD",
        "CALL:EMS ALERT",
        "ID:1204741",
        "INFO:48 year old, Male, Consciousness unknown, Breathing status unknown. A");

    doTest("T4",
        "CAD:213 E SHERMAN ST;1204747;foot ball game [08/28/12 17:57:06 JPYLE]",
        "DATE:08/28/12",
        "TIME:17:57:06",
        "ADDR:213 E SHERMAN ST",
        "CALL:EMS ALERT",
        "ID:1204747",
        "INFO:foot ball game");

    doTest("T5",
        "CAD:501 S ROCK LAKE DR;1204801;REQUEST FOR RESCUE [08/30/12 21:45:45 SDAVIS] 17-A-3 [08/30/12 21:44:40 SDAVIS] [Medical Priority Info] Key Questions Complete RESPO",
        "DATE:08/30/12",
        "TIME:21:45:45",
        "ADDR:501 S ROCK LAKE DR",
        "CALL:EMS ALERT",
        "ID:1204801",
        "INFO:REQUEST FOR RESCUE / 17-A-3");

    doTest("T6",
        "CAD:10522 E BOYER RD;1204802",
        "ADDR:10522 E BOYER RD",
        "CALL:EMS ALERT",
        "ID:1204802");

    doTest("T7",
        "CAD:FYI: ;08/26/2012 11:01:49;E STANTON RD/S MT HOPE RD;MT HOPE E STANTON RD JUST TO THE EAST SMELLS REALLY BAD OF NATURAL GAS [08/26/12 11:02:10 BDOOD]",
        "DATE:08/26/2012",
        "TIME:11:01:49",
        "ADDR:E STANTON RD & S MT HOPE RD",
        "CALL:MT HOPE E STANTON RD JUST TO THE EAST SMELLS REALLY BAD OF NATURAL GAS");

    doTest("T8",
        "CAD:620-119 N SECOND ST;1204810;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 77 year old, Male, Unconscious, Breathing. Unconscious -- Effectiv",
        "ADDR:620-119 N SECOND ST",
        "MADDR:620 N SECOND ST",
        "CALL:EMS ALERT",
        "ID:1204810",
        "INFO:77 year old, Male, Unconscious, Breathing. Unconscious -- Effectiv");

    doTest("T9",
        "CAD:320-15 JUNIPER ST;1204817;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 70 year old, Female, Conscious, Breathing. POSSIBLY DANGEROUS body a",
        "ADDR:320-15 JUNIPER ST",
        "MADDR:320 JUNIPER ST",
        "CALL:EMS ALERT",
        "ID:1204817",
        "INFO:70 year old, Female, Conscious, Breathing. POSSIBLY DANGEROUS body a");

    doTest("T10",
        "CAD:7925 PENNY LANE;1204819;PAGED R23 SECOND TIME [08/31/12 15:29:55 KBAILEY] aired over primary [08/31/12 15:24:59 JPYLE] [Medical Priority Info] RESPONSE: Amb &",
        "DATE:08/31/12",
        "TIME:15:29:55",
        "ADDR:7925 PENNY LANE",
        "CALL:EMS ALERT",
        "ID:1204819",
        "INFO:PAGED R23 SECOND TIME / aired over primary");

    doTest("T11",
        "CAD:118 E PINE ST;1204821;[Medical Priority Info] Key Questions Complete RESPONSE: Amb & Rescue RESPONDER SCRIPT: 81 year old, Female, Conscious, Breathing. [08/31",
        "ADDR:118 E PINE ST",
        "CALL:EMS ALERT",
        "ID:1204821",
        "INFO:81 year old, Female, Conscious, Breathing.");

    doTest("T12",
        "CAD:503 GARY ST;1204825;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 21 year old, Male, Unconscious, Breathing. CONTINUOUS or MULTIPLE seizures",
        "ADDR:503 GARY ST",
        "CALL:EMS ALERT",
        "ID:1204825",
        "INFO:21 year old, Male, Unconscious, Breathing. CONTINUOUS or MULTIPLE seizures");

    doTest("T13",
        "CAD:620 N SECOND ST;1204826;[Medical Priority Info] Key Questions Complete RESPONSE: Amb & Rescue RESPONDER SCRIPT: 81 year old, Male, Conscious, Breathing. [09/01",
        "ADDR:620 N SECOND ST",
        "CALL:EMS ALERT",
        "ID:1204826",
        "INFO:81 year old, Male, Conscious, Breathing.");

    doTest("T14",
        "CAD:4401 E DEANER RD;1204828;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 45 year old, Male, Unconscious, Breathing status unknown. Unconscious",
        "ADDR:4401 E DEANER RD",
        "CALL:EMS ALERT",
        "ID:1204828",
        "INFO:45 year old, Male, Unconscious, Breathing status unknown. Unconscious");

    doTest("T15",
        "CAD:620-103 S SECOND ST;1204832;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 79 year old, Male, Conscious, Breathing. NON-RECENT (=> 6hrs) inju ",
        "ADDR:620-103 S SECOND ST",
        "MADDR:620 S SECOND ST",
        "CALL:EMS ALERT",
        "ID:1204832",
        "INFO:79 year old, Male, Conscious, Breathing. NON-RECENT (=> 6hrs) inju");

  }
  
  public static void main(String[] args) {
    new MIMontcalmCountyParserTest().generateTests("T1");
  }
}
