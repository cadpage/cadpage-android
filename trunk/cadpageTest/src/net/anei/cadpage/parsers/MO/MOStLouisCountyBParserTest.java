package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOStLouisCountyBParserTest extends BaseParserTest {
  
  public MOStLouisCountyBParserTest() {
    setParser(new MOStLouisCountyBParser(), "ST LOUIS COUNTY", "MO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Dispatch) DIFFICULTY BREATHING \n\n" +
        "1762 LEMAY FERRY RD, Apt. APT 313 \n" +
        "1617 \n" +
        "MapRegions: L29-49, LE Card # 4143 CrossStreets: LE Card# 4143 0.00 mi \n" +
        "Call Number: 7182",

        "CALL:DIFFICULTY BREATHING",
        "ADDR:1762 LEMAY FERRY RD",
        "APT:313",
        "UNIT:1617",
        "MAP:L29-49",
        "INFO:LE Card # 4143",
        "ID:7182");

    doTest("T2",
        "(Dispatch) ANIMAL BITE \n\n" +
        "325 W ARLEE AVE \n" +
        "1117 1614 \n" +
        "MapRegions: K29-49, LE Card # 4271 CrossStreets: LE Card# 4271 0.00 mi \n" +
        "Call Number: 718281",

        "CALL:ANIMAL BITE",
        "ADDR:325 W ARLEE AVE",
        "UNIT:1117 1614",
        "MAP:K29-49",
        "INFO:LE Card # 4271",
        "ID:718281");

    doTest("T3",
        "(Dispatch) FALL \n\n" +
        "2116 KEVIN DR \n" +
        "1617 \n" +
        "MapRegions: K30-49, LE Card # 4130 CrossStreets: LE Card# 4130 0.00 mi \n" +
        "Call Number: 718280",

        "CALL:FALL",
        "ADDR:2116 KEVIN DR",
        "UNIT:1617",
        "MAP:K30-49",
        "INFO:LE Card # 4130",
        "ID:718280");

    doTest("T4",
        "(Dispatch) OBS \n\n" +
        "812 DAMMERT AVE \n" +
        "1617 \n" +
        "MapRegions: K29-49, LE Card # 4064 CrossStreets: LE Card# 4064 0.00 mi \n" +
        "Call Number: 718269",

        "CALL:OBS",
        "ADDR:812 DAMMERT AVE",
        "UNIT:1617",
        "MAP:K29-49",
        "INFO:LE Card # 4064",
        "ID:718269");

    doTest("T5",
        "(Dispatch) SICK CASE \n\n" +
        "115 W ETTA AVE \n" +
        "1614 \n" +
        "MapRegions: K29-49, LE Card # 4273 CrossStreets: LE Card# 4273 0.00 mi \n" +
        "Call Number: 718257",

        "CALL:SICK CASE",
        "ADDR:115 W ETTA AVE",
        "UNIT:1614",
        "MAP:K29-49",
        "INFO:LE Card # 4273",
        "ID:718257");

    doTest("T6",
        "(Dispatch) AMBT \n\n" +
        "4400 BIG CHIEF DR \n" +
        "1617 1134 \n" +
        "MapRegions: AF Card# 3031, L28-49 CrossStreets: AZTEC DR 0.01 mi E TURQUOISE DR 0.06 mi NW \n" +
        "Call Number: 718255",

        "CALL:AMBT",
        "ADDR:4400 BIG CHIEF DR",
        "UNIT:1617 1134",
        "INFO:AF Card# 3031",
        "MAP:L28-49",
        "X:AZTEC DR 0.01 mi E TURQUOISE DR 0.06 mi NW",
        "ID:718255");

    doTest("T7",
        "(Dispatch) DIFFICULTY BREATHING \n\n" +
        "1762 LEMAY FERRY RD, Apt. APT 313 \n" +
        "1617 \n" +
        "MapRegions: L29-49, LE Card # 4143 CrossStreets: LE Card# 4143 0.00 mi \n" +
        "Call Number: 7182",

        "CALL:DIFFICULTY BREATHING",
        "ADDR:1762 LEMAY FERRY RD",
        "APT:313",
        "UNIT:1617",
        "MAP:L29-49",
        "INFO:LE Card # 4143",
        "ID:7182");

    doTest("T8",
        "(Dispatch) VEHACC \n\n" +
        "GREEN PARK RD & REAVIS BARRACKS RD \n" +
        "1710 1614 1757 \n" +
        "MapRegions: L29-49, LE Card # 4107, LE Card # 4201, ME Card# 1665, ME Card# 747 CrossStreets",

        "CALL:VEHACC",
        "ADDR:GREEN PARK RD & REAVIS BARRACKS RD",
        "UNIT:1710 1614 1757",
        "MAP:L29-49",
        "INFO:LE Card # 4107, LE Card # 4201, ME Card# 1665, ME Card# 747 CrossStreets");

    doTest("T9",
        "(Dispatch) ASTFIR \n\n317 EAST DAVIS \n1614 \nMapRegions:  CrossStreets: \nCall Number: 718231",
        "CALL:ASTFIR",
        "ADDR:317 EAST DAVIS",
        "UNIT:1614",
        "ID:718231");

    doTest("T10",
        "(Dispatch) ACCIDENTAL INJURY \n\n" +
        "373 TUCKAHOE DR \n" +
        "1617 \n" +
        "MapRegions: K31-59, LE Card # 4248 CrossStreets: LE Card# 4248 0.00 mi \n" +
        "Call Number: 718226",

        "CALL:ACCIDENTAL INJURY",
        "ADDR:373 TUCKAHOE DR",
        "UNIT:1617",
        "MAP:K31-59",
        "INFO:LE Card # 4248",
        "ID:718226");

    doTest("T11",
        "(Dispatch) VEHACC \n\nLEMAY FERRY RD & FANNIE AVE \n1614 1617 \nMapRegions: K28-49, LE Card # 4299 CrossStreets: \nCall Number: 718216",
        "CALL:VEHACC",
        "ADDR:LEMAY FERRY RD & FANNIE AVE",
        "UNIT:1614 1617",
        "MAP:K28-49",
        "INFO:LE Card # 4299",
        "ID:718216");
  }
  
  public static void main(String[] args) {
    new MOStLouisCountyBParserTest().generateTests("T1");
  }
}
