package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class VANewKentCountyParserTest extends BaseParserTest {
  
  public VANewKentCountyParserTest() {
    setParser(new VANewKentCountyParser(), "NEW KENT COUNTY", "VA");
  }
  
  @Test
  public void testTravisLongest() {

    doTest("T1",
        "MAILBOX:F3 ASSIST ANOTHER AGENCY KENTLAND TRL/COLONIAL DOWN CFS# 2012-018312",
        "SRC:F3",
        "CALL:ASSIST ANOTHER AGENCY",
        "ADDR:KENTLAND TRL & COLONIAL DOWN",
        "ID:2012-018312");
 
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "MAILBOX:F1 TEST ONLY 11995 COURTHOUSE CIR 0 CFS# 2012-017858",
        "SRC:F1",
        "CALL:TEST ONLY",
        "ADDR:11995 COURTHOUSE CIR",
        "ID:2012-017858");

    doTest("T2",
        "MAILBOX:F1 TEST ONLY 12025 COURTHOUSE CIR CFS# 2012-017860",
        "SRC:F1",
        "CALL:TEST ONLY",
        "ADDR:12025 COURTHOUSE CIR",
        "ID:2012-017860");

    doTest("T3",
        "MAILBOX:F1 TEST ONLY 4315 N COURTHOUSE RD CFS# 2012-017863",
        "SRC:F1",
        "CALL:TEST ONLY",
        "ADDR:4315 N COURTHOUSE RD",
        "ID:2012-017863");

    doTest("T4",
        "MAILBOX:F1 TEST ONLY 3511 OLIVET CHURCH RD CFS# 2012-017862",
        "SRC:F1",
        "CALL:TEST ONLY",
        "ADDR:3511 OLIVET CHURCH RD",
        "ID:2012-017862");

    doTest("T5",
        "MAILBOX:F1 TEST ONLY 12001 COURTHOUSE CIR CFS# 2012-017861",
        "SRC:F1",
        "CALL:TEST ONLY",
        "ADDR:12001 COURTHOUSE CIR",
        "ID:2012-017861");

    doTest("T6",
        "MAILBOX:F1 SICK (UNKNOWN MEDICAL) 15460 POCAHONTAS TRL CFS# 2012-017864",
        "SRC:F1",
        "CALL:SICK (UNKNOWN MEDICAL)",
        "ADDR:15460 POCAHONTAS TRL",
        "ID:2012-017864");

    doTest("T7",
        "MAILBOX:F3 VEHICLE FIRE 220 WB 64 CFS# 2012-017867",
        "SRC:F3",
        "CALL:VEHICLE FIRE",
        "ADDR:220 WB 64",
        "MADDR:220 64",
        "ID:2012-017867");

    doTest("T8",
        "MAILBOX:F1 SEIZURE/CONVULSIONS 9100 POCAHONTAS TRL CFS# 2012-017875",
        "SRC:F1",
        "CALL:SEIZURE/CONVULSIONS",
        "ADDR:9100 POCAHONTAS TRL",
        "ID:2012-017875");

    doTest("T9",
        "MAILBOX:F3 RESIDENTIAL FIRE ALARM 9818 TUNSTALL RD CFS# 2012-017894",
        "SRC:F3",
        "CALL:RESIDENTIAL FIRE ALARM",
        "ADDR:9818 TUNSTALL RD",
        "ID:2012-017894");

    doTest("T10",
        "MAILBOX:F3 BREATHING DIFFICULTY 7701 PARHAM LANDING RD CFS# 2012-017897",
        "SRC:F3",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:7701 PARHAM LANDING RD",
        "ID:2012-017897");

    doTest("T11",
        "MAILBOX:F2 SUSPICIOUS SITUATION 8157 N HENPECK RD G CFS# 2012-017902",
        "SRC:F2",
        "CALL:SUSPICIOUS SITUATION",
        "ADDR:8157 N HENPECK RD G",
        "ID:2012-017902");

    doTest("T12",
        "MAILBOX:F2 CARDIAC (WITH HISTORY) 3447 RIDGE RD CFS# 2012-017921",
        "SRC:F2",
        "CALL:CARDIAC (WITH HISTORY)",
        "ADDR:3447 RIDGE RD",
        "ID:2012-017921");

    doTest("T13",
        "MAILBOX:F3 MOTOR VEHICLE ACCIDENT 33/EXXON CFS# 2012-018009",
        "SRC:F3",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:33 & EXXON",
        "ID:2012-018009");

    doTest("T14",
        "MAILBOX:F2 DEBRIS/TREE IN ROAD 000000 HENPECK/64 CFS# 2012-018017",
        "SRC:F2",
        "CALL:DEBRIS/TREE IN ROAD",
        "ADDR:HENPECK & 64",
        "ID:2012-018017");
 
  }
  
  public static void main(String[] args) {
    new VANewKentCountyParserTest().generateTests("T1");
  }
}