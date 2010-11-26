package net.anei.cadpage.parsers;

import org.junit.Test;


public class DESussexCountyParserTest extends BaseParserTest {
  
  public DESussexCountyParserTest() {
    setParser(new DESussexCountyParser(), "SUSSEX", "DE");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
    		"[86 EMS] -- 31C2 -- 33384 Hartford Ct Lewes",
    		"CALL:31C2",
    		"ADDR:33384 Hartford Ct",
    		"CITY:Lewes"
    		);
    doTest("T2",
    		"[86 EMS] -- 33A1 -- 36101 Seaside Blvd Rehoboth",
    		"CALL:33A1",
    		"ADDR:36101 Seaside Blvd",
    		"CITY:Rehoboth"
    		);
    doTest("T3",
    		"[86 Fire] -- F - Auto Fire Alarm -- Hallmark, Parcel Post, Safeway -- 19266 Coastal Hwy Rehoboth -- INC #602",
    		"CALL:F - Auto Fire Alarm",
    		"ADDR:19266 Coastal Hwy",
    		"CITY:Rehoboth",
    		"ID:#602",
    		"INFO:Hallmark, Parcel Post, Safeway"
    		);
    doTest("T4",
    		"[83 FIRE] -- Traffic/TransportationAcdntALS -- 228 W Dupont Hwy Millsboro 19966 -- Food Lion (83)",
    		"CALL:Traffic/TransportationAcdntALS",
    		"ADDR:228 W Dupont Hwy",
    		"CITY:Millsboro 19966",
    		"INFO:Food Lion (83)"
    		);
    doTest("T5",
    		"[83 FIRE] -- Structure Fire -- 0 JOHNSON RD & JESTICE FARM RD Laurel 19956",
    		"CALL:Structure Fire",
    		"ADDR:0 JOHNSON RD / JESTICE FARM RD",
    		"CITY:Laurel 19956"
    		);
    
  }
}
    		