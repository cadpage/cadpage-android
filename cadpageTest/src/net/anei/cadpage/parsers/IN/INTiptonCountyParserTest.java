package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.IN.INTiptonCountyParser;

import org.junit.Test;

/*
Tipton County, IN
reporting email: Amy Lane <ammlane@gmail.com>
sender: CAD@tipco.com
CAD:A5,R45,T43,E42,E41,T46;STRUCTURE FIRE RESIDENTIAL;4003;3000 N US 31 NB
CAD:WEATHER;SEVERE WEATHER;CITY;121-A W MADISON ST
CAD:G49;OUTSIDE FIRE-FIELD/WOODS;6001;6500 N 400 E
CAD:A5,R45;INJURED IN FALL;4000;E VINE ST/S WASHINGTON ST;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: You are responding to a patient involved in a fall
CAD:A5,R45;UNKNOWN MEDICAL PROBLEM;4004;3421 N SR 19;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: You are responding to a patient with an unknown problem
CAD:A5,R45;INJURED IN FALL;4002;304 E 625 N;hx of dementia [10/06/10 18:51:56 DARCIR] [Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: You are responding to
CAD:G49;OUTSIDE FIRE-FIELD/WOODS;6001;6500 N 400 E


Contact: Active911
Agency name: Cicero Twp. Vol. Fire Dept
Location: Tipton, IN, United States
Sender: CAD@tipco.com

CAD:A22,E21,R25;MVA UNKNOWN;2011;5999 S SR 19;[LAW] NO HELMET ON [03/31/13 21:52:24 TOMG] MOTORCYCLE ACCIDENT [03/31/13 21:50:39 TOMG]
CAD:A22,E21,R25;MVA/PERSONAL INJURY;2004;132 S 500 W;NECK PAIN [03/31/13 19:53:00 TOMG] [LAW] 4 WHEELER ACCIDENT 11 YEAR MALE [03/31/13 19:52:15 TOMG]
CAD:A22;UNKNOWN MEDICAL PROBLEM;5005;2845 S SR 213;[Medical Priority Info] PROBLEM: man down # PATS: 1 AGE: Unknown Range SEX: Male CONSCIOUS: Yes BREATHING: Yes RESPONSE: Bravo [03/29/13 16:11:13 KGONZALEZ]
CAD:A22,E21;UNCONSCIOUS PERSON / FAINTING;2008;3930 S SR 19;[Medical Priority Info] PROBLEM: fainted # PATS: 1 AGE: 83 Years SEX: Male CONSCIOUS: Yes BREATHING: Yes RESPONSE: Delta [03/29/13 15:26:22 KGONZALEZ]
CAD:WEATHR;SEVERE WEATHER;TIPTON COUNTY;THIS IS A STATE WIDE TORNADO DRILL. TEST ONLY. NWS/TCC [03/27/13 19:33:52 EROBISON]
CAD:A22,E21;SICK PERSON;2005;1126 W 300 S;[Medical Priority Info] PROBLEM: SICK # PATS: 1 AGE: 87 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes RESPONSE: Alpha [03/27/13 17:59:59 WRUSSELL]
CAD:WEATHR;SEVERE WEATHER;TIPTON COUNTY;STATEWIDE TORNADO DRILL [03/27/13 10:15:14 WRUSSELL]
CAD:WEATHR;SEVERE WEATHER;TRI CENTRAL;TRI CENTRAL IS CLOSED TODAY 3-25-13 [03/25/13 06:19:30 VJARRETT]
CAD:WEATHR;SEVERE WEATHER;TIPTON SCHOOL;TIPTON SCHOOL IS ON A 2 HOUR DELAY TOMORROW [03/24/13 21:05:49 VJARRETT]
CAD:WEATHR;SEVERE WEATHER;TRI CENTRAL;TRI CENTRAL WILL BE ON A 2 HOUR DELAY TOMORROW [03/24/13 20:58:10 VJARRETT]
CAD:A22,E21,R25;MVA/PERSONAL INJURY;2001;4000 W DIVISION RD;[LAW] driver is out of the vehicle [03/24/13 19:20:20 TBAKER] inverted vehilce [03/24/13 19:19:42 TBAKER]
CAD:WEATHR;SEVERE WEATHER;TIPTON COUNTY;WINTER STORM WARNING IN EFFECT FROM 8 AM SUNDAY 3-24-13 TO 12:00 PM MONDAY 3-25-13 [03/23/13 20:54:40 VJARRETT]
CAD:S35,T34,G27,E31,E21,R25,T23,T24;ILLEGAL/OPEN BURN;2004;729 S US 31;304 enroute [03/23/13 07:21:44 JHAYES] STATION 30 CLEAR [03/23/13 07:20:23 VJARRETT] LARGE AMOUNTS OF BLACK SMOKE [03/23/13 07:20:03 VJARRETT]
CAD:WEATHR;SEVERE WEATHER;TIPTON COUNTY;NWS HAS ISSUED WINTER STORM WATCH FOR TIPTON CO IN EFFECT FROM 0800 SUNDAY 4/24/13 TO 1200 MONDAY 4/25/13. 5-9 IN OF HEAVY WET SNOW ARE EXPECTED. AUTH NWS/TCC [03/22/13 22:34:00 TBAKER]
CAD:A22,E21;INJURED IN FALL;2005;1114 LEININGER DR;[Medical Priority Info] PROBLEM: # PATS: 1 AGE: 79 Years SEX: Male CONSCIOUS: Yes BREATHING: Yes RESPONSE: Alpha [03/22/13 10:08:59 MSCHWARTZ]
CAD:S35,E32,E21;MVA UNKNOWN;2001;1000 N US 31 NB
CAD:A22,E21;SICK PERSON;2005;2360 W 300 S;[Medical Priority Info] PROBLEM: SICK # PATS: 1 AGE: 38 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes RESPONSE: Alpha [03/21/13 22:41:15 TOMG]
CAD:A22,E21;INJURED IN FALL;2005;2360 W 300 S;[Medical Priority Info] PROBLEM: FALL # PATS: 1 AGE: 38 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes RESPONSE: Delta [03/21/13 21:42:15 TOMG]
CAD:E21,R25,T23;INVESTIGATION/ODORS;2007;W SR 28/S US 31 NB;cp stated he was driving northbound in the area, and could smell what appeared to be natural gas [03/21/13 17:20:29 KGONZALEZ]
CAD:A22,E21;INJURED IN FALL;2008;3492 S SR 19;[Medical Priority Info] PROBLEM: FALL # PATS: 1 AGE: 91 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes RESPONSE: Alpha [03/16/13 12:34:47 WRUSSELL]

*/

public class INTiptonCountyParserTest extends BaseParserTest {
  
  public INTiptonCountyParserTest() {
    setParser(new INTiptonCountyParser(), "TIPTON COUNTY", "IN");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "CAD:A5,R45,T43,E42,E41,T46;STRUCTURE FIRE RESIDENTIAL;4003;3000 N US 31 NB",
        "UNIT:A5,R45,T43,E42,E41,T46",
        "CALL:STRUCTURE FIRE RESIDENTIAL",
        "MAP:4003",
        "ADDR:3000 N US 31 NB",
        "MADDR:3000 N US 31");

    doTest("T2",
        "CAD:WEATHER;SEVERE WEATHER;CITY;121-A W MADISON ST",
        "UNIT:WEATHER",
        "CALL:SEVERE WEATHER",
        "MAP:CITY",
        "ADDR:121-A W MADISON ST",
        "MADDR:121 W MADISON ST");
    
    doTest("T3",
        "CAD:G49;OUTSIDE FIRE-FIELD/WOODS;6001;6500 N 400 E",
        "UNIT:G49",
        "CALL:OUTSIDE FIRE-FIELD/WOODS",
        "MAP:6001",
        "ADDR:6500 N 400 E");
    
    doTest("T4",
        "CAD:A5,R45;INJURED IN FALL;4000;E VINE ST/S WASHINGTON ST;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: You are responding to a patient involved in a fall",
        "UNIT:A5,R45",
        "CALL:INJURED IN FALL",
        "MAP:4000",
        "ADDR:E VINE ST & S WASHINGTON ST",
        "INFO:You are responding to a patient involved in a fall");
    
    doTest("T5",
        "CAD:A5,R45;UNKNOWN MEDICAL PROBLEM;4004;3421 N SR 19;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: You are responding to a patient with an unknown problem",
        "UNIT:A5,R45",
        "CALL:UNKNOWN MEDICAL PROBLEM",
        "MAP:4004",
        "ADDR:3421 N SR 19",
        "MADDR:3421 N IN 19",
        "INFO:You are responding to a patient with an unknown problem");
    
    doTest("T6",
        "CAD:A5,R45;INJURED IN FALL;4002;304 E 625 N;hx of dementia [10/06/10 18:51:56 DARCIR] [Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: You are responding to",
        "UNIT:A5,R45",
        "CALL:INJURED IN FALL",
        "MAP:4002",
        "ADDR:304 E 625 N",
        "INFO:hx of dementia / You are responding to",
        "DATE:10/06/10",
        "TIME:18:51:56");
    
    doTest("T7",
        "CAD:G49;OUTSIDE FIRE-FIELD/WOODS;6001;6500 N 400 E",
        "UNIT:G49",
        "CALL:OUTSIDE FIRE-FIELD/WOODS",
        "MAP:6001",
        "ADDR:6500 N 400 E");
    
  }
  
  @Test
  public void testCiceroTwpVolFireDept() {

    doTest("T1",
        "CAD:A22,E21,R25;MVA UNKNOWN;2011;5999 S SR 19;[LAW] NO HELMET ON [03/31/13 21:52:24 TOMG] MOTORCYCLE ACCIDENT [03/31/13 21:50:39 TOMG]",
        "UNIT:A22,E21,R25",
        "CALL:MVA UNKNOWN",
        "MAP:2011",
        "ADDR:5999 S SR 19",
        "MADDR:5999 S IN 19",
        "INFO:NO HELMET ON / MOTORCYCLE ACCIDENT",
        "DATE:03/31/13",
        "TIME:21:52:24");

    doTest("T2",
        "CAD:A22,E21,R25;MVA/PERSONAL INJURY;2004;132 S 500 W;NECK PAIN [03/31/13 19:53:00 TOMG] [LAW] 4 WHEELER ACCIDENT 11 YEAR MALE [03/31/13 19:52:15 TOMG]",
        "UNIT:A22,E21,R25",
        "CALL:MVA/PERSONAL INJURY",
        "MAP:2004",
        "ADDR:132 S 500 W",
        "INFO:NECK PAIN / 4 WHEELER ACCIDENT 11 YEAR MALE",
        "DATE:03/31/13",
        "TIME:19:53:00");

    doTest("T3",
        "CAD:A22;UNKNOWN MEDICAL PROBLEM;5005;2845 S SR 213;[Medical Priority Info] PROBLEM: man down # PATS: 1 AGE: Unknown Range SEX: Male CONSCIOUS: Yes BREATHING: Yes RESPONSE: Bravo [03/29/13 16:11:13 KGONZALEZ]",
        "UNIT:A22",
        "CALL:UNKNOWN MEDICAL PROBLEM",
        "MAP:5005",
        "ADDR:2845 S SR 213",
        "MADDR:2845 S IN 213",
        "INFO:man down # PATS: 1 AGE: Unknown Range SEX: Male CONSCIOUS: Yes BREATHING: Yes RESPONSE: Bravo",
        "DATE:03/29/13",
        "TIME:16:11:13");

    doTest("T4",
        "CAD:A22,E21;UNCONSCIOUS PERSON / FAINTING;2008;3930 S SR 19;[Medical Priority Info] PROBLEM: fainted # PATS: 1 AGE: 83 Years SEX: Male CONSCIOUS: Yes BREATHING: Yes RESPONSE: Delta [03/29/13 15:26:22 KGONZALEZ]",
        "UNIT:A22,E21",
        "CALL:UNCONSCIOUS PERSON / FAINTING",
        "MAP:2008",
        "ADDR:3930 S SR 19",
        "MADDR:3930 S IN 19",
        "INFO:fainted # PATS: 1 AGE: 83 Years SEX: Male CONSCIOUS: Yes BREATHING: Yes RESPONSE: Delta",
        "DATE:03/29/13",
        "TIME:15:26:22");

    doTest("T5",
        "CAD:WEATHR;SEVERE WEATHER;TIPTON COUNTY;THIS IS A STATE WIDE TORNADO DRILL. TEST ONLY. NWS/TCC [03/27/13 19:33:52 EROBISON]",
        "UNIT:WEATHR",
        "CALL:SEVERE WEATHER",
        "ADDR:TIPTON COUNTY",
        "INFO:THIS IS A STATE WIDE TORNADO DRILL. TEST ONLY. NWS/TCC",
        "DATE:03/27/13",
        "TIME:19:33:52");

    doTest("T6",
        "CAD:A22,E21;SICK PERSON;2005;1126 W 300 S;[Medical Priority Info] PROBLEM: SICK # PATS: 1 AGE: 87 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes RESPONSE: Alpha [03/27/13 17:59:59 WRUSSELL]",
        "UNIT:A22,E21",
        "CALL:SICK PERSON",
        "MAP:2005",
        "ADDR:1126 W 300 S",
        "INFO:SICK # PATS: 1 AGE: 87 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes RESPONSE: Alpha",
        "DATE:03/27/13",
        "TIME:17:59:59");

    doTest("T7",
        "CAD:WEATHR;SEVERE WEATHER;TIPTON COUNTY;STATEWIDE TORNADO DRILL [03/27/13 10:15:14 WRUSSELL]",
        "UNIT:WEATHR",
        "CALL:SEVERE WEATHER",
        "ADDR:TIPTON COUNTY",
        "INFO:STATEWIDE TORNADO DRILL",
        "DATE:03/27/13",
        "TIME:10:15:14");

    doTest("T8",
        "CAD:WEATHR;SEVERE WEATHER;TRI CENTRAL;TRI CENTRAL IS CLOSED TODAY 3-25-13 [03/25/13 06:19:30 VJARRETT]",
        "UNIT:WEATHR",
        "CALL:SEVERE WEATHER",
        "ADDR:TRI CENTRAL",
        "INFO:TRI CENTRAL IS CLOSED TODAY 3-25-13",
        "DATE:03/25/13",
        "TIME:06:19:30");

    doTest("T9",
        "CAD:WEATHR;SEVERE WEATHER;TIPTON SCHOOL;TIPTON SCHOOL IS ON A 2 HOUR DELAY TOMORROW [03/24/13 21:05:49 VJARRETT]",
        "UNIT:WEATHR",
        "CALL:SEVERE WEATHER",
        "ADDR:TIPTON SCHOOL",
        "INFO:TIPTON SCHOOL IS ON A 2 HOUR DELAY TOMORROW",
        "DATE:03/24/13",
        "TIME:21:05:49");

    doTest("T10",
        "CAD:WEATHR;SEVERE WEATHER;TRI CENTRAL;TRI CENTRAL WILL BE ON A 2 HOUR DELAY TOMORROW [03/24/13 20:58:10 VJARRETT]",
        "UNIT:WEATHR",
        "CALL:SEVERE WEATHER",
        "ADDR:TRI CENTRAL",
        "INFO:TRI CENTRAL WILL BE ON A 2 HOUR DELAY TOMORROW",
        "DATE:03/24/13",
        "TIME:20:58:10");

    doTest("T11",
        "CAD:A22,E21,R25;MVA/PERSONAL INJURY;2001;4000 W DIVISION RD;[LAW] driver is out of the vehicle [03/24/13 19:20:20 TBAKER] inverted vehilce [03/24/13 19:19:42 TBAKER]",
        "UNIT:A22,E21,R25",
        "CALL:MVA/PERSONAL INJURY",
        "MAP:2001",
        "ADDR:4000 W DIVISION RD",
        "INFO:driver is out of the vehicle / inverted vehilce",
        "DATE:03/24/13",
        "TIME:19:20:20");

    doTest("T12",
        "CAD:WEATHR;SEVERE WEATHER;TIPTON COUNTY;WINTER STORM WARNING IN EFFECT FROM 8 AM SUNDAY 3-24-13 TO 12:00 PM MONDAY 3-25-13 [03/23/13 20:54:40 VJARRETT]",
        "UNIT:WEATHR",
        "CALL:SEVERE WEATHER",
        "ADDR:TIPTON COUNTY",
        "INFO:WINTER STORM WARNING IN EFFECT FROM 8 AM SUNDAY 3-24-13 TO 12:00 PM MONDAY 3-25-13",
        "DATE:03/23/13",
        "TIME:20:54:40");

    doTest("T13",
        "CAD:S35,T34,G27,E31,E21,R25,T23,T24;ILLEGAL/OPEN BURN;2004;729 S US 31;304 enroute [03/23/13 07:21:44 JHAYES] STATION 30 CLEAR [03/23/13 07:20:23 VJARRETT] LARGE AMOUNTS OF BLACK SMOKE [03/23/13 07:20:03 VJARRETT]",
        "UNIT:S35,T34,G27,E31,E21,R25,T23,T24",
        "CALL:ILLEGAL/OPEN BURN",
        "MAP:2004",
        "ADDR:729 S US 31",
        "INFO:304 enroute / STATION 30 CLEAR / LARGE AMOUNTS OF BLACK SMOKE",
        "DATE:03/23/13",
        "TIME:07:21:44");

    doTest("T14",
        "CAD:WEATHR;SEVERE WEATHER;TIPTON COUNTY;NWS HAS ISSUED WINTER STORM WATCH FOR TIPTON CO IN EFFECT FROM 0800 SUNDAY 4/24/13 TO 1200 MONDAY 4/25/13. 5-9 IN OF HEAVY WET SNOW ARE EXPECTED. AUTH NWS/TCC [03/22/13 22:34:00 TBAKER]",
        "UNIT:WEATHR",
        "CALL:SEVERE WEATHER",
        "ADDR:TIPTON COUNTY",
        "INFO:NWS HAS ISSUED WINTER STORM WATCH FOR TIPTON CO IN EFFECT FROM 0800 SUNDAY 4/24/13 TO 1200 MONDAY 4/25/13. 5-9 IN OF HEAVY WET SNOW ARE EXPECTED. AUTH NWS/TCC",
        "DATE:03/22/13",
        "TIME:22:34:00");

    doTest("T15",
        "CAD:A22,E21;INJURED IN FALL;2005;1114 LEININGER DR;[Medical Priority Info] PROBLEM: # PATS: 1 AGE: 79 Years SEX: Male CONSCIOUS: Yes BREATHING: Yes RESPONSE: Alpha [03/22/13 10:08:59 MSCHWARTZ]",
        "UNIT:A22,E21",
        "CALL:INJURED IN FALL",
        "MAP:2005",
        "ADDR:1114 LEININGER DR",
        "INFO:# PATS: 1 AGE: 79 Years SEX: Male CONSCIOUS: Yes BREATHING: Yes RESPONSE: Alpha",
        "DATE:03/22/13",
        "TIME:10:08:59");

    doTest("T16",
        "CAD:S35,E32,E21;MVA UNKNOWN;2001;1000 N US 31 NB",
        "UNIT:S35,E32,E21",
        "CALL:MVA UNKNOWN",
        "MAP:2001",
        "ADDR:1000 N US 31 NB",
        "MADDR:1000 N US 31");

    doTest("T17",
        "CAD:A22,E21;SICK PERSON;2005;2360 W 300 S;[Medical Priority Info] PROBLEM: SICK # PATS: 1 AGE: 38 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes RESPONSE: Alpha [03/21/13 22:41:15 TOMG]",
        "UNIT:A22,E21",
        "CALL:SICK PERSON",
        "MAP:2005",
        "ADDR:2360 W 300 S",
        "INFO:SICK # PATS: 1 AGE: 38 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes RESPONSE: Alpha",
        "DATE:03/21/13",
        "TIME:22:41:15");

    doTest("T18",
        "CAD:A22,E21;INJURED IN FALL;2005;2360 W 300 S;[Medical Priority Info] PROBLEM: FALL # PATS: 1 AGE: 38 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes RESPONSE: Delta [03/21/13 21:42:15 TOMG]",
        "UNIT:A22,E21",
        "CALL:INJURED IN FALL",
        "MAP:2005",
        "ADDR:2360 W 300 S",
        "INFO:FALL # PATS: 1 AGE: 38 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes RESPONSE: Delta",
        "DATE:03/21/13",
        "TIME:21:42:15");

    doTest("T19",
        "CAD:E21,R25,T23;INVESTIGATION/ODORS;2007;W SR 28/S US 31 NB;cp stated he was driving northbound in the area, and could smell what appeared to be natural gas [03/21/13 17:20:29 KGONZALEZ]",
        "UNIT:E21,R25,T23",
        "CALL:INVESTIGATION/ODORS",
        "MAP:2007",
        "ADDR:W SR 28 & S US 31 NB",
        "MADDR:W ST 28 & S US 31",
        "INFO:cp stated he was driving northbound in the area, and could smell what appeared to be natural gas",
        "DATE:03/21/13",
        "TIME:17:20:29");

    doTest("T20",
        "CAD:A22,E21;INJURED IN FALL;2008;3492 S SR 19;[Medical Priority Info] PROBLEM: FALL # PATS: 1 AGE: 91 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes RESPONSE: Alpha [03/16/13 12:34:47 WRUSSELL]",
        "UNIT:A22,E21",
        "CALL:INJURED IN FALL",
        "MAP:2008",
        "ADDR:3492 S SR 19",
        "MADDR:3492 S IN 19",
        "INFO:FALL # PATS: 1 AGE: 91 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes RESPONSE: Alpha",
        "DATE:03/16/13",
        "TIME:12:34:47");
   
  }
  
  public static void main(String[] args) {
    new INTiptonCountyParserTest().generateTests("T1");
  }
}