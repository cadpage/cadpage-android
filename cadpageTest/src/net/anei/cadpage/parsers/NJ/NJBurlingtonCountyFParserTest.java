package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;
import org.junit.Test;

public class NJBurlingtonCountyFParserTest extends BaseParserTest {
  
  public NJBurlingtonCountyFParserTest() {
    setParser(new NJBurlingtonCountyFParser(), "BURLINGTON COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[MLCAD] EMS E EMS Call Loc: 5142 CHURCH RD Ven: Mt Laurel XS: PREAKNESS DR/SHARP RD Nature: SON IS CHOKING // 15:44:31 02/14/2012",
        "CALL:EMS E EMS Call",
        "ADDR:5142 CHURCH RD",
        "CITY:Mt Laurel",
        "X:PREAKNESS DR/SHARP RD",
        "INFO:SON IS CHOKING",
        "TIME:15:44:31",
        "DATE:02/14/2012");

    doTest("T2",
        "EMS E EMS Call Loc: 20 WOODHAVEN LA Ven: Willingbor XS: WINDOVER LA/WELDON LA Nature: CHANGE IN MENTAL STATUS 07:03:09 06/27/2012",
        "CALL:EMS E EMS Call",
        "ADDR:20 WOODHAVEN LA",
        "MADDR:20 WOODHAVEN LN",
        "CITY:Willingboro",
        "X:WINDOVER LA/WELDON LA",
        "INFO:CHANGE IN MENTAL STATUS",
        "TIME:07:03:09",
        "DATE:06/27/2012");

    doTest("T3",
        "EMS E EMS Call Loc: 4 THORNHILL LA Ven: Willingbor XS: TYLER DR/TREBING LA Nature: FM/DECEASED 08:29:39 06/27/2012",
        "CALL:EMS E EMS Call",
        "ADDR:4 THORNHILL LA",
        "MADDR:4 THORNHILL LN",
        "CITY:Willingboro",
        "X:TYLER DR/TREBING LA",
        "INFO:FM/DECEASED",
        "TIME:08:29:39",
        "DATE:06/27/2012");

    doTest("T4",
        "EMS E EMS Call Loc: 15 BLUEBERRY LA Ven: Willingbor XS: BABBITT LA/BRADFORD LA Nature: 7MT PREGNANT /FALL VICTIM/SPOTTING 08:42:37 06/27/2012",
        "CALL:EMS E EMS Call",
        "ADDR:15 BLUEBERRY LA",
        "MADDR:15 BLUEBERRY LN",
        "CITY:Willingboro",
        "X:BABBITT LA/BRADFORD LA",
        "INFO:7MT PREGNANT /FALL VICTIM/SPOTTING",
        "TIME:08:42:37",
        "DATE:06/27/2012");

    doTest("T5",
        "EMS E EMS Call Loc: 32 TWISTING LA Ven: Willingbor XS: TOWER LA/TOBIN CT Nature: ILL 09:12:53 06/27/2012",
        "CALL:EMS E EMS Call",
        "ADDR:32 TWISTING LA",
        "MADDR:32 TWISTING LN",
        "CITY:Willingboro",
        "X:TOWER LA/TOBIN CT",
        "INFO:ILL",
        "TIME:09:12:53",
        "DATE:06/27/2012");

    doTest("T6",
        "EMS E EMS Call Loc: 1103 MILLENNIUM WY Ven: Willingbor XS: VANSCIVER PY/LEVITT PY Nature: SICK / NEEDS TO GO TO HOSPITAL // 09:43:41 06/27/2012",
        "CALL:EMS E EMS Call",
        "ADDR:1103 MILLENNIUM WY",  // Google calls this Millennium Dr
        "CITY:Willingboro",
        "X:VANSCIVER PY/LEVITT PY",
        "INFO:SICK / NEEDS TO GO TO HOSPITAL",
        "TIME:09:43:41",
        "DATE:06/27/2012");

    doTest("T7",
        "12 F StrNonFire Loc: 73 BROOKLAWN DR Ven: Willingbor XS: BUCKNELL LA/BABBITT LA Nature: OVEN FIRE 18:17:21 06/26/2012",
        "CALL:12 F StrNonFire",
        "ADDR:73 BROOKLAWN DR",
        "CITY:Willingboro",
        "X:BUCKNELL LA/BABBITT LA",
        "INFO:OVEN FIRE",
        "TIME:18:17:21",
        "DATE:06/26/2012");

    doTest("T8",
        "FIRE F Fire Call Loc: 45 HOPEWELL LA Ven: Willingbor XS: HANCOCK LA/HARGROVE LA Nature: GARAGE ON FIRE 17:42:38 06/26/2012",
        "CALL:FIRE F Fire Call",
        "ADDR:45 HOPEWELL LA",
        "MADDR:45 HOPEWELL LN",
        "CITY:Willingboro",
        "X:HANCOCK LA/HARGROVE LA",
        "INFO:GARAGE ON FIRE",
        "TIME:17:42:38",
        "DATE:06/26/2012");

    doTest("T9",
        "EMS E EMS Call Loc: 37 HUMMINGBIRD LA Ven: Willingbor XS: HUNTINGTON LA/HAMPSHIRE LA Nature: STOMACH AND BACK AND LEG PAIN 16:07:00 06/26/2012",
        "CALL:EMS E EMS Call",
        "ADDR:37 HUMMINGBIRD LA",
        "MADDR:37 HUMMINGBIRD LN",
        "CITY:Willingboro",
        "X:HUNTINGTON LA/HAMPSHIRE LA",
        "INFO:STOMACH AND BACK AND LEG PAIN",
        "TIME:16:07:00",
        "DATE:06/26/2012");

    doTest("T10",
        "EMS E EMS Call Loc: 20 BUTTERCUP LA Ven: Willingbor XS: BRADFORD LA/BROOKLAWN DR Nature: FEM BROKEN ANKLE//IS DIABETIC 15:42:24 06/26/2012",
        "CALL:EMS E EMS Call",
        "ADDR:20 BUTTERCUP LA",
        "MADDR:20 BUTTERCUP LN",
        "CITY:Willingboro",
        "X:BRADFORD LA/BROOKLAWN DR",
        "INFO:FEM BROKEN ANKLE//IS DIABETIC",
        "TIME:15:42:24",
        "DATE:06/26/2012");

    doTest("T11",
        "EMS E EMS Call Loc: 55 SUNSET RD Ven: Willingbor XS: STRETTON CL/SIDNEY LA Nature: TENANT HAVING STOMACH PAIN // 11:08:43 06/27/2012",
        "CALL:EMS E EMS Call",
        "ADDR:55 SUNSET RD",
        "CITY:Willingboro",
        "X:STRETTON CL/SIDNEY LA",
        "INFO:TENANT HAVING STOMACH PAIN",
        "TIME:11:08:43",
        "DATE:06/27/2012");
  
  }
  
  public static void main(String[] args) {
    new NJBurlingtonCountyFParserTest().generateTests("T1");
  }
}
  