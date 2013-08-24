package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Monroe County, NY (Webster) 
Contact: Matt Micsak <wfd316@gmail.com>
Sender: paging@rednmxcad.com
System: Red Alert

L: 701 AUDLEY END\nT: STRUCTURE FIRE\nO: \nB: \nC1: FINCHINGFIELD LA\nC2: WOODBRIDGE LA\nX: PLASTIC CONTAINER CAUGHT FIRE ON STOVE..COMP SAYS THAT CONTAINER IS SMOLD
L: 286 PHILLIPS RD\nT: AUTOMATIC FIRE ALARM\nO: SMELTER RES - 265451\nB:\nC1: N CHIGWELL LA\nC2: MEADOW BREEZE LA\nX: FIRE ALRM ,GEN, C/C - ONLY CORNER STREET ALRM
L: 736 BLUE CREEK DR\nT: AUTOMATIC FIRE ALARM\nO: FRANCO RESIDENCE\nB:\nC1: JOHN GLENN BL\nC2: LITHUANICA LA\nX: FIRE ALRM--SMOKE DETECTOR--UNK WHERE----C/C-----PH#
L: 1271 FAIRPRT NINE MILE PT RD\nT: MVAIA - W/INJURIES\nO:\nB:\nC1: BAINBRIDGE LA\nC2: PLANK RD\nX: PRECAUTIONARY FOR CHEST PAIN DUE TO MVA

Contact: John Overacker <joveracker@fairportfd.org>
A: FAIF BOX: 0176\nL: 2 LEWIS ST\nT: CARDIAC/RESP-NOT BREATHING\nO: \nB: \nC1: POTTER PL\nC2: FILKINS ST\nX: 46 YO/M NOT BREATHING -- COLD TO THE TOUCH

Contact: Mark Smith <smity725@gmail.com>
Sender: chilifd@rednmxcad.com
L: 50 COTTAGE GROVE CI BOX: 0622\nT: CHIE - 6D2 : TRB BREATHING- DIFF SPEAKING            \nB: ROCH PRESB  PH:\nC1: BUFFALO RD\nC2: DEAD END\nX: 43 YO F PROB BREAT

Contact: Tim Hyland <Hyland@pittsfordfd.org>
Sender: pfdcad@pittsfordfd.org
L: 25 N MAIN ST\nT: WATER PROBLEM\nO: VACANT HOUSE- APT AB\nB: \nC1: S MAIN ST\nC2: BARGE CANAL\nX: CLEAR WATER FLOODING OUTSIDE FROM APT -POURING OUT OF GAR

Contact: Active911
(Scottsville Amb.) SCOE  B:0310 1  L:19 CHILI AV ,SCO - GROUP HOME T:6D4    X: MALE 50 TROUBLE BREATHING--CLAMMY AND FEVERISH--
(Scottsville Amb.) SCOE  B:0320 2  L:521 NORTH RD ,SCO - KAYLEIGH STEELLMAN RES T:23C1   X: XFER FROM 211/CLR REQ AMB FOR 19 YO F INTOX, HX OF SUICIDAL TENDENCIES, V IOLENT, NOT ALERT, SOUNDED LIKE SHE WAS BREATHING ABNORMALLY PER 211, F H/U ON 211 
SCOE  B:0450 1P L:851 SCOTTSVILLE MUMFORD RD ,WHE T:17D3   X: 71 YO HUSBAND HAS FALLEN / NOT ALERT
SCOE B:0450 1P L:851 SCOTTSVILLE MUMFORD RD ,WHE T:17D3 X: 71 YO HUSBAND HAS FALLEN / NOT ALERT --
SCOE B:0330 4 L:2 RACE ST ,SCO T:26A1 X: 89 YO F/BLADDER INFECTION /PAIN IN URINATION AND BACK PAIN
SCOE B:0330 1 L:385 SCOTTSVILLE MUMFORD RD ,SCO -- SCOF T:TEST X: TESTING SCOE'S TONES, PLEASE DISREGARD AND HAVE A GOOD NIGHT! --
SCOE B:0310 3 L:724 NORTH RD ,SCO - ROOM 6 T:RBCST X: ,NEED A DRIVER OR A MEDIC TO COMPLETE THE CREW W/ 4M16 - GATES A4569 TAKING THE ALS PORTION --
SCOE B:0310 1 L:724 NORTH RD ,SCO - ROOM 6 T:6D4 X: 48 YO M - TRBL BREATHING - IS CLAMMY - ALERT --
SCOE B:0330 1 L:MAIN ST/RT 251 ,SCO T:29D2N X: CAR TOOK OFF OUT OF COUNTY PARK -- EJECTED ONE OF THE PPL OUT OF THE CAR -- NOW TRYING TO LOAD HER INTO CAR AND LEAVE LOOK TO BE INTOX -- BLU CAR POSS SUBU IMPREZA 4D COMPACT
SCOE B:0320 2 L:NORTH RD/ROCHESTER ST ,SCO - MOBILE GAS STATION T:EMSA X: ODOR OF NATURAL GAS INSIDE THE BLDG - M IN BACK COOKING --
SCOE B:0320 4 L:8 GENESEE ST ,SCO - JOHN HOLTZ RES T:26A2 X: 68 YO MALE - SHAKING - POSS HIGH FEVER - COMPS ETA 15 MINS TO LOC --
SCOE B:0320 4 L:498 NORTH RD ,SCO T:7A1 X: 67 YO MALE RADIATOR SPLASHED ANTI FREEZE ON HIM /BURNING ON HIS CHEST AND FACE --

Contact: Active911
Agency name: Irondequoit Ambulance
Location: Rochester, NY, United States
Sender: From: "SPARKGAP Access Gateway" <pagerchanges@monroecounty.gov>

([SAG3] Sparkgap ResponseView Message)IROE  B:0800 4  L:1884 N GOODMAN ST ,IRO T:18A1   X: 33 YO M HEADACHE \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message)IROE  B:     4  L:300 CRANBERRY LANDING DR ,IRO -- CRANBERRY LANDIN - 134 FRONT ENTRANCE T:17A3   X: 91 YO MALE RESIDENT TIPPED OVER IN SCOOTER-STILL ON FLOOR- NO INJ- \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message)IROE  B:0110 2  L:213 FILON AV ,IRO T:28C1   X: 43 YO F WIFE POSS HAD A STROKE - LEFT SIDE PARAYLSIS - NOT COMPLETELY ALERT - UNK WHEN SYMPTOMS STARTED \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message)IROE  B:     1P L:966 IRONDEQUOIT BL ,IRO T:9E1    X: 66 YO F - FOUND MOTHER ON THE FLOOR COLD AND STIFF \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message)IROE  B:     2  L:EMPIRE BL/SHELFORD RD ,IRO T:EMSA   X: DRIVER REQ AMB FOR MINOR HEAD INJ FROM MVA \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message)IROE  B:     4  L:300 CRANBERRY LANDING DR ,IRO -- CRANBERRY LANDIN - APT 132 T:17B1   X: 93YOA F FELL INJ KNEE \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message)WWBE  B:0120 4  L:000 RT 104 ,WBT -- BAY BRIDGE WB T:STREET X: DOUBLE RIGHT LANE CLOSURE FROM 1000-1400 \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message)IROE  B:0100 1  L:42 WOODRIDGE CT ,IRO - APT #6 T:21D3   X: 34 YO F W/ SERIOUS RECTAL BLEEDING \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message)IROE  B:0220 4  L:320 LIBERTY AV ,IRO - ARENA RES/2661695 T:32B2   X: MED ALRM ..UNK AGE M, REQ AMB..TOLD AMB HE WASNT FEELING WELL.. ALRM CO HAS NO ADDITIONAL INFO \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message)IROE  B:     2  L:613 HURSTBOURNE RD ,IRO T:19C4   X: 70 YOA M - FAST HEART RATE - 110 B P M \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message)IROE  B:0802 2  L:225 BROOKDALE PK ,IRO T:31C2   X: 61 YO M PASSED OUT 2 TIMES / AWAKE AND BREATHING NORMAL/ HEART HX \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message)IROE  B:     4  L:124 EDGECREEK TR ,IRO T:1A1    X: 26 YO M ABDOMINAL PAINS \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message)IROE  B:0304 1  L:100 KINGS HW S ,IRO - REIDMAN CAMPUS AT RGH T:19D4   X: 31 YO FEM POSS SVT..HANDS ARE BLUE,SHE IS PAIL \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message) CTYF  B: 112 2  L:179 ST PAUL ST ,ROC - 179-181 SEARLE BUILDING 442-6150 T:AMTCA  X:  FIRE ALRM--4TH FLOOR ELEVATOR PULL \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
([SAG3] Sparkgap ResponseView Message) CTYF  B: 313 1  L:511 E MAIN ST ,ROC - DBM FOOD MARKET T:FUMSA  X:  SMELL OF NATURAL GAS INSIDE THE STORE - RG&E 1 HR ETA \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.

Contact: Active911
Agency name: Hamlin Morton Walker Fire Dist.
Location: Hamlin, NY, United States
Sender: "SPARKGAP Access Gateway" <pagerchanges@monroecounty.gov>

([SAG3] Sparkgap ResponseView Message) MORF  B:0813 3  L:3004 CHURCH RD ,HAM T:RBCST  X:  ,NEED A EMS CREW FOR 217 FOR THE OVERDOSE \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message) MORF  B:0813 4  L:3004 CHURCH RD ,HAM T:25B3V  X:  2ND PTY - MOTHER AND BROTHER AT LOC - MOTHER POSS THREATENING SUICIDE POSS VIA PILLS - UNK WEAPS -MOTHERS NAME COLLEEN CLARK -POSS BEING ABUSIVE TO BROTHER TOOK PHONE AWAY FROM HI\n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message) MORF  B:0813 4  L:3004 CHURCH RD ,HAM T:25B3V  X:2ND PTY - MOTHER AND BROTHER AT LOC - MOTHER POSS THREATENING SUICIDE POSS VIA PILLS - UNK WEAPS -MOTHERS NAME COLLEEN CLARK -POSS BEING ABUSIVE TO BROTHER TOOK PHONE AWAY FROM HIM \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message) MORF  B: 2  L:1932 KENDALL RD - ELEMENTARY SCHOOL T:AMTCA  X:  AUTOMATIC ALRM / HAMF AS RIC/ MORF PUMPER AND RESCUE \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message) MORF  B: 2  L:1932 KENDALL RD ,KEN - ELEMENTARY SCHOOL T:AMTCA  X:  AUTOMATIC ALARM/ MUTUAL ASSIST MORF 1 PUMPER AND 1 RESCUE / HAMF RIC \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message) MORF  B:0910 1  L:17230 CREEK RD ,KEN T:FIREA  X:  MALE DWN OUTSIDE BY 4 WHEELER, NOT BREATHING \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message) MORF  B:0910 1  L:17230 CREEK RD ,KEN T:FIREA  X:MALE DWN OUTSIDE BY 4 WHEELER, NOT BREATHING \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message) HAMF  B:0304 2  L:18 OAK DR ,HAM T:26C1   X:  87 YO /F / CONFUSED / WONT GET OUT OF BED \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message) MORF  B:0818 3  L:4500 ROOSEVELT HW ,HAM - LOT 20 T:RBCST  X:  ,NEED DRIVER OR MEDIC FOR THE SQUAD \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message) MORF  B:0818 4  L:4500 ROOSEVELT HW ,HAM - LOT 20 T:17B1   X:  40 YO / F / FELL OF TOILET / WHEEL CHAIR BOUND / HIT HEAD \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message) MORF  B:0818 4  L:4500 ROOSEVELT HW ,HAM - LOT 20 T:17B1   X:40 YO / F / FELL OF TOILET / WHEEL CHAIR BOUND / HIT HEAD \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message) WLKF  B:0703 3  L:446 MARTIN RD ,HAM T:FUMSB  X:  CARBON MONOXIDE ALRM GOING OFF- -NO REPORTED ILLNESS- ADVISED TO WAIT OUTSIDE- \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n
([SAG3] Sparkgap ResponseView Message) WLKF  B:620A 2  L:5796 W WAUTOMA BEACH ,HAM T:23C1   X:  57 YO F-NOT ALERT-TOOK PILLS, UNK WHEN -COMPL CAME HOME TO FIND HER ON THE GROUND WITH PILLS AROUND HER DUTAL-ASA-CASS, PIPHENHYDRANINE \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.\n

Contact: Active911
Agency name: Spencerport Fire Department
Location: Spencerport, NY, United States
Sender: messaging@iamresponding.com

(Spencerport Fire) SPEF  B:0213 1   3227 BIG RIDGE RD ,OGD T:FIREA  X:,GATES AMB COVERING CALL FOR F POSS HAVING A STROKE \n\n-- Confidentiality
(Spencerport Fire) SPEF  B:5132 2   26 SLAYTON AV ,SPE - SLAYTON PLACE RESTAURANT-352-0260 T:AMTCA  X:AUTOMATIC FIRE ALARM - DUCT DETECTOR - CC \n\n-- Confidentiality
(Spencerport Fire) SPEF  B:4314 1   128 NORWICH DR ,OGD - SPEARY- 5942542 T:FIREA  X:,GATES AMB COVERING P-3 CALL -- 79 YO FEMALE UNABLE TO GET OFF TOILET \n\n-- Confidentiality
(Spencerport Fire) SPEF  B:0122 1P  17 GLENN HAVEN ,OGD - APT A T:9E1    X:88 YO MALE FOUND PASSED AWAY IN THE BATHROOM BY HIS SON \n\n-- Confidentiality
(Spencerport Fire) SPEF  B:4314 2   73 WINDSORSHIRE DR ,OGD - LIFETIME ASSISTANCE PH # 5940560 T:AMTCA  X:FIRE ALARM - PULL STATION - C/C \n\n-- Confidentiality
(Spencerport Fire) SPEF  B:0231 2P  4802 W RIDGE RD ,PAR T:FIREB  X:NEED FD FOR RADIATOR FLUID AND EMS FOR PRECAUTION-NO NEED FOR 77 \n\n-- Confidentiality
(Spencerport Fire) SPEF  B:0153 2P L:3389 BROCKPORT SPENCERPRT RD ,OGD T:FIREB  X:REQ FIRE TO CUT UP TREE AND REMOVE FROM ROAD - TREE IS COMPLETELY BLKG \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
(Spencerport Fire) SPEF  B: 2  L:2215 LONG POND RD ,GAT T:FILLIN X:ENGING FROM SPEF TO FILL IN \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
(Spencerport Fire) SPEF  B:0252 3  L:3 WALNUT HILL DR ,PAR - IN AREA... T:RBCST  X: \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
(Spencerport Fire) SPEF  B:0252 2P L:3 WALNUT HILL DR ,PAR - IN AREA... T:FIREB  X:STRONG BURNING ODOR WHEN SHE STEPS OUTSIDE --- HAZY TYPE APPEARANCE BUT DOESNT SEEM TO BE SMOKE - SAYS IF SHE HAD TO GUESS IT WAS ORIGINATING FROM THE PINE HILL RD AR\n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
(Spencerport Fire) SPEF  B:0223 4  L:3482 BIG RIDGE RD ,OGD T:29B1   X:1 VEH - IN COMPS LAWN - ELDERLY F OUT OF VEH ON GROUND \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
(Spencerport Fire) SPEF  B:0241 2P L:5028 W RIDGE RD ,PAR - HESS T:FIREB  X:ODOR OF PROPANE W/U TO THE FIREHOUSE \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
(Spencerport Fire) SPEF  B:0143 1  L:42 NICHOLS ST ,SPE -- STRONG URGENT CAR T:FIREA  X:,EMS 23 Y/O/F VOMITING BLOOD TROUBLE BREATHING GATES AMB TO COVER \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
(Spencerport Fire) SPEF  B:0121 1P L:44 THISTLEWOOD LA ,OGD T:9E1    X:F - 64 - NOT BREATHING - IS COLD - ON THE FLOOR \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
(Spencerport Fire) SPEF  B:0232 1  L:OGDEN PARMA T L RD/UNION ST ,PAR - ON UNION T:29D2P  X:TRUCK ROLLED OVER ON ITS SIDE, MALE STILL IN DRIVERS SEAT \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
(Spencerport Fire) SPEF  B:0232 1  L:OGDEN PARMA T L RD/UNION ST ,PAR T:29D2P  X:TRUCK ROLLED OVER ON ITS SIDE, MALE STILL IN DRIVERS SEAT \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
(Spencerport Fire) SPEF  B:4233 3  L:203 CEDAR CI ,OGD T:FUMSB  X:CO DETECTOR ACTIVATED \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
(Spencerport Fire) SPEF  B:0335 2  L:47 BREWERTON DR ,OGD - CLARICE ROW - 594 1810 T:AMTCA  X:FIRE ALRM - 1ST FLR SMOKE DETECTOR - UNABLE TO REACH CONTACTS \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
(Spencerport Fire) SPEF  B:0152 3  L:46 SARAH CI ,OGD - POHLEVEN RESD - 349.0139 T:FUMSB  X:CARBON MONIXIDE ALRM FROM BASEMENT -CC \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.
(Spencerport Fire) SPEF  B:0252 1  L:485 TRIMMER RD ,PAR T:FIREA  X:,REQ FIRERESPOND FOR ALLERGIC REACTION TO A BEE STING - MONE COVERING \n\n-- Confidentiality Notice --\nThis email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\nincluding attachments.

Contact: "Damon, Chris" <cdamon@spencerportfire.org>
Sender: messaging@iamresponding.com
(Spencerport Fire) BROF  B:4513 3   19 MERCER ST ,BRO T:RBCST  X:,NEED A DRIVER FOR F2914 \n\n-- Confidentiality

*/
public class NYMonroeCountyWebsterParserTest extends BaseParserTest {
  
  public NYMonroeCountyWebsterParserTest() {
    setParser(new NYMonroeCountyWebsterParser(), "MONROE COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "L: 701 AUDLEY END\nT: STRUCTURE FIRE\nO: \nB: \nC1: FINCHINGFIELD LA\nC2: WOODBRIDGE LA\nX: PLASTIC CONTAINER CAUGHT FIRE ON STOVE..COMP SAYS THAT CONTAINER IS SMOLD",
        "ADDR:701 AUDLEY END",
        "CALL:STRUCTURE FIRE",
        "X:FINCHINGFIELD LA & WOODBRIDGE LA",
        "INFO:PLASTIC CONTAINER CAUGHT FIRE ON STOVE..COMP SAYS THAT CONTAINER IS SMOLD");

    doTest("T2",
        "L: 286 PHILLIPS RD\nT: AUTOMATIC FIRE ALARM\nO: SMELTER RES - 265451\nB:\nC1: N CHIGWELL LA\nC2: MEADOW BREEZE LA\nX: FIRE ALRM ,GEN, C/C - ONLY CORNER STREET ALRM",
        "ADDR:286 PHILLIPS RD",
        "CALL:AUTOMATIC FIRE ALARM",
        "NAME:SMELTER RES - 265451",
        "X:N CHIGWELL LA & MEADOW BREEZE LA",
        "INFO:FIRE ALRM ,GEN, C/C - ONLY CORNER STREET ALRM");

    doTest("T3",
        "L: 736 BLUE CREEK DR\nT: AUTOMATIC FIRE ALARM\nO: FRANCO RESIDENCE\nB:\nC1: JOHN GLENN BL\nC2: LITHUANICA LA\nX: FIRE ALRM--SMOKE DETECTOR--UNK WHERE----C/C-----PH#",
        "ADDR:736 BLUE CREEK DR",
        "CALL:AUTOMATIC FIRE ALARM",
        "NAME:FRANCO RESIDENCE",
        "X:JOHN GLENN BL & LITHUANICA LA",
        "INFO:FIRE ALRM--SMOKE DETECTOR--UNK WHERE----C/C-----PH#");

    doTest("T4",
        "L: 1271 FAIRPRT NINE MILE PT RD\nT: MVAIA - W/INJURIES\nO:\nB:\nC1: BAINBRIDGE LA\nC2: PLANK RD\nX: PRECAUTIONARY FOR CHEST PAIN DUE TO MVA",
        "ADDR:1271 FAIRPRT NINE MILE PT RD",
        "CALL:MVAIA - W/INJURIES",
        "X:BAINBRIDGE LA & PLANK RD",
        "INFO:PRECAUTIONARY FOR CHEST PAIN DUE TO MVA");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "A: FAIF BOX: 0176\nL: 2 LEWIS ST\nT: CARDIAC/RESP-NOT BREATHING\nO: \nB: \nC1: POTTER PL\nC2: FILKINS ST\nX: 46 YO/M NOT BREATHING -- COLD TO THE TOUCH",
        "BOX:0176",
        "ADDR:2 LEWIS ST",
        "CALL:CARDIAC/RESP-NOT BREATHING",
        "X:POTTER PL & FILKINS ST",
        "INFO:46 YO/M NOT BREATHING -- COLD TO THE TOUCH");

  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "L: 50 COTTAGE GROVE CI BOX: 0622\nT: CHIE - 6D2 : TRB BREATHING- DIFF SPEAKING            \nB: ROCH PRESB  PH:\nC1: BUFFALO RD\nC2: DEAD END\nX: 43 YO F PROB BREAT",
        "ADDR:50 COTTAGE GROVE CI",
        "MADDR:50 COTTAGE GROVE CIR",
        "BOX:0622",
        "CALL:CHIE - 6D2 : TRB BREATHING- DIFF SPEAKING",
        "PLACE:ROCH PRESB",
        "X:BUFFALO RD & DEAD END",
        "INFO:43 YO F PROB BREAT");
  }
  
  @Test
  public void testTimHyland() {

    doTest("T1",
        "L: 25 N MAIN ST\n" +
        "T: WATER PROBLEM\n" +
        "O: VACANT HOUSE- APT AB\n" +
        "B: \n" +
        "C1: S MAIN ST\n" +
        "C2: BARGE CANAL\n" +
        "X: CLEAR WATER FLOODING OUTSIDE FROM APT -POURING OUT OF GAR",

        "ADDR:25 N MAIN ST",
        "X:S MAIN ST & BARGE CANAL",
        "CALL:WATER PROBLEM",
        "NAME:VACANT HOUSE- APT AB",
        "INFO:CLEAR WATER FLOODING OUTSIDE FROM APT -POURING OUT OF GAR");
 
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "(Scottsville Amb.) SCOE  B:0310 1  L:19 CHILI AV ,SCO - GROUP HOME T:6D4    X: MALE 50 TROUBLE BREATHING--CLAMMY AND FEVERISH--",
        "SRC:SCOE",
        "BOX:0310",
        "PRI:1",
        "ADDR:19 CHILI AV",
        "MADDR:19 CHILI AVE",
        "CITY:SCOTTSVILLE",
        "PLACE:GROUP HOME",
        "CODE:6D4",
        "CALL:Breathing Problems - Clammy",
        "INFO:MALE 50 TROUBLE BREATHING--CLAMMY AND FEVERISH--");

    doTest("T2",
        "(Scottsville Amb.) SCOE  B:0320 2  L:521 NORTH RD ,SCO - KAYLEIGH STEELLMAN RES T:23C1   X: XFER FROM 211/CLR REQ AMB FOR 19 YO F INTOX, HX OF SUICIDAL TENDENCIES, V IOLENT, NOT ALERT, SOUNDED LIKE SHE WAS BREATHING ABNORMALLY PER 211, F H/U ON 211 ",
        "SRC:SCOE",
        "BOX:0320",
        "PRI:2",
        "ADDR:521 NORTH RD",
        "CITY:SCOTTSVILLE",
        "PLACE:KAYLEIGH STEELLMAN RES",
        "CODE:23C1",
        "CALL:Overdose - Not alert",
        "INFO:XFER FROM 211/CLR REQ AMB FOR 19 YO F INTOX, HX OF SUICIDAL TENDENCIES, V IOLENT, NOT ALERT, SOUNDED LIKE SHE WAS BREATHING ABNORMALLY PER 211, F H/U ON 211");

    doTest("T3",
        "SCOE  B:0450 1P L:851 SCOTTSVILLE MUMFORD RD ,WHE T:17D3   X: 71 YO HUSBAND HAS FALLEN / NOT ALERT",
        "SRC:SCOE",
        "BOX:0450",
        "PRI:1P",
        "ADDR:851 SCOTTSVILLE MUMFORD RD",
        "CITY:WHEATLAND",
        "CODE:17D3",
        "CALL:Fall - Not alert",
        "INFO:71 YO HUSBAND HAS FALLEN / NOT ALERT");

    doTest("T4",
        "SCOE B:0450 1P L:851 SCOTTSVILLE MUMFORD RD ,WHE T:17D3 X: 71 YO HUSBAND HAS FALLEN / NOT ALERT --",
        "SRC:SCOE",
        "BOX:0450",
        "PRI:1P",
        "ADDR:851 SCOTTSVILLE MUMFORD RD",
        "CITY:WHEATLAND",
        "CODE:17D3",
        "CALL:Fall - Not alert",
        "INFO:71 YO HUSBAND HAS FALLEN / NOT ALERT --");

    doTest("T5",
        "SCOE B:0330 4 L:2 RACE ST ,SCO T:26A1 X: 89 YO F/BLADDER INFECTION /PAIN IN URINATION AND BACK PAIN",
        "SRC:SCOE",
        "BOX:0330",
        "PRI:4",
        "ADDR:2 RACE ST",
        "CITY:SCOTTSVILLE",
        "CODE:26A1",
        "CALL:Sick - No priority symptoms",
        "INFO:89 YO F/BLADDER INFECTION /PAIN IN URINATION AND BACK PAIN");

    doTest("T6",
        "SCOE B:0330 1 L:385 SCOTTSVILLE MUMFORD RD ,SCO -- SCOF T:TEST X: TESTING SCOE'S TONES, PLEASE DISREGARD AND HAVE A GOOD NIGHT! --",
        "SRC:SCOE",
        "BOX:0330",
        "PRI:1",
        "ADDR:385 SCOTTSVILLE MUMFORD RD",
        "CITY:SCOTTSVILLE",
        "PLACE:SCOF",
        "CALL:TEST",
        "INFO:TESTING SCOE'S TONES, PLEASE DISREGARD AND HAVE A GOOD NIGHT! --");

    doTest("T7",
        "SCOE B:0310 3 L:724 NORTH RD ,SCO - ROOM 6 T:RBCST X: ,NEED A DRIVER OR A MEDIC TO COMPLETE THE CREW W/ 4M16 - GATES A4569 TAKING THE ALS PORTION --",
        "SRC:SCOE",
        "BOX:0310",
        "PRI:3",
        "ADDR:724 NORTH RD",
        "CITY:SCOTTSVILLE",
        "PLACE:ROOM 6",
        "CALL:RBCST",
        "INFO:NEED A DRIVER OR A MEDIC TO COMPLETE THE CREW W/ 4M16 - GATES A4569 TAKING THE ALS PORTION --");

    doTest("T8",
        "SCOE B:0310 1 L:724 NORTH RD ,SCO - ROOM 6 T:6D4 X: 48 YO M - TRBL BREATHING - IS CLAMMY - ALERT --",
        "SRC:SCOE",
        "BOX:0310",
        "PRI:1",
        "ADDR:724 NORTH RD",
        "CITY:SCOTTSVILLE",
        "PLACE:ROOM 6",
        "CODE:6D4",
        "CALL:Breathing Problems - Clammy",
        "INFO:48 YO M - TRBL BREATHING - IS CLAMMY - ALERT --");

    doTest("T9",
        "SCOE B:0330 1 L:MAIN ST/RT 251 ,SCO T:29D2N X: CAR TOOK OFF OUT OF COUNTY PARK -- EJECTED ONE OF THE PPL OUT OF THE CAR -- NOW TRYING TO LOAD HER INTO CAR AND LEAVE LOOK TO BE INTOX -- BLU CAR POSS SUBU IMPREZA 4D COMPACT",
        "SRC:SCOE",
        "BOX:0330",
        "PRI:1",
        "ADDR:MAIN ST & RT 251",
        "CITY:SCOTTSVILLE",
        "CODE:29D2N",
        "CALL:MVA - High mechanism: Ejection",
        "INFO:CAR TOOK OFF OUT OF COUNTY PARK -- EJECTED ONE OF THE PPL OUT OF THE CAR -- NOW TRYING TO LOAD HER INTO CAR AND LEAVE LOOK TO BE INTOX -- BLU CAR POSS SUBU IMPREZA 4D COMPACT");

    doTest("T10",
        "SCOE B:0320 2 L:NORTH RD/ROCHESTER ST ,SCO - MOBILE GAS STATION T:EMSA X: ODOR OF NATURAL GAS INSIDE THE BLDG - M IN BACK COOKING --",
        "SRC:SCOE",
        "BOX:0320",
        "PRI:2",
        "ADDR:NORTH RD & ROCHESTER ST",
        "CITY:SCOTTSVILLE",
        "PLACE:MOBILE GAS STATION",
        "CALL:EMSA",
        "INFO:ODOR OF NATURAL GAS INSIDE THE BLDG - M IN BACK COOKING --");

    doTest("T11",
        "SCOE B:0320 4 L:8 GENESEE ST ,SCO - JOHN HOLTZ RES T:26A2 X: 68 YO MALE - SHAKING - POSS HIGH FEVER - COMPS ETA 15 MINS TO LOC --",
        "SRC:SCOE",
        "BOX:0320",
        "PRI:4",
        "ADDR:8 GENESEE ST",
        "CITY:SCOTTSVILLE",
        "PLACE:JOHN HOLTZ RES",
        "CODE:26A2",
        "CALL:Sick - Blood pressure abnormallity",
        "INFO:68 YO MALE - SHAKING - POSS HIGH FEVER - COMPS ETA 15 MINS TO LOC --");

    doTest("T12",
        "SCOE B:0320 4 L:498 NORTH RD ,SCO T:7A1 X: 67 YO MALE RADIATOR SPLASHED ANTI FREEZE ON HIM /BURNING ON HIS CHEST AND FACE --",
        "SRC:SCOE",
        "BOX:0320",
        "PRI:4",
        "ADDR:498 NORTH RD",
        "CITY:SCOTTSVILLE",
        "CODE:7A1",
        "CALL:Burns <18% body area",
        "INFO:67 YO MALE RADIATOR SPLASHED ANTI FREEZE ON HIM /BURNING ON HIS CHEST AND FACE --");

  }
  
  @Test
  public void testIrondequoitAmbulance() {

    doTest("T1",
        "([SAG3] Sparkgap ResponseView Message)IROE  B:0800 4  L:1884 N GOODMAN ST ,IRO T:18A1   X: 33 YO M HEADACHE \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:IROE",
        "BOX:0800",
        "PRI:4",
        "ADDR:1884 N GOODMAN ST",
        "CITY:IRONDEQUOIT",
        "CODE:18A1",
        "CALL:Headache - Breathing normally",
        "INFO:33 YO M HEADACHE");

    doTest("T2",
        "([SAG3] Sparkgap ResponseView Message)IROE  B:     4  L:300 CRANBERRY LANDING DR ,IRO -- CRANBERRY LANDIN - 134 FRONT ENTRANCE T:17A3   X: 91 YO MALE RESIDENT TIPPED OVER IN SCOOTER-STILL ON FLOOR- NO INJ- \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:IROE",
        "PRI:4",
        "ADDR:300 CRANBERRY LANDING DR",
        "CITY:IRONDEQUOIT",
        "PLACE:CRANBERRY LANDIN - 134 FRONT ENTRANCE",
        "CODE:17A3",
        "CALL:Fall - Public assist (no injuries and no priority symptoms)",
        "INFO:91 YO MALE RESIDENT TIPPED OVER IN SCOOTER-STILL ON FLOOR- NO INJ-");

    doTest("T3",
        "([SAG3] Sparkgap ResponseView Message)IROE  B:0110 2  L:213 FILON AV ,IRO T:28C1   X: 43 YO F WIFE POSS HAD A STROKE - LEFT SIDE PARAYLSIS - NOT COMPLETELY ALERT - UNK WHEN SYMPTOMS STARTED \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:IROE",
        "BOX:0110",
        "PRI:2",
        "ADDR:213 FILON AV",
        "MADDR:213 FILON AVE",
        "CITY:IRONDEQUOIT",
        "CODE:28C1",
        "CALL:Stroke - Not alert",
        "INFO:43 YO F WIFE POSS HAD A STROKE - LEFT SIDE PARAYLSIS - NOT COMPLETELY ALERT - UNK WHEN SYMPTOMS STARTED");

    doTest("T4",
        "([SAG3] Sparkgap ResponseView Message)IROE  B:     1P L:966 IRONDEQUOIT BL ,IRO T:9E1    X: 66 YO F - FOUND MOTHER ON THE FLOOR COLD AND STIFF \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:IROE",
        "PRI:1P",
        "ADDR:966 IRONDEQUOIT BL",
        "CITY:IRONDEQUOIT",
        "CODE:9E1",
        "CALL:Suspected workable arrest – not breathing at all",
        "INFO:66 YO F - FOUND MOTHER ON THE FLOOR COLD AND STIFF");

    doTest("T5",
        "([SAG3] Sparkgap ResponseView Message)IROE  B:     2  L:EMPIRE BL/SHELFORD RD ,IRO T:EMSA   X: DRIVER REQ AMB FOR MINOR HEAD INJ FROM MVA \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:IROE",
        "PRI:2",
        "ADDR:EMPIRE BL & SHELFORD RD",
        "CITY:IRONDEQUOIT",
        "CALL:EMSA",
        "INFO:DRIVER REQ AMB FOR MINOR HEAD INJ FROM MVA");

    doTest("T6",
        "([SAG3] Sparkgap ResponseView Message)IROE  B:     4  L:300 CRANBERRY LANDING DR ,IRO -- CRANBERRY LANDIN - APT 132 T:17B1   X: 93YOA F FELL INJ KNEE \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:IROE",
        "PRI:4",
        "ADDR:300 CRANBERRY LANDING DR",
        "CITY:IRONDEQUOIT",
        "PLACE:CRANBERRY LANDIN",
        "APT:132",
        "CODE:17B1",
        "CALL:Fall - Possibly dangerous body area",
        "INFO:93YOA F FELL INJ KNEE");

    doTest("T7",
        "([SAG3] Sparkgap ResponseView Message)WWBE  B:0120 4  L:000 RT 104 ,WBT -- BAY BRIDGE WB T:STREET X: DOUBLE RIGHT LANE CLOSURE FROM 1000-1400 \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:WWBE",
        "BOX:0120",
        "PRI:4",
        "ADDR:RT 104",
        "CITY:WEBSTER",
        "PLACE:BAY BRIDGE WB",
        "CALL:STREET",
        "INFO:DOUBLE RIGHT LANE CLOSURE FROM 1000-1400");

    doTest("T8",
        "([SAG3] Sparkgap ResponseView Message)IROE  B:0100 1  L:42 WOODRIDGE CT ,IRO - APT #6 T:21D3   X: 34 YO F W/ SERIOUS RECTAL BLEEDING \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:IROE",
        "BOX:0100",
        "PRI:1",
        "ADDR:42 WOODRIDGE CT",
        "CITY:IRONDEQUOIT",
        "APT:6",
        "CODE:21D3",
        "CALL:Hemorrhage - Dangerous Hemorrhage",
        "INFO:34 YO F W/ SERIOUS RECTAL BLEEDING");

    doTest("T9",
        "([SAG3] Sparkgap ResponseView Message)IROE  B:0220 4  L:320 LIBERTY AV ,IRO - ARENA RES/2661695 T:32B2   X: MED ALRM ..UNK AGE M, REQ AMB..TOLD AMB HE WASNT FEELING WELL.. ALRM CO HAS NO ADDITIONAL INFO \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:IROE",
        "BOX:0220",
        "PRI:4",
        "ADDR:320 LIBERTY AV",
        "MADDR:320 LIBERTY AVE",
        "CITY:IRONDEQUOIT",
        "PLACE:ARENA RES/2661695",
        "CALL:32B2",
        "INFO:MED ALRM ..UNK AGE M, REQ AMB..TOLD AMB HE WASNT FEELING WELL.. ALRM CO HAS NO ADDITIONAL INFO");

    doTest("T10",
        "([SAG3] Sparkgap ResponseView Message)IROE  B:     2  L:613 HURSTBOURNE RD ,IRO T:19C4   X: 70 YOA M - FAST HEART RATE - 110 B P M \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:IROE",
        "PRI:2",
        "ADDR:613 HURSTBOURNE RD",
        "CITY:IRONDEQUOIT",
        "CODE:19C4",
        "CALL:Heart Problem - Cardiac history",
        "INFO:70 YOA M - FAST HEART RATE - 110 B P M");

    doTest("T11",
        "([SAG3] Sparkgap ResponseView Message)IROE  B:0802 2  L:225 BROOKDALE PK ,IRO T:31C2   X: 61 YO M PASSED OUT 2 TIMES / AWAKE AND BREATHING NORMAL/ HEART HX \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:IROE",
        "BOX:0802",
        "PRI:2",
        "ADDR:225 BROOKDALE PK",
        "MADDR:225 BROOKDALE PARK",
        "CITY:IRONDEQUOIT",
        "CODE:31C2",
        "CALL:Fainting episodes(s) and alert > 35 (w/cardiac history)",
        "INFO:61 YO M PASSED OUT 2 TIMES / AWAKE AND BREATHING NORMAL/ HEART HX");

    doTest("T12",
        "([SAG3] Sparkgap ResponseView Message)IROE  B:     4  L:124 EDGECREEK TR ,IRO T:1A1    X: 26 YO M ABDOMINAL PAINS \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:IROE",
        "PRI:4",
        "ADDR:124 EDGECREEK TR",
        "CITY:IRONDEQUOIT",
        "CODE:1A1",
        "CALL:Abdominal pain",
        "INFO:26 YO M ABDOMINAL PAINS");

    doTest("T13",
        "([SAG3] Sparkgap ResponseView Message)IROE  B:0304 1  L:100 KINGS HW S ,IRO - REIDMAN CAMPUS AT RGH T:19D4   X: 31 YO FEM POSS SVT..HANDS ARE BLUE,SHE IS PAIL \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:IROE",
        "BOX:0304",
        "PRI:1",
        "ADDR:100 KINGS HW S",
        "MADDR:100 KINGS HWY S",
        "CITY:IRONDEQUOIT",
        "PLACE:REIDMAN CAMPUS AT RGH",
        "CODE:19D4",
        "CALL:Heart Problem - Clammy",
        "INFO:31 YO FEM POSS SVT..HANDS ARE BLUE,SHE IS PAIL");

    doTest("T14",
        "([SAG3] Sparkgap ResponseView Message) CTYF  B: 112 2  L:179 ST PAUL ST ,ROC - 179-181 SEARLE BUILDING 442-6150 T:AMTCA  X:  FIRE ALRM--4TH FLOOR ELEVATOR PULL \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:CTYF",
        "BOX:112",
        "PRI:2",
        "ADDR:179 ST PAUL ST",
        "CITY:ROCHESTER",
        "PLACE:179-181 SEARLE BUILDING 442-6150",
        "CALL:AMTCA",
        "INFO:FIRE ALRM--4TH FLOOR ELEVATOR PULL");

    doTest("T15",
        "([SAG3] Sparkgap ResponseView Message) CTYF  B: 313 1  L:511 E MAIN ST ,ROC - DBM FOOD MARKET T:FUMSA  X:  SMELL OF NATURAL GAS INSIDE THE STORE - RG&E 1 HR ETA \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:CTYF",
        "BOX:313",
        "PRI:1",
        "ADDR:511 E MAIN ST",
        "CITY:ROCHESTER",
        "PLACE:DBM FOOD MARKET",
        "CALL:FUMSA",
        "INFO:SMELL OF NATURAL GAS INSIDE THE STORE - RG&E 1 HR ETA");

  }
  
  @Test
  public void HamlinMortonFire() {

    doTest("T1",
        "([SAG3] Sparkgap ResponseView Message) MORF  B:0813 3  L:3004 CHURCH RD ,HAM T:RBCST  X:  ,NEED A EMS CREW FOR 217 FOR THE OVERDOSE \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:MORF",
        "BOX:0813",
        "PRI:3",
        "ADDR:3004 CHURCH RD",
        "CITY:HAMLIN",
        "CALL:RBCST",
        "INFO:NEED A EMS CREW FOR 217 FOR THE OVERDOSE");

    doTest("T2",
        "([SAG3] Sparkgap ResponseView Message) MORF  B:0813 4  L:3004 CHURCH RD ,HAM T:25B3V  X:  2ND PTY - MOTHER AND BROTHER AT LOC - MOTHER POSS THREATENING SUICIDE POSS VIA PILLS - UNK WEAPS -MOTHERS NAME COLLEEN CLARK -POSS BEING ABUSIVE TO BROTHER TOOK PHONE AWAY FROM HI\n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:MORF",
        "BOX:0813",
        "PRI:4",
        "ADDR:3004 CHURCH RD",
        "CITY:HAMLIN",
        "CODE:25B3V",
        "CALL:Threatening suicide",
        "INFO:2ND PTY - MOTHER AND BROTHER AT LOC - MOTHER POSS THREATENING SUICIDE POSS VIA PILLS - UNK WEAPS -MOTHERS NAME COLLEEN CLARK -POSS BEING ABUSIVE TO BROTHER TOOK PHONE AWAY FROM HI");

    doTest("T3",
        "([SAG3] Sparkgap ResponseView Message) MORF  B:0813 4  L:3004 CHURCH RD ,HAM T:25B3V  X:2ND PTY - MOTHER AND BROTHER AT LOC - MOTHER POSS THREATENING SUICIDE POSS VIA PILLS - UNK WEAPS -MOTHERS NAME COLLEEN CLARK -POSS BEING ABUSIVE TO BROTHER TOOK PHONE AWAY FROM HIM \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:MORF",
        "BOX:0813",
        "PRI:4",
        "ADDR:3004 CHURCH RD",
        "CITY:HAMLIN",
        "CODE:25B3V",
        "CALL:Threatening suicide",
        "INFO:2ND PTY - MOTHER AND BROTHER AT LOC - MOTHER POSS THREATENING SUICIDE POSS VIA PILLS - UNK WEAPS -MOTHERS NAME COLLEEN CLARK -POSS BEING ABUSIVE TO BROTHER TOOK PHONE AWAY FROM HIM");

    doTest("T4",
        "([SAG3] Sparkgap ResponseView Message) MORF  B: 2  L:1932 KENDALL RD - ELEMENTARY SCHOOL T:AMTCA  X:  AUTOMATIC ALRM / HAMF AS RIC/ MORF PUMPER AND RESCUE \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:MORF",
        "PRI:2",
        "ADDR:1932 KENDALL RD",
        "PLACE:ELEMENTARY SCHOOL",
        "CALL:AMTCA",
        "INFO:AUTOMATIC ALRM / HAMF AS RIC/ MORF PUMPER AND RESCUE");

    doTest("T5",
        "([SAG3] Sparkgap ResponseView Message) MORF  B: 2  L:1932 KENDALL RD ,KEN - ELEMENTARY SCHOOL T:AMTCA  X:  AUTOMATIC ALARM/ MUTUAL ASSIST MORF 1 PUMPER AND 1 RESCUE / HAMF RIC \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:MORF",
        "PRI:2",
        "ADDR:1932 KENDALL RD",
        "CITY:KENDALL",
        "PLACE:ELEMENTARY SCHOOL",
        "CALL:AMTCA",
        "INFO:AUTOMATIC ALARM/ MUTUAL ASSIST MORF 1 PUMPER AND 1 RESCUE / HAMF RIC");

    doTest("T6",
        "([SAG3] Sparkgap ResponseView Message) MORF  B:0910 1  L:17230 CREEK RD ,KEN T:FIREA  X:  MALE DWN OUTSIDE BY 4 WHEELER, NOT BREATHING \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:MORF",
        "BOX:0910",
        "PRI:1",
        "ADDR:17230 CREEK RD",
        "CITY:KENDALL",
        "CALL:FIREA",
        "INFO:MALE DWN OUTSIDE BY 4 WHEELER, NOT BREATHING");

    doTest("T7",
        "([SAG3] Sparkgap ResponseView Message) MORF  B:0910 1  L:17230 CREEK RD ,KEN T:FIREA  X:MALE DWN OUTSIDE BY 4 WHEELER, NOT BREATHING \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:MORF",
        "BOX:0910",
        "PRI:1",
        "ADDR:17230 CREEK RD",
        "CITY:KENDALL",
        "CALL:FIREA",
        "INFO:MALE DWN OUTSIDE BY 4 WHEELER, NOT BREATHING");

    doTest("T8",
        "([SAG3] Sparkgap ResponseView Message) HAMF  B:0304 2  L:18 OAK DR ,HAM T:26C1   X:  87 YO /F / CONFUSED / WONT GET OUT OF BED \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:HAMF",
        "BOX:0304",
        "PRI:2",
        "ADDR:18 OAK DR",
        "CITY:HAMLIN",
        "CODE:26C1",
        "CALL:Sick - Altered level of conciousness",
        "INFO:87 YO /F / CONFUSED / WONT GET OUT OF BED");

    doTest("T9",
        "([SAG3] Sparkgap ResponseView Message) MORF  B:0818 3  L:4500 ROOSEVELT HW ,HAM - LOT 20 T:RBCST  X:  ,NEED DRIVER OR MEDIC FOR THE SQUAD \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:MORF",
        "BOX:0818",
        "PRI:3",
        "ADDR:4500 ROOSEVELT HW",
        "MADDR:4500 ROOSEVELT HWY",
        "CITY:HAMLIN",
        "PLACE:LOT 20",
        "CALL:RBCST",
        "INFO:NEED DRIVER OR MEDIC FOR THE SQUAD");

    doTest("T10",
        "([SAG3] Sparkgap ResponseView Message) MORF  B:0818 4  L:4500 ROOSEVELT HW ,HAM - LOT 20 T:17B1   X:  40 YO / F / FELL OF TOILET / WHEEL CHAIR BOUND / HIT HEAD \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:MORF",
        "BOX:0818",
        "PRI:4",
        "ADDR:4500 ROOSEVELT HW",
        "MADDR:4500 ROOSEVELT HWY",
        "CITY:HAMLIN",
        "PLACE:LOT 20",
        "CODE:17B1",
        "CALL:Fall - Possibly dangerous body area",
        "INFO:40 YO / F / FELL OF TOILET / WHEEL CHAIR BOUND / HIT HEAD");

    doTest("T11",
        "([SAG3] Sparkgap ResponseView Message) MORF  B:0818 4  L:4500 ROOSEVELT HW ,HAM - LOT 20 T:17B1   X:40 YO / F / FELL OF TOILET / WHEEL CHAIR BOUND / HIT HEAD \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:MORF",
        "BOX:0818",
        "PRI:4",
        "ADDR:4500 ROOSEVELT HW",
        "MADDR:4500 ROOSEVELT HWY",
        "CITY:HAMLIN",
        "PLACE:LOT 20",
        "CODE:17B1",
        "CALL:Fall - Possibly dangerous body area",
        "INFO:40 YO / F / FELL OF TOILET / WHEEL CHAIR BOUND / HIT HEAD");

    doTest("T12",
        "([SAG3] Sparkgap ResponseView Message) WLKF  B:0703 3  L:446 MARTIN RD ,HAM T:FUMSB  X:  CARBON MONOXIDE ALRM GOING OFF- -NO REPORTED ILLNESS- ADVISED TO WAIT OUTSIDE- \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:WLKF",
        "BOX:0703",
        "PRI:3",
        "ADDR:446 MARTIN RD",
        "CITY:HAMLIN",
        "CALL:FUMSB",
        "INFO:CARBON MONOXIDE ALRM GOING OFF- -NO REPORTED ILLNESS- ADVISED TO WAIT OUTSIDE-");

    doTest("T13",
        "([SAG3] Sparkgap ResponseView Message) WLKF  B:620A 2  L:5796 W WAUTOMA BEACH ,HAM T:23C1   X:  57 YO F-NOT ALERT-TOOK PILLS, UNK WHEN -COMPL CAME HOME TO FIND HER ON THE GROUND WITH PILLS AROUND HER DUTAL-ASA-CASS, PIPHENHYDRANINE \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.\n",

        "SRC:WLKF",
        "BOX:620A",
        "PRI:2",
        "ADDR:5796 W WAUTOMA BEACH",
        "CITY:HAMLIN",
        "CODE:23C1",
        "CALL:Overdose - Not alert",
        "INFO:57 YO F-NOT ALERT-TOOK PILLS, UNK WHEN -COMPL CAME HOME TO FIND HER ON THE GROUND WITH PILLS AROUND HER DUTAL-ASA-CASS, PIPHENHYDRANINE");

  }
  
  @Test
  public void testSpencerportFireDepartment() {

    doTest("T1",
        "(Spencerport Fire) SPEF  B:0213 1   3227 BIG RIDGE RD ,OGD T:FIREA  X:,GATES AMB COVERING CALL FOR F POSS HAVING A STROKE \n\n" +
        "-- Confidentiality",

        "SRC:SPEF",
        "BOX:0213",
        "PRI:1",
        "ADDR:3227 BIG RIDGE RD",
        "CITY:OGDEN",
        "CALL:FIREA",
        "INFO:GATES AMB COVERING CALL FOR F POSS HAVING A STROKE");

    doTest("T2",
        "(Spencerport Fire) SPEF  B:5132 2   26 SLAYTON AV ,SPE - SLAYTON PLACE RESTAURANT-352-0260 T:AMTCA  X:AUTOMATIC FIRE ALARM - DUCT DETECTOR - CC \n\n" +
        "-- Confidentiality",

        "SRC:SPEF",
        "BOX:5132",
        "PRI:2",
        "ADDR:26 SLAYTON AV",
        "MADDR:26 SLAYTON AVE",
        "CITY:SPENCERPORT",
        "PLACE:SLAYTON PLACE RESTAURANT-352-0260",
        "CALL:AMTCA",
        "INFO:AUTOMATIC FIRE ALARM - DUCT DETECTOR - CC");

    doTest("T3",
        "(Spencerport Fire) SPEF  B:4314 1   128 NORWICH DR ,OGD - SPEARY- 5942542 T:FIREA  X:,GATES AMB COVERING P-3 CALL -- 79 YO FEMALE UNABLE TO GET OFF TOILET \n\n" +
        "-- Confidentiality",

        "SRC:SPEF",
        "BOX:4314",
        "PRI:1",
        "ADDR:128 NORWICH DR",
        "CITY:OGDEN",
        "PLACE:SPEARY- 5942542",
        "CALL:FIREA",
        "INFO:GATES AMB COVERING P-3 CALL -- 79 YO FEMALE UNABLE TO GET OFF TOILET");

    doTest("T4",
        "(Spencerport Fire) SPEF  B:0122 1P  17 GLENN HAVEN ,OGD - APT A T:9E1    X:88 YO MALE FOUND PASSED AWAY IN THE BATHROOM BY HIS SON \n\n" +
        "-- Confidentiality",

        "SRC:SPEF",
        "BOX:0122",
        "PRI:1P",
        "ADDR:17 GLENN HAVEN",
        "CITY:OGDEN",
        "APT:A",
        "CODE:9E1",
        "CALL:Suspected workable arrest – not breathing at all",
        "INFO:88 YO MALE FOUND PASSED AWAY IN THE BATHROOM BY HIS SON");

    doTest("T5",
        "(Spencerport Fire) SPEF  B:4314 2   73 WINDSORSHIRE DR ,OGD - LIFETIME ASSISTANCE PH # 5940560 T:AMTCA  X:FIRE ALARM - PULL STATION - C/C \n\n" +
        "-- Confidentiality",

        "SRC:SPEF",
        "BOX:4314",
        "PRI:2",
        "ADDR:73 WINDSORSHIRE DR",
        "CITY:OGDEN",
        "PLACE:LIFETIME ASSISTANCE PH # 5940560",
        "CALL:AMTCA",
        "INFO:FIRE ALARM - PULL STATION - C/C");

    doTest("T6",
        "(Spencerport Fire) SPEF  B:0231 2P  4802 W RIDGE RD ,PAR T:FIREB  X:NEED FD FOR RADIATOR FLUID AND EMS FOR PRECAUTION-NO NEED FOR 77 \n\n" +
        "-- Confidentiality",

        "SRC:SPEF",
        "BOX:0231",
        "PRI:2P",
        "ADDR:4802 W RIDGE RD",
        "CITY:PARMA",
        "CALL:FIREB",
        "INFO:NEED FD FOR RADIATOR FLUID AND EMS FOR PRECAUTION-NO NEED FOR 77");

    doTest("T7",
        "(Spencerport Fire) SPEF  B:0153 2P L:3389 BROCKPORT SPENCERPRT RD ,OGD T:FIREB  X:REQ FIRE TO CUT UP TREE AND REMOVE FROM ROAD - TREE IS COMPLETELY BLKG \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "BOX:0153",
        "PRI:2P",
        "ADDR:3389 BROCKPORT SPENCERPRT RD",
        "MADDR:3389 BROCKPORT SPENCERPORT RD",
        "CITY:OGDEN",
        "CALL:FIREB",
        "INFO:REQ FIRE TO CUT UP TREE AND REMOVE FROM ROAD - TREE IS COMPLETELY BLKG");

    doTest("T8",
        "(Spencerport Fire) SPEF  B: 2  L:2215 LONG POND RD ,GAT T:FILLIN X:ENGING FROM SPEF TO FILL IN \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "PRI:2",
        "ADDR:2215 LONG POND RD",
        "CITY:GATES",
        "CALL:FILLIN",
        "INFO:ENGING FROM SPEF TO FILL IN");

    doTest("T9",
        "(Spencerport Fire) SPEF  B:0252 3  L:3 WALNUT HILL DR ,PAR - IN AREA... T:RBCST  X: \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "BOX:0252",
        "PRI:3",
        "ADDR:3 WALNUT HILL DR",
        "CITY:PARMA",
        "PLACE:IN AREA...",
        "CALL:RBCST");

    doTest("T10",
        "(Spencerport Fire) SPEF  B:0252 2P L:3 WALNUT HILL DR ,PAR - IN AREA... T:FIREB  X:STRONG BURNING ODOR WHEN SHE STEPS OUTSIDE --- HAZY TYPE APPEARANCE BUT DOESNT SEEM TO BE SMOKE - SAYS IF SHE HAD TO GUESS IT WAS ORIGINATING FROM THE PINE HILL RD AR\n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "BOX:0252",
        "PRI:2P",
        "ADDR:3 WALNUT HILL DR",
        "CITY:PARMA",
        "PLACE:IN AREA...",
        "CALL:FIREB",
        "INFO:STRONG BURNING ODOR WHEN SHE STEPS OUTSIDE --- HAZY TYPE APPEARANCE BUT DOESNT SEEM TO BE SMOKE - SAYS IF SHE HAD TO GUESS IT WAS ORIGINATING FROM THE PINE HILL RD AR");

    doTest("T11",
        "(Spencerport Fire) SPEF  B:0223 4  L:3482 BIG RIDGE RD ,OGD T:29B1   X:1 VEH - IN COMPS LAWN - ELDERLY F OUT OF VEH ON GROUND \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "BOX:0223",
        "PRI:4",
        "ADDR:3482 BIG RIDGE RD",
        "CITY:OGDEN",
        "CODE:29B1",
        "CALL:MVA - Injuries",
        "INFO:1 VEH - IN COMPS LAWN - ELDERLY F OUT OF VEH ON GROUND");

    doTest("T12",
        "(Spencerport Fire) SPEF  B:0241 2P L:5028 W RIDGE RD ,PAR - HESS T:FIREB  X:ODOR OF PROPANE W/U TO THE FIREHOUSE \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "BOX:0241",
        "PRI:2P",
        "ADDR:5028 W RIDGE RD",
        "CITY:PARMA",
        "PLACE:HESS",
        "CALL:FIREB",
        "INFO:ODOR OF PROPANE W/U TO THE FIREHOUSE");

    doTest("T13",
        "(Spencerport Fire) SPEF  B:0143 1  L:42 NICHOLS ST ,SPE -- STRONG URGENT CAR T:FIREA  X:,EMS 23 Y/O/F VOMITING BLOOD TROUBLE BREATHING GATES AMB TO COVER \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "BOX:0143",
        "PRI:1",
        "ADDR:42 NICHOLS ST",
        "CITY:SPENCERPORT",
        "PLACE:STRONG URGENT CAR",
        "CALL:FIREA",
        "INFO:EMS 23 Y/O/F VOMITING BLOOD TROUBLE BREATHING GATES AMB TO COVER");

    doTest("T14",
        "(Spencerport Fire) SPEF  B:0121 1P L:44 THISTLEWOOD LA ,OGD T:9E1    X:F - 64 - NOT BREATHING - IS COLD - ON THE FLOOR \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "BOX:0121",
        "PRI:1P",
        "ADDR:44 THISTLEWOOD LA",
        "MADDR:44 THISTLEWOOD LN",
        "CITY:OGDEN",
        "CODE:9E1",
        "CALL:Suspected workable arrest – not breathing at all",
        "INFO:F - 64 - NOT BREATHING - IS COLD - ON THE FLOOR");

    doTest("T15",
        "(Spencerport Fire) SPEF  B:0232 1  L:OGDEN PARMA T L RD/UNION ST ,PAR - ON UNION T:29D2P  X:TRUCK ROLLED OVER ON ITS SIDE, MALE STILL IN DRIVERS SEAT \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "BOX:0232",
        "PRI:1",
        "ADDR:OGDEN PARMA T L RD & UNION ST",
        "MADDR:OGDEN PARMA TOWN LINE RD & UNION ST",
        "CITY:PARMA",
        "PLACE:ON UNION",
        "CODE:29D2P",
        "CALL:MVA - High mechanism: Rollovers",
        "INFO:TRUCK ROLLED OVER ON ITS SIDE, MALE STILL IN DRIVERS SEAT");

    doTest("T16",
        "(Spencerport Fire) SPEF  B:0232 1  L:OGDEN PARMA T L RD/UNION ST ,PAR T:29D2P  X:TRUCK ROLLED OVER ON ITS SIDE, MALE STILL IN DRIVERS SEAT \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "BOX:0232",
        "PRI:1",
        "ADDR:OGDEN PARMA T L RD & UNION ST",
        "MADDR:OGDEN PARMA TOWN LINE RD & UNION ST",
        "CITY:PARMA",
        "CODE:29D2P",
        "CALL:MVA - High mechanism: Rollovers",
        "INFO:TRUCK ROLLED OVER ON ITS SIDE, MALE STILL IN DRIVERS SEAT");

    doTest("T17",
        "(Spencerport Fire) SPEF  B:4233 3  L:203 CEDAR CI ,OGD T:FUMSB  X:CO DETECTOR ACTIVATED \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "BOX:4233",
        "PRI:3",
        "ADDR:203 CEDAR CI",
        "MADDR:203 CEDAR CIR",
        "CITY:OGDEN",
        "CALL:FUMSB",
        "INFO:CO DETECTOR ACTIVATED");

    doTest("T18",
        "(Spencerport Fire) SPEF  B:0335 2  L:47 BREWERTON DR ,OGD - CLARICE ROW - 594 1810 T:AMTCA  X:FIRE ALRM - 1ST FLR SMOKE DETECTOR - UNABLE TO REACH CONTACTS \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "BOX:0335",
        "PRI:2",
        "ADDR:47 BREWERTON DR",
        "CITY:OGDEN",
        "PLACE:CLARICE ROW - 594 1810",
        "CALL:AMTCA",
        "INFO:FIRE ALRM - 1ST FLR SMOKE DETECTOR - UNABLE TO REACH CONTACTS");

    doTest("T19",
        "(Spencerport Fire) SPEF  B:0152 3  L:46 SARAH CI ,OGD - POHLEVEN RESD - 349.0139 T:FUMSB  X:CARBON MONIXIDE ALRM FROM BASEMENT -CC \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "BOX:0152",
        "PRI:3",
        "ADDR:46 SARAH CI",
        "MADDR:46 SARAH CIR",
        "CITY:OGDEN",
        "PLACE:POHLEVEN RESD - 349.0139",
        "CALL:FUMSB",
        "INFO:CARBON MONIXIDE ALRM FROM BASEMENT -CC");

    doTest("T20",
        "(Spencerport Fire) SPEF  B:0252 1  L:485 TRIMMER RD ,PAR T:FIREA  X:,REQ FIRERESPOND FOR ALLERGIC REACTION TO A BEE STING - MONE COVERING \n\n" +
        "-- Confidentiality Notice --\n" +
        "This email message, including all the attachments, is for the sole use of the intended recipient(s) and contains confidential information. Unauthorized use or disclosure is prohibited. If you are not the intended recipient, you may not use, disclose, copy or disseminate this information. If you are not the intended recipient, please contact the sender immediately by reply email and destroy all copies of the original message,\n" +
        "including attachments.",

        "SRC:SPEF",
        "BOX:0252",
        "PRI:1",
        "ADDR:485 TRIMMER RD",
        "CITY:PARMA",
        "CALL:FIREA",
        "INFO:REQ FIRERESPOND FOR ALLERGIC REACTION TO A BEE STING - MONE COVERING");
 
  }
  
  @Test
  public void testChrisDamon() {

    doTest("T1",
        "(Spencerport Fire) BROF  B:4513 3   19 MERCER ST ,BRO T:RBCST  X:,NEED A DRIVER FOR F2914 \n\n-- Confidentiality",
        "SRC:BROF",
        "BOX:4513",
        "PRI:3",
        "ADDR:19 MERCER ST",
        "CITY:BROCKPORT",
        "CALL:RBCST",
        "INFO:NEED A DRIVER FOR F2914");

  }
  
  public static void main(String[] args) {
    new NYMonroeCountyWebsterParserTest().generateTests("T1");
  }
}