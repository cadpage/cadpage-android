package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.OR.ORWashingtonCountyParser;

import org.junit.Test;


public class ORWashingtonCountyParserTest extends BaseParserTest {
  
  public ORWashingtonCountyParserTest() {
    setParser(new ORWashingtonCountyParser(), "WASHINGTON COUNTY", "OR");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "MVA-UKN INJURY SW TUALATIN VALLEY HW/SW331ST AV (33098 TUALATIN VALLEY/331ST) HIL MAP: 5377D UNIT: C2 E01 R8",
        "CALL:MVA-UKN INJURY",
        "ADDR:SW TUALATIN VALLEY HW & SW331ST AV",
        "X:33098 TUALATIN VALLEY/331ST",
        "CITY:HILLSBORO",
        "MAP:5377D",
        "UNIT:C2 E01 R8");
        
    doTest("T2",
        "ABDOMINAL PAIN 985 N DAVIS ST (DEAD END & N 10TH AV) CON MAP: 5375D UNIT: METWA STA8",
        "CALL:ABDOMINAL PAIN",
        "ADDR:985 N DAVIS ST",
        "X:DEAD END & N 10TH AV",
        "CITY:CORNELIUS",
        "MAP:5375D",
        "UNIT:METWA STA8");

    doTest("T3",
        "BREATHING PROB 39470 SW GEIGER RD (SW LAFOLLETT RD & FERN HILL RD) CON MAP: 5574B UNIT: METWA STA8",
        "CALL:BREATHING PROB",
        "ADDR:39470 SW GEIGER RD",
        "X:SW LAFOLLETT RD & FERN HILL RD",
        "CITY:CORNELIUS",
        "MAP:5574B",
        "UNIT:METWA STA8");

    doTest("T4",
        "SICK PERSON/UNKO 1045 N ADAIR ST (N 10TH AV & N 10TH-11TH AL) CON MAP: 5375D UNIT: METWA STA8",
        "CALL:SICK PERSON/UNKO",
        "ADDR:1045 N ADAIR ST",
        "X:N 10TH AV & N 10TH-11TH AL",
        "CITY:CORNELIUS",
        "MAP:5375D",
        "UNIT:METWA STA8");

    doTest("T5",
        "RESIDENTIAL FIRE 822 N 28TH AV (N HOLLADAY DR & N 27TH AV) CON MAP: 5376D UNIT: METWA TIMERC CAS8 CFDUTY SIRN08 E813 E814 E815 E421 R8 T03 COCB1",
        "CALL:RESIDENTIAL FIRE",
        "ADDR:822 N 28TH AV",
        "X:N HOLLADAY DR & N 27TH AV",
        "CITY:CORNELIUS",
        "MAP:5376D",
        "UNIT:METWA TIMERC CAS8 CFDUTY SIRN08 E813 E814 E815 E421 R8 T03 COCB1");
  }
}
