package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYOrangeCountyParser;

import org.junit.Test;


public class NYOrangeCountyParserTest extends BaseParserTest {
  
  public NYOrangeCountyParserTest() {
    setParser(new NYOrangeCountyParser(), "ORANGE COUNTY", "NY");
  }
  
  @Test
  public void testParser() {


    doTest("T1",
        "DEPTWK     TYP: MVA- UNKNOWN STATUS AD: ST RTE 17 W&EXIT 120 W OFF CTY: WALLKILL CN: RICHARD CMT1: CALLER REPORTS A 2 CAR MV",
        "SRC:DEPTWK",
        "CALL:MVA- UNKNOWN STATUS",
        "ADDR:ST RTE 17 W & EXIT 120 W OFF",
        "CITY:WALLKILL",
        "NAME:RICHARD",
        "INFO:CALLER REPORTS A 2 CAR MV");
    
    doTest("T2",
        "DEPTWK     TYP: FALLS APT: 621 AD: 121 DUNNING RD CTY: WALLKILL CN: MARGARET TENNISON CMT1: MVISITOR FELL IN PT ROOM ARM AND",
        "SRC:DEPTWK",
        "CALL:FALLS",
        "APT:621",
        "ADDR:121 DUNNING RD",
        "CITY:WALLKILL",
        "NAME:MARGARET TENNISON",
        "INFO:MVISITOR FELL IN PT ROOM ARM AND");
        
    doTest("T3",
        "DEPTWK     TYP: PSYCH EMERG BLD: 10 APT: 13B AD: 92 FITZGERALD DR CTY: WALLKILL CN: TRACZ, CAROLINE CMT1: \"SEND AS AN ALPHA",
        "SRC:DEPTWK",
        "CALL:PSYCH EMERG",
        "APT:10-13B",
        "ADDR:92 FITZGERALD DR",
        "CITY:WALLKILL",
        "NAME:TRACZ, CAROLINE",
        "INFO:\"SEND AS AN ALPHA");

    doTest("T4",
        "DEPTWK     TYP: MVA WITH INJURIES AD: 637 ST RTE 211 W CTY: WALLKILL CN: PAULIE SMITH CMT1: CAR OFF ROADWAY UNK INJURIES TIM",
        "SRC:DEPTWK",
        "CALL:MVA WITH INJURIES",
        "ADDR:637 ST RTE 211 W",
        "CITY:WALLKILL",
        "NAME:PAULIE SMITH",
        "INFO:CAR OFF ROADWAY UNK INJURIES");
    
    doTest("T5",
        "DEPTPB          TYP: MEDICAL ASSISTANCE AD: 1015 INDIAN SPRINGS RD CN: ULSTER 911 CMT1: REGISTRO RD AND REDDER RD / 67/M UPPER ABDOMIAL PAIN-ALS CALL / WALKER VA CMT2: LLEY FIRE DISTRICT TIME: 14:44",
        "SRC:DEPTPB",
        "CALL:MEDICAL ASSISTANCE",
        "ADDR:1015 INDIAN SPRINGS RD",
        "CITY:ULSTER COUNTY",
        "NAME:ULSTER 911",
        "INFO:REGISTRO RD AND REDDER RD / 67/M UPPER ABDOMIAL PAIN-ALS CALL / WALKER VA / LLEY FIRE DISTRICT");
  
  }
}