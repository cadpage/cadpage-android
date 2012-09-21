package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.TX.TXLongviewParser;

import org.junit.Test;


public class TXLongviewParserTest extends BaseParserTest {
  
  public TXLongviewParserTest() {
    setParser(new TXLongviewParser(), "LONGVIEW", "TX");
  }
  
  @Test
  public void testLongviewParser() {
    
    doTest("T1",
        "RC:Run# 30209/ *Non Life Emergency P/2/ Sick Person (Specific Diagnosis)/ 1102 FRANCIS/ EASTON/ 18:21/ <Unknown>/ bp issues-- dizzy spells-- P",
        "ID:30209",
        "CALL:*Non Life Emergency P/2/Sick Person (Specific Diagnosis)",
        "ADDR:1102 FRANCIS",
        "CITY:EASTON",
        "INFO:bp issues-- dizzy spells-- P");
    
    doTest("T2",
        "RC:Run# 29907/PR Event/Public Service/CRYSTAL FARMS RD///TATUM/19:15/////PR EVENT/ TATUM/Tatum vs Harmony////",
        "ID:29907",
        "CALL:PR Event/Public Service",
        "ADDR:CRYSTAL FARMS RD",
        "CITY:TATUM",
        "INFO:PR EVENT/TATUM/Tatum vs Harmony");
    
    doTest("T3",
        "RC:Run# 29793/*Non Life Emergency P/1/Falls/301 B FORREST ACRES///TATUM/22:18/////<Unknown>/////",
        "ID:29793",
        "CALL:*Non Life Emergency P/1/Falls",
        "ADDR:301 B FORREST ACRES",
        "CITY:TATUM");
    
    doTest("T4",
        "RC:Run# 29764/*Non Life Emergency P/1/Overdose / Poisoning (Ingestion)/1100 S ADAMS ST//Panola Apts: 32/CARTHAGE/17:23/////<Unknown>/////",
        "ID:29764",
        "CALL:*Non Life Emergency P/1/Overdose/Poisoning (Ingestion)",
        "ADDR:1100 S ADAMS ST",
        "APT:32",
        "CITY:CARTHAGE");
  }
  
  @Test
  public void testDaingerfieldParser() {

    doTest("T1",
        "[CAD - part 1 of 1]  RC:Run# 31754/*Non Life Emergency P/1/Chest Pain/204 MOUNTAIN VIEW///DAIGNERFEILD/02:13/////<Unknown>/////",
        "ID:31754",
        "CALL:*Non Life Emergency P/1/Chest Pain",
        "ADDR:204 MOUNTAIN VIEW",
        "CITY:DAIGNERFEILD");

    doTest("T2",
        "[CAD - part 1 of 1]  RC:Run# 31710/*Non Life Emergency P/1/Unconscious / Fainting (Near)/347 COUNTY ROAD 2101///DAINGERFIELD/13:31/////<Unknown>/had stent t",
        "ID:31710",
        "CALL:*Non Life Emergency P/1/Unconscious/Fainting (Near)",
        "ADDR:347 COUNTY ROAD 2101",
        "CITY:DAINGERFIELD",
        "INFO:had stent t");

    doTest("T3",
        "[CAD - part 1 of 1]  RC:Run# 31696/*Non Life Emergency P/1/Sick Person (Specific Diagnosis)/2246 COUNTY ROAD 4206///NAPLES/10:31/////<Unknown>/////",
        "ID:31696",
        "CALL:*Non Life Emergency P/1/Sick Person (Specific Diagnosis)",
        "ADDR:2246 COUNTY ROAD 4206",
        "CITY:NAPLES");

    doTest("T4",
        "[CAD - part 1 of 1]  RC:Run# 31669/*Non Life Emergency P/1/Falls/3000 FM 250///HUGHES SPRINGS/23:22/////<Unknown>/////",
        "ID:31669",
        "CALL:*Non Life Emergency P/1/Falls",
        "ADDR:3000 FM 250",
        "CITY:HUGHES SPRINGS");

    doTest("T5",
        "[CAD - part 1 of 1]  RC:Run# 31646/*Non Life Emergency P/2/Assault / Sexual Assault/1005 COUNTY ROAD 4214///DAINGERFIELD/17:30/////<Unknown>/pt was thrown d",
        "ID:31646",
        "CALL:*Non Life Emergency P/2/Assault/Sexual Assault",
        "ADDR:1005 COUNTY ROAD 4214",
        "CITY:DAINGERFIELD",
        "INFO:pt was thrown d");

    doTest("T6",
        "[CAD - part 1 of 1]  RC:Run# 31627/*Non Life Emergency P/1/Unconscious / Fainting (Near)/401 E HOUSTON ST///LINDEN/14:06/////<Unknown>/passed out////",
        "ID:31627",
        "CALL:*Non Life Emergency P/1/Unconscious/Fainting (Near)",
        "ADDR:401 E HOUSTON ST",
        "CITY:LINDEN",
        "INFO:passed out");

    doTest("T7",
        "[CAD - part 1 of 1]  RC:Run# 31414/PR Event/<None>/US HWY 67//N33 11.075 x W94 42.799/OMAHA/16:30/////PR EVENT/ PR EVENT/////",
        "ID:31414",
        "CALL:PR Event/<None>/US HWY 67",
        "ADDR:N33 11.075 x W94 42.799",
        "CITY:OMAHA",
        "INFO:PR EVENT/PR EVENT");

    doTest("T8",
        "[CAD - part 1 of 1]  RC:Run# 31394/*Non Scheduled Transfer/Routine Transfer/Titus Regional Medical Center//Wound Care/MOUNT PLEASANT/13:31/Omaha Health Care",
        "ID:31394",
        "CALL:*Non Scheduled Transfer/Routine Transfer/Titus Regional Medical Center",
        "ADDR:Wound Care",
        "CITY:MOUNT PLEASANT",
        "INFO:Omaha Health Care");

    doTest("T9",
        "[CAD - part 1 of 1]  RC:Run# 31315/*Non Life Emergency P/1/Chest Pain/1912 GUM SPRINGS RD///LONGVIEW/14:56/////<Unknown>/Camp RV park --////",
        "ID:31315",
        "CALL:*Non Life Emergency P/1/Chest Pain",
        "ADDR:1912 GUM SPRINGS RD",
        "CITY:LONGVIEW",
        "INFO:Camp RV park --");
    
  }
  
  public static void main(String[] args) {
    new TXLongviewParserTest().generateTests("T1", "ID CALL ADDR CITY INFO");
  }
}
