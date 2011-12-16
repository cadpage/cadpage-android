package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYErieCountyAParser;

import org.junit.Test;


public class NYErieCountyAParserTest extends BaseParserTest {
  
  public NYErieCountyAParserTest() {
    setParser(new NYErieCountyAParser(), "ERIE COUNTY", "NY");
    
    // This is for the test generator, For unit tests it will be reset
    // the the default value before each test run
    setFromAddress("9300xxxx");
  }
  
  @Test
  public void testAmhParser() {
    
    doTest("T1",
        "AMH 238 WESTFIELD RD EMS 79 YO F/  CHEST PAIN",
        "ADDR:238 WESTFIELD RD",
        "CALL:EMS 79 YO F / CHEST PAIN");
        
    doTest("T2",
        "AMH 52 ENDICOTT DR EMS 82 YO M",
        "ADDR:52 ENDICOTT DR",
        "CALL:EMS 82 YO M");
        
    doTest("T3",
        "AMH 670 LONGMEADOW RD EMS 71 Y/O F CHEST PAINS, DIFFICULTY BREATHING",
        "ADDR:670 LONGMEADOW RD",
        "CALL:EMS 71 Y / O F CHEST PAINS, DIFFICULTY BREATHING");
        
    doTest("T4",
        "AMH 3030 SHERIDAN DR EMS RM 146 58 M TROUBLE BREATHING",
        "ADDR:3030 SHERIDAN DR",
        "CALL:EMS RM 146 58 M TROUBLE BREATHING");
        
    doTest("T5",
        "AMH 35 ELM RD EMS 69M CHEST/ARM PAIN",
        "ADDR:35 ELM RD",
        "CALL:EMS 69M CHEST / ARM PAIN");
  }
  
  @Test
  public void testErieParser() {
    doTest("T1",
        "ALERT@ERIE.GOV FIRE CO-DETECTOR 262 MILLER ST APT: GARAGE LANCASTER TOWN CO DETECTOR ACTIV / NO SYMPTOMS",
        "CALL:FIRE CO-DETECTOR",
        "ADDR:262 MILLER ST",
        "APT:GARAGE",
        "CITY:LANCASTER TOWN",
        "INFO:CO DETECTOR ACTIV / NO SYMPTOMS");

    doTest("T2",
        "ALERT@ERIE.GOV EMS 4779 TRANSIT RD LANCASTER TOWN GREEN DODGE CALIBER 25 YO FEMALE FEELS AS THOUGH SHE MAY PASS OUT",
        "CALL:EMS",
        "ADDR:4779 TRANSIT RD",
        "CITY:LANCASTER TOWN",
        "INFO:GREEN DODGE CALIBER 25 YO FEMALE FEELS AS THOUGH SHE MAY PASS OUT");

    doTest("T3",
        "ALERT@ERIE.GOV EMS 4805 TRANSIT RD APT: 1106 LANCASTER TOWN EMS- 59 YO MALE, LEG PAIN AS A RESULT OF A FALL EARLIER",
        "CALL:EMS",
        "ADDR:4805 TRANSIT RD",
        "APT:1106",
        "CITY:LANCASTER TOWN",
        "INFO:EMS- 59 YO MALE, LEG PAIN AS A RESULT OF A FALL EARLIER");

    doTest("T4",
        "ALERT@ERIE.GOV EMS 48 BENTLEY CR LANCASTER TOWN 79 Y/O FEMALE LETHARGIC",
        "CALL:EMS",
        "ADDR:48 BENTLEY CR",
        "MADDR:48 BENTLEY CIR",
        "CITY:LANCASTER TOWN",
        "INFO:79 Y / O FEMALE LETHARGIC");
    
    doTest("T5",
        "ALERT@ERIE.GOV FIRE CO-DETECTOR 47 VIA DONATO E LANCASTER TOWN CO DETECTOR NO SYMPTOMS REFER TWIN DISTRICT FD",
        "CALL:FIRE CO-DETECTOR",
        "ADDR:47 VIA DONATO E",
        "CITY:LANCASTER TOWN",
        "INFO:CO DETECTOR NO SYMPTOMS REFER TWIN DISTRICT FD");

    doTest("T6",
        "ALERT@ERIE.GOV AMH KLEIN W RD&FOREST N RD MVA 2 CAR MVA - HEAD INJURY",
        "CALL:MVA 2 CAR MVA - HEAD INJURY",
        "ADDR:KLEIN W RD & FOREST N RD");

  }
  
  @Test
  public void testDepewParser() {
    setFromAddress("9300xxxxxx");

    doTest("T1",
        "NOTIFICATIONS 85 MANITOU ST DEPEW DEPEW FIRE DEPARTMENT- DAILY TEST",
        "CALL:NOTIFICATIONS",
        "ADDR:85 MANITOU ST",
        "CITY:DEPEW",
        "INFO:DEPEW FIRE DEPARTMENT- DAILY TEST");

    doTest("T2",
        "NOTIFICATIONS 85 MANITOU ST DEPEW CONDUCTED THE DAILY FIRE RADIO AND PAGER TEST",
        "CALL:NOTIFICATIONS",
        "ADDR:85 MANITOU ST",
        "CITY:DEPEW",
        "INFO:CONDUCTED THE DAILY FIRE RADIO AND PAGER TEST");

    doTest("T3",
        "4569 BROADWAY DEPEW COMMERCIAL FIRE ALARM COMING FROM THE BANQUET ROOM",
        "CALL:COMMERCIAL FIRE ALARM COMING FROM THE BANQUET ROOM",
        "ADDR:4569 BROADWAY",
        "CITY:DEPEW");
    
  }
  
  public static void main(String[] args) {
    new NYErieCountyAParserTest().generateTests("T6", "CALL ADDR APT CITY INFO");
  }
}