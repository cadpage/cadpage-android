package net.anei.cadpage.parsers;

import org.junit.Test;


public class NYHolbrookParserTest extends BaseParserTest {
  
  public NYHolbrookParserTest() {
    setParser(new NYHolbrookParser(), "HOLBROOK", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "MOTOR VEHICLE ACCIDENT . . MVA 29D4 at intersection of GREENBELT PKWY and PATCHOGUE-HOLBROOK RD. . 10:48:57",
        "CALL:MOTOR VEHICLE ACCIDENT - MVA 29D4",
        "ADDR:GREENBELT PKWY and PATCHOGUE-HOLBROOK RD");
    
    doTest("T2",
        "WIRES . . POWER CONDENSER FIRE at intersection of PATCHOGUE-HOLBROOK RD and FURROWS RD. . 07:14:36",
        "CALL:WIRES - POWER CONDENSER FIRE",
        "ADDR:PATCHOGUE-HOLBROOK RD and FURROWS RD");
    
    doTest("T3",
        "WORKING STRUCTURE FIRE at 223 SPRINGMEADOW DR. . 16:22:21",
        "CALL:WORKING STRUCTURE FIRE",
        "ADDR:223 SPRINGMEADOW DR");
        
    doTest("T4",
        "AMBULANCE CALL . . E/M RESP 6D2 at 76 LINCOLN AVE. . 17:48:14",
        "CALL:AMBULANCE CALL - E/M RESP 6D2",
        "ADDR:76 LINCOLN AVE");

    doTest("T5",
        "AMBULANCE CALL: 63 YOF RESP. 6-D-2 at 1585 CLAAS AVE, Holbrook . . 20:49:28",
        "CALL:AMBULANCE CALL: 63 YOF RESP. 6-D-2",
        "ADDR:1585 CLAAS AVE",
        "CITY:Holbrook");
    
    doTest("T6",
        "CARBON MONOXIDE ALARM: ALARM GOING OFF - NEG SYMPTOMS at 53 TIMBER RIDGE DR, Holbrook . . 22:46:56",
        "CALL:CARBON MONOXIDE ALARM: ALARM GOING OFF - NEG SYMPTOMS",
        "ADDR:53 TIMBER RIDGE DR",
        "CITY:Holbrook");

    doTest("T7",
        "FUEL SPILL: SHERIFFS ON SCENE REQUESTING at E/B SUNRISE HWY SRVC / BROADWAY AVE, HOLBROOK . . 23:06:50",
        "CALL:FUEL SPILL: SHERIFFS ON SCENE REQUESTING",
        "ADDR:E & B SUNRISE HWY SRVC & BROADWAY AVE",
        "CITY:HOLBROOK");
    
    doTest("T8",
        "CARBON MONOXIDE ALARM: CO ALARM at 53 TIMBER RIDGE DR, HOLBROOK  c/s: SPRINGMEADOW DR . . 00:15:25",
        "CALL:CARBON MONOXIDE ALARM: CO ALARM",
        "ADDR:53 TIMBER RIDGE DR",
        "CITY:HOLBROOK",
        "X:SPRINGMEADOW DR");
    
    doTest("T9",
        "MUTUAL AID - STRUCTURE FIRE at 62 POTOMAC  c/s: GRUNDY . . 15:08:02",
        "CALL:MUTUAL AID - STRUCTURE FIRE",
        "ADDR:62 POTOMAC",
        "X:GRUNDY");
    
    doTest("T10",
        "MOTOR VEHICLE ACCIDENT at LINCOLN AVE / VETERANS MEMORIAL HWY, HOLBROOK . . 12:16:23",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:LINCOLN AVE & VETERANS MEMORIAL HWY",
        "CITY:HOLBROOK");
    
    doTest("T11",
        "MISC: UNKNOWN TYPE FIRE - SOUTH END OF MUSKET DR at MUSKET DR / CANNON DR, HOLBROOK . . 20:58:10",
        "CALL:MISC: UNKNOWN TYPE FIRE - SOUTH END OF MUSKET DR",
        "ADDR:MUSKET DR & CANNON DR",
        "CITY:HOLBROOK");
    
    doTest("T12",
        "MUTUAL AID - STRUCTURE FIRE: 1 LADDER TO THE SCENE at 456 WAVERLY AVE  c/s: BUCKLEY RD . . 13:56:21",
        "CALL:MUTUAL AID - STRUCTURE FIRE: 1 LADDER TO THE SCENE",
        "ADDR:456 WAVERLY AVE",
        "X:BUCKLEY RD");
    
    doTest("T13",
        "AMBULANCE CALL: E/F FALL 17B1  at 229 SPRINGMEADOW DR #G, HOLBROOK  c/s: BEECH LN . . 08:39:55",
        "CALL:AMBULANCE CALL: E/F FALL 17B1",
        "ADDR:229 SPRINGMEADOW DR #G",
        "CITY:HOLBROOK",
        "X:BEECH LN");
    
    doTest("T14",
        "VEHICLE FIRE: CAR FIRE - MULTIPLE CALLS at 24 ANNANDALE ROAD  c/s: INVERNESS ROAD . . 06:07:57",
        "CALL:VEHICLE FIRE: CAR FIRE - MULTIPLE CALLS",
        "ADDR:24 ANNANDALE ROAD",
        "X:INVERNESS ROAD");
    
    doTest("T15",
        "Hazmat: gas pumps knocked over at 125 Crooked hill road, Brentwood  c/s: Wicks road   O: 7-11 store . . 11:29:34",
        "CALL:Hazmat: gas pumps knocked over",
        "ADDR:125 Crooked hill road",
        "CITY:Brentwood",
        "X:Wicks road",
        "PLACE:7-11 store");
  }
}