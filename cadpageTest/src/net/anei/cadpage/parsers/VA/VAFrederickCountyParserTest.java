package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.VA.VAFrederickCountyParser;

import org.junit.Test;


public class VAFrederickCountyParserTest extends BaseParserTest {
  
  public VAFrederickCountyParserTest() {
    setParser(new VAFrederickCountyParser(), "FREDERICK COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:107 HICKORY HILL DR;GENERAL ILL-NEW ONSET IMMOBILE;LAUREL HILL DR;LAKESIDE DR",
        "ADDR:107 HICKORY HILL DR",
        "CALL:GENERAL ILL-NEW ONSET IMMOBILE",
        "X:LAUREL HILL DR & LAKESIDE DR");

    doTest("T2",
        "CAD:458 HITES RD;UNCON/FAINT-UNCON/BREATHING;CARSON LN;GEM DR",
        "ADDR:458 HITES RD",
        "CALL:UNCON/FAINT-UNCON/BREATHING",
        "X:CARSON LN & GEM DR");

    doTest("T3",
        "CAD:2044-79 FAIRFAX PIKE;PREGNANCY-LABOR;APPRENTICE LN",
        "ADDR:2044-79 FAIRFAX PIKE",
        "MADDR:2044 FAIRFAX PIKE",
        "CALL:PREGNANCY-LABOR",
        "X:APPRENTICE LN");

    doTest("T4",
        "CAD:250 COSTELLO DR;FILL STATION;FRONT ROYAL PIKE;PRINCE FREDERICK DR",
        "ADDR:250 COSTELLO DR",
        "CALL:FILL STATION",
        "X:FRONT ROYAL PIKE & PRINCE FREDERICK DR");

    doTest("T5",
        "CAD:3632 VALLEY PIKE;FALL - POSS DANGEROUS;COMMONWEALTH CT;FAY ST",
        "ADDR:3632 VALLEY PIKE",
        "CALL:FALL - POSS DANGEROUS",
        "X:COMMONWEALTH CT & FAY ST");
    
    doTest("T6",
        "CAD:1 RT37 N/I81 N;ACCIDENT W/ INJURY;REAR END COLLISIONS [12/07/10 17:35:47 LBRANNON] THREE VEHS INVOVLED.....UNK INJURIES...NO ENTRAPMENT [12/07/10 17:35:3",
        "CALL:ACCIDENT W/ INJURY",
        "ADDR:1 RT37 N & I81 N",
        "MADDR:1 RT 37 N",
        "INFO:REAR END COLLISIONS / THREE VEHS INVOVLED.....UNK INJURIES...NO ENTRAPMENT",
        "DATE:12/07/10",
        "TIME:17:35:47");

    doTest("T7",
        "CAD:285 PARK CENTER DR;LARCENY GENERAL;FIRE ALARM ZONE 7 PLANT PULL STATION [06/19/11 11:09:10 SFULTZ] ;W BROOKE RD",
        "ADDR:285 PARK CENTER DR",
        "CALL:LARCENY GENERAL",
        "INFO:FIRE ALARM ZONE 7 PLANT PULL STATION / W BROOKE RD",
        "DATE:06/19/11",
        "TIME:11:09:10");
  }
  
  public static void main(String[] args) {
    new VAFrederickCountyParserTest().generateTests("T1");
  }
}
