package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.VA.VAPittsylvaniaCountyParser;

import org.junit.Test;


public class VAPittsylvaniaCountyParserTest extends BaseParserTest {
   
  public VAPittsylvaniaCountyParserTest() {
    setParser(new VAPittsylvaniaCountyParser(), "PITTSYLVANIA COUNTY", "VA");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
    		"701:CAD:TRAFFIC ACCIDENT PI;100 MALMAISON RD/U S HIGHWAY NO 29; BLA",
    		"ID:701",
    		"CALL:TRAFFIC ACCIDENT PI",
    		"ADDR:100 MALMAISON RD & U S HIGHWAY NO 29",
    		"CITY:Blairs"
    	);
    doTest("T2",
    		"700:CAD:ABDOMINAL DISTRESS; 701 E WITT RD;BLA;WITT LN;MOUNT VIEW RD;[Medical Priority Info] PROBLEM:CHEST HURTING #PATS: 1 AGE: 77 Years SEX: Male",
    		"CALL:ABDOMINAL DISTRESS",
    		"ID:700",
    		"ADDR:701 E WITT RD",
    		"X:WITT LN & MOUNT VIEW RD",
    		"CITY:Blairs",
    		"INFO:CHEST HURTING #PATS: 1 AGE: 77 Years SEX: Male"
    	);
    doTest("T3",
    		"699:CAD:RESPIRATORY DISTRESS;600 NORTH POINTE LN;DAN;SEMINOLE DR;[Medical Priority Info] PROBLEM: TROUBLE BREATHING #PATS: 1 AGE: 5 Months SEX",
    		"ID:699",
    		"CALL:RESPIRATORY DISTRESS",
    		"ADDR:600 NORTH POINTE LN",
    		"X:SEMINOLE DR",
    		"CITY:Danville",
    		"INFO:TROUBLE BREATHING #PATS: 1 AGE: 5 Months SEX"
    	);
    doTest("T4",
    		"698:CAD:RESPIRATORY DISTRESS;1000 LAWLESS CREEK RD;BLA;PRITCHETT LN;DAKE DR;[Medical Priority Info] PROBLEM: DIFF BREATHING #PATS: 1 AGE: 13 Y",
    		"ID:698",
    		"CALL:RESPIRATORY DISTRESS",
    		"ADDR:1000 LAWLESS CREEK RD",
    		"CITY:Blairs",
    		"X:PRITCHETT LN & DAKE DR",
    		"INFO:DIFF BREATHING #PATS: 1 AGE: 13 Y"
    	);
    doTest("T5",
    		"697:CAD:OTHER FIRE EMERGENCY;7180 U S HIGHWAY NO 29;BLA;DANVILLE EXPW;GEORGES LN",
    		"ID:697",
    		"CALL:OTHER FIRE EMERGENCY",
    		"ADDR:7180 U S HIGHWAY NO 29",
    		"CITY:Blairs",
    		"X:DANVILLE EXPW & GEORGES LN"
    	);
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "1357:CHEST PAINS;1855 RAINBOW CIR;DAN;2011044707;BUCKHORN DR;POWHATAN DR;[Medical Priority Info] PROBLEM: CHEST PAINS AND SWEATING, NAUSEUA # PATS: 1 AGE: 39 Years",
        "CALL:CHEST PAINS",
        "ADDR:1855 RAINBOW CIR",
        "CITY:Danville",
        "ID:2011044707",
        "X:BUCKHORN DR & POWHATAN DR",
        "INFO:CHEST PAINS AND SWEATING, NAUSEUA # PATS: 1 AGE: 39 Years");

    doTest("T2",
        "1363:EMS CALL FOR PROQA;12321 FRANKLIN TPKE;CHA;2011045077;F C BEVERLY RD;STRAWBERRY RD;[Medical Priority Info] PROBLEM: DIZZY SPELLS # PATS: 1 AGE: 85 Years SEX: F",
        "CALL:EMS CALL FOR PROQA",
        "ADDR:12321 FRANKLIN TPKE",
        "CITY:Chatham",
        "ID:2011045077",
        "X:F C BEVERLY RD & STRAWBERRY RD",
        "INFO:DIZZY SPELLS # PATS: 1 AGE: 85 Years SEX: F");

    doTest("T3",
        "1358:HEMORRHAGING;438 BONNY AVE;CAS;2011044807;PEACEFUL LN;SERENE CT;[Medical Priority Info] PROBLEM: BLEEDING FRON URINE AND BOWEL MOMENT # PATS: 1 AGE: 47 Years S",
        "CALL:HEMORRHAGING",
        "ADDR:438 BONNY AVE",
        "CITY:Cascade",
        "ID:2011044807",
        "X:PEACEFUL LN & SERENE CT",
        "INFO:BLEEDING FRON URINE AND BOWEL MOMENT # PATS: 1 AGE: 47 Years S");

    doTest("T4",
        "1360:RESPIRATORY DISTRESS;113 HUNTERS RDG;DAN;2011044913;HUNTERS TRL;HUNTERS CHASE;[Medical Priority Info] PROBLEM: HUSBAND TROUBLE BREATHING&CHEST PAINS # PATS: 1",
        "CALL:RESPIRATORY DISTRESS",
        "ADDR:113 HUNTERS RDG",
        "CITY:Danville",
        "ID:2011044913",
        "X:HUNTERS TRL",
        "INFO:HUNTERS CHASE / HUSBAND TROUBLE BREATHING&CHEST PAINS # PATS: 1");

    doTest("T5",
        "1366:EMS CALL FOR PROQA;127 MEDICAL CENTER RD;DAN;2011045246;MOUNT CROSS RD;HINESVILLE RD",
        "CALL:EMS CALL FOR PROQA",
        "ADDR:127 MEDICAL CENTER RD",
        "CITY:Danville",
        "ID:2011045246",
        "X:MOUNT CROSS RD & HINESVILLE RD");

    doTest("T6",
        "1365:ENTRAPMENT;127 MEDICAL CENTER RD;DAN;2011045245;MOUNT CROSS RD;HINESVILLE RD",
        "CALL:ENTRAPMENT",
        "ADDR:127 MEDICAL CENTER RD",
        "CITY:Danville",
        "ID:2011045245",
        "X:MOUNT CROSS RD & HINESVILLE RD");

    doTest("T7",
        "1367:UNKNOWN MEDICAL EMERGENCY;1976 HILL CREEK RD;DRY;2011045254;SUNSET DR;MOUNT CROSS RD;[Medical Priority Info] PROBLEM: MEDICAL ALARM # PATS: 1 AGE: Unknown Rang",
        "CALL:UNKNOWN MEDICAL EMERGENCY",
        "ADDR:1976 HILL CREEK RD",
        "CITY:Dry Fork",
        "ID:2011045254",
        "X:SUNSET DR & MOUNT CROSS RD",
        "INFO:MEDICAL ALARM # PATS: 1 AGE: Unknown Rang");

    doTest("T8",
        "1364:EMS CALL FOR PROQA;1976 HILL CREEK RD;DRY;2011045231;SUNSET DR;MOUNT CROSS RD;[Medical Priority Info] PROBLEM: MEDICAL ALARM # PATS: 1 AGE: Unknown Range SEX:",
        "CALL:EMS CALL FOR PROQA",
        "ADDR:1976 HILL CREEK RD",
        "CITY:Dry Fork",
        "ID:2011045231",
        "X:SUNSET DR & MOUNT CROSS RD",
        "INFO:MEDICAL ALARM # PATS: 1 AGE: Unknown Range SEX:");

  }
  
  public static void main(String[] args) {
    new VAPittsylvaniaCountyParserTest().generateTests("T1");
  }
}