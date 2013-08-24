package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Columbiana County, OH
Contact: nightrh@att.net <nightrh@att.net>
Sender: leetoniafd@hotmail.com

\n\n\n\nCarbon monoxide detector going off 3362 St. Rt. 164 Everyone out 2-28-13 00:56 hrs            \n
Fire 40266 St. Rt 558 Subjects can see a lg. fire somewhere behind their back field (possibly between Leet Rd & Crestview Rd.) 3-2-13 2115hrs 
MVA Lisbon rd/ St Jacob logtown rd MVA with Injury was Adv DOA 3-3-13 2200hrs    Leetonia ohio columbiana county
Blood in Urine 740 Stocking St., WV 80 yr MS blood in urine 2-28-13 1007hrs    Washingtonville ohio columbiana county
Carbon monoxide detector going off 3362 St. Rt. 164 Everyone out 2-28-13 00:56 hrs  Leetonia ohio columbiana county 
Possiable Structure Fire 170 Chris Ave., Green Contacted us and said there is heavy smoke 3/2/2013 955hrs     Washingtonville ohio        
Check a head injury 211 Main St., MS was hit in head with a 2X4 would like checked no lights/sirens 3-4-13 Leetonia ohio columbiana county            
1 Car MVA  5455 SR 45 car hit telephone pole 3-18-13 columbiana county salem twp              
1 car MVA  3771 Lisbon-Canfield Rd.,  car slid off roadway has a 1yr old & newborn inside columbiana county salem twp               
M/S Unkown medical 255 E Main St. WV 3/17/13 16:34 hrs. columbiana county side  Washingtonville               

Contact: Active911
Agency name: St. Clair Fire
Location: East Liverpool, OH, United States
Sender: messaging@emergencysmc.com

(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nPossible Structure Fire with liverpool TWP\nDresdon Ave next to MOtor lodge
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nCarbon Monoxide Detector Going Off\n16150 Martha St
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nLift Assist\n15578 East Liverpool Road 
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nStucture Fire \n44878 Bloomfield Rd\nEveryone is out of the house
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nLines ontop of truck\nbehind the Goodwill / Dunham Plaza St Rt 170
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nstation 11 is requesting mutual aide for a fire on the corner of sprucevale road and pancake clarkson
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTesting\n\n15390 Pugh Rd
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\ntesting per Dave McCoy\n15390 Pugh Rd
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nLife Alert Requested FD for Lift assist -\n15390 Puch Rd Apt 12\nKey is in the office - women fell out of chair\nno injuries
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nGarage Fire\n49167 Eagle Dr\nTurkcana Dr
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTree Down / Candle Street off of Shadyside / Request per Station 8
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nHeavy Reports of Black Smoke \nMc Guffy Drive\nSoccor fields
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nSOME TYPE OF ILLEGAL BURN ON MARTHA ST GIVING OUT BLACK SMOKE
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nOil Dry and Flush \nST Rt 170 Front of Dunhams
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nsmoke alarm \nCrossroads Assisted Living\n13280 Echo Dell Road
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nAnnsley Road / Tree blocking the road\nAnnsley towards Campground
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nInvestigatoin of Low Wire\n49150 Calcutta Smithferry Rd\nFour Seasons Minimart
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTesting Fire Alarm System at 16280 Dresden Ave until 12:00
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTrash Can on fire\nJC Pennies
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nShed On Fire \n140 Fredericktown Rd
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTree Down \nGrimms Bridge Rd \nJust past dump 
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTree Down\nGrimms Bridge Rd\nJust past dump
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\npossible house fire \nsidehill road off of East Liverpool road
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nStructure Fire \nright by Dixonville FD
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nPossible Stucture Fire \nPark Way\nOff of Foresyth Mutual aid Liverpool TWP. 
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nMVA ROLLOVER CALCUTTA SMITH FERRY RD BUTTOM OF BIG HILL
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nMVA ROLL OVER CALCUTTA SMITH FERRY RD AT BOTTOM OF BIG HILL
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\npublic serivce call 48735 bloomfeild rd : call dispatch for information.
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTest the system\n16356 State Route 267
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTest\nText late due to computer malfunction
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nMVA Roll Over \nRoute 11 North Bound \nBetween Calcutta and Rogers close to OS hill
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nnegley is requesting tanker\n47943 tomahawk drive\nfor a structure fire
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nPossible Car fire\nBerkshire Rd
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nFire alarm \nEl paso
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nMVA \nFredricktown State Route 170\nno Injuries Telephone pole snapped
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nNeed road flushed\nMVA on 170\nIn front of Post office
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nSMOKE INVESTGATION\n50642 CALCUTTA SMITH-FERRY RD\nLARGE AMOUNT OF SMOKE.
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTanker on fire\nRt 11 Nort h just before Calcutta Exit
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nLongs Church On Longs Run Church Rd of of Calcutta Smith Ferry Rd. Light Balist on fire
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nLanding Zone STAT MedEvac \ncalcutta fire station\nfor north star
(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nLift Assist\n15415 Summit Drive\nWomen fell just need assistance getting up

*/

public class OHColumbianaCountyParserTest extends BaseParserTest {
  
  public OHColumbianaCountyParserTest() {
    setParser(new OHColumbianaCountyParser(), "COLUMBIANA COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "\n\n\n\nCarbon monoxide detector going off 3362 St. Rt. 164 Everyone out 2-28-13 00:56 hrs            \n",
        "CALL:Carbon monoxide detector going off",
        "ADDR:3362 St Rt 164",
        "MADDR:3362 OH 164",
        "DATE:2/28/13",
        "TIME:00:56",
        "INFO:Everyone out");

    doTest("T2",
        "Fire 40266 St. Rt 558 Subjects can see a lg. fire somewhere behind their back field (possibly between Leet Rd & Crestview Rd.) 3-2-13 2115hrs ",
        "CALL:Fire",
        "ADDR:40266 St Rt 558",
        "MADDR:40266 OH 558",
        "DATE:3/2/13",
        "TIME:21:15",
        "INFO:Subjects can see a lg. fire somewhere behind their back field (possibly between Leet Rd & Crestview Rd.)");

    doTest("T3",
        "MVA Lisbon rd/ St Jacob logtown rd MVA with Injury was Adv DOA 3-3-13 2200hrs    Leetonia ohio columbiana county",
        "CALL:MVA",
        "ADDR:Lisbon rd & St Jacob logtown rd",
        "DATE:3/3/13",
        "TIME:22:00",
        "INFO:MVA with Injury was Adv DOA",
        "CITY:Leetonia");

    doTest("T4",
        "Blood in Urine 740 Stocking St., WV 80 yr MS blood in urine 2-28-13 1007hrs    Washingtonville ohio columbiana county",
        "CALL:Blood in Urine",
        "ADDR:740 Stocking St",
        "DATE:2/28/13",
        "TIME:10:07",
        "INFO:WV 80 yr MS blood in urine",
        "CITY:Washingtonville");

    doTest("T5",
        "Carbon monoxide detector going off 3362 St. Rt. 164 Everyone out 2-28-13 00:56 hrs  Leetonia ohio columbiana county ",
        "CALL:Carbon monoxide detector going off",
        "ADDR:3362 St Rt 164",
        "MADDR:3362 OH 164",
        "DATE:2/28/13",
        "TIME:00:56",
        "INFO:Everyone out",
        "CITY:Leetonia");

    doTest("T6",
        "Possiable Structure Fire 170 Chris Ave., Green Contacted us and said there is heavy smoke 3/2/2013 955hrs     Washingtonville ohio        ",
        "CALL:Possiable Structure Fire",
        "ADDR:170 Chris Ave",
        "DATE:3/2/2013",
        "TIME:9:55",
        "INFO:Green Contacted us and said there is heavy smoke",
        "CITY:Washingtonville");

    doTest("T7",
        "Check a head injury 211 Main St., MS was hit in head with a 2X4 would like checked no lights/sirens 3-4-13 Leetonia ohio columbiana county            ",
        "CALL:Check a head injury",
        "ADDR:211 Main St",
        "DATE:3/4/13",
        "INFO:MS was hit in head with a 2X4 would like checked no lights/sirens",
        "CITY:Leetonia");

    doTest("T8",
        "1 Car MVA  5455 SR 45 car hit telephone pole 3-18-13 columbiana county salem twp              ",
        "CALL:1 Car MVA",
        "ADDR:5455 SR 45",
        "MADDR:5455 OH 45",
        "DATE:3/18/13",
        "INFO:car hit telephone pole",
        "CITY:salem twp");

    doTest("T9",
        "1 car MVA  3771 Lisbon-Canfield Rd.,  car slid off roadway has a 1yr old & newborn inside columbiana county salem twp               ",
        "CALL:1 car MVA",
        "ADDR:3771 Lisbon-Canfield Rd",
        "X:car slid off roadway has a 1yr old & newborn inside",
        "CITY:salem twp");

    doTest("T10",
        "M/S Unkown medical 255 E Main St. WV 3/17/13 16:34 hrs. columbiana county side  Washingtonville               ",
        "CALL:M/S Unkown medical",
        "ADDR:255 E Main St",
        "DATE:3/17/13",
        "TIME:16:34",
        "INFO:WV . columbiana county side Washingtonville");

  }
  
  @Test
  public void testStClairFire() {

    doTest("T1",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\n" +
        "Possible Structure Fire with liverpool TWP\n" +
        "Dresdon Ave next to MOtor lodge",

        "SRC:Saint Clair Fire",
        "CALL:Possible Structure Fire with liverpool TWP",
        "ADDR:Dresdon Ave",
        "INFO:next to MOtor lodge");

    doTest("T2",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nCarbon Monoxide Detector Going Off\n16150 Martha St",
        "SRC:Saint Clair Fire",
        "CALL:Carbon Monoxide Detector Going Off",
        "ADDR:16150 Martha St");

    doTest("T3",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nLift Assist\n15578 East Liverpool Road ",
        "SRC:Saint Clair Fire",
        "CALL:Lift Assist",
        "ADDR:15578 East Liverpool Road");

    doTest("T4",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nStucture Fire \n44878 Bloomfield Rd\nEveryone is out of the house",
        "SRC:Saint Clair Fire",
        "CALL:Stucture Fire",
        "ADDR:44878 Bloomfield Rd",
        "INFO:Everyone is out of the house");

    doTest("T5",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nLines ontop of truck\nbehind the Goodwill / Dunham Plaza St Rt 170",
        "SRC:Saint Clair Fire",
        "CALL:Lines ontop of truck",
        "ADDR:behind the Goodwill & Dunham Plaza St Rt 170",
        "MADDR:behind the Goodwill & Dunham Plaza OH 170");

    doTest("T6",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\n" +
        "station 11 is requesting mutual aide for a fire on the corner of sprucevale road and pancake clarkson",

        "SRC:Saint Clair Fire",
        "CALL:station 11 is requesting mutual aide for a fire on the corner of",
        "ADDR:sprucevale road",
        "INFO:and pancake clarkson");

    doTest("T7",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTesting\n\n15390 Pugh Rd",
        "SRC:Saint Clair Fire",
        "CALL:Testing",
        "ADDR:15390 Pugh Rd");

    doTest("T8",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\ntesting per Dave McCoy\n15390 Pugh Rd",
        "SRC:Saint Clair Fire",
        "CALL:testing per Dave McCoy",
        "ADDR:15390 Pugh Rd");

    doTest("T9",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\n" +
        "Life Alert Requested FD for Lift assist -\n" +
        "15390 Puch Rd Apt 12\n" +
        "Key is in the office - women fell out of chair\n" +
        "no injuries",

        "SRC:Saint Clair Fire",
        "CALL:Life Alert Requested FD for Lift assist -",
        "ADDR:15390 Puch Rd",
        "APT:12",
        "INFO:Key is in the office - women fell out of chair / no injuries");

    doTest("T10",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nGarage Fire\n49167 Eagle Dr\nTurkcana Dr",
        "SRC:Saint Clair Fire",
        "CALL:Garage Fire",
        "ADDR:49167 Eagle Dr", // Not mapping
        "X:Turkcana Dr");

    doTest("T11",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\n" +
        "Tree Down / Candle Street off of Shadyside / Request per Station 8",

        "SRC:Saint Clair Fire",
        "CALL:Tree Down /",
        "ADDR:Candle Street",
        "INFO:off of Shadyside / Request per Station 8");

    doTest("T12",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nHeavy Reports of Black Smoke \nMc Guffy Drive\nSoccor fields",
        "SRC:Saint Clair Fire",
        "CALL:Heavy Reports of Black Smoke",
        "ADDR:Mc Guffy Drive",
        "INFO:Soccor fields");

    doTest("T13",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nSOME TYPE OF ILLEGAL BURN ON MARTHA ST GIVING OUT BLACK SMOKE",
        "SRC:Saint Clair Fire",
        "CALL:SOME TYPE OF ILLEGAL BURN ON",
        "ADDR:MARTHA ST",
        "INFO:GIVING OUT BLACK SMOKE");

    doTest("T14",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nOil Dry and Flush \nST Rt 170 Front of Dunhams",
        "SRC:Saint Clair Fire",
        "CALL:Oil Dry and Flush",
        "ADDR:ST Rt 170",
        "MADDR:OH 170",
        "INFO:Front of Dunhams");

    doTest("T15",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nsmoke alarm \nCrossroads Assisted Living\n13280 Echo Dell Road",
        "SRC:Saint Clair Fire",
        "CALL:smoke alarm",
        "PLACE:Crossroads Assisted Living",
        "ADDR:13280 Echo Dell Road");

    doTest("T16",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nAnnsley Road / Tree blocking the road\nAnnsley towards Campground",
        "SRC:Saint Clair Fire",
        "CALL:Annsley Road / Tree blocking the road",
        "ADDR:Annsley towards Campground");

    doTest("T17",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\n" +
        "Investigatoin of Low Wire\n" +
        "49150 Calcutta Smithferry Rd\n" +
        "Four Seasons Minimart",

        "SRC:Saint Clair Fire",
        "CALL:Investigatoin of Low Wire",
        "ADDR:49150 Calcutta Smithferry Rd",
        "INFO:Four Seasons Minimart");

    doTest("T18",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTesting Fire Alarm System at 16280 Dresden Ave until 12:00",
        "SRC:Saint Clair Fire",
        "CALL:Testing Fire Alarm System at",
        "ADDR:16280 Dresden Ave",
        "TIME:12:00",
        "INFO:until");

    doTest("T19",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTrash Can on fire\nJC Pennies",
        "SRC:Saint Clair Fire",
        "CALL:Trash Can on fire",
        "ADDR:JC Pennies");

    doTest("T20",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nShed On Fire \n140 Fredericktown Rd",
        "SRC:Saint Clair Fire",
        "CALL:Shed On Fire",
        "ADDR:140 Fredericktown Rd");

    doTest("T21",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTree Down \nGrimms Bridge Rd \nJust past dump ",
        "SRC:Saint Clair Fire",
        "CALL:Tree Down",
        "ADDR:Grimms Bridge Rd",
        "INFO:Just past dump");

    doTest("T22",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTree Down\nGrimms Bridge Rd\nJust past dump",
        "SRC:Saint Clair Fire",
        "CALL:Tree Down",
        "ADDR:Grimms Bridge Rd",
        "INFO:Just past dump");

    doTest("T23",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\npossible house fire \nsidehill road off of East Liverpool road",
        "SRC:Saint Clair Fire",
        "CALL:possible house fire",
        "ADDR:sidehill road off of East Liverpool road",
        "MADDR:sidehill road & of East Liverpool road");

    doTest("T24",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nStructure Fire \nright by Dixonville FD",
        "SRC:Saint Clair Fire",
        "CALL:Structure Fire",
        "ADDR:right by Dixonville FD");

    doTest("T25",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\n" +
        "Possible Stucture Fire \n" +
        "Park Way\n" +
        "Off of Foresyth Mutual aid Liverpool TWP. ",

        "SRC:Saint Clair Fire",
        "CALL:Possible Stucture Fire",
        "ADDR:Park Way",
        "INFO:Off of Foresyth Mutual aid Liverpool TWP.");

    doTest("T26",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nMVA ROLLOVER CALCUTTA SMITH FERRY RD BUTTOM OF BIG HILL",
        "SRC:Saint Clair Fire",
        "CALL:MVA ROLLOVER",
        "ADDR:CALCUTTA SMITH FERRY RD",
        "INFO:BUTTOM OF BIG HILL");

    doTest("T27",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nMVA ROLL OVER CALCUTTA SMITH FERRY RD AT BOTTOM OF BIG HILL",
        "SRC:Saint Clair Fire",
        "CALL:MVA ROLL OVER",
        "ADDR:CALCUTTA SMITH FERRY RD",
        "INFO:AT BOTTOM OF BIG HILL");

    doTest("T28",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\n" +
        "public serivce call 48735 bloomfeild rd : call dispatch for information.",

        "SRC:Saint Clair Fire",
        "CALL:public serivce call",
        "ADDR:48735 bloomfeild rd",
        "INFO:: call dispatch for information.");

    doTest("T29",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTest the system\n16356 State Route 267",
        "SRC:Saint Clair Fire",
        "CALL:Test the system",
        "ADDR:16356 State Route 267",
        "MADDR:16356 STATE 267");

    doTest("T30",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTest\nText late due to computer malfunction",
        "SRC:Saint Clair Fire",
        "CALL:Test",
        "ADDR:Text late due to computer malfunction");

    doTest("T31",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\n" +
        "MVA Roll Over \n" +
        "Route 11 North Bound \n" +
        "Between Calcutta and Rogers close to OS hill",

        "SRC:Saint Clair Fire",
        "CALL:MVA Roll Over",
        "ADDR:Route 11 North Bound",
        "INFO:Between Calcutta and Rogers close to OS hill");

    doTest("T32",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\n" +
        "negley is requesting tanker\n" +
        "47943 tomahawk drive\n" +
        "for a structure fire",

        "SRC:Saint Clair Fire",
        "CALL:negley is requesting tanker",
        "ADDR:47943 tomahawk drive",
        "INFO:for a structure fire");

    doTest("T33",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nPossible Car fire\nBerkshire Rd",
        "SRC:Saint Clair Fire",
        "CALL:Possible Car fire",
        "ADDR:Berkshire Rd");

    doTest("T34",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nFire alarm \nEl paso",
        "SRC:Saint Clair Fire",
        "CALL:Fire alarm",
        "ADDR:El paso");

    doTest("T35",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\n" +
        "MVA \n" +
        "Fredricktown State Route 170\n" +
        "no Injuries Telephone pole snapped",

        "SRC:Saint Clair Fire",
        "CALL:MVA",
        "ADDR:Fredricktown State Route 170",
        "MADDR:Fredricktown STATE 170",
        "INFO:no Injuries Telephone pole snapped");

    doTest("T36",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nNeed road flushed\nMVA on 170\nIn front of Post office",
        "SRC:Saint Clair Fire",
        "CALL:Need road flushed",
        "ADDR:MVA on 170",
        "INFO:In front of Post office");

    doTest("T37",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\n" +
        "SMOKE INVESTGATION\n" +
        "50642 CALCUTTA SMITH-FERRY RD\n" +
        "LARGE AMOUNT OF SMOKE.",

        "SRC:Saint Clair Fire",
        "CALL:SMOKE INVESTGATION",
        "ADDR:50642 CALCUTTA SMITH-FERRY RD",
        "INFO:LARGE AMOUNT OF SMOKE.");

    doTest("T38",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nTanker on fire\nRt 11 Nort h just before Calcutta Exit",
        "SRC:Saint Clair Fire",
        "CALL:Tanker on fire",
        "ADDR:Rt 11 Nort h",
        "INFO:just before Calcutta Exit");

    doTest("T39",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\n" +
        "Longs Church On Longs Run Church Rd of of Calcutta Smith Ferry Rd. Light Balist on fire",

        "SRC:Saint Clair Fire",
        "CALL:Longs Church On",
        "ADDR:Longs Run",
        "INFO:Church Rd of of Calcutta Smith Ferry Rd. Light Balist on fire");

    doTest("T40",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\nLanding Zone STAT MedEvac \ncalcutta fire station\nfor north star",
        "SRC:Saint Clair Fire",
        "CALL:Landing Zone STAT MedEvac",
        "ADDR:calcutta fire station",
        "INFO:for north star");

    doTest("T41",
        "(GLENMOOR VFD ASSOC.) This email was sent by: Saint Clair Fire\n\n" +
        "Lift Assist\n" +
        "15415 Summit Drive\n" +
        "Women fell just need assistance getting up",

        "SRC:Saint Clair Fire",
        "CALL:Lift Assist",
        "ADDR:15415 Summit Drive",
        "INFO:Women fell just need assistance getting up");
  
  }
  
  public static void main(String[] args) {
    new OHColumbianaCountyParserTest().generateTests("T1");
  }
}