package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class SCAndersonCountyParserTest extends BaseParserTest {
  
  public SCAndersonCountyParserTest() {
    setParser(new SCAndersonCountyParser(), "ANDERSON COUNTY", "SC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "ANDERSON CO 911:29B1 >MVA-ALS PRI1 3814 N HIGHWAY 29 XS: BROOKS RD - DORCHESTER RD BELTON PLATINUM PLUS Map: Grids:0,0 Cad: 2011-0000004351",
        "CODE:29B1",
        "CALL:MVA-ALS PRI1",
        "ADDR:3814 N HIGHWAY 29",
        "X:BROOKS RD - DORCHESTER RD",
        "CITY:BELTON",
        "NAME:PLATINUM PLUS",
        "ID:2011-0000004351");

    doTest("T2",
        "ANDERSON CO 911:29B4 >MVA-ALS PRI1 HIGHWAY 29 N MICHAEL QUEEN2214421 Cad: 2011-0000004070",
        "CODE:29B4",
        "CALL:MVA-ALS PRI1",
        "ADDR:HIGHWAY 29 N",
        "NAME:MICHAEL QUEEN2214421",
        "ID:2011-0000004070");

    doTest("T3",
        "ANDERSON CO 911:32 >UNKNOWN PROBLEM 1216 ROUND ABOUT TRL JOSH 201-4436 Cad: 2011-0000004370",
        "CODE:32",
        "CALL:UNKNOWN PROBLEM",
        "ADDR:1216 ROUND ABOUT TRL",
        "NAME:JOSH",
        "PHONE:201-4436",
        "ID:2011-0000004370");

    doTest("T4",
        "ANDERSON CO 911:17B1 >FALLS-ALS PRI1-FR 110 FRANKLIN RD ANDERSON HAWKINS, PAUL Map: Grids:0,0 Cad: 2011-0000004223",
        "CODE:17B1",
        "CALL:FALLS-ALS PRI1-FR",
        "ADDR:110 FRANKLIN RD",
        "CITY:ANDERSON",
        "NAME:HAWKINS, PAUL",
        "ID:2011-0000004223");

    doTest("T5",
        "ANDERSON CO 911:31 >UNCONSCIOUS/FAINTING 210 KIRK LN Apt: 11 Bldg PENDLETON6463347 MICHELLE DURHAM Map: Grids:0,0 Cad: 2011-0000004465",
        "CODE:31",
        "CALL:UNCONSCIOUS/FAINTING",
        "ADDR:210 KIRK LN",
        "APT:11",
        "NAME:Bldg PENDLETON6463347 MICHELLE DURHAM",
        "ID:2011-0000004465");

    doTest("T6",
        "ANDERSON CO 911:13A1 >DIABETIC-ALS PRI2 7900 HIGHWAY 76 PENDLETON OFFICER SUMMERS 934-3443 Map: Grids:0,0 Cad: 2011-0000004494",
        "CODE:13A1",
        "CALL:DIABETIC-ALS PRI2",
        "ADDR:7900 HIGHWAY 76",
        "NAME:PENDLETON OFFICER SUMMERS",
        "PHONE:934-3443",
        "ID:2011-0000004494");

    doTest("T7",
        "AND 911:17A01 >FALLS-BLS PRI2 141 ASHTON LN Apt: 141 Bldg ANDERSON LOUIE SHEILDS 6264049863 Map: Grids:0,0 Cad: 2011-0000202072",
        "CODE:17A01",
        "CALL:FALLS-BLS PRI2",
        "ADDR:141 ASHTON LN",
        "APT:141 Bldg",
        "CITY:ANDERSON",
        "NAME:LOUIE SHEILDS",
        "PHONE:6264049863",
        "ID:2011-0000202072");
   
  }
  
  public static void main(String[] args) {
    new SCAndersonCountyParserTest().generateTests("T1", "CODE CALL ADDR APT X CITY NAME BOX MAP ID");
  }
}