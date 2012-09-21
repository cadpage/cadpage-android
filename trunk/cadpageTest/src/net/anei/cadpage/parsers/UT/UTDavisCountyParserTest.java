package net.anei.cadpage.parsers.UT;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.UT.UTDavisCountyParser;

import org.junit.Test;


public class UTDavisCountyParserTest extends BaseParserTest {
  
  public UTDavisCountyParserTest() {
    setParser(new UTDavisCountyParser(), "DAVIS COUNTY", "UT");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
          "paging@co.davis.ut.us<http://us.mc330.mail.yahoo.com/mc/compose?to=paging@co.davis.ut.us>/\nDCSO / Fire Alarm Comm\n2645 N MAIN ST; 12D ACTION ZONE GYMNASTI\nKEY PAD / RP PENDING",
          "CALL:DCSO / Fire Alarm Comm",
          "ADDR:2645 N MAIN ST",
          "PLACE:12D ACTION ZONE GYMNASTI",
          "INFO:KEY PAD / RP PENDING");
    
    doTest("T2",
          "Child Birth\n2539 N 475 W; #B\n17:02:14 11/29/2010 - dmaples\nProQA Medical Recommended Dispatch Level = 24D5\n28 year old, Female, Conscious, B",
          "CALL:Child Birth",
          "ADDR:2539 N 475 W",
          "APT:#B",
          "INFO:28 year old, Female, Conscious, B");
    
    doTest("T3",
          "Pregnancy Prob\n2248 N 75 W\n22:20:36 11/28/2010 - carchbol\nProQA Medical Recommended Dispatch Level = 24D4\n19 year old, Female, Conscious, Br",
          "CALL:Pregnancy Prob",
          "ADDR:2248 N 75 W",
          "INFO:19 year old, Female, Conscious, Br");
    
    doTest("T4",
          "Fainting\n177 W 1850 N\n20:55:02 11/26/2010 - vjones\nProQA Medical Recommended Dispatch Level = 31D2\n75 year old, Male, Unconscious, Breathing",
          "CALL:Fainting",
          "ADDR:177 W 1850 N",
          "INFO:75 year old, Male, Unconscious, Breathing");
    
    doTest("T5",
          "Fainting\n1086 N 450 W\n20:23:18 11/26/2010 - ebutcher\nProQA Medical Recommended Dispatch Level = 31D4\n52 year old, Female, Conscious, Breathi",
          "CALL:Fainting",
          "ADDR:1086 N 450 W",
          "INFO:52 year old, Female, Conscious, Breathi");
    
    doTest("T6",
          "paging@co.davis.ut.us<http://us.mc330.mail.yahoo.com/mc/compose?to=paging@co.davis.ut.us>/\nDCSO / Acc PI Alpha\n2300 N MAIN ST\nNEG INJURIES, DODGE DURANGO, 2006 TOYT,\n16:14:58 11/24/2010 - D Bird\nIN THE TURNING LANE",
          "CALL:DCSO / Acc PI Alpha",
          "ADDR:2300 N MAIN ST",
          "INFO:NEG INJURIES, DODGE DURANGO, 2006 TOYT, IN THE TURNING LANE");
      
    doTest("T7",
          "paging@co.davis.ut.us<http://us.mc330.mail.yahoo.com/mc/compose?to=paging@co.davis.ut.us>/\nDCSO / Domestic\n31 W 1600 N; 8\nman & woman it has been physical, no weapons, alcohol involved, they are\nboth\noutside",
          "CALL:DCSO / Domestic",
          "ADDR:31 W 1600 N",
          "APT:8",
          "INFO:man & woman it has been physical, no weapons, alcohol involved, they are both outside");
      
    doTest("T8",
          "paging@co.davis.ut.us<http://us.mc330.mail.yahoo.com/mc/compose?to=paging@co.davis.ut.us>/\nDCSO / Medical Standby\n78 W 800 N\n.SUICIDAL TRYING TO GET A KNIFE",
          "CALL:DCSO / Medical Standby",
          "ADDR:78 W 800 N",
          "INFO:.SUICIDAL TRYING TO GET A KNIFE");
  }
}