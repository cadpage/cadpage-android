package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Waterford Town, CT
Dispatched from waterford communications center
Contact: Jason Finnigan <finni94tac@gmail.com>
Sender: WECC@waterfordct.org

2013-007676*\n1 BEECHWOOD DRIVE*\n322*\n*\nWATERFORD*\nPARKWAY SOUTH*\nDEAD END*\n*\n*\nEMS ALS*\nAMBULANCE CALL - ALS*\n*\n860-326-2178*\nCO4*\n*\nLine16=*\nLine17=*\nLine18=02/23/2013 21:18:05 : pos2 : dlabbey   Place Comment: UPDATED 06-17-04  Landmark Comment: UPDATE 12/3/2002  Landmark: CROSSROADS PLACE  Cross streets: PARKWAY SOUTH//DEAD END  elderly female difficulty breathing*
2013-007726*\n1 BEECHWOOD DRIVE*\n139*\n*\nWATERFORD*\nPARKWAY SOUTH*\nDEAD END*\n*\n*\nEMS ALS*\nAMBULANCE CALL - ALS*\n*\n860-439-0352*\nCO4*\n*\nLine16=*\nLine17=*\nLine18=02/24/2013 04:03:33 : pos2 : dlabbey   Place Comment: UPDATED 06-17-04  Landmark Comment: UPDATE 12/3/2002  Landmark: CROSSROADS PLACE  Cross streets: PARKWAY SOUTH//DEAD END  elderly male chest pain*
2013-007649*\n155 WATERFORD PARKWAY NORTH*\n*\n*\nWATERFORD*\nCROSS ROAD*\nDEAD END*\n*\n*\nMVA WITH*\nVEHICLE ACCIDENT WITH INJURIES*\n*\n860-447-0011*\n52,60,CO4*\n*\nLine16=*\nLine17=*\nLine18=02/23/2013 16:58:54 : pos2 : dlabbey   Landmark Comment: UPDATE 16-25-2002  Landmark: WALMART  Cross streets: CROSS ROAD//DEAD END  car vs pole and van in the parking lot     handi capped parking near the grocery entrance  elderly male laying across the front seat of a toyota*
2013-007462*\n850 HARTFORD ROAD*\n*\n*\nWATERFORD*\nCRYSTAL MALL*\nCRYSTAL MALL*\n*\n*\nFIRE ALARM85*\nROUTE 85 - FIRE ALARM ACTIVATION*\n*\n860-442-0064*\nCO4,CO5,W500,W51,W55*\n*\nLine16=*\nLine17=*\nLine18=02/22/2013 12:09:10 : pos2 : MJKNIGHT   Cross streets: CRYSTAL MALL//CRYSTAL MALL  Landmark: BED BATH AND BEYOND    TYCO int. security 877-238-7739 op.JKZ   fire alarm/smoke det. activation*
2013-007437*\n36 MARY STREET*\n7*\n*\nWATERFORD*\nJEFFERSON AVENUE*\nGILEAD ROAD*\n*\n*\nFIRE ALARM*\nFIRE ALARM ACTIVATION*\n*\n860-   -*\nCO1,CO4,CO5,W11,W51,W55*\n*\nLine16=*\nLine17=*\nLine18=02/22/2013 09:34:00 : pos2 : MJKNIGHT   w55 resp. requesting co 4     02/22/2013 09:31:09 : pos2 : MJKNIGHT   Landmark Comment: UPDATED 12-30-2004  Landmark: TWIN HAVENS ELDERLY HOUSING  Cross streets: JEFFERSON AVENUE//GILEAD ROAD    smoke detector activation*
2013-008108*\n32 SAVI AVENUE*\n*\n*\nWATERFORD*\nTIFFANY AVENUE*\nTIFFANY AVENUE*\n*\n*\nEMS BLS*\nAMBULANCE CALL - BLS*\n*\n860-501-1674*\nCO4,W100*\n*\nLine16=*\nLine17=*\nLine18=02/26/2013 23:45:56 : pos2 : TAGoodhind   ems masterson to scene     02/26/2013 23:43:59 : pos2 : TAGoodhind    Calls 2013-008106,2013-008108 are related.     *

*************************************************
* Obsolete - no longer supported
*************************************************
Contact: Jason Finnigan <finni94tac@gmail.com>
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
2012-038597* 909 HARTFORD ROAD* * * WATERFORD* * MVA WITH* VEHICLE ACCIDENT WITH INJURIES* * 203-511-9577* CO4,CO5,MED11,W51* * * * 10/08/2012 16:22:36 : pos2 :
2012-038730* HARTFORD ROAD // CROSS ROAD* * * WATERFORD* * MVA WITH* VEHICLE ACCIDENT WITH INJURIES* * 203-511-1079* CO4,CO5,MED11,W500* * * * 10/09/2012 21:24:
2012-038697* 165 BOSTON POST ROAD* * * WATERFORD* * SMOKE* SMOKE INVESTIGATION-OUTSIDE OF STRUCTURE* * 860-625-2702* CO1,CO4,W11* * * * 10/09/2012 17:46:19 : po
2012-038597* 909 HARTFORD ROAD* * * WATERFORD* * MVA WITH* VEHICLE ACCIDENT WITH INJURIES* * 203-511-9577* CO4,CO5,MED11,W51* * * * 10/08/2012 16:22:36 : pos2 :
*
*/


public class CTWaterfordTownParserTest extends BaseParserTest {
  
  public CTWaterfordTownParserTest() {
    setParser(new CTWaterfordTownParser(), "WATERFORD TWP", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "2013-007676*\n" +
        "1 BEECHWOOD DRIVE*\n" +
        "322*\n" +
        "*\n" +
        "WATERFORD*\n" +
        "PARKWAY SOUTH*\n" +
        "DEAD END*\n" +
        "*\n" +
        "*\n" +
        "EMS ALS*\n" +
        "AMBULANCE CALL - ALS*\n" +
        "*\n" +
        "860-326-2178*\n" +
        "CO4*\n" +
        "*\n" +
        "Line16=*\n" +
        "Line17=*\n" +
        "Line18=02/23/2013 21:18:05 : pos2 : dlabbey   Place Comment: UPDATED 06-17-04  Landmark Comment: UPDATE 12/3/2002  Landmark: CROSSROADS PLACE  Cross streets: PARKWAY SOUTH//DEAD END  elderly female difficulty breathing*",

        "ID:2013-007676",
        "ADDR:1 BEECHWOOD DRIVE",
        "APT:322",
        "CITY:WATERFORD",
        "X:PARKWAY SOUTH & DEAD END",
        "CALL:AMBULANCE CALL - ALS",
        "PLACE:CROSSROADS PLACE",
        "PHONE:860-326-2178",
        "UNIT:CO4",
        "DATE:02/23/2013",
        "TIME:21:18:05",
        "INFO:elderly female difficulty breathing");

    doTest("T2",
        "2013-007726*\n" +
        "1 BEECHWOOD DRIVE*\n" +
        "139*\n" +
        "*\n" +
        "WATERFORD*\n" +
        "PARKWAY SOUTH*\n" +
        "DEAD END*\n" +
        "*\n" +
        "*\n" +
        "EMS ALS*\n" +
        "AMBULANCE CALL - ALS*\n" +
        "*\n" +
        "860-439-0352*\n" +
        "CO4*\n" +
        "*\n" +
        "Line16=*\n" +
        "Line17=*\n" +
        "Line18=02/24/2013 04:03:33 : pos2 : dlabbey   Place Comment: UPDATED 06-17-04  Landmark Comment: UPDATE 12/3/2002  Landmark: CROSSROADS PLACE  Cross streets: PARKWAY SOUTH//DEAD END  elderly male chest pain*",

        "ID:2013-007726",
        "ADDR:1 BEECHWOOD DRIVE",
        "APT:139",
        "CITY:WATERFORD",
        "X:PARKWAY SOUTH & DEAD END",
        "CALL:AMBULANCE CALL - ALS",
        "PLACE:CROSSROADS PLACE",
        "PHONE:860-439-0352",
        "UNIT:CO4",
        "DATE:02/24/2013",
        "TIME:04:03:33",
        "INFO:elderly male chest pain");

    doTest("T3",
        "2013-007649*\n" +
        "155 WATERFORD PARKWAY NORTH*\n" +
        "*\n" +
        "*\n" +
        "WATERFORD*\n" +
        "CROSS ROAD*\n" +
        "DEAD END*\n" +
        "*\n" +
        "*\n" +
        "MVA WITH*\n" +
        "VEHICLE ACCIDENT WITH INJURIES*\n" +
        "*\n" +
        "860-447-0011*\n" +
        "52,60,CO4*\n" +
        "*\n" +
        "Line16=*\n" +
        "Line17=*\n" +
        "Line18=02/23/2013 16:58:54 : pos2 : dlabbey   Landmark Comment: UPDATE 16-25-2002  Landmark: WALMART  Cross streets: CROSS ROAD//DEAD END  car vs pole and van in the parking lot     handi capped parking near the grocery entrance  elderly male laying across the front seat of a toyota*",

        "ID:2013-007649",
        "ADDR:155 WATERFORD PARKWAY NORTH",
        "CITY:WATERFORD",
        "X:CROSS ROAD & DEAD END",
        "CALL:VEHICLE ACCIDENT WITH INJURIES",
        "PLACE:WALMART",
        "PHONE:860-447-0011",
        "UNIT:52,60,CO4",
        "DATE:02/23/2013",
        "TIME:16:58:54",
        "INFO:car vs pole and van in the parking lot / handi capped parking near the grocery entrance / elderly male laying across the front seat of a toyota");

    doTest("T4",
        "2013-007462*\n" +
        "850 HARTFORD ROAD*\n" +
        "*\n" +
        "*\n" +
        "WATERFORD*\n" +
        "CRYSTAL MALL*\n" +
        "CRYSTAL MALL*\n" +
        "*\n" +
        "*\n" +
        "FIRE ALARM85*\n" +
        "ROUTE 85 - FIRE ALARM ACTIVATION*\n" +
        "*\n" +
        "860-442-0064*\n" +
        "CO4,CO5,W500,W51,W55*\n" +
        "*\n" +
        "Line16=*\n" +
        "Line17=*\n" +
        "Line18=02/22/2013 12:09:10 : pos2 : MJKNIGHT   Cross streets: CRYSTAL MALL//CRYSTAL MALL  Landmark: BED BATH AND BEYOND    TYCO int. security 877-238-7739 op.JKZ   fire alarm/smoke det. activation*",

        "ID:2013-007462",
        "ADDR:850 HARTFORD ROAD",
        "CITY:WATERFORD",
        "X:CRYSTAL MALL & CRYSTAL MALL",
        "CALL:ROUTE 85 - FIRE ALARM ACTIVATION",
        "PLACE:BED BATH AND BEYOND",
        "PHONE:860-442-0064",
        "UNIT:CO4,CO5,W500,W51,W55",
        "DATE:02/22/2013",
        "TIME:12:09:10",
        "INFO:TYCO int. security 877-238-7739 op.JKZ / fire alarm/smoke det. activation");

    doTest("T5",
        "2013-007437*\n" +
        "36 MARY STREET*\n" +
        "7*\n" +
        "*\n" +
        "WATERFORD*\n" +
        "JEFFERSON AVENUE*\n" +
        "GILEAD ROAD*\n" +
        "*\n" +
        "*\n" +
        "FIRE ALARM*\n" +
        "FIRE ALARM ACTIVATION*\n" +
        "*\n" +
        "860-   -*\n" +
        "CO1,CO4,CO5,W11,W51,W55*\n" +
        "*\n" +
        "Line16=*\n" +
        "Line17=*\n" +
        "Line18=02/22/2013 09:34:00 : pos2 : MJKNIGHT   w55 resp. requesting co 4     02/22/2013 09:31:09 : pos2 : MJKNIGHT   Landmark Comment: UPDATED 12-30-2004  Landmark: TWIN HAVENS ELDERLY HOUSING  Cross streets: JEFFERSON AVENUE//GILEAD ROAD    smoke detector activation*",

        "ID:2013-007437",
        "ADDR:36 MARY STREET",
        "APT:7",
        "CITY:WATERFORD",
        "X:JEFFERSON AVENUE & GILEAD ROAD",
        "CALL:FIRE ALARM ACTIVATION",
        "PLACE:TWIN HAVENS ELDERLY HOUSING",
        "PHONE:860-   -",
        "UNIT:CO1,CO4,CO5,W11,W51,W55",
        "DATE:02/22/2013",
        "TIME:09:34:00",
        "INFO:w55 resp. requesting co 4\nsmoke detector activation");

    doTest("T6",
        "2013-008108*\n" +
        "32 SAVI AVENUE*\n" +
        "*\n" +
        "*\n" +
        "WATERFORD*\n" +
        "TIFFANY AVENUE*\n" +
        "TIFFANY AVENUE*\n" +
        "*\n" +
        "*\n" +
        "EMS BLS*\n" +
        "AMBULANCE CALL - BLS*\n" +
        "*\n" +
        "860-501-1674*\n" +
        "CO4,W100*\n" +
        "*\n" +
        "Line16=*\n" +
        "Line17=*\n" +
        "Line18=02/26/2013 23:45:56 : pos2 : TAGoodhind   ems masterson to scene     02/26/2013 23:43:59 : pos2 : TAGoodhind    Calls 2013-008106,2013-008108 are related.     *",

        "ID:2013-008108",
        "ADDR:32 SAVI AVENUE",
        "CITY:WATERFORD",
        "X:TIFFANY AVENUE & TIFFANY AVENUE",
        "CALL:AMBULANCE CALL - BLS",
        "PHONE:860-501-1674",
        "UNIT:CO4,W100",
        "DATE:02/26/2013",
        "TIME:23:45:56",
        "INFO:ems masterson to scene\nCalls 2013-008106,2013-008108 are related.");

  }
  
  public static void main(String[] args) {
    new CTWaterfordTownParserTest().generateTests("T1");
  }
}