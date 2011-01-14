package net.anei.cadpage.parsers;

import org.junit.Before;
import org.junit.Test;


public class NYSuffolkCountyAllParserTest extends BaseParserTest {
  
  public NYSuffolkCountyAllParserTest() {
    setParser(new NYSuffolkCountyAllParser(), "SUFFOLK COUNTY", "NY");
  }
  
  @Before
  public void setup() {
    setDefaults("SUFFOLK COUNTY", "NY");
  }
  
  @Test
  public void testAParser() {
    doTest("T1",
        "TYPE: GAS LEAKS / GAS ODOR (NATURAL / L.P.G.) LOC: 11 BRENTWOOD PKWY BRENTW HOMELESS SHELTER CROSS: PENNSYLVANIA AV / SUFFOLK AV CODE: 60-B-2 TIME: 12:54:16",
        "CALL:GAS LEAKS / GAS ODOR (NATURAL / L.P.G.)",
        "PLACE:HOMELESS SHELTER",
        "ADDR:11 BRENTWOOD PKWY",
        "CITY:Brentwood",
        "X:PENNSYLVANIA AV / SUFFOLK AV",
        "CODE:60-B-2");
  }
  
  @Test
  public void testBParser() {
    doTest("T1",
        "*** 13 - Structure Fire *** 147 CHERUBINA LN CS: LEADER AVE  / SKIDMORE RD TOA: 22:37 09/22/10 OIL BURNER NORTH BABYLON FC 2010-002398 HY: 8' 11",
        "CALL:13 - Structure Fire",
        "ADDR:147 CHERUBINA LN",
        "X:LEADER AVE  / SKIDMORE RD",
        "INFO:OIL BURNER",
        "SRC:NORTH BABYLON FC",
        "ID:2010-002398");
  }
  
  @Test
  public void testHolbrookParser() {
    doTest("T1",
        "MOTOR VEHICLE ACCIDENT . . MVA 29D4 at intersection of GREENBELT PKWY and PATCHOGUE-HOLBROOK RD. . 10:48:57",
        "CALL:MOTOR VEHICLE ACCIDENT - MVA 29D4",
        "ADDR:GREENBELT PKWY and PATCHOGUE-HOLBROOK RD");
  }
  
  @Test
  public void testFarmingdaleParser() {
    doTest("T1",
        "Signal 9 . . Stroke (CVA) at 64 DOUD ST. . 11:31:21",
        "CALL:Signal 9 - Stroke (CVA)",
        "ADDR:64 DOUD ST");
  }
  
  @Test
  public void testSetauketParser() {
    doTest("T1",
        "AMBULANCE, CONVULSIONS / SEIZURES: 12-D-2 44 YOF SEIZURES at 43 NEAL PATH, SETAUKET   O: FAIRFIELD GABLES            TRUSS . . 19:39:51",
        "CALL:AMBULANCE, CONVULSIONS / SEIZURES",
        "ADDR:43 NEAL PATH",
        "CITY:SETAUKET",
        "PLACE:FAIRFIELD GABLES TRUSS",
        "CODE:12-D-2",
        "INFO:44 YOF SEIZURES");
  }
  
  @Test
  public void testRockyPointParser() {
    doTest("T1",
        "Automatic Alarm, Residential at 38 CHERYL DR, SHOREHAM  c/s: COBBLESTONE DR . . 08:23:03",
        "CALL:Automatic Alarm, Residential",
        "ADDR:38 CHERYL DR",
        "CITY:SHOREHAM",
        "X:COBBLESTONE DR");
  }
  
  @Test
  public void testSouthamptonParser() {
    doTest("T1",
        "ALARM - GENERAL at 64 COUNTY RD 39, SOUTHAMPTON  c/s: NORTH SEA RD   O: HAMPTONS CENTER FOR REHAB . . 11:09:34",
        "CALL:ALARM - GENERAL",
        "ADDR:64 COUNTY RD 39",
        "CITY:SOUTHAMPTON",
        "X:NORTH SEA RD",
        "PLACE:HAMPTONS CENTER FOR REHAB");
  }
  
  
  @Test
  public void testBelmoreParser() {
    doTest("T1",
        "RESCUE at 2438 BEDFORD PLACE. . 11:34:04",
        "CALL:RESCUE",
        "ADDR:2438 BEDFORD PLACE");
 }
  
  @Test
  public void testDixHillsParser() {
    setDefaults("DIX HILLS", "NY");
    doTest("T1",
        "2010-001784 23:36 *** 16- Rescue *** 17 BRYCEWOOD DR SPIEGEL, LORI A Dix Hills HQ ARISTA DR 31-A-1 UNCONSCIOUS / FAINTING (NEAR) CEWOOD DR DIXHIL TYPE:",
        "ID:2010-001784",
        "CALL:16- Rescue",
        "ADDR:17 BRYCEWOOD DR");
  }
  
  @Test
  public void testParser() {
    setDefaults("AMHERST", "NY");
    doTest("T1",
        "CLA 10990 Keller Rd. EMS 80M slurred speech",
        "CALL:EMS 80M slurred speech",
        "ADDR:10990 Keller Rd"
        );
  }
}