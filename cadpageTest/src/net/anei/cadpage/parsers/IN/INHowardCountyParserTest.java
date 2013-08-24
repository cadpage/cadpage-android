package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/***
Howard County, IN
Contact: Michael Kaelin <mdkaelin@gmail.com>
Sender: cisco.paging@co.howard.in.us

Subject:BREATHING PROBLEM\nLoc:1103 N 1100E XSt:200N 100N Grid:E300 Units:A11 Rmk:68 YOA FEMALE, DIZZY, BREATHING HARD, REAL RESTLE
Subject:BREATHING PROBLEM\nLoc:221 S HOWARD ST XSt:MAIN ST G HOLIDAY LN Grid:D210 Units:AGTFD Rmk:CANCER PATIENT DIFFICULTY BREATHI
Subject:BREATHING PROBLEM\nLoc:1401 SUNFLOWER CT XSt:MEADOW DR Grid:D210 Units:AGTFD Rmk:
Subject:TRANSPORTION\nLoc:705 N MERIDIAN ST Grid:D205 Units:A11 Rmk:RETURN TRANSPORT FROM HOWARD COMM
Subject:RESIDENTIAL FIRE\nLoc:10269 E 300S XSt:1100E 980E Grid:A400 Units:E11 A11 Rmk:SMOKE COMING FROM THE UTILITY CLOSET
Subject:BREATHING PROBLEM\nLoc:6348 E 200N XSt:700E 600E Grid:D400 Units:AGTFD A11 Rmk:
Subject:ABDOM/BACK PAIN\nLoc:705 N MERIDIAN ST Grid:D205 Units:A11 Rmk:ROOM 406 95 YOA FEMALE
Subject:GAS ODOR\nLoc:325 S MAPLE ST G XSt:MAIN ST G HALL ST Grid:D210 Units:E11 A11 Rmk:SMELLS NATURAL GAS INSIDE HER RESIDENCE

 
Contact: Jason <jgunning@att.net>
FRM:cisco.paging@co.howard.in.us\nSUBJ:MEDIC INTERCEPT\nMSG:Loc:00EW/500S Grid:B390 Units:MED21 Rmk:21 YOA FM SEIZURE\r\n

***/

public class INHowardCountyParserTest extends BaseParserTest {
  
  public INHowardCountyParserTest() {
    setParser(new INHowardCountyParser(), "HOWARD COUNTY", "IN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:BREATHING PROBLEM\nLoc:1103 N 1100E XSt:200N 100N Grid:E300 Units:A11 Rmk:68 YOA FEMALE, DIZZY, BREATHING HARD, REAL RESTLE",
        "CALL:BREATHING PROBLEM",
        "ADDR:1103 N 1100E",
        "X:200N 100N",
        "MAP:E300",
        "UNIT:A11",
        "INFO:68 YOA FEMALE, DIZZY, BREATHING HARD, REAL RESTLE");

    doTest("T2",
        "Subject:BREATHING PROBLEM\nLoc:221 S HOWARD ST XSt:MAIN ST G HOLIDAY LN Grid:D210 Units:AGTFD Rmk:CANCER PATIENT DIFFICULTY BREATHI",
        "CALL:BREATHING PROBLEM",
        "ADDR:221 S HOWARD ST",
        "X:MAIN ST G HOLIDAY LN",
        "MAP:D210",
        "UNIT:AGTFD",
        "INFO:CANCER PATIENT DIFFICULTY BREATHI");

    doTest("T3",
        "Subject:BREATHING PROBLEM\nLoc:1401 SUNFLOWER CT XSt:MEADOW DR Grid:D210 Units:AGTFD Rmk:",
        "CALL:BREATHING PROBLEM",
        "ADDR:1401 SUNFLOWER CT",
        "X:MEADOW DR",
        "MAP:D210",
        "UNIT:AGTFD");

    doTest("T4",
        "Subject:TRANSPORTION\nLoc:705 N MERIDIAN ST Grid:D205 Units:A11 Rmk:RETURN TRANSPORT FROM HOWARD COMM",
        "CALL:TRANSPORTION",
        "ADDR:705 N MERIDIAN ST",
        "MAP:D205",
        "UNIT:A11",
        "INFO:RETURN TRANSPORT FROM HOWARD COMM");

    doTest("T5",
        "Subject:RESIDENTIAL FIRE\nLoc:10269 E 300S XSt:1100E 980E Grid:A400 Units:E11 A11 Rmk:SMOKE COMING FROM THE UTILITY CLOSET",
        "CALL:RESIDENTIAL FIRE",
        "ADDR:10269 E 300S",
        "X:1100E 980E",
        "MAP:A400",
        "UNIT:E11 A11",
        "INFO:SMOKE COMING FROM THE UTILITY CLOSET");

    doTest("T6",
        "Subject:BREATHING PROBLEM\nLoc:6348 E 200N XSt:700E 600E Grid:D400 Units:AGTFD A11 Rmk:",
        "CALL:BREATHING PROBLEM",
        "ADDR:6348 E 200N",
        "X:700E 600E",
        "MAP:D400",
        "UNIT:AGTFD A11");

    doTest("T7",
        "Subject:ABDOM/BACK PAIN\nLoc:705 N MERIDIAN ST Grid:D205 Units:A11 Rmk:ROOM 406 95 YOA FEMALE",
        "CALL:ABDOM/BACK PAIN",
        "ADDR:705 N MERIDIAN ST",
        "MAP:D205",
        "UNIT:A11",
        "INFO:ROOM 406 95 YOA FEMALE");

    doTest("T8",
        "Subject:GAS ODOR\nLoc:325 S MAPLE ST G XSt:MAIN ST G HALL ST Grid:D210 Units:E11 A11 Rmk:SMELLS NATURAL GAS INSIDE HER RESIDENCE",
        "CALL:GAS ODOR",
        "ADDR:325 S MAPLE ST G",
        "X:MAIN ST G HALL ST",
        "MAP:D210",
        "UNIT:E11 A11",
        "INFO:SMELLS NATURAL GAS INSIDE HER RESIDENCE");

  }
  
  @Test
  public void testJason() {

    doTest("T1",
        "FRM:cisco.paging@co.howard.in.us\nSUBJ:MEDIC INTERCEPT\nMSG:Loc:00EW/500S Grid:B390 Units:MED21 Rmk:21 YOA FM SEIZURE\r\n",
        "CALL:MEDIC INTERCEPT",
        "ADDR:00EW & 500S",
        "MAP:B390",
        "UNIT:MED21",
        "INFO:21 YOA FM SEIZURE");

  }
  
  public static void main(String[] args) {
    new INHowardCountyParserTest().generateTests("T1");
  }
}