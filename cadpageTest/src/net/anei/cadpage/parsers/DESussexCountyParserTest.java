package net.anei.cadpage.parsers;

import org.junit.Test;


public class DESussexCountyParserTest extends BaseParserTest {
  
  public DESussexCountyParserTest() {
    setParser(new DESussexCountyParser(), "SUSSEX COUNTY", "DE");
  }
  
  @Test
  public void testProblem() {
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
        "ADDR:Bethany Beach Station 70",
        "CITY:Rehoboth Beach"
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
        "ADDR:Dupont Blvd & Av Of Honor",
        "CITY:Georgetown"
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
    
    doTest("T20",
        "[81 FIRE] -- Traffic/TransportaionAcdntBLS -- 0 Discount Land Rd & Sussex Hw",
        "CALL:Traffic/TransportaionAcdntBLS",
        "ADDR:Discount Land Rd & Sussex Hw"
        );
    doTest("T21",
        "[81 EMS] -- Chest Pain-ALS -- 34544 Doe Dr Laurel 19956",
        "CALL:Chest Pain-ALS",
        "ADDR:34544 Doe Dr",
        "CITY:Laurel"
        );
    doTest("T22",
        "[81 FIRE] -- Cardiac/Res./Death-ALS -- 815 S Central Ave Laurel 19956 -- Laurel Middle / intermediate n",
        "CALL:Cardiac/Res./Death-ALS",
        "PLACE:Laurel Middle / intermediate n",
        "ADDR:815 S Central Ave",
        "CITY:Laurel"
        );
    doTest("T23",
        "[81 EMS] -- Abdominal Pain-BLS -- 30594 SUssex Hwy Laurel 19956 -- Relax Inn",
        "CALL:Abdominal Pain-BLS",
        "ADDR:30594 SUssex Hwy",
        "CITY:Laurel",
        "PLACE:Relax Inn"
        );
    doTest("T24",
        "[81 EMS] -- Unconcious/Fainting(Near)-ALS -- 31574 White Ave Laurel 19956",
        "CALL:Unconcious/Fainting(Near)-ALS",
        "ADDR:31574 White Ave",
        "CITY:Laurel"
        );
    doTest("T25",
        "[81 EMS] -- Falls-BLS -- 609 Little Creek Dr Laurel 19956",
        "CALL:Falls-BLS",
        "ADDR:609 Little Creek Dr",
        "CITY:Laurel"
        );
  }
  
  @Test
  public void testSeaford() {
    doTest("T30",
        "[87 EMS] -- 1A Abdominal Pains (ALS) -- 6412 Woodduck Dr Seaford de, 19973",
        "CALL:1A Abdominal Pains (ALS)",
        "ADDR:6412 Woodduck Dr",
        "CITY:Seaford"
        );
    doTest("T31",
        "[87 FIRE] -- Smoke Investigation -- 6341 Baker Rd Seaford de, 19973",
        "CALL:Smoke Investigation",
        "ADDR:6341 Baker Rd",
        "CITY:Seaford"
        );
    doTest("T32",
        "[87 EMS] -- 6A Breathing Problems (ALS) -- 24642 Shufelt Rd Seaford de, 19973",
        "CALL:6A Breathing Problems (ALS)",
        "ADDR:24642 Shufelt Rd",
        "CITY:Seaford"
        );
    doTest("T33",
        "[87 FIRE] -- Assist Other Agency -- Hickory Hill Rd/ Guard Rd Seaford de, 19973",
        "CALL:Assist Other Agency",
        "ADDR:Hickory Hill Rd & Guard Rd",
        "CITY:Seaford"
        );
    doTest("T34",
        "[87 EMS] -- 33A Interfacility (ALS) -- 715 E King St 204a Seaford de, 19973",
        "CALL:33A Interfacility (ALS)",
        "ADDR:715 E King St 204a",
        "CITY:Seaford"
        );
    doTest("T35",
        "[87 EMS] -- 13A Diabetic Problems (ALS) -- 24101 Dove Rd Seaford de, 19973",
        "CALL:13A Diabetic Problems (ALS)",
        "ADDR:24101 Dove Rd",
        "CITY:Seaford"
        );


    
  }
}
    		