package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCMecklenburgCountyAParserTest extends BaseParserTest {
  
  public NCMecklenburgCountyAParserTest() {
    setParser(new NCMecklenburgCountyAParser(), "MECKLENBURG COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:Text Page\n18758 Silver Quay Dr                                                  Charlie                       17- Falls/Back injur",
        "ADDR:18758 Silver Quay Dr",
        "INFO:Charlie",
        "CALL:17- Falls/Back injuries");

    doTest("T2",
        "Subject:Text Page\n19485 Old Jetton Rd           ste 100   Lakeside Familty Physicians anDelta                         31- Unconsciousness/",
        "ADDR:19485 Old Jetton Rd",
        "APT:ste 100",
        "PLACE:Lakeside Familty Physicians an",
        "INFO:Delta",
        "CALL:31- Unconsciousness/Fainting");

    doTest("T3",
        "(Text Page) 16710 Northcross Dr                                                   Fire -  Emergency             59-Fuel Spi",
        "ADDR:16710 Northcross Dr",
        "INFO:Fire -  Emergency",
        "CALL:59- Fuel Spill");

    doTest("T4",
        "(Text Page) 19180-19209 Coachmans Trace             GLENRIDGE                     Fire -  Emergency             69-Structure Fire             Meadow Crossing L",
        "ADDR:19180-19209 Coachmans Trace",
        "MADDR:19180 Coachmans Trace",
        "PLACE:GLENRIDGE",
        "INFO:Fire -  Emergency",
        "CALL:69- Structure Fire",
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
        "CALL:06- Breathing Problems");

    doTest("T7",
        "Subject:Incoming Message\n10043 Idlewild Rd             126       Willow Grove Retirement       Charlie                       06- Breathing Pr",
        "ADDR:10043 Idlewild Rd",
        "APT:126",
        "PLACE:Willow Grove Retirement",
        "INFO:Charlie",
        "CALL:06- Breathing Problems");

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
        "MADDR:12463 Stratfield Place Cir",
        "PLACE:CAROLINA CROSSING SUBD",
        "INFO:Delta",
        "CALL:31- Unconsciousness/Fainting",
        "X:Stineway Ct/Sam Meeks Rd",
        "CH:PINR3",
        "MAP:405405/J9",
        "ID:07302011-086");

    doTest("T11",
        "1010 Lakeview Dr              30-B      Pvl Rehab & Living Ctr  *SNF* Charlie                       06- Breathing Problems        Eden Cr/B",
        "ADDR:1010 Lakeview Dr",
        "APT:30-B",
        "PLACE:Pvl Rehab & Living Ctr  *SNF*",
        "INFO:Charlie",
        "CALL:06- Breathing Problems",
        "X:Eden Cr/B");
  }
  
  @Test
  public void parserTest2() {

    doTest("T1",
        "(Incoming Message) 16902 Harbor Master Cove                                              Fire -  Emergency             52F",
        "ADDR:16902 Harbor Master Cove",
        "INFO:Fire -  Emergency",
        "CALL:52F-Alarm-FIRE");

    doTest("T2",
        "(Incoming Message) 13000-blk Hidcote Ct                    BURNING BRUSH                 Fire -  Emergency             67-",
        "ADDR:13000-blk Hidcote Ct",
        "MADDR:13000 Hidcote Ct",
        "PLACE:BURNING BRUSH",
        "INFO:Fire -  Emergency",
        "CALL:67-");

    doTest("T3",
        "(Incoming Message) 16902 Harbor Master Cove                                              Fire -  Emergency             52F",
        "ADDR:16902 Harbor Master Cove",
        "INFO:Fire -  Emergency",
        "CALL:52F-Alarm-FIRE");

    doTest("T4",
        "(Incoming Message) 14341 Salem Ridge Rd                    residential fire alarm        Fire -  Emergency             52F",
        "ADDR:14341 Salem Ridge Rd",
        "PLACE:residential fire alarm",
        "INFO:Fire -  Emergency",
        "CALL:52F-Alarm-FIRE");

    doTest("T5",
        "(Incoming Message) 12019 Verhoeff Dr                       Huntersville Oaks Nursing *SNFFire -  Emergency             52F",
        "ADDR:12019 Verhoeff Dr",
        "PLACE:Huntersville Oaks Nursing *SNF",
        "INFO:Fire -  Emergency",
        "CALL:52F-Alarm-FIRE");

    doTest("T6",
        "(Incoming Message) Beatties Ford Rd & Mcilwaine R          TREE DOWN BLOCKING ONE LANE   Fire -  Emergency             53-",
        "ADDR:Beatties Ford Rd & Mcilwaine R",
        "PLACE:TREE DOWN BLOCKING ONE LANE",
        "INFO:Fire -  Emergency",
        "CALL:53-");

  }
  

  public static void main(String[] args) {
    new NCMecklenburgCountyAParserTest().generateTests("T1", "ADDR APT PLACE INFO CALL X CH MAP ID");
  }
}
