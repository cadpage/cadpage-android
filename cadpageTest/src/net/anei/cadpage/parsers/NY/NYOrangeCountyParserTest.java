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

    doTest("T6",
        "DEPT13     TYP: MOTOR VEHICLE ACCIDT AD: 1166 US RTE 9W CTY: HIGHLANDS CN: MATTHREW CMT1: MOTORCYCLE DOWN AT THIS LOCATION TWO INJURIES.",
        "SRC:DEPT13",
        "CALL:MOTOR VEHICLE ACCIDT",
        "ADDR:1166 US RTE 9W",
        "CITY:HIGHLANDS",
        "NAME:MATTHREW",
        "INFO:MOTORCYCLE DOWN AT THIS LOCATION TWO INJURIES.");
 
    doTest("T7",
        "DEPTNM    ¿TYP: MEDICAL ASSISTANCE AD: 227 SUMMIT DR CTY: NEW WINDSOR CN: 173 CMT1: EDP TIME: 21:33 XST: 109 PARKDALE DR XST2: 43 ONA LN",
        "SRC:DEPTNM",
        "CALL:MEDICAL ASSISTANCE",
        "ADDR:227 SUMMIT DR",
        "CITY:NEW WINDSOR",
        "NAME:173",
        "INFO:EDP",
        "X:109 PARKDALE DR & 43 ONA LN");

    doTest("T8",
        "DEPT38 TYP: WIRES DOWN/BURNING AD: 54 RESERVOIR AVE CTY: PORT JERVIS CN: PJ PD CMT1: WIRES DOWN AND BURNING TIME: 04:52 XST: 4 CEDAR ST XST2: SKYLINE DR",
        "SRC:DEPT38",
        "CALL:WIRES DOWN/BURNING",
        "ADDR:54 RESERVOIR AVE",
        "CITY:PORT JERVIS",
        "NAME:PJ PD",
        "INFO:WIRES DOWN AND BURNING",
        "X:4 CEDAR ST & SKYLINE DR");

    doTest("T9",
        "DEPTWK     TYP: FALLS AD: 12 JOHNS RD CTY: WALLKILL CN: NAMARA, DANIEL F MC CMT1: MFALL/ POSS BROKEN ANKLE 61 YEAR OLD FEMALE CONSCIOUS B",
        "SRC:DEPTWK",
        "CALL:FALLS",
        "ADDR:12 JOHNS RD",
        "CITY:WALLKILL",
        "NAME:NAMARA, DANIEL F MC",
        "INFO:MFALL/ POSS BROKEN ANKLE 61 YEAR OLD FEMALE CONSCIOUS B");
  }
  
  public static void main(String[] args) {
    new NYOrangeCountyParserTest().generateTests("T10");
  }
}