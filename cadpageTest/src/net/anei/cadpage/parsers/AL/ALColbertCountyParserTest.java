package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class ALColbertCountyParserTest extends BaseParserTest {
  
  public ALColbertCountyParserTest() {
    setParser(new ALColbertCountyParser(), "COLBERT COUNTY", "AL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MISSING PERSON\n 2564150099\n3804 HATCH BLVD, SHEFFIELD",
        "CALL:MISSING PERSON",
        "PHONE:2564150099",
        "ADDR:3804 HATCH BLVD",
        "CITY:SHEFFIELD");

    doTest("T2",
        "SUICIDAL PERSON\n 6622123327\n105 FORREST DR, CHEROKEE\n43 YOF",
        "CALL:SUICIDAL PERSON",
        "PHONE:6622123327",
        "ADDR:105 FORREST DR",
        "CITY:CHEROKEE",
        "INFO:43 YOF");

    doTest("T3",
        "BREATHING PROBLEM\nCHEROKEE FAMILY CLINIC 2563594516\n1080 2ND ST, CHEROKEE\n62 YOF",
        "CALL:BREATHING PROBLEM",
        "PLACE:CHEROKEE FAMILY CLINIC",
        "PHONE:2563594516",
        "ADDR:1080 2ND ST",
        "CITY:CHEROKEE",
        "INFO:62 YOF");

    doTest("T4",
        "SEIZURE\n 2568566665\n8685 HIGHWAY 72, CHEROKEE\n21F",
        "CALL:SEIZURE",
        "PHONE:2568566665",
        "ADDR:8685 HIGHWAY 72",
        "CITY:CHEROKEE",
        "INFO:21F");

    doTest("T5",
        "MISSING PERSON\nATKISSON, TAMARA 2564123685\n603 PASADENA AV, A, MUSCLE SHOALS",
        "CALL:MISSING PERSON",
        "NAME:ATKISSON, TAMARA",
        "PHONE:2564123685",
        "ADDR:603 PASADENA AV",
        "MADDR:603 PASADENA AVE",
        "APT:A",
        "CITY:MUSCLE SHOALS");

    doTest("T6",
        "MVC-Injury\n 2564125319\nWOODWARD AV && 6TH ST, MUSCLE SHOALS\n2 CARS",
        "CALL:MVC-Injury",
        "PHONE:2564125319",
        "ADDR:WOODWARD AV & 6TH ST",
        "MADDR:WOODWARD AVE & 6TH ST",
        "CITY:MUSCLE SHOALS",
        "INFO:2 CARS");
  }
  
  @Test
  public void testActive911Alert() {

    doTest("T1",
        "[E911] MEETING\n \nCHEROKEE FIRE DEPT\n6:30 IMPORTANT MEETING,\n",
        "CALL:MEETING",
        "ADDR:CHEROKEE FIRE DEPT",
        "INFO:6:30 IMPORTANT MEETING,");

    doTest("T2",
        "[E911] WEATHER\n \nWEATHER\nFLASH FLOODING TILL 5:00\n",
        "CALL:WEATHER",
        "ADDR:WEATHER",
        "INFO:FLASH FLOODING TILL 5:00");

    doTest("T3",
        "[E911] TRAINING\n \nSPR AT 6 PM AT STATION 1\n",
        "CALL:TRAINING",
        "PLACE:SPR AT 6 PM",
        "MADDR:SPR AT 6 PM,STATION 1",
        "ADDR:STATION 1");

    doTest("T4",
        "[E911] MVC WITHOUT INJURY\nJJS\n",
        "CALL:MVC WITHOUT INJURY",
        "ADDR:JJS");
    
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "[E911] PATIENT TRANSFER\nHELEN KELLER HOSPITAL 2563811766\n1300 S MONTGOMERY AV, SHEFFIELD\n315 EULA\n",
        "CALL:PATIENT TRANSFER",
        "PHONE:2563811766",
        "PLACE:HELEN KELLER HOSPITAL",
        "ADDR:1300 S MONTGOMERY AV",
        "MADDR:1300 S MONTGOMERY AVE",
        "CITY:SHEFFIELD",
        "INFO:315 EULA");

    doTest("T2",
        "[E911] STROKE\nHOUSTON BOLTON 2563596427\n5280 OLD LEE HWY, CHEROKEE\n83M\n",
        "CALL:STROKE",
        "PHONE:2563596427",
        "NAME:HOUSTON BOLTON",
        "ADDR:5280 OLD LEE HWY",
        "CITY:CHEROKEE",
        "INFO:83M");

    doTest("T3",
        "[E911] PASSED OUT\n 2565772031\n290 FORREST DR, CHEROKEE\n25 YOM\n",
        "CALL:PASSED OUT",
        "PHONE:2565772031",
        "ADDR:290 FORREST DR",
        "CITY:CHEROKEE",
        "INFO:25 YOM");

    doTest("T4",
        "[E911] OVERDOSE\nADAY, SHANE 2563602442\n145 ADAY DR, CHEROKEE\n15 YOM\n",
        "CALL:OVERDOSE",
        "PHONE:2563602442",
        "NAME:ADAY, SHANE",
        "ADDR:145 ADAY DR",
        "CITY:CHEROKEE",
        "INFO:15 YOM");

    doTest("T5",
        "[E911] FIRE - UNKNOWN\nNELIA STAFFORD 2563594739\n445 NORTH PKE, CHEROKEE\nACROSS THE STREET FROM CALLER\n",
        "CALL:FIRE - UNKNOWN",
        "PHONE:2563594739",
        "NAME:NELIA STAFFORD",
        "ADDR:445 NORTH PKE",
        "CITY:CHEROKEE",
        "INFO:ACROSS THE STREET FROM CALLER");

    doTest("T6",
        "[E911] MVC / C INJURIES\n 2564128754\n1080 NORTH PKE, CHEROKEE\n",
        "CALL:MVC / C INJURIES",
        "PHONE:2564128754",
        "ADDR:1080 NORTH PKE",
        "CITY:CHEROKEE");

    doTest("T7",
        "[E911] CHEST PAIN\nMONTEZ DAVIS 2563594174\n190 JOHNSON DR, CHEROKEE\n68F\n",
        "CALL:CHEST PAIN",
        "PHONE:2563594174",
        "NAME:MONTEZ DAVIS",
        "ADDR:190 JOHNSON DR",
        "CITY:CHEROKEE",
        "INFO:68F");

    doTest("T8",
        "[E911] PASSED OUT\n 2565779317\n1350 OLD COVER BRIDGE RD W, CHEROKEE\n40M\n",
        "CALL:PASSED OUT",
        "PHONE:2565779317",
        "ADDR:1350 OLD COVER BRIDGE RD W",
        "CITY:CHEROKEE",
        "INFO:40M");

    doTest("T9",
        "[E911] VOMITING\nNELLAREE W DODSON 2563596248\n800 CROSS ST, CHEROKEE\n83/F\n",
        "CALL:VOMITING",
        "PHONE:2563596248",
        "PLACE:NELLAREE W DODSON",
        "ADDR:800 CROSS ST",
        "CITY:CHEROKEE",
        "INFO:83/F");

    doTest("T10",
        "[E911] FIRE - GRASS/WOODS\n \nMT HESTER RD MILE S OF 72 B4 CEDAR LN\n",
        "CALL:FIRE - GRASS/WOODS",
        "PLACE:MT HESTER RD MILE S OF",
        "ADDR:72 B4 CEDAR LN");

    doTest("T11",
        "[E911] FALL\nN MCGEE 2563594003\n765 CROSS ST, CHEROKEE\n60/M\n",
        "CALL:FALL",
        "PHONE:2563594003",
        "NAME:N MCGEE",
        "ADDR:765 CROSS ST",
        "CITY:CHEROKEE",
        "INFO:60/M");

    doTest("T12",
        "[E911] HEART PROBLEM\n 2564129804\n125 SPRING VALLEY LN, CHEROKEE\n66 YOM\n",
        "CALL:HEART PROBLEM",
        "PHONE:2564129804",
        "ADDR:125 SPRING VALLEY LN",
        "CITY:CHEROKEE",
        "INFO:66 YOM");

    doTest("T13",
        "[E911] BREATHING PROBLEM\n 2567023439\n7455 ALLSBORO RD, CHEROKEE\n54/F\n",
        "CALL:BREATHING PROBLEM",
        "PHONE:2567023439",
        "ADDR:7455 ALLSBORO RD",
        "CITY:CHEROKEE",
        "INFO:54/F");

    doTest("T14",
        "[E911] DRILL\nSHOALS FLIGHT CENTER 2563812869\n1729 T ED CAMPBELL DR, MUSCLE SHOALS\nA4\n",
        "CALL:DRILL",
        "PHONE:2563812869",
        "PLACE:SHOALS FLIGHT CENTER",
        "ADDR:1729 T ED CAMPBELL DR",
        "CITY:MUSCLE SHOALS",
        "INFO:A4");

    doTest("T15",
        "[E911] DISTURBANCE\nALTHEA LONG 2563814676\n911 SE 18TH ST, SHEFFIELD\n",
        "CALL:DISTURBANCE",
        "PHONE:2563814676",
        "NAME:ALTHEA LONG",
        "ADDR:911 SE 18TH ST",
        "CITY:SHEFFIELD");

    doTest("T16",
        "[E911] LOST PERSON\n FREEDOM HILLS RD\n",
        "CALL:LOST PERSON",
        "ADDR:FREEDOM HILLS RD");

    doTest("T17",
        "[E911] NOSE BLEED\nGAIL STEVENSON 890 DOBBS ST, CHEROKEE\n60 YOF\n",
        "CALL:NOSE BLEED",
        "NAME:GAIL STEVENSON",
        "ADDR:890 DOBBS ST",
        "CITY:CHEROKEE",
        "INFO:60 YOF");

    doTest("T18",
        "[E911] MVC /C UNKNOWN INJ\n HIGHWAY 72 @ MM 5, CHEROKEE\n",
        "CALL:MVC /C UNKNOWN INJ",
        "ADDR:HIGHWAY 72 @ MM 5",
        "CITY:CHEROKEE");

    doTest("T19",
        "[E911] MISSING PERSON\n NATCHEZ TRACE PKWY @ MP 319\n",
        "CALL:MISSING PERSON",
        "ADDR:NATCHEZ TRACE PKWY @ MP 319");

    doTest("T20",
        "[E911] HEMORRHAGE/LACERATION\nADAY, SHANE 145 ADAY DR\n49M\n",
        "CALL:HEMORRHAGE/LACERATION",
        "NAME:ADAY, SHANE",
        "ADDR:145 ADAY DR",
        "INFO:49M");

    doTest("T21",
        "[E911] BREATHING PROBLEM\nPARADISE FOODMART AND PACKAGE NO 7060 HIGHWAY 72, CHEROKEE\n55 YOM\n",
        "CALL:BREATHING PROBLEM",
        "PLACE:PARADISE FOODMART AND PACKAGE NO",
        "ADDR:7060 HIGHWAY 72",
        "CITY:CHEROKEE",
        "INFO:55 YOM");

    doTest("T22",
        "[E911] AMPUTATION\nADAY, SHANE 145 ADAY DR, CHEROKEE\n",
        "CALL:AMPUTATION",
        "NAME:ADAY, SHANE",
        "ADDR:145 ADAY DR",
        "CITY:CHEROKEE");

    doTest("T23",
        "[E911] HEMORRHAGE/LACERATION\nMRS MILDRED PUGH 2480 WHITE PKE, CHEROKEE\n67M\n",
        "CALL:HEMORRHAGE/LACERATION",
        "NAME:MRS MILDRED PUGH",
        "ADDR:2480 WHITE PKE",
        "CITY:CHEROKEE",
        "INFO:67M");

    doTest("T24",
        "[E911] AMPUTATION\nADAY, SHANE 145 ADAY DR, CHEROKEE",
        "CALL:AMPUTATION",
        "NAME:ADAY, SHANE",
        "ADDR:145 ADAY DR",
        "CITY:CHEROKEE");

  }
  
  public static void main(String[] args) {
    new ALColbertCountyParserTest().generateTests("T1");
  }
}
