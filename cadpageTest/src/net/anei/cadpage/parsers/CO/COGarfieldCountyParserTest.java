package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Garfield County, CO
Contact: Active911
Agency name: Burning Mountains Fire Protection District Location: New Castle, CO 
Sender: GCECA@call3n.com,@everbridge.net

(CAD Page) Accident Location  97 E I70SILT 2012 00000387     
(CAD Page) FSmoke Check Location  15000 CORD 313 Z2 2012 00000388     
(CAD Page) Code Location  CHAIR BAR RD CORD 331 Z2 2012 00000389     
(CAD Page) FBrush Location  94.5 HWY 6Z2 2012 00000554     
(CAD Page) EBleeding Non traumatic Location  667 N 16TH ST SILT 2012 00000391     
(CAD Page) Code Location  ELK CREEK CAMPGROUND Z2 2012 00000393     
(CAD Page) Code Location  1360 EM AVE SILT 2012 00000394     
(CAD Page) Code Location  ELK CREEK CAMPGROUND Z2 2012 00000393     
(CAD Page) EChest Pain Location  124 E  MAIN ST NC 2012 00000395     
(CAD Page) Accident Location  12545 CORD 245 Z2 2012 00000396     
(CAD Page) FOdor Check Location  794 CASTLE VALLEY BLVD NC APT G 2012 00003116     
(CAD Page) Code Location  CORD 229 USHY 6 Z2 2012 00000398     
(CAD Page) Accident Location  105 E I70NC 2012 00000399     
(CAD Page) Accident Location  100 E I70Z2 2012 00015425     
(CAD Page) ETrauma with Injury Location  1601 ORCHARD AVE SILT 2012 00000401     
(CAD Page) EOverdose Poisoning Location  200 N 7TH ST blk NC 2012 00000402     
(CAD Page) FSmoke Check Location  7696 CORD 312 Z2 2012 00000403     
(CAD Page) FBrush Location  7299 CORD 233 Z2 2012 00000404     
(CAD Page) FAlarm Location  56 EL DIENTE WAY NC 2012 00000405     
(CAD Page) FAlarm Location  560 RIVER VIEW DR 7 NC 2012 00000406     
(CAD Page) FSmoke Check Location  4200 CORD 243 Z2 2012 00000408     
(CAD Page) Code Location  3600 CORD 237 Z2 2012 00000410     
(CAD Page) FBrush Location  97.5 E I70SILT 2012 00000411     
(CAD Page) EFalls Location  287 LUPINE DR NC 2012 00000412     
(CAD Page) EBack Pain Location  Silt Senior Housing701 HOME AVE 108 SILT 2012 00000413     
(CAD Page) ETrauma with Injury Location  247 E  CAPITAL CT NC 2012 00000414     
(CAD Page) FVehicle Fire Location  105 E I70NC 2012 00000415     
(CAD Page) FRiver Rescue Location  SOUTH CANYON BRIDGE Z1 2012 00000806     
(CAD Page) EFalls Location  APPLE TREE MHP5033 CORD 335 Z2 2012 00000421     
(CAD Page) Code Location  221 N 7TH ST NC 2012 00000422     
(CAD Page) Accident Location  98.5 W I70Z2 2012 00016190     
(CAD Page) EAbdominal Location  122 E  MAIN ST NC 2012 00000424     
(CAD Page) ESeizures Location  5033 CORD 335 28 Z2 2012 00000427     
(CAD Page) EFalls Location  1220 CHARLIN AVE SILT 2012 00002784     
(CAD Page) FSmoke Check Location  CORD 250 CORD 237 Z2 2012 00000431     
(CAD Page) FSmoke Check Location  S W OF JOLLEY MESA Z2 2012 00000433     
(CAD Page) FBrush Location  FOREST SERVICE RD 603 Z2 2012 00000434
(CAD Page) ESick Unknown Location  FOREST RD 603 Z2 2012 00000435     
(CAD Page) EOverdose Poisoning Location  120 S  E AVE NC 2012 00000436     
(CAD Page) FGas Leak Location  386 W MAIN ST 7 NC 2012 00000437     
(CAD Page) EGynecology Childbirth Location  422 W  RICHARDS AVE SILT 2012 00000438     
(CAD Page) FSmoke Check Location  97 E I70SILT 2012 00000439     
(CAD Page) EChest Pain Location  144 PEAR CT Z2 2012 00000440

Contact: Active911
Agency name: Rifle Fire Protection District Location: Rifle, CO 
Sender: @everbridge.net

([1/1] CAD Page) Accident Location  103 E I70Z2 2012 00018886     
([1/1] CAD Page) EFalls Location  150 UTE AVE RIF APT L1 2012 00000739     
([1/1] CAD Page) EChoking Location  451 SILVERHORN DR NC 2012 00000510     
([1/1] CAD Page) ESick Unknown Location  APPLE TREE MHP5033 CORD 335 138 Z2 2012 00000511     
([1/1] CAD Page) FAlarm Location  Colorado State Veterians Nursing Home851 E  5TH ST RIF 2012 00000742     
([1/1] CAD Page) Accident Location  TAUGHENBAUGH STHY 13 ROUNDABOUTRIF 2012 00009976     
([1/1] CAD Page) Accident Location  HARVEY GAP Z2 2012 00000512     
([1/1] CAD Page) EFalls Location  1218 BALLARD AVE SILT 2012 00000513     
([1/1] CAD Page) FBrush Location  RIFLE PD201 E 18TH ST RIF 2012 00000747     
([1/1] CAD Page) EFalls Location  200 S  E AVE NC 2012 00000515     
([1/1] CAD Page) EStabbing Gunshot Location  Green Diamond Cabins1535 MAIN ST 8 Z2 2012 00000517     
([1/1] CAD Page) EAbdominal Location  826 CEDAR DR RIF 2012 00000749     
([1/1] CAD Page) ETrauma with Injury Location  1325 ORCHARD AVE SILT 2012 00000518     
([1/1] CAD Page) EMedical Alarm Location  54 WINCHESTER ST Z3 2012 00000750     
([1/1] CAD Page) EMedical Alarm Location  188 SHOSHONE TRL Z2 2012 00000519     
([1/1] CAD Page) EUnconscious Syncope Location  420 W  26TH ST RIF 2012 00000751     
([1/1] CAD Page) FVehicle Fire Location  32958 RIVER FRONTAGE RD Z2 2012 00000520     
([1/1] CAD Page) EBreathing Difficulty Location  Colorado State Veterians Nursing Home851 E  5TH ST RIF RM 142 2012 00000753     
([1/1] CAD Page) FBrush Location  RIFLE CREEK GOLF COURSE3063 STHY 325 Z2 2012 00000754     
([1/1] CAD Page) Accident Location  109.5 W I70 2012 00000521     
([1/1] CAD Page) FVehicle Fire Location  91 E I70RIF 2012 00000755     
([1/1] CAD Page) EChest Pain Location  1300 CORD 311 Z2 2012 00000522     
([1/1] CAD Page) EBack Pain Location  DSS Rif195 W  14TH ST RIF 2012 00000756     
([1/1] CAD Page) EMental Emotional Psych Location  W  2ND ST WEST RIF 2012 00000757     
([1/1] CAD Page) EMental Emotional Psych Location  1218 BALLARD AVE SILT UNIT TRLR 2012 00000523     
([1/1] CAD Page) Accident Location  TOP OF STEVENS HILL Z2 2012 00000759     
([1/1] CAD Page) FAlarm Location  Wamsley Elementary225 E  30TH ST RIF 2012 00000761     
([1/1] CAD Page) ESeizures Location  241 N 7TH ST NC 2012 00000524     
([1/1] CAD Page) FSmoke Check Location  APPLE TREE MHP5033 CORD 335 Z2 2012 00000525     

Contact: Active911
Agency name: Grand Valley Fire  Protection District
Location: Parachute, CO, United States
Sender: "GCECA@call3n.com" <conf-1484753723@everbridge.net>

{[1/1] CAD Page} 1/1\r\n\r\nFStructure   33 Angelica Cir  Z3     
{[1/1] CAD Page} 1/1\r\n\r\nEDiabetic Location  MESA VISTA ASSISTED LIVING72 SIPPRELLE DR Z3 2012 00000595     
{[1/1] CAD Page} 1/1\r\n\r\nEAbdominal Location  12 W  RIDGE CT Z3 2012 00000594     
{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  190 LIMBERPINE CIR Z3     
{[1/1] CAD Page} 1/1\r\n\r\nAccident Location  67 E I70Z3 2012 00000592     
{[1/1] CAD Page} 1/1\r\n\r\nFSmoke Check BMT Activity Center 398 Arroyo Dr     
{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  30 E  RIDGE CT Z3     
{[1/1] CAD Page} 1/1\r\n\r\nEAssault Parachute PD 222 Grand Valley Way     
{[1/1] CAD Page} 1/1\r\n\r\nEBreathing Difficulty Location  113 W  TAMARACK CIR Z3     
{[1/1] CAD Page} 1/1\r\n\r\nEAllergic Reaction   854 W Battlement Pkwy #P206     
{[1/1] CAD Page} 1/1\r\n\r\nEAbdominal Location  24 TAMARISK TRL Z3 2012 00000584     
{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  557 TAMARISK TRL Z3 2012 00000582     
{[1/1] CAD Page} 1/1\r\n\r\nFStructure Location  2 ST JOHN CIR PARA 2012 00000580     
{[1/1] CAD Page} 1/1\r\n\r\nEMedical Alarm Location  440 N PARACHUTE AVE PARA     
{[1/2] CAD Page} 1/1\r\n\r\nEGynecology Childbirth Location  Cottonwood View Apt Homes200 COLORADO AVE 8205 PARA 2012 00000578
{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  100 JUNIPER LN Z3 2012 00000577     
{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  Mesa Vista Assisted Living72 SIPPRELLE DR 6 Z3     
{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  5 CRESTONE PL Z3 2012 00000574     
{[1/1] CAD Page} 1/1\r\n\r\nAccident Location  75 W I70PARA 2012 00000573     
{[1/1] CAD Page} 1/1\r\n\r\nESeizures Location  71 SIPPRELLE DR Z3 2012 00000572     
{[1/1] CAD Page} 1/1\r\n\r\nEAbdominal Location  854 W BATTLEMENT PKWY A105 Z3     
{[1/1] CAD Page} 1/1\r\n\r\nFVehicle Fire Location  81 W I70Z3 2012 00000569     
{[1/1] CAD Page} 1/1\r\n\r\nEChest Pain Location  Stallion Oilfield Services16605 USHY 6 Z3 2012 00000568     
{[1/1] CAD Page} 1/1\r\n\r\nFAlarm Location  854 W BATTLEMENT PKWY G208 Z3 2012 00000567     
{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  Mesa Vista Assisted Living72 SIPPRELLE DR 6 Z3

 */
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
        "MADDR:CHAIR BAR RD & COUNTY ROAD 331",  // Can't find CHAIR BAR RD
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
        "MADDR:S & JOLLEY MESA",
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
        "PLACE:TAUGHENBAUGH",
        "ADDR:STHY 13 ROUNDABOUT",
        "MADDR:CO 13 ROUNDABOUT",
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
        "PLACE:RIFLE PD",
        "ADDR:201 E 18TH ST",
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
        "ADDR:851 E 5TH ST",
        "CITY:RIFLE",
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
        "ADDR:1218 BALLARD AVE",
        "CITY:SILT",
        "APT:TRLR",
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
  
  @Test
  public void testGrandValleyFire() {

    doTest("T1",
        "{[1/1] CAD Page} 1/1\r\n\r\nFStructure   33 Angelica Cir  Z3     ",
        "CALL:FStructure",
        "ADDR:33 Angelica Cir",
        "MAP:Z3");

    doTest("T2",
        "{[1/1] CAD Page} 1/1\r\n\r\nEDiabetic Location  MESA VISTA ASSISTED LIVING72 SIPPRELLE DR Z3 2012 00000595     ",
        "CALL:EDiabetic",
        "PLACE:MESA VISTA ASSISTED LIVING",
        "ADDR:72 SIPPRELLE DR",
        "MAP:Z3",
        "ID:2012 00000595");

    doTest("T3",
        "{[1/1] CAD Page} 1/1\r\n\r\nEAbdominal Location  12 W  RIDGE CT Z3 2012 00000594     ",
        "CALL:EAbdominal",
        "ADDR:12 W RIDGE CT",
        "MAP:Z3",
        "ID:2012 00000594");

    doTest("T4",
        "{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  190 LIMBERPINE CIR Z3     ",
        "CALL:ESick Unknown",
        "ADDR:190 LIMBERPINE CIR",
        "MAP:Z3");

    doTest("T5",
        "{[1/1] CAD Page} 1/1\r\n\r\nAccident Location  67 E I70Z3 2012 00000592     ",
        "CALL:Accident",
        "ADDR:67 E I70",
        "MADDR:67 E I 70",
        "MAP:Z3",
        "ID:2012 00000592");

    doTest("T6",
        "{[1/1] CAD Page} 1/1\r\n\r\nFSmoke Check BMT Activity Center 398 Arroyo Dr     ",
        "CALL:FSmoke Check",
        "PLACE:BMT Activity Center",
        "ADDR:398 Arroyo Dr");

    doTest("T7",
        "{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  30 E  RIDGE CT Z3     ",
        "CALL:ESick Unknown",
        "ADDR:30 E RIDGE CT",
        "MAP:Z3");

    doTest("T8",
        "{[1/1] CAD Page} 1/1\r\n\r\nEAssault Parachute PD 222 Grand Valley Way     ",
        "CALL:EAssault",
        "PLACE:Parachute PD",
        "ADDR:222 Grand Valley Way");

    doTest("T9",
        "{[1/1] CAD Page} 1/1\r\n\r\nEBreathing Difficulty Location  113 W  TAMARACK CIR Z3     ",
        "CALL:EBreathing Difficulty",
        "ADDR:113 W TAMARACK CIR",
        "MAP:Z3");

    doTest("T10",
        "{[1/1] CAD Page} 1/1\r\n\r\nEAllergic Reaction   854 W Battlement Pkwy #P206     ",
        "CALL:EAllergic Reaction ",
        "ADDR:854 W Battlement Pkwy",
        "APT:P206");

    doTest("T11",
        "{[1/1] CAD Page} 1/1\r\n\r\nEAbdominal Location  24 TAMARISK TRL Z3 2012 00000584     ",
        "CALL:EAbdominal",
        "ADDR:24 TAMARISK TRL",
        "MAP:Z3",
        "ID:2012 00000584");

    doTest("T12",
        "{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  557 TAMARISK TRL Z3 2012 00000582     ",
        "CALL:ESick Unknown",
        "ADDR:557 TAMARISK TRL",
        "MAP:Z3",
        "ID:2012 00000582");

    doTest("T13",
        "{[1/1] CAD Page} 1/1\r\n\r\nFStructure Location  2 ST JOHN CIR PARA 2012 00000580     ",
        "CALL:FStructure",
        "ADDR:2 ST JOHN CIR",
        "CITY:PARACHUTE",
        "ID:2012 00000580");

    doTest("T14",
        "{[1/1] CAD Page} 1/1\r\n\r\nEMedical Alarm Location  440 N PARACHUTE AVE PARA     ",
        "CALL:EMedical Alarm",
        "ADDR:440 N PARACHUTE AVE",
        "CITY:PARACHUTE");

    doTest("T15",
        "{[1/2] CAD Page} 1/1\r\n\r\nEGynecology Childbirth Location  Cottonwood View Apt Homes200 COLORADO AVE 8205 PARA 2012 00000578",
        "CALL:EGynecology Childbirth",
        "PLACE:Cottonwood View Apt Homes",
        "ADDR:200 COLORADO AVE 8205",
        "CITY:PARACHUTE",
        "ID:2012 00000578");

    doTest("T16",
        "{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  100 JUNIPER LN Z3 2012 00000577     ",
        "CALL:ESick Unknown",
        "ADDR:100 JUNIPER LN",
        "MAP:Z3",
        "ID:2012 00000577");

    doTest("T17",
        "{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  Mesa Vista Assisted Living72 SIPPRELLE DR 6 Z3     ",
        "CALL:ESick Unknown",
        "PLACE:Mesa Vista Assisted Living",
        "ADDR:72 SIPPRELLE DR 6",
        "MAP:Z3");

    doTest("T18",
        "{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  5 CRESTONE PL Z3 2012 00000574     ",
        "CALL:ESick Unknown",
        "ADDR:5 CRESTONE PL",
        "MAP:Z3",
        "ID:2012 00000574");

    doTest("T19",
        "{[1/1] CAD Page} 1/1\r\n\r\nAccident Location  75 W I70PARA 2012 00000573     ",
        "CALL:Accident",
        "ADDR:75 W I70",
        "MADDR:75 W I 70",
        "CITY:PARACHUTE",
        "ID:2012 00000573");

    doTest("T20",
        "{[1/1] CAD Page} 1/1\r\n\r\nESeizures Location  71 SIPPRELLE DR Z3 2012 00000572     ",
        "CALL:ESeizures",
        "ADDR:71 SIPPRELLE DR",
        "MAP:Z3",
        "ID:2012 00000572");

    doTest("T21",
        "{[1/1] CAD Page} 1/1\r\n\r\nEAbdominal Location  854 W BATTLEMENT PKWY A105 Z3     ",
        "CALL:EAbdominal",
        "ADDR:854 W BATTLEMENT PKWY A105",
        "MAP:Z3");

    doTest("T22",
        "{[1/1] CAD Page} 1/1\r\n\r\nFVehicle Fire Location  81 W I70Z3 2012 00000569     ",
        "CALL:FVehicle Fire",
        "ADDR:81 W I70",
        "MADDR:81 W I 70",
        "MAP:Z3",
        "ID:2012 00000569");

    doTest("T23",
        "{[1/1] CAD Page} 1/1\r\n\r\nEChest Pain Location  Stallion Oilfield Services16605 USHY 6 Z3 2012 00000568     ",
        "CALL:EChest Pain",
        "PLACE:Stallion Oilfield Services",
        "ADDR:16605 USHY 6",
        "MADDR:16605 US 6",
        "MAP:Z3",
        "ID:2012 00000568");

    doTest("T24",
        "{[1/1] CAD Page} 1/1\r\n\r\nFAlarm Location  854 W BATTLEMENT PKWY G208 Z3 2012 00000567     ",
        "CALL:FAlarm",
        "ADDR:854 W BATTLEMENT PKWY G208",
        "MAP:Z3",
        "ID:2012 00000567");

    doTest("T25",
        "{[1/1] CAD Page} 1/1\r\n\r\nESick Unknown Location  Mesa Vista Assisted Living72 SIPPRELLE DR 6 Z3",
        "CALL:ESick Unknown",
        "PLACE:Mesa Vista Assisted Living",
        "ADDR:72 SIPPRELLE DR 6",
        "MAP:Z3");
  
  }
  
  public static void main(String[] args) {
    new COGarfieldCountyParserTest().generateTests("T1");
  }
}