package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*    
Jackson County, OR

Contact: N. H. <nihebr@gmail.com>
Sender: Messaging@ecso911.com
(CAD Page) DISPATCH:GRASS, Grass Fire, NB INTERSTATE 5 @ 49, RR, at NB INTERSTATE 5 @ 49, RR <0/0>, PRI:1, Units:7368, 7410, 7441, 7451, 7461, ODFG - From CAD

Contact Active911
Agency name: Jackson County Fire District #5 Location: Phoenix, OR 
Sender: Messaging@ecso911.com
  
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:CPF, Chest Pains, 345 WILLOW SPRINGS DR, TA, PRI:1, Units:8300, 8331, 8833 - From\n(Con't) 2 of 2\nCAD07 06/24/2012 19:48:52\n(End)
FRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:STRUCF, Structure Fire, 1457 WHITMAN AVE, MF, PRI:1, Unit:8300 - From CAD13 06/25/2012 17:38:40 
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:MVCUF, MVC Unknown Injury, 1362 FOSS RD, TA, PRI:1, Units:8300, 8301, 8331, 8831 -\n(Con't) 2 of 2\nFrom CAD15 06/25/2012 18:54:05 \n(End)
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:GRASS, Grass Fire, DEER TRAIL LN/COLEMAN CREEK RD, MF, PRI:1, Units:8300, 8303,\n(Con't) 2 of 2\n8341, 8361, 8363, 8801, ODFM - From CAD15 06/25/2012 18:55:35 \n(End)
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:MVCUF, MVC Unknown Injury, 1362 FOSS RD, TA, PRI:1, Units:8300, 8301, 8331, 8831 -\n(Con't) 2 of 2\nFrom CAD15 06/25/2012 18:54:05 \n(End)
FRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:ALRMMF, Medical Alarm, 1122 N ROSE ST, PH, PRI:1, Units:8300, 8303 - From CAD15 06/25/2012 19:25:13 
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:STRUCF, Structure Fire, 180 LINCOLN ST, AS, PRI:1, Units:8300, 8301, 8801, 8802,\n(Con't) 2 of 2\n8853, 88CO - From CAD15 06/26/2012 07:47:36 \n(End)
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:UNCF, Unconscious Person, 10548 WAGNER CREEK RD, TA, PRI:1, Units:8300, 8331, 8831 -\n(Con't) 2 of 2\nFrom CAD15 06/25/2012 21:13:21 \n(End)
FRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:STRUCF, Structure Fire, 3555 S PACIFIC HWY #193, MF, PRI:1, Unit:8300 - From CAD13 06/26/2012 23:12:50 
FRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:MVCIF, MVC injury, 1188 OAK ST, AS, PRI:1, Units:8300, 8311, 8331, 8831 - From CAD15 07/01/2012 17:42:42 
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:GRASS, Grass Fire, 4332 FERN VALLEY RD, MF, PRI:2A, Units:8106, 8146, 8166, 8168,\n(Con't) 2 of 2\n8300, 8300DO, 8311 - From CAD15 07/02/2012 19:53:43 \n(End)
FRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:FALLF, Fall Victim, 300 LUMAN RD #45, PH, PRI:1, Units:8300, 8303 - From CAD15 07/01/2012 10:43:31 
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:GRASS, Grass Fire, 2050 BUTLER CREEK RD, AS, PRI:1, Units:8300, 8301, 8341, 8361,\n(Con't) 2 of 2\n8801, 8861, 88CO, ODFM - From CAD15 07/04/2012 13:49:40 \n(End)
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:SMOKE, Smoke Investigation, FOSS RD/ADAMS RD, TA, PRI:1, Units:8300, 8312 - From\n(Con't) 2 of 2\nCAD15 06/29/2012 20:51:08 \n(End)

Contact: Active911
Agency name: Applegate Valley Fire District
Location: Jacksonville, OR, United States
Sender: Messaging@ecso911.com

(CAD Page) DISPATCH:ILBURN, Illegal Burn, CANTRALL BUCKLEY PARK, JV, PRI:1, Units:8503, 8515 - From CAD15 02/12/2013 17:59:46
(CAD Page) DISPATCH:ASSTPF, Assist to Public, APPLEGATE STORE, JV, PRI:1, Unit:8536 - From CAD15 02/11/2013 19:20:56
(CAD Page) DISPATCH:STRUCF, Structure Fire, 1269 UPPER APPLEGATE RD, JV, PRI:1, Units:8501, 8503, 8515, 8539, 8541, 8543 - From CAD15 02/11/2013 15:10:11
(CAD Page) DISPATCH:ALLERF, Allergic Reaction, 7208 HIGHWAY 238, JV, PRI:1, Unit:8533 - From CAD15 02/11/2013 10:47:01
(CAD Page) DISPATCH:FALLF, 8534, 199 POWELL CREEK RD, WI, PRI:1, Units:8500, 8534 - From CAD14 02/10/2013 13:48:32
(CAD Page) DISPATCH:HEMF, Hemorrhage, 18493 N APPLEGATE RD, GP, PRI:1, Units:8531, 8536, AMR - From CAD15 02/08/2013 18:14:41
(CAD Page) DISPATCH:MVCUF, MVC Unknown Injury, WILLIAMS HWY/WATERGAP RD, GP, PRI:1, Units:8531, 8534, AMR - From CAD15 02/07/2013 19:28:52
(CAD Page) DISPATCH:STRUCF, Structure Fire, 1000 BLK SOUTHSIDE RD, GP, PRI:1, Units:8504, 8544 - From CAD14 02/07/2013 08:56:40
(CAD Page) DISPATCH:GRASS, Grass Fire, KUBLI RD/MISSOURI FLAT RD, GP, PRI:1, Units:8536, 8541, 8561, ODFG - From CAD15 02/06/2013 15:13:32
(CAD Page) DISPATCH:SICKF, General Illness, 6581 WHISPERING PINES LN, JV, PRI:1, Unit:8533 - From CAD07 02/06/2013 13:24:19
(CAD Page) DISPATCH:BPF, 8500, 1100 GLENLYN DR, WI, PRI:1, Units:8500, 8534 - From CAD09 02/05/2013 02:01:34
(CAD Page) DISPATCH:TRAUMF, Traumatic Injury, 2032 CEDAR FLAT RD, WI, PRI:1, Unit:8500 - From CAD14 02/04/2013 08:53:13

Contact: Active911
Agency name: Medford Fire-Rescue
Location: Medford, OR, United States
Sender: Messaging@ecso911.com

(CAD Page) DISPATCH:SICKF, General Illness, BEAR CREEK MOTEL #3, MF, at 2715 S PACIFIC HWY #3, MF, PRI:2, Unit:8103 - From CAD13 07/08/2013 16:05:58
(CAD Page) DISPATCH:ALARMF, Fire Alarm, 1000 TERMINAL LOOP PKWY, MF, btwn TERMINAL SPUR RD and AIRPORT RD, PRI:1, Units:7980, 8104 - From CAD13 07/08/2013 11:27:28
(CAD Page) DISPATCH:BARK, Bark Fire, COURTYARD BY MARRIOTT, MF, at 600 AIRPORT RD, MF, PRI:1, Unit:8104 - From CAD13 07/08/2013 09:03:35
(CAD Page) DISPATCH:SICKF, SEND LAW, 2520 W MAIN ST, MF, btwn CLOVER LN and DARLINGTON ST, PRI:2, Unit:8104 - From CAD13 07/08/2013 16:50:21
(CAD Page) DISPATCH:PERDNF, Person Down, CEDAR ST/W JACKSON ST, MF,  <700/ 210>, PRI:1, Unit:8102 - From CAD13 07/08/2013 16:41:03
(CAD Page) DISPATCH:ABDOMF, Abdominal Pain, 3565 S VILLAGE DR, MF, btwn SCOTTSDALE CIR and N PHOENIX RD, PRI:1, Unit:8106 - From CAD13 07/08/2013 16:18:01
(CAD Page) DISPATCH:CPF, Chest Pains, 63 NORTHRIDGE TER #23, MF, btwn S PACIFIC HWY and BEAR CREEK GREENWAY, PRI:1, Units:8153, 8303 - From CAD13 07/08/2013 16:15:03
(CAD Page) DISPATCH:BARK, Bark Fire, 1005 E MAIN ST #A, MF, btwn VANCOUVER AVE and WILLAMETTE AVE, PRI:1, Unit:8103 - From CAD13 07/08/2013 15:34:56
(CAD Page) DISPATCH:PERDNF, Person Down, 523 S CENTRAL AVE, MF, btwn E 12TH ST and E 13TH ST, PRI:1, Unit:8103 - From CAD13 07/08/2013 14:59:30
(CAD Page) DISPATCH:ALARMF, Fire Alarm, 1111 CRATER LAKE AVE, MF, btwn WOODROW LN and E MCANDREWS RD, PRI:1, Unit:8105 - From CAD13 07/08/2013 14:50:55
(CAD Page) DISPATCH:HEMF, Hemorrhage, MEDFORD POST OFFICE, MF, at 325 S RIVERSIDE AVE, MF, PRI:1, Unit:8103 - From CAD13 07/08/2013 13:57:37
(CAD Page) DISPATCH:FALLF, Fall Victim, 2061 ROBERTS RD, MF, btwn CRATER LAKE AVE and SUNBURST CT, PRI:2, Unit:8105 - From CAD13 07/08/2013 13:48:34
(CAD Page) DISPATCH:DIABF, Diabetic Problem, 2458 REPUBLIC WAY, MF, btwn CONSTITUTION DR and END, PRI:1, Unit:8103 - From CAD13 07/08/2013 13:14:08
(CAD Page) DISPATCH:FALLF, Fall Victim, 154 1/2 DE HAGUE ST, MF, btwn CONNELL AVE and WYATT DR, PRI:1, Unit:8104 - From CAD13 07/08/2013 12:48:23
(CAD Page) DISPATCH:STRUCF, Structure Fire, 1800 E BARNETT RD #STEB, MF, btwn ELLENDALE DR and HILLDALE AVE, PRI:1, Units:8102, 8103, 8106, 8153 - From CAD13 07/08/2013 12:31:17
(CAD Page) DISPATCH:SEIZF, Seizure Victim, 406 W MAIN ST, MF, btwn N IVY ST and N OAKDALE AVE, PRI:1, Unit:8102 - From CAD13 07/08/2013 11:23:37
(CAD Page) DISPATCH:BPF, Breathing Problems, 307 BLACK OAK DR, MF, btwn COUNTRY CLUB DR and DELLWOOD AVE, PRI:1, Unit:8103 - From CAD13 07/08/2013 10:53:12
(CAD Page) DISPATCH:UNCF, Unconscious Person, 822 GOLF VIEW DR, MF, btwn CREEK VIEW DR and EDGEWATER DR, PRI:1, Unit:8103 - From CAD13 07/08/2013 10:15:24
(CAD Page) DISPATCH:HEARTF, Heart Problems, 1520 POPLAR DR #2, MF, btwn PROGRESS DR and MORROW RD, PRI:1, Unit:8105 - From CAD13 07/08/2013 09:16:11
(CAD Page) DISPATCH:SEIZF, Seizure Victim, 2162 CAMP BAKER RD, MF, btwn LAUREL LN and CHARLOTTE LN, PRI:1, Unit:8102 - From CAD15 07/08/2013 08:57:57

*/

public class ORJacksonCountyParserTest extends BaseParserTest {
  
  public ORJacksonCountyParserTest() {
    setParser(new ORJacksonCountyParser(), "JACKSON COUNTY", "OR");
  }
  
  @Test
  public void testNH() {

    doTest("T1",
        "(CAD Page) DISPATCH:GRASS, Grass Fire, NB INTERSTATE 5 @ 49, RR, at NB INTERSTATE 5 @ 49, RR <0/0>, PRI:1, Units:7368, 7410, 7441, 7451, 7461, ODFG - From CAD",
        "CODE:GRASS",
        "CALL:Grass Fire",
        "PLACE:NB INTERSTATE 5 @ 49",
        "ADDR:NB INTERSTATE 5 @ 49",
        "MADDR:INTERSTATE 5 @ 49",
        "CITY:ROGUE RIVER",
        "PRI:1",
        "UNIT:7368,7410,7441,7451,7461,ODFG - From CAD",
        "SRC:CAD");

  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:CPF, Chest Pains, 345 WILLOW SPRINGS DR, TA, PRI:1, Units:8300, 8331, 8833 - From\n" +
        "(Con't) 2 of 2\n" +
        "CAD07 06/24/2012 19:48:52\n" +
        "(End)",

        "CODE:CPF",
        "CALL:Chest Pains",
        "ADDR:345 WILLOW SPRINGS DR",
        "CITY:TALENT",
        "PRI:1",
        "UNIT:8300,8331,8833",
        "SRC:CAD07",
        "DATE:06/24/2012",
        "TIME:19:48:52");

    doTest("T2",
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:STRUCF, Structure Fire, 1457 WHITMAN AVE, MF, PRI:1, Unit:8300 - From CAD13 06/25/2012 17:38:40 ",

        "CODE:STRUCF",
        "CALL:Structure Fire",
        "ADDR:1457 WHITMAN AVE",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8300",
        "SRC:CAD13",
        "DATE:06/25/2012",
        "TIME:17:38:40");

    doTest("T3",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:MVCUF, MVC Unknown Injury, 1362 FOSS RD, TA, PRI:1, Units:8300, 8301, 8331, 8831 -\n" +
        "(Con't) 2 of 2\n" +
        "From CAD15 06/25/2012 18:54:05 \n" +
        "(End)",

        "CODE:MVCUF",
        "CALL:MVC Unknown Injury",
        "ADDR:1362 FOSS RD",
        "CITY:TALENT",
        "PRI:1",
        "UNIT:8300,8301,8331,8831",
        "SRC:CAD15",
        "DATE:06/25/2012",
        "TIME:18:54:05");

    doTest("T4",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:GRASS, Grass Fire, DEER TRAIL LN/COLEMAN CREEK RD, MF, PRI:1, Units:8300, 8303,\n" +
        "(Con't) 2 of 2\n" +
        "8341, 8361, 8363, 8801, ODFM - From CAD15 06/25/2012 18:55:35 \n" +
        "(End)",

        "CODE:GRASS",
        "CALL:Grass Fire",
        "ADDR:DEER TRAIL LN & COLEMAN CREEK RD",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8300,8303,8341,8361,8363,8801,ODFM",
        "SRC:CAD15",
        "DATE:06/25/2012",
        "TIME:18:55:35");

    doTest("T5",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:MVCUF, MVC Unknown Injury, 1362 FOSS RD, TA, PRI:1, Units:8300, 8301, 8331, 8831 -\n" +
        "(Con't) 2 of 2\n" +
        "From CAD15 06/25/2012 18:54:05 \n" +
        "(End)",

        "CODE:MVCUF",
        "CALL:MVC Unknown Injury",
        "ADDR:1362 FOSS RD",
        "CITY:TALENT",
        "PRI:1",
        "UNIT:8300,8301,8331,8831",
        "SRC:CAD15",
        "DATE:06/25/2012",
        "TIME:18:54:05");

    doTest("T6",
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:ALRMMF, Medical Alarm, 1122 N ROSE ST, PH, PRI:1, Units:8300, 8303 - From CAD15 06/25/2012 19:25:13 ",

        "CODE:ALRMMF",
        "CALL:Medical Alarm",
        "ADDR:1122 N ROSE ST",
        "CITY:PHOENIX",
        "PRI:1",
        "UNIT:8300,8303",
        "SRC:CAD15",
        "DATE:06/25/2012",
        "TIME:19:25:13");

    doTest("T7",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:STRUCF, Structure Fire, 180 LINCOLN ST, AS, PRI:1, Units:8300, 8301, 8801, 8802,\n" +
        "(Con't) 2 of 2\n" +
        "8853, 88CO - From CAD15 06/26/2012 07:47:36 \n" +
        "(End)",

        "CODE:STRUCF",
        "CALL:Structure Fire",
        "ADDR:180 LINCOLN ST",
        "CITY:ASHLAND",
        "PRI:1",
        "UNIT:8300,8301,8801,8802,8853,88CO",
        "SRC:CAD15",
        "DATE:06/26/2012",
        "TIME:07:47:36");

    doTest("T8",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:UNCF, Unconscious Person, 10548 WAGNER CREEK RD, TA, PRI:1, Units:8300, 8331, 8831 -\n" +
        "(Con't) 2 of 2\n" +
        "From CAD15 06/25/2012 21:13:21 \n" +
        "(End)",

        "CODE:UNCF",
        "CALL:Unconscious Person",
        "ADDR:10548 WAGNER CREEK RD",
        "CITY:TALENT",
        "PRI:1",
        "UNIT:8300,8331,8831",
        "SRC:CAD15",
        "DATE:06/25/2012",
        "TIME:21:13:21");

    doTest("T9",
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:STRUCF, Structure Fire, 3555 S PACIFIC HWY #193, MF, PRI:1, Unit:8300 - From CAD13 06/26/2012 23:12:50 ",

        "CODE:STRUCF",
        "CALL:Structure Fire",
        "ADDR:3555 S PACIFIC HWY",
        "APT:193",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8300",
        "SRC:CAD13",
        "DATE:06/26/2012",
        "TIME:23:12:50");

    doTest("T10",
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:MVCIF, MVC injury, 1188 OAK ST, AS, PRI:1, Units:8300, 8311, 8331, 8831 - From CAD15 07/01/2012 17:42:42 ",

        "CODE:MVCIF",
        "CALL:MVC injury",
        "ADDR:1188 OAK ST",
        "CITY:ASHLAND",
        "PRI:1",
        "UNIT:8300,8311,8331,8831",
        "SRC:CAD15",
        "DATE:07/01/2012",
        "TIME:17:42:42");

    doTest("T11",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:GRASS, Grass Fire, 4332 FERN VALLEY RD, MF, PRI:2A, Units:8106, 8146, 8166, 8168,\n" +
        "(Con't) 2 of 2\n" +
        "8300, 8300DO, 8311 - From CAD15 07/02/2012 19:53:43 \n" +
        "(End)",

        "CODE:GRASS",
        "CALL:Grass Fire",
        "ADDR:4332 FERN VALLEY RD",
        "CITY:MEDFORD",
        "PRI:2A",
        "UNIT:8106,8146,8166,8168,8300,8300DO,8311",
        "SRC:CAD15",
        "DATE:07/02/2012",
        "TIME:19:53:43");

    doTest("T12",
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:FALLF, Fall Victim, 300 LUMAN RD #45, PH, PRI:1, Units:8300, 8303 - From CAD15 07/01/2012 10:43:31 ",

        "CODE:FALLF",
        "CALL:Fall Victim",
        "ADDR:300 LUMAN RD",
        "APT:45",
        "CITY:PHOENIX",
        "PRI:1",
        "UNIT:8300,8303",
        "SRC:CAD15",
        "DATE:07/01/2012",
        "TIME:10:43:31");

    doTest("T13",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:GRASS, Grass Fire, 2050 BUTLER CREEK RD, AS, PRI:1, Units:8300, 8301, 8341, 8361,\n" +
        "(Con't) 2 of 2\n" +
        "8801, 8861, 88CO, ODFM - From CAD15 07/04/2012 13:49:40 \n" +
        "(End)",

        "CODE:GRASS",
        "CALL:Grass Fire",
        "ADDR:2050 BUTLER CREEK RD",
        "CITY:ASHLAND",
        "PRI:1",
        "UNIT:8300,8301,8341,8361,8801,8861,88CO,ODFM",
        "SRC:CAD15",
        "DATE:07/04/2012",
        "TIME:13:49:40");

    doTest("T14",
        "1 of 2\n" +
        "FRM:Messaging@ecso911.com\n" +
        "SUBJ:CAD Page\n" +
        "MSG:DISPATCH:SMOKE, Smoke Investigation, FOSS RD/ADAMS RD, TA, PRI:1, Units:8300, 8312 - From\n" +
        "(Con't) 2 of 2\n" +
        "CAD15 06/29/2012 20:51:08 \n" +
        "(End)",

        "CODE:SMOKE",
        "CALL:Smoke Investigation",
        "ADDR:FOSS RD & ADAMS RD",
        "CITY:TALENT",
        "PRI:1",
        "UNIT:8300,8312",
        "SRC:CAD15",
        "DATE:06/29/2012",
        "TIME:20:51:08");

  }
  
  @Test
  public void testApplegateFire() {

    doTest("T1",
        "(CAD Page) DISPATCH:ILBURN, Illegal Burn, CANTRALL BUCKLEY PARK, JV, PRI:1, Units:8503, 8515 - From CAD15 02/12/2013 17:59:46",
        "CODE:ILBURN",
        "CALL:Illegal Burn",
        "ADDR:CANTRALL BUCKLEY PARK",
        "CITY:JACKSONVILLE",
        "PRI:1",
        "UNIT:8503,8515",
        "SRC:CAD15",
        "DATE:02/12/2013",
        "TIME:17:59:46");

    doTest("T2",
        "(CAD Page) DISPATCH:ASSTPF, Assist to Public, APPLEGATE STORE, JV, PRI:1, Unit:8536 - From CAD15 02/11/2013 19:20:56",
        "CODE:ASSTPF",
        "CALL:Assist to Public",
        "ADDR:APPLEGATE STORE",
        "CITY:JACKSONVILLE",
        "PRI:1",
        "UNIT:8536",
        "SRC:CAD15",
        "DATE:02/11/2013",
        "TIME:19:20:56");

    doTest("T3",
        "(CAD Page) DISPATCH:STRUCF, Structure Fire, 1269 UPPER APPLEGATE RD, JV, PRI:1, Units:8501, 8503, 8515, 8539, 8541, 8543 - From CAD15 02/11/2013 15:10:11",
        "CODE:STRUCF",
        "CALL:Structure Fire",
        "ADDR:1269 UPPER APPLEGATE RD",
        "CITY:JACKSONVILLE",
        "PRI:1",
        "UNIT:8501,8503,8515,8539,8541,8543",
        "SRC:CAD15",
        "DATE:02/11/2013",
        "TIME:15:10:11");

    doTest("T4",
        "(CAD Page) DISPATCH:ALLERF, Allergic Reaction, 7208 HIGHWAY 238, JV, PRI:1, Unit:8533 - From CAD15 02/11/2013 10:47:01",
        "CODE:ALLERF",
        "CALL:Allergic Reaction",
        "ADDR:7208 HIGHWAY 238",
        "CITY:JACKSONVILLE",
        "PRI:1",
        "UNIT:8533",
        "SRC:CAD15",
        "DATE:02/11/2013",
        "TIME:10:47:01");

    doTest("T5",
        "(CAD Page) DISPATCH:FALLF, 8534, 199 POWELL CREEK RD, WI, PRI:1, Units:8500, 8534 - From CAD14 02/10/2013 13:48:32",
        "CODE:FALLF",
        "CALL:8534",
        "ADDR:199 POWELL CREEK RD",
        "CITY:WILLIAMS",
        "PRI:1",
        "UNIT:8500,8534",
        "SRC:CAD14",
        "DATE:02/10/2013",
        "TIME:13:48:32");

    doTest("T6",
        "(CAD Page) DISPATCH:HEMF, Hemorrhage, 18493 N APPLEGATE RD, GP, PRI:1, Units:8531, 8536, AMR - From CAD15 02/08/2013 18:14:41",
        "CODE:HEMF",
        "CALL:Hemorrhage",
        "ADDR:18493 N APPLEGATE RD",
        "CITY:GRANTS PASS",
        "PRI:1",
        "UNIT:8531,8536,AMR",
        "SRC:CAD15",
        "DATE:02/08/2013",
        "TIME:18:14:41");

    doTest("T7",
        "(CAD Page) DISPATCH:MVCUF, MVC Unknown Injury, WILLIAMS HWY/WATERGAP RD, GP, PRI:1, Units:8531, 8534, AMR - From CAD15 02/07/2013 19:28:52",
        "CODE:MVCUF",
        "CALL:MVC Unknown Injury",
        "ADDR:WILLIAMS HWY & WATERGAP RD",
        "CITY:GRANTS PASS",
        "PRI:1",
        "UNIT:8531,8534,AMR",
        "SRC:CAD15",
        "DATE:02/07/2013",
        "TIME:19:28:52");

    doTest("T8",
        "(CAD Page) DISPATCH:STRUCF, Structure Fire, 1000 BLK SOUTHSIDE RD, GP, PRI:1, Units:8504, 8544 - From CAD14 02/07/2013 08:56:40",
        "CODE:STRUCF",
        "CALL:Structure Fire",
        "ADDR:1000 BLK SOUTHSIDE RD",
        "MADDR:1000  SOUTHSIDE RD",
        "CITY:GRANTS PASS",
        "PRI:1",
        "UNIT:8504,8544",
        "SRC:CAD14",
        "DATE:02/07/2013",
        "TIME:08:56:40");

    doTest("T9",
        "(CAD Page) DISPATCH:GRASS, Grass Fire, KUBLI RD/MISSOURI FLAT RD, GP, PRI:1, Units:8536, 8541, 8561, ODFG - From CAD15 02/06/2013 15:13:32",
        "CODE:GRASS",
        "CALL:Grass Fire",
        "ADDR:KUBLI RD & MISSOURI FLAT RD",
        "CITY:GRANTS PASS",
        "PRI:1",
        "UNIT:8536,8541,8561,ODFG",
        "SRC:CAD15",
        "DATE:02/06/2013",
        "TIME:15:13:32");

    doTest("T10",
        "(CAD Page) DISPATCH:SICKF, General Illness, 6581 WHISPERING PINES LN, JV, PRI:1, Unit:8533 - From CAD07 02/06/2013 13:24:19",
        "CODE:SICKF",
        "CALL:General Illness",
        "ADDR:6581 WHISPERING PINES LN",
        "CITY:JACKSONVILLE",
        "PRI:1",
        "UNIT:8533",
        "SRC:CAD07",
        "DATE:02/06/2013",
        "TIME:13:24:19");

    doTest("T11",
        "(CAD Page) DISPATCH:BPF, 8500, 1100 GLENLYN DR, WI, PRI:1, Units:8500, 8534 - From CAD09 02/05/2013 02:01:34",
        "CODE:BPF",
        "CALL:8500",
        "ADDR:1100 GLENLYN DR",
        "CITY:WILLIAMS",
        "PRI:1",
        "UNIT:8500,8534",
        "SRC:CAD09",
        "DATE:02/05/2013",
        "TIME:02:01:34");

    doTest("T12",
        "(CAD Page) DISPATCH:TRAUMF, Traumatic Injury, 2032 CEDAR FLAT RD, WI, PRI:1, Unit:8500 - From CAD14 02/04/2013 08:53:13",
        "CODE:TRAUMF",
        "CALL:Traumatic Injury",
        "ADDR:2032 CEDAR FLAT RD",
        "CITY:WILLIAMS",
        "PRI:1",
        "UNIT:8500",
        "SRC:CAD14",
        "DATE:02/04/2013",
        "TIME:08:53:13");
    
  }
  
  @Test
  public void testMedfordFireRescue() {

    doTest("T1",
        "(CAD Page) DISPATCH:SICKF, General Illness, BEAR CREEK MOTEL #3, MF, at 2715 S PACIFIC HWY #3, MF, PRI:2, Unit:8103 - From CAD13 07/08/2013 16:05:58",
        "CODE:SICKF",
        "CALL:General Illness",
        "PLACE:BEAR CREEK MOTEL #3",
        "ADDR:2715 S PACIFIC HWY",
        "APT:3",
        "CITY:MEDFORD",
        "PRI:2",
        "UNIT:8103",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:16:05:58");

    doTest("T2",
        "(CAD Page) DISPATCH:ALARMF, Fire Alarm, 1000 TERMINAL LOOP PKWY, MF, btwn TERMINAL SPUR RD and AIRPORT RD, PRI:1, Units:7980, 8104 - From CAD13 07/08/2013 11:27:28",
        "CODE:ALARMF",
        "CALL:Fire Alarm",
        "ADDR:1000 TERMINAL LOOP PKWY",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:7980,8104",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:11:27:28");

    doTest("T3",
        "(CAD Page) DISPATCH:BARK, Bark Fire, COURTYARD BY MARRIOTT, MF, at 600 AIRPORT RD, MF, PRI:1, Unit:8104 - From CAD13 07/08/2013 09:03:35",
        "CODE:BARK",
        "CALL:Bark Fire",
        "PLACE:COURTYARD BY MARRIOTT",
        "ADDR:600 AIRPORT RD",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8104",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:09:03:35");

    doTest("T4",
        "(CAD Page) DISPATCH:SICKF, SEND LAW, 2520 W MAIN ST, MF, btwn CLOVER LN and DARLINGTON ST, PRI:2, Unit:8104 - From CAD13 07/08/2013 16:50:21",
        "CODE:SICKF",
        "CALL:SEND LAW",
        "ADDR:2520 W MAIN ST",
        "CITY:MEDFORD",
        "PRI:2",
        "UNIT:8104",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:16:50:21");

    doTest("T5",
        "(CAD Page) DISPATCH:PERDNF, Person Down, CEDAR ST/W JACKSON ST, MF,  <700/ 210>, PRI:1, Unit:8102 - From CAD13 07/08/2013 16:41:03",
        "CODE:PERDNF",
        "CALL:Person Down",
        "ADDR:CEDAR ST & W JACKSON ST",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8102",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:16:41:03");

    doTest("T6",
        "(CAD Page) DISPATCH:ABDOMF, Abdominal Pain, 3565 S VILLAGE DR, MF, btwn SCOTTSDALE CIR and N PHOENIX RD, PRI:1, Unit:8106 - From CAD13 07/08/2013 16:18:01",
        "CODE:ABDOMF",
        "CALL:Abdominal Pain",
        "ADDR:3565 S VILLAGE DR",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8106",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:16:18:01");

    doTest("T7",
        "(CAD Page) DISPATCH:CPF, Chest Pains, 63 NORTHRIDGE TER #23, MF, btwn S PACIFIC HWY and BEAR CREEK GREENWAY, PRI:1, Units:8153, 8303 - From CAD13 07/08/2013 16:15:03",
        "CODE:CPF",
        "CALL:Chest Pains",
        "ADDR:63 NORTHRIDGE TER",
        "APT:23",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8153,8303",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:16:15:03");

    doTest("T8",
        "(CAD Page) DISPATCH:BARK, Bark Fire, 1005 E MAIN ST #A, MF, btwn VANCOUVER AVE and WILLAMETTE AVE, PRI:1, Unit:8103 - From CAD13 07/08/2013 15:34:56",
        "CODE:BARK",
        "CALL:Bark Fire",
        "ADDR:1005 E MAIN ST",
        "APT:A",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8103",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:15:34:56");

    doTest("T9",
        "(CAD Page) DISPATCH:PERDNF, Person Down, 523 S CENTRAL AVE, MF, btwn E 12TH ST and E 13TH ST, PRI:1, Unit:8103 - From CAD13 07/08/2013 14:59:30",
        "CODE:PERDNF",
        "CALL:Person Down",
        "ADDR:523 S CENTRAL AVE",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8103",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:14:59:30");

    doTest("T10",
        "(CAD Page) DISPATCH:ALARMF, Fire Alarm, 1111 CRATER LAKE AVE, MF, btwn WOODROW LN and E MCANDREWS RD, PRI:1, Unit:8105 - From CAD13 07/08/2013 14:50:55",
        "CODE:ALARMF",
        "CALL:Fire Alarm",
        "ADDR:1111 CRATER LAKE AVE",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8105",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:14:50:55");

    doTest("T11",
        "(CAD Page) DISPATCH:HEMF, Hemorrhage, MEDFORD POST OFFICE, MF, at 325 S RIVERSIDE AVE, MF, PRI:1, Unit:8103 - From CAD13 07/08/2013 13:57:37",
        "CODE:HEMF",
        "CALL:Hemorrhage",
        "PLACE:MEDFORD POST OFFICE",
        "ADDR:325 S RIVERSIDE AVE",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8103",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:13:57:37");

    doTest("T12",
        "(CAD Page) DISPATCH:FALLF, Fall Victim, 2061 ROBERTS RD, MF, btwn CRATER LAKE AVE and SUNBURST CT, PRI:2, Unit:8105 - From CAD13 07/08/2013 13:48:34",
        "CODE:FALLF",
        "CALL:Fall Victim",
        "ADDR:2061 ROBERTS RD",
        "CITY:MEDFORD",
        "PRI:2",
        "UNIT:8105",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:13:48:34");

    doTest("T13",
        "(CAD Page) DISPATCH:DIABF, Diabetic Problem, 2458 REPUBLIC WAY, MF, btwn CONSTITUTION DR and END, PRI:1, Unit:8103 - From CAD13 07/08/2013 13:14:08",
        "CODE:DIABF",
        "CALL:Diabetic Problem",
        "ADDR:2458 REPUBLIC WAY",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8103",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:13:14:08");

    doTest("T14",
        "(CAD Page) DISPATCH:FALLF, Fall Victim, 154 1/2 DE HAGUE ST, MF, btwn CONNELL AVE and WYATT DR, PRI:1, Unit:8104 - From CAD13 07/08/2013 12:48:23",
        "CODE:FALLF",
        "CALL:Fall Victim",
        "ADDR:154 1/2 DE HAGUE ST",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8104",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:12:48:23");

    doTest("T15",
        "(CAD Page) DISPATCH:STRUCF, Structure Fire, 1800 E BARNETT RD #STEB, MF, btwn ELLENDALE DR and HILLDALE AVE, PRI:1, Units:8102, 8103, 8106, 8153 - From CAD13 07/08/2013 12:31:17",
        "CODE:STRUCF",
        "CALL:Structure Fire",
        "ADDR:1800 E BARNETT RD",
        "APT:STEB",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8102,8103,8106,8153",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:12:31:17");

    doTest("T16",
        "(CAD Page) DISPATCH:SEIZF, Seizure Victim, 406 W MAIN ST, MF, btwn N IVY ST and N OAKDALE AVE, PRI:1, Unit:8102 - From CAD13 07/08/2013 11:23:37",
        "CODE:SEIZF",
        "CALL:Seizure Victim",
        "ADDR:406 W MAIN ST",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8102",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:11:23:37");

    doTest("T17",
        "(CAD Page) DISPATCH:BPF, Breathing Problems, 307 BLACK OAK DR, MF, btwn COUNTRY CLUB DR and DELLWOOD AVE, PRI:1, Unit:8103 - From CAD13 07/08/2013 10:53:12",
        "CODE:BPF",
        "CALL:Breathing Problems",
        "ADDR:307 BLACK OAK DR",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8103",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:10:53:12");

    doTest("T18",
        "(CAD Page) DISPATCH:UNCF, Unconscious Person, 822 GOLF VIEW DR, MF, btwn CREEK VIEW DR and EDGEWATER DR, PRI:1, Unit:8103 - From CAD13 07/08/2013 10:15:24",
        "CODE:UNCF",
        "CALL:Unconscious Person",
        "ADDR:822 GOLF VIEW DR",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8103",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:10:15:24");

    doTest("T19",
        "(CAD Page) DISPATCH:HEARTF, Heart Problems, 1520 POPLAR DR #2, MF, btwn PROGRESS DR and MORROW RD, PRI:1, Unit:8105 - From CAD13 07/08/2013 09:16:11",
        "CODE:HEARTF",
        "CALL:Heart Problems",
        "ADDR:1520 POPLAR DR",
        "APT:2",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8105",
        "SRC:CAD13",
        "DATE:07/08/2013",
        "TIME:09:16:11");

    doTest("T20",
        "(CAD Page) DISPATCH:SEIZF, Seizure Victim, 2162 CAMP BAKER RD, MF, btwn LAUREL LN and CHARLOTTE LN, PRI:1, Unit:8102 - From CAD15 07/08/2013 08:57:57",
        "CODE:SEIZF",
        "CALL:Seizure Victim",
        "ADDR:2162 CAMP BAKER RD",
        "CITY:MEDFORD",
        "PRI:1",
        "UNIT:8102",
        "SRC:CAD15",
        "DATE:07/08/2013",
        "TIME:08:57:57");
  
  }
  
  public static void main(String args[]) {
    new ORJacksonCountyParserTest().generateTests("T1");
  }
}