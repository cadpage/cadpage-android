package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYErieCountyDParser;

import org.junit.Test;

/*
CLA 10990 Keller Rd. EMS 80M slurred speech
CLA 9970 Greiner Rd. EMS Finger laceration
CLA 5727 Marthas Vineyard EMS 55 y/o fell
CLA 5945 Vinecroft Dr. EMA apt. 401
CLA Salt rd. & County rd. MVA. 1/2 mile north of county.
CLA 5955 Elm St. EMS
CLA 9690 Clarence Center Rd. EMS

Contact: "Buttino, John" <John.Buttino@erie.gov>   (network administrator)
AMH 238 WESTFIELD RD EMS 79 YO F/  CHEST PAIN
AMH 52 ENDICOTT DR EMS 82 YO M
AMH 670 LONGMEADOW RD EMS 71 Y/O F CHEST PAINS, DIFFICULTY BREATHING
AMH 3030 SHERIDAN DR EMS RM 146 58 M TROUBLE BREATHING
AMH 35 ELM RD EMS 69M CHEST/ARM PAIN

Contact: brad marshall <northspartans@gmail.com>
Sender: 777075442231
ALERT@ERIE.GOV AMH KLEIN W RD&FOREST N RD MVA 2 CAR MVA - HEAD INJURY

Contact: Michael Grant <mike18435@gmail.com>
Sender: ALERT@ERIE.GOV
ALERT@ERIE.GOV WMV 5403 MAIN ST EMA APT 308 /

Contact: Mike Ryan <hm2ryan@yahoo.com>
CLA 10205 LAPP RD FAL * FAMILY ROOM SMOKE DETECTOR
NIA 7071 TONAWANDA CREEK RD MAA EMT & MANPOWER REQ BY RAPIDS - 66 F FELL
CLA 5375 OLD GOODRICH RD FAL * CLA CHURCH OF CHRIST FIRE ALARM ACT
CLA 5567 SHIMERVILLE RD FAL HALL SMOKE DETECTOR
CLA 9036 SHANNON CT FAL SMOKE DETECTOR ACTIVATION
CLA 5715 SHIMERVILLE RD FAL BASEMENT HEAT DETECTOR
CLA ROLL RD&GOODRICH RD MVF DUMP TRUCK ON FIRE IN FIELD BEFORE THE PARK IN THIS AREA
CLA 10000 CLARENCE CENTER RD EMS FIELD 5 / 18 YO M UNCONSCIOUS

*/

public class NYErieCountyDParserTest extends BaseParserTest {
  
  public NYErieCountyDParserTest() {
    setParser(new NYErieCountyDParser(), "ERIE COUNTY", "NY");
  }
  
  @Test
  public void testClarence() {

    doTest("T1",
        "CLA 10990 Keller Rd. EMS 80M slurred speech",
        "CITY:CLARENCE",
        "ADDR:10990 Keller Rd",
        "CODE:EMS",
        "CALL:MEDICAL",
        "INFO:80M slurred speech");

    doTest("T2",
        "CLA 9970 Greiner Rd. EMS Finger laceration",
        "CITY:CLARENCE",
        "ADDR:9970 Greiner Rd",
        "CODE:EMS",
        "CALL:MEDICAL",
        "INFO:Finger laceration");

    doTest("T3",
        "CLA 5727 Marthas Vineyard EMS 55 y/o fell",
        "CITY:CLARENCE",
        "ADDR:5727 Marthas Vineyard",
        "CODE:EMS",
        "CALL:MEDICAL",
        "INFO:55 y/o fell");

    doTest("T4",
        "CLA 5945 Vinecroft Dr. EMA apt. 401",
        "CITY:CLARENCE",
        "ADDR:5945 Vinecroft Dr",
        "CODE:EMA",
        "CALL:MEDICAL",
        "APT:401");

    doTest("T5",
        "CLA Salt rd. & County rd. MVA. 1/2 mile north of county.",
        "CITY:CLARENCE",
        "ADDR:Salt rd & County rd",
        "CODE:MVA",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "INFO:1/2 mile north of county.");

    doTest("T6",
        "CLA 5955 Elm St. EMS",
        "CITY:CLARENCE",
        "ADDR:5955 Elm St",
        "CODE:EMS",
        "CALL:MEDICAL");

    doTest("T7",
        "CLA 9690 Clarence Center Rd. EMS",
        "CITY:CLARENCE",
        "ADDR:9690 Clarence Center Rd",
        "CODE:EMS",
        "CALL:MEDICAL");
  }
  
  @Test
  public void testAmherst() {

    doTest("T1",
        "AMH 238 WESTFIELD RD EMS 79 YO F/  CHEST PAIN",
        "CITY:AMHERST",
        "ADDR:238 WESTFIELD RD",
        "CODE:EMS",
        "CALL:MEDICAL",
        "INFO:79 YO F/  CHEST PAIN");

    doTest("T2",
        "AMH 52 ENDICOTT DR EMS 82 YO M",
        "CITY:AMHERST",
        "ADDR:52 ENDICOTT DR",
        "CODE:EMS",
        "CALL:MEDICAL",
        "INFO:82 YO M");

    doTest("T3",
        "AMH 670 LONGMEADOW RD EMS 71 Y/O F CHEST PAINS, DIFFICULTY BREATHING",
        "CITY:AMHERST",
        "ADDR:670 LONGMEADOW RD",
        "CODE:EMS",
        "CALL:MEDICAL",
        "INFO:71 Y/O F CHEST PAINS, DIFFICULTY BREATHING");

    doTest("T4",
        "AMH 3030 SHERIDAN DR EMS RM 146 58 M TROUBLE BREATHING",
        "CITY:AMHERST",
        "ADDR:3030 SHERIDAN DR",
        "CODE:EMS",
        "CALL:MEDICAL",
        "APT:146",
        "INFO:58 M TROUBLE BREATHING");

    doTest("T5",
        "AMH 35 ELM RD EMS 69M CHEST/ARM PAIN",
        "CITY:AMHERST",
        "ADDR:35 ELM RD",
        "CODE:EMS",
        "CALL:MEDICAL",
        "INFO:69M CHEST/ARM PAIN");

    doTest("T6",
        "ALERT@ERIE.GOV AMH KLEIN W RD&FOREST N RD MVA 2 CAR MVA - HEAD INJURY",
        "CITY:AMHERST",
        "ADDR:KLEIN W RD & FOREST N RD",
        "CODE:MVA",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "INFO:2 CAR MVA - HEAD INJURY");
  }
  
  @Test
  public void testWilliamsville() {

    doTest("T1",
        "ALERT@ERIE.GOV WMV 5403 MAIN ST EMA APT 308 /",
        "CITY:WILLIAMSVILLE",
        "ADDR:5403 MAIN ST",
        "CODE:EMA",
        "CALL:MEDICAL",
        "APT:308");
    
  }
  
  @Test
  public void testMikeRyan() {

    doTest("T1",
        "CLA 10205 LAPP RD FAL * FAMILY ROOM SMOKE DETECTOR",
        "CITY:CLARENCE",
        "ADDR:10205 LAPP RD",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "INFO:FAMILY ROOM SMOKE DETECTOR");

    doTest("T2",
        "NIA 7071 TONAWANDA CREEK RD MAA EMT & MANPOWER REQ BY RAPIDS - 66 F FELL",
        "CITY:NIAGRA COUNTY",
        "ADDR:7071 TONAWANDA CREEK RD",
        "CODE:MAA",
        "CALL:MUTUAL AID",
        "INFO:EMT & MANPOWER REQ BY RAPIDS - 66 F FELL");

    doTest("T3",
        "CLA 5375 OLD GOODRICH RD FAL * CLA CHURCH OF CHRIST FIRE ALARM ACT",
        "CITY:CLARENCE",
        "ADDR:5375 OLD GOODRICH RD",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "INFO:CLA CHURCH OF CHRIST FIRE ALARM ACT");

    doTest("T4",
        "CLA 5567 SHIMERVILLE RD FAL HALL SMOKE DETECTOR",
        "CITY:CLARENCE",
        "ADDR:5567 SHIMERVILLE RD",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "INFO:HALL SMOKE DETECTOR");

    doTest("T5",
        "CLA 9036 SHANNON CT FAL SMOKE DETECTOR ACTIVATION",
        "CITY:CLARENCE",
        "ADDR:9036 SHANNON CT",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "INFO:SMOKE DETECTOR ACTIVATION");

    doTest("T6",
        "CLA 5715 SHIMERVILLE RD FAL BASEMENT HEAT DETECTOR",
        "CITY:CLARENCE",
        "ADDR:5715 SHIMERVILLE RD",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "INFO:BASEMENT HEAT DETECTOR");

    doTest("T7",
        "CLA ROLL RD&GOODRICH RD MVF DUMP TRUCK ON FIRE IN FIELD BEFORE THE PARK IN THIS AREA",
        "CITY:CLARENCE",
        "ADDR:ROLL RD & GOODRICH RD",
        "CODE:MVF",
        "CALL:VEHICLE FIRE",
        "INFO:DUMP TRUCK ON FIRE IN FIELD BEFORE THE PARK IN THIS AREA");

    doTest("T8",
        "CLA 10000 CLARENCE CENTER RD EMS FIELD 5 / 18 YO M UNCONSCIOUS",
        "CITY:CLARENCE",
        "ADDR:10000 CLARENCE CENTER RD",
        "CODE:EMS",
        "CALL:MEDICAL",
        "INFO:FIELD 5 / 18 YO M UNCONSCIOUS");

  }
  
  public static void main(String[] args) {
    new NYErieCountyDParserTest().generateTests("T1");
  }
}