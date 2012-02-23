package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TNCumberlandCountyParserTest extends BaseParserTest {
  
  public TNCumberlandCountyParserTest() {
    setParser(new TNCumberlandCountyParser(), "CUMBERLAND COUNTY", "TN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "911-CENTER:1046 INJURY ACCIDENT LANTANA AT STORIE 7656250985 COUNTY",
        "CODE:1046",
        "CALL:INJURY ACCIDENT LANTANA",
        "ADDR:STORIE",
        "PHONE:7656250985");

    doTest("T2",
        "911-CENTER:1072A FIRE ALARM 912 GERONIMO LN 9317470058 COUNTY WIDE",
        "CODE:1072A",
        "CALL:FIRE ALARM",
        "ADDR:912 GERONIMO LN",
        "PHONE:9317470058");

    doTest("T3",
        "911-CENTER:1072B FIRE, BRUSH/WOODS 18 JASPER DR 931 COUNTY WIDE",
        "CODE:1072B",
        "CALL:FIRE, BRUSH/WOODS",
        "ADDR:18 JASPER DR",
        "PHONE:931");

    doTest("T4",
        "911-CENTER:1072S FIRE, STRUCTURE 171 RED FOX DR 931 COUNTY WIDE",
        "CODE:1072S",
        "CALL:FIRE, STRUCTURE",
        "ADDR:171 RED FOX DR",
        "PHONE:931");

    doTest("T5",
        "911-CENTER:1046 INJURY ACCIDENT 3173 GENESIS RD 9312108439 COUNTY WIDE",
        "CODE:1046",
        "CALL:INJURY ACCIDENT",
        "ADDR:3173 GENESIS RD",
        "PHONE:9312108439");

    doTest("T6",
        "911-CENTER:1072S FIRE, STRUCTURE 4503 CRESTON RD 9317071052 COUNTY WIDE",
        "CODE:1072S",
        "CALL:FIRE, STRUCTURE",
        "ADDR:4503 CRESTON RD",
        "PHONE:9317071052");

    doTest("T7",
        "911-CENTER:1072 FIRE 110 NORTHRIDGE DR 931 COUNTY WIDE",
        "CODE:1072",
        "CALL:FIRE",
        "ADDR:110 NORTHRIDGE DR",
        "PHONE:931");

    doTest("T8",
        "911-CENTER:1072S FIRE, STRUCTURE 261 FLORIDA AVE 9317885007 COUNTY WIDE",
        "CODE:1072S",
        "CALL:FIRE, STRUCTURE",
        "ADDR:261 FLORIDA AVE",
        "PHONE:9317885007");

    doTest("T9",
        "911-CENTER:1046 INJURY ACCIDENT 217 SNEAD DR 9315290123 COUNTY WIDE",
        "CODE:1046",
        "CALL:INJURY ACCIDENT",
        "ADDR:217 SNEAD DR",
        "PHONE:9315290123");
  
  }
  

  public static void main(String[] args) {
    new TNCumberlandCountyParserTest().generateTests("T1", "CODE CALL ADDR PHONE CITY");
  }
}
