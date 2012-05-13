package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAChesterCountyGParserTest extends BaseParserTest {
  
  public PAChesterCountyGParserTest() {
    setParser(new PAChesterCountyGParser(), "CHESTER COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

     doTest("T1",
         "Inc History #NCCF12000028           \n" +
         "                      \n" +
         " Entered      04/17/12  13:15:35  BY FD16     135    \n" +
         " Dispatched   04/17/12  13:15:42  BY FD16     135    \n\n" +
         " Initial Type: RELOCAT    Final Type: RELOCAT (RELOCATE FIRE/EMS UNITS)\n" +
         " Initial Priority: 3      Final Priority: 3 \n" +
         " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
         " Disposition:        Source: T    Primary Unit: ENG22       Rsp: 0099  \n" +
         " Police BOX:   Fire BOX:   EMS BOX:  \n" +
         " Group: C88F          Section:   Map:          X: 0000000  Y: 0000000\n\n" +
         " Loc: NCC STA19   (NV)\n" +
         " AKA:   Municipality:        Dev: \n" +
         " Name: NCC ENG19               Addr:                         PH:                \n\n" +
         "/1315  (135   )  ENTRY            NO FURTHER INFORMATION\n" +
         "/1315            DISP    ENG242    #ENG242 ENG242 MDT \n" +
         "/1323           $PREMPT  ENG242   \n" +
         "/1323           $DISP    ENG22     #ENG22  ENG22 MDT \n" +
         "/1323            EXCH    ENG242   ENG22    \n" +
         "PRIOR PREMISE HISTORY FOR: NCC STA19                                         \n\n" +
         "No Prior Premise History found for the Location",

         "ID:NCCF12000028",
         "DATE:04/17/12",
         "TIME:13:15:42",
         "CALL:RELOCAT (RELOCATE FIRE/EMS UNITS)",
         "ADDR:NCC STA19 (NV)",
         "NAME:NCC ENG19",
         "INFO:NO FURTHER INFORMATION",
         "UNIT:NG242 NG22");

     doTest("T2",
         "Inc History #WGRF12000543  Xref: #58PJ12000321\n\n" +
         " Entered      04/26/12  06:09:05  BY CT09     693\n" +
         " Dispatched   04/26/12  06:09:53  BY FD16     157\n" +
         " Initial Type: ACCENT     Final Type: ACCENT  (ACCIDENT - ENTRAPMENT *)\n" +
         " Initial Priority: E      Final Priority: E\n" +
         " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
         " Disposition:        Source: T    Primary Unit: RES22       Rsp: 0002\n" +
         " Police BOX: 5802  Fire BOX: 2204  EMS BOX: 2204\n" +
         " Group: 22FD          Section: 22     Map:          X: 7586988  Y: 3982389\n" +
         " Loc: OLD BALTIMORE PK/RT 796 ,58    (V)\n" +
         " AKA:                            Municipality: PENN\n" +
         "Dev:\n" +
         " Name:                         Addr:                         PH:\n" +
         "610-633-8998C\n" +
         "/0609  (693   )  ENTRY            2 VEHS -- HEAD ON COLLISION -- ENTRAPMENT\n" +
         "/0609            ENTRY            DETAILS TO FOLLOW\n" +
         "/0609  (157   )  DTSEEN           INFO SEEN\n" +
         "/0609            DISP    RES22     #RES22  RES22 MDT\n" +
         "/0609            ASST    ENG22     #ENG22  ENG22 MDT\n" +
         "/0609            ASST    AMB221    #AMB221 AMB221 MDT\n" +
         "/0609            ASST    MED941    #MED941 MED941 MDT\n" +
         "/0609            ASST    ENG12     #ENG12  ENG12 MDT\n" +
         "/0609            ASST    AMB222    #AMB222 AMB222 MDT\n" +
         "/0609            ASST    ENG32     #ENG32  ENG32 MDT\n" +
         "PRIOR PREMISE HISTORY FOR: OLD BALTIMORE PK/RT 796\n" +
         ",58\n" +
         "No Prior Premise History found for the Location\n" +
         "*** List of closest hydrants\n" +
         "***\n" +
         " Inc #WGRF12000543 Type: ACCENT  Loc: OLD BALTIMORE PK/RT 796 ,58\n" +
         " ID   STAT  GPM   LOCATION\n" +
         "58-014      0      835 W BALTIMORE PK, 58\n\n" +
         "58-013      0      835 W BALTIMORE PK, 58\n\n" +
         "58-012      0      835 W BALTIMORE PK, 58\n\n" +
         "58-011      0      835 W BALTIMORE PK, 58",

         "ID:WGRF12000543",
         "DATE:04/26/12",
         "TIME:06:09:53",
         "CALL:ACCENT  (ACCIDENT - ENTRAPMENT *)",
         "BOX:F:2204 E:2204",
         "ADDR:OLD BALTIMORE PK & RT 796",
         "MADDR:OLD BALTIMORE PIKE & RT 796",
         "CITY:PENN TWP",
         "PHONE:610-633-8998C",
         "INFO:2 VEHS -- HEAD ON COLLISION -- ENTRAPMENT\nDETAILS TO FOLLOW",
         "UNIT:ES22 NG22 MB221 ED941 NG12 MB222 NG32");

     doTest("T3",
         " Inc History #WGRF12000549  Xref: #59PJ12000174\n\n" +
         " Entered      04/27/12  23:31:33  BY CT08     663\n" +
         " Dispatched   04/27/12  23:32:07  BY FD16     135\n\n" +
         " Initial Type: INVOUT     Final Type: INVOUT  (SMOKE/ODOR INVEST (OUTSIDE)\n" +
         "*)\n" +
         " Initial Priority: 1      Final Priority: 1\n" +
         " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
         " Disposition:        Source: T    Primary Unit: ENG22       Rsp: 0026\n" +
         " Police BOX: 59BP  Fire BOX: 2202  EMS BOX: 2202\n" +
         " Group: 22FD          Section: 22     Map: 45D7     X: 7580925  Y: 3983699\n\n" +
         " Loc: 160 SB RT 1 BP ,59  btwn CHATHAM RD & BAKER STATION RD (V)\n" +
         " AKA: KENNETT OXFORD BP  Municipality: LGROVE Dev:\n" +
         " Name: WERTZ, JONATHON         Addr: 343 LEA DR              PH:\n" +
         "610-812-0021\n\n" +
         "/2331  (663   )  ENTRY            LOOKED LIKE WHAREHOUSE MIGHT HAVE BEEN ON\n" +
         "FIRE\n" +
         "                                   ONLY SAW WHITE COLORED SMOKE WHILE\n" +
         "DRIVING BY\n" +
         "/2332  (135   )  DISP    ENG22     #ENG22  ENG22 MDT\n" +
         "/2332            ASST    LAD22     #LAD22  LAD22 MDT\n" +
         "/2332            ASST    ENG12     #ENG12  ENG12 MDT\n" +
         "/2332            ASST    ENG32     #ENG32  ENG32 MDT\n" +
         "PRIOR PREMISE HISTORY FOR: 160 SB RT 1 BP\n" +
         ",59\n\n" +
         "No Prior Premise History found for the Location",

         "ID:WGRF12000549",
         "DATE:04/27/12",
         "TIME:23:32:07",
         "CALL:INVOUT  (SMOKE/ODOR INVEST (OUTSIDE) *)",
         "BOX:F:2202 E:2202",
         "MAP:45D7",
         "PLACE:KENNETT OXFORD BP",
         "ADDR:160 SB RT 1 BP",
         "MADDR:160 RT 1 BYPASS",
         "CITY:LONDON GROVE TWP",
         "X:CHATHAM RD & BAKER STATION RD (V)",
         "NAME:WERTZ, JONATHON (343 LEA DR)",
         "PHONE:610-812-0021",
         "INFO:LOOKED LIKE WHAREHOUSE MIGHT HAVE BEEN ON FIRE ONLY SAW WHITE COLORED SMOKE WHILE DRIVING BY",
         "UNIT:NG22 AD22 NG12 NG32");
    
  }
  
  public static void main(String[] args) {
    new PAChesterCountyGParserTest().generateTests("T1", "SRC ID DATE TIME CALL BOX MAP PLACE ADDR APT CITY X NAME PHONE INFO UNIT");
  }
}