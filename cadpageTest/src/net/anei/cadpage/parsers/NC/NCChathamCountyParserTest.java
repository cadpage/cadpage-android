package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NC.NCChathamCountyParserTest;

import org.junit.Test;

/*
Chattam County, NC
Contact: Bill <leatherheadfirefighter@yahoo.com>
Sender: @chathamnc.org

FRM:HEATHER.BOONE@chathamnc.org
MSG:HEATHER.BOONE:399 LYNDFIELD CLOSE PITTSBORO MDL 10D04 1119468 18:13:33 Chest Pains- Clammy HUSBAND HAVING CHEST PAINS - EMER

FRM:HEATHER.BOONE@chathamnc.org
MSG:HEATHER.BOONE:791 RED GATE RD PITTSBORO 1119520 05:38:59 medical call HUSBAND OFF BALCONY

1 of 2
FRM:LISA.SCOTT@chathamnc.org
MSG:LISA.SCOTT:965 SEAFORTH BEACH RD PITTSBORO 1119461 17:08:12 medical call 10YOM WEARING WHITE SHORTS
(Con't) 2 of 2
NAMED TRAY LAST SEEN APPROX 4 MINS AGO(End)

1 of 2
FRM:KIM.HANNER@chathamnc.org
MSG:KIM.HANNER:858 BRUMLEY PITTSBORO MDL 31C02 1119495 22:11:57 Unconscious / Fainting (Near) Fainting
(Con't) 2 of 2
episodes an WIFE PASSED OUT, IS CONS NOW(End)

1 of 2
FRM:KIM.HANNER@chathamnc.org
MSG:KIM.HANNER:475 NATURE TRAIL RD CHAPEL HILL 1119504 00:09:15 Convulsions/ Seizures- CONTINUOUS or
(Con't) 2 of 2
MULTIPLE seiz PREVIOUS CALL FOR THIS ADDRESS WITH THIS NUMBER GIVEN BY CARY PD UNKNOWN PROBLEM POSSIBLE SEIZURES(End)


Contact: C Stephens <scubastevechfd@gmail.com>
Sender: TRACY.BALDWIN__@chathamnc.org
  / TRACY.BALDWIN__:602 N SECOND AVE SILER CITY 1207466 16:44:01 medical call caller christie harris subj having chest pain\n

Contact: David Reeves <dmreeves@gtcc.edu>
Sender: HEATHER.BOONE@chathamnc.org
HEATHER.BOONE:1319 HODGE ST SILER CITY, 1236367, 23:39:03, Smoke Detector Activation, SMOKE DETECTOR IS BEEPING AND HAS BEEN FOR APPROX 40 MINS

*/

public class NCChathamCountyParserTest extends BaseParserTest {
  
  public NCChathamCountyParserTest() {
    setParser(new NCChathamCountyParser(), "CHATHAM COUNTY", "NC");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "HEATHER.BOONE:399 LYNDFIELD CLOSE PITTSBORO MDL 10D04 1119468 18:13:33 Chest Pains- Clammy HUSBAND HAVING CHEST PAINS - EMER",
        "ADDR:399 LYNDFIELD CLOSE",
        "CITY:PITTSBORO",
        "CODE:10D04",
        "ID:1119468",
        "TIME:18:13:33",
        "INFO:Chest Pains- Clammy HUSBAND HAVING CHEST PAINS - EMER");

    doTest("T2",
        "HEATHER.BOONE:791 RED GATE RD PITTSBORO 1119520 05:38:59 medical call HUSBAND OFF BALCONY",
        "ADDR:791 RED GATE RD",
        "CITY:PITTSBORO",
        "ID:1119520",
        "TIME:05:38:59",
        "INFO:medical call HUSBAND OFF BALCONY");

    doTest("T3",
        "LISA.SCOTT:965 SEAFORTH BEACH RD PITTSBORO 1119461 17:08:12 medical call 10YOM WEARING WHITE SHORTS NAMED TRAY LAST SEEN APPROX 4 MINS AGO(End)",
        "ADDR:965 SEAFORTH BEACH RD",
        "CITY:PITTSBORO",
        "ID:1119461",
        "TIME:17:08:12",
        "INFO:medical call 10YOM WEARING WHITE SHORTS NAMED TRAY LAST SEEN APPROX 4 MINS AGO(End)");

    doTest("T4",
        "KIM.HANNER:858 BRUMLEY PITTSBORO MDL 31C02 1119495 22:11:57 Unconscious / Fainting (Near) Fainting episodes an WIFE PASSED OUT, IS CONS NOW(End)",
        "ADDR:858 BRUMLEY",
        "CITY:PITTSBORO",
        "CODE:31C02",
        "ID:1119495",
        "TIME:22:11:57",
        "CALL:Unconscious",
        "INFO:Fainting (Near) Fainting episodes an WIFE PASSED OUT, IS CONS NOW(End)");

    doTest("T5",
        "KIM.HANNER:475 NATURE TRAIL RD CHAPEL HILL 1119504 00:09:15 Convulsions/ Seizures- CONTINUOUS or MULTIPLE seiz PREVIOUS CALL FOR THIS ADDRESS WITH THIS NUMBER GIVEN BY CARY PD UNKNOWN PROBLEM POSSIBLE SEIZURES(End)",
        "ADDR:475 NATURE TRAIL RD",
        "CITY:CHAPEL HILL",
        "ID:1119504",
        "TIME:00:09:15",
        "INFO:Convulsions/ Seizures- CONTINUOUS or MULTIPLE seiz PREVIOUS CALL FOR THIS ADDRESS WITH THIS NUMBER GIVEN BY CARY PD UNKNOWN PROBLEM POSSIBLE SEIZURES(End)");

    doTest("T6",
        "  / TRACY.BALDWIN__:602 N SECOND AVE SILER CITY 1207466 16:44:01 medical call caller christie harris subj having chest pain\n",
        "ADDR:602 N SECOND AVE",
        "CITY:SILER CITY",
        "ID:1207466",
        "TIME:16:44:01",
        "INFO:medical call caller christie harris subj having chest pain");

    doTest("T7",
        "HEATHER.BOONE:1319 HODGE ST SILER CITY, 1236367, 23:39:03, Smoke Detector Activation, SMOKE DETECTOR IS BEEPING AND HAS BEEN FOR APPROX 40 MINS",
        "ADDR:1319 HODGE ST",
        "CITY:SILER CITY",
        "ID:1236367",
        "TIME:23:39:03",
        "CALL:Smoke Detector Activation",
        "INFO:SMOKE DETECTOR IS BEEPING AND HAS BEEN FOR APPROX 40 MINS");

  }
  
  public static void main(String[] args) {
    new NCChathamCountyParserTest().generateTests("T1");
  }
}