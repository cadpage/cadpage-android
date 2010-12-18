package net.anei.cadpage.parsers;

import org.junit.Test;


public class COAdamsCountyParserTest extends BaseParserTest {
  
  public COAdamsCountyParserTest() {
    setParser(new COAdamsCountyParser(), "ADAMS COUNTY", "CO");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "Subject:IPS I/Page Notification E 64TH AVE/MONACO ST ADAM CCPD 09:51:48 TYPE CODE: ACCI CALLER NAME: TIME: 09:51:48 Comments: -104.90947",
        "ADDR:E 64TH AVE & MONACO ST",
        "CALL:ACCI");
    
    doTest("T2",
        "Subject:IPS I/Page Notification 6950 NIAGARA ST ADAM CCPD 11:04:10 TYPE CODE: EMS CALLER NAME: FELIX - 13YO TIME: 11:04:10 Comments: 15YO",
        "ADDR:6950 NIAGARA ST",
        "CALL:EMS");
    
    doTest("T3",
        "Subject:IPS I/Page Notification 10220 BRIGHTON RD ADAM CCPD:DIVERSIFIES TRUCK AND RV 17:22:11 TYPE CODE: NONSTR CALLER NAME: BOB TIME: 17:",
        "ADDR:10220 BRIGHTON RD",
        "CALL:NONSTR");
      
    doTest("T4",
        "Subject:IPS I/Page Notification US HIGHWAY 85 NB/E 77TH AVE ADAM ADAM 03:34:04 TYPE CODE: NONSTR CALLER NAME: ASHLEY TIME: 03:34:04 Commen",
        "ADDR:US HIGHWAY 85 NB & E 77TH AVE",
        "CALL:NONSTR");
    
    doTest("T5",
        "Subject:IPS I/Page Notification 9900 E 102ND AVE ADAM CCPD:USF 06:06:49 TYPE CODE: FRALRM CALLER NAME: ADT TIME: 06:06:49 Comments: WATER",
        "ADDR:9900 E 102ND AVE",
        "CALL:FRALRM");
    
  }
}