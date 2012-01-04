package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.SC.SCCharlestonCountyParser;

import org.junit.Test;


public class SCCharlestonCountyParserTest extends BaseParserTest {
  
  public SCCharlestonCountyParserTest() {
    setParser(new SCCharlestonCountyParser(), "CHARLESTON COUNTY", "SC");
  }
  
  @Test
  public void testBad() {
    doBadTest("Dispatch Info) ANY MEMBER AVAILABLE TO ASSIST WITH THE SOCON BASEBALL TOURNAMENT TOMM CONTACT 619 AS SOON AS POSSIBLE. OPR#5");
  }
  
  @Test
  public void testAParser() {
    doTest("T1",
        "1110-0001587 District 03 Rescue Rescue Needed Address: Orleans Rd / Sam Rittenberg Blvd X Street:   Cmd Channel: Incident 04" ,
        "SRC:03",
        "CALL:Rescue Rescue Needed",
        "ADDR:Orleans Rd & Sam Rittenberg Blvd",
        "ID:1110-0001587",
        "CH:Incident 04");
    
    doTest("T2",
        "1110-0001574 District 03 Rescue MVA Entrapment D Address: Playground Rd / Ashley River Rd X Street:   Cmd Channel: Incident 07" ,
        "SRC:03",
        "CALL:Rescue MVA Entrapment D",
        "ADDR:Playground Rd & Ashley River Rd",
        "ID:1110-0001574",
        "CH:Incident 07");
    
    doTest("T3",
        "1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Chann" ,
        "SRC:04",
        "CALL:Rescue MVA  w/Injury B",
        "ADDR:JAMES ISLAND EXPWY & FOLLY RD",
        "X:JAMES ISLAND CONNECTOR",
        "ID:1110-0001568");
    
    doTest("T4",
        "1110-0001577 District 09 Rescue Rescue Needed Address: Ashley Phosphate Rd / Stall Rd X Street:   Cmd Channel: Incident 04" ,
        "SRC:09",
        "CALL:Rescue Rescue Needed",
        "ADDR:Ashley Phosphate Rd & Stall Rd",
        "ID:1110-0001577",
        "CH:Incident 04");
    
    doTest("T5",
        "1110-0001580 District 12 Rescue MVA Major Incident D Address: International Blvd / Mark Clark Expwy X Street:   Cmd Channel: Incid" ,
        "SRC:12",
        "CALL:Rescue MVA Major Incident D",
        "ADDR:International Blvd & Mark Clark Expwy",
        "ID:1110-0001580",
        "CH:Incid");
    
    doTest("T6",
        "1110-0001581 District 11 A Rescue Needed Address: 2324 Andover Way X Street: PARSONAGE WOODS LN/BANCROFT LN  Cmd Channel: Incident" ,
        "SRC:11",
        "CALL:A Rescue Needed",
        "ADDR:2324 Andover Way",
        "X:PARSONAGE WOODS LN/BANCROFT LN",
        "ID:1110-0001581",
        "CH:Incident");

    doTest("T7",
        "1110-0001582 District 01 Rescue Water Rescue Strnd Motorist  B Address: Jetty's Of Charelston Harbor X Street:  Charleston Harbor",
        "ID:1110-0001582",
        "SRC:01",
        "CALL:Rescue Water Rescue Strnd Motorist  B",
        "ADDR:Jetty's Of Charelston Harbor",
        "MADDR:Jetty's Of Charelston Harbor & Charleston Harbor",
        "X:Charleston Harbor");

    doTest("T8",
        "1110-0001589 District 11 A Entrapment Unknown B Address: HIGHWAY 41 / N HIGHWAY 17 X Street:  COSMIC DOGS HOT DOG STAND Cmd Channe",
        "ID:1110-0001589",
        "SRC:11",
        "CALL:A Entrapment Unknown B",
        "ADDR:HIGHWAY 41 & N HIGHWAY 17",
        "X:COSMIC DOGS HOT DOG STAND");

    doTest("T9",
        "1110-0001587 District 03 Rescue Rescue Needed Address: Orleans Rd / Sam Rittenberg Blvd X Street:   Cmd Channel: Incident 04",
        "ID:1110-0001587",
        "SRC:03",
        "CALL:Rescue Rescue Needed",
        "ADDR:Orleans Rd & Sam Rittenberg Blvd",
        "CH:Incident 04");

    doTest("T10",
        "1110-0001581 District 11 A Rescue Needed Address: 2324 Andover Way X Street: PARSONAGE WOODS LN/BANCROFT LN  Cmd Channel: Incident",
        "ID:1110-0001581",
        "SRC:11",
        "CALL:A Rescue Needed",
        "ADDR:2324 Andover Way",
        "X:PARSONAGE WOODS LN/BANCROFT LN",
        "CH:Incident");

    doTest("T11",
        "1110-0001562 District 02 Rescue MVA Unknown B Address: Rivers Av / Mark Clark Expwy X Street:  On Mark Clark East Bound Cmd Channel:",
        "ID:1110-0001562",
        "SRC:02",
        "CALL:Rescue MVA Unknown B",
        "ADDR:Rivers Av & Mark Clark Expwy",
        "MADDR:Rivers Ave & Mark Clark Expwy",
        "X:On Mark Clark East Bound");

    doTest("T12",
        "1110-0001564 District 03 Rescue MVA Other Hazards B Address: Ashley River Rd ...",
        "ID:1110-0001564",
        "SRC:03",
        "CALL:Rescue MVA Other Hazards B",
        "ADDR:Ashley River Rd");

    doTest("T13",
        "1110-0001564 District 03 Rescue MVA Other Hazards B Address: Ashley River Rd / Dogwood Rd X Street:  ALT# 843-327-8597 Cmd Channel:",
        "ID:1110-0001564",
        "SRC:03",
        "CALL:Rescue MVA Other Hazards B",
        "ADDR:Ashley River Rd & Dogwood Rd",
        "X:ALT# 843-327-8597");

    doTest("T14",
        "1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savanna...",
        "ID:1110-0001567",
        "SRC:03",
        "CALL:Rescue MVA Entrapment D",
        "ADDR:Wappoo Rd & Savanna");

    doTest("T15",
        "1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savannah Hwy X Street:   Cmd Channel:",
        "ID:1110-0001567",
        "SRC:03",
        "CALL:Rescue MVA Entrapment D",
        "ADDR:Wappoo Rd & Savannah Hwy");

    doTest("T16",
        "1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savanna...",
        "ID:1110-0001567",
        "SRC:03",
        "CALL:Rescue MVA Entrapment D",
        "ADDR:Wappoo Rd & Savanna");

    doTest("T17",
        "1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savannah Hwy X Street:   Cmd Channel: Incident 10",
        "ID:1110-0001567",
        "SRC:03",
        "CALL:Rescue MVA Entrapment D",
        "ADDR:Wappoo Rd & Savannah Hwy",
        "CH:Incident 10");

    doTest("T18",
        "1110-0001568 District 04 Rescue MVA w/Injury B Address: JAMES ISLAND EXPWY / ...",
        "ID:1110-0001568",
        "SRC:04",
        "CALL:Rescue MVA w/Injury B",
        "ADDR:JAMES ISLAND EXPWY");

    doTest("T19",
        "1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Channel: Incident 04",
        "ID:1110-0001568",
        "SRC:04",
        "CALL:Rescue MVA  w/Injury B",
        "ADDR:JAMES ISLAND EXPWY & FOLLY RD",
        "X:JAMES ISLAND CONNECTOR",
        "CH:Incident 04");

    doTest("T20",
        "1110-0001570 District 01 Rescue Medical Assist Bravo Response Address: 93 America St X Street: E HAMPSTEAD SQUARE/BLAKE ST  Cmd Channel:",
        "ID:1110-0001570",
        "SRC:01",
        "CALL:Rescue Medical Assist Bravo Response",
        "ADDR:93 America St",
        "X:E HAMPSTEAD SQUARE/BLAKE ST");

    doTest("T21",
        "1110-0001568 District 04 Rescue MVA w/Injury B Address: JAMES ISLAND EXPWY / ...",
        "ID:1110-0001568",
        "SRC:04",
        "CALL:Rescue MVA w/Injury B",
        "ADDR:JAMES ISLAND EXPWY");

    doTest("T22",
        "1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Channel: Incident 04",
        "ID:1110-0001568",
        "SRC:04",
        "CALL:Rescue MVA  w/Injury B",
        "ADDR:JAMES ISLAND EXPWY & FOLLY RD",
        "X:JAMES ISLAND CONNECTOR",
        "CH:Incident 04");

    doTest("T23",
        "1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Channel: Incident 04",
        "ID:1110-0001568",
        "SRC:04",
        "CALL:Rescue MVA  w/Injury B",
        "ADDR:JAMES ISLAND EXPWY & FOLLY RD",
        "X:JAMES ISLAND CONNECTOR",
        "CH:Incident 04");

    doTest("T24",
        "1110-0001570 District 01 Rescue Medical Assist Bravo Response Address: 93 America St X Street: E HAMPSTEAD SQUARE/BLAKE ST  Cmd Channel:",
        "ID:1110-0001570",
        "SRC:01",
        "CALL:Rescue Medical Assist Bravo Response",
        "ADDR:93 America St",
        "X:E HAMPSTEAD SQUARE/BLAKE ST");

    doTest("T25",
        "1211-0002346 District 09 Rescue Entrapment Unknown B Address: Dorchester Rd / Hill Blvd X Street:  IFO HUNLEY PARK Cmd Channel:  In",
        "ID:1211-0002346",
        "SRC:09",
        "ADDR:Dorchester Rd & Hill Blvd",
        "X:IFO HUNLEY PARK",
        "CH:In",
        "CALL:Rescue Entrapment Unknown B");
    
  }
  
  @Test
  public void testBParser() {

    doTest("T1",
        "Medical Assist Charlie Respons 1605 Highway 41 X Street: JOE ROUSE RD/JOE ROUSE RD Op Channel: EMS OPS",
        "CALL:Medical Assist Charlie Respons",
        "ADDR:1605 Highway 41",
        "X:JOE ROUSE RD/JOE ROUSE RD",
        "CH:EMS OPS");
    

    doTest("T2",
        "(Dispatch Info) Medical Assist Bravo Response 1717 River Rd X Street: TOBY RD/UNNAMED_298 ST Cmnd Channel: EMS OPS",
        "ADDR:1717 River Rd",
        "X:TOBY RD/UNNAMED_298 ST",
        "CH:EMS OPS",
        "CALL:Medical Assist Bravo Response");
  }
  
  public static void main(String[] args) {
    new SCCharlestonCountyParserTest().generateTests("T1");
  }
}