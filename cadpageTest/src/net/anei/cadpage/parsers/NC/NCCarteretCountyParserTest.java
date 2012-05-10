package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCCarteretCountyParserTest extends BaseParserTest {
  
  public NCCarteretCountyParserTest() {
    setParser(new NCCarteretCountyParser(), "CARTERET COUNTY", "NC");
  }
  
  @Test
  public void testMainParser() {

    doTest("T1",
        "CEC:303 COLLEGE CIR MOREHEAD CITY FDL 52C03-G 11-090057 12:36:58 ALARM FIRE",
        "ADDR:303 COLLEGE CIR",
        "CITY:MOREHEAD CITY",
        "CODE:52C03-G",
        "ID:11-090057",
        "TIME:12:36:58",
        "CALL:ALARM FIRE");

    doTest("T2",
        "CEC:3905 ARENDELL ST MOREHEAD CITY MDL 30B01 11-090021 11:38:14 TRAUMATIC INJURIES",
        "ADDR:3905 ARENDELL ST",
        "CITY:MOREHEAD CITY",
        "CODE:30B01",
        "ID:11-090021",
        "TIME:11:38:14",
        "CALL:TRAUMATIC INJURIES");

    doTest("T3",
        "CEC:828 S YAUPON TER MOREHEAD CITY 11-089759 20:36:57 CHECK WELFARE",
        "ADDR:828 S YAUPON TER",
        "CITY:MOREHEAD CITY",
        "ID:11-089759",
        "TIME:20:36:57",
        "CALL:CHECK WELFARE");

    doTest("T4",
        "CEC:3722 BRIDGES ST MOREHEAD CITY MDL 10C04 11-089619 15:13:10 CHEST PAIN",
        "ADDR:3722 BRIDGES ST",
        "CITY:MOREHEAD CITY",
        "CODE:10C04",
        "ID:11-089619",
        "TIME:15:13:10",
        "CALL:CHEST PAIN");

    doTest("T5",
        "CEC:2714 MAYBERRY LOOP RD MOREHEAD CITY 11-089532 12:03:48 HEAT - COLD EXPOSURE",
        "ADDR:2714 MAYBERRY LOOP RD",
        "CITY:MOREHEAD CITY",
        "ID:11-089532",
        "TIME:12:03:48",
        "CALL:HEAT - COLD EXPOSURE");

    doTest("T6",
        "CEC:1005 YAUPON DR MOREHEAD CITY 11-088667 20:15:44 OUTSIDE FIRE",
        "ADDR:1005 YAUPON DR",
        "CITY:MOREHEAD CITY",
        "ID:11-088667",
        "TIME:20:15:44",
        "CALL:OUTSIDE FIRE");

    doTest("T7",
        "CEC:3500 ARENDELL ST MOREHEAD CITY 11-089379 04:23:11 TRANSFER (MEDICAL) INTERFACILITY",
        "ADDR:3500 ARENDELL ST",
        "CITY:MOREHEAD CITY",
        "ID:11-089379",
        "TIME:04:23:11",
        "CALL:TRANSFER",
        "INFO:(MEDICAL) INTERFACILITY");

    doTest("T8",
        "CEC:3017 BRIDGES ST MOREHEAD CITY 11-086957 13:07:00 STRUCTURE FIRE",
        "ADDR:3017 BRIDGES ST",
        "CITY:MOREHEAD CITY",
        "ID:11-086957",
        "TIME:13:07:00",
        "CALL:STRUCTURE FIRE");

    doTest("T9",
        "CEC:5018 HWY 70 MOREHEAD CITY 11-088596 16:40:33 MVC UNK PI",
        "ADDR:5018 HWY 70",
        "CITY:MOREHEAD CITY",
        "ID:11-088596",
        "TIME:16:40:33",
        "CALL:MVC UNK PI");

    doTest("T10",
        "CEC:BRIDGES ST ST EXT / HWY 70 11-087512 13:54:18 MVC MINOR",
        "ADDR:BRIDGES ST",
        "MADDR:ST EXT / HWY 70,BRIDGES ST",
        "PLACE:ST EXT / HWY 70",
        "ID:11-087512",
        "TIME:13:54:18",
        "CALL:MVC MINOR");

    doTest("T11",
        "CEC:5167 HWY 70 MOREHEAD CITY FDL 60D03-O 11-087553 15:18:54 GAS LEAK - ODOR (LP or Natural Gas)",
        "ADDR:5167 HWY 70",
        "CITY:MOREHEAD CITY",
        "CODE:60D03-O",
        "ID:11-087553",
        "TIME:15:18:54",
        "CALL:GAS LEAK - ODOR",
        "INFO:(LP or Natural Gas)");

    doTest("T12",
        "CEC:11-082100 08:48:00 SICK PERSON WEST WOOD SQUARE APTS 403 BROOK ST E32 MOREHEAD CITY",
        "ADDR:403 BROOK ST E32",
        "CITY:MOREHEAD CITY",
        "ID:11-082100",
        "TIME:08:48:00",
        "CALL:SICK PERSON WEST WOOD SQUARE APTS");

    doTest("T13",
        "CEC:11-082157 11:29:34 MVC PI OR ROLLOVER WILCO HESS MHC 4TH ST 400 ARENDELL ST MOREHEAD CITY",
        "ADDR:ST 400 ARENDELL ST",
        "MADDR:NC 400 ARENDELL ST",
        "CITY:MOREHEAD CITY",
        "ID:11-082157",
        "TIME:11:29:34",
        "CALL:MVC PI OR ROLLOVER WILCO HESS MHC 4TH");

    doTest("T14",
        "CEC:11-082262 16:31:51 STRUCTURE FIRE 4 VINE LN NEWPORT FDL 69D10",
        "ADDR:4 VINE LN",
        "CITY:NEWPORT",
        "CODE:69D10",
        "ID:11-082262",
        "TIME:16:31:51",
        "CALL:STRUCTURE FIRE");

    doTest("T15",
        "CEC:114 CLUB COLONY DR b ATLANTIC BEACH FDL 52B01-G 11-084908 18:06:28 ALARM FIRE",
        "ADDR:114 CLUB COLONY DR b",
        "CITY:ATLANTIC BEACH",
        "CODE:52B01-G",
        "ID:11-084908",
        "TIME:18:06:28",
        "CALL:ALARM FIRE");

    doTest("T16",
        "CEC:306 CRAVEN ST BEAUFORT MDL 17B03-G 11-089178 19:42:02 FALLS",
        "ADDR:306 CRAVEN ST",
        "CITY:BEAUFORT",
        "CODE:17B03-G",
        "ID:11-089178",
        "TIME:19:42:02",
        "CALL:FALLS");

    doTest("T17",
        "CEC:405 WEST BEAUFORT RD BEAUFORT FDL 69D06 11-085673 04:39:22 STRUCTURE FIRE",
        "ADDR:405 WEST BEAUFORT RD",
        "CITY:BEAUFORT",
        "CODE:69D06",
        "ID:11-085673",
        "TIME:04:39:22",
        "CALL:STRUCTURE FIRE");

    doTest("T18",
        "CEC:HWY 24 / HWY 70 11-088160 17:29:35 MVC PI OR ROLLOVER",
        "ADDR:HWY 24 & HWY 70",
        "ID:11-088160",
        "TIME:17:29:35",
        "CALL:MVC PI OR ROLLOVER");

    doTest("T19",
        "CEC:438 MACON CT MOREHEAD CITY MDL 01A01 11-088343 02:36:15 ABDOMINAL PAIN - PROBLEMS",
        "ADDR:438 MACON CT",
        "CITY:MOREHEAD CITY",
        "CODE:01A01",
        "ID:11-088343",
        "TIME:02:36:15",
        "INFO:ABDOMINAL PAIN - PROBLEMS");

    doTest("T20",
        "CEC:306 CRAVEN ST BEAUFORT MDL 17B03-G 11-089178 19:42:02 FALLS",
        "ADDR:306 CRAVEN ST",
        "CITY:BEAUFORT",
        "CODE:17B03-G",
        "ID:11-089178",
        "TIME:19:42:02",
        "CALL:FALLS");

    doTest("T21",
        "CEC:315 FRONT ST BEAUFORT FDL 52C03-G 11-088849 04:01:34 ALARM FIRE",
        "ADDR:315 FRONT ST",
        "CITY:BEAUFORT",
        "CODE:52C03-G",
        "ID:11-088849",
        "TIME:04:01:34",
        "CALL:ALARM FIRE");

    doTest("T22",
        "CEC:4035 ARENDELL ST rm 226 MOREHEAD CITY 11-089051 14:12:37 BREATHING PROBLEMS",
        "ADDR:4035 ARENDELL ST",
        "APT:226",
        "CITY:MOREHEAD CITY",
        "ID:11-089051",
        "TIME:14:12:37",
        "CALL:BREATHING PROBLEMS");

    doTest("T23",
        "CEC:1805 ARENDELL ST apt b MOREHEAD CITY MDL 26D01 11-088938 09:43:13 SICK PERSON",
        "ADDR:1805 ARENDELL ST",
        "APT:b",
        "CITY:MOREHEAD CITY",
        "CODE:26D01",
        "ID:11-088938",
        "TIME:09:43:13",
        "CALL:SICK PERSON");
  }
  
  @Test
  public void testSeaLevelParser() {

    doTest("T1",
        "CEC:272 HWY 70 SEA LEVEL SEA LEVEL 11-087105 20:00:18 HEART PROB -DEFIB",
        "ADDR:272 HWY 70",
        "CITY:SEA LEVEL",
        "ID:11-087105",
        "TIME:20:00:18",
        "CALL:HEART PROB -DEFIB");

    doTest("T2",
        "CEC:272 HWY 70 SEA LEVEL SEA LEVEL 11-090344 23:57:53 SICK PERSON",
        "ADDR:272 HWY 70",
        "CITY:SEA LEVEL",
        "ID:11-090344",
        "TIME:23:57:53",
        "CALL:SICK PERSON");

    doTest("T3",
        "CEC:1056 HWY 70 DAVIS DAVIS MDL 28C01-L 11-090093 13:50:12 STROKE",
        "ADDR:1056 HWY 70",
        "CITY:DAVIS",
        "CODE:28C01-L",
        "ID:11-090093",
        "TIME:13:50:12",
        "CALL:STROKE");

    doTest("T4",
        "CEC:468 HWY 70 SEA LEVEL SEA LEVEL MDL 06D02 11-088385 08:00:04 BREATHING PROBLEMS",
        "ADDR:468 HWY 70",
        "CITY:SEA LEVEL",
        "CODE:06D02",
        "ID:11-088385",
        "TIME:08:00:04",
        "CALL:BREATHING PROBLEMS");

    doTest("T5",
        "CEC:1133 HWY 70 STACY STACY MDL 28C01-L 11-086390 13:22:20 STROKE",
        "ADDR:1133 HWY 70",
        "CITY:STACY",
        "CODE:28C01-L",
        "ID:11-086390",
        "TIME:13:22:20",
        "CALL:STROKE");

    doTest("T6",
        "CEC:1185 SEASHORE DR ATLANTIC MDL 09E01 11-084435 20:18:33 UNCONSCIOUS - FAINTING",
        "ADDR:1185 SEASHORE DR",
        "CITY:ATLANTIC",
        "CODE:09E01",
        "ID:11-084435",
        "TIME:20:18:33",
        "INFO:UNCONSCIOUS - FAINTING");
    
  }
  
  @Test
  public void testOtherParser() {

    doTest("T1",
        "wcfd.comm2+caf_=2522413726=vtext.com@gmail.com CEC:392 CROATAN DR CAPE CARTERET MDL 01D01 11-109565 11:32:17 FALLS",
        "ADDR:392 CROATAN DR",
        "CITY:CAPE CARTERET",
        "CODE:01D01",
        "ID:11-109565",
        "TIME:11:32:17",
        "CALL:FALLS");

    doTest("T2",
        "wcfd.comm2+caf_=2522413726=vtext.com@gmail.com CEC:129 HUNTER BROWN DR CAPE CARTERET 11-113600 16:24:22 STROKE",
        "ADDR:129 HUNTER BROWN DR",
        "CITY:CAPE CARTERET",
        "ID:11-113600",
        "TIME:16:24:22",
        "CALL:STROKE");
  
  }
  
  public static void main(String[] args) {
    new NCCarteretCountyParserTest().generateTests("T1", "ADDR APT CITY PLACE CODE ID TIME CALL INFO");
  }
}
