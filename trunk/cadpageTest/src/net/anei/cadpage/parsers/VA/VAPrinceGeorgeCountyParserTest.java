package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class VAPrinceGeorgeCountyParserTest extends BaseParserTest {
   
  public VAPrinceGeorgeCountyParserTest() {
    setParser(new VAPrinceGeorgeCountyParser(), "PRINCE GEORGE COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "388:CAD:FIRE AUTOMATIC AID - DINWIDDIE;SPAIN DR/OAK GROVE",
        "ID:388",
        "CALL:FIRE AUTOMATIC AID",
        "ADDR:SPAIN DR & OAK GROVE",
        "CITY:DINWIDDIE");

    doTest("T2",
        "386:CAD:ACCIDENT ENTRAPMENT-OVERTURNED;38 I95 S;CARS",
        "ID:386",
        "CALL:ACCIDENT ENTRAPMENT-OVERTURNED",
        "ADDR:38 I95 S",
        "MADDR:38 I 95 S",
        "CITY:CARSON");

    doTest("T3",
        "384:CAD:FIRE WIRE/POWER LINES DOWN;13499 S CRATER RD/GARYS CHURCH RD;PETE",
        "ID:384",
        "CALL:FIRE WIRE/POWER LINES DOWN",
        "ADDR:13499 S CRATER RD & GARYS CHURCH RD",
        "MADDR:13499 S CRATER RD",
        "CITY:PETERSBURG");

    doTest("T4",
        "380:CAD:FIRE AUTOMATIC AID - DINWIDDIE;27317 REAMS DR",
        "ID:380",
        "CALL:FIRE AUTOMATIC AID",
        "ADDR:27317 REAMS DR",
        "CITY:DINWIDDIE");

    doTest("T5",
        "379:CAD:ACCIDENT UNKNOWN INJURY;20000-BLK S CRATER RD;OFFRAMP I95 S;HALIFAX RD;CARS",
        "ID:379",
        "CALL:ACCIDENT UNKNOWN INJURY",
        "ADDR:20000-BLK S CRATER RD",
        "MADDR:20000 S CRATER RD",
        "X:OFFRAMP I95 S & HALIFAX RD",
        "CITY:CARSON");

    doTest("T6",
        "377:CAD:ACCIDENT ENTRAPMENT-OVERTURNED;20000 ROWANTY RD;ROWANTY CT;INDIAN SWAMP LN;CARS",
        "ID:377",
        "CALL:ACCIDENT ENTRAPMENT-OVERTURNED",
        "ADDR:20000 ROWANTY RD",
        "X:ROWANTY CT & INDIAN SWAMP LN",
        "CITY:CARSON");

    doTest("T7",
        "376:CAD:EMS-SICK;16702 S CRATER RD;PRINCE GEORGE DR;PRINCE GEORGE DR;PETE",
        "ID:376",
        "CALL:EMS-SICK",
        "ADDR:16702 S CRATER RD",
        "X:PRINCE GEORGE DR & PRINCE GEORGE DR",
        "CITY:PETERSBURG");

    doTest("T8",
        "375:CAD:ACCIDENT UNKNOWN INJURY;42 I95 S;I295 S;PETE",
        "ID:375",
        "CALL:ACCIDENT UNKNOWN INJURY",
        "ADDR:42 I95 S",
        "MADDR:42 I 95 S",
        "X:I295 S",
        "CITY:PETERSBURG");

    doTest("T9",
        "369:CAD:FIRE ALARM;2643 LANSING RD;INDIAN RD;TEMPLETON RD;PETE",
        "ID:369",
        "CALL:FIRE ALARM",
        "ADDR:2643 LANSING RD",
        "X:INDIAN RD & TEMPLETON RD",
        "CITY:PETERSBURG");

    doTest("T10",
        "368:CAD:FIRE CARBON MONOXIDE/SMOKE DET;714 JOHNS RD;S CRATER RD;OAK HILL CT;CARS",
        "ID:368",
        "CALL:FIRE CARBON MONOXIDE/SMOKE DET",
        "ADDR:714 JOHNS RD",
        "X:S CRATER RD & OAK HILL CT",
        "CITY:CARSON");

    doTest("T11",
        "366:CAD:ACCIDENT - COMMERICAL VEHICLE;16699 S CRATER RD/PRINCE GEORGE DR;PETE",
        "ID:366",
        "CALL:ACCIDENT - COMMERICAL VEHICLE",
        "ADDR:16699 S CRATER RD & PRINCE GEORGE DR",
        "MADDR:16699 S CRATER RD",
        "CITY:PETERSBURG");

    doTest("T12",
        "1108:CAD:ACCIDENT UNKNOWN INJURY;43 I95 N;PETE",
        "ID:1108",
        "CALL:ACCIDENT UNKNOWN INJURY",
        "ADDR:43 I95 N",
        "MADDR:43 I 95 N",
        "CITY:PETERSBURG");

    doTest("T13",
        "1199:CAD:FIRE STRUCTURE;13586 PUMPHOUSE RD;GOLF COURSE DR;THWEATT DR;DISP",
        "ID:1199",
        "CALL:FIRE STRUCTURE",
        "ADDR:13586 PUMPHOUSE RD",
        "X:GOLF COURSE DR & THWEATT DR & DISP");

  }
  
  public static void main(String[] args) {
    new VAPrinceGeorgeCountyParserTest().generateTests("T1");
  }
}