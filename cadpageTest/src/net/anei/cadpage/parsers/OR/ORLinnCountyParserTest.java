package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Linn County, OR
Contact: Zachary Lincoln <vtzach88@gmail.com>
Sender: linn911@le.linn.or.us

OTH STRCT FIRE/40560 MCQUEEN DR Linn County/HWY 228 &/6654B23*21/ E23 PT23 STN23 SF M21 A201 E21 E25 STN21 TONE WT21 1ST E22 STN22 WT22 STN24
UNCONC/FAINTING/ 300 W HOLLEY RD Sweet Home STONEBROOK APARTMENTS/ 61602221/ F
BREATH PROB/ 5050 MOUNTAIN FIR ST Sweet Home WILEY CREEK COMMUNITY/ 59662221/
SICK PERSON/ 1048 26TH CT Sweet Home/ 60632221/
SICK PERSON/ 24490 WEST BRUSH CREEK RD Linn County/ 705023*21/
SICK PERSON/ 45265 SUNNYSIDE RD Linn County/ 547021*21/
TRAUMA INJ/ 43813 WILEY CREEK DR Linn County/ 587022*21/
STROKE/CVA/ 43786 WILEY CREEK DR Linn County/ 587022*21/
SICK PERSON/ 1177 1ST AV Sweet Home/ 60602221/
UNK PROB (man down)/ 1228 4TH AV Sweet Home/ 60602221/
O D/INGESTION/POISONING/ 1131 29TH AV #C2 Sweet Home/ 60632221/
DIABETIC PROB/ 950 NANDINA ST Sweet Home TWIN OAKS CARE CENTER/ 60612221/
BREATH PROB/ 43156 NORTH RIVER DR Linn County/ 586622*21/
BREATH PROB/ 38110 HWY 228 Linn County/ 6649A23*21/
ALARM-FIRE/ 1400 18TH AV Sweet Home LINMAR INDUSTRIES LLC/ 60612221/
ALARM-FIRE/1400 18TH AV Sweet Home LINMAR INDUSTRIES LLC/HWY 20 & TAMARACK ST/60612221/ E21 STN21/Overhead door ~ water flow ~ zone 3 ~ riser 1
SICK PERSON/ 1099 LONG ST Sweet Home SWEET HOME FIRE DEPARTMENT/ 60612221/
CHEST PAIN/ 1530 TAMARACK ST #62 Sweet Home MT SHADOW TRAILER PARK/ 60612221/
CARDIAC/RESP ARREST/ 930 POPLAR ST Sweet Home/ 60602221/
CARDIAC/RESP ARREST/930 POPLAR ST Sweet Home/9TH AV & 11TH AV/60602221/ E21 RESCUE M21/neighbor came over and found her
EYE PROB/INJURIES/ 1530 TAMARACK ST #218 Sweet Home MT SHADOW TRAILER PARK/ 60612221/
TRAUMA INJ/ 3137 SANTIAM HWY SP 11 Sweet Home TRAILER VILLA/ 60632221/

Contact: Zach Akin <brfdfireman@gmail.com>
Sender: 93001NNN
ICOM/400 notification,HOUSE FIRE/ 1173 W SHERMAN ST Lebanon/ 4142A3131/

Contact: "sta32jp@yahoo.com" <sta32jp@yahoo.com>
Sender: linn911@linnsheriff.org
FRM:linn911@linnsheriff.org\nSUBJ:!\nMSG:DIABETIC PROB/32717 OLD MILL RD/06-08-12/21:20:12/63 year old, Male, Conscious, Breathing.  Diabetic/E32/

Contact: Active911.com
[ICOM/400 notification] TEST 1st ALARM FIRE/ 1115 SE JACKSON ST Albany LINN CO SHERIFFS OFFICE/JAIL/ 282511S11/\n
[ICOM/400 notification] OTH STRCT FIRE/ 36149 RIVERSIDE DR INTERSECTN Linn County  /  OAKVILLE RD/ 30181111/\n
[ICOM/400 notification] ALARM-FIRE/ 618 SW WASHINGTON ST Albany/ 282411N11/\n
[ICOM/400 notification] ALARM-FIRE/ 525 SW 25TH AV Albany OREGON FREEZE DRY PLANT #2/ 30241212/\n
[ICOM/400 notification] ALARM-FIRE/ 1929 SE GRAND PRAIRIE RD Albany VILLAS AT COURTYARD/ 30261212/\n
[ICOM/400 notification] TRAF COLLISION/ 3700 NE KNOX BUTTE RD Linn County LINN CO FAIRGROUNDS AND EXPO/ 26291313/\n
[ICOM/400 notification] CARDIAC/RESP ARREST/ 2801 SW UMATILLA ST Albany/ 30231212/\n
[ICOM/400 notification] A501 Recall Alarm/ TRAF COLLISION/25010 S I5 Linn County MP212 S I5//vehicle was traveling south, put his blinker on to the\n

Contact: vtzach88 . <vtzach88@gmail.com>
Sender: 777800490099
LINN 911 (!) UNCONC/FAINTING/28290 KINGSBURY RD/08-18-13/10:25:07/80 year old, Male, Unconscious, Breathing.  Unconscious //SHFF SHEMT/ TXT STOP to opt-out

*/
public class ORLinnCountyParserTest extends BaseParserTest {
  
  public ORLinnCountyParserTest() {
    setParser(new ORLinnCountyParser(), "LINN COUNTY", "OR");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "OTH STRCT FIRE/40560 MCQUEEN DR Linn County/HWY 228 &/6654B23*21/ E23 PT23 STN23 SF M21 A201 E21 E25 STN21 TONE WT21 1ST E22 STN22 WT22 STN24",
        "CALL:OTH STRCT FIRE",
        "ADDR:40560 MCQUEEN DR",
        "X:HWY 228 &",
        "MAP:6654B",
        "UNIT:23*21 E23 PT23 STN23 SF M21 A201 E21 E25 STN21 TONE WT21 1ST E22 STN22 WT22 STN24");

    doTest("T2",
        "UNCONC/FAINTING/ 300 W HOLLEY RD Sweet Home STONEBROOK APARTMENTS/ 61602221/ F",
        "CALL:UNCONC/FAINTING",
        "ADDR:300 W HOLLEY RD",
        "CITY:Sweet Home",
        "PLACE:STONEBROOK APARTMENTS",
        "MAP:6160",
        "UNIT:2221 F");

    doTest("T3",
        "BREATH PROB/ 5050 MOUNTAIN FIR ST Sweet Home WILEY CREEK COMMUNITY/ 59662221/",
        "CALL:BREATH PROB",
        "ADDR:5050 MOUNTAIN FIR ST",
        "CITY:Sweet Home",
        "PLACE:WILEY CREEK COMMUNITY",
        "MAP:5966",
        "UNIT:2221");

    doTest("T4",
        "SICK PERSON/ 1048 26TH CT Sweet Home/ 60632221/",
        "CALL:SICK PERSON",
        "ADDR:1048 26TH CT",
        "CITY:Sweet Home",
        "MAP:6063",
        "UNIT:2221");

    doTest("T5",
        "SICK PERSON/ 24490 WEST BRUSH CREEK RD Linn County/ 705023*21/",
        "CALL:SICK PERSON",
        "ADDR:24490 WEST BRUSH CREEK RD",
        "MAP:7050",
        "UNIT:23*21");

    doTest("T6",
        "SICK PERSON/ 45265 SUNNYSIDE RD Linn County/ 547021*21/",
        "CALL:SICK PERSON",
        "ADDR:45265 SUNNYSIDE RD",
        "MAP:5470",
        "UNIT:21*21");

    doTest("T7",
        "TRAUMA INJ/ 43813 WILEY CREEK DR Linn County/ 587022*21/",
        "CALL:TRAUMA INJ",
        "ADDR:43813 WILEY CREEK DR",
        "MAP:5870",
        "UNIT:22*21");

    doTest("T8",
        "STROKE/CVA/ 43786 WILEY CREEK DR Linn County/ 587022*21/",
        "CALL:STROKE/CVA",
        "ADDR:43786 WILEY CREEK DR",
        "MAP:5870",
        "UNIT:22*21");

    doTest("T9",
        "SICK PERSON/ 1177 1ST AV Sweet Home/ 60602221/",
        "CALL:SICK PERSON",
        "ADDR:1177 1ST AV",
        "MADDR:1177 1ST AVE",
        "CITY:Sweet Home",
        "MAP:6060",
        "UNIT:2221");

    doTest("T10",
        "UNK PROB (man down)/ 1228 4TH AV Sweet Home/ 60602221/",
        "CALL:UNK PROB (man down)",
        "ADDR:1228 4TH AV",
        "MADDR:1228 4TH AVE",
        "CITY:Sweet Home",
        "MAP:6060",
        "UNIT:2221");

    doTest("T11",
        "O D/INGESTION/POISONING/ 1131 29TH AV #C2 Sweet Home/ 60632221/",
        "CALL:O D/INGESTION/POISONING",
        "ADDR:1131 29TH AV",
        "MADDR:1131 29TH AVE",
        "APT:C2",
        "CITY:Sweet Home",
        "MAP:6063",
        "UNIT:2221");

    doTest("T12",
        "DIABETIC PROB/ 950 NANDINA ST Sweet Home TWIN OAKS CARE CENTER/ 60612221/",
        "CALL:DIABETIC PROB",
        "ADDR:950 NANDINA ST",
        "CITY:Sweet Home",
        "PLACE:TWIN OAKS CARE CENTER",
        "MAP:6061",
        "UNIT:2221");

    doTest("T13",
        "BREATH PROB/ 43156 NORTH RIVER DR Linn County/ 586622*21/",
        "CALL:BREATH PROB",
        "ADDR:43156 NORTH RIVER DR",
        "MAP:5866",
        "UNIT:22*21");

    doTest("T14",
        "BREATH PROB/ 38110 HWY 228 Linn County/ 6649A23*21/",
        "CALL:BREATH PROB",
        "ADDR:38110 HWY 228",
        "MAP:6649A",
        "UNIT:23*21");

    doTest("T15",
        "ALARM-FIRE/ 1400 18TH AV Sweet Home LINMAR INDUSTRIES LLC/ 60612221/",
        "CALL:ALARM-FIRE",
        "ADDR:1400 18TH AV",
        "MADDR:1400 18TH AVE",
        "CITY:Sweet Home",
        "PLACE:LINMAR INDUSTRIES LLC",
        "MAP:6061",
        "UNIT:2221");

    doTest("T16",
        "ALARM-FIRE/1400 18TH AV Sweet Home LINMAR INDUSTRIES LLC/HWY 20 & TAMARACK ST/60612221/ E21 STN21/Overhead door ~ water flow ~ zone 3 ~ riser 1",
        "CALL:ALARM-FIRE",
        "ADDR:1400 18TH AV",
        "MADDR:1400 18TH AVE",
        "CITY:Sweet Home",
        "PLACE:LINMAR INDUSTRIES LLC",
        "X:HWY 20 & TAMARACK ST",
        "MAP:6061",
        "UNIT:2221 E21 STN21",
        "INFO:Overhead door ~ water flow ~ zone 3 ~ riser 1");

    doTest("T17",
        "SICK PERSON/ 1099 LONG ST Sweet Home SWEET HOME FIRE DEPARTMENT/ 60612221/",
        "CALL:SICK PERSON",
        "ADDR:1099 LONG ST",
        "CITY:Sweet Home",
        "PLACE:SWEET HOME FIRE DEPARTMENT",
        "MAP:6061",
        "UNIT:2221");

    doTest("T18",
        "CHEST PAIN/ 1530 TAMARACK ST #62 Sweet Home MT SHADOW TRAILER PARK/ 60612221/",
        "CALL:CHEST PAIN",
        "ADDR:1530 TAMARACK ST",
        "APT:62",
        "CITY:Sweet Home",
        "PLACE:MT SHADOW TRAILER PARK",
        "MAP:6061",
        "UNIT:2221");

    doTest("T19",
        "CARDIAC/RESP ARREST/ 930 POPLAR ST Sweet Home/ 60602221/",
        "CALL:CARDIAC/RESP ARREST",
        "ADDR:930 POPLAR ST",
        "CITY:Sweet Home",
        "MAP:6060",
        "UNIT:2221");

    doTest("T20",
        "CARDIAC/RESP ARREST/930 POPLAR ST Sweet Home/9TH AV & 11TH AV/60602221/ E21 RESCUE M21/neighbor came over and found her",
        "CALL:CARDIAC/RESP ARREST",
        "ADDR:930 POPLAR ST",
        "CITY:Sweet Home",
        "X:9TH AV & 11TH AV",
        "MAP:6060",
        "UNIT:2221 E21 RESCUE M21",
        "INFO:neighbor came over and found her");

    doTest("T21",
        "EYE PROB/INJURIES/ 1530 TAMARACK ST #218 Sweet Home MT SHADOW TRAILER PARK/ 60612221/",
        "CALL:EYE PROB/INJURIES",
        "ADDR:1530 TAMARACK ST",
        "APT:218",
        "CITY:Sweet Home",
        "PLACE:MT SHADOW TRAILER PARK",
        "MAP:6061",
        "UNIT:2221");

    doTest("T22",
        "TRAUMA INJ/ 3137 SANTIAM HWY SP 11 Sweet Home TRAILER VILLA/ 60632221/",
        "CALL:TRAUMA INJ",
        "ADDR:3137 SANTIAM HWY",
        "APT:11",
        "CITY:Sweet Home",
        "PLACE:TRAILER VILLA",
        "MAP:6063",
        "UNIT:2221");

    doTest("T23",
        "ICOM/400 notification,HOUSE FIRE/ 1173 W SHERMAN ST Lebanon/ 4142A3131/",
        "CALL:HOUSE FIRE",
        "ADDR:1173 W SHERMAN ST",
        "CITY:Lebanon",
        "MAP:4142A",
        "UNIT:3131");

    doTest("T24",
        "FRM:linn911@linnsheriff.org\n" +
        "SUBJ:!\n" +
        "MSG:DIABETIC PROB/32717 OLD MILL RD/06-08-12/21:20:12/63 year old, Male, Conscious, Breathing.  Diabetic/E32/",

        "CALL:DIABETIC PROB",
        "ADDR:32717 OLD MILL RD",
        "DATE:06/08/12",
        "TIME:21:20:12",
        "INFO:63 year old, Male, Conscious, Breathing.  Diabetic",
        "UNIT:E32");
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "[ICOM/400 notification] TEST 1st ALARM FIRE/ 1115 SE JACKSON ST Albany LINN CO SHERIFFS OFFICE/JAIL/ 282511S11/\n",
        "CALL:TEST 1st ALARM FIRE",
        "ADDR:1115 SE JACKSON ST",
        "CITY:Albany",
        "PLACE:LINN CO SHERIFFS OFFICE",
        "X:JAIL",
        "MAP:2825",
        "UNIT:11S11");

    doTest("T2",
        "[ICOM/400 notification] OTH STRCT FIRE/ 36149 RIVERSIDE DR INTERSECTN Linn County  /  OAKVILLE RD/ 30181111/\n",
        "CALL:OTH STRCT FIRE",
        "ADDR:36149 RIVERSIDE DR",
        "X:OAKVILLE RD",
        "MAP:3018",
        "UNIT:1111");

    doTest("T3",
        "[ICOM/400 notification] ALARM-FIRE/ 618 SW WASHINGTON ST Albany/ 282411N11/\n",
        "CALL:ALARM-FIRE",
        "ADDR:618 SW WASHINGTON ST",
        "CITY:Albany",
        "MAP:2824",
        "UNIT:11N11");

    doTest("T4",
        "[ICOM/400 notification] ALARM-FIRE/ 525 SW 25TH AV Albany OREGON FREEZE DRY PLANT #2/ 30241212/\n",
        "CALL:ALARM-FIRE",
        "ADDR:525 SW 25TH AV",
        "MADDR:525 SW 25TH AVE",
        "CITY:Albany",
        "PLACE:OREGON FREEZE DRY PLANT #2",
        "MAP:3024",
        "UNIT:1212");

    doTest("T5",
        "[ICOM/400 notification] ALARM-FIRE/ 1929 SE GRAND PRAIRIE RD Albany VILLAS AT COURTYARD/ 30261212/\n",
        "CALL:ALARM-FIRE",
        "ADDR:1929 SE GRAND PRAIRIE RD",
        "CITY:Albany",
        "PLACE:VILLAS AT COURTYARD",
        "MAP:3026",
        "UNIT:1212");

    doTest("T6",
        "[ICOM/400 notification] TRAF COLLISION/ 3700 NE KNOX BUTTE RD Linn County LINN CO FAIRGROUNDS AND EXPO/ 26291313/\n",
        "CALL:TRAF COLLISION",
        "ADDR:3700 NE KNOX BUTTE RD",
        "PLACE:LINN CO FAIRGROUNDS AND EXPO",
        "MAP:2629",
        "UNIT:1313");

    doTest("T7",
        "[ICOM/400 notification] CARDIAC/RESP ARREST/ 2801 SW UMATILLA ST Albany/ 30231212/\n",
        "CALL:CARDIAC/RESP ARREST",
        "ADDR:2801 SW UMATILLA ST",
        "CITY:Albany",
        "MAP:3023",
        "UNIT:1212");

    doTest("T8",
        "[ICOM/400 notification] A501 Recall Alarm/ TRAF COLLISION/25010 S I5 Linn County MP212 S I5//vehicle was traveling south, put his blinker on to the\n",
        "CALL:A501 Recall Alarm/TRAF COLLISION",
        "ADDR:25010 S I5",
        "MADDR:25010 S I 5",
        "PLACE:MP212 S I5",
        "INFO:vehicle was traveling south, put his blinker on to the");

  }
  
  @Test
  public void testvtzach88() {

    doTest("T1",
        "LINN 911 (!) UNCONC/FAINTING/28290 KINGSBURY RD/08-18-13/10:25:07/80 year old, Male, Unconscious, Breathing.  Unconscious //SHFF SHEMT/ TXT STOP to opt-out",
        "CALL:UNCONC/FAINTING",
        "ADDR:28290 KINGSBURY RD",
        "DATE:08/18/13",
        "TIME:10:25:07",
        "INFO:80 year old, Male, Unconscious, Breathing.  Unconscious",
        "UNIT:SHFF SHEMT");

  }
  
  public static void main(String[] args) {
    new ORLinnCountyParserTest().generateTests("T1");
  }
}