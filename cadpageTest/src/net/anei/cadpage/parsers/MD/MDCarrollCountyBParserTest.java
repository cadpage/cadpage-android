package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Carroll County, MD
Contact: Active911
Agency name: Reese VFC
Location: Westminster, MD, United States
Sender: "FASTalert System" <fast@md-carroll-09.fastalerting.com>

(Station 09 ALERT!! (13000193)) \nBLS MEDICAL CALL\n0911\nX99\n1727 REESE RD, Westminster, MD\n
(Station 09 ALERT!! (13000179)) \nUNCONSCIOUS SUBJECT\n0321\nX99  FR3\nELKS CLUB @538 GORSUCH RD, Westminster, MD\n
(Station 09 ALERT!! (13000159)) \nALS MEDICAL CALL\n0901\nX99\n9 SHAMROCK CIR, Westminster, MD\n
(Station 09 ALERT!! (13000156)) \nBLS MEDICAL CALL\n0366\nX99  FR3\n30 LOCUST ST @LOCUST HOUSE APTS                      APT 510, Westminster, MD\n
(Station 09 ALERT!! (13000144)) \nBLS MEDICAL CALL\n0917\nX99\n2202 RIDGEMONT DR, Finksburg, MD\n
(Station 09 ALERT!! (13000136)) \nBLS MEDICAL CALL\n0917\nX99\n2437 CLYDESDALE RD, Finksburg, MD\n
(Station 09 ALERT!! (13000135)) \nRESCUE ALARM\n0331\nX38  E31  RS9\n12 KEMPER AV, Westminster, MD\n
(Station 09 ALERT!! (13000075)) \nMUTUAL AID ALARM\nBC\nX99\n41-9 714 WESTMINSTER PIKE; VEH COLL TG WEST 4\n
(Station 09 ALERT!! (13000045)) \nALS MEDICAL CALL\n0217\nX49  FR2  X99\n1000 BOXWOOD DR, Hampstead, MD\n
(Station 09 ALERT!! (13000034)) \nALS MEDICAL CALL\n0312\nX99  FR3\n564 MARSHALL DR @HIDDEN TREASURES, Westminster, MD\n
(Station 09 ALERT!! (13000028)) \nALS MEDICAL CALL\n0914\nX99\n2432 SANDYMOUNT RD, Finksburg, MD\n
(Station 09 ALERT!! (13000022)) \nCHIMNEY FIRE\n0335\nE31  E91  TO3  X38\n154 BOND ST, Westminster, MD\n
(Station 09 ALERT!! (12018844)) \nMUTUAL AID ALARM\nBC\nX99\n56-6 35 FOX RUN CT // FALL // WEST\n
(Station 09 ALERT!! (12018840)) \nENGINE TRANSFER\n1005\nTR11  E31  E63  E91\nCO 10 @101 HIGH ST, New Windsor, MD\n
(Station 09 ALERT!! (12018838)) \nMUTUAL AID ALARM\nBC\nX99\nBC 56-3 114 BROOKBERRY DR 2D ABDOMINAL PAIN TG WEST\n
(Station 09 ALERT!! (12018833)) \nPATIENT ASSIST\n0914\nX99\n2344 SANDYMOUNT RD, Finksburg, MD\n
(Station 09 ALERT!! (12018814)) \nALS MEDICAL CALL\n0912\nX99\n1011 BALTIMORE BLVD ; EXPRESSCARE, Westminster, MD\n
(Station 09 ALERT!! (12018804)) \nALS MEDICAL CALL\n0917\nX99\n1950 RUSTIC VIEW DR, Finksburg, MD\n
(Station 09 ALERT!! (12018803)) \nCARDIAC ARREST\n0335\nX99  FR3  E31\n202 MANDY DR                                         APT B, Westminster, MD\n
(Station 09 ALERT!! (12018798)) \nALS MEDICAL CALL\n0908\nX99\n2470 COLLISON DR @COUNTRY ACRES, Westminster, MD\n
(Station 09 ALERT!! (12018796)) \nALS MEDICAL CALL\n0201\nX99  FR2\n3158 COON CLUB RD, Hampstead, MD\n
(Station 09 ALERT!! (12018783)) \nVEHICLE COLLISION\n0314\nX39  E31  RS9\nRT 140 / RT 97-MALCOLM DR, Westminster, MD\n
(Station 09 ALERT!! (12018781)) \nMUTUAL AID ALARM\nBC\nE23  E91\n42-8 5847 MT GILEAD RD // DWELLING FIRE // TAC 22\n
(Station 09 ALERT!! (12018763)) \nALS MEDICAL CALL\n0912\nX99\n1011 BALTIMORE BLVD, Westminster, MD\n
(Station 09 ALERT!! (12018758)) \nVEHICLE COLLISION\n0906\nX99  E91\nRT 140 / RT 91, Finksburg, MD\n
(Station 09 ALERT!! (12018757)) \nALS MEDICAL CALL\n0334\nX99  FR3\nGRANITE HOUSE @288 E GREEN ST, Westminster, MD\n

Contact: Nate Martin <delta7755@gmail.com>
Sender: fast@md-frederick-01.fastalerting.com
Subject:Station 01 ALERT!! (F13020973)\n\nSEIZURE\nA18\n105\n1202 DANIELLE DR, FREDERICK, MD\nSEIZURE
Subject:Station 01 ALERT!! (F13020984)\n\nVEHICLE ACCIDENT\nA18   A38   E12   E22   E31   RE11\n11501\n@RT15NB / W PATRICK
Subject:Station 01 ALERT!! (F13020994)\n\nDECREASED LEVEL OF CONSCIOUSNESS\nA19   M2\n102\n@CITIZENS CARE &amp @  REHAB 19
Subject:Station 01 ALERT!! (F13021001)\n\nTROUBLE BREATHING\nA18   M1\n122\n7836-B EDGEWOOD CHURCH RD, FREDERICK, MD\nCALL
Subject:Station 01 ALERT!! (F13020831)\n\nABDOMINAL PAIN (ALS)\nA18   M1\n110\n2123 CARROLL CREEK VIEW CT, FREDERICK, MD
Subject:Station 01 ALERT!! (F13021014)\n\nCHEST PAIN\nA18   M1\n103\nAPT 1 DOWNSTAIRS 903 WALNUT ST, FREDERICK, MD\nHUSBAN
Subject:Station 01 ALERT!! (F13021015)\n\nINJURED PERSON\nA19\n102\n@SUNRISE RETIREMENT ROOM 111 990 WATERFORD DR, FREDERI

*/
public class MDCarrollCountyBParserTest extends BaseParserTest {
  
  public MDCarrollCountyBParserTest() {
    setParser(new MDCarrollCountyBParser(), "CARROLL COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Station 09 ALERT!! (13000193)) \nBLS MEDICAL CALL\n0911\nX99\n1727 REESE RD, Westminster, MD\n",
        "SRC:09",
        "ID:13000193",
        "CALL:BLS MEDICAL CALL",
        "BOX:0911",
        "UNIT:X99",
        "ADDR:1727 REESE RD",
        "CITY:Westminster");

    doTest("T2",
        "(Station 09 ALERT!! (13000179)) \nUNCONSCIOUS SUBJECT\n0321\nX99  FR3\nELKS CLUB @538 GORSUCH RD, Westminster, MD\n",
        "SRC:09",
        "ID:13000179",
        "CALL:UNCONSCIOUS SUBJECT",
        "BOX:0321",
        "UNIT:X99 FR3",
        "PLACE:ELKS CLUB",
        "ADDR:538 GORSUCH RD",
        "CITY:Westminster");

    doTest("T3",
        "(Station 09 ALERT!! (13000159)) \nALS MEDICAL CALL\n0901\nX99\n9 SHAMROCK CIR, Westminster, MD\n",
        "SRC:09",
        "ID:13000159",
        "CALL:ALS MEDICAL CALL",
        "BOX:0901",
        "UNIT:X99",
        "ADDR:9 SHAMROCK CIR",
        "CITY:Westminster");

    doTest("T4",
        "(Station 09 ALERT!! (13000156)) \n" +
        "BLS MEDICAL CALL\n" +
        "0366\n" +
        "X99  FR3\n" +
        "30 LOCUST ST @LOCUST HOUSE APTS                      APT 510, Westminster, MD\n",

        "SRC:09",
        "ID:13000156",
        "CALL:BLS MEDICAL CALL",
        "BOX:0366",
        "UNIT:X99 FR3",
        "PLACE:LOCUST HOUSE APTS",
        "ADDR:30 LOCUST ST",
        "APT:510",
        "CITY:Westminster");

    doTest("T5",
        "(Station 09 ALERT!! (13000144)) \nBLS MEDICAL CALL\n0917\nX99\n2202 RIDGEMONT DR, Finksburg, MD\n",
        "SRC:09",
        "ID:13000144",
        "CALL:BLS MEDICAL CALL",
        "BOX:0917",
        "UNIT:X99",
        "ADDR:2202 RIDGEMONT DR",
        "CITY:Finksburg");

    doTest("T6",
        "(Station 09 ALERT!! (13000136)) \nBLS MEDICAL CALL\n0917\nX99\n2437 CLYDESDALE RD, Finksburg, MD\n",
        "SRC:09",
        "ID:13000136",
        "CALL:BLS MEDICAL CALL",
        "BOX:0917",
        "UNIT:X99",
        "ADDR:2437 CLYDESDALE RD",
        "CITY:Finksburg");

    doTest("T7",
        "(Station 09 ALERT!! (13000135)) \nRESCUE ALARM\n0331\nX38  E31  RS9\n12 KEMPER AV, Westminster, MD\n",
        "SRC:09",
        "ID:13000135",
        "CALL:RESCUE ALARM",
        "BOX:0331",
        "UNIT:X38 E31 RS9",
        "ADDR:12 KEMPER AV",
        "MADDR:12 KEMPER AVE",
        "CITY:Westminster");

    doTest("T8",
        "(Station 09 ALERT!! (13000075)) \nMUTUAL AID ALARM\nBC\nX99\n41-9 714 WESTMINSTER PIKE; VEH COLL TG WEST 4\n",
        "SRC:09",
        "ID:13000075",
        "CALL:MUTUAL AID ALARM - VEH COLL",
        "CITY:BALTIMORE COUNTY",   // BC used to mean Baltimore county.  Doe sit still??
        "UNIT:X99",
        "BOX:41-9",
        "ADDR:714 WESTMINSTER PIKE",
        "CH:WEST 4");

    doTest("T9",
        "(Station 09 ALERT!! (13000045)) \nALS MEDICAL CALL\n0217\nX49  FR2  X99\n1000 BOXWOOD DR, Hampstead, MD\n",
        "SRC:09",
        "ID:13000045",
        "CALL:ALS MEDICAL CALL",
        "BOX:0217",
        "UNIT:X49 FR2 X99",
        "ADDR:1000 BOXWOOD DR",
        "CITY:Hampstead");

    doTest("T10",
        "(Station 09 ALERT!! (13000034)) \nALS MEDICAL CALL\n0312\nX99  FR3\n564 MARSHALL DR @HIDDEN TREASURES, Westminster, MD\n",
        "SRC:09",
        "ID:13000034",
        "CALL:ALS MEDICAL CALL",
        "BOX:0312",
        "UNIT:X99 FR3",
        "PLACE:HIDDEN TREASURES",
        "ADDR:564 MARSHALL DR",
        "CITY:Westminster");

    doTest("T11",
        "(Station 09 ALERT!! (13000028)) \nALS MEDICAL CALL\n0914\nX99\n2432 SANDYMOUNT RD, Finksburg, MD\n",
        "SRC:09",
        "ID:13000028",
        "CALL:ALS MEDICAL CALL",
        "BOX:0914",
        "UNIT:X99",
        "ADDR:2432 SANDYMOUNT RD",
        "CITY:Finksburg");

    doTest("T12",
        "(Station 09 ALERT!! (13000022)) \nCHIMNEY FIRE\n0335\nE31  E91  TO3  X38\n154 BOND ST, Westminster, MD\n",
        "SRC:09",
        "ID:13000022",
        "CALL:CHIMNEY FIRE",
        "BOX:0335",
        "UNIT:E31 E91 TO3 X38",
        "ADDR:154 BOND ST",
        "CITY:Westminster");

    doTest("T13",
        "(Station 09 ALERT!! (12018844)) \nMUTUAL AID ALARM\nBC\nX99\n56-6 35 FOX RUN CT // FALL // WEST\n",
        "SRC:09",
        "ID:12018844",
        "CALL:MUTUAL AID ALARM - FALL",
        "CITY:BALTIMORE COUNTY",
        "BOX:56-6",
        "UNIT:X99",
        "ADDR:35 FOX RUN CT",
        "CH:WEST");

    doTest("T14",
        "(Station 09 ALERT!! (12018840)) \nENGINE TRANSFER\n1005\nTR11  E31  E63  E91\nCO 10 @101 HIGH ST, New Windsor, MD\n",
        "SRC:09",
        "ID:12018840",
        "CALL:ENGINE TRANSFER",
        "BOX:1005",
        "UNIT:TR11 E31 E63 E91",
        "PLACE:CO 10",
        "ADDR:101 HIGH ST",
        "CITY:New Windsor");

    doTest("T15",
        "(Station 09 ALERT!! (12018838)) \nMUTUAL AID ALARM\nBC\nX99\nBC 56-3 114 BROOKBERRY DR 2D ABDOMINAL PAIN TG WEST\n",
        "SRC:09",
        "ID:12018838",
        "CALL:MUTUAL AID ALARM - ABDOMINAL PAIN",
        "CITY:BALTIMORE COUNTY",
        "UNIT:X99",
        "BOX:56-3",
        "ADDR:114 BROOKBERRY DR", // Not mapping
        "APT:2D",
        "CH:WEST");

    doTest("T16",
        "(Station 09 ALERT!! (12018833)) \nPATIENT ASSIST\n0914\nX99\n2344 SANDYMOUNT RD, Finksburg, MD\n",
        "SRC:09",
        "ID:12018833",
        "CALL:PATIENT ASSIST",
        "BOX:0914",
        "UNIT:X99",
        "ADDR:2344 SANDYMOUNT RD",
        "CITY:Finksburg");

    doTest("T17",
        "(Station 09 ALERT!! (12018814)) \nALS MEDICAL CALL\n0912\nX99\n1011 BALTIMORE BLVD ; EXPRESSCARE, Westminster, MD\n",
        "SRC:09",
        "ID:12018814",
        "CALL:ALS MEDICAL CALL",
        "BOX:0912",
        "UNIT:X99",
        "PLACE:EXPRESSCARE",
        "ADDR:1011 BALTIMORE BLVD",
        "CITY:Westminster");

    doTest("T18",
        "(Station 09 ALERT!! (12018804)) \nALS MEDICAL CALL\n0917\nX99\n1950 RUSTIC VIEW DR, Finksburg, MD\n",
        "SRC:09",
        "ID:12018804",
        "CALL:ALS MEDICAL CALL",
        "BOX:0917",
        "UNIT:X99",
        "ADDR:1950 RUSTIC VIEW DR",
        "CITY:Finksburg");

    doTest("T19",
        "(Station 09 ALERT!! (12018803)) \n" +
        "CARDIAC ARREST\n" +
        "0335\n" +
        "X99  FR3  E31\n" +
        "202 MANDY DR                                         APT B, Westminster, MD\n",

        "SRC:09",
        "ID:12018803",
        "CALL:CARDIAC ARREST",
        "BOX:0335",
        "UNIT:X99 FR3 E31",
        "ADDR:202 MANDY DR",
        "APT:B",
        "CITY:Westminster");

    doTest("T20",
        "(Station 09 ALERT!! (12018798)) \nALS MEDICAL CALL\n0908\nX99\n2470 COLLISON DR @COUNTRY ACRES, Westminster, MD\n",
        "SRC:09",
        "ID:12018798",
        "CALL:ALS MEDICAL CALL",
        "BOX:0908",
        "UNIT:X99",
        "PLACE:COUNTRY ACRES",
        "ADDR:2470 COLLISON DR",
        "CITY:Westminster");

    doTest("T21",
        "(Station 09 ALERT!! (12018796)) \nALS MEDICAL CALL\n0201\nX99  FR2\n3158 COON CLUB RD, Hampstead, MD\n",
        "SRC:09",
        "ID:12018796",
        "CALL:ALS MEDICAL CALL",
        "BOX:0201",
        "UNIT:X99 FR2",
        "ADDR:3158 COON CLUB RD",
        "CITY:Hampstead");

    doTest("T22",
        "(Station 09 ALERT!! (12018783)) \nVEHICLE COLLISION\n0314\nX39  E31  RS9\nRT 140 / RT 97-MALCOLM DR, Westminster, MD\n",
        "SRC:09",
        "ID:12018783",
        "CALL:VEHICLE COLLISION",
        "BOX:0314",
        "UNIT:X39 E31 RS9",
        "ADDR:RT 140 & RT 97-MALCOLM DR",
        "CITY:Westminster");

    doTest("T23",
        "(Station 09 ALERT!! (12018781)) \nMUTUAL AID ALARM\nBC\nE23  E91\n42-8 5847 MT GILEAD RD // DWELLING FIRE // TAC 22\n",
        "SRC:09",
        "ID:12018781",
        "CALL:MUTUAL AID ALARM - DWELLING FIRE",
        "CITY:BALTIMORE COUNTY",
        "BOX:42-8",
        "UNIT:E23 E91",
        "ADDR:5847 MT GILEAD RD",
        "CH:TAC 22");

    doTest("T24",
        "(Station 09 ALERT!! (12018763)) \nALS MEDICAL CALL\n0912\nX99\n1011 BALTIMORE BLVD, Westminster, MD\n",
        "SRC:09",
        "ID:12018763",
        "CALL:ALS MEDICAL CALL",
        "BOX:0912",
        "UNIT:X99",
        "ADDR:1011 BALTIMORE BLVD",
        "CITY:Westminster");

    doTest("T25",
        "(Station 09 ALERT!! (12018758)) \nVEHICLE COLLISION\n0906\nX99  E91\nRT 140 / RT 91, Finksburg, MD\n",
        "SRC:09",
        "ID:12018758",
        "CALL:VEHICLE COLLISION",
        "BOX:0906",
        "UNIT:X99 E91",
        "ADDR:RT 140 & RT 91",
        "CITY:Finksburg");

    doTest("T26",
        "(Station 09 ALERT!! (12018757)) \nALS MEDICAL CALL\n0334\nX99  FR3\nGRANITE HOUSE @288 E GREEN ST, Westminster, MD\n",
        "SRC:09",
        "ID:12018757",
        "CALL:ALS MEDICAL CALL",
        "BOX:0334",
        "UNIT:X99 FR3",
        "PLACE:GRANITE HOUSE",
        "ADDR:288 E GREEN ST",
        "CITY:Westminster");
   
  }
  
  @Test
  public void testNateMartin() {

    doTest("T1",
        "Subject:Station 01 ALERT!! (F13020973)\n\nSEIZURE\nA18\n105\n1202 DANIELLE DR, FREDERICK, MD\nSEIZURE",
        "SRC:01",
        "ID:F13020973",
        "CALL:SEIZURE",
        "UNIT:A18",
        "BOX:105",
        "ADDR:1202 DANIELLE DR",
        "CITY:FREDERICK",
        "INFO:SEIZURE");

    doTest("T2",
        "Subject:Station 01 ALERT!! (F13020984)\n\nVEHICLE ACCIDENT\nA18   A38   E12   E22   E31   RE11\n11501\n@RT15NB / W PATRICK",
        "SRC:01",
        "ID:F13020984",
        "CALL:VEHICLE ACCIDENT",
        "UNIT:A18 A38 E12 E22 E31 RE11",
        "BOX:11501",
        "ADDR:RT15NB & W PATRICK",
        "MADDR:RT 15 & W PATRICK");

    doTest("T3",
        "Subject:Station 01 ALERT!! (F13020994)\n\nDECREASED LEVEL OF CONSCIOUSNESS\nA19   M2\n102\n@CITIZENS CARE &amp @  REHAB 19",
        "SRC:01",
        "ID:F13020994",
        "CALL:DECREASED LEVEL OF CONSCIOUSNESS",
        "UNIT:A19 M2",
        "BOX:102",
        "ADDR:CITIZENS CARE & amp",
        "PLACE:REHAB 19");

    doTest("T4",
        "Subject:Station 01 ALERT!! (F13021001)\n\nTROUBLE BREATHING\nA18   M1\n122\n7836-B EDGEWOOD CHURCH RD, FREDERICK, MD\nCALL",
        "SRC:01",
        "ID:F13021001",
        "CALL:TROUBLE BREATHING",
        "UNIT:A18 M1",
        "BOX:122",
        "ADDR:7836-B EDGEWOOD CHURCH RD",
        "MADDR:7836 EDGEWOOD CHURCH RD",
        "CITY:FREDERICK",
        "INFO:CALL");

    doTest("T5",
        "Subject:Station 01 ALERT!! (F13020831)\n\nABDOMINAL PAIN (ALS)\nA18   M1\n110\n2123 CARROLL CREEK VIEW CT, FREDERICK, MD",
        "SRC:01",
        "ID:F13020831",
        "CALL:ABDOMINAL PAIN (ALS)",
        "UNIT:A18 M1",
        "BOX:110",
        "ADDR:2123 CARROLL CREEK VIEW CT",
        "CITY:FREDERICK");

    doTest("T6",
        "Subject:Station 01 ALERT!! (F13021014)\n\nCHEST PAIN\nA18   M1\n103\nAPT 1 DOWNSTAIRS 903 WALNUT ST, FREDERICK, MD\nHUSBAN",
        "SRC:01",
        "ID:F13021014",
        "CALL:CHEST PAIN",
        "UNIT:A18 M1",
        "BOX:103",
        "APT:1 DOWNSTAIRS",
        "ADDR:903 WALNUT ST",
        "CITY:FREDERICK",
        "INFO:HUSBAN");

    doTest("T7",
        "Subject:Station 01 ALERT!! (F13021015)\n\nINJURED PERSON\nA19\n102\n@SUNRISE RETIREMENT ROOM 111 990 WATERFORD DR, FREDERI",
        "SRC:01",
        "ID:F13021015",
        "CALL:INJURED PERSON",
        "UNIT:A19",
        "BOX:102",
        "PLACE:SUNRISE RETIREMENT",
        "APT:111",
        "ADDR:990 WATERFORD DR",
        "CITY:FREDERI");

  }
  
  public static void main(String[] args) {
    new MDCarrollCountyBParserTest().generateTests("T1");
  }
}