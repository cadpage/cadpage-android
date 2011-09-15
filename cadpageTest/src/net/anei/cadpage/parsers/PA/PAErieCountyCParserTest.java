package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PAErieCountyCParserTest;

import org.junit.Test;


public class PAErieCountyCParserTest extends BaseParserTest {
  
  public PAErieCountyCParserTest() {
    setParser(new PAErieCountyCParser(), "ERIE COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Belle Valley / 26C1 &gt;SICK PERSON 41 W GORE RD Apt 282 Bldg XS OLD FRENCH RD MILLCREEK TWP RN - SUSAN\n\n",
        "SRC:Belle Valley",
        "CODE:26C1",
        "CALL:SICK PERSON",
        "ADDR:41 W GORE RD",
        "APT:282",
        "CITY:MILLCREEK TWP",
        "X:OLD FRENCH RD",
        "NAME:RN - SUSAN");

    doTest("T2",
        "Belle Valley / 26C1 &gt;SICK PERSON 41 W GORE RD Apt 282 Bldg XS OLD FRENCH RD MILLCREEK TWP RN - SUSAN\n\n",
        "SRC:Belle Valley",
        "CODE:26C1",
        "CALL:SICK PERSON",
        "ADDR:41 W GORE RD",
        "APT:282",
        "CITY:MILLCREEK TWP",
        "X:OLD FRENCH RD",
        "NAME:RN - SUSAN");

    doTest("T3",
        "Belle Valley / 17A1G &gt;FALLS (ON THE GROUND/FLOOR) 4717 CONRAD RD XS ZENITH DR MILLCREEK TWP WRAY, ROSE\n\n",
        "SRC:Belle Valley",
        "CODE:17A1G",
        "CALL:FALLS (ON THE GROUND/FLOOR)",
        "ADDR:4717 CONRAD RD",
        "CITY:MILLCREEK TWP",
        "X:ZENITH DR",
        "NAME:WRAY, ROSE");

    doTest("T4",
        "Belle Valley / 26A9 &gt;SICK PERSON 5450 CIDER MILL RD XS COVINGTON VALLEY DR MILLCREEK TWP GREGORY, CHRO\n\n",
        "SRC:Belle Valley",
        "CODE:26A9",
        "CALL:SICK PERSON",
        "ADDR:5450 CIDER MILL RD",
        "CITY:MILLCREEK TWP",
        "X:COVINGTON VALLEY DR",
        "NAME:GREGORY, CHRO");

    doTest("T5",
        "Belle Valley / 17A1G &gt;FALLS (ON THE GROUND/FLOOR) 41 W GORE RD Apt 282 Bldg XS OLD FRENCH RD MILLCREEK TWP PEGGY\n\n",
        "SRC:Belle Valley",
        "CODE:17A1G",
        "CALL:FALLS (ON THE GROUND/FLOOR)",
        "ADDR:41 W GORE RD",
        "APT:282",
        "CITY:MILLCREEK TWP",
        "X:OLD FRENCH RD",
        "NAME:PEGGY");

    doTest("T6",
        "Belle Valley / 52C1P &gt;ALM HI-LIFE HAZ PULL STATION 1928 WAGER RD XS BUNDY DR MILLCREEK TWP 37655 FROM SIMPLEX\n\n",
        "SRC:Belle Valley",
        "CODE:52C1P",
        "CALL:ALM HI-LIFE HAZ PULL STATION",
        "ADDR:1928 WAGER RD",
        "CITY:MILLCREEK TWP",
        "X:BUNDY DR",
        "NAME:37655 FROM SIMPLEX");

  }
  
  public static void main(String[] args) {
    new PAErieCountyCParserTest().generateTests("T1");
  }
}