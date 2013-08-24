package net.anei.cadpage.parsers.NV;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Clark County, NV
Contact: andrew frechette <lvswatmedic12@gmail.com>
Contact: Trevor Nelson <robs_trevor@yahoo.com>
Sender: sms@pageway.net

(SMS) 580 13006900 Pri:2 Prob:17B Grid:02729-55 INDIOS AV & BOULDER HWY Bld: Apt: Zip:89121
(SMS) 580 13007393 Pri:2 Prob:17B Grid:02629-57 4800 VEGAS VALLEY DR Bld: Apt:179 Zip:89121
(SMS) 580 13007380 Cancel Call. Disp:10:24 Enroute:10:25 On Scene:10:40 Cancelled:10:48 Reason:851
(SMS) 580 13007380 Pri:1 Prob:23C Grid:03127-22 5850 EUCLID ST Bld: Apt: Zip:89120
(SMS) 580 13007378 Pri:3 Prob:26A Grid:02726-31 3501 S MARYLAND PKY Bld: Apt:87 Zip:
(SMS) 580 13007214 Pri:2 Prob:32B Grid:02226-53 E LAKE MEAD BLVD & N LAS VEGAS BLVD Bld: Apt: Zip:
(SMS) 580 13007175 Pri:2 Prob:32B Grid:02628-44 3738 BOULDER HWY Bld: Apt: Zip:89121
(SMS) 580 13007151 Pri:3 Prob:1A- Grid:02826-59 2325 E HARMON AV Bld: Apt: Zip:89119
(SMS) 580 13007151 Disp:16:09:12 Enroute:16:09:27 On Scene:16:13:55 To Hosp:16:21:56 At Hosp:16:36:49
 SMS / 518 13006170 Pri:1 Prob:29D Grid:02631-11 E SAHARA AV & S NELLIS BLVD Bld: Apt: Zip:89142
 SMS / 518 13006481 Pri:1 Prob:12D Grid:01929-89 3325 N NELLIS BLVD Bld: Apt:115 Zip:89115
 SMS / 518 13006170 Pri:1 Prob:29D Grid:02631-11 E SAHARA AV & S NELLIS BLVD Bld: Apt: Zip:89142
 SMS / 518 13006183 Pri:1 Prob:6C- Grid:2625-1/11 2945 CASA VEGAS ST Bld: Apt:117 B Zip:89169
 SMS / 518 13006224 Pri:1 Prob:29D Grid:02624-94 S LAS VEGAS BLVD & ECHELON RESORT DR Bld: Apt: Zip:89109
 SMS / 518 13006481 Pri:1 Prob:12D Grid:01929-89 3325 N NELLIS BLVD Bld: Apt:115 Zip:89115
 SMS / 518 13006411 Pri:1 Prob:6D- Grid:01923-81 3602 GOLD SLUICE AVE Bld: Apt: Zip:
 SMS / 518 13006393 Pri:1 Prob:31D Grid:02724-14 3131 S LAS VEGAS BLVD Bld: Apt: Zip:89109
 SMS / 518 13006426 Pri:1 Prob:27D Grid:02725-67 3825 CAMBRIDGE ST Bld: Apt: Zip:89119

*/

public class NVClarkCountyBParserTest extends BaseParserTest {
  
  public NVClarkCountyBParserTest() {
    setParser(new NVClarkCountyBParser(), "CLARK COUNTY", "NV");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(SMS) 580 13006900 Pri:2 Prob:17B Grid:02729-55 INDIOS AV & BOULDER HWY Bld: Apt: Zip:89121",
        "UNIT:580",
        "ID:13006900",
        "PRI:2",
        "CODE:17B",
        "MAP:02729-55",
        "ADDR:INDIOS AV & BOULDER HWY",
        "MADDR:INDIOS AVE & BOULDER HWY",
        "CITY:89121");

    doTest("T2",
        "(SMS) 580 13007393 Pri:2 Prob:17B Grid:02629-57 4800 VEGAS VALLEY DR Bld: Apt:179 Zip:89121",
        "UNIT:580",
        "ID:13007393",
        "PRI:2",
        "CODE:17B",
        "MAP:02629-57",
        "ADDR:4800 VEGAS VALLEY DR",
        "APT:179",
        "CITY:89121");

    doTest("T1",
        "(SMS) 580 13007380 Cancel Call. Disp:10:24 Enroute:10:25 On Scene:10:40 Cancelled:10:48 Reason:851",
        "CALL:RUN REPORT",
        "PLACE:Cancel Call. Disp:10:24 Enroute:10:25 On Scene:10:40 Cancelled:10:48 Reason:851",
        "UNIT:580",
        "ID:13007380");

    doTest("T4",
        "(SMS) 580 13007380 Pri:1 Prob:23C Grid:03127-22 5850 EUCLID ST Bld: Apt: Zip:89120",
        "UNIT:580",
        "ID:13007380",
        "PRI:1",
        "CODE:23C",
        "MAP:03127-22",
        "ADDR:5850 EUCLID ST",
        "CITY:89120");

    doTest("T5",
        "(SMS) 580 13007378 Pri:3 Prob:26A Grid:02726-31 3501 S MARYLAND PKY Bld: Apt:87 Zip:",
        "UNIT:580",
        "ID:13007378",
        "PRI:3",
        "CODE:26A",
        "MAP:02726-31",
        "ADDR:3501 S MARYLAND PKY",
        "MADDR:3501 S MARYLAND PKWY",
        "APT:87");

    doTest("T6",
        "(SMS) 580 13007214 Pri:2 Prob:32B Grid:02226-53 E LAKE MEAD BLVD & N LAS VEGAS BLVD Bld: Apt: Zip:",
        "UNIT:580",
        "ID:13007214",
        "PRI:2",
        "CODE:32B",
        "MAP:02226-53",
        "ADDR:E LAKE MEAD BLVD & N LAS VEGAS BLVD");

    doTest("T7",
        "(SMS) 580 13007175 Pri:2 Prob:32B Grid:02628-44 3738 BOULDER HWY Bld: Apt: Zip:89121",
        "UNIT:580",
        "ID:13007175",
        "PRI:2",
        "CODE:32B",
        "MAP:02628-44",
        "ADDR:3738 BOULDER HWY",
        "CITY:89121");

    doTest("T8",
        "(SMS) 580 13007151 Pri:3 Prob:1A- Grid:02826-59 2325 E HARMON AV Bld: Apt: Zip:89119",
        "UNIT:580",
        "ID:13007151",
        "PRI:3",
        "CODE:1A-",
        "MAP:02826-59",
        "ADDR:2325 E HARMON AV",
        "MADDR:2325 E HARMON AVE",
        "CITY:89119");

    doTest("T9",
        "(SMS) 580 13007151 Disp:16:09:12 Enroute:16:09:27 On Scene:16:13:55 To Hosp:16:21:56 At Hosp:16:36:49",
        "CALL:RUN REPORT",
        "PLACE:Disp:16:09:12 Enroute:16:09:27 On Scene:16:13:55 To Hosp:16:21:56 At Hosp:16:36:49",
        "UNIT:580",
        "ID:13007151");

    doTest("T10",
        " SMS / 518 13006170 Pri:1 Prob:29D Grid:02631-11 E SAHARA AV & S NELLIS BLVD Bld: Apt: Zip:89142",
        "UNIT:518",
        "ID:13006170",
        "PRI:1",
        "CODE:29D",
        "MAP:02631-11",
        "ADDR:E SAHARA AV & S NELLIS BLVD",
        "MADDR:E SAHARA AVE & S NELLIS BLVD",
        "CITY:89142");

    doTest("T11",
        " SMS / 518 13006481 Pri:1 Prob:12D Grid:01929-89 3325 N NELLIS BLVD Bld: Apt:115 Zip:89115",
        "UNIT:518",
        "ID:13006481",
        "PRI:1",
        "CODE:12D",
        "MAP:01929-89",
        "ADDR:3325 N NELLIS BLVD",
        "APT:115",
        "CITY:89115");

    doTest("T12",
        " SMS / 518 13006170 Pri:1 Prob:29D Grid:02631-11 E SAHARA AV & S NELLIS BLVD Bld: Apt: Zip:89142",
        "UNIT:518",
        "ID:13006170",
        "PRI:1",
        "CODE:29D",
        "MAP:02631-11",
        "ADDR:E SAHARA AV & S NELLIS BLVD",
        "MADDR:E SAHARA AVE & S NELLIS BLVD",
        "CITY:89142");

    doTest("T13",
        "SMS / 518 13006183 Pri:1 Prob:6C- Grid:2625-1/11 2945 CASA VEGAS ST Bld: Apt:117 B Zip:89169",
        "UNIT:518",
        "ID:13006183",
        "PRI:1",
        "CODE:6C-",
        "MAP:2625-1/11",
        "ADDR:2945 CASA VEGAS ST",
        "APT:117 B",
        "CITY:89169");

    doTest("T14",
        " SMS / 518 13006224 Pri:1 Prob:29D Grid:02624-94 S LAS VEGAS BLVD & ECHELON RESORT DR Bld: Apt: Zip:89109",
        "UNIT:518",
        "ID:13006224",
        "PRI:1",
        "CODE:29D",
        "MAP:02624-94",
        "ADDR:S LAS VEGAS BLVD & ECHELON RESORT DR",
        "CITY:89109");

    doTest("T15",
        " SMS / 518 13006481 Pri:1 Prob:12D Grid:01929-89 3325 N NELLIS BLVD Bld: Apt:115 Zip:89115",
        "UNIT:518",
        "ID:13006481",
        "PRI:1",
        "CODE:12D",
        "MAP:01929-89",
        "ADDR:3325 N NELLIS BLVD",
        "APT:115",
        "CITY:89115");

    doTest("T16",
        " SMS / 518 13006411 Pri:1 Prob:6D- Grid:01923-81 3602 GOLD SLUICE AVE Bld: Apt: Zip:",
        "UNIT:518",
        "ID:13006411",
        "PRI:1",
        "CODE:6D-",
        "MAP:01923-81",
        "ADDR:3602 GOLD SLUICE AVE");

    doTest("T17",
        " SMS / 518 13006393 Pri:1 Prob:31D Grid:02724-14 3131 S LAS VEGAS BLVD Bld: Apt: Zip:89109",
        "UNIT:518",
        "ID:13006393",
        "PRI:1",
        "CODE:31D",
        "MAP:02724-14",
        "ADDR:3131 S LAS VEGAS BLVD",
        "CITY:89109");

    doTest("T18",
        " SMS / 518 13006426 Pri:1 Prob:27D Grid:02725-67 3825 CAMBRIDGE ST Bld: Apt: Zip:89119",
        "UNIT:518",
        "ID:13006426",
        "PRI:1",
        "CODE:27D",
        "MAP:02725-67",
        "ADDR:3825 CAMBRIDGE ST",
        "CITY:89119");

  }
  

  public static void main(String[] args) {
    new NVClarkCountyBParserTest().generateTests("T1");
  }
}
