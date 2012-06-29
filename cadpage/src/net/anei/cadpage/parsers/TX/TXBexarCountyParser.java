package net.anei.cadpage.parsers.TX;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Bexar County, TX
Contact: "Dorian Davis (IT GUY)" <dorian@bexarcountyfire.org>
Contact: Adam Slater <adam@raymondmartin.com>
Sender: visinet.command@sanantonio.gov
System: Tritech
 
*** Main variant T1
Fire - Structure     - Stockport / Chipping           - 585E1 - comp states a house is on fire[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0105711,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000502. [Shared],Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000571. [Shared],Automatic Case Number(s) issued for Converse FD: CONV-2012-000000420. [Shared],Automatic Case Number(s) issued for Kirby FD: KIRB-2012-000000372. [Shared],
Med - Sick Person         - 17694 Shepherd Rd              - 711F7   -  31 yo female...knee pain cause by past injury pt says it's a cut[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0107603,[BCLE] has closed their incident [BCSO-2012-0107603],Automatic Case Number(s) issued for Lytle FD: LYTL-2012-000000122. [Shared],This incident LYTL-2012-0010282 has been sent to ACADIAN via the CAD2CAD Interface
Fire - Vehicle            Ih 10 W / Tarpon Dr            - 447A2   - engine smoking c has pulled to the side of the road...tan f350...wb on 10..doesn't seem to be leaking fluid[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:3511  AT&T MOBILITY-SE SECTOR-QF 446F.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:3511  AT&T MOBILITY-SE SECTOR-QF
Fire - Structure     - Stockport / Chipping           - 585E1 - comp states a house is on fire[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0105711,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000502. [Shared],Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000571. [Shared],Automatic Case Number(s) issued for Converse FD: CONV-2012-000000420. [Shared],Automatic Case Number(s) issued for Kirby FD: KIRB-2012-000000372. [Shared]
MVC                             W Loop 1604 S / Spurs Ranch     646B1    GVIL-2012-000001006  - crash, injuries, one car roll over.  On the access rd, sb side.[Shared],Invalid address received:61  SPRINT-N SECTOR-QF 646C4.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0107458,C is an off-duty officer with SAPD.  thinks the guy involved in crash is okay..but would like him checked out [Shared],Automatic Case Number(s)
Fire - Unauthorized Burn  9279 Aqua Dr                   - 447A3   - Unauth BUrning  to the left of location,Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000283.
04/28 06:28 am - Med - Diabetic Problems   - 4455 Twin Valley            - 748E6   - C states her mother 72yo has low blood sugar..acad notifed[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0109820,Automatic Case Number(s) issued for Somerset FD: SOM-2012-000000292. [Shared],
MED - ASSAULT        - 7246 GLEN HILL                 - SA585 - ACADIAN: Unit:    740         9941959,ACADIAN: The cross street was verified by caller.,ACADIAN: Law enforcement on scene; it is safe for the crew to enter.,ACADIAN: assult to head unk age male,ACADIAN: [ProQA Session Aborted] Medical Professional,Transferred incident: Remote   Reference Number: 20120428-ZN16-0222 by Jacobs, Angela From ACADIAN,Interface has sent an ack message for CAM-2012-0010500 to the
Med - Unconscious Pe - 7838 Sun Forest                -       - 585C1   - 24 yo female went over to comps resd to visit his son; comp states female started drinking some wine and passed out; comp states she is breathing ; does not know what to do with female[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0109700,This incident WIND-2012-0010491 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120428-ZN16-0059 [Shared],Unit - 76
Med - Sick Person    - 8216 Glen Boro                 - 553F8 - 50 YO F HAVING CHEST PAINS[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0109833,[BCLE] has closed their incident [BCSO-2012-0109833],Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000521. [Shared],
Fire                            6126 Kimble Mill                577D3    GVIL-2012-000001031  - C thinks the grease fire in his pit is getting out of hand.  in his backyard[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110061,C has turned off burners [Shared],Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001031. [Shared],
* BCFA Medical Emergency  - Ih 35 S Nb / Sb Ih 35 S Onrp S - 712A5   - unk where other fighters went[Shared],they have been drinking[Shared],no weapons[Shared],C says at los amigos there was a fight, three people are on the ground, req ems[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110791,Automatic Case Number(s) issued for Jarret FD: JARR-2012-000000207. [Shared],
Med - Possible Stroke           12446 Modena Bay                577D6    GVIL-2012-000001047  - 66 yom- poss stroke- acad advised[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110913,This incident GVIL-2012-0010627 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120429-ZN16-1184 [Shared],Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001047. [Shared],
MVC                       - 23101 - 24511 Campbellton - HICKORY WAY/RANCH TRAIL RD               - 783D1 - small dark colored suv[Shared],going north on cambellton, it will be on the left[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:1453  TMOBILE-SE SECTOR-QF 751A2.[Shared],C disconnected[Shared],C says there is a car, unoccupied, flipped over.[Shared],Invalid address received:1453  TMOBILE-SE SECTOR-QF 751A2.[Shared],A cellular re-bid has occurre
Med - Sick Person    - 6739 Glen Fair                 - 553E7 - C says her niece had a seizure, 34 yo.  fell onto concrete[Shared],Invalid address received:343  SPRINT-E SECTOR-QF 553C8.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110931,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000525. [Shared],
Alarm - Fire         - 9503 Millers Rdg               -       - 553E7   - POE;SMOKE DETECTOR;JOHN GILG @ 653-7947[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0111024,Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000599. [Shared],Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000527. [Shared],Automatic Case Number(s) issued for Converse FD: CONV-2012-000000442. [Shared],
Med - Sick Person         - 16927 Ih 35 S Sb               - 711E6   -  23 YOF POSSIBLE BROKEN FOOT/FELL DOWN[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0112109,[BCLE] has closed their incident [BCSO-2012-0112109],Automatic Case Number(s) issued for Lytle FD: LYTL-2012-000000126. [Shared],
Alarm                - 8210 Ih 35 N                  -       - 552E8   Dept-E108,C145,E145B,120A - Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000612.,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000547.,FIRE ALARM-RED LOBSTERS REST.,Backed up C145 with E145B,SINGLE STORY LIGHT SMOKE SHOWING AND SMOKE IN KITCHEN,Automatic Case Number(s) issued for Gardendale FD: GARD-2012-000000134.,
Med - Sick Person               9615 Rainbow Crk                612C5      GVIL-2012-000001138  Dept-123C - Multi-Agency BCLE Incident #: BCSO-2012-0118460,Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001138. [Shared],
Med - Sick Person         - 1460 Martinez Losoya           # SRST  - 717B8 Dept-141E - 6 YO F BROKE ARM[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0118435,Automatic Case Number(s) issued for South Bexar FD: SOBX-2012-000000251. [Shared],
Alarm - Fire              - 7406 Scintilla                 - 413F8   Dept-133A,126E,SPK activated general fire alarm,borene pd called this one in,Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000339.,Automatic Case Number(s) issued for Grey Forest FD: GRYF-2012-000000169.,
Med - Diabetic Problems   - 14085 Ih 35 S                  - 713B2   Dept-130C 67 yof diabetic feeling light headed[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0119030,This incident JARR-2012-0011429 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120508-ZN16-0205 [Shared],Unit - 709, status change to STATUS_DISPATCHED by ACADIAN at 05/08/2012 04:33:59 [Shared],trlr 15 [Shared],[BCLE] has closed their incident [BCSO-2012-011903
Med - Cardiac Arrest            2918 FISHERS GLADE              SA612/F8   GVIL-2012-000001157  Dept-123B - ACADIAN: Unit:    734         9963763,Transferred incident: Remote   Reference Number: 20120508-ZN16-0370 by Brunson, Savannah L. From ACADIAN,Interface has sent an ack message for GVIL-2012-0011432 to the remote CAD,9963763,This incident 20120508-ZN16-0370 has been sent to BCFA via the CAD2CAD Interface.,Unit - 734, status change to STATUS_RESPONDING by ACADIAN at 05/08/2012 06:25:35,Automatic Case Number
Med - Sick Person    - 8510 WINDY CROSS               -       - SA553/C Dept-145D - ACADIAN: Unit:    735         9975423,Transferred incident: Remote   Reference Number: 20120513-ZN16-0481 by Reed, Juliana E. From ACADIAN,Interface has sent an ack message for WIND-2012-0011843 to the remote CAD,9975423,This incident 20120513-ZN16-0481 has been sent to BCFA via the CAD2CAD Interface.,ACADIAN HAS CHANGED the CALL BACK PHONE# to:,Automatic Case Number(s) issued for Windcrest FD: WIND-2012-0
Med - Heart Problems - 8835 WILLMON WAY               -       - SA552/F Dept-145A - ACADIAN: The cross street was verified by caller.,ACADIAN: Unit:    733         9975214,ACADIAN: The patient's weight is below 300 pounds.,ACADIAN: [ProQA Script] Dispatch code: 19D02  You are responding to a patient  with heart problems.  The patient is a  66-year-old female, who is    conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  Heart Problems / A.I.C.D..  DIFFICULTY SPE,AKING BETWEEN

*** Variant T2
07:35 pm   10410 Stallion Bay             :Rspnd for: Med - Sick Person    - 546C6   - D7FR-2012-000000330\r

*** Variant T2
Respond For MVC                           @30000 Smithson Valley Rd                     ;      ;                              Cross- VOGEL VALLEY/FM 1863                                                            ;418D7;BBUL-2012-000000497 ;Multi-Agency BCLE Incident #: BCSO-2012-0104123,e veh roll over, injuries [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000497. [Shared]
Respond For Med - Sick Person             @25715 Fan Flower                             ;      ;                              Cross- Dead End/BEAUTYBERRY                                                            ;452B7;BBUL-2012-000000532 ;C said a woman came by her house,is now seizing, 24 yo.[Shared],Invalid address received:520  AT&T MOBILITY -SE SECTOR-QF 451.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110748,Automatic Case Number(s) issued for Bexa

** This variant is not currently parsed, waiting to see if it pops up more than once
a structure fire \nVALLEY RIDGE MOBILE PARK \n8671 Sw Loop 410, Unit 520 \nSB SW LP 410 OFRPOP RD/OLD PEARSALL RD \n*TAC2 \nDistrict: D2 \nE36, L36, E44, E35 and BC2

********************************************************************************************************
All of the above are in the process of being phased out and may be droppped  New text page format follows
********************************************************************************************************
Contact: support@active911.com
Agency name: Hollywood Park FD Location: San Antonio, TX
Final status unknown 
*** These are not currently supported ***
07:37 - Med - Sick Person              - 206 Donella Dr                           -           -Case - HPK-2012-000000230   - 69 YO F FELL AND CANT GET UP[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0138384,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000230. [Shared],
07:42 - Assist - Law Enforcement       - Sun Way Dr / El Cerrito Cir              -           -Case - HPK-2012-000000231   - 9217s  thousand oaks/us hwy 281 egg and i restaraunt[Shared],9217s  looking around us hwy 281/mecca. person said heading towards 1604 bleeding from head[Shared],SUBJ STATED HE STARTED A NEW MEDS AND HE IS TRYING TO FIND HIS PARENTS HOUSE[Shared],W/M/DK HAIR/SHIRT BLK/SHORT RED/SANDLES. COMP STATES THAT THE SUBJ CAME UP TO HER AND STATED HE LOST HIS GLASSES AND IS CONFUSED. WALKING TOWARDS US HWY 281[Shared
17:26 - Assist - Lift                  - 339 Donella Dr                           -           -Case - HPK-2012-000000229   - 98 yo female...lift assist only[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0137362,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000229. [Shared],
Alarm - Fire                    3920 Beckwood Dr                                      484B5 - HPK-2012-000000232   Dept-104D,129E,SPK - AUD. "FAWCETT, TOM GRACE" POE: GEN FIRE. 210-402-0240 NO ADD INFO[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0139715,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000679. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000232. [Shared],
Alarm - Fire         - 9311 Durham Trace              - 546A6   - GVIL-2012-000001346  - 115B,128E,122E   05:02 pm
18:38 - Alarm - Fire                   - 155 William Classen Dr                   -           -Case - BBUL-2012-000000681  - Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000233.,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000681.,
Fire                            3606 Sausalito Fern                                   452A8 - HPK-2012-000000234   Dept-129A,104D - comp says she sees smoke coming from wash room area. said not washer or dryer can smell the smoke[Shared],Invalid address received:83  SPRINT-NE SECTOR-QF 483D2.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0140833,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000682. [Shared],Automatic Case Number(s) issu
15:47 - Med - Back Pain                - 30 Amber Forest                          -           -Case - HPK-2012-000000235   - 36 YOM- HURT BACK- NOT ABLE TO GET OUT OF CHAIR[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:3117  AT&T MOBILITY-N SECTOR-QF 581D4.[Shared],Invalid address received:3117  AT&T MOBILITY-N SECTOR-QF 581D4.[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0142020,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000235. [Shared],
15:54 - Alarm - Fire                   - 16315 Us Hwy 281 N                       -           -Case - BBUL-2012-000000692  - Multi-Agency BCLE Incident #: HPPD-2012-0142027,comm fire alarm...poe/general fire alarm...bus/Holiday Inn...bus./210-402-3300 [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000236. [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000692. [Shared],
23:41 - Med - Sick Person              - 328 El Portal                            -           -Case - HPK-2012-000000237   - 75 YOF HAVING HEART PAINS[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0142337,This incident HPK-2012-0013604 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120601-ZN16-2014 [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000237. [Shared],Unit - 776, status change to STATUS_DISPATCHED by ACADIAN at 06/01/2012 23:41:17 [Sha
Alarm - Fire                    25630 Indian Summer                                   450D8 - HPK-2012-000000238   Dept-103C,129E,SPK - Phone #:210-481-3208[Shared],Name of the resident:Glen & Barbara Johnson.[Shared],Fire alarm.  Smoke detector.  unk location.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0142845,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000695. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000238. [Shared],
18:56 - Alarm - Medical                - 131 SUN WAY DR                           -           -Case - HPK-2012-000000239   - ACADIAN: The cross street was verified by caller.,ACADIAN: Unit:    740         10039768,Transferred incident: Remote   Reference Number: 20120602-ZN16-1270 by Barron, Ricardo From ACADIAN,Interface has sent an ack message for HPK-2012-0013670 to the remote CAD,10039768,This incident 20120602-ZN16-1270 has been sent to BCFA via the CAD2CAD Interface.,unknown medical alarm,ACADIAN HAS CHANGED CALLER to:Acad
Alarm - Fire                   ; 28300 Us Hwy 281  N                           ;       ; 451E2 ; HPK-2012-000000240   Dept-103D,129E,SPK ;  Activated Fire Alarm,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000700.,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000240.,
16:06 - MED - ASSAULT                  - 310 Yosemite                             -           -Case - HPK-2012-000000241   - DISTURBANCE[Shared],subj is outside loc[Shared],c states w/f- grey shirt and jeans told c that her son ranaway- subj has been wandering around in the neighborhood looking for him- c states subj has asthma and is over heated- ref ems req ofc[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0144505,SCENE IS NOT SECURE,EMS ENROUTE [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-0000002
17:22 - Med - Sick Person              - 17319 Us Hwy 281 N                       - SUITE 400 -Case - HPK-2012-000000242   - comp is not with the pt[Shared],60 yof complaining of a headache and high blood sugar; comp states the pt is breathing heavily[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0144554,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000242. [Shared],
Med - Chest Pain               - 144 BLUET LN                             -            - 12:34-Case - HPK-2012-000000243   - ACADIAN: Unit:    738         10044990,ACADIAN: The patient's weight is below 300 pounds.  83 yo male,ACADIAN: home health nurse is on scene,ACADIAN: 160/94  pt has taken 1 nitro,Transferred incident: Remote   Reference Number: 20120605-ZN16-1057 by Brunson, Savannah L. From ACADIAN,Interface has sent an ack message for BCFAO-2012-0013893 to the remote CAD,This incident 20120605-ZN16-1057 has been sent to
Med - Sick Person              - 700 EL PORTAL                            -            - 07:53-Case - HPK-2012-000000244   - voyt park inj child[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0145967,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000244. [Shared],
Alarm - Fire         - 25302 Miranda Rdg              : 446A8   Dept 132E,126C,128E 01:25 pm - bedroom #4[Shared],childs resd aud 210-557-1420 poe gas alarm[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0146472,Automatic Case Number(s) issued for Grey Forest FD: GRYF-2012-000000200. [Shared],Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000430. [Shared],Automatic Case Nu
MVC                            - N Loop 1604 E / Stone Oak Pkwy           -            - 20:08-Case - HPK-2012-000000245   - mv ped acc........valero plot........chevy tahoe......unk lp...>[Shared][Shared],Multi-Agency SAFD Incident #: 120606-0390,caller stated tosapd, this will be in the pklot of valero, which is in hollywood park,Secondary Location for 3130B: ON INFO.... [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000245. [Shared],
Alarm - Medical                - 104 Garrapata Ln                         -            - 10:04-Case - HPK-2012-000000247   - Multi-Agency BCLE Incident #: HPPD-2012-0147298,aud  medical alarm res/martha falke #4948180  83 yoa  [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000247. [Shared],
Alarm - Fire                   - 155 William Classen Dr                   -            - 11:11-Case - BBUL-2012-000000719  - Multi-Agency BCLE Incident #: HPPD-2012-0147396,AUD   BUS/GURINSKY JEWELRY #7222776  POE/FIRE ALARM DOWNSTAIRS SMOKE [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000248. [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000719. [Shared],
Alarm - Fire         - 10734 Shaenview                - 546B6   - GVIL-2012-000001421  - 115C,128E,122E   04:26 pm
Alarm - Fire                    5819 Culberson Mill             577C4      HELO-2012-000000095  Dept-115E,122C,128E - aud. fire alarm. flores,marvin. 830-255-0398. no answer on call back[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0148428,Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001427. [Shared],Automatic Case Number(s) issued for District 7 FD: D7FR-2012-000000421. [Shared],Automatic Case Number(s) issued for Helotes FD: HELO-2012-000000095. [Shared],
Alarm - Fire                   ; 24811 Bogey Rdg                               ;Apt      ; 482F1 ; HPK-2012-000000249   Dept 103D,129E,SPK ;  Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000726.,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000249.,
Alarm - Fire                   ; 26003 Scenic Pass                             ;Apt      ; 450D6 ; HPK-2012-000000250   Dept 103B,129E,SPK ;  Bradley and Erin Machik  #830-438-6869[Shared],Fire panic alarm[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149032,ref 08723751 [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000728. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000250. [Shared],
Med - Sick Person              - 319 Yosemite                             -            - 05:18-Case - HPK-2012-000000251   - Multi-Agency BCLE Incident #: HPPD-2012-0149261,60yr old heart patient...bleeding from the biopsy from the bone marrow he had [Shared],This incident HPK-2012-0014258 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120609-ZN16-0283 [Shared],Unit - 731, status change to STATUS_DISPATCHED by ACADIAN at 06/09/2012 05:18:30 [Shared],Automatic Case Number(s) i
Med - Breathing Problems       - 153 Grand Oak                            -            - 22:01-Case - HPK-2012-000000252   - C is having trouble breathing, 88 yo female.[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0149710,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000252. [Shared],
Med - Fall                     - 230 Yosemite                             -            - 23:27-Case - HPK-2012-000000253   - fell coming out of the shower[Shared],female fell bump back of head[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0149768,88yo [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000253. [Shared],


Contact: "Dorian Davis (IT GUY)" <dorian@bexarcountyfire.org>
Sender: VisiNet.Command@sanantonio.gov
Med - Sick Person              ; 21746 Thunder Basin                           ;       ; 485B5 ; BBUL-2012-000000701  Dept-104B ;  mother is Emma Gardley, 90 yo.[Shared],C says his mother is mentally unstable, possibly violent, he cannot control her.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143660,This incident BBUL-2012-0013756 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120603-ZN16-1062 [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000701
MVC                            ; Us Hwy 281 N / Bulverde Rd                    ;       ; 451D6 ; BBUL-2012-000000702  Dept-103D ;  sb side gold tahoe vs blk car /female with neck pain[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143974,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000702. [Shared],unk age of female [Shared],
Med - Choking                  ; 734 Ottawa Way St                             ;       ; 451A4 ; BBUL-2012-000000699  Dept-103D ;  35 yo.[Shared],C says that her father has a bone in his throat, choking.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143557,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000699. [Shared],
MVC - OTV                      ; 21415 Battle Crk                              ;       ; 484E6 ; BBUL-2012-000000698  Dept-104A ;  C says a pickup truck crashed, behind loc.  unk injuries.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143514,white pickup [Shared],the vehicle crashed into some trees, vehicle is turned over [Shared],C says he may be trapped in the vehicle, people are attempting to get him out [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000698. [Shared],
Med - Sick Person              ; 849 Pine Eagle Ln                             ;       ; 451A4 ; BBUL-2012-000000704  Dept 103D ;  female trouble breathing 64yo[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0144879,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000704. [Shared],This incident BBUL-2012-0013867 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],
Med - Fall                     ; 855 Tecumseh Dr                               ;       ; 451A3 ; BBUL-2012-000000708  Dept 103C ;  68 yo female...fall now has sever body pain...170lb[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0145684,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000708. [Shared], 
Med - Sick Person              ; 23238 Bison Canyon                            ;Apt      ; 484B3 ; BBUL-2012-000000723  Dept 104A ;  50 yom fell; and is sweating[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0148106,acadian notified [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000723. [Shared],
Alarm - Fire                   ; 24811 Bogey Rdg                               ;Apt      ; 482F1 ; HPK-2012-000000249   Dept 103D,129E,SPK ;  Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000726.,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000249.,
Med - Chest Pain               ; 24539 Glass Canyon                            ;Apt      ; 482F1 ; BBUL-2012-000000729  Dept 104B ;  41 yo male, having chest pains.[Shared],Invalid address received:1  VERIZON-SE SECTOR-QF 450E7.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149066,awake and responsive [Shared],This incident BBUL-2012-0014236 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120608-ZN16-2020
Med - Seizure                  ; 4527 Echo Grove                               ;Apt      ; 484D6 ; BBUL-2012-000000730  Dept 104E ;  29 yoa female seizure[Shared],Invalid address received:3073  AT&T MOBILITY-SW SECTOR-QF 550F.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149117,starting to come out of it [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000730. [Shared],
Alarm - Medical                ; 838 Emerald Bay                               ;Apt      ; 482F1 ; BBUL-2012-000000732  Dept 103C ;  Multi-Agency BCLE Incident #: BCSO-2012-0149257,aud/medicl/res; analisa diaz/res'; 210-648-3962 [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000732. [Shared],
Med - Sick Person              ; 25675 Overlook Pkwy                           ;Apt2708  ; 451C8 ; BBUL-2012-000000731  Dept 104B ;  [Premise:  25675 OVERLOOK PKWY] [Medium] [Criminal Trespass Warning] VAN, SAMUEL JONES B/M DOB:09-04-1966 REFERENCE CASE 2011-BCSO-023624[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149230,[Premise:  25675 Overlook Pkwy] VAN, SAMUEL JONES B/M DOB:09-04-1966 REFERENCE CASE 2011-BCSO-023624,26yr old female was drinking alcohol and now has rapid heart rate, feels like her throat is closing [Shared],This
MVC                            ; BULVERDE RD / US HWY 281 N                    ;Apt      ; 451D6 ; BBUL-2012-000000733  Dept 103C ;  major[Shared],nb[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149352,acad notified [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000733. [Shared],
Alarm - Smoke                  ; 510 Reenie Way                                ;Apt      ; 482F2 ; BBUL-2012-000000735  Dept 104E ;  c states smoke detectors will not turn off- took out batteries and replaced them and alarm is still beeping[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149659,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000735. [Shared],
Med - Unconscious Person       ; 23808 Resort Pkwy                             ;Apt      ; 484E2 ; BBUL-2012-000000734  Dept 104A ;  [Premise:  23808 RESORT PKWY] [Medium] [Location Note] LOSS PREVENTION SECURITY FOR THE MARRIOTT 210-483-6660, THEY ARE FIRST RESPONDERS TO THIS LOCATION[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149578,[Premise:  23808 Resort Pkwy] LOSS PREVENTION SECURITY FOR THE MARRIOTT 210-483-6660, THEY ARE FIRST RESPONDERS TO THIS LOCATION,c/rprts they have a guest who has gone unconscious while by the swimmi
MED - PYSCHIATRIC PROBLEMS     ; 1219 Wilder Pond                              ;Apt      ; 451A6 ; BBUL-2012-000000738  Dept 103C ;  C BELIEVES MALE IS AT ABV RESIDENTS ;C HAS BEEN TRYIN TO CALL MALE -NO ANSWER.... [Shared][Shared],C RECV TEXT FROM SHAWN MC DONALD FROM CELL #210-771-5167-----TEXTING HE WAS GOIN TO END IT ALL ---JUST TOOK 25 PILLS OF TEMAZEPAM =ANTI ANX  WITH WHISKEY AND NOW FEELING SLEEPY.....C RQ OFCR TO CALL BACK W/ OUTCOME...  .UNK WPN / INTOX[Shared][Shared],Multi-Agency BCLE Incident #: BCSO-2012-0150265,Add Agency
Alarm - Fire                   ; 3040 Single Peak                              ;Apt      ; 451F4 ; HPK-2012-000000254   Dept 104B,129E,SPK ;  fire alarm...upstairs smoke detector...williamson residence...830-438-7561..gate code 0011[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0150233,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000737. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000254. [Shared],
MED - TOX INGEST - INTENTIONAL ; 1234 Wilder Pond                              ;Apt      ; 451B6 ; BBUL-2012-000000736  Dept 103D ;  Multi-Agency BCLE Incident #: BCSO-2012-0150168,36 yo female...prozac and other pills pt breathing somewhat responding [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000736. [Shared],

Med - Fall           - 8502 GLEN BREEZE               - 553F8 Dept-108B - ACADIAN: Unit:    731         10041536,Transferred incident: Remote   Reference Number: 20120603-ZN16-1180 by Stinson, Nathaniel T. From ACADIAN,Interface has sent an ack message for CAM-2012-0013763 to the remote CAD,10041536,This incident 20120603-ZN16-1180 has been sent to BCFA via the CAD2CAD Interface.,Unit - 731, status change to STATUS_RESPONDING by ACADIAN at 06/03/2012 23:07:18,ACADIAN HAS CHANGED
Fire-Authorized Burn      - 24440 Loma Verde          - RED GATE DR/TOPALA DR                    - 783B3  Dept-138B - unk what is burning[Shared],C says she sees smoke coming from her neighbors yard.  Unk address.[Shared],Invalid address received:220  VERIZON-E SECTOR-QF 783A4.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0142874,Automatic Case Number(s) issued for Sandy Oaks FD: SOAK-2012-000000498. [Shared],

*/

public class TXBexarCountyParser extends FieldProgramParser {
  
  private static final String MAP_PATTERN = "(?:\\d{3}[A-Z]\\d|SA\\d{3}(?:/[A-Z]\\d?)?)";
  private static final Pattern SEMI_DELIM = Pattern.compile("(?<= ) *; ");
  private static final Pattern DASH_DELIM_PTN = Pattern.compile(" +- ");
  private static final Pattern PROTECT_KEYWORD = Pattern.compile("(?<=:)  +(?=[^ ])");
  private static final Pattern BLANK_DELIM_PTN = Pattern.compile(" {4,}");
  private static final Pattern SHORT_BLANK_DELIM_PTN = Pattern.compile("(?<![ -])  +(?![ -])");
  private static final Pattern MAP_BLANK_DELIM_PTN = Pattern.compile(" " + MAP_PATTERN + " +(?=[^ -])");
  
  private static final Set<String> CALL_PREFIX_SET = new HashSet<String>(Arrays.asList(new String[]{
      "Alarm", "Assist", "Fire", "Med", "MED",
  }));
  
  private boolean dashStyle;
  
  public TXBexarCountyParser() {
    super("BEXAR COUNTY", "TX",
          "DATETIME? CALL CALL2? ADDR XAPT+? MAP ID? INFO+");
  }
  
  public String getFilter() {
    return "visinet.command@sanantonio.gov";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // New main format is semicolon delimted.  So let's give that a try
    body = body.replace(" ;Apt", " ; Apt");
    String flds[] = SEMI_DELIM.split(body);
    
    // If we don't get enough fields, fall back to using the old ugly logic
    dashStyle = false;
    if (flds.length < 5) {
      dashStyle = true;
      
      // The main format is usually dash delimited, but occasionally drops the dashes in favor on
      // long strings of blanks, which we will turn in regular dash delimiters
      // And then, they occasionally leave a single space delimiter after the Map field
      body = DASH_DELIM_PTN.matcher(body).replaceAll(" - ");
      body = PROTECT_KEYWORD.matcher(body).replaceAll(" ");
      body = BLANK_DELIM_PTN.matcher(body).replaceAll(" - ");
      body = MAP_BLANK_DELIM_PTN.matcher(body).replaceFirst("$0 - ");
      
      int pt = body.lastIndexOf(" - ");
      if (pt < 0) return false;
      body = SHORT_BLANK_DELIM_PTN.matcher(body.substring(0,pt)).replaceAll(" - ") + body.substring(pt);
      flds = body.split(" - ");
    }
    return parseFields(flds, data);
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d/\\d\\d )?(\\d\\d:\\d\\d(?: [ap]m)?)");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("KK:mm aa");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strDate = getOptGroup(match.group(1));
      String time = match.group(2);
      if (time.endsWith("m")) {
        setTime(TIME_FMT, time, data);
      } else {
        data.strTime = time;
      }
      return true;
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("*")) field = field.substring(1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyCall2Field extends CallField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {

      // The whole point it to correct for dashes in data field that got
      // confused with field delimiters, if we aren't using dash field
      // delimiters, there is no point
      if (!dashStyle) return false;
      
      // A numeric field is assumed to be part of a street range that will
      // be prepended to the address that is coming up next
      if (NUMERIC.matcher(field).matches()) {
        data.strAddress = field;
        return true;
      }
      
      // Otherwise see if the previous call description was one of the short keywords taht
      // we expect to be followed by a second call description
      // If it is, and this field doesn't start with zero, append it to the 
      // previous call description
      if (!CALL_PREFIX_SET.contains(data.strCall)) return false;
      if (field.length() == 0) return false;
      if (Character.isDigit(field.charAt(0))) return false;
      
      data.strCall = append(data.strCall, " - ", field);
      return true;
    }
  }
  
  private static final Pattern IH_PTN = Pattern.compile("\\bIh\\b", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String prefix = data.strAddress;
      data.strAddress = "";
      field = IH_PTN.matcher(field).replaceAll("I");
      super.parse(field, data);
      data.strAddress = append(prefix, "-", data.strAddress);
    }
  }
  
  private class MyCrossAptField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("Apt")) {
        data.strApt = append(data.strApt, " - ", field.substring(3).trim());
      } else if (field.startsWith("#")) {
        data.strApt = append(data.strApt, " - ", field.substring(1).trim());
      } else if (field.length() > 5) {
        data.strCross = append(data.strCross, " & ", field);
      } else {
        data.strApt = append(data.strApt, " - ", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "X APT";
    }
  }
  
  private static final Pattern ID_PTN = Pattern.compile("([A-Z]{3,4}-\\d{4}-\\d{6,})(?: +Dept[ -](.*))?");
  private class MyIdField extends IdField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = ID_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strCallId = match.group(1);
      data.strUnit = getOptGroup(match.group(2));
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  // Info field tries to clean up some of the more useless information
  private static final Pattern INFO_DEPT_PTN = Pattern.compile("^Dept[ -]([^ ]+?)(?: |$)");
  private static final Pattern ACADIAN_PTN = Pattern.compile("(?:\\bACADIAN:|\\[ProQA Script\\]) *");
  private static final Pattern SPEC_INFO_PTN = Pattern.compile("(?<=^|,) *Unit: *([^ ]+)\\b|" +                                // Unit:
                                                                  "(?<=^|,) *Dispatch code: *([^ ]+)\\b|" +                       // Dispatch code:
                                                                  "(?:(?:^|,)[^,]*?)?\\b([A-Z]{3,4}-\\d{4}-\\d{6,})\\b[^,]*");    // Call ID
  private static final Pattern TRASH_PTN = Pattern.compile("(?:^|,) *(?:A cellular re-bid |check the ANI/ALI |Invalid address received:|Automatic Case |\\[ProQA Session Aborted\\]|Transferred incident:|Acknowledgement Received |Reference Number:|status change to |This incident [-A-Z0-9]+ has been sent to |ACADIAN HAS CHANGED )[^,]*");
  private static final Pattern TRIM_PTN = Pattern.compile("^[, \\.]+|[, \\.]+$");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_DEPT_PTN.matcher(field);
      if (match.find()) {
        data.strUnit = append(data.strUnit, " ", match.group(1));
        field = field.substring(match.end()).trim();
      }
      field = ACADIAN_PTN.matcher(field).replaceAll("");
      match = SPEC_INFO_PTN.matcher(field);
      StringBuffer sb = new StringBuffer();
      while (match.find()) {
        if (match.group(1) != null) {
          data.strUnit = append(data.strUnit, " ", match.group(1));
        } else if (match.group(2) != null) {
          data.strCode = match.group(2);
        } else {
          if (data.strCallId.length() == 0) data.strCallId = match.group(3);
        }
        match.appendReplacement(sb, "");
      }
      match.appendTail(sb);
      field = sb.toString();
      field = TRASH_PTN.matcher(field).replaceAll("");
      field = field.replace("[Shared]", "");
      field = TRIM_PTN.matcher(field).replaceAll("");
      data.strSupp = append(data.strSupp, " - ", field);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT CODE ID INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.startsWith("T") && name.length()==2) return new SkipField(name, true);
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("CALL2")) return new MyCall2Field();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("XAPT")) return new MyCrossAptField();
    if (name.equals("MAP")) return new MapField(MAP_PATTERN, true);
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
