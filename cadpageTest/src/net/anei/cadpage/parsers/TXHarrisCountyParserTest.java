package net.anei.cadpage.parsers;

import org.junit.Test;


public class TXHarrisCountyParserTest extends BaseParserTest {
  
  public TXHarrisCountyParserTest() {
    setParser(new TXHarrisCountyParser(), "HARRIS COUNTY", "TX");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "1of2:09/06 11:56 W HILLSIDE DR/EASTEX FRWY, ; Map:414D Sub: Nat:MA-MUTUAL AID / ASSIST AGENCY Units:E91 T81 T73 E-L19 X-St:EASTEX",
        "ADDR:W HILLSIDE DR & EASTEX FRWY",
        "MAP:414D",
        "CALL:MA-MUTUAL AID / ASSIST AGENCY",
        "UNIT:E91 T81 T73 E-L19",
        "X:EASTEX",
        "CITY:Humble");

    doTest("T2",
        "1of2:09/06 11:28 19707 WOOD WALK LN, ; Map:337U Sub:PINEHURST OF ATASCOCITA Nat:09E01-ARREST - NOT BREATHING Units:E-M19 E-M29 E-7900",
        "ADDR:19707 WOOD WALK LN",
        "MAP:337U",
        "PLACE:PINEHURST OF ATASCOCITA",
        "CALL:09E01-ARREST - NOT BREATHING",
        "UNIT:E-M19 E-M29 E-7900");

    doTest("T3",
        "1of2:09/05 08:56 19226 AQUATIC DR, ; Map:378A Sub:WALDEN ON LAKE HOUSTON Nat:52B01G-FIRE ALARM - RESIDENTIAL Units:ATFD E-E39 X-",
        "ADDR:19226 AQUATIC DR",
        "MAP:378A",
        "PLACE:WALDEN ON LAKE HOUSTON",
        "CALL:52B01G-FIRE ALARM - RESIDENTIAL",
        "UNIT:ATFD E-E39 X-");
    
    doTest("T4",
      "1of2:09/04 19:45 17219 KOBUK VALLEY CIR, ; Map:377E Sub:EAGLE SPRINGS Nat:67B03U-OUTSIDE FIRE - INVESTIGA Units:E-E39 X-St:*** Dead",
      "ADDR:17219 KOBUK VALLEY CIR",
      "MAP:377E",
      "PLACE:EAGLE SPRINGS",
      "CALL:67B03U-OUTSIDE FIRE - INVESTIGA",
      "UNIT:E-E39",
      "X:*** Dead");
    
    doTest("T5",
        "1of2:09/03 08:14 LILES LN/WOODLAND HILLS DR, ; Map:376H Sub:ATASCOCITA FOREST Nat:29-MOTOR VEHICLE INCIDENT Units:E-M19 E-E39 X-",
        "ADDR:LILES LN & WOODLAND HILLS DR",
        "MAP:376H",
        "PLACE:ATASCOCITA FOREST",
        "CALL:29-MOTOR VEHICLE INCIDENT",
        "UNIT:E-M19 E-E39 X-");
  }
}
