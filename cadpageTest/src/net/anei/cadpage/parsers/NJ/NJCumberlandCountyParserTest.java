package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;
/*
Cumberland County, NJ
Contact: Ryan Feaster <feaster.ryan@gmail.com>
Sender: E911@co.cumberland.nj.us

E911:E22_INVEST_(VINELAND CITY)1763 CHEROKEE LA_2011-04-24 19:02:46_
E911:E2902_STRUCTURE_(GREENWICH TWP)176 BAYSIDE RD_2011-04-24 17:27:45_AREA OF THE BAY
E911:E22_COMM ALARM_(VINELAND CITY)CARNIVAL DISCOUNT LIQUORS / 4039 S MAIN RD_2011-04-24 12:27:19_
E911:29R-FA_BLEEDING_(DEERFIELD TWP)246 KENYON AV/SHINDLE RES_2011-05-02 10:25:55_
E911:29R-FA_BLEEDING_(DEERFIELD TWP)CUMBERLAND COUNTY TEC / 601 BRIDGETON AV_2011-05-02 09:27:47_NURSING OFFICE
E911:E21_VEHICLE_(VINELAND CITY)S DELSEA DR & W ELMER RD_2011-05-01 18:46:26_
E911:L2_COMM ALARM_(VINELAND CITY)COURTYARD SCHOOL INC / 1270 S EAST AVE_2011-05-01 17:03:36_
E911:B2_UNKNOWNF_(VINELAND CITY)1775 ROOSEVELT BLVD / BEHIND_2011-05-01 00:10:13_
E911:E2901_MVC_(DEERFIELD TWP)BIG OAK RD & MORTON AV_2011-04-30 00:06:19_
E911:E2901_COMM ALARM_(DEERFIELD TWP)MAJOR OIL / 733 LANDIS AV_2011-05-12 09:29:52_

Contact: Will Mosley <willmosleysr@gmail.com>
NJFFS-FD_WDS/BRSH_(MILLVILLE CITY)MILL VILLAGE APTS / 301 N WADE BLVD_2011-06-02 21:50:47_BEHIND/WOODS

Contact: Chuck Nardelli <chuckie3238@gmail.com>
(E3202_MVC_(UPPER DEERFIELD)DUBOIS RD & FINLEY RD_2011-08-16 01) 19:26_

Contact: ccerts2@aol.com
Sender: E911@co.cumberland.nj.us
Subject:R3923_DIABETIC_(DOWNE TWP)442 BAPTIST RD\nE911:21:35_\r
Subject:R3923_DWELLING_(FAIRFIELD TWP)254 BACK N\nE911:33:27_\r
Subject:T3911_COVER_(FAIRFIELD TWP)STATION 16 / \nE911:26:38_\r

*/

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
        "ADDR:1763 CHEROKEE LA",
        "MADDR:1763 CHEROKEE LN",
        "DATE:04/24/2011",
        "TIME:19:02:46");

    doTest("T2",
        "E911:E2902_STRUCTURE_(GREENWICH TWP)176 BAYSIDE RD_2011-04-24 17:27:45_AREA OF THE BAY",
        "UNIT:E2902",
        "CALL:STRUCTURE",
        "CITY:GREENWICH TWP",
        "ADDR:176 BAYSIDE RD",
        "DATE:04/24/2011",
        "TIME:17:27:45",
        "PLACE:AREA OF THE BAY");

    doTest("T3",
        "E911:E22_COMM ALARM_(VINELAND CITY)CARNIVAL DISCOUNT LIQUORS / 4039 S MAIN RD_2011-04-24 12:27:19_",
        "UNIT:E22",
        "CALL:COMM ALARM",
        "CITY:VINELAND CITY",
        "ADDR:4039 S MAIN RD",
        "DATE:04/24/2011",
        "TIME:12:27:19",
        "PLACE:CARNIVAL DISCOUNT LIQUORS");

    doTest("T4",
        "E911:29R-FA_BLEEDING_(DEERFIELD TWP)246 KENYON AV/SHINDLE RES_2011-05-02 10:25:55_",
        "UNIT:29R-FA",
        "CALL:BLEEDING",
        "CITY:DEERFIELD TWP",
        "ADDR:246 KENYON AV",
        "MADDR:246 KENYON AVE",
        "DATE:05/02/2011",
        "TIME:10:25:55",
        "PLACE:SHINDLE RES");

    doTest("T5",
        "E911:29R-FA_BLEEDING_(DEERFIELD TWP)CUMBERLAND COUNTY TEC / 601 BRIDGETON AV_2011-05-02 09:27:47_NURSING OFFICE",
        "UNIT:29R-FA",
        "CALL:BLEEDING",
        "CITY:DEERFIELD TWP",
        "ADDR:601 BRIDGETON AV",
        "MADDR:601 BRIDGETON AVE",
        "DATE:05/02/2011",
        "TIME:09:27:47",
        "PLACE:CUMBERLAND COUNTY TEC / NURSING OFFICE");

    doTest("T6",
        "E911:E21_VEHICLE_(VINELAND CITY)S DELSEA DR & W ELMER RD_2011-05-01 18:46:26_",
        "UNIT:E21",
        "CALL:VEHICLE",
        "CITY:VINELAND CITY",
        "ADDR:S DELSEA DR & W ELMER RD",
        "DATE:05/01/2011",
        "TIME:18:46:26");

    doTest("T7",
        "E911:L2_COMM ALARM_(VINELAND CITY)COURTYARD SCHOOL INC / 1270 S EAST AVE_2011-05-01 17:03:36_",
        "UNIT:L2",
        "CALL:COMM ALARM",
        "CITY:VINELAND CITY",
        "ADDR:1270 S EAST AVE",
        "DATE:05/01/2011",
        "TIME:17:03:36",
        "PLACE:COURTYARD SCHOOL INC");

    doTest("T8",
        "E911:B2_UNKNOWNF_(VINELAND CITY)1775 ROOSEVELT BLVD / BEHIND_2011-05-01 00:10:13_",
        "UNIT:B2",
        "CALL:UNKNOWNF",
        "CITY:VINELAND CITY",
        "ADDR:1775 ROOSEVELT BLVD",
        "DATE:05/01/2011",
        "TIME:00:10:13",
        "PLACE:BEHIND");

    doTest("T9",
        "E911:E2901_MVC_(DEERFIELD TWP)BIG OAK RD & MORTON AV_2011-04-30 00:06:19_",
        "UNIT:E2901",
        "CALL:MVC",
        "CITY:DEERFIELD TWP",
        "ADDR:BIG OAK RD & MORTON AV",
        "MADDR:BIG OAK RD & MORTON AVE",
        "DATE:04/30/2011",
        "TIME:00:06:19");

    doTest("T10",
        "E911:E2901_COMM ALARM_(DEERFIELD TWP)MAJOR OIL / 733 LANDIS AV_2011-05-12 09:29:52_",
        "UNIT:E2901",
        "CALL:COMM ALARM",
        "CITY:DEERFIELD TWP",
        "ADDR:733 LANDIS AV",
        "MADDR:733 LANDIS AVE",
        "DATE:05/12/2011",
        "TIME:09:29:52",
        "PLACE:MAJOR OIL");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "NJFFS-FD_WDS/BRSH_(MILLVILLE CITY)MILL VILLAGE APTS / 301 N WADE BLVD_2011-06-02 21:50:47_BEHIND/WOODS",
        "UNIT:NJFFS-FD",
        "CALL:WDS/BRSH",
        "CITY:MILLVILLE CITY",
        "ADDR:301 N WADE BLVD",
        "DATE:06/02/2011",
        "TIME:21:50:47",
        "PLACE:MILL VILLAGE APTS / BEHIND/WOODS");
    
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "Subject:R3923_DIABETIC_(DOWNE TWP)442 BAPTIST RD\nE911:21:35_\r",
        "UNIT:R3923",
        "CALL:DIABETIC",
        "CITY:DOWNE TWP",
        "ADDR:442 BAPTIST RD",
        "TIME:21:35");

    doTest("T2",
        "Subject:R3923_DWELLING_(FAIRFIELD TWP)254 BACK N\nE911:33:27_\r",
        "UNIT:R3923",
        "CALL:DWELLING",
        "CITY:FAIRFIELD TWP",
        "ADDR:254 BACK N",
        "TIME:33:27");

    doTest("T3",
        "Subject:T3911_COVER_(FAIRFIELD TWP)STATION 16 / \nE911:26:38_\r",
        "UNIT:T3911",
        "CALL:COVER",
        "CITY:FAIRFIELD TWP",
        "TIME:26:38",
        "PLACE:STATION 16");

  }
    
  public static void main(String[] args) {
    new NJCumberlandCountyParserTest().generateTests("T1");
  }
}