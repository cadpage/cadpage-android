package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Chester County, PA (variant D1)
Contact: Ray Stegmaier <stegmaierr@gmail.com>
Sender: adi62@ridgefirecompany.com
http://wiki.radioreference.com/index.php/Chester_County_%28PA%29

(340 RIDGE RD ,21 -- EAST) 14:04 ** ALARM - FIRE * ** 340 RIDGE RD ,21 -- EAST VINCENT ELEM SC ** 6253 ** AFA/GENERAL/ATN\n**  **
(56 WADE DR ,21  btwn NOT) 11:43 ** ALARM - FIRE * ** 56 WADE DR ,21  btwn NOTTINGHAM DR & SHE ** 6203 ** AFA - GEN - ATN\n
(WB BETHEL CHURCH RD WO S) 08:53 ** ACCIDENT - UNKNOWN INJURIES * **  WB BETHEL CHURCH RD WO STONEY RUN RD ,18 ** 6201 ** 1 VEH, BLOCKING, AIR BAG DEPLOYM
(1059 SANATOGA RD ,18  bt) 08:49 ** HOUSE FIRE * ** 1059 SANATOGA RD ,18  btwn MEADOW LA & E ** 6201 ** ELECTRIC FIRE IN WALL - FLAMES AND SMOKE\nDETAILS
(SB FULMER RD SO EBELHARE) 21:26 ** ACCIDENT - MOTORCYCLE * ** SB FULMER RD SO EBELHARE RD ,18   (V) ** 6201 ** MC VS TREE ---\nDETAILS TO FOLLOW\n**  **
(1701 POTTSTOWN PK ,20 --) 14:39 ** ACCIDENT - MOTORCYCLE * ** 1701  POTTSTOWN PK ,20 -- MAIN EVENT SPOR ** 6205 ** TWO DOWN IN THE ROADWAY\n**  **

 */

public class PAChesterCountyD1ParserTest extends BaseParserTest {
  
  public PAChesterCountyD1ParserTest() {
    setParser(new PAChesterCountyD1Parser(), "CHESTER COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(340 RIDGE RD ,21 -- EAST) 14:04 ** ALARM - FIRE * ** 340 RIDGE RD ,21 -- EAST VINCENT ELEM SC ** 6253 ** AFA/GENERAL/ATN\n**  **",
        "TIME:14:04",
        "CALL:ALARM - FIRE",
        "ADDR:340 RIDGE RD",
        "CITY:EAST VINCENT TWP",
        "PLACE:EAST VINCENT ELEM SC",
        "BOX:6253",
        "INFO:AFA/GENERAL/ATN");

    doTest("T2",
        "(56 WADE DR ,21  btwn NOT) 11:43 ** ALARM - FIRE * ** 56 WADE DR ,21  btwn NOTTINGHAM DR & SHE ** 6203 ** AFA - GEN - ATN\n",
        "TIME:11:43",
        "CALL:ALARM - FIRE",
        "ADDR:56 WADE DR",
        "CITY:EAST VINCENT TWP",
        "X:NOTTINGHAM DR & SHE",
        "BOX:6203",
        "INFO:AFA - GEN - ATN");

    doTest("T3",
        "(WB BETHEL CHURCH RD WO S) 08:53 ** ACCIDENT - UNKNOWN INJURIES * **  WB BETHEL CHURCH RD WO STONEY RUN RD ,18 ** 6201 ** 1 VEH, BLOCKING, AIR BAG DEPLOYM",
        "TIME:08:53",
        "CALL:ACCIDENT - UNKNOWN INJURIES",
        "ADDR:WB BETHEL CHURCH RD & STONEY RUN RD",
        "MADDR:BETHEL CHURCH RD & STONEY RUN RD",
        "CITY:EAST COVENTRY TWP",
        "BOX:6201",
        "INFO:1 VEH, BLOCKING, AIR BAG DEPLOYM");

    doTest("T4",
        "(1059 SANATOGA RD ,18  bt) 08:49 ** HOUSE FIRE * ** 1059 SANATOGA RD ,18  btwn MEADOW LA & E ** 6201 ** ELECTRIC FIRE IN WALL - FLAMES AND SMOKE\nDETAILS",
        "TIME:08:49",
        "CALL:HOUSE FIRE",
        "ADDR:1059 SANATOGA RD",
        "CITY:EAST COVENTRY TWP",
        "X:MEADOW LA & E",
        "BOX:6201",
        "INFO:ELECTRIC FIRE IN WALL - FLAMES AND SMOKE DETAILS");

    doTest("T5",
        "(SB FULMER RD SO EBELHARE) 21:26 ** ACCIDENT - MOTORCYCLE * ** SB FULMER RD SO EBELHARE RD ,18   (V) ** 6201 ** MC VS TREE ---\nDETAILS TO FOLLOW\n**  **",
        "TIME:21:26",
        "CALL:ACCIDENT - MOTORCYCLE",
        "ADDR:SB FULMER RD & EBELHARE RD",
        "MADDR:FULMER RD & EBELHARE RD",
        "CITY:EAST COVENTRY TWP",
        "BOX:6201",
        "INFO:MC VS TREE --- DETAILS TO FOLLOW");

    doTest("T6",
        "(1701 POTTSTOWN PK ,20 --) 14:39 ** ACCIDENT - MOTORCYCLE * ** 1701  POTTSTOWN PK ,20 -- MAIN EVENT SPOR ** 6205 ** TWO DOWN IN THE ROADWAY\n**  **",
        "TIME:14:39",
        "CALL:ACCIDENT - MOTORCYCLE",
        "ADDR:1701  POTTSTOWN PIKE",
        "CITY:POTTSTOWN",
        "PLACE:MAIN EVENT SPOR",
        "BOX:6205",
        "INFO:TWO DOWN IN THE ROADWAY");
 
  }
  
  public static void main(String[] args) {
    new PAChesterCountyD1ParserTest().generateTests("T1");
  }
}
