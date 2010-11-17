package net.anei.cadpage.parsers;

import org.junit.Test;


public class NYBrentwoodParserTest extends BaseParserTest {
  
  public NYBrentwoodParserTest() {
    setParser(new NYBrentwoodParser(), "SUFFOLK COUNTY", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "TYPE: GAS LEAKS / GAS ODOR (NATURAL / L.P.G.) LOC: 11 BRENTWOOD PKWY BRENTW HOMELESS SHELTER CROSS: PENNSYLVANIA AV / SUFFOLK AV CODE: 60-B-2 TIME: 12:54:16",
        "CALL:GAS LEAKS / GAS ODOR (NATURAL / L.P.G.)",
        "PLACE:HOMELESS SHELTER",
        "ADDR:11 BRENTWOOD PKWY",
        "CITY:Brentwood",
        "X:PENNSYLVANIA AV / SUFFOLK AV",
        "MAP:60-B-2");
    
    doTest("T2",
        "TYPE: STRUCTURE FIRE LOC: 81 NEW HAMPSHIRE AV NBAYSH  CROSS: E FORKS RD / E 3 AV CODE: 69-D-10 TIME: 16:36:48",
        "CALL:STRUCTURE FIRE",
        "ADDR:81 NEW HAMPSHIRE AV",
        "X:E FORKS RD / E 3 AV",
        "CITY:Bay Shore",
        "MAP:69-D-10");
    
    doTest("T3",
        "TYPE: OPEN BURNING LOC: 65 GRANT AVE BRENTW CROSS: SUFFOLK AVE CODE: 54-C-6 TIME: 18:39:20",
        "CALL:OPEN BURNING",
        "ADDR:65 GRANT AVE",
        "X:SUFFOLK AVE",
        "CITY:Brentwood",
        "MAP:54-C-6");
 
    doTest("T4",
        "TYPE: PREGNANCY / CHILDBIRTH / MISCARRIAGE LOC: 330 MOTOR PKWY HAUPPA:@FELDMAN, KRAMER & MONACO STE 400  CROSS: WASHINGTON AV / MARCUS BLVD C",
        "CALL:PREGNANCY / CHILDBIRTH / MISCARRIAGE",
        "PLACE:FELDMAN, KRAMER & MONACO STE 400",
        "ADDR:330 MOTOR PKWY",
        "X:WASHINGTON AV / MARCUS BLVD C",
        "CITY:Hauppauge");

    doTest("T5",
        "TYPE: PSYCHIATRIC / ABNORMAL BEHAVIOR / SUICIDE LOC: 200 WIRELESS BLVD HAUPPA: @SOCIAL SERVICES HAUPPAUGE INTERVIEW AREA CROSS: MORELAND RD /",
        "CALL:PSYCHIATRIC / ABNORMAL BEHAVIOR / SUICIDE",
        "PLACE:SOCIAL SERVICES HAUPPAUGE INTERVIEW AREA",
        "ADDR:200 WIRELESS BLVD",
        "X:MORELAND RD /",
        "CITY:Hauppauge");


  }
}
