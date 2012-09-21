package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class INWayneCountyParserTest extends BaseParserTest {
  
  public INWayneCountyParserTest() {
    setParser(new INWayneCountyParser(), "WAYNE COUNTY", "IN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(911) 05/31 20:20 81 S 14TH ST #209 209: Landmark: MERLE HENDERSON APTS  E MAIN ST//S A ST  70 Y/O FEMALE.;CONSC AND ALERT. ABLE TO SPEAK. ; DB JUST STARTED.",
        "DATE:05/31",
        "TIME:20:20",
        "ADDR:81 S 14TH ST",
        "APT:209",
        "CALL:209",
        "PLACE:MERLE HENDERSON APTS",
        "X:E MAIN ST & S A ST",
        "INFO:70 Y/O FEMALE.;CONSC AND ALERT. ABLE TO SPEAK. ; DB JUST STARTED.");

    doTest("T2",
        "(911) 05/31 19:56 812 NW 5TH ST #LOT 4 10-52: Landmark: HARBOR LIGHTS  NW J ST//INDIANA AV  FEMALE FELL AGAIN FROM A STANDING POSITION NO LOC  SHE IS UP JUST",
        "DATE:05/31",
        "TIME:19:56",
        "ADDR:812 NW 5TH ST",
        "APT:LOT 4",
        "CALL:10-52",
        "PLACE:HARBOR LIGHTS",
        "X:NW J ST & INDIANA AV",
        "INFO:FEMALE FELL AGAIN FROM A STANDING POSITION NO LOC  SHE IS UP JUST");

    doTest("T3",
        "(911) 05/31 18:43 2005 VI POST RD 10-52 DB:  TEST RD//SALISBURY RD S  72 Y/O MALE HAS BEEN SICK FOR A FEW DAYS. CONSC AND ALERT.",
        "DATE:05/31",
        "TIME:18:43",
        "ADDR:2005 VI POST RD",
        "CALL:10-52 DB",
        "X:TEST RD & SALISBURY RD S",
        "INFO:72 Y/O MALE HAS BEEN SICK FOR A FEW DAYS. CONSC AND ALERT.");

    doTest("T4",
        "(911) 05/31 16:37 E MAIN ST // WOODSIDE DR 10-50 PI: E MAIN ST // WOODSIDE DR  37TH ST//34TH ST  NECK PAIN;STILL IN THE ROAD WAY",
        "DATE:05/31",
        "TIME:16:37",
        "ADDR:E MAIN ST & WOODSIDE DR",  // Not mapping
        "CALL:10-50 PI",
        "X:37TH ST & 34TH ST",
        "INFO:NECK PAIN;STILL IN THE ROAD WAY");

    doTest("T5",
        "(911) 06/01 10:29 408 S 10TH ST #D 10-52 DB:  S C ST//S E ST  48 Y/O FEMALE. TROUBLE BREATHING HISTORY: COPD",
        "DATE:06/01",
        "TIME:10:29",
        "ADDR:408 S 10TH ST",
        "APT:D",
        "CALL:10-52 DB",
        "X:S C ST & S E ST",
        "INFO:48 Y/O FEMALE. TROUBLE BREATHING HISTORY: COPD");

    doTest("T6",
        "(911) 06/01 12:20 1212 S 20TH ST 10-52: Landmark: BETHLEHEM MANOR APARTMENTS  S L ST// ACCIDENTAL CUT TO THE HAND..WAITING AT THE ENTRANCE ",
        "DATE:06/01",
        "TIME:12:20",
        "ADDR:1212 S 20TH ST",
        "CALL:10-52",
        "PLACE:BETHLEHEM MANOR APARTMENTS",
        "X:S L ST & ACCIDENTAL CUT TO THE HAND..WAITING AT THE ENTRANCE");

    doTest("T7",
        "(911) 06/01 13:27 3601 E MAIN ST : Landmark Comment: WALMART PLAZA Landmark: WALMART  37TH ST//34TH ST  ;JUST INSIDE THE GROCERY ENTRANCE",
        "DATE:06/01",
        "TIME:13:27",
        "ADDR:3601 E MAIN ST",
        "CALL:ALERT",
        "PLACE:WALMART-WALMART PLAZA",
        "X:37TH ST & 34TH ST",
        "INFO:JUST INSIDE THE GROCERY ENTRANCE");

    doTest("T8",
        "(911) 06/01 00:00 BEELOR RD // US 27 10-50 UNK: 3081 BEELOR RD S US 27 // LIBERY AV  VEH IN THE DITCH NO DESC",
        "DATE:06/01",
        "TIME:00:00",
        "ADDR:BEELOR RD & US 27",
        "CALL:10-50 UNK",
        "X:3081 BEELOR RD S US 27 & LIBERY AV",
        "INFO:VEH IN THE DITCH NO DESC");

    doTest("T9",
        "(911) 06/01 09:43 900 S A ST : Landmark: LELAND RESIDENCE  S 10TH ST//S 9TH ST",
        "DATE:06/01",
        "TIME:09:43",
        "ADDR:900 S A ST",
        "CALL:ALERT",
        "PLACE:LELAND RESIDENCE",
        "X:S 10TH ST & S 9TH ST");

    doTest("T10",
        "(911) 07/13 10:34 322 S 8TH ST OVERDOSE:  S C ST//S E ST MALE TOOK MEDICINE LAST NIGHT APPROX MIDNIGHT SARAQIL AND VISITRIL  UNKNOWN AMOUNT HE IS SLEEPING NOW",
        "DATE:07/13",
        "TIME:10:34",
        "ADDR:322 S 8TH ST",
        "CALL:OVERDOSE",
        "X:S C ST & S E ST MALE TOOK MEDICINE LAST NIGHT APPROX MIDNIGHT SARAQIL AND VISITRIL",
        "INFO:UNKNOWN AMOUNT HE IS SLEEPING NOW");
  }
  
  public static void main(String[] args) {
    new INWayneCountyParserTest().generateTests("T1", "DATE TIME ADDR APT CALL PLACE X INFO");
  }
}