package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Lebanon County, PA
Contact: Loren Miller <lmiller05@gmail.com>
Sender: 7176798487

Current call logs available at http://lebanonema.org/pager/html/monitor.html

Heidelberg Township 3 GLASSMOYER LN WF - Wildfire/Brush Fire Box 35-05 FG3 A160
City of Lebanon 541 SPRUCE ST Med Class1 Hemorrhage Box 190-2 199MU
Cornwall Borough 113 WENGER ST Med Class3 Fall Victim BOX 190-6 A192
City of Lebanon 437 NEW ST Med Class1 Abdominal Pain Box190-2 BC190
City of Lebanon 220 E WEIDMAN ST Med Class1 ALOC Box 190-2 A193 M12-3
South Lebanon Township 590 S 5TH AVE * Cedar Haven ROOM 313F Med Class1 Heart Problem Box 190-3 193MU
Palmyra Borough 101 S RAILROAD ST * Palmyra Interfaith Manor AFA - Auto Fire Alarm BOX 1-01 FG 3 W1 E2
North Cornwall Township 900 TUCK ST * Manor Care Med Class1 Altered Mental Status Box 190-8 193MU
City of Lebanon LEHMAN ST N 7TH ST MV - Accident w/Injuries Box 15-06 E15-2 R24 AmbCo190
City of Lebanon S 7TH ST CHESTNUT ST MV - Accident w/Injuries Box 15-03 E15-1 SQ22 R24 AmbCo190
City of Lebanon 544 N 8TH ST Med Class3 302 Commitment Assist MHMR Box 190-2 A198 
Heidelberg Township 3 GLASSMOYER LN WF - Wildfire/Brush Fire Box 35-05 FG3 **Second Alert** A160 
Swatara Township 68 SUPERVISORS DR AREA OF WF - Wildfire/Brush Fire Box 47-05 FG-3 E10 R47 AT47 PT47 AmbCo190 
South Lebanon Township 518 S 5TH ST SUPPORTIVE CONCEPTS Med Class3 Abdominal Pain Box 190-4 A198

Contact: Clinton Masr <mastclinton@gmail.com>
Sender: km911alert@gmail.com
(FASP@20:13) City of Lebanon CUMBERLAND ST N 9TH ST MV - Accident w/Injuries Pedestrian Struck Box 15-04 Class 1 for EMS BC190 \n\nTo unsubscribe reply STOP

Contact: nevin weaver <weavmy36@gmail.com>
Sender: km911alert@gmail.com
Subject:Sta 29@12:50\nSouth Lebanon Twp 2618 KING ST MI - Miscellaneous Wire Down FG 3 E29 Fire-Box 29-01 EMS-Box 140-1\r\n\r\nTo unsubscribe r\r
Subject:Sta 29@04:39\nRichland Boro 308 POPLAR ST CORETEC PLASTICS BC - Business/Commercial Roof Fire FG-3 E33 SQ33 E34 E34-1 W31 TK31 PT30\r

Contact: "Roger Funck" <rogerfunck@verizon.net>
Sender: 7176798487
Sender: km911alert@gmail.com
East Hanover Township 7 TOWER LN AREA OF MV - Accident w/Injuries fg 3 E12  Fire-Box 12-03 EMS-Box 190-16
North Annville Township BLACKS BRIDGE RD HOSTETTER LN AREA OF SF - Dwelling Fire Barn Fire FG3 E6 R5 QRS6 E7 E12 E75 TK12 SQ12 T6 T6-1 T7 PT47 AmbCo19
North Annville Township BLACKS BRIDGE RD HOSTETTER LN AREA OF BF - Barn Fire Barn Fire FG3  Box is In-Service Auth Dep 6 SQ12 T6 T6-1  Fire-Box 6-03 E
(Sta 12@12:30) East Hanover Twp DAUPHIN COUNTY 257 BOW CREEK RD=AREA OF BF - Barn Fire FG 5 E1-1 TK12 Fire-Box EMS-Box\n\nTo unsubscribe reply STOP
DAUPHIN CO/EAST HANOVER  9708 ALLENTOWN BLVD. AFA - Auto Fire Alarm TK12 E1-1  Fire-Box EMS-Box
East Hanover Township 102 RACE HORSE DR OB - Other Building Garage Fire FG3 E12 E75 E10 TK12 R10 T11 T7 T6 AmbCo190  Fire-Box 12-01 EMS-Box 190-17
DAUPHIN COUNTY EAST HANOVER TWP=105 KELLY CT MAIN STATE HOTEL  BC - Business/Commercial Smoke Reported On The 2nd Floor  W1 TK12  Fire-Box EMS-Box

Contact: Thomas Miller <rattielover35@yahoo.com>
Sender: km911alert@gmail.com
Sender: 7176798487
(Sta 2@19:42) DAUPHIN EAST HANOVER 123 AUTOMATIC LN SF - Dwelling Fire WORKING STRUCTURE FIRE T2 Fire-Box EMS-Box\n\nTo unsubscribe reply STOP
LANCASTER ELIZABETH TWP PUMPING STATION RD AT ROUTE 322   MV - Accident w/Injuries MOTORCYCLE ACCIDENT E35  Fire-Box EMS-Box
(Sta 47@16:49) Bethel Twp 400 INTERSTATE 78 E AIRCFT-w/injuries Box In Service AUTH Command 41 FG 3 AT47 Fire-Box 41-96 EMS-Box 190-21\r\n\r\nTo unsubscribe reply 

Contact: Kyle Brock <ksbrock@hotmail.com>
Sender: km911alert@gmail.com
Amb 140@23:53 / Jackson Twp 21 FERNWOOD DR Med Class3 sick person A141 Fire-Box 30-01 EMS-Box 140-2\n\nTo unsubscribe reply STOP\n\n

Contact: Active911
Agency name: Lawn Fire Dept
Location: Lawn, PA, United States
Sender: "KM-911" <km911alert@gmail.com>

(Sta 3@13:26) West Cornwall Twp 103 PINE AVE IS - Investigation Inside Struct Box In Service Auth Command AT3 Fire-Box 38-01 EMS-Box 180-3\n\nTo unsubscribe reply STOP
(Sta 3@13:02) West Cornwall Twp 103 PINE AVE IS - Investigation Inside Struct CO Detector Activation FG 3 E37 AT38 R38 AmbCo180 TK36 BR38 AT3 R5 T38 PT3 AmbCo190 LE2-7-2 Fire-Box 38-01 EMS-Box 180-3\n\nTo unsubscribe reply STOP
(Sta 3@09:53) South Londonderry Twp 200 CHESTNUT HILL RD BF - Barn Fire FG3 E2 E2-1 TW1 AT3 R2 DAL48 T2-1 AmbCo180 W1 DE48 DTK48 E1-1 PT3 T38 CHF2 Fire-Box 2-05 EMS-Box 4-3\n\nTo unsubscribe reply STOP
City of Lebanon 1584 CHESTNUT ST Med Class1 SEIZURES (TEST TEST TEST) 199MU Fire-Box 15-04 EMS-Box 190-1\n\nTo unsubscribe reply STOP

Contact: Active911
Agency name: Mt Gretna Fire Company
Location: Mt Gretna, PA, United States
Sender: "KM-911" <km911alert@gmail.com>

(Sta 38@13:26) West Cornwall Twp 103 PINE AVE IS - Investigation Inside Struct Box In Service Auth Command E38 Fire-Box 38-01 EMS-Box 180-3\n\nTo unsubscribe reply STOP
(Sta 38@13:26) West Cornwall Twp 103 PINE AVE IS - Investigation Inside Struct Box In Service Auth Command AT38 BR38 E37 Fire-Box 38-01 EMS-Box 180-3\n\nTo unsubscribe reply STOP
(Sta 38@13:08) West Cornwall Twp 103 PINE AVE IS - Investigation Inside Struct CO Detector Activation FG 3 E38 Fire-Box 38-01 EMS-Box 180-3\n\nTo unsubscribe reply STOP
(Sta 38@13:02) West Cornwall Twp 103 PINE AVE IS - Investigation Inside Struct CO Detector Activation FG 3 E37 AT38 R38 AmbCo180 TK36 BR38 AT3 R5 T38 PT3 AmbCo190 LE2-7-2 Fire-Box 38-01 EMS-Box 180-3\n\nTo unsubscribe reply STOP
(Sta 38@09:54) South Londonderry Twp 200 CHESTNUT HILL RD BF - Barn Fire FG3 E2 E2-1 TW1 AT3 R2 DAL48 T2-1 AmbCo180 W1 DE48 DTK48 E1-1 PT3 T38 CHF2 Fire-Box 2-05 EMS-Box 4-3\n\nTo unsubscribe reply STOP
(Sta 38@14:52) West Cornwall Twp MAIN ST QUENTIN RD SC - Spill Control FG 3 E37 R38 Fire-Box 37-01 EMS-Box 190-7\n\nTo unsubscribe reply STOP
City of Lebanon 1584 CHESTNUT ST Med Class1 SEIZURES (TEST TEST TEST) 199MU Fire-Box 15-04 EMS-Box 190-1\n\nTo unsubscribe reply STOP
City of Lebanon 7 WOODLAND EST SF - Dwelling Fire (TEST TEST TEST) E15-1 SQ22 E15-2 TK15 R24 AmbCo190 Fire-Box 15-02 EMS-Box 190-1\n\nTo unsubscribe reply STOP
North Lebanon Twp 175 GRUBB AVE SF - Dwelling Fire SMOKE DETECTOR ACTIVATION FG3 E28 AmbCo190 E40 R24 PT43 T40 T29 TK26 Fire-Box 28-04 EMS-Box 190-10\n\nTo unsubscribe reply STOP
TEST TEST TEST North Lebanon Twp 175 GRUBB AVE SF - Dwelling Fire (TEST TEST TEST) SMOKE DETECTOR ACTIVATION FG3 E28 AmbCo190 E40 R24 PT43 T40 T29 TK26 Fire-Box 28-04 EMS-Box 190-10\n\nTo unsubscribe reply STOP
South Lebanon Twp 590 S 5TH AVE Cedar HavenMed Class1 SYNCOPE 195MU Fire-Box 26-01 EMS-Box 190-3\n\nTo unsubscribe reply STOP
(FASP@16:17) Cornwall Boro 1 BOYD ST Cornwall Manor CLINIC BRADLEY HALL Med Class1 Sick Person 192MU Fire-Box 36-21 EMS-Box 190-6\n\nTo unsubscribe reply STOP
(FASP@16:04) 201 S LANCASTER ST APT 44 Med Class1 medical alarm difficulty breathing A280 199MU Fire-Box EMS-Box\n\nTo unsubscribe reply STOP
(FASP@15:30) Jackson Twp 100 EVERGREEN DR ELCO INTERMEDIATE SCHOOL Med Class1 CARDIAC ARREST BC190 Fire-Box 31-04 EMS-Box 140-1\n\nTo unsubscribe reply STOP
(FASP@15:26) Jackson Twp 100 EVERGREEN DR Med Class1 CARDIAC ARREST A160 M12-2 AmbCo140 R31 Fire-Box 31-04 EMS-Box 140-1\n\nTo unsubscribe reply STOP
(FASP@15:11) South Lebanon Twp 590 S 5TH AVE Cedar HavenMed Class1 SYNCOPE 195MU Fire-Box 26-01 EMS-Box 190-3\n\nTo unsubscribe reply STOP
(FASP@15:00) City of Lebanon 1584 CHESTNUT ST Med Class1 SEIZURES 199MU Fire-Box 15-04 EMS-Box 190-1\n\nTo unsubscribe reply STOP
(FASP@14:57) Millcreek Twp 242 MEMORIAL BLVD Med Class1 BACK PAIN/A140 cover for A150 and BA650 AmbCo150 A141 M12-2 Fire-Box 34-01 EMS-Box 150-1\n\nTo unsubscribe reply STOP
(FASP@14:35) LANCASTER COUNTY ELIZABETH TWP 257 LANCASTER AVE Med Class1 ASSIST 2-5 FALL VICTIM 192MU Fire-Box EMS-Box\n\nTo unsubscribe reply STOP
(FASP@13:24) North Lebanon Twp 1794 ASHTON DR Med Class3 FALL VICTIM 199MU Fire-Box 9-01 EMS]agx 190-9\n\nTo unsubscribe reply STOP

Contact: Active911
Agency name: Mt Zion Fire Co
Location: Lebanon, PA, United States
Sender: "KM-911" <km911alert@gmail.com>

(Sta 43@17:38) North Lebanon Twp KOCHENDERFER RD SANDHILL RD OS - Investigation Outside FG 4 E42 E43 E9 R42 R24 AmbCo190 Fire-Box 42-01 EMS-Box 190-9\n\nTo unsubscribe reply STOP
(Sta 41@20:58) Bethel Twp 2957 STATE ROUTE 22 ESTHERS RESTAURANT AFA - Auto Fire Alarm FG 4 Box in Service AUTH Dep 41 E41 E41-1 T41 Fire-Box 41-98 EMS-Box 190-21\n\nTo unsubscribe reply STOP
(Sta 41@20:52) Bethel Twp 2957 STATE ROUTE 22 ESTHERS RESTAURANT AFA - Auto Fire Alarm FG 4 E41 E41-1 T41 AmbCo190 Fire-Box 41-98 EMS-Box 190-21\n\nTo unsubscribe reply STOP
(Sta 41@13:50) Bethel Twp 158 N CENTER ST Med Class1 NEAR SYNCOPE E41 Fire-Box 41-01 EMS-Box 190-21\n\nTo unsubscribe reply STOP
(Sta 41@13:43) Bethel Twp 158 N CENTER ST Med Class1 NEAR SYNCOPE 199MU E41-1 Fire-Box 41-01 EMS-Box 190-21\n\nTo unsubscribe reply STOP
(Sta 28@10:47) North Lebanon Twp 1643 N 7TH ST MV - Accident w/Injuries FG 3 **CANCEL THE CALL** E28 Fire-Box 43-01 EMS-Box 190-10\n\nTo unsubscribe reply STOP
(Sta 43@10:45) North Lebanon Twp 1643 N 7TH ST MV - Accident w/Injuries FG 3 SQ43 Fire-Box 43-01 EMS-Box 190-10\n\nTo unsubscribe reply STOP
(Sta 43@10:41) North Lebanon Twp 1643 N 7TH ST MV - Accident w/Injuries FG 3 E43 E28 AmbCo190 Fire-Box 43-01 EMS-Box 190-10\n\nTo unsubscribe reply STOP
(Sta 43@16:17) North Lebanon Twp 309 SUNSET LN AFA - Auto Fire Alarm ******BOX IN SERVICE****** PT43 Fire-Box 43-04 EMS-Box 190-9\n\nTo unsubscribe reply STOP
(Sta 43@16:16) North Lebanon Twp 309 SUNSET LN AFA - Auto Fire Alarm ******BOX IN SERVICE****** E43 Fire-Box 43-04 EMS-Box 190-9\n\nTo unsubscribe reply STOP
(Sta 43@16:13) North Lebanon Twp 309 SUNSET LN AFA - Auto Fire Alarm FG 03 E43 E9 R42 AmbCo190 E42 PT43 Fire-Box 43-04 EMS-Box 190-9\n\nTo unsubscribe reply STOP
(Sta 1@12:12) Palmyra Boro 315 N CHESTNUT ST SF - Dwelling Fire Reported Building Collapse FG-3 W1 E2 E1-1 DTK48 R2 AmbCo4 TW1 Fire-Box 1-02 EMS-Box 4-1\n\nTo unsubscribe reply STOP
(Sta 1@04:10) North Londonderry Twp 618 CAMBRIDGE CT SF - Dwelling Fire AUDIBLE ALARM ACTIVATION E1-1 AmbCo4 E2 W1 DTK48 R2 TW1 UT1 Fire-Box 1-08 EMS-Box 4-2\n\nTo unsubscribe reply STOP

*/

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
        "PRI:1",
        "CALL:Hemorrhage",
        "BOX:190-2",
        "UNIT:199MU");

    doTest("T3",
        "Cornwall Borough 113 WENGER ST Med Class3 Fall Victim BOX 190-6 A192",
        "CITY:CORNWALL",
        "ADDR:113 WENGER ST",
        "PRI:3",
        "CALL:Fall Victim",
        "BOX:190-6",
        "UNIT:A192");

    doTest("T4",
        "City of Lebanon 437 NEW ST Med Class1 Abdominal Pain Box190-2 BC190",
        "CITY:LEBANON",
        "ADDR:437 NEW ST",
        "PRI:1",
        "CALL:Abdominal Pain",
        "BOX:190-2",
        "UNIT:BC190");

    doTest("T5",
        "City of Lebanon 220 E WEIDMAN ST Med Class1 ALOC Box 190-2 A193 M12-3",
        "CITY:LEBANON",
        "ADDR:220 E WEIDMAN ST",
        "PRI:1",
        "CALL:ALOC",
        "BOX:190-2",
        "UNIT:A193 M12-3");

    doTest("T6",
        "South Lebanon Township 590 S 5TH AVE * Cedar Haven ROOM 313F Med Class1 Heart Problem Box 190-3 193MU",
        "CITY:SOUTH LEBANON TOWNSHIP",
        "ADDR:590 S 5TH AVE",
        "PLACE:Cedar Haven ROOM 313F",
        "PRI:1",
        "CALL:Heart Problem",
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
        "PRI:1",
        "CALL:Altered Mental Status",
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
        "PRI:3",
        "CALL:302 Commitment Assist MHMR",
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
        "PRI:3",
        "CALL:Abdominal Pain",
        "BOX:190-4",
        "UNIT:A198");

    doTest("T15",
        "(FASP@20:13) City of Lebanon CUMBERLAND ST N 9TH ST MV - Accident w/Injuries Pedestrian Struck Box 15-04 Class 1 for EMS BC190 \n\nTo unsubscribe reply STOP",
        "CITY:LEBANON",
        "ADDR:CUMBERLAND ST & N 9TH ST",
        "PRI:1",
        "CALL:MV - Accident w/Injuries Pedestrian Struck",
        "BOX:15-04",
        "UNIT:BC190");
 }
  
  @Test
  public void testNevinWeaver() {

    doTest("T1",
        "Subject:Sta 29@12:50\n" +
        "South Lebanon Twp 2618 KING ST MI - Miscellaneous Wire Down FG 3 E29 Fire-Box 29-01 EMS-Box 140-1\r\n" +
        "\r\n" +
        "To unsubscribe r\r",

        "CITY:SOUTH LEBANON TWP",
        "ADDR:2618 KING ST",
        "CALL:MI - Miscellaneous Wire Down",
        "BOX:Fire:29-01 EMS:140-1",
        "UNIT:FG 3 E29");

    doTest("T2",
        "Subject:Sta 29@04:39\n" +
        "Richland Boro 308 POPLAR ST CORETEC PLASTICS BC - Business/Commercial Roof Fire FG-3 E33 SQ33 E34 E34-1 W31 TK31 PT30\r",

        "CITY:RICHLAND",
        "ADDR:308 POPLAR ST",
        "PLACE:CORETEC PLASTICS",
        "CALL:BC - Business/Commercial Roof Fire",
        "UNIT:FG-3 E33 SQ33 E34 E34-1 W31 TK31 PT30");

  }
  
  @Test
  public void testRobertFunc() {

    doTest("T1",
        "East Hanover Township 7 TOWER LN AREA OF MV - Accident w/Injuries fg 3 E12  Fire-Box 12-03 EMS-Box 190-16",
        "CITY:EAST HANOVER TOWNSHIP",
        "ADDR:7 TOWER LN",
        "PLACE:AREA OF",
        "CALL:MV - Accident w/Injuries",
        "BOX:Fire:12-03 EMS:190-16",
        "UNIT:FG 3 E12");

    doTest("T2",
        "North Annville Township BLACKS BRIDGE RD HOSTETTER LN AREA OF SF - Dwelling Fire Barn Fire FG3 E6 R5 QRS6 E7 E12 E75 TK12 SQ12 T6 T6-1 T7 PT47 AmbCo19",
        "CITY:NORTH ANNVILLE TOWNSHIP",
        "ADDR:BLACKS BRIDGE RD & HOSTETTER LN",
        "PLACE:AREA OF",
        "CALL:SF - Dwelling Fire Barn Fire",
        "UNIT:FG3 E6 R5 QRS6 E7 E12 E75 TK12 SQ12 T6 T6-1 T7 PT47 AMBCO19");

    doTest("T3",
        "(Sta 12@12:30) East Hanover Twp DAUPHIN COUNTY 257 BOW CREEK RD=AREA OF BF - Barn Fire FG 5 E1-1 TK12 Fire-Box EMS-Box\n\n" +
        "To unsubscribe reply STOP",

        "CITY:EAST HANOVER TWP, DAUPHIN COUNTY",
        "ADDR:257 BOW CREEK RD",
        "PLACE:AREA OF",
        "CALL:BF - Barn Fire",
        "UNIT:FG 5 E1-1 TK12");

    doTest("T4",
        "DAUPHIN CO/EAST HANOVER  9708 ALLENTOWN BLVD. AFA - Auto Fire Alarm TK12 E1-1  Fire-Box EMS-Box",
        "CITY:EAST HANOVER, DAUPHIN COUNTY",
        "ADDR:9708 ALLENTOWN BLVD",
        "CALL:AFA - Auto Fire Alarm",
        "UNIT:TK12 E1-1");

    doTest("T5",
        "East Hanover Township 102 RACE HORSE DR OB - Other Building Garage Fire FG3 E12 E75 E10 TK12 R10 T11 T7 T6 AmbCo190  Fire-Box 12-01 EMS-Box 190-17",
        "CITY:EAST HANOVER TOWNSHIP",
        "ADDR:102 RACE HORSE DR",
        "CALL:OB - Other Building Garage Fire",
        "BOX:Fire:12-01 EMS:190-17",
        "UNIT:FG3 E12 E75 E10 TK12 R10 T11 T7 T6 AMBCO190");

    doTest("T6",
        "DAUPHIN COUNTY EAST HANOVER TWP=105 KELLY CT MAIN STATE HOTEL  BC - Business/Commercial Smoke Reported On The 2nd Floor  W1 TK12  Fire-Box EMS-Box",
        "CITY:EAST HANOVER TWP, DAUPHIN COUNTY",
        "ADDR:105 KELLY CT",
        "PLACE:MAIN STATE HOTEL",
        "CALL:BC - Business/Commercial Smoke Reported On The 2nd Floor",
        "UNIT:W1 TK12");

  }
  
  @Test
  public void testThomasMiller() {

    doTest("T1",
        "(Sta 2@19:42) DAUPHIN EAST HANOVER 123 AUTOMATIC LN SF - Dwelling Fire WORKING STRUCTURE FIRE T2 Fire-Box EMS-Box\n\n" +
        "To unsubscribe reply STOP",

        "CITY:EAST HANOVER, DAUPHIN COUNTY",
        "ADDR:123 AUTOMATIC LN",
        "CALL:SF - Dwelling Fire WORKING STRUCTURE FIRE",
        "UNIT:T2");

    doTest("T2",
        "LANCASTER ELIZABETH TWP PUMPING STATION RD AT ROUTE 322   MV - Accident w/Injuries MOTORCYCLE ACCIDENT E35  Fire-Box EMS-Box",
        "CITY:ELIZABETH TWP, LANCASTER COUNTY",
        "ADDR:PUMPING STATION RD",
        "MADDR:PUMPING STATION RD & ROUTE 322",
        "X:ROUTE 322",
        "CALL:MV - Accident w/Injuries MOTORCYCLE ACCIDENT",
        "UNIT:E35");

    doTest("T3",
        "(Sta 47@16:49) Bethel Twp 400 INTERSTATE 78 E AIRCFT-w/injuries Box In Service AUTH Command 41 FG 3 AT47 Fire-Box 41-96 EMS-Box 190-21\r\n" +
        "\r\n" +
        "To unsubscribe reply ",

        "CITY:BETHEL TWP",
        "ADDR:400 INTERSTATE 78 E",
        "CALL:AIRCFT-w/injuries Box In Service AUTH Command 41",
        "BOX:Fire:41-96 EMS:190-21",
        "UNIT:FG 3 AT47");

  }
  
  @Test
  public void testKyleBrock() {

    doTest("T1",
        "Amb 140@23:53 / Jackson Twp 21 FERNWOOD DR Med Class3 sick person A141 Fire-Box 30-01 EMS-Box 140-2\n\nTo unsubscribe reply STOP\n\n",
        "CITY:AMB 140@23:53 / JACKSON TWP",
        "ADDR:21 FERNWOOD DR",
        "PRI:3",
        "CALL:sick person",
        "BOX:Fire:30-01 EMS:140-2",
        "UNIT:A141");

  }
  
  @Test
  public void testLawnFire() {

    doTest("T1",
        "(Sta 3@13:26) West Cornwall Twp 103 PINE AVE IS - Investigation Inside Struct Box In Service Auth Command AT3 Fire-Box 38-01 EMS-Box 180-3\n\n" +
        "To unsubscribe reply STOP",

        "CITY:WEST CORNWALL TWP",
        "ADDR:103 PINE AVE",
        "CALL:IS - Investigation Inside Struct Box In Service Auth Command",
        "BOX:Fire:38-01 EMS:180-3",
        "UNIT:AT3");

    doTest("T2",
        "(Sta 3@13:02) West Cornwall Twp 103 PINE AVE IS - Investigation Inside Struct CO Detector Activation FG 3 E37 AT38 R38 AmbCo180 TK36 BR38 AT3 R5 T38 PT3 AmbCo190 LE2-7-2 Fire-Box 38-01 EMS-Box 180-3\n\n" +
        "To unsubscribe reply STOP",

        "CITY:WEST CORNWALL TWP",
        "ADDR:103 PINE AVE",
        "CALL:IS - Investigation Inside Struct CO Detector Activation",
        "UNIT:FG 3 E37 AT38 R38 AMBCO180 TK36 BR38 AT3 R5 T38 PT3 AMBCO190 LE2-7-2",
        "BOX:Fire:38-01 EMS:180-3");

    doTest("T3",
        "(Sta 3@09:53) South Londonderry Twp 200 CHESTNUT HILL RD BF - Barn Fire FG3 E2 E2-1 TW1 AT3 R2 DAL48 T2-1 AmbCo180 W1 DE48 DTK48 E1-1 PT3 T38 CHF2 Fire-Box 2-05 EMS-Box 4-3\n\n" +
        "To unsubscribe reply STOP",

        "CITY:SOUTH LONDONDERRY TWP",
        "ADDR:200 CHESTNUT HILL RD",
        "CALL:BF - Barn Fire",
        "BOX:Fire:2-05 EMS:4-3",
        "UNIT:FG3 E2 E2-1 TW1 AT3 R2 DAL48 T2-1 AMBCO180 W1 DE48 DTK48 E1-1 PT3 T38 CHF2");

    doTest("T4",
        "City of Lebanon 1584 CHESTNUT ST Med Class1 SEIZURES (TEST TEST TEST) 199MU Fire-Box 15-04 EMS-Box 190-1\n\n" +
        "To unsubscribe reply STOP",

        "CITY:LEBANON",
        "ADDR:1584 CHESTNUT ST",
        "PRI:1",
        "CALL:SEIZURES (TEST TEST TEST)",
        "BOX:Fire:15-04 EMS:190-1",
        "UNIT:199MU");

  }
  
  @Test
  public void testMtGretnaFire() {

    doTest("T1",
        "(Sta 38@13:26) West Cornwall Twp 103 PINE AVE IS - Investigation Inside Struct Box In Service Auth Command E38 Fire-Box 38-01 EMS-Box 180-3\n\n" +
        "To unsubscribe reply STOP",

        "CITY:WEST CORNWALL TWP",
        "ADDR:103 PINE AVE",
        "CALL:IS - Investigation Inside Struct Box In Service Auth Command",
        "BOX:Fire:38-01 EMS:180-3",
        "UNIT:E38");

    doTest("T2",
        "(Sta 38@13:26) West Cornwall Twp 103 PINE AVE IS - Investigation Inside Struct Box In Service Auth Command AT38 BR38 E37 Fire-Box 38-01 EMS-Box 180-3\n\n" +
        "To unsubscribe reply STOP",

        "CITY:WEST CORNWALL TWP",
        "ADDR:103 PINE AVE",
        "CALL:IS - Investigation Inside Struct Box In Service Auth Command",
        "BOX:Fire:38-01 EMS:180-3",
        "UNIT:AT38 BR38 E37");

    doTest("T3",
        "(Sta 38@13:08) West Cornwall Twp 103 PINE AVE IS - Investigation Inside Struct CO Detector Activation FG 3 E38 Fire-Box 38-01 EMS-Box 180-3\n\n" +
        "To unsubscribe reply STOP",

        "CITY:WEST CORNWALL TWP",
        "ADDR:103 PINE AVE",
        "CALL:IS - Investigation Inside Struct CO Detector Activation",
        "BOX:Fire:38-01 EMS:180-3",
        "UNIT:FG 3 E38");

    doTest("T4",
        "(Sta 38@13:02) West Cornwall Twp 103 PINE AVE IS - Investigation Inside Struct CO Detector Activation FG 3 E37 AT38 R38 AmbCo180 TK36 BR38 AT3 R5 T38 PT3 AmbCo190 LE2-7-2 Fire-Box 38-01 EMS-Box 180-3\n\n" +
        "To unsubscribe reply STOP",

        "CITY:WEST CORNWALL TWP",
        "ADDR:103 PINE AVE",
        "CALL:IS - Investigation Inside Struct CO Detector Activation",
        "BOX:Fire:38-01 EMS:180-3",
        "UNIT:FG 3 E37 AT38 R38 AMBCO180 TK36 BR38 AT3 R5 T38 PT3 AMBCO190 LE2-7-2");

    doTest("T5",
        "(Sta 38@09:54) South Londonderry Twp 200 CHESTNUT HILL RD BF - Barn Fire FG3 E2 E2-1 TW1 AT3 R2 DAL48 T2-1 AmbCo180 W1 DE48 DTK48 E1-1 PT3 T38 CHF2 Fire-Box 2-05 EMS-Box 4-3\n\n" +
        "To unsubscribe reply STOP",

        "CITY:SOUTH LONDONDERRY TWP",
        "ADDR:200 CHESTNUT HILL RD",
        "CALL:BF - Barn Fire",
        "BOX:Fire:2-05 EMS:4-3",
        "UNIT:FG3 E2 E2-1 TW1 AT3 R2 DAL48 T2-1 AMBCO180 W1 DE48 DTK48 E1-1 PT3 T38 CHF2");

    doTest("T6",
        "(Sta 38@14:52) West Cornwall Twp MAIN ST QUENTIN RD SC - Spill Control FG 3 E37 R38 Fire-Box 37-01 EMS-Box 190-7\n\n" +
        "To unsubscribe reply STOP",

        "CITY:WEST CORNWALL TWP",
        "ADDR:MAIN ST & QUENTIN RD",
        "CALL:SC - Spill Control",
        "BOX:Fire:37-01 EMS:190-7",
        "UNIT:FG 3 E37 R38");

    doTest("T7",
        "City of Lebanon 1584 CHESTNUT ST Med Class1 SEIZURES (TEST TEST TEST) 199MU Fire-Box 15-04 EMS-Box 190-1\n\n" +
        "To unsubscribe reply STOP",

        "CITY:LEBANON",
        "ADDR:1584 CHESTNUT ST",
        "PRI:1",
        "CALL:SEIZURES (TEST TEST TEST)",
        "BOX:Fire:15-04 EMS:190-1",
        "UNIT:199MU");

    doTest("T8",
        "City of Lebanon 7 WOODLAND EST SF - Dwelling Fire (TEST TEST TEST) E15-1 SQ22 E15-2 TK15 R24 AmbCo190 Fire-Box 15-02 EMS-Box 190-1\n\n" +
        "To unsubscribe reply STOP",

        "CITY:LEBANON",
        "ADDR:7 WOODLAND EST",
        "CALL:SF - Dwelling Fire (TEST TEST TEST)",
        "BOX:Fire:15-02 EMS:190-1",
        "UNIT:E15-1 SQ22 E15-2 TK15 R24 AMBCO190");

    doTest("T9",
        "North Lebanon Twp 175 GRUBB AVE SF - Dwelling Fire SMOKE DETECTOR ACTIVATION FG3 E28 AmbCo190 E40 R24 PT43 T40 T29 TK26 Fire-Box 28-04 EMS-Box 190-10\n\n" +
        "To unsubscribe reply STOP",

        "CITY:NORTH LEBANON TWP",
        "ADDR:175 GRUBB AVE",
        "CALL:SF - Dwelling Fire SMOKE DETECTOR ACTIVATION",
        "BOX:Fire:28-04 EMS:190-10",
        "UNIT:FG3 E28 AMBCO190 E40 R24 PT43 T40 T29 TK26");

    doTest("T10",
        "TEST TEST TEST North Lebanon Twp 175 GRUBB AVE SF - Dwelling Fire (TEST TEST TEST) SMOKE DETECTOR ACTIVATION FG3 E28 AmbCo190 E40 R24 PT43 T40 T29 TK26 Fire-Box 28-04 EMS-Box 190-10\n\n" +
        "To unsubscribe reply STOP",

        "CITY:TEST TEST TEST NORTH LEBANON TWP",
        "ADDR:175 GRUBB AVE",
        "CALL:SF - Dwelling Fire (TEST TEST TEST) SMOKE DETECTOR ACTIVATION",
        "BOX:Fire:28-04 EMS:190-10",
        "UNIT:FG3 E28 AMBCO190 E40 R24 PT43 T40 T29 TK26");

    doTest("T11",
        "South Lebanon Twp 590 S 5TH AVE Cedar HavenMed Class1 SYNCOPE 195MU Fire-Box 26-01 EMS-Box 190-3\n\nTo unsubscribe reply STOP",
        "CITY:SOUTH LEBANON TWP",
        "ADDR:590 S 5TH AVE",
        "PLACE:Cedar HavenMed Class1 SYNCOPE 195MU Fire-Box 26-01",
        "CALL:EMS-Box 190-3");

    doTest("T12",
        "(FASP@16:17) Cornwall Boro 1 BOYD ST Cornwall Manor CLINIC BRADLEY HALL Med Class1 Sick Person 192MU Fire-Box 36-21 EMS-Box 190-6\n\n" +
        "To unsubscribe reply STOP",

        "CITY:CORNWALL",
        "ADDR:1 BOYD ST",
        "PLACE:Cornwall Manor CLINIC BRADLEY HALL",
        "PRI:1",
        "CALL:Sick Person",
        "BOX:Fire:36-21 EMS:190-6",
        "UNIT:192MU");

    doTest("T13",
        "(FASP@16:04) 201 S LANCASTER ST APT 44 Med Class1 medical alarm difficulty breathing A280 199MU Fire-Box EMS-Box\n\n" +
        "To unsubscribe reply STOP",

        "ADDR:201 S LANCASTER ST",
        "APT:44",
        "PRI:1",
        "CALL:medical alarm difficulty breathing",
        "UNIT:A280 199MU");

    doTest("T14",
        "(FASP@15:30) Jackson Twp 100 EVERGREEN DR ELCO INTERMEDIATE SCHOOL Med Class1 CARDIAC ARREST BC190 Fire-Box 31-04 EMS-Box 140-1\n\n" +
        "To unsubscribe reply STOP",

        "CITY:JACKSON TWP",
        "ADDR:100 EVERGREEN DR",
        "PLACE:ELCO INTERMEDIATE SCHOOL",
        "PRI:1",
        "CALL:CARDIAC ARREST",
        "BOX:Fire:31-04 EMS:140-1",
        "UNIT:BC190");

    doTest("T15",
        "(FASP@15:26) Jackson Twp 100 EVERGREEN DR Med Class1 CARDIAC ARREST A160 M12-2 AmbCo140 R31 Fire-Box 31-04 EMS-Box 140-1\n\n" +
        "To unsubscribe reply STOP",

        "CITY:JACKSON TWP",
        "ADDR:100 EVERGREEN DR",
        "PRI:1",
        "CALL:CARDIAC ARREST",
        "BOX:Fire:31-04 EMS:140-1",
        "UNIT:A160 M12-2 AMBCO140 R31");

    doTest("T16",
        "(FASP@15:11) South Lebanon Twp 590 S 5TH AVE Cedar HavenMed Class1 SYNCOPE 195MU Fire-Box 26-01 EMS-Box 190-3\n\n" +
        "To unsubscribe reply STOP",

        "CITY:SOUTH LEBANON TWP",
        "ADDR:590 S 5TH AVE",
        "PLACE:Cedar HavenMed Class1 SYNCOPE 195MU Fire-Box 26-01",
        "CALL:EMS-Box 190-3");

    doTest("T17",
        "(FASP@15:00) City of Lebanon 1584 CHESTNUT ST Med Class1 SEIZURES 199MU Fire-Box 15-04 EMS-Box 190-1\n\nTo unsubscribe reply STOP",
        "CITY:LEBANON",
        "ADDR:1584 CHESTNUT ST",
        "PRI:1",
        "CALL:SEIZURES",
        "BOX:Fire:15-04 EMS:190-1",
        "UNIT:199MU");

    doTest("T18",
        "(FASP@14:57) Millcreek Twp 242 MEMORIAL BLVD Med Class1 BACK PAIN/A140 cover for A150 and BA650 AmbCo150 A141 M12-2 Fire-Box 34-01 EMS-Box 150-1\n\n" +
        "To unsubscribe reply STOP",

        "CITY:MILLCREEK TWP",
        "ADDR:242 MEMORIAL BLVD",
        "PRI:1",
        "CALL:BACK PAIN/A140 cover for A150 and",
        "BOX:Fire:34-01 EMS:150-1",
        "UNIT:BA650 AMBCO150 A141 M12-2");

    doTest("T19",
        "(FASP@14:35) LANCASTER COUNTY ELIZABETH TWP 257 LANCASTER AVE Med Class1 ASSIST 2-5 FALL VICTIM 192MU Fire-Box EMS-Box\n\n" +
        "To unsubscribe reply STOP",

        "CITY:ELIZABETH TWP, LANCASTER COUNTY",
        "ADDR:257 LANCASTER AVE",
        "PRI:1",
        "CALL:ASSIST 2-5 FALL VICTIM",
        "UNIT:192MU");

    doTest("T20",
        "(FASP@13:24) North Lebanon Twp 1794 ASHTON DR Med Class3 FALL VICTIM 199MU Fire-Box 9-01 EMS]agx 190-9\n\nTo unsubscribe reply STOP",
        "CITY:NORTH LEBANON TWP",
        "ADDR:1794 ASHTON DR",
        "PRI:3",
        "CALL:FALL VICTIM 199MU Fire-Box 9-01 EMS]agx 190-9");

  }
  
  @Test
  public void testMtZionFireCo() {

    doTest("T1",
        "(Sta 43@17:38) North Lebanon Twp KOCHENDERFER RD SANDHILL RD OS - Investigation Outside FG 4 E42 E43 E9 R42 R24 AmbCo190 Fire-Box 42-01 EMS-Box 190-9\n\n" +
        "To unsubscribe reply STOP",

        "CITY:NORTH LEBANON TWP",
        "ADDR:KOCHENDERFER RD & SANDHILL RD",
        "CALL:OS - Investigation Outside",
        "BOX:Fire:42-01 EMS:190-9",
        "UNIT:FG 4 E42 E43 E9 R42 R24 AMBCO190");

    doTest("T2",
        "(Sta 41@20:58) Bethel Twp 2957 STATE ROUTE 22 ESTHERS RESTAURANT AFA - Auto Fire Alarm FG 4 Box in Service AUTH Dep 41 E41 E41-1 T41 Fire-Box 41-98 EMS-Box 190-21\n\n" +
        "To unsubscribe reply STOP",

        "CITY:BETHEL TWP",
        "ADDR:2957 STATE ROUTE 22",
        "MADDR:2957 STATE 22",
        "PLACE:ESTHERS RESTAURANT",
        "CALL:AFA - Auto Fire Alarm FG 4 Box in Service AUTH Dep 41",
        "BOX:Fire:41-98 EMS:190-21",
        "UNIT:E41 E41-1 T41");

    doTest("T3",
        "(Sta 41@20:52) Bethel Twp 2957 STATE ROUTE 22 ESTHERS RESTAURANT AFA - Auto Fire Alarm FG 4 E41 E41-1 T41 AmbCo190 Fire-Box 41-98 EMS-Box 190-21\n\n" +
        "To unsubscribe reply STOP",

        "CITY:BETHEL TWP",
        "ADDR:2957 STATE ROUTE 22",
        "MADDR:2957 STATE 22",
        "PLACE:ESTHERS RESTAURANT",
        "CALL:AFA - Auto Fire Alarm",
        "BOX:Fire:41-98 EMS:190-21",
        "UNIT:FG 4 E41 E41-1 T41 AMBCO190");

    doTest("T4",
        "(Sta 41@13:50) Bethel Twp 158 N CENTER ST Med Class1 NEAR SYNCOPE E41 Fire-Box 41-01 EMS-Box 190-21\n\nTo unsubscribe reply STOP",
        "CITY:BETHEL TWP",
        "ADDR:158 N CENTER ST",
        "PRI:1",
        "CALL:NEAR SYNCOPE",
        "BOX:Fire:41-01 EMS:190-21",
        "UNIT:E41");

    doTest("T5",
        "(Sta 41@13:43) Bethel Twp 158 N CENTER ST Med Class1 NEAR SYNCOPE 199MU E41-1 Fire-Box 41-01 EMS-Box 190-21\n\n" +
        "To unsubscribe reply STOP",

        "CITY:BETHEL TWP",
        "ADDR:158 N CENTER ST",
        "PRI:1",
        "CALL:NEAR SYNCOPE",
        "BOX:Fire:41-01 EMS:190-21",
        "UNIT:199MU E41-1");

    doTest("T6",
        "(Sta 28@10:47) North Lebanon Twp 1643 N 7TH ST MV - Accident w/Injuries FG 3 **CANCEL THE CALL** E28 Fire-Box 43-01 EMS-Box 190-10\n\n" +
        "To unsubscribe reply STOP",

        "CITY:NORTH LEBANON TWP",
        "ADDR:1643 N 7TH ST",
        "CALL:MV - Accident w/Injuries FG 3 **CANCEL THE CALL**",
        "BOX:Fire:43-01 EMS:190-10",
        "UNIT:E28");

    doTest("T7",
        "(Sta 43@10:45) North Lebanon Twp 1643 N 7TH ST MV - Accident w/Injuries FG 3 SQ43 Fire-Box 43-01 EMS-Box 190-10\n\n" +
        "To unsubscribe reply STOP",

        "CITY:NORTH LEBANON TWP",
        "ADDR:1643 N 7TH ST",
        "CALL:MV - Accident w/Injuries",
        "BOX:Fire:43-01 EMS:190-10",
        "UNIT:FG 3 SQ43");

    doTest("T8",
        "(Sta 43@10:41) North Lebanon Twp 1643 N 7TH ST MV - Accident w/Injuries FG 3 E43 E28 AmbCo190 Fire-Box 43-01 EMS-Box 190-10\n\n" +
        "To unsubscribe reply STOP",

        "CITY:NORTH LEBANON TWP",
        "ADDR:1643 N 7TH ST",
        "CALL:MV - Accident w/Injuries",
        "BOX:Fire:43-01 EMS:190-10",
        "UNIT:FG 3 E43 E28 AMBCO190");

    doTest("T9",
        "(Sta 43@16:17) North Lebanon Twp 309 SUNSET LN AFA - Auto Fire Alarm ******BOX IN SERVICE****** PT43 Fire-Box 43-04 EMS-Box 190-9\n\n" +
        "To unsubscribe reply STOP",

        "CITY:NORTH LEBANON TWP",
        "ADDR:309 SUNSET LN",
        "CALL:AFA - Auto Fire Alarm ******BOX IN SERVICE******",
        "BOX:Fire:43-04 EMS:190-9",
        "UNIT:PT43");

    doTest("T10",
        "(Sta 43@16:16) North Lebanon Twp 309 SUNSET LN AFA - Auto Fire Alarm ******BOX IN SERVICE****** E43 Fire-Box 43-04 EMS-Box 190-9\n\n" +
        "To unsubscribe reply STOP",

        "CITY:NORTH LEBANON TWP",
        "ADDR:309 SUNSET LN",
        "CALL:AFA - Auto Fire Alarm ******BOX IN SERVICE******",
        "BOX:Fire:43-04 EMS:190-9",
        "UNIT:E43");

    doTest("T11",
        "(Sta 43@16:13) North Lebanon Twp 309 SUNSET LN AFA - Auto Fire Alarm FG 03 E43 E9 R42 AmbCo190 E42 PT43 Fire-Box 43-04 EMS-Box 190-9\n\n" +
        "To unsubscribe reply STOP",

        "CITY:NORTH LEBANON TWP",
        "ADDR:309 SUNSET LN",
        "CALL:AFA - Auto Fire Alarm FG 03",
        "BOX:Fire:43-04 EMS:190-9",
        "UNIT:E43 E9 R42 AMBCO190 E42 PT43");

    doTest("T12",
        "(Sta 1@12:12) Palmyra Boro 315 N CHESTNUT ST SF - Dwelling Fire Reported Building Collapse FG-3 W1 E2 E1-1 DTK48 R2 AmbCo4 TW1 Fire-Box 1-02 EMS-Box 4-1\n\n" +
        "To unsubscribe reply STOP",

        "CITY:PALMYRA",
        "ADDR:315 N CHESTNUT ST",
        "CALL:SF - Dwelling Fire Reported Building Collapse",
        "BOX:Fire:1-02 EMS:4-1",
        "UNIT:FG-3 W1 E2 E1-1 DTK48 R2 AMBCO4 TW1");

    doTest("T13",
        "(Sta 1@04:10) North Londonderry Twp 618 CAMBRIDGE CT SF - Dwelling Fire AUDIBLE ALARM ACTIVATION E1-1 AmbCo4 E2 W1 DTK48 R2 TW1 UT1 Fire-Box 1-08 EMS-Box 4-2\n\n" +
        "To unsubscribe reply STOP",

        "CITY:NORTH LONDONDERRY TWP",
        "ADDR:618 CAMBRIDGE CT",
        "CALL:SF - Dwelling Fire AUDIBLE ALARM ACTIVATION",
        "BOX:Fire:1-08 EMS:4-2",
        "UNIT:E1-1 AMBCO4 E2 W1 DTK48 R2 TW1 UT1");
 
  }
  
  public static void main(String[] args) {
    new PALebanonCountyParserTest().generateTests("T1");
  }
}
