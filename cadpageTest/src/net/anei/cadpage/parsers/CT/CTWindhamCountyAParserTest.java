package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Windham County, CT (Quinebaug Valley Emergency Communications)
Contact: Jeffrey Bellavance <jcb294@gmail.com>
Sender: qvecpaging@qvec.org

(Moosup FD Page) STA94 STA594 MOOS1  UHF-4 PRI 1 person fallen Medical Alarm 1 SARA LN / Moosup (X-STS HIGH ST / DEAD END ) 07:31
(Moosup FD Page) STA94 STA594 MOOS1  33.88 PRI 1 Sick Person 109 WHIP POOR WILL DR / Moosup (X-STS ) 10:57
(Moosup FD Page) STA94 STA594 MOOS1  UHF-4 PRI 1 Sick Person BARBER HILL RD / N  MAIN ST Moosup (X-STS ) 17:35
(Moosup FD Page) STA94 94OFF  33.90 Vehicle Fire I 395 SOUTH SOUTH OF REST AREA / Moosup (X-STS ) 14:24
(Moosup FD Page) STA94  UHF-4 Wire Down Starting a Small Grass Fire / Tree/Wires Down 201 STARKWEATHER RD / Moosup (X-STS GROVE ST  STERLING HILL RD / PLAINFIELD
(Moosup FD Page) STA94  33.88 Please Operate 33.88/  Lift Assist 2 N  POTVIN AVE / Moosup (X-STS DAGGETT ST / POTVIN AVE ) 11:34
(Moosup FD Page) STA94  33.76 OUT BUILDING SMOLDERING Outside/Unknown Fire 399 SNAKE MEADOW RD / SNAKE MEADOW CLUB Moosup (X-STS OLEAROS HILL RD / DEMERS RD )
(Moosup FD Page) STA94  UHF-4 Alarm Reset / Smoke from Cooking /  Fire Alarm 25 SUNNY ACRES / Moosup (X-STS DAGGETT ST / DEAD END ) 10:19
(Moosup FD Page) STA94  33.90 PRI 1 ROLL OVER / STA94 MANPOWER REQUESTED / Vehicle Accident I 395 S / EXIT 88 / Plainfield (X-STS ) 11:27
(Moosup FD Page) QVMedic STA94 STA594 MOOS1  UHF-4 PRI 1 PARTIAL AIR WAS OBSTRUCTIONS / Choking/Airway Problem 67 S MAIN ST / Moosup (X-STS VOSSLER DR / WARD LN
(Moosup FD Page) STA94 STA594 MOOS2  UHF-4 PRI 1 MOOS AMB 2ND CREW / Vehicle Accident SNAKE MEADOW RD / VALLEY VIEW RD / Moosup (X-STS ) 22:10

Contact: Joshua Maloney <josh.d.maloney@gmail.com>
Contact: "chieflapierre@sbcglobal.net" <chieflapierre@sbcglobal.net>
STA97 STA594 MOOS2  UHF-4 PRI 1 2ND CREW NEEDED Cardiac Distress 30 PICKETT RD / Central Village (X-STS TEX
Subject:Central Village FD Page\nSTA97 STA594 MOOS2  UHF-4 PRI 1 MOOS AMB 2ND CREW NEEDED / Injured Person 80 S CADY LN / CENTRAL CYCLE TRAC

Contact: David Silva <david.silva92@yahoo.com>
1 of 2\nFRM:messaging@iamresponding.com\nSUBJ:K.B. Ambulance\nMSG:RES65  KB2  UHF-2 PRI 1 KB SECOND CREW / POLICE ENROUTE /  Cardiac/Respiratory\n(Con't) 2 of 2\nArrest 36 SAW MILL HILL RD / Killingly (X-STS TILLINGHAST RD / PROVIDENCE PIKE  BAILEY HILL RD ) 07:11¿\n(End)

Contact: Larry Loomis <larry.loomis.jr@gmail.com>
.... (Moosup Fire) STA94 STA594 MOOS1  UHF-4 PRI 1 Down an enbankment Vehicle Accident MARY AVE / TOM AVE Moosup (X-STS ) 21:59
.... (Moosup Fire) STA94 STA594 MOOS2  UHF-4 PRI 1 Injured Person 47 PROSPECT ST / PARKING LOT Moosup (X-STS RAILROAD AVE / ALLEN ST ) 18:25
.... (Moosup Fire) STA94 STA594 MOOS2  UHF-4 PRI 1 Moos Amb. 2nd Crew needed /  Sick Person 29 SUNNY ACRES / Moosup (X-STS DEAD END / DAGGETT ST ) 12:34
.... (Moosup Fire) STA94  33.88 PRI 1 STA94 for R1 Personnel to Plainfield/  Fall Injury 796 NORWICH RD / MC DONALDS Plainfield (X-STS LATHROP RD EXT / OLD NORWICH RD ) 13:52
.... (Moosup Fire) STA94  UHF-4 OPER UHF PLEASE Fire Alarm 19 SUNNY ACRES / Moosup (X-STS DAGGETT ST / DEAD END ) 11:56

Contact: Brian Theriault <car194@ct.metrocast.net>
Sender: messaging@iamresponding.com
(Moosup Fire) STA94 STA594 MOOS1  EKONK 460 PRI 1 POSSIBLE CHOKING Unknown Problem (EMS) 81 LAKE ST / Moosup (X-STS VICTORIA DR / PARENT HILL RD ) 07:26

Contact: Active911
Agency name: Lisbon Fire  Ambulance
Location: Lisbon, CT, United States
Sender: qvecpaging@qvec.org

(Lisbon FD Page) STA54 STA554 R554  33.88 PRI 1 MEET THE TROOP / Unknown Problem (EMS) 55 KENDALL RD / Lisbon (X-STS KENDALL RD EXT / PRESTON ALLEN RD ) 18:38
(Lisbon FD Page) STA54 STA554 R554  33.88 PRI 1 SYNCOPY NOW CONC. Unconscious/Fainting 114 RIVER RD / HENNY PENNY Lisbon (X-STS EXIT 84 N / LEE RD ) 11:17
(Lisbon FD Page) STA54  33.74 CO (No Symptoms) 18 VERSAILLES RD / Lisbon (X-STS KENDALL RD / DEAD END ) 20:08
(Lisbon FD Page) STA54  33.88 PRI 2 EMT still needed /  Mental Disorder N BURNHAM HWY / ROSS HILL RD Lisbon (X-STS ) 11:03

Contact: Active911
Agency name: Danielson Fire Department
Location: Danielson, CT, United States
Sender: "qvecpaging@qvec.org" <qvecpaging@qvec.org>

(Danielson FD Page) QVMedic1 RES61 STA561 KB1  KILLINGLY 460 PRI 1 Difficulty Breathing 30 GLADYS ST / Killingly (X-STS RIVER ST / MAPLE ST ) 16:39
(Danielson FD Page) RES61 STA561 KB2  KILLINGLY 460 PRI 1 2ND CREW NEEDED Sick Person 22 PALMER ST / Killingly (X-STS LEANDER ST / MAPLE ST, W PALMER ST ) 23:47
(Danielson FD Page) RES61 STA561 KB1 QVMedic1  KILLINGLY 460 PRI 1 Prior to Exit 92 Unconscious/Fainting ROUTE 395 NORTHBOUND / Killingly (X-STS ) 15:16
(Danielson FD Page) RES61 STA561 KB1  KILLINGLY 460 PRI 1 question of obstructed airway Choking/Airway Problem 29 OAK ST / Killingly (X-STS SPRING ST / MECHANIC ST ) 15:09
(Danielson FD Page) STA61  33.90 REPAGE FOR E161 Hazardous Materials 111 WESTCOTT RD / Killingly (X-STS SPRAGUE ST / MAIN ST, HUTCHINS ST ) 13:54
(Danielson FD Page) STA61  33.90 Fire Alarm 111 WESTCOTT RD / Killingly (X-STS SPRAGUE ST / MAIN ST, HUTCHINS ST ) 13:54
(Danielson FD Page) STA61 :  Oper 33.76 /  ET161 to Cover at STA67 (Sterling)
(Danielson FD Page) STA61  33.76 CO (No Symptoms) 231 MAIN ST / UNIT A Killingly (X-STS REYNOLDS ST, SPRING ST / BROAD ST ) 00:57
(Danielson FD Page) STA61  33.90 smoke detectors  Fire Alarm 163 COMMERCE AVE / Killingly (X-STS ) 18:24
(Danielson FD Page) STA61  33.76 Fire Alarm 127 LHOMME ST / Killingly (X-STS BONNEVILLE ST / EXIT 92 S, GAUTHIER AVE ) 14:20

Contact: Active911
Agency name: Eastford Independent Fire Co.#1
Location: Eastford, CT, United States
Sender: "qvecpaging@qvec.org" <qvecpaging@qvec.org>

(Eastford FD Page) STA71  33.88 Lift Assist 31 ASHFORD RD / Eastford (X-STS WESTFORD RD / FLOETING RD ) 17:39
(Eastford FD Page) STA71  33.90 HOT WATER HEATER  Smoke in the Building 18 WEEKS RD / Eastford (X-STS WESTFORD RD / CRYSTAL POND RD ) 13:26
(Eastford FD Page) STA77 STA71  UNION 453 / CALL FROM 50 HOPKINS RD /  Smoke/Odor Investigation 501 PERRIN RD / Woodstock (X-STS HOPKINS RD, ROCKY HILL RD / OLD COLONY RD ) 07:54
(Eastford FD Page) QVMedic1 STA71 R520  33.88 PRI 1 Difficulty Breathing 76 COUNTY RD / WHITCRAFT DOCK 5 Eastford (X-STS MILL BRIDGE RD / BARLOW CEMETERY RD ) 07:53
(Eastford FD Page) STA71 STA70 R520  33.90 REKINDLE FROM PREVIOUS GARAGE FIRE Structure Fire 195 PILFERSHIRE RD / Eastford (X-STS KINGSBURY RD / DEAD END ) 18:31
(Eastford FD Page) STA71 R520  33.88 PRI 1 known diabetic/abdominal distress/ Sick Person 181 WESTFORD RD / Eastford (X-STS ASHFORD RD / CRYSTAL POND RD ) 15:31
(Eastford FD Page) STA71 R520  33.88 PRI 1 Headache as result of fall/67 y/o female/ Medical Alarm 181 WESTFORD RD / Eastford (X-STS ASHFORD RD / CRYSTAL POND RD ) 18:38
(Eastford FD Page) STA71 STA70 R520  33.90 Structure Fire 195 PILFERSHIRE RD / Eastford (X-STS KINGSBURY RD / DEAD END ) 22:05
(Eastford FD Page) STA71 R520  33.88 PRI 1 Abdominal Pain 54 WESTFORD RD / Eastford (X-STS WEEKS RD / CHURCH RD ) 12:52
(Eastford FD Page) STA71 R520  33.88 PRI 2 police on scene Mental Disorder 211 EASTFORD RD / Eastford (X-STS WESTFORD RD, OLD COLONY RD / ROUTE 198 ) 13:03

Contact: Active911
Agency name: Bungay Fire Brigade
Location: Woodstock, CT, United States
Sender: qvecpaging@qvec.org

(Bungay FD Page) QVMedic1 STA77 STA576 WOOD1  UNION 453 PRI 1 intersection of 197/198/ Vehicle Accident 1711 ROUTE 197 / Woodstock (X-STS HERINDEEN LDG / ROUTE 198 ) 12:07
(Bungay FD Page) STA77 STA576 WOOD1  UNION 453 PRI 1 POWER SAW INJURY TO HAND Injured Person 334 BRICKYARD RD / Woodstock (X-STS CHILD RD / REDHEAD HILL RD ) 14:57
(Bungay FD Page) STA77  UNION 453 1 ET TO COVER STA 71 Misc 6 WESTFORD RD / Eastford (X-STS EASTFORD RD, OLD COLONY RD / JOHN PERRY RD ) 14:04
(Bungay FD Page) STA77 STA576 WOOD1  UNION 453 PRI 2 meet state police Injured Person 6 VALLEY VIEW RD / Woodstock (X-STS LYON RD / SPRING HILL RD ) 10:07
(Bungay FD Page) QVMedic1 STA77 STA576 WOOD1  UNION 453 PRI 1 TONGUE SWELLING / 5 YO Allergic Reaction 251 SMITH RD / Woodstock (X-STS ROCKY HILL RD / ROUTE 171 ) 20:56
(Bungay FD Page) STA76 STA77  UNION 453 Sta-76 for L-176  Chimney Fire 32 VALLEY VIEW RD / Woodstock (X-STS LYON RD / SPRING HILL RD ) 17:52
(Bungay FD Page) STA77  UNION 453 WATER IN BASEMENT Service Call 100 BRADFORD CORNER RD / Woodstock (X-STS HEREFORD LN / PERRIN RD, ROUTE 171 ) 10:52
(Bungay FD Page) STA77 STA576 WOOD1  UNION 453 PRI 1 Accidental Lac from Box Cutter /  Injured Person 1026 ROUTE 171 / Woodstock (X-STS SHIELDS RD, COATNEY HILL RD / SMITH RD ) 14:44
(Bungay FD Page) STA77 STA576 WOOD1  UNION 453 PRI 1 No contact with Subscriber /  Medical Alarm 41 RED CEDAR RD / Woodstock (X-STS MAPLE WOOD DR / LYON RD ) 13:43
(Bungay FD Page) QVMedic1 STA77 STA576 WOOD1  UNION 453 PRI 1 Cardiac Distress 38 LYON RD / Woodstock (X-STS RED CEDAR RD / HEMLOCK DR ) 13:42

*/

public class CTWindhamCountyAParserTest extends BaseParserTest {
  
  public CTWindhamCountyAParserTest() {
    setParser(new CTWindhamCountyAParser(), "WINDHAM COUNTY", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Moosup FD Page) STA94 STA594 MOOS1  UHF-4 PRI 1 person fallen Medical Alarm 1 SARA LN / Moosup (X-STS HIGH ST / DEAD END ) 07:31",
        "SRC:Moosup FD",
        "UNIT:STA94 STA594 MOOS1",
        "CH:UHF-4",
        "PRI:1",
        "CALL:person fallen Medical Alarm",
        "ADDR:1 SARA LN",
        "CITY:Moosup",
        "X:HIGH ST / DEAD END",
        "TIME:07:31");

    doTest("T2",
        "(Moosup FD Page) STA94 STA594 MOOS1  33.88 PRI 1 Sick Person 109 WHIP POOR WILL DR / Moosup (X-STS ) 10:57",
        "SRC:Moosup FD",
        "UNIT:STA94 STA594 MOOS1",
        "CH:33.88",
        "PRI:1",
        "CALL:Sick Person",
        "ADDR:109 WHIP POOR WILL DR",
        "CITY:Moosup",
        "TIME:10:57");

    doTest("T3",
        "(Moosup FD Page) STA94 STA594 MOOS1  UHF-4 PRI 1 Sick Person BARBER HILL RD / N  MAIN ST Moosup (X-STS ) 17:35",
        "SRC:Moosup FD",
        "UNIT:STA94 STA594 MOOS1",
        "CH:UHF-4",
        "PRI:1",
        "CALL:Sick Person",
        "ADDR:BARBER HILL RD & N  MAIN ST",
        "CITY:Moosup",
        "TIME:17:35");

    doTest("T4",
        "(Moosup FD Page) STA94 94OFF  33.90 Vehicle Fire I 395 SOUTH SOUTH OF REST AREA / Moosup (X-STS ) 14:24",
        "SRC:Moosup FD",
        "UNIT:STA94 94OFF",
        "CH:33.90",
        "CALL:Vehicle Fire",
        "ADDR:I 395 SOUTH SOUTH OF REST AREA",
        "MADDR:I 395 SOUTH & REST AREA",
        "CITY:Moosup",
        "TIME:14:24");

    doTest("T5",
        "(Moosup FD Page) STA94  UHF-4 Wire Down Starting a Small Grass Fire / Tree/Wires Down 201 STARKWEATHER RD / Moosup (X-STS GROVE ST  STERLING HILL RD / PLAINFIELD",
        "SRC:Moosup FD",
        "UNIT:STA94",
        "CH:UHF-4",
        "CALL:Wire Down Starting a Small Grass Fire / Tree/Wires Down",
        "ADDR:201 STARKWEATHER RD",
        "CITY:Moosup",
        "X:GROVE ST  STERLING HILL RD / PLAINFIELD");

    doTest("T6",
        "(Moosup FD Page) STA94  33.88 Please Operate 33.88/  Lift Assist 2 N  POTVIN AVE / Moosup (X-STS DAGGETT ST / POTVIN AVE ) 11:34",
        "SRC:Moosup FD",
        "UNIT:STA94",
        "CH:33.88",
        "CALL:Please Operate 33.88/  Lift Assist",
        "ADDR:2 N POTVIN AVE",
        "CITY:Moosup",
        "X:DAGGETT ST / POTVIN AVE",
        "TIME:11:34");

    doTest("T7",
        "(Moosup FD Page) STA94  33.76 OUT BUILDING SMOLDERING Outside/Unknown Fire 399 SNAKE MEADOW RD / SNAKE MEADOW CLUB Moosup (X-STS OLEAROS HILL RD / DEMERS RD )",
        "SRC:Moosup FD",
        "UNIT:STA94",
        "CH:33.76",
        "CALL:OUT BUILDING SMOLDERING Outside/Unknown Fire",
        "ADDR:399 SNAKE MEADOW RD",
        "PLACE:SNAKE MEADOW CLUB",
        "CITY:Moosup",
        "X:OLEAROS HILL RD / DEMERS RD");

    doTest("T8",
        "(Moosup FD Page) STA94  UHF-4 Alarm Reset / Smoke from Cooking /  Fire Alarm 25 SUNNY ACRES / Moosup (X-STS DAGGETT ST / DEAD END ) 10:19",
        "SRC:Moosup FD",
        "UNIT:STA94",
        "CH:UHF-4",
        "CALL:Alarm Reset / Smoke from Cooking /  Fire Alarm",
        "ADDR:25 SUNNY ACRES",
        "CITY:Moosup",
        "X:DAGGETT ST / DEAD END",
        "TIME:10:19");

    doTest("T9",
        "(Moosup FD Page) STA94  33.90 PRI 1 ROLL OVER / STA94 MANPOWER REQUESTED / Vehicle Accident I 395 S / EXIT 88 / Plainfield (X-STS ) 11:27",
        "SRC:Moosup FD",
        "UNIT:STA94",
        "CH:33.90",
        "PRI:1",
        "CALL:ROLL OVER / STA94 MANPOWER REQUESTED / Vehicle Accident",
        "ADDR:I 395 S & EXIT 88",
        "CITY:Plainfield",
        "TIME:11:27");

    doTest("T10",
        "(Moosup FD Page) QVMedic STA94 STA594 MOOS1  UHF-4 PRI 1 PARTIAL AIR WAS OBSTRUCTIONS / Choking/Airway Problem 67 S MAIN ST / Moosup (X-STS VOSSLER DR / WARD LN",
        "SRC:Moosup FD",
        "UNIT:QVMedic STA94 STA594 MOOS1",
        "CH:UHF-4",
        "PRI:1",
        "CALL:PARTIAL AIR WAS OBSTRUCTIONS / Choking/Airway Problem",
        "ADDR:67 S MAIN ST",
        "CITY:Moosup",
        "X:VOSSLER DR / WARD LN");

    doTest("T11",
        "(Moosup FD Page) STA94 STA594 MOOS2  UHF-4 PRI 1 MOOS AMB 2ND CREW / Vehicle Accident SNAKE MEADOW RD / VALLEY VIEW RD / Moosup (X-STS ) 22:10",
        "SRC:Moosup FD",
        "UNIT:STA94 STA594 MOOS2",
        "CH:UHF-4",
        "PRI:1",
        "CALL:MOOS AMB 2ND CREW / Vehicle Accident SNAKE",
        "ADDR:MEADOW RD & VALLEY VIEW RD",
        "CITY:Moosup",
        "TIME:22:10");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "STA97 STA594 MOOS2  UHF-4 PRI 1 2ND CREW NEEDED Cardiac Distress 30 PICKETT RD / Central Village (X-STS TEX",
        "UNIT:STA97 STA594 MOOS2",
        "CH:UHF-4",
        "PRI:1",
        "CALL:2ND CREW NEEDED Cardiac Distress",
        "ADDR:30 PICKETT RD",
        "CITY:Central Village",
        "X:TEX");

    doTest("T2",
        "Subject:Central Village FD Page\nSTA97 STA594 MOOS2  UHF-4 PRI 1 MOOS AMB 2ND CREW NEEDED / Injured Person 80 S CADY LN / CENTRAL CYCLE TRAC",
        "SRC:Central Village FD",
        "UNIT:STA97 STA594 MOOS2",
        "CH:UHF-4",
        "PRI:1",
        "CALL:MOOS AMB 2ND CREW NEEDED / Injured Person",
        "ADDR:80 S CADY LN",
        "PLACE:CENTRAL CYCLE TRAC");

    doTest("T3",
        "1 of 2\nFRM:messaging@iamresponding.com\nSUBJ:K.B. Ambulance\nMSG:RES65  KB2  UHF-2 PRI 1 KB SECOND CREW / POLICE ENROUTE /  Cardiac/Respiratory\n(Con't) 2 of 2\nArrest 36 SAW MILL HILL RD / Killingly (X-STS TILLINGHAST RD / PROVIDENCE PIKE  BAILEY HILL RD ) 07:11¿\n(End)",
        "SRC:K.B. Ambulance",
        "UNIT:RES65 KB2",
        "CH:UHF-2",
        "PRI:1",
        "CALL:KB SECOND CREW / POLICE ENROUTE /  Cardiac/Respiratory Arrest",
        "ADDR:36 SAW MILL HILL RD",
        "CITY:Killingly",
        "X:TILLINGHAST RD / PROVIDENCE PIKE  BAILEY HILL RD");

  }
  
  @Test
  public void testBrianTheriault() {

    doTest("T1",
        "(Moosup Fire) STA94 STA594 MOOS1  EKONK 460 PRI 1 POSSIBLE CHOKING Unknown Problem (EMS) 81 LAKE ST / Moosup (X-STS VICTORIA DR / PARENT HILL RD ) 07:26",
        "SRC:Moosup Fire",
        "UNIT:STA94 STA594 MOOS1 EKONK",
        "CH:460",
        "PRI:1",
        "CALL:POSSIBLE CHOKING Unknown Problem (EMS)",
        "ADDR:81 LAKE ST",
        "CITY:Moosup",
        "X:VICTORIA DR / PARENT HILL RD",
        "TIME:07:26");

  }
  
  @Test
  public void testLisbonFireAmbulance() {

    doTest("T1",
        "(Lisbon FD Page) STA54 STA554 R554  33.88 PRI 1 MEET THE TROOP / Unknown Problem (EMS) 55 KENDALL RD / Lisbon (X-STS KENDALL RD EXT / PRESTON ALLEN RD ) 18:38",
        "SRC:Lisbon FD",
        "UNIT:STA54 STA554 R554",
        "CH:33.88",
        "PRI:1",
        "CALL:MEET THE TROOP / Unknown Problem (EMS)",
        "ADDR:55 KENDALL RD",
        "CITY:Lisbon",
        "X:KENDALL RD EXT / PRESTON ALLEN RD",
        "TIME:18:38");

    doTest("T2",
        "(Lisbon FD Page) STA54 STA554 R554  33.88 PRI 1 SYNCOPY NOW CONC. Unconscious/Fainting 114 RIVER RD / HENNY PENNY Lisbon (X-STS EXIT 84 N / LEE RD ) 11:17",
        "SRC:Lisbon FD",
        "UNIT:STA54 STA554 R554",
        "CH:33.88",
        "PRI:1",
        "CALL:SYNCOPY NOW CONC. Unconscious/Fainting",
        "ADDR:114 RIVER RD",
        "PLACE:HENNY PENNY",
        "CITY:Lisbon",
        "X:EXIT 84 N / LEE RD",
        "TIME:11:17");

    doTest("T3",
        "(Lisbon FD Page) STA54  33.74 CO (No Symptoms) 18 VERSAILLES RD / Lisbon (X-STS KENDALL RD / DEAD END ) 20:08",
        "SRC:Lisbon FD",
        "UNIT:STA54",
        "CH:33.74",
        "CALL:CO (No Symptoms)",
        "ADDR:18 VERSAILLES RD",
        "CITY:Lisbon",
        "X:KENDALL RD / DEAD END",
        "TIME:20:08");

    doTest("T4",
        "(Lisbon FD Page) STA54  33.88 PRI 2 EMT still needed /  Mental Disorder N BURNHAM HWY / ROSS HILL RD Lisbon (X-STS ) 11:03",
        "SRC:Lisbon FD",
        "UNIT:STA54",
        "CH:33.88",
        "PRI:2",
        "CALL:EMT still needed /  Mental Disorder",
        "ADDR:N BURNHAM HWY & ROSS HILL RD",
        "CITY:Lisbon",
        "TIME:11:03");
 
  }
  
  @Test
  public void testDanielsonFire() {

    doTest("T1",
        "(Danielson FD Page) QVMedic1 RES61 STA561 KB1  KILLINGLY 460 PRI 1 Difficulty Breathing 30 GLADYS ST / Killingly (X-STS RIVER ST / MAPLE ST ) 16:39",
        "SRC:Danielson FD",
        "UNIT:QVMedic1 RES61 STA561 KB1",
        "CH:KILLINGLY 460",
        "PRI:1",
        "CALL:Difficulty Breathing",
        "ADDR:30 GLADYS ST",
        "CITY:Killingly",
        "X:RIVER ST / MAPLE ST",
        "TIME:16:39");

    doTest("T2",
        "(Danielson FD Page) RES61 STA561 KB2  KILLINGLY 460 PRI 1 2ND CREW NEEDED Sick Person 22 PALMER ST / Killingly (X-STS LEANDER ST / MAPLE ST, W PALMER ST ) 23:47",
        "SRC:Danielson FD",
        "UNIT:RES61 STA561 KB2",
        "CH:KILLINGLY 460",
        "PRI:1",
        "CALL:2ND CREW NEEDED Sick Person",
        "ADDR:22 PALMER ST",
        "CITY:Killingly",
        "X:LEANDER ST / MAPLE ST, W PALMER ST",
        "TIME:23:47");

    doTest("T3",
        "(Danielson FD Page) RES61 STA561 KB1 QVMedic1  KILLINGLY 460 PRI 1 Prior to Exit 92 Unconscious/Fainting ROUTE 395 NORTHBOUND / Killingly (X-STS ) 15:16",
        "SRC:Danielson FD",
        "UNIT:RES61 STA561 KB1 QVMedic1",
        "CH:KILLINGLY 460",
        "PRI:1",
        "CALL:Prior to Exit",
        "ADDR:92 Unconscious & Fainting ROUTE 395 NORTHBOUND",
        "MADDR:92 Unconscious",
        "CITY:Killingly",
        "TIME:15:16");

    doTest("T4",
        "(Danielson FD Page) RES61 STA561 KB1  KILLINGLY 460 PRI 1 question of obstructed airway Choking/Airway Problem 29 OAK ST / Killingly (X-STS SPRING ST / MECHANIC ST ) 15:09",
        "SRC:Danielson FD",
        "UNIT:RES61 STA561 KB1",
        "CH:KILLINGLY 460",
        "PRI:1",
        "CALL:question of obstructed airway Choking/Airway Problem",
        "ADDR:29 OAK ST",
        "CITY:Killingly",
        "X:SPRING ST / MECHANIC ST",
        "TIME:15:09");

    doTest("T5",
        "(Danielson FD Page) STA61  33.90 REPAGE FOR E161 Hazardous Materials 111 WESTCOTT RD / Killingly (X-STS SPRAGUE ST / MAIN ST, HUTCHINS ST ) 13:54",
        "SRC:Danielson FD",
        "UNIT:STA61",
        "CH:33.90",
        "CALL:REPAGE FOR E161 Hazardous Materials",
        "ADDR:111 WESTCOTT RD",
        "CITY:Killingly",
        "X:SPRAGUE ST / MAIN ST, HUTCHINS ST",
        "TIME:13:54");

    doTest("T6",
        "(Danielson FD Page) STA61  33.90 Fire Alarm 111 WESTCOTT RD / Killingly (X-STS SPRAGUE ST / MAIN ST, HUTCHINS ST ) 13:54",
        "SRC:Danielson FD",
        "UNIT:STA61",
        "CH:33.90",
        "CALL:Fire Alarm",
        "ADDR:111 WESTCOTT RD",
        "CITY:Killingly",
        "X:SPRAGUE ST / MAIN ST, HUTCHINS ST",
        "TIME:13:54");

    doTest("T7",
        "(Danielson FD Page) STA61 :  Oper 33.76 /  ET161 to Cover at STA67 (Sterling)",
        "SRC:Danielson FD",
        "UNIT:STA61 : Oper",
        "CH:33.76",
        "PLACE:ET161 to Cover at STA67 (Sterling)");

    doTest("T8",
        "(Danielson FD Page) STA61  33.76 CO (No Symptoms) 231 MAIN ST / UNIT A Killingly (X-STS REYNOLDS ST, SPRING ST / BROAD ST ) 00:57",
        "SRC:Danielson FD",
        "UNIT:STA61",
        "CH:33.76",
        "CALL:CO (No Symptoms)",
        "ADDR:231 MAIN ST",
        "PLACE:UNIT A",
        "CITY:Killingly",
        "X:REYNOLDS ST, SPRING ST / BROAD ST",
        "TIME:00:57");

    doTest("T9",
        "(Danielson FD Page) STA61  33.90 smoke detectors  Fire Alarm 163 COMMERCE AVE / Killingly (X-STS ) 18:24",
        "SRC:Danielson FD",
        "UNIT:STA61",
        "CH:33.90",
        "CALL:smoke detectors Fire Alarm",
        "ADDR:163 COMMERCE AVE",
        "CITY:Killingly",
        "TIME:18:24");

    doTest("T10",
        "(Danielson FD Page) STA61  33.76 Fire Alarm 127 LHOMME ST / Killingly (X-STS BONNEVILLE ST / EXIT 92 S, GAUTHIER AVE ) 14:20",
        "SRC:Danielson FD",
        "UNIT:STA61",
        "CH:33.76",
        "CALL:Fire Alarm",
        "ADDR:127 LHOMME ST",
        "CITY:Killingly",
        "X:BONNEVILLE ST / EXIT 92 S, GAUTHIER AVE",
        "TIME:14:20");

  }
  
  @Test
  public void testEastfordIndependentFireCo1() {

    doTest("T1",
        "(Eastford FD Page) STA71  33.88 Lift Assist 31 ASHFORD RD / Eastford (X-STS WESTFORD RD / FLOETING RD ) 17:39",
        "SRC:Eastford FD",
        "UNIT:STA71",
        "CH:33.88",
        "CALL:Lift Assist",
        "ADDR:31 ASHFORD RD",
        "CITY:Eastford",
        "X:WESTFORD RD / FLOETING RD",
        "TIME:17:39");

    doTest("T2",
        "(Eastford FD Page) STA71  33.90 HOT WATER HEATER  Smoke in the Building 18 WEEKS RD / Eastford (X-STS WESTFORD RD / CRYSTAL POND RD ) 13:26",
        "SRC:Eastford FD",
        "UNIT:STA71",
        "CH:33.90",
        "CALL:HOT WATER HEATER  Smoke in the Building",
        "ADDR:18 WEEKS RD",
        "CITY:Eastford",
        "X:WESTFORD RD / CRYSTAL POND RD",
        "TIME:13:26");

    doTest("T3",
        "(Eastford FD Page) STA77 STA71  UNION 453 / CALL FROM 50 HOPKINS RD /  Smoke/Odor Investigation 501 PERRIN RD / Woodstock (X-STS HOPKINS RD, ROCKY HILL RD / OLD COLONY RD ) 07:54",
        "SRC:Eastford FD",
        "UNIT:STA77 STA71",
        "CH:UNION 453",
        "CALL:CALL FROM 50 HOPKINS RD /  Smoke/Odor Investigation",
        "ADDR:501 PERRIN RD",
        "CITY:Woodstock",
        "X:HOPKINS RD, ROCKY HILL RD / OLD COLONY RD",
        "TIME:07:54");

    doTest("T4",
        "(Eastford FD Page) QVMedic1 STA71 R520  33.88 PRI 1 Difficulty Breathing 76 COUNTY RD / WHITCRAFT DOCK 5 Eastford (X-STS MILL BRIDGE RD / BARLOW CEMETERY RD ) 07:53",
        "SRC:Eastford FD",
        "UNIT:QVMedic1 STA71 R520",
        "CH:33.88",
        "PRI:1",
        "CALL:Difficulty Breathing",
        "ADDR:76 COUNTY RD",
        "PLACE:WHITCRAFT DOCK 5",
        "CITY:Eastford",
        "X:MILL BRIDGE RD / BARLOW CEMETERY RD",
        "TIME:07:53");

    doTest("T5",
        "(Eastford FD Page) STA71 STA70 R520  33.90 REKINDLE FROM PREVIOUS GARAGE FIRE Structure Fire 195 PILFERSHIRE RD / Eastford (X-STS KINGSBURY RD / DEAD END ) 18:31",
        "SRC:Eastford FD",
        "UNIT:STA71 STA70 R520",
        "CH:33.90",
        "CALL:REKINDLE FROM PREVIOUS GARAGE FIRE Structure Fire",
        "ADDR:195 PILFERSHIRE RD",
        "CITY:Eastford",
        "X:KINGSBURY RD / DEAD END",
        "TIME:18:31");

    doTest("T6",
        "(Eastford FD Page) STA71 R520  33.88 PRI 1 known diabetic/abdominal distress/ Sick Person 181 WESTFORD RD / Eastford (X-STS ASHFORD RD / CRYSTAL POND RD ) 15:31",
        "SRC:Eastford FD",
        "UNIT:STA71 R520",
        "CH:33.88",
        "PRI:1",
        "CALL:known diabetic/abdominal distress/ Sick Person",
        "ADDR:181 WESTFORD RD",
        "CITY:Eastford",
        "X:ASHFORD RD / CRYSTAL POND RD",
        "TIME:15:31");

    doTest("T7",
        "(Eastford FD Page) STA71 R520  33.88 PRI 1 Headache as result of fall/67 y/o female/ Medical Alarm 181 WESTFORD RD / Eastford (X-STS ASHFORD RD / CRYSTAL POND RD ) 18:38",
        "SRC:Eastford FD",
        "UNIT:STA71 R520",
        "CH:33.88",
        "PRI:1",
        "CALL:Headache as result of fall/67 y/o female/ Medical Alarm",
        "ADDR:181 WESTFORD RD",
        "CITY:Eastford",
        "X:ASHFORD RD / CRYSTAL POND RD",
        "TIME:18:38");

    doTest("T8",
        "(Eastford FD Page) STA71 STA70 R520  33.90 Structure Fire 195 PILFERSHIRE RD / Eastford (X-STS KINGSBURY RD / DEAD END ) 22:05",
        "SRC:Eastford FD",
        "UNIT:STA71 STA70 R520",
        "CH:33.90",
        "CALL:Structure Fire",
        "ADDR:195 PILFERSHIRE RD",
        "CITY:Eastford",
        "X:KINGSBURY RD / DEAD END",
        "TIME:22:05");

    doTest("T9",
        "(Eastford FD Page) STA71 R520  33.88 PRI 1 Abdominal Pain 54 WESTFORD RD / Eastford (X-STS WEEKS RD / CHURCH RD ) 12:52",
        "SRC:Eastford FD",
        "UNIT:STA71 R520",
        "CH:33.88",
        "PRI:1",
        "CALL:Abdominal Pain",
        "ADDR:54 WESTFORD RD",
        "CITY:Eastford",
        "X:WEEKS RD / CHURCH RD",
        "TIME:12:52");

    doTest("T10",
        "(Eastford FD Page) STA71 R520  33.88 PRI 2 police on scene Mental Disorder 211 EASTFORD RD / Eastford (X-STS WESTFORD RD, OLD COLONY RD / ROUTE 198 ) 13:03",
        "SRC:Eastford FD",
        "UNIT:STA71 R520",
        "CH:33.88",
        "PRI:2",
        "CALL:police on scene Mental Disorder",
        "ADDR:211 EASTFORD RD",
        "CITY:Eastford",
        "X:WESTFORD RD, OLD COLONY RD / ROUTE 198",
        "TIME:13:03");
   
  }
  
  @Test
  public void testBungayFireBrigade() {

    doTest("T1",
        "(Bungay FD Page) QVMedic1 STA77 STA576 WOOD1  UNION 453 PRI 1 intersection of 197/198/ Vehicle Accident 1711 ROUTE 197 / Woodstock (X-STS HERINDEEN LDG / ROUTE 198 ) 12:07",
        "SRC:Bungay FD",
        "UNIT:QVMedic1 STA77 STA576 WOOD1",
        "CH:UNION 453",
        "PRI:1",
        "CALL:intersection of 197/198/ Vehicle Accident",
        "ADDR:1711 ROUTE 197",
        "CITY:Woodstock",
        "X:HERINDEEN LDG / ROUTE 198",
        "TIME:12:07");

    doTest("T2",
        "(Bungay FD Page) STA77 STA576 WOOD1  UNION 453 PRI 1 POWER SAW INJURY TO HAND Injured Person 334 BRICKYARD RD / Woodstock (X-STS CHILD RD / REDHEAD HILL RD ) 14:57",
        "SRC:Bungay FD",
        "UNIT:STA77 STA576 WOOD1",
        "CH:UNION 453",
        "PRI:1",
        "CALL:POWER SAW INJURY TO HAND Injured Person",
        "ADDR:334 BRICKYARD RD",
        "CITY:Woodstock",
        "X:CHILD RD / REDHEAD HILL RD",
        "TIME:14:57");

    doTest("T3",
        "(Bungay FD Page) STA77  UNION 453 1 ET TO COVER STA 71 Misc 6 WESTFORD RD / Eastford (X-STS EASTFORD RD, OLD COLONY RD / JOHN PERRY RD ) 14:04",
        "SRC:Bungay FD",
        "UNIT:STA77",
        "CH:UNION 453",
        "CALL:1 ET TO COVER STA",
        "ADDR:71 Misc 6 WESTFORD RD",
        "CITY:Eastford",
        "X:EASTFORD RD, OLD COLONY RD / JOHN PERRY RD",
        "TIME:14:04");

    doTest("T4",
        "(Bungay FD Page) STA77 STA576 WOOD1  UNION 453 PRI 2 meet state police Injured Person 6 VALLEY VIEW RD / Woodstock (X-STS LYON RD / SPRING HILL RD ) 10:07",
        "SRC:Bungay FD",
        "UNIT:STA77 STA576 WOOD1",
        "CH:UNION 453",
        "PRI:2",
        "CALL:meet state police Injured Person",
        "ADDR:6 VALLEY VIEW RD",
        "CITY:Woodstock",
        "X:LYON RD / SPRING HILL RD",
        "TIME:10:07");

    doTest("T5",
        "(Bungay FD Page) QVMedic1 STA77 STA576 WOOD1  UNION 453 PRI 1 TONGUE SWELLING / 5 YO Allergic Reaction 251 SMITH RD / Woodstock (X-STS ROCKY HILL RD / ROUTE 171 ) 20:56",
        "SRC:Bungay FD",
        "UNIT:QVMedic1 STA77 STA576 WOOD1",
        "CH:UNION 453",
        "PRI:1",
        "CALL:TONGUE SWELLING / 5 YO Allergic Reaction",
        "ADDR:251 SMITH RD",
        "CITY:Woodstock",
        "X:ROCKY HILL RD / ROUTE 171",
        "TIME:20:56");

    doTest("T6",
        "(Bungay FD Page) STA76 STA77  UNION 453 Sta-76 for L-176  Chimney Fire 32 VALLEY VIEW RD / Woodstock (X-STS LYON RD / SPRING HILL RD ) 17:52",
        "SRC:Bungay FD",
        "UNIT:STA76 STA77",
        "CH:UNION 453",
        "CALL:Sta-76 for L-176  Chimney Fire",
        "ADDR:32 VALLEY VIEW RD",
        "CITY:Woodstock",
        "X:LYON RD / SPRING HILL RD",
        "TIME:17:52");

    doTest("T7",
        "(Bungay FD Page) STA77  UNION 453 WATER IN BASEMENT Service Call 100 BRADFORD CORNER RD / Woodstock (X-STS HEREFORD LN / PERRIN RD, ROUTE 171 ) 10:52",
        "SRC:Bungay FD",
        "UNIT:STA77",
        "CH:UNION 453",
        "CALL:WATER IN BASEMENT Service Call",
        "ADDR:100 BRADFORD CORNER RD",
        "CITY:Woodstock",
        "X:HEREFORD LN / PERRIN RD, ROUTE 171",
        "TIME:10:52");

    doTest("T8",
        "(Bungay FD Page) STA77 STA576 WOOD1  UNION 453 PRI 1 Accidental Lac from Box Cutter /  Injured Person 1026 ROUTE 171 / Woodstock (X-STS SHIELDS RD, COATNEY HILL RD / SMITH RD ) 14:44",
        "SRC:Bungay FD",
        "UNIT:STA77 STA576 WOOD1",
        "CH:UNION 453",
        "PRI:1",
        "CALL:Accidental Lac from Box Cutter /  Injured Person",
        "ADDR:1026 ROUTE 171",
        "CITY:Woodstock",
        "X:SHIELDS RD, COATNEY HILL RD / SMITH RD",
        "TIME:14:44");

    doTest("T9",
        "(Bungay FD Page) STA77 STA576 WOOD1  UNION 453 PRI 1 No contact with Subscriber /  Medical Alarm 41 RED CEDAR RD / Woodstock (X-STS MAPLE WOOD DR / LYON RD ) 13:43",
        "SRC:Bungay FD",
        "UNIT:STA77 STA576 WOOD1",
        "CH:UNION 453",
        "PRI:1",
        "CALL:No contact with Subscriber / Medical Alarm",
        "ADDR:41 RED CEDAR RD",
        "CITY:Woodstock",
        "X:MAPLE WOOD DR / LYON RD",
        "TIME:13:43");

    doTest("T10",
        "(Bungay FD Page) QVMedic1 STA77 STA576 WOOD1  UNION 453 PRI 1 Cardiac Distress 38 LYON RD / Woodstock (X-STS RED CEDAR RD / HEMLOCK DR ) 13:42",
        "SRC:Bungay FD",
        "UNIT:QVMedic1 STA77 STA576 WOOD1",
        "CH:UNION 453",
        "PRI:1",
        "CALL:Cardiac Distress",
        "ADDR:38 LYON RD",
        "CITY:Woodstock",
        "X:RED CEDAR RD / HEMLOCK DR",
        "TIME:13:42");

  }
  
  public static void main(String[] args) {
    new CTWindhamCountyAParserTest().generateTests("T1");
  }
}