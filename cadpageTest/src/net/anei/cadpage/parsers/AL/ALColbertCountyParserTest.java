package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class ALColbertCountyParserTest extends BaseParserTest {
  
  public ALColbertCountyParserTest() {
    setParser(new ALColbertCountyParser(), "COLBERT COUNTY", "AL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MISSING PERSON\n 2564150099\n3804 HATCH BLVD, SHEFFIELD",
        "CALL:MISSING PERSON",
        "PHONE:2564150099",
        "ADDR:3804 HATCH BLVD",
        "CITY:SHEFFIELD");

    doTest("T2",
        "SUICIDAL PERSON\n 6622123327\n105 FORREST DR, CHEROKEE\n43 YOF",
        "CALL:SUICIDAL PERSON",
        "PHONE:6622123327",
        "ADDR:105 FORREST DR",
        "CITY:CHEROKEE",
        "INFO:43 YOF");

    doTest("T3",
        "BREATHING PROBLEM\nCHEROKEE FAMILY CLINIC 2563594516\n1080 2ND ST, CHEROKEE\n62 YOF",
        "CALL:BREATHING PROBLEM",
        "NAME:CHEROKEE FAMILY CLINIC",
        "PHONE:2563594516",
        "ADDR:1080 2ND ST",
        "CITY:CHEROKEE",
        "INFO:62 YOF");

    doTest("T4",
        "SEIZURE\n 2568566665\n8685 HIGHWAY 72, CHEROKEE\n21F",
        "CALL:SEIZURE",
        "PHONE:2568566665",
        "ADDR:8685 HIGHWAY 72",
        "CITY:CHEROKEE",
        "INFO:21F");

    doTest("T5",
        "MISSING PERSON\nATKISSON, TAMARA 2564123685\n603 PASADENA AV, A, MUSCLE SHOALS",
        "CALL:MISSING PERSON",
        "NAME:ATKISSON, TAMARA",
        "PHONE:2564123685",
        "ADDR:603 PASADENA AV",
        "MADDR:603 PASADENA AVE",
        "APT:A",
        "CITY:MUSCLE SHOALS");

    doTest("T6",
        "MVC-Injury\n 2564125319\nWOODWARD AV && 6TH ST, MUSCLE SHOALS\n2 CARS",
        "CALL:MVC-Injury",
        "PHONE:2564125319",
        "ADDR:WOODWARD AV & 6TH ST",
        "MADDR:WOODWARD AVE & 6TH ST",
        "CITY:MUSCLE SHOALS",
        "INFO:2 CARS");
    
  }
  
  public static void main(String[] args) {
    new ALColbertCountyParserTest().generateTests("T1");
  }
}
