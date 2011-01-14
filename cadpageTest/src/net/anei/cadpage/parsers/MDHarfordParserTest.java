package net.anei.cadpage.parsers;

import org.junit.Test;


public class MDHarfordParserTest extends BaseParserTest {
  
  public MDHarfordParserTest() {
    setParser(new MDHarfordParser(), "HARFORD", "MD");
  }
  
  @Test
  public void testParser() {
    
    doTest("T6",
        "Subject:HCCAD\n[!] EOC:F03 WIRES >WIRES/POLE SHAWNEE DR&WALTERS MILL RD XS: WALTERS MILL RD FOREST HILL NOT ENTERED Cad: 2010-000019169",
        "UNIT:F03",
        "CALL:WIRES/POLE",
        "ADDR:SHAWNEE DR & WALTERS MILL RD",
        "X:WALTERS MILL RD",
        "CITY:FOREST HILL",
        "ID:2010-000019169");

    
    
    doTest("T1",
        "[!] EOC:A1091 UNC >UNCONSCIOUS 2200 CHANNEL RD XS: X BIG BRANCH BRDG #127 PYLESVILLE CRIZER,KIM BOX: N08 Cad: 2010-0000162717",
        "UNIT:A1091",
        "CALL:UNCONSCIOUS",
        "ADDR:2200 CHANNEL RD",
        "X:BIG BRANCH BRDG #127",
        "CITY:PYLESVILLE",
        "BOX:N08",
        "ID:2010-0000162717");

    doTest("T2",
        "[!] EOC:A1091 SICK >SICK PERSON 1606 SCOTT RD XS: X FAWN GROVE RD PYLESVILLE BATCHELDER,MICHELLE BOX: N04 Cad: 2010-0000162427",
        "UNIT:A1091", 
        "CALL:SICK PERSON",
        "ADDR:1606 SCOTT RD",
        "X:FAWN GROVE RD",
        "CITY:PYLESVILLE",
        "BOX:N04",
        "ID:2010-0000162427");
    
    doTest("T3",        
        "[!] EOC:A1091 DIAB >DIABETIC EMRG. 2145 HARKINS RD XS: SAINT PAULS CHURCH RD PYLESVILLE ROHREAUGH,KEN BOX: N04 Cad: 2010-0000162445",
        "UNIT:A1091",
        "CALL:DIABETIC EMRG",
        "ADDR:2145 HARKINS RD",
        "X:SAINT PAULS CHURCH RD",
        "CITY:PYLESVILLE",
        "BOX:N04",
        "ID:2010-0000162445");
        
    doTest("T4",
        "[!] EOC:E1011 MISC >MISC 4873 CAREA RD XS: X WALNUT SPRING CT WHITE HALL SHERBS,ROBERT BOX: N08 Cad: 2010-0000162395",
        "UNIT:E1011",
        "CALL:MISC",
        "ADDR:4873 CAREA RD",
        "X:WALNUT SPRING CT",
        "CITY:WHITE HALL",
        "BOX:N08",
        "ID:2010-0000162395");
        
    doTest("T5",
        "[!] EOC:A1091 MVA >MV ACCIDENT W/INJURY SRT24&SAINT MARYS RD XS: SAINT MARYS RD PYLESVILLE DEDRICK.PATTI Cad: 2010-0000162161",
        "UNIT:A1091",
        "CALL:MV ACCIDENT W/INJURY",
        "ADDR:ST-24 & SAINT MARYS RD",
        "X:SAINT MARYS RD",
        "CITY:PYLESVILLE",
        "ID:2010-0000162161");
    
    doTest("T6",
        "Subject:HCCAD\n[!] EOC:F03 WIRES >WIRES/POLE SHAWNEE DR&WALTERS MILL RD XS: WALTERS MILL RD FOREST HILL NOT ENTERED Cad: 2010-000019169",
        "UNIT:F03",
        "CALL:WIRES/POLE",
        "ADDR:SHAWNEE DR & WALTERS MILL RD",
        "X:WALTERS MILL RD",
        "CITY:FOREST HILL",
        "ID:2010-000019169");

  }
}
