package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDHarfordParser;

import org.junit.Test;


public class MDHarfordParserTest extends BaseParserTest {
  
  public MDHarfordParserTest() {
    setParser(new MDHarfordParser(), "HARFORD", "MD");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "[!] EOC:A1091 UNC >UNCONSCIOUS 2200 CHANNEL RD XS: X BIG BRANCH BRDG #127 PYLESVILLE CRIZER,KIM BOX: N08 Cad: 2010-0000162717",
        "UNIT:A1091",
        "CALL:UNCONSCIOUS",
        "ADDR:2200 CHANNEL RD",
        "X:BIG BRANCH BRDG",
        "APT:127",
        "CITY:PYLESVILLE",
        "NAME:CRIZER,KIM",
        "BOX:N08",
        "ID:2010-0000162717");

    doTest("T2",
        "[!] EOC:A1091 SICK >SICK PERSON 1606 SCOTT RD XS: X FAWN GROVE RD PYLESVILLE BATCHELDER,MICHELLE BOX: N04 Cad: 2010-0000162427",
        "UNIT:A1091", 
        "CALL:SICK PERSON",
        "ADDR:1606 SCOTT RD",
        "X:FAWN GROVE RD",
        "CITY:PYLESVILLE",
        "NAME:BATCHELDER,MICHELLE",
        "BOX:N04",
        "ID:2010-0000162427");
    
    doTest("T3",        
        "[!] EOC:A1091 DIAB >DIABETIC EMRG. 2145 HARKINS RD XS: SAINT PAULS CHURCH RD PYLESVILLE ROHREAUGH,KEN BOX: N04 Cad: 2010-0000162445",
        "UNIT:A1091",
        "CALL:DIABETIC EMRG.",
        "ADDR:2145 HARKINS RD",
        "X:SAINT PAULS CHURCH RD",
        "CITY:PYLESVILLE",
        "NAME:ROHREAUGH,KEN",
        "BOX:N04",
        "ID:2010-0000162445");
        
    doTest("T4",
        "[!] EOC:E1011 MISC >MISC 4873 CAREA RD XS: X WALNUT SPRING CT WHITE HALL SHERBS,ROBERT BOX: N08 Cad: 2010-0000162395",
        "UNIT:E1011",
        "CALL:MISC",
        "ADDR:4873 CAREA RD",
        "X:WALNUT SPRING CT",
        "CITY:WHITE HALL",
        "NAME:SHERBS,ROBERT",
        "BOX:N08",
        "ID:2010-0000162395");
        
    doTest("T5",
        "[!] EOC:A1091 MVA >MV ACCIDENT W/INJURY SRT24&SAINT MARYS RD XS: SAINT MARYS RD PYLESVILLE DEDRICK.PATTI Cad: 2010-0000162161",
        "UNIT:A1091",
        "CALL:MV ACCIDENT W/INJURY",
        "ADDR:SRT24 & SAINT MARYS RD",
        "MADDR:MD 24 & SAINT MARYS RD",
        "X:SAINT MARYS RD",
        "CITY:PYLESVILLE",
        "PLACE:DEDRICK",
        "NAME:PATTI",
        "ID:2010-0000162161");
    
    doTest("T6",
        "Subject:HCCAD\n[!] EOC:F03 WIRES >WIRES/POLE SHAWNEE DR&WALTERS MILL RD XS: WALTERS MILL RD FOREST HILL NOT ENTERED Cad: 2010-000019169",
        "UNIT:F03",
        "CALL:WIRES/POLE",
        "ADDR:SHAWNEE DR & WALTERS MILL RD",
        "X:WALTERS MILL RD",
        "CITY:FOREST HILL",
        "NAME:NOT ENTERED",
        "ID:2010-000019169");

    doTest("T7",
        "(HCCAD) [!] EOC:E04 HEMM >HEMORRAGE/LACERATION 4324 HAMPTON HALL CT XS: DEAD END BELCAMP KOWALCHEK,JOHN BOX: 402 Cad: 2011-0000090313",
        "UNIT:E04",
        "CALL:HEMORRAGE/LACERATION",
        "ADDR:4324 HAMPTON HALL CT",
        "X:DEAD END",
        "CITY:BELCAMP",
        "NAME:KOWALCHEK,JOHN",
        "BOX:402",
        "ID:2011-0000090313");

    doTest("T8",
        "HCCAD / [!] EOC:E02 ARRES >CARDIAC ARREST 35 LINCOLN AVE Apt: C1 Bldg XS: PRITCHARD AVE ABERDEEN WARD,ASHANTE BOX: 211 Cad:11793\n\n",
        "UNIT:E02",
        "CALL:CARDIAC ARREST",
        "ADDR:35 LINCOLN AVE",
        "APT:C1 Bldg",
        "X:PRITCHARD AVE",
        "CITY:ABERDEEN",
        "NAME:WARD,ASHANTE",
        "BOX:211",
        "ID:11793");

    doTest("T9",
        "[DVFC]  EOC:F09 911-CENTER SWR &gt;SWIFT/FLOOD WATER RES SRT24&amp;CHESTNUT HILL RD XS: CHESTNUT HILL RD FOREST HILL THOMPSON,DOUG Cad: 2011-0000122811",
        "UNIT:F09",
        "CALL:SWIFT/FLOOD WATER RES",
        "ADDR:ST-24 & CHESTNUT HILL RD",
        "MADDR:MD 24 & CHESTNUT HILL RD",
        "X:CHESTNUT HILL RD",
        "CITY:FOREST HILL",
        "NAME:THOMPSON,DOUG",
        "ID:2011-0000122811");

    doTest("T10",
        "FRM:rc.95@c-msg.net\nSUBJ:HCCAD\nMSG:[!] EOC:E91 HEART >HEART PROBLEM SRT155&SRT161 XS: SRT161 HAVRE DE GRACE Cad:143258\n",
        "UNIT:E91",
        "CALL:HEART PROBLEM",
        "ADDR:ST-155 & SRT161",
        "MADDR:MD 155 & MD 161",
        "X:SRT161",
        "CITY:HAVRE DE GRACE",
        "ID:143258");

    doTest("T11",
        "(HCCAD) [!] EOC:E04 ABDOM >ABDOMINAL PAIN 4964 BRISTLE CONE CIR XS: HOLLY OAK CIR - SOUTH ABERDEEN ROGERS,WILLIAM BOX: 417 Cad:209431",
        "UNIT:E04",
        "CALL:ABDOMINAL PAIN",
        "ADDR:4964 BRISTLE CONE CIR",
        "X:HOLLY OAK CIR - SOUTH",
        "CITY:ABERDEEN",
        "NAME:ROGERS,WILLIAM",
        "BOX:417",
        "ID:209431");

    doTest("T12",
        "(HCCAD) [!] EOC:F07 MVAR >MVA W/ RESCUE 4830 NORRISVILLE RD XS: X AYRES CHAPEL RD WHITE HALL GLACIER,KATHY BOX: 712 Cad: 2012-0000101402",
        "UNIT:F07",
        "CALL:MVA W/ RESCUE",
        "ADDR:4830 NORRISVILLE RD",
        "X:AYRES CHAPEL RD",
        "CITY:WHITE HALL",
        "NAME:GLACIER,KATHY",
        "BOX:712",
        "ID:2012-0000101402");

    doTest("T13",
        "(HCCAD) [!] EOC:F07 MVAR >MVA W/ RESCUE 1219 BALDWIN MILL RD XS: INGLESIDE DR JARRETTSVILLE BARNHILL,DAVE BOX: 700 Cad: 2012-0000101401",
        "UNIT:F07",
        "CALL:MVA W/ RESCUE",
        "ADDR:1219 BALDWIN MILL RD",
        "X:INGLESIDE DR",
        "CITY:JARRETTSVILLE",
        "NAME:BARNHILL,DAVE",
        "BOX:700",
        "ID:2012-0000101401");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(HCCAD) [!] EOC:E04 MED PRE-ALERT 20 BOX HILL SOUTH PKY Apt: 304 Bldg MERCHANT BLVD GARDNER,ROWENA",
        "UNIT:E04",
        "CALL:MED PRE-ALERT",
        "ADDR:20 BOX HILL SOUTH PKY",
        "APT:304 Bldg",
        "X:MERCHANT BLVD",
        "NAME:GARDNER,ROWENA");

    doTest("T2",
        "(HCCAD) [!] EOC:E03 MED PRE-ALERT 912 BUCKLAND PL DEAD END - S END HERBERT,GREG",
        "UNIT:E03",
        "CALL:MED PRE-ALERT",
        "ADDR:912 BUCKLAND PL",
        "PLACE:DEAD END - S END",
        "NAME:HERBERT,GREG");

    doTest("T3",
        "(HCCAD) [!] EOC:E04 HEAD >HEADACHE 20 BOX HILL SOUTH PKY Apt: 304 Bldg XS: MERCHANT BLVD ABINGDON GARDNER,ROWENA BOX: 410 Cad: 2012-0000153342",
        "UNIT:E04",
        "CALL:HEADACHE",
        "ADDR:20 BOX HILL SOUTH PKY",
        "APT:304 Bldg",
        "X:MERCHANT BLVD",
        "CITY:ABINGDON",
        "NAME:GARDNER,ROWENA",
        "BOX:410",
        "ID:2012-0000153342");

    doTest("T4",
        "(HCCAD) [!] EOC:E01 CVA >STROKE 912 BUCKLAND PL XS: DEAD END - S END BEL AIR HERBERT,GREG BOX: 322 Cad: 2012-0000153343",
        "UNIT:E01",
        "CALL:STROKE",
        "ADDR:912 BUCKLAND PL",
        "X:DEAD END - S END",
        "CITY:BEL AIR",
        "NAME:HERBERT,GREG",
        "BOX:322",
        "ID:2012-0000153343");

    doTest("T5",
        "(HCCAD) [!] EOC:E04 ALRMHI>HOLD UP ALARM IP 4417 TOLCHESTER CT XS: BRISTOL FOREST DR BELCAMP PINNACLE//OP VANESSA BOX: 402 Cad: 2012-0000153349",
        "UNIT:E04",
        "CALL:HOLD UP ALARM IP",
        "ADDR:4417 TOLCHESTER CT",
        "X:BRISTOL FOREST DR",
        "CITY:BELCAMP",
        "PLACE:PINNACLE / / OP",
        "NAME:VANESSA",
        "BOX:402",
        "ID:2012-0000153349");

    doTest("T6",
        "(HCCAD) [!] EOC:E11 MUTBC >MUT AID BALTO CO BCO 48-4 12652 FORK RD Cad: 2012-0000153395",
        "UNIT:E11",
        "CALL:MUT AID BALTO CO BCO",
        "ADDR:48-4 12652 FORK RD",
        "MADDR:48 12652 FORK RD",
        "ID:2012-0000153395");

    doTest("T7",
        "(HCCAD) [!] EOC:E11 MED PRE-ALERT 1605 ANGLESIDE RD DEAD END BUSCH,CAROL",
        "UNIT:E11",
        "CALL:MED PRE-ALERT",
        "ADDR:1605 ANGLESIDE RD",
        "PLACE:DEAD END",
        "NAME:BUSCH,CAROL");

    doTest("T8",
        "(HCCAD) [!] EOC:E11 RESP >RESPIRATORY DISTRESS 1605 ANGLESIDE RD XS: DEAD END FALLSTON BUSCH,CAROL BOX: F24 Cad: 2012-0000154310",
        "UNIT:E11",
        "CALL:RESPIRATORY DISTRESS",
        "ADDR:1605 ANGLESIDE RD",
        "X:DEAD END",
        "CITY:FALLSTON",
        "NAME:BUSCH,CAROL",
        "BOX:F24",
        "ID:2012-0000154310");

    doTest("T9",
        "(HCCAD) [!] EOC:E11 MED PRE-ALERT 1938 HIGH POINT RD X CANNONGATE RD HAMMERBACHER,REBECCA",
        "UNIT:E11",
        "CALL:MED PRE-ALERT",
        "ADDR:1938 HIGH POINT RD",
        "X:CANNONGATE RD",
        "NAME:HAMMERBACHER,REBECCA");

    doTest("T10",
        "(HCCAD) [!] EOC:E11 SICK >SICK PERSON 1938 HIGH POINT RD XS: X CANNONGATE RD FOREST HILL HAMMERBACHER,REBECCA BOX: F26 Cad: 2012-0000154770",
        "UNIT:E11",
        "CALL:SICK PERSON",
        "ADDR:1938 HIGH POINT RD",
        "X:CANNONGATE RD",
        "CITY:FOREST HILL",
        "NAME:HAMMERBACHER,REBECCA",
        "BOX:F26",
        "ID:2012-0000154770");

    doTest("T11",
        "(HCCAD) [!] EOC:E11 UNK >UNKNOWN MEDICAL 201 KIMARY CT Apt: C Bldg XS: SPENCEOLA PKY FOREST HILL LIFE ALERT #723 BOX: 383 Cad: 2012-0000154851",
        "UNIT:E11",
        "CALL:UNKNOWN MEDICAL",
        "ADDR:201 KIMARY CT",
        "APT:C Bldg",
        "X:SPENCEOLA PKY",
        "CITY:FOREST HILL",
        "INFO:LIFE ALERT #723",
        "BOX:383",
        "ID:2012-0000154851");

    doTest("T12",
        "(HCCAD) [!] EOC:E11 SICK >SICK PERSON 1030 ROCK SPRING RD XS: HARFORD CO DETENTION CENTER BEL AIR S383 BOX: 351 Cad: 2012-0000154850",
        "UNIT:E11",
        "CALL:SICK PERSON",
        "ADDR:1030 ROCK SPRING RD",
        "X:HARFORD CO DETENTION CENTER",
        "CITY:BEL AIR",
        "NAME:S383",
        "BOX:351",
        "ID:2012-0000154850");

    doTest("T13",
        "(HCCAD) [!] EOC:E11 MED PRE-ALERT 2513 GREENE RD BALDWIN MILL RD SAMPLE,RONESSA",
        "UNIT:E11",
        "CALL:MED PRE-ALERT",
        "ADDR:2513 GREENE RD",
        "X:BALDWIN MILL RD",
        "NAME:SAMPLE,RONESSA");

    doTest("T14",
        "(HCCAD) [!] EOC:E11 RESP >RESPIRATORY DISTRESS 2513 GREENE RD XS: BALDWIN MILL RD BALDWIN SAMPLE,RONESSA BOX: F11 Cad: 2012-0000155044",
        "UNIT:E11",
        "CALL:RESPIRATORY DISTRESS",
        "ADDR:2513 GREENE RD",
        "X:BALDWIN MILL RD",
        "PLACE:BALDWIN",
        "NAME:SAMPLE,RONESSA",
        "BOX:F11",
        "ID:2012-0000155044");

    doTest("T15",
        "(HCCAD) [!] EOC:F11 RES >RESCUE NOT MVA 864 SMITH LN XS: CONNOLLY RD FALLSTON ANON BOX: 347 Cad: 2012-0000155045",
        "UNIT:F11",
        "CALL:RESCUE NOT MVA",
        "ADDR:864 SMITH LN",
        "X:CONNOLLY RD",
        "CITY:FALLSTON",
        "NAME:ANON",
        "BOX:347",
        "ID:2012-0000155045");

    doTest("T16",
        "(HCCAD) [!] EOC:E11 MUTBC >MUT AID BALTO CO BC 38-23 5 LAUREL MILL CT Cad: 2012-0000155581",
        "UNIT:E11",
        "CALL:MUT AID BALTO CO BC",
        "ADDR:38-23 5 LAUREL MILL CT",
        "MADDR:38 5 LAUREL MILL CT",
        "ID:2012-0000155581");

    doTest("T17",
        "(HCCAD) [!] EOC:E11 UNC >UNCONSCIOUS 1102 RED PUMP RD XS: GRAFTON SHOP RD BEL AIR TRACEY,JEFF BOX: 358 Cad: 2012-0000155628",
        "UNIT:E11",
        "CALL:UNCONSCIOUS",
        "ADDR:1102 RED PUMP RD",
        "X:GRAFTON SHOP RD",
        "CITY:BEL AIR",
        "NAME:TRACEY,JEFF",
        "BOX:358",
        "ID:2012-0000155628");

    doTest("T18",
        "(HCCAD) [!] EOC:E11 MVA >MV ACCIDENT W/INJURY SRT1&SRT152 XS: SRT152 FALLSTON Cad: 2012-0000155869",
        "UNIT:E11",
        "CALL:MV ACCIDENT W/INJURY",
        "ADDR:SRT1 & SRT152",
        "MADDR:MD 1 & MD 152",
        "X:SRT152",
        "CITY:FALLSTON",
        "ID:2012-0000155869");

    doTest("T19",
        "(HCCAD) [!] EOC:E11 MED PRE-ALERT 26 MOUNTAIN RD MILLS RD ALEXANDER,MARY",
        "UNIT:E11",
        "CALL:MED PRE-ALERT",
        "ADDR:26 MOUNTAIN RD",
        "X:MILLS RD",
        "NAME:ALEXANDER,MARY");

    doTest("T20",
        "(HCCAD) [!] EOC:E11 RESP >RESPIRATORY DISTRESS 26 MOUNTAIN RD XS: MILLS RD FALLSTON ALEXANDER,MARY BOX: F01 Cad: 2012-0000156728",
        "UNIT:E11",
        "CALL:RESPIRATORY DISTRESS",
        "ADDR:26 MOUNTAIN RD",
        "X:MILLS RD",
        "CITY:FALLSTON",
        "NAME:ALEXANDER,MARY",
        "BOX:F01",
        "ID:2012-0000156728");

    doTest("T21",
        "(HCCAD) [!] EOC:E11 MED PRE-ALERT 2505 DERBY DR PREAKNESS DR ZIEGLER,KELSEY",
        "UNIT:E11",
        "CALL:MED PRE-ALERT",
        "ADDR:2505 DERBY DR",
        "X:PREAKNESS DR",
        "NAME:ZIEGLER,KELSEY");

    doTest("T22",
        "(HCCAD) [!] EOC:E11 UNC >UNCONSCIOUS 2505 DERBY DR XS: PREAKNESS DR FALLSTON ZIEGLER,KELSEY BOX: F13 Cad: 2012-0000156752",
        "UNIT:E11",
        "CALL:UNCONSCIOUS",
        "ADDR:2505 DERBY DR",
        "X:PREAKNESS DR",
        "CITY:FALLSTON",
        "NAME:ZIEGLER,KELSEY",
        "BOX:F13",
        "ID:2012-0000156752");

    doTest("T23",
        "(HCCAD) [!] EOC:F11 FIRE PRE-ALERT 2530 HESS RD CANTERBURY LN CHAD",
        "UNIT:F11",
        "CALL:FIRE PRE-ALERT",
        "ADDR:2530 HESS RD",
        "X:CANTERBURY LN",
        "NAME:CHAD");

    doTest("T24",
        "(HCCAD) [!] EOC:F11 FIELD >FIELD/WOOD FIRE 2530 HESS RD XS: CANTERBURY LN FALLSTON CHAD BOX: F15 Cad: 2012-0000156832",
        "UNIT:F11",
        "CALL:FIELD/WOOD FIRE",
        "ADDR:2530 HESS RD",
        "X:CANTERBURY LN",
        "CITY:FALLSTON",
        "NAME:CHAD",
        "BOX:F15",
        "ID:2012-0000156832");

    doTest("T25",
        "(HCCAD) [!] EOC:E11 MED PRE-ALERT 2403 STONEYSIDE DR DEAD END KLEINSMITH,THERESA",
        "UNIT:E11",
        "CALL:MED PRE-ALERT",
        "ADDR:2403 STONEYSIDE DR",
        "PLACE:DEAD END",
        "NAME:KLEINSMITH,THERESA");

    doTest("T26",
        "(HCCAD) [!] EOC:E11 CVA >STROKE 2403 STONEYSIDE DR XS: DEAD END FALLSTON KLEINSMITH,THERESA BOX: F01 Cad: 2012-0000156860",
        "UNIT:E11",
        "CALL:STROKE",
        "ADDR:2403 STONEYSIDE DR",
        "X:DEAD END",
        "CITY:FALLSTON",
        "NAME:KLEINSMITH,THERESA",
        "BOX:F01",
        "ID:2012-0000156860");

    doTest("T27",
        "(HCCAD) [!] EOC:E11 MUTBC >MUT AID BALTO CO BCMB 38-11 13330 LONG GREEN PI Cad: 2012-0000156882",
        "UNIT:E11",
        "CALL:MUT AID BALTO CO BCMB",
        "ADDR:38-11 13330 LONG GREEN PI",
        "MADDR:38 13330 LONG GREEN PIKE",
        "ID:2012-0000156882");

    doTest("T28",
        "(HCCAD) [!] EOC:E11 SICK >SICK PERSON 118 NICHOLS ST Apt: F Bldg XS: WILLIAMS ST BEL AIR LASSAHN,CAROL J BOX: 305 Cad: 2012-0000157036",
        "UNIT:E11",
        "CALL:SICK PERSON",
        "ADDR:118 NICHOLS ST",
        "APT:F Bldg",
        "X:WILLIAMS ST",
        "CITY:BEL AIR",
        "NAME:LASSAHN,CAROL J",
        "BOX:305",
        "ID:2012-0000157036");

  }
  
  public static void main(String[] args) {
    new MDHarfordParserTest().generateTests("T1", "UNIT CALL ADDR APT X CITY PLACE INFO NAME BOX ID");
  }
}
