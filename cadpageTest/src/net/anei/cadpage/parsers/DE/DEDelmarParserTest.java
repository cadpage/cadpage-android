package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class DEDelmarParserTest extends BaseParserTest {
  
  public DEDelmarParserTest() {
    setParser(new DEDelmarParser(), "DELMAR", "DE");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(CAD Alert) 74AST      Call at 101 Delaware Ave              Delmar Nursing and RehabilitatCity19940      Problem Interfacillity/Palliative-ALS",
        "UNIT:74AST",
        "ADDR:101 Delaware Ave",
        "PLACE:Delmar Nursing and RehabilitatC",
        "CALL:Interfacillity/Palliative-ALS");

    doTest("T2",
        "(CAD Alert) 74AST      Call at 10411 Hearns Way                                             City19940      Problem Chest Pain-ALS",
        "UNIT:74AST",
        "ADDR:10411 Hearns Way",
        "CALL:Chest Pain-ALS");

    doTest("T3",
        "(CAD Alert) 74AST      Call at Bi State Blvd & E Grove St    74HQ                           City19940      Problem Heart Problems/ AICD-BLS",
        "UNIT:74AST",
        "ADDR:Bi State Blvd & E Grove St",
        "PLACE:74HQ",
        "CALL:Heart Problems/ AICD-BLS");

    doTest("T4",
        "(CAD Alert) 74AST      Call at Bi State Blvd & E Grove St    74HQ                           City19940      Problem Heart Problems/ AICD-BLS",
        "UNIT:74AST",
        "ADDR:Bi State Blvd & E Grove St",
        "PLACE:74HQ",
        "CALL:Heart Problems/ AICD-BLS");

    doTest("T5",
        "(CAD Alert) 74AST      Call at Holly Ct & Twelfth St         on foot                        City19940      Problem Abdominal Pain-ALS",
        "UNIT:74AST",
        "ADDR:Holly Ct & Twelfth St",
        "PLACE:on foot",
        "CALL:Abdominal Pain-ALS");

    doTest("T6",
        "(CAD Alert) 74A        Call at 38650 Sussex Hwy              Food Lion (74) at  appartments City19940      Problem Fire Nature Unknown",
        "UNIT:74A",
        "ADDR:38650 Sussex Hwy",
        "PLACE:Food Lion (74) at  appartments",
        "CALL:Fire Nature Unknown");

    doTest("T7",
        "(CAD Alert) 74AST      Call at Sussex Hwy & Trussum Pond Rd  intersection by johnny  janosikCity 19956      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Sussex Hwy & Trussum Pond Rd",
        "PLACE:intersection by johnny  janosik",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T8",
        "(CAD Alert) 74ST       Call at Sussex Hwy & Iron Hill Rd                                    City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74ST",
        "ADDR:Sussex Hwy & Iron Hill Rd",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T9",
        "(CAD Alert) 74AST      Call at Sussex Hwy & Iron Hill Rd                                    City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Sussex Hwy & Iron Hill Rd",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T10",
        "(CAD Alert) 74A        Call at Pepperbox Rd & Brittingham Rd                                City19940      Problem Wires Down/Arching",
        "UNIT:74A",
        "ADDR:Pepperbox Rd & Brittingham Rd",
        "CALL:Wires Down/Arching");

    doTest("T11",
        "(CAD Alert) 74ST       Call at Jackson Rd & Saint George Rd                                 City19940      Problem Structure Fire",
        "UNIT:74ST",
        "ADDR:Jackson Rd & Saint George Rd",
        "CALL:Structure Fire");

    doTest("T12",
        "(CAD Alert) 74AS1      Call at Jackson Rd & Saint George Rd                                 City19940      Problem Structure Fire",
        "UNIT:74AS1",
        "ADDR:Jackson Rd & Saint George Rd",
        "CALL:Structure Fire");

    doTest("T13",
        "(CAD Alert) 74AST      Call at Whitesville Rd & Sussex Hwy                                  City 19956      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Whitesville Rd & Sussex Hwy",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T14",
        "(CAD Alert) 74ST       Call at Sussex Hwy & Whitesville Rd                                  City19940      Problem Fire Nature Unknown",
        "UNIT:74ST",
        "ADDR:Sussex Hwy & Whitesville Rd",
        "CALL:Fire Nature Unknown");

    doTest("T15",
        "(CAD Alert) 74ST       Call at Connelly Mill Rd & Wood Creek                                City21875      Problem Trash Fire",
        "UNIT:74ST",
        "ADDR:Connelly Mill Rd & Wood Creek",
        "CALL:Trash Fire");

    doTest("T16",
        "(CAD Alert) 74ST       Call at Sussex Hwy & Line Rd                                         City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74ST",
        "ADDR:Sussex Hwy & Line Rd",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T17",
        "(CAD Alert) 74AST      Call at Sussex Hwy & Line Rd                                         City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Sussex Hwy & Line Rd",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T18",
        "(CAD Alert) 74B        Call at Line Rd & Rum Ridge Rd                                       City21875      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74B",
        "ADDR:Line Rd & Rum Ridge Rd",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T19",
        "(CAD Alert) 74AST      Call at Line Rd & Rum Ridge Rd                                       City21875      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Line Rd & Rum Ridge Rd",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T20",
        "(CAD Alert) 74AS2      Call at Bi State Blvd & E Grove St    74HQ                           City19940      Problem Stroke-BLS",
        "UNIT:74AS2",
        "ADDR:Bi State Blvd & E Grove St",
        "PLACE:74HQ",
        "CALL:Stroke-BLS");

    doTest("T21",
        "(CAD Alert) 74ST       Call at S 2nd St & E Walnut St                                       City21875      Problem Structure Fire",
        "UNIT:74ST",
        "ADDR:S 2nd St & E Walnut St",
        "CALL:Structure Fire");

    doTest("T22",
        "(CAD Alert) 74ST       Call at Ocean Hwy & Stage Rd                                         City21875      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74ST",
        "ADDR:Ocean Hwy & Stage Rd",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T23",
        "(CAD Alert) 74ST       Call at Rum Ridge & Williams Mill Pond                               City           Problem Traffic/TransportationAcdntBLS",
        "UNIT:74ST",
        "ADDR:Rum Ridge & Williams Mill Pond",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T24",
        "(CAD Alert) 74ST       Call at Pine St & Ocean Hwy                                          City21875      Problem Fire Nature Unknown",
        "UNIT:74ST",
        "ADDR:Pine St & Ocean Hwy",
        "CALL:Fire Nature Unknown");

    doTest("T25",
        "(CAD Alert) 74AST      Call at Bi State Blvd & Foskey Ln                                    City21875      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Bi State Blvd & Foskey Ln",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T26",
        "(CAD Alert) 74AST      Call at Line Rd & Robin Hood Rd       yellow hse                     City21875      Problem Unknown Problem(Man Down)-ALS",
        "UNIT:74AST",
        "ADDR:Line Rd & Robin Hood Rd",
        "PLACE:yellow hse",
        "CALL:Unknown Problem(Man Down)-ALS");

    doTest("T27",
        "(CAD Alert) 74AST      Call at Bi State Blvd & E State St                                   City           Problem Back Pain (Non Traumatic)-BLS",
        "UNIT:74AST",
        "ADDR:Bi State Blvd & E State St",
        "CALL:Back Pain (Non Traumatic)-BLS");

    doTest("T28",
        "(CAD Alert) 74AS1      Call at Sussex Hwy & W Snake Rd                                      City19956      Problem Traffic/TransportationAcdntALS",
        "UNIT:74AS1",
        "ADDR:Sussex Hwy & W Snake Rd",
        "CALL:Traffic/TransportationAcdntALS");

    doTest("T29",
        "(CAD Alert) 74AST      Call at Northwood Dr & Mavel Dr                                                     Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Northwood Dr & Mavel Dr",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T30",
        "(CAD Alert) 74AS1      Call at Bi State Blvd & S Bi State Blv                               City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AS1",
        "ADDR:Bi State Blvd & S Bi State Blv",
        "CALL:Traffic/TransportationAcdntBLS");
   }
  
  public static void main(String[] args) {
    new DEDelmarParserTest().generateTests("T1", "UNIT ADDR PLACE CALL");
  }
}
    		