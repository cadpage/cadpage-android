package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

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
zTEST CALL                - 7895 Fair Oaks Pkwy           FAIR OAKS RANCH                   - 413D8   Dept 133C 132/134 Primary Dept This is a test call,Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000645.,
Rescue - Elevato  24365 Wilderness Oak                           FAIRWAY BRIDGE/MIDNIGHT PEAK                   483B2     BBUL-2012-000001328  Dept-104B          **103/104 Primary Dept** c/ states she has been stuck in the elevator for about 15 min[Shared],Invalid address received:83  SPRINT-NW SECTOR-QF 483D2.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0271650,[Notification] [BCFA]-Problem changed from Fire to Rescue - Elevator by BCFA [Shared],building 6 [Shared],states she is in building 6 [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000001328. [Shared]\r\n

Contact: Active911
Agency name: Ata-Bexar VFD
Location: San Antonio, TX, United States
Sender: VisiNet.Command@sanantonio.gov

Med - Animal Bit  279 Duke Rd                                    PVT RD AT 232 DUKE RD/ROBERT JARED        782D3    ATAB-2012-000000436 Dept- 101A **101 Primary Dept**Multi-Agency BCLE Incident #: BCSO-2012-0315988,9 YOA MALE BIT BY A SPIDER BETWEEN TOES, NOW SWELLING., C HAS THE SPIDER [Shared],[Notification] [BCFA]-Problem changed from Med - Sick Person to Med - Animal Bite by BCFA [Shared],[BCLE] has closed their incident [BCSO-2012-0315988],Automatic Case Number(s) issued for Ata-Bexar FD: ATAB-2012-000000436. [Shared],\r\n
Med - Sick Perso  24945 Pleasanton Rd                            DUKE RD/PEACEFUL LN                       782E4    ATAB-2012-000000435 Dept- 101B **101 Primary Dept**26 yo female fell a couple of days ago and hurt her rib[Shared],Invalid address received:55  SPRINT-W SECTOR-QF 784A2.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0315181,This incident ATAB-2012-0029542 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20121120-ZN16-1674 [Shared\r\n
Med - Sick Perso  895 Mogford                                    HARDWICK/DUKE DR                          782F4    ATAB-2012-000000434 Dept- 101A **101 Primary Dept**43 YO MALE PASSING OUT[Shared],Invalid address received:150  CRICKET-SE SECTOR-TBD.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0309971,[Notification] [BCLE]-Problem changed from 911 Abuse   to * EMS Only   by BCLE [Shared],Automatic Case Number(s) issued for Ata-Bexar FD: ATAB-2012-000000434. [Shared],\r\n
Med - Breathing   337 Hallmark Path                              PLEASANTON RD/Dead End                    750C8    ATAB-2012-000000433 Dept- 101C **101 Primary Dept**53 yo male...hospice pt throwing up shallow breathing..has liver problems[Shared],Invalid address received:55  SPRINT-W SECTOR-QF 784A2.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0309231,[Notification] [BCFA]-Problem changed from Med - Sick Person to Med - Breathing Problems by BCFA [Shared],This incident ATAB-2012-0029065 h\r\n
Fire - Tree / Br  Applewhite Rd / S Loop 1604 W                                                            749D3    ATAB-2012-000000432 Dept- 101C **101 Primary Dept**GRAS FIRE[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:8  CRICKET-SW SECTOR-TBD.[Shared],Invalid address received:8  CRICKET-SW SECTOR-TBD.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0308159,Overcast  52 F  11 C  Humidity54%Wind SpeedNE 3 mphBarometer30.39 inDewpoint36 F (2 C)Visibility10.00 miLast Update on 14 Nov 7:55 am CST   [Shared]\r\n
Med - Sick Perso  23831 Us Hwy 281 S                             S ADDISON/BIG OAK DR                      783A2    ATAB-2012-000000431 Dept- 101A **101 Primary Dept**Multi-Agency BCLE Incident #: BCSO-2012-0307300,19 yoa male having trouble breathing [Shared],Automatic Case Number(s) issued for Ata-Bexar FD: ATAB-2012-000000431. [Shared],\r\n
Med - Seizure     510 Shagbark                                   TIMBERWOOD LN/EL CONEJO                   750F8    ATAB-2012-000000430 Dept- 101A **101 Primary Dept**24 yo male...hit head after siezure, pt is feeling tingley and can't walk, breathing, eyes open[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0306633,[Notification] [BCFA]-Problem changed from Med - Sick Person to Med - Seizure by BCFA [Shared],Automatic Case Number(s) issued for Ata-Bexar FD: ATAB-2012-000000430. [Shared],\r\n
Med - Fall        23225 Us Hwy 281 S                             N ADDISON/S ADDISON                       783A1    ATAB-2012-000000429 Dept- 101C **101 Primary Dept**55 yo female...pt fell off ladder happened about 15-20 mins ago...has huge bump on the back of her head...pt is breathing and talking[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0306475,[Notification] [BCFA]-Problem changed from Med - Sick Person to Med - Fall by BCFA [Shared],This incident ATAB-2012-0028885 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACAD\r\n
Med - Choking     25624 Progress Rd                              MARTHA RD/HUME RD                              783A6     Dept- B138,138C,138E,101C  81 year old female choking on food[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0305790,Automatic Case Number(s) issued for Sandy Oaks FD: SOAK-2012-000001073. [Shared],[Appended, 17:49:27] ACADIAN: Unit:    766         10403133 [Shared],[Appended, 17:49:27] Transferred incident: Remote   Reference Number: 20121111-ZN16-0947 by Robichaux, Michael P. From ACADIAN [Shared],[Appended, 17:49:27] Interface h\r\n
MVC               Englehart Rd / Pleasanton Rd                                                             750D7    ATAB-2012-000000427 Dept- 101C **101 Primary Dept**C says there is an empty running vehicle in a ditch near above location.  C looks like there was an accident, the window is smashed.[Shared],Invalid address received:3232  AT&T-SE SECTOR-QF 750B4.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0305498,Automatic Case Number(s) issued for Ata-Bexar FD: ATAB-2012-000000427. [Shared]\r\n

Fire              Sassafras / Forsythia                                                                         452B7     BBUL-2012-000001643  Dept-104E          **103/104 Primary Dept** Strong smell of natural gas in area.  Unknown which house it is coming from.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0337978,[BCLE] has closed their incident [BCSO-2012-0337978],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000001643. [Shared],\r\n
MVC - OTV         24345 Wilderness Oak                           FAIRWAY BRIDGE/MIDNIGHT PEAK                   483A2     BBUL-2012-000001635  Dept-104A          **103/104 Primary Dept** [Address:  24345 WILDERNESS OAK] [Medium] [Criminal Trespass Warning] RYAN DAILEY B/M DOB: 10-28-96, AVERY HOLLIS W/M DOB: 01-01-1997, ERNEST NORIEGA W/M DOB: 05-22-1996 REFERENCE CASE 2011-BCSO-015068[Shared],[Premise:  24345 WILDERNESS OAK] [Medium] [Criminal Trespass Warning] RYAN DAILEY B/M DOB: 10-28-96, AVERY HOLLIS W/M DOB: 01-01-1997, ERNEST NORIEGA W/M DOB: 05-22-1996 REFERENCE CASE 2011-BCSO-0150\r\n
Gas/Fuel - Leak   4707 Bending Grove                             BIRDS ELM/BRANCHING BAY                        484E5     BBUL-2012-000001626  Dept-104B          **103/104 Primary Dept** Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000001626.,\r\n

Contact: Active911
Agency name: OEMBCFMO
Location: San Antonio, TX, United States
Sender: VisiNet.Command@sanantonio.gov

zFMO  2928-2999 BUTTERFLY PALM                       REDFISH CAVERN/Dead End                                  2013-119-0000527     Dept-FMO06,FMO07**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-119-0000527.,FMO06:CREATED CALL FROM MOBILE,
zFMO  711 W MAYFIELD                                                                                          2013-119-00848       Dept-FMO30**BCFA OUTSIDE AREA**FMO30:CREATED CALL FROM MOBILE,SAPD FUEL,Automatic Case Number(s) issued for FM Insp: 2013-119-00848.,
zFMO  16525 SENIOR RD                                                                                         2013-119-00846       Dept- FMO30**INSPECTOR PAGE**FMO30:CREATED CALL FROM MOBILE,TAZ SERVICES,Automatic Case Number(s) issued for FM Insp: 2013-119-00846.,
zFMO  7205 HANZI                                     Dead End/SE MILITARY DR                                  2013-119-0000526     Dept-FMO07**BCFA OUTSIDE AREA**FMO07:CREATED CALL FROM MOBILE,one adult female and one juvenile male// starting mileage 109555,Automatic Case Number(s) issued for FM Invest: 2013-119-0000526.,
zFMO  622 Dolorosa                                                                                            2013-119-0000525     Dept- FMO07**INVESTIGATOR PAGE**FMO07:CREATED CALL FROM MOBILE,Transporting one adult female and one juvenile male//starting mileage:109546,Automatic Case Number(s) issued for FM Invest: 2013-119-0000525.,
zFMO  8130 Inner Circle                                                                                       2013-119-0000524     Dept- FMO08**INVESTIGATOR PAGE**FMO08:CREATED CALL FROM MOBILE,ast BCOEM/,Automatic Case Number(s) issued for FM Invest: 2013-119-0000524.,
Fire - Vehicle        11215 Vollmer Ln                546A8     2013-119-0000522      E115,128A,E116,E128,FMO05,115A **115/116 Primary Dept** C says that her vehicle in front of her house is on fire.[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0133750,Automatic Case Number(s) issued for District 7 FD: D7FR-2013-000000356. [Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details [Shared],Invalid address received:1440  TMOBILE-SW SECTOR-QF 546E3. [Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details
Fire  7509 NEW SULPHUR SPGS                          BLANDFORD/BLANDFORD                            653F6     2013-118-0000521     Dept-E120,U110,142A,136A,E127,T142,B127,U120,B120B,B110,R110,B136**BCFA OUTSIDE AREA**structure fire.. cps energy crews can see it from a small distance..[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0133130,structure fire.. cps energy crews can see it from a small distance..   [Shared],Automatic Case Number(s) issued for China Grove FD: CGRV-2013-000000110. [Shared],Automatic Case Number(s) issued for Gardendale FD: GARD-2013-000000128. [Shared],Automatic Case Number(s) issued for Harmo
Assist - Law Enf  21700-blk US HWY 281 S                         ROCKPORT RD/ROCKPORT RD                        751A5     Dept- FMO05  Multi-Agency BCLE Incident #: BCSO-2013-0130850,[Notification] [BCFA]-Problem changed from * BCFA Fire Emergency to Assist - Law Enforcement by BCFA [Shared],Automatic Case Number(s) issued for FM Invest: 2013-115-0000518. [Shared],
zFMO - Special A  23319 Mesquite Bend                            Dead End/MESQUITE CV                           783D1     Dept- FMO05  DTR BOYFRIEND HAS NOT PICKED UP ITEMS FROM ABOVE LOC   C STATED BOYFRIEND CALLED BEING OTW BUT STILL NOT AT LOC[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0130783,Automatic Case Number(s) issued for FM Invest: 2013-115-0000517. [Shared],
Fire - Tree / Br  25671 Mathis Rd                                HARDY RD/HARDY RD                              784C6     Dept- E101,E162,E161,BC161,127E,B162,FMO05,FMO90,162C,161B,101C  HOUSE NEXT DOOR TO THE LEFT IS ON FIRE   FLAMES & SMOKE[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0127884,Automatic Case Number(s) issued for Ata-Bexar FD: ATAB-2013-000000175. [Shared],Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2013-000001649. [Shared],C WILL GET OUT OF HIS HOUSE [Shared],Backed up E161 with BC161 [Shared],Automatic Case Number(s) issued for Harmony FD: HARM-2013-
zFMO  622 dolorosa                                                                                            2013-115-0000514     Dept- FMO05**INVESTIGATOR PAGE**Automatic Case Number(s) issued for FM Invest: 2013-115-0000514.,
zFMO  West, Tx                                                                                                2013-114-0000511     Dept- FMO07,FMO08**INVESTIGATOR PAGE**FMO07:CREATED CALL FROM MOBILE,1608, 1606, 1616,Automatic Case Number(s) issued for FM Invest: 2013-114-0000511.,FMO07 - please assign veh AR152,
zFMO  400 N OLIVE ST                                 E CROCKETT ST/BOSTON                           617B5     SPK-2013-000000222   Dept-FMO30,M139B,FMO30**BCFA OUTSIDE AREA**FMO30:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-112-00811.,This is actually in Dallas Texas......,Automatic Case Number(s) issued for Shavano Park FD: SPK-2013-000000222.,
Med - Bleeding    112 W Mossy Cup Ln                             MOSSY CUP/Dead End                             515B4     2013-113-00830       Dept- M139B,E139,FMO30,139D **139 Primary Dept**  83 yom fallen injry..bleeding from head,Automatic Case Number(s) issued for Shavano Park FD: SPK-2013-000000221.,Backed up M139B with E139,Automatic Case Number(s) issued for FM Insp: 2013-113-00830.,
zFMO  5554-5571 DUFFEK DR                            Dead End/ACKERMAN RD                                     2013-113-0000509     Dept-FMO06**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-113-0000509.,
zFMO  217 GUILFORD FORGE                             RISING STAR/WAGON CROSSING                               2013-113-0000508     Dept-FMO05**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-113-0000508.,
zFMO  5560 DUFFEK DR                                 Dead End/ACKERMAN RD                                     2013-113-0000506     Dept-FMO06**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-113-0000506.,FMO06:CREATED CALL FROM MOBILE,
zFMO  2819 Se Military Dr                            S NEW BRAUNFELS AVE/HANZI                      651E8     2013-113-0000505     Dept-FMO08**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-113-0000505.,
zFMO  5600 blk gawain                                                                                         2013-113-0000504     Dept- FMO07**INVESTIGATOR PAGE**FMO07:CREATED CALL FROM MOBILE,2013-FM-009,Automatic Case Number(s) issued for FM Invest: 2013-113-0000504.,
zFMO - Interview - Witnes 21 Park Mounain                                                                                      2013-122-0000546     Dept- FMO08**Inv Check Out**FMO08:CREATED CALL FROM MOBILE,2013-FM-068,Automatic Case Number(s) issued for FM Invest: 2013-122-0000546.,

Contact: Active911
Agency name: OEMBCFMO
Location: San Antonio, TX, United States
Sender: VisiNet.Command@sanantonio.gov

zFMO - Inspection Followu 22115 US Hwy. 281 S                                                                                  2013-172-01289       Dept- FMO36 **OUTSIDE BCFA AREA** FMO36:CREATED CALL FROM MOBILE,followup construction,Automatic Case Number(s) issued for FM Insp: 2013-172-01289.,
zFMO - Inspectio      6619 QUAIL LAKE                                                                                                2013-172-01286       Dept- FMO14**145 Primary Dept**FMO14:CREATED CALL FROM MOBILE,HILL QUALITY CHILDCARE,Automatic Case Number(s) issued for FM Insp: 2013-172-01286.,
zFMO - Special Assignment 4900-5199 PRUE RD                             FREDERICKSBURG RD/LAUREATE DR                          2013-172-01282       Dept- FMO10 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-172-01282.,
zFMO - Investigation Foll  622 Dolorosa                                                                                            2013-172-0000766    Dept-FMO05**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-172-0000766.,
Fire - Structure     - 17396 Low Rd                   #       - 512D3    - 2013-171-0000763     Depts-E116,E126B,C115,T115,T128,FMO05,126E,128E,115E - 126 Primary Dept fire in living room[Shared],Invalid address received:234  SPRINT-NE SECTOR-QF 512C5.[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0193610,Automatic Case Number(s) issued for Grey Forest FD: GRYF-2013-000000237. [Shared],Automatic Case Number(s) issued for Helotes FD: HELO-2013-000000099. [Shared]
zFMO - Inspectio    5565 Mansions Bluff                                                                                             2013-171-01275        Dept-FMO36    **D2FR Primary Dept** FMO36:CREATED CALL FROM MOBILE,Rough In inspections,Automatic Case Number(s) issued for FM Insp: 2013-171-01275.,
zFMO - Investigation Foll 7918 DEMPSEY DR                               HILLBURN DR/GAVILAN DR                        648D8    2013-171-0000762     Dept- FMO05 **OUTSIDE BCFA AREA** FMO05:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Invest: 2013-171-0000762.,
Fire - Structure      6711 SUNLIT PASS DR                             Dead End/BENDING CREST                            553D6        2013-171-0000759     Dept- C145,E145B,Q145,FMO05,145B,111E,108E,131B**145 Primary Dept**STATES HOUSE BEHIND THEM HOUSE IS ON FIRE[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0192770,STATES THE CORNER OF THE HOUSE IS ON FIRE ; STATES ITS SMALL [Shared],Automatic Case Number(s) issued for Windcrest FD: WIND-2013-000000967. [Shared],Automatic Case Number(s) issued for Camelot FD: CAM-2013-000000600. [Shared],CAMELOT OUT OF SERVICE//KIRBY AND CONVERSE RESPONDING [Shared],ALL COMMUNICATIONS ON
zFMO - Inspectio  21806 Hwy. 281 S.                                                                                       Dept- FMO36  FMO36:CREATED CALL FROM MOBILE,Inspection followup.,Automatic Case Number(s) issued for FM Insp: 2013-170-01268.,
zFMO - Inspection         6415 MONTGOMERY RD                                                                                   2013-170-01265       Dept- FMO30 **OUTSIDE BCFA AREA** FMO30:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-170-01265.,
zFMO - Investigation Foll 300-399 LA GARDE ST                           PALOS/CALERA                                           2013-170-0000758     Dept- FMO05 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-170-0000758.,
zFMO - Inspection         211 RED QUILL NEST                                                                                   2013-170-01264       Dept- FMO10 **INSPECTOR PAGE** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-170-01264.,
Fire - Structure  20295 Somerset Rd               W DIXON RD/Dead End                       747B3     2013-170-01259       Dept- E140,T140,FMO12,140C,130D,119B,206D  Multi-Agency BCLE Incident #: BCSO-2013-0191966,LIGHTS ARE SMOKING  [Shared],[Notification] [BCFA]-Problem changed from Fire to Fire - Structure by BCFA [Shared],CIRCUIT BREAKERS HAVE GONE OFF. [Shared],Automatic Case Number(s) issued for Somerset FD: SOM-2013-000000456. [Shared],Automatic Case Number(s) issued for ESD5 FD: ESD5-2013-000000607. [Shared],Automatic Case Number(s) issued for Lytle FD: LYTL-20
zFMO - Meeting            3201 E HOUSTON ST                             COCA COLA PLACE/AT AND T CENTER PKWY          617F5    2013-170-01258       Dept- FMO30 **OUTSIDE BCFA AREA** FMO30:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-170-01258.,
zFMO - Inspection         11026 Culebra Rd                                                                                     2013-170-01257       Dept- FMO34 **INSPECTOR PAGE** FMO34:CREATED CALL FROM MOBILE,VHS/BLD Final,Automatic Case Number(s) issued for FM Insp: 2013-170-01257.,
zFMO - Inspectio  4375 S LOOP 1604                                                                              752D3     Dept- FMO36  FMO36:CREATED CALL FROM MOBILE,Hydro - Final x2,Automatic Case Number(s) issued for FM Insp: 2013-170-01253.,
zFMO - Investigation Foll 622 dolorosa                                                                                         2013-170-0000757     Dept- FMO05 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-170-0000757.,
zFMO - Special Assignment 800-903 SAN LUIS ST                           S SALADO ST/S COMAL ST                                 2013-170-01250       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-170-01250.,
zFMO - Investiga    200 N Comal                                                                                                     2013-169-0000754      Dept-FMO08    **D2FR Primary Dept** FMO08:CREATED CALL FROM MOBILE,2013-FM-096,Automatic Case Number(s) issued for FM Invest: 2013-169-0000754.,
zFMO - Inspection         24891 Boerne Stage rd                                                                                2013-169-01245       Dept- FMO10 **OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-169-01245.,
zFMO - Inspectio      4375 S. Loop  1604 E.                                                                                          2013-169-01244       Dept- FMO36**145 Primary Dept**FMO36:CREATED CALL FROM MOBILE,Hydro test.,Automatic Case Number(s) issued for FM Insp: 2013-169-01244.,
zFMO - Inspection         24188 BOERNE STAGE RD                         BAYWATER STAGE/CROSS MOUNTAIN TRL                      2013-169-01242       Dept- FMO10 **OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-169-01242.,
zFMO - Inspectio    28036 Boerne Stage Rd             DOS CERROS DR/BRIDLEWOOD TRL                446C3       2013-169-01240       Dept- FMO10 **132 Primary Dept** leon springs fd #4,Automatic Case Number(s) issued for FM Insp: 2013-169-01240.,
zFMO - Special Assignment  7337 Louis pasteur                                                                                      2013-169-0000750    Dept-FMO08**Inv Page*FMO08:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Invest: 2013-169-0000750.,
zFMO - Investigation      6614-6637 S NEW BRAUNFELS AVE                 PVT RD AT 6639 S NEW BRAUNFELS/PVT RD AT 6639          2013-169-0000749     Dept- FMO05 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-169-0000749.,
Fire - Structure  15198 QUESENBERRY RD           SOMERSET RD/Dead End                      714B3     2013-169-0000748     Dept -E130,E119,T140,FMO13,140D,130C,119E,206E     *** 130 Primary Dept ***C/ STATES THERE IS A HOUSE ON FIRE[Shared],Invalid address received:362  SPRINT-N SECTOR-QF 748F8.[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0190104,STATES ITS NEXT DOOR NEIGHBORS HOUSE THAT IS ON FIRE [Shared],Automatic Case Number(s) issued for Jarret FD: JARR-2013-000000322. [Shared],Automatic Case Number(s) issued for Somerset FD: SOM-2013-000000448. [Shared],Automatic Case Number(s) issued for E
zFMO - SELF INITIATED ACT 401 S Frio St                                 W DURANGO BLVD/SB IH 35 S OFRP S FRIO         616D5    2013-168-0000747     Dept- FMO05 **OUTSIDE BCFA AREA** obtaining search warrant,Automatic Case Number(s) issued for FM Invest: 2013-168-0000747.,
zFMO - Inspection         13830 Southton Rd.                                                                                   2013-168-01229       Dept- FMO36 **OUTSIDE BCFA AREA** FMO36:CREATED CALL FROM MOBILE,Construction Follow up.,Automatic Case Number(s) issued for FM Insp: 2013-168-01229.,
zFMO - Inspectio      13117 Donop Rd.                                                                                                2013-168-01227       Dept- FMO36**145 Primary Dept**FMO36:CREATED CALL FROM MOBILE,Inspection follow up/ permit.,Automatic Case Number(s) issued for FM Insp: 2013-168-01227.,
zFMO - Inspectio      10880 US HWY 181 S                              GREEN LAKE DR/GREEN LAKE DR                       684F6        2013-168-01226       Dept- FMO36**145 Primary Dept**FMO36:CREATED CALL FROM MOBILE,Fuel tank permit followup.,Automatic Case Number(s) issued for FM Insp: 2013-168-01226.,
zFMO - Inspection         4375 S. Loop 1604 E.                                                                                 2013-168-01224       Dept- FMO36 **INSPECTOR PAGE** FMO36:CREATED CALL FROM MOBILE,Hydro final 2hrs.,Automatic Case Number(s) issued for FM Insp: 2013-168-01224.,
zFMO - SELF INITIATED ACT 622 Dolorosa                                                                                         2013-168-0000743     Dept- FMO06 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-168-0000743.,
zFMO - Assist Other Agenc 2125 Universal City Blvd                      EL DORADO/SUNRISE CANYON DR                   554D2    2013-167-0000740     Dept- FMO05 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-167-0000740.,
(FW: ) Fire - Structure  14725 LADD RD                   MILES RD/W KELLER RD            676D8      Dept-E140,E130,E119,E206,B118,Q140,T140,E706,FMO08,149A,RB149,118 2013-FM-0000097          **118/119 Primary Units**house behind this address on ladd rd is on fire the whole house is in flames[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0187199,Automatic Case Number(s) issued for ESD5 FD: ESD5-2013-000000590. [Shared],Automatic Case Number(s) issued for Somerset FD: SOM-2013-000000438. [Shared],Automatic Case Number(s) issued for Jarret FD: JARR-2013-000000318. [Shared],Automatic Case Number(s) issued for Lytle FD:
zFMO - Special Assignment 203 w nueva                                                                                          2013-165-01218       Dept- FMO10 **INSPECTOR PAGE** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-165-01218.,
zFMO - Investigation Foll  622 Dolorosa                                                                                            2013-165-0000737    Dept-FMO06**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-165-0000737.,
zFMO - Inspection         16840 Shepard Rd.                                                                                    2013-165-01216       Dept- FMO36 **INSPECTOR PAGE** FMO36:CREATED CALL FROM MOBILE,Hyodr test 2hr.,Automatic Case Number(s) issued for FM Insp: 2013-165-01216.,
zFMO - Investigation Foll  622 Dolorosa                                                                                            2013-165-0000736    Dept-FMO05**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-165-0000736.,
zFMO - Inspection         12635-12799 US HWY 181 S                      MAX RD/W LAGUNA RD                                     2013-165-01214       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-165-01214.,FMO12:CREATED CALL FROM MOBILE,12751 hwy 181 s,
zFMO - Inspectio    24891 BOERNE STAGE RD             BAYWATER STAGE/BROAD OAK TRL                479B1       2013-165-01213       Dept- FMO34 **132 Primary Dept** FMO34:CREATED CALL FROM MOBILE,UFL Hydro,Automatic Case Number(s) issued for FM Insp: 2013-165-01213.,
zFMO - SELF INITIATED ACT 622 Dolorosa                                                                                         2013-165-0000734     Dept- FMO06 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-165-0000734.,
zFMO - Inspectio    19414 BABCOCK RD                  HEUERMANN RD/KYLE SEALE PKWY                479D8       2013-165-01208       Dept- FMO34 **132 Primary Dept** FMO34:CREATED CALL FROM MOBILE,UFL Visual/Hydro,Automatic Case Number(s) issued for FM Insp: 2013-165-01208.,
Gas/Fuel - Leak   4105 S Loop 1604 E                             EAGLE FORD COMMON/IH 37 S                      752C3     Dept- BC161,E162,FMO24,E161,FMO00,162E  C says there is a truck in the back that is leaking some kind of fluid.  Unk what it is.  Possibly flamable[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0185957,At the Pilot [Shared],C says it is a tanker truck that is leaking right out of the tank. [Shared],[Notification] [BCFA]-Problem changed from Fire to Gas/Fuel - Spill by BCFA [Shared],C says that the driver says it is Argon [Shared],Driver saying
zFMO - Special Assignment 6784-6901 CULEBRA RD                          AVE G/NW LOOP 410                                      2013-164-01204       Dept- FMO10 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-164-01204.,
zFMO - Inspection Followu 12573-12635 US HWY 181 S                      WESTERN TRAILS/MAX RD                                  2013-164-01199       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-164-01199.,FMO12:CREATED CALL FROM MOBILE,
zFMO - Inspection         4628-4645 S FLORES RD                         LAMM RD/S LOOP 1604 E                                  2013-164-01195       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-164-01195.,
zFMO - Meeting            100 Dolorosa                                  W MARKET ST/S MAIN AVE                        616E5    2013-164-0000730     Dept- FMO05 **OUTSIDE BCFA AREA** [Premise:  100 DOLOROSA] [Medium] [Criminal Trespass Warning] FUENTES, JOAQUIN JULIAN W/M DOB: 03-08-1960 REFERENCE CASE 2011-BCSO-050884,[Address:  100 DOLOROSA] [Medium] [Criminal Trespass Warning] FUENTES, JOAQUIN JULIAN W/M DOB: 03-08-1960 REFERENCE CASE 2011-BCSO-050884,meeting at the DA's office,Automatic Case Number(s) issued for FM Invest: 2013-164-0000730.,
zFMO - Inspection         4272-4283 S FLORES RD                         NB IH 37 S OFRP FLORES RD/OLD LAMM RD                  2013-164-01191       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-164-01191.,FMO12:CREATED CALL FROM MOBILE,
Med - Burns          5930 Beck Rd               SOUTH FORK LN/RUTH LEE DR       654C5    Dept-R136,FMO06,136C   ** 136 Primary Dept ** 55 yo female. burned on arm-face- hands. acad notified[Shared],Invalid address received:1451  TMOBILE-SW SECTOR-QF 621B5.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0184924,Automatic Case Number(s) issued for Lone Oak FD: LOAK-2013-000000251. [Shared],[Appended, 08:35:49] ACADIAN: Unit:    740         10916568 [Shared],[Appen
zFMO - Inspection         20005 Liedecke Rd.                                                                                   2013-164-01189       Dept- FMO36 **OUTSIDE BCFA AREA** FMO36:CREATED CALL FROM MOBILE,Final Temp. Trailer inspection.,Automatic Case Number(s) issued for FM Insp: 2013-164-01189.,
zFMO - Inv Surveillance    LA GARDE ST / GOLIAD RD                      BARKMEYER/GOLIAD RD                                    2013-163-01186       Dept- FMO10 **OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-163-01186.,
zFMO - Inspectio      4375 S. Loop 1604                                                                                              2013-163-01184       Dept- FMO36**145 Primary Dept**FMO36:CREATED CALL FROM MOBILE,Final Cement Plant,Automatic Case Number(s) issued for FM Insp: 2013-163-01184.,
zFMO - SELF INIT  622 DOLOROSA                                                                                            2013-163-01181       Dept-FMO14          **103/104 Primary Dept** Automatic Case Number(s) issued for FM Insp: 2013-163-01181.,
zFMO - Inspectio  11203 PECAN CANYON              ROYAL CANYON/MAGIC CANYON       646A4      Dept-FMO10 2013-163-01174           **118/119 Primary Units**FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-163-01174.,
zFMO - Inspection         10742-10951 KOSUB                             PVT RD AT 10786 KOSUB/PVT RD AT 10951 KOSUB            2013-163-01173       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-163-01173.,FMO12:CREATED CALL FROM MOBILE,
Fire - Structure  24205 Alpine Lodge                             HEAVENS PEAK/SEVEN WINDS                       483C2     2013-162-0000723     Dept-E139B,E103,Q104,BC103,Q129,C104,E104,R149B,FMO08,104E,129E,1          **103/104 Primary Dept** LIGHTENING HIT HOUSE...ROOF IS ON FIRE[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0183080,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2013-000000781. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2013-000000243. [Shared],Automatic Case Number(s) issued for Shavano Park FD: SPK-2013-000000328. [Shared],FG3 [Shared],Backed up E103 with Q104 [Shared],Backed up E103 w
zFMO - Inspection Fire Wa 3201 E HOUSTON                                                                                       2013-162-01172       Dept- FMO30 **OUTSIDE BCFA AREA** FMO30:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-162-01172.,
zFMO - SELF INITIATED ACT  Wandering                                                                                               2013-162-0000722    Dept-FMO01**Inv Page*FMO01:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Invest: 2013-162-0000722.,
Fire - Tree / Br  14402 Mangold Way               Dead End/MILES RD               676D7      Dept-B119,130B,B130,E119,FMO10,118B 2013-162-01162           **118/119 Primary Units**PROPERTY ON FIRE BEHIND HER LOCATION[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0182786,Automatic Case Number(s) issued for ESD5 FD: ESD5-2013-000000580. [Shared],Automatic Case Number(s) issued for Jarret FD: JARR-2013-000000311. [Shared],B119  1 ACRE BURN AT THIS TIME [Shared],Mostly Cloudy  NA  HumidityNA  Wind SpeedSE 9 mph  Barometer30.03 in  DewpointNA  Visibility10.00 mi  Last Update on 11 Jun
zFMO - Special Assignment 23954-24152 IH 10 W                           OLD FREDERICKSBURG RD/BOERNE STAGE RD                  2013-162-01161       Dept- FMO10 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-162-01161.,FMO10:CREATED CALL FROM MOBILE,Wash tub,
zFMO - Inspection         9939 SABLE ARROW                              GEMSBUCK CHASE/GAZELLE FOREST                 578D5    2013-162-01160       Dept- FMO10 **OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-162-01160.,
zFMO - Investigation Foll  8601 Midcrown                                                                                           2013-162-0000717    Dept-FMO06**Inv Page*FMO06:CREATED CALL FROM MOBILE,Windcrest PD,Automatic Case Number(s) issued for FM Invest: 2013-162-0000717.,
zFMO - Inspection         24911 N SADDLE TRAIL                                                                        NOT FOUN 2013-162-0000716     Dept- FMO01 **OUTSIDE BCFA AREA** FMO01:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Invest: 2013-162-0000716.,
zFMO - Inspection Followu 100-199 DANIEL RD                             FM 1346/Dead End                                       2013-162-01153       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-162-01153.,
zTEST CALL                203 W Nueva                                   S FLORES ST/S LAREDO ST                       616E5    2013-161-0000715     Dept- FMO44 **OUTSIDE BCFA AREA** TEST CALL ONLY,Automatic Case Number(s) issued for FM Invest: 2013-161-0000715.,
zFMO - Special Assignment 3201 E Houston St                                                                                    2013-161-01150       Dept- FMO10 **INSPECTOR PAGE** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-161-01150.,
zFMO - Investigation      3838 PAVO VIEJO                               MONTE SECO/FAIRLAWN DR                                 2013-161-0000713     Dept- FMO05 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-161-0000713.,FMO05:CREATED CALL FROM MOBILE,
Plane Safely Landed at boerne stage airfield. All Units cancelled
Aircraft Emergen    28102 Old Boerne Stage Rd                                                     446C3       2013-159-0000711     Dept- E134,R132,FMO13,134D **132 Primary Dept** Plane Coming in with no landing gear,Automatic Case Number(s) issued for Leon Springs FD: LSPR-2013-000000519.,Multi-Agency BCLE Incident #: BCSO-2013-0180049,This incident LSPR-2013-0016462 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20130608-ZN16-1453 [Shared],Unit - 741, status change to STATUS_DISPATCHED by ACADIAN at 06/08/2013 18:24:55 [Shared],U
zFMO - SERVING WARRANT     10315 margherita hill                                                                                   2013-158-0000710    Dept-FMO07**Inv Page*FMO07:CREATED CALL FROM MOBILE,one in custody,Automatic Case Number(s) issued for FM Invest: 2013-158-0000710.,
zFMO - SELF INIT  25080 Us Hwy 281 N                             SENDERO VERDE/WILDERNESS OAK                   451D8     2013-158-01147       Dept-FMO14          **103/104 Primary Dept** Automatic Case Number(s) issued for FM Insp: 2013-158-01147.,
zFMO - Inspection Followu 4608-4675 BECK RD                             US HWY 87 E/MICHELLE PASS                              2013-158-01146       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01146.,
zFMO - Inspection         67102 Echanted Eve                                                                          NOT FOUN 2013-158-01145       Dept- FMO14 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01145.,
zFMO - Inspection Followu 8400-8448 US HWY 87 E                         TRIPLE TREE DR/KIRKNER RD                              2013-158-01144       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01144.,
zFMO - Inspection Followu 9108-9298 US HWY 87 E                         LOOP 106/MONACO CIR                                    2013-158-01143       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01143.,
zFMO - Inspection Followu 12229-12271 US HWY 181 S                      S FOSTER RD/WESTERN TRAILS                             2013-158-01142       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01142.,
zFMO - Inspection         10710 Fm 78                                   NORTH ST/E FM 1518 N                          555C3    2013-158-01140       Dept- FMO14 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01140.,
zFMO - Inspection Followu 10233-10329 US HWY 181 S                      NB IH 37 S OFRP US HIGHWAY 181/NB IH 37 S OFR          2013-158-01138       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01138.,FMO12:CREATED CALL FROM MOBILE,10236 hwy 11 s.,
zFMO - SELF INIT      8811 Waterside                                  BRIDINGTON/HAVEN SIDE                             553D7        2013-158-01137       Dept- FMO14**145 Primary Dept**Automatic Case Number(s) issued for FM Insp: 2013-158-01137.,
zFMO - Investigation Foll  622 dolorosa                                                                                            2013-158-0000709    Dept-FMO05**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-158-0000709.,
zFMO - Special Assignment 622 DOLOROSA                                  CALDER/S LAREDO ST                            616E5    2013-158-01136       Dept- FMO10 **OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-158-01136.,
zFMO - FD Traini  6658 FM 1346                    S FOSTER RD/KIEFER RD                     619D6    2013-157-0000708      Dept-FMO08,FMO07       **120 Primary Dept ** Automatic Case Number(s) issued for FM Invest: 2013-157-0000708.,FMO08:CREATED CALL FROM MOBILE,FACTTS training- Gardendale VFD,
zFMO - FD Training         6658 E Houston                                                                                          2013-157-0000708    Dept-FMO08**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-157-0000708.,
zFMO - SELF INITIATED ACT  2829-2999 ACKERMAN RD                                                                                   2013-157-0000707    Dept-FMO06**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-157-0000707.,
zFMO - Inspection Fire Wa 3201 E HOUSTON                                                                                       2013-157-01135       Dept- FMO30 **INSPECTOR PAGE** FMO30:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-157-01135.,
zFMO - Inspection Fire Wa SW BEXAR COUNTY                                                                                      2013-157-01132       Dept- FMO30 **INSPECTOR PAGE** Automatic Case Number(s) issued for FM Insp: 2013-157-01132.,
zFMO - Inspection         2000-2050 ACAPONETA AVE                       Dead End/ROSA ST                                       2013-157-01131       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-157-01131.,
zFMO - Inspection Fire Wa S BEXAR COUNTY                                                                                       2013-157-01130       Dept- FMO30 **INSPECTOR PAGE** Automatic Case Number(s) issued for FM Insp: 2013-157-01130.,
zFMO - Inspection Fire Wa SE BEXAR COUNTY                                                                                      2013-157-01127       Dept- FMO30 **INSPECTOR PAGE** FMO30:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-157-01127.,
zFMO - SELF INITIATED ACT 4734-4799 SEGUIN RD                           IH 35 N/BINZ-ENGLEMAN RD                               2013-157-0000705     Dept- FMO06 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-157-0000705.,
Fire - Unauthori  Freudenburg Rd / N Graytown Rd                                       621F1    Dept-B142,FMO08,FMO06,142B **142 Primary** Automatic Case Number(s) issued for St Hedwig FD: SHED-2013-000000157.,POSSIBLE AUTHORIZED BURNING,[Notification] [BCFA]-Problem changed from Smoke in Area to Fire - Unauthorized Burn by BCFA,B142 ADVISED SMALL BURN PILE IN FIELD 30 FT OFF ROADWAY UNATTENDED//WILL BE EXTINGUISHING,Automatic Case Number(s) issued for FM Invest: 2013-157-0000704.,
zFMO - Inspectio    12414 Alstroemeria                                Dead End/TULIP BEND                              577D4        2013-157-01126        Dept-FMO10    **D2FR Primary Dept** Automatic Case Number(s) issued for FM Insp: 2013-157-01126.,
Fire - Vehicle    12440 Us Hwy 181 S         PVT RD AT 12290 US HWY 181 S/MAX RD       685D8     2013-157-0000703      Dept-E127B,FMO08,127D       **127 Primary Dept** [Address:  12440 US HWY 181 S] [High] [Officer Safety] Send at least two Officers to this location regardless of Problem Nature; persons living at location are combative. They have threaten to shoot responders and are anti goverment.,A cellular re-bid has occurred, check the ANI/ALI Viewer for details,A cellular re-bid has occurred, check the ANI/ALI Viewer for details,Automatic Case Number(s) issued for H
zFMO - Inspection         24803 BROAD OAK TRAIL                                                                                2013-157-01125       Dept- FMO34 **OUTSIDE BCFA AREA** FMO34:CREATED CALL FROM MOBILE,VHS Final,Automatic Case Number(s) issued for FM Insp: 2013-157-01125.,
MED - ASSAULT     23014 Sandy Forest Dr                          WATERWOOD PASS DR/WATERBROOK DR                752C8     Dept- E162,FMO36,162E  comp 72 yo female has been assaulted by her son/kenneth charles painter...requesting ems[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0176291,subj not at loc right now [Shared],[Notification] [BCLE]-Problem changed from Injured-Sick/ Adult   to Assault   by BCLE [Shared],[Notification] [BCFA]-Problem changed from Med - Sick Person to MED - ASSAULT by BCFA [Shared],Automatic Case Number(s) issued for Ger
zFMO - Interview - Witnes26749 timberline                                                                                  2013-156-0000702    Dept-FMO07**Inv Check Page*FMO07:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Invest: 2013-156-0000702.,

*/

public class TXBexarCountyParserTest extends BaseParserTest {
  
  public TXBexarCountyParserTest() {
    setParser(new TXBexarCountyParser(), "BEXAR COUNTY", "TX");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "Fire - Structure     - Stockport / Chipping           - 585E1 - comp states a house is on fire[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0105711,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000502. [Shared],Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000571. [Shared],Automatic Case Number(s) issued for Converse FD: CONV-2012-000000420. [Shared],Automatic Case Number(s) issued for Kirby FD: KIRB-2012-000000372. [Shared],",
        "CALL:Fire - Structure",
        "ADDR:Stockport & Chipping",
        "MAP:585E1",
        "ID:BCSO-2012-0105711",
        "INFO:comp states a house is on fire");

    doTest("T2",
        "Med - Sick Person         - 17694 Shepherd Rd              - 711F7   -  31 yo female...knee pain cause by past injury pt says it's a cut[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0107603,[BCLE] has closed their incident [BCSO-2012-0107603],Automatic Case Number(s) issued for Lytle FD: LYTL-2012-000000122. [Shared],This incident LYTL-2012-0010282 has been sent to ACADIAN via the CAD2CAD Interface",
        "CALL:Med - Sick Person",
        "ADDR:17694 Shepherd Rd",
        "MAP:711F7",
        "ID:BCSO-2012-0107603",
        "INFO:31 yo female...knee pain cause by past injury pt says it's a cut");

    doTest("T3",
        "Fire - Vehicle            Ih 10 W / Tarpon Dr            - 447A2   - engine smoking c has pulled to the side of the road...tan f350...wb on 10..doesn't seem to be leaking fluid[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:3511  AT&T MOBILITY-SE SECTOR-QF 446F.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:3511  AT&T MOBILITY-SE SECTOR-QF",
        "CALL:Fire - Vehicle",
        "ADDR:I 10 W & Tarpon Dr",
        "MAP:447A2",
        "INFO:engine smoking c has pulled to the side of the road...tan f350...wb on 10..doesn't seem to be leaking fluid");

    doTest("T4",
        "Fire - Structure     - Stockport / Chipping           - 585E1 - comp states a house is on fire[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0105711,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000502. [Shared],Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000571. [Shared],Automatic Case Number(s) issued for Converse FD: CONV-2012-000000420. [Shared],Automatic Case Number(s) issued for Kirby FD: KIRB-2012-000000372. [Shared]",
        "CALL:Fire - Structure",
        "ADDR:Stockport & Chipping",
        "MAP:585E1",
        "ID:BCSO-2012-0105711",
        "INFO:comp states a house is on fire");

    doTest("T5",
        "MVC                             W Loop 1604 S / Spurs Ranch     646B1    GVIL-2012-000001006  - crash, injuries, one car roll over.  On the access rd, sb side.[Shared],Invalid address received:61  SPRINT-N SECTOR-QF 646C4.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0107458,C is an off-duty officer with SAPD.  thinks the guy involved in crash is okay..but would like him checked out [Shared],Automatic Case Number(s)",
        "CALL:MVC",
        "ADDR:W Loop 1604 S & Spurs Ranch",
        "MAP:646B1",
        "ID:GVIL-2012-000001006",
        "INFO:crash, injuries, one car roll over.  On the access rd, sb side.,C is an off-duty officer with SAPD.  thinks the guy involved in crash is okay..but would like him checked out");

    doTest("T6",
        "Fire - Unauthorized Burn  9279 Aqua Dr                   - 447A3   - Unauth BUrning  to the left of location,Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000283.",
        "CALL:Fire - Unauthorized Burn",
        "ADDR:9279 Aqua Dr",
        "MAP:447A3",
        "ID:LSPR-2012-000000283",
        "INFO:Unauth BUrning  to the left of location");

    doTest("T7",
        "04/28 06:28 am - Med - Diabetic Problems   - 4455 Twin Valley            - 748E6   - C states her mother 72yo has low blood sugar..acad notifed[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0109820,Automatic Case Number(s) issued for Somerset FD: SOM-2012-000000292. [Shared],",
        "DATE:04/28",
        "TIME:06:28:00",
        "CALL:Med - Diabetic Problems",
        "ADDR:4455 Twin Valley",
        "MAP:748E6",
        "ID:BCSO-2012-0109820",
        "INFO:C states her mother 72yo has low blood sugar..acad notifed");

    doTest("T8",
        "MED - ASSAULT        - 7246 GLEN HILL                 - SA585 - ACADIAN: Unit:    740         9941959,ACADIAN: The cross street was verified by caller.,ACADIAN: Law enforcement on scene; it is safe for the crew to enter.,ACADIAN: assult to head unk age male,ACADIAN: [ProQA Session Aborted] Medical Professional,Transferred incident: Remote   Reference Number: 20120428-ZN16-0222 by Jacobs, Angela From ACADIAN,Interface has sent an ack message for CAM-2012-0010500 to the",
        "CALL:MED - ASSAULT",
        "ADDR:7246 GLEN HILL",
        "MAP:SA585",
        "ID:CAM-2012-0010500",
        "UNIT:740",
        "INFO:9941959,The cross street was verified by caller.,Law enforcement on scene; it is safe for the crew to enter.,assult to head unk age male, Angela From ACADIAN");

    doTest("T9",
        "Med - Unconscious Pe - 7838 Sun Forest                -       - 585C1   - 24 yo female went over to comps resd to visit his son; comp states female started drinking some wine and passed out; comp states she is breathing - does not know what to do with female[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0109700,This incident WIND-2012-0010491 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120428-ZN16-0059 [Shared],Unit - 76",
        "CALL:Med - Unconscious Pe",
        "ADDR:7838 Sun Forest",
        "MAP:585C1",
        "ID:BCSO-2012-0109700",
        "INFO:24 yo female went over to comps resd to visit his son; comp states female started drinking some wine and passed out; comp states she is breathing - does not know what to do with female,Unit - 76");

    doTest("T10",
        "Med - Sick Person    - 8216 Glen Boro                 - 553F8 - 50 YO F HAVING CHEST PAINS[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0109833,[BCLE] has closed their incident [BCSO-2012-0109833],Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000521. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:8216 Glen Boro",
        "MAP:553F8",
        "ID:BCSO-2012-0109833",
        "INFO:50 YO F HAVING CHEST PAINS");

    doTest("T11",
        "Fire                            6126 Kimble Mill                577D3    GVIL-2012-000001031  - C thinks the grease fire in his pit is getting out of hand.  in his backyard[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110061,C has turned off burners [Shared],Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001031. [Shared],",
        "CALL:Fire",
        "ADDR:6126 Kimble Mill",
        "MAP:577D3",
        "ID:GVIL-2012-000001031",
        "INFO:C thinks the grease fire in his pit is getting out of hand.  in his backyard,C has turned off burners");

    doTest("T12",
        "* BCFA Medical Emergency  - Ih 35 S Nb / Sb Ih 35 S Onrp S - 712A5   - unk where other fighters went[Shared],they have been drinking[Shared],no weapons[Shared],C says at los amigos there was a fight, three people are on the ground, req ems[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110791,Automatic Case Number(s) issued for Jarret FD: JARR-2012-000000207. [Shared],",
        "CALL:BCFA Medical Emergency",
        "ADDR:I 35 S Nb & Sb I 35 S Onrp S",
        "MADDR:I 35 S & I 35 S Onrp S",
        "MAP:712A5",
        "ID:BCSO-2012-0110791",
        "INFO:unk where other fighters went,they have been drinking,no weapons,C says at los amigos there was a fight, three people are on the ground, req ems");

    doTest("T13",
        "Med - Possible Stroke           12446 Modena Bay                577D6    GVIL-2012-000001047  - 66 yom- poss stroke- acad advised[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110913,This incident GVIL-2012-0010627 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120429-ZN16-1184 [Shared],Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001047. [Shared],",
        "CALL:Med - Possible Stroke",
        "ADDR:12446 Modena Bay",
        "MAP:577D6",
        "ID:GVIL-2012-000001047",
        "INFO:66 yom- poss stroke- acad advised");

    doTest("T14",
        "MVC                       - 23101 - 24511 Campbellton - HICKORY WAY/RANCH TRAIL RD               - 783D1 - small dark colored suv[Shared],going north on cambellton, it will be on the left[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:1453  TMOBILE-SE SECTOR-QF 751A2.[Shared],C disconnected[Shared],C says there is a car, unoccupied, flipped over.[Shared],Invalid address received:1453  TMOBILE-SE SECTOR-QF 751A2.[Shared],A cellular re-bid has occurre",
        "CALL:MVC",
        "ADDR:23101-24511 Campbellton",
        "MADDR:23101 Campbellton",
        "X:HICKORY WAY/RANCH TRAIL RD",
        "MAP:783D1",
        "INFO:small dark colored suv,going north on cambellton, it will be on the left,C disconnected,C says there is a car, unoccupied, flipped over");

    doTest("T15",
        "Med - Sick Person    - 6739 Glen Fair                 - 553E7 - C says her niece had a seizure, 34 yo.  fell onto concrete[Shared],Invalid address received:343  SPRINT-E SECTOR-QF 553C8.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110931,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000525. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:6739 Glen Fair",
        "MAP:553E7",
        "ID:BCSO-2012-0110931",
        "INFO:C says her niece had a seizure, 34 yo.  fell onto concrete");

    doTest("T16",
        "Alarm - Fire         - 9503 Millers Rdg               -       - 553E7   - POE;SMOKE DETECTOR;JOHN GILG @ 653-7947[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0111024,Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000599. [Shared],Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000527. [Shared],Automatic Case Number(s) issued for Converse FD: CONV-2012-000000442. [Shared],",
        "CALL:Alarm - Fire",
        "ADDR:9503 Millers Rdg",
        "MAP:553E7",
        "ID:BCSO-2012-0111024",
        "INFO:POE;SMOKE DETECTOR;JOHN GILG @ 653-7947");

    doTest("T17",
        "Med - Sick Person         - 16927 Ih 35 S Sb               - 711E6   -  23 YOF POSSIBLE BROKEN FOOT/FELL DOWN[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0112109,[BCLE] has closed their incident [BCSO-2012-0112109],Automatic Case Number(s) issued for Lytle FD: LYTL-2012-000000126. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:16927 I 35 S Sb",
        "MADDR:16927 I 35 S",
        "MAP:711E6",
        "ID:BCSO-2012-0112109",
        "INFO:23 YOF POSSIBLE BROKEN FOOT/FELL DOWN");

    doTest("T18",
        "Alarm                - 8210 Ih 35 N                  -       - 552E8   Dept-E108,C145,E145B,120A - Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000612.,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000547.,FIRE ALARM-RED LOBSTERS REST.,Backed up C145 with E145B,SINGLE STORY LIGHT SMOKE SHOWING AND SMOKE IN KITCHEN,Automatic Case Number(s) issued for Gardendale FD: GARD-2012-000000134.,",
        "CALL:Alarm",
        "ADDR:8210 I 35 N",
        "MAP:552E8",
        "ID:WIND-2012-000000612",
        "UNIT:E108,C145,E145B,120A",
        "INFO:FIRE ALARM-RED LOBSTERS REST.,Backed up C145 with E145B,SINGLE STORY LIGHT SMOKE SHOWING AND SMOKE IN KITCHEN");

    doTest("T19",
        "Med - Sick Person               9615 Rainbow Crk                612C5      GVIL-2012-000001138  Dept-123C - Multi-Agency BCLE Incident #: BCSO-2012-0118460,Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001138. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:9615 Rainbow Crk",
        "MAP:612C5",
        "ID:GVIL-2012-000001138",
        "UNIT:123C");

    doTest("T20",
        "Med - Sick Person         - 1460 Martinez Losoya           # SRST  - 717B8 Dept-141E - 6 YO F BROKE ARM[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0118435,Automatic Case Number(s) issued for South Bexar FD: SOBX-2012-000000251. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:1460 Martinez Losoya",
        "APT:SRST",
        "MAP:717B8",
        "ID:BCSO-2012-0118435",
        "UNIT:141E",
        "INFO:6 YO F BROKE ARM");

    doTest("T21",
        "Alarm - Fire              - 7406 Scintilla                 - 413F8   Dept-133A,126E,SPK activated general fire alarm,borene pd called this one in,Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000339.,Automatic Case Number(s) issued for Grey Forest FD: GRYF-2012-000000169.,",
        "CALL:Alarm - Fire",
        "ADDR:7406 Scintilla",
        "MAP:413F8",
        "ID:LSPR-2012-000000339",
        "UNIT:133A,126E,SPK",
        "INFO:activated general fire alarm,borene pd called this one in");

    doTest("T22",
        "Med - Diabetic Problems   - 14085 Ih 35 S                  - 713B2   Dept-130C 67 yof diabetic feeling light headed[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0119030,This incident JARR-2012-0011429 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120508-ZN16-0205 [Shared],Unit - 709, status change to STATUS_DISPATCHED by ACADIAN at 05/08/2012 04:33:59 [Shared],trlr 15 [Shared],[BCLE] has closed their incident [BCSO-2012-011903",
        "CALL:Med - Diabetic Problems",
        "ADDR:14085 I 35 S",
        "MAP:713B2",
        "ID:BCSO-2012-0119030",
        "UNIT:130C",
        "INFO:67 yof diabetic feeling light headed,Unit - 709,trlr 15");

    doTest("T23",
        "Med - Cardiac Arrest            2918 FISHERS GLADE              SA612/F8   GVIL-2012-000001157  Dept-123B - ACADIAN: Unit:    734         9963763,Transferred incident: Remote   Reference Number: 20120508-ZN16-0370 by Brunson, Savannah L. From ACADIAN,Interface has sent an ack message for GVIL-2012-0011432 to the remote CAD,9963763,This incident 20120508-ZN16-0370 has been sent to BCFA via the CAD2CAD Interface.,Unit - 734, status change to STATUS_RESPONDING by ACADIAN at 05/08/2012 06:25:35,Automatic Case Number",
        "CALL:Med - Cardiac Arrest",
        "ADDR:2918 FISHERS GLADE",
        "MAP:SA612/F8",
        "ID:GVIL-2012-000001157",
        "UNIT:123B 734",
        "INFO:9963763 - Savannah L. From ACADIAN,9963763,Unit - 734");

    doTest("T24",
        "Med - Sick Person    - 8510 WINDY CROSS               -       - SA553/C Dept-145D - ACADIAN: Unit:    735         9975423,Transferred incident: Remote   Reference Number: 20120513-ZN16-0481 by Reed, Juliana E. From ACADIAN,Interface has sent an ack message for WIND-2012-0011843 to the remote CAD,9975423,This incident 20120513-ZN16-0481 has been sent to BCFA via the CAD2CAD Interface.,ACADIAN HAS CHANGED the CALL BACK PHONE# to:,Automatic Case Number(s) issued for Windcrest FD: WIND-2012-0",
        "CALL:Med - Sick Person",
        "ADDR:8510 WINDY CROSS",
        "MAP:SA553/C",
        "ID:WIND-2012-0011843",
        "UNIT:145D 735",
        "INFO:9975423, Juliana E. From ACADIAN,9975423");

    doTest("T25",
        "Med - Heart Problems - 8835 WILLMON WAY               -       - SA552/F Dept-145A - ACADIAN: The cross street was verified by caller.,ACADIAN: Unit:    733         9975214,ACADIAN: The patient's weight is below 300 pounds.,ACADIAN: [ProQA Script] Dispatch code: 19D02  You are responding to a patient  with heart problems.  The patient is a  66-year-old female, who is    conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  Heart Problems / A.I.C.D..  DIFFICULTY SPE,AKING BETWEEN",
        "CALL:Med - Heart Problems",
        "ADDR:8835 WILLMON WAY",
        "MAP:SA552/F",
        "CODE:19D02",
        "UNIT:145A 733",
        "INFO:The cross street was verified by caller - 9975214,The patient's weight is below 300 pounds - You are responding to a patient - with heart problems - The patient is a - 66-year-old female, who is - conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  Heart Problems / A.I.C.D..  DIFFICULTY SPE,AKING BETWEEN");

  }
  
  @Test
  public void testHollywoodParkFire() {

    doTest("T1",
        "07:37 - Med - Sick Person              - 206 Donella Dr                           -           -Case - HPK-2012-000000230   - 69 YO F FELL AND CANT GET UP[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0138384,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000230. [Shared],",
        "TIME:07:37",
        "CALL:Med - Sick Person",
        "ADDR:206 Donella Dr",
        "ID:HPK-2012-000000230",
        "INFO:69 YO F FELL AND CANT GET UP");

    doTest("T2",
        "07:42 - Assist - Law Enforcement       - Sun Way Dr / El Cerrito Cir              -           -Case - HPK-2012-000000231   - 9217s  thousand oaks/us hwy 281 egg and i restaraunt[Shared],9217s  looking around us hwy 281/mecca. person said heading towards 1604 bleeding from head[Shared],SUBJ STATED HE STARTED A NEW MEDS AND HE IS TRYING TO FIND HIS PARENTS HOUSE[Shared],W/M/DK HAIR/SHIRT BLK/SHORT RED/SANDLES. COMP STATES THAT THE SUBJ CAME UP TO HER AND STATED HE LOST HIS GLASSES AND IS CONFUSED. WALKING TOWARDS US HWY 281[Shared",
        "TIME:07:42",
        "CALL:Assist - Law Enforcement",
        "ADDR:Sun Way Dr & El Cerrito Cir",  // Google calls this SUNWAY DR
        "ID:HPK-2012-000000231",
        "INFO:9217s  thousand oaks/us hwy 281 egg and i restaraunt,9217s  looking around us hwy 281/mecca. person said heading towards 1604 bleeding from head,SUBJ STATED HE STARTED A NEW MEDS AND HE IS TRYING TO FIND HIS PARENTS HOUSE,W/M/DK HAIR/SHIRT BLK/SHORT RED/SANDLES. COMP STATES THAT THE SUBJ CAME UP TO HER AND STATED HE LOST HIS GLASSES AND IS CONFUSED. WALKING TOWARDS US HWY 281[Shared");

    doTest("T3",
        "17:26 - Assist - Lift                  - 339 Donella Dr                           -           -Case - HPK-2012-000000229   - 98 yo female...lift assist only[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0137362,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000229. [Shared],",
        "TIME:17:26",
        "CALL:Assist - Lift",
        "ADDR:339 Donella Dr",
        "ID:HPK-2012-000000229",
        "INFO:98 yo female...lift assist only");

    doTest("T4",
        "Alarm - Fire                    3920 Beckwood Dr                                      484B5 - HPK-2012-000000232   Dept-104D,129E,SPK - AUD. \"FAWCETT, TOM GRACE\" POE: GEN FIRE. 210-402-0240 NO ADD INFO[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0139715,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000679. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000232. [Shared],",
        "CALL:Alarm - Fire",
        "ADDR:3920 Beckwood Dr",  // Google says this is BECKWOOD
        "MAP:484B5",
        "ID:HPK-2012-000000232",
        "UNIT:104D,129E,SPK",
        "INFO:AUD. \"FAWCETT, TOM GRACE\" POE: GEN FIRE. 210-402-0240 NO ADD INFO");

    doTest("T5",
        "Alarm - Fire         - 9311 Durham Trace              - 546A6   - GVIL-2012-000001346  - 115B,128E,122E   05:02 pm",
        "CALL:Alarm - Fire",
        "ADDR:9311 Durham Trace",
        "MAP:546A6",
        "ID:GVIL-2012-000001346",
        "INFO:115B,128E,122E   05:02 pm");

    doTest("T6",
        "18:38 - Alarm - Fire                   - 155 William Classen Dr                   -           -Case - BBUL-2012-000000681  - Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000233.,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000681.,",
        "TIME:18:38",
        "CALL:Alarm - Fire",
        "ADDR:155 William Classen Dr",
        "ID:BBUL-2012-000000681");

    doTest("T7",
        "Fire                            3606 Sausalito Fern                                   452A8 - HPK-2012-000000234   Dept-129A,104D - comp says she sees smoke coming from wash room area. said not washer or dryer can smell the smoke[Shared],Invalid address received:83  SPRINT-NE SECTOR-QF 483D2.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0140833,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000682. [Shared],Automatic Case Number(s) issu",
        "CALL:Fire",
        "ADDR:3606 Sausalito Fern",
        "MAP:452A8",
        "ID:HPK-2012-000000234",
        "UNIT:129A,104D",
        "INFO:comp says she sees smoke coming from wash room area. said not washer or dryer can smell the smoke");

    doTest("T8",
        "15:47 - Med - Back Pain                - 30 Amber Forest                          -           -Case - HPK-2012-000000235   - 36 YOM- HURT BACK- NOT ABLE TO GET OUT OF CHAIR[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:3117  AT&T MOBILITY-N SECTOR-QF 581D4.[Shared],Invalid address received:3117  AT&T MOBILITY-N SECTOR-QF 581D4.[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0142020,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000235. [Shared],",
        "TIME:15:47",
        "CALL:Med - Back Pain",
        "ADDR:30 Amber Forest",
        "ID:HPK-2012-000000235",
        "INFO:36 YOM- HURT BACK- NOT ABLE TO GET OUT OF CHAIR");

    doTest("T9",
        "15:54 - Alarm - Fire                   - 16315 Us Hwy 281 N                       -           -Case - BBUL-2012-000000692  - Multi-Agency BCLE Incident #: HPPD-2012-0142027,comm fire alarm...poe/general fire alarm...bus/Holiday Inn...bus./210-402-3300 [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000236. [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000692. [Shared],",
        "TIME:15:54",
        "CALL:Alarm - Fire",
        "ADDR:16315 Us Hwy 281 N",
        "MADDR:16315 US 281 N",
        "ID:BBUL-2012-000000692",
        "INFO:comm fire alarm...poe/general fire alarm...bus/Holiday Inn...bus./210-402-3300");

    doTest("T10",
        "23:41 - Med - Sick Person              - 328 El Portal                            -           -Case - HPK-2012-000000237   - 75 YOF HAVING HEART PAINS[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0142337,This incident HPK-2012-0013604 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120601-ZN16-2014 [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000237. [Shared],Unit - 776, status change to STATUS_DISPATCHED by ACADIAN at 06/01/2012 23:41:17 [Sha",
        "TIME:23:41",
        "CALL:Med - Sick Person",
        "ADDR:328 El Portal",
        "ID:HPK-2012-000000237",
        "INFO:75 YOF HAVING HEART PAINS,Unit - 776");

    doTest("T11",
        "Alarm - Fire                    25630 Indian Summer                                   450D8 - HPK-2012-000000238   Dept-103C,129E,SPK - Phone #:210-481-3208[Shared],Name of the resident:Glen & Barbara Johnson.[Shared],Fire alarm.  Smoke detector.  unk location.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0142845,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000695. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000238. [Shared],",
        "CALL:Alarm - Fire",
        "ADDR:25630 Indian Summer",
        "MAP:450D8",
        "ID:HPK-2012-000000238",
        "UNIT:103C,129E,SPK",
        "INFO:Phone #:210-481-3208,Name of the resident:Glen & Barbara Johnson.,Fire alarm.  Smoke detector.  unk location");

    doTest("T12",
        "18:56 - Alarm - Medical                - 131 SUN WAY DR                           -           -Case - HPK-2012-000000239   - ACADIAN: The cross street was verified by caller.,ACADIAN: Unit:    740         10039768,Transferred incident: Remote   Reference Number: 20120602-ZN16-1270 by Barron, Ricardo From ACADIAN,Interface has sent an ack message for HPK-2012-0013670 to the remote CAD,10039768,This incident 20120602-ZN16-1270 has been sent to BCFA via the CAD2CAD Interface.,unknown medical alarm,ACADIAN HAS CHANGED CALLER to:Acad",
        "TIME:18:56",
        "CALL:Alarm - Medical",
        "ADDR:131 SUN WAY DR",
        "ID:HPK-2012-000000239",
        "UNIT:740",
        "INFO:The cross street was verified by caller - 10039768, Ricardo From ACADIAN,10039768,unknown medical alarm");

    doTest("T13",
        "Alarm - Fire                   ; 28300 Us Hwy 281  N                           ;       ; 451E2 ; HPK-2012-000000240   Dept-103D,129E,SPK ;  Activated Fire Alarm,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000700.,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000240.,",
        "CALL:Alarm - Fire",
        "ADDR:28300 Us Hwy 281  N",
        "MADDR:28300 US 281  N",
        "MAP:451E2",
        "ID:HPK-2012-000000240",
        "UNIT:103D,129E,SPK",
        "INFO:Activated Fire Alarm");

    doTest("T14",
        "16:06 - MED - ASSAULT                  - 310 Yosemite                             -           -Case - HPK-2012-000000241   - DISTURBANCE[Shared],subj is outside loc[Shared],c states w/f- grey shirt and jeans told c that her son ranaway- subj has been wandering around in the neighborhood looking for him- c states subj has asthma and is over heated- ref ems req ofc[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0144505,SCENE IS NOT SECURE,EMS ENROUTE [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-0000002",
        "TIME:16:06",
        "CALL:MED - ASSAULT",
        "ADDR:310 Yosemite",
        "ID:HPK-2012-000000241",
        "INFO:DISTURBANCE,subj is outside loc,c states w/f- grey shirt and jeans told c that her son ranaway- subj has been wandering around in the neighborhood looking for him- c states subj has asthma and is over heated- ref ems req ofc,SCENE IS NOT SECURE,EMS ENROUTE");

    doTest("T15",
        "17:22 - Med - Sick Person              - 17319 Us Hwy 281 N                       - SUITE 400 -Case - HPK-2012-000000242   - comp is not with the pt[Shared],60 yof complaining of a headache and high blood sugar; comp states the pt is breathing heavily[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0144554,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000242. [Shared],",
        "TIME:17:22",
        "CALL:Med - Sick Person",
        "ADDR:17319 Us Hwy 281 N",
        "MADDR:17319 US 281 N",
        "APT:SUITE 400",
        "ID:HPK-2012-000000242",
        "INFO:comp is not with the pt,60 yof complaining of a headache and high blood sugar; comp states the pt is breathing heavily");

    doTest("T16",
        "Med - Chest Pain               - 144 BLUET LN                             -            - 12:34-Case - HPK-2012-000000243   - ACADIAN: Unit:    738         10044990,ACADIAN: The patient's weight is below 300 pounds.  83 yo male,ACADIAN: home health nurse is on scene,ACADIAN: 160/94  pt has taken 1 nitro,Transferred incident: Remote   Reference Number: 20120605-ZN16-1057 by Brunson, Savannah L. From ACADIAN,Interface has sent an ack message for BCFAO-2012-0013893 to the remote CAD,This incident 20120605-ZN16-1057 has been sent to",
        "TIME:12:34",
        "CALL:Med - Chest Pain",
        "ADDR:144 BLUET LN",
        "ID:HPK-2012-000000243",
        "UNIT:738",
        "INFO:10044990,The patient's weight is below 300 pounds.  83 yo male,home health nurse is on scene,160/94  pt has taken 1 nitro, Savannah L. From ACADIAN,Interface has sent an ack message for BCFAO-2012-0013893 to the remote CAD,This incident 20120605-ZN16-1057 has been sent to");

    doTest("T17",
        "Med - Sick Person              - 700 EL PORTAL                            -            - 07:53-Case - HPK-2012-000000244   - voyt park inj child[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0145967,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000244. [Shared],",
        "TIME:07:53",
        "CALL:Med - Sick Person",
        "ADDR:700 EL PORTAL",
        "ID:HPK-2012-000000244",
        "INFO:voyt park inj child");

    doTest("T18",
        "Alarm - Fire         - 25302 Miranda Rdg              : 446A8   Dept 132E,126C,128E 01:25 pm - bedroom #4[Shared],childs resd aud 210-557-1420 poe gas alarm[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0146472,Automatic Case Number(s) issued for Grey Forest FD: GRYF-2012-000000200. [Shared],Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000430. [Shared],Automatic Case Nu",
        "CALL:Alarm - Fire",
        "ADDR:25302 Miranda Rdg",
        "MAP:446A8",
        "ID:BCSO-2012-0146472",
        "UNIT:132E,126C,128E",
        "INFO:01:25 pm - bedroom #4,childs resd aud 210-557-1420 poe gas alarm");

    doTest("T19",
        "MVC                            - N Loop 1604 E / Stone Oak Pkwy           -            - 20:08-Case - HPK-2012-000000245   - mv ped acc........valero plot........chevy tahoe......unk lp...>[Shared][Shared],Multi-Agency SAFD Incident #: 120606-0390,caller stated tosapd, this will be in the pklot of valero, which is in hollywood park,Secondary Location for 3130B: ON INFO.... [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000245. [Shared],",
        "TIME:20:08",
        "CALL:MVC",
        "ADDR:N Loop 1604 E & Stone Oak Pkwy",
        "ID:HPK-2012-000000245",
        "INFO:mv ped acc........valero plot........chevy tahoe......unk lp...>,Multi-Agency SAFD Incident #: 120606-0390,caller stated tosapd, this will be in the pklot of valero, which is in hollywood park,Secondary Location for 3130B: ON INFO");

    doTest("T20",
        "Alarm - Medical                - 104 Garrapata Ln                         -            - 10:04-Case - HPK-2012-000000247   - Multi-Agency BCLE Incident #: HPPD-2012-0147298,aud  medical alarm res/martha falke #4948180  83 yoa  [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000247. [Shared],",
        "TIME:10:04",
        "CALL:Alarm - Medical",
        "ADDR:104 Garrapata Ln",
        "ID:HPK-2012-000000247",
        "INFO:aud  medical alarm res/martha falke #4948180  83 yoa");

    doTest("T21",
        "Alarm - Fire                   - 155 William Classen Dr                   -            - 11:11-Case - BBUL-2012-000000719  - Multi-Agency BCLE Incident #: HPPD-2012-0147396,AUD   BUS/GURINSKY JEWELRY #7222776  POE/FIRE ALARM DOWNSTAIRS SMOKE [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000248. [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000719. [Shared],",
        "TIME:11:11",
        "CALL:Alarm - Fire",
        "ADDR:155 William Classen Dr",
        "ID:BBUL-2012-000000719",
        "INFO:AUD   BUS/GURINSKY JEWELRY #7222776  POE/FIRE ALARM DOWNSTAIRS SMOKE");

    doTest("T22",
        "Alarm - Fire         - 10734 Shaenview                - 546B6   - GVIL-2012-000001421  - 115C,128E,122E   04:26 pm",
        "CALL:Alarm - Fire",
        "ADDR:10734 Shaenview",
        "MAP:546B6",
        "ID:GVIL-2012-000001421",
        "INFO:115C,128E,122E   04:26 pm");

    doTest("T23",
        "Alarm - Fire                    5819 Culberson Mill             577C4      HELO-2012-000000095  Dept-115E,122C,128E - aud. fire alarm. flores,marvin. 830-255-0398. no answer on call back[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0148428,Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001427. [Shared],Automatic Case Number(s) issued for District 7 FD: D7FR-2012-000000421. [Shared],Automatic Case Number(s) issued for Helotes FD: HELO-2012-000000095. [Shared],",
        "CALL:Alarm - Fire",
        "ADDR:5819 Culberson Mill",
        "MAP:577C4",
        "ID:HELO-2012-000000095",
        "UNIT:115E,122C,128E",
        "INFO:aud. fire alarm. flores,marvin. 830-255-0398. no answer on call back");

    doTest("T24",
        "Alarm - Fire                   ; 24811 Bogey Rdg                               ;Apt      ; 482F1 ; HPK-2012-000000249   Dept 103D,129E,SPK ;  Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000726.,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000249.,",
        "CALL:Alarm - Fire",
        "ADDR:24811 Bogey Rdg",
        "MAP:482F1",
        "ID:HPK-2012-000000249",
        "UNIT:103D,129E,SPK");

    doTest("T25",
        "Alarm - Fire                   ; 26003 Scenic Pass                             ;Apt      ; 450D6 ; HPK-2012-000000250   Dept 103B,129E,SPK ;  Bradley and Erin Machik  #830-438-6869[Shared],Fire panic alarm[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149032,ref 08723751 [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000728. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000250. [Shared],",
        "CALL:Alarm - Fire",
        "ADDR:26003 Scenic Pass",
        "MAP:450D6",
        "ID:HPK-2012-000000250",
        "UNIT:103B,129E,SPK",
        "INFO:Bradley and Erin Machik  #830-438-6869,Fire panic alarm,ref 08723751");

    doTest("T26",
        "Med - Sick Person              - 319 Yosemite                             -            - 05:18-Case - HPK-2012-000000251   - Multi-Agency BCLE Incident #: HPPD-2012-0149261,60yr old heart patient...bleeding from the biopsy from the bone marrow he had [Shared],This incident HPK-2012-0014258 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120609-ZN16-0283 [Shared],Unit - 731, status change to STATUS_DISPATCHED by ACADIAN at 06/09/2012 05:18:30 [Shared],Automatic Case Number(s) i",
        "TIME:05:18",
        "CALL:Med - Sick Person",
        "ADDR:319 Yosemite",
        "ID:HPK-2012-000000251",
        "INFO:60yr old heart patient...bleeding from the biopsy from the bone marrow he had ,Unit - 731");

    doTest("T27",
        "Med - Breathing Problems       - 153 Grand Oak                            -            - 22:01-Case - HPK-2012-000000252   - C is having trouble breathing, 88 yo female.[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0149710,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000252. [Shared],",
        "TIME:22:01",
        "CALL:Med - Breathing Problems",
        "ADDR:153 Grand Oak",
        "ID:HPK-2012-000000252",
        "INFO:C is having trouble breathing, 88 yo female");

    doTest("T28",
        "Med - Fall                     - 230 Yosemite                             -            - 23:27-Case - HPK-2012-000000253   - fell coming out of the shower[Shared],female fell bump back of head[Shared],Multi-Agency BCLE Incident #: HPPD-2012-0149768,88yo [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000253. [Shared],",
        "TIME:23:27",
        "CALL:Med - Fall",
        "ADDR:230 Yosemite",
        "ID:HPK-2012-000000253",
        "INFO:fell coming out of the shower,female fell bump back of head,88yo");

  }
  
  @Test
  public void testNewParser() {

    doTest("T1",
        "Med - Sick Person              ; 21746 Thunder Basin                           ;       ; 485B5 ; BBUL-2012-000000701  Dept-104B ;  mother is Emma Gardley, 90 yo.[Shared],C says his mother is mentally unstable, possibly violent, he cannot control her.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143660,This incident BBUL-2012-0013756 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120603-ZN16-1062 [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000701",
        "CALL:Med - Sick Person",
        "ADDR:21746 Thunder Basin",
        "MAP:485B5",
        "ID:BBUL-2012-000000701",
        "UNIT:104B",
        "INFO:mother is Emma Gardley, 90 yo.,C says his mother is mentally unstable, possibly violent, he cannot control her");

    doTest("T2",
        "MVC                            ; Us Hwy 281 N / Bulverde Rd                    ;       ; 451D6 ; BBUL-2012-000000702  Dept-103D ;  sb side gold tahoe vs blk car /female with neck pain[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143974,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000702. [Shared],unk age of female [Shared],",
        "CALL:MVC",
        "ADDR:Us Hwy 281 N & Bulverde Rd",
        "MADDR:US 281 N & Bulverde Rd",
        "MAP:451D6",
        "ID:BBUL-2012-000000702",
        "UNIT:103D",
        "INFO:sb side gold tahoe vs blk car /female with neck pain,unk age of female");

    doTest("T3",
        "Med - Choking                  ; 734 Ottawa Way St                             ;       ; 451A4 ; BBUL-2012-000000699  Dept-103D ;  35 yo.[Shared],C says that her father has a bone in his throat, choking.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143557,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000699. [Shared],",
        "CALL:Med - Choking",
        "ADDR:734 Ottawa Way St",
        "MAP:451A4",
        "ID:BBUL-2012-000000699",
        "UNIT:103D",
        "INFO:35 yo.,C says that her father has a bone in his throat, choking");

    doTest("T4",
        "MVC - OTV                      ; 21415 Battle Crk                              ;       ; 484E6 ; BBUL-2012-000000698  Dept-104A ;  C says a pickup truck crashed, behind loc.  unk injuries.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143514,white pickup [Shared],the vehicle crashed into some trees, vehicle is turned over [Shared],C says he may be trapped in the vehicle, people are attempting to get him out [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000698. [Shared],",
        "CALL:MVC - OTV",
        "ADDR:21415 Battle Crk",
        "MAP:484E6",
        "ID:BBUL-2012-000000698",
        "UNIT:104A",
        "INFO:C says a pickup truck crashed, behind loc.  unk injuries.,white pickup ,the vehicle crashed into some trees, vehicle is turned over ,C says he may be trapped in the vehicle, people are attempting to get him out");

    doTest("T5",
        "Med - Sick Person              ; 849 Pine Eagle Ln                             ;       ; 451A4 ; BBUL-2012-000000704  Dept 103D ;  female trouble breathing 64yo[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0144879,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000704. [Shared],This incident BBUL-2012-0013867 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:849 Pine Eagle Ln",
        "MAP:451A4",
        "ID:BBUL-2012-000000704",
        "UNIT:103D",
        "INFO:female trouble breathing 64yo");

    doTest("T6",
        "Med - Fall                     ; 855 Tecumseh Dr                               ;       ; 451A3 ; BBUL-2012-000000708  Dept 103C ;  68 yo female...fall now has sever body pain...170lb[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0145684,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000708. [Shared], ",
        "CALL:Med - Fall",
        "ADDR:855 Tecumseh Dr",
        "MAP:451A3",
        "ID:BBUL-2012-000000708",
        "UNIT:103C",
        "INFO:68 yo female...fall now has sever body pain...170lb");

    doTest("T7",
        "Med - Sick Person              ; 23238 Bison Canyon                            ;Apt      ; 484B3 ; BBUL-2012-000000723  Dept 104A ;  50 yom fell; and is sweating[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0148106,acadian notified [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000723. [Shared],",
        "CALL:Med - Sick Person",
        "ADDR:23238 Bison Canyon",
        "MAP:484B3",
        "ID:BBUL-2012-000000723",
        "UNIT:104A",
        "INFO:50 yom fell; and is sweating,acadian notified");

    doTest("T8",
        "Alarm - Fire                   ; 24811 Bogey Rdg                               ;Apt      ; 482F1 ; HPK-2012-000000249   Dept 103D,129E,SPK ;  Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000726.,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000249.,",
        "CALL:Alarm - Fire",
        "ADDR:24811 Bogey Rdg",
        "MAP:482F1",
        "ID:HPK-2012-000000249",
        "UNIT:103D,129E,SPK");

    doTest("T9",
        "Med - Chest Pain               ; 24539 Glass Canyon                            ;Apt      ; 482F1 ; BBUL-2012-000000729  Dept 104B ;  41 yo male, having chest pains.[Shared],Invalid address received:1  VERIZON-SE SECTOR-QF 450E7.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149066,awake and responsive [Shared],This incident BBUL-2012-0014236 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120608-ZN16-2020",
        "CALL:Med - Chest Pain",
        "ADDR:24539 Glass Canyon",
        "MAP:482F1",
        "ID:BBUL-2012-000000729",
        "UNIT:104B",
        "INFO:41 yo male, having chest pains.,awake and responsive");

    doTest("T10",
        "Med - Seizure                  ; 4527 Echo Grove                               ;Apt      ; 484D6 ; BBUL-2012-000000730  Dept 104E ;  29 yoa female seizure[Shared],Invalid address received:3073  AT&T MOBILITY-SW SECTOR-QF 550F.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149117,starting to come out of it [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000730. [Shared],",
        "CALL:Med - Seizure",
        "ADDR:4527 Echo Grove",  // Not mapping
        "MAP:484D6",
        "ID:BBUL-2012-000000730",
        "UNIT:104E",
        "INFO:29 yoa female seizure,starting to come out of it");

    doTest("T11",
        "Alarm - Medical                ; 838 Emerald Bay                               ;Apt      ; 482F1 ; BBUL-2012-000000732  Dept 103C ;  Multi-Agency BCLE Incident #: BCSO-2012-0149257,aud/medicl/res; analisa diaz/res'; 210-648-3962 [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000732. [Shared],",
        "CALL:Alarm - Medical",
        "ADDR:838 Emerald Bay",
        "MAP:482F1",
        "ID:BBUL-2012-000000732",
        "UNIT:103C",
        "INFO:aud/medicl/res; analisa diaz/res'; 210-648-3962");

    doTest("T12",
        "Med - Sick Person              ; 25675 Overlook Pkwy                           ;Apt2708  ; 451C8 ; BBUL-2012-000000731  Dept 104B ;  [Premise:  25675 OVERLOOK PKWY] [Medium] [Criminal Trespass Warning] VAN, SAMUEL JONES B/M DOB:09-04-1966 REFERENCE CASE 2011-BCSO-023624[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149230,[Premise:  25675 Overlook Pkwy] VAN, SAMUEL JONES B/M DOB:09-04-1966 REFERENCE CASE 2011-BCSO-023624,26yr old female was drinking alcohol and now has rapid heart rate, feels like her throat is closing [Shared],This",
        "CALL:Med - Sick Person",
        "ADDR:25675 Overlook Pkwy",
        "APT:2708",
        "MAP:451C8",
        "ID:BBUL-2012-000000731",
        "UNIT:104B",
        "INFO:[Premise:  25675 OVERLOOK PKWY] [Medium] [Criminal Trespass Warning] VAN, SAMUEL JONES B/M DOB:09-04-1966 REFERENCE CASE 2011-BCSO-023624,[Premise:  25675 Overlook Pkwy] VAN, SAMUEL JONES B/M DOB:09-04-1966 REFERENCE CASE 2011-BCSO-023624,26yr old female was drinking alcohol and now has rapid heart rate, feels like her throat is closing ,This");

    doTest("T13",
        "MVC                            ; BULVERDE RD / US HWY 281 N                    ;Apt      ; 451D6 ; BBUL-2012-000000733  Dept 103C ;  major[Shared],nb[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149352,acad notified [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000733. [Shared],",
        "CALL:MVC",
        "ADDR:BULVERDE RD & US HWY 281 N",
        "MADDR:BULVERDE RD & US 281 N",
        "MAP:451D6",
        "ID:BBUL-2012-000000733",
        "UNIT:103C",
        "INFO:major,nb,acad notified");

    doTest("T14",
        "Alarm - Smoke                  ; 510 Reenie Way                                ;Apt      ; 482F2 ; BBUL-2012-000000735  Dept 104E ;  c states smoke detectors will not turn off- took out batteries and replaced them and alarm is still beeping[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149659,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000735. [Shared],",
        "CALL:Alarm - Smoke",
        "ADDR:510 Reenie Way",
        "MAP:482F2",
        "ID:BBUL-2012-000000735",
        "UNIT:104E",
        "INFO:c states smoke detectors will not turn off- took out batteries and replaced them and alarm is still beeping");

    doTest("T15",
        "Med - Unconscious Person       ; 23808 Resort Pkwy                             ;Apt      ; 484E2 ; BBUL-2012-000000734  Dept 104A ;  [Premise:  23808 RESORT PKWY] [Medium] [Location Note] LOSS PREVENTION SECURITY FOR THE MARRIOTT 210-483-6660, THEY ARE FIRST RESPONDERS TO THIS LOCATION[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149578,[Premise:  23808 Resort Pkwy] LOSS PREVENTION SECURITY FOR THE MARRIOTT 210-483-6660, THEY ARE FIRST RESPONDERS TO THIS LOCATION,c/rprts they have a guest who has gone unconscious while by the swimmi",
        "CALL:Med - Unconscious Person",
        "ADDR:23808 Resort Pkwy",
        "MAP:484E2",
        "ID:BBUL-2012-000000734",
        "UNIT:104A",
        "INFO:[Premise:  23808 RESORT PKWY] [Medium] [Location Note] LOSS PREVENTION SECURITY FOR THE MARRIOTT 210-483-6660, THEY ARE FIRST RESPONDERS TO THIS LOCATION,[Premise:  23808 Resort Pkwy] LOSS PREVENTION SECURITY FOR THE MARRIOTT 210-483-6660, THEY ARE FIRST RESPONDERS TO THIS LOCATION,c/rprts they have a guest who has gone unconscious while by the swimmi");

    doTest("T16",
        "MED - PYSCHIATRIC PROBLEMS     ; 1219 Wilder Pond                              ;Apt      ; 451A6 ; BBUL-2012-000000738  Dept 103C ;  C BELIEVES MALE IS AT ABV RESIDENTS ;C HAS BEEN TRYIN TO CALL MALE -NO ANSWER.... [Shared][Shared],C RECV TEXT FROM SHAWN MC DONALD FROM CELL #210-771-5167-----TEXTING HE WAS GOIN TO END IT ALL ---JUST TOOK 25 PILLS OF TEMAZEPAM =ANTI ANX  WITH WHISKEY AND NOW FEELING SLEEPY.....C RQ OFCR TO CALL BACK W/ OUTCOME...  .UNK WPN / INTOX[Shared][Shared],Multi-Agency BCLE Incident #: BCSO-2012-0150265,Add Agency",
        "CALL:MED - PYSCHIATRIC PROBLEMS",
        "ADDR:1219 Wilder Pond",
        "MAP:451A6",
        "ID:BBUL-2012-000000738",
        "UNIT:103C",
        "INFO:C BELIEVES MALE IS AT ABV RESIDENTS ;C HAS BEEN TRYIN TO CALL MALE -NO ANSWER.... ,C RECV TEXT FROM SHAWN MC DONALD FROM CELL #210-771-5167-----TEXTING HE WAS GOIN TO END IT ALL ---JUST TOOK 25 PILLS OF TEMAZEPAM =ANTI ANX  WITH WHISKEY AND NOW FEELING SLEEPY.....C RQ OFCR TO CALL BACK W/ OUTCOME...  .UNK WPN / INTOX,Add Agency");

    doTest("T17",
        "Alarm - Fire                   ; 3040 Single Peak                              ;Apt      ; 451F4 ; HPK-2012-000000254   Dept 104B,129E,SPK ;  fire alarm...upstairs smoke detector...williamson residence...830-438-7561..gate code 0011[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0150233,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000737. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000254. [Shared],",
        "CALL:Alarm - Fire",
        "ADDR:3040 Single Peak",
        "MAP:451F4",
        "ID:HPK-2012-000000254",
        "UNIT:104B,129E,SPK",
        "INFO:fire alarm...upstairs smoke detector...williamson residence...830-438-7561..gate code 0011");

    doTest("T18",
        "MED - TOX INGEST - INTENTIONAL ; 1234 Wilder Pond                              ;Apt      ; 451B6 ; BBUL-2012-000000736  Dept 103D ;  Multi-Agency BCLE Incident #: BCSO-2012-0150168,36 yo female...prozac and other pills pt breathing somewhat responding [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000736. [Shared],",
        "CALL:MED - TOX INGEST - INTENTIONAL",
        "ADDR:1234 Wilder Pond",
        "MAP:451B6",
        "ID:BBUL-2012-000000736",
        "UNIT:103D",
        "INFO:36 yo female...prozac and other pills pt breathing somewhat responding");

  }
  
  @Test
  public void testNewParser2() {

    doTest("T1",
        "Med - Fall           - 8502 GLEN BREEZE               - 553F8 Dept-108B - ACADIAN: Unit:    731         10041536,Transferred incident: Remote   Reference Number: 20120603-ZN16-1180 by Stinson, Nathaniel T. From ACADIAN,Interface has sent an ack message for CAM-2012-0013763 to the remote CAD,10041536,This incident 20120603-ZN16-1180 has been sent to BCFA via the CAD2CAD Interface.,Unit - 731, status change to STATUS_RESPONDING by ACADIAN at 06/03/2012 23:07:18,ACADIAN HAS CHANGED",
        "CALL:Med - Fall",
        "ADDR:8502 GLEN BREEZE",
        "MAP:553F8",
        "ID:CAM-2012-0013763",
        "UNIT:108B 731",
        "INFO:10041536 - Nathaniel T. From ACADIAN,10041536,Unit - 731,ACADIAN HAS CHANGED");

    doTest("T2",
        "Fire-Authorized Burn      - 24440 Loma Verde          - RED GATE DR/TOPALA DR                    - 783B3  Dept-138B - unk what is burning[Shared],C says she sees smoke coming from her neighbors yard.  Unk address.[Shared],Invalid address received:220  VERIZON-E SECTOR-QF 783A4.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0142874,Automatic Case Number(s) issued for Sandy Oaks FD: SOAK-2012-000000498. [Shared],",
        "CALL:Fire-Authorized Burn",
        "ADDR:24440 Loma Verde",
        "X:RED GATE DR/TOPALA DR",
        "MAP:783B3",
        "ID:BCSO-2012-0142874",
        "UNIT:138B",
        "INFO:unk what is burning,C says she sees smoke coming from her neighbors yard.  Unk address");

    doTest("T3",
        "zTEST CALL                - 7895 Fair Oaks Pkwy           FAIR OAKS RANCH                   - 413D8   Dept 133C 132/134 Primary Dept This is a test call,Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000645.,",
        "CALL:zTEST CALL",
        "ADDR:7895 Fair Oaks Pkwy",
        "CITY:FAIR OAKS RANCH",
        "MAP:413D8",
        "ID:LSPR-2012-000000645",
        "UNIT:133C",
        "INFO:132/134 Primary Dept This is a test call");

    doTest("T4",
        "Rescue - Elevato  24365 Wilderness Oak                           FAIRWAY BRIDGE/MIDNIGHT PEAK                   483B2     BBUL-2012-000001328  Dept-104B          **103/104 Primary Dept** c/ states she has been stuck in the elevator for about 15 min[Shared],Invalid address received:83  SPRINT-NW SECTOR-QF 483D2.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0271650,[Notification] [BCFA]-Problem changed from Fire to Rescue - Elevator by BCFA [Shared],building 6 [Shared],states she is in building 6 [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000001328. [Shared]\r\n",
        "CALL:Rescue - Elevato",
        "ADDR:24365 Wilderness Oak",
        "X:FAIRWAY BRIDGE/MIDNIGHT PEAK",
        "MAP:483B2",
        "ID:BBUL-2012-000001328",
        "UNIT:104B",
        "INFO:103/104 Primary Dept** c/ states she has been stuck in the elevator for about 15 min - SPRINT-NW SECTOR-QF 483D2.,[Notification] [BCFA]-Problem changed from Fire to Rescue - Elevator by BCFA ,building 6 ,states she is in building 6");

  }
  
  @Test
  public void testAtaBexar() {

    doTest("T1",
        "Med - Animal Bit  279 Duke Rd                                    PVT RD AT 232 DUKE RD/ROBERT JARED        782D3    ATAB-2012-000000436 Dept- 101A **101 Primary Dept**Multi-Agency BCLE Incident #: BCSO-2012-0315988,9 YOA MALE BIT BY A SPIDER BETWEEN TOES, NOW SWELLING., C HAS THE SPIDER [Shared],[Notification] [BCFA]-Problem changed from Med - Sick Person to Med - Animal Bite by BCFA [Shared],[BCLE] has closed their incident [BCSO-2012-0315988],Automatic Case Number(s) issued for Ata-Bexar FD: ATAB-2012-000000436. [Shared],\r\n",
        "CALL:Med - Animal Bit",
        "ADDR:279 Duke Rd",
        "X:PVT RD AT 232 DUKE RD/ROBERT JARED",
        "MAP:782D3",
        "ID:ATAB-2012-000000436",
        "UNIT:101A",
        "INFO:9 YOA MALE BIT BY A SPIDER BETWEEN TOES, NOW SWELLING., C HAS THE SPIDER ,[Notification] [BCFA]-Problem changed from Med - Sick Person to Med - Animal Bite by BCFA");

    doTest("T2",
        "Med - Sick Perso  24945 Pleasanton Rd                            DUKE RD/PEACEFUL LN                       782E4    ATAB-2012-000000435 Dept- 101B **101 Primary Dept**26 yo female fell a couple of days ago and hurt her rib[Shared],Invalid address received:55  SPRINT-W SECTOR-QF 784A2.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0315181,This incident ATAB-2012-0029542 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20121120-ZN16-1674 [Shared\r\n",
        "CALL:Med - Sick Perso",
        "ADDR:24945 Pleasanton Rd",
        "X:DUKE RD/PEACEFUL LN",
        "MAP:782E4",
        "ID:ATAB-2012-000000435",
        "UNIT:101B",
        "INFO:101 Primary Dept**26 yo female fell a couple of days ago and hurt her rib");

    doTest("T3",
        "Med - Sick Perso  895 Mogford                                    HARDWICK/DUKE DR                          782F4    ATAB-2012-000000434 Dept- 101A **101 Primary Dept**43 YO MALE PASSING OUT[Shared],Invalid address received:150  CRICKET-SE SECTOR-TBD.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0309971,[Notification] [BCLE]-Problem changed from 911 Abuse   to * EMS Only   by BCLE [Shared],Automatic Case Number(s) issued for Ata-Bexar FD: ATAB-2012-000000434. [Shared],\r\n",
        "CALL:Med - Sick Perso",
        "ADDR:895 Mogford",
        "X:HARDWICK/DUKE DR",
        "MAP:782F4",
        "ID:ATAB-2012-000000434",
        "UNIT:101A",
        "INFO:101 Primary Dept**43 YO MALE PASSING OUT,[Notification] [BCLE]-Problem changed from 911 Abuse   to * EMS Only   by BCLE");

    doTest("T4",
        "Med - Breathing   337 Hallmark Path                              PLEASANTON RD/Dead End                    750C8    ATAB-2012-000000433 Dept- 101C **101 Primary Dept**53 yo male...hospice pt throwing up shallow breathing..has liver problems[Shared],Invalid address received:55  SPRINT-W SECTOR-QF 784A2.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0309231,[Notification] [BCFA]-Problem changed from Med - Sick Person to Med - Breathing Problems by BCFA [Shared],This incident ATAB-2012-0029065 h\r\n",
        "CALL:Med - Breathing",
        "ADDR:337 Hallmark Path",
        "X:PLEASANTON RD/Dead End",
        "MAP:750C8",
        "ID:ATAB-2012-000000433",
        "UNIT:101C",
        "INFO:101 Primary Dept**53 yo male...hospice pt throwing up shallow breathing..has liver problems - SPRINT-W SECTOR-QF 784A2.,[Notification] [BCFA]-Problem changed from Med - Sick Person to Med - Breathing Problems by BCFA");

    doTest("T5",
        "Fire - Tree / Br  Applewhite Rd / S Loop 1604 W                                                            749D3    ATAB-2012-000000432 Dept- 101C **101 Primary Dept**GRAS FIRE[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:8  CRICKET-SW SECTOR-TBD.[Shared],Invalid address received:8  CRICKET-SW SECTOR-TBD.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0308159,Overcast  52 F  11 C  Humidity54%Wind SpeedNE 3 mphBarometer30.39 inDewpoint36 F (2 C)Visibility10.00 miLast Update on 14 Nov 7:55 am CST   [Shared]\r\n",
        "CALL:Fire - Tree / Br",
        "ADDR:Applewhite Rd & S Loop 1604 W",
        "MAP:749D3",
        "ID:ATAB-2012-000000432",
        "UNIT:101C",
        "INFO:101 Primary Dept**GRAS FIRE,Overcast  52 F  11 C  Humidity54%Wind SpeedNE 3 mphBarometer30.39 inDewpoint36 F (2 C)Visibility10.00 miLast Update on 14 Nov 7:55 am CST");

    doTest("T6",
        "Med - Sick Perso  23831 Us Hwy 281 S                             S ADDISON/BIG OAK DR                      783A2    ATAB-2012-000000431 Dept- 101A **101 Primary Dept**Multi-Agency BCLE Incident #: BCSO-2012-0307300,19 yoa male having trouble breathing [Shared],Automatic Case Number(s) issued for Ata-Bexar FD: ATAB-2012-000000431. [Shared],\r\n",
        "CALL:Med - Sick Perso",
        "ADDR:23831 Us Hwy 281 S",
        "MADDR:23831 US 281 S",
        "X:S ADDISON/BIG OAK DR",
        "MAP:783A2",
        "ID:ATAB-2012-000000431",
        "UNIT:101A",
        "INFO:19 yoa male having trouble breathing");

    doTest("T7",
        "Med - Seizure     510 Shagbark                                   TIMBERWOOD LN/EL CONEJO                   750F8    ATAB-2012-000000430 Dept- 101A **101 Primary Dept**24 yo male...hit head after siezure, pt is feeling tingley and can't walk, breathing, eyes open[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0306633,[Notification] [BCFA]-Problem changed from Med - Sick Person to Med - Seizure by BCFA [Shared],Automatic Case Number(s) issued for Ata-Bexar FD: ATAB-2012-000000430. [Shared],\r\n",
        "CALL:Med - Seizure",
        "ADDR:510 Shagbark",
        "X:TIMBERWOOD LN/EL CONEJO",
        "MAP:750F8",
        "ID:ATAB-2012-000000430",
        "UNIT:101A",
        "INFO:101 Primary Dept**24 yo male...hit head after siezure, pt is feeling tingley and can't walk, breathing, eyes open,[Notification] [BCFA]-Problem changed from Med - Sick Person to Med - Seizure by BCFA");

    doTest("T8",
        "Med - Fall        23225 Us Hwy 281 S                             N ADDISON/S ADDISON                       783A1    ATAB-2012-000000429 Dept- 101C **101 Primary Dept**55 yo female...pt fell off ladder happened about 15-20 mins ago...has huge bump on the back of her head...pt is breathing and talking[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0306475,[Notification] [BCFA]-Problem changed from Med - Sick Person to Med - Fall by BCFA [Shared],This incident ATAB-2012-0028885 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACAD\r\n",
        "CALL:Med - Fall",
        "ADDR:23225 Us Hwy 281 S",
        "MADDR:23225 US 281 S",
        "X:N ADDISON/S ADDISON",
        "MAP:783A1",
        "ID:ATAB-2012-000000429",
        "UNIT:101C",
        "INFO:101 Primary Dept**55 yo female...pt fell off ladder happened about 15-20 mins ago...has huge bump on the back of her head...pt is breathing and talking,[Notification] [BCFA]-Problem changed from Med - Sick Person to Med - Fall by BCFA");

    doTest("T9",
        "Med - Choking     25624 Progress Rd                              MARTHA RD/HUME RD                              783A6     Dept- B138,138C,138E,101C  81 year old female choking on food[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0305790,Automatic Case Number(s) issued for Sandy Oaks FD: SOAK-2012-000001073. [Shared],[Appended, 17:49:27] ACADIAN: Unit:    766         10403133 [Shared],[Appended, 17:49:27] Transferred incident: Remote   Reference Number: 20121111-ZN16-0947 by Robichaux, Michael P. From ACADIAN [Shared],[Appended, 17:49:27] Interface h\r\n",
        "CALL:Med - Choking",
        "ADDR:25624 Progress Rd",
        "X:MARTHA RD/HUME RD",
        "MAP:783A6",
        "ID:BCSO-2012-0305790",
        "UNIT:B138,138C,138E,101C",
        "INFO:81 year old female choking on food,[Appended, 17:49:27] Unit: 766 - 10403133 ,[Appended, 17:49:27] Transferred incident: Remote   Reference Number: 20121111-ZN16-0947 by Robichaux, Michael P. From ACADIAN ,[Appended, 17:49:27] Interface h");

    doTest("T10",
        "MVC               Englehart Rd / Pleasanton Rd                                                             750D7    ATAB-2012-000000427 Dept- 101C **101 Primary Dept**C says there is an empty running vehicle in a ditch near above location.  C looks like there was an accident, the window is smashed.[Shared],Invalid address received:3232  AT&T-SE SECTOR-QF 750B4.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0305498,Automatic Case Number(s) issued for Ata-Bexar FD: ATAB-2012-000000427. [Shared]\r\n",
        "CALL:MVC",
        "ADDR:Englehart Rd & Pleasanton Rd",
        "MAP:750D7",
        "ID:ATAB-2012-000000427",
        "UNIT:101C",
        "INFO:101 Primary Dept**C says there is an empty running vehicle in a ditch near above location.  C looks like there was an accident, the window is smashed");

    doTest("T11",
        "Fire              Sassafras / Forsythia                                                                         452B7     BBUL-2012-000001643  Dept-104E          **103/104 Primary Dept** Strong smell of natural gas in area.  Unknown which house it is coming from.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0337978,[BCLE] has closed their incident [BCSO-2012-0337978],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000001643. [Shared],\r\n",
        "CALL:Fire",
        "ADDR:Sassafras & Forsythia",
        "MAP:452B7",
        "ID:BBUL-2012-000001643",
        "UNIT:104E",
        "INFO:103/104 Primary Dept** Strong smell of natural gas in area.  Unknown which house it is coming from");

    doTest("T12",
        "MVC - OTV         24345 Wilderness Oak                           FAIRWAY BRIDGE/MIDNIGHT PEAK                   483A2     BBUL-2012-000001635  Dept-104A          **103/104 Primary Dept** [Address:  24345 WILDERNESS OAK] [Medium] [Criminal Trespass Warning] RYAN DAILEY B/M DOB: 10-28-96, AVERY HOLLIS W/M DOB: 01-01-1997, ERNEST NORIEGA W/M DOB: 05-22-1996 REFERENCE CASE 2011-BCSO-015068[Shared],[Premise:  24345 WILDERNESS OAK] [Medium] [Criminal Trespass Warning] RYAN DAILEY B/M DOB: 10-28-96, AVERY HOLLIS W/M DOB: 01-01-1997, ERNEST NORIEGA W/M DOB: 05-22-1996 REFERENCE CASE 2011-BCSO-0150\r\n",
        "CALL:MVC - OTV",
        "ADDR:24345 Wilderness Oak",
        "X:FAIRWAY BRIDGE/MIDNIGHT PEAK",
        "MAP:483A2",
        "ID:BBUL-2012-000001635",
        "UNIT:104A",
        "INFO:103/104 Primary Dept** [Address: 24345 WILDERNESS OAK] [Medium] [Criminal Trespass Warning] RYAN DAILEY B/M DOB: 10-28-96, AVERY HOLLIS W/M DOB: 01-01-1997, ERNEST NORIEGA W/M DOB: 05-22-1996 REFERENCE CASE 2011-BCSO-015068,[Premise: 24345 WILDERNESS OAK] [Medium] [Criminal Trespass Warning] RYAN DAILEY B/M DOB: 10-28-96, AVERY HOLLIS W/M DOB: 01-01-1997, ERNEST NORIEGA W/M DOB: 05-22-1996 REFERENCE CASE 2011-BCSO-0150");

    doTest("T13",
        "Gas/Fuel - Leak   4707 Bending Grove                             BIRDS ELM/BRANCHING BAY                        484E5     BBUL-2012-000001626  Dept-104B          **103/104 Primary Dept** Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000001626.,\r\n",
        "CALL:Gas/Fuel - Leak",
        "ADDR:4707 Bending Grove",
        "X:BIRDS ELM/BRANCHING BAY",
        "MAP:484E5",
        "ID:BBUL-2012-000001626",
        "UNIT:104B");

  }
  
  @Test
  public void testOEMBCFMO() {

    doTest("T1",
        "zFMO  2928-2999 BUTTERFLY PALM                       REDFISH CAVERN/Dead End                                  2013-119-0000527     Dept-FMO06,FMO07**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-119-0000527.,FMO06:CREATED CALL FROM MOBILE,",
        "CALL:zFMO",
        "ADDR:2928-2999 BUTTERFLY PALM",
        "MADDR:2928 BUTTERFLY PALM",
        "X:REDFISH CAVERN/Dead End",
        "ID:2013-119-0000527",
        "UNIT:FMO06,FMO07",
        "INFO:**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-119-0000527.,FMO06:CREATED CALL FROM MOBILE");

    doTest("T2",
        "zFMO  711 W MAYFIELD                                                                                          2013-119-00848       Dept-FMO30**BCFA OUTSIDE AREA**FMO30:CREATED CALL FROM MOBILE,SAPD FUEL,Automatic Case Number(s) issued for FM Insp: 2013-119-00848.,",
        "CALL:zFMO",
        "ADDR:711 W MAYFIELD",
        "ID:2013-119-00848",
        "UNIT:FMO30",
        "INFO:**BCFA OUTSIDE AREA**FMO30:CREATED CALL FROM MOBILE,SAPD FUEL");

    doTest("T3",
        "zFMO  16525 SENIOR RD                                                                                         2013-119-00846       Dept- FMO30**INSPECTOR PAGE**FMO30:CREATED CALL FROM MOBILE,TAZ SERVICES,Automatic Case Number(s) issued for FM Insp: 2013-119-00846.,",
        "CALL:zFMO",
        "ADDR:16525 SENIOR RD",
        "ID:2013-119-00846",
        "UNIT:FMO30",
        "INFO:**INSPECTOR PAGE**FMO30:CREATED CALL FROM MOBILE,TAZ SERVICES");

    doTest("T4",
        "zFMO  7205 HANZI                                     Dead End/SE MILITARY DR                                  2013-119-0000526     Dept-FMO07**BCFA OUTSIDE AREA**FMO07:CREATED CALL FROM MOBILE,one adult female and one juvenile male// starting mileage 109555,Automatic Case Number(s) issued for FM Invest: 2013-119-0000526.,",
        "CALL:zFMO",
        "ADDR:7205 HANZI",
        "X:Dead End/SE MILITARY DR",
        "ID:2013-119-0000526",
        "UNIT:FMO07",
        "INFO:**BCFA OUTSIDE AREA**FMO07:CREATED CALL FROM MOBILE,one adult female and one juvenile male// starting mileage 109555");

    doTest("T5",
        "zFMO  622 Dolorosa                                                                                            2013-119-0000525     Dept- FMO07**INVESTIGATOR PAGE**FMO07:CREATED CALL FROM MOBILE,Transporting one adult female and one juvenile male//starting mileage:109546,Automatic Case Number(s) issued for FM Invest: 2013-119-0000525.,",
        "CALL:zFMO",
        "ADDR:622 Dolorosa",
        "ID:2013-119-0000525",
        "UNIT:FMO07",
        "INFO:**INVESTIGATOR PAGE**FMO07:CREATED CALL FROM MOBILE,Transporting one adult female and one juvenile male//starting mileage:109546");

    doTest("T6",
        "zFMO  8130 Inner Circle                                                                                       2013-119-0000524     Dept- FMO08**INVESTIGATOR PAGE**FMO08:CREATED CALL FROM MOBILE,ast BCOEM/,Automatic Case Number(s) issued for FM Invest: 2013-119-0000524.,",
        "CALL:zFMO",
        "ADDR:8130 Inner Circle",
        "ID:2013-119-0000524",
        "UNIT:FMO08",
        "INFO:**INVESTIGATOR PAGE**FMO08:CREATED CALL FROM MOBILE,ast BCOEM/");

    doTest("T7",
        "Fire - Vehicle        11215 Vollmer Ln                546A8     2013-119-0000522      E115,128A,E116,E128,FMO05,115A **115/116 Primary Dept** C says that her vehicle in front of her house is on fire.[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0133750,Automatic Case Number(s) issued for District 7 FD: D7FR-2013-000000356. [Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details [Shared],Invalid address received:1440  TMOBILE-SW SECTOR-QF 546E3. [Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details",
        "CALL:Fire - Vehicle",
        "ADDR:11215 Vollmer Ln",
        "MAP:546A8",
        "ID:2013-119-0000522",
        "INFO:E115,128A,E116,E128,FMO05,115A - 115/116 Primary Dept** C says that her vehicle in front of her house is on fire");

    doTest("T8",
        "Fire  7509 NEW SULPHUR SPGS                          BLANDFORD/BLANDFORD                            653F6     2013-118-0000521     Dept-E120,U110,142A,136A,E127,T142,B127,U120,B120B,B110,R110,B136**BCFA OUTSIDE AREA**structure fire.. cps energy crews can see it from a small distance..[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0133130,structure fire.. cps energy crews can see it from a small distance..   [Shared],Automatic Case Number(s) issued for China Grove FD: CGRV-2013-000000110. [Shared],Automatic Case Number(s) issued for Gardendale FD: GARD-2013-000000128. [Shared],Automatic Case Number(s) issued for Harmo",
        "CALL:Fire",
        "ADDR:7509 NEW SULPHUR SPGS",
        "X:BLANDFORD/BLANDFORD",
        "MAP:653F6",
        "ID:2013-118-0000521",
        "UNIT:E120,U110,142A,136A,E127,T142,B127,U120,B120B,B110,R110,B136",
        "INFO:**BCFA OUTSIDE AREA**structure fire.. cps energy crews can see it from a small distance..,structure fire.. cps energy crews can see it from a small distance");

    doTest("T9",
        "Assist - Law Enf  21700-blk US HWY 281 S                         ROCKPORT RD/ROCKPORT RD                        751A5     Dept- FMO05  Multi-Agency BCLE Incident #: BCSO-2013-0130850,[Notification] [BCFA]-Problem changed from * BCFA Fire Emergency to Assist - Law Enforcement by BCFA [Shared],Automatic Case Number(s) issued for FM Invest: 2013-115-0000518. [Shared],",
        "CALL:Assist - Law Enf",
        "ADDR:21700-blk US HWY 281 S",
        "MADDR:21700 US 281 S",
        "X:ROCKPORT RD/ROCKPORT RD",
        "MAP:751A5",
        "ID:BCSO-2013-0130850",
        "UNIT:FMO05",
        "INFO:[Notification] [BCFA]-Problem changed from * BCFA Fire Emergency to Assist - Law Enforcement by BCFA");

    doTest("T10",
        "zFMO - Special A  23319 Mesquite Bend                            Dead End/MESQUITE CV                           783D1     Dept- FMO05  DTR BOYFRIEND HAS NOT PICKED UP ITEMS FROM ABOVE LOC   C STATED BOYFRIEND CALLED BEING OTW BUT STILL NOT AT LOC[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0130783,Automatic Case Number(s) issued for FM Invest: 2013-115-0000517. [Shared],",
        "CALL:zFMO - Special A",
        "ADDR:23319 Mesquite Bend",
        "X:Dead End/MESQUITE CV",
        "MAP:783D1",
        "ID:BCSO-2013-0130783",
        "UNIT:FMO05",
        "INFO:DTR BOYFRIEND HAS NOT PICKED UP ITEMS FROM ABOVE LOC   C STATED BOYFRIEND CALLED BEING OTW BUT STILL NOT AT LOC");

    doTest("T11",
        "Fire - Tree / Br  25671 Mathis Rd                                HARDY RD/HARDY RD                              784C6     Dept- E101,E162,E161,BC161,127E,B162,FMO05,FMO90,162C,161B,101C  HOUSE NEXT DOOR TO THE LEFT IS ON FIRE   FLAMES & SMOKE[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0127884,Automatic Case Number(s) issued for Ata-Bexar FD: ATAB-2013-000000175. [Shared],Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2013-000001649. [Shared],C WILL GET OUT OF HIS HOUSE [Shared],Backed up E161 with BC161 [Shared],Automatic Case Number(s) issued for Harmony FD: HARM-2013-",
        "CALL:Fire - Tree / Br",
        "ADDR:25671 Mathis Rd",
        "X:HARDY RD/HARDY RD",
        "MAP:784C6",
        "ID:BCSO-2013-0127884",
        "UNIT:E101,E162,E161,BC161,127E,B162,FMO05,FMO90,162C,161B,101C",
        "INFO:HOUSE NEXT DOOR TO THE LEFT IS ON FIRE   FLAMES & SMOKE,C WILL GET OUT OF HIS HOUSE ,Backed up E161 with BC161");

    doTest("T12",
        "zFMO  622 dolorosa                                                                                            2013-115-0000514     Dept- FMO05**INVESTIGATOR PAGE**Automatic Case Number(s) issued for FM Invest: 2013-115-0000514.,",
        "CALL:zFMO",
        "ADDR:622 dolorosa",
        "ID:2013-115-0000514",
        "UNIT:FMO05",
        "INFO:**INVESTIGATOR PAGE**Automatic Case Number(s) issued for FM Invest: 2013-115-0000514");

    doTest("T13",
        "zFMO  West, Tx                                                                                                2013-114-0000511     Dept- FMO07,FMO08**INVESTIGATOR PAGE**FMO07:CREATED CALL FROM MOBILE,1608, 1606, 1616,Automatic Case Number(s) issued for FM Invest: 2013-114-0000511.,FMO07 - please assign veh AR152,",
        "CALL:zFMO",
        "ADDR:West, Tx",
        "ID:2013-114-0000511",
        "UNIT:FMO07,FMO08",
        "INFO:**INVESTIGATOR PAGE**FMO07:CREATED CALL FROM MOBILE,1608, 1606, 1616,FMO07 - please assign veh AR152");

    doTest("T14",
        "zFMO  400 N OLIVE ST                                 E CROCKETT ST/BOSTON                           617B5     SPK-2013-000000222   Dept-FMO30,M139B,FMO30**BCFA OUTSIDE AREA**FMO30:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-112-00811.,This is actually in Dallas Texas......,Automatic Case Number(s) issued for Shavano Park FD: SPK-2013-000000222.,",
        "CALL:zFMO",
        "ADDR:400 N OLIVE ST",
        "X:E CROCKETT ST/BOSTON",
        "MAP:617B5",
        "ID:SPK-2013-000000222",
        "UNIT:FMO30,M139B,FMO30**BCFA OUTSIDE AREA**FMO30:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-112-00811.,This is actually in Dallas Texas......,Automatic Case Number(s) issued for Shavano Park FD: SPK-2013-000000222.,");

    doTest("T15",
        "Med - Bleeding    112 W Mossy Cup Ln                             MOSSY CUP/Dead End                             515B4     2013-113-00830       Dept- M139B,E139,FMO30,139D **139 Primary Dept**  83 yom fallen injry..bleeding from head,Automatic Case Number(s) issued for Shavano Park FD: SPK-2013-000000221.,Backed up M139B with E139,Automatic Case Number(s) issued for FM Insp: 2013-113-00830.,",
        "CALL:Med - Bleeding",
        "ADDR:112 W Mossy Cup Ln",
        "X:MOSSY CUP/Dead End",
        "MAP:515B4",
        "ID:2013-113-00830",
        "UNIT:M139B,E139,FMO30,139D",
        "INFO:139 Primary Dept**  83 yom fallen injry..bleeding from head,Backed up M139B with E139");

    doTest("T16",
        "zFMO  5554-5571 DUFFEK DR                            Dead End/ACKERMAN RD                                     2013-113-0000509     Dept-FMO06**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-113-0000509.,",
        "CALL:zFMO",
        "ADDR:5554-5571 DUFFEK DR",
        "MADDR:5554 DUFFEK DR",
        "X:Dead End/ACKERMAN RD",
        "ID:2013-113-0000509",
        "UNIT:FMO06",
        "INFO:**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-113-0000509");

    doTest("T17",
        "zFMO  217 GUILFORD FORGE                             RISING STAR/WAGON CROSSING                               2013-113-0000508     Dept-FMO05**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-113-0000508.,",
        "CALL:zFMO",
        "ADDR:217 GUILFORD FORGE",
        "X:RISING STAR/WAGON CROSSING",
        "ID:2013-113-0000508",
        "UNIT:FMO05",
        "INFO:**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-113-0000508");

    doTest("T18",
        "zFMO  5560 DUFFEK DR                                 Dead End/ACKERMAN RD                                     2013-113-0000506     Dept-FMO06**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-113-0000506.,FMO06:CREATED CALL FROM MOBILE,",
        "CALL:zFMO",
        "ADDR:5560 DUFFEK DR",
        "X:Dead End/ACKERMAN RD",
        "ID:2013-113-0000506",
        "UNIT:FMO06",
        "INFO:**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-113-0000506.,FMO06:CREATED CALL FROM MOBILE");

    doTest("T19",
        "zFMO  2819 Se Military Dr                            S NEW BRAUNFELS AVE/HANZI                      651E8     2013-113-0000505     Dept-FMO08**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-113-0000505.,",
        "CALL:zFMO",
        "ADDR:2819 Se Military Dr",
        "X:S NEW BRAUNFELS AVE/HANZI",
        "MAP:651E8",
        "ID:2013-113-0000505",
        "UNIT:FMO08",
        "INFO:**BCFA OUTSIDE AREA**Automatic Case Number(s) issued for FM Invest: 2013-113-0000505");

    doTest("T20",
        "zFMO  5600 blk gawain                                                                                         2013-113-0000504     Dept- FMO07**INVESTIGATOR PAGE**FMO07:CREATED CALL FROM MOBILE,2013-FM-009,Automatic Case Number(s) issued for FM Invest: 2013-113-0000504.,",
        "CALL:zFMO",
        "ADDR:5600 blk gawain",
        "MADDR:5600  gawain",
        "ID:2013-113-0000504",
        "UNIT:FMO07",
        "INFO:**INVESTIGATOR PAGE**FMO07:CREATED CALL FROM MOBILE,2013-FM-009");

    doTest("T21",
        "zFMO - Interview - Witnes 21 Park Mounain                                                                                      2013-122-0000546     Dept- FMO08**Inv Check Out**FMO08:CREATED CALL FROM MOBILE,2013-FM-068,Automatic Case Number(s) issued for FM Invest: 2013-122-0000546.,",
        "CALL:zFMO - Interview - Witnes",
        "ADDR:21 Park Mounain",
        "ID:2013-122-0000546",
        "UNIT:FMO08",
        "INFO:**Inv Check Out**FMO08:CREATED CALL FROM MOBILE,2013-FM-068");

  }

  @Test
  public void testOEMBCFMO2() {

    doTest("T1",
        "zFMO - Inspection Followu 22115 US Hwy. 281 S                                                                                  2013-172-01289       Dept- FMO36 **OUTSIDE BCFA AREA** FMO36:CREATED CALL FROM MOBILE,followup construction,Automatic Case Number(s) issued for FM Insp: 2013-172-01289.,",
        "CALL:zFMO - Inspection Followu",
        "ADDR:22115 US Hwy 281 S",
        "MADDR:22115 US 281 S",
        "ID:2013-172-01289",
        "UNIT:FMO36",
        "INFO:OUTSIDE BCFA AREA** FMO36:CREATED CALL FROM MOBILE,followup construction");

    doTest("T2",
        "zFMO - Inspectio      6619 QUAIL LAKE                                                                                                2013-172-01286       Dept- FMO14**145 Primary Dept**FMO14:CREATED CALL FROM MOBILE,HILL QUALITY CHILDCARE,Automatic Case Number(s) issued for FM Insp: 2013-172-01286.,",
        "CALL:zFMO - Inspectio",
        "ADDR:6619 QUAIL LAKE",
        "ID:2013-172-01286",
        "UNIT:FMO14",
        "INFO:**145 Primary Dept**FMO14:CREATED CALL FROM MOBILE,HILL QUALITY CHILDCARE");

    doTest("T3",
        "zFMO - Special Assignment 4900-5199 PRUE RD                             FREDERICKSBURG RD/LAUREATE DR                          2013-172-01282       Dept- FMO10 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-172-01282.,",
        "CALL:zFMO - Special Assignment",
        "ADDR:4900-5199 PRUE RD",
        "MADDR:4900 PRUE RD",
        "X:FREDERICKSBURG RD/LAUREATE DR",
        "ID:2013-172-01282",
        "UNIT:FMO10",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-172-01282");

    doTest("T4",
        "zFMO - Investigation Foll  622 Dolorosa                                                                                            2013-172-0000766    Dept-FMO05**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-172-0000766.,",
        "CALL:zFMO - Investigation Foll",
        "ADDR:622 Dolorosa",
        "ID:2013-172-0000766",
        "UNIT:FMO05",
        "INFO:**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-172-0000766");

    doTest("T5",
        "Fire - Structure     - 17396 Low Rd                   #       - 512D3    - 2013-171-0000763     Depts-E116,E126B,C115,T115,T128,FMO05,126E,128E,115E - 126 Primary Dept fire in living room[Shared],Invalid address received:234  SPRINT-NE SECTOR-QF 512C5.[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0193610,Automatic Case Number(s) issued for Grey Forest FD: GRYF-2013-000000237. [Shared],Automatic Case Number(s) issued for Helotes FD: HELO-2013-000000099. [Shared]",
        "CALL:Fire - Structure",
        "ADDR:17396 Low Rd",
        "MAP:512D3",
        "ID:2013-171-0000763",
        "INFO:Depts-E116,E126B,C115,T115,T128,FMO05,126E,128E,115E - 126 Primary Dept fire in living room");

    doTest("T6",
        "zFMO - Inspectio    5565 Mansions Bluff                                                                                             2013-171-01275        Dept-FMO36    **D2FR Primary Dept** FMO36:CREATED CALL FROM MOBILE,Rough In inspections,Automatic Case Number(s) issued for FM Insp: 2013-171-01275.,",
        "CALL:zFMO - Inspectio",
        "ADDR:5565 Mansions Bluff",
        "ID:2013-171-01275",
        "UNIT:FMO36",
        "INFO:D2FR Primary Dept** FMO36:CREATED CALL FROM MOBILE,Rough In inspections");

    doTest("T7",
        "zFMO - Investigation Foll 7918 DEMPSEY DR                               HILLBURN DR/GAVILAN DR                        648D8    2013-171-0000762     Dept- FMO05 **OUTSIDE BCFA AREA** FMO05:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Invest: 2013-171-0000762.,",
        "CALL:zFMO - Investigation Foll",
        "ADDR:7918 DEMPSEY DR",
        "X:HILLBURN DR/GAVILAN DR",
        "MAP:648D8",
        "ID:2013-171-0000762",
        "UNIT:FMO05",
        "INFO:OUTSIDE BCFA AREA** FMO05:CREATED CALL FROM MOBILE");

    doTest("T8",
        "Fire - Structure      6711 SUNLIT PASS DR                             Dead End/BENDING CREST                            553D6        2013-171-0000759     Dept- C145,E145B,Q145,FMO05,145B,111E,108E,131B**145 Primary Dept**STATES HOUSE BEHIND THEM HOUSE IS ON FIRE[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0192770,STATES THE CORNER OF THE HOUSE IS ON FIRE ; STATES ITS SMALL [Shared],Automatic Case Number(s) issued for Windcrest FD: WIND-2013-000000967. [Shared],Automatic Case Number(s) issued for Camelot FD: CAM-2013-000000600. [Shared],CAMELOT OUT OF SERVICE//KIRBY AND CONVERSE RESPONDING [Shared],ALL COMMUNICATIONS ON",
        "CALL:Fire - Structure",
        "ADDR:6711 SUNLIT PASS DR",
        "X:Dead End/BENDING CREST",
        "MAP:553D6",
        "ID:2013-171-0000759",
        "UNIT:C145,E145B,Q145,FMO05,145B,111E,108E,131B",
        "INFO:**145 Primary Dept**STATES HOUSE BEHIND THEM HOUSE IS ON FIRE,STATES THE CORNER OF THE HOUSE IS ON FIRE ; STATES ITS SMALL ,CAMELOT OUT OF SERVICE//KIRBY AND CONVERSE RESPONDING ,ALL COMMUNICATIONS ON");

    doTest("T9",
        "zFMO - Inspectio  21806 Hwy. 281 S.                                                                                       Dept- FMO36  FMO36:CREATED CALL FROM MOBILE,Inspection followup.,Automatic Case Number(s) issued for FM Insp: 2013-170-01268.,",
        "CALL:zFMO - Inspectio",
        "ADDR:21806 Hwy 281 S",
        "UNIT:FMO36",
        "INFO:FMO36:CREATED CALL FROM MOBILE,Inspection followup");

    doTest("T10",
        "zFMO - Inspection         6415 MONTGOMERY RD                                                                                   2013-170-01265       Dept- FMO30 **OUTSIDE BCFA AREA** FMO30:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-170-01265.,",
        "CALL:zFMO - Inspection",
        "ADDR:6415 MONTGOMERY RD",
        "ID:2013-170-01265",
        "UNIT:FMO30",
        "INFO:OUTSIDE BCFA AREA** FMO30:CREATED CALL FROM MOBILE");

    doTest("T11",
        "zFMO - Investigation Foll 300-399 LA GARDE ST                           PALOS/CALERA                                           2013-170-0000758     Dept- FMO05 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-170-0000758.,",
        "CALL:zFMO - Investigation Foll",
        "ADDR:300-399 LA GARDE ST",
        "MADDR:300 LA GARDE ST",
        "X:PALOS/CALERA",
        "ID:2013-170-0000758",
        "UNIT:FMO05",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-170-0000758");

    doTest("T12",
        "zFMO - Inspection         211 RED QUILL NEST                                                                                   2013-170-01264       Dept- FMO10 **INSPECTOR PAGE** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-170-01264.,",
        "CALL:zFMO - Inspection",
        "ADDR:211 RED QUILL NEST",
        "ID:2013-170-01264",
        "UNIT:FMO10",
        "INFO:INSPECTOR PAGE** FMO10:CREATED CALL FROM MOBILE");

    doTest("T13",
        "Fire - Structure  20295 Somerset Rd               W DIXON RD/Dead End                       747B3     2013-170-01259       Dept- E140,T140,FMO12,140C,130D,119B,206D  Multi-Agency BCLE Incident #: BCSO-2013-0191966,LIGHTS ARE SMOKING  [Shared],[Notification] [BCFA]-Problem changed from Fire to Fire - Structure by BCFA [Shared],CIRCUIT BREAKERS HAVE GONE OFF. [Shared],Automatic Case Number(s) issued for Somerset FD: SOM-2013-000000456. [Shared],Automatic Case Number(s) issued for ESD5 FD: ESD5-2013-000000607. [Shared],Automatic Case Number(s) issued for Lytle FD: LYTL-20",
        "CALL:Fire - Structure",
        "ADDR:20295 Somerset Rd",
        "X:W DIXON RD/Dead End",
        "MAP:747B3",
        "ID:2013-170-01259",
        "UNIT:E140,T140,FMO12,140C,130D,119B,206D",
        "INFO:LIGHTS ARE SMOKING - [Notification] [BCFA]-Problem changed from Fire to Fire - Structure by BCFA ,CIRCUIT BREAKERS HAVE GONE OFF");

    doTest("T14",
        "zFMO - Meeting            3201 E HOUSTON ST                             COCA COLA PLACE/AT AND T CENTER PKWY          617F5    2013-170-01258       Dept- FMO30 **OUTSIDE BCFA AREA** FMO30:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-170-01258.,",
        "CALL:zFMO - Meeting",
        "ADDR:3201 E HOUSTON ST",
        "X:COCA COLA PLACE/AT AND T CENTER PKWY",
        "MAP:617F5",
        "ID:2013-170-01258",
        "UNIT:FMO30",
        "INFO:OUTSIDE BCFA AREA** FMO30:CREATED CALL FROM MOBILE");

    doTest("T15",
        "zFMO - Inspection         11026 Culebra Rd                                                                                     2013-170-01257       Dept- FMO34 **INSPECTOR PAGE** FMO34:CREATED CALL FROM MOBILE,VHS/BLD Final,Automatic Case Number(s) issued for FM Insp: 2013-170-01257.,",
        "CALL:zFMO - Inspection",
        "ADDR:11026 Culebra Rd",
        "ID:2013-170-01257",
        "UNIT:FMO34",
        "INFO:INSPECTOR PAGE** FMO34:CREATED CALL FROM MOBILE,VHS/BLD Final");

    doTest("T16",
        "zFMO - Inspectio  4375 S LOOP 1604                                                                              752D3     Dept- FMO36  FMO36:CREATED CALL FROM MOBILE,Hydro - Final x2,Automatic Case Number(s) issued for FM Insp: 2013-170-01253.,",
        "CALL:zFMO - Inspectio",
        "ADDR:4375 S LOOP 1604",
        "MAP:752D3",
        "UNIT:FMO36",
        "INFO:FMO36:CREATED CALL FROM MOBILE,Hydro - Final x2");

    doTest("T17",
        "zFMO - Investigation Foll 622 dolorosa                                                                                         2013-170-0000757     Dept- FMO05 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-170-0000757.,",
        "CALL:zFMO - Investigation Foll",
        "ADDR:622 dolorosa",
        "ID:2013-170-0000757",
        "UNIT:FMO05",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-170-0000757");

    doTest("T18",
        "zFMO - Special Assignment 800-903 SAN LUIS ST                           S SALADO ST/S COMAL ST                                 2013-170-01250       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-170-01250.,",
        "CALL:zFMO - Special Assignment",
        "ADDR:800-903 SAN LUIS ST",
        "MADDR:800 SAN LUIS ST",
        "X:S SALADO ST/S COMAL ST",
        "ID:2013-170-01250",
        "UNIT:FMO12",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-170-01250");

    doTest("T19",
        "zFMO - Investiga    200 N Comal                                                                                                     2013-169-0000754      Dept-FMO08    **D2FR Primary Dept** FMO08:CREATED CALL FROM MOBILE,2013-FM-096,Automatic Case Number(s) issued for FM Invest: 2013-169-0000754.,",
        "CALL:zFMO - Investiga",
        "ADDR:200 N Comal",
        "ID:2013-169-0000754",
        "UNIT:FMO08",
        "INFO:D2FR Primary Dept** FMO08:CREATED CALL FROM MOBILE,2013-FM-096");

    doTest("T20",
        "zFMO - Inspection         24891 Boerne Stage rd                                                                                2013-169-01245       Dept- FMO10 **OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-169-01245.,",
        "CALL:zFMO - Inspection",
        "ADDR:24891 Boerne Stage rd",
        "ID:2013-169-01245",
        "UNIT:FMO10",
        "INFO:OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE");

    doTest("T21",
        "zFMO - Inspectio      4375 S. Loop  1604 E.                                                                                          2013-169-01244       Dept- FMO36**145 Primary Dept**FMO36:CREATED CALL FROM MOBILE,Hydro test.,Automatic Case Number(s) issued for FM Insp: 2013-169-01244.,",
        "CALL:zFMO - Inspectio",
        "ADDR:4375 S Loop",
        "X:1604 E.",
        "ID:2013-169-01244",
        "UNIT:FMO36",
        "INFO:**145 Primary Dept**FMO36:CREATED CALL FROM MOBILE,Hydro test");

    doTest("T22",
        "zFMO - Inspection         24188 BOERNE STAGE RD                         BAYWATER STAGE/CROSS MOUNTAIN TRL                      2013-169-01242       Dept- FMO10 **OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-169-01242.,",
        "CALL:zFMO - Inspection",
        "ADDR:24188 BOERNE STAGE RD",
        "X:BAYWATER STAGE/CROSS MOUNTAIN TRL",
        "ID:2013-169-01242",
        "UNIT:FMO10",
        "INFO:OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE");

    doTest("T23",
        "zFMO - Inspectio    28036 Boerne Stage Rd             DOS CERROS DR/BRIDLEWOOD TRL                446C3       2013-169-01240       Dept- FMO10 **132 Primary Dept** leon springs fd #4,Automatic Case Number(s) issued for FM Insp: 2013-169-01240.,",
        "CALL:zFMO - Inspectio",
        "ADDR:28036 Boerne Stage Rd",
        "X:DOS CERROS DR/BRIDLEWOOD TRL",
        "MAP:446C3",
        "ID:2013-169-01240",
        "UNIT:FMO10",
        "INFO:132 Primary Dept** leon springs fd #4");

    doTest("T24",
        "zFMO - Special Assignment  7337 Louis pasteur                                                                                      2013-169-0000750    Dept-FMO08**Inv Page*FMO08:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Invest: 2013-169-0000750.,",
        "CALL:zFMO - Special Assignment",
        "ADDR:7337 Louis pasteur",
        "ID:2013-169-0000750",
        "UNIT:FMO08",
        "INFO:**Inv Page*FMO08:CREATED CALL FROM MOBILE");

    doTest("T25",
        "zFMO - Investigation      6614-6637 S NEW BRAUNFELS AVE                 PVT RD AT 6639 S NEW BRAUNFELS/PVT RD AT 6639          2013-169-0000749     Dept- FMO05 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-169-0000749.,",
        "CALL:zFMO - Investigation",
        "ADDR:6614-6637 S NEW BRAUNFELS AVE",
        "MADDR:6614 S NEW BRAUNFELS AVE",
        "X:PVT RD AT 6639 S NEW BRAUNFELS/PVT RD AT 6639",
        "ID:2013-169-0000749",
        "UNIT:FMO05",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-169-0000749");

    doTest("T26",
        "Fire - Structure  15198 QUESENBERRY RD           SOMERSET RD/Dead End                      714B3     2013-169-0000748     Dept -E130,E119,T140,FMO13,140D,130C,119E,206E     *** 130 Primary Dept ***C/ STATES THERE IS A HOUSE ON FIRE[Shared],Invalid address received:362  SPRINT-N SECTOR-QF 748F8.[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0190104,STATES ITS NEXT DOOR NEIGHBORS HOUSE THAT IS ON FIRE [Shared],Automatic Case Number(s) issued for Jarret FD: JARR-2013-000000322. [Shared],Automatic Case Number(s) issued for Somerset FD: SOM-2013-000000448. [Shared],Automatic Case Number(s) issued for E",
        "CALL:Fire - Structure",
        "ADDR:15198 QUESENBERRY RD",
        "X:SOMERSET RD/Dead End",
        "MAP:714B3",
        "ID:2013-169-0000748",
        "UNIT:E130,E119,T140,FMO13,140D,130C,119E,206E",
        "INFO:* 130 Primary Dept - *C/ STATES THERE IS A HOUSE ON FIRE,STATES ITS NEXT DOOR NEIGHBORS HOUSE THAT IS ON FIRE");

    doTest("T27",
        "zFMO - SELF INITIATED ACT 401 S Frio St                                 W DURANGO BLVD/SB IH 35 S OFRP S FRIO         616D5    2013-168-0000747     Dept- FMO05 **OUTSIDE BCFA AREA** obtaining search warrant,Automatic Case Number(s) issued for FM Invest: 2013-168-0000747.,",
        "CALL:zFMO - SELF INITIATED ACT",
        "ADDR:401 S Frio St",
        "X:W DURANGO BLVD/SB IH 35 S OFRP S FRIO",
        "MAP:616D5",
        "ID:2013-168-0000747",
        "UNIT:FMO05",
        "INFO:OUTSIDE BCFA AREA** obtaining search warrant");

    doTest("T28",
        "zFMO - Inspection         13830 Southton Rd.                                                                                   2013-168-01229       Dept- FMO36 **OUTSIDE BCFA AREA** FMO36:CREATED CALL FROM MOBILE,Construction Follow up.,Automatic Case Number(s) issued for FM Insp: 2013-168-01229.,",
        "CALL:zFMO - Inspection",
        "ADDR:13830 Southton Rd",
        "ID:2013-168-01229",
        "UNIT:FMO36",
        "INFO:OUTSIDE BCFA AREA** FMO36:CREATED CALL FROM MOBILE,Construction Follow up");

    doTest("T29",
        "zFMO - Inspectio      13117 Donop Rd.                                                                                                2013-168-01227       Dept- FMO36**145 Primary Dept**FMO36:CREATED CALL FROM MOBILE,Inspection follow up/ permit.,Automatic Case Number(s) issued for FM Insp: 2013-168-01227.,",
        "CALL:zFMO - Inspectio",
        "ADDR:13117 Donop Rd",
        "ID:2013-168-01227",
        "UNIT:FMO36",
        "INFO:**145 Primary Dept**FMO36:CREATED CALL FROM MOBILE,Inspection follow up/ permit");

    doTest("T30",
        "zFMO - Inspectio      10880 US HWY 181 S                              GREEN LAKE DR/GREEN LAKE DR                       684F6        2013-168-01226       Dept- FMO36**145 Primary Dept**FMO36:CREATED CALL FROM MOBILE,Fuel tank permit followup.,Automatic Case Number(s) issued for FM Insp: 2013-168-01226.,",
        "CALL:zFMO - Inspectio",
        "ADDR:10880 US HWY 181 S",
        "MADDR:10880 US 181 S",
        "X:GREEN LAKE DR/GREEN LAKE DR",
        "MAP:684F6",
        "ID:2013-168-01226",
        "UNIT:FMO36",
        "INFO:**145 Primary Dept**FMO36:CREATED CALL FROM MOBILE,Fuel tank permit followup");

    doTest("T31",
        "zFMO - Inspection         4375 S. Loop 1604 E.                                                                                 2013-168-01224       Dept- FMO36 **INSPECTOR PAGE** FMO36:CREATED CALL FROM MOBILE,Hydro final 2hrs.,Automatic Case Number(s) issued for FM Insp: 2013-168-01224.,",
        "CALL:zFMO - Inspection",
        "ADDR:4375 S Loop 1604 E",
        "ID:2013-168-01224",
        "UNIT:FMO36",
        "INFO:INSPECTOR PAGE** FMO36:CREATED CALL FROM MOBILE,Hydro final 2hrs");

    doTest("T32",
        "zFMO - SELF INITIATED ACT 622 Dolorosa                                                                                         2013-168-0000743     Dept- FMO06 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-168-0000743.,",
        "CALL:zFMO - SELF INITIATED ACT",
        "ADDR:622 Dolorosa",
        "ID:2013-168-0000743",
        "UNIT:FMO06",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-168-0000743");

    doTest("T33",
        "zFMO - Assist Other Agenc 2125 Universal City Blvd                      EL DORADO/SUNRISE CANYON DR                   554D2    2013-167-0000740     Dept- FMO05 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-167-0000740.,",
        "CALL:zFMO - Assist Other Agenc",
        "ADDR:2125 Universal City Blvd",
        "X:EL DORADO/SUNRISE CANYON DR",
        "MAP:554D2",
        "ID:2013-167-0000740",
        "UNIT:FMO05",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-167-0000740");

    doTest("T34",
        "(FW: ) Fire - Structure  14725 LADD RD                   MILES RD/W KELLER RD            676D8      Dept-E140,E130,E119,E206,B118,Q140,T140,E706,FMO08,149A,RB149,118 2013-FM-0000097          **118/119 Primary Units**house behind this address on ladd rd is on fire the whole house is in flames[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0187199,Automatic Case Number(s) issued for ESD5 FD: ESD5-2013-000000590. [Shared],Automatic Case Number(s) issued for Somerset FD: SOM-2013-000000438. [Shared],Automatic Case Number(s) issued for Jarret FD: JARR-2013-000000318. [Shared],Automatic Case Number(s) issued for Lytle FD:",
        "CALL:Fire - Structure",
        "ADDR:14725 LADD RD",
        "X:MILES RD/W KELLER RD",
        "MAP:676D8",
        "ID:BCSO-2013-0187199",
        "UNIT:E140,E130,E119,E206,B118,Q140,T140,E706,FMO08,149A,RB149,118",
        "INFO:2013-FM-0000097 - 118/119 Primary Units**house behind this address on ladd rd is on fire the whole house is in flames");

    doTest("T35",
        "zFMO - Special Assignment 203 w nueva                                                                                          2013-165-01218       Dept- FMO10 **INSPECTOR PAGE** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-165-01218.,",
        "CALL:zFMO - Special Assignment",
        "ADDR:203 w nueva",
        "ID:2013-165-01218",
        "UNIT:FMO10",
        "INFO:INSPECTOR PAGE** FMO10:CREATED CALL FROM MOBILE");

    doTest("T36",
        "zFMO - Investigation Foll  622 Dolorosa                                                                                            2013-165-0000737    Dept-FMO06**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-165-0000737.,",
        "CALL:zFMO - Investigation Foll",
        "ADDR:622 Dolorosa",
        "ID:2013-165-0000737",
        "UNIT:FMO06",
        "INFO:**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-165-0000737");

    doTest("T37",
        "zFMO - Inspection         16840 Shepard Rd.                                                                                    2013-165-01216       Dept- FMO36 **INSPECTOR PAGE** FMO36:CREATED CALL FROM MOBILE,Hyodr test 2hr.,Automatic Case Number(s) issued for FM Insp: 2013-165-01216.,",
        "CALL:zFMO - Inspection",
        "ADDR:16840 Shepard Rd",
        "ID:2013-165-01216",
        "UNIT:FMO36",
        "INFO:INSPECTOR PAGE** FMO36:CREATED CALL FROM MOBILE,Hyodr test 2hr");

    doTest("T38",
        "zFMO - Investigation Foll  622 Dolorosa                                                                                            2013-165-0000736    Dept-FMO05**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-165-0000736.,",
        "CALL:zFMO - Investigation Foll",
        "ADDR:622 Dolorosa",
        "ID:2013-165-0000736",
        "UNIT:FMO05",
        "INFO:**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-165-0000736");

    doTest("T39",
        "zFMO - Inspection         12635-12799 US HWY 181 S                      MAX RD/W LAGUNA RD                                     2013-165-01214       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-165-01214.,FMO12:CREATED CALL FROM MOBILE,12751 hwy 181 s,",
        "CALL:zFMO - Inspection",
        "ADDR:12635-12799 US HWY 181 S",
        "MADDR:12635 US 181 S",
        "X:MAX RD/W LAGUNA RD",
        "ID:2013-165-01214",
        "UNIT:FMO12",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-165-01214.,FMO12:CREATED CALL FROM MOBILE,12751 hwy 181 s");

    doTest("T40",
        "zFMO - Inspectio    24891 BOERNE STAGE RD             BAYWATER STAGE/BROAD OAK TRL                479B1       2013-165-01213       Dept- FMO34 **132 Primary Dept** FMO34:CREATED CALL FROM MOBILE,UFL Hydro,Automatic Case Number(s) issued for FM Insp: 2013-165-01213.,",
        "CALL:zFMO - Inspectio",
        "ADDR:24891 BOERNE STAGE RD",
        "X:BAYWATER STAGE/BROAD OAK TRL",
        "MAP:479B1",
        "ID:2013-165-01213",
        "UNIT:FMO34",
        "INFO:132 Primary Dept** FMO34:CREATED CALL FROM MOBILE,UFL Hydro");

    doTest("T41",
        "zFMO - SELF INITIATED ACT 622 Dolorosa                                                                                         2013-165-0000734     Dept- FMO06 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-165-0000734.,",
        "CALL:zFMO - SELF INITIATED ACT",
        "ADDR:622 Dolorosa",
        "ID:2013-165-0000734",
        "UNIT:FMO06",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-165-0000734");

    doTest("T42",
        "zFMO - Inspectio    19414 BABCOCK RD                  HEUERMANN RD/KYLE SEALE PKWY                479D8       2013-165-01208       Dept- FMO34 **132 Primary Dept** FMO34:CREATED CALL FROM MOBILE,UFL Visual/Hydro,Automatic Case Number(s) issued for FM Insp: 2013-165-01208.,",
        "CALL:zFMO - Inspectio",
        "ADDR:19414 BABCOCK RD",
        "X:HEUERMANN RD/KYLE SEALE PKWY",
        "MAP:479D8",
        "ID:2013-165-01208",
        "UNIT:FMO34",
        "INFO:132 Primary Dept** FMO34:CREATED CALL FROM MOBILE,UFL Visual/Hydro");

    doTest("T43",
        "Gas/Fuel - Leak   4105 S Loop 1604 E                             EAGLE FORD COMMON/IH 37 S                      752C3     Dept- BC161,E162,FMO24,E161,FMO00,162E  C says there is a truck in the back that is leaking some kind of fluid.  Unk what it is.  Possibly flamable[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0185957,At the Pilot [Shared],C says it is a tanker truck that is leaking right out of the tank. [Shared],[Notification] [BCFA]-Problem changed from Fire to Gas/Fuel - Spill by BCFA [Shared],C says that the driver says it is Argon [Shared],Driver saying",
        "CALL:Gas/Fuel - Leak",
        "ADDR:4105 S Loop 1604 E",
        "X:EAGLE FORD COMMON/IH 37 S",
        "MAP:752C3",
        "ID:BCSO-2013-0185957",
        "UNIT:BC161,E162,FMO24,E161,FMO00,162E",
        "INFO:C says there is a truck in the back that is leaking some kind of fluid - Unk what it is - Possibly flamable,At the Pilot ,C says it is a tanker truck that is leaking right out of the tank. ,[Notification] [BCFA]-Problem changed from Fire to Gas/Fuel - Spill by BCFA ,C says that the driver says it is Argon ,Driver saying");

    doTest("T44",
        "zFMO - Special Assignment 6784-6901 CULEBRA RD                          AVE G/NW LOOP 410                                      2013-164-01204       Dept- FMO10 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-164-01204.,",
        "CALL:zFMO - Special Assignment",
        "ADDR:6784-6901 CULEBRA RD",
        "MADDR:6784 CULEBRA RD",
        "X:AVE G/NW LOOP 410",
        "ID:2013-164-01204",
        "UNIT:FMO10",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-164-01204");

    doTest("T45",
        "zFMO - Inspection Followu 12573-12635 US HWY 181 S                      WESTERN TRAILS/MAX RD                                  2013-164-01199       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-164-01199.,FMO12:CREATED CALL FROM MOBILE,",
        "CALL:zFMO - Inspection Followu",
        "ADDR:12573-12635 US HWY 181 S",
        "MADDR:12573 US 181 S",
        "X:WESTERN TRAILS/MAX RD",
        "ID:2013-164-01199",
        "UNIT:FMO12",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-164-01199.,FMO12:CREATED CALL FROM MOBILE");

    doTest("T46",
        "zFMO - Inspection         4628-4645 S FLORES RD                         LAMM RD/S LOOP 1604 E                                  2013-164-01195       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-164-01195.,",
        "CALL:zFMO - Inspection",
        "ADDR:4628-4645 S FLORES RD",
        "MADDR:4628 S FLORES RD",
        "X:LAMM RD/S LOOP 1604 E",
        "ID:2013-164-01195",
        "UNIT:FMO12",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-164-01195");

    doTest("T47",
        "zFMO - Meeting            100 Dolorosa                                  W MARKET ST/S MAIN AVE                        616E5    2013-164-0000730     Dept- FMO05 **OUTSIDE BCFA AREA** [Premise:  100 DOLOROSA] [Medium] [Criminal Trespass Warning] FUENTES, JOAQUIN JULIAN W/M DOB: 03-08-1960 REFERENCE CASE 2011-BCSO-050884,[Address:  100 DOLOROSA] [Medium] [Criminal Trespass Warning] FUENTES, JOAQUIN JULIAN W/M DOB: 03-08-1960 REFERENCE CASE 2011-BCSO-050884,meeting at the DA's office,Automatic Case Number(s) issued for FM Invest: 2013-164-0000730.,",
        "CALL:zFMO - Meeting",
        "ADDR:100 Dolorosa",
        "X:W MARKET ST/S MAIN AVE",
        "MAP:616E5",
        "ID:2013-164-0000730",
        "UNIT:FMO05",
        "INFO:OUTSIDE BCFA AREA** [Premise: 100 DOLOROSA] [Medium] [Criminal Trespass Warning] FUENTES, JOAQUIN JULIAN W/M DOB: 03-08-1960 REFERENCE CASE 2011-BCSO-050884,[Address: 100 DOLOROSA] [Medium] [Criminal Trespass Warning] FUENTES, JOAQUIN JULIAN W/M DOB: 03-08-1960 REFERENCE CASE 2011-BCSO-050884,meeting at the DA's office");

    doTest("T48",
        "zFMO - Inspection         4272-4283 S FLORES RD                         NB IH 37 S OFRP FLORES RD/OLD LAMM RD                  2013-164-01191       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-164-01191.,FMO12:CREATED CALL FROM MOBILE,",
        "CALL:zFMO - Inspection",
        "ADDR:4272-4283 S FLORES RD",
        "MADDR:4272 S FLORES RD",
        "X:NB IH 37 S OFRP FLORES RD/OLD LAMM RD",
        "ID:2013-164-01191",
        "UNIT:FMO12",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-164-01191.,FMO12:CREATED CALL FROM MOBILE");

    doTest("T49",
        "Med - Burns          5930 Beck Rd               SOUTH FORK LN/RUTH LEE DR       654C5    Dept-R136,FMO06,136C   ** 136 Primary Dept ** 55 yo female. burned on arm-face- hands. acad notified[Shared],Invalid address received:1451  TMOBILE-SW SECTOR-QF 621B5.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0184924,Automatic Case Number(s) issued for Lone Oak FD: LOAK-2013-000000251. [Shared],[Appended, 08:35:49] ACADIAN: Unit:    740         10916568 [Shared],[Appen",
        "CALL:Med - Burns",
        "ADDR:5930 Beck Rd",
        "X:SOUTH FORK LN/RUTH LEE DR",
        "MAP:654C5",
        "ID:BCSO-2013-0184924",
        "UNIT:R136,FMO06,136C",
        "INFO:136 Primary Dept - 55 yo female. burned on arm-face- hands. acad notified - TMOBILE-SW SECTOR-QF 621B5.,[Appended, 08:35:49] Unit: 740 - 10916568 ,[Appen");

    doTest("T50",
        "zFMO - Inspection         20005 Liedecke Rd.                                                                                   2013-164-01189       Dept- FMO36 **OUTSIDE BCFA AREA** FMO36:CREATED CALL FROM MOBILE,Final Temp. Trailer inspection.,Automatic Case Number(s) issued for FM Insp: 2013-164-01189.,",
        "CALL:zFMO - Inspection",
        "ADDR:20005 Liedecke Rd",
        "ID:2013-164-01189",
        "UNIT:FMO36",
        "INFO:OUTSIDE BCFA AREA** FMO36:CREATED CALL FROM MOBILE,Final Temp. Trailer inspection");

    doTest("T51",
        "zFMO - Inv Surveillance    LA GARDE ST / GOLIAD RD                      BARKMEYER/GOLIAD RD                                    2013-163-01186       Dept- FMO10 **OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-163-01186.,",
        "CALL:zFMO - Inv Surveillance",
        "ADDR:LA GARDE ST & GOLIAD RD",
        "X:BARKMEYER/GOLIAD RD",
        "ID:2013-163-01186",
        "UNIT:FMO10",
        "INFO:OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE");

    doTest("T52",
        "zFMO - Inspectio      4375 S. Loop 1604                                                                                              2013-163-01184       Dept- FMO36**145 Primary Dept**FMO36:CREATED CALL FROM MOBILE,Final Cement Plant,Automatic Case Number(s) issued for FM Insp: 2013-163-01184.,",
        "CALL:zFMO - Inspectio",
        "ADDR:4375 S Loop 1604",
        "ID:2013-163-01184",
        "UNIT:FMO36",
        "INFO:**145 Primary Dept**FMO36:CREATED CALL FROM MOBILE,Final Cement Plant");

    doTest("T53",
        "zFMO - SELF INIT  622 DOLOROSA                                                                                            2013-163-01181       Dept-FMO14          **103/104 Primary Dept** Automatic Case Number(s) issued for FM Insp: 2013-163-01181.,",
        "CALL:zFMO - SELF INIT",
        "ADDR:622 DOLOROSA",
        "ID:2013-163-01181",
        "UNIT:FMO14",
        "INFO:103/104 Primary Dept** Automatic Case Number(s) issued for FM Insp: 2013-163-01181");

    doTest("T54",
        "zFMO - Inspectio  11203 PECAN CANYON              ROYAL CANYON/MAGIC CANYON       646A4      Dept-FMO10 2013-163-01174           **118/119 Primary Units**FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-163-01174.,",
        "CALL:zFMO - Inspectio",
        "ADDR:11203 PECAN CANYON",
        "X:ROYAL CANYON/MAGIC CANYON",
        "MAP:646A4",
        "UNIT:FMO10",
        "INFO:2013-163-01174 - 118/119 Primary Units**FMO10:CREATED CALL FROM MOBILE");

    doTest("T55",
        "zFMO - Inspection         10742-10951 KOSUB                             PVT RD AT 10786 KOSUB/PVT RD AT 10951 KOSUB            2013-163-01173       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-163-01173.,FMO12:CREATED CALL FROM MOBILE,",
        "CALL:zFMO - Inspection",
        "ADDR:10742-10951 KOSUB",
        "MADDR:10742 KOSUB",
        "X:PVT RD AT 10786 KOSUB/PVT RD AT 10951 KOSUB",
        "ID:2013-163-01173",
        "UNIT:FMO12",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-163-01173.,FMO12:CREATED CALL FROM MOBILE");

    doTest("T56",
        "Fire - Structure  24205 Alpine Lodge                             HEAVENS PEAK/SEVEN WINDS                       483C2     2013-162-0000723     Dept-E139B,E103,Q104,BC103,Q129,C104,E104,R149B,FMO08,104E,129E,1          **103/104 Primary Dept** LIGHTENING HIT HOUSE...ROOF IS ON FIRE[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0183080,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2013-000000781. [Shared],Automatic Case Number(s) issued for Hollywood Park FD: HPK-2013-000000243. [Shared],Automatic Case Number(s) issued for Shavano Park FD: SPK-2013-000000328. [Shared],FG3 [Shared],Backed up E103 with Q104 [Shared],Backed up E103 w",
        "CALL:Fire - Structure",
        "ADDR:24205 Alpine Lodge",
        "X:HEAVENS PEAK/SEVEN WINDS",
        "MAP:483C2",
        "ID:2013-162-0000723",
        "UNIT:E139B,E103,Q104,BC103,Q129,C104,E104,R149B,FMO08,104E,129E,1",
        "INFO:103/104 Primary Dept** LIGHTENING HIT HOUSE...ROOF IS ON FIRE,FG3 ,Backed up E103 with Q104 ,Backed up E103 w");

    doTest("T57",
        "zFMO - Inspection Fire Wa 3201 E HOUSTON                                                                                       2013-162-01172       Dept- FMO30 **OUTSIDE BCFA AREA** FMO30:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-162-01172.,",
        "CALL:zFMO - Inspection Fire Wa",
        "ADDR:3201 E HOUSTON",
        "ID:2013-162-01172",
        "UNIT:FMO30",
        "INFO:OUTSIDE BCFA AREA** FMO30:CREATED CALL FROM MOBILE");

    doTest("T58",
        "zFMO - SELF INITIATED ACT  Wandering                                                                                               2013-162-0000722    Dept-FMO01**Inv Page*FMO01:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Invest: 2013-162-0000722.,",
        "CALL:zFMO - SELF INITIATED ACT",
        "ADDR:Wandering",
        "ID:2013-162-0000722",
        "UNIT:FMO01",
        "INFO:**Inv Page*FMO01:CREATED CALL FROM MOBILE");

    doTest("T59",
        "Fire - Tree / Br  14402 Mangold Way               Dead End/MILES RD               676D7      Dept-B119,130B,B130,E119,FMO10,118B 2013-162-01162           **118/119 Primary Units**PROPERTY ON FIRE BEHIND HER LOCATION[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0182786,Automatic Case Number(s) issued for ESD5 FD: ESD5-2013-000000580. [Shared],Automatic Case Number(s) issued for Jarret FD: JARR-2013-000000311. [Shared],B119  1 ACRE BURN AT THIS TIME [Shared],Mostly Cloudy  NA  HumidityNA  Wind SpeedSE 9 mph  Barometer30.03 in  DewpointNA  Visibility10.00 mi  Last Update on 11 Jun",
        "CALL:Fire - Tree / Br",
        "ADDR:14402 Mangold Way",
        "X:Dead End/MILES RD",
        "MAP:676D7",
        "ID:BCSO-2013-0182786",
        "UNIT:B119,130B,B130,E119,FMO10,118B",
        "INFO:2013-162-01162 - 118/119 Primary Units**PROPERTY ON FIRE BEHIND HER LOCATION,B119  1 ACRE BURN AT THIS TIME ,Mostly Cloudy  NA  HumidityNA  Wind SpeedSE 9 mph  Barometer30.03 in  DewpointNA  Visibility10.00 mi  Last Update on 11 Jun");

    doTest("T60",
        "zFMO - Special Assignment 23954-24152 IH 10 W                           OLD FREDERICKSBURG RD/BOERNE STAGE RD                  2013-162-01161       Dept- FMO10 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-162-01161.,FMO10:CREATED CALL FROM MOBILE,Wash tub,",
        "CALL:zFMO - Special Assignment",
        "ADDR:23954-24152 I 10 W",
        "MADDR:23954 I 10 W",
        "X:OLD FREDERICKSBURG RD/BOERNE STAGE RD",
        "ID:2013-162-01161",
        "UNIT:FMO10",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-162-01161.,FMO10:CREATED CALL FROM MOBILE,Wash tub");

    doTest("T61",
        "zFMO - Inspection         9939 SABLE ARROW                              GEMSBUCK CHASE/GAZELLE FOREST                 578D5    2013-162-01160       Dept- FMO10 **OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-162-01160.,",
        "CALL:zFMO - Inspection",
        "ADDR:9939 SABLE ARROW",
        "X:GEMSBUCK CHASE/GAZELLE FOREST",
        "MAP:578D5",
        "ID:2013-162-01160",
        "UNIT:FMO10",
        "INFO:OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE");

    doTest("T62",
        "zFMO - Investigation Foll  8601 Midcrown                                                                                           2013-162-0000717    Dept-FMO06**Inv Page*FMO06:CREATED CALL FROM MOBILE,Windcrest PD,Automatic Case Number(s) issued for FM Invest: 2013-162-0000717.,",
        "CALL:zFMO - Investigation Foll",
        "ADDR:8601 Midcrown",
        "ID:2013-162-0000717",
        "UNIT:FMO06",
        "INFO:**Inv Page*FMO06:CREATED CALL FROM MOBILE,Windcrest PD");

    doTest("T63",
        "zFMO - Inspection         24911 N SADDLE TRAIL                                                                        NOT FOUN 2013-162-0000716     Dept- FMO01 **OUTSIDE BCFA AREA** FMO01:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Invest: 2013-162-0000716.,",
        "CALL:zFMO - Inspection",
        "ADDR:24911 N SADDLE TRAIL",
        "X:NOT FOUN 2013-162-0000716",
        "UNIT:FMO01",
        "INFO:OUTSIDE BCFA AREA** FMO01:CREATED CALL FROM MOBILE");

    doTest("T64",
        "zFMO - Inspection Followu 100-199 DANIEL RD                             FM 1346/Dead End                                       2013-162-01153       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-162-01153.,",
        "CALL:zFMO - Inspection Followu",
        "ADDR:100-199 DANIEL RD",
        "MADDR:100 DANIEL RD",
        "X:FM 1346/Dead End",
        "ID:2013-162-01153",
        "UNIT:FMO12",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-162-01153");

    doTest("T65",
        "zTEST CALL                203 W Nueva                                   S FLORES ST/S LAREDO ST                       616E5    2013-161-0000715     Dept- FMO44 **OUTSIDE BCFA AREA** TEST CALL ONLY,Automatic Case Number(s) issued for FM Invest: 2013-161-0000715.,",
        "CALL:zTEST CALL",
        "ADDR:203 W Nueva",
        "X:S FLORES ST/S LAREDO ST",
        "MAP:616E5",
        "ID:2013-161-0000715",
        "UNIT:FMO44",
        "INFO:OUTSIDE BCFA AREA** TEST CALL ONLY");

    doTest("T66",
        "zFMO - Special Assignment 3201 E Houston St                                                                                    2013-161-01150       Dept- FMO10 **INSPECTOR PAGE** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-161-01150.,",
        "CALL:zFMO - Special Assignment",
        "ADDR:3201 E Houston St",
        "ID:2013-161-01150",
        "UNIT:FMO10",
        "INFO:INSPECTOR PAGE** FMO10:CREATED CALL FROM MOBILE");

    doTest("T67",
        "zFMO - Investigation      3838 PAVO VIEJO                               MONTE SECO/FAIRLAWN DR                                 2013-161-0000713     Dept- FMO05 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-161-0000713.,FMO05:CREATED CALL FROM MOBILE,",
        "CALL:zFMO - Investigation",
        "ADDR:3838 PAVO VIEJO",
        "X:MONTE SECO/FAIRLAWN DR",
        "ID:2013-161-0000713",
        "UNIT:FMO05",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-161-0000713.,FMO05:CREATED CALL FROM MOBILE");

    doTest("T68",
        "Aircraft Emergen    28102 Old Boerne Stage Rd                                                     446C3       2013-159-0000711     Dept- E134,R132,FMO13,134D **132 Primary Dept** Plane Coming in with no landing gear,Automatic Case Number(s) issued for Leon Springs FD: LSPR-2013-000000519.,Multi-Agency BCLE Incident #: BCSO-2013-0180049,This incident LSPR-2013-0016462 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20130608-ZN16-1453 [Shared],Unit - 741, status change to STATUS_DISPATCHED by ACADIAN at 06/08/2013 18:24:55 [Shared],U",
        "CALL:Aircraft Emergen",
        "ADDR:28102 Old Boerne Stage Rd",
        "MAP:446C3",
        "ID:2013-159-0000711",
        "UNIT:E134,R132,FMO13,134D",
        "INFO:132 Primary Dept** Plane Coming in with no landing gear,Unit - 741,U");

    doTest("T69",
        "zFMO - SERVING WARRANT     10315 margherita hill                                                                                   2013-158-0000710    Dept-FMO07**Inv Page*FMO07:CREATED CALL FROM MOBILE,one in custody,Automatic Case Number(s) issued for FM Invest: 2013-158-0000710.,",
        "CALL:zFMO - SERVING WARRANT",
        "ADDR:10315 margherita hill",
        "ID:2013-158-0000710",
        "UNIT:FMO07",
        "INFO:**Inv Page*FMO07:CREATED CALL FROM MOBILE,one in custody");

    doTest("T70",
        "zFMO - SELF INIT  25080 Us Hwy 281 N                             SENDERO VERDE/WILDERNESS OAK                   451D8     2013-158-01147       Dept-FMO14          **103/104 Primary Dept** Automatic Case Number(s) issued for FM Insp: 2013-158-01147.,",
        "CALL:zFMO - SELF INIT",
        "ADDR:25080 Us Hwy 281 N",
        "MADDR:25080 US 281 N",
        "X:SENDERO VERDE/WILDERNESS OAK",
        "MAP:451D8",
        "ID:2013-158-01147",
        "UNIT:FMO14",
        "INFO:103/104 Primary Dept** Automatic Case Number(s) issued for FM Insp: 2013-158-01147");

    doTest("T71",
        "zFMO - Inspection Followu 4608-4675 BECK RD                             US HWY 87 E/MICHELLE PASS                              2013-158-01146       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01146.,",
        "CALL:zFMO - Inspection Followu",
        "ADDR:4608-4675 BECK RD",
        "MADDR:4608 BECK RD",
        "X:US HWY 87 E/MICHELLE PASS",
        "ID:2013-158-01146",
        "UNIT:FMO12",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01146");

    doTest("T72",
        "zFMO - Inspection         67102 Echanted Eve                                                                          NOT FOUN 2013-158-01145       Dept- FMO14 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01145.,",
        "CALL:zFMO - Inspection",
        "ADDR:67102 Echanted Eve",
        "X:NOT FOUN 2013-158-01145",
        "UNIT:FMO14",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01145");

    doTest("T73",
        "zFMO - Inspection Followu 8400-8448 US HWY 87 E                         TRIPLE TREE DR/KIRKNER RD                              2013-158-01144       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01144.,",
        "CALL:zFMO - Inspection Followu",
        "ADDR:8400-8448 US HWY 87 E",
        "MADDR:8400 US 87 E",
        "X:TRIPLE TREE DR/KIRKNER RD",
        "ID:2013-158-01144",
        "UNIT:FMO12",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01144");

    doTest("T74",
        "zFMO - Inspection Followu 9108-9298 US HWY 87 E                         LOOP 106/MONACO CIR                                    2013-158-01143       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01143.,",
        "CALL:zFMO - Inspection Followu",
        "ADDR:9108-9298 US HWY 87 E",
        "MADDR:9108 US 87 E",
        "X:LOOP 106/MONACO CIR",
        "ID:2013-158-01143",
        "UNIT:FMO12",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01143");

    doTest("T75",
        "zFMO - Inspection Followu 12229-12271 US HWY 181 S                      S FOSTER RD/WESTERN TRAILS                             2013-158-01142       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01142.,",
        "CALL:zFMO - Inspection Followu",
        "ADDR:12229-12271 US HWY 181 S",
        "MADDR:12229 US 181 S",
        "X:S FOSTER RD/WESTERN TRAILS",
        "ID:2013-158-01142",
        "UNIT:FMO12",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01142");

    doTest("T76",
        "zFMO - Inspection         10710 Fm 78                                   NORTH ST/E FM 1518 N                          555C3    2013-158-01140       Dept- FMO14 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01140.,",
        "CALL:zFMO - Inspection",
        "ADDR:10710 Fm 78",
        "X:NORTH ST/E FM 1518 N",
        "MAP:555C3",
        "ID:2013-158-01140",
        "UNIT:FMO14",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01140");

    doTest("T77",
        "zFMO - Inspection Followu 10233-10329 US HWY 181 S                      NB IH 37 S OFRP US HIGHWAY 181/NB IH 37 S OFR          2013-158-01138       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01138.,FMO12:CREATED CALL FROM MOBILE,10236 hwy 11 s.,",
        "CALL:zFMO - Inspection Followu",
        "ADDR:10233-10329 US HWY 181 S",
        "MADDR:10233 US 181 S",
        "X:NB IH 37 S OFRP US HIGHWAY 181/NB IH 37 S OFR",
        "ID:2013-158-01138",
        "UNIT:FMO12",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-158-01138.,FMO12:CREATED CALL FROM MOBILE,10236 hwy 11 s");

    doTest("T78",
        "zFMO - SELF INIT      8811 Waterside                                  BRIDINGTON/HAVEN SIDE                             553D7        2013-158-01137       Dept- FMO14**145 Primary Dept**Automatic Case Number(s) issued for FM Insp: 2013-158-01137.,",
        "CALL:zFMO - SELF INIT",
        "ADDR:8811 Waterside",
        "X:BRIDINGTON/HAVEN SIDE",
        "MAP:553D7",
        "ID:2013-158-01137",
        "UNIT:FMO14",
        "INFO:**145 Primary Dept**Automatic Case Number(s) issued for FM Insp: 2013-158-01137");

    doTest("T79",
        "zFMO - Investigation Foll  622 dolorosa                                                                                            2013-158-0000709    Dept-FMO05**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-158-0000709.,",
        "CALL:zFMO - Investigation Foll",
        "ADDR:622 dolorosa",
        "ID:2013-158-0000709",
        "UNIT:FMO05",
        "INFO:**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-158-0000709");

    doTest("T80",
        "zFMO - Special Assignment 622 DOLOROSA                                  CALDER/S LAREDO ST                            616E5    2013-158-01136       Dept- FMO10 **OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-158-01136.,",
        "CALL:zFMO - Special Assignment",
        "ADDR:622 DOLOROSA",
        "X:CALDER/S LAREDO ST",
        "MAP:616E5",
        "ID:2013-158-01136",
        "UNIT:FMO10",
        "INFO:OUTSIDE BCFA AREA** FMO10:CREATED CALL FROM MOBILE");

    doTest("T81",
        "zFMO - FD Traini  6658 FM 1346                    S FOSTER RD/KIEFER RD                     619D6    2013-157-0000708      Dept-FMO08,FMO07       **120 Primary Dept ** Automatic Case Number(s) issued for FM Invest: 2013-157-0000708.,FMO08:CREATED CALL FROM MOBILE,FACTTS training- Gardendale VFD,",
        "CALL:zFMO - FD Traini",
        "ADDR:6658 FM 1346",
        "X:S FOSTER RD/KIEFER RD",
        "MAP:619D6",
        "ID:2013-157-0000708",
        "UNIT:FMO08,FMO07",
        "INFO:120 Primary Dept - FMO08:CREATED CALL FROM MOBILE,FACTTS training- Gardendale VFD");

    doTest("T82",
        "zFMO - FD Training         6658 E Houston                                                                                          2013-157-0000708    Dept-FMO08**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-157-0000708.,",
        "CALL:zFMO - FD Training",
        "ADDR:6658 E Houston",
        "ID:2013-157-0000708",
        "UNIT:FMO08",
        "INFO:**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-157-0000708");

    doTest("T83",
        "zFMO - SELF INITIATED ACT  2829-2999 ACKERMAN RD                                                                                   2013-157-0000707    Dept-FMO06**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-157-0000707.,",
        "CALL:zFMO - SELF INITIATED ACT",
        "ADDR:2829-2999 ACKERMAN RD",
        "MADDR:2829 ACKERMAN RD",
        "ID:2013-157-0000707",
        "UNIT:FMO06",
        "INFO:**Inv Page*Automatic Case Number(s) issued for FM Invest: 2013-157-0000707");

    doTest("T84",
        "zFMO - Inspection Fire Wa 3201 E HOUSTON                                                                                       2013-157-01135       Dept- FMO30 **INSPECTOR PAGE** FMO30:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-157-01135.,",
        "CALL:zFMO - Inspection Fire Wa",
        "ADDR:3201 E HOUSTON",
        "ID:2013-157-01135",
        "UNIT:FMO30",
        "INFO:INSPECTOR PAGE** FMO30:CREATED CALL FROM MOBILE");

    doTest("T85",
        "zFMO - Inspection Fire Wa SW BEXAR COUNTY                                                                                      2013-157-01132       Dept- FMO30 **INSPECTOR PAGE** Automatic Case Number(s) issued for FM Insp: 2013-157-01132.,",
        "CALL:zFMO - Inspection Fire Wa",
        "ADDR:SW BEXAR COUNTY",
        "ID:2013-157-01132",
        "UNIT:FMO30",
        "INFO:INSPECTOR PAGE** Automatic Case Number(s) issued for FM Insp: 2013-157-01132");

    doTest("T86",
        "zFMO - Inspection         2000-2050 ACAPONETA AVE                       Dead End/ROSA ST                                       2013-157-01131       Dept- FMO12 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-157-01131.,",
        "CALL:zFMO - Inspection",
        "ADDR:2000-2050 ACAPONETA AVE",
        "MADDR:2000 ACAPONETA AVE",
        "X:Dead End/ROSA ST",
        "ID:2013-157-01131",
        "UNIT:FMO12",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Insp: 2013-157-01131");

    doTest("T87",
        "zFMO - Inspection Fire Wa S BEXAR COUNTY                                                                                       2013-157-01130       Dept- FMO30 **INSPECTOR PAGE** Automatic Case Number(s) issued for FM Insp: 2013-157-01130.,",
        "CALL:zFMO - Inspection Fire Wa",
        "ADDR:S BEXAR COUNTY",
        "ID:2013-157-01130",
        "UNIT:FMO30",
        "INFO:INSPECTOR PAGE** Automatic Case Number(s) issued for FM Insp: 2013-157-01130");

    doTest("T88",
        "zFMO - Inspection Fire Wa SE BEXAR COUNTY                                                                                      2013-157-01127       Dept- FMO30 **INSPECTOR PAGE** FMO30:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Insp: 2013-157-01127.,",
        "CALL:zFMO - Inspection Fire Wa",
        "ADDR:SE BEXAR COUNTY",
        "ID:2013-157-01127",
        "UNIT:FMO30",
        "INFO:INSPECTOR PAGE** FMO30:CREATED CALL FROM MOBILE");

    doTest("T89",
        "zFMO - SELF INITIATED ACT 4734-4799 SEGUIN RD                           IH 35 N/BINZ-ENGLEMAN RD                               2013-157-0000705     Dept- FMO06 **OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-157-0000705.,",
        "CALL:zFMO - SELF INITIATED ACT",
        "ADDR:4734-4799 SEGUIN RD",
        "MADDR:4734 SEGUIN RD",
        "X:IH 35 N/BINZ-ENGLEMAN RD",
        "ID:2013-157-0000705",
        "UNIT:FMO06",
        "INFO:OUTSIDE BCFA AREA** Automatic Case Number(s) issued for FM Invest: 2013-157-0000705");

    doTest("T90",
        "Fire - Unauthori  Freudenburg Rd / N Graytown Rd                                       621F1    Dept-B142,FMO08,FMO06,142B **142 Primary** Automatic Case Number(s) issued for St Hedwig FD: SHED-2013-000000157.,POSSIBLE AUTHORIZED BURNING,[Notification] [BCFA]-Problem changed from Smoke in Area to Fire - Unauthorized Burn by BCFA,B142 ADVISED SMALL BURN PILE IN FIELD 30 FT OFF ROADWAY UNATTENDED//WILL BE EXTINGUISHING,Automatic Case Number(s) issued for FM Invest: 2013-157-0000704.,",
        "CALL:Fire - Unauthori",
        "ADDR:Freudenburg Rd & N Graytown Rd",
        "MAP:621F1",
        "ID:SHED-2013-000000157",
        "UNIT:B142,FMO08,FMO06,142B",
        "INFO:POSSIBLE AUTHORIZED BURNING,[Notification] [BCFA]-Problem changed from Smoke in Area to Fire - Unauthorized Burn by BCFA,B142 ADVISED SMALL BURN PILE IN FIELD 30 FT OFF ROADWAY UNATTENDED//WILL BE EXTINGUISHING");

    doTest("T91",
        "zFMO - Inspectio    12414 Alstroemeria                                Dead End/TULIP BEND                              577D4        2013-157-01126        Dept-FMO10    **D2FR Primary Dept** Automatic Case Number(s) issued for FM Insp: 2013-157-01126.,",
        "CALL:zFMO - Inspectio",
        "ADDR:12414 Alstroemeria",
        "X:Dead End/TULIP BEND",
        "MAP:577D4",
        "ID:2013-157-01126",
        "UNIT:FMO10",
        "INFO:D2FR Primary Dept** Automatic Case Number(s) issued for FM Insp: 2013-157-01126");

    doTest("T92",
        "Fire - Vehicle    12440 Us Hwy 181 S         PVT RD AT 12290 US HWY 181 S/MAX RD       685D8     2013-157-0000703      Dept-E127B,FMO08,127D       **127 Primary Dept** [Address:  12440 US HWY 181 S] [High] [Officer Safety] Send at least two Officers to this location regardless of Problem Nature; persons living at location are combative. They have threaten to shoot responders and are anti goverment.,A cellular re-bid has occurred, check the ANI/ALI Viewer for details,A cellular re-bid has occurred, check the ANI/ALI Viewer for details,Automatic Case Number(s) issued for H",
        "CALL:Fire - Vehicle",
        "ADDR:12440 Us Hwy 181 S",
        "MADDR:12440 US 181 S",
        "X:PVT RD AT 12290 US HWY 181 S/MAX RD",
        "MAP:685D8",
        "ID:2013-157-0000703",
        "UNIT:E127B,FMO08,127D",
        "INFO:127 Primary Dept** [Address: 12440 US HWY 181 S] [High] [Officer Safety] Send at least two Officers to this location regardless of Problem Nature; persons living at location are combative. They have threaten to shoot responders and are anti goverment");

    doTest("T93",
        "zFMO - Inspection         24803 BROAD OAK TRAIL                                                                                2013-157-01125       Dept- FMO34 **OUTSIDE BCFA AREA** FMO34:CREATED CALL FROM MOBILE,VHS Final,Automatic Case Number(s) issued for FM Insp: 2013-157-01125.,",
        "CALL:zFMO - Inspection",
        "ADDR:24803 BROAD OAK TRAIL",
        "ID:2013-157-01125",
        "UNIT:FMO34",
        "INFO:OUTSIDE BCFA AREA** FMO34:CREATED CALL FROM MOBILE,VHS Final");

    doTest("T94",
        "MED - ASSAULT     23014 Sandy Forest Dr                          WATERWOOD PASS DR/WATERBROOK DR                752C8     Dept- E162,FMO36,162E  comp 72 yo female has been assaulted by her son/kenneth charles painter...requesting ems[Shared],Multi-Agency BCLE Incident #: BCSO-2013-0176291,subj not at loc right now [Shared],[Notification] [BCLE]-Problem changed from Injured-Sick/ Adult   to Assault   by BCLE [Shared],[Notification] [BCFA]-Problem changed from Med - Sick Person to MED - ASSAULT by BCFA [Shared],Automatic Case Number(s) issued for Ger",
        "CALL:MED - ASSAULT",
        "ADDR:23014 Sandy Forest Dr",
        "X:WATERWOOD PASS DR/WATERBROOK DR",
        "MAP:752C8",
        "ID:BCSO-2013-0176291",
        "UNIT:E162,FMO36,162E",
        "INFO:comp 72 yo female has been assaulted by her son/kenneth charles painter...requesting ems,subj not at loc right now ,[Notification] [BCLE]-Problem changed from Injured-Sick/ Adult - to Assault - by BCLE ,[Notification] [BCFA]-Problem changed from Med - Sick Person to MED - ASSAULT by BCFA");

    doTest("T95",
        "zFMO - Interview - Witnes26749 timberline                                                                                  2013-156-0000702    Dept-FMO07**Inv Check Page*FMO07:CREATED CALL FROM MOBILE,Automatic Case Number(s) issued for FM Invest: 2013-156-0000702.,",
        "CALL:zFMO - Interview - Witnes",
        "ADDR:26749 timberline",
        "ID:2013-156-0000702",
        "UNIT:FMO07",
        "INFO:**Inv Check Page*FMO07:CREATED CALL FROM MOBILE");
   
  }
  
  public static void main(String[] args) {
    new TXBexarCountyParserTest().generateTests("T1");
  }
}
