package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHMorrowCountyParserTest extends BaseParserTest {
  
  public OHMorrowCountyParserTest() {
    setParser(new OHMorrowCountyParser(), "MORROW COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Alert: MVA) ALRM LVL: 1\nLOC:\n3556 RD 145\nGILEAD TWP\nBTWN: RD 9 & RD 30\n\nCOM:\nCAR FLIPPED\n1 CAR\n\nCT:\nBRM at POS 02",
        "CALL:MVA",
        "PRI:1",
        "ADDR:3556 RD 145",
        "CITY:GILEAD TWP",
        "X:RD 9 & RD 30",
        "INFO:CAR FLIPPED / 1 CAR / BRM at POS 02");

    doTest("T2",
        "(Alert: Fire Occupied Structure) ALRM LVL: 1\nLOC:\n2681 RD 254\nLINCOLN TWP\nBTWN: RD 155 & DEAD END\n\nRCVD AS 911\n\nCOM:\nCHIMNEY FIRE\nGETTING EVERYONE OUT OF THE HOUSE",
        "CALL:Fire Occupied Structure",
        "PRI:1",
        "ADDR:2681 RD 254",
        "CITY:LINCOLN TWP",
        "X:RD 155 & DEAD END",
        "INFO:CHIMNEY FIRE / GETTING EVERYONE OUT OF THE HOUSE");

    doTest("T3",
        "(Alert: MVA) ALRM LVL: 1\nLOC:\n156 I-71\nPERRY TWP\nBTWN: MM 156 & MM 158\n\nRCVD AS 911\n\nCOM:\nNB\n2 SEMI\nUNK IF OTHER SEMI IS CARRYING ANY HAZMAT\nACCIDENT IS SPREAD OUT",
        "CALL:MVA",
        "PRI:1",
        "ADDR:156 I-71",
        "MADDR:156 I 71",
        "CITY:PERRY TWP",
        "X:MM 156 & MM 158",
        "INFO:NB / 2 SEMI / UNK IF OTHER SEMI IS CARRYING ANY HAZMAT / ACCIDENT IS SPREAD OUT");

    doTest("T4",
        "(Alert: MVA - Non Injury) ALRM LVL: 1\nLOC:\n5475 RD 9\nGILEAD TWP\nBTWN: RD 127 & EDISON VILLAGE\n\nRCVD AS 911\n\nCOM:\nGUY STANDING ON TOP OF HIS TRUCK\nSURROUNDED BY WAT",
        "CALL:MVA - Non Injury",
        "PRI:1",
        "ADDR:5475 RD 9",
        "CITY:GILEAD TWP",
        "X:RD 127 & EDISON VILLAGE",
        "INFO:GUY STANDING ON TOP OF HIS TRUCK / SURROUNDED BY WAT");

    doTest("T5",
        "(Alert: Gas Smell) ALRM LVL: 1\nLOC:\n6803 RD 30\nGILEAD TWP\nBTWN: RD 75 & RD 61\n\nRCVD AS 911\n\nCOM:\nSMELL OF GAS\nCALLED FROM MARION\nCALLED IN FROM A PASSING CAR\nSMELL",
        "CALL:Gas Smell",
        "PRI:1",
        "ADDR:6803 RD 30",
        "CITY:GILEAD TWP",
        "X:RD 75 & RD 61",
        "INFO:SMELL OF GAS / CALLED FROM MARION / CALLED IN FROM A PASSING CAR / SMELL");

    doTest("T6",
        "(Alert: MVA) ALRM LVL: 1\nLOC:\n5957 RD 28\nCANAAN TWP\nBTWN: RD 135 & ST RT 95\n\nRCVD AS 911\n\nCOM:\nIN CAR CANNOT GET OUT NEEDS HELP UNABLE TO GET OUT DUE TO SOME UNKNO",
        "CALL:MVA",
        "PRI:1",
        "ADDR:5957 RD 28",
        "CITY:CANAAN TWP",
        "X:RD 135 & ST RT 95",
        "INFO:IN CAR CANNOT GET OUT NEEDS HELP UNABLE TO GET OUT DUE TO SOME UNKNO");
  }
  
  public static void main(String[] args) {
    new OHMorrowCountyParserTest().generateTests("T1");
  }
}