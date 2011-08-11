package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXBellCountyParserTest extends BaseParserTest {
  
  public TXBellCountyParserTest() {
    setParser(new TXBellCountyParser(), "BELL COUNTY", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "LOC: 640 SCARLET OAK DR BELL TYPE CODE: STRUCT SubType: CALLER NAME: CLRNUM: TIME: 14:35:00 Comments: AC UNIT ON FIRE",
        "ADDR:640 SCARLET OAK DR",
        "CALL:STRUCT",
        "INFO:AC UNIT ON FIRE");

    doTest("T2",
        "LOC: CHAPPARAL RD/E TRIMMIER RD BELL TYPE CODE: TTA SubType: CALLER NAME: CLAY/CBF&R 513 CLRNUM: 830-426-0696 TIME: 15:38:34 Comments: TX 8304260696 -097.690451 +031.030079 CALLED IN BY A CENTAL BELL FIRE &RECUE NOT BLOCKING, BOTH VEH IN DIRT 5 INDIVIDUAL INVOLVED - 4 FEM, 1 MALE 2 VEH ACC Number of patients: 5 Age: Unknown Range Gender: Unknown Conscious: Unknown Breathing: Unknown ProQA chief complaint code: 29 Responder script: Age unknown, 2 VEH ACC. RED HYUNDAI SEDAN VS TAN SUBURBAN SUBURBAN RADIATOR IS LEAKING AIRBAG DEPLOYED ON SEDAN",
        "ADDR:CHAPARRAL RD & E TRIMMIER RD",
        "CALL:TTA",
        "NAME:CLAY/CBF&R 513",
        "PHONE:830-426-0696",
        "INFO:TX 8304260696 -097.690451 +031.030079 CALLED IN BY A CENTAL BELL FIRE &RECUE NOT BLOCKING, BOTH VEH IN DIRT 5 INDIVIDUAL INVOLVED - 4 FEM, 1 MALE 2 VEH ACC Number of patients: 5 Age: Unknown Range Gender: Unknown Conscious: Unknown Breathing: Unknown ProQA chief complaint code: 29 Responder script: Age unknown, 2 VEH ACC. RED HYUNDAI SEDAN VS TAN SUBURBAN SUBURBAN RADIATOR IS LEAKING AIRBAG DEPLOYED ON SEDAN");

    doTest("T3",
        "LOC: CHAPPARAL RD/SCARLET OAK DR BELL TYPE CODE: GRASS SubType: CITY CALLER NAME: SW 706 CLRNUM:  TIME: 17:50:51",
        "ADDR:CHAPARRAL RD & SCARLET OAK DR",
        "CALL:GRASS - CITY",
        "NAME:SW 706");

    doTest("T4",
        "LOC: 512 CEDAR RIDGE CR BELL TYPE CODE: GRASS SubType: COUNTY CALLER NAME:  CLRNUM:  TIME: 19:22:52",
        "ADDR:512 CEDAR RIDGE CR",
        "CALL:GRASS - COUNTY");

    doTest("T5",
        "LOC: 3465 UPTON DR BELL TYPE CODE: AL SubType: FIRE CALLER NAME: SARAH/STROUD CLRNUM: 8566-885-4634 TIME: 03:13:58 Comments:  ** Event not created for uncovered group CCFD/CCFD GENERAL FIRE RESIDENCE PREMISE PETER & JULIE PETERSON 254-518-5845 PENDING CONTACT '",
        "ADDR:3465 UPTON DR",
        "CALL:AL - FIRE",
        "NAME:SARAH/STROUD",
        "PHONE:8566-885-4634",
        "INFO:** Event not created for uncovered group CCFD/CCFD GENERAL FIRE RESIDENCE PREMISE PETER & JULIE PETERSON 254-518-5845 PENDING CONTACT '");
 
  }
  
  public static void main(String[] args) {
    new TXBellCountyParserTest().generateTests("T1");
  }
}
