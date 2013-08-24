package net.anei.cadpage.parsers.NM;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*

Dona Ana County, NM
Contact: Active911
Agency name: South Valley Fire
Location: Dona Ana, NM, United States
Sender: access@mvrda.org

(Notification) Seizures/Convulsions | (A)SVFD | SVFD2013-00290 | 1875 ROADRUNNER LN, 88007  (SOUTHWIND RD, BURKE RD/RILLITO DR) |
(Notification) Disturbance Domestic Injury | (A)SVFD | SVFD2013-00289 | 245 CALLE AL RUMBO, 88021  (/CAMINO SIN BUELTA) |
(Notification) Lift Assist | (A)SVFD | SVFD2013-00288 | 4225 BUTTERFLY LN, 88011 |
(Notification) Traffic Accident with Injury | (A)SVFD | SVFD2013-00287 | CARVER RD&amp;N HIGHWAY 28 |
(Notification) Disturbance Domestic Injury | (A)SVFD2 | SVFD2013-00286 | @Summerwinds Mobile Home Park #130    (4801 S MAIN ST) |
(Notification) Fall Victim | (A)SVFD | SVFD2013-00285 | 2605 LA LUZ ST, 88007  (/CIELO CIR) |
(Notification) Abdominal Pain/Injury | (A)SVFD | SVFD2013-00284 | 255 SWANNACK RD, 88072  (FLOWER RD/STERN DR) |
(Notification) Chest Pain | (A)SVFD | SVFD2013-00283 | 845 WATSON LN, 88005  (N HIGHWAY 28/ARGUS ST; Near:WATSON MOBILE HOME PARK) #19 |
(Notification) Traffic Accident Extra Response | (A)SVFD | SVFD2013-00282 | LAS ALTURAS DR&amp;COUNTY ROAD B59 |
(Notification) Standby Fire or EMS | (A)SVFD | SVFD2013-00281 | @SOUTHERN NEW MEXICO FAIRGROUNDS  (12125 ROBERT LARSON BLVD) |
(Notification) Ill Person | (A)SVFD | SVFD2013-00280 | 5600 FIRST ST (A ST/) |
(Notification) Abdominal Pain/Injury | (A)SVFD | SVFD2013-00276 | 15825 FURNACE ST, 88012  (THIRD ST/FOURTH ST) |
(Notification) Ill Person | (A)SVFD | SVFD2013-00275 | 44 PATTY LN, 88072  (/VADO DR) |
(Notification) Ill Person | (A)SVFD | SVFD2013-00270 | 684 RICHARDSON RD, 88005  (SNOW RD/HARVEST MOON PL) |
(Notification) Breathing Problems | (A)SVFD | SVFD2013-00264 | 3901 CALLE DE LAS MARGARITAS, 88005  (DUNLOP RD/WATSON LN; Near:SKOSHI MOBILE HOME PARK) |
(Notification) Traffic Accident Extra Response | (A)SVFD | SVFD2013-00262 | 119 INTERSTATE 10, 88005 |
(Notification) Ill Person | (A)SVFD | SVFD2013-00256 | 610 EAST ORGAN RD, 88005  (BAR B QUE RD/RAGING BULL PL) |
(Notification) BF - Brush/Wildland Fire | (A)SVFD | SVFD2013-00255 | SANTO TOMAS ST&amp;HAWTHORNE ST |
(Notification) Fire Pole/Tree | (A)SVFD2 | SVFD2013-00254 | HIGHWAY 478&amp;HIGHWAY 192 |
(Notification) Welfare Check with EMS | (A)SVFD | SVFD2013-00251 | 145 INTERSTATE 10, 88001  (; Near:I10/I25 SPLIT) |
(Notification) Breathing Problems | (A)SVFD2 | SVFD2013-00250 | 67 WARTHEN RD, 88021  (/LIMON RD) #3 |
(Notification) Bleeding | (A)SVFD | SVFD2013-00248 | 44 PATTY LN, 88072  (/VADO DR) |
(Notification) Chest Pain | (A)SVFD2 | SVFD2013-00249 | @HOLY CROSS RETREAT #1  (600 HOLY CROSS RD) |
(Notification) Bleeding | (A)SVFD | SVFD2013-00248 | 44 PATTY LN, 88072  (/VADO DR) |
(Notification) Gas Leak Natural | (A)SVFD | SVFD2013-00247 | 114 EMERSON AVE, 88048  (BRYANT ST/) |
(Notification) Unconscious Person | (A)SVFD | SVFD2013-00241 | 100 LA FE AVE, 88048  (PLAZA AVE/OJITO AVE) |
(Notification) Seizures/Convulsions | (A)SVFD | SVFD2013-00240 | 4210 N HIGHWAY 28, 88005 |
(Notification) Gas Odor Natural | (A)SVFD | SVFD2013-00239 | 3515 S MAIN ST (CINNABAR LN/HOLLYHOCK AVE) #60 |
(Notification) Cardiac/Respiratory Arrest (Infant) | (A)SVFD | SVFD2013-00228 | 11831 BUFFALO ESTATES RD, 88007  (FORT SELDEN RD/) |
(Notification) Traffic Accident Extra Response | (A)SVFD | SVFD2013-00227 | 15205 LAS ALTURAS DR, 88048  (HIGH VALLEY RD/EL SUSPIRO CT) |

*/

public class NMDonaAnaCountyParserTest extends BaseParserTest {
  
  public NMDonaAnaCountyParserTest() {
    setParser(new NMDonaAnaCountyParser(), "DONA ANA COUNTY", "NM");
  }
  
  @Test
  public void testRunReport() {

    doTest("T1",
        "(Notification) Seizures/Convulsions | (A)SVFD | SVFD2013-00290 | 1875 ROADRUNNER LN, 88007  (SOUTHWIND RD, BURKE RD/RILLITO DR) |",
        "CALL:Seizures/Convulsions",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00290",
        "ADDR:1875 ROADRUNNER LN",
        "CITY:88007",
        "X:SOUTHWIND RD, BURKE RD/RILLITO DR");

    doTest("T2",
        "(Notification) Disturbance Domestic Injury | (A)SVFD | SVFD2013-00289 | 245 CALLE AL RUMBO, 88021  (/CAMINO SIN BUELTA) |",
        "CALL:Disturbance Domestic Injury",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00289",
        "ADDR:245 CALLE AL RUMBO",
        "CITY:88021",
        "X:CAMINO SIN BUELTA");

    doTest("T3",
        "(Notification) Lift Assist | (A)SVFD | SVFD2013-00288 | 4225 BUTTERFLY LN, 88011 |",
        "CALL:Lift Assist",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00288",
        "ADDR:4225 BUTTERFLY LN",
        "CITY:88011");

    doTest("T4",
        "(Notification) Traffic Accident with Injury | (A)SVFD | SVFD2013-00287 | CARVER RD&amp;N HIGHWAY 28 |",
        "CALL:Traffic Accident with Injury",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00287",
        "ADDR:CARVER RD & N HIGHWAY 28");

    doTest("T5",
        "(Notification) Disturbance Domestic Injury | (A)SVFD2 | SVFD2013-00286 | @Summerwinds Mobile Home Park #130    (4801 S MAIN ST) |",
        "CALL:Disturbance Domestic Injury",
        "UNIT:(A)SVFD2",
        "ID:SVFD2013-00286",
        "PLACE:Summerwinds Mobile Home Park #130",
        "ADDR:4801 S MAIN ST");

    doTest("T6",
        "(Notification) Fall Victim | (A)SVFD | SVFD2013-00285 | 2605 LA LUZ ST, 88007  (/CIELO CIR) |",
        "CALL:Fall Victim",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00285",
        "ADDR:2605 LA LUZ ST",
        "MADDR:2605 LN LUZ ST",
        "CITY:88007",
        "X:CIELO CIR");

    doTest("T7",
        "(Notification) Abdominal Pain/Injury | (A)SVFD | SVFD2013-00284 | 255 SWANNACK RD, 88072  (FLOWER RD/STERN DR) |",
        "CALL:Abdominal Pain/Injury",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00284",
        "ADDR:255 SWANNACK RD",
        "CITY:88072",
        "X:FLOWER RD/STERN DR");

    doTest("T8",
        "(Notification) Chest Pain | (A)SVFD | SVFD2013-00283 | 845 WATSON LN, 88005  (N HIGHWAY 28/ARGUS ST; Near:WATSON MOBILE HOME PARK) #19 |",
        "CALL:Chest Pain",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00283",
        "PLACE:Near:WATSON MOBILE HOME PARK",
        "ADDR:845 WATSON LN",
        "APT:19",
        "CITY:88005",
        "X:N HIGHWAY 28/ARGUS ST");

    doTest("T9",
        "(Notification) Traffic Accident Extra Response | (A)SVFD | SVFD2013-00282 | LAS ALTURAS DR&amp;COUNTY ROAD B59 |",
        "CALL:Traffic Accident Extra Response",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00282",
        "ADDR:LAS ALTURAS DR & COUNTY ROAD B59");

    doTest("T10",
        "(Notification) Standby Fire or EMS | (A)SVFD | SVFD2013-00281 | @SOUTHERN NEW MEXICO FAIRGROUNDS  (12125 ROBERT LARSON BLVD) |",
        "CALL:Standby Fire or EMS",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00281",
        "PLACE:SOUTHERN NEW MEXICO FAIRGROUNDS",
        "ADDR:12125 ROBERT LARSON BLVD");

    doTest("T11",
        "(Notification) Ill Person | (A)SVFD | SVFD2013-00280 | 5600 FIRST ST (A ST/) |",
        "CALL:Ill Person",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00280",
        "ADDR:5600 FIRST ST",
        "X:A ST");

    doTest("T12",
        "(Notification) Abdominal Pain/Injury | (A)SVFD | SVFD2013-00276 | 15825 FURNACE ST, 88012  (THIRD ST/FOURTH ST) |",
        "CALL:Abdominal Pain/Injury",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00276",
        "ADDR:15825 FURNACE ST",
        "CITY:88012",
        "X:THIRD ST/FOURTH ST");

    doTest("T13",
        "(Notification) Ill Person | (A)SVFD | SVFD2013-00275 | 44 PATTY LN, 88072  (/VADO DR) |",
        "CALL:Ill Person",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00275",
        "ADDR:44 PATTY LN",
        "CITY:88072",
        "X:VADO DR");

    doTest("T14",
        "(Notification) Ill Person | (A)SVFD | SVFD2013-00270 | 684 RICHARDSON RD, 88005  (SNOW RD/HARVEST MOON PL) |",
        "CALL:Ill Person",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00270",
        "ADDR:684 RICHARDSON RD",
        "CITY:88005",
        "X:SNOW RD/HARVEST MOON PL");

    doTest("T15",
        "(Notification) Breathing Problems | (A)SVFD | SVFD2013-00264 | 3901 CALLE DE LAS MARGARITAS, 88005  (DUNLOP RD/WATSON LN; Near:SKOSHI MOBILE HOME PARK) |",
        "CALL:Breathing Problems",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00264",
        "PLACE:Near:SKOSHI MOBILE HOME PARK",
        "ADDR:3901 CALLE DE LAS MARGARITAS",
        "CITY:88005",
        "X:DUNLOP RD/WATSON LN");

    doTest("T16",
        "(Notification) Traffic Accident Extra Response | (A)SVFD | SVFD2013-00262 | 119 INTERSTATE 10, 88005 |",
        "CALL:Traffic Accident Extra Response",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00262",
        "ADDR:119 INTERSTATE 10",
        "CITY:88005");

    doTest("T17",
        "(Notification) Ill Person | (A)SVFD | SVFD2013-00256 | 610 EAST ORGAN RD, 88005  (BAR B QUE RD/RAGING BULL PL) |",
        "CALL:Ill Person",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00256",
        "ADDR:610 EAST ORGAN RD",
        "CITY:88005",
        "X:BAR B QUE RD/RAGING BULL PL");

    doTest("T18",
        "(Notification) BF - Brush/Wildland Fire | (A)SVFD | SVFD2013-00255 | SANTO TOMAS ST&amp;HAWTHORNE ST |",
        "CALL:BF - Brush/Wildland Fire",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00255",
        "ADDR:SANTO TOMAS ST & HAWTHORNE ST");

    doTest("T19",
        "(Notification) Fire Pole/Tree | (A)SVFD2 | SVFD2013-00254 | HIGHWAY 478&amp;HIGHWAY 192 |",
        "CALL:Fire Pole/Tree",
        "UNIT:(A)SVFD2",
        "ID:SVFD2013-00254",
        "ADDR:HIGHWAY 478 & HIGHWAY 192");

    doTest("T20",
        "(Notification) Welfare Check with EMS | (A)SVFD | SVFD2013-00251 | 145 INTERSTATE 10, 88001  (; Near:I10/I25 SPLIT) |",
        "CALL:Welfare Check with EMS",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00251",
        "PLACE:Near:I10/I25 SPLIT",
        "ADDR:145 INTERSTATE 10",
        "CITY:88001");

    doTest("T21",
        "(Notification) Breathing Problems | (A)SVFD2 | SVFD2013-00250 | 67 WARTHEN RD, 88021  (/LIMON RD) #3 |",
        "CALL:Breathing Problems",
        "UNIT:(A)SVFD2",
        "ID:SVFD2013-00250",
        "ADDR:67 WARTHEN RD",
        "APT:3",
        "CITY:88021",
        "X:LIMON RD");

    doTest("T22",
        "(Notification) Bleeding | (A)SVFD | SVFD2013-00248 | 44 PATTY LN, 88072  (/VADO DR) |",
        "CALL:Bleeding",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00248",
        "ADDR:44 PATTY LN",
        "CITY:88072",
        "X:VADO DR");

    doTest("T23",
        "(Notification) Chest Pain | (A)SVFD2 | SVFD2013-00249 | @HOLY CROSS RETREAT #1  (600 HOLY CROSS RD) |",
        "CALL:Chest Pain",
        "UNIT:(A)SVFD2",
        "ID:SVFD2013-00249",
        "PLACE:HOLY CROSS RETREAT #1",
        "ADDR:600 HOLY CROSS RD");

    doTest("T24",
        "(Notification) Bleeding | (A)SVFD | SVFD2013-00248 | 44 PATTY LN, 88072  (/VADO DR) |",
        "CALL:Bleeding",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00248",
        "ADDR:44 PATTY LN",
        "CITY:88072",
        "X:VADO DR");

    doTest("T25",
        "(Notification) Gas Leak Natural | (A)SVFD | SVFD2013-00247 | 114 EMERSON AVE, 88048  (BRYANT ST/) |",
        "CALL:Gas Leak Natural",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00247",
        "ADDR:114 EMERSON AVE",
        "CITY:88048",
        "X:BRYANT ST");

    doTest("T26",
        "(Notification) Unconscious Person | (A)SVFD | SVFD2013-00241 | 100 LA FE AVE, 88048  (PLAZA AVE/OJITO AVE) |",
        "CALL:Unconscious Person",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00241",
        "ADDR:100 LA FE AVE",
        "MADDR:100 LN FE AVE",
        "CITY:88048",
        "X:PLAZA AVE/OJITO AVE");

    doTest("T27",
        "(Notification) Seizures/Convulsions | (A)SVFD | SVFD2013-00240 | 4210 N HIGHWAY 28, 88005 |",
        "CALL:Seizures/Convulsions",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00240",
        "ADDR:4210 N HIGHWAY 28",
        "CITY:88005");

    doTest("T28",
        "(Notification) Gas Odor Natural | (A)SVFD | SVFD2013-00239 | 3515 S MAIN ST (CINNABAR LN/HOLLYHOCK AVE) #60 |",
        "CALL:Gas Odor Natural",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00239",
        "ADDR:3515 S MAIN ST",
        "APT:60",
        "X:CINNABAR LN/HOLLYHOCK AVE");

    doTest("T29",
        "(Notification) Cardiac/Respiratory Arrest (Infant) | (A)SVFD | SVFD2013-00228 | 11831 BUFFALO ESTATES RD, 88007  (FORT SELDEN RD/) |",
        "CALL:Cardiac/Respiratory Arrest (Infant)",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00228",
        "ADDR:11831 BUFFALO ESTATES RD",
        "CITY:88007",
        "X:FORT SELDEN RD");

    doTest("T30",
        "(Notification) Traffic Accident Extra Response | (A)SVFD | SVFD2013-00227 | 15205 LAS ALTURAS DR, 88048  (HIGH VALLEY RD/EL SUSPIRO CT) |",
        "CALL:Traffic Accident Extra Response",
        "UNIT:(A)SVFD",
        "ID:SVFD2013-00227",
        "ADDR:15205 LAS ALTURAS DR",
        "CITY:88048",
        "X:HIGH VALLEY RD/EL SUSPIRO CT");
  }
  
  public static void main(String[] args) {
    new NMDonaAnaCountyParserTest().generateTests("T1");
  }
}