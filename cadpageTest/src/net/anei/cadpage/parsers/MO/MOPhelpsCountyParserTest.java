package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Phelps County, MO


Contact: Active911
(Incident# : 13126E15 For Activity Finish Resource) \n\rCase# :- 13000086\n\rJulian Incident# :- 13126E15\n\rPriority :- 3\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- R-Radio\n\rPrimary Officer :- AEJ996-Amanda Jones\n\rAgency Code :- SJA\n\rCFS :- AMBT\n\rCFS Description :- Ambulance Transport\n\rLocation :- 34 FAKE\n\rCommon Place :- MISSOURI BAPTIST - SULLIVAN\n\rCross Streets :-  / \n\rZone :- 997\n\rArea Of Responsibility :- 97\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- A-No Report\n\rIncident Recv DateTime :- 05/06/2013 21:16:36\n\rDispatch DateTime :- 05/06/2013 21:16:36\n\rArrive DateTime :- 05/06/2013 21:16:36\n\rFinish/Clear DateTime :- 5/6/2013 11:49:49 PM\n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/06/2013 21:16:38\n\rOrigin ID :- AEJ996\n\rComment :- VS Call: \n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2227\n\rResource Status :- ER\n\rStatus DateTime :- 05/06/2013 21:17:04\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2227\n\rResource Status :- FI\n\rStatus DateTime :- 05/06/2013 23:49:49\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2227\n\rResource Status :- AR\n\rStatus DateTime :- 05/06/2013 21:42:10\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2227\n\rResource Status :- VS\n\rStatus DateTime :- 05/06/2013 21:16:37\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2227\n\rResource Status :- EP\n\rStatus DateTime :- 05/06/2013 21:56:34\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13126E14 For Activity Finish Resource) \n\rCase# :- 13000085\n\rJulian Incident# :- 13126E14\n\rPriority :- 2\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- AEJ996-Amanda Jones\n\rAgency Code :- SJA\n\rCFS :- AMB\n\rCFS Description :- Ambulance Needed\n\rLocation :- 17795 COUNTY RD 1060\n\rCommon Place :- \n\rCross Streets :- PRIVATE DR 1063 / STATE ROUTE B\n\rZone :- 512\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- A-No Report\n\rIncident Recv DateTime :- 05/06/2013 21:07:54\n\rDispatch DateTime :- 05/06/2013 21:10:28\n\rArrive DateTime :- 05/06/2013 21:18:09\n\rFinish/Clear DateTime :- 5/6/2013 9:49:35 PM\n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/06/2013 21:08:15\n\rOrigin ID :- AEJ996\n\rComment :- SUBJECT IN SEVERE BACK PAIN DUE TO A PROCEDURE DONE ON THE BACK. IT WAS SOME TYPE OF ELECTRIC SHOCK TREATMENT. 49 YO MALE. ADDRESS IS MARKED.\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- GALE\n\rLast Name :- DUCKWORTH\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5732650260\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2247\n\rResource Status :- ES\n\rStatus DateTime :- 05/06/2013 21:35:59\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2247\n\rResource Status :- AR\n\rStatus DateTime :- 05/06/2013 21:18:09\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2247\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 21:12:53\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2200\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 21:10:28\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2247\n\rResource Status :- FI\n\rStatus DateTime :- 05/06/2013 21:49:35\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13126E7 For Activity Finish Resource) \n\rCase# :- 13000084\n\rJulian Incident# :- 13126E7\n\rPriority :- 3\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- R-Radio\n\rPrimary Officer :- cja913-Crystal Allen\n\rAgency Code :- SJA\n\rCFS :- AMBT\n\rCFS Description :- Ambulance Transport\n\rLocation :- 415 SIDNEY ST\n\rCommon Place :- GOLDEN LIVING CENTER\n\rCross Streets :- N JEFFERSON ST / AMANDA AV\n\rZone :- 504\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- A-No Report\n\rIncident Recv DateTime :- 05/06/2013 10:54:58\n\rDispatch DateTime :- 05/06/2013 10:55:07\n\rArrive DateTime :- 05/06/2013 11:07:33\n\rFinish/Clear DateTime :- 5/6/2013 12:01:20 PM\n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/06/2013 11:45:55\n\rOrigin ID :- cja913\n\rComment :- ENROUTE AT 1131\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2247\n\rResource Status :- EH\n\rStatus DateTime :- 05/06/2013 10:55:22\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2247\n\rResource Status :- AP\n\rStatus DateTime :- 05/06/2013 11:45:55\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2247\n\rResource Status :- AH\n\rStatus DateTime :- 05/06/2013 11:07:33\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2247\n\rResource Status :- FI\n\rStatus DateTime :- 05/06/2013 12:01:20\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2247\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 10:55:07\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------

Contact: Active911
Agency name: St. James Ambulance District
Location: St. James, MO, United States
Sender: projects@computerra.com

(Incident# : 13126E18 For Activity Dispatch Resource) \n\rCase# :- 13000087\n\rJulian Incident# :- 13126E18\n\rPriority :- 2\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- AEJ996-Amanda Jones\n\rAgency Code :- SJA\n\rCFS :- AMB\n\rCFS Description :- Ambulance Needed\n\rLocation :- 330 E HARDY ST\n\rCommon Place :- \n\rCross Streets :- S WISHON ST / EMORY ST\n\rZone :- 504\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- A-No Report\n\rIncident Recv DateTime :- 05/06/2013 23:27:30\n\rDispatch DateTime :- 05/06/2013 23:29:02\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/06/2013 23:27:44\n\rOrigin ID :- MDG976\n\rComment :- BLOOD PRESSURE IS 159/119 PULSE IS 116\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- GRACIE\n\rLast Name :- WEIKOFF\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5732653228\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2200\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 23:29:02\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2247\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 23:29:27\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13126E14 For Activity Dispatch Resource) \n\rCase# :- 13000085\n\rJulian Incident# :- 13126E14\n\rPriority :- 2\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- AEJ996-Amanda Jones\n\rAgency Code :- SJA\n\rCFS :- AMB\n\rCFS Description :- Ambulance Needed\n\rLocation :- 17795 COUNTY RD 1060\n\rCommon Place :- \n\rCross Streets :- PRIVATE DR 1063 / STATE ROUTE B\n\rZone :- 512\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- A-No Report\n\rIncident Recv DateTime :- 05/06/2013 21:07:54\n\rDispatch DateTime :- 05/06/2013 21:10:28\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/06/2013 21:08:15\n\rOrigin ID :- AEJ996\n\rComment :- SUBJECT IN SEVERE BACK PAIN DUE TO A PROCEDURE DONE ON THE BACK. IT WAS SOME TYPE OF ELECTRIC SHOCK TREATMENT. 49 YO MALE. ADDRESS IS MARKED.\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- GALE\n\rLast Name :- DUCKWORTH\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5732650260\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2200\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 21:10:28\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2247\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 21:12:53\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13126E7 For Activity Dispatch Resource) \n\rCase# :- 13000084\n\rJulian Incident# :- 13126E7\n\rPriority :- 3\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- R-Radio\n\rPrimary Officer :- cja913-Crystal Allen\n\rAgency Code :- SJA\n\rCFS :- AMBT\n\rCFS Description :- Ambulance Transport\n\rLocation :- 415 SIDNEY ST\n\rCommon Place :- GOLDEN LIVING CENTER\n\rCross Streets :- N JEFFERSON ST / AMANDA AV\n\rZone :- 504\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- A-No Report\n\rIncident Recv DateTime :- 05/06/2013 10:54:58\n\rDispatch DateTime :- 05/06/2013 10:55:07\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2247\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 10:55:07\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13125E8 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13125E8\n\rPriority :- 1\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- AEJ996-Amanda Jones\n\rAgency Code :- SJA\n\rCFS :- MENTAL\n\rCFS Description :- Mental Health\n\rLocation :- 414 SAINT FRANCIS AV\n\rCommon Place :- \n\rCross Streets :- WALTERS ST / SAINT JOHNS AV\n\rZone :- 504\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/05/2013 17:00:43\n\rDispatch DateTime :- 05/05/2013 17:05:53\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/05/2013 17:00:05\n\rOrigin ID :- TAG908\n\rComment :- chev s10 blk maya gets headed to chris fitsgeralds house. she slit her wrists. because her boyfriend was screaming at her.\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- Sheryl\n\rLast Name :- Derrick\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5732639571\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2200\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 17:05:53\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2257\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 17:07:11\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13125E6 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13125E6\n\rPriority :- 1\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- cja913-Crystal Allen\n\rAgency Code :- SJA\n\rCFS :- 50J2\n\rCFS Description :- Accident  Injury\n\rLocation :- 193 W I44\n\rCommon Place :- \n\rCross Streets :-  / \n\rZone :- WH5\n\rArea Of Responsibility :- AM\n\rJuris :- \n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/05/2013 15:02:32\n\rDispatch DateTime :- 05/05/2013 15:04:49\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/05/2013 15:02:52\n\rOrigin ID :- cja913\n\rComment :- WHITE PC IN THE MEDIAN JUST SLID OF THE ROAD\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- BRENT\n\rLast Name :- OHLENBROF\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 8157390586\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2200\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 15:04:49\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2257\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 15:07:11\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13125E7 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13125E7\n\rPriority :- 6\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- M-Mail\n\rPrimary Officer :- cja913-Crystal Allen\n\rAgency Code :- SJA\n\rCFS :- REMIND\n\rCFS Description :- Special Reminder\n\rLocation :- 1007 N ELM ST\n\rCommon Place :- RPD\n\rCross Streets :- W 10TH ST / W 11TH ST\n\rZone :- 999\n\rArea Of Responsibility :- 99\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 04/30/2013 15:00:00\n\rDispatch DateTime :- 05/05/2013 15:05:59\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2257\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 15:05:59\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13125E5 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13125E5\n\rPriority :- 1\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- cja913-Crystal Allen\n\rAgency Code :- SJA\n\rCFS :- 50J2\n\rCFS Description :- Accident  Injury\n\rLocation :- 195 E I44\n\rCommon Place :- \n\rCross Streets :-  / \n\rZone :- EH5\n\rArea Of Responsibility :- AM\n\rJuris :- \n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/05/2013 13:34:38\n\rDispatch DateTime :- 05/05/2013 13:36:31\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/05/2013 13:35:07\n\rOrigin ID :- cja913\n\rComment :- NAVY BLUE VEH OFF THE SHOULDER UNKNOWN INJURIES ONE VEH\n\r ---------------------------------------------------------------------------------\n\rComment DateTime :- 05/05/2013 13:38:11\n\rOrigin ID :- cja913\n\rComment :- PER 2201 THIS IS IN THE MEDIAN\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2200\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 13:36:31\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2247\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 13:38:06\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123E24 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123E24\n\rPriority :- 2\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- KLL911-Keri Lloyd\n\rAgency Code :- SJA\n\rCFS :- AMB\n\rCFS Description :- Ambulance Needed\n\rLocation :- 19085 PVT1255\n\rCommon Place :- \n\rCross Streets :- STATE ROUTE EE / DEAD END\n\rZone :- 512\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 20:20:46\n\rDispatch DateTime :- 05/03/2013 20:26:14\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/03/2013 20:21:15\n\rOrigin ID :- KLL911\n\rComment :- PH1 HANGUP - CALLED BACK, SHE HAS A 10 DAY OLD BABY CANT KEEP LIQUIDS DOWN - CONCIOUS AND ALERT, STARTED TODAY OFF AND ON ALL DAY, NO VOMITTING - ITS OFF HWY EE - 2ND DRIVE ON LEFT, THERE IS A RED GATE AND IT IS MARKED\n\r ---------------------------------------------------------------------------------\n\rComment DateTime :- 05/03/2013 20:24:35\n\rOrigin ID :- KLL911\n\rComment :- NO FEVER\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- TAMMY\n\rLast Name :- MORELAND\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 4173159698\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2257\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 20:30:17\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2200\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 20:26:14\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123E24 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123E24\n\rPriority :- 2\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- KLL911-Keri Lloyd\n\rAgency Code :- SJA\n\rCFS :- AMB\n\rCFS Description :- Ambulance Needed\n\rLocation :- 19085 PVT1255\n\rCommon Place :- \n\rCross Streets :- STATE ROUTE EE / DEAD END\n\rZone :- 512\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 20:20:46\n\rDispatch DateTime :- 05/03/2013 20:26:14\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/03/2013 20:21:15\n\rOrigin ID :- KLL911\n\rComment :- PH1 HANGUP - CALLED BACK, SHE HAS A 10 DAY OLD BABY CANT KEEP LIQUIDS DOWN - CONCIOUS AND ALERT, STARTED TODAY OFF AND ON ALL DAY, NO VOMITTING - ITS OFF HWY EE - 2ND DRIVE ON LEFT, THERE IS A RED GATE AND IT IS MARKED\n\r ---------------------------------------------------------------------------------\n\rComment DateTime :- 05/03/2013 20:24:35\n\rOrigin ID :- KLL911\n\rComment :- NO FEVER\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- TAMMY\n\rLast Name :- MORELAND\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 4173159698\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2200\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 20:26:14\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123E22 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123E22\n\rPriority :- 2\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- jls917-Jeff Stokes\n\rAgency Code :- SJA\n\rCFS :- AMB\n\rCFS Description :- Ambulance Needed\n\rLocation :- 21749 COUNTY RD 1000\n\rCommon Place :- \n\rCross Streets :- STATE ROUTE U / COUNTY RD 1190\n\rZone :- 512\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 19:23:21\n\rDispatch DateTime :- 05/03/2013 19:24:26\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/03/2013 19:23:31\n\rOrigin ID :- jls917\n\rComment :- 65Y/O FEMALE, HIGH FEVER, CANNOT SIT OR STAND, SHAKING.\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- GRACE\n\rLast Name :- FITSIMMONS\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5734652267\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2257\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 19:28:48\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2200\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 19:24:26\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123E23 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123E23\n\rPriority :- 3\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- KLL911-Keri Lloyd\n\rAgency Code :- SJA\n\rCFS :- TH\n\rCFS Description :- Telephone Harass.\n\rLocation :- 1206 E 18TH ST\n\rCommon Place :- \n\rCross Streets :- FARRAR DR / FORUM DR\n\rZone :- 999\n\rArea Of Responsibility :- 99\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 19:05:09\n\rDispatch DateTime :- 05/03/2013 19:27:38\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2257\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 19:27:38\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123E22 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123E22\n\rPriority :- 2\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- jls917-Jeff Stokes\n\rAgency Code :- SJA\n\rCFS :- AMB\n\rCFS Description :- Ambulance Needed\n\rLocation :- 21749 COUNTY RD 1000\n\rCommon Place :- \n\rCross Streets :- STATE ROUTE U / COUNTY RD 1190\n\rZone :- 512\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 19:23:21\n\rDispatch DateTime :- 05/03/2013 19:24:26\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/03/2013 19:23:31\n\rOrigin ID :- jls917\n\rComment :- 65Y/O FEMALE, HIGH FEVER, CANNOT SIT OR STAND, SHAKING.\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- GRACE\n\rLast Name :- FITSIMMONS\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5734652267\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2200\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 19:24:26\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123E12 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123E12\n\rPriority :- 1\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- JLJ978-Jamie Jones\n\rAgency Code :- SJA\n\rCFS :- 50J2\n\rCFS Description :- Accident  Injury\n\rLocation :- 22050 STATE ROUTE KK\n\rCommon Place :- ROSATI WINERY\n\rCross Streets :- 90DEG / RAILROAD TRACKS\n\rZone :- 512\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 14:19:32\n\rDispatch DateTime :- 05/03/2013 14:21:38\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/03/2013 14:20:09\n\rOrigin ID :- JLJ978\n\rComment :- VEHICLE OFF THE ROAD UNSURE OF INJURIES\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- \n\rLast Name :- ANONYMOUS\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- \n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2200\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 14:21:38\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2257\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 14:23:18\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123E6 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123E6\n\rPriority :- 2\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- PMV920-Paula Volkmer\n\rAgency Code :- SJA\n\rCFS :- AMB\n\rCFS Description :- Ambulance Needed\n\rLocation :- 620 N JEFFERSON ST\n\rCommon Place :- MISSOURI VETERANS HOME\n\rCross Streets :- AIDA ST / MARCELLA ST\n\rZone :- 504\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 11:08:41\n\rDispatch DateTime :- 05/03/2013 11:11:51\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/03/2013 11:09:22\n\rOrigin ID :- PMV920\n\rComment :- in the clinic...68 YROLD WITH CHEST PAINS\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- TIFFANY\n\rLast Name :- UNKNOWN\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5732650339\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2257\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 11:14:16\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2200\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 11:11:51\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123E3 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123E3\n\rPriority :- 2\n\rAgency Type :- E\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- jls917-Jeff Stokes\n\rAgency Code :- SJA\n\rCFS :- AMB\n\rCFS Description :- Ambulance Needed\n\rLocation :- 422 SAINT FRANCIS AV\n\rCommon Place :- \n\rCross Streets :- SAINT JOHNS AV / SAINT FRANCIS CR\n\rZone :- 504\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 05:20:59\n\rDispatch DateTime :- 05/03/2013 05:23:01\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/03/2013 05:21:06\n\rOrigin ID :- jls917\n\rComment :- RP'S LEG ARE NOT WORKING RIGHT. THEY FEEL FUNNY AND HER BALANCE IS OFF. BURNING IN HER STOMACH.\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- MICHELLE\n\rLast Name :- MONTGOMERY\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 9112048790\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 2200\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 05:23:01\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 2257\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 05:27:36\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------

Contact: Active911
Agency name: Doolittle Rural Fire District
Location: Doolittle, MO, United States
Sender: projects@computerra.com 

(Incident# : 13123F6 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123F6\n\rPriority :- 3\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- KLL911-Keri Lloyd\n\rAgency Code :- DLF\n\rCFS :- ODOR\n\rCFS Description :- Suspicious Odor\n\rLocation :- 520 EISENHOWER ST\n\rCommon Place :- \n\rCross Streets :- MACARTHUR ST / BRADLEY ST\n\rZone :- 515\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 17:18:10\n\rDispatch DateTime :- 05/03/2013 17:21:26\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/03/2013 17:18:23\n\rOrigin ID :- KLL911\n\rComment :- OVERPOWERING ODOR COMING FROM THE HOUSE, SMELLS SOMEWHAT LIKE GAS OR SEWAGE - THEY ARE ALL ELECTRIC - SMELLS LIKE ROTTEN EGGS\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- CANDI\n\rLast Name :- CAQUELIN\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5733680726\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 600\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 17:21:26\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 6614\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 17:25:36\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13118F2 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13118F2\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- KAQ915-Kathryn Quigley\n\rAgency Code :- DLF\n\rCFS :- 50J2\n\rCFS Description :- Accident  Injury\n\rLocation :- 24000 STATE ROUTE P\n\rCommon Place :- \n\rCross Streets :- STATE ROUTE J / FOREST RD 1724\n\rZone :- 515\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 04/28/2013 17:39:58\n\rDispatch DateTime :- 04/28/2013 17:47:10\n\rArrive DateTime :- 04/28/2013 18:01:30\n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 04/28/2013 17:40:07\n\rOrigin ID :- KAQ915\n\rComment :- 3 MILES FROM J/AND HWY P, MALE HAS A BROKEN LANE, LEFT LEG, AWAKE AND TALKING TO EVERYEONE, MOTORCYCLE\n\r ---------------------------------------------------------------------------------\n\rComment DateTime :- 04/28/2013 18:01:31\n\rOrigin ID :- AKC975\n\rComment :- 614 HAS COMMAND\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- BRANDON\n\rLast Name :- PELEZO\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5734335154\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 600\n\rResource Status :- DP\n\rStatus DateTime :- 04/28/2013 17:47:10\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 6614\n\rResource Status :- DP\n\rStatus DateTime :- 04/28/2013 17:49:31\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 6614\n\rResource Status :- ER\n\rStatus DateTime :- 04/28/2013 17:50:19\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 6618\n\rResource Status :- DP\n\rStatus DateTime :- 04/28/2013 17:56:07\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 6618\n\rResource Status :- ER\n\rStatus DateTime :- 04/28/2013 17:56:18\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 6614\n\rResource Status :- AR\n\rStatus DateTime :- 04/28/2013 18:01:30\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 6618\n\rResource Status :- AR\n\rStatus DateTime :- 04/28/2013 18:03:46\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 6620\n\rResource Status :- DP\n\rStatus DateTime :- 04/28/2013 18:12:17\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13118F2 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13118F2\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- KAQ915-Kathryn Quigley\n\rAgency Code :- DLF\n\rCFS :- 50J2\n\rCFS Description :- Accident  Injury\n\rLocation :- 24000 STATE ROUTE P\n\rCommon Place :- \n\rCross Streets :- STATE ROUTE J / FOREST RD 1724\n\rZone :- 515\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 04/28/2013 17:39:58\n\rDispatch DateTime :- 04/28/2013 17:47:10\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 04/28/2013 17:40:07\n\rOrigin ID :- KAQ915\n\rComment :- 3 MILES FROM J/AND HWY P, MALE HAS A BROKEN LANE, LEFT LEG, AWAKE AND TALKING TO EVERYEONE, MOTORCYCLE\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- BRANDON\n\rLast Name :- PELEZO\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5734335154\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 600\n\rResource Status :- DP\n\rStatus DateTime :- 04/28/2013 17:47:10\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13116F5 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13116F5\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- TAG908-Thomas Grisham\n\rAgency Code :- DLF\n\rCFS :- 50J2\n\rCFS Description :- Accident  Injury\n\rLocation :- 169 W I44\n\rCommon Place :- \n\rCross Streets :-  / \n\rZone :- WH1\n\rArea Of Responsibility :- FD\n\rJuris :- \n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 04/26/2013 16:40:24\n\rDispatch DateTime :- 04/26/2013 16:43:56\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 04/26/2013 16:41:09\n\rOrigin ID :- TAG908\n\rComment :- VEHICLE WENT THROUGH THE CABLES IN THE MEDIAN. STUCK IN THE CABLES. WHT PONTIAC GRANDAM\n\r ---------------------------------------------------------------------------------\n\rComment DateTime :- 04/26/2013 16:45:05\n\rOrigin ID :- JLJ978\n\rComment :- 602 ENROUTE\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- \n\rLast Name :- UNKNOWN\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 4059242020\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 600\n\rResource Status :- DP\n\rStatus DateTime :- 04/26/2013 16:43:56\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 600\n\rResource Status :- ER\n\rStatus DateTime :- 04/26/2013 16:45:05\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 6614\n\rResource Status :- DP\n\rStatus DateTime :- 04/26/2013 16:48:48\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13113F1 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13113F1\n\rPriority :- 6\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- P-Other Authorities\n\rPrimary Officer :- TLS959-Tabitha Stanley\n\rAgency Code :- DLF\n\rCFS :- TFIRE\n\rCFS Description :- Test Fire Test\n\rLocation :- 410 EISENHOWER ST\n\rCommon Place :- DLFD\n\rCross Streets :- BAUMAN ST / PRIVATE DR 7311\n\rZone :- 515\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 04/23/2013 13:36:06\n\rDispatch DateTime :- 04/23/2013 13:37:11\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 04/23/2013 13:36:56\n\rOrigin ID :- TLS959\n\rComment :- TEST TEST TEST\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 600\n\rResource Status :- DP\n\rStatus DateTime :- 04/23/2013 13:37:11\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------

Contact: Active911
Agency name: St. James Fire Protection District
Location: St. James, MO, United States
Sender: projects@computerra.com 

(Incident# : 13125F8 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13125F8\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- R-Radio\n\rPrimary Officer :- KLL911-Keri Lloyd\n\rAgency Code :- SJF\n\rCFS :- FOTH\n\rCFS Description :- Fire-Other\n\rLocation :- 195 E I44\n\rCommon Place :- \n\rCross Streets :-  / \n\rZone :- EH5\n\rArea Of Responsibility :- FD\n\rJuris :- \n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/05/2013 15:37:48\n\rDispatch DateTime :- 05/05/2013 15:38:45\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/05/2013 15:38:19\n\rOrigin ID :- KLL911\n\rComment :- 1106 REQUESTING ASSISTANCE FOR TRAFFIC CONTROL\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- \n\rLast Name :- 1106\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- \n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 500\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 15:38:45\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- T56\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 15:38:55\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13125F7 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13125F7\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- cja913-Crystal Allen\n\rAgency Code :- SJF\n\rCFS :- 50J2\n\rCFS Description :- Accident  Injury\n\rLocation :- 193 W I44\n\rCommon Place :- \n\rCross Streets :-  / \n\rZone :- WH5\n\rArea Of Responsibility :- FD\n\rJuris :- \n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/05/2013 15:02:32\n\rDispatch DateTime :- 05/05/2013 15:04:21\n\rArrive DateTime :- 05/05/2013 15:10:15\n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/05/2013 15:02:52\n\rOrigin ID :- cja913\n\rComment :- WHITE PC IN THE MEDIAN JUST SLID OF THE ROAD\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- BRENT\n\rLast Name :- OHLENBROF\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 8157390586\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 500\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 15:04:21\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- E52\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 15:06:22\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- T56\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 15:07:54\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- E52\n\rResource Status :- AR\n\rStatus DateTime :- 05/05/2013 15:10:15\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- T56\n\rResource Status :- AR\n\rStatus DateTime :- 05/05/2013 15:10:27\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- T53\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 15:10:44\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13125F7 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13125F7\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- cja913-Crystal Allen\n\rAgency Code :- SJF\n\rCFS :- 50J2\n\rCFS Description :- Accident  Injury\n\rLocation :- 193 W I44\n\rCommon Place :- \n\rCross Streets :-  / \n\rZone :- WH5\n\rArea Of Responsibility :- FD\n\rJuris :- \n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/05/2013 15:02:32\n\rDispatch DateTime :- 05/05/2013 15:04:21\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/05/2013 15:02:52\n\rOrigin ID :- cja913\n\rComment :- WHITE PC IN THE MEDIAN JUST SLID OF THE ROAD\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- BRENT\n\rLast Name :- OHLENBROF\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 8157390586\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 500\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 15:04:21\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- E52\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 15:06:22\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13125F6 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13125F6\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- cja913-Crystal Allen\n\rAgency Code :- SJF\n\rCFS :- 50J2\n\rCFS Description :- Accident  Injury\n\rLocation :- 195 E I44\n\rCommon Place :- \n\rCross Streets :-  / \n\rZone :- EH5\n\rArea Of Responsibility :- FD\n\rJuris :- \n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/05/2013 13:34:38\n\rDispatch DateTime :- 05/05/2013 13:36:17\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/05/2013 13:35:07\n\rOrigin ID :- cja913\n\rComment :- NAVY BLUE VEH OFF THE SHOULDER UNKNOWN INJURIES ONE VEH\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 500\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 13:36:17\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- E52\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 13:42:06\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13124F3 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13124F3\n\rPriority :- 6\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- JLJ978-Jamie Jones\n\rAgency Code :- SJF\n\rCFS :- TEST\n\rCFS Description :- Test\n\rLocation :- 903 N JEFFERSON ST\n\rCommon Place :- S15\n\rCross Streets :- SIDNEY ST / UNION AV\n\rZone :- 504\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/04/2013 10:00:27\n\rDispatch DateTime :- 05/04/2013 10:02:25\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/04/2013 10:00:51\n\rOrigin ID :- TLS959\n\rComment :- TEST CALL ONLY DO NOT RESPOND TEST... TEST... TEST...\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- ANTHONY\n\rLast Name :- CRAFT\n\rMiddle Name :- K\n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5732632705\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 500\n\rResource Status :- DP\n\rStatus DateTime :- 05/04/2013 10:02:25\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123F7 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123F7\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- SDO906-Scott Olds\n\rAgency Code :- SJF\n\rCFS :- VF\n\rCFS Description :- Vehicle Fire\n\rLocation :- 197 W I44\n\rCommon Place :- \n\rCross Streets :-  / \n\rZone :- WH5\n\rArea Of Responsibility :- FD\n\rJuris :- \n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 17:34:56\n\rDispatch DateTime :- 05/03/2013 17:36:38\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/03/2013 17:35:14\n\rOrigin ID :- SDO906\n\rComment :- vehicle on fire on the side of the road\n\r ---------------------------------------------------------------------------------\n\rComment DateTime :- 05/03/2013 17:41:29\n\rOrigin ID :- SDO906\n\rComment :- E56 DISPATCHED AT THIS TIME\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 501\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 17:41:37\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 501\n\rResource Status :- ER\n\rStatus DateTime :- 05/03/2013 17:42:16\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- E52\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 17:39:24\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- E52\n\rResource Status :- ER\n\rStatus DateTime :- 05/03/2013 17:39:47\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- E50\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 17:42:36\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- T56\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 17:41:54\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- T56\n\rResource Status :- ER\n\rStatus DateTime :- 05/03/2013 17:42:03\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- E52\n\rResource Status :- ER\n\rStatus DateTime :- 05/03/2013 17:41:29\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 500\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 17:36:38\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123F4 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123F4\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- JLJ978-Jamie Jones\n\rAgency Code :- SJF\n\rCFS :- DEATH\n\rCFS Description :- Death\n\rLocation :- 127 HJ DR\n\rCommon Place :- AMERICAS BEST VALUE INN\n\rCross Streets :-  / \n\rZone :- 999\n\rArea Of Responsibility :- 99\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 14:28:33\n\rDispatch DateTime :- 05/03/2013 14:31:50\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- E52\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 14:31:50\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123F2 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123F2\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- JLJ978-Jamie Jones\n\rAgency Code :- SJF\n\rCFS :- 50J2\n\rCFS Description :- Accident  Injury\n\rLocation :- 22050 STATE ROUTE KK\n\rCommon Place :- ROSATI WINERY\n\rCross Streets :- 90DEG / RAILROAD TRACKS\n\rZone :- 512\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 14:19:32\n\rDispatch DateTime :- 05/03/2013 14:21:45\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/03/2013 14:20:09\n\rOrigin ID :- JLJ978\n\rComment :- VEHICLE OFF THE ROAD UNSURE OF INJURIES\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- \n\rLast Name :- ANONYMOUS\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- \n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- T53\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 14:26:05\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 500\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 14:21:45\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- T56\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 14:26:05\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123F3 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123F3\n\rPriority :- 3\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- cja913-Crystal Allen\n\rAgency Code :- SJF\n\rCFS :- 50J1\n\rCFS Description :- Accident  No Injury\n\rLocation :- 901 STROBACH ST\n\rCommon Place :- DOLLAR TREE\n\rCross Streets :- S WALKER AV / S SPILMAN AV\n\rZone :- 999\n\rArea Of Responsibility :- 99\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 14:19:31\n\rDispatch DateTime :- 05/03/2013 14:23:21\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- E52\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 14:23:21\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13122F7 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13122F7\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- 1-Level 1\n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- CTS807-Charles Satterfield\n\rAgency Code :- SJF\n\rCFS :- SF\n\rCFS Description :- Structure Fire\n\rLocation :- 17326 S US HWY 63\n\rCommon Place :- \n\rCross Streets :- COUNTY RD 5240 / COUNTY RD 7240\n\rZone :- 997\n\rArea Of Responsibility :- 97\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/02/2013 23:31:27\n\rDispatch DateTime :- 05/03/2013 01:00:37\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 500\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 01:00:37\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------

Contact: Active911
Agency name: Rolla Rural Fire District
Location: Rolla, MO, United States
Sender: projects@computerra.com 

(Incident# : 13124F5 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13124F5\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- SDO906-Scott Olds\n\rAgency Code :- RRF\n\rCFS :- FOTH\n\rCFS Description :- Fire-Other\n\rLocation :- 14010 STATE ROUTE E\n\rCommon Place :- \n\rCross Streets :- COUNTY RD 8300 / COUNTY RD 8430\n\rZone :- 510\n\rArea Of Responsibility :- LE\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/04/2013 17:04:34\n\rDispatch DateTime :- 05/04/2013 17:55:34\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/04/2013 17:56:23\n\rOrigin ID :- SDO906\n\rComment :- CFS Changed From MISSIN To FOTH\n\r ---------------------------------------------------------------------------------\n\rComment DateTime :- 05/04/2013 17:56:23\n\rOrigin ID :- SDO906\n\rComment :- Priority Changed From 1 To 2\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 400\n\rResource Status :- DP\n\rStatus DateTime :- 05/04/2013 17:55:34\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 4428\n\rResource Status :- DP\n\rStatus DateTime :- 05/04/2013 17:58:31\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123F10 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123F10\n\rPriority :- 3\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- SDO906-Scott Olds\n\rAgency Code :- RRF\n\rCFS :- ODOR\n\rCFS Description :- Suspicious Odor\n\rLocation :- 11420 CEDAR GROVE LN\n\rCommon Place :- \n\rCross Streets :- CEDAR GROVE RD / DEAD END\n\rZone :- 510\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 17:55:22\n\rDispatch DateTime :- 05/03/2013 17:58:33\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/03/2013 17:55:39\n\rOrigin ID :- TAG908\n\rComment :- SMOKE IN THE BUILDING. SMELLS SOMETHING BURNING. LIGHT SMOKE INT HE BUILDING. DOES NOT SEE ANY FLAMES.\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- CRAIG\n\rLast Name :- HALL\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5733684866\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 4414\n\rResource Status :- ER\n\rStatus DateTime :- 05/03/2013 18:01:25\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 4425\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 18:03:14\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 4493\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 18:03:14\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 400\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 17:58:33\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 4414\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 18:01:19\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13122F8 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13122F8\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- 1-Level 1\n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- CTS807-Charles Satterfield\n\rAgency Code :- RRF\n\rCFS :- SF\n\rCFS Description :- Structure Fire\n\rLocation :- 17326 S US HWY 63\n\rCommon Place :- \n\rCross Streets :- COUNTY RD 5240 / COUNTY RD 7240\n\rZone :- 510\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/02/2013 23:31:27\n\rDispatch DateTime :- 05/03/2013 01:00:51\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/02/2013 23:35:25\n\rOrigin ID :- jls917\n\rComment :- HOUSE IS TO THE LEFT OF HER, UNK IF IT IS A STRUCTURE, HEARD 2 TO 3 EXPLOSINS.\n\r ---------------------------------------------------------------------------------\n\rComment DateTime :- 05/02/2013 23:35:34\n\rOrigin ID :- jls917\n\rComment :- NO ONE IS AROUND THE FIRE.\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- CAROLYN\n\rLast Name :- DOYLE\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5733080904\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 400\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 01:00:51\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13117F1 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13117F1\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- AKC975-Anthony Craft\n\rAgency Code :- RRF\n\rCFS :- AMB\n\rCFS Description :- Ambulance Needed\n\rLocation :- 12750 PRIVATE DR 7085\n\rCommon Place :- \n\rCross Streets :- STATE ROUTE CC / DEAD END\n\rZone :- 510\n\rArea Of Responsibility :- AM\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 04/27/2013 00:27:44\n\rDispatch DateTime :- 04/27/2013 00:30:05\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- HELEN\n\rLast Name :- WARREN\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5735782176\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 400\n\rResource Status :- DP\n\rStatus DateTime :- 04/27/2013 00:30:05\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 4428\n\rResource Status :- DP\n\rStatus DateTime :- 04/27/2013 00:34:07\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13115F14 For Activity Dispatch Resource) \n\rCase# :- 13000182\n\rJulian Incident# :- 13115F14\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- AKC975-Anthony Craft\n\rAgency Code :- RRF\n\rCFS :- 50J2\n\rCFS Description :- Accident  Injury\n\rLocation :- 17995 S US HWY 63\n\rCommon Place :- \n\rCross Streets :- MAGNOLIA CT / COUNTY RD 5300\n\rZone :- 510\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 04/25/2013 22:28:52\n\rDispatch DateTime :- 04/25/2013 22:32:37\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 04/25/2013 22:29:29\n\rOrigin ID :- AEJ996\n\rComment :- UNSURE IF INJURED, VEHICLE CRASHED INTO A TREE\n\r ---------------------------------------------------------------------------------\n\rComment DateTime :- 04/25/2013 22:36:44\n\rOrigin ID :- AKC975\n\rComment :- 441 ON THE SCENE OUT FOR INVESTIGATION\n\r ---------------------------------------------------------------------------------\n\rComment DateTime :- 04/25/2013 22:40:41\n\rOrigin ID :- AKC975\n\rComment :- 441 ADVISING ONE PATIENT UNRESTRAINED BLEEDING FROM THE NOSE AIRBAGS DID DEPLOY\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 400\n\rResource Status :- DP\n\rStatus DateTime :- 04/25/2013 22:32:37\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 4414\n\rResource Status :- DP\n\rStatus DateTime :- 04/25/2013 22:36:43\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 4414\n\rResource Status :- ER\n\rStatus DateTime :- 04/25/2013 22:37:29\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 4428\n\rResource Status :- DP\n\rStatus DateTime :- 04/25/2013 22:43:45\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13115F5 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13115F5\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- ASK965-Amy King\n\rAgency Code :- RRF\n\rCFS :- FAMB\n\rCFS Description :- Assist Ambulance/First Responders\n\rLocation :- 15115 STATE ROUTE F\n\rCommon Place :- \n\rCross Streets :- COUNTY RD 3210 / COUNTY RD 4110\n\rZone :- 510\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 04/25/2013 12:32:40\n\rDispatch DateTime :- 04/25/2013 12:33:33\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 04/25/2013 12:33:10\n\rOrigin ID :- ASK965\n\rComment :- FOOT STUCK IN A STUMP GRINDER\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 400\n\rResource Status :- DP\n\rStatus DateTime :- 04/25/2013 12:33:33\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 4414\n\rResource Status :- DP\n\rStatus DateTime :- 04/25/2013 12:36:54\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 4415\n\rResource Status :- DP\n\rStatus DateTime :- 04/25/2013 12:36:55\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 401\n\rResource Status :- DP\n\rStatus DateTime :- 04/25/2013 12:37:38\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------

Contact: Active911
Agency name: City of Rolla Fire & Rescue
Location: Rolla, MO, United States
Sender: projects@computerra.com  

(Incident# : 13126F3 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13126F3\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- AEJ996-Amanda Jones\n\rAgency Code :- RFD\n\rCFS :- 50J2\n\rCFS Description :- Accident  Injury\n\rLocation :- 190 E I44\n\rCommon Place :- \n\rCross Streets :-  / \n\rZone :- EH3\n\rArea Of Responsibility :- FD\n\rJuris :- \n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/06/2013 18:08:57\n\rDispatch DateTime :- 05/06/2013 18:09:56\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/06/2013 18:09:15\n\rOrigin ID :- AEJ996\n\rComment :- ONE VEHICLE ROLL OVER INTO THE MEDIAN, ONE PERSON OUT OF VEHICLE TALKING TO SOMEONE\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 18:09:56\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L33\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 18:11:37\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 18:11:37\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13126F2 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13126F2\n\rPriority :- 3\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- ADS918-Anastasia Smith\n\rAgency Code :- RFD\n\rCFS :- ODOR\n\rCFS Description :- Suspicious Odor\n\rLocation :- 910 S BISHOP AV\n\rCommon Place :- TOWN & COUNTRY BANK\n\rCross Streets :- ALDI DR / LANNING LN\n\rZone :- W\n\rArea Of Responsibility :- 97\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/06/2013 12:20:05\n\rDispatch DateTime :- 05/06/2013 12:20:58\n\rArrive DateTime :- 05/06/2013 12:24:51\n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/06/2013 12:24:51\n\rOrigin ID :- cja913\n\rComment :- 312  HAS COMMAND\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- ALAN\n\rLast Name :- MICHAELS\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- \n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 12:20:58\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L33\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 12:21:52\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 12:21:52\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L33\n\rResource Status :- AR\n\rStatus DateTime :- 05/06/2013 12:24:51\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 302\n\rResource Status :- DP\n\rStatus DateTime :- 05/06/2013 12:25:13\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13125F9 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13125F9\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- AEJ996-Amanda Jones\n\rAgency Code :- RFD\n\rCFS :- AMB\n\rCFS Description :- Ambulance Needed\n\rLocation :- 1101 MCCUTCHEN DR\n\rCommon Place :- ROLLA APARTMENTS\n\rCross Streets :- E 10TH ST / TRUMAN AV\n\rZone :- E\n\rArea Of Responsibility :- 97\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/05/2013 21:41:49\n\rDispatch DateTime :- 05/05/2013 21:58:46\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 21:58:46\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 22:00:34\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13125F5 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13125F5\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- ADS918-Anastasia Smith\n\rAgency Code :- RFD\n\rCFS :- 90F\n\rCFS Description :- Alarm Fire\n\rLocation :- 2201 N BISHOP AV\n\rCommon Place :- HAMPTON INN\n\rCross Streets :- WEST BOUND I44 ON RAMP / CITY LIMITS\n\rZone :- W\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/05/2013 08:27:51\n\rDispatch DateTime :- 05/05/2013 08:28:13\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/05/2013 08:28:00\n\rOrigin ID :- ADS918\n\rComment :- GENERAL FIRE ALARM\n\r ---------------------------------------------------------------------------------\n\rComment DateTime :- 05/05/2013 08:29:40\n\rOrigin ID :- ADS918\n\rComment :- StatusDateTime Changed From 5/5/2013 8:29:40 AMTo 5/5/2013 8:29:40 AM\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 08:28:13\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 08:29:40\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- ER\n\rStatus DateTime :- 05/05/2013 08:29:40\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L33\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 08:31:08\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13125F4 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13125F4\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- ADS918-Anastasia Smith\n\rAgency Code :- RFD\n\rCFS :- AF\n\rCFS Description :- Amb/Fire Dual Response\n\rLocation :- 1349 E HWY 72\n\rCommon Place :- HUFFMAN TRAILER PARK\n\rCross Streets :- JOHNSON ST / PINE TREE\n\rZone :- E\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/05/2013 07:19:57\n\rDispatch DateTime :- 05/05/2013 07:20:42\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- \n\rLast Name :- MUCHA/JASON\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5733647790\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 07:20:42\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13125F3 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13125F3\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- jls917-Jeff Stokes\n\rAgency Code :- RFD\n\rCFS :- 90F\n\rCFS Description :- Alarm Fire\n\rLocation :- 910 S BISHOP AV\n\rCommon Place :- TOWN & COUNTRY BANK\n\rCross Streets :- ALDI DR / LANNING LN\n\rZone :- W\n\rArea Of Responsibility :- 97\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/05/2013 04:16:40\n\rDispatch DateTime :- 05/05/2013 04:17:52\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 04:17:52\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 04:19:56\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- ER\n\rStatus DateTime :- 05/05/2013 04:20:01\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L33\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 04:20:11\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13125F1 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13125F1\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- ADH989-Alicia Hill\n\rAgency Code :- RFD\n\rCFS :- 90F\n\rCFS Description :- Alarm Fire\n\rLocation :- 1407 TRUMAN AV\n\rCommon Place :- GINGERBREAD HOUSE 2\n\rCross Streets :- MCCUTCHEN DR / PERSHING PL\n\rZone :- E\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/05/2013 03:02:30\n\rDispatch DateTime :- 05/05/2013 03:03:51\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/05/2013 03:03:12\n\rOrigin ID :- ADH989\n\rComment :- NORTH LAUNDRY ROOM GAS ALARM\nGINGER BREAD HOUSE 2\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 03:03:51\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 03:06:25\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L33\n\rResource Status :- DP\n\rStatus DateTime :- 05/05/2013 03:06:32\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13124F8 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13124F8\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- R-Radio\n\rPrimary Officer :- SDO906-Scott Olds\n\rAgency Code :- RFD\n\rCFS :- FIREMA\n\rCFS Description :- Fire Mutual AId\n\rLocation :- 14010 STATE ROUTE E\n\rCommon Place :- \n\rCross Streets :- COUNTY RD 8300 / COUNTY RD 8430\n\rZone :- 999\n\rArea Of Responsibility :- 99\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/04/2013 17:59:23\n\rDispatch DateTime :- 05/04/2013 18:02:05\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/04/2013 18:02:05\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- HAZ2\n\rResource Status :- DP\n\rStatus DateTime :- 05/04/2013 18:14:43\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13124F4 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13124F4\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- TLS959-Tabitha Stanley\n\rAgency Code :- RFD\n\rCFS :- 50J2\n\rCFS Description :- Accident  Injury\n\rLocation :- W HWY 72 / S ROLLA ST\n\rCommon Place :- \n\rCross Streets :-  / \n\rZone :- 999\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/04/2013 12:53:28\n\rDispatch DateTime :- 05/04/2013 12:55:48\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/04/2013 12:53:41\n\rOrigin ID :- TLS959\n\rComment :- 2 VEHICLE ACCIDENT\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- STEVE\n\rLast Name :- BLAKELY\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- \n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/04/2013 12:55:48\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L33\n\rResource Status :- DP\n\rStatus DateTime :- 05/04/2013 12:56:20\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- DP\n\rStatus DateTime :- 05/04/2013 12:56:20\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13124F2 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13124F2\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- cja913-Crystal Allen\n\rAgency Code :- RFD\n\rCFS :- FOTH\n\rCFS Description :- Fire-Other\n\rLocation :- 600 BLUES LAKE PW\n\rCommon Place :- BOND CLINIC\n\rCross Streets :- BRIDGE SCHOOL RD / MARTIN SPRINGS DR\n\rZone :- 997\n\rArea Of Responsibility :- 97\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/04/2013 08:41:34\n\rDispatch DateTime :- 05/04/2013 08:42:21\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/04/2013 08:41:38\n\rOrigin ID :- cja913\n\rComment :- LOWER LEVEL NEED ALARM RESET\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/04/2013 08:42:21\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L33\n\rResource Status :- DP\n\rStatus DateTime :- 05/04/2013 08:43:55\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123F8 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123F8\n\rPriority :- 1\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- SDO906-Scott Olds\n\rAgency Code :- RFD\n\rCFS :- VF\n\rCFS Description :- Vehicle Fire\n\rLocation :- 197 W I44\n\rCommon Place :- \n\rCross Streets :-  / \n\rZone :- 999\n\rArea Of Responsibility :- 99\n\rJuris :- \n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 17:34:56\n\rDispatch DateTime :- 05/03/2013 17:35:42\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 17:35:42\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13123F5 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13123F5\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- KLL911-Keri Lloyd\n\rAgency Code :- RFD\n\rCFS :- FOTH\n\rCFS Description :- Fire-Other\n\rLocation :- E LIONS CLUB DR / S ROLLA ST\n\rCommon Place :- \n\rCross Streets :-  / \n\rZone :- 999\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/03/2013 16:21:39\n\rDispatch DateTime :- 05/03/2013 16:23:58\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/03/2013 16:21:40\n\rOrigin ID :- KLL911\n\rComment :- SMOKE COMING FROM THE BACKYARD, DID NOT SEE OPEN FLAME\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- ALEX\n\rLast Name :- LEMASTERS\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 3142391322\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 16:23:58\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L33\n\rResource Status :- DP\n\rStatus DateTime :- 05/03/2013 16:24:40\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13122F5 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13122F5\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- AEJ996-Amanda Jones\n\rAgency Code :- RFD\n\rCFS :- FOTH\n\rCFS Description :- Fire-Other\n\rLocation :- 500 S BISHOP AV\n\rCommon Place :- WALMART\n\rCross Streets :- STROBACH ST / FORT WYMAN RD\n\rZone :- 997\n\rArea Of Responsibility :- 97\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/02/2013 15:36:00\n\rDispatch DateTime :- 05/02/2013 15:37:49\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/02/2013 15:36:12\n\rOrigin ID :- AEJ996\n\rComment :- TWO 16 OZ MILK JUGS WITH A GEL TYPE SUBSTANCE IN THEM, THEY ARE EXPANDING. THEY ARE ON THE GRASSY AREA ON THE EAST SIDE OF THE STORE NEAR AUTOMOTIVE SIDE.\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/02/2013 15:37:49\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 302\n\rResource Status :- DP\n\rStatus DateTime :- 05/02/2013 15:40:03\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L33\n\rResource Status :- DP\n\rStatus DateTime :- 05/02/2013 15:40:20\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13122F4 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13122F4\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- AEJ996-Amanda Jones\n\rAgency Code :- RFD\n\rCFS :- 90F\n\rCFS Description :- Alarm Fire\n\rLocation :- 1400 N BISHOP AV\n\rCommon Place :- V.H. MCNUTT HALL\n\rCross Streets :- UNIVERSITY DR / WATTS DR\n\rZone :- 997\n\rArea Of Responsibility :- 97\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/02/2013 14:53:47\n\rDispatch DateTime :- 05/02/2013 14:54:20\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/02/2013 14:52:19\n\rOrigin ID :- AEJ996\n\rComment :- POSSIBLY A FIRE ON THE 3RD FLOOR WHERE THE WASHERS AND DRYERS. THE HALLS  ARE HAZY AND IT SMELLS LIKE SOMETHING IS BURNING.\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/02/2013 14:54:20\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 302\n\rResource Status :- DP\n\rStatus DateTime :- 05/02/2013 14:56:17\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L33\n\rResource Status :- DP\n\rStatus DateTime :- 05/02/2013 14:56:17\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- DP\n\rStatus DateTime :- 05/02/2013 14:56:17\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13122F3 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13122F3\n\rPriority :- 3\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- TLS959-Tabitha Stanley\n\rAgency Code :- RFD\n\rCFS :- WD\n\rCFS Description :- Wire Down\n\rLocation :- 605 SOUTH MURRY LN\n\rCommon Place :- \n\rCross Streets :- WHITNEY LN / HIGHLAND DR\n\rZone :- 500\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/02/2013 13:58:17\n\rDispatch DateTime :- 05/02/2013 13:59:17\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/02/2013 13:58:22\n\rOrigin ID :- TLS959\n\rComment :- THERE IS A WIRE LAYING IN THE ROADWAY\n\r ---------------------------------------------------------------------------------\n\rComment DateTime :- 05/02/2013 14:01:45\n\rOrigin ID :- ASK965\n\rComment :- StatusDateTime Changed From 5/2/2013 2:01:45 PMTo 5/2/2013 2:01:45 PM\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- TIM\n\rLast Name :- COOK\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5735780981\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/02/2013 13:59:17\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- DP\n\rStatus DateTime :- 05/02/2013 14:01:45\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- ER\n\rStatus DateTime :- 05/02/2013 14:01:45\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13121F2 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13121F2\n\rPriority :- 3\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- JLJ978-Jamie Jones\n\rAgency Code :- RFD\n\rCFS :- ODOR\n\rCFS Description :- Suspicious Odor\n\rLocation :- 504 WOODLAND DR\n\rCommon Place :- \n\rCross Streets :- E 5TH ST / HOLLOWAY ST\n\rZone :- E\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/01/2013 09:44:19\n\rDispatch DateTime :- 05/01/2013 09:45:07\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/01/2013 09:44:07\n\rOrigin ID :- JLJ978\n\rComment :- GAS SMELL \nPOSSIBLY COMING FROM THE PROPANE TANK\nTHIS HAS HAPPENED BEFORE\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- CLEDA\n\rLast Name :- SCHULTZ\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5733642774\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/01/2013 09:45:07\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- DP\n\rStatus DateTime :- 05/01/2013 09:46:19\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13121F1 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13121F1\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- TLS959-Tabitha Stanley\n\rAgency Code :- RFD\n\rCFS :- 90F\n\rCFS Description :- Alarm Fire\n\rLocation :- 1675 N BISHOP AV\n\rCommon Place :- COLTON'S STEAKHOUSE\n\rCross Streets :- N STATE ST / VICHY RD\n\rZone :- 997\n\rArea Of Responsibility :- 97\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/01/2013 08:44:50\n\rDispatch DateTime :- 05/01/2013 08:45:54\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/01/2013 08:45:03\n\rOrigin ID :- TLS959\n\rComment :- KITCHEN HOOD ANSUL SYSTEM, NO CONTACT WITH PREMISES\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- \n\rLast Name :- MID-ARK\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 8006870668\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/01/2013 08:45:54\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- 301\n\rResource Status :- DP\n\rStatus DateTime :- 05/01/2013 08:47:30\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13121F1 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13121F1\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- T-Telephone\n\rPrimary Officer :- TLS959-Tabitha Stanley\n\rAgency Code :- RFD\n\rCFS :- 90F\n\rCFS Description :- Alarm Fire\n\rLocation :- 1675 N BISHOP AV\n\rCommon Place :- COLTON'S STEAKHOUSE\n\rCross Streets :- N STATE ST / VICHY RD\n\rZone :- 997\n\rArea Of Responsibility :- 97\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 05/01/2013 08:44:50\n\rDispatch DateTime :- 05/01/2013 08:45:54\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 05/01/2013 08:45:03\n\rOrigin ID :- TLS959\n\rComment :- KITCHEN HOOD ANSUL SYSTEM, NO CONTACT WITH PREMISES\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- \n\rLast Name :- MID-ARK\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 8006870668\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 05/01/2013 08:45:54\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13120F1 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13120F1\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- TLS959-Tabitha Stanley\n\rAgency Code :- RFD\n\rCFS :- GF\n\rCFS Description :- Grass Fire\n\rLocation :- 189 E I44\n\rCommon Place :- \n\rCross Streets :-  / \n\rZone :- EH3\n\rArea Of Responsibility :- FD\n\rJuris :- \n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 04/30/2013 10:55:17\n\rDispatch DateTime :- 04/30/2013 10:56:49\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\rComment DateTime :- 04/30/2013 10:55:31\n\rOrigin ID :- TLS959\n\rComment :- SMALL GRASS FIRE ON SIDE OF THE ROAD, NEARLY UNDER THE OVERPASS\n\r ---------------------------------------------------------------------------------\n\n\r =>> Name Record \n\rReason Code :- CAL\n\rDate Of Birth :- \n\rAge :- \n\rFirst Name :- PATRICIA\n\rLast Name :- PASHIA\n\rMiddle Name :- \n\rSex :- \n\rWeight :- \n\rHeight :- \n\rAddress :- \n\rSSN :- \n\rRace :- \n\rRace Description :- \n\rEye Color :- \n\rEye Color Description :- \n\rHair Color :- \n\rHair Color Description :- \n\rHome Phone :- 5736479422\n\rWork Phone :- \n\r ---------------------------------------------------------------------------------\n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 04/30/2013 10:56:49\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- DP\n\rStatus DateTime :- 04/30/2013 10:58:16\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------
(Incident# : 13119F16 For Activity Dispatch Resource) \n\rCase# :- \n\rJulian Incident# :- 13119F16\n\rPriority :- 2\n\rAgency Type :- F\n\rAlarm Level :- \n\rreceive Source :- E-E911 Call in\n\rPrimary Officer :- AEJ996-Amanda Jones\n\rAgency Code :- RFD\n\rCFS :- CO\n\rCFS Description :- Carbon Monoxide Detector\n\rLocation :- 202 N WALNUT ST\n\rCommon Place :- \n\rCross Streets :- E 3RD ST / E 2ND ST\n\rZone :- W\n\rArea Of Responsibility :- FD\n\rJuris :- PC-Phelps County\n\rMunicipality :- \n\rDisposition :- \n\rIncident Recv DateTime :- 04/29/2013 22:25:42\n\rDispatch DateTime :- 04/29/2013 22:26:28\n\rArrive DateTime :- \n\rFinish/Clear DateTime :- \n\rContain DateTime :- \n\n\r =>> Comment Record \n\n\r =>> Name Record \n\n\r =>> Vehicle Record \n\n\r  =>> Resource Activity Record \n\rResource# :- 300\n\rResource Status :- DP\n\rStatus DateTime :- 04/29/2013 22:26:28\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L33\n\rResource Status :- DP\n\rStatus DateTime :- 04/29/2013 22:27:05\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------\n\rResource# :- L35\n\rResource Status :- DP\n\rStatus DateTime :- 04/29/2013 22:27:05\n\rPID :- \n\rFirst Name :- \n\rLast Name :- \n\r ---------------------------------------------------------------------------------

*/

public class MOPhelpsCountyParserTest extends BaseParserTest {
  
  public MOPhelpsCountyParserTest() {
    setParser(new MOPhelpsCountyParser(), "PHELPS COUNTY", "MO");
  }
  
  @Test
  public void testRunReports() {

    doTest("T1",
        "(Incident# : 13126E15 For Activity Finish Resource) \n" +
        "\rCase# :- 13000086\n" +
        "\rJulian Incident# :- 13126E15\n" +
        "\rPriority :- 3\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- R-Radio\n" +
        "\rPrimary Officer :- AEJ996-Amanda Jones\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- AMBT\n" +
        "\rCFS Description :- Ambulance Transport\n" +
        "\rLocation :- 34 FAKE\n" +
        "\rCommon Place :- MISSOURI BAPTIST - SULLIVAN\n" +
        "\rCross Streets :-  / \n" +
        "\rZone :- 997\n" +
        "\rArea Of Responsibility :- 97\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- A-No Report\n" +
        "\rIncident Recv DateTime :- 05/06/2013 21:16:36\n" +
        "\rDispatch DateTime :- 05/06/2013 21:16:36\n" +
        "\rArrive DateTime :- 05/06/2013 21:16:36\n" +
        "\rFinish/Clear DateTime :- 5/6/2013 11:49:49 PM\n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/06/2013 21:16:38\n" +
        "\rOrigin ID :- AEJ996\n" +
        "\rComment :- VS Call: \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2227\n" +
        "\rResource Status :- ER\n" +
        "\rStatus DateTime :- 05/06/2013 21:17:04\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2227\n" +
        "\rResource Status :- FI\n" +
        "\rStatus DateTime :- 05/06/2013 23:49:49\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2227\n" +
        "\rResource Status :- AR\n" +
        "\rStatus DateTime :- 05/06/2013 21:42:10\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2227\n" +
        "\rResource Status :- VS\n" +
        "\rStatus DateTime :- 05/06/2013 21:16:37\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2227\n" +
        "\rResource Status :- EP\n" +
        "\rStatus DateTime :- 05/06/2013 21:56:34\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "CALL:RUN REPORT",
        "ID:13126E15",
        "PLACE:Case# :- 13000086\nJulian Incident# :- 13126E15\nPriority :- 3\nAgency Type :- E\nAlarm Level :- \nreceive Source :- R-Radio\nPrimary Officer :- AEJ996-Amanda Jones\nAgency Code :- SJA\nCFS :- AMBT\nCFS Description :- Ambulance Transport\nLocation :- 34 FAKE\nCommon Place :- MISSOURI BAPTIST - SULLIVAN\nCross Streets :-  / \nZone :- 997\nArea Of Responsibility :- 97\nJuris :- PC-Phelps County\nMunicipality :- \nDisposition :- A-No Report\nIncident Recv DateTime :- 05/06/2013 21:16:36\nDispatch DateTime :- 05/06/2013 21:16:36\nArrive DateTime :- 05/06/2013 21:16:36\nFinish/Clear DateTime :- 5/6/2013 11:49:49 PM\nContain DateTime :- \n\n =>> Comment Record \nComment DateTime :- 05/06/2013 21:16:38\nOrigin ID :- AEJ996\nComment :- VS Call: \n ---------------------------------------------------------------------------------\n\n =>> Name Record \n\n =>> Vehicle Record \n\n  =>> Resource Activity Record \nResource# :- 2227\nResource Status :- ER\nStatus DateTime :- 05/06/2013 21:17:04\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------\nResource# :- 2227\nResource Status :- FI\nStatus DateTime :- 05/06/2013 23:49:49\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------\nResource# :- 2227\nResource Status :- AR\nStatus DateTime :- 05/06/2013 21:42:10\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------\nResource# :- 2227\nResource Status :- VS\nStatus DateTime :- 05/06/2013 21:16:37\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------\nResource# :- 2227\nResource Status :- EP\nStatus DateTime :- 05/06/2013 21:56:34\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------");

    doTest("T2",
        "(Incident# : 13126E14 For Activity Finish Resource) \n" +
        "\rCase# :- 13000085\n" +
        "\rJulian Incident# :- 13126E14\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- AEJ996-Amanda Jones\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- AMB\n" +
        "\rCFS Description :- Ambulance Needed\n" +
        "\rLocation :- 17795 COUNTY RD 1060\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- PRIVATE DR 1063 / STATE ROUTE B\n" +
        "\rZone :- 512\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- A-No Report\n" +
        "\rIncident Recv DateTime :- 05/06/2013 21:07:54\n" +
        "\rDispatch DateTime :- 05/06/2013 21:10:28\n" +
        "\rArrive DateTime :- 05/06/2013 21:18:09\n" +
        "\rFinish/Clear DateTime :- 5/6/2013 9:49:35 PM\n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/06/2013 21:08:15\n" +
        "\rOrigin ID :- AEJ996\n" +
        "\rComment :- SUBJECT IN SEVERE BACK PAIN DUE TO A PROCEDURE DONE ON THE BACK. IT WAS SOME TYPE OF ELECTRIC SHOCK TREATMENT. 49 YO MALE. ADDRESS IS MARKED.\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- GALE\n" +
        "\rLast Name :- DUCKWORTH\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5732650260\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2247\n" +
        "\rResource Status :- ES\n" +
        "\rStatus DateTime :- 05/06/2013 21:35:59\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2247\n" +
        "\rResource Status :- AR\n" +
        "\rStatus DateTime :- 05/06/2013 21:18:09\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2247\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/06/2013 21:12:53\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2200\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/06/2013 21:10:28\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2247\n" +
        "\rResource Status :- FI\n" +
        "\rStatus DateTime :- 05/06/2013 21:49:35\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "CALL:RUN REPORT",
        "ID:13126E14",
        "PLACE:Case# :- 13000085\nJulian Incident# :- 13126E14\nPriority :- 2\nAgency Type :- E\nAlarm Level :- \nreceive Source :- E-E911 Call in\nPrimary Officer :- AEJ996-Amanda Jones\nAgency Code :- SJA\nCFS :- AMB\nCFS Description :- Ambulance Needed\nLocation :- 17795 COUNTY RD 1060\nCommon Place :- \nCross Streets :- PRIVATE DR 1063 / STATE ROUTE B\nZone :- 512\nArea Of Responsibility :- AM\nJuris :- PC-Phelps County\nMunicipality :- \nDisposition :- A-No Report\nIncident Recv DateTime :- 05/06/2013 21:07:54\nDispatch DateTime :- 05/06/2013 21:10:28\nArrive DateTime :- 05/06/2013 21:18:09\nFinish/Clear DateTime :- 5/6/2013 9:49:35 PM\nContain DateTime :- \n\n =>> Comment Record \nComment DateTime :- 05/06/2013 21:08:15\nOrigin ID :- AEJ996\nComment :- SUBJECT IN SEVERE BACK PAIN DUE TO A PROCEDURE DONE ON THE BACK. IT WAS SOME TYPE OF ELECTRIC SHOCK TREATMENT. 49 YO MALE. ADDRESS IS MARKED.\n ---------------------------------------------------------------------------------\n\n =>> Name Record \nReason Code :- CAL\nDate Of Birth :- \nAge :- \nFirst Name :- GALE\nLast Name :- DUCKWORTH\nMiddle Name :- \nSex :- \nWeight :- \nHeight :- \nAddress :- \nSSN :- \nRace :- \nRace Description :- \nEye Color :- \nEye Color Description :- \nHair Color :- \nHair Color Description :- \nHome Phone :- 5732650260\nWork Phone :- \n ---------------------------------------------------------------------------------\n\n =>> Vehicle Record \n\n  =>> Resource Activity Record \nResource# :- 2247\nResource Status :- ES\nStatus DateTime :- 05/06/2013 21:35:59\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------\nResource# :- 2247\nResource Status :- AR\nStatus DateTime :- 05/06/2013 21:18:09\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------\nResource# :- 2247\nResource Status :- DP\nStatus DateTime :- 05/06/2013 21:12:53\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------\nResource# :- 2200\nResource Status :- DP\nStatus DateTime :- 05/06/2013 21:10:28\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------\nResource# :- 2247\nResource Status :- FI\nStatus DateTime :- 05/06/2013 21:49:35\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------");

    doTest("T3",
        "(Incident# : 13126E7 For Activity Finish Resource) \n" +
        "\rCase# :- 13000084\n" +
        "\rJulian Incident# :- 13126E7\n" +
        "\rPriority :- 3\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- R-Radio\n" +
        "\rPrimary Officer :- cja913-Crystal Allen\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- AMBT\n" +
        "\rCFS Description :- Ambulance Transport\n" +
        "\rLocation :- 415 SIDNEY ST\n" +
        "\rCommon Place :- GOLDEN LIVING CENTER\n" +
        "\rCross Streets :- N JEFFERSON ST / AMANDA AV\n" +
        "\rZone :- 504\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- A-No Report\n" +
        "\rIncident Recv DateTime :- 05/06/2013 10:54:58\n" +
        "\rDispatch DateTime :- 05/06/2013 10:55:07\n" +
        "\rArrive DateTime :- 05/06/2013 11:07:33\n" +
        "\rFinish/Clear DateTime :- 5/6/2013 12:01:20 PM\n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/06/2013 11:45:55\n" +
        "\rOrigin ID :- cja913\n" +
        "\rComment :- ENROUTE AT 1131\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2247\n" +
        "\rResource Status :- EH\n" +
        "\rStatus DateTime :- 05/06/2013 10:55:22\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2247\n" +
        "\rResource Status :- AP\n" +
        "\rStatus DateTime :- 05/06/2013 11:45:55\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2247\n" +
        "\rResource Status :- AH\n" +
        "\rStatus DateTime :- 05/06/2013 11:07:33\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2247\n" +
        "\rResource Status :- FI\n" +
        "\rStatus DateTime :- 05/06/2013 12:01:20\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2247\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/06/2013 10:55:07\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "CALL:RUN REPORT",
        "ID:13126E7",
        "PLACE:Case# :- 13000084\nJulian Incident# :- 13126E7\nPriority :- 3\nAgency Type :- E\nAlarm Level :- \nreceive Source :- R-Radio\nPrimary Officer :- cja913-Crystal Allen\nAgency Code :- SJA\nCFS :- AMBT\nCFS Description :- Ambulance Transport\nLocation :- 415 SIDNEY ST\nCommon Place :- GOLDEN LIVING CENTER\nCross Streets :- N JEFFERSON ST / AMANDA AV\nZone :- 504\nArea Of Responsibility :- AM\nJuris :- PC-Phelps County\nMunicipality :- \nDisposition :- A-No Report\nIncident Recv DateTime :- 05/06/2013 10:54:58\nDispatch DateTime :- 05/06/2013 10:55:07\nArrive DateTime :- 05/06/2013 11:07:33\nFinish/Clear DateTime :- 5/6/2013 12:01:20 PM\nContain DateTime :- \n\n =>> Comment Record \nComment DateTime :- 05/06/2013 11:45:55\nOrigin ID :- cja913\nComment :- ENROUTE AT 1131\n ---------------------------------------------------------------------------------\n\n =>> Name Record \n\n =>> Vehicle Record \n\n  =>> Resource Activity Record \nResource# :- 2247\nResource Status :- EH\nStatus DateTime :- 05/06/2013 10:55:22\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------\nResource# :- 2247\nResource Status :- AP\nStatus DateTime :- 05/06/2013 11:45:55\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------\nResource# :- 2247\nResource Status :- AH\nStatus DateTime :- 05/06/2013 11:07:33\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------\nResource# :- 2247\nResource Status :- FI\nStatus DateTime :- 05/06/2013 12:01:20\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------\nResource# :- 2247\nResource Status :- DP\nStatus DateTime :- 05/06/2013 10:55:07\nPID :- \nFirst Name :- \nLast Name :- \n ---------------------------------------------------------------------------------");
    
  }
  
  @Test
  public void testStJamesAmbulanceDistrict() {

    doTest("T1",
        "(Incident# : 13126E18 For Activity Dispatch Resource) \n" +
        "\rCase# :- 13000087\n" +
        "\rJulian Incident# :- 13126E18\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- AEJ996-Amanda Jones\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- AMB\n" +
        "\rCFS Description :- Ambulance Needed\n" +
        "\rLocation :- 330 E HARDY ST\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- S WISHON ST / EMORY ST\n" +
        "\rZone :- 504\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- A-No Report\n" +
        "\rIncident Recv DateTime :- 05/06/2013 23:27:30\n" +
        "\rDispatch DateTime :- 05/06/2013 23:29:02\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/06/2013 23:27:44\n" +
        "\rOrigin ID :- MDG976\n" +
        "\rComment :- BLOOD PRESSURE IS 159/119 PULSE IS 116\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- GRACIE\n" +
        "\rLast Name :- WEIKOFF\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5732653228\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2200\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/06/2013 23:29:02\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2247\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/06/2013 23:29:27\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13126E18",
        "PRI:2",
        "SRC:SJA",
        "CODE:AMB",
        "CALL:Ambulance Needed",
        "ADDR:330 E HARDY ST",
        "X:S WISHON ST / EMORY ST",
        "MAP:504",
        "DATE:05/06/2013",
        "TIME:23:27:30",
        "INFO:BLOOD PRESSURE IS 159/119 PULSE IS 116");

    doTest("T2",
        "(Incident# : 13126E14 For Activity Dispatch Resource) \n" +
        "\rCase# :- 13000085\n" +
        "\rJulian Incident# :- 13126E14\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- AEJ996-Amanda Jones\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- AMB\n" +
        "\rCFS Description :- Ambulance Needed\n" +
        "\rLocation :- 17795 COUNTY RD 1060\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- PRIVATE DR 1063 / STATE ROUTE B\n" +
        "\rZone :- 512\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- A-No Report\n" +
        "\rIncident Recv DateTime :- 05/06/2013 21:07:54\n" +
        "\rDispatch DateTime :- 05/06/2013 21:10:28\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/06/2013 21:08:15\n" +
        "\rOrigin ID :- AEJ996\n" +
        "\rComment :- SUBJECT IN SEVERE BACK PAIN DUE TO A PROCEDURE DONE ON THE BACK. IT WAS SOME TYPE OF ELECTRIC SHOCK TREATMENT. 49 YO MALE. ADDRESS IS MARKED.\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- GALE\n" +
        "\rLast Name :- DUCKWORTH\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5732650260\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2200\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/06/2013 21:10:28\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2247\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/06/2013 21:12:53\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13126E14",
        "PRI:2",
        "SRC:SJA",
        "CODE:AMB",
        "CALL:Ambulance Needed",
        "ADDR:17795 COUNTY RD 1060",
        "MADDR:17795 COUNTY ROAD 1060",
        "X:PRIVATE DR 1063 / STATE ROUTE B",
        "MAP:512",
        "DATE:05/06/2013",
        "TIME:21:07:54",
        "INFO:SUBJECT IN SEVERE BACK PAIN DUE TO A PROCEDURE DONE ON THE BACK. IT WAS SOME TYPE OF ELECTRIC SHOCK TREATMENT. 49 YO MALE. ADDRESS IS MARKED.");

    doTest("T3",
        "(Incident# : 13126E7 For Activity Dispatch Resource) \n" +
        "\rCase# :- 13000084\n" +
        "\rJulian Incident# :- 13126E7\n" +
        "\rPriority :- 3\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- R-Radio\n" +
        "\rPrimary Officer :- cja913-Crystal Allen\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- AMBT\n" +
        "\rCFS Description :- Ambulance Transport\n" +
        "\rLocation :- 415 SIDNEY ST\n" +
        "\rCommon Place :- GOLDEN LIVING CENTER\n" +
        "\rCross Streets :- N JEFFERSON ST / AMANDA AV\n" +
        "\rZone :- 504\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- A-No Report\n" +
        "\rIncident Recv DateTime :- 05/06/2013 10:54:58\n" +
        "\rDispatch DateTime :- 05/06/2013 10:55:07\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2247\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/06/2013 10:55:07\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13126E7",
        "PRI:3",
        "SRC:SJA",
        "CODE:AMBT",
        "CALL:Ambulance Transport",
        "ADDR:415 SIDNEY ST",
        "PLACE:GOLDEN LIVING CENTER",
        "X:N JEFFERSON ST / AMANDA AV",
        "MAP:504",
        "DATE:05/06/2013",
        "TIME:10:54:58");

    doTest("T4",
        "(Incident# : 13125E8 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13125E8\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- AEJ996-Amanda Jones\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- MENTAL\n" +
        "\rCFS Description :- Mental Health\n" +
        "\rLocation :- 414 SAINT FRANCIS AV\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- WALTERS ST / SAINT JOHNS AV\n" +
        "\rZone :- 504\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/05/2013 17:00:43\n" +
        "\rDispatch DateTime :- 05/05/2013 17:05:53\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/05/2013 17:00:05\n" +
        "\rOrigin ID :- TAG908\n" +
        "\rComment :- chev s10 blk maya gets headed to chris fitsgeralds house. she slit her wrists. because her boyfriend was screaming at her.\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- Sheryl\n" +
        "\rLast Name :- Derrick\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5732639571\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2200\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 17:05:53\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2257\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 17:07:11\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13125E8",
        "PRI:1",
        "SRC:SJA",
        "CODE:MENTAL",
        "CALL:Mental Health",
        "ADDR:414 SAINT FRANCIS AV",
        "MADDR:414 SAINT FRANCIS AVE",
        "X:WALTERS ST / SAINT JOHNS AV",
        "MAP:504",
        "DATE:05/05/2013",
        "TIME:17:00:43",
        "INFO:chev s10 blk maya gets headed to chris fitsgeralds house. she slit her wrists. because her boyfriend was screaming at her.");

    doTest("T5",
        "(Incident# : 13125E6 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13125E6\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- cja913-Crystal Allen\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- 50J2\n" +
        "\rCFS Description :- Accident  Injury\n" +
        "\rLocation :- 193 W I44\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :-  / \n" +
        "\rZone :- WH5\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- \n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/05/2013 15:02:32\n" +
        "\rDispatch DateTime :- 05/05/2013 15:04:49\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/05/2013 15:02:52\n" +
        "\rOrigin ID :- cja913\n" +
        "\rComment :- WHITE PC IN THE MEDIAN JUST SLID OF THE ROAD\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- BRENT\n" +
        "\rLast Name :- OHLENBROF\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 8157390586\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2200\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 15:04:49\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2257\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 15:07:11\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13125E6",
        "PRI:1",
        "SRC:SJA",
        "CODE:50J2",
        "CALL:Accident  Injury",
        "ADDR:193 W I44",
        "MADDR:193 W I 44",
        "MAP:WH5",
        "DATE:05/05/2013",
        "TIME:15:02:32",
        "INFO:WHITE PC IN THE MEDIAN JUST SLID OF THE ROAD");

    doTest("T6",
        "(Incident# : 13125E7 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13125E7\n" +
        "\rPriority :- 6\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- M-Mail\n" +
        "\rPrimary Officer :- cja913-Crystal Allen\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- REMIND\n" +
        "\rCFS Description :- Special Reminder\n" +
        "\rLocation :- 1007 N ELM ST\n" +
        "\rCommon Place :- RPD\n" +
        "\rCross Streets :- W 10TH ST / W 11TH ST\n" +
        "\rZone :- 999\n" +
        "\rArea Of Responsibility :- 99\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 04/30/2013 15:00:00\n" +
        "\rDispatch DateTime :- 05/05/2013 15:05:59\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2257\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 15:05:59\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13125E7",
        "PRI:6",
        "SRC:SJA",
        "CODE:REMIND",
        "CALL:Special Reminder",
        "ADDR:1007 N ELM ST",
        "PLACE:RPD",
        "X:W 10TH ST / W 11TH ST",
        "MAP:999",
        "DATE:04/30/2013",
        "TIME:15:00:00");

    doTest("T7",
        "(Incident# : 13125E5 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13125E5\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- cja913-Crystal Allen\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- 50J2\n" +
        "\rCFS Description :- Accident  Injury\n" +
        "\rLocation :- 195 E I44\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :-  / \n" +
        "\rZone :- EH5\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- \n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/05/2013 13:34:38\n" +
        "\rDispatch DateTime :- 05/05/2013 13:36:31\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/05/2013 13:35:07\n" +
        "\rOrigin ID :- cja913\n" +
        "\rComment :- NAVY BLUE VEH OFF THE SHOULDER UNKNOWN INJURIES ONE VEH\n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rComment DateTime :- 05/05/2013 13:38:11\n" +
        "\rOrigin ID :- cja913\n" +
        "\rComment :- PER 2201 THIS IS IN THE MEDIAN\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2200\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 13:36:31\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2247\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 13:38:06\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13125E5",
        "PRI:1",
        "SRC:SJA",
        "CODE:50J2",
        "CALL:Accident  Injury",
        "ADDR:195 E I44",
        "MADDR:195 E I 44",
        "MAP:EH5",
        "DATE:05/05/2013",
        "TIME:13:34:38",
        "INFO:NAVY BLUE VEH OFF THE SHOULDER UNKNOWN INJURIES ONE VEH");

    doTest("T8",
        "(Incident# : 13123E24 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123E24\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- KLL911-Keri Lloyd\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- AMB\n" +
        "\rCFS Description :- Ambulance Needed\n" +
        "\rLocation :- 19085 PVT1255\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- STATE ROUTE EE / DEAD END\n" +
        "\rZone :- 512\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 20:20:46\n" +
        "\rDispatch DateTime :- 05/03/2013 20:26:14\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/03/2013 20:21:15\n" +
        "\rOrigin ID :- KLL911\n" +
        "\rComment :- PH1 HANGUP - CALLED BACK, SHE HAS A 10 DAY OLD BABY CANT KEEP LIQUIDS DOWN - CONCIOUS AND ALERT, STARTED TODAY OFF AND ON ALL DAY, NO VOMITTING - ITS OFF HWY EE - 2ND DRIVE ON LEFT, THERE IS A RED GATE AND IT IS MARKED\n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rComment DateTime :- 05/03/2013 20:24:35\n" +
        "\rOrigin ID :- KLL911\n" +
        "\rComment :- NO FEVER\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- TAMMY\n" +
        "\rLast Name :- MORELAND\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 4173159698\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2257\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 20:30:17\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2200\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 20:26:14\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123E24",
        "PRI:2",
        "SRC:SJA",
        "CODE:AMB",
        "CALL:Ambulance Needed",
        "ADDR:19085 PVT1255",
        "MADDR:19085 PVT DRIVE 1255",
        "X:STATE ROUTE EE / DEAD END",
        "MAP:512",
        "DATE:05/03/2013",
        "TIME:20:20:46",
        "INFO:PH1 HANGUP - CALLED BACK, SHE HAS A 10 DAY OLD BABY CANT KEEP LIQUIDS DOWN - CONCIOUS AND ALERT, STARTED TODAY OFF AND ON ALL DAY, NO VOMITTING - ITS OFF HWY EE - 2ND DRIVE ON LEFT, THERE IS A RED GATE AND IT IS MARKED");

    doTest("T9",
        "(Incident# : 13123E24 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123E24\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- KLL911-Keri Lloyd\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- AMB\n" +
        "\rCFS Description :- Ambulance Needed\n" +
        "\rLocation :- 19085 PVT1255\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- STATE ROUTE EE / DEAD END\n" +
        "\rZone :- 512\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 20:20:46\n" +
        "\rDispatch DateTime :- 05/03/2013 20:26:14\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/03/2013 20:21:15\n" +
        "\rOrigin ID :- KLL911\n" +
        "\rComment :- PH1 HANGUP - CALLED BACK, SHE HAS A 10 DAY OLD BABY CANT KEEP LIQUIDS DOWN - CONCIOUS AND ALERT, STARTED TODAY OFF AND ON ALL DAY, NO VOMITTING - ITS OFF HWY EE - 2ND DRIVE ON LEFT, THERE IS A RED GATE AND IT IS MARKED\n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rComment DateTime :- 05/03/2013 20:24:35\n" +
        "\rOrigin ID :- KLL911\n" +
        "\rComment :- NO FEVER\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- TAMMY\n" +
        "\rLast Name :- MORELAND\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 4173159698\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2200\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 20:26:14\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123E24",
        "PRI:2",
        "SRC:SJA",
        "CODE:AMB",
        "CALL:Ambulance Needed",
        "ADDR:19085 PVT1255",
        "MADDR:19085 PVT DRIVE 1255",
        "X:STATE ROUTE EE / DEAD END",
        "MAP:512",
        "DATE:05/03/2013",
        "TIME:20:20:46",
        "INFO:PH1 HANGUP - CALLED BACK, SHE HAS A 10 DAY OLD BABY CANT KEEP LIQUIDS DOWN - CONCIOUS AND ALERT, STARTED TODAY OFF AND ON ALL DAY, NO VOMITTING - ITS OFF HWY EE - 2ND DRIVE ON LEFT, THERE IS A RED GATE AND IT IS MARKED");

    doTest("T10",
        "(Incident# : 13123E22 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123E22\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- jls917-Jeff Stokes\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- AMB\n" +
        "\rCFS Description :- Ambulance Needed\n" +
        "\rLocation :- 21749 COUNTY RD 1000\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- STATE ROUTE U / COUNTY RD 1190\n" +
        "\rZone :- 512\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 19:23:21\n" +
        "\rDispatch DateTime :- 05/03/2013 19:24:26\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/03/2013 19:23:31\n" +
        "\rOrigin ID :- jls917\n" +
        "\rComment :- 65Y/O FEMALE, HIGH FEVER, CANNOT SIT OR STAND, SHAKING.\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- GRACE\n" +
        "\rLast Name :- FITSIMMONS\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5734652267\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2257\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 19:28:48\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2200\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 19:24:26\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123E22",
        "PRI:2",
        "SRC:SJA",
        "CODE:AMB",
        "CALL:Ambulance Needed",
        "ADDR:21749 COUNTY RD 1000",
        "MADDR:21749 COUNTY ROAD 1000",
        "X:STATE ROUTE U / COUNTY RD 1190",
        "MAP:512",
        "DATE:05/03/2013",
        "TIME:19:23:21",
        "INFO:65Y/O FEMALE, HIGH FEVER, CANNOT SIT OR STAND, SHAKING.");

    doTest("T11",
        "(Incident# : 13123E23 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123E23\n" +
        "\rPriority :- 3\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- T-Telephone\n" +
        "\rPrimary Officer :- KLL911-Keri Lloyd\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- TH\n" +
        "\rCFS Description :- Telephone Harass.\n" +
        "\rLocation :- 1206 E 18TH ST\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- FARRAR DR / FORUM DR\n" +
        "\rZone :- 999\n" +
        "\rArea Of Responsibility :- 99\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 19:05:09\n" +
        "\rDispatch DateTime :- 05/03/2013 19:27:38\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2257\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 19:27:38\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123E23",
        "PRI:3",
        "SRC:SJA",
        "CODE:TH",
        "CALL:Telephone Harass.",
        "ADDR:1206 E 18TH ST",
        "X:FARRAR DR / FORUM DR",
        "MAP:999",
        "DATE:05/03/2013",
        "TIME:19:05:09");

    doTest("T12",
        "(Incident# : 13123E22 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123E22\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- jls917-Jeff Stokes\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- AMB\n" +
        "\rCFS Description :- Ambulance Needed\n" +
        "\rLocation :- 21749 COUNTY RD 1000\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- STATE ROUTE U / COUNTY RD 1190\n" +
        "\rZone :- 512\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 19:23:21\n" +
        "\rDispatch DateTime :- 05/03/2013 19:24:26\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/03/2013 19:23:31\n" +
        "\rOrigin ID :- jls917\n" +
        "\rComment :- 65Y/O FEMALE, HIGH FEVER, CANNOT SIT OR STAND, SHAKING.\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- GRACE\n" +
        "\rLast Name :- FITSIMMONS\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5734652267\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2200\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 19:24:26\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123E22",
        "PRI:2",
        "SRC:SJA",
        "CODE:AMB",
        "CALL:Ambulance Needed",
        "ADDR:21749 COUNTY RD 1000",
        "MADDR:21749 COUNTY ROAD 1000",
        "X:STATE ROUTE U / COUNTY RD 1190",
        "MAP:512",
        "DATE:05/03/2013",
        "TIME:19:23:21",
        "INFO:65Y/O FEMALE, HIGH FEVER, CANNOT SIT OR STAND, SHAKING.");

    doTest("T13",
        "(Incident# : 13123E12 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123E12\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- JLJ978-Jamie Jones\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- 50J2\n" +
        "\rCFS Description :- Accident  Injury\n" +
        "\rLocation :- 22050 STATE ROUTE KK\n" +
        "\rCommon Place :- ROSATI WINERY\n" +
        "\rCross Streets :- 90DEG / RAILROAD TRACKS\n" +
        "\rZone :- 512\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 14:19:32\n" +
        "\rDispatch DateTime :- 05/03/2013 14:21:38\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/03/2013 14:20:09\n" +
        "\rOrigin ID :- JLJ978\n" +
        "\rComment :- VEHICLE OFF THE ROAD UNSURE OF INJURIES\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- ANONYMOUS\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- \n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2200\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 14:21:38\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2257\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 14:23:18\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123E12",
        "PRI:1",
        "SRC:SJA",
        "CODE:50J2",
        "CALL:Accident  Injury",
        "ADDR:22050 STATE ROUTE KK",
        "MADDR:22050 STATE KK",
        "PLACE:ROSATI WINERY",
        "X:90DEG / RAILROAD TRACKS",
        "MAP:512",
        "DATE:05/03/2013",
        "TIME:14:19:32",
        "INFO:VEHICLE OFF THE ROAD UNSURE OF INJURIES");

    doTest("T14",
        "(Incident# : 13123E6 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123E6\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- PMV920-Paula Volkmer\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- AMB\n" +
        "\rCFS Description :- Ambulance Needed\n" +
        "\rLocation :- 620 N JEFFERSON ST\n" +
        "\rCommon Place :- MISSOURI VETERANS HOME\n" +
        "\rCross Streets :- AIDA ST / MARCELLA ST\n" +
        "\rZone :- 504\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 11:08:41\n" +
        "\rDispatch DateTime :- 05/03/2013 11:11:51\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/03/2013 11:09:22\n" +
        "\rOrigin ID :- PMV920\n" +
        "\rComment :- in the clinic...68 YROLD WITH CHEST PAINS\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- TIFFANY\n" +
        "\rLast Name :- UNKNOWN\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5732650339\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2257\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 11:14:16\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2200\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 11:11:51\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123E6",
        "PRI:2",
        "SRC:SJA",
        "CODE:AMB",
        "CALL:Ambulance Needed",
        "ADDR:620 N JEFFERSON ST",
        "PLACE:MISSOURI VETERANS HOME",
        "X:AIDA ST / MARCELLA ST",
        "MAP:504",
        "DATE:05/03/2013",
        "TIME:11:08:41",
        "INFO:in the clinic...68 YROLD WITH CHEST PAINS");

    doTest("T15",
        "(Incident# : 13123E3 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123E3\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- E\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- jls917-Jeff Stokes\n" +
        "\rAgency Code :- SJA\n" +
        "\rCFS :- AMB\n" +
        "\rCFS Description :- Ambulance Needed\n" +
        "\rLocation :- 422 SAINT FRANCIS AV\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- SAINT JOHNS AV / SAINT FRANCIS CR\n" +
        "\rZone :- 504\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 05:20:59\n" +
        "\rDispatch DateTime :- 05/03/2013 05:23:01\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/03/2013 05:21:06\n" +
        "\rOrigin ID :- jls917\n" +
        "\rComment :- RP'S LEG ARE NOT WORKING RIGHT. THEY FEEL FUNNY AND HER BALANCE IS OFF. BURNING IN HER STOMACH.\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- MICHELLE\n" +
        "\rLast Name :- MONTGOMERY\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 9112048790\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 2200\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 05:23:01\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 2257\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 05:27:36\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123E3",
        "PRI:2",
        "SRC:SJA",
        "CODE:AMB",
        "CALL:Ambulance Needed",
        "ADDR:422 SAINT FRANCIS AV",
        "MADDR:422 SAINT FRANCIS AVE",
        "X:SAINT JOHNS AV / SAINT FRANCIS CR",
        "MAP:504",
        "DATE:05/03/2013",
        "TIME:05:20:59",
        "INFO:RP'S LEG ARE NOT WORKING RIGHT. THEY FEEL FUNNY AND HER BALANCE IS OFF. BURNING IN HER STOMACH.");

  }
  
  @Test
  public void testDoolittleRuralFireDistrict() {

    doTest("T1",
        "(Incident# : 13123F6 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123F6\n" +
        "\rPriority :- 3\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- KLL911-Keri Lloyd\n" +
        "\rAgency Code :- DLF\n" +
        "\rCFS :- ODOR\n" +
        "\rCFS Description :- Suspicious Odor\n" +
        "\rLocation :- 520 EISENHOWER ST\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- MACARTHUR ST / BRADLEY ST\n" +
        "\rZone :- 515\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 17:18:10\n" +
        "\rDispatch DateTime :- 05/03/2013 17:21:26\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/03/2013 17:18:23\n" +
        "\rOrigin ID :- KLL911\n" +
        "\rComment :- OVERPOWERING ODOR COMING FROM THE HOUSE, SMELLS SOMEWHAT LIKE GAS OR SEWAGE - THEY ARE ALL ELECTRIC - SMELLS LIKE ROTTEN EGGS\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- CANDI\n" +
        "\rLast Name :- CAQUELIN\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5733680726\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 600\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 17:21:26\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 6614\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 17:25:36\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123F6",
        "PRI:3",
        "SRC:DLF",
        "CODE:ODOR",
        "CALL:Suspicious Odor",
        "ADDR:520 EISENHOWER ST",
        "X:MACARTHUR ST / BRADLEY ST",
        "MAP:515",
        "DATE:05/03/2013",
        "TIME:17:18:10",
        "INFO:OVERPOWERING ODOR COMING FROM THE HOUSE, SMELLS SOMEWHAT LIKE GAS OR SEWAGE - THEY ARE ALL ELECTRIC - SMELLS LIKE ROTTEN EGGS");

    doTest("T2",
        "(Incident# : 13118F2 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13118F2\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- KAQ915-Kathryn Quigley\n" +
        "\rAgency Code :- DLF\n" +
        "\rCFS :- 50J2\n" +
        "\rCFS Description :- Accident  Injury\n" +
        "\rLocation :- 24000 STATE ROUTE P\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- STATE ROUTE J / FOREST RD 1724\n" +
        "\rZone :- 515\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 04/28/2013 17:39:58\n" +
        "\rDispatch DateTime :- 04/28/2013 17:47:10\n" +
        "\rArrive DateTime :- 04/28/2013 18:01:30\n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 04/28/2013 17:40:07\n" +
        "\rOrigin ID :- KAQ915\n" +
        "\rComment :- 3 MILES FROM J/AND HWY P, MALE HAS A BROKEN LANE, LEFT LEG, AWAKE AND TALKING TO EVERYEONE, MOTORCYCLE\n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rComment DateTime :- 04/28/2013 18:01:31\n" +
        "\rOrigin ID :- AKC975\n" +
        "\rComment :- 614 HAS COMMAND\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- BRANDON\n" +
        "\rLast Name :- PELEZO\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5734335154\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 600\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/28/2013 17:47:10\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 6614\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/28/2013 17:49:31\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 6614\n" +
        "\rResource Status :- ER\n" +
        "\rStatus DateTime :- 04/28/2013 17:50:19\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 6618\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/28/2013 17:56:07\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 6618\n" +
        "\rResource Status :- ER\n" +
        "\rStatus DateTime :- 04/28/2013 17:56:18\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 6614\n" +
        "\rResource Status :- AR\n" +
        "\rStatus DateTime :- 04/28/2013 18:01:30\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 6618\n" +
        "\rResource Status :- AR\n" +
        "\rStatus DateTime :- 04/28/2013 18:03:46\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 6620\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/28/2013 18:12:17\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13118F2",
        "PRI:1",
        "SRC:DLF",
        "CODE:50J2",
        "CALL:Accident  Injury",
        "ADDR:24000 STATE ROUTE P",
        "MADDR:24000 STATE P",
        "X:STATE ROUTE J / FOREST RD 1724",
        "MAP:515",
        "DATE:04/28/2013",
        "TIME:17:39:58",
        "INFO:3 MILES FROM J/AND HWY P, MALE HAS A BROKEN LANE, LEFT LEG, AWAKE AND TALKING TO EVERYEONE, MOTORCYCLE");

    doTest("T3",
        "(Incident# : 13118F2 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13118F2\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- KAQ915-Kathryn Quigley\n" +
        "\rAgency Code :- DLF\n" +
        "\rCFS :- 50J2\n" +
        "\rCFS Description :- Accident  Injury\n" +
        "\rLocation :- 24000 STATE ROUTE P\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- STATE ROUTE J / FOREST RD 1724\n" +
        "\rZone :- 515\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 04/28/2013 17:39:58\n" +
        "\rDispatch DateTime :- 04/28/2013 17:47:10\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 04/28/2013 17:40:07\n" +
        "\rOrigin ID :- KAQ915\n" +
        "\rComment :- 3 MILES FROM J/AND HWY P, MALE HAS A BROKEN LANE, LEFT LEG, AWAKE AND TALKING TO EVERYEONE, MOTORCYCLE\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- BRANDON\n" +
        "\rLast Name :- PELEZO\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5734335154\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 600\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/28/2013 17:47:10\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13118F2",
        "PRI:1",
        "SRC:DLF",
        "CODE:50J2",
        "CALL:Accident  Injury",
        "ADDR:24000 STATE ROUTE P",
        "MADDR:24000 STATE P",
        "X:STATE ROUTE J / FOREST RD 1724",
        "MAP:515",
        "DATE:04/28/2013",
        "TIME:17:39:58",
        "INFO:3 MILES FROM J/AND HWY P, MALE HAS A BROKEN LANE, LEFT LEG, AWAKE AND TALKING TO EVERYEONE, MOTORCYCLE");

    doTest("T4",
        "(Incident# : 13116F5 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13116F5\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- TAG908-Thomas Grisham\n" +
        "\rAgency Code :- DLF\n" +
        "\rCFS :- 50J2\n" +
        "\rCFS Description :- Accident  Injury\n" +
        "\rLocation :- 169 W I44\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :-  / \n" +
        "\rZone :- WH1\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- \n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 04/26/2013 16:40:24\n" +
        "\rDispatch DateTime :- 04/26/2013 16:43:56\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 04/26/2013 16:41:09\n" +
        "\rOrigin ID :- TAG908\n" +
        "\rComment :- VEHICLE WENT THROUGH THE CABLES IN THE MEDIAN. STUCK IN THE CABLES. WHT PONTIAC GRANDAM\n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rComment DateTime :- 04/26/2013 16:45:05\n" +
        "\rOrigin ID :- JLJ978\n" +
        "\rComment :- 602 ENROUTE\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- UNKNOWN\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 4059242020\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 600\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/26/2013 16:43:56\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 600\n" +
        "\rResource Status :- ER\n" +
        "\rStatus DateTime :- 04/26/2013 16:45:05\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 6614\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/26/2013 16:48:48\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13116F5",
        "PRI:1",
        "SRC:DLF",
        "CODE:50J2",
        "CALL:Accident  Injury",
        "ADDR:169 W I44",
        "MADDR:169 W I 44",
        "MAP:WH1",
        "DATE:04/26/2013",
        "TIME:16:40:24",
        "INFO:VEHICLE WENT THROUGH THE CABLES IN THE MEDIAN. STUCK IN THE CABLES. WHT PONTIAC GRANDAM");

    doTest("T5",
        "(Incident# : 13113F1 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13113F1\n" +
        "\rPriority :- 6\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- P-Other Authorities\n" +
        "\rPrimary Officer :- TLS959-Tabitha Stanley\n" +
        "\rAgency Code :- DLF\n" +
        "\rCFS :- TFIRE\n" +
        "\rCFS Description :- Test Fire Test\n" +
        "\rLocation :- 410 EISENHOWER ST\n" +
        "\rCommon Place :- DLFD\n" +
        "\rCross Streets :- BAUMAN ST / PRIVATE DR 7311\n" +
        "\rZone :- 515\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 04/23/2013 13:36:06\n" +
        "\rDispatch DateTime :- 04/23/2013 13:37:11\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 04/23/2013 13:36:56\n" +
        "\rOrigin ID :- TLS959\n" +
        "\rComment :- TEST TEST TEST\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 600\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/23/2013 13:37:11\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13113F1",
        "PRI:6",
        "SRC:DLF",
        "CODE:TFIRE",
        "CALL:Test Fire Test",
        "ADDR:410 EISENHOWER ST",
        "PLACE:DLFD",
        "X:BAUMAN ST / PRIVATE DR 7311",
        "MAP:515",
        "DATE:04/23/2013",
        "TIME:13:36:06",
        "INFO:TEST TEST TEST");
   
  }
  
  @Test
  public void testStJamesFireProtectionDistrict() {

    doTest("T1",
        "(Incident# : 13125F8 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13125F8\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- R-Radio\n" +
        "\rPrimary Officer :- KLL911-Keri Lloyd\n" +
        "\rAgency Code :- SJF\n" +
        "\rCFS :- FOTH\n" +
        "\rCFS Description :- Fire-Other\n" +
        "\rLocation :- 195 E I44\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :-  / \n" +
        "\rZone :- EH5\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- \n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/05/2013 15:37:48\n" +
        "\rDispatch DateTime :- 05/05/2013 15:38:45\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/05/2013 15:38:19\n" +
        "\rOrigin ID :- KLL911\n" +
        "\rComment :- 1106 REQUESTING ASSISTANCE FOR TRAFFIC CONTROL\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- 1106\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- \n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 500\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 15:38:45\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- T56\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 15:38:55\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13125F8",
        "PRI:2",
        "SRC:SJF",
        "CODE:FOTH",
        "CALL:Fire-Other",
        "ADDR:195 E I44",
        "MADDR:195 E I 44",
        "MAP:EH5",
        "DATE:05/05/2013",
        "TIME:15:37:48",
        "INFO:1106 REQUESTING ASSISTANCE FOR TRAFFIC CONTROL");

    doTest("T2",
        "(Incident# : 13125F7 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13125F7\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- cja913-Crystal Allen\n" +
        "\rAgency Code :- SJF\n" +
        "\rCFS :- 50J2\n" +
        "\rCFS Description :- Accident  Injury\n" +
        "\rLocation :- 193 W I44\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :-  / \n" +
        "\rZone :- WH5\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- \n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/05/2013 15:02:32\n" +
        "\rDispatch DateTime :- 05/05/2013 15:04:21\n" +
        "\rArrive DateTime :- 05/05/2013 15:10:15\n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/05/2013 15:02:52\n" +
        "\rOrigin ID :- cja913\n" +
        "\rComment :- WHITE PC IN THE MEDIAN JUST SLID OF THE ROAD\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- BRENT\n" +
        "\rLast Name :- OHLENBROF\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 8157390586\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 500\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 15:04:21\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- E52\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 15:06:22\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- T56\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 15:07:54\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- E52\n" +
        "\rResource Status :- AR\n" +
        "\rStatus DateTime :- 05/05/2013 15:10:15\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- T56\n" +
        "\rResource Status :- AR\n" +
        "\rStatus DateTime :- 05/05/2013 15:10:27\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- T53\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 15:10:44\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13125F7",
        "PRI:1",
        "SRC:SJF",
        "CODE:50J2",
        "CALL:Accident  Injury",
        "ADDR:193 W I44",
        "MADDR:193 W I 44",
        "MAP:WH5",
        "DATE:05/05/2013",
        "TIME:15:02:32",
        "INFO:WHITE PC IN THE MEDIAN JUST SLID OF THE ROAD");

    doTest("T3",
        "(Incident# : 13125F7 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13125F7\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- cja913-Crystal Allen\n" +
        "\rAgency Code :- SJF\n" +
        "\rCFS :- 50J2\n" +
        "\rCFS Description :- Accident  Injury\n" +
        "\rLocation :- 193 W I44\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :-  / \n" +
        "\rZone :- WH5\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- \n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/05/2013 15:02:32\n" +
        "\rDispatch DateTime :- 05/05/2013 15:04:21\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/05/2013 15:02:52\n" +
        "\rOrigin ID :- cja913\n" +
        "\rComment :- WHITE PC IN THE MEDIAN JUST SLID OF THE ROAD\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- BRENT\n" +
        "\rLast Name :- OHLENBROF\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 8157390586\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 500\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 15:04:21\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- E52\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 15:06:22\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13125F7",
        "PRI:1",
        "SRC:SJF",
        "CODE:50J2",
        "CALL:Accident  Injury",
        "ADDR:193 W I44",
        "MADDR:193 W I 44",
        "MAP:WH5",
        "DATE:05/05/2013",
        "TIME:15:02:32",
        "INFO:WHITE PC IN THE MEDIAN JUST SLID OF THE ROAD");

    doTest("T4",
        "(Incident# : 13125F6 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13125F6\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- cja913-Crystal Allen\n" +
        "\rAgency Code :- SJF\n" +
        "\rCFS :- 50J2\n" +
        "\rCFS Description :- Accident  Injury\n" +
        "\rLocation :- 195 E I44\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :-  / \n" +
        "\rZone :- EH5\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- \n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/05/2013 13:34:38\n" +
        "\rDispatch DateTime :- 05/05/2013 13:36:17\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/05/2013 13:35:07\n" +
        "\rOrigin ID :- cja913\n" +
        "\rComment :- NAVY BLUE VEH OFF THE SHOULDER UNKNOWN INJURIES ONE VEH\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 500\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 13:36:17\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- E52\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/05/2013 13:42:06\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13125F6",
        "PRI:1",
        "SRC:SJF",
        "CODE:50J2",
        "CALL:Accident  Injury",
        "ADDR:195 E I44",
        "MADDR:195 E I 44",
        "MAP:EH5",
        "DATE:05/05/2013",
        "TIME:13:34:38",
        "INFO:NAVY BLUE VEH OFF THE SHOULDER UNKNOWN INJURIES ONE VEH");

    doTest("T5",
        "(Incident# : 13124F3 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13124F3\n" +
        "\rPriority :- 6\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- T-Telephone\n" +
        "\rPrimary Officer :- JLJ978-Jamie Jones\n" +
        "\rAgency Code :- SJF\n" +
        "\rCFS :- TEST\n" +
        "\rCFS Description :- Test\n" +
        "\rLocation :- 903 N JEFFERSON ST\n" +
        "\rCommon Place :- S15\n" +
        "\rCross Streets :- SIDNEY ST / UNION AV\n" +
        "\rZone :- 504\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/04/2013 10:00:27\n" +
        "\rDispatch DateTime :- 05/04/2013 10:02:25\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/04/2013 10:00:51\n" +
        "\rOrigin ID :- TLS959\n" +
        "\rComment :- TEST CALL ONLY DO NOT RESPOND TEST... TEST... TEST...\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- ANTHONY\n" +
        "\rLast Name :- CRAFT\n" +
        "\rMiddle Name :- K\n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5732632705\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 500\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/04/2013 10:02:25\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13124F3",
        "PRI:6",
        "SRC:SJF",
        "CODE:TEST",
        "CALL:Test",
        "ADDR:903 N JEFFERSON ST",
        "PLACE:S15",
        "X:SIDNEY ST / UNION AV",
        "MAP:504",
        "DATE:05/04/2013",
        "TIME:10:00:27",
        "INFO:TEST CALL ONLY DO NOT RESPOND TEST... TEST... TEST...");

    doTest("T6",
        "(Incident# : 13123F7 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123F7\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- SDO906-Scott Olds\n" +
        "\rAgency Code :- SJF\n" +
        "\rCFS :- VF\n" +
        "\rCFS Description :- Vehicle Fire\n" +
        "\rLocation :- 197 W I44\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :-  / \n" +
        "\rZone :- WH5\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- \n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 17:34:56\n" +
        "\rDispatch DateTime :- 05/03/2013 17:36:38\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/03/2013 17:35:14\n" +
        "\rOrigin ID :- SDO906\n" +
        "\rComment :- vehicle on fire on the side of the road\n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rComment DateTime :- 05/03/2013 17:41:29\n" +
        "\rOrigin ID :- SDO906\n" +
        "\rComment :- E56 DISPATCHED AT THIS TIME\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 501\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 17:41:37\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 501\n" +
        "\rResource Status :- ER\n" +
        "\rStatus DateTime :- 05/03/2013 17:42:16\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- E52\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 17:39:24\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- E52\n" +
        "\rResource Status :- ER\n" +
        "\rStatus DateTime :- 05/03/2013 17:39:47\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- E50\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 17:42:36\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- T56\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 17:41:54\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- T56\n" +
        "\rResource Status :- ER\n" +
        "\rStatus DateTime :- 05/03/2013 17:42:03\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- E52\n" +
        "\rResource Status :- ER\n" +
        "\rStatus DateTime :- 05/03/2013 17:41:29\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 500\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 17:36:38\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123F7",
        "PRI:1",
        "SRC:SJF",
        "CODE:VF",
        "CALL:Vehicle Fire",
        "ADDR:197 W I44",
        "MADDR:197 W I 44",
        "MAP:WH5",
        "DATE:05/03/2013",
        "TIME:17:34:56",
        "INFO:vehicle on fire on the side of the road");

    doTest("T7",
        "(Incident# : 13123F4 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123F4\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- T-Telephone\n" +
        "\rPrimary Officer :- JLJ978-Jamie Jones\n" +
        "\rAgency Code :- SJF\n" +
        "\rCFS :- DEATH\n" +
        "\rCFS Description :- Death\n" +
        "\rLocation :- 127 HJ DR\n" +
        "\rCommon Place :- AMERICAS BEST VALUE INN\n" +
        "\rCross Streets :-  / \n" +
        "\rZone :- 999\n" +
        "\rArea Of Responsibility :- 99\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 14:28:33\n" +
        "\rDispatch DateTime :- 05/03/2013 14:31:50\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- E52\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 14:31:50\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123F4",
        "PRI:2",
        "SRC:SJF",
        "CODE:DEATH",
        "CALL:Death",
        "ADDR:127 HJ DR",
        "PLACE:AMERICAS BEST VALUE INN",
        "MAP:999",
        "DATE:05/03/2013",
        "TIME:14:28:33");

    doTest("T8",
        "(Incident# : 13123F2 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123F2\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- JLJ978-Jamie Jones\n" +
        "\rAgency Code :- SJF\n" +
        "\rCFS :- 50J2\n" +
        "\rCFS Description :- Accident  Injury\n" +
        "\rLocation :- 22050 STATE ROUTE KK\n" +
        "\rCommon Place :- ROSATI WINERY\n" +
        "\rCross Streets :- 90DEG / RAILROAD TRACKS\n" +
        "\rZone :- 512\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 14:19:32\n" +
        "\rDispatch DateTime :- 05/03/2013 14:21:45\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/03/2013 14:20:09\n" +
        "\rOrigin ID :- JLJ978\n" +
        "\rComment :- VEHICLE OFF THE ROAD UNSURE OF INJURIES\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- ANONYMOUS\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- \n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- T53\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 14:26:05\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 500\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 14:21:45\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- T56\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 14:26:05\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123F2",
        "PRI:1",
        "SRC:SJF",
        "CODE:50J2",
        "CALL:Accident  Injury",
        "ADDR:22050 STATE ROUTE KK",
        "MADDR:22050 STATE KK",
        "PLACE:ROSATI WINERY",
        "X:90DEG / RAILROAD TRACKS",
        "MAP:512",
        "DATE:05/03/2013",
        "TIME:14:19:32",
        "INFO:VEHICLE OFF THE ROAD UNSURE OF INJURIES");

    doTest("T9",
        "(Incident# : 13123F3 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123F3\n" +
        "\rPriority :- 3\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- T-Telephone\n" +
        "\rPrimary Officer :- cja913-Crystal Allen\n" +
        "\rAgency Code :- SJF\n" +
        "\rCFS :- 50J1\n" +
        "\rCFS Description :- Accident  No Injury\n" +
        "\rLocation :- 901 STROBACH ST\n" +
        "\rCommon Place :- DOLLAR TREE\n" +
        "\rCross Streets :- S WALKER AV / S SPILMAN AV\n" +
        "\rZone :- 999\n" +
        "\rArea Of Responsibility :- 99\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 14:19:31\n" +
        "\rDispatch DateTime :- 05/03/2013 14:23:21\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- E52\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 14:23:21\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123F3",
        "PRI:3",
        "SRC:SJF",
        "CODE:50J1",
        "CALL:Accident  No Injury",
        "ADDR:901 STROBACH ST",
        "PLACE:DOLLAR TREE",
        "X:S WALKER AV / S SPILMAN AV",
        "MAP:999",
        "DATE:05/03/2013",
        "TIME:14:19:31");

    doTest("T10",
        "(Incident# : 13122F7 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13122F7\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- 1-Level 1\n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- CTS807-Charles Satterfield\n" +
        "\rAgency Code :- SJF\n" +
        "\rCFS :- SF\n" +
        "\rCFS Description :- Structure Fire\n" +
        "\rLocation :- 17326 S US HWY 63\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- COUNTY RD 5240 / COUNTY RD 7240\n" +
        "\rZone :- 997\n" +
        "\rArea Of Responsibility :- 97\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/02/2013 23:31:27\n" +
        "\rDispatch DateTime :- 05/03/2013 01:00:37\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 500\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 01:00:37\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13122F7",
        "PRI:1",
        "SRC:SJF",
        "CODE:SF",
        "CALL:Structure Fire",
        "ADDR:17326 S US HWY 63",
        "MADDR:17326 S US 63",
        "X:COUNTY RD 5240 / COUNTY RD 7240",
        "MAP:997",
        "DATE:05/02/2013",
        "TIME:23:31:27");
   
  }
  
  @Test
  public void testRollaRuralFireDistrict() {

    doTest("T1",
        "(Incident# : 13124F5 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13124F5\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- SDO906-Scott Olds\n" +
        "\rAgency Code :- RRF\n" +
        "\rCFS :- FOTH\n" +
        "\rCFS Description :- Fire-Other\n" +
        "\rLocation :- 14010 STATE ROUTE E\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- COUNTY RD 8300 / COUNTY RD 8430\n" +
        "\rZone :- 510\n" +
        "\rArea Of Responsibility :- LE\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/04/2013 17:04:34\n" +
        "\rDispatch DateTime :- 05/04/2013 17:55:34\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/04/2013 17:56:23\n" +
        "\rOrigin ID :- SDO906\n" +
        "\rComment :- CFS Changed From MISSIN To FOTH\n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rComment DateTime :- 05/04/2013 17:56:23\n" +
        "\rOrigin ID :- SDO906\n" +
        "\rComment :- Priority Changed From 1 To 2\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 400\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/04/2013 17:55:34\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 4428\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/04/2013 17:58:31\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13124F5",
        "PRI:2",
        "SRC:RRF",
        "CODE:FOTH",
        "CALL:Fire-Other",
        "ADDR:14010 STATE ROUTE E",
        "MADDR:14010 STATE E",
        "X:COUNTY RD 8300 / COUNTY RD 8430",
        "MAP:510",
        "DATE:05/04/2013",
        "TIME:17:04:34",
        "INFO:CFS Changed From MISSIN To FOTH");

    doTest("T2",
        "(Incident# : 13123F10 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13123F10\n" +
        "\rPriority :- 3\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- SDO906-Scott Olds\n" +
        "\rAgency Code :- RRF\n" +
        "\rCFS :- ODOR\n" +
        "\rCFS Description :- Suspicious Odor\n" +
        "\rLocation :- 11420 CEDAR GROVE LN\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- CEDAR GROVE RD / DEAD END\n" +
        "\rZone :- 510\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/03/2013 17:55:22\n" +
        "\rDispatch DateTime :- 05/03/2013 17:58:33\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/03/2013 17:55:39\n" +
        "\rOrigin ID :- TAG908\n" +
        "\rComment :- SMOKE IN THE BUILDING. SMELLS SOMETHING BURNING. LIGHT SMOKE INT HE BUILDING. DOES NOT SEE ANY FLAMES.\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- CRAIG\n" +
        "\rLast Name :- HALL\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5733684866\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 4414\n" +
        "\rResource Status :- ER\n" +
        "\rStatus DateTime :- 05/03/2013 18:01:25\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 4425\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 18:03:14\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 4493\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 18:03:14\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 400\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 17:58:33\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 4414\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 18:01:19\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13123F10",
        "PRI:3",
        "SRC:RRF",
        "CODE:ODOR",
        "CALL:Suspicious Odor",
        "ADDR:11420 CEDAR GROVE LN",
        "X:CEDAR GROVE RD / DEAD END",
        "MAP:510",
        "DATE:05/03/2013",
        "TIME:17:55:22",
        "INFO:SMOKE IN THE BUILDING. SMELLS SOMETHING BURNING. LIGHT SMOKE INT HE BUILDING. DOES NOT SEE ANY FLAMES.");

    doTest("T3",
        "(Incident# : 13122F8 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13122F8\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- 1-Level 1\n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- CTS807-Charles Satterfield\n" +
        "\rAgency Code :- RRF\n" +
        "\rCFS :- SF\n" +
        "\rCFS Description :- Structure Fire\n" +
        "\rLocation :- 17326 S US HWY 63\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- COUNTY RD 5240 / COUNTY RD 7240\n" +
        "\rZone :- 510\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 05/02/2013 23:31:27\n" +
        "\rDispatch DateTime :- 05/03/2013 01:00:51\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 05/02/2013 23:35:25\n" +
        "\rOrigin ID :- jls917\n" +
        "\rComment :- HOUSE IS TO THE LEFT OF HER, UNK IF IT IS A STRUCTURE, HEARD 2 TO 3 EXPLOSINS.\n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rComment DateTime :- 05/02/2013 23:35:34\n" +
        "\rOrigin ID :- jls917\n" +
        "\rComment :- NO ONE IS AROUND THE FIRE.\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- CAROLYN\n" +
        "\rLast Name :- DOYLE\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5733080904\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 400\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 05/03/2013 01:00:51\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13122F8",
        "PRI:1",
        "SRC:RRF",
        "CODE:SF",
        "CALL:Structure Fire",
        "ADDR:17326 S US HWY 63",
        "MADDR:17326 S US 63",
        "X:COUNTY RD 5240 / COUNTY RD 7240",
        "MAP:510",
        "DATE:05/02/2013",
        "TIME:23:31:27",
        "INFO:HOUSE IS TO THE LEFT OF HER, UNK IF IT IS A STRUCTURE, HEARD 2 TO 3 EXPLOSINS.");

    doTest("T4",
        "(Incident# : 13117F1 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13117F1\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- AKC975-Anthony Craft\n" +
        "\rAgency Code :- RRF\n" +
        "\rCFS :- AMB\n" +
        "\rCFS Description :- Ambulance Needed\n" +
        "\rLocation :- 12750 PRIVATE DR 7085\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- STATE ROUTE CC / DEAD END\n" +
        "\rZone :- 510\n" +
        "\rArea Of Responsibility :- AM\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 04/27/2013 00:27:44\n" +
        "\rDispatch DateTime :- 04/27/2013 00:30:05\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n\n" +
        "\r =>> Name Record \n" +
        "\rReason Code :- CAL\n" +
        "\rDate Of Birth :- \n" +
        "\rAge :- \n" +
        "\rFirst Name :- HELEN\n" +
        "\rLast Name :- WARREN\n" +
        "\rMiddle Name :- \n" +
        "\rSex :- \n" +
        "\rWeight :- \n" +
        "\rHeight :- \n" +
        "\rAddress :- \n" +
        "\rSSN :- \n" +
        "\rRace :- \n" +
        "\rRace Description :- \n" +
        "\rEye Color :- \n" +
        "\rEye Color Description :- \n" +
        "\rHair Color :- \n" +
        "\rHair Color Description :- \n" +
        "\rHome Phone :- 5735782176\n" +
        "\rWork Phone :- \n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 400\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/27/2013 00:30:05\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 4428\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/27/2013 00:34:07\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13117F1",
        "PRI:2",
        "SRC:RRF",
        "CODE:AMB",
        "CALL:Ambulance Needed",
        "ADDR:12750 PRIVATE DR 7085",
        "MADDR:12750 PVT DRIVE 7085",
        "X:STATE ROUTE CC / DEAD END",
        "MAP:510",
        "DATE:04/27/2013",
        "TIME:00:27:44");

    doTest("T5",
        "(Incident# : 13115F14 For Activity Dispatch Resource) \n" +
        "\rCase# :- 13000182\n" +
        "\rJulian Incident# :- 13115F14\n" +
        "\rPriority :- 1\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- AKC975-Anthony Craft\n" +
        "\rAgency Code :- RRF\n" +
        "\rCFS :- 50J2\n" +
        "\rCFS Description :- Accident  Injury\n" +
        "\rLocation :- 17995 S US HWY 63\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- MAGNOLIA CT / COUNTY RD 5300\n" +
        "\rZone :- 510\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 04/25/2013 22:28:52\n" +
        "\rDispatch DateTime :- 04/25/2013 22:32:37\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 04/25/2013 22:29:29\n" +
        "\rOrigin ID :- AEJ996\n" +
        "\rComment :- UNSURE IF INJURED, VEHICLE CRASHED INTO A TREE\n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rComment DateTime :- 04/25/2013 22:36:44\n" +
        "\rOrigin ID :- AKC975\n" +
        "\rComment :- 441 ON THE SCENE OUT FOR INVESTIGATION\n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rComment DateTime :- 04/25/2013 22:40:41\n" +
        "\rOrigin ID :- AKC975\n" +
        "\rComment :- 441 ADVISING ONE PATIENT UNRESTRAINED BLEEDING FROM THE NOSE AIRBAGS DID DEPLOY\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 400\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/25/2013 22:32:37\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 4414\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/25/2013 22:36:43\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 4414\n" +
        "\rResource Status :- ER\n" +
        "\rStatus DateTime :- 04/25/2013 22:37:29\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 4428\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/25/2013 22:43:45\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13115F14",
        "PRI:1",
        "SRC:RRF",
        "CODE:50J2",
        "CALL:Accident  Injury",
        "ADDR:17995 S US HWY 63",
        "MADDR:17995 S US 63",
        "X:MAGNOLIA CT / COUNTY RD 5300",
        "MAP:510",
        "DATE:04/25/2013",
        "TIME:22:28:52",
        "INFO:UNSURE IF INJURED, VEHICLE CRASHED INTO A TREE");

    doTest("T6",
        "(Incident# : 13115F5 For Activity Dispatch Resource) \n" +
        "\rCase# :- \n" +
        "\rJulian Incident# :- 13115F5\n" +
        "\rPriority :- 2\n" +
        "\rAgency Type :- F\n" +
        "\rAlarm Level :- \n" +
        "\rreceive Source :- E-E911 Call in\n" +
        "\rPrimary Officer :- ASK965-Amy King\n" +
        "\rAgency Code :- RRF\n" +
        "\rCFS :- FAMB\n" +
        "\rCFS Description :- Assist Ambulance/First Responders\n" +
        "\rLocation :- 15115 STATE ROUTE F\n" +
        "\rCommon Place :- \n" +
        "\rCross Streets :- COUNTY RD 3210 / COUNTY RD 4110\n" +
        "\rZone :- 510\n" +
        "\rArea Of Responsibility :- FD\n" +
        "\rJuris :- PC-Phelps County\n" +
        "\rMunicipality :- \n" +
        "\rDisposition :- \n" +
        "\rIncident Recv DateTime :- 04/25/2013 12:32:40\n" +
        "\rDispatch DateTime :- 04/25/2013 12:33:33\n" +
        "\rArrive DateTime :- \n" +
        "\rFinish/Clear DateTime :- \n" +
        "\rContain DateTime :- \n\n" +
        "\r =>> Comment Record \n" +
        "\rComment DateTime :- 04/25/2013 12:33:10\n" +
        "\rOrigin ID :- ASK965\n" +
        "\rComment :- FOOT STUCK IN A STUMP GRINDER\n" +
        "\r ---------------------------------------------------------------------------------\n\n" +
        "\r =>> Name Record \n\n" +
        "\r =>> Vehicle Record \n\n" +
        "\r  =>> Resource Activity Record \n" +
        "\rResource# :- 400\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/25/2013 12:33:33\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 4414\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/25/2013 12:36:54\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 4415\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/25/2013 12:36:55\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------\n" +
        "\rResource# :- 401\n" +
        "\rResource Status :- DP\n" +
        "\rStatus DateTime :- 04/25/2013 12:37:38\n" +
        "\rPID :- \n" +
        "\rFirst Name :- \n" +
        "\rLast Name :- \n" +
        "\r ---------------------------------------------------------------------------------",

        "ID:13115F5",
        "PRI:2",
        "SRC:RRF",
        "CODE:FAMB",
        "CALL:Assist Ambulance/First Responders",
        "ADDR:15115 STATE ROUTE F",
        "MADDR:15115 STATE F",
        "X:COUNTY RD 3210 / COUNTY RD 4110",
        "MAP:510",
        "DATE:04/25/2013",
        "TIME:12:32:40",
        "INFO:FOOT STUCK IN A STUMP GRINDER");

  }
  
  public static void main(String[] args) {
    new MOPhelpsCountyParserTest().generateTests("T1");
  }
}