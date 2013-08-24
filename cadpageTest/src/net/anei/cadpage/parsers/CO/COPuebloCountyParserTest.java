package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.CO.COPuebloCountyParser;

import org.junit.Test;

/*
Pueblo RFD, CO
Contact: Steven Passig <giz5312@gmail.com>
Sender: surepage@wdsl.us
System: Spillman mobile
(Page ) 12:43PM 11/28 RURAL FIRE in the area of 1543 Cooper Pl report of heavy smoke no flames showing...kr
(Page ) 04:26PM 12/13 rural fire:  hwy 50 & 27th ln; north side, 10 ft fire...tdb
(Page ) 04:52PM 11/27 ATTN RURAL FIRE: 28141 south rd....male poss overdose...jaa
(Page ) 09:18AM 12/11 rural fire  33550 hwy 96 E Lot 379 35 yof convulsions
(Page ) 11:45PM 11/15 ATTN RURAL FIRE: 1917 n santa fe ave...at the car wash....39yof...seizure...jaa


Contact: Giz <passig5312@hotmail.com>
(Page ) rural fire...23090 gale rd female with chest pain
(Page ) 328 avondale blvd; 16 yom passed out earlier today, cant talk now... go in side door...smb
(Page ) Attn Rural Fire...27767 Hwy 50 E.... 89 yof passed out...rach
(Page ) RURAL  75 yof breathing diff  1130 WAGO DR
(Page ) attn pueblo rural fire 27025 tourchey way female dizzy and not feeling good
(Page ) 31918 hwy 96 e; loaf & jug; fem dizzy; almost fainted...tdb

Contact: Willie Martin <willismart84@gmail.com>
Sender: surepage@wdsl.us
(Page ) 2027 zinno blvd; medical alarm on 71 yof c/o diff breathing. fem has copd and on oxygen. kcq

*/

public class COPuebloCountyParserTest extends BaseParserTest {
  
  public COPuebloCountyParserTest() {
    setParser(new COPuebloCountyParser(), "PUEBLO COUNTY", "CO");
  }
  
  @Test
  public void test1Parser() {
    
    doTest("T1",
        "(Page ) 12:43PM 11/28 RURAL FIRE in the area of 1543 Cooper Pl report of heavy smoke no flames showing...kr",
        "ADDR:1543 Cooper Pl",
        "CALL:RURAL FIRE in the area of",
        "INFO:report of heavy smoke no flames showing");
    
    doTest("T2",
        "(Page ) 04:26PM 12/13 rural fire:  hwy 50 & 27th ln; north side, 10 ft fire...tdb",
        "ADDR:hwy 50 & 27th ln",
        "CALL:rural fire:",
        "INFO:north side, 10 ft fire");
    
    doTest("T3", 
        "(Page ) 04:52PM 11/27 ATTN RURAL FIRE: 28141 south rd....male poss overdose...jaa",
        "ADDR:28141 south rd",
        "CALL:ATTN RURAL FIRE:",
        "INFO:male poss overdose");
    
    doTest("T4",
        "(Page ) 09:18AM 12/11 rural fire  33550 hwy 96 E Lot 379 35 yof convulsions",
        "ADDR:33550 hwy 96 E",
        "CALL:rural fire",
        "APT:379",
        "INFO:35 yof convulsions");
    
    doTest("T5",
        "(Page ) 11:45PM 11/15 ATTN RURAL FIRE: 1917 n santa fe ave...at the car wash....39yof...seizure...jaa",
        "ADDR:1917 n santa fe ave",
        "CALL:ATTN RURAL FIRE:",
        "INFO:at the car wash / 39yof / seizure");
  }
  
  @Test
  public void test2Parser() {

    doTest("T1",
        "(Page ) rural fire...23090 gale rd female with chest pain",
        "CALL:rural fire",
        "ADDR:23090 gale rd",
        "INFO:female with chest pain");

    doTest("T2",
        "(Page ) 328 avondale blvd; 16 yom passed out earlier today, cant talk now... go in side door...smb",
        "ADDR:328 avondale blvd",
        "INFO:16 yom passed out earlier today, cant talk now / go in side door");

    doTest("T3",
        "(Page ) Attn Rural Fire...27767 Hwy 50 E.... 89 yof passed out...rach",
        "CALL:Attn Rural Fire",
        "ADDR:27767 Hwy 50 E",
        "INFO:89 yof passed out");

    doTest("T4",
        "(Page ) RURAL  75 yof breathing diff  1130 WAGO DR",
        "ADDR:1130 WAGO DR",
        "CALL:RURAL  75 yof breathing diff");

    doTest("T5",
        "(Page ) attn pueblo rural fire 27025 tourchey way female dizzy and not feeling good",
        "CALL:attn pueblo rural fire",
        "ADDR:27025 tourchey way",
        "INFO:female dizzy and not feeling good");

    doTest("T6",
        "(Page ) 31918 hwy 96 e; loaf & jug; fem dizzy; almost fainted...tdb",
        "ADDR:31918 hwy 96 e",
        "INFO:loaf & jug / fem dizzy / almost fainted");

    doTest("T7",
        "(Page ) 2027 zinno blvd; medical alarm on 71 yof c/o diff breathing. fem has copd and on oxygen. kcq",
        "ADDR:2027 zinno blvd",
        "INFO:medical alarm on 71 yof c/o diff breathing. fem has copd and on oxygen. kcq");
   
  }
  
  public static void main(String[] args) {
    new COPuebloCountyParserTest().generateTests("T1");
  }
}   