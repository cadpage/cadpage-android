package net.anei.cadpage.parsers.NV;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NVLasVegasCountyParserTest extends BaseParserTest {
  
  public NVLasVegasCountyParserTest() {
    setParser(new NVLasVegasParser(), "LAS VEGAS", "NV");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(SMS) I: 4273738 U: 3901, P: 3, G: 3423, PH: 17 L: 2711 W WINDMILL LN# , B: , AL: PC:, 1A N:1A], 17:07:17 [Geographic Area: 2711 W WINDMILL LN]",
        "ID:4273738",
        "UNIT:3901",
        "PRI:3",
        "MAP:3423",
        "INFO:17 / 1A",
        "ADDR:2711 W WINDMILL LN",
        "TIME:17:07:17");

    doTest("T2",
        "(SMS) I: 4274400 U: 3901, P: 2, G: 3217, PH: 61 L: S DURANGO DR / W MAULE AVE# , B: , AL: PC:, 32B N:32B], 19:02:59 [Geographic Area: S DURANGO",
        "ID:4274400",
        "UNIT:3901",
        "PRI:2",
        "MAP:3217",
        "INFO:61 / 32B",
        "ADDR:S DURANGO DR & W MAULE AVE",
        "TIME:19:02:59");

    doTest("T3",
        "(SMS) I: 4273913 U: 3901, P: 1, G: 2821, PH: 13 L: 4285 DUNEVILLE ST-CC# 236 , B: , AL: PC:, 6D N:6D], Location from Fire: 4285 DUNEVILLE ST, 00",
        "ID:4273913",
        "UNIT:3901",
        "PRI:1",
        "MAP:2821",
        "INFO:13 / 6D",
        "APT:236",
        "ADDR:4285 DUNEVILLE ST",
        "CITY:CLARK COUNTY");

    doTest("T4",
        "[SMS]  I: 4273807 U: 3901, P: 1, G: 2814, PH: 55 L: 4541 BERSAGLIO ST-CC# , B: , AL: PC:, 5C N:5C], Location from Fire: 4541 BERSAGLIO ST, 19:51:",
        "ID:4273807",
        "UNIT:3901",
        "PRI:1",
        "MAP:2814",
        "INFO:55 / 5C",
        "ADDR:4541 BERSAGLIO ST",
        "CITY:CLARK COUNTY");

    doTest("T5",
        "(SMS) I: 4274438 U: 3901, P: 1, G: 2815, PH: 17 L: W FLAMINGO RD / N I 215# , B: , AL: PC:, 12D N:12D], 20:33:59 [Geographic Area: W FLAMINGO RD",
        "ID:4274438",
        "UNIT:3901",
        "PRI:1",
        "MAP:2815",
        "INFO:17 / 12D",
        "ADDR:W FLAMINGO RD & N I 215", // Not mapping
        "TIME:20:33:59");

    doTest("T6",
        "(SMS) I: 4274468 U: 3901, P: 3, G: 3425, PH: 25 L: 8105 BURNT SIENNA ST-CC# , B: , AL: PC:, 17A N:17A], Location from Fire: 8105 BURNT SIENNA ST",
        "ID:4274468",
        "UNIT:3901",
        "PRI:3",
        "MAP:3425",
        "INFO:25 / 17A",
        "ADDR:8105 BURNT SIENNA ST",
        "CITY:CLARK COUNTY");

    doTest("T7",
        "(SMS) I: 4274545 U: 3901, P: 7, G: 3216, PH: 11 L: 9300 W SUNSET RD-CC# ER 1 , B: SOUTHERN HILLS HOSPI, AL: 9MOM / IV MON O2 / H1P ER PC:, 430 N",
        "ID:4274545",
        "UNIT:3901",
        "PRI:7",
        "MAP:3216",
        "INFO:11 / 9MOM / IV MON O2 / H1P ER / 430 N",
        "APT:ER 1",
        "ADDR:9300 W SUNSET RD",
        "CITY:CLARK COUNTY",
        "PLACE:SOUTHERN HILLS HOSPI");
  }
  

  public static void main(String[] args) {
    new NVLasVegasCountyParserTest().generateTests("T1");
  }
}
