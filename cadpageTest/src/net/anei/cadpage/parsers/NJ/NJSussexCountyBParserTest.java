package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJSussexCountyBParserTest extends BaseParserTest {
  
  public NJSussexCountyBParserTest() {
    setParser(new NJSussexCountyBParser(), "SUSSEX COUNTY", "NJ");
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
  
  @Test
  public void testParser2() {

    doTest("T1",
        "NWES\r\nMedical Emerg\r\nPAGED\r\n31 PATERSON AVE; APT 28\r\nNWES\r\nNWESPG\r\n9-1-1 CALLER REQ EMS FOR THE 2YOA HAVING A SEIZURE\r",
        "SRC:NWES",
        "CALL:Medical Emerg",
        "ADDR:31 PATERSON AVE;",
        "APT:28",
        "UNIT:NWES NWESPG",
        "INFO:9-1-1 CALLER REQ EMS FOR THE 2YOA HAVING A SEIZURE");

    doTest("T2",
        "NWES\r\nFire Alarm\r\nPAGED\r\n4 ACADEMY ST\r\nNWES\r\nNWESPG\r\nACTIVATED FIRE ALARM. MULTIPLE ZONE ACTIVATIONS",
        "SRC:NWES",
        "CALL:Fire Alarm",
        "ADDR:4 ACADEMY ST",
        "UNIT:NWES NWESPG",
        "INFO:ACTIVATED FIRE ALARM. MULTIPLE ZONE ACTIVATIONS");

    doTest("T3",
        "NWES\r\nMedical Emerg\r\nPAGED\r\n39 TRINITY ST\r\nNWES\r\nNWESPG",
        "SRC:NWES",
        "CALL:Medical Emerg",
        "ADDR:39 TRINITY ST",
        "UNIT:NWES NWESPG");

    doTest("T4",
        "NWFD\r\nFire Alarm\r\nPAGED\r\n3 HIGH ST\r\nNWFD\r\nNWESPG\r\nSCSO REQUEST FD RESPOND FOR THE ACTIVATED FIRE ALARM.",
        "SRC:NWFD",
        "CALL:Fire Alarm",
        "ADDR:3 HIGH ST",
        "UNIT:NWFD NWESPG",
        "INFO:SCSO REQUEST FD RESPOND FOR THE ACTIVATED FIRE ALARM.");

    doTest("T5",
        "NWES\r\nMedical Emerg\r\nPAGED\r\n7 E CLINTON ST\r\nNWES\r\nNWESPG",
        "SRC:NWES",
        "CALL:Medical Emerg",
        "ADDR:7 E CLINTON ST",
        "UNIT:NWES NWESPG");

    doTest("T6",
        "NWES\r\nMedical Emerg\r\nPAGED\r\n160 SPRING STREET\r\nNWES\r\nNWESPG",
        "SRC:NWES",
        "CALL:Medical Emerg",
        "ADDR:160 SPRING STREET",
        "UNIT:NWES NWESPG");

  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "[SUSPECT:]  BTFD\nHazard Cond\nPAGED\nWATERLOO RD\nBTF06\nBTFE4\nDAMAGE CAUSED BY DEBRIS IN THE ROADWAY.\nCall type l reopened by",
        "SRC:BTFD",
        "CALL:Hazard Cond",
        "ADDR:WATERLOO RD",
        "UNIT:BTF06 BTFE4",
        "INFO:DAMAGE CAUSED BY DEBRIS IN THE ROADWAY. / Call type l reopened by");

  }
  
  public static void main(String[] args) {
    new NJSussexCountyBParserTest().generateTests("T1");
  }
}