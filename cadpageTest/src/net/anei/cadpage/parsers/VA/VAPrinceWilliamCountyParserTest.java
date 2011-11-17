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
        "DATE:29-Oct-2010",
        "TIME:11:07:25",
        "CODE:OUTF",
        "CALL:Outside Fire",
        "ADDR:15742 DUMFRIES RD",
        "X:15726 CARRS BROOKE WY",
        "BOX:17",
        "UNIT:E517 STA17",
        "INFO:ON NB  DUMFRIES RD / BTW CARRS BROOK AND TODDBURY");

    doTest("T2",
        "29-Oct-2010/10:38:09/FALARM/15750 NORRIS POINT WY ,PWC /23/E510B STA23 TW512 /LANDING AT MARKHAM  /// 703-580-8121 /  GENERAL ALARM [72]",
        "DATE:29-Oct-2010",
        "TIME:10:38:09",
        "CODE:FALARM",
        "CALL:Fire Alarm",
        "ADDR:15750 NORRIS POINT WY",
        "BOX:23",
        "UNIT:E510B STA23 TW512",
        "INFO:LANDING AT MARKHAM / 703-580-8121 / GENERAL ALARM",
        "ID:72");

    doTest("T3",
        "29-Oct-2010/09:41:32/INVEST/18911 FULLER HEIGHTS RD ,PWC /03F/E503B STA03F /CABLE LYING ON THE ROUND - BOTH ENDS ARE CONNECTED TO POLES - NO",
        "DATE:29-Oct-2010",
        "TIME:09:41:32",
        "CODE:INVEST",
        "CALL:Investigation",
        "ADDR:18911 FULLER HEIGHTS RD",
        "BOX:03F",
        "UNIT:E503B STA03F",
        "INFO:CABLE LYING ON THE ROUND - BOTH ENDS ARE CONNECTED TO POLES - NO");

    doTest("T4",
        "29-Oct-2010/02:17:37/SICA/17428 KAGERA DR ,PWC /03R/E503B M503 STA03R /DAD HAVING POSS HEART ATTACK/ [60]",
        "DATE:29-Oct-2010",
        "TIME:02:17:37",
        "CODE:SICA",
        "CALL:Sickness - ALS",
        "ADDR:17428 KAGERA DR",
        "BOX:03R",
        "UNIT:E503B M503 STA03R",
        "INFO:DAD HAVING POSS HEART ATTACK",
        "ID:60");

    doTest("T5",
        "29-Oct-2010/09:21:10/UNC/18303 OLD TRIANGLE RD ,PWC /03R/E503B E523 M503 STA03R female screaming something is wrong w male in t he house .",
        "DATE:29-Oct-2010",
        "TIME:09:21:10",
        "CODE:UNC",
        "CALL:Unconscious",
        "ADDR:18303 OLD TRIANGLE RD",
        "BOX:03R",
        "UNIT:E503B E523 M503 STA03R female screaming something is wrong w male in t he house .");

    doTest("T6",
        "28-Oct-2010/18:35:32/OUTF/CARBOROUGH ST / 19140 WINDSOR RD ,PWC /03R/E503B STA03R /BRUSH ON FIRE BESIDES THE HIGHWAY [53]",
        "DATE:28-Oct-2010",
        "TIME:18:35:32",
        "CODE:OUTF",
        "CALL:Outside Fire",
        "ADDR:19140 WINDSOR RD",
        "X:CARBOROUGH ST",
        "BOX:03R",
        "UNIT:E503B STA03R",
        "INFO:BRUSH ON FIRE BESIDES THE HIGHWAY",
        "ID:53");

    doTest("T7",
        "05-Nov-2010/10:08:33/FALARM/19043 FULLER HEIGHTS RD ,PWC (INSPIRATION > HOUSE DAY CARE)/03F/E503B STA03F TW512 /busn / 703 441 0997 / aud / ge",
        "DATE:05-Nov-2010",
        "TIME:10:08:33",
        "CODE:FALARM",
        "CALL:Fire Alarm",
        "ADDR:19043 FULLER HEIGHTS RD",
        "PLACE:INSPIRATION > HOUSE DAY CARE",
        "BOX:03F",
        "UNIT:E503B STA03F TW512",
        "INFO:busn / 703 441 0997 / aud / ge");

  }
  
  public static void main(String[] args) {
    new VAPrinceWilliamCountyParserTest().generateTests("T1");
  }

}
