package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Henry County, GA
Contact: Stan Jones <sjones@co.henry.ga.us>
Contact: Stan Jones <hcboc045@gmail.com>
Contact: 6783003350@messaging.sprintpcs.com
Contact: Chris Phillips <thorstinger@gmail.com>
Sender: 93001nnn
Sender: 777256167528

VEHICLE FIRE/416 KIRKLAND DR/COLLINSWOOD S/D/./113F/04:29:42/ 
VEHICLE FIRE/416 KIRKLAND DR/COLLINSWOOD S/D/E2/04:29:42/ 
AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/./R1/23:43:09/
AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/2129/23:43:09/ 
AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/E51/23:43:09/ 
AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/E51/23:43:09/ 
AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/R7/23:43:09/ 
AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/R7/23:43:09/
AUTO ACCIDENT WITH INJURIES/2746 S HIGHWAY 155 INTERSECTN/./E2/15:38:30/
AUTO ACCIDENT WITH INJURIES/2746 S HIGHWAY 155 INTERSECTN/./R2/15:38:30/
AUTO ACCIDENT WITH INJURIES/216 N I75/EXIT 69/WHI CHEVY TRUCK/TOYT/E2/13:14:05/
AUTO ACCIDENT WITH INJURIES/221 N I75/EXIT 71/JUST BEFORE EXIT 221/E1/16:28:24
HOUSE FIRE/8506 ABINGTON DR/THE ARBORS AT EAGLES BROOKE/FROM I75, SOUTH ON 155.LEFT TO GREENWOOD INDUSTRIAL PKW. RIGHT TO/
VEHICLE FIRE/416 KIRKLAND DR/COLLINSWOOD S/D/E2/04:29:42/
33 HOUSE FIRE/724 PATRIOTS POINT ST/dryer is on fire..whole house is smoked up/R2/04:53:22/
HOUSE FIRE/140 DAILEY MILL RD/in b/t 140 and 150 dailey mill rd/L1 S1 E8 E3/18:59:45/
AUTO ACCIDENT WITH INJURIES/221 S I75/EXIT 71/female hit her head on side window and neck is tight/R9/15:25:28/
HOUSE FIRE/5164 HERON BAY BLV/E2 Q52 B1 L1 S1/10:57:25/
DA/PAGE, LLC MEDICAL CALL/152 BELLINGTON DR/BRISTOL PARK Z1/R7/12:16:13/

*/

public class GAHenryCountyParserTest extends BaseParserTest {
  
  public GAHenryCountyParserTest() {
    setParser(new GAHenryCountyParser(), "HENRY COUNTY", "GA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "VEHICLE FIRE/416 KIRKLAND DR/COLLINSWOOD S/D/./113F/04:29:42/ ",
        "CALL:VEHICLE FIRE",
        "ADDR:416 KIRKLAND DR",
        "INFO:COLLINSWOOD S/D/.",
        "UNIT:113F",
        "TIME:04:29:42");

    doTest("T2",
        "VEHICLE FIRE/416 KIRKLAND DR/COLLINSWOOD S/D/E2/04:29:42/ ",
        "CALL:VEHICLE FIRE",
        "ADDR:416 KIRKLAND DR",
        "INFO:COLLINSWOOD S/D",
        "UNIT:E2",
        "TIME:04:29:42");

    doTest("T3",
        "AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/./R1/23:43:09/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:177 RACETRACK RD",
        "INFO:.",
        "UNIT:R1",
        "TIME:23:43:09");

    doTest("T4",
        "AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/2129/23:43:09/ ",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:177 RACETRACK RD",
        "INFO:c/s at intersection",
        "UNIT:2129",
        "TIME:23:43:09");

    doTest("T5",
        "AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/E51/23:43:09/ ",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:177 RACETRACK RD",
        "INFO:c/s at intersection",
        "UNIT:E51",
        "TIME:23:43:09");

    doTest("T6",
        "AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/E51/23:43:09/ ",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:177 RACETRACK RD",
        "INFO:c/s at intersection",
        "UNIT:E51",
        "TIME:23:43:09");

    doTest("T7",
        "AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/R7/23:43:09/ ",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:177 RACETRACK RD",
        "INFO:c/s at intersection",
        "UNIT:R7",
        "TIME:23:43:09");

    doTest("T8",
        "AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/R7/23:43:09/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:177 RACETRACK RD",
        "INFO:c/s at intersection",
        "UNIT:R7",
        "TIME:23:43:09");

    doTest("T9",
        "AUTO ACCIDENT WITH INJURIES/2746 S HIGHWAY 155 INTERSECTN/./E2/15:38:30/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:2746 S HIGHWAY 155",
        "INFO:.",
        "UNIT:E2",
        "TIME:15:38:30");

    doTest("T10",
        "AUTO ACCIDENT WITH INJURIES/2746 S HIGHWAY 155 INTERSECTN/./R2/15:38:30/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:2746 S HIGHWAY 155",
        "INFO:.",
        "UNIT:R2",
        "TIME:15:38:30");

    doTest("T11",
        "AUTO ACCIDENT WITH INJURIES/216 N I75/EXIT 69/WHI CHEVY TRUCK/TOYT/E2/13:14:05/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:216 N I75",
        "MADDR:216 N I 75",
        "INFO:EXIT 69/WHI CHEVY TRUCK/TOYT",
        "UNIT:E2",
        "TIME:13:14:05");

    doTest("T12",
        "AUTO ACCIDENT WITH INJURIES/221 N I75/EXIT 71/JUST BEFORE EXIT 221/E1/16:28:24",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:221 N I75",
        "MADDR:221 N I 75",
        "INFO:EXIT 71/JUST BEFORE EXIT 221",
        "UNIT:E1",
        "TIME:16:28:24");

    doTest("T13",
        "HOUSE FIRE/8506 ABINGTON DR/THE ARBORS AT EAGLES BROOKE/FROM I75, SOUTH ON 155.LEFT TO GREENWOOD INDUSTRIAL PKW. RIGHT TO/",
        "CALL:HOUSE FIRE",
        "ADDR:8506 ABINGTON DR",
        "INFO:THE ARBORS AT EAGLES BROOKE/FROM I75, SOUTH ON 155.LEFT TO GREENWOOD INDUSTRIAL PKW. RIGHT TO");

    doTest("T14",
        "VEHICLE FIRE/416 KIRKLAND DR/COLLINSWOOD S/D/E2/04:29:42/",
        "CALL:VEHICLE FIRE",
        "ADDR:416 KIRKLAND DR",
        "INFO:COLLINSWOOD S/D",
        "UNIT:E2",
        "TIME:04:29:42");

    doTest("T15",
        "33 HOUSE FIRE/724 PATRIOTS POINT ST/dryer is on fire..whole house is smoked up/R2/04:53:22/",
        "CALL:33 HOUSE FIRE",
        "ADDR:724 PATRIOTS POINT ST",
        "INFO:dryer is on fire..whole house is smoked up",
        "UNIT:R2",
        "TIME:04:53:22");

    doTest("T16",
        "HOUSE FIRE/140 DAILEY MILL RD/in b/t 140 and 150 dailey mill rd/L1 S1 E8 E3/18:59:45/",
        "CALL:HOUSE FIRE",
        "ADDR:140 DAILEY MILL RD",
        "INFO:in b/t 140 and 150 dailey mill rd",
        "UNIT:L1 S1 E8 E3",
        "TIME:18:59:45");

    doTest("T17",
        "AUTO ACCIDENT WITH INJURIES/221 S I75/EXIT 71/female hit her head on side window and neck is tight/R9/15:25:28/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:221 S I75",
        "MADDR:221 S I 75",
        "INFO:EXIT 71/female hit her head on side window and neck is tight",
        "UNIT:R9",
        "TIME:15:25:28");

    doTest("T18",
        "HOUSE FIRE/5164 HERON BAY BLV/E2 Q52 B1 L1 S1/10:57:25/",
        "CALL:HOUSE FIRE",
        "ADDR:5164 HERON BAY BLV",
        "MADDR:5164 HERON BAY BLVD",
        "UNIT:E2 Q52 B1 L1 S1",
        "TIME:10:57:25");

    doTest("T19",
        "DA/PAGE, LLC MEDICAL CALL/152 BELLINGTON DR/BRISTOL PARK Z1/R7/12:16:13/",
        "CALL:DA/PAGE, LLC MEDICAL CALL",
        "ADDR:152 BELLINGTON DR",
        "INFO:BRISTOL PARK Z1",
        "UNIT:R7",
        "TIME:12:16:13");
   
  }
  
  public static void main(String[] args) {
    new GAHenryCountyParserTest().generateTests("T1");
  }
}
