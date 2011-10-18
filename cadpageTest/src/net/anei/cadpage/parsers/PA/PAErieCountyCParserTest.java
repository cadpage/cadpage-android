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

  @Test
  public void testParser2() {

    doTest("T1",
        "(Belle Valley) 17B3G &gt;FALLS (ON THE GROUND/FLOOR) 1248 E ARLINGTON RD XS BRANDES ST MILLCREEK TWP DORAK, JANE\n",
        "SRC:Belle Valley",
        "CODE:17B3G",
        "CALL:FALLS (ON THE GROUND/FLOOR)",
        "ADDR:1248 E ARLINGTON RD",
        "CITY:MILLCREEK TWP",
        "X:BRANDES ST",
        "NAME:DORAK, JANE");

    doTest("T2",
        "(Belle Valley) 26A5 &gt;SICK PERSON 5298 CRABAPPLE DR Apt 211 Bldg XS CIDER MILL RD MILLCREEK TWP OSBORN M L\n",
        "SRC:Belle Valley",
        "CODE:26A5",
        "CALL:SICK PERSON",
        "ADDR:5298 CRABAPPLE DR",
        "APT:211",
        "CITY:MILLCREEK TWP",
        "X:CIDER MILL RD",
        "NAME:OSBORN M L");

    doTest("T3",
        "(Belle Valley) 26C2 &gt;SICK PERSON 1747 E GRANDVIEW BLVD XS ALVIN ST MILLCREEK TWP HILL,RONALD\n",
        "SRC:Belle Valley",
        "CODE:26C2",
        "CALL:SICK PERSON",
        "ADDR:1747 E GRANDVIEW BLVD",
        "CITY:MILLCREEK TWP",
        "X:ALVIN ST",
        "NAME:HILL,RONALD");

    doTest("T4",
        "(Belle Valley) 10C2 &gt;CHEST PAIN 5143 SCHRIMPER RD XS RIPLEY DR MILLCREEK TWP MOREHOUSE, ADINA\n",
        "SRC:Belle Valley",
        "CODE:10C2",
        "CALL:CHEST PAIN",
        "ADDR:5143 SCHRIMPER RD",
        "CITY:MILLCREEK TWP",
        "X:RIPLEY DR",
        "NAME:MOREHOUSE, ADINA");

    doTest("T5",
        "(Belle Valley) 26A1 &gt;SICK PERSON 1188 E ARLINGTON RD XS BELLEVIEW DR MILLCREEK TWP SMITH PAUL\n",
        "SRC:Belle Valley",
        "CODE:26A1",
        "CALL:SICK PERSON",
        "ADDR:1188 E ARLINGTON RD",
        "CITY:MILLCREEK TWP",
        "X:BELLEVIEW DR",
        "NAME:SMITH PAUL");
  }
  
  public static void main(String[] args) {
    new PAErieCountyCParserTest().generateTests("T1");
  }
}