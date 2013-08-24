package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Adams County, PA
Contact: Tim Tyler <tyler33fire@yahoo.com>
Contact: Randy Wolf <rmwolf2005@gmail.com>
Contact: Kip Hamilton <kip.vmi.77@gmail.com>
Sender: alert@adams911.com

Subject:Alert: Traffic Accident - 1\nALRM LVL: 1\nLOC:\n274 HANOVER ST\nOXFORD TWP\nBTWN: COMMERCE ST & TROUT LN
Subject:Alert: Fire - Residential\nALRM LVL: 1\nLOC:\n80 HUNTER CIR\nHAMILTON TWP\nBTWN: FOX DEN LN & FOX MEADOW
Subject:Alert: Diabetic Emergency - 1\nALRM LVL: 1\nLOC:\nLINCOLNWAY W/TRACY AVE\nNEW OXFORD BORO\nBTWN: TRACY AVE & KOHLER MILL RD
Subject:Alert: Traffic Accident - 2\nALRM LVL: 1\nLOC:\nYORK RD/FLESHMAN MILL RD\nMOUNT PLEASANT TWP\nBTWN: FLESHMAN MILL RD
Subject:Alert: Fire - Residential\nALRM LVL: 1\nLOC:\n2315 HUNTERSTOWN-HAMPTON RD\nSTRABAN TWP\nBTWN: ALLEY & CONEWAGO RD
Subject:Alert: Traffic Accident - 2\nALRM LVL: 1\nLOC:\n760 NEW CHESTER RD\nSTRABAN TWP\nBTWN: SWIFT RUN RD & BRICKCRAFTERS RD
Subject:Alert: Fire - Brush / Wildland\nALRM LVL: 1\r\nLOC:\r\n1809 GERMANY RD\r\nREADING TWP\r\nBTWN: STONEY POINT RD & POSSUM HOLLOW RD\r\n\r\n\r\n\r\nCOM:\r
(Alert: Falls - 2) ALRM LVL: 1\r\nLOC:\r\n1175 OLD WAYNESBORO RD\r\nROOM 1\r\nHAMILTONBAN TWP\r\nBTWN: TUNNEL LN & LILAC LN\r\n\r\nRCVD AS 911\r\n\r\nCOM:\r\nThis happened now (less

Contact: hshank571@comcast.net <hshank571@comcast.net>
Sender: messaging@iamresponding.com
(GFD) Alert: Falls - 2\nALRM LVL: 1\nLOC:\n54 PERRIN AVE\nCUMBERLAND TWP\nBTWN: PEGRAM ST & ARCHER ST\n\nRCVD AS 911\n\nCOM:\nThis happened now (less t

Contact: bill mclaughlin <tala312@yahoo.com>
Sender: messaging@iamresponding.com
Subject:GFD\nAlert: Chest Pain - 1\nALRM LVL: 1\nLOC:\nHILTON GARDEN INN\n1061 YORK RD\nROOM-205\nSTRABAN TWP\nBTWN: NATURAL SPRING

Contact: Joseph Temarantz <jht726@gmail.com>
Sender: 777326416041
.... (GFD) Alert: Falls - 3\nALRM LVL: 1\nLOC:\nGETTYSBURG LUTHERAN HOME\n1075 OLD HARRISBURG RD\n156\nSTRABAN TWP\nBTWN: PRIVATE & SHEALER RD\n\nRCVD AS 911\n\nCOM:\nThis happened now (less than 6hrs ago).\nIt''s reported that she fell at ground level.\nThe reason for the fall is not known.\nThere is no bleeding now.\nShe is completely alert (responding appropriately).\nThe injury is to a NOT DANGEROUS area.\nShe is no longer on the floor (ground).\nDeterminant: 17A01, Suffix: , Response: Class 3\nThe patient is a 95 year(s) female who is conscious and breathing.\n\nCT:\nWEHERR at POS 04
.... (GFD) Alert: Breathing Problems - 1\nALRM LVL: 1\nLOC:\nGETTYSBURG FAMILY PRACTICE\n524 S WASHINGTON ST\n2ND FLR\nGETTYSBURG BORO\nBTWN: HOSPITAL ALY & GETTYS ST\n\nRCVD AS 911\n\nCOM:\nHe is completely alert (responding appropriately).\nHe has difficulty speaking between breaths.\nDeterminant: 06D02, Suffix: , Response: Class 1\nThe patient is a 72 year(s) male who is conscious and breathing.\nHe is not changing color.\nHe is not clammy.\nHe does not have asthma.\nN/A\n\nCT:\nPAHAGE at POS 01
.... (GFD) Alert: Transfer Fire / EMS\nALRM LVL: 1\nLOC:\nFK STATION 26\nFREDERICK CO\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\nFK STATION 26\n\nCT:\nGABRET at POS 04
.... (GFD) Alert: Fire - Brush / Wildland\nALRM LVL: 1\nLOC:\n435 CHAPEL RD\nCUMBERLAND TWP\nBTWN: BARLOW RD & RIDGE RD\n\nRCVD AS 911\n\nCOM:\nSMALL BRUSH FIRE WITH WIRES DOWN\nSPOKE TO SARAH AT MET-ED  WIRE DOWN WHICH CAUSED THE FIRE\nIT IS STOPPING FIRE DEPT FROM PUTTING OUT THE FIRE\nTHERE IS A POWER OUTAGE\nTHEY GAVE A 1-2 HOUR ETA\nTICKET#328-747-722\nREQ E1-1, ET23\nCALLED MET-ED BACK AND SPOKE TO TONYA TO LET HER KNOW POLE IS BROKEN\n\nCT:\nGABRET at POS 04

Contact: Active911
Agency name: York Springs Fire Department
Location: York Springs, PA, United States
Sender: "alert@adams911.com" <alert@adams911.com>

(Alert:) ALRM LVL: 1\nLOC:\nSOUTH MOUNTIAN RD/GREENHOUSE RD\nFRANKLIN TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:
(Alert:) ALRM LVL: 1\nLOC:\nSTA 36-1\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:
(Alert:) ALRM LVL: 1\nLOC:\n\nBTWN: N/A & N/A\n\n\n\nCOM:\n\n\nCT:
(Alert:) ALRM LVL: 1\nLOC:\nUNITED HOOK AND LADDER COMPANY #33 STATION 1\n21 N BOLTON ST\nNEW OXFORD BORO\nBTWN: LINCOLNWAY                       W & GOLDEN LN\n\nRCVD AS 911\n\nCOM:\n\n\nCT:
(Alert:) ALRM LVL: 1\nLOC:\n26 US 15 SB\nLATIMORE TWP\nBTWN: MOUNTAIN RD & COUNTY LINE RD\n\nRCVD AS 911\n\nCOM:\n\n\nCT:
(Alert: Stroke / CVA - 1) ALRM LVL: 1\nLOC:\n20 PLANK RD\nLATIMORE TWP\nBTWN: ACCESS OFF & OLD ROUTE 15\n\nRCVD AS 911\n\nCOM:\nShe is not completely alert (not responding appropriately).\nShe is breathing normally.\nShe is having sudden speech problems.\nThe stroke diagnostic was not used: NOT USED\nThese symptoms (problem) started: 15 MINS\nIt is not known if she has had a STROKE before.\nDeterminant: 28C01, Suffix: L, Response: Class 1\nThe patient is a 91 year(s) female who is conscious and breathing.\n\nCT:
(Alert: Falls - 2) ALRM LVL: 1\nLOC:\nHARMONY HILL FARM\n141 BATEMAN RD\nLATIMORE TWP\nBTWN: QUAKER CHURCH RD & RIDGE RD\n\nRCVD AS 911\n\nCOM:\nThis happened now (less than 6hrs ago).\nThe fall was less than 10ft/3m (less than 1 story).\nThe fall was accidental.\nThere is some bleeding, not serious.\nShe is completely alert (responding appropriately).\nThe extent of her injuries is not known.\nShe is still on the floor (ground).\nDeterminant: 17B03, Suffix: G, Response: Class 2\nAQUESTRIAN ACIDENT FELL FROM HORSE SHE HURST ALL OVER IS SITTING UP CONCIOUS ALERT\n\nCT:
(Alert: Unknown - 2) ALRM LVL: 1\nLOC:\n845 BUSHEY SCHOOL RD\nLATIMORE TWP\nBTWN: LATIMORE CREEK RD & COUNTY LINE RD\n\nRCVD AS 911\n\nCOM:\nREF 143710328\nVELMA PENTZ RESIDENCE, 528-4595\nThis is a Medical Alarm (Alert) notification.\nIt''s not known if she appears to be completely awake (alert).\nThe caller was too far away to hear if the patient was talking.\nIt''s not known what she is doing now.\nIt''s not known if she is moving at all.\nThe caller doesn''t know where she is.\nDeterminant: 32B02, Suffix: , Response: Class 2\n\nCT:
(Alert: Transfer Fire / EMS) ALRM LVL: 1\nLOC:\nSTA 36-1\nMOUNT HOLLY\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\nE9-2-Switch Status-STA 36-1, MOUNT HOLLY\nE9-2-No Response-STA 36-1, MOUNT HOLLY\n\nCT:
(Alert: Breathing Problems - 1) ALRM LVL: 1\nLOC:\n1410 UPPER BERMUDIAN RD\nHUNTINGTON TWP\nBTWN: GROUND OAK CHURCH RD & FUNT RD\n\nRCVD AS 911\n\nCOM:\nHe is completely alert (responding appropriately).\nHe does not have any difficulty speaking between breaths.\nHe is not changing color.\nHe is not clammy.\nHe does not have asthma.\nN/A\nDeterminant: 06C01, Suffix: , Response: Class 1\nThe patient is a 78 year(s) male who is conscious and breathing.\n\nCT:

Contact: Active911
Agency name: Fairfield Fire and EMS
Location: Fairfield, PA, United States
Sender: "alert@adams911.com" <alert@adams911.com>

(Alert: Alarm - Fire - Commercial) ALRM LVL: 1\nLOC:\nQUADGRAPHICS\n100 N MILLER ST\nFAIRFIELD BORO\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nEEBOWM at POS 03
(Alert: Diabetic Emergency - 1) ALRM LVL: 1\nLOC:\nFAIRFIELD RD/IRON SPRINGS RD\nHAMILTONBAN TWP\nBTWN: IRON SPRINGS RD & MCGLAUGHLIN LN\n\nRCVD AS Officer Initiated\n\nCOM:\nADAMS18-3-Safety Check-FAIRFIELD RD/IRON SPRINGS RD, HAMILTONBAN TWP\n\nCT:\nMDGROF at POS 04
(Alert: Alarm - Fire - Commercial) ALRM LVL: 1\nLOC:\nQUADGRAPHICS\n100 N MILLER ST\nFAIRFIELD BORO\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nLMBYER at POS 03
(Alert: Breathing Problems - 1) ALRM LVL: 1\nLOC:\nHILLSIDE REST HOME\n1175 OLD WAYNESBORO RD\nHAMILTONBAN TWP\nBTWN: TUNNEL LN & LILAC LN\n\nRCVD AS 911\n\nCOM:\nShe is completely alert (responding appropriately).\nShe has difficulty speaking between breaths.\nDeterminant: 06D02, Suffix: , Response: Class 1\nPROQA has reconfigured the response\n67-year-old, female, conscious, breathing.   Code: 6-D-2-A: DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma)\nShe is changing color.\nHer color change is pale.\nShe is not clammy.\nShe has asthma.\nReconfigured determinant: 06D02, Suffix: A, Response: Class 1\nThe patient is a 67 year(s) female who is conscious and breathing.\nShe has a prescribed inhaler.\nShe has used a prescribed inhaler.\nN/A\nIJN THE MED AREA\nFLM202-Switch Status-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD, HAMILTONBAN TWP\nFLM202-Enroute-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD, HAMILTONBAN TWP\n\nCT:\nNBCOOK at POS 03
(Alert: Falls - 1) ALRM LVL: 1\nLOC:\n34 FRUITWOOD TRL\nCARROLL VALLEY BORO\nBTWN: CROSS VIEW TRL & ASPEN TRL\n\nRCVD AS 911\n\nCOM:\nThis happened now (less than 6hrs ago).\nIt''s reported that he fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nHe is completely alert (responding appropriately).\nThe injury is to the head.\nHe is no longer on the floor (ground).\nDeterminant: 17B01, Suffix: , Response: Class 2\nThe patient is a 81 year(s) male who is conscious and breathing.\n\nCT:\nSMMELH at POS 04
(Alert: Falls - 2) ALRM LVL: 1\nLOC:\nBAYSIDE MASONRY\n26 DIANE TRL\nA\nCARROLL VALLEY BORO\nBTWN: CHERYL TRL & MARY-ANN TRL\n\nRCVD AS 911\n\nCOM:\nThis happened now (less than 6hrs ago).\nThe fall was less than 10ft/3m (less than 1 story).\nThe fall was accidental.\nThere is no bleeding now.\nHe is completely alert (responding appropriately).\nThe injury is to the head.\nHe is no longer on the floor (ground).\nDeterminant: 17B01, Suffix: , Response: Class 2\nThe patient is a 6 year(s) male who is conscious and breathing.\n\nCT:\nLMBYER at POS 04
(Alert: Sick Person - 3) ALRM LVL: 1\nLOC:\n26 ELIZABETH TRL\nCARROLL VALLEY BORO\nBTWN: CHERYL TRL & DORA TRL\n\nRCVD AS 911\n\nCOM:\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nShe has other pain: STOMACH PAIN\nShe is not bleeding (or vomiting blood).\nHer primary problem is nausea.\nDeterminant: 26A06, Suffix: , Response: Class 3\n\nCT:\nPAHAGE at POS 03
(Alert: Helicopter Standby) ALRM LVL: 1\nLOC:\nFAIRFIELD FIRE AND EMS DEPARTMENT\n106 STEELMAN ST\nFAIRFIELD BORO\nBTWN: BALDER ST & J H KANE AVE\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nPAHAGE at POS 04
(Alert: Breathing Problems - 1) ALRM LVL: 1\nLOC:\nSKI LIBERTY\n78 COUNTRY CLUB TRL\nCARROLL VALLEY BORO\nBTWN: SANDERS RD & SPORTS TRL\n\nRCVD AS 911\n\nCOM:\nShe is not completely alert (not responding appropriately).\nShe has difficulty speaking between breaths.\nDeterminant: 06D01, Suffix: , Response: Class 1\n\nCT:\nJEKOPP at POS 01
(Alert: Unknown - 2) ALRM LVL: 1\nLOC:\nBROWNS RANCH\n180 REDDING LN\nCUMBERLAND TWP\nBTWN: DIAMOND HILL RD & BOYCOTT LN\n\nRCVD AS 911\n\nCOM:\nThis is a Medical Alarm (Alert) notification.\nHe appears to be completely awake (alert).\nHe was heard talking.\nIt''s not known what he is doing now.\nHe is moving.\nThe caller doesn''t know where he is.\nDeterminant: 32B01, Suffix: , Response: Class 2\n\nCT:\nPAHAGE at POS 03

Contact: Active911
Agency name: Alpha Fire Co #1
Location: Littlestown, PA, United States
Sender: "alert@adams911.com" <alert@adams911.com>

(Alert:) ALRM LVL: 1\nLOC:\n\nBTWN: N/A & N/A\n\n\n\nCOM:\n\n\nCT:\nWEHERR at POS 04
(Alert: Chest Pain - 1) ALRM LVL: 1\nLOC:\n41000 SIMSON DR\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n6-15\n\nCT:\nMDGROF at POS 03
(Alert: Traumatic Injury - 2) ALRM LVL: 1\nLOC:\n250 FEESER RD\nGERMANY TWP\nBTWN: BALTIMORE PIKE & ROBERTS RD\n\nRCVD AS 911\n\nCOM:\nIt''s not known when this happened.\nThere is no bleeding now.\nHe is completely alert (responding appropriately).\nThe injury is to the head.\nDeterminant: 30B01, Suffix: , Response: Class 2\nThe patient is a 19 year(s) male who is conscious and breathing.\n\nCT:\nMDGROF at POS 04
(Alert: Chest Pain - 1) ALRM LVL: 1\nLOC:\n49 MARYLAND AVE\nLITTLESTOWN BORO\nBTWN: CLOVER LN & MYRTLE ST\n\nRCVD AS 911\n\nCOM:\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nHe is changing color.\nHis color change is pale.\nHe is clammy.\nDeterminant: 10D04, Suffix: , Response: Class 1\nThe patient is a 103 year(s) male who is conscious and breathing.\nHe has had angina (heart pains) before.\nHe took a prescribed medication in the past 12 hrs: NITRO (2)\n\nCT:\nGABRET at POS 01
(Alert: Investigation Outside) ALRM LVL: 1\nLOC:\nFREDERICK PIKE/GETTYSBURG RD\nGERMANY TWP\nBTWN: GETTYSBURG RD & HARNEY RD\n\nRCVD AS 911\n\nCOM:\nSOMETHING BURNING OUTSIDE\nE20-2-Switch Status-FREDERICK PIKE/GETTYSBURG RD, GERMANY TWP\nE20-2-Enroute-FREDERICK PIKE/GETTYSBURG RD, GERMANY TWP\n\nCT:\nJESCHW at POS 03
(Alert: Investigation Outside) ALRM LVL: 1\nLOC:\nFREDERICK PIKE/GETTYSBURG RD\nGERMANY TWP\nBTWN: GETTYSBURG RD & HARNEY RD\n\nRCVD AS 911\n\nCOM:\nSOMETHING BURNING OUTSIDE\n\nCT:\nJESCHW at POS 03
(Alert: Rescue - BLS) ALRM LVL: 1\nLOC:\nMATHIAS RD/LINE RD\nGERMANY TWP\nBTWN: LINE RD & CLOUSER RD\n\nRCVD AS 911\n\nCOM:\nWIRES DOWN ON A VEHICLE\nCALLER DOESN'T KNOW WHAT TYPE OF WIRE IT IS\n1 ADULT AND 2 CHILDREN IN THE VEHICLE\n\nCT:\nNBCOOK at POS 04
(Alert: Rescue - BLS) ALRM LVL: 1\nLOC:\nMATHIAS RD/LINE RD\nGERMANY TWP\nBTWN: LINE RD & CLOUSER RD\n\nRCVD AS 911\n\nCOM:\nWIRES DOWN ON A VEHICLE\nCALLER DOESN'T KNOW WHAT TYPE OF WIRE IT IS\n1 ADULT AND 2 CHILDREN IN THE VEHICLE\n\nCT:\nNBCOOK at POS 04
(Alert: Rescue - BLS) ALRM LVL: 1\nLOC:\nMATHIAS RD/LINE RD\nGERMANY TWP\nBTWN: LINE RD & CLOUSER RD\n\nRCVD AS 911\n\nCOM:\nWIRES DOWN ON A VEHICLE\nCALLER DOESN'T KNOW WHAT TYPE OF WIRE IT IS\n1 ADULT AND 2 CHILDREN IN THE VEHICLE\n\nCT:\nNBCOOK at POS 04
(Alert: Fire - Commercial) ALRM LVL: 1\nLOC:\nGETTYSBURG TOUR CENTER\n778 BALTIMORE ST\nGETTYSBURG BORO\nBTWN: STEINWEHR AVE & NATIONAL CEMETERY DR\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nNBCOOK at POS 03

Contact: Active911
Agency name: East Berlin Fire Company
Location: East Berlin, PA, United States
Sender: "alert@adams911.com" <alert@adams911.com>

(Alert:) ALRM LVL: 1\nLOC:\n\nBTWN: N/A & N/A\n\n\n\nCOM:\n\n\nCT:\nWEHERR at POS 04
(Alert: Unknown - 2) ALRM LVL: 1\nLOC:\n5551 PINE HILL RD\nDOVER TWP\nBTWN: N/A & N/A\n\nRCVD AS Radio\n\nCOM:\nBOX 9-6\n11A-Switch Status-5551 PINE HILL RD, DOVER TWP\n11A-Enroute-5551 PINE HILL RD, DOVER TWP\n\nCT:\nLMBYER at POS 04
(Alert: Unknown - 2) ALRM LVL: 1\nLOC:\n5551 PINE HILL RD\nDOVER TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\nBOX 9-6\n\nCT:\nLMBYER at POS 04
(Alert: Falls - 2) ALRM LVL: 1\nLOC:\n6040 WINDING LN\nPARADISE TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\nYORK BOX 112-30 11A\n\nCT:\nMDGROF at POS 04
(Alert: Falls - 2) ALRM LVL: 1\nLOC:\n7636 LINCOLN HWY\nBTWN: N/A & N/A\n\n\n\nCOM:\n33-100 11A\n\nCT:\nMDGROF at POS 04
(Alert: Traffic Accident - 2) ALRM LVL: 1\nLOC:\n7685 LINCOLN HWY\nPARADISE TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nMDGROF at POS 04
(Alert: Falls - 2) ALRM LVL: 1\nLOC:\nHARMONY HILL FARM\n141 BATEMAN RD\nLATIMORE TWP\nBTWN: QUAKER CHURCH RD & RIDGE RD\n\nRCVD AS 911\n\nCOM:\nThis happened now (less than 6hrs ago).\nThe fall was less than 10ft/3m (less than 1 story).\nThe fall was accidental.\nThere is some bleeding, not serious.\nShe is completely alert (responding appropriately).\nThe extent of her injuries is not known.\nShe is still on the floor (ground).\nDeterminant: 17B03, Suffix: G, Response: Class 2\nAQUESTRIAN ACIDENT FELL FROM HORSE SHE HURST ALL OVER IS SITTING UP CONCIOUS ALERT\n\nCT:\nGABRET at POS 02
(Alert: Unconscious - 1) ALRM LVL: 1\nLOC:\n239 THIRD ST\nEAST BERLIN BORO\nBTWN: SOUTH AVE & LOCUST ST\n\nRCVD AS 911\n\nCOM:\nIt''s not known if his breathing is completely normal.\nHis breathing is INEFFECTIVE.\nDeterminant: 31D01, Suffix: , Response: Class 1\n\nCT:\nCAHAGE at POS 04
(Alert: Fire - Residential) ALRM LVL: 1\nLOC:\n10 JEFFERSON DR\nHAMILTON TWP\nBTWN: HAMILTON DR & END\n\nRCVD AS 911\n\nCOM:\nSMOKE IN THE GARAGE AREA\nATTACHED TO HOUSE\nODOR AND VISISBLE\n\nCT:\nWEHERR at POS 03
(Alert: Fire - Residential) ALRM LVL: 1\nLOC:\n10 JEFFERSON DR\nHAMILTON TWP\nBTWN: HAMILTON DR & END\n\nRCVD AS 911\n\nCOM:\nSMOKE IN THE GARAGE AREA\nATTACHED TO HOUSE\n\nCT:\nWEHERR at POS 03

Contact: Active911
Agency name: Southeastern Adams Volunteer Emergency Services
Location: Hanover, PA, United States
Sender: "alert@adams911.com" <alert@adams911.com>

(Alert: Traffic Accident - 1) ALRM LVL: 1\nLOC:\nHANOVER BRICK & BLOCK CO\n240 BENDER RD\nMOUNT PLEASANT TWP\nBTWN: GEISELMAN RD & CENTENNIAL RD\n\nRCVD AS 911\n\nCOM:\nMALE CON ALERT  HEAD INJ  CAR UNDER A TREE\n\nCT:\nSMMELH at POS 04
(Alert: Assist Fire / EMS) ALRM LVL: 1\nLOC:\n2973 HANOVER PIKE\nCONEWAGO TWP\nBTWN: NARROW DR & PLEASANT VIEW DR\n\nRCVD AS 911\n\nCOM:\nYCA49-1 REQ MED ASSIST FOR LIFTING\n\nCT:\nPLPETR at POS 04
(Alert: Traumatic Injury - 3) ALRM LVL: 1\nLOC:\n2973 HANOVER PIKE\nCONEWAGO TWP\nBTWN: NARROW DR & PLEASANT VIEW DR\n\nRCVD AS 911\n\nCOM:\nThis happened more than 6hrs ago.\nThere is no bleeding now.\nHe is completely alert (responding appropriately).\nThe injury is to a NOT DANGEROUS area.\nDeterminant: 30A02, Suffix: , Response: Class 3\nThe patient is a 33 year(s) male who is conscious and breathing.\nDISLOCATED HIS KNEE YESTERDAY\nUNABLE TO GET OFF THE COUCH\nPT IS OVER 500LBS AND WILL NEED EXTRA MANPOWER\n\nCT:\nKNPARR at POS 04
(Alert: Traffic Accident - 2) ALRM LVL: 1\nLOC:\n280 S JEFFERSON ST\nCONEWAGO TWP\nBTWN: POPLAR ST & DEER DR\n\nRCVD AS 911\n\nCOM:\nPICK UP TRUCK HIT / OTHER VEHICLE IS IN CEMETARY\n\nCT:\nCAHAGE at POS 03
(Alert: Alarm - CO) ALRM LVL: 1\nLOC:\n19 N SIXTH ST\nMCSHERRYSTOWN BORO\nBTWN: MAPLE ST & NORTH ST\n\nRCVD AS 911\n\nCOM:\nCO ALARM IN MAIN LEVEL NEAR BASEMENT DOOR\n3 IN HOUSE ALL READING ZERO NOW\n\nCT:\nLRSORD at POS 04
(Alert: Fire - Residential) ALRM LVL: 1\nLOC:\n208 LUMBER ST\nLITTLESTOWN BORO\nBTWN: PARK AVE & WALNUT ST\n\nRCVD AS 911\n\nCOM:\nQUEEN ST/LUMBER ST\nSMOKE IS COMING OUT OF THE GARAGE\nWHITE GARAGE\n\nCT:\nMMSHAN at POS 04
(Alert: Falls - 1) ALRM LVL: 1\nLOC:\n120 FILBERT ST\nCONEWAGO TWP\nBTWN: S LINCOLN DR & COUNTY LINE\n\nRCVD AS 911\n\nCOM:\nThis happened now (less than 6hrs ago).\nIt''s reported that he fell at ground level.\nThe reason for the fall is not known.\nThere is no bleeding now.\nHe is not completely alert (not responding appropriately).\nThe extent of his injuries is not known.\nDeterminant: 17D03, Suffix: , Response: Class 1\nThe patient is a 29 year(s) male who is conscious and breathing.\n\nCT:\nSNCROU at POS 03
(Alert: Unconscious - 1) ALRM LVL: 1\nLOC:\nC & L DRYWALL\n390 LINDEN AVE\nD\nCONEWAGO TWP\nBTWN: JEFFERSON ST & WASHINGTON ST\n\nRCVD AS 911\n\nCOM:\nHis breathing is not completely normal.\nHe is not completely alert (not responding appropriately).\nHe is changing color.\nHis color change is pale.\nDeterminant: 31D03, Suffix: , Response: Class 1\nThe patient is a 24 year(s) male who is conscious and breathing.\nHe has no history of heart problems.\nFELL OUT OF THE CAR, UNRESPONSIVE, SLOW PULSE, BREATHING\nALS46A OS.\nALS46A ADV CARDIAC ARREST\n\nCT:\nSNCROU at POS 04
(Alert: Investigation Inside) ALRM LVL: 1\nLOC:\n800 RANDOLPH ST\nHANOVER\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nSARABINE at POS 04
(Alert:) ALRM LVL: 1\nLOC:\nSTATION 46-3\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nSARABINE at POS 04

Contact: Active911
Agency name: Barlow Fire Department
Location: Barlow, PA, United States
Sender: "alert@adams911.com" <alert@adams911.com>

(Alert: Alarm - Fire - Commercial) ALRM LVL: 1\nLOC:\nADIDAS\n1863 GETTYSBURG VILLAGE DR\n610\nMOUNT JOY TWP\nBTWN: PRIVATE & PRIVATE\n\nRCVD AS 911\n\nCOM:\nSMOKE DETECTOR\n\nCT:\nGABRET at POS 04
(Alert: Fire - Commercial) ALRM LVL: 1\nLOC:\nGETTYSBURG TOUR CENTER\n778 BALTIMORE ST\nGETTYSBURG BORO\nBTWN: STEINWEHR AVE & NATIONAL CEMETERY DR\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nNBCOOK at POS 03
(Alert: Fire - Residential) ALRM LVL: 1\nLOC:\n60 KNIGHT RD\nCUMBERLAND TWP\nBTWN: TANEYTOWN RD & ROUND TOP LN\n\nRCVD AS 911\n\nCOM:\nSMOKE IN THE HOUSE\n\nCT:\nPLPETR at POS 04
(Alert: Fire - Residential) ALRM LVL: 1\nLOC:\n1865 HIGHLAND AVENUE RD\nMOUNT JOY TWP\nBTWN: CLAPSADDLE RD & BALTIMORE PIKE\n\nRCVD AS 911\n\nCOM:\nBLACK SMOKE COMING FROM A VENT PIPE ON THE SIDE OF THE HOUSE\nCALLER KNOCKED ON THE DOOR BUT CANNOT GET ANYONE TO THE DOOR\nDOES NOT KNOW IF ITS A STOVE VENT OR DRYER VENT\nBLK SMOKE HAS STOPPED BUT CONCERNED THEIR IS A PROBLEM\n\nCT:\nJEKOPP at POS 02
(Alert: Falls - 3) ALRM LVL: 1\nLOC:\n1545 RIDGE RD\nCUMBERLAND TWP\nBTWN: CHAPEL RD & SENTZ RD\n\nRCVD AS 911\n\nCOM:\nThis happened now (less than 6hrs ago).\nIt''s reported that she fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nShe is completely alert (responding appropriately).\nShe has no injuries.\nShe is still on the floor (ground).\nDeterminant: 17A03, Suffix: G, Response: Class 3\nThe patient is a 63 year(s) female who is conscious and breathing.\nFELL FACE FORWARD INTO A RECLINER. NO APPARANT INJ.\nPT HAS SEVERE DIARRHEA AND VOMITTING FOR 2 DAYS. CALLER AND PT STATED A HOYER LIFT WOULD BE NEEDED/ MED ASSIST DS TO HELP.\n\nCT:\nSNCROU at POS 04
(Alert: Fire - Residential) ALRM LVL: 1\nLOC:\n1920 TANEYTOWN RD\nCUMBERLAND TWP\nBTWN: SOLOMON RD & BARLOW-GREENMOUNT RD\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nKNPARR at POS 04
(Alert: Traffic Accident - 2) ALRM LVL: 1\nLOC:\nCHAPEL RD/RIDGE RD\nCUMBERLAND TWP\nBTWN: RIDGE RD & MARSH CREEK RD\n\nRCVD AS 911\n\nCOM:\nONE VEH FED EX TRUCK HIT POLE\nPOSSIBLE INJURY\nONE SUBJECT OUT WALKING AROUND\nWIRES DOWN IN ROADWAY\n\nCT:\nBMPARR at POS 04
(Alert: Fire - Brush / Wildland) ALRM LVL: 1\nLOC:\n560 KNIGHT RD\nCUMBERLAND TWP\nBTWN: ROUND TOP LN & RIDGE RD\n\nRCVD AS 911\n\nCOM:\nCONTROLLED BURN  OUT OF CONTROL\n\nCT:\nJEKOPP at POS 03
(Alert: Fire - Commercial) ALRM LVL: 1\nLOC:\n127 BALTIMORE ST\nGETTYSBURG BORO\nBTWN: LEGION ALY & HIGH ST\n\nRCVD AS 911\n\nCOM:\nDUMPSTER FIRE NEAR STRUCTURE\n\nCT:\nLMBYER at POS 01
(Alert: Fire - Commercial) ALRM LVL: 1\nLOC:\nBOYD'S BEAR COUNTRY\n75 CUNNINGHAM RD\nCUMBERLAND TWP\nBTWN: EMMITSBURG RD & SHRIVER RD\n\nRCVD AS 911\n\nCOM:\nSMOKE COMING FROM THE BARN\n\nCT:\nKNPARR at POS 04

Contact: Active911
Agency name: United Hook  Ladder Co. #33
Location: New Oxford, PA, United States
Sender: "alert@adams911.com" <alert@adams911.com>

(Alert: Traffic Accident - 2) ALRM LVL: FP\nLOC:\nYORK RD/OAK DR\nOXFORD TWP\nBTWN: OAK DR & VILLAGE DR\n\nRCVD AS 911\n\nCOM:\nSUBJECT OUT OF THE VEHICLE, MINOR INJURIES\n\nCT:\nMDGROF at POS 04
(Alert: Sick Person - 1) ALRM LVL: 1\nLOC:\n29 CHINKAPIN DR\nOXFORD TWP\nBTWN: OAK DR & OAK DR\n\nRCVD AS 911\n\nCOM:\nHe is not completely alert (not responding appropriately).\nDeterminant: 26D01, Suffix: , Response: Class 1\n\nCT:\nMDGROF at POS 04
(Alert: Traffic Accident - 2) ALRM LVL: 1\nLOC:\n7685 LINCOLN HWY\nPARADISE TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nMDGROF at POS 04
(Alert: Falls - 3) ALRM LVL: 1\nLOC:\n245 BRICK LN\nMOUNT PLEASANT TWP\nBTWN: DAUBERTON DR & MANOR DR\n\nRCVD AS 911\n\nCOM:\nThis happened now (less than 6hrs ago).\nIt''s reported that he fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nHe is completely alert (responding appropriately).\nThe injury is to a NOT DANGEROUS area.\nHe is still on the floor (ground).\nDeterminant: 17A01, Suffix: G, Response: Class 3\nThe patient is a 70 year(s) male who is conscious and breathing.\nFALL WITH HIP INJURY. STILL ON FLOOR. MAY NEED TO BREAK WINDOW TO GET IN\n\nCT:\nGABRET at POS 04
(Alert: Stroke / CVA - 1) ALRM LVL: 1\nLOC:\nBRETHREN HOME\n2990 CARLISLE PIKE\nPERSONNEL CARE RM 3927\nOXFORD TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\nShe is not completely alert (not responding appropriately).\nShe is not breathing normally.\nOther symptoms were reported: HISTORY OF STROKE\nThe stroke diagnostic results indicate partial evidence of stroke.\nThese symptoms (problem) started: 15 MIN\nShe has had a STROKE before.\nDeterminant: 28C01, Suffix: C, Response: Class 1\nThe patient is a 90 year(s) female who is conscious and breathing.\n\nCT:\nCAHAGE at POS 01
(Alert: Unconscious - 1) ALRM LVL: 1\nLOC:\n239 THIRD ST\nEAST BERLIN BORO\nBTWN: SOUTH AVE & LOCUST ST\n\nRCVD AS 911\n\nCOM:\nIt''s not known if his breathing is completely normal.\nHis breathing is INEFFECTIVE.\nDeterminant: 31D01, Suffix: , Response: Class 1\nSIX STINTS IN PLACE\n\nCT:\nCAHAGE at POS 04
(Alert: Fire - Residential) ALRM LVL: 1\nLOC:\n10 JEFFERSON DR\nHAMILTON TWP\nBTWN: HAMILTON DR & END\n\nRCVD AS 911\n\nCOM:\nSMOKE IN THE GARAGE AREA\nATTACHED TO HOUSE\n\nCT:\nWEHERR at POS 03
(Alert: Cardiac / Respiratory Arrest - Echo) ALRM LVL: 1\nLOC:\n1125 ABBOTTSTOWN PIKE\nBERWICK TWP\nBTWN: GREEN SPRINGS RD & DEER TRAIL DR\n\nRCVD AS 911\n\nCOM:\nDeterminant: 09E01, Suffix: , Response: Class 1\nMALE IS ICE COLD, UNKNOWN CONDITIONS\nLAYING IN CHAIR\nCALLER UNABLE TO START CPR\nThe patient is a 82 year(s) male who is not conscious and not breathing.\nIt''s suspected that the patient is in cardiac arrest.\nIt''s not known if a defibrillator (AED) is available.\nS33-Switch Status-1125 ABBOTTSTOWN PIKE, BERWICK TWP\nS33-Enroute-1125 ABBOTTSTOWN PIKE, BERWICK TWP\n\nCT:\nWEHERR at POS 02
(Alert: Diabetic Emergency - 1) ALRM LVL: 1\nLOC:\n14 PARADISE CT\nNEW OXFORD BORO\nBTWN: WATER WORKS RD & END\n\nRCVD AS 911\n\nCOM:\nShe is not completely alert (not responding appropriately).\nShe is not behaving normally now.\nShe is breathing normally.\nDeterminant: 13C01, Suffix: , Response: Class 1\nThe patient is a 67 year(s) female who is conscious and breathing.\n\nCT:\nKEDEHO at POS 04
(Alert: Unconscious - 3) ALRM LVL: 1\nLOC:\nHARMONY RIDGE APARTMENTS\n610 HARMONY DR\nAPT-301\nOXFORD TWP\nBTWN: PATIENTS ARE IN & APT BUILDING\n\nRCVD AS 911\n\nCOM:\nHer breathing is completely normal.\nShe is completely alert (responding appropriately).\nShe is not changing color.\nShe has no history of heart problems.\nDeterminant: 31A01, Suffix: , Response: Class 3\nThe patient is a 86 year(s) female who is conscious and breathing.\n\nCT:\nKEDEHO at POS 04

Contact: Active911
Agency name: Bendersville Community Fire Company
Location: Bendersville, PA, United States
Sender: "alert@adams911.com" <alert@adams911.com>

(Alert: Investigation Outside) ALRM LVL: 1\nLOC:\n1081 POTATO RD\nMENALLEN TWP\nBTWN: CHURCH ST & BEAR MOUNTAIN RD\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nNBCOOK at POS 04
(Alert: Breathing Problems - 1) ALRM LVL: 1\nLOC:\n1410 UPPER BERMUDIAN RD\nHUNTINGTON TWP\nBTWN: GROUND OAK CHURCH RD & FUNT RD\n\nRCVD AS 911\n\nCOM:\nHe is completely alert (responding appropriately).\nHe does not have any difficulty speaking between breaths.\nHe is not changing color.\nHe is not clammy.\nHe does not have asthma.\nN/A\nDeterminant: 06C01, Suffix: , Response: Class 1\nThe patient is a 78 year(s) male who is conscious and breathing.\n\nCT:\nLMBYER at POS 04
(Alert: Animal Bite / Attack - 3) ALRM LVL: 1\nLOC:\n270 OPOSSUM HILL RD\nMENALLEN TWP\nBTWN: GABLERS RD & CLINES CHURCH RD\n\nRCVD AS 911\n\nCOM:\nThis happened now (less than 6hrs ago).\nShe was bitten/injured by a dog.\nThe animal has been locked up or captured.\nThere is some bleeding, not serious.\nShe is completely alert (responding appropriately).\nThe injury is to a NOT DANGEROUS area.\nThe bite is other than superficial, severe, or as a result of an ATTACK.\nDeterminant: 03A01, Suffix: , Response: Class 3\nThe patient is a 89 year(s) female who is conscious and breathing.\n\nCT:\nPAHAGE at POS 04
(Alert: Sick Person - 3) ALRM LVL: 1\nLOC:\nWELLSPAN ASPERS HEALTH CENTER\n2060 CARLISLE RD\nMENALLEN TWP\nBTWN: ASPERS-BENDERSVILLE RD & GABLERS RD\n\nRCVD AS 911\n\nCOM:\nThis is apparently a generalized (grand mal) seizure.\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nHe has other pain: STOMACH\nHe is not bleeding (or vomiting blood).\nNo priority symptoms (ALPHA conditions 2<128,147>11 not identified).\nNo priority symptoms (OMEGA conditions 2<128,147>28 not identified).\nDeterminant: 26A01, Suffix: , Response: Class 3\n\nCT:\nPAHAGE at POS 04
(Alert: Breathing Problems - 1) ALRM LVL: 1\nLOC:\n3886 CARLISLE RD\nHUNTINGTON TWP\nBTWN: IDAVILLE-YORK SPRINGS RD & THE COUNTY LINE\n\nRCVD AS 911\n\nCOM:\nHe is completely alert (responding appropriately).\nHe has difficulty speaking between breaths.\nDeterminant: 06D02, Suffix: , Response: Class 1\n\nCT:\nPLPETR at POS 04
(Alert: Heart Problems - 1) ALRM LVL: 1\nLOC:\nWELLSPAN ASPERS HEALTH CENTER\n2060 CARLISLE RD\nMENALLEN TWP\nBTWN: ASPERS-BENDERSVILLE RD & GABLERS RD\n\nRCVD AS 911\n\nCOM:\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nHe is changing color.\nHis color change is pink.\nHe is clammy.\nDeterminant: 19D04, Suffix: , Response: Class 1\nThe patient is a 65 year(s) male who is conscious and breathing.\nHe has a history of heart problems: AFIB\nHe does not have chest pain.\nHe took a prescribed medication in the past 12 hrs: REG MEDS\nInstructions for taking a pulse have been given.\nHis pulse is greater than or equal to 130 beats per minute.\nSIDE ENTRANCE\n\nCT:\nAJHANS at POS 03
(Alert: Fire - Brush / Wildland) ALRM LVL: 1\nLOC:\n515 PEACH GLEN-IDAVILLE RD\nHUNTINGTON TWP\nBTWN: GEORGETOWN RD & STARNER STATION RD\n\nRCVD AS 911\n\nCOM:\nCORN FIELD ON FIRE\nABOUT 100 YARDS AWAY FROM BUILDINGS\n\nCT:\nKEDEHO at POS 03
(Alert: Alarm - Fire - Commercial) ALRM LVL: 1\nLOC:\nKNOUSE FOODS PEACH GLEN\n800 PEACH GLEN-IDAVILLE RD\nHUNTINGTON TWP\nBTWN: STARNER STATION RD & GABLERS RD\n\nRCVD AS 911\n\nCOM:\nSAME ALARM PUMP HOUSE PUMP RUN\n\nCT:\nKEDEHO at POS 04
(Alert: Convulsions - 1) ALRM LVL: 1\nLOC:\n140 PEACH GLEN-IDAVILLE RD\nHUNTINGTON TWP\nBTWN: CARLISLE RD & GEORGETOWN RD\n\nRCVD AS 911\n\nCOM:\nThis is a FOCAL seizure.\nShe is not pregnant.\nShe is not diabetic.\nShe is an epileptic or she has had seizures before.\nShe is completely alert (responding appropriately).\nDeterminant: 12A02, Suffix: E, Response: Class 3\nThe patient is a 27 year(s) female who is conscious and breathing.\n\nCT:\nBMPARR at POS 04
(Alert: Chest Pain - 1) ALRM LVL: 1\nLOC:\n140 PEACH GLEN-IDAVILLE RD\nHUNTINGTON TWP\nBTWN: CARLISLE RD & GEORGETOWN RD\n\nRCVD AS 911\n\nCOM:\nShe is completely alert (responding appropriately).\nShe is not breathing normally.\nShe has difficulty speaking between breaths.\nDeterminant: 10D02, Suffix: , Response: Class 1\n\nCT:\nJLSHEN at POS 04

Contact: Active911
Agency name: Hampton Fire Company
Location: New Oxford, PA, United States
Sender: "alert@adams911.com" <alert@adams911.com>

(Alert: Fire - Residential) ALRM LVL: 1\nLOC:\n10 JEFFERSON DR\nHAMILTON TWP\nBTWN: HAMILTON DR & END\n\nRCVD AS 911\n\nCOM:\nSMOKE IN THE GARAGE AREA\nATTACHED TO HOUSE\n\nCT:\nWEHERR at POS 03
(Alert: Transfer Fire / EMS) ALRM LVL: 1\nLOC:\nEAST BERLIN FIRE DEPARTMENT\n101 E LOCUST ST\nEAST BERLIN BORO\nBTWN: ABBOTTSTOWN ST & STONER AVE\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nJESCHW at POS 04
(Alert: Fire - Chimney) ALRM LVL: 1\nLOC:\nYC BOX 112-32\n884 MEETING HOUSE RD\nPARADISE TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\nXST SHADY DELL ROAD\nCHIMNEY FIRE\n\nCT:\nJESCHW at POS 04
(Alert: Fire - Brush / Wildland) ALRM LVL: 1\nLOC:\nN BROWNS DAM DR/BROWNS DAM RD\nREADING TWP\nBTWN: BROWNS DAM RD & BROWNS DAM DR\n\nRCVD AS 911\n\nCOM:\nFIELD IS ON FIRE\nBROWNS DAM RD AND MAKE SECOND RIGHT\n\nCT:\nNBCOOK at POS 01
(Alert: Breathing Problems - 1) ALRM LVL: 1\nLOC:\n245 HOOVERS SCHOOL RD\nREADING TWP\nBTWN: EAST BERLIN RD & STONEY POINT RD\n\nRCVD AS 911\n\nCOM:\nShe is completely alert (responding appropriately).\nShe has difficulty speaking between breaths.\nDeterminant: 06D02, Suffix: , Response: Class 1\nPROQA has reconfigured the response\n39-year-old, female, conscious, breathing.   Code: 6-D-2-A: DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma)\nShe is clammy.\nShe has asthma.\nReconfigured determinant: 06D02, Suffix: A, Response: Class 1\n\nCT:\nPAHAGE at POS 01
(Alert: Unconscious - 1) ALRM LVL: 1\nLOC:\n16 HAMPTON DR\nREADING TWP\nBTWN: STONEY POINT RD & END\n\nRCVD AS 911\n\nCOM:\nHer breathing is not completely normal.\nHer breathing is abnormal but effective.\nShe is still unconscious.\nDeterminant: 31D02, Suffix: , Response: Class 1\n\nCT:\nBMPARR at POS 04
(Alert:) ALRM LVL: 1\nLOC:\nSHARRER'S MILL\n2220 OXFORD RD\nTYRONE TWP\nBTWN: SHARRER MILL RD & PLUM RUN RD\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nCAHAGE at POS 04
(Alert: Traffic Accident - 1) ALRM LVL: 1\nLOC:\n2300 OXFORD RD\nTYRONE TWP\nBTWN: SHARRER MILL RD & PLUM RUN RD\n\nRCVD AS 911\n\nCOM:\n33A-Switch Status-2300 OXFORD RD, TYRONE TWP\n33A-Enroute-2300 OXFORD RD, TYRONE TWP\nM51 REQ SUPERVISOR46 AND ASST 25 REQ AIR MED ON STANDBY\nPSP NOTIFIED AT DISP\nSTAT 13 ON STANDBY 8MIN ETA TO SCENE IF NEEDED\nM51 ADVISING STAT 13 IN THE AIR\nSTAT 13 GIVING 8 MIN ETA WITH FIRE 3 LZ25 CONTACT\n\nCT:\nCAHAGE at POS 02
(Alert: Breathing Problems - 1) ALRM LVL: 1\nLOC:\n245 HOOVERS SCHOOL RD\nREADING TWP\nBTWN: EAST BERLIN RD & STONEY POINT RD\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nSNCROU at POS 04
(Alert: Traffic Accident - 1) ALRM LVL: 1\nLOC:\nSTONEY POINT RD/GERMANY RD\nREADING TWP\nBTWN: GERMANY RD & BROUGH HILL RD\n\nRCVD AS 911\n\nCOM:\nCAR IN IN FIELD 3 FEET OFF ROAD WITH BLINKERS ON\nLEGS UNDERNEATH CAR\nFROM HAMPTON B EFORE INTERSECTION\n\nCT:\nLMBYER at POS 03

Contact: Active911
Agency name: Irishtown Fire Company
Location: New Oxford, PA, United States
Sender: "alert@adams911.com" <alert@adams911.com>

(Alert: Traffic Accident - 1) ALRM LVL: 1\nLOC:\n2300 OXFORD RD\nTYRONE TWP\nBTWN: SHARRER MILL RD & PLUM RUN RD\n\nRCVD AS 911\n\nCOM:\n33A-Switch Status-2300 OXFORD RD, TYRONE TWP\n33A-Enroute-2300 OXFORD RD, TYRONE TWP\nM51 REQ SUPERVISOR46 AND ASST 25 REQ AIR MED ON STANDBY\nPSP NOTIFIED AT DISP\nSTAT 13 ON STANDBY 8MIN ETA TO SCENE IF NEEDED\nM51 ADVISING STAT 13 IN THE AIR\nSTAT 13 GIVING 8 MIN ETA WITH FIRE 3 LZ25 CONTACT\n\nCT:\nCAHAGE at POS 02
(Alert: Traffic Accident - 1) ALRM LVL: 1\nLOC:\nMOUNT MISERY RD/RED HILL RD\nOXFORD TWP\nBTWN: RED HILL RD & IRISHTOWN RD\n\nRCVD AS 911\n\nCOM:\n2 VEHICLES\nVEHICLES BLOCKING THE ROADWAY\n1 INJURY\nHEAD INJURY\n\nCT:\nBLKELC at POS 04
(Alert: Fire - Residential) ALRM LVL: 1\nLOC:\n925 IRISHTOWN RD\nOXFORD TWP\nBTWN: BLACK LN & KOHLER MILL RD\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nNBCOOK at POS 03
(Alert: Traffic Accident - 2) ALRM LVL: 1\nLOC:\nEAST BERLIN RD/GUN CLUB RD\nHUNTINGTON TWP\nBTWN: GUN CLUB RD & WEIRMANS MILL RD\n\nRCVD AS 911\n\nCOM:\nBOX TRUCK INTO THE WOODS ONE SUBJECT COMPLAINING  KNEE INJURY\nVEHICLE IS LEAKING FUEL SU\nCH 4\nCM REQ SPILL UNIT\\nLOCAL EMA\nCM 25 CALL UPPER ADAMS/BERMUDIAN SCHOOL DISTRICTS RD WILL BE\nCLOSED FOR AWHILE\nEMA 76 NOTIFIED AND IS GOING TO CALL COMMAND 25\nCALLED BERMUDIAN SCHOOL DISTRICT\nCALLED UPPER ADAMS\nEMA 5 REQUESTING DEP BE CONTACTED\n\nCT:\nSMMELH at POS 01
(Alert: Traffic Accident w/ Entrapment) ALRM LVL: 1\nLOC:\nYORK RD/CARLISLE PIKE\nHAMILTON TWP\nBTWN: CARLISLE PIKE & STANLEY DR\n\nRCVD AS 911\n\nCOM:\n2 CARS\nCHANNEL 3\n\nCT:\nSMMELH at POS 04
(Alert: Traffic Accident w/ Entrapment) ALRM LVL: FP\nLOC:\nBROWNS DAM RD/CARLISLE PIKE\nREADING TWP\nBTWN: CARLISLE PIKE & FAWN AVE\n\nRCVD AS 911\n\nCOM:\nTT VS PICK UP\n1 VEHICLE POSSIBLY SMOKING\nHEAVY ENTRAPMENT PER FP10-2\nDRIVER IS CONSCIOUS\n\nCT:\nSMMELH at POS 04
(Alert: Fire - Commercial) ALRM LVL: 1\nLOC:\nSUZI SUDS-NEW OXFORD\n322 LINCOLNWAY E\nOXFORD TWP\nBTWN: BILLERBECK ST & BORO LINE\n\nRCVD AS 911\n\nCOM:\nDRYER IS SMOKING\n\nCT:\nLRSORD at POS 04
(Alert: Alarm - Fire - Commercial) ALRM LVL: 1\nLOC:\nBRETHREN HOME\n2990 CARLISLE PIKE\nOXFORD TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\nPERSONAL CARE SECOND FLOOR AND MAIN BUILDING\nWILL ATTEMPT KEYHOLDER\n\nCT:\nAMSTON at POS 01
(Alert: Fire - Brush / Wildland) ALRM LVL: 1\nLOC:\n901 SEVEN HUNDRED RD\nHAMILTON TWP\nBTWN: THE SPANGLER RD & SOLDIER CT\n\nRCVD AS 911\n\nCOM:\nWOODS IS ON FIRE NOT IMPENDING ON ANY STRUCTURES AT THIS TIME\n\nCT:\nAMSTON at POS 03
(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1\nLOC:\n14 MARY ST\nPARADISE TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\nBOX 33-100 / PARADISE TWP\nOPS 10\nXS ATLAND AVE\nXS LINCOLN HIGHWAY\nCHIEF 33 REQ\n\nCT:\nBMPARR at POS 04

Contact: Active911
Agency name: Wellspan EMS
Location: Gettysburg, PA, United States
Sender: "alert@adams911.com" <alert@adams911.com>

(Alert: Stroke / CVA - 1) ALRM LVL: 1\nLOC:\n1035 RENTZEL RD\nBUTLER TWP\nBTWN: BROOKSIDE LN & BENDERS CHURCH RD\n\nRCVD AS 911\n\nCOM:\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nHe is having sudden paralysis or facial droop on one side of the body.\nThe stroke diagnostic was not used: Skipped by user\nThese symptoms (problem) started: NOW\nHe has not had a STROKE before.\nDeterminant: 28C05, Suffix: L, Response: Class 1\nThe patient is a 70 year(s) male who is conscious and breathing.\n\nCT:\nWEHERR at POS 04
(Alert:) ALRM LVL: 1\nLOC:\n\nBTWN: N/A & N/A\n\n\n\nCOM:\n\n\nCT:\nWEHERR at POS 04
(Alert:) ALRM LVL: 1\nLOC:\n1240 GOODYEAR RD\nDICKENSON TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nLMBYER at POS 04
(Alert: Breathing Problems - 1) ALRM LVL: 1\nLOC:\nGETTYSBURG TRAVELODGE\n613 BALTIMORE ST\nROOM 215\nGETTYSBURG BORO\nBTWN: STEINWEHR AVE & NATIONAL CEMETERY DR\n\nRCVD AS 911\n\nCOM:\nIt''s not known if he is completely alert (responding appropriately).\nHe does not have any difficulty speaking between breaths.\nIt''s not known if he is changing color.\nIt''s not known if he is clammy.\nIt''s not known if he has asthma.\nIt''s not known if he has any special equipment or instructions to treat this.\nDeterminant: 06C01, Suffix: , Response: Class 1\nThe patient is a 58 year(s) male who is conscious and breathing.\n\nCT:\nMDGROF at POS 04
(Alert: Sick Person - 1) ALRM LVL: 1\nLOC:\n430 GUERNSEY RD\nBUTLER TWP\nBTWN: W GUERNSEY RD & OLD CARLISLE RD\n\nRCVD AS 911\n\nCOM:\nHe is confused.\nHe is breathing normally.\nHe does not have any pain.\nHe is not bleeding (or vomiting blood).\nDeterminant: 26C01, Suffix: , Response: Class 1\nThe patient is a 86 year(s) male who is conscious and breathing.\nHis primary problem is fever/chills.\n101.5\n\nCT:\nMDGROF at POS 04
(Alert: Breathing Problems - 1) ALRM LVL: 1\nLOC:\nGETTYSBURG LUTHERAN HOME\n1075 OLD HARRISBURG RD\n212B\nSTRABAN TWP\nBTWN: PRIVATE & SHEALER RD\n\nRCVD AS 911\n\nCOM:\nShe is completely alert (responding appropriately).\nShe has difficulty speaking between breaths.\nDeterminant: 06D02, Suffix: , Response: Class 1\nThe patient is a 72 year(s) female who is conscious and breathing.\nShe is not changing color.\nShe is not clammy.\nShe does not have asthma.\nN/A\n\nCT:\nLMBYER at POS 05
(Alert: Unconscious - 1) ALRM LVL: 1\nLOC:\nIRONHORSE REPAIR\n2939 YORK RD\nSTRABAN TWP\nBTWN: GRANITE STATION RD & CAREY LN\n\nRCVD AS 911\n\nCOM:\nHer breathing is not completely normal.\nShe is not completely alert (not responding appropriately).\nShe is changing color.\nHer color change is pink.\nDeterminant: 31D03, Suffix: , Response: Class 1\n\nCT:\nMDGROF at POS 04
(Alert: Unconscious - 1) ALRM LVL: 1\nLOC:\nTRANSITIONS HEALTHCARE GETTYSBURG\n595 BIGLERVILLE RD\nEAST SOUTH HALLWAY\nCUMBERLAND TWP\nBTWN: BORO LINE & HOWARD AVE\n\nRCVD AS 911\n\nCOM:\nHer breathing is completely normal.\nShe is completely alert (responding appropriately).\nShe is not changing color.\nIt''s not known if she has a history of heart problems.\nDeterminant: 31C02, Suffix: , Response: Class 1\nThe patient is a 80 year(s) female who is conscious and breathing.\n\nCT:\nMDGROF at POS 04
(Alert: Diabetic Emergency - 1) ALRM LVL: 1\nLOC:\nFAIRFIELD RD/IRON SPRINGS RD\nHAMILTONBAN TWP\nBTWN: IRON SPRINGS RD & MCGLAUGHLIN LN\n\nRCVD AS Officer Initiated\n\nCOM:\nADAMS18-3-Safety Check-FAIRFIELD RD/IRON SPRINGS RD, HAMILTONBAN TWP\n\nCT:\nMDGROF at POS 04
(Alert: Diabetic Emergency - 1) ALRM LVL: 1\nLOC:\n718 CENTER MILLS RD\nBUTLER TWP\nBTWN: OLD CARLISLE RD & BULL VALLEY RD\n\nRCVD AS 911\n\nCOM:\nSOUNDED LIKE A FEMALE TALKING IN THE BACKGROUND FOR A SHORT TIME THEN HUNG UP.\nHe is not completely alert (not responding appropriately).\nHe is reportedly combative or aggressive.\nHe is breathing normally.\nDeterminant: 13C01, Suffix: C, Response: Class 1\nThe patient is a 35 year(s) male who is conscious and breathing.\n\nCT:\nMDGROF at POS 04

Contact: Active911
Agency name: Fountaindale Fire Dept
Location: Fairfield, PA, United States
Sender: "alert@adams911.com" <alert@adams911.com>

(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1\nLOC:\n100 C V AVE\nWAYNESBORO\nBTWN: N/A & N/A\n\nRCVD AS Other Agency\n\nCOM:\nFL BOX 2-01\nJOHNSON CONTROLS\nET3-Switch Status-100 C V AVE, WAYNESBORO\nET3-Enroute-100 C V AVE, WAYNESBORO\n\nCT:\nGABRET at POS 04
(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1\nLOC:\n100 RD\nBTWN: WAYNESBORO PIKE & END\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nGABRET at POS 04
(Alert: Fire - Brush / Wildland) ALRM LVL: 1\nLOC:\n6833 BROWNS QUARRY RD\nSABILLASVILLE\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nKEDEHO at POS 03
(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1\nLOC:\n\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nKEDEHO at POS 04
(Alert:) ALRM LVL: 1\nLOC:\n12744 MONARAY LN\nWASHINGTON TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nLMBYER at POS 04
(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1\nLOC:\nWASHINGTON COUNTY BOX 7-6\n14627 PENNERSVILLE\nWASHINGTON COUNTY\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\nCS OF MACAFY HILL RD AND MD LINE HOUSE FIRE\nET3 AND EQ3\n\nCT:\nCAHAGE at POS 01
(Alert: Traffic Accident - 1) ALRM LVL: 1\nLOC:\nRT 550 AT WASH CO LINE\nFREDERICK CO\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nLRSORD at POS 03
(Alert: Traffic Accident - 2) ALRM LVL: 1\nLOC:\nJACKS MOUNTAIN RD/SKYLARK TRL\nCARROLL VALLEY BORO\nBTWN: SKYLARK TRL & CHERYL TRL\n\nRCVD AS 911\n\nCOM:\nFIRE 3\n1 OR 2 VEHICLES\n3 CHILDREN IN THE VEHICLE. PT'S WERE RUBBING THEIR NECKS\n\nCT:\nBLKELC at POS 04
(Alert:) ALRM LVL: 1\nLOC:\nFRANKLIN CO 4\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nLRSORD at POS 04
(Alert: Abdominal Pain - 1) ALRM LVL: 1\nLOC:\nHILLSIDE REST HOME\n1175 OLD WAYNESBORO RD\nDINNING ROOM\nHAMILTONBAN TWP\nBTWN: TUNNEL LN & LILAC LN\n\nRCVD AS 911\n\nCOM:\nShe is completely alert (responding appropriately).\nThere was no mention of existing aortic aneurysm.\nShe had a near fainting episode.\nDeterminant: 01C04, Suffix: , Response: Class 1\nThe patient is a 40 year(s) female who is conscious and breathing.\nFLM202-Switch Status-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD DINNING ROOM, HAMILTONBAN TWP\nFLM202-Enroute-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD DINNING ROOM, HAMILTONBAN TWP\n\nCT:\nBMPARR at POS 04

Contact: Active911
Agency name: Heidlersburg Fire Company
Location: Gettysburg, PA, United States
Sender: "alert@adams911.com" <alert@adams911.com>

(Alert: Traffic Accident - 1) ALRM LVL: 1\nLOC:\n2300 OXFORD RD\nTYRONE TWP\nBTWN: SHARRER MILL RD & PLUM RUN RD\n\nRCVD AS 911\n\nCOM:\n33A-Switch Status-2300 OXFORD RD, TYRONE TWP\n33A-Enroute-2300 OXFORD RD, TYRONE TWP\nM51 REQ SUPERVISOR46 AND ASST 25 REQ AIR MED ON STANDBY\nPSP NOTIFIED AT DISP\nSTAT 13 ON STANDBY 8MIN ETA TO SCENE IF NEEDED\nM51 ADVISING STAT 13 IN THE AIR\nSTAT 13 GIVING 8 MIN ETA WITH FIRE 3 LZ25 CONTACT\n\nCT:\nCAHAGE at POS 02
(Alert: Traffic Accident - 1) ALRM LVL: 1\nLOC:\n2300 OXFORD RD\nTYRONE TWP\nBTWN: SHARRER MILL RD & PLUM RUN RD\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nCAHAGE at POS 02
(Alert: Traffic Accident - 2) ALRM LVL: 1\nLOC:\n930 BENDERS CHURCH RD\nBUTLER TWP\nBTWN: RENTZEL RD & STONE JUG RD\n\nRCVD AS 911\n\nCOM:\nVEH INTO A DITCH / UNKN IN ANYONE IS IN THE VEH\nCALLER WAS ADVISED TO CALL BACK WITH MORE INFORMATION\n\nCT:\nPLPETR at POS 04
(Alert: Req For Fire Police) ALRM LVL: 1\nLOC:\nOLD HARRISBURG RD/HEIDLERSBURG RD\nTYRONE TWP\nBTWN: HEIDLERSBURG RD & ALLEY\n\nRCVD AS 911\n\nCOM:\nREQ FOR FIRE POLICE LOW HANGING WIRE JUST WEST OF THE INTERSECTION\nFP 9-1 ADVISED FP9-2 WAS ENROUTE TO THAT LOCATION\n\nCT:\nBMPARR at POS 02
(Alert: Traffic Accident - 1) ALRM LVL: FP\nLOC:\n23.4 US 15 NB\nHUNTINGTON TWP\nBTWN: S RIDGE RD & YORK SPRINGS EXIT (94)\n\nRCVD AS 911\n\nCOM:\n2 VEHICLES HEAD ON\n42 ADVISING 2 PT ONE W/ BACK AND STOMACH PAIN\n\nCT:\nNBCOOK at POS 03
(Alert: Traffic Accident - 1) ALRM LVL: 1\nLOC:\n23.4 US 15 NB\nHUNTINGTON TWP\nBTWN: S RIDGE RD & YORK SPRINGS EXIT (94)\n\nRCVD AS 911\n\nCOM:\n2 VEHICLES HEAD ON\n\nCT:\nNBCOOK at POS 03
(Alert: Breathing Problems - 1) ALRM LVL: 1\nLOC:\n4226 OLD HARRISBURG RD\nBUTLER TWP\nBTWN: PLAINVIEW RD & TWIN BRIDGE RD\n\nRCVD AS 911\n\nCOM:\nREF #143170732\nDOOR IS UNLOCKED\n86 YEAR OLD FEMALE, TROUBLE BREATHING, IS CONSCIOUS, NO DIFFICULTY SPEAKING BETWEEN BREATHS\nNO PAST HX KNOWN BY ALARM COMPANY\nREQUEST EMS RESET THE LIFELINE BOX\n\nCT:\nKNPARR at POS 02
(Alert: Overdose / Poisoning - Omega) ALRM LVL: 1\nLOC:\n651 FUNT RD\nTYRONE TWP\nBTWN: CRANBERRY RD & UPPER BERMUDIAN RD\n\nRCVD AS 911\n\nCOM:\nThis was accidental.\nHe is not changing color.\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nHe has taken something unlisted in ProQA: WOOD STAIN\nHe took it now (less than 30 mins. ago).\nDeterminant: 23O01, Suffix: A, Response: Class 3\n\nCT:\nPLPETR at POS 01
(Alert: Sick Person - 3) ALRM LVL: 1\nLOC:\n3822 OLD HARRISBURG RD\nSTRABAN TWP\nBTWN: STONE JUG RD & PLAINVIEW RD\n\nRCVD AS 911\n\nCOM:\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nShe has other pain: HIP AND LEG PAIN\nShe is not bleeding (or vomiting blood).\nHer primary problem is general weakness.\nDeterminant: 26A05, Suffix: , Response: Class 3\nThe patient is a 92 year(s) female who is conscious and breathing.\n\nCT:\nPLPETR at POS 03
(Alert: Traffic Accident - 2) ALRM LVL: 1\nLOC:\nEAST BERLIN RD/GUN CLUB RD\nHUNTINGTON TWP\nBTWN: GUN CLUB RD & WEIRMANS MILL RD\n\nRCVD AS 911\n\nCOM:\nBOX TRUCK INTO THE WOODS ONE SUBJECT COMPLAINING  KNEE INJURY\nVEHICLE IS LEAKING FUEL SU\nCH 4\n\nCT:\nSMMELH at POS 01

Contact: Active911
Agency name: Buchanan Valley Fire Department
Location: Orrtanna, PA, United States
Sender: adams911@adamscounty.us

(Alert: Animal Stray) ALRM LVL: 1, RUN CARD: BOX 33-2\nLOC:\n118 BILLERBECK ST\nOXFORD TWP\nBTWN: LIBERTY DR & HERITAGE CT\n\nCOM:\nFOUND DOG- GOLDEN RETRIEVER- GOLDEN IN COLOR\nUNITS: E27,ADAMS41-11
(Alert: Fire - Residential) ALRM LVL: 1, RUN CARD: BOX 5-8\nLOC:\n203 PEBBLE LN\nMENALLEN TWP\nBTWN: ROCKY RD & END\nUNITS: ET27,S5,E5-1,6A,E7-1,E27,R6,OFFICER5,TWR5
(Alert: Stroke / CVA - 1) ALRM LVL: 1, RUN CARD: BOX 27-5\nLOC:\n399 MILTONBERGER RD\nFRANKLIN TWP\nBTWN: MOUNTAIN RD & PINEY MOUNTAIN RIDGE RD\n\nCOM:\n72-year-old, male, conscious, breathing.   Code: 28-C-9-G: STROKE history (Greater than ___ hours since the symptoms started)\nSTROKE\nStroke (CVA)\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nOnly the word "stroke" was mentioned as the Chief Complaint.\nThe caller was unable to get close enough to the patient to use the Stroke Diagnostic.\nThese symptoms (problem) started: 6 HOURS\nHe has had a STROKE before.\nProQA Code: 28C09 (STROKE history)\nSuffix: G (Greater than ___ hours since the symptoms started)\nResponse: Class 1\nUNITS: FLM7,MEDASSIST27,FLA7-7
(Alert: Falls - 2) ALRM LVL: 1, RUN CARD: BOX 27-4\nLOC:\n1550 NEW RD\nFRANKLIN TWP\nBTWN: BOTTOM RD & CHURCH RD\n\nCOM:\n65-year-old, female, conscious, breathing.   Code: 17-B-3-G: Unknown status/Other codes not applicable (On the ground or floor)\nwife fell\nFalls\nThis happened now (less than 6hrs ago).\nIt''s reported that she fell at ground level.\nThe reason for the fall is not known.\nThere is no bleeding now.\nIt''s not known if she is completely alert (responding appropriately).\nThe extent of her injuries is not known.\nShe is still on the floor (ground).\nProQA Code: 17B03 (Unknown status/Other codes not applicable)\nSuffix: G (On the ground or floor)\nResponse: Class 2\nThe patient is a 65 year(s) female who is conscious and breathing.\nUNITS: MEDASSIST27,FLA7-7
(Alert: Traffic Accident - 1) ALRM LVL: 1, RUN CARD: BOX 27-1\nLOC:\n710 BUCHANAN VALLEY RD\nFRANKLIN TWP\nBTWN: CHURCH RD & MOUNTAIN RD\n\nCOM:\nSINGLE VEH INTO TREE, UNK INJURY, NOT BLOCKING\nUNITS: FLM7,ET27,R4,OFFICER27,FLA7-7
(Alert: Fire - Residential) ALRM LVL: 1, RUN CARD: BOX 4-1\nLOC:\n305 SEVEN STARS RD\nFRANKLIN TWP\nBTWN: CHAMBERSBURG RD & GLENWOOD DR\nUNITS: T4,OFFICER4,TK1,1A,ET27,E5-1,R4,E1-2,R6,E4-1
(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1, RUN CARD:\nLOC:\n1534 HEARTHSIDE DRIVE\nBOX 7-4\nGUILDORD TWP\nBTWN: N/A & N/A\nUNITS: ET27
(Alert: Investigation Outside) ALRM LVL: 1\nLOC:\nMISTER ED'S\n6019 CHAMBERSBURG RD\nFRANKLIN TWP\nBTWN: OLD ROUTE 30 & RHODODENDRON DR\n\nRCVD AS 911\n\nCOM:\nLARGE VOULUMN OF SMOKE IN THE AREA\n\nCT:\nJEKOPP at POS 03
(Alert: Fire - Residential) ALRM LVL: 1\nLOC:\n155 NORRIS RD\nMENALLEN TWP\nBTWN: HEEFNER RD & PRIVATE\n\nRCVD AS 911\n\nCOM:\nHOUSE ON FIRE NEXT TO ABOVE ADDRESS\n\nCT:\nPLPETR at POS 04
(Alert: Breathing Problems - 1) ALRM LVL: 1\nLOC:\nVILLAGE OF LAUREL RUN - TERRACE 2\n6353 CHAMBERSBURG RD\nFRANKLIN TWP\nBTWN: STONEBROOK DR & DOCKWOOD\n\nRCVD AS 911\n\nCOM:\n92-year-old, female, conscious, breathing.\nShe is completely alert (responding appropriately).\nShe has difficulty speaking between breaths.\nDeterminant: 06D02, Suffix: , Response: Class 1\nThe patient is a 92 year(s) female who is conscious and breathing.\nShe is not changing color.\nShe is not clammy.\nShe does not have asthma.\nN/A\n\nCT:\nBESTRA at POS 04
(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1\nLOC:\n1485 PARK TERRACE DR\nBOX 17-7\nGUILFORD TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nJLSHEN at POS 03

*/

public class PAAdamsCountyAParserTest extends BaseParserTest {
  
  public PAAdamsCountyAParserTest() {
    setParser(new PAAdamsCountyAParser(), "ADAMS COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:Alert: Traffic Accident - 1\nALRM LVL: 1\nLOC:\n274 HANOVER ST\nOXFORD TWP\nBTWN: COMMERCE ST & TROUT LN",
        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:274 HANOVER ST",
        "CITY:OXFORD TWP",
        "X:COMMERCE ST & TROUT LN");

    doTest("T2",
        "Subject:Alert: Fire - Residential\nALRM LVL: 1\nLOC:\n80 HUNTER CIR\nHAMILTON TWP\nBTWN: FOX DEN LN & FOX MEADOW",
        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:80 HUNTER CIR",
        "CITY:HAMILTON TWP",
        "X:FOX DEN LN & FOX MEADOW");

    doTest("T3",
        "Subject:Alert: Diabetic Emergency - 1\nALRM LVL: 1\nLOC:\nLINCOLNWAY W/TRACY AVE\nNEW OXFORD BORO\nBTWN: TRACY AVE & KOHLER MILL RD",
        "CALL:Diabetic Emergency - 1",
        "PRI:1",
        "ADDR:LINCOLNWAY W & TRACY AVE",
        "CITY:NEW OXFORD",
        "X:TRACY AVE & KOHLER MILL RD");

    doTest("T4",
        "Subject:Alert: Traffic Accident - 2\nALRM LVL: 1\nLOC:\nYORK RD/FLESHMAN MILL RD\nMOUNT PLEASANT TWP\nBTWN: FLESHMAN MILL RD",
        "CALL:Traffic Accident - 2",
        "PRI:1",
        "ADDR:YORK RD & FLESHMAN MILL RD",
        "CITY:MOUNT PLEASANT TWP",
        "X:FLESHMAN MILL RD");

    doTest("T5",
        "Subject:Alert: Fire - Residential\nALRM LVL: 1\nLOC:\n2315 HUNTERSTOWN-HAMPTON RD\nSTRABAN TWP\nBTWN: ALLEY & CONEWAGO RD",
        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:2315 HUNTERSTOWN-HAMPTON RD",
        "CITY:STRABAN TWP",
        "X:ALLEY & CONEWAGO RD");

    doTest("T6",
        "Subject:Alert: Traffic Accident - 2\nALRM LVL: 1\nLOC:\n760 NEW CHESTER RD\nSTRABAN TWP\nBTWN: SWIFT RUN RD & BRICKCRAFTERS RD",
        "CALL:Traffic Accident - 2",
        "PRI:1",
        "ADDR:760 NEW CHESTER RD",
        "CITY:STRABAN TWP",
        "X:SWIFT RUN RD & BRICKCRAFTERS RD");

    doTest("T7",
        "Subject:Alert: Fire - Brush / Wildland\n" +
        "ALRM LVL: 1\r\n" +
        "LOC:\r\n" +
        "1809 GERMANY RD\r\n" +
        "READING TWP\r\n" +
        "BTWN: STONEY POINT RD & POSSUM HOLLOW RD\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "COM:\r",

        "CALL:Fire - Brush / Wildland",
        "PRI:1",
        "ADDR:1809 GERMANY RD",
        "CITY:READING TWP",
        "X:STONEY POINT RD & POSSUM HOLLOW RD");

    doTest("T8",
        "(Alert: Falls - 2) ALRM LVL: 1\r\n" +
        "LOC:\r\n" +
        "1175 OLD WAYNESBORO RD\r\n" +
        "ROOM 1\r\n" +
        "HAMILTONBAN TWP\r\n" +
        "BTWN: TUNNEL LN & LILAC LN\r\n" +
        "\r\n" +
        "RCVD AS 911\r\n" +
        "\r\n" +
        "COM:\r\n" +
        "This happened now (less",

        "CALL:Falls - 2",
        "PRI:1",
        "PLACE:ROOM 1",
        "ADDR:1175 OLD WAYNESBORO RD",
        "CITY:HAMILTONBAN TWP",
        "X:TUNNEL LN & LILAC LN",
        "INFO:This happened now (less");

  }
  
  @Test
  public void testHshank571() {

    doTest("T1",
        "(GFD) Alert: Falls - 2\n" +
        "ALRM LVL: 1\n" +
        "LOC:\n" +
        "54 PERRIN AVE\n" +
        "CUMBERLAND TWP\n" +
        "BTWN: PEGRAM ST & ARCHER ST\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This happened now (less t",

        "SRC:GFD",
        "CALL:Falls - 2",
        "PRI:1",
        "ADDR:54 PERRIN AVE",
        "CITY:CUMBERLAND TWP",
        "X:PEGRAM ST & ARCHER ST",
        "INFO:This happened now (less t");

  }
  
  @Test
  public void testBillmcglaughin() {

    doTest("T1",
        "Subject:GFD\nAlert: Chest Pain - 1\nALRM LVL: 1\nLOC:\nHILTON GARDEN INN\n1061 YORK RD\nROOM-205\nSTRABAN TWP\nBTWN: NATURAL SPRING",
        "SRC:GFD",
        "CALL:Chest Pain - 1",
        "PRI:1",
        "PLACE:HILTON GARDEN INN",
        "ADDR:1061 YORK RD",
        "APT:205",
        "CITY:STRABAN TWP",
        "X:NATURAL SPRING");
   
  }
  
  @Test
  public void testJosephTemarantz() {

    doTest("T1",
        ".... (GFD) Alert: Falls - 3\n" +
        "ALRM LVL: 1\n" +
        "LOC:\n" +
        "GETTYSBURG LUTHERAN HOME\n" +
        "1075 OLD HARRISBURG RD\n" +
        "156\n" +
        "STRABAN TWP\n" +
        "BTWN: PRIVATE & SHEALER RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This happened now (less than 6hrs ago).\n" +
        "It''s reported that she fell at ground level.\n" +
        "The reason for the fall is not known.\n" +
        "There is no bleeding now.\n" +
        "She is completely alert (responding appropriately).\n" +
        "The injury is to a NOT DANGEROUS area.\n" +
        "She is no longer on the floor (ground).\n" +
        "Determinant: 17A01, Suffix: , Response: Class 3\n" +
        "The patient is a 95 year(s) female who is conscious and breathing.\n\n" +
        "CT:\n" +
        "WEHERR at POS 04",

        "SRC:GFD",
        "CALL:Falls - 3",
        "PRI:1",
        "PLACE:GETTYSBURG LUTHERAN HOME",
        "ADDR:1075 OLD HARRISBURG RD",
        "APT:156",
        "CITY:STRABAN TWP",
        "X:PRIVATE & SHEALER RD",
        "INFO:This happened now (less than 6hrs ago).\nIt''s reported that she fell at ground level.\nThe reason for the fall is not known.\nThere is no bleeding now.\nShe is completely alert (responding appropriately).\nThe injury is to a NOT DANGEROUS area.\nShe is no longer on the floor (ground).\nDeterminant: 17A01, Suffix: , Response: Class 3\nThe patient is a 95 year(s) female who is conscious and breathing.");

    doTest("T2",
        ".... (GFD) Alert: Breathing Problems - 1\n" +
        "ALRM LVL: 1\n" +
        "LOC:\n" +
        "GETTYSBURG FAMILY PRACTICE\n" +
        "524 S WASHINGTON ST\n" +
        "2ND FLR\n" +
        "GETTYSBURG BORO\n" +
        "BTWN: HOSPITAL ALY & GETTYS ST\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "He is completely alert (responding appropriately).\n" +
        "He has difficulty speaking between breaths.\n" +
        "Determinant: 06D02, Suffix: , Response: Class 1\n" +
        "The patient is a 72 year(s) male who is conscious and breathing.\n" +
        "He is not changing color.\n" +
        "He is not clammy.\n" +
        "He does not have asthma.\n" +
        "N/A\n\n" +
        "CT:\n" +
        "PAHAGE at POS 01",

        "SRC:GFD",
        "CALL:Breathing Problems - 1",
        "PRI:1",
        "PLACE:GETTYSBURG FAMILY PRACTICE",
        "ADDR:524 S WASHINGTON ST",
        "CITY:2ND FLR",
        "X:HOSPITAL ALY & GETTYS ST",
        "INFO:He is completely alert (responding appropriately).\nHe has difficulty speaking between breaths.\nDeterminant: 06D02, Suffix: , Response: Class 1\nThe patient is a 72 year(s) male who is conscious and breathing.\nHe is not changing color.\nHe is not clammy.\nHe does not have asthma.\nN/A");

    doTest("T3",
        ".... (GFD) Alert: Transfer Fire / EMS\n" +
        "ALRM LVL: 1\n" +
        "LOC:\n" +
        "FK STATION 26\n" +
        "FREDERICK CO\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "FK STATION 26\n\n" +
        "CT:\n" +
        "GABRET at POS 04",

        "SRC:GFD",
        "CALL:Transfer Fire / EMS",
        "PRI:1",
        "ADDR:FK STATION 26",
        "CITY:FREDERICK COUNTY",
        "ST:MD",
        "INFO:FK STATION 26");

    doTest("T4",
        ".... (GFD) Alert: Fire - Brush / Wildland\n" +
        "ALRM LVL: 1\n" +
        "LOC:\n" +
        "435 CHAPEL RD\n" +
        "CUMBERLAND TWP\n" +
        "BTWN: BARLOW RD & RIDGE RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "SMALL BRUSH FIRE WITH WIRES DOWN\n" +
        "SPOKE TO SARAH AT MET-ED  WIRE DOWN WHICH CAUSED THE FIRE\n" +
        "IT IS STOPPING FIRE DEPT FROM PUTTING OUT THE FIRE\n" +
        "THERE IS A POWER OUTAGE\n" +
        "THEY GAVE A 1-2 HOUR ETA\n" +
        "TICKET#328-747-722\n" +
        "REQ E1-1, ET23\n" +
        "CALLED MET-ED BACK AND SPOKE TO TONYA TO LET HER KNOW POLE IS BROKEN\n\n" +
        "CT:\n" +
        "GABRET at POS 04",

        "SRC:GFD",
        "CALL:Fire - Brush / Wildland",
        "PRI:1",
        "ADDR:435 CHAPEL RD",
        "CITY:CUMBERLAND TWP",
        "X:BARLOW RD & RIDGE RD",
        "INFO:SMALL BRUSH FIRE WITH WIRES DOWN\nSPOKE TO SARAH AT MET-ED  WIRE DOWN WHICH CAUSED THE FIRE\nIT IS STOPPING FIRE DEPT FROM PUTTING OUT THE FIRE\nTHERE IS A POWER OUTAGE\nTHEY GAVE A 1-2 HOUR ETA\nTICKET#328-747-722\nREQ E1-1, ET23\nCALLED MET-ED BACK AND SPOKE TO TONYA TO LET HER KNOW POLE IS BROKEN");
 
  }
  
  @Test
  public void testYorkSpringsFireDepartment() {

    doTest("T1",
        "(Alert:) ALRM LVL: 1\nLOC:\nSOUTH MOUNTIAN RD/GREENHOUSE RD\nFRANKLIN TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:",
        "CALL:ALERT",
        "PRI:1",
        "ADDR:SOUTH MOUNTIAN RD & GREENHOUSE RD",
        "CITY:FRANKLIN TWP");

    doTest("T2",
        "(Alert:) ALRM LVL: 1\nLOC:\nSTA 36-1\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:",
        "CALL:ALERT",
        "PRI:1",
        "ADDR:STA 36-1");

    doTest("T3",
        "(Alert:) ALRM LVL: 1\nLOC:\n\nBTWN: N/A & N/A\n\n\n\nCOM:\n\n\nCT:",
        "CALL:ALERT",
        "PRI:1");

    doTest("T4",
        "(Alert:) ALRM LVL: 1\n" +
        "LOC:\n" +
        "UNITED HOOK AND LADDER COMPANY #33 STATION 1\n" +
        "21 N BOLTON ST\n" +
        "NEW OXFORD BORO\n" +
        "BTWN: LINCOLNWAY                       W & GOLDEN LN\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "CAHAGE at POS 04",

        "CALL:ALERT",
        "PRI:1",
        "PLACE:UNITED HOOK AND LADDER COMPANY #33 STATION 1",
        "ADDR:21 N BOLTON ST",
        "CITY:NEW OXFORD",
        "X:LINCOLNWAY W & GOLDEN LN");

    doTest("T5",
        "(Alert:) ALRM LVL: 1\nLOC:\n26 US 15 SB\nLATIMORE TWP\nBTWN: MOUNTAIN RD & COUNTY LINE RD\n\nRCVD AS 911\n\nCOM:\n\n\nCT:",
        "CALL:ALERT",
        "PRI:1",
        "ADDR:26 US 15 SB",
        "MADDR:26 US 15",
        "CITY:LATIMORE TWP",
        "X:MOUNTAIN RD & COUNTY LINE RD");

    doTest("T6",
        "(Alert: Stroke / CVA - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "20 PLANK RD\n" +
        "LATIMORE TWP\n" +
        "BTWN: ACCESS OFF & OLD ROUTE 15\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "She is not completely alert (not responding appropriately).\n" +
        "She is breathing normally.\n" +
        "She is having sudden speech problems.\n" +
        "The stroke diagnostic was not used: NOT USED\n" +
        "These symptoms (problem) started: 15 MINS\n" +
        "It is not known if she has had a STROKE before.\n" +
        "Determinant: 28C01, Suffix: L, Response: Class 1\n" +
        "The patient is a 91 year(s) female who is conscious and breathing.\n\n" +
        "CT:\n" +
        "WEHERR at POS 01",

        "CALL:Stroke / CVA - 1",
        "PRI:1",
        "ADDR:20 PLANK RD",
        "CITY:LATIMORE TWP",
        "X:ACCESS OFF & OLD ROUTE 15",
        "INFO:She is not completely alert (not responding appropriately).\nShe is breathing normally.\nShe is having sudden speech problems.\nThe stroke diagnostic was not used: NOT USED\nThese symptoms (problem) started: 15 MINS\nIt is not known if she has had a STROKE before.\nDeterminant: 28C01, Suffix: L, Response: Class 1\nThe patient is a 91 year(s) female who is conscious and breathing.");

    doTest("T7",
        "(Alert: Falls - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "HARMONY HILL FARM\n" +
        "141 BATEMAN RD\n" +
        "LATIMORE TWP\n" +
        "BTWN: QUAKER CHURCH RD & RIDGE RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This happened now (less than 6hrs ago).\n" +
        "The fall was less than 10ft/3m (less than 1 story).\n" +
        "The fall was accidental.\n" +
        "There is some bleeding, not serious.\n" +
        "She is completely alert (responding appropriately).\n" +
        "The extent of her injuries is not known.\n" +
        "She is still on the floor (ground).\n" +
        "Determinant: 17B03, Suffix: G, Response: Class 2\n" +
        "AQUESTRIAN ACIDENT FELL FROM HORSE SHE HURST ALL OVER IS SITTING UP CONCIOUS ALERT\n\n" +
        "CT:\n" +
        "GABRET at POS 02",

        "CALL:Falls - 2",
        "PRI:1",
        "PLACE:HARMONY HILL FARM",
        "ADDR:141 BATEMAN RD",
        "CITY:LATIMORE TWP",
        "X:QUAKER CHURCH RD & RIDGE RD",
        "INFO:This happened now (less than 6hrs ago).\nThe fall was less than 10ft/3m (less than 1 story).\nThe fall was accidental.\nThere is some bleeding, not serious.\nShe is completely alert (responding appropriately).\nThe extent of her injuries is not known.\nShe is still on the floor (ground).\nDeterminant: 17B03, Suffix: G, Response: Class 2\nAQUESTRIAN ACIDENT FELL FROM HORSE SHE HURST ALL OVER IS SITTING UP CONCIOUS ALERT");

    doTest("T8",
        "(Alert: Unknown - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "845 BUSHEY SCHOOL RD\n" +
        "LATIMORE TWP\n" +
        "BTWN: LATIMORE CREEK RD & COUNTY LINE RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "REF 143710328\n" +
        "VELMA PENTZ RESIDENCE, 528-4595\n" +
        "This is a Medical Alarm (Alert) notification.\n" +
        "It''s not known if she appears to be completely awake (alert).\n" +
        "The caller was too far away to hear if the patient was talking.\n" +
        "It''s not known what she is doing now.\n" +
        "It''s not known if she is moving at all.\n" +
        "The caller doesn''t know where she is.\n" +
        "Determinant: 32B02, Suffix: , Response: Class 2\n\n" +
        "CT:\n" +
        "GABRET at POS 04",

        "CALL:Unknown - 2",
        "PRI:1",
        "ADDR:845 BUSHEY SCHOOL RD",
        "CITY:LATIMORE TWP",
        "X:LATIMORE CREEK RD & COUNTY LINE RD",
        "INFO:REF 143710328\nVELMA PENTZ RESIDENCE, 528-4595\nThis is a Medical Alarm (Alert) notification.\nIt''s not known if she appears to be completely awake (alert).\nThe caller was too far away to hear if the patient was talking.\nIt''s not known what she is doing now.\nIt''s not known if she is moving at all.\nThe caller doesn''t know where she is.\nDeterminant: 32B02, Suffix: , Response: Class 2");

    doTest("T9",
        "(Alert: Transfer Fire / EMS) ALRM LVL: 1\n" +
        "LOC:\n" +
        "STA 36-1\n" +
        "MOUNT HOLLY\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "E9-2-Switch Status-STA 36-1, MOUNT HOLLY\n" +
        "E9-2-No Response-STA 36-1, MOUNT HOLLY\n\n" +
        "CT:\n" +
        "LMBYER at POS 04",

        "CALL:Transfer Fire / EMS",
        "PRI:1",
        "ADDR:STA 36-1",
        "CITY:MOUNT HOLLY",
        "INFO:E9-2-Switch Status-STA 36-1, MOUNT HOLLY\nE9-2-No Response-STA 36-1, MOUNT HOLLY");

    doTest("T10",
        "(Alert: Breathing Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "1410 UPPER BERMUDIAN RD\n" +
        "HUNTINGTON TWP\n" +
        "BTWN: GROUND OAK CHURCH RD & FUNT RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "He is completely alert (responding appropriately).\n" +
        "He does not have any difficulty speaking between breaths.\n" +
        "He is not changing color.\n" +
        "He is not clammy.\n" +
        "He does not have asthma.\n" +
        "N/A\n" +
        "Determinant: 06C01, Suffix: , Response: Class 1\n" +
        "The patient is a 78 year(s) male who is conscious and breathing.\n\n" +
        "CT:\n" +
        "LMBYER at POS 04",

        "CALL:Breathing Problems - 1",
        "PRI:1",
        "ADDR:1410 UPPER BERMUDIAN RD",
        "CITY:HUNTINGTON TWP",
        "X:GROUND OAK CHURCH RD & FUNT RD",
        "INFO:He is completely alert (responding appropriately).\nHe does not have any difficulty speaking between breaths.\nHe is not changing color.\nHe is not clammy.\nHe does not have asthma.\nN/A\nDeterminant: 06C01, Suffix: , Response: Class 1\nThe patient is a 78 year(s) male who is conscious and breathing.");

  }
  
  @Test
  public void testFairfieldFireAndEMS() {

    doTest("T1",
        "(Alert: Alarm - Fire - Commercial) ALRM LVL: 1\n" +
        "LOC:\n" +
        "QUADGRAPHICS\n" +
        "100 N MILLER ST\n" +
        "FAIRFIELD BORO\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "EEBOWM at POS 03",

        "CALL:Alarm - Fire - Commercial",
        "PRI:1",
        "PLACE:QUADGRAPHICS",
        "ADDR:100 N MILLER ST",
        "CITY:FAIRFIELD");

    doTest("T2",
        "(Alert: Diabetic Emergency - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "FAIRFIELD RD/IRON SPRINGS RD\n" +
        "HAMILTONBAN TWP\n" +
        "BTWN: IRON SPRINGS RD & MCGLAUGHLIN LN\n\n" +
        "RCVD AS Officer Initiated\n\n" +
        "COM:\n" +
        "ADAMS18-3-Safety Check-FAIRFIELD RD/IRON SPRINGS RD, HAMILTONBAN TWP\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Diabetic Emergency - 1",
        "PRI:1",
        "ADDR:FAIRFIELD RD & IRON SPRINGS RD",
        "CITY:HAMILTONBAN TWP",
        "X:IRON SPRINGS RD & MCGLAUGHLIN LN",
        "INFO:ADAMS18-3-Safety Check-FAIRFIELD RD/IRON SPRINGS RD, HAMILTONBAN TWP");

    doTest("T3",
        "(Alert: Alarm - Fire - Commercial) ALRM LVL: 1\n" +
        "LOC:\n" +
        "QUADGRAPHICS\n" +
        "100 N MILLER ST\n" +
        "FAIRFIELD BORO\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "LMBYER at POS 03",

        "CALL:Alarm - Fire - Commercial",
        "PRI:1",
        "PLACE:QUADGRAPHICS",
        "ADDR:100 N MILLER ST",
        "CITY:FAIRFIELD");

    doTest("T4",
        "(Alert: Breathing Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "HILLSIDE REST HOME\n" +
        "1175 OLD WAYNESBORO RD\n" +
        "HAMILTONBAN TWP\n" +
        "BTWN: TUNNEL LN & LILAC LN\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "She is completely alert (responding appropriately).\n" +
        "She has difficulty speaking between breaths.\n" +
        "Determinant: 06D02, Suffix: , Response: Class 1\n" +
        "PROQA has reconfigured the response\n" +
        "67-year-old, female, conscious, breathing.   Code: 6-D-2-A: DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma)\n" +
        "She is changing color.\n" +
        "Her color change is pale.\n" +
        "She is not clammy.\n" +
        "She has asthma.\n" +
        "Reconfigured determinant: 06D02, Suffix: A, Response: Class 1\n" +
        "The patient is a 67 year(s) female who is conscious and breathing.\n" +
        "She has a prescribed inhaler.\n" +
        "She has used a prescribed inhaler.\n" +
        "N/A\n" +
        "IJN THE MED AREA\n" +
        "FLM202-Switch Status-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD, HAMILTONBAN TWP\n" +
        "FLM202-Enroute-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD, HAMILTONBAN TWP\n\n" +
        "CT:\n" +
        "NBCOOK at POS 03",

        "CALL:Breathing Problems - 1",
        "PRI:1",
        "PLACE:HILLSIDE REST HOME",
        "ADDR:1175 OLD WAYNESBORO RD",
        "CITY:HAMILTONBAN TWP",
        "X:TUNNEL LN & LILAC LN",
        "INFO:She is completely alert (responding appropriately).\nShe has difficulty speaking between breaths.\nDeterminant: 06D02, Suffix: , Response: Class 1\nPROQA has reconfigured the response\n67-year-old, female, conscious, breathing.   Code: 6-D-2-A: DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma)\nShe is changing color.\nHer color change is pale.\nShe is not clammy.\nShe has asthma.\nReconfigured determinant: 06D02, Suffix: A, Response: Class 1\nThe patient is a 67 year(s) female who is conscious and breathing.\nShe has a prescribed inhaler.\nShe has used a prescribed inhaler.\nN/A\nIJN THE MED AREA\nFLM202-Switch Status-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD, HAMILTONBAN TWP\nFLM202-Enroute-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD, HAMILTONBAN TWP");

    doTest("T5",
        "(Alert: Falls - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "34 FRUITWOOD TRL\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: CROSS VIEW TRL & ASPEN TRL\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This happened now (less than 6hrs ago).\n" +
        "It''s reported that he fell at ground level.\n" +
        "The fall was accidental.\n" +
        "There is no bleeding now.\n" +
        "He is completely alert (responding appropriately).\n" +
        "The injury is to the head.\n" +
        "He is no longer on the floor (ground).\n" +
        "Determinant: 17B01, Suffix: , Response: Class 2\n" +
        "The patient is a 81 year(s) male who is conscious and breathing.\n\n" +
        "CT:\n" +
        "SMMELH at POS 04",

        "CALL:Falls - 1",
        "PRI:1",
        "ADDR:34 FRUITWOOD TRL",
        "CITY:CARROLL VALLEY",
        "X:CROSS VIEW TRL & ASPEN TRL",
        "INFO:This happened now (less than 6hrs ago).\nIt''s reported that he fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nHe is completely alert (responding appropriately).\nThe injury is to the head.\nHe is no longer on the floor (ground).\nDeterminant: 17B01, Suffix: , Response: Class 2\nThe patient is a 81 year(s) male who is conscious and breathing.");

    doTest("T6",
        "(Alert: Falls - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "BAYSIDE MASONRY\n" +
        "26 DIANE TRL\n" +
        "A\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: CHERYL TRL & MARY-ANN TRL\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This happened now (less than 6hrs ago).\n" +
        "The fall was less than 10ft/3m (less than 1 story).\n" +
        "The fall was accidental.\n" +
        "There is no bleeding now.\n" +
        "He is completely alert (responding appropriately).\n" +
        "The injury is to the head.\n" +
        "He is no longer on the floor (ground).\n" +
        "Determinant: 17B01, Suffix: , Response: Class 2\n" +
        "The patient is a 6 year(s) male who is conscious and breathing.\n\n" +
        "CT:\n" +
        "LMBYER at POS 04",

        "CALL:Falls - 2",
        "PRI:1",
        "PLACE:BAYSIDE MASONRY",
        "ADDR:26 DIANE TRL",
        "APT:A",
        "CITY:CARROLL VALLEY",
        "X:CHERYL TRL & MARY-ANN TRL",
        "INFO:This happened now (less than 6hrs ago).\nThe fall was less than 10ft/3m (less than 1 story).\nThe fall was accidental.\nThere is no bleeding now.\nHe is completely alert (responding appropriately).\nThe injury is to the head.\nHe is no longer on the floor (ground).\nDeterminant: 17B01, Suffix: , Response: Class 2\nThe patient is a 6 year(s) male who is conscious and breathing.");

    doTest("T7",
        "(Alert: Sick Person - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "26 ELIZABETH TRL\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: CHERYL TRL & DORA TRL\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is breathing normally.\n" +
        "She has other pain: STOMACH PAIN\n" +
        "She is not bleeding (or vomiting blood).\n" +
        "Her primary problem is nausea.\n" +
        "Determinant: 26A06, Suffix: , Response: Class 3\n\n" +
        "CT:\n" +
        "PAHAGE at POS 03",

        "CALL:Sick Person - 3",
        "PRI:1",
        "ADDR:26 ELIZABETH TRL",
        "CITY:CARROLL VALLEY",
        "X:CHERYL TRL & DORA TRL",
        "INFO:She is completely alert (responding appropriately).\nShe is breathing normally.\nShe has other pain: STOMACH PAIN\nShe is not bleeding (or vomiting blood).\nHer primary problem is nausea.\nDeterminant: 26A06, Suffix: , Response: Class 3");

    doTest("T8",
        "(Alert: Helicopter Standby) ALRM LVL: 1\n" +
        "LOC:\n" +
        "FAIRFIELD FIRE AND EMS DEPARTMENT\n" +
        "106 STEELMAN ST\n" +
        "FAIRFIELD BORO\n" +
        "BTWN: BALDER ST & J H KANE AVE\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "PAHAGE at POS 04",

        "CALL:Helicopter Standby",
        "PRI:1",
        "PLACE:FAIRFIELD FIRE AND EMS DEPARTMENT",
        "ADDR:106 STEELMAN ST",
        "CITY:FAIRFIELD",
        "X:BALDER ST & J H KANE AVE");

    doTest("T9",
        "(Alert: Breathing Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "SKI LIBERTY\n" +
        "78 COUNTRY CLUB TRL\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: SANDERS RD & SPORTS TRL\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "She is not completely alert (not responding appropriately).\n" +
        "She has difficulty speaking between breaths.\n" +
        "Determinant: 06D01, Suffix: , Response: Class 1\n\n" +
        "CT:\n" +
        "JEKOPP at POS 01",

        "CALL:Breathing Problems - 1",
        "PRI:1",
        "PLACE:SKI LIBERTY",
        "ADDR:78 COUNTRY CLUB TRL",
        "CITY:CARROLL VALLEY",
        "X:SANDERS RD & SPORTS TRL",
        "INFO:She is not completely alert (not responding appropriately).\nShe has difficulty speaking between breaths.\nDeterminant: 06D01, Suffix: , Response: Class 1");

    doTest("T10",
        "(Alert: Unknown - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "BROWNS RANCH\n" +
        "180 REDDING LN\n" +
        "CUMBERLAND TWP\n" +
        "BTWN: DIAMOND HILL RD & BOYCOTT LN\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This is a Medical Alarm (Alert) notification.\n" +
        "He appears to be completely awake (alert).\n" +
        "He was heard talking.\n" +
        "It''s not known what he is doing now.\n" +
        "He is moving.\n" +
        "The caller doesn''t know where he is.\n" +
        "Determinant: 32B01, Suffix: , Response: Class 2\n\n" +
        "CT:\n" +
        "PAHAGE at POS 03",

        "CALL:Unknown - 2",
        "PRI:1",
        "PLACE:BROWNS RANCH",
        "ADDR:180 REDDING LN",
        "CITY:CUMBERLAND TWP",
        "X:DIAMOND HILL RD & BOYCOTT LN",
        "INFO:This is a Medical Alarm (Alert) notification.\nHe appears to be completely awake (alert).\nHe was heard talking.\nIt''s not known what he is doing now.\nHe is moving.\nThe caller doesn''t know where he is.\nDeterminant: 32B01, Suffix: , Response: Class 2");

  }
  
  @Test
  public void testAlphaFireCo1() {

    doTest("T1",
        "(Alert:) ALRM LVL: 1\nLOC:\n\nBTWN: N/A & N/A\n\n\n\nCOM:\n\n\nCT:\nWEHERR at POS 04",
        "CALL:ALERT",
        "PRI:1");

    doTest("T2",
        "(Alert: Chest Pain - 1) ALRM LVL: 1\nLOC:\n41000 SIMSON DR\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n6-15\n\nCT:\nMDGROF at POS 03",
        "CALL:Chest Pain - 1",
        "PRI:1",
        "ADDR:41000 SIMSON DR",
        "INFO:6-15");

    doTest("T3",
        "(Alert: Traumatic Injury - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "250 FEESER RD\n" +
        "GERMANY TWP\n" +
        "BTWN: BALTIMORE PIKE & ROBERTS RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "It''s not known when this happened.\n" +
        "There is no bleeding now.\n" +
        "He is completely alert (responding appropriately).\n" +
        "The injury is to the head.\n" +
        "Determinant: 30B01, Suffix: , Response: Class 2\n" +
        "The patient is a 19 year(s) male who is conscious and breathing.\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Traumatic Injury - 2",
        "PRI:1",
        "ADDR:250 FEESER RD",
        "CITY:GERMANY TWP",
        "X:BALTIMORE PIKE & ROBERTS RD",
        "INFO:It''s not known when this happened.\nThere is no bleeding now.\nHe is completely alert (responding appropriately).\nThe injury is to the head.\nDeterminant: 30B01, Suffix: , Response: Class 2\nThe patient is a 19 year(s) male who is conscious and breathing.");

    doTest("T4",
        "(Alert: Chest Pain - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "49 MARYLAND AVE\n" +
        "LITTLESTOWN BORO\n" +
        "BTWN: CLOVER LN & MYRTLE ST\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "He is completely alert (responding appropriately).\n" +
        "He is breathing normally.\n" +
        "He is changing color.\n" +
        "His color change is pale.\n" +
        "He is clammy.\n" +
        "Determinant: 10D04, Suffix: , Response: Class 1\n" +
        "The patient is a 103 year(s) male who is conscious and breathing.\n" +
        "He has had angina (heart pains) before.\n" +
        "He took a prescribed medication in the past 12 hrs: NITRO (2)\n\n" +
        "CT:\n" +
        "GABRET at POS 01",

        "CALL:Chest Pain - 1",
        "PRI:1",
        "ADDR:49 MARYLAND AVE",
        "CITY:LITTLESTOWN",
        "X:CLOVER LN & MYRTLE ST",
        "INFO:He is completely alert (responding appropriately).\nHe is breathing normally.\nHe is changing color.\nHis color change is pale.\nHe is clammy.\nDeterminant: 10D04, Suffix: , Response: Class 1\nThe patient is a 103 year(s) male who is conscious and breathing.\nHe has had angina (heart pains) before.\nHe took a prescribed medication in the past 12 hrs: NITRO (2)");

    doTest("T5",
        "(Alert: Investigation Outside) ALRM LVL: 1\n" +
        "LOC:\n" +
        "FREDERICK PIKE/GETTYSBURG RD\n" +
        "GERMANY TWP\n" +
        "BTWN: GETTYSBURG RD & HARNEY RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "SOMETHING BURNING OUTSIDE\n" +
        "E20-2-Switch Status-FREDERICK PIKE/GETTYSBURG RD, GERMANY TWP\n" +
        "E20-2-Enroute-FREDERICK PIKE/GETTYSBURG RD, GERMANY TWP\n\n" +
        "CT:\n" +
        "JESCHW at POS 03",

        "CALL:Investigation Outside",
        "PRI:1",
        "ADDR:FREDERICK PIKE & GETTYSBURG RD",
        "CITY:GERMANY TWP",
        "X:GETTYSBURG RD & HARNEY RD",
        "INFO:SOMETHING BURNING OUTSIDE\nE20-2-Switch Status-FREDERICK PIKE/GETTYSBURG RD, GERMANY TWP\nE20-2-Enroute-FREDERICK PIKE/GETTYSBURG RD, GERMANY TWP");

    doTest("T6",
        "(Alert: Investigation Outside) ALRM LVL: 1\n" +
        "LOC:\n" +
        "FREDERICK PIKE/GETTYSBURG RD\n" +
        "GERMANY TWP\n" +
        "BTWN: GETTYSBURG RD & HARNEY RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "SOMETHING BURNING OUTSIDE\n\n" +
        "CT:\n" +
        "JESCHW at POS 03",

        "CALL:Investigation Outside",
        "PRI:1",
        "ADDR:FREDERICK PIKE & GETTYSBURG RD",
        "CITY:GERMANY TWP",
        "X:GETTYSBURG RD & HARNEY RD",
        "INFO:SOMETHING BURNING OUTSIDE");

    doTest("T7",
        "(Alert: Rescue - BLS) ALRM LVL: 1\n" +
        "LOC:\n" +
        "MATHIAS RD/LINE RD\n" +
        "GERMANY TWP\n" +
        "BTWN: LINE RD & CLOUSER RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "WIRES DOWN ON A VEHICLE\n" +
        "CALLER DOESN'T KNOW WHAT TYPE OF WIRE IT IS\n" +
        "1 ADULT AND 2 CHILDREN IN THE VEHICLE\n\n" +
        "CT:\n" +
        "NBCOOK at POS 04",

        "CALL:Rescue - BLS",
        "PRI:1",
        "ADDR:MATHIAS RD & LINE RD",
        "CITY:GERMANY TWP",
        "X:LINE RD & CLOUSER RD",
        "INFO:WIRES DOWN ON A VEHICLE\nCALLER DOESN'T KNOW WHAT TYPE OF WIRE IT IS\n1 ADULT AND 2 CHILDREN IN THE VEHICLE");

    doTest("T8",
        "(Alert: Rescue - BLS) ALRM LVL: 1\n" +
        "LOC:\n" +
        "MATHIAS RD/LINE RD\n" +
        "GERMANY TWP\n" +
        "BTWN: LINE RD & CLOUSER RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "WIRES DOWN ON A VEHICLE\n" +
        "CALLER DOESN'T KNOW WHAT TYPE OF WIRE IT IS\n" +
        "1 ADULT AND 2 CHILDREN IN THE VEHICLE\n\n" +
        "CT:\n" +
        "NBCOOK at POS 04",

        "CALL:Rescue - BLS",
        "PRI:1",
        "ADDR:MATHIAS RD & LINE RD",
        "CITY:GERMANY TWP",
        "X:LINE RD & CLOUSER RD",
        "INFO:WIRES DOWN ON A VEHICLE\nCALLER DOESN'T KNOW WHAT TYPE OF WIRE IT IS\n1 ADULT AND 2 CHILDREN IN THE VEHICLE");

    doTest("T9",
        "(Alert: Rescue - BLS) ALRM LVL: 1\n" +
        "LOC:\n" +
        "MATHIAS RD/LINE RD\n" +
        "GERMANY TWP\n" +
        "BTWN: LINE RD & CLOUSER RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "WIRES DOWN ON A VEHICLE\n" +
        "CALLER DOESN'T KNOW WHAT TYPE OF WIRE IT IS\n" +
        "1 ADULT AND 2 CHILDREN IN THE VEHICLE\n\n" +
        "CT:\n" +
        "NBCOOK at POS 04",

        "CALL:Rescue - BLS",
        "PRI:1",
        "ADDR:MATHIAS RD & LINE RD",
        "CITY:GERMANY TWP",
        "X:LINE RD & CLOUSER RD",
        "INFO:WIRES DOWN ON A VEHICLE\nCALLER DOESN'T KNOW WHAT TYPE OF WIRE IT IS\n1 ADULT AND 2 CHILDREN IN THE VEHICLE");

    doTest("T10",
        "(Alert: Fire - Commercial) ALRM LVL: 1\n" +
        "LOC:\n" +
        "GETTYSBURG TOUR CENTER\n" +
        "778 BALTIMORE ST\n" +
        "GETTYSBURG BORO\n" +
        "BTWN: STEINWEHR AVE & NATIONAL CEMETERY DR\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "NBCOOK at POS 03",

        "CALL:Fire - Commercial",
        "PRI:1",
        "PLACE:GETTYSBURG TOUR CENTER",
        "ADDR:778 BALTIMORE ST",
        "CITY:GETTYSBURG",
        "X:STEINWEHR AVE & NATIONAL CEMETERY DR");

  }
  
  @Test
  public void testEastBerlinFireCompany() {

    doTest("T1",
        "(Alert:) ALRM LVL: 1\nLOC:\n\nBTWN: N/A & N/A\n\n\n\nCOM:\n\n\nCT:\nWEHERR at POS 04",
        "CALL:ALERT",
        "PRI:1");

    doTest("T2",
        "(Alert: Unknown - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "5551 PINE HILL RD\n" +
        "DOVER TWP\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS Radio\n\n" +
        "COM:\n" +
        "BOX 9-6\n" +
        "11A-Switch Status-5551 PINE HILL RD, DOVER TWP\n" +
        "11A-Enroute-5551 PINE HILL RD, DOVER TWP\n\n" +
        "CT:\n" +
        "LMBYER at POS 04",

        "CALL:Unknown - 2",
        "PRI:1",
        "ADDR:5551 PINE HILL RD",
        "CITY:DOVER TWP",
        "INFO:BOX 9-6\n11A-Switch Status-5551 PINE HILL RD, DOVER TWP\n11A-Enroute-5551 PINE HILL RD, DOVER TWP");

    doTest("T3",
        "(Alert: Unknown - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "5551 PINE HILL RD\n" +
        "DOVER TWP\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "BOX 9-6\n\n" +
        "CT:\n" +
        "LMBYER at POS 04",

        "CALL:Unknown - 2",
        "PRI:1",
        "ADDR:5551 PINE HILL RD",
        "CITY:DOVER TWP",
        "INFO:BOX 9-6");

    doTest("T4",
        "(Alert: Falls - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "6040 WINDING LN\n" +
        "PARADISE TWP\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "YORK BOX 112-30 11A\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Falls - 2",
        "PRI:1",
        "ADDR:6040 WINDING LN",
        "CITY:PARADISE TWP",
        "INFO:YORK BOX 112-30 11A");

    doTest("T5",
        "(Alert: Falls - 2) ALRM LVL: 1\nLOC:\n7636 LINCOLN HWY\nBTWN: N/A & N/A\n\n\n\nCOM:\n33-100 11A\n\nCT:\nMDGROF at POS 04",
        "CALL:Falls - 2",
        "PRI:1",
        "ADDR:7636 LINCOLN HWY",
        "INFO:33-100 11A");

    doTest("T6",
        "(Alert: Traffic Accident - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "7685 LINCOLN HWY\n" +
        "PARADISE TWP\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Traffic Accident - 2",
        "PRI:1",
        "ADDR:7685 LINCOLN HWY",
        "CITY:PARADISE TWP");

    doTest("T7",
        "(Alert: Falls - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "HARMONY HILL FARM\n" +
        "141 BATEMAN RD\n" +
        "LATIMORE TWP\n" +
        "BTWN: QUAKER CHURCH RD & RIDGE RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This happened now (less than 6hrs ago).\n" +
        "The fall was less than 10ft/3m (less than 1 story).\n" +
        "The fall was accidental.\n" +
        "There is some bleeding, not serious.\n" +
        "She is completely alert (responding appropriately).\n" +
        "The extent of her injuries is not known.\n" +
        "She is still on the floor (ground).\n" +
        "Determinant: 17B03, Suffix: G, Response: Class 2\n" +
        "AQUESTRIAN ACIDENT FELL FROM HORSE SHE HURST ALL OVER IS SITTING UP CONCIOUS ALERT\n\n" +
        "CT:\n" +
        "GABRET at POS 02",

        "CALL:Falls - 2",
        "PRI:1",
        "PLACE:HARMONY HILL FARM",
        "ADDR:141 BATEMAN RD",
        "CITY:LATIMORE TWP",
        "X:QUAKER CHURCH RD & RIDGE RD",
        "INFO:This happened now (less than 6hrs ago).\nThe fall was less than 10ft/3m (less than 1 story).\nThe fall was accidental.\nThere is some bleeding, not serious.\nShe is completely alert (responding appropriately).\nThe extent of her injuries is not known.\nShe is still on the floor (ground).\nDeterminant: 17B03, Suffix: G, Response: Class 2\nAQUESTRIAN ACIDENT FELL FROM HORSE SHE HURST ALL OVER IS SITTING UP CONCIOUS ALERT");

    doTest("T8",
        "(Alert: Unconscious - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "239 THIRD ST\n" +
        "EAST BERLIN BORO\n" +
        "BTWN: SOUTH AVE & LOCUST ST\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "It''s not known if his breathing is completely normal.\n" +
        "His breathing is INEFFECTIVE.\n" +
        "Determinant: 31D01, Suffix: , Response: Class 1\n\n" +
        "CT:\n" +
        "CAHAGE at POS 04",

        "CALL:Unconscious - 1",
        "PRI:1",
        "ADDR:239 THIRD ST",
        "CITY:EAST BERLIN",
        "X:SOUTH AVE & LOCUST ST",
        "INFO:It''s not known if his breathing is completely normal.\nHis breathing is INEFFECTIVE.\nDeterminant: 31D01, Suffix: , Response: Class 1");

    doTest("T9",
        "(Alert: Fire - Residential) ALRM LVL: 1\n" +
        "LOC:\n" +
        "10 JEFFERSON DR\n" +
        "HAMILTON TWP\n" +
        "BTWN: HAMILTON DR & END\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "SMOKE IN THE GARAGE AREA\n" +
        "ATTACHED TO HOUSE\n" +
        "ODOR AND VISISBLE\n\n" +
        "CT:\n" +
        "WEHERR at POS 03",

        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:10 JEFFERSON DR",
        "CITY:HAMILTON TWP",
        "X:HAMILTON DR & END",
        "INFO:SMOKE IN THE GARAGE AREA\nATTACHED TO HOUSE\nODOR AND VISISBLE");

    doTest("T10",
        "(Alert: Fire - Residential) ALRM LVL: 1\n" +
        "LOC:\n" +
        "10 JEFFERSON DR\n" +
        "HAMILTON TWP\n" +
        "BTWN: HAMILTON DR & END\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "SMOKE IN THE GARAGE AREA\n" +
        "ATTACHED TO HOUSE\n\n" +
        "CT:\n" +
        "WEHERR at POS 03",

        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:10 JEFFERSON DR",
        "CITY:HAMILTON TWP",
        "X:HAMILTON DR & END",
        "INFO:SMOKE IN THE GARAGE AREA\nATTACHED TO HOUSE");

  }
  
  @Test 
  public void testSoutheasternAdamsVolunteerEmergencyServices() {

    doTest("T1",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "HANOVER BRICK & BLOCK CO\n" +
        "240 BENDER RD\n" +
        "MOUNT PLEASANT TWP\n" +
        "BTWN: GEISELMAN RD & CENTENNIAL RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "MALE CON ALERT  HEAD INJ  CAR UNDER A TREE\n\n" +
        "CT:\n" +
        "SMMELH at POS 04",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "PLACE:HANOVER BRICK & BLOCK CO",
        "ADDR:240 BENDER RD",
        "CITY:MOUNT PLEASANT TWP",
        "X:GEISELMAN RD & CENTENNIAL RD",
        "INFO:MALE CON ALERT  HEAD INJ  CAR UNDER A TREE");

    doTest("T2",
        "(Alert: Assist Fire / EMS) ALRM LVL: 1\n" +
        "LOC:\n" +
        "2973 HANOVER PIKE\n" +
        "CONEWAGO TWP\n" +
        "BTWN: NARROW DR & PLEASANT VIEW DR\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "YCA49-1 REQ MED ASSIST FOR LIFTING\n\n" +
        "CT:\n" +
        "PLPETR at POS 04",

        "CALL:Assist Fire / EMS",
        "PRI:1",
        "ADDR:2973 HANOVER PIKE",
        "CITY:CONEWAGO TWP",
        "X:NARROW DR & PLEASANT VIEW DR",
        "INFO:YCA49-1 REQ MED ASSIST FOR LIFTING");

    doTest("T3",
        "(Alert: Traumatic Injury - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "2973 HANOVER PIKE\n" +
        "CONEWAGO TWP\n" +
        "BTWN: NARROW DR & PLEASANT VIEW DR\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This happened more than 6hrs ago.\n" +
        "There is no bleeding now.\n" +
        "He is completely alert (responding appropriately).\n" +
        "The injury is to a NOT DANGEROUS area.\n" +
        "Determinant: 30A02, Suffix: , Response: Class 3\n" +
        "The patient is a 33 year(s) male who is conscious and breathing.\n" +
        "DISLOCATED HIS KNEE YESTERDAY\n" +
        "UNABLE TO GET OFF THE COUCH\n" +
        "PT IS OVER 500LBS AND WILL NEED EXTRA MANPOWER\n\n" +
        "CT:\n" +
        "KNPARR at POS 04",

        "CALL:Traumatic Injury - 3",
        "PRI:1",
        "ADDR:2973 HANOVER PIKE",
        "CITY:CONEWAGO TWP",
        "X:NARROW DR & PLEASANT VIEW DR",
        "INFO:This happened more than 6hrs ago.\nThere is no bleeding now.\nHe is completely alert (responding appropriately).\nThe injury is to a NOT DANGEROUS area.\nDeterminant: 30A02, Suffix: , Response: Class 3\nThe patient is a 33 year(s) male who is conscious and breathing.\nDISLOCATED HIS KNEE YESTERDAY\nUNABLE TO GET OFF THE COUCH\nPT IS OVER 500LBS AND WILL NEED EXTRA MANPOWER");

    doTest("T4",
        "(Alert: Traffic Accident - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "280 S JEFFERSON ST\n" +
        "CONEWAGO TWP\n" +
        "BTWN: POPLAR ST & DEER DR\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "PICK UP TRUCK HIT / OTHER VEHICLE IS IN CEMETARY\n\n" +
        "CT:\n" +
        "CAHAGE at POS 03",

        "CALL:Traffic Accident - 2",
        "PRI:1",
        "ADDR:280 S JEFFERSON ST",
        "CITY:CONEWAGO TWP",
        "X:POPLAR ST & DEER DR",
        "INFO:PICK UP TRUCK HIT\nOTHER VEHICLE IS IN CEMETARY");

    doTest("T5",
        "(Alert: Alarm - CO) ALRM LVL: 1\n" +
        "LOC:\n" +
        "19 N SIXTH ST\n" +
        "MCSHERRYSTOWN BORO\n" +
        "BTWN: MAPLE ST & NORTH ST\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "CO ALARM IN MAIN LEVEL NEAR BASEMENT DOOR\n" +
        "3 IN HOUSE ALL READING ZERO NOW\n\n" +
        "CT:\n" +
        "LRSORD at POS 04",

        "CALL:Alarm - CO",
        "PRI:1",
        "ADDR:19 N SIXTH ST",
        "CITY:MCSHERRYSTOWN",
        "X:MAPLE ST & NORTH ST",
        "INFO:CO ALARM IN MAIN LEVEL NEAR BASEMENT DOOR\n3 IN HOUSE ALL READING ZERO NOW");

    doTest("T6",
        "(Alert: Fire - Residential) ALRM LVL: 1\n" +
        "LOC:\n" +
        "208 LUMBER ST\n" +
        "LITTLESTOWN BORO\n" +
        "BTWN: PARK AVE & WALNUT ST\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "QUEEN ST/LUMBER ST\n" +
        "SMOKE IS COMING OUT OF THE GARAGE\n" +
        "WHITE GARAGE\n\n" +
        "CT:\n" +
        "MMSHAN at POS 04",

        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:208 LUMBER ST",
        "CITY:LITTLESTOWN",
        "X:PARK AVE & WALNUT ST",
        "INFO:QUEEN ST/LUMBER ST\nSMOKE IS COMING OUT OF THE GARAGE\nWHITE GARAGE");

    doTest("T7",
        "(Alert: Falls - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "120 FILBERT ST\n" +
        "CONEWAGO TWP\n" +
        "BTWN: S LINCOLN DR & COUNTY LINE\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This happened now (less than 6hrs ago).\n" +
        "It''s reported that he fell at ground level.\n" +
        "The reason for the fall is not known.\n" +
        "There is no bleeding now.\n" +
        "He is not completely alert (not responding appropriately).\n" +
        "The extent of his injuries is not known.\n" +
        "Determinant: 17D03, Suffix: , Response: Class 1\n" +
        "The patient is a 29 year(s) male who is conscious and breathing.\n\n" +
        "CT:\n" +
        "SNCROU at POS 03",

        "CALL:Falls - 1",
        "PRI:1",
        "ADDR:120 FILBERT ST",
        "CITY:CONEWAGO TWP",
        "X:S LINCOLN DR & COUNTY LINE",
        "INFO:This happened now (less than 6hrs ago).\nIt''s reported that he fell at ground level.\nThe reason for the fall is not known.\nThere is no bleeding now.\nHe is not completely alert (not responding appropriately).\nThe extent of his injuries is not known.\nDeterminant: 17D03, Suffix: , Response: Class 1\nThe patient is a 29 year(s) male who is conscious and breathing.");

    doTest("T8",
        "(Alert: Unconscious - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "C & L DRYWALL\n" +
        "390 LINDEN AVE\n" +
        "D\n" +
        "CONEWAGO TWP\n" +
        "BTWN: JEFFERSON ST & WASHINGTON ST\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "His breathing is not completely normal.\n" +
        "He is not completely alert (not responding appropriately).\n" +
        "He is changing color.\n" +
        "His color change is pale.\n" +
        "Determinant: 31D03, Suffix: , Response: Class 1\n" +
        "The patient is a 24 year(s) male who is conscious and breathing.\n" +
        "He has no history of heart problems.\n" +
        "FELL OUT OF THE CAR, UNRESPONSIVE, SLOW PULSE, BREATHING\n" +
        "ALS46A OS.\n" +
        "ALS46A ADV CARDIAC ARREST\n\n" +
        "CT:\n" +
        "SNCROU at POS 04",

        "CALL:Unconscious - 1",
        "PRI:1",
        "PLACE:C & L DRYWALL",
        "ADDR:390 LINDEN AVE",
        "APT:D",
        "CITY:CONEWAGO TWP",
        "X:JEFFERSON ST & WASHINGTON ST",
        "INFO:His breathing is not completely normal.\nHe is not completely alert (not responding appropriately).\nHe is changing color.\nHis color change is pale.\nDeterminant: 31D03, Suffix: , Response: Class 1\nThe patient is a 24 year(s) male who is conscious and breathing.\nHe has no history of heart problems.\nFELL OUT OF THE CAR, UNRESPONSIVE, SLOW PULSE, BREATHING\nALS46A OS.\nALS46A ADV CARDIAC ARREST");

    doTest("T9",
        "(Alert: Investigation Inside) ALRM LVL: 1\n" +
        "LOC:\n" +
        "800 RANDOLPH ST\n" +
        "HANOVER\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "SARABINE at POS 04",

        "CALL:Investigation Inside",
        "PRI:1",
        "ADDR:800 RANDOLPH ST",
        "CITY:HANOVER");

    doTest("T10",
        "(Alert:) ALRM LVL: 1\nLOC:\nSTATION 46-3\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nSARABINE at POS 04",
        "CALL:ALERT",
        "PRI:1",
        "ADDR:STATION 46-3");
   
  }
  
  @Test
  public void testBarlowFireDepartment() {

    doTest("T1",
        "(Alert: Alarm - Fire - Commercial) ALRM LVL: 1\n" +
        "LOC:\n" +
        "ADIDAS\n" +
        "1863 GETTYSBURG VILLAGE DR\n" +
        "610\n" +
        "MOUNT JOY TWP\n" +
        "BTWN: PRIVATE & PRIVATE\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "SMOKE DETECTOR\n\n" +
        "CT:\n" +
        "GABRET at POS 04",

        "CALL:Alarm - Fire - Commercial",
        "PRI:1",
        "PLACE:ADIDAS",
        "ADDR:1863 GETTYSBURG VILLAGE DR",
        "APT:610",
        "CITY:MOUNT JOY TWP",
        "X:PRIVATE & PRIVATE",
        "INFO:SMOKE DETECTOR");

    doTest("T2",
        "(Alert: Fire - Commercial) ALRM LVL: 1\n" +
        "LOC:\n" +
        "GETTYSBURG TOUR CENTER\n" +
        "778 BALTIMORE ST\n" +
        "GETTYSBURG BORO\n" +
        "BTWN: STEINWEHR AVE & NATIONAL CEMETERY DR\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "NBCOOK at POS 03",

        "CALL:Fire - Commercial",
        "PRI:1",
        "PLACE:GETTYSBURG TOUR CENTER",
        "ADDR:778 BALTIMORE ST",
        "CITY:GETTYSBURG",
        "X:STEINWEHR AVE & NATIONAL CEMETERY DR");

    doTest("T3",
        "(Alert: Fire - Residential) ALRM LVL: 1\n" +
        "LOC:\n" +
        "60 KNIGHT RD\n" +
        "CUMBERLAND TWP\n" +
        "BTWN: TANEYTOWN RD & ROUND TOP LN\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "SMOKE IN THE HOUSE\n\n" +
        "CT:\n" +
        "PLPETR at POS 04",

        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:60 KNIGHT RD",
        "CITY:CUMBERLAND TWP",
        "X:TANEYTOWN RD & ROUND TOP LN",
        "INFO:SMOKE IN THE HOUSE");

    doTest("T4",
        "(Alert: Fire - Residential) ALRM LVL: 1\n" +
        "LOC:\n" +
        "1865 HIGHLAND AVENUE RD\n" +
        "MOUNT JOY TWP\n" +
        "BTWN: CLAPSADDLE RD & BALTIMORE PIKE\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "BLACK SMOKE COMING FROM A VENT PIPE ON THE SIDE OF THE HOUSE\n" +
        "CALLER KNOCKED ON THE DOOR BUT CANNOT GET ANYONE TO THE DOOR\n" +
        "DOES NOT KNOW IF ITS A STOVE VENT OR DRYER VENT\n" +
        "BLK SMOKE HAS STOPPED BUT CONCERNED THEIR IS A PROBLEM\n\n" +
        "CT:\n" +
        "JEKOPP at POS 02",

        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:1865 HIGHLAND AVENUE RD",
        "CITY:MOUNT JOY TWP",
        "X:CLAPSADDLE RD & BALTIMORE PIKE",
        "INFO:BLACK SMOKE COMING FROM A VENT PIPE ON THE SIDE OF THE HOUSE\nCALLER KNOCKED ON THE DOOR BUT CANNOT GET ANYONE TO THE DOOR\nDOES NOT KNOW IF ITS A STOVE VENT OR DRYER VENT\nBLK SMOKE HAS STOPPED BUT CONCERNED THEIR IS A PROBLEM");

    doTest("T5",
        "(Alert: Falls - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "1545 RIDGE RD\n" +
        "CUMBERLAND TWP\n" +
        "BTWN: CHAPEL RD & SENTZ RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This happened now (less than 6hrs ago).\n" +
        "It''s reported that she fell at ground level.\n" +
        "The fall was accidental.\n" +
        "There is no bleeding now.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She has no injuries.\n" +
        "She is still on the floor (ground).\n" +
        "Determinant: 17A03, Suffix: G, Response: Class 3\n" +
        "The patient is a 63 year(s) female who is conscious and breathing.\n" +
        "FELL FACE FORWARD INTO A RECLINER. NO APPARANT INJ.\n" +
        "PT HAS SEVERE DIARRHEA AND VOMITTING FOR 2 DAYS. CALLER AND PT STATED A HOYER LIFT WOULD BE NEEDED/ MED ASSIST DS TO HELP.\n\n" +
        "CT:\n" +
        "SNCROU at POS 04",

        "CALL:Falls - 3",
        "PRI:1",
        "ADDR:1545 RIDGE RD",
        "CITY:CUMBERLAND TWP",
        "X:CHAPEL RD & SENTZ RD",
        "INFO:This happened now (less than 6hrs ago).\nIt''s reported that she fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nShe is completely alert (responding appropriately).\nShe has no injuries.\nShe is still on the floor (ground).\nDeterminant: 17A03, Suffix: G, Response: Class 3\nThe patient is a 63 year(s) female who is conscious and breathing.\nFELL FACE FORWARD INTO A RECLINER. NO APPARANT INJ.\nPT HAS SEVERE DIARRHEA AND VOMITTING FOR 2 DAYS. CALLER AND PT STATED A HOYER LIFT WOULD BE NEEDED/ MED ASSIST DS TO HELP.");

    doTest("T6",
        "(Alert: Fire - Residential) ALRM LVL: 1\n" +
        "LOC:\n" +
        "1920 TANEYTOWN RD\n" +
        "CUMBERLAND TWP\n" +
        "BTWN: SOLOMON RD & BARLOW-GREENMOUNT RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "KNPARR at POS 04",

        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:1920 TANEYTOWN RD",
        "CITY:CUMBERLAND TWP",
        "X:SOLOMON RD & BARLOW-GREENMOUNT RD");

    doTest("T7",
        "(Alert: Traffic Accident - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "CHAPEL RD/RIDGE RD\n" +
        "CUMBERLAND TWP\n" +
        "BTWN: RIDGE RD & MARSH CREEK RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "ONE VEH FED EX TRUCK HIT POLE\n" +
        "POSSIBLE INJURY\n" +
        "ONE SUBJECT OUT WALKING AROUND\n" +
        "WIRES DOWN IN ROADWAY\n\n" +
        "CT:\n" +
        "BMPARR at POS 04",

        "CALL:Traffic Accident - 2",
        "PRI:1",
        "ADDR:CHAPEL RD & RIDGE RD",
        "CITY:CUMBERLAND TWP",
        "X:RIDGE RD & MARSH CREEK RD",
        "INFO:ONE VEH FED EX TRUCK HIT POLE\nPOSSIBLE INJURY\nONE SUBJECT OUT WALKING AROUND\nWIRES DOWN IN ROADWAY");

    doTest("T8",
        "(Alert: Fire - Brush / Wildland) ALRM LVL: 1\n" +
        "LOC:\n" +
        "560 KNIGHT RD\n" +
        "CUMBERLAND TWP\n" +
        "BTWN: ROUND TOP LN & RIDGE RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "CONTROLLED BURN  OUT OF CONTROL\n\n" +
        "CT:\n" +
        "JEKOPP at POS 03",

        "CALL:Fire - Brush / Wildland",
        "PRI:1",
        "ADDR:560 KNIGHT RD",
        "CITY:CUMBERLAND TWP",
        "X:ROUND TOP LN & RIDGE RD",
        "INFO:CONTROLLED BURN  OUT OF CONTROL");

    doTest("T9",
        "(Alert: Fire - Commercial) ALRM LVL: 1\n" +
        "LOC:\n" +
        "127 BALTIMORE ST\n" +
        "GETTYSBURG BORO\n" +
        "BTWN: LEGION ALY & HIGH ST\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "DUMPSTER FIRE NEAR STRUCTURE\n\n" +
        "CT:\n" +
        "LMBYER at POS 01",

        "CALL:Fire - Commercial",
        "PRI:1",
        "ADDR:127 BALTIMORE ST",
        "CITY:GETTYSBURG",
        "X:LEGION ALY & HIGH ST",
        "INFO:DUMPSTER FIRE NEAR STRUCTURE");

    doTest("T10",
        "(Alert: Fire - Commercial) ALRM LVL: 1\n" +
        "LOC:\n" +
        "BOYD'S BEAR COUNTRY\n" +
        "75 CUNNINGHAM RD\n" +
        "CUMBERLAND TWP\n" +
        "BTWN: EMMITSBURG RD & SHRIVER RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "SMOKE COMING FROM THE BARN\n\n" +
        "CT:\n" +
        "KNPARR at POS 04",

        "CALL:Fire - Commercial",
        "PRI:1",
        "PLACE:BOYD'S BEAR COUNTRY",
        "ADDR:75 CUNNINGHAM RD",
        "CITY:CUMBERLAND TWP",
        "X:EMMITSBURG RD & SHRIVER RD",
        "INFO:SMOKE COMING FROM THE BARN");

  }
  
  @Test
  public void testUnitedHookLadderCo33() {

    doTest("T1",
        "(Alert: Traffic Accident - 2) ALRM LVL: FP\n" +
        "LOC:\n" +
        "YORK RD/OAK DR\n" +
        "OXFORD TWP\n" +
        "BTWN: OAK DR & VILLAGE DR\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "SUBJECT OUT OF THE VEHICLE, MINOR INJURIES\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Traffic Accident - 2",
        "PRI:FP",
        "ADDR:YORK RD & OAK DR",
        "CITY:OXFORD TWP",
        "X:OAK DR & VILLAGE DR",
        "INFO:SUBJECT OUT OF THE VEHICLE, MINOR INJURIES");

    doTest("T2",
        "(Alert: Sick Person - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "29 CHINKAPIN DR\n" +
        "OXFORD TWP\n" +
        "BTWN: OAK DR & OAK DR\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "He is not completely alert (not responding appropriately).\n" +
        "Determinant: 26D01, Suffix: , Response: Class 1\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Sick Person - 1",
        "PRI:1",
        "ADDR:29 CHINKAPIN DR",
        "CITY:OXFORD TWP",
        "X:OAK DR & OAK DR",
        "INFO:He is not completely alert (not responding appropriately).\nDeterminant: 26D01, Suffix: , Response: Class 1");

    doTest("T3",
        "(Alert: Traffic Accident - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "7685 LINCOLN HWY\n" +
        "PARADISE TWP\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Traffic Accident - 2",
        "PRI:1",
        "ADDR:7685 LINCOLN HWY",
        "CITY:PARADISE TWP");

    doTest("T4",
        "(Alert: Falls - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "245 BRICK LN\n" +
        "MOUNT PLEASANT TWP\n" +
        "BTWN: DAUBERTON DR & MANOR DR\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This happened now (less than 6hrs ago).\n" +
        "It''s reported that he fell at ground level.\n" +
        "The fall was accidental.\n" +
        "There is no bleeding now.\n" +
        "He is completely alert (responding appropriately).\n" +
        "The injury is to a NOT DANGEROUS area.\n" +
        "He is still on the floor (ground).\n" +
        "Determinant: 17A01, Suffix: G, Response: Class 3\n" +
        "The patient is a 70 year(s) male who is conscious and breathing.\n" +
        "FALL WITH HIP INJURY. STILL ON FLOOR. MAY NEED TO BREAK WINDOW TO GET IN\n\n" +
        "CT:\n" +
        "GABRET at POS 04",

        "CALL:Falls - 3",
        "PRI:1",
        "ADDR:245 BRICK LN",
        "CITY:MOUNT PLEASANT TWP",
        "X:DAUBERTON DR & MANOR DR",
        "INFO:This happened now (less than 6hrs ago).\nIt''s reported that he fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nHe is completely alert (responding appropriately).\nThe injury is to a NOT DANGEROUS area.\nHe is still on the floor (ground).\nDeterminant: 17A01, Suffix: G, Response: Class 3\nThe patient is a 70 year(s) male who is conscious and breathing.\nFALL WITH HIP INJURY. STILL ON FLOOR. MAY NEED TO BREAK WINDOW TO GET IN");

    doTest("T5",
        "(Alert: Stroke / CVA - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "BRETHREN HOME\n" +
        "2990 CARLISLE PIKE\n" +
        "PERSONNEL CARE RM 3927\n" +
        "OXFORD TWP\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "She is not completely alert (not responding appropriately).\n" +
        "She is not breathing normally.\n" +
        "Other symptoms were reported: HISTORY OF STROKE\n" +
        "The stroke diagnostic results indicate partial evidence of stroke.\n" +
        "These symptoms (problem) started: 15 MIN\n" +
        "She has had a STROKE before.\n" +
        "Determinant: 28C01, Suffix: C, Response: Class 1\n" +
        "The patient is a 90 year(s) female who is conscious and breathing.\n\n" +
        "CT:\n" +
        "CAHAGE at POS 01",

        "CALL:Stroke / CVA - 1",
        "PRI:1",
        "PLACE:BRETHREN HOME",
        "ADDR:2990 CARLISLE PIKE",
        "APT:PERSONNEL CARE RM 3927",
        "CITY:OXFORD TWP",
        "INFO:She is not completely alert (not responding appropriately).\nShe is not breathing normally.\nOther symptoms were reported: HISTORY OF STROKE\nThe stroke diagnostic results indicate partial evidence of stroke.\nThese symptoms (problem) started: 15 MIN\nShe has had a STROKE before.\nDeterminant: 28C01, Suffix: C, Response: Class 1\nThe patient is a 90 year(s) female who is conscious and breathing.");

    doTest("T6",
        "(Alert: Unconscious - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "239 THIRD ST\n" +
        "EAST BERLIN BORO\n" +
        "BTWN: SOUTH AVE & LOCUST ST\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "It''s not known if his breathing is completely normal.\n" +
        "His breathing is INEFFECTIVE.\n" +
        "Determinant: 31D01, Suffix: , Response: Class 1\n" +
        "SIX STINTS IN PLACE\n\n" +
        "CT:\n" +
        "CAHAGE at POS 04",

        "CALL:Unconscious - 1",
        "PRI:1",
        "ADDR:239 THIRD ST",
        "CITY:EAST BERLIN",
        "X:SOUTH AVE & LOCUST ST",
        "INFO:It''s not known if his breathing is completely normal.\nHis breathing is INEFFECTIVE.\nDeterminant: 31D01, Suffix: , Response: Class 1\nSIX STINTS IN PLACE");

    doTest("T7",
        "(Alert: Fire - Residential) ALRM LVL: 1\n" +
        "LOC:\n" +
        "10 JEFFERSON DR\n" +
        "HAMILTON TWP\n" +
        "BTWN: HAMILTON DR & END\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "SMOKE IN THE GARAGE AREA\n" +
        "ATTACHED TO HOUSE\n\n" +
        "CT:\n" +
        "WEHERR at POS 03",

        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:10 JEFFERSON DR",
        "CITY:HAMILTON TWP",
        "X:HAMILTON DR & END",
        "INFO:SMOKE IN THE GARAGE AREA\nATTACHED TO HOUSE");

    doTest("T8",
        "(Alert: Cardiac / Respiratory Arrest - Echo) ALRM LVL: 1\n" +
        "LOC:\n" +
        "1125 ABBOTTSTOWN PIKE\n" +
        "BERWICK TWP\n" +
        "BTWN: GREEN SPRINGS RD & DEER TRAIL DR\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "Determinant: 09E01, Suffix: , Response: Class 1\n" +
        "MALE IS ICE COLD, UNKNOWN CONDITIONS\n" +
        "LAYING IN CHAIR\n" +
        "CALLER UNABLE TO START CPR\n" +
        "The patient is a 82 year(s) male who is not conscious and not breathing.\n" +
        "It''s suspected that the patient is in cardiac arrest.\n" +
        "It''s not known if a defibrillator (AED) is available.\n" +
        "S33-Switch Status-1125 ABBOTTSTOWN PIKE, BERWICK TWP\n" +
        "S33-Enroute-1125 ABBOTTSTOWN PIKE, BERWICK TWP\n\n" +
        "CT:\n" +
        "WEHERR at POS 02",

        "CALL:Cardiac / Respiratory Arrest - Echo",
        "PRI:1",
        "ADDR:1125 ABBOTTSTOWN PIKE",
        "CITY:BERWICK TWP",
        "X:GREEN SPRINGS RD & DEER TRAIL DR",
        "INFO:Determinant: 09E01, Suffix: , Response: Class 1\nMALE IS ICE COLD, UNKNOWN CONDITIONS\nLAYING IN CHAIR\nCALLER UNABLE TO START CPR\nThe patient is a 82 year(s) male who is not conscious and not breathing.\nIt''s suspected that the patient is in cardiac arrest.\nIt''s not known if a defibrillator (AED) is available.\nS33-Switch Status-1125 ABBOTTSTOWN PIKE, BERWICK TWP\nS33-Enroute-1125 ABBOTTSTOWN PIKE, BERWICK TWP");

    doTest("T9",
        "(Alert: Diabetic Emergency - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "14 PARADISE CT\n" +
        "NEW OXFORD BORO\n" +
        "BTWN: WATER WORKS RD & END\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "She is not completely alert (not responding appropriately).\n" +
        "She is not behaving normally now.\n" +
        "She is breathing normally.\n" +
        "Determinant: 13C01, Suffix: , Response: Class 1\n" +
        "The patient is a 67 year(s) female who is conscious and breathing.\n\n" +
        "CT:\n" +
        "KEDEHO at POS 04",

        "CALL:Diabetic Emergency - 1",
        "PRI:1",
        "ADDR:14 PARADISE CT",
        "CITY:NEW OXFORD",
        "X:WATER WORKS RD & END",
        "INFO:She is not completely alert (not responding appropriately).\nShe is not behaving normally now.\nShe is breathing normally.\nDeterminant: 13C01, Suffix: , Response: Class 1\nThe patient is a 67 year(s) female who is conscious and breathing.");

    doTest("T10",
        "(Alert: Unconscious - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "HARMONY RIDGE APARTMENTS\n" +
        "610 HARMONY DR\n" +
        "APT-301\n" +
        "OXFORD TWP\n" +
        "BTWN: PATIENTS ARE IN & APT BUILDING\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "Her breathing is completely normal.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is not changing color.\n" +
        "She has no history of heart problems.\n" +
        "Determinant: 31A01, Suffix: , Response: Class 3\n" +
        "The patient is a 86 year(s) female who is conscious and breathing.\n\n" +
        "CT:\n" +
        "KEDEHO at POS 04",

        "CALL:Unconscious - 3",
        "PRI:1",
        "PLACE:HARMONY RIDGE APARTMENTS",
        "ADDR:610 HARMONY DR",
        "APT:301",
        "CITY:OXFORD TWP",
        "X:PATIENTS ARE IN & APT BUILDING",
        "INFO:Her breathing is completely normal.\nShe is completely alert (responding appropriately).\nShe is not changing color.\nShe has no history of heart problems.\nDeterminant: 31A01, Suffix: , Response: Class 3\nThe patient is a 86 year(s) female who is conscious and breathing.");

  }
  
  @Test
  public void testBendersvilleCommunityFireCompany() {

    doTest("T1",
        "(Alert: Investigation Outside) ALRM LVL: 1\n" +
        "LOC:\n" +
        "1081 POTATO RD\n" +
        "MENALLEN TWP\n" +
        "BTWN: CHURCH ST & BEAR MOUNTAIN RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "NBCOOK at POS 04",

        "CALL:Investigation Outside",
        "PRI:1",
        "ADDR:1081 POTATO RD",
        "CITY:MENALLEN TWP",
        "X:CHURCH ST & BEAR MOUNTAIN RD");

    doTest("T2",
        "(Alert: Breathing Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "1410 UPPER BERMUDIAN RD\n" +
        "HUNTINGTON TWP\n" +
        "BTWN: GROUND OAK CHURCH RD & FUNT RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "He is completely alert (responding appropriately).\n" +
        "He does not have any difficulty speaking between breaths.\n" +
        "He is not changing color.\n" +
        "He is not clammy.\n" +
        "He does not have asthma.\n" +
        "N/A\n" +
        "Determinant: 06C01, Suffix: , Response: Class 1\n" +
        "The patient is a 78 year(s) male who is conscious and breathing.\n\n" +
        "CT:\n" +
        "LMBYER at POS 04",

        "CALL:Breathing Problems - 1",
        "PRI:1",
        "ADDR:1410 UPPER BERMUDIAN RD",
        "CITY:HUNTINGTON TWP",
        "X:GROUND OAK CHURCH RD & FUNT RD",
        "INFO:He is completely alert (responding appropriately).\nHe does not have any difficulty speaking between breaths.\nHe is not changing color.\nHe is not clammy.\nHe does not have asthma.\nN/A\nDeterminant: 06C01, Suffix: , Response: Class 1\nThe patient is a 78 year(s) male who is conscious and breathing.");

    doTest("T3",
        "(Alert: Animal Bite / Attack - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "270 OPOSSUM HILL RD\n" +
        "MENALLEN TWP\n" +
        "BTWN: GABLERS RD & CLINES CHURCH RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This happened now (less than 6hrs ago).\n" +
        "She was bitten/injured by a dog.\n" +
        "The animal has been locked up or captured.\n" +
        "There is some bleeding, not serious.\n" +
        "She is completely alert (responding appropriately).\n" +
        "The injury is to a NOT DANGEROUS area.\n" +
        "The bite is other than superficial, severe, or as a result of an ATTACK.\n" +
        "Determinant: 03A01, Suffix: , Response: Class 3\n" +
        "The patient is a 89 year(s) female who is conscious and breathing.\n\n" +
        "CT:\n" +
        "PAHAGE at POS 04",

        "CALL:Animal Bite / Attack - 3",
        "PRI:1",
        "ADDR:270 OPOSSUM HILL RD",
        "CITY:MENALLEN TWP",
        "X:GABLERS RD & CLINES CHURCH RD",
        "INFO:This happened now (less than 6hrs ago).\nShe was bitten/injured by a dog.\nThe animal has been locked up or captured.\nThere is some bleeding, not serious.\nShe is completely alert (responding appropriately).\nThe injury is to a NOT DANGEROUS area.\nThe bite is other than superficial, severe, or as a result of an ATTACK.\nDeterminant: 03A01, Suffix: , Response: Class 3\nThe patient is a 89 year(s) female who is conscious and breathing.");

    doTest("T4",
        "(Alert: Sick Person - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "WELLSPAN ASPERS HEALTH CENTER\n" +
        "2060 CARLISLE RD\n" +
        "MENALLEN TWP\n" +
        "BTWN: ASPERS-BENDERSVILLE RD & GABLERS RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This is apparently a generalized (grand mal) seizure.\n" +
        "He is completely alert (responding appropriately).\n" +
        "He is breathing normally.\n" +
        "He has other pain: STOMACH\n" +
        "He is not bleeding (or vomiting blood).\n" +
        "No priority symptoms (ALPHA conditions 2<128,147>11 not identified).\n" +
        "No priority symptoms (OMEGA conditions 2<128,147>28 not identified).\n" +
        "Determinant: 26A01, Suffix: , Response: Class 3\n\n" +
        "CT:\n" +
        "PAHAGE at POS 04",

        "CALL:Sick Person - 3",
        "PRI:1",
        "PLACE:WELLSPAN ASPERS HEALTH CENTER",
        "ADDR:2060 CARLISLE RD",
        "CITY:MENALLEN TWP",
        "X:ASPERS-BENDERSVILLE RD & GABLERS RD",
        "INFO:This is apparently a generalized (grand mal) seizure.\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nHe has other pain: STOMACH\nHe is not bleeding (or vomiting blood).\nNo priority symptoms (ALPHA conditions 2<128,147>11 not identified).\nNo priority symptoms (OMEGA conditions 2<128,147>28 not identified).\nDeterminant: 26A01, Suffix: , Response: Class 3");

    doTest("T5",
        "(Alert: Breathing Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "3886 CARLISLE RD\n" +
        "HUNTINGTON TWP\n" +
        "BTWN: IDAVILLE-YORK SPRINGS RD & THE COUNTY LINE\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "He is completely alert (responding appropriately).\n" +
        "He has difficulty speaking between breaths.\n" +
        "Determinant: 06D02, Suffix: , Response: Class 1\n\n" +
        "CT:\n" +
        "PLPETR at POS 04",

        "CALL:Breathing Problems - 1",
        "PRI:1",
        "ADDR:3886 CARLISLE RD",
        "CITY:HUNTINGTON TWP",
        "X:IDAVILLE-YORK SPRINGS RD & THE COUNTY LINE",
        "INFO:He is completely alert (responding appropriately).\nHe has difficulty speaking between breaths.\nDeterminant: 06D02, Suffix: , Response: Class 1");

    doTest("T6",
        "(Alert: Heart Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "WELLSPAN ASPERS HEALTH CENTER\n" +
        "2060 CARLISLE RD\n" +
        "MENALLEN TWP\n" +
        "BTWN: ASPERS-BENDERSVILLE RD & GABLERS RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "He is completely alert (responding appropriately).\n" +
        "He is breathing normally.\n" +
        "He is changing color.\n" +
        "His color change is pink.\n" +
        "He is clammy.\n" +
        "Determinant: 19D04, Suffix: , Response: Class 1\n" +
        "The patient is a 65 year(s) male who is conscious and breathing.\n" +
        "He has a history of heart problems: AFIB\n" +
        "He does not have chest pain.\n" +
        "He took a prescribed medication in the past 12 hrs: REG MEDS\n" +
        "Instructions for taking a pulse have been given.\n" +
        "His pulse is greater than or equal to 130 beats per minute.\n" +
        "SIDE ENTRANCE\n\n" +
        "CT:\n" +
        "AJHANS at POS 03",

        "CALL:Heart Problems - 1",
        "PRI:1",
        "PLACE:WELLSPAN ASPERS HEALTH CENTER",
        "ADDR:2060 CARLISLE RD",
        "CITY:MENALLEN TWP",
        "X:ASPERS-BENDERSVILLE RD & GABLERS RD",
        "INFO:He is completely alert (responding appropriately).\nHe is breathing normally.\nHe is changing color.\nHis color change is pink.\nHe is clammy.\nDeterminant: 19D04, Suffix: , Response: Class 1\nThe patient is a 65 year(s) male who is conscious and breathing.\nHe has a history of heart problems: AFIB\nHe does not have chest pain.\nHe took a prescribed medication in the past 12 hrs: REG MEDS\nInstructions for taking a pulse have been given.\nHis pulse is greater than or equal to 130 beats per minute.\nSIDE ENTRANCE");

    doTest("T7",
        "(Alert: Fire - Brush / Wildland) ALRM LVL: 1\n" +
        "LOC:\n" +
        "515 PEACH GLEN-IDAVILLE RD\n" +
        "HUNTINGTON TWP\n" +
        "BTWN: GEORGETOWN RD & STARNER STATION RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "CORN FIELD ON FIRE\n" +
        "ABOUT 100 YARDS AWAY FROM BUILDINGS\n\n" +
        "CT:\n" +
        "KEDEHO at POS 03",

        "CALL:Fire - Brush / Wildland",
        "PRI:1",
        "ADDR:515 PEACH GLEN-IDAVILLE RD",
        "CITY:HUNTINGTON TWP",
        "X:GEORGETOWN RD & STARNER STATION RD",
        "INFO:CORN FIELD ON FIRE\nABOUT 100 YARDS AWAY FROM BUILDINGS");

    doTest("T8",
        "(Alert: Alarm - Fire - Commercial) ALRM LVL: 1\n" +
        "LOC:\n" +
        "KNOUSE FOODS PEACH GLEN\n" +
        "800 PEACH GLEN-IDAVILLE RD\n" +
        "HUNTINGTON TWP\n" +
        "BTWN: STARNER STATION RD & GABLERS RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "SAME ALARM PUMP HOUSE PUMP RUN\n\n" +
        "CT:\n" +
        "KEDEHO at POS 04",

        "CALL:Alarm - Fire - Commercial",
        "PRI:1",
        "PLACE:KNOUSE FOODS PEACH GLEN",
        "ADDR:800 PEACH GLEN-IDAVILLE RD",
        "CITY:HUNTINGTON TWP",
        "X:STARNER STATION RD & GABLERS RD",
        "INFO:SAME ALARM PUMP HOUSE PUMP RUN");

    doTest("T9",
        "(Alert: Convulsions - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "140 PEACH GLEN-IDAVILLE RD\n" +
        "HUNTINGTON TWP\n" +
        "BTWN: CARLISLE RD & GEORGETOWN RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This is a FOCAL seizure.\n" +
        "She is not pregnant.\n" +
        "She is not diabetic.\n" +
        "She is an epileptic or she has had seizures before.\n" +
        "She is completely alert (responding appropriately).\n" +
        "Determinant: 12A02, Suffix: E, Response: Class 3\n" +
        "The patient is a 27 year(s) female who is conscious and breathing.\n\n" +
        "CT:\n" +
        "BMPARR at POS 04",

        "CALL:Convulsions - 1",
        "PRI:1",
        "ADDR:140 PEACH GLEN-IDAVILLE RD",
        "CITY:HUNTINGTON TWP",
        "X:CARLISLE RD & GEORGETOWN RD",
        "INFO:This is a FOCAL seizure.\nShe is not pregnant.\nShe is not diabetic.\nShe is an epileptic or she has had seizures before.\nShe is completely alert (responding appropriately).\nDeterminant: 12A02, Suffix: E, Response: Class 3\nThe patient is a 27 year(s) female who is conscious and breathing.");

    doTest("T10",
        "(Alert: Chest Pain - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "140 PEACH GLEN-IDAVILLE RD\n" +
        "HUNTINGTON TWP\n" +
        "BTWN: CARLISLE RD & GEORGETOWN RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is not breathing normally.\n" +
        "She has difficulty speaking between breaths.\n" +
        "Determinant: 10D02, Suffix: , Response: Class 1\n\n" +
        "CT:\n" +
        "JLSHEN at POS 04",

        "CALL:Chest Pain - 1",
        "PRI:1",
        "ADDR:140 PEACH GLEN-IDAVILLE RD",
        "CITY:HUNTINGTON TWP",
        "X:CARLISLE RD & GEORGETOWN RD",
        "INFO:She is completely alert (responding appropriately).\nShe is not breathing normally.\nShe has difficulty speaking between breaths.\nDeterminant: 10D02, Suffix: , Response: Class 1");

  }
  
  @Test
  public void testHamptonFireCompany() {

    doTest("T1",
        "(Alert: Fire - Residential) ALRM LVL: 1\n" +
        "LOC:\n" +
        "10 JEFFERSON DR\n" +
        "HAMILTON TWP\n" +
        "BTWN: HAMILTON DR & END\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "SMOKE IN THE GARAGE AREA\n" +
        "ATTACHED TO HOUSE\n\n" +
        "CT:\n" +
        "WEHERR at POS 03",

        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:10 JEFFERSON DR",
        "CITY:HAMILTON TWP",
        "X:HAMILTON DR & END",
        "INFO:SMOKE IN THE GARAGE AREA\nATTACHED TO HOUSE");

    doTest("T2",
        "(Alert: Transfer Fire / EMS) ALRM LVL: 1\n" +
        "LOC:\n" +
        "EAST BERLIN FIRE DEPARTMENT\n" +
        "101 E LOCUST ST\n" +
        "EAST BERLIN BORO\n" +
        "BTWN: ABBOTTSTOWN ST & STONER AVE\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "JESCHW at POS 04",

        "CALL:Transfer Fire / EMS",
        "PRI:1",
        "PLACE:EAST BERLIN FIRE DEPARTMENT",
        "ADDR:101 E LOCUST ST",
        "CITY:EAST BERLIN",
        "X:ABBOTTSTOWN ST & STONER AVE");

    doTest("T3",
        "(Alert: Fire - Chimney) ALRM LVL: 1\n" +
        "LOC:\n" +
        "YC BOX 112-32\n" +
        "884 MEETING HOUSE RD\n" +
        "PARADISE TWP\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "XST SHADY DELL ROAD\n" +
        "CHIMNEY FIRE\n\n" +
        "CT:\n" +
        "JESCHW at POS 04",

        "CALL:Fire - Chimney",
        "PRI:1",
        "PLACE:YC BOX 112-32",
        "ADDR:884 MEETING HOUSE RD",
        "CITY:PARADISE TWP",
        "INFO:XST SHADY DELL ROAD\nCHIMNEY FIRE");

    doTest("T4",
        "(Alert: Fire - Brush / Wildland) ALRM LVL: 1\n" +
        "LOC:\n" +
        "N BROWNS DAM DR/BROWNS DAM RD\n" +
        "READING TWP\n" +
        "BTWN: BROWNS DAM RD & BROWNS DAM DR\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "FIELD IS ON FIRE\n" +
        "BROWNS DAM RD AND MAKE SECOND RIGHT\n\n" +
        "CT:\n" +
        "NBCOOK at POS 01",

        "CALL:Fire - Brush / Wildland",
        "PRI:1",
        "ADDR:N BROWNS DAM DR & BROWNS DAM RD",
        "CITY:READING TWP",
        "X:BROWNS DAM RD & BROWNS DAM DR",
        "INFO:FIELD IS ON FIRE\nBROWNS DAM RD AND MAKE SECOND RIGHT");

    doTest("T5",
        "(Alert: Breathing Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "245 HOOVERS SCHOOL RD\n" +
        "READING TWP\n" +
        "BTWN: EAST BERLIN RD & STONEY POINT RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "She is completely alert (responding appropriately).\n" +
        "She has difficulty speaking between breaths.\n" +
        "Determinant: 06D02, Suffix: , Response: Class 1\n" +
        "PROQA has reconfigured the response\n" +
        "39-year-old, female, conscious, breathing.   Code: 6-D-2-A: DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma)\n" +
        "She is clammy.\n" +
        "She has asthma.\n" +
        "Reconfigured determinant: 06D02, Suffix: A, Response: Class 1\n\n" +
        "CT:\n" +
        "PAHAGE at POS 01",

        "CALL:Breathing Problems - 1",
        "PRI:1",
        "ADDR:245 HOOVERS SCHOOL RD",
        "CITY:READING TWP",
        "X:EAST BERLIN RD & STONEY POINT RD",
        "INFO:She is completely alert (responding appropriately).\nShe has difficulty speaking between breaths.\nDeterminant: 06D02, Suffix: , Response: Class 1\nPROQA has reconfigured the response\n39-year-old, female, conscious, breathing.   Code: 6-D-2-A: DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma)\nShe is clammy.\nShe has asthma.\nReconfigured determinant: 06D02, Suffix: A, Response: Class 1");

    doTest("T6",
        "(Alert: Unconscious - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "16 HAMPTON DR\n" +
        "READING TWP\n" +
        "BTWN: STONEY POINT RD & END\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "Her breathing is not completely normal.\n" +
        "Her breathing is abnormal but effective.\n" +
        "She is still unconscious.\n" +
        "Determinant: 31D02, Suffix: , Response: Class 1\n\n" +
        "CT:\n" +
        "BMPARR at POS 04",

        "CALL:Unconscious - 1",
        "PRI:1",
        "ADDR:16 HAMPTON DR",
        "CITY:READING TWP",
        "X:STONEY POINT RD & END",
        "INFO:Her breathing is not completely normal.\nHer breathing is abnormal but effective.\nShe is still unconscious.\nDeterminant: 31D02, Suffix: , Response: Class 1");

    doTest("T7",
        "(Alert:) ALRM LVL: 1\n" +
        "LOC:\n" +
        "SHARRER'S MILL\n" +
        "2220 OXFORD RD\n" +
        "TYRONE TWP\n" +
        "BTWN: SHARRER MILL RD & PLUM RUN RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "CAHAGE at POS 04",

        "CALL:ALERT",
        "PRI:1",
        "PLACE:SHARRER'S MILL",
        "ADDR:2220 OXFORD RD",
        "CITY:TYRONE TWP",
        "X:SHARRER MILL RD & PLUM RUN RD");

    doTest("T8",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "2300 OXFORD RD\n" +
        "TYRONE TWP\n" +
        "BTWN: SHARRER MILL RD & PLUM RUN RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "33A-Switch Status-2300 OXFORD RD, TYRONE TWP\n" +
        "33A-Enroute-2300 OXFORD RD, TYRONE TWP\n" +
        "M51 REQ SUPERVISOR46 AND ASST 25 REQ AIR MED ON STANDBY\n" +
        "PSP NOTIFIED AT DISP\n" +
        "STAT 13 ON STANDBY 8MIN ETA TO SCENE IF NEEDED\n" +
        "M51 ADVISING STAT 13 IN THE AIR\n" +
        "STAT 13 GIVING 8 MIN ETA WITH FIRE 3 LZ25 CONTACT\n\n" +
        "CT:\n" +
        "CAHAGE at POS 02",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:2300 OXFORD RD",
        "CITY:TYRONE TWP",
        "X:SHARRER MILL RD & PLUM RUN RD",
        "INFO:33A-Switch Status-2300 OXFORD RD, TYRONE TWP\n33A-Enroute-2300 OXFORD RD, TYRONE TWP\nM51 REQ SUPERVISOR46 AND ASST 25 REQ AIR MED ON STANDBY\nPSP NOTIFIED AT DISP\nSTAT 13 ON STANDBY 8MIN ETA TO SCENE IF NEEDED\nM51 ADVISING STAT 13 IN THE AIR\nSTAT 13 GIVING 8 MIN ETA WITH FIRE 3 LZ25 CONTACT");

    doTest("T9",
        "(Alert: Breathing Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "245 HOOVERS SCHOOL RD\n" +
        "READING TWP\n" +
        "BTWN: EAST BERLIN RD & STONEY POINT RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "SNCROU at POS 04",

        "CALL:Breathing Problems - 1",
        "PRI:1",
        "ADDR:245 HOOVERS SCHOOL RD",
        "CITY:READING TWP",
        "X:EAST BERLIN RD & STONEY POINT RD");

    doTest("T10",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "STONEY POINT RD/GERMANY RD\n" +
        "READING TWP\n" +
        "BTWN: GERMANY RD & BROUGH HILL RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "CAR IN IN FIELD 3 FEET OFF ROAD WITH BLINKERS ON\n" +
        "LEGS UNDERNEATH CAR\n" +
        "FROM HAMPTON B EFORE INTERSECTION\n\n" +
        "CT:\n" +
        "LMBYER at POS 03",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:STONEY POINT RD & GERMANY RD",
        "CITY:READING TWP",
        "X:GERMANY RD & BROUGH HILL RD",
        "INFO:CAR IN IN FIELD 3 FEET OFF ROAD WITH BLINKERS ON\nLEGS UNDERNEATH CAR\nFROM HAMPTON B EFORE INTERSECTION");
 
  }
  
  @Test
  public void testIrishtownFireCompany() {

    doTest("T1",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "2300 OXFORD RD\n" +
        "TYRONE TWP\n" +
        "BTWN: SHARRER MILL RD & PLUM RUN RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "33A-Switch Status-2300 OXFORD RD, TYRONE TWP\n" +
        "33A-Enroute-2300 OXFORD RD, TYRONE TWP\n" +
        "M51 REQ SUPERVISOR46 AND ASST 25 REQ AIR MED ON STANDBY\n" +
        "PSP NOTIFIED AT DISP\n" +
        "STAT 13 ON STANDBY 8MIN ETA TO SCENE IF NEEDED\n" +
        "M51 ADVISING STAT 13 IN THE AIR\n" +
        "STAT 13 GIVING 8 MIN ETA WITH FIRE 3 LZ25 CONTACT\n\n" +
        "CT:\n" +
        "CAHAGE at POS 02",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:2300 OXFORD RD",
        "CITY:TYRONE TWP",
        "X:SHARRER MILL RD & PLUM RUN RD",
        "INFO:33A-Switch Status-2300 OXFORD RD, TYRONE TWP\n33A-Enroute-2300 OXFORD RD, TYRONE TWP\nM51 REQ SUPERVISOR46 AND ASST 25 REQ AIR MED ON STANDBY\nPSP NOTIFIED AT DISP\nSTAT 13 ON STANDBY 8MIN ETA TO SCENE IF NEEDED\nM51 ADVISING STAT 13 IN THE AIR\nSTAT 13 GIVING 8 MIN ETA WITH FIRE 3 LZ25 CONTACT");

    doTest("T2",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "MOUNT MISERY RD/RED HILL RD\n" +
        "OXFORD TWP\n" +
        "BTWN: RED HILL RD & IRISHTOWN RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "2 VEHICLES\n" +
        "VEHICLES BLOCKING THE ROADWAY\n" +
        "1 INJURY\n" +
        "HEAD INJURY\n\n" +
        "CT:\n" +
        "BLKELC at POS 04",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:MOUNT MISERY RD & RED HILL RD",
        "CITY:OXFORD TWP",
        "X:RED HILL RD & IRISHTOWN RD",
        "INFO:2 VEHICLES\nVEHICLES BLOCKING THE ROADWAY\n1 INJURY\nHEAD INJURY");

    doTest("T3",
        "(Alert: Fire - Residential) ALRM LVL: 1\n" +
        "LOC:\n" +
        "925 IRISHTOWN RD\n" +
        "OXFORD TWP\n" +
        "BTWN: BLACK LN & KOHLER MILL RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "NBCOOK at POS 03",

        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:925 IRISHTOWN RD",
        "CITY:OXFORD TWP",
        "X:BLACK LN & KOHLER MILL RD");

    doTest("T4",
        "(Alert: Traffic Accident - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "EAST BERLIN RD/GUN CLUB RD\n" +
        "HUNTINGTON TWP\n" +
        "BTWN: GUN CLUB RD & WEIRMANS MILL RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "BOX TRUCK INTO THE WOODS ONE SUBJECT COMPLAINING  KNEE INJURY\n" +
        "VEHICLE IS LEAKING FUEL SU\n" +
        "CH 4\n" +
        "CM REQ SPILL UNIT\\\n" +
        "LOCAL EMA\n" +
        "CM 25 CALL UPPER ADAMS/BERMUDIAN SCHOOL DISTRICTS RD WILL BE\n" +
        "CLOSED FOR AWHILE\n" +
        "EMA 76 NOTIFIED AND IS GOING TO CALL COMMAND 25\n" +
        "CALLED BERMUDIAN SCHOOL DISTRICT\n" +
        "CALLED UPPER ADAMS\n" +
        "EMA 5 REQUESTING DEP BE CONTACTED\n\n" +
        "CT:\n" +
        "SMMELH at POS 01",

        "CALL:Traffic Accident - 2",
        "PRI:1",
        "ADDR:EAST BERLIN RD & GUN CLUB RD",  // Google says this is in tyrone
        "CITY:HUNTINGTON TWP",
        "X:GUN CLUB RD & WEIRMANS MILL RD",
        "INFO:BOX TRUCK INTO THE WOODS ONE SUBJECT COMPLAINING  KNEE INJURY\nVEHICLE IS LEAKING FUEL SU\nCH 4\nCM REQ SPILL UNIT\\\nLOCAL EMA\nCM 25 CALL UPPER ADAMS/BERMUDIAN SCHOOL DISTRICTS RD WILL BE\nCLOSED FOR AWHILE\nEMA 76 NOTIFIED AND IS GOING TO CALL COMMAND 25\nCALLED BERMUDIAN SCHOOL DISTRICT\nCALLED UPPER ADAMS\nEMA 5 REQUESTING DEP BE CONTACTED");

    doTest("T5",
        "(Alert: Traffic Accident w/ Entrapment) ALRM LVL: 1\n" +
        "LOC:\n" +
        "YORK RD/CARLISLE PIKE\n" +
        "HAMILTON TWP\n" +
        "BTWN: CARLISLE PIKE & STANLEY DR\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "2 CARS\n" +
        "CHANNEL 3\n\n" +
        "CT:\n" +
        "SMMELH at POS 04",

        "CALL:Traffic Accident w/ Entrapment",
        "PRI:1",
        "ADDR:YORK RD & CARLISLE PIKE",
        "CITY:HAMILTON TWP",
        "X:CARLISLE PIKE & STANLEY DR",
        "INFO:2 CARS\nCHANNEL 3");

    doTest("T6",
        "(Alert: Traffic Accident w/ Entrapment) ALRM LVL: FP\n" +
        "LOC:\n" +
        "BROWNS DAM RD/CARLISLE PIKE\n" +
        "READING TWP\n" +
        "BTWN: CARLISLE PIKE & FAWN AVE\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "TT VS PICK UP\n" +
        "1 VEHICLE POSSIBLY SMOKING\n" +
        "HEAVY ENTRAPMENT PER FP10-2\n" +
        "DRIVER IS CONSCIOUS\n\n" +
        "CT:\n" +
        "SMMELH at POS 04",

        "CALL:Traffic Accident w/ Entrapment",
        "PRI:FP",
        "ADDR:BROWNS DAM RD & CARLISLE PIKE",
        "CITY:READING TWP",
        "X:CARLISLE PIKE & FAWN AVE",
        "INFO:TT VS PICK UP\n1 VEHICLE POSSIBLY SMOKING\nHEAVY ENTRAPMENT PER FP10-2\nDRIVER IS CONSCIOUS");

    doTest("T7",
        "(Alert: Fire - Commercial) ALRM LVL: 1\n" +
        "LOC:\n" +
        "SUZI SUDS-NEW OXFORD\n" +
        "322 LINCOLNWAY E\n" +
        "OXFORD TWP\n" +
        "BTWN: BILLERBECK ST & BORO LINE\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "DRYER IS SMOKING\n\n" +
        "CT:\n" +
        "LRSORD at POS 04",

        "CALL:Fire - Commercial",
        "PRI:1",
        "PLACE:SUZI SUDS-NEW OXFORD",
        "ADDR:322 LINCOLNWAY E",
        "CITY:OXFORD TWP",
        "X:BILLERBECK ST & BORO LINE",
        "INFO:DRYER IS SMOKING");

    doTest("T8",
        "(Alert: Alarm - Fire - Commercial) ALRM LVL: 1\n" +
        "LOC:\n" +
        "BRETHREN HOME\n" +
        "2990 CARLISLE PIKE\n" +
        "OXFORD TWP\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "PERSONAL CARE SECOND FLOOR AND MAIN BUILDING\n" +
        "WILL ATTEMPT KEYHOLDER\n\n" +
        "CT:\n" +
        "AMSTON at POS 01",

        "CALL:Alarm - Fire - Commercial",
        "PRI:1",
        "PLACE:BRETHREN HOME",
        "ADDR:2990 CARLISLE PIKE",
        "CITY:OXFORD TWP",
        "INFO:PERSONAL CARE SECOND FLOOR AND MAIN BUILDING\nWILL ATTEMPT KEYHOLDER");

    doTest("T9",
        "(Alert: Fire - Brush / Wildland) ALRM LVL: 1\n" +
        "LOC:\n" +
        "901 SEVEN HUNDRED RD\n" +
        "HAMILTON TWP\n" +
        "BTWN: THE SPANGLER RD & SOLDIER CT\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "WOODS IS ON FIRE NOT IMPENDING ON ANY STRUCTURES AT THIS TIME\n\n" +
        "CT:\n" +
        "AMSTON at POS 03",

        "CALL:Fire - Brush / Wildland",
        "PRI:1",
        "ADDR:901 SEVEN HUNDRED RD",
        "CITY:HAMILTON TWP",
        "X:THE SPANGLER RD & SOLDIER CT",
        "INFO:WOODS IS ON FIRE NOT IMPENDING ON ANY STRUCTURES AT THIS TIME");

    doTest("T10",
        "(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1\n" +
        "LOC:\n" +
        "14 MARY ST\n" +
        "PARADISE TWP\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "BOX 33-100 / PARADISE TWP\n" +
        "OPS 10\n" +
        "XS ATLAND AVE\n" +
        "XS LINCOLN HIGHWAY\n" +
        "CHIEF 33 REQ\n\n" +
        "CT:\n" +
        "BMPARR at POS 04",

        "CALL:Fire - Structure Mutual Aid",
        "PRI:1",
        "ADDR:14 MARY ST",
        "CITY:PARADISE TWP",
        "INFO:BOX 33-100\nPARADISE TWP\nOPS 10\nXS ATLAND AVE\nXS LINCOLN HIGHWAY\nCHIEF 33 REQ");

  }
  
  @Test
  public void testWellspanEMS() {

    doTest("T1",
        "(Alert: Stroke / CVA - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "1035 RENTZEL RD\n" +
        "BUTLER TWP\n" +
        "BTWN: BROOKSIDE LN & BENDERS CHURCH RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "He is completely alert (responding appropriately).\n" +
        "He is breathing normally.\n" +
        "He is having sudden paralysis or facial droop on one side of the body.\n" +
        "The stroke diagnostic was not used: Skipped by user\n" +
        "These symptoms (problem) started: NOW\n" +
        "He has not had a STROKE before.\n" +
        "Determinant: 28C05, Suffix: L, Response: Class 1\n" +
        "The patient is a 70 year(s) male who is conscious and breathing.\n\n" +
        "CT:\n" +
        "WEHERR at POS 04",

        "CALL:Stroke / CVA - 1",
        "PRI:1",
        "ADDR:1035 RENTZEL RD",
        "CITY:BUTLER TWP",
        "X:BROOKSIDE LN & BENDERS CHURCH RD",
        "INFO:He is completely alert (responding appropriately).\nHe is breathing normally.\nHe is having sudden paralysis or facial droop on one side of the body.\nThe stroke diagnostic was not used: Skipped by user\nThese symptoms (problem) started: NOW\nHe has not had a STROKE before.\nDeterminant: 28C05, Suffix: L, Response: Class 1\nThe patient is a 70 year(s) male who is conscious and breathing.");

    doTest("T2",
        "(Alert:) ALRM LVL: 1\nLOC:\n\nBTWN: N/A & N/A\n\n\n\nCOM:\n\n\nCT:\nWEHERR at POS 04",
        "CALL:ALERT",
        "PRI:1");

    doTest("T3",
        "(Alert:) ALRM LVL: 1\nLOC:\n1240 GOODYEAR RD\nDICKENSON TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nLMBYER at POS 04",
        "CALL:ALERT",
        "PRI:1",
        "ADDR:1240 GOODYEAR RD",
        "CITY:DICKENSON TWP");

    doTest("T4",
        "(Alert: Breathing Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "GETTYSBURG TRAVELODGE\n" +
        "613 BALTIMORE ST\n" +
        "ROOM 215\n" +
        "GETTYSBURG BORO\n" +
        "BTWN: STEINWEHR AVE & NATIONAL CEMETERY DR\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "It''s not known if he is completely alert (responding appropriately).\n" +
        "He does not have any difficulty speaking between breaths.\n" +
        "It''s not known if he is changing color.\n" +
        "It''s not known if he is clammy.\n" +
        "It''s not known if he has asthma.\n" +
        "It''s not known if he has any special equipment or instructions to treat this.\n" +
        "Determinant: 06C01, Suffix: , Response: Class 1\n" +
        "The patient is a 58 year(s) male who is conscious and breathing.\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Breathing Problems - 1",
        "PRI:1",
        "PLACE:GETTYSBURG TRAVELODGE",
        "ADDR:613 BALTIMORE ST",
        "APT:215",
        "CITY:GETTYSBURG",
        "X:STEINWEHR AVE & NATIONAL CEMETERY DR",
        "INFO:It''s not known if he is completely alert (responding appropriately).\nHe does not have any difficulty speaking between breaths.\nIt''s not known if he is changing color.\nIt''s not known if he is clammy.\nIt''s not known if he has asthma.\nIt''s not known if he has any special equipment or instructions to treat this.\nDeterminant: 06C01, Suffix: , Response: Class 1\nThe patient is a 58 year(s) male who is conscious and breathing.");

    doTest("T5",
        "(Alert: Sick Person - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "430 GUERNSEY RD\n" +
        "BUTLER TWP\n" +
        "BTWN: W GUERNSEY RD & OLD CARLISLE RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "He is confused.\n" +
        "He is breathing normally.\n" +
        "He does not have any pain.\n" +
        "He is not bleeding (or vomiting blood).\n" +
        "Determinant: 26C01, Suffix: , Response: Class 1\n" +
        "The patient is a 86 year(s) male who is conscious and breathing.\n" +
        "His primary problem is fever/chills.\n" +
        "101.5\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Sick Person - 1",
        "PRI:1",
        "ADDR:430 GUERNSEY RD",
        "CITY:BUTLER TWP",
        "X:W GUERNSEY RD & OLD CARLISLE RD",
        "INFO:He is confused.\nHe is breathing normally.\nHe does not have any pain.\nHe is not bleeding (or vomiting blood).\nDeterminant: 26C01, Suffix: , Response: Class 1\nThe patient is a 86 year(s) male who is conscious and breathing.\nHis primary problem is fever/chills.\n101.5");

    doTest("T6",
        "(Alert: Breathing Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "GETTYSBURG LUTHERAN HOME\n" +
        "1075 OLD HARRISBURG RD\n" +
        "212B\n" +
        "STRABAN TWP\n" +
        "BTWN: PRIVATE & SHEALER RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "She is completely alert (responding appropriately).\n" +
        "She has difficulty speaking between breaths.\n" +
        "Determinant: 06D02, Suffix: , Response: Class 1\n" +
        "The patient is a 72 year(s) female who is conscious and breathing.\n" +
        "She is not changing color.\n" +
        "She is not clammy.\n" +
        "She does not have asthma.\n" +
        "N/A\n\n" +
        "CT:\n" +
        "LMBYER at POS 05",

        "CALL:Breathing Problems - 1",
        "PRI:1",
        "PLACE:GETTYSBURG LUTHERAN HOME",
        "ADDR:1075 OLD HARRISBURG RD",
        "CITY:212B",
        "X:PRIVATE & SHEALER RD",
        "INFO:She is completely alert (responding appropriately).\nShe has difficulty speaking between breaths.\nDeterminant: 06D02, Suffix: , Response: Class 1\nThe patient is a 72 year(s) female who is conscious and breathing.\nShe is not changing color.\nShe is not clammy.\nShe does not have asthma.\nN/A");

    doTest("T7",
        "(Alert: Unconscious - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "IRONHORSE REPAIR\n" +
        "2939 YORK RD\n" +
        "STRABAN TWP\n" +
        "BTWN: GRANITE STATION RD & CAREY LN\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "Her breathing is not completely normal.\n" +
        "She is not completely alert (not responding appropriately).\n" +
        "She is changing color.\n" +
        "Her color change is pink.\n" +
        "Determinant: 31D03, Suffix: , Response: Class 1\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Unconscious - 1",
        "PRI:1",
        "PLACE:IRONHORSE REPAIR",
        "ADDR:2939 YORK RD",
        "CITY:STRABAN TWP",
        "X:GRANITE STATION RD & CAREY LN",
        "INFO:Her breathing is not completely normal.\nShe is not completely alert (not responding appropriately).\nShe is changing color.\nHer color change is pink.\nDeterminant: 31D03, Suffix: , Response: Class 1");

    doTest("T8",
        "(Alert: Unconscious - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "TRANSITIONS HEALTHCARE GETTYSBURG\n" +
        "595 BIGLERVILLE RD\n" +
        "EAST SOUTH HALLWAY\n" +
        "CUMBERLAND TWP\n" +
        "BTWN: BORO LINE & HOWARD AVE\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "Her breathing is completely normal.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is not changing color.\n" +
        "It''s not known if she has a history of heart problems.\n" +
        "Determinant: 31C02, Suffix: , Response: Class 1\n" +
        "The patient is a 80 year(s) female who is conscious and breathing.\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Unconscious - 1",
        "PRI:1",
        "PLACE:TRANSITIONS HEALTHCARE GETTYSBURG",
        "ADDR:595 BIGLERVILLE RD",
        "APT:EAST SOUTH HALLWAY",
        "CITY:CUMBERLAND TWP",
        "X:BORO LINE & HOWARD AVE",
        "INFO:Her breathing is completely normal.\nShe is completely alert (responding appropriately).\nShe is not changing color.\nIt''s not known if she has a history of heart problems.\nDeterminant: 31C02, Suffix: , Response: Class 1\nThe patient is a 80 year(s) female who is conscious and breathing.");

    doTest("T9",
        "(Alert: Diabetic Emergency - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "FAIRFIELD RD/IRON SPRINGS RD\n" +
        "HAMILTONBAN TWP\n" +
        "BTWN: IRON SPRINGS RD & MCGLAUGHLIN LN\n\n" +
        "RCVD AS Officer Initiated\n\n" +
        "COM:\n" +
        "ADAMS18-3-Safety Check-FAIRFIELD RD/IRON SPRINGS RD, HAMILTONBAN TWP\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Diabetic Emergency - 1",
        "PRI:1",
        "ADDR:FAIRFIELD RD & IRON SPRINGS RD",
        "CITY:HAMILTONBAN TWP",
        "X:IRON SPRINGS RD & MCGLAUGHLIN LN",
        "INFO:ADAMS18-3-Safety Check-FAIRFIELD RD/IRON SPRINGS RD, HAMILTONBAN TWP");

    doTest("T10",
        "(Alert: Diabetic Emergency - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "718 CENTER MILLS RD\n" +
        "BUTLER TWP\n" +
        "BTWN: OLD CARLISLE RD & BULL VALLEY RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "SOUNDED LIKE A FEMALE TALKING IN THE BACKGROUND FOR A SHORT TIME THEN HUNG UP.\n" +
        "He is not completely alert (not responding appropriately).\n" +
        "He is reportedly combative or aggressive.\n" +
        "He is breathing normally.\n" +
        "Determinant: 13C01, Suffix: C, Response: Class 1\n" +
        "The patient is a 35 year(s) male who is conscious and breathing.\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Diabetic Emergency - 1",
        "PRI:1",
        "ADDR:718 CENTER MILLS RD",
        "CITY:BUTLER TWP",
        "X:OLD CARLISLE RD & BULL VALLEY RD",
        "INFO:SOUNDED LIKE A FEMALE TALKING IN THE BACKGROUND FOR A SHORT TIME THEN HUNG UP.\nHe is not completely alert (not responding appropriately).\nHe is reportedly combative or aggressive.\nHe is breathing normally.\nDeterminant: 13C01, Suffix: C, Response: Class 1\nThe patient is a 35 year(s) male who is conscious and breathing.");

  }
  
  @Test
  public void testFountaindaleFireDept() {

    doTest("T1",
        "(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1\n" +
        "LOC:\n" +
        "100 C V AVE\n" +
        "WAYNESBORO\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS Other Agency\n\n" +
        "COM:\n" +
        "FL BOX 2-01\n" +
        "JOHNSON CONTROLS\n" +
        "ET3-Switch Status-100 C V AVE, WAYNESBORO\n" +
        "ET3-Enroute-100 C V AVE, WAYNESBORO\n\n" +
        "CT:\n" +
        "GABRET at POS 04",

        "CALL:Fire - Structure Mutual Aid",
        "PRI:1",
        "ADDR:100 C V AVE",
        "CITY:WAYNESBORO",
        "INFO:FL BOX 2-01\nJOHNSON CONTROLS\nET3-Switch Status-100 C V AVE, WAYNESBORO\nET3-Enroute-100 C V AVE, WAYNESBORO");

    doTest("T2",
        "(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1\n" +
        "LOC:\n" +
        "100 RD\n" +
        "BTWN: WAYNESBORO PIKE & END\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "GABRET at POS 04",

        "CALL:Fire - Structure Mutual Aid",
        "PRI:1",
        "ADDR:100 RD",
        "X:WAYNESBORO PIKE & END");

    doTest("T3",
        "(Alert: Fire - Brush / Wildland) ALRM LVL: 1\n" +
        "LOC:\n" +
        "6833 BROWNS QUARRY RD\n" +
        "SABILLASVILLE\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "KEDEHO at POS 03",

        "CALL:Fire - Brush / Wildland",
        "PRI:1",
        "ADDR:6833 BROWNS QUARRY RD",
        "CITY:SABILLASVILLE");

    doTest("T4",
        "(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1\nLOC:\n\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nKEDEHO at POS 04",
        "CALL:Fire - Structure Mutual Aid",
        "PRI:1");

    doTest("T5",
        "(Alert:) ALRM LVL: 1\nLOC:\n12744 MONARAY LN\nWASHINGTON TWP\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nLMBYER at POS 04",
        "CALL:ALERT",
        "PRI:1",
        "ADDR:12744 MONARAY LN",
        "CITY:WASHINGTON TWP");

    doTest("T6",
        "(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1\n" +
        "LOC:\n" +
        "WASHINGTON COUNTY BOX 7-6\n" +
        "14627 PENNERSVILLE\n" +
        "WASHINGTON COUNTY\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "CS OF MACAFY HILL RD AND MD LINE HOUSE FIRE\n" +
        "ET3 AND EQ3\n\n" +
        "CT:\n" +
        "CAHAGE at POS 01",

        "CALL:Fire - Structure Mutual Aid",
        "PRI:1",
        "PLACE:WASHINGTON COUNTY BOX 7-6",
        "ADDR:14627 PENNERSVILLE",
        "CITY:WASHINGTON COUNTY",
        "ST:MD",
        "INFO:CS OF MACAFY HILL RD AND MD LINE HOUSE FIRE\nET3 AND EQ3");

    doTest("T7",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "RT 550 AT WASH CO LINE\n" +
        "FREDERICK CO\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "LRSORD at POS 03",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:RT 550 AT WASH CO LINE",
        "CITY:FREDERICK COUNTY",
        "ST:MD");

    doTest("T8",
        "(Alert: Traffic Accident - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "JACKS MOUNTAIN RD/SKYLARK TRL\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: SKYLARK TRL & CHERYL TRL\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "FIRE 3\n" +
        "1 OR 2 VEHICLES\n" +
        "3 CHILDREN IN THE VEHICLE. PT'S WERE RUBBING THEIR NECKS\n\n" +
        "CT:\n" +
        "BLKELC at POS 04",

        "CALL:Traffic Accident - 2",
        "PRI:1",
        "ADDR:JACKS MOUNTAIN RD & SKYLARK TRL",
        "CITY:CARROLL VALLEY",
        "X:SKYLARK TRL & CHERYL TRL",
        "INFO:FIRE 3\n1 OR 2 VEHICLES\n3 CHILDREN IN THE VEHICLE. PT'S WERE RUBBING THEIR NECKS");

    doTest("T9",
        "(Alert:) ALRM LVL: 1\nLOC:\nFRANKLIN CO 4\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n\n\nCT:\nLRSORD at POS 04",
        "CALL:ALERT",
        "PRI:1",
        "ADDR:FRANKLIN CO 4",
        "MADDR:FRANKLIN COUNTY ROAD 4");

    doTest("T10",
        "(Alert: Abdominal Pain - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "HILLSIDE REST HOME\n" +
        "1175 OLD WAYNESBORO RD\n" +
        "DINNING ROOM\n" +
        "HAMILTONBAN TWP\n" +
        "BTWN: TUNNEL LN & LILAC LN\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "She is completely alert (responding appropriately).\n" +
        "There was no mention of existing aortic aneurysm.\n" +
        "She had a near fainting episode.\n" +
        "Determinant: 01C04, Suffix: , Response: Class 1\n" +
        "The patient is a 40 year(s) female who is conscious and breathing.\n" +
        "FLM202-Switch Status-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD DINNING ROOM, HAMILTONBAN TWP\n" +
        "FLM202-Enroute-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD DINNING ROOM, HAMILTONBAN TWP\n\n" +
        "CT:\n" +
        "BMPARR at POS 04",

        "CALL:Abdominal Pain - 1",
        "PRI:1",
        "PLACE:HILLSIDE REST HOME",
        "ADDR:1175 OLD WAYNESBORO RD",
        "APT:DINNING ROOM",
        "CITY:HAMILTONBAN TWP",
        "X:TUNNEL LN & LILAC LN",
        "INFO:She is completely alert (responding appropriately).\nThere was no mention of existing aortic aneurysm.\nShe had a near fainting episode.\nDeterminant: 01C04, Suffix: , Response: Class 1\nThe patient is a 40 year(s) female who is conscious and breathing.\nFLM202-Switch Status-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD DINNING ROOM, HAMILTONBAN TWP\nFLM202-Enroute-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD DINNING ROOM, HAMILTONBAN TWP");

  }
  
  @Test
  public void testHeidlersburgFireCompany() {

    doTest("T1",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "2300 OXFORD RD\n" +
        "TYRONE TWP\n" +
        "BTWN: SHARRER MILL RD & PLUM RUN RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "33A-Switch Status-2300 OXFORD RD, TYRONE TWP\n" +
        "33A-Enroute-2300 OXFORD RD, TYRONE TWP\n" +
        "M51 REQ SUPERVISOR46 AND ASST 25 REQ AIR MED ON STANDBY\n" +
        "PSP NOTIFIED AT DISP\n" +
        "STAT 13 ON STANDBY 8MIN ETA TO SCENE IF NEEDED\n" +
        "M51 ADVISING STAT 13 IN THE AIR\n" +
        "STAT 13 GIVING 8 MIN ETA WITH FIRE 3 LZ25 CONTACT\n\n" +
        "CT:\n" +
        "CAHAGE at POS 02",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:2300 OXFORD RD",
        "CITY:TYRONE TWP",
        "X:SHARRER MILL RD & PLUM RUN RD",
        "INFO:33A-Switch Status-2300 OXFORD RD, TYRONE TWP\n33A-Enroute-2300 OXFORD RD, TYRONE TWP\nM51 REQ SUPERVISOR46 AND ASST 25 REQ AIR MED ON STANDBY\nPSP NOTIFIED AT DISP\nSTAT 13 ON STANDBY 8MIN ETA TO SCENE IF NEEDED\nM51 ADVISING STAT 13 IN THE AIR\nSTAT 13 GIVING 8 MIN ETA WITH FIRE 3 LZ25 CONTACT");

    doTest("T2",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "2300 OXFORD RD\n" +
        "TYRONE TWP\n" +
        "BTWN: SHARRER MILL RD & PLUM RUN RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "CAHAGE at POS 02",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:2300 OXFORD RD",
        "CITY:TYRONE TWP",
        "X:SHARRER MILL RD & PLUM RUN RD");

    doTest("T3",
        "(Alert: Traffic Accident - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "930 BENDERS CHURCH RD\n" +
        "BUTLER TWP\n" +
        "BTWN: RENTZEL RD & STONE JUG RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "VEH INTO A DITCH / UNKN IN ANYONE IS IN THE VEH\n" +
        "CALLER WAS ADVISED TO CALL BACK WITH MORE INFORMATION\n\n" +
        "CT:\n" +
        "PLPETR at POS 04",

        "CALL:Traffic Accident - 2",
        "PRI:1",
        "ADDR:930 BENDERS CHURCH RD",
        "CITY:BUTLER TWP",
        "X:RENTZEL RD & STONE JUG RD",
        "INFO:VEH INTO A DITCH\nUNKN IN ANYONE IS IN THE VEH\nCALLER WAS ADVISED TO CALL BACK WITH MORE INFORMATION");

    doTest("T4",
        "(Alert: Req For Fire Police) ALRM LVL: 1\n" +
        "LOC:\n" +
        "OLD HARRISBURG RD/HEIDLERSBURG RD\n" +
        "TYRONE TWP\n" +
        "BTWN: HEIDLERSBURG RD & ALLEY\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "REQ FOR FIRE POLICE LOW HANGING WIRE JUST WEST OF THE INTERSECTION\n" +
        "FP 9-1 ADVISED FP9-2 WAS ENROUTE TO THAT LOCATION\n\n" +
        "CT:\n" +
        "BMPARR at POS 02",

        "CALL:Req For Fire Police",
        "PRI:1",
        "ADDR:OLD HARRISBURG RD & HEIDLERSBURG RD",
        "CITY:TYRONE TWP",
        "X:HEIDLERSBURG RD & ALLEY",
        "INFO:REQ FOR FIRE POLICE LOW HANGING WIRE JUST WEST OF THE INTERSECTION\nFP 9-1 ADVISED FP9-2 WAS ENROUTE TO THAT LOCATION");

    doTest("T5",
        "(Alert: Traffic Accident - 1) ALRM LVL: FP\n" +
        "LOC:\n" +
        "23.4 US 15 NB\n" +
        "HUNTINGTON TWP\n" +
        "BTWN: S RIDGE RD & YORK SPRINGS EXIT (94)\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "2 VEHICLES HEAD ON\n" +
        "42 ADVISING 2 PT ONE W/ BACK AND STOMACH PAIN\n\n" +
        "CT:\n" +
        "NBCOOK at POS 03",

        "CALL:Traffic Accident - 1",
        "PRI:FP",
        "ADDR:23.4 US 15 NB",
        "MADDR:23.4 US 15 & S RIDGE RD",
        "CITY:HUNTINGTON TWP",
        "X:S RIDGE RD & YORK SPRINGS EXIT (94)",
        "INFO:2 VEHICLES HEAD ON\n42 ADVISING 2 PT ONE W/ BACK AND STOMACH PAIN");

    doTest("T6",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "23.4 US 15 NB\n" +
        "HUNTINGTON TWP\n" +
        "BTWN: S RIDGE RD & YORK SPRINGS EXIT (94)\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "2 VEHICLES HEAD ON\n\n" +
        "CT:\n" +
        "NBCOOK at POS 03",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:23.4 US 15 NB",
        "MADDR:23.4 US 15 & S RIDGE RD",
        "CITY:HUNTINGTON TWP",
        "X:S RIDGE RD & YORK SPRINGS EXIT (94)",
        "INFO:2 VEHICLES HEAD ON");

    doTest("T7",
        "(Alert: Breathing Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "4226 OLD HARRISBURG RD\n" +
        "BUTLER TWP\n" +
        "BTWN: PLAINVIEW RD & TWIN BRIDGE RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "REF #143170732\n" +
        "DOOR IS UNLOCKED\n" +
        "86 YEAR OLD FEMALE, TROUBLE BREATHING, IS CONSCIOUS, NO DIFFICULTY SPEAKING BETWEEN BREATHS\n" +
        "NO PAST HX KNOWN BY ALARM COMPANY\n" +
        "REQUEST EMS RESET THE LIFELINE BOX\n\n" +
        "CT:\n" +
        "KNPARR at POS 02",

        "CALL:Breathing Problems - 1",
        "PRI:1",
        "ADDR:4226 OLD HARRISBURG RD",
        "CITY:BUTLER TWP",
        "X:PLAINVIEW RD & TWIN BRIDGE RD",
        "INFO:REF #143170732\nDOOR IS UNLOCKED\n86 YEAR OLD FEMALE, TROUBLE BREATHING, IS CONSCIOUS, NO DIFFICULTY SPEAKING BETWEEN BREATHS\nNO PAST HX KNOWN BY ALARM COMPANY\nREQUEST EMS RESET THE LIFELINE BOX");

    doTest("T8",
        "(Alert: Overdose / Poisoning - Omega) ALRM LVL: 1\n" +
        "LOC:\n" +
        "651 FUNT RD\n" +
        "TYRONE TWP\n" +
        "BTWN: CRANBERRY RD & UPPER BERMUDIAN RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "This was accidental.\n" +
        "He is not changing color.\n" +
        "He is completely alert (responding appropriately).\n" +
        "He is breathing normally.\n" +
        "He has taken something unlisted in ProQA: WOOD STAIN\n" +
        "He took it now (less than 30 mins. ago).\n" +
        "Determinant: 23O01, Suffix: A, Response: Class 3\n\n" +
        "CT:\n" +
        "PLPETR at POS 01",

        "CALL:Overdose / Poisoning - Omega",
        "PRI:1",
        "ADDR:651 FUNT RD",
        "CITY:TYRONE TWP",
        "X:CRANBERRY RD & UPPER BERMUDIAN RD",
        "INFO:This was accidental.\nHe is not changing color.\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nHe has taken something unlisted in ProQA: WOOD STAIN\nHe took it now (less than 30 mins. ago).\nDeterminant: 23O01, Suffix: A, Response: Class 3");

    doTest("T9",
        "(Alert: Sick Person - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "3822 OLD HARRISBURG RD\n" +
        "STRABAN TWP\n" +
        "BTWN: STONE JUG RD & PLAINVIEW RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is breathing normally.\n" +
        "She has other pain: HIP AND LEG PAIN\n" +
        "She is not bleeding (or vomiting blood).\n" +
        "Her primary problem is general weakness.\n" +
        "Determinant: 26A05, Suffix: , Response: Class 3\n" +
        "The patient is a 92 year(s) female who is conscious and breathing.\n\n" +
        "CT:\n" +
        "PLPETR at POS 03",

        "CALL:Sick Person - 3",
        "PRI:1",
        "ADDR:3822 OLD HARRISBURG RD",
        "CITY:STRABAN TWP",
        "X:STONE JUG RD & PLAINVIEW RD",
        "INFO:She is completely alert (responding appropriately).\nShe is breathing normally.\nShe has other pain: HIP AND LEG PAIN\nShe is not bleeding (or vomiting blood).\nHer primary problem is general weakness.\nDeterminant: 26A05, Suffix: , Response: Class 3\nThe patient is a 92 year(s) female who is conscious and breathing.");

    doTest("T10",
        "(Alert: Traffic Accident - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "EAST BERLIN RD/GUN CLUB RD\n" +
        "HUNTINGTON TWP\n" +
        "BTWN: GUN CLUB RD & WEIRMANS MILL RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "BOX TRUCK INTO THE WOODS ONE SUBJECT COMPLAINING  KNEE INJURY\n" +
        "VEHICLE IS LEAKING FUEL SU\n" +
        "CH 4\n\n" +
        "CT:\n" +
        "SMMELH at POS 01",

        "CALL:Traffic Accident - 2",
        "PRI:1",
        "ADDR:EAST BERLIN RD & GUN CLUB RD",
        "CITY:HUNTINGTON TWP",
        "X:GUN CLUB RD & WEIRMANS MILL RD",
        "INFO:BOX TRUCK INTO THE WOODS ONE SUBJECT COMPLAINING  KNEE INJURY\nVEHICLE IS LEAKING FUEL SU\nCH 4");

  }
  
  @Test
  public void testBuchananValleyFireDepartment() {

    doTest("T1",
        "(Alert: Animal Stray) ALRM LVL: 1, RUN CARD: BOX 33-2\n" +
        "LOC:\n" +
        "118 BILLERBECK ST\n" +
        "OXFORD TWP\n" +
        "BTWN: LIBERTY DR & HERITAGE CT\n\n" +
        "COM:\n" +
        "FOUND DOG- GOLDEN RETRIEVER- GOLDEN IN COLOR\n" +
        "UNITS: E27,ADAMS41-11",

        "CALL:Animal Stray",
        "PRI:1, RUN CARD: BOX 33-2",
        "ADDR:118 BILLERBECK ST",
        "CITY:OXFORD TWP",
        "X:LIBERTY DR & HERITAGE CT",
        "INFO:FOUND DOG- GOLDEN RETRIEVER- GOLDEN IN COLOR",
        "UNIT:E27,ADAMS41-11");

    doTest("T2",
        "(Alert: Fire - Residential) ALRM LVL: 1, RUN CARD: BOX 5-8\n" +
        "LOC:\n" +
        "203 PEBBLE LN\n" +
        "MENALLEN TWP\n" +
        "BTWN: ROCKY RD & END\n" +
        "UNITS: ET27,S5,E5-1,6A,E7-1,E27,R6,OFFICER5,TWR5",

        "CALL:Fire - Residential",
        "PRI:1, RUN CARD: BOX 5-8",
        "ADDR:203 PEBBLE LN",
        "CITY:MENALLEN TWP",
        "X:ROCKY RD & END",
        "UNIT:ET27,S5,E5-1,6A,E7-1,E27,R6,OFFICER5,TWR5");

    doTest("T3",
        "(Alert: Stroke / CVA - 1) ALRM LVL: 1, RUN CARD: BOX 27-5\n" +
        "LOC:\n" +
        "399 MILTONBERGER RD\n" +
        "FRANKLIN TWP\n" +
        "BTWN: MOUNTAIN RD & PINEY MOUNTAIN RIDGE RD\n\n" +
        "COM:\n" +
        "72-year-old, male, conscious, breathing.   Code: 28-C-9-G: STROKE history (Greater than ___ hours since the symptoms started)\n" +
        "STROKE\n" +
        "Stroke (CVA)\n" +
        "He is completely alert (responding appropriately).\n" +
        "He is breathing normally.\n" +
        "Only the word \"stroke\" was mentioned as the Chief Complaint.\n" +
        "The caller was unable to get close enough to the patient to use the Stroke Diagnostic.\n" +
        "These symptoms (problem) started: 6 HOURS\n" +
        "He has had a STROKE before.\n" +
        "ProQA Code: 28C09 (STROKE history)\n" +
        "Suffix: G (Greater than ___ hours since the symptoms started)\n" +
        "Response: Class 1\n" +
        "UNITS: FLM7,MEDASSIST27,FLA7-7",

        "CALL:Stroke / CVA - 1",
        "PRI:1, RUN CARD: BOX 27-5",
        "ADDR:399 MILTONBERGER RD",
        "CITY:FRANKLIN TWP",
        "X:MOUNTAIN RD & PINEY MOUNTAIN RIDGE RD",
        "INFO:72-year-old, male, conscious, breathing.   Code: 28-C-9-G: STROKE history (Greater than ___ hours since the symptoms started)\nSTROKE\nStroke (CVA)\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nOnly the word \"stroke\" was mentioned as the Chief Complaint.\nThe caller was unable to get close enough to the patient to use the Stroke Diagnostic.\nThese symptoms (problem) started: 6 HOURS\nHe has had a STROKE before.\nProQA Code: 28C09 (STROKE history)\nSuffix: G (Greater than ___ hours since the symptoms started)\nResponse: Class 1",
        "UNIT:FLM7,MEDASSIST27,FLA7-7");

    doTest("T4",
        "(Alert: Falls - 2) ALRM LVL: 1, RUN CARD: BOX 27-4\n" +
        "LOC:\n" +
        "1550 NEW RD\n" +
        "FRANKLIN TWP\n" +
        "BTWN: BOTTOM RD & CHURCH RD\n\n" +
        "COM:\n" +
        "65-year-old, female, conscious, breathing.   Code: 17-B-3-G: Unknown status/Other codes not applicable (On the ground or floor)\n" +
        "wife fell\n" +
        "Falls\n" +
        "This happened now (less than 6hrs ago).\n" +
        "It''s reported that she fell at ground level.\n" +
        "The reason for the fall is not known.\n" +
        "There is no bleeding now.\n" +
        "It''s not known if she is completely alert (responding appropriately).\n" +
        "The extent of her injuries is not known.\n" +
        "She is still on the floor (ground).\n" +
        "ProQA Code: 17B03 (Unknown status/Other codes not applicable)\n" +
        "Suffix: G (On the ground or floor)\n" +
        "Response: Class 2\n" +
        "The patient is a 65 year(s) female who is conscious and breathing.\n" +
        "UNITS: MEDASSIST27,FLA7-7",

        "CALL:Falls - 2",
        "PRI:1, RUN CARD: BOX 27-4",
        "ADDR:1550 NEW RD",
        "CITY:FRANKLIN TWP",
        "X:BOTTOM RD & CHURCH RD",
        "INFO:65-year-old, female, conscious, breathing.   Code: 17-B-3-G: Unknown status/Other codes not applicable (On the ground or floor)\nwife fell\nFalls\nThis happened now (less than 6hrs ago).\nIt''s reported that she fell at ground level.\nThe reason for the fall is not known.\nThere is no bleeding now.\nIt''s not known if she is completely alert (responding appropriately).\nThe extent of her injuries is not known.\nShe is still on the floor (ground).\nProQA Code: 17B03 (Unknown status/Other codes not applicable)\nSuffix: G (On the ground or floor)\nResponse: Class 2\nThe patient is a 65 year(s) female who is conscious and breathing.",
        "UNIT:MEDASSIST27,FLA7-7");

    doTest("T5",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1, RUN CARD: BOX 27-1\n" +
        "LOC:\n" +
        "710 BUCHANAN VALLEY RD\n" +
        "FRANKLIN TWP\n" +
        "BTWN: CHURCH RD & MOUNTAIN RD\n\n" +
        "COM:\n" +
        "SINGLE VEH INTO TREE, UNK INJURY, NOT BLOCKING\n" +
        "UNITS: FLM7,ET27,R4,OFFICER27,FLA7-7",

        "CALL:Traffic Accident - 1",
        "PRI:1, RUN CARD: BOX 27-1",
        "ADDR:710 BUCHANAN VALLEY RD",
        "CITY:FRANKLIN TWP",
        "X:CHURCH RD & MOUNTAIN RD",
        "INFO:SINGLE VEH INTO TREE, UNK INJURY, NOT BLOCKING",
        "UNIT:FLM7,ET27,R4,OFFICER27,FLA7-7");

    doTest("T6",
        "(Alert: Fire - Residential) ALRM LVL: 1, RUN CARD: BOX 4-1\n" +
        "LOC:\n" +
        "305 SEVEN STARS RD\n" +
        "FRANKLIN TWP\n" +
        "BTWN: CHAMBERSBURG RD & GLENWOOD DR\n" +
        "UNITS: T4,OFFICER4,TK1,1A,ET27,E5-1,R4,E1-2,R6,E4-1",

        "CALL:Fire - Residential",
        "PRI:1, RUN CARD: BOX 4-1",
        "ADDR:305 SEVEN STARS RD",
        "CITY:FRANKLIN TWP",
        "X:CHAMBERSBURG RD & GLENWOOD DR",
        "UNIT:T4,OFFICER4,TK1,1A,ET27,E5-1,R4,E1-2,R6,E4-1");

    doTest("T7",
        "(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1, RUN CARD:\n" +
        "LOC:\n" +
        "1534 HEARTHSIDE DRIVE\n" +
        "BOX 7-4\n" +
        "GUILDORD TWP\n" +
        "BTWN: N/A & N/A\n" +
        "UNITS: ET27",

        "CALL:Fire - Structure Mutual Aid",
        "PRI:1, RUN CARD:",
        "PLACE:BOX 7-4",
        "ADDR:1534 HEARTHSIDE DRIVE",
        "CITY:GUILDORD TWP",
        "UNIT:ET27");

    doTest("T8",
        "(Alert: Investigation Outside) ALRM LVL: 1\n" +
        "LOC:\n" +
        "MISTER ED'S\n" +
        "6019 CHAMBERSBURG RD\n" +
        "FRANKLIN TWP\n" +
        "BTWN: OLD ROUTE 30 & RHODODENDRON DR\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "LARGE VOULUMN OF SMOKE IN THE AREA\n\n" +
        "CT:\n" +
        "JEKOPP at POS 03",

        "CALL:Investigation Outside",
        "PRI:1",
        "PLACE:MISTER ED'S",
        "ADDR:6019 CHAMBERSBURG RD",
        "CITY:FRANKLIN TWP",
        "X:OLD ROUTE 30 & RHODODENDRON DR",
        "INFO:LARGE VOULUMN OF SMOKE IN THE AREA");

    doTest("T9",
        "(Alert: Fire - Residential) ALRM LVL: 1\n" +
        "LOC:\n" +
        "155 NORRIS RD\n" +
        "MENALLEN TWP\n" +
        "BTWN: HEEFNER RD & PRIVATE\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "HOUSE ON FIRE NEXT TO ABOVE ADDRESS\n\n" +
        "CT:\n" +
        "PLPETR at POS 04",

        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:155 NORRIS RD",
        "CITY:MENALLEN TWP",
        "X:HEEFNER RD & PRIVATE",
        "INFO:HOUSE ON FIRE NEXT TO ABOVE ADDRESS");

    doTest("T10",
        "(Alert: Breathing Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "VILLAGE OF LAUREL RUN - TERRACE 2\n" +
        "6353 CHAMBERSBURG RD\n" +
        "FRANKLIN TWP\n" +
        "BTWN: STONEBROOK DR & DOCKWOOD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "92-year-old, female, conscious, breathing.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She has difficulty speaking between breaths.\n" +
        "Determinant: 06D02, Suffix: , Response: Class 1\n" +
        "The patient is a 92 year(s) female who is conscious and breathing.\n" +
        "She is not changing color.\n" +
        "She is not clammy.\n" +
        "She does not have asthma.\n" +
        "N/A\n\n" +
        "CT:\n" +
        "BESTRA at POS 04",

        "CALL:Breathing Problems - 1",
        "PRI:1",
        "PLACE:VILLAGE OF LAUREL RUN - TERRACE 2",
        "ADDR:6353 CHAMBERSBURG RD",
        "CITY:FRANKLIN TWP",
        "X:STONEBROOK DR & DOCKWOOD",
        "INFO:92-year-old, female, conscious, breathing.\nShe is completely alert (responding appropriately).\nShe has difficulty speaking between breaths.\nDeterminant: 06D02, Suffix: , Response: Class 1\nThe patient is a 92 year(s) female who is conscious and breathing.\nShe is not changing color.\nShe is not clammy.\nShe does not have asthma.\nN/A");

    doTest("T11",
        "(Alert: Fire - Structure Mutual Aid) ALRM LVL: 1\n" +
        "LOC:\n" +
        "1485 PARK TERRACE DR\n" +
        "BOX 17-7\n" +
        "GUILFORD TWP\n" +
        "BTWN: N/A & N/A\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "JLSHEN at POS 03",

        "CALL:Fire - Structure Mutual Aid",
        "PRI:1",
        "PLACE:1485 PARK TERRACE DR",
        "ADDR:BOX 17-7",
        "CITY:GUILFORD TWP");

  }
  
  public static void main(String[] args) {
    new PAAdamsCountyAParserTest().generateTests("T1");
  }
  
}
