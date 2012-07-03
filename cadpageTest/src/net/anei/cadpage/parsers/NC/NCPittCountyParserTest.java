package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCPittCountyParserTest extends BaseParserTest {
  
  public NCPittCountyParserTest() {
    setParser(new NCPittCountyParser(), "PITT COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "S:911 Fire Call M:F24|Rcvd:05/31/2012 03:34|Rsn:FIRE ALARM ACT|Note:SAME|Adr:1550  QUALITY LN",
        "SRC:F24",
        "DATE:05/31/2012",
        "TIME:03:34",
        "CALL:FIRE ALARM ACT",
        "ADDR:1550  QUALITY LN");  // Google can't find

    doTest("T2",
        "S:911 Fire Call M: F14 | Rcvd:05/27/2012 01:16 | Rsn: MVC PI | Note:MARTIN LUTHER KING JR DR | WHICHARD RD | Adr:0 ",
        "SRC:F14",
        "DATE:05/27/2012",
        "TIME:01:16",
        "CALL:MVC PI",
        "ADDR:MARTIN LUTHER KING JR DR",
        "MADDR:MARTIN LUTHER KING JR DR & WHICHARD RD", // Google can't find
        "X:WHICHARD RD");

    doTest("T3",
        "S:911 Fire Call M: F14 | Rcvd:05/25/2012 17:12 | Rsn:47 YOM STROKE | Note:618 DANIELLE DR | Adr:0",
        "SRC:F14",
        "DATE:05/25/2012",
        "TIME:17:12",
        "CALL:47 YOM STROKE",
        "ADDR:618 DANIELLE DR");

    doTest("T4",
        "S:911 Fire Call M: F14 | Rcvd:05/25/2012 01:41 | Rsn: POSS ELECTRICAL FIRE |Note:3157 OLD RIVER RD | Adr:0",
        "SRC:F14",
        "DATE:05/25/2012",
        "TIME:01:41",
        "CALL:POSS ELECTRICAL FIRE",
        "ADDR:3157 OLD RIVER RD");

    doTest("T5",
        "S:911 Fire Call M: F14 | Rcvd:05/23/2012 19:55 | Rsn: MVC PI | Note:OLDR RIVER RD | BROWN PLACE DR @ THE BRIDGE | Adr:0",
        "SRC:F14",
        "DATE:05/23/2012",
        "TIME:19:55",
        "CALL:MVC PI",
        "ADDR:OLDR RIVER RD", // OLD RIVER RD & BLACK PLACE DR
        "MADDR:OLDR RIVER RD & BROWN PLACE DR",
        "X:BROWN PLACE DR",
        "PLACE:THE BRIDGE");

    doTest("T6",
        "S:911 Fire Call M: F24 | Rcvd:05/22/2012 17:16 | Rsn: FIRE ALARM | Note:SAME | Adr:2185 OAKLEY RD",
        "SRC:F24",
        "DATE:05/22/2012",
        "TIME:17:16",
        "CALL:FIRE ALARM",
        "ADDR:2185 OAKLEY RD");
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "(911 Fire Call) F01|Rcvd:06/30/2012 09:02|Rsn:FIRE ALARM|Note:SLAY HALL|Adr:701 E 5TH ST\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:06/30/2012",
        "TIME:09:02",
        "CALL:FIRE ALARM",
        "INFO:SLAY HALL",
        "ADDR:701 E 5TH ST");

    doTest("T2",
        "(911 Fire Call) F01|Rcvd:06/30/2012 15:42|Rsn:FIRE ALARM|Note:SAME|Adr:408  RAINTREE DR\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:06/30/2012",
        "TIME:15:42",
        "CALL:FIRE ALARM",
        "ADDR:408  RAINTREE DR");

    doTest("T3",
        "(911 Fire Call) F01|Rcvd:06/30/2012 15:51|Rsn:FIRE ALARM|Note:SAME|Adr:2459  EMERALD PL\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:06/30/2012",
        "TIME:15:51",
        "CALL:FIRE ALARM",
        "ADDR:2459  EMERALD PL");

    doTest("T4",
        "(911 Fire Call) F01|Rcvd:06/30/2012 21:06|Rsn:FIRE ALARM ACTIVATION|Note:FICKLIN STADIUM|Adr:701 E 5TH ST\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:06/30/2012",
        "TIME:21:06",
        "CALL:FIRE ALARM ACTIVATION",
        "INFO:FICKLIN STADIUM",
        "ADDR:701 E 5TH ST");

    doTest("T5",
        "(911 Fire Call) F01|Rcvd:06/30/2012 22:21|Rsn:FIRE ALARM ACTIVATION|Note:517 MOYE BLVD | MOYE MEDICAL 2|Adr:701 E 5TH ST\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:06/30/2012",
        "TIME:22:21",
        "CALL:FIRE ALARM ACTIVATION",
        "INFO:517 MOYE BLVD",
        "PLACE:MOYE MEDICAL 2",
        "ADDR:701 E 5TH ST");

    doTest("T6",
        "(911 Fire Call) F01|Rcvd:07/01/2012 02:42|Rsn:MALE CHEST PAIN|Note:HOWELL AND PITT|Adr:0  -\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/01/2012",
        "TIME:02:42",
        "CALL:MALE CHEST PAIN",
        "ADDR:HOWELL AND PITT");

    doTest("T7",
        "(911 Fire Call) F01|Rcvd:07/01/2012 05:36|Rsn:FIRE ALARM ACTIVATION|Note:|Adr:1055  WATERFORD COMMONS DR\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/01/2012",
        "TIME:05:36",
        "CALL:FIRE ALARM ACTIVATION",
        "ADDR:1055  WATERFORD COMMONS DR");

    doTest("T8",
        "(911 Fire Call) F01|Rcvd:07/01/2012 06:50|Rsn:FIRE ALARM|Note:800-230-6975/OPERATOR TARA|Adr:1055  WATERFORD COMMONS DR\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/01/2012",
        "TIME:06:50",
        "CALL:FIRE ALARM",
        "INFO:800-230-6975/OPERATOR TARA",
        "ADDR:1055  WATERFORD COMMONS DR");

    doTest("T9",
        "(911 Fire Call) F01|Rcvd:07/01/2012 07:21|Rsn:FIRE ALARM|Note:SAME|Adr:2095  STANTONSBURG RD\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/01/2012",
        "TIME:07:21",
        "CALL:FIRE ALARM",
        "ADDR:2095  STANTONSBURG RD");

    doTest("T10",
        "(911 Fire Call) F01|Rcvd:07/01/2012 16:09|Rsn:FENCE FIRE|Note:N HARDING ST BEHIND 109 N LIBRARY|Adr:0  -\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/01/2012",
        "TIME:16:09",
        "CALL:FENCE FIRE",
        "INFO:BEHIND 109 N LIBRARY",
        "ADDR:N HARDING ST");

    doTest("T11",
        "(911 Fire Call) F01|Rcvd:07/01/2012 16:20|Rsn:FIRE ALARM|Note:CLEMMENT HALL|Adr:701 E 5TH ST\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/01/2012",
        "TIME:16:20",
        "CALL:FIRE ALARM",
        "INFO:CLEMMENT HALL",
        "ADDR:701 E 5TH ST");

    doTest("T12",
        "(911 Fire Call) F01|Rcvd:07/01/2012 19:21|Rsn:FEMALE BREATHING PROBLEM|Note:|Adr:1805  KENNEDY CIR  A\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/01/2012",
        "TIME:19:21",
        "CALL:FEMALE BREATHING PROBLEM",
        "ADDR:1805  KENNEDY CIR  A");

    doTest("T13",
        "(911 Fire Call) F01|Rcvd:07/01/2012 20:38|Rsn:TREE FALLEN ON HOUSE|Note:1605 MURFIELD DR|Adr:121  WILKSHIRE DR\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/01/2012",
        "TIME:20:38",
        "CALL:TREE FALLEN ON HOUSE",
        "INFO:1605 MURFIELD DR",
        "ADDR:121  WILKSHIRE DR");

    doTest("T14",
        "(911 Fire Call) F01|Rcvd:07/01/2012 20:49|Rsn:TREE FALLEN ON HOUSE|Note:1605 MURFIELD DR|Adr:121  WILKSHIRE DR\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/01/2012",
        "TIME:20:49",
        "CALL:TREE FALLEN ON HOUSE",
        "INFO:1605 MURFIELD DR",
        "ADDR:121  WILKSHIRE DR");

    doTest("T15",
        "(911 Fire Call) F01|Rcvd:07/01/2012 20:50|Rsn:FEMALE STROKE|Note:902 BANCROFT AV|Adr:0  -\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/01/2012",
        "TIME:20:50",
        "CALL:FEMALE STROKE",
        "ADDR:902 BANCROFT AV",
        "MADDR:902 BANCROFT AVE");

    doTest("T16",
        "(911 Fire Call) F01|Rcvd:07/01/2012 21:01|Rsn:TREE FALLEN ON HOUSE|Note:1605 MURFIELD DR|Adr:121  WILKSHIRE DR\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/01/2012",
        "TIME:21:01",
        "CALL:TREE FALLEN ON HOUSE",
        "INFO:1605 MURFIELD DR",
        "ADDR:121  WILKSHIRE DR");

    doTest("T17",
        "(911 Fire Call) F01|Rcvd:07/02/2012 07:34|Rsn:MVC PI|Note:LINE AV | FARMVILLE BL|Adr:100 W 3RD ST\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/02/2012",
        "TIME:07:34",
        "CALL:MVC PI",
        "INFO:LINE AV",
        "X:FARMVILLE BL",
        "ADDR:100 W 3RD ST");

    doTest("T18",
        "(911 Fire Call) F01|Rcvd:07/02/2012 11:25|Rsn:FEMALE SEIZURES|Note:SAME|Adr:2114  MYRTLE AVE\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/02/2012",
        "TIME:11:25",
        "CALL:FEMALE SEIZURES",
        "ADDR:2114  MYRTLE AVE");

    doTest("T19",
        "(911 Fire Call) F01|Rcvd:07/02/2012 11:49|Rsn:MVC PI|Note:E 5TH ST | S HARDING ST|Adr:500 S GREENE ST\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/02/2012",
        "TIME:11:49",
        "CALL:MVC PI",
        "INFO:E 5TH ST",
        "X:S HARDING ST",
        "ADDR:500 S GREENE ST");

    doTest("T20",
        "(911 Fire Call) F01|Rcvd:07/02/2012 12:29|Rsn:FIRE ALARM ACTIVATION|Note:SAME|Adr:214 E FIRE TOWER RD\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/02/2012",
        "TIME:12:29",
        "CALL:FIRE ALARM ACTIVATION",
        "ADDR:214 E FIRE TOWER RD");

    doTest("T21",
        "(911 Fire Call) F01|Rcvd:07/02/2012 21:25|Rsn:FIRE ALARM|Note:108 CHANDLER DR G|Adr:1717 W 5TH ST\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/02/2012",
        "TIME:21:25",
        "CALL:FIRE ALARM",
        "INFO:108 CHANDLER DR G",
        "ADDR:1717 W 5TH ST");

    doTest("T22",
        "(911 Fire Call) F01|Rcvd:07/03/2012 09:24|Rsn:FIRE ALARM ACTIVATION|Note:GENERAL // NO KEYHOLDER LIST|Adr:2313 S MEMORIAL DR\n\n" +
        "________________________________\n\n" +
        "This e-mail is for the intended recipient only.\n" +
        "If you have received it by mistake please let us know by reply and then delete it from your system; access, disclosure, copying, distribution or reliance on any of it by anyone else is prohibited.\n" +
        "If you as intended recipient have received this e-mail incorrectly, please notify the sender (via e-mail) immediately.",

        "SRC:F01",
        "DATE:07/03/2012",
        "TIME:09:24",
        "CALL:FIRE ALARM ACTIVATION",
        "INFO:GENERAL // NO KEYHOLDER LIST",
        "ADDR:2313 S MEMORIAL DR");

  }

  public static void main(String[] args) {
    new NCPittCountyParserTest().generateTests("T1");
  }
}
