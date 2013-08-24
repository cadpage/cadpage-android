package net.anei.cadpage.parsers.SD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Minnehaha county, SD
Contact: brubin@med-starambulance.com
Contact: James Dietz <kc0usq@gmail.com>
Sender: 911metrodispatch@911metro.org

930 Quad 2070 - VS 100 CLIFF AVE 2 VS Unconsc/Faint C3 2011-00000870
930 Quad 460 - BR 904 SNOWBERRY AVE BR Conv Seizure C3 2011-00000374
930 Quad 2060 - VS I 90 MM 410 VS Sick Person C1 2011-00000028
930 Quad 2060 - VS 26472 484TH AVE VS Diabetic C2 2011-00000003
930 Quad 2010 - SR 26525 482ND AVE BR Medical Emergency 2011-00000621
930 Quad 460 - BR 3008 E ASPEN BLVD BR Falls C1 2011-00000051
930 Quad 460 - BR 1625 RUSHMORE DR BR Family Dispute 2011-00000347 

Contact: Dusty Kiner <dusty.kiner@gmail.com>
(Dispatch Page) BR  Quad 460 - BR 1413 RUSHMORE DR 12 BR Falls C1 2011-00000111

Contact: Craig Beaubien <sdiver1973@gmail.com>
(Dispatch Page) Quad 800 - HD N WESTERN AVE OAKS DR HD Injury Accident C3 2011-00000163

Contact: Joe Zweifel <jlzweifel@yahoo.com>
(Dispatch Page) DR EM  Quad 660 - DR I 29 MM 98DR Inj Accident C1 + Fire 2011-00000192
(Dispatch Page) CO LY HD EM  Quad 550 - CO 46166 250TH ST CO Structure Fire 2011-00000091
(Dispatch Page) HU HD EM  Quad 940 - HU I 90 MM 382HU Structure Fire 2011-00000085
(Dispatch Page) BR EM  Quad 450 - BR 261ST ST 484TH AVE VS Injury Accident / Rollover 2011-00000466

Contact: brubin <brubin@med-starambulance.com>
Sender: 911metrodispatch@911metro.org
(Dispatch Page) 930  Brandon-1 1100 TEAKWOOD ST 7 BR Chest Pain C3 2013-00001061

Contact: Active911
Agency name: Dell Rapids Ambulance
Location: Dell Rapids, SD, United States
Sender: 911metrodispatch@911metro.org

(Dispatch Page) 951  Quad 690 - DR 909 IOWA AVE DELL RAPIDS HOSPITALDR Transfer / Interfacility 2013-00000091
(Dispatch Page)  Dell Rapids 7 I 29 MM 100Injury Accident / Rollover 2013-00004061
(Dispatch Page)  Quad 660 - DR I 29 MM 99DR Injury Accident / Rollover 2013-00004061
(Dispatch Page) 951  Dell Rapids 7 I 29 MM 100 Injury Accident / Rollover 2013-00004061
(Dispatch Page) 951  Quad 690 - DR 909 N IOWA AVE DR Transfer / Interfacility 2013-00000128
(Dispatch Page) 951  Quad 360 - BA 248TH ST 475TH AVE DR Injury Accident C1 2013-00000034
(Dispatch Page) 951  Quad 690 - DR 909 N IOWA AVE DR Transfer / Interfacility 2013-00000087
(Dispatch Page) DR 951  Quad 690 - DR 200 W  10TH ST 205 DR Transfer / Interfacility 2013-00000086
(Dispatch Page) 951  Quad 980 - LY 46875 252ND ST BA Traumatic Injury C1 2013-00000003
(Dispatch Page) 951  Quad 680 - DR 24631 470TH AVE DR Structure Fire 2013-00000083
(Dispatch Page) 951  Quad 400 - BA 47376 256TH ST RE Abdominal Pain C3 2013-00000032
(Dispatch Page) 951  Quad 690 - DR 1025 CLUBHOUSE CT DR New Call 2013-00000120
(Dispatch Page) 951  Quad 690 - DR 105 E  5TH ST DR Falls C1 2013-00000077
(Dispatch Page) 951  Quad 690 - DR 200 W  10TH ST DR Chest Pain C3 2013-00000070
(Dispatch Page) 951  Quad 690 - DR 909 N IOWA AVE DR Transfer / Interfacility 2013-00000117
(Dispatch Page) 951  Quad 690 - DR 718 E  4TH ST DR Injury Accident C3 2013-00000069
(Dispatch Page) 951  Quad 690 - DR 310 W 10TH ST 1 DR Sick Person C3 2013-00000068
(Dispatch Page) 951  Quad 690 - DR 111 E  10TH ST DR Transfer / Interfacility 2013-00000114
(Dispatch Page)  Quad 690 - DR 909 IOWA AVE DELL RAPIDS HOSPITALDR Transfer / Interfacility 2013-00000113
(Dispatch Page) 951  Quad 690 - DR 313 S  GARFIELD AVE DR New Call 2013-00000113

*/

public class SDMinnehahaCountyParserTest extends BaseParserTest {
  
  public SDMinnehahaCountyParserTest() {
    setParser(new SDMinnehahaCountyParser(), "MINNEHAHA COUNTY", "SD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "930 Quad 2070 - VS 100 CLIFF AVE 2 VS Unconsc/Faint C3 2011-00000870",
        "SRC:930",
        "MAP:Quad 2070",
        "ADDR:100 CLIFF AVE",
        "APT:2",
        "CITY:VALLEY SPRINGS",
        "CALL:Unconsc/Faint",
        "CODE:C3",
        "ID:2011-00000870");

    doTest("T2",
        "930 Quad 460 - BR 904 SNOWBERRY AVE BR Conv Seizure C3 2011-00000374",
        "SRC:930",
        "MAP:Quad 460",
        "ADDR:904 SNOWBERRY AVE",
        "CITY:BRANDON",
        "CALL:Conv Seizure",
        "CODE:C3",
        "ID:2011-00000374");

    doTest("T3",
        "930 Quad 2060 - VS I 90 MM 410 VS Sick Person C1 2011-00000028",
        "SRC:930",
        "MAP:Quad 2060",
        "ADDR:I 90 MM 410",
        "CITY:VALLEY SPRINGS",
        "CALL:Sick Person",
        "CODE:C1",
        "ID:2011-00000028");

    doTest("T4",
        "930 Quad 2060 - VS 26472 484TH AVE VS Diabetic C2 2011-00000003",
        "SRC:930",
        "MAP:Quad 2060",
        "ADDR:26472 484TH AVE",
        "CITY:VALLEY SPRINGS",
        "CALL:Diabetic",
        "CODE:C2",
        "ID:2011-00000003");

    doTest("T5",
        "930 Quad 2010 - SR 26525 482ND AVE BR Medical Emergency 2011-00000621",
        "SRC:930",
        "MAP:Quad 2010",
        "ADDR:26525 482ND AVE",
        "CITY:BRANDON",
        "CALL:Medical Emergency",
        "ID:2011-00000621");

    doTest("T6",
        "930 Quad 460 - BR 3008 E ASPEN BLVD BR Falls C1 2011-00000051",
        "SRC:930",
        "MAP:Quad 460",
        "ADDR:3008 E ASPEN BLVD",
        "CITY:BRANDON",
        "CALL:Falls",
        "CODE:C1",
        "ID:2011-00000051");

    doTest("T7",
        "930 Quad 460 - BR 1625 RUSHMORE DR BR Family Dispute 2011-00000347",
        "SRC:930",
        "MAP:Quad 460",
        "ADDR:1625 RUSHMORE DR",
        "CITY:BRANDON",
        "CALL:Family Dispute",
        "ID:2011-00000347");

    doTest("T8",
        "(Dispatch Page) BR  Quad 460 - BR 1413 RUSHMORE DR 12 BR Falls C1 2011-00000111",
        "UNIT:BR",
        "MAP:Quad 460",
        "ADDR:1413 RUSHMORE DR",
        "APT:12",
        "CITY:BRANDON",
        "CALL:Falls",
        "CODE:C1",
        "ID:2011-00000111");

    doTest("T9",
        "(Dispatch Page) Quad 800 - HD N WESTERN AVE OAKS DR HD Injury Accident C3 2011-00000163",
        "MAP:Quad 800",
        "ADDR:N WESTERN AVE & OAKS DR",
        "CALL:Injury Accident",
        "CODE:C3",
        "ID:2011-00000163");

    doTest("T10",
        "(Dispatch Page) DR EM  Quad 660 - DR I 29 MM 98DR Inj Accident C1 + Fire 2011-00000192",
        "UNIT:DR EM",
        "MAP:Quad 660",
        "ADDR:I 29 MM 98",
        "CITY:DELL RAPIDS",
        "CALL:Inj Accident C1 + Fire",
        "ID:2011-00000192");

    doTest("T11",
        "(Dispatch Page) CO LY HD EM  Quad 550 - CO 46166 250TH ST CO Structure Fire 2011-00000091",
        "UNIT:CO LY HD EM",
        "MAP:Quad 550",
        "ADDR:46166 250TH ST",
        "CITY:COLTON",
        "CALL:Structure Fire",
        "ID:2011-00000091");

    doTest("T12",
        "(Dispatch Page) HU HD EM  Quad 940 - HU I 90 MM 382HU Structure Fire 2011-00000085",
        "UNIT:HU HD EM",
        "MAP:Quad 940",
        "ADDR:I 90 MM 382",
        "CITY:HUMBOLT",
        "CALL:Structure Fire",
        "ID:2011-00000085");

    doTest("T13",
        "(Dispatch Page) BR EM  Quad 450 - BR 261ST ST 484TH AVE VS Injury Accident / Rollover 2011-00000466",
        "UNIT:BR EM",
        "MAP:Quad 450",
        "ADDR:261ST ST & 484TH AVE",
        "CITY:VALLEY SPRINGS",
        "CALL:Injury Accident / Rollover",
        "ID:2011-00000466");
  }
  
  @Test
  public void testBrubin() {

    doTest("T1",
        "(Dispatch Page) 930  Brandon-1 1100 TEAKWOOD ST 7 BR Chest Pain C3 2013-00001061",
        "SRC:930",
        "MAP:Brandon-1",
        "ADDR:1100 TEAKWOOD ST",
        "APT:7",
        "CITY:BRANDON",
        "CALL:Chest Pain",
        "CODE:C3",
        "ID:2013-00001061");
  
  }
  
  @Test
  public void testDellRapids() {

    doTest("T1",
        "(Dispatch Page) 951  Quad 690 - DR 909 IOWA AVE DELL RAPIDS HOSPITALDR Transfer / Interfacility 2013-00000091",
        "SRC:951",
        "MAP:Quad 690",
        "ADDR:909 IOWA AVE",
        "CALL:DELL RAPIDS HOSPITALDR Transfer / Interfacility",
        "ID:2013-00000091");

    doTest("T2",
        "(Dispatch Page)  Dell Rapids 7 I 29 MM 100Injury Accident / Rollover 2013-00004061",
        "MAP:Dell Rapids 7",
        "ADDR:I 29 MM 100",
        "CALL:Injury Accident / Rollover",
        "ID:2013-00004061");

    doTest("T3",
        "(Dispatch Page)  Quad 660 - DR I 29 MM 99DR Injury Accident / Rollover 2013-00004061",
        "MAP:Quad 660",
        "ADDR:I 29 MM 99",
        "CITY:DELL RAPIDS",
        "CALL:Injury Accident / Rollover",
        "ID:2013-00004061");

    doTest("T4",
        "(Dispatch Page) 951  Dell Rapids 7 I 29 MM 100 Injury Accident / Rollover 2013-00004061",
        "SRC:951",
        "MAP:Dell Rapids 7",
        "ADDR:I 29 MM 100",
        "CALL:Injury Accident / Rollover",
        "ID:2013-00004061");

    doTest("T5",
        "(Dispatch Page) 951  Quad 690 - DR 909 N IOWA AVE DR Transfer / Interfacility 2013-00000128",
        "SRC:951",
        "MAP:Quad 690",
        "ADDR:909 N IOWA AVE",
        "CITY:DELL RAPIDS",
        "CALL:Transfer / Interfacility",
        "ID:2013-00000128");

    doTest("T6",
        "(Dispatch Page) 951  Quad 360 - BA 248TH ST 475TH AVE DR Injury Accident C1 2013-00000034",
        "SRC:951",
        "MAP:Quad 360",
        "ADDR:248TH ST & 475TH AVE",
        "CITY:DELL RAPIDS",
        "CALL:Injury Accident",
        "CODE:C1",
        "ID:2013-00000034");

    doTest("T7",
        "(Dispatch Page) 951  Quad 690 - DR 909 N IOWA AVE DR Transfer / Interfacility 2013-00000087",
        "SRC:951",
        "MAP:Quad 690",
        "ADDR:909 N IOWA AVE",
        "CITY:DELL RAPIDS",
        "CALL:Transfer / Interfacility",
        "ID:2013-00000087");

    doTest("T8",
        "(Dispatch Page) DR 951  Quad 690 - DR 200 W  10TH ST 205 DR Transfer / Interfacility 2013-00000086",
        "SRC:951",
        "UNIT:DR",
        "MAP:Quad 690",
        "ADDR:200 W 10TH ST",
        "APT:205",
        "CITY:DELL RAPIDS",
        "CALL:Transfer / Interfacility",
        "ID:2013-00000086");

    doTest("T9",
        "(Dispatch Page) 951  Quad 980 - LY 46875 252ND ST BA Traumatic Injury C1 2013-00000003",
        "SRC:951",
        "MAP:Quad 980",
        "ADDR:46875 252ND ST",
        "CITY:BALTIC",
        "CALL:Traumatic Injury",
        "CODE:C1",
        "ID:2013-00000003");

    doTest("T10",
        "(Dispatch Page) 951  Quad 680 - DR 24631 470TH AVE DR Structure Fire 2013-00000083",
        "SRC:951",
        "MAP:Quad 680",
        "ADDR:24631 470TH AVE",
        "CITY:DELL RAPIDS",
        "CALL:Structure Fire",
        "ID:2013-00000083");

    doTest("T11",
        "(Dispatch Page) 951  Quad 400 - BA 47376 256TH ST RE Abdominal Pain C3 2013-00000032",
        "SRC:951",
        "MAP:Quad 400",
        "ADDR:47376 256TH ST",
        "CITY:RENNER",
        "CALL:Abdominal Pain",
        "CODE:C3",
        "ID:2013-00000032");

    doTest("T12",
        "(Dispatch Page) 951  Quad 690 - DR 1025 CLUBHOUSE CT DR New Call 2013-00000120",
        "SRC:951",
        "MAP:Quad 690",
        "ADDR:1025 CLUBHOUSE CT",
        "CITY:DELL RAPIDS",
        "CALL:New Call",
        "ID:2013-00000120");

    doTest("T13",
        "(Dispatch Page) 951  Quad 690 - DR 105 E  5TH ST DR Falls C1 2013-00000077",
        "SRC:951",
        "MAP:Quad 690",
        "ADDR:105 E 5TH ST",
        "CITY:DELL RAPIDS",
        "CALL:Falls",
        "CODE:C1",
        "ID:2013-00000077");

    doTest("T14",
        "(Dispatch Page) 951  Quad 690 - DR 200 W  10TH ST DR Chest Pain C3 2013-00000070",
        "SRC:951",
        "MAP:Quad 690",
        "ADDR:200 W 10TH ST",
        "CITY:DELL RAPIDS",
        "CALL:Chest Pain",
        "CODE:C3",
        "ID:2013-00000070");

    doTest("T15",
        "(Dispatch Page) 951  Quad 690 - DR 909 N IOWA AVE DR Transfer / Interfacility 2013-00000117",
        "SRC:951",
        "MAP:Quad 690",
        "ADDR:909 N IOWA AVE",
        "CITY:DELL RAPIDS",
        "CALL:Transfer / Interfacility",
        "ID:2013-00000117");

    doTest("T16",
        "(Dispatch Page) 951  Quad 690 - DR 718 E  4TH ST DR Injury Accident C3 2013-00000069",
        "SRC:951",
        "MAP:Quad 690",
        "ADDR:718 E 4TH ST",
        "CITY:DELL RAPIDS",
        "CALL:Injury Accident",
        "CODE:C3",
        "ID:2013-00000069");

    doTest("T17",
        "(Dispatch Page) 951  Quad 690 - DR 310 W 10TH ST 1 DR Sick Person C3 2013-00000068",
        "SRC:951",
        "MAP:Quad 690",
        "ADDR:310 W 10TH ST",
        "APT:1",
        "CITY:DELL RAPIDS",
        "CALL:Sick Person",
        "CODE:C3",
        "ID:2013-00000068");

    doTest("T18",
        "(Dispatch Page) 951  Quad 690 - DR 111 E  10TH ST DR Transfer / Interfacility 2013-00000114",
        "SRC:951",
        "MAP:Quad 690",
        "ADDR:111 E 10TH ST",
        "CITY:DELL RAPIDS",
        "CALL:Transfer / Interfacility",
        "ID:2013-00000114");

    doTest("T19",
        "(Dispatch Page)  Quad 690 - DR 909 IOWA AVE DELL RAPIDS HOSPITALDR Transfer / Interfacility 2013-00000113",
        "MAP:Quad 690",
        "ADDR:909 IOWA AVE",
        "CALL:DELL RAPIDS HOSPITALDR Transfer / Interfacility",
        "ID:2013-00000113");

    doTest("T20",
        "(Dispatch Page) 951  Quad 690 - DR 313 S  GARFIELD AVE DR New Call 2013-00000113",
        "SRC:951",
        "MAP:Quad 690",
        "ADDR:313 S GARFIELD AVE",
        "CITY:DELL RAPIDS",
        "CALL:New Call",
        "ID:2013-00000113");

  }
  
  public static void main(String[] args) {
    new SDMinnehahaCountyParserTest().generateTests("T1");
  }
}