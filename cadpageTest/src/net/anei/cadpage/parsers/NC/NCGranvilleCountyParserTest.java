package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Granville County, NC
Contact: "ghockaday@brassfieldfiredept.com" <ghockaday@brassfieldfiredept.com>
Sender: @granvillecounty.org

LEWIS:2127 VICTORY LN CREEDMOOR WALTERS RD X DEAD END jim lyons 9197255015 02:53:08 CHEST PAINS 63 yo male..
BOWEN:3559 NC HWY 56 E e CREEDMOOR WALTERS RD X JATAVIAN LN garcia,lisa 9199391917 14:01:51 FALL (PERSON HAS FALLEN) caller advised 52.      yoa female fell in.
HICKS:3436 HORSESHOE RD CREEDMOOR LAWRENCE RD X REEDY BRANCH RD NICHALS, GLENDA 9196976593 15:46:38 FIRE (GRASS-WOODS) THE CALLER ADVISED THERE IS A SMALL
ROYSTER:1506 NC HWY 96 S FRANKLINTON BRAGG, Martin 9195283196 2012050157 04:09:11 FALL (PERSON HAS FALLEN) 88 yof fell , bleeding from rectal area, cons.

*/

public class NCGranvilleCountyParserTest extends BaseParserTest {
  
  public NCGranvilleCountyParserTest() {
    setParser(new NCGranvilleCountyParser(), "GRANVILLE COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "LEWIS:2127 VICTORY LN CREEDMOOR WALTERS RD X DEAD END jim lyons 9197255015 02:53:08 CHEST PAINS 63 yo male..",
        "NAME:jim lyons",
        "ADDR:2127 VICTORY LN",
        "CITY:CREEDMOOR",
        "X:WALTERS RD / DEAD END",
        "ID:9197255015",
        "TIME:02:53:08",
        "CALL:CHEST PAINS",
        "INFO:63 yo male..");

    doTest("T2",
        "BOWEN:3559 NC HWY 56 E e CREEDMOOR WALTERS RD X JATAVIAN LN garcia,lisa 9199391917 14:01:51 FALL (PERSON HAS FALLEN) caller advised 52.      yoa female fell in.",
        "NAME:garcia,lisa",
        "ADDR:3559 NC HWY 56 E e",
        "MADDR:3559 STATE 56 E e",
        "CITY:CREEDMOOR",
        "X:WALTERS RD / JATAVIAN LN",
        "ID:9199391917",
        "TIME:14:01:51",
        "CALL:FALL",
        "INFO:(PERSON HAS FALLEN) caller advised 52.      yoa female fell in.");

    doTest("T3",
        "HICKS:3436 HORSESHOE RD CREEDMOOR LAWRENCE RD X REEDY BRANCH RD NICHALS, GLENDA 9196976593 15:46:38 FIRE (GRASS-WOODS) THE CALLER ADVISED THERE IS A SMALL",
        "NAME:NICHALS, GLENDA",
        "ADDR:3436 HORSESHOE RD",
        "CITY:CREEDMOOR",
        "X:LAWRENCE RD / REEDY BRANCH RD",
        "ID:9196976593",
        "TIME:15:46:38",
        "CALL:FIRE",
        "INFO:(GRASS-WOODS) THE CALLER ADVISED THERE IS A SMALL");

    doTest("T4",
        "ROYSTER:1506 NC HWY 96 S FRANKLINTON BRAGG, Martin 9195283196 2012050157 04:09:11 FALL (PERSON HAS FALLEN) 88 yof fell , bleeding from rectal area, cons.",
        "NAME:BRAGG, Martin",
        "ADDR:1506 NC HWY 96 S",
        "MADDR:1506 STATE 96 S",
        "CITY:FRANKLINTON",
        "PHONE:9195283196",
        "ID:2012050157",
        "TIME:04:09:11",
        "CALL:FALL",
        "INFO:(PERSON HAS FALLEN) 88 yof fell , bleeding from rectal area, cons.");

  }
  
  public static void main(String[] args) {
    new NCGranvilleCountyParserTest().generateTests("T1");
  }
}
