package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHGeaugaCountyParserTest extends BaseParserTest {
  
  public OHGeaugaCountyParserTest() {
    setParser(new OHGeaugaCountyParser(), "GEAUGA COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 11 lois ln elderly female vomiting and sick TXT STOP to opt-out",
        "CALL:RESCUE",
        "ADDR:11 lois ln",
        "INFO:elderly female vomiting and sick");

    doTest("T2",
        "GEAUGA COUNTY SHERIFF (Text Message) 13806 Mayfield Rd. Electrical Fire TXT STOP to opt-out",
        "CALL:Electrical Fire",
        "ADDR:13806 Mayfield Rd");

    doTest("T3",
        "GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 9579 Venus 76yom abdominal pain TXT STOP to opt-out",
        "CALL:RESCUE",
        "PLACE:9579 Venus 76yom abdominal pain");

    doTest("T4",
        "GEAUGA COUNTY SHERIFF (Text Message 2of2) Smoking really bad. 2800/Wright TXT STOP to opt-out",
        "PLACE:Smoking really bad. 2800/Wright");

    doTest("T5",
        "GEAUGA COUNTY SHERIFF (Text Message 1of2) Fire Dept needed at the Dept of Aging, 12555 Ravenwood Dr, reported possibly oven fire. TXT STOP to opt-out",
        "CALL:Fire Dept",
        "PLACE:the Dept of Aging",
        "ADDR:12555 Ravenwood Dr",
        "INFO:reported possibly oven fire");

    doTest("T6",
        "GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 10865 holi dale 18 month old female diff breathing 2800 clr/phillips TXT STOP to opt-out",
        "CALL:RESCUE",
        "PLACE:10865 holi dale 18 month old female diff breathing 2800 clr/phillips");

    doTest("T7",
        "GEAUGA COUNTY SHERIFF (Text Message) Rescue neeeded at 13791 GAR Hwy for an unknown type overdose called into your station /2800 TXT STOP to opt-out",
        "CALL:Rescue neeeded",
        "ADDR:13791 GAR Hwy",
        "INFO:for an unknown type overdose called into your station / 2800");

    doTest("T8",
        "GEAUGA COUNTY SHERIFF (Text Message) INJURY ACCIDENT AT - GAR and Old State for 2 car MVA with possible injuries. TXT STOP to opt-out",
        "CALL:INJURY ACCIDENT",
        "PLACE:GAR and Old State for 2 car MVA with possible injuries.");

    doTest("T9",
        "GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 9600 S brown rd for 50 yom with chest pain. TXT STOP to opt-out",
        "CALL:RESCUE",
        "ADDR:9600 S brown rd",
        "INFO:for 50 yom with chest pain");

    doTest("T10",
        "GEAUGA COUNTY SHERIFF (Text Message) 14949 Rock Creek Rd. 40 y/o/m abdominal pain TXT STOP to opt-out",
        "CALL:40 y / o / m abdominal pain",
        "ADDR:14949 Rock Creek Rd");

    doTest("T11",
        "GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 668 WOODLAWN RD ELDERLY FEMALE DIFFICUTLY BREATHING TXT STOP to opt-out",
        "CALL:RESCUE",
        "ADDR:668 WOODLAWN RD",
        "INFO:ELDERLY FEMALE DIFFICUTLY BREATHING");

    doTest("T12",
        "GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 9544 old state 32 yof chest pain TXT STOP to opt-out",
        "CALL:RESCUE",
        "PLACE:9544",
        "ADDR:old state 32",
        "MADDR:9544,old state 32",
        "INFO:yof chest pain");

    doTest("T13",
        "GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 9051 brakeman 57 yof ill TXT STOP to opt-out",
        "CALL:RESCUE",
        "PLACE:9051 brakeman 57 yof ill");

    doTest("T14",
        "GEAUGA COUNTY SHERIFF (Text Message) Rescue needed at 9051 Brakemen for 57yof compl of feeling ill TXT STOP to opt-out",
        "CALL:Rescue",
        "PLACE:9051 Brakemen for 57yof compl of feeling ill");

    doTest("T15",
        "GEAUGA COUNTY SHERIFF (Text Message) INJURY ACCIDENT AT - 1 CAR 1 ENTRAP 1 EJECTED 608 BY WALKING STICK TXT STOP to opt-out",
        "CALL:INJURY ACCIDENT",
        "PLACE:1 CAR 1 ENTRAP 1 EJECTED 608 BY WALKING STICK");

    doTest("T16",
        "GEAUGA COUNTY SHERIFF (Text Message 1of2) RESCUE IS NEEDED AT - 8325 MADISON RD M/A TO THOMPSON WITH A SQUAD FOR 1 CAR MVA ROLLOVER TXT STOP to opt-out",
        "CALL:RESCUE",
        "ADDR:8325 MADISON RD",
        "INFO:M / A TO THOMPSON WITH A SQUAD FOR 1 CAR MVA ROLLOVER");

    doTest("T17",
        "GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 9488 wildwood -- 46 y/o male -- possible alcohol poison -- 2800 TXT STOP to opt-out",
        "CALL:RESCUE",
        "ADDR:9488 wildwood",
        "INFO:46 y/o male -- possible alcohol poison -- 2800");

    doTest("T18",
        "GEAUGA COUNTY SHERIFF (Text Message) M/A to Chardon for a Fire Alarm off at Geauga Hospital. 2800/Wright TXT STOP to opt-out",
        "PLACE:M/A to Chardon for a Fire Alarm off at Geauga Hospital. 2800/Wright");

    doTest("T19",
        "GEAUGA COUNTY SHERIFF (Text Message) FIRE DEPT NEEDED AT - M/A TO MONTVILLE 9141 CLAY ST SMELL OF GAS IN THE HOUSE TXT STOP to opt-out",
        "CALL:FIRE DEPT NEEDED",
        "PLACE:M/A TO MONTVILLE",
        "ADDR:9141 CLAY ST",
        "INFO:SMELL OF GAS IN THE HOUSE");

    doTest("T20",
        "GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 14181 RADCLIFFE RD 72 YO FEMALE CONS NOT RESPONSIVE HIST OF HEART PROBLEMS TXT STOP to opt-out",
        "CALL:RESCUE",
        "ADDR:14181 RADCLIFFE RD",
        "INFO:72 YO FEMALE CONS NOT RESPONSIVE HIST OF HEART PROBLEMS");

    doTest("T21",
        "GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - hambden twp park -- 13860 gar hwy -- 16 y/o male -- back pain -- 2800 TXT STOP to opt-out",
        "CALL:RESCUE",
        "PLACE:hambden twp park",
        "ADDR:13860 gar hwy",
        "INFO:16 y/o male -- back pain -- 2800");

    doTest("T22",
        "GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - sunco station female in custody hx heart problems TXT STOP to opt-out",
        "CALL:RESCUE",
        "PLACE:sunco station female in custody hx heart problems");

    doTest("T23",
        "GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 9922 OLD STATE RD 90 YO FEMALE DIFF BREATHING TXT STOP to opt-out",
        "CALL:RESCUE",
        "ADDR:9922 OLD STATE RD",
        "INFO:90 YO FEMALE DIFF BREATHING");

    doTest("T24",
        "GEAUGA COUNTY SHERIFF (Text Message) Rescue needed at 1 La Verne Ln, female possible going into Labor. 2800/Wright TXT STOP to opt-out",
        "CALL:Rescue",
        "ADDR:1 La Verne Ln",
        "INFO:female possible going into Labor 2800 / Wright");

    doTest("T25",
        "GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 12115 COUNTRY OAKS TRL 96 Y/O/F POSSIBLE D.O.A. 2800/DP TXT STOP to opt-out",
        "CALL:RESCUE",
        "ADDR:12115 COUNTRY OAKS TRL",
        "INFO:96 Y / O / F POSSIBLE DOA 2800 / DP");
    
  }
  
  public static void main(String[] args) {
    new OHGeaugaCountyParserTest().generateTests("T1", "CALL ADDR APT INFO PLACE");
  }
}