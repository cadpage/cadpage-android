package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJAtlanticareEMSParserTest extends BaseParserTest {
  
  public NJAtlanticareEMSParserTest() {
    setParser(new NJAtlanticareEMSParser(), "", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54365/LINWOOD-EMS/199 NEW RD/law office in central square/LINWOOD/11:14/////////<Unknown>",
        "SRC:NOPHI MEDCOM",
        "ID:54365",
        "CALL:LINWOOD-EMS",
        "ADDR:199 NEW RD",
        "PLACE:law office in central square",
        "CITY:LINWOOD");

    doTest("T2",
        "[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54353/MICU/42 ROUTE 50/X KRUK TERRACE/OCEAN VIEW/10:16///////SEAVILLE//<Unknown>",
        "SRC:NOPHI MEDCOM",
        "ID:54353",
        "CALL:MICU",
        "ADDR:42 ROUTE 50",
        "X:KRUK TERRACE",
        "CITY:OCEAN VIEW");

    doTest("T3",
        "[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54345/MICU/117 HARRISON AVE/x new rd/PLEASANTVILLE/09:36/////////<Unknown>",
        "SRC:NOPHI MEDCOM",
        "ID:54345",
        "CALL:MICU",
        "ADDR:117 HARRISON AVE",
        "X:new rd",
        "CITY:PLEASANTVILLE");

    doTest("T4",
        "[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54374/MICU/301 W  DELILAH RD/U7/PLEASANTVILLE/12:08/////////<Unknown>",
        "SRC:NOPHI MEDCOM",
        "ID:54374",
        "CALL:MICU",
        "ADDR:301 W  DELILAH RD",
        "PLACE:U7",
        "CITY:PLEASANTVILLE");

    doTest("T5",
        "[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54384/MICU/13 MANCHESTER ST/x s moore rd/ABSECON/12:29/////////<Unknown>",
        "SRC:NOPHI MEDCOM",
        "ID:54384",
        "CALL:MICU",
        "ADDR:13 MANCHESTER ST",
        "X:s moore rd",
        "CITY:ABSECON");
  }
  
  public static void main(String[] args) {
    new NJAtlanticareEMSParserTest().generateTests("T1");
  }
}