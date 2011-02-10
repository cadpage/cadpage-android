package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCUnionCountyParserTest extends BaseParserTest {
  
  public NCUnionCountyParserTest() {
    setParser(new NCUnionCountyParser(), "UNION COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:5413 MONROE ANSONVILLE RD;CHEST PAIN EMD;S09;B-CF2;CLARK ST;ANSONVILLE RD;01/26/2011 05:41:48",
        "ADDR:5413 MONROE ANSONVILLE RD",
        "CALL:CHEST PAIN EMD",
        "SRC:S09",
        "INFO:B-CF2",
        "X:CLARK ST & ANSONVILLE RD");

    doTest("T2",
        "CAD:226 S MAIN ST;GATEWOOD VILLAGE;FIRE ALARM EFD;S09;B2;HINSON ST;GOODWILL LN;01/16/2011 14:04:24",
        "ADDR:226 S MAIN ST",
        "PLACE:GATEWOOD VILLAGE",
        "CALL:FIRE ALARM EFD",
        "SRC:S09",
        "INFO:B2",
        "X:HINSON ST & GOODWILL LN");

    doTest("T3",
        "CAD:1299 WITMORE RD/OLD MONROE MARSHVILLE RD;ACCIDENT EMD;S09;B-CF2;01/21/2011 16:59:15",
        "ADDR:1299 WITMORE RD & OLD MONROE MARSHVILLE RD",
        "CALL:ACCIDENT EMD",
        "SRC:S09",
        "INFO:B-CF2");

    doTest("T4",
        "CAD:3344 PRESSON RD;UNION COUNTY SHERIFFS OFFICE;FALLS EMD;S09;D/ST;E HWY 74;DRIVEWAY;01/22/2011 16:53:54",
        "ADDR:3344 PRESSON RD",
        "PLACE:UNION COUNTY SHERIFFS OFFICE",
        "CALL:FALLS EMD",
        "SRC:S09",
        "INFO:D/ST",
        "X:E HWY 74 & DRIVEWAY");

    doTest("T5",
        "CAD:5413 MONROE ANSONVILLE RD;CHEST PAIN EMD;S09;B-CF2;CLARK ST;ANSONVILLE RD;01/26/2011 05:41:48",
        "ADDR:5413 MONROE ANSONVILLE RD",
        "CALL:CHEST PAIN EMD",
        "SRC:S09",
        "INFO:B-CF2",
        "X:CLARK ST & ANSONVILLE RD");

    doTest("T6",
        "CAD:101 GOODWILL LN;ANIMAL BITE ATTACKS EMD;S09;B-2;S MAIN ST;01/26/2011 09:13:28",
        "ADDR:101 GOODWILL LN",
        "CALL:ANIMAL BITE ATTACKS EMD",
        "SRC:S09",
        "INFO:B-2",
        "X:S MAIN ST");

    doTest("T7",
        "CAD:100 N STEWART ST/E HWY 74;ACCIDENT EMD;S09;B-2;01/26/2011 10:25:54",
        "ADDR:100 N STEWART ST & E HWY 74",
        "CALL:ACCIDENT EMD",
        "SRC:S09",
        "INFO:B-2");

    doTest("T8",
        "CAD:210 CAMDEN STREET EXT;PREGNANCY EMD;S09;C-3;JEROME ST;01/26/2011 11:14:34",
        "ADDR:210 CAMDEN STREET EXT",
        "CALL:PREGNANCY EMD",
        "SRC:S09",
        "INFO:C-3",
        "X:JEROME ST");

    doTest("T9",
        "CAD:1900 WEDDINGTON RD/WAXHAW HWY;VEHICLE FIRE EFD;S16;D-ST;01/26/2011 18:17:07",
        "ADDR:1900 WEDDINGTON RD & WAXHAW HWY",
        "CALL:VEHICLE FIRE EFD",
        "SRC:S16",
        "INFO:D-ST");

  }
  

  public static void main(String[] args) {
    new NCUnionCountyParserTest().generateTests("T1");
  }
}
