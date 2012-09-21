package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class ORJacksonCountyParserTest extends BaseParserTest {
  
  public ORJacksonCountyParserTest() {
    setParser(new ORJacksonCountyParser(), "JACKSON COUNTY", "OR");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:CPF, Chest Pains, 345 WILLOW SPRINGS DR, TA, PRI:1, Units:8300, 8331, 8833 - From\n" +
        "(Con't) 2 of 2\n" +
        "CAD07 06/24/2012 19:48:52\n" +
        "(End)",

        "CODE:CPF",
        "CALL:Chest Pains",
        "ADDR:345 WILLOW SPRINGS DR",
        "CITY:TALENT",
        "PRI:1",
        "UNIT:8300,8331,8833",
        "SRC:CAD07",
        "DATE:06/24/2012",
        "TIME:19:48:52");

    doTest("T2",
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:STRUCF, Structure Fire, 1457 WHITMAN AVE, MF, PRI:1, Unit:8300 - From CAD13 06/25/2012 17:38:40 ",

        "CODE:STRUCF",
        "CALL:Structure Fire",
        "ADDR:1457 WHITMAN AVE",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8300",
        "SRC:CAD13",
        "DATE:06/25/2012",
        "TIME:17:38:40");

    doTest("T3",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:MVCUF, MVC Unknown Injury, 1362 FOSS RD, TA, PRI:1, Units:8300, 8301, 8331, 8831 -\n" +
        "(Con't) 2 of 2\n" +
        "From CAD15 06/25/2012 18:54:05 \n" +
        "(End)",

        "CODE:MVCUF",
        "CALL:MVC Unknown Injury",
        "ADDR:1362 FOSS RD",
        "CITY:TALENT",
        "PRI:1",
        "UNIT:8300,8301,8331,8831",
        "SRC:CAD15",
        "DATE:06/25/2012",
        "TIME:18:54:05");

    doTest("T4",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:GRASS, Grass Fire, DEER TRAIL LN/COLEMAN CREEK RD, MF, PRI:1, Units:8300, 8303,\n" +
        "(Con't) 2 of 2\n" +
        "8341, 8361, 8363, 8801, ODFM - From CAD15 06/25/2012 18:55:35 \n" +
        "(End)",

        "CODE:GRASS",
        "CALL:Grass Fire",
        "ADDR:DEER TRAIL LN & COLEMAN CREEK RD",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8300,8303,8341,8361,8363,8801,ODFM",
        "SRC:CAD15",
        "DATE:06/25/2012",
        "TIME:18:55:35");

    doTest("T5",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:MVCUF, MVC Unknown Injury, 1362 FOSS RD, TA, PRI:1, Units:8300, 8301, 8331, 8831 -\n" +
        "(Con't) 2 of 2\n" +
        "From CAD15 06/25/2012 18:54:05 \n" +
        "(End)",

        "CODE:MVCUF",
        "CALL:MVC Unknown Injury",
        "ADDR:1362 FOSS RD",
        "CITY:TALENT",
        "PRI:1",
        "UNIT:8300,8301,8331,8831",
        "SRC:CAD15",
        "DATE:06/25/2012",
        "TIME:18:54:05");

    doTest("T6",
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:ALRMMF, Medical Alarm, 1122 N ROSE ST, PH, PRI:1, Units:8300, 8303 - From CAD15 06/25/2012 19:25:13 ",

        "CODE:ALRMMF",
        "CALL:Medical Alarm",
        "ADDR:1122 N ROSE ST",
        "CITY:PHOENIX",
        "PRI:1",
        "UNIT:8300,8303",
        "SRC:CAD15",
        "DATE:06/25/2012",
        "TIME:19:25:13");

    doTest("T7",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:STRUCF, Structure Fire, 180 LINCOLN ST, AS, PRI:1, Units:8300, 8301, 8801, 8802,\n" +
        "(Con't) 2 of 2\n" +
        "8853, 88CO - From CAD15 06/26/2012 07:47:36 \n" +
        "(End)",

        "CODE:STRUCF",
        "CALL:Structure Fire",
        "ADDR:180 LINCOLN ST",
        "CITY:ASHLAND",
        "PRI:1",
        "UNIT:8300,8301,8801,8802,8853,88CO",
        "SRC:CAD15",
        "DATE:06/26/2012",
        "TIME:07:47:36");

    doTest("T8",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:UNCF, Unconscious Person, 10548 WAGNER CREEK RD, TA, PRI:1, Units:8300, 8331, 8831 -\n" +
        "(Con't) 2 of 2\n" +
        "From CAD15 06/25/2012 21:13:21 \n" +
        "(End)",

        "CODE:UNCF",
        "CALL:Unconscious Person",
        "ADDR:10548 WAGNER CREEK RD",
        "CITY:TALENT",
        "PRI:1",
        "UNIT:8300,8331,8831",
        "SRC:CAD15",
        "DATE:06/25/2012",
        "TIME:21:13:21");

    doTest("T9",
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:STRUCF, Structure Fire, 3555 S PACIFIC HWY #193, MF, PRI:1, Unit:8300 - From CAD13 06/26/2012 23:12:50 ",

        "CODE:STRUCF",
        "CALL:Structure Fire",
        "ADDR:3555 S PACIFIC HWY",
        "APT:193",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8300",
        "SRC:CAD13",
        "DATE:06/26/2012",
        "TIME:23:12:50");

    doTest("T10",
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:MVCIF, MVC injury, 1188 OAK ST, AS, PRI:1, Units:8300, 8311, 8331, 8831 - From CAD15 07/01/2012 17:42:42 ",

        "CODE:MVCIF",
        "CALL:MVC injury",
        "ADDR:1188 OAK ST",
        "CITY:ASHLAND",
        "PRI:1",
        "UNIT:8300,8311,8331,8831",
        "SRC:CAD15",
        "DATE:07/01/2012",
        "TIME:17:42:42");

    doTest("T11",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:GRASS, Grass Fire, 4332 FERN VALLEY RD, MF, PRI:2A, Units:8106, 8146, 8166, 8168,\n" +
        "(Con't) 2 of 2\n" +
        "8300, 8300DO, 8311 - From CAD15 07/02/2012 19:53:43 \n" +
        "(End)",

        "CODE:GRASS",
        "CALL:Grass Fire",
        "ADDR:4332 FERN VALLEY RD",
        "CITY:MEDFORD",
        "PRI:2A",
        "UNIT:8106,8146,8166,8168,8300,8300DO,8311",
        "SRC:CAD15",
        "DATE:07/02/2012",
        "TIME:19:53:43");

    doTest("T12",
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:FALLF, Fall Victim, 300 LUMAN RD #45, PH, PRI:1, Units:8300, 8303 - From CAD15 07/01/2012 10:43:31 ",

        "CODE:FALLF",
        "CALL:Fall Victim",
        "ADDR:300 LUMAN RD",
        "APT:45",
        "CITY:PHOENIX",
        "PRI:1",
        "UNIT:8300,8303",
        "SRC:CAD15",
        "DATE:07/01/2012",
        "TIME:10:43:31");

    doTest("T13",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:GRASS, Grass Fire, 2050 BUTLER CREEK RD, AS, PRI:1, Units:8300, 8301, 8341, 8361,\n" +
        "(Con't) 2 of 2\n" +
        "8801, 8861, 88CO, ODFM - From CAD15 07/04/2012 13:49:40 \n" +
        "(End)",

        "CODE:GRASS",
        "CALL:Grass Fire",
        "ADDR:2050 BUTLER CREEK RD",
        "CITY:ASHLAND",
        "PRI:1",
        "UNIT:8300,8301,8341,8361,8801,8861,88CO,ODFM",
        "SRC:CAD15",
        "DATE:07/04/2012",
        "TIME:13:49:40");

    doTest("T14",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:SMOKE, Smoke Investigation, FOSS RD/ADAMS RD, TA, PRI:1, Units:8300, 8312 - From\n" +
        "(Con't) 2 of 2\n" +
        "CAD15 06/29/2012 20:51:08 \n" +
        "(End)",

        "CODE:SMOKE",
        "CALL:Smoke Investigation",
        "ADDR:FOSS RD & ADAMS RD",
        "CITY:TALENT",
        "PRI:1",
        "UNIT:8300,8312",
        "SRC:CAD15",
        "DATE:06/29/2012",
        "TIME:20:51:08");

  }
  
  public static void main(String args[]) {
    new ORJacksonCountyParserTest().generateTests("T1");
  }
}