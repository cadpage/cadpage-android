package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

public class NJCumberlandCountyParserTest extends BaseParserTest {
  
  public NJCumberlandCountyParserTest() {
    setParser(new NJCumberlandCountyParser(), "CUMBERLAND COUNTY", "NJ");
  }
  
  @Test
  public void testParser1() {
    
    doTest("T1",
        "E911:E22_INVEST_(VINELAND CITY)1763 CHEROKEE LA_2011-04-24 19:02:46_",
        "UNIT:E22",
        "CALL:INVEST",
        "CITY:VINELAND CITY",
        "ADDR:1763 CHEROKEE LN");

    doTest("T2",
        "E911:E2902_STRUCTURE_(GREENWICH TWP)176 BAYSIDE RD_2011-04-24 17:27:45_AREA OF THE BAY",
        "UNIT:E2902",
        "CALL:STRUCTURE",
        "CITY:GREENWICH TWP",
        "ADDR:176 BAYSIDE RD",
        "PLACE:AREA OF THE BAY");

    doTest("T3",
        "E911:E22_COMM ALARM_(VINELAND CITY)CARNIVAL DISCOUNT LIQUORS / 4039 S MAIN RD_2011-04-24 12:27:19_",
        "UNIT:E22",
        "CALL:COMM ALARM",
        "CITY:VINELAND CITY",
        "PLACE:CARNIVAL DISCOUNT LIQUORS",
        "ADDR:4039 S MAIN RD");

    doTest("T4",
        "E911:29R-FA_BLEEDING_(DEERFIELD TWP)246 KENYON AV/SHINDLE RES_2011-05-02 10:25:55_",
        "UNIT:29R-FA",
        "CALL:BLEEDING",
        "CITY:DEERFIELD TWP",
        "ADDR:246 KENYON AV",
        "PLACE:SHINDLE RES");

    doTest("T5",
        "E911:29R-FA_BLEEDING_(DEERFIELD TWP)CUMBERLAND COUNTY TEC / 601 BRIDGETON AV_2011-05-02 09:27:47_NURSING OFFICE",
        "UNIT:29R-FA",
        "CALL:BLEEDING",
        "CITY:DEERFIELD TWP",
        "PLACE:CUMBERLAND COUNTY TEC / NURSING OFFICE",
        "ADDR:601 BRIDGETON AV");

    doTest("T6",
        "E911:E21_VEHICLE_(VINELAND CITY)S DELSEA DR & W ELMER RD_2011-05-01 18:46:26_",
        "UNIT:E21",
        "CALL:VEHICLE",
        "CITY:VINELAND CITY",
        "ADDR:S DELSEA DR & W ELMER RD");

    doTest("T7",
        "E911:L2_COMM ALARM_(VINELAND CITY)COURTYARD SCHOOL INC / 1270 S EAST AVE_2011-05-01 17:03:36_",
        "UNIT:L2",
        "CALL:COMM ALARM",
        "CITY:VINELAND CITY",
        "PLACE:COURTYARD SCHOOL INC",
        "ADDR:1270 S EAST AVE");

    doTest("T8",
        "E911:B2_UNKNOWNF_(VINELAND CITY)1775 ROOSEVELT BLVD / BEHIND_2011-05-01 00:10:13_",
        "UNIT:B2",
        "CALL:UNKNOWNF",
        "CITY:VINELAND CITY",
        "ADDR:1775 ROOSEVELT BLVD",
        "PLACE:BEHIND");

    doTest("T9",
        "E911:E2901_MVC_(DEERFIELD TWP)BIG OAK RD & MORTON AV_2011-04-30 00:06:19_",
        "UNIT:E2901",
        "CALL:MVC",
        "CITY:DEERFIELD TWP",
        "ADDR:BIG OAK RD & MORTON AV");

    doTest("T10",
        "E911:E2901_COMM ALARM_(DEERFIELD TWP)MAJOR OIL / 733 LANDIS AV_2011-05-12 09:29:52_",
        "UNIT:E2901",
        "CALL:COMM ALARM",
        "CITY:DEERFIELD TWP",
        "PLACE:MAJOR OIL",
        "ADDR:733 LANDIS AV");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "NJFFS-FD_WDS/BRSH_(MILLVILLE CITY)MILL VILLAGE APTS / 301 N WADE BLVD_2011-06-02 21:50:47_BEHIND/WOODS",
        "UNIT:NJFFS-FD",
        "CALL:WDS/BRSH",
        "CITY:MILLVILLE CITY",
        "ADDR:301 N WADE BLVD",
        "PLACE:MILL VILLAGE APTS / BEHIND/WOODS");
    
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "(E3202_MVC_(UPPER DEERFIELD)DUBOIS RD & FINLEY RD_2011-08-16 01) 19:26_",
        "UNIT:E3202",
        "CALL:MVC",
        "CITY:UPPER DEERFIELD",
        "ADDR:DUBOIS RD & FINLEY RD");

  }
 
    
    
    
  public static void main(String[] args) {
    new NJCumberlandCountyParserTest().generateTests("T1");
  }
}