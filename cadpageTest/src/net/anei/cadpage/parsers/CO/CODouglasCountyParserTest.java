package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CODouglasCountyParserTest extends BaseParserTest {
  
  public CODouglasCountyParserTest() {
    setParser(new CODouglasCountyParser(), "DOUGLAS COUNTY", "CO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Dispatch) Call: F MED ASSIST Location: 6287 OLD DIVIDE TRL / Map: AD35C Units: MED181 E184 XXX184  HOSPITALITY PL / GREEN CT Common Name: Time: 08/25/.",
        "CALL:F MED ASSIST",
        "ADDR:6287 OLD DIVIDE TRL",
        "MAP:AD35C",
        "UNIT:MED181 E184 XXX184",
        "X:HOSPITALITY PL / GREEN CT");

    doTest("T2",
        "(Dispatch) Call: F MED ASSIST Location: 11710 PONDEROSA LN / Map: AF40D Units: E184 MED181 XXX184  PONDEROSA RD / ELKHORN DR Common Name: Time: 08/25/1",
        "CALL:F MED ASSIST",
        "ADDR:11710 PONDEROSA LN",
        "MAP:AF40D",
        "UNIT:E184 MED181 XXX184",
        "X:PONDEROSA RD / ELKHORN DR");

    doTest("T3",
        "(Dispatch) Call: F GAS LP OUTSIDE Location: DEERFIELD RD / S  WHITE TAIL DR I Map: AI38D Units: E181 XXX181  Common Name: Time: 08/25/11 20:07 Narrativ",
        "CALL:F GAS LP OUTSIDE",
        "ADDR:DEERFIELD RD & S  WHITE TAIL DR I",
        "MAP:AI38D",
        "UNIT:E181 XXX181");

    doTest("T4",
        "(Dispatch) Call: F MED ASSIST Location: 2535 BURNT OAK DR / Map: AG37A Units: E181 MED181 XXX181  BURNING TREE TRL / DEAD END Common Name: Time: 08/25/",
        "CALL:F MED ASSIST",
        "ADDR:2535 BURNT OAK DR",
        "MAP:AG37A",
        "UNIT:E181 MED181 XXX181",
        "X:BURNING TREE TRL / DEAD END");
  }
  
  @Test
  public void testElbertCounty() {

    doTest("T1",
        "(Dispatch) Call: F MED ASSIST Location: S PINE ST / SPRUCE ST Map: AJ44 Units: MED271 E273 XXX271  Common Name: Time: 09/20/11 17:13 Narrative:  PER LE 473 PINE",
        "CALL:F MED ASSIST",
        "ADDR:S PINE ST & SPRUCE ST",
        "MAP:AJ44",
        "UNIT:MED271 E273 XXX271");

    doTest("T2",
        "(Dispatch) Call: F MED ASSIST Location: CR 136 / PADDOCK ST EOPS1 Map: AJ44 Units: MED271 E271 XXX272  Common Name: Time: 09/23/11 13:06 Narrative:  Nature Of Ca",
        "CALL:F MED ASSIST",
        "ADDR:CR 136 & PADDOCK ST",
        "MADDR:COUNTY ROAD 136 & PADDOCK ST",
        "CH:EOPS1",
        "MAP:AJ44",
        "UNIT:MED271 E271 XXX272");

    doTest("T3",
        "Subject:Dispatch\n" +
        "Call: F LIGHTNING Location: STATE HIGHWAY 86 / CHEROKEE TRL Map: AJ42 Units: E271 XXX271  Common Name: Time: 06/13/12 21:06",

        "CALL:F LIGHTNING",
        "ADDR:STATE HIGHWAY 86 & CHEROKEE TRL",
        "MAP:AJ42",
        "UNIT:E271 XXX271");

    doTest("T4",
        "Subject:Dispatch\n" +
        "Call: F BRUSH (T) Location: 4495 W KIOWA CREEK RD / Map: AV44 Units: XXX231 XXX271  BADGER LN / PUMA DR Common Name: Time:",

        "CALL:F BRUSH (T)",
        "ADDR:4495 W KIOWA CREEK RD",
        "MAP:AV44",
        "UNIT:XXX231 XXX271",
        "X:BADGER LN / PUMA DR");

  }
  
  public static void main(String[] args) {
    new CODouglasCountyParserTest().generateTests("T1");
  }
}