package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MDCalvertCountyParserTest extends BaseParserTest {
  
  public MDCalvertCountyParserTest() {
    setParser(new MDCalvertCountyParser(), "CALVERT COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "M Priority 3 Medical  00:02 03/12/11 8536 BAYSIDE RD CHESAPEAKE BEACH 2011-00000445 CO1 abdom. pain",
        "TIME:00:02",
        "DATE:03/12/11",
        "CALL:M Priority 3 Medical",
        "ADDR:8536 BAYSIDE RD",
        "CITY:CHESAPEAKE BEACH",
        "ID:2011-00000445",
        "INFO:CO1 abdom. pain");

    doTest("T2",
        "R Auto Accident Serious S5 R1 A59 A19 M102  21:41 03/11/11 W CHESAPEAKE BEACH RD DUNKIRK 2011-00016920  entrapment  a truck hit a another car",
        "TIME:21:41",
        "DATE:03/11/11",
        "CALL:R Auto Accident Serious",
        "UNIT:S5 R1 A59 A19 M102",
        "ADDR:W CHESAPEAKE BEACH RD",
        "CITY:DUNKIRK",
        "ID:2011-00016920",
        "INFO:entrapment  a truck hit a another car");

    doTest("T3",
        "F Local Box E12  19:23 03/10/11 3741 3RD ST NORTH BEACH 2011-00000438  NEIGHBORS ARE TRYING TO APPROACH IT. THERE IS A CAR UNDER THE TREE, IT",
        "TIME:19:23",
        "DATE:03/10/11",
        "CALL:F Local Box",
        "UNIT:E12",
        "ADDR:3741 3RD ST",
        "CITY:NORTH BEACH",
        "ID:2011-00000438",
        "INFO:NEIGHBORS ARE TRYING TO APPROACH IT. THERE IS A CAR UNDER THE TREE, IT");

    doTest("T4",
        "M Priority 2 Medical A19 M102  17:19 03/10/11 950 E  MT HARMONY RD OWINGS 2011-00000435  ProQA Medical Key Questions have been completed; Disp Dispatch Code:",
        "TIME:17:19",
        "DATE:03/10/11",
        "CALL:M Priority 2 Medical",
        "UNIT:A19 M102",
        "ADDR:950 E MT HARMONY RD",
        "CITY:OWINGS",
        "ID:2011-00000435",
        "INFO:ProQA Medical Key Questions have been completed; Disp Dispatch Code:");

    doTest("T5",
        "F Fire Alarm E11 E51 T1  16:30 03/10/11 1850 PROSPER LN OWINGS 2011-00000433 SNEADES ACE-OW ProQA Fire Questionnaire Completed;",
        "TIME:16:30",
        "DATE:03/10/11",
        "CALL:F Fire Alarm",
        "UNIT:E11 E51 T1",
        "ADDR:1850 PROSPER LN",
        "CITY:OWINGS",
        "ID:2011-00000433",
        "INFO:SNEADES ACE-OW ProQA Fire Questionnaire Completed;");

    doTest("T6",
        "F Area Box E61 E21 E52 E11 TN5 TN7 T2 S6 A68 NDC  17:52 03/09/11 65 WALTON RD HUNTINGTOWN 2011-00000443  ProQA Fire Questionnaire Completed; D ",
        "TIME:17:52",
        "DATE:03/09/11",
        "CALL:F Area Box",
        "UNIT:E61 E21 E52 E11 TN5 TN7 T2 S6 A68 NDC",
        "ADDR:65 WALTON RD",
        "CITY:HUNTINGTOWN",
        "ID:2011-00000443",
        "INFO:ProQA Fire Questionnaire Completed; D");

    doTest("T7",
        "M Priority 2 Medical A19 NOMED  10:45 03/09/11 8818 CHESAPEAKE LIGHTHOUSE DR NORTH BEACH 2011-00000428  ProQA Medical Questionnaire Completed;",
        "TIME:10:45",
        "DATE:03/09/11",
        "CALL:M Priority 2 Medical",
        "UNIT:A19 NOMED",
        "ADDR:8818 CHESAPEAKE LIGHTHOUSE DR",
        "CITY:NORTH BEACH",
        "ID:2011-00000428",
        "INFO:ProQA Medical Questionnaire Completed;");

    doTest("T8",
        "(Dispatch Info) M Priority 3 Medical A79  11:44 03/22/11 Box 303 12680 HG TRUEMAN RD LUSBY 2011-00000525 SCHOOL-DOW ES ProQA Medical Questionnaire Completed;",
        "TIME:11:44",
        "DATE:03/22/11",
        "CALL:M Priority 3 Medical",
        "UNIT:A79",
        "BOX:303",
        "ADDR:12680 HG TRUEMAN RD",
        "CITY:LUSBY",
        "ID:2011-00000525",
        "INFO:SCHOOL-DOW ES ProQA Medical Questionnaire Completed;");

    doTest("T9",
        "(Dispatch Info) M Priority 1 Medical E33 A38 SMA796 M105  11:20 04/18/11 Box 302 1105 BACK CREEK LOOP SOLOMONS",
        "TIME:11:20",
        "DATE:04/18/11",
        "CALL:M Priority 1 Medical",
        "UNIT:E33 A38 SMA796 M105",
        "BOX:302",
        "ADDR:1105 BACK CREEK LOOP",
        "CITY:SOLOMONS");

    doTest("T10",
        "(Dispatch Info) M Priority 3 Medical A37  16:52 04/24/11 Box 302 11740 ASBURY CIR SOLOMONS ASBURY APTS-SOUT",
        "TIME:16:52",
        "DATE:04/24/11",
        "CALL:M Priority 3 Medical",
        "UNIT:A37",
        "BOX:302",
        "ADDR:11740 ASBURY CIR",
        "PLACE:ASBURY APTS-SOUT",
        "CITY:SOLOMONS");

    doTest("T11",
        "(Dispatch Info) M Priority 1 Medical E33 A37 SMA796 M105  19:25 05/09/11 Box 301 14575 S  SOLOMONS ISLAND RD SOLOMONS Sol Pie",
        "TIME:19:25",
        "DATE:05/09/11",
        "CALL:M Priority 1 Medical",
        "UNIT:E33 A37 SMA796 M105",
        "BOX:301",
        "ADDR:14575 S SOLOMONS ISLAND RD",
        "PLACE:Sol Pie",
        "CITY:SOLOMONS");
  }
  
  public static void main(String[] args) {
    new MDCalvertCountyParserTest().generateTests("T1", "TIME DATE CALL UNIT BOX ADDR PLACE CITY ID INFO");
  }
}
