package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Jackson County, IA
Contact: lyn medinger <medic354@gmail.com>
Sender: swmail@maquoketaia.com
System: Shieldware

S:Dispatch Center M:11-004602 GENERAL MEDICAL/AMBULANCE\n33618 MILL CREEK RD\n325 AVE / SIEVERDING/RIDGE RD\nBELLEVUE\nBEA1 BEF1\n\n\n
S:Dispatch Center M:11-004682 GENERAL MEDICAL/AMBULANCE\n208 N 12 ST\nSTATE ST / PARK ST/\nMEDICAL ASSOCIATES OF BELLEVUE  BELLEVUE\nBEA1\n\n\n
S:Dispatch Center M:11-004692 MOTOR VEH ACCIDENT W/INJURIES\nE 1 ST/ N MAIN ST\nST DONATUS\n49 8 BEA1 BEA2 BEF1\n\n\n

S:Dispatch Center M:11-004655 GENERAL MEDICAL/AMBULANCE\n1201 PARK ST\n12 ST / DEADEND/\nMILL VALLEY CARE CENTER  BELLEVUE\nBEA1\n\n\n
S:Dispatch Center M:11-004566 GENERAL MEDICAL/AMBULANCE\n109 E 1 ST\nCITYLIMITS / DUBILCH/EN ST\nST DONATUS\nBEA1 BEF1\n\n\n
S:Dispatch Center M:11-004406 GENERAL MEDICAL/AMBULANCE\n35109 370 ST\n346 AVE / 380 AVE/\nBELLEVUE\nBEA1 BEF1\n\n\n
S:Dispatch Center M:11-004340 GENERAL MEDICAL/AMBULANCE\n116 W MAIN ST\n1 ST / CITYLIMITS/\nSPRINGBROOK\nBEA1 SBF1\n\n\n
S:Dispatch Center M:11-004214 GENERAL MEDICAL/AMBULANCE\n401 N 6 ST\nFRANKLIN ST / SPRING/ST\nBELLEVUE\nBEA1\n\n\n

Contact: Lyn Medinger <lmedinger@co.jackson.ia.us>
Sender: swmail@maquoketaia.com
S:Dispatch Center M:12-014585 911 HANG UP \nReported: 10/15/2012 10:01:20 \n23266 33 ST \nDEADEND / 233 AVE \nMAQUOKETA \nMAA1 \n\n\n
S:Dispatch Center M:12-014621 GENERAL MEDICAL/AMBULANCE \nReported: 10/16/2012 05:47:55 \n402-215 ARCADE ST \nGERMAN ST / W G ROVE ST \nRIVER VILLAGE 1  MAQUOKETA \nMAA1 \n\n\n

Contact: zeimetr@yahoo.com
Sender: swmail@maquoketaia.com
S:Dispatch Center M:13-001384 MOTOR VEH ACCIDENT W/INJURIES \n Reported: 02/02/2013 22:16:05 \n 1336 335 AV CLINTON \n PRA1 PRF1
S:Dispatch Center M:13-001551 STRUCTURE FIRE \n Reported: 02/07/2013 19:42:43 \n 440 FERRY RD \n ALLEN ST / ORSON ST \n MILES \n MIF1 PRA1 PRF1

Contact: Kent Clasen <kclasen@akronbrass.com>
Sender: swmail@maquoketaia.com
( 1 of  2) S:Dispatch Center M:13-003989 STRUCTURE FIRE \nReported: 04/02/2013 15:05:01 \n17136 413 AV \n150 ST / 442 AV \nBELLEVUE \nBE

 */

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
        "X:325 AVE / SIEVERDING RIDGE RD",
        "CITY:BELLEVUE",
        "UNIT:BEA1 BEF1");

    doTest("T2",
        "S:Dispatch Center M:11-004682 GENERAL MEDICAL/AMBULANCE\n208 N 12 ST\nSTATE ST / PARK ST/\nMEDICAL ASSOCIATES OF BELLEVUE  BELLEVUE\nBEA1\n\n\n",
        "ID:11-004682",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "ADDR:208 N 12 ST",
        "X:STATE ST / PARK ST",
        "CITY:BELLEVUE",
        "PLACE:MEDICAL ASSOCIATES OF BELLEVUE",
        "UNIT:BEA1");

    doTest("T3",
        "S:Dispatch Center M:11-004692 MOTOR VEH ACCIDENT W/INJURIES\nE 1 ST/ N MAIN ST\nST DONATUS\n49 8 BEA1 BEA2 BEF1\n\n\n",
        "ID:11-004692",
        "CALL:MOTOR VEH ACCIDENT W/INJURIES",
        "ADDR:E 1 ST & N MAIN ST",
        "CITY:ST DONATUS",
        "UNIT:49 8 BEA1 BEA2 BEF1");

    doTest("T4",
        "S:Dispatch Center M:11-004655 GENERAL MEDICAL/AMBULANCE\n1201 PARK ST\n12 ST / DEADEND/\nMILL VALLEY CARE CENTER  BELLEVUE\nBEA1\n\n\n",
        "ID:11-004655",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "ADDR:1201 PARK ST",
        "X:12 ST / DEADEND",
        "CITY:BELLEVUE",
        "PLACE:MILL VALLEY CARE CENTER",
        "UNIT:BEA1");

    doTest("T5",
        "S:Dispatch Center M:11-004566 GENERAL MEDICAL/AMBULANCE\n109 E 1 ST\nCITYLIMITS / DUBILCH/EN ST\nST DONATUS\nBEA1 BEF1\n\n\n",
        "ID:11-004566",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "ADDR:109 E 1 ST",
        "X:CITYLIMITS / DUBILCH EN ST",
        "CITY:ST DONATUS",
        "UNIT:BEA1 BEF1");

    doTest("T6",
        "S:Dispatch Center M:11-004406 GENERAL MEDICAL/AMBULANCE\n35109 370 ST\n346 AVE / 380 AVE/\nBELLEVUE\nBEA1 BEF1\n\n\n",
        "ID:11-004406",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "ADDR:35109 370 ST",
        "X:346 AVE / 380 AVE",
        "CITY:BELLEVUE",
        "UNIT:BEA1 BEF1");

    doTest("T7",
        "S:Dispatch Center M:11-004340 GENERAL MEDICAL/AMBULANCE\n116 W MAIN ST\n1 ST / CITYLIMITS/\nSPRINGBROOK\nBEA1 SBF1\n\n\n",
        "ID:11-004340",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "ADDR:116 W MAIN ST",
        "X:1 ST / CITYLIMITS",
        "CITY:SPRINGBROOK",
        "UNIT:BEA1 SBF1");

    doTest("T8",
        "S:Dispatch Center M:11-004214 GENERAL MEDICAL/AMBULANCE\n401 N 6 ST\nFRANKLIN ST / SPRING/ST\nBELLEVUE\nBEA1\n\n\n",
        "ID:11-004214",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "ADDR:401 N 6 ST",
        "X:FRANKLIN ST / SPRING ST",
        "CITY:BELLEVUE",
        "UNIT:BEA1");
  
  }
  
  @Test
  public void testLynMedinger() {

    doTest("T1",
        "S:Dispatch Center M:12-014585 911 HANG UP \nReported: 10/15/2012 10:01:20 \n23266 33 ST \nDEADEND / 233 AVE \nMAQUOKETA \nMAA1 \n\n\n",
        "ID:12-014585",
        "CALL:911 HANG UP",
        "DATE:10/15/2012",
        "TIME:10:01:20",
        "ADDR:23266 33 ST",
        "X:DEADEND / 233 AVE",
        "CITY:MAQUOKETA",
        "UNIT:MAA1");

    doTest("T2",
        "S:Dispatch Center M:12-014621 GENERAL MEDICAL/AMBULANCE \n" +
        "Reported: 10/16/2012 05:47:55 \n" +
        "402-215 ARCADE ST \n" +
        "GERMAN ST / W G ROVE ST \n" +
        "RIVER VILLAGE 1  MAQUOKETA \n" +
        "MAA1 \n\n\n",

        "ID:12-014621",
        "CALL:GENERAL MEDICAL/AMBULANCE",
        "DATE:10/16/2012",
        "TIME:05:47:55",
        "ADDR:402-215 ARCADE ST",
        "MADDR:402 ARCADE ST",
        "X:GERMAN ST / W G ROVE ST",
        "CITY:MAQUOKETA",
        "PLACE:RIVER VILLAGE 1",
        "UNIT:MAA1");
    
  }
  
  @Test
  public void testZeimetr() {

    doTest("T1",
        "S:Dispatch Center M:13-001384 MOTOR VEH ACCIDENT W/INJURIES \n Reported: 02/02/2013 22:16:05 \n 1336 335 AV CLINTON \n PRA1 PRF1",
        "ID:13-001384",
        "CALL:MOTOR VEH ACCIDENT W/INJURIES",
        "DATE:02/02/2013",
        "TIME:22:16:05",
        "ADDR:1336 335 AV",
        "MADDR:1336 335 AVE",
        "CITY:CLINTON",
        "UNIT:PRA1 PRF1");

    doTest("T2",
        "S:Dispatch Center M:13-001551 STRUCTURE FIRE \n" +
        " Reported: 02/07/2013 19:42:43 \n" +
        " 440 FERRY RD \n" +
        " ALLEN ST / ORSON ST \n" +
        " MILES \n" +
        " MIF1 PRA1 PRF1",

        "ID:13-001551",
        "CALL:STRUCTURE FIRE",
        "DATE:02/07/2013",
        "TIME:19:42:43",
        "ADDR:440 FERRY RD",
        "CITY:MILES",
        "X:ALLEN ST / ORSON ST",
        "UNIT:MIF1 PRA1 PRF1");

  }
  
  public static void main(String[] args) {
    new IAJacksonCountyParserTest().generateTests("T1");
  }
}