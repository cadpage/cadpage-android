package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NJ.NJBergenCountyParser;

import org.junit.Test;


public class NJBergenCountyParserTest extends BaseParserTest {
  
  public NJBergenCountyParserTest() {
    setParser(new NJBergenCountyParser(), "BERGEN COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "(CAD)  RESPOND: #10-0092 ENGLEWOOD CLIFFS BOR*580 Sylvan Ave * *SUITE B *DEMAREST AVE/UNNAMED STREET *Unknown Problem (Man Down)-BLS08:23 Code:31B01",
        "ID:10-0092",
        "CITY:ENGLEWOOD CLIFFS",
        "ADDR:580 Sylvan Ave",
        "APT:SUITE B",
        "X:DEMAREST AVE/UNNAMED STREET",
        "CALL:Unknown Problem (Man Down)");

    doTest("T2",
        "(CAD) S332 RESPOND: #10-0090603 ENGLEWOOD CITY *143 Engle St * * *E DEMAREST AVE/CHESTNUT ST *Falls-BLS 10:46 Code:17b01",
        "UNIT:S332",
        "ID:10-0090603",
        "CITY:ENGLEWOOD CITY",
        "ADDR:143 Engle St",
        "X:E DEMAREST AVE/CHESTNUT ST",
        "CALL:Falls");
    
    doTest("T3",
        "(CAD) S332 CANCEL: #10-0090603 ENGLEWOOD CITY *143 Engle St Paged:10:46 Enrte:10:48 Scene:10:54 Avail:11:33 Cxl Rsn: Refused Medical Aid Code:17b01",
        "UNIT:S332",
        "ID:10-0090603",
        "CITY:ENGLEWOOD CITY",
        "ADDR:143 Engle St",
        "CALL:CANCEL");

    doTest("T4",
        "(CAD) S2 RESPOND: #10-0092818 FORT LEE BORO *0 - 0 Bridge Plz N *WALGREENS * *LEMOINE AVE/LEMOINE AVE *Traumatic Injuries-BLS 16:01 Code:30bt1",
        "UNIT:S2",
        "ID:10-0092818",
        "CITY:FORT LEE",
        "ADDR:0 - 0 Bridge Plz N",
        "PLACE:WALGREENS",
        "X:LEMOINE AVE/LEMOINE AVE",
        "CALL:Traumatic Injuries");
  }
}