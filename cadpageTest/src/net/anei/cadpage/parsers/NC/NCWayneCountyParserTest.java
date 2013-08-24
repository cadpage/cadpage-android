package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Wayne County, NC
Contact: Active911
Agency name: Dudley Volunteer Fire Dept 
Location: Dudley, NC, United States
Sender: CC_Message_Notification@usamobility.net

RT:Structure Fire  Loc:390 OUTLAW RD, DUDLEY (BYRD RD/GLENNERROR RD) [91]
RT:Grass Fire  Loc:101 POANDL PL, DUDLEY (/BARNWELL RD) [90]
RT:Structure Fire  Loc:104 APPLEVIEW DR, MOUNT OLIVE (/INDIAN SPRINGS RD, DAVIS RD) [89]
RT:Unknown Fire Call  Loc:219 ODOM FARM RD, DUDLEY (COLBY DR/HIDE AWAY CIR) [87]
RT:Fire Alarm  Loc:110 CONNIES WALK, DUDLEY (HOPESWAY DR/) [86]
RT:Smoke Investigation  Loc:800 S BREAZEALE AV, MOUNT OLIVE [85]
RT:Fire Alarm  Loc:4255 S US 117 ALT HWY, DUDLEY [84]
RT:Unknown Fire Call  Loc:1805 ARRINGTON BRIDGE RD, DUDLEY (EMMAUS CHURCH RD/BILL LANEBLVD) [83]
RT:Structure Fire  Loc:201 SYDNEY DR, DUDLEY (ARROW HEAD LN/BEAR TRAP DR) [81]
RT:Fire Alarm  Loc:494 ARRINGTON BRIDGE RD, GOLDSBORO (WESTBROOK RD/S JOHN ST; Near:UCHIYAMA AMERICA, INC.) [80]
RT:Smoke Investigation  Loc:112 EVERITTSVILLE RD, DUDLEY (/COLONEL WARRICK RD) [78]
RT:Traffic Accident-Inj  Loc:218 BREWINGTON DR, DUDLEY (EMMAUS CHURCH RD/RUSKIN RD) [77]
RT:Grass Fire  Loc:1073 EMMAUS CHURCH RD, DUDLEY (TURNAGE LN/LIPSCOMB LN) [75]
RT:Smoke Investigation  Loc:129 SHEPHERD LN, MOUNT OLIVE (/COUNTRY CLUB RD) [74]
RT:Traffic Accident-Inj  Loc:S US 117 HWY, DUDLEY/COUNTRY CLUB RD, MOUNT OLIVE [73]
RT:Traffic Accident-Inj  Loc:ARRINGTON BRIDGE RD, DUDLEY/PECAN RD, DUDLEY [72]
RT:Structure Fire  Loc:426 E HILLSBORO ST, MOUNT OLIVE (COBB ST/S JOHNSON ST) [71]
RT:Vehicle Fire  Loc:102 VAN DYKE LN, DUDLEY (DARLENE DR/) [70]
RT:Electrical Short  Loc:1604 GENOA RD, DUDLEY (OUTLAW RD/ERIK DR) [69]
RT:Traffic Accident-Inj  Loc:S US 117 HWY, DUDLEY/COUNTRY CLUB RD, MOUNT OLIVE [68]
RT:Fire Alarm  Loc:127 HOPE BLVD, DUDLEY (/SPRING DR) [67]
RT:Structure Fire  Loc:218 E WILLIAMSON ST, MOUNT OLIVE (S JOHNSON ST/S CHURCH ST) [66]
RT:Vehicle Fire  Loc:1606 E NC 55 HWY, MOUNT OLIVE (NC 403 HWY, PINEVIEW CEMETERY RD/STANLEY CHAPEL CHURCH RD) [64]
RT:Structure Fire  Loc:119 E POLLOCK ST, MOUNT OLIVE (S CHURCH ST/S CENTER ST, W POLLOCK ST) [62]
RT:Traffic Accident-Inj  Loc:239 OBERRY RD, DUDLEY (ST MATTHEWS RD/SOUTHWEST CIR) [60]
RT:Structure Fire  Loc:1564 OLD MT OLIVE HWY, DUDLEY (BURKE ST/HOLLOMAN LN) [58]
RT:Structure Fire  Loc:311 S US 13 HWY, DUDLEY (WOODLAND CHURCH RD, DURHAM LAKE RD/WALDROP RD) [57]
RT:Fire Alarm  Loc:628 DURHAM LAKE RD, DUDLEY (FORD ST/SUNDANCE TRL) [55]
RT:Structure Fire  Loc:121 GAINEY DR, GOLDSBORO (SANDHILL DR/US 13 HWY) [54]
RT:Field Fire  Loc:111 FOREST [53]
RT:Grass Fire  Loc:208 ROLLINGWOOD DR, DUDLEY (BRENTWOOD DR/ROLLINGWOOD CT) [52]
RT:Structure Fire  Loc:1280 DURHAM LAKE RD, DUDLEY (LOREASE DR/S LANDFILL RD) [51]
RT:Traffic Accident-Inj  Loc:ALERT CABLE RD, DUDLEY/US 117 ALT, DUDLEY [50]
RT:Fire Alarm  Loc:330 PECAN RD, DUDLEY (MITCHELL RD/ARRINGTON BRIDGE RD; Near:CASE FARMS) [49]
RT:Structure Fire  Loc:134 PINELAND AVE, MOUNT OLIVE (/SERVICE RD) [47]
RT:Fire Alarm  Loc:213 N CHESTNUT ST, MOUNT OLIVE (W JOHN ST/W JAMES ST) [46]
RT:Structure Fire  Loc:202 GAINEY DR, GOLDSBORO (WILDWOOD DR/SANDHILL DR) [45]
RT:Agricultural Building Fire  Loc:SLEEPY CREEK RD, DUDLEY/ARRINGTON BRIDGE RD, DUDLEY [44]
RT:Traffic Accident-Inj  Loc:US 117 ALT (US 117 ALT), DUDLEY/WALTER FULCHER RD, DUDLEY [42]
RT:Traffic Accident-Inj  Loc:124 WALTER FULCHER RD, DUDLEY (OLD MT OLIVE HWY/US 117 ALT; Near:SOUTHERN WAYNE HIGH) [40]
RT:Fire Alarm  Loc:202 GAINEY DR, GOLDSBORO (WILDWOOD DR/SANDHILL DR) [38]
RT:Fire Other  Loc:334 OUTLAW RD, DUDLEY (GLENNERROR RD/LORIE CT) [37]
RT:Grass Fire  Loc:336 BRENTWOOD DR, DUDLEY (/PARKER PL) [36]
RT:Fire Alarm  Loc:712 S US 13 HWY, GOLDSBORO (COUNTRY RUNLN/SANDHILL DR,) [35]
RT:Traffic Accident-Inj  Loc:ems station [34]
RT:Structure Fire  Loc:6002 MEADOW LN, GOLDSBORO (COMET DR/BRIGHTLEAF RD) [33]
RT:Grass Fire  Loc:102 EDINBUROUGH LN, DUDLEY (/HERRING RD) [32]
RT:Grass Fire  Loc:109 COLONEL WARRICK RD, DUDLEY (S EVERITTSVILLE PL, N EVERITTSVILLE PL/EVERITTSVILLE RD) [31]
RT:Traffic Accident-Inj  Loc:@BROGDEN PRIMARY  (2253 OLD MOUNT OLIVE HWY) [29]
RT:Smoke Investigation  Loc:705 GENOA RD, DUDLEY (MOBILE CIR/PECAN RD) [28]
RT:Fire Alarm  Loc:714 SANDHILL DR, DUDLEY (PINEGROVE LN/COUNTRY RUNLN) [27]
RT:Structure Fire  Loc:1087 GENOA RD, DUDLEY (CARRAWAY CREEK DR/MOBILE CIR) [26]
RT:Fire Alarm  Loc:105 FOXCROFT LN, MOUNT OLIVE (/HERMITAGE LN) [25]
RT:Seizures  Loc:1599 GENOA RD, DUDLEY (ERIK DR/ROBIN LAKE DR) [24]
RT:Structure Fire  Loc:296 SLEEPY CREEK RD, DUDLEY (RUSKIN RD/BOSEMAN LN) [23]
RT:Assist EMS  Loc:OBERRY RD, DUDLEY/US 117 ALT, DUDLEY [22]
RT:Woods Fire  Loc:105 ANNIES AVE, DUDLEY (/POTTS RD) [21]
RT:Structure Fire  Loc:457 FRANKLIN ST, MOUNT OLIVE (OLIVER ST/S JOHNSON ST) [20]
RT:Fire Alarm  Loc:330 PECAN RD, DUDLEY (MITCHELL RD/ARRINGTON BRIDGE RD; Near:CASE FARMS) [19]
RT:Electrical Short  Loc:6009 MEADOW LN, GOLDSBORO (COMET DR/BRIGHTLEAF RD) [17]
RT:Structure Fire  Loc:2882 OLD MT OLIVE HWY, DUDLEY (PARKER RD/WALTER FULCHER RD) [16]
RT:Structure Fire  Loc:206 s jeffersopn st [14]
RT:Structure Fire  Loc:729 MASSEY RD, DUDLEY (HERRING RD/OBERRY RD) [13]
RT:Structure Fire  Loc:1273 N BREAZEALE AVE, MOUNT OLIVE (NORTHEAST CHURCH RD/NO RTHPOINT DR) [12]
RT:Structure Fire  Loc:779 RUSKIN RD, DUDLEY (MAXFIELD DR/SLEEPY CREEK RD) [10]
RT:Structure Fire  Loc:105 GARNER CT, MOUNT OLIVE (/LEES COUNTRY CLUB RD) [09]
RT:Structure Fire  Loc:116 SHADY NOOK CIR, DUDLEY (US 117 ALT/) [07]
RT:Fire Alarm  Loc:330 PECAN RD, DUDLEY (MITCHELL RD/ARRINGTON BRIDGE RD) [06]
RT:Traffic Accident-Inj  Loc:COUNTRY CLUB DR, MOUNT OLIVE/US 117 ALT (US 117 ALT), MOUNT OLIVE [04]
RT:Gas Leak  Loc:1130 N BREAZEALE AVE, MOUNT OLIVE (TADLOCK RD, DAVIS ST/NC 55 HWY, NC 55 HWY) [02]
RT:Traffic Accident-Inj  Loc:3846 US 117 ALT (US 117 ALT), DUDLEY (SANDRA LN/ALPINE LN) [99]
RT:Carbon Monoxide Alarm  Loc:185 LEGION LAKE DR, DUDLEY [97]

*/

public class NCWayneCountyParserTest extends BaseParserTest {
  
  public NCWayneCountyParserTest() {
    setParser(new NCWayneCountyParser(), "WAYNE COUNTY", "NC");
  }
  
  @Test
  public void testDudleyFire() {

    doTest("T1",
        "RT:Structure Fire  Loc:390 OUTLAW RD, DUDLEY (BYRD RD/GLENNERROR RD) [91]",
        "CALL:Structure Fire",
        "ADDR:390 OUTLAW RD",
        "CITY:DUDLEY",
        "X:BYRD RD/GLENNERROR RD");

    doTest("T2",
        "RT:Grass Fire  Loc:101 POANDL PL, DUDLEY (/BARNWELL RD) [90]",
        "CALL:Grass Fire",
        "ADDR:101 POANDL PL",
        "CITY:DUDLEY",
        "X:BARNWELL RD");

    doTest("T3",
        "RT:Structure Fire  Loc:104 APPLEVIEW DR, MOUNT OLIVE (/INDIAN SPRINGS RD, DAVIS RD) [89]",
        "CALL:Structure Fire",
        "ADDR:104 APPLEVIEW DR",
        "CITY:MOUNT OLIVE",
        "X:INDIAN SPRINGS RD, DAVIS RD");

    doTest("T4",
        "RT:Unknown Fire Call  Loc:219 ODOM FARM RD, DUDLEY (COLBY DR/HIDE AWAY CIR) [87]",
        "CALL:Unknown Fire Call",
        "ADDR:219 ODOM FARM RD",
        "CITY:DUDLEY",
        "X:COLBY DR/HIDE AWAY CIR");

    doTest("T5",
        "RT:Fire Alarm  Loc:110 CONNIES WALK, DUDLEY (HOPESWAY DR/) [86]",
        "CALL:Fire Alarm",
        "ADDR:110 CONNIES WALK",
        "CITY:DUDLEY",
        "X:HOPESWAY DR");

    doTest("T6",
        "RT:Smoke Investigation  Loc:800 S BREAZEALE AV, MOUNT OLIVE [85]",
        "CALL:Smoke Investigation",
        "ADDR:800 S BREAZEALE AV",
        "MADDR:800 S BREAZEALE AVE",
        "CITY:MOUNT OLIVE");

    doTest("T7",
        "RT:Fire Alarm  Loc:4255 S US 117 ALT HWY, DUDLEY [84]",
        "CALL:Fire Alarm",
        "ADDR:4255 S US 117 ALT HWY",
        "CITY:DUDLEY");

    doTest("T8",
        "RT:Unknown Fire Call  Loc:1805 ARRINGTON BRIDGE RD, DUDLEY (EMMAUS CHURCH RD/BILL LANEBLVD) [83]",
        "CALL:Unknown Fire Call",
        "ADDR:1805 ARRINGTON BRIDGE RD",
        "CITY:DUDLEY",
        "X:EMMAUS CHURCH RD/BILL LANEBLVD");

    doTest("T9",
        "RT:Structure Fire  Loc:201 SYDNEY DR, DUDLEY (ARROW HEAD LN/BEAR TRAP DR) [81]",
        "CALL:Structure Fire",
        "ADDR:201 SYDNEY DR",
        "CITY:DUDLEY",
        "X:ARROW HEAD LN/BEAR TRAP DR");

    doTest("T10",
        "RT:Fire Alarm  Loc:494 ARRINGTON BRIDGE RD, GOLDSBORO (WESTBROOK RD/S JOHN ST; Near:UCHIYAMA AMERICA, INC.) [80]",
        "CALL:Fire Alarm",
        "ADDR:494 ARRINGTON BRIDGE RD",
        "CITY:GOLDSBORO",
        "X:WESTBROOK RD/S JOHN ST",
        "INFO:Near:UCHIYAMA AMERICA, INC.");

    doTest("T11",
        "RT:Smoke Investigation  Loc:112 EVERITTSVILLE RD, DUDLEY (/COLONEL WARRICK RD) [78]",
        "CALL:Smoke Investigation",
        "ADDR:112 EVERITTSVILLE RD",
        "CITY:DUDLEY",
        "X:COLONEL WARRICK RD");

    doTest("T12",
        "RT:Traffic Accident-Inj  Loc:218 BREWINGTON DR, DUDLEY (EMMAUS CHURCH RD/RUSKIN RD) [77]",
        "CALL:Traffic Accident-Inj",
        "ADDR:218 BREWINGTON DR",
        "CITY:DUDLEY",
        "X:EMMAUS CHURCH RD/RUSKIN RD");

    doTest("T13",
        "RT:Grass Fire  Loc:1073 EMMAUS CHURCH RD, DUDLEY (TURNAGE LN/LIPSCOMB LN) [75]",
        "CALL:Grass Fire",
        "ADDR:1073 EMMAUS CHURCH RD",
        "CITY:DUDLEY",
        "X:TURNAGE LN/LIPSCOMB LN");

    doTest("T14",
        "RT:Smoke Investigation  Loc:129 SHEPHERD LN, MOUNT OLIVE (/COUNTRY CLUB RD) [74]",
        "CALL:Smoke Investigation",
        "ADDR:129 SHEPHERD LN",
        "CITY:MOUNT OLIVE",
        "X:COUNTRY CLUB RD");

    doTest("T15",
        "RT:Traffic Accident-Inj  Loc:S US 117 HWY, DUDLEY/COUNTRY CLUB RD, MOUNT OLIVE [73]",
        "CALL:Traffic Accident-Inj",
        "ADDR:S US 117 HWY & COUNTRY CLUB RD",
        "MADDR:S US 117 & COUNTRY CLUB RD",
        "CITY:DUDLEY");

    doTest("T16",
        "RT:Traffic Accident-Inj  Loc:ARRINGTON BRIDGE RD, DUDLEY/PECAN RD, DUDLEY [72]",
        "CALL:Traffic Accident-Inj",
        "ADDR:ARRINGTON BRIDGE RD & PECAN RD",
        "CITY:DUDLEY");

    doTest("T17",
        "RT:Structure Fire  Loc:426 E HILLSBORO ST, MOUNT OLIVE (COBB ST/S JOHNSON ST) [71]",
        "CALL:Structure Fire",
        "ADDR:426 E HILLSBORO ST",
        "CITY:MOUNT OLIVE",
        "X:COBB ST/S JOHNSON ST");

    doTest("T18",
        "RT:Vehicle Fire  Loc:102 VAN DYKE LN, DUDLEY (DARLENE DR/) [70]",
        "CALL:Vehicle Fire",
        "ADDR:102 VAN DYKE LN",
        "CITY:DUDLEY",
        "X:DARLENE DR");

    doTest("T19",
        "RT:Electrical Short  Loc:1604 GENOA RD, DUDLEY (OUTLAW RD/ERIK DR) [69]",
        "CALL:Electrical Short",
        "ADDR:1604 GENOA RD",
        "CITY:DUDLEY",
        "X:OUTLAW RD/ERIK DR");

    doTest("T20",
        "RT:Traffic Accident-Inj  Loc:S US 117 HWY, DUDLEY/COUNTRY CLUB RD, MOUNT OLIVE [68]",
        "CALL:Traffic Accident-Inj",
        "ADDR:S US 117 HWY & COUNTRY CLUB RD",
        "MADDR:S US 117 & COUNTRY CLUB RD",
        "CITY:DUDLEY");

    doTest("T21",
        "RT:Fire Alarm  Loc:127 HOPE BLVD, DUDLEY (/SPRING DR) [67]",
        "CALL:Fire Alarm",
        "ADDR:127 HOPE BLVD",
        "CITY:DUDLEY",
        "X:SPRING DR");

    doTest("T22",
        "RT:Structure Fire  Loc:218 E WILLIAMSON ST, MOUNT OLIVE (S JOHNSON ST/S CHURCH ST) [66]",
        "CALL:Structure Fire",
        "ADDR:218 E WILLIAMSON ST",
        "CITY:MOUNT OLIVE",
        "X:S JOHNSON ST/S CHURCH ST");

    doTest("T23",
        "RT:Vehicle Fire  Loc:1606 E NC 55 HWY, MOUNT OLIVE (NC 403 HWY, PINEVIEW CEMETERY RD/STANLEY CHAPEL CHURCH RD) [64]",
        "CALL:Vehicle Fire",
        "ADDR:1606 E NC 55 HWY",
        "MADDR:1606 E STATE 55",
        "CITY:MOUNT OLIVE",
        "X:NC 403 HWY, PINEVIEW CEMETERY RD/STANLEY CHAPEL CHURCH RD");

    doTest("T24",
        "RT:Structure Fire  Loc:119 E POLLOCK ST, MOUNT OLIVE (S CHURCH ST/S CENTER ST, W POLLOCK ST) [62]",
        "CALL:Structure Fire",
        "ADDR:119 E POLLOCK ST",
        "CITY:MOUNT OLIVE",
        "X:S CHURCH ST/S CENTER ST, W POLLOCK ST");

    doTest("T25",
        "RT:Traffic Accident-Inj  Loc:239 OBERRY RD, DUDLEY (ST MATTHEWS RD/SOUTHWEST CIR) [60]",
        "CALL:Traffic Accident-Inj",
        "ADDR:239 OBERRY RD",
        "CITY:DUDLEY",
        "X:ST MATTHEWS RD/SOUTHWEST CIR");

    doTest("T26",
        "RT:Structure Fire  Loc:1564 OLD MT OLIVE HWY, DUDLEY (BURKE ST/HOLLOMAN LN) [58]",
        "CALL:Structure Fire",
        "ADDR:1564 OLD MT OLIVE HWY",
        "CITY:DUDLEY",
        "X:BURKE ST/HOLLOMAN LN");

    doTest("T27",
        "RT:Structure Fire  Loc:311 S US 13 HWY, DUDLEY (WOODLAND CHURCH RD, DURHAM LAKE RD/WALDROP RD) [57]",
        "CALL:Structure Fire",
        "ADDR:311 S US 13 HWY",
        "MADDR:311 S US 13",
        "CITY:DUDLEY",
        "X:WOODLAND CHURCH RD, DURHAM LAKE RD/WALDROP RD");

    doTest("T28",
        "RT:Fire Alarm  Loc:628 DURHAM LAKE RD, DUDLEY (FORD ST/SUNDANCE TRL) [55]",
        "CALL:Fire Alarm",
        "ADDR:628 DURHAM LAKE RD",
        "CITY:DUDLEY",
        "X:FORD ST/SUNDANCE TRL");

    doTest("T29",
        "RT:Structure Fire  Loc:121 GAINEY DR, GOLDSBORO (SANDHILL DR/US 13 HWY) [54]",
        "CALL:Structure Fire",
        "ADDR:121 GAINEY DR",
        "CITY:GOLDSBORO",
        "X:SANDHILL DR/US 13 HWY");

    doTest("T30",
        "RT:Field Fire  Loc:111 FOREST [53]",
        "CALL:Field Fire",
        "ADDR:111 FOREST");

    doTest("T31",
        "RT:Grass Fire  Loc:208 ROLLINGWOOD DR, DUDLEY (BRENTWOOD DR/ROLLINGWOOD CT) [52]",
        "CALL:Grass Fire",
        "ADDR:208 ROLLINGWOOD DR",
        "CITY:DUDLEY",
        "X:BRENTWOOD DR/ROLLINGWOOD CT");

    doTest("T32",
        "RT:Structure Fire  Loc:1280 DURHAM LAKE RD, DUDLEY (LOREASE DR/S LANDFILL RD) [51]",
        "CALL:Structure Fire",
        "ADDR:1280 DURHAM LAKE RD",
        "CITY:DUDLEY",
        "X:LOREASE DR/S LANDFILL RD");

    doTest("T33",
        "RT:Traffic Accident-Inj  Loc:ALERT CABLE RD, DUDLEY/US 117 ALT, DUDLEY [50]",
        "CALL:Traffic Accident-Inj",
        "ADDR:ALERT CABLE RD & US 117 ALT",
        "CITY:DUDLEY");

    doTest("T34",
        "RT:Fire Alarm  Loc:330 PECAN RD, DUDLEY (MITCHELL RD/ARRINGTON BRIDGE RD; Near:CASE FARMS) [49]",
        "CALL:Fire Alarm",
        "ADDR:330 PECAN RD",
        "CITY:DUDLEY",
        "X:MITCHELL RD/ARRINGTON BRIDGE RD",
        "INFO:Near:CASE FARMS");

    doTest("T35",
        "RT:Structure Fire  Loc:134 PINELAND AVE, MOUNT OLIVE (/SERVICE RD) [47]",
        "CALL:Structure Fire",
        "ADDR:134 PINELAND AVE",
        "CITY:MOUNT OLIVE",
        "X:SERVICE RD");

    doTest("T36",
        "RT:Fire Alarm  Loc:213 N CHESTNUT ST, MOUNT OLIVE (W JOHN ST/W JAMES ST) [46]",
        "CALL:Fire Alarm",
        "ADDR:213 N CHESTNUT ST",
        "CITY:MOUNT OLIVE",
        "X:W JOHN ST/W JAMES ST");

    doTest("T37",
        "RT:Structure Fire  Loc:202 GAINEY DR, GOLDSBORO (WILDWOOD DR/SANDHILL DR) [45]",
        "CALL:Structure Fire",
        "ADDR:202 GAINEY DR",
        "CITY:GOLDSBORO",
        "X:WILDWOOD DR/SANDHILL DR");

    doTest("T38",
        "RT:Agricultural Building Fire  Loc:SLEEPY CREEK RD, DUDLEY/ARRINGTON BRIDGE RD, DUDLEY [44]",
        "CALL:Agricultural Building Fire",
        "ADDR:SLEEPY CREEK RD & ARRINGTON BRIDGE RD",
        "CITY:DUDLEY");

    doTest("T39",
        "RT:Traffic Accident-Inj  Loc:US 117 ALT (US 117 ALT), DUDLEY/WALTER FULCHER RD, DUDLEY [42]",
        "CALL:Traffic Accident-Inj",
        "ADDR:US 117 ALT (US 117 ALT) & WALTER FULCHER RD",
        "MADDR:US 117 ALT & WALTER FULCHER RD",
        "CITY:DUDLEY");

    doTest("T40",
        "RT:Traffic Accident-Inj  Loc:124 WALTER FULCHER RD, DUDLEY (OLD MT OLIVE HWY/US 117 ALT; Near:SOUTHERN WAYNE HIGH) [40]",
        "CALL:Traffic Accident-Inj",
        "ADDR:124 WALTER FULCHER RD",
        "CITY:DUDLEY",
        "X:OLD MT OLIVE HWY/US 117 ALT",
        "INFO:Near:SOUTHERN WAYNE HIGH");

    doTest("T41",
        "RT:Fire Alarm  Loc:202 GAINEY DR, GOLDSBORO (WILDWOOD DR/SANDHILL DR) [38]",
        "CALL:Fire Alarm",
        "ADDR:202 GAINEY DR",
        "CITY:GOLDSBORO",
        "X:WILDWOOD DR/SANDHILL DR");

    doTest("T42",
        "RT:Fire Other  Loc:334 OUTLAW RD, DUDLEY (GLENNERROR RD/LORIE CT) [37]",
        "CALL:Fire Other",
        "ADDR:334 OUTLAW RD",
        "CITY:DUDLEY",
        "X:GLENNERROR RD/LORIE CT");

    doTest("T43",
        "RT:Grass Fire  Loc:336 BRENTWOOD DR, DUDLEY (/PARKER PL) [36]",
        "CALL:Grass Fire",
        "ADDR:336 BRENTWOOD DR",
        "CITY:DUDLEY",
        "X:PARKER PL");

    doTest("T44",
        "RT:Fire Alarm  Loc:712 S US 13 HWY, GOLDSBORO (COUNTRY RUNLN/SANDHILL DR,) [35]",
        "CALL:Fire Alarm",
        "ADDR:712 S US 13 HWY",
        "MADDR:712 S US 13",
        "CITY:GOLDSBORO",
        "X:COUNTRY RUNLN/SANDHILL DR");

    doTest("T45",
        "RT:Traffic Accident-Inj  Loc:ems station [34]",
        "CALL:Traffic Accident-Inj",
        "ADDR:ems station");

    doTest("T46",
        "RT:Structure Fire  Loc:6002 MEADOW LN, GOLDSBORO (COMET DR/BRIGHTLEAF RD) [33]",
        "CALL:Structure Fire",
        "ADDR:6002 MEADOW LN",
        "CITY:GOLDSBORO",
        "X:COMET DR/BRIGHTLEAF RD");

    doTest("T47",
        "RT:Grass Fire  Loc:102 EDINBUROUGH LN, DUDLEY (/HERRING RD) [32]",
        "CALL:Grass Fire",
        "ADDR:102 EDINBUROUGH LN",
        "CITY:DUDLEY",
        "X:HERRING RD");

    doTest("T48",
        "RT:Grass Fire  Loc:109 COLONEL WARRICK RD, DUDLEY (S EVERITTSVILLE PL, N EVERITTSVILLE PL/EVERITTSVILLE RD) [31]",
        "CALL:Grass Fire",
        "ADDR:109 COLONEL WARRICK RD",
        "CITY:DUDLEY",
        "X:S EVERITTSVILLE PL, N EVERITTSVILLE PL/EVERITTSVILLE RD");

    doTest("T49",
        "RT:Traffic Accident-Inj  Loc:@BROGDEN PRIMARY  (2253 OLD MOUNT OLIVE HWY) [29]",
        "CALL:Traffic Accident-Inj",
        "PLACE:BROGDEN PRIMARY",
        "ADDR:2253 OLD MOUNT OLIVE HWY");

    doTest("T50",
        "RT:Smoke Investigation  Loc:705 GENOA RD, DUDLEY (MOBILE CIR/PECAN RD) [28]",
        "CALL:Smoke Investigation",
        "ADDR:705 GENOA RD",
        "CITY:DUDLEY",
        "X:MOBILE CIR/PECAN RD");

    doTest("T51",
        "RT:Fire Alarm  Loc:714 SANDHILL DR, DUDLEY (PINEGROVE LN/COUNTRY RUNLN) [27]",
        "CALL:Fire Alarm",
        "ADDR:714 SANDHILL DR",
        "CITY:DUDLEY",
        "X:PINEGROVE LN/COUNTRY RUNLN");

    doTest("T52",
        "RT:Structure Fire  Loc:1087 GENOA RD, DUDLEY (CARRAWAY CREEK DR/MOBILE CIR) [26]",
        "CALL:Structure Fire",
        "ADDR:1087 GENOA RD",
        "CITY:DUDLEY",
        "X:CARRAWAY CREEK DR/MOBILE CIR");

    doTest("T53",
        "RT:Fire Alarm  Loc:105 FOXCROFT LN, MOUNT OLIVE (/HERMITAGE LN) [25]",
        "CALL:Fire Alarm",
        "ADDR:105 FOXCROFT LN",
        "CITY:MOUNT OLIVE",
        "X:HERMITAGE LN");

    doTest("T54",
        "RT:Seizures  Loc:1599 GENOA RD, DUDLEY (ERIK DR/ROBIN LAKE DR) [24]",
        "CALL:Seizures",
        "ADDR:1599 GENOA RD",
        "CITY:DUDLEY",
        "X:ERIK DR/ROBIN LAKE DR");

    doTest("T55",
        "RT:Structure Fire  Loc:296 SLEEPY CREEK RD, DUDLEY (RUSKIN RD/BOSEMAN LN) [23]",
        "CALL:Structure Fire",
        "ADDR:296 SLEEPY CREEK RD",
        "CITY:DUDLEY",
        "X:RUSKIN RD/BOSEMAN LN");

    doTest("T56",
        "RT:Assist EMS  Loc:OBERRY RD, DUDLEY/US 117 ALT, DUDLEY [22]",
        "CALL:Assist EMS",
        "ADDR:OBERRY RD & US 117 ALT",
        "CITY:DUDLEY");

    doTest("T57",
        "RT:Woods Fire  Loc:105 ANNIES AVE, DUDLEY (/POTTS RD) [21]",
        "CALL:Woods Fire",
        "ADDR:105 ANNIES AVE",
        "CITY:DUDLEY",
        "X:POTTS RD");

    doTest("T58",
        "RT:Structure Fire  Loc:457 FRANKLIN ST, MOUNT OLIVE (OLIVER ST/S JOHNSON ST) [20]",
        "CALL:Structure Fire",
        "ADDR:457 FRANKLIN ST",
        "CITY:MOUNT OLIVE",
        "X:OLIVER ST/S JOHNSON ST");

    doTest("T59",
        "RT:Fire Alarm  Loc:330 PECAN RD, DUDLEY (MITCHELL RD/ARRINGTON BRIDGE RD; Near:CASE FARMS) [19]",
        "CALL:Fire Alarm",
        "ADDR:330 PECAN RD",
        "CITY:DUDLEY",
        "X:MITCHELL RD/ARRINGTON BRIDGE RD",
        "INFO:Near:CASE FARMS");

    doTest("T60",
        "RT:Electrical Short  Loc:6009 MEADOW LN, GOLDSBORO (COMET DR/BRIGHTLEAF RD) [17]",
        "CALL:Electrical Short",
        "ADDR:6009 MEADOW LN",
        "CITY:GOLDSBORO",
        "X:COMET DR/BRIGHTLEAF RD");

    doTest("T61",
        "RT:Structure Fire  Loc:2882 OLD MT OLIVE HWY, DUDLEY (PARKER RD/WALTER FULCHER RD) [16]",
        "CALL:Structure Fire",
        "ADDR:2882 OLD MT OLIVE HWY",
        "CITY:DUDLEY",
        "X:PARKER RD/WALTER FULCHER RD");

    doTest("T62",
        "RT:Structure Fire  Loc:206 s jeffersopn st [14]",
        "CALL:Structure Fire",
        "ADDR:206 s jeffersopn st");

    doTest("T63",
        "RT:Structure Fire  Loc:729 MASSEY RD, DUDLEY (HERRING RD/OBERRY RD) [13]",
        "CALL:Structure Fire",
        "ADDR:729 MASSEY RD",
        "CITY:DUDLEY",
        "X:HERRING RD/OBERRY RD");

    doTest("T64",
        "RT:Structure Fire  Loc:1273 N BREAZEALE AVE, MOUNT OLIVE (NORTHEAST CHURCH RD/NO RTHPOINT DR) [12]",
        "CALL:Structure Fire",
        "ADDR:1273 N BREAZEALE AVE",
        "CITY:MOUNT OLIVE",
        "X:NORTHEAST CHURCH RD/NO RTHPOINT DR");

    doTest("T65",
        "RT:Structure Fire  Loc:779 RUSKIN RD, DUDLEY (MAXFIELD DR/SLEEPY CREEK RD) [10]",
        "CALL:Structure Fire",
        "ADDR:779 RUSKIN RD",
        "CITY:DUDLEY",
        "X:MAXFIELD DR/SLEEPY CREEK RD");

    doTest("T66",
        "RT:Structure Fire  Loc:105 GARNER CT, MOUNT OLIVE (/LEES COUNTRY CLUB RD) [09]",
        "CALL:Structure Fire",
        "ADDR:105 GARNER CT",
        "CITY:MOUNT OLIVE",
        "X:LEES COUNTRY CLUB RD");

    doTest("T67",
        "RT:Structure Fire  Loc:116 SHADY NOOK CIR, DUDLEY (US 117 ALT/) [07]",
        "CALL:Structure Fire",
        "ADDR:116 SHADY NOOK CIR",
        "CITY:DUDLEY",
        "X:US 117 ALT");

    doTest("T68",
        "RT:Fire Alarm  Loc:330 PECAN RD, DUDLEY (MITCHELL RD/ARRINGTON BRIDGE RD) [06]",
        "CALL:Fire Alarm",
        "ADDR:330 PECAN RD",
        "CITY:DUDLEY",
        "X:MITCHELL RD/ARRINGTON BRIDGE RD");

    doTest("T69",
        "RT:Traffic Accident-Inj  Loc:COUNTRY CLUB DR, MOUNT OLIVE/US 117 ALT (US 117 ALT), MOUNT OLIVE [04]",
        "CALL:Traffic Accident-Inj",
        "ADDR:COUNTRY CLUB DR & US 117 ALT (US 117 ALT)",
        "MADDR:COUNTRY CLUB DR & US 117 ALT",
        "CITY:MOUNT OLIVE");

    doTest("T70",
        "RT:Gas Leak  Loc:1130 N BREAZEALE AVE, MOUNT OLIVE (TADLOCK RD, DAVIS ST/NC 55 HWY, NC 55 HWY) [02]",
        "CALL:Gas Leak",
        "ADDR:1130 N BREAZEALE AVE",
        "CITY:MOUNT OLIVE",
        "X:TADLOCK RD, DAVIS ST/NC 55 HWY, NC 55 HWY");

    doTest("T71",
        "RT:Traffic Accident-Inj  Loc:3846 US 117 ALT (US 117 ALT), DUDLEY (SANDRA LN/ALPINE LN) [99]",
        "CALL:Traffic Accident-Inj",
        "ADDR:3846 US 117 ALT (US 117 ALT)",
        "MADDR:3846 US 117 ALT",
        "CITY:DUDLEY",
        "X:SANDRA LN/ALPINE LN");

    doTest("T72",
        "RT:Carbon Monoxide Alarm  Loc:185 LEGION LAKE DR, DUDLEY [97]",
        "CALL:Carbon Monoxide Alarm",
        "ADDR:185 LEGION LAKE DR",
        "CITY:DUDLEY");

  }

  public static void main(String[] args) {
    new NCWayneCountyParserTest().generateTests("T1");
  }
}
