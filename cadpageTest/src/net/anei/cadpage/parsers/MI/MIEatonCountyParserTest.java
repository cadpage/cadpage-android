package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Eaton County, MI
Contact: Steve Grosshans <firefighter925@gmail.com>
Contact: Chris Sloan <sloanc35@gmail.com>
Sender: cad@eatoncounty.org

CAD:FYI: ;20110000176;10/04/2011 20:35:39;BRUSH FIRE;W MT HOPE HWY/N SHAYTOWN RD;CALLER PASSERBY [10/04/11 20:36:48 KANTCLIFF] N OF ABOVE ADDRESS
CAD:FYI: ;20110000177;10/09/2011 09:45:21;MEDICAL ASSIST;3286 E EATON HWY;Event spawned from EMS PRIORITY 2. [10/09/2011 09:45:21
CAD:FYI: ;20110000178;10/10/2011 07:59:43;MEDICAL ASSIST;10763 N SHAYTOWN RD;Event spawned from EMS PRIORITY 3. [10/10/2011 07:59:
CAD:FYI: ;20110000179;10/11/2011 15:13:37;MEDICAL ASSIST;9040 W GRAND LEDGE HWY;Event spawned from EMS PRIORITY 1
CAD:FYI: ;20110000180;10/11/2011 19:55:29;WIRES DOWN;11600 N IONIA RD;SEMI WENT BY TOOK DOWN WIRE RIPPED METER BOX FROM CALLERS HOUSE
CAD:FYI: ;20110000485;09/16/2011 20:40:28;MEDICAL ASSIST;1931 GIDNER RD;Event spawned from EMS PRIORITY 1. [09/16/2011 20:40:28 JBLOUNT] {122} REQ MANPOWER [09/
CAD:FYI: ;20110000487;09/20/2011 00:38:14;MEDICAL ASSIST;2704 S PERKEY RD;Event spawned from EMS PRIORITY 1. [09/20/2011 00:38:14 KANTCLIFF] [LAW] VICTIM IS TER
CAD:FYI: ;20110000484;09/16/2011 19:23:15;SPECIAL RESCUE;ACKLEY RD/BELL HWY;Event spawned from UNKNOWN PROBLEM. [09/16/2011 19:23:15 JBLOUNT] ONE MAY BE CAUGHT
CAD:FYI: ;20110000471;09/08/2011 14:27:39;MEDICAL ASSIST;414 RAILROAD ST;Event spawned from EMS PRIORITY 1. [09/08/2011 14:27:39 ROWENS] HX LEAKY VALVE IN HEART
CAD:FYI: ;20110000486;09/17/2011 19:48:03;COMPLAINT FIRE INVESTIGATION;800 E SHAW ST;EVERYONE IS OUTSIDE, REF EMS. [09/17/11 19:49:20 JBLOUNT]
CAD:FYI: ;20110000482;09/15/2011 19:42:53;COMPLAINT FIRE INVESTIGATION;W FIVE POINT HWY/MATTHEWS RD;W OF MATTHEWS [09/15/11 19:43:57 KANTCLIFF] NE SIDE OF THE R
CAD:FYI: ;20110000481;09/15/2011 08:19:47;COMMERCIAL FIRE ALARM;417 MAYNARD ST;BEEN GOING FOR 5 MINS. [09/15/11 08:21:10 MBIALKOWSKI] CLLR IN THE NORTH WING. GO
CAD:FYI: ;20110000480;09/14/2011 19:20:41;MISCELLANEOUS FIRE RUN;S PERKEY RD/E CLINTON TRL;Event spawned from MISCELLANEOUS INCIDENT. [09/14/2011 19:20:41 CYARG

Contact: Rebecca Bell <rjbell06@gmail.com>
CAD:FYI: ;EEMS;20120003108;01/29/2012 01:17:26;PRIORTY3;7291 TUCKER RD;ERCY;70/F VOMITTING THE PAST 3-4 HRS [01/29/12 01:21:07 MLUNDQUIST]

Contact: Active911
Agency name: Eaton County 911 Location: Charlotte, MI 
Sender: CAD@eatoncounty.org

CAD:FYI: ;DEMS;1202628;08/31/2012 10:10:01;TRAUMA;6971 W WILLOW HWY;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 30-A-2: NON-RECENT (??? 6hrs) injuries (without priority symptoms) 1. This happened more than 6hrs ago. 2. There is no blee\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202629;08/31/2012 10:44:44;SICK;6333 LANSING RD;DLTA;60-year-old, male, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: FEELING DIZZY. [EMD] [08/31/12 10:46:31 RSTAHELIN]\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202630;08/31/2012 11:10:16;SICK;422 ELMSHAVEN DR;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 26-A-4: Fever/chills 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He has other pain:\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202631;08/31/2012 16:11:38;ALLERGY;6429 EARLINGTON LN;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 2-C-1: Difficulty breathing or swallowing 1. She has an allergic reaction. 2. She is completely alert (responding appropr\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202632;08/31/2012 18:30:37;FALLS;933-2 HARVEST LN;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 17-A-2: NON-RECENT (??? 6hrs) injuries (without priority symptoms) 1. This happened more than 6hrs ago. 2. It`s reported that\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202633;08/31/2012 18:53:27;D I B;7324 PLAYERS CLUB DR;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 6-D-2: DIFFICULTY SPEAKING BETWEEN BREATHS 1. She is completely alert (responding appropriately). 2. She has difficulty s\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202634;08/31/2012 21:53:34;CARDIAC;3301 S CREYTS RD;DLTA;20-year-old, male, not conscious, not breathing. Cardiac or Respiratory Arrest / Death Caller Statement: DIB. [EMD] [08/31/12 21:54:27 HDAWSON]\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202634;08/31/2012 21:53:34;CARDIAC;3301 S CREYTS RD;DLTA;DOING RESCUE BREATHING [08/31/12 21:57:01 HDAWSON] NO DEFIB USED [08/31/12 21:56:57 HDAWSON] Key Questions Complete RESPONSE: ***PRIORITY 1*** Questions: 1. The cardia\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202635;09/01/2012 01:04:24;PSYCH;8460 W HOWE RD;EAGL;** Transfer from CLCD ** CLCD received: 09/01/2012 01:04:11 Source: PHONE Nature: SUICIDE/ATTEMPT/SUICIDAL SUBJ2 Call #: 429 Event Id: 12075216 Console: CAD4 Call Taker: 9\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202636;09/01/2012 04:43:00;CHEST;12857 CRESCENT DR;GDLG;RESPONSE: ***PRIORITY 1*** Questions: Code: 10-C-1: Abnormal breathing 1. He is completely alert (responding appropriately). 2. He is not breathing normally. 3. He does\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202637;09/01/2012 05:46:56;EMS PRIORITY 1;WI96/EI496 RAMP;Event spawned from MEDICAL ASSIST. [09/01/2012 05:46:56 RSTAHELIN] [LAW] CALLER IS SEMI DRIVER THAT STOPPED [09/01/12 05:46:53 ROWENS] Event spawned from PERSONAL INJ\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202638;09/01/2012 05:59:41;SICK;1418 ELMWOOD RD;DLTA;81-year-old, female, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: HIGH FEVER. [EMD] [09/01/12 06:01:01 NBROWN] RESD- RITA KOLBERG TX 517 321684\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:CANCEL;1418 ELMWOOD RD; DLTA\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202639;09/01/2012 10:05:39;CARDIAC;505 THEO AVE;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 9-E-1: Not breathing at all [EMD] [09/01/12 10:07:52 NBROWN] 59-year-old, male, not conscious, not breathing. Cardiac or Respir\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202640;09/01/2012 14:56:02;SICK;4327 GLADYS DR;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 26-C-2: Abnormal breathing 1. She is completely alert (responding appropriately). 2. She is not breathing normally. 3. She has o\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202641;09/01/2012 16:03:33;D I B;2006 ROCKDALE AVE;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 6-D-2: DIFFICULTY SPEAKING BETWEEN BREATHS 1. She is completely alert (responding appropriately). 2. She has difficulty spea\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DFD;09/01/2012 16:47:41;MANPOWER;811 N CANAL RD\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DFD;1251125;09/01/2012 16:47:41;MANPOWER;811 N CANAL RD\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;09/01/2012 19:23:33;ACCIDENT;15427 W GRAND RIVER HWY;EAGL;{FROM CLCD: SUBJ TRIED TO PASS THE TRUCK CAME UP ON CALLER COMING OTHER DIRECTION, AND SWERVED BACK OVER AND HIT TRUCK [09/01/12 19:24:58 926A]} [09/01/12 19:24:59 TRA\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202643;09/01/2012 21:31:02;CHEST;5712-3 PEMBROOK PL;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 10-A-1: Breathing normally < 35 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He is\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202644;09/01/2012 22:14:04;SICK;3023 SNOW RD;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 26-A-4: Fever/chills 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He has other pain: EVER\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202645;09/01/2012 22:42:27;SICK;4820 GULL RD;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 26-C-1: ALTERED LEVEL OF CONSCIOUSNESS 1. He is lethargic. 2. He is not breathing normally. 3. He has other pain: HEAD PAIN, RECEN\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202646;09/02/2012 04:26:17;EMS PRIORITY 2;300-H3 PARKWEST CT;Event spawned from DOMESTIC DISPUTE. [09/02/2012 04:26:17 JBAKER] REQ EMS [09/02/12 04:26:13 JBAKER] AT LEAST 4 PEOPLE THERE [09/02/12 04:26:05 JBAKER] EVERYONE HA\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202647;09/02/2012 04:40:29;D I B;5011 W WILLOW HWY;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 6-D-2: DIFFICULTY SPEAKING BETWEEN BREATHS 1. It`s not certain if he is completely alert (responding appropriately). 2. He h\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202648;09/02/2012 06:31:18;FALLS;4601 NORWICK ST;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 17-A-3-G: PUBLIC ASSIST (no injuries and no priority symptoms) (On the ground or floor) 5. He is completely alert (responding\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202649;09/02/2012 10:44:02;EMS PRIORITY 3;10825 CANTERBURY LN;Event spawned from DISORDERLY PERSON OR SUBJECT. [09/02/2012 10:44:02 RTHACKER] (D3A) EMS [09/02/12 10:43:53 RTHACKER] ONE UNDER ... OPEN AIR [09/02/12 10:43:41 R\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:Update: ;OOAE;1202649;09/02/2012 10:44:02;EMS PRIORITY 3;7639 WALDON;7639 WILDON [09/02/12 10:44:27 RTHACKER] Event spawned from DISORDERLY PERSON OR SUBJECT. [09/02/2012 10:44:02 RTHACKER] (D3A) EMS [09/02/12 10:43:53 RTHACKER] ONE UND\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:Update: ;DEMS;1202649;09/02/2012 10:44:02;EMS PRIORITY 3;7641-BLK WILDON WAY;7639 WILDON [09/02/12 10:44:27 RTHACKER] Event spawned from DISORDERLY PERSON OR SUBJECT. [09/02/2012 10:44:02 RTHACKER] (D3A) EMS [09/02/12 10:43:53 RTHACKER]\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202650;09/02/2012 15:18:09;EMS PRIORITY 3;811 N CANAL RD\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202651;09/02/2012 20:49:48;SEIZURES;7611-2 HERITAGE DR;DLTA;5-year-old, male, conscious, breathing. Convulsions / Seizures Caller Statement: SEIZURE FEVER. [EMD] [09/02/12 20:51:17 CMASON]\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202652;09/02/2012 20:55:43;ABD PAIN;5719 W SAGINAW HWY;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 1-C-6: Females with pain above navel ??? 45 1. She is completely alert (responding appropriately). 2. There was no menti\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202653;09/02/2012 21:08:34;UNCONS;6429 EARLINGTON LN;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Unconscious / Fainting (Near) Code: 31-C-1: Alert with abnormal breathing 1. This happened now (less than 6hrs ago). 2. It`s rep\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202654;09/03/2012 06:45:12;EMS PRIORITY 1;209-D FALLS CT;female just home from the hospital earlier this morning unk problem [09/03/12 06:46:07 DBEACHNAU]\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202655;09/03/2012 07:23:52;BLEEDING;201-14 MALL DRIVE SOUTH;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 21-D-3: DANGEROUS hemorrhage 1. The cause of the bleeding is non-traumatic. 2. The bleeding is from a DANGEROUS are\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202656;09/03/2012 07:43:24;CHEST;3301 S CREYTS RD;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 10-D-4: Clammy 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. It`s not known if he is\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202657;09/03/2012 12:35:21;EMS PRIORITY 1;209-D FALLS CT;Event spawned from UNKNOWN PROBLEM. [09/03/2012 12:35:21 MBIALKOWSKI] CLLR HAS BEEN IN HOSPITAL RECENTLY. [09/03/12 12:14:49 MBIALKOWSKI] HE THREATENED TO BEAT SOMEONE\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202658;09/03/2012 13:34:41;SICK;933 N WAVERLY RD;DLTA;73-year-old, female, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: FEMALE ABOUT TO PASS OUT, DIABETIC (BS246). [EMD] [09/03/12 13:35:22 DBEACHN\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202659;09/03/2012 16:50:05;EMS PRIORITY 2;W SAGINAW HWY/N CANAL RD;W OF [09/03/12 16:50:13 SVANZILE]\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202660;09/03/2012 17:37:07;SICK;1115 BOULDER CT;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 26-A-1: No priority symptoms (complaint conditions 2???11 not identified) 1. She is completely alert (responding appropriately)\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202661;09/04/2012 00:09:55;ABD PAIN;810 DELTA COMMERCE DR;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 1-C-4: Females with fainting or near fainting 12???50 1. She is completely alert (responding appropriately). 2. There\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:Update: ;DEMS;1202661;09/04/2012 00:09:55;ABD PAIN;810-121 DELTA COMMERCE DR;DLTA;PT IS IN ROOM 121 [09/04/12 00:12:45 FROBINSON] RESPONSE: ***PRIORITY 1*** Questions: Code: 1-C-4: Females with fainting or near fainting 12???50 1. She i\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202662;09/04/2012 04:39:59;HEART;1121 DURANGO;DLTA;18-year-old, female, conscious, breathing. Heart Problems / A.I.C.D. Caller Statement: POSS HEART . [EMD] [09/04/12 04:40:37 FROBINSON]\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202663;09/04/2012 11:10:46;SICK;2224 ROCKDALE AVE;DLTA;87-year-old, female, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: WEAKNESS, NUMBNESS . [EMD] [09/04/12 11:12:04 JOSTERMAN] REQ NO LIGHTS/SIRE\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;09/04/2012 12:53:10;EMS PRIORITY 1;3020 N WAVERLY RD;Aborted by Medical Priority with code: MUTUAL AID REQUEST [EMD] [09/04/12 12:54:28 MBIALKOWSKI] 44 YR OLD FEMALE, CAN`T STAND OR MOVE HER LEG. REQ FOR MUTUAL AID AMB. LFD S\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202664;09/04/2012 13:11:22;EMS PRIORITY 3;5303-316 IVAN DR;Aborted by Medical Priority with code: 1. Caller hung up [EMD] [09/04/12 13:12:31 JOSTERMAN] res: UNKNWN TX: 323 2800 MEDICAL ALARM - NO INFO AVAIL WILL CONTACT KH [\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202665;09/04/2012 13:19:39;EMS PRIORITY 3;220 GATEWOOD DR;Event spawned from COMMERCIAL FIRE ALARM. [09/04/2012 13:19:39 SVANZILE] TONED ALL CALL 13:18 [09/04/12 13:18:54 SVANZILE] (401) REQ ALL CALL [09/04/12 13:18:34 SVANZ\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202666;09/04/2012 13:31:45;FALLS;5617 W SAGINAW HWY;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 17-A-1-G: NOT DANGEROUS body area (On the ground or floor) 1. This happened now (less than 6hrs ago). 2. It`s reported that\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202668;09/04/2012 14:00:26;EMS PRIORITY 1;1134 MUNICIPAL WAY;36-year-old, female, conscious, breathing. Unconscious / Fainting (Near) Caller Statement: FEMALE 36 Y/O - SLOW TO RESPONSIVE, NUMB. [EMD] [09/04/12 14:01:35 DBEAC\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202669;09/04/2012 14:15:23;ABD PAIN;4383 W CUTLER RD;DEWT;** Transfer from CLCD ** CLCD received: 09/04/2012 14:12:04 Source: PHONE Nature: ABDOMINAL PAIN/PROBLEMS 2 Call #: 506 Event Id: 12076273 Console: CAD3 Call Taker: 9\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:CANCEL;4383 W CUTLER RD; DEWT\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202669;09/04/2012 14:15:23;ABD PAIN;4383 W CUTLER RD;DEWT;{FROM CLCD: Closed event with disposition [CN]} [09/04/12 14:38:57 TRANSFER] {FROM CLCD: STOMACHE PAIN ALSO [09/04/12 14:16:39 922B]} [09/04/12 14:16:40 TRANSFER] **\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202671;09/04/2012 15:36:06;EMS PRIORITY 2;S WAVERLY RD/MOORES RIVER DR;Event spawned from UNKNOWN ACCIDENT. [09/04/2012 15:36:06 SVANZILE] LPD DISPATCH SAYS THEY HAVE IT AT GLASGOW -- [09/04/12 15:35:05 JOSTERMAN] SB LANE EQ\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202672;09/04/2012 16:13:57;CARDIAC;5020 W SAGINAW HWY;DLTA;62-year-old, male, not conscious, breathing status uncertain. Cardiac or Respiratory Arrest / Death Caller Statement: SUBJ PASSED OUT, FELL ON THE SEAT. [EMD] [09/04\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202673;09/04/2012 16:58:53;SICK;14294 W HOWE RD;PORT;** Transfer from CLCD ** CLCD received: 09/04/2012 16:57:07 Source: W911 Nature: SICK PERSON/NON-SPECIFIC 4 Call #: 558 Event Id: 12076323 Console: CAD1 Call Taker: 910E N\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202674;09/04/2012 21:28:45;ALLERGY;320-S3 PARKWOOD DR;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 2-D-2: DIFFICULTY SPEAKING BETWEEN BREATHS 1. He has an allergic reaction. 2. He is completely alert (responding appropri\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202675;09/04/2012 22:11:42;CHEST;5640 PIERSON HWY;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 10-D-4: Clammy 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He is not changing color\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;1202676;09/04/2012 23:13:26;D I B;4911 MALPASO;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 6-C-1: Abnormal breathing 1. She is completely alert (responding appropriately). 2. She does not have any difficulty speaking bet\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;DEMS;09/05/2012 00:05:56;EMS PRIORITY 1;3900 LAUDERHILL CIR;Aborted by Medical Priority with code: REQ FROM LPD [EMD] [09/05/12 00:07:48 MLUNDQUIST] THEY HAVE AN ENGINE ERNT [09/05/12 00:07:25 MLUNDQUIST] REQ EMS FROM DELTA 63/M D\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses. 

Contact: Active911
Agency name: Charlotte Fire Dept
Location: Charlotte, MI, United States
Sender: CAD@eatoncounty.org

CAD:FYI: ;MISCELLANEOUS FIRE RUN;1399 PORTER DR;ANGEL CT;TIRRELL RD;NO TONE, FOR AN INVESTIGATION [08/07/2013 08:48:27 LWOODS]\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;MEDICAL ASSIST;230 N LINCOLN ST;N BONNIE BROOK DR;W STODDARD ST;Event spawned from FALLS. [08/06/2013 13:37:22 MBIALKOWSKI] 70-year-old, male, conscious, breathing. Falls Caller Statement: FATHER FELL AND HIT HIS HEAD. IS UNCONSCI\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:Update: ;EAMS;08/04/2013 20:34:10;EMS STANDBY;209 BEECH ST;CHAR;OVEN FIRE [08/04/13 20:33:12 CMASON] [FIRE] EVERYONE HAS BEEN TOLD TO LEAVE THE HOUSE [08/04/13 20:34:28 CMASON]\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;CFD;20130000375;08/04/2013 20:32:40;LARGE STRUCTURE FIRE;209 BEECH ST;CHAR;OVEN FIRE [08/04/13 20:33:12 CMASON]\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;CFD;20130000374;08/03/2013 16:55:13;MEDICAL ASSIST;530 BEECH ST;CHAR;Event spawned from BREATHING PROBLEMS. [08/03/2013 16:55:13 NBROWN] 90-year-old, female, conscious, breathing. Breathing Problems Caller Statement: DIB WAS CHOKI\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;CFD;20130000373;08/03/2013 16:04:40;VEHICLE FIRE;SI69/E CLINTON TRL;CHAR;SEMI THAT IS ON FIRE, HEAVY SMOKE FROM THE UNDER THE TRAILER, [08/03/13 16:05:38 NBROWN] N OF M50 [08/03/13 16:05:58 NBROWN]\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;CFD;20130000372;08/03/2013 15:47:47;HEAVY RESCUE;59 SI69;CHAR;Event spawned from TRAFFIC/TRANSPORTATION ACCIDEN. [08/03/2013 15:47:47 NBROWN] Event spawned from UNKNOWN ACCIDENT. [08/03/2013 15:46:25 NBROWN] CROSS ENTIRE HW FROM N\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:CANCEL;1385 GIDNER RD; CHAR\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;CFD;20130000371;08/03/2013 10:11:40;MEDICAL ASSIST;1385 GIDNER RD;CHAR;Event spawned from SICK PERSON. [08/03/2013 10:11:40 RSTAHELIN] 90-year-old, male, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: POS\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.
CAD:FYI: ;CFD;20130000370;08/03/2013 09:19:44;MEDICAL ASSIST;500 MEIJER ST;CHAR;Event spawned from PSYCHIATRIC/ABNORMAL BEHAVIOR. [08/03/2013 09:19:44 NBROWN] Event spawned from SUICIDAL THRT OR ATTEMPT. [08/03/2013 09:18:08 RSTAHELIN] 47 Y\n\n\n\nThis email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.

*/

public class MIEatonCountyParserTest extends BaseParserTest {
  
  public MIEatonCountyParserTest() {
	  setParser(new MIEatonCountyParser(), "EATON COUNTY", "MI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:FYI: ;20110000176;10/04/2011 20:35:39;BRUSH FIRE;W MT HOPE HWY/N SHAYTOWN RD;CALLER PASSERBY [10/04/11 20:36:48 KANTCLIFF] N OF ABOVE ADDRESS",
        "ID:20110000176",
        "DATE:10/04/2011",
        "TIME:20:35:39",
        "CALL:BRUSH FIRE",
        "ADDR:W MT HOPE HWY & N SHAYTOWN RD",
        "INFO:CALLER PASSERBY / N OF ABOVE ADDRESS");

    doTest("T2",
        "CAD:FYI: ;20110000177;10/09/2011 09:45:21;MEDICAL ASSIST;3286 E EATON HWY;Event spawned from EMS PRIORITY 2. [10/09/2011 09:45:21",
        "ID:20110000177",
        "DATE:10/09/2011",
        "TIME:09:45:21",
        "CALL:MEDICAL ASSIST",
        "ADDR:3286 E EATON HWY",
        "PRI:2");

    doTest("T3",
        "CAD:FYI: ;20110000178;10/10/2011 07:59:43;MEDICAL ASSIST;10763 N SHAYTOWN RD;Event spawned from EMS PRIORITY 3. [10/10/2011 07:59:",
        "ID:20110000178",
        "DATE:10/10/2011",
        "TIME:07:59:43",
        "CALL:MEDICAL ASSIST",
        "ADDR:10763 N SHAYTOWN RD",
        "PRI:3");

    doTest("T4",
        "CAD:FYI: ;20110000179;10/11/2011 15:13:37;MEDICAL ASSIST;9040 W GRAND LEDGE HWY;Event spawned from EMS PRIORITY 1",
        "ID:20110000179",
        "DATE:10/11/2011",
        "TIME:15:13:37",
        "CALL:MEDICAL ASSIST",
        "ADDR:9040 W GRAND LEDGE HWY",
        "PRI:1");

    doTest("T5",
        "CAD:FYI: ;20110000180;10/11/2011 19:55:29;WIRES DOWN;11600 N IONIA RD;SEMI WENT BY TOOK DOWN WIRE RIPPED METER BOX FROM CALLERS HOUSE",
        "ID:20110000180",
        "DATE:10/11/2011",
        "TIME:19:55:29",
        "CALL:WIRES DOWN",
        "ADDR:11600 N IONIA RD",
        "INFO:SEMI WENT BY TOOK DOWN WIRE RIPPED METER BOX FROM CALLERS HOUSE");

    doTest("T6",
        "CAD:FYI: ;20110000485;09/16/2011 20:40:28;MEDICAL ASSIST;1931 GIDNER RD;Event spawned from EMS PRIORITY 1. [09/16/2011 20:40:28 JBLOUNT] {122} REQ MANPOWER [09/",
        "ID:20110000485",
        "DATE:09/16/2011",
        "TIME:20:40:28",
        "CALL:MEDICAL ASSIST",
        "ADDR:1931 GIDNER RD",
        "PRI:1",
        "INFO:{122} REQ MANPOWER");

    doTest("T7",
        "CAD:FYI: ;20110000487;09/20/2011 00:38:14;MEDICAL ASSIST;2704 S PERKEY RD;Event spawned from EMS PRIORITY 1. [09/20/2011 00:38:14 KANTCLIFF] [LAW] VICTIM IS TER",
        "ID:20110000487",
        "DATE:09/20/2011",
        "TIME:00:38:14",
        "CALL:MEDICAL ASSIST",
        "ADDR:2704 S PERKEY RD",
        "PRI:1",
        "INFO:VICTIM IS TER");

    doTest("T8",
        "CAD:FYI: ;20110000484;09/16/2011 19:23:15;SPECIAL RESCUE;ACKLEY RD/BELL HWY;Event spawned from UNKNOWN PROBLEM. [09/16/2011 19:23:15 JBLOUNT] ONE MAY BE CAUGHT",
        "ID:20110000484",
        "DATE:09/16/2011",
        "TIME:19:23:15",
        "CALL:SPECIAL RESCUE",
        "ADDR:ACKLEY RD & BELL HWY",
        "INFO:UNKNOWN PROBLEM. / ONE MAY BE CAUGHT");

    doTest("T9",
        "CAD:FYI: ;20110000471;09/08/2011 14:27:39;MEDICAL ASSIST;414 RAILROAD ST;Event spawned from EMS PRIORITY 1. [09/08/2011 14:27:39 ROWENS] HX LEAKY VALVE IN HEART",
        "ID:20110000471",
        "DATE:09/08/2011",
        "TIME:14:27:39",
        "CALL:MEDICAL ASSIST",
        "ADDR:414 RAILROAD ST",
        "PRI:1",
        "INFO:HX LEAKY VALVE IN HEART");

    doTest("T10",
        "CAD:FYI: ;20110000486;09/17/2011 19:48:03;COMPLAINT FIRE INVESTIGATION;800 E SHAW ST;EVERYONE IS OUTSIDE, REF EMS. [09/17/11 19:49:20 JBLOUNT]",
        "ID:20110000486",
        "DATE:09/17/2011",
        "TIME:19:48:03",
        "CALL:COMPLAINT FIRE INVESTIGATION",
        "ADDR:800 E SHAW ST",
        "INFO:EVERYONE IS OUTSIDE, REF EMS.");

    doTest("T11",
        "CAD:FYI: ;20110000482;09/15/2011 19:42:53;COMPLAINT FIRE INVESTIGATION;W FIVE POINT HWY/MATTHEWS RD;W OF MATTHEWS [09/15/11 19:43:57 KANTCLIFF] NE SIDE OF THE R",
        "ID:20110000482",
        "DATE:09/15/2011",
        "TIME:19:42:53",
        "CALL:COMPLAINT FIRE INVESTIGATION",
        "ADDR:W FIVE POINT HWY & MATTHEWS RD",
        "INFO:W OF MATTHEWS / NE SIDE OF THE R");

    doTest("T12",
        "CAD:FYI: ;20110000481;09/15/2011 08:19:47;COMMERCIAL FIRE ALARM;417 MAYNARD ST;BEEN GOING FOR 5 MINS. [09/15/11 08:21:10 MBIALKOWSKI] CLLR IN THE NORTH WING. GO",
        "ID:20110000481",
        "DATE:09/15/2011",
        "TIME:08:19:47",
        "CALL:COMMERCIAL FIRE ALARM",
        "ADDR:417 MAYNARD ST",
        "INFO:BEEN GOING FOR 5 MINS. / CLLR IN THE NORTH WING. GO");

    doTest("T13",
        "CAD:FYI: ;20110000480;09/14/2011 19:20:41;MISCELLANEOUS FIRE RUN;S PERKEY RD/E CLINTON TRL;Event spawned from MISCELLANEOUS INCIDENT. [09/14/2011 19:20:41 CYARG",
        "ID:20110000480",
        "DATE:09/14/2011",
        "TIME:19:20:41",
        "CALL:MISCELLANEOUS FIRE RUN",
        "ADDR:S PERKEY RD & E CLINTON TRL",
        "INFO:MISCELLANEOUS INCIDENT.");
  }
  
  @Test
  public void testEMSParser() {

    doTest("T1",
        "CAD:FYI: ;EEMS;20120003108;01/29/2012 01:17:26;PRIORTY3;7291 TUCKER RD;ERCY;70/F VOMITTING THE PAST 3-4 HRS [01/29/12 01:21:07 MLUNDQUIST]",
        "SRC:EEMS",
        "ID:20120003108",
        "DATE:01/29/2012",
        "TIME:01:17:26",
        "CALL:PRIORTY3",
        "ADDR:7291 TUCKER RD",  // Google says this is in Hamlin
        "CITY:EATON RAPIDS",
        "INFO:70/F VOMITTING THE PAST 3-4 HRS");
  }
  
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "CAD:FYI: ;DEMS;1202628;08/31/2012 10:10:01;TRAUMA;6971 W WILLOW HWY;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 30-A-2: NON-RECENT (??? 6hrs) injuries (without priority symptoms) 1. This happened more than 6hrs ago. 2. There is no blee\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202628",
        "DATE:08/31/2012",
        "TIME:10:10:01",
        "CALL:TRAUMA",
        "ADDR:6971 W WILLOW HWY",
        "CITY:LANSING",
        "PRI:3",
        "CODE:30-A-2",
        "INFO:NON-RECENT (??? 6hrs) injuries (without priority symptoms) 1. This happened more than 6hrs ago. 2. There is no blee");

    doTest("T2",
        "CAD:FYI: ;DEMS;1202629;08/31/2012 10:44:44;SICK;6333 LANSING RD;DLTA;60-year-old, male, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: FEELING DIZZY. [EMD] [08/31/12 10:46:31 RSTAHELIN]\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202629",
        "DATE:08/31/2012",
        "TIME:10:44:44",
        "CALL:SICK",
        "ADDR:6333 LANSING RD",
        "CITY:LANSING",
        "INFO:60-year-old, male, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: FEELING DIZZY.");

    doTest("T3",
        "CAD:FYI: ;DEMS;1202630;08/31/2012 11:10:16;SICK;422 ELMSHAVEN DR;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 26-A-4: Fever/chills 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He has other pain:\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202630",
        "DATE:08/31/2012",
        "TIME:11:10:16",
        "CALL:SICK",
        "ADDR:422 ELMSHAVEN DR",
        "CITY:LANSING",
        "PRI:3",
        "CODE:26-A-4",
        "INFO:Fever/chills 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He has other pain:");

    doTest("T4",
        "CAD:FYI: ;DEMS;1202631;08/31/2012 16:11:38;ALLERGY;6429 EARLINGTON LN;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 2-C-1: Difficulty breathing or swallowing 1. She has an allergic reaction. 2. She is completely alert (responding appropr\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202631",
        "DATE:08/31/2012",
        "TIME:16:11:38",
        "CALL:ALLERGY",
        "ADDR:6429 EARLINGTON LN",
        "CITY:LANSING",
        "PRI:1",
        "CODE:2-C-1",
        "INFO:Difficulty breathing or swallowing 1. She has an allergic reaction. 2. She is completely alert (responding appropr");

    doTest("T5",
        "CAD:FYI: ;DEMS;1202632;08/31/2012 18:30:37;FALLS;933-2 HARVEST LN;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 17-A-2: NON-RECENT (??? 6hrs) injuries (without priority symptoms) 1. This happened more than 6hrs ago. 2. It`s reported that\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202632",
        "DATE:08/31/2012",
        "TIME:18:30:37",
        "CALL:FALLS",
        "ADDR:933-2 HARVEST LN",
        "MADDR:933 HARVEST LN",
        "CITY:LANSING",
        "PRI:3",
        "CODE:17-A-2",
        "INFO:NON-RECENT (??? 6hrs) injuries (without priority symptoms) 1. This happened more than 6hrs ago. 2. It`s reported that");

    doTest("T6",
        "CAD:FYI: ;DEMS;1202633;08/31/2012 18:53:27;D I B;7324 PLAYERS CLUB DR;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 6-D-2: DIFFICULTY SPEAKING BETWEEN BREATHS 1. She is completely alert (responding appropriately). 2. She has difficulty s\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202633",
        "DATE:08/31/2012",
        "TIME:18:53:27",
        "CALL:D I B",
        "ADDR:7324 PLAYERS CLUB DR",
        "CITY:LANSING",
        "PRI:1",
        "CODE:6-D-2",
        "INFO:DIFFICULTY SPEAKING BETWEEN BREATHS 1. She is completely alert (responding appropriately). 2. She has difficulty s");

    doTest("T7",
        "CAD:FYI: ;DEMS;1202634;08/31/2012 21:53:34;CARDIAC;3301 S CREYTS RD;DLTA;20-year-old, male, not conscious, not breathing. Cardiac or Respiratory Arrest / Death Caller Statement: DIB. [EMD] [08/31/12 21:54:27 HDAWSON]\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202634",
        "DATE:08/31/2012",
        "TIME:21:53:34",
        "CALL:CARDIAC",
        "ADDR:3301 S CREYTS RD",
        "CITY:LANSING",
        "INFO:20-year-old, male, not conscious, not breathing. Cardiac or Respiratory Arrest / Death Caller Statement: DIB.");

    doTest("T8",
        "CAD:FYI: ;DEMS;1202634;08/31/2012 21:53:34;CARDIAC;3301 S CREYTS RD;DLTA;DOING RESCUE BREATHING [08/31/12 21:57:01 HDAWSON] NO DEFIB USED [08/31/12 21:56:57 HDAWSON] Key Questions Complete RESPONSE: ***PRIORITY 1*** Questions: 1. The cardia\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202634",
        "DATE:08/31/2012",
        "TIME:21:53:34",
        "CALL:CARDIAC",
        "ADDR:3301 S CREYTS RD",
        "CITY:LANSING",
        "PRI:1",
        "INFO:DOING RESCUE BREATHING / NO DEFIB USED / Key Questions Complete     1. The cardia");

    doTest("T9",
        "CAD:FYI: ;DEMS;1202635;09/01/2012 01:04:24;PSYCH;8460 W HOWE RD;EAGL;** Transfer from CLCD ** CLCD received: 09/01/2012 01:04:11 Source: PHONE Nature: SUICIDE/ATTEMPT/SUICIDAL SUBJ2 Call #: 429 Event Id: 12075216 Console: CAD4 Call Taker: 9\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202635",
        "DATE:09/01/2012",
        "TIME:01:04:24",
        "CALL:PSYCH",
        "ADDR:8460 W HOWE RD",
        "CITY:EAGLE",
        "INFO:** Transfer from CLCD ** CLCD received: 09/01/2012 01:04:11 Source: PHONE Nature: SUICIDE/ATTEMPT/SUICIDAL SUBJ2 Call #: 429 Event Id: 12075216 Console: CAD4 Call Taker: 9");

    doTest("T10",
        "CAD:FYI: ;DEMS;1202636;09/01/2012 04:43:00;CHEST;12857 CRESCENT DR;GDLG;RESPONSE: ***PRIORITY 1*** Questions: Code: 10-C-1: Abnormal breathing 1. He is completely alert (responding appropriately). 2. He is not breathing normally. 3. He does\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202636",
        "DATE:09/01/2012",
        "TIME:04:43:00",
        "CALL:CHEST",
        "ADDR:12857 CRESCENT DR", // Google cannot find
        "CITY:GRAND LEDGE",
        "PRI:1",
        "CODE:10-C-1",
        "INFO:Abnormal breathing 1. He is completely alert (responding appropriately). 2. He is not breathing normally. 3. He does");

    doTest("T11",
        "CAD:FYI: ;DEMS;1202637;09/01/2012 05:46:56;EMS PRIORITY 1;WI96/EI496 RAMP;Event spawned from MEDICAL ASSIST. [09/01/2012 05:46:56 RSTAHELIN] [LAW] CALLER IS SEMI DRIVER THAT STOPPED [09/01/12 05:46:53 ROWENS] Event spawned from PERSONAL INJ\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202637",
        "DATE:09/01/2012",
        "TIME:05:46:56",
        "CALL:EMS PRIORITY 1",
        "ADDR:WI96 & EI496 RAMP",
        "INFO:MEDICAL ASSIST. / CALLER IS SEMI DRIVER THAT STOPPED / PERSONAL INJ");

    doTest("T12",
        "CAD:FYI: ;DEMS;1202638;09/01/2012 05:59:41;SICK;1418 ELMWOOD RD;DLTA;81-year-old, female, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: HIGH FEVER. [EMD] [09/01/12 06:01:01 NBROWN] RESD- RITA KOLBERG TX 517 321684\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202638",
        "DATE:09/01/2012",
        "TIME:05:59:41",
        "CALL:SICK",
        "ADDR:1418 ELMWOOD RD",
        "CITY:LANSING",
        "INFO:81-year-old, female, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: HIGH FEVER. / RESD- RITA KOLBERG TX 517 321684");

    doTest("T13",
        "CAD:CANCEL;1418 ELMWOOD RD; DLTA\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "CALL:CANCEL",
        "ADDR:1418 ELMWOOD RD",
        "CITY:LANSING");

    doTest("T14",
        "CAD:FYI: ;DEMS;1202639;09/01/2012 10:05:39;CARDIAC;505 THEO AVE;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 9-E-1: Not breathing at all [EMD] [09/01/12 10:07:52 NBROWN] 59-year-old, male, not conscious, not breathing. Cardiac or Respir\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202639",
        "DATE:09/01/2012",
        "TIME:10:05:39",
        "CALL:CARDIAC",
        "ADDR:505 THEO AVE",
        "CITY:LANSING",
        "PRI:1",
        "CODE:9-E-1",
        "INFO:Not breathing at all / 59-year-old, male, not conscious, not breathing. Cardiac or Respir");

    doTest("T15",
        "CAD:FYI: ;DEMS;1202640;09/01/2012 14:56:02;SICK;4327 GLADYS DR;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 26-C-2: Abnormal breathing 1. She is completely alert (responding appropriately). 2. She is not breathing normally. 3. She has o\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202640",
        "DATE:09/01/2012",
        "TIME:14:56:02",
        "CALL:SICK",
        "ADDR:4327 GLADYS DR",
        "CITY:LANSING",
        "PRI:1",
        "CODE:26-C-2",
        "INFO:Abnormal breathing 1. She is completely alert (responding appropriately). 2. She is not breathing normally. 3. She has o");

    doTest("T16",
        "CAD:FYI: ;DEMS;1202641;09/01/2012 16:03:33;D I B;2006 ROCKDALE AVE;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 6-D-2: DIFFICULTY SPEAKING BETWEEN BREATHS 1. She is completely alert (responding appropriately). 2. She has difficulty spea\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202641",
        "DATE:09/01/2012",
        "TIME:16:03:33",
        "CALL:D I B",
        "ADDR:2006 ROCKDALE AVE",
        "CITY:LANSING",
        "PRI:1",
        "CODE:6-D-2",
        "INFO:DIFFICULTY SPEAKING BETWEEN BREATHS 1. She is completely alert (responding appropriately). 2. She has difficulty spea");

    doTest("T17",
        "CAD:FYI: ;DFD;09/01/2012 16:47:41;MANPOWER;811 N CANAL RD\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DFD",
        "DATE:09/01/2012",
        "TIME:16:47:41",
        "CALL:MANPOWER",
        "ADDR:811 N CANAL RD");

    doTest("T18",
        "CAD:FYI: ;DFD;1251125;09/01/2012 16:47:41;MANPOWER;811 N CANAL RD\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DFD",
        "ID:1251125",
        "DATE:09/01/2012",
        "TIME:16:47:41",
        "CALL:MANPOWER",
        "ADDR:811 N CANAL RD");

    doTest("T19",
        "CAD:FYI: ;DEMS;09/01/2012 19:23:33;ACCIDENT;15427 W GRAND RIVER HWY;EAGL;{FROM CLCD: SUBJ TRIED TO PASS THE TRUCK CAME UP ON CALLER COMING OTHER DIRECTION, AND SWERVED BACK OVER AND HIT TRUCK [09/01/12 19:24:58 926A]} [09/01/12 19:24:59 TRA\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "DATE:09/01/2012",
        "TIME:19:23:33",
        "CALL:ACCIDENT",
        "ADDR:15427 W GRAND RIVER HWY",
        "CITY:EAGLE",
        "INFO:{FROM CLCD: SUBJ TRIED TO PASS THE TRUCK CAME UP ON CALLER COMING OTHER DIRECTION, AND SWERVED BACK OVER AND HIT TRUCK / }");

    doTest("T20",
        "CAD:FYI: ;DEMS;1202643;09/01/2012 21:31:02;CHEST;5712-3 PEMBROOK PL;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 10-A-1: Breathing normally < 35 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He is\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202643",
        "DATE:09/01/2012",
        "TIME:21:31:02",
        "CALL:CHEST",
        "ADDR:5712-3 PEMBROOK PL",
        "MADDR:5712 PEMBROOK PL",
        "CITY:LANSING",
        "PRI:3",
        "CODE:10-A-1",
        "INFO:Breathing normally < 35 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He is");

    doTest("T21",
        "CAD:FYI: ;DEMS;1202644;09/01/2012 22:14:04;SICK;3023 SNOW RD;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 26-A-4: Fever/chills 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He has other pain: EVER\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202644",
        "DATE:09/01/2012",
        "TIME:22:14:04",
        "CALL:SICK",
        "ADDR:3023 SNOW RD",
        "CITY:LANSING",
        "PRI:3",
        "CODE:26-A-4",
        "INFO:Fever/chills 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He has other pain: EVER");

    doTest("T22",
        "CAD:FYI: ;DEMS;1202645;09/01/2012 22:42:27;SICK;4820 GULL RD;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 26-C-1: ALTERED LEVEL OF CONSCIOUSNESS 1. He is lethargic. 2. He is not breathing normally. 3. He has other pain: HEAD PAIN, RECEN\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202645",
        "DATE:09/01/2012",
        "TIME:22:42:27",
        "CALL:SICK",
        "ADDR:4820 GULL RD",
        "CITY:LANSING",
        "PRI:1",
        "CODE:26-C-1",
        "INFO:ALTERED LEVEL OF CONSCIOUSNESS 1. He is lethargic. 2. He is not breathing normally. 3. He has other pain: HEAD PAIN, RECEN");

    doTest("T23",
        "CAD:FYI: ;DEMS;1202646;09/02/2012 04:26:17;EMS PRIORITY 2;300-H3 PARKWEST CT;Event spawned from DOMESTIC DISPUTE. [09/02/2012 04:26:17 JBAKER] REQ EMS [09/02/12 04:26:13 JBAKER] AT LEAST 4 PEOPLE THERE [09/02/12 04:26:05 JBAKER] EVERYONE HA\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202646",
        "DATE:09/02/2012",
        "TIME:04:26:17",
        "CALL:EMS PRIORITY 2",
        "ADDR:300-H3 PARKWEST CT",
        "MADDR:300 PARKWEST CT",
        "INFO:DOMESTIC DISPUTE. / REQ EMS / AT LEAST 4 PEOPLE THERE / EVERYONE HA");

    doTest("T24",
        "CAD:FYI: ;DEMS;1202647;09/02/2012 04:40:29;D I B;5011 W WILLOW HWY;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 6-D-2: DIFFICULTY SPEAKING BETWEEN BREATHS 1. It`s not certain if he is completely alert (responding appropriately). 2. He h\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202647",
        "DATE:09/02/2012",
        "TIME:04:40:29",
        "CALL:D I B",
        "ADDR:5011 W WILLOW HWY",
        "CITY:LANSING",
        "PRI:1",
        "CODE:6-D-2",
        "INFO:DIFFICULTY SPEAKING BETWEEN BREATHS 1. It`s not certain if he is completely alert (responding appropriately). 2. He h");

    doTest("T25",
        "CAD:FYI: ;DEMS;1202648;09/02/2012 06:31:18;FALLS;4601 NORWICK ST;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 17-A-3-G: PUBLIC ASSIST (no injuries and no priority symptoms) (On the ground or floor) 5. He is completely alert (responding\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202648",
        "DATE:09/02/2012",
        "TIME:06:31:18",
        "CALL:FALLS",
        "ADDR:4601 NORWICK ST",
        "CITY:LANSING",
        "PRI:3",
        "CODE:17-A-3-G",
        "INFO:PUBLIC ASSIST (no injuries and no priority symptoms) (On the ground or floor) 5. He is completely alert (responding");

    doTest("T26",
        "CAD:FYI: ;DEMS;1202649;09/02/2012 10:44:02;EMS PRIORITY 3;10825 CANTERBURY LN;Event spawned from DISORDERLY PERSON OR SUBJECT. [09/02/2012 10:44:02 RTHACKER] (D3A) EMS [09/02/12 10:43:53 RTHACKER] ONE UNDER ... OPEN AIR [09/02/12 10:43:41 R\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202649",
        "DATE:09/02/2012",
        "TIME:10:44:02",
        "CALL:EMS PRIORITY 3",
        "ADDR:10825 CANTERBURY LN",
        "INFO:DISORDERLY PERSON OR SUBJECT. / (D3A) EMS / ONE UNDER ... OPEN AIR");

    doTest("T27",
        "CAD:Update: ;OOAE;1202649;09/02/2012 10:44:02;EMS PRIORITY 3;7639 WALDON;7639 WILDON [09/02/12 10:44:27 RTHACKER] Event spawned from DISORDERLY PERSON OR SUBJECT. [09/02/2012 10:44:02 RTHACKER] (D3A) EMS [09/02/12 10:43:53 RTHACKER] ONE UND\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:OOAE",
        "ID:1202649",
        "DATE:09/02/2012",
        "TIME:10:44:02",
        "CALL:EMS PRIORITY 3",
        "ADDR:7639 WALDON",
        "INFO:7639 WILDON / DISORDERLY PERSON OR SUBJECT. / (D3A) EMS / ONE UND");

    doTest("T28",
        "CAD:Update: ;DEMS;1202649;09/02/2012 10:44:02;EMS PRIORITY 3;7641-BLK WILDON WAY;7639 WILDON [09/02/12 10:44:27 RTHACKER] Event spawned from DISORDERLY PERSON OR SUBJECT. [09/02/2012 10:44:02 RTHACKER] (D3A) EMS [09/02/12 10:43:53 RTHACKER]\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202649",
        "DATE:09/02/2012",
        "TIME:10:44:02",
        "CALL:EMS PRIORITY 3",
        "ADDR:7641-BLK WILDON WAY",
        "MADDR:7641 WILDON WAY",
        "INFO:7639 WILDON / DISORDERLY PERSON OR SUBJECT. / (D3A) EMS");

    doTest("T29",
        "CAD:FYI: ;DEMS;1202650;09/02/2012 15:18:09;EMS PRIORITY 3;811 N CANAL RD\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202650",
        "DATE:09/02/2012",
        "TIME:15:18:09",
        "CALL:EMS PRIORITY 3",
        "ADDR:811 N CANAL RD");

    doTest("T30",
        "CAD:FYI: ;DEMS;1202651;09/02/2012 20:49:48;SEIZURES;7611-2 HERITAGE DR;DLTA;5-year-old, male, conscious, breathing. Convulsions / Seizures Caller Statement: SEIZURE FEVER. [EMD] [09/02/12 20:51:17 CMASON]\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202651",
        "DATE:09/02/2012",
        "TIME:20:49:48",
        "CALL:SEIZURES",
        "ADDR:7611-2 HERITAGE DR",
        "MADDR:7611 HERITAGE DR",
        "CITY:LANSING",
        "INFO:5-year-old, male, conscious, breathing. Convulsions / Seizures Caller Statement: SEIZURE FEVER.");

    doTest("T31",
        "CAD:FYI: ;DEMS;1202652;09/02/2012 20:55:43;ABD PAIN;5719 W SAGINAW HWY;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 1-C-6: Females with pain above navel ??? 45 1. She is completely alert (responding appropriately). 2. There was no menti\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202652",
        "DATE:09/02/2012",
        "TIME:20:55:43",
        "CALL:ABD PAIN",
        "ADDR:5719 W SAGINAW HWY",
        "CITY:LANSING",
        "PRI:1",
        "CODE:1-C-6",
        "INFO:Females with pain above navel ??? 45 1. She is completely alert (responding appropriately). 2. There was no menti");

    doTest("T32",
        "CAD:FYI: ;DEMS;1202653;09/02/2012 21:08:34;UNCONS;6429 EARLINGTON LN;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Unconscious / Fainting (Near) Code: 31-C-1: Alert with abnormal breathing 1. This happened now (less than 6hrs ago). 2. It`s rep\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202653",
        "DATE:09/02/2012",
        "TIME:21:08:34",
        "CALL:UNCONS",
        "ADDR:6429 EARLINGTON LN",
        "CITY:LANSING",
        "PRI:1",
        "CODE:31-C-1",
        "INFO:Unconscious / Fainting (Near)   Alert with abnormal breathing 1. This happened now (less than 6hrs ago). 2. It`s rep");

    doTest("T33",
        "CAD:FYI: ;DEMS;1202654;09/03/2012 06:45:12;EMS PRIORITY 1;209-D FALLS CT;female just home from the hospital earlier this morning unk problem [09/03/12 06:46:07 DBEACHNAU]\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202654",
        "DATE:09/03/2012",
        "TIME:06:45:12",
        "CALL:EMS PRIORITY 1",
        "ADDR:209-D FALLS CT",
        "MADDR:209 FALLS CT",
        "INFO:female just home from the hospital earlier this morning unk problem");

    doTest("T34",
        "CAD:FYI: ;DEMS;1202655;09/03/2012 07:23:52;BLEEDING;201-14 MALL DRIVE SOUTH;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 21-D-3: DANGEROUS hemorrhage 1. The cause of the bleeding is non-traumatic. 2. The bleeding is from a DANGEROUS are\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202655",
        "DATE:09/03/2012",
        "TIME:07:23:52",
        "CALL:BLEEDING",
        "ADDR:201-14 MALL DRIVE SOUTH",
        "MADDR:201 MALL DRIVE SOUTH",
        "CITY:LANSING",
        "PRI:1",
        "CODE:21-D-3",
        "INFO:DANGEROUS hemorrhage 1. The cause of the bleeding is non-traumatic. 2. The bleeding is from a DANGEROUS are");

    doTest("T35",
        "CAD:FYI: ;DEMS;1202656;09/03/2012 07:43:24;CHEST;3301 S CREYTS RD;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 10-D-4: Clammy 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. It`s not known if he is\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202656",
        "DATE:09/03/2012",
        "TIME:07:43:24",
        "CALL:CHEST",
        "ADDR:3301 S CREYTS RD",
        "CITY:LANSING",
        "PRI:1",
        "CODE:10-D-4",
        "INFO:Clammy 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. It`s not known if he is");

    doTest("T36",
        "CAD:FYI: ;DEMS;1202657;09/03/2012 12:35:21;EMS PRIORITY 1;209-D FALLS CT;Event spawned from UNKNOWN PROBLEM. [09/03/2012 12:35:21 MBIALKOWSKI] CLLR HAS BEEN IN HOSPITAL RECENTLY. [09/03/12 12:14:49 MBIALKOWSKI] HE THREATENED TO BEAT SOMEONE\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202657",
        "DATE:09/03/2012",
        "TIME:12:35:21",
        "CALL:EMS PRIORITY 1",
        "ADDR:209-D FALLS CT",
        "MADDR:209 FALLS CT",
        "INFO:UNKNOWN PROBLEM. / CLLR HAS BEEN IN HOSPITAL RECENTLY. / HE THREATENED TO BEAT SOMEONE");

    doTest("T37",
        "CAD:FYI: ;DEMS;1202658;09/03/2012 13:34:41;SICK;933 N WAVERLY RD;DLTA;73-year-old, female, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: FEMALE ABOUT TO PASS OUT, DIABETIC (BS246). [EMD] [09/03/12 13:35:22 DBEACHN\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202658",
        "DATE:09/03/2012",
        "TIME:13:34:41",
        "CALL:SICK",
        "ADDR:933 N WAVERLY RD",
        "CITY:LANSING",
        "INFO:73-year-old, female, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: FEMALE ABOUT TO PASS OUT, DIABETIC (BS246).");

    doTest("T38",
        "CAD:FYI: ;DEMS;1202659;09/03/2012 16:50:05;EMS PRIORITY 2;W SAGINAW HWY/N CANAL RD;W OF [09/03/12 16:50:13 SVANZILE]\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202659",
        "DATE:09/03/2012",
        "TIME:16:50:05",
        "CALL:EMS PRIORITY 2",
        "ADDR:W SAGINAW HWY & N CANAL RD",
        "INFO:W OF");

    doTest("T39",
        "CAD:FYI: ;DEMS;1202660;09/03/2012 17:37:07;SICK;1115 BOULDER CT;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 26-A-1: No priority symptoms (complaint conditions 2???11 not identified) 1. She is completely alert (responding appropriately)\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202660",
        "DATE:09/03/2012",
        "TIME:17:37:07",
        "CALL:SICK",
        "ADDR:1115 BOULDER CT",
        "CITY:LANSING",
        "PRI:3",
        "CODE:26-A-1",
        "INFO:No priority symptoms (complaint conditions 2???11 not identified) 1. She is completely alert (responding appropriately)");

    doTest("T40",
        "CAD:FYI: ;DEMS;1202661;09/04/2012 00:09:55;ABD PAIN;810 DELTA COMMERCE DR;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 1-C-4: Females with fainting or near fainting 12???50 1. She is completely alert (responding appropriately). 2. There\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202661",
        "DATE:09/04/2012",
        "TIME:00:09:55",
        "CALL:ABD PAIN",
        "ADDR:810 DELTA COMMERCE DR",
        "CITY:LANSING",
        "PRI:1",
        "CODE:1-C-4",
        "INFO:Females with fainting or near fainting 12???50 1. She is completely alert (responding appropriately). 2. There");

    doTest("T41",
        "CAD:Update: ;DEMS;1202661;09/04/2012 00:09:55;ABD PAIN;810-121 DELTA COMMERCE DR;DLTA;PT IS IN ROOM 121 [09/04/12 00:12:45 FROBINSON] RESPONSE: ***PRIORITY 1*** Questions: Code: 1-C-4: Females with fainting or near fainting 12???50 1. She i\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202661",
        "DATE:09/04/2012",
        "TIME:00:09:55",
        "CALL:ABD PAIN",
        "ADDR:810-121 DELTA COMMERCE DR",
        "MADDR:810 DELTA COMMERCE DR",
        "CITY:LANSING",
        "PRI:1",
        "CODE:1-C-4",
        "INFO:PT IS IN ROOM 121 / Females with fainting or near fainting 12???50 1. She i");

    doTest("T42",
        "CAD:FYI: ;DEMS;1202662;09/04/2012 04:39:59;HEART;1121 DURANGO;DLTA;18-year-old, female, conscious, breathing. Heart Problems / A.I.C.D. Caller Statement: POSS HEART . [EMD] [09/04/12 04:40:37 FROBINSON]\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202662",
        "DATE:09/04/2012",
        "TIME:04:39:59",
        "CALL:HEART",
        "ADDR:1121 DURANGO",
        "CITY:LANSING",
        "INFO:18-year-old, female, conscious, breathing. Heart Problems / A.I.C.D. Caller Statement: POSS HEART .");

    doTest("T43",
        "CAD:FYI: ;DEMS;1202663;09/04/2012 11:10:46;SICK;2224 ROCKDALE AVE;DLTA;87-year-old, female, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: WEAKNESS, NUMBNESS . [EMD] [09/04/12 11:12:04 JOSTERMAN] REQ NO LIGHTS/SIRE\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202663",
        "DATE:09/04/2012",
        "TIME:11:10:46",
        "CALL:SICK",
        "ADDR:2224 ROCKDALE AVE",
        "CITY:LANSING",
        "INFO:87-year-old, female, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: WEAKNESS, NUMBNESS . / REQ NO LIGHTS/SIRE");

    doTest("T44",
        "CAD:FYI: ;DEMS;09/04/2012 12:53:10;EMS PRIORITY 1;3020 N WAVERLY RD;Aborted by Medical Priority with code: MUTUAL AID REQUEST [EMD] [09/04/12 12:54:28 MBIALKOWSKI] 44 YR OLD FEMALE, CAN`T STAND OR MOVE HER LEG. REQ FOR MUTUAL AID AMB. LFD S\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "DATE:09/04/2012",
        "TIME:12:53:10",
        "CALL:EMS PRIORITY 1",
        "ADDR:3020 N WAVERLY RD",
        "INFO:MUTUAL AID REQUEST / 44 YR OLD FEMALE, CAN`T STAND OR MOVE HER LEG. REQ FOR MUTUAL AID AMB. LFD S");

    doTest("T45",
        "CAD:FYI: ;DEMS;1202664;09/04/2012 13:11:22;EMS PRIORITY 3;5303-316 IVAN DR;Aborted by Medical Priority with code: 1. Caller hung up [EMD] [09/04/12 13:12:31 JOSTERMAN] res: UNKNWN TX: 323 2800 MEDICAL ALARM - NO INFO AVAIL WILL CONTACT KH [\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202664",
        "DATE:09/04/2012",
        "TIME:13:11:22",
        "CALL:EMS PRIORITY 3",
        "ADDR:5303-316 IVAN DR",
        "MADDR:5303 IVAN DR",
        "INFO:1. Caller hung up / res: UNKNWN TX: 323 2800 MEDICAL ALARM - NO INFO AVAIL WILL CONTACT KH");

    doTest("T46",
        "CAD:FYI: ;DEMS;1202665;09/04/2012 13:19:39;EMS PRIORITY 3;220 GATEWOOD DR;Event spawned from COMMERCIAL FIRE ALARM. [09/04/2012 13:19:39 SVANZILE] TONED ALL CALL 13:18 [09/04/12 13:18:54 SVANZILE] (401) REQ ALL CALL [09/04/12 13:18:34 SVANZ\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202665",
        "DATE:09/04/2012",
        "TIME:13:19:39",
        "CALL:EMS PRIORITY 3",
        "ADDR:220 GATEWOOD DR",
        "INFO:COMMERCIAL FIRE ALARM. / TONED ALL CALL 13:18 / (401) REQ ALL CALL");

    doTest("T47",
        "CAD:FYI: ;DEMS;1202666;09/04/2012 13:31:45;FALLS;5617 W SAGINAW HWY;DLTA;RESPONSE: ***PRIORITY 3*** Questions: Code: 17-A-1-G: NOT DANGEROUS body area (On the ground or floor) 1. This happened now (less than 6hrs ago). 2. It`s reported that\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202666",
        "DATE:09/04/2012",
        "TIME:13:31:45",
        "CALL:FALLS",
        "ADDR:5617 W SAGINAW HWY",
        "CITY:LANSING",
        "PRI:3",
        "CODE:17-A-1-G",
        "INFO:NOT DANGEROUS body area (On the ground or floor) 1. This happened now (less than 6hrs ago). 2. It`s reported that");

    doTest("T48",
        "CAD:FYI: ;DEMS;1202668;09/04/2012 14:00:26;EMS PRIORITY 1;1134 MUNICIPAL WAY;36-year-old, female, conscious, breathing. Unconscious / Fainting (Near) Caller Statement: FEMALE 36 Y/O - SLOW TO RESPONSIVE, NUMB. [EMD] [09/04/12 14:01:35 DBEAC\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202668",
        "DATE:09/04/2012",
        "TIME:14:00:26",
        "CALL:EMS PRIORITY 1",
        "ADDR:1134 MUNICIPAL WAY",
        "INFO:36-year-old, female, conscious, breathing. Unconscious / Fainting (Near) Caller Statement: FEMALE 36 Y/O - SLOW TO RESPONSIVE, NUMB.");

    doTest("T49",
        "CAD:FYI: ;DEMS;1202669;09/04/2012 14:15:23;ABD PAIN;4383 W CUTLER RD;DEWT;** Transfer from CLCD ** CLCD received: 09/04/2012 14:12:04 Source: PHONE Nature: ABDOMINAL PAIN/PROBLEMS 2 Call #: 506 Event Id: 12076273 Console: CAD3 Call Taker: 9\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202669",
        "DATE:09/04/2012",
        "TIME:14:15:23",
        "CALL:ABD PAIN",
        "ADDR:4383 W CUTLER RD",
        "CITY:DEWITT",
        "INFO:** Transfer from CLCD ** CLCD received: 09/04/2012 14:12:04 Source: PHONE Nature: ABDOMINAL PAIN/PROBLEMS 2 Call #: 506 Event Id: 12076273 Console: CAD3 Call Taker: 9");

    doTest("T50",
        "CAD:CANCEL;4383 W CUTLER RD; DEWT\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "CALL:CANCEL",
        "ADDR:4383 W CUTLER RD",
        "CITY:DEWITT");

    doTest("T51",
        "CAD:FYI: ;DEMS;1202669;09/04/2012 14:15:23;ABD PAIN;4383 W CUTLER RD;DEWT;{FROM CLCD: Closed event with disposition [CN]} [09/04/12 14:38:57 TRANSFER] {FROM CLCD: STOMACHE PAIN ALSO [09/04/12 14:16:39 922B]} [09/04/12 14:16:40 TRANSFER] **\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202669",
        "DATE:09/04/2012",
        "TIME:14:15:23",
        "CALL:ABD PAIN",
        "ADDR:4383 W CUTLER RD",
        "CITY:DEWITT",
        "INFO:{FROM CLCD: Closed event with disposition / } / {FROM CLCD: STOMACHE PAIN ALSO / } / **");

    doTest("T52",
        "CAD:FYI: ;DEMS;1202671;09/04/2012 15:36:06;EMS PRIORITY 2;S WAVERLY RD/MOORES RIVER DR;Event spawned from UNKNOWN ACCIDENT. [09/04/2012 15:36:06 SVANZILE] LPD DISPATCH SAYS THEY HAVE IT AT GLASGOW -- [09/04/12 15:35:05 JOSTERMAN] SB LANE EQ\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202671",
        "DATE:09/04/2012",
        "TIME:15:36:06",
        "CALL:EMS PRIORITY 2",
        "ADDR:S WAVERLY RD & MOORES RIVER DR",
        "INFO:UNKNOWN ACCIDENT. / LPD DISPATCH SAYS THEY HAVE IT AT GLASGOW -- / SB LANE EQ");

    doTest("T53",
        "CAD:FYI: ;DEMS;1202672;09/04/2012 16:13:57;CARDIAC;5020 W SAGINAW HWY;DLTA;62-year-old, male, not conscious, breathing status uncertain. Cardiac or Respiratory Arrest / Death Caller Statement: SUBJ PASSED OUT, FELL ON THE SEAT. [EMD] [09/04\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202672",
        "DATE:09/04/2012",
        "TIME:16:13:57",
        "CALL:CARDIAC",
        "ADDR:5020 W SAGINAW HWY",
        "CITY:LANSING",
        "INFO:62-year-old, male, not conscious, breathing status uncertain. Cardiac or Respiratory Arrest / Death Caller Statement: SUBJ PASSED OUT, FELL ON THE SEAT.");

    doTest("T54",
        "CAD:FYI: ;DEMS;1202673;09/04/2012 16:58:53;SICK;14294 W HOWE RD;PORT;** Transfer from CLCD ** CLCD received: 09/04/2012 16:57:07 Source: W911 Nature: SICK PERSON/NON-SPECIFIC 4 Call #: 558 Event Id: 12076323 Console: CAD1 Call Taker: 910E N\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202673",
        "DATE:09/04/2012",
        "TIME:16:58:53",
        "CALL:SICK",
        "ADDR:14294 W HOWE RD",
        "CITY:PORTLAND",
        "INFO:** Transfer from CLCD ** CLCD received: 09/04/2012 16:57:07 Source: W911 Nature: SICK PERSON/NON-SPECIFIC 4 Call #: 558 Event Id: 12076323 Console: CAD1 Call Taker: 910E N");

    doTest("T55",
        "CAD:FYI: ;DEMS;1202674;09/04/2012 21:28:45;ALLERGY;320-S3 PARKWOOD DR;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 2-D-2: DIFFICULTY SPEAKING BETWEEN BREATHS 1. He has an allergic reaction. 2. He is completely alert (responding appropri\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202674",
        "DATE:09/04/2012",
        "TIME:21:28:45",
        "CALL:ALLERGY",
        "ADDR:320-S3 PARKWOOD DR",
        "MADDR:320 PARKWOOD DR",
        "CITY:LANSING",
        "PRI:1",
        "CODE:2-D-2",
        "INFO:DIFFICULTY SPEAKING BETWEEN BREATHS 1. He has an allergic reaction. 2. He is completely alert (responding appropri");

    doTest("T56",
        "CAD:FYI: ;DEMS;1202675;09/04/2012 22:11:42;CHEST;5640 PIERSON HWY;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 10-D-4: Clammy 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He is not changing color\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202675",
        "DATE:09/04/2012",
        "TIME:22:11:42",
        "CALL:CHEST",
        "ADDR:5640 PIERSON HWY",
        "CITY:LANSING",
        "PRI:1",
        "CODE:10-D-4",
        "INFO:Clammy 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He is not changing color");

    doTest("T57",
        "CAD:FYI: ;DEMS;1202676;09/04/2012 23:13:26;D I B;4911 MALPASO;DLTA;RESPONSE: ***PRIORITY 1*** Questions: Code: 6-C-1: Abnormal breathing 1. She is completely alert (responding appropriately). 2. She does not have any difficulty speaking bet\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:DEMS",
        "ID:1202676",
        "DATE:09/04/2012",
        "TIME:23:13:26",
        "CALL:D I B",
        "ADDR:4911 MALPASO",
        "CITY:LANSING",
        "PRI:1",
        "CODE:6-C-1",
        "INFO:Abnormal breathing 1. She is completely alert (responding appropriately). 2. She does not have any difficulty speaking bet");

    doTest("T58",
        "CAD:FYI: ;DEMS;09/05/2012 00:05:56;EMS PRIORITY 1;3900 LAUDERHILL CIR;Aborted by Medical Priority with code: REQ FROM LPD [EMD] [09/05/12 00:07:48 MLUNDQUIST] THEY HAVE AN ENGINE ERNT [09/05/12 00:07:25 MLUNDQUIST] REQ EMS FROM DELTA 63/M D\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses. ",

        "SRC:DEMS",
        "DATE:09/05/2012",
        "TIME:00:05:56",
        "CALL:EMS PRIORITY 1",
        "ADDR:3900 LAUDERHILL CIR",
        "INFO:REQ FROM LPD / THEY HAVE AN ENGINE ERNT / REQ EMS FROM DELTA 63/M D");

  }
  
  @Test
  public void testCharlotteFireDept() {

    doTest("T1",
        "CAD:FYI: ;MISCELLANEOUS FIRE RUN;1399 PORTER DR;ANGEL CT;TIRRELL RD;NO TONE, FOR AN INVESTIGATION [08/07/2013 08:48:27 LWOODS]\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "CALL:MISCELLANEOUS FIRE RUN",
        "ADDR:1399 PORTER DR",  // Not mapping
        "X:ANGEL CT & TIRRELL RD",
        "INFO:NO TONE, FOR AN INVESTIGATION",
        "DATE:08/07/2013",
        "TIME:08:48:27");

    doTest("T2",
        "CAD:FYI: ;MEDICAL ASSIST;230 N LINCOLN ST;N BONNIE BROOK DR;W STODDARD ST;Event spawned from FALLS. [08/06/2013 13:37:22 MBIALKOWSKI] 70-year-old, male, conscious, breathing. Falls Caller Statement: FATHER FELL AND HIT HIS HEAD. IS UNCONSCI\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "CALL:MEDICAL ASSIST",
        "ADDR:230 N LINCOLN ST",
        "X:N BONNIE BROOK DR & W STODDARD ST",
        "INFO:FALLS. / 70-year-old, male, conscious, breathing. Falls Caller Statement: FATHER FELL AND HIT HIS HEAD. IS UNCONSCI",
        "DATE:08/06/2013",
        "TIME:13:37:22");

    doTest("T3",
        "CAD:Update: ;EAMS;08/04/2013 20:34:10;EMS STANDBY;209 BEECH ST;CHAR;OVEN FIRE [08/04/13 20:33:12 CMASON] [FIRE] EVERYONE HAS BEEN TOLD TO LEAVE THE HOUSE [08/04/13 20:34:28 CMASON]\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:EAMS",
        "DATE:08/04/2013",
        "TIME:20:34:10",
        "CALL:EMS STANDBY",
        "ADDR:209 BEECH ST",
        "CITY:CHARLOTTE",
        "INFO:OVEN FIRE / EVERYONE HAS BEEN TOLD TO LEAVE THE HOUSE");

    doTest("T4",
        "CAD:FYI: ;CFD;20130000375;08/04/2013 20:32:40;LARGE STRUCTURE FIRE;209 BEECH ST;CHAR;OVEN FIRE [08/04/13 20:33:12 CMASON]\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:CFD",
        "ID:20130000375",
        "DATE:08/04/2013",
        "TIME:20:32:40",
        "CALL:LARGE STRUCTURE FIRE",
        "ADDR:209 BEECH ST",
        "CITY:CHARLOTTE",
        "INFO:OVEN FIRE");

    doTest("T5",
        "CAD:FYI: ;CFD;20130000374;08/03/2013 16:55:13;MEDICAL ASSIST;530 BEECH ST;CHAR;Event spawned from BREATHING PROBLEMS. [08/03/2013 16:55:13 NBROWN] 90-year-old, female, conscious, breathing. Breathing Problems Caller Statement: DIB WAS CHOKI\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:CFD",
        "ID:20130000374",
        "DATE:08/03/2013",
        "TIME:16:55:13",
        "CALL:MEDICAL ASSIST",
        "ADDR:530 BEECH ST",
        "CITY:CHARLOTTE",
        "INFO:BREATHING PROBLEMS. / 90-year-old, female, conscious, breathing. Breathing Problems Caller Statement: DIB WAS CHOKI");

    doTest("T6",
        "CAD:FYI: ;CFD;20130000373;08/03/2013 16:04:40;VEHICLE FIRE;SI69/E CLINTON TRL;CHAR;SEMI THAT IS ON FIRE, HEAVY SMOKE FROM THE UNDER THE TRAILER, [08/03/13 16:05:38 NBROWN] N OF M50 [08/03/13 16:05:58 NBROWN]\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:CFD",
        "ID:20130000373",
        "DATE:08/03/2013",
        "TIME:16:04:40",
        "CALL:VEHICLE FIRE",
        "ADDR:SI69 & E CLINTON TRL",
        "CITY:CHARLOTTE",
        "INFO:SEMI THAT IS ON FIRE, HEAVY SMOKE FROM THE UNDER THE TRAILER, / N OF M50");

    doTest("T7",
        "CAD:FYI: ;CFD;20130000372;08/03/2013 15:47:47;HEAVY RESCUE;59 SI69;CHAR;Event spawned from TRAFFIC/TRANSPORTATION ACCIDEN. [08/03/2013 15:47:47 NBROWN] Event spawned from UNKNOWN ACCIDENT. [08/03/2013 15:46:25 NBROWN] CROSS ENTIRE HW FROM N\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:CFD",
        "ID:20130000372",
        "DATE:08/03/2013",
        "TIME:15:47:47",
        "CALL:HEAVY RESCUE",
        "ADDR:59 SI69",
        "CITY:CHARLOTTE",
        "INFO:TRAFFIC/TRANSPORTATION ACCIDEN. / UNKNOWN ACCIDENT. / CROSS ENTIRE HW FROM N");

    doTest("T8",
        "CAD:CANCEL;1385 GIDNER RD; CHAR\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "CALL:CANCEL",
        "ADDR:1385 GIDNER RD",
        "CITY:CHARLOTTE");

    doTest("T9",
        "CAD:FYI: ;CFD;20130000371;08/03/2013 10:11:40;MEDICAL ASSIST;1385 GIDNER RD;CHAR;Event spawned from SICK PERSON. [08/03/2013 10:11:40 RSTAHELIN] 90-year-old, male, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: POS\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:CFD",
        "ID:20130000371",
        "DATE:08/03/2013",
        "TIME:10:11:40",
        "CALL:MEDICAL ASSIST",
        "ADDR:1385 GIDNER RD",
        "CITY:CHARLOTTE",
        "INFO:SICK PERSON. / 90-year-old, male, conscious, breathing. Sick Person (Specific Diagnosis) Caller Statement: POS");

    doTest("T10",
        "CAD:FYI: ;CFD;20130000370;08/03/2013 09:19:44;MEDICAL ASSIST;500 MEIJER ST;CHAR;Event spawned from PSYCHIATRIC/ABNORMAL BEHAVIOR. [08/03/2013 09:19:44 NBROWN] Event spawned from SUICIDAL THRT OR ATTEMPT. [08/03/2013 09:18:08 RSTAHELIN] 47 Y\n\n\n\n" +
        "This email, including any attachment(s) to it are intended solely for the use of the individual or entity to which it is addressed. If you have received this email in error please notify Eaton County by replying to the original email and deleting any email(s) or attachment(s) that you have received. Eaton County screens all outgoing email and attachment(s) for viruses; however, Eaton County cannot accept liability for any damage caused by any virus transmitted by this email. The recipient should check this email and any attachment(s) for the presence of viruses.",

        "SRC:CFD",
        "ID:20130000370",
        "DATE:08/03/2013",
        "TIME:09:19:44",
        "CALL:MEDICAL ASSIST",
        "ADDR:500 MEIJER ST",
        "CITY:CHARLOTTE",
        "INFO:PSYCHIATRIC/ABNORMAL BEHAVIOR. / SUICIDAL THRT OR ATTEMPT. / 47 Y");

  }
  
  public static void main(String[] args) {
    new MIEatonCountyParserTest().generateTests("T1");
  }
}
