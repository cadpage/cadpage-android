package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Chester County, PA (Variant D3)
Contact: Bob Gliem <goshenfire@gmail.com>
Sender: gfc@goshenfireco.org

(1566 VASSAR CT ,53) 56  10/21/11  15:37  APLNC  APPLIANCE FIRE *  1566 VASSAR CT ,53  -  EGOSHN  HERSHEYS MILL V
(1515 MANLEY RD ,53) 54  10/26/11  09:45  APT  APARTMENT BUILDING FIRE *  1515 MANLEY RD ,53  BUILDING 5, APT 433-OXFORD GAT    EGOSHN
(992 GARRETT MILL RD ,54) 54  10/24/11  15:45  ALARMF  ALARM - FIRE *  992 GARRETT MILL RD ,54  HITSCHLER RES#610-578-0346-    WILLIS
(1006 ROBIN DR ,67) 54  10/24/11  10:40  ALARMF  ALARM - FIRE *  1006 ROBIN DR ,67  GILBERT RES - 610.399.1788-    WESTWN
(1201 E STRASBURG RD ,52) 54  10/21/11  21:11  FUEL  FUEL SPILL *  1201 E STRASBURG RD ,52  FRONT P/LOT-STRASBURG COURT AP  WGOSHN
(980 HERSHEY MILL RD ,53) 56  10/26/11  18:56  ALARMF  ALARM - FIRE *  980 HERSHEY MILL RD ,53  LEWIS RES/610-644-8389-    EGOSHN

 */

public class PAChesterCountyD3ParserTest extends BaseParserTest {
  
  public PAChesterCountyD3ParserTest() {
    setParser(new PAChesterCountyD3Parser(), "CHESTER COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(1566 VASSAR CT ,53) 56  10/21/11  15:37  APLNC  APPLIANCE FIRE *  1566 VASSAR CT ,53  -  EGOSHN  HERSHEYS MILL V",
        "DATE:10/21/11",
        "TIME:15:37",
        "CODE:APLNC",
        "CALL:APPLIANCE FIRE",
        "ADDR:1566 VASSAR CT",
        "CITY:EAST GOSHEN TWP",
        "INFO:HERSHEYS MILL V");

    doTest("T2",
        "(1515 MANLEY RD ,53) 54  10/26/11  09:45  APT  APARTMENT BUILDING FIRE *  1515 MANLEY RD ,53  BUILDING 5, APT 433-OXFORD GAT    EGOSHN",
        "DATE:10/26/11",
        "TIME:09:45",
        "CODE:APT",
        "CALL:APARTMENT BUILDING FIRE",
        "ADDR:1515 MANLEY RD",
        "CITY:EAST GOSHEN TWP",
        "INFO:BUILDING 5, APT 433-OXFORD GAT");

    doTest("T3",
        "(992 GARRETT MILL RD ,54) 54  10/24/11  15:45  ALARMF  ALARM - FIRE *  992 GARRETT MILL RD ,54  HITSCHLER RES#610-578-0346-    WILLIS",
        "DATE:10/24/11",
        "TIME:15:45",
        "CODE:ALARMF",
        "CALL:ALARM - FIRE",
        "ADDR:992 GARRETT MILL RD",
        "CITY:WILLISTOWN TWP",
        "INFO:HITSCHLER RES#610-578-0346");

    doTest("T4",
        "(1006 ROBIN DR ,67) 54  10/24/11  10:40  ALARMF  ALARM - FIRE *  1006 ROBIN DR ,67  GILBERT RES - 610.399.1788-    WESTWN",
        "DATE:10/24/11",
        "TIME:10:40",
        "CODE:ALARMF",
        "CALL:ALARM - FIRE",
        "ADDR:1006 ROBIN DR",
        "CITY:WESTTOWN TWP",
        "INFO:GILBERT RES - 610.399.1788");

    doTest("T5",
        "(1201 E STRASBURG RD ,52) 54  10/21/11  21:11  FUEL  FUEL SPILL *  1201 E STRASBURG RD ,52  FRONT P/LOT-STRASBURG COURT AP  WGOSHN",
        "DATE:10/21/11",
        "TIME:21:11",
        "CODE:FUEL",
        "CALL:FUEL SPILL",
        "ADDR:1201 E STRASBURG RD",
        "CITY:WEST GOSHEN TWP",
        "INFO:FRONT P/LOT-STRASBURG COURT AP");

    doTest("T6",
        "(980 HERSHEY MILL RD ,53) 56  10/26/11  18:56  ALARMF  ALARM - FIRE *  980 HERSHEY MILL RD ,53  LEWIS RES/610-644-8389-    EGOSHN",
        "DATE:10/26/11",
        "TIME:18:56",
        "CODE:ALARMF",
        "CALL:ALARM - FIRE",
        "ADDR:980 HERSHEY MILL RD",
        "CITY:EAST GOSHEN TWP",
        "INFO:LEWIS RES/610-644-8389");

  }
  
  public static void main(String[] args) {
    new PAChesterCountyD3ParserTest().generateTests("T1");
  }
}
