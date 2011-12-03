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
        "CALL:S80 - CORONARY PROBLEM",
        "ADDR:1280 N STHY 11",
        "MADDR:1280 N ST 11",
        "X:SPRINGDALE DR / SCENIC HEIGHTS RD, FOWLER RD",
        "CITY:WEST UNION",
        "ID:2011-00000815",
        "DATE:09/26/11",
        "TIME:22:27",
        "INFO:S");

    doTest("T2",
        "[911 Message]  S80 - CORONARY PROBLEM  206 S  TUGALOO ST XStreet: W MAULDIN ST / BOOKER DR WALHALLA    2011-00000809  09/25/11 06:49  Narr:   PATIENT IS HER FATHER",
        "CALL:S80 - CORONARY PROBLEM",
        "ADDR:206 S TUGALOO ST",
        "X:W MAULDIN ST / BOOKER DR",
        "CITY:WALHALLA",
        "ID:2011-00000809",
        "DATE:09/25/11",
        "TIME:06:49",
        "INFO:PATIENT IS HER FATHER");

    doTest("T3",
        "[911 Message]  S46 - ALTERED MENTAL STATUS  308 N  LAUREL ST XStreet: ARDASHIR LN / WALHALLA GARDENS CIR WALHALLA    2011-00000777  09/16/11 12:24  Narr:   76 YOA",
        "CALL:S46 - ALTERED MENTAL STATUS",
        "ADDR:308 N LAUREL ST",
        "X:ARDASHIR LN / WALHALLA GARDENS CIR",
        "CITY:WALHALLA",
        "ID:2011-00000777",
        "DATE:09/16/11",
        "TIME:12:24",
        "INFO:76 YOA");

    doTest("T4",
        "(911 Message) S4 - DIABETIC REACTION  100 PINE MANOR CIR APT 3 XStreet: STOUDEMIRE ST / STOUDEMIRE ST WALHALLA  COUNTRY RIDGE APTS  2011-00000872  10/26/11 19:21",
        "CALL:S4 - DIABETIC REACTION",
        "ADDR:100 PINE MANOR CIR",
        "APT:3",
        "X:STOUDEMIRE ST / STOUDEMIRE ST",
        "CITY:WALHALLA",
        "PLACE:COUNTRY RIDGE APTS",
        "ID:2011-00000872",
        "DATE:10/26/11",
        "TIME:19:21");

    doTest("T5",
        "(911 Message) LIFT ASSISTANCE  313 MANOR LN XStreet: INDUSTRIAL PARK PL / DEAD END SENECA     12/02/11 01:06  Narr:   COME TO THE BACK DOOR  NEEDS HELP GETTING UP",
        "CALL:LIFT ASSISTANCE",
        "ADDR:313 MANOR LN",
        "X:INDUSTRIAL PARK PL / DEAD END",
        "CITY:SENECA",
        "DATE:12/02/11",
        "TIME:01:06",
        "INFO:COME TO THE BACK DOOR  NEEDS HELP GETTING UP");

    doTest("T6",
        "(911 Message) S86 - CHEST PAIN  3440 BLUE RIDGE BLVD XStreet: MISTY DR, THE OLE HOME PLACE LN / TRAVELLERS BLVD WEST UNION  EDWARDS AUTO SALES  2011-00000946  11/",
        "CALL:S86 - CHEST PAIN",
        "ADDR:3440 BLUE RIDGE BLVD",
        "X:MISTY DR, THE OLE HOME PLACE LN / TRAVELLERS BLVD",
        "CITY:WEST UNION",
        "PLACE:EDWARDS AUTO SALES",
        "ID:2011-00000946");

    doTest("T7",
        "(911 Message) LIFT ASSISTANCE  313 MANOR LN XStreet: INDUSTRIAL PARK PL / DEAD END SENECA     12/02/11 01:06  Narr:   COME TO THE BACK DOOR  NEEDS HELP GETTING UP",
        "CALL:LIFT ASSISTANCE",
        "ADDR:313 MANOR LN",
        "X:INDUSTRIAL PARK PL / DEAD END",
        "CITY:SENECA",
        "DATE:12/02/11",
        "TIME:01:06",
        "INFO:COME TO THE BACK DOOR  NEEDS HELP GETTING UP");

  }
  
  public static void main(String[] args) {
    new SCOconeeCountyParserTest().generateTests("T1", "UNIT CALL ADDR APT X CITY PLACE ID DATE TIME INFO");
  }
}