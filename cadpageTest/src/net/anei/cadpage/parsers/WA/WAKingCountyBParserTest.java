package net.anei.cadpage.parsers.WA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
King County, WA
Contact: "Dan Covey" <dan@dancovey.net>
System: Aegis

CAD||44530 Se 148th St # KING COUNTY Aid - Emergency FTAC1 L87,A88 
CAD||39664 Se Spruce St # Structure Fire - Residential FTAC2 281ST,E281,SQSOP,L87,E271,B71ST
CAD||51699 EB90 # KING COUNTY MVA - Rescue FTAC3 M3,A88,87ST,E291,E2
CAD||Addr: 79500 Wb90 Problem: MVA - Aid Emergency Units: A291,L87,KTAID,A291,SPFD1,E291, [Geographic Area: 79500 WB90] [Medi
CAD||410 NE 6th St # NORTH BEND Medic FTAC1 A88,M3,L87

*/

public class WAKingCountyBParserTest extends BaseParserTest {
  
  public WAKingCountyBParserTest() {
    setParser(new WAKingCountyBParser(), "KING COUNTY", "WA");
  }
  
  @Test
  public void testDanCovey() {

    doTest("T1",
        "CAD||44530 Se 148th St # KING COUNTY Aid - Emergency FTAC1 L87,A88 ",
        "ADDR:44530 Se 148th St",
        "CALL:KING COUNTY Aid - Emergency",
        "CH:FTAC1",
        "UNIT:L87,A88");

    doTest("T2",
        "CAD||39664 Se Spruce St # Structure Fire - Residential FTAC2 281ST,E281,SQSOP,L87,E271,B71ST",
        "ADDR:39664 Se Spruce St",
        "CALL:Structure Fire - Residential",
        "CH:FTAC2",
        "UNIT:281ST,E281,SQSOP,L87,E271,B71ST");

    doTest("T3",
        "CAD||51699 EB90 # KING COUNTY MVA - Rescue FTAC3 M3,A88,87ST,E291,E2",
        "ADDR:51699 EB90",
        "CALL:KING COUNTY MVA - Rescue",
        "CH:FTAC3",
        "UNIT:M3,A88,87ST,E291,E2");

    doTest("T4",
        "CAD||Addr: 79500 Wb90 Problem: MVA - Aid Emergency Units: A291,L87,KTAID,A291,SPFD1,E291, [Geographic Area: 79500 WB90] [Medi",
        "ADDR:79500 Wb90",
        "CALL:MVA - Aid",
        "UNIT:A291,L87,KTAID,A291,SPFD1,E291");

    doTest("T5",
        "CAD||410 NE 6th St # NORTH BEND Medic FTAC1 A88,M3,L87",
        "ADDR:410 NE 6th St",
        "CALL:NORTH BEND Medic",
        "CH:FTAC1",
        "UNIT:A88,M3,L87");

  }
  
  public static void main(String[] args) {
    new WAKingCountyBParserTest().generateTests("T1");
  }
}