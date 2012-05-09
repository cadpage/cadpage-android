package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYClintonCountyParserTest extends BaseParserTest {
  
  public NYClintonCountyParserTest() {
    setParser(new NYClintonCountyParser(), "CLINTON COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        ".... (Keeseville) Time: May 02, 2012 11:59:43\n" +
        "AgencyName: Keeseville EMS\n" +
        "Address: 89 Second St, CHESTERFIELD (WASHINGTON ST/LUMBER ST)\n" +
        "Resp.Type: 001Ambulance\n" +
        "Priority: Priority 1",

        "DATE:05/02/2012",
        "TIME:11:59:43",
        "SRC:Keeseville EMS",
        "ADDR:89 Second St",
        "CITY:CHESTERFIELD",
        "X:WASHINGTON ST/LUMBER ST",
        "CALL:001Ambulance",
        "PRI:1");

    doTest("T2",
        ".... (Keeseville) Time: May 01, 2012 19:26:16\n" +
        "AgencyName: Keeseville EMS\n" +
        "Address: 164 HILL ST, AUSABLE (TAYLOR HILL RD, HALLOCK HILL RD/87)\n" +
        "Resp.Type: 001Ambulance\n" +
        "Priority: Priority 1",

        "DATE:05/01/2012",
        "TIME:19:26:16",
        "SRC:Keeseville EMS",
        "ADDR:164 HILL ST",
        "CITY:AUSABLE",
        "X:TAYLOR HILL RD, HALLOCK HILL RD/87",
        "CALL:001Ambulance",
        "PRI:1");

    doTest("T3",
        ".... (Keeseville) Time: April 30, 2012 18:54:04\n" +
        "AgencyName: Keeseville EMS\n" +
        "Address: 73 Clinton St, KEESEVILLE VILLAGE (CHESTERFIELD) (DIVISION ST/CHURCH ST)\n" +
        "Resp.Type: 24B02-Unknown status/Other codes not applicable\n" +
        "Priority:",

        "DATE:04/30/2012",
        "TIME:18:54:04",
        "SRC:Keeseville EMS",
        "ADDR:73 Clinton St",
        "CITY:KEESEVILLE VILLAGE",
        "X:DIVISION ST/CHURCH ST",
        "CALL:24B02-Unknown status/Other codes not applicable");

    doTest("T4",
        ".... (Keeseville) Time: April 30, 2012 17:49:11\n" +
        "AgencyName: Keeseville\n" +
        "Address: 80 PLEASANT ST, KEESEVILLE VILLAGE (AUSABLE) (LIBERTY ST/MAIN ST)\n" +
        "Resp.Type: 003-Chimney Fire\n" +
        "Priority: Priority 1",

        "DATE:04/30/2012",
        "TIME:17:49:11",
        "SRC:Keeseville",
        "ADDR:80 PLEASANT ST",
        "CITY:KEESEVILLE VILLAGE",
        "X:LIBERTY ST/MAIN ST",
        "CALL:003-Chimney Fire",
        "PRI:1");

  }
  
  public static void main(String[] args) {
    new NYClintonCountyParserTest().generateTests("T1");
  }
}