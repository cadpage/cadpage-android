package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class VAWinchesterParserTest extends BaseParserTest {
  
  public VAWinchesterParserTest() {
    setParser(new VAWinchesterParser(), "WINCHESTER", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Winchester ECC info) 11-041989 INSIDE SMELL OR SMOKE\n336 GRAY AVE\nNATIONAL AVE / VIRGI/NIA AVE\nWINCHESTER\nBAT6 E4 E5 EC18 M41 TK2 W1 E",
        "CALL:INSIDE SMELL OR SMOKE",
        "ADDR:336 GRAY AVE",
        "X:NATIONAL AVE / VIRGI/NIA AVE",
        "CITY:WINCHESTER",
        "UNIT:BAT6 E4 E5 EC18 M41 TK2 W1 E");

    doTest("T2",
        "(Winchester ECC info) 11-042157 INSIDE FIRE STRUCT/ELEC/CHIMN\n122-1 E PALL MALL ST\nS CAMERON ST / S KEN/T ST\nWINCHESTER\nBAT6 E1 E4 E5 EC21 M51 TK2",
        "CALL:INSIDE FIRE STRUCT/ELEC/CHIMN",
        "ADDR:122-1 E PALL MALL ST",
        "X:S CAMERON ST / S KEN/T ST",
        "CITY:WINCHESTER",
        "UNIT:BAT6 E1 E4 E5 EC21 M51 TK2");

    doTest("T3",
        "(Winchester ECC info) 11-042110 FIRE ALARM\n1890 AMHERST ST\nWESTSIDE STATION DR// CITY LIMITS\nADULT PSYCH CENTER  WINCHESTER\nE1 E4 EC15 TK2",
        "CALL:FIRE ALARM",
        "ADDR:1890 AMHERST ST",
        "X:WESTSIDE STATION DR// CITY LIMITS",
        "PLACE:ADULT PSYCH CENTER",
        "CITY:WINCHESTER",
        "UNIT:E1 E4 EC15 TK2");

    doTest("T4",
        "(Winchester ECC info) 11-042059 OUTSIDE FIRES WITH NO EXPOSURE\n1029 ALLEN DR\nMOLDEN DR / KINZEL D/R\nTINAS QUALITY CLEANING  WINCHESTER\nE1",
        "CALL:OUTSIDE FIRES WITH NO EXPOSURE",
        "ADDR:1029 ALLEN DR",
        "X:MOLDEN DR / KINZEL D/R",
        "PLACE:TINAS QUALITY CLEANING",
        "CITY:WINCHESTER",
        "UNIT:E1");
    
  }
  
  public static void main(String[] args) {
    new VAWinchesterParserTest().generateTests("T1");
  }
}