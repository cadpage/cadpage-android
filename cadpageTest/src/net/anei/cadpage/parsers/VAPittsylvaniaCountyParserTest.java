package net.anei.cadpage.parsers;

import org.junit.Test;


public class VAPittsylvaniaCountyParserTest extends BaseParserTest {
   
  public VAPittsylvaniaCountyParserTest() {
    setParser(new VAPittsylvaniaCountyParser(), "PITTSYLVANIA", "VA");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
    		"701:CAD:TRAFFIC ACCIDENT PI;100 MALMAISON RD/U S HIGHWAY NO 29; BLA",
    		"CALL:TRAFFIC ACCIDENT PI",
    		"ADDR:100 MALMAISON RD & U S HIGHWAY NO 29",
    		"CITY:Blairs"
    	);
    doTest("T2",
    		"700:CAD:ABDOMINAL DISTRESS; 701 E WITT RD;BLA;WITT LN;MOUNT VIEW RD;[Medical Priority Info] PROBLEM:CHEST HURTING #PATS: 1 AGE: 77 Years SEX: Male",
    		"CALL:ABDOMINAL DISTRESS",
    		"ADDR:701 E WITT RD",
    		"X:WITT LN",
    		"CITY:Blairs",
    		"INFO:CHEST HURTING #PATS: 1 AGE: 77 Years SEX: Male"
    	);
    doTest("T3",
    		"699:CAD:RESPIRATORY DISTRESS;600 NORTH POINTE LN;DAN;SEMINOLE DR;[Medical Priority Info] PROBLEM: TROUBLE BREATHING #PATS: 1 AGE: 5 Months SEX",
    		"CALL:RESPIRATORY DISTRESS",
    		"ADDR:600 NORTH POINTE LN",
    		"X:SEMINOLE DR",
    		"CITY:Danville",
    		"INFO:TROUBLE BREATHING #PATS: 1 AGE: 5 Months SEX"
    	);
    doTest("T4",
    		"698:CAD:RESPIRATORY DISTRESS;1000 LAWLESS CREEK RD;BLA;PRITCHETT LN;DAKE DR;[Medical Priority Info] PROBLEM: DIFF BREATHING #PATS: 1 AGE: 13 Y",
    		"CALL:RESPIRATORY DISTRESS",
    		"ADDR:1000 LAWLESS CREEK RD",
    		"CITY:Blairs",
    		"X:PRITCHETT LN",
    		"INFO:DIFF BREATHING #PATS: 1 AGE: 13 Y"
    	);
    doTest("T5",
    		"697:CAD:OTHER FIRE EMERGENCY;7180 U S HIGHWAY NO 29;BLA;DANVILLE EXPW;GEORGES LN",
    		"CALL:OTHER FIRE EMERGENCY",
    		"ADDR:7180 U S HIGHWAY NO 29",
    		"CITY:Blairs",
    		"X:DANVILLE EXPW"
    	);
  }
}