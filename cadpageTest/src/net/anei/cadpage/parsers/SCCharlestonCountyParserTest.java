package net.anei.cadpage.parsers;

import org.junit.Test;


public class SCCharlestonCountyParserTest extends BaseParserTest {
  
  public SCCharlestonCountyParserTest() {
    setParser(new SCCharlestonCountyParser(), "CHARLESTON COUNTY", "SC");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "1110-0001587 District 03 Rescue Rescue Needed Address: Orleans Rd / Sam Rittenberg Blvd X Street:   Cmd Channel: Incident 04" ,
        "CALL:03 Rescue Rescue Needed",
        "ADDR:Orleans Rd & Sam Rittenberg Blvd",
        "ID:1110-0001587",
        "INFO:Incident 04"
        );
    doTest("T2",
        "1110-0001574 District 03 Rescue MVA Entrapment D Address: Playground Rd / Ashley River Rd X Street:   Cmd Channel: Incident 07" ,
        "CALL:03 Rescue MVA Entrapment D",
        "ADDR:Playground Rd & Ashley River Rd",
        "ID:1110-0001574",
        "INFO:Incident 07"
        );
    doTest("T3",
        "1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Chann" ,
        "CALL:04 Rescue MVA  w/Injury B",
        "ADDR:JAMES ISLAND EXPWY & FOLLY RD",
        "X:JAMES ISLAND CONNECTOR",
        "ID:1110-0001568",
        "INFO:Chann"
        );
    doTest("T4",
        "1110-0001577 District 09 Rescue Rescue Needed Address: Ashley Phosphate Rd / Stall Rd X Street:   Cmd Channel: Incident 04" ,
        "CALL:09 Rescue Rescue Needed",
        "ADDR:Ashley Phosphate Rd & Stall Rd",
        "ID:1110-0001577",
        "INFO:Incident 04"
        );
    doTest("T5",
        "1110-0001580 District 12 Rescue MVA Major Incident D Address: International Blvd / Mark Clark Expwy X Street:   Cmd Channel: Incid" ,
        "CALL:12 Rescue MVA Major Incident D",
        "ADDR:International Blvd & Mark Clark Expwy",
        "ID:1110-0001580",
        "INFO:Incid"
        );
    doTest("T6",
        "1110-0001581 District 11 A Rescue Needed Address: 2324 Andover Way X Street: PARSONAGE WOODS LN/BANCROFT LN  Cmd Channel: Incident" ,
        "CALL:11 A Rescue Needed",
        "ADDR:2324 Andover Way",
        "X:PARSONAGE WOODS LN/BANCROFT LN",
        "ID:1110-0001581",
        "INFO:Incident"
        );
    
  }
}