package net.anei.cadpage.parsers.NJ;

                                                                                                                                                                                                                                                                                                                                                                                                           

import net.anei.cadpage.parsers.BaseParserTest;
import org.junit.Test;


public class NJBurlingtonCountyFParserTest extends BaseParserTest {
  
  public NJBurlingtonCountyFParserTest() {
    setParser(new NJBurlingtonCountyFParser(), "Willngboro", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "EMS E EMS Call Loc: 20 WOODHAVEN LA Ven: Willingbor XS: WINDOVER LA/WELDON LA Nature: CHANGE IN MENTAL STATUS 07:03:09 06/27/2012",
        "CALL:EMS E EMS Call",
        "ADDR:20 WOODHAVEN LA",
        "CITY:Willingbor",
        "X:WINDOVER LA/WELDON LA",
        "INFO:CHANGE IN MENTAL STATUS",
        "TIME:07:03:09",
        "DATE:06/27/2012");
    
    doTest("T2",
        "EMS E EMS Call Loc: 4 THORNHILL LA Ven: Willingbor XS: TYLER DR/TREBING LA Nature: FM/DECEASED 08:29:39 06/27/2012",
        "CALL:EMS E EMS Call",
        "ADDR:4 THORNHILL LA",
        "CITY:Willingbor",
        "X:TYLER DR/TREBING LA",
        "INFO:FM/DECEASED",
        "TIME:08:29:39",
        "DATE:06/27/2012");
    
    doTest("T3",
        "EMS E EMS Call Loc: 15 BLUEBERRY LA Ven: Willingbor XS: BABBITT LA/BRADFORD LA Nature: 7MT PREGNANT /FALL VICTIM/SPOTTING 08:42:37 06/27/2012",
        "CALL:EMS E EMS Call",
        "ADDR:15 BLUEBERRY LA",
        "CITY:Willingbor",
        "X:BABBITT LA/BRADFORD LA",
        "INFO:7MT PREGNANT /FALL VICTIM/SPOTTING",
        "TIME:08:42:37",
        "DATE:06/27/2012");
    
    doTest("T4",
        "EMS E EMS Call Loc: 32 TWISTING LA Ven: Willingbor XS: TOWER LA/TOBIN CT Nature: ILL 09:12:53 06/27/2012",
        "CALL:EMS E EMS Call",
        "ADDR:32 TWISTING LA",
        "CITY:Willingbor",
        "X:TOWER LA/TOBIN CT",
        "INFO:ILL",
        "TIME:09:12:53",
        "DATE:06/27/2012");
    
    doTest("T5",
        "EMS E EMS Call Loc: 1103 MILLENNIUM WY Ven: Willingbor XS: VANSCIVER PY/LEVITT PY Nature: SICK / NEEDS TO GO TO HOSPITAL // 09:43:41 06/27/2012",
        "CALL:EMS E EMS Call",
        "ADDR:1103 MILLENNIUM WY",
        "CITY:Willingbor",
        "X:VANSCIVER PY/LEVITT PY",
        "INFO:SICK / NEEDS TO GO TO HOSPITAL //",
        "TIME:09:43:41",
        "DATE:06/27/2012");
    
    doTest("T6",
        "12 F StrNonFire Loc: 73 BROOKLAWN DR Ven: Willingbor XS: BUCKNELL LA/BABBITT LA Nature: OVEN FIRE 18:17:21 06/26/2012",
        "CALL:12 F StrNonFire",
        "ADDR:73 BROOKLAWN DR",
        "CITY:Willingbor",
        "X:BUCKNELL LA/BABBITT LA",
        "INFO:OVEN FIRE",
        "TIME:18:17:21",
        "DATE:06/26/2012");
  }
  
  public static void main(String[] args) {
    new NJBurlingtonCountyFParserTest().generateTests("T1");
  }
}
  