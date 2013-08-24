package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Geneva, OH
Contact: Dale Arkenburg <darkenburg@gmail.com>
Sender: Genevafiredepartment@genevaohio.com

Subject:ATFD\n44 north forest st
Subject:ATFD\n535 East wood St geneva ohio
Subject:ATFD\n3572 Wheeler Creek Rd stove fire
Subject:ATFD\nRESPOND TO FAMILY DOLLAR 120 EAST MAIN FOR AN ODOR INVESTIGATION
Subject:ATFD\nTEST - FIRE ALARM 772 SOUTH BROADWAY
Subject:ATFD\nTEST - FIRE ALARM  1625 SHERMAN STREET
Subject:ATFD\nTEST FIRE ALARM 5061 UNIVERSITY DRIVE
Subject:ATFD\n4561 North Ridge East tree down
Subject:ATFD\ntree on lines 4872 North Ridge East
Subject:ATFD\n7400 Middle Ridge AMA

 */
public class OHGenevaParserTest extends BaseParserTest {
  
  public OHGenevaParserTest() {
    setParser(new OHGenevaParser(), "GENEVA", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:ATFD\n44 north forest st",
        "SRC:ATFD",
        "ADDR:44 north forest st");

    doTest("T2",
        "Subject:ATFD\n535 East wood St geneva ohio",
        "SRC:ATFD",
        "ADDR:535 East wood St");

    doTest("T3",
        "Subject:ATFD\n3572 Wheeler Creek Rd stove fire",
        "SRC:ATFD",
        "CALL:stove fire",
        "ADDR:3572 Wheeler Creek Rd");

    doTest("T4",
        "Subject:ATFD\nRESPOND TO FAMILY DOLLAR 120 EAST MAIN FOR AN ODOR INVESTIGATION",
        "SRC:ATFD",
        "CALL:RESPOND TO FAMILY DOLLAR",
        "ADDR:120 EAST MAIN",
        "INFO:FOR AN ODOR INVESTIGATION");

    doTest("T5",
        "Subject:ATFD\nTEST - FIRE ALARM 772 SOUTH BROADWAY",
        "SRC:ATFD",
        "CALL:TEST - FIRE ALARM",
        "ADDR:772 SOUTH BROADWAY");

    doTest("T6",
        "Subject:ATFD\nTEST - FIRE ALARM  1625 SHERMAN STREET",
        "SRC:ATFD",
        "CALL:TEST - FIRE ALARM",
        "ADDR:1625 SHERMAN STREET");

    doTest("T7",
        "Subject:ATFD\nTEST FIRE ALARM 5061 UNIVERSITY DRIVE",
        "SRC:ATFD",
        "CALL:TEST FIRE ALARM",
        "ADDR:5061 UNIVERSITY DRIVE");

    doTest("T8",
        "Subject:ATFD\n4561 North Ridge East tree down",
        "SRC:ATFD",
        "ADDR:4561 North Ridge East tree down");

    doTest("T9",
        "Subject:ATFD\ntree on lines 4872 North Ridge East",
        "SRC:ATFD",
        "CALL:tree on lines",
        "ADDR:4872 North Ridge East");

    doTest("T10",
        "Subject:ATFD\n7400 Middle Ridge AMA",
        "SRC:ATFD",
        "ADDR:7400 Middle Ridge AMA");
 
  }
  
  public static void main(String[] args) {
    new OHGenevaParserTest().generateTests("T1");
  }
}