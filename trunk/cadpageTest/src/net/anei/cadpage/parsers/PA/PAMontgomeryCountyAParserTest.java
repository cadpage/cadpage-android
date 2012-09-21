package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAMontgomeryCountyAParserTest extends BaseParserTest {
  
  public PAMontgomeryCountyAParserTest() {
    setParser(new PAMontgomeryCountyAParser(), "MONTGOMERY COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:Dispatch\n09:39 * RESCUE - WATER * 316 RIVER RD * - *",
        "CALL:RESCUE - WATER",
        "ADDR:316 RIVER RD");

    doTest("T2",
        "Subject:Dispatch\n11:12 * PUMP DETAIL * 114 KOEGEL LN * - *",
        "CALL:PUMP DETAIL",
        "ADDR:114 KOEGEL LN");

    doTest("T3",
        "Subject:Dispatch\n13:32 * GAS-ODOR/LEAK OUTSIDE * 2409 DAIRY LN * - *",
        "CALL:GAS-ODOR/LEAK OUTSIDE",
        "ADDR:2409 DAIRY LN");

    doTest("T4",
        "Subject:Dispatch\n18:06 * VEHICLE FIRE * N TROOPER RD AND W MAIN ST * - *",
        "CALL:VEHICLE FIRE",
        "ADDR:N TROOPER RD AND W MAIN ST");

    doTest("T5",
        "Subject:Dispatch\n01:49 * BUILDING FIRE COMMERCIAL * 2030 MAIN ST W * DOMINOS PIZZA- *",
        "CALL:BUILDING FIRE COMMERCIAL",
        "ADDR:2030 MAIN ST W",
        "PLACE:DOMINOS PIZZA");

    doTest("T6",
        "Subject:Dispatch\n03:20 * RESCUE - WATER * 6025 VALLEY GREEN RD W * PHILADELPHIA CRICKET CLUB- *",
        "CALL:RESCUE - WATER",
        "ADDR:6025 VALLEY GREEN RD W",
        "PLACE:PHILADELPHIA CRICKET CLUB");

    doTest("T7",
        "Subject:Dispatch\n18:10 * S/B AT HELICOPTER LANDING * 51 UPPER FARM RD  Apt# C2 * BUILDING 051 NORRISTOWN STATE HOSPITAL- *",
        "CALL:S/B AT HELICOPTER LANDING",
        "ADDR:51 UPPER FARM RD",
        "APT:C2",
        "PLACE:BUILDING 051 NORRISTOWN STATE HOSPITAL");
  }
  
  public static void main(String[] args) {
    new PAMontgomeryCountyAParserTest().generateTests("T1");
  }
}