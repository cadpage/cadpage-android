package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAArmstrongCountyParserTest extends BaseParserTest {
  
  public PAArmstrongCountyParserTest() {
    setParser(new PAArmstrongCountyParser(), "ARMSTRONG COUNTY", "PA");
  }
  
  @Test
  public void testParser() {
    

    doTest("T2",
        "11878 STATE ROUTE 85 ARMSDALE RD / CRYTZER RD ORPHANS OF THE STORM VAENT 40313 19:09 7247120225",
        "ADDR:11878 STATE ROUTE 85",
        "X:ARMSDALE RD & CRYTZER RD",
        "PLACE:ORPHANS OF THE STORM",
        "CALL:VAENT",
        "ID:40313");


    doTest("T1",
        "473 TROY HILL RD AIRPORT RD / MCGREGOR RD FMISC 39992 05:40 7245453398",
        "ADDR:473 TROY HILL RD",
        "CALL:FMISC",
        "X:AIRPORT RD & MCGREGOR RD",
        "ID:39992");

    doTest("T2",
        "11878 STATE ROUTE 85 ARMSDALE RD / CRYTZER RD ORPHANS OF THE STORM VAENT 40313 19:09 7247120225",
        "ADDR:11878 STATE ROUTE 85",
        "X:ARMSDALE RD & CRYTZER RD",
        "PLACE:ORPHANS OF THE STORM",
        "CALL:VAENT",
        "ID:40313");

    doTest("T3",
        "141 ADAMS RD STATE ROUTE 85 / BALLOCK LN FMISC 40720 09:07 7247837418",
        "ADDR:141 ADAMS RD",
        "X:STATE ROUTE 85 & BALLOCK LN",
        "CALL:FMISC",
        "ID:40720");

    doTest("T4",
        "[Dispatch]  580 N CHERRY ST HOOKS LN / SPRUCE LN FSTR2 41628 13:58 7246640045",
        "ADDR:580 N CHERRY ST",
        "X:HOOKS LN & SPRUCE LN",
        "CALL:FSTR2",
        "ID:41628");

    doTest("T5",
        "[Dispatch]  868 STATE ROUTE 28/66 MECHLING RD / SLOAN HILL RD VAENT 42068 15:55 7248597657",
        "ADDR:868 STATE ROUTE 28",
        "X:66 MECHLING RD & SLOAN HILL RD",
        "CALL:VAENT",
        "ID:42068");
 }
  
  
  public static void main(String[] args) {
    new PAArmstrongCountyParserTest().generateTests("T1", "ADDR X PLACE CALL ID");
  }
}
