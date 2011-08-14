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
        "X:BIG BRANCH BRDG #127",
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
        "CALL:DIABETIC EMRG",
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
        "ADDR:ST-24 & SAINT MARYS RD",
        "X:SAINT MARYS RD",
        "CITY:PYLESVILLE",
        "NAME:DEDRICKPATTI",
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
        "X:CHESTNUT HILL RD",
        "CITY:FOREST HILL",
        "NAME:THOMPSON,DOUG",
        "ID:2011-0000122811");

    doTest("T10",
        "FRM:rc.95@c-msg.net\nSUBJ:HCCAD\nMSG:[!] EOC:E91 HEART >HEART PROBLEM SRT155&SRT161 XS: SRT161 HAVRE DE GRACE Cad:143258\n",
        "UNIT:E91",
        "CALL:HEART PROBLEM",
        "ADDR:ST-155 & SRT161",
        "X:SRT161",
        "CITY:HAVRE DE GRACE",
        "ID:143258");
  }
  
  public static void main(String[] args) {
    new MDHarfordParserTest().generateTests("T10", "UNIT CALL ADDR APT X CITY NAME BOX ID");
  }
}
