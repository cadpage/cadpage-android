package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class COGarfieldCountyParserTest extends BaseParserTest {
  
  public COGarfieldCountyParserTest() {
    setParser(new COGarfieldCountyParser(), "GARFIELD COUNTY", "CO");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(CAD Page) Accident Location  97 E I70SILT 2012 00000387     ",
        "CALL:Accident",
        "ADDR:97 E I70",
        "MADDR:97 E I 70",
        "CITY:SILT",
        "ID:2012 00000387");

    doTest("T2",
        "(CAD Page) FSmoke Check Location  15000 CORD 313 Z2 2012 00000388     ",
        "CALL:FSmoke Check",
        "ADDR:15000 CORD 313",
        "MADDR:15000 COUNTY ROAD 313",
        "MAP:Z2",
        "ID:2012 00000388");

    doTest("T3",
        "(CAD Page) Code Location  CHAIR BAR RD CORD 331 Z2 2012 00000389     ",
        "CALL:Code",
        "ADDR:CHAIR BAR RD & CORD 331",
        "MADDR:CHAIR BAR RD & COUNTY ROAD 331",  // Can't dinf CHAIR BAR RD
        "MAP:Z2",
        "ID:2012 00000389");

    doTest("T4",
        "(CAD Page) FBrush Location  94.5 HWY 6Z2 2012 00000554     ",
        "CALL:FBrush",
        "ADDR:94.5 HWY 6",
        "MAP:Z2",
        "ID:2012 00000554");

    doTest("T5",
        "(CAD Page) EBleeding Non traumatic Location  667 N 16TH ST SILT 2012 00000391     ",
        "CALL:EBleeding Non traumatic",
        "ADDR:667 N 16TH ST",
        "CITY:SILT",
        "ID:2012 00000391");

    doTest("T6",
        "(CAD Page) Code Location  ELK CREEK CAMPGROUND Z2 2012 00000393     ",
        "CALL:Code",
        "ADDR:ELK CREEK CAMPGROUND",
        "MAP:Z2",
        "ID:2012 00000393");

    doTest("T7",
        "(CAD Page) Code Location  1360 EM AVE SILT 2012 00000394     ",
        "CALL:Code",
        "ADDR:1360 EM AVE",
        "CITY:SILT",
        "ID:2012 00000394");

    doTest("T8",
        "(CAD Page) Code Location  ELK CREEK CAMPGROUND Z2 2012 00000393     ",
        "CALL:Code",
        "ADDR:ELK CREEK CAMPGROUND", // Not mapping
        "MAP:Z2",
        "ID:2012 00000393");

    doTest("T9",
        "(CAD Page) EChest Pain Location  124 E  MAIN ST NC 2012 00000395     ",
        "CALL:EChest Pain",
        "ADDR:124 E MAIN ST",
        "CITY:NEW CASTLE",
        "ID:2012 00000395");

    doTest("T10",
        "(CAD Page) Accident Location  12545 CORD 245 Z2 2012 00000396     ",
        "CALL:Accident",
        "ADDR:12545 CORD 245",
        "MADDR:12545 COUNTY ROAD 245",
        "MAP:Z2",
        "ID:2012 00000396");

    doTest("T11",
        "(CAD Page) FOdor Check Location  794 CASTLE VALLEY BLVD NC APT G 2012 00003116     ",
        "CALL:FOdor Check",
        "ADDR:794 CASTLE VALLEY BLVD",
        "CITY:NEW CASTLE",
        "APT:G",
        "ID:2012 00003116");

    doTest("T12",
        "(CAD Page) Code Location  CORD 229 USHY 6 Z2 2012 00000398     ",
        "CALL:Code",
        "ADDR:CORD 229 & USHY 6",
        "MADDR:COUNTY ROAD 229 & US 6",
        "MAP:Z2",
        "ID:2012 00000398");

    doTest("T13",
        "(CAD Page) Accident Location  105 E I70NC 2012 00000399     ",
        "CALL:Accident",
        "ADDR:105 E I70",
        "MADDR:105 E I 70",
        "CITY:NEW CASTLE",
        "ID:2012 00000399");

    doTest("T14",
        "(CAD Page) Accident Location  100 E I70Z2 2012 00015425     ",
        "CALL:Accident",
        "ADDR:100 E I70",
        "MADDR:100 E I 70",
        "MAP:Z2",
        "ID:2012 00015425");

    doTest("T15",
        "(CAD Page) ETrauma with Injury Location  1601 ORCHARD AVE SILT 2012 00000401     ",
        "CALL:ETrauma with Injury",
        "ADDR:1601 ORCHARD AVE",
        "CITY:SILT",
        "ID:2012 00000401");

    doTest("T16",
        "(CAD Page) EOverdose Poisoning Location  200 N 7TH ST blk NC 2012 00000402     ",
        "CALL:EOverdose Poisoning",
        "ADDR:200 N 7TH ST BLK",
        "MADDR:200 N 7TH ST",
        "CITY:NEW CASTLE",
        "ID:2012 00000402");

    doTest("T17",
        "(CAD Page) FSmoke Check Location  7696 CORD 312 Z2 2012 00000403     ",
        "CALL:FSmoke Check",
        "ADDR:7696 CORD 312",
        "MADDR:7696 COUNTY ROAD 312",
        "MAP:Z2",
        "ID:2012 00000403");

    doTest("T18",
        "(CAD Page) FBrush Location  7299 CORD 233 Z2 2012 00000404     ",
        "CALL:FBrush",
        "ADDR:7299 CORD 233",
        "MADDR:7299 COUNTY ROAD 233",
        "MAP:Z2",
        "ID:2012 00000404");

    doTest("T19",
        "(CAD Page) FAlarm Location  56 EL DIENTE WAY NC 2012 00000405     ",
        "CALL:FAlarm",
        "ADDR:56 EL DIENTE WAY",
        "CITY:NEW CASTLE",
        "ID:2012 00000405");

    doTest("T20",
        "(CAD Page) FAlarm Location  560 RIVER VIEW DR 7 NC 2012 00000406     ",
        "CALL:FAlarm",
        "ADDR:560 RIVER VIEW DR 7",
        "CITY:NEW CASTLE",
        "ID:2012 00000406");

    doTest("T21",
        "(CAD Page) FSmoke Check Location  4200 CORD 243 Z2 2012 00000408     ",
        "CALL:FSmoke Check",
        "ADDR:4200 CORD 243",
        "MADDR:4200 COUNTY ROAD 243",
        "MAP:Z2",
        "ID:2012 00000408");

    doTest("T22",
        "(CAD Page) Code Location  3600 CORD 237 Z2 2012 00000410     ",
        "CALL:Code",
        "ADDR:3600 CORD 237",
        "MADDR:3600 COUNTY ROAD 237",
        "MAP:Z2",
        "ID:2012 00000410");

    doTest("T23",
        "(CAD Page) FBrush Location  97.5 E I70SILT 2012 00000411     ",
        "CALL:FBrush",
        "ADDR:97.5 E I70",
        "MADDR:97.5 E I 70",
        "CITY:SILT",
        "ID:2012 00000411");

    doTest("T24",
        "(CAD Page) EFalls Location  287 LUPINE DR NC 2012 00000412     ",
        "CALL:EFalls",
        "ADDR:287 LUPINE DR",
        "CITY:NEW CASTLE",
        "ID:2012 00000412");

    doTest("T25",
        "(CAD Page) EBack Pain Location  Silt Senior Housing701 HOME AVE 108 SILT 2012 00000413     ",
        "CALL:EBack Pain",
        "PLACE:Silt Senior Housing",
        "ADDR:701 HOME AVE 108",
        "CITY:SILT",
        "ID:2012 00000413");

    doTest("T26",
        "(CAD Page) ETrauma with Injury Location  247 E  CAPITAL CT NC 2012 00000414     ",
        "CALL:ETrauma with Injury",
        "ADDR:247 E CAPITAL CT",
        "CITY:NEW CASTLE",
        "ID:2012 00000414");

    doTest("T27",
        "(CAD Page) FVehicle Fire Location  105 E I70NC 2012 00000415     ",
        "CALL:FVehicle Fire",
        "ADDR:105 E I70",
        "MADDR:105 E I 70",
        "CITY:NEW CASTLE",
        "ID:2012 00000415");

    doTest("T28",
        "(CAD Page) FRiver Rescue Location  SOUTH CANYON BRIDGE Z1 2012 00000806     ",
        "CALL:FRiver Rescue",
        "ADDR:SOUTH CANYON BRIDGE",
        "MAP:Z1",
        "ID:2012 00000806");

    doTest("T29",
        "(CAD Page) EFalls Location  APPLE TREE MHP5033 CORD 335 Z2 2012 00000421     ",
        "CALL:EFalls",
        "PLACE:APPLE TREE MHP",
        "ADDR:5033 CORD 335",
        "MADDR:5033 COUNTY ROAD 335",
        "MAP:Z2",
        "ID:2012 00000421");

    doTest("T30",
        "(CAD Page) Code Location  221 N 7TH ST NC 2012 00000422     ",
        "CALL:Code",
        "ADDR:221 N 7TH ST",
        "CITY:NEW CASTLE",
        "ID:2012 00000422");

    doTest("T31",
        "(CAD Page) Accident Location  98.5 W I70Z2 2012 00016190     ",
        "CALL:Accident",
        "ADDR:98.5 W I70",
        "MADDR:98.5 W I 70",
        "MAP:Z2",
        "ID:2012 00016190");

    doTest("T32",
        "(CAD Page) EAbdominal Location  122 E  MAIN ST NC 2012 00000424     ",
        "CALL:EAbdominal",
        "ADDR:122 E MAIN ST",
        "CITY:NEW CASTLE",
        "ID:2012 00000424");

    doTest("T33",
        "(CAD Page) ESeizures Location  5033 CORD 335 28 Z2 2012 00000427     ",
        "CALL:ESeizures",
        "ADDR:5033 CORD 335 28",
        "MADDR:5033 COUNTY ROAD 335 28",
        "MAP:Z2",
        "ID:2012 00000427");

    doTest("T34",
        "(CAD Page) EFalls Location  1220 CHARLIN AVE SILT 2012 00002784     ",
        "CALL:EFalls",
        "ADDR:1220 CHARLIN AVE",
        "CITY:SILT",
        "ID:2012 00002784");

    doTest("T35",
        "(CAD Page) FSmoke Check Location  CORD 250 CORD 237 Z2 2012 00000431     ",
        "CALL:FSmoke Check",
        "ADDR:CORD 250 & CORD 237",
        "MADDR:COUNTY ROAD 250 & COUNTY ROAD 237",
        "MAP:Z2",
        "ID:2012 00000431");

    doTest("T36",
        "(CAD Page) FSmoke Check Location  S W OF JOLLEY MESA Z2 2012 00000433     ",
        "CALL:FSmoke Check",
        "ADDR:S W OF JOLLEY MESA",
        "MAP:Z2",
        "ID:2012 00000433");

    doTest("T37",
        "(CAD Page) FBrush Location  FOREST SERVICE RD 603 Z2 2012 00000434     ",
        "CALL:FBrush",
        "ADDR:FOREST SERVICE RD 603", // Not Mapping
        "MAP:Z2",
        "ID:2012 00000434");

    doTest("T38",
        "(CAD Page) ESick Unknown Location  FOREST RD 603 Z2 2012 00000435     ",
        "CALL:ESick Unknown",
        "ADDR:FOREST RD 603", // Also not mapping
        "MAP:Z2",
        "ID:2012 00000435");

    doTest("T39",
        "(CAD Page) EOverdose Poisoning Location  120 S  E AVE NC 2012 00000436     ",
        "CALL:EOverdose Poisoning",
        "ADDR:120 S E AVE",
        "CITY:NEW CASTLE",
        "ID:2012 00000436");

    doTest("T40",
        "(CAD Page) FGas Leak Location  386 W MAIN ST 7 NC 2012 00000437     ",
        "CALL:FGas Leak",
        "ADDR:386 W MAIN ST 7",
        "CITY:NEW CASTLE",
        "ID:2012 00000437");

    doTest("T41",
        "(CAD Page) EGynecology Childbirth Location  422 W  RICHARDS AVE SILT 2012 00000438     ",
        "CALL:EGynecology Childbirth",
        "ADDR:422 W RICHARDS AVE",
        "CITY:SILT",
        "ID:2012 00000438");

    doTest("T42",
        "(CAD Page) FSmoke Check Location  97 E I70SILT 2012 00000439     ",
        "CALL:FSmoke Check",
        "ADDR:97 E I70",
        "MADDR:97 E I 70",
        "CITY:SILT",
        "ID:2012 00000439");

    doTest("T43",
        "(CAD Page) EChest Pain Location  144 PEAR CT Z2 2012 00000440     ",
        "CALL:EChest Pain",
        "ADDR:144 PEAR CT",
        "MAP:Z2",
        "ID:2012 00000440");

  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "([1/1] CAD Page) Accident Location  103 E I70Z2 2012 00018886     ",
        "CALL:Accident",
        "ADDR:103 E I70",
        "MADDR:103 E I 70",
        "MAP:Z2",
        "ID:2012 00018886");

    doTest("T2",
        "([1/1] CAD Page) EFalls Location  150 UTE AVE RIF APT L1 2012 00000739     ",
        "CALL:EFalls",
        "ADDR:150 UTE AVE",
        "APT:L1",
        "CITY:RIFLE",
        "ID:2012 00000739");

    doTest("T3",
        "([1/1] CAD Page) EChoking Location  451 SILVERHORN DR NC 2012 00000510     ",
        "CALL:EChoking",
        "ADDR:451 SILVERHORN DR",
        "CITY:NEW CASTLE",
        "ID:2012 00000510");

    doTest("T4",
        "([1/1] CAD Page) ESick Unknown Location  APPLE TREE MHP5033 CORD 335 138 Z2 2012 00000511     ",
        "CALL:ESick Unknown",
        "PLACE:APPLE TREE MHP",
        "ADDR:5033 CORD 335 138",
        "MADDR:5033 COUNTY ROAD 335 138",
        "MAP:Z2",
        "ID:2012 00000511");

    doTest("T5",
        "([1/1] CAD Page) FAlarm Location  Colorado State Veterians Nursing Home851 E  5TH ST RIF 2012 00000742     ",
        "CALL:FAlarm",
        "PLACE:Colorado State Veterians Nursing Home",
        "ADDR:851 E 5TH ST",
        "CITY:RIFLE",
        "ID:2012 00000742");

    doTest("T6",
        "([1/1] CAD Page) Accident Location  TAUGHENBAUGH STHY 13 ROUNDABOUTRIF 2012 00009976     ",
        "CALL:Accident",
        "ADDR:TAUGHENBAUGH STHY 13 ROUNDABOUT",
        "MADDR:TAUGHENBAUGH ST 13 ROUNDABOUT",
        "CITY:RIFLE",
        "ID:2012 00009976");

    doTest("T7",
        "([1/1] CAD Page) Accident Location  HARVEY GAP Z2 2012 00000512     ",
        "CALL:Accident",
        "ADDR:HARVEY GAP",
        "MAP:Z2",
        "ID:2012 00000512");

    doTest("T8",
        "([1/1] CAD Page) EFalls Location  1218 BALLARD AVE SILT 2012 00000513     ",
        "CALL:EFalls",
        "ADDR:1218 BALLARD AVE",
        "CITY:SILT",
        "ID:2012 00000513");

    doTest("T9",
        "([1/1] CAD Page) FBrush Location  RIFLE PD201 E 18TH ST RIF 2012 00000747     ",
        "CALL:FBrush",
        "ADDR:RIFLE PD201 E 18TH ST",
        "CITY:RIFLE",
        "ID:2012 00000747");

    doTest("T10",
        "([1/1] CAD Page) EFalls Location  200 S  E AVE NC 2012 00000515     ",
        "CALL:EFalls",
        "ADDR:200 S E AVE",
        "CITY:NEW CASTLE",
        "ID:2012 00000515");

    doTest("T11",
        "([1/1] CAD Page) EStabbing Gunshot Location  Green Diamond Cabins1535 MAIN ST 8 Z2 2012 00000517     ",
        "CALL:EStabbing Gunshot",
        "PLACE:Green Diamond Cabins",
        "ADDR:1535 MAIN ST 8",
        "MAP:Z2",
        "ID:2012 00000517");

    doTest("T12",
        "([1/1] CAD Page) EAbdominal Location  826 CEDAR DR RIF 2012 00000749     ",
        "CALL:EAbdominal",
        "ADDR:826 CEDAR DR",
        "CITY:RIFLE",
        "ID:2012 00000749");

    doTest("T13",
        "([1/1] CAD Page) ETrauma with Injury Location  1325 ORCHARD AVE SILT 2012 00000518     ",
        "CALL:ETrauma with Injury",
        "ADDR:1325 ORCHARD AVE",
        "CITY:SILT",
        "ID:2012 00000518");

    doTest("T14",
        "([1/1] CAD Page) EMedical Alarm Location  54 WINCHESTER ST Z3 2012 00000750     ",
        "CALL:EMedical Alarm",
        "ADDR:54 WINCHESTER ST",
        "MAP:Z3",
        "ID:2012 00000750");

    doTest("T15",
        "([1/1] CAD Page) EMedical Alarm Location  188 SHOSHONE TRL Z2 2012 00000519     ",
        "CALL:EMedical Alarm",
        "ADDR:188 SHOSHONE TRL",
        "MAP:Z2",
        "ID:2012 00000519");

    doTest("T16",
        "([1/1] CAD Page) EUnconscious Syncope Location  420 W  26TH ST RIF 2012 00000751     ",
        "CALL:EUnconscious Syncope",
        "ADDR:420 W 26TH ST",
        "CITY:RIFLE",
        "ID:2012 00000751");

    doTest("T17",
        "([1/1] CAD Page) FVehicle Fire Location  32958 RIVER FRONTAGE RD Z2 2012 00000520     ",
        "CALL:FVehicle Fire",
        "ADDR:32958 RIVER FRONTAGE RD",
        "MAP:Z2",
        "ID:2012 00000520");

    doTest("T18",
        "([1/1] CAD Page) EBreathing Difficulty Location  Colorado State Veterians Nursing Home851 E  5TH ST RIF RM 142 2012 00000753     ",
        "CALL:EBreathing Difficulty",
        "PLACE:Colorado State Veterians Nursing Home",
        "ADDR:851 E 5TH ST RIF",
        "APT:142",
        "ID:2012 00000753");

    doTest("T19",
        "([1/1] CAD Page) FBrush Location  RIFLE CREEK GOLF COURSE3063 STHY 325 Z2 2012 00000754     ",
        "CALL:FBrush",
        "PLACE:RIFLE CREEK GOLF COURSE",
        "ADDR:3063 STHY 325",
        "MADDR:3063 CO 325",
        "MAP:Z2",
        "ID:2012 00000754");

    doTest("T20",
        "([1/1] CAD Page) Accident Location  109.5 W I70 2012 00000521     ",
        "CALL:Accident",
        "ADDR:109.5 W I70",
        "MADDR:109.5 W I 70",
        "ID:2012 00000521");

    doTest("T21",
        "([1/1] CAD Page) FVehicle Fire Location  91 E I70RIF 2012 00000755     ",
        "CALL:FVehicle Fire",
        "ADDR:91 E I70",
        "MADDR:91 E I 70",
        "CITY:RIFLE",
        "ID:2012 00000755");

    doTest("T22",
        "([1/1] CAD Page) EChest Pain Location  1300 CORD 311 Z2 2012 00000522     ",
        "CALL:EChest Pain",
        "ADDR:1300 CORD 311",
        "MADDR:1300 COUNTY ROAD 311",
        "MAP:Z2",
        "ID:2012 00000522");

    doTest("T23",
        "([1/1] CAD Page) EBack Pain Location  DSS Rif195 W  14TH ST RIF 2012 00000756     ",
        "CALL:EBack Pain",
        "PLACE:DSS Rif",
        "ADDR:195 W 14TH ST",
        "CITY:RIFLE",
        "ID:2012 00000756");

    doTest("T24",
        "([1/1] CAD Page) EMental Emotional Psych Location  W  2ND ST WEST RIF 2012 00000757     ",
        "CALL:EMental Emotional Psych",
        "ADDR:W 2ND ST WEST",
        "CITY:RIFLE",
        "ID:2012 00000757");

    doTest("T25",
        "([1/1] CAD Page) EMental Emotional Psych Location  1218 BALLARD AVE SILT UNIT TRLR 2012 00000523     ",
        "CALL:EMental Emotional Psych",
        "ADDR:1218 BALLARD AVE SILT UNIT TRLR",
        "ID:2012 00000523");

    doTest("T26",
        "([1/1] CAD Page) Accident Location  TOP OF STEVENS HILL Z2 2012 00000759     ",
        "CALL:Accident",
        "ADDR:TOP OF STEVENS HILL",
        "MAP:Z2",
        "ID:2012 00000759");

    doTest("T27",
        "([1/1] CAD Page) FAlarm Location  Wamsley Elementary225 E  30TH ST RIF 2012 00000761     ",
        "CALL:FAlarm",
        "PLACE:Wamsley Elementary",
        "ADDR:225 E 30TH ST",
        "CITY:RIFLE",
        "ID:2012 00000761");

    doTest("T28",
        "([1/1] CAD Page) ESeizures Location  241 N 7TH ST NC 2012 00000524     ",
        "CALL:ESeizures",
        "ADDR:241 N 7TH ST",
        "CITY:NEW CASTLE",
        "ID:2012 00000524");

    doTest("T29",
        "([1/1] CAD Page) FSmoke Check Location  APPLE TREE MHP5033 CORD 335 Z2 2012 00000525     ",
        "CALL:FSmoke Check",
        "PLACE:APPLE TREE MHP",
        "ADDR:5033 CORD 335",
        "MADDR:5033 COUNTY ROAD 335",
        "MAP:Z2",
        "ID:2012 00000525");

  }
  
  public static void main(String[] args) {
    new COGarfieldCountyParserTest().generateTests("T1", "CALL PLACE ADDR APT CITY MAP ID");
  }
}