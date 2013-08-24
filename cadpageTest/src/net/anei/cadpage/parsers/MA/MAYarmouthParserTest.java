package net.anei.cadpage.parsers.MA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*    
Yarmouth, MA
Contact: Charles Talbott <medic2@comcast.net>

 109 NOTTINGHAM DR\nNO NAME\nYARMOUTH\nMedical Priority 2/3\n2_East_1\n\nNotes\nPOSSIBLE UNATTENDED
 579 BUCK ISLAND RD\nMAYFLOWER PLACE\nYARMOUTH\nMedical Priority 2/3\n3_South_1\n\nNotes\nBREWSTER UNIT EYE SWELLING
 43 MEDINAH DR\n2_West_3\n\nNotes\nDEHYDRATION SHORTNESS OF BREATH
 55 COTTONWOOD ST\nBACK PAIN
 19 FLICKER LN\n1_East_2\n\nNotes\n87 Y/O MALE DIFF BREATHING
 33 LEWIS RD\n3_South_1\n\nNotes\nUNRESPONSIVE FEMALE
 121 CAMP ST\nMILL POND VILLAGE\nYARMOUTH\nAFA (residential)\n3_North_2
 23 TASMANIA DR\n2_East_1
 6 SQUIRREL RUN\nNO NAME\nYARMOUTH\nCO Asymptomatic\n2_West_3\n\nNotes
 0 ROUTE 6\nNO NAME\nYARMOUTH\nMVC\nMID-CAPE HIGHWAY\n\nNotes\n6 EAST BOUND JUST PAST EXIT 8\n

*/

public class MAYarmouthParserTest extends BaseParserTest {
  
  public MAYarmouthParserTest() {
    setParser(new MAYarmouthParser(), "YARMOUTH", "MA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        " 109 NOTTINGHAM DR\nNO NAME\nYARMOUTH\nMedical Priority 2/3\n2_East_1\n\nNotes\nPOSSIBLE UNATTENDED",
        "ADDR:109 NOTTINGHAM DR",
        "PRI:2",
        "MAP:2_East_1",
        "CALL:POSSIBLE UNATTENDED");

    doTest("T2",
        " 579 BUCK ISLAND RD\nMAYFLOWER PLACE\nYARMOUTH\nMedical Priority 2/3\n3_South_1\n\nNotes\nBREWSTER UNIT EYE SWELLING",
        "ADDR:579 BUCK ISLAND RD",
        "PLACE:MAYFLOWER PLACE",
        "PRI:2",
        "MAP:3_South_1",
        "CALL:BREWSTER UNIT EYE SWELLING");

    doTest("T3",
        " 43 MEDINAH DR\n2_West_3\n\nNotes\nDEHYDRATION SHORTNESS OF BREATH",
        "ADDR:43 MEDINAH DR",
        "MAP:2_West_3",
        "CALL:DEHYDRATION SHORTNESS OF BREATH");

    doTest("T4",
        " 55 COTTONWOOD ST\nBACK PAIN",
        "ADDR:55 COTTONWOOD ST",
        "CALL:BACK PAIN");

    doTest("T5",
        " 19 FLICKER LN\n1_East_2\n\nNotes\n87 Y/O MALE DIFF BREATHING",
        "ADDR:19 FLICKER LN",
        "MAP:1_East_2",
        "CALL:87 Y/O MALE DIFF BREATHING");

    doTest("T6",
        " 33 LEWIS RD\n3_South_1\n\nNotes\nUNRESPONSIVE FEMALE",
        "ADDR:33 LEWIS RD",
        "MAP:3_South_1",
        "CALL:UNRESPONSIVE FEMALE");

    doTest("T7",
        " 121 CAMP ST\nMILL POND VILLAGE\nYARMOUTH\nAFA (residential)\n3_North_2",
        "ADDR:121 CAMP ST",
        "PLACE:MILL POND VILLAGE",
        "MAP:3_North_2",
        "CALL:AFA (residential)");

    doTest("T8",
        " 23 TASMANIA DR\n2_East_1",
        "ADDR:23 TASMANIA DR",
        "MAP:2_East_1");

    doTest("T9",
        " 6 SQUIRREL RUN\nNO NAME\nYARMOUTH\nCO Asymptomatic\n2_West_3\n\nNotes",
        "ADDR:6 SQUIRREL RUN",
        "MAP:2_West_3",
        "CALL:CO Asymptomatic");

    doTest("T10",
        " 0 ROUTE 6\nNO NAME\nYARMOUTH\nMVC\nMID-CAPE HIGHWAY\n\nNotes\n6 EAST BOUND JUST PAST EXIT 8\n",
        "ADDR:ROUTE 6",
        "CALL:MVC",
        "INFO:MID-CAPE HIGHWAY / 6 EAST BOUND JUST PAST EXIT 8");
    
  }
  
  public static void main(String[] args) {
    new MAYarmouthParserTest().generateTests("T1");
  }
}