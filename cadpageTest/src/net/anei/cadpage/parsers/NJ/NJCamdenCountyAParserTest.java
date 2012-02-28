package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJCamdenCountyAParserTest extends BaseParserTest {
  
  public NJCamdenCountyAParserTest() {
    setParser(new NJCamdenCountyAParser(), "CAMDEN COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Dispatch SD45) DWELLING\n312 9TH ST ,14\n#:\nX:CENTER/CHERRY\nZN:14A\nCP:  2011-03-31 10:44:12\nMI#:110073123\nRES#:SD45",
        "CALL:DWELLING",
        "ADDR:312 9TH ST",
        "CITY:Gloucester City",
        "X:CENTER/CHERRY",
        "MAP:14A",
        "ID:110073123",
        "UNIT:SD45");

    doTest("T2",
        "(Dispatch SD45) M.V.A\nROUTE 295 SB RAMP TO 76 SB ALJO CUR ,04\n#:\nX:/\nZN:04Q\nCP:ROUTE 295 SB RAMP T  2011-03-31 09:06:36\nMI#:110073062",
        "CALL:M.V.A",
        "ADDR:ROUTE 295 SB",
        "MADDR:RAMP TO 76 SB ALJO CUR ROUTE 295 SB RAMP T,ROUTE 295",
        "CITY:Bellmawr",
        "MAP:04Q",
        "PLACE:RAMP TO 76 SB ALJO CUR ROUTE 295 SB RAMP T",
        "ID:110073062",
        "UNIT:SD45");

    doTest("T3",
        "(Dispatch SD45) DIABETIC\n217 BLACK HORSE PK N ,25\n#:4\nX:CARLISLE/LAKEVIEW\nZN:25B\nCP:MAX GROUP PHILLY CO  2011-03-30 13:23:26\nMI#:11007",
        "CALL:DIABETIC",
        "ADDR:217 BLACK HORSE PK N",
        "MADDR:217 BLACK HORSE PIKE N",
        "CITY:Mount Ephraim",
        "X:CARLISLE/LAKEVIEW",
        "MAP:25B",
        "PLACE:MAX GROUP PHILLY CO",
        "ID:11007",
        "UNIT:SD45");

    doTest("T4",
        "(Dispatch SD45) DWELLING\nBURLINGTON ST S/MONMOUTH ST ,14\n#:\nX:/\nZN:14A\nCP:  2011-03-30 10:33:28\nMI#:110072287\nRES#:SD45",
        "CALL:DWELLING",
        "ADDR:BURLINGTON ST S & MONMOUTH ST",
        "CITY:Gloucester City",
        "MAP:14A",
        "ID:110072287",
        "UNIT:SD45");
  }
  
  public static void main(String[] args) {
    new NJCamdenCountyAParserTest().generateTests("T1");
  }
}