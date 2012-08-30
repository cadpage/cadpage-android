package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MORayCountyParserTest extends BaseParserTest {
  
  public MORayCountyParserTest() {
    setParser(new MORayCountyParser(), "RAY COUNTY", "MO");
  }
  
  @Test
  public void testLeeODell() {

    doTest("T1",
        "HIGHWAY Y RAY COUNTY CrossStreets: 10-50 TRAFFIC/TRANSPORT INCIDENT (CRASH)",
        "ADDR:HIGHWAY Y",
        "CALL:10-50 TRAFFIC/TRANSPORT INCIDENT (CRASH)");

    doTest("T2",
        "14851 HIGHWAY Y CRYSTAL LAKES CrossStreets: BEACH DR 0.09 mi N RAVENWOOD DR 0.00 mi W OUTSIDE FIRE",
        "ADDR:14851 HIGHWAY Y",
        "CITY:CRYSTAL LAKES",
        "X:BEACH DR/0.09 mi N / RAVENWOOD DR/0.00 mi W",
        "CALL:OUTSIDE FIRE");

    doTest("T3",
        "15659 HIGHWAY Y RAY COUNTY CrossStreets: PINE RD 0.07 mi N W 158TH ST 0.10 mi S OUTSIDE FIRE",
        "ADDR:15659 HIGHWAY Y",
        "X:PINE RD/0.07 mi N / W 158TH ST/0.10 mi S",
        "CALL:OUTSIDE FIRE");

    doTest("T4",
        "107 S DONNA DR RAY COUNTY CrossStreets: W DONNA DR 0.02 mi NE CAROL LN 0.05 mi S OUTSIDE FIRE",
        "ADDR:107 S DONNA DR",
        "X:W DONNA DR/0.02 mi NE / CAROL LN/0.05 mi S",
        "CALL:OUTSIDE FIRE");

    doTest("T5",
        "4364 HIGHWAY 10 RAY COUNTY CrossStreets: MOCKINGBIRD LN 0.18 mi NW LITTLE FARM RD 0.17 mi SE STROKE (CVA)",
        "ADDR:4364 HIGHWAY 10",
        "X:MOCKINGBIRD LN/0.18 mi NW / LITTLE FARM RD/0.17 mi SE",
        "CALL:STROKE (CVA)");

    doTest("T6",
        "4684 HIGHWAY 10 RAY COUNTY CrossStreets: CROWLEY RD 0.20 mi NW SHORT RD 0.30 mi SE FIRE ALARM",
        "ADDR:4684 HIGHWAY 10",
        "X:CROWLEY RD/0.20 mi NW / SHORT RD/0.30 mi SE",
        "CALL:FIRE ALARM");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[] 15659 HIGHWAY Y RAY COUNTY CrossStreets: PINE RD 0.07 mi N W 158TH ST 0.10 mi S OUTSIDE FIRE\r\n\r\n\r\n\r\n\r\n\r\n",
        "ADDR:15659 HIGHWAY Y",
        "X:PINE RD/0.07 mi N / W 158TH ST/0.10 mi S",
        "CALL:OUTSIDE FIRE");

    doTest("T2",
        "[] 14851 HIGHWAY Y CRYSTAL LAKES CrossStreets: BEACH DR 0.09 mi N RAVENWOOD DR 0.00 mi W OUTSIDE FIRE\r\n\r\n\r\n\r\n\r\n\r\n",
        "ADDR:14851 HIGHWAY Y",
        "CITY:CRYSTAL LAKES",
        "X:BEACH DR/0.09 mi N / RAVENWOOD DR/0.00 mi W",
        "CALL:OUTSIDE FIRE");

    doTest("T3",
        "[] HIGHWAY Y RAY COUNTY CrossStreets: 10-50 TRAFFIC/TRANSPORT INCIDENT (CRASH)\r\n\r\n\r\n\r\n\r\n\r\n",
        "ADDR:HIGHWAY Y",
        "CALL:10-50 TRAFFIC/TRANSPORT INCIDENT (CRASH)");

    doTest("T4",
        "[] HIGHWAY 10 & W 133RD ST RAY COUNTY CrossStreets: OUTSIDE FIRE\r\n\r\n\r\n\r\n\r\n\r\n",
        "ADDR:HIGHWAY 10 & W 133RD ST",
        "CALL:OUTSIDE FIRE");

    doTest("T5",
        "[] 18347 N UNION RD RAY COUNTY CrossStreets: HIGHWAY C 0.40 mi S MUTUAL AID/ASSIST OUTSIDE AGENCIES\r\n\r\n\r\n\r\n\r\n\r\n",
        "ADDR:18347 N UNION RD",
        "X:HIGHWAY C/0.40 mi S",
        "CALL:MUTUAL AID/ASSIST OUTSIDE AGENCIES");

  }

  public static void main(String[] args) {
    new MORayCountyParserTest().generateTests("T1", "ADDR APT CITY X CALL");
  }
}
