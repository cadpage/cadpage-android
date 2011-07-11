package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PADelawareCountyCParserTest extends BaseParserTest {
  
  public PADelawareCountyCParserTest() {
    setParser(new PADelawareCountyCParser(), "DELAWARE COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:[Update]\nF11032765\n06/09/2011\n04:13\nASSIST\nFD TO ASSIST EMS\n17 ELMWOOD AV\nS\n(Con't) 2 of 2\nELMWOOD AV\nMCKINLEY AV\n021/M100D/M100/027B\n~80YOM,Set Station Alarm activ\nFD\nFIRE\nANI/(End)",
        "ID:F11032765",
        "CALL:ASSIST - FD TO ASSIST EMS",
        "ADDR:17 ELMWOOD AV",
        "X:S ELMWOOD AV & MCKINLEY AV",
        "INFO:021/M100D/M100/027B / ~80YOM,Set Station Alarm activ / FD / FIRE / ANI/");

    doTest("T2",
        "1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11031554 \n06/03/2011 \n08:56 \nSTREET \nSTREET CLOSED \nW ASHLAND AV & N MACDADE BLVD \nW\n(Con't) 2 of 2\nASHLAND AV \nN MACDADE BLVD \nM100D/STA02/STA05/STA09/STA01 \nBETWEEN N WELLS AND MACDADE ON(End)",
        "ID:F11031554",
        "CALL:STREET - STREET CLOSED",
        "ADDR:W ASHLAND AV & N MACDADE BLVD",
        "INFO:M100D/STA02/STA05/STA09/STA01 / BETWEEN N WELLS AND MACDADE ON");

    doTest("T3",
        "1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11031406 \n06/02/2011 \n14:44 \nACC \nWITH INJURY REPORTED \n8TH AV & LINCOLN AV \n8TH\n(Con't) 2 of 2\nAV \nLINCOLN AV \n487/ENG08/027/M102A/RE08/071 \n610-461-1539,SEE THE MAN,STRIK \nFD \nFIRE \nCELL (End)",
        "ID:F11031406",
        "CALL:ACC - WITH INJURY REPORTED",
        "ADDR:8TH AV & LINCOLN AV",
        "INFO:487/ENG08/027/M102A/RE08/071 / 610-461-1539,SEE THE MAN,STRIK / FD / FIRE / CELL");

    doTest("T4",
        "1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11031265 \n06/01/2011 \n20:40 \nFIRE-BLD \nBUILDING FIRE, COMMERCIAL BLDG \n734 CHESTER\n(Con't) 2 of 2\nPKE \nPENNSYLVANIA AV \nNASSAU BLVD \nENG08/021/027/SN08/RE08/076/07 \n-075.305228 +039.883204 (End)",
        "ID:F11031265",
        "CALL:FIRE-BLD - BUILDING FIRE, COMMERCIAL BLDG",
        "ADDR:734 CHESTER PKE",
        "X:PENNSYLVANIA AV & NASSAU BLVD",
        "INFO:ENG08/021/027/SN08/RE08/076/07 / -075.305228 +039.883204");

    doTest("T5",
        "1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11031005 \n05/31/2011 \n18:14 \nFIRE-OTH \nFD INVESTIGATION \n241 W WINONA AV \nSYLVAN\n(Con't) 2 of 2\nAV \nTRITES AV \n021 \n-075.303855 +039.894780,~ GRIL \nFD \nFIRE \nANI/ALI \nRACHEL - SAME \nFIRE-OT(End)",
        "ID:F11031005",
        "CALL:FIRE-OTH - FD INVESTIGATION",
        "ADDR:241 W WINONA AV",
        "X:SYLVAN AV & TRITES AV",
        "INFO:021 / -075.303855 +039.894780,~ GRIL / FD / FIRE / ANI/ALI / RACHEL - SAME / FIRE-OT");

    doTest("T6",
        "1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11029356 \n05/24/2011 \n00:41 \nALARM \nCARBON MONOXIDE ALARM \n711 SOUTH AV \nUNNAMED\n(Con't) 2 of 2\nSTREET \nQUAINT ST \nARID7/027/RID7B/677C/MRID7/LA4 \nò~3¿ \nFD \nFIRE \nANI/ALI \nWARD MARGARET - (End)",
        "ID:F11029356",
        "CALL:ALARM - CARBON MONOXIDE ALARM",
        "ADDR:711 SOUTH AV",
        "X:UNNAMED STREET & QUAINT ST",
        "INFO:ARID7/027/RID7B/677C/MRID7/LA4 / ò~3¿ / FD / FIRE / ANI/ALI / WARD MARGARET -");

    doTest("T7",
        "1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11027808 \n05/16/2011 \n10:54 \nFIRE-BLD \nBUILDING FIRE, COMMERCIAL BLDG \n701 ASHLAND AV\n(Con't) 2 of 2\n22 \nDELMAR DR \nCARPENTERS CROSSING \nM06/012/017/027A/091/ENG05/TW0 \nMULTIPLE BUSINESSES (End)",
        "ID:F11027808",
        "CALL:FIRE-BLD - BUILDING FIRE, COMMERCIAL BLDG",
        "ADDR:701 ASHLAND AV 22",
        "X:DELMAR DR & CARPENTERS CROSSING",
        "INFO:M06/012/017/027A/091/ENG05/TW0 / MULTIPLE BUSINESSES");
  }
  
  public static void main(String[] args) {
    new PADelawareCountyCParserTest().generateTests("T1");
  }
}
