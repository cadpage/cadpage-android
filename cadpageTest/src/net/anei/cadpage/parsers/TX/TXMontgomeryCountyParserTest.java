package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXMontgomeryCountyParserTest extends BaseParserTest {
  
  public TXMontgomeryCountyParserTest() {
    setParser(new TXMontgomeryCountyParser(), "MONTGOMERY COUNTY", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[Fire CAD Message]  New Fire Run: 2010-63654,Nature: 12D02E-SEIZURE - Continuous or Multiple seizures,MR54,Location: 12246 TRAIL HOLLOW DR,Buildi",
        "ID:2010-63654",
        "CALL:12D02E-SEIZURE - Continuous or Multiple seizures",
        "UNIT:MR54",
        "ADDR:12246 TRAIL HOLLOW DR");

    doTest("T2",
        "[Fire CAD Message]  New Fire Run: 2010-63564,Nature: 19D04-HEART PROBLEMS - Clammy,MR51,Location: HIGHWAY 105 W & S FM 1486,Building: ,Cross: ,,G",
        "ID:2010-63564",
        "CALL:19D04-HEART PROBLEMS - Clammy",
        "UNIT:MR51",
        "ADDR:HIGHWAY 105 W & S FM 1486");

    doTest("T3",
        "[Fire CAD Message]  New Fire Run: 2010-63733,Nature: F15-ILLEGAL BURN,E55;,Location: 14321 FOREST CIR E-MO,Building: ,Cross: 14658 FOREST CIR-MO,",
        "ID:2010-63733",
        "CALL:F15-ILLEGAL BURN",
        "UNIT:E55",
        "ADDR:14321 FOREST CIR E",
        "CITY:MONTGOMERY",
        "X:14658 FOREST CIR");

    doTest("T4",
        "[Fire CAD Message]  New Fire Run: 2010-63709,Nature: F25-RESIDENTIAL FIRE,E51;,Location: 159 S PINE DR-MO,Building: ,Cross: 132 N PINE DR-MO,132",
        "ID:2010-63709",
        "CALL:F25-RESIDENTIAL FIRE",
        "UNIT:E51",
        "ADDR:159 S PINE DR",
        "CITY:MONTGOMERY",
        "X:132 N PINE DR");

    doTest("T5",
        "[Fire CAD Message]  New Fire Run: 2010-63739,Nature: F15-ILLEGAL BURN,E51;,Location: PINE LN-MO/HICKORY DR-MO,Building: ,Cross: 19902 PINE LN-MO,",
        "ID:2010-63739",
        "CALL:F15-ILLEGAL BURN",
        "UNIT:E51",
        "ADDR:PINE LN & HICKORY DR",
        "CITY:MONTGOMERY",
        "X:19902 PINE LN");

    doTest("T6",
        "[Fire CAD Message]  New Fire Run: 2010-63762,Nature: 10C04-CHEST PAIN - Breathing Normally => 35,MR51,Location: 24495 REED RD,Building: ,Cross: ,",
        "ID:2010-63762",
        "UNIT:MR51",
        "CALL:10C04-CHEST PAIN - Breathing Normally => 35",
        "ADDR:24495 REED RD");

    doTest("T7",
        "[Fire CAD Message]  New Fire Run: 2010-63789,Nature: 17D03-FALL - Not alert,MR51,Location: 1953 DR MARTIN LUTHER KING JR DR,Building: ,Cross: ,,G",
        "ID:2010-63789",
        "CALL:17D03-FALL - Not alert",
        "UNIT:MR51",
        "ADDR:1953 DR MARTIN LUTHER KING JR DR");

    doTest("T8",
        "[Fire CAD Message]  New Fire Run: 2010-63800,Nature: 28C01G-STROKE/CVA - Not alert - Greater than one hour onset,MR55,Location: 1 FAIRFIELD DR,Bu",
        "ID:2010-63800",
        "CALL:28C01G-STROKE/CVA - Not alert - Greater than one hour onset",
        "UNIT:MR55",
        "ADDR:1 FAIRFIELD DR");

    doTest("T9",
        "(Nature: 13D01-DIABETIC PROBLEMS - Unconscious) New Fire Run: 2011-76911,,MR18,Location: 35219 W PINE HILL,Building: ,Cross: ,,Grid: 247F,Map: 4",
        "ID:2011-76911",
        "CALL:13D01-DIABETIC PROBLEMS - Unconscious",
        "UNIT:MR18",
        "ADDR:35219 W PINE HILL");

    doTest("T10",
        "(Nature: 13D01-DIABETIC PROBLEMS - Unconscious) New Fire Run: 2011-76911,,MR18,Location: 35219 W PINE HILL,Building: ,Cross: ,,Grid: 247F,Map: 4",
        "ID:2011-76911",
        "CALL:13D01-DIABETIC PROBLEMS - Unconscious",
        "UNIT:MR18",
        "ADDR:35219 W PINE HILL");

    doTest("T11",
        "New Fire Run: 2011-75288,Nature: 28C01G-STROKE/CVA - Not alert - Greater than one hour onset,MR18,Location: 158 CHARLIE,Building: ,Cross: ,,Grid: 212K,Map: 4476,.",
        "ID:2011-75288",
        "CALL:28C01G-STROKE/CVA - Not alert - Greater than one hour onset",
        "UNIT:MR18",
        "ADDR:158 CHARLIE");

    doTest("T12",
        "(Nature: 06D02-BREATHING PROBLEMS -) New Fire Run: 2011-79434,,MR51,Location: 21760 CHAPPEL WAY,Building: ,Cross: ,,Grid: 69A,Map: 4291,.",
        "ID:2011-79434",
        "CALL:06D02-BREATHING PROBLEMS -",
        "UNIT:MR51",
        "ADDR:21760 CHAPPEL WAY");

    doTest("T13",
        "(Nature: F25-RESIDENTIAL FIRE) New Fire Run: 2011-86558,,E82;,Location: 12767 COON MASSEY RD-CR,Building: ,Cross: 15344 FM 3083-CR,127,Grid: 190",
        "ID:2011-86558",
        "CALL:F25-RESIDENTIAL FIRE",
        "UNIT:E82",
        "ADDR:12767 COON MASSEY RD",
        "CITY:CONROE",
        "X:15344 FM 3083");

    doTest("T13",
        "(Nature: 29-MVA - PRE-ALERT) New Fire Run: 2011-96042,,E112,Location: RAYFORD RD-SC/FOX RUN BLVD-SC,Building: ,Cross: 3050 RAYFORD RD-SC,,Grid:",
        "ID:2011-96042",
        "CALL:29-MVA - PRE-ALERT",
        "UNIT:E112",
        "ADDR:RAYFORD RD & FOX RUN BLVD",
        "CITY:SPRING",
        "X:3050 RAYFORD RD");

    doTest("T14",
        "(Nature: 12B01-SEIZURE - Effective breathing NOT) New Fire Run: 2011-95939,,B113,Location: 25808 I45 N-SC,Building: ,Cross: 102 OAKWOOD DR-SC,BR",
        "ID:2011-95939",
        "CALL:12B01-SEIZURE - Effective breathing NOT",
        "UNIT:B113",
        "ADDR:25808 I45 N",
        "CITY:SPRING",
        "X:102 OAKWOOD DR");

    doTest("T15",
        "(Nature: F48-CODE 1000 DRILL ONLY) New Fire Run: 2011-95833,,E113,Location: 27430 ROBINSON RD-OR,Building: ST 113 S MONT CO FIRE,Cross: 27254 BL",
        "ID:2011-95833",
        "CALL:F48-CODE 1000 DRILL ONLY",
        "UNIT:E113",
        "ADDR:27430 ROBINSON RD",
        "APT:ST 113 S MONT CO FIRE",
        "CITY:OAK RIDGE",
        "X:27254 BL");

    doTest("T16",
        "(Nature: F03-AUTOMATIC ALARM) New Fire Run: 2011-96053,,E112,Location: 1805 RILEY FUZZELL RD-SC,Building: ,Cross: 28500 SPRING TRAILS,Grid: 293E,",
        "ID:2011-96053",
        "CALL:F03-AUTOMATIC ALARM",
        "UNIT:E112",
        "ADDR:1805 RILEY FUZZELL RD",
        "CITY:SPRING",
        "X:28500 SPRING TRAILS");

    doTest("T17",
        "(Nature: F08-CONTROLLED BURN) New Fire Run: 2011-96055,,B112,Location: 1638 JULIA PARK DR-SC,Building: ,Cross: 27918 TESSIE HILLS L,Grid: 293K,M",
        "ID:2011-96055",
        "CALL:F08-CONTROLLED BURN",
        "UNIT:B112",
        "ADDR:1638 JULIA PARK DR",
        "CITY:SPRING",
        "X:27918 TESSIE HILLS L");

    doTest("T18",
        "(Nature: F08-CONTROLLED BURN) New Fire Run: 2011-96061,,B112,Location: 2121 RILEY FUZZELL RD-SC,Building: ,Cross: 28702 LODDINGTON ST-,Grid: 293E",
        "ID:2011-96061",
        "CALL:F08-CONTROLLED BURN",
        "UNIT:B112",
        "ADDR:2121 RILEY FUZZELL RD",
        "CITY:SPRING",
        "X:28702 LODDINGTON ST");

    doTest("T19",
        "(Nature: 10C01-CHEST PAIN - Abnormal Breathing) New Fire Run: 2011-96069,,B113,Location: 319 PINE MANOR DR-OR,Building: ,Cross: 27072 N HARLAN L",
        "ID:2011-96069",
        "CALL:10C01-CHEST PAIN - Abnormal Breathing",
        "UNIT:B113",
        "ADDR:319 PINE MANOR DR",
        "CITY:OAK RIDGE",
        "X:27072 N HARLAN L");

    doTest("T20",
        "(Nature: 28C01U-STROKE/CVA - Not alert - Unknown) New Fire Run: 2011-96082,,T112,Location: 2115 OLD OX RD-SC,Building: ,Cross: 29502 TIMBER TRL-",
        "ID:2011-96082",
        "CALL:28C01U-STROKE/CVA - Not alert - Unknown",
        "UNIT:T112",
        "ADDR:2115 OLD OX RD",
        "CITY:SPRING",
        "X:29502 TIMBER TRL");

    doTest("T21",
        "(Nature: 29-MVA - PRE-ALERT) New Fire Run: 2011-96081,,L111,Location: INTERSTATE 45 N & RAYFORD RD,Building: ,Cross: ,,Grid: 252W,Map: 5173,.",
        "ID:2011-96081",
        "CALL:29-MVA - PRE-ALERT",
        "UNIT:L111",
        "ADDR:INTERSTATE 45 N & RAYFORD RD");

    doTest("T22",
        "(Nature: 32D01-UNKNOWN PROBLEM/MAN DOWN - Life St) New Fire Run: 2011-96095,,B111,Location: INTERSTATE 45 N & RAYFORD RD,Building: ,Cross: ,,Gri",
        "ID:2011-96095",
        "CALL:32D01-UNKNOWN PROBLEM/MAN DOWN - Life St",
        "UNIT:B111",
        "ADDR:INTERSTATE 45 N & RAYFORD RD");

    doTest("T23",
        "(Nature: 28C01L-STROKE/CVA - Not alert - Less tha) New Fire Run: 2011-96102,,B113,Location: 25610 OAKHURST DR-SC,Building: GRACE MEMORY CARE II,",
        "ID:2011-96102",
        "CALL:28C01L-STROKE/CVA - Not alert - Less tha",
        "UNIT:B113",
        "ADDR:25610 OAKHURST DR",
        "APT:GRACE MEMORY CARE II",
        "CITY:SPRING");

    doTest("T24",
        "(Nature: F44-SMALL OUTSIDE FIRE) New Fire Run: 2011-96146,,E112,Location: 29903 S LEGENDS VILLAGE CIR-SC,Building: ,Cross: 29820 LEGENDS PASS L,",
        "ID:2011-96146",
        "CALL:F44-SMALL OUTSIDE FIRE",
        "UNIT:E112",
        "ADDR:29903 S LEGENDS VILLAGE CIR",
        "CITY:SPRING",
        "X:29820 LEGENDS PASS L");

    doTest("T25",
        "(Nature: 06C01-BREATHING PROBLEMS - Abnormal Brea) New Fire Run: 2011-96151,,B111,Location: I45 N-SC/RAYFORD RD-SC,Building: ,Cross: 25130 I45 N",
        "ID:2011-96151",
        "CALL:06C01-BREATHING PROBLEMS - Abnormal Brea",
        "UNIT:B111",
        "ADDR:I45 N & RAYFORD RD",
        "CITY:SPRING",
        "X:25130 I45 N");

    doTest("T26",
        "(Nature: 06D02-BREATHING PROBLEMS - DIFICULTY SPE) New Fire Run: 2011-96229,,B113,Location: 258 SPRING PINES DR-SC,Building: ,Cross: 26202 MAPLE",
        "ID:2011-96229",
        "CALL:06D02-BREATHING PROBLEMS - DIFICULTY SPE",
        "UNIT:B113",
        "ADDR:258 SPRING PINES DR",
        "CITY:SPRING",
        "X:26202 MAPLE");

    doTest("T27",
        "(Nature: 10D02-CHEST PAIN - Difficulty speaking b) New Fire Run: 2011-96261,,B111,Location: 25469 BOROUGH PARK DR-SC,617,Building: MISSION WOODS",
        "ID:2011-96261",
        "CALL:10D02-CHEST PAIN - Difficulty speaking b",
        "UNIT:B111",
        "ADDR:25469 BOROUGH PARK DR",
        "APT:MISSION WOODS",
        "CITY:SPRING");
  }
  
  public static void main(String[] args) {
    new TXMontgomeryCountyParserTest().generateTests("T27");
  }
}
