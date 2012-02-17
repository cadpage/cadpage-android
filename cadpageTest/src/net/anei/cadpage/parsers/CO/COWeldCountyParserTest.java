package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.CO.COWeldCountyParser;

import org.junit.Test;


public class COWeldCountyParserTest extends BaseParserTest {
  
  public COWeldCountyParserTest() {
    setParser(new COWeldCountyParser(), "WELD COUNTY", "CO");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "\" \" 24\nSIPF\nD\n3211 LUPTON AVE\nEV\n24\nMOM IS NOT WAKING UP 0000 Confirm 0001 Refuse TXT STOP to opt-out",
        "CODE:SIPF",
        "CALL:SICK AND INJURED POLICE/FIRE",
        "ADDR:3211 LUPTON AVE",
        "SRC:EV",
        "UNIT:24",
        "INFO:MOM IS NOT WAKING UP 0000 Confirm 0001 Refuse");

    doTest("T2",
        "\" \" 24\n" +
        "ALARMFR\n" +
        "D\n" +
        "2936 PARK VIEW DR   ; CARRICH RESIDENCE\n" +
        "EV\n" +
        "24D\n" +
        "AUDIBLE FROM ZONE 4.  NO ANSWER OS.  PREM PH 970 339 7664.  WILL BE ATC\n" +
        "KEYHOLDER. 0000 Confirm 0001 Refuse TXT STOP to opt-out",

        "CODE:ALARMFR",
        "CALL:FIRE ALARM RESIDENTIAL",
        "ADDR:2936 PARK VIEW DR",
        "PLACE:CARRICH RESIDENCE",
        "SRC:EV",
        "UNIT:24D",
        "INFO:AUDIBLE FROM ZONE 4.  NO ANSWER OS.  PREM PH 970 339 7664.  WILL BE ATC / KEYHOLDER. 0000 Confirm 0001 Refuse");

    doTest("T3",
        "\" \" 36\n" +
        "TAU\n" +
        "D\n" +
        "WCR 21\n" +
        "PL\n" +
        "36\n" +
        "4DR SD DOWN IN DITCH\n" +
        "ProQA Medical Recommended Dispatch Level = 29B04U\n" +
        "You are responding to patients involved in a traffic incident.  (If known -- relay  pertinent patient-specific information.) Unknown status/Other codes n TXT STOP to opt-out",

        "CODE:29B04U",
        "CALL:TRAFFIC ACCIDENT UNKNOWN INJ",
        "ADDR:CR 21",
        "MADDR:COUNTY ROAD 21",
        "SRC:PL",
        "UNIT:36",
        "INFO:4DR SD DOWN IN DITCH / You are responding to patients involved in a traffic incident.  (If known -- relay  pertinent patient-specific information.) Unknown status/Other codes n");

    doTest("T4",
        "\" \" 24\n" +
        "SIPF\n" +
        "D\n" +
        "800 31ST ST; AMERICAS BEST VALUE INN RM #31\n" +
        "EV\n" +
        "24\n" +
        "HSBND BEGAN HAVING A SIEZURE WHILE ON THE PHN W/HER. RP NOT OS TXT STOP to opt-out",

        "CODE:SIPF",
        "CALL:SICK AND INJURED POLICE/FIRE",
        "ADDR:800 31ST ST",
        "PLACE:AMERICAS BEST VALUE INN RM #31",
        "SRC:EV",
        "UNIT:24",
        "INFO:HSBND BEGAN HAVING A SIEZURE WHILE ON THE PHN W/HER. RP NOT OS");

    doTest("T5",
        "\" \" 36\n" +
        "SMKODR\n" +
        "D\n" +
        "WCR 17\n" +
        "PL\n" +
        "36\n" +
        "1/4 MILES WEST...NORTH SIDE OF THE ROAD..NATURAL GAS LINE LEAK.. NO RESIDENCES\n" +
        "THREATENED TXT STOP to opt-out",

        "CODE:SMKODR",
        "CALL:SMOKE ODOR INVESTIGATION",
        "ADDR:CR 17",
        "MADDR:COUNTY ROAD 17",
        "SRC:PL",
        "UNIT:36",
        "INFO:1/4 MILES WEST...NORTH SIDE OF THE ROAD..NATURAL GAS LINE LEAK.. NO RESIDENCES / THREATENED");

    doTest("T6",
        "\" \" 26\n" +
        "TAU\n" +
        "D\n" +
        "HWY 52\n" +
        "FL\n" +
        "26A\n" +
        "SB** RP SEEN A BLK CAR POSS 4 DR CAR GO OFF THE RD AND DOWN EMBANKMENT, RP JUST\n" +
        "PASSED BY TXT STOP to opt-out",

        "CODE:TAU",
        "CALL:TRAFFIC ACCIDENT UNKNOWN INJ",
        "ADDR:HWY 52",
        "SRC:FL",
        "UNIT:26A",
        "INFO:SB** RP SEEN A BLK CAR POSS 4 DR CAR GO OFF THE RD AND DOWN EMBANKMENT, RP JUST / PASSED BY");

    doTest("T7",
        "\" \" 26\n" +
        "TAU\n" +
        "D\n" +
        "WCR 18\n" +
        "FL\n" +
        "26D\n" +
        "VEH IN THE DITCH LIGHTS STILL ON - RP COULD NOT STOP. VEH IS A DRK SEDAN\n" +
        "ProQA Medical Recommended Dispatch Level = 29B04U\n" +
        "You are responding to patients involved in a traffic incident.  (If known -- relay  pertinent patien TXT STOP to opt-out",

        "CODE:29B04U",
        "CALL:TRAFFIC ACCIDENT UNKNOWN INJ",
        "ADDR:CR 18",
        "MADDR:COUNTY ROAD 18",
        "SRC:FL",
        "UNIT:26D",
        "INFO:VEH IN THE DITCH LIGHTS STILL ON - RP COULD NOT STOP. VEH IS A DRK SEDAN / You are responding to patients involved in a traffic incident.  (If known -- relay  pertinent patien");

    doTest("T8",
        "\" \" 26\n" +
        "TAU\n" +
        "D\n" +
        "HWY 85 SB\n" +
        "FL\n" +
        "26\n" +
        "RED CHEVY BLAZER VS WHITE FORD EXPLORER.  EXPLORER LOST CONTROL\n" +
        "ProQA Medical Recommended Dispatch Level = 29B04U\n" +
        "You are responding to patients involved in a traffic incident.  (If known -- relay  pertinent patient-speci TXT STOP to opt-out",

        "CODE:29B04U",
        "CALL:TRAFFIC ACCIDENT UNKNOWN INJ",
        "ADDR:HWY 85 SB",
        "MADDR:HWY 85",
        "SRC:FL",
        "UNIT:26",
        "INFO:RED CHEVY BLAZER VS WHITE FORD EXPLORER.  EXPLORER LOST CONTROL / You are responding to patients involved in a traffic incident.  (If known -- relay  pertinent patient-speci");

    doTest("T9",
        "\" \" 26\n" +
        "SIPF\n" +
        "D\n" +
        "1001 MOUNTVIEW AVE;410\n" +
        "FL\n" +
        "26\n" +
        "RP IS WEAK, ALL OF A SUDDEN\n" +
        "ProQA Medical Recommended Dispatch Level = 26A05\n" +
        "You are responding to a patient who is sick (or has a current medical condition).  The patient is a 50-year-old male, who is consc TXT STOP to opt-out",

        "CODE:26A05",
        "CALL:SICK AND INJURED POLICE/FIRE",
        "ADDR:1001 MOUNTVIEW AVE",
        "APT:410",
        "SRC:FL",
        "UNIT:26",
        "INFO:RP IS WEAK, ALL OF A SUDDEN / You are responding to a patient who is sick (or has a current medical condition).  The patient is a 50-year-old male, who is consc");

    doTest("T10",
        "\" \" 26\n" +
        "FASIST\n" +
        "D\n" +
        "WCR 31\n" +
        "FL\n" +
        "26\n" +
        "VEH HIT A POWER POLE, POLE IS DOWN, LINES DOWN...LINES NOT SPARKING . RP\n" +
        "BELIEVES UNITED POWER SERVICES THE AREA. RP IS OS IN A BLUE DODGE PU\n" +
        "POWERLINES DOWN DUE TO TAHR, NOT SPARKING, WILL ADVISE  UNITED POWER TXT STOP to opt-out",

        "CODE:FASIST",
        "CALL:FIRE ASSIST",
        "ADDR:CR 31",
        "MADDR:COUNTY ROAD 31",
        "SRC:FL",
        "UNIT:26",
        "INFO:VEH HIT A POWER POLE, POLE IS DOWN, LINES DOWN...LINES NOT SPARKING . RP / BELIEVES UNITED POWER SERVICES THE AREA. RP IS OS IN A BLUE DODGE PU / POWERLINES DOWN DUE TO TAHR, NOT SPARKING, WILL ADVISE  UNITED POWER");

    doTest("T11",
        "\" \" 26\n" +
        "SIPF\n" +
        "D\n" +
        "451 ROLLIE AVE\n" +
        "FL\n" +
        "26\n" +
        "RES HAS FALLEN, HURT ANKLE, TOO LG FOR RP TO PU\n" +
        "ProQA Medical Recommended Dispatch Level = 17A01G\n" +
        "You are responding to a patient involved in a fall.  The patient is a 61-year-old  female, who is conscious and breat TXT STOP to opt-out",

        "CODE:17A01G",
        "CALL:SICK AND INJURED POLICE/FIRE",
        "ADDR:451 ROLLIE AVE",
        "SRC:FL",
        "UNIT:26",
        "INFO:RES HAS FALLEN, HURT ANKLE, TOO LG FOR RP TO PU / You are responding to a patient involved in a fall.  The patient is a 61-year-old  female, who is conscious and breat");

    doTest("T12",
        "\" \" 26\nSIPF\nD\n7898 RICHARD ST\nFL\n26\nFEMALE GOING CRAZY - POSS PSYCH ISSUE TXT STOP to opt-out",
        "CODE:SIPF",
        "CALL:SICK AND INJURED POLICE/FIRE",
        "ADDR:7898 RICHARD ST",
        "SRC:FL",
        "UNIT:26",
        "INFO:FEMALE GOING CRAZY - POSS PSYCH ISSUE");

    doTest("T13",
        "\" \" 26\nFIREV\nD\n14619 WCR 18\nFL\n26 TXT STOP to opt-out",
        "CODE:FIREV",
        "CALL:VEHICLE FIRE",
        "ADDR:14619 CR 18",
        "MADDR:14619 COUNTY ROAD 18",
        "SRC:FL",
        "UNIT:26");

    doTest("T14",
        "\" \" 26\n" +
        "SI\n" +
        "D\n" +
        "1001 MOUNTVIEW AVE; 410\n" +
        "FL\n" +
        "26A\n" +
        "ProQA Medical Recommended Dispatch Level = 28C03G\n" +
        "You are responding to a patient who has apparently suffered a stroke. The patient  is a 60-year-old male, who is conscious and breathing. Sudden speech  pro TXT STOP to opt-out",

        "CODE:28C03G",
        "CALL:SICK AND INJURED FIRE/EMS",
        "ADDR:1001 MOUNTVIEW AVE",
        "APT:410",
        "SRC:FL",
        "UNIT:26A",
        "INFO:You are responding to a patient who has apparently suffered a stroke. The patient  is a 60-year-old male, who is conscious and breathing. Sudden speech  pro");

    doTest("T15",
        "\" \" 26\n" +
        "SIPF\n" +
        "D\n" +
        "15022 MORRIS AVE\n" +
        "FL\n" +
        "26\n" +
        "dizzy ill female\n" +
        "ProQA Medical Recommended Dispatch Level = 31C01\n" +
        "You are responding to a patient who is unconscious (or has 0000 Confirm 0001 Refuse fainted).  The patient  is a 78-year-old female, who is conscious and breathing. Alert w 0000 Confirm 0001 Refuse TXT STOP to opt-out",

        "CODE:31C01",
        "CALL:SICK AND INJURED POLICE/FIRE",
        "ADDR:15022 MORRIS AVE",
        "SRC:FL",
        "UNIT:26",
        "INFO:dizzy ill female / You are responding to a patient who is unconscious (or has 0000 Confirm 0001 Refuse fainted).  The patient  is a 78-year-old female, who is conscious and breathing. Alert w 0000 Confirm 0001 Refuse");

    doTest("T16",
        "\" \" 26\n" +
        "ATSUCI\n" +
        "D\n" +
        "1001 MOUNTVIEW AVE; 106\n" +
        "FL\n" +
        "26\n" +
        "SUICIDAL PARTY CARY BOLINGTON\n" +
        "ProQA Medical Recommended Dispatch Level = 25B03\n" +
        "You are responding to a patient who has abnormal or suicidal behavior.  The patient is a 52-year-old male, who is conscious a TXT STOP to opt-out",

        "CODE:25B03",
        "CALL:ATTEMPT SUICIDE",
        "ADDR:1001 MOUNTVIEW AVE",
        "APT:106",
        "SRC:FL",
        "UNIT:26",
        "INFO:SUICIDAL PARTY CARY BOLINGTON / You are responding to a patient who has abnormal or suicidal behavior.  The patient is a 52-year-old male, who is conscious a");

    doTest("T17",
        "\" \" 26\n" +
        "SI\n" +
        "D\n" +
        "HWY 52\n" +
        "FL\n" +
        "26\n" +
        "RP PULLED OVER TO HELP A MAN THAT WAS ON THE SIDE OF THE ROAD ... HIS\n" +
        "TRANSMISSION WENT OUT BUT THE MAN IS VERY CONFUSED AND DOESNT KNOW WHERE HE IS\n" +
        "OR HIS NAME OR SONS NAME. RP IS GOING TO WAIT WITH HIM. RP SAYS HE DOESNT NE TXT STOP to opt-out",

        "CODE:SI",
        "CALL:SICK AND INJURED FIRE/EMS",
        "ADDR:HWY 52",
        "SRC:FL",
        "UNIT:26",
        "INFO:RP PULLED OVER TO HELP A MAN THAT WAS ON THE SIDE OF THE ROAD ... HIS / TRANSMISSION WENT OUT BUT THE MAN IS VERY CONFUSED AND DOESNT KNOW WHERE HE IS / OR HIS NAME OR SONS NAME. RP IS GOING TO WAIT WITH HIM. RP SAYS HE DOESNT NE");

    doTest("T18",
        "\" \" 26\nSIPF\nD\n5018 WCR 35\nFL\n26\nRP'S WIFE IS HAVING A SEIZURE TXT STOP to opt-out",
        "CODE:SIPF",
        "CALL:SICK AND INJURED POLICE/FIRE",
        "ADDR:5018 CR 35",
        "MADDR:5018 COUNTY ROAD 35",
        "SRC:FL",
        "UNIT:26",
        "INFO:RP'S WIFE IS HAVING A SEIZURE");

    doTest("T19",
        "\" \" 26\n" +
        "MUT\n" +
        "D\n" +
        "2999 9TH ST; FL FD STN 2\n" +
        "FL\n" +
        "26\n" +
        "Brighton Fire requesting a Ft Lupton tower to respond and cover BF Stn 51 TXT STOP to opt-out",

        "CODE:MUT",
        "CALL:MUTUAL AID",
        "ADDR:2999 9TH ST",
        "PLACE:FL FD STN 2",
        "SRC:FL",
        "UNIT:26",
        "INFO:Brighton Fire requesting a Ft Lupton tower to respond and cover BF Stn 51");

    doTest("T20",
        "\" \" 26\nTAU\nD\nHWY 52\nFL\n26\nsb//veh in ditch TXT STOP to opt-out",
        "CODE:TAU",
        "CALL:TRAFFIC ACCIDENT UNKNOWN INJ",
        "ADDR:HWY 52",
        "SRC:FL",
        "UNIT:26",
        "INFO:sb//veh in ditch");

    doTest("T21",
        "\" \" 26\nTAU\nD\nHWY 52\nFL\n26\nMAROON SUV THAT IS ROLLED OVER SOUTH OF HY 52 TXT STOP to opt-outSend time:1328594015000",
        "CODE:TAU",
        "CALL:TRAFFIC ACCIDENT UNKNOWN INJ",
        "ADDR:HWY 52",
        "SRC:FL",
        "UNIT:26",
        "INFO:MAROON SUV THAT IS ROLLED OVER SOUTH OF HY 52");

    doTest("T22",
        "\" \" 32\n" +
        "FASIST\n" +
        "D\n" +
        "23510 HIGHWAY 257\n" +
        "MI\n" +
        "32\n" +
        "S SIDE OF THE UP RR // GAS BLOW OFF\n" +
        "RP THINKS IT NEEDS TO BE CHECKED ON BCSE IT'S \"REALLY BLUE\" TXT STOP to opt-out",

        "CODE:FASIST",
        "CALL:FIRE ASSIST",
        "ADDR:23510 HIGHWAY 257",
        "SRC:MI",
        "UNIT:32",
        "INFO:S SIDE OF THE UP RR // GAS BLOW OFF / RP THINKS IT NEEDS TO BE CHECKED ON BCSE IT'S \"REALLY BLUE\"");

    doTest("T23",
        "\" \" 26\n" +
        "TAI\n" +
        "D\n" +
        "WCR 19\n" +
        "FL\n" +
        "26\n" +
        "TAI\n" +
        "ProQA Medical Recommended Dispatch Level = 29D02p\n" +
        "You are responding to patients involved in a traffic incident.  (If known -- relay TXT STOP to opt-out",

        "CODE:29D02p",
        "CALL:TRAFFIC ACCIDENT WITH INJURY",
        "ADDR:CR 19",
        "MADDR:COUNTY ROAD 19",
        "SRC:FL",
        "UNIT:26",
        "INFO:TAI / You are responding to patients involved in a traffic incident.  (If known -- relay");

    doTest("T24",
        "\" \" 32\nSIPF\nD\n107 PAR DR\nMI\n32\nSEIZURE TXT STOP to opt-out",
        "CODE:SIPF",
        "CALL:SICK AND INJURED POLICE/FIRE",
        "ADDR:107 PAR DR",
        "SRC:MI",
        "UNIT:32",
        "INFO:SEIZURE");
   
  }
  
  @Test
  public void testparser2() {

    doTest("T1",
        "Dispatch / 22\nSIPF\nD\n13009 WCR 13\nMV3E\n2203\nFALL..INSIDE BUSINESS\n",
        "CODE:SIPF",
        "CALL:SICK AND INJURED POLICE/FIRE",
        "ADDR:13009 CR 13",
        "MADDR:13009 COUNTY ROAD 13",
        "SRC:MV3E",
        "UNIT:2203",
        "INFO:FALL..INSIDE BUSINESS");

    doTest("T2",
        "Dispatch / LAFF\nFIRESR\nD\n711 MEADOWLARK DR\nBOLFF\n22\nalready toned stn 6 mnt view....for trailer on fire\n",
        "CODE:FIRESR",
        "CALL:RESIDENTIAL STRUCTURE FIRE",
        "ADDR:711 MEADOWLARK DR",
        "SRC:BOLFF",
        "UNIT:22",
        "INFO:already toned stn 6 mnt view....for trailer on fire");

    doTest("T3",
        "(Dispatch) 22\n" +
        "ATSUCI\n" +
        "D\n" +
        "2651 HUGHS DR\n" +
        "MV6B\n" +
        "2206\n" +
        "toned mv stn 6 male shot himself in the head with a gun\n" +
        "ProQA Medical Case 5590 Aborted  bouilder emd",

        "CODE:ATSUCI",
        "CALL:ATTEMPT SUICIDE",
        "ADDR:2651 HUGHS DR",
        "SRC:MV6B",
        "UNIT:2206",
        "INFO:toned mv stn 6 male shot himself in the head with a gun / ProQA Medical Case 5590 Aborted  bouilder emd");

    doTest("T4",
        "22\n" +
        "SI\n" +
        "D\n" +
        "7803 MONARCH RD\n" +
        "MV4A\n" +
        "2201\n" +
        "TONED OUT 2224 REF A MALE PARTY WITH A DIABETIC SEIZURE.\n" +
        "ProQA Medical Case 8109 Aborted\\2sOTHER CENTER EMD'D",

        "CODE:SI",
        "CALL:SICK AND INJURED FIRE/EMS",
        "ADDR:7803 MONARCH RD",
        "SRC:MV4A",
        "UNIT:2201",
        "INFO:TONED OUT 2224 REF A MALE PARTY WITH A DIABETIC SEIZURE. / ProQA Medical Case 8109 Aborted\\2sOTHER CENTER EMD'D");

    doTest("T5",
        "22\n" +
        "TAI\n" +
        "D\n" +
        "1415 VISTA VIEW DR; HAJEK CHEVROLET\n" +
        "MV1B\n" +
        "2201\n" +
        "ROLL OVER // RP DISC'D BEFORE GETTING FRUTHER\n" +
        "RP ADVD THEY WERE ON HWY 119 // DIDN'T GIVE DOT // SOUNDED",

        "CODE:TAI",
        "CALL:TRAFFIC ACCIDENT WITH INJURY",
        "ADDR:1415 VISTA VIEW DR",
        "PLACE:HAJEK CHEVROLET",
        "SRC:MV1B",
        "UNIT:2201",
        "INFO:ROLL OVER // RP DISC'D BEFORE GETTING FRUTHER / RP ADVD THEY WERE ON HWY 119 // DIDN'T GIVE DOT // SOUNDED");

    doTest("T6",
        "22\n" +
        "ALARMFR\n" +
        "D\n" +
        "2758 IRONWOOD CIR; CAMPBELL RESIDENCE\n" +
        "MV6E\n" +
        "2206\n" +
        "STN 6 AND 2226.  GENERAL FIRE ALARM AND SMOKE DETECTOR.\n" +
        "BOULDER ADVISING TO CANCEL.  PROPER CODES",

        "CODE:ALARMFR",
        "CALL:FIRE ALARM RESIDENTIAL",
        "ADDR:2758 IRONWOOD CIR",
        "PLACE:CAMPBELL RESIDENCE",
        "SRC:MV6E",
        "UNIT:2206",
        "INFO:STN 6 AND 2226.  GENERAL FIRE ALARM AND SMOKE DETECTOR. / BOULDER ADVISING TO CANCEL.  PROPER CODES");

    doTest("T7",
        "(Dispatch) 22\n" +
        "SI\n" +
        "D\n" +
        "659 GRIMSON PL\n" +
        "MV6E\n" +
        "2206\n" +
        "ProQA Medical Case 10112 Aborted\\2son radio\n" +
        "ProQA Medical Returned Error 39\\2sCase already on file - Call ID 10112",

        "CODE:SI",
        "CALL:SICK AND INJURED FIRE/EMS",
        "ADDR:659 GRIMSON PL",
        "SRC:MV6E",
        "UNIT:2206",
        "INFO:ProQA Medical Case 10112 Aborted\\2son radio / ProQA Medical Returned Error 39\\2sCase already on file - Call ID 10112");

  }
  
  public static void  main(String[] args) {
    new COWeldCountyParserTest().generateTests("T1");
  }
}