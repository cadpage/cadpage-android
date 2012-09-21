package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHPortageCountyParserTest extends BaseParserTest {
  
  public OHPortageCountyParserTest() {
    setParser(new OHPortageCountyParser(), "PORTAGE", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "911@ci.ravenna.oh.us:* 15_edinburg_general29,MEDICAL EMERGENCY *\n" +
        "3594,INDRUSTRY RD, * ,ROOTSTOWN * 89YOA MALE OXYGEN MACHINE BROKEN,\n" +
        "TROU",

        "CALL:MEDICAL EMERGENCY",
        "ADDR:3594 INDRUSTRY RD",
        "CITY:ROOTSTOWN",
        "INFO:89YOA MALE OXYGEN MACHINE BROKEN, TROU");

    doTest("T2",
        "911@ci.ravenna.oh.us:* 15_edinburg_general29,MEDICAL EMERGENCY * 4265,ROCK SPRING RD, * ,Ravenna * 53 YR OLD MALE DIFFICULTY BREATHING, PO",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4265 ROCK SPRING RD",
        "CITY:Ravenna",
        "INFO:53 YR OLD MALE DIFFICULTY BREATHING, PO");

    doTest("T3",
        "911@ci.ravenna.oh.us:* 15_edinburg_generalMA,MUTUAL AID * 0,PALMYRA TOWNSHIP [EDIT], * PALMYRA,Ravenna * 1511 TO MEET 2011 AT STATION 20",
        "CALL:MUTUAL AID",
        "ADDR:PALMYRA TOWNSHIP [EDIT]",
        "CITY:PALMYRA Ravenna",
        "INFO:1511 TO MEET 2011 AT STATION 20");

    doTest("T4",
        "911@ci.ravenna.oh.us:* 15_edinburg_general29,MEDICAL EMERGENCY * 7824,TALLMADGE RD, * ,Ravenna * 80 YOA FEMALE CHEST PAINS﻿",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:7824 TALLMADGE RD",
        "CITY:Ravenna",
        "INFO:80 YOA FEMALE CHEST PAINS﻿");

    doTest("T5",
        "911@ci.ravenna.oh.us:* 15_edinburg_general29,MEDICAL EMERGENCY * 4174,PORTER RD , * ,EDINBURG TWP * FEMALE VERY LIGHT HEADED﻿",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4174 PORTER RD",
        "CITY:EDINBURG TWP",
        "INFO:FEMALE VERY LIGHT HEADED﻿");

    doTest("T6",
        "911@ci.ravenna.oh.us:* 15_edinburg_general29,MEDICAL EMERGENCY * 3594,INDUSTRY RD, * ,ROOTSTOWN * 89 YOA MALE FALLEN",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:3594 INDUSTRY RD",
        "CITY:ROOTSTOWN",
        "INFO:89 YOA MALE FALLEN");

    doTest("T7",
        "911@ci.ravenna.oh.us:* 15_edinburg_general28,FIRE * 4907,ROCK SPRING RD, * ,Ravenna * CHIMNEY FIRE﻿",
        "CALL:FIRE",
        "ADDR:4907 ROCK SPRING RD",
        "CITY:Ravenna",
        "INFO:CHIMNEY FIRE﻿");
    
  }
  
  public static void main(String[] args) {
    new OHPortageCountyParserTest().generateTests("T1");
  }
}