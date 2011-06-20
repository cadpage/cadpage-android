package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYNassauCountyFiretrackerParserTest extends BaseParserTest {
  
  public NYNassauCountyFiretrackerParserTest() {
    setParser(new NYNassauCountyFiretrackerParser(), "NASSAU COUNTY", "NY");
  }
  
  @Test
  public void testFFDParser() {

    doTest("T1",
        "(FirePage) ** FFD FIRE CALL ** GENERAL PROB WITH GAS STOVE-POSS LEAK 170 JAY ST\nC/S: DEAN (E) ST / MILTON (E) ST TOA: 17:02 [FireTracker]",
        "SRC:FFD",
        "CALL:GENERAL PROB WITH GAS STOVE-POSS LEAK",
        "ADDR:170 JAY ST",
        "X:DEAN (E) ST / MILTON (E) ST");

    doTest("T2",
        "(FirePage) ** FFD FIRE CALL ** DISTRIC DIST CALL FOR SMOKE IN THE AREA CHURCH ST\nC/S: ARCHER ST TOA: 19:12 [FireTracker]",
        "SRC:FFD",
        "CALL:DISTRIC DIST CALL FOR SMOKE IN THE AREA",
        "ADDR:CHURCH ST",
        "X:ARCHER ST");

    doTest("T3",
        "(FirePage) ** FFD FIRE CALL ** GENERAL APT 72 / 3RD FLOOR / SMOKE 100 N MAIN ST\nC/S: RANDALL AVE / GRAND AVE TOA: 18:50 [FireTracker]",
        "SRC:FFD",
        "CALL:GENERAL/3RD FLOOR/SMOKE",
        "APT:72",
        "ADDR:100 N MAIN ST",
        "X:RANDALL AVE / GRAND AVE");

    doTest("T4",
        "(FirePage) ** FFD FIRE CALL ** STILL WILLOWBROOK LA C/S: BROOKSIDE (N) AVE TOA:\n09:16 [FireTracker]",
        "SRC:FFD",
        "CALL:STILL",
        "ADDR:WILLOWBROOK LN",
        "X:BROOKSIDE (N) AVE");

    doTest("T5",
        "(FirePage) ** FFD FIRE CALL ** GENERAL ELEC PROBLEM/APT 415 45 WALLACE ST C/S:\nBROOKLYN AVE / RANDALL AVE TOA: 18:26 [FireTracker]",
        "SRC:FFD",
        "CALL:GENERAL ELEC PROBLEM /",
        "APT:415",
        "ADDR:45 WALLACE ST",
        "X:BROOKLYN AVE / RANDALL AVE");


    doTest("T6",
        "(FirePage) ** FFD FIRE CALL ** CARBON APT 33 116 WEST END AVE C/S: RAY ST / ELINOR\nPL TOA: 11:23 [FireTracker]",
        "SRC:FFD",
        "CALL:CARBON",
        "ADDR:116 WEST END AVE",
        "APT:33",
        "X:RAY ST / ELINOR PL");

    doTest("T7",
        "(FirePage) ** FFD FIRE CALL ** GENERAL 22 PEARSALL AVE C/S: LONG BEACH (N) AVE /\nPENNSYLVANIA AVE TOA: 15:56 [FireTracker]",
        "SRC:FFD",
        "CALL:GENERAL",
        "ADDR:22 PEARSALL AVE",
        "X:LONG BEACH (N) AVE / PENNSYLVANIA AVE");
  
  }
  
  @Test
  public void testFSMFDParser() {

    doTest("T1",
        "(FirePage) *FSMFD* 4/22/2011 TOA:20:47 AMBU [AMBU] 178 RINTIN ST BENRIS AVE ARM\nINJURY [FireTracker]",
        "SRC:FSMFD",
        "CALL:AMBU",
        "ADDR:178 RINTIN ST",
        "X:BENRIS AVE",
        "INFO:ARM INJURY");

    doTest("T2",
        "(FirePage) *FSMFD* 4/27/2011 TOA:21:12 AMBU [AMBU] 820 FRANKLIN PL GARDEN CITY ROAD\nDIZZY FEMALE VOMITING [FireTracker]",
        "SRC:FSMFD",
        "CALL:AMBU",
        "ADDR:820 FRANKLIN PL",
        "X:GARDEN CITY ROAD",
        "INFO:DIZZY FEMALE VOMITING");

    doTest("T3",
        "(FirePage) *FSMFD* 4/28/2011 TOA:14:59 AMBU [AMBU] 1150 HEMPSTEAD TPK RENKEN BLVD\nIN THE SICK BAY SICK FEMALE [FireTracker]",
        "SRC:FSMFD",
        "CALL:AMBU",
        "ADDR:1150 HEMPSTEAD TPK",
        "X:RENKEN BLVD",
        "INFO:IN THE SICK BAY SICK FEMALE");

    doTest("T4",
        "(FirePage) *FSMFD* 4/28/2011 TOA:19:45 AMBU [AMBU] 947 MAPLE DR COURT HOUSE ROAD\nMALE,SHORT OF BREATH [FireTracker]",
        "SRC:FSMFD",
        "CALL:AMBU",
        "ADDR:947 MAPLE DR",
        "X:COURT HOUSE ROAD",
        "INFO:MALE,SHORT OF BREATH");

    doTest("T5",
        "(FirePage) *FSMFD* 4/28/2011 TOA:22:16 AMBU [AMBU] 1031 MOSEFAN ST WILLIAM AVE\nFEMALE FELL,WRIST INJURY [FireTracker]",
        "SRC:FSMFD",
        "CALL:AMBU",
        "ADDR:1031 MOSEFAN ST",
        "X:WILLIAM AVE",
        "INFO:FEMALE FELL,WRIST INJURY");

    doTest("T6",
        "[FirePage]  *FSMFD* 4/28/2011 TOA:22:16 AMBU [AMBU] 1031 MOSEFAN ST WILLIAM AVE FEMALE FELL,WRIST INJURY [FireTracker]",
        "SRC:FSMFD",
        "CALL:AMBU",
        "ADDR:1031 MOSEFAN ST",
        "X:WILLIAM AVE",
        "INFO:FEMALE FELL,WRIST INJURY");

    doTest("T7",
        "(FirePage) *FSMFD* 4/28/2011 TOA:23:14 CARB 1 [CARB] 551 CHESMAN ST NASSAU BLVD NO\nAIDED [FireTracker]",
        "SRC:FSMFD",
        "CALL:CARB 1",
        "ADDR:551 CHESMAN ST",
        "X:NASSAU BLVD",
        "INFO:NO AIDED");

    doTest("T8",
        "(FirePage) *FSMFD* 4/29/2011 TOA:19:21 AMBU [AMBU] 775 CORNELL ROAD ETON ROAD MALE\nFELL-HIP INJURY [FireTracker]",
        "SRC:FSMFD",
        "CALL:AMBU",
        "ADDR:775 CORNELL ROAD",
        "X:ETON ROAD",
        "INFO:MALE FELL-HIP INJURY");

    doTest("T9",
        "(FirePage) *FSMFD* 4/29/2011 TOA:21:59 MUTUAID [MAF] 125 MEACHAM AVE POST AVE\n[FireTracker]",
        "SRC:FSMFD",
        "CALL:MUTUAID",
        "ADDR:125 MEACHAM AVE",
        "X:POST AVE");

    doTest("T10",
        "(FirePage) FSMFD 5/2/2011 TOA:17:36 AMBU [AMBU] 766 WILLOW ROAD BIRCH ST BROKEN\nHIP [FireTracker]",
        "SRC:FSMFD",
        "CALL:AMBU",
        "ADDR:766 WILLOW ROAD",
        "X:BIRCH ST",
        "INFO:BROKEN HIP");
    
  }
  
  @Test
  public void testNMFDParser() {

    doTest("T1",
        "1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [GENERAL] [HOUSE] 7 ARMS AVE C/S: CAMP AVE / GARFIELD (E) ST -\nM/A 64 UPSTAIRS\n(Con' 2 of 2\nTOA:01:57 6/20/2011 Town Of: MERRICK [FireTracker](End)",
        "SRC:NMFD",
        "CALL:[GENERAL] [HOUSE]",
        "ADDR:7 ARMS AVE",
        "X:CAMP AVE / GARFIELD (E) ST - M/A 64 UPSTAIRS");
    
  }
  
  public static void main(String[] args) {
    new NYNassauCountyFiretrackerParserTest().generateTests("T6");
    //new NYNassauCountyFiretrackerParserTest().generateTests("T1", "SRC CALL ADDR X INFO");
  }
}