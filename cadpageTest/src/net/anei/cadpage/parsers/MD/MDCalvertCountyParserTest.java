package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*    
Calvert County, MD
Contact: michael smith <lee020988@gmail.com>, 4436247957@vtext.com
Sender: dispatch@co.cal.md.us

M Priority 3 Medical  00:02 03/12/11 8536 BAYSIDE RD CHESAPEAKE BEACH 2011-00000445 CO1 abdom. pain
R Auto Accident Serious S5 R1 A59 A19 M102  21:41 03/11/11 W CHESAPEAKE BEACH RD DUNKIRK 2011-00016920  entrapment  a truck hit a another car
F Local Box E12  19:23 03/10/11 3741 3RD ST NORTH BEACH 2011-00000438  NEIGHBORS ARE TRYING TO APPROACH IT. THERE IS A CAR UNDER THE TREE, IT
M Priority 2 Medical A19 M102  17:19 03/10/11 950 E  MT HARMONY RD OWINGS 2011-00000435  ProQA Medical Key Questions have been completed; Disp Dispatch Code:
F Fire Alarm E11 E51 T1  16:30 03/10/11 1850 PROSPER LN OWINGS 2011-00000433 SNEADES ACE-OW ProQA Fire Questionnaire Completed;
F Area Box E61 E21 E52 E11 TN5 TN7 T2 S6 A68 NDC  17:52 03/09/11 65 WALTON RD HUNTINGTOWN 2011-00000443  ProQA Fire Questionnaire Completed; D 
M Priority 2 Medical A19 NOMED  10:45 03/09/11 8818 CHESAPEAKE LIGHTHOUSE DR NORTH BEACH 2011-00000428  ProQA Medical Questionnaire Completed;

New text format
Contact: Marcus Richman <richmanmh@gmail.com>
(Dispatch Info) M Priority 3 Medical A79  11:44 03/22/11 Box 303 12680 HG TRUEMAN RD LUSBY 2011-00000525 SCHOOL-DOW ES ProQA Medical Questionnaire Completed;

Contact: Kevin Harness <kay.kh32@gmail.com>
(Dispatch Info) M Priority 1 Medical E33 A38 SMA796 M105  11:20 04/18/11 Box 302 1105 BACK CREEK LOOP SOLOMONS

Contact: Steve Nero <steve21800@gmail.com>
(Dispatch Info) M Priority 3 Medical A37  16:52 04/24/11 Box 302 11740 ASBURY CIR SOLOMONS ASBURY APTS-SOUT

Contact: Josh Paiva <jp58709@gmail.com>
(Dispatch Info) M Priority 1 Medical E33 A37 SMA796 M105  19:25 05/09/11 Box 301 14575 S  SOLOMONS ISLAND RD SOLOMONS Sol Pie

Contact: Active911
Agency name: Solomons Volunteer Rescue Squad  Fire Dept
Location: Solomons, MD, United States
Sender: dispatch@co.cal.md.us

(Dispatch Info) M Priority 3 Medical A39  18:23 10/20/12 Box 302 11740 ASBURY CIR SOLOMONS ASBURY APTS-SOUTH Problem: fall.  Patient Info: 1 patient(s); 89 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Questionnaire Completed; Dispatch Code: 17-A-01  female, who is conscious and breathing. NOT DANGEROUS body area.  ProQA Medical Dispatch Message Sent; Dispatch Code: 17-A-01  You are responding to a patient involved in a fall.  The patient is a 89-year-old  female, who is conscious and breathing. NOT DANGEROUS body area.  Falls.  Caller Statement: fall.  1.This happened now (less than 6hrs ago).  2.It's reported that she fell at ground level.  3.The fall was accidental.  4.There is some bleeding, not serious.  5.She is completely alert (responding appropriately).  6.The injury is to a NOT DANGEROUS area.  7.She is no longer on the floor (ground).  Problem: fall.  Patient Info: 1 patient(s); 89 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1722094 \r\n\r\n
(Dispatch Info) F Service Call  17:33 10/20/12 Box 308 10210 HG TRUEMAN RD LUSBY CHURCH-MIDDLEHAM CHAPEL standy by during the hay ride \r\n\r\n
(Dispatch Info) M Priority 3 Medical  16:10 10/20/12 Box 206 4755 HALLOWING POINT RD PRINCE FREDERICK HP PK NO HEAD INJURY  12 YOM  ARM INJURY AT FIELD 12  POSSIBLY DANGEROUS body area.  ProQA Medical Questionnaire Completed; Dispatch Code: 30-B-01  Problem: HEAD INJURY.  Patient Info: 1 patient(s); 12 Years old; Male; Conscious: Yes; Breathing: Yes;  You are responding to a patient with specifically identified traumatic injuries.  The patient is a 12-year-old male, who is conscious and breathing.  POSSIBLY DANGEROUS body area.  Traumatic Injuries (Specific).  Caller Statement: HEAD INJURY.  1.This happened now (less than 6hrs ago).  2.There is no bleeding now.  3.He is completely alert (responding appropriately).  4.The injury is to the head.  ProQA Medical Dispatch Message Sent; Dispatch Code: 30-B-01  Problem: HEAD INJURY.  Patient Info: 1 patient(s); 12 Years old; Male; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1722070 \r\n\r\n
(Dispatch Info) M Priority 3 Medical A39  15:21 10/20/12 Box 308 9923 HG TRUEMAN RD LUSBY  ProQA Medical Questionnaire Completed; Dispatch Code: 26-A-01  priority symptoms (complaint conditions 2-11 not identified).  Problem: kidney bag lose.  Patient Info: 1 patient(s); 65 Years old; Male; Conscious: Yes; Breathing: Yes;  You are responding to a patient who is sick (or has a current medical condition).  The patient is a 65-year-old male, who is conscious and breathing. No  priority symptoms (complaint conditions 2-11 not identified).  Sick Person (Specific Diagnosis).  No priority symptoms (complaint conditions 2-11 not identified).  Caller Statement: kidney bag lose.  1.He is completely alert (responding appropriately).  2.He is breathing normally.  3.He has other pain.  4.He is not bleeding (or vomiting blood).  5.No priority symptoms (ALPHA conditions 2-11 not identified).  6.No priority symptoms (OMEGA conditions 2-28 not identified).  Problem: kidney bag lose.  Patient Info: 1 patient(s); 65 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 26-A-01  kidney bag came lose 65yom  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1722055 \r\n\r\n
(Dispatch Info) R Auto Accident Injury R3 A39 A79  13:00 10/20/12 Box 310 CORDOVA LN LUSBY  11.Everyone is being cooperative.  12.It is not known if alcohol or drugs are involved.  13.The vehicle description is:  14.The exact location of the vehicle(s) is: intersection  15.It is not known if any other property is damaged besides the vehicle(s).-Comments: intersection-  ProQA Police Key Questions have been completed; Dispatch Code: 131-C-01B  subaru suv - ford focus.. 2 vehs at intersection  ProQA Police Dispatch Message Sent; Dispatch Code: 131-C-01B  Traffic / Transportation Accident (Crash).TRAFFIC ACCIDENT (unknown injury)  (Blocking traffic). Caller Statement: accident.  1.The caller is not on scene.  2.This incident just occurred.  3.This incident involves a TRAFFIC ACCIDENT.  4.It is not known if anyone is injured.  5.It is not known if anyone is pinned (trapped) in the vehicle(s).  6.No one was thrown from the vehicle(s).  7.It is not known if there are hazardous materials involved.  8.There are items blocking or slowing the flow of traffic: vehs  9.More than one vehicle is involved: 2  10.All drivers are still on scene.-Comments: vehs--Comments: 2-  New ProQA Police Case Number has been assigned; Dispatch Code: --: -1722025 \r\n\r\n
(Dispatch Info) M Priority 3 Medical A39  01:06 10/20/12 Box 303 11840 CLIFTON DR LUSBY  ProQA Medical Questionnaire Completed; Dispatch Code: 28-C-03H  problems  (Strong evidence of stroke (=> X hours)).  Problem: mom poss cva.  Patient Info: 1 patient(s); 93 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 28-C-03H  You are responding to a patient who has apparently suffered a stroke.  The patient  is a 93-year-old female, who is conscious and breathing. Sudden speech  problems  (Strong evidence of stroke (=> X hours)).  Stroke (CVA).  Sudden speech problems  (Strong evidence of stroke (=> X hours)).  Caller Statement: mom poss cva.  1.She is completely alert (responding appropriately).  2.She is breathing normally.  3.She is having sudden speech problems.  4.The Stroke Diagnostic results indicate strong evidence of stroke.  5.These symptoms (problem) started: this morning  6.She has not had a STROKE before.  -Stroke Diagnostic:Tool Predictive Value: Strong evidence of stroke (2,2,4)-  -Comments: this morning-  Problem: mom poss cva.  Patient Info: 1 patient(s); 93 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1721916  E911 Info - Class of Service: RESD Special Response Info: PRIMARY PSAP: BOX 303 \r\n\r\n
(Dispatch Info) M Priority 3 Medical A39  20:15 10/19/12 23220 SURREY WAY ST MARYS  medical box 902 at 23220 surrey way apt g chest pains... ac03 \r\n\r\n
(Dispatch Info) F Service Call  18:45 10/19/12 Box 305  12485 SOUTHERN CONNECTOR BLVD LUSBY SCHOOL-PAT HS football game standby \r\n\r\n
(Dispatch Info) M Priority 2 Medical A39 SMA388 M102  14:31 10/19/12 Box 302 13962 HG TRUEMAN RD SOLOMONS JERRYS SUBS-SOL THE MALE WOULD LIEK TO RIDE WITH THE AMB HE IF CAN  23 YOF OUTSIDE VOMITING BLOOD W CHEST PAINS  PAT PLAZA  Problem: vomiting blood.  Patient Info: 1 patient(s); 23 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Questionnaire Completed; Dispatch Code: 10-A-01  female, who is conscious and breathing. Breathing normally < 35.  You are responding to a patient with chest pain.  The patient is a 23-year-old  female, who is conscious and breathing. Breathing normally < 35.  Chest Pain (Non-Traumatic).  Caller Statement: vomiting blood.  1.She is completely alert (responding appropriately).  2.She is breathing normally.  ^    3.She has chest pain. (Change from Protocol #26)  4.She is completely alert (responding appropriately).  5.She is breathing normally.  6.She is not changing color.  7.She is not clammy.  8.She has not had a heart attack or angina (heart pains) before.  9.She did not take any drugs (medications) in the past 12hrs.  Problem: vomiting blood.  Patient Info: 1 patient(s); 23 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 10-A-01  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1721766 \r\n\r\n
(Dispatch Info) M Priority 3 Medical A39  11:44 10/19/12 Box 311 11812 ARROW HEAD TRL LUSBY  You are responding to a patient who is hemorrhaging.  The patient is a  87-year-old male, who is conscious and breathing. NOT DANGEROUS  hemorrhage.  Hemorrhage / Lacerations.  NOT DANGEROUS hemorrhage.  Caller Statement: BED SORE ON HEAL.  1.The cause of the bleeding is non-traumatic.  2.The bleeding is from a NOT DANGEROUS area.  3.He is completely alert (responding appropriately).  4.He is breathing normally.  5.There is no SERIOUS bleeding.  6.He does not have a bleeding disorder or is taking blood thinners.  ProQA Medical Dispatch Message Sent; Dispatch Code: 21-A-01  Problem: BED SORE ON HEAL.  Patient Info: 1 patient(s); 87 Years old; Male; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1721716  BED SORE ON HEEL THAT IS INFECTED  E911 Info - Class of Service: VOIP Special Response Info: VERIFY PD                       VERIFY FD                       VERIFY EMS \r\n\r\n

*/

public class MDCalvertCountyParserTest extends BaseParserTest {
  
  public MDCalvertCountyParserTest() {
    setParser(new MDCalvertCountyParser(), "CALVERT COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "M Priority 3 Medical  00:02 03/12/11 8536 BAYSIDE RD CHESAPEAKE BEACH 2011-00000445 CO1 abdom. pain",
        "TIME:00:02",
        "DATE:03/12/11",
        "CALL:M Priority 3 Medical",
        "ADDR:8536 BAYSIDE RD",
        "CITY:CHESAPEAKE BEACH",
        "ID:2011-00000445",
        "INFO:CO1 abdom. pain");

    doTest("T2",
        "R Auto Accident Serious S5 R1 A59 A19 M102  21:41 03/11/11 W CHESAPEAKE BEACH RD DUNKIRK 2011-00016920  entrapment  a truck hit a another car",
        "TIME:21:41",
        "DATE:03/11/11",
        "CALL:R Auto Accident Serious",
        "UNIT:S5 R1 A59 A19 M102",
        "ADDR:W CHESAPEAKE BEACH RD",
        "CITY:DUNKIRK",
        "ID:2011-00016920",
        "INFO:entrapment  a truck hit a another car");

    doTest("T3",
        "F Local Box E12  19:23 03/10/11 3741 3RD ST NORTH BEACH 2011-00000438  NEIGHBORS ARE TRYING TO APPROACH IT. THERE IS A CAR UNDER THE TREE, IT",
        "TIME:19:23",
        "DATE:03/10/11",
        "CALL:F Local Box",
        "UNIT:E12",
        "ADDR:3741 3RD ST",
        "CITY:NORTH BEACH",
        "ID:2011-00000438",
        "INFO:NEIGHBORS ARE TRYING TO APPROACH IT. THERE IS A CAR UNDER THE TREE, IT");

    doTest("T4",
        "M Priority 2 Medical A19 M102  17:19 03/10/11 950 E  MT HARMONY RD OWINGS 2011-00000435  ProQA Medical Key Questions have been completed; Disp Dispatch Code:",
        "TIME:17:19",
        "DATE:03/10/11",
        "CALL:M Priority 2 Medical",
        "UNIT:A19 M102",
        "ADDR:950 E MT HARMONY RD",
        "CITY:OWINGS",
        "ID:2011-00000435",
        "INFO:ProQA Medical Key Questions have been completed; Disp Dispatch Code:");

    doTest("T5",
        "F Fire Alarm E11 E51 T1  16:30 03/10/11 1850 PROSPER LN OWINGS 2011-00000433 SNEADES ACE-OW ProQA Fire Questionnaire Completed;",
        "TIME:16:30",
        "DATE:03/10/11",
        "CALL:F Fire Alarm",
        "UNIT:E11 E51 T1",
        "ADDR:1850 PROSPER LN",
        "CITY:OWINGS",
        "ID:2011-00000433",
        "INFO:SNEADES ACE-OW ProQA Fire Questionnaire Completed;");

    doTest("T6",
        "F Area Box E61 E21 E52 E11 TN5 TN7 T2 S6 A68 NDC  17:52 03/09/11 65 WALTON RD HUNTINGTOWN 2011-00000443  ProQA Fire Questionnaire Completed; D ",
        "TIME:17:52",
        "DATE:03/09/11",
        "CALL:F Area Box",
        "UNIT:E61 E21 E52 E11 TN5 TN7 T2 S6 A68 NDC",
        "ADDR:65 WALTON RD",
        "CITY:HUNTINGTOWN",
        "ID:2011-00000443",
        "INFO:ProQA Fire Questionnaire Completed; D");

    doTest("T7",
        "M Priority 2 Medical A19 NOMED  10:45 03/09/11 8818 CHESAPEAKE LIGHTHOUSE DR NORTH BEACH 2011-00000428  ProQA Medical Questionnaire Completed;",
        "TIME:10:45",
        "DATE:03/09/11",
        "CALL:M Priority 2 Medical",
        "UNIT:A19 NOMED",
        "ADDR:8818 CHESAPEAKE LIGHTHOUSE DR",
        "CITY:NORTH BEACH",
        "ID:2011-00000428",
        "INFO:ProQA Medical Questionnaire Completed;");

    doTest("T8",
        "(Dispatch Info) M Priority 3 Medical A79  11:44 03/22/11 Box 303 12680 HG TRUEMAN RD LUSBY 2011-00000525 SCHOOL-DOW ES ProQA Medical Questionnaire Completed;",
        "TIME:11:44",
        "DATE:03/22/11",
        "CALL:M Priority 3 Medical",
        "UNIT:A79",
        "BOX:303",
        "ADDR:12680 HG TRUEMAN RD",
        "CITY:LUSBY",
        "ID:2011-00000525",
        "INFO:SCHOOL-DOW ES ProQA Medical Questionnaire Completed;");

    doTest("T9",
        "(Dispatch Info) M Priority 1 Medical E33 A38 SMA796 M105  11:20 04/18/11 Box 302 1105 BACK CREEK LOOP SOLOMONS",
        "TIME:11:20",
        "DATE:04/18/11",
        "CALL:M Priority 1 Medical",
        "UNIT:E33 A38 SMA796 M105",
        "BOX:302",
        "ADDR:1105 BACK CREEK LOOP",
        "CITY:SOLOMONS");

    doTest("T10",
        "(Dispatch Info) M Priority 3 Medical A37  16:52 04/24/11 Box 302 11740 ASBURY CIR SOLOMONS ASBURY APTS-SOUT",
        "TIME:16:52",
        "DATE:04/24/11",
        "CALL:M Priority 3 Medical",
        "UNIT:A37",
        "BOX:302",
        "ADDR:11740 ASBURY CIR",
        "PLACE:ASBURY APTS-SOUT",
        "CITY:SOLOMONS");

    doTest("T11",
        "(Dispatch Info) M Priority 1 Medical E33 A37 SMA796 M105  19:25 05/09/11 Box 301 14575 S  SOLOMONS ISLAND RD SOLOMONS Sol Pie",
        "TIME:19:25",
        "DATE:05/09/11",
        "CALL:M Priority 1 Medical",
        "UNIT:E33 A37 SMA796 M105",
        "BOX:301",
        "ADDR:14575 S SOLOMONS ISLAND RD",
        "PLACE:Sol Pie",
        "CITY:SOLOMONS");
  }
  
  @Test
  public void testSolomonFire() {

    doTest("T1",
        "(Dispatch Info) M Priority 3 Medical A39  18:23 10/20/12 Box 302 11740 ASBURY CIR SOLOMONS ASBURY APTS-SOUTH Problem: fall.  Patient Info: 1 patient(s); 89 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Questionnaire Completed; Dispatch Code: 17-A-01  female, who is conscious and breathing. NOT DANGEROUS body area.  ProQA Medical Dispatch Message Sent; Dispatch Code: 17-A-01  You are responding to a patient involved in a fall.  The patient is a 89-year-old  female, who is conscious and breathing. NOT DANGEROUS body area.  Falls.  Caller Statement: fall.  1.This happened now (less than 6hrs ago).  2.It's reported that she fell at ground level.  3.The fall was accidental.  4.There is some bleeding, not serious.  5.She is completely alert (responding appropriately).  6.The injury is to a NOT DANGEROUS area.  7.She is no longer on the floor (ground).  Problem: fall.  Patient Info: 1 patient(s); 89 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1722094 \r\n" +
        "\r\n",

        "TIME:18:23",
        "DATE:10/20/12",
        "CALL:M Priority 3 Medical",
        "UNIT:A39",
        "BOX:302",
        "ADDR:11740 ASBURY CIR",
        "PLACE:ASBURY APTS-SOUTH",
        "CITY:SOLOMONS",
        "INFO:Problem: fall.  Patient Info: 1 patient(s); 89 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Questionnaire Completed; Dispatch Code: 17-A-01  female, who is conscious and breathing. NOT DANGEROUS body area.  ProQA Medical Dispatch Message Sent; Dispatch Code: 17-A-01  You are responding to a patient involved in a fall.  The patient is a 89-year-old  female, who is conscious and breathing. NOT DANGEROUS body area.  Falls.  Caller Statement: fall.  1.This happened now (less than 6hrs ago).  2.It's reported that she fell at ground level.  3.The fall was accidental.  4.There is some bleeding, not serious.  5.She is completely alert (responding appropriately).  6.The injury is to a NOT DANGEROUS area.  7.She is no longer on the floor (ground).  Problem: fall.  Patient Info: 1 patient(s); 89 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1722094");

    doTest("T2",
        "(Dispatch Info) F Service Call  17:33 10/20/12 Box 308 10210 HG TRUEMAN RD LUSBY CHURCH-MIDDLEHAM CHAPEL standy by during the hay ride \r\n" +
        "\r\n",

        "TIME:17:33",
        "DATE:10/20/12",
        "CALL:F Service Call",
        "BOX:308",
        "ADDR:10210 HG TRUEMAN RD",
        "PLACE:CHURCH-MIDDLEHAM CHAPEL",
        "CITY:LUSBY",
        "INFO:standy by during the hay ride");

    doTest("T3",
        "(Dispatch Info) M Priority 3 Medical  16:10 10/20/12 Box 206 4755 HALLOWING POINT RD PRINCE FREDERICK HP PK NO HEAD INJURY  12 YOM  ARM INJURY AT FIELD 12  POSSIBLY DANGEROUS body area.  ProQA Medical Questionnaire Completed; Dispatch Code: 30-B-01  Problem: HEAD INJURY.  Patient Info: 1 patient(s); 12 Years old; Male; Conscious: Yes; Breathing: Yes;  You are responding to a patient with specifically identified traumatic injuries.  The patient is a 12-year-old male, who is conscious and breathing.  POSSIBLY DANGEROUS body area.  Traumatic Injuries (Specific).  Caller Statement: HEAD INJURY.  1.This happened now (less than 6hrs ago).  2.There is no bleeding now.  3.He is completely alert (responding appropriately).  4.The injury is to the head.  ProQA Medical Dispatch Message Sent; Dispatch Code: 30-B-01  Problem: HEAD INJURY.  Patient Info: 1 patient(s); 12 Years old; Male; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1722070 \r\n" +
        "\r\n",

        "TIME:16:10",
        "DATE:10/20/12",
        "CALL:M Priority 3 Medical",
        "BOX:206",
        "ADDR:4755 HALLOWING POINT RD",
        "INFO:PRINCE FREDERICK HP PK NO HEAD INJURY  12 YOM  ARM INJURY AT FIELD 12  POSSIBLY DANGEROUS body area.  ProQA Medical Questionnaire Completed; Dispatch Code: 30-B-01  Problem: HEAD INJURY.  Patient Info: 1 patient(s); 12 Years old; Male; Conscious: Yes; Breathing: Yes;  You are responding to a patient with specifically identified traumatic injuries.  The patient is a 12-year-old male, who is conscious and breathing.  POSSIBLY DANGEROUS body area.  Traumatic Injuries (Specific).  Caller Statement: HEAD INJURY.  1.This happened now (less than 6hrs ago).  2.There is no bleeding now.  3.He is completely alert (responding appropriately).  4.The injury is to the head.  ProQA Medical Dispatch Message Sent; Dispatch Code: 30-B-01  Problem: HEAD INJURY.  Patient Info: 1 patient(s); 12 Years old; Male; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1722070");

    doTest("T4",
        "(Dispatch Info) M Priority 3 Medical A39  15:21 10/20/12 Box 308 9923 HG TRUEMAN RD LUSBY  ProQA Medical Questionnaire Completed; Dispatch Code: 26-A-01  priority symptoms (complaint conditions 2-11 not identified).  Problem: kidney bag lose.  Patient Info: 1 patient(s); 65 Years old; Male; Conscious: Yes; Breathing: Yes;  You are responding to a patient who is sick (or has a current medical condition).  The patient is a 65-year-old male, who is conscious and breathing. No  priority symptoms (complaint conditions 2-11 not identified).  Sick Person (Specific Diagnosis).  No priority symptoms (complaint conditions 2-11 not identified).  Caller Statement: kidney bag lose.  1.He is completely alert (responding appropriately).  2.He is breathing normally.  3.He has other pain.  4.He is not bleeding (or vomiting blood).  5.No priority symptoms (ALPHA conditions 2-11 not identified).  6.No priority symptoms (OMEGA conditions 2-28 not identified).  Problem: kidney bag lose.  Patient Info: 1 patient(s); 65 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 26-A-01  kidney bag came lose 65yom  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1722055 \r\n" +
        "\r\n",

        "TIME:15:21",
        "DATE:10/20/12",
        "CALL:M Priority 3 Medical",
        "UNIT:A39",
        "BOX:308",
        "ADDR:9923 HG TRUEMAN RD",
        "CITY:LUSBY",
        "INFO:ProQA Medical Questionnaire Completed; Dispatch Code: 26-A-01  priority symptoms (complaint conditions 2-11 not identified).  Problem: kidney bag lose.  Patient Info: 1 patient(s); 65 Years old; Male; Conscious: Yes; Breathing: Yes;  You are responding to a patient who is sick (or has a current medical condition).  The patient is a 65-year-old male, who is conscious and breathing. No  priority symptoms (complaint conditions 2-11 not identified).  Sick Person (Specific Diagnosis).  No priority symptoms (complaint conditions 2-11 not identified).  Caller Statement: kidney bag lose.  1.He is completely alert (responding appropriately).  2.He is breathing normally.  3.He has other pain.  4.He is not bleeding (or vomiting blood).  5.No priority symptoms (ALPHA conditions 2-11 not identified).  6.No priority symptoms (OMEGA conditions 2-28 not identified).  Problem: kidney bag lose.  Patient Info: 1 patient(s); 65 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 26-A-01  kidney bag came lose 65yom  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1722055");

    doTest("T5",
        "(Dispatch Info) R Auto Accident Injury R3 A39 A79  13:00 10/20/12 Box 310 CORDOVA LN LUSBY  11.Everyone is being cooperative.  12.It is not known if alcohol or drugs are involved.  13.The vehicle description is:  14.The exact location of the vehicle(s) is: intersection  15.It is not known if any other property is damaged besides the vehicle(s).-Comments: intersection-  ProQA Police Key Questions have been completed; Dispatch Code: 131-C-01B  subaru suv - ford focus.. 2 vehs at intersection  ProQA Police Dispatch Message Sent; Dispatch Code: 131-C-01B  Traffic / Transportation Accident (Crash).TRAFFIC ACCIDENT (unknown injury)  (Blocking traffic). Caller Statement: accident.  1.The caller is not on scene.  2.This incident just occurred.  3.This incident involves a TRAFFIC ACCIDENT.  4.It is not known if anyone is injured.  5.It is not known if anyone is pinned (trapped) in the vehicle(s).  6.No one was thrown from the vehicle(s).  7.It is not known if there are hazardous materials involved.  8.There are items blocking or slowing the flow of traffic: vehs  9.More than one vehicle is involved: 2  10.All drivers are still on scene.-Comments: vehs--Comments: 2-  New ProQA Police Case Number has been assigned; Dispatch Code: --: -1722025 \r\n" +
        "\r\n",

        "TIME:13:00",
        "DATE:10/20/12",
        "CALL:R Auto Accident Injury",
        "UNIT:R3 A39 A79",
        "BOX:310",
        "ADDR:CORDOVA LN",
        "CITY:LUSBY",
        "INFO:11.Everyone is being cooperative.  12.It is not known if alcohol or drugs are involved.  13.The vehicle description is:  14.The exact location of the vehicle(s) is: intersection  15.It is not known if any other property is damaged besides the vehicle(s).-Comments: intersection-  ProQA Police Key Questions have been completed; Dispatch Code: 131-C-01B  subaru suv - ford focus.. 2 vehs at intersection  ProQA Police Dispatch Message Sent; Dispatch Code: 131-C-01B  Traffic / Transportation Accident (Crash).TRAFFIC ACCIDENT (unknown injury)  (Blocking traffic). Caller Statement: accident.  1.The caller is not on scene.  2.This incident just occurred.  3.This incident involves a TRAFFIC ACCIDENT.  4.It is not known if anyone is injured.  5.It is not known if anyone is pinned (trapped) in the vehicle(s).  6.No one was thrown from the vehicle(s).  7.It is not known if there are hazardous materials involved.  8.There are items blocking or slowing the flow of traffic: vehs  9.More than one vehicle is involved: 2  10.All drivers are still on scene.-Comments: vehs--Comments: 2-  New ProQA Police Case Number has been assigned; Dispatch Code: --: -1722025");

    doTest("T6",
        "(Dispatch Info) M Priority 3 Medical A39  01:06 10/20/12 Box 303 11840 CLIFTON DR LUSBY  ProQA Medical Questionnaire Completed; Dispatch Code: 28-C-03H  problems  (Strong evidence of stroke (=> X hours)).  Problem: mom poss cva.  Patient Info: 1 patient(s); 93 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 28-C-03H  You are responding to a patient who has apparently suffered a stroke.  The patient  is a 93-year-old female, who is conscious and breathing. Sudden speech  problems  (Strong evidence of stroke (=> X hours)).  Stroke (CVA).  Sudden speech problems  (Strong evidence of stroke (=> X hours)).  Caller Statement: mom poss cva.  1.She is completely alert (responding appropriately).  2.She is breathing normally.  3.She is having sudden speech problems.  4.The Stroke Diagnostic results indicate strong evidence of stroke.  5.These symptoms (problem) started: this morning  6.She has not had a STROKE before.  -Stroke Diagnostic:Tool Predictive Value: Strong evidence of stroke (2,2,4)-  -Comments: this morning-  Problem: mom poss cva.  Patient Info: 1 patient(s); 93 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1721916  E911 Info - Class of Service: RESD Special Response Info: PRIMARY PSAP: BOX 303 \r\n" +
        "\r\n",

        "TIME:01:06",
        "DATE:10/20/12",
        "CALL:M Priority 3 Medical",
        "UNIT:A39",
        "BOX:303",
        "ADDR:11840 CLIFTON DR",
        "CITY:LUSBY",
        "INFO:ProQA Medical Questionnaire Completed; Dispatch Code: 28-C-03H  problems  (Strong evidence of stroke (=> X hours)).  Problem: mom poss cva.  Patient Info: 1 patient(s); 93 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 28-C-03H  You are responding to a patient who has apparently suffered a stroke.  The patient  is a 93-year-old female, who is conscious and breathing. Sudden speech  problems  (Strong evidence of stroke (=> X hours)).  Stroke (CVA).  Sudden speech problems  (Strong evidence of stroke (=> X hours)).  Caller Statement: mom poss cva.  1.She is completely alert (responding appropriately).  2.She is breathing normally.  3.She is having sudden speech problems.  4.The Stroke Diagnostic results indicate strong evidence of stroke.  5.These symptoms (problem) started: this morning  6.She has not had a STROKE before.  -Stroke Diagnostic:Tool Predictive Value: Strong evidence of stroke (2,2,4)-  -Comments: this morning-  Problem: mom poss cva.  Patient Info: 1 patient(s); 93 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1721916  E911 Info - Class of Service: RESD Special Response Info: PRIMARY PSAP: BOX 303");

    doTest("T7",
        "(Dispatch Info) M Priority 3 Medical A39  20:15 10/19/12 23220 SURREY WAY ST MARYS  medical box 902 at 23220 surrey way apt g chest pains... ac03 \r\n" +
        "\r\n",

        "TIME:20:15",
        "DATE:10/19/12",
        "CALL:M Priority 3 Medical",
        "UNIT:A39",
        "ADDR:23220 SURREY WAY",
        "PLACE:ST MARYS",
        "INFO:medical box 902 at 23220 surrey way apt g chest pains... ac03");

    doTest("T8",
        "(Dispatch Info) F Service Call  18:45 10/19/12 Box 305  12485 SOUTHERN CONNECTOR BLVD LUSBY SCHOOL-PAT HS football game standby \r\n" +
        "\r\n",

        "TIME:18:45",
        "DATE:10/19/12",
        "CALL:F Service Call",
        "BOX:305",
        "ADDR:12485 SOUTHERN CONNECTOR BLVD",
        "PLACE:SCHOOL-PAT HS",
        "CITY:LUSBY",
        "INFO:football game standby");

    doTest("T9",
        "(Dispatch Info) M Priority 2 Medical A39 SMA388 M102  14:31 10/19/12 Box 302 13962 HG TRUEMAN RD SOLOMONS JERRYS SUBS-SOL THE MALE WOULD LIEK TO RIDE WITH THE AMB HE IF CAN  23 YOF OUTSIDE VOMITING BLOOD W CHEST PAINS  PAT PLAZA  Problem: vomiting blood.  Patient Info: 1 patient(s); 23 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Questionnaire Completed; Dispatch Code: 10-A-01  female, who is conscious and breathing. Breathing normally < 35.  You are responding to a patient with chest pain.  The patient is a 23-year-old  female, who is conscious and breathing. Breathing normally < 35.  Chest Pain (Non-Traumatic).  Caller Statement: vomiting blood.  1.She is completely alert (responding appropriately).  2.She is breathing normally.  ^    3.She has chest pain. (Change from Protocol #26)  4.She is completely alert (responding appropriately).  5.She is breathing normally.  6.She is not changing color.  7.She is not clammy.  8.She has not had a heart attack or angina (heart pains) before.  9.She did not take any drugs (medications) in the past 12hrs.  Problem: vomiting blood.  Patient Info: 1 patient(s); 23 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 10-A-01  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1721766 \r\n" +
        "\r\n",

        "TIME:14:31",
        "DATE:10/19/12",
        "CALL:M Priority 2 Medical",
        "UNIT:A39 SMA388 M102",
        "BOX:302",
        "ADDR:13962 HG TRUEMAN RD",
        "CITY:SOLOMONS",
        "INFO:JERRYS SUBS-SOL THE MALE WOULD LIEK TO RIDE WITH THE AMB HE IF CAN  23 YOF OUTSIDE VOMITING BLOOD W CHEST PAINS  PAT PLAZA  Problem: vomiting blood.  Patient Info: 1 patient(s); 23 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Questionnaire Completed; Dispatch Code: 10-A-01  female, who is conscious and breathing. Breathing normally < 35.  You are responding to a patient with chest pain.  The patient is a 23-year-old  female, who is conscious and breathing. Breathing normally < 35.  Chest Pain (Non-Traumatic).  Caller Statement: vomiting blood.  1.She is completely alert (responding appropriately).  2.She is breathing normally.  ^    3.She has chest pain. (Change from Protocol #26)  4.She is completely alert (responding appropriately).  5.She is breathing normally.  6.She is not changing color.  7.She is not clammy.  8.She has not had a heart attack or angina (heart pains) before.  9.She did not take any drugs (medications) in the past 12hrs.  Problem: vomiting blood.  Patient Info: 1 patient(s); 23 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 10-A-01  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1721766");

    doTest("T10",
        "(Dispatch Info) M Priority 3 Medical A39  11:44 10/19/12 Box 311 11812 ARROW HEAD TRL LUSBY  You are responding to a patient who is hemorrhaging.  The patient is a  87-year-old male, who is conscious and breathing. NOT DANGEROUS  hemorrhage.  Hemorrhage / Lacerations.  NOT DANGEROUS hemorrhage.  Caller Statement: BED SORE ON HEAL.  1.The cause of the bleeding is non-traumatic.  2.The bleeding is from a NOT DANGEROUS area.  3.He is completely alert (responding appropriately).  4.He is breathing normally.  5.There is no SERIOUS bleeding.  6.He does not have a bleeding disorder or is taking blood thinners.  ProQA Medical Dispatch Message Sent; Dispatch Code: 21-A-01  Problem: BED SORE ON HEAL.  Patient Info: 1 patient(s); 87 Years old; Male; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1721716  BED SORE ON HEEL THAT IS INFECTED  E911 Info - Class of Service: VOIP Special Response Info: VERIFY PD                       VERIFY FD                       VERIFY EMS \r\n" +
        "\r\n",

        "TIME:11:44",
        "DATE:10/19/12",
        "CALL:M Priority 3 Medical",
        "UNIT:A39",
        "BOX:311",
        "ADDR:11812 ARROW HEAD TRL",
        "CITY:LUSBY",
        "INFO:You are responding to a patient who is hemorrhaging.  The patient is a  87-year-old male, who is conscious and breathing. NOT DANGEROUS  hemorrhage.  Hemorrhage / Lacerations.  NOT DANGEROUS hemorrhage.  Caller Statement: BED SORE ON HEAL.  1.The cause of the bleeding is non-traumatic.  2.The bleeding is from a NOT DANGEROUS area.  3.He is completely alert (responding appropriately).  4.He is breathing normally.  5.There is no SERIOUS bleeding.  6.He does not have a bleeding disorder or is taking blood thinners.  ProQA Medical Dispatch Message Sent; Dispatch Code: 21-A-01  Problem: BED SORE ON HEAL.  Patient Info: 1 patient(s); 87 Years old; Male; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned; Dispatch Code: --: -1721716  BED SORE ON HEEL THAT IS INFECTED  E911 Info - Class of Service: VOIP Special Response Info: VERIFY PD                       VERIFY FD                       VERIFY EMS");

  }
  
  public static void main(String[] args) {
    new MDCalvertCountyParserTest().generateTests("T1");
  }
}
