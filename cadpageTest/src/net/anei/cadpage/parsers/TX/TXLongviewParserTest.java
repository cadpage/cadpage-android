package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.TX.TXLongviewParser;

import org.junit.Test;


public class TXLongviewParserTest extends BaseParserTest {
  
  public TXLongviewParserTest() {
    setParser(new TXLongviewParser(), "LONGVIEW", "TX");
  }
  
  @Test
  public void testParser() {
    
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
}
