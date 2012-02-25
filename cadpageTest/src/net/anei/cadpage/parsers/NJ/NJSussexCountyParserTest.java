package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJSussexCountyParserTest extends BaseParserTest {
  
  public NJSussexCountyParserTest() {
    setParser(new NJSussexCountyParser(), "SUSSEX COUNTY", "NJ");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "[Message from HipLink]  BTFD\n" +
        "Fire Alarm\n" +
        "PAGED\n" +
        "11 MANSFIELD DR\n" +
        "BTF02\n" +
        "BTFIRE\n" +
        "ADT,877-535-0563 OPER#AMH, REPORTS AN ACTIVATED GENERAL FIRE ALARM.",

        "SRC:BTFD",
        "CALL:Fire Alarm",
        "ADDR:11 MANSFIELD DR",
        "UNIT:BTF02 BTFIRE",
        "INFO:ADT,877-535-0563 OPER#AMH, REPORTS AN ACTIVATED GENERAL FIRE ALARM.");

    doTest("T2",
        "[Message from HipLink]  BTFD\nFire Other\nPAGED\n16 CARLISLE DR\nBTF03\nBTFIRE\nREPORT OF A FIRE IN THE FURNACE",
        "SRC:BTFD",
        "CALL:Fire Other",
        "ADDR:16 CARLISLE DR",
        "UNIT:BTF03 BTFIRE",
        "INFO:REPORT OF A FIRE IN THE FURNACE");

    doTest("T3",
        "[Message from HipLink]  BTFD\n" +
        "Suspicious Acti\n" +
        "PAGED\n" +
        "161 LACKAWANNA DR\n" +
        "BTF02\n" +
        "BTFIRE\n" +
        "POSSIBLE CHIMNEY FIRE\n" +
        "24 E/R\n" +
        "chief 2 i/s\n" +
        "Call type l reopened by Cat",

        "SRC:BTFD",
        "CALL:Suspicious Acti",
        "ADDR:161 LACKAWANNA DR",
        "UNIT:BTF02 BTFIRE",
        "INFO:POSSIBLE CHIMNEY FIRE / 24 E/R / chief 2 i/s / Call type l reopened by Cat");

    doTest("T4",
        "[Message from HipLink]  BTFD\n" +
        "Fire Other\n" +
        "PAGED\n" +
        "I 80\n" +
        "BTF06\n" +
        "BTFIRE\n" +
        "BRAKE FIRE ON A T.T. BYRAM FIRE AND EMS WAS DISPATCHED AS PER NJSP",

        "SRC:BTFD",
        "CALL:Fire Other",
        "ADDR:I 80",
        "UNIT:BTF06 BTFIRE",
        "INFO:BRAKE FIRE ON A T.T. BYRAM FIRE AND EMS WAS DISPATCHED AS PER NJSP");

    doTest("T5",
        "[Message from HipLink]  BTFD\n" +
        "MV Acc Injury\n" +
        "PAGED\n" +
        "LACKAWANNA DR\n" +
        "BTF02\n" +
        "43EMS\n" +
        "MOTOR VEHICLE ACCIDENT WITH ENTRAPPMENT\n" +
        "PATIENT REMOVED",

        "SRC:BTFD",
        "CALL:MV Acc Injury",
        "ADDR:LACKAWANNA DR",
        "UNIT:BTF02 43EMS",
        "INFO:MOTOR VEHICLE ACCIDENT WITH ENTRAPPMENT / PATIENT REMOVED");

    doTest("T6",
        "[Message from HipLink]  BTFD\nFire Other\nPAGED\n17 STONEHEDGE LN\nBTF03\nBTFIRE",
        "SRC:BTFD",
        "CALL:Fire Other",
        "ADDR:17 STONEHEDGE LN",
        "UNIT:BTF03 BTFIRE");
  }
  
  public static void main(String[] args) {
    new NJSussexCountyParserTest().generateTests("T1");
  }
}