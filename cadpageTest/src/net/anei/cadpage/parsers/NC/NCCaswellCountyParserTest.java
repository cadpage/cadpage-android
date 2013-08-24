package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NC.NCCaswellCountyParserTest;

import org.junit.Test;

/*
Caswell County, NC
Contact: Josh Benfield <jhbenfield@gmail.com>
Sender: @caswellcountync.gov

JKYLANDER:764 LOVELACE RD PELHAM 201301769 14:45:11 POWER,PHONE LINE/TREE DOWN TREE DOWN ACROSS POWER LINE, ROADWAY BLOCKED, GRASS FIRE IN THE FRONT Y
RJEFFERSON:89 SUGAR MAPLE LN PELHAM 201301628 12:18:43 SMOKE INVESTIGATION OCA: 201302-24
HGWYNN:2583 CHANDLERS MILL RD PELHAM MDL 01C03 201301602 12:43:14 MEDICAL PROQA OCA: 201302-23
MCOE:3065 OLD US HWY 29 PELHAM MDL 06D02-A 201301563 11:25:59 MEDICAL PROQA conjestive heart failure decreased o2 stats with swelling 66 yof OCA: 201302-21

*/

public class NCCaswellCountyParserTest extends BaseParserTest {
  
  public NCCaswellCountyParserTest() {
    setParser(new NCCaswellCountyParser(), "CASWELL COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "JKYLANDER:764 LOVELACE RD PELHAM 201301769 14:45:11 POWER,PHONE LINE/TREE DOWN TREE DOWN ACROSS POWER LINE, ROADWAY BLOCKED, GRASS FIRE IN THE FRONT Y",
        "ADDR:764 LOVELACE RD",
        "CITY:PELHAM",
        "ID:201301769",
        "TIME:14:45:11",
        "CALL:POWER",
        "INFO:PHONE LINE/TREE DOWN TREE DOWN ACROSS POWER LINE, ROADWAY BLOCKED, GRASS FIRE IN THE FRONT Y");

    doTest("T2",
        "RJEFFERSON:89 SUGAR MAPLE LN PELHAM 201301628 12:18:43 SMOKE INVESTIGATION OCA: 201302-24",
        "ADDR:89 SUGAR MAPLE LN",
        "CITY:PELHAM",
        "ID:201302-24",
        "TIME:12:18:43",
        "CALL:SMOKE INVESTIGATION");

    doTest("T3",
        "HGWYNN:2583 CHANDLERS MILL RD PELHAM MDL 01C03 201301602 12:43:14 MEDICAL PROQA OCA: 201302-23",
        "ADDR:2583 CHANDLERS MILL RD",
        "CITY:PELHAM",
        "CODE:01C03",
        "ID:201302-23",
        "TIME:12:43:14",
        "CALL:MEDICAL PROQA");

    doTest("T4",
        "MCOE:3065 OLD US HWY 29 PELHAM MDL 06D02-A 201301563 11:25:59 MEDICAL PROQA conjestive heart failure decreased o2 stats with swelling 66 yof OCA: 201302-21",
        "ADDR:3065 OLD US HWY 29",
        "MADDR:3065 OLD US 29",
        "CITY:PELHAM",
        "CODE:06D02-A",
        "ID:201302-21",
        "TIME:11:25:59",
        "CALL:MEDICAL PROQA",
        "INFO:conjestive heart failure decreased o2 stats with swelling 66 yof");

  }
  
  public static void main(String[] args) {
    new NCCaswellCountyParserTest().generateTests("T1");
  }
}