package net.anei.cadpage.parsers.ZCAAB;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Canmore, AB, Canada
Contact: Active911
Agency name: Canmore Fire-Rescue
Location: Canmore, Alberta, Canada
Sender: LuchiaM@fresc.ca

(Rip & Run) 11:34PM CALL 52b04 AT 180 kananaskis way, montane village, canmore \r\n
(Rip & Run) 07:55PM CALL 31d01 AT 7 ave & 7 st, canmore union hall canmore, canmore \r\n
(Rip & Run) 10:15AM CALL 52b01 AT 908 lawrence_grassi rdge, canmore \r\n
(Rip & Run) 01:30PM CALL 65b01 AT ,  \r\n
(Rip & Run) 12:20PM CALL 06d02 AT 1 march cl, canmore \r\n
(Rip & Run) 10:31AM CALL 31d03 AT 105 china cl, canmore \r\n
(Rip & Run) 08:43AM CALL 52c03 AT 1200 railway ave, safeway, canmore \r\n
(Rip & Run) 05:45AM CALL 65b02 AT 816 13 st, canmore \r\n
(Rip & Run) 02:54PM CALL 65b01 AT 234 benchlands terr, canmore \r\n
(Rip & Run) 08:10AM CALL 29d02 AT 105 harvie_heights rd, u:6 c:90, canmore \r\n
(Rip & Run) 02:19AM CALL 31d01 AT 248 three_sisters dr, canmore \r\n
(Rip & Run) 05:24PM CALL 52b04 AT 606 7 ave, round house daycare, canmore \r\n
(Rip & Run) 01:30AM CALL 10d04 AT benchlands tr & 1 hwy, canmore \r\n
(Rip & Run) 01:11PM CALL 65a04 AT 633 3 st, canmore \r\n
(Rip & Run) 11:36PM CALL 12d02 AT 125 kananaskis way, canmore \r\n
(Rip & Run) 07:52PM CALL 52c01 AT 107 montane rd, lodge at canmore, canmore \r\n
(Rip & Run) 06:29PM CALL 69d07 AT 4-1061 evergreen cir, canmore \r\n
(Rip & Run) 06:56PM CALL 52b04 AT 707 railway ave, canbow motors, canmore \r\n
(Rip & Run) 11:39AM CALL 06d01 AT 920 13 st, canmore \r\n
(Rip & Run) 03:52PM CALL 09e01 AT 901 bridge rd, canmore \r\n
(Rip & Run) 02:58AM CALL 65a01 AT 60-920 11 st, bow river seniors lodge, canmore \r\n
(Rip & Run) 11:44PM CALL 29b04 AT , hwy 1 ext 83 eb lane,  \r\n
(Rip & Run) 10:02PM CALL 29b04 AT , hwy 1 near banff gate,  \r\n
(Rip & Run) 03:02PM CALL 17d03 AT 206-1160 railway ave, canmore \r\n
(Rip & Run) 12:08PM CALL 06d01 AT 31-920 13 st, canmore \r\n
(Rip & Run) 11:44PM CALL 55b02 AT 285 three_sisters dr, canmore \r\n
(Rip & Run) 11:19AM CALL 52c04 AT 300 palliser lane, blakiston condos,  \r\n
(Rip & Run) 10:39AM CALL 09e01 AT 1005 9 ave, canmore \r\n
(Rip & Run) 01:51PM CALL 60d03 AT 950 railway ave, sobeys parking lot, canmore \r\n
(Rip & Run) 07:15AM CALL 52c01 AT 505 spring creek drive, glacier rock lodge, canmore \r\n
(Rip & Run) 03:50AM CALL 17d03 AT 105 china cl, canmore \r\n
(Rip & Run) 01:12AM CALL 17d02 AT 130 15 st, canmore \r\n
(Rip & Run) 08:39PM CALL 69d05 AT 6 aspen glen, canmore \r\n
(Rip & Run) 06:04PM CALL 06d02 AT 1050 cougar_creek dr, canmore \r\n
(Rip & Run) 07:45AM CALL 31c01 AT 3-920 13 st, canmore \r\n
(Rip & Run) 04:09PM CALL 60d03 AT 187 kananaskis way, solar resort & spa, canmore \r\n
(Rip & Run) 04:02PM CALL 60d03 AT 187 kananaskis way, canmore \r\n
(Rip & Run) 08:03AM CALL 52b01 AT 1267 7 ave, canmore \r\n
(Rip & Run) 05:31PM CALL 31d02 AT a-100 rummel pl, canmore \r\n

Contact: Active911
Agency name: Black Diamond Fire Department
Location: Black Diamond, Alberta, Canada
Sender: LuchiaM@fresc.ca

(Rip & Run) 08:44AM CALL 10d04 AT 5-701 government rd s, glen mead 1, black diamond 
(Rip & Run) 07:57PM CALL 52b01 AT 1300 okalta rd sw, turner valley 
(Rip & Run) 01:17PM CALL 65a02 AT 717 government rd s, black diamond 
(Rip & Run) 06:55PM CALL 65a01 AT 115 centre ave w, black diamond 
(Rip & Run) 10:13AM CALL 65a01 AT 717 government rd s, black diamond 
(Rip & Run) 08:44AM CALL 10d04 AT 5-701 government rd s, glen mead 1, black diamond
(Rip & Run) 08:44AM CALL 10d04 AT 5-701 government rd s, glen mead 1, black diamond
(Rip & Run) 07:57PM CALL 52b01 AT 1300 okalta rd sw, turner valley
(Rip & Run) 09:48AM CALL 71d01 AT 509 sunrise hill sw, turner valley \r\n
(Rip & Run) 10:16AM CALL 10c04 AT 210 1 ave sw, black diamond \r\n
(Rip & Run) 10:27AM CALL 29b01 AT * 176022 22 hwy, u:11 c:90, foothills md \r\n
(Rip & Run) 08:06PM CALL 55b01 AT 339 willow ridge manor, black diamond \r\n
(Rip & Run) 04:51PM CALL 52c03 AT 102-450 1 ave ne, fibre renew international, black diamond \r\n
(Rip & Run) 05:14PM CALL 67b01 AT 80 st w & 7 hwy w, foothills md \r\n
(Rip & Run) 08:47PM CALL 65b01 AT 717 government rd s, black diamond \r\n
(Rip & Run) 07:55PM CALL 13d01 AT 271 willow_ridge_mnr sw, black diamond \r\n
(Rip & Run) 08:44AM CALL 10d04 AT 5-701 government rd s, glen mead 1, black diamond \r\n
(Rip & Run) 07:57PM CALL 52b01 AT 1300 okalta rd sw, turner valley \r\n
(Rip & Run) 01:17PM CALL 65a02 AT 717 government rd s, black diamond \r\n
(Rip & Run) 06:55PM CALL 65a01 AT 115 centre ave w, black diamond \r\n
(Rip & Run) 10:13AM CALL 65a01 AT 717 government rd s, black diamond \r\n

Contact: Active911
Agency name: Foothills Fire Dept  Longview Station
Location: Longview, Alberta, Canada
Sender: LuchiaM@fresc.ca

(Rip & Run) 09:14PM CALL 12d02 AT 0 sw_13_17_4_w5, house 77, eden valley ir 216 
(Rip & Run) 04:26PM CALL 65a04 AT 216 royalties cr, lift assist, longview 
(Rip & Run) 11:20PM CALL 67b01 AT , house 87, eden valley 
(Rip & Run) 09:51PM CALL 65b02 AT 13-10 17_4_w5, house 13, eden valley ir 216 
(Rip & Run) 10:09PM CALL 65b02 AT , house 66, eden valley reserve 
(Rip & Run) 04:14AM CALL 27d03 AT 0 ne_11_17_4_w5, house 62, eden valley ir 216 
(Rip & Run) 09:43PM CALL 65a04 AT 123 kee dr, bumpys pit stop, longview 
(Rip & Run) 09:37PM CALL 21d01 AT , house 72 eden valley, eden valley reserve 
(Rip & Run) 07:23PM CALL 69d01 AT 22 hwy & 176 st w, foothills md 
(Rip & Run) 10:08PM CALL 65b02 AT 541 hwy & 40 hwy, kananaskis id 
(Rip & Run) 11:42PM CALL 10d04 AT 0 house_3, eden valley reserve 
(Rip & Run) 10:03AM CALL 52c01 AT , chief jacob bearspaw school, eden valley 
(Rip & Run) 03:02PM CALL 21d02 AT #se_14_17_4_w5, eden valley arena, eden valley ir 216 
(Rip & Run) 10:51AM CALL 26c02 AT lat 50.433560 lon -114.440860, hse 109, foothills md 
(Rip & Run) 12:49PM CALL 65b02 AT 32015 562 ave w, foothills md 
(Rip & Run) 02:32PM CALL 69d01 AT house 8,  
(Rip & Run) 08:58PM CALL 65b02 AT , hse 52, eden valley reserve 
(Rip & Run) 05:43PM CALL 29d01 AT 530 ave w & 144 st w, foothills md 
(Rip & Run) 05:32PM CALL 29d02 AT 0 sw_4_17_4_w5, pt is at public works, eden valley ir 216 
(Rip & Run) 05:18PM CALL 12a01 AT 0 house_72, eden valley reserve 
(Rip & Run) 04:36PM CALL 29d02 AT 0 sw_4_17_4_w5, pt is at public works, eden valley ir 216 
(Rip & Run) 04:09AM CALL 23c02 AT 0 ne_14_17_4_w5, house 112, eden valley ir 216 

(Rip & Run) 03:46PM CALL 26a11 AT 0 ne_14_17_4_w5, house 113, eden valley ir 216 
(Rip & Run) 02:33PM CALL 26d01 AT 0 se_14_17_4_w5, eden valley ir 216 
(Rip & Run) 11:48AM CALL 23b01 AT 0 se_14_17_4_w5, wellness centre, eden valley ir 216 
(Rip & Run) 12:43PM CALL 52c03 AT 102 morrison rd, p&v systems address 101 morrison rd, longview 
(Rip & Run) 11:24PM CALL 23d01 AT 0 house_35, eden valley 
(Rip & Run) 06:56PM CALL 10d02 AT , house 42, eden valley reserve 
(Rip & Run) 11:19PM CALL 65a04 AT 602 riverview pl, longview 
(Rip & Run) 10:21AM CALL 09e01 AT 0 se_24_17_4_w5, house 87, eden valley ir 216 
(Rip & Run) 11:33PM CALL 04b03 AT , house 57,  

*/
public class ZCAABCanmoreParserTest extends BaseParserTest {
  
  public ZCAABCanmoreParserTest() {
    setParser(new ZCAABCanmoreParser(), "CANMORE", "AB");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Rip & Run) 11:34PM CALL 52b04 AT 180 kananaskis way, montane village, canmore \r\n",
        "TIME:23:34:00",
        "CALL:52b04",
        "ADDR:180 kananaskis way",
        "PLACE:montane village",
        "CITY:canmore");

    doTest("T2",
        "(Rip & Run) 07:55PM CALL 31d01 AT 7 ave & 7 st, canmore union hall canmore, canmore \r\n",
        "TIME:19:55:00",
        "CALL:31d01",
        "ADDR:7 ave & 7 st",
        "PLACE:canmore union hall canmore",
        "CITY:canmore");

    doTest("T3",
        "(Rip & Run) 10:15AM CALL 52b01 AT 908 lawrence_grassi rdge, canmore \r\n",
        "TIME:10:15:00",
        "CALL:52b01",
        "ADDR:908 lawrence grassi rdge",
        "CITY:canmore");

    doTest("T4",
        "(Rip & Run) 01:30PM CALL 65b01 AT ,  \r\n",
        "TIME:13:30:00",
        "CALL:65b01");

    doTest("T5",
        "(Rip & Run) 12:20PM CALL 06d02 AT 1 march cl, canmore \r\n",
        "TIME:12:20:00",
        "CALL:06d02",
        "ADDR:1 march cl",
        "CITY:canmore");

    doTest("T6",
        "(Rip & Run) 10:31AM CALL 31d03 AT 105 china cl, canmore \r\n",
        "TIME:10:31:00",
        "CALL:31d03",
        "ADDR:105 china cl",
        "CITY:canmore");

    doTest("T7",
        "(Rip & Run) 08:43AM CALL 52c03 AT 1200 railway ave, safeway, canmore \r\n",
        "TIME:08:43:00",
        "CALL:52c03",
        "ADDR:1200 railway ave",
        "PLACE:safeway",
        "CITY:canmore");

    doTest("T8",
        "(Rip & Run) 05:45AM CALL 65b02 AT 816 13 st, canmore \r\n",
        "TIME:05:45:00",
        "CALL:65b02",
        "ADDR:816 13 st",
        "CITY:canmore");

    doTest("T9",
        "(Rip & Run) 02:54PM CALL 65b01 AT 234 benchlands terr, canmore \r\n",
        "TIME:14:54:00",
        "CALL:65b01",
        "ADDR:234 benchlands terr",
        "CITY:canmore");

    doTest("T10",
        "(Rip & Run) 08:10AM CALL 29d02 AT 105 harvie_heights rd, u:6 c:90, canmore \r\n",
        "TIME:08:10:00",
        "CALL:29d02",
        "ADDR:105 harvie heights rd",
        "PLACE:u:6 c:90",
        "CITY:canmore");

    doTest("T11",
        "(Rip & Run) 02:19AM CALL 31d01 AT 248 three_sisters dr, canmore \r\n",
        "TIME:02:19:00",
        "CALL:31d01",
        "ADDR:248 three sisters dr",
        "CITY:canmore");

    doTest("T12",
        "(Rip & Run) 05:24PM CALL 52b04 AT 606 7 ave, round house daycare, canmore \r\n",
        "TIME:17:24:00",
        "CALL:52b04",
        "ADDR:606 7 ave",
        "PLACE:round house daycare",
        "CITY:canmore");

    doTest("T13",
        "(Rip & Run) 01:30AM CALL 10d04 AT benchlands tr & 1 hwy, canmore \r\n",
        "TIME:01:30:00",
        "CALL:10d04",
        "ADDR:benchlands tr & 1 hwy",
        "MADDR:benchlands tr & hwy 1",
        "CITY:canmore");

    doTest("T14",
        "(Rip & Run) 01:11PM CALL 65a04 AT 633 3 st, canmore \r\n",
        "TIME:13:11:00",
        "CALL:65a04",
        "ADDR:633 3 st",
        "CITY:canmore");

    doTest("T15",
        "(Rip & Run) 11:36PM CALL 12d02 AT 125 kananaskis way, canmore \r\n",
        "TIME:23:36:00",
        "CALL:12d02",
        "ADDR:125 kananaskis way",
        "CITY:canmore");

    doTest("T16",
        "(Rip & Run) 07:52PM CALL 52c01 AT 107 montane rd, lodge at canmore, canmore \r\n",
        "TIME:19:52:00",
        "CALL:52c01",
        "ADDR:107 montane rd",
        "PLACE:lodge at canmore",
        "CITY:canmore");

    doTest("T17",
        "(Rip & Run) 06:29PM CALL 69d07 AT 4-1061 evergreen cir, canmore \r\n",
        "TIME:18:29:00",
        "CALL:69d07",
        "ADDR:4-1061 evergreen cir",
        "MADDR:1061 evergreen cir",
        "CITY:canmore");

    doTest("T18",
        "(Rip & Run) 06:56PM CALL 52b04 AT 707 railway ave, canbow motors, canmore \r\n",
        "TIME:18:56:00",
        "CALL:52b04",
        "ADDR:707 railway ave",
        "PLACE:canbow motors",
        "CITY:canmore");

    doTest("T19",
        "(Rip & Run) 11:39AM CALL 06d01 AT 920 13 st, canmore \r\n",
        "TIME:11:39:00",
        "CALL:06d01",
        "ADDR:920 13 st",
        "CITY:canmore");

    doTest("T20",
        "(Rip & Run) 03:52PM CALL 09e01 AT 901 bridge rd, canmore \r\n",
        "TIME:15:52:00",
        "CALL:09e01",
        "ADDR:901 bridge rd",
        "CITY:canmore");

    doTest("T21",
        "(Rip & Run) 02:58AM CALL 65a01 AT 60-920 11 st, bow river seniors lodge, canmore \r\n",
        "TIME:02:58:00",
        "CALL:65a01",
        "ADDR:60-920 11 st",
        "MADDR:920 11 st",
        "PLACE:bow river seniors lodge",
        "CITY:canmore");

    doTest("T22",
        "(Rip & Run) 11:44PM CALL 29b04 AT , hwy 1 ext 83 eb lane,  \r\n",
        "TIME:23:44:00",
        "CALL:29b04",
        "ADDR:hwy 1 ext 83 eb lane",
        "MADDR:hwy 1 83 lane");

    doTest("T23",
        "(Rip & Run) 10:02PM CALL 29b04 AT , hwy 1 near banff gate,  \r\n",
        "TIME:22:02:00",
        "CALL:29b04",
        "ADDR:hwy 1 near banff gate",
        "MADDR:hwy 1 & banff gate");

    doTest("T24",
        "(Rip & Run) 03:02PM CALL 17d03 AT 206-1160 railway ave, canmore \r\n",
        "TIME:15:02:00",
        "CALL:17d03",
        "ADDR:206-1160 railway ave",
        "MADDR:1160 railway ave",
        "CITY:canmore");

    doTest("T25",
        "(Rip & Run) 12:08PM CALL 06d01 AT 31-920 13 st, canmore \r\n",
        "TIME:12:08:00",
        "CALL:06d01",
        "ADDR:31-920 13 st",
        "MADDR:920 13 st",
        "CITY:canmore");

    doTest("T26",
        "(Rip & Run) 11:44PM CALL 55b02 AT 285 three_sisters dr, canmore \r\n",
        "TIME:23:44:00",
        "CALL:55b02",
        "ADDR:285 three sisters dr",
        "CITY:canmore");

    doTest("T27",
        "(Rip & Run) 11:19AM CALL 52c04 AT 300 palliser lane, blakiston condos,  \r\n",
        "TIME:11:19:00",
        "CALL:52c04",
        "ADDR:300 palliser lane", // Palliser Trail?
        "PLACE:blakiston condos");

    doTest("T28",
        "(Rip & Run) 10:39AM CALL 09e01 AT 1005 9 ave, canmore \r\n",
        "TIME:10:39:00",
        "CALL:09e01",
        "ADDR:1005 9 ave",
        "CITY:canmore");

    doTest("T29",
        "(Rip & Run) 01:51PM CALL 60d03 AT 950 railway ave, sobeys parking lot, canmore \r\n",
        "TIME:13:51:00",
        "CALL:60d03",
        "ADDR:950 railway ave",
        "PLACE:sobeys parking lot",
        "CITY:canmore");

    doTest("T30",
        "(Rip & Run) 07:15AM CALL 52c01 AT 505 spring creek drive, glacier rock lodge, canmore \r\n",
        "TIME:07:15:00",
        "CALL:52c01",
        "ADDR:505 spring creek drive",
        "PLACE:glacier rock lodge",
        "CITY:canmore");

    doTest("T31",
        "(Rip & Run) 03:50AM CALL 17d03 AT 105 china cl, canmore \r\n",
        "TIME:03:50:00",
        "CALL:17d03",
        "ADDR:105 china cl",
        "CITY:canmore");

    doTest("T32",
        "(Rip & Run) 01:12AM CALL 17d02 AT 130 15 st, canmore \r\n",
        "TIME:01:12:00",
        "CALL:17d02",
        "ADDR:130 15 st",
        "CITY:canmore");

    doTest("T33",
        "(Rip & Run) 08:39PM CALL 69d05 AT 6 aspen glen, canmore \r\n",
        "TIME:20:39:00",
        "CALL:69d05",
        "ADDR:6 aspen glen",
        "CITY:canmore");

    doTest("T34",
        "(Rip & Run) 06:04PM CALL 06d02 AT 1050 cougar_creek dr, canmore \r\n",
        "TIME:18:04:00",
        "CALL:06d02",
        "ADDR:1050 cougar creek dr",
        "CITY:canmore");

    doTest("T35",
        "(Rip & Run) 07:45AM CALL 31c01 AT 3-920 13 st, canmore \r\n",
        "TIME:07:45:00",
        "CALL:31c01",
        "ADDR:3-920 13 st",
        "MADDR:920 13 st",
        "CITY:canmore");

    doTest("T36",
        "(Rip & Run) 04:09PM CALL 60d03 AT 187 kananaskis way, solar resort & spa, canmore \r\n",
        "TIME:16:09:00",
        "CALL:60d03",
        "ADDR:187 kananaskis way",
        "PLACE:solar resort & spa",
        "CITY:canmore");

    doTest("T37",
        "(Rip & Run) 04:02PM CALL 60d03 AT 187 kananaskis way, canmore \r\n",
        "TIME:16:02:00",
        "CALL:60d03",
        "ADDR:187 kananaskis way",
        "CITY:canmore");

    doTest("T38",
        "(Rip & Run) 08:03AM CALL 52b01 AT 1267 7 ave, canmore \r\n",
        "TIME:08:03:00",
        "CALL:52b01",
        "ADDR:1267 7 ave",
        "CITY:canmore");

    doTest("T39",
        "(Rip & Run) 05:31PM CALL 31d02 AT a-100 rummel pl, canmore \r\n",
        "TIME:17:31:00",
        "CALL:31d02",
        "ADDR:a-100 rummel pl",
        "CITY:canmore");

  }
  
  @Test
  public void testBlackDiamondFire() {

    doTest("T1",
        "(Rip & Run) 08:44AM CALL 10d04 AT 5-701 government rd s, glen mead 1, black diamond ",
        "TIME:08:44:00",
        "CALL:10d04",
        "ADDR:5-701 government rd s",
        "MADDR:701 government rd s",
        "PLACE:glen mead 1",
        "CITY:black diamond");

    doTest("T2",
        "(Rip & Run) 07:57PM CALL 52b01 AT 1300 okalta rd sw, turner valley ",
        "TIME:19:57:00",
        "CALL:52b01",
        "ADDR:1300 okalta rd sw",
        "CITY:turner valley");

    doTest("T3",
        "(Rip & Run) 01:17PM CALL 65a02 AT 717 government rd s, black diamond ",
        "TIME:13:17:00",
        "CALL:65a02",
        "ADDR:717 government rd s",
        "CITY:black diamond");

    doTest("T4",
        "(Rip & Run) 06:55PM CALL 65a01 AT 115 centre ave w, black diamond ",
        "TIME:18:55:00",
        "CALL:65a01",
        "ADDR:115 centre ave w",
        "CITY:black diamond");

    doTest("T5",
        "(Rip & Run) 10:13AM CALL 65a01 AT 717 government rd s, black diamond ",
        "TIME:10:13:00",
        "CALL:65a01",
        "ADDR:717 government rd s",
        "CITY:black diamond");

    doTest("T6",
        "(Rip & Run) 08:44AM CALL 10d04 AT 5-701 government rd s, glen mead 1, black diamond",
        "TIME:08:44:00",
        "CALL:10d04",
        "ADDR:5-701 government rd s",
        "MADDR:701 government rd s",
        "PLACE:glen mead 1",
        "CITY:black diamond");

    doTest("T7",
        "(Rip & Run) 08:44AM CALL 10d04 AT 5-701 government rd s, glen mead 1, black diamond",
        "TIME:08:44:00",
        "CALL:10d04",
        "ADDR:5-701 government rd s",
        "MADDR:701 government rd s",
        "PLACE:glen mead 1",
        "CITY:black diamond");

    doTest("T8",
        "(Rip & Run) 07:57PM CALL 52b01 AT 1300 okalta rd sw, turner valley",
        "TIME:19:57:00",
        "CALL:52b01",
        "ADDR:1300 okalta rd sw",
        "CITY:turner valley");

    doTest("T9",
        "(Rip & Run) 09:48AM CALL 71d01 AT 509 sunrise hill sw, turner valley \r\n",
        "TIME:09:48:00",
        "CALL:71d01",
        "ADDR:509 sunrise hill sw",
        "CITY:turner valley");

    doTest("T10",
        "(Rip & Run) 10:16AM CALL 10c04 AT 210 1 ave sw, black diamond \r\n",
        "TIME:10:16:00",
        "CALL:10c04",
        "ADDR:210 1 ave sw",
        "CITY:black diamond");

    doTest("T11",
        "(Rip & Run) 10:27AM CALL 29b01 AT * 176022 22 hwy, u:11 c:90, foothills md \r\n",
        "TIME:10:27:00",
        "CALL:29b01",
        "ADDR:176022 22 hwy",
        "MADDR:176022 hwy 22",
        "PLACE:u:11 c:90",
        "CITY:foothills md");

    doTest("T12",
        "(Rip & Run) 08:06PM CALL 55b01 AT 339 willow ridge manor, black diamond \r\n",
        "TIME:20:06:00",
        "CALL:55b01",
        "ADDR:339 willow ridge manor",
        "CITY:black diamond");

    doTest("T13",
        "(Rip & Run) 04:51PM CALL 52c03 AT 102-450 1 ave ne, fibre renew international, black diamond \r\n",
        "TIME:16:51:00",
        "CALL:52c03",
        "ADDR:102-450 1 ave ne",
        "MADDR:450 1 ave ne",
        "PLACE:fibre renew international",
        "CITY:black diamond");

    doTest("T14",
        "(Rip & Run) 05:14PM CALL 67b01 AT 80 st w & 7 hwy w, foothills md \r\n",
        "TIME:17:14:00",
        "CALL:67b01",
        "ADDR:80 st w & 7 hwy w",
        "CITY:foothills md");

    doTest("T15",
        "(Rip & Run) 08:47PM CALL 65b01 AT 717 government rd s, black diamond \r\n",
        "TIME:20:47:00",
        "CALL:65b01",
        "ADDR:717 government rd s",
        "CITY:black diamond");

    doTest("T16",
        "(Rip & Run) 07:55PM CALL 13d01 AT 271 willow_ridge_mnr sw, black diamond \r\n",
        "TIME:19:55:00",
        "CALL:13d01",
        "ADDR:271 willow ridge mnr sw",
        "CITY:black diamond");

    doTest("T17",
        "(Rip & Run) 08:44AM CALL 10d04 AT 5-701 government rd s, glen mead 1, black diamond \r\n",
        "TIME:08:44:00",
        "CALL:10d04",
        "ADDR:5-701 government rd s",
        "MADDR:701 government rd s",
        "PLACE:glen mead 1",
        "CITY:black diamond");

    doTest("T18",
        "(Rip & Run) 07:57PM CALL 52b01 AT 1300 okalta rd sw, turner valley \r\n",
        "TIME:19:57:00",
        "CALL:52b01",
        "ADDR:1300 okalta rd sw",
        "CITY:turner valley");

    doTest("T19",
        "(Rip & Run) 01:17PM CALL 65a02 AT 717 government rd s, black diamond \r\n",
        "TIME:13:17:00",
        "CALL:65a02",
        "ADDR:717 government rd s",
        "CITY:black diamond");

    doTest("T20",
        "(Rip & Run) 06:55PM CALL 65a01 AT 115 centre ave w, black diamond \r\n",
        "TIME:18:55:00",
        "CALL:65a01",
        "ADDR:115 centre ave w",
        "CITY:black diamond");

    doTest("T21",
        "(Rip & Run) 10:13AM CALL 65a01 AT 717 government rd s, black diamond \r\n",
        "TIME:10:13:00",
        "CALL:65a01",
        "ADDR:717 government rd s",
        "CITY:black diamond");

  }
  
  @Test
  public void testFoothillsFire() {

    doTest("T1",
        "(Rip & Run) 09:14PM CALL 12d02 AT 0 sw_13_17_4_w5, house 77, eden valley ir 216 ",
        "TIME:21:14:00",
        "CALL:12d02",
        "ADDR:sw 13 17 4 w5",
        "PLACE:house 77",
        "CITY:eden valley ir 216");

    doTest("T2",
        "(Rip & Run) 04:26PM CALL 65a04 AT 216 royalties cr, lift assist, longview ",
        "TIME:16:26:00",
        "CALL:65a04",
        "ADDR:216 royalties cr",
        "MADDR:216 royalties cir",
        "PLACE:lift assist",
        "CITY:longview");

    doTest("T3",
        "(Rip & Run) 11:20PM CALL 67b01 AT , house 87, eden valley ",
        "TIME:23:20:00",
        "CALL:67b01",
        "ADDR:house 87",
        "CITY:eden valley");

    doTest("T4",
        "(Rip & Run) 09:51PM CALL 65b02 AT 13-10 17_4_w5, house 13, eden valley ir 216 ",
        "TIME:21:51:00",
        "CALL:65b02",
        "ADDR:13-10 17 4 w5",
        "MADDR:13 17 4 w5",
        "PLACE:house 13",
        "CITY:eden valley ir 216");

    doTest("T5",
        "(Rip & Run) 10:09PM CALL 65b02 AT , house 66, eden valley reserve ",
        "TIME:22:09:00",
        "CALL:65b02",
        "ADDR:house 66",
        "CITY:eden valley reserve");

    doTest("T6",
        "(Rip & Run) 04:14AM CALL 27d03 AT 0 ne_11_17_4_w5, house 62, eden valley ir 216 ",
        "TIME:04:14:00",
        "CALL:27d03",
        "ADDR:ne 11 17 4 w5",
        "PLACE:house 62",
        "CITY:eden valley ir 216");

    doTest("T7",
        "(Rip & Run) 09:43PM CALL 65a04 AT 123 kee dr, bumpys pit stop, longview ",
        "TIME:21:43:00",
        "CALL:65a04",
        "ADDR:123 kee dr",
        "PLACE:bumpys pit stop",
        "CITY:longview");

    doTest("T8",
        "(Rip & Run) 09:37PM CALL 21d01 AT , house 72 eden valley, eden valley reserve ",
        "TIME:21:37:00",
        "CALL:21d01",
        "ADDR:house 72 eden valley",
        "CITY:eden valley reserve");

    doTest("T9",
        "(Rip & Run) 07:23PM CALL 69d01 AT 22 hwy & 176 st w, foothills md ",
        "TIME:19:23:00",
        "CALL:69d01",
        "ADDR:22 hwy & 176 st w",
        "MADDR:hwy 22 & 176 st w",
        "CITY:foothills md");

    doTest("T10",
        "(Rip & Run) 10:08PM CALL 65b02 AT 541 hwy & 40 hwy, kananaskis id ",
        "TIME:22:08:00",
        "CALL:65b02",
        "ADDR:541 hwy & 40 hwy",
        "MADDR:hwy 541 & hwy 40",
        "CITY:kananaskis id");

    doTest("T11",
        "(Rip & Run) 11:42PM CALL 10d04 AT 0 house_3, eden valley reserve ",
        "TIME:23:42:00",
        "CALL:10d04",
        "ADDR:house 3",
        "CITY:eden valley reserve");

    doTest("T12",
        "(Rip & Run) 10:03AM CALL 52c01 AT , chief jacob bearspaw school, eden valley ",
        "TIME:10:03:00",
        "CALL:52c01",
        "ADDR:chief jacob bearspaw school",
        "CITY:eden valley");

    doTest("T13",
        "(Rip & Run) 03:02PM CALL 21d02 AT #se_14_17_4_w5, eden valley arena, eden valley ir 216 ",
        "TIME:15:02:00",
        "CALL:21d02",
        "APT:se 14 17 4 w5",
        "PLACE:eden valley arena",
        "CITY:eden valley ir 216");

    doTest("T14",
        "(Rip & Run) 10:51AM CALL 26c02 AT lat 50.433560 lon -114.440860, hse 109, foothills md ",
        "TIME:10:51:00",
        "CALL:26c02",
        "ADDR:lat 50.433560 lon -114.440860",
        "PLACE:hse 109",
        "CITY:foothills md");

    doTest("T15",
        "(Rip & Run) 12:49PM CALL 65b02 AT 32015 562 ave w, foothills md ",
        "TIME:12:49:00",
        "CALL:65b02",
        "ADDR:32015 562 ave w",
        "CITY:foothills md");

    doTest("T16",
        "(Rip & Run) 02:32PM CALL 69d01 AT house 8,  ",
        "TIME:14:32:00",
        "CALL:69d01",
        "ADDR:house 8");

    doTest("T17",
        "(Rip & Run) 08:58PM CALL 65b02 AT , hse 52, eden valley reserve ",
        "TIME:20:58:00",
        "CALL:65b02",
        "ADDR:hse 52",
        "CITY:eden valley reserve");

    doTest("T18",
        "(Rip & Run) 05:43PM CALL 29d01 AT 530 ave w & 144 st w, foothills md ",
        "TIME:17:43:00",
        "CALL:29d01",
        "ADDR:530 ave w & 144 st w",
        "CITY:foothills md");

    doTest("T19",
        "(Rip & Run) 05:32PM CALL 29d02 AT 0 sw_4_17_4_w5, pt is at public works, eden valley ir 216 ",
        "TIME:17:32:00",
        "CALL:29d02",
        "ADDR:sw 4 17 4 w5",
        "PLACE:pt is at public works",
        "CITY:eden valley ir 216");

    doTest("T20",
        "(Rip & Run) 05:18PM CALL 12a01 AT 0 house_72, eden valley reserve ",
        "TIME:17:18:00",
        "CALL:12a01",
        "ADDR:house 72",
        "CITY:eden valley reserve");

    doTest("T21",
        "(Rip & Run) 04:36PM CALL 29d02 AT 0 sw_4_17_4_w5, pt is at public works, eden valley ir 216 ",
        "TIME:16:36:00",
        "CALL:29d02",
        "ADDR:sw 4 17 4 w5",
        "PLACE:pt is at public works",
        "CITY:eden valley ir 216");

    doTest("T22",
        "(Rip & Run) 04:09AM CALL 23c02 AT 0 ne_14_17_4_w5, house 112, eden valley ir 216 ",
        "TIME:04:09:00",
        "CALL:23c02",
        "ADDR:ne 14 17 4 w5",
        "PLACE:house 112",
        "CITY:eden valley ir 216");

    doTest("T23",
        "(Rip & Run) 03:46PM CALL 26a11 AT 0 ne_14_17_4_w5, house 113, eden valley ir 216 ",
        "TIME:15:46:00",
        "CALL:26a11",
        "ADDR:ne 14 17 4 w5",
        "PLACE:house 113",
        "CITY:eden valley ir 216");

    doTest("T24",
        "(Rip & Run) 02:33PM CALL 26d01 AT 0 se_14_17_4_w5, eden valley ir 216 ",
        "TIME:14:33:00",
        "CALL:26d01",
        "ADDR:se 14 17 4 w5",
        "CITY:eden valley ir 216");

    doTest("T25",
        "(Rip & Run) 11:48AM CALL 23b01 AT 0 se_14_17_4_w5, wellness centre, eden valley ir 216 ",
        "TIME:11:48:00",
        "CALL:23b01",
        "ADDR:se 14 17 4 w5",
        "PLACE:wellness centre",
        "CITY:eden valley ir 216");

    doTest("T26",
        "(Rip & Run) 12:43PM CALL 52c03 AT 102 morrison rd, p&v systems address 101 morrison rd, longview ",
        "TIME:12:43:00",
        "CALL:52c03",
        "ADDR:102 morrison rd",
        "PLACE:p&v systems address 101 morrison rd",
        "CITY:longview");

    doTest("T27",
        "(Rip & Run) 11:24PM CALL 23d01 AT 0 house_35, eden valley ",
        "TIME:23:24:00",
        "CALL:23d01",
        "ADDR:house 35",
        "CITY:eden valley");

    doTest("T28",
        "(Rip & Run) 06:56PM CALL 10d02 AT , house 42, eden valley reserve ",
        "TIME:18:56:00",
        "CALL:10d02",
        "ADDR:house 42",
        "CITY:eden valley reserve");

    doTest("T29",
        "(Rip & Run) 11:19PM CALL 65a04 AT 602 riverview pl, longview ",
        "TIME:23:19:00",
        "CALL:65a04",
        "ADDR:602 riverview pl",
        "CITY:longview");

    doTest("T30",
        "(Rip & Run) 10:21AM CALL 09e01 AT 0 se_24_17_4_w5, house 87, eden valley ir 216 ",
        "TIME:10:21:00",
        "CALL:09e01",
        "ADDR:se 24 17 4 w5",
        "PLACE:house 87",
        "CITY:eden valley ir 216");

    doTest("T31",
        "(Rip & Run) 11:33PM CALL 04b03 AT , house 57,  ",
        "TIME:23:33:00",
        "CALL:04b03",
        "ADDR:house 57");
   
  }
  
  public static void main(String[] args) {
    new ZCAABCanmoreParserTest().generateTests("T23");
  }
}