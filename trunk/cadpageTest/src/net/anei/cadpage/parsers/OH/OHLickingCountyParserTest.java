package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHLickingCountyParserTest extends BaseParserTest {
  
  public OHLickingCountyParserTest() {
    setParser(new OHLickingCountyParser(), "LICKING COUNTY", "OH");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "LC911:ILLNESS    24 S OREGON ST   JOHNSTOWN",
        "CALL:ILLNESS",
        "ADDR:24 S OREGON ST",
        "CITY:JOHNSTOWN");

    doTest("T2",
        "LC911:SICK PERSON   231  COMMERCE BL   JOHNSTOWN",
        "CALL:SICK PERSON",
        "ADDR:231 COMMERCE BL",
        "CITY:JOHNSTOWN");

    doTest("T3",
        "LC911:ABDOMINAL PAIN   76  YARDNER ST   LOT 9 JOHNSTOWN",
        "CALL:ABDOMINAL PAIN",
        "ADDR:76 YARDNER ST",
        "APT:9",
        "CITY:JOHNSTOWN");

    doTest("T4",
        "LC911:TRAFFIC ACCIDENT  551 W COSHOCTON ST JOHNSTOWN",
        "CALL:TRAFFIC ACCIDENT",
        "ADDR:551 W COSHOCTON ST",
        "CITY:JOHNSTOWN");

    doTest("T5",
        "LC911:HEMMORAGE/LACERATION - Location:   14584.00  JUG STREET RD  JERSEY TWP",
        "CALL:HEMMORAGE/LACERATION",
        "ADDR:14584 JUG STREET RD",
        "CITY:JERSEY TWP");

  }
  
  @Test
  public void testParser2() {


    doTest("T1",
        "LC911:[3298]-- - Nature: HEMMORAGE/LACERATION - Location: 36.00 S MAIN ST   JOHNSTOWN -",
        "CALL:HEMMORAGE/LACERATION",
        "ADDR:36 S MAIN ST",
        "CITY:JOHNSTOWN");

    doTest("T2",
        "LC911:[3298]-- - Nature: FALLS - Location:    8485.00  WINDY HOLLOW RD NW  LIBERTY TWP -",
        "CALL:FALLS",
        "ADDR:8485 WINDY HOLLOW RD NW",
        "CITY:LIBERTY TWP");

    doTest("T3",
        "LC911:[4503]-- - Nature: ABDOMINAL PAIN/PROBLEM - Location:    322 BEECH RD NW  JERSEY TWP .  Fema",
        "CALL:ABDOMINAL PAIN/PROBLEM",
        "ADDR:322 BEECH RD NW",
        "CITY:JERSEY TWP",
        "INFO:Fema");

    doTest("T4",
        "LC911:[3298]-- - Nature: HEMMORAGE/LACERATION - Location: 188.00  COMMERCE BL  JOHNSTOWN -",
        "CALL:HEMMORAGE/LACERATION",
        "ADDR:188 COMMERCE BL",
        "CITY:JOHNSTOWN");

    doTest("T5",
        "LC911:[3298]-- - Nature: TRAUMATIC INJURIES (SPECIFIC) - Location:     231.00  COMMERCE BL",
        "CALL:TRAUMATIC INJURIES (SPECIFIC)",
        "ADDR:231 COMMERCE BL");

    doTest("T6",
        "LC911:[3064]-- - Nature: SICK PERSON (SPECIFIC DIAGNOSIS) - Location:    4977.00  MINK ST NW  MONROE TWP - Comments:",
        "CALL:SICK PERSON (SPECIFIC DIAGNOSIS)",
        "ADDR:4977 MINK ST NW",
        "CITY:MONROE TWP");

    doTest("T7",
        "LC911:[3298]-- - Nature: ILLNESS - NON SPECIFIC - Location: 76.00 YARDNER ST Suite:UNIT29 JOHNSTOWN -",
        "CALL:ILLNESS - NON SPECIFIC",
        "ADDR:76 YARDNER ST",
        "APT:UNIT29",
        "CITY:JOHNSTOWN");
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "LC911:- Nature: ILLNESS - NON SPECIFIC - Location:      65.00 S WILLIAMS ST  Suite:RM 206 JOHNSTOWN",
        "CALL:ILLNESS - NON SPECIFIC",
        "ADDR:65 S WILLIAMS ST",
        "APT:RM 206",
        "CITY:JOHNSTOWN");

    doTest("T2",
        "LC911:- Nature: CHEST PAIN - Location:     119.00  WESTVIEW DR JOHNSTOWN -",
        "CALL:CHEST PAIN",
        "ADDR:119 WESTVIEW DR",
        "CITY:JOHNSTOWN");

    doTest("T3",
        "LC911:- Nature: FIRE - HOUSE/ MOBILE HOME -SINGLE - Location:    5598.00  RACCOON VALLEY RD NW  ST ALBANS TWP -",
        "CALL:FIRE - HOUSE/ MOBILE HOME -SINGLE",
        "ADDR:5598 RACCOON VALLEY RD NW",
        "CITY:ST ALBANS TWP");

    doTest("T4",
        "LC911:- Nature: HEMMORAGE/LACERATION - Location:     250.00 WOODGATE CT   JOHNSTOWN -",
        "CALL:HEMMORAGE/LACERATION",
        "ADDR:250 WOODGATE CT",
        "CITY:JOHNSTOWN");

    doTest("T5",
        "LC911:- Nature: ILLNESS - NON SPECIFIC - Location:      65.00 S WILLIAMS ST  Suite:APT 102 JOHNSTOWN",
        "CALL:ILLNESS - NON SPECIFIC",
        "ADDR:65 S WILLIAMS ST",
        "APT:102",
        "CITY:JOHNSTOWN");

    doTest("T6",
        "LC911:- Nature: ILLNESS - NON SPECIFIC - Location:      65.00 S WILLIAMS ST  Suite:APT 102 JOHNSTOWN",
        "CALL:ILLNESS - NON SPECIFIC",
        "ADDR:65 S WILLIAMS ST",
        "APT:102",
        "CITY:JOHNSTOWN");

    doTest("T7",
        "LC911:- Nature: HEMMORAGE/LACERATION - Location:     250.00 WOODGATE CT   JOHNSTOWN",
        "CALL:HEMMORAGE/LACERATION",
        "ADDR:250 WOODGATE CT",
        "CITY:JOHNSTOWN");

    doTest("T8",
        "LC911:- Nature: DIABETIC PROBLEMS - Location:     406.00 HILLVIEW DR   JOHNSTOWN -",
        "CALL:DIABETIC PROBLEMS",
        "ADDR:406 HILLVIEW DR",
        "CITY:JOHNSTOWN");

    doTest("T9",
        "LC911:- Nature: CHOKING - Location:     155.00  CLARK DR JOHNSTOWN -",
        "CALL:CHOKING",
        "ADDR:155 CLARK DR",
        "CITY:JOHNSTOWN");
    
  }
  
  @Test
  public void testCoreyWeekly() {

    doTest("T1",
        "LC911:[4597]-- - Nature: SICK PERSON (SPECIFIC DIAGNOSIS) - Location: 277.00 N HIGH ST HEBRON - Comments:",
        "CALL:SICK PERSON (SPECIFIC DIAGNOSIS)",
        "ADDR:277 N HIGH ST",
        "CITY:HEBRON");

  }
  
  public static void main(String[] args) {
    new OHLickingCountyParserTest().generateTests("T1", "CALL ADDR APT CITY INFO");
  }
}