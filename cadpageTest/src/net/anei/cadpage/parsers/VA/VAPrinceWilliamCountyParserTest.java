package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.VA.VAPrinceWilliamCountyParser;

import org.junit.Test;


public class VAPrinceWilliamCountyParserTest extends BaseParserTest {
  
  public VAPrinceWilliamCountyParserTest() {
    setParser(new VAPrinceWilliamCountyParser(), "PRINCE WILLIAM COUNTY", "VA");
  }
  
  @Test
  public void testParser() {
    doTest("T1", 
        "29-Oct-2010/11:07:25/OUTF/15742 DUMFRIES RD / 15726 CARRS BROOKE WY ,PWC /17/E517 STA17 /ON NB  DUMFRIES RD  / BTW CARRS BROOK AND TODDBURY",
        "CALL:OUTF",
        "ADDR:15742 DUMFRIES RD",
        "X:15726 CARRS BROOKE WY",
        "BOX:17",
        "UNIT:E517 STA17",
        "INFO:ON NB  DUMFRIES RD / BTW CARRS BROOK AND TODDBURY");
    doTest("T2",
        "29-Oct-2010/10:38:09/FALARM/15750 NORRIS POINT WY ,PWC /23/E510B STA23 TW512 /LANDING AT MARKHAM  /// 703-580-8121 /  GENERAL ALARM [72]",
        "CALL:FALARM",
        "ADDR:15750 NORRIS POINT WY",
        "BOX:23",
        "UNIT:E510B STA23 TW512",
        "INFO:LANDING AT MARKHAM / 703-580-8121 / GENERAL ALARM [72]");
    doTest("T3",
        "29-Oct-2010/09:41:32/INVEST/18911 FULLER HEIGHTS RD ,PWC /03F/E503B STA03F /CABLE LYING ON THE ROUND - BOTH ENDS ARE CONNECTED TO POLES - NO",
        "CALL:INVEST",
        "ADDR:18911 FULLER HEIGHTS RD",
        "BOX:03F",
        "UNIT:E503B STA03F",
        "INFO:CABLE LYING ON THE ROUND - BOTH ENDS ARE CONNECTED TO POLES - NO");
        

  }

}
