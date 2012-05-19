package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAWashingtonCountyParserTest extends BaseParserTest {
  
  public PAWashingtonCountyParserTest() {
    setParser(new PAWashingtonCountyParser(), "WASHINGTON COUNTY", "PA");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "Location: 116 GRANT ST MCDO Xstreet: NORTH ST STATION ST TYPE: STRUCTURE FIRE TIME: 23:42:41 Comments: IN THE BACK POSS 112 OR 114",
        "ADDR:116 GRANT ST",
        "CITY:MCDONALD",
        "X:NORTH ST & STATION ST",
        "CALL:STRUCTURE FIRE",
        "TIME:23:42:41",
        "INFO:IN THE BACK POSS 112 OR 114");

    doTest("T2",
        "Location: 50 STONECREST LN CECI Xstreet: MCCONNELL RD DEAD END TYPE: FIRE TIME: 23:40:09 Comments:",
        "ADDR:50 STONECREST LN",
        "CITY:CECIL TWP",
        "X:MCCONNELL RD DEAD END",
        "CALL:FIRE",
        "TIME:23:40:09");

    doTest("T3",
        "Location: 1647 MILLERS RUN RD MTPL: @KEEPSAKE ARABIANS Xstreet: PLEASANT RD FORT CHERRY RD TYPE: FIRE ALARM TIME: 22:31:54 Comments:",
        "ADDR:1647 MILLERS RUN RD",
        "CITY:MT PLEASANT TWP",
        "PLACE:KEEPSAKE ARABIANS",
        "X:PLEASANT RD & FORT CHERRY RD",
        "CALL:FIRE ALARM",
        "TIME:22:31:54");

    doTest("T4",
        "Location: 22 2ND ST CECI Xstreet: SCHOOL ST BOYCE ST TYPE: STRUCTURE FIRE TIME: 22:40:10 Comments:",
        "ADDR:22 2ND ST",
        "CITY:CECIL TWP",
        "X:SCHOOL ST & BOYCE ST",
        "CALL:STRUCTURE FIRE",
        "TIME:22:40:10");

    doTest("T5",
        "Location: 345 SOUTHPOINTE BLVD CECI: @LOCAL 23 UFCW Xstreet: SOUTHPOINTE BLVD NB SOUTHPOINTE BLVD NB TYPE: FIRE ALARM TIME: 11:39:27 Comments:",
        "ADDR:345 SOUTHPOINTE BLVD",
        "CITY:CECIL TWP",
        "PLACE:LOCAL 23 UFCW",
        "X:SOUTHPOINTE BLVD NB & SOUTHPOINTE BLVD NB",
        "CALL:FIRE ALARM",
        "TIME:11:39:27");

    doTest("T6",
        "Xstreet: REISSING RD SR 50 TYPE: GRASS OR FIELD FIRE TIME: 15:07:34 Comments: ON REISSING NEAR SR 50",
        "ADDR:REISSING RD & SR 50",
        "MADDR:REISSING RD & PA 50",
        "CALL:GRASS OR FIELD FIRE",
        "TIME:15:07:34",
        "INFO:ON REISSING NEAR SR 50");

    doTest("T7",
        "Xstreet: REISSING RD TAYLOR DR TYPE: VEHICLE ACCIDENT WITH UNKNOWN INJURIES TIME: 05:36:10 Comments:",
        "ADDR:REISSING RD & TAYLOR DR",
        "CALL:VEHICLE ACCIDENT WITH UNKNOWN INJURIES",
        "TIME:05:36:10");

    doTest("T8",
        "Xstreet: SR 980 HIGHLAND DR TYPE: VEHICLE ACCIDENT WITH INJURIES TIME: 14:17:43 Comments: JUST PASSED HIGHLAND HEADED TOWARD CECIL",
        "ADDR:SR 980 & HIGHLAND DR",
        "MADDR:PA 980 & HIGHLAND DR",
        "CALL:VEHICLE ACCIDENT WITH INJURIES",
        "TIME:14:17:43",
        "INFO:JUST PASSED HIGHLAND HEADED TOWARD CECIL");
   
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "(911) Location: 200 TANDEM VILLAGE RD NSTR: @PCH 48 CONSULATE BLDG 2 Xstreet: LINDEN CREEK RD DEAD END TYPE: FIRE ALAR",
        "ADDR:200 TANDEM VILLAGE RD",
        "CITY:NORTH STRABANE TWP",
        "PLACE:PCH 48 CONSULATE BLDG 2",
        "X:LINDEN CREEK RD DEAD END",
        "CALL:FIRE ALAR");

    doTest("T2",
        "(911) Location: 100 MEDICAL BLVD NSTR: @CANONSBURG HOSPITAL Xstreet: BOONE AVE HILL CHURCH HOUSTON RD TYPE: FIRE ALARM",
        "ADDR:100 MEDICAL BLVD",
        "CITY:NORTH STRABANE TWP",
        "PLACE:CANONSBURG HOSPITAL",
        "X:BOONE AVE & HILL CHURCH HOUSTON RD",
        "CALL:FIRE ALARM");
  
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "Subject:911\nLocation: 213 EXPRESS WAY LONG: EST Xstreet: EXPRESS WAY EB DALLY RD TYPE: VEHICLE ACCIDENT WITH UNKNOWN INJURIES TIM",
        "ADDR:213 EXPRESS WAY",
        "CITY:LONG BRANCH",
        "PLACE:EST",
        "X:EXPRESS WAY & EB DALLY RD",
        "CALL:VEHICLE ACCIDENT WITH UNKNOWN INJURIES TIM");

    doTest("T2",
        "Subject:911\nLocation: 6 RAILROAD ST ALLE Xstreet: FRANKLIN ST HAMILTON ST TYPE: MUTUAL AID REQUEST TIME: 11:34:09 Comments:",
        "ADDR:6 RAILROAD ST",
        "CITY:ALLENPORT",
        "X:FRANKLIN ST & HAMILTON ST",
        "CALL:MUTUAL AID REQUEST",
        "TIME:11:34:09");

    doTest("T3",
        "Subject:911\nLocation: 213 EXPRESS WAY LONG: EST Xstreet: EXPRESS WAY EB DALLY RD TYPE: VEHICLE ACCIDENT WITH UNKNOWN INJURIES TIM",
        "ADDR:213 EXPRESS WAY",
        "CITY:LONG BRANCH",
        "PLACE:EST",
        "X:EXPRESS WAY & EB DALLY RD",
        "CALL:VEHICLE ACCIDENT WITH UNKNOWN INJURIES TIM");

    doTest("T4",
        "Subject:911\nLocation: 3 HIGH RD ROSC: EST Xstreet: MOUNT TABOR RD LATTA HOLLOW RD TYPE: UNCONSCIOUS PT / IS BREATHING TIME: 03:21",
        "ADDR:3 HIGH RD",
        "CITY:ROSCOE",
        "PLACE:EST",
        "X:MOUNT TABOR RD & LATTA HOLLOW RD",
        "CALL:UNCONSCIOUS PT / IS BREATHING",
        "TIME:03:21");
  }
  
  @Test
  public void testParser4() {

    doTest("T1",
        "1 of 2\n" +
        "FRM:WashCo911 \n" +
        "SUBJ:911\n" +
        "MSG:Location: 791 LOCUST AVE EX SSTR: @PCH 44 HAWTHORNE WOODS ASSISTED LIVING Xstreet: BERRY RD VERONA DR TYPE:\n" +
        "(Con't) 2 of 2\n" +
        "UNCONSCIOUS PT / IS BREATHING TIME: 08:26:06 Comments: 1ST FLOOR HEALTH ROOM\n" +
        "(End)",

        "ADDR:791 LOCUST AVE EX",
        "MADDR:791 LOCUST AVE",
        "CITY:SOUTH STRABANE TWP",
        "PLACE:PCH 44 HAWTHORNE WOODS ASSISTED LIVING",
        "X:BERRY RD & VERONA DR",
        "CALL:UNCONSCIOUS PT / IS BREATHING",
        "TIME:08:26:06",
        "INFO:1ST FLOOR HEALTH ROOM");
  }
  
  @Test
  public void testVictorFedrick() {

    doTest("T1",
        "Subject:911\n" +
        "Location: 2 WHEELING PITTSBURGH STEEL DR ALLE: @AMROX Xstreet: MILL RD J F KENNEDY ST TYPE: FIRE TIME: 15:07:31 Comments: at the wheeling pittsburgh plant",

        "ADDR:2 WHEELING PITTSBURGH STEEL DR",
        "CITY:ALLENPORT",
        "PLACE:AMROX",
        "X:MILL RD & J F KENNEDY ST",
        "CALL:FIRE",
        "TIME:15:07:31",
        "INFO:at the wheeling pittsburgh plant");

    doTest("T2",
        "Subject:911\nLocation: 5 CENTER ST ALLE Xstreet: ANDERSON ST SR 88 TYPE: ODOR OF NATURAL GAS TIME: 21:39:50 Comments:",
        "ADDR:5 CENTER ST",
        "CITY:ALLENPORT",
        "X:ANDERSON ST & SR 88",
        "CALL:ODOR OF NATURAL GAS",
        "TIME:21:39:50");

    doTest("T3",
        "Subject:911\n" +
        "Location: 1850 MAIN ST ALLE: @FD 40 ALLENPORT Xstreet: MALLARD ST WASHINGTON ST TYPE: VEHICLE ACCIDENT NO INJURIES TIME: 16:33:09 Comments:",

        "ADDR:1850 MAIN ST",
        "CITY:ALLENPORT",
        "PLACE:FD 40 ALLENPORT",
        "X:MALLARD ST & WASHINGTON ST",
        "CALL:VEHICLE ACCIDENT NO INJURIES",
        "TIME:16:33:09");

    doTest("T4",
        "Subject:911\nLocation: 446 BOW ST STOC Xstreet: LOCUST ST WALNUT ST TYPE: STRUCTURE FIRE TIME: 08:56:53 Comments:",
        "ADDR:446 BOW ST",
        "CITY:STOCKDALE",
        "X:LOCUST ST & WALNUT ST",
        "CALL:STRUCTURE FIRE",
        "TIME:08:56:53");

    doTest("T5",
        "Subject:911\nLocation: 1859 MAIN ST ALLE Xstreet: WASHINGTON ST BRIDGE ST TYPE: STRUCTURE FIRE TIME: 15:19:45 Comments:",
        "ADDR:1859 MAIN ST",
        "CITY:ALLENPORT",
        "X:WASHINGTON ST & BRIDGE ST",
        "CALL:STRUCTURE FIRE",
        "TIME:15:19:45");

    doTest("T6",
        "Subject:911\n" +
        "Location: 214 DALLY RD LONG Xstreet: ROCK DR CREST DR TYPE: FIRE ALARM TIME: 20:32:03 Comments: WAGNER/MACK RES - 412-716-7984",

        "ADDR:214 DALLY RD",
        "CITY:LONG BRANCH",
        "X:ROCK DR & CREST DR",
        "CALL:FIRE ALARM",
        "TIME:20:32:03",
        "INFO:WAGNER/MACK RES - 412-716-7984");
  }
  
  @Test
  public void testJanisMiller() {

    doTest("T1",
        "(911) Loc: 36 LYNNCREST CIR CECI Xsts: HILLCREST DR DEAD END Type: ALMED Time: 15:36:27 Loc Com: KOSANOVICH RES//7247462905",
        "ADDR:36 LYNNCREST CIR",
        "CITY:CECIL TWP",
        "X:HILLCREST DR DEAD END",
        "CALL:ALMED",
        "TIME:15:36:27",
        "INFO:KOSANOVICH RES//7247462905");

  }
  
  @Test
  public void testMark181() {

    doTest("T1",
        "(911) Loc: 75 BEATTY LN NBET Xsts: GARRETT RD FARM LN Type: FIRST Time: 23:13:21 Loc Com:",
        "ADDR:75 BEATTY LN",
        "CITY:NORTH BETHLEHEM TWP",
        "X:GARRETT RD & FARM LN",
        "CALL:STRUCTURE FIRE",
        "TIME:23:13:21");
    
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "[] (911) Loc: 323 MUSE BISHOP RD CECI: EST Xsts: CIAFFONI RD BURNSIDE RD Type: RDCLS Time: 22:14:11 Loc Com:\n",
        "ADDR:323 MUSE BISHOP RD",
        "CITY:CECIL TWP",
        "PLACE:EST",
        "X:CIAFFONI RD & BURNSIDE RD",
        "CALL:ROAD CLOSURE",
        "TIME:22:14:11");

    doTest("T2",
        "[] (911) Xsts: WEAVERTOWN LN MILLERS RUN RD Type: ACCIN Time: 12:17:20 Loc Com:\n",
        "ADDR:WEAVERTOWN LN & MILLERS RUN RD",  // Not mapping
        "CALL:ACCIDENT W/INJURIES",
        "TIME:12:17:20");

    doTest("T3",
        "[] (911) Loc: 52 CARLISLE ST CECI Xsts: 2ND ST 3RD ST Type: MUTAF Time: 15:49:08 Loc Com:\n",
        "ADDR:52 CARLISLE ST",
        "CITY:CECIL TWP",
        "X:2ND ST & 3RD ST",
        "CALL:MUTUAL AID REQUEST",
        "TIME:15:49:08");

    doTest("T4",
        "[] (911) Location: 307 ROSEWOOD DR CECI Xstreet: RIDGEWOOD DR RIDGEWOOD DR TYPE: FIRE ALARM TIME: 14:59:51 Comments: SHAWN KELLY\n",
        "ADDR:307 ROSEWOOD DR",
        "CITY:CECIL TWP",
        "X:RIDGEWOOD DR & RIDGEWOOD DR",
        "CALL:FIRE ALARM",
        "TIME:14:59:51",
        "INFO:SHAWN KELLY");

    doTest("T5",
        "[] (911) Loc: 27 HIGHLAND DR CECI Xsts: SR 980 PROFIO RD Type: FIRAL Time: 13:58:32 Loc Com: MARKOVIC RES 724-9262427\n",
        "ADDR:27 HIGHLAND DR",
        "CITY:CECIL TWP",
        "X:SR 980 & PROFIO RD",
        "CALL:FIRE ALARM",
        "TIME:13:58:32",
        "INFO:MARKOVIC RES 724-9262427");

    doTest("T6",
        "[] (911) Xstreet: MORGANZA RD DEAD END TYPE: STRUCTURE FIRE TIME: 22:27:03 Comments:\n",
        "ADDR:MORGANZA RD DEAD END", // Not mapping
        "CALL:STRUCTURE FIRE",
        "TIME:22:27:03");

    doTest("T7",
        "[] (911) Location: 232 RAILROAD ST CECI Xstreet: JOHNSTON ST DEAD END TYPE: UNCONSCIOUS PT / IS BREATHING TIME: 22:36:33 Comments:\n",
        "ADDR:232 RAILROAD ST",
        "CITY:CECIL TWP",
        "X:JOHNSTON ST DEAD END",
        "CALL:UNCONSCIOUS PT / IS BREATHING",
        "TIME:22:36:33");

    doTest("T8",
        "[] (911) Location: 3351 MILLERS RUN RD CECI: @FD 10 CECIL Xstreet: NUGENT ST COLEMAN RD TYPE: MUTUAL AID REQUEST TIME: 16:25:10 Comments:\n",
        "ADDR:3351 MILLERS RUN RD",
        "CITY:CECIL TWP",
        "PLACE:FD 10 CECIL",
        "X:NUGENT ST & COLEMAN RD",
        "CALL:MUTUAL AID REQUEST",
        "TIME:16:25:10");

    doTest("T9",
        "[] (911) Location: 3351 MILLERS RUN RD CECI: @FD 10 CECIL Xstreet: NUGENT ST COLEMAN RD TYPE: MUTUAL AID REQUEST TIME: 16:25:10 Comments:\n",
        "ADDR:3351 MILLERS RUN RD",
        "CITY:CECIL TWP",
        "PLACE:FD 10 CECIL",
        "X:NUGENT ST & COLEMAN RD",
        "CALL:MUTUAL AID REQUEST",
        "TIME:16:25:10");

    doTest("T10",
        "[] (911) Location: 1000 CORPORATE DR CECI: @HILTON GARDEN INN Xstreet: KLINGER RD DEAD END TYPE: FIRE ALARM TIME: 06:57:37 Comments:\n",
        "ADDR:1000 CORPORATE DR",
        "CITY:CECIL TWP",
        "PLACE:HILTON GARDEN INN",
        "X:KLINGER RD DEAD END",
        "CALL:FIRE ALARM",
        "TIME:06:57:37");

    doTest("T11",
        "[] (911) Location: 1029 MAYFAIR DR CECI Xstreet: GREENFIELD DR FIELDSTONE DR TYPE: FIRE ALARM TIME: 09:01:11 Comments:\n",
        "ADDR:1029 MAYFAIR DR",
        "CITY:CECIL TWP",
        "X:GREENFIELD DR & FIELDSTONE DR",
        "CALL:FIRE ALARM",
        "TIME:09:01:11");

    doTest("T12",
        "[] (911) Location: 11 HICKORY GRADE RD CECI Xstreet: CECIL HENDERSON RD ANDREIS LN TYPE: ODOR OF NATURAL GAS TIME: 13:11:16 Comments:\n",
        "ADDR:11 HICKORY GRADE RD",
        "CITY:CECIL TWP",
        "X:CECIL HENDERSON RD & ANDREIS LN",
        "CALL:ODOR OF NATURAL GAS",
        "TIME:13:11:16");

    doTest("T13",
        "[] (911) Loc: 323 MUSE BISHOP RD CECI: EST Xsts: CIAFFONI RD BURNSIDE RD Type: RDCLS Time: 22:14:11 Loc Com:\n",
        "ADDR:323 MUSE BISHOP RD",
        "CITY:CECIL TWP",
        "PLACE:EST",
        "X:CIAFFONI RD & BURNSIDE RD",
        "CALL:ROAD CLOSURE",
        "TIME:22:14:11");

    doTest("T14",
        "[] (911) Loc: 545 MUSE BISHOP RD CECI Xsts: CUMER RD MCCONNELL RD Type: ACCUN Time: 20:41:52 Loc Com:\n",
        "ADDR:545 MUSE BISHOP RD",
        "CITY:CECIL TWP",
        "X:CUMER RD & MCCONNELL RD",
        "CALL:ACCIDENT W/UNK INJURIES",
        "TIME:20:41:52");

    doTest("T15",
        "[] (911) Location: 307 ROSEWOOD DR CECI Xstreet: RIDGEWOOD DR RIDGEWOOD DR TYPE: FIRE ALARM TIME: 14:59:51 Comments: SHAWN KELLY\n",
        "ADDR:307 ROSEWOOD DR",
        "CITY:CECIL TWP",
        "X:RIDGEWOOD DR & RIDGEWOOD DR",
        "CALL:FIRE ALARM",
        "TIME:14:59:51",
        "INFO:SHAWN KELLY");

    doTest("T16",
        "[] (911) Loc: 27 HIGHLAND DR CECI Xsts: SR 980 PROFIO RD Type: FIRAL Time: 13:58:32 Loc Com: MARKOVIC RES 724-9262427\n",
        "ADDR:27 HIGHLAND DR",
        "CITY:CECIL TWP",
        "X:SR 980 & PROFIO RD",
        "CALL:FIRE ALARM",
        "TIME:13:58:32",
        "INFO:MARKOVIC RES 724-9262427");

    doTest("T17",
        "[] (911) Xsts: WEAVERTOWN LN MILLERS RUN RD Type: ACCIN Time: 12:17:20 Loc Com:\n",
        "ADDR:WEAVERTOWN LN & MILLERS RUN RD",  // Google can't find
        "CALL:ACCIDENT W/INJURIES",
        "TIME:12:17:20");

    doTest("T18",
        "[] (911) Xsts: CUMER RD BERNARDI LN Type: FIRE Time: 11:45:58 Loc Com: ON CUMER...1/2MI FROM MUSE BISHOP\n",
        "ADDR:CUMER RD & BERNARDI LN",
        "CALL:FIRE",
        "TIME:11:45:58",
        "INFO:ON CUMER...1/2MI FROM MUSE BISHOP");

    doTest("T19",
        "[] (911) Loc: 1000 CORPORATE DR CECI: @HILTON GARDEN INN Xsts: KLINGER RD DEAD END Type: FIRAL Time: 17:58:17 Loc Com:\n",
        "ADDR:1000 CORPORATE DR",
        "CITY:CECIL TWP",
        "PLACE:HILTON GARDEN INN",
        "X:KLINGER RD DEAD END",
        "CALL:FIRE ALARM",
        "TIME:17:58:17");

    doTest("T20",
        "[] (911) Loc: 27 HIGHLAND DR CECI Xsts: SR 980 PROFIO RD Type: FIRAL Time: 13:58:32 Loc Com: MARKOVIC RES 724-9262427\n",
        "ADDR:27 HIGHLAND DR",
        "CITY:CECIL TWP",
        "X:SR 980 & PROFIO RD",
        "CALL:FIRE ALARM",
        "TIME:13:58:32",
        "INFO:MARKOVIC RES 724-9262427");

    doTest("T21",
        "[] (911) Loc: 1000 CORPORATE DR CECI: @HILTON GARDEN INN Xsts: KLINGER RD DEAD END Type: FIRAL Time: 17:58:17 Loc Com:\n",
        "ADDR:1000 CORPORATE DR",
        "CITY:CECIL TWP",
        "PLACE:HILTON GARDEN INN",
        "X:KLINGER RD DEAD END",
        "CALL:FIRE ALARM",
        "TIME:17:58:17");

    doTest("T22",
        "[911] Xsts: SLATEMORE DR MILLERS RUN RD Type: ACCIN Time: 17:48:51 Loc Com:\n",
        "ADDR:SLATEMORE DR & MILLERS RUN RD", // Google can't find - reported
        "CALL:ACCIDENT W/INJURIES",
        "TIME:17:48:51");

  }
  
  public static void main(String[] args) {
    new PAWashingtonCountyParserTest().generateTests("T7");
  }
}
