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
    
  }
  
  public static void main(String[] args) {
    new OHEnglewoodParserTest().generateTests("T11", "UNIT TIME CODE CALL ADDR APT CITY INFO");
  }
}