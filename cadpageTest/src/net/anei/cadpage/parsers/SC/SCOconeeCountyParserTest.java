package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class SCOconeeCountyParserTest extends BaseParserTest {
  
  public SCOconeeCountyParserTest() {
    setParser(new SCOconeeCountyParser(), "OCONEE COUNTY", "SC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[911 Message]  S80 - CORONARY PROBLEM  1280 N  STHY 11 XStreet: SPRINGDALE DR / SCENIC HEIGHTS RD, FOWLER RD WEST UNION    2011-00000815  09/26/11 22:27  Narr:   S",
        "UNIT:S80",
        "CALL:CORONARY PROBLEM",
        "ADDR:1280 N STHY 11",
        "X:SPRINGDALE DR / SCENIC HEIGHTS RD, FOWLER RD",
        "CITY:WEST UNION",
        "ID:2011-00000815",
        "INFO:S");

    doTest("T2",
        "[911 Message]  S80 - CORONARY PROBLEM  206 S  TUGALOO ST XStreet: W MAULDIN ST / BOOKER DR WALHALLA    2011-00000809  09/25/11 06:49  Narr:   PATIENT IS HER FATHER",
        "UNIT:S80",
        "CALL:CORONARY PROBLEM",
        "ADDR:206 S TUGALOO ST",
        "X:W MAULDIN ST / BOOKER DR",
        "CITY:WALHALLA",
        "ID:2011-00000809",
        "INFO:PATIENT IS HER FATHER");

    doTest("T3",
        "[911 Message]  S46 - ALTERED MENTAL STATUS  308 N  LAUREL ST XStreet: ARDASHIR LN / WALHALLA GARDENS CIR WALHALLA    2011-00000777  09/16/11 12:24  Narr:   76 YOA",
        "UNIT:S46",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:308 N LAUREL ST",
        "X:ARDASHIR LN / WALHALLA GARDENS CIR",
        "CITY:WALHALLA",
        "ID:2011-00000777",
        "INFO:76 YOA");

    doTest("T4",
        "(911 Message) S4 - DIABETIC REACTION  100 PINE MANOR CIR APT 3 XStreet: STOUDEMIRE ST / STOUDEMIRE ST WALHALLA  COUNTRY RIDGE APTS  2011-00000872  10/26/11 19:21",
        "UNIT:S4",
        "CALL:DIABETIC REACTION",
        "ADDR:100 PINE MANOR CIR",
        "APT:3",
        "X:STOUDEMIRE ST / STOUDEMIRE ST",
        "CITY:WALHALLA",
        "PLACE:COUNTRY RIDGE APTS",
        "ID:2011-00000872");
 
  }
  
  public static void main(String[] args) {
    new SCOconeeCountyParserTest().generateTests("T1", "UNIT CALL ADDR APT X CITY PLACE ID INFO");
  }
}