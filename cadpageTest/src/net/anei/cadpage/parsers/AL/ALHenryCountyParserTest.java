package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.TestManagePreferences;
import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class ALHenryCountyParserTest extends BaseParserTest {
  
  public ALHenryCountyParserTest() {
    setParser(new ALHenryCountyParser(), "HENRY COUNTY", "AL");
    TestManagePreferences pmgr = getPreferences();
    pmgr.setTestOverrideFilter(false);
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MEDICAL EMERGENCY CO.RD. 405 @ CO.RD. 49 SOUTH OF 134 EAST FEMALE SUBJ FALLEN FROM HORSE... HAVING DIFFICULTY BREATHING",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:CO RD 405 & CO RD 49",
        "MADDR:CO 405 & CO 49",
        "INFO:SOUTH OF 134 EAST FEMALE SUBJ FALLEN FROM HORSE HAVING DIFFICULTY BREATHING");

    doTest("T2",
        "MEDICAL CALL 5526 CO. RD. 73 IN NEWVILLE 14 YO TOOK 15 TREDONE SUBJ. IS CONCIOUS AT THIS TIME.",
        "CALL:MEDICAL CALL",
        "ADDR:5526 CO RD 73",
        "MADDR:5526 CO 73",
        "CITY:NEWVILLE",
        "INFO:14 YO TOOK 15 TREDONE SUBJ IS CONCIOUS AT THIS TIME");

    doTest("T3",
        "FIRE ALARM ACTIVATION 506 HOLLY LANE SMOKE AND THERMAL HEAT DETECTOR DOES NOT ADV. SPECIFIC AREA INSIDE RESIDENCE.",
        "CALL:FIRE ALARM ACTIVATION",
        "ADDR:506 HOLLY LANE",
        "INFO:SMOKE AND THERMAL HEAT DETECTOR DOES NOT ADV SPECIFIC AREA INSIDE RESIDENCE");

    doTest("T4",
        "MEDICAL EMERG. 707 MITCHELL ST. DIARRHEA, VOMITING, FEVER, HISTORY DIABETES, HEART PROBLEMS.",
        "CALL:MEDICAL EMERG",
        "ADDR:707 MITCHELL ST",
        "INFO:DIARRHEA, VOMITING, FEVER, HISTORY DIABETES, HEART PROBLEMS");

    doTest("T5",
        "MEDICAL CALL 509 TERRACE DR. IN HEADLAND MALE PAT. DIFF. BREATHING FEEL AS IF HE IS ABOUT TO PASS OUT.,",
        "CALL:MEDICAL CALL",
        "ADDR:509 TERRACE DR",
        "CITY:HEADLAND",
        "INFO:MALE PAT DIFF BREATHING FEEL AS IF HE IS ABOUT TO PASS OUT ,");
  }
  
  public static void main(String[] args) {
    new ALHenryCountyParserTest().generateTests("T1", "CALL ADDR CITY INFO");
  }
  
}