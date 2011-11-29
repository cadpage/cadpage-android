package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class GAHenryCountyParserTest extends BaseParserTest {
  
  public GAHenryCountyParserTest() {
    setParser(new GAHenryCountyParser(), "HENRY COUNTY", "GA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "VEHICLE FIRE/416 KIRKLAND DR/COLLINSWOOD S/D/./113F/04:29:42/",
        "CALL:VEHICLE FIRE",
        "ADDR:416 KIRKLAND DR",
        "INFO:COLLINSWOOD S/D/.",
        "UNIT:113F");

    doTest("T2",
        "VEHICLE FIRE/416 KIRKLAND DR/COLLINSWOOD S/D/E2/04:29:42/",
        "CALL:VEHICLE FIRE",
        "ADDR:416 KIRKLAND DR",
        "INFO:COLLINSWOOD S/D",
        "UNIT:E2");

    doTest("T3",
        "AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/./R1/23:43:09/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:177 RACETRACK RD",
        "INFO:.",
        "UNIT:R1");

    doTest("T4",
        "AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/2129/23:43:09/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:177 RACETRACK RD",
        "INFO:c/s at intersection",
        "UNIT:2129");

    doTest("T5",
        "AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/E51/23:43:09/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:177 RACETRACK RD",
        "INFO:c/s at intersection",
        "UNIT:E51");

    doTest("T6",
        "AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/E51/23:43:09/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:177 RACETRACK RD",
        "INFO:c/s at intersection",
        "UNIT:E51");

    doTest("T7",
        "AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/R7/23:43:09/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:177 RACETRACK RD",
        "INFO:c/s at intersection",
        "UNIT:R7");

    doTest("T8",
        "AUTO ACCIDENT WITH INJURIES/177 RACETRACK RD INTERSECTN/c/s at intersection/R7/23:43:09/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:177 RACETRACK RD",
        "INFO:c/s at intersection",
        "UNIT:R7");

    doTest("T9",
        "AUTO ACCIDENT WITH INJURIES/2746 S HIGHWAY 155 INTERSECTN/./E2/15:38:30/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:2746 S HIGHWAY 155",
        "INFO:.",
        "UNIT:E2");

    doTest("T10",
        "AUTO ACCIDENT WITH INJURIES/2746 S HIGHWAY 155 INTERSECTN/./R2/15:38:30/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:2746 S HIGHWAY 155",
        "INFO:.",
        "UNIT:R2");

    doTest("T11",
        "AUTO ACCIDENT WITH INJURIES/216 N I75/EXIT 69/WHI CHEVY TRUCK/TOYT/E2/13:14:05/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:216 N I75",
        "MADDR:216 N I 75",
        "INFO:EXIT 69/WHI CHEVY TRUCK/TOYT",
        "UNIT:E2");

    doTest("T12",
        "AUTO ACCIDENT WITH INJURIES/221 N I75/EXIT 71/JUST BEFORE EXIT 221/E1/16:28:24",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:221 N I75",
        "MADDR:221 N I 75",
        "INFO:EXIT 71/JUST BEFORE EXIT 221",
        "UNIT:E1");

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
        "UNIT:E2");

    doTest("T15",
        "33 HOUSE FIRE/724 PATRIOTS POINT ST/dryer is on fire..whole house is smoked up/R2/04:53:22/",
        "CALL:33 HOUSE FIRE",
        "ADDR:724 PATRIOTS POINT ST",
        "INFO:dryer is on fire..whole house is smoked up",
        "UNIT:R2");

    doTest("T16",
        "HOUSE FIRE/140 DAILEY MILL RD/in b/t 140 and 150 dailey mill rd/L1 S1 E8 E3/18:59:45/",
        "CALL:HOUSE FIRE",
        "ADDR:140 DAILEY MILL RD",
        "INFO:in b/t 140 and 150 dailey mill rd",
        "UNIT:L1 S1 E8 E3");

    doTest("T17",
        "AUTO ACCIDENT WITH INJURIES/221 S I75/EXIT 71/female hit her head on side window and neck is tight/R9/15:25:28/",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:221 S I75",
        "MADDR:221 S I 75",
        "INFO:EXIT 71/female hit her head on side window and neck is tight",
        "UNIT:R9");

    doTest("T18",
        "HOUSE FIRE/5164 HERON BAY BLV/E2 Q52 B1 L1 S1/10:57:25/",
        "CALL:HOUSE FIRE",
        "ADDR:5164 HERON BAY BLV",
        "MADDR:5164 HERON BAY BLVD",
        "UNIT:E2 Q52 B1 L1 S1");
    
  }
  
  public static void main(String[] args) {
    new GAHenryCountyParserTest().generateTests("T1");
  }
}
