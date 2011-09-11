package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAChesterCountyD1ParserTest extends BaseParserTest {
  
  public PAChesterCountyD1ParserTest() {
    setParser(new PAChesterCountyD1Parser(), "CHESTER COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(340 RIDGE RD ,21 -- EAST) 14:04 ** ALARM - FIRE * ** 340 RIDGE RD ,21 -- EAST VINCENT ELEM SC ** 6253 ** AFA/GENERAL/ATN\n**  **",
        "CALL:ALARM - FIRE",
        "ADDR:340 RIDGE RD",
        "CITY:EAST VINCENT TWP",
        "PLACE:EAST VINCENT ELEM SC",
        "ID:6253",
        "INFO:AFA/GENERAL/ATN");

    doTest("T2",
        "(56 WADE DR ,21  btwn NOT) 11:43 ** ALARM - FIRE * ** 56 WADE DR ,21  btwn NOTTINGHAM DR & SHE ** 6203 ** AFA - GEN - ATN\n",
        "CALL:ALARM - FIRE",
        "ADDR:56 WADE DR",
        "CITY:EAST VINCENT TWP",
        "X:NOTTINGHAM DR & SHE",
        "ID:6203",
        "INFO:AFA - GEN - ATN");

    doTest("T3",
        "(WB BETHEL CHURCH RD WO S) 08:53 ** ACCIDENT - UNKNOWN INJURIES * **  WB BETHEL CHURCH RD WO STONEY RUN RD ,18 ** 6201 ** 1 VEH, BLOCKING, AIR BAG DEPLOYM",
        "CALL:ACCIDENT - UNKNOWN INJURIES",
        "ADDR:WB BETHEL CHURCH RD & STONEY RUN RD",
        "CITY:EAST COVENTRY TWP",
        "ID:6201",
        "INFO:1 VEH, BLOCKING, AIR BAG DEPLOYM");

    doTest("T4",
        "(1059 SANATOGA RD ,18  bt) 08:49 ** HOUSE FIRE * ** 1059 SANATOGA RD ,18  btwn MEADOW LA & E ** 6201 ** ELECTRIC FIRE IN WALL - FLAMES AND SMOKE\nDETAILS",
        "CALL:HOUSE FIRE",
        "ADDR:1059 SANATOGA RD",
        "CITY:EAST COVENTRY TWP",
        "X:MEADOW LA & E",
        "ID:6201",
        "INFO:ELECTRIC FIRE IN WALL - FLAMES AND SMOKE DETAILS");

    doTest("T5",
        "(SB FULMER RD SO EBELHARE) 21:26 ** ACCIDENT - MOTORCYCLE * ** SB FULMER RD SO EBELHARE RD ,18   (V) ** 6201 ** MC VS TREE ---\nDETAILS TO FOLLOW\n**  **",
        "CALL:ACCIDENT - MOTORCYCLE",
        "ADDR:SB FULMER RD & EBELHARE RD",
        "CITY:EAST COVENTRY TWP",
        "ID:6201",
        "INFO:MC VS TREE --- DETAILS TO FOLLOW");

    doTest("T6",
        "(1701 POTTSTOWN PK ,20 --) 14:39 ** ACCIDENT - MOTORCYCLE * ** 1701  POTTSTOWN PK ,20 -- MAIN EVENT SPOR ** 6205 ** TWO DOWN IN THE ROADWAY\n**  **",
        "CALL:ACCIDENT - MOTORCYCLE",
        "ADDR:1701  POTTSTOWN PIKE",
        "CITY:POTTSTOWN",
        "PLACE:MAIN EVENT SPOR",
        "ID:6205",
        "INFO:TWO DOWN IN THE ROADWAY");

  }
  
  public static void main(String[] args) {
    new PAChesterCountyD1ParserTest().generateTests("T1");
  }
}
