package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCWataugaCountyParserTest extends BaseParserTest {
  
  public NCWataugaCountyParserTest() {
    setParser(new NCWataugaCountyParser(), "WATAUGA COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "HOWARDS CREEK RD / SUGARLOAF RD FDL 71B01 2011013987 16:02:05 VEHICLE FIRE 421N-RT TATER HILL RD-LT HOWARDS CREEK RD TO SUGARLOAF RD",
        "ADDR:HOWARDS CREEK RD & SUGARLOAF RD",
        "CODE:71B01",
        "ID:2011013987",
        "CALL:VEHICLE FIRE 421N",
        "X:RT TATER HILL RD",
        "INFO:LT HOWARDS CREEK RD TO SUGARLOAF RD");

    doTest("T2",
        "524 JONES DR BOONE MDL 01A01 2011013875 02:10:09 ABDOMINAL PAIN 194S-CHESTNUT GRV RD-LT COBBS CREEK RD-1ST RT JONES DR",
        "ADDR:524 JONES DR",
        "CITY:BOONE",
        "CODE:01A01",
        "ID:2011013875",
        "CALL:ABDOMINAL PAIN 194S",
        "X:CHESTNUT GRV RD / LT COBBS CREEK RD / 1ST RT JONES DR");

    doTest("T3",
        "131 BIG VALLEY ST BOONE 2011013813 13:15:57 STRUCTURE FIRE 321S-LT DEERFIELD RD-TRAVEL 2.0 MI-RT BIG VALLEY ST INTO DEERFIELD MEADOWS BUSINESS PARK",
        "ADDR:131 BIG VALLEY ST",
        "CITY:BOONE",
        "ID:2011013813",
        "CALL:STRUCTURE FIRE 321S",
        "X:LT DEERFIELD RD",
        "INFO:TRAVEL 2.0 MI / RT BIG VALLEY ST INTO DEERFIELD MEADOWS BUSINESS PARK");

    doTest("T4",
        "200 QUAIL ST BOONE 2011013939 03:11:32 STANDBY",
        "ADDR:200 QUAIL ST",
        "CITY:BOONE",
        "ID:2011013939",
        "CALL:STANDBY");

    doTest("T5",
        "853 HIDDEN VALLEY DR BOONE MDL 09E01 2011013997 20:13:36 ARREST-ADULT 105S-BESIDE HIDDEN VALLEY MOTEL-LT HIDDEN VALLEY DR",
        "ADDR:853 HIDDEN VALLEY DR",
        "CITY:BOONE",
        "CODE:09E01",
        "ID:2011013997",
        "CALL:ARREST",
        "X:LT HIDDEN VALLEY DR",
        "INFO:ADULT 105S / BESIDE HIDDEN VALLEY MOTEL");

 }
  

  public static void main(String[] args) {
    new NCWataugaCountyParserTest().generateTests("T1", "ADDR CITY CODE ID CALL X INFO");
  }
}
