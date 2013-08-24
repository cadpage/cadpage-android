package net.anei.cadpage.parsers;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class CadpageParserTest extends BaseParserTest {
  
  public CadpageParserTest() {
    setParser(new CadpageParser(), "", "");
  }
  
  @Test
  public void testBad() {
    doBadTest("This is an Active911 test message");
  }
  
  @Test
  public void testProblems() {
    setDefaults("", "OR");
    setExpMapCode("ORBentonCounty");
    doTest("ORBentonCounty",
        "CALL:INJURY MVA\nPLACE:\nADDR:SW AIRPORT AV and DEERHAVEN DR\nDATE: 05/30/2013\nTIME: 09:24:54\nCITY:PHILOMATH\nID:053013-68\nDST:OR\nMAP:510-345\nX:BELLFOUNTAIN RD * SW AIRPORT AV\nUNIT:BENTON CO SO\nINFO:\nPARSER: ORBentonCounty\n",
        "CALL:INJURY MVA",
        "ADDR:SW AIRPORT AV and DEERHAVEN DR",
        "MADDR:SW AIRPORT AVE & DEERHAVEN DR",
        "DATE:05/30/2013",
        "TIME:09:24:54",
        "CITY:PHILOMATH",
        "ID:053013-68",
        "MAP:510-345",
        "X:BELLFOUNTAIN RD * SW AIRPORT AV",
        "UNIT:BENTON CO SO");

    
    setDefaults("", "MD");
    setExpMapCode("MDSaintMarysCounty");
    doTest("MDSaintMarysCounty",
          "CALL:Personal Injury Accident\nPLACE:A & M GLASS\nADDR:20105 POINT LOOKOUT RD\nDATE: 05/28/2013\nTIME: 21:08:39\nCITY:GREAT MILLS\nDST:MD\nX:GODDARD RD\nUNIT:CO3 ST39 ST38 CO6R\nINFO:\nPARSER: MDSaintMarysCounty", 
          "CALL:Personal Injury Accident",
          "PLACE:A & M GLASS",
          "ADDR:20105 POINT LOOKOUT RD",
          "DATE:05/28/2013",
          "TIME:21:08:39",
          "CITY:GREAT MILLS",
          "X:GODDARD RD",
          "UNIT:CO3 ST39 ST38 CO6R"); 
  }
  
  @Test
  public void testSweden() {
    
    setDefaults("", "Sdermanland");
    doTest("T1", "CALL:Sjukdomsfall / Medvetslös-vuxen\nPLACE:\nADDR:bellmansplan 1\nDATE: 03/26/2013\nTIME: 15:06:01\nCITY:Eskilstuna\nID:3521533\nDST:Sdermanland\nUNIT:D10\nCO:SE\nGPS:59.35901700, 16.50505000\nINFO:\nCO: SE\nRECGPS: Y",
         "CALL:Sjukdomsfall / Medvetslös-vuxen",
         "ADDR:bellmansplan 1",
         "DATE:03/26/2013",
         "TIME:15:06:01",
         "CITY:Eskilstuna",
         "ID:3521533",
         "UNIT:D10",
         "GPS:+59.359017,+16.505050");
    
    doTest("T2", "CALL:Trafikolycka - flera fordon / Lastbil / Övrigt\nPLACE:\nADDR:Årbyrondellen\nDATE: 03/27/2013\nTIME: 07:38:05\nCITY:Eskilstuna\nID:3523002\nDST:Sdermanland\nUNIT:D10\nCO:SE\nGPS:0.00000000, 0.00000000\nINFO:\nCO: SE\n",
        "CALL:Trafikolycka - flera fordon / Lastbil / Övrigt",
        "ADDR:Årbyrondellen",
        "DATE:03/27/2013",
        "TIME:07:38:05",
        "CITY:Eskilstuna",
        "ID:3523002",
        "UNIT:D10");
    
  }
  
  @Test
  public void testActive911() {
         
    doTest("T1", "CALL:Test Message2 (WITH GPS)\nADDR: 1517 College ST\nCITY: Philomath\nGPS: 44.5420, -123.3660\nINFO: This message has a manual GPS vocab and should result in GPS vocab\nbeing sent to Cadpage.",
         "CALL:Test Message2 (WITH GPS)",
         "ADDR:1517 College ST",
         "CITY:Philomath",
         "GPS:+44.542000,-123.366000",
         "INFO:This message has a manual GPS vocab and should result in GPS vocab\nbeing sent to Cadpage.");
    
    setDefaults("", "NY");
    doTest("T2", "CALL:2-B-1 ALLERGIC REACTION\nPLACE:\nADDR:115 RIVIERA DR\nDATE: 03/08/2013\nTIME: 14:40:56\nCITY:Mastic Beach\nID:CC13032286\nDST:NY\nX:LAKEVIEW DR AND FOREST RD E\nINFO:PRI: B / 2-B-1 UNKNOWN STATUS/OTHER CODES NOT APPLICABLE\n49 YO F-MEDICATION MACHINE INDICATING AI\n\nYou are responding to a patient with an unknown problem /man down/.\n\nThe patient is a 49-year-old female, who is conscious and breathing.\n\nStanding, sitting, moving, or talking.\n\n49 YO F-MEDICATION MACHINE INDICATING AI.\n\n1.Continue on Protocol 32.\n\nReason- MEDICATION MACHINE INDICATING AIR IN LINE 2.No special\n\ncircumstances.\n\n3.She appears to be completely awake /alert/.\n\n4.She was heard talking.\n\n5.She is lying down now.\n\n6.She is moving.\n\n7.The caller doesn't know where she is.\n\nCALL BEING VERIFIED\n\n49 YO F-MEDICATION MACHINE INDICATING AI OK #2\n\n",
        "CALL:2-B-1 ALLERGIC REACTION",
        "ADDR:115 RIVIERA DR",
        "DATE:03/08/2013",
        "TIME:14:40:56",
        "CITY:Mastic Beach",
        "ID:CC13032286",
        "X:LAKEVIEW DR AND FOREST RD E",
        "INFO:PRI: B / 2-B-1 UNKNOWN STATUS/OTHER CODES NOT APPLICABLE\n49 YO F-MEDICATION MACHINE INDICATING AI\n\nYou are responding to a patient with an unknown problem /man down/.\n\nThe patient is a 49-year-old female, who is conscious and breathing.\n\nStanding, sitting, moving, or talking.\n\n49 YO F-MEDICATION MACHINE INDICATING AI.\n\n1.Continue on Protocol 32.\n\nReason- MEDICATION MACHINE INDICATING AIR IN LINE 2.No special\n\ncircumstances.\n\n3.She appears to be completely awake /alert/.\n\n4.She was heard talking.\n\n5.She is lying down now.\n\n6.She is moving.\n\n7.The caller doesn't know where she is.\n\nCALL BEING VERIFIED\n\n49 YO F-MEDICATION MACHINE INDICATING AI OK #2");
    
    setDefaults("", "PA");
    doTest("T3", "CALL:UNCONSCIOUS\nPLACE:\nADDR:80 TROXEL RD\nDATE: 03/12/2013\nTIME: 08:57:05\nCITY:MAIDENCREEK\nDST:PA\nX:HECKTOWN RD / SHOEMAKERSVILLE RD\nUNIT:M670A\nINFO:75YOM/UNRESPONSIVE/ IS BREATHING\nSuggested city: Shoemakersville",
        "CALL:UNCONSCIOUS",
        "ADDR:80 TROXEL RD",
        "DATE:03/12/2013",
        "TIME:08:57:05",
        "CITY:MAIDENCREEK",
        "X:HECKTOWN RD / SHOEMAKERSVILLE RD",
        "UNIT:M670A",
        "INFO:75YOM/UNRESPONSIVE/ IS BREATHING\nSuggested city: Shoemakersville");
  }
  
  @Test
  public void testEverything() {
    doAllTest("PRI: 1\nDATE: 12/15/2011\nTIME: 09:12\nCALL: HELP ME\nPLACE: MY HOUSE\nADDR: 611 PINE ST\nCITY: PHILOMATH\nST: XX\nAPT: J3\nX: BLACK ST & BLUE AV\nBOX: XX77\nMAP: J75S2\nCH: OP6\nUNIT: 221\nINFO: BEHIND HOUSE\nNAME: KEN\nPH: 5551212\nCODE: 77J23\nID: 2011-001\nSRC: ST202\nGPS: +43.710000,-84.490000\nPARSER: Cadpage");
    doAllTest("PRI: 1\nDATE: 12/15/2011\nTIME: 09:12\nCALL: HELP ME\nPLACE: MY HOUSE\nADDR: 611 PINE ST\nAPT: J3\nX: BLACK ST & BLUE AV\nBOX: XX77\nMAP: J75S2\nCH: OP6\nUNIT: 221\nINFO: BEHIND HOUSE\nNAME: KEN\nPH: 5551212\nCODE: 77J23\nID: 2011-001\nSRC: ST202\nDCITY: BENTON COUNTY\nDST: OR\nCO=AU\nGPS: +43.710000,-84.490000\nREC_GPS: Y\nPARSER: Cadpage");
  }
  
  private void doAllTest(String body) {
    Message msg = new Message(false, "ken@cadpage.org", "", body);
    MsgParser parser = new CadpageParser();
    assertTrue(parser.isPageMsg(msg, 0));
    assertEquals(body, CadpageParser.formatInfo(msg.getInfo(), "\n", false));
  }
  
  @Test
  public void testSpecialFields() {
    doTest("T1", "ADDR:80 W PINE ST\nMADDR:810 N PINE ST\nPARSER:ORBadParser",
        "ADDR:80 W PINE ST",
        "MADDR:810 N PINE ST");
    
    setExpMapCode("ORBentonCounty");
    doTest("T2", "ADDR:80 W PINE ST\nMADDR:810 N PINE ST\nPARSER:ORBentonCounty",
        "ADDR:80 W PINE ST",
        "MADDR:810 N PINE ST");
  }
}