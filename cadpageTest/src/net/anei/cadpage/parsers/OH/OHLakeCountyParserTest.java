package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Lake County, OH
Contact: Active911
Agency name: Concord Fire Dept
Location: Concord, OH, United States
Sender: ingr.com@archwireless.net

Location: 69 E PROSPECT ST PC Cross Streets: WARNER ST COURTLAND ST Type Code: FIRE Sub Type: RESIDE Time: 13:03:08 
Location: 828 LIBERTY ST PA Cross Streets: BANK ST UNNAMED STREET Type Code: ILLNESS Sub Type: GENERAL Time: 09:19:01 
Location: 2050 I 90 HWY LE Cross Streets: Type Code: ACCIDENT Sub Type: INJACC Time: 07:19:04 
Location: 187 HAWTHORNE DR PA Cross Streets: BUCKEYE RD WOODLAND RD Type Code: FIRE Sub Type: RESIDE Time: 03:19:22 
Location: 2036 I 90 HWY CO Cross Streets: Type Code: ACCIDENT Sub Type: INJACC Time: 17:12:45 
Location: 3 W ERIE ST PC Cross Streets: MENTOR AV W TO W ERIE ST E RICHMOND ST Type Code: FIRE Sub Type: BUSINES Time: 08:37:30 

Contact: Active911
Agency name: Madison Fire
Location: Madison, OH, United States
Sender: ingr.com@usamobility.net

Location: 6270 N RIDGE RD MA Cross Streets: BURNS RD STONEYRIDGE DR Type Code: TRANSFER Sub Type: NON_ER Time: 22:42:38 Comments: LW 
Location: 486 HYDER DR MV Cross Streets: ROSS RD Type Code: FALL Sub Type: INJURY Time: 11:00:16 
Location: 6771 DAVE DR MA Cross Streets: NORTH TR DRIVEWAY Type Code: UNCON Sub Type: UNCON Time: 07:36:27 
Location: 6831 CHAPEL RD MA Cross Streets: DRIVEWAY BENNETT RD Type Code: BREATH Sub Type: PROBLEM Time: 22:48:39 
Location: 6192 INVERNESS ST MA Cross Streets: Type Code: FALL Sub Type: INJURY Time: 17:44:34 Comments: FEMALE JUST WOKE UP ON THE FLOOR, UNK HOW SHE GOT THERE 
Location: 4828 PALISADE DR MA Cross Streets: RIVERDALE DR RIVER RD Type Code: FALL Sub Type: INJURY Time: 17:40:43 
Location: 1963 HUBBARD RD MA Cross Streets: CHAPEL RD WHISPERING SANDS DR Type Code: ILLNESS Sub Type: GENERAL Time: 16:29:05 
Location: 6080 N RIDGE RD MA Cross Streets: GREEN RD BURNS RD Type Code: ACCIDENT Sub Type: INJACC Time: 15:36:46 
Location: 6550 N RIDGE RD MA Cross Streets: MORNINGSTAR DR DERUBERTIS DR Type Code: CHEST Sub Type: PAINS Time: 13:42:17 
Location: 1963 HUBBARD RD MA Cross Streets: CHAPEL RD WHISPERING SANDS DR Type Code: ILLNESS Sub Type: GENERAL Time: 13:11:02 
Location: 2041 HUBBARD RD MA Cross Streets: COUNTYARD DR CHAPEL RD Type Code: BLEED Sub Type: BLEED Time: 10:12:56 Comments: CLOTS 
Location: 7927 MIDDLE RIDGE RD MA Cross Streets: DRIVEWAY Type Code: FALL Sub Type: INJURY Time: 09:22:01 
Location: 7164 LAKE RD MA Cross Streets: DRIVEWAY ARTHUR CT Type Code: PAIN Sub Type: PAIN Time: 08:20:28 
Location: 1841 LAKESIDE DR MA APT: 9 Cross Streets: UNNAMED STREET HAINES RD Type Code: BREATH Sub Type: PROBLEM Time: 07:58:08 
Location: 1962 SANDGATE RD MA Cross Streets: HOMESTEAD DR NORTHWAY RD Type Code: BREATH Sub Type: PROBLEM Time: 19:15:42 
Location: 7927 MIDDLE RIDGE RD MA Cross Streets: DRIVEWAY Type Code: DIABET Sub Type: DIABETIC Time: 16:42:58 
Location: 2 HAWAIIAN DR MA Cross Streets: WAIKIKI DR WAIKIKI DR Type Code: HEART Sub Type: PROBLEM Time: 14:45:38 
Location: 5423 S RIDGE RD MA Cross Streets: TOWNLINE RD WOOD RD Type Code: BREATH Sub Type: PROBLEM Time: 11:49:01 
Location: 6067 N RIDGE RD MA Cross Streets: GREEN RD BURNS RD Type Code: CHEST Sub Type: PAINS Time: 08:32:06 
Location: 2050 I 90 HWY LE Cross Streets: Type Code: ACCIDENT Sub Type: INJACC Time: 07:19:04 
Cross Streets: CHAPEL RD HUBBARD RD Type Code: ODOR Sub Type: CHECK Time: 11:56:35 

Contact: Active911
Agency name: Perry Joint Fire District
Location: Perry, OH, United States
Sender: ingr.com@usamobility.net

Location: 4060 MAIN ST PV Cross Streets: CENTER RD MAPLE ST Type Code: PAIN Sub Type: PAIN Time: 21:27:22
Location: 2501 N RIDGE RD PE Cross Streets: Type Code: ACCIDENT Sub Type: INJACC Time: 16:13:23
Location: 3160 MAINE AV PE Cross Streets: OREGON ST MILL POND CI Type Code: CODET Sub Type: ILLNESS Time: 10:58:47
Location: 74 SANDS BL MA Cross Streets: THIRD ST FOURTH ST Type Code: FIRE Sub Type: RESIDE Time: 10:15:52
Location: 3918 MAIN ST PV Cross Streets: CENTER RD MAPLE ST Type Code: FIRE Sub Type: ALARM Time: 10:10:21
Location: 3870 S RIDGE RD PE Cross Streets: LANE RD SHEPARD RD Type Code: PAIN Sub Type: PAIN Time: 08:51:04
Location: 132 PARADISE BL MA Cross Streets: PUPULE CI PALM BL Type Code: ACCIDENT Sub Type: INJACC Time: 19:15:36
Location: 4075 CALL RD PV Cross Streets: Type Code: CODET Sub Type: INVEST Time: 18:43:15
Location: 4075 CALL Cross Streets: Type Code: CODET Sub Type: INVEST Time: 18:42:56
Location: 2826 N RIDGE RD PE Cross Streets: LANE RD EX DRIVEWAY Type Code: BREATH Sub Type: PROBLEM Time: 16:01:57
Location: 4780 BALDWIN RD PE Cross Streets: GREENING AV Type Code: FIRE Sub Type: RESIDE Time: 14:41:11
Location: 4623 WEBB RD PE Cross Streets: WELLINGTON DR S RIDGE RD Type Code: BREATH Sub Type: PROBLEM Time: 14:23:40 Comments: F 30WKS ALONG
Cross Streets: HARDY RD LAKE RD Type Code: SPCSIT Sub Type: WRESCUE Time: 15:39:20
Location: 3667 BLACKMORE RD PE Cross Streets: N RIDGE RD NIAGRA AV Type Code: CHEST Sub Type: PAINS Time: 14:12:12 Comments: 84 YOF
Location: 4734 DAVIS RD PE Cross Streets: S PINE LN CALL RD Type Code: DIABET Sub Type: DIABETIC Time: 03:43:11
Location: 2990 MAINE AV PE Cross Streets: FLORIDA ST OREGON ST Type Code: ILLNESS Sub Type: GENERAL Time: 17:19:04
Location: 2348 TOWNLINE RD NP Cross Streets: GREENBRIAR LN LOCKWOOD RD Type Code: DIABET Sub Type: DIABETIC Time: 16:42:19 Comments: LOW SUGAR MALE 62 YOA
Location: 1843 CLYDE RD MA Cross Streets: DOUGLAS DR TWEED LN Type Code: FIRE Sub Type: RESIDE Time: 10:45:42
Location: 4228 MIDDLE RIDGE RD PE Cross Streets: SUCCESS BL LAUREL DR Type Code: LOCKIN Sub Type: VEHICLE Time: 12:56:16
Location: 3122 N RIDGE RD PE Cross Streets: BLACKMORE RD OHIO ST Type Code: FALL Sub Type: INJURY Time: 09:00:57
Location: 4699 MIDDLE RIDGE RD PE Cross Streets: CALL RD AZALEA RIDGE DR Type Code: WIRES Sub Type: DOWN Time: 07:40:21
Location: 3235 ELIZABETH DR PE APT: J40 Cross Streets: CALL RD Type Code: CODET Sub Type: INVEST Time: 20:39:21
Location: 3059 N RIDGE RD PE Cross Streets: BLACKMORE RD OHIO ST Type Code: ACCIDENT Sub Type: INJACC Time: 18:20:38
Location: 6412 N RIDGE RD MA Cross Streets: MORNINGSTAR DR DERUBERTIS DR Type Code: FIRE Sub Type: RESIDE Time: 10:51:08
Location: 7925 PROCTOR RD LE Cross Streets: RADCLIFFE RD PAINESVILLE WARREN RD Type Code: FIRE Sub Type: RESIDE Time: 22:31:15
Location: 3753 MAIN ST PV Cross Streets: NARROWS RD CENTER RD Type Code: FIRE Sub Type: ALARM Time: 14:31:53
Location: 3610 MAIN ST PV Cross Streets: NARROWS RD CENTER RD Type Code: ACCIDENT Sub Type: INJACC Time: 13:26:53
Location: 5585 N RIDGE RD MA Cross Streets: MCMACKIN RD HAINES RD Type Code: FIRE Sub Type: RESIDE Time: 06:44:08
Location: 2586 RIVERSIDE DR PE Cross Streets: CANYON RIDGE DR MADISON AV Type Code: FALL Sub Type: INJURY Time: 01:23:00
Location: 1074 DOCK RD MA Cross Streets: ANGELA LN NORTON DR Type Code: FIRE Sub Type: RESIDE Time: 05:59:43
Cross Streets: N RIDGE RD TOWNLINE RD Type Code: ACCIDENT Sub Type: INJACC Time: 05:54:43
Location: 3235 ELIZABETH DR PE Cross Streets: CALL RD Type Code: CODET Sub Type: INVEST Time: 05:00:48

 */

public class OHLakeCountyParserTest extends BaseParserTest {
  
  public OHLakeCountyParserTest() {
    setParser(new OHLakeCountyParser(), "LAKE COUNTY", "OH");
  }
  
  @Test
  public void testConcordFire() {

    doTest("T1",
        "Location: 69 E PROSPECT ST PC Cross Streets: WARNER ST COURTLAND ST Type Code: FIRE Sub Type: RESIDE Time: 13:03:08 ",
        "ADDR:69 E PROSPECT ST",
        "CITY:PAINSVILLE",
        "X:WARNER ST / COURTLAND ST",
        "CALL:FIRE - RESIDE",
        "TIME:13:03:08");

    doTest("T2",
        "Location: 828 LIBERTY ST PA Cross Streets: BANK ST UNNAMED STREET Type Code: ILLNESS Sub Type: GENERAL Time: 09:19:01 ",
        "ADDR:828 LIBERTY ST",
        "CITY:PAINSVILLE",
        "X:BANK ST / UNNAMED STREET",
        "CALL:ILLNESS - GENERAL",
        "TIME:09:19:01");

    doTest("T3",
        "Location: 2050 I 90 HWY LE Cross Streets: Type Code: ACCIDENT Sub Type: INJACC Time: 07:19:04 ",
        "ADDR:2050 I 90 HWY",
        "MADDR:2050 I 90",
        "CITY:LEROY TWP",
        "CALL:ACCIDENT - INJACC",
        "TIME:07:19:04");

    doTest("T4",
        "Location: 187 HAWTHORNE DR PA Cross Streets: BUCKEYE RD WOODLAND RD Type Code: FIRE Sub Type: RESIDE Time: 03:19:22 ",
        "ADDR:187 HAWTHORNE DR",
        "CITY:PAINSVILLE",
        "X:BUCKEYE RD / WOODLAND RD",
        "CALL:FIRE - RESIDE",
        "TIME:03:19:22");

    doTest("T5",
        "Location: 2036 I 90 HWY CO Cross Streets: Type Code: ACCIDENT Sub Type: INJACC Time: 17:12:45 ",
        "ADDR:2036 I 90 HWY",
        "MADDR:2036 I 90",
        "CITY:CONCORD TWP",
        "CALL:ACCIDENT - INJACC",
        "TIME:17:12:45");

    doTest("T6",
        "Location: 3 W ERIE ST PC Cross Streets: MENTOR AV W TO W ERIE ST E RICHMOND ST Type Code: FIRE Sub Type: BUSINES Time: 08:37:30 ",
        "ADDR:3 W ERIE ST",
        "CITY:PAINSVILLE",
        "X:MENTOR AV W / TO W ERIE ST E RICHMOND ST",
        "CALL:FIRE - BUSINES",
        "TIME:08:37:30");

  }
  
  @Test
  public void testMadisonFire() {

    doTest("T1",
        "Location: 6270 N RIDGE RD MA Cross Streets: BURNS RD STONEYRIDGE DR Type Code: TRANSFER Sub Type: NON_ER Time: 22:42:38 Comments: LW ",
        "ADDR:6270 N RIDGE RD",
        "CITY:MADISON",
        "X:BURNS RD / STONEYRIDGE DR",
        "CALL:TRANSFER - NON_ER",
        "TIME:22:42:38",
        "INFO:LW");

    doTest("T2",
        "Location: 486 HYDER DR MV Cross Streets: ROSS RD Type Code: FALL Sub Type: INJURY Time: 11:00:16 ",
        "ADDR:486 HYDER DR",
        "CITY:MADISON",
        "X:ROSS RD",
        "CALL:FALL - INJURY",
        "TIME:11:00:16");

    doTest("T3",
        "Location: 6771 DAVE DR MA Cross Streets: NORTH TR DRIVEWAY Type Code: UNCON Sub Type: UNCON Time: 07:36:27 ",
        "ADDR:6771 DAVE DR",
        "CITY:MADISON",
        "X:NORTH TR DRIVEWAY",
        "CALL:UNCON - UNCON",
        "TIME:07:36:27");

    doTest("T4",
        "Location: 6831 CHAPEL RD MA Cross Streets: DRIVEWAY BENNETT RD Type Code: BREATH Sub Type: PROBLEM Time: 22:48:39 ",
        "ADDR:6831 CHAPEL RD",
        "CITY:MADISON",
        "X:DRIVEWAY BENNETT RD",
        "CALL:BREATH - PROBLEM",
        "TIME:22:48:39");

    doTest("T5",
        "Location: 6192 INVERNESS ST MA Cross Streets: Type Code: FALL Sub Type: INJURY Time: 17:44:34 Comments: FEMALE JUST WOKE UP ON THE FLOOR, UNK HOW SHE GOT THERE ",
        "ADDR:6192 INVERNESS ST",
        "CITY:MADISON",
        "CALL:FALL - INJURY",
        "TIME:17:44:34",
        "INFO:FEMALE JUST WOKE UP ON THE FLOOR, UNK HOW SHE GOT THERE");

    doTest("T6",
        "Location: 4828 PALISADE DR MA Cross Streets: RIVERDALE DR RIVER RD Type Code: FALL Sub Type: INJURY Time: 17:40:43 ",
        "ADDR:4828 PALISADE DR",
        "CITY:MADISON",
        "X:RIVERDALE DR / RIVER RD",
        "CALL:FALL - INJURY",
        "TIME:17:40:43");

    doTest("T7",
        "Location: 1963 HUBBARD RD MA Cross Streets: CHAPEL RD WHISPERING SANDS DR Type Code: ILLNESS Sub Type: GENERAL Time: 16:29:05 ",
        "ADDR:1963 HUBBARD RD",
        "CITY:MADISON",
        "X:CHAPEL RD / WHISPERING SANDS DR",
        "CALL:ILLNESS - GENERAL",
        "TIME:16:29:05");

    doTest("T8",
        "Location: 6080 N RIDGE RD MA Cross Streets: GREEN RD BURNS RD Type Code: ACCIDENT Sub Type: INJACC Time: 15:36:46 ",
        "ADDR:6080 N RIDGE RD",
        "CITY:MADISON",
        "X:GREEN RD / BURNS RD",
        "CALL:ACCIDENT - INJACC",
        "TIME:15:36:46");

    doTest("T9",
        "Location: 6550 N RIDGE RD MA Cross Streets: MORNINGSTAR DR DERUBERTIS DR Type Code: CHEST Sub Type: PAINS Time: 13:42:17 ",
        "ADDR:6550 N RIDGE RD",
        "CITY:MADISON",
        "X:MORNINGSTAR DR / DERUBERTIS DR",
        "CALL:CHEST - PAINS",
        "TIME:13:42:17");

    doTest("T10",
        "Location: 1963 HUBBARD RD MA Cross Streets: CHAPEL RD WHISPERING SANDS DR Type Code: ILLNESS Sub Type: GENERAL Time: 13:11:02 ",
        "ADDR:1963 HUBBARD RD",
        "CITY:MADISON",
        "X:CHAPEL RD / WHISPERING SANDS DR",
        "CALL:ILLNESS - GENERAL",
        "TIME:13:11:02");

    doTest("T11",
        "Location: 2041 HUBBARD RD MA Cross Streets: COUNTYARD DR CHAPEL RD Type Code: BLEED Sub Type: BLEED Time: 10:12:56 Comments: CLOTS ",
        "ADDR:2041 HUBBARD RD",
        "CITY:MADISON",
        "X:COUNTYARD DR / CHAPEL RD",
        "CALL:BLEED - BLEED",
        "TIME:10:12:56",
        "INFO:CLOTS");

    doTest("T12",
        "Location: 7927 MIDDLE RIDGE RD MA Cross Streets: DRIVEWAY Type Code: FALL Sub Type: INJURY Time: 09:22:01 ",
        "ADDR:7927 MIDDLE RIDGE RD",
        "CITY:MADISON",
        "X:DRIVEWAY",
        "CALL:FALL - INJURY",
        "TIME:09:22:01");

    doTest("T13",
        "Location: 7164 LAKE RD MA Cross Streets: DRIVEWAY ARTHUR CT Type Code: PAIN Sub Type: PAIN Time: 08:20:28 ",
        "ADDR:7164 LAKE RD",
        "CITY:MADISON",
        "X:DRIVEWAY ARTHUR CT",
        "CALL:PAIN - PAIN",
        "TIME:08:20:28");

    doTest("T14",
        "Location: 1841 LAKESIDE DR MA APT: 9 Cross Streets: UNNAMED STREET HAINES RD Type Code: BREATH Sub Type: PROBLEM Time: 07:58:08 ",
        "ADDR:1841 LAKESIDE DR",
        "APT:9",
        "CITY:MADISON",
        "X:UNNAMED STREET / HAINES RD",
        "CALL:BREATH - PROBLEM",
        "TIME:07:58:08");

    doTest("T15",
        "Location: 1962 SANDGATE RD MA Cross Streets: HOMESTEAD DR NORTHWAY RD Type Code: BREATH Sub Type: PROBLEM Time: 19:15:42 ",
        "ADDR:1962 SANDGATE RD",
        "CITY:MADISON",
        "X:HOMESTEAD DR / NORTHWAY RD",
        "CALL:BREATH - PROBLEM",
        "TIME:19:15:42");

    doTest("T16",
        "Location: 7927 MIDDLE RIDGE RD MA Cross Streets: DRIVEWAY Type Code: DIABET Sub Type: DIABETIC Time: 16:42:58 ",
        "ADDR:7927 MIDDLE RIDGE RD",
        "CITY:MADISON",
        "X:DRIVEWAY",
        "CALL:DIABET - DIABETIC",
        "TIME:16:42:58");

    doTest("T17",
        "Location: 2 HAWAIIAN DR MA Cross Streets: WAIKIKI DR WAIKIKI DR Type Code: HEART Sub Type: PROBLEM Time: 14:45:38 ",
        "ADDR:2 HAWAIIAN DR",
        "CITY:MADISON",
        "X:WAIKIKI DR / WAIKIKI DR",
        "CALL:HEART - PROBLEM",
        "TIME:14:45:38");

    doTest("T18",
        "Location: 5423 S RIDGE RD MA Cross Streets: TOWNLINE RD WOOD RD Type Code: BREATH Sub Type: PROBLEM Time: 11:49:01 ",
        "ADDR:5423 S RIDGE RD",
        "CITY:MADISON",
        "X:TOWNLINE RD / WOOD RD",
        "CALL:BREATH - PROBLEM",
        "TIME:11:49:01");

    doTest("T19",
        "Location: 6067 N RIDGE RD MA Cross Streets: GREEN RD BURNS RD Type Code: CHEST Sub Type: PAINS Time: 08:32:06 ",
        "ADDR:6067 N RIDGE RD",
        "CITY:MADISON",
        "X:GREEN RD / BURNS RD",
        "CALL:CHEST - PAINS",
        "TIME:08:32:06");

    doTest("T20",
        "Location: 2050 I 90 HWY LE Cross Streets: Type Code: ACCIDENT Sub Type: INJACC Time: 07:19:04 ",
        "ADDR:2050 I 90 HWY",
        "MADDR:2050 I 90",
        "CITY:LEROY TWP",
        "CALL:ACCIDENT - INJACC",
        "TIME:07:19:04");

    doTest("T21",
        "Cross Streets: CHAPEL RD HUBBARD RD Type Code: ODOR Sub Type: CHECK Time: 11:56:35 ",
        "ADDR:CHAPEL RD & HUBBARD RD",
        "CALL:ODOR - CHECK",
        "TIME:11:56:35");
   
  }
  
  @Test
  public void testPerryJointFire() {

    doTest("T1",
        "Location: 4060 MAIN ST PV Cross Streets: CENTER RD MAPLE ST Type Code: PAIN Sub Type: PAIN Time: 21:27:22",
        "ADDR:4060 MAIN ST",
        "CITY:PERRY",
        "X:CENTER RD / MAPLE ST",
        "CALL:PAIN - PAIN",
        "TIME:21:27:22");

    doTest("T2",
        "Location: 2501 N RIDGE RD PE Cross Streets: Type Code: ACCIDENT Sub Type: INJACC Time: 16:13:23",
        "ADDR:2501 N RIDGE RD",
        "CITY:PERRY",
        "CALL:ACCIDENT - INJACC",
        "TIME:16:13:23");

    doTest("T3",
        "Location: 3160 MAINE AV PE Cross Streets: OREGON ST MILL POND CI Type Code: CODET Sub Type: ILLNESS Time: 10:58:47",
        "ADDR:3160 MAINE AV",
        "MADDR:3160 MAINE AVE",
        "CITY:PERRY",
        "X:OREGON ST / MILL POND CI",
        "CALL:CODET - ILLNESS",
        "TIME:10:58:47");

    doTest("T4",
        "Location: 74 SANDS BL MA Cross Streets: THIRD ST FOURTH ST Type Code: FIRE Sub Type: RESIDE Time: 10:15:52",
        "ADDR:74 SANDS BL",
        "CITY:MADISON",
        "X:THIRD ST / FOURTH ST",
        "CALL:FIRE - RESIDE",
        "TIME:10:15:52");

    doTest("T5",
        "Location: 3918 MAIN ST PV Cross Streets: CENTER RD MAPLE ST Type Code: FIRE Sub Type: ALARM Time: 10:10:21",
        "ADDR:3918 MAIN ST",
        "CITY:PERRY",
        "X:CENTER RD / MAPLE ST",
        "CALL:FIRE - ALARM",
        "TIME:10:10:21");

    doTest("T6",
        "Location: 3870 S RIDGE RD PE Cross Streets: LANE RD SHEPARD RD Type Code: PAIN Sub Type: PAIN Time: 08:51:04",
        "ADDR:3870 S RIDGE RD",
        "CITY:PERRY",
        "X:LANE RD / SHEPARD RD",
        "CALL:PAIN - PAIN",
        "TIME:08:51:04");

    doTest("T7",
        "Location: 132 PARADISE BL MA Cross Streets: PUPULE CI PALM BL Type Code: ACCIDENT Sub Type: INJACC Time: 19:15:36",
        "ADDR:132 PARADISE BL",
        "CITY:MADISON",
        "X:PUPULE CI / PALM BL",
        "CALL:ACCIDENT - INJACC",
        "TIME:19:15:36");

    doTest("T8",
        "Location: 4075 CALL RD PV Cross Streets: Type Code: CODET Sub Type: INVEST Time: 18:43:15",
        "ADDR:4075 CALL RD",
        "CITY:PERRY",
        "CALL:CODET - INVEST",
        "TIME:18:43:15");

    doTest("T9",
        "Location: 4075 CALL Cross Streets: Type Code: CODET Sub Type: INVEST Time: 18:42:56",
        "ADDR:4075 CALL",
        "CALL:CODET - INVEST",
        "TIME:18:42:56");

    doTest("T10",
        "Location: 2826 N RIDGE RD PE Cross Streets: LANE RD EX DRIVEWAY Type Code: BREATH Sub Type: PROBLEM Time: 16:01:57",
        "ADDR:2826 N RIDGE RD",
        "CITY:PERRY",
        "X:LANE RD EX DRIVEWAY",
        "CALL:BREATH - PROBLEM",
        "TIME:16:01:57");

    doTest("T11",
        "Location: 4780 BALDWIN RD PE Cross Streets: GREENING AV Type Code: FIRE Sub Type: RESIDE Time: 14:41:11",
        "ADDR:4780 BALDWIN RD",
        "CITY:PERRY",
        "X:GREENING AV",
        "CALL:FIRE - RESIDE",
        "TIME:14:41:11");

    doTest("T12",
        "Location: 4623 WEBB RD PE Cross Streets: WELLINGTON DR S RIDGE RD Type Code: BREATH Sub Type: PROBLEM Time: 14:23:40 Comments: F 30WKS ALONG",
        "ADDR:4623 WEBB RD",
        "CITY:PERRY",
        "X:WELLINGTON DR / S RIDGE RD",
        "CALL:BREATH - PROBLEM",
        "TIME:14:23:40",
        "INFO:F 30WKS ALONG");

    doTest("T13",
        "Cross Streets: HARDY RD LAKE RD Type Code: SPCSIT Sub Type: WRESCUE Time: 15:39:20",
        "ADDR:HARDY RD & LAKE RD",
        "CALL:SPCSIT - WRESCUE",
        "TIME:15:39:20");

    doTest("T14",
        "Location: 3667 BLACKMORE RD PE Cross Streets: N RIDGE RD NIAGRA AV Type Code: CHEST Sub Type: PAINS Time: 14:12:12 Comments: 84 YOF",
        "ADDR:3667 BLACKMORE RD",
        "CITY:PERRY",
        "X:N RIDGE RD / NIAGRA AV",
        "CALL:CHEST - PAINS",
        "TIME:14:12:12",
        "INFO:84 YOF");

    doTest("T15",
        "Location: 4734 DAVIS RD PE Cross Streets: S PINE LN CALL RD Type Code: DIABET Sub Type: DIABETIC Time: 03:43:11",
        "ADDR:4734 DAVIS RD",
        "CITY:PERRY",
        "X:S PINE LN / CALL RD",
        "CALL:DIABET - DIABETIC",
        "TIME:03:43:11");

    doTest("T16",
        "Location: 2990 MAINE AV PE Cross Streets: FLORIDA ST OREGON ST Type Code: ILLNESS Sub Type: GENERAL Time: 17:19:04",
        "ADDR:2990 MAINE AV",
        "MADDR:2990 MAINE AVE",
        "CITY:PERRY",
        "X:FLORIDA ST / OREGON ST",
        "CALL:ILLNESS - GENERAL",
        "TIME:17:19:04");

    doTest("T17",
        "Location: 2348 TOWNLINE RD NP Cross Streets: GREENBRIAR LN LOCKWOOD RD Type Code: DIABET Sub Type: DIABETIC Time: 16:42:19 Comments: LOW SUGAR MALE 62 YOA",
        "ADDR:2348 TOWNLINE RD",
        "CITY:NORTH PERRY",
        "X:GREENBRIAR LN / LOCKWOOD RD",
        "CALL:DIABET - DIABETIC",
        "TIME:16:42:19",
        "INFO:LOW SUGAR MALE 62 YOA");

    doTest("T18",
        "Location: 1843 CLYDE RD MA Cross Streets: DOUGLAS DR TWEED LN Type Code: FIRE Sub Type: RESIDE Time: 10:45:42",
        "ADDR:1843 CLYDE RD",
        "CITY:MADISON",
        "X:DOUGLAS DR / TWEED LN",
        "CALL:FIRE - RESIDE",
        "TIME:10:45:42");

    doTest("T19",
        "Location: 4228 MIDDLE RIDGE RD PE Cross Streets: SUCCESS BL LAUREL DR Type Code: LOCKIN Sub Type: VEHICLE Time: 12:56:16",
        "ADDR:4228 MIDDLE RIDGE RD",
        "CITY:PERRY",
        "X:SUCCESS BL / LAUREL DR",
        "CALL:LOCKIN - VEHICLE",
        "TIME:12:56:16");

    doTest("T20",
        "Location: 3122 N RIDGE RD PE Cross Streets: BLACKMORE RD OHIO ST Type Code: FALL Sub Type: INJURY Time: 09:00:57",
        "ADDR:3122 N RIDGE RD",
        "CITY:PERRY",
        "X:BLACKMORE RD / OHIO ST",
        "CALL:FALL - INJURY",
        "TIME:09:00:57");

    doTest("T21",
        "Location: 4699 MIDDLE RIDGE RD PE Cross Streets: CALL RD AZALEA RIDGE DR Type Code: WIRES Sub Type: DOWN Time: 07:40:21",
        "ADDR:4699 MIDDLE RIDGE RD",
        "CITY:PERRY",
        "X:CALL RD / AZALEA RIDGE DR",
        "CALL:WIRES - DOWN",
        "TIME:07:40:21");

    doTest("T22",
        "Location: 3235 ELIZABETH DR PE APT: J40 Cross Streets: CALL RD Type Code: CODET Sub Type: INVEST Time: 20:39:21",
        "ADDR:3235 ELIZABETH DR",
        "APT:J40",
        "CITY:PERRY",
        "X:CALL RD",
        "CALL:CODET - INVEST",
        "TIME:20:39:21");

    doTest("T23",
        "Location: 3059 N RIDGE RD PE Cross Streets: BLACKMORE RD OHIO ST Type Code: ACCIDENT Sub Type: INJACC Time: 18:20:38",
        "ADDR:3059 N RIDGE RD",
        "CITY:PERRY",
        "X:BLACKMORE RD / OHIO ST",
        "CALL:ACCIDENT - INJACC",
        "TIME:18:20:38");

    doTest("T24",
        "Location: 6412 N RIDGE RD MA Cross Streets: MORNINGSTAR DR DERUBERTIS DR Type Code: FIRE Sub Type: RESIDE Time: 10:51:08",
        "ADDR:6412 N RIDGE RD",
        "CITY:MADISON",
        "X:MORNINGSTAR DR / DERUBERTIS DR",
        "CALL:FIRE - RESIDE",
        "TIME:10:51:08");

    doTest("T25",
        "Location: 7925 PROCTOR RD LE Cross Streets: RADCLIFFE RD PAINESVILLE WARREN RD Type Code: FIRE Sub Type: RESIDE Time: 22:31:15",
        "ADDR:7925 PROCTOR RD",
        "CITY:LEROY TWP",
        "X:RADCLIFFE RD / PAINESVILLE WARREN RD",
        "CALL:FIRE - RESIDE",
        "TIME:22:31:15");

    doTest("T26",
        "Location: 3753 MAIN ST PV Cross Streets: NARROWS RD CENTER RD Type Code: FIRE Sub Type: ALARM Time: 14:31:53",
        "ADDR:3753 MAIN ST",
        "CITY:PERRY",
        "X:NARROWS RD / CENTER RD",
        "CALL:FIRE - ALARM",
        "TIME:14:31:53");

    doTest("T27",
        "Location: 3610 MAIN ST PV Cross Streets: NARROWS RD CENTER RD Type Code: ACCIDENT Sub Type: INJACC Time: 13:26:53",
        "ADDR:3610 MAIN ST",
        "CITY:PERRY",
        "X:NARROWS RD / CENTER RD",
        "CALL:ACCIDENT - INJACC",
        "TIME:13:26:53");

    doTest("T28",
        "Location: 5585 N RIDGE RD MA Cross Streets: MCMACKIN RD HAINES RD Type Code: FIRE Sub Type: RESIDE Time: 06:44:08",
        "ADDR:5585 N RIDGE RD",
        "CITY:MADISON",
        "X:MCMACKIN RD / HAINES RD",
        "CALL:FIRE - RESIDE",
        "TIME:06:44:08");

    doTest("T29",
        "Location: 2586 RIVERSIDE DR PE Cross Streets: CANYON RIDGE DR MADISON AV Type Code: FALL Sub Type: INJURY Time: 01:23:00",
        "ADDR:2586 RIVERSIDE DR",
        "CITY:PERRY",
        "X:CANYON RIDGE DR / MADISON AV",
        "CALL:FALL - INJURY",
        "TIME:01:23:00");

    doTest("T30",
        "Location: 1074 DOCK RD MA Cross Streets: ANGELA LN NORTON DR Type Code: FIRE Sub Type: RESIDE Time: 05:59:43",
        "ADDR:1074 DOCK RD",
        "CITY:MADISON",
        "X:ANGELA LN / NORTON DR",
        "CALL:FIRE - RESIDE",
        "TIME:05:59:43");

    doTest("T31",
        "Cross Streets: N RIDGE RD TOWNLINE RD Type Code: ACCIDENT Sub Type: INJACC Time: 05:54:43",
        "ADDR:N RIDGE RD & TOWNLINE RD",
        "CALL:ACCIDENT - INJACC",
        "TIME:05:54:43");

    doTest("T32",
        "Location: 3235 ELIZABETH DR PE Cross Streets: CALL RD Type Code: CODET Sub Type: INVEST Time: 05:00:48",
        "ADDR:3235 ELIZABETH DR",
        "CITY:PERRY",
        "X:CALL RD",
        "CALL:CODET - INVEST",
        "TIME:05:00:48");

  }
  
  public static void main(String[] args) {
    new OHLakeCountyParserTest().generateTests("T1");
  }
}