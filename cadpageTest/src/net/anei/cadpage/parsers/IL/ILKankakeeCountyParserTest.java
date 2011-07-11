package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class ILKankakeeCountyParserTest extends BaseParserTest {
  
  public ILKankakeeCountyParserTest() {
    setParser(new ILKankakeeCountyParser(), "KANKAKEE COUNTY", "IL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[NWS Message]  ALARM:FIRE Location: KANKAKEE TERRACE 100 BELLE AIRE AVE Bourbonnais 05/27/11 05:29 Incident #: 2011-00001016",
        "CALL:ALARM:FIRE",
        "PLACE:KANKAKEE TERRACE",
        "ADDR:100 BELLE AIRE AVE",
        "CITY:Bourbonnais",
        "ID:2011-00001016");

    doTest("T2",
        "[NWS Message]  SMOKE/ODOR Location: COURT STREET FORD 558 WILLIAM LATHAM DR Bourbonnais 05/09/11 15:57 Incident #: 2011-00000889",
        "CALL:SMOKE/ODOR",
        "PLACE:COURT STREET FORD",
        "ADDR:558 WILLIAM LATHAM DR",
        "CITY:Bourbonnais",
        "ID:2011-00000889");

    doTest("T3",
        "[NWS Message]  WIRES DOWN Location: 968 N 2750E RD Kankakee 05/30/11 11:09 Incident #: 2011-00000111",
        "CALL:WIRES DOWN",
        "ADDR:968 N 2750E RD",
        "CITY:Kankakee",
        "ID:2011-00000111");

    doTest("T4",
        "[NWS Message]  AMB:MUTUAL AID Location: 4552/3400N RD 06/01/11 14:00 Incident #: 2011-00000113",
        "CALL:AMB:MUTUAL AID",
        "ADDR:4552 3400N RD",
        "ID:2011-00000113");

    doTest("T5",
        "[NWS Message]  AMBULANCE Location: 55 SAINT FRANCIS DR Bourbonnais 06/01/11 12:38 Incident #: 2011-00001056",
        "CALL:AMBULANCE",
        "ADDR:55 SAINT FRANCIS DR",
        "CITY:Bourbonnais",
        "ID:2011-00001056");

    doTest("T6",
        "[NWS Message] AMBULANCE Location: 1355 N  ARTHUR BURCH DR F11 Bourbonnais 06/03/11 14:32 Incident #: 2011-00001066",
        "CALL:AMBULANCE",
        "ADDR:1355 N ARTHUR BURCH DR F11",
        "CITY:Bourbonnais",
        "ID:2011-00001066");

    doTest("T7",
        "[NWS Message]  AMBULANCE Location: 874 EDWIN DR Bourbonnais 06/01/11 14:24 Incident #: 2011-00004870",
        "CALL:AMBULANCE",
        "ADDR:874 EDWIN DR",
        "CITY:Bourbonnais",
        "ID:2011-00004870");
    
  }
  
  public static void main(String[] args) {
    new ILKankakeeCountyParserTest().generateTests("T1","CALL PLACE ADDR CITY ID");
  }
}