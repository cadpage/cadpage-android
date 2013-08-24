package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Lehigh County PA

Contact: Active911
Agency name: Lehigh Valley Health Network Public Safety
Location: Allentown, PA, United States
Sender: dispatch@lvh.com

(- part 1 of 1) RC:MV InterFac Ground Urgent/700 E BROAD ST/MED SUR FL 510 B//LVH-CC/2K ROOM 11
(- part 1 of 1) RC:MV InterFac Ground Urgent/1600 E HIGH ST/ER/15 YOM/ 160 LBS. IV. MONITOR. CARDIAC ARRYTHMIAS. 2 SYCONPES IN ER 1 HR APART. R BUNDLE BRANCH BLOCK. UNKNOWN DRIPS./1200 S CEDAR CREST BLVD/3K 05
(- part 1 of 1) RC:MV InterFac Ground Urgent/LVH-M/ed/transfer from muhl with no data. never recieved call. was given to crew at hospital./LVH-CC/10
(- part 1 of 1) RC:MV InterFac Ground Scheduled/LVH-CC/ER 28/CARDIAC MONITOR. IVs. PT WT 197 LBS. 85/45; 98; 20; 94% RA. TEMP 100.0  PT STABLE. TRANSFER FOR POSSIBLE SEPSIS AND HYPOTENSION./100 N ACADEMY AVE/ROOM 210
(- part 1 of 1) RC:MV InterFac Ground Urgent/185 ROSEBERRY ST/icu/80 yr old female gi bleed. hemo stable. on a protonix drip/2K MICU SICU/2k09
(- part 1 of 1) RC:MV InterFac Ground Urgent/206 E BROWN ST/ER/17 YR OLD MALE.  OVER DOSE ASA/PICU/JAINDL SECOND FLOOR
(- part 1 of 1) RC:MV InterFac Ground Urgent/1600 E HIGH ST/502 Bed 1/80 yo female - empyema - b/l chest tubes - no drips - referring facility refusing air request ground SCT ONLY/LVH-M/Regional Heart Bed 359
(- part 1 of 1) RC:Detail/700 E BROAD ST//PR DETAIL AT HGH//
(- part 1 of 1) RC:MV InterFac Ground Urgent/250 S 21ST ST/3NW3132/67 YO M SPINAL CORD COMPRESSION - NO LINES - NO DRIPS - DR KUIKLITIS ACCEPTING/LVH-CC/TNICU J210A
(- part 1 of 1) RC:MV InterFac Ground Urgent/135 LAFAYETTE AVE/ED/83 YR FEMALE INTERCRAINAL HEMMORAGE/1200 S CEDAR CREST BLVD/J222B
(- part 1 of 1) RC:MV-InterFac-Ground-Scheduled/4B Pediatrics/4b17a/7 y/f female. New diagnosis of brain mass. no drips/ no lines./3400 CIVIC CENTER BLVD/3E
(- part 1 of 1) RC:MV-InterFac-Ground-Urgent/ED Muhl/KOLB SECOND FLOOR/77 Y/O FEMALE/ OCCLED FEM-FEM BYPASS/ ON A HEPARIN DRIP / GOING TO RM 338 @ POCONO/206 E BROWN ST/NULL
(- part 1 of 1) RC:MV-InterFac-Ground-Urgent/206 E BROWN ST/ED/52 F  ED UNK BED    BRAIN TUMOR   NORMAL VITALS/TNICU/JAINDL SECOND FLOOR J220B/Run# 26435
(- part 1 of 1) RC:Code Blue/1240/1ST FL INFUSION/
(- part 1 of 1) RC:MV-InterFac-Ground-Urgent/135 LAFAYETTE AVE/PALMERTON HOSPITAL/70 Y/O M  S

*/

public class PALehighCountyBParserTest extends BaseParserTest {
  
  public PALehighCountyBParserTest() {
    setParser(new PALehighCountyBParser(), "LEHIGH COUNTY", "PA");
  }
  
  @Test
  public void testLehighValleyNetworkPublicSafety() {

    doTest("T1",
        "(- part 1 of 1) RC:MV InterFac Ground Urgent/700 E BROAD ST/MED SUR FL 510 B//LVH-CC/2K ROOM 11",
        "CALL:MV InterFac Ground Urgent",
        "ADDR:700 E BROAD ST",  // Not mapping
        "APT:MED SUR FL 510 B",
        "INFO:LVH-CC / 2K ROOM 11");

    doTest("T2",
        "(- part 1 of 1) RC:MV InterFac Ground Urgent/1600 E HIGH ST/ER/15 YOM/ 160 LBS. IV. MONITOR. CARDIAC ARRYTHMIAS. 2 SYCONPES IN ER 1 HR APART. R BUNDLE BRANCH BLOCK. UNKNOWN DRIPS./1200 S CEDAR CREST BLVD/3K 05",
        "CALL:MV InterFac Ground Urgent",
        "ADDR:1600 E HIGH ST",
        "APT:ER",
        "INFO:15 YOM / 160 LBS. IV. MONITOR. CARDIAC ARRYTHMIAS. 2 SYCONPES IN ER 1 HR APART. R BUNDLE BRANCH BLOCK. UNKNOWN DRIPS. / 1200 S CEDAR CREST BLVD / 3K 05");

    doTest("T3",
        "(- part 1 of 1) RC:MV InterFac Ground Urgent/LVH-M/ed/transfer from muhl with no data. never recieved call. was given to crew at hospital./LVH-CC/10",
        "CALL:MV InterFac Ground Urgent",
        "ADDR:LVH-M",
        "APT:ed",
        "INFO:transfer from muhl with no data. never recieved call. was given to crew at hospital. / LVH-CC / 10");

    doTest("T4",
        "(- part 1 of 1) RC:MV InterFac Ground Scheduled/LVH-CC/ER 28/CARDIAC MONITOR. IVs. PT WT 197 LBS. 85/45; 98; 20; 94% RA. TEMP 100.0  PT STABLE. TRANSFER FOR POSSIBLE SEPSIS AND HYPOTENSION./100 N ACADEMY AVE/ROOM 210",
        "CALL:MV InterFac Ground Scheduled",
        "ADDR:LVH-CC",
        "APT:ER 28",
        "INFO:CARDIAC MONITOR. IVs. PT WT 197 LBS. 85 / 45; 98; 20; 94% RA. TEMP 100.0  PT STABLE. TRANSFER FOR POSSIBLE SEPSIS AND HYPOTENSION. / 100 N ACADEMY AVE / ROOM 210");

    doTest("T5",
        "(- part 1 of 1) RC:MV InterFac Ground Urgent/185 ROSEBERRY ST/icu/80 yr old female gi bleed. hemo stable. on a protonix drip/2K MICU SICU/2k09",
        "CALL:MV InterFac Ground Urgent",
        "ADDR:185 ROSEBERRY ST",
        "APT:icu",
        "INFO:80 yr old female gi bleed. hemo stable. on a protonix drip / 2K MICU SICU / 2k09");

    doTest("T6",
        "(- part 1 of 1) RC:MV InterFac Ground Urgent/206 E BROWN ST/ER/17 YR OLD MALE.  OVER DOSE ASA/PICU/JAINDL SECOND FLOOR",
        "CALL:MV InterFac Ground Urgent",
        "ADDR:206 E BROWN ST",
        "APT:ER",
        "INFO:17 YR OLD MALE.  OVER DOSE ASA / PICU / JAINDL SECOND FLOOR");

    doTest("T7",
        "(- part 1 of 1) RC:MV InterFac Ground Urgent/1600 E HIGH ST/502 Bed 1/80 yo female - empyema - b/l chest tubes - no drips - referring facility refusing air request ground SCT ONLY/LVH-M/Regional Heart Bed 359",
        "CALL:MV InterFac Ground Urgent",
        "ADDR:1600 E HIGH ST",
        "APT:502 Bed 1",
        "INFO:80 yo female - empyema - b / l chest tubes - no drips - referring facility refusing air request ground SCT ONLY / LVH-M / Regional Heart Bed 359");

    doTest("T8",
        "(- part 1 of 1) RC:Detail/700 E BROAD ST//PR DETAIL AT HGH//",
        "CALL:Detail",
        "ADDR:700 E BROAD ST",
        "INFO:PR DETAIL AT HGH");

    doTest("T9",
        "(- part 1 of 1) RC:MV InterFac Ground Urgent/250 S 21ST ST/3NW3132/67 YO M SPINAL CORD COMPRESSION - NO LINES - NO DRIPS - DR KUIKLITIS ACCEPTING/LVH-CC/TNICU J210A",
        "CALL:MV InterFac Ground Urgent",
        "ADDR:250 S 21ST ST",
        "APT:3NW3132",
        "INFO:67 YO M SPINAL CORD COMPRESSION - NO LINES - NO DRIPS - DR KUIKLITIS ACCEPTING / LVH-CC / TNICU J210A");

    doTest("T10",
        "(- part 1 of 1) RC:MV InterFac Ground Urgent/135 LAFAYETTE AVE/ED/83 YR FEMALE INTERCRAINAL HEMMORAGE/1200 S CEDAR CREST BLVD/J222B",
        "CALL:MV InterFac Ground Urgent",
        "ADDR:135 LAFAYETTE AVE",
        "APT:ED",
        "INFO:83 YR FEMALE INTERCRAINAL HEMMORAGE / 1200 S CEDAR CREST BLVD / J222B");

    doTest("T11",
        "(- part 1 of 1) RC:MV-InterFac-Ground-Scheduled/4B Pediatrics/4b17a/7 y/f female. New diagnosis of brain mass. no drips/ no lines./3400 CIVIC CENTER BLVD/3E",
        "CALL:MV-InterFac-Ground-Scheduled",
        "ADDR:4B Pediatrics",
        "APT:4b17a",
        "INFO:7 y / f female. New diagnosis of brain mass. no drips / no lines. / 3400 CIVIC CENTER BLVD / 3E");

    doTest("T12",
        "(- part 1 of 1) RC:MV-InterFac-Ground-Urgent/ED Muhl/KOLB SECOND FLOOR/77 Y/O FEMALE/ OCCLED FEM-FEM BYPASS/ ON A HEPARIN DRIP / GOING TO RM 338 @ POCONO/206 E BROWN ST/NULL",
        "CALL:MV-InterFac-Ground-Urgent",
        "ADDR:ED Muhl",
        "APT:KOLB SECOND FLOOR",
        "INFO:77 Y / O FEMALE / OCCLED FEM-FEM BYPASS / ON A HEPARIN DRIP / GOING TO RM 338 @ POCONO / 206 E BROWN ST / NULL");

    doTest("T13",
        "(- part 1 of 1) RC:MV-InterFac-Ground-Urgent/206 E BROWN ST/ED/52 F  ED UNK BED    BRAIN TUMOR   NORMAL VITALS/TNICU/JAINDL SECOND FLOOR J220B/Run# 26435",
        "CALL:MV-InterFac-Ground-Urgent",
        "ADDR:206 E BROWN ST",
        "APT:ED",
        "INFO:52 F  ED UNK BED    BRAIN TUMOR   NORMAL VITALS / TNICU / JAINDL SECOND FLOOR J220B / Run# 26435");

    doTest("T14",
        "(- part 1 of 1) RC:Code Blue/1240/1ST FL INFUSION/",
        "CALL:Code Blue",
        "ADDR:1240",
        "APT:1ST FL INFUSION");

    doTest("T15",
        "(- part 1 of 1) RC:MV-InterFac-Ground-Urgent/135 LAFAYETTE AVE/PALMERTON HOSPITAL/70 Y/O M  S",
        "CALL:MV-InterFac-Ground-Urgent",
        "ADDR:135 LAFAYETTE AVE",
        "APT:PALMERTON HOSPITAL",
        "INFO:70 Y / O M  S");

  }
  
  public static void main(String[] args) {
    new PALehighCountyBParserTest().generateTests("T1");
  }
}