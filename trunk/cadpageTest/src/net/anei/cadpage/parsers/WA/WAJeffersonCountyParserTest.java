package net.anei.cadpage.parsers.WA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
East Jefferson County, WA
Contact: Ryan Mc Allister <rtmcallister@yahoo.com>
Sender: messaging@iamresponding.com
System: New World
 
(JCFD5) BLS  :  A51   :   :  BK=(36  :   :  DEAD END / CASSERLARY ROAD EXT, MISTY RIDGE RD  :  09/06/12 20:27  :  Narrative :   72YOM  PNEMONIA  DIFF BR
(JCFD5) BLS  :  E52   :   :  2911 SHERMAN ST  :  Port Townsend  :  29TH ST / 30TH ST  :  09/06/12 18:37  :  Narrative :   LEG IS STUCK  PT IS STUCK IN H
(JCFD5) Fire - Dumpster  :  E16 A16 DC11   :   :  CASS ST  :  Port Townsend  :   :  09/06/12 02:22  :  Narrative :   IN THE MIDDLE OF THE STREET  COUCH 
(JCFD5) Fire - Alarm Commercial  :  E31   :  San Juan Villa :  112 CASTELLANO WAY  :  Port Townsend  :  CAROLINE ST / SAN JUAN AVE  :  09/05/12 07:31  :
(JCFD5) Fire - Alarm Commercial  :  E11 E31 DC112   :   :  3801 HASTINGS AVE W  :  Port Townsend  :  No Cross Streets Found  :  09/05/12 07:31  :  Narra
(JCFD5) BLS  :  A51   :   :  31 N CHANDLER CT A  :  Port Ludlow  :  SPINNAKER PL, S CHANDLER CT / DEAD END  :  09/04/12 16:55  :  Narrative :   SUDDEN O
(JCFD5) HazCon  :  E51 DC51   :   :  240 MOA HILL RD  :  Port Townsend  :  DEAD END / HWY 20  :  09/04/12 12:46  :  Narrative :   WAS FIRE, BUT UNK IF S
(JCFD5) Fire - Brush  :  B21   :   :  330 GLEN LOGIE RD  :  Quilcene  :  DEAD END / HWY 101  :  09/03/12 19:06  :  Narrative :   DC21, NEED DNR TO RESPO
(JCFD5) Fire - Illegal Burn  :  E15 M15 DC11   :   :  CREST AVE  :  Port Townsend  :   :  08/31/12 10:21  :  Narrative :   E911 Info - Class of Service:
(JCFD5) BLS  :  A51   :   :  161 WINDROSE DR  :  Port Ludlow  :  DEAD END / MARTINGALE PL  :  08/27/12 09:18  :  Narrative :   LIFT ASSIST  GROUND LEVEL

*/


public class WAJeffersonCountyParserTest extends BaseParserTest {
  
  public WAJeffersonCountyParserTest() {
    setParser(new WAJeffersonCountyParser(), "JEFFERSON COUNTY", "WA");
  }
  
  @Test
  public void testRyanMcAllister() {

    doTest("T1",
        "(JCFD5) BLS  :  A51   :   :  BK=(36  :   :  DEAD END / CASSERLARY ROAD EXT, MISTY RIDGE RD  :  09/06/12 20:27  :  Narrative :   72YOM  PNEMONIA  DIFF BR",
        "SRC:JCFD5",
        "CALL:BLS",
        "UNIT:A51",
        "ADDR:BK=(36",
        "MADDR:BK=(36 & DEAD END",
        "X:DEAD END / CASSERLARY ROAD EXT, MISTY RIDGE RD",
        "DATE:09/06/12",
        "TIME:20:27",
        "INFO:72YOM  PNEMONIA  DIFF BR");

    doTest("T2",
        "(JCFD5) BLS  :  E52   :   :  2911 SHERMAN ST  :  Port Townsend  :  29TH ST / 30TH ST  :  09/06/12 18:37  :  Narrative :   LEG IS STUCK  PT IS STUCK IN H",
        "SRC:JCFD5",
        "CALL:BLS",
        "UNIT:E52",
        "ADDR:2911 SHERMAN ST",
        "CITY:Port Townsend",
        "X:29TH ST / 30TH ST",
        "DATE:09/06/12",
        "TIME:18:37",
        "INFO:LEG IS STUCK  PT IS STUCK IN H");

    doTest("T3",
        "(JCFD5) Fire - Dumpster  :  E16 A16 DC11   :   :  CASS ST  :  Port Townsend  :   :  09/06/12 02:22  :  Narrative :   IN THE MIDDLE OF THE STREET  COUCH ",
        "SRC:JCFD5",
        "CALL:Fire - Dumpster",
        "UNIT:E16 A16 DC11",
        "ADDR:CASS ST",
        "CITY:Port Townsend",
        "DATE:09/06/12",
        "TIME:02:22",
        "INFO:IN THE MIDDLE OF THE STREET  COUCH");

    doTest("T4",
        "(JCFD5) Fire - Alarm Commercial  :  E31   :  San Juan Villa :  112 CASTELLANO WAY  :  Port Townsend  :  CAROLINE ST / SAN JUAN AVE  :  09/05/12 07:31  :",
        "SRC:JCFD5",
        "CALL:Fire - Alarm Commercial",
        "UNIT:E31",
        "PLACE:San Juan Villa",
        "ADDR:112 CASTELLANO WAY",
        "CITY:Port Townsend",
        "X:CAROLINE ST / SAN JUAN AVE",
        "DATE:09/05/12",
        "TIME:07:31  :");

    doTest("T5",
        "(JCFD5) Fire - Alarm Commercial  :  E11 E31 DC112   :   :  3801 HASTINGS AVE W  :  Port Townsend  :  No Cross Streets Found  :  09/05/12 07:31  :  Narra",
        "SRC:JCFD5",
        "CALL:Fire - Alarm Commercial",
        "UNIT:E11 E31 DC112",
        "ADDR:3801 HASTINGS AVE W",
        "CITY:Port Townsend",
        "X:No Cross Streets Found",
        "DATE:09/05/12",
        "TIME:07:31");

    doTest("T6",
        "(JCFD5) BLS  :  A51   :   :  31 N CHANDLER CT A  :  Port Ludlow  :  SPINNAKER PL, S CHANDLER CT / DEAD END  :  09/04/12 16:55  :  Narrative :   SUDDEN O",
        "SRC:JCFD5",
        "CALL:BLS",
        "UNIT:A51",
        "ADDR:31 N CHANDLER CT A",
        "CITY:Port Ludlow",
        "X:SPINNAKER PL, S CHANDLER CT / DEAD END",
        "DATE:09/04/12",
        "TIME:16:55",
        "INFO:SUDDEN O");

    doTest("T7",
        "(JCFD5) HazCon  :  E51 DC51   :   :  240 MOA HILL RD  :  Port Townsend  :  DEAD END / HWY 20  :  09/04/12 12:46  :  Narrative :   WAS FIRE, BUT UNK IF S",
        "SRC:JCFD5",
        "CALL:HazCon",
        "UNIT:E51 DC51",
        "ADDR:240 MOA HILL RD",
        "CITY:Port Townsend",
        "X:DEAD END / HWY 20",
        "DATE:09/04/12",
        "TIME:12:46",
        "INFO:WAS FIRE, BUT UNK IF S");

    doTest("T8",
        "(JCFD5) Fire - Brush  :  B21   :   :  330 GLEN LOGIE RD  :  Quilcene  :  DEAD END / HWY 101  :  09/03/12 19:06  :  Narrative :   DC21, NEED DNR TO RESPO",
        "SRC:JCFD5",
        "CALL:Fire - Brush",
        "UNIT:B21",
        "ADDR:330 GLEN LOGIE RD",
        "CITY:Quilcene",
        "X:DEAD END / HWY 101",
        "DATE:09/03/12",
        "TIME:19:06",
        "INFO:DC21, NEED DNR TO RESPO");

    doTest("T9",
        "(JCFD5) Fire - Illegal Burn  :  E15 M15 DC11   :   :  CREST AVE  :  Port Townsend  :   :  08/31/12 10:21  :  Narrative :   E911 Info - Class of Service:",
        "SRC:JCFD5",
        "CALL:Fire - Illegal Burn",
        "UNIT:E15 M15 DC11",
        "ADDR:CREST AVE",
        "CITY:Port Townsend",
        "DATE:08/31/12",
        "TIME:10:21",
        "INFO:E911 Info - Class of Service:");

    doTest("T10",
        "(JCFD5) BLS  :  A51   :   :  161 WINDROSE DR  :  Port Ludlow  :  DEAD END / MARTINGALE PL  :  08/27/12 09:18  :  Narrative :   LIFT ASSIST  GROUND LEVEL",
        "SRC:JCFD5",
        "CALL:BLS",
        "UNIT:A51",
        "ADDR:161 WINDROSE DR",
        "CITY:Port Ludlow",
        "X:DEAD END / MARTINGALE PL",
        "DATE:08/27/12",
        "TIME:09:18",
        "INFO:LIFT ASSIST  GROUND LEVEL");
  }
  
  public static void main(String[] args) {
    new WAJeffersonCountyParserTest().generateTests("T1");
  }
}