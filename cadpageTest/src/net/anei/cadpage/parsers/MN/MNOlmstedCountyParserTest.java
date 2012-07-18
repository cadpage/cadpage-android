package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MNOlmstedCountyParserTest extends BaseParserTest {
  
  public MNOlmstedCountyParserTest() {
    setParser(new MNOlmstedCountyParser(), "OLMSTEAD COUNTY", "MN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Main St N 20 ST NW) Two vehicle Accident with injuries, neck and head pain\r\n" +
        "\r\n" +
        "Jeff Wellik\r\n" +
        "Public Safety Communications\r\n" +
        "Rochester Police/Olmsted County Sh",

        "ADDR:Main St N & 20 ST NW",
        "CALL:Two vehicle Accident with injuries, neck and head pain",
        "INFO:Jeff Wellik / Public Safety Communications / Rochester Police/Olmsted County Sh");

    doTest("T2",
        "(4639 grove st se) Elderly male stroke symptoms, blurred vision weak legs",
        "ADDR:4639 grove st se",
        "CALL:Elderly male stroke symptoms, blurred vision weak legs");

    doTest("T3",
        "(200 lakeshore dr nw) Med",
        "ADDR:200 lakeshore dr nw",
        "CALL:Med");

    doTest("T4",
        "(200 lakeshore dr nw  florence park) medical",
        "ADDR:200 lakeshore dr nw",
        "PLACE:florence park",
        "CALL:medical");

    doTest("T5",
        "(500 6 st ne) Medical",
        "ADDR:500 6 st ne",
        "CALL:Medical");

    doTest("T6",
        "(6220 70 ST SW) Male with chest pains  6220 70 ST SW",
        "ADDR:6220 70 ST SW",
        "CALL:Male with chest pains  6220 70 ST SW");

    doTest("T7",
        "(medical 1106 Sunrise Ct SE  baby with siezure)",
        "ADDR:1106 Sunrise Ct SE",
        "CALL:medical",
        "INFO:baby with siezure");

    doTest("T8",
        "(101 schumann dr nw) GRASS FIRE ON W SIDE OF KWIK TRIP",
        "ADDR:101 schumann dr nw",
        "CALL:GRASS FIRE ON W SIDE OF KWIK TRIP");
        
  }
  
  public static void main(String[] args) {
    new MNOlmstedCountyParserTest().generateTests("T1", "ADDR APT PLACE CALL INFO");
  }
}
