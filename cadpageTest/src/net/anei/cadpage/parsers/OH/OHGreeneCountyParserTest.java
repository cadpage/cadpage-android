package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Xenia township, OH
Contact:  Brian Miller. Xtfd62@yahoo.com, 9376732333@messaging.sprintp

MBLS-MEDICAL Location: 160 RICHARD DR DAYTON XENIA RD / ROBERT LN XENIA TWP Time: 17:31 Units: M51  Common
FMALS-MEDIC AL Location: 378 WINDING TRL LAMPLIGHTER PL, WOODLAND DR / HELEN AVE XENIA TWP Time: 16:39 Unit
FGRA-GRASS/FIELD Location: 731 HOOK RD OLD HOOK RD / S BICKETT RD XENIA TWP Time: 11:52 Units:  Common Name
FMBLS-MEDICAL Location: 721 KINSEY RD CRESTLINE DR / APOLLO DR XENIA TWP Time: 23:36 Units:  Common Name: I
FGRA-GRASS/FIELD Location: 731 HOOK RD OLD HOOK RD / S BICKETT RD XENIA TWP Time: 11:52 Units:  Common Name
FMBLS-MEDICAL Location: 160 RICHARD DR DAYTON XENIA RD / ROBERT LN XENIA TWP Time: 17:31 Units: M51  Common
CRUI Location: STEVENSON RD US 42 E XENIA TWP Time: 23:52 Units: E51 M51 CHF50  Common Name: Info:  IN A DI
FMALS-MEDIC AL Location: 378 WINDING TRL LAMPLIGHTER PL, WOODLAND DR / HELEN AVE XENIA TWP Time: 16:39 Unit
CRPI Location: 413 CLIFTON RD LITTLE MIAMI SCENIC BIKE PATH / CLARK RUN RD XENIA TWP Time: 19:17 Units: E51
CRUI Location: STEVENSON RD US 42 E XENIA TWP Time: 23:52 Units: E51 M51 CHF50  Common Name: Info:  IN A DI
FMBLS-MEDICAL Location: 9 SEXTON DR OLD SPRINGFIELD PIKE / OLD SPRINGFIELD PIKE XENIA TWP Time: 21:28 Units
FACO-FIRE ALARM COMMERCIAL Location: 121 FAIRGROUND RD GREENE COUNTY FAIRGROUNDS / BEAVERCREEK LN XENIA TWP
FMBLS-MEDICAL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 13:36 Units: M52  Common Na
FMALS-MEDIC AL Location: 3301 BONE RD UNKNOWN / E SPRING VALLEY PAINTERSVILLE RD CAESARCREEK TWP Time: 18:2
CRUI Location: E LIMESTONE ST XENIA AVE YELLOW SPRINGS Time: 18:42 Units: E82 HUSMA M51 CHF81  Common Name:
FMBLS-MEDICAL Location: 2960 W  ENON RD SR 235 / W HYDE RD XENIA TWP Time: 12:02 Units: M51  Common Name: G
FMBLS-MEDICAL Location: 2383 NEEDMORE RD No Cross Streets Found CAESARCREEK TWP Time: 17:05 Units: M52  Com
FMALS-MEDIC AL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 09:05 Units: M52 E52  Comm
FMBLS-MEDICAL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 17:17 Units:  Common Name:
FGRA-GRASS/FIELD Location: 55 CLIFTON RD US 68 N / LITTLE MIAMI SCENIC BIKE PATH XENIA TWP Time: 00:05 Unit
FSCE-SERVICE CALL-ENGINE Location: 8834 MICHAELA LN WARREN COUNTY Time: 20:41 Units: T51 T52  Common Name:
FMBLS-MEDICAL Location: 1541 SR 380 COUNTRY PLACE CT / RENAISSANCE WOOD CT XENIA TWP Time: 00:28 Units: M52
FMBLS-MEDICAL Location: 467 WILSON DR REGINA DR / MEADOW LN XENIA TWP Time: 23:39 Units:  Common Name: Info
FRES-RESIDENTIAL FIRE Location: 710 HAWKINS RD CREEKSIDE TRAIL BIKE PATH / FORD RD XENIA TWP Time: 20:51 Un
FMALS-MEDIC AL Location: 1264 BOYD RD DEAD END / US 68 S XENIA TWP Time: 21:25 Units: M52 E52  Common Name:
FMBLS-MEDICAL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 17:17 Units:  Common Name:

Contact: 5864897676@vzwpix.com
(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 4185 CHERRY GROVE RD JUNKIN RD / OLD US 35 E NEW JASPER TWP Time: 17:08 Units: E14 E41 E11 T14 T41 T11
(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 683 E  MAIN ST WILLIAMS AVE / HARBISON AVE XENIA Time: 16:33 Units: E31 E32 E51 E11 L31 M33 BAT30 CHF3
(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 4185 CHERRY GROVE RD JUNKIN RD / OLD US 35 E NEW JASPER TWP Time: 17:08 Units: E14 E41 E11 T14 T41 T11
(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 986 E  MARKET ST N PATTON ST / WILLIAMS AVE XENIA Time: 19:54 Units: E31 E32 E51 E11 L31 M32 CHF30  Co
(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 4185 CHERRY GROVE RD JUNKIN RD / OLD US 35 E NEW JASPER TWP Time: 17:08 Units: E14 E41 E11 T14 T41 T11

New Jasper Township
Contact: Greg Gould <gould1440@gmail.com>
Sender: psisn_dispatch@ci.xenia.oh.us
(Dispatch Info) FMBLS-MEDICAL Location: 738 BLACK FOOT TRL SHAWNEE TRL / ONEIDA TRL NEW JASPER TWP Time: 20:37 Units:  Common Name: Info:  Problem: LO
(Dispatch Info) FMALS-MEDIC AL Location: 3986 SHAWNEE TRL N LAKESHORE DR / NIAGARA TRL NEW JASPER TWP Time: 14:09 Units: M42 BR14  Common Name: Info:
(Dispatch Info) FMBLS-MEDICAL Location: 3811 WAYNESVILLE JAMESTOWN RD ST JOHN RD / MT CARMEL RD NEW JASPER TWP Time: 09:57 Units: M14 BR14  Common Nam
(Dispatch Info) CRUI Location: 3809 JASPER RD ST JOHN RD / APACHE TRL NEW JASPER TWP Time: 18:16 Units:  Common Name: Info:  W 2 PTS NON ER TO GMH  PO
(Dispatch Info) FMALS-MEDIC AL Location: 2136 E  HOOP RD GULTICE RD / COOPER LN NEW JASPER TWP Time: 06:21 Units: M14 BR14  Common Name: Info:  NOT RE

Contact: Active911
Agency name: Xenia Township
Location: Xenia, OH, United States
Sender: PSISN_Dispatch@ci.xenia.oh.us

(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 2660 WAYNESVILLE JAMESTOWN RD TURNER RD / E HOOP RD CAESARCREEK TWP Time: 10:56 Units: E52 E51 E14 T52 T51 T14 T16 M52 R52 BR52 CHF50  Common Name: Info:  Incident #: 2013-00000205
(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 227 N  MAIN ST COLLEGE ST / CHURCH ST CEDARVILLE Time: 08:03 Units: E41 E31 E81 E51 L11 R11 M13 M15 CHF11  Common Name: Info:  Incident #: 2013-00000184
(Dispatch Info) FMBLS-MEDICAL Location: 946 LIVINGSTON DR MAPLE DR / DEAD END XENIA TWP Time: 22:11 Units: M52  Common Name: Info:  Problem: PAIN.  Patient Info: 1 patient(s); 65 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26A01; Response Text: Alpha  65 year old, Male, Conscious, Breathing.  Sick Person (Specific Diagnosis).  No priority symptoms (complaint conditions 2-11 not identified).  Caller Statement: PAIN.  1.He is completely alert (responding appropriately).  2.He is breathing normally.  3.He has other pain: LEGS AND ARMS  4.He is not bleeding (or vomiting blood).  5.No priority symptoms (ALPHA conditions 2-11 not identified).  6.No priority symptoms (OMEGA conditions 2-28 not identified).  -Comments: LEGS AND ARMS-  New ProQA Case Number has been assigned: -873754  Incident #: 2013-00000203
(Dispatch Info) FMBLS-MEDICAL Location: 1934 HUSSEY RD NEEDMORE RD / WAYNESVILLE JAMESTOWN RD CAESARCREEK TWP Time: 10:16 Units: M52  Common Name: Info:  New ProQA Case Number has been assigned: -873512  Incident #: 2013-00000202
(Dispatch Info) FMBLS-MEDICAL Location: 3375 US 68 S E SPRING VALLEY PAINTERSVILLE RD / ELEAZER RD CAESARCREEK TWP Time: 02:46 Units: M52  Common Name: Info:  g132 req medic  w/ the fml now  the male contacted clinton county s.o advising he was next door at his parents house, 937-768-5126  unable to get thru to compl  lost call  now uncle might pick female up  mom is going to pick caller up  he is back at the house  his parents live behind them  he doesn't drive  he ran out the door  unk where the male is at this time  male was choking female so she punched him in the face  they have a 7 mo old child in the house  no intox  male may have been drinking  jonathan downey is male  he has stabbed her bf w a kitchen knife  no weapons  male yelling in background  can't understand caller - she is crying  male choking female  Incident #: 2013-00007654
(Dispatch Info) FMBLS-MEDICAL Location: 1055 N  BICKETT RD US 42 E / OHIO TO ERIE TRAIL BIKE PATH XENIA TWP Time: 18:01 Units: M51  Common Name: Info:  Problem: laceration to hand.  Patient Info: 1 patient(s); 24 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 21; Dispatch Level: 21A01; Response Text: Alpha  24 year old, Female, Conscious, Breathing.  Hemorrhage / Lacerations.  NOT DANGEROUS hemorrhage.  Caller Statement: laceration to hand.  1.The cause of the bleeding is traumatic.  2.The bleeding is from a NOT DANGEROUS area.  3.She is completely alert (responding appropriately).  4.She is breathing normally.  5.There is no blood spurting or pouring out.  6.She does not have a bleeding disorder or is taking blood thinners.  New ProQA Case Number has been assigned: -872632  alumni multiplex gym  Incident #: 2013-00000200
(Dispatch Info) FMALS-MEDIC AL Location: 855 LOWER BELLBROOK RD BELLBROOK AVE / STERLING COMMONS BLVD XENIA TWP Time: 13:52 Units: M52 E52  Common Name: NATIONWIDE BI WEEKLY ADMINISTRATIONInfo:  Problem: seizure.  Patient Info: 1 patient(s); 45 Years old; Female; Conscious: No; Breathing: Yes;  45 year old, Female, Unconscious, Breathing.  Convulsions / Seizures.  CONTINUOUS or MULTIPLE seizures  (Epileptic or Previous seizure diagnosis).  Caller Statement: seizure.  1.This is apparently a generalized (grand mal) seizure.  2.It's not known if she has had more than one seizure in a row.  3.It's not known if she is pregnant.  4.It's not known if she is diabetic.  5.She is an epileptic (diagnosed with a seizure disorder).  6.It's not known if she has a history of STROKE or brain tumor.  7.The jerking (twitching) has not stopped.  ProQA Dispatch Message Sent; Chief Complaint Number: 12; Dispatch Level: 12D02; Dispatch Level Suffix: E; Response Text: Delta  New ProQA Case Number has been assigned: -872546  Incident #: 2013-00000199
(Dispatch Info) FMBLS-MEDICAL Location: 1435 US 42 E BRUSH ROW RD / N BICKETT RD XENIA TWP Time: 11:36 Units: M51  Common Name: Info:  WATNS OFFICERS TO MEET AT SPEEDWAY  BLK JEEP  HE IS THERE ALONE  CRISIS ADVISING HE NEEDS TO GO TO HOSPITAL  MOTEHR HAS LEFT  BEIGN VIOLENT  HE IS BIPOLAR AND OFF MEDS  GRANT BOGGS  21 YOA SON  Incident #: 2013-00000294
(Dispatch Info) FIIN-INSIDE INVEST Location: 3198 OLD WINCHESTER TRL E SPRING VALLEY PAINTERSVILLE RD / MILL RD CAESARCREEK TWP Time: 10:43 Units: E52  Common Name: Info:  New ProQA Case Number has been assigned: -871969  Incident #: 2013-00000197
(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 1887 CONNECTICUT DR MONTANA DR / WISCONSIN DR XENIA Time: 06:33 Units: BAT30 CHF30 E32 E31 L31 M32 E51 E64A  Common Name: Info:  Incident #: 2013-00000966

Contact: Active911
Agency name: Xenia Fire Division
Location: Xenia, OH, United States
Sender: PSISN_Dispatch@ci.xenia.oh.us

(Dispatch Info) FMALS-MEDIC AL Location: 600 LITTLE MAIN ST W SECOND ST / S ORANGE ST XENIA Time: 21:24 Units: M32  Common Name: DEERFIELD INNInfo:  ROOM  203  40 year old, Male, Conscious, Breathing.  Chest Pain (Non-Traumatic).  Clammy.  Caller Statement: CHEST PAIN.  1.He is completely alert (responding appropriately).  2.He is breathing normally.  3.He is not changing color.  4.He is clammy.  Problem: CHEST PAIN.  Patient Info: 1 patient(s); 40 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 10; Dispatch Level: 10D04; Response Text: Delta  New ProQA Case Number has been assigned: -899980  Incident #: 2013-00001748
(Dispatch Info) CRUI Location: 1900 WEST PARK SQ N PROGRESS DR, GREENE WAY BLVD / DEAD END XENIA Time: 18:09 Units: BAT30 E32 M34  Common Name: Info:  CALLER WAS PASSERBY  ON PROGRESS NEAR RURAL KING  Dispatch received by unit X39  Dispatch received by unit X25  WHITE CAR AND SILVER CAR  TWO CARS  Incident #: 2013-00009069
(Dispatch Info) FMALS-MEDIC AL Location: 206 CODDINGTON AVE ARLINGTON DR / S DETROIT ST XENIA Time: 16:37 Units: M32  Common Name: Info:  Problem: BREATHING.  Patient Info: 1 patient(s); 1 Months old; Male; Conscious: Yes; Breathing: Yes;  1 month old, Male, Conscious, Breathing.  Breathing Problems.  DIFFICULTY SPEAKING BETWEEN BREATHS.  Caller Statement: BREATHING.  1.He is completely alert (responding appropriately).  2.He has difficulty crying between breaths.  ProQA Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: Delta  New ProQA Case Number has been assigned: -899822  Incident #: 2013-00001744
(Dispatch Info) FMBLS-MEDICAL Location: 2365 TENNESSEE DR NEW YORK DR / NEW MEXICO DR XENIA Time: 14:14 Units: M32  Common Name: Info:  Problem: FALL.  Patient Info: 1 patient(s); 52 Years old; Male; Conscious: Yes; Breathing: Yes;  52 year old, Male, Conscious, Breathing.  Falls.  POSSIBLY DANGEROUS body area  (On the ground or floor).  Caller Statement: FALL.  1.This happened now (less than 6hrs ago).  2.It's reported that he fell at ground level.  3.The fall was accidental.  4.There is no bleeding now.  5.He is completely alert (responding appropriately).  6.The injury is to a POSSIBLY DANGEROUS area.  7.He is still on the floor (ground).  ProQA Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17B01; Dispatch Level Suffix: G; Response Text: Bravo  New ProQA Case Number has been assigned: -899761  Incident #: 2013-00001742
(Dispatch Info) FMBLS-MEDICAL Location: 701 MT VERNON DR BEDFORD AVE / NEWPORT RD XENIA Time: 11:41 Units: M32  Common Name: Info:  66 year old, Male, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Dizziness/vertigo.  Caller Statement: dizziness.  1.He is completely alert (responding appropriately).  2.He is breathing normally.  3.He does not have any pain.  4.He is not bleeding (or vomiting blood).  5.His primary problem is dizziness/vertigo.  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26A03; Response Text: Alpha  Problem: dizziness.  Patient Info: 1 patient(s); 66 Years old; Male; Conscious: Yes; Breathing: Yes;  New ProQA Case Number has been assigned: -899699  Incident #: 2013-00001740
(Dispatch Info) FMALS-MEDIC AL Location: 2224 HIGH WHEEL DR WRIGHT CYCLE BLVD / WRIGHT CYCLE BLVD XENIA Time: 09:31 Units: M32  Common Name: WRIGHT PLACEInfo:  LOBBY  ProQA Dispatch Message Sent; Chief Complaint Number: 31; Dispatch Level: 31D03; Response Text: Delta  75 year old, Female, Conscious, Breathing.  Unconscious / Fainting (Near).  Not alert.  Caller Statement: LOW BLOOD PRESSURE.  1.Her breathing is not completely normal.  2.She is not completely alert (not responding appropriately).  3.She is changing color.  4.Her color change is pale.  Problem: LOW BLOOD PRESSURE.  Patient Info: 1 patient(s); 75 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Case Number has been assigned: -899652  Incident #: 2013-00001739
(Dispatch Info) FMBLS-MEDICAL Location: 489 CONARD DR BINGHAM DR / BERWALD DR XENIA Time: 20:36 Units: M31  Common Name: Info:  84 year old, Female, Conscious, Breathing.  Falls.  POSSIBLY DANGEROUS body area  (On the ground or floor).  Caller Statement: FELL.  1.This happened now (less than 6hrs ago).  2.It's reported that she fell at ground level.  3.The reason for the fall is not known.  4.There is no bleeding now.  5.She is completely alert (responding appropriately).  6.The injury is to the head.  7.She is still on the floor (ground).  ProQA Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17B01; Dispatch Level Suffix: G; Response Text: Bravo  Problem: FELL.  Patient Info: 1 patient(s); 84 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Case Number has been assigned: -899378  Incident #: 2013-00001737
(Dispatch Info) FMALS-MEDIC AL Location: 1445 PAVEY PL COUNTRY CLUB DR / DEE ANNE DR XENIA Time: 19:55 Units: M32 E31  Common Name: Info:  2.She is unwell/ill.  Problem: SICK.  Patient Info: 1 patient(s); 94 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Key Questions have been completed; Chief Complaint Number: 26; Dispatch Level: 26D01; Response Text: Delta  94 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Not alert.  Caller Statement: SICK.  1.She is not completely alert (not responding appropriately).  Problem: SICK.  Patient Info: 1 patient(s); 94 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26D01; Response Text: Delta  New ProQA Case Number has been assigned: -899353  Incident #: 2013-00001736
(Dispatch Info) FMBLS-MEDICAL Location: 1243 ARLINGTON DR HERITAGE LN / LEDBETTER RD XENIA Time: 19:02 Units: M31  Common Name: Info:  ProQA Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17B01; Dispatch Level Suffix: G; Response Text: Bravo  Problem: FALL.  Patient Info: 1 patient(s); 76 Years old; Female; Conscious: Yes; Breathing: Yes;  76 year old, Female, Conscious, Breathing.  Falls.  POSSIBLY DANGEROUS body area  (On the ground or floor).  Caller Statement: FALL.  1.This happened now (less than 6hrs ago).  2.It's reported that she fell at ground level.  3.The fall was accidental.  4.There is no bleeding now.  5.She is completely alert (responding appropriately).  6.The injury is to a POSSIBLY DANGEROUS area.  7.She is still on the floor (ground).  New ProQA Case Number has been assigned: -899326  Incident #: 2013-00001735
(Dispatch Info) FMBLS-MEDICAL Location: 135 E  CHURCH ST N COLLIER ST, EDISON BLVD / N WHITEMAN ST XENIA Time: 17:29 Units: M31  Common Name: YMCAInfo:  DIFF BREATHING  IN DIRECTORS OFFICE  Dispatch received by unit X64  KATHEE FORREST  Incident #: 2013-00008990

Contact: Active911
Agency name: Xenia Township
Location: Xenia, OH, United States
Sender: PSISN_Dispatch@ci.xenia.oh.us

(Dispatch Info) FMBLS-MEDICAL Location: 2065 SR 235 HILLTOP RD / US 68 N XENIA TWP Time: 20:45 Units: M51  Common Name: Info:  89 year old, Female, Conscious, Breathing.  Unconscious / Fainting (Near).  Fainting episode(s) and alert => 35 (without cardiac history).  Caller Statement: DIZZY.  1.Her breathing is completely normal.  2.She is completely alert (responding appropriately).  3.She is not changing color.  4.She has no history of heart problems.  Problem: DIZZY.  Patient Info: 1 patient(s); 89 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 31; Dispatch Level: 31A01; Response Text: Alpha  New ProQA Case Number has been assigned: -899952  E911 Info - Class of Service: RESD Special Response Info: XENIA TWP FD D-1  Incident #: 2013-00000346
(Dispatch Info) FMALS-MEDIC AL Location: 1525 E HOOP RD HOOP RD, S BICKETT RD / COOPER LN XENIA TWP Time: 10:02 Units: M52 E52  Common Name: Info:  3.She is not clammy.  4.She does not have asthma.  5.N/A  ProQA Key Questions have been completed; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: Delta  Problem: panic attack.  Patient Info: 1 patient(s); 53 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: Delta  Problem: panic attack.  Patient Info: 1 patient(s); 53 Years old; Female; Conscious: Yes; Breathing: Yes;  53 year old, Female, Conscious, Breathing.  Breathing Problems.  DIFFICULTY SPEAKING BETWEEN BREATHS.  Caller Statement: panic attack.  1.She is completely alert (responding appropriately).  2.She has difficulty speaking between breaths.  New ProQA Case Number has been assigned: -899667  Incident #: 2013-00000345
(Dispatch Info) FMALS-MEDIC AL Location: 338 GREEN ACRES DR OAK DALE DR / OAK DALE DR XENIA TWP Time: 09:40 Units:  Common Name: Info:  Problem: vomiting blood.  Patient Info: 1 patient(s); 78 Years old; Male; Conscious: Yes; Breathing: Yes;  78 year old, Male, Conscious, Breathing.  Hemorrhage / Lacerations.  Abnormal breathing.  Caller Statement: vomiting blood.  1.He is completely alert (responding appropriately).  2.He is not breathing normally.  3.He has other pain: esophagus is burning and pain in lower back  ^    4.He is bleeding (or vomiting blood). (Change from Protocol #26)  5.The cause of the bleeding is non-traumatic.  6.He is vomiting blood.  7.He is completely alert (responding appropriately).  8.He is not breathing normally.  9.There is no SERIOUS bleeding.  10.He does not have a bleeding disorder or is taking blood thinners.  -Comments: esophagus is burning and pain in lower back-  ProQA Dispatch Message Sent; Chief Complaint Number: 21; Dispatch Level: 21D04; Response Text: Delta  New ProQA Case Number has been assigned: -899658  Incident #: 2013-00000344
(Dispatch Info) FMBLS-MEDICAL Location: 338 GREEN ACRES DR OAK DALE DR / OAK DALE DR XENIA TWP Time: 09:40 Units: M51  Common Name: Info:  New ProQA Case Number has been assigned: -899658  Incident #: 2013-00000344
(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 76 POCAHONTAS ST ORMSBY DR / S DETROIT ST XENIA Time: 19:10 Units: E31 E32 E51 E11 L31 M32 BAT30 CHF30  Common Name: Info:  SMOKE COMING OUT WINDOWS AND FRONT DOOR  Incident #: 2013-00001722
(Dispatch Info) CREN Location: 303 KINSEY RD AMLIN DR / YELLOWSTONE RD XENIA Time: 09:17 Units: M51 R52  Common Name: XENIA HIGH SCHOOLInfo:  Dispatch received by unit CHF30  Incident #: 2013-00001710
(Dispatch Info) FSCE-SERVICE CALL-ENGINE Location: 1038 OLD SPRINGFIELD PIKE SEXTON DR / TEMPLE DR XENIA TWP Time: 23:49 Units: E51  Common Name: Info:  stove is fire hazzard  Incident #: 2013-00000341
(Dispatch Info) CRUI Location: OLD US 35 W, OLD US 35 W TO US 35 E / W MAIN ST, HOSPITALITY DR XENIA TWP Time: 16:41 Units: E51 M51 CHF50  Common Name: US 35 BYPASS SPLITInfo:  2 VEH  JUST BEFORE MERGE TO ONE LANE  Incident #: 2013-00000340
(Dispatch Info) FMBLS-MEDICAL Location: 1300 E SPRING VALLEY PAINTERSVILLE RD LEWIS RD / OLD WINCHESTER TRL CAESARCREEK TWP Time: 13:09 Units: M52  Common Name: Info:  Problem: fall.  Patient Info: 1 patient(s); 65 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 31; Dispatch Level: 31A01; Response Text: Alpha  65 year old, Male, Conscious, Breathing.  Unconscious / Fainting (Near).  Fainting episode(s) and alert => 35 (without cardiac history).  Caller Statement: fall.  1.This happened more than 6hrs ago.  2.It's reported that he fell at ground level.  ^    3.The fall was caused by dizziness. (Change from Protocol #17)  4.His breathing is completely normal.  5.He is completely alert (responding appropriately).  6.He is not changing color.  7.He has no history of heart problems.  New ProQA Case Number has been assigned: -897873  Incident #: 2013-00000339
(Dispatch Info) FMALS-MEDIC AL Location: 170 OUTERVIEW DR YELLOWSTONE RD / HILLCREST DR XENIA TWP Time: 09:37 Units: M51 E51  Common Name: Info:  76 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Not alert.  Caller Statement: CLAMMY.  1.She is not completely alert (not responding appropriately).  Problem: CLAMMY.  Patient Info: 1 patient(s); 76 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26D01; Response Text: Delta  New ProQA Case Number has been assigned: -897233  Incident #: 2013-00000338

Contact: Steve Mathis <stevemathis7@gmail.com>
Sender: PSISN_Dispatch@ci.xenia.oh.us
(Dispatch Info) FMBLS-MEDICAL Location: 486 CINCINNATI AVE SHORT ST / CENTER ST XENIA Time: 23:08 Units: M31  Common Name: Info:  Dispatch received by

 */

public class OHGreeneCountyParserTest extends BaseParserTest {
  
  public OHGreeneCountyParserTest() {
    setParser(new OHGreeneCountyParser(), "GREENE COUNTY", "OH");
  }
  
  @Test
  public void testXeniaTwp1() {

    doTest("T1",
        "MBLS-MEDICAL Location: 160 RICHARD DR DAYTON XENIA RD / ROBERT LN XENIA TWP Time: 17:31 Units: M51  Common",
        "CALL:MBLS-MEDICAL",
        "ADDR:160 RICHARD DR",
        "X:DAYTON XENIA RD / ROBERT LN",
        "CITY:XENIA TWP",
        "TIME:17:31",
        "UNIT:M51");

    doTest("T2",
        "FMALS-MEDIC AL Location: 378 WINDING TRL LAMPLIGHTER PL, WOODLAND DR / HELEN AVE XENIA TWP Time: 16:39 Unit",
        "CALL:FMALS-MEDIC AL",
        "ADDR:378 WINDING TRL",
        "PLACE:LAMPLIGHTER PL",
        "X:WOODLAND DR / HELEN AVE",
        "CITY:XENIA TWP",
        "TIME:16:39");

    doTest("T3",
        "FGRA-GRASS/FIELD Location: 731 HOOK RD OLD HOOK RD / S BICKETT RD XENIA TWP Time: 11:52 Units:  Common Name",
        "CALL:FGRA-GRASS/FIELD",
        "ADDR:731 HOOK RD",
        "X:OLD HOOK RD / S BICKETT RD",
        "CITY:XENIA TWP",
        "TIME:11:52");

    doTest("T4",
        "FMBLS-MEDICAL Location: 721 KINSEY RD CRESTLINE DR / APOLLO DR XENIA TWP Time: 23:36 Units:  Common Name: I",
        "CALL:FMBLS-MEDICAL",
        "ADDR:721 KINSEY RD",
        "X:CRESTLINE DR / APOLLO DR",
        "CITY:XENIA TWP",
        "TIME:23:36");

    doTest("T5",
        "FGRA-GRASS/FIELD Location: 731 HOOK RD OLD HOOK RD / S BICKETT RD XENIA TWP Time: 11:52 Units:  Common Name",
        "CALL:FGRA-GRASS/FIELD",
        "ADDR:731 HOOK RD",
        "X:OLD HOOK RD / S BICKETT RD",
        "CITY:XENIA TWP",
        "TIME:11:52");

    doTest("T6",
        "FMBLS-MEDICAL Location: 160 RICHARD DR DAYTON XENIA RD / ROBERT LN XENIA TWP Time: 17:31 Units: M51  Common",
        "CALL:FMBLS-MEDICAL",
        "ADDR:160 RICHARD DR",
        "X:DAYTON XENIA RD / ROBERT LN",
        "CITY:XENIA TWP",
        "TIME:17:31",
        "UNIT:M51");

    doTest("T7",
        "CRUI Location: STEVENSON RD US 42 E XENIA TWP Time: 23:52 Units: E51 M51 CHF50  Common Name: Info:  IN A DI",
        "CALL:CRUI",
        "ADDR:STEVENSON RD",
        "MADDR:STEVENSON RD & US 42 E",
        "X:US 42 E",
        "CITY:XENIA TWP",
        "TIME:23:52",
        "UNIT:E51 M51 CHF50",
        "INFO:IN A DI");

    doTest("T8",
        "FMALS-MEDIC AL Location: 378 WINDING TRL LAMPLIGHTER PL, WOODLAND DR / HELEN AVE XENIA TWP Time: 16:39 Unit",
        "CALL:FMALS-MEDIC AL",
        "ADDR:378 WINDING TRL",
        "PLACE:LAMPLIGHTER PL",
        "X:WOODLAND DR / HELEN AVE",
        "CITY:XENIA TWP",
        "TIME:16:39");

    doTest("T9",
        "CRPI Location: 413 CLIFTON RD LITTLE MIAMI SCENIC BIKE PATH / CLARK RUN RD XENIA TWP Time: 19:17 Units: E51",
        "CALL:CRPI",
        "ADDR:413 CLIFTON RD",
        "X:LITTLE MIAMI SCENIC BIKE PATH / CLARK RUN RD",
        "CITY:XENIA TWP",
        "TIME:19:17",
        "UNIT:E51");

    doTest("T10",
        "CRUI Location: STEVENSON RD US 42 E XENIA TWP Time: 23:52 Units: E51 M51 CHF50  Common Name: Info:  IN A DI",
        "CALL:CRUI",
        "ADDR:STEVENSON RD",
        "MADDR:STEVENSON RD & US 42 E",
        "X:US 42 E",
        "CITY:XENIA TWP",
        "TIME:23:52",
        "UNIT:E51 M51 CHF50",
        "INFO:IN A DI");

    doTest("T11",
        "FMBLS-MEDICAL Location: 9 SEXTON DR OLD SPRINGFIELD PIKE / OLD SPRINGFIELD PIKE XENIA TWP Time: 21:28 Units",
        "CALL:FMBLS-MEDICAL",
        "ADDR:9 SEXTON DR",
        "X:OLD SPRINGFIELD PIKE / OLD SPRINGFIELD PIKE",
        "CITY:XENIA TWP",
        "TIME:21:28");

    doTest("T12",
        "FACO-FIRE ALARM COMMERCIAL Location: 121 FAIRGROUND RD GREENE COUNTY FAIRGROUNDS / BEAVERCREEK LN XENIA TWP",
        "CALL:FACO-FIRE ALARM COMMERCIAL",
        "ADDR:121 FAIRGROUND RD",
        "X:GREENE COUNTY FAIRGROUNDS / BEAVERCREEK LN",
        "CITY:XENIA TWP");

    doTest("T13",
        "FMBLS-MEDICAL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 13:36 Units: M52  Common Na",
        "CALL:FMBLS-MEDICAL",
        "ADDR:1154 HOOK RD",
        "X:S BICKETT RD / OLD HOOK RD",
        "CITY:XENIA TWP",
        "TIME:13:36",
        "UNIT:M52");

    doTest("T14",
        "FMALS-MEDIC AL Location: 3301 BONE RD UNKNOWN / E SPRING VALLEY PAINTERSVILLE RD CAESARCREEK TWP Time: 18:2",
        "CALL:FMALS-MEDIC AL",
        "ADDR:3301 BONE RD",
        "X:UNKNOWN / E SPRING VALLEY PAINTERSVILLE RD",
        "CITY:CAESARSCREEK TWP",
        "TIME:18:2");

    doTest("T15",
        "CRUI Location: E LIMESTONE ST XENIA AVE YELLOW SPRINGS Time: 18:42 Units: E82 HUSMA M51 CHF81  Common Name:",
        "CALL:CRUI",
        "ADDR:E LIMESTONE ST",
        "MADDR:E LIMESTONE ST & XENIA AVE",
        "X:XENIA AVE",
        "CITY:YELLOW SPRINGS",
        "TIME:18:42",
        "UNIT:E82 HUSMA M51 CHF81");

    doTest("T16",
        "FMBLS-MEDICAL Location: 2960 W  ENON RD SR 235 / W HYDE RD XENIA TWP Time: 12:02 Units: M51  Common Name: G",
        "CALL:FMBLS-MEDICAL",
        "ADDR:2960 W ENON RD",
        "X:SR 235 / W HYDE RD",
        "CITY:XENIA TWP",
        "TIME:12:02",
        "UNIT:M51",
        "NAME:G");

    doTest("T17",
        "FMBLS-MEDICAL Location: 2383 NEEDMORE RD No Cross Streets Found CAESARCREEK TWP Time: 17:05 Units: M52  Com",
        "CALL:FMBLS-MEDICAL",
        "ADDR:2383 NEEDMORE RD",
        "CITY:CAESARSCREEK TWP",
        "TIME:17:05",
        "UNIT:M52");

    doTest("T18",
        "FMALS-MEDIC AL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 09:05 Units: M52 E52  Comm",
        "CALL:FMALS-MEDIC AL",
        "ADDR:1154 HOOK RD",
        "X:S BICKETT RD / OLD HOOK RD",
        "CITY:XENIA TWP",
        "TIME:09:05",
        "UNIT:M52 E52");

    doTest("T19",
        "FMBLS-MEDICAL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 17:17 Units:  Common Name:",
        "CALL:FMBLS-MEDICAL",
        "ADDR:1154 HOOK RD",
        "X:S BICKETT RD / OLD HOOK RD",
        "CITY:XENIA TWP",
        "TIME:17:17");

    doTest("T20",
        "FGRA-GRASS/FIELD Location: 55 CLIFTON RD US 68 N / LITTLE MIAMI SCENIC BIKE PATH XENIA TWP Time: 00:05 Unit",
        "CALL:FGRA-GRASS/FIELD",
        "ADDR:55 CLIFTON RD",
        "X:US 68 N / LITTLE MIAMI SCENIC BIKE PATH",
        "CITY:XENIA TWP",
        "TIME:00:05");

    doTest("T21",
        "FSCE-SERVICE CALL-ENGINE Location: 8834 MICHAELA LN WARREN COUNTY Time: 20:41 Units: T51 T52  Common Name:",
        "CALL:FSCE-SERVICE CALL-ENGINE",
        "ADDR:8834 MICHAELA LN",
        "X:WARREN COUNTY",
        "TIME:20:41",
        "UNIT:T51 T52");

    doTest("T22",
        "FMBLS-MEDICAL Location: 1541 SR 380 COUNTRY PLACE CT / RENAISSANCE WOOD CT XENIA TWP Time: 00:28 Units: M52",
        "CALL:FMBLS-MEDICAL",
        "ADDR:1541 SR 380",
        "MADDR:1541 OH 380",
        "X:COUNTRY PLACE CT / RENAISSANCE WOOD CT",
        "CITY:XENIA TWP",
        "TIME:00:28",
        "UNIT:M52");

    doTest("T23",
        "FMBLS-MEDICAL Location: 467 WILSON DR REGINA DR / MEADOW LN XENIA TWP Time: 23:39 Units:  Common Name: Info",
        "CALL:FMBLS-MEDICAL",
        "ADDR:467 WILSON DR",
        "X:REGINA DR / MEADOW LN",
        "CITY:XENIA TWP",
        "TIME:23:39");

    doTest("T24",
        "FRES-RESIDENTIAL FIRE Location: 710 HAWKINS RD CREEKSIDE TRAIL BIKE PATH / FORD RD XENIA TWP Time: 20:51 Un",
        "CALL:FRES-RESIDENTIAL FIRE",
        "ADDR:710 HAWKINS RD",
        "X:CREEKSIDE TRAIL BIKE PATH / FORD RD",
        "CITY:XENIA TWP",
        "TIME:20:51");

    doTest("T25",
        "FMALS-MEDIC AL Location: 1264 BOYD RD DEAD END / US 68 S XENIA TWP Time: 21:25 Units: M52 E52  Common Name:",
        "CALL:FMALS-MEDIC AL",
        "ADDR:1264 BOYD RD",
        "X:DEAD END / US 68 S",
        "CITY:XENIA TWP",
        "TIME:21:25",
        "UNIT:M52 E52");

    doTest("T26",
        "FMBLS-MEDICAL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 17:17 Units:  Common Name:",
        "CALL:FMBLS-MEDICAL",
        "ADDR:1154 HOOK RD",
        "X:S BICKETT RD / OLD HOOK RD",
        "CITY:XENIA TWP",
        "TIME:17:17");

  }
  
  @Test
  public void testNewJasperTwp() {

    doTest("T1",
        "(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 4185 CHERRY GROVE RD JUNKIN RD / OLD US 35 E NEW JASPER TWP Time: 17:08 Units: E14 E41 E11 T14 T41 T11",
        "CALL:FRES-RESIDENTIAL FIRE",
        "ADDR:4185 CHERRY GROVE RD",
        "X:JUNKIN RD / OLD US 35 E",
        "CITY:NEW JASPER TWP",
        "TIME:17:08",
        "UNIT:E14 E41 E11 T14 T41 T11");

    doTest("T2",
        "(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 683 E  MAIN ST WILLIAMS AVE / HARBISON AVE XENIA Time: 16:33 Units: E31 E32 E51 E11 L31 M33 BAT30 CHF3",
        "CALL:FRES-RESIDENTIAL FIRE",
        "ADDR:683 E MAIN ST",
        "X:WILLIAMS AVE / HARBISON AVE",
        "CITY:XENIA",
        "TIME:16:33",
        "UNIT:E31 E32 E51 E11 L31 M33 BAT30 CHF3");

    doTest("T3",
        "(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 4185 CHERRY GROVE RD JUNKIN RD / OLD US 35 E NEW JASPER TWP Time: 17:08 Units: E14 E41 E11 T14 T41 T11",
        "CALL:FRES-RESIDENTIAL FIRE",
        "ADDR:4185 CHERRY GROVE RD",
        "X:JUNKIN RD / OLD US 35 E",
        "CITY:NEW JASPER TWP",
        "TIME:17:08",
        "UNIT:E14 E41 E11 T14 T41 T11");

    doTest("T4",
        "(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 986 E  MARKET ST N PATTON ST / WILLIAMS AVE XENIA Time: 19:54 Units: E31 E32 E51 E11 L31 M32 CHF30  Co",
        "CALL:FRES-RESIDENTIAL FIRE",
        "ADDR:986 E MARKET ST",
        "X:N PATTON ST / WILLIAMS AVE",
        "CITY:XENIA",
        "TIME:19:54",
        "UNIT:E31 E32 E51 E11 L31 M32 CHF30");

    doTest("T5",
        "(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 4185 CHERRY GROVE RD JUNKIN RD / OLD US 35 E NEW JASPER TWP Time: 17:08 Units: E14 E41 E11 T14 T41 T11",
        "CALL:FRES-RESIDENTIAL FIRE",
        "ADDR:4185 CHERRY GROVE RD",
        "X:JUNKIN RD / OLD US 35 E",
        "CITY:NEW JASPER TWP",
        "TIME:17:08",
        "UNIT:E14 E41 E11 T14 T41 T11");

  }
  
  @Test
  public void testJasperTwpParser() {

    doTest("T1",
        "(Dispatch Info) FMBLS-MEDICAL Location: 738 BLACK FOOT TRL SHAWNEE TRL / ONEIDA TRL NEW JASPER TWP Time: 20:37 Units:  Common Name: Info:  Problem: LO",
        "CALL:FMBLS-MEDICAL",
        "ADDR:738 BLACK FOOT TRL",
        "X:SHAWNEE TRL / ONEIDA TRL",
        "CITY:NEW JASPER TWP",
        "TIME:20:37",
        "INFO:Problem: LO");

    doTest("T2",
        "(Dispatch Info) FMALS-MEDIC AL Location: 3986 SHAWNEE TRL N LAKESHORE DR / NIAGARA TRL NEW JASPER TWP Time: 14:09 Units: M42 BR14  Common Name: Info:",
        "CALL:FMALS-MEDIC AL",
        "ADDR:3986 SHAWNEE TRL",
        "X:N LAKESHORE DR / NIAGARA TRL",
        "CITY:NEW JASPER TWP",
        "TIME:14:09",
        "UNIT:M42 BR14");

    doTest("T3",
        "(Dispatch Info) FMBLS-MEDICAL Location: 3811 WAYNESVILLE JAMESTOWN RD ST JOHN RD / MT CARMEL RD NEW JASPER TWP Time: 09:57 Units: M14 BR14  Common Nam",
        "CALL:FMBLS-MEDICAL",
        "ADDR:3811 WAYNESVILLE JAMESTOWN RD",
        "X:ST JOHN RD / MT CARMEL RD",
        "CITY:NEW JASPER TWP",
        "TIME:09:57",
        "UNIT:M14 BR14");

    doTest("T4",
        "(Dispatch Info) CRUI Location: 3809 JASPER RD ST JOHN RD / APACHE TRL NEW JASPER TWP Time: 18:16 Units:  Common Name: Info:  W 2 PTS NON ER TO GMH  PO",
        "CALL:CRUI",
        "ADDR:3809 JASPER RD",
        "X:ST JOHN RD / APACHE TRL",
        "CITY:NEW JASPER TWP",
        "TIME:18:16",
        "INFO:W 2 PTS NON ER TO GMH  PO");

    doTest("T5",
        "(Dispatch Info) FMALS-MEDIC AL Location: 2136 E  HOOP RD GULTICE RD / COOPER LN NEW JASPER TWP Time: 06:21 Units: M14 BR14  Common Name: Info:  NOT RE",
        "CALL:FMALS-MEDIC AL",
        "ADDR:2136 E HOOP RD",
        "X:GULTICE RD / COOPER LN",
        "CITY:NEW JASPER TWP",
        "TIME:06:21",
        "UNIT:M14 BR14",
        "INFO:NOT RE");
 
  }
  
  @Test
  public void testXeniaTownship2() {

    doTest("T1",
        "(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 2660 WAYNESVILLE JAMESTOWN RD TURNER RD / E HOOP RD CAESARCREEK TWP Time: 10:56 Units: E52 E51 E14 T52 T51 T14 T16 M52 R52 BR52 CHF50  Common Name: Info:  Incident #: 2013-00000205",
        "CALL:FRES-RESIDENTIAL FIRE",
        "ADDR:2660 WAYNESVILLE JAMESTOWN RD",
        "X:TURNER RD / E HOOP RD",
        "CITY:CAESARSCREEK TWP",
        "TIME:10:56",
        "UNIT:E52 E51 E14 T52 T51 T14 T16 M52 R52 BR52 CHF50",
        "INFO:Incident #: 2013-00000205");

    doTest("T2",
        "(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 227 N  MAIN ST COLLEGE ST / CHURCH ST CEDARVILLE Time: 08:03 Units: E41 E31 E81 E51 L11 R11 M13 M15 CHF11  Common Name: Info:  Incident #: 2013-00000184",
        "CALL:FRES-RESIDENTIAL FIRE",
        "ADDR:227 N MAIN ST",
        "X:COLLEGE ST / CHURCH ST",
        "CITY:CEDARVILLE",
        "TIME:08:03",
        "UNIT:E41 E31 E81 E51 L11 R11 M13 M15 CHF11",
        "INFO:Incident #: 2013-00000184");

    doTest("T3",
        "(Dispatch Info) FMBLS-MEDICAL Location: 946 LIVINGSTON DR MAPLE DR / DEAD END XENIA TWP Time: 22:11 Units: M52  Common Name: Info:  Problem: PAIN.  Patient Info: 1 patient(s); 65 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26A01; Response Text: Alpha  65 year old, Male, Conscious, Breathing.  Sick Person (Specific Diagnosis).  No priority symptoms (complaint conditions 2-11 not identified).  Caller Statement: PAIN.  1.He is completely alert (responding appropriately).  2.He is breathing normally.  3.He has other pain: LEGS AND ARMS  4.He is not bleeding (or vomiting blood).  5.No priority symptoms (ALPHA conditions 2-11 not identified).  6.No priority symptoms (OMEGA conditions 2-28 not identified).  -Comments: LEGS AND ARMS-  New ProQA Case Number has been assigned: -873754  Incident #: 2013-00000203",
        "CALL:FMBLS-MEDICAL",
        "ADDR:946 LIVINGSTON DR",
        "X:MAPLE DR / DEAD END",
        "CITY:XENIA TWP",
        "TIME:22:11",
        "UNIT:M52",
        "INFO:Problem: PAIN.  Patient Info: 1 patient(s); 65 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26A01; Response Text: Alpha  65 year old, Male, Conscious, Breathing.  Sick Person (Specific Diagnosis).  No priority symptoms (complaint conditions 2-11 not identified).  Caller Statement: PAIN.  1.He is completely alert (responding appropriately).  2.He is breathing normally.  3.He has other pain: LEGS AND ARMS  4.He is not bleeding (or vomiting blood).  5.No priority symptoms (ALPHA conditions 2-11 not identified).  6.No priority symptoms (OMEGA conditions 2-28 not identified).  -Comments: LEGS AND ARMS-  New ProQA Case Number has been assigned: -873754  Incident #: 2013-00000203");

    doTest("T4",
        "(Dispatch Info) FMBLS-MEDICAL Location: 1934 HUSSEY RD NEEDMORE RD / WAYNESVILLE JAMESTOWN RD CAESARCREEK TWP Time: 10:16 Units: M52  Common Name: Info:  New ProQA Case Number has been assigned: -873512  Incident #: 2013-00000202",
        "CALL:FMBLS-MEDICAL",
        "ADDR:1934 HUSSEY RD",
        "X:NEEDMORE RD / WAYNESVILLE JAMESTOWN RD",
        "CITY:CAESARSCREEK TWP",
        "TIME:10:16",
        "UNIT:M52",
        "INFO:New ProQA Case Number has been assigned: -873512  Incident #: 2013-00000202");

    doTest("T5",
        "(Dispatch Info) FMBLS-MEDICAL Location: 3375 US 68 S E SPRING VALLEY PAINTERSVILLE RD / ELEAZER RD CAESARCREEK TWP Time: 02:46 Units: M52  Common Name: Info:  g132 req medic  w/ the fml now  the male contacted clinton county s.o advising he was next door at his parents house, 937-768-5126  unable to get thru to compl  lost call  now uncle might pick female up  mom is going to pick caller up  he is back at the house  his parents live behind them  he doesn't drive  he ran out the door  unk where the male is at this time  male was choking female so she punched him in the face  they have a 7 mo old child in the house  no intox  male may have been drinking  jonathan downey is male  he has stabbed her bf w a kitchen knife  no weapons  male yelling in background  can't understand caller - she is crying  male choking female  Incident #: 2013-00007654",
        "CALL:FMBLS-MEDICAL",
        "ADDR:3375 US 68",
        "X:S E SPRING VALLEY PAINTERSVILLE RD / ELEAZER RD",
        "CITY:CAESARSCREEK TWP",
        "TIME:02:46",
        "UNIT:M52",
        "INFO:g132 req medic  w/ the fml now  the male contacted clinton county s.o advising he was next door at his parents house, 937-768-5126  unable to get thru to compl  lost call  now uncle might pick female up  mom is going to pick caller up  he is back at the house  his parents live behind them  he doesn't drive  he ran out the door  unk where the male is at this time  male was choking female so she punched him in the face  they have a 7 mo old child in the house  no intox  male may have been drinking  jonathan downey is male  he has stabbed her bf w a kitchen knife  no weapons  male yelling in background  can't understand caller - she is crying  male choking female  Incident #: 2013-00007654");

    doTest("T6",
        "(Dispatch Info) FMBLS-MEDICAL Location: 1055 N  BICKETT RD US 42 E / OHIO TO ERIE TRAIL BIKE PATH XENIA TWP Time: 18:01 Units: M51  Common Name: Info:  Problem: laceration to hand.  Patient Info: 1 patient(s); 24 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 21; Dispatch Level: 21A01; Response Text: Alpha  24 year old, Female, Conscious, Breathing.  Hemorrhage / Lacerations.  NOT DANGEROUS hemorrhage.  Caller Statement: laceration to hand.  1.The cause of the bleeding is traumatic.  2.The bleeding is from a NOT DANGEROUS area.  3.She is completely alert (responding appropriately).  4.She is breathing normally.  5.There is no blood spurting or pouring out.  6.She does not have a bleeding disorder or is taking blood thinners.  New ProQA Case Number has been assigned: -872632  alumni multiplex gym  Incident #: 2013-00000200",
        "CALL:FMBLS-MEDICAL",
        "ADDR:1055 N BICKETT RD",
        "X:US 42 E / OHIO TO ERIE TRAIL BIKE PATH",
        "CITY:XENIA TWP",
        "TIME:18:01",
        "UNIT:M51",
        "INFO:Problem: laceration to hand.  Patient Info: 1 patient(s); 24 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 21; Dispatch Level: 21A01; Response Text: Alpha  24 year old, Female, Conscious, Breathing.  Hemorrhage / Lacerations.  NOT DANGEROUS hemorrhage.  Caller Statement: laceration to hand.  1.The cause of the bleeding is traumatic.  2.The bleeding is from a NOT DANGEROUS area.  3.She is completely alert (responding appropriately).  4.She is breathing normally.  5.There is no blood spurting or pouring out.  6.She does not have a bleeding disorder or is taking blood thinners.  New ProQA Case Number has been assigned: -872632  alumni multiplex gym  Incident #: 2013-00000200");

    doTest("T7",
        "(Dispatch Info) FMALS-MEDIC AL Location: 855 LOWER BELLBROOK RD BELLBROOK AVE / STERLING COMMONS BLVD XENIA TWP Time: 13:52 Units: M52 E52  Common Name: NATIONWIDE BI WEEKLY ADMINISTRATIONInfo:  Problem: seizure.  Patient Info: 1 patient(s); 45 Years old; Female; Conscious: No; Breathing: Yes;  45 year old, Female, Unconscious, Breathing.  Convulsions / Seizures.  CONTINUOUS or MULTIPLE seizures  (Epileptic or Previous seizure diagnosis).  Caller Statement: seizure.  1.This is apparently a generalized (grand mal) seizure.  2.It's not known if she has had more than one seizure in a row.  3.It's not known if she is pregnant.  4.It's not known if she is diabetic.  5.She is an epileptic (diagnosed with a seizure disorder).  6.It's not known if she has a history of STROKE or brain tumor.  7.The jerking (twitching) has not stopped.  ProQA Dispatch Message Sent; Chief Complaint Number: 12; Dispatch Level: 12D02; Dispatch Level Suffix: E; Response Text: Delta  New ProQA Case Number has been assigned: -872546  Incident #: 2013-00000199",
        "CALL:FMALS-MEDIC AL",
        "ADDR:855 LOWER BELLBROOK RD",
        "X:BELLBROOK AVE / STERLING COMMONS BLVD",
        "CITY:XENIA TWP",
        "TIME:13:52",
        "UNIT:M52 E52",
        "NAME:NATIONWIDE BI WEEKLY ADMINISTRATION",
        "INFO:Problem: seizure.  Patient Info: 1 patient(s); 45 Years old; Female; Conscious: No; Breathing: Yes;  45 year old, Female, Unconscious, Breathing.  Convulsions / Seizures.  CONTINUOUS or MULTIPLE seizures  (Epileptic or Previous seizure diagnosis).  Caller Statement: seizure.  1.This is apparently a generalized (grand mal) seizure.  2.It's not known if she has had more than one seizure in a row.  3.It's not known if she is pregnant.  4.It's not known if she is diabetic.  5.She is an epileptic (diagnosed with a seizure disorder).  6.It's not known if she has a history of STROKE or brain tumor.  7.The jerking (twitching) has not stopped.  ProQA Dispatch Message Sent; Chief Complaint Number: 12; Dispatch Level: 12D02; Dispatch Level Suffix: E; Response Text: Delta  New ProQA Case Number has been assigned: -872546  Incident #: 2013-00000199");

    doTest("T8",
        "(Dispatch Info) FMBLS-MEDICAL Location: 1435 US 42 E BRUSH ROW RD / N BICKETT RD XENIA TWP Time: 11:36 Units: M51  Common Name: Info:  WATNS OFFICERS TO MEET AT SPEEDWAY  BLK JEEP  HE IS THERE ALONE  CRISIS ADVISING HE NEEDS TO GO TO HOSPITAL  MOTEHR HAS LEFT  BEIGN VIOLENT  HE IS BIPOLAR AND OFF MEDS  GRANT BOGGS  21 YOA SON  Incident #: 2013-00000294",
        "CALL:FMBLS-MEDICAL",
        "ADDR:1435 US 42",
        "X:E BRUSH ROW RD / N BICKETT RD",
        "CITY:XENIA TWP",
        "TIME:11:36",
        "UNIT:M51",
        "INFO:WATNS OFFICERS TO MEET AT SPEEDWAY  BLK JEEP  HE IS THERE ALONE  CRISIS ADVISING HE NEEDS TO GO TO HOSPITAL  MOTEHR HAS LEFT  BEIGN VIOLENT  HE IS BIPOLAR AND OFF MEDS  GRANT BOGGS  21 YOA SON  Incident #: 2013-00000294");

    doTest("T9",
        "(Dispatch Info) FIIN-INSIDE INVEST Location: 3198 OLD WINCHESTER TRL E SPRING VALLEY PAINTERSVILLE RD / MILL RD CAESARCREEK TWP Time: 10:43 Units: E52  Common Name: Info:  New ProQA Case Number has been assigned: -871969  Incident #: 2013-00000197",
        "CALL:FIIN-INSIDE INVEST",
        "ADDR:3198 OLD WINCHESTER TRL",
        "X:E SPRING VALLEY PAINTERSVILLE RD / MILL RD",
        "CITY:CAESARSCREEK TWP",
        "TIME:10:43",
        "UNIT:E52",
        "INFO:New ProQA Case Number has been assigned: -871969  Incident #: 2013-00000197");

    doTest("T10",
        "(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 1887 CONNECTICUT DR MONTANA DR / WISCONSIN DR XENIA Time: 06:33 Units: BAT30 CHF30 E32 E31 L31 M32 E51 E64A  Common Name: Info:  Incident #: 2013-00000966",
        "CALL:FRES-RESIDENTIAL FIRE",
        "ADDR:1887 CONNECTICUT DR",
        "X:MONTANA DR / WISCONSIN DR",
        "CITY:XENIA",
        "TIME:06:33",
        "UNIT:BAT30 CHF30 E32 E31 L31 M32 E51 E64A",
        "INFO:Incident #: 2013-00000966");

  }
  
  @Test
  public void testXeniaFire() {

    doTest("T1",
        "(Dispatch Info) FMALS-MEDIC AL Location: 600 LITTLE MAIN ST W SECOND ST / S ORANGE ST XENIA Time: 21:24 Units: M32  Common Name: DEERFIELD INNInfo:  ROOM  203  40 year old, Male, Conscious, Breathing.  Chest Pain (Non-Traumatic).  Clammy.  Caller Statement: CHEST PAIN.  1.He is completely alert (responding appropriately).  2.He is breathing normally.  3.He is not changing color.  4.He is clammy.  Problem: CHEST PAIN.  Patient Info: 1 patient(s); 40 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 10; Dispatch Level: 10D04; Response Text: Delta  New ProQA Case Number has been assigned: -899980  Incident #: 2013-00001748",
        "CALL:FMALS-MEDIC AL",
        "ADDR:600 LITTLE MAIN ST",
        "X:W SECOND ST / S ORANGE ST",
        "CITY:XENIA",
        "TIME:21:24",
        "UNIT:M32",
        "NAME:DEERFIELD INN",
        "INFO:ROOM  203  40 year old, Male, Conscious, Breathing.  Chest Pain (Non-Traumatic).  Clammy.  Caller Statement: CHEST PAIN.  1.He is completely alert (responding appropriately).  2.He is breathing normally.  3.He is not changing color.  4.He is clammy.  Problem: CHEST PAIN.  Patient Info: 1 patient(s); 40 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 10; Dispatch Level: 10D04; Response Text: Delta  New ProQA Case Number has been assigned: -899980  Incident #: 2013-00001748");

    doTest("T2",
        "(Dispatch Info) CRUI Location: 1900 WEST PARK SQ N PROGRESS DR, GREENE WAY BLVD / DEAD END XENIA Time: 18:09 Units: BAT30 E32 M34  Common Name: Info:  CALLER WAS PASSERBY  ON PROGRESS NEAR RURAL KING  Dispatch received by unit X39  Dispatch received by unit X25  WHITE CAR AND SILVER CAR  TWO CARS  Incident #: 2013-00009069",
        "CALL:CRUI",
        "ADDR:1900 WEST PARK SQ",
        "PLACE:N PROGRESS DR",
        "X:GREENE WAY BLVD / DEAD END",
        "CITY:XENIA",
        "TIME:18:09",
        "UNIT:BAT30 E32 M34",
        "INFO:CALLER WAS PASSERBY  ON PROGRESS NEAR RURAL KING  Dispatch received by unit X39  Dispatch received by unit X25  WHITE CAR AND SILVER CAR  TWO CARS  Incident #: 2013-00009069");

    doTest("T3",
        "(Dispatch Info) FMALS-MEDIC AL Location: 206 CODDINGTON AVE ARLINGTON DR / S DETROIT ST XENIA Time: 16:37 Units: M32  Common Name: Info:  Problem: BREATHING.  Patient Info: 1 patient(s); 1 Months old; Male; Conscious: Yes; Breathing: Yes;  1 month old, Male, Conscious, Breathing.  Breathing Problems.  DIFFICULTY SPEAKING BETWEEN BREATHS.  Caller Statement: BREATHING.  1.He is completely alert (responding appropriately).  2.He has difficulty crying between breaths.  ProQA Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: Delta  New ProQA Case Number has been assigned: -899822  Incident #: 2013-00001744",
        "CALL:FMALS-MEDIC AL",
        "ADDR:206 CODDINGTON AVE",
        "X:ARLINGTON DR / S DETROIT ST",
        "CITY:XENIA",
        "TIME:16:37",
        "UNIT:M32",
        "INFO:Problem: BREATHING.  Patient Info: 1 patient(s); 1 Months old; Male; Conscious: Yes; Breathing: Yes;  1 month old, Male, Conscious, Breathing.  Breathing Problems.  DIFFICULTY SPEAKING BETWEEN BREATHS.  Caller Statement: BREATHING.  1.He is completely alert (responding appropriately).  2.He has difficulty crying between breaths.  ProQA Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: Delta  New ProQA Case Number has been assigned: -899822  Incident #: 2013-00001744");

    doTest("T4",
        "(Dispatch Info) FMBLS-MEDICAL Location: 2365 TENNESSEE DR NEW YORK DR / NEW MEXICO DR XENIA Time: 14:14 Units: M32  Common Name: Info:  Problem: FALL.  Patient Info: 1 patient(s); 52 Years old; Male; Conscious: Yes; Breathing: Yes;  52 year old, Male, Conscious, Breathing.  Falls.  POSSIBLY DANGEROUS body area  (On the ground or floor).  Caller Statement: FALL.  1.This happened now (less than 6hrs ago).  2.It's reported that he fell at ground level.  3.The fall was accidental.  4.There is no bleeding now.  5.He is completely alert (responding appropriately).  6.The injury is to a POSSIBLY DANGEROUS area.  7.He is still on the floor (ground).  ProQA Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17B01; Dispatch Level Suffix: G; Response Text: Bravo  New ProQA Case Number has been assigned: -899761  Incident #: 2013-00001742",
        "CALL:FMBLS-MEDICAL",
        "ADDR:2365 TENNESSEE DR",
        "X:NEW YORK DR / NEW MEXICO DR",
        "CITY:XENIA",
        "TIME:14:14",
        "UNIT:M32",
        "INFO:Problem: FALL.  Patient Info: 1 patient(s); 52 Years old; Male; Conscious: Yes; Breathing: Yes;  52 year old, Male, Conscious, Breathing.  Falls.  POSSIBLY DANGEROUS body area  (On the ground or floor).  Caller Statement: FALL.  1.This happened now (less than 6hrs ago).  2.It's reported that he fell at ground level.  3.The fall was accidental.  4.There is no bleeding now.  5.He is completely alert (responding appropriately).  6.The injury is to a POSSIBLY DANGEROUS area.  7.He is still on the floor (ground).  ProQA Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17B01; Dispatch Level Suffix: G; Response Text: Bravo  New ProQA Case Number has been assigned: -899761  Incident #: 2013-00001742");

    doTest("T5",
        "(Dispatch Info) FMBLS-MEDICAL Location: 701 MT VERNON DR BEDFORD AVE / NEWPORT RD XENIA Time: 11:41 Units: M32  Common Name: Info:  66 year old, Male, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Dizziness/vertigo.  Caller Statement: dizziness.  1.He is completely alert (responding appropriately).  2.He is breathing normally.  3.He does not have any pain.  4.He is not bleeding (or vomiting blood).  5.His primary problem is dizziness/vertigo.  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26A03; Response Text: Alpha  Problem: dizziness.  Patient Info: 1 patient(s); 66 Years old; Male; Conscious: Yes; Breathing: Yes;  New ProQA Case Number has been assigned: -899699  Incident #: 2013-00001740",
        "CALL:FMBLS-MEDICAL",
        "ADDR:701 MT VERNON DR",
        "X:BEDFORD AVE / NEWPORT RD",
        "CITY:XENIA",
        "TIME:11:41",
        "UNIT:M32",
        "INFO:66 year old, Male, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Dizziness/vertigo.  Caller Statement: dizziness.  1.He is completely alert (responding appropriately).  2.He is breathing normally.  3.He does not have any pain.  4.He is not bleeding (or vomiting blood).  5.His primary problem is dizziness/vertigo.  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26A03; Response Text: Alpha  Problem: dizziness.  Patient Info: 1 patient(s); 66 Years old; Male; Conscious: Yes; Breathing: Yes;  New ProQA Case Number has been assigned: -899699  Incident #: 2013-00001740");

    doTest("T6",
        "(Dispatch Info) FMALS-MEDIC AL Location: 2224 HIGH WHEEL DR WRIGHT CYCLE BLVD / WRIGHT CYCLE BLVD XENIA Time: 09:31 Units: M32  Common Name: WRIGHT PLACEInfo:  LOBBY  ProQA Dispatch Message Sent; Chief Complaint Number: 31; Dispatch Level: 31D03; Response Text: Delta  75 year old, Female, Conscious, Breathing.  Unconscious / Fainting (Near).  Not alert.  Caller Statement: LOW BLOOD PRESSURE.  1.Her breathing is not completely normal.  2.She is not completely alert (not responding appropriately).  3.She is changing color.  4.Her color change is pale.  Problem: LOW BLOOD PRESSURE.  Patient Info: 1 patient(s); 75 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Case Number has been assigned: -899652  Incident #: 2013-00001739",
        "CALL:FMALS-MEDIC AL",
        "ADDR:2224 HIGH WHEEL DR",
        "X:WRIGHT CYCLE BLVD / WRIGHT CYCLE BLVD",
        "CITY:XENIA",
        "TIME:09:31",
        "UNIT:M32",
        "NAME:WRIGHT PLACE",
        "INFO:LOBBY  ProQA Dispatch Message Sent; Chief Complaint Number: 31; Dispatch Level: 31D03; Response Text: Delta  75 year old, Female, Conscious, Breathing.  Unconscious / Fainting (Near).  Not alert.  Caller Statement: LOW BLOOD PRESSURE.  1.Her breathing is not completely normal.  2.She is not completely alert (not responding appropriately).  3.She is changing color.  4.Her color change is pale.  Problem: LOW BLOOD PRESSURE.  Patient Info: 1 patient(s); 75 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Case Number has been assigned: -899652  Incident #: 2013-00001739");

    doTest("T7",
        "(Dispatch Info) FMBLS-MEDICAL Location: 489 CONARD DR BINGHAM DR / BERWALD DR XENIA Time: 20:36 Units: M31  Common Name: Info:  84 year old, Female, Conscious, Breathing.  Falls.  POSSIBLY DANGEROUS body area  (On the ground or floor).  Caller Statement: FELL.  1.This happened now (less than 6hrs ago).  2.It's reported that she fell at ground level.  3.The reason for the fall is not known.  4.There is no bleeding now.  5.She is completely alert (responding appropriately).  6.The injury is to the head.  7.She is still on the floor (ground).  ProQA Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17B01; Dispatch Level Suffix: G; Response Text: Bravo  Problem: FELL.  Patient Info: 1 patient(s); 84 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Case Number has been assigned: -899378  Incident #: 2013-00001737",
        "CALL:FMBLS-MEDICAL",
        "ADDR:489 CONARD DR",
        "X:BINGHAM DR / BERWALD DR",
        "CITY:XENIA",
        "TIME:20:36",
        "UNIT:M31",
        "INFO:84 year old, Female, Conscious, Breathing.  Falls.  POSSIBLY DANGEROUS body area  (On the ground or floor).  Caller Statement: FELL.  1.This happened now (less than 6hrs ago).  2.It's reported that she fell at ground level.  3.The reason for the fall is not known.  4.There is no bleeding now.  5.She is completely alert (responding appropriately).  6.The injury is to the head.  7.She is still on the floor (ground).  ProQA Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17B01; Dispatch Level Suffix: G; Response Text: Bravo  Problem: FELL.  Patient Info: 1 patient(s); 84 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Case Number has been assigned: -899378  Incident #: 2013-00001737");

    doTest("T8",
        "(Dispatch Info) FMALS-MEDIC AL Location: 1445 PAVEY PL COUNTRY CLUB DR / DEE ANNE DR XENIA Time: 19:55 Units: M32 E31  Common Name: Info:  2.She is unwell/ill.  Problem: SICK.  Patient Info: 1 patient(s); 94 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Key Questions have been completed; Chief Complaint Number: 26; Dispatch Level: 26D01; Response Text: Delta  94 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Not alert.  Caller Statement: SICK.  1.She is not completely alert (not responding appropriately).  Problem: SICK.  Patient Info: 1 patient(s); 94 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26D01; Response Text: Delta  New ProQA Case Number has been assigned: -899353  Incident #: 2013-00001736",
        "CALL:FMALS-MEDIC AL",
        "ADDR:1445 PAVEY PL",
        "X:COUNTRY CLUB DR / DEE ANNE DR",
        "CITY:XENIA",
        "TIME:19:55",
        "UNIT:M32 E31",
        "INFO:2.She is unwell/ill.  Problem: SICK.  Patient Info: 1 patient(s); 94 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Key Questions have been completed; Chief Complaint Number: 26; Dispatch Level: 26D01; Response Text: Delta  94 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Not alert.  Caller Statement: SICK.  1.She is not completely alert (not responding appropriately).  Problem: SICK.  Patient Info: 1 patient(s); 94 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26D01; Response Text: Delta  New ProQA Case Number has been assigned: -899353  Incident #: 2013-00001736");

    doTest("T9",
        "(Dispatch Info) FMBLS-MEDICAL Location: 1243 ARLINGTON DR HERITAGE LN / LEDBETTER RD XENIA Time: 19:02 Units: M31  Common Name: Info:  ProQA Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17B01; Dispatch Level Suffix: G; Response Text: Bravo  Problem: FALL.  Patient Info: 1 patient(s); 76 Years old; Female; Conscious: Yes; Breathing: Yes;  76 year old, Female, Conscious, Breathing.  Falls.  POSSIBLY DANGEROUS body area  (On the ground or floor).  Caller Statement: FALL.  1.This happened now (less than 6hrs ago).  2.It's reported that she fell at ground level.  3.The fall was accidental.  4.There is no bleeding now.  5.She is completely alert (responding appropriately).  6.The injury is to a POSSIBLY DANGEROUS area.  7.She is still on the floor (ground).  New ProQA Case Number has been assigned: -899326  Incident #: 2013-00001735",
        "CALL:FMBLS-MEDICAL",
        "ADDR:1243 ARLINGTON DR",
        "X:HERITAGE LN / LEDBETTER RD",
        "CITY:XENIA",
        "TIME:19:02",
        "UNIT:M31",
        "INFO:ProQA Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17B01; Dispatch Level Suffix: G; Response Text: Bravo  Problem: FALL.  Patient Info: 1 patient(s); 76 Years old; Female; Conscious: Yes; Breathing: Yes;  76 year old, Female, Conscious, Breathing.  Falls.  POSSIBLY DANGEROUS body area  (On the ground or floor).  Caller Statement: FALL.  1.This happened now (less than 6hrs ago).  2.It's reported that she fell at ground level.  3.The fall was accidental.  4.There is no bleeding now.  5.She is completely alert (responding appropriately).  6.The injury is to a POSSIBLY DANGEROUS area.  7.She is still on the floor (ground).  New ProQA Case Number has been assigned: -899326  Incident #: 2013-00001735");

    doTest("T10",
        "(Dispatch Info) FMBLS-MEDICAL Location: 135 E  CHURCH ST N COLLIER ST, EDISON BLVD / N WHITEMAN ST XENIA Time: 17:29 Units: M31  Common Name: YMCAInfo:  DIFF BREATHING  IN DIRECTORS OFFICE  Dispatch received by unit X64  KATHEE FORREST  Incident #: 2013-00008990",
        "CALL:FMBLS-MEDICAL",
        "ADDR:135 E CHURCH ST",
        "PLACE:N COLLIER ST",
        "X:EDISON BLVD / N WHITEMAN ST",
        "CITY:XENIA",
        "TIME:17:29",
        "UNIT:M31",
        "NAME:YMCA",
        "INFO:DIFF BREATHING  IN DIRECTORS OFFICE  Dispatch received by unit X64  KATHEE FORREST  Incident #: 2013-00008990");
 
  }
  
  @Test
  public void testXeniaTwp2() {

    doTest("T1",
        "(Dispatch Info) FMBLS-MEDICAL Location: 2065 SR 235 HILLTOP RD / US 68 N XENIA TWP Time: 20:45 Units: M51  Common Name: Info:  89 year old, Female, Conscious, Breathing.  Unconscious / Fainting (Near).  Fainting episode(s) and alert => 35 (without cardiac history).  Caller Statement: DIZZY.  1.Her breathing is completely normal.  2.She is completely alert (responding appropriately).  3.She is not changing color.  4.She has no history of heart problems.  Problem: DIZZY.  Patient Info: 1 patient(s); 89 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 31; Dispatch Level: 31A01; Response Text: Alpha  New ProQA Case Number has been assigned: -899952  E911 Info - Class of Service: RESD Special Response Info: XENIA TWP FD D-1  Incident #: 2013-00000346",
        "CALL:FMBLS-MEDICAL",
        "ADDR:2065 SR 235",
        "MADDR:2065 OH 235",
        "X:HILLTOP RD / US 68 N",
        "CITY:XENIA TWP",
        "TIME:20:45",
        "UNIT:M51",
        "INFO:89 year old, Female, Conscious, Breathing.  Unconscious / Fainting (Near).  Fainting episode(s) and alert => 35 (without cardiac history).  Caller Statement: DIZZY.  1.Her breathing is completely normal.  2.She is completely alert (responding appropriately).  3.She is not changing color.  4.She has no history of heart problems.  Problem: DIZZY.  Patient Info: 1 patient(s); 89 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 31; Dispatch Level: 31A01; Response Text: Alpha  New ProQA Case Number has been assigned: -899952  E911 Info - Class of Service: RESD Special Response Info: XENIA TWP FD D-1  Incident #: 2013-00000346");

    doTest("T2",
        "(Dispatch Info) FMALS-MEDIC AL Location: 1525 E HOOP RD HOOP RD, S BICKETT RD / COOPER LN XENIA TWP Time: 10:02 Units: M52 E52  Common Name: Info:  3.She is not clammy.  4.She does not have asthma.  5.N/A  ProQA Key Questions have been completed; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: Delta  Problem: panic attack.  Patient Info: 1 patient(s); 53 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: Delta  Problem: panic attack.  Patient Info: 1 patient(s); 53 Years old; Female; Conscious: Yes; Breathing: Yes;  53 year old, Female, Conscious, Breathing.  Breathing Problems.  DIFFICULTY SPEAKING BETWEEN BREATHS.  Caller Statement: panic attack.  1.She is completely alert (responding appropriately).  2.She has difficulty speaking between breaths.  New ProQA Case Number has been assigned: -899667  Incident #: 2013-00000345",
        "CALL:FMALS-MEDIC AL",
        "ADDR:1525 E HOOP RD",
        "PLACE:HOOP RD",
        "X:S BICKETT RD / COOPER LN",
        "CITY:XENIA TWP",
        "TIME:10:02",
        "UNIT:M52 E52",
        "INFO:3.She is not clammy.  4.She does not have asthma.  5.N/A  ProQA Key Questions have been completed; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: Delta  Problem: panic attack.  Patient Info: 1 patient(s); 53 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: Delta  Problem: panic attack.  Patient Info: 1 patient(s); 53 Years old; Female; Conscious: Yes; Breathing: Yes;  53 year old, Female, Conscious, Breathing.  Breathing Problems.  DIFFICULTY SPEAKING BETWEEN BREATHS.  Caller Statement: panic attack.  1.She is completely alert (responding appropriately).  2.She has difficulty speaking between breaths.  New ProQA Case Number has been assigned: -899667  Incident #: 2013-00000345");

    doTest("T3",
        "(Dispatch Info) FMALS-MEDIC AL Location: 338 GREEN ACRES DR OAK DALE DR / OAK DALE DR XENIA TWP Time: 09:40 Units:  Common Name: Info:  Problem: vomiting blood.  Patient Info: 1 patient(s); 78 Years old; Male; Conscious: Yes; Breathing: Yes;  78 year old, Male, Conscious, Breathing.  Hemorrhage / Lacerations.  Abnormal breathing.  Caller Statement: vomiting blood.  1.He is completely alert (responding appropriately).  2.He is not breathing normally.  3.He has other pain: esophagus is burning and pain in lower back  ^    4.He is bleeding (or vomiting blood). (Change from Protocol #26)  5.The cause of the bleeding is non-traumatic.  6.He is vomiting blood.  7.He is completely alert (responding appropriately).  8.He is not breathing normally.  9.There is no SERIOUS bleeding.  10.He does not have a bleeding disorder or is taking blood thinners.  -Comments: esophagus is burning and pain in lower back-  ProQA Dispatch Message Sent; Chief Complaint Number: 21; Dispatch Level: 21D04; Response Text: Delta  New ProQA Case Number has been assigned: -899658  Incident #: 2013-00000344",
        "CALL:FMALS-MEDIC AL",
        "ADDR:338 GREEN ACRES DR",
        "X:OAK DALE DR / OAK DALE DR",
        "CITY:XENIA TWP",
        "TIME:09:40",
        "INFO:Problem: vomiting blood.  Patient Info: 1 patient(s); 78 Years old; Male; Conscious: Yes; Breathing: Yes;  78 year old, Male, Conscious, Breathing.  Hemorrhage / Lacerations.  Abnormal breathing.  Caller Statement: vomiting blood.  1.He is completely alert (responding appropriately).  2.He is not breathing normally.  3.He has other pain: esophagus is burning and pain in lower back  ^    4.He is bleeding (or vomiting blood). (Change from Protocol #26)  5.The cause of the bleeding is non-traumatic.  6.He is vomiting blood.  7.He is completely alert (responding appropriately).  8.He is not breathing normally.  9.There is no SERIOUS bleeding.  10.He does not have a bleeding disorder or is taking blood thinners.  -Comments: esophagus is burning and pain in lower back-  ProQA Dispatch Message Sent; Chief Complaint Number: 21; Dispatch Level: 21D04; Response Text: Delta  New ProQA Case Number has been assigned: -899658  Incident #: 2013-00000344");

    doTest("T4",
        "(Dispatch Info) FMBLS-MEDICAL Location: 338 GREEN ACRES DR OAK DALE DR / OAK DALE DR XENIA TWP Time: 09:40 Units: M51  Common Name: Info:  New ProQA Case Number has been assigned: -899658  Incident #: 2013-00000344",
        "CALL:FMBLS-MEDICAL",
        "ADDR:338 GREEN ACRES DR",
        "X:OAK DALE DR / OAK DALE DR",
        "CITY:XENIA TWP",
        "TIME:09:40",
        "UNIT:M51",
        "INFO:New ProQA Case Number has been assigned: -899658  Incident #: 2013-00000344");

    doTest("T5",
        "(Dispatch Info) FRES-RESIDENTIAL FIRE Location: 76 POCAHONTAS ST ORMSBY DR / S DETROIT ST XENIA Time: 19:10 Units: E31 E32 E51 E11 L31 M32 BAT30 CHF30  Common Name: Info:  SMOKE COMING OUT WINDOWS AND FRONT DOOR  Incident #: 2013-00001722",
        "CALL:FRES-RESIDENTIAL FIRE",
        "ADDR:76 POCAHONTAS ST",
        "X:ORMSBY DR / S DETROIT ST",
        "CITY:XENIA",
        "TIME:19:10",
        "UNIT:E31 E32 E51 E11 L31 M32 BAT30 CHF30",
        "INFO:SMOKE COMING OUT WINDOWS AND FRONT DOOR  Incident #: 2013-00001722");

    doTest("T6",
        "(Dispatch Info) CREN Location: 303 KINSEY RD AMLIN DR / YELLOWSTONE RD XENIA Time: 09:17 Units: M51 R52  Common Name: XENIA HIGH SCHOOLInfo:  Dispatch received by unit CHF30  Incident #: 2013-00001710",
        "CALL:CREN",
        "ADDR:303 KINSEY RD",
        "X:AMLIN DR / YELLOWSTONE RD",
        "CITY:XENIA",
        "TIME:09:17",
        "UNIT:M51 R52",
        "NAME:XENIA HIGH SCHOOL",
        "INFO:Dispatch received by unit CHF30  Incident #: 2013-00001710");

    doTest("T7",
        "(Dispatch Info) FSCE-SERVICE CALL-ENGINE Location: 1038 OLD SPRINGFIELD PIKE SEXTON DR / TEMPLE DR XENIA TWP Time: 23:49 Units: E51  Common Name: Info:  stove is fire hazzard  Incident #: 2013-00000341",
        "CALL:FSCE-SERVICE CALL-ENGINE",
        "ADDR:1038 OLD SPRINGFIELD PIKE",
        "X:SEXTON DR / TEMPLE DR",
        "CITY:XENIA TWP",
        "TIME:23:49",
        "UNIT:E51",
        "INFO:stove is fire hazzard  Incident #: 2013-00000341");

    doTest("T8",
        "(Dispatch Info) CRUI Location: OLD US 35 W, OLD US 35 W TO US 35 E / W MAIN ST, HOSPITALITY DR XENIA TWP Time: 16:41 Units: E51 M51 CHF50  Common Name: US 35 BYPASS SPLITInfo:  2 VEH  JUST BEFORE MERGE TO ONE LANE  Incident #: 2013-00000340",
        "CALL:CRUI",
        "ADDR:OLD US 35",
        "MADDR:OLD US 35 & OLD US 35 W TO US 35 E",
        "PLACE:W",
        "X:OLD US 35 W TO US 35 E / W MAIN ST, HOSPITALITY DR",
        "CITY:XENIA TWP",
        "TIME:16:41",
        "UNIT:E51 M51 CHF50",
        "NAME:US 35 BYPASS SPLIT",
        "INFO:2 VEH  JUST BEFORE MERGE TO ONE LANE  Incident #: 2013-00000340");

    doTest("T9",
        "(Dispatch Info) FMBLS-MEDICAL Location: 1300 E SPRING VALLEY PAINTERSVILLE RD LEWIS RD / OLD WINCHESTER TRL CAESARCREEK TWP Time: 13:09 Units: M52  Common Name: Info:  Problem: fall.  Patient Info: 1 patient(s); 65 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 31; Dispatch Level: 31A01; Response Text: Alpha  65 year old, Male, Conscious, Breathing.  Unconscious / Fainting (Near).  Fainting episode(s) and alert => 35 (without cardiac history).  Caller Statement: fall.  1.This happened more than 6hrs ago.  2.It's reported that he fell at ground level.  ^    3.The fall was caused by dizziness. (Change from Protocol #17)  4.His breathing is completely normal.  5.He is completely alert (responding appropriately).  6.He is not changing color.  7.He has no history of heart problems.  New ProQA Case Number has been assigned: -897873  Incident #: 2013-00000339",
        "CALL:FMBLS-MEDICAL",
        "ADDR:1300 E SPRING VALLEY PAINTERSVILLE RD",
        "X:LEWIS RD / OLD WINCHESTER TRL",
        "CITY:CAESARSCREEK TWP",
        "TIME:13:09",
        "UNIT:M52",
        "INFO:Problem: fall.  Patient Info: 1 patient(s); 65 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 31; Dispatch Level: 31A01; Response Text: Alpha  65 year old, Male, Conscious, Breathing.  Unconscious / Fainting (Near).  Fainting episode(s) and alert => 35 (without cardiac history).  Caller Statement: fall.  1.This happened more than 6hrs ago.  2.It's reported that he fell at ground level.  ^    3.The fall was caused by dizziness. (Change from Protocol #17)  4.His breathing is completely normal.  5.He is completely alert (responding appropriately).  6.He is not changing color.  7.He has no history of heart problems.  New ProQA Case Number has been assigned: -897873  Incident #: 2013-00000339");

    doTest("T10",
        "(Dispatch Info) FMALS-MEDIC AL Location: 170 OUTERVIEW DR YELLOWSTONE RD / HILLCREST DR XENIA TWP Time: 09:37 Units: M51 E51  Common Name: Info:  76 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Not alert.  Caller Statement: CLAMMY.  1.She is not completely alert (not responding appropriately).  Problem: CLAMMY.  Patient Info: 1 patient(s); 76 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26D01; Response Text: Delta  New ProQA Case Number has been assigned: -897233  Incident #: 2013-00000338",
        "CALL:FMALS-MEDIC AL",
        "ADDR:170 OUTERVIEW DR",
        "X:YELLOWSTONE RD / HILLCREST DR",
        "CITY:XENIA TWP",
        "TIME:09:37",
        "UNIT:M51 E51",
        "INFO:76 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Not alert.  Caller Statement: CLAMMY.  1.She is not completely alert (not responding appropriately).  Problem: CLAMMY.  Patient Info: 1 patient(s); 76 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26D01; Response Text: Delta  New ProQA Case Number has been assigned: -897233  Incident #: 2013-00000338");

  }
  
  @Test
  public void testSteveMathis() {

    doTest("T1",
        "(Dispatch Info) FMBLS-MEDICAL Location: 486 CINCINNATI AVE SHORT ST / CENTER ST XENIA Time: 23:08 Units: M31  Common Name: Info:  Dispatch received by",
        "CALL:FMBLS-MEDICAL",
        "ADDR:486 CINCINNATI AVE",
        "X:SHORT ST / CENTER ST",
        "CITY:XENIA",
        "TIME:23:08",
        "UNIT:M31",
        "INFO:Dispatch received by");

  }
  
  public static void main(String[] args) {
    new OHGreeneCountyParserTest().generateTests("T1");
  }
}
