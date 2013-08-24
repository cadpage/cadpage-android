package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.IN.INMadisonCountyAParser;

import org.junit.Test;

/*
Madison County (Alexandria), IN
Contact: Pamela Stigall <pamstigall@gmail.com>
Sender: Mplus@madisoncty.com
Unit:ST40 UnitSts: Loc:6302 APOLLO DR Venue:RICHLA TWP Inc:Brush Fire Date:10/17/2010 Time:18:49 ON GEMINI / 1 ST HOUSE SOUTH EAST END Addtl:TRASH FIRE ON THE GROUND/WHI MODULAR WHI VAN SITTING IN DRIVE
Unit:AM45 UnitSts: Loc:6197 N SR 9 Venue:RICHLA TWP Inc:EMS Call Date:10/17/2010 Time:01:12 56 YOM / ADV HE DOESNT FEEL GOOD / VOMITING A Addtl:ND NO APPITITE ALL DAY / WILL BE WATING OUTSI DE RESD:
Unit:ST40 UnitSts: Loc:E 400N/100E Venue:RICHLA TWP Inc:Brush Fire Date:10/15/2010 Time:14:33 OPEN BURN BETWEEEN 100E AND ALEX PIKE/ S SIDE Addtl: OF ROAD
Unit:ST40 UnitSts: Loc:3551 N SR 9 Venue:LAFAYE TWP TOM WOOD HONDA Inc:Accidnt PI Date:10/14/2010 Time:07:43 UNKNOWN 2 VEHS Addtl:
Unit:AM45 UnitSts: Loc:124 DARIN CT Venue:RICHLA TWP Inc:SEIZURE Date:10/29/2010 Time:19:31 18 MO/POSS SEIZURE Addtl:

Contact: Jason Quimby <fjquimby@gmail.com>
Subject:{EMAOPS} (62533) CAD Page Unit:EMA1 Loc:3727 N 200E Venue:RICHLA TWP Inc:Accidnt PI Date:12/09/2010 Time:10:31 UNKNOWN  CAR VS POL
Subject:(62534) Dispatch\nUnit:ST50 UnitSts: Loc:207 E MAIN ST Venue:CHESTERFIE STATION 50 Inc:Fire Date:12/09/2010 Time:12:00 STAND BY YO
Subject:(63067) DISP\nUnit:U20 UnitSts: Loc:53RD ST/SCATTERFIELD Venue:ANDERSON Inc:Accidnt PI Date:12/17/2010 Time:12:06 NECK PAIN/IN PRK
Subject:{ST30} (63312) Dispatch\nUnit:RS35 Loc:2278 N 600W Venue:LAFAYE TWP Inc:FALL Date:12/22/2010 Time:07:03 65YOM FELL ON ICE IN DRIVEW

Brent Jensen <brent.cutfd28@gmail.com>
Fwd: (62208) DISPATCH) Unit:AM51 UnitSts: Loc:3363 E 200N Venue:UNION TWP Inc:Accidnt PI Date:12/04/2010 Time:09:59 CAR HIT POLE/CONSCIOUS BUT HIT HEAD/NOT A

*/

public class INMadisonCountyAParserTest extends BaseParserTest {
  
  public INMadisonCountyAParserTest() {
    setParser(new INMadisonCountyAParser(), "MADISON COUNTY", "IN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Unit:ST40 UnitSts: Loc:6302 APOLLO DR Venue:RICHLA TWP Inc:Brush Fire Date:10/17/2010 Time:18:49 ON GEMINI / 1 ST HOUSE SOUTH EAST END Addtl:TRASH FIRE ON THE GROUND/WHI MODULAR WHI VAN SITTING IN DRIVE",
        "UNIT:ST40",
        "ADDR:6302 APOLLO DR",
        "CITY:RICHLAND TWP",
        "CALL:Brush Fire",
        "DATE:10/17/2010",
        "TIME:18:49",
        "INFO:ON GEMINI / 1 ST HOUSE SOUTH EAST END / TRASH FIRE ON THE GROUND/WHI MODULAR WHI VAN SITTING IN DRIVE");

    doTest("T2",
        "Unit:AM45 UnitSts: Loc:6197 N SR 9 Venue:RICHLA TWP Inc:EMS Call Date:10/17/2010 Time:01:12 56 YOM / ADV HE DOESNT FEEL GOOD / VOMITING A Addtl:ND NO APPITITE ALL DAY / WILL BE WATING OUTSI DE RESD:",
        "UNIT:AM45",
        "ADDR:6197 N SR 9",
        "MADDR:6197 N IN 9",
        "CITY:RICHLAND TWP",
        "CALL:EMS Call",
        "DATE:10/17/2010",
        "TIME:01:12",
        "INFO:56 YOM / ADV HE DOESNT FEEL GOOD / VOMITING A / ND NO APPITITE ALL DAY / WILL BE WATING OUTSI DE RESD:");

    doTest("T3",
        "Unit:ST40 UnitSts: Loc:E 400N/100E Venue:RICHLA TWP Inc:Brush Fire Date:10/15/2010 Time:14:33 OPEN BURN BETWEEEN 100E AND ALEX PIKE/ S SIDE Addtl: OF ROAD",
        "UNIT:ST40",
        "ADDR:E 400N & 100E",
        "CITY:RICHLAND TWP",
        "CALL:Brush Fire",
        "DATE:10/15/2010",
        "TIME:14:33",
        "INFO:OPEN BURN BETWEEEN 100E AND ALEX PIKE/ S SIDE / OF ROAD");

    doTest("T4",
        "Unit:ST40 UnitSts: Loc:3551 N SR 9 Venue:LAFAYE TWP TOM WOOD HONDA Inc:Accidnt PI Date:10/14/2010 Time:07:43 UNKNOWN 2 VEHS Addtl:",
        "UNIT:ST40",
        "ADDR:3551 N SR 9",
        "MADDR:3551 N IN 9",
        "CITY:LAFAYE TWP TOM WOOD HONDA",
        "CALL:Accidnt PI",
        "DATE:10/14/2010",
        "TIME:07:43",
        "INFO:UNKNOWN 2 VEHS");

    doTest("T5",
        "Unit:AM45 UnitSts: Loc:124 DARIN CT Venue:RICHLA TWP Inc:SEIZURE Date:10/29/2010 Time:19:31 18 MO/POSS SEIZURE Addtl:",
        "UNIT:AM45",
        "ADDR:124 DARIN CT",
        "CITY:RICHLAND TWP",
        "CALL:SEIZURE",
        "DATE:10/29/2010",
        "TIME:19:31",
        "INFO:18 MO/POSS SEIZURE");

  }
  
  @Test
  public void testJasonQuimby() {

    doTest("T1",
        "Subject:{EMAOPS} (62533) CAD Page Unit:EMA1 Loc:3727 N 200E Venue:RICHLA TWP Inc:Accidnt PI Date:12/09/2010 Time:10:31 UNKNOWN  CAR VS POL",
        "UNIT:EMA1",
        "ADDR:3727 N 200E",
        "CITY:RICHLAND TWP",
        "CALL:Accidnt PI",
        "DATE:12/09/2010",
        "TIME:10:31",
        "INFO:UNKNOWN  CAR VS POL");

    doTest("T2",
        "Subject:(62534) Dispatch\n" +
        "Unit:ST50 UnitSts: Loc:207 E MAIN ST Venue:CHESTERFIE STATION 50 Inc:Fire Date:12/09/2010 Time:12:00 STAND BY YO",

        "UNIT:ST50",
        "ADDR:207 E MAIN ST",
        "CITY:CHESTERFIELD",
        "CALL:Fire",
        "DATE:12/09/2010",
        "TIME:12:00",
        "INFO:STAND BY YO");

    doTest("T3",
        "Subject:(63067) DISP\n" +
        "Unit:U20 UnitSts: Loc:53RD ST/SCATTERFIELD Venue:ANDERSON Inc:Accidnt PI Date:12/17/2010 Time:12:06 NECK PAIN/IN PRK",

        "UNIT:U20",
        "ADDR:53RD ST & SCATTERFIELD",
        "CITY:ANDERSON",
        "CALL:Accidnt PI",
        "DATE:12/17/2010",
        "TIME:12:06",
        "INFO:NECK PAIN/IN PRK");

    doTest("T4",
        "Subject:{ST30} (63312) Dispatch\n" +
        "Unit:RS35 Loc:2278 N 600W Venue:LAFAYE TWP Inc:FALL Date:12/22/2010 Time:07:03 65YOM FELL ON ICE IN DRIVEW",

        "UNIT:RS35",
        "ADDR:2278 N 600W",
        "CITY:LAFAYETTE TWP",
        "CALL:FALL",
        "DATE:12/22/2010",
        "TIME:07:03",
        "INFO:65YOM FELL ON ICE IN DRIVEW");

  }
  
  @Test
  public void testBrentJenson() {

    doTest("T1",
        "Fwd: (62208) DISPATCH) Unit:AM51 UnitSts: Loc:3363 E 200N Venue:UNION TWP Inc:Accidnt PI Date:12/04/2010 Time:09:59 CAR HIT POLE/CONSCIOUS BUT HIT HEAD/NOT A",
        "UNIT:AM51",
        "ADDR:3363 E 200N",
        "CITY:UNION TWP",
        "CALL:Accidnt PI",
        "DATE:12/04/2010",
        "TIME:09:59",
        "INFO:CAR HIT POLE/CONSCIOUS BUT HIT HEAD/NOT");

  }
  
  public static void main(String[] args) {
    new INMadisonCountyAParserTest().generateTests("T1");
  }
}