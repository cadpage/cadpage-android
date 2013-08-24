package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDAlleganyCountyParser;

import org.junit.Test;

/*    
Allegheney County, MD
Contact: Chris Green <mediccgreen@gmail.com>
Contact: Joseph Hoffman <jphoffman0@frostburg.edu>
Sender:acgov_911_cad@allconet.org

S:CAD M:CT:BREATHING DIFFICULTY 100 BRADDOCK HTS APT 105  BOX:F1601 DUE:A355\n\n
FRM:acgov_911_cad@allconet.org\nSUBJ:CAD\nMSG:CT:BREATHING DIFFICULTY 100 BRADDOCK HTS APT 105  BOX:F1601 DUE:A355
FRM:acgov_911_cad@allconet.org\nSUBJ:CAD\nMSG:CT:CHEST PAINS, HEART FROSTBURG VILLAGE NURSING HOME  1 KAYLOR CIR  BOX:F1602 DUE:A364\n\n

Contact: kenny haught <haught65@gmail.com>
S:CAD M:15:31 #058516 BEHAVORIAL EMERGENCY 20960 MARYLAND HW  BOX:F3601 DUE:CO36 A351 M512\n\n

Contact: Jeremy Athey <athey9014@yahoo.com>
Sender: acgov_911_cad@allconet.org
S:CAD M:03:16 #024484 BREATHING DIFFICULTY 12030 IRIS AVE SW  BOX:F0801 DUE:A396\n\n

Contact: Jeremy <athey9014@yahoo.com>
Contact: "Roger Bennett" <rbennett@allconet.org>  (AllCoNet.org) (Dispatch center)
Sender: acgov_911_cad@allconet.org
S:CAD M:08:26 #047678 BEHAVORIAL EMERGENCY 12037 IRIS AVE SW  BOX:F0801 DUE:A396 M514\n\n\n
S:CAD M:12:56 #038525 CHEST PAINS, HEART 12002 BOWLING ST SW  BOX:F0803 DUE:A396 MED08 MED09\n\n
S:CAD M:21:08 #038431 MEDICAL EMERGENCY 13103 QUARRY RIDGE RD SW  BOX:F0902 DUE:CO09 A396\n\n
S:CAD M:21:02 #038765 STROKE/CVA 14512 BARTON BLVD SW  BOX:F0904 DUE:A396\n \n 
S:CAD M:00:02 #038632 MEDICAL EMERGENCY 15201 TRAIL RIDGE RD SW  BOX:F0903 DUE:CO09 A396\n \n

*/

public class MDAlleganyCountyParserTest extends BaseParserTest {
  
  public MDAlleganyCountyParserTest() {
    setParser(new MDAlleganyCountyParser(), "ALLEGANY COUNTY", "MD");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "S:CAD M:CT:BREATHING DIFFICULTY 100 BRADDOCK HTS APT 105  BOX:F1601 DUE:A355\n\n",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:100 BRADDOCK HTS",
        "APT:105",
        "BOX:F1601",
        "UNIT:A355");

    doTest("T2",
        "FRM:acgov_911_cad@allconet.org\nSUBJ:CAD\nMSG:CT:BREATHING DIFFICULTY 100 BRADDOCK HTS APT 105  BOX:F1601 DUE:A355",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:100 BRADDOCK HTS",
        "APT:105",
        "BOX:F1601",
        "UNIT:A355");

    doTest("T3",
        "FRM:acgov_911_cad@allconet.org\nSUBJ:CAD\nMSG:CT:CHEST PAINS, HEART FROSTBURG VILLAGE NURSING HOME  1 KAYLOR CIR  BOX:F1602 DUE:A364\n\n",
        "CALL:CHEST PAINS, HEART FROSTBURG VILLAGE NURSING HOME",
        "ADDR:1 KAYLOR CIR",
        "BOX:F1602",
        "UNIT:A364");
 }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "S:CAD M:15:31 #058516 BEHAVORIAL EMERGENCY 20960 MARYLAND HW  BOX:F3601 DUE:CO36 A351 M512\n\n",
        "TIME:15:31",
        "ID:058516",
        "CALL:BEHAVORIAL EMERGENCY",
        "ADDR:20960 MARYLAND HW",
        "MADDR:20960 MARYLAND HWY",
        "BOX:F3601",
        "UNIT:CO36 A351 M512");

  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "S:CAD M:03:16 #024484 BREATHING DIFFICULTY 12030 IRIS AVE SW  BOX:F0801 DUE:A396\n\n",
        "TIME:03:16",
        "ID:024484",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:12030 IRIS AVE SW",
        "BOX:F0801",
        "UNIT:A396");
  }
  @Test
  public void testParser4() {

    doTest("T1",
        "S:CAD M:08:26 #047678 BEHAVORIAL EMERGENCY 12037 IRIS AVE SW  BOX:F0801 DUE:A396 M514\n\n\n",
        "TIME:08:26",
        "ID:047678",
        "CALL:BEHAVORIAL EMERGENCY",
        "ADDR:12037 IRIS AVE SW",
        "BOX:F0801",
        "UNIT:A396 M514");

    doTest("T2",
        "S:CAD M:12:56 #038525 CHEST PAINS, HEART 12002 BOWLING ST SW  BOX:F0803 DUE:A396 MED08 MED09\n\n",
        "TIME:12:56",
        "ID:038525",
        "CALL:CHEST PAINS, HEART",
        "ADDR:12002 BOWLING ST SW",
        "BOX:F0803",
        "UNIT:A396 MED08 MED09");

    doTest("T3",
        "S:CAD M:21:08 #038431 MEDICAL EMERGENCY 13103 QUARRY RIDGE RD SW  BOX:F0902 DUE:CO09 A396\n\n",
        "TIME:21:08",
        "ID:038431",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:13103 QUARRY RIDGE RD SW",
        "BOX:F0902",
        "UNIT:CO09 A396");

    doTest("T4",
        "S:CAD M:21:02 #038765 STROKE/CVA 14512 BARTON BLVD SW  BOX:F0904 DUE:A396\n \n ",
        "TIME:21:02",
        "ID:038765",
        "CALL:STROKE/CVA",
        "ADDR:14512 BARTON BLVD SW",
        "BOX:F0904",
        "UNIT:A396");

    doTest("T5",
        "S:CAD M:00:02 #038632 MEDICAL EMERGENCY 15201 TRAIL RIDGE RD SW  BOX:F0903 DUE:CO09 A396\n \n",
        "TIME:00:02",
        "ID:038632",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:15201 TRAIL RIDGE RD SW",
        "BOX:F0903",
        "UNIT:CO09 A396");

  }
  
  public static void main(String[] args) {
    new MDAlleganyCountyParserTest().generateTests("T1");
  }
}