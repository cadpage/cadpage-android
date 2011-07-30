package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NJ.NJMICOMParser;

import org.junit.Test;


public class NJMICOMParserTest extends BaseParserTest {
  
  public NJMICOMParserTest() {
    setParser(new NJMICOMParser(), "", "NJ");
  }
  
  @Test
  public void testBergenParser() {
    
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
  
  @Test
  public void testParser2() {

    doTest("T1",
        "(CAD) S1041 RESPOND: #11-0074384 Garfield City *57 Spring St * *2 *Belmont Ave/Botany St *Unconscious/Fainting-ALS 22:01 Code:",
        "UNIT:S1041",
        "ID:11-0074384",
        "CITY:Garfield City",
        "ADDR:57 Spring St",
        "APT:2",
        "X:Belmont Ave/Botany St",
        "CALL:Unconscious/Fainting");
   
  }
  
  @Test
  public void testMorrisParser() {

    doTest("T1",
        "(CAD) T541 RESPOND: #11-0071085 Denville Twp *21 Pocono Rd *Fransiscan Oaks Health Ce*303B *Unnamed Street/Unnamed Street *Trans/Interfacility/Palliative14:05 Co",
        "UNIT:T541",
        "ID:11-0071085",
        "CITY:Denville Twp",
        "ADDR:21 Pocono Rd",
        "PLACE:Fransiscan Oaks Health Ce",
        "APT:303B",
        "X:Unnamed Street/Unnamed Street",
        "CALL:Trans/Interfacility/Palliative");
   
  }
  
  public static void main(String[] args) {
    new NJMICOMParserTest().generateTests("T1", "UNIT ID CITY ADDR PLACE APT X CALL");
  }
}