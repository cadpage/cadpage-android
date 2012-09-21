package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHLawrenceCountyParserTest extends BaseParserTest {
  
  public OHLawrenceCountyParserTest() {
    setParser(new OHLawrenceCountyParser(), "LAWRENCE COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "alert:[121]- NATURE: F 15B LOCATION: US 52 / CO RD 450 PERRY TW P COMMENTS: +038.420273 -082.572212 CF=100% Example of an intersection call that came from a cell phone.",
        "UNIT:121",
        "CODE:F 15B",
        "CALL:Motorcycle/ATV Crash",
        "ADDR:US 52 & CO RD 450",
        "MADDR:US 52 & COUNTY ROAD 450",
        "CITY:PERRY TWP",
        "INFO:+038.420273 -082.572212 CF=100% Example of an intersection call that came from a cell phone.");

    doTest("T2",
        "alert:[121]- NATURE: E 29 LOCATION: 943 MARION PKE COAL GROVE COMMENTS: Example of a call from a address inside a muni cipality.",
        "UNIT:121",
        "CALL:E 29",
        "ADDR:943 MARION PKE",
        "CITY:COAL GROVE",
        "INFO:Example of a call from a address inside a muni cipality.");

    doTest("T3",
        "alert:[121]- NATURE: E 49 LOCATION: 59 PVT DR 7882 CO RD 15 FA YETTE TWP COMMENTS: Example of a call from a private drive . \"Fayette Twp\" is the name of the township the call is loca ted in",
        "UNIT:121",
        "CALL:E 49",
        "ADDR:59 PVT DR 7882 CO RD 15",
        "MADDR:59 PVT DR 7882",
        "CITY:FAYETTE TWP",
        "INFO:Example of a call from a private drive . \"Fayette Twp\" is the name of the township the call is loca ted in");

    doTest("T4",
        "alert:[121]- NATURE: E 10M LOCATION: 6405 STATE RTE 141 LAWRENC E TWP This is an example of a call at an address on a st ate route.",
        "UNIT:121",
        "CALL:E 10M",
        "ADDR:6405 STATE RTE 141",
        "MADDR:6405 STATE 141",
        "NAME:LAWRENC E TWP This is an example of a call at an address on a st ate route");

    doTest("T5",
        "alert:[121]- NATURE: S 72 LOCATION: 2101 N 2 ST IRONTON COMMEN TS: This is an example of a run inside a municipality wi th a street direction. In long form this would be 2101 North 2nd Street Ironton, Ohio",
        "UNIT:121",
        "CALL:S 72",
        "ADDR:2101 N 2 ST",
        "CITY:IRONTON",
        "INFO:This is an example of a run inside a municipality wi th a street direction. In long form this would be 2101 North 2nd Street Ironton, Ohio");

    doTest("T6",
        "alert:[121]- NATURE: ABD LOCATION: 989 TWP RD 161 FAYETTE TWP COMMENTS: This is an example of a call on a township ro ad.",
        "UNIT:121",
        "CALL:ABD",
        "ADDR:989 TWP RD",
        "APT:161",
        "NAME:FAYETTE TWPCOMMENTS: This is an example of a call on a township ro ad");

    doTest("T7",
        "alert:[121]- NATURE: E 48A LOCATION: 24 TWP RD 1101 W FAYETTE T WP COMMENTS: This is an example of a call on a township wi th a direction. The long form would be 24 Township Road 1101 West",
        "UNIT:121",
        "CALL:E 48A",
        "ADDR:24 TWP RD 1101 W",
        "CITY:FAYETTE TWP",
        "INFO:This is an example of a call on a township wi th a direction. The long form would be 24 Township Road 1101 West");

  }
  
  @Test
  public void testActive911A() {


    doTest("T1",
        "alert:[121]- NATURE: E 40 LOCATION: 11024 CO RD 1 UNION TWP CO MMENTS: Test page for Fayete FD",
        "UNIT:121",
        "CALL:E 40",
        "ADDR:11024 CO RD 1",
        "MADDR:11024 COUNTY ROAD 1",
        "CITY:UNION TWP",
        "INFO:Test page for Fayete FD");

    doTest("T2",
        "alert:[112]- NATURE: F 33 LOCATION: 264 TWP RD 1030 FAYETTE TW P COMMENTS: +038.404287 -082.540090 CF=100% CALLER REPORT ED A STRUCTURE FIRE AT THIS LOCATION WITH FLAMES VISIBLE",
        "UNIT:112",
        "CODE:F 33",
        "CALL:Structure Fire",
        "ADDR:264 TWP RD 1030",
        "CITY:FAYETTE TWP",
        "INFO:+038.404287 -082.540090 CF=100% CALLER REPORT ED A STRUCTURE FIRE AT THIS LOCATION WITH FLAMES VISIBLE");

    doTest("T3",
        "alert:[103]- NATURE: F 15 LOCATION: 389 CO RD 120 S FAYETTE TW P COMMENTS: MVA US 52/MURPHYS GAS UNKNOWN",
        "UNIT:103",
        "CODE:F 15",
        "CALL:Vehicle Crash",
        "ADDR:389 CO RD 120 S",
        "MADDR:389 COUNTY ROAD 120 S",
        "CITY:FAYETTE TWP",
        "INFO:MVA US 52/MURPHYS GAS UNKNOWN");

    doTest("T4",
        "alert:[103]- NATURE: E 29 LOCATION: 8308 CO RD 1 FAYETTE TWP C OMMENTS: CALLER ADVISES SHE HAD HEART SURGERY A WEEK AGO AND IS HAVING FLUTTERING, CHEST PAIN. WHITE HOUSE, PT WILL BE O N FRONT PORCH. MED 11 ID 168/258T",
        "UNIT:103",
        "CALL:E 29",
        "ADDR:8308 CO RD 1",
        "MADDR:8308 COUNTY ROAD 1",
        "CITY:FAYETTE TWP",
        "INFO:CALLER ADVISES SHE HAD HEART SURGERY A WEEK AGO AND IS HAVING FLUTTERING, CHEST PAIN. WHITE HOUSE, PT WILL BE O N FRONT PORCH. MED 11 ID 168/258T");

    doTest("T5",
        "alert:[107]- NATURE: E 15 LOCATION: 155 CO RD 406 FAYETTE TWP 2 CAR MVC WITH INJURIES",
        "UNIT:107",
        "CALL:E 15",
        "ADDR:155 CO RD 406",
        "MADDR:155 COUNTY ROAD 406",
        "CITY:FAYETTE TWP",
        "NAME:2 CAR MVC WITH INJURIES");

    doTest("T6",
        "alert:[136]- NATURE: S38 LOCATION: 602 BRUBAKER DR SOUTH POIN T COMMENTS: LCSO REQUESTS FD FOR ASSISTANCE MISSING MAN 72Y /O GREY HOODIE AND BLUE JEANS MISSING SOMETIME BETWEEN 1 AM AND 8 AM THIS MORNING",
        "UNIT:136",
        "CALL:S38",
        "ADDR:602 BRUBAKER DR",
        "CITY:SOUTH POINT",
        "INFO:LCSO REQUESTS FD FOR ASSISTANCE MISSING MAN 72Y /O GREY HOODIE AND BLUE JEANS MISSING SOMETIME BETWEEN: 1 AM AND 8 AM THIS MORNING");

    doTest("T7",
        "alert:[121]- NATURE: E 5L LOCATION: 51 PVT DR 1085 TWP RD 135 FAYETTE TWP COMMENTS: MED CARE FROM COLUMBUS REQUESTED LIFT ING WITH PT 600 LBS AQUEDA FINKS CONTACTED SUPRV AND HE S TATED NO LIFTING ASSIT TO CALL PORTSMOUTH AMBULANCE",
        "UNIT:121",
        "CALL:E 5L",
        "ADDR:51 PVT DR 1085 TWP RD 135",
        "MADDR:51 PVT DR 1085",
        "CITY:FAYETTE TWP",
        "INFO:MED CARE FROM COLUMBUS REQUESTED LIFT ING WITH PT 600 LBS AQUEDA FINKS CONTACTED SUPRV AND HE S TATED NO LIFTING ASSIT TO CALL PORTSMOUTH AMBULANCE");

    doTest("T8",
        "alert:[103]- NATURE: F 15 LOCATION: 389 CO RD 120 S FAYETTE TW P COMMENTS: MVA WB LANE POSS INJURY MURPHYS GAS /US 52",
        "UNIT:103",
        "CODE:F 15",
        "CALL:Vehicle Crash",
        "ADDR:389 CO RD 120 S",
        "MADDR:389 COUNTY ROAD 120 S",
        "CITY:FAYETTE TWP",
        "INFO:MVA WB LANE POSS INJURY MURPHYS GAS /US 52");

    doTest("T9",
        "alert:[107]- NATURE: O 31 LOCATION: 9353 CO RD 1 FAYETTE TWP C OMMENTS: CALLER REPORTS A CAR HIT A POLE NEAR THE AIRPORT . NEGATIVE INJURIES. TRANSFERRED TO THE OSP THIS CAR IS SMOKI NG",
        "UNIT:107",
        "CALL:O 31",
        "ADDR:9353 CO RD 1",
        "MADDR:9353 COUNTY ROAD 1",
        "CITY:FAYETTE TWP",
        "INFO:CALLER REPORTS A CAR HIT A POLE NEAR THE AIRPORT . NEGATIVE INJURIES. TRANSFERRED TO THE OSP THIS CAR IS SMOKI NG");

  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "alert:[107]- NATURE: E 59 LOCATION: 40 TWP RD 1001 AID TWP COM MENTS: SHE THINKS VIRGIL MAY HAVE PHENOMONIA. ADVISED MEDIC 51 IDS 306T-116",
        "UNIT:107",
        "CALL:E 59",
        "ADDR:40 TWP RD 1001",
        "CITY:AID TWP",
        "INFO:SHE THINKS VIRGIL MAY HAVE PHENOMONIA. ADVISED MEDIC 51 IDS 306T-116");

    doTest("T2",
        "alert:[120]- NATURE: F 46 LOCATION: 4219 CO RD 16 AID TWP COMM ENTS: CALLER STATES THAT A TREE IS ON FIRE JUST UP FROM HER HOUSE. ALERTED ST 100 ADVISED BUCKEYE POWER CO.",
        "UNIT:120",
        "CODE:F 46",
        "CALL:Utility lines Down",
        "ADDR:4219 CO RD 16",
        "MADDR:4219 COUNTY ROAD 16",
        "CITY:AID TWP",
        "INFO:CALLER STATES THAT A TREE IS ON FIRE JUST UP FROM HER HOUSE. ALERTED ST 100 ADVISED BUCKEYE POWER CO.");

  }
  
  @Test
  public void testActive911C() {

    doTest("T1",
        "alert:[136]- NATURE: S38 LOCATION: 602 BRUBAKER DR SOUTH POIN T COMMENTS: LCSO REQUESTS FD FOR ASSISTANCE MISSING MAN 72Y /O GREY HOODIE AND BLUE JEANS MISSING SOMETIME BETWEEN 1 AM AND 8 AM THIS MORNING",
        "UNIT:136",
        "CALL:S38",
        "ADDR:602 BRUBAKER DR",
        "CITY:SOUTH POINT",
        "INFO:LCSO REQUESTS FD FOR ASSISTANCE MISSING MAN 72Y /O GREY HOODIE AND BLUE JEANS MISSING SOMETIME BETWEEN: 1 AM AND 8 AM THIS MORNING");

    doTest("T2",
        "alert:[121]- NATURE: E 15 LOCATION: 5400 STATE RTE 141 UPPER T WP COMMENTS: CALLER REPORTS A SINGLE VEHICLE MVC IN THE CREE K, POSSIBLE ENTRAPMENT. THREE PATIENTS. ALERTED ST 400/1500",
        "UNIT:121",
        "CALL:E 15",
        "ADDR:5400 STATE RTE 141",
        "MADDR:5400 STATE 141",
        "CITY:UPPER TWP",
        "INFO:CALLER REPORTS A SINGLE VEHICLE MVC IN THE CREE K, POSSIBLE ENTRAPMENT. THREE PATIENTS. ALERTED ST 400/1500");

    doTest("T3",
        "alert:[121]- NATURE: TEST LOCATION: 8064 CO RD 2 WINDSOR TWP C OMMENTS: ACTIVE911 TEST ALERT FOR COAL GROVE FD",
        "UNIT:121",
        "CALL:TEST",
        "ADDR:8064 CO RD 2",
        "MADDR:8064 COUNTY ROAD 2",
        "CITY:WINDSOR TWP",
        "INFO:ACTIVE911 TEST ALERT FOR COAL GROVE FD");

    doTest("T4",
        "alert:[107]- NATURE: E 52 LOCATION: 613 PIKE ST COAL GROVE",
        "UNIT:107",
        "CALL:E 52",
        "ADDR:613 PIKE ST",
        "CITY:COAL GROVE");

  }
  
  public static void main(String[] args) {
    new OHLawrenceCountyParserTest().generateTests("T1");
  }
}