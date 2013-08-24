package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Humble TX, (Harris County)
Contact: "Wassell, Michael" <MWassell@avfd.com>
Sender: msg@cfmsg.com,alert@cfmsg.com
[AVFD EMS] - Cardiac -- 17111 Dawn Shadows Dr, Humble -- Map: 376H- -- Xst's: Forest Rain Ln Old Arbor -- Units: E-M29 -- 201105590
[AVFD EMS] - Diabetic Emergency -- 5310 Moonshadows Dr, Humble -- Map: 337S- -- Xst's: Pocito Ct Wellswood Ct -- Units: E-M29 -- 201105542
[AVFD EMS] - Medical Call -- 6810 Amber Ash Ct, Humble -- Map: 337Q- -- Xst's: Crimson Oak Trl -- Units: E-M19 -- 201105487
[AVFD FIRE] - Fire Alarm - Residential -- 19222 Pinewood Mist Ln, Humble -- Map: 338W- -- Xst's: Pinewood Canyon Ln Pinewo -- Units: ATFD E-E39 -- 201105452
[AVFD FIRE] - Motor Vehicle Incident -- E Fm 1960 & w Lake Houston P, Humble -- Map: 337Z- -- Xst's: W Lake Houston Pkwy Atasc -- Units: E-M19 E-E39 - 201105443
[AVFD FIRE][Repage] - Mvi - Unknown -- Will Clayton Pkwy & atascoci -- Map: 376C- -- Xst's: Atascocita Rd Hunters Ter -- Units: E-M29 E-E39 - 201105192
(Chief ALT) [AVFD FIRE][Repage] - Mutual Aid / Assist Agency -- 5711 Lakewater Dr -- Map: 338M- -- Water Wonderland -- Xst's: Running Water Dr Waterwoo -- Units: E-B3
(Chief ALT) [EMS] - Medical Call - 19326 Aquatic Dr, Humble - Map: 378B- - Xst's: Red Sails Pass Rolling Ra - Units: E-M19 - 201139731
(Chief ALT) [EMS] - Injured Person - 13300 Will Clayton Pkwy, Humble - Map: 377C- - Atascocita High School - Xst's: Tabor Brook Dr Aerobic Av - Units: E-M19 - 2011398
(Chief ALT) [FIRE] - Mutual Aid / Assist Agency - 142 Sunlit Park Dr, Humble - Map: 375V- - Xst's: Early Autumn Ct - Units: UT91 E-E39 - 201139857
(Chief ALT) [FIRE] - Controlled Burn - Jodywood Dr & lonesome Woods - Map: 337Z- - Xst's: Lonesome Woods Trl Echo P - Units: E-E19 - 201139902
(Chief ALT) [EMS] - Medical Call - 7923 Palmer Place Ln, Humble - Map: 337Z- - Xst's: Match Play Dr - Units: E-M19 - 201139926
(Chief ALT) [EMS] - Assault - 17314 Wigeon Way Dr, Humble - Map: 376F- - Xst's: Shearwater Bend Dr - Units: E-M29 - 201139940
(Chief ALT) [EMS] - Eye Problems - Moderate - 238 Old Arbor Way, Humble - Map: 376H- - Xst's: Morning Shadows Way Dawn - Units: E-M29 - 201141225
(Chief ALT) [EMS] - Chest Pain - Clammy - 0218 Powerscourt - Map: 337U- - Units: E-M39 E-E39 E-D59 - 201141272
(Chief ALT) [FIRE] - Fire Alarm - Commercial - 5250 E Fm 1960, Humble - Map: 337W- - Humble Mini Warehouse - Xst's: Moon Trail Dr Timber Fore - Units: ATFD E-E39 - 20
(Chief ALT) [FIRE] - Unk Problem - Medical Ale - 17811 Deep Shade Ct, Humble - Map: 377E- - Xst's: Conifer Ridge Way - Units: E-M29 E-E19 E-E39 - 201149242
(Chief ALT) [EMS] -  Breathing Problems  -  20035 W Lake Houston Pkwy  - Xst's: Firesign Dr/january Dr - Bldg:Ped Associ - Key Map:337U - Box #:A1901
(Chief ALT) [EMS] -  10a1 Cardiac  -  18310 Valiant Brook Ct  -  M19  - KM:377C - Xst's: Dead End/rosebud Bend Dr
(Chief ALT) [EMS] -  32b1 Unknown Problem  -  5823 Forest Timbers Dr  -  M19  - KM:337T - Xst's: Oak Station Dr/kelly Timbers D

CyFair, TX (Atascocita TX)
Contact:  "Stoltz, Eric" <EStoltz@avfd.com>
Sender: msg@cfmsg.com
 1 of 2\nFRM:msg@cfmsg.com\nSUBJ:Chief ALT\nMSG:[FIRE] - Fire Alarm - Residential - 17202 Beretta Bend Dr - Map: 376F- - Atascocita Trace - Xst's:\n(Con't) 2 of 2\nMuscory Dr Shearwater Ben - Units: ATFD E-E29 - 201300303\n(End)
 1 of 2\nFRM:msg@cfmsg.com\nSUBJ:Chief ALT\nMSG:[FIRE] - Motor Vehicle Incident - 2300 E Fm 1960 - Map: 336S- - Xst's: Moonshine Hill Rd 1st St -\n(Con't) 2 of 2\nUnits: E-M29 E-E29 E-E39 - 201300177\n(End)
 1 of 2\nFRM:msg@cfmsg.com\nSUBJ:Chief ALT\nMSG:[FIRE] - Motor Vehicle Incident - Timber Forest Dr & e Fm 1960 - Map: 337S- - Oaks Of Atascocita -\n(Con't) 2 of 2\nXst's: E Fm 1960 Green Timbers D - Units: E-M29 E-E39 E-E29 - 201300087\n(End)
 1 of 2\nFRM:msg@cfmsg.com\nSUBJ:Chief ALT\nMSG:[FIRE] - Small Outside Fire - 6818 Amber Ash Ct - Map: 337Q- - Kings River Village - Xst's: Crimson\n(Con't 2 of 2\nOak Trl - Units: E-E39 FW E-E19 - 201300006\n(End)
 1 of 2\nFRM:msg@cfmsg.com\nSUBJ:Chief ALT\nMSG:[FIRE] - Light Structure Incident - 7619 Bronze Trail Dr - Map: 377D- - Walden On Lake Houston -\n(Con't) 2 of 2\nXst's: Sailfish Cove Dr Trophy P - Units: E-D89 E-E19 E-L19 - 201258397\n(End)
 1 of 2\nFRM:msg@cfmsg.com\nSUBJ:Chief ALT\nMSG:[FIRE] - Residential Fire - 7619 Bronze Trail Dr - Map: 377D- - Walden On Lake Houston - Xst's:\n(Con't) 2 of 2\nSailfish Cove Dr Trophy P - Units: E-E19 E-L19 E-D99 E-E39 - 201258397\n(End)

Contact: Bryan <kyfiremedic36@aol.com>
Sender: alert@cfmsg.com
1 of 2\nFRM:alert@cfmsg.com\nSUBJ:Chief ALT\nMSG:[FIRE] -  Traumatic Injuries (  -  6931 E Fm 1960  - Xst's: Town Center Blvd/atascocita Rd -\n(Con't) 2 of 2\nBldg:Target Sto - Key Map:337Y - Box #:A1901\n\n(End)

Status message, Should be handled as General Alert
(Chief ALT) [AVFD EMS TIMES] - Incident: 201117017 -- Unit: E-M19 Disp 18:20:53 -- Enroute: 18:22:50 -- Arrived: -- Transport: -- At Hosp: -- Available: 18:24:58
(Chief ALT) [ET] - [ 201141019 ] - UNIT: E-M29 Disp 21:47:04 - ENRT: 21:48:26 - OSN: 21:54:23 - TRAN: - @HOS: - AVAL: 22:22:50
don't have the gear to make a string ....bout 20 - 30 at gander
(Chief ALT) [ET] - [ ] - UNIT: E-M29 Disp 18:54:04 - ENRT: 18:55:44 - OSN: 19:00:24 - TRAN: 19:14:40 - @HOS: 19:33:32 - AVAL: 20:12:44


 */

public class TXHumbleParserTest extends BaseParserTest {
  
  public TXHumbleParserTest() {
    setParser(new TXHumbleParser(), "HUMBLE", "TX");
  }
  
  @Test
  public void testStatusMsg() {
    doBadTest("(Chief ALT) [AVFD EMS TIMES] - Incident: 201117017 -- Unit: E-M19 Disp 18:20:53 -- Enroute: 18:22:50 -- Arrived: -- Transport: -- At Hosp: -- Available: 18:24:58");
    doBadTest("(Chief ALT) [ET] - [ 201141019 ] - UNIT: E-M29 Disp 21:47:04 - ENRT: 21:48:26 - OSN: 21:54:23 - TRAN: - @HOS: - AVAL: 22:22:50");
    doBadTest("don't have the gear to make a string ....bout 20 - 30 at gander");
    doBadTest("(Chief ALT) [ET] - [ ] - UNIT: E-M29 Disp 18:54:04 - ENRT: 18:55:44 - OSN: 19:00:24 - TRAN: 19:14:40 - @HOS: 19:33:32 - AVAL: 20:12:44");
  }
  
  @Test
  public void testMichaelWassell() {

    doTest("T1",
        "[AVFD EMS] - Cardiac -- 17111 Dawn Shadows Dr, Humble -- Map: 376H- -- Xst's: Forest Rain Ln Old Arbor -- Units: E-M29 -- 201105590",
        "SRC:AVFD EMS",
        "CALL:Cardiac",
        "ADDR:17111 Dawn Shadows Dr",
        "CITY:Humble",
        "MAP:376H-",
        "X:Forest Rain Ln Old Arbor",
        "UNIT:E-M29",
        "ID:201105590");

    doTest("T2",
        "[AVFD EMS] - Diabetic Emergency -- 5310 Moonshadows Dr, Humble -- Map: 337S- -- Xst's: Pocito Ct Wellswood Ct -- Units: E-M29 -- 201105542",
        "SRC:AVFD EMS",
        "CALL:Diabetic Emergency",
        "ADDR:5310 Moonshadows Dr",
        "CITY:Humble",
        "MAP:337S-",
        "X:Pocito Ct Wellswood Ct",
        "UNIT:E-M29",
        "ID:201105542");

    doTest("T3",
        "[AVFD EMS] - Medical Call -- 6810 Amber Ash Ct, Humble -- Map: 337Q- -- Xst's: Crimson Oak Trl -- Units: E-M19 -- 201105487",
        "SRC:AVFD EMS",
        "CALL:Medical Call",
        "ADDR:6810 Amber Ash Ct",
        "CITY:Humble",
        "MAP:337Q-",
        "X:Crimson Oak Trl",
        "UNIT:E-M19",
        "ID:201105487");

    doTest("T4",
        "[AVFD FIRE] - Fire Alarm - Residential -- 19222 Pinewood Mist Ln, Humble -- Map: 338W- -- Xst's: Pinewood Canyon Ln Pinewo -- Units: ATFD E-E39 -- 201105452",
        "SRC:AVFD FIRE",
        "CALL:Fire Alarm - Residential",
        "ADDR:19222 Pinewood Mist Ln",
        "CITY:Humble",
        "MAP:338W-",
        "X:Pinewood Canyon Ln Pinewo",
        "UNIT:ATFD E-E39",
        "ID:201105452");

    doTest("T5",
        "[AVFD FIRE] - Motor Vehicle Incident -- E Fm 1960 & w Lake Houston P, Humble -- Map: 337Z- -- Xst's: W Lake Houston Pkwy Atasc -- Units: E-M19 E-E39 - 201105443",
        "SRC:AVFD FIRE",
        "CALL:Motor Vehicle Incident",
        "ADDR:E Fm 1960 & w Lake Houston P",
        "CITY:Humble",
        "MAP:337Z-",
        "X:W Lake Houston Pkwy Atasc",
        "UNIT:E-M19 E-E39",
        "ID:201105443");

    doTest("T6",
        "[AVFD FIRE][Repage] - Mvi - Unknown -- Will Clayton Pkwy & atascoci -- Map: 376C- -- Xst's: Atascocita Rd Hunters Ter -- Units: E-M29 E-E39 - 201105192",
        "SRC:AVFD FIRE",
        "CALL:Mvi - Unknown",
        "ADDR:Will Clayton Pkwy & atascoci",
        "MAP:376C-",
        "X:Atascocita Rd Hunters Ter",
        "UNIT:E-M29 E-E39",
        "ID:201105192");

    doTest("T7",
        "(Chief ALT) [AVFD FIRE][Repage] - Mutual Aid / Assist Agency -- 5711 Lakewater Dr -- Map: 338M- -- Water Wonderland -- Xst's: Running Water Dr Waterwoo -- Units: E-B3",
        "SRC:AVFD FIRE",
        "CALL:Mutual Aid / Assist Agency",
        "ADDR:5711 Lakewater Dr",
        "MAP:338M-",
        "PLACE:Water Wonderland",
        "X:Running Water Dr Waterwoo",
        "UNIT:E-B3");

    doTest("T8",
        "(Chief ALT) [EMS] - Medical Call - 19326 Aquatic Dr, Humble - Map: 378B- - Xst's: Red Sails Pass Rolling Ra - Units: E-M19 - 201139731",
        "SRC:EMS",
        "CALL:Medical Call",
        "ADDR:19326 Aquatic Dr",
        "CITY:Humble",
        "MAP:378B-",
        "X:Red Sails Pass Rolling Ra",
        "UNIT:E-M19",
        "ID:201139731");

    doTest("T8",
        "(Chief ALT) [EMS] - Injured Person - 13300 Will Clayton Pkwy, Humble - Map: 377C- - Atascocita High School - Xst's: Tabor Brook Dr Aerobic Av - Units: E-M19 - 2011398",
        "SRC:EMS",
        "CALL:Injured Person",
        "ADDR:13300 Will Clayton Pkwy",
        "CITY:Humble",
        "MAP:377C-",
        "PLACE:Atascocita High School",
        "X:Tabor Brook Dr Aerobic Av",
        "UNIT:E-M19",
        "ID:2011398");

    doTest("T9",
        "(Chief ALT) [FIRE] - Mutual Aid / Assist Agency - 142 Sunlit Park Dr, Humble - Map: 375V- - Xst's: Early Autumn Ct - Units: UT91 E-E39 - 201139857",
        "SRC:FIRE",
        "CALL:Mutual Aid / Assist Agency",
        "ADDR:142 Sunlit Park Dr",
        "CITY:Humble",
        "MAP:375V-",
        "X:Early Autumn Ct",
        "UNIT:UT91 E-E39",
        "ID:201139857");

    doTest("T10",
        "(Chief ALT) [FIRE] - Controlled Burn - Jodywood Dr & lonesome Woods - Map: 337Z- - Xst's: Lonesome Woods Trl Echo P - Units: E-E19 - 201139902",
        "SRC:FIRE",
        "CALL:Controlled Burn",
        "ADDR:Jodywood Dr & lonesome Woods",
        "MAP:337Z-",
        "X:Lonesome Woods Trl Echo P",
        "UNIT:E-E19",
        "ID:201139902");

    doTest("T11",
        "(Chief ALT) [EMS] - Medical Call - 7923 Palmer Place Ln, Humble - Map: 337Z- - Xst's: Match Play Dr - Units: E-M19 - 201139926",
        "SRC:EMS",
        "CALL:Medical Call",
        "ADDR:7923 Palmer Place Ln",
        "CITY:Humble",
        "MAP:337Z-",
        "X:Match Play Dr",
        "UNIT:E-M19",
        "ID:201139926");

    doTest("T12",
        "(Chief ALT) [EMS] - Assault - 17314 Wigeon Way Dr, Humble - Map: 376F- - Xst's: Shearwater Bend Dr - Units: E-M29 - 201139940",
        "SRC:EMS",
        "CALL:Assault",
        "ADDR:17314 Wigeon Way Dr",
        "CITY:Humble",
        "MAP:376F-",
        "X:Shearwater Bend Dr",
        "UNIT:E-M29",
        "ID:201139940");

    doTest("T13",
        "(Chief ALT) [EMS] - Eye Problems - Moderate - 238 Old Arbor Way, Humble - Map: 376H- - Xst's: Morning Shadows Way Dawn - Units: E-M29 - 201141225",
        "SRC:EMS",
        "CALL:Eye Problems - Moderate",
        "ADDR:238 Old Arbor Way",
        "CITY:Humble",
        "MAP:376H-",
        "X:Morning Shadows Way Dawn",
        "UNIT:E-M29",
        "ID:201141225");

    doTest("T14",
        "(Chief ALT) [EMS] - Chest Pain - Clammy - 0218 Powerscourt - Map: 337U- - Units: E-M39 E-E39 E-D59 - 201141272",
        "SRC:EMS",
        "CALL:Chest Pain - Clammy",
        "ADDR:0218 Powerscourt",
        "MAP:337U-",
        "UNIT:E-M39 E-E39 E-D59",
        "ID:201141272");

    doTest("T15",
        "(Chief ALT) [FIRE] - Fire Alarm - Commercial - 5250 E Fm 1960, Humble - Map: 337W- - Humble Mini Warehouse - Xst's: Moon Trail Dr Timber Fore - Units: ATFD E-E39 - 20",
        "SRC:FIRE",
        "CALL:Fire Alarm - Commercial",
        "ADDR:5250 E Fm 1960",
        "CITY:Humble",
        "MAP:337W-",
        "PLACE:Humble Mini Warehouse",
        "X:Moon Trail Dr Timber Fore",
        "UNIT:ATFD E-E39",
        "ID:20");

    doTest("T16",
        "(Chief ALT) [FIRE] - Unk Problem - Medical Ale - 17811 Deep Shade Ct, Humble - Map: 377E- - Xst's: Conifer Ridge Way - Units: E-M29 E-E19 E-E39 - 201149242",
        "SRC:FIRE",
        "CALL:Unk Problem - Medical Ale",
        "ADDR:17811 Deep Shade Ct",
        "CITY:Humble",
        "MAP:377E-",
        "X:Conifer Ridge Way",
        "UNIT:E-M29 E-E19 E-E39",
        "ID:201149242");

    doTest("T17",
        "(Chief ALT) [EMS] -  Breathing Problems  -  20035 W Lake Houston Pkwy  - Xst's: Firesign Dr/january Dr - Bldg:Ped Associ - Key Map:337U - Box #:A1901",
        "SRC:EMS",
        "CALL:Breathing Problems",
        "ADDR:20035 W Lake Houston Pkwy",
        "X:Firesign Dr/january Dr",
        "PLACE:Ped Associ",
        "MAP:337U",
        "BOX:A1901");

    doTest("T18",
        "(Chief ALT) [EMS] -  10a1 Cardiac  -  18310 Valiant Brook Ct  -  M19  - KM:377C - Xst's: Dead End/rosebud Bend Dr",
        "SRC:EMS",
        "CALL:10a1 Cardiac",
        "ADDR:18310 Valiant Brook Ct",
        "UNIT:M19",
        "MAP:377C",
        "X:Dead End/rosebud Bend Dr");

    doTest("T19",
        "(Chief ALT) [EMS] -  32b1 Unknown Problem  -  5823 Forest Timbers Dr  -  M19  - KM:337T - Xst's: Oak Station Dr/kelly Timbers D",
        "SRC:EMS",
        "CALL:32b1 Unknown Problem",
        "ADDR:5823 Forest Timbers Dr",
        "UNIT:M19",
        "MAP:337T",
        "X:Oak Station Dr/kelly Timbers D");

  }
  
  @Test
  public void testAtascocita() {

    doTest("T1",
        " 1 of 2\n" +
        "FRM:msg@cfmsg.com\n" +
        "SUBJ:Chief ALT\n" +
        "MSG:[FIRE] - Fire Alarm - Residential - 17202 Beretta Bend Dr - Map: 376F- - Atascocita Trace - Xst's:\n" +
        "(Con't) 2 of 2\n" +
        "Muscory Dr Shearwater Ben - Units: ATFD E-E29 - 201300303\n" +
        "(End)",

        "SRC:FIRE",
        "CALL:Fire Alarm - Residential",
        "ADDR:17202 Beretta Bend Dr",
        "MAP:376F-",
        "PLACE:Atascocita Trace",
        "X:Muscory Dr Shearwater Ben",
        "UNIT:ATFD E-E29",
        "ID:201300303");

    doTest("T2",
        " 1 of 2\n" +
        "FRM:msg@cfmsg.com\n" +
        "SUBJ:Chief ALT\n" +
        "MSG:[FIRE] - Motor Vehicle Incident - 2300 E Fm 1960 - Map: 336S- - Xst's: Moonshine Hill Rd 1st St -\n" +
        "(Con't) 2 of 2\n" +
        "Units: E-M29 E-E29 E-E39 - 201300177\n" +
        "(End)",

        "SRC:FIRE",
        "CALL:Motor Vehicle Incident",
        "ADDR:2300 E Fm 1960",
        "MAP:336S-",
        "X:Moonshine Hill Rd 1st St",
        "UNIT:E-M29 E-E29 E-E39",
        "ID:201300177");

    doTest("T3",
        " 1 of 2\n" +
        "FRM:msg@cfmsg.com\n" +
        "SUBJ:Chief ALT\n" +
        "MSG:[FIRE] - Motor Vehicle Incident - Timber Forest Dr & e Fm 1960 - Map: 337S- - Oaks Of Atascocita -\n" +
        "(Con't) 2 of 2\n" +
        "Xst's: E Fm 1960 Green Timbers D - Units: E-M29 E-E39 E-E29 - 201300087\n" +
        "(End)",

        "SRC:FIRE",
        "CALL:Motor Vehicle Incident",
        "ADDR:Timber Forest Dr & e Fm 1960",
        "MAP:337S-",
        "PLACE:Oaks Of Atascocita",
        "X:E Fm 1960 Green Timbers D",
        "UNIT:E-M29 E-E39 E-E29",
        "ID:201300087");

    doTest("T4",
        " 1 of 2\n" +
        "FRM:msg@cfmsg.com\n" +
        "SUBJ:Chief ALT\n" +
        "MSG:[FIRE] - Small Outside Fire - 6818 Amber Ash Ct - Map: 337Q- - Kings River Village - Xst's: Crimson\n" +
        "(Con't 2 of 2\n" +
        "Oak Trl - Units: E-E39 FW E-E19 - 201300006\n" +
        "(End)",

        "SRC:FIRE",
        "CALL:Small Outside Fire",
        "ADDR:6818 Amber Ash Ct",
        "MAP:337Q-",
        "PLACE:Kings River Village",
        "X:Crimson Oak Trl",
        "UNIT:E-E39 FW E-E19",
        "ID:201300006");

    doTest("T5",
        " 1 of 2\n" +
        "FRM:msg@cfmsg.com\n" +
        "SUBJ:Chief ALT\n" +
        "MSG:[FIRE] - Light Structure Incident - 7619 Bronze Trail Dr - Map: 377D- - Walden On Lake Houston -\n" +
        "(Con't) 2 of 2\n" +
        "Xst's: Sailfish Cove Dr Trophy P - Units: E-D89 E-E19 E-L19 - 201258397\n" +
        "(End)",

        "SRC:FIRE",
        "CALL:Light Structure Incident",
        "ADDR:7619 Bronze Trail Dr",
        "MAP:377D-",
        "PLACE:Walden On Lake Houston",
        "X:Sailfish Cove Dr Trophy P",
        "UNIT:E-D89 E-E19 E-L19",
        "ID:201258397");

    doTest("T6",
        " 1 of 2\n" +
        "FRM:msg@cfmsg.com\n" +
        "SUBJ:Chief ALT\n" +
        "MSG:[FIRE] - Residential Fire - 7619 Bronze Trail Dr - Map: 377D- - Walden On Lake Houston - Xst's:\n" +
        "(Con't) 2 of 2\n" +
        "Sailfish Cove Dr Trophy P - Units: E-E19 E-L19 E-D99 E-E39 - 201258397\n" +
        "(End)",

        "SRC:FIRE",
        "CALL:Residential Fire",
        "ADDR:7619 Bronze Trail Dr",
        "MAP:377D-",
        "PLACE:Walden On Lake Houston",
        "X:Sailfish Cove Dr Trophy P",
        "UNIT:E-E19 E-L19 E-D99 E-E39",
        "ID:201258397");
   
  }
  
  @Test
  public void testByron() {

    doTest("T1",
        "1 of 2\n" +
        "FRM:alert@cfmsg.com\n" +
        "SUBJ:Chief ALT\n" +
        "MSG:[FIRE] -  Traumatic Injuries (  -  6931 E Fm 1960  - Xst's: Town Center Blvd/atascocita Rd -\n" +
        "(Con't) 2 of 2\n" +
        "Bldg:Target Sto - Key Map:337Y - Box #:A1901\n\n" +
        "(End)",

        "SRC:FIRE",
        "CALL:Traumatic Injuries (",
        "ADDR:6931 E Fm 1960",
        "X:Town Center Blvd/atascocita Rd",
        "PLACE:Target Sto",
        "MAP:337Y",
        "BOX:A1901");
    
  }
  
  public static void main(String[] args) {
    new TXHumbleParserTest().generateTests("T1");
  }
}
