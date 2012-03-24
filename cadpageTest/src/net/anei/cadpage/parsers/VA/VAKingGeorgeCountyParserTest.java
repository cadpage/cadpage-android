package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class VAKingGeorgeCountyParserTest extends BaseParserTest {
  
  public VAKingGeorgeCountyParserTest() {
    setParser(new VAKingGeorgeCountyParser(), "KING GEORGE COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "KGFR1 MOTOR VEHICLE ACCIDENT KINGS HWY & BIG TIMBER RD CFS# 2012-007738 Run# 000668",
        "SRC:KGFR1",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:KINGS HWY & BIG TIMBER RD",
        "ID:2012-007738");

    doTest("T2",
        "DES MOTOR VEHICLE ACCIDENT KINGS HWY & BIG TIMBER RD CFS# 2012-007738 Run# 000668",
        "SRC:DES",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:KINGS HWY & BIG TIMBER RD",
        "ID:2012-007738");

    doTest("T3",
        "DES CHOKING 6053 ROSEDALE DR CFS# 2012-007707 Run# 000666 CROSS: FERRY DOCK RD/SIXTH ST",
        "SRC:DES",
        "CALL:CHOKING",
        "ADDR:6053 ROSEDALE DR",
        "ID:2012-007707",
        "X:FERRY DOCK RD/SIXTH ST");

    doTest("T4",
        "DES MOTOR VEHICLE ACCIDENT KINGS HWY & BIG TIMBER RD CFS# 2012-007738 Run# 000668",
        "SRC:DES",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:KINGS HWY & BIG TIMBER RD",
        "ID:2012-007738");

    doTest("T5",
        "KGFR1 PUBLIC SERVICE - FIRE DEPT 8122 KINGS HWY CFS# 2012-007650 Run# 000664 CROSS: MADISON DR/DAHLGREN RD",
        "SRC:KGFR1",
        "CALL:PUBLIC SERVICE - FIRE DEPT",
        "ADDR:8122 KINGS HWY",
        "ID:2012-007650",
        "X:MADISON DR/DAHLGREN RD");

    doTest("T6",
        "DES ILLNESS 9352 INAUGURAL DR CFS# 2012-007642 Run# 000663 CROSS: COLUMBIA DR/AMBASSADOR DR",
        "SRC:DES",
        "CALL:ILLNESS",
        "ADDR:9352 INAUGURAL DR",
        "ID:2012-007642",
        "X:COLUMBIA DR/AMBASSADOR DR");

    doTest("T7",
        "KGFR1 PUBLIC SERVICE - FIRE DEPT 8122 KINGS HWY CFS# 2012-007650 Run# 000664 CROSS: MADISON DR/DAHLGREN RD",
        "SRC:KGFR1",
        "CALL:PUBLIC SERVICE - FIRE DEPT",
        "ADDR:8122 KINGS HWY",
        "ID:2012-007650",
        "X:MADISON DR/DAHLGREN RD");

    doTest("T8",
        "DES ALLERGIC REACTION 9447 INAUGURAL DR CFS# 2012-007604 Run# 000661 CROSS: KINGS HWY/COLUMBIA DR",
        "SRC:DES",
        "CALL:ALLERGIC REACTION",
        "ADDR:9447 INAUGURAL DR",
        "ID:2012-007604",
        "X:KINGS HWY/COLUMBIA DR");

    doTest("T9",
        "DES ILLNESS 17065 TWELFTH ST CFS# 2012-007589 Run# 000659 CROSS: DAHLGREN RD/POTOMAC DR",
        "SRC:DES",
        "CALL:ILLNESS",
        "ADDR:17065 TWELFTH ST",
        "ID:2012-007589",
        "X:DAHLGREN RD/POTOMAC DR");

    doTest("T10",
        "DES ABDOMINAL PAIN 4755 JAMES MADISON PKY CFS# 2012-007574 Run# 000657 CROSS: COMMERCE DR/DANUBE DR",
        "SRC:DES",
        "CALL:ABDOMINAL PAIN",
        "ADDR:4755 JAMES MADISON PKY",
        "ID:2012-007574",
        "X:COMMERCE DR/DANUBE DR");

    doTest("T11",
        "KGFR2 FIRE ALARM RESIDENTIAL 6138 SCHOONER CIR CFS# 2012-007553 Run# 000656 CROSS: WINDWARD LN/ROSEDALE DR",
        "SRC:KGFR2",
        "CALL:FIRE ALARM RESIDENTIAL",
        "ADDR:6138 SCHOONER CIR",
        "ID:2012-007553",
        "X:WINDWARD LN/ROSEDALE DR");

    doTest("T12",
        "DES DIFFICULTY BREATHING 9445 INAUGURAL DR CFS# 2012-007549 Run# 000655 CROSS: KINGS HWY/COLUMBIA DR",
        "SRC:DES",
        "CALL:DIFFICULTY BREATHING",
        "ADDR:9445 INAUGURAL DR",
        "ID:2012-007549",
        "X:KINGS HWY/COLUMBIA DR");

    doTest("T13",
        "KGFR1 MUTUAL AID TO (FIRE) 518 MARKET ST PORT ROYAL CFS# 2012-007530 Run# 000652 ",
        "SRC:KGFR1",
        "CALL:MUTUAL AID TO (FIRE)",
        "ADDR:518 MARKET ST",
        "CITY:PORT ROYAL",
        "ID:2012-007530");
  }
  
  @Test
  public void testCamdenBullock() {

    doTest("T1",
        "KGFR1 OVERDOSE 8429 FLETCHERS CHAPEL RD CFS# 2012-008288 Run# 000728 CROSS: CALEDON RD/SHELTON LN",
        "SRC:KGFR1",
        "CALL:OVERDOSE",
        "ADDR:8429 FLETCHERS CHAPEL RD",
        "ID:2012-008288",
        "X:CALEDON RD/SHELTON LN");

    doTest("T2",
        "DES MUTUAL AID TO (RESCUE) 9384 CANVAS BACK COURT CFS# 2012-008307 Run# 000729",
        "SRC:DES",
        "CALL:MUTUAL AID TO (RESCUE)",
        "ADDR:9384 CANVAS BACK COURT",
        "ID:2012-008307");

    doTest("T3",
        "KGFR1 OVERDOSE 8429 FLETCHERS CHAPEL RD CFS# 2012-008288 Run# 000728 CROSS: CALEDON RD/SHELTON LN",
        "SRC:KGFR1",
        "CALL:OVERDOSE",
        "ADDR:8429 FLETCHERS CHAPEL RD",
        "ID:2012-008288",
        "X:CALEDON RD/SHELTON LN");

    doTest("T4",
        "KGFR2 MVA OVERTURNED KINGS HWY & SALEM CHURCH RD CFS# 2012-008347 Run# 000731",
        "SRC:KGFR2",
        "CALL:MVA OVERTURNED",
        "ADDR:KINGS HWY & SALEM CHURCH RD",
        "ID:2012-008347");
    
  }
  
  public static void main(String[] args) {
    new VAKingGeorgeCountyParserTest().generateTests("T1", "SRC CALL CITY ADDR ID X INFO");
  }
}
  