package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
St Louis County, MO
Contact: Steve <steve@stlouisarsenal.com>
Sender: From:bpage@scfa911.org

(.SCFA Page) RESALM  9025 S BROADWAY ST 1614 Map: J28-49, LE Card # 4233 X-St: KAYSER AVE 0.03 mi NE WALLER AVE 0.11 mi SW  14:51
[.SCFA Page] SICK CASE 700 AVENUE H ST 1617 Map: K28-49, LE Card # 4013 X-St: LE Card# 4013 10:14
[.SCFA Page] FALL 815 MARK SHARON CT 1617 Map: L28-49, LE Card # 4158 X-St: LE Card# 4158 13:25
[.SCFA Page] COMMERCIAL FIRE 4232 LA SALETTE DR, Apt. 1C 1614 1114 19 1710 HL3 1617 GTWY1 1604 Map: L28-49, LE Card # 4141 X-St: LE Card# 4141 19:08
[.SCFA Page] DIFFICULTY BREATHING 309 SIGSBEE AVE, Apt. APT C 1617 Map: L30-49, LE Card # 4230 X-St: LE Card# 4230 20:23
[.SCFA Page] ASSAULT DIRT CHEAP AF 8455 GRAVOIS RD 8455 GRAVOIS RD 1617 1134 Map: AF Card# 7015, M27-48 X-St: LAKEWOOD AVE 0.11 mi E LACEY AVE 0.05 mi W 21:32
[.SCFA Page] ALLERGIC REACTION 777 RIVER CITY CASINO BLVD, Apt. FL 1 1617 Map: J28-49, LE CARD # X-St: LE Card# 4314 23:09
[.SCFA Page]  CHEST PAIN  308 SOUTHAMPTON DR 1617 Map: K30-49, LE Card # 4234 X-St: LE Card# 4234   02:45

Contact: Active911
Agency name: Eureka Fire Protection District
Location: Eureka, MO, United States
Sender: ".SCFA Page" <bpage@scfa911.org>

(.SCFA Page)  VEHACC  HIGHWAY W & RIVERS END DR 2417 2434 Map: EU Map# 33 X-St:  20:30 
(.SCFA Page)  DIFFICULTY BREATHING  18726 VIXEN DR 2427 Map: EU Map# 44 X-St: EU Card# 78   06:40 
(.SCFA Page)  SICK CASE  17103 HIDDEN VALLEY FOREST DR 2417 Map: EU Map# 9 X-St: EU Card# 8   02:19 
(.SCFA Page)  ASTFIR 4641 GRAVOIS RD   2434    19:25 
(.SCFA Page)  OBS  5828 HUNTERS FORD RD 2427 Map: EU Map# 26 X-St: EU Card# 136   17:39 
(.SCFA Page)  OBS MARYMOUNT MANOR HEALTH CENTER 313 AUGUSTINE RD 2417 Map: 296, EU Map# 62A X-St: EU Card# 296   16:58 
(.SCFA Page)  FAINTING (NEAR FAINTING) WALMART EU 131 EUREKA TOWNE CENTER DR 131 EUREKA TOWNE CENTER DR 2427 Map: EU Card# 481, EU Map# 5A X-St: EU Card# 481   12:26 
(.SCFA Page)  ASTFIR 5048 HIGHWAY N   2492   PA Map# 71 08:03 
(.SCFA Page)  FALL  16826 ENDERBUSH LN 2417 Map: EU Card# 480, EU Map# 107 X-St: EU Card# 480   22:06 
(.SCFA Page)  ASTFIR 228 E FRANKLIN ST   2424  PA CARD# 6009 PA Map# 132 19:41 
(.SCFA Page)  ASTEMS 16060 CLAYTON RD  [METRO WEST 4] 2417    12:14 
(.SCFA Page)  DIFFICULTY BREATHING MERCY CLINIC FAMILY MEDICINE 407 MERAMEC BLVD 2427 Map: EU Card# 167, EU Map# 6 X-St: EU Card# 167   10:19 
(.SCFA Page)  SICK CASE  505 MAUREEN DR 2417 Map: EU Card# 163, EU Map# 20 X-St: EU Card# 163   04:42 
(.SCFA Page)  FAINTING (NEAR FAINTING) MECC 18701 OLD HIGHWAY 66 2427 2402 Map: EU Map# 70 X-St: EU Card# 152   08:10 
(.SCFA Page)  SICK CASE  520 VIOLA LN 2417 Map: EU Card# 250 X-St: EU Card# 250   20:30 
(.SCFA Page)  VEHACC  2890 HIGHWAY W 2434 2417 Map:  X-St: EU Card# 124   18:27 
(.SCFA Page)  SICK CASE  17254 HILLTOP RIDGE DR 2417 Map: EU Card# 452, EU Map# 105 X-St: EU Card# 452   11:45 
(.SCFA Page)  FALL  17021 ELM TRAIL DR 2427 Map: EU Card# 379, EU Map# 16B X-St: EU Card# 379   11:31 
(.SCFA Page)  SICK CASE  505 MAUREEN DR 2417 Map: EU Card# 163, EU Map# 20 X-St: EU Card# 163   01:50 
(.SCFA Page)  GASOUT  18775 OLD HIGHWAY 66 2424 6115 2402 Map: EU Map# 29 X-St: EU Card# 325   19:07 
(.SCFA Page)  STROKE  10 NICKLAUS CIRCLE DR, Apt. 108 2417 Map: EU Map# 114 X-St: EU Card# 573   17:50 
(.SCFA Page)  SICK CASE EU1 4849 HIGHWAY 109 2417 Map: EU Card# 304, EU Map# 30 X-St: EU Card# 122   16:50 
(.SCFA Page)  ASTEMS  WB I44 & MM 257   2427    16:49 
(.SCFA Page)  ASTEMS  WB I44 & MM 257 2427 Map:  X-St:  16:48 
(.SCFA Page)  CHEST PAIN  20 LEGENDS PKWY 2417 Map:  X-St: EU Card# 34   13:59 
(.SCFA Page)  OBS  772 TOP NOTCH LN 2427 Map: EU Card# 242, EU Map# 65 X-St: EU Card# 242   11:10 
(.SCFA Page)  VEHACC  EB I44 & MM 269.8 2414 1914 2417 1927 Map: EU Card# 390, EU Map# 51 X-St:  11:09 
(.SCFA Page)  DIFFICULTY BREATHING  740 EMERALD OAKS CT 2427 Map: EU Map# 108 X-St: EU Card# 507   22:54 
(.SCFA Page)  SICK CASE  46 SHERMAN DR 2417 Map: EU Map# 36 & 67 X-St: EU Card# 221   21:44 
(.SCFA Page)  ASTEMS 1700 ANTIRE RD   2414 2417    20:44 

*/

public class MOStLouisCountyBParserTest extends BaseParserTest {
  
  public MOStLouisCountyBParserTest() {
    setParser(new MOStLouisCountyBParser(), "ST LOUIS COUNTY", "MO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(.SCFA Page) RESALM  9025 S BROADWAY ST 1614 Map: J28-49, LE Card # 4233 X-St: KAYSER AVE 0.03 mi NE WALLER AVE 0.11 mi SW  14:51",
        "CALL:RESALM",
        "ADDR:9025 S BROADWAY ST",
        "UNIT:1614",
        "MAP:J28-49",
        "X:KAYSER AVE 0.03 mi NE WALLER AVE 0.11 mi SW",
        "INFO:LE Card # 4233",
        "TIME:14:51");

    doTest("T2",
        "[.SCFA Page] SICK CASE 700 AVENUE H ST 1617 Map: K28-49, LE Card # 4013 X-St: LE Card# 4013 10:14",
        "CALL:SICK CASE",
        "ADDR:700 AVENUE H ST",
        "UNIT:1617",
        "MAP:K28-49",
        "INFO:LE Card # 4013",
        "TIME:10:14");

    doTest("T3",
        "[.SCFA Page] FALL 815 MARK SHARON CT 1617 Map: L28-49, LE Card # 4158 X-St: LE Card# 4158 13:25",
        "CALL:FALL",
        "ADDR:815 MARK SHARON CT",
        "UNIT:1617",
        "MAP:L28-49",
        "INFO:LE Card # 4158",
        "TIME:13:25");

    doTest("T4",
        "[.SCFA Page] COMMERCIAL FIRE 4232 LA SALETTE DR, Apt. 1C 1614 1114 19 1710 HL3 1617 GTWY1 1604 Map: L28-49, LE Card # 4141 X-St: LE Card# 4141 19:08",
        "CALL:COMMERCIAL FIRE",
        "ADDR:4232 LA SALETTE DR",
        "APT:1C",
        "UNIT:1614 1114 19 1710 HL3 1617 GTWY1 1604",
        "MAP:L28-49",
        "INFO:LE Card # 4141",
        "TIME:19:08");

    doTest("T5",
        "[.SCFA Page] DIFFICULTY BREATHING 309 SIGSBEE AVE, Apt. APT C 1617 Map: L30-49, LE Card # 4230 X-St: LE Card# 4230 20:23",
        "CALL:DIFFICULTY BREATHING",
        "ADDR:309 SIGSBEE AVE",
        "APT:C",
        "UNIT:1617",
        "MAP:L30-49",
        "INFO:LE Card # 4230",
        "TIME:20:23");

    doTest("T6",
        "[.SCFA Page] ASSAULT DIRT CHEAP AF 8455 GRAVOIS RD 8455 GRAVOIS RD 1617 1134 Map: AF Card# 7015, M27-48 X-St: LAKEWOOD AVE 0.11 mi E LACEY AVE 0.05 mi W 21:32",
        "CALL:ASSAULT",
        "PLACE:DIRT CHEAP AF",
        "ADDR:8455 GRAVOIS RD",
        "UNIT:1617 1134",
        "MAP:M27-48",
        "X:LAKEWOOD AVE 0.11 mi E LACEY AVE 0.05 mi W",
        "INFO:AF Card# 7015",
        "TIME:21:32");

    doTest("T7",
        "[.SCFA Page] ALLERGIC REACTION 777 RIVER CITY CASINO BLVD, Apt. FL 1 1617 Map: J28-49, LE CARD # X-St: LE Card# 4314 23:09",
        "CALL:ALLERGIC REACTION",
        "ADDR:777 RIVER CITY CASINO BLVD",
        "APT:FL 1",
        "UNIT:1617",
        "MAP:J28-49",
        "INFO:LE Card# 4314",
        "TIME:23:09");

    doTest("T8",
        "[.SCFA Page]  CHEST PAIN  308 SOUTHAMPTON DR 1617 Map: K30-49, LE Card # 4234 X-St: LE Card# 4234   02:45",
        "CALL:CHEST PAIN",
        "ADDR:308 SOUTHAMPTON DR",
        "UNIT:1617",
        "MAP:K30-49",
        "INFO:LE Card # 4234",
        "TIME:02:45");

  }
  
  @Test
  public void testEurekaFire() {

    doTest("T1",
        "(.SCFA Page)  VEHACC  HIGHWAY W & RIVERS END DR 2417 2434 Map: EU Map# 33 X-St:  20:30 ",
        "CALL:VEHACC",
        "ADDR:HIGHWAY W & RIVERS END DR",
        "UNIT:2417 2434",
        "MAP:EU Map# 33",
        "TIME:20:30");

    doTest("T2",
        "(.SCFA Page)  DIFFICULTY BREATHING  18726 VIXEN DR 2427 Map: EU Map# 44 X-St: EU Card# 78   06:40 ",
        "CALL:DIFFICULTY BREATHING",
        "ADDR:18726 VIXEN DR",
        "UNIT:2427",
        "MAP:EU Map# 44",
        "INFO:EU Card# 78",
        "TIME:06:40");

    doTest("T3",
        "(.SCFA Page)  SICK CASE  17103 HIDDEN VALLEY FOREST DR 2417 Map: EU Map# 9 X-St: EU Card# 8   02:19 ",
        "CALL:SICK CASE",
        "ADDR:17103 HIDDEN VALLEY FOREST DR",
        "UNIT:2417",
        "MAP:EU Map# 9",
        "INFO:EU Card# 8",
        "TIME:02:19");

    doTest("T4",
        "(.SCFA Page)  ASTFIR 4641 GRAVOIS RD   2434    19:25 ",
        "CALL:ASTFIR",
        "ADDR:4641 GRAVOIS RD",
        "UNIT:2434",
        "TIME:19:25");

    doTest("T5",
        "(.SCFA Page)  OBS  5828 HUNTERS FORD RD 2427 Map: EU Map# 26 X-St: EU Card# 136   17:39 ",
        "CALL:OBS",
        "ADDR:5828 HUNTERS FORD RD",
        "UNIT:2427",
        "MAP:EU Map# 26",
        "INFO:EU Card# 136",
        "TIME:17:39");

    doTest("T6",
        "(.SCFA Page)  OBS MARYMOUNT MANOR HEALTH CENTER 313 AUGUSTINE RD 2417 Map: 296, EU Map# 62A X-St: EU Card# 296   16:58 ",
        "CALL:OBS",
        "PLACE:MARYMOUNT MANOR HEALTH CENTER",
        "ADDR:313 AUGUSTINE RD",
        "UNIT:2417",
        "MAP:296, EU Map# 62A",
        "INFO:EU Card# 296",
        "TIME:16:58");

    doTest("T7",
        "(.SCFA Page)  FAINTING (NEAR FAINTING) WALMART EU 131 EUREKA TOWNE CENTER DR 131 EUREKA TOWNE CENTER DR 2427 Map: EU Card# 481, EU Map# 5A X-St: EU Card# 481   12:26 ",
        "CALL:FAINTING (NEAR FAINTING)",
        "PLACE:WALMART EU",
        "ADDR:131 EUREKA TOWNE CENTER DR",
        "UNIT:2427",
        "MAP:EU Map# 5A",
        "INFO:EU Card# 481",
        "TIME:12:26");

    doTest("T8",
        "(.SCFA Page)  ASTFIR 5048 HIGHWAY N   2492   PA Map# 71 08:03 ",
        "CALL:ASTFIR",
        "ADDR:5048 HIGHWAY N",
        "UNIT:2492   PA Map# 71",
        "TIME:08:03");

    doTest("T9",
        "(.SCFA Page)  FALL  16826 ENDERBUSH LN 2417 Map: EU Card# 480, EU Map# 107 X-St: EU Card# 480   22:06 ",
        "CALL:FALL",
        "ADDR:16826 ENDERBUSH LN",
        "UNIT:2417",
        "MAP:EU Map# 107",
        "INFO:EU Card# 480",
        "TIME:22:06");

    doTest("T10",
        "(.SCFA Page)  ASTFIR 228 E FRANKLIN ST   2424  PA CARD# 6009 PA Map# 132 19:41 ",
        "CALL:ASTFIR",
        "ADDR:228 E FRANKLIN ST",
        "UNIT:2424 PA Map# 132",
        "INFO:PA CARD# 6009",
        "TIME:19:41");

    doTest("T11",
        "(.SCFA Page)  ASTEMS 16060 CLAYTON RD  [METRO WEST 4] 2417    12:14 ",
        "CALL:ASTEMS",
        "ADDR:16060 CLAYTON RD",
        "PLACE:METRO WEST 4",
        "UNIT:2417",
        "TIME:12:14");

    doTest("T12",
        "(.SCFA Page)  DIFFICULTY BREATHING MERCY CLINIC FAMILY MEDICINE 407 MERAMEC BLVD 2427 Map: EU Card# 167, EU Map# 6 X-St: EU Card# 167   10:19 ",
        "CALL:DIFFICULTY BREATHING",
        "PLACE:MERCY CLINIC FAMILY MEDICINE",
        "ADDR:407 MERAMEC BLVD",
        "UNIT:2427",
        "MAP:EU Map# 6",
        "INFO:EU Card# 167",
        "TIME:10:19");

    doTest("T13",
        "(.SCFA Page)  SICK CASE  505 MAUREEN DR 2417 Map: EU Card# 163, EU Map# 20 X-St: EU Card# 163   04:42 ",
        "CALL:SICK CASE",
        "ADDR:505 MAUREEN DR",
        "UNIT:2417",
        "MAP:EU Map# 20",
        "INFO:EU Card# 163",
        "TIME:04:42");

    doTest("T14",
        "(.SCFA Page)  FAINTING (NEAR FAINTING) MECC 18701 OLD HIGHWAY 66 2427 2402 Map: EU Map# 70 X-St: EU Card# 152   08:10 ",
        "CALL:FAINTING (NEAR FAINTING)",
        "PLACE:MECC",
        "ADDR:18701 OLD HIGHWAY 66",
        "UNIT:2427 2402",
        "MAP:EU Map# 70",
        "INFO:EU Card# 152",
        "TIME:08:10");

    doTest("T15",
        "(.SCFA Page)  SICK CASE  520 VIOLA LN 2417 Map: EU Card# 250 X-St: EU Card# 250   20:30 ",
        "CALL:SICK CASE",
        "ADDR:520 VIOLA LN",
        "UNIT:2417",
        "INFO:EU Card# 250",
        "TIME:20:30");

    doTest("T16",
        "(.SCFA Page)  VEHACC  2890 HIGHWAY W 2434 2417 Map:  X-St: EU Card# 124   18:27 ",
        "CALL:VEHACC",
        "ADDR:2890 HIGHWAY W",
        "UNIT:2434 2417",
        "INFO:EU Card# 124",
        "TIME:18:27");

    doTest("T17",
        "(.SCFA Page)  SICK CASE  17254 HILLTOP RIDGE DR 2417 Map: EU Card# 452, EU Map# 105 X-St: EU Card# 452   11:45 ",
        "CALL:SICK CASE",
        "ADDR:17254 HILLTOP RIDGE DR",
        "UNIT:2417",
        "MAP:EU Map# 105",
        "INFO:EU Card# 452",
        "TIME:11:45");

    doTest("T18",
        "(.SCFA Page)  FALL  17021 ELM TRAIL DR 2427 Map: EU Card# 379, EU Map# 16B X-St: EU Card# 379   11:31 ",
        "CALL:FALL",
        "ADDR:17021 ELM TRAIL DR",
        "UNIT:2427",
        "MAP:EU Map# 16B",
        "INFO:EU Card# 379",
        "TIME:11:31");

    doTest("T19",
        "(.SCFA Page)  SICK CASE  505 MAUREEN DR 2417 Map: EU Card# 163, EU Map# 20 X-St: EU Card# 163   01:50 ",
        "CALL:SICK CASE",
        "ADDR:505 MAUREEN DR",
        "UNIT:2417",
        "MAP:EU Map# 20",
        "INFO:EU Card# 163",
        "TIME:01:50");

    doTest("T20",
        "(.SCFA Page)  GASOUT  18775 OLD HIGHWAY 66 2424 6115 2402 Map: EU Map# 29 X-St: EU Card# 325   19:07 ",
        "CALL:GASOUT",
        "ADDR:18775 OLD HIGHWAY 66",
        "UNIT:2424 6115 2402",
        "MAP:EU Map# 29",
        "INFO:EU Card# 325",
        "TIME:19:07");

    doTest("T21",
        "(.SCFA Page)  STROKE  10 NICKLAUS CIRCLE DR, Apt. 108 2417 Map: EU Map# 114 X-St: EU Card# 573   17:50 ",
        "CALL:STROKE",
        "ADDR:10 NICKLAUS CIRCLE DR",
        "APT:108",
        "UNIT:2417",
        "MAP:EU Map# 114",
        "INFO:EU Card# 573",
        "TIME:17:50");

    doTest("T22",
        "(.SCFA Page)  SICK CASE EU1 4849 HIGHWAY 109 2417 Map: EU Card# 304, EU Map# 30 X-St: EU Card# 122   16:50 ",
        "CALL:SICK CASE",
        "PLACE:EU1",
        "ADDR:4849 HIGHWAY 109",
        "UNIT:2417",
        "MAP:EU Map# 30",
        "INFO:EU Card# 304",
        "TIME:16:50");

    doTest("T23",
        "(.SCFA Page)  ASTEMS  WB I44 & MM 257   2427    16:49 ",
        "CALL:ASTEMS",
        "ADDR:WB I-44",
        "MADDR:I 44",
        "UNIT:& MM 257   2427",
        "TIME:16:49");

    doTest("T24",
        "(.SCFA Page)  ASTEMS  WB I44 & MM 257 2427 Map:  X-St:  16:48 ",
        "CALL:ASTEMS",
        "ADDR:WB I-44",
        "MADDR:I 44",
        "UNIT:& MM 257 2427",
        "TIME:16:48");

    doTest("T25",
        "(.SCFA Page)  CHEST PAIN  20 LEGENDS PKWY 2417 Map:  X-St: EU Card# 34   13:59 ",
        "CALL:CHEST PAIN",
        "ADDR:20 LEGENDS PKWY",
        "UNIT:2417",
        "INFO:EU Card# 34",
        "TIME:13:59");

    doTest("T26",
        "(.SCFA Page)  OBS  772 TOP NOTCH LN 2427 Map: EU Card# 242, EU Map# 65 X-St: EU Card# 242   11:10 ",
        "CALL:OBS",
        "ADDR:772 TOP NOTCH LN",
        "UNIT:2427",
        "MAP:EU Map# 65",
        "INFO:EU Card# 242",
        "TIME:11:10");

    doTest("T27",
        "(.SCFA Page)  VEHACC  EB I44 & MM 269.8 2414 1914 2417 1927 Map: EU Card# 390, EU Map# 51 X-St:  11:09 ",
        "CALL:VEHACC",
        "ADDR:EB I-44",
        "MADDR:I 44",
        "UNIT:& MM 269.8 2414 1914 2417 1927",
        "MAP:EU Map# 51",
        "INFO:EU Card# 390",
        "TIME:11:09");

    doTest("T28",
        "(.SCFA Page)  DIFFICULTY BREATHING  740 EMERALD OAKS CT 2427 Map: EU Map# 108 X-St: EU Card# 507   22:54 ",
        "CALL:DIFFICULTY BREATHING",
        "ADDR:740 EMERALD OAKS CT",
        "UNIT:2427",
        "MAP:EU Map# 108",
        "INFO:EU Card# 507",
        "TIME:22:54");

    doTest("T29",
        "(.SCFA Page)  SICK CASE  46 SHERMAN DR 2417 Map: EU Map# 36 & 67 X-St: EU Card# 221   21:44 ",
        "CALL:SICK CASE",
        "ADDR:46 SHERMAN DR",
        "UNIT:2417",
        "MAP:EU Map# 36 & 67",
        "INFO:EU Card# 221",
        "TIME:21:44");

    doTest("T30",
        "(.SCFA Page)  ASTEMS 1700 ANTIRE RD   2414 2417    20:44 ",
        "CALL:ASTEMS",
        "ADDR:1700 ANTIRE RD",
        "UNIT:2414 2417",
        "TIME:20:44");
  
  }
  
  public static void main(String[] args) {
    new MOStLouisCountyBParserTest().generateTests("T1");
  }
}
