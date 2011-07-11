package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAMonroevilleParserTest extends BaseParserTest {
  
  public PAMonroevilleParserTest() {
    setParser(new PAMonroevilleParser(), "MONROEVILLE", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[Alert: Sick Person]  ALRM LVL: 1\nLOC:\n538 FIRETHORN DR\nMONROEVILLE\nBTWN: FIELDSTONE DR & N/A\n\nRCVD AS Phone\n\nCOM:\n23Y/O FEMALE SICK / ALPHA\n\nCT:\nMD103 at",
        "CALL:Sick Person",
        "PRI:1",
        "ADDR:538 FIRETHORN DR",
        "CITY:MONROEVILLE",
        "X:FIELDSTONE DR & N/A",
        "INFO:23Y/O FEMALE SICK / ALPHA / MD103 at");

    doTest("T2",
        "[Alert: Breathing]  ALRM LVL: 1\nLOC:\n721 HEARTWOOD DR\nMONROEVILLE\nBTWN: COTTONWOOD DR & COTTONWOOD DR\n\nRCVD AS Phone\n\nCOM:\n94 YO FEMALE/DIFF BREATHING/3RD",
        "CALL:Breathing",
        "PRI:1",
        "ADDR:721 HEARTWOOD DR",
        "CITY:MONROEVILLE",
        "X:COTTONWOOD DR & COTTONWOOD DR",
        "INFO:94 YO FEMALE/DIFF BREATHING/3RD");

    doTest("T3",
        "[Alert: Fire-Alarm Activation]  ALRM LVL: 1\nLOC:\n245 AZALEA DR\nMONROEVILLE\nBTWN: GARDEN CITY DR & N/A\n\nRCVD AS Phone\n\nCOM:\n2ND FLOOR PULL STATION\n\nCT:\nMD10",
        "CALL:Fire-Alarm Activation",
        "PRI:1",
        "ADDR:245 AZALEA DR",
        "CITY:MONROEVILLE",
        "X:GARDEN CITY DR & N/A",
        "INFO:2ND FLOOR PULL STATION / MD10");

    doTest("T4",
        "[Alert: Sick Person]  ALRM LVL: 1\nLOC:\n540 FIRETHORN DR\nMONROEVILLE\nBTWN: FIELDSTONE DR & N/A\n\nRCVD AS Phone\n\nCOM:\n79 YOF HIGH TEMP, CHILLS, LETHARGIC. BRAvo",
        "CALL:Sick Person",
        "PRI:1",
        "ADDR:540 FIRETHORN DR",
        "CITY:MONROEVILLE",
        "X:FIELDSTONE DR & N/A",
        "INFO:79 YOF HIGH TEMP, CHILLS, LETHARGIC. BRAvo");

    doTest("T5",
        "[Alert: Sick Person]  ALRM LVL: 1\nLOC:\n3912 BARBARA ANN DR\nMONROEVILLE\nBTWN: EVERGREEN DR & N/A\n\nCOM:\n90Y/O MALE - FAMILY NOW WANTS PT TRANSPORTED TO HOS",
        "CALL:Sick Person",
        "PRI:1",
        "ADDR:3912 BARBARA ANN DR",
        "CITY:MONROEVILLE",
        "X:EVERGREEN DR & N/A",
        "INFO:90Y/O MALE - FAMILY NOW WANTS PT TRANSPORTED TO HOS");

    doTest("T6",
        "[Alert: Abdominal Pain]  ALRM LVL: 1\nLOC:\n166 KEEFER\nPENN HILLS\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n86Y/O MALE ABD PAIN / CHARLIE\n\nCT:\nMD103 at POS 01",
        "CALL:Abdominal Pain",
        "PRI:1",
        "ADDR:166 KEEFER",
        "CITY:PENN HILLS",
        "X:N/A & N/A",
        "INFO:86Y/O MALE ABD PAIN / CHARLIE / MD103 at POS 01");

    doTest("T7",
        "[Alert: Fall]  ALRM LVL: 1\nLOC:\n3912 BARBARA ANN DR\nMONROEVILLE\nBTWN: EVERGREEN DR & N/A\n\nRCVD AS Phone\n\nCOM:\n92 YO MALE/FELL/NOT BELIEVED TO BE INJURED/3R",
        "CALL:Fall",
        "PRI:1",
        "ADDR:3912 BARBARA ANN DR",
        "CITY:MONROEVILLE",
        "X:EVERGREEN DR & N/A",
        "INFO:92 YO MALE/FELL/NOT BELIEVED TO BE INJURED/3R");

    doTest("T8",
        "[Alert: Heart Problem]  ALRM LVL: 1\nLOC:\n205 HEATHER DR\nMONROEVILLE\nBTWN: DUFF RD & N/A\n\nRCVD AS Phone\n\nCOM:\nRAPID HEART BEAT\n87 YOF CARDIAC HX. CHARLIE",
        "CALL:Heart Problem",
        "PRI:1",
        "ADDR:205 HEATHER DR",
        "CITY:MONROEVILLE",
        "X:DUFF RD & N/A",
        "INFO:RAPID HEART BEAT / 87 YOF CARDIAC HX. CHARLIE");
  }
  
  public static void main(String[] args) {
    new PAMonroevilleParserTest().generateTests("T1");
  }
  
}
