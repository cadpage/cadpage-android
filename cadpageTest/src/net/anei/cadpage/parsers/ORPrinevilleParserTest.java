package net.anei.cadpage.parsers;

import org.junit.Test;


public class ORPrinevilleParserTest extends BaseParserTest {
  
  public ORPrinevilleParserTest() {
    setParser(new ORPrinevilleParser(), "PRINEVILLE", "OR");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "(PPD) 6:01 PM\nNEW EVENT PFD\nMED1\n1201: 1271\n228 SW MEADOWLAKES DR\nPRINEVILLE",
        "CALL:MED1",
        "ADDR:228 SW MEADOWLAKES DR",
        "CITY:PRINEVILLE");
    
    doTest("T2",
        "(PPD) 3:17 PM\nNEW EVENT PFD\nMVA\n1201: 1273 / 1225\nLAMONTA/PIONEER CUTSTOCK\nPRINEVILLE",
        "CALL:MVA",
        "ADDR:LAMONTA & PIONEER CUTSTOCK",
        "CITY:PRINEVILLE");
      }
}