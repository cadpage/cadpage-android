package net.anei.cadpage.parsers.MD;


import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

public class MDCharlesCountyParserTest extends BaseParserTest {
  
  public MDCharlesCountyParserTest() {
    setParser(new MDCharlesCountyParser(), "CHARLES COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(*CAD*) [CAD] UNDETERMINED FIRE MIDDLETOWN RD / LYLES PL 3H11-9G1 CALLER LIVES ON CADWELL ST AND CAN SEE A LARGE FIRE THRU THE WOODS...UNSURE WHAT IT IS F103490",
        "CALL:UNDETERMINED FIRE",
        "ADDR:MIDDLETOWN RD & LYLES PL");

    doTest("T2",
        "(*CAD*) [CAD] TROUBLE BREATHING, RESPIRATORY DISTRESS, EMS, ALS, 6C, 6D 3465 LAUREL DR 7 H3 65 year old, Female, Conscious, Breathing. Breathing Problems. Abnor",
        "CALL:TROUBLE BREATHING, RESPIRATORY DISTRESS",
        "UNIT:EMS, ALS, 6C, 6D",
        "ADDR:3465 LAUREL DR",
        "CODE:7 H3",
        "INFO:65 year old, Female, Conscious, Breathing. Breathing Problems. Abnor");

    doTest("T3",
        "(*CAD*) [CAD] CO DETECTOR, CARBON MONOXIDE, 8A 2204 JASON CT 7 K2 CALLER ADVISED HIS BSMT CO DETECTOR IS GOING OFF. F103510001 1022578 02:01",
        "CALL:CO DETECTOR, CARBON MONOXIDE",
        "UNIT:8A",
        "ADDR:2204 JASON CT",
        "CODE:7 K2",
        "INFO:CALLER ADVISED HIS BSMT CO DETECTOR IS GOING OFF.",
        "ID:F103510001");

    doTest("T4",
        "(*CAD*) [CAD] UNKNOWN MEDICAL ALARM, EMS, BLS, 32B 3487 HIGHGROVE DR 8 H5 Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown",
        "CALL:UNKNOWN MEDICAL ALARM",
        "UNIT:EMS, BLS, 32B",
        "ADDR:3487 HIGHGROVE DR",
        "CODE:8 H5",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown");

    doTest("T5",
        "(*CAD*) [CAD] 10-50 PI, EMS, BLS, 29A HAWTHORNE RD / CHICAMUXEN RD 7 F11 Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown n",
        "CALL:10-50 PI",
        "UNIT:EMS, BLS, 29A",
        "ADDR:HAWTHORNE RD & CHICAMUXEN RD",
        "CODE:7 F11",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown n");

    doTest("T6",
        "(*CAD*) [CAD] MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT, 130 KALMIA CT 17 F6 DRYER ON FIRE / ADVISED TO GET OUT F103550006 1022816 12:07",
        "CALL:MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT",
        "ADDR:130 KALMIA CT",
        "CODE:17 F6",
        "INFO:DRYER ON FIRE / ADVISED TO GET OUT",
        "ID:F103550006");

    doTest("T7",
        "Subject:*CAD*\n[CAD] GAS LEAK INSIDE\nA S/F SINGLE FAMILY DWELLING 5748 OAK CT 7 E11 SMELLS GAS INSIDE HOME AND IN GARAGE F103640012 102",
        "CALL:GAS LEAK INSIDE A S/F SINGLE FAMILY DWELLING",
        "ADDR:5748 OAK CT",
        "CODE:7 E11",
        "INFO:SMELLS GAS INSIDE HOME AND IN GARAGE",
        "ID:F103640012");

    doTest("T8",
        "Subject:*CAD*\n[CAD] 10-50 PI EXTRICATION, TRAPPED, PINNED, EMS, ALS, 29B, 29D 9275 IRONSIDES RD RT 425, MT HOPE ELEM SCHOOL A/O 23 H4-",
        "CALL:10-50 PI EXTRICATION, TRAPPED, PINNED",
        "UNIT:EMS, ALS, 29B, 29D",
        "ADDR:9275 IRONSIDES RD RT 425",
        "PLACE:MT HOPE ELEM SCHOOL A/O",
        "CODE:23 H4",
        "INFO:-");

    doTest("T9",
        "Subject:*CAD*\n[CAD] GAS LEAK\nINSIDE A S/F SINGLE FAMILY DWELLING 5748 OAK CT 7 E11 SMELLS GAS INSIDE HOME AND IN GARAGE F103640012 102",
        "CALL:GAS LEAK INSIDE A S/F SINGLE FAMILY DWELLING",
        "ADDR:5748 OAK CT",
        "CODE:7 E11",
        "INFO:SMELLS GAS INSIDE HOME AND IN GARAGE",
        "ID:F103640012");

    doTest("T10",
        "Subject:*CAD*\n[CAD] 10-50 PI FIRE EMS APPARATUS TRUCK AMBULANCE HAWTHORNE RD / MANOR LA 15 J3 10-17 ADV SHE WAS ASSAULTED BY HER FRIEN",
        "CALL:10-50 PI FIRE",
        "UNIT:EMS APPARATUS TRUCK AMBULANCE",
        "ADDR:HAWTHORNE RD & MANOR LA",
        "CODE:15 J3",
        "INFO:10-17 ADV SHE WAS ASSAULTED BY HER FRIEN");

    doTest("T11",
        "Subject:*CAD*\n[CAD] 10-50 PI, EMS, BLS, 29A HAWTHORNE RD / CHICAMUXEN RD 7 F11 Age unknown, Gender unknown, Consciousness unknown, Bre",
        "CALL:10-50 PI",
        "UNIT:EMS, BLS, 29A",
        "ADDR:HAWTHORNE RD & CHICAMUXEN RD",
        "CODE:7 F11",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Bre");

    doTest("T12",
        "Subject:*CAD*\n[CAD] COMMERCIAL BUILDING FIRE, STRUCTURE, BLDG, 4975 HAWTHORNE RD, PENNYS TAVERN NEXT TO 7 C7 NEXT TO BLDG, CHILD CARE",
        "CALL:COMMERCIAL BUILDING FIRE, STRUCTURE, BLDG",
        "ADDR:4975 HAWTHORNE RD",
        "PLACE:PENNYS TAVERN NEXT TO",
        "CODE:7 C7",
        "INFO:NEXT TO BLDG, CHILD CARE");

    doTest("T13",
        "Subject:*CAD*\n[CAD] UNDETERMINED FIRE INNSBRUCK CT / MASONS SPRING RD 14 K7 CALLER REPORTING LARGE FIRE VISIBLE A/F INNBRUCK CT,UNK WH",
        "CALL:UNDETERMINED FIRE",
        "ADDR:INNSBRUCK CT & MASONS SPRING RD",
        "CODE:14 K7",
        "INFO:CALLER REPORTING LARGE FIRE VISIBLE A/F INNBRUCK CT,UNK WH");

    doTest("T14",
        "Subject:*CAD*\n[CAD] 10-50 PI MOTORCYCLE, EMS, ALS, ATV, BICYCLE, BIKE, 29B, 29D RIPLEY RD, 2 MILES FROM ANNAPOLIS WOODS RD 15 F6 Age u",
        "CALL:10-50 PI",
        "UNIT:MOTORCYCLE, EMS, ALS, ATV, BICYCLE, BIKE, 29B, 29D",
        "ADDR:RIPLEY RD",
        "PLACE:2 MILES FROM ANNAPOLIS WOODS RD",
        "CODE:15 F6",
        "INFO:Age u");

    doTest("T15",
        "Subject:*CAD*\n[CAD] MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT, 1 HICKORY LN, APT #307 17 G6 CALLER ADVISED HAS ODOR OF SMOKE",
        "CALL:MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT",
        "ADDR:1 HICKORY LN",
        "PLACE:APT #307",
        "CODE:17 G6",
        "INFO:CALLER ADVISED HAS ODOR OF SMOKE");

    doTest("T16",
        "Subject:*CAD*\n[CAD] MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT, 28 FAIRHILL LN 6 H6 ODER OF SMOKE IN EQUIPMENT ROOM. F10338000",
        "CALL:MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT",
        "ADDR:28 FAIRHILL LN",
        "CODE:6 H6",
        "INFO:ODER OF SMOKE IN EQUIPMENT ROOM. F10338000");

    doTest("T17",
        "Subject:*CAD*\n[CAD] AFA - SINGLE FAMILY DWELLING, FIRE ALARM, S/F HOUSE 6445 MASON SPRINGS RD 15 A4 HALLWAY S/D, PHONE WAS PUT DOWN, N",
        "CALL:AFA - SINGLE FAMILY DWELLING, FIRE ALARM, S/F HOUSE",
        "ADDR:6445 MASON SPRINGS RD",
        "CODE:15 A4",
        "INFO:HALLWAY S/D, PHONE WAS PUT DOWN, N");
  
  }
    
  public static void main(String[] args) {
    new MDCharlesCountyParserTest().generateTests("T1", "CALL UNIT ADDR PLACE CODE INFO ID");
  }

}