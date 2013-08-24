package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NC.NCDavidsonCountyAParser;

import org.junit.Test;

/***
Davidson County, NC
Contact: Rsk <rskbok09@yahoo.com>
Contact: "Zachary, Marcus M [CON]" <Marcus.Zachary@sprint.com>
Sender: cad@davidsoncountync.gov

CAD:50PD-MOTOR VEH/PD ONLY;3248 FRIENDSHIP LEDFORD RD;2010024643;SADDLECHASE LN;MOTSINGER RD;OIL AND FLUIDS ON ROADWAY [12/17/10 11:05:24 BHUGHES] UDTS: 
CAD:P29-TRAFFIC ACCIDENT-BRAVO;I 85 S/MM 99;2010024707;[Medical Priority Info] PROBLEM: traffic accident # PATS: 1 AGE: Unknown Range SEX: Unknown CONSCIOU
CAD:HOUSE/SINGLE DWELLING;3637 BECKS CHURCH RD;2010024363;HUCKLE PL;NC HWY 47;[Fire Priority Info] PROBLEM: KITCHEN FIRE [12/14/10 18:25:04 BPOOLE] [Fire P
CAD:P26-SICK-DELTA;4970 REID RD;2010024356;EASTVIEW DR;[Medical Priority Info] PROBLEM: SICK # PATS: 1 AGE: 78 Years SEX: Female CONSCIOUS: Yes BREATHING:
CAD:Co Fire Tac3 for call;I 85 S/MM 99; THA;7703351053
CAD:cancel further response;I 85 S/MM 99; THA;7703351053
CAD:P29-TRAFFIC ACCIDENT-BRAVO;I 85 S/MM 96;2010025333;unk on inj, near mm97 [12/26/10 09:57:18 CHUFF] JUST NORTH OF THE 96....UKN INJ
CAD:SMOKE INVESTIGATION;JOHNSONTOWN RD/TAFT HEDRICK RD;2010025211;no need for dispatch [12/25/2010 14:19:26 ASTILL]
CAD:P29-TRAFFIC ACCIDENT-BRAVO;I 85 N/MM 98;2010025251;[Medical Priority Info] PROBLEM: 10-50 # PATS: 255 AGE: Unknown Range SEX: Unkn
CAD:CANCEL;2006 JOHNSONTOWN RD; THA
CAD:Co Fire TAC4 for call;I 85 S/MM 96; LEX;4075477164

Contact: jon story <jstory2186@gmail.com>
CAD:Co Fire Tac3 for call;3136 MOCK RD; HP

Contact: Bradley Nations <bradley.nations@hollygrovefire.org>
  / CAD:Fire Under Control;N COUNTY HOME RD/BRIAR PATCH DR; LEX;3473996166\n
  / CAD:Co Fire Tac5 for call;I 85 S/MM 96; LEX;3367062145

Contact: Michael Beane <firefighter7539.mb@gmail.com>
TREE DOWN/FIRE;LICK CREEK CHURCH RD/NC HWY 8;2011016908;big tree plum across the road [08/20/11 08:28:05 JEVERHART] 2048 en route [08/20/11 08:33:44 JEVERH

Contact: jeff warner <fire73ems@gmail.com>
BCAD:P10-CHEST PAINS-CHARLIE;1125 WEAVER RD;2011018228;FROG POND DR;MEADOWVIEW RD;[Medical Priority Info] PROBLEM: CHEST PAIN 76YOM # PATS: 1 AGE: 76 SEX: M

Contact: Andrew King <aking.salisburyfire@gmail.com>
CAD:P6-BREATHING PROBLEMS-DELTA;2570 RIVERVIEW RD;2011020042;BLUE WATER PT;RIVERHOUSE RD;[Medical Priority Info] PROBLEM: DIFF BREATHING # PATS: 1 AGE: 72
CAD:P31-UNCONSCIOUS/FAINTING-DELTA;106 MT VISTA HEALTH PARK RD;MT VISTA HEALTH PARK;2012003042;S MAIN ST EXT;[Medical Priority Info] PROBLEM: uncon # PATS:
CAD:P1-ABDOMINAL PAINS-CHARLIE;15 E SALISBURY ST;ENERGY UNITED (DENTON);2012003053;S MAIN ST;GARNER ST;[Medical Priority Info] PROBLEM: stomach pains # PAT
CAD:TK65 TRANSPORT;207 OLD LEXINGTON RD;THOMASVILLE MEDICAL CENTER;FORD ST;HOSPITAL DR E;to Chapel Hill in the am [05/04/12 12:07:13 JEVERHART]

Contact: Active911
Agency name: Thomasville Fire Dept
Location: Thomasville, NC, United States
Sender: <CAD@davidsoncountync.gov>

CAD:P71A-VEH FIRE EXTINGUISHED;815 S NC HWY 109;THA;ST22/THOMASVILLE FD;2013014474;LIBERTY DR;LAMBETH RD;CALLER ADV FIRE IS OUT AT THIS TIME [07/19/13 22:34:28 MALLEN] CALLER ADV ITS ON 109 NEAR ST22 [07/19/13 22:33:51 MALLEN] [Fire Priorit
CAD:P52C-HIGH LIFE/STRUCT;17 HIGH TECH BLVD;THA;ADVANCED MOTORSPORTS COATINGS;2013014453;LAKE RD;[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: COMMERCIAL/INDUSTRIAL building (Waterflow/Sprinkler). 1. The caller is an alarm monito
CAD:P52B-ALARM;103 SUMMERS CT;THA;2013014450;RAEFORD CT;[Fire Priority Update] Fire Priority reconfigured event from to 52-B-01S. RESPONDER SCRIPT: Residential (single) (Smoke detector). 1. The caller is an alarm monitoring company. 2. It i
CAD:P52C-HIGH LIFE/STRUCT;550 CLONIGER DR;THA;UNILIN (QUICK STEP);2013014407;REGENCY INDUSTRIAL BLVD;[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: COMMERCIAL/INDUSTRIAL building (General/Fire). 1. The caller is an alarm monitorin
CAD:SMOKE INVESTIGATION;1107 LEXINGTON AV;THA;ST23/THOMASVILLE FD;PINEYWOOD RD;OLD LEXINGTON RD
CAD:P29-TRAFFIC ACCIDENT-BRAVO;1033 RANDOLPH ST;THA;SOUTHGATE PLAZA;2013014388;CLONIGER DR;LAURA LN;Aborted by Medical Priority with code: sdfg [07/18/13 17:08:51 JEVERHART] WHEN ASKED IF ROUTINE OR 10-18 ...HE JUST ADV PER THERE PROTOCAL [
CAD:FIRE-PUBLIC SERVICE;207 OLD LEXINGTON RD;THA;THOMASVILLE MEDICAL CENTER;2013014386;FORD ST;HOSPITAL DR E;NEED FD REF STANDBY FOR HELICOPTER, ALREADY ON GROUND [07/18/13 16:43:31 BSTOSS] Event spawned from 1063-INVESTIGATE/SUPPLEMENTAL. 
CAD:P52C-HIGH LIFE/STRUCT;1308 BLAIR ST;THA;EXCOPACK;2013014319;UNITY ST;PENNY RD;[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: COMMERCIAL/INDUSTRIAL building (General/Fire). 1. The caller is an alarm monitoring company. 2. It is
CAD:ILLEGAL BURN;202 JOHN MILLS LN;THA;JOHN THOMAS DR
CAD:P52C-HIGH LIFE/STRUCT;110-B BISH CT;THA;2013014301;TRINITY ST;[Fire Priority Info] Key Questions Complete RESPONSE: Charlie RESPONDER SCRIPT: 8. A single-level structure is involved. 9. It is not known what caused the alarm. 10. There a
CAD:ILLEGAL BURN;202 JOHN MILLS LN;THA;2013014302;JOHN THOMAS DR
CAD:P52C-HIGH LIFE/STRUCT;1200 UNITY ST;THA;IMAFLEX USA (TYCO PLASTICS);2013014287;NORFOLK SOUTHERN CRSG;BLAIR ST;[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: COMMERCIAL/INDUSTRIAL building (Waterflow/Sprinkler). 1. The caller i
CAD:FIRE-PUBLIC SERVICE;315 BREWER ST;THA;2013014270;CULBRETH AV;FAIRWAY AV;NEEDS SOMEONE TO UNPLUG STOVE [07/16/13 21:46:19 BHUGHES] CANT GET BURNER TURNED OFF ON STOVE [07/16/13 21:46:14 BHUGHES] NEED FIRE DEPT [07/16/13 21:45:42 BHUGHES]
CAD:P32-UNKNOWN/MAN DOWN-BRAVO;315 BREWER ST;THA;2013014270;CULBRETH AV;FAIRWAY AV;[EMS] elderly female [07/16/13 21:44:43 BHUGHES] [EMS] was patched through from northstate; female kept said she needed help and to send someone over there; 
CAD:P29-TRAFFIC ACCIDENT-BRAVO;1024-16 BLAIR ST;THA;2013014253;HODGES DR;CONRAD ST;[EMS] SUBJS WRECKED SCOOTER IN DRIVEWAY; ANKLE BLEEDING AND SO IS HER KNEE [07/16/13 17:48:00 BHUGHES] [Medical Priority Info] RESPONSE: Bravo RESPONDER SCRI
CAD:P29-TRAFFIC ACCIDENT-BRAVO;1024-16 BLAIR ST;THA;2013014253;HODGES DR;CONRAD ST;[EMS] SUBJS WRECKED SCOOTER IN DRIVEWAY; ANKLE BLEEDING AND SO IS HER KNEE [07/16/13 17:48:00 BHUGHES] [Medical Priority Info] RESPONSE: Bravo RESPONDER SCRI
CAD:{ENG24} Fire Nothing Showing;101 REDBUD LN; THA;3364063387 DIST: 57.53 ft
CAD:P69D6-HOUSE SINGLE RESIDENCE;101 REDBUD LN;THA;2013014199;HOWARD CIR;ASHE CT;UDTS: TFD Tac1 for the call [07/15/13 18:22:35 CBOWERS] [LAW] tpd adv [07/15/13 18:22:18 LWHITAKER] CALLER ADVISED TURNED ON A LIGHT SWITCH AND SAME APRKED AND
CAD:TFD Tac1 for the call;101 REDBUD LN; THA;3364063387 DIST: 57.53 ft
CAD:P69D6-HOUSE SINGLE RESIDENCE;101 REDBUD LN;THA;2013014199;HOWARD CIR;ASHE CT;[Fire Priority Info] Key Questions Complete RESPONSE: Delta RESPONDER SCRIPT: 6. No one is trapped inside the structure. 7. No one is reported to be injured. [

***/

public class NCDavidsonCountyAParserTest extends BaseParserTest {
  
  public NCDavidsonCountyAParserTest() {
    setParser(new NCDavidsonCountyAParser(), "DAVIDSON COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:50PD-MOTOR VEH/PD ONLY;3248 FRIENDSHIP LEDFORD RD;2010024643;SADDLECHASE LN;MOTSINGER RD;OIL AND FLUIDS ON ROADWAY [12/17/10 11:05:24 BHUGHES] UDTS: ",
        "CALL:50PD-MOTOR VEH/PD ONLY",
        "ADDR:3248 FRIENDSHIP LEDFORD RD",
        "ID:2010024643",
        "X:SADDLECHASE LN & MOTSINGER RD",
        "INFO:OIL AND FLUIDS ON ROADWAY / UDTS:",
        "DATE:12/17/10",
        "TIME:11:05:24");

    doTest("T2",
        "CAD:P29-TRAFFIC ACCIDENT-BRAVO;I 85 S/MM 99;2010024707;[Medical Priority Info] PROBLEM: traffic accident # PATS: 1 AGE: Unknown Range SEX: Unknown CONSCIOU",
        "CALL:P29-TRAFFIC ACCIDENT-BRAVO",
        "ADDR:I 85 S & MM 99",
        "ID:2010024707",
        "INFO:traffic accident # PATS: 1 AGE: Unknown Range SEX: Unknown CONSCIOU");

    doTest("T3",
        "CAD:HOUSE/SINGLE DWELLING;3637 BECKS CHURCH RD;2010024363;HUCKLE PL;NC HWY 47;[Fire Priority Info] PROBLEM: KITCHEN FIRE [12/14/10 18:25:04 BPOOLE] [Fire P",
        "CALL:HOUSE/SINGLE DWELLING",
        "ADDR:3637 BECKS CHURCH RD",
        "ID:2010024363",
        "X:HUCKLE PL & NC HWY 47",
        "INFO:KITCHEN FIRE",
        "DATE:12/14/10",
        "TIME:18:25:04");

    doTest("T4",
        "CAD:P26-SICK-DELTA;4970 REID RD;2010024356;EASTVIEW DR;[Medical Priority Info] PROBLEM: SICK # PATS: 1 AGE: 78 Years SEX: Female CONSCIOUS: Yes BREATHING:",
        "CALL:P26-SICK-DELTA",
        "ADDR:4970 REID RD",
        "ID:2010024356",
        "X:EASTVIEW DR",
        "INFO:SICK # PATS: 1 AGE: 78 Years SEX: Female CONSCIOUS: Yes BREATHING:");

    doTest("T5",
        "CAD:Co Fire Tac3 for call;I 85 S/MM 99; THA;7703351053",
        "CALL:Co Fire Tac3 for call",
        "ADDR:I 85 S & MM 99",
        "CITY:THOMASVILLE",
        "ID:7703351053");

    doTest("T6",
        "CAD:cancel further response;I 85 S/MM 99; THA;7703351053",
        "CALL:cancel further response",
        "ADDR:I 85 S & MM 99",
        "CITY:THOMASVILLE",
        "ID:7703351053");

    doTest("T7",
        "CAD:P29-TRAFFIC ACCIDENT-BRAVO;I 85 S/MM 96;2010025333;unk on inj, near mm97 [12/26/10 09:57:18 CHUFF] JUST NORTH OF THE 96....UKN INJ",
        "CALL:P29-TRAFFIC ACCIDENT-BRAVO",
        "ADDR:I 85 S & MM 96",
        "ID:2010025333",
        "INFO:unk on inj, near mm97 / JUST NORTH OF THE 96....UKN INJ",
        "DATE:12/26/10",
        "TIME:09:57:18");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "CAD:SMOKE INVESTIGATION;JOHNSONTOWN RD/TAFT HEDRICK RD;2010025211;no need for dispatch [12/25/2010 14:19:26 ASTILL]",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:JOHNSONTOWN RD & TAFT HEDRICK RD",
        "ID:2010025211",
        "INFO:no need for dispatch",
        "DATE:12/25/2010",
        "TIME:14:19:26");

    doTest("T2",
        "CAD:P29-TRAFFIC ACCIDENT-BRAVO;I 85 N/MM 98;2010025251;[Medical Priority Info] PROBLEM: 10-50 # PATS: 255 AGE: Unknown Range SEX: Unkn",
        "CALL:P29-TRAFFIC ACCIDENT-BRAVO",
        "ADDR:I 85 N & MM 98",
        "ID:2010025251",
        "INFO:10-50 # PATS: 255 AGE: Unknown Range SEX: Unkn");

    doTest("T3",
        "CAD:CANCEL;2006 JOHNSONTOWN RD; THA",
        "CALL:CANCEL",
        "ADDR:2006 JOHNSONTOWN RD",
        "CITY:THOMASVILLE");

    doTest("T4",
        "CAD:Co Fire TAC4 for call;I 85 S/MM 96; LEX;4075477164",
        "CALL:Co Fire TAC4 for call",
        "ADDR:I 85 S & MM 96",
        "CITY:LEXINGTON",
        "ID:4075477164");

    doTest("T5",
        "CAD:Co Fire Tac3 for call;3136 MOCK RD; HP",
        "CALL:Co Fire Tac3 for call",
        "ADDR:3136 MOCK RD",
        "CITY:HIGH POINT");

    doTest("T6",
        "  / CAD:Fire Under Control;N COUNTY HOME RD/BRIAR PATCH DR; LEX;3473996166\n",
        "CALL:Fire Under Control",
        "ADDR:N COUNTY HOME RD & BRIAR PATCH DR",
        "CITY:LEXINGTON",
        "ID:3473996166");

    doTest("T7",
        "  / CAD:Co Fire Tac5 for call;I 85 S/MM 96; LEX;3367062145",
        "CALL:Co Fire Tac5 for call",
        "ADDR:I 85 S & MM 96",
        "CITY:LEXINGTON",
        "ID:3367062145");

    doTest("T8",
        "TREE DOWN/FIRE;LICK CREEK CHURCH RD/NC HWY 8;2011016908;big tree plum across the road [08/20/11 08:28:05 JEVERHART] 2048 en route [08/20/11 08:33:44 JEVERH",
        "CALL:TREE DOWN/FIRE",
        "ADDR:LICK CREEK CHURCH RD & NC HWY 8",
        "MADDR:LICK CREEK CHURCH RD & STATE 8",
        "ID:2011016908",
        "INFO:big tree plum across the road / 2048 en route",
        "DATE:08/20/11",
        "TIME:08:28:05");

    doTest("T9",
        "BCAD:P10-CHEST PAINS-CHARLIE;1125 WEAVER RD;2011018228;FROG POND DR;MEADOWVIEW RD;[Medical Priority Info] PROBLEM: CHEST PAIN 76YOM # PATS: 1 AGE: 76 SEX: M",
        "CALL:BCAD:P10-CHEST PAINS-CHARLIE",
        "ADDR:1125 WEAVER RD",
        "ID:2011018228",
        "X:FROG POND DR & MEADOWVIEW RD",
        "INFO:CHEST PAIN 76YOM # PATS: 1 AGE: 76 SEX: M");

    doTest("T10",
        "CAD:P6-BREATHING PROBLEMS-DELTA;2570 RIVERVIEW RD;2011020042;BLUE WATER PT;RIVERHOUSE RD;[Medical Priority Info] PROBLEM: DIFF BREATHING # PATS: 1 AGE: 72",
        "CALL:P6-BREATHING PROBLEMS-DELTA",
        "ADDR:2570 RIVERVIEW RD",
        "ID:2011020042",
        "INFO:BLUE WATER PT / RIVERHOUSE RD / DIFF BREATHING # PATS: 1 AGE: 72");

    doTest("T11",
        "CAD:P31-UNCONSCIOUS/FAINTING-DELTA;106 MT VISTA HEALTH PARK RD;MT VISTA HEALTH PARK;2012003042;S MAIN ST EXT;[Medical Priority Info] PROBLEM: uncon # PATS:",
        "CALL:P31-UNCONSCIOUS/FAINTING-DELTA",
        "ADDR:106 MT VISTA HEALTH PARK RD",
        "PLACE:MT VISTA HEALTH PARK",
        "ID:2012003042",
        "X:S MAIN ST EXT",
        "INFO:uncon # PATS:");

    doTest("T12",
        "CAD:P1-ABDOMINAL PAINS-CHARLIE;15 E SALISBURY ST;ENERGY UNITED (DENTON);2012003053;S MAIN ST;GARNER ST;[Medical Priority Info] PROBLEM: stomach pains # PAT",
        "CALL:P1-ABDOMINAL PAINS-CHARLIE",
        "ADDR:15 E SALISBURY ST",
        "PLACE:ENERGY UNITED (DENTON)",
        "ID:2012003053",
        "X:S MAIN ST & GARNER ST",
        "INFO:stomach pains # PAT");

    doTest("T13",
        "CAD:TK65 TRANSPORT;207 OLD LEXINGTON RD;THOMASVILLE MEDICAL CENTER;FORD ST;HOSPITAL DR E;to Chapel Hill in the am [05/04/12 12:07:13 JEVERHART]",
        "CALL:TK65 TRANSPORT",
        "ADDR:207 OLD LEXINGTON RD",
        "PLACE:THOMASVILLE MEDICAL CENTER",
        "X:FORD ST & HOSPITAL DR E",
        "INFO:to Chapel Hill in the am",
        "DATE:05/04/12",
        "TIME:12:07:13");
  }
  
  @Test
  public void testThomasvilleFireDept() {

    doTest("T1",
        "CAD:P71A-VEH FIRE EXTINGUISHED;815 S NC HWY 109;THA;ST22/THOMASVILLE FD;2013014474;LIBERTY DR;LAMBETH RD;CALLER ADV FIRE IS OUT AT THIS TIME [07/19/13 22:34:28 MALLEN] CALLER ADV ITS ON 109 NEAR ST22 [07/19/13 22:33:51 MALLEN] [Fire Priorit",
        "CALL:P71A-VEH FIRE EXTINGUISHED",
        "ADDR:815 S NC HWY 109",
        "MADDR:815 S STATE 109",
        "CITY:THOMASVILLE",
        "PLACE:ST22/THOMASVILLE FD",
        "ID:2013014474",
        "X:LIBERTY DR & LAMBETH RD",
        "INFO:CALLER ADV FIRE IS OUT AT THIS TIME / CALLER ADV ITS ON 109 NEAR ST22",
        "DATE:07/19/13",
        "TIME:22:34:28");

    doTest("T2",
        "CAD:P52C-HIGH LIFE/STRUCT;17 HIGH TECH BLVD;THA;ADVANCED MOTORSPORTS COATINGS;2013014453;LAKE RD;[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: COMMERCIAL/INDUSTRIAL building (Waterflow/Sprinkler). 1. The caller is an alarm monito",
        "CALL:P52C-HIGH LIFE/STRUCT",
        "ADDR:17 HIGH TECH BLVD",
        "CITY:THOMASVILLE",
        "PLACE:ADVANCED MOTORSPORTS COATINGS",
        "ID:2013014453",
        "X:LAKE RD",
        "INFO:COMMERCIAL/INDUSTRIAL building (Waterflow/Sprinkler). 1. The caller is an alarm monito");

    doTest("T3",
        "CAD:P52B-ALARM;103 SUMMERS CT;THA;2013014450;RAEFORD CT;[Fire Priority Update] Fire Priority reconfigured event from to 52-B-01S. RESPONDER SCRIPT: Residential (single) (Smoke detector). 1. The caller is an alarm monitoring company. 2. It i",
        "CALL:P52B-ALARM",
        "ADDR:103 SUMMERS CT",
        "CITY:THOMASVILLE",
        "ID:2013014450",
        "X:RAEFORD CT",
        "INFO:Fire Priority reconfigured event from to 52-B-01S. RESPONDER SCRIPT: Residential (single) (Smoke detector). 1. The caller is an alarm monitoring company. 2. It i");

    doTest("T4",
        "CAD:P52C-HIGH LIFE/STRUCT;550 CLONIGER DR;THA;UNILIN (QUICK STEP);2013014407;REGENCY INDUSTRIAL BLVD;[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: COMMERCIAL/INDUSTRIAL building (General/Fire). 1. The caller is an alarm monitorin",
        "CALL:P52C-HIGH LIFE/STRUCT",
        "ADDR:550 CLONIGER DR",
        "CITY:THOMASVILLE",
        "PLACE:UNILIN (QUICK STEP)",
        "ID:2013014407",
        "X:REGENCY INDUSTRIAL BLVD",
        "INFO:COMMERCIAL/INDUSTRIAL building (General/Fire). 1. The caller is an alarm monitorin");

    doTest("T5",
        "CAD:SMOKE INVESTIGATION;1107 LEXINGTON AV;THA;ST23/THOMASVILLE FD;PINEYWOOD RD;OLD LEXINGTON RD",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:1107 LEXINGTON AV",
        "MADDR:1107 LEXINGTON AVE",
        "CITY:THOMASVILLE",
        "PLACE:ST23/THOMASVILLE FD",
        "X:PINEYWOOD RD & OLD LEXINGTON RD");

    doTest("T6",
        "CAD:P29-TRAFFIC ACCIDENT-BRAVO;1033 RANDOLPH ST;THA;SOUTHGATE PLAZA;2013014388;CLONIGER DR;LAURA LN;Aborted by Medical Priority with code: sdfg [07/18/13 17:08:51 JEVERHART] WHEN ASKED IF ROUTINE OR 10-18 ...HE JUST ADV PER THERE PROTOCAL [",
        "CALL:P29-TRAFFIC ACCIDENT-BRAVO",
        "ADDR:1033 RANDOLPH ST",
        "CITY:THOMASVILLE",
        "PLACE:SOUTHGATE PLAZA",
        "ID:2013014388",
        "X:CLONIGER DR & LAURA LN",
        "INFO:Aborted by Medical Priority with code: sdfg / WHEN ASKED IF ROUTINE OR 10-18 ...HE JUST ADV PER THERE PROTOCAL",
        "DATE:07/18/13",
        "TIME:17:08:51");

    doTest("T7",
        "CAD:FIRE-PUBLIC SERVICE;207 OLD LEXINGTON RD;THA;THOMASVILLE MEDICAL CENTER;2013014386;FORD ST;HOSPITAL DR E;NEED FD REF STANDBY FOR HELICOPTER, ALREADY ON GROUND [07/18/13 16:43:31 BSTOSS] Event spawned from 1063-INVESTIGATE/SUPPLEMENTAL. ",
        "CALL:FIRE-PUBLIC SERVICE",
        "ADDR:207 OLD LEXINGTON RD",
        "CITY:THOMASVILLE",
        "PLACE:THOMASVILLE MEDICAL CENTER",
        "ID:2013014386",
        "X:FORD ST & HOSPITAL DR E",
        "INFO:NEED FD REF STANDBY FOR HELICOPTER, ALREADY ON GROUND / Event spawned from 1063-INVESTIGATE/SUPPLEMENTAL.",
        "DATE:07/18/13",
        "TIME:16:43:31");

    doTest("T8",
        "CAD:P52C-HIGH LIFE/STRUCT;1308 BLAIR ST;THA;EXCOPACK;2013014319;UNITY ST;PENNY RD;[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: COMMERCIAL/INDUSTRIAL building (General/Fire). 1. The caller is an alarm monitoring company. 2. It is",
        "CALL:P52C-HIGH LIFE/STRUCT",
        "ADDR:1308 BLAIR ST",
        "CITY:THOMASVILLE",
        "PLACE:EXCOPACK",
        "ID:2013014319",
        "X:UNITY ST & PENNY RD",
        "INFO:COMMERCIAL/INDUSTRIAL building (General/Fire). 1. The caller is an alarm monitoring company. 2. It is");

    doTest("T9",
        "CAD:ILLEGAL BURN;202 JOHN MILLS LN;THA;JOHN THOMAS DR",
        "CALL:ILLEGAL BURN",
        "ADDR:202 JOHN MILLS LN",
        "CITY:THOMASVILLE",
        "X:JOHN THOMAS DR");

    doTest("T10",
        "CAD:P52C-HIGH LIFE/STRUCT;110-B BISH CT;THA;2013014301;TRINITY ST;[Fire Priority Info] Key Questions Complete RESPONSE: Charlie RESPONDER SCRIPT: 8. A single-level structure is involved. 9. It is not known what caused the alarm. 10. There a",
        "CALL:P52C-HIGH LIFE/STRUCT",
        "ADDR:110-B BISH CT",
        "MADDR:110 BISH CT",
        "CITY:THOMASVILLE",
        "ID:2013014301",
        "X:TRINITY ST",
        "INFO:8. A single-level structure is involved. 9. It is not known what caused the alarm. 10. There a");

    doTest("T11",
        "CAD:ILLEGAL BURN;202 JOHN MILLS LN;THA;2013014302;JOHN THOMAS DR",
        "CALL:ILLEGAL BURN",
        "ADDR:202 JOHN MILLS LN",
        "CITY:THOMASVILLE",
        "ID:2013014302",
        "X:JOHN THOMAS DR");

    doTest("T12",
        "CAD:P52C-HIGH LIFE/STRUCT;1200 UNITY ST;THA;IMAFLEX USA (TYCO PLASTICS);2013014287;NORFOLK SOUTHERN CRSG;BLAIR ST;[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: COMMERCIAL/INDUSTRIAL building (Waterflow/Sprinkler). 1. The caller i",
        "CALL:P52C-HIGH LIFE/STRUCT",
        "ADDR:1200 UNITY ST",
        "CITY:THOMASVILLE",
        "PLACE:IMAFLEX USA (TYCO PLASTICS)",
        "ID:2013014287",
        "INFO:NORFOLK SOUTHERN CRSG / BLAIR ST / COMMERCIAL/INDUSTRIAL building (Waterflow/Sprinkler). 1. The caller i");

    doTest("T13",
        "CAD:FIRE-PUBLIC SERVICE;315 BREWER ST;THA;2013014270;CULBRETH AV;FAIRWAY AV;NEEDS SOMEONE TO UNPLUG STOVE [07/16/13 21:46:19 BHUGHES] CANT GET BURNER TURNED OFF ON STOVE [07/16/13 21:46:14 BHUGHES] NEED FIRE DEPT [07/16/13 21:45:42 BHUGHES]",
        "CALL:FIRE-PUBLIC SERVICE",
        "ADDR:315 BREWER ST",
        "CITY:THOMASVILLE",
        "ID:2013014270",
        "X:CULBRETH AV & FAIRWAY AV",
        "INFO:NEEDS SOMEONE TO UNPLUG STOVE / CANT GET BURNER TURNED OFF ON STOVE / NEED FIRE DEPT",
        "DATE:07/16/13",
        "TIME:21:46:19");

    doTest("T14",
        "CAD:P32-UNKNOWN/MAN DOWN-BRAVO;315 BREWER ST;THA;2013014270;CULBRETH AV;FAIRWAY AV;[EMS] elderly female [07/16/13 21:44:43 BHUGHES] [EMS] was patched through from northstate; female kept said she needed help and to send someone over there; ",
        "CALL:P32-UNKNOWN/MAN DOWN-BRAVO",
        "ADDR:315 BREWER ST",
        "CITY:THOMASVILLE",
        "ID:2013014270",
        "X:CULBRETH AV & FAIRWAY AV",
        "INFO:elderly female / was patched through from northstate / female kept said she needed help and to send someone over there",
        "DATE:07/16/13",
        "TIME:21:44:43");

    doTest("T15",
        "CAD:P29-TRAFFIC ACCIDENT-BRAVO;1024-16 BLAIR ST;THA;2013014253;HODGES DR;CONRAD ST;[EMS] SUBJS WRECKED SCOOTER IN DRIVEWAY; ANKLE BLEEDING AND SO IS HER KNEE [07/16/13 17:48:00 BHUGHES] [Medical Priority Info] RESPONSE: Bravo RESPONDER SCRI",
        "CALL:P29-TRAFFIC ACCIDENT-BRAVO",
        "ADDR:1024-16 BLAIR ST",
        "MADDR:1024 BLAIR ST",
        "CITY:THOMASVILLE",
        "ID:2013014253",
        "X:HODGES DR & CONRAD ST",
        "INFO:SUBJS WRECKED SCOOTER IN DRIVEWAY / ANKLE BLEEDING AND SO IS HER KNEE",
        "DATE:07/16/13",
        "TIME:17:48:00");

    doTest("T16",
        "CAD:P29-TRAFFIC ACCIDENT-BRAVO;1024-16 BLAIR ST;THA;2013014253;HODGES DR;CONRAD ST;[EMS] SUBJS WRECKED SCOOTER IN DRIVEWAY; ANKLE BLEEDING AND SO IS HER KNEE [07/16/13 17:48:00 BHUGHES] [Medical Priority Info] RESPONSE: Bravo RESPONDER SCRI",
        "CALL:P29-TRAFFIC ACCIDENT-BRAVO",
        "ADDR:1024-16 BLAIR ST",
        "MADDR:1024 BLAIR ST",
        "CITY:THOMASVILLE",
        "ID:2013014253",
        "X:HODGES DR & CONRAD ST",
        "INFO:SUBJS WRECKED SCOOTER IN DRIVEWAY / ANKLE BLEEDING AND SO IS HER KNEE",
        "DATE:07/16/13",
        "TIME:17:48:00");

    doTest("T17",
        "CAD:{ENG24} Fire Nothing Showing;101 REDBUD LN; THA;3364063387 DIST: 57.53 ft",
        "CALL:{ENG24} Fire Nothing Showing",
        "ADDR:101 REDBUD LN",
        "CITY:THOMASVILLE",
        "INFO:3364063387 DIST: 57.53 ft");

    doTest("T18",
        "CAD:P69D6-HOUSE SINGLE RESIDENCE;101 REDBUD LN;THA;2013014199;HOWARD CIR;ASHE CT;UDTS: TFD Tac1 for the call [07/15/13 18:22:35 CBOWERS] [LAW] tpd adv [07/15/13 18:22:18 LWHITAKER] CALLER ADVISED TURNED ON A LIGHT SWITCH AND SAME APRKED AND",
        "CALL:P69D6-HOUSE SINGLE RESIDENCE",
        "ADDR:101 REDBUD LN",
        "CITY:THOMASVILLE",
        "ID:2013014199",
        "X:HOWARD CIR & ASHE CT",
        "INFO:UDTS: TFD Tac1 for the call / tpd adv / CALLER ADVISED TURNED ON A LIGHT SWITCH AND SAME APRKED AND",
        "DATE:07/15/13",
        "TIME:18:22:35");

    doTest("T19",
        "CAD:TFD Tac1 for the call;101 REDBUD LN; THA;3364063387 DIST: 57.53 ft",
        "CALL:TFD Tac1 for the call",
        "ADDR:101 REDBUD LN",
        "CITY:THOMASVILLE",
        "INFO:3364063387 DIST: 57.53 ft");

    doTest("T20",
        "CAD:P69D6-HOUSE SINGLE RESIDENCE;101 REDBUD LN;THA;2013014199;HOWARD CIR;ASHE CT;[Fire Priority Info] Key Questions Complete RESPONSE: Delta RESPONDER SCRIPT: 6. No one is trapped inside the structure. 7. No one is reported to be injured. [",
        "CALL:P69D6-HOUSE SINGLE RESIDENCE",
        "ADDR:101 REDBUD LN",
        "CITY:THOMASVILLE",
        "ID:2013014199",
        "X:HOWARD CIR & ASHE CT",
        "INFO:6. No one is trapped inside the structure. 7. No one is reported to be injured.");

  }
  
  public static void main(String[] args) {
    new NCDavidsonCountyAParserTest().generateTests("T1");
  }
}
