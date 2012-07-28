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
        "CITY:Mount Laurel",
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
    doTest("T12",
        "[DISPATCH]EMS E EMS Call LOC: 907 PLEASANT VALLEY AV VEN: Mt Laurel XS: EASTGATE DR/S CHURCH ST NATURE: FEM DIZZY & LIGHT HEADED 13:48:34 07/10/2012",
        "CALL:EMS E EMS Call",
        "ADDR:907 PLEASANT VALLEY AV",
        "MADDR:907 PLEASANT VALLEY AVE",
        "CITY:Mount Laurel",
        "X:EASTGATE DR/S CHURCH ST",
        "INFO:FEM DIZZY & LIGHT HEADED",
        "TIME:13:48:34",
        "DATE:07/10/2012");

    doTest("T13",
        "[DISPATCH]EMS E EMS Call LOC: 110 LAUREL LA VEN: Mt Laurel XS: LAUREL LA/HOLLY LA NATURE: FALL VIC,, LACERATION TO HEAD 18:16:26 07/05/2012",
        "CALL:EMS E EMS Call",
        "ADDR:110 LAUREL LA",
        "MADDR:110 LAUREL LN",
        "CITY:Mount Laurel",
        "X:LAUREL LA/HOLLY LA",
        "INFO:FALL VIC,, LACERATION TO HEAD",
        "TIME:18:16:26",
        "DATE:07/05/2012");

    doTest("T14",
        "[DISPATCH]132 E UnkMedEmrg LOC: 159 BIRCHFIELD CT A VEN: Mt Laurel XS: BIRCHFIELD DR/DEAD END NATURE: 71 YEAR OLD FEM/ACTIVATED ALERT/RUSKIN, 18:51:28 07/05/2012",
        "CALL:132 E UnkMedEmrg",
        "ADDR:159 BIRCHFIELD CT A",
        "CITY:Mount Laurel",
        "X:BIRCHFIELD DR/DEAD END",
        "INFO:71 YEAR OLD FEM/ACTIVATED ALERT/RUSKIN,",
        "TIME:18:51:28",
        "DATE:07/05/2012");

    doTest("T15",
        "[DISPATCH]EMS E EMS Call LOC: 13 GOLDENROD DR VEN: Mt Laurel XS: MORNING GLORY DR/ NATURE: F/FEELING WEAK 16:06:14 07/13/2012",
        "CALL:EMS E EMS Call",
        "ADDR:13 GOLDENROD DR",
        "CITY:Mount Laurel",
        "X:MORNING GLORY DR/",
        "INFO:F/FEELING WEAK",
        "TIME:16:06:14",
        "DATE:07/13/2012");

    doTest("T16",
        "[DISPATCH]EMS E EMS Call LOC: 3740 RT295 SB VEN: Mt Laurel XS: RT73 EXITS/RT38 EXITS NATURE: M/V ACCIDENT SHOULDER INJURY BLS ONLY 15:44:57 07/14/2012",
        "CALL:EMS E EMS Call",
        "ADDR:3740 RT295 SB",
        "MADDR:3740 RT 295",
        "CITY:Mount Laurel",
        "X:RT73 EXITS/RT38 EXITS",
        "INFO:M/V ACCIDENT SHOULDER INJURY BLS ONLY",
        "TIME:15:44:57",
        "DATE:07/14/2012");

    doTest("T17",
        "[DISPATCH]EMS E EMS Call LOC: 250 CENTURY PY VEN: Mt Laurel XS: FELLOWSHIP RD/FELLOWSHIP RD NATURE: EMPLOYEE W/HEADACHE / VOMITING // 12:48:33 07/18/2012",
        "CALL:EMS E EMS Call",
        "ADDR:250 CENTURY PY",
        "MADDR:250 CENTURY PKWY",
        "CITY:Mount Laurel",
        "X:FELLOWSHIP RD/FELLOWSHIP RD",
        "INFO:EMPLOYEE W/HEADACHE / VOMITING",
        "TIME:12:48:33",
        "DATE:07/18/2012");

    doTest("T18",
        "[DISPATCH]EMS E EMS Call LOC: 101 DIEMER DR VEN: Mt Laurel XS: CRAWFORD PL/PACILLI PL NATURE: CLLR COMING DOWN FROM ALCOHOL WITHDRAWAL 18:24:46 07/18/2012",
        "CALL:EMS E EMS Call",
        "ADDR:101 DIEMER DR",
        "CITY:Mount Laurel",
        "X:CRAWFORD PL/PACILLI PL",
        "INFO:CLLR COMING DOWN FROM ALCOHOL WITHDRAWAL",
        "TIME:18:24:46",
        "DATE:07/18/2012");

    doTest("T19",
        "[DISPATCH]EMS E EMS Call LOC: 121 WAVERLY AV VEN: Mt Laurel XS: FEDERAL ST/CHURCH RD NATURE: MVA OCCURED IN D10,,,ONE SUBJ W/FACIAL 13:40:27 06/25/2012",
        "CALL:EMS E EMS Call",
        "ADDR:121 WAVERLY AV",
        "MADDR:121 WAVERLY AVE",
        "CITY:Mount Laurel",
        "X:FEDERAL ST/CHURCH RD",
        "INFO:MVA OCCURED IN D10,,,ONE SUBJ W/FACIAL",
        "TIME:13:40:27",
        "DATE:06/25/2012");

    doTest("T20",
        "[DISPATCH]EMS E EMS Call LOC: 5711 ADELAIDE DR VEN: Mt Laurel XS: LINDALE DR/LINDALE DR NATURE: FEM POSS STROKE 08:17:02 06/25/2012",
        "CALL:EMS E EMS Call",
        "ADDR:5711 ADELAIDE DR",
        "CITY:Mount Laurel",
        "X:LINDALE DR/LINDALE DR",
        "INFO:FEM POSS STROKE",
        "TIME:08:17:02",
        "DATE:06/25/2012");
  }
  
  public static void main(String[] args) {
    new NJBurlingtonCountyFParserTest().generateTests("T1");
  }
}
  