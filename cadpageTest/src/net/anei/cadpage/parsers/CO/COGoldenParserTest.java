package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class COGoldenParserTest extends BaseParserTest {
  
  public COGoldenParserTest() {
    setParser(new COGoldenParser(), "GOLDEN", "CO");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(Golden Fire) Call#: 122230024*                                                               \n\n" +
        "Time: 08:25:36*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 1270 N FORD ST, GOLDEN*                                               \n\n" +
        "Cross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: in dining room/ poss stroke or heart attack                          \n\n" +
        "not responsive/                                                                 \n\n" +
        "born 19254                                                                      \n\n" +
        "is c but not resp/ is b/*                                                       \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122230024",
        "TIME:08:25:36",
        "CALL:Ambulance and Rescue",
        "ADDR:1270 N FORD ST",
        "CITY:GOLDEN",
        "X:PINE RIDGE RD/ VIRGINIA ST",
        "UNIT:DIST1 DIST2",
        "INFO:in dining room/ poss stroke or heart attack\nnot responsive/\nborn 19254\nis c but not resp/ is b/");

    doTest("T2",
        "(Golden Fire) Call#: 122230095*                                                               \n\n" +
        "Time: 16:53:33*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 1030 JOHNSON RD U200, GOLDEN*                                         \n\n" +
        "Cross streets: W 10TH AVE/W 14TH AVE*                                           \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: high bp / numbless and tingling                                      \n\n" +
        "approx 80's female                                                              \n\n" +
        "cannot move one side / poss stroke                                              \n\n" +
        "no doc on scene*                                                                \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122230095",
        "TIME:16:53:33",
        "CALL:Ambulance and Rescue",
        "ADDR:1030 JOHNSON RD U200",
        "CITY:GOLDEN",
        "X:W 10TH AVE/W 14TH AVE",
        "UNIT:DIST1 DIST2",
        "INFO:high bp / numbless and tingling\napprox 80's female\ncannot move one side / poss stroke\nno doc on scene");

    doTest("T3",
        "(Golden Fire) Call#: 122230107*                                                               \n\n" +
        "Time: 18:19:55*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 2011 WASHINGTON AVE, GOLDEN*                                          \n\n" +
        "Cross streets: 20TH ST/ WASHINGTON CIR*                                         \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: elderly fem, diff breathing                                          \n\n" +
        "82 pulse ox                                                                     \n\n" +
        "dehydrated                                                                      \n\n" +
        "is con*                                                                         \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122230107",
        "TIME:18:19:55",
        "CALL:Ambulance and Rescue",
        "ADDR:2011 WASHINGTON AVE",
        "CITY:GOLDEN",
        "X:20TH ST/ WASHINGTON CIR",
        "UNIT:DIST1 DIST2",
        "INFO:elderly fem, diff breathing\n82 pulse ox\ndehydrated\nis con");

    doTest("T4",
        "(Golden Fire) Call#: 122230113*                                                               \n\n" +
        "Time: 19:29:45*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 1908 PINAL RD, GOLDEN*                                                \n\n" +
        "Cross streets: MT ZION DR/ SMITH RD*                                            \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: rp's husband poss having a heart attack                              \n\n" +
        "husband went to store                                                           \n\n" +
        "rp has parkinson's, hard to understand                                          \n\n" +
        "so neighbor is on scene trying to \"translate\"*                                  \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122230113",
        "TIME:19:29:45",
        "CALL:Ambulance and Rescue",
        "ADDR:1908 PINAL RD",
        "CITY:GOLDEN",
        "X:MT ZION DR/ SMITH RD",
        "UNIT:DIST1 DIST2",
        "INFO:rp's husband poss having a heart attack\nhusband went to store\nrp has parkinson's, hard to understand\nso neighbor is on scene trying to \"translate\"");

    doTest("T5",
        "(Golden Fire) Call#: 122230116*                                                               \n\n" +
        "Time: 19:31:53*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 531 SOMERSET DR, GOLDEN*                                              \n\n" +
        "Cross streets: CHELAN ST/ EAGLE RIDGE DR*                                       \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: wife is 43 / unc but breathing                                       \n\n" +
        "unk how many pills / last 15 minutes                                            \n\n" +
        "sleeping pills                                                                  \n\n" +
        "intentional od*                                                                 \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122230116",
        "TIME:19:31:53",
        "CALL:Ambulance and Rescue",
        "ADDR:531 SOMERSET DR",
        "CITY:GOLDEN",
        "X:CHELAN ST/ EAGLE RIDGE DR",
        "UNIT:DIST1 DIST2",
        "INFO:wife is 43 / unc but breathing\nunk how many pills / last 15 minutes\nsleeping pills\nintentional od");

    doTest("T6",
        "(Golden Fire) Call#: 122240049*                                                               \n\n" +
        "Time: 11:29:38*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 517 15TH ST A2, GOLDEN*                                               \n\n" +
        "Cross streets: EAST ST/ FORD ST*                                                \n\n" +
        "*                                                                               \n\n" +
        "Narrative: poss stroke 55 yof                                                   \n\n" +
        "acting unu                                                                      \n\n" +
        "not con / breathing                                                             \n\n" +
        "poss just out of it                                                             \n\n" +
        "cannot call rp back / phone disconnected*                                       \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122240049",
        "TIME:11:29:38",
        "CALL:Ambulance and Rescue",
        "ADDR:517 15TH ST A2",
        "CITY:GOLDEN",
        "X:EAST ST/ FORD ST",
        "INFO:poss stroke 55 yof\nacting unu\nnot con / breathing\nposs just out of it\ncannot call rp back / phone disconnected");

    doTest("T7",
        "(Golden Fire) Call#: 122240086*                                                               \n\n" +
        "Time: 16:50:13*                                                                 \n\n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n\n" +
        "Location: 824 MARSTON TRL, GOLDEN*                                              \n\n" +
        "Cross streets: EAGLE RIDGE DR/ EAGLE RIDGE DR*                                  \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: ind/entire house                                                     \n\n" +
        "premise 720-771-0383 / nam/seibert*                                             \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122240086",
        "TIME:16:50:13",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:824 MARSTON TRL",
        "CITY:GOLDEN",
        "X:EAGLE RIDGE DR/ EAGLE RIDGE DR",
        "UNIT:DIST1 DIST2",
        "INFO:ind/entire house\npremise 720-771-0383 / nam/seibert");

    doTest("T8",
        "(Golden Fire) Call#: 122240102*                                                               \n\n" +
        "Time: 18:46:45*                                                                 \n\n" +
        "Type of call: Fire code/fire ordinance violation*                               \n\n" +
        "Location: BRIDGE WASH, 1030 WASHINGTON AVE, GOLDEN*                             \n\n" +
        "Cross streets: 10TH ST/ 11TH ST*                                                \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: respond via foot; sml bonfire just smoldering                        \n\n" +
        "pd on scene                                                                     \n\n" +
        "east of slide on north side of creek*                                           \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122240102",
        "TIME:18:46:45",
        "CALL:Fire code/fire ordinance violation",
        "PLACE:BRIDGE WASH",
        "ADDR:1030 WASHINGTON AVE",
        "CITY:GOLDEN",
        "X:10TH ST/ 11TH ST",
        "UNIT:DIST1 DIST2",
        "INFO:respond via foot; sml bonfire just smoldering\npd on scene\neast of slide on north side of creek");

    doTest("T9",
        "(Golden Fire) Call#: 122250065*                                                               \n\n" +
        "Time: 13:58:26*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: WHITE WATER KAYAK PARK, 1201 10TH ST, GOLDEN*                         \n\n" +
        "Cross streets: MAPLE ST/ MAPLE ST*                                              \n\n" +
        "Units: AMR131 DIST1 DIST2*                                                      \n\n" +
        "Narrative: male dislocated shoulder while kayaking                              \n\n" +
        "in a lot of pain                                                                \n\n" +
        "dizzy, but is con                                                               \n\n" +
        "breathing                                                                       \n\n" +
        "fem w/ rhodesian ridgeback dog will                                             \n\n" +
        "flag down amb*                                                                  \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122250065",
        "TIME:13:58:26",
        "CALL:Ambulance and Rescue",
        "PLACE:WHITE WATER KAYAK PARK",
        "ADDR:1201 10TH ST",
        "CITY:GOLDEN",
        "X:MAPLE ST/ MAPLE ST",
        "UNIT:AMR131 DIST1 DIST2",
        "INFO:male dislocated shoulder while kayaking\nin a lot of pain\ndizzy, but is con\nbreathing\nfem w/ rhodesian ridgeback dog will\nflag down amb");

    doTest("T10",
        "(Golden Fire) Call#: 122250086*                                                               \n\n" +
        "Time: 16:58:15*                                                                 \n\n" +
        "Type of call: Canyon Call*                                                      \n\n" +
        "Location: CCC AT 261, 261 HWY 6 MM, GOLDEN*                                     \n\n" +
        "Cross streets: HWY 93/ HWY 119*                                                 \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: one vehicle accident, unk injuries                                   \n\n" +
        "csp en rt*                                                                      \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122250086",
        "TIME:16:58:15",
        "CALL:Canyon Call",
        "PLACE:CCC AT 261",
        "ADDR:261 HWY 6 MM",
        "CITY:GOLDEN",
        "X:HWY 93/ HWY 119",
        "UNIT:DIST1 DIST2",
        "INFO:one vehicle accident, unk injuries\ncsp en rt");

    doTest("T11",
        "(Golden Fire) Call#: 122250102*                                                               \n\n" +
        "Time: 18:54:52*                                                                 \n\n" +
        "Type of call: Structure Fire (11)*                                              \n\n" +
        "Location: 318 ALLEN ST, GOLDEN*                                                 \n\n" +
        "Cross streets: KIMBALL AVE/ KIMBALL AVE*                                        \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: bbq caught on fire                                                   \n\n" +
        "poss structures in danger                                                       \n\n" +
        "house                                                                           \n\n" +
        "propane bbq*                                                                    \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122250102",
        "TIME:18:54:52",
        "CALL:Structure Fire (11)",
        "ADDR:318 ALLEN ST",
        "CITY:GOLDEN",
        "X:KIMBALL AVE/ KIMBALL AVE",
        "UNIT:DIST1 DIST2",
        "INFO:bbq caught on fire\nposs structures in danger\nhouse\npropane bbq");

    doTest("T12",
        "(Golden Fire) Call#: 122250109*                                                               \n\n" +
        "Time: 20:14:08*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 262 MARBLE CIR, GOLDEN*                                               \n\n" +
        "Cross streets: DEER ST/ PINECONE ST*                                            \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: chest pains                                                          \n\n" +
        "no responding                                                                   \n\n" +
        "61 yo/m                                                                         \n\n" +
        "uncon/diff breathing*                                                           \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122250109",
        "TIME:20:14:08",
        "CALL:Ambulance and Rescue",
        "ADDR:262 MARBLE CIR",
        "CITY:GOLDEN",
        "X:DEER ST/ PINECONE ST",
        "UNIT:DIST1 DIST2",
        "INFO:chest pains\nno responding\n61 yo/m\nuncon/diff breathing");

    doTest("T13",
        "(Golden Fire) Call#: 122250116*                                                               \n\n" +
        "Time: 21:33:43*                                                                 \n\n" +
        "Type of call: Unknown Injury Traffic Accident*                                  \n\n" +
        "Location: HWY 6/W COLFAX AVE, GOLDEN*                                           \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: 3 veh's*                                                             \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122250116",
        "TIME:21:33:43",
        "CALL:Unknown Injury Traffic Accident",
        "ADDR:HWY 6 & W COLFAX AVE",
        "CITY:GOLDEN",
        "UNIT:DIST1 DIST2",
        "INFO:3 veh's");

    doTest("T14",
        "(Golden Fire) Call#: 122260016*                                                               \n\n" +
        "Time: 07:28:50*                                                                 \n\n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n\n" +
        "Location: 1310 WASHINGTON AVE, GOLDEN*                                          \n\n" +
        "Cross streets: 13TH ST/ 14TH ST*                                                \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: gen fire*                                                            \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122260016",
        "TIME:07:28:50",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:1310 WASHINGTON AVE",
        "CITY:GOLDEN",
        "X:13TH ST/ 14TH ST",
        "UNIT:DIST1 DIST2",
        "INFO:gen fire");

    doTest("T15",
        "(Golden Fire) Call#: 122260058*                                                               \n\n" +
        "Time: 14:41:09*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: ALPINE SLIDE 101, 18301 W COLFAX AVE U101, GOLDEN*                    \n\n" +
        "Cross streets: W COLFAX AVE/ HERITAGE RD*                                       \n\n" +
        "Units: AMR132 DIST1 DIST2*                                                      \n\n" +
        "Narrative: emp poss drug reaction                                               \n\n" +
        "emp at the top of mtn                                                           \n\n" +
        "17 yom c/b                                                                      \n\n" +
        "unk what he took*                                                               \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122260058",
        "TIME:14:41:09",
        "CALL:Ambulance and Rescue",
        "PLACE:ALPINE SLIDE 101",
        "ADDR:18301 W COLFAX AVE U101",
        "CITY:GOLDEN",
        "X:W COLFAX AVE/ HERITAGE RD",
        "UNIT:AMR132 DIST1 DIST2",
        "INFO:emp poss drug reaction\nemp at the top of mtn\n17 yom c/b\nunk what he took");

    doTest("T16",
        "(Golden Fire) Call#: 122260085*                                                               \n\n" +
        "Time: 19:03:41*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 423 CANYON POINT CIR, GOLDEN*                                         \n\n" +
        "Cross streets: MAGPIE CT/ VALLEY VIEW CT*                                       \n\n" +
        "Units: AMR131 DIST1 DIST2*                                                      \n\n" +
        "Narrative: poss partial choking                                                 \n\n" +
        "female 61 c/b diff breathing                                                    \n\n" +
        "is getting air                                                                  \n\n" +
        "2a1 code from pd*                                                               \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122260085",
        "TIME:19:03:41",
        "CALL:Ambulance and Rescue",
        "ADDR:423 CANYON POINT CIR",
        "CITY:GOLDEN",
        "X:MAGPIE CT/ VALLEY VIEW CT",
        "UNIT:AMR131 DIST1 DIST2",
        "INFO:poss partial choking\nfemale 61 c/b diff breathing\nis getting air\n2a1 code from pd");

    doTest("T17",
        "(Golden Fire) Call#: 122260093*                                                               \n\n" +
        "Time: 20:45:23*                                                                 \n\n" +
        "Type of call: Extrication/Rescue/Climber (35)*                                  \n\n" +
        "Location: MARRIOTT COURTYARD, 14700 W 6TH FRONTAGE RD, GOLDEN*                  \n\n" +
        "Cross streets: GLADIOLA ST/ INDIANA ST*                                         \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: 3 ppl trapped                                                        \n\n" +
        "not in distress*                                                                \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122260093",
        "TIME:20:45:23",
        "CALL:Extrication/Rescue/Climber (35)",
        "PLACE:MARRIOTT COURTYARD",
        "ADDR:14700 W 6TH FRONTAGE RD",
        "CITY:GOLDEN",
        "X:GLADIOLA ST/ INDIANA ST",
        "UNIT:DIST1 DIST2",
        "INFO:3 ppl trapped\nnot in distress");

    doTest("T18",
        "(Golden Fire) Call#: 122270019*                                                               \n\n" +
        "Time: 05:41:03*                                                                 \n\n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n\n" +
        "Location: 17731 W COLFAX AVE, GOLDEN*                                           \n\n" +
        "Cross streets: WEST ST/ LA VETA PASS AVE*                                       \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: gen fire*                                                            \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122270019",
        "TIME:05:41:03",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:17731 W COLFAX AVE",
        "CITY:GOLDEN",
        "X:WEST ST/ LA VETA PASS AVE",
        "UNIT:DIST1 DIST2",
        "INFO:gen fire");

    doTest("T19",
        "(Golden Fire) Call#: 122270024*                                                               \n\n" +
        "Time: 07:12:24*                                                                 \n\n" +
        "Type of call: Hazardous Material Leak/Spill(41)*                                \n\n" +
        "Location: CHEYENNE ST/ 8TH ST, GOLDEN*                                          \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: contractor hit gas line*                                             \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122270024",
        "TIME:07:12:24",
        "CALL:Hazardous Material Leak/Spill(41)",
        "ADDR:CHEYENNE ST & 8TH ST",
        "CITY:GOLDEN",
        "UNIT:DIST1 DIST2",
        "INFO:contractor hit gas line");

    doTest("T20",
        "(Golden Fire) Call#: 122270027*                                                               \n\n" +
        "Time: 08:01:17*                                                                 \n\n" +
        "Type of call: Vehicle/Car Fire (13)*                                            \n\n" +
        "Location: JOHNSON RD/W 10TH AVE, GOLDEN*                                        \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: rps hood smoking                                                     \n\n" +
        "hood smokeing                                                                   \n\n" +
        "no flames                                                                       \n\n" +
        "in right hand lane*                                                             \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122270027",
        "TIME:08:01:17",
        "CALL:Vehicle/Car Fire (13)",
        "ADDR:JOHNSON RD & W 10TH AVE",
        "CITY:GOLDEN",
        "UNIT:DIST1 DIST2",
        "INFO:rps hood smoking\nhood smokeing\nno flames\nin right hand lane");

    doTest("T21",
        "(Golden Fire) Call#: 122270034*                                                               \n\n" +
        "Time: 09:03:43*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 1400 UTAH ST A208, GOLDEN*                                            \n\n" +
        "Cross streets: SOUTH GOLDEN RD/ ULYSSES ST*                                     \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: 6 months old swallowed paper diff breathing                          \n\n" +
        "con and breath*                                                                 \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122270034",
        "TIME:09:03:43",
        "CALL:Ambulance and Rescue",
        "ADDR:1400 UTAH ST A208",
        "CITY:GOLDEN",
        "X:SOUTH GOLDEN RD/ ULYSSES ST",
        "UNIT:DIST1 DIST2",
        "INFO:6 months old swallowed paper diff breathing\ncon and breath");

    doTest("T22",
        "(Golden Fire) Call#: 122270094*                                                               \n\n" +
        "Time: 16:29:23*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 660 GOLDEN RIDGE RD U250, GOLDEN*                                     \n\n" +
        "Cross streets: HERITAGE RD/ HERITAGE RD*                                        \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: patient uncon                                                        \n\n" +
        "breathing                                                                       \n\n" +
        "52 yo male*                                                                     \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122270094",
        "TIME:16:29:23",
        "CALL:Ambulance and Rescue",
        "ADDR:660 GOLDEN RIDGE RD U250",
        "CITY:GOLDEN",
        "X:HERITAGE RD/ HERITAGE RD",
        "UNIT:DIST1 DIST2",
        "INFO:patient uncon\nbreathing\n52 yo male");

    doTest("T23",
        "(Golden Fire) Call#: 122270103*                                                               \n\n" +
        "Time: 17:17:41*                                                                 \n\n" +
        "Type of call: AGENCY ASSIST - AMBULANCE*                                        \n\n" +
        "Location: 1270 N FORD ST R1B, GOLDEN*                                           \n\n" +
        "Cross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \n\n" +
        "Units: 200 DIST1 DIST2*                                                         \n\n" +
        "Narrative: unresponsive / not c/ unk b                                          \n\n" +
        "awake now / 88 yof                                                              \n\n" +
        "meadows unit*                                                                   \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122270103",
        "TIME:17:17:41",
        "CALL:AGENCY ASSIST - AMBULANCE",
        "ADDR:1270 N FORD ST R1B",
        "CITY:GOLDEN",
        "X:PINE RIDGE RD/ VIRGINIA ST",
        "UNIT:200 DIST1 DIST2",
        "INFO:unresponsive / not c/ unk b\nawake now / 88 yof\nmeadows unit");

    doTest("T24",
        "(Golden Fire) Call#: 122270132*                                                               \n\n" +
        "Time: 20:43:29*                                                                 \n\n" +
        "Type of call: CSMPD*                                                            \n\n" +
        "Location: 1800 W CAMPUS RD, GOLDEN*                                             \n\n" +
        "Cross streets: ELM ST/ 15TH ST*                                                 \n\n" +
        "Units: U13 DIST1 DIST2*                                                         \n\n" +
        "Narrative: general / 303-225-3282*                                              \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122270132",
        "TIME:20:43:29",
        "CALL:CSMPD",
        "ADDR:1800 W CAMPUS RD",
        "CITY:GOLDEN",
        "X:ELM ST/ 15TH ST",
        "UNIT:U13 DIST1 DIST2",
        "INFO:general / 303-225-3282");

    doTest("T25",
        "(Golden Fire) Call#: 122280025*                                                               \n\n" +
        "Time: 09:00:46*                                                                 \n\n" +
        "Type of call: Vehicle/Car Fire (13)*                                            \n\n" +
        "Location: C470 HWY/ I70 HWY, GOLDEN*                                            \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: active flames under car on shoulder                                  \n\n" +
        "nb c470 right before ramp to i70*                                               \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122280025",
        "TIME:09:00:46",
        "CALL:Vehicle/Car Fire (13)",
        "ADDR:C470 HWY & I70 HWY",
        "MADDR:C470 HWY & I 70",
        "CITY:GOLDEN",
        "UNIT:DIST1 DIST2",
        "INFO:active flames under car on shoulder\nnb c470 right before ramp to i70");

    doTest("T26",
        "(Golden Fire) Call#: 122280032*                                                               \n\n" +
        "Time: 10:49:52*                                                                 \n\n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n\n" +
        "Location: 1310 WASHINGTON AVE, GOLDEN*                                          \n\n" +
        "Cross streets: 13TH ST/ 14TH ST*                                                \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: gen fire*                                                            \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122280032",
        "TIME:10:49:52",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:1310 WASHINGTON AVE",
        "CITY:GOLDEN",
        "X:13TH ST/ 14TH ST",
        "UNIT:DIST1 DIST2",
        "INFO:gen fire");

    doTest("T27",
        "(Golden Fire) Call#: 122280043*                                                               \n\n" +
        "Time: 12:12:39*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 1549 COUGAR CT, GOLDEN*                                               \n\n" +
        "Cross streets: CANYON POINT CIR/ CANYON POINT CIR*                              \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: wife fell and is not responding                                      \n\n" +
        "76 yo f                                                                         \n\n" +
        "is c and b*                                                                     \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122280043",
        "TIME:12:12:39",
        "CALL:Ambulance and Rescue",
        "ADDR:1549 COUGAR CT",
        "CITY:GOLDEN",
        "X:CANYON POINT CIR/ CANYON POINT CIR",
        "UNIT:DIST1 DIST2",
        "INFO:wife fell and is not responding\n76 yo f\nis c and b");

    doTest("T28",
        "(Golden Fire) Call#: 122280083*                                                               \n\n" +
        "Time: 17:18:53*                                                                 \n\n" +
        "Type of call: Other Fire (16)*                                                  \n\n" +
        "Location: EAGLE RIDGE DR/ HERITAGE RD, GOLDEN*                                  \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: parasailor is spinning out of control                                \n\n" +
        "not landed/drifting towards golden ridge condos                                 \n\n" +
        "sail is blu with orng in blk suit                                               \n\n" +
        "rp standing at corner                                                           \n\n" +
        "now floating towards the south side of county                                   \n\n" +
        "building                                                                        \n\n" +
        "closwer to the ground                                                           \n\n" +
        "2nd caller 405 513 4332*                                                        \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122280083",
        "TIME:17:18:53",
        "CALL:Other Fire (16)",
        "ADDR:EAGLE RIDGE DR & HERITAGE RD",
        "CITY:GOLDEN",
        "UNIT:DIST1 DIST2",
        "INFO:parasailor is spinning out of control\nnot landed/drifting towards golden ridge condos\nsail is blu with orng in blk suit\nrp standing at corner\nnow floating towards the south side of county\nbuilding\ncloswer to the ground\n2nd caller 405 513 4332");

    doTest("T29",
        "(Golden Fire) Call#: 122290029*                                                               \n\n" +
        "Time: 07:19:11*                                                                 \n\n" +
        "Type of call: Smoke/Odor Complaint/Call (53)*                                   \n\n" +
        "Location: HERITAGE SQUARE, 18301 W COLFAX AVE SHOPS, GOLDEN*                    \n\n" +
        "Cross streets: W COLFAX AVE/ HERITAGE RD*                                       \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: pos fire by heritage square/smoke frm house on hill/ whi             \n\n" +
        "per rp is a lot of smoke-                                                       \n\n" +
        "rp is calling at 470/70 interchange*                                            \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122290029",
        "TIME:07:19:11",
        "CALL:Smoke/Odor Complaint/Call (53)",
        "PLACE:HERITAGE SQUARE",
        "ADDR:18301 W COLFAX AVE SHOPS",
        "CITY:GOLDEN",
        "X:W COLFAX AVE/ HERITAGE RD",
        "UNIT:DIST1 DIST2",
        "INFO:pos fire by heritage square/smoke frm house on hill/ whi\nper rp is a lot of smoke-\nrp is calling at 470/70 interchange");

    doTest("T30",
        "(Golden Fire) Call#: 122290080*                                                               \n\n" +
        "Time: 14:02:10*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 1270 N FORD ST, GOLDEN*                                               \n\n" +
        "Cross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: aired to pd                                                          \n\n" +
        "res is c/ is b/                                                                 \n\n" +
        "unresponsive/                                                                   \n\n" +
        "poss passed out/ unk exact/                                                     \n\n" +
        "82 yo fem/*                                                                     \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122290080",
        "TIME:14:02:10",
        "CALL:Ambulance and Rescue",
        "ADDR:1270 N FORD ST",
        "CITY:GOLDEN",
        "X:PINE RIDGE RD/ VIRGINIA ST",
        "UNIT:DIST1 DIST2",
        "INFO:aired to pd\nres is c/ is b/\nunresponsive/\nposs passed out/ unk exact/\n82 yo fem/");

    doTest("T31",
        "(Golden Fire) Call#: 122290115*                                                               \n\n" +
        "Time: 19:23:38*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 1212 CHEYENNE ST, GOLDEN*                                             \n\n" +
        "Cross streets: 12TH ST/ 13TH ST*                                                \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: 55 yom / c/diff breathing                                            \n\n" +
        "1/2 address                                                                     \n\n" +
        "access off back side                                                            \n\n" +
        "says pain all*                                                                  \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122290115",
        "TIME:19:23:38",
        "CALL:Ambulance and Rescue",
        "ADDR:1212 CHEYENNE ST",
        "CITY:GOLDEN",
        "X:12TH ST/ 13TH ST",
        "UNIT:DIST1 DIST2",
        "INFO:55 yom / c/diff breathing\n1/2 address\naccess off back side\nsays pain all");

    doTest("T32",
        "(Golden Fire) Call#: 122300015*                                                               \n\n" +
        "Time: 04:15:29*                                                                 \n\n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n\n" +
        "Location: 823 RABBIT RUN DR, GOLDEN*                                            \n\n" +
        "Cross streets: EAGLE RIDGE DR/ EAGLE RIDGE DR*                                  \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: gen smoke                                                            \n\n" +
        "brian pam miller                                                                \n\n" +
        "303 237 2009                                                                    \n\n" +
        "aired to pd/*                                                                   \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122300015",
        "TIME:04:15:29",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:823 RABBIT RUN DR",
        "CITY:GOLDEN",
        "X:EAGLE RIDGE DR/ EAGLE RIDGE DR",
        "UNIT:DIST1 DIST2",
        "INFO:gen smoke\nbrian pam miller\n303 237 2009\naired to pd/");

    doTest("T33",
        "(Golden Fire) Call#: 122300090*                                                               \n\n" +
        "Time: 16:56:16*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: 102 N RUBEY DR, GOLDEN*                                               \n\n" +
        "Cross streets: IOWA ST/ WASHINGTON AVE*                                         \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: white honda /                                                        \n\n" +
        "cannot feel her hands                                                           \n\n" +
        "32 yof / c/b                                                                    \n\n" +
        "swaeting a lot*                                                                 \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122300090",
        "TIME:16:56:16",
        "CALL:Ambulance and Rescue",
        "ADDR:102 N RUBEY DR",
        "CITY:GOLDEN",
        "X:IOWA ST/ WASHINGTON AVE",
        "UNIT:DIST1 DIST2",
        "INFO:white honda /\ncannot feel her hands\n32 yof / c/b\nswaeting a lot");

    doTest("T34",
        "(Golden Fire) Call#: 122300099*                                                               \n\n" +
        "Time: 19:31:38*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: FIRE STATION 1, 911 10TH ST GFD1, GOLDEN*                             \n\n" +
        "Cross streets: ARAPAHOE ST/ CHEYENNE ST*                                        \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: chest pain / 56 yof                                                  \n\n" +
        "also clammy                                                                     \n\n" +
        "is breathing / right out front*                                                 \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122300099",
        "TIME:19:31:38",
        "CALL:Ambulance and Rescue",
        "PLACE:FIRE STATION 1",
        "ADDR:911 10TH ST GFD1",
        "CITY:GOLDEN",
        "X:ARAPAHOE ST/ CHEYENNE ST",
        "UNIT:DIST1 DIST2",
        "INFO:chest pain / 56 yof\nalso clammy\nis breathing / right out front");

    doTest("T35",
        "(Golden Fire) Call#: 122300104*                                                               \n\n" +
        "Time: 20:44:40*                                                                 \n\n" +
        "Type of call: Smoke/Odor Complaint/Call (53)*                                   \n\n" +
        "Location: 600 IDAHO ST, GOLDEN*                                                 \n\n" +
        "Cross streets: N FORD ST/ COLUMBINE ST*                                         \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122300104",
        "TIME:20:44:40",
        "CALL:Smoke/Odor Complaint/Call (53)",
        "ADDR:600 IDAHO ST",
        "CITY:GOLDEN",
        "X:N FORD ST/ COLUMBINE ST",
        "UNIT:DIST1 DIST2");

    doTest("T36",
        "(Golden Fire) Call#: 122310025*                                                               \n\n" +
        "Time: 05:10:05*                                                                 \n\n" +
        "Type of call: Extrication/Rescue/Climber (35)*                                  \n\n" +
        "Location: 14600 W 6TH FRONTAGE RD, GOLDEN*                                      \n\n" +
        "Cross streets: GLADIOLA ST/ INDIANA ST*                                         \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122310025",
        "TIME:05:10:05",
        "CALL:Extrication/Rescue/Climber (35)",
        "ADDR:14600 W 6TH FRONTAGE RD",
        "CITY:GOLDEN",
        "X:GLADIOLA ST/ INDIANA ST",
        "UNIT:DIST1 DIST2");

    doTest("T37",
        "(Golden Fire) Call#: 122310043*                                                               \n\n" +
        "Time: 11:55:56*                                                                 \n\n" +
        "Type of call: Hazardous Material Leak/Spill(41)*                                \n\n" +
        "Location: 920 15TH ST R318, GOLDEN*                                             \n\n" +
        "Cross streets: ARAPAHOE ST/ ARAPAHOE ST*                                        \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: fluid in a lab on the floor/about a pint, unk what                   \n\n" +
        "the fluid is                                                                    \n\n" +
        "coming from under the sink/there are stored materials                           \n\n" +
        "under sink                                                                      \n\n" +
        "cleaning fluids / unk if further under there*                                   \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This",

        "ID:122310043",
        "TIME:11:55:56",
        "CALL:Hazardous Material Leak/Spill(41)",
        "ADDR:920 15TH ST R318",
        "CITY:GOLDEN",
        "X:ARAPAHOE ST/ ARAPAHOE ST",
        "UNIT:DIST1 DIST2",
        "INFO:fluid in a lab on the floor/about a pint, unk what\nthe fluid is\ncoming from under the sink/there are stored materials\nunder sink\ncleaning fluids / unk if further under there");

    doTest("T38",
        "(Golden Fire) Call#: 122310051*                                                               \n\n" +
        "Time: 13:13:43*                                                                 \n\n" +
        "Type of call: Ambulance and Rescue*                                             \n\n" +
        "Location: JEFFERSON COUNTY JAIL, 200 JEFFERSON COUNTY PKY, GOLDEN*              \n\n" +
        "Cross streets: W 10TH AVE/W 10TH AVE*                                           \n\n" +
        "Units: DIST1 DIST2*                                                             \n\n" +
        "Narrative: unk party down-emergent-come in thru sally port*                     \n\n\n\n\n\n\n\n\n\n\n\n" +
        "This\n\n",

        "ID:122310051",
        "TIME:13:13:43",
        "CALL:Ambulance and Rescue",
        "PLACE:JEFFERSON COUNTY JAIL",
        "ADDR:200 JEFFERSON COUNTY PKY",
        "CITY:GOLDEN",
        "X:W 10TH AVE/W 10TH AVE",
        "UNIT:DIST1 DIST2",
        "INFO:unk party down-emergent-come in thru sally port");

  }
  
  public static void main(String[] args) {
    new COGoldenParserTest().generateTests("T1");
  }
}