package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Sussex County, NJ
Contact: Todd Rudloff <btfd43capt2@gmail.com>

[Message from HipLink]  BTFD\nFire Alarm\nPAGED\n11 MANSFIELD DR\nBTF02\nBTFIRE\nADT,877-535-0563 OPER#AMH, REPORTS AN ACTIVATED GENERAL FIRE ALARM.
[Message from HipLink]  BTFD\nFire Other\nPAGED\n16 CARLISLE DR\nBTF03\nBTFIRE\nREPORT OF A FIRE IN THE FURNACE
[Message from HipLink]  BTFD\nSuspicious Acti\nPAGED\n161 LACKAWANNA DR\nBTF02\nBTFIRE\nPOSSIBLE CHIMNEY FIRE\n24 E/R\nchief 2 i/s\nCall type l reopened by Cat
[Message from HipLink]  BTFD\nFire Other\nPAGED\nI 80\nBTF06\nBTFIRE\nBRAKE FIRE ON A T.T. BYRAM FIRE AND EMS WAS DISPATCHED AS PER NJSP
[Message from HipLink]  BTFD\nMV Acc Injury\nPAGED\nLACKAWANNA DR\nBTF02\n43EMS\nMOTOR VEHICLE ACCIDENT WITH ENTRAPPMENT\nPATIENT REMOVED
[Message from HipLink]  BTFD\nFire Other\nPAGED\n17 STONEHEDGE LN\nBTF03\nBTFIRE

Contact: David Suriano <dasuriano1@gmail.com>
Sender: paging@sussexcountysheriff.com
NWES\r\nMedical Emerg\r\nPAGED\r\n31 PATERSON AVE; APT 28\r\nNWES\r\nNWESPG\r\n9-1-1 CALLER REQ EMS FOR THE 2YOA HAVING A SEIZURE\r
NWES\r\nFire Alarm\r\nPAGED\r\n4 ACADEMY ST\r\nNWES\r\nNWESPG\r\nACTIVATED FIRE ALARM. MULTIPLE ZONE ACTIVATIONS
NWES\r\nMedical Emerg\r\nPAGED\r\n39 TRINITY ST\r\nNWES\r\nNWESPG
NWFD\r\nFire Alarm\r\nPAGED\r\n3 HIGH ST\r\nNWFD\r\nNWESPG\r\nSCSO REQUEST FD RESPOND FOR THE ACTIVATED FIRE ALARM.
NWES\r\nMedical Emerg\r\nPAGED\r\n7 E CLINTON ST\r\nNWES\r\nNWESPG
NWES\r\nMedical Emerg\r\nPAGED\r\n160 SPRING STREET\r\nNWES\r\nNWESPG

Contact: Todd Rudloff <btfd43capt2@gmail.com>
[SUSPECT:]  BTFD\nHazard Cond\nPAGED\nWATERLOO RD\nBTF06\nBTFE4\nDAMAGE CAUSED BY DEBRIS IN THE ROADWAY.\nCall type l reopened by

Contact: "Robert Holowach" <rholowach@sussexfire.com>
Sender: paging@sussexcountysheriff.com
(Message from HipLink) SXFD\nFire Other\nPAGED\n121 State Hwy 23\nSXFD\nWTFD\nSMELL OF SOMETHING BURNING
(Message from HipLink) SXFD\nMV Accident\nPAGED\nRT 565\nSXFD\nWTFD\n2 CARS- EVERYONE OUT- MCCOY'S CORNER
(Message from HipLink) SXFD\nFire Other\nPAGED\n39 UNIONVILLE AVE\nSXFD\nSXFD\nILLEGAL BURNING IN FIREPIT.
SXFD\nFire LZ\nPAGED\n25 County Hwy 639\nSXFD\nSXFD\nTRANSPORT FROM ST CLAIRES. NORTH STAR ETA 10 MINS
SXFD\nMedical Emerg\nPAGED\n803 State Hwy 23\nSXFD\nWTFD\nUNK TYPE INJURY FROM CRANE\nnjsp notified\n2ND CALLER REPORTS CRANE FELL ON A GUY'S FOOT- C
 */

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
        "ADDR:31 PATERSON AVE",
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
  
  @Test
  public void testParser4() {

    doTest("T1",
        "(Message from HipLink) SXFD\nFire Other\nPAGED\n121 State Hwy 23\nSXFD\nWTFD\nSMELL OF SOMETHING BURNING",
        "SRC:SXFD",
        "CALL:Fire Other",
        "ADDR:121 State Hwy 23",
        "MADDR:121 STATE 23",
        "UNIT:SXFD WTFD",
        "INFO:SMELL OF SOMETHING BURNING");

    doTest("T2",
        "(Message from HipLink) SXFD\nMV Accident\nPAGED\nRT 565\nSXFD\nWTFD\n2 CARS- EVERYONE OUT- MCCOY'S CORNER",
        "SRC:SXFD",
        "CALL:MV Accident",
        "ADDR:RT 565",
        "UNIT:SXFD WTFD",
        "INFO:2 CARS- EVERYONE OUT- MCCOY'S CORNER");

    doTest("T3",
        "(Message from HipLink) SXFD\nFire Other\nPAGED\n39 UNIONVILLE AVE\nSXFD\nSXFD\nILLEGAL BURNING IN FIREPIT.",
        "SRC:SXFD",
        "CALL:Fire Other",
        "ADDR:39 UNIONVILLE AVE",
        "UNIT:SXFD SXFD",
        "INFO:ILLEGAL BURNING IN FIREPIT.");

    doTest("T4",
        "SXFD\nFire LZ\nPAGED\n25 County Hwy 639\nSXFD\nSXFD\nTRANSPORT FROM ST CLAIRES. NORTH STAR ETA 10 MINS",
        "SRC:SXFD",
        "CALL:Fire LZ",
        "ADDR:25 County Hwy 639",
        "MADDR:25 COUNTY ROAD 639",
        "UNIT:SXFD SXFD",
        "INFO:TRANSPORT FROM ST CLAIRES. NORTH STAR ETA 10 MINS");

    doTest("T5",
        "SXFD\n" +
        "Medical Emerg\n" +
        "PAGED\n" +
        "803 State Hwy 23\n" +
        "SXFD\n" +
        "WTFD\n" +
        "UNK TYPE INJURY FROM CRANE\n" +
        "njsp notified\n" +
        "2ND CALLER REPORTS CRANE FELL ON A GUY'S FOOT- C",

        "SRC:SXFD",
        "CALL:Medical Emerg",
        "ADDR:803 State Hwy 23",
        "MADDR:803 STATE 23",
        "UNIT:SXFD WTFD",
        "INFO:UNK TYPE INJURY FROM CRANE / njsp notified / 2ND CALLER REPORTS CRANE FELL ON A GUY'S FOOT- C");

  }
  
  public static void main(String[] args) {
    new NJSussexCountyBParserTest().generateTests("T1");
  }
}