package net.anei.cadpage.parsers.AZ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Yavapai County, AZ
Contact: "Joel Rosenberg Northern AZ. Garage Doors" <nazgaragedoors@gmail.com>
Sender: @sedonafire.org

CT:EMS E UNC PERSON 2714 S PIPE CREEK DR CTWD BOX:3030 DUE:C314
CT:EMS E UNC PERSON 2714 S PIPE CREEK DR CTWD BOX:3030 DUE:E411 A-VVFD
CT:EMS UNC PERSON 2714 S PIPE CREEK DR CTWD BOX:3030 DUE:CH7RA E311 A311
CT:EMS E 1295 E HOMBRE DR CTWD BOX:3060 DUE:C314
CT:EMS E 1295 E HOMBRE DR CTWD BOX:3060 DUE:E411 A-VVFD TIPS N-VVDC
CT:EMS 1295 E HOMBRE DR CTWD BOX:3060 DUE:CH7RA E311 A311

Contact: jodellmoore@cableone.net <jodellmoore@cableone.net>
Sender: 418@sedonafire.org
CT:SPEC INVALID ASSIST 521 TODD CIR CLK BOX:2120 DUE:CH7RA SD210

*/

public class AZYavapaiCountyParserTest extends BaseParserTest {
  
  public AZYavapaiCountyParserTest() {
    setParser(new AZYavapaiCountyParser(), "YAVAPAI COUNTY", "AZ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CT:EMS E UNC PERSON 2714 S PIPE CREEK DR CTWD BOX:3030 DUE:C314",
        "CALL:EMS E UNC PERSON",
        "ADDR:2714 S PIPE CREEK DR",
        "CITY:COTTONWOOD",
        "BOX:3030",
        "UNIT:C314");

    doTest("T2",
        "CT:EMS E UNC PERSON 2714 S PIPE CREEK DR CTWD BOX:3030 DUE:E411 A-VVFD",
        "CALL:EMS E UNC PERSON",
        "ADDR:2714 S PIPE CREEK DR",
        "CITY:COTTONWOOD",
        "BOX:3030",
        "UNIT:E411 A-VVFD");

    doTest("T3",
        "CT:EMS UNC PERSON 2714 S PIPE CREEK DR CTWD BOX:3030 DUE:CH7RA E311 A311",
        "CALL:EMS UNC PERSON",
        "ADDR:2714 S PIPE CREEK DR",
        "CITY:COTTONWOOD",
        "BOX:3030",
        "UNIT:CH7RA E311 A311");

    doTest("T4",
        "CT:EMS E 1295 E HOMBRE DR CTWD BOX:3060 DUE:C314",
        "CALL:EMS E",
        "ADDR:1295 E HOMBRE DR",
        "CITY:COTTONWOOD",
        "BOX:3060",
        "UNIT:C314");

    doTest("T5",
        "CT:EMS E 1295 E HOMBRE DR CTWD BOX:3060 DUE:E411 A-VVFD TIPS N-VVDC",
        "CALL:EMS E",
        "ADDR:1295 E HOMBRE DR",
        "CITY:COTTONWOOD",
        "BOX:3060",
        "UNIT:E411 A-VVFD TIPS N-VVDC");

    doTest("T6",
        "CT:EMS 1295 E HOMBRE DR CTWD BOX:3060 DUE:CH7RA E311 A311",
        "CALL:EMS",
        "ADDR:1295 E HOMBRE DR",
        "CITY:COTTONWOOD",
        "BOX:3060",
        "UNIT:CH7RA E311 A311");

  }
  
  @Test
  public void testJodellMoore() {

    doTest("T1",
        "CT:SPEC INVALID ASSIST 521 TODD CIR CLK BOX:2120 DUE:CH7RA SD210",
        "CALL:SPEC INVALID ASSIST",
        "ADDR:521 TODD CIR",
        "CITY:CLARKDALE",
        "BOX:2120",
        "UNIT:CH7RA SD210");
    
  }
  
  public static void main(String[] args) {
    new AZYavapaiCountyParserTest().generateTests("T1");
  }
}