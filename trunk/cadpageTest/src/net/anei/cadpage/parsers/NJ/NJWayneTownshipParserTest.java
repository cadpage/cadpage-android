package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJWayneTownshipParserTest extends BaseParserTest {
  
  public NJWayneTownshipParserTest() {
    setParser(new NJWayneTownshipParser(), "WAYNE TOWNSHIP", "NJ");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "2012000006 {01/03/2012 10:58:16}\nAFCI     - Fire alarm - commercial/industrial{3}\n3 Willowbrook Mall;PD\nUnits:\n\nComments:\n  Station Dispatched : {C1 } Station Dispatched : {C2 } Units Recommended: ,;\nDispatched: {C2 }, {C1 } ZONE 3 FIRE ALARM/IDHIT/8772387739/ACWN/ADT",
        "ID:2012000006",
        "DATE:01/03/2012",
        "TIME:10:58:16",
        "CODE:AFCI",
        "CALL:Fire alarm - commercial/industrial",
        "PRI:3",
        "ADDR:3 Willowbrook Mall");

    doTest("T2",
        "2012000019 {01/04/2012 11:47:19}\nFCI      - Fire - commercial/industrial{1}\n1520 Rt23;PD\nUnits:\n\nComments:\n  Station Dispatched : {C3 } Station Dispatched : {C1 } Loc changed  \nfrom {1530 Rt23;PD} to {1520 Rt23;PD}\n\nPri from -> 5 to 1\n  Station Dispatched : {C2 } Station Dispatched : {C5 } Units Recommended: (Not able to recommend);\nDispatched: {C5 }, {C2 } Elco admin services\nRough,Jim  862 226 9566\nCaller stated her heard a popping sound inside the building and they nsmell smoke\nAddress in 1538 rt23  behing wayne Hardware Update reviewed by dispatcher- Peterson, Tracy L-716",
        "ID:2012000019",
        "DATE:01/04/2012",
        "TIME:11:47:19",
        "CODE:FCI",
        "CALL:Fire - commercial/industrial",
        "PRI:1",
        "ADDR:1520 Rt23",
        "MADDR:1520 Rt 23",
        "INFO:from {1530 Rt23;PD} to {1520 Rt23;PD}\nPri from -> 5 to 1\nRough,Jim  862 226 9566\nCaller stated her heard a popping sound inside the building and they nsmell smoke\nAddress in 1538 rt23  behing wayne Hardware Update reviewed by dispatcher- Peterson, Tracy L-716");

    doTest("T3",
        "2012000017 {01/04/2012 10:49:09}\nAFCI     - Fire alarm - commercial/industrial{3}\n520 Rt46;PD.\n  Units:\n\nComments:\n  Station Dispatched : {C1 } Station Dispatched : {C2 } Units Recommended: ,;\nDispatched: {C2 }, {C1 } Adt/877 2387739/id iub/acwn\nRed Lobster\nzone 18 ANSUL",
        "ID:2012000017",
        "DATE:01/04/2012",
        "TIME:10:49:09",
        "CODE:AFCI",
        "CALL:Fire alarm - commercial/industrial",
        "PRI:3",
        "ADDR:520 Rt46",
        "MADDR:520 Rt 46",
        "INFO:Red Lobster\nzone 18 ANSUL");

    doTest("T4",
        "2012000022 {01/04/2012 20:21:09}\nMVAE     - MVA - extrication{1}\nValley Rd/French Hill Rd;PD\nUnits:\n\nComments:\n  Station Dispatched : {R5 } Station Dispatched : {C1 } Units Recommended: ,;\nDispatched: {C1 }, {R5 } Caller states the white suv flipped over  -  \nmight be trapped inside - caller not involed - Caller states white suv  \nposs trapped States 4 veh involved - caller not involed -",
        "ID:2012000022",
        "DATE:01/04/2012",
        "TIME:20:21:09",
        "CODE:MVAE",
        "CALL:MVA - extrication",
        "PRI:1",
        "ADDR:Valley Rd & French Hill Rd",
        "INFO:might be trapped inside - caller not involed - Caller states white suv\nposs trapped States 4 veh involved - caller not involed -");

    doTest("T5",
        "2012000023 {01/05/2012 00:07:46}\nAFCI     - Fire alarm - commercial/industrial{2}\n1 Willowbrook Mall;PD \nUnits:\n\nComments:\n   Station Dispatched : {C1 } Station Dispatched : {C2 } Units Recommended: ,;\nDispatched: {C2 }, {C1 } PreEmpt - 03N\nCode 4 MaCYS COMM CENTER/8662297579/opred/acwn glass beak perimeter",
        "ID:2012000023",
        "DATE:01/05/2012",
        "TIME:00:07:46",
        "CODE:AFCI",
        "CALL:Fire alarm - commercial/industrial",
        "PRI:2",
        "ADDR:1 Willowbrook Mall",
        "INFO:Code 4 MaCYS COMM CENTER/8662297579/opred/acwn glass beak perimeter");
  }
  
  public static void main(String[] args) {
    new NJWayneTownshipParserTest().generateTests("T1");
  }
}