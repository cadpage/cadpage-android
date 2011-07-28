package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CAMendocinoCountyParserTest extends BaseParserTest {
  
  public CAMendocinoCountyParserTest() {
    setParser(new CAMendocinoCountyParser(), "MENDOCINO COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(CAD Page) OTHER MISC. DISPLAY; =L(39.107949,-123.087224) ,UKV (COW MOUNTAIN); Inc# X: -123 5.23344  Y: 39 6.47694 B1113; testing with b1113",
        "CALL:OTHER MISC. DISPLAY",
        "PLACE:COW MOUNTAIN",
        "ADDR:=L(39.107949,-123.087224)",
        "CITY:UKIAH",
        "GPS:X: -123 5.23344  Y: 39 6.47694",
        "UNIT:B1113",
        "INFO:testing with b1113");

    doTest("T2",
        "MEDICAL, BRAVO; COVELO FIREHOUSE @ 75900 HWY 162 ,COVL ; Inc# 004042X: -123 14.8924  Y: 39 47.2236 B1113 CVL E1151; 42 YOF DIFF BREATHING",
        "CALL:MEDICAL, BRAVO",
        "PLACE:COVELO FIREHOUSE",
        "ADDR:75900 HWY 162",
        "CITY:COVELO",
        "ID:004042",
        "GPS:X: -123 14.8924  Y: 39 47.2236",
        "UNIT:B1113 CVL E1151",
        "INFO:42 YOF DIFF BREATHING");

    doTest("T3",
        "MEDICAL, BRAVO; 76415 LOVELL ST ,COVL ; Inc# 004038X: -123 15.1425  Y: 39 47.5964 B1113 CVL E1151; 97 YOF GLF BRUISING ON THIGH",
        "CALL:MEDICAL, BRAVO",
        "ADDR:76415 LOVELL ST",
        "CITY:COVELO",
        "ID:004038",
        "GPS:X: -123 15.1425  Y: 39 47.5964",
        "UNIT:B1113 CVL E1151",
        "INFO:97 YOF GLF BRUISING ON THIGH");

    doTest("T4",
        "PA, AGENCY; ROUND VALLEY AIRPORT @ =L(39.789877,-123.267513) ,COVL ; Inc# 004014X: -123 16.0507  Y: 39 47.3926 B1113 CVL E1151; wht 1 eng sieries 22 a small plain tale #  N1463C see if plane has landed   and advise mcso",
        "CALL:PA, AGENCY",
        "PLACE:ROUND VALLEY AIRPORT",
        "ADDR:=L(39.789877,-123.267513)",
        "CITY:COVELO",
        "ID:004014",
        "GPS:X: -123 16.0507  Y: 39 47.3926",
        "UNIT:B1113 CVL E1151",
        "INFO:wht 1 eng sieries 22 a small plain tale #  N1463C see if plane has landed   and advise mcso");

    doTest("T5",
        "FIRE, RESIDENTIAL ALARM; 31110BLK  BRUSH CREEK RD ,FORTB ; Inc# 004013X: -123 46.6691  Y: 39 25.7574 B1113 BRG E1152 ADMIN; 31171 living room smoke dector",
        "CALL:FIRE, RESIDENTIAL ALARM",
        "ADDR:31110BLK  BRUSH CREEK RD",
        "CITY:FORT BRAGG",
        "ID:004013",
        "GPS:X: -123 46.6691  Y: 39 25.7574",
        "UNIT:B1113 BRG E1152 ADMIN",
        "INFO:31171 living room smoke dector");

    doTest("T6",
        "FIRE, RESIDENTIAL; 341 MACMILLAN DR ,HOPL ; Inc# 004007X: -123 7.29456  Y: 38 58.0572 B1113 HOP T96 HEL101 E1153 E1165 E1453 E1161 CCR4 DOZ1242 ADMIN; structure fire multi caller",
        "CALL:FIRE, RESIDENTIAL",
        "ADDR:341 MACMILLAN DR",
        "CITY:HOPLAND",
        "ID:004007",
        "GPS:X: -123 7.29456  Y: 38 58.0572",
        "UNIT:B1113 HOP T96 HEL101 E1153 E1165 E1453 E1161 CCR4 DOZ1242 ADMIN",
        "INFO:structure fire multi caller");

    doTest("T7",
        "FIRE, WILDLAND; 32151 PUDDING CREEK RD ,FORTB ; Inc# 004005X: -123 47.5662  Y: 39 27.0477 B1113 BRG E1152 E1156 E1154 E1168 PFK1 HEL101 ADMIN; brow shirt wht sleeves older jen 60-70 wb on pud creek rd sta",
        "CALL:FIRE, WILDLAND",
        "ADDR:32151 PUDDING CREEK RD",
        "CITY:FORT BRAGG",
        "ID:004005",
        "GPS:X: -123 47.5662  Y: 39 27.0477",
        "UNIT:B1113 BRG E1152 E1156 E1154 E1168 PFK1 HEL101 ADMIN",
        "INFO:brow shirt wht sleeves older jen 60-70 wb on pud creek rd sta");

    doTest("T8",
        "MED, TRAFFIC COLLISION; HWY 101 MP 100.25 @ =L(39.930402,-123.762749) ,PIERC ; Inc# 003522X: -123 45.7649  Y: 39 55.8241 B1113; testing cad paging",
        "CALL:MED, TRAFFIC COLLISION",
        "PLACE:HWY 101 MP 100.25",
        "ADDR:=L(39.930402,-123.762749)",
        "CITY:PIERCY",
        "ID:003522",
        "GPS:X: -123 45.7649  Y: 39 55.8241",
        "UNIT:B1113",
        "INFO:testing cad paging");

    doTest("T9",
        "MED, TRAFFIC COLLISION; 802 S MAIN ST / 2 HWY 20 ,WILL ; Inc# 003522X: -123 21.0982  Y: 39 24.2470 B1113; testing cad paging",
        "CALL:MED, TRAFFIC COLLISION",
        "ADDR:802 S MAIN ST & 2 HWY 20",
        "CITY:WILLITS",
        "ID:003522",
        "GPS:X: -123 21.0982  Y: 39 24.2470",
        "UNIT:B1113",
        "INFO:testing cad paging");

    doTest("T10",
        "MEDICAL, BRAVO; =L(39.126853,-123.129230) ,UKV ; Inc# 003823X: -123 7.7538  Y: 39 7.61118 B1113; mill creek by upper pond adult male leg inj 3rd party report",
        "CALL:MEDICAL, BRAVO",
        "ADDR:=L(39.126853,-123.129230)",
        "CITY:UKIAH",
        "ID:003823",
        "GPS:X: -123 7.7538  Y: 39 7.61118",
        "UNIT:B1113",
        "INFO:mill creek by upper pond adult male leg inj 3rd party report");

    doTest("T11",
        "FIRE, VEH PASSENGER; SQUAW ROCK @ =L(38.912401,-123.056112) ,HOPL ; Inc# 003858X: -123 3.36672  Y: 38 54.7440 B1113 HOP CLD ADMIN; big rig fire - chp responding",
        "CALL:FIRE, VEH PASSENGER",
        "PLACE:SQUAW ROCK",
        "ADDR:=L(38.912401,-123.056112)",
        "CITY:HOPLAND",
        "ID:003858",
        "GPS:X: -123 3.36672  Y: 38 54.7440",
        "UNIT:B1113 HOP CLD ADMIN",
        "INFO:big rig fire - chp responding");
  }
  
  public static void main(String[] args) {
    new CAMendocinoCountyParserTest().generateTests("T1");
  }
}