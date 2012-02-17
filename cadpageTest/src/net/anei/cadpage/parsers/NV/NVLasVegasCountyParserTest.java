package net.anei.cadpage.parsers.NV;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NVLasVegasCountyParserTest extends BaseParserTest {
  
  public NVLasVegasCountyParserTest() {
    setParser(new NVLasVegasParser(), "LAS VEGAS", "NV");
  }
  
  @Test
  public void testBadMsg() {
    doBadTest("SMS / 725 12011269 Disp:16:59:20 Enroute:16:59:27 On Scene:17:26:43 To Hosp:17:40:01 At Hosp:17:58:28");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "SMS / 725 12011164 Pri:4 Prob:Sch Grid:2625-1/11 3186 S MARYLAND PKWY Bld:ER Apt:25 Zip:89169",
        "ID:12011164",
        "PRI:4",
        "CALL:Sch",
        "MAP:2625-1/11",
        "ADDR:3186 S MARYLAND PKWY",
        "APT:ER-25",
        "CITY:89169");

    doTest("T2",
        "SMS / 725 12011200 Pri:4 Prob:Imm Grid:2429-1/11 61 N NELLIS BLVD Bld: Apt: Zip:89110",
        "ID:12011200",
        "PRI:4",
        "CALL:Imm",
        "MAP:2429-1/11",
        "ADDR:61 N NELLIS BLVD",
        "CITY:89110");

    doTest("T3",
        "SMS / 725 12011221 Pri:5 Prob:Imm Grid:2826-1/11 2170 E HARMON AV Bld: Apt:324A Zip:89119",
        "ID:12011221",
        "PRI:5",
        "CALL:Imm",
        "MAP:2826-1/11",
        "ADDR:2170 E HARMON AV",
        "MADDR:2170 E HARMON AVE",
        "APT:324A",
        "CITY:89119");

    doTest("T4",
        "SMS / 725 12011269 Pri:5 Prob:Imm Grid:1823-1/11 2202 W CRAIG RD Bld: Apt: Zip:89032",
        "ID:12011269",
        "PRI:5",
        "CALL:Imm",
        "MAP:1823-1/11",
        "ADDR:2202 W CRAIG RD",
        "CITY:89032");
  }
  

  public static void main(String[] args) {
    new NVLasVegasCountyParserTest().generateTests("T1");
  }
}
