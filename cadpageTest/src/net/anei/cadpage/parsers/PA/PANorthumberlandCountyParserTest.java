package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PANorthumberlandCountyParserTest extends BaseParserTest {
  
  public PANorthumberlandCountyParserTest() {
    setParser(new PANorthumberlandCountyParser(), "NORTHUMBERLAND COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "desc STHY 147 & BRUSH VALLEY RD * UPA * ACCIDENT - MVA WITH UNKNOWN INJURY(S) * Dispatch: CH 503,TK 542,MICU 545,ENG 721,CH 723,SQ 723,CH 721,ENG 541,SQ 553,SQ 581,RES 552,AMB 547,CH 722,CH 505,BR 724 affected loc AMB 547,MICU 545,ENG 541,RES 552,SQ 581,CH 721,CH 722,CH 723,ENG 721,SQ 723,CH 503,CH 505,BR 724,TK 542,SQ 553",
        "ADDR:STHY 147 & BRUSH VALLEY RD",
        "MADDR:ST 147 & BRUSH VALLEY RD",
        "CITY:UPPER AUGUSTA TWP",
        "CALL:ACCIDENT - MVA WITH UNKNOWN INJURY(S)",
        "UNIT:CH 503,TK 542,MICU 545,ENG 721,CH 723,SQ 723,CH 721,ENG 541,SQ 553,SQ 581,RES 552,AMB 547,CH 722,CH 505,BR 724 affected loc AMB 547,MICU 545,ENG 541,RES 552,SQ 581,CH 721,CH 722,CH 723,ENG 721,SQ 723,CH 503,CH 505,BR 724,TK 542,SQ 553");

    doTest("T2",
        "desc 202 E PINE ST * YSE * FIRE - DWELLING - 2ND ALARM * Dispatch: ENG 561,TK 542,RES 735,MICU 545,ENG 572,SQ 563,UN 548,CH 505,RH 544 affected loc UN 548",
        "ADDR:202 E PINE ST",
        "CITY:YSE",
        "CALL:FIRE - DWELLING - 2ND ALARM",
        "UNIT:ENG 561,TK 542,RES 735,MICU 545,ENG 572,SQ 563,UN 548,CH 505,RH 544 affected loc UN 548");

    doTest("T3",
        "LINCOLN ST & MEMORIAL DR * SUN * CARBON MONOXIDE INCIDENT * Dispatch: CH 503,CH 504,TK 542,ENG 531,SQ 581,MICU 91,ENG 572,CH 501,CH 502",
        "ADDR:LINCOLN ST & MEMORIAL DR",
        "CITY:SUNBURY",
        "CALL:CARBON MONOXIDE INCIDENT",
        "UNIT:CH 503,CH 504,TK 542,ENG 531,SQ 581,MICU 91,ENG 572,CH 501,CH 502");

    doTest("T4",
        "330 S SHAMOKIN ST * SHA * FIRE - VEHICLE (CAR/SUV/VAN/ETC...) * Dispatch: FP 80,ENG 41,S/CH 4,ENG 11,S/CH 1 ,SH 21,S/CH 3,RES 62 ENG 11,SH 21,S/CH 3,RES 62,FP 80",
        "ADDR:330 S SHAMOKIN ST",
        "CITY:SHAMOKIN",
        "CALL:FIRE - VEHICLE (CAR/SUV/VAN/ETC...)",
        "UNIT:FP 80,ENG 41,S/CH 4,ENG 11,S/CH 1 ,SH 21,S/CH 3,RES 62 ENG 11,SH 21,S/CH 3,RES 62,FP 80");

    doTest("T5",
        "S ANTHRACITE ST & W HIGH ST * SHA * FIRE - BRUSH * Dispatch: FP 80,ENG 41,BR 153,S/CH 4,SQ 21,ENG 11,S/CH 1 ,SH 21,S/CH 3,S/CH 2,RES 62 SH 21",
        "ADDR:S ANTHRACITE ST & W HIGH ST",
        "CITY:SHAMOKIN",
        "CALL:FIRE - BRUSH",
        "UNIT:FP 80,ENG 41,BR 153,S/CH 4,SQ 21,ENG 11,S/CH 1 ,SH 21,S/CH 3,S/CH 2,RES 62 SH 21");

    doTest("T6",
        "204 MAIN ST * COA * STAND-BY ASSIGNMENT * Dispatch: ENG 141,ENG 41,ENG1,TK 32,AT 21,MICU 90,UT 195,SQ 66,ENG 294,A/L 36,ENG 161,SH 21,RES 62,AMB 923 AMB 923,MICU 90,AT 21,ENG 141,ENG 161,UT 195,ENG1,ENG 294,SH 21,TK 32,ENG 41,RES 62",
        "ADDR:204 MAIN ST",
        "CITY:COAL",
        "CALL:STAND-BY ASSIGNMENT",
        "UNIT:ENG 141,ENG 41,ENG1,TK 32,AT 21,MICU 90,UT 195,SQ 66,ENG 294,A/L 36,ENG 161,SH 21,RES 62,AMB 923 AMB 923,MICU 90,AT 21,ENG 141,ENG 161,UT 195,ENG1,ENG 294,SH 21,TK 32,ENG 41,RES 62");

    doTest("T7",
        "19 N GRANT ST * SHA * FIRE - DWELLING - 1ST ALARM * Dispatch: FP 80,ENG 41,TK 32,S/CH 4,SQ 21,SQ 11,ENG 11,S/CH 1 ,ENG 51,SQ 66,AMB 919,SH 21,S/CH 3,S/CH 2,RES 62 ENG 11,SH 21,TK 32,ENG 41,ENG 51,RES 62,FP 80",
        "ADDR:19 N GRANT ST",
        "CITY:SHAMOKIN",
        "CALL:FIRE - DWELLING - 1ST ALARM",
        "UNIT:FP 80,ENG 41,TK 32,S/CH 4,SQ 21,SQ 11,ENG 11,S/CH 1 ,ENG 51,SQ 66,AMB 919,SH 21,S/CH 3,S/CH 2,RES 62 ENG 11,SH 21,TK 32,ENG 41,ENG 51,RES 62,FP 80");

    doTest("T8",
        "123 N FRANKLIN ST * SHA * FIRE - DWELLING - 1ST ALARM * Dispatch: FP 80,ENG 41,TK 32,S/CH 4,SQ 21,SQ 11,MICU 90\r",
        "ADDR:123 N FRANKLIN ST",
        "CITY:SHAMOKIN",
        "CALL:FIRE - DWELLING - 1ST ALARM",
        "UNIT:FP 80,ENG 41,TK 32,S/CH 4,SQ 21,SQ 11,MICU 90");
   
  }
  
  public static void main(String[] args) {
    new PANorthumberlandCountyParserTest().generateTests("T1");
  }
}