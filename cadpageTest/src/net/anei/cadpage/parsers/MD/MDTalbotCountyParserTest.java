package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Talbot County, MD
Contact: "jg0169586@yahoo.com" <jg0169586@yahoo.com>
Contact: Scott Redmer <sredmer140@gmail.com>
Sender: msg@cfmsg.com

Talbot 911:*D 61 B-ABDOMINAL PAIN 319 LINDEN AVE T60
Talbot 911:*D 70 A-CHEST PAIN 5656 BLACK WALNUT POINT RD BREATHING NORMAL <35 T70
Talbot 911:*D 66 MVA/PI OCEAN GTWY / GOLDSBOROUGH ST T60
Talbot 911:*D 40C B-FALLS/BACK TRAUMA 103 MILES LN POSS DANGER BODY PT T40
Talbot 911:*D DOR ASSIST EMS 821 FIELDCREST DR D01
Talbot 911:*D 61 POLICE REQUEST EMS IDLEWILD PARK @116 IDLEWILD AVE BRAVO RESPONSE T60
Talbot 911:*D 43 SM NON-DWELLING FIRE 7011 HOPKINS NECK RD SHED/DETACH GARAGE T40

Contact: Chris Hash <east66side@gmail.com>
Sender: 4109247197
Talbot 911:*D 62AH C-SMOKE DETECTOR 700 PORT ST @HEART FIELDS AT EAST COMMERCIAL STRUCTURE T60

Contact: clyde dickey <cldickey45@gmail.com>
Sender: 777255020755
Talbot911:*D 54 RESIDENTIAL FIRE 9695 COUNCELL RD SINGLE T50


Contact: Active911
Agency name: Talbot DES
Location: Easton, MD, United States
Sender: Talbot911@talbotdes.org

Talbot911:*D 44   A-SICK PERSON        6319 BOZMAN NEAVITT RD                       UNWELL / ILL         T40
Talbot911:*D 60   MVA/PI               HARRISON ST N / WASHINGTON ST N                                   T60
Talbot911:*D CAR  ASSIST FIRE          23200 GROVE RD                                                    C300
Talbot911:*D 43   B-INDUSTRIAL ALARM   27040 RIGBYLOT RD                            RESIDENTIAL/SINGLE   T40
Talbot911:*G 64   MVA/PI               EASTON BYP N / ST MICHAELS RD                                     T60
Talbot911:*D 41C  C-BREATHING PROBLEMS 210 NORTH ST                                 ABNORMAL BREATHING   T40
Talbot911:*D 61C  A-SICK PERSON        43 MARIAN TER                                UNWELL / ILL         T60
Talbot911:*D 61   D-BREATHING PROBLEMS 10 PROSPECT AVE                              DIFFICULTY SPEAKING  T60
Talbot911:*D 71   MEDICAL ALARM        21352 SETH AVE                               BRAVO RESPONSE       T70
Talbot911:*D 43   D-UNCONSCIOUS/FAINT  7560 RYDERS REST LN                          UNCONSC/EFFEC BREATH T40


The codes following the *D are the box area and then the T__ and such is the
station number that has the call. We have the following stations in the
county.
20  -  Oxford
30  -  Trappe
40  -  St. Michaels
50  -  Cordova
60  -  Easton
70  -  Tilghman
80  -  Queen Ann Hillsboro
90  -  Talbot County EMS

The D01 is for assisting Dorchester county station 1
******************************************************************************/

public class MDTalbotCountyParserTest extends BaseParserTest {
  
  public MDTalbotCountyParserTest() {
    setParser(new MDTalbotCountyParser(), "TALBOT COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Talbot 911:*D 61 B-ABDOMINAL PAIN 319 LINDEN AVE T60",
        "BOX:61",
        "CALL:B-ABDOMINAL PAIN",
        "ADDR:319 LINDEN AVE",
        "UNIT:T60");
    
    doTest("T3",
        "Talbot 911:*D 66 MVA/PI OCEAN GTWY / GOLDSBOROUGH ST T60",
        "BOX:66",
        "CALL:MVA/PI",
        "ADDR:OCEAN GTWY & GOLDSBOROUGH ST",
        "UNIT:T60");

    doTest("T4",
        "Talbot 911:*D 40C B-FALLS/BACK TRAUMA 103 MILES LN POSS DANGER BODY PT T40",
        "BOX:40C",
        "CALL:B-FALLS/BACK TRAUMA",
        "ADDR:103 MILES LN",
        "INFO:POSS DANGER BODY PT",
        "UNIT:T40");

    doTest("T5",
        "Talbot 911:*D DOR ASSIST EMS 821 FIELDCREST DR D01",
        "BOX:DOR",
        "CALL:ASSIST EMS",
        "ADDR:821 FIELDCREST DR",
        "UNIT:D01");

    doTest("T6",
        "Talbot 911:*D 61 POLICE REQUEST EMS IDLEWILD PARK @116 IDLEWILD AVE BRAVO RESPONSE T60",
        "BOX:61",
        "CALL:POLICE REQUEST EMS IDLEWILD PARK",
        "ADDR:116 IDLEWILD AVE",
        "INFO:BRAVO RESPONSE",
        "UNIT:T60");

    doTest("T7",
        "Talbot 911:*D 43 SM NON-DWELLING FIRE 7011 HOPKINS NECK RD SHED/DETACH GARAGE T40",
        "BOX:43",
        "CALL:SM NON-DWELLING FIRE",
        "ADDR:7011 HOPKINS NECK RD",
        "INFO:SHED/DETACH GARAGE",
        "UNIT:T40");

    doTest("T8",
        "Talbot 911:*D 62AH C-SMOKE DETECTOR 700 PORT ST @HEART FIELDS AT EAST COMMERCIAL STRUCTURE T60",
        "BOX:62AH",
        "CALL:C-SMOKE DETECTOR",
        "ADDR:700 PORT ST",
        "PLACE:HEART",
        "INFO:FIELDS AT EAST COMMERCIAL STRUCTURE",
        "UNIT:T60");

    doTest("T9",
        "Talbot911:*D 54 RESIDENTIAL FIRE 9695 COUNCELL RD SINGLE T50",
        "BOX:54",
        "CALL:RESIDENTIAL FIRE",
        "ADDR:9695 COUNCELL RD",
        "INFO:SINGLE",
        "UNIT:T50");

  }
  
  @Test
  public void testTalbotDES() {

    doTest("T1",
        "Talbot911:*D 44   A-SICK PERSON        6319 BOZMAN NEAVITT RD                       UNWELL / ILL         T40",
        "BOX:44",
        "CALL:A-SICK PERSON",
        "ADDR:6319 BOZMAN NEAVITT RD",
        "INFO:UNWELL / ILL",
        "UNIT:T40");

    doTest("T2",
        "Talbot911:*D 60   MVA/PI               HARRISON ST N / WASHINGTON ST N                                   T60",
        "BOX:60",
        "CALL:MVA/PI",
        "ADDR:HARRISON ST N & WASHINGTON ST N",
        "UNIT:T60");

    doTest("T3",
        "Talbot911:*D CAR  ASSIST FIRE          23200 GROVE RD                                                    C300",
        "BOX:CAR",
        "CALL:ASSIST FIRE",
        "ADDR:23200 GROVE RD",
        "UNIT:C300");

    doTest("T4",
        "Talbot911:*D 43   B-INDUSTRIAL ALARM   27040 RIGBYLOT RD                            RESIDENTIAL/SINGLE   T40",
        "BOX:43",
        "CALL:B-INDUSTRIAL ALARM",
        "ADDR:27040 RIGBYLOT RD",
        "INFO:RESIDENTIAL/SINGLE",
        "UNIT:T40");

    doTest("T5",
        "Talbot911:*G 64   MVA/PI               EASTON BYP N / ST MICHAELS RD                                     T60",
        "BOX:64",
        "CALL:MVA/PI",
        "ADDR:EASTON BYP N & ST MICHAELS RD",
        "MADDR:EASTON BYPASS N & ST MICHAELS RD",
        "UNIT:T60");

    doTest("T6",
        "Talbot911:*D 41C  C-BREATHING PROBLEMS 210 NORTH ST                                 ABNORMAL BREATHING   T40",
        "BOX:41C",
        "CALL:C-BREATHING PROBLEMS",
        "ADDR:210 NORTH ST",
        "INFO:ABNORMAL BREATHING",
        "UNIT:T40");

    doTest("T7",
        "Talbot911:*D 61C  A-SICK PERSON        43 MARIAN TER                                UNWELL / ILL         T60",
        "BOX:61C",
        "CALL:A-SICK PERSON",
        "ADDR:43 MARIAN TER",
        "INFO:UNWELL / ILL",
        "UNIT:T60");

    doTest("T8",
        "Talbot911:*D 61   D-BREATHING PROBLEMS 10 PROSPECT AVE                              DIFFICULTY SPEAKING  T60",
        "BOX:61",
        "CALL:D-BREATHING PROBLEMS",
        "ADDR:10 PROSPECT AVE",
        "INFO:DIFFICULTY SPEAKING",
        "UNIT:T60");

    doTest("T9",
        "Talbot911:*D 71   MEDICAL ALARM        21352 SETH AVE                               BRAVO RESPONSE       T70",
        "BOX:71",
        "CALL:MEDICAL ALARM",
        "ADDR:21352 SETH AVE",
        "INFO:BRAVO RESPONSE",
        "UNIT:T70");

    doTest("T10",
        "Talbot911:*D 43   D-UNCONSCIOUS/FAINT  7560 RYDERS REST LN                          UNCONSC/EFFEC BREATH T40",
        "BOX:43",
        "CALL:D-UNCONSCIOUS/FAINT",
        "ADDR:7560 RYDERS REST LN",
        "INFO:UNCONSC/EFFEC BREATH",
        "UNIT:T40");

  }
  
  public static void main(String[] args) {
    new MDTalbotCountyParserTest().generateTests("T1");
  }
}
