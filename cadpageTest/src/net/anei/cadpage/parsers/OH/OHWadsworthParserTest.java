package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHWadsworthParserTest extends BaseParserTest {
  
  public OHWadsworthParserTest() {
    setParser(new OHWadsworthParser(), "WADSWORTH", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(From: WadsTextSender) 0,,COLLEGE/MAIN,WADSWORTHMVA,MVA (EMS) (INJURY)MVA...NECK PAIN",
        "ADDR:COLLEGE & MAIN",
        "CITY:WADSWORTH",
        "CALL:MVA",
        "INFO:MVA (EMS) (INJURY)MVA...NECK PAIN");

    doTest("T2",
        "(From: WadsTextSender) 194,BALDWIN ST,,WADSWORTH  HART,HEART67 YOF CHEST PAINS",
        "ADDR:194 BALDWIN ST",
        "CITY:WADSWORTH",
        "CALL:HART",
        "INFO:HEART67 YOF CHEST PAINS");

    doTest("T3",
        "(From: WadsTextSender) 250,SMOKERISE DR,LIBERTY RESIDENCE,WADSWORTHPAIN,PAINRM 124   STOMACH PAIN   LIBERTY ONE",
        "ADDR:250 SMOKERISE DR",
        "PLACE:LIBERTY RESIDENCE",
        "CITY:WADSWORTH",
        "CALL:PAIN",
        "INFO:PAINRM 124   STOMACH PAIN   LIBERTY ONE");

    doTest("T4",
        "(From: WadsTextSender) 230,GREAT OAKS TR,101WHITE OAK VILLAGE,WADSWORTHASST,INV. ASSIST80 YOF GENERAL PAIN / NOT FEELING WELL / PMHX CVA - MEDICAL ALARM",
        "ADDR:230 GREAT OAKS TR",
        "PLACE:101WHITE OAK VILLAGE",
        "CITY:WADSWORTH",
        "CALL:ASST",
        "INFO:INV. ASSIST80 YOF GENERAL PAIN / NOT FEELING WELL / PMHX CVA - MEDICAL ALARM");

    doTest("T5",
        "(From: WadsTextSender) 295,WALL RD,,WADSWORTH  GRAS,GRASS/TREE/BRUSH FIRESGRASS FIRE",
        "ADDR:295 WALL RD",
        "CITY:WADSWORTH",
        "CALL:GRAS",
        "INFO:GRASS/TREE/BRUSH FIRESGRASS FIRE");

    doTest("T6",
        "(From: WadsTextSender) 269,E WALNUT ,,WADSWORTH WEAK,WEAKNESSFEMALE WEAK / HISTORY OF STROKES",
        "ADDR:269 E WALNUT",
        "CITY:WADSWORTH",
        "CALL:WEAK",
        "INFO:WEAKNESSFEMALE WEAK / HISTORY OF STROKES");

    doTest("T7",
        "(From: WadsTextSender) 100,HIGH ST,,WADSWORTH  PAIN,PAINFEMALE CHEST PAIN 66 YOF",
        "ADDR:100 HIGH ST",
        "CITY:WADSWORTH",
        "CALL:PAIN",
        "INFO:PAINFEMALE CHEST PAIN 66 YOF");
  }
  
  public static void main(String[] args) {
    new OHWadsworthParserTest().generateTests("T1");
  }
}