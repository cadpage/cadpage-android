package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Muscalane County, IA
Contact: KEVIN FLYNN <kwf9111@gmail.com>
System: Iamresponding
Sender: 7771

.... (NFD) 12-001870 MEDICAL \n1089 180TH ST \nATWOOD AVE / BANCROF/T AVE \nNICHOLS \nNFR WLAB
.... (NFD) 11-052885 ACCIDENT-PI\nIJEM AVE/ MAIN ST\nNICHOLS\nNFD NFR
.... (NFD) 11-052886 FIRE-STRUCTURE\n410 RAILROAD ST\nIJEM AVE / WASHINGTO/N AVE\nNICHOLS\nNFD
.... (NFD) 12-001933 MEDICAL\n1649 HOLLY AVE\n160TH ST / 170TH ST/\nWEST LIBERTY\nNFR WLAB
.... (NFD) 12-000312 FIRE-STRUCTURE\n1530 ATWOOD AVE\n560TH ST SE / 160TH/ST\nWEST LIBERTY\nNFD WLFD

 */

public class IAMuscatineCountyParserTest extends BaseParserTest {
  
  public IAMuscatineCountyParserTest() {
    setParser(new IAMuscatineCountyParser(), "MUSCATINE COUNTY", "IA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        ".... (NFD) 12-001870 MEDICAL \n1089 180TH ST \nATWOOD AVE / BANCROF/T AVE \nNICHOLS \nNFR WLAB",
        "SRC:NFD",
        "ID:12-001870",
        "CALL:MEDICAL",
        "ADDR:1089 180TH ST",
        "X:ATWOOD AVE / BANCROF/T AVE",
        "CITY:NICHOLS",
        "UNIT:NFR WLAB");

    doTest("T2",
        ".... (NFD) 11-052885 ACCIDENT-PI\nIJEM AVE/ MAIN ST\nNICHOLS\nNFD NFR",
        "SRC:NFD",
        "ID:11-052885",
        "CALL:ACCIDENT-PI",
        "ADDR:IJEM AVE & MAIN ST",
        "CITY:NICHOLS",
        "UNIT:NFD NFR");

    doTest("T3",
        ".... (NFD) 11-052886 FIRE-STRUCTURE\n410 RAILROAD ST\nIJEM AVE / WASHINGTO/N AVE\nNICHOLS\nNFD",
        "SRC:NFD",
        "ID:11-052886",
        "CALL:FIRE-STRUCTURE",
        "ADDR:410 RAILROAD ST",
        "X:IJEM AVE / WASHINGTO/N AVE",
        "CITY:NICHOLS",
        "UNIT:NFD");

    doTest("T4",
        ".... (NFD) 12-001933 MEDICAL\n1649 HOLLY AVE\n160TH ST / 170TH ST/\nWEST LIBERTY\nNFR WLAB",
        "SRC:NFD",
        "ID:12-001933",
        "CALL:MEDICAL",
        "ADDR:1649 HOLLY AVE",
        "X:160TH ST / 170TH ST/",
        "CITY:WEST LIBERTY",
        "UNIT:NFR WLAB");

    doTest("T5",
        ".... (NFD) 12-000312 FIRE-STRUCTURE\n1530 ATWOOD AVE\n560TH ST SE / 160TH/ST\nWEST LIBERTY\nNFD WLFD",
        "SRC:NFD",
        "ID:12-000312",
        "CALL:FIRE-STRUCTURE",
        "ADDR:1530 ATWOOD AVE",
        "X:560TH ST SE / 160TH/ST",
        "CITY:WEST LIBERTY",
        "UNIT:NFD WLFD");
  
  }
  
  public static void main(String[] args) {
    new IAMuscatineCountyParserTest().generateTests("T1");
  }
}