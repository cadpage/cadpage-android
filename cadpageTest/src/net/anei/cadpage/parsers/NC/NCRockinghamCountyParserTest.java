package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Rockingham County, NC
Contact: "alex.french3068" <alex.french3068@gmail.com>
Sender: 3365208378
Sender: cad@co.rockingham.nc.us

CAD:STROKE;316 MATTIE RD;US 29 BUS;REID;160;TAC3 [10/14/12 18:04:44 JBOWLES] [Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: *
CAD:CHESTPAI;1891 HARRISON CROSSROAD LP;BURTON FARM RD;NC 14;REID;10C04;160;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: Y
CAD:FIREALRM;244 MT HERMAN CHURCH RD;MAYFIELD RD;RUFF;20;TAC 2 [10/15/12 20:32:10 JGREER] location: smoke detector [10/15/12 20:31:49 MJOYCE]
CAD:STRUC;480 LICK FORK CREEK RD;LICK FORK LN;LONGBRANCH RD;REID;20;rekindle at barn fire [10/13/12 08:31:41 CEADS]

Contact: d_white79 <d_white79@yahoo.com>
Sender: CAD@co.rockingham.nc.us
2034:CAD:STRUCTURE FIRE;531 BERRY HILL BRIDGE RD;STEWART RD;PRUITT DR;RUFF;20

Contact: Active911
Agency name: Shiloh Volunteer Fire Department
Location: Stoneville, NC, United States

CAD:BREATHIN;194 DEERWOOD LN;DEERTRACT LP;DEERTRACT LP;STON;120\r\n\r\n
CAD:SMOKEINV;1731 PRICE GRANGE RD;SNEAD RD;SEXTON CIR;STON;120\r\n\r\n
CAD:CARBON;226 BEECH BEND LN;NC 135;STON;120\r\n\r\n
CAD:INDUSTRA;352 VALLEY FIELD RD;NC 135;STON;22B02A;120\r\n\r\n
CAD:SICKPERS;322 YOUNG RD;NC 135;NC 770;STON;120\r\n\r\n
CAD:FALLS;2008 SNEAD RD;OAKLEY RD;BRIGGS DR;STON;17D03;120\r\n\r\n
CAD:UNCONSCI;1469 GROGAN RD;STONE MOUNTAIN RD;RIVER RD;STON;31D02;120\r\n\r\n
CAD:UNDER CONTROL;2008 SNEAD RD; STON\r\n\r\n
CAD:FALLS;2008 SNEAD RD;OAKLEY RD;BRIGGS DR;STON;120;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 78-year-old female, who is conscious an\r\n\r\n
CAD:FIREALRM;170 SHAKEY RD;REMINGTON DR;STON;FRONTIER SPINNING;60;location is sprinkler water flow alarm [11/04/12 03:44:43 DMOORE]\r\n\r\n
CAD:UNCONSCI;101 LYNNE LN;STERLING DR;STON;31D03;120;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 56-year-old female, wh\r\n\r\n
CAD:UNKNOWN;176 ORIOLE DR;COMER RD;STON;120;[EMS] CALLER WILL BE IN A PONTICA MINIVAN . CHAMPAGNE [11/02/12 13:46:48 GAVINZ] [EMS] AMANDA EVANS, 336-613-8204 --- IS ENROUTE FEW MIN ETA, HAS A KEY TO THE RES ... FRIEND CALLED TOLD HER SHE WA\r\n\r\n
CAD:MVA;NC 135/MOUNTAIN RIDGE TR;STON;120;Radio Channel: TACT2 [11/01/12 02:02:32 GKASEY] [Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to multiple patients involved in a traffic incident.\r\n\r\n
CAD:EYEPROBL;114 REBEL RUN LP;STONE MOUNTAIN RD;STONE MOUNTAIN RD;STON;120;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient with an eye injury. The patient is a 22-year-old femal\r\n\r\n
CAD:UNCONSCI;2810 SETTLE BRIDGE RD;DOGWOOD RD;NC 135;STON;120;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 66-year-old f\r\n\r\n
CAD:MVA;SETTLE BRIDGE RD/NC 135;STON;120;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient injured in a traffic incident. The patient is a 35-year-old male, who is conscious and\r\n\r\n
CAD:BREATHIN;149 STERLING DR;BOB TR;STON;120;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 23-year-old male, who is conscious and bre\r\n\r\n
CAD:CHESTPAI;445 YOUNG RD;NC 135;NC 770;STON;120;[EMS] TACT 4444444444 [10/27/12 09:03:20 SGARRISON] [Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient\r\n\r\n
CAD:All Units Stage;122 TOP RUN DR; STON\r\n\r\n

Contact: Active911
Agency name: Eden Rescue Squad
Location: Eden, NC, United States

CAD:STBYRES;858 MT CARMEL CHURCH RD;CRUTCHFIELD RD;TOBACCO DR;REID;OREGON HILL FIRE DEPARTMENT;BAS3\r\n\r\n
CAD:BREATHIN;216 N OAKLAND AVE;UNION ST;DUNN ST;EDEN;CHADWICK APARTMENTS;06D02A;BAS1\r\n\r\n
CAD:CHESTPAI;BOONE RD/EARLY AVE;EDEN;10C01;BAS1\r\n\r\n
CAD:CHESTPAI;1235 NORMAN DR;PRICE ST;ROBERTS ST;EDEN;PARKLAND APARTMENTS;10C04;BAS1\r\n\r\n
CAD:TRAUMA;900 CHURCH ST;S HAMILTON ST;N OAKLAND AVE;EDEN;30A01;BAS1\r\n\r\n
CAD:ONEUNIT;150 NC 65;JUSTICE CENTER DR;COUNTY HOME RD;REID;EMERGENCY SERVICES;BAS3\r\n\r\n
CAD:FALLS;1607 E MEADOW RD;MAIN ST;PHILLIP ST;EDEN;BAS1\r\n\r\n
CAD:DIABETIC;133 NANCE ST;NC 87;AZALEA RD;EDEN;13C01;BAS1\r\n\r\n
CAD:ONEUNIT;150 NC 65;JUSTICE CENTER DR;COUNTY HOME RD;REID;EMERGENCY SERVICES;BAS3\r\n\r\n
CAD:UNDER CONTROL;6970 NC 135; MAY ;RM 27\r\n\r\n
CAD:MVA;ELLETT AVE/N OAKLAND AVE;EDEN;BAS1\r\n\r\n
CAD:CPRDEATH;6970 NC 135;DAN VALLEY RD;RIVER RD;MAY;NORTH POINTE OF MAYODAN;09D01;BAS2\r\n\r\n
CAD:HEART;1224 RIDGE AVE;N HALE ST;N HUNDLEY DR;EDEN;19D02;BAS1\r\n\r\n
CAD:SEIZURES;730 MORGAN RD;OAK ST;HOLLAND ST;EDEN;12D02E;BAS1\r\n\r\n
CAD:CONVO;117 E KINGS HWY;S VAN BUREN RD;LINDEN DR;EDEN;MOREHEAD MEMORIAL HOSPITAL;BAS1\r\n\r\n
CAD:UNDER CONTROL;803 S VAN BUREN RD; EDEN\r\n\r\n
CAD:MVA;803 S VAN BUREN RD;W HARRIS PL;KNIGHT ST;EDEN;LITTLE CEASARS;29B01;BAS1\r\n\r\n
CAD:STROKE;205 E KINGS HWY;S VAN BUREN RD;LINDEN DR;EDEN;MOREHEAD NURSING CENTER;28C09L;BAS1\r\n\r\n
CAD:BREATHIN;618 S PIERCE ST;PIERCE ST;E ARBOR LN;EDEN;WOUND CENTER;06C01;BAS1\r\n\r\n
CAD:HEMORRHA;705 IRVING AVE;MOIR ST;BRIDGE ST;EDEN;21D03;BAS1\r\n\r\n

Agency name: Huntsville Volunteer Fire Department
Location: Madison, NC, United States
Contact: Active911
Sender: CAD@co.rockingham.nc.us

CAD:BREATHIN;1012 GIDEON GROVE CHURCH RD;WINDING CREEK RD;WOODGROVE WAY;STOK;150\r\n\r\n
CAD:MVA;631 SARDIS CHURCH RD;PILOTVIEW LP;PILOTVIEW LP;MAD;150\r\n\r\n
CAD:MVA;GRIFFIN RD/GOLD HILL RD;MAD;150\r\n\r\n
CAD:PATIENT FREE;1783 ANGELL RD; MAD\r\n\r\n
CAD:UNDER CONTROL;100 SERVICE RD; PELH\r\n\r\n
CAD:STRUC;100 SERVICE RD;MAYFIELD RD;STACEY RD;PELH;20;[LAW] C13 ADV OF CALL [11/05/12 13:36:17 SGARRISON] [EMS] caller advises that this is nearer to stacey rd [11/05/12 13:33:24 LREYES] half mile to a mile north of the ramp in the south b\r\n\r\n
CAD:TRAUMA;1783 ANGELL RD;SANDROCK RIDGE LN;GOLD HILL RD;MAD;150\r\n\r\n
CAD:MVA;3099 US 220;HARNED FARM RD;RICKYS TR;MAD;150;2 MILES SOUTH OF THE MADISON EXIT IN THE NORTH BOUND LN [11/05/12 07:02:34 CBODEY] Aborted by Medical Priority with code: ON THE LINE [11/05/12 07:00:32 CBODEY] SILVER IN CALLER [11/05/12\r\n\r\n
CAD:FALLS;521 MINERAL SPRINGS RD;NELL RD;M & M LN;MAD;150;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 59-year-old female, who is conscio\r\n\r\n
CAD:HEART;241 STANLEY RD;ELLISBORO RD;HONEY RD;STOK;150;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient with heart problems. The patient is a 68-year-old female, who is consciou\r\n\r\n
CAD:MVA;LINDSEY BRIDGE RD/EDEN CHURCH RD;MAD;150;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to patients involved in a traffic incident. (If known -- relay pertinent patient-specific inf\r\n\r\n
CAD:BRUSH;1100-BLK PIPE PLANT RD;stokes county is requesting station 150 to stand by at stokes 37 [11/01/12 15:23:20 JBOWLES] tanker and brush truck.....off us 311..req station 50 to respond... [11/01/12 15:13:06 JBOWLES]\r\n\r\n
CAD:UNDER CONTROL;100 JW RD; MAD\r\n\r\n
CAD:BRUSH;100 JW RD;LINDSEY BRIDGE RD;MAD;150;brush fire in the woods.... 10 to 15 feet from a building..and 25 yards from a house... [11/01/12 14:40:33 JBOWLES]\r\n\r\n
CAD:FIREALRM;1102 LINDSEY BRIDGE RD;RIERSON RD;JW RD;MAD;150;GENERAL FIRE ALARM ATTEMPTING NEXT... [10/29/12 18:23:19 CBODEY]\r\n\r\n
CAD:UNDER CONTROL;230 FRIENDS FARM WAY; STOK\r\n\r\n
CAD:MVA;230 FRIENDS FARM WAY;STOK;150;Radio Channel: 666666 [10/28/12 16:23:36 RKIVETT] [Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient injured in a traffic incident. The p\r\n\r\n
CAD:CHESTPAI;480 MARTIN FARM RD;REJOYCE LN;MAD;150;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 82-year-old female, who is conscious and bre\r\n\r\n
CAD:UNDER CONTROL;1139 SARDIS CHURCH RD; MAD\r\n\r\n
CAD:CPRDEATH;1139 SARDIS CHURCH RD;ELLISBORO RD;DALTON LAKE RD;MAD;LZ 150 HUNTSVILLE BALL PARK;150;[EMS] PULSE IS 122 AND WEAK [10/26/12 20:54:36 JBOWLES] [Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You ar\r\n\r\n

*/

public class NCRockinghamCountyParserTest extends BaseParserTest {
  
  public NCRockinghamCountyParserTest() {
    setParser(new NCRockinghamCountyParser(), "ROCKINGHAM COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:STROKE;316 MATTIE RD;US 29 BUS;REID;160;TAC3 [10/14/12 18:04:44 JBOWLES] [Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: *",
        "CALL:STROKE",
        "ADDR:316 MATTIE RD",
        "X:US 29 BUS",
        "CITY:REIDSVILLE",
        "UNIT:160",
        "CH:TAC3",
        "INFO:*",
        "DATE:10/14/12",
        "TIME:18:04:44");

    doTest("T2",
        "CAD:CHESTPAI;1891 HARRISON CROSSROAD LP;BURTON FARM RD;NC 14;REID;10C04;160;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: Y",
        "CALL:CHESTPAI",
        "ADDR:1891 HARRISON CROSSROAD LP",
        "X:BURTON FARM RD & NC 14",
        "CITY:REIDSVILLE",
        "CODE:10C04",
        "UNIT:160",
        "INFO:Y");

    doTest("T3",
        "CAD:FIREALRM;244 MT HERMAN CHURCH RD;MAYFIELD RD;RUFF;20;TAC 2 [10/15/12 20:32:10 JGREER] location: smoke detector [10/15/12 20:31:49 MJOYCE]",
        "CALL:FIREALRM",
        "ADDR:244 MT HERMAN CHURCH RD",
        "X:MAYFIELD RD",
        "CITY:RUFFIN",
        "UNIT:20",
        "CH:TAC 2",
        "INFO:location: smoke detector",
        "DATE:10/15/12",
        "TIME:20:32:10");

    doTest("T4",
        "CAD:CHESTPAI;1891 HARRISON CROSSROAD LP;BURTON FARM RD;NC 14;REID;10C04;160;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: Y",
        "CALL:CHESTPAI",
        "ADDR:1891 HARRISON CROSSROAD LP",
        "X:BURTON FARM RD & NC 14",
        "CITY:REIDSVILLE",
        "CODE:10C04",
        "UNIT:160",
        "INFO:Y");

    doTest("T5",
        "CAD:STROKE;316 MATTIE RD;US 29 BUS;REID;160;TAC3 [10/14/12 18:04:44 JBOWLES] [Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT:",
        "CALL:STROKE",
        "ADDR:316 MATTIE RD",
        "X:US 29 BUS",
        "CITY:REIDSVILLE",
        "UNIT:160",
        "CH:TAC3",
        "DATE:10/14/12",
        "TIME:18:04:44");

    doTest("T6",
        "CAD:STRUC;480 LICK FORK CREEK RD;LICK FORK LN;LONGBRANCH RD;REID;20;rekindle at barn fire [10/13/12 08:31:41 CEADS]",
        "CALL:STRUC",
        "ADDR:480 LICK FORK CREEK RD",
        "X:LICK FORK LN & LONGBRANCH RD",
        "CITY:REIDSVILLE",
        "UNIT:20",
        "INFO:rekindle at barn fire",
        "DATE:10/13/12",
        "TIME:08:31:41");

  }
  
  @Test
  public void testDWhite() {

    doTest("T1",
        "2034:CAD:STRUCTURE FIRE;531 BERRY HILL BRIDGE RD;STEWART RD;PRUITT DR;RUFF;20",
        "ID:2034",
        "CALL:STRUCTURE FIRE",
        "ADDR:531 BERRY HILL BRIDGE RD",
        "X:STEWART RD & PRUITT DR",
        "CITY:RUFFIN",
        "UNIT:20");
    
  }
  
  @Test
  public void testShilohFire() {

    doTest("T1",
        "CAD:BREATHIN;194 DEERWOOD LN;DEERTRACT LP;DEERTRACT LP;STON;120\r\n\r\n",
        "CALL:BREATHIN",
        "ADDR:194 DEERWOOD LN",
        "X:DEERTRACT LP & DEERTRACT LP",
        "CITY:STONEVILLE",
        "UNIT:120");

    doTest("T2",
        "CAD:SMOKEINV;1731 PRICE GRANGE RD;SNEAD RD;SEXTON CIR;STON;120\r\n\r\n",
        "CALL:SMOKEINV",
        "ADDR:1731 PRICE GRANGE RD",
        "X:SNEAD RD & SEXTON CIR",
        "CITY:STONEVILLE",
        "UNIT:120");

    doTest("T3",
        "CAD:CARBON;226 BEECH BEND LN;NC 135;STON;120\r\n\r\n",
        "CALL:CARBON",
        "ADDR:226 BEECH BEND LN",
        "X:NC 135",
        "CITY:STONEVILLE",
        "UNIT:120");

    doTest("T4",
        "CAD:INDUSTRA;352 VALLEY FIELD RD;NC 135;STON;22B02A;120\r\n\r\n",
        "CALL:INDUSTRA",
        "ADDR:352 VALLEY FIELD RD",
        "X:NC 135",
        "CITY:STONEVILLE",
        "CODE:22B02A",
        "UNIT:120");

    doTest("T5",
        "CAD:SICKPERS;322 YOUNG RD;NC 135;NC 770;STON;120\r\n\r\n",
        "CALL:SICKPERS",
        "ADDR:322 YOUNG RD",
        "X:NC 135 & NC 770",
        "CITY:STONEVILLE",
        "UNIT:120");

    doTest("T6",
        "CAD:FALLS;2008 SNEAD RD;OAKLEY RD;BRIGGS DR;STON;17D03;120\r\n\r\n",
        "CALL:FALLS",
        "ADDR:2008 SNEAD RD",
        "X:OAKLEY RD & BRIGGS DR",
        "CITY:STONEVILLE",
        "CODE:17D03",
        "UNIT:120");

    doTest("T7",
        "CAD:UNCONSCI;1469 GROGAN RD;STONE MOUNTAIN RD;RIVER RD;STON;31D02;120\r\n\r\n",
        "CALL:UNCONSCI",
        "ADDR:1469 GROGAN RD",
        "X:STONE MOUNTAIN RD & RIVER RD",
        "CITY:STONEVILLE",
        "CODE:31D02",
        "UNIT:120");

    doTest("T8",
        "CAD:UNDER CONTROL;2008 SNEAD RD; STON\r\n\r\n",
        "CALL:UNDER CONTROL",
        "ADDR:2008 SNEAD RD",
        "CITY:STONEVILLE");

    doTest("T9",
        "CAD:FALLS;2008 SNEAD RD;OAKLEY RD;BRIGGS DR;STON;120;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 78-year-old female, who is conscious an\r\n" +
        "\r\n",

        "CALL:FALLS",
        "ADDR:2008 SNEAD RD",
        "X:OAKLEY RD & BRIGGS DR",
        "CITY:STONEVILLE",
        "UNIT:120",
        "INFO:You are responding to a patient involved in a fall. The patient is a 78-year-old female, who is conscious an");

    doTest("T10",
        "CAD:FIREALRM;170 SHAKEY RD;REMINGTON DR;STON;FRONTIER SPINNING;60;location is sprinkler water flow alarm [11/04/12 03:44:43 DMOORE]\r\n" +
        "\r\n",

        "CALL:FIREALRM",
        "ADDR:170 SHAKEY RD",
        "X:REMINGTON DR",
        "CITY:STONEVILLE",
        "PLACE:FRONTIER SPINNING",
        "UNIT:60",
        "INFO:location is sprinkler water flow alarm",
        "DATE:11/04/12",
        "TIME:03:44:43");

    doTest("T11",
        "CAD:UNCONSCI;101 LYNNE LN;STERLING DR;STON;31D03;120;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 56-year-old female, wh\r\n" +
        "\r\n",

        "CALL:UNCONSCI",
        "ADDR:101 LYNNE LN",
        "X:STERLING DR",
        "CITY:STONEVILLE",
        "CODE:31D03",
        "UNIT:120",
        "INFO:You are responding to a patient who is unconscious (or has fainted). The patient is a 56-year-old female, wh");

    doTest("T12",
        "CAD:UNKNOWN;176 ORIOLE DR;COMER RD;STON;120;[EMS] CALLER WILL BE IN A PONTICA MINIVAN . CHAMPAGNE [11/02/12 13:46:48 GAVINZ] [EMS] AMANDA EVANS, 336-613-8204 --- IS ENROUTE FEW MIN ETA, HAS A KEY TO THE RES ... FRIEND CALLED TOLD HER SHE WA\r\n" +
        "\r\n",

        "CALL:UNKNOWN",
        "ADDR:176 ORIOLE DR",
        "X:COMER RD",
        "CITY:STONEVILLE",
        "UNIT:120",
        "INFO:CALLER WILL BE IN A PONTICA MINIVAN . CHAMPAGNE / AMANDA EVANS, 336-613-8204 --- IS ENROUTE FEW MIN ETA, HAS A KEY TO THE RES ... FRIEND CALLED TOLD HER SHE WA",
        "DATE:11/02/12",
        "TIME:13:46:48");

    doTest("T13",
        "CAD:MVA;NC 135/MOUNTAIN RIDGE TR;STON;120;Radio Channel: TACT2 [11/01/12 02:02:32 GKASEY] [Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to multiple patients involved in a traffic incident.\r\n" +
        "\r\n",

        "CALL:MVA",
        "ADDR:NC 135 & MOUNTAIN RIDGE TR",
        "MADDR:STATE 135 & MOUNTAIN RIDGE TR",
        "CITY:STONEVILLE",
        "UNIT:120",
        "CH:TACT2",
        "INFO:You are responding to multiple patients involved in a traffic incident.",
        "DATE:11/01/12",
        "TIME:02:02:32");

    doTest("T14",
        "CAD:EYEPROBL;114 REBEL RUN LP;STONE MOUNTAIN RD;STONE MOUNTAIN RD;STON;120;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient with an eye injury. The patient is a 22-year-old femal\r\n" +
        "\r\n",

        "CALL:EYEPROBL",
        "ADDR:114 REBEL RUN LP",
        "X:STONE MOUNTAIN RD & STONE MOUNTAIN RD",
        "CITY:STONEVILLE",
        "UNIT:120",
        "INFO:You are responding to a patient with an eye injury. The patient is a 22-year-old femal");

    doTest("T15",
        "CAD:UNCONSCI;2810 SETTLE BRIDGE RD;DOGWOOD RD;NC 135;STON;120;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 66-year-old f\r\n" +
        "\r\n",

        "CALL:UNCONSCI",
        "ADDR:2810 SETTLE BRIDGE RD",
        "X:DOGWOOD RD & NC 135",
        "CITY:STONEVILLE",
        "UNIT:120",
        "INFO:You are responding to a patient who is unconscious (or has fainted). The patient is a 66-year-old f");

    doTest("T16",
        "CAD:MVA;SETTLE BRIDGE RD/NC 135;STON;120;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient injured in a traffic incident. The patient is a 35-year-old male, who is conscious and\r\n" +
        "\r\n",

        "CALL:MVA",
        "ADDR:SETTLE BRIDGE RD & NC 135",
        "MADDR:SETTLE BRIDGE RD & STATE 135",
        "CITY:STONEVILLE",
        "UNIT:120",
        "INFO:You are responding to a patient injured in a traffic incident. The patient is a 35-year-old male, who is conscious and");

    doTest("T17",
        "CAD:BREATHIN;149 STERLING DR;BOB TR;STON;120;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 23-year-old male, who is conscious and bre\r\n" +
        "\r\n",

        "CALL:BREATHIN",
        "ADDR:149 STERLING DR",
        "X:BOB TR",
        "CITY:STONEVILLE",
        "UNIT:120",
        "INFO:You are responding to a patient with breathing problems. The patient is a 23-year-old male, who is conscious and bre");

    doTest("T18",
        "CAD:CHESTPAI;445 YOUNG RD;NC 135;NC 770;STON;120;[EMS] TACT 4444444444 [10/27/12 09:03:20 SGARRISON] [Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient\r\n" +
        "\r\n",

        "CALL:CHESTPAI",
        "ADDR:445 YOUNG RD",
        "X:NC 135 & NC 770",
        "CITY:STONEVILLE",
        "UNIT:120",
        "INFO:TACT 4444444444 / You are responding to a patient with chest pain. The patient",
        "DATE:10/27/12",
        "TIME:09:03:20");

    doTest("T19",
        "CAD:All Units Stage;122 TOP RUN DR; STON\r\n\r\n",
        "CALL:All Units Stage",
        "ADDR:122 TOP RUN DR",
        "CITY:STONEVILLE");

    doTest("T20",
        "CAD:DIABETIC;122 TOP RUN DR;STON;120;TACT 2222222222 [10/27/12 08:08:57 SGARRISON] [Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient with diabetic problems. The patient is a\r\n" +
        "\r\n",

        "CALL:DIABETIC",
        "ADDR:122 TOP RUN DR",
        "CITY:STONEVILLE",
        "UNIT:120",
        "CH:TACT 2222222222",
        "INFO:You are responding to a patient with diabetic problems. The patient is a",
        "DATE:10/27/12",
        "TIME:08:08:57");

  }
  
  @Test
  public void testEdenRescue() {

    doTest("T1",
        "CAD:STBYRES;858 MT CARMEL CHURCH RD;CRUTCHFIELD RD;TOBACCO DR;REID;OREGON HILL FIRE DEPARTMENT;BAS3\r\n\r\n",
        "CALL:STBYRES",
        "ADDR:858 MT CARMEL CHURCH RD",
        "X:CRUTCHFIELD RD & TOBACCO DR",
        "CITY:REIDSVILLE",
        "PLACE:OREGON HILL FIRE DEPARTMENT",
        "UNIT:BAS3");

    doTest("T2",
        "CAD:BREATHIN;216 N OAKLAND AVE;UNION ST;DUNN ST;EDEN;CHADWICK APARTMENTS;06D02A;BAS1\r\n\r\n",
        "CALL:BREATHIN",
        "ADDR:216 N OAKLAND AVE",
        "X:UNION ST & DUNN ST",
        "CITY:EDEN",
        "PLACE:CHADWICK APARTMENTS",
        "CODE:06D02A",
        "UNIT:BAS1");

    doTest("T3",
        "CAD:CHESTPAI;BOONE RD/EARLY AVE;EDEN;10C01;BAS1\r\n\r\n",
        "CALL:CHESTPAI",
        "ADDR:BOONE RD & EARLY AVE",
        "CITY:EDEN",
        "CODE:10C01",
        "UNIT:BAS1");

    doTest("T4",
        "CAD:CHESTPAI;1235 NORMAN DR;PRICE ST;ROBERTS ST;EDEN;PARKLAND APARTMENTS;10C04;BAS1\r\n\r\n",
        "CALL:CHESTPAI",
        "ADDR:1235 NORMAN DR",
        "X:PRICE ST & ROBERTS ST",
        "CITY:EDEN",
        "PLACE:PARKLAND APARTMENTS",
        "CODE:10C04",
        "UNIT:BAS1");

    doTest("T5",
        "CAD:TRAUMA;900 CHURCH ST;S HAMILTON ST;N OAKLAND AVE;EDEN;30A01;BAS1\r\n\r\n",
        "CALL:TRAUMA",
        "ADDR:900 CHURCH ST",
        "X:S HAMILTON ST & N OAKLAND AVE",
        "CITY:EDEN",
        "CODE:30A01",
        "UNIT:BAS1");

    doTest("T6",
        "CAD:ONEUNIT;150 NC 65;JUSTICE CENTER DR;COUNTY HOME RD;REID;EMERGENCY SERVICES;BAS3\r\n\r\n",
        "CALL:ONEUNIT",
        "ADDR:150 NC 65",
        "MADDR:150 STATE 65",
        "X:JUSTICE CENTER DR & COUNTY HOME RD",
        "CITY:REIDSVILLE",
        "PLACE:EMERGENCY SERVICES",
        "UNIT:BAS3");

    doTest("T7",
        "CAD:FALLS;1607 E MEADOW RD;MAIN ST;PHILLIP ST;EDEN;BAS1\r\n\r\n",
        "CALL:FALLS",
        "ADDR:1607 E MEADOW RD",
        "X:MAIN ST & PHILLIP ST",
        "CITY:EDEN",
        "UNIT:BAS1");

    doTest("T8",
        "CAD:DIABETIC;133 NANCE ST;NC 87;AZALEA RD;EDEN;13C01;BAS1\r\n\r\n",
        "CALL:DIABETIC",
        "ADDR:133 NANCE ST",
        "X:NC 87 & AZALEA RD",
        "CITY:EDEN",
        "CODE:13C01",
        "UNIT:BAS1");

    doTest("T9",
        "CAD:ONEUNIT;150 NC 65;JUSTICE CENTER DR;COUNTY HOME RD;REID;EMERGENCY SERVICES;BAS3\r\n\r\n",
        "CALL:ONEUNIT",
        "ADDR:150 NC 65",
        "MADDR:150 STATE 65",
        "X:JUSTICE CENTER DR & COUNTY HOME RD",
        "CITY:REIDSVILLE",
        "PLACE:EMERGENCY SERVICES",
        "UNIT:BAS3");

    doTest("T10",
        "CAD:UNDER CONTROL;6970 NC 135; MAY ;RM 27\r\n\r\n",
        "CALL:UNDER CONTROL",
        "ADDR:6970 NC 135",
        "MADDR:6970 STATE 135",
        "CITY:MAYODAN",
        "APT:RM 27");

    doTest("T11",
        "CAD:MVA;ELLETT AVE/N OAKLAND AVE;EDEN;BAS1\r\n\r\n",
        "CALL:MVA",
        "ADDR:ELLETT AVE & N OAKLAND AVE",
        "CITY:EDEN",
        "UNIT:BAS1");

    doTest("T12",
        "CAD:CPRDEATH;6970 NC 135;DAN VALLEY RD;RIVER RD;MAY;NORTH POINTE OF MAYODAN;09D01;BAS2\r\n\r\n",
        "CALL:CPRDEATH",
        "ADDR:6970 NC 135",
        "MADDR:6970 STATE 135",
        "X:DAN VALLEY RD & RIVER RD",
        "CITY:MAYODAN",
        "PLACE:NORTH POINTE OF MAYODAN",
        "CODE:09D01",
        "UNIT:BAS2");

    doTest("T13",
        "CAD:HEART;1224 RIDGE AVE;N HALE ST;N HUNDLEY DR;EDEN;19D02;BAS1\r\n\r\n",
        "CALL:HEART",
        "ADDR:1224 RIDGE AVE",
        "X:N HALE ST & N HUNDLEY DR",
        "CITY:EDEN",
        "CODE:19D02",
        "UNIT:BAS1");

    doTest("T14",
        "CAD:SEIZURES;730 MORGAN RD;OAK ST;HOLLAND ST;EDEN;12D02E;BAS1\r\n\r\n",
        "CALL:SEIZURES",
        "ADDR:730 MORGAN RD",
        "X:OAK ST & HOLLAND ST",
        "CITY:EDEN",
        "CODE:12D02E",
        "UNIT:BAS1");

    doTest("T15",
        "CAD:CONVO;117 E KINGS HWY;S VAN BUREN RD;LINDEN DR;EDEN;MOREHEAD MEMORIAL HOSPITAL;BAS1\r\n\r\n",
        "CALL:CONVO",
        "ADDR:117 E KINGS HWY",
        "X:S VAN BUREN RD & LINDEN DR",
        "CITY:EDEN",
        "PLACE:MOREHEAD MEMORIAL HOSPITAL",
        "UNIT:BAS1");

    doTest("T16",
        "CAD:UNDER CONTROL;803 S VAN BUREN RD; EDEN\r\n\r\n",
        "CALL:UNDER CONTROL",
        "ADDR:803 S VAN BUREN RD",
        "CITY:EDEN");

    doTest("T17",
        "CAD:MVA;803 S VAN BUREN RD;W HARRIS PL;KNIGHT ST;EDEN;LITTLE CEASARS;29B01;BAS1\r\n\r\n",
        "CALL:MVA",
        "ADDR:803 S VAN BUREN RD",
        "X:W HARRIS PL & KNIGHT ST",
        "CITY:EDEN",
        "PLACE:LITTLE CEASARS",
        "CODE:29B01",
        "UNIT:BAS1");

    doTest("T18",
        "CAD:STROKE;205 E KINGS HWY;S VAN BUREN RD;LINDEN DR;EDEN;MOREHEAD NURSING CENTER;28C09L;BAS1\r\n\r\n",
        "CALL:STROKE",
        "ADDR:205 E KINGS HWY",
        "X:S VAN BUREN RD & LINDEN DR",
        "CITY:EDEN",
        "PLACE:MOREHEAD NURSING CENTER",
        "CODE:28C09L",
        "UNIT:BAS1");

    doTest("T19",
        "CAD:BREATHIN;618 S PIERCE ST;PIERCE ST;E ARBOR LN;EDEN;WOUND CENTER;06C01;BAS1\r\n\r\n",
        "CALL:BREATHIN",
        "ADDR:618 S PIERCE ST",
        "X:PIERCE ST & E ARBOR LN",
        "CITY:EDEN",
        "PLACE:WOUND CENTER",
        "CODE:06C01",
        "UNIT:BAS1");

    doTest("T20",
        "CAD:HEMORRHA;705 IRVING AVE;MOIR ST;BRIDGE ST;EDEN;21D03;BAS1\r\n\r\n",
        "CALL:HEMORRHA",
        "ADDR:705 IRVING AVE",
        "X:MOIR ST & BRIDGE ST",
        "CITY:EDEN",
        "CODE:21D03",
        "UNIT:BAS1");
  
  }
 
  @Test
  public void testHuntsvilleFire() {

    doTest("T1",
        "CAD:BREATHIN;1012 GIDEON GROVE CHURCH RD;WINDING CREEK RD;WOODGROVE WAY;STOK;150\r\n\r\n",
        "CALL:BREATHIN",
        "ADDR:1012 GIDEON GROVE CHURCH RD",
        "X:WINDING CREEK RD & WOODGROVE WAY",
        "CITY:STOKESDALE",
        "UNIT:150");

    doTest("T2",
        "CAD:MVA;631 SARDIS CHURCH RD;PILOTVIEW LP;PILOTVIEW LP;MAD;150\r\n\r\n",
        "CALL:MVA",
        "ADDR:631 SARDIS CHURCH RD",
        "X:PILOTVIEW LP & PILOTVIEW LP",
        "CITY:MADISON",
        "UNIT:150");

    doTest("T3",
        "CAD:MVA;GRIFFIN RD/GOLD HILL RD;MAD;150\r\n\r\n",
        "CALL:MVA",
        "ADDR:GRIFFIN RD & GOLD HILL RD", // Google says this is in NEW BETHEL
        "CITY:MADISON",
        "UNIT:150");

    doTest("T4",
        "CAD:PATIENT FREE;1783 ANGELL RD; MAD\r\n\r\n",
        "CALL:PATIENT FREE",
        "ADDR:1783 ANGELL RD",
        "CITY:MADISON");

    doTest("T5",
        "CAD:UNDER CONTROL;100 SERVICE RD; PELH\r\n\r\n",
        "CALL:UNDER CONTROL",
        "ADDR:100 SERVICE RD",
        "CITY:PELHAM");

    doTest("T6",
        "CAD:STRUC;100 SERVICE RD;MAYFIELD RD;STACEY RD;PELH;20;[LAW] C13 ADV OF CALL [11/05/12 13:36:17 SGARRISON] [EMS] caller advises that this is nearer to stacey rd [11/05/12 13:33:24 LREYES] half mile to a mile north of the ramp in the south b\r\n" +
        "\r\n",

        "CALL:STRUC",
        "ADDR:100 SERVICE RD",
        "X:MAYFIELD RD & STACEY RD",
        "CITY:PELHAM",
        "UNIT:20",
        "INFO:C13 ADV OF CALL / caller advises that this is nearer to stacey rd / half mile to a mile north of the ramp in the south b",
        "DATE:11/05/12",
        "TIME:13:36:17");

    doTest("T7",
        "CAD:TRAUMA;1783 ANGELL RD;SANDROCK RIDGE LN;GOLD HILL RD;MAD;150\r\n\r\n",
        "CALL:TRAUMA",
        "ADDR:1783 ANGELL RD",
        "X:SANDROCK RIDGE LN & GOLD HILL RD",
        "CITY:MADISON",
        "UNIT:150");

    doTest("T8",
        "CAD:MVA;3099 US 220;HARNED FARM RD;RICKYS TR;MAD;150;2 MILES SOUTH OF THE MADISON EXIT IN THE NORTH BOUND LN [11/05/12 07:02:34 CBODEY] Aborted by Medical Priority with code: ON THE LINE [11/05/12 07:00:32 CBODEY] SILVER IN CALLER [11/05/12\r\n" +
        "\r\n",

        "CALL:MVA",
        "ADDR:3099 US 220",
        "X:HARNED FARM RD & RICKYS TR",
        "CITY:MADISON",
        "UNIT:150",
        "INFO:2 MILES SOUTH OF THE MADISON EXIT IN THE NORTH BOUND LN / Aborted by Medical Priority with code: ON THE LINE / SILVER IN CALLER",
        "DATE:11/05/12",
        "TIME:07:02:34");

    doTest("T9",
        "CAD:FALLS;521 MINERAL SPRINGS RD;NELL RD;M & M LN;MAD;150;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 59-year-old female, who is conscio\r\n" +
        "\r\n",

        "CALL:FALLS",
        "ADDR:521 MINERAL SPRINGS RD",
        "X:NELL RD & M & M LN",
        "CITY:MADISON",
        "UNIT:150",
        "INFO:You are responding to a patient involved in a fall. The patient is a 59-year-old female, who is conscio");

    doTest("T10",
        "CAD:HEART;241 STANLEY RD;ELLISBORO RD;HONEY RD;STOK;150;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient with heart problems. The patient is a 68-year-old female, who is consciou\r\n" +
        "\r\n",

        "CALL:HEART",
        "ADDR:241 STANLEY RD",
        "X:ELLISBORO RD & HONEY RD",
        "CITY:STOKESDALE",
        "UNIT:150",
        "INFO:You are responding to a patient with heart problems. The patient is a 68-year-old female, who is consciou");

    doTest("T11",
        "CAD:MVA;LINDSEY BRIDGE RD/EDEN CHURCH RD;MAD;150;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to patients involved in a traffic incident. (If known -- relay pertinent patient-specific inf\r\n" +
        "\r\n",

        "CALL:MVA",
        "ADDR:LINDSEY BRIDGE RD & EDEN CHURCH RD",  // Google says this in Huntsville
        "CITY:MADISON",
        "UNIT:150",
        "INFO:You are responding to patients involved in a traffic incident. (If known -- relay pertinent patient-specific inf");

    doTest("T12",
        "CAD:BRUSH;1100-BLK PIPE PLANT RD;stokes county is requesting station 150 to stand by at stokes 37 [11/01/12 15:23:20 JBOWLES] tanker and brush truck.....off us 311..req station 50 to respond... [11/01/12 15:13:06 JBOWLES]\r\n" +
        "\r\n",

        "CALL:BRUSH",
        "ADDR:1100-BLK PIPE PLANT RD",
        "MADDR:1100 PIPE PLANT RD",
        "X:stokes county is requesting station 150 to stand by at stokes 37 & tanker and brush truck.....off us 311..req station 50 to respond...",
        "DATE:11/01/12",
        "TIME:15:23:20");

    doTest("T13",
        "CAD:UNDER CONTROL;100 JW RD; MAD\r\n\r\n",
        "CALL:UNDER CONTROL",
        "ADDR:100 JW RD",
        "CITY:MADISON");

    doTest("T14",
        "CAD:BRUSH;100 JW RD;LINDSEY BRIDGE RD;MAD;150;brush fire in the woods.... 10 to 15 feet from a building..and 25 yards from a house... [11/01/12 14:40:33 JBOWLES]\r\n" +
        "\r\n",

        "CALL:BRUSH",
        "ADDR:100 JW RD",
        "X:LINDSEY BRIDGE RD",
        "CITY:MADISON",
        "UNIT:150",
        "INFO:brush fire in the woods.... 10 to 15 feet from a building..and 25 yards from a house...",
        "DATE:11/01/12",
        "TIME:14:40:33");

    doTest("T15",
        "CAD:FIREALRM;1102 LINDSEY BRIDGE RD;RIERSON RD;JW RD;MAD;150;GENERAL FIRE ALARM ATTEMPTING NEXT... [10/29/12 18:23:19 CBODEY]\r\n\r\n",
        "CALL:FIREALRM",
        "ADDR:1102 LINDSEY BRIDGE RD",
        "X:RIERSON RD & JW RD",
        "CITY:MADISON",
        "UNIT:150",
        "INFO:GENERAL FIRE ALARM ATTEMPTING NEXT...",
        "DATE:10/29/12",
        "TIME:18:23:19");

    doTest("T16",
        "CAD:UNDER CONTROL;230 FRIENDS FARM WAY; STOK\r\n\r\n",
        "CALL:UNDER CONTROL",
        "ADDR:230 FRIENDS FARM WAY",
        "CITY:STOKESDALE");

    doTest("T17",
        "CAD:MVA;230 FRIENDS FARM WAY;STOK;150;Radio Channel: 666666 [10/28/12 16:23:36 RKIVETT] [Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient injured in a traffic incident. The p\r\n" +
        "\r\n",

        "CALL:MVA",
        "ADDR:230 FRIENDS FARM WAY",
        "CITY:STOKESDALE",
        "UNIT:150",
        "INFO:Radio Channel: 666666 / You are responding to a patient injured in a traffic incident. The p",
        "DATE:10/28/12",
        "TIME:16:23:36");

    doTest("T18",
        "CAD:CHESTPAI;480 MARTIN FARM RD;REJOYCE LN;MAD;150;[Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 82-year-old female, who is conscious and bre\r\n" +
        "\r\n",

        "CALL:CHESTPAI",
        "ADDR:480 MARTIN FARM RD",
        "X:REJOYCE LN",
        "CITY:MADISON",
        "UNIT:150",
        "INFO:You are responding to a patient with chest pain. The patient is a 82-year-old female, who is conscious and bre");

    doTest("T19",
        "CAD:UNDER CONTROL;1139 SARDIS CHURCH RD; MAD\r\n\r\n",
        "CALL:UNDER CONTROL",
        "ADDR:1139 SARDIS CHURCH RD",
        "CITY:MADISON");

    doTest("T20",
        "CAD:CPRDEATH;1139 SARDIS CHURCH RD;ELLISBORO RD;DALTON LAKE RD;MAD;LZ 150 HUNTSVILLE BALL PARK;150;[EMS] PULSE IS 122 AND WEAK [10/26/12 20:54:36 JBOWLES] [Medical Priority Info] RESPONSE: ALS HOT & FIRST RESPONDERS RESPONDER SCRIPT: You ar\r\n" +
        "\r\n",

        "CALL:CPRDEATH",
        "ADDR:1139 SARDIS CHURCH RD",
        "X:ELLISBORO RD & DALTON LAKE RD",
        "CITY:MADISON",
        "PLACE:LZ 150 HUNTSVILLE BALL PARK",
        "UNIT:150",
        "INFO:PULSE IS 122 AND WEAK / You ar",
        "DATE:10/26/12",
        "TIME:20:54:36");

  }
  

  public static void main(String[] args) {
    new NCRockinghamCountyParserTest().generateTests("T1");
  }
}
