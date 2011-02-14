package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXMontgomeryCountyParserTest extends BaseParserTest {
  
  public TXMontgomeryCountyParserTest() {
    setParser(new TXMontgomeryCountyParser(), "MONTGOMERY COUNTY", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[Fire CAD Message]  New Fire Run: 2010-63654,Nature: 12D02E-SEIZURE - Continuous or Multiple seizures,MR54,Location: 12246 TRAIL HOLLOW DR,Buildi",
        "ID:2010-63654",
        "CALL:12D02E-SEIZURE - Continuous or Multiple seizures",
        "ADDR:12246 TRAIL HOLLOW DR");

    doTest("T2",
        "[Fire CAD Message]  New Fire Run: 2010-63564,Nature: 19D04-HEART PROBLEMS - Clammy,MR51,Location: HIGHWAY 105 W & S FM 1486,Building: ,Cross: ,,G",
        "ID:2010-63564",
        "CALL:19D04-HEART PROBLEMS - Clammy",
        "ADDR:HIGHWAY 105 W & S FM 1486");

    doTest("T3",
        "[Fire CAD Message]  New Fire Run: 2010-63733,Nature: F15-ILLEGAL BURN,E55;,Location: 14321 FOREST CIR E-MO,Building: ,Cross: 14658 FOREST CIR-MO,",
        "ID:2010-63733",
        "CALL:F15-ILLEGAL BURN",
        "ADDR:14321 FOREST CIR E",
        "CITY:MONTGOMERY",
        "X:14658 FOREST CIR");

    doTest("T4",
        "[Fire CAD Message]  New Fire Run: 2010-63709,Nature: F25-RESIDENTIAL FIRE,E51;,Location: 159 S PINE DR-MO,Building: ,Cross: 132 N PINE DR-MO,132",
        "ID:2010-63709",
        "CALL:F25-RESIDENTIAL FIRE",
        "ADDR:159 S PINE DR",
        "CITY:MONTGOMERY",
        "X:132 N PINE DR");

    doTest("T5",
        "[Fire CAD Message]  New Fire Run: 2010-63739,Nature: F15-ILLEGAL BURN,E51;,Location: PINE LN-MO/HICKORY DR-MO,Building: ,Cross: 19902 PINE LN-MO,",
        "ID:2010-63739",
        "CALL:F15-ILLEGAL BURN",
        "ADDR:PINE LN & HICKORY DR",
        "CITY:MONTGOMERY",
        "X:19902 PINE LN");

    doTest("T6",
        "[Fire CAD Message]  New Fire Run: 2010-63762,Nature: 10C04-CHEST PAIN - Breathing Normally => 35,MR51,Location: 24495 REED RD,Building: ,Cross: ,",
        "ID:2010-63762",
        "CALL:10C04-CHEST PAIN - Breathing Normally => 35",
        "ADDR:24495 REED RD");

    doTest("T7",
        "[Fire CAD Message]  New Fire Run: 2010-63789,Nature: 17D03-FALL - Not alert,MR51,Location: 1953 DR MARTIN LUTHER KING JR DR,Building: ,Cross: ,,G",
        "ID:2010-63789",
        "CALL:17D03-FALL - Not alert",
        "ADDR:1953 DR MARTIN LUTHER KING JR DR");

    doTest("T8",
        "[Fire CAD Message]  New Fire Run: 2010-63800,Nature: 28C01G-STROKE/CVA - Not alert - Greater than one hour onset,MR55,Location: 1 FAIRFIELD DR,Bu",
        "ID:2010-63800",
        "CALL:28C01G-STROKE/CVA - Not alert - Greater than one hour onset",
        "ADDR:1 FAIRFIELD DR");
  }
  
  public static void main(String[] args) {
    new TXMontgomeryCountyParserTest().generateTests();
  }
}
