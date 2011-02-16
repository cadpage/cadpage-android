package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class KSButlerCountyParserTest extends BaseParserTest {
  
  public KSButlerCountyParserTest() {
    setParser(new KSButlerCountyParser(), "BUTLER COUNTY", "KS");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[Incident Notification]  17D FALL (MAP PAGE): 26E (ADDRESS): 1611 N FAIRWAY DR Augusta (CROSS ST): N CLUB HOUSE DR / E FAIRWAY CT (NARR):  ProQA Medical Questionnai",
        "CALL:17D FALL",
        "MAP:26E",
        "ADDR:1611 N FAIRWAY DR",
        "CITY:Augusta",
        "X:N CLUB HOUSE DR / E FAIRWAY CT",
        "INFO:ProQA Medical Questionnai");

    doTest("T2",
        "[Incident Notification]  6D DIFF BREATHING (MAP PAGE): 22C (ADDRESS): 524 S EMPORIA ST El Dorado (CROSS ST): W CAVE SPRINGS AVE / W LOCUST AVE (NARR): ProQA Medica",
        "CALL:6D DIFF BREATHING",
        "MAP:22C",
        "ADDR:524 S EMPORIA ST",
        "CITY:El Dorado",
        "X:W CAVE SPRINGS AVE / W LOCUST AVE",
        "INFO:ProQA Medica");

    doTest("T3",
        "(Incident Notification) 10D CHEST PAIN (MAP PAGE): 9 (ADDRESS): 5957 NE 80TH ST County (CROSS ST): NE ELLIS RD / NE HWY 177 (NARR):  ProQA Medical Questionnaire Co",
        "CALL:10D CHEST PAIN",
        "MAP:9",
        "ADDR:5957 NE 80TH ST County",
        "X:NE ELLIS RD / NE HWY 177",
        "INFO:ProQA Medical Questionnaire Co");

    doTest("T4",
        "(Incident Notification) 6E ECHO DIFF BREATH (MAP PAGE): 36F (ADDRESS): 218 E ROSEWOOD ST Rose Hill (CROSS ST): N MAIN ST / N MEEKER CT (NARR):  a  as fd3  es fd3",
        "CALL:6E ECHO DIFF BREATH",
        "MAP:36F",
        "ADDR:218 E ROSEWOOD ST",
        "CITY:Rose Hill",
        "X:N MAIN ST / N MEEKER CT",
        "INFO:a  as fd3  es fd3");

    doTest("T5",
        "(Incident Notification) 31D UNCONCIOUS (MAP PAGE): 15 (ADDRESS): 955 N HAVERHILL RD El Dorado (CROSS ST): W PIONEER DR / W 6TH AVE (NARR):  acting alittle confused",
        "CALL:31D UNCONCIOUS",
        "MAP:15",
        "ADDR:955 N HAVERHILL RD",
        "CITY:El Dorado",
        "X:W PIONEER DR / W 6TH AVE",
        "INFO:acting alittle confused");

    doTest("T6",
        "[Incident Notification]  13D DIABETIC EMERGENCY (MAP PAGE): 25B (ADDRESS): 726 N PROSPERITY LN Andover (CROSS ST): W ELLEN LN / DEAD END (NARR):  rp",
        "CALL:13D DIABETIC EMERGENCY",
        "MAP:25B",
        "ADDR:726 N PROSPERITY LN",
        "CITY:Andover",
        "X:W ELLEN LN / DEAD END",
        "INFO:rp");
 }
  
  public static void main(String[] args) {
    new KSButlerCountyParserTest().generateTests("T1");
  }
}
