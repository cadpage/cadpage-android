package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDCambridgeParser;

import org.junit.Test;

/*
Cambridge, MD
Contact:ryan travers <traversboy@gmail.com>
Sender:dor911@docogonet.com
DOR911:CT:COMMERCIAL FIRE ALAR 2715 OCEAN GTWY @HOLIDAY INN CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC
DOR911:CT:GAS LEAK OUTSIDE 513 RACE ST CAMB BOX:1-2 DUE: EN1-1 EN1-2 :DC
DOR911:CT:VEHICLE FIRE HARDEES @800 WOODS RD CAMB BOX:1-1 DUE:EN1-3 EN1-4 :DC
DOR911:CT:STRUCTURE FIRE 118 VIRGINIA AVE CAMB BOX:1-1 DUE: EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100 :DC
DOR911:CT:SICK PERSON 5226 WOODS RD @CAMBRIDGE CLUB APT 6 APT 6127 CAMB BOX:1-1 DUE: P101 RS1-1 :DC

Contact: Jeff Lewis <jeff.lewis37@yahoo.com>
Sender: DOR911@docogonet.com
DOR911:CANCEL LAST ALERT AUTH OF ALARM CO 835 :DC\r

***/

public class MDCambridgeParserTest extends BaseParserTest {
  
  public MDCambridgeParserTest() {
    setParser(new MDCambridgeParser(), "CAMBRIDGE", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "DOR911:CT:COMMERCIAL FIRE ALAR 2715 OCEAN GTWY @HOLIDAY INN CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC",
        "CALL:COMMERCIAL FIRE ALAR",
        "ADDR:2715 OCEAN GTWY",
        "CITY:Cambridge",
        "PLACE:HOLIDAY INN",
        "BOX:1-1",
        "UNIT:EN1-1 EN1-2");

    doTest("T2",
        "DOR911:CT:GAS LEAK OUTSIDE 513 RACE ST CAMB BOX:1-2 DUE: EN1-1 EN1-2 :DC",
        "CALL:GAS LEAK OUTSIDE",
        "ADDR:513 RACE ST",
        "CITY:Cambridge",
        "BOX:1-2",
        "UNIT:EN1-1 EN1-2");

    doTest("T3",
        "DOR911:CT:VEHICLE FIRE HARDEES @800 WOODS RD CAMB BOX:1-1 DUE:EN1-3 EN1-4 :DC",
        "CALL:VEHICLE FIRE HARDEES",
        "ADDR:800 WOODS RD",
        "CITY:Cambridge",
        "BOX:1-1",
        "UNIT:EN1-3 EN1-4");

    doTest("T4",
        "DOR911:CT:STRUCTURE FIRE 118 VIRGINIA AVE CAMB BOX:1-1 DUE: EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100 :DC",
        "CALL:STRUCTURE FIRE",
        "ADDR:118 VIRGINIA AVE",
        "CITY:Cambridge",
        "BOX:1-1",
        "UNIT:EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100");

    doTest("T5",
        "DOR911:CT:SICK PERSON 5226 WOODS RD @CAMBRIDGE CLUB APT 6 APT 6127 CAMB BOX:1-1 DUE: P101 RS1-1 :DC",
        "CALL:SICK PERSON",
        "ADDR:5226 WOODS RD",
        "CITY:Cambridge",
        "PLACE:CAMBRIDGE CLUB",
        "APT:6 APT 6127",
        "BOX:1-1",
        "UNIT:P101 RS1-1");
   
  }
  
  public static void main(String[] args) {
    new MDCambridgeParserTest().generateTests("T1");
  }
}