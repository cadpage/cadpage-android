package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Cleveland County, NC
Contact: Richard Carroll <crrll19@gmail.com>
Sender: CAD@clevelandcounty.com

CAD:7044775828-CHEST PA-1861 E MARION ST-CAMDEN CT-BORDERS RD-[Medical Priority Info] PROBLEM: TINGLING DOWN HER ARMS # PATS: 1 AGE: 30 Years SEX: Female CO
CAD:10-50 PI-CHARLES RD/W DIXON BLVD-[LAW] 2 cars [07/25/12 19:10:38 C89] Aborted by Medical Priority with code: 1. Caller hung up [07/25/12 19:10:23 C89]
CAD:7042978331-SEIZURES-117 PALMER ST-E MARION ST-AIRLINE AV-[Medical Priority Info] PROBLEM: seizure # PATS: 1 AGE: 22 Years SEX: Male CONSCIOUS: No BREATH
CAD:KELIOSA-SEIZURES-313 S POST RD-GARRETT DR-KINGS ROAD EXT-[Medical Priority Info] PROBLEM: seizure # PATS: 1 AGE: 3 Years SEX: Female CONSCIOUS: No BREAT
CAD:10-50 PI-CHARLES RD/W DIXON BLVD-[LAW] 2 cars [07/25/12 19:10:38 C89] Aborted by Medical Priority with code: 1. Caller hung up [07/25/12 19:10:23 C89]
CAD:SPRINT PCS-9802953855-FIREAPT-415 GARDNER ST-SMITH ST-MARTIN ST-kitchen on fire at aprtment 5 they are trying to get every one out of adjacent apts [07/
CAD:CICILIA-8286444392-FIRE/HAZ-354 WASHBURN SWITCH RD-LILLCO DR-AMBER LN-GAS LEAK INSIDE THE HOUSE [07/31/12 21:18:19 C84]
CAD:AT&T MOBILITY-9118385620-FIRE/MIS-705 E DIXON BLVD-WAL-MART-EARL RD-GROVE ST

Contact: Active911
Agency name: Shanghai Volunteer Fire Department
Location: Shelby, NC, United States

CAD:990-FIRE ALA-110 S MAIN ST-GWU/DECKER RESIDENCE HALL-E COLLEGE AV-FALCON CIR-decker dorm ref fire alarm [02/01/13 17:20:30 C77]
CAD:GWPD-7044064444-FIRE ALA-110 S MAIN ST-GWU/LUTZ-YELTON CONVOCATION C-E COLLEGE AV-FALCON CIR-gen fure [02/01/13 11:55:15 C89]
CAD:CHRIS SLUDER-OVERDOSE-2041 CLAY RD-BURKE RD-BURKE RD-He is seeing stuff. he thinks the people in the house did it. [01/31/13 22:10:58 C94] 31 year old male says he thinks he has been drugged. He is not alert. He is having trouble breath
CAD:DUKE ENERGY - JUDY-7043953825-FIRE/MIS-1053 OLD BOILING SPRINGS RD-WEBB RD-COLLEGE AV-Advised fire dept already went out there. Caller adv the tree cutters weren`t there yet. They are there now. [01/30/13 19:31:02 C75] Tree cutters on s
CAD:DUKE ENERGY - DARRYL-7043953825-FIRE/MIS-1053 OLD BOILING SPRINGS RD-WEBB RD-COLLEGE AV-trees have to be cut. Requests fire dept for traffic control. They have cutters there now. [01/30/13 18:29:04 C75]
CAD:SECURITY CENTRAL,-8002865699-FIRE ALA-1711 BURKE RD-THORE RD-SOUTH PATTERSON RD-Humphries residence, 704-484-9538, poa hall smoke activation. [01/30/13 13:11:03 C75]
CAD:CROWELL-7044349865-FIRE/HAZ-315 BEAVER DAM CHURCH RD-CREST MIDDLE SCHOOL-CREST RD-LANEY DR-caller advised smelt gas in the area [01/29/13 15:40:01 DSR] bridge anear crest middle school [01/29/13 15:39:16 DSR]
CAD:CLEVELAND COUNTY SCHOOLS-7044825355-SEIZURES-800 OLD BOILING SPRINGS RD-CREST HIGH SCHOOL-CREST RD-CRESTWOOD DR-[PROQA] RESPONSE: Delta [01/29/13 14:00:42 C80]
CAD:BARRY-- C985-7042976981-FIRE ALA-110 S MAIN ST-GWU/CAMPUS APARTMENTS-E COLLEGE AV-FALCON CIR-UNIVERSITY COMMONS BUILDING B [01/29/13 12:20:30 C89]
CAD:VERIZON WIRELESS-7044738019-10-50 PI-1043 POPLAR SPRINGS CHURCH RD-SHERIFF ALLEN RD-BEN JONES RD
CAD:FIRE ALA-110 S MAIN ST-GWU/CAMPUS APARTMENTS-E COLLEGE AV-FALCON CIR-apt e [01/25/13 10:05:58 C90]
CAD:ALEXANDER, ROBERT-7044806339-STROKE-1002 WESTERN LN-LONGWOOD DR-[PROQA] RESPONSE: Delta [01/24/13 22:37:38 DSR] posible stroke 84 yoa female [01/24/13 22:34:41 DSR]
CAD:SALLY THOMPSON-7044665997-FIRE/INV-1019 TIMBER RIDGE RD-GREEN CT-smoke in the area [01/24/13 17:56:48 C88]

*/

public class NCClevelandCountyParserTest extends BaseParserTest {
  
  public NCClevelandCountyParserTest() {
    setParser(new NCClevelandCountyParser(), "CLEVELAND COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:7044775828-CHEST PA-1861 E MARION ST-CAMDEN CT-BORDERS RD-[Medical Priority Info] PROBLEM: TINGLING DOWN HER ARMS # PATS: 1 AGE: 30 Years SEX: Female CO",
        "PHONE:7044775828",
        "CALL:CHEST PA",
        "ADDR:1861 E MARION ST",
        "X:CAMDEN CT & BORDERS RD",
        "INFO:TINGLING DOWN HER ARMS # PATS: 1 AGE: 30 Years SEX: Female CO");

    doTest("T2",
        "CAD:10-50 PI-CHARLES RD/W DIXON BLVD-[LAW] 2 cars [07/25/12 19:10:38 C89] Aborted by Medical Priority with code: 1. Caller hung up [07/25/12 19:10:23 C89]",
        "CALL:10-50 PI",
        "ADDR:CHARLES RD & W DIXON BLVD",
        "INFO:2 cars / Aborted by Medical Priority with code: 1. Caller hung up",
        "DATE:07/25/12",
        "TIME:19:10:38");

    doTest("T3",
        "CAD:7042978331-SEIZURES-117 PALMER ST-E MARION ST-AIRLINE AV-[Medical Priority Info] PROBLEM: seizure # PATS: 1 AGE: 22 Years SEX: Male CONSCIOUS: No BREATH",
        "PHONE:7042978331",
        "CALL:SEIZURES",
        "ADDR:117 PALMER ST",
        "X:E MARION ST & AIRLINE AV",
        "INFO:seizure # PATS: 1 AGE: 22 Years SEX: Male CONSCIOUS: No BREATH");

    doTest("T4",
        "CAD:KELIOSA-SEIZURES-313 S POST RD-GARRETT DR-KINGS ROAD EXT-[Medical Priority Info] PROBLEM: seizure # PATS: 1 AGE: 3 Years SEX: Female CONSCIOUS: No BREAT",
        "CALL:KELIOSA-SEIZURES",
        "ADDR:313 S POST RD",
        "X:GARRETT DR & KINGS ROAD EXT",
        "INFO:seizure # PATS: 1 AGE: 3 Years SEX: Female CONSCIOUS: No BREAT");

    doTest("T5",
        "CAD:10-50 PI-CHARLES RD/W DIXON BLVD-[LAW] 2 cars [07/25/12 19:10:38 C89] Aborted by Medical Priority with code: 1. Caller hung up [07/25/12 19:10:23 C89]",
        "CALL:10-50 PI",
        "ADDR:CHARLES RD & W DIXON BLVD",
        "INFO:2 cars / Aborted by Medical Priority with code: 1. Caller hung up",
        "DATE:07/25/12",
        "TIME:19:10:38");

    doTest("T6",
        "CAD:SPRINT PCS-9802953855-FIREAPT-415 GARDNER ST-SMITH ST-MARTIN ST-kitchen on fire at aprtment 5 they are trying to get every one out of adjacent apts [07/",
        "PHONE:9802953855",
        "CALL:FIREAPT",
        "ADDR:415 GARDNER ST",
        "X:SMITH ST & MARTIN ST",
        "INFO:kitchen on fire at aprtment 5 they are trying to get every one out of adjacent apts");

    doTest("T7",
        "CAD:CICILIA-8286444392-FIRE/HAZ-354 WASHBURN SWITCH RD-LILLCO DR-AMBER LN-GAS LEAK INSIDE THE HOUSE [07/31/12 21:18:19 C84]",
        "NAME:CICILIA",
        "PHONE:8286444392",
        "CALL:FIRE/HAZ",
        "ADDR:354 WASHBURN SWITCH RD",
        "X:LILLCO DR & AMBER LN",
        "INFO:GAS LEAK INSIDE THE HOUSE",
        "DATE:07/31/12",
        "TIME:21:18:19");

    doTest("T8",
        "CAD:AT&T MOBILITY-9118385620-FIRE/MIS-705 E DIXON BLVD-WAL-MART-EARL RD-GROVE ST",
        "PHONE:9118385620",
        "CALL:FIRE/MIS",
        "ADDR:705 E DIXON BLVD",
        "PLACE:WAL-MART",
        "X:EARL RD & GROVE ST");
  }
  
  @Test
  public void testShanghaiFire() {

    doTest("T1",
        "CAD:990-FIRE ALA-110 S MAIN ST-GWU/DECKER RESIDENCE HALL-E COLLEGE AV-FALCON CIR-decker dorm ref fire alarm [02/01/13 17:20:30 C77]",
        "CALL:990-FIRE ALA",
        "ADDR:110 S MAIN ST",
        "X:E COLLEGE AV & FALCON CIR",
        "PLACE:GWU/DECKER RESIDENCE HALL",
        "INFO:decker dorm ref fire alarm",
        "DATE:02/01/13",
        "TIME:17:20:30");

    doTest("T2",
        "CAD:GWPD-7044064444-FIRE ALA-110 S MAIN ST-GWU/LUTZ-YELTON CONVOCATION C-E COLLEGE AV-FALCON CIR-gen fure [02/01/13 11:55:15 C89]",
        "NAME:GWPD",
        "PHONE:7044064444",
        "CALL:FIRE ALA",
        "ADDR:110 S MAIN ST",
        "X:E COLLEGE AV & FALCON CIR",
        "PLACE:GWU/LUTZ-YELTON CONVOCATION C",
        "INFO:gen fure",
        "DATE:02/01/13",
        "TIME:11:55:15");

    doTest("T3",
        "CAD:CHRIS SLUDER-OVERDOSE-2041 CLAY RD-BURKE RD-BURKE RD-He is seeing stuff. he thinks the people in the house did it. [01/31/13 22:10:58 C94] 31 year old male says he thinks he has been drugged. He is not alert. He is having trouble breath",
        "CALL:CHRIS SLUDER-OVERDOSE",
        "ADDR:2041 CLAY RD",
        "X:BURKE RD & BURKE RD",
        "INFO:He is seeing stuff. he thinks the people in the house did it. / 31 year old male says he thinks he has been drugged. He is not alert. He is having trouble breath",
        "DATE:01/31/13",
        "TIME:22:10:58");

    doTest("T4",
        "CAD:DUKE ENERGY - JUDY-7043953825-FIRE/MIS-1053 OLD BOILING SPRINGS RD-WEBB RD-COLLEGE AV-Advised fire dept already went out there. Caller adv the tree cutters weren`t there yet. They are there now. [01/30/13 19:31:02 C75] Tree cutters on s",
        "CALL:DUKE ENERGY-JUDY-7043953825-FIRE/MIS",
        "ADDR:1053 OLD BOILING SPRINGS RD",
        "X:WEBB RD & COLLEGE AV",
        "INFO:Advised fire dept already went out there. Caller adv the tree cutters weren`t there yet. They are there now. / Tree cutters on s",
        "DATE:01/30/13",
        "TIME:19:31:02");

    doTest("T5",
        "CAD:DUKE ENERGY - DARRYL-7043953825-FIRE/MIS-1053 OLD BOILING SPRINGS RD-WEBB RD-COLLEGE AV-trees have to be cut. Requests fire dept for traffic control. They have cutters there now. [01/30/13 18:29:04 C75]",
        "CALL:DUKE ENERGY-DARRYL-7043953825-FIRE/MIS",
        "ADDR:1053 OLD BOILING SPRINGS RD",
        "X:WEBB RD & COLLEGE AV",
        "INFO:trees have to be cut. Requests fire dept for traffic control. They have cutters there now.",
        "DATE:01/30/13",
        "TIME:18:29:04");

    doTest("T6",
        "CAD:SECURITY CENTRAL,-8002865699-FIRE ALA-1711 BURKE RD-THORE RD-SOUTH PATTERSON RD-Humphries residence, 704-484-9538, poa hall smoke activation. [01/30/13 13:11:03 C75]",
        "NAME:SECURITY CENTRAL,",
        "PHONE:8002865699",
        "CALL:FIRE ALA",
        "ADDR:1711 BURKE RD",
        "X:THORE RD & SOUTH PATTERSON RD",
        "INFO:Humphries residence, 704 / 484 / 9538, poa hall smoke activation.",
        "DATE:01/30/13",
        "TIME:13:11:03");

    doTest("T7",
        "CAD:CROWELL-7044349865-FIRE/HAZ-315 BEAVER DAM CHURCH RD-CREST MIDDLE SCHOOL-CREST RD-LANEY DR-caller advised smelt gas in the area [01/29/13 15:40:01 DSR] bridge anear crest middle school [01/29/13 15:39:16 DSR]",
        "NAME:CROWELL",
        "PHONE:7044349865",
        "CALL:FIRE/HAZ",
        "ADDR:315 BEAVER DAM CHURCH RD",
        "X:CREST RD & LANEY DR",
        "PLACE:CREST MIDDLE SCHOOL",
        "INFO:caller advised smelt gas in the area / bridge anear crest middle school",
        "DATE:01/29/13",
        "TIME:15:40:01");

    doTest("T8",
        "CAD:CLEVELAND COUNTY SCHOOLS-7044825355-SEIZURES-800 OLD BOILING SPRINGS RD-CREST HIGH SCHOOL-CREST RD-CRESTWOOD DR-[PROQA] RESPONSE: Delta [01/29/13 14:00:42 C80]",
        "NAME:CLEVELAND COUNTY SCHOOLS",
        "PHONE:7044825355",
        "CALL:SEIZURES",
        "ADDR:800 OLD BOILING SPRINGS RD",
        "X:CREST RD & CRESTWOOD DR",
        "PLACE:CREST HIGH SCHOOL",
        "INFO:RESPONSE: Delta",
        "DATE:01/29/13",
        "TIME:14:00:42");

    doTest("T9",
        "CAD:BARRY-- C985-7042976981-FIRE ALA-110 S MAIN ST-GWU/CAMPUS APARTMENTS-E COLLEGE AV-FALCON CIR-UNIVERSITY COMMONS BUILDING B [01/29/13 12:20:30 C89]",
        "CALL:BARRY-C985-7042976981-FIRE ALA",
        "ADDR:110 S MAIN ST",
        "X:E COLLEGE AV & FALCON CIR",
        "PLACE:GWU/CAMPUS APARTMENTS",
        "INFO:UNIVERSITY COMMONS BUILDING B",
        "DATE:01/29/13",
        "TIME:12:20:30");

    doTest("T10",
        "CAD:VERIZON WIRELESS-7044738019-10-50 PI-1043 POPLAR SPRINGS CHURCH RD-SHERIFF ALLEN RD-BEN JONES RD",
        "PHONE:7044738019",
        "CALL:10-50 PI",
        "ADDR:1043 POPLAR SPRINGS CHURCH RD",
        "X:SHERIFF ALLEN RD & BEN JONES RD");

    doTest("T11",
        "CAD:FIRE ALA-110 S MAIN ST-GWU/CAMPUS APARTMENTS-E COLLEGE AV-FALCON CIR-apt e [01/25/13 10:05:58 C90]",
        "CALL:FIRE ALA",
        "ADDR:110 S MAIN ST",
        "APT:e",
        "X:E COLLEGE AV & FALCON CIR",
        "PLACE:GWU/CAMPUS APARTMENTS",
        "DATE:01/25/13",
        "TIME:10:05:58");

    doTest("T12",
        "CAD:ALEXANDER, ROBERT-7044806339-STROKE-1002 WESTERN LN-LONGWOOD DR-[PROQA] RESPONSE: Delta [01/24/13 22:37:38 DSR] posible stroke 84 yoa female [01/24/13 22:34:41 DSR]",
        "NAME:ALEXANDER, ROBERT",
        "PHONE:7044806339",
        "CALL:STROKE",
        "ADDR:1002 WESTERN LN",
        "X:LONGWOOD DR",
        "INFO:RESPONSE: Delta / posible stroke 84 yoa female",
        "DATE:01/24/13",
        "TIME:22:37:38");

    doTest("T13",
        "CAD:SALLY THOMPSON-7044665997-FIRE/INV-1019 TIMBER RIDGE RD-GREEN CT-smoke in the area [01/24/13 17:56:48 C88]",
        "NAME:SALLY THOMPSON",
        "PHONE:7044665997",
        "CALL:FIRE/INV",
        "ADDR:1019 TIMBER RIDGE RD",
        "X:GREEN CT",
        "INFO:smoke in the area",
        "DATE:01/24/13",
        "TIME:17:56:48");

  }

  public static void main(String[] args) {
    new NCClevelandCountyParserTest().generateTests("T1");
  }
}
