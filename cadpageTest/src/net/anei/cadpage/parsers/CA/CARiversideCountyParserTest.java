package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Riverside County, CA
Contact: JackPeckham <jackpeckham@idyllwildfire.com>
Sender: messaging@iamresponding.com

MED, TRAFFIC COLLISION; 24630 UPPER RIM ROCK RD ,IDYL ; IFO ADDY SOLO VEH ROLLOVER; 24899 BLK AZALEA RD; 814_F_4/155__98; Inc# 118228; Cmd: RRU SUP 8; Tac: RVC TAC 0; M626; icy roads access from lower way
MED, PERSON DOWN; STN621 @ 54160 MARANATHA DR ,IDYL ; ; 25778 BLK JOHNSON RD; 814_C_6/154__131; Inc# 119114; Cmd: RRU SUP 11; Tac: RVC TAC 0; M625; NO TEXT
MED, PERSON DOWN; 25280 NORWOOD DR ,PINC ; RX TO PRES MEDS; 52100 BLK ACORN LN; 813_H_5/154__116; Inc# 118213; Cmd: RRU SUP 8; Tac: RVC TAC 0; STN23A E23 M624; NO TEXT
MED, FALL; TAHQUITZ CONFERENCE ASSOC @ 55251 S CIRCLE DR ,IDYL ; PT IN PLOT; 25000 BLK JOHN MUIR RD; 814_E_5/155__121; Inc# 118088; Cmd: RRU SUP 11; Tac: RVC TAC 0; STN621A ME621 M624; 659-2934
FMS, ELECTRICAL; 54912 WILDWOOD DR / 54860 S CIRCLE DR ,IDYL ; TREE FALLEN INTO SMALLER TREE; ; 814_E_6/155__133; Inc# 117897; Cmd: RRU SUP 8; Tac: RVC TAC 0; M624; hanging over power lines, not actually touching power lines-
FIRE, COMMERCIAL ALARM; 52500 TEMECULA DR ,IDYL ; IAF-LOWER WAYNE; 52200 BLK CAHUILLA DR; 843_J_1/154__164; Inc# 117832; Cmd: RRU SUP 11; Tac: RVC TAC 5; STN621A ME621 E23; fire alarm , rm #118 premise 951-659-2171
MED, FALL; 54915 S CIRCLE DR ,IDYL ; ILL, HEAD INJ; 54099 BLK MONTGOMERY ST; 814_E_6/155__133; Inc# 117490; Cmd: RRU SUP 11; Tac: RVC TAC 0; SQ621; 951-468-4043
MED, CHILD BIRTH; 52830 PINE COVE RD ,PINC ; ; 25056 BLK MARION RIDGE DR; 813_J_5/154__117; Inc# 117230; Cmd: RRU SUP 8; Tac: RVC TAC 0; STN23A E23 M624; e23 e/r, req amr
MED, FALL; 52735 OAK KNOLL RD ,PINC ; HEAD INJ; 25322 BLK MARION RIDGE DR; 813_J_5/154__117; Inc# 117011; Cmd: RRU SUP 8; Tac: RVC TAC 0; M624; NO TEXT
MED, DIFFICULTY BREATHING; 54310 VALLEY VIEW DR ,IDYL ; ; 26500 BLK PINE AV; 814_D_7/154__156; Inc# 116620; Cmd: RRU SUP 8; Tac: RVC TAC 0; M625; White Jeep in driveway

(Idyllwild Fire) MED, PERSON DOWN; STN621 @ 54160 MARANATHA DR ,IDYL ; WALK IN; 25778 BLKJOHNSON RD; 814_C_6/154__131; Inc# 038248; Cmd: RVC CMD 8; Tac: RVC TAC 0;M625 STN621A; NO TEXT)
(Idyllwild Fire) FIRE, COMMERCIAL ALARM; 25980 HY 243 ,IDYL ; ARRIBAS RESTERAUNT  ZONE 11;54000 BLK NORTH CIRCLE DR; 814_C_6/154__144; Inc# 038171; Cmd: RVC CMD 8;Tac: RVC TAC 2; ME621 MT621 STN621A; premise 951 659 4960
(Idyllwild Fire) MED, TRAUMA; 54635 NORTH CIRCLE DR ,IDYL ; ; 25730 BLK FIR ST;814_D_6/154__132; Inc# 038046; Cmd: RVC CMD 8; Tac: RVC TAC 0; MT621; name -mary\npain in arm\nDispatch  30A02\nYou are responding to a patient with specifically identified traumaticinjuries.  The patient is a 78-year-old female, who is conscious andbreathing.  NON-RECENT (=&gt; 6hrs) injuries (without priority symptoms).
(Idyllwild Fire) PA, PERSON; 54160 MARANATHA DR ,IDYL (STN621); ; 25778 BLK JOHNSON RD;814_C_6/154__131; Inc# 038010; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; bloodpressure check
(Idyllwild Fire) FIRE, COMMERCIAL ALARM; 52500 TEMECULA DR ,IDYL ; IAF PIERCE DORM; 52200 BLKCAHUILLA DR; 843_J_1/154__164; Inc# 037704; Cmd: RVC CMD 8; Tac: RVC TAC 6;M625; gen fire  zone 62  ph/  9516592171room 715 smoke
(Idyllwild Fire) MED, PERSON DOWN; STN621 @ 54160 MARANATHA DR ,IDYL ; CVA, M625 COMMITTED;25778 BLK JOHNSON RD; 814_C_6/154__131; Inc# 037452; Cmd: RVC CMD 8; Tac:RVC TAC 0; M625; NO TEXT
(Idyllwild Fire) MED, OVERDOSE; 26650 FAIRWAY DR ,IDYL ; RSO E/R; 54330 BLK LIVE OAK ST;844_D_1/154__168; Inc# 036980; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625 ME621STN621A; Dispatch  23C01       non combative pt with family o/s  You are responding to a patient who has apparently overdosed/been  poisoned.The patient is a 36-year-old male, who is conscious and  breathing. Notalert  (Intentional Overdose).  1.He is not violent.  2.He does not have aweapon.  3.The patient is inside the same structure.  ^    4.He attemptedsuicide by an overdose. (Change from Protocol #25)  5.This was intentional.6.He is not violent.  -Comments: xanax, sleeping pills and alcohol-
(Idyllwild Fire) FIRE, UNKNOWN TYPE; 54125 PINE CREST AV ,IDYL ; 54125 LOWER PINECREST; 54271BLK MARANATHA DR; 814_C_6/154__143; Inc# 036716; Cmd: RVC CMD 8; Tac: RVCTAC 1; M625; rp sees gry some next to him
(Idyllwild Fire) MED, ASSAULT; 26290 HY 243 ,IDYL ; RSO ENRT ***STAGE; 54199 BLK COUNTY PARKRD; 814_C_7/154__143; Inc# 036554; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625MT621 STN621A; cabin tro restaurant - bleeding from arm    nfi\nDispatch  04B03\nYou are responding to patients who have been assaulted/sexually  assaulted.(If known -- relay pertinent patient-specific information.)  Unknownstatus/Other codes not applicable  (Assault).  Unknown number of patientsinvolved.  3.The location of the assailant is not known.  4.It's not knownif the assailant is armed.
(Idyllwild Fire) MED, PERSON DOWN; 22901 EAGLE NEST TRL ,PINC ; UNIT B (2ND HOUSE ONPROPERTY); 22900 BLK AZALEA TRAILS RD; 813_H_1/154__44; Inc# 036065; Cmd:RVC CMD 8; Tac: RVC TAC 0; E23 M625 STN23A; Dispatch  05A02\nYou are responding to a patient with non-traumatic back pain.  The patientis  a 54-year-old female, who is conscious and breathing. NON-RECENT (=&gt;6hrs) traumatic back pain (without priority symptoms).  -Comments: sharp andneck unstable-
(Idyllwild Fire) MED, BLEEDING; 54618 REED LN ,IDYL ; ; 54650 BLK MARIAN VIEW DR;814_D_7/154__156; Inc# 035784; Cmd: RVC CMD 8; Tac: RVC TAC 0; SQ621; femalecut herself on glass washing dishes\nDispatch  21B02\nYou are responding to a patient who is hemorrhaging.  The patient is a23-year-old female, who is conscious and breathing. SERIOUS  hemorrhage.5.There is blood spurting or pouring out (after dispatch, go to ControlBleeding in DLS Links).
(Idyllwild Fire) OTH, COVER; HY 243 / 53650 HY 74 E ,MOUN ; AMR REQ 621 COVER ANZA; ;844_B_5/183__47; Inc# 035439; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625 STN53A;NO TEXT
(Idyllwild Fire) MED, TC OVER THE SIDE; MP 74-54 @ =L(33.708848,-116.761452) ,MOUN ; ;  ;843_G_4/183__43; Inc# 035098; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; vehiclehad poss rolled over a couple times, female pt on the side of the roadwaving down traffic, unk if any other parties are trapped in the vehicle\nDispatch  29B04  \nYou are responding to patients involved in a traffic incident.  (If known --relay  pertinent patient-specific information.) Unknown status/Other codesnot  applicable  (Unknown number of patients).  Unknown number of patientsinvolved.  3.Chemicals or other hazards are not involved.
(Idyllwild Fire) MED, FALL; 54245 NORTH CIRCLE DR ,IDYL ; IFO IDYLLWILD COFFEE; 54200 BLKPARK LN; 814_D_6/154__144; Inc# 035049; Cmd: RVC CMD 8; Tac: RVC TAC 0;C6200; Dispatch  17B01  \nYou are responding to a patient involved in a fall.  The patient is a69-year-old  female, who is conscious and breathing. POSSIBLY DANGEROUS bodyarea.
(Idyllwild Fire) MED, FALL; 54245 NORTH CIRCLE DR ,IDYL ; IFO IDYLLWILD COFFEE; 54200 BLKPARK LN; 814_D_6/154__144; Inc# 035049; Cmd: RVC CMD 8; Tac: RVC TAC 0; M624ME621 STN621A; Dispatch  17B01  \nYou are responding to a patient involved in a fall.  The patient is a69-year-old  female, who is conscious and breathing. POSSIBLY DANGEROUS bodyarea.
(Idyllwild Fire) MED, FAINTED / PASSED OUT; 52070 ACORN LN ,PINC ; ; 25400 BLK NORWOOD DR;813_H_5/154__116; Inc# 035036; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625;\nDispatch  26A03  \nYou are responding to a patient who is sick (or has a current medicalcondition).  The patient is a 76-year-old male, who is conscious andbreathing.  Dizziness/vertigo.
(Idyllwild Fire) MED, FAINTED / PASSED OUT; 52070 ACORN LN ,PINC ; ; 25400 BLK NORWOOD DR;813_H_5/154__116; Inc# 035036; Cmd: RVC CMD 8; Tac: RVC TAC 0; E23 M624STN23A; Dispatch  26A03  \nYou are responding to a patient who is sick (or has a current medicalcondition).  The patient is a 76-year-old male, who is conscious andbreathing.  Dizziness/vertigo.
(Idyllwild Fire) MED, PERSON DOWN; 52500 TEMECULA DR ,IDYL ; IDYLLWILD ARTS ACADEMY - HEALTHCENTER; 52200 BLK CAHUILLA DR; 843_J_1/154__164; Inc# 034973; Cmd: RVC CMD8; Tac: RVC TAC 0; SQ621; ext  2275\nDispatch  26A10  \nYou are responding to a patient who is sick (or has a current medicalcondition).  The patient is a 65-year-old male, who is conscious andbreathing.  Unwell/ill.  -Comments: arm and hand pain-
(Idyllwild Fire) MED, FALL; 26800 SAUNDERS MEADOW RD ,IDYL (ASTRO CAMP); PT LOC IN FIRST AIDOFFICE; 26400 BLK CLUB HOUSE DR; 844_D_1/154__168; Inc# 034932; Cmd: RVC CMD8; Tac: RVC TAC 0; MT621; Dispatch  17B01  \nYou are responding to a patient involved in a fall.  The patient is a11-year-old  male, who is conscious and breathing. POSSIBLY DANGEROUS bodyarea.
(Idyllwild Fire) FIRE, DEBRIS; 54375 TAHQUITZ VIEW DR ,IDYL ; RSO E/R; 26600 BLK PINE AV;814_D_7/154__168; Inc# 034466; Cmd: RVC CMD 8; Tac: RVC TAC 0; MT621; rsoe/r for noise complaint     bon fire/ill burn
(Idyllwild Fire) MED, PERSON DOWN; 54276 NORTH CIRCLE DR / 54200 VILLAGE CENTER DR ,IDYL ;MT621 M625; ; 814_D_6/154__144; Inc# 034279; Cmd: RVC CMD 8; Tac: RVC TAC 0;M625 MT621 STN621A; NO TEXT
(Idyllwild Fire) OTH, COVER; HY 243 / 53650 HY 74 E ,MOUN ; REQ IDY TO COVER ANZA; ;844_B_5/183__47; Inc# 033942; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625 STN53A;NO TEXT
(Idyllwild Fire) MED, SEIZURES; 26350 DELANO DR #27 ,IDYL (ROYAL PINES ESTATES MHP); ; 53499BLK FOUR CHIMNEYS RD; 814_B_7/154__154; Inc# 033700; Cmd: RVC CMD 8; Tac:RVC TAC 0; STN621A ME621 M625; Descr: SEIZURE   Pat Cnt: 1  Age: UnknownRange  Sex: Unknown  Con: Unknown  Breath: Unknown  Resp Script: You areresponding to a patient who has had a seizure.  The patient is of unknownage and gender, whose consciousness and breathing is unknown.  Effectivebreathing not verified =&gt; 35.
(Idyllwild Fire) MED, CHEST PAINS; 52625 DOUBLE VIEW DR ,IDYL ; ; 53099 BLK INSPIRATION LN;843_J_2/154__177; Inc# 033346; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN621A ME621M625; Descr: heart issues  Pat Cnt: 1  Age: 45  Years  Sex: Male  Con: YesBreath: Yes  Resp Script: You are responding to a patient with heartproblems.  The patient is a  45-year-old male, who is conscious andbreathing. Clammy.
(Idyllwild Fire) MED, UNRESP &amp; BREATHING; 23440 HY 243 ,PINC ; ; 25500 BLK SUNRISE DR;814_A_5/154__117; Inc# 033250; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN23A E23M625; Descr: fell  Pat Cnt: 1  Age: 79  Years  Sex: Female  Con: YesBreath: Yes  Resp Script: You are responding to a patient who is unconscious(or has fainted).  The patient  is a 79-year-old female, who is consciousand breathing. Not alert.
(Idyllwild Fire) FIRE, RESIDENTIAL; 54450 VILLAGE VIEW DR ,IDYL ; ACROSS FROM ADDY;DEAD-END; 814_D_7/154__156; Inc# 033071; Cmd: RVC CMD 8; Tac: RVC TAC 6;M625; house fully engulfed in flames per rp
(Idyllwild Fire) MED, PERSON DOWN; 53375 IDYLLBROOK DR ,IDYL ; PWC,  CAROL     POSS 5150;26550 BLK DELANO DR; 844_B_1/154__166; Inc# 033078; Cmd: RVC CMD 8; Tac: RVCTAC 0; M624; Descr: lost your mind  Pat Cnt: 1  Age: 81  Years  Sex: FemaleCon: Yes  Breath: Yes  Resp Script: You are responding to a patient who hasabnormal or suicidal behavior.  The patient is a 81-year-old female, who isconscious and breathing.  Non-suicidal and alert.  1.She is not violent.2.She does not have a weapon.  3.Her exact position is: sitting in thekitchen  4.This is not a suicide attempt.  -Comments: sitting in thekitchen-  
(Idyllwild Fire) FIRE, RESIDENTIAL; 54450 VILLAGE VIEW DR ,IDYL ; ACROSS FROM ADDY;DEAD-END; 814_D_7/154__156; Inc# 033071; Cmd: RVC CMD 8; Tac: RVC TAC 6;C6200; house fully engulfed in flames per rp
(Idyllwild Fire) MED, TRAFFIC COLLISION; VISTA POINT (HY 243) @ 51750 HY 243 ,PINC ; ;  BLACKMOUNTAIN TRL; 783_G_6/154__19; Inc# 033055; Cmd: RVC CMD 8; Tac: RVC TAC 0;STN23A E23 M625; JUST BELOW VISTA POINT , NEAR THE TURN-OUT , VEH INTO THESIDE OF MTN , UNK DIRECTION OF TRAVEL...MULT VEHS PULLED OVER ATTEMPTING TOASSISTDescr: Traffic / Transportation Incidents  Pat Cnt: 255  Age: Unknown  RangeSex: Unknown  Con: Unknown  Breath: Unknown  Resp Script: You are respondingto patients involved in a traffic incident.  (If known -- relay  pertinentpatient-specific information.) Unknown status/Other codes not  applicable(Unknown number of patients).  Unknown number of patients involved.  3.It'snot known if chemicals or other hazards are involved.
(Idyllwild Fire) MED, UNRESP &amp; BREATHING; 52315 SYLVAN WY ,PINC ; ; 23199 BLK OAK LEAFLN; 813_H_5/154__116; Inc# 032045; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN23AE23 M625; Descr: PASSED OUT NOW   Pat Cnt: 1  Age: 14  Years  Sex: FemaleCon: Yes  Breath: Yes  Resp Script: You are responding to a patient who issick (or has a current medical condition).  The patient is a 14-year-oldfemale, who is conscious and breathing. Not  alert.
(Idyllwild Fire) MED, BITES OR STINGS; 53261 DEER FOOT LN ,IDYL ; ; 53350 BLK DOUBLE VIEW DR;844_A_2/154__178; Inc# 031552; Cmd: RVC CMD 8; Tac: RVC TAC 0; M626; name -joanDescr: allergic rxn   Pat Cnt: 1  Age: 61  Years  Sex: Female  Con: YesBreath: Yes  Resp Script: You are responding to a patient with an allergicreaction/envenomation  (sting, bite).  The patient is a 61-year-old female,who is conscious and  breathing. DIFFICULTY SPEAKING BETWEEN BREATHS.
(Idyllwild Fire) MED, TRAUMA; 25465 MANZANITA DR ,IDYL ; MINISTERS HOUSE AT CHURCH OFIDYLLWILD; 25526 BLK HY 243; 814_C_5/154__131; Inc# 031544; Cmd: RVC CMD 8;Tac: RVC TAC 0; STN621A M625 ME621; 6592364 fell earlier  bit lip  hasstitchesDescr: trauma  Pat Cnt: 1  Age: 87  Years  Sex: Female  Con: Yes  Breath:Yes  Resp Script: You are responding to a patient with specificallyidentified traumatic injuries.  The patient is a 87-year-old female, who isconscious and breathing.  SERIOUS hemorrhage.Descr: trauma  Pat Cnt: 1  Age: 87  Years  Sex: Female  Con: Yes  Breath:Yes  Resp Script: SERIOUS hemorrhage.
(Idyllwild Fire) FMS, GAS; 54750 NORTH CIRCLE DR ,IDYL ; E621 M625, SMELL OF GAS; 55799 BLK SCIRCLE DR; 814_D_5/154__132; Inc# 031463; Cmd: RVC CMD 8; Tac: RVC TAC 0;STN621A ME621 M625; NO TEXT
(Idyllwild Fire) MED, CHEST PAINS; 54165 PINE CREST AV ,IDYL ; IDYLLWILD HEALTH CENTER,;54271 BLK MARANATHA DR; 814_C_6/154__143; Inc# 031392; Cmd: RVC CMD 8; Tac:RVC TAC 0; M626; Descr: cp  Pat Cnt: 1  Age: 97  Years  Sex: Female  Con:Yes  Breath: Yes  Resp Script: You are responding to a patient with chestpain.  The patient is a 97-year-old  female, who is conscious and breathing.Clammy.
(Idyllwild Fire) MED, PERSON DOWN; 25726 ALDERWOOD ST / 54550 NORTH CIRCLE DR ,IDYL ; 26990ALDERWOOD; ; 814_D_6/154__132; Inc# 031369; Cmd: RVC CMD 8; Tac: RVC TAC 0;STN621A ME621 M625; Descr: sick  Pat Cnt: 1  Age: 50  Years  Sex: FemaleCon: Yes  Breath: Yes  Resp Script: You are responding to a patient withnon-traumatic back pain.  The patient is  a 50-year-old female, who isconscious and breathing. NON-TRAUMATIC  -Comments: back-  -Comments: 9-10-
(Idyllwild Fire) MED, UNCONSCIOUS / UNRESP; 54144 LINGER LN ,IDYL ; UNATTENDED, RSO E/R;26600 BLK HIDE A LN; 844_C_1/154__167; Inc# 031011; Cmd: RVC CMD 8; Tac: RVCTAC 0; M625; NO TEXT
(Idyllwild Fire) MED, FAINTED / PASSED OUT; 54400 NORTH CIRCLE DR ,IDYL ; IFO IDYL COMMPRESBYTERIAN CHURCH; 25800 BLK OAKWOOD ST; 814_D_6/154__144; Inc# 030701;Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; Descr: collapsed   Pat Cnt: 1  Age: 92Years  Sex: Male  Con: Yes  Breath: Yes  Resp Script: You are responding toa patient who is unconscious (or has fainted).  The patient  is a92-year-old male, who is conscious and breathing. Fainting  episode(s) andalert =&gt; 35 (without cardiac history).  
(Idyllwild Fire) MED, DIFFICULTY BREATHING; 25050 CASCADE DR ,PINC ; ; 25199 BLK ROSA WY;814_A_5/154__118; Inc# 030606; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; Descr:DB, ILL  Pat Cnt: 1  Age: 65  Years  Sex: Female  Con: Yes  Breath: YesResp Script: You are responding to a patient with breathing problems.  Thepatient is a  65-year-old female, who is conscious and breathing. DIFFICULTYSPEAKING BETWEEN BREATHS.
(Idyllwild Fire) MED, PERSON DOWN; STN621 @ 54160 MARANATHA DR ,IDYL ; ; 25778 BLK JOHNSONRD; 814_C_6/154__131; Inc# 030054; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; NOTEXT
(Idyllwild Fire) MED, ALTERED LOC; LAKE HEMET CAMPGROUND @ 56570 HY 74 E ,ANZA ; SP 133;THOMAS MOUNTAIN RD; 874_H_2/184__111; Inc# 029957; Cmd: RVC CMD 8; Tac: RVCTAC 0; E621; Descr: man laying on ground  Pat Cnt: 1  Age: 77  Years  Sex:Male  Con: Yes  Breath: Yes  Resp Script: You are responding to a patientwho is sick (or has a current medical condition).  The patient is a77-year-old male, who is conscious and breathing.  ALTERED LEVEL OFCONSCIOUSNESS.
(Idyllwild Fire) OTH, COVER; HY 243 / 53650 HY 74 E ,MOUN ; COVERAGE FOR AMR; ;936_A_2/213__168; Inc# 029701; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; NO TEXT
(Idyllwild Fire) OTH, COVER; 61700 HY 371 / 61750 HY 74 E ,ANZA ; COVERAGE FOR AMR; ;936_A_2/213__168; Inc# 029701; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN53ASTN621A M624; NO TEXT
(Idyllwild Fire) MED, DIABETIC; 26140 CRESTVIEW DR ,IDYL ; ; 26400 BLK FOREST HILL DR;814_D_7/154__156; Inc# 029609; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; Descr:blurry vision/ weak  Pat Cnt: 1  Age: 57  Years  Sex: Male  Con: YesBreath: Yes  Resp Script: You are responding to a patient with diabeticproblems.  The patient is a  57-year-old male, who is conscious andbreathing. Alert and behaving  normally.
(Idyllwild Fire) MED, PERSON DOWN; STN621 @ 54160 MARANATHA DR ,IDYL ; WALK IN; 25778 BLKJOHNSON RD; 814_C_6/154__131; Inc# 029400; Cmd: RVC CMD 8; Tac: RVC TAC 0;STN621A M625; NO TEXT
(Idyllwild Fire) MED, SEIZURES; 54360 MARIAN VIEW DR ,IDYL ; AMERICAN LEGION POST 800; 26000BLK CRESTVIEW DR; 814_D_7/154__156; Inc# 029359; Cmd: RVC CMD 8; Tac: RVCTAC 0; SQ621; Descr: SEIZURE  Pat Cnt: 1  Age: 60  Years  Sex: Male  Con:Unknown  Breath: Yes  Resp Script: You are responding to a patient who hashad a seizure.  The patient is a  60-year-old male, who is breathing andwhose consciousness is  unknown. Effective breathing not verified =&gt; 35.
(Idyllwild Fire) MED, BLOOD PRESSURE; 25080 FERN VALLEY RD ,IDYL ; ; 25199 BLK MCGRATH RD;814_E_4/155__109; Inc# 029329; Cmd: RVC CMD 8; Tac: RVC TAC 0; C6200;PREMISE 951 659 4139 PATRICIADescr: HIGH BP  Pat Cnt: 1  Age: 87  Years  Sex: Female  Con: Yes  Breath:Yes  Resp Script: You are responding to a patient who is sick (or has acurrent medical condition).  The patient is a 87-year-old female, who isconscious and breathing.  Blood pressure abnormality (asymptomatic).
(Idyllwild Fire) MED, PERSON DOWN; 54910 PINE CREST AV ,IDYL (IDYLLWILD HEALTH CLINIC); FERNCREEK MEDICAL CENTER; 55799 BLK S CIRCLE DR; 814_D_5/154__132; Inc# 029304;Cmd: RVC CMD 8; Tac: RVC TAC 0; STN621A ME621 M625; Descr: chest pain  PatCnt: 1  Age: 84  Years  Sex: Female  Con: Yes  Breath: Yes  Resp Script: Youare responding to a patient transfer or medical care facility situation.The patient is a 84-year-old female, who is conscious and breathing.Emergency response requested  (Transfer).
(Idyllwild Fire) MED, CHEST PAINS; 25205 LODGE RD ,IDYL ; ; 55022 BLK SAN JACINTO RD;814_E_5/155__109; Inc# 028586; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN621A ME621M625; Descr: chest pains  Pat Cnt: 1  Age: 31  Years  Sex: Female  Con: YesBreath: Yes  Resp Script: You are responding to a patient with chest pain.The patient is a 31-year-old  female, who is conscious and breathing.DIFFICULTY SPEAKING BETWEEN  BREATHS.
(Idyllwild Fire) FIRE, RESIDENTIAL; STN30 @ 70080 HY 74 E ,ANZA ; 1/2 MILE   LOOKING NORTHOFF HWY; 70353 BLK SCENIC DR; 907_H_6/215__123; Inc# 027496; Cmd: RVC CMD 8;Tac: RVC TAC 6; STN30B E3162 E33 E67 B12B E23 E3169 BR621; 8 miles west ofstn30 ...black smoke  ..rp is a local and doesnt believe its idyllwild thathes seeing ..
(Idyllwild Fire) MED, UNCONSCIOUS / UNRESP; 54563 MARIAN VIEW DR ,IDYL ; RSO E/R; 54600 BLKLOOKOUT RD; 814_D_7/154__156; Inc# 027443; Cmd: RVC CMD 8; Tac: RVC TAC 0;ME621 M625; armandoFound by house clearner,, stiff and purple,, has been illDescr: Poss unattended  Pat Cnt: 1  Age: 82  Years  Sex: Male  Con: NoBreath: No  Resp Script: You are responding to a patient in apparent cardiac(respiratory) arrest.  The  patient is a 82-year-old male, who isunconscious and not breathing.  Not breathing at all.
(Idyllwild Fire) MED, RINGING ALARM; 54565 MARIAN VIEW DR ,IDYL ; ; 54600 BLK LOOKOUT RD;814_D_7/154__156; Inc# 027463; Cmd: RVC CMD 8; Tac: RVC TAC 0; ME621 M625;prem -- 951-468-4026no contact by alarm co Descr: Unknown Problem (Man Down)  Pat Cnt: 1  Age: Unknown  Range  Sex:Unknown  Con: Unknown  Breath: Unknown  Resp Script: You are responding to apatient with an unknown problem (man down).  The  patient is of unknown ageand gender, whose consciousness and breathing  is unknown. Medical Alarm(Alert) notifications (no patient information).  -Comments: as dispatched-
(Idyllwild Fire) MED, UNCONSCIOUS / UNRESP; 54563 MARIAN VIEW DR ,IDYL ; ; 54600 BLK LOOKOUTRD; 814_D_7/154__156; Inc# 027443; Cmd: RVC CMD 8; Tac: RVC TAC 0; BR621;armandoFound by house clearner,, stiff and purple,, has been illDescr: Poss unattended  Pat Cnt: 1  Age: 82  Years  Sex: Male  Con: NoBreath: No  Resp Script: You are responding to a patient in apparent cardiac(respiratory) arrest.  The  patient is a 82-year-old male, who isunconscious and not breathing.  Not breathing at all.
(Idyllwild Fire) FIRE, COMMERCIAL ALARM; 26700 HY 243 ,IDYL (IDYLLWILD ELEMENTARY SCH); ZONE1; 53999 BLK TOLL GATE RD; 814_C_7/154__155; Inc# 027381; Cmd: RVC CMD 8;Tac: RVC TAC 2; STN621A ME621 E23; NO TEXT
(Idyllwild Fire) FMS, GAS; 53145 DOUBLE VIEW DR ,IDYL ; ; 26999 BLK MEADOW GLEN DR;844_A_1/154__178; Inc# 027148; Cmd: RVC CMD 8; Tac: RVC TAC 0; SQ621; NOTEXT
(Idyllwild Fire) OTH, COVER; 53650 HY 74 E AT   HY 243 ,MOUN ; MEDIC COVERAGE; ;936_A_2/213__168; Inc# 026558; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN53A M625;NO TEXT
(Idyllwild Fire) MED, UNRESP &amp; BREATHING; 53230 DOUBLE VIEW DR ,IDYL ; LOW; 26999 BLKMEADOW GLEN DR; 844_A_1/154__178; Inc# 026473; Cmd: RVC CMD 8; Tac: RVC TAC0; SQ621; rp - DuraDescr: low bp   Pat Cnt: 1  Age: 63  Years  Sex: Male  Con: No  Breath: YesResp Script: You are responding to a patient with an unknown problem (mandown).  The  patient is a 63-year-old male, who is unconscious andbreathing. LIFE  STATUS QUESTIONABLE.
(Idyllwild Fire) MED, PERSON DOWN; 53230 DOUBLE VIEW DR ,IDYL ; LOW; 26999 BLK MEADOW GLENDR; 844_A_1/154__178; Inc# 026473; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN621AME621 M625; rp - DuraDescr: low bp   Pat Cnt: 1  Age: 63  Years  Sex: Male  Con: No  Breath: YesResp Script: You are responding to a patient with an unknown problem (mandown).  The  patient is a 63-year-old male, who is unconscious andbreathing. LIFE  STATUS QUESTIONABLE.
(Idyllwild Fire) MED, FALL; 54716 NORTH CIRCLE DR ,IDYL ; ; 54999 BLK RIVER DR; 814_D_6/154__132; Inc# 038397; Cmd: RVC CMD 8; Tac: RVC TAC 0; MT621; ba

 */

public class CARiversideCountyParserTest extends BaseParserTest {
  
  public CARiversideCountyParserTest() {
    setParser(new CARiversideCountyParser(), "RIVERSIDE COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MED, TRAFFIC COLLISION; 24630 UPPER RIM ROCK RD ,IDYL ; IFO ADDY SOLO VEH ROLLOVER; 24899 BLK AZALEA RD; 814_F_4/155__98; Inc# 118228; Cmd: RRU SUP 8; Tac: RVC TAC 0; M626; icy roads access from lower way",
        "CALL:MED, TRAFFIC COLLISION",
        "ADDR:24630 UPPER RIM ROCK RD",
        "CITY:IDYLLWILD",
        "INFO:IFO ADDY SOLO VEH ROLLOVER / icy roads access from lower way",
        "X:24899 BLK AZALEA RD",
        "MAP:814_F_4/155__98",
        "ID:118228",
        "SRC:RRU SUP 8",
        "CH:RVC TAC 0",
        "UNIT:M626");

    doTest("T2",
        "MED, PERSON DOWN; STN621 @ 54160 MARANATHA DR ,IDYL ; ; 25778 BLK JOHNSON RD; 814_C_6/154__131; Inc# 119114; Cmd: RRU SUP 11; Tac: RVC TAC 0; M625; NO TEXT",
        "CALL:MED, PERSON DOWN",
        "PLACE:STN621",
        "ADDR:54160 MARANATHA DR",
        "CITY:IDYLLWILD",
        "INFO:NO TEXT",
        "X:25778 BLK JOHNSON RD",
        "MAP:814_C_6/154__131",
        "ID:119114",
        "SRC:RRU SUP 11",
        "CH:RVC TAC 0",
        "UNIT:M625");

    doTest("T3",
        "MED, PERSON DOWN; 25280 NORWOOD DR ,PINC ; RX TO PRES MEDS; 52100 BLK ACORN LN; 813_H_5/154__116; Inc# 118213; Cmd: RRU SUP 8; Tac: RVC TAC 0; STN23A E23 M624; NO TEXT",
        "CALL:MED, PERSON DOWN",
        "ADDR:25280 NORWOOD DR",
        "CITY:PINE COVE",
        "INFO:RX TO PRES MEDS / NO TEXT",
        "X:52100 BLK ACORN LN",
        "MAP:813_H_5/154__116",
        "ID:118213",
        "SRC:RRU SUP 8",
        "CH:RVC TAC 0",
        "UNIT:STN23A E23 M624");

    doTest("T4",
        "MED, FALL; TAHQUITZ CONFERENCE ASSOC @ 55251 S CIRCLE DR ,IDYL ; PT IN PLOT; 25000 BLK JOHN MUIR RD; 814_E_5/155__121; Inc# 118088; Cmd: RRU SUP 11; Tac: RVC TAC 0; STN621A ME621 M624; 659-2934",
        "CALL:MED, FALL",
        "PLACE:TAHQUITZ CONFERENCE ASSOC",
        "ADDR:55251 S CIRCLE DR",
        "CITY:IDYLLWILD",
        "INFO:PT IN PLOT / 659-2934",
        "X:25000 BLK JOHN MUIR RD",
        "MAP:814_E_5/155__121",
        "ID:118088",
        "SRC:RRU SUP 11",
        "CH:RVC TAC 0",
        "UNIT:STN621A ME621 M624");

    doTest("T5",
        "FMS, ELECTRICAL; 54912 WILDWOOD DR / 54860 S CIRCLE DR ,IDYL ; TREE FALLEN INTO SMALLER TREE; ; 814_E_6/155__133; Inc# 117897; Cmd: RRU SUP 8; Tac: RVC TAC 0; M624; hanging over power lines, not actually touching power lines-",
        "CALL:FMS, ELECTRICAL",
        "ADDR:54912 WILDWOOD DR & 54860 S CIRCLE DR",
        "MADDR:54912 WILDWOOD DR",
        "CITY:IDYLLWILD",
        "INFO:TREE FALLEN INTO SMALLER TREE / hanging over power lines, not actually touching power lines-",
        "MAP:814_E_6/155__133",
        "ID:117897",
        "SRC:RRU SUP 8",
        "CH:RVC TAC 0",
        "UNIT:M624");

    doTest("T6",
        "FIRE, COMMERCIAL ALARM; 52500 TEMECULA DR ,IDYL ; IAF-LOWER WAYNE; 52200 BLK CAHUILLA DR; 843_J_1/154__164; Inc# 117832; Cmd: RRU SUP 11; Tac: RVC TAC 5; STN621A ME621 E23; fire alarm , rm #118 premise 951-659-2171",
        "CALL:FIRE, COMMERCIAL ALARM",
        "ADDR:52500 TEMECULA DR",
        "CITY:IDYLLWILD",
        "INFO:IAF-LOWER WAYNE / fire alarm , rm #118 premise 951-659-2171",
        "X:52200 BLK CAHUILLA DR",
        "MAP:843_J_1/154__164",
        "ID:117832",
        "SRC:RRU SUP 11",
        "CH:RVC TAC 5",
        "UNIT:STN621A ME621 E23");

    doTest("T7",
        "MED, FALL; 54915 S CIRCLE DR ,IDYL ; ILL, HEAD INJ; 54099 BLK MONTGOMERY ST; 814_E_6/155__133; Inc# 117490; Cmd: RRU SUP 11; Tac: RVC TAC 0; SQ621; 951-468-4043",
        "CALL:MED, FALL",
        "ADDR:54915 S CIRCLE DR",
        "CITY:IDYLLWILD",
        "INFO:ILL, HEAD INJ / 951-468-4043",
        "X:54099 BLK MONTGOMERY ST",
        "MAP:814_E_6/155__133",
        "ID:117490",
        "SRC:RRU SUP 11",
        "CH:RVC TAC 0",
        "UNIT:SQ621");

    doTest("T8",
        "MED, CHILD BIRTH; 52830 PINE COVE RD ,PINC ; ; 25056 BLK MARION RIDGE DR; 813_J_5/154__117; Inc# 117230; Cmd: RRU SUP 8; Tac: RVC TAC 0; STN23A E23 M624; e23 e/r, req amr",
        "CALL:MED, CHILD BIRTH",
        "ADDR:52830 PINE COVE RD",
        "CITY:PINE COVE",
        "INFO:e23 e/r, req amr",
        "X:25056 BLK MARION RIDGE DR",
        "MAP:813_J_5/154__117",
        "ID:117230",
        "SRC:RRU SUP 8",
        "CH:RVC TAC 0",
        "UNIT:STN23A E23 M624");

    doTest("T9",
        "MED, FALL; 52735 OAK KNOLL RD ,PINC ; HEAD INJ; 25322 BLK MARION RIDGE DR; 813_J_5/154__117; Inc# 117011; Cmd: RRU SUP 8; Tac: RVC TAC 0; M624; NO TEXT",
        "CALL:MED, FALL",
        "ADDR:52735 OAK KNOLL RD",
        "CITY:PINE COVE",
        "INFO:HEAD INJ / NO TEXT",
        "X:25322 BLK MARION RIDGE DR",
        "MAP:813_J_5/154__117",
        "ID:117011",
        "SRC:RRU SUP 8",
        "CH:RVC TAC 0",
        "UNIT:M624");

    doTest("T10",
        "MED, DIFFICULTY BREATHING; 54310 VALLEY VIEW DR ,IDYL ; ; 26500 BLK PINE AV; 814_D_7/154__156; Inc# 116620; Cmd: RRU SUP 8; Tac: RVC TAC 0; M625; White Jeep in driveway",
        "CALL:MED, DIFFICULTY BREATHING",
        "ADDR:54310 VALLEY VIEW DR",
        "CITY:IDYLLWILD",
        "INFO:White Jeep in driveway",
        "X:26500 BLK PINE AV",
        "MAP:814_D_7/154__156",
        "ID:116620",
        "SRC:RRU SUP 8",
        "CH:RVC TAC 0",
        "UNIT:M625");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "(Idyllwild Fire) MED, PERSON DOWN; STN621 @ 54160 MARANATHA DR ,IDYL ; WALK IN; 25778 BLKJOHNSON RD; 814_C_6/154__131; Inc# 038248; Cmd: RVC CMD 8; Tac: RVC TAC 0;M625 STN621A; NO TEXT)",
        "CALL:MED, PERSON DOWN",
        "PLACE:STN621",
        "ADDR:54160 MARANATHA DR",
        "CITY:IDYLLWILD",
        "INFO:WALK IN / NO TEXT)",
        "X:25778 BLKJOHNSON RD",
        "MAP:814_C_6/154__131",
        "ID:038248",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625 STN621A");

    doTest("T2",
        "(Idyllwild Fire) FIRE, COMMERCIAL ALARM; 25980 HY 243 ,IDYL ; ARRIBAS RESTERAUNT  ZONE 11;54000 BLK NORTH CIRCLE DR; 814_C_6/154__144; Inc# 038171; Cmd: RVC CMD 8;Tac: RVC TAC 2; ME621 MT621 STN621A; premise 951 659 4960",
        "CALL:FIRE, COMMERCIAL ALARM",
        "ADDR:25980 HY 243",
        "MADDR:25980 HWY 243",
        "CITY:IDYLLWILD",
        "INFO:ARRIBAS RESTERAUNT  ZONE 11 / premise 951 659 4960",
        "X:54000 BLK NORTH CIRCLE DR",
        "MAP:814_C_6/154__144",
        "ID:038171",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 2",
        "UNIT:ME621 MT621 STN621A");

    doTest("T3",
        "(Idyllwild Fire) MED, TRAUMA; 54635 NORTH CIRCLE DR ,IDYL ; ; 25730 BLK FIR ST;814_D_6/154__132; Inc# 038046; Cmd: RVC CMD 8; Tac: RVC TAC 0; MT621; name -mary\n" +
        "pain in arm\n" +
        "Dispatch  30A02\n" +
        "You are responding to a patient with specifically identified traumaticinjuries.  The patient is a 78-year-old female, who is conscious andbreathing.  NON-RECENT (=&gt; 6hrs) injuries (without priority symptoms).",

        "CALL:MED, TRAUMA",
        "ADDR:54635 NORTH CIRCLE DR",
        "CITY:IDYLLWILD",
        "INFO:name -mary\npain in arm\nDispatch  30A02\nYou are responding to a patient with specifically identified traumaticinjuries.  The patient is a 78-year-old female, who is conscious andbreathing.  NON-RECENT (=> 6hrs) injuries (without priority symptoms).",
        "X:25730 BLK FIR ST",
        "MAP:814_D_6/154__132",
        "ID:038046",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:MT621");

    doTest("T4",
        "(Idyllwild Fire) PA, PERSON; 54160 MARANATHA DR ,IDYL (STN621); ; 25778 BLK JOHNSON RD;814_C_6/154__131; Inc# 038010; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; bloodpressure check",
        "CALL:PA, PERSON",
        "PLACE:STN621",
        "ADDR:54160 MARANATHA DR",
        "CITY:IDYLLWILD",
        "INFO:bloodpressure check",
        "X:25778 BLK JOHNSON RD",
        "MAP:814_C_6/154__131",
        "ID:038010",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625");

    doTest("T5",
        "(Idyllwild Fire) FIRE, COMMERCIAL ALARM; 52500 TEMECULA DR ,IDYL ; IAF PIERCE DORM; 52200 BLKCAHUILLA DR; 843_J_1/154__164; Inc# 037704; Cmd: RVC CMD 8; Tac: RVC TAC 6;M625; gen fire  zone 62  ph/  9516592171room 715 smoke",
        "CALL:FIRE, COMMERCIAL ALARM",
        "ADDR:52500 TEMECULA DR",
        "CITY:IDYLLWILD",
        "INFO:IAF PIERCE DORM / gen fire  zone 62  ph/  9516592171room 715 smoke",
        "X:52200 BLKCAHUILLA DR",
        "MAP:843_J_1/154__164",
        "ID:037704",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 6",
        "UNIT:M625");

    doTest("T6",
        "(Idyllwild Fire) MED, PERSON DOWN; STN621 @ 54160 MARANATHA DR ,IDYL ; CVA, M625 COMMITTED;25778 BLK JOHNSON RD; 814_C_6/154__131; Inc# 037452; Cmd: RVC CMD 8; Tac:RVC TAC 0; M625; NO TEXT",
        "CALL:MED, PERSON DOWN",
        "PLACE:STN621",
        "ADDR:54160 MARANATHA DR",
        "CITY:IDYLLWILD",
        "INFO:CVA, M625 COMMITTED / NO TEXT",
        "X:25778 BLK JOHNSON RD",
        "MAP:814_C_6/154__131",
        "ID:037452",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625");

    doTest("T7",
        "(Idyllwild Fire) MED, OVERDOSE; 26650 FAIRWAY DR ,IDYL ; RSO E/R; 54330 BLK LIVE OAK ST;844_D_1/154__168; Inc# 036980; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625 ME621STN621A; Dispatch  23C01       non combative pt with family o/s  You are responding to a patient who has apparently overdosed/been  poisoned.The patient is a 36-year-old male, who is conscious and  breathing. Notalert  (Intentional Overdose).  1.He is not violent.  2.He does not have aweapon.  3.The patient is inside the same structure.  ^    4.He attemptedsuicide by an overdose. (Change from Protocol #25)  5.This was intentional.6.He is not violent.  -Comments: xanax, sleeping pills and alcohol-",
        "CALL:MED, OVERDOSE",
        "ADDR:26650 FAIRWAY DR",
        "CITY:IDYLLWILD",
        "INFO:RSO E/R / Dispatch  23C01       non combative pt with family o/s  You are responding to a patient who has apparently overdosed/been  poisoned.The patient is a 36-year-old male, who is conscious and  breathing. Notalert  (Intentional Overdose).  1.He is not violent.  2.He does not have aweapon.  3.The patient is inside the same structure.  ^    4.He attemptedsuicide by an overdose. (Change from Protocol #25)  5.This was intentional.6.He is not violent.  -Comments: xanax, sleeping pills and alcohol-",
        "X:54330 BLK LIVE OAK ST",
        "MAP:844_D_1/154__168",
        "ID:036980",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625 ME621STN621A");

    doTest("T8",
        "(Idyllwild Fire) FIRE, UNKNOWN TYPE; 54125 PINE CREST AV ,IDYL ; 54125 LOWER PINECREST; 54271BLK MARANATHA DR; 814_C_6/154__143; Inc# 036716; Cmd: RVC CMD 8; Tac: RVCTAC 1; M625; rp sees gry some next to him",
        "CALL:FIRE, UNKNOWN TYPE",
        "ADDR:54125 PINE CREST AV",
        "MADDR:54125 PINE CREST AVE",
        "CITY:IDYLLWILD",
        "INFO:54125 LOWER PINECREST / rp sees gry some next to him",
        "X:54271BLK MARANATHA DR",
        "MAP:814_C_6/154__143",
        "ID:036716",
        "SRC:RVC CMD 8",
        "CH:RVCTAC 1",
        "UNIT:M625");

    doTest("T9",
        "(Idyllwild Fire) MED, ASSAULT; 26290 HY 243 ,IDYL ; RSO ENRT ***STAGE; 54199 BLK COUNTY PARKRD; 814_C_7/154__143; Inc# 036554; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625MT621 STN621A; cabin tro restaurant - bleeding from arm    nfi\n" +
        "Dispatch  04B03\n" +
        "You are responding to patients who have been assaulted/sexually  assaulted.(If known -- relay pertinent patient-specific information.)  Unknownstatus/Other codes not applicable  (Assault).  Unknown number of patientsinvolved.  3.The location of the assailant is not known.  4.It's not knownif the assailant is armed.",

        "CALL:MED, ASSAULT",
        "ADDR:26290 HY 243",
        "MADDR:26290 HWY 243",
        "CITY:IDYLLWILD",
        "INFO:RSO ENRT ***STAGE / cabin tro restaurant - bleeding from arm    nfi\nDispatch  04B03\nYou are responding to patients who have been assaulted/sexually  assaulted.(If known -- relay pertinent patient-specific information.)  Unknownstatus/Other codes not applicable  (Assault).  Unknown number of patientsinvolved.  3.The location of the assailant is not known.  4.It's not knownif the assailant is armed.",
        "X:54199 BLK COUNTY PARKRD",
        "MAP:814_C_7/154__143",
        "ID:036554",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625MT621 STN621A");

    doTest("T10",
        "(Idyllwild Fire) MED, PERSON DOWN; 22901 EAGLE NEST TRL ,PINC ; UNIT B (2ND HOUSE ONPROPERTY); 22900 BLK AZALEA TRAILS RD; 813_H_1/154__44; Inc# 036065; Cmd:RVC CMD 8; Tac: RVC TAC 0; E23 M625 STN23A; Dispatch  05A02\n" +
        "You are responding to a patient with non-traumatic back pain.  The patientis  a 54-year-old female, who is conscious and breathing. NON-RECENT (=&gt;6hrs) traumatic back pain (without priority symptoms).  -Comments: sharp andneck unstable-",

        "CALL:MED, PERSON DOWN",
        "ADDR:22901 EAGLE NEST TRL",
        "CITY:PINE COVE",
        "INFO:UNIT B (2ND HOUSE ONPROPERTY) / Dispatch  05A02\nYou are responding to a patient with non-traumatic back pain.  The patientis  a 54-year-old female, who is conscious and breathing. NON-RECENT (=>6hrs) traumatic back pain (without priority symptoms).  -Comments: sharp andneck unstable-",
        "X:22900 BLK AZALEA TRAILS RD",
        "MAP:813_H_1/154__44",
        "ID:036065",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:E23 M625 STN23A");

    doTest("T11",
        "(Idyllwild Fire) MED, BLEEDING; 54618 REED LN ,IDYL ; ; 54650 BLK MARIAN VIEW DR;814_D_7/154__156; Inc# 035784; Cmd: RVC CMD 8; Tac: RVC TAC 0; SQ621; femalecut herself on glass washing dishes\n" +
        "Dispatch  21B02\n" +
        "You are responding to a patient who is hemorrhaging.  The patient is a23-year-old female, who is conscious and breathing. SERIOUS  hemorrhage.5.There is blood spurting or pouring out (after dispatch, go to ControlBleeding in DLS Links).",

        "CALL:MED, BLEEDING",
        "ADDR:54618 REED LN",
        "CITY:IDYLLWILD",
        "INFO:femalecut herself on glass washing dishes\nDispatch  21B02\nYou are responding to a patient who is hemorrhaging.  The patient is a23-year-old female, who is conscious and breathing. SERIOUS  hemorrhage.5.There is blood spurting or pouring out (after dispatch, go to ControlBleeding in DLS Links).",
        "X:54650 BLK MARIAN VIEW DR",
        "MAP:814_D_7/154__156",
        "ID:035784",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:SQ621");

    doTest("T12",
        "(Idyllwild Fire) OTH, COVER; HY 243 / 53650 HY 74 E ,MOUN ; AMR REQ 621 COVER ANZA; ;844_B_5/183__47; Inc# 035439; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625 STN53A;NO TEXT",
        "CALL:OTH, COVER",
        "ADDR:HY 243 & 53650 HY 74 E",
        "MADDR:HWY 243 & 53650 HWY 74 E",
        "CITY:MOUNTAIN CENTER",
        "INFO:AMR REQ 621 COVER ANZA / NO TEXT",
        "MAP:844_B_5/183__47",
        "ID:035439",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625 STN53A");

    doTest("T13",
        "(Idyllwild Fire) MED, TC OVER THE SIDE; MP 74-54 @ =L(33.708848,-116.761452) ,MOUN ; ;  ;843_G_4/183__43; Inc# 035098; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; vehiclehad poss rolled over a couple times, female pt on the side of the roadwaving down traffic, unk if any other parties are trapped in the vehicle\n" +
        "Dispatch  29B04  \n" +
        "You are responding to patients involved in a traffic incident.  (If known --relay  pertinent patient-specific information.) Unknown status/Other codesnot  applicable  (Unknown number of patients).  Unknown number of patientsinvolved.  3.Chemicals or other hazards are not involved.",

        "CALL:MED, TC OVER THE SIDE",
        "PLACE:MP 74-54",
        "ADDR:=L(33.708848,-116.761452)",
        "MADDR:+33.708848,-116.761452",
        "CITY:MOUNTAIN CENTER",
        "INFO:vehiclehad poss rolled over a couple times, female pt on the side of the roadwaving down traffic, unk if any other parties are trapped in the vehicle\nDispatch  29B04  \nYou are responding to patients involved in a traffic incident.  (If known --relay  pertinent patient-specific information.) Unknown status/Other codesnot  applicable  (Unknown number of patients).  Unknown number of patientsinvolved.  3.Chemicals or other hazards are not involved.",
        "MAP:843_G_4/183__43",
        "ID:035098",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625");

    doTest("T14",
        "(Idyllwild Fire) MED, FALL; 54245 NORTH CIRCLE DR ,IDYL ; IFO IDYLLWILD COFFEE; 54200 BLKPARK LN; 814_D_6/154__144; Inc# 035049; Cmd: RVC CMD 8; Tac: RVC TAC 0;C6200; Dispatch  17B01  \n" +
        "You are responding to a patient involved in a fall.  The patient is a69-year-old  female, who is conscious and breathing. POSSIBLY DANGEROUS bodyarea.",

        "CALL:MED, FALL",
        "ADDR:54245 NORTH CIRCLE DR",
        "CITY:IDYLLWILD",
        "INFO:IFO IDYLLWILD COFFEE / Dispatch  17B01  \nYou are responding to a patient involved in a fall.  The patient is a69-year-old  female, who is conscious and breathing. POSSIBLY DANGEROUS bodyarea.",
        "X:54200 BLKPARK LN",
        "MAP:814_D_6/154__144",
        "ID:035049",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:C6200");

    doTest("T15",
        "(Idyllwild Fire) MED, FALL; 54245 NORTH CIRCLE DR ,IDYL ; IFO IDYLLWILD COFFEE; 54200 BLKPARK LN; 814_D_6/154__144; Inc# 035049; Cmd: RVC CMD 8; Tac: RVC TAC 0; M624ME621 STN621A; Dispatch  17B01  \n" +
        "You are responding to a patient involved in a fall.  The patient is a69-year-old  female, who is conscious and breathing. POSSIBLY DANGEROUS bodyarea.",

        "CALL:MED, FALL",
        "ADDR:54245 NORTH CIRCLE DR",
        "CITY:IDYLLWILD",
        "INFO:IFO IDYLLWILD COFFEE / Dispatch  17B01  \nYou are responding to a patient involved in a fall.  The patient is a69-year-old  female, who is conscious and breathing. POSSIBLY DANGEROUS bodyarea.",
        "X:54200 BLKPARK LN",
        "MAP:814_D_6/154__144",
        "ID:035049",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M624ME621 STN621A");

    doTest("T16",
        "(Idyllwild Fire) MED, FAINTED / PASSED OUT; 52070 ACORN LN ,PINC ; ; 25400 BLK NORWOOD DR;813_H_5/154__116; Inc# 035036; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625;\n" +
        "Dispatch  26A03  \n" +
        "You are responding to a patient who is sick (or has a current medicalcondition).  The patient is a 76-year-old male, who is conscious andbreathing.  Dizziness/vertigo.",

        "CALL:MED, FAINTED / PASSED OUT",
        "ADDR:52070 ACORN LN",
        "CITY:PINE COVE",
        "INFO:Dispatch  26A03  \nYou are responding to a patient who is sick (or has a current medicalcondition).  The patient is a 76-year-old male, who is conscious andbreathing.  Dizziness/vertigo.",
        "X:25400 BLK NORWOOD DR",
        "MAP:813_H_5/154__116",
        "ID:035036",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625");

    doTest("T17",
        "(Idyllwild Fire) MED, FAINTED / PASSED OUT; 52070 ACORN LN ,PINC ; ; 25400 BLK NORWOOD DR;813_H_5/154__116; Inc# 035036; Cmd: RVC CMD 8; Tac: RVC TAC 0; E23 M624STN23A; Dispatch  26A03  \n" +
        "You are responding to a patient who is sick (or has a current medicalcondition).  The patient is a 76-year-old male, who is conscious andbreathing.  Dizziness/vertigo.",

        "CALL:MED, FAINTED / PASSED OUT",
        "ADDR:52070 ACORN LN",
        "CITY:PINE COVE",
        "INFO:Dispatch  26A03  \nYou are responding to a patient who is sick (or has a current medicalcondition).  The patient is a 76-year-old male, who is conscious andbreathing.  Dizziness/vertigo.",
        "X:25400 BLK NORWOOD DR",
        "MAP:813_H_5/154__116",
        "ID:035036",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:E23 M624STN23A");

    doTest("T18",
        "(Idyllwild Fire) MED, PERSON DOWN; 52500 TEMECULA DR ,IDYL ; IDYLLWILD ARTS ACADEMY - HEALTHCENTER; 52200 BLK CAHUILLA DR; 843_J_1/154__164; Inc# 034973; Cmd: RVC CMD8; Tac: RVC TAC 0; SQ621; ext  2275\n" +
        "Dispatch  26A10  \n" +
        "You are responding to a patient who is sick (or has a current medicalcondition).  The patient is a 65-year-old male, who is conscious andbreathing.  Unwell/ill.  -Comments: arm and hand pain-",

        "CALL:MED, PERSON DOWN",
        "ADDR:52500 TEMECULA DR",
        "CITY:IDYLLWILD",
        "INFO:IDYLLWILD ARTS ACADEMY - HEALTHCENTER / ext  2275\nDispatch  26A10  \nYou are responding to a patient who is sick (or has a current medicalcondition).  The patient is a 65-year-old male, who is conscious andbreathing.  Unwell/ill.  -Comments: arm and hand pain-",
        "X:52200 BLK CAHUILLA DR",
        "MAP:843_J_1/154__164",
        "ID:034973",
        "SRC:RVC CMD8",
        "CH:RVC TAC 0",
        "UNIT:SQ621");

    doTest("T19",
        "(Idyllwild Fire) MED, FALL; 26800 SAUNDERS MEADOW RD ,IDYL (ASTRO CAMP); PT LOC IN FIRST AIDOFFICE; 26400 BLK CLUB HOUSE DR; 844_D_1/154__168; Inc# 034932; Cmd: RVC CMD8; Tac: RVC TAC 0; MT621; Dispatch  17B01  \n" +
        "You are responding to a patient involved in a fall.  The patient is a11-year-old  male, who is conscious and breathing. POSSIBLY DANGEROUS bodyarea.",

        "CALL:MED, FALL",
        "PLACE:ASTRO CAMP",
        "ADDR:26800 SAUNDERS MEADOW RD",
        "CITY:IDYLLWILD",
        "INFO:PT LOC IN FIRST AIDOFFICE / Dispatch  17B01  \nYou are responding to a patient involved in a fall.  The patient is a11-year-old  male, who is conscious and breathing. POSSIBLY DANGEROUS bodyarea.",
        "X:26400 BLK CLUB HOUSE DR",
        "MAP:844_D_1/154__168",
        "ID:034932",
        "SRC:RVC CMD8",
        "CH:RVC TAC 0",
        "UNIT:MT621");

    doTest("T20",
        "(Idyllwild Fire) FIRE, DEBRIS; 54375 TAHQUITZ VIEW DR ,IDYL ; RSO E/R; 26600 BLK PINE AV;814_D_7/154__168; Inc# 034466; Cmd: RVC CMD 8; Tac: RVC TAC 0; MT621; rsoe/r for noise complaint     bon fire/ill burn",
        "CALL:FIRE, DEBRIS",
        "ADDR:54375 TAHQUITZ VIEW DR",
        "CITY:IDYLLWILD",
        "INFO:RSO E/R / rsoe/r for noise complaint     bon fire/ill burn",
        "X:26600 BLK PINE AV",
        "MAP:814_D_7/154__168",
        "ID:034466",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:MT621");

    doTest("T21",
        "(Idyllwild Fire) MED, PERSON DOWN; 54276 NORTH CIRCLE DR / 54200 VILLAGE CENTER DR ,IDYL ;MT621 M625; ; 814_D_6/154__144; Inc# 034279; Cmd: RVC CMD 8; Tac: RVC TAC 0;M625 MT621 STN621A; NO TEXT",
        "CALL:MED, PERSON DOWN",
        "ADDR:54276 NORTH CIRCLE DR & 54200 VILLAGE CENTER DR",
        "MADDR:54276 NORTH CIRCLE DR",
        "CITY:IDYLLWILD",
        "INFO:MT621 M625 / NO TEXT",
        "MAP:814_D_6/154__144",
        "ID:034279",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625 MT621 STN621A");

    doTest("T22",
        "(Idyllwild Fire) OTH, COVER; HY 243 / 53650 HY 74 E ,MOUN ; REQ IDY TO COVER ANZA; ;844_B_5/183__47; Inc# 033942; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625 STN53A;NO TEXT",
        "CALL:OTH, COVER",
        "ADDR:HY 243 & 53650 HY 74 E",
        "MADDR:HWY 243 & 53650 HWY 74 E",
        "CITY:MOUNTAIN CENTER",
        "INFO:REQ IDY TO COVER ANZA / NO TEXT",
        "MAP:844_B_5/183__47",
        "ID:033942",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625 STN53A");

    doTest("T23",
        "(Idyllwild Fire) MED, SEIZURES; 26350 DELANO DR #27 ,IDYL (ROYAL PINES ESTATES MHP); ; 53499BLK FOUR CHIMNEYS RD; 814_B_7/154__154; Inc# 033700; Cmd: RVC CMD 8; Tac:RVC TAC 0; STN621A ME621 M625; Descr: SEIZURE   Pat Cnt: 1  Age: UnknownRange  Sex: Unknown  Con: Unknown  Breath: Unknown  Resp Script: You areresponding to a patient who has had a seizure.  The patient is of unknownage and gender, whose consciousness and breathing is unknown.  Effectivebreathing not verified =&gt; 35.",
        "CALL:MED, SEIZURES",
        "PLACE:ROYAL PINES ESTATES MHP",
        "ADDR:26350 DELANO DR",
        "CITY:IDYLLWILD",
        "INFO:Descr: SEIZURE   Pat Cnt: 1  Age: UnknownRange  Sex: Unknown  Con: Unknown  Breath: Unknown  Resp Script: You areresponding to a patient who has had a seizure.  The patient is of unknownage and gender, whose consciousness and breathing is unknown.  Effectivebreathing not verified => 35.",
        "APT:27",
        "X:53499BLK FOUR CHIMNEYS RD",
        "MAP:814_B_7/154__154",
        "ID:033700",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN621A ME621 M625");

    doTest("T24",
        "(Idyllwild Fire) MED, CHEST PAINS; 52625 DOUBLE VIEW DR ,IDYL ; ; 53099 BLK INSPIRATION LN;843_J_2/154__177; Inc# 033346; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN621A ME621M625; Descr: heart issues  Pat Cnt: 1  Age: 45  Years  Sex: Male  Con: YesBreath: Yes  Resp Script: You are responding to a patient with heartproblems.  The patient is a  45-year-old male, who is conscious andbreathing. Clammy.",
        "CALL:MED, CHEST PAINS",
        "ADDR:52625 DOUBLE VIEW DR",
        "CITY:IDYLLWILD",
        "INFO:Descr: heart issues  Pat Cnt: 1  Age: 45  Years  Sex: Male  Con: YesBreath: Yes  Resp Script: You are responding to a patient with heartproblems.  The patient is a  45-year-old male, who is conscious andbreathing. Clammy.",
        "X:53099 BLK INSPIRATION LN",
        "MAP:843_J_2/154__177",
        "ID:033346",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN621A ME621M625");

    doTest("T25",
        "(Idyllwild Fire) MED, UNRESP &amp; BREATHING; 23440 HY 243 ,PINC ; ; 25500 BLK SUNRISE DR;814_A_5/154__117; Inc# 033250; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN23A E23M625; Descr: fell  Pat Cnt: 1  Age: 79  Years  Sex: Female  Con: YesBreath: Yes  Resp Script: You are responding to a patient who is unconscious(or has fainted).  The patient  is a 79-year-old female, who is consciousand breathing. Not alert.",
        "CALL:MED, UNRESP & BREATHING",
        "ADDR:23440 HY 243",
        "MADDR:23440 HWY 243",
        "CITY:PINE COVE",
        "INFO:Descr: fell  Pat Cnt: 1  Age: 79  Years  Sex: Female  Con: YesBreath: Yes  Resp Script: You are responding to a patient who is unconscious(or has fainted).  The patient  is a 79-year-old female, who is consciousand breathing. Not alert.",
        "X:25500 BLK SUNRISE DR",
        "MAP:814_A_5/154__117",
        "ID:033250",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN23A E23M625");

    doTest("T26",
        "(Idyllwild Fire) FIRE, RESIDENTIAL; 54450 VILLAGE VIEW DR ,IDYL ; ACROSS FROM ADDY;DEAD-END; 814_D_7/154__156; Inc# 033071; Cmd: RVC CMD 8; Tac: RVC TAC 6;M625; house fully engulfed in flames per rp",
        "CALL:FIRE, RESIDENTIAL",
        "ADDR:54450 VILLAGE VIEW DR",
        "CITY:IDYLLWILD",
        "INFO:ACROSS FROM ADDY / house fully engulfed in flames per rp",
        "X:DEAD-END",
        "MAP:814_D_7/154__156",
        "ID:033071",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 6",
        "UNIT:M625");

    doTest("T27",
        "(Idyllwild Fire) MED, PERSON DOWN; 53375 IDYLLBROOK DR ,IDYL ; PWC,  CAROL     POSS 5150;26550 BLK DELANO DR; 844_B_1/154__166; Inc# 033078; Cmd: RVC CMD 8; Tac: RVCTAC 0; M624; Descr: lost your mind  Pat Cnt: 1  Age: 81  Years  Sex: FemaleCon: Yes  Breath: Yes  Resp Script: You are responding to a patient who hasabnormal or suicidal behavior.  The patient is a 81-year-old female, who isconscious and breathing.  Non-suicidal and alert.  1.She is not violent.2.She does not have a weapon.  3.Her exact position is: sitting in thekitchen  4.This is not a suicide attempt.  -Comments: sitting in thekitchen-  ",
        "CALL:MED, PERSON DOWN",
        "ADDR:53375 IDYLLBROOK DR",
        "CITY:IDYLLWILD",
        "INFO:PWC,  CAROL     POSS 5150 / Descr: lost your mind  Pat Cnt: 1  Age: 81  Years  Sex: FemaleCon: Yes  Breath: Yes  Resp Script: You are responding to a patient who hasabnormal or suicidal behavior.  The patient is a 81-year-old female, who isconscious and breathing.  Non-suicidal and alert.  1.She is not violent.2.She does not have a weapon.  3.Her exact position is: sitting in thekitchen  4.This is not a suicide attempt.  -Comments: sitting in thekitchen-",
        "X:26550 BLK DELANO DR",
        "MAP:844_B_1/154__166",
        "ID:033078",
        "SRC:RVC CMD 8",
        "CH:RVCTAC 0",
        "UNIT:M624");

    doTest("T28",
        "(Idyllwild Fire) FIRE, RESIDENTIAL; 54450 VILLAGE VIEW DR ,IDYL ; ACROSS FROM ADDY;DEAD-END; 814_D_7/154__156; Inc# 033071; Cmd: RVC CMD 8; Tac: RVC TAC 6;C6200; house fully engulfed in flames per rp",
        "CALL:FIRE, RESIDENTIAL",
        "ADDR:54450 VILLAGE VIEW DR",
        "CITY:IDYLLWILD",
        "INFO:ACROSS FROM ADDY / house fully engulfed in flames per rp",
        "X:DEAD-END",
        "MAP:814_D_7/154__156",
        "ID:033071",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 6",
        "UNIT:C6200");

    doTest("T29",
        "(Idyllwild Fire) MED, TRAFFIC COLLISION; VISTA POINT (HY 243) @ 51750 HY 243 ,PINC ; ;  BLACKMOUNTAIN TRL; 783_G_6/154__19; Inc# 033055; Cmd: RVC CMD 8; Tac: RVC TAC 0;STN23A E23 M625; JUST BELOW VISTA POINT , NEAR THE TURN-OUT , VEH INTO THESIDE OF MTN , UNK DIRECTION OF TRAVEL...MULT VEHS PULLED OVER ATTEMPTING TOASSISTDescr: Traffic / Transportation Incidents  Pat Cnt: 255  Age: Unknown  RangeSex: Unknown  Con: Unknown  Breath: Unknown  Resp Script: You are respondingto patients involved in a traffic incident.  (If known -- relay  pertinentpatient-specific information.) Unknown status/Other codes not  applicable(Unknown number of patients).  Unknown number of patients involved.  3.It'snot known if chemicals or other hazards are involved.",
        "CALL:MED, TRAFFIC COLLISION",
        "PLACE:VISTA POINT (HY 243)",
        "ADDR:51750 HY 243",
        "MADDR:51750 HWY 243",
        "CITY:PINE COVE",
        "INFO:JUST BELOW VISTA POINT , NEAR THE TURN-OUT , VEH INTO THESIDE OF MTN , UNK DIRECTION OF TRAVEL...MULT VEHS PULLED OVER ATTEMPTING TOASSISTDescr: Traffic / Transportation Incidents  Pat Cnt: 255  Age: Unknown  RangeSex: Unknown  Con: Unknown  Breath: Unknown  Resp Script: You are respondingto patients involved in a traffic incident.  (If known -- relay  pertinentpatient-specific information.) Unknown status/Other codes not  applicable(Unknown number of patients).  Unknown number of patients involved.  3.It'snot known if chemicals or other hazards are involved.",
        "X:BLACKMOUNTAIN TRL",
        "MAP:783_G_6/154__19",
        "ID:033055",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN23A E23 M625");

    doTest("T30",
        "(Idyllwild Fire) MED, UNRESP &amp; BREATHING; 52315 SYLVAN WY ,PINC ; ; 23199 BLK OAK LEAFLN; 813_H_5/154__116; Inc# 032045; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN23AE23 M625; Descr: PASSED OUT NOW   Pat Cnt: 1  Age: 14  Years  Sex: FemaleCon: Yes  Breath: Yes  Resp Script: You are responding to a patient who issick (or has a current medical condition).  The patient is a 14-year-oldfemale, who is conscious and breathing. Not  alert.",
        "CALL:MED, UNRESP & BREATHING",
        "ADDR:52315 SYLVAN WY",
        "CITY:PINE COVE",
        "INFO:Descr: PASSED OUT NOW   Pat Cnt: 1  Age: 14  Years  Sex: FemaleCon: Yes  Breath: Yes  Resp Script: You are responding to a patient who issick (or has a current medical condition).  The patient is a 14-year-oldfemale, who is conscious and breathing. Not  alert.",
        "X:23199 BLK OAK LEAFLN",
        "MAP:813_H_5/154__116",
        "ID:032045",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN23AE23 M625");

    doTest("T31",
        "(Idyllwild Fire) MED, BITES OR STINGS; 53261 DEER FOOT LN ,IDYL ; ; 53350 BLK DOUBLE VIEW DR;844_A_2/154__178; Inc# 031552; Cmd: RVC CMD 8; Tac: RVC TAC 0; M626; name -joanDescr: allergic rxn   Pat Cnt: 1  Age: 61  Years  Sex: Female  Con: YesBreath: Yes  Resp Script: You are responding to a patient with an allergicreaction/envenomation  (sting, bite).  The patient is a 61-year-old female,who is conscious and  breathing. DIFFICULTY SPEAKING BETWEEN BREATHS.",
        "CALL:MED, BITES OR STINGS",
        "ADDR:53261 DEER FOOT LN",
        "CITY:IDYLLWILD",
        "INFO:name -joanDescr: allergic rxn   Pat Cnt: 1  Age: 61  Years  Sex: Female  Con: YesBreath: Yes  Resp Script: You are responding to a patient with an allergicreaction/envenomation  (sting, bite).  The patient is a 61-year-old female,who is conscious and  breathing. DIFFICULTY SPEAKING BETWEEN BREATHS.",
        "X:53350 BLK DOUBLE VIEW DR",
        "MAP:844_A_2/154__178",
        "ID:031552",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M626");

    doTest("T32",
        "(Idyllwild Fire) MED, TRAUMA; 25465 MANZANITA DR ,IDYL ; MINISTERS HOUSE AT CHURCH OFIDYLLWILD; 25526 BLK HY 243; 814_C_5/154__131; Inc# 031544; Cmd: RVC CMD 8;Tac: RVC TAC 0; STN621A M625 ME621; 6592364 fell earlier  bit lip  hasstitchesDescr: trauma  Pat Cnt: 1  Age: 87  Years  Sex: Female  Con: Yes  Breath:Yes  Resp Script: You are responding to a patient with specificallyidentified traumatic injuries.  The patient is a 87-year-old female, who isconscious and breathing.  SERIOUS hemorrhage.Descr: trauma  Pat Cnt: 1  Age: 87  Years  Sex: Female  Con: Yes  Breath:Yes  Resp Script: SERIOUS hemorrhage.",
        "CALL:MED, TRAUMA",
        "ADDR:25465 MANZANITA DR",
        "CITY:IDYLLWILD",
        "INFO:MINISTERS HOUSE AT CHURCH OFIDYLLWILD / 6592364 fell earlier  bit lip  hasstitchesDescr: trauma  Pat Cnt: 1  Age: 87  Years  Sex: Female  Con: Yes  Breath:Yes  Resp Script: You are responding to a patient with specificallyidentified traumatic injuries.  The patient is a 87-year-old female, who isconscious and breathing.  SERIOUS hemorrhage.Descr: trauma  Pat Cnt: 1  Age: 87  Years  Sex: Female  Con: Yes  Breath:Yes  Resp Script: SERIOUS hemorrhage.",
        "X:25526 BLK HY 243",
        "MAP:814_C_5/154__131",
        "ID:031544",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN621A M625 ME621");

    doTest("T33",
        "(Idyllwild Fire) FMS, GAS; 54750 NORTH CIRCLE DR ,IDYL ; E621 M625, SMELL OF GAS; 55799 BLK SCIRCLE DR; 814_D_5/154__132; Inc# 031463; Cmd: RVC CMD 8; Tac: RVC TAC 0;STN621A ME621 M625; NO TEXT",
        "CALL:FMS, GAS",
        "ADDR:54750 NORTH CIRCLE DR",
        "CITY:IDYLLWILD",
        "INFO:E621 M625, SMELL OF GAS / NO TEXT",
        "X:55799 BLK SCIRCLE DR",
        "MAP:814_D_5/154__132",
        "ID:031463",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN621A ME621 M625");

    doTest("T34",
        "(Idyllwild Fire) MED, CHEST PAINS; 54165 PINE CREST AV ,IDYL ; IDYLLWILD HEALTH CENTER,;54271 BLK MARANATHA DR; 814_C_6/154__143; Inc# 031392; Cmd: RVC CMD 8; Tac:RVC TAC 0; M626; Descr: cp  Pat Cnt: 1  Age: 97  Years  Sex: Female  Con:Yes  Breath: Yes  Resp Script: You are responding to a patient with chestpain.  The patient is a 97-year-old  female, who is conscious and breathing.Clammy.",
        "CALL:MED, CHEST PAINS",
        "ADDR:54165 PINE CREST AV",
        "MADDR:54165 PINE CREST AVE",
        "CITY:IDYLLWILD",
        "INFO:IDYLLWILD HEALTH CENTER, / Descr: cp  Pat Cnt: 1  Age: 97  Years  Sex: Female  Con:Yes  Breath: Yes  Resp Script: You are responding to a patient with chestpain.  The patient is a 97-year-old  female, who is conscious and breathing.Clammy.",
        "X:54271 BLK MARANATHA DR",
        "MAP:814_C_6/154__143",
        "ID:031392",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M626");

    doTest("T35",
        "(Idyllwild Fire) MED, PERSON DOWN; 25726 ALDERWOOD ST / 54550 NORTH CIRCLE DR ,IDYL ; 26990ALDERWOOD; ; 814_D_6/154__132; Inc# 031369; Cmd: RVC CMD 8; Tac: RVC TAC 0;STN621A ME621 M625; Descr: sick  Pat Cnt: 1  Age: 50  Years  Sex: FemaleCon: Yes  Breath: Yes  Resp Script: You are responding to a patient withnon-traumatic back pain.  The patient is  a 50-year-old female, who isconscious and breathing. NON-TRAUMATIC  -Comments: back-  -Comments: 9-10-",
        "CALL:MED, PERSON DOWN",
        "ADDR:25726 ALDERWOOD ST & 54550 NORTH CIRCLE DR",
        "MADDR:25726 ALDERWOOD ST",
        "CITY:IDYLLWILD",
        "INFO:26990ALDERWOOD / Descr: sick  Pat Cnt: 1  Age: 50  Years  Sex: FemaleCon: Yes  Breath: Yes  Resp Script: You are responding to a patient withnon-traumatic back pain.  The patient is  a 50-year-old female, who isconscious and breathing. NON-TRAUMATIC  -Comments: back-  -Comments: 9-10-",
        "MAP:814_D_6/154__132",
        "ID:031369",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN621A ME621 M625");

    doTest("T36",
        "(Idyllwild Fire) MED, UNCONSCIOUS / UNRESP; 54144 LINGER LN ,IDYL ; UNATTENDED, RSO E/R;26600 BLK HIDE A LN; 844_C_1/154__167; Inc# 031011; Cmd: RVC CMD 8; Tac: RVCTAC 0; M625; NO TEXT",
        "CALL:MED, UNCONSCIOUS / UNRESP",
        "ADDR:54144 LINGER LN",
        "CITY:IDYLLWILD",
        "INFO:UNATTENDED, RSO E/R / NO TEXT",
        "X:26600 BLK HIDE A LN",
        "MAP:844_C_1/154__167",
        "ID:031011",
        "SRC:RVC CMD 8",
        "CH:RVCTAC 0",
        "UNIT:M625");

    doTest("T37",
        "(Idyllwild Fire) MED, FAINTED / PASSED OUT; 54400 NORTH CIRCLE DR ,IDYL ; IFO IDYL COMMPRESBYTERIAN CHURCH; 25800 BLK OAKWOOD ST; 814_D_6/154__144; Inc# 030701;Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; Descr: collapsed   Pat Cnt: 1  Age: 92Years  Sex: Male  Con: Yes  Breath: Yes  Resp Script: You are responding toa patient who is unconscious (or has fainted).  The patient  is a92-year-old male, who is conscious and breathing. Fainting  episode(s) andalert =&gt; 35 (without cardiac history).  ",
        "CALL:MED, FAINTED / PASSED OUT",
        "ADDR:54400 NORTH CIRCLE DR",
        "CITY:IDYLLWILD",
        "INFO:IFO IDYL COMMPRESBYTERIAN CHURCH / Descr: collapsed   Pat Cnt: 1  Age: 92Years  Sex: Male  Con: Yes  Breath: Yes  Resp Script: You are responding toa patient who is unconscious (or has fainted).  The patient  is a92-year-old male, who is conscious and breathing. Fainting  episode(s) andalert => 35 (without cardiac history).",
        "X:25800 BLK OAKWOOD ST",
        "MAP:814_D_6/154__144",
        "ID:030701",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625");

    doTest("T38",
        "(Idyllwild Fire) MED, DIFFICULTY BREATHING; 25050 CASCADE DR ,PINC ; ; 25199 BLK ROSA WY;814_A_5/154__118; Inc# 030606; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; Descr:DB, ILL  Pat Cnt: 1  Age: 65  Years  Sex: Female  Con: Yes  Breath: YesResp Script: You are responding to a patient with breathing problems.  Thepatient is a  65-year-old female, who is conscious and breathing. DIFFICULTYSPEAKING BETWEEN BREATHS.",
        "CALL:MED, DIFFICULTY BREATHING",
        "ADDR:25050 CASCADE DR",
        "CITY:PINE COVE",
        "INFO:Descr:DB, ILL  Pat Cnt: 1  Age: 65  Years  Sex: Female  Con: Yes  Breath: YesResp Script: You are responding to a patient with breathing problems.  Thepatient is a  65-year-old female, who is conscious and breathing. DIFFICULTYSPEAKING BETWEEN BREATHS.",
        "X:25199 BLK ROSA WY",
        "MAP:814_A_5/154__118",
        "ID:030606",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625");

    doTest("T39",
        "(Idyllwild Fire) MED, PERSON DOWN; STN621 @ 54160 MARANATHA DR ,IDYL ; ; 25778 BLK JOHNSONRD; 814_C_6/154__131; Inc# 030054; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; NOTEXT",
        "CALL:MED, PERSON DOWN",
        "PLACE:STN621",
        "ADDR:54160 MARANATHA DR",
        "CITY:IDYLLWILD",
        "INFO:NOTEXT",
        "X:25778 BLK JOHNSONRD",
        "MAP:814_C_6/154__131",
        "ID:030054",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625");

    doTest("T40",
        "(Idyllwild Fire) MED, ALTERED LOC; LAKE HEMET CAMPGROUND @ 56570 HY 74 E ,ANZA ; SP 133;THOMAS MOUNTAIN RD; 874_H_2/184__111; Inc# 029957; Cmd: RVC CMD 8; Tac: RVCTAC 0; E621; Descr: man laying on ground  Pat Cnt: 1  Age: 77  Years  Sex:Male  Con: Yes  Breath: Yes  Resp Script: You are responding to a patientwho is sick (or has a current medical condition).  The patient is a77-year-old male, who is conscious and breathing.  ALTERED LEVEL OFCONSCIOUSNESS.",
        "CALL:MED, ALTERED LOC",
        "PLACE:LAKE HEMET CAMPGROUND",
        "ADDR:56570 HY 74 E",
        "MADDR:56570 HWY 74 E",
        "CITY:ANZAS",
        "INFO:SP 133 / Descr: man laying on ground  Pat Cnt: 1  Age: 77  Years  Sex:Male  Con: Yes  Breath: Yes  Resp Script: You are responding to a patientwho is sick (or has a current medical condition).  The patient is a77-year-old male, who is conscious and breathing.  ALTERED LEVEL OFCONSCIOUSNESS.",
        "X:THOMAS MOUNTAIN RD",
        "MAP:874_H_2/184__111",
        "ID:029957",
        "SRC:RVC CMD 8",
        "CH:RVCTAC 0",
        "UNIT:E621");

    doTest("T41",
        "(Idyllwild Fire) OTH, COVER; HY 243 / 53650 HY 74 E ,MOUN ; COVERAGE FOR AMR; ;936_A_2/213__168; Inc# 029701; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; NO TEXT",
        "CALL:OTH, COVER",
        "ADDR:HY 243 & 53650 HY 74 E",
        "MADDR:HWY 243 & 53650 HWY 74 E",
        "CITY:MOUNTAIN CENTER",
        "INFO:COVERAGE FOR AMR / NO TEXT",
        "MAP:936_A_2/213__168",
        "ID:029701",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625");

    doTest("T42",
        "(Idyllwild Fire) OTH, COVER; 61700 HY 371 / 61750 HY 74 E ,ANZA ; COVERAGE FOR AMR; ;936_A_2/213__168; Inc# 029701; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN53ASTN621A M624; NO TEXT",
        "CALL:OTH, COVER",
        "ADDR:61700 HY 371 & 61750 HY 74 E",
        "MADDR:61700 HWY 371",
        "CITY:ANZAS",
        "INFO:COVERAGE FOR AMR / NO TEXT",
        "MAP:936_A_2/213__168",
        "ID:029701",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN53ASTN621A M624");

    doTest("T43",
        "(Idyllwild Fire) MED, DIABETIC; 26140 CRESTVIEW DR ,IDYL ; ; 26400 BLK FOREST HILL DR;814_D_7/154__156; Inc# 029609; Cmd: RVC CMD 8; Tac: RVC TAC 0; M625; Descr:blurry vision/ weak  Pat Cnt: 1  Age: 57  Years  Sex: Male  Con: YesBreath: Yes  Resp Script: You are responding to a patient with diabeticproblems.  The patient is a  57-year-old male, who is conscious andbreathing. Alert and behaving  normally.",
        "CALL:MED, DIABETIC",
        "ADDR:26140 CRESTVIEW DR",
        "CITY:IDYLLWILD",
        "INFO:Descr:blurry vision/ weak  Pat Cnt: 1  Age: 57  Years  Sex: Male  Con: YesBreath: Yes  Resp Script: You are responding to a patient with diabeticproblems.  The patient is a  57-year-old male, who is conscious andbreathing. Alert and behaving  normally.",
        "X:26400 BLK FOREST HILL DR",
        "MAP:814_D_7/154__156",
        "ID:029609",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:M625");

    doTest("T44",
        "(Idyllwild Fire) MED, PERSON DOWN; STN621 @ 54160 MARANATHA DR ,IDYL ; WALK IN; 25778 BLKJOHNSON RD; 814_C_6/154__131; Inc# 029400; Cmd: RVC CMD 8; Tac: RVC TAC 0;STN621A M625; NO TEXT",
        "CALL:MED, PERSON DOWN",
        "PLACE:STN621",
        "ADDR:54160 MARANATHA DR",
        "CITY:IDYLLWILD",
        "INFO:WALK IN / NO TEXT",
        "X:25778 BLKJOHNSON RD",
        "MAP:814_C_6/154__131",
        "ID:029400",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN621A M625");

    doTest("T45",
        "(Idyllwild Fire) MED, SEIZURES; 54360 MARIAN VIEW DR ,IDYL ; AMERICAN LEGION POST 800; 26000BLK CRESTVIEW DR; 814_D_7/154__156; Inc# 029359; Cmd: RVC CMD 8; Tac: RVCTAC 0; SQ621; Descr: SEIZURE  Pat Cnt: 1  Age: 60  Years  Sex: Male  Con:Unknown  Breath: Yes  Resp Script: You are responding to a patient who hashad a seizure.  The patient is a  60-year-old male, who is breathing andwhose consciousness is  unknown. Effective breathing not verified =&gt; 35.",
        "CALL:MED, SEIZURES",
        "ADDR:54360 MARIAN VIEW DR",
        "CITY:IDYLLWILD",
        "INFO:AMERICAN LEGION POST 800 / Descr: SEIZURE  Pat Cnt: 1  Age: 60  Years  Sex: Male  Con:Unknown  Breath: Yes  Resp Script: You are responding to a patient who hashad a seizure.  The patient is a  60-year-old male, who is breathing andwhose consciousness is  unknown. Effective breathing not verified => 35.",
        "X:26000BLK CRESTVIEW DR",
        "MAP:814_D_7/154__156",
        "ID:029359",
        "SRC:RVC CMD 8",
        "CH:RVCTAC 0",
        "UNIT:SQ621");

    doTest("T46",
        "(Idyllwild Fire) MED, BLOOD PRESSURE; 25080 FERN VALLEY RD ,IDYL ; ; 25199 BLK MCGRATH RD;814_E_4/155__109; Inc# 029329; Cmd: RVC CMD 8; Tac: RVC TAC 0; C6200;PREMISE 951 659 4139 PATRICIADescr: HIGH BP  Pat Cnt: 1  Age: 87  Years  Sex: Female  Con: Yes  Breath:Yes  Resp Script: You are responding to a patient who is sick (or has acurrent medical condition).  The patient is a 87-year-old female, who isconscious and breathing.  Blood pressure abnormality (asymptomatic).",
        "CALL:MED, BLOOD PRESSURE",
        "ADDR:25080 FERN VALLEY RD",
        "CITY:IDYLLWILD",
        "INFO:PREMISE 951 659 4139 PATRICIADescr: HIGH BP  Pat Cnt: 1  Age: 87  Years  Sex: Female  Con: Yes  Breath:Yes  Resp Script: You are responding to a patient who is sick (or has acurrent medical condition).  The patient is a 87-year-old female, who isconscious and breathing.  Blood pressure abnormality (asymptomatic).",
        "X:25199 BLK MCGRATH RD",
        "MAP:814_E_4/155__109",
        "ID:029329",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:C6200");

    doTest("T47",
        "(Idyllwild Fire) MED, PERSON DOWN; 54910 PINE CREST AV ,IDYL (IDYLLWILD HEALTH CLINIC); FERNCREEK MEDICAL CENTER; 55799 BLK S CIRCLE DR; 814_D_5/154__132; Inc# 029304;Cmd: RVC CMD 8; Tac: RVC TAC 0; STN621A ME621 M625; Descr: chest pain  PatCnt: 1  Age: 84  Years  Sex: Female  Con: Yes  Breath: Yes  Resp Script: Youare responding to a patient transfer or medical care facility situation.The patient is a 84-year-old female, who is conscious and breathing.Emergency response requested  (Transfer).",
        "CALL:MED, PERSON DOWN",
        "PLACE:IDYLLWILD HEALTH CLINIC",
        "ADDR:54910 PINE CREST AV",
        "MADDR:54910 PINE CREST AVE",
        "CITY:IDYLLWILD",
        "INFO:FERNCREEK MEDICAL CENTER / Descr: chest pain  PatCnt: 1  Age: 84  Years  Sex: Female  Con: Yes  Breath: Yes  Resp Script: Youare responding to a patient transfer or medical care facility situation.The patient is a 84-year-old female, who is conscious and breathing.Emergency response requested  (Transfer).",
        "X:55799 BLK S CIRCLE DR",
        "MAP:814_D_5/154__132",
        "ID:029304",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN621A ME621 M625");

    doTest("T48",
        "(Idyllwild Fire) MED, CHEST PAINS; 25205 LODGE RD ,IDYL ; ; 55022 BLK SAN JACINTO RD;814_E_5/155__109; Inc# 028586; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN621A ME621M625; Descr: chest pains  Pat Cnt: 1  Age: 31  Years  Sex: Female  Con: YesBreath: Yes  Resp Script: You are responding to a patient with chest pain.The patient is a 31-year-old  female, who is conscious and breathing.DIFFICULTY SPEAKING BETWEEN  BREATHS.",
        "CALL:MED, CHEST PAINS",
        "ADDR:25205 LODGE RD",
        "CITY:IDYLLWILD",
        "INFO:Descr: chest pains  Pat Cnt: 1  Age: 31  Years  Sex: Female  Con: YesBreath: Yes  Resp Script: You are responding to a patient with chest pain.The patient is a 31-year-old  female, who is conscious and breathing.DIFFICULTY SPEAKING BETWEEN  BREATHS.",
        "X:55022 BLK SAN JACINTO RD",
        "MAP:814_E_5/155__109",
        "ID:028586",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN621A ME621M625");

    doTest("T49",
        "(Idyllwild Fire) FIRE, RESIDENTIAL; STN30 @ 70080 HY 74 E ,ANZA ; 1/2 MILE   LOOKING NORTHOFF HWY; 70353 BLK SCENIC DR; 907_H_6/215__123; Inc# 027496; Cmd: RVC CMD 8;Tac: RVC TAC 6; STN30B E3162 E33 E67 B12B E23 E3169 BR621; 8 miles west ofstn30 ...black smoke  ..rp is a local and doesnt believe its idyllwild thathes seeing ..",
        "CALL:FIRE, RESIDENTIAL",
        "PLACE:STN30",
        "ADDR:70080 HY 74 E",
        "MADDR:70080 HWY 74 E",
        "CITY:ANZAS",
        "INFO:1/2 MILE   LOOKING NORTHOFF HWY / 8 miles west ofstn30 ...black smoke  ..rp is a local and doesnt believe its idyllwild thathes seeing ..",
        "X:70353 BLK SCENIC DR",
        "MAP:907_H_6/215__123",
        "ID:027496",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 6",
        "UNIT:STN30B E3162 E33 E67 B12B E23 E3169 BR621");

    doTest("T50",
        "(Idyllwild Fire) MED, UNCONSCIOUS / UNRESP; 54563 MARIAN VIEW DR ,IDYL ; RSO E/R; 54600 BLKLOOKOUT RD; 814_D_7/154__156; Inc# 027443; Cmd: RVC CMD 8; Tac: RVC TAC 0;ME621 M625; armandoFound by house clearner,, stiff and purple,, has been illDescr: Poss unattended  Pat Cnt: 1  Age: 82  Years  Sex: Male  Con: NoBreath: No  Resp Script: You are responding to a patient in apparent cardiac(respiratory) arrest.  The  patient is a 82-year-old male, who isunconscious and not breathing.  Not breathing at all.",
        "CALL:MED, UNCONSCIOUS / UNRESP",
        "ADDR:54563 MARIAN VIEW DR",
        "CITY:IDYLLWILD",
        "INFO:RSO E/R / armandoFound by house clearner,, stiff and purple,, has been illDescr: Poss unattended  Pat Cnt: 1  Age: 82  Years  Sex: Male  Con: NoBreath: No  Resp Script: You are responding to a patient in apparent cardiac(respiratory) arrest.  The  patient is a 82-year-old male, who isunconscious and not breathing.  Not breathing at all.",
        "X:54600 BLKLOOKOUT RD",
        "MAP:814_D_7/154__156",
        "ID:027443",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:ME621 M625");

    doTest("T51",
        "(Idyllwild Fire) MED, RINGING ALARM; 54565 MARIAN VIEW DR ,IDYL ; ; 54600 BLK LOOKOUT RD;814_D_7/154__156; Inc# 027463; Cmd: RVC CMD 8; Tac: RVC TAC 0; ME621 M625;prem -- 951-468-4026no contact by alarm co Descr: Unknown Problem (Man Down)  Pat Cnt: 1  Age: Unknown  Range  Sex:Unknown  Con: Unknown  Breath: Unknown  Resp Script: You are responding to apatient with an unknown problem (man down).  The  patient is of unknown ageand gender, whose consciousness and breathing  is unknown. Medical Alarm(Alert) notifications (no patient information).  -Comments: as dispatched-",
        "CALL:MED, RINGING ALARM",
        "ADDR:54565 MARIAN VIEW DR",
        "CITY:IDYLLWILD",
        "INFO:prem -- 951-468-4026no contact by alarm co Descr: Unknown Problem (Man Down)  Pat Cnt: 1  Age: Unknown  Range  Sex:Unknown  Con: Unknown  Breath: Unknown  Resp Script: You are responding to apatient with an unknown problem (man down).  The  patient is of unknown ageand gender, whose consciousness and breathing  is unknown. Medical Alarm(Alert) notifications (no patient information).  -Comments: as dispatched-",
        "X:54600 BLK LOOKOUT RD",
        "MAP:814_D_7/154__156",
        "ID:027463",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:ME621 M625");

    doTest("T52",
        "(Idyllwild Fire) MED, UNCONSCIOUS / UNRESP; 54563 MARIAN VIEW DR ,IDYL ; ; 54600 BLK LOOKOUTRD; 814_D_7/154__156; Inc# 027443; Cmd: RVC CMD 8; Tac: RVC TAC 0; BR621;armandoFound by house clearner,, stiff and purple,, has been illDescr: Poss unattended  Pat Cnt: 1  Age: 82  Years  Sex: Male  Con: NoBreath: No  Resp Script: You are responding to a patient in apparent cardiac(respiratory) arrest.  The  patient is a 82-year-old male, who isunconscious and not breathing.  Not breathing at all.",
        "CALL:MED, UNCONSCIOUS / UNRESP",
        "ADDR:54563 MARIAN VIEW DR",
        "CITY:IDYLLWILD",
        "INFO:armandoFound by house clearner,, stiff and purple,, has been illDescr: Poss unattended  Pat Cnt: 1  Age: 82  Years  Sex: Male  Con: NoBreath: No  Resp Script: You are responding to a patient in apparent cardiac(respiratory) arrest.  The  patient is a 82-year-old male, who isunconscious and not breathing.  Not breathing at all.",
        "X:54600 BLK LOOKOUTRD",
        "MAP:814_D_7/154__156",
        "ID:027443",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:BR621");

    doTest("T53",
        "(Idyllwild Fire) FIRE, COMMERCIAL ALARM; 26700 HY 243 ,IDYL (IDYLLWILD ELEMENTARY SCH); ZONE1; 53999 BLK TOLL GATE RD; 814_C_7/154__155; Inc# 027381; Cmd: RVC CMD 8;Tac: RVC TAC 2; STN621A ME621 E23; NO TEXT",
        "CALL:FIRE, COMMERCIAL ALARM",
        "PLACE:IDYLLWILD ELEMENTARY SCH",
        "ADDR:26700 HY 243",
        "MADDR:26700 HWY 243",
        "CITY:IDYLLWILD",
        "INFO:ZONE1 / NO TEXT",
        "X:53999 BLK TOLL GATE RD",
        "MAP:814_C_7/154__155",
        "ID:027381",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 2",
        "UNIT:STN621A ME621 E23");

    doTest("T54",
        "(Idyllwild Fire) FMS, GAS; 53145 DOUBLE VIEW DR ,IDYL ; ; 26999 BLK MEADOW GLEN DR;844_A_1/154__178; Inc# 027148; Cmd: RVC CMD 8; Tac: RVC TAC 0; SQ621; NOTEXT",
        "CALL:FMS, GAS",
        "ADDR:53145 DOUBLE VIEW DR",
        "CITY:IDYLLWILD",
        "INFO:NOTEXT",
        "X:26999 BLK MEADOW GLEN DR",
        "MAP:844_A_1/154__178",
        "ID:027148",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:SQ621");

    doTest("T55",
        "(Idyllwild Fire) OTH, COVER; 53650 HY 74 E AT   HY 243 ,MOUN ; MEDIC COVERAGE; ;936_A_2/213__168; Inc# 026558; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN53A M625;NO TEXT",
        "CALL:OTH, COVER",
        "ADDR:53650 HY 74 E AT   HY 243",
        "MADDR:53650 HWY 74 E AT   HWY 243",
        "CITY:MOUNTAIN CENTER",
        "INFO:MEDIC COVERAGE / NO TEXT",
        "MAP:936_A_2/213__168",
        "ID:026558",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN53A M625");

    doTest("T56",
        "(Idyllwild Fire) MED, UNRESP &amp; BREATHING; 53230 DOUBLE VIEW DR ,IDYL ; LOW; 26999 BLKMEADOW GLEN DR; 844_A_1/154__178; Inc# 026473; Cmd: RVC CMD 8; Tac: RVC TAC0; SQ621; rp - DuraDescr: low bp   Pat Cnt: 1  Age: 63  Years  Sex: Male  Con: No  Breath: YesResp Script: You are responding to a patient with an unknown problem (mandown).  The  patient is a 63-year-old male, who is unconscious andbreathing. LIFE  STATUS QUESTIONABLE.",
        "CALL:MED, UNRESP & BREATHING",
        "ADDR:53230 DOUBLE VIEW DR",
        "CITY:IDYLLWILD",
        "INFO:LOW / rp - DuraDescr: low bp   Pat Cnt: 1  Age: 63  Years  Sex: Male  Con: No  Breath: YesResp Script: You are responding to a patient with an unknown problem (mandown).  The  patient is a 63-year-old male, who is unconscious andbreathing. LIFE  STATUS QUESTIONABLE.",
        "X:26999 BLKMEADOW GLEN DR",
        "MAP:844_A_1/154__178",
        "ID:026473",
        "SRC:RVC CMD 8",
        "CH:RVC TAC0",
        "UNIT:SQ621");

    doTest("T57",
        "(Idyllwild Fire) MED, PERSON DOWN; 53230 DOUBLE VIEW DR ,IDYL ; LOW; 26999 BLK MEADOW GLENDR; 844_A_1/154__178; Inc# 026473; Cmd: RVC CMD 8; Tac: RVC TAC 0; STN621AME621 M625; rp - DuraDescr: low bp   Pat Cnt: 1  Age: 63  Years  Sex: Male  Con: No  Breath: YesResp Script: You are responding to a patient with an unknown problem (mandown).  The  patient is a 63-year-old male, who is unconscious andbreathing. LIFE  STATUS QUESTIONABLE.",
        "CALL:MED, PERSON DOWN",
        "ADDR:53230 DOUBLE VIEW DR",
        "CITY:IDYLLWILD",
        "INFO:LOW / rp - DuraDescr: low bp   Pat Cnt: 1  Age: 63  Years  Sex: Male  Con: No  Breath: YesResp Script: You are responding to a patient with an unknown problem (mandown).  The  patient is a 63-year-old male, who is unconscious andbreathing. LIFE  STATUS QUESTIONABLE.",
        "X:26999 BLK MEADOW GLENDR",
        "MAP:844_A_1/154__178",
        "ID:026473",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:STN621AME621 M625");

    doTest("T58",
        "(Idyllwild Fire) MED, FALL; 54716 NORTH CIRCLE DR ,IDYL ; ; 54999 BLK RIVER DR; 814_D_6/154__132; Inc# 038397; Cmd: RVC CMD 8; Tac: RVC TAC 0; MT621; ba",
        "CALL:MED, FALL",
        "ADDR:54716 NORTH CIRCLE DR",
        "CITY:IDYLLWILD",
        "INFO:ba",
        "X:54999 BLK RIVER DR",
        "MAP:814_D_6/154__132",
        "ID:038397",
        "SRC:RVC CMD 8",
        "CH:RVC TAC 0",
        "UNIT:MT621");

  }
  
  public static void main(String[] args) {
    new CARiversideCountyParserTest().generateTests("T1");
  }
}