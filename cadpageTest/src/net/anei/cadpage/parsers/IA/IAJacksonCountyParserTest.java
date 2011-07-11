package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class IAJacksonCountyParserTest extends BaseParserTest {
  
  public IAJacksonCountyParserTest() {
    setParser(new IAJacksonCountyParser(), "JACKSON COUNTY", "IA");
  }
  
  @Test
  public void testParser() {


    doTest("T1",
        "S:Dispatch Center M:11-004602 GENERAL MEDICAL/AMBULANCE\n33618 MILL CREEK RD\n325 AVE / SIEVERDING/RIDGE RD\nBELLEVUE\nBEA1 BEF1\n\n\n",
        "ID:11-004602",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "ADDR:33618 MILL CREEK RD",
        "X:325 AVE / SIEVERDING/RIDGE RD",
        "CITY:BELLEVUE",
        "UNIT:BEA1 BEF1");

    doTest("T2",
        "S:Dispatch Center M:11-004682 GENERAL MEDICAL/AMBULANCE\n208 N 12 ST\nSTATE ST / PARK ST/\nMEDICAL ASSOCIATES OF BELLEVUE  BELLEVUE\nBEA1\n\n\n",
        "ID:11-004682",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "ADDR:208 N 12 ST",
        "X:STATE ST / PARK ST/",
        "CITY:BELLEVUE",
        "PLACE:MEDICAL ASSOCIATES OF BELLEVUE",
        "UNIT:BEA1");

    doTest("T3",
        "S:Dispatch Center M:11-004692 MOTOR VEH ACCIDENT W/INJURIES\nE 1 ST/ N MAIN ST\nST DONATUS\n49 8 BEA1 BEA2 BEF1\n\n\n",
        "ID:11-004692",
        "CALL:MOTOR VEH ACCIDENT W/INJURIES",
        "ADDR:E 1 ST & N MAIN ST",
        "X:ST DONATUS",
        "PLACE:49 8 BEA1 BEA2 BEF1");

    doTest("T4",
        "S:Dispatch Center M:11-004655 GENERAL MEDICAL/AMBULANCE\n1201 PARK ST\n12 ST / DEADEND/\nMILL VALLEY CARE CENTER  BELLEVUE\nBEA1\n\n\n",
        "ID:11-004655",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "ADDR:1201 PARK ST",
        "X:12 ST / DEADEND/",
        "CITY:BELLEVUE",
        "PLACE:MILL VALLEY CARE CENTER",
        "UNIT:BEA1");

    doTest("T5",
        "S:Dispatch Center M:11-004566 GENERAL MEDICAL/AMBULANCE\n109 E 1 ST\nCITYLIMITS / DUBILCH/EN ST\nST DONATUS\nBEA1 BEF1\n\n\n",
        "ID:11-004566",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "ADDR:109 E 1 ST",
        "X:CITYLIMITS / DUBILCH/EN ST",
        "CITY:ST DONATUS",
        "UNIT:BEA1 BEF1");

    doTest("T6",
        "S:Dispatch Center M:11-004406 GENERAL MEDICAL/AMBULANCE\n35109 370 ST\n346 AVE / 380 AVE/\nBELLEVUE\nBEA1 BEF1\n\n\n",
        "ID:11-004406",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "ADDR:35109 370 ST",
        "X:346 AVE / 380 AVE/",
        "CITY:BELLEVUE",
        "UNIT:BEA1 BEF1");

    doTest("T7",
        "S:Dispatch Center M:11-004340 GENERAL MEDICAL/AMBULANCE\n116 W MAIN ST\n1 ST / CITYLIMITS/\nSPRINGBROOK\nBEA1 SBF1\n\n\n",
        "ID:11-004340",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "ADDR:116 W MAIN ST",
        "X:1 ST / CITYLIMITS/",
        "CITY:SPRINGBROOK",
        "UNIT:BEA1 SBF1");

    doTest("T8",
        "S:Dispatch Center M:11-004214 GENERAL MEDICAL/AMBULANCE\n401 N 6 ST\nFRANKLIN ST / SPRING/ST\nBELLEVUE\nBEA1\n\n\n",
        "ID:11-004214",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "ADDR:401 N 6 ST",
        "X:FRANKLIN ST / SPRING/ST",
        "CITY:BELLEVUE",
        "UNIT:BEA1");
  
  }
  
  public static void main(String[] args) {
    new IAJacksonCountyParserTest().generateTests("T1");
  }
}