package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Oxford, OH
Contact: Greg Yingling <gyingling@cityofoxford.org>
Sender: cisco@cityofoxford.org

Ct:MED:ENTRAPMENT  Loc:11 S POPLAR ST               Apt:      XSt:HIGH ST WALNUT ST               Grid:1604 Units:NO19                                      Rmk:
Ct:FD: FIRE ALARM  Loc:5201 COLLEGE CORNER PKe      Apt:219   XSt:                                Grid:4300 Units:M11                                       Rmk:
Ct:MED:EMERGENCY   Loc:CHESTNUT ST/MAIN ST          Apt:      XSt:                                Grid:3116 Units:E11   M11                                 Rmk:
Ct:PD: INJ CRASH   Loc:CHURCH ST/COLLEGE AV         Apt:      XSt:                                Grid:2535 Units:LO49  LO57                                Rmk:
Ct:FD: OTHER       Loc:5980 WILMINGTON PIKE         Apt:      XSt:CLYO RD         WILMINGTON PIKE Grid:6590 Units:C10                                       Rmk:

Contact:Active911
Agency name: City of Oxford Station 11
Location: Oxford, OH, United States
Sender: cisco@cityofoxford.or

(FD: FIRE ALARM) Loc:5151 MORNING SUN RD XSt:SYCAMORE ST KELLY DR Grid:2300 Units: Rmk:FIRE WATER FLOW/\r\n\r\n
(MED:TRANSPORT) Loc:700 MAPLE ST Apt:132 XSt:CENTER DR HARRIS DR Grid:7285 Units:M11 Rmk:INTOX FEMALE/INCOHERENT/VOMITING\r\n\r\n
(MED:OTHER) Loc:5265 COLLEGE CORNER PKE Apt:11 XSt:HESTER RD MELANEE LN Grid:4400 Units:S13 Rmk:34 YO FEMALE/HEART MONITOR/GOING OFF/AORTIS DENOSIS/\r\n\r\n
(MED:TRANSPORT) Loc:400 MAPLE ST XSt:SPRING ST CENTER DR Grid:7312 Units:M12 Rmk:HALLWAY OUTSIDE ROOM 104 /INTOX FEMALE\r\n\r\n
(MED:INJUR CRASH) Loc:SPRING ST/COLLEGE AV Grid:3029 Units:E11 M11 Rmk:Call Initiated by Unit: SO32\r\n\r\n
(FD: FIRE ALARM) Loc:11 W CHURCH ST XSt:MAIN ST BEECH ST Grid:1305 Units: Rmk:FIRE AREA 0\r\n\r\n
(MED:OTHER) Loc:101 W HIGH ST XSt:BEECH ST COLLEGE AV Grid:1102 Units:LO40 Rmk:FEMALE LIGHT HEADED ON THE FLOOR\r\n\r\n
(MED:OTHER) Loc:122 HOMESTEAD AV XSt:POPLAR ST CAMPUS AV Grid:2401 Units:M11 Rmk:INTOX MALE/\r\n\r\n

***/

public class OHOxfordParserTest extends BaseParserTest {
  
  public OHOxfordParserTest() {
    setParser(new OHOxfordParser(), "OXFORD", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Ct:MED:ENTRAPMENT  Loc:11 S POPLAR ST               Apt:      XSt:HIGH ST WALNUT ST               Grid:1604 Units:NO19                                      Rmk:",
        "CALL:MED:ENTRAPMENT",
        "ADDR:11 S POPLAR ST",
        "X:HIGH ST WALNUT ST",
        "MAP:1604",
        "UNIT:NO19");

    doTest("T2",
        "Ct:FD: FIRE ALARM  Loc:5201 COLLEGE CORNER PKe      Apt:219   XSt:                                Grid:4300 Units:M11                                       Rmk:",
        "CALL:FD: FIRE ALARM",
        "ADDR:5201 COLLEGE CORNER PKe",
        "MADDR:5201 COLLEGE CORNER PIke",
        "APT:219",
        "MAP:4300",
        "UNIT:M11");

    doTest("T3",
        "Ct:MED:EMERGENCY   Loc:CHESTNUT ST/MAIN ST          Apt:      XSt:                                Grid:3116 Units:E11   M11                                 Rmk:",
        "CALL:MED:EMERGENCY",
        "ADDR:CHESTNUT ST & MAIN ST",
        "MAP:3116",
        "UNIT:E11 M11");

    doTest("T4",
        "Ct:PD: INJ CRASH   Loc:CHURCH ST/COLLEGE AV         Apt:      XSt:                                Grid:2535 Units:LO49  LO57                                Rmk:",
        "CALL:PD: INJ CRASH",
        "ADDR:CHURCH ST & COLLEGE AV",
        "MADDR:CHURCH ST & COLLEGE AVE",
        "MAP:2535",
        "UNIT:LO49 LO57");

    doTest("T5",
        "Ct:FD: OTHER       Loc:5980 WILMINGTON PIKE         Apt:      XSt:CLYO RD         WILMINGTON PIKE Grid:6590 Units:C10                                       Rmk:",
        "CALL:FD: OTHER",
        "ADDR:5980 WILMINGTON PIKE",
        "X:CLYO RD & WILMINGTON PIKE",
        "MAP:6590",
        "UNIT:C10");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(FD: FIRE ALARM) Loc:5151 MORNING SUN RD XSt:SYCAMORE ST KELLY DR Grid:2300 Units: Rmk:FIRE WATER FLOW/\r\n\r\n",
        "CALL:FD: FIRE ALARM",
        "ADDR:5151 MORNING SUN RD",
        "X:SYCAMORE ST KELLY DR",
        "MAP:2300",
        "INFO:FIRE WATER FLOW/");

    doTest("T2",
        "(MED:TRANSPORT) Loc:700 MAPLE ST Apt:132 XSt:CENTER DR HARRIS DR Grid:7285 Units:M11 Rmk:INTOX FEMALE/INCOHERENT/VOMITING\r\n\r\n",
        "CALL:MED:TRANSPORT",
        "ADDR:700 MAPLE ST",
        "APT:132",
        "X:CENTER DR HARRIS DR",
        "MAP:7285",
        "UNIT:M11",
        "INFO:INTOX FEMALE/INCOHERENT/VOMITING");

    doTest("T3",
        "(MED:OTHER) Loc:5265 COLLEGE CORNER PKE Apt:11 XSt:HESTER RD MELANEE LN Grid:4400 Units:S13 Rmk:34 YO FEMALE/HEART MONITOR/GOING OFF/AORTIS DENOSIS/\r\n" +
        "\r\n",

        "CALL:MED:OTHER",
        "ADDR:5265 COLLEGE CORNER PKE",
        "MADDR:5265 COLLEGE CORNER PIKE",
        "APT:11",
        "X:HESTER RD MELANEE LN",
        "MAP:4400",
        "UNIT:S13",
        "INFO:34 YO FEMALE/HEART MONITOR/GOING OFF/AORTIS DENOSIS/");

    doTest("T4",
        "(MED:TRANSPORT) Loc:400 MAPLE ST XSt:SPRING ST CENTER DR Grid:7312 Units:M12 Rmk:HALLWAY OUTSIDE ROOM 104 /INTOX FEMALE\r\n\r\n",
        "CALL:MED:TRANSPORT",
        "ADDR:400 MAPLE ST",
        "X:SPRING ST CENTER DR",
        "MAP:7312",
        "UNIT:M12",
        "INFO:HALLWAY OUTSIDE ROOM 104 /INTOX FEMALE");

    doTest("T5",
        "(MED:INJUR CRASH) Loc:SPRING ST/COLLEGE AV Grid:3029 Units:E11 M11 Rmk:Call Initiated by Unit: SO32\r\n\r\n",
        "CALL:MED:INJUR CRASH",
        "ADDR:SPRING ST & COLLEGE AV",
        "MADDR:SPRING ST & COLLEGE AVE",
        "MAP:3029",
        "UNIT:E11 M11",
        "INFO:Call Initiated by Unit: SO32");

    doTest("T6",
        "(FD: FIRE ALARM) Loc:11 W CHURCH ST XSt:MAIN ST BEECH ST Grid:1305 Units: Rmk:FIRE AREA 0\r\n\r\n",
        "CALL:FD: FIRE ALARM",
        "ADDR:11 W CHURCH ST",
        "X:MAIN ST BEECH ST",
        "MAP:1305",
        "INFO:FIRE AREA 0");

    doTest("T7",
        "(MED:OTHER) Loc:101 W HIGH ST XSt:BEECH ST COLLEGE AV Grid:1102 Units:LO40 Rmk:FEMALE LIGHT HEADED ON THE FLOOR\r\n\r\n",
        "CALL:MED:OTHER",
        "ADDR:101 W HIGH ST",
        "X:BEECH ST COLLEGE AV",
        "MAP:1102",
        "UNIT:LO40",
        "INFO:FEMALE LIGHT HEADED ON THE FLOOR");

    doTest("T8",
        "(MED:OTHER) Loc:122 HOMESTEAD AV XSt:POPLAR ST CAMPUS AV Grid:2401 Units:M11 Rmk:INTOX MALE/\r\n\r\n",
        "CALL:MED:OTHER",
        "ADDR:122 HOMESTEAD AV",
        "MADDR:122 HOMESTEAD AVE",
        "X:POPLAR ST CAMPUS AV",
        "MAP:2401",
        "UNIT:M11",
        "INFO:INTOX MALE/");
        
  }
  
  public static void main(String[] args) {
    new OHOxfordParserTest().generateTests("T1");
  }
}
