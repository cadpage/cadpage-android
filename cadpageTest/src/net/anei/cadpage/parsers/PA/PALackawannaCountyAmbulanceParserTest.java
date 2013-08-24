package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Lackawanna County, PA (alternate - Lackawanna Ambulance)
Contact: Pat Gillott <pgill107@gmail.com>
Sender: lead@ladisp.us

06:34AM Sat 04/28 INC#:1219146-1 FROM:320 EMMETT ST, SCRANTON CITY RM:16D  TYPE:CHEST PAIN  to:
01:03PM Thu 05/03 INC#:1219963-1 FROM:345 PHELPS ST, SCRANTON CITY  TYPE:EMERGENT EVAL  to:
11:16AM Thu 05/03 INC#:1219939-1 FROM:1435 N WASHINGTON AVE, SCRANTON CITY RM:Kwik mart  TYPE:EMERGENT EVAL  to:
10:06AM Thu 05/03 INC#:1219924-1 FROM:APT - LUTHERWOOD- 1 LAKE SCR RD RM:211  TYPE:PUBLIC ASSIST  to:
08:14AM Thu 05/03 INC#:1219854-1 FROM:EVERGREEN H.C.C. - formerly MTH Skilled RM:7  TYPE:DR APPOINTMENT PT:Barbara Martin  to: DELTA MEDIX -
06:23AM Thu 05/03 INC#:1219903-1 FROM:1020 MULBERRY ST, SCRANTON CITY RM:Nelvelle Hall Rm 107  TYPE:UNKNOWN  to:

*** No idea what this is **
00 Meade St, Dunmore  1000 MEADE ST, DUNMORE, PA  MODE:BLS  PU: 0915 (02/02)

 */

public class PALackawannaCountyAmbulanceParserTest extends BaseParserTest {
  
  public PALackawannaCountyAmbulanceParserTest() {
    setParser(new PALackawannaCountyAmbulanceParser(), "LACKAWANNA COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "06:34AM Sat 04/28 INC#:1219146-1 FROM:320 EMMETT ST, SCRANTON CITY RM:16D  TYPE:CHEST PAIN  to:",
        "DATE:04/28",
        "TIME:06:34:00",
        "ID:1219146-1",
        "ADDR:320 EMMETT ST",
        "APT:16D",
        "CITY:SCRANTON CITY",
        "CALL:CHEST PAIN");

    doTest("T2",
        "01:03PM Thu 05/03 INC#:1219963-1 FROM:345 PHELPS ST, SCRANTON CITY  TYPE:EMERGENT EVAL  to:",
        "DATE:05/03",
        "TIME:13:03:00",
        "ID:1219963-1",
        "ADDR:345 PHELPS ST",
        "CITY:SCRANTON CITY",
        "CALL:EMERGENT EVAL");

    doTest("T3",
        "11:16AM Thu 05/03 INC#:1219939-1 FROM:1435 N WASHINGTON AVE, SCRANTON CITY RM:Kwik mart  TYPE:EMERGENT EVAL  to:",
        "DATE:05/03",
        "TIME:11:16:00",
        "ID:1219939-1",
        "ADDR:1435 N WASHINGTON AVE",
        "APT:Kwik mart",
        "CITY:SCRANTON CITY",
        "CALL:EMERGENT EVAL");

    doTest("T4",
        "10:06AM Thu 05/03 INC#:1219924-1 FROM:APT - LUTHERWOOD- 1 LAKE SCR RD RM:211  TYPE:PUBLIC ASSIST  to:",
        "DATE:05/03",
        "TIME:10:06:00",
        "ID:1219924-1",
        "APT:- LUTHERWOOD- 1 LAKE SCR RD-211",
        "CALL:PUBLIC ASSIST");

    doTest("T5",
        "08:14AM Thu 05/03 INC#:1219854-1 FROM:EVERGREEN H.C.C. - formerly MTH Skilled RM:7  TYPE:DR APPOINTMENT PT:Barbara Martin  to: DELTA MEDIX -",
        "DATE:05/03",
        "TIME:08:14:00",
        "ID:1219854-1",
        "ADDR:EVERGREEN HCC - formerly MTH Skilled",
        "APT:7",
        "CALL:DR APPOINTMENT PT:Barbara Martin",
        "INFO:DELTA MEDIX -");

    doTest("T6",
        "06:23AM Thu 05/03 INC#:1219903-1 FROM:1020 MULBERRY ST, SCRANTON CITY RM:Nelvelle Hall Rm 107  TYPE:UNKNOWN  to:",
        "DATE:05/03",
        "TIME:06:23:00",
        "ID:1219903-1",
        "ADDR:1020 MULBERRY ST",
        "APT:Nelvelle Hall Rm 107",
        "CITY:SCRANTON CITY",
        "CALL:UNKNOWN");
  }
  
  public static void main(String args[]) {
    new PALackawannaCountyAmbulanceParserTest().generateTests("T1");
  }
}