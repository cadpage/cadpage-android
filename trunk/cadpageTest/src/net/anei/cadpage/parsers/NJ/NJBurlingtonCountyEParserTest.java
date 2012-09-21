package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJBurlingtonCountyEParserTest extends BaseParserTest {
  
  public NJBurlingtonCountyEParserTest() {
    setParser(new NJBurlingtonCountyEParser(), "BURLINGTON COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "EMS E EMS Call 3690 NJTP VENUE : NJTP MALE INTOXICATED 16:01:53 05/12/2012",
        "CALL:EMS E EMS Call",
        "ADDR:3690 NJTP",
        "INFO:NJTP MALE INTOXICATED",
        "DATE:05/12/2012",
        "TIME:16:01:53");

    doTest("T2",
        "FIRE F Fire Call N CROPWELL  RD  VENUE : WASH DOWN/MVA 08:06:57 05/07/2012",
        "CALL:FIRE F Fire Call",
        "ADDR:N CROPWELL RD",
        "INFO:WASH DOWN/MVA",
        "DATE:05/07/2012",
        "TIME:08:06:57");

    doTest("T3",
        "EMS E EMS Call 422 SEDGEWICK LA VENUE : Evesham MALE SWEATY SLURRED SPEECH POSS STROKE CARDIA 08:16:51 05/23/2012",
        "CALL:EMS E EMS Call",
        "ADDR:422 SEDGEWICK LA",
        "MADDR:422 SEDGEWICK LN",
        "CITY:Evesham",
        "INFO:MALE SWEATY SLURRED SPEECH POSS STROKE CARDIA",
        "DATE:05/23/2012",
        "TIME:08:16:51");

    doTest("T4",
        "EMS E EMS Call 360 s RT73 VENUE : Evesham MALE?ALLEGRIC REACTION 12:22:28 06/04/2012",
        "CALL:EMS E EMS Call",
        "ADDR:360 s RT73",
        "MADDR:360 s RT 73",
        "CITY:Evesham",
        "INFO:MALE?ALLEGRIC REACTION",
        "DATE:06/04/2012",
        "TIME:12:22:28");

    doTest("T5",
        "117 E Falls 803 JONATHAN LA VENUE : Evesham SUBJECT FELL 00:34:25 05/16/2012",
        "CALL:117 E Falls",
        "ADDR:803 JONATHAN LA",
        "MADDR:803 JONATHAN LN",
        "CITY:Evesham",
        "INFO:SUBJECT FELL",
        "DATE:05/16/2012",
        "TIME:00:34:25");
  
  }
  
  public static void main(String[] args) {
    new NJBurlingtonCountyEParserTest().generateTests("T1", "CALL ADDR CITY INFO DATE TIME");
  }
}