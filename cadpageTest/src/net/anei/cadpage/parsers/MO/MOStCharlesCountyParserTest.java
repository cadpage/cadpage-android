package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOStCharlesCountyParserTest extends BaseParserTest {
  
  public MOStCharlesCountyParserTest() {
    setParser(new MOStCharlesCountyParser(), "ST CHARLES COUNTY", "MO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "081411-29063        05 Back Pain (No Trauma) 161 Our Ln                                        ~/HIGHWAY 94 N           APT:                X ST:HIGHWAY 94 N/Dead End         MAP:M 6-22         Rivers Pointe B2",
        "ID:081411-29063",
        "INFO:        ",
        "CODE:05 ",
        "CALL:Back Pain (No Trauma) ",
        "ADDR:161 Our Ln                                        ~ & HIGHWAY 94 N           APT:                X ST:HIGHWAY 94 N & Dead End         MAP:M 6-22         Rivers Pointe B2");

    doTest("T2",
        "072611-26676        23 Overdose QD           308 Donald Ave                                    PRAIRIE HOMES ADDN/HWY V APT:                X ST:SUSAN AVE/RUTH AVE            MAP:BB 8-19        Orchard Farm B2",
        "ID:072611-26676",
        "INFO:        ",
        "CODE:23 ",
        "CALL:Overdose QD           ",
        "ADDR:308 Donald Ave                                    PRAIRIE HOMES ADDN & HWY V APT:                X ST:SUSAN AVE & RUTH AVE            MAP:BB 8-19        Orchard Farm B2");

    doTest("T3",
        "081911-29644        29 Motor Vehicle Accident4795 Highway 94 N                                 CHU Trinity Lutheran ChurAPT:                X ST:CHURCH RD/HIGHWAY H           MAP:Z 10-19        Orchard Farm B2",
        "ID:081911-29644",
        "INFO:        ",
        "CODE:29 ",
        "CALL:Motor Vehicle Accident",
        "ADDR:4795 Highway 94 N                                 CHU Trinity Lutheran ChurAPT:                X ST:CHURCH RD & HIGHWAY H           MAP:Z 10-19        Orchard Farm B2");

    doTest("T4",
        "081911-29644        29 Motor Vehicle Accident4795 Highway 94 N                                 CHU Trinity Lutheran ChurAPT:                X ST:CHURCH RD/HIGHWAY H           MAP:Z 10-19        Orchard Farm B2",
        "ID:081911-29644",
        "INFO:        ",
        "CODE:29 ",
        "CALL:Motor Vehicle Accident",
        "ADDR:4795 Highway 94 N                                 CHU Trinity Lutheran ChurAPT:                X ST:CHURCH RD & HIGHWAY H           MAP:Z 10-19        Orchard Farm B2");
  }
  
  public static void main(String[] args) {
    new MOStCharlesCountyParserTest().generateTests("T1", "ID INFO CODE CALL ADDR");
  }
}