package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class VAHalifaxCountyParserTest extends BaseParserTest {
  
  public VAHalifaxCountyParserTest() {
    setParser(new VAHalifaxCountyParser(), "HALIFAX COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[from Central]  11-023176 FALLEN PATIENT\n2210 N TERRYS BRIDGE RD\nJAMES D HAGOOD HWY //SUNSET LN\nHALIFAX",
        "ID:11-023176",
        "CALL:FALLEN PATIENT",
        "ADDR:2210 N TERRYS BRIDGE RD",
        "X:JAMES D HAGOOD HWY //SUNSET LN",
        "CITY:HALIFAX");

    doTest("T2",
        "[from Central]  11-023175 FALLEN PATIENT\n1167 LEWIS FERRELL RD\nOAK LEVEL RD / LITTL/E CIR\nSOUTH BOSTON",
        "ID:11-023175",
        "CALL:FALLEN PATIENT",
        "ADDR:1167 LEWIS FERRELL RD",
        "X:OAK LEVEL RD / LITTL/E CIR",
        "CITY:SOUTH BOSTON");

    doTest("T3",
        "[from Central]  11-023166 EMERGENCY MEDICAL SERVICE\n111-22 ROSEHILL DR\nPOWELL RD / DEAD END/EN\nROSE HILL APARTMENTS  SOUTH BOSTON",
        "ID:11-023166",
        "CALL:EMERGENCY MEDICAL SERVICE",
        "ADDR:111-22 ROSEHILL DR",
        "MADDR:111 ROSEHILL DR",
        "X:POWELL RD / DEAD END/EN",
        "PLACE:ROSE HILL APARTMENTS",
        "CITY:SOUTH BOSTON");

    doTest("T4",
        "[from Central]  11-023086 UNRESPONSIVE PATIENT\n1110 ASBURY CHURCH RD\nCHATHAM RD / PAUL PR/Y TRL\nYOUNGERS HOME FOR ADULTS  HALIFAX",
        "ID:11-023086",
        "CALL:UNRESPONSIVE PATIENT",
        "ADDR:1110 ASBURY CHURCH RD",
        "X:CHATHAM RD / PAUL PR/Y TRL",
        "PLACE:YOUNGERS HOME FOR ADULTS",
        "CITY:HALIFAX");

    doTest("T5",
        "[from Central]  11-023050 FALLEN PATIENT\n3471 OLD HALIFAX RD\nHIGH SCHOOL CIR /  C/ENTERVILLE PARK RD\nWAL-MART  SOUTH BOSTON",
        "ID:11-023050",
        "CALL:FALLEN PATIENT",
        "ADDR:3471 OLD HALIFAX RD",
        "X:HIGH SCHOOL CIR /  C/ENTERVILLE PARK RD",
        "PLACE:WAL-MART",
        "CITY:SOUTH BOSTON");

    doTest("T6",
        "[from Central]  11-023040 EMERGENCY MEDICAL SERVICE\n2082 BURTON RD\nWAGSTAFF LN / CLAYS/MILL RD\nSCOTTSBURG",
        "ID:11-023040",
        "CALL:EMERGENCY MEDICAL SERVICE",
        "ADDR:2082 BURTON RD",
        "X:WAGSTAFF LN / CLAYS/MILL RD",
        "CITY:SCOTTSBURG");

    doTest("T7",
        "[from Central]  11-023038 FALLEN PATIENT\n103 WHITE OAK DR\nSYCAMORE RD / SYCAMO/RE RD\nSOUTH BOSTON",
        "ID:11-023038",
        "CALL:FALLEN PATIENT",
        "ADDR:103 WHITE OAK DR",
        "X:SYCAMORE RD / SYCAMO/RE RD",
        "CITY:SOUTH BOSTON");

    doTest("T8",
        "[from Central]  11-017088 SHORTNESS OF BREATH, ETC.\n1110 HENRYS TRL\nAMBERSTONE DR / DEAD/END\nNATHALIE",
        "ID:11-017088",
        "CALL:SHORTNESS OF BREATH, ETC.",
        "ADDR:1110 HENRYS TRL",
        "X:AMBERSTONE DR / DEAD/END",
        "CITY:NATHALIE");

    doTest("T9",
        "(from Central) 11-022783 ACCIDENT INVOLVING PEDESTRIAN\n104-20 LOVE SHOP PARK RD\nOLD HALIFAX RD / DEA/D END\nLOVE SHOP TRAILER PARK  SOUTH BOSTON",
        "ID:11-022783",
        "CALL:ACCIDENT INVOLVING PEDESTRIAN",
        "ADDR:104-20 LOVE SHOP PARK RD",
        "X:OLD HALIFAX RD / DEA/D END",
        "PLACE:LOVE SHOP TRAILER PARK",
        "CITY:SOUTH BOSTON");
  }
  
  public static void main(String[] args) {
    new VAHalifaxCountyParserTest().generateTests("T1");
  }
}