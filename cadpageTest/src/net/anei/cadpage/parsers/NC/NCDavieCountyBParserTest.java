package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Davie County, NC

Contact: Barry Carter <barry2139@gmail.com>
Sender:911@co.davie.nc.us
1 of 4\nFRM:911@co.davie.nc.us\nMSG:911:Call#130329-0643* Address:162 KNOLL CREST RD* * * City:MOCKSVILLE* DEADMON RD* HOLIDAY LN* * Location:NBH:\n(Con't) 2 of 4\nOFF 760 DEADMON RD NEAR WILLBOONE RD* Complaint:21* Desc:CALL BY PHONE* Caller:rex smith* Ph#:336-998-3324* Units:131,132,21,31,33* *\n(Con't) 3 of 4\nMed:Medical: No* Haz:Hazards: No* Narr:03/29/2013 19:49:08 : pos2 : SPHILLIPS 131 REQUESTING EMS 2 PATIENTS, AND FIRE DEPARTMENT WITH CO\n(Con't) 4 of 4\n2 03/29/2013 19:20(End)

Contact: Michael Wilson <fireman1700@gmail.com>
Sender: 911@co.davie.nc.us
911:Call#130414-2488* Address:2030 US HWY 601 N* * * City:MOCKSVILLE* BLAISE CHURCH RD* ASHLEY BRROK LN* * Location:* Complaint:54I* Description:HIT & RUN/INJURY
911:Call#130419-3256* Address:US HWY 601 N // EATONS CHURCH RD* * * City:MOCKSVILLE* EATONS CHURCH RD* MACY LANGSTON LN* * Location:* Complaint:50PI* Description

Contact: adoubdsd@aol.com <adoubdsd@aol.com>
Sender: 911@co.davie.nc.us 
911:Call#130328-0420* Address:1869 US HWY 601 N* * * City:MOCKSVILLE* DISTRICT LINE* QUALITY DR* * LocCmmt:NBH: BETWEEN BRANTLEY FARM RD & QUALITY DR* Comp:6D2*Eff 
911:Call#130328-0436* Address:221 JOLLEY RD* * * City:MOCKSVILLE* US HWY 601 N* US HWY 601 N* * LocCmmt:NBH: OFF 3022 US HWY 601 N TO 3160 US HWY 601 N* Comp:MED
911:Call#130329-0559* Address:421 ALLEN RD* * * City:MOCKSVILLE* HIDDEN VALLEY LN* DEADEND* * Location:Special Comment:: MR TRIVETTE IS TAKING MEDICINE CAUSING C
911:Call#130414-2573* Address:146 MCBRIDE LN* * * City:MOCKSVILLE* SPEER RD* DEADEND* * Location:NBH: OFF 250 SPEER RD OFF 500 BLOCK ELMORE RD* Complaint:26C1* D
911:Call#130419-3256* Address:US HWY 601 N // EATONS CHURCH RD* * * City:MOCKSVILLE* EATONS CHURCH RD* MACY LANGSTON LN* * Location:* Complaint:50PI* Description
911:Call#130423-3781* Address:183 R SHORE DR* * * City:MOCKSVILLE* US HWY 601 N* US HWY 601 N* * Location:NBH: FROM 4584 TO 4612 US HWY 601 NORTH ACROSS FROM BAI

Contact: Lisa Thomas <sislisathomas@gmail.com>
Sender: 911@co.davie.nc.us
911:Call#130615-0325* Address:321 AVON ST* * * City:MOCKSVILLE* RAYMOND ST* S TOT ST* * Location:NBH: 100 BLOCK RAYMOND ST TO 400 BLOCK TOT ST* Complaint:FALL* D

Contact: Active911
New format - multiple agencies
Sender: 911@co.davie.nc.us

911:Call#130327-0331* Address:124 ROSEWALK LN* * * City:ADVANCE* TOWNPARK DR* NORTH FIELD DR* * LocCmmt:Geo Comment: KINDERTON DEVELOPMENT NBH: OFF 200 BLK TOWNPARK DR OFF OLD TOWNE DR* Comp:HC* Desc:HAZARDOUS CONDITION* Caller:KOHLER,BILLIE* Ph#:336-940-4275* Units:24* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 11:28:05 : pos1 : JJASTER Cross streets: TOWNPARK DR//NORTH FIELD DR Geo Comm
911:Call#130327-0312* Address:130 OLEANDER DR* * * City:ADVANCE* HOLLYBROOK DR* HOLLYBROOK DR* * LocCmmt:NBH: 140 HOLLYBROOK TO 180 HOLLYBROOK OFF BERMUDA VILL DR* Comp:FALL* Desc:FALL* Caller:CHURCH EVELYN HESTER* Ph#:336-940-6575* Units:24* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 08:46:56 : pos1 : JJASTER ** EMD Case Entry Finished ** Chief Complaint Number: 17 Key Questions: 64 year
911:Call#130326-0272* Address:102 I40 EB* * * City:MOCKSVILLE* 601 NORTH* FARMINGTON RD* * LocCmmt:* Comp:VF* Desc:VEHICLE FIRE* Caller:NC DEPT OF TRANSPORTATION* Ph#:336-940-5627* Units:23,24* * Med:Medical: No* Haz:Hazards: No* Narr:03/26/2013 21:13:00 : pos4 : RPIERCE Cross streets: 601 NORTH//FARMINGTON RD black blazer on the camper side caller advised looked like something was on fire inside 
911:Call#130326-0272* Address:102 I40 EB* * * City:MOCKSVILLE* 601 NORTH* FARMINGTON RD* * LocCmmt:* Comp:VF* Desc:VEHICLE FIRE* Caller:NC DEPT OF TRANSPORTATION* Ph#:336-940-5627* Units:13* * Med:Medical: No* Haz:Hazards: No* Narr:03/26/2013 21:13:00 : pos4 : RPIERCE Cross streets: 601 NORTH//FARMINGTON RD black blazer on the camper side caller advised looked like something was on fire inside the front of the blazer*
911:Call#130327-0331* Address:124 ROSEWALK LN* * * City:ADVANCE* TOWNPARK DR* NORTH FIELD DR* * LocCmmt:Geo Comment: KINDERTON DEVELOPMENT NBH: OFF 200 BLK TOWNPARK DR OFF OLD TOWNE DR* Comp:HC* Desc:HAZARDOUS CONDITION* Caller:KOHLER,BILLIE* Ph#:336-940-4275* Units:23,24* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 11:28:05 : pos1 : JJASTER Cross streets: TOWNPARK DR//NORTH FIELD DR Geo Comment: KINDERTON DEVELOPMENT NBH: OFF 200 BLK TOWNPARK DR OFF OLD TOWNE DR Cross streets: US HWY 158//DEADEND NBH: OFF 4900 BLOCK US HWY 158 STRONG SMELL OUTSIDE ..SMELLS LIKE ONIONS.. WANTS FD TO COME CHECK AND SEE IF GAS .. OUTSIDE*
911:Call#130327-0307* Address:219 DUTCHMAN TRL* * * City:MOCKSVILLE* PATRICIA WA* PATRICIA WA* * LocCmmt:NBH: OFF 338 FARMINGTON RD* Comp:6D2* Desc:BREATHING PROBLEMS* Caller:REAVIS JEFFERY* Ph#:336-940-2619* Units:23,32* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 08:01:55 : pos1 : JJASTER ** EMD Case Complete ** Key Questions: 54 year old, Female, Conscious, Breathing. 03/27/2013 08:01:26 : pos1 : JJASTER ** EMD Key Questions Finished ** Key Questions: 5.She has a prescribed inhaler. * 6.She has used a prescribed inhaler. * 7.N/A 03/27/2013 08:01:18 : pos1 : JJASTER ** EMD Reconfigure ** Response Text: Delta Dispatch Level: 06D02 Suffix: A CAD Incident Code: 6D2 Key Questions: DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma). * 3.She is not clammy. * 4.She has asthma. 03/27/2013 08:01:11 : pos1 : JJASTER ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 06D02 CAD Incident Code: 6D2 Key Questions: DIFFICULTY SPEAKING BETWEEN BREATHS. * 1.She is completely alert 
911:Call#130326-0272* Address:102 I40 EB* * * City:MOCKSVILLE* 601 NORTH* FARMINGTON RD* * LocCmmt:* Comp:VF* Desc:VEHICLE FIRE* Caller:NC DEPT OF TRANSPORTATION* Ph#:336-940-5627* Units:13,23* * Med:Medical: No* Haz:Hazards: No* Narr:03/26/2013 21:13:00 : pos4 : RPIERCE Cross streets: 601 NORTH//FARMINGTON RD black blazer on the camper side caller advised looked like something was on fire inside the front of the blazer*
911:Call#130327-0312* Address:130 OLEANDER DR* * * City:ADVANCE* HOLLYBROOK DR* HOLLYBROOK DR* * LocCmmt:NBH: 140 HOLLYBROOK TO 180 HOLLYBROOK OFF BERMUDA VILL DR* Comp:FALL* Desc:FALL* Caller:CHURCH EVELYN HESTER* Ph#:336-940-6575* Units:24,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 08:46:56 : pos1 : JJASTER ** EMD Case Entry Finished ** Chief Complaint Number: 17 Key Questions: 64 year old, Male, Conscious, Breathing. Falls. Caller Statement: SON FELL AND HIT HEAD . 03/27/2013 08:46:34 : pos1 : JJASTER Cross streets: HOLLYBROOK DR//HOLLYBROOK DR NBH: 140 HOLLYBROOK TO 180 HOLLYBROOK OFF BERMUDA VILL DR HEAD INJ*
911:Call#130327-0307* Address:219 DUTCHMAN TRL* * * City:MOCKSVILLE* PATRICIA WA* PATRICIA WA* * LocCmmt:NBH: OFF 338 FARMINGTON RD* Comp:6D2* Desc:BREATHING PROBLEMS* Caller:REAVIS JEFFERY* Ph#:336-940-2619* Units:23,32,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 08:01:55 : pos1 : JJASTER ** EMD Case Complete ** Key Questions: 54 year old, Female, Conscious, Breathing. 03/27/2013 08:01:26 : pos1 : JJASTER ** EMD Key Questions Finished ** Key Questions: 5.She has a prescribed inhaler. * 6.She has used a prescribed inhaler. * 7.N/A 03/27/2013 08:01:18 : pos1 : JJASTER ** EMD Reconfigure ** Response Text: Delta Dispatch Level: 06D02 Suffix: A CAD Incident Code: 6D2 Key Questions: DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma). * 3.She is not clammy. * 4.She has asthma. 03/27/2013 08:01:11 : pos1 : JJASTER ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 06D02 CAD Incident Code: 6D2 Key Questions: DIFFICULTY SPEAKING BETWEEN BREATHS. * 1.She is completely al
911:Call#130327-0296* Address:622 N MAIN ST* * * City:MOCKSVILLE* POPLAR ST* HEMLOCK ST* * LocCmmt:NBH: OFF 100 POPLAR ST TO 100 HEMLOCK ST* Comp:FALL* Desc:FALL* Caller:BRENT HALL* Ph#:336-469-9339* Units:22,31,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 05:58:18 : pos1 : SPHILLIPS Cross streets: POPLAR ST//HEMLOCK ST Landmark: B C BROCK NBH: OFF 100 POPLAR ST TO 100 HEMLOCK ST Cross streets: CUSTOM DR//CITY LIMITS NBH: OFF 1098 SALISBURY RD COME IN THROUGH THE BACK*
911:Call#130327-0290* Address:3037 SANDY SPRINGS RD* * * City:STATESVILLE* * * * LocCmmt:* Comp:SF* Desc:STRUCTURE FIRE* Caller:IREDELL COUNTY ECOM* Ph#:704-878-3039* Units:16* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 01:42:12 : pos1 : SPHILLIPS STATION 16*

Contact: Active911
Agency name: Smith Grove Fire Department
Location: Advance, NC, United States
Sender: 911@co.davie.nc.us

911:Call#130330-0681* Address:115 S MILLBROOKE CT* * * City:ADVANCE* MILL COVE DR* DEAD END* * Location:NBH: OFF 200 BLK N HIDDENBROOK OFF 150 BLOK TWIN CREEK* Complaint:26D1* Desc:SICK PERSON (SPECIFIC DIAGNOSIS)* Caller:GAY WILLIAM W* Ph#:336-940-4082* Units:24* * Med:Medical: No* Haz:Hazards: No* Narr:03/30/2013 05:16:18 : pos1 : TWMYERS ** EMD Recommended Dispatch ** Response Text: Delta Dispa
911:Call#130329-0628* Address:278 JESSE KING RD* * * City:ADVANCE* PEACEFUL VALLEY RD* DEADEND* * Location:NBH: OFF 1300 BLOCK YADKIN VALLEY RD* Complaint:GWB* Desc:GRASS/WOODS/BRUSH FIRE* Caller:cary mcguire* Ph#:336-618-5274* Units:23,24,FOR1,FOR2* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 16:44:35 : pos2 : JALLGOOD Cross streets: PEACEFUL VALLEY RD//DEADEND NBH: OFF 1300 BLOCK YADKIN 
911:Call#130329-0595* Address:134 DONREE LN* * * City:MOCKSVILLE* US HWY 158* DEADEND* * Location:NBH: OFF 2144 US HWY 158 ACROSS FROM WHITAKER RD* Complaint:FA* Desc:FIRE ALARM* Caller:cpi* Ph#:800-948-7133* Units:22,24* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 12:55:25 : pos2 : JALLGOOD Cross streets: US HWY 158//DEADEND NBH: OFF 2144 US HWY 158 ACROSS FROM WHITAKER RD beverly pilcher

Contact: Active911
Agency name: Clemmons Fire Department
Location: Clemmons, NC, United States
Sender: FCFD <forsythcountyfir@bellsouth.net>

911:Call#130329-0596* Address:622 RIVERBEND DR* * * City:ADVANCE* SPYGLASS DR* SPYGLASS DR* * Location:Geo Comment: BERMUDA RUN DEV* Complaint:RD* Desc:RESPIRATORY DISTRESS* Caller:WHITMAN, CHARLES H* Ph#:336-998-4309* Units:32,FC14* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 13:25:46 : pos1 : SFRYE Cross streets: SPYGLASS DR//SPYGLASS DR Geo Comment: BERMUDA RUN DEV*
911:Call#130328-0464* Address:112 E KINDERTON WA* * * City:ADVANCE* ABERCORN WAY* DEADEND* * Location:Geo Comment: KINDERTON DEV NBH: OFF ABERCORN OFF DORNACH WA OFF KINDERTON BLV* Complaint:TRA* Desc:TRANSPORT* Caller:faith* Ph#:336-941-3118* Units:31,FC14* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 13:09:59 : pos2 : JJASTER Cross streets: ABERCORN WAY//DEADEND Geo Comment: KINDERTON DEV NBH: OFF ABERCORN OFF DORNACH WA OFF KINDERTON BLV 03/28/2013 13:06:22 : pos4 : ABURTON 10-18 80 yr old female not responsvive they are bagging*

Agency name: Cooleemee Fire Department
Location: Cooleemee, NC, United States
Contact: Active911
Sender: 911@co.davie.nc.us

911:Call#130330-0682* Address:176 MIDWAY ST* * * City:COOLEEMEE* RAMARS CT* GROVE ST* * Location:NBH: 100 BLOCK RAMARS CT TO 277 GROVE ST* Complaint:MED* Desc:MEDICAL CALL* Caller:BROWN, WALTER* Ph#:336-284-2835* Units:14* * Med:Medical: No* Haz:Hazards: No* Narr:03/30/2013 05:20:28 : pos1 : TWMYERS Cross streets: RAMARS CT//GROVE ST NBH: 100 BLOCK RAMARS CT TO 277 GROVE ST*

Contact: Active911
Agency name: Mocksville Center Fire Department
Location: Mocksville, NC, United States
Sender: 911@co.davie.nc.us

911:Call#130330-0708* Address:202 POWELL RD* * * City:MOCKSVILLE* US HWY 64 W* ALLISON LN* * Location:NBH: OFF 2152 US HWY 64 W* Complaint:MED* Desc:MEDICAL CALL* Caller:* Ph#:336-655-4441* Units:13* * Med:Medical: No* Haz:Hazards: No* Narr:03/30/2013 10:27:43 : pos1 : JALLGOOD ** EMD Case Entry Finished ** Chief Complaint Number: 31 Key Questions: 59 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Caller Statement: mother is sick with brain swelling . 03/30/2013 10:26:52 : pos2 : JBYERLY Call 130330-0707, 130330-0708 are related. 03/30/2013 10:26:28 : pos2 : JBYERLY Cross streets: US HWY 64 W//ALLISON LN NBH: OFF 2152 US HWY 64 W*
911:Call#130329-0543* Address:482 POWELL RD* * * City:MOCKSVILLE* ALLISON LN* GODBEY RD* * Location:NBH: FROM 466 GODBEY RD TO 2152 US HWY 64 W* Complaint:SEI* Desc:SEIZURE* Caller:GALE PAUL H* Ph#:336-492-6322* Units:13* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 02:29:57 : pos2 : SSPEER Cross streets: ALLISON LN//GODBEY RD NBH: FROM 466 GODBEY RD TO 2152 US HWY 64 W*

Agency name: Fork Fire Department
Location: Advance, NC, United States
Contact: Active911
Sender: 911@co.davie.nc.us

911:Call#130329-0639* Address:1617 PEOPLES CREEK RD* * * City:ADVANCE* MARCHMONT DR* SOUTHERN MAGNOLIA DR* * Location:NBH: OFF 2500 BLOCK 801 SOUTH ADVANCE END* Complaint:SF* Desc:STRUCTURE FIRE* Caller:JONES PATRICIA R* Ph#:336-998-7073* Units:12,15,19,32* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 18:09:34 : pos2 : JALLGOOD Cross streets: MARCHMONT DR//SOUTHERN MAGNOLIA DR NBH: OFF 2500 BLOCK 801 SOUTH ADVANCE END*

Contact: Active911
Agency name: Farmington Volunteer Fire Department
Location: Mocksville, NC, United States
Sender: 911@co.davie.nc.us

911:Call#130329-0628* Address:278 JESSE KING RD* * * City:ADVANCE* PEACEFUL VALLEY RD* DEADEND* * Location:NBH: OFF 1300 BLOCK YADKIN VALLEY RD* Complaint:GWB* Desc:GRASS/WOODS/BRUSH FIRE* Caller:cary mcguire* Ph#:336-618-5274* Units:23* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 16:44:35 : pos2 : JALLGOOD Cross streets: PEACEFUL VALLEY RD//DEADEND NBH: OFF 1300 BLOCK YADKIN VALLEY RD Cross streets: US HWY 158//DEADEND NBH: OFF 4900 BLOCK US HWY 158*
911:Call#130328-0484* Address:295 ESSIC RD* * * City:MOCKSVILLE* DISTRICT LINE* BONKIN LAKE RD* * Location:NBH: OFF 4082 HWY 801 N FROM BONKIN LAKE RD TO CAP CAIN RD* Complaint:VF* Desc:VEHICLE FIRE* Caller:VERIZON WIRELESS* Ph#:336-486-1480* Units:23,YC19* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 15:11:34 : pos2 : JJASTER VEH FULLY INVOLVED 03/28/2013 15:11:21 : pos2 : JJASTER Cross streets: DISTRICT LINE//BONKIN LAKE RD NBH: OFF 4082 HWY 801 N FROM BONKIN LAKE RD TO CAP CAIN RD*
911:Call#130328-0420* Address:1869 NC HWY 801 N* * * City:MOCKSVILLE* RHYNEHARDT RD* CEDAR FOREST LN* * LocCmmt:* Comp:RD* Desc:RESPIRATORY DISTRESS* Caller:matthew breyer* Ph#:336-480-8928* Units:23* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 06:50:14 : pos1 : KBROOKS Cross streets: RHYNEHARDT RD//CEDAR FOREST LN Cross streets: US HWY 601 N//THEODORE DR*
911:Call#130327-0331* Address:124 ROSEWALK LN* * * City:ADVANCE* TOWNPARK DR* NORTH FIELD DR* * LocCmmt:Geo Comment: KINDERTON DEVELOPMENT NBH: OFF 200 BLK TOWNPARK DR OFF OLD TOWNE DR* Comp:HC* Desc:HAZARDOUS CONDITION* Caller:KOHLER,BILLIE* Ph#:336-940-4275* Units:23,24* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 11:28:05 : pos1 : JJASTER Cross streets: TOWNPARK DR//NORTH FIELD DR Geo Comment: KINDERTON DEVELOPMENT NBH: OFF 200 BLK TOWNPARK DR OFF OLD TOWNE DR Cross streets: US HWY 158//DEADEND NBH: OFF 4900 BLOCK US HWY 158 STRONG SMELL OUTSIDE ..SMELLS LIKE ONIONS.. WANTS FD TO COME CHECK AND SEE IF GAS .. OUTSIDE*
911:Call#130327-0307* Address:219 DUTCHMAN TRL* * * City:MOCKSVILLE* PATRICIA WA* PATRICIA WA* * LocCmmt:NBH: OFF 338 FARMINGTON RD* Comp:6D2* Desc:BREATHING PROBLEMS* Caller:REAVIS JEFFERY* Ph#:336-940-2619* Units:23,32* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 08:01:55 : pos1 : JJASTER ** EMD Case Complete ** Key Questions: 54 year old, Female, Conscious, Breathing. 03/27/2013 08:01:26 : pos1 : JJASTER ** EMD Key Questions Finished ** Key Questions: 5.She has a prescribed inhaler. * 6.She has used a prescribed inhaler. * 7.N/A 03/27/2013 08:01:18 : pos1 : JJASTER ** EMD Reconfigure ** Response Text: Delta Dispatch Level: 06D02 Suffix: A CAD Incident Code: 6D2 Key Questions: DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma). * 3.She is not clammy. * 4.She has asthma. 03/27/2013 08:01:11 : pos1 : JJASTER ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 06D02 CAD Incident Code: 6D2 Key Questions: DIFFICULTY SPEAKING BETWEEN BREATHS. * 1.She is completely alert 
911:Call#130326-0272* Address:102 I40 EB* * * City:MOCKSVILLE* 601 NORTH* FARMINGTON RD* * LocCmmt:* Comp:VF* Desc:VEHICLE FIRE* Caller:NC DEPT OF TRANSPORTATION* Ph#:336-940-5627* Units:13,23* * Med:Medical: No* Haz:Hazards: No* Narr:03/26/2013 21:13:00 : pos4 : RPIERCE Cross streets: 601 NORTH//FARMINGTON RD black blazer on the camper side caller advised looked like something was on fire inside the front of the blazer*

Contact: Active911
Agency name: Davie Rescue
Location: Mocksville, NC, United States
Sender: 911@co.davie.nc.us

911:Call#130330-0708* Address:202 POWELL RD* * * City:MOCKSVILLE* US HWY 64 W* ALLISON LN* * Location:NBH: OFF 2152 US HWY 64 W* Complaint:MED* Desc:MEDICAL CALL* Caller:* Ph#:336-655-4441* Units:13,34,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/30/2013 10:27:43 : pos1 : JALLGOOD ** EMD Case Entry Finished ** Chief Complaint Number: 31 Key Questions: 59 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Caller Statement: mother is sick with brain swelling . 03/30/2013 10:26:52 : pos2 : JBYERLY Call 130330-0707, 130330-0708 are related. 03/30/2013 10:26:28 : pos2 : JBYERLY Cross streets: US HWY 64 W//ALLISON LN NBH: OFF 2152 US HWY 64 W*
911:Call#130330-0682* Address:176 MIDWAY ST* * * City:COOLEEMEE* RAMARS CT* GROVE ST* * Location:NBH: 100 BLOCK RAMARS CT TO 277 GROVE ST* Complaint:MED* Desc:MEDICAL CALL* Caller:BROWN, WALTER* Ph#:336-284-2835* Units:14,33,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/30/2013 05:20:28 : pos1 : TWMYERS Cross streets: RAMARS CT//GROVE ST NBH: 100 BLOCK RAMARS CT TO 277 GROVE ST*
911:Call#130330-0681* Address:115 S MILLBROOKE CT* * * City:ADVANCE* MILL COVE DR* DEAD END* * Location:NBH: OFF 200 BLK N HIDDENBROOK OFF 150 BLOK TWIN CREEK* Complaint:26D1* Desc:SICK PERSON (SPECIFIC DIAGNOSIS)* Caller:GAY WILLIAM W* Ph#:336-940-4082* Units:24,32,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/30/2013 05:16:23 : pos1 : TWMYERS ** EMD Key Questions Finished ** Key Questions: 2.His primary problem is fever/chills. 03/30/2013 05:16:18 : pos1 : TWMYERS ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 26D01 CAD Incident Code: 26D1 Key Questions: Not alert. * 1.He is not completely alert (not responding appropriately). 03/30/2013 05:16:09 : pos1 : TWMYERS ** EMD Case Entry Finished ** Chief Complaint Number: 26 Key Questions: 87 year old, Male, Conscious, Breathing. Sick Person (Specific Diagnosis). Caller Statement: HIGH FEVER. 03/30/2013 05:15:51 : pos1 : TWMYERS Cross streets: MILL COVE DR//DEAD END NBH: OFF 200 BLK N HIDDENBROOK OFF 150 BLOK TWIN 
911:Call#130329-0596* Address:622 RIVERBEND DR* * * City:ADVANCE* SPYGLASS DR* SPYGLASS DR* * Location:Geo Comment: BERMUDA RUN DEV* Complaint:RD* Desc:RESPIRATORY DISTRESS* Caller:WHITMAN, CHARLES H* Ph#:336-998-4309* Units:32,FC14,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 13:25:46 : pos1 : SFRYE Cross streets: SPYGLASS DR//SPYGLASS DR Geo Comment: BERMUDA RUN DEV*
911:Call#130329-0559* Address:421 ALLEN RD* * * City:MOCKSVILLE* HIDDEN VALLEY LN* DEADEND* * Location:Special Comment:: MR TRIVETTE IS TAKING MEDICINE CAUSING CONFUSION NBH: OFF 2100 BLOCK US HWY 601 N* Complaint:CVA* Desc:STROKE* Caller:133* Ph#:336-492-7471* Units:17,31,ST4* * Med:Medical: Yes* Haz:Hazards: No* Narr:03/29/2013 09:28:56 : pos1 : SFRYE Special Comment:: MR TRIVETTE IS TAKING MEDICINE CAUSING CONFUSION Cross streets: HIDDEN VALLEY LN//DEADEND NBH: OFF 2100 BLOCK US HWY 601 N*
911:Call#130329-0543* Address:482 POWELL RD* * * City:MOCKSVILLE* ALLISON LN* GODBEY RD* * Location:NBH: FROM 466 GODBEY RD TO 2152 US HWY 64 W* Complaint:SEI* Desc:SEIZURE* Caller:GALE PAUL H* Ph#:336-492-6322* Units:13,34,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 02:29:57 : pos2 : SSPEER Cross streets: ALLISON LN//GODBEY RD NBH: FROM 466 GODBEY RD TO 2152 US HWY 64 W*
911:Call#130328-0523* Address:235 DEADMON RD* * * City:MOCKSVILLE* US HWY 601 S* REDWOOD DR* * Location:NBH: OFF 1590 US HWY 601 S* Complaint:50PI* Desc:ACCIDENT/INJURY* Caller:FISHER DOROTHY E* Ph#:336-753-0675* Units:21,33,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 21:07:56 : pos4 : ABURTON Cross streets: US HWY 601 S//REDWOOD DR NBH: OFF 1590 US HWY 601 S 2 VEHICLES UNBKNOWN INJURIES*
911:Call#130328-0506* Address:253 CAMPBELL RD* * * City:MOCKSVILLE* HOLMAN ST* HEWITT LN* * Location:NBH: OFF 1000 N MAIN ST* Complaint:50PI* Desc:ACCIDENT/INJURY* Caller:VERIZON* Ph#:336-909-0711* Units:22,31,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 19:03:12 : pos2 : JJASTER Cross streets: HOLMAN ST//HEWITT LN NBH: OFF 1000 N MAIN ST CAMEL//*
911:Call#130328-0481* Address:1281 DAVIE ACADEMY RD* * * City:MOCKSVILLE* JONES RD* BLUEGRASS TR* * Location:* Complaint:MED* Desc:MEDICAL CALL* Caller:VERIZON WIRELESS* Ph#:336-909-3305* Units:18,34,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 15:02:08 : pos4 : ABURTON ** EMD Case Entry Finished ** Chief Complaint Number: 30 Key Questions: 61 year old, Female, Conscious, Breathing. Traumatic Injuries (Specific). Caller Statement: broke arm. 03/28/2013 15:01:49 : pos4 : ABURTON Cross streets: JONES RD//BLUEGRASS TR*
911:Call#130328-0464* Address:112 E KINDERTON WA* * * City:ADVANCE* ABERCORN WAY* DEADEND* * Location:Geo Comment: KINDERTON DEV NBH: OFF ABERCORN OFF DORNACH WA OFF KINDERTON BLV* Complaint:TRA* Desc:TRANSPORT* Caller:faith* Ph#:336-941-3118* Units:31,FC14,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 13:09:59 : pos2 : JJASTER Cross streets: ABERCORN WAY//DEADEND Geo Comment: KINDERTON DEV NBH: OFF ABERCORN OFF DORNACH WA OFF KINDERTON BLV 03/28/2013 13:06:22 : pos4 : ABURTON 10-18 80 yr old female not responsvive they are bagging*

Contact: Active911
Agency name: Advance Fire Department
Location: Advance, NC, United States
Sender: 911@co.davie.nc.us

911:Call#130329-0639* Address:1617 PEOPLES CREEK RD* * * City:ADVANCE* MARCHMONT DR* SOUTHERN MAGNOLIA DR* * Location:NBH: OFF 2500 BLOCK 801 SOUTH ADVANCE END* Complaint:SF* Desc:STRUCTURE FIRE* Caller:JONES PATRICIA R* Ph#:336-998-7073* Units:12* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 18:09:34 : pos2 : JALLGOOD Cross streets: MARCHMONT DR//SOUTHERN MAGNOLIA DR NBH: OFF 2500 BLOCK 801 SOUTH ADVANCE END*
911:Call#130327-0338* Address:190 DESTINY TRL* * * City:ADVANCE* POTTS RD* DEADEND* * LocCmmt:NBH: OFF 300 BLOCK POTTS RD* Comp:RD* Desc:RESPIRATORY DISTRESS* Caller:AT&T MOBILITY* Ph#:336-655-3549* Units:12* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 12:42:51 : pos1 : JJASTER Cross streets: POTTS RD//DEADEND NBH: OFF 300 BLOCK POTTS RD*

Contact: Active911
Agency name: Mocksville Fire Department
Location: Mocksville, NC, United States
Sender: 911@co.davie.nc.us

911:Call#130329-0609* Address:109 ROLLINGWOOD DR* * * City:MOCKSVILLE* SALISBURY RD* RANDOM RD* * Location:NBH: OFF 1340 SALISBURY RD BELOW DAVIE HIGH--SOUTHWOOD DEV* Complaint:GWB* Desc:GRASS/WOODS/BRUSH FIRE* Caller:* Ph#:336- -* Units:22* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 15:10:18 : pos1 : SFRYE Cross streets: SALISBURY RD//RANDOM RD NBH: OFF 1340 SALISBURY RD BELOW DAVIE HIGH--SOUTHWOOD DEV*
911:Call#130329-0595* Address:134 DONREE LN* * * City:MOCKSVILLE* US HWY 158* DEADEND* * Location:NBH: OFF 2144 US HWY 158 ACROSS FROM WHITAKER RD* Complaint:FA* Desc:FIRE ALARM* Caller:cpi* Ph#:800-948-7133* Units:22* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 12:55:25 : pos2 : JALLGOOD Cross streets: US HWY 158//DEADEND NBH: OFF 2144 US HWY 158 ACROSS FROM WHITAKER RD beverly pilcher upstairs smoke alarm*
911:Call#130329-0593* Address:817 SALISBURY RD* * * City:MOCKSVILLE* CITY LIMITS* KAYDON DR* * Location:* Complaint:ATL* Desc:ATTEMPT TO LOCATE* Caller:SPRINT NEXTEL - CDMA* Ph#:704-273-9519* Units:212,22* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 12:40:46 : pos1 : SFRYE Cross streets: CITY LIMITS//KAYDON DR Landmark: MOCKSVILLE CAR WASH Cross streets: CUSTOM DR//CITY LIMITS NBH: OFF 1098 SALISBURY RD GOLD SATURN BHZ-6638*
911:Call#130328-0506* Address:253 CAMPBELL RD* * * City:MOCKSVILLE* HOLMAN ST* HEWITT LN* * Location:NBH: OFF 1000 N MAIN ST* Complaint:50PI* Desc:ACCIDENT/INJURY* Caller:VERIZON* Ph#:336-909-0711* Units:22* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 19:03:12 : pos2 : JJASTER Cross streets: HOLMAN ST//HEWITT LN NBH: OFF 1000 N MAIN ST CAMEL//*
911:Call#130327-0296* Address:622 N MAIN ST* * * City:MOCKSVILLE* POPLAR ST* HEMLOCK ST* * LocCmmt:NBH: OFF 100 POPLAR ST TO 100 HEMLOCK ST* Comp:FALL* Desc:FALL* Caller:BRENT HALL* Ph#:336-469-9339* Units:22* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 05:58:18 : pos1 : SPHILLIPS Cross streets: POPLAR ST//HEMLOCK ST Landmark: B C BROCK NBH: OFF 100 POPLAR ST TO 100 HEMLOCK ST Cross streets: CUSTOM DR//CITY LIMITS NBH: OFF 1098 SALISBURY RD COME IN THROUGH THE BACK*

Contact: Active911
Agency name: Sheffield Calahaln VFD
Location: Mocksville, NC, United States
Sender: 911@co.davie.nc.us

911:Call#130327-0290* Address:3037 SANDY SPRINGS RD* * * City:STATESVILLE* * * * LocCmmt:* Comp:SF* Desc:STRUCTURE FIRE* Caller:IREDELL COUNTY ECOM* Ph#:704-878-3039* Units:16* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 01:42:12 : pos1 : SPHILLIPS STATION 16*

Agency name: County Line Fire Department
Location: Mocksville, NC, United States
Contact: Active911
Sender: 911@co.davie.nc.us

911:Call#130415-2671* Address:164 I40 WB* * * City:MOCKSVILLE* IREDELL COUNTY LINE* 64 W AT CENTER* * Location:* Complaint:50PI* Description:ACCIDENT/INJURY* Caller:VERIZON WIRELESS* Ph#:864-590-9259* Units:18,31,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:04/15/2013 16:22:58 : pos4 : ABURTON Cross streets: IREDELL COUNTY LINE//64 W AT CENTER 04/15/2013 16:22:21 : pos4 : ABURTON 2 VEHICLE S*
911:Call#130415-2667* Address:162 I40 WB* * * City:MOCKSVILLE* IREDELL COUNTY LINE* 64 W AT CENTER* * Location:* Complaint:50PI* Description:ACCIDENT/INJURY* Caller:SPRINT NEXTEL - CDMA* Ph#:336-477-4206* Units:13,31,ST4,18* * Med:Medical: No* Haz:Hazards: No* Narr:04/15/2013 16:19:22 : pos2 : TJONES Cross streets: IREDELL COUNTY LINE//64 W AT CENTER Cross streets: DAVIE FARMS TR//WOOD VALE DR*
911:Call#130413-2349* Address:103 VAUGHN MILL RD* * * City:STATESVILLE* * * * Location:* Complaint:SF* Description:STRUCTURE FIRE* Caller:IREDELL COUNTY* Ph#:704-878-3039* Units:16,18,1802,18PV* * Med:Medical: No* Haz:Hazards: No* Narr:04/13/2013 02:34:58 : pos1 : SPHILLIPS BARN FIRE*
911:Call#130413-2349* Address:103 FAWN MILL RD* * * City:MOCKSVILLE* * * * Location:* Complaint:SF* Description:STRUCTURE FIRE* Caller:IREDELL COUNTY* Ph#:704-878-3039* Units:16,18* * Med:Medical: No* Haz:Hazards: No* Narr:04/13/2013 02:34:58 : pos1 : SPHILLIPS BARN FIRE*
911:Call#130412-2337* Address:I40* * * City:STATESVILLE* * * * Location:* Complaint:50PI* Description:ACCIDENT/INJURY* Caller:* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:*
911:Call#130412-2263* Address:167 I40 EB* * * City:MOCKSVILLE* IREDELL COUNTY LINE* 64 WEST AT CENTER* * Location:* Complaint:50PD* Description:ACCIDENT/DAMAGE* Caller:VERIZON* Ph#:919-721-0078* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:04/12/2013 15:44:21 : pos4 : SFRYE Cross streets: IREDELL COUNTY LINE//64 WEST AT CENTER Cross streets: DAVIE FARMS TR//WOOD VALE DR SILVER HONDA*
911:Call#130411-2029* Address:2464 OLD MOCKSVILLE RD* * * City:HARMONY* * * * Location:* Complaint:FALL* Description:FALL* Caller:IRC* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:*
911:Call#130406-1503* Address:155 I40 MEDIAN* * * City:MOCKSVILLE* * * * Location:* Complaint:GWB* Desc:GRASS/WOODS/BRUSH FIRE* Caller:* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:*
911:Call#130404-1330* Address:163 I40 EB* * * City:MOCKSVILLE* IREDELL COUNTY LINE* 64 WEST AT CENTER* * Location:* Complaint:50PI* Desc:ACCIDENT/INJURY* Caller:ADAMS, RACHEL* Ph#:315-416-6262* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:04/04/2013 19:15:01 : pos2 : SPHILLIPS Cross streets: IREDELL COUNTY LINE//64 WEST AT CENTER 04/04/2013 19:14:47 : pos2 : SPHILLIPS Cross streets: IREDELL COUNTY LINE//64 WEST AT CENTER Cross streets: DAVIE FARMS TR//WOOD VALE DR SILVER*
911:Call#130404-1294* Address:162 I40 EB* * * City:MOCKSVILLE* IREDELL COUNTY LINE* 64 WEST AT CENTER* * Location:* Complaint:58* Desc:DIRECT TRAFFIC* Caller:101* Ph#:336- -* Units:101,110,18* * Med:Medical: No* Haz:Hazards: No* Narr:04/04/2013 15:19:33 : pos2 : JALLGOOD Cross streets: IREDELL COUNTY LINE//64 WEST AT CENTER 04/04/2013 14:56:44 : pos2 : JALLGOOD Cross streets: IREDELL COUNTY LINE//64 W AT CENTER*
911:Call#130328-0481* Address:1281 DAVIE ACADEMY RD* * * City:MOCKSVILLE* JONES RD* BLUEGRASS TR* * Location:* Complaint:MED* Desc:MEDICAL CALL* Caller:VERIZON WIRELESS* Ph#:336-909-3305* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 15:02:08 : pos4 : ABURTON ** EMD Case Entry Finished ** Chief Complaint Number: 30 Key Questions: 61 year old, Female, Conscious, Breathing. Traumatic Injuries (Specific). Caller Statement: broke arm. 03/28/2013 15:01:49 : pos4 : ABURTON Cross streets: JONES RD//BLUEGRASS TR*
911:Call#130328-0476* Address:157 I40 WB* * * City:MOCKSVILLE* * * * Location:* Complaint:GWB* Desc:GRASS/WOODS/BRUSH FIRE* Caller:ir911* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 14:23:01 : pos4 : ABURTON shoulder of road*
911:Call#130328-0442* Address:168 DWIGGINS RD* * * City:MOCKSVILLE* DAVIE ACADEMY RD* DEADEND* * Location:NBH: 948 DAVIE ACADEMY RD* Complaint:YEL* Desc:CARDIAC PROBLEM* Caller:RICKLES KATHERINE* Ph#:336-492-2358* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 09:52:20 : pos2 : JJASTER Cross streets: DAVIE ACADEMY RD//DEADEND NBH: 948 DAVIE ACADEMY RD*
911:Call#130328-0435* Address:213 HAYS FARM RD* * * City:MOCKSVILLE* * * * LocCmmt:* Comp:HEM* Desc:HEMORHAGE* Caller:IREDELL* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 08:39:09 : pos2 : JJASTER LOWER GI BLEED ASSIST IREDELL COUNTY*
911:Call#130328-0412* Address:155 I40 WB* * * City:MOCKSVILLE* * * * LocCmmt:* Comp:PS* Desc:PUBLIC SERVICE* Caller:IREDELL* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 00:06:03 : pos2 : TWMYERS FUEL LEAK FROM A 10-50*
911:Call#130327-0330* Address:213 HAYSFARM RD* * * City:MOCKSVILLE* * * * LocCmmt:* Comp:MED* Desc:MEDICAL CALL* Caller:* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:*

 */

public class NCDavieCountyBParserTest extends BaseParserTest {
  
  public NCDavieCountyBParserTest() {
    setParser(new NCDavieCountyBParser(), "DAVIE COUNTY", "NC");
  }
  
  @Test
  public void testBarry() {

    doTest("T1",
        "1 of 4\n" +
        "FRM:911@co.davie.nc.us\n" +
        "MSG:911:Call#130329-0643* Address:162 KNOLL CREST RD* * * City:MOCKSVILLE* DEADMON RD* HOLIDAY LN* * Location:NBH:\n" +
        "(Con't) 2 of 4\n" +
        "OFF 760 DEADMON RD NEAR WILLBOONE RD* Complaint:21* Desc:CALL BY PHONE* Caller:rex smith* Ph#:336-998-3324* Units:131,132,21,31,33* *\n" +
        "(Con't) 3 of 4\n" +
        "Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 19:49:08 : pos2 : SPHILLIPS 131 REQUESTING EMS 2 PATIENTS, AND FIRE DEPARTMENT WITH CO\n" +
        "(Con't) 4 of 4\n" +
        "2 03/29/2013 19:20(End)",

        "ID:130329-0643",
        "ADDR:162 KNOLL CREST RD",
        "CITY:MOCKSVILLE",
        "X:DEADMON RD & HOLIDAY LN",
        "INFO:Med:Medical: No / Haz:Hazards: No\n131 REQUESTING EMS 2 PATIENTS, AND FIRE DEPARTMENT WITH CO 2 03/29/2013 19:20",
        "CODE:21",
        "CALL:CALL BY PHONE",
        "NAME:rex smith",
        "PHONE:336-998-3324",
        "UNIT:131,132,21,31,33",
        "DATE:03/29/2013",
        "TIME:19:49:08",
        "PLACE:OFF 760 DEADMON RD NEAR WILLBOONE RD");
   
  }
  
  @Test
  public void testMichaelWilson() {

    doTest("T1",
        "911:Call#130414-2488* Address:2030 US HWY 601 N* * * City:MOCKSVILLE* BLAISE CHURCH RD* ASHLEY BRROK LN* * Location:* Complaint:54I* Description:HIT & RUN/INJURY",
        "ID:130414-2488",
        "ADDR:2030 US HWY 601 N",
        "MADDR:2030 US 601 N",
        "CITY:MOCKSVILLE",
        "X:BLAISE CHURCH RD & ASHLEY BRROK LN",
        "CODE:54I",
        "CALL:HIT & RUN/INJURY");

    doTest("T1",
        "911:Call#130419-3256* Address:US HWY 601 N // EATONS CHURCH RD* * * City:MOCKSVILLE* EATONS CHURCH RD* MACY LANGSTON LN* * Location:* Complaint:50PI* Description",
        "ID:130419-3256",
        "ADDR:US HWY 601 N & EATONS CHURCH RD",
        "MADDR:US 601 N & EATONS CHURCH RD",
        "CITY:MOCKSVILLE",
        "X:EATONS CHURCH RD & MACY LANGSTON LN",
        "CODE:50PI");
   
  }

  @Test
  public void testAdoubdsd() {

    doTest("T1",
        "911:Call#130328-0420* Address:1869 US HWY 601 N* * * City:MOCKSVILLE* DISTRICT LINE* QUALITY DR* * LocCmmt:NBH: BETWEEN BRANTLEY FARM RD & QUALITY DR* Comp:6D2*Eff ",
        "ID:130328-0420",
        "ADDR:1869 US HWY 601 N",
        "MADDR:1869 US 601 N",
        "CITY:MOCKSVILLE",
        "X:DISTRICT LINE & QUALITY DR",
        "PLACE:BETWEEN BRANTLEY FARM RD & QUALITY DR",
        "CODE:6D2*Eff");

    doTest("T2",
        "911:Call#130328-0436* Address:221 JOLLEY RD* * * City:MOCKSVILLE* US HWY 601 N* US HWY 601 N* * LocCmmt:NBH: OFF 3022 US HWY 601 N TO 3160 US HWY 601 N* Comp:MED",
        "ID:130328-0436",
        "ADDR:221 JOLLEY RD",
        "CITY:MOCKSVILLE",
        "X:US HWY 601 N & US HWY 601 N",
        "PLACE:OFF 3022 US HWY 601 N TO 3160 US HWY 601 N",
        "CODE:MED");

    doTest("T3",
        "911:Call#130329-0559* Address:421 ALLEN RD* * * City:MOCKSVILLE* HIDDEN VALLEY LN* DEADEND* * Location:Special Comment:: MR TRIVETTE IS TAKING MEDICINE CAUSING C",
        "ID:130329-0559",
        "ADDR:421 ALLEN RD",
        "CITY:MOCKSVILLE",
        "X:HIDDEN VALLEY LN & DEADEND",
        "INFO:Special Comment:: MR TRIVETTE IS TAKING MEDICINE CAUSING C");

    doTest("T4",
        "911:Call#130414-2573* Address:146 MCBRIDE LN* * * City:MOCKSVILLE* SPEER RD* DEADEND* * Location:NBH: OFF 250 SPEER RD OFF 500 BLOCK ELMORE RD* Complaint:26C1* D",
        "ID:130414-2573",
        "ADDR:146 MCBRIDE LN",
        "CITY:MOCKSVILLE",
        "X:SPEER RD & DEADEND",
        "PLACE:OFF 250 SPEER RD OFF 500 BLOCK ELMORE RD",
        "CODE:26C1");

    doTest("T5",
        "911:Call#130419-3256* Address:US HWY 601 N // EATONS CHURCH RD* * * City:MOCKSVILLE* EATONS CHURCH RD* MACY LANGSTON LN* * Location:* Complaint:50PI* Description",
        "ID:130419-3256",
        "ADDR:US HWY 601 N & EATONS CHURCH RD",
        "MADDR:US 601 N & EATONS CHURCH RD",
        "CITY:MOCKSVILLE",
        "X:EATONS CHURCH RD & MACY LANGSTON LN",
        "CODE:50PI");

    doTest("T6",
        "911:Call#130423-3781* Address:183 R SHORE DR* * * City:MOCKSVILLE* US HWY 601 N* US HWY 601 N* * Location:NBH: FROM 4584 TO 4612 US HWY 601 NORTH ACROSS FROM BAI",
        "ID:130423-3781",
        "ADDR:183 R SHORE DR",
        "CITY:MOCKSVILLE",
        "X:US HWY 601 N & US HWY 601 N",
        "PLACE:FROM 4584 TO 4612 US HWY 601 NORTH ACROSS FROM BAI");
   
  }
  
  @Test
  public void testLisaThomas() {

    doTest("T1",
        "911:Call#130615-0325* Address:321 AVON ST* * * City:MOCKSVILLE* RAYMOND ST* S TOT ST* * Location:NBH: 100 BLOCK RAYMOND ST TO 400 BLOCK TOT ST* Complaint:FALL* D",
        "ID:130615-0325",
        "ADDR:321 AVON ST",
        "CITY:MOCKSVILLE",
        "X:RAYMOND ST & S TOT ST",
        "PLACE:100 BLOCK RAYMOND ST TO 400 BLOCK TOT ST",
        "CODE:FALL");
 
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "911:Call#130327-0331* Address:124 ROSEWALK LN* * * City:ADVANCE* TOWNPARK DR* NORTH FIELD DR* * LocCmmt:Geo Comment: KINDERTON DEVELOPMENT NBH: OFF 200 BLK TOWNPARK DR OFF OLD TOWNE DR* Comp:HC* Desc:HAZARDOUS CONDITION* Caller:KOHLER,BILLIE* Ph#:336-940-4275* Units:24* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 11:28:05 : pos1 : JJASTER Cross streets: TOWNPARK DR//NORTH FIELD DR Geo Comm",
        "ID:130327-0331",
        "ADDR:124 ROSEWALK LN",
        "CITY:ADVANCE",
        "X:TOWNPARK DR & NORTH FIELD DR",
        "INFO:KINDERTON DEVELOPMENT / Med:Medical: No / Haz:Hazards: No\nGeo Comm",
        "CODE:HC",
        "CALL:HAZARDOUS CONDITION",
        "NAME:KOHLER,BILLIE",
        "PHONE:336-940-4275",
        "UNIT:24",
        "DATE:03/27/2013",
        "TIME:11:28:05",
        "PLACE:OFF 200 BLK TOWNPARK DR OFF OLD TOWNE DR");

    doTest("T2",
        "911:Call#130327-0312* Address:130 OLEANDER DR* * * City:ADVANCE* HOLLYBROOK DR* HOLLYBROOK DR* * LocCmmt:NBH: 140 HOLLYBROOK TO 180 HOLLYBROOK OFF BERMUDA VILL DR* Comp:FALL* Desc:FALL* Caller:CHURCH EVELYN HESTER* Ph#:336-940-6575* Units:24* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 08:46:56 : pos1 : JJASTER ** EMD Case Entry Finished ** Chief Complaint Number: 17 Key Questions: 64 year",
        "ID:130327-0312",
        "ADDR:130 OLEANDER DR",
        "CITY:ADVANCE",
        "X:HOLLYBROOK DR & HOLLYBROOK DR",
        "INFO:Med:Medical: No / Haz:Hazards: No\nChief Complaint Number: 17 / 64 year",
        "CODE:FALL",
        "CALL:FALL",
        "NAME:CHURCH EVELYN HESTER",
        "PHONE:336-940-6575",
        "UNIT:24",
        "DATE:03/27/2013",
        "TIME:08:46:56",
        "PLACE:140 HOLLYBROOK TO 180 HOLLYBROOK OFF BERMUDA VILL DR");

    doTest("T3",
        "911:Call#130326-0272* Address:102 I40 EB* * * City:MOCKSVILLE* 601 NORTH* FARMINGTON RD* * LocCmmt:* Comp:VF* Desc:VEHICLE FIRE* Caller:NC DEPT OF TRANSPORTATION* Ph#:336-940-5627* Units:23,24* * Med:Medical: No* Haz:Hazards: No* Narr:03/26/2013 21:13:00 : pos4 : RPIERCE Cross streets: 601 NORTH//FARMINGTON RD black blazer on the camper side caller advised looked like something was on fire inside ",
        "ID:130326-0272",
        "ADDR:102 I40 EB",
        "MADDR:102 I 40",
        "CITY:MOCKSVILLE",
        "X:601 NORTH & FARMINGTON RD",
        "INFO:Med:Medical: No / Haz:Hazards: No\nblack blazer on the camper side caller advised looked like something was on fire inside",
        "CODE:VF",
        "CALL:VEHICLE FIRE",
        "NAME:NC DEPT OF TRANSPORTATION",
        "PHONE:336-940-5627",
        "UNIT:23,24",
        "DATE:03/26/2013",
        "TIME:21:13:00");

    doTest("T4",
        "911:Call#130326-0272* Address:102 I40 EB* * * City:MOCKSVILLE* 601 NORTH* FARMINGTON RD* * LocCmmt:* Comp:VF* Desc:VEHICLE FIRE* Caller:NC DEPT OF TRANSPORTATION* Ph#:336-940-5627* Units:13* * Med:Medical: No* Haz:Hazards: No* Narr:03/26/2013 21:13:00 : pos4 : RPIERCE Cross streets: 601 NORTH//FARMINGTON RD black blazer on the camper side caller advised looked like something was on fire inside the front of the blazer*",
        "ID:130326-0272",
        "ADDR:102 I40 EB",
        "MADDR:102 I 40",
        "CITY:MOCKSVILLE",
        "X:601 NORTH & FARMINGTON RD",
        "INFO:Med:Medical: No / Haz:Hazards: No\nblack blazer on the camper side caller advised looked like something was on fire inside the front of the blazer",
        "CODE:VF",
        "CALL:VEHICLE FIRE",
        "NAME:NC DEPT OF TRANSPORTATION",
        "PHONE:336-940-5627",
        "UNIT:13",
        "DATE:03/26/2013",
        "TIME:21:13:00");

    doTest("T5",
        "911:Call#130327-0331* Address:124 ROSEWALK LN* * * City:ADVANCE* TOWNPARK DR* NORTH FIELD DR* * LocCmmt:Geo Comment: KINDERTON DEVELOPMENT NBH: OFF 200 BLK TOWNPARK DR OFF OLD TOWNE DR* Comp:HC* Desc:HAZARDOUS CONDITION* Caller:KOHLER,BILLIE* Ph#:336-940-4275* Units:23,24* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 11:28:05 : pos1 : JJASTER Cross streets: TOWNPARK DR//NORTH FIELD DR Geo Comment: KINDERTON DEVELOPMENT NBH: OFF 200 BLK TOWNPARK DR OFF OLD TOWNE DR Cross streets: US HWY 158//DEADEND NBH: OFF 4900 BLOCK US HWY 158 STRONG SMELL OUTSIDE ..SMELLS LIKE ONIONS.. WANTS FD TO COME CHECK AND SEE IF GAS .. OUTSIDE*",
        "ID:130327-0331",
        "ADDR:124 ROSEWALK LN",
        "CITY:ADVANCE",
        "X:TOWNPARK DR & NORTH FIELD DR",
        "INFO:KINDERTON DEVELOPMENT / Med:Medical: No / Haz:Hazards: No\nNBH: OFF 4900 BLOCK US HWY 158 STRONG SMELL OUTSIDE ..SMELLS LIKE ONIONS.. WANTS FD TO COME CHECK AND SEE IF GAS",
        "CODE:HC",
        "CALL:HAZARDOUS CONDITION",
        "NAME:KOHLER,BILLIE",
        "PHONE:336-940-4275",
        "UNIT:23,24",
        "DATE:03/27/2013",
        "TIME:11:28:05",
        "PLACE:OFF 200 BLK TOWNPARK DR OFF OLD TOWNE DR");

    doTest("T6",
        "911:Call#130327-0307* Address:219 DUTCHMAN TRL* * * City:MOCKSVILLE* PATRICIA WA* PATRICIA WA* * LocCmmt:NBH: OFF 338 FARMINGTON RD* Comp:6D2* Desc:BREATHING PROBLEMS* Caller:REAVIS JEFFERY* Ph#:336-940-2619* Units:23,32* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 08:01:55 : pos1 : JJASTER ** EMD Case Complete ** Key Questions: 54 year old, Female, Conscious, Breathing. 03/27/2013 08:01:26 : pos1 : JJASTER ** EMD Key Questions Finished ** Key Questions: 5.She has a prescribed inhaler. * 6.She has used a prescribed inhaler. * 7.N/A 03/27/2013 08:01:18 : pos1 : JJASTER ** EMD Reconfigure ** Response Text: Delta Dispatch Level: 06D02 Suffix: A CAD Incident Code: 6D2 Key Questions: DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma). * 3.She is not clammy. * 4.She has asthma. 03/27/2013 08:01:11 : pos1 : JJASTER ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 06D02 CAD Incident Code: 6D2 Key Questions: DIFFICULTY SPEAKING BETWEEN BREATHS. * 1.She is completely alert ",
        "ID:130327-0307",
        "ADDR:219 DUTCHMAN TRL",
        "CITY:MOCKSVILLE",
        "X:PATRICIA WA & PATRICIA WA",
        "INFO:Med:Medical: No / Haz:Hazards: No\n54 year old, Female, Conscious, Breathing.\n** EMD Key Questions Finished ** / 5.She has a prescribed inhaler. / 6.She has used a prescribed inhaler.\n7.N/A\n** EMD Reconfigure ** / Delta Dispatch Level: 06D02 Suffix: A CAD Incident Code: 6D2 / DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma). / 3.She is not clammy.\n4.She has asthma.\nDelta Dispatch Level: 06D02 CAD Incident Code: 6D2 / DIFFICULTY SPEAKING BETWEEN BREATHS. / 1.She is completely alert",
        "CODE:6D2",
        "CALL:BREATHING PROBLEMS",
        "NAME:REAVIS JEFFERY",
        "PHONE:336-940-2619",
        "UNIT:23,32",
        "DATE:03/27/2013",
        "TIME:08:01:11",
        "PLACE:OFF 338 FARMINGTON RD");

    doTest("T7",
        "911:Call#130326-0272* Address:102 I40 EB* * * City:MOCKSVILLE* 601 NORTH* FARMINGTON RD* * LocCmmt:* Comp:VF* Desc:VEHICLE FIRE* Caller:NC DEPT OF TRANSPORTATION* Ph#:336-940-5627* Units:13,23* * Med:Medical: No* Haz:Hazards: No* Narr:03/26/2013 21:13:00 : pos4 : RPIERCE Cross streets: 601 NORTH//FARMINGTON RD black blazer on the camper side caller advised looked like something was on fire inside the front of the blazer*",
        "ID:130326-0272",
        "ADDR:102 I40 EB",
        "MADDR:102 I 40",
        "CITY:MOCKSVILLE",
        "X:601 NORTH & FARMINGTON RD",
        "INFO:Med:Medical: No / Haz:Hazards: No\nblack blazer on the camper side caller advised looked like something was on fire inside the front of the blazer",
        "CODE:VF",
        "CALL:VEHICLE FIRE",
        "NAME:NC DEPT OF TRANSPORTATION",
        "PHONE:336-940-5627",
        "UNIT:13,23",
        "DATE:03/26/2013",
        "TIME:21:13:00");

    doTest("T8",
        "911:Call#130327-0312* Address:130 OLEANDER DR* * * City:ADVANCE* HOLLYBROOK DR* HOLLYBROOK DR* * LocCmmt:NBH: 140 HOLLYBROOK TO 180 HOLLYBROOK OFF BERMUDA VILL DR* Comp:FALL* Desc:FALL* Caller:CHURCH EVELYN HESTER* Ph#:336-940-6575* Units:24,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 08:46:56 : pos1 : JJASTER ** EMD Case Entry Finished ** Chief Complaint Number: 17 Key Questions: 64 year old, Male, Conscious, Breathing. Falls. Caller Statement: SON FELL AND HIT HEAD . 03/27/2013 08:46:34 : pos1 : JJASTER Cross streets: HOLLYBROOK DR//HOLLYBROOK DR NBH: 140 HOLLYBROOK TO 180 HOLLYBROOK OFF BERMUDA VILL DR HEAD INJ*",
        "ID:130327-0312",
        "ADDR:130 OLEANDER DR",
        "CITY:ADVANCE",
        "X:HOLLYBROOK DR & HOLLYBROOK DR",
        "INFO:Med:Medical: No / Haz:Hazards: No\nChief Complaint Number: 17 / 64 year old, Male, Conscious, Breathing. Falls. Caller Statement: SON FELL AND HIT HEAD .\nHEAD INJ",
        "CODE:FALL",
        "CALL:FALL",
        "NAME:CHURCH EVELYN HESTER",
        "PHONE:336-940-6575",
        "UNIT:24,ST4",
        "DATE:03/27/2013",
        "TIME:08:46:56",
        "PLACE:140 HOLLYBROOK TO 180 HOLLYBROOK OFF BERMUDA VILL DR");

    doTest("T9",
        "911:Call#130327-0307* Address:219 DUTCHMAN TRL* * * City:MOCKSVILLE* PATRICIA WA* PATRICIA WA* * LocCmmt:NBH: OFF 338 FARMINGTON RD* Comp:6D2* Desc:BREATHING PROBLEMS* Caller:REAVIS JEFFERY* Ph#:336-940-2619* Units:23,32,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 08:01:55 : pos1 : JJASTER ** EMD Case Complete ** Key Questions: 54 year old, Female, Conscious, Breathing. 03/27/2013 08:01:26 : pos1 : JJASTER ** EMD Key Questions Finished ** Key Questions: 5.She has a prescribed inhaler. * 6.She has used a prescribed inhaler. * 7.N/A 03/27/2013 08:01:18 : pos1 : JJASTER ** EMD Reconfigure ** Response Text: Delta Dispatch Level: 06D02 Suffix: A CAD Incident Code: 6D2 Key Questions: DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma). * 3.She is not clammy. * 4.She has asthma. 03/27/2013 08:01:11 : pos1 : JJASTER ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 06D02 CAD Incident Code: 6D2 Key Questions: DIFFICULTY SPEAKING BETWEEN BREATHS. * 1.She is completely al",
        "ID:130327-0307",
        "ADDR:219 DUTCHMAN TRL",
        "CITY:MOCKSVILLE",
        "X:PATRICIA WA & PATRICIA WA",
        "INFO:Med:Medical: No / Haz:Hazards: No\n54 year old, Female, Conscious, Breathing.\n** EMD Key Questions Finished ** / 5.She has a prescribed inhaler. / 6.She has used a prescribed inhaler.\n7.N/A\n** EMD Reconfigure ** / Delta Dispatch Level: 06D02 Suffix: A CAD Incident Code: 6D2 / DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma). / 3.She is not clammy.\n4.She has asthma.\nDelta Dispatch Level: 06D02 CAD Incident Code: 6D2 / DIFFICULTY SPEAKING BETWEEN BREATHS. / 1.She is completely al",
        "CODE:6D2",
        "CALL:BREATHING PROBLEMS",
        "NAME:REAVIS JEFFERY",
        "PHONE:336-940-2619",
        "UNIT:23,32,ST4",
        "DATE:03/27/2013",
        "TIME:08:01:11",
        "PLACE:OFF 338 FARMINGTON RD");

    doTest("T10",
        "911:Call#130327-0296* Address:622 N MAIN ST* * * City:MOCKSVILLE* POPLAR ST* HEMLOCK ST* * LocCmmt:NBH: OFF 100 POPLAR ST TO 100 HEMLOCK ST* Comp:FALL* Desc:FALL* Caller:BRENT HALL* Ph#:336-469-9339* Units:22,31,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 05:58:18 : pos1 : SPHILLIPS Cross streets: POPLAR ST//HEMLOCK ST Landmark: B C BROCK NBH: OFF 100 POPLAR ST TO 100 HEMLOCK ST Cross streets: CUSTOM DR//CITY LIMITS NBH: OFF 1098 SALISBURY RD COME IN THROUGH THE BACK*",
        "ID:130327-0296",
        "ADDR:622 N MAIN ST",
        "CITY:MOCKSVILLE",
        "X:POPLAR ST & HEMLOCK ST",
        "INFO:Med:Medical: No / Haz:Hazards: No\nNBH: OFF 1098 SALISBURY RD COME IN THROUGH THE BACK",
        "CODE:FALL",
        "CALL:FALL",
        "NAME:BRENT HALL",
        "PHONE:336-469-9339",
        "UNIT:22,31,ST4",
        "DATE:03/27/2013",
        "TIME:05:58:18",
        "PLACE:B C BROCK OFF 100 POPLAR ST TO 100 HEMLOCK ST");


    doTest("T11",
        "911:Call#130327-0290* Address:3037 SANDY SPRINGS RD* * * City:STATESVILLE* * * * LocCmmt:* Comp:SF* Desc:STRUCTURE FIRE* Caller:IREDELL COUNTY ECOM* Ph#:704-878-3039* Units:16* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 01:42:12 : pos1 : SPHILLIPS STATION 16*",
        "ID:130327-0290",
        "ADDR:3037 SANDY SPRINGS RD",
        "CITY:STATESVILLE",
        "INFO:Med:Medical: No / Haz:Hazards: No\nSTATION 16",
        "CODE:SF",
        "CALL:STRUCTURE FIRE",
        "NAME:IREDELL COUNTY ECOM",
        "PHONE:704-878-3039",
        "UNIT:16",
        "DATE:03/27/2013",
        "TIME:01:42:12");
  
  }
  
  @Test
  public void testSmithGroveFireDepartment() {

    doTest("T1",
        "911:Call#130330-0681* Address:115 S MILLBROOKE CT* * * City:ADVANCE* MILL COVE DR* DEAD END* * Location:NBH: OFF 200 BLK N HIDDENBROOK OFF 150 BLOK TWIN CREEK* Complaint:26D1* Desc:SICK PERSON (SPECIFIC DIAGNOSIS)* Caller:GAY WILLIAM W* Ph#:336-940-4082* Units:24* * Med:Medical: No* Haz:Hazards: No* Narr:03/30/2013 05:16:18 : pos1 : TWMYERS ** EMD Recommended Dispatch ** Response Text: Delta Dispa",
        "ID:130330-0681",
        "ADDR:115 S MILLBROOKE CT",
        "CITY:ADVANCE",
        "X:MILL COVE DR & DEAD END",
        "INFO:Med:Medical: No / Haz:Hazards: No\nDelta Dispa",
        "CODE:26D1",
        "CALL:SICK PERSON (SPECIFIC DIAGNOSIS)",
        "NAME:GAY WILLIAM W",
        "PHONE:336-940-4082",
        "UNIT:24",
        "DATE:03/30/2013",
        "TIME:05:16:18",
        "PLACE:OFF 200 BLK N HIDDENBROOK OFF 150 BLOK TWIN CREEK");

    doTest("T2",
        "911:Call#130329-0628* Address:278 JESSE KING RD* * * City:ADVANCE* PEACEFUL VALLEY RD* DEADEND* * Location:NBH: OFF 1300 BLOCK YADKIN VALLEY RD* Complaint:GWB* Desc:GRASS/WOODS/BRUSH FIRE* Caller:cary mcguire* Ph#:336-618-5274* Units:23,24,FOR1,FOR2* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 16:44:35 : pos2 : JALLGOOD Cross streets: PEACEFUL VALLEY RD//DEADEND NBH: OFF 1300 BLOCK YADKIN ",
        "ID:130329-0628",
        "ADDR:278 JESSE KING RD",
        "CITY:ADVANCE",
        "X:PEACEFUL VALLEY RD & DEADEND",
        "INFO:Med:Medical: No / Haz:Hazards: No\nNBH: OFF 1300 BLOCK YADKIN",
        "CODE:GWB",
        "CALL:GRASS/WOODS/BRUSH FIRE",
        "NAME:cary mcguire",
        "PHONE:336-618-5274",
        "UNIT:23,24,FOR1,FOR2",
        "DATE:03/29/2013",
        "TIME:16:44:35",
        "PLACE:OFF 1300 BLOCK YADKIN VALLEY RD");

    doTest("T3",
        "911:Call#130329-0595* Address:134 DONREE LN* * * City:MOCKSVILLE* US HWY 158* DEADEND* * Location:NBH: OFF 2144 US HWY 158 ACROSS FROM WHITAKER RD* Complaint:FA* Desc:FIRE ALARM* Caller:cpi* Ph#:800-948-7133* Units:22,24* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 12:55:25 : pos2 : JALLGOOD Cross streets: US HWY 158//DEADEND NBH: OFF 2144 US HWY 158 ACROSS FROM WHITAKER RD beverly pilcher",
        "ID:130329-0595",
        "ADDR:134 DONREE LN",
        "CITY:MOCKSVILLE",
        "X:US HWY 158 & DEADEND",
        "INFO:Med:Medical: No / Haz:Hazards: No\nbeverly pilcher",
        "CODE:FA",
        "CALL:FIRE ALARM",
        "NAME:cpi",
        "PHONE:800-948-7133",
        "UNIT:22,24",
        "DATE:03/29/2013",
        "TIME:12:55:25",
        "PLACE:OFF 2144 US HWY 158 ACROSS FROM WHITAKER RD");
   
  }
  
  @Test
  public void testClemmonsFireDepartment() {

    doTest("T1",
        "911:Call#130329-0596* Address:622 RIVERBEND DR* * * City:ADVANCE* SPYGLASS DR* SPYGLASS DR* * Location:Geo Comment: BERMUDA RUN DEV* Complaint:RD* Desc:RESPIRATORY DISTRESS* Caller:WHITMAN, CHARLES H* Ph#:336-998-4309* Units:32,FC14* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 13:25:46 : pos1 : SFRYE Cross streets: SPYGLASS DR//SPYGLASS DR Geo Comment: BERMUDA RUN DEV*",
        "ID:130329-0596",
        "ADDR:622 RIVERBEND DR",
        "CITY:ADVANCE",
        "X:SPYGLASS DR & SPYGLASS DR",
        "INFO:BERMUDA RUN DEV / Med:Medical: No / Haz:Hazards: No",
        "CODE:RD",
        "CALL:RESPIRATORY DISTRESS",
        "NAME:WHITMAN, CHARLES H",
        "PHONE:336-998-4309",
        "UNIT:32,FC14",
        "DATE:03/29/2013",
        "TIME:13:25:46");

    doTest("T2",
        "911:Call#130328-0464* Address:112 E KINDERTON WA* * * City:ADVANCE* ABERCORN WAY* DEADEND* * Location:Geo Comment: KINDERTON DEV NBH: OFF ABERCORN OFF DORNACH WA OFF KINDERTON BLV* Complaint:TRA* Desc:TRANSPORT* Caller:faith* Ph#:336-941-3118* Units:31,FC14* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 13:09:59 : pos2 : JJASTER Cross streets: ABERCORN WAY//DEADEND Geo Comment: KINDERTON DEV NBH: OFF ABERCORN OFF DORNACH WA OFF KINDERTON BLV 03/28/2013 13:06:22 : pos4 : ABURTON 10-18 80 yr old female not responsvive they are bagging*",
        "ID:130328-0464",
        "ADDR:112 E KINDERTON WA",
        "MADDR:112 E KINDERTON WAY",
        "CITY:ADVANCE",
        "X:ABERCORN WAY & DEADEND",
        "INFO:KINDERTON DEV / Med:Medical: No / Haz:Hazards: No\n10-18 80 yr old female not responsvive they are bagging",
        "CODE:TRA",
        "CALL:TRANSPORT",
        "NAME:faith",
        "PHONE:336-941-3118",
        "UNIT:31,FC14",
        "DATE:03/28/2013",
        "TIME:13:09:59",
        "PLACE:OFF ABERCORN OFF DORNACH WA OFF KINDERTON BLV");
  
  }
  
  @Test
  public void testCooleemeeFireDepartment() {

    doTest("T1",
        "911:Call#130330-0682* Address:176 MIDWAY ST* * * City:COOLEEMEE* RAMARS CT* GROVE ST* * Location:NBH: 100 BLOCK RAMARS CT TO 277 GROVE ST* Complaint:MED* Desc:MEDICAL CALL* Caller:BROWN, WALTER* Ph#:336-284-2835* Units:14* * Med:Medical: No* Haz:Hazards: No* Narr:03/30/2013 05:20:28 : pos1 : TWMYERS Cross streets: RAMARS CT//GROVE ST NBH: 100 BLOCK RAMARS CT TO 277 GROVE ST*",
        "ID:130330-0682",
        "ADDR:176 MIDWAY ST",
        "CITY:COOLEEMEE",
        "X:RAMARS CT & GROVE ST",
        "INFO:Med:Medical: No / Haz:Hazards: No",
        "CODE:MED",
        "CALL:MEDICAL CALL",
        "NAME:BROWN, WALTER",
        "PHONE:336-284-2835",
        "UNIT:14",
        "DATE:03/30/2013",
        "TIME:05:20:28",
        "PLACE:100 BLOCK RAMARS CT TO 277 GROVE ST");

  }
  
  @Test
  public void testMocksvilleCenterFireDepartment() {

    doTest("T1",
        "911:Call#130330-0708* Address:202 POWELL RD* * * City:MOCKSVILLE* US HWY 64 W* ALLISON LN* * Location:NBH: OFF 2152 US HWY 64 W* Complaint:MED* Desc:MEDICAL CALL* Caller:* Ph#:336-655-4441* Units:13* * Med:Medical: No* Haz:Hazards: No* Narr:03/30/2013 10:27:43 : pos1 : JALLGOOD ** EMD Case Entry Finished ** Chief Complaint Number: 31 Key Questions: 59 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Caller Statement: mother is sick with brain swelling . 03/30/2013 10:26:52 : pos2 : JBYERLY Call 130330-0707, 130330-0708 are related. 03/30/2013 10:26:28 : pos2 : JBYERLY Cross streets: US HWY 64 W//ALLISON LN NBH: OFF 2152 US HWY 64 W*",
        "ID:130330-0708",
        "ADDR:202 POWELL RD",
        "CITY:MOCKSVILLE",
        "X:US HWY 64 W & ALLISON LN",
        "INFO:Med:Medical: No / Haz:Hazards: No\nChief Complaint Number: 31 / 59 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Caller Statement: mother is sick with brain swelling .\nCall 130330-0707, 130330-0708 are related.",
        "CODE:MED",
        "CALL:MEDICAL CALL",
        "PHONE:336-655-4441",
        "UNIT:13",
        "DATE:03/30/2013",
        "TIME:10:27:43",
        "PLACE:OFF 2152 US HWY 64 W");

    doTest("T2",
        "911:Call#130329-0543* Address:482 POWELL RD* * * City:MOCKSVILLE* ALLISON LN* GODBEY RD* * Location:NBH: FROM 466 GODBEY RD TO 2152 US HWY 64 W* Complaint:SEI* Desc:SEIZURE* Caller:GALE PAUL H* Ph#:336-492-6322* Units:13* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 02:29:57 : pos2 : SSPEER Cross streets: ALLISON LN//GODBEY RD NBH: FROM 466 GODBEY RD TO 2152 US HWY 64 W*",
        "ID:130329-0543",
        "ADDR:482 POWELL RD",
        "CITY:MOCKSVILLE",
        "X:ALLISON LN & GODBEY RD",
        "INFO:Med:Medical: No / Haz:Hazards: No",
        "CODE:SEI",
        "CALL:SEIZURE",
        "NAME:GALE PAUL H",
        "PHONE:336-492-6322",
        "UNIT:13",
        "DATE:03/29/2013",
        "TIME:02:29:57",
        "PLACE:FROM 466 GODBEY RD TO 2152 US HWY 64 W");

  }
  
  @Test
  public void testForkFireDepartment() {

    doTest("T1",
        "911:Call#130329-0639* Address:1617 PEOPLES CREEK RD* * * City:ADVANCE* MARCHMONT DR* SOUTHERN MAGNOLIA DR* * Location:NBH: OFF 2500 BLOCK 801 SOUTH ADVANCE END* Complaint:SF* Desc:STRUCTURE FIRE* Caller:JONES PATRICIA R* Ph#:336-998-7073* Units:12,15,19,32* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 18:09:34 : pos2 : JALLGOOD Cross streets: MARCHMONT DR//SOUTHERN MAGNOLIA DR NBH: OFF 2500 BLOCK 801 SOUTH ADVANCE END*",
        "ID:130329-0639",
        "ADDR:1617 PEOPLES CREEK RD",
        "CITY:ADVANCE",
        "X:MARCHMONT DR & SOUTHERN MAGNOLIA DR",
        "INFO:Med:Medical: No / Haz:Hazards: No",
        "CODE:SF",
        "CALL:STRUCTURE FIRE",
        "NAME:JONES PATRICIA R",
        "PHONE:336-998-7073",
        "UNIT:12,15,19,32",
        "DATE:03/29/2013",
        "TIME:18:09:34",
        "PLACE:OFF 2500 BLOCK 801 SOUTH ADVANCE END");

  }
  
  @Test
  public void testFarmingtonVolunteerFireDepartment() {

    doTest("T1",
        "911:Call#130329-0628* Address:278 JESSE KING RD* * * City:ADVANCE* PEACEFUL VALLEY RD* DEADEND* * Location:NBH: OFF 1300 BLOCK YADKIN VALLEY RD* Complaint:GWB* Desc:GRASS/WOODS/BRUSH FIRE* Caller:cary mcguire* Ph#:336-618-5274* Units:23* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 16:44:35 : pos2 : JALLGOOD Cross streets: PEACEFUL VALLEY RD//DEADEND NBH: OFF 1300 BLOCK YADKIN VALLEY RD Cross streets: US HWY 158//DEADEND NBH: OFF 4900 BLOCK US HWY 158*",
        "ID:130329-0628",
        "ADDR:278 JESSE KING RD",
        "CITY:ADVANCE",
        "X:PEACEFUL VALLEY RD & DEADEND",
        "INFO:Med:Medical: No / Haz:Hazards: No\nNBH: OFF 4900 BLOCK US HWY 158",
        "CODE:GWB",
        "CALL:GRASS/WOODS/BRUSH FIRE",
        "NAME:cary mcguire",
        "PHONE:336-618-5274",
        "UNIT:23",
        "DATE:03/29/2013",
        "TIME:16:44:35",
        "PLACE:OFF 1300 BLOCK YADKIN VALLEY RD");

    doTest("T2",
        "911:Call#130328-0484* Address:295 ESSIC RD* * * City:MOCKSVILLE* DISTRICT LINE* BONKIN LAKE RD* * Location:NBH: OFF 4082 HWY 801 N FROM BONKIN LAKE RD TO CAP CAIN RD* Complaint:VF* Desc:VEHICLE FIRE* Caller:VERIZON WIRELESS* Ph#:336-486-1480* Units:23,YC19* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 15:11:34 : pos2 : JJASTER VEH FULLY INVOLVED 03/28/2013 15:11:21 : pos2 : JJASTER Cross streets: DISTRICT LINE//BONKIN LAKE RD NBH: OFF 4082 HWY 801 N FROM BONKIN LAKE RD TO CAP CAIN RD*",
        "ID:130328-0484",
        "ADDR:295 ESSIC RD",
        "CITY:MOCKSVILLE",
        "X:DISTRICT LINE & BONKIN LAKE RD",
        "INFO:Med:Medical: No / Haz:Hazards: No\nVEH FULLY INVOLVED",
        "CODE:VF",
        "CALL:VEHICLE FIRE",
        "PHONE:336-486-1480",
        "UNIT:23,YC19",
        "DATE:03/28/2013",
        "TIME:15:11:34",
        "PLACE:OFF 4082 HWY 801 N FROM BONKIN LAKE RD TO CAP CAIN RD");

    doTest("T3",
        "911:Call#130328-0420* Address:1869 NC HWY 801 N* * * City:MOCKSVILLE* RHYNEHARDT RD* CEDAR FOREST LN* * LocCmmt:* Comp:RD* Desc:RESPIRATORY DISTRESS* Caller:matthew breyer* Ph#:336-480-8928* Units:23* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 06:50:14 : pos1 : KBROOKS Cross streets: RHYNEHARDT RD//CEDAR FOREST LN Cross streets: US HWY 601 N//THEODORE DR*",
        "ID:130328-0420",
        "ADDR:1869 NC HWY 801 N",
        "MADDR:1869 STATE 801 N",
        "CITY:MOCKSVILLE",
        "X:RHYNEHARDT RD & CEDAR FOREST LN",
        "INFO:Med:Medical: No / Haz:Hazards: No",
        "CODE:RD",
        "CALL:RESPIRATORY DISTRESS",
        "NAME:matthew breyer",
        "PHONE:336-480-8928",
        "UNIT:23",
        "DATE:03/28/2013",
        "TIME:06:50:14");

    doTest("T4",
        "911:Call#130327-0331* Address:124 ROSEWALK LN* * * City:ADVANCE* TOWNPARK DR* NORTH FIELD DR* * LocCmmt:Geo Comment: KINDERTON DEVELOPMENT NBH: OFF 200 BLK TOWNPARK DR OFF OLD TOWNE DR* Comp:HC* Desc:HAZARDOUS CONDITION* Caller:KOHLER,BILLIE* Ph#:336-940-4275* Units:23,24* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 11:28:05 : pos1 : JJASTER Cross streets: TOWNPARK DR//NORTH FIELD DR Geo Comment: KINDERTON DEVELOPMENT NBH: OFF 200 BLK TOWNPARK DR OFF OLD TOWNE DR Cross streets: US HWY 158//DEADEND NBH: OFF 4900 BLOCK US HWY 158 STRONG SMELL OUTSIDE ..SMELLS LIKE ONIONS.. WANTS FD TO COME CHECK AND SEE IF GAS .. OUTSIDE*",
        "ID:130327-0331",
        "ADDR:124 ROSEWALK LN",
        "CITY:ADVANCE",
        "X:TOWNPARK DR & NORTH FIELD DR",
        "INFO:KINDERTON DEVELOPMENT / Med:Medical: No / Haz:Hazards: No\nNBH: OFF 4900 BLOCK US HWY 158 STRONG SMELL OUTSIDE ..SMELLS LIKE ONIONS.. WANTS FD TO COME CHECK AND SEE IF GAS",
        "CODE:HC",
        "CALL:HAZARDOUS CONDITION",
        "NAME:KOHLER,BILLIE",
        "PHONE:336-940-4275",
        "UNIT:23,24",
        "DATE:03/27/2013",
        "TIME:11:28:05",
        "PLACE:OFF 200 BLK TOWNPARK DR OFF OLD TOWNE DR");

    doTest("T5",
        "911:Call#130327-0307* Address:219 DUTCHMAN TRL* * * City:MOCKSVILLE* PATRICIA WA* PATRICIA WA* * LocCmmt:NBH: OFF 338 FARMINGTON RD* Comp:6D2* Desc:BREATHING PROBLEMS* Caller:REAVIS JEFFERY* Ph#:336-940-2619* Units:23,32* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 08:01:55 : pos1 : JJASTER ** EMD Case Complete ** Key Questions: 54 year old, Female, Conscious, Breathing. 03/27/2013 08:01:26 : pos1 : JJASTER ** EMD Key Questions Finished ** Key Questions: 5.She has a prescribed inhaler. * 6.She has used a prescribed inhaler. * 7.N/A 03/27/2013 08:01:18 : pos1 : JJASTER ** EMD Reconfigure ** Response Text: Delta Dispatch Level: 06D02 Suffix: A CAD Incident Code: 6D2 Key Questions: DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma). * 3.She is not clammy. * 4.She has asthma. 03/27/2013 08:01:11 : pos1 : JJASTER ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 06D02 CAD Incident Code: 6D2 Key Questions: DIFFICULTY SPEAKING BETWEEN BREATHS. * 1.She is completely alert ",
        "ID:130327-0307",
        "ADDR:219 DUTCHMAN TRL",
        "CITY:MOCKSVILLE",
        "X:PATRICIA WA & PATRICIA WA",
        "INFO:Med:Medical: No / Haz:Hazards: No\n54 year old, Female, Conscious, Breathing.\n** EMD Key Questions Finished ** / 5.She has a prescribed inhaler. / 6.She has used a prescribed inhaler.\n7.N/A\n** EMD Reconfigure ** / Delta Dispatch Level: 06D02 Suffix: A CAD Incident Code: 6D2 / DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma). / 3.She is not clammy.\n4.She has asthma.\nDelta Dispatch Level: 06D02 CAD Incident Code: 6D2 / DIFFICULTY SPEAKING BETWEEN BREATHS. / 1.She is completely alert",
        "CODE:6D2",
        "CALL:BREATHING PROBLEMS",
        "NAME:REAVIS JEFFERY",
        "PHONE:336-940-2619",
        "UNIT:23,32",
        "DATE:03/27/2013",
        "TIME:08:01:11",
        "PLACE:OFF 338 FARMINGTON RD");

    doTest("T6",
        "911:Call#130326-0272* Address:102 I40 EB* * * City:MOCKSVILLE* 601 NORTH* FARMINGTON RD* * LocCmmt:* Comp:VF* Desc:VEHICLE FIRE* Caller:NC DEPT OF TRANSPORTATION* Ph#:336-940-5627* Units:13,23* * Med:Medical: No* Haz:Hazards: No* Narr:03/26/2013 21:13:00 : pos4 : RPIERCE Cross streets: 601 NORTH//FARMINGTON RD black blazer on the camper side caller advised looked like something was on fire inside the front of the blazer*",
        "ID:130326-0272",
        "ADDR:102 I40 EB",
        "MADDR:102 I 40",
        "CITY:MOCKSVILLE",
        "X:601 NORTH & FARMINGTON RD",
        "INFO:Med:Medical: No / Haz:Hazards: No\nblack blazer on the camper side caller advised looked like something was on fire inside the front of the blazer",
        "CODE:VF",
        "CALL:VEHICLE FIRE",
        "NAME:NC DEPT OF TRANSPORTATION",
        "PHONE:336-940-5627",
        "UNIT:13,23",
        "DATE:03/26/2013",
        "TIME:21:13:00");

  }
  
  @Test
  public void testDavieRescue() {

    doTest("T1",
        "911:Call#130330-0708* Address:202 POWELL RD* * * City:MOCKSVILLE* US HWY 64 W* ALLISON LN* * Location:NBH: OFF 2152 US HWY 64 W* Complaint:MED* Desc:MEDICAL CALL* Caller:* Ph#:336-655-4441* Units:13,34,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/30/2013 10:27:43 : pos1 : JALLGOOD ** EMD Case Entry Finished ** Chief Complaint Number: 31 Key Questions: 59 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Caller Statement: mother is sick with brain swelling . 03/30/2013 10:26:52 : pos2 : JBYERLY Call 130330-0707, 130330-0708 are related. 03/30/2013 10:26:28 : pos2 : JBYERLY Cross streets: US HWY 64 W//ALLISON LN NBH: OFF 2152 US HWY 64 W*",
        "ID:130330-0708",
        "ADDR:202 POWELL RD",
        "CITY:MOCKSVILLE",
        "X:US HWY 64 W & ALLISON LN",
        "INFO:Med:Medical: No / Haz:Hazards: No\nChief Complaint Number: 31 / 59 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Caller Statement: mother is sick with brain swelling .\nCall 130330-0707, 130330-0708 are related.",
        "CODE:MED",
        "CALL:MEDICAL CALL",
        "PHONE:336-655-4441",
        "UNIT:13,34,ST4",
        "DATE:03/30/2013",
        "TIME:10:27:43",
        "PLACE:OFF 2152 US HWY 64 W");

    doTest("T2",
        "911:Call#130330-0682* Address:176 MIDWAY ST* * * City:COOLEEMEE* RAMARS CT* GROVE ST* * Location:NBH: 100 BLOCK RAMARS CT TO 277 GROVE ST* Complaint:MED* Desc:MEDICAL CALL* Caller:BROWN, WALTER* Ph#:336-284-2835* Units:14,33,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/30/2013 05:20:28 : pos1 : TWMYERS Cross streets: RAMARS CT//GROVE ST NBH: 100 BLOCK RAMARS CT TO 277 GROVE ST*",
        "ID:130330-0682",
        "ADDR:176 MIDWAY ST",
        "CITY:COOLEEMEE",
        "X:RAMARS CT & GROVE ST",
        "INFO:Med:Medical: No / Haz:Hazards: No",
        "CODE:MED",
        "CALL:MEDICAL CALL",
        "NAME:BROWN, WALTER",
        "PHONE:336-284-2835",
        "UNIT:14,33,ST4",
        "DATE:03/30/2013",
        "TIME:05:20:28",
        "PLACE:100 BLOCK RAMARS CT TO 277 GROVE ST");

    doTest("T3",
        "911:Call#130330-0681* Address:115 S MILLBROOKE CT* * * City:ADVANCE* MILL COVE DR* DEAD END* * Location:NBH: OFF 200 BLK N HIDDENBROOK OFF 150 BLOK TWIN CREEK* Complaint:26D1* Desc:SICK PERSON (SPECIFIC DIAGNOSIS)* Caller:GAY WILLIAM W* Ph#:336-940-4082* Units:24,32,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/30/2013 05:16:23 : pos1 : TWMYERS ** EMD Key Questions Finished ** Key Questions: 2.His primary problem is fever/chills. 03/30/2013 05:16:18 : pos1 : TWMYERS ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 26D01 CAD Incident Code: 26D1 Key Questions: Not alert. * 1.He is not completely alert (not responding appropriately). 03/30/2013 05:16:09 : pos1 : TWMYERS ** EMD Case Entry Finished ** Chief Complaint Number: 26 Key Questions: 87 year old, Male, Conscious, Breathing. Sick Person (Specific Diagnosis). Caller Statement: HIGH FEVER. 03/30/2013 05:15:51 : pos1 : TWMYERS Cross streets: MILL COVE DR//DEAD END NBH: OFF 200 BLK N HIDDENBROOK OFF 150 BLOK TWIN ",
        "ID:130330-0681",
        "ADDR:115 S MILLBROOKE CT",
        "CITY:ADVANCE",
        "X:MILL COVE DR & DEAD END",
        "INFO:Med:Medical: No / Haz:Hazards: No\n** EMD Key Questions Finished ** / 2.His primary problem is fever/chills.\nDelta Dispatch Level: 26D01 CAD Incident Code: 26D1 / Not alert.\n1.He is not completely alert (not responding appropriately).\nChief Complaint Number: 26 / 87 year old, Male, Conscious, Breathing. Sick Person (Specific Diagnosis). Caller Statement: HIGH FEVER.\nNBH: OFF 200 BLK N HIDDENBROOK OFF 150 BLOK TWIN",
        "CODE:26D1",
        "CALL:SICK PERSON (SPECIFIC DIAGNOSIS)",
        "NAME:GAY WILLIAM W",
        "PHONE:336-940-4082",
        "UNIT:24,32,ST4",
        "DATE:03/30/2013",
        "TIME:05:16:09",
        "PLACE:OFF 200 BLK N HIDDENBROOK OFF 150 BLOK TWIN CREEK");

    doTest("T4",
        "911:Call#130329-0596* Address:622 RIVERBEND DR* * * City:ADVANCE* SPYGLASS DR* SPYGLASS DR* * Location:Geo Comment: BERMUDA RUN DEV* Complaint:RD* Desc:RESPIRATORY DISTRESS* Caller:WHITMAN, CHARLES H* Ph#:336-998-4309* Units:32,FC14,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 13:25:46 : pos1 : SFRYE Cross streets: SPYGLASS DR//SPYGLASS DR Geo Comment: BERMUDA RUN DEV*",
        "ID:130329-0596",
        "ADDR:622 RIVERBEND DR",
        "CITY:ADVANCE",
        "X:SPYGLASS DR & SPYGLASS DR",
        "INFO:BERMUDA RUN DEV / Med:Medical: No / Haz:Hazards: No",
        "CODE:RD",
        "CALL:RESPIRATORY DISTRESS",
        "NAME:WHITMAN, CHARLES H",
        "PHONE:336-998-4309",
        "UNIT:32,FC14,ST4",
        "DATE:03/29/2013",
        "TIME:13:25:46");

    doTest("T5",
        "911:Call#130329-0559* Address:421 ALLEN RD* * * City:MOCKSVILLE* HIDDEN VALLEY LN* DEADEND* * Location:Special Comment:: MR TRIVETTE IS TAKING MEDICINE CAUSING CONFUSION NBH: OFF 2100 BLOCK US HWY 601 N* Complaint:CVA* Desc:STROKE* Caller:133* Ph#:336-492-7471* Units:17,31,ST4* * Med:Medical: Yes* Haz:Hazards: No* Narr:03/29/2013 09:28:56 : pos1 : SFRYE Special Comment:: MR TRIVETTE IS TAKING MEDICINE CAUSING CONFUSION Cross streets: HIDDEN VALLEY LN//DEADEND NBH: OFF 2100 BLOCK US HWY 601 N*",
        "ID:130329-0559",
        "ADDR:421 ALLEN RD",
        "CITY:MOCKSVILLE",
        "X:HIDDEN VALLEY LN & DEADEND",
        "INFO:Special Comment:: MR TRIVETTE IS TAKING MEDICINE CAUSING CONFUSION / Med:Medical: Yes / Haz:Hazards: No",
        "CODE:CVA",
        "CALL:STROKE",
        "NAME:133",
        "PHONE:336-492-7471",
        "UNIT:17,31,ST4",
        "DATE:03/29/2013",
        "TIME:09:28:56",
        "PLACE:OFF 2100 BLOCK US HWY 601 N");

    doTest("T6",
        "911:Call#130329-0543* Address:482 POWELL RD* * * City:MOCKSVILLE* ALLISON LN* GODBEY RD* * Location:NBH: FROM 466 GODBEY RD TO 2152 US HWY 64 W* Complaint:SEI* Desc:SEIZURE* Caller:GALE PAUL H* Ph#:336-492-6322* Units:13,34,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 02:29:57 : pos2 : SSPEER Cross streets: ALLISON LN//GODBEY RD NBH: FROM 466 GODBEY RD TO 2152 US HWY 64 W*",
        "ID:130329-0543",
        "ADDR:482 POWELL RD",
        "CITY:MOCKSVILLE",
        "X:ALLISON LN & GODBEY RD",
        "INFO:Med:Medical: No / Haz:Hazards: No",
        "CODE:SEI",
        "CALL:SEIZURE",
        "NAME:GALE PAUL H",
        "PHONE:336-492-6322",
        "UNIT:13,34,ST4",
        "DATE:03/29/2013",
        "TIME:02:29:57",
        "PLACE:FROM 466 GODBEY RD TO 2152 US HWY 64 W");

    doTest("T7",
        "911:Call#130328-0523* Address:235 DEADMON RD* * * City:MOCKSVILLE* US HWY 601 S* REDWOOD DR* * Location:NBH: OFF 1590 US HWY 601 S* Complaint:50PI* Desc:ACCIDENT/INJURY* Caller:FISHER DOROTHY E* Ph#:336-753-0675* Units:21,33,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 21:07:56 : pos4 : ABURTON Cross streets: US HWY 601 S//REDWOOD DR NBH: OFF 1590 US HWY 601 S 2 VEHICLES UNBKNOWN INJURIES*",
        "ID:130328-0523",
        "ADDR:235 DEADMON RD",
        "CITY:MOCKSVILLE",
        "X:US HWY 601 S & REDWOOD DR",
        "INFO:Med:Medical: No / Haz:Hazards: No\n2 VEHICLES UNBKNOWN INJURIES",
        "CODE:50PI",
        "CALL:ACCIDENT/INJURY",
        "NAME:FISHER DOROTHY E",
        "PHONE:336-753-0675",
        "UNIT:21,33,ST4",
        "DATE:03/28/2013",
        "TIME:21:07:56",
        "PLACE:OFF 1590 US HWY 601 S");

    doTest("T8",
        "911:Call#130328-0506* Address:253 CAMPBELL RD* * * City:MOCKSVILLE* HOLMAN ST* HEWITT LN* * Location:NBH: OFF 1000 N MAIN ST* Complaint:50PI* Desc:ACCIDENT/INJURY* Caller:VERIZON* Ph#:336-909-0711* Units:22,31,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 19:03:12 : pos2 : JJASTER Cross streets: HOLMAN ST//HEWITT LN NBH: OFF 1000 N MAIN ST CAMEL//*",
        "ID:130328-0506",
        "ADDR:253 CAMPBELL RD",
        "CITY:MOCKSVILLE",
        "X:HOLMAN ST & HEWITT LN",
        "INFO:Med:Medical: No / Haz:Hazards: No\nCAMEL//",
        "CODE:50PI",
        "CALL:ACCIDENT/INJURY",
        "PHONE:336-909-0711",
        "UNIT:22,31,ST4",
        "DATE:03/28/2013",
        "TIME:19:03:12",
        "PLACE:OFF 1000 N MAIN ST");

    doTest("T9",
        "911:Call#130328-0481* Address:1281 DAVIE ACADEMY RD* * * City:MOCKSVILLE* JONES RD* BLUEGRASS TR* * Location:* Complaint:MED* Desc:MEDICAL CALL* Caller:VERIZON WIRELESS* Ph#:336-909-3305* Units:18,34,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 15:02:08 : pos4 : ABURTON ** EMD Case Entry Finished ** Chief Complaint Number: 30 Key Questions: 61 year old, Female, Conscious, Breathing. Traumatic Injuries (Specific). Caller Statement: broke arm. 03/28/2013 15:01:49 : pos4 : ABURTON Cross streets: JONES RD//BLUEGRASS TR*",
        "ID:130328-0481",
        "ADDR:1281 DAVIE ACADEMY RD",
        "CITY:MOCKSVILLE",
        "X:JONES RD & BLUEGRASS TR",
        "INFO:Med:Medical: No / Haz:Hazards: No\nChief Complaint Number: 30 / 61 year old, Female, Conscious, Breathing. Traumatic Injuries (Specific). Caller Statement: broke arm.",
        "CODE:MED",
        "CALL:MEDICAL CALL",
        "PHONE:336-909-3305",
        "UNIT:18,34,ST4",
        "DATE:03/28/2013",
        "TIME:15:02:08");

    doTest("T10",
        "911:Call#130328-0464* Address:112 E KINDERTON WA* * * City:ADVANCE* ABERCORN WAY* DEADEND* * Location:Geo Comment: KINDERTON DEV NBH: OFF ABERCORN OFF DORNACH WA OFF KINDERTON BLV* Complaint:TRA* Desc:TRANSPORT* Caller:faith* Ph#:336-941-3118* Units:31,FC14,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 13:09:59 : pos2 : JJASTER Cross streets: ABERCORN WAY//DEADEND Geo Comment: KINDERTON DEV NBH: OFF ABERCORN OFF DORNACH WA OFF KINDERTON BLV 03/28/2013 13:06:22 : pos4 : ABURTON 10-18 80 yr old female not responsvive they are bagging*",
        "ID:130328-0464",
        "ADDR:112 E KINDERTON WA",
        "MADDR:112 E KINDERTON WAY",
        "CITY:ADVANCE",
        "X:ABERCORN WAY & DEADEND",
        "INFO:KINDERTON DEV / Med:Medical: No / Haz:Hazards: No\n10-18 80 yr old female not responsvive they are bagging",
        "CODE:TRA",
        "CALL:TRANSPORT",
        "NAME:faith",
        "PHONE:336-941-3118",
        "UNIT:31,FC14,ST4",
        "DATE:03/28/2013",
        "TIME:13:09:59",
        "PLACE:OFF ABERCORN OFF DORNACH WA OFF KINDERTON BLV");

  }
  
  @Test
  public void testAdvanceFireDepartment() {

    doTest("T1",
        "911:Call#130329-0639* Address:1617 PEOPLES CREEK RD* * * City:ADVANCE* MARCHMONT DR* SOUTHERN MAGNOLIA DR* * Location:NBH: OFF 2500 BLOCK 801 SOUTH ADVANCE END* Complaint:SF* Desc:STRUCTURE FIRE* Caller:JONES PATRICIA R* Ph#:336-998-7073* Units:12* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 18:09:34 : pos2 : JALLGOOD Cross streets: MARCHMONT DR//SOUTHERN MAGNOLIA DR NBH: OFF 2500 BLOCK 801 SOUTH ADVANCE END*",
        "ID:130329-0639",
        "ADDR:1617 PEOPLES CREEK RD",
        "CITY:ADVANCE",
        "X:MARCHMONT DR & SOUTHERN MAGNOLIA DR",
        "INFO:Med:Medical: No / Haz:Hazards: No",
        "CODE:SF",
        "CALL:STRUCTURE FIRE",
        "NAME:JONES PATRICIA R",
        "PHONE:336-998-7073",
        "UNIT:12",
        "DATE:03/29/2013",
        "TIME:18:09:34",
        "PLACE:OFF 2500 BLOCK 801 SOUTH ADVANCE END");

    doTest("T2",
        "911:Call#130327-0338* Address:190 DESTINY TRL* * * City:ADVANCE* POTTS RD* DEADEND* * LocCmmt:NBH: OFF 300 BLOCK POTTS RD* Comp:RD* Desc:RESPIRATORY DISTRESS* Caller:AT&T MOBILITY* Ph#:336-655-3549* Units:12* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 12:42:51 : pos1 : JJASTER Cross streets: POTTS RD//DEADEND NBH: OFF 300 BLOCK POTTS RD*",
        "ID:130327-0338",
        "ADDR:190 DESTINY TRL",
        "CITY:ADVANCE",
        "X:POTTS RD & DEADEND",
        "INFO:Med:Medical: No / Haz:Hazards: No",
        "CODE:RD",
        "CALL:RESPIRATORY DISTRESS",
        "PHONE:336-655-3549",
        "UNIT:12",
        "DATE:03/27/2013",
        "TIME:12:42:51",
        "PLACE:OFF 300 BLOCK POTTS RD");

  }
  
  @Test
  public void testMocksvilleFireDepartment() {

    doTest("T1",
        "911:Call#130329-0609* Address:109 ROLLINGWOOD DR* * * City:MOCKSVILLE* SALISBURY RD* RANDOM RD* * Location:NBH: OFF 1340 SALISBURY RD BELOW DAVIE HIGH--SOUTHWOOD DEV* Complaint:GWB* Desc:GRASS/WOODS/BRUSH FIRE* Caller:* Ph#:336- -* Units:22* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 15:10:18 : pos1 : SFRYE Cross streets: SALISBURY RD//RANDOM RD NBH: OFF 1340 SALISBURY RD BELOW DAVIE HIGH--SOUTHWOOD DEV*",
        "ID:130329-0609",
        "ADDR:109 ROLLINGWOOD DR",
        "CITY:MOCKSVILLE",
        "X:SALISBURY RD & RANDOM RD",
        "INFO:Med:Medical: No / Haz:Hazards: No",
        "CODE:GWB",
        "CALL:GRASS/WOODS/BRUSH FIRE",
        "PHONE:336- -",
        "UNIT:22",
        "DATE:03/29/2013",
        "TIME:15:10:18",
        "PLACE:OFF 1340 SALISBURY RD BELOW DAVIE HIGH--SOUTHWOOD DEV");

    doTest("T2",
        "911:Call#130329-0595* Address:134 DONREE LN* * * City:MOCKSVILLE* US HWY 158* DEADEND* * Location:NBH: OFF 2144 US HWY 158 ACROSS FROM WHITAKER RD* Complaint:FA* Desc:FIRE ALARM* Caller:cpi* Ph#:800-948-7133* Units:22* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 12:55:25 : pos2 : JALLGOOD Cross streets: US HWY 158//DEADEND NBH: OFF 2144 US HWY 158 ACROSS FROM WHITAKER RD beverly pilcher upstairs smoke alarm*",
        "ID:130329-0595",
        "ADDR:134 DONREE LN",
        "CITY:MOCKSVILLE",
        "X:US HWY 158 & DEADEND",
        "INFO:Med:Medical: No / Haz:Hazards: No\nbeverly pilcher upstairs smoke alarm",
        "CODE:FA",
        "CALL:FIRE ALARM",
        "NAME:cpi",
        "PHONE:800-948-7133",
        "UNIT:22",
        "DATE:03/29/2013",
        "TIME:12:55:25",
        "PLACE:OFF 2144 US HWY 158 ACROSS FROM WHITAKER RD");

    doTest("T3",
        "911:Call#130329-0593* Address:817 SALISBURY RD* * * City:MOCKSVILLE* CITY LIMITS* KAYDON DR* * Location:* Complaint:ATL* Desc:ATTEMPT TO LOCATE* Caller:SPRINT NEXTEL - CDMA* Ph#:704-273-9519* Units:212,22* * Med:Medical: No* Haz:Hazards: No* Narr:03/29/2013 12:40:46 : pos1 : SFRYE Cross streets: CITY LIMITS//KAYDON DR Landmark: MOCKSVILLE CAR WASH Cross streets: CUSTOM DR//CITY LIMITS NBH: OFF 1098 SALISBURY RD GOLD SATURN BHZ-6638*",
        "ID:130329-0593",
        "ADDR:817 SALISBURY RD",
        "CITY:MOCKSVILLE",
        "X:CITY LIMITS & KAYDON DR",
        "INFO:Med:Medical: No / Haz:Hazards: No\nNBH: OFF 1098 SALISBURY RD GOLD SATURN BHZ-6638",
        "CODE:ATL",
        "CALL:ATTEMPT TO LOCATE",
        "PHONE:704-273-9519",
        "UNIT:212,22",
        "DATE:03/29/2013",
        "TIME:12:40:46",
        "PLACE:MOCKSVILLE CAR WASH");

    doTest("T4",
        "911:Call#130328-0506* Address:253 CAMPBELL RD* * * City:MOCKSVILLE* HOLMAN ST* HEWITT LN* * Location:NBH: OFF 1000 N MAIN ST* Complaint:50PI* Desc:ACCIDENT/INJURY* Caller:VERIZON* Ph#:336-909-0711* Units:22* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 19:03:12 : pos2 : JJASTER Cross streets: HOLMAN ST//HEWITT LN NBH: OFF 1000 N MAIN ST CAMEL//*",
        "ID:130328-0506",
        "ADDR:253 CAMPBELL RD",
        "CITY:MOCKSVILLE",
        "X:HOLMAN ST & HEWITT LN",
        "INFO:Med:Medical: No / Haz:Hazards: No\nCAMEL//",
        "CODE:50PI",
        "CALL:ACCIDENT/INJURY",
        "PHONE:336-909-0711",
        "UNIT:22",
        "DATE:03/28/2013",
        "TIME:19:03:12",
        "PLACE:OFF 1000 N MAIN ST");

    doTest("T5",
        "911:Call#130327-0296* Address:622 N MAIN ST* * * City:MOCKSVILLE* POPLAR ST* HEMLOCK ST* * LocCmmt:NBH: OFF 100 POPLAR ST TO 100 HEMLOCK ST* Comp:FALL* Desc:FALL* Caller:BRENT HALL* Ph#:336-469-9339* Units:22* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 05:58:18 : pos1 : SPHILLIPS Cross streets: POPLAR ST//HEMLOCK ST Landmark: B C BROCK NBH: OFF 100 POPLAR ST TO 100 HEMLOCK ST Cross streets: CUSTOM DR//CITY LIMITS NBH: OFF 1098 SALISBURY RD COME IN THROUGH THE BACK*",
        "ID:130327-0296",
        "ADDR:622 N MAIN ST",
        "CITY:MOCKSVILLE",
        "X:POPLAR ST & HEMLOCK ST",
        "INFO:Med:Medical: No / Haz:Hazards: No\nNBH: OFF 1098 SALISBURY RD COME IN THROUGH THE BACK",
        "PLACE:OFF 1098 SALISBURY RD COME IN THROUGH THE BACK",
        "CODE:FALL",
        "CALL:FALL",
        "NAME:BRENT HALL",
        "PHONE:336-469-9339",
        "UNIT:22",
        "DATE:03/27/2013",
        "TIME:05:58:18",
        "PLACE:B C BROCK OFF 100 POPLAR ST TO 100 HEMLOCK ST");

  }
  
  @Test
  public void testSheffieldCalahalnVFD() {

    doTest("T1",
        "911:Call#130327-0290* Address:3037 SANDY SPRINGS RD* * * City:STATESVILLE* * * * LocCmmt:* Comp:SF* Desc:STRUCTURE FIRE* Caller:IREDELL COUNTY ECOM* Ph#:704-878-3039* Units:16* * Med:Medical: No* Haz:Hazards: No* Narr:03/27/2013 01:42:12 : pos1 : SPHILLIPS STATION 16*",
        "ID:130327-0290",
        "ADDR:3037 SANDY SPRINGS RD",  // Not mapping
        "CITY:STATESVILLE",
        "INFO:Med:Medical: No / Haz:Hazards: No\nSTATION 16",
        "CODE:SF",
        "CALL:STRUCTURE FIRE",
        "NAME:IREDELL COUNTY ECOM",
        "PHONE:704-878-3039",
        "UNIT:16",
        "DATE:03/27/2013",
        "TIME:01:42:12");
  
  }
  
  @Test
  public void testCountyLineFire() {

    doTest("T1",
        "911:Call#130415-2671* Address:164 I40 WB* * * City:MOCKSVILLE* IREDELL COUNTY LINE* 64 W AT CENTER* * Location:* Complaint:50PI* Description:ACCIDENT/INJURY* Caller:VERIZON WIRELESS* Ph#:864-590-9259* Units:18,31,ST4* * Med:Medical: No* Haz:Hazards: No* Narr:04/15/2013 16:22:58 : pos4 : ABURTON Cross streets: IREDELL COUNTY LINE//64 W AT CENTER 04/15/2013 16:22:21 : pos4 : ABURTON 2 VEHICLE S*",
        "ID:130415-2671",
        "ADDR:164 I40 WB",
        "MADDR:164 I 40",
        "CITY:MOCKSVILLE",
        "X:IREDELL COUNTY LINE & 64 W AT CENTER",
        "INFO:Med:Medical: No / Haz:Hazards: No\n2 VEHICLE S",
        "CODE:50PI",
        "CALL:ACCIDENT/INJURY",
        "PHONE:864-590-9259",
        "UNIT:18,31,ST4",
        "DATE:04/15/2013",
        "TIME:16:22:58");

    doTest("T2",
        "911:Call#130415-2667* Address:162 I40 WB* * * City:MOCKSVILLE* IREDELL COUNTY LINE* 64 W AT CENTER* * Location:* Complaint:50PI* Description:ACCIDENT/INJURY* Caller:SPRINT NEXTEL - CDMA* Ph#:336-477-4206* Units:13,31,ST4,18* * Med:Medical: No* Haz:Hazards: No* Narr:04/15/2013 16:19:22 : pos2 : TJONES Cross streets: IREDELL COUNTY LINE//64 W AT CENTER Cross streets: DAVIE FARMS TR//WOOD VALE DR*",
        "ID:130415-2667",
        "ADDR:162 I40 WB",
        "MADDR:162 I 40",
        "CITY:MOCKSVILLE",
        "X:IREDELL COUNTY LINE & 64 W AT CENTER",
        "INFO:Med:Medical: No / Haz:Hazards: No",
        "CODE:50PI",
        "CALL:ACCIDENT/INJURY",
        "PHONE:336-477-4206",
        "UNIT:13,31,ST4,18",
        "DATE:04/15/2013",
        "TIME:16:19:22");

    doTest("T3",
        "911:Call#130413-2349* Address:103 VAUGHN MILL RD* * * City:STATESVILLE* * * * Location:* Complaint:SF* Description:STRUCTURE FIRE* Caller:IREDELL COUNTY* Ph#:704-878-3039* Units:16,18,1802,18PV* * Med:Medical: No* Haz:Hazards: No* Narr:04/13/2013 02:34:58 : pos1 : SPHILLIPS BARN FIRE*",
        "ID:130413-2349",
        "ADDR:103 VAUGHN MILL RD",
        "CITY:STATESVILLE",
        "INFO:Med:Medical: No / Haz:Hazards: No\nBARN FIRE",
        "CODE:SF",
        "CALL:STRUCTURE FIRE",
        "NAME:IREDELL COUNTY",
        "PHONE:704-878-3039",
        "UNIT:16,18,1802,18PV",
        "DATE:04/13/2013",
        "TIME:02:34:58");

    doTest("T4",
        "911:Call#130413-2349* Address:103 FAWN MILL RD* * * City:MOCKSVILLE* * * * Location:* Complaint:SF* Description:STRUCTURE FIRE* Caller:IREDELL COUNTY* Ph#:704-878-3039* Units:16,18* * Med:Medical: No* Haz:Hazards: No* Narr:04/13/2013 02:34:58 : pos1 : SPHILLIPS BARN FIRE*",
        "ID:130413-2349",
        "ADDR:103 FAWN MILL RD",
        "CITY:MOCKSVILLE",
        "INFO:Med:Medical: No / Haz:Hazards: No\nBARN FIRE",
        "CODE:SF",
        "CALL:STRUCTURE FIRE",
        "NAME:IREDELL COUNTY",
        "PHONE:704-878-3039",
        "UNIT:16,18",
        "DATE:04/13/2013",
        "TIME:02:34:58");

    doTest("T5",
        "911:Call#130412-2337* Address:I40* * * City:STATESVILLE* * * * Location:* Complaint:50PI* Description:ACCIDENT/INJURY* Caller:* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:*",
        "ID:130412-2337",
        "ADDR:I40",
        "MADDR:I 40",
        "CITY:STATESVILLE",
        "INFO:Med:Medical: No / Haz:Hazards: No / Narr:",
        "CODE:50PI",
        "CALL:ACCIDENT/INJURY",
        "PHONE:336- -",
        "UNIT:18");

    doTest("T6",
        "911:Call#130412-2263* Address:167 I40 EB* * * City:MOCKSVILLE* IREDELL COUNTY LINE* 64 WEST AT CENTER* * Location:* Complaint:50PD* Description:ACCIDENT/DAMAGE* Caller:VERIZON* Ph#:919-721-0078* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:04/12/2013 15:44:21 : pos4 : SFRYE Cross streets: IREDELL COUNTY LINE//64 WEST AT CENTER Cross streets: DAVIE FARMS TR//WOOD VALE DR SILVER HONDA*",
        "ID:130412-2263",
        "ADDR:167 I40 EB",
        "MADDR:167 I 40",
        "CITY:MOCKSVILLE",
        "X:IREDELL COUNTY LINE & 64 WEST AT CENTER",
        "INFO:Med:Medical: No / Haz:Hazards: No\nSILVER HONDA",
        "CODE:50PD",
        "CALL:ACCIDENT/DAMAGE",
        "PHONE:919-721-0078",
        "UNIT:18",
        "DATE:04/12/2013",
        "TIME:15:44:21");

    doTest("T7",
        "911:Call#130411-2029* Address:2464 OLD MOCKSVILLE RD* * * City:HARMONY* * * * Location:* Complaint:FALL* Description:FALL* Caller:IRC* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:*",
        "ID:130411-2029",
        "ADDR:2464 OLD MOCKSVILLE RD",
        "CITY:HARMONY",
        "INFO:Med:Medical: No / Haz:Hazards: No / Narr:",
        "CODE:FALL",
        "CALL:FALL",
        "NAME:IRC",
        "PHONE:336- -",
        "UNIT:18");

    doTest("T8",
        "911:Call#130406-1503* Address:155 I40 MEDIAN* * * City:MOCKSVILLE* * * * Location:* Complaint:GWB* Desc:GRASS/WOODS/BRUSH FIRE* Caller:* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:*",
        "ID:130406-1503",
        "ADDR:155 I40 MEDIAN",
        "MADDR:155 I 40 MEDIAN",
        "CITY:MOCKSVILLE",
        "INFO:Med:Medical: No / Haz:Hazards: No / Narr:",
        "CODE:GWB",
        "CALL:GRASS/WOODS/BRUSH FIRE",
        "PHONE:336- -",
        "UNIT:18");

    doTest("T9",
        "911:Call#130404-1330* Address:163 I40 EB* * * City:MOCKSVILLE* IREDELL COUNTY LINE* 64 WEST AT CENTER* * Location:* Complaint:50PI* Desc:ACCIDENT/INJURY* Caller:ADAMS, RACHEL* Ph#:315-416-6262* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:04/04/2013 19:15:01 : pos2 : SPHILLIPS Cross streets: IREDELL COUNTY LINE//64 WEST AT CENTER 04/04/2013 19:14:47 : pos2 : SPHILLIPS Cross streets: IREDELL COUNTY LINE//64 WEST AT CENTER Cross streets: DAVIE FARMS TR//WOOD VALE DR SILVER*",
        "ID:130404-1330",
        "ADDR:163 I40 EB",
        "MADDR:163 I 40",
        "CITY:MOCKSVILLE",
        "X:IREDELL COUNTY LINE & 64 WEST AT CENTER",
        "INFO:Med:Medical: No / Haz:Hazards: No\nSILVER",
        "CODE:50PI",
        "CALL:ACCIDENT/INJURY",
        "NAME:ADAMS, RACHEL",
        "PHONE:315-416-6262",
        "UNIT:18",
        "DATE:04/04/2013",
        "TIME:19:15:01");

    doTest("T10",
        "911:Call#130404-1294* Address:162 I40 EB* * * City:MOCKSVILLE* IREDELL COUNTY LINE* 64 WEST AT CENTER* * Location:* Complaint:58* Desc:DIRECT TRAFFIC* Caller:101* Ph#:336- -* Units:101,110,18* * Med:Medical: No* Haz:Hazards: No* Narr:04/04/2013 15:19:33 : pos2 : JALLGOOD Cross streets: IREDELL COUNTY LINE//64 WEST AT CENTER 04/04/2013 14:56:44 : pos2 : JALLGOOD Cross streets: IREDELL COUNTY LINE//64 W AT CENTER*",
        "ID:130404-1294",
        "ADDR:162 I40 EB",
        "MADDR:162 I 40",
        "CITY:MOCKSVILLE",
        "X:IREDELL COUNTY LINE & 64 WEST AT CENTER",
        "INFO:Med:Medical: No / Haz:Hazards: No",
        "CODE:58",
        "CALL:DIRECT TRAFFIC",
        "NAME:101",
        "PHONE:336- -",
        "UNIT:101,110,18",
        "DATE:04/04/2013",
        "TIME:15:19:33");

    doTest("T11",
        "911:Call#130328-0481* Address:1281 DAVIE ACADEMY RD* * * City:MOCKSVILLE* JONES RD* BLUEGRASS TR* * Location:* Complaint:MED* Desc:MEDICAL CALL* Caller:VERIZON WIRELESS* Ph#:336-909-3305* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 15:02:08 : pos4 : ABURTON ** EMD Case Entry Finished ** Chief Complaint Number: 30 Key Questions: 61 year old, Female, Conscious, Breathing. Traumatic Injuries (Specific). Caller Statement: broke arm. 03/28/2013 15:01:49 : pos4 : ABURTON Cross streets: JONES RD//BLUEGRASS TR*",
        "ID:130328-0481",
        "ADDR:1281 DAVIE ACADEMY RD",
        "CITY:MOCKSVILLE",
        "X:JONES RD & BLUEGRASS TR",
        "INFO:Med:Medical: No / Haz:Hazards: No\nChief Complaint Number: 30 / 61 year old, Female, Conscious, Breathing. Traumatic Injuries (Specific). Caller Statement: broke arm.",
        "CODE:MED",
        "CALL:MEDICAL CALL",
        "PHONE:336-909-3305",
        "UNIT:18",
        "DATE:03/28/2013",
        "TIME:15:02:08");

    doTest("T12",
        "911:Call#130328-0476* Address:157 I40 WB* * * City:MOCKSVILLE* * * * Location:* Complaint:GWB* Desc:GRASS/WOODS/BRUSH FIRE* Caller:ir911* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 14:23:01 : pos4 : ABURTON shoulder of road*",
        "ID:130328-0476",
        "ADDR:157 I40 WB",
        "MADDR:157 I 40",
        "CITY:MOCKSVILLE",
        "INFO:Med:Medical: No / Haz:Hazards: No\nshoulder of road",
        "CODE:GWB",
        "CALL:GRASS/WOODS/BRUSH FIRE",
        "NAME:ir911",
        "PHONE:336- -",
        "UNIT:18",
        "DATE:03/28/2013",
        "TIME:14:23:01");

    doTest("T13",
        "911:Call#130328-0442* Address:168 DWIGGINS RD* * * City:MOCKSVILLE* DAVIE ACADEMY RD* DEADEND* * Location:NBH: 948 DAVIE ACADEMY RD* Complaint:YEL* Desc:CARDIAC PROBLEM* Caller:RICKLES KATHERINE* Ph#:336-492-2358* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 09:52:20 : pos2 : JJASTER Cross streets: DAVIE ACADEMY RD//DEADEND NBH: 948 DAVIE ACADEMY RD*",
        "ID:130328-0442",
        "ADDR:168 DWIGGINS RD",
        "CITY:MOCKSVILLE",
        "X:DAVIE ACADEMY RD & DEADEND",
        "INFO:Med:Medical: No / Haz:Hazards: No",
        "CODE:YEL",
        "CALL:CARDIAC PROBLEM",
        "NAME:RICKLES KATHERINE",
        "PHONE:336-492-2358",
        "UNIT:18",
        "DATE:03/28/2013",
        "TIME:09:52:20",
        "PLACE:948 DAVIE ACADEMY RD");

    doTest("T14",
        "911:Call#130328-0435* Address:213 HAYS FARM RD* * * City:MOCKSVILLE* * * * LocCmmt:* Comp:HEM* Desc:HEMORHAGE* Caller:IREDELL* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 08:39:09 : pos2 : JJASTER LOWER GI BLEED ASSIST IREDELL COUNTY*",
        "ID:130328-0435",
        "ADDR:213 HAYS FARM RD",
        "CITY:MOCKSVILLE",
        "INFO:Med:Medical: No / Haz:Hazards: No\nLOWER GI BLEED ASSIST IREDELL COUNTY",
        "CODE:HEM",
        "CALL:HEMORHAGE",
        "NAME:IREDELL",
        "PHONE:336- -",
        "UNIT:18",
        "DATE:03/28/2013",
        "TIME:08:39:09");

    doTest("T15",
        "911:Call#130328-0412* Address:155 I40 WB* * * City:MOCKSVILLE* * * * LocCmmt:* Comp:PS* Desc:PUBLIC SERVICE* Caller:IREDELL* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:03/28/2013 00:06:03 : pos2 : TWMYERS FUEL LEAK FROM A 10-50*",
        "ID:130328-0412",
        "ADDR:155 I40 WB",
        "MADDR:155 I 40",
        "CITY:MOCKSVILLE",
        "INFO:Med:Medical: No / Haz:Hazards: No\nFUEL LEAK FROM A 10-50",
        "CODE:PS",
        "CALL:PUBLIC SERVICE",
        "NAME:IREDELL",
        "PHONE:336- -",
        "UNIT:18",
        "DATE:03/28/2013",
        "TIME:00:06:03");

    doTest("T16",
        "911:Call#130327-0330* Address:213 HAYSFARM RD* * * City:MOCKSVILLE* * * * LocCmmt:* Comp:MED* Desc:MEDICAL CALL* Caller:* Ph#:336- -* Units:18* * Med:Medical: No* Haz:Hazards: No* Narr:*",
        "ID:130327-0330",
        "ADDR:213 HAYSFARM RD",
        "CITY:MOCKSVILLE",
        "INFO:Med:Medical: No / Haz:Hazards: No / Narr:",
        "CODE:MED",
        "CALL:MEDICAL CALL",
        "PHONE:336- -",
        "UNIT:18");
   
  }
  

  public static void main(String[] args) {
    new NCDavieCountyBParserTest().generateTests("T1");
  }
}
