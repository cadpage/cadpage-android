package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCMecklenburgCountyParserTest extends BaseParserTest {
  
  public NCMecklenburgCountyParserTest() {
    setParser(new NCMecklenburgCountyParser(), "MECKLENBURG COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:Text Page\n18758 Silver Quay Dr                                                  Charlie                       17- Falls/Back injur",
        "ADDR:18758 Silver Quay Dr",
        "INFO:Charlie",
        "CALL:17- Falls/Back injur");

    doTest("T2",
        "Subject:Text Page\n19485 Old Jetton Rd           ste 100   Lakeside Familty Physicians anDelta                         31- Unconsciousness/",
        "ADDR:19485 Old Jetton Rd",
        "APT:ste 100",
        "PLACE:Lakeside Familty Physicians an",
        "INFO:Delta",
        "CALL:31- Unconsciousness/");

    doTest("T3",
        "(Text Page) 16710 Northcross Dr                                                   Fire -  Emergency             59-Fuel Spi",
        "ADDR:16710 Northcross Dr",
        "INFO:Fire -  Emergency",
        "CALL:59-Fuel Spi");

    doTest("T4",
        "(Text Page) 19180-19209 Coachmans Trace             GLENRIDGE                     Fire -  Emergency             69-Structure Fire             Meadow Crossing L",
        "ADDR:19180-19209 Coachmans Trace",
        "PLACE:GLENRIDGE",
        "INFO:Fire -  Emergency",
        "CALL:69-Structure Fire",
        "X:Meadow Crossing L");

    doTest("T5",
        "Subject:Incoming Message\n16738 Amberside Rd East                 Alexander Chase Condos        Fire -  Emergency             52F-Alarm-FIRE",
        "ADDR:16738 Amberside Rd East",
        "PLACE:Alexander Chase Condos",
        "INFO:Fire -  Emergency",
        "CALL:52F-Alarm-FIRE");

    doTest("T6",
        "Subject:Incoming Message\n9150 Lawyers Rd                         McDonalds - Mint Hill         Charlie                       06- Breathing Pr",
        "ADDR:9150 Lawyers Rd",
        "PLACE:McDonalds - Mint Hill",
        "INFO:Charlie",
        "CALL:06- Breathing Pr");

    doTest("T7",
        "Subject:Incoming Message\n10043 Idlewild Rd             126       Willow Grove Retirement       Charlie                       06- Breathing Pr",
        "ADDR:10043 Idlewild Rd",
        "APT:126",
        "PLACE:Willow Grove Retirement",
        "INFO:Charlie",
        "CALL:06- Breathing Pr");

    doTest("T8",
        "(Incoming Message) 19432 Fridley Ln                        medical alarm .. no pt info ..Charlie                       32- Unknown problem (man down)Denae Lynn",
        "ADDR:19432 Fridley Ln",
        "PLACE:medical alarm .. no pt info ..",
        "INFO:Charlie",
        "CALL:32- Unknown problem (man down)",
        "X:Denae Lynn");

    doTest("T9",
        "9120 Willow Ridge Rd          307A      Regency Retirement            Charlie                       26- Sick person               Goodsell",
        "ADDR:9120 Willow Ridge Rd",
        "APT:307A",
        "PLACE:Regency Retirement",
        "INFO:Charlie",
        "CALL:26- Sick person",
        "X:Goodsell");

    doTest("T10",
        "12463 Stratfield Place Cr               CAROLINA CROSSING SUBD        Delta                         31- Unconsciousness/Fainting  Stineway Ct/Sam Meeks Rd                                    PINR3     Map - 405405/J9 07302011-086",
        "ADDR:12463 Stratfield Place Cr",
        "PLACE:CAROLINA CROSSING SUBD",
        "INFO:Delta",
        "CALL:31- Unconsciousness/Fainting",
        "X:Stineway Ct/Sam Meeks Rd",
        "CH:PINR3",
        "MAP:405405/J9",
        "ID:07302011-086");
 }
  

  public static void main(String[] args) {
    new NCMecklenburgCountyParserTest().generateTests("T11", "ADDR APT PLACE INFO CALL X CH MAP ID");
  }
}
