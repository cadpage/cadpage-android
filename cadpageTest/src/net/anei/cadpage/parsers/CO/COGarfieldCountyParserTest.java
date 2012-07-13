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
        "ADDR:APPLE TREE MHP5033 CORD 335",
        "MADDR:APPLE TREE MHP5033 COUNTY ROAD 335",
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
  
  public static void main(String[] args) {
    new COGarfieldCountyParserTest().generateTests("T1", "CALL PLACE ADDR APT CITY MAP ID");
  }
}