package net.anei.cadpage.parsers;

import org.junit.Test;


public class NYSetauketParserTest extends BaseParserTest {
  
  public NYSetauketParserTest() {
    setParser(new NYSetauketParser(), "SETAUKET", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "AMBULANCE, CONVULSIONS / SEIZURES: 12-D-2 44 YOF SEIZURES at 43 NEAL PATH, SETAUKET   O: FAIRFIELD GABLES            TRUSS . . 19:39:51",
        "CALL:AMBULANCE, CONVULSIONS / SEIZURES",
        "ADDR:43 NEAL PATH",
        "CITY:SETAUKET",
        "MAP:12-D-2",
        "INFO:44 YOF SEIZURES");

    doTest("T2",
        "AMBULANCE, SICK PERSON (SPECIFIC DIAGNOSIS): 56 YOF SICK 26-A-5 IFO BUILDING at 5000 ROUTE 347, East Setauket  c/s: ARROWHEAD LN SOUTH   O: KOHLS . . 14:54:20",
        "CALL:AMBULANCE, SICK PERSON (SPECIFIC DIAGNOSIS)",
        "ADDR:5000 ROUTE 347",
        "CITY:East Setauket",
        "X:ARROWHEAD LN SOUTH",
        "MAP:26-A-5",
        "INFO:56 YOF SICK IFO BUILDING");
    
    doTest("T3",
        "MISC CALL, CHIEFS INVESTIGATION: GENERAL FIRE ALARM 52C04 Residential (multiple) at 700H HEALTH SCIENCES DR, STONY BROOK  c/s: NICOLLS RD   O: CHAPIN APTS - S: 26-A-16 at 20 FAWN LN W, SOUTH SETAUKET  c/s: LONGBOW LN . . 00:20:06",
        "CALL:MISC CALL, CHIEFS INVESTIGATION",
        "ADDR:700H HEALTH SCIENCES DR",
        "CITY:STONY BROOK",
        "X:NICOLLS RD",
        "INFO:GENERAL FIRE ALARM 52C04 Residential (multiple)");
        
    doTest("T4",
        "AMBULANCE, HEMORRHAGE / LACERATIONS: 21-A-1 - 61 YOM - CUT TO HAND at 8 HOLLY LN, EAST SETAUKET  c/s: CRANE NECK RD . . 16:57:21",
        "CALL:AMBULANCE, HEMORRHAGE / LACERATIONS",
        "ADDR:8 HOLLY LN",
        "CITY:EAST SETAUKET",
        "X:CRANE NECK RD",
        "MAP:21-A-1",
        "INFO:61 YOM - CUT TO HAND");
        
    doTest("T5",
        "MISC CALL WITH RESCUE, MVA: 29-B-1U - INJURIES at C/O, Setauket  c/s: WIRELESS RD . . 16:08:02",
        "CALL:MISC CALL WITH RESCUE, MVA",
        "ADDR:C/O",
        "CITY:Setauket",
        "X:WIRELESS RD",
        "MAP:29-B-1U",
        "INFO:INJURIES");
    
  }
}
