package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PALebanonCountyParserTest extends BaseParserTest {
  
  public PALebanonCountyParserTest() {
    setParser(new PALebanonCountyParser(), "LEBANON COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Heidelberg Township 3 GLASSMOYER LN WF - Wildfire/Brush Fire Box 35-05 FG3 A160",
        "CITY:HEIDELBERG TOWNSHIP",
        "ADDR:3 GLASSMOYER LN",
        "CALL:WF - Wildfire/Brush Fire",
        "BOX:35-05",
        "UNIT:FG3 A160");

    doTest("T2",
        "City of Lebanon 541 SPRUCE ST Med Class1 Hemorrhage Box 190-2 199MU",
        "CITY:LEBANON",
        "ADDR:541 SPRUCE ST",
        "CALL:Med Class1 Hemorrhage",
        "BOX:190-2",
        "UNIT:199MU");

    doTest("T3",
        "Cornwall Borough 113 WENGER ST Med Class3 Fall Victim BOX 190-6 A192",
        "CITY:CORNWALL",
        "ADDR:113 WENGER ST",
        "CALL:Med Class3 Fall Victim",
        "BOX:190-6",
        "UNIT:A192");

    doTest("T4",
        "City of Lebanon 437 NEW ST Med Class1 Abdominal Pain Box190-2 BC190",
        "CITY:LEBANON",
        "ADDR:437 NEW ST",
        "CALL:Med Class1 Abdominal Pain",
        "BOX:190-2",
        "UNIT:BC190");

    doTest("T5",
        "City of Lebanon 220 E WEIDMAN ST Med Class1 ALOC Box 190-2 A193 M12-3",
        "CITY:LEBANON",
        "ADDR:220 E WEIDMAN ST",
        "CALL:Med Class1 ALOC",
        "BOX:190-2",
        "UNIT:A193 M12-3");

    doTest("T6",
        "South Lebanon Township 590 S 5TH AVE * Cedar Haven ROOM 313F Med Class1 Heart Problem Box 190-3 193MU",
        "CITY:SOUTH LEBANON TOWNSHIP",
        "ADDR:590 S 5TH AVE",
        "PLACE:Cedar Haven ROOM 313F",
        "CALL:Med Class1 Heart Problem",
        "BOX:190-3",
        "UNIT:193MU");

    doTest("T7",
        "Palmyra Borough 101 S RAILROAD ST * Palmyra Interfaith Manor AFA - Auto Fire Alarm BOX 1-01 FG 3 W1 E2",
        "CITY:PALMYRA",
        "ADDR:101 S RAILROAD ST",
        "PLACE:Palmyra Interfaith Manor",
        "CALL:AFA - Auto Fire Alarm",
        "BOX:1-01",
        "UNIT:FG 3 W1 E2");

    doTest("T8",
        "North Cornwall Township 900 TUCK ST * Manor Care Med Class1 Altered Mental Status Box 190-8 193MU",
        "CITY:NORTH CORNWALL TOWNSHIP",
        "ADDR:900 TUCK ST",
        "PLACE:Manor Care",
        "CALL:Med Class1 Altered Mental Status",
        "BOX:190-8",
        "UNIT:193MU");

    doTest("T9",
        "City of Lebanon LEHMAN ST N 7TH ST MV - Accident w/Injuries Box 15-06 E15-2 R24 AmbCo190",
        "CITY:LEBANON",
        "ADDR:LEHMAN ST & N 7TH ST",
        "CALL:MV - Accident w/Injuries",
        "BOX:15-06",
        "UNIT:E15-2 R24 AmbCo190");

    doTest("T10",
        "City of Lebanon S 7TH ST CHESTNUT ST MV - Accident w/Injuries Box 15-03 E15-1 SQ22 R24 AmbCo190",
        "CITY:LEBANON",
        "ADDR:S 7TH ST & CHESTNUT ST",
        "CALL:MV - Accident w/Injuries",
        "BOX:15-03",
        "UNIT:E15-1 SQ22 R24 AmbCo190");

    doTest("T11",
        "City of Lebanon 544 N 8TH ST Med Class3 302 Commitment Assist MHMR Box 190-2 A198",
        "CITY:LEBANON",
        "ADDR:544 N 8TH ST",
        "CALL:Med Class3 302 Commitment Assist MHMR",
        "BOX:190-2",
        "UNIT:A198");

    doTest("T12",
        "Heidelberg Township 3 GLASSMOYER LN WF - Wildfire/Brush Fire Box 35-05 FG3 **Second Alert** A160",
        "CITY:HEIDELBERG TOWNSHIP",
        "ADDR:3 GLASSMOYER LN",
        "CALL:WF - Wildfire/Brush Fire",
        "BOX:35-05",
        "UNIT:FG3 **Second Alert** A160");

    doTest("T13",
        "Swatara Township 68 SUPERVISORS DR AREA OF WF - Wildfire/Brush Fire Box 47-05 FG-3 E10 R47 AT47 PT47 AmbCo190",
        "CITY:SWATARA TOWNSHIP",
        "ADDR:68 SUPERVISORS DR",
        "PLACE:AREA OF",
        "CALL:WF - Wildfire/Brush Fire",
        "BOX:47-05",
        "UNIT:FG-3 E10 R47 AT47 PT47 AmbCo190");

    doTest("T14",
        "South Lebanon Township 518 S 5TH ST SUPPORTIVE CONCEPTS Med Class3 Abdominal Pain Box 190-4 A198",
        "CITY:SOUTH LEBANON TOWNSHIP",
        "ADDR:518 S 5TH ST",
        "PLACE:SUPPORTIVE CONCEPTS",
        "CALL:Med Class3 Abdominal Pain",
        "BOX:190-4",
        "UNIT:A198");

    doTest("T15",
        "(FASP@20:13) City of Lebanon CUMBERLAND ST N 9TH ST MV - Accident w/Injuries Pedestrian Struck Box 15-04 Class 1 for EMS BC190 \n\nTo unsubscribe reply STOP",
        "CITY:LEBANON",
        "ADDR:CUMBERLAND ST & N 9TH ST",
        "CALL:MV - Accident w/Injuries Pedestrian Struck",
        "BOX:15-04",
        "UNIT:Class 1 for EMS BC190 \n\nTo unsubscribe reply STOP");
 }
  
  public static void main(String[] args) {
    new PALebanonCountyParserTest().generateTests("T1", "CITY ADDR APT PLACE CALL BOX UNIT");
  }
}
