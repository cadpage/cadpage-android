package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class GADoughertyCountyParserTest extends BaseParserTest {
  
  public GADoughertyCountyParserTest() {
    setParser(new GADoughertyCountyParser(), "DOUGHERTY COUNTY", "GA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "110126 152104110260350/01-26-11/15:20:15/ALTERED MENTAL STATE/1906 LULLWATER RD/ALBANY/FOREST GLEN DR/SUMMIT DR/E01/73YOF C/B/MED5/",
        "ID:152104110260350",
        "CALL:ALTERED MENTAL STATE",
        "ADDR:1906 LULLWATER RD",
        "CITY:ALBANY",
        "X:FOREST GLEN DR & SUMMIT DR",
        "UNIT:E01",
        "INFO:73YOF C / B / MED5");

    doTest("T2",
        "110126 191509110260454/01-26-11/19:12:59/PERSON ILL/1905 BARNESDALE WAY/ALBANY/ROBINHOOD RD/LADY MARION LN/E01/58YM C/B  LOTS OF PAIN,PAIN IN FEET/MED5/",
        "ID:191509110260454",
        "CALL:PERSON ILL",
        "ADDR:1905 BARNESDALE WAY",
        "CITY:ALBANY",
        "X:ROBINHOOD RD & LADY MARION LN",
        "UNIT:E01",
        "INFO:58YM C / B  LOTS OF PAIN,PAIN IN FEET / MED5");

    doTest("T3",
        "110126 125725110260273/01-26-11/12:57:03/STROKE/803 BEECHWOOD DR/ALBANY/WHITE OAK DR/VINE LN/E01/MED5/",
        "ID:125725110260273",
        "CALL:STROKE",
        "ADDR:803 BEECHWOOD DR",
        "CITY:ALBANY",
        "X:WHITE OAK DR & VINE LN",
        "UNIT:E01",
        "INFO:MED5");

    doTest("T4",
        "110127 054453110270051/01-27-11/05:44:19/CARDIAC ARREST/2509 FAIRFAX DR/ALBANY/HUTCHINSON LN/STAR LN/E01/84yof   Not Responding n Not Breathing/MED5 MED2/",
        "ID:054453110270051",
        "CALL:CARDIAC ARREST",
        "ADDR:2509 FAIRFAX DR",
        "CITY:ALBANY",
        "X:HUTCHINSON LN & STAR LN",
        "UNIT:E01",
        "INFO:84yof   Not Responding n Not Breathing / MED5 MED2");

    doTest("T5",
        "110127 042557110270043/01-27-11/04:25:49/ABDOMINAL PROBLEMS/3201 TROWBRIDGE RD/ALBANY/DEVON DR/BEATTIE RD/E01/MED5/",
        "ID:042557110270043",
        "CALL:ABDOMINAL PROBLEMS",
        "ADDR:3201 TROWBRIDGE RD",
        "CITY:ALBANY",
        "X:DEVON DR & BEATTIE RD",
        "UNIT:E01",
        "INFO:MED5");

    doTest("T6",
        "110126 064823110260088/01-26-11/06:47:46/DIABETIC/2823 GILLIONVILLE RD/ALBANY/EVERGREEN ASSISTED LIVING/N WESTOVER BLV/NATIONAL CT/E01/98 YOF C/B  SUGAR IS  58/MED5/",
        "ID:064823110260088",
        "CALL:DIABETIC",
        "ADDR:2823 GILLIONVILLE RD",
        "CITY:ALBANY",
        "PLACE:EVERGREEN ASSISTED LIVING",
        "X:N WESTOVER BLV & NATIONAL CT",
        "UNIT:E01",
        "INFO:98 YOF C / B  SUGAR IS  58 / MED5");

    doTest("T7",
        "140134110980278/04-08-11/14:01:24/HEADACHE/902 CORN AV/ALBANY/HOLLEY HOMES/S HARDING ST/S CLEVELAND ST/E07/56YOF  C/B   HEART RATE IS UP/O2 @ [1 of 2]",
        "ID:140134110980278",
        "CALL:HEADACHE",
        "ADDR:902 CORN AV",
        "MADDR:902 CORN AVE",
        "CITY:ALBANY",
        "PLACE:HOLLEY HOMES",
        "X:S HARDING ST & S CLEVELAND ST",
        "UNIT:E07",
        "INFO:56YOF  C / B   HEART RATE IS UP / O2 @");
    
  }
  
  public static void main(String[] args) {
    new GADoughertyCountyParserTest().generateTests("T7");
  }
}
