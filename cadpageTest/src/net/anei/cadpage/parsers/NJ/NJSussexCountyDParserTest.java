package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Sussex County, NJ (Hopatcong)
Contact: Peter Calbo <wfas340@yahoo.com>
Sender: noreply@hopatcongpd.org

(Fire Page) EMS CAD#: 13-00549\nTime of Call: 7:14:27 PM\n232 Chincopee Avenue\nType of EMS Call: \nNotes: Latitude: +040.968899 Longitude: -074.652168\n7:1
(Fire Page) EMS CAD#: 13-00552\nTime of Call: 10:01:40 PM\n68 Leo Avenue\nType of EMS Call: \nNotes: 9:59:17 PM 60 yof abdominal pain
(Fire Page) EMS CAD#: 13-00553\nTime of Call: 10:25:15 AM\n4 Reynard Road\nType of EMS Call: Diff Breathing / ALS\nNotes: 74 YOM  Op 68 & 65 to bldg & op 32
(Fire Page) EMS CAD#: 13-00553\nTime of Call: 10:25:15 AM\n4 Reynard Road\nType of EMS Call: Diff Breathing / ALS\nNotes: 74 YOM\2sOp 68 & 65 to bldg & op 32
(Fire Page) EMS CAD#: 13-00556\nTime of Call: 1:51:40 PM\n40 Lakeside Boulevard\nType of EMS Call: Seizure/ALS\nNotes: Male in seizures. NFIA. 233 on anothe
(Fire Page) EMS CAD#: 13-00559\nTime of Call: 6:02:41 PM\n5 Walton Way\nType of EMS Call: \nNotes: Latitude:             Longitude:            6:02:24 PM\n6
(Fire Page) EMS CAD#: 13-00560\nTime of Call: 4:38:19 AM\n111 Frances Avenue\nType of EMS Call: \nNotes: female having seizures

 */

public class NJSussexCountyDParserTest extends BaseParserTest {
  
  public NJSussexCountyDParserTest() {
    setParser(new NJSussexCountyDParser(), "SUSSEX COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {


    doTest("T1",
        "(Fire Page) EMS CAD#: 13-00549\n" +
        "Time of Call: 7:14:27 PM\n" +
        "232 Chincopee Avenue\n" +
        "Type of EMS Call: \n" +
        "Notes: Latitude: +040.968899 Longitude: -074.652168\n" +
        "7:1",

        "ID:13-00549",
        "TIME:19:14:27",
        "ADDR:232 Chincopee Avenue",
        "GPS:+40.968899,-74.652168",
        "INFO:7:1");

    doTest("T2",
        "(Fire Page) EMS CAD#: 13-00552\nTime of Call: 10:01:40 PM\n68 Leo Avenue\nType of EMS Call: \nNotes: 9:59:17 PM 60 yof abdominal pain",
        "ID:13-00552",
        "TIME:22:01:40",
        "ADDR:68 Leo Avenue",
        "INFO:9:59:17 PM 60 yof abdominal pain");

    doTest("T3",
        "(Fire Page) EMS CAD#: 13-00553\n" +
        "Time of Call: 10:25:15 AM\n" +
        "4 Reynard Road\n" +
        "Type of EMS Call: Diff Breathing / ALS\n" +
        "Notes: 74 YOM  Op 68 & 65 to bldg & op 32",

        "ID:13-00553",
        "TIME:10:25:15",
        "ADDR:4 Reynard Road",
        "CALL:Diff Breathing / ALS",
        "INFO:74 YOM  Op 68 & 65 to bldg & op 32");


    doTest("T4",
        "(Fire Page) EMS CAD#: 13-00553\n" +
        "Time of Call: 10:25:15 AM\n" +
        "4 Reynard Road\n" +
        "Type of EMS Call: Diff Breathing / ALS\n" +
        "Notes: 74 YOM\\2sOp 68 & 65 to bldg & op 32",

        "ID:13-00553",
        "TIME:10:25:15",
        "ADDR:4 Reynard Road",
        "CALL:Diff Breathing / ALS",
        "INFO:74 YOM\\2sOp 68 & 65 to bldg & op 32");

    doTest("T5",
        "(Fire Page) EMS CAD#: 13-00556\n" +
        "Time of Call: 1:51:40 PM\n" +
        "40 Lakeside Boulevard\n" +
        "Type of EMS Call: Seizure/ALS\n" +
        "Notes: Male in seizures. NFIA. 233 on anothe",

        "ID:13-00556",
        "TIME:13:51:40",
        "ADDR:40 Lakeside Boulevard",
        "CALL:Seizure/ALS",
        "INFO:Male in seizures. NFIA. 233 on anothe");

    doTest("T6",
        "(Fire Page) EMS CAD#: 13-00559\n" +
        "Time of Call: 6:02:41 PM\n" +
        "5 Walton Way\n" +
        "Type of EMS Call: \n" +
        "Notes: Latitude:             Longitude:            6:02:24 PM\n" +
        "6",

        "ID:13-00559",
        "TIME:18:02:41",
        "ADDR:5 Walton Way",
        "INFO:6");

    doTest("T7",
        "(Fire Page) EMS CAD#: 13-00560\nTime of Call: 4:38:19 AM\n111 Frances Avenue\nType of EMS Call: \nNotes: female having seizures",
        "ID:13-00560",
        "TIME:04:38:19",
        "ADDR:111 Frances Avenue",
        "INFO:female having seizures");
}
  
  public static void main(String[] args) {
    new NJSussexCountyDParserTest().generateTests("T1");
  }
}