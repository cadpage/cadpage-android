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
        "PLACE:Delmar Nursing and Rehabilitat",
        "CITY:19940",
        "CALL:Interfacillity/Palliative-ALS");

    doTest("T2",
        "(CAD Alert) 74AST      Call at 10411 Hearns Way                                             City19940      Problem Chest Pain-ALS",
        "UNIT:74AST",
        "ADDR:10411 Hearns Way",
        "CITY:19940",
        "CALL:Chest Pain-ALS");

    doTest("T3",
        "(CAD Alert) 74AST      Call at Bi State Blvd & E Grove St    74HQ                           City19940      Problem Heart Problems/ AICD-BLS",
        "UNIT:74AST",
        "ADDR:Bi State Blvd & E Grove St",
        "PLACE:74HQ",
        "CITY:19940",
        "CALL:Heart Problems/ AICD-BLS");

    doTest("T4",
        "(CAD Alert) 74AST      Call at Bi State Blvd & E Grove St    74HQ                           City19940      Problem Heart Problems/ AICD-BLS",
        "UNIT:74AST",
        "ADDR:Bi State Blvd & E Grove St",
        "PLACE:74HQ",
        "CITY:19940",
        "CALL:Heart Problems/ AICD-BLS");

    doTest("T5",
        "(CAD Alert) 74AST      Call at Holly Ct & Twelfth St         on foot                        City19940      Problem Abdominal Pain-ALS",
        "UNIT:74AST",
        "ADDR:Holly Ct & Twelfth St",
        "PLACE:on foot",
        "CITY:19940",
        "CALL:Abdominal Pain-ALS");

    doTest("T6",
        "(CAD Alert) 74A        Call at 38650 Sussex Hwy              Food Lion (74) at  appartments City19940      Problem Fire Nature Unknown",
        "UNIT:74A",
        "ADDR:38650 Sussex Hwy",
        "PLACE:Food Lion (74) at  appartments",
        "CITY:19940",
        "CALL:Fire Nature Unknown");

    doTest("T7",
        "(CAD Alert) 74AST      Call at Sussex Hwy & Trussum Pond Rd  intersection by johnny  janosikCity 19956      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Sussex Hwy & Trussum Pond Rd",
        "PLACE:intersection by johnny  janosik",
        "CITY:19956",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T8",
        "(CAD Alert) 74ST       Call at Sussex Hwy & Iron Hill Rd                                    City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74ST",
        "ADDR:Sussex Hwy & Iron Hill Rd",
        "CITY:19940",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T9",
        "(CAD Alert) 74AST      Call at Sussex Hwy & Iron Hill Rd                                    City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Sussex Hwy & Iron Hill Rd",
        "CITY:19940",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T10",
        "(CAD Alert) 74A        Call at Pepperbox Rd & Brittingham Rd                                City19940      Problem Wires Down/Arching         ",
        "UNIT:74A",
        "ADDR:Pepperbox Rd & Brittingham Rd",
        "CITY:19940",
        "CALL:Wires Down/Arching");

    doTest("T11",
        "(CAD Alert) 74ST       Call at Jackson Rd & Saint George Rd                                 City19940      Problem Structure Fire ",
        "UNIT:74ST",
        "ADDR:Jackson Rd & Saint George Rd",
        "CITY:19940",
        "CALL:Structure Fire");

    doTest("T12",
        "(CAD Alert) 74AS1      Call at Jackson Rd & Saint George Rd                                 City19940      Problem Structure Fire",
        "UNIT:74AS1",
        "ADDR:Jackson Rd & Saint George Rd",
        "CITY:19940",
        "CALL:Structure Fire");

    doTest("T13",
        "(CAD Alert) 74AST      Call at Whitesville Rd & Sussex Hwy                                  City 19956      Problem Traffic/TransportationAcdntBLS       ",
        "UNIT:74AST",
        "ADDR:Whitesville Rd & Sussex Hwy",
        "CITY:19956",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T14",
        "(CAD Alert) 74ST       Call at Sussex Hwy & Whitesville Rd                                  City19940      Problem Fire Nature Unknown",
        "UNIT:74ST",
        "ADDR:Sussex Hwy & Whitesville Rd",
        "CITY:19940",
        "CALL:Fire Nature Unknown");

    doTest("T15",
        "(CAD Alert) 74ST       Call at Connelly Mill Rd & Wood Creek                                City21875      Problem Trash Fire",
        "UNIT:74ST",
        "ADDR:Connelly Mill Rd & Wood Creek",
        "CITY:21875",
        "CALL:Trash Fire");

    doTest("T16",
        "(CAD Alert) 74ST       Call at Sussex Hwy & Line Rd                                         City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74ST",
        "ADDR:Sussex Hwy & Line Rd",
        "CITY:19940",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T17",
        "(CAD Alert) 74AST      Call at Sussex Hwy & Line Rd                                         City19940      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Sussex Hwy & Line Rd",
        "CITY:19940",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T18",
        "(CAD Alert) 74B        Call at Line Rd & Rum Ridge Rd                                       City21875      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74B",
        "ADDR:Line Rd & Rum Ridge Rd",
        "CITY:21875",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T19",
        "(CAD Alert) 74AST      Call at Line Rd & Rum Ridge Rd                                       City21875      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Line Rd & Rum Ridge Rd",
        "CITY:21875",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T20",
        "(CAD Alert) 74AS2      Call at Bi State Blvd & E Grove St    74HQ                           City19940      Problem Stroke-BLS",
        "UNIT:74AS2",
        "ADDR:Bi State Blvd & E Grove St",
        "PLACE:74HQ",
        "CITY:19940",
        "CALL:Stroke-BLS");

    doTest("T21",
        "(CAD Alert) 74ST       Call at S 2nd St & E Walnut St                                       City21875      Problem Structure Fire",
        "UNIT:74ST",
        "ADDR:S 2nd St & E Walnut St",
        "CITY:21875",
        "CALL:Structure Fire");

    doTest("T22",
        "(CAD Alert) 74ST       Call at Ocean Hwy & Stage Rd                                         City21875      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74ST",
        "ADDR:Ocean Hwy & Stage Rd",
        "CITY:21875",
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
        "CITY:21875",
        "CALL:Fire Nature Unknown");

    doTest("T25",
        "(CAD Alert) 74AST      Call at Bi State Blvd & Foskey Ln                                    City21875      Problem Traffic/TransportationAcdntBLS",
        "UNIT:74AST",
        "ADDR:Bi State Blvd & Foskey Ln",
        "CITY:21875",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T26",
        "(CAD Alert) 74AST      Call at Line Rd & Robin Hood Rd       yellow hse                     City21875      Problem Unknown Problem(Man Down)-ALS",
        "UNIT:74AST",
        "ADDR:Line Rd & Robin Hood Rd",
        "PLACE:yellow hse",
        "CITY:21875",
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
        "CITY:19956",
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
        "MADDR:Bi State Blvd & S Bi State Blvd",
        "CITY:19940",
        "CALL:Traffic/TransportationAcdntBLS");
   }
  
  @Test
  public void testMillsboro() {

    doTest("T1",
        "(CAD Alert) 82B        Call at 11 Hartford Way                                             City19958      Problem Gas Leak",
        "UNIT:82B",
        "ADDR:11 Hartford Way",
        "CITY:19958",
        "CALL:Gas Leak");

    doTest("T2",
        "(CAD Alert) 80ST       Call at 26002 John J Williams Hwy     Renaissance Nursing rm 114 / rCity19966      Problem Interfacillity/Palliative-ALS",
        "UNIT:80ST",
        "ADDR:26002 John J Williams Hwy",
        "PLACE:Renaissance Nursing rm 114 / r",
        "CITY:19966",
        "CALL:Interfacillity/Palliative-ALS");

    doTest("T3",
        "(CAD Alert) 82B        Call at Robinsonville Rd & Seashell Bl                              City19958      Problem Traffic/TransportationAcdntBLS",
        "UNIT:82B",
        "ADDR:Robinsonville Rd & Seashell Bl",
        "CITY:19958",
        "CALL:Traffic/TransportationAcdntBLS");

    doTest("T4",
        "(CAD Alert) 821        Call at 20415 Beaver Dam Rd                                         City19951      Problem Unconscious/Fainting(Near)-ALS",
        "UNIT:821",
        "ADDR:20415 Beaver Dam Rd",
        "CITY:19951",
        "CALL:Unconscious/Fainting(Near)-ALS");

    doTest("T5",
        "(CAD Alert) 821        Call at 25877 Prince St                                             City19966      Problem Sick Person(Specific Diag)-ALS",
        "UNIT:821",
        "ADDR:25877 Prince St",
        "CITY:19966",
        "CALL:Sick Person(Specific Diag)-ALS");

    doTest("T6",
        "(CAD Alert) 821        Call at 30971 Buttonwood Dr                                         City19958      Problem Sick Person(Specific Diag)-BLS",
        "UNIT:821",
        "ADDR:30971 Buttonwood Dr",
        "CITY:19958",
        "CALL:Sick Person(Specific Diag)-BLS");
  }
  
  public static void main(String[] args) {
    new DEDelmarParserTest().generateTests("T1", "UNIT ADDR PLACE CITY CALL");
  }
}
    		