package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.IN.INVigoCountyParser;

import org.junit.Test;


public class INVigoCountyParserTest extends BaseParserTest {
  
  public INVigoCountyParserTest() {
    setParser(new INVigoCountyParser(), "VIGO COUNTY", "IN");
  }
  
  @Test
  public void testBillyRoberts() {

    doTest("T1",
        "Ct:FALL Loc:3301 ST MARY'S RD Apt: XSt:BLOOMTOWN RD US HWY 150 Grid:112D Units:E-42 TC-1 Rmk:92 YOLD FML; FELL; FACE DOWN ON FLOOR -",
        "CALL:FALL",
        "ADDR:3301 ST MARY'S RD",
        "X:BLOOMTOWN RD US HWY 150",
        "MAP:112D",
        "UNIT:E-42 TC-1",
        "INFO:92 YOLD FML; FELL; FACE DOWN ON FLOOR -");
    
    doTest("T2",
        "Ct:FALL Loc:309 N CHURCH ST Apt: XSt:PARIS AV Grid:0WTH Units:E-41 TC-2 Rmk:65 Years F ;fall",
        "CALL:FALL",
        "ADDR:309 N CHURCH ST",
        "X:PARIS AV",
        "MAP:0WTH",
        "UNIT:E-41 TC-2",
        "INFO:65 Years F ;fall");
    
    doTest("T3",
        "Ct:CHEST PAIN Loc:500 W PARIS AV Apt: XSt:6TH ST WTH 4TH ST WTH Grid:0WTH Units:E-41 TC-1 Rmk:",
        "CALL:CHEST PAIN",
        "ADDR:500 W PARIS AV",
        "MADDR:500 W PARIS AVE",
        "X:6TH ST WTH 4TH ST WTH",
        "MAP:0WTH",
        "UNIT:E-41 TC-1");
    
    doTest("T4",
        "Ct:CHOKING Loc:2925 N MAPLE PL Apt: XSt:LOCUST AV Grid:0126 Units:E-42 TC-1 Rmk:18 Months F ;CHOKING",
        "CALL:CHOKING",
        "ADDR:2925 N MAPLE PL",
        "X:LOCUST AV",
        "MAP:0126",
        "UNIT:E-42 TC-1",
        "INFO:18 Months F ;CHOKING");
    
    doTest("T5",
        "Ct:MVA-UNKNOWN-INJ Loc:US HWY 40/INTERSTATE 70 Apt: XSt: Grid:0169 Units:E-41 Rmk:SEMI AND PASSENGER CAR//UNKNOWN Injuries",
        "CALL:MVA-UNKNOWN-INJ",
        "ADDR:US HWY 40 & INTERSTATE 70",
        "MADDR:US 40 & INTERSTATE 70",
        "MAP:0169",
        "UNIT:E-41",
        "INFO:SEMI AND PASSENGER CAR//UNKNOWN Injuries");
    
    doTest("T6",
        "Ct:FIRE-ENTRAPMENT Loc:101 N 7TH ST WTH Apt: XSt:JOHNSON AV MILLER AV Grid:0WTH Units:E-41 E-42 L-41 R-41 Rmk:HOUSE ON FIRE PEOPLE STILL INSIDE",
        "CALL:FIRE-ENTRAPMENT",
        "ADDR:101 N 7TH ST",
        "CITY:WEST TERRE HAUTE",
        "X:JOHNSON AV MILLER AV",
        "MAP:0WTH",
        "UNIT:E-41 E-42 L-41 R-41",
        "INFO:HOUSE ON FIRE PEOPLE STILL INSIDE");

    doTest("T7",
        "(MEDICAL ALARM) Loc:1334 6TH AV Grid:0563 Units:M-7 Rmk:PUSHED PENDANT BUTTON/ UNABLE TO REACH",
        "CALL:MEDICAL ALARM",
        "ADDR:1334 6TH AV",
        "MADDR:1334 6TH AVE",
        "MAP:0563",
        "UNIT:M-7",
        "INFO:PUSHED PENDANT BUTTON/ UNABLE TO REACH");
    
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "[TRASH OR RUBBISH-FIRE]  Loc:428 W POPLAR ST XSt:5TH ST WTH 4TH ST WTH Grid:0WTH Units:E-41 Rmk:RP ADV MALE SUBJECT THERE THAT IS CAUSING PROBLEMS AND",
        "CALL:TRASH OR RUBBISH-FIRE",
        "ADDR:428 W POPLAR ST",
        "X:5TH ST WTH 4TH ST WTH",
        "MAP:0WTH",
        "UNIT:E-41",
        "INFO:RP ADV MALE SUBJECT THERE THAT IS CAUSING PROBLEMS AND");
    
  }
  
  @Test
  public void testJoshSittler() {

    doTest("T1",
        "(FIRE-RESIDENTIAL-STRUCTURE) Loc:1670 W EDGEMONT DR XSt:RAVINE PL EDGEWOOD AV Grid:0126 Units:91RIT CV912 Rmk:ADV HER NEIGHBORS HOUSE IS ON FIRE/OPEN",
        "CALL:FIRE-RESIDENTIAL-STRUCTURE",
        "ADDR:1670 W EDGEMONT DR",
        "X:RAVINE PL EDGEWOOD AV",
        "MAP:0126",
        "UNIT:91RIT CV912",
        "INFO:ADV HER NEIGHBORS HOUSE IS ON FIRE/OPEN");

    doTest("T2",
        "(FIRE-RESIDENTIAL-STRUCTURE) Loc:1670 W EDGEMONT DR XSt:RAVINE PL EDGEWOOD AV Grid:0126 Units:E-42 E-41 T-42 T-41 R-41 Rmk:ADV HER NEIGHBORS HOUSE IS",
        "CALL:FIRE-RESIDENTIAL-STRUCTURE",
        "ADDR:1670 W EDGEMONT DR",
        "X:RAVINE PL EDGEWOOD AV",
        "MAP:0126",
        "UNIT:E-42 E-41 T-42 T-41 R-41",
        "INFO:ADV HER NEIGHBORS HOUSE IS");

    doTest("T3",
        "(INJURED PERSON) Loc:7201 E GROSS DR XSt:LAMA ST ST RD 159 Grid:237A Units:R-53 Rmk:",
        "CALL:INJURED PERSON",
        "ADDR:7201 E GROSS DR",
        "X:LAMA ST ST RD 159",
        "MAP:237A",
        "UNIT:R-53");
   
  }
  
  @Test
  public void testPaulWatson() {

    doTest("T1",
        "(FIRE-RESIDENTIAL-STRUCTURE) Loc:1318 S 11TH HLF ST XSt:COLLEGE AV WASHINGTON ST Grid:0741 Units:EC-2 EC-6 EC-9 L-5 M-9 Rmk:BACK OF THE HOUSE IS ON F",
        "CALL:FIRE-RESIDENTIAL-STRUCTURE",
        "ADDR:1318 S 11TH 1/2 ST",
        "X:COLLEGE AV WASHINGTON ST",
        "MAP:0741",
        "UNIT:EC-2 EC-6 EC-9 L-5 M-9",
        "INFO:BACK OF THE HOUSE IS ON F");

    doTest("T2",
        "(FIRE-COMMERCIAL-STRUCTURE) Loc:663 OHIO ST Grid:0666 Units:EC-2 EC-3 EC-9 L-5 S-5 BAT-2 C-11 Rmk:FIRE SMOKE ALARM/BEEN GOING OFF FOR A COUPLE HRS",
        "CALL:FIRE-COMMERCIAL-STRUCTURE",
        "ADDR:663 OHIO ST",
        "MAP:0666",
        "UNIT:EC-2 EC-3 EC-9 L-5 S-5 BAT-2 C-11",
        "INFO:FIRE SMOKE ALARM/BEEN GOING OFF FOR A COUPLE HRS");
   
  }
  
  public static void main(String[] args) {
    new INVigoCountyParserTest().generateTests("T1");
  }
}