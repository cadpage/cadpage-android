package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHEnglewoodParserTest extends BaseParserTest {
  
  public OHEnglewoodParserTest() {
    setParser(new OHEnglewoodParser(), "ENGLEWOOD", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n622 EE98 EM98 OP72:12:31:00-53B:E53:2 VEH ACC UNK INJ:@9200 N MAIN ST,DAYTON:FDC SOUTH WALL\n\n",
        "UNIT:622 EE98 EM98 OP72",
        "TIME:12:31:00",
        "CODE:53B:E53",
        "CALL:2 VEH ACC UNK INJ",
        "ADDR:9200 N MAIN ST",
        "CITY:DAYTON",
        "INFO:FDC SOUTH WALL");

    doTest("T2",
        "CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n630 632 EM98:16:10:00-45:E45:MEDIC/SUICIDAL SUBJECT:@9000 N MAIN ST UNIT 300,DAYTON: ",
        "UNIT:630 632 EM98",
        "TIME:16:10:00",
        "CODE:45:E45",
        "CALL:MEDIC/SUICIDAL SUBJECT",
        "ADDR:9000 N MAIN ST",
        "APT:300",
        "CITY:DAYTON");

    doTest("T3",
        "CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n622 EE98 EM98 OP72:12:31:00-53B:E53:2 VEH ACC UNK INJ:@9200 N MAIN ST,DAYTON:FDC SOUTH WALL ",
        "UNIT:622 EE98 EM98 OP72",
        "TIME:12:31:00",
        "CODE:53B:E53",
        "CALL:2 VEH ACC UNK INJ",
        "ADDR:9200 N MAIN ST",
        "CITY:DAYTON",
        "INFO:FDC SOUTH WALL");

    doTest("T4",
        "CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n620 621 622 EM99:13:34:00-45:E45:MEDIC/CALLER ON SCENE FOR EVAL-PINK SLIP - SUBJ HAS MEDICAL PROBLEMS AND MENTAL ISSUES:@1100 TAYWOOD RD UNIT 14,ENGLEWOOD: ",
        "UNIT:620 621 622 EM99",
        "TIME:13:34:00",
        "CODE:45:E45",
        "CALL:MEDIC/CALLER ON SCENE FOR EVAL-PINK SLIP - SUBJ HAS MEDICAL PROBLEMS AND MENTAL ISSUES",
        "ADDR:1100 TAYWOOD RD",
        "APT:14",
        "CITY:ENGLEWOOD");

    doTest("T5",
        "CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\nEE99 EL98 OP72 UE81 UE82:03:42:00-43:U43:POSS STRUCTURE FIRE:@426 APPLEGATE CT,UNION: ",
        "UNIT:EE99 EL98 OP72 UE81 UE82",
        "TIME:03:42:00",
        "CODE:43:U43",
        "CALL:POSS STRUCTURE FIRE",
        "ADDR:426 APPLEGATE CT",
        "CITY:UNION");

    doTest("T6",
        "CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n631 EE98 EM99 OP72:22:13:00-53B:E53:POSS INJ CRASH:@NATIONAL RD@MAIN ST,ENGLEWOOD: ",
        "UNIT:631 EE98 EM99 OP72",
        "TIME:22:13:00",
        "CODE:53B:E53",
        "CALL:POSS INJ CRASH",
        "ADDR:NATIONAL RD & MAIN ST",
        "CITY:ENGLEWOOD");

    doTest("T7",
        "CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n924 UE81:14:02:00-43:U46:CHECK NORTH SIDE OF THE ROAD FOR A POSS FIELD FIRE:@RINEHART RD@SWEET POTATO RIDGE RD,CLAYTON: ",
        "UNIT:924 UE81",
        "TIME:14:02:00",
        "CODE:43:U46",
        "CALL:CHECK NORTH SIDE OF THE ROAD FOR A POSS FIELD FIRE",
        "ADDR:RINEHART RD & SWEET POTATO RIDGE RD",
        "CITY:CLAYTON");

    doTest("T8",
        "FRM:CAD@englewood.oh.us\n" +
        "MSG:630 EM98:15:51:00-45:E45:MEDIC - 65YOF BACK DOOR SHORTNESS OF BREATH EXTREME PAIN ALL OVER :@322 HEATHER ST UNIT 6,ENGLEWOOD:\r\n",

        "UNIT:630 EM98",
        "TIME:15:51:00",
        "CODE:45:E45",
        "CALL:MEDIC - 65YOF BACK DOOR SHORTNESS OF BREATH EXTREME PAIN ALL OVER",
        "ADDR:322 HEATHER ST",
        "APT:6",
        "CITY:ENGLEWOOD");

    doTest("T9",
        "FRM:CAD@englewood.oh.us\nMSG:EM98:12:53:13-45::MEDIC/ 65 YOF, STOMACH PAINS:@824 HILE LN,ENGLEWOOD:\r\n",
        "UNIT:EM98",
        "TIME:12:53:13",
        "CODE:45:",
        "CALL:MEDIC/ 65 YOF, STOMACH PAINS",
        "ADDR:824 HILE LN",
        "CITY:ENGLEWOOD");

    doTest("T10",
        " 1 of 2\n" +
        "FRM:CAD@englewood.oh.us\n" +
        "MSG:EE98 EM98 OP72:17:04:27-53B::2 VEH CRASH - 1 VEH ON SIDE:@404 W NATIONAL RD,ENGLEWOOD:KEYBOX FRONT DOOR LEFT,\n" +
        "(Con't) 2 of 2\n" +
        "FDC SE CORNER IN FENCE\r\n" +
        "(End)",

        "UNIT:EE98 EM98 OP72",
        "TIME:17:04:27",
        "CODE:53B:",
        "CALL:2 VEH CRASH - 1 VEH ON SIDE",
        "ADDR:404 W NATIONAL RD",
        "CITY:ENGLEWOOD",
        "INFO:KEYBOX FRONT DOOR LEFT, FDC SE CORNER IN FENCE");

    doTest("T11",
        "FRM:CAD@englewood.oh.us\nMSG:EM98:22:35:24-45:E45:MUTUAL AID MEDIC/ MALE WITH FEVER, X OF JEFFERSON BY JAY:@139 NORTH STREET,:\r\n",
        "UNIT:EM98",
        "TIME:22:35:24",
        "CODE:45:E45",
        "CALL:MUTUAL AID MEDIC/ MALE WITH FEVER, X OF JEFFERSON BY JAY",
        "ADDR:139 NORTH STREET");
      
  }
  
  public static void main(String[] args) {
    new OHEnglewoodParserTest().generateTests("T1", "UNIT TIME CODE CALL ADDR APT CITY INFO");
  }
}