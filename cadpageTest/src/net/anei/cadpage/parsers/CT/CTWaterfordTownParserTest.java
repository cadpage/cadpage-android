package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Waterford Town, CT
Contact: Jason Finnigan <finni94tac@gmail.com>
Dispatched from waterford communications center
Sender: wecc@waterfordct.org

2012-009336*\n16 SCENIC VIEW DRIVE*\n*\n*\nWATERFORD*\n*\nEMS BLS*\nAMBULANCE CALL - BLS*\n*\n*\nCO4*\n*\n*\n*\n*
2012-009419*\nINTERSTATE 395 (X77-MONT)*\n*\n*\nWATERFORD*\n*\nMVA HIGH*\nVEHICLE ACCIDENT - HIGHWAY/SPEED*\n*\n*\n49,CO4,CO5,MED11,W500,W51,W57*\n*\n*\n*\n*
2012-009444*\n14 KINGFISHER WAY*\n*\n*\nWATERFORD*\n*\nCARB MONOX*\nCARBON MONOXIDE INCIDENT*\nNOLDA,ZACH*\n*\nCO1,CO4,W100,W11,W400*\n*\n*\n*\n*
2012-009566*\n16 CENTER STREET*\nB*\n*\nWATERFORD*\n*\nEMS ALS*\nAMBULANCE CALL - ALS*\nDE*SANTO,ROBERT S*\n*\nCO4*\n*\n*\n*\n*
2012-009600*\n45 NORWICH ROAD*\n*\n*\nQUAKER HILL*\n*\nSTRUCTURE*\nSTRUCTURE/BUILDING FIRE*\nCUMBERLAND FARMS*\n*\nCO2,CO4,CO5,W200,W21,W25,W51,W94*\n*\n*\n*\n*
2012-009697*\n277 NIANTIC RIVER ROAD*\n*\n*\nWATERFORD*\n*\nEMS ALS*\nAMBULANCE CALL - ALS*\nBARRY,THOMAS R*\n*\nCO4*\n*\n*\n*\n*
2012-009759*\n14 HIGH RIDGE DRIVE*\n*\n*\nWATERFORD*\n*\nEMS BLS*\nAMBULANCE CALL - BLS*\nRISLEY,R A*\n*\nCO1,CO4,W100,W400*\n*\n*\n*\n*
2012-009851*\n745 VAUXHALL STREET EXTENSION*\n*\n*\nWATERFORD*\n*\nMVA WITH*\nVEHICLE ACCIDENT WITH INJURIES*\nDanielle Chaude*\n*\nCO4,CO5,MED11,W200,W500*\n*\n*\n*\n*
2012-009905*\n563 BOSTON POST ROAD*\n14*\n2*\nWATERFORD*\n*\nEMS ALS*\nAMBULANCE CALL - ALS*\nBlue Anchor*\n*\nCO4*\n*\n*\n*\n*
2012-009851*\n745 VAUXHALL STREET EXTENSION*\n*\n*\nWATERFORD*\n*\nMVA WITH*\nVEHICLE ACCIDENT WITH INJURIES*\nDanielle Chaude*\n*\nCO4,CO5,MED11,W200,W500*\n*\n*\n*\n*

2012-036049*\n 89 BLOOMINGDALE ROAD*\n *\n *\n QUAKER HILL*\n *\n EMS BLS*\n AMBULANCE CALL - BLS*\n *\n 860-447-3334*\n 46,56,CO2,CO4,W21*\n *\n *\n *\n 09/19/2012 19:14:30 : pos2 : MJKNIGHT   Cross streets: GALLOWS LN//APPLEWOOD DR    48 y/o female severely intoxicated*
2012-036209*\n 1 BEECHWOOD DRIVE*\n 321*\n *\n WATERFORD*\n *\n EMS ALS*\n AMBULANCE CALL - ALS*\n *\n 860-439-0352*\n CO4*\n *\n *\n *\n 09/20/2012 20:47:08 : pos2 : MJKNIGHT   Place Comment: UPDATED 06-17-04  Landmark Comment: UPDATE 12/3/2002  Landmark: CROSSROADS PLACE  Cross streets: PARKWAY SOUTH//DEAD END    elderly male fall victim in shower.. approx. 15min ago.. unwitnessed.. unknown LOC. 2nd party call.*
2012-036163*\n 65 ROPE FERRY ROAD*\n *\n *\n WATERFORD*\n *\n MVA SPILL*\n VEHICLE ACCIDENT WITH FUEL SPILL*\n *\n 860-442-2707*\n 35,38,CO1,CO3,CO4,W300*\n *\n *\n *\n 09/20/2012 14:12:02 : pos2 : RKWILLIAMS   W300 RESP. FULL CREW.     09/20/2012 14:06:35 : pos2 : RKWILLIAMS   Cross streets: BOSTON POST ROAD//AVERY LANE  Landmark: WATERFORD HISTORICAL BUILDINGS  Landmark Comment: UPDATED 01/21/05    JONAH STALLER 860-8844170. 2 CAR REAR ENDER ACCIDENT. W/FLUIDS ON THE GROUND*
2012-035924*\n OCEAN // LEE*\n *\n *\n NEW LONDON*\n *\n MUTUAL EMS*\n MUTUAL AID AMBULANCE CALL*\n *\n 860-   -*\n CO1,CO4,W100*\n *\n *\n *\n 09/18/2012 16:43:45 : pos2 : JNOTT   OCEAN // LEE*

Contact: Jared DiPierro <jared.dipierro@gmail.com>
  / 2012-010577* BOSTON POST ROAD* * * WATERFORD* * MVA WITH* VEHICLE ACCIDENT WITH INJURIES* * * CO1,CO4,W100,W11,W400* * * * *\n
2012-015044* 1 BEECHWOOD DRIVE* 106B* * WATERFORD* Place Comment: UPDATED 06-17-04 Landmark Comment: UPDATE 12/3/2002* EMS ALS* AMBULANCE CALL - ALS* ATRIA CROS
  / 2012-014889* 1 BEECHWOOD DRIVE* * * WATERFORD* * EMS ALS* AMBULANCE CALL - ALS* ATRIA CROSSROADS PLACE* * CO4* * * * *\n
  / 2012-023639* 155 WATERFORD PARKWAY NORTH* * * WATERFORD* * EMS ALS* AMBULANCE CALL - ALS* WALMART STORE* * CO4* * * * *\n
2012-036274* 7 BEVERLY ROAD* * * WATERFORD* * EMS ALS* AMBULANCE CALL - ALS* * 860-442-8118* CO4* * * * 09/21/2012 08:06:36 : pos2 : RKWILLIAMS Cross streets: H

*/


public class CTWaterfordTownParserTest extends BaseParserTest {
  
  public CTWaterfordTownParserTest() {
    setParser(new CTWaterfordTownParser(), "WATERFORD TWP", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "2012-009336*\n16 SCENIC VIEW DRIVE*\n*\n*\nWATERFORD*\n*\nEMS BLS*\nAMBULANCE CALL - BLS*\n*\n*\nCO4*\n*\n*\n*\n*",
        "ID:2012-009336",
        "ADDR:16 SCENIC VIEW DRIVE",
        "CITY:WATERFORD",
        "CALL:AMBULANCE CALL - BLS",
        "UNIT:CO4");

    doTest("T2",
        "2012-009419*\n" +
        "INTERSTATE 395 (X77-MONT)*\n" +
        "*\n" +
        "*\n" +
        "WATERFORD*\n" +
        "*\n" +
        "MVA HIGH*\n" +
        "VEHICLE ACCIDENT - HIGHWAY/SPEED*\n" +
        "*\n" +
        "*\n" +
        "49,CO4,CO5,MED11,W500,W51,W57*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*",

        "ID:2012-009419",
        "ADDR:INTERSTATE 395 (X77-MONT)",
        "CITY:WATERFORD",
        "CALL:VEHICLE ACCIDENT - HIGHWAY/SPEED",
        "UNIT:49,CO4,CO5,MED11,W500,W51,W57");

    doTest("T3",
        "2012-009444*\n" +
        "14 KINGFISHER WAY*\n" +
        "*\n" +
        "*\n" +
        "WATERFORD*\n" +
        "*\n" +
        "CARB MONOX*\n" +
        "CARBON MONOXIDE INCIDENT*\n" +
        "NOLDA,ZACH*\n" +
        "*\n" +
        "CO1,CO4,W100,W11,W400*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*",

        "ID:2012-009444",
        "ADDR:14 KINGFISHER WAY",
        "CITY:WATERFORD",
        "CALL:CARBON MONOXIDE INCIDENT",
        "NAME:NOLDA,ZACH",
        "UNIT:CO1,CO4,W100,W11,W400");

    doTest("T4",
        "2012-009566*\n16 CENTER STREET*\nB*\n*\nWATERFORD*\n*\nEMS ALS*\nAMBULANCE CALL - ALS*\nDE*SANTO,ROBERT S*\n*\nCO4*\n*\n*\n*\n*",
        "ID:2012-009566",
        "ADDR:16 CENTER STREET",
        "APT:B",
        "CITY:WATERFORD",
        "CALL:AMBULANCE CALL - ALS",
        "NAME:DE*SANTO,ROBERT S",
        "UNIT:CO4");

    doTest("T5",
        "2012-009600*\n" +
        "45 NORWICH ROAD*\n" +
        "*\n" +
        "*\n" +
        "QUAKER HILL*\n" +
        "*\n" +
        "STRUCTURE*\n" +
        "STRUCTURE/BUILDING FIRE*\n" +
        "CUMBERLAND FARMS*\n" +
        "*\n" +
        "CO2,CO4,CO5,W200,W21,W25,W51,W94*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*",

        "ID:2012-009600",
        "ADDR:45 NORWICH ROAD",
        "CITY:QUAKER HILL",
        "CALL:STRUCTURE/BUILDING FIRE",
        "NAME:CUMBERLAND FARMS",
        "UNIT:CO2,CO4,CO5,W200,W21,W25,W51,W94");

    doTest("T6",
        "2012-009697*\n277 NIANTIC RIVER ROAD*\n*\n*\nWATERFORD*\n*\nEMS ALS*\nAMBULANCE CALL - ALS*\nBARRY,THOMAS R*\n*\nCO4*\n*\n*\n*\n*",
        "ID:2012-009697",
        "ADDR:277 NIANTIC RIVER ROAD",
        "CITY:WATERFORD",
        "CALL:AMBULANCE CALL - ALS",
        "NAME:BARRY,THOMAS R",
        "UNIT:CO4");

    doTest("T7",
        "2012-009759*\n14 HIGH RIDGE DRIVE*\n*\n*\nWATERFORD*\n*\nEMS BLS*\nAMBULANCE CALL - BLS*\nRISLEY,R A*\n*\nCO1,CO4,W100,W400*\n*\n*\n*\n*",
        "ID:2012-009759",
        "ADDR:14 HIGH RIDGE DRIVE",
        "CITY:WATERFORD",
        "CALL:AMBULANCE CALL - BLS",
        "NAME:RISLEY,R A",
        "UNIT:CO1,CO4,W100,W400");

    doTest("T8",
        "2012-009851*\n" +
        "745 VAUXHALL STREET EXTENSION*\n" +
        "*\n" +
        "*\n" +
        "WATERFORD*\n" +
        "*\n" +
        "MVA WITH*\n" +
        "VEHICLE ACCIDENT WITH INJURIES*\n" +
        "Danielle Chaude*\n" +
        "*\n" +
        "CO4,CO5,MED11,W200,W500*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*",

        "ID:2012-009851",
        "ADDR:745 VAUXHALL STREET EXTENSION",
        "CITY:WATERFORD",
        "CALL:VEHICLE ACCIDENT WITH INJURIES",
        "NAME:Danielle Chaude",
        "UNIT:CO4,CO5,MED11,W200,W500");

    doTest("T9",
        "2012-009905*\n563 BOSTON POST ROAD*\n14*\n2*\nWATERFORD*\n*\nEMS ALS*\nAMBULANCE CALL - ALS*\nBlue Anchor*\n*\nCO4*\n*\n*\n*\n*",
        "ID:2012-009905",
        "ADDR:563 BOSTON POST ROAD",
        "APT:14-2",
        "CITY:WATERFORD",
        "CALL:AMBULANCE CALL - ALS",
        "NAME:Blue Anchor",
        "UNIT:CO4");

    doTest("T10",
        "2012-009851*\n" +
        "745 VAUXHALL STREET EXTENSION*\n" +
        "*\n" +
        "*\n" +
        "WATERFORD*\n" +
        "*\n" +
        "MVA WITH*\n" +
        "VEHICLE ACCIDENT WITH INJURIES*\n" +
        "Danielle Chaude*\n" +
        "*\n" +
        "CO4,CO5,MED11,W200,W500*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*",

        "ID:2012-009851",
        "ADDR:745 VAUXHALL STREET EXTENSION",
        "CITY:WATERFORD",
        "CALL:VEHICLE ACCIDENT WITH INJURIES",
        "NAME:Danielle Chaude",
        "UNIT:CO4,CO5,MED11,W200,W500");

    doTest("T11",
        "2012-036049*\n" +
        " 89 BLOOMINGDALE ROAD*\n" +
        " *\n" +
        " *\n" +
        " QUAKER HILL*\n" +
        " *\n" +
        " EMS BLS*\n" +
        " AMBULANCE CALL - BLS*\n" +
        " *\n" +
        " 860-447-3334*\n" +
        " 46,56,CO2,CO4,W21*\n" +
        " *\n" +
        " *\n" +
        " *\n" +
        " 09/19/2012 19:14:30 : pos2 : MJKNIGHT   Cross streets: GALLOWS LN//APPLEWOOD DR    48 y/o female severely intoxicated*",

        "ID:2012-036049",
        "ADDR:89 BLOOMINGDALE ROAD",
        "CITY:QUAKER HILL",
        "INFO:48 y/o female severely intoxicated",
        "CALL:AMBULANCE CALL - BLS",
        "PHONE:860-447-3334",
        "UNIT:46,56,CO2,CO4,W21",
        "DATE:09/19/2012",
        "TIME:19:14:30",
        "CH:pos2",
        "X:GALLOWS LN / APPLEWOOD DR");

    doTest("T12",
        "2012-036209*\n" +
        " 1 BEECHWOOD DRIVE*\n" +
        " 321*\n" +
        " *\n" +
        " WATERFORD*\n" +
        " *\n" +
        " EMS ALS*\n" +
        " AMBULANCE CALL - ALS*\n" +
        " *\n" +
        " 860-439-0352*\n" +
        " CO4*\n" +
        " *\n" +
        " *\n" +
        " *\n" +
        " 09/20/2012 20:47:08 : pos2 : MJKNIGHT   Place Comment: UPDATED 06-17-04  Landmark Comment: UPDATE 12/3/2002  Landmark: CROSSROADS PLACE  Cross streets: PARKWAY SOUTH//DEAD END    elderly male fall victim in shower.. approx. 15min ago.. unwitnessed.. unknown LOC. 2nd party call.*",

        "ID:2012-036209",
        "ADDR:1 BEECHWOOD DRIVE",
        "APT:321",
        "CITY:WATERFORD",
        "INFO:Place Comment: UPDATED 06-17-04 / UPDATE 12/3/2002 / elderly male fall victim in shower.. approx. 15min ago.. unwitnessed.. unknown LOC. 2nd party call.",
        "CALL:AMBULANCE CALL - ALS",
        "PLACE:CROSSROADS PLACE",
        "PHONE:860-439-0352",
        "UNIT:CO4",
        "DATE:09/20/2012",
        "TIME:20:47:08",
        "CH:pos2",
        "X:PARKWAY SOUTH / DEAD END");

    doTest("T13",
        "2012-036163*\n" +
        " 65 ROPE FERRY ROAD*\n" +
        " *\n" +
        " *\n" +
        " WATERFORD*\n" +
        " *\n" +
        " MVA SPILL*\n" +
        " VEHICLE ACCIDENT WITH FUEL SPILL*\n" +
        " *\n" +
        " 860-442-2707*\n" +
        " 35,38,CO1,CO3,CO4,W300*\n" +
        " *\n" +
        " *\n" +
        " *\n" +
        " 09/20/2012 14:12:02 : pos2 : RKWILLIAMS   W300 RESP. FULL CREW.     09/20/2012 14:06:35 : pos2 : RKWILLIAMS   Cross streets: BOSTON POST ROAD//AVERY LANE  Landmark: WATERFORD HISTORICAL BUILDINGS  Landmark Comment: UPDATED 01/21/05    JONAH STALLER 860-8844170. 2 CAR REAR ENDER ACCIDENT. W/FLUIDS ON THE GROUND*",

        "ID:2012-036163",
        "ADDR:65 ROPE FERRY ROAD",
        "CITY:WATERFORD",
        "INFO:W300 RESP. FULL CREW. / UPDATED 01/21/05 / JONAH STALLER 860-8844170. 2 CAR REAR ENDER ACCIDENT. W/FLUIDS ON THE GROUND",
        "CALL:VEHICLE ACCIDENT WITH FUEL SPILL",
        "PLACE:WATERFORD HISTORICAL BUILDINGS",
        "PHONE:860-442-2707",
        "UNIT:35,38,CO1,CO3,CO4,W300",
        "DATE:09/20/2012",
        "TIME:14:12:02",
        "CH:pos2",
        "X:BOSTON POST ROAD / AVERY LANE");

    doTest("T14",
        "2012-035924*\n" +
        " OCEAN // LEE*\n" +
        " *\n" +
        " *\n" +
        " NEW LONDON*\n" +
        " *\n" +
        " MUTUAL EMS*\n" +
        " MUTUAL AID AMBULANCE CALL*\n" +
        " *\n" +
        " 860-   -*\n" +
        " CO1,CO4,W100*\n" +
        " *\n" +
        " *\n" +
        " *\n" +
        " 09/18/2012 16:43:45 : pos2 : JNOTT   OCEAN // LEE*",

        "ID:2012-035924",
        "ADDR:OCEAN &  & LEE",
        "CITY:NEW LONDON",
        "INFO:OCEAN // LEE",
        "CALL:MUTUAL AID AMBULANCE CALL",
        "PHONE:860-   -",
        "UNIT:CO1,CO4,W100",
        "DATE:09/18/2012",
        "TIME:16:43:45",
        "CH:pos2");

  }
  
  @Test
  public void testJaredDiPerrio() {

    doTest("T1",
        "  / 2012-010577* BOSTON POST ROAD* * * WATERFORD* * MVA WITH* VEHICLE ACCIDENT WITH INJURIES* * * CO1,CO4,W100,W11,W400* * * * *\n",
        "ID:2012-010577",
        "ADDR:BOSTON POST ROAD",
        "CITY:WATERFORD",
        "CALL:VEHICLE ACCIDENT WITH INJURIES",
        "UNIT:CO1,CO4,W100,W11,W400");

    doTest("T2",
        "2012-015044* 1 BEECHWOOD DRIVE* 106B* * WATERFORD* Place Comment: UPDATED 06-17-04 Landmark Comment: UPDATE 12/3/2002* EMS ALS* AMBULANCE CALL - ALS* ATRIA CROS",
        "ID:2012-015044",
        "ADDR:1 BEECHWOOD DRIVE",
        "APT:106B",
        "CITY:WATERFORD",
        "INFO:Place Comment: UPDATED 06-17-04 Landmark Comment: UPDATE 12/3/2002",
        "CALL:AMBULANCE CALL - ALS",
        "NAME:ATRIA CROS");

    doTest("T3",
        "  / 2012-014889* 1 BEECHWOOD DRIVE* * * WATERFORD* * EMS ALS* AMBULANCE CALL - ALS* ATRIA CROSSROADS PLACE* * CO4* * * * *\n",
        "ID:2012-014889",
        "ADDR:1 BEECHWOOD DRIVE",
        "CITY:WATERFORD",
        "CALL:AMBULANCE CALL - ALS",
        "PLACE:ATRIA CROSSROADS PLACE",
        "UNIT:CO4");

    doTest("T4",
        "  / 2012-023639* 155 WATERFORD PARKWAY NORTH* * * WATERFORD* * EMS ALS* AMBULANCE CALL - ALS* WALMART STORE* * CO4* * * * *\n",
        "ID:2012-023639",
        "ADDR:155 WATERFORD PARKWAY NORTH",
        "CITY:WATERFORD",
        "CALL:AMBULANCE CALL - ALS",
        "NAME:WALMART STORE",
        "UNIT:CO4");

    doTest("T5",
        "2012-036274* 7 BEVERLY ROAD* * * WATERFORD* * EMS ALS* AMBULANCE CALL - ALS* * 860-442-8118* CO4* * * * 09/21/2012 08:06:36 : pos2 : RKWILLIAMS Cross streets: H",
        "ID:2012-036274",
        "ADDR:7 BEVERLY ROAD",
        "CITY:WATERFORD",
        "CALL:AMBULANCE CALL - ALS",
        "PHONE:860-442-8118",
        "UNIT:CO4",
        "DATE:09/21/2012",
        "TIME:08:06:36",
        "CH:pos2",
        "X:H");

  }
  
  public static void main(String[] args) {
    new CTWaterfordTownParserTest().generateTests("T11");
  }
}