package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class ILRichlandCountyParserTest extends BaseParserTest {
  
  public ILRichlandCountyParserTest() {
    setParser(new ILRichlandCountyParser(), "RICHLAND COUNTY", "IL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FIRE/RESCUE - 5755 N SHIPLEY OLNEY - BARN ON FIRE",
        "SRC:FIRE/RESCUE",
        "ADDR:5755 N SHIPLEY",
        "CITY:OLNEY",
        "CALL:BARN ON FIRE");

    doTest("T2",
        "FIRE/RESCUE - DEERFARM/SHIPLEY -",
        "SRC:FIRE/RESCUE",
        "ADDR:DEERFARM & SHIPLEY",
        "CALL:ALERT");

    doTest("T3",
        "FIRE/RESCUE - S PALMER ST NOBLE -",
        "SRC:FIRE/RESCUE",
        "ADDR:S PALMER ST",
        "CITY:NOBLE",
        "CALL:ALERT");

    doTest("T4",
        "FIRE/RESCUE - 225 S PALMER ST NOBLE - VEH ON FIRE",
        "SRC:FIRE/RESCUE",
        "ADDR:225 S PALMER ST",
        "CITY:NOBLE",
        "CALL:VEH ON FIRE");

    doTest("T5",
        "FIRE/RESCUE - 4752 N SHIPLEY OLNEY -",
        "SRC:FIRE/RESCUE",
        "ADDR:4752 N SHIPLEY",
        "CITY:OLNEY",
        "CALL:ALERT");

    doTest("T6",
        "FIRE/RESCUE - 380 W SOUTH NOBLE - DAN ROBINSON REQUEST NOBLE FIRE RESPOND AS HE HAS A HOT ELCECTICAL SMELL COMING FROM HIS HALLWAY BELIVED TO BE THE ATTIC.",
        "SRC:FIRE/RESCUE",
        "ADDR:380 W SOUTH",
        "CITY:NOBLE",
        "INFO:DAN ROBINSON REQUEST NOBLE FIRE RESPOND AS HE HAS A HOT ELCECTICAL SMELL COMING FROM HIS HALLWAY BELIVED TO BE THE ATTIC.");

    doTest("T7",
        "FIRE/RESCUE - E PARKERSBURG LN - -",
        "SRC:FIRE/RESCUE",
        "ADDR:E PARKERSBURG LN",
        "CALL:ALERT");

    doTest("T8",
        "FIRE/RESCUE - 325N NOBLE - -",
        "SRC:FIRE/RESCUE",
        "ADDR:325N NOBLE",
        "CALL:ALERT");

    doTest("T9",
        "FIRE/RESCUE - 225 S PALMER ST NOBLE - VEH ON FIRE",
        "SRC:FIRE/RESCUE",
        "ADDR:225 S PALMER ST",
        "CITY:NOBLE",
        "CALL:VEH ON FIRE");

    doTest("T10",
        "FIRE/RESCUE - S PALMER ST NOBLE -",
        "SRC:FIRE/RESCUE",
        "ADDR:S PALMER ST",
        "CITY:NOBLE",
        "CALL:ALERT");

    doTest("T11",
        "FIRE/RESCUE - 5755 N SHIPLEY OLNEY - BARN ON FIRE",
        "SRC:FIRE/RESCUE",
        "ADDR:5755 N SHIPLEY",
        "CITY:OLNEY",
        "CALL:BARN ON FIRE");

    doTest("T12",
        "FIRE/RESCUE - 2631 E ELBOW LN NOBLE - - REC'D 911 CELL CALL OF A BRUSH OR FIELD FIRE. ORIGINAL CALL WAS N OF 450N AND BETWEEN 600E AND 700E. TONED OUT NFD. 2203 MCCORMICK CALLED AND ADV'D THAT ALAN WALKER HAD A CONTROLLED BURN LAST NIGHT AND IS NOT SURE IF THEY HAVE STARTED IT BACK UP THIS MORNING, BUT WILL BE RESPONDING TO CHECK. MN",
        "SRC:FIRE/RESCUE",
        "ADDR:2631 E ELBOW LN",
        "CITY:NOBLE",
        "INFO:REC'D 911 CELL CALL OF A BRUSH OR FIELD FIRE. ORIGINAL CALL WAS N OF 450N AND BETWEEN 600E AND 700E. TONED OUT NFD. 2203 MCCORMICK CALLED AND ADV'D THAT ALAN WALKER HAD A CONTROLLED BURN LAST NIGHT AND IS NOT SURE IF THEY HAVE STARTED IT BACK UP THIS MORNING, BUT WILL BE RESPONDING TO CHECK. MN");

    doTest("T13",
        "FIRE/RESCUE - 3772 E TWIN BRIDGE LN - -",
        "SRC:FIRE/RESCUE",
        "ADDR:3772 E TWIN BRIDGE LN",
        "CALL:ALERT");
   
  }
  
  public static void main(String[] args) {
    new ILRichlandCountyParserTest().generateTests("T1");
  }
}