package net.anei.cadpage.parsers;

import org.junit.Test;


public class DESussexCountyParserTest extends BaseParserTest {
  
  public DESussexCountyParserTest() {
    setParser(new DESussexCountyParser(), "SUSSEX COUNTY", "DE");
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
        "[86 EMS] -- 17A1 -- 18958 Coastal Hwy Lewes",
        "CALL:17A1",
        "ADDR:18958 Coastal Hwy",
        "CITY:Lewes"
        );
    doTest("T4",
    		"[86 Fire] -- F - Auto Fire Alarm -- Hallmark, Parcel Post, Safeway -- 19266 Coastal Hwy Rehoboth -- INC #602",
    		"CALL:F - Auto Fire Alarm",
    		"ADDR:19266 Coastal Hwy",
    		"CITY:Rehoboth",
    		"PLACE:Hallmark, Parcel Post, Safeway"
    		);
    doTest("T5",
        "[86 Fire] -- F - Standby -- Bethany Beach Station 70 Rehoboth Beach -- INC #599",
        "CALL:F - Standby",
        "ADDR:Bethany Beach Station 70 Rehoboth Beach"
        );
    doTest("T6",
    		"[83 FIRE] -- Traffic/TransportationAcdntALS -- 228 W Dupont Hwy Millsboro 19966 -- Food Lion (83)",
    		"CALL:Traffic/TransportationAcdntALS",
    		"ADDR:228 W Dupont Hwy",
    		"CITY:Millsboro",
    		"PLACE:Food Lion (83)"
    		);
    doTest("T7",
        "[83 FIRE] -- Vehicle Fire -- 26026 Patriots Way Georgetown 19947 -- Sussex Central High School",
        "CALL:Vehicle Fire",
        "ADDR:26026 Patriots Way",
        "CITY:Georgetown",
        "PLACE:Sussex Central High School"
        );
    doTest("T8",
        "[83 FIRE] -- Carbon Monoxide Detector -- 28 Patterson Dr Georgetown 19947",
        "CALL:Carbon Monoxide Detector",
        "ADDR:28 Patterson Dr",
        "CITY:Georgetown"
        );
    doTest("T9",
        "[83 FIRE] -- Washdown (Fuel Spill) -- 26972 - 28044 Zoar Rd Georgetown 19947",
        "CALL:Washdown (Fuel Spill)",
        "ADDR:26972 - 28044 Zoar Rd",
        "CITY:Georgetown"
        );
    doTest("T10",
        "[83 FIRE] -- Traffic/TransportationAcdntBLS -- 0 Dupont Blvd & Av Of Honor Georgetown 19947",
        "CALL:Traffic/TransportationAcdntBLS",
        "ADDR:Dupont Blvd",
        "CITY:& Av Of Honor Georgetown"
        );
    doTest("T11",
    		"[83 FIRE] -- Structure Fire -- 0 JOHNSON RD & JESTICE FARM RD Laurel 19956",
    		"CALL:Structure Fire",
    		"ADDR:JOHNSON RD & JESTICE FARM RD",
    		"CITY:Laurel"
    		);
    doTest("T12",
        "[83 FIRE] -- Cardiac/Resp./Death-ALS -- 28723 Woodcrest Dr Harbeson 19951",
        "CALL:Cardiac/Resp./Death-ALS",
        "ADDR:28723 Woodcrest Dr",
        "CITY:Harbeson"
        );

    
  }
}
    		