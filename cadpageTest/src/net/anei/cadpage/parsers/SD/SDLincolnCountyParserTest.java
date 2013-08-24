package net.anei.cadpage.parsers.SD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Lincoln County, SD
Contact: James Dietz <kc0usq@gmail.com>
Sender: no-reply@ledsportal.com
System: LEDS

Subject:12-10952 - SIG1 : Injury Accident\nI-29 MM 64 \r\nPlease respond immediately. Roll over 6pts. I-29 nb south of the 64mm.\r
Subject:12-10680 -\n48548 480TH AVE, Canton \r\nPlease respond immediately. Diabetic emergency\r
Subject:AMB : Ambulance Call\n307 E Jefferson St # 7, Inwood eld male who has fallen\r
Subject:12-10682 -\n903 W 5th. st #3, ca \r\nPlease respond immediately. 60 yo. f fallen and hit head.\r
Subject:AMB : Ambulance Call\nI-29 NB at 59 MM59 MM I-29 27 YOM with severe back pain\r
Subject:AMB : Ambulance Call\n501 S MAPLE ST, Inwood female had a baby 1 week ago passing clots\r
Subject:AMB : Ambulance Call\n1022 N DAKOTA ST, CANTON, SD Non-ER transfer to Avera ER for behavioral evaluation\r
Subject:Mutual Aid for Field and Hay Baler Fire\n48259 289th St\r\nPlease respond immediately.\r
Subject:12-11731 -\n1947 250th St - M pt Fall Victim.  Please respond immediately.\r
Subject:12-11722 - AMB : Ambulance Call\n519 S BARTLETT ST, CANTON, SD \r\nPlease respond immediately. 82 Yo. f poss dehydrated\r
Subject:12-11690 - AMB : Ambulance Call\nSanford Canton-Inwood Hospital 14 y/o F pt - Head Injury\r\nPlease respond immediately.\r
Subject:12-11612 - AMB : Ambulance Call\nCanton Good Samaritan Society \r\nPlease respond immediately.  98yo.f diff. breathing\r
Subject:{12-12835} - {injury accident\n{gravel road between Inwood and Canton} \r\nPlease respond immediately.\r
Subject:INJURY ACCIDENT\n480TH & 289TH - 1 FEMALE WITH UNKNOWN INJURY\r
(12-15330 - AMB : Ambulance Call) 204 S BROADWAY ST, Canton, SD 57013 \r\nPlease respond immediately. fell, and can not catch his breath.
(12-15176) 115 N MILWAUKEE ST, CANTON, SD 83 y/o F pt - Fall Victim\r\nPlease respond immediately.
(12-15072 - AMB : Ambulance Call) 440 N HIAWATHA DR, CANTON, SD 82 y/o F pt - GI Bleed - Please respond immediately.
(12-14996 - AMB : Ambulance Call) 908 Angel Ln, Canton, SD 57013 \r\nPlease respond immediately. Medic Alert.
(12-15941 - AMB : Ambulance Call) 47926 275TH ST Elderly M pt - Poss Stroke.  Please respond immediately.
27527 481st ave, for adult male diabetic, has had siezure and is now unresponsive
(224 W 3RD ST) PD REQUEST CODE 1 FOR STAND BY
(212 N MAIN ST, INWOOD, IA) FEMALE - CHEST PAIN

Contact: James Dietz <kc0usq@gmail.com>
Sender: no-reply@ledsportal.com
(13-00330 - AMB : Ambulance Call) 503 E POPLAR DR, # 111, CANTON, SD 57013 Lift Assist.  Please respond immediately. [Attachment(s) removed]
(227 S JOHNSON) MALE - DIFFICULTY BREATHING [Attachment(s) removed]
(13-04979 - AMB : Ambulance Call1 call rollover) +43.301044, -096.643700 \nPlease respond immediately.\n18/west of 11\n2 patients back and neck injuries

Contact: James Dietz <kc0usq@gmail.com>
Sender: no-reply@ledsportal.com
(83 Y/O Female not feeling well Diff breathing) 519 S Bartlett\nPlease respond immediately. [Attachment(s) removed]
(20 Y/O Female stomach and back pain) 28106 472nd Ave\nPlease respond immediately. [Attachment(s) removed]
(AMB : Ambulance Call MEDICAL) I-29 and hwy 18, Canton EX 62 FOR ADULT FEMALE UNRESPONSIVE [Attachment(s) removed]
(210 N LAWLER) 17 Y/O MALE IN A HALO, BLEEDING NEAR HALO [Attachment(s) removed]
(310 e elder) 310 e elder vehicle fire [Attachment(s) removed]
(509 W 5th Caseys) Male fell head and knee pain\nPlease respond immediately. [Attachment(s) removed]
(13-08212 - AMB : Ambulance Call) Casey's General Store - Canton \nPlease respond immediately. 50 yo. m. Fallen complaining of knee pain.
(HWY 18 & HWY 11) SICK FEMALE IN A CAR. [Attachment(s) removed]

Contact: nathan laubach  <wyturtle@hotmail.com>
Sender: no-reply@ledsportal.com
(SIG1 : Injury Accident SIGNAL 1) 115 / 276TH ST SIGNAL 1 INJURY ACCIDENT UNKNOWN INJURIES [Attachment(s) removed]

** Parser failures **
Subject:dehydration\n519 s bartlett 18 yo female dehyrated, please respond\r
Subject:12-11706 - AMB : Ambulance Call\n420 S. Dakota, c \r\nPlease respond immediately. 36 yo. m passed out.\r
Subject:ambulance call\ncanton in wood 65yo male needs transport to Sanford with GI bleeding\r
Subject:MEDICAL @ KEYSTONE\nMALE IN 50'S - CHEST PAIN\r
(TS : Traffic Enforcement MEDICAL) Intersection of 271 and 469 ADULT MALE INSULIN SHOCK [Attachment(s) removed]
(AMB : Ambulance Call) Adams Thermal Systems Inc in office for patient with chest pains [Attachment(s) removed]
(US HWY 18 AND HAIWATHA) US HIWGHWAY 18 AND HAIWATHA = POSSIBLE DROWNIG VICTIM [Attachment(s) removed]

*/

public class SDLincolnCountyParserTest extends BaseParserTest {
  
  public SDLincolnCountyParserTest() {
    setParser(new SDLincolnCountyParser(), "LINCOLN COUNTY", "SD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:12-10952 - SIG1 : Injury Accident\nI-29 MM 64 \r\nPlease respond immediately. Roll over 6pts. I-29 nb south of the 64mm.\r",
        "ID:12-10952",
        "CALL:SIG1 : Injury Accident",
        "ADDR:I-29 MM 64",
        "MADDR:I 29 MM 64",
        "INFO:Roll over 6pts. I-29 nb south of the 64mm.");

    doTest("T2",
        "Subject:12-10680 -\n48548 480TH AVE, Canton \r\nPlease respond immediately. Diabetic emergency\r",
        "ID:12-10680",
        "CALL:ALERT",
        "ADDR:48548 480TH AVE",
        "CITY:Canton",
        "INFO:Diabetic emergency");

    doTest("T3",
        "Subject:AMB : Ambulance Call\n307 E Jefferson St # 7, Inwood eld male who has fallen\r",
        "CALL:AMB : Ambulance Call",
        "ADDR:307 E Jefferson St",
        "APT:7",
        "CITY:Inwood",
        "ST:IA",
        "INFO:eld male who has fallen");

    doTest("T4",
        "Subject:12-10682 -\n903 W 5th. st #3, ca \r\nPlease respond immediately. 60 yo. f fallen and hit head.\r",
        "ID:12-10682",
        "CALL:ALERT",
        "ADDR:903 W 5th st",
        "APT:3",
        "CITY:CANTON",
        "INFO:60 yo. f fallen and hit head.");

    doTest("T5",
        "Subject:AMB : Ambulance Call\nI-29 NB at 59 MM59 MM I-29 27 YOM with severe back pain\r",
        "CALL:AMB : Ambulance Call",
        "ADDR:I-29 NB",
        "MADDR:I 29",
        "INFO:at 59 MM59 MM I-29 27 YOM with severe back pain");

    doTest("T6",
        "Subject:AMB : Ambulance Call\n501 S MAPLE ST, Inwood female had a baby 1 week ago passing clots\r",
        "CALL:AMB : Ambulance Call",
        "ADDR:501 S MAPLE ST",
        "CITY:Inwood",
        "ST:IA",
        "INFO:female had a baby 1 week ago passing clots");

    doTest("T7",
        "Subject:AMB : Ambulance Call\n1022 N DAKOTA ST, CANTON, SD Non-ER transfer to Avera ER for behavioral evaluation\r",
        "CALL:AMB : Ambulance Call",
        "ADDR:1022 N DAKOTA ST",
        "CITY:CANTON",
        "ST:SD",
        "INFO:Non-ER transfer to Avera ER for behavioral evaluation");

    doTest("T8",
        "Subject:Mutual Aid for Field and Hay Baler Fire\n48259 289th St\r\nPlease respond immediately.\r",
        "CALL:Mutual Aid for Field and Hay Baler Fire",
        "ADDR:48259 289th St");

    doTest("T9",
        "Subject:12-11731 -\n1947 250th St - M pt Fall Victim.  Please respond immediately.\r",
        "ID:12-11731",
        "CALL:ALERT",
        "ADDR:1947 250th St",
        "INFO:M pt Fall Victim.");

    doTest("T10",
        "Subject:12-11722 - AMB : Ambulance Call\n519 S BARTLETT ST, CANTON, SD \r\nPlease respond immediately. 82 Yo. f poss dehydrated\r",
        "ID:12-11722",
        "CALL:AMB : Ambulance Call",
        "ADDR:519 S BARTLETT ST",
        "CITY:CANTON",
        "ST:SD",
        "INFO:82 Yo. f poss dehydrated");

    doTest("T11",
        "Subject:12-11690 - AMB : Ambulance Call\nSanford Canton-Inwood Hospital 14 y/o F pt - Head Injury\r\nPlease respond immediately.\r",
        "ID:12-11690",
        "CALL:AMB : Ambulance Call",
        "ADDR:Sanford Canton-Inwood Hospital 14 y & o F pt - Head Injury");

    doTest("T12",
        "Subject:12-11612 - AMB : Ambulance Call\nCanton Good Samaritan Society \r\nPlease respond immediately.  98yo.f diff. breathing\r",
        "ID:12-11612",
        "CALL:AMB : Ambulance Call",
        "ADDR:Canton Good Samaritan Society",
        "INFO:98yo.f diff. breathing");

    doTest("T13",
        "Subject:{12-12835} - {injury accident\n{gravel road between Inwood and Canton} \r\nPlease respond immediately.\r",
        "ID:12-12835",
        "CALL:injury accident",
        "ADDR:gravel road between Inwood and Canton",
        "MADDR:gravel road between Inwood & Canton");

    doTest("T14",
        "Subject:INJURY ACCIDENT\n480TH & 289TH - 1 FEMALE WITH UNKNOWN INJURY\r",
        "CALL:INJURY ACCIDENT",
        "ADDR:480TH & 289TH",
        "INFO:1 FEMALE WITH UNKNOWN INJURY");

    doTest("T15",
        "(12-15330 - AMB : Ambulance Call) 204 S BROADWAY ST, Canton, SD 57013 \r\n" +
        "Please respond immediately. fell, and can not catch his breath.",

        "ID:12-15330",
        "CALL:AMB : Ambulance Call",
        "ADDR:204 S BROADWAY ST",
        "CITY:Canton",
        "ST:SD",
        "INFO:fell, and can not catch his breath.");

    doTest("T16",
        "(12-15176) 115 N MILWAUKEE ST, CANTON, SD 83 y/o F pt - Fall Victim\r\nPlease respond immediately.",
        "ID:12-15176",
        "CALL:ALERT",
        "ADDR:115 N MILWAUKEE ST",
        "CITY:CANTON",
        "ST:SD",
        "INFO:83 y/o F pt - Fall Victim");

    doTest("T17",
        "(12-15072 - AMB : Ambulance Call) 440 N HIAWATHA DR, CANTON, SD 82 y/o F pt - GI Bleed - Please respond immediately.",
        "ID:12-15072",
        "CALL:AMB : Ambulance Call",
        "ADDR:440 N HIAWATHA DR",
        "CITY:CANTON",
        "ST:SD",
        "INFO:82 y/o F pt / GI Bleed -");

    doTest("T18",
        "(12-14996 - AMB : Ambulance Call) 908 Angel Ln, Canton, SD 57013 \r\nPlease respond immediately. Medic Alert.",
        "ID:12-14996",
        "CALL:AMB : Ambulance Call",
        "ADDR:908 Angel Ln",
        "CITY:Canton",
        "ST:SD",
        "INFO:Medic Alert.");

    doTest("T19",
        "(12-15941 - AMB : Ambulance Call) 47926 275TH ST Elderly M pt - Poss Stroke.  Please respond immediately.",
        "ID:12-15941",
        "CALL:AMB : Ambulance Call",
        "ADDR:47926 275TH ST",
        "INFO:Elderly M pt - Poss Stroke.");

    doTest("T20",
        "(224 W 3RD ST) PD REQUEST CODE 1 FOR STAND BY",
        "CALL:PD REQUEST CODE 1 FOR STAND BY",
        "ADDR:224 W 3RD ST");

    doTest("T21",
        "(212 N MAIN ST, INWOOD, IA) FEMALE - CHEST PAIN",
        "ADDR:212 N MAIN ST",
        "CITY:INWOOD",
        "ST:IA",
        "CALL:FEMALE - CHEST PAIN");

  }
  
  @Test
  public void testJamesDietz() {

    doTest("T1",
        "(13-00330 - AMB : Ambulance Call) 503 E POPLAR DR, # 111, CANTON, SD 57013 Lift Assist.  Please respond immediately. [Attachment(s) removed]",
        "ID:13-00330",
        "CALL:AMB : Ambulance Call",
        "ADDR:503 E POPLAR DR",
        "APT:111",
        "CITY:CANTON",
        "ST:SD",
        "INFO:Lift Assist.");

    doTest("T2",
        "(227 S JOHNSON) MALE - DIFFICULTY BREATHING [Attachment(s) removed]",
        "CALL:MALE - DIFFICULTY BREATHING",
        "ADDR:227 S JOHNSON");

    doTest("T3",
        "(AMB : Ambulance Call MEDICAL) I-29 and hwy 18, Canton EX 62 FOR ADULT FEMALE UNRESPONSIVE [Attachment(s) removed]",
        "CALL:AMB : Ambulance Call MEDICAL",
        "ADDR:I-29 and hwy 18",
        "MADDR:I 29 & hwy 18",
        "CITY:Canton",
        "INFO:EX 62 FOR ADULT FEMALE UNRESPONSIVE");

    doTest("T4",
        "(210 N LAWLER) 17 Y/O MALE IN A HALO, BLEEDING NEAR HALO [Attachment(s) removed]",
        "CALL:17 Y/O MALE IN A HALO, BLEEDING NEAR HALO",
        "ADDR:210 N LAWLER");

    doTest("T5",
        "(310 e elder) 310 e elder vehicle fire [Attachment(s) removed]",
        "CALL:310 e elder vehicle fire",
        "ADDR:310 e elder");

    doTest("T6",
        "(509 W 5th Caseys) Male fell head and knee pain\nPlease respond immediately. [Attachment(s) removed]",
        "CALL:Male fell head and knee pain\nPlease respond immediately.",
        "ADDR:509 W 5th Caseys");

    doTest("T7",
        "(13-08212 - AMB : Ambulance Call) Casey's General Store - Canton \n" +
        "Please respond immediately. 50 yo. m. Fallen complaining of knee pain.",

        "ID:13-08212",
        "CALL:AMB : Ambulance Call",
        "ADDR:Casey's General Store -",
        "CITY:Canton",
        "INFO:50 yo. m. Fallen complaining of knee pain.");

    doTest("T8",
        "(HWY 18 & HWY 11) SICK FEMALE IN A CAR. [Attachment(s) removed]",
        "CALL:SICK FEMALE IN A CAR.",
        "ADDR:HWY 18 & HWY 11");

  }
  
  @Test
  public void testJamesDietz2() {

    doTest("T1",
        "(83 Y/O Female not feeling well Diff breathing) 519 S Bartlett\nPlease respond immediately. [Attachment(s) removed]",
        "CALL:83 Y/O Female not feeling well Diff breathing",
        "ADDR:519 S Bartlett");

    doTest("T2",
        "(20 Y/O Female stomach and back pain) 28106 472nd Ave\nPlease respond immediately. [Attachment(s) removed]",
        "CALL:20 Y/O Female stomach and back pain",
        "ADDR:28106 472nd Ave");
    
  }
  
  @Test
  public void testNathanLaubach() {

    doTest("T1",
        "(SIG1 : Injury Accident SIGNAL 1) 115 / 276TH ST SIGNAL 1 INJURY ACCIDENT UNKNOWN INJURIES [Attachment(s) removed]",
        "CALL:SIG1 : Injury Accident SIGNAL 1",
        "ADDR:115 & 276TH ST",
        "INFO:SIGNAL 1 INJURY ACCIDENT UNKNOWN INJURIES");
  
  }
  
  public static void main(String[] args) {
    new SDLincolnCountyParserTest().generateTests("T1");
  }
}