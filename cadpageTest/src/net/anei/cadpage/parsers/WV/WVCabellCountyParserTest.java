package net.anei.cadpage.parsers.WV;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class WVCabellCountyParserTest extends BaseParserTest {
  
  public WVCabellCountyParserTest() {
    setParser(new WVCabellCountyParser(), "CABELL COUNTY", "WV");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "1 of 2\nFRM:dispatch@ccerc911.org\nSUBJ:(22225) CCERC911\nMSG:113030126/10-30-11/06:42:08/Other Fire/8160 FRAZIERS LN/LESAGE/LORENA LN/KATHI\n(Con't) 2 of 2\nLN/50YF/BLEEDING FROM A SURGICAL WOUND IN STOMACH//(End)",
        "ID:113030126",
        "DATE:10-30-11",
        "TIME:06:42:08",
        "CALL:Other Fire",
        "ADDR:8160 FRAZIERS LN",
        "CITY:LESAGE",
        "X:LORENA LN & KATHI LN",
        "INFO:50YF / BLEEDING FROM A SURGICAL WOUND IN STOMACH");

    doTest("T2",
        "1 of 2\nFRM:dispatch@ccerc911.org\nSUBJ:(22343) CCERC911\nMSG:113030199/10-30-11/14:16:29/Structure Fire/6419 RT 60/BARBOURSVILLE/GEORGES DRY\n(Con't) 2 of 2\nCLEANERS/FARMDALE RD/MAIN ST/201 231 ENRT/237/(End)",
        "ID:113030199",
        "DATE:10-30-11",
        "TIME:14:16:29",
        "CALL:Structure Fire",
        "ADDR:6419 RT 60",
        "CITY:BARBOURSVILLE",
        "PLACE:GEORGES DRY CLEANERS",
        "X:FARMDALE RD & MAIN ST",
        "INFO:201 231 ENRT / 237");

    doTest("T3",
        "1 of 2\nFRM:dispatch@ccerc911.org\nSUBJ:(22412) CCERC911\nMSG:113030260/10-30-11/16:53:24/Abdominal Pain/6430 OHIO RIVER RD APT1/LESAGE/TAN\n(Con't) 2 of 2\nZONE/DOUTHAT LN/NINE MILE RD/22YR FEMALE/27WKS PREGNANT/(End)",
        "ID:113030260",
        "DATE:10-30-11",
        "TIME:16:53:24",
        "CALL:Abdominal Pain",
        "ADDR:6430 OHIO RIVER RD",
        "APT:APT1",
        "CITY:LESAGE",
        "PLACE:TAN ZONE",
        "X:DOUTHAT LN & NINE MILE RD",
        "INFO:22YR FEMALE / 27WKS PREGNANT");

    doTest("T4",
        "1 of 2\nFRM:dispatch@ccerc911.org\nSUBJ:(22719) CCERC911\nMSG:113040332/10-31-11/20:53:50/MVA Inj./4805 HILLVIEW DR/HUNTINGTON/OHIO RIVER\n(Con't) 2 of 2\nRD/END/ONE VEH OVER THE HILL/ ADV ABOUT 50 YARD OVER A HILL/(End)",
        "ID:113040332",
        "DATE:10-31-11",
        "TIME:20:53:50",
        "CALL:MVA Inj.",
        "ADDR:4805 HILLVIEW DR",
        "CITY:HUNTINGTON",
        "X:OHIO RIVER RD & END",
        "INFO:ONE VEH OVER THE HILL / ADV ABOUT 50 YARD OVER A HILL");

    doTest("T5",
        "1 of 2\nFRM:dispatch@ccerc911.org\nSUBJ:(22809) CCERC911\nMSG:113050042/11-01-11/05:35:54/MVA Inj./5315 OHIO RIVER RD BLK/HUNTINGTON/THREE MILE\n(Con't) 2 of 2\nCREEK RD/MOBILE CITY RD/TRACTOR TRAILOR / TRUCK IS ON THE TRACKS/(End)",
        "ID:113050042",
        "DATE:11-01-11",
        "TIME:05:35:54",
        "CALL:MVA Inj.",
        "ADDR:5315 OHIO RIVER RD BLK",
        "CITY:HUNTINGTON",
        "X:THREE MILE CREEK RD & MOBILE CITY RD",
        "INFO:TRACTOR TRAILOR / TRUCK IS ON THE TRACKS");
    
  }
  
  public static void main(String[] args) {
    new WVCabellCountyParserTest().generateTests("T1");
  }
}