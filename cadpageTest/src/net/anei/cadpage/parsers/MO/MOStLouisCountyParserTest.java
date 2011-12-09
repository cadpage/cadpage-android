package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOStLouisCountyParserTest extends BaseParserTest {
  
  public MOStLouisCountyParserTest() {
    setParser(new MOStLouisCountyParser(), "ST LOUIS COUNTY", "MO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "IN AREA, 224 S HARVEY AV (RES) - - 3014,3025,4310,3615,4610,3016,3017 19:57",
        "PLACE:IN AREA",
        "ADDR:224 S HARVEY AV",
        "MADDR:224 S HARVEY AVE",
        "CALL:(RES) -",
        "UNIT:3014,3025,4310,3615,4610,3016,3017");

    doTest("T2",
        "MONROE AV / OAKRIDGE DR (MISC) - WIRES DOWN - 4310 09:04",
        "ADDR:MONROE AV & OAKRIDGE DR",
        "MADDR:MONROE AVE & OAKRIDGE DR",
        "CALL:(MISC) - WIRES DOWN",
        "UNIT:4310");

    doTest("T3",
        "6721 THURSTON AV (MISC) - WIRES DOWN - 4310 00:22",
        "ADDR:6721 THURSTON AV",
        "MADDR:6721 THURSTON AVE",
        "CALL:(MISC) - WIRES DOWN",
        "UNIT:4310");

    doTest("T4",
        "BROTHERTON LN (RES) - HOUSE ON BROTHERTON - 3025,4310,4610,3615,4210,3016,3017 22:27",
        "ADDR:BROTHERTON LN",
        "CALL:(RES) - HOUSE ON BROTHERTON",
        "UNIT:3025,4310,4610,3615,4210,3016,3017");

    doTest("T5",
        "KIPD, 5990 MONROE AV (LIFE) - 21 YOF WITH CHEST PAINS - 4310,4617 11:03",
        "PLACE:KIPD",
        "ADDR:5990 MONROE AV",
        "MADDR:5990 MONROE AVE",
        "CALL:(LIFE) - 21 YOF WITH CHEST PAINS",
        "UNIT:4310,4617");

    doTest("T6",
        "EVERGREEN BLVD / JANUARY AV (RES) - HSE FIRE ON CORNER - 3615,3620,3014,4310,3602 07:47",
        "ADDR:EVERGREEN BLVD & JANUARY AV",
        "MADDR:EVERGREEN BLVD & JANUARY AVE",
        "CALL:(RES) - HSE FIRE ON CORNER",
        "UNIT:3615,3620,3014,4310,3602");

    doTest("T7",
        "8006 COURTNEY AV (FALLS) - 69 year old, Female, Conscious, Breathing. Falls. Caller Statement: FALLEN. GARAGE DOOR CODE 6008 - 3717,4310 12:44",
        "ADDR:8006 COURTNEY AV",
        "MADDR:8006 COURTNEY AVE",
        "CALL:(FALLS) - 69 year old, Female, Conscious, Breathing. Falls. Caller Statement: FALLEN. GARAGE DOOR CODE 6008",
        "UNIT:3717,4310");

    doTest("T8",
        "8026 WESLEY AV (DIF BREATH) - 65 year old, Female, Conscious, Breathing. Breathing Problems. Caller Statement: DIFF BREATHING. - 4310,3017 13:33",
        "ADDR:8026 WESLEY AV",
        "MADDR:8026 WESLEY AVE",
        "CALL:(DIF BREATH) - 65 year old, Female, Conscious, Breathing. Breathing Problems. Caller Statement: DIFF BREATHING.",
        "UNIT:4310,3017");
  }
  
  public static void main(String[] args) {
    new MOStLouisCountyParserTest().generateTests("T1", "PLACE ADDR CALL UNIT");
  }
}
