package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCAnsonCountyParserTest extends BaseParserTest {
  
  public NCAnsonCountyParserTest() {
    setParser(new NCAnsonCountyParser(), "ANSON COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "1078 SALISBURY ST WADESBORO 2012007703 14:09:41 FIRE STRUCTURE MA 1: ST3 LVILLE MA 2: ST6 POLKTON",
        "ADDR:1078 SALISBURY ST",
        "CITY:WADESBORO",
        "ID:2012007703",
        "TIME:14:09:41",
        "CALL:FIRE STRUCTURE",
        "INFO:MA 1: ST3 LVILLE MA 2: ST6 POLKTON");

    doTest("T2",
        "0 US HWY 52 N ANSONVILLE 2012007859 15:02:58 ACCIDENT - PERSONAL INJURIES GREY IMPALA IN WOODS",
        "ADDR:US HWY 52 N",
        "MADDR:US 52 N",
        "CITY:ANSONVILLE",
        "ID:2012007859",
        "TIME:15:02:58",
        "CALL:ACCIDENT - PERSONAL INJURIES GREY IMPALA IN WOODS");

    doTest("T3",
        "264 MARTIN ST ANSONVILLE MDL 26O21 2012007878 18:02:33 AMBULANCE NEEDED JENNY TYSON MA1: ST 8 BVILLE MA2: ST 6 POLKTON",
        "ADDR:264 MARTIN ST",
        "CITY:ANSONVILLE",
        "CODE:26O21",
        "ID:2012007878",
        "TIME:18:02:33",
        "CALL:AMBULANCE NEEDED JENNY TYSON",
        "INFO:MA1: ST 8 BVILLE MA2: ST 6 POLKTON");

    doTest("T4",
        "3263 RANDALL RD POLKTON MDL 10C02 2012007984 16:07:15 CHEST PAIN MA1: ST 8 BVILLE MA2: ST 6 POLKTON",
        "ADDR:3263 RANDALL RD",
        "CITY:POLKTON",
        "CODE:10C02",
        "ID:2012007984",
        "TIME:16:07:15",
        "CALL:CHEST PAIN",
        "INFO:MA1: ST 8 BVILLE MA2: ST 6 POLKTON");

    doTest("T5",
        "388 JACKS BRANCH RD WADESBORO MDL 10D04 2012007967 07:16:47 CHEST PAIN MA1: ST 8 BVILLE MA2: ST 6 POLKTON",
        "ADDR:388 JACKS BRANCH RD",
        "CITY:WADESBORO",
        "CODE:10D04",
        "ID:2012007967",
        "TIME:07:16:47",
        "CALL:CHEST PAIN",
        "INFO:MA1: ST 8 BVILLE MA2: ST 6 POLKTON");

  }
  
  public static void main(String[] args) {
    new NCAnsonCountyParserTest().generateTests("T1", "ADDR CITY CODE ID TIME CALL INFO");
  }
}