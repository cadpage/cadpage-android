package net.anei.cadpage.parsers.MS;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Calhoun County, MS
Contact: Active911
Agency name: Calhoun County 912
Location: Pittsboro, MS, United States
Sender: cadalerts@eforcesoftware.com

(Dispatch Alert) CC/DERMA EMR\n129 MYERS AVE\nCALHOUN CITY\nNote: mS lOUISE ADV 68 YOM DIFFCULTY BREATHING
(Dispatch Alert) AMBULANCE\nCALHOUN COUNTY NURSING HOME\n152 BURKE-CC RD\nApt 139B\nCALHOUN CITY\nNote: 93 YR OLD FEMALE, MAVIS MEGAN, FELL AND HAS CUT ON RIGHT EYE AND EYE AND BRUISE ON FACIAL AREA. CHS NURSING  HOME RM 139B ON NEW SIDE
(Dispatch Alert) CC/DERMA EMR\n205 DAVIS ST\nApt B\nCALHOUN CITY\nNote: CALLER ADV 47 YR OLD FEMALE BREATHING BUT UNRESPONSIVE.
(Dispatch Alert) BANNER EMR\n10 CR 266\nBRUCE\nNote: 72 YOF COMPLAINTING BK PAINS
(Dispatch Alert) BRUCE/CB FIRE\n5 CR 157\nHOULKA\nNote: ADV WOODS ON FIRE
(Dispatch Alert) AMBULANCE\n501 CR 102\nPITTSBORO\nNote: PENNY ADV RUBY KAY 69 YOF FEEDING TUBE HAS COME OUT
(Dispatch Alert) BRUCE/CB EMR\n113 N PONTOTOC RD\nBRUCE\nNote: CALLER ADV. 54 YOF IS HAVING CHEST AND BACK PAINS, MEDICS NEEDED. ADV. M41. BRUCE/CBONE EMRS
(Dispatch Alert) BRUCE/CB EMR\n260 N THOMPSON ST\nApt 14\nBRUCE\nNote: LIFE LINE ADV. BILLY MANN HAVING SEIZURES. UNABLE TO CONTACT BY PHONE\r
(Dispatch Alert) BRUCE/CB EMR\n260 N NEWBURGER AVE\nApt 14\nBRUCE\nNote: LIFE LINE ADV. BILLY MANN HAVING SEIZURES. UNABLE TO CONTACT BY PHONE\r
(Dispatch Alert) BRUCE/CB EMR\n107 E JOHNSON ST\nBRUCE\nNote: 72 YO FEMALE SEVERE NECK PAIN/ NANCY HARRISON
(Dispatch Alert) BRUCE/CB EMR\n113 A CR 247 \nBRUCE\nNote: 56 yo MALE DIALYSIS PATIENT/ BLEEDING FROM SHUNT IN ARM
(Dispatch Alert) BRUCE/CB FIRE\n692 HWY 9 N\nBRUCE\nNote: Patricia Scallion adv she sees smoke behind her house
(Dispatch Alert) CC/DERMA FIRE\n14 CR 411\nCALHOUN CITY\nNote: caller adv he can smell smoke and see smoke near the water tower. He neeeds someone to come out and check on it.
(Dispatch Alert) AMBULANCE\nCALHOUN COUNTY NURSING HOME\n152 BURKE-CC RD\nCALHOUN CITY\nNote: aron has tran to er adv pt wheezing in rm 128-b on the old side
(Dispatch Alert) AMBULANCE\nCALHOUN COUNTY NURSING HOME\n152 BURKE-CC RD\nCALHOUN CITY\nNote: NURSE ADV. 72 YOM NEEDS TO BE TRANSFERED TO ER; IN RM# 137-B NEW SIDE; ADV. MEDIC 44
(Dispatch Alert) CC/DERMA EMR\n129 MYERS AVE\nCALHOUN CITY\nNote: CALLER ADV. 68YOM IS HAVING DIFFCULTY BREATHINGS, NEEDS MEDICS. ADV. MEDIC AND CC/DERMA EMRS
(Dispatch Alert) AMBULANCE\nCALHOUN COUNTY SHERIFF'S OFFICE\n178 S MURPHREE ST\nPITTSBORO\nNote: 47 YR OLD FEMALE, CHERYL ROBINSON, COMPLAINING OF PAIN ALL OVER. HUSBAND ADV THEY WERE ENROUTE TO BAPTIST/OXFORD BUT CAR BROKE DOWN AND REQUEST AMBULANCE. ADV SHE IS IN WITHDRAWALS FROM PAIN  MEDS.
(Dispatch Alert) AMBULANCE\n430 W CALHOUN ST\nBRUCE\nNote: Mattie Ruth adv Dwight Ruth 83 yom needs to be tran to Oxford beacause of shortness of breath
(Dispatch Alert) CC/DERMA EMR\n276 HWY 8 E\nCALHOUN CITY\nNote: Lakisha Shaw 22 yof adv shortness of breath and needs to be tran to Tupelo and history of blood clots
(Dispatch Alert) DEATH\n930 HWY 9 W\nBANNER\nNote: CALLER ADV 74YO FEMALE, ANITA CHRESTMAN, POSSIBLE DECEASED. CALLER  NOT AT RESIDENCE WITH SUBJECT.
(Dispatch Alert) AMBULANCE\nBRUCE COMMUNITY LIVING CENTER\n176 HWY 9 N\nPITTSBORO\nNote: 100 yo F / FELL FROM BED/ LARGE LACERATION ON HEAD
(Dispatch Alert) BRUCE/CB EMR\n201 E CLAY ST\nBRUCE\nNote: CALLER ADV. 38YOM POSSIBLE OVERDOSE, SHE ADV. HE HAS TAKEN SEVERAL PILLS AND HAS BEEN DRINKING; HE IS LAYING IN THE BED, W/SLURRED SPEECH, BUT IS RESPONDING ADV. M44/BRUCE/CBONE EMRS/B3\r
(Dispatch Alert) CC/DERMA EMR\n103 LUNCEFORD LN\nCALHOUN CITY\nNote: lORINE BOUNDA STATED THAT TIFFANY COCKRELL 35 YOF 12 WKS PREGNANT AND SHE IN & OUT OF COSCIENCE AND CRAMPING REAL BAD
(Dispatch Alert) CC/DERMA EMR\n221 SIMMONS DR EXT\nDERMA\nNote: TOMMY JONES 61 YOM UNRESPONSIVE
(Dispatch Alert) CC/DERMA EMR\n58 CR 368\nCALHOUN CITY\nNote: lou Mcphail 79 yof felled and just hip replacement on nov. 19  adv
(Dispatch Alert) PITTSBORO EMR\n6 CR 210-A\nPITTSBORO\nNote: 89 YR OLD FEMALE, EUNICE BOWLING, UNRESPONSIVE BUT BREATHING. NEPHEW ADV MAKING GURGLING NOISES. ADV HISTORY OF DIABETES AND CARDIAC.
(Dispatch Alert) PITTSBORO EMR\n126 CR 100\nPITTSBORO\nNote: CALLER 83YOM IS HAVING DIFFCULTY BREATHING AND IS UNABLE TO RESPOND
(Dispatch Alert) VARDAMAN FIRE\n40 B CR 442\nApt \nVARDAMAN\nNote: grass fire - leaves
(Dispatch Alert) VARDAMAN FIRE\n1 HWY 341 N\nVARDAMAN\nNote: 1 car 10-50 about cr 136
(Dispatch Alert) AMBULANCE\n159 HWY 9 S\nPITTSBORO\nNote: CALLER ADV. 91YOF NAUSEA AND VOMITING NEEDS TO BE TRANSPORTED TO ER

*/

public class MSCalhounCountyParserTest extends BaseParserTest {
  
  public MSCalhounCountyParserTest() {
    setParser(new MSCalhounCountyParser(), "CALHOUN COUNTY", "MS");
  }
  
  @Test
  public void testCalhounCounty() {

    doTest("T1",
        "(Dispatch Alert) CC/DERMA EMR\n129 MYERS AVE\nCALHOUN CITY\nNote: mS lOUISE ADV 68 YOM DIFFCULTY BREATHING",
        "CALL:CC/DERMA EMR",
        "ADDR:129 MYERS AVE",
        "CITY:CALHOUN CITY",
        "INFO:mS lOUISE ADV 68 YOM DIFFCULTY BREATHING");

    doTest("T2",
        "(Dispatch Alert) AMBULANCE\n" +
        "CALHOUN COUNTY NURSING HOME\n" +
        "152 BURKE-CC RD\n" +
        "Apt 139B\n" +
        "CALHOUN CITY\n" +
        "Note: 93 YR OLD FEMALE, MAVIS MEGAN, FELL AND HAS CUT ON RIGHT EYE AND EYE AND BRUISE ON FACIAL AREA. CHS NURSING  HOME RM 139B ON NEW SIDE",

        "CALL:AMBULANCE",
        "PLACE:CALHOUN COUNTY NURSING HOME",
        "ADDR:152 BURKE CALHOUN CITY RD",
        "APT:139B",
        "CITY:CALHOUN CITY",
        "INFO:93 YR OLD FEMALE, MAVIS MEGAN, FELL AND HAS CUT ON RIGHT EYE AND EYE AND BRUISE ON FACIAL AREA. CHS NURSING  HOME RM 139B ON NEW SIDE");

    doTest("T3",
        "(Dispatch Alert) CC/DERMA EMR\n205 DAVIS ST\nApt B\nCALHOUN CITY\nNote: CALLER ADV 47 YR OLD FEMALE BREATHING BUT UNRESPONSIVE.",
        "CALL:CC/DERMA EMR",
        "ADDR:205 DAVIS ST",
        "APT:B",
        "CITY:CALHOUN CITY",
        "INFO:CALLER ADV 47 YR OLD FEMALE BREATHING BUT UNRESPONSIVE.");

    doTest("T4",
        "(Dispatch Alert) BANNER EMR\n10 CR 266\nBRUCE\nNote: 72 YOF COMPLAINTING BK PAINS",
        "CALL:BANNER EMR",
        "ADDR:10 CR 266",
        "MADDR:10 COUNTY ROAD 266",
        "CITY:BRUCE",
        "INFO:72 YOF COMPLAINTING BK PAINS");

    doTest("T5",
        "(Dispatch Alert) BRUCE/CB FIRE\n5 CR 157\nHOULKA\nNote: ADV WOODS ON FIRE",
        "CALL:BRUCE/CB FIRE",
        "ADDR:5 CR 157",
        "MADDR:5 COUNTY ROAD 157",
        "CITY:HOULKA",
        "INFO:ADV WOODS ON FIRE");

    doTest("T6",
        "(Dispatch Alert) AMBULANCE\n501 CR 102\nPITTSBORO\nNote: PENNY ADV RUBY KAY 69 YOF FEEDING TUBE HAS COME OUT",
        "CALL:AMBULANCE",
        "ADDR:501 CR 102",
        "MADDR:501 COUNTY ROAD 102",
        "CITY:PITTSBORO",
        "INFO:PENNY ADV RUBY KAY 69 YOF FEEDING TUBE HAS COME OUT");

    doTest("T7",
        "(Dispatch Alert) BRUCE/CB EMR\n" +
        "113 N PONTOTOC RD\n" +
        "BRUCE\n" +
        "Note: CALLER ADV. 54 YOF IS HAVING CHEST AND BACK PAINS, MEDICS NEEDED. ADV. M41. BRUCE/CBONE EMRS",

        "CALL:BRUCE/CB EMR",
        "ADDR:113 N PONTOTOC RD",
        "CITY:BRUCE",
        "INFO:CALLER ADV. 54 YOF IS HAVING CHEST AND BACK PAINS, MEDICS NEEDED. ADV. M41. BRUCE/CBONE EMRS");

    doTest("T8",
        "(Dispatch Alert) BRUCE/CB EMR\n" +
        "260 N THOMPSON ST\n" +
        "Apt 14\n" +
        "BRUCE\n" +
        "Note: LIFE LINE ADV. BILLY MANN HAVING SEIZURES. UNABLE TO CONTACT BY PHONE\r",

        "CALL:BRUCE/CB EMR",
        "ADDR:260 N THOMPSON ST",
        "APT:14",
        "CITY:BRUCE",
        "INFO:LIFE LINE ADV. BILLY MANN HAVING SEIZURES. UNABLE TO CONTACT BY PHONE");

    doTest("T9",
        "(Dispatch Alert) BRUCE/CB EMR\n" +
        "260 N NEWBURGER AVE\n" +
        "Apt 14\n" +
        "BRUCE\n" +
        "Note: LIFE LINE ADV. BILLY MANN HAVING SEIZURES. UNABLE TO CONTACT BY PHONE\r",

        "CALL:BRUCE/CB EMR",
        "ADDR:260 N NEWBURGER AVE",
        "APT:14",
        "CITY:BRUCE",
        "INFO:LIFE LINE ADV. BILLY MANN HAVING SEIZURES. UNABLE TO CONTACT BY PHONE");

    doTest("T10",
        "(Dispatch Alert) BRUCE/CB EMR\n107 E JOHNSON ST\nBRUCE\nNote: 72 YO FEMALE SEVERE NECK PAIN/ NANCY HARRISON",
        "CALL:BRUCE/CB EMR",
        "ADDR:107 E JOHNSON ST",
        "CITY:BRUCE",
        "INFO:72 YO FEMALE SEVERE NECK PAIN/ NANCY HARRISON");

    doTest("T11",
        "(Dispatch Alert) BRUCE/CB EMR\n113 A CR 247 \nBRUCE\nNote: 56 yo MALE DIALYSIS PATIENT/ BLEEDING FROM SHUNT IN ARM",
        "CALL:BRUCE/CB EMR",
        "ADDR:113 A CR 247",
        "MADDR:113 A COUNTY ROAD 247",
        "CITY:BRUCE",
        "INFO:56 yo MALE DIALYSIS PATIENT/ BLEEDING FROM SHUNT IN ARM");

    doTest("T12",
        "(Dispatch Alert) BRUCE/CB FIRE\n692 HWY 9 N\nBRUCE\nNote: Patricia Scallion adv she sees smoke behind her house",
        "CALL:BRUCE/CB FIRE",
        "ADDR:692 HWY 9 N",
        "CITY:BRUCE",
        "INFO:Patricia Scallion adv she sees smoke behind her house");

    doTest("T13",
        "(Dispatch Alert) CC/DERMA FIRE\n" +
        "14 CR 411\n" +
        "CALHOUN CITY\n" +
        "Note: caller adv he can smell smoke and see smoke near the water tower. He neeeds someone to come out and check on it.",

        "CALL:CC/DERMA FIRE",
        "ADDR:14 CR 411",
        "MADDR:14 COUNTY ROAD 411",
        "CITY:CALHOUN CITY",
        "INFO:caller adv he can smell smoke and see smoke near the water tower. He neeeds someone to come out and check on it.");

    doTest("T14",
        "(Dispatch Alert) AMBULANCE\n" +
        "CALHOUN COUNTY NURSING HOME\n" +
        "152 BURKE-CC RD\n" +
        "CALHOUN CITY\n" +
        "Note: aron has tran to er adv pt wheezing in rm 128-b on the old side",

        "CALL:AMBULANCE",
        "PLACE:CALHOUN COUNTY NURSING HOME",
        "ADDR:152 BURKE CALHOUN CITY RD",
        "CITY:CALHOUN CITY",
        "INFO:aron has tran to er adv pt wheezing in rm 128-b on the old side");

    doTest("T15",
        "(Dispatch Alert) AMBULANCE\n" +
        "CALHOUN COUNTY NURSING HOME\n" +
        "152 BURKE-CC RD\n" +
        "CALHOUN CITY\n" +
        "Note: NURSE ADV. 72 YOM NEEDS TO BE TRANSFERED TO ER; IN RM# 137-B NEW SIDE; ADV. MEDIC 44",

        "CALL:AMBULANCE",
        "PLACE:CALHOUN COUNTY NURSING HOME",
        "ADDR:152 BURKE CALHOUN CITY RD",
        "CITY:CALHOUN CITY",
        "INFO:NURSE ADV. 72 YOM NEEDS TO BE TRANSFERED TO ER; IN RM# 137-B NEW SIDE; ADV. MEDIC 44");

    doTest("T16",
        "(Dispatch Alert) CC/DERMA EMR\n" +
        "129 MYERS AVE\n" +
        "CALHOUN CITY\n" +
        "Note: CALLER ADV. 68YOM IS HAVING DIFFCULTY BREATHINGS, NEEDS MEDICS. ADV. MEDIC AND CC/DERMA EMRS",

        "CALL:CC/DERMA EMR",
        "ADDR:129 MYERS AVE",
        "CITY:CALHOUN CITY",
        "INFO:CALLER ADV. 68YOM IS HAVING DIFFCULTY BREATHINGS, NEEDS MEDICS. ADV. MEDIC AND CC/DERMA EMRS");

    doTest("T17",
        "(Dispatch Alert) AMBULANCE\n" +
        "CALHOUN COUNTY SHERIFF'S OFFICE\n" +
        "178 S MURPHREE ST\n" +
        "PITTSBORO\n" +
        "Note: 47 YR OLD FEMALE, CHERYL ROBINSON, COMPLAINING OF PAIN ALL OVER. HUSBAND ADV THEY WERE ENROUTE TO BAPTIST/OXFORD BUT CAR BROKE DOWN AND REQUEST AMBULANCE. ADV SHE IS IN WITHDRAWALS FROM PAIN  MEDS.",

        "CALL:AMBULANCE",
        "PLACE:CALHOUN COUNTY SHERIFF'S OFFICE",
        "ADDR:178 S MURPHREE ST",
        "CITY:PITTSBORO",
        "INFO:47 YR OLD FEMALE, CHERYL ROBINSON, COMPLAINING OF PAIN ALL OVER. HUSBAND ADV THEY WERE ENROUTE TO BAPTIST/OXFORD BUT CAR BROKE DOWN AND REQUEST AMBULANCE. ADV SHE IS IN WITHDRAWALS FROM PAIN  MEDS.");

    doTest("T18",
        "(Dispatch Alert) AMBULANCE\n" +
        "430 W CALHOUN ST\n" +
        "BRUCE\n" +
        "Note: Mattie Ruth adv Dwight Ruth 83 yom needs to be tran to Oxford beacause of shortness of breath",

        "CALL:AMBULANCE",
        "ADDR:430 W CALHOUN ST",
        "CITY:BRUCE",
        "INFO:Mattie Ruth adv Dwight Ruth 83 yom needs to be tran to Oxford beacause of shortness of breath");

    doTest("T19",
        "(Dispatch Alert) CC/DERMA EMR\n" +
        "276 HWY 8 E\n" +
        "CALHOUN CITY\n" +
        "Note: Lakisha Shaw 22 yof adv shortness of breath and needs to be tran to Tupelo and history of blood clots",

        "CALL:CC/DERMA EMR",
        "ADDR:276 HWY 8 E",
        "CITY:CALHOUN CITY",
        "INFO:Lakisha Shaw 22 yof adv shortness of breath and needs to be tran to Tupelo and history of blood clots");

    doTest("T20",
        "(Dispatch Alert) DEATH\n" +
        "930 HWY 9 W\n" +
        "BANNER\n" +
        "Note: CALLER ADV 74YO FEMALE, ANITA CHRESTMAN, POSSIBLE DECEASED. CALLER  NOT AT RESIDENCE WITH SUBJECT.",

        "CALL:DEATH",
        "ADDR:930 HWY 9 W",
        "CITY:BANNER",
        "INFO:CALLER ADV 74YO FEMALE, ANITA CHRESTMAN, POSSIBLE DECEASED. CALLER  NOT AT RESIDENCE WITH SUBJECT.");

    doTest("T21",
        "(Dispatch Alert) AMBULANCE\n" +
        "BRUCE COMMUNITY LIVING CENTER\n" +
        "176 HWY 9 N\n" +
        "PITTSBORO\n" +
        "Note: 100 yo F / FELL FROM BED/ LARGE LACERATION ON HEAD",

        "CALL:AMBULANCE",
        "PLACE:BRUCE COMMUNITY LIVING CENTER",
        "ADDR:176 HWY 9 N",
        "CITY:PITTSBORO",
        "INFO:100 yo F / FELL FROM BED/ LARGE LACERATION ON HEAD");

    doTest("T22",
        "(Dispatch Alert) BRUCE/CB EMR\n" +
        "201 E CLAY ST\n" +
        "BRUCE\n" +
        "Note: CALLER ADV. 38YOM POSSIBLE OVERDOSE, SHE ADV. HE HAS TAKEN SEVERAL PILLS AND HAS BEEN DRINKING; HE IS LAYING IN THE BED, W/SLURRED SPEECH, BUT IS RESPONDING ADV. M44/BRUCE/CBONE EMRS/B3\r",

        "CALL:BRUCE/CB EMR",
        "ADDR:201 E CLAY ST",
        "CITY:BRUCE",
        "INFO:CALLER ADV. 38YOM POSSIBLE OVERDOSE, SHE ADV. HE HAS TAKEN SEVERAL PILLS AND HAS BEEN DRINKING; HE IS LAYING IN THE BED, W/SLURRED SPEECH, BUT IS RESPONDING ADV. M44/BRUCE/CBONE EMRS/B3");

    doTest("T23",
        "(Dispatch Alert) CC/DERMA EMR\n" +
        "103 LUNCEFORD LN\n" +
        "CALHOUN CITY\n" +
        "Note: lORINE BOUNDA STATED THAT TIFFANY COCKRELL 35 YOF 12 WKS PREGNANT AND SHE IN & OUT OF COSCIENCE AND CRAMPING REAL BAD",

        "CALL:CC/DERMA EMR",
        "ADDR:103 LUNCEFORD LN",
        "CITY:CALHOUN CITY",
        "INFO:lORINE BOUNDA STATED THAT TIFFANY COCKRELL 35 YOF 12 WKS PREGNANT AND SHE IN & OUT OF COSCIENCE AND CRAMPING REAL BAD");

    doTest("T24",
        "(Dispatch Alert) CC/DERMA EMR\n221 SIMMONS DR EXT\nDERMA\nNote: TOMMY JONES 61 YOM UNRESPONSIVE",
        "CALL:CC/DERMA EMR",
        "ADDR:221 SIMMONS DR EXT",
        "MADDR:221 SIMMONS DR",
        "CITY:DERMA",
        "INFO:TOMMY JONES 61 YOM UNRESPONSIVE");

    doTest("T25",
        "(Dispatch Alert) CC/DERMA EMR\n58 CR 368\nCALHOUN CITY\nNote: lou Mcphail 79 yof felled and just hip replacement on nov. 19  adv",
        "CALL:CC/DERMA EMR",
        "ADDR:58 CR 368",
        "MADDR:58 COUNTY ROAD 368",
        "CITY:CALHOUN CITY",
        "INFO:lou Mcphail 79 yof felled and just hip replacement on nov. 19  adv");

    doTest("T26",
        "(Dispatch Alert) PITTSBORO EMR\n" +
        "6 CR 210-A\n" +
        "PITTSBORO\n" +
        "Note: 89 YR OLD FEMALE, EUNICE BOWLING, UNRESPONSIVE BUT BREATHING. NEPHEW ADV MAKING GURGLING NOISES. ADV HISTORY OF DIABETES AND CARDIAC.",

        "CALL:PITTSBORO EMR",
        "ADDR:6 CR 210-A",
        "MADDR:6 COUNTY ROAD 210-A",
        "CITY:PITTSBORO",
        "INFO:89 YR OLD FEMALE, EUNICE BOWLING, UNRESPONSIVE BUT BREATHING. NEPHEW ADV MAKING GURGLING NOISES. ADV HISTORY OF DIABETES AND CARDIAC.");

    doTest("T27",
        "(Dispatch Alert) PITTSBORO EMR\n126 CR 100\nPITTSBORO\nNote: CALLER 83YOM IS HAVING DIFFCULTY BREATHING AND IS UNABLE TO RESPOND",
        "CALL:PITTSBORO EMR",
        "ADDR:126 CR 100",
        "MADDR:126 COUNTY ROAD 100",
        "CITY:PITTSBORO",
        "INFO:CALLER 83YOM IS HAVING DIFFCULTY BREATHING AND IS UNABLE TO RESPOND");

    doTest("T28",
        "(Dispatch Alert) VARDAMAN FIRE\n40 B CR 442\nApt \nVARDAMAN\nNote: grass fire - leaves",
        "CALL:VARDAMAN FIRE",
        "ADDR:40 B CR 442",
        "MADDR:40 B COUNTY ROAD 442",
        "CITY:VARDAMAN",
        "INFO:grass fire - leaves");

    doTest("T29",
        "(Dispatch Alert) VARDAMAN FIRE\n1 HWY 341 N\nVARDAMAN\nNote: 1 car 10-50 about cr 136",
        "CALL:VARDAMAN FIRE",
        "ADDR:1 HWY 341 N",
        "CITY:VARDAMAN",
        "INFO:1 car 10-50 about cr 136");

    doTest("T30",
        "(Dispatch Alert) AMBULANCE\n159 HWY 9 S\nPITTSBORO\nNote: CALLER ADV. 91YOF NAUSEA AND VOMITING NEEDS TO BE TRANSPORTED TO ER",
        "CALL:AMBULANCE",
        "ADDR:159 HWY 9 S",
        "CITY:PITTSBORO",
        "INFO:CALLER ADV. 91YOF NAUSEA AND VOMITING NEEDS TO BE TRANSPORTED TO ER");

  }
  
  public static void main(String[] args) {
    new MSCalhounCountyParserTest().generateTests("T1");
  }
}