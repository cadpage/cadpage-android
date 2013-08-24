package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Golden, CO
Agency name: Golden FD Location: Golden, CO
Sender: messaging@iamresponding.com
 
(Golden Fire) Call#: 122230024*                                                               \n\nTime: 08:25:36*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 1270 N FORD ST, GOLDEN*                                               \n\nCross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: in dining room/ poss stroke or heart attack                          \n\nnot responsive/                                                                 \n\nborn 19254                                                                      \n\nis c but not resp/ is b/*                                                       \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122230095*                                                               \n\nTime: 16:53:33*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 1030 JOHNSON RD U200, GOLDEN*                                         \n\nCross streets: W 10TH AVE/W 14TH AVE*                                           \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: high bp / numbless and tingling                                      \n\napprox 80's female                                                              \n\ncannot move one side / poss stroke                                              \n\nno doc on scene*                                                                \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122230107*                                                               \n\nTime: 18:19:55*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 2011 WASHINGTON AVE, GOLDEN*                                          \n\nCross streets: 20TH ST/ WASHINGTON CIR*                                         \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: elderly fem, diff breathing                                          \n\n82 pulse ox                                                                     \n\ndehydrated                                                                      \n\nis con*                                                                         \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122230113*                                                               \n\nTime: 19:29:45*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 1908 PINAL RD, GOLDEN*                                                \n\nCross streets: MT ZION DR/ SMITH RD*                                            \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: rp's husband poss having a heart attack                              \n\nhusband went to store                                                           \n\nrp has parkinson's, hard to understand                                          \n\nso neighbor is on scene trying to "translate"*                                  \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122230116*                                                               \n\nTime: 19:31:53*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 531 SOMERSET DR, GOLDEN*                                              \n\nCross streets: CHELAN ST/ EAGLE RIDGE DR*                                       \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: wife is 43 / unc but breathing                                       \n\nunk how many pills / last 15 minutes                                            \n\nsleeping pills                                                                  \n\nintentional od*                                                                 \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122240049*                                                               \n\nTime: 11:29:38*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 517 15TH ST A2, GOLDEN*                                               \n\nCross streets: EAST ST/ FORD ST*                                                \n\n*                                                                               \n\nNarrative: poss stroke 55 yof                                                   \n\nacting unu                                                                      \n\nnot con / breathing                                                             \n\nposs just out of it                                                             \n\ncannot call rp back / phone disconnected*                                       \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122240086*                                                               \n\nTime: 16:50:13*                                                                 \n\nType of call: Fire Alarm Activation (73)*                                       \n\nLocation: 824 MARSTON TRL, GOLDEN*                                              \n\nCross streets: EAGLE RIDGE DR/ EAGLE RIDGE DR*                                  \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: ind/entire house                                                     \n\npremise 720-771-0383 / nam/seibert*                                             \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122240102*                                                               \n\nTime: 18:46:45*                                                                 \n\nType of call: Fire code/fire ordinance violation*                               \n\nLocation: BRIDGE WASH, 1030 WASHINGTON AVE, GOLDEN*                             \n\nCross streets: 10TH ST/ 11TH ST*                                                \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: respond via foot; sml bonfire just smoldering                        \n\npd on scene                                                                     \n\neast of slide on north side of creek*                                           \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122250065*                                                               \n\nTime: 13:58:26*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: WHITE WATER KAYAK PARK, 1201 10TH ST, GOLDEN*                         \n\nCross streets: MAPLE ST/ MAPLE ST*                                              \n\nUnits: AMR131 DIST1 DIST2*                                                      \n\nNarrative: male dislocated shoulder while kayaking                              \n\nin a lot of pain                                                                \n\ndizzy, but is con                                                               \n\nbreathing                                                                       \n\nfem w/ rhodesian ridgeback dog will                                             \n\nflag down amb*                                                                  \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122250086*                                                               \n\nTime: 16:58:15*                                                                 \n\nType of call: Canyon Call*                                                      \n\nLocation: CCC AT 261, 261 HWY 6 MM, GOLDEN*                                     \n\nCross streets: HWY 93/ HWY 119*                                                 \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: one vehicle accident, unk injuries                                   \n\ncsp en rt*                                                                      \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122250102*                                                               \n\nTime: 18:54:52*                                                                 \n\nType of call: Structure Fire (11)*                                              \n\nLocation: 318 ALLEN ST, GOLDEN*                                                 \n\nCross streets: KIMBALL AVE/ KIMBALL AVE*                                        \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: bbq caught on fire                                                   \n\nposs structures in danger                                                       \n\nhouse                                                                           \n\npropane bbq*                                                                    \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122250109*                                                               \n\nTime: 20:14:08*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 262 MARBLE CIR, GOLDEN*                                               \n\nCross streets: DEER ST/ PINECONE ST*                                            \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: chest pains                                                          \n\nno responding                                                                   \n\n61 yo/m                                                                         \n\nuncon/diff breathing*                                                           \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122250116*                                                               \n\nTime: 21:33:43*                                                                 \n\nType of call: Unknown Injury Traffic Accident*                                  \n\nLocation: HWY 6/W COLFAX AVE, GOLDEN*                                           \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: 3 veh's*                                                             \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122260016*                                                               \n\nTime: 07:28:50*                                                                 \n\nType of call: Fire Alarm Activation (73)*                                       \n\nLocation: 1310 WASHINGTON AVE, GOLDEN*                                          \n\nCross streets: 13TH ST/ 14TH ST*                                                \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: gen fire*                                                            \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122260058*                                                               \n\nTime: 14:41:09*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: ALPINE SLIDE 101, 18301 W COLFAX AVE U101, GOLDEN*                    \n\nCross streets: W COLFAX AVE/ HERITAGE RD*                                       \n\nUnits: AMR132 DIST1 DIST2*                                                      \n\nNarrative: emp poss drug reaction                                               \n\nemp at the top of mtn                                                           \n\n17 yom c/b                                                                      \n\nunk what he took*                                                               \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122260085*                                                               \n\nTime: 19:03:41*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 423 CANYON POINT CIR, GOLDEN*                                         \n\nCross streets: MAGPIE CT/ VALLEY VIEW CT*                                       \n\nUnits: AMR131 DIST1 DIST2*                                                      \n\nNarrative: poss partial choking                                                 \n\nfemale 61 c/b diff breathing                                                    \n\nis getting air                                                                  \n\n2a1 code from pd*                                                               \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122260093*                                                               \n\nTime: 20:45:23*                                                                 \n\nType of call: Extrication/Rescue/Climber (35)*                                  \n\nLocation: MARRIOTT COURTYARD, 14700 W 6TH FRONTAGE RD, GOLDEN*                  \n\nCross streets: GLADIOLA ST/ INDIANA ST*                                         \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: 3 ppl trapped                                                        \n\nnot in distress*                                                                \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122270019*                                                               \n\nTime: 05:41:03*                                                                 \n\nType of call: Fire Alarm Activation (73)*                                       \n\nLocation: 17731 W COLFAX AVE, GOLDEN*                                           \n\nCross streets: WEST ST/ LA VETA PASS AVE*                                       \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: gen fire*                                                            \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122270024*                                                               \n\nTime: 07:12:24*                                                                 \n\nType of call: Hazardous Material Leak/Spill(41)*                                \n\nLocation: CHEYENNE ST/ 8TH ST, GOLDEN*                                          \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: contractor hit gas line*                                             \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122270027*                                                               \n\nTime: 08:01:17*                                                                 \n\nType of call: Vehicle/Car Fire (13)*                                            \n\nLocation: JOHNSON RD/W 10TH AVE, GOLDEN*                                        \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: rps hood smoking                                                     \n\nhood smokeing                                                                   \n\nno flames                                                                       \n\nin right hand lane*                                                             \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122270034*                                                               \n\nTime: 09:03:43*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 1400 UTAH ST A208, GOLDEN*                                            \n\nCross streets: SOUTH GOLDEN RD/ ULYSSES ST*                                     \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: 6 months old swallowed paper diff breathing                          \n\ncon and breath*                                                                 \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122270094*                                                               \n\nTime: 16:29:23*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 660 GOLDEN RIDGE RD U250, GOLDEN*                                     \n\nCross streets: HERITAGE RD/ HERITAGE RD*                                        \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: patient uncon                                                        \n\nbreathing                                                                       \n\n52 yo male*                                                                     \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122270103*                                                               \n\nTime: 17:17:41*                                                                 \n\nType of call: AGENCY ASSIST - AMBULANCE*                                        \n\nLocation: 1270 N FORD ST R1B, GOLDEN*                                           \n\nCross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \n\nUnits: 200 DIST1 DIST2*                                                         \n\nNarrative: unresponsive / not c/ unk b                                          \n\nawake now / 88 yof                                                              \n\nmeadows unit*                                                                   \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122270132*                                                               \n\nTime: 20:43:29*                                                                 \n\nType of call: CSMPD*                                                            \n\nLocation: 1800 W CAMPUS RD, GOLDEN*                                             \n\nCross streets: ELM ST/ 15TH ST*                                                 \n\nUnits: U13 DIST1 DIST2*                                                         \n\nNarrative: general / 303-225-3282*                                              \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122280025*                                                               \n\nTime: 09:00:46*                                                                 \n\nType of call: Vehicle/Car Fire (13)*                                            \n\nLocation: C470 HWY/ I70 HWY, GOLDEN*                                            \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: active flames under car on shoulder                                  \n\nnb c470 right before ramp to i70*                                               \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122280032*                                                               \n\nTime: 10:49:52*                                                                 \n\nType of call: Fire Alarm Activation (73)*                                       \n\nLocation: 1310 WASHINGTON AVE, GOLDEN*                                          \n\nCross streets: 13TH ST/ 14TH ST*                                                \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: gen fire*                                                            \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122280043*                                                               \n\nTime: 12:12:39*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 1549 COUGAR CT, GOLDEN*                                               \n\nCross streets: CANYON POINT CIR/ CANYON POINT CIR*                              \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: wife fell and is not responding                                      \n\n76 yo f                                                                         \n\nis c and b*                                                                     \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122280083*                                                               \n\nTime: 17:18:53*                                                                 \n\nType of call: Other Fire (16)*                                                  \n\nLocation: EAGLE RIDGE DR/ HERITAGE RD, GOLDEN*                                  \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: parasailor is spinning out of control                                \n\nnot landed/drifting towards golden ridge condos                                 \n\nsail is blu with orng in blk suit                                               \n\nrp standing at corner                                                           \n\nnow floating towards the south side of county                                   \n\nbuilding                                                                        \n\ncloswer to the ground                                                           \n\n2nd caller 405 513 4332*                                                        \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122290029*                                                               \n\nTime: 07:19:11*                                                                 \n\nType of call: Smoke/Odor Complaint/Call (53)*                                   \n\nLocation: HERITAGE SQUARE, 18301 W COLFAX AVE SHOPS, GOLDEN*                    \n\nCross streets: W COLFAX AVE/ HERITAGE RD*                                       \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: pos fire by heritage square/smoke frm house on hill/ whi             \n\nper rp is a lot of smoke-                                                       \n\nrp is calling at 470/70 interchange*                                            \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122290080*                                                               \n\nTime: 14:02:10*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 1270 N FORD ST, GOLDEN*                                               \n\nCross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: aired to pd                                                          \n\nres is c/ is b/                                                                 \n\nunresponsive/                                                                   \n\nposs passed out/ unk exact/                                                     \n\n82 yo fem/*                                                                     \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122290115*                                                               \n\nTime: 19:23:38*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 1212 CHEYENNE ST, GOLDEN*                                             \n\nCross streets: 12TH ST/ 13TH ST*                                                \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: 55 yom / c/diff breathing                                            \n\n1/2 address                                                                     \n\naccess off back side                                                            \n\nsays pain all*                                                                  \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122300015*                                                               \n\nTime: 04:15:29*                                                                 \n\nType of call: Fire Alarm Activation (73)*                                       \n\nLocation: 823 RABBIT RUN DR, GOLDEN*                                            \n\nCross streets: EAGLE RIDGE DR/ EAGLE RIDGE DR*                                  \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: gen smoke                                                            \n\nbrian pam miller                                                                \n\n303 237 2009                                                                    \n\naired to pd/*                                                                   \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122300090*                                                               \n\nTime: 16:56:16*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: 102 N RUBEY DR, GOLDEN*                                               \n\nCross streets: IOWA ST/ WASHINGTON AVE*                                         \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: white honda /                                                        \n\ncannot feel her hands                                                           \n\n32 yof / c/b                                                                    \n\nswaeting a lot*                                                                 \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122300099*                                                               \n\nTime: 19:31:38*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: FIRE STATION 1, 911 10TH ST GFD1, GOLDEN*                             \n\nCross streets: ARAPAHOE ST/ CHEYENNE ST*                                        \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: chest pain / 56 yof                                                  \n\nalso clammy                                                                     \n\nis breathing / right out front*                                                 \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122300104*                                                               \n\nTime: 20:44:40*                                                                 \n\nType of call: Smoke/Odor Complaint/Call (53)*                                   \n\nLocation: 600 IDAHO ST, GOLDEN*                                                 \n\nCross streets: N FORD ST/ COLUMBINE ST*                                         \n\nUnits: DIST1 DIST2*                                                             \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122310025*                                                               \n\nTime: 05:10:05*                                                                 \n\nType of call: Extrication/Rescue/Climber (35)*                                  \n\nLocation: 14600 W 6TH FRONTAGE RD, GOLDEN*                                      \n\nCross streets: GLADIOLA ST/ INDIANA ST*                                         \n\nUnits: DIST1 DIST2*                                                             \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122310043*                                                               \n\nTime: 11:55:56*                                                                 \n\nType of call: Hazardous Material Leak/Spill(41)*                                \n\nLocation: 920 15TH ST R318, GOLDEN*                                             \n\nCross streets: ARAPAHOE ST/ ARAPAHOE ST*                                        \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: fluid in a lab on the floor/about a pint, unk what                   \n\nthe fluid is                                                                    \n\ncoming from under the sink/there are stored materials                           \n\nunder sink                                                                      \n\ncleaning fluids / unk if further under there*                                   \n\n\n\n\n\n\n\n\n\n\n\nThis
(Golden Fire) Call#: 122310051*                                                               \n\nTime: 13:13:43*                                                                 \n\nType of call: Ambulance and Rescue*                                             \n\nLocation: JEFFERSON COUNTY JAIL, 200 JEFFERSON COUNTY PKY, GOLDEN*              \n\nCross streets: W 10TH AVE/W 10TH AVE*                                           \n\nUnits: DIST1 DIST2*                                                             \n\nNarrative: unk party down-emergent-come in thru sally port*                     \n\n\n\n\n\n\n\n\n\n\n\nThis\n\n

Contact: Active911
[Golden Fire] Call#: 122560092*                                                               \r\r\nTime: 21:45:56*                                                                 \r\r\nType of call: Fire Alarm Activation (73)*                                       \r\r\nLocation: 130 CRAWFORD CIR, GOLDEN*                                             \r\r\nCross streets: BURGESS AVE/ DEFRANCE WAY*                                       \r\r\nMap page: MAP J3  *                                                             \r\r\nUnits: DIST1 DIST2*\r\r\nNarrative: poss co                                                              \r\r\nturned off valve to gas fireplace                                               \r\r\naired/*                                                                         \r\r\n\r\r\n\r\r\n\r\r\n\r\r\n\r\r\n  \r\r\n\r\n\r\n\r\n
[Golden Fire] Call#: 122570021*                                                               \r\r\nTime: 07:19:06*                                                                 \r\r\nType of call: Ambulance and Rescue*                                             \r\r\nLocation: 17881 W COLFAX AVE, GOLDEN*                                           \r\r\nCross streets: WEST ST/ XYLON ST*\r\r\nMap page: MAP J4  *                                                             \r\r\nUnits: DIST1 DIST2*\r\r\nNarrative: rp feeling dizzy and lightheaded                                     \r\r\n61 yof colon cancer                                                             \r\r\ncon and breath                                                                  \r\r\ndiff breathing*                                                                 \r\r\n\r\r\n\r\r\n\r\r\n\r\r\n\r\r\n  \r\r\n\r\n\r\n\r\n
[Golden Fire] Call#: 122570073*                                                               \r\r\nTime: 16:14:46*                                                                 \r\r\nType of call: Smoke/Odor Complaint/Call (53)*                                   \r\r\nLocation: HERITAGE RD/W COLFAX AVE, GOLDEN*                                     \r\r\nMap page: MAP K4  *\r\r\nUnits: DIST1 DIST2*                                                             \r\r\nNarrative: sees smoke in area, says not quary and smells smoke*                 \r\r\n\r\r\n\r\r\n\r\r\n\r\r\n\r\r\n  \r\r\n\r\n\r\n\r\n
[Golden Fire] Call#: 122580034*                                                               \r\r\nTime: 10:20:13*                                                                 \r\r\nType of call: Ambulance and Rescue*                                             \r\r\nLocation: JEFFERSON COUNTY COURT HOUSE, 100 JEFFERSON COUNTY PKY, GOLDEN*       \r\r\nCross streets: COURTHOUSE DR/ COURTHOUSE DR*                                    \r\r\nMap page: MAP I4  *                                                             \r\r\nUnits: DIST1 DIST2*                                                             \r\r\nNarrative: 35 yo/f                                                              \r\r\ncon seizure                                                                     \r\r\ndifficulty breathing                                                            \r\r\nnot in seizure now                                                              \r\r\nrespond to front of court house*                                                \r\r\n\r\r\n\r\r\n\r\r\n\r\r\n\r\r\n  \r\r\n\r\n\r\n\r\n
[Golden Fire] Call#: 122580074*                                                               \r\r\nTime: 18:03:55*                                                                 \r\r\nType of call: Ambulance and Rescue*                                             \r\r\nLocation: 16035 W 4TH AVE, GOLDEN*                                              \r\r\nCross streets: ORCHARD ST/ ORION ST*                                            \r\r\nMap page: MAP J6  *                                                             \r\r\nUnits: DIST1 DIST2*                                                             \r\r\nNarrative: aired to pd                                                          \r\r\nmale diff breathing                                                             \r\r\n36 yom / amb will have access*                                                  \r\r\n\r\r\n\r\r\n\r\r\n\r\r\n\r\r\n  \r\r\n\r\n\r\n\r\n
[Golden Fire] Call#: 122590040*                                                               \r\r\nTime: 11:40:15*                                                                 \r\r\nType of call: Unknown Injury Traffic Accident*                                  \r\r\nLocation: HWY 6/ 19TH ST, GOLDEN*                                               \r\r\nMap page: MAP F3  *                                                             \r\r\nUnits: DIST1 DIST2*                                                             \r\r\nNarrative: car vs bicyclist                                                     \r\r\nyelling at each other as well                                                   \r\r\ndrk grn suv*                                                                    \r\r\n\r\r\n\r\r\n\r\r\n\r\r\n\r\r\n  \r\r\n\r\n\r\n\r\n
[Golden Fire] Call#: 122590072*                                                               \r\r\nTime: 17:35:28*                                                                 \r\r\nType of call: Fire Alarm Activation (73)*                                       \r\r\nLocation: 17700 SOUTH GOLDEN RD, GOLDEN*                                        \r\r\nCross streets: LUNNONHAUS DR/ JOHNSON RD*                                       \r\r\nMap page: MAP G4  *                                                             \r\r\nUnits: DIST1 DIST2*                                                             \r\r\nNarrative: doesn't specify business name                                        \r\r\npremise 303 443 3313*                                                           \r\r\n\r\r\n\r\r\n\r\r\n\r\r\n\r\r\n  \r\r\n\r\n\r\n\r\n
[Golden Fire] Call#: 123550120*                                                               \r\nTime: 22:51:47*                                                                 \r\nType of call: Mutual Aid*                                                       \r\nLocation: 1430 JOYCE ST*                                                        \r\nCross streets:/*                                                                \r\nUnits: DIST1 DIST2*                                                          \r\nNarrative: eng and rescue fire se*

Contact: Active911
Agency name: Golden FD
Location: Golden, CO, United States
Sender: messaging@iamresponding.com

(Golden Fire) Call#: 130070096*                                                               \nTime: 18:45:41*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 1200 GOLDEN CIR, GOLDEN*                                              \nCross streets: GOLDEN CIR/ GOLDEN CIR*                                          \nMap page: MAP I4  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: bldg 10 automatic*                                                   \n\n\n\n\n\n  
(Golden Fire) Call#: 130070087*                                                               \nTime: 17:37:24*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 149 KIMBALL AVE, GOLDEN*                                              \nCross streets: DEFRANCE WAY/ CRAWFORD ST*                                       \nMap page: MAP K3  *                                                             \nUnits: DIST1 DIST2 MED22*                                                       \nNarrative: c/b diff breathing 38 yof*                                           \n\n\n\n\n\n  
(Golden Fire) Call#: 130070080*                                                               \nTime: 16:08:32*                                                                 \nType of call: Water Problem/Pipe Break (52)*                                    \nLocation: 2201 ILLINOIS ST, GOLDEN*                                             \nCross streets: 22ND ST/ 23RD ST*                                                \nMap page: MAP F3  *                                                             \nUnits: CHF21 DIST1 DIST2*                                                       \nNarrative: water puring out of basement*                                        \n\n\n\n\n\n  
(Golden Fire) Call#: 130070046*                                                               \nTime: 12:01:06*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 355 C ST, GOLDEN*                                                     \nCross streets: ZETA ST/ ZURICH ST*                                              \nMap page: MAP J4  *                                                             \nUnits: DIST1 DIST2 MED22*                                                       \nNarrative: aired to pd                                                          \nulcer and severe pain c/b                                                       \n23 yo male                                                                      \nCall emailed to:                                                                \n2023@iaralerts.com                                                              \n2023b@iaralerts.com*                                                            \n\n\n\n\n\n  
(Golden Fire) Call#: 130070028*                                                               \nTime: 09:29:25*                                                                 \nType of call: Vehicle/Car Fire (13)*                                            \nLocation: PANORAMA ORTHOPEDICS, 660 GOLDEN RIDGE RD U250, GOLDEN*               \nCross streets: HERITAGE RD/ HERITAGE RD*                                        \nMap page: MAP I4  *                                                             \nUnits: DIST1 DIST2 BAT21 MED22*                                                 \nNarrative: per cr4/smoke visible from shops                                     \nno flames seen                                                                  \nflames visible/                                                                 \nin main parking lot black smoke                                                 \nCall emailed to:                                                                \n2023@iaralerts.com                                                              \n2023b@iaralerts.com*                                                            \n\n\n\n\n\n  
(Golden Fire) Call#: 130070021*                                                               \nTime: 08:25:22*                                                                 \nType of call: Ambulance call only (32)*                                         \nLocation: 249 CRAWFORD DR, GOLDEN*                                              \nCross streets: DEFRANCE DR/ CRAWFORD ST*                                        \nMap page: MAP J3  *                                                             \nUnits: MED22*                                                                   \nNarrative: front door unlockd lift assist*                                      \n\n\n\n\n\n  
(Golden Fire) Call#: 130070012*                                                               \nTime: 06:21:56*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 1828 MT ZION DR, GOLDEN*                                              \nCross streets: PINAL RD/ FOOTHILLS RD*                                          \nMap page: MAP F2  *                                                             \nUnits: DIST1 DIST2 MED21*                                                       \nNarrative: some diff breat 90 yof*                                              \n\n\n\n\n\n  
(Golden Fire) Call#: 130060070*                                                               \nTime: 17:37:37*                                                                 \nType of call: Extrication/Rescue/Climber (35)*                                  \nLocation: WHITE WATER KAYAK PARK, 1201 10TH ST, GOLDEN*                         \nCross streets: MAPLE ST/ MAPLE ST*                                              \nMap page: MAP E2  *                                                             \nUnits: DIST1 DIST2*                                                             \n\n\n\n\n\n  
(Golden Fire) Call#: 130060061*                                                               \nTime: 15:13:26*                                                                 \nType of call: Canyon Call*                                                      \nLocation: TUNNEL # 1 EAST END, 270 HWY 6 .4MM, GOLDEN*                          \nCross streets: HWY 93/ HWY 119*                                                 \nMap page: NO MAP  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: somebody down near the creek                                         \nbleeding, shivering                                                             \nnear creek, poss male                                                           \nrp not with him                                                                 \ndrk jacket, drk pants                                                           \nrp is on the boardwalk trail south of the creek                                 \nabout 1 mile east of tun1                                                       \nrp and other ppl cannot get to road; stuck on the trail                         \nrp is fem wearing drk blu jacket and blue jeans*                                \n\n\n\n\n\n  
(Golden Fire) Call#: 130060039*                                                               \nTime: 10:07:58*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 1270 N FORD ST, GOLDEN*                                               \nCross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \nMap page: MAP A2  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: poss stroke/                                                         \nweakness on l side                                                              \nlate 80s 90s                                                                    \nis c is b                                                                       \nis 91 yo f*                                                                     \n\n\n\n\n\n  
(Golden Fire) Call#: 130050058*                                                               \nTime: 21:12:35*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 1800 W CAMPUS RD, GOLDEN*                                             \nCross streets: ELM ST/ 15TH ST*                                                 \nMap page: MAP F3  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: general fire alarm*                                                  \n\n\n\n\n\n  
(Golden Fire) Call#: 130050038*                                                               \nTime: 13:03:05*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 18301 W COLFAX AVE UD103, GOLDEN*                                     \nCross streets: W COLFAX AVE/ HERITAGE RD*                                       \nMap page: MAP K3  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: trouble signals / carlos on site                                     \nhave a lot of water                                                             \npremise 303-277-0040*                                                           \n\n\n\n\n\n  
(Golden Fire) Call#: 130040088*                                                               \nTime: 18:25:01*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 814 RABBIT RUN DR, GOLDEN*                                            \nCross streets: EAGLE RIDGE DR/ EAGLE RIDGE DR*                                  \nMap page: MAP H3  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: ind/general                                                          \npremise 303-278-6682 / res nam/hammontree                                       \naired to all units*                                                             \n\n\n\n\n\n  
(Golden Fire) Call#: 130040073*                                                               \nTime: 15:14:23*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 1470 10TH ST, GOLDEN*                                                 \nCross streets: MAPLE ST/ MAPLE ST*                                              \nMap page: MAP E2  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: ind is en alarm                                                      \nkh will be contacted*                                                           \n\n\n\n\n\n  
(Golden Fire) Call#: 130040067*                                                               \nTime: 14:42:32*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: CSM M, 21400 LARIAT LOOP TRL, GOLDEN*                                 \nCross streets: MT ZION DR/ MT ZION DR*                                          \nMap page: MAP G2  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: paraglider down below the m on east                                  \nc/b 41 yo male                                                                  \nlower back injuries*                                                            \n\n\n\n\n\n  
(Golden Fire) Call#: 130040064*                                                               \nTime: 14:24:33*                                                                 \nType of call: Smoke/Odor Complaint/Call (53)*                                   \nLocation: STANLEY STEEMER, 621 CORPORATE CIR UJ, GOLDEN*                        \nCross streets: CONFERENCE PL/ CAPITAL DR*                                       \nMap page: MAP J5  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: smoke investigation                                                  \nstrong smell inside bldg                                                        \nno flames seen*                                                                 \n\n\n\n\n\n  
(Golden Fire) Call#: 130040061*                                                               \nTime: 14:17:25*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 912 HOMESTAKE DR, GOLDEN*                                             \nCross streets: ILLINOIS ST/ ILLINOIS ST*                                        \nMap page: MAP G3  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: difficulty breathing c/b                                             \n67 yo male                                                                      \naired*                                                                          \n\n\n\n\n\n  
(Golden Fire) Call#: 130040033*                                                               \nTime: 08:11:47*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 16950 W COLFAX AVE U104, GOLDEN*                                      \nCross streets: W COLFAX AVE/ INTER PLAZA WEST*                                  \nMap page: MAP J5  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: female party passed out now c/b*                                     \n\n\n\n\n\n  
(Golden Fire) Call#: 130030071*                                                               \nTime: 15:35:12*                                                                 \nType of call: Extrication/Rescue/Climber (35)*                                  \nLocation: 400 INDIANA ST, GOLDEN*                                               \nCross streets: W 4TH AVE/W 4TH AVE*                                             \nMap page: MAP J6  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: both patients on the second and need to be carried                   \ndown to the first floor                                                         \nelevator are broken                                                             \nis not life threatening*                                                        \n\n\n\n\n\n  
(Golden Fire) Call#: 130030059*                                                               \nTime: 14:12:59*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 722 WASHINGTON AVE, GOLDEN*                                           \nCross streets: 7TH ST/ 8TH ST*                                                  \nMap page: MAP D2  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: aud/ first floor office  general*                                    \n\n\n\n\n\n  
(Golden Fire) Call#: 130030052*                                                               \nTime: 13:15:20*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 700 JEFFERSON COUNTY PKY, GOLDEN*                                     \nCross streets: ILLINOIS ST/W 10TH AVE*                                          \nMap page: MAP H4  *                                                             \nUnits: STA21 DIST1 DIST2*                                                       \nNarrative: aud fire alarm general and water flow 720.201.6257*                  \n\n\n\n\n\n  
(Golden Fire) Call#: 130030037*                                                               \nTime: 10:28:27*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 1270 N FORD ST, GOLDEN*                                               \nCross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \nMap page: MAP A2  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: room 260                                                             \nfemale unresponsive c/b                                                         \nunk age*                                                                        \n\n\n\n\n\n  
(Golden Fire) Call#: 130010056*                                                               \nTime: 19:11:45*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: 1903 MT ZION DR, GOLDEN*                                              \nCross streets: FOOTHILLS RD/ GOLDENVUE DR*                                      \nMap page: MAP F2  *                                                             \nUnits: STA21 AMR131*                                                            \nNarrative: has stomach flu / ongoing issues with diahera                        \nrp there with wife / has dementia                                               \n75 yom                                                                          \nno amr call sign avail / used sta21 as call sign for this                       \nincident*                                                                       \n\n\n\n\n\n  
(Golden Fire) Call#: 130010054*                                                               \nTime: 19:00:50*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: 1613 GOLDEN HILLS RD, GOLDEN*                                         \nCross streets: GOLDEN HILLS PL/ GOLDEN HILLS PL*                                \nMap page: MAP G5  *                                                             \nUnits: DIST1 DIST2*                                                             \n\n\n\n\n\n  
(Golden Fire) Call#: 130010052*                                                               \nTime: 18:33:31*                                                                 \nType of call: Mutual Aid*                                                       \nLocation: 15100 W 13TH AVE*                                                     \nCross streets:/*                                                                \nUnits: BAT22 BAT21 DIST1 DIST2*                                                 \nNarrative: one eng and one res                                                  \ngarage w/two veh inside                                                         \njoyce / juniper nearest cross                                                   \ncommand post at same loc*                                                       \n\n\n\n\n\n  
(Golden Fire) Call#: 130010042*                                                               \nTime: 16:01:15*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 900 GOLDEN PARK DR AD, GOLDEN*                                        \nCross streets: GOLDEN PARK PL/ GOLDEN PARK PL*                                  \nMap page: MAP C2  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: man passed out in backyard in shorts                                 \nnot responding                                                                  \n20 yom                                                                          \nlaying on hands*                                                                \n\n\n\n\n\n  
(Golden Fire) Call#: 130010021*                                                               \nTime: 09:26:40*                                                                 \nType of call: Unknown Injury Traffic Accident*                                  \nLocation: HWY 6/ 19TH ST, GOLDEN*                                               \nMap page: MAP F3  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: caller stated jeffco on scene                                        \nslide off                                                                       \njeffco ckng injuries                                                            \nonly 1 occupant                                                                 \nsubaru lost control went into ditch                                             \non west side now                                                                \nunk inj                                                                         \nj s o intersection*                                                             \n\n\n\n\n\n  
(Golden Fire) Call#: 123660042*                                                               \nTime: 17:40:27*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 312 WHITE ASH DR, GOLDEN*                                             \nCross streets: WILD ROSE CT/ WASHINGTON ST*                                     \nMap page: MAP C1  *                                                             \nUnits: DIST1*                                                                   \nNarrative: neighbor hears it / poss smoke alarm                                 \nno ind of fire                                                                  \ntexted home owner / no response                                                 \nmelissa barbara / lights on / did not knock on door                             \ngot home owner to come to door                                                  \nwill call if needed                                                             \nowner called / cannot reset*                                                    \n\n\n\n\n\n  
(Golden Fire) Call#: 123660016*                                                               \nTime: 09:00:45*                                                                 \nType of call: Ambulance call only (32)*                                         \nLocation: GOLDEN POLICE DEPARTMENT, 911 10TH ST GPD, GOLDEN*                    \nCross streets: ARAPAHOE ST/ CHEYENNE ST*                                        \nMap page: MAP D2  *                                                             \nUnits: AMR131*                                                                  \nNarrative: or blood draw*                                                       \n\n\n\n\n\n  
(Golden Fire) Call#: 123660009*                                                               \nTime: 05:46:20*                                                                 \nType of call: Extrication/Rescue/Climber (35)*                                  \nLocation: C470 HWY/ I70 HWY, GOLDEN*                                            \nMap page: MAP K5  *                                                             \nUnits: DIST1 DIST2 AMR132*                                                      \nNarrative: 31                                                                   \nCall emailed to:                                                                \n2023@iaralerts.com                                                              \n2023b@iaralerts.com*                                                            \n\n\n\n\n\n  
(Golden Fire) Call#: 123660009*                                                               \nTime: 05:46:20*                                                                 \nType of call: Extrication/Rescue/Climber (35)*                                  \nLocation: C470 HWY/ I70 HWY, GOLDEN*                                            \nMap page: MAP K5  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: 31*                                                                  \n\n\n\n\n\n  
(Golden Fire) Call#: 123650052*                                                               \nTime: 22:20:29*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: 18206 W 3RD AVE A4, GOLDEN*                                           \nCross streets: ZETA ST/ ZETA ST*                                                \nMap page: MAP J4  *                                                             \nUnits: AMR132*                                                                  \nNarrative: male with back pain, is on dialysis,  41*                            \n\n\n\n\n\n  
(Golden Fire) Call#: 123650044*                                                               \nTime: 19:19:05*                                                                 \nType of call: Ambulance call only (32)*                                         \nLocation: WASHINGTON AVE/ 10TH ST, GOLDEN*                                      \nMap page: MAP D3  *                                                             \nUnits: AMR131*                                                                  \nNarrative: dk male; complain leg pain*                                          \n\n\n\n\n\n  
(Golden Fire) Call#: 123650026*                                                               \nTime: 10:49:09*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: 1030 JOHNSON RD U200, GOLDEN*                                         \nCross streets: W 10TH AVE/W 14TH AVE*                                           \nMap page: MAP H4  *                                                             \nUnits: AMR132 AMR131*                                                           \nNarrative: patient is hypoxic                                                   \n83yo m / is c / is b                                                            \non a rebreather 8 l pulxox of 70                                                \nCall emailed to:                                                                \n2023d@iaralerts.com*                                                            \n\n\n\n\n\n  
(Golden Fire) Call#: 123650026*                                                               \nTime: 10:49:09*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: 1030 JOHNSON RD U200, GOLDEN*                                         \nCross streets: W 10TH AVE/W 14TH AVE*                                           \nMap page: MAP H4  *                                                             \nUnits: AMR132*                                                                  \nNarrative: patient is hypoxic                                                   \n83yo m / is c / is b                                                            \non a rebreather 8 l pulxox of 70*                                               \n\n\n\n\n\n  
(Golden Fire) Call#: 123640063*                                                               \nTime: 21:55:37*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 1350 N FORD ST, GOLDEN*                                               \nCross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \nMap page: MAP A2  *                                                             \nUnits: DIST1 ST1 DIST2 AMR AMR131*                                              \nNarrative: unconcious not responding but breathing                              \nroom 208                                                                        \n95 yo                                                                           \nCall emailed to:                                                                \n2023@iaralerts.com                                                              \n2023b@iaralerts.com*                                                            \n\n\n\n\n\n  
(Golden Fire) Call#: 123640012*                                                               \nTime: 08:40:42*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 700 JEFFERSON COUNTY PKY, GOLDEN*                                     \nCross streets: ILLINOIS ST/W 10TH AVE*                                          \nMap page: MAP H4  *                                                             \nNarrative: ind/general                                                          \npremise 720-201-6257                                                            \nshows water flow*                                                               \n\n\n\n\n\n  
(Golden Fire) Call#: 123640001*                                                               \nTime: 00:04:32*                                                                 \nType of call: Ambulance call only (32)*                                         \nLocation: GOLDEN POLICE DEPARTMENT, 911 10TH ST GPD, GOLDEN*                    \nCross streets: ARAPAHOE ST/ CHEYENNE ST*                                        \nMap page: MAP D2  *                                                             \nUnits: AMR131*                                                                  \nNarrative: blood test*                                                          \n\n\n\n\n\n  
(Golden Fire) Call#: 123630050*                                                               \nTime: 13:42:14*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: JEFFERSON COUNTY COURT HOUSE, 100 JEFFERSON COUNTY PKY, GOLDEN*       \nCross streets: COURTHOUSE DR/ COURTHOUSE DR*                                    \nMap page: MAP I4  *                                                             \nUnits: AMR132*                                                                  \nNarrative: female spider bite open and bleeding                                 \ncon and breath                                                                  \nin atrim                                                                        \n28 yof con and breath*                                                          \n\n\n\n\n\n  
(Golden Fire) Call#: 123630043*                                                               \nTime: 12:39:03*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 600 9TH ST COORS, GOLDEN*                                             \nCross streets: JACKSON ST/ JACKSON ST*                                          \nMap page: MAP D2  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: gen fire                                                             \nfire water floor bldg 11 5th floor                                              \nalso ground flooor*                                                             \n\n\n\n\n\n  
(Golden Fire) Call#: 123630041*                                                               \nTime: 12:06:37*                                                                 \nType of call: Mutual Aid*                                                       \nLocation: 14095 W 7TH AVE*                                                      \nCross streets:/*                                                                \nUnits: DIST1 DIST2*                                                             \nNarrative: one engine / command post same loc                                   \nshed on fire*                                                                   \n\n\n\n\n\n  
(Golden Fire) Call#: 123630035*                                                               \nTime: 10:17:23*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 1917 PARFET ESTATES DR, GOLDEN*                                       \nCross streets: KOHINOOR PL/ KOHINOOR PL*                                        \nMap page: MAP F2  *                                                             \nUnits: AMR131 RES2 DIST1 DIST2*                                                 \nNarrative: fall vict / poss broken hip                                          \n86 yof c/b                                                                      \nCall emailed to:                                                                \n2023c@iaralerts.com*                                                            \n\n\n\n\n\n  
(Golden Fire) Call#: 123630019*                                                               \nTime: 04:30:35*                                                                 \nType of call: Ambulance call only (32)*                                         \nLocation: GOLDEN POLICE DEPARTMENT, 911 10TH ST GPD, GOLDEN*                    \nCross streets: ARAPAHOE ST/ CHEYENNE ST*                                        \nMap page: MAP D2  *                                                             \nUnits: AMR131*                                                                  \nNarrative: blood draw*                                                          \n\n\n\n\n\n  
(Golden Fire) Call#: 123630010*                                                               \nTime: 01:35:08*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 1300 GOLDEN CIR A205, GOLDEN*                                         \nCross streets: GOLDEN CIR/ GOLDEN CIR*                                          \nMap page: MAP I4  *                                                             \nUnits: AMR132*                                                                  \nNarrative: 83  yo/m                                                             \ndiff breathing                                                                  \nreq non emergent                                                                \nCall emailed to:                                                                \n2023@iaralerts.com                                                              \n2023b@iaralerts.com*                                                            \n\n\n\n\n\n  
(Golden Fire) Call#: 123620053*                                                               \nTime: 20:25:29*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 1300 GOLDEN CIR, GOLDEN*                                              \nCross streets: GOLDEN CIR/ GOLDEN CIR*                                          \nMap page: MAP I4  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: kids knocked into the fire pull station                              \nat the south entrance on main floor                                             \nthe fire alarm is not going off but some other                                  \ntype of noise or alarm coming from it                                           \nhas been going off for the last 15 mins                                         \nnext to apt 212*                                                                \n\n\n\n\n\n  
(Golden Fire) Call#: 123620046*                                                               \nTime: 17:07:15*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 1224 WASHINGTON AVE U105, GOLDEN*                                     \nCross streets: 12TH ST/ 13TH ST*                                                \nMap page: MAP E3  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: unk unit number                                                      \nindicator gen fire zone 12                                                      \nrp 303 325 1978 pat foss                                                        \naired*                                                                          \n\n\n\n\n\n  
(Golden Fire) Call#: 123620037*                                                               \nTime: 14:11:06*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: 1549 COUGAR CT, GOLDEN*                                               \nCross streets: CANYON POINT CIR/ CANYON POINT CIR*                              \nMap page: MAP C1  *                                                             \nUnits: AMR131*                                                                  \nNarrative: AN FELL A FEW DAYS AGO AND NOW HAS BAD CRAMPING                      \n78yo f / is c / is b*                                                           \n\n\n\n\n\n  
(Golden Fire) Call#: 123620025*                                                               \nTime: 09:53:16*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: 323 ORION ST, GOLDEN*                                                 \nCross streets: W 2ND PL/W 4TH AVE*                                              \nMap page: MAP J6  *                                                             \nUnits: AMR132*                                                                  \nNarrative: 65yo m he is sick throwing up and has diarhea                        \nis c / is b*                                                                    \n\n\n\n\n\n  
(Golden Fire) Call#: 123620017*                                                               \nTime: 08:18:17*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 1819 PARFET ESTATES DR, GOLDEN*                                       \nCross streets: 19TH ST/ YUCCA CT*                                               \nMap page: MAP F2  *                                                             \nUnits: AMR131*                                                                  \nNarrative: poss stroke                                                          \nis 80 yo m                                                                      \nis c/ is b/                                                                     \ntransfer to emd//                                                               \nCall emailed to:                                                                \n2023@iaralerts.com                                                              \n2023b@iaralerts.com*                                                            \n\n\n\n\n\n  
(Golden Fire) Call#: 123620014*                                                               \nTime: 07:46:22*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 3050 ILLINOIS ST, GOLDEN*                                             \nCross streets: JEFFERSON COUNTY PKY/ JEFFERSON COUNTY PKY*                      \nMap page: MAP H4  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: ind clubhouse water flow                                             \np 3032778750                                                                    \nkh wasn't contacted yet*                                                        \n\n\n\n\n\n  
(Golden Fire) Call#: 130090127*                                                               \nTime: 15:38:50*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: SHELTON ELEMENTARY SCHOOL, 420 CRAWFORD ST SCHOOL, GOLDEN*            \nCross streets: CRAWFORD DR/ TRIPP DR*                                           \nMap page: MAP J3  *                                                             \nUnits: MED22*                                                                   \nNarrative: student outside / ankle run over by car                              \nparent of child / accidental                                                    \nright out front                                                                 \nstudent is 6th grader /                                                         \nrp not with subj                                                                \nstill relaying status thru principal*                                           \n

Agency name: Golden FD
Location: Golden, CO, United States
Contact: Active911
Sender: CADTOFIRE@CITYOFGOLDEN.NET

(CAD call 130930009) Call#: 130930009*                                                               \nTime: 04:37:08*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: 1150 GOLDEN CIR A205, GOLDEN*                                         \nCross streets: GOLDEN CIR/ GOLDEN CIR*                                          \nMap page: MAP I4  *                                                             \nUnits: MED22*                                                                   \nNarrative: stomach pain 2030                                                    \n44 yom  c/b                                                                     \nabovce nbavel*                                                                  \n\n\n\n\n\nThis email and the attached documents (if any) are intended only for the use of\nthe individual or entity to which they are addressed and may contain information\nthat is privileged, confidential and exempt from disclosure under applicable\nlaw.  If the reader of this message and the accompanying documents is not the\nintended recipient or the employee or agent responsible for delivering the\nmessage to the intended recipient, you are hereby notified that any\ndissemination, distribution or copying of this communication is strictly\nprohibited.  If you have received this communication in error, please notify us\nimmediately by telephone and fully delete the original message and any\naccompanying documents.  Thank you.
(CAD call 130920116) Call#: 130920116*                                                               \nTime: 20:34:57*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: 17150 W COLFAX AVE, GOLDEN*                                           \nCross streets: HWY 6/ CORPORATE DR*                                             \nMap page: MAP J5  *                                                             \nUnits: MED22*                                                                   \nNarrative: m1 eval / routine*                                                   \n\n\n\n\n\nThis email and the attached documents (if any) are intended only for the use of\nthe individual or entity to which they are addressed and may contain information\nthat is privileged, confidential and exempt from disclosure under applicable\nlaw.  If the reader of this message and the accompanying documents is not the\nintended recipient or the employee or agent responsible for delivering the\nmessage to the intended recipient, you are hereby notified that any\ndissemination, distribution or copying of this communication is strictly\nprohibited.  If you have received this communication in error, please notify us\nimmediately by telephone and fully delete the original message and any\naccompanying documents.  Thank you.
(CAD call 130920102) Call#: 130920102*                                                               \nTime: 17:27:35*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 165 A ST, GOLDEN*                                                     \nCross streets: ZETA ST/ ZURICH ST*                                              \nMap page: MAP J4  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: difficulty breathing / copd / asthma                                 \n83yo f is c*                                                                    \n\n\n\n\n\nThis email and the attached documents (if any) are intended only for the use of\nthe individual or entity to which they are addressed and may contain information\nthat is privileged, confidential and exempt from disclosure under applicable\nlaw.  If the reader of this message and the accompanying documents is not the\nintended recipient or the employee or agent responsible for delivering the\nmessage to the intended recipient, you are hereby notified that any\ndissemination, distribution or copying of this communication is strictly\nprohibited.  If you have received this communication in error, please notify us\nimmediately by telephone and fully delete the original message and any\naccompanying documents.  Thank you.
(CAD call 130920093) Call#: 130920093*                                                               \nTime: 14:36:20*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: 1223 W CAMPUS RD A304, GOLDEN*                                        \nCross streets: MAPLE ST/ ELM ST*                                                \nMap page: MAP E2  *                                                             \nUnits: MED21*                                                                   \nNarrative: room 304                                                             \n19 feeling numb                                                                 \ncant move wrist                                                                 \ncon and breathing*                                                              \n\n\n\n\n\nThis email and the attached documents (if any) are intended only for the use of\nthe individual or entity to which they are addressed and may contain information\nthat is privileged, confidential and exempt from disclosure under applicable\nlaw.  If the reader of this message and the accompanying documents is not the\nintended recipient or the employee or agent responsible for delivering the\nmessage to the intended recipient, you are hereby notified that any\ndissemination, distribution or copying of this communication is strictly\nprohibited.  If you have received this communication in error, please notify us\nimmediately by telephone and fully delete the original message and any\naccompanying documents.  Thank you.
(CAD call 130920082) Call#: 130920082*                                                               \nTime: 14:06:13*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: 1375 CATAMOUNT DR, GOLDEN*                                            \nCross streets: PINE RIDGE RD/ GOLDEN GATE CANYON RD*                            \nMap page: MAP A1  *                                                             \nUnits: MED21*                                                                   \nNarrative: according to nurse at st joes needs to go there                      \nnow con and breath                                                              \non blood pressure meds                                                          \nmid 80s female                                                                  \ncon and breath*                                                                 \n\n\n\n\n\nThis email and the attached documents (if any) are intended only for the use of\nthe individual or entity to which they are addressed and may contain information\nthat is privileged, confidential and exempt from disclosure under applicable\nlaw.  If the reader of this message and the accompanying documents is not the\nintended recipient or the employee or agent responsible for delivering the\nmessage to the intended recipient, you are hereby notified that any\ndissemination, distribution or copying of this communication is strictly\nprohibited.  If you have received this communication in error, please notify us\nimmediately by telephone and fully delete the original message and any\naccompanying documents.  Thank you.
(CAD call 130920077) Call#: 130920077*                                                               \nTime: 13:56:43*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: 814 RABBIT RUN DR, GOLDEN*                                            \nCross streets: EAGLE RIDGE DR/ EAGLE RIDGE DR*                                  \nMap page: MAP H3  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: zone 6*                                                              \n\n\n\n\n\nThis email and the attached documents (if any) are intended only for the use of\nthe individual or entity to which they are addressed and may contain information\nthat is privileged, confidential and exempt from disclosure under applicable\nlaw.  If the reader of this message and the accompanying documents is not the\nintended recipient or the employee or agent responsible for delivering the\nmessage to the intended recipient, you are hereby notified that any\ndissemination, distribution or copying of this communication is strictly\nprohibited.  If you have received this communication in error, please notify us\nimmediately by telephone and fully delete the original message and any\naccompanying documents.  Thank you.
(CAD call 130920025) Call#: 130920025*                                                               \nTime: 08:15:05*                                                                 \nType of call: Fire Alarm Activation (73)*                                       \nLocation: WATER TREATMENT PLANT, 1409 10TH ST, GOLDEN*                          \nCross streets: MAPLE ST/ MAPLE ST*                                              \nMap page: MAP E2  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: smoke detector in kitchen burnt food*                                \n\n\n\n\n\nThis email and the attached documents (if any) are intended only for the use of\nthe individual or entity to which they are addressed and may contain information\nthat is privileged, confidential and exempt from disclosure under applicable\nlaw.  If the reader of this message and the accompanying documents is not the\nintended recipient or the employee or agent responsible for delivering the\nmessage to the intended recipient, you are hereby notified that any\ndissemination, distribution or copying of this communication is strictly\nprohibited.  If you have received this communication in error, please notify us\nimmediately by telephone and fully delete the original message and any\naccompanying documents.  Thank you.
(CAD call 130910055) Call#: 130910055*                                                               \nTime: 16:10:40*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: 18236 W 4TH AVE, GOLDEN*                                              \nCross streets: ZETA ST/ GOLDEN CIR*                                             \nMap page: MAP J4  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: copd / emphazema / 66 yom c/ diff breath*                            \n\n\n\n\n\nThis email and the attached documents (if any) are intended only for the use of\nthe individual or entity to which they are addressed and may contain information\nthat is privileged, confidential and exempt from disclosure under applicable\nlaw.  If the reader of this message and the accompanying documents is not the\nintended recipient or the employee or agent responsible for delivering the\nmessage to the intended recipient, you are hereby notified that any\ndissemination, distribution or copying of this communication is strictly\nprohibited.  If you have received this communication in error, please notify us\nimmediately by telephone and fully delete the original message and any\naccompanying documents.  Thank you.
(CAD call 130910050) Call#: 130910050*                                                               \nTime: 14:54:22*                                                                 \nType of call: Ambulance/EMS Call (32)*                                          \nLocation: 1270 N FORD ST A100, GOLDEN*                                          \nCross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \nMap page: MAP A2  *                                                             \nUnits: MED21*                                                                   \nNarrative: 96 yof c/b fell from wheel chair                                     \nposs right hip injury*                                                          \n\n\n\n\n\nThis email and the attached documents (if any) are intended only for the use of\nthe individual or entity to which they are addressed and may contain information\nthat is privileged, confidential and exempt from disclosure under applicable\nlaw.  If the reader of this message and the accompanying documents is not the\nintended recipient or the employee or agent responsible for delivering the\nmessage to the intended recipient, you are hereby notified that any\ndissemination, distribution or copying of this communication is strictly\nprohibited.  If you have received this communication in error, please notify us\nimmediately by telephone and fully delete the original message and any\naccompanying documents.  Thank you.
(CAD call 130910032) Call#: 130910032*                                                               \nTime: 10:56:46*                                                                 \nType of call: Ambulance and Rescue*                                             \nLocation: JEFFERSON COUNTY COURT HOUSE, 100 JEFFERSON COUNTY PKY, GOLDEN*       \nCross streets: COURTHOUSE DR/ COURTHOUSE DR*                                    \nMap page: MAP I4  *                                                             \nUnits: DIST1 DIST2*                                                             \nNarrative: 38yom is c is b chest pains                                          \nwill meet in the security*                                                      \n\n\n\n\n\nThis email and the attached documents (if any) are intended only for the use of\nthe individual or entity to which they are addressed and may contain information\nthat is privileged, confidential and exempt from disclosure under applicable\nlaw.  If the reader of this message and the accompanying documents is not the\nintended recipient or the employee or agent responsible for delivering the\nmessage to the intended recipient, you are hereby notified that any\ndissemination, distribution or copying of this communication is strictly\nprohibited.  If you have received this communication in error, please notify us\nimmediately by telephone and fully delete the original message and any\naccompanying documents.  Thank you.

 */


public class COGoldenParserTest extends BaseParserTest {
  
  public COGoldenParserTest() {
    setParser(new COGoldenParser(), "GOLDEN", "CO");
  }
  
  @Test
  public void testGoldenFD1() {

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
        "ADDR:1030 JOHNSON RD",
        "APT:U200",
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
        "ADDR:517 15TH ST",
        "APT:A2",
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
        "ADDR:18301 W COLFAX AVE",
        "APT:U101",
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
        "ADDR:1400 UTAH ST",
        "APT:A208",
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
        "ADDR:660 GOLDEN RIDGE RD",
        "APT:U250",
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
        "ADDR:1270 N FORD ST",
        "APT:R1B",
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
        "ADDR:C470 HWY & I-70 HWY",
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
        "ADDR:18301 W COLFAX AVE",
        "APT:SHOPS",
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
        "ADDR:911 10TH ST",
        "APT:GFD1",
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
        "ADDR:920 15TH ST",
        "APT:R318",
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
        "MADDR:200 JEFFERSON COUNTY PKWY",
        "CITY:GOLDEN",
        "X:W 10TH AVE/W 10TH AVE",
        "UNIT:DIST1 DIST2",
        "INFO:unk party down-emergent-come in thru sally port");

  }
  
  @Test
  public void testGoldenFD2() {

    doTest("T1",
        "[Golden Fire] Call#: 122560092*                                                               \r\r\n" +
        "Time: 21:45:56*                                                                 \r\r\n" +
        "Type of call: Fire Alarm Activation (73)*                                       \r\r\n" +
        "Location: 130 CRAWFORD CIR, GOLDEN*                                             \r\r\n" +
        "Cross streets: BURGESS AVE/ DEFRANCE WAY*                                       \r\r\n" +
        "Map page: MAP J3  *                                                             \r\r\n" +
        "Units: DIST1 DIST2*\r\r\n" +
        "Narrative: poss co                                                              \r\r\n" +
        "turned off valve to gas fireplace                                               \r\r\n" +
        "aired/*                                                                         \r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "  \r\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "ID:122560092",
        "TIME:21:45:56",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:130 CRAWFORD CIR",
        "CITY:GOLDEN",
        "X:BURGESS AVE/ DEFRANCE WAY",
        "MAP:J3",
        "UNIT:DIST1 DIST2",
        "INFO:poss co\nturned off valve to gas fireplace\naired/*");

    doTest("T2",
        "[Golden Fire] Call#: 122570021*                                                               \r\r\n" +
        "Time: 07:19:06*                                                                 \r\r\n" +
        "Type of call: Ambulance and Rescue*                                             \r\r\n" +
        "Location: 17881 W COLFAX AVE, GOLDEN*                                           \r\r\n" +
        "Cross streets: WEST ST/ XYLON ST*\r\r\n" +
        "Map page: MAP J4  *                                                             \r\r\n" +
        "Units: DIST1 DIST2*\r\r\n" +
        "Narrative: rp feeling dizzy and lightheaded                                     \r\r\n" +
        "61 yof colon cancer                                                             \r\r\n" +
        "con and breath                                                                  \r\r\n" +
        "diff breathing*                                                                 \r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "  \r\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "ID:122570021",
        "TIME:07:19:06",
        "CALL:Ambulance and Rescue",
        "ADDR:17881 W COLFAX AVE",
        "CITY:GOLDEN",
        "X:WEST ST/ XYLON ST",
        "MAP:J4",
        "UNIT:DIST1 DIST2",
        "INFO:rp feeling dizzy and lightheaded\n61 yof colon cancer\ncon and breath\ndiff breathing*");

    doTest("T3",
        "[Golden Fire] Call#: 122570073*                                                               \r\r\n" +
        "Time: 16:14:46*                                                                 \r\r\n" +
        "Type of call: Smoke/Odor Complaint/Call (53)*                                   \r\r\n" +
        "Location: HERITAGE RD/W COLFAX AVE, GOLDEN*                                     \r\r\n" +
        "Map page: MAP K4  *\r\r\n" +
        "Units: DIST1 DIST2*                                                             \r\r\n" +
        "Narrative: sees smoke in area, says not quary and smells smoke*                 \r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "  \r\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "ID:122570073",
        "TIME:16:14:46",
        "CALL:Smoke/Odor Complaint/Call (53)",
        "ADDR:HERITAGE RD & W COLFAX AVE",
        "CITY:GOLDEN",
        "MAP:K4",
        "UNIT:DIST1 DIST2",
        "INFO:sees smoke in area, says not quary and smells smoke*");

    doTest("T4",
        "[Golden Fire] Call#: 122580034*                                                               \r\r\n" +
        "Time: 10:20:13*                                                                 \r\r\n" +
        "Type of call: Ambulance and Rescue*                                             \r\r\n" +
        "Location: JEFFERSON COUNTY COURT HOUSE, 100 JEFFERSON COUNTY PKY, GOLDEN*       \r\r\n" +
        "Cross streets: COURTHOUSE DR/ COURTHOUSE DR*                                    \r\r\n" +
        "Map page: MAP I4  *                                                             \r\r\n" +
        "Units: DIST1 DIST2*                                                             \r\r\n" +
        "Narrative: 35 yo/f                                                              \r\r\n" +
        "con seizure                                                                     \r\r\n" +
        "difficulty breathing                                                            \r\r\n" +
        "not in seizure now                                                              \r\r\n" +
        "respond to front of court house*                                                \r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "  \r\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "ID:122580034",
        "TIME:10:20:13",
        "CALL:Ambulance and Rescue",
        "PLACE:JEFFERSON COUNTY COURT HOUSE",
        "ADDR:100 JEFFERSON COUNTY PKY",
        "MADDR:100 JEFFERSON COUNTY PKWY",
        "CITY:GOLDEN",
        "X:COURTHOUSE DR/ COURTHOUSE DR",
        "MAP:I4",
        "UNIT:DIST1 DIST2",
        "INFO:35 yo/f\ncon seizure\ndifficulty breathing\nnot in seizure now\nrespond to front of court house*");

    doTest("T5",
        "[Golden Fire] Call#: 122580074*                                                               \r\r\n" +
        "Time: 18:03:55*                                                                 \r\r\n" +
        "Type of call: Ambulance and Rescue*                                             \r\r\n" +
        "Location: 16035 W 4TH AVE, GOLDEN*                                              \r\r\n" +
        "Cross streets: ORCHARD ST/ ORION ST*                                            \r\r\n" +
        "Map page: MAP J6  *                                                             \r\r\n" +
        "Units: DIST1 DIST2*                                                             \r\r\n" +
        "Narrative: aired to pd                                                          \r\r\n" +
        "male diff breathing                                                             \r\r\n" +
        "36 yom / amb will have access*                                                  \r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "  \r\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "ID:122580074",
        "TIME:18:03:55",
        "CALL:Ambulance and Rescue",
        "ADDR:16035 W 4TH AVE",
        "CITY:GOLDEN",
        "X:ORCHARD ST/ ORION ST",
        "MAP:J6",
        "UNIT:DIST1 DIST2",
        "INFO:aired to pd\nmale diff breathing\n36 yom / amb will have access*");

    doTest("T6",
        "[Golden Fire] Call#: 122590040*                                                               \r\r\n" +
        "Time: 11:40:15*                                                                 \r\r\n" +
        "Type of call: Unknown Injury Traffic Accident*                                  \r\r\n" +
        "Location: HWY 6/ 19TH ST, GOLDEN*                                               \r\r\n" +
        "Map page: MAP F3  *                                                             \r\r\n" +
        "Units: DIST1 DIST2*                                                             \r\r\n" +
        "Narrative: car vs bicyclist                                                     \r\r\n" +
        "yelling at each other as well                                                   \r\r\n" +
        "drk grn suv*                                                                    \r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "  \r\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "ID:122590040",
        "TIME:11:40:15",
        "CALL:Unknown Injury Traffic Accident",
        "ADDR:HWY 6 & 19TH ST",
        "CITY:GOLDEN",
        "MAP:F3",
        "UNIT:DIST1 DIST2",
        "INFO:car vs bicyclist\nyelling at each other as well\ndrk grn suv*");

    doTest("T7",
        "[Golden Fire] Call#: 122590072*                                                               \r\r\n" +
        "Time: 17:35:28*                                                                 \r\r\n" +
        "Type of call: Fire Alarm Activation (73)*                                       \r\r\n" +
        "Location: 17700 SOUTH GOLDEN RD, GOLDEN*                                        \r\r\n" +
        "Cross streets: LUNNONHAUS DR/ JOHNSON RD*                                       \r\r\n" +
        "Map page: MAP G4  *                                                             \r\r\n" +
        "Units: DIST1 DIST2*                                                             \r\r\n" +
        "Narrative: doesn't specify business name                                        \r\r\n" +
        "premise 303 443 3313*                                                           \r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "\r\r\n" +
        "  \r\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "ID:122590072",
        "TIME:17:35:28",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:17700 SOUTH GOLDEN RD",
        "CITY:GOLDEN",
        "X:LUNNONHAUS DR/ JOHNSON RD",
        "MAP:G4",
        "UNIT:DIST1 DIST2",
        "INFO:doesn't specify business name\npremise 303 443 3313*");

    doTest("T8",
        "[Golden Fire] Call#: 123550120*                                                               \r\n" +
        "Time: 22:51:47*                                                                 \r\n" +
        "Type of call: Mutual Aid*                                                       \r\n" +
        "Location: 1430 JOYCE ST*                                                        \r\n" +
        "Cross streets:/*                                                                \r\n" +
        "Units: DIST1 DIST2*                                                          \r\n" +
        "Narrative: eng and rescue fire se*",

        "ID:123550120",
        "TIME:22:51:47",
        "CALL:Mutual Aid",
        "ADDR:1430 JOYCE ST",
        "UNIT:DIST1 DIST2",
        "INFO:eng and rescue fire se*");

  }
  
  @Test
  public void testGoldenFD3() {

    doTest("T1",
        "(Golden Fire) Call#: 130070096*                                                               \n" +
        "Time: 18:45:41*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 1200 GOLDEN CIR, GOLDEN*                                              \n" +
        "Cross streets: GOLDEN CIR/ GOLDEN CIR*                                          \n" +
        "Map page: MAP I4  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: bldg 10 automatic*                                                   \n\n\n\n\n\n" +
        "  ",

        "ID:130070096",
        "TIME:18:45:41",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:1200 GOLDEN CIR",
        "CITY:GOLDEN",
        "X:GOLDEN CIR/ GOLDEN CIR",
        "MAP:I4",
        "UNIT:DIST1 DIST2",
        "INFO:bldg 10 automatic*");

    doTest("T2",
        "(Golden Fire) Call#: 130070087*                                                               \n" +
        "Time: 17:37:24*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 149 KIMBALL AVE, GOLDEN*                                              \n" +
        "Cross streets: DEFRANCE WAY/ CRAWFORD ST*                                       \n" +
        "Map page: MAP K3  *                                                             \n" +
        "Units: DIST1 DIST2 MED22*                                                       \n" +
        "Narrative: c/b diff breathing 38 yof*                                           \n\n\n\n\n\n" +
        "  ",

        "ID:130070087",
        "TIME:17:37:24",
        "CALL:Ambulance and Rescue",
        "ADDR:149 KIMBALL AVE",
        "CITY:GOLDEN",
        "X:DEFRANCE WAY/ CRAWFORD ST",
        "MAP:K3",
        "UNIT:DIST1 DIST2 MED22",
        "INFO:c/b diff breathing 38 yof*");

    doTest("T3",
        "(Golden Fire) Call#: 130070080*                                                               \n" +
        "Time: 16:08:32*                                                                 \n" +
        "Type of call: Water Problem/Pipe Break (52)*                                    \n" +
        "Location: 2201 ILLINOIS ST, GOLDEN*                                             \n" +
        "Cross streets: 22ND ST/ 23RD ST*                                                \n" +
        "Map page: MAP F3  *                                                             \n" +
        "Units: CHF21 DIST1 DIST2*                                                       \n" +
        "Narrative: water puring out of basement*                                        \n\n\n\n\n\n" +
        "  ",

        "ID:130070080",
        "TIME:16:08:32",
        "CALL:Water Problem/Pipe Break (52)",
        "ADDR:2201 ILLINOIS ST",
        "CITY:GOLDEN",
        "X:22ND ST/ 23RD ST",
        "MAP:F3",
        "UNIT:CHF21 DIST1 DIST2",
        "INFO:water puring out of basement*");

    doTest("T4",
        "(Golden Fire) Call#: 130070046*                                                               \n" +
        "Time: 12:01:06*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 355 C ST, GOLDEN*                                                     \n" +
        "Cross streets: ZETA ST/ ZURICH ST*                                              \n" +
        "Map page: MAP J4  *                                                             \n" +
        "Units: DIST1 DIST2 MED22*                                                       \n" +
        "Narrative: aired to pd                                                          \n" +
        "ulcer and severe pain c/b                                                       \n" +
        "23 yo male                                                                      \n" +
        "Call emailed to:                                                                \n" +
        "2023@iaralerts.com                                                              \n" +
        "2023b@iaralerts.com*                                                            \n\n\n\n\n\n" +
        "  ",

        "ID:130070046",
        "TIME:12:01:06",
        "CALL:Ambulance and Rescue",
        "ADDR:355 C ST",
        "CITY:GOLDEN",
        "X:ZETA ST/ ZURICH ST",
        "MAP:J4",
        "UNIT:DIST1 DIST2 MED22",
        "INFO:aired to pd\nulcer and severe pain c/b\n23 yo male\nCall emailed to:\n2023@iaralerts.com\n2023b@iaralerts.com*");

    doTest("T5",
        "(Golden Fire) Call#: 130070028*                                                               \n" +
        "Time: 09:29:25*                                                                 \n" +
        "Type of call: Vehicle/Car Fire (13)*                                            \n" +
        "Location: PANORAMA ORTHOPEDICS, 660 GOLDEN RIDGE RD U250, GOLDEN*               \n" +
        "Cross streets: HERITAGE RD/ HERITAGE RD*                                        \n" +
        "Map page: MAP I4  *                                                             \n" +
        "Units: DIST1 DIST2 BAT21 MED22*                                                 \n" +
        "Narrative: per cr4/smoke visible from shops                                     \n" +
        "no flames seen                                                                  \n" +
        "flames visible/                                                                 \n" +
        "in main parking lot black smoke                                                 \n" +
        "Call emailed to:                                                                \n" +
        "2023@iaralerts.com                                                              \n" +
        "2023b@iaralerts.com*                                                            \n\n\n\n\n\n" +
        "  ",

        "ID:130070028",
        "TIME:09:29:25",
        "CALL:Vehicle/Car Fire (13)",
        "PLACE:PANORAMA ORTHOPEDICS",
        "ADDR:660 GOLDEN RIDGE RD",
        "APT:U250",
        "CITY:GOLDEN",
        "X:HERITAGE RD/ HERITAGE RD",
        "MAP:I4",
        "UNIT:DIST1 DIST2 BAT21 MED22",
        "INFO:per cr4/smoke visible from shops\nno flames seen\nflames visible/\nin main parking lot black smoke\nCall emailed to:\n2023@iaralerts.com\n2023b@iaralerts.com*");

    doTest("T6",
        "(Golden Fire) Call#: 130070021*                                                               \n" +
        "Time: 08:25:22*                                                                 \n" +
        "Type of call: Ambulance call only (32)*                                         \n" +
        "Location: 249 CRAWFORD DR, GOLDEN*                                              \n" +
        "Cross streets: DEFRANCE DR/ CRAWFORD ST*                                        \n" +
        "Map page: MAP J3  *                                                             \n" +
        "Units: MED22*                                                                   \n" +
        "Narrative: front door unlockd lift assist*                                      \n\n\n\n\n\n" +
        "  ",

        "ID:130070021",
        "TIME:08:25:22",
        "CALL:Ambulance call only (32)",
        "ADDR:249 CRAWFORD DR",
        "CITY:GOLDEN",
        "X:DEFRANCE DR/ CRAWFORD ST",
        "MAP:J3",
        "UNIT:MED22",
        "INFO:front door unlockd lift assist*");

    doTest("T7",
        "(Golden Fire) Call#: 130070012*                                                               \n" +
        "Time: 06:21:56*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 1828 MT ZION DR, GOLDEN*                                              \n" +
        "Cross streets: PINAL RD/ FOOTHILLS RD*                                          \n" +
        "Map page: MAP F2  *                                                             \n" +
        "Units: DIST1 DIST2 MED21*                                                       \n" +
        "Narrative: some diff breat 90 yof*                                              \n\n\n\n\n\n" +
        "  ",

        "ID:130070012",
        "TIME:06:21:56",
        "CALL:Ambulance and Rescue",
        "ADDR:1828 MT ZION DR",
        "CITY:GOLDEN",
        "X:PINAL RD/ FOOTHILLS RD",
        "MAP:F2",
        "UNIT:DIST1 DIST2 MED21",
        "INFO:some diff breat 90 yof*");

    doTest("T8",
        "(Golden Fire) Call#: 130060070*                                                               \n" +
        "Time: 17:37:37*                                                                 \n" +
        "Type of call: Extrication/Rescue/Climber (35)*                                  \n" +
        "Location: WHITE WATER KAYAK PARK, 1201 10TH ST, GOLDEN*                         \n" +
        "Cross streets: MAPLE ST/ MAPLE ST*                                              \n" +
        "Map page: MAP E2  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n\n\n\n\n\n" +
        "  ",

        "ID:130060070",
        "TIME:17:37:37",
        "CALL:Extrication/Rescue/Climber (35)",
        "PLACE:WHITE WATER KAYAK PARK",
        "ADDR:1201 10TH ST",
        "CITY:GOLDEN",
        "X:MAPLE ST/ MAPLE ST",
        "MAP:E2",
        "UNIT:DIST1 DIST2*");

    doTest("T9",
        "(Golden Fire) Call#: 130060061*                                                               \n" +
        "Time: 15:13:26*                                                                 \n" +
        "Type of call: Canyon Call*                                                      \n" +
        "Location: TUNNEL # 1 EAST END, 270 HWY 6 .4MM, GOLDEN*                          \n" +
        "Cross streets: HWY 93/ HWY 119*                                                 \n" +
        "Map page: NO MAP  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: somebody down near the creek                                         \n" +
        "bleeding, shivering                                                             \n" +
        "near creek, poss male                                                           \n" +
        "rp not with him                                                                 \n" +
        "drk jacket, drk pants                                                           \n" +
        "rp is on the boardwalk trail south of the creek                                 \n" +
        "about 1 mile east of tun1                                                       \n" +
        "rp and other ppl cannot get to road; stuck on the trail                         \n" +
        "rp is fem wearing drk blu jacket and blue jeans*                                \n\n\n\n\n\n" +
        "  ",

        "ID:130060061",
        "TIME:15:13:26",
        "CALL:Canyon Call",
        "PLACE:TUNNEL # 1 EAST END",
        "ADDR:270 HWY 6 .4MM",
        "CITY:GOLDEN",
        "X:HWY 93/ HWY 119",
        "MAP:NO MAP",
        "UNIT:DIST1 DIST2",
        "INFO:somebody down near the creek\nbleeding, shivering\nnear creek, poss male\nrp not with him\ndrk jacket, drk pants\nrp is on the boardwalk trail south of the creek\nabout 1 mile east of tun1\nrp and other ppl cannot get to road; stuck on the trail\nrp is fem wearing drk blu jacket and blue jeans*");

    doTest("T10",
        "(Golden Fire) Call#: 130060039*                                                               \n" +
        "Time: 10:07:58*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 1270 N FORD ST, GOLDEN*                                               \n" +
        "Cross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \n" +
        "Map page: MAP A2  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: poss stroke/                                                         \n" +
        "weakness on l side                                                              \n" +
        "late 80s 90s                                                                    \n" +
        "is c is b                                                                       \n" +
        "is 91 yo f*                                                                     \n\n\n\n\n\n" +
        "  ",

        "ID:130060039",
        "TIME:10:07:58",
        "CALL:Ambulance and Rescue",
        "ADDR:1270 N FORD ST",
        "CITY:GOLDEN",
        "X:PINE RIDGE RD/ VIRGINIA ST",
        "MAP:A2",
        "UNIT:DIST1 DIST2",
        "INFO:poss stroke/\nweakness on l side\nlate 80s 90s\nis c is b\nis 91 yo f*");

    doTest("T11",
        "(Golden Fire) Call#: 130050058*                                                               \n" +
        "Time: 21:12:35*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 1800 W CAMPUS RD, GOLDEN*                                             \n" +
        "Cross streets: ELM ST/ 15TH ST*                                                 \n" +
        "Map page: MAP F3  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: general fire alarm*                                                  \n\n\n\n\n\n" +
        "  ",

        "ID:130050058",
        "TIME:21:12:35",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:1800 W CAMPUS RD",
        "CITY:GOLDEN",
        "X:ELM ST/ 15TH ST",
        "MAP:F3",
        "UNIT:DIST1 DIST2",
        "INFO:general fire alarm*");

    doTest("T12",
        "(Golden Fire) Call#: 130050038*                                                               \n" +
        "Time: 13:03:05*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 18301 W COLFAX AVE UD103, GOLDEN*                                     \n" +
        "Cross streets: W COLFAX AVE/ HERITAGE RD*                                       \n" +
        "Map page: MAP K3  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: trouble signals / carlos on site                                     \n" +
        "have a lot of water                                                             \n" +
        "premise 303-277-0040*                                                           \n\n\n\n\n\n" +
        "  ",

        "ID:130050038",
        "TIME:13:03:05",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:18301 W COLFAX AVE",
        "APT:UD103",
        "CITY:GOLDEN",
        "X:W COLFAX AVE/ HERITAGE RD",
        "MAP:K3",
        "UNIT:DIST1 DIST2",
        "INFO:trouble signals / carlos on site\nhave a lot of water\npremise 303-277-0040*");

    doTest("T13",
        "(Golden Fire) Call#: 130040088*                                                               \n" +
        "Time: 18:25:01*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 814 RABBIT RUN DR, GOLDEN*                                            \n" +
        "Cross streets: EAGLE RIDGE DR/ EAGLE RIDGE DR*                                  \n" +
        "Map page: MAP H3  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: ind/general                                                          \n" +
        "premise 303-278-6682 / res nam/hammontree                                       \n" +
        "aired to all units*                                                             \n\n\n\n\n\n" +
        "  ",

        "ID:130040088",
        "TIME:18:25:01",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:814 RABBIT RUN DR",
        "CITY:GOLDEN",
        "X:EAGLE RIDGE DR/ EAGLE RIDGE DR",
        "MAP:H3",
        "UNIT:DIST1 DIST2",
        "INFO:ind/general\npremise 303-278-6682 / res nam/hammontree\naired to all units*");

    doTest("T14",
        "(Golden Fire) Call#: 130040073*                                                               \n" +
        "Time: 15:14:23*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 1470 10TH ST, GOLDEN*                                                 \n" +
        "Cross streets: MAPLE ST/ MAPLE ST*                                              \n" +
        "Map page: MAP E2  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: ind is en alarm                                                      \n" +
        "kh will be contacted*                                                           \n\n\n\n\n\n" +
        "  ",

        "ID:130040073",
        "TIME:15:14:23",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:1470 10TH ST",
        "CITY:GOLDEN",
        "X:MAPLE ST/ MAPLE ST",
        "MAP:E2",
        "UNIT:DIST1 DIST2",
        "INFO:ind is en alarm\nkh will be contacted*");

    doTest("T15",
        "(Golden Fire) Call#: 130040067*                                                               \n" +
        "Time: 14:42:32*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: CSM M, 21400 LARIAT LOOP TRL, GOLDEN*                                 \n" +
        "Cross streets: MT ZION DR/ MT ZION DR*                                          \n" +
        "Map page: MAP G2  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: paraglider down below the m on east                                  \n" +
        "c/b 41 yo male                                                                  \n" +
        "lower back injuries*                                                            \n\n\n\n\n\n" +
        "  ",

        "ID:130040067",
        "TIME:14:42:32",
        "CALL:Ambulance and Rescue",
        "PLACE:CSM M",
        "ADDR:21400 LARIAT LOOP TRL",
        "CITY:GOLDEN",
        "X:MT ZION DR/ MT ZION DR",
        "MAP:G2",
        "UNIT:DIST1 DIST2",
        "INFO:paraglider down below the m on east\nc/b 41 yo male\nlower back injuries*");

    doTest("T16",
        "(Golden Fire) Call#: 130040064*                                                               \n" +
        "Time: 14:24:33*                                                                 \n" +
        "Type of call: Smoke/Odor Complaint/Call (53)*                                   \n" +
        "Location: STANLEY STEEMER, 621 CORPORATE CIR UJ, GOLDEN*                        \n" +
        "Cross streets: CONFERENCE PL/ CAPITAL DR*                                       \n" +
        "Map page: MAP J5  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: smoke investigation                                                  \n" +
        "strong smell inside bldg                                                        \n" +
        "no flames seen*                                                                 \n\n\n\n\n\n" +
        "  ",

        "ID:130040064",
        "TIME:14:24:33",
        "CALL:Smoke/Odor Complaint/Call (53)",
        "PLACE:STANLEY STEEMER",
        "ADDR:621 CORPORATE CIR",
        "APT:UJ",
        "CITY:GOLDEN",
        "X:CONFERENCE PL/ CAPITAL DR",
        "MAP:J5",
        "UNIT:DIST1 DIST2",
        "INFO:smoke investigation\nstrong smell inside bldg\nno flames seen*");

    doTest("T17",
        "(Golden Fire) Call#: 130040061*                                                               \n" +
        "Time: 14:17:25*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 912 HOMESTAKE DR, GOLDEN*                                             \n" +
        "Cross streets: ILLINOIS ST/ ILLINOIS ST*                                        \n" +
        "Map page: MAP G3  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: difficulty breathing c/b                                             \n" +
        "67 yo male                                                                      \n" +
        "aired*                                                                          \n\n\n\n\n\n" +
        "  ",

        "ID:130040061",
        "TIME:14:17:25",
        "CALL:Ambulance and Rescue",
        "ADDR:912 HOMESTAKE DR",
        "CITY:GOLDEN",
        "X:ILLINOIS ST/ ILLINOIS ST",
        "MAP:G3",
        "UNIT:DIST1 DIST2",
        "INFO:difficulty breathing c/b\n67 yo male\naired*");

    doTest("T18",
        "(Golden Fire) Call#: 130040033*                                                               \n" +
        "Time: 08:11:47*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 16950 W COLFAX AVE U104, GOLDEN*                                      \n" +
        "Cross streets: W COLFAX AVE/ INTER PLAZA WEST*                                  \n" +
        "Map page: MAP J5  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: female party passed out now c/b*                                     \n\n\n\n\n\n" +
        "  ",

        "ID:130040033",
        "TIME:08:11:47",
        "CALL:Ambulance and Rescue",
        "ADDR:16950 W COLFAX AVE",
        "APT:U104",
        "CITY:GOLDEN",
        "X:W COLFAX AVE/ INTER PLAZA WEST",
        "MAP:J5",
        "UNIT:DIST1 DIST2",
        "INFO:female party passed out now c/b*");

    doTest("T19",
        "(Golden Fire) Call#: 130030071*                                                               \n" +
        "Time: 15:35:12*                                                                 \n" +
        "Type of call: Extrication/Rescue/Climber (35)*                                  \n" +
        "Location: 400 INDIANA ST, GOLDEN*                                               \n" +
        "Cross streets: W 4TH AVE/W 4TH AVE*                                             \n" +
        "Map page: MAP J6  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: both patients on the second and need to be carried                   \n" +
        "down to the first floor                                                         \n" +
        "elevator are broken                                                             \n" +
        "is not life threatening*                                                        \n\n\n\n\n\n" +
        "  ",

        "ID:130030071",
        "TIME:15:35:12",
        "CALL:Extrication/Rescue/Climber (35)",
        "ADDR:400 INDIANA ST",
        "CITY:GOLDEN",
        "X:W 4TH AVE/W 4TH AVE",
        "MAP:J6",
        "UNIT:DIST1 DIST2",
        "INFO:both patients on the second and need to be carried\ndown to the first floor\nelevator are broken\nis not life threatening*");

    doTest("T20",
        "(Golden Fire) Call#: 130030059*                                                               \n" +
        "Time: 14:12:59*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 722 WASHINGTON AVE, GOLDEN*                                           \n" +
        "Cross streets: 7TH ST/ 8TH ST*                                                  \n" +
        "Map page: MAP D2  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: aud/ first floor office  general*                                    \n\n\n\n\n\n" +
        "  ",

        "ID:130030059",
        "TIME:14:12:59",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:722 WASHINGTON AVE",
        "CITY:GOLDEN",
        "X:7TH ST/ 8TH ST",
        "MAP:D2",
        "UNIT:DIST1 DIST2",
        "INFO:aud/ first floor office  general*");

    doTest("T21",
        "(Golden Fire) Call#: 130030052*                                                               \n" +
        "Time: 13:15:20*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 700 JEFFERSON COUNTY PKY, GOLDEN*                                     \n" +
        "Cross streets: ILLINOIS ST/W 10TH AVE*                                          \n" +
        "Map page: MAP H4  *                                                             \n" +
        "Units: STA21 DIST1 DIST2*                                                       \n" +
        "Narrative: aud fire alarm general and water flow 720.201.6257*                  \n\n\n\n\n\n" +
        "  ",

        "ID:130030052",
        "TIME:13:15:20",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:700 JEFFERSON COUNTY PKY",
        "MADDR:700 JEFFERSON COUNTY PKWY",
        "CITY:GOLDEN",
        "X:ILLINOIS ST/W 10TH AVE",
        "MAP:H4",
        "UNIT:STA21 DIST1 DIST2",
        "INFO:aud fire alarm general and water flow 720.201.6257*");

    doTest("T22",
        "(Golden Fire) Call#: 130030037*                                                               \n" +
        "Time: 10:28:27*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 1270 N FORD ST, GOLDEN*                                               \n" +
        "Cross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \n" +
        "Map page: MAP A2  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: room 260                                                             \n" +
        "female unresponsive c/b                                                         \n" +
        "unk age*                                                                        \n\n\n\n\n\n" +
        "  ",

        "ID:130030037",
        "TIME:10:28:27",
        "CALL:Ambulance and Rescue",
        "ADDR:1270 N FORD ST",
        "CITY:GOLDEN",
        "X:PINE RIDGE RD/ VIRGINIA ST",
        "MAP:A2",
        "UNIT:DIST1 DIST2",
        "INFO:room 260\nfemale unresponsive c/b\nunk age*");

    doTest("T23",
        "(Golden Fire) Call#: 130010056*                                                               \n" +
        "Time: 19:11:45*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: 1903 MT ZION DR, GOLDEN*                                              \n" +
        "Cross streets: FOOTHILLS RD/ GOLDENVUE DR*                                      \n" +
        "Map page: MAP F2  *                                                             \n" +
        "Units: STA21 AMR131*                                                            \n" +
        "Narrative: has stomach flu / ongoing issues with diahera                        \n" +
        "rp there with wife / has dementia                                               \n" +
        "75 yom                                                                          \n" +
        "no amr call sign avail / used sta21 as call sign for this                       \n" +
        "incident*                                                                       \n\n\n\n\n\n" +
        "  ",

        "ID:130010056",
        "TIME:19:11:45",
        "CALL:Ambulance/EMS Call (32)",
        "ADDR:1903 MT ZION DR",
        "CITY:GOLDEN",
        "X:FOOTHILLS RD/ GOLDENVUE DR",
        "MAP:F2",
        "UNIT:STA21 AMR131",
        "INFO:has stomach flu / ongoing issues with diahera\nrp there with wife / has dementia\n75 yom\nno amr call sign avail / used sta21 as call sign for this\nincident*");

    doTest("T24",
        "(Golden Fire) Call#: 130010054*                                                               \n" +
        "Time: 19:00:50*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: 1613 GOLDEN HILLS RD, GOLDEN*                                         \n" +
        "Cross streets: GOLDEN HILLS PL/ GOLDEN HILLS PL*                                \n" +
        "Map page: MAP G5  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n\n\n\n\n\n" +
        "  ",

        "ID:130010054",
        "TIME:19:00:50",
        "CALL:Ambulance/EMS Call (32)",
        "ADDR:1613 GOLDEN HILLS RD",
        "CITY:GOLDEN",
        "X:GOLDEN HILLS PL/ GOLDEN HILLS PL",
        "MAP:G5",
        "UNIT:DIST1 DIST2*");

    doTest("T25",
        "(Golden Fire) Call#: 130010052*                                                               \n" +
        "Time: 18:33:31*                                                                 \n" +
        "Type of call: Mutual Aid*                                                       \n" +
        "Location: 15100 W 13TH AVE*                                                     \n" +
        "Cross streets:/*                                                                \n" +
        "Units: BAT22 BAT21 DIST1 DIST2*                                                 \n" +
        "Narrative: one eng and one res                                                  \n" +
        "garage w/two veh inside                                                         \n" +
        "joyce / juniper nearest cross                                                   \n" +
        "command post at same loc*                                                       \n\n\n\n\n\n" +
        "  ",

        "ID:130010052",
        "TIME:18:33:31",
        "CALL:Mutual Aid",
        "ADDR:15100 W 13TH AVE",
        "UNIT:BAT22 BAT21 DIST1 DIST2",
        "INFO:one eng and one res\ngarage w/two veh inside\njoyce / juniper nearest cross\ncommand post at same loc*");

    doTest("T26",
        "(Golden Fire) Call#: 130010042*                                                               \n" +
        "Time: 16:01:15*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 900 GOLDEN PARK DR AD, GOLDEN*                                        \n" +
        "Cross streets: GOLDEN PARK PL/ GOLDEN PARK PL*                                  \n" +
        "Map page: MAP C2  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: man passed out in backyard in shorts                                 \n" +
        "not responding                                                                  \n" +
        "20 yom                                                                          \n" +
        "laying on hands*                                                                \n\n\n\n\n\n" +
        "  ",

        "ID:130010042",
        "TIME:16:01:15",
        "CALL:Ambulance and Rescue",
        "ADDR:900 GOLDEN PARK DR",
        "APT:AD",
        "CITY:GOLDEN",
        "X:GOLDEN PARK PL/ GOLDEN PARK PL",
        "MAP:C2",
        "UNIT:DIST1 DIST2",
        "INFO:man passed out in backyard in shorts\nnot responding\n20 yom\nlaying on hands*");

    doTest("T27",
        "(Golden Fire) Call#: 130010021*                                                               \n" +
        "Time: 09:26:40*                                                                 \n" +
        "Type of call: Unknown Injury Traffic Accident*                                  \n" +
        "Location: HWY 6/ 19TH ST, GOLDEN*                                               \n" +
        "Map page: MAP F3  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: caller stated jeffco on scene                                        \n" +
        "slide off                                                                       \n" +
        "jeffco ckng injuries                                                            \n" +
        "only 1 occupant                                                                 \n" +
        "subaru lost control went into ditch                                             \n" +
        "on west side now                                                                \n" +
        "unk inj                                                                         \n" +
        "j s o intersection*                                                             \n\n\n\n\n\n" +
        "  ",

        "ID:130010021",
        "TIME:09:26:40",
        "CALL:Unknown Injury Traffic Accident",
        "ADDR:HWY 6 & 19TH ST",
        "CITY:GOLDEN",
        "MAP:F3",
        "UNIT:DIST1 DIST2",
        "INFO:caller stated jeffco on scene\nslide off\njeffco ckng injuries\nonly 1 occupant\nsubaru lost control went into ditch\non west side now\nunk inj\nj s o intersection*");

    doTest("T28",
        "(Golden Fire) Call#: 123660042*                                                               \n" +
        "Time: 17:40:27*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 312 WHITE ASH DR, GOLDEN*                                             \n" +
        "Cross streets: WILD ROSE CT/ WASHINGTON ST*                                     \n" +
        "Map page: MAP C1  *                                                             \n" +
        "Units: DIST1*                                                                   \n" +
        "Narrative: neighbor hears it / poss smoke alarm                                 \n" +
        "no ind of fire                                                                  \n" +
        "texted home owner / no response                                                 \n" +
        "melissa barbara / lights on / did not knock on door                             \n" +
        "got home owner to come to door                                                  \n" +
        "will call if needed                                                             \n" +
        "owner called / cannot reset*                                                    \n\n\n\n\n\n" +
        "  ",

        "ID:123660042",
        "TIME:17:40:27",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:312 WHITE ASH DR",
        "CITY:GOLDEN",
        "X:WILD ROSE CT/ WASHINGTON ST",
        "MAP:C1",
        "UNIT:DIST1",
        "INFO:neighbor hears it / poss smoke alarm\nno ind of fire\ntexted home owner / no response\nmelissa barbara / lights on / did not knock on door\ngot home owner to come to door\nwill call if needed\nowner called / cannot reset*");

    doTest("T29",
        "(Golden Fire) Call#: 123660016*                                                               \n" +
        "Time: 09:00:45*                                                                 \n" +
        "Type of call: Ambulance call only (32)*                                         \n" +
        "Location: GOLDEN POLICE DEPARTMENT, 911 10TH ST GPD, GOLDEN*                    \n" +
        "Cross streets: ARAPAHOE ST/ CHEYENNE ST*                                        \n" +
        "Map page: MAP D2  *                                                             \n" +
        "Units: AMR131*                                                                  \n" +
        "Narrative: or blood draw*                                                       \n\n\n\n\n\n" +
        "  ",

        "ID:123660016",
        "TIME:09:00:45",
        "CALL:Ambulance call only (32)",
        "PLACE:GOLDEN POLICE DEPARTMENT",
        "ADDR:911 10TH ST",
        "APT:GPD",
        "CITY:GOLDEN",
        "X:ARAPAHOE ST/ CHEYENNE ST",
        "MAP:D2",
        "UNIT:AMR131",
        "INFO:or blood draw*");

    doTest("T30",
        "(Golden Fire) Call#: 123660009*                                                               \n" +
        "Time: 05:46:20*                                                                 \n" +
        "Type of call: Extrication/Rescue/Climber (35)*                                  \n" +
        "Location: C470 HWY/ I70 HWY, GOLDEN*                                            \n" +
        "Map page: MAP K5  *                                                             \n" +
        "Units: DIST1 DIST2 AMR132*                                                      \n" +
        "Narrative: 31                                                                   \n" +
        "Call emailed to:                                                                \n" +
        "2023@iaralerts.com                                                              \n" +
        "2023b@iaralerts.com*                                                            \n\n\n\n\n\n" +
        "  ",

        "ID:123660009",
        "TIME:05:46:20",
        "CALL:Extrication/Rescue/Climber (35)",
        "ADDR:C470 HWY & I-70 HWY",
        "MADDR:C470 HWY & I 70",
        "CITY:GOLDEN",
        "MAP:K5",
        "UNIT:DIST1 DIST2 AMR132",
        "INFO:31\nCall emailed to:\n2023@iaralerts.com\n2023b@iaralerts.com*");

    doTest("T31",
        "(Golden Fire) Call#: 123660009*                                                               \n" +
        "Time: 05:46:20*                                                                 \n" +
        "Type of call: Extrication/Rescue/Climber (35)*                                  \n" +
        "Location: C470 HWY/ I70 HWY, GOLDEN*                                            \n" +
        "Map page: MAP K5  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: 31*                                                                  \n\n\n\n\n\n" +
        "  ",

        "ID:123660009",
        "TIME:05:46:20",
        "CALL:Extrication/Rescue/Climber (35)",
        "ADDR:C470 HWY & I-70 HWY",
        "MADDR:C470 HWY & I 70",
        "CITY:GOLDEN",
        "MAP:K5",
        "UNIT:DIST1 DIST2",
        "INFO:31*");

    doTest("T32",
        "(Golden Fire) Call#: 123650052*                                                               \n" +
        "Time: 22:20:29*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: 18206 W 3RD AVE A4, GOLDEN*                                           \n" +
        "Cross streets: ZETA ST/ ZETA ST*                                                \n" +
        "Map page: MAP J4  *                                                             \n" +
        "Units: AMR132*                                                                  \n" +
        "Narrative: male with back pain, is on dialysis,  41*                            \n\n\n\n\n\n" +
        "  ",

        "ID:123650052",
        "TIME:22:20:29",
        "CALL:Ambulance/EMS Call (32)",
        "ADDR:18206 W 3RD AVE",
        "APT:A4",
        "CITY:GOLDEN",
        "X:ZETA ST/ ZETA ST",
        "MAP:J4",
        "UNIT:AMR132",
        "INFO:male with back pain, is on dialysis,  41*");

    doTest("T33",
        "(Golden Fire) Call#: 123650044*                                                               \n" +
        "Time: 19:19:05*                                                                 \n" +
        "Type of call: Ambulance call only (32)*                                         \n" +
        "Location: WASHINGTON AVE/ 10TH ST, GOLDEN*                                      \n" +
        "Map page: MAP D3  *                                                             \n" +
        "Units: AMR131*                                                                  \n" +
        "Narrative: dk male; complain leg pain*                                          \n\n\n\n\n\n" +
        "  ",

        "ID:123650044",
        "TIME:19:19:05",
        "CALL:Ambulance call only (32)",
        "ADDR:WASHINGTON AVE & 10TH ST",
        "CITY:GOLDEN",
        "MAP:D3",
        "UNIT:AMR131",
        "INFO:dk male; complain leg pain*");

    doTest("T34",
        "(Golden Fire) Call#: 123650026*                                                               \n" +
        "Time: 10:49:09*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: 1030 JOHNSON RD U200, GOLDEN*                                         \n" +
        "Cross streets: W 10TH AVE/W 14TH AVE*                                           \n" +
        "Map page: MAP H4  *                                                             \n" +
        "Units: AMR132 AMR131*                                                           \n" +
        "Narrative: patient is hypoxic                                                   \n" +
        "83yo m / is c / is b                                                            \n" +
        "on a rebreather 8 l pulxox of 70                                                \n" +
        "Call emailed to:                                                                \n" +
        "2023d@iaralerts.com*                                                            \n\n\n\n\n\n" +
        "  ",

        "ID:123650026",
        "TIME:10:49:09",
        "CALL:Ambulance/EMS Call (32)",
        "ADDR:1030 JOHNSON RD",
        "APT:U200",
        "CITY:GOLDEN",
        "X:W 10TH AVE/W 14TH AVE",
        "MAP:H4",
        "UNIT:AMR132 AMR131",
        "INFO:patient is hypoxic\n83yo m / is c / is b\non a rebreather 8 l pulxox of 70\nCall emailed to:\n2023d@iaralerts.com*");

    doTest("T35",
        "(Golden Fire) Call#: 123650026*                                                               \n" +
        "Time: 10:49:09*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: 1030 JOHNSON RD U200, GOLDEN*                                         \n" +
        "Cross streets: W 10TH AVE/W 14TH AVE*                                           \n" +
        "Map page: MAP H4  *                                                             \n" +
        "Units: AMR132*                                                                  \n" +
        "Narrative: patient is hypoxic                                                   \n" +
        "83yo m / is c / is b                                                            \n" +
        "on a rebreather 8 l pulxox of 70*                                               \n\n\n\n\n\n" +
        "  ",

        "ID:123650026",
        "TIME:10:49:09",
        "CALL:Ambulance/EMS Call (32)",
        "ADDR:1030 JOHNSON RD",
        "APT:U200",
        "CITY:GOLDEN",
        "X:W 10TH AVE/W 14TH AVE",
        "MAP:H4",
        "UNIT:AMR132",
        "INFO:patient is hypoxic\n83yo m / is c / is b\non a rebreather 8 l pulxox of 70*");

    doTest("T36",
        "(Golden Fire) Call#: 123640063*                                                               \n" +
        "Time: 21:55:37*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 1350 N FORD ST, GOLDEN*                                               \n" +
        "Cross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \n" +
        "Map page: MAP A2  *                                                             \n" +
        "Units: DIST1 ST1 DIST2 AMR AMR131*                                              \n" +
        "Narrative: unconcious not responding but breathing                              \n" +
        "room 208                                                                        \n" +
        "95 yo                                                                           \n" +
        "Call emailed to:                                                                \n" +
        "2023@iaralerts.com                                                              \n" +
        "2023b@iaralerts.com*                                                            \n\n\n\n\n\n" +
        "  ",

        "ID:123640063",
        "TIME:21:55:37",
        "CALL:Ambulance and Rescue",
        "ADDR:1350 N FORD ST",
        "CITY:GOLDEN",
        "X:PINE RIDGE RD/ VIRGINIA ST",
        "MAP:A2",
        "UNIT:DIST1 ST1 DIST2 AMR AMR131",
        "INFO:unconcious not responding but breathing\nroom 208\n95 yo\nCall emailed to:\n2023@iaralerts.com\n2023b@iaralerts.com*");

    doTest("T37",
        "(Golden Fire) Call#: 123640012*                                                               \n" +
        "Time: 08:40:42*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 700 JEFFERSON COUNTY PKY, GOLDEN*                                     \n" +
        "Cross streets: ILLINOIS ST/W 10TH AVE*                                          \n" +
        "Map page: MAP H4  *                                                             \n" +
        "Narrative: ind/general                                                          \n" +
        "premise 720-201-6257                                                            \n" +
        "shows water flow*                                                               \n\n\n\n\n\n" +
        "  ",

        "ID:123640012",
        "TIME:08:40:42",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:700 JEFFERSON COUNTY PKY",
        "MADDR:700 JEFFERSON COUNTY PKWY",
        "CITY:GOLDEN",
        "X:ILLINOIS ST/W 10TH AVE",
        "MAP:H4",
        "INFO:ind/general\npremise 720-201-6257\nshows water flow*");

    doTest("T38",
        "(Golden Fire) Call#: 123640001*                                                               \n" +
        "Time: 00:04:32*                                                                 \n" +
        "Type of call: Ambulance call only (32)*                                         \n" +
        "Location: GOLDEN POLICE DEPARTMENT, 911 10TH ST GPD, GOLDEN*                    \n" +
        "Cross streets: ARAPAHOE ST/ CHEYENNE ST*                                        \n" +
        "Map page: MAP D2  *                                                             \n" +
        "Units: AMR131*                                                                  \n" +
        "Narrative: blood test*                                                          \n\n\n\n\n\n" +
        "  ",

        "ID:123640001",
        "TIME:00:04:32",
        "CALL:Ambulance call only (32)",
        "PLACE:GOLDEN POLICE DEPARTMENT",
        "ADDR:911 10TH ST",
        "APT:GPD",
        "CITY:GOLDEN",
        "X:ARAPAHOE ST/ CHEYENNE ST",
        "MAP:D2",
        "UNIT:AMR131",
        "INFO:blood test*");

    doTest("T39",
        "(Golden Fire) Call#: 123630050*                                                               \n" +
        "Time: 13:42:14*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: JEFFERSON COUNTY COURT HOUSE, 100 JEFFERSON COUNTY PKY, GOLDEN*       \n" +
        "Cross streets: COURTHOUSE DR/ COURTHOUSE DR*                                    \n" +
        "Map page: MAP I4  *                                                             \n" +
        "Units: AMR132*                                                                  \n" +
        "Narrative: female spider bite open and bleeding                                 \n" +
        "con and breath                                                                  \n" +
        "in atrim                                                                        \n" +
        "28 yof con and breath*                                                          \n\n\n\n\n\n" +
        "  ",

        "ID:123630050",
        "TIME:13:42:14",
        "CALL:Ambulance/EMS Call (32)",
        "PLACE:JEFFERSON COUNTY COURT HOUSE",
        "ADDR:100 JEFFERSON COUNTY PKY",
        "MADDR:100 JEFFERSON COUNTY PKWY",
        "CITY:GOLDEN",
        "X:COURTHOUSE DR/ COURTHOUSE DR",
        "MAP:I4",
        "UNIT:AMR132",
        "INFO:female spider bite open and bleeding\ncon and breath\nin atrim\n28 yof con and breath*");

    doTest("T40",
        "(Golden Fire) Call#: 123630043*                                                               \n" +
        "Time: 12:39:03*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 600 9TH ST COORS, GOLDEN*                                             \n" +
        "Cross streets: JACKSON ST/ JACKSON ST*                                          \n" +
        "Map page: MAP D2  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: gen fire                                                             \n" +
        "fire water floor bldg 11 5th floor                                              \n" +
        "also ground flooor*                                                             \n\n\n\n\n\n" +
        "  ",

        "ID:123630043",
        "TIME:12:39:03",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:600 9TH ST",
        "APT:COORS",
        "CITY:GOLDEN",
        "X:JACKSON ST/ JACKSON ST",
        "MAP:D2",
        "UNIT:DIST1 DIST2",
        "INFO:gen fire\nfire water floor bldg 11 5th floor\nalso ground flooor*");

    doTest("T41",
        "(Golden Fire) Call#: 123630041*                                                               \n" +
        "Time: 12:06:37*                                                                 \n" +
        "Type of call: Mutual Aid*                                                       \n" +
        "Location: 14095 W 7TH AVE*                                                      \n" +
        "Cross streets:/*                                                                \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: one engine / command post same loc                                   \n" +
        "shed on fire*                                                                   \n\n\n\n\n\n" +
        "  ",

        "ID:123630041",
        "TIME:12:06:37",
        "CALL:Mutual Aid",
        "ADDR:14095 W 7TH AVE",
        "UNIT:DIST1 DIST2",
        "INFO:one engine / command post same loc\nshed on fire*");

    doTest("T42",
        "(Golden Fire) Call#: 123630035*                                                               \n" +
        "Time: 10:17:23*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 1917 PARFET ESTATES DR, GOLDEN*                                       \n" +
        "Cross streets: KOHINOOR PL/ KOHINOOR PL*                                        \n" +
        "Map page: MAP F2  *                                                             \n" +
        "Units: AMR131 RES2 DIST1 DIST2*                                                 \n" +
        "Narrative: fall vict / poss broken hip                                          \n" +
        "86 yof c/b                                                                      \n" +
        "Call emailed to:                                                                \n" +
        "2023c@iaralerts.com*                                                            \n\n\n\n\n\n" +
        "  ",

        "ID:123630035",
        "TIME:10:17:23",
        "CALL:Ambulance and Rescue",
        "ADDR:1917 PARFET ESTATES DR",
        "CITY:GOLDEN",
        "X:KOHINOOR PL/ KOHINOOR PL",
        "MAP:F2",
        "UNIT:AMR131 RES2 DIST1 DIST2",
        "INFO:fall vict / poss broken hip\n86 yof c/b\nCall emailed to:\n2023c@iaralerts.com*");

    doTest("T43",
        "(Golden Fire) Call#: 123630019*                                                               \n" +
        "Time: 04:30:35*                                                                 \n" +
        "Type of call: Ambulance call only (32)*                                         \n" +
        "Location: GOLDEN POLICE DEPARTMENT, 911 10TH ST GPD, GOLDEN*                    \n" +
        "Cross streets: ARAPAHOE ST/ CHEYENNE ST*                                        \n" +
        "Map page: MAP D2  *                                                             \n" +
        "Units: AMR131*                                                                  \n" +
        "Narrative: blood draw*                                                          \n\n\n\n\n\n" +
        "  ",

        "ID:123630019",
        "TIME:04:30:35",
        "CALL:Ambulance call only (32)",
        "PLACE:GOLDEN POLICE DEPARTMENT",
        "ADDR:911 10TH ST",
        "APT:GPD",
        "CITY:GOLDEN",
        "X:ARAPAHOE ST/ CHEYENNE ST",
        "MAP:D2",
        "UNIT:AMR131",
        "INFO:blood draw*");

    doTest("T44",
        "(Golden Fire) Call#: 123630010*                                                               \n" +
        "Time: 01:35:08*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 1300 GOLDEN CIR A205, GOLDEN*                                         \n" +
        "Cross streets: GOLDEN CIR/ GOLDEN CIR*                                          \n" +
        "Map page: MAP I4  *                                                             \n" +
        "Units: AMR132*                                                                  \n" +
        "Narrative: 83  yo/m                                                             \n" +
        "diff breathing                                                                  \n" +
        "req non emergent                                                                \n" +
        "Call emailed to:                                                                \n" +
        "2023@iaralerts.com                                                              \n" +
        "2023b@iaralerts.com*                                                            \n\n\n\n\n\n" +
        "  ",

        "ID:123630010",
        "TIME:01:35:08",
        "CALL:Ambulance and Rescue",
        "ADDR:1300 GOLDEN CIR",
        "APT:A205",
        "CITY:GOLDEN",
        "X:GOLDEN CIR/ GOLDEN CIR",
        "MAP:I4",
        "UNIT:AMR132",
        "INFO:83  yo/m\ndiff breathing\nreq non emergent\nCall emailed to:\n2023@iaralerts.com\n2023b@iaralerts.com*");

    doTest("T45",
        "(Golden Fire) Call#: 123620053*                                                               \n" +
        "Time: 20:25:29*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 1300 GOLDEN CIR, GOLDEN*                                              \n" +
        "Cross streets: GOLDEN CIR/ GOLDEN CIR*                                          \n" +
        "Map page: MAP I4  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: kids knocked into the fire pull station                              \n" +
        "at the south entrance on main floor                                             \n" +
        "the fire alarm is not going off but some other                                  \n" +
        "type of noise or alarm coming from it                                           \n" +
        "has been going off for the last 15 mins                                         \n" +
        "next to apt 212*                                                                \n\n\n\n\n\n" +
        "  ",

        "ID:123620053",
        "TIME:20:25:29",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:1300 GOLDEN CIR",
        "CITY:GOLDEN",
        "X:GOLDEN CIR/ GOLDEN CIR",
        "MAP:I4",
        "UNIT:DIST1 DIST2",
        "INFO:kids knocked into the fire pull station\nat the south entrance on main floor\nthe fire alarm is not going off but some other\ntype of noise or alarm coming from it\nhas been going off for the last 15 mins\nnext to apt 212*");

    doTest("T46",
        "(Golden Fire) Call#: 123620046*                                                               \n" +
        "Time: 17:07:15*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 1224 WASHINGTON AVE U105, GOLDEN*                                     \n" +
        "Cross streets: 12TH ST/ 13TH ST*                                                \n" +
        "Map page: MAP E3  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: unk unit number                                                      \n" +
        "indicator gen fire zone 12                                                      \n" +
        "rp 303 325 1978 pat foss                                                        \n" +
        "aired*                                                                          \n\n\n\n\n\n" +
        "  ",

        "ID:123620046",
        "TIME:17:07:15",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:1224 WASHINGTON AVE",
        "APT:U105",
        "CITY:GOLDEN",
        "X:12TH ST/ 13TH ST",
        "MAP:E3",
        "UNIT:DIST1 DIST2",
        "INFO:unk unit number\nindicator gen fire zone 12\nrp 303 325 1978 pat foss\naired*");

    doTest("T47",
        "(Golden Fire) Call#: 123620037*                                                               \n" +
        "Time: 14:11:06*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: 1549 COUGAR CT, GOLDEN*                                               \n" +
        "Cross streets: CANYON POINT CIR/ CANYON POINT CIR*                              \n" +
        "Map page: MAP C1  *                                                             \n" +
        "Units: AMR131*                                                                  \n" +
        "Narrative: AN FELL A FEW DAYS AGO AND NOW HAS BAD CRAMPING                      \n" +
        "78yo f / is c / is b*                                                           \n\n\n\n\n\n" +
        "  ",

        "ID:123620037",
        "TIME:14:11:06",
        "CALL:Ambulance/EMS Call (32)",
        "ADDR:1549 COUGAR CT",
        "CITY:GOLDEN",
        "X:CANYON POINT CIR/ CANYON POINT CIR",
        "MAP:C1",
        "UNIT:AMR131",
        "INFO:AN FELL A FEW DAYS AGO AND NOW HAS BAD CRAMPING\n78yo f / is c / is b*");

    doTest("T48",
        "(Golden Fire) Call#: 123620025*                                                               \n" +
        "Time: 09:53:16*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: 323 ORION ST, GOLDEN*                                                 \n" +
        "Cross streets: W 2ND PL/W 4TH AVE*                                              \n" +
        "Map page: MAP J6  *                                                             \n" +
        "Units: AMR132*                                                                  \n" +
        "Narrative: 65yo m he is sick throwing up and has diarhea                        \n" +
        "is c / is b*                                                                    \n\n\n\n\n\n" +
        "  ",

        "ID:123620025",
        "TIME:09:53:16",
        "CALL:Ambulance/EMS Call (32)",
        "ADDR:323 ORION ST",
        "CITY:GOLDEN",
        "X:W 2ND PL/W 4TH AVE",
        "MAP:J6",
        "UNIT:AMR132",
        "INFO:65yo m he is sick throwing up and has diarhea\nis c / is b*");

    doTest("T49",
        "(Golden Fire) Call#: 123620017*                                                               \n" +
        "Time: 08:18:17*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 1819 PARFET ESTATES DR, GOLDEN*                                       \n" +
        "Cross streets: 19TH ST/ YUCCA CT*                                               \n" +
        "Map page: MAP F2  *                                                             \n" +
        "Units: AMR131*                                                                  \n" +
        "Narrative: poss stroke                                                          \n" +
        "is 80 yo m                                                                      \n" +
        "is c/ is b/                                                                     \n" +
        "transfer to emd//                                                               \n" +
        "Call emailed to:                                                                \n" +
        "2023@iaralerts.com                                                              \n" +
        "2023b@iaralerts.com*                                                            \n\n\n\n\n\n" +
        "  ",

        "ID:123620017",
        "TIME:08:18:17",
        "CALL:Ambulance and Rescue",
        "ADDR:1819 PARFET ESTATES DR",
        "CITY:GOLDEN",
        "X:19TH ST/ YUCCA CT",
        "MAP:F2",
        "UNIT:AMR131",
        "INFO:poss stroke\nis 80 yo m\nis c/ is b/\ntransfer to emd//\nCall emailed to:\n2023@iaralerts.com\n2023b@iaralerts.com*");

    doTest("T50",
        "(Golden Fire) Call#: 123620014*                                                               \n" +
        "Time: 07:46:22*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 3050 ILLINOIS ST, GOLDEN*                                             \n" +
        "Cross streets: JEFFERSON COUNTY PKY/ JEFFERSON COUNTY PKY*                      \n" +
        "Map page: MAP H4  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: ind clubhouse water flow                                             \n" +
        "p 3032778750                                                                    \n" +
        "kh wasn't contacted yet*                                                        \n\n\n\n\n\n" +
        "  ",

        "ID:123620014",
        "TIME:07:46:22",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:3050 ILLINOIS ST",
        "CITY:GOLDEN",
        "X:JEFFERSON COUNTY PKY/ JEFFERSON COUNTY PKY",
        "MAP:H4",
        "UNIT:DIST1 DIST2",
        "INFO:ind clubhouse water flow\np 3032778750\nkh wasn't contacted yet*");

    doTest("T51",
        "(Golden Fire) Call#: 130090127*                                                               \n" +
        "Time: 15:38:50*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: SHELTON ELEMENTARY SCHOOL, 420 CRAWFORD ST SCHOOL, GOLDEN*            \n" +
        "Cross streets: CRAWFORD DR/ TRIPP DR*                                           \n" +
        "Map page: MAP J3  *                                                             \n" +
        "Units: MED22*                                                                   \n" +
        "Narrative: student outside / ankle run over by car                              \n" +
        "parent of child / accidental                                                    \n" +
        "right out front                                                                 \n" +
        "student is 6th grader /                                                         \n" +
        "rp not with subj                                                                \n" +
        "still relaying status thru principal*                                           \n",

        "ID:130090127",
        "TIME:15:38:50",
        "CALL:Ambulance/EMS Call (32)",
        "PLACE:SHELTON ELEMENTARY SCHOOL",
        "ADDR:420 CRAWFORD ST",
        "APT:SCHOOL",
        "CITY:GOLDEN",
        "X:CRAWFORD DR/ TRIPP DR",
        "MAP:J3",
        "UNIT:MED22",
        "INFO:student outside / ankle run over by car\nparent of child / accidental\nright out front\nstudent is 6th grader /\nrp not with subj\nstill relaying status thru principal*");

  }
  
  @Test
  public void testGoldenFD4() {

    doTest("T1",
        "(CAD call 130930009) Call#: 130930009*                                                               \n" +
        "Time: 04:37:08*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: 1150 GOLDEN CIR A205, GOLDEN*                                         \n" +
        "Cross streets: GOLDEN CIR/ GOLDEN CIR*                                          \n" +
        "Map page: MAP I4  *                                                             \n" +
        "Units: MED22*                                                                   \n" +
        "Narrative: stomach pain 2030                                                    \n" +
        "44 yom  c/b                                                                     \n" +
        "abovce nbavel*                                                                  \n\n\n\n\n\n" +
        "This email and the attached documents (if any) are intended only for the use of\n" +
        "the individual or entity to which they are addressed and may contain information\n" +
        "that is privileged, confidential and exempt from disclosure under applicable\n" +
        "law.  If the reader of this message and the accompanying documents is not the\n" +
        "intended recipient or the employee or agent responsible for delivering the\n" +
        "message to the intended recipient, you are hereby notified that any\n" +
        "dissemination, distribution or copying of this communication is strictly\n" +
        "prohibited.  If you have received this communication in error, please notify us\n" +
        "immediately by telephone and fully delete the original message and any\n" +
        "accompanying documents.  Thank you.",

        "ID:130930009",
        "TIME:04:37:08",
        "CALL:Ambulance/EMS Call (32)",
        "ADDR:1150 GOLDEN CIR",
        "APT:A205",
        "CITY:GOLDEN",
        "X:GOLDEN CIR/ GOLDEN CIR",
        "MAP:I4",
        "UNIT:MED22",
        "INFO:stomach pain 2030\n44 yom  c/b\nabovce nbavel");

    doTest("T2",
        "(CAD call 130920116) Call#: 130920116*                                                               \n" +
        "Time: 20:34:57*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: 17150 W COLFAX AVE, GOLDEN*                                           \n" +
        "Cross streets: HWY 6/ CORPORATE DR*                                             \n" +
        "Map page: MAP J5  *                                                             \n" +
        "Units: MED22*                                                                   \n" +
        "Narrative: m1 eval / routine*                                                   \n\n\n\n\n\n" +
        "This email and the attached documents (if any) are intended only for the use of\n" +
        "the individual or entity to which they are addressed and may contain information\n" +
        "that is privileged, confidential and exempt from disclosure under applicable\n" +
        "law.  If the reader of this message and the accompanying documents is not the\n" +
        "intended recipient or the employee or agent responsible for delivering the\n" +
        "message to the intended recipient, you are hereby notified that any\n" +
        "dissemination, distribution or copying of this communication is strictly\n" +
        "prohibited.  If you have received this communication in error, please notify us\n" +
        "immediately by telephone and fully delete the original message and any\n" +
        "accompanying documents.  Thank you.",

        "ID:130920116",
        "TIME:20:34:57",
        "CALL:Ambulance/EMS Call (32)",
        "ADDR:17150 W COLFAX AVE",
        "CITY:GOLDEN",
        "X:HWY 6/ CORPORATE DR",
        "MAP:J5",
        "UNIT:MED22",
        "INFO:m1 eval / routine");

    doTest("T3",
        "(CAD call 130920102) Call#: 130920102*                                                               \n" +
        "Time: 17:27:35*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 165 A ST, GOLDEN*                                                     \n" +
        "Cross streets: ZETA ST/ ZURICH ST*                                              \n" +
        "Map page: MAP J4  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: difficulty breathing / copd / asthma                                 \n" +
        "83yo f is c*                                                                    \n\n\n\n\n\n" +
        "This email and the attached documents (if any) are intended only for the use of\n" +
        "the individual or entity to which they are addressed and may contain information\n" +
        "that is privileged, confidential and exempt from disclosure under applicable\n" +
        "law.  If the reader of this message and the accompanying documents is not the\n" +
        "intended recipient or the employee or agent responsible for delivering the\n" +
        "message to the intended recipient, you are hereby notified that any\n" +
        "dissemination, distribution or copying of this communication is strictly\n" +
        "prohibited.  If you have received this communication in error, please notify us\n" +
        "immediately by telephone and fully delete the original message and any\n" +
        "accompanying documents.  Thank you.",

        "ID:130920102",
        "TIME:17:27:35",
        "CALL:Ambulance and Rescue",
        "ADDR:165 A ST",
        "CITY:GOLDEN",
        "X:ZETA ST/ ZURICH ST",
        "MAP:J4",
        "UNIT:DIST1 DIST2",
        "INFO:difficulty breathing / copd / asthma\n83yo f is c");

    doTest("T4",
        "(CAD call 130920093) Call#: 130920093*                                                               \n" +
        "Time: 14:36:20*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: 1223 W CAMPUS RD A304, GOLDEN*                                        \n" +
        "Cross streets: MAPLE ST/ ELM ST*                                                \n" +
        "Map page: MAP E2  *                                                             \n" +
        "Units: MED21*                                                                   \n" +
        "Narrative: room 304                                                             \n" +
        "19 feeling numb                                                                 \n" +
        "cant move wrist                                                                 \n" +
        "con and breathing*                                                              \n\n\n\n\n\n" +
        "This email and the attached documents (if any) are intended only for the use of\n" +
        "the individual or entity to which they are addressed and may contain information\n" +
        "that is privileged, confidential and exempt from disclosure under applicable\n" +
        "law.  If the reader of this message and the accompanying documents is not the\n" +
        "intended recipient or the employee or agent responsible for delivering the\n" +
        "message to the intended recipient, you are hereby notified that any\n" +
        "dissemination, distribution or copying of this communication is strictly\n" +
        "prohibited.  If you have received this communication in error, please notify us\n" +
        "immediately by telephone and fully delete the original message and any\n" +
        "accompanying documents.  Thank you.",

        "ID:130920093",
        "TIME:14:36:20",
        "CALL:Ambulance/EMS Call (32)",
        "ADDR:1223 W CAMPUS RD",
        "APT:A304",
        "CITY:GOLDEN",
        "X:MAPLE ST/ ELM ST",
        "MAP:E2",
        "UNIT:MED21",
        "INFO:room 304\n19 feeling numb\ncant move wrist\ncon and breathing");

    doTest("T5",
        "(CAD call 130920082) Call#: 130920082*                                                               \n" +
        "Time: 14:06:13*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: 1375 CATAMOUNT DR, GOLDEN*                                            \n" +
        "Cross streets: PINE RIDGE RD/ GOLDEN GATE CANYON RD*                            \n" +
        "Map page: MAP A1  *                                                             \n" +
        "Units: MED21*                                                                   \n" +
        "Narrative: according to nurse at st joes needs to go there                      \n" +
        "now con and breath                                                              \n" +
        "on blood pressure meds                                                          \n" +
        "mid 80s female                                                                  \n" +
        "con and breath*                                                                 \n\n\n\n\n\n" +
        "This email and the attached documents (if any) are intended only for the use of\n" +
        "the individual or entity to which they are addressed and may contain information\n" +
        "that is privileged, confidential and exempt from disclosure under applicable\n" +
        "law.  If the reader of this message and the accompanying documents is not the\n" +
        "intended recipient or the employee or agent responsible for delivering the\n" +
        "message to the intended recipient, you are hereby notified that any\n" +
        "dissemination, distribution or copying of this communication is strictly\n" +
        "prohibited.  If you have received this communication in error, please notify us\n" +
        "immediately by telephone and fully delete the original message and any\n" +
        "accompanying documents.  Thank you.",

        "ID:130920082",
        "TIME:14:06:13",
        "CALL:Ambulance/EMS Call (32)",
        "ADDR:1375 CATAMOUNT DR",
        "CITY:GOLDEN",
        "X:PINE RIDGE RD/ GOLDEN GATE CANYON RD",
        "MAP:A1",
        "UNIT:MED21",
        "INFO:according to nurse at st joes needs to go there\nnow con and breath\non blood pressure meds\nmid 80s female\ncon and breath");

    doTest("T6",
        "(CAD call 130920077) Call#: 130920077*                                                               \n" +
        "Time: 13:56:43*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: 814 RABBIT RUN DR, GOLDEN*                                            \n" +
        "Cross streets: EAGLE RIDGE DR/ EAGLE RIDGE DR*                                  \n" +
        "Map page: MAP H3  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: zone 6*                                                              \n\n\n\n\n\n" +
        "This email and the attached documents (if any) are intended only for the use of\n" +
        "the individual or entity to which they are addressed and may contain information\n" +
        "that is privileged, confidential and exempt from disclosure under applicable\n" +
        "law.  If the reader of this message and the accompanying documents is not the\n" +
        "intended recipient or the employee or agent responsible for delivering the\n" +
        "message to the intended recipient, you are hereby notified that any\n" +
        "dissemination, distribution or copying of this communication is strictly\n" +
        "prohibited.  If you have received this communication in error, please notify us\n" +
        "immediately by telephone and fully delete the original message and any\n" +
        "accompanying documents.  Thank you.",

        "ID:130920077",
        "TIME:13:56:43",
        "CALL:Fire Alarm Activation (73)",
        "ADDR:814 RABBIT RUN DR",
        "CITY:GOLDEN",
        "X:EAGLE RIDGE DR/ EAGLE RIDGE DR",
        "MAP:H3",
        "UNIT:DIST1 DIST2",
        "INFO:zone 6");

    doTest("T7",
        "(CAD call 130920025) Call#: 130920025*                                                               \n" +
        "Time: 08:15:05*                                                                 \n" +
        "Type of call: Fire Alarm Activation (73)*                                       \n" +
        "Location: WATER TREATMENT PLANT, 1409 10TH ST, GOLDEN*                          \n" +
        "Cross streets: MAPLE ST/ MAPLE ST*                                              \n" +
        "Map page: MAP E2  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: smoke detector in kitchen burnt food*                                \n\n\n\n\n\n" +
        "This email and the attached documents (if any) are intended only for the use of\n" +
        "the individual or entity to which they are addressed and may contain information\n" +
        "that is privileged, confidential and exempt from disclosure under applicable\n" +
        "law.  If the reader of this message and the accompanying documents is not the\n" +
        "intended recipient or the employee or agent responsible for delivering the\n" +
        "message to the intended recipient, you are hereby notified that any\n" +
        "dissemination, distribution or copying of this communication is strictly\n" +
        "prohibited.  If you have received this communication in error, please notify us\n" +
        "immediately by telephone and fully delete the original message and any\n" +
        "accompanying documents.  Thank you.",

        "ID:130920025",
        "TIME:08:15:05",
        "CALL:Fire Alarm Activation (73)",
        "PLACE:WATER TREATMENT PLANT",
        "ADDR:1409 10TH ST",
        "CITY:GOLDEN",
        "X:MAPLE ST/ MAPLE ST",
        "MAP:E2",
        "UNIT:DIST1 DIST2",
        "INFO:smoke detector in kitchen burnt food");

    doTest("T8",
        "(CAD call 130910055) Call#: 130910055*                                                               \n" +
        "Time: 16:10:40*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: 18236 W 4TH AVE, GOLDEN*                                              \n" +
        "Cross streets: ZETA ST/ GOLDEN CIR*                                             \n" +
        "Map page: MAP J4  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: copd / emphazema / 66 yom c/ diff breath*                            \n\n\n\n\n\n" +
        "This email and the attached documents (if any) are intended only for the use of\n" +
        "the individual or entity to which they are addressed and may contain information\n" +
        "that is privileged, confidential and exempt from disclosure under applicable\n" +
        "law.  If the reader of this message and the accompanying documents is not the\n" +
        "intended recipient or the employee or agent responsible for delivering the\n" +
        "message to the intended recipient, you are hereby notified that any\n" +
        "dissemination, distribution or copying of this communication is strictly\n" +
        "prohibited.  If you have received this communication in error, please notify us\n" +
        "immediately by telephone and fully delete the original message and any\n" +
        "accompanying documents.  Thank you.",

        "ID:130910055",
        "TIME:16:10:40",
        "CALL:Ambulance and Rescue",
        "ADDR:18236 W 4TH AVE",
        "CITY:GOLDEN",
        "X:ZETA ST/ GOLDEN CIR",
        "MAP:J4",
        "UNIT:DIST1 DIST2",
        "INFO:copd / emphazema / 66 yom c/ diff breath");

    doTest("T9",
        "(CAD call 130910050) Call#: 130910050*                                                               \n" +
        "Time: 14:54:22*                                                                 \n" +
        "Type of call: Ambulance/EMS Call (32)*                                          \n" +
        "Location: 1270 N FORD ST A100, GOLDEN*                                          \n" +
        "Cross streets: PINE RIDGE RD/ VIRGINIA ST*                                      \n" +
        "Map page: MAP A2  *                                                             \n" +
        "Units: MED21*                                                                   \n" +
        "Narrative: 96 yof c/b fell from wheel chair                                     \n" +
        "poss right hip injury*                                                          \n\n\n\n\n\n" +
        "This email and the attached documents (if any) are intended only for the use of\n" +
        "the individual or entity to which they are addressed and may contain information\n" +
        "that is privileged, confidential and exempt from disclosure under applicable\n" +
        "law.  If the reader of this message and the accompanying documents is not the\n" +
        "intended recipient or the employee or agent responsible for delivering the\n" +
        "message to the intended recipient, you are hereby notified that any\n" +
        "dissemination, distribution or copying of this communication is strictly\n" +
        "prohibited.  If you have received this communication in error, please notify us\n" +
        "immediately by telephone and fully delete the original message and any\n" +
        "accompanying documents.  Thank you.",

        "ID:130910050",
        "TIME:14:54:22",
        "CALL:Ambulance/EMS Call (32)",
        "ADDR:1270 N FORD ST",
        "APT:A100",
        "CITY:GOLDEN",
        "X:PINE RIDGE RD/ VIRGINIA ST",
        "MAP:A2",
        "UNIT:MED21",
        "INFO:96 yof c/b fell from wheel chair\nposs right hip injury");

    doTest("T10",
        "(CAD call 130910032) Call#: 130910032*                                                               \n" +
        "Time: 10:56:46*                                                                 \n" +
        "Type of call: Ambulance and Rescue*                                             \n" +
        "Location: JEFFERSON COUNTY COURT HOUSE, 100 JEFFERSON COUNTY PKY, GOLDEN*       \n" +
        "Cross streets: COURTHOUSE DR/ COURTHOUSE DR*                                    \n" +
        "Map page: MAP I4  *                                                             \n" +
        "Units: DIST1 DIST2*                                                             \n" +
        "Narrative: 38yom is c is b chest pains                                          \n" +
        "will meet in the security*                                                      \n\n\n\n\n\n" +
        "This email and the attached documents (if any) are intended only for the use of\n" +
        "the individual or entity to which they are addressed and may contain information\n" +
        "that is privileged, confidential and exempt from disclosure under applicable\n" +
        "law.  If the reader of this message and the accompanying documents is not the\n" +
        "intended recipient or the employee or agent responsible for delivering the\n" +
        "message to the intended recipient, you are hereby notified that any\n" +
        "dissemination, distribution or copying of this communication is strictly\n" +
        "prohibited.  If you have received this communication in error, please notify us\n" +
        "immediately by telephone and fully delete the original message and any\n" +
        "accompanying documents.  Thank you.",

        "ID:130910032",
        "TIME:10:56:46",
        "CALL:Ambulance and Rescue",
        "PLACE:JEFFERSON COUNTY COURT HOUSE",
        "ADDR:100 JEFFERSON COUNTY PKY",
        "MADDR:100 JEFFERSON COUNTY PKWY",
        "CITY:GOLDEN",
        "X:COURTHOUSE DR/ COURTHOUSE DR",
        "MAP:I4",
        "UNIT:DIST1 DIST2",
        "INFO:38yom is c is b chest pains\nwill meet in the security");
    
  }
  
  public static void main(String[] args) {
    new COGoldenParserTest().generateTests("T1");
  }
}