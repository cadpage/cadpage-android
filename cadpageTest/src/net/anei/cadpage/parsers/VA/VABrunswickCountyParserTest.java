package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class VABrunswickCountyParserTest extends BaseParserTest {
  
  public VABrunswickCountyParserTest() {
    setParser(new VABrunswickCountyParser(), "BRUNSWICK COUNTY", "VA");
  }
  
  @Test
  public void testEarlysvillParser() {

    doTest("T1",
        "Subject:BCSO CFS Info - DO NOT REPLY\n11-019210 BREATHING DIFFICULTY \n493 BROOKS CROSSING \nGRIFFITH LN / LOBLOL/LY DR \nLAWRENCEVILLE",
        "ID:11-019210",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:493 BROOKS CROSSING",
        "X:GRIFFITH LN / LOBLOL/LY DR",
        "CITY:LAWRENCEVILLE");

    doTest("T2",
        "Subject:BCSO CFS Info - DO NOT REPLY\n11-019305 CHEST PAIN/HEART PROBLEM \n1562 GREENS CHAPEL RD \nMEREDITH MILL RD / G/RNADY RD \nBRODNA",
        "ID:11-019305",
        "CALL:CHEST PAIN/HEART PROBLEM",
        "ADDR:1562 GREENS CHAPEL RD",
        "X:MEREDITH MILL RD / G/RNADY RD",
        "CITY:BRODNAX");

    doTest("T3",
        "Subject:BCSO CFS Info - DO NOT REPLY\n11-019164 MOTOR VEHICLE CRASH \n1634-BLK LAWRENCEVILLE PLANK RD \nPOOR HOUSE RD / BRUNSWICK COMMONS DR",
        "ID:11-019164",
        "CALL:MOTOR VEHICLE CRASH",
        "ADDR:1634-BLK LAWRENCEVILLE PLANK RD",
        "MADDR:1634 LAWRENCEVILLE PLANK RD",
        "X:POOR HOUSE RD / BRUNSWICK COMMONS DR");

    doTest("T4",
        "Subject:BCSO CFS Info - DO NOT REPLY\n11-019197 STROKE \n1722 LAWRENCEVILLE PLANK RD \nPOOR HOUSE RD / BRUN/SWICK COMMONS CT \nENVOY HEAL",
        "ID:11-019197",
        "CALL:STROKE",
        "ADDR:1722 LAWRENCEVILLE PLANK RD",
        "X:POOR HOUSE RD / BRUN/SWICK COMMONS CT");

    doTest("T5",
        "Subject:BCSO CFS Info - DO NOT REPLY\n11-019208 UNCONSC/UNRESPONSIVE/SYNCOPE \n1904 LAWRENCEVILLE PLANK RD \nBRUNSWICK COMMONS CT// PLAN",
        "ID:11-019208",
        "CALL:UNCONSC/UNRESPONSIVE/SYNCOPE",
        "ADDR:1904 LAWRENCEVILLE PLANK RD",
        "X:BRUNSWICK COMMONS CT// PLAN");

    doTest("T6",
        "Subject:BCSO CFS Info - DO NOT REPLY\n11-019129 STRUCTURE FIRE \n4151 POOR HOUSE RD \nPINEY WOODS RD / DIG/UARDI DR \nJOHNSON GROVE RZUA",
        "ID:11-019129",
        "CALL:STRUCTURE FIRE",
        "ADDR:4151 POOR HOUSE RD",
        "X:PINEY WOODS RD / DIG/UARDI DR");

    doTest("T7",
        "Subject:BCSO CFS Info - DO NOT REPLY\n11-019208 UNCONSC/UNRESPONSIVE/SYNCOPE \n1904 LAWRENCEVILLE PLANK RD \nBRUNSWICK COMMONS CT// PLAN",
        "ID:11-019208",
        "CALL:UNCONSC/UNRESPONSIVE/SYNCOPE",
        "ADDR:1904 LAWRENCEVILLE PLANK RD",
        "X:BRUNSWICK COMMONS CT// PLAN");

    doTest("T8",
        "Subject:BCSO CFS Info - DO NOT REPLY\n11-019310 SEIZURES \n18597 CHRISTANNA HWY \nFOX LN / GREEN ACRES/RD \nLAWRENCEVILLE \n7FR 900",
        "ID:11-019310",
        "CALL:SEIZURES",
        "ADDR:18597 CHRISTANNA HWY",
        "X:FOX LN / GREEN ACRES/RD",
        "CITY:LAWRENCEVILLE",
        "INFO:7FR 900");

  }
  
  public static void main(String[] args) {
    new VABrunswickCountyParserTest().generateTests("T1");
  }
}