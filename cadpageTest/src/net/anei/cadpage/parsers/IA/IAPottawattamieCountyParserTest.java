package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class IAPottawattamieCountyParserTest extends BaseParserTest {
  
  public IAPottawattamieCountyParserTest() {
    setParser(new IAPottawattamieCountyParser(), "POTTAWATTAMIE COUNTY", "IA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[1700]  17-11-339 11/23 08:32\n20595 MCPHERSON AV, POTT COUNTY\nFIRE - WEED GRASS FIRE\nXST: STATE ORCHARD RD//SUNNYDALE RD ",
        "SRC:1700",
        "ID:17-11-339",
        "DATE:11/23",
        "TIME:08:32",
        "ADDR:20595 MCPHERSON AV",
        "MADDR:20595 MCPHERSON AVE",
        "CALL:FIRE - WEED GRASS FIRE",
        "X:STATE ORCHARD RD//SUNNYDALE RD");

    doTest("T2",
        "[1700]  17-11-338 11/21 17:33\n3000 RISEN SON BV, POTT COUNTY\nEMS/FIRE - UNCONCIOUS/FAINTING\nXST: VIRGINIA HILLS RD//",
        "SRC:1700",
        "ID:17-11-338",
        "DATE:11/21",
        "TIME:17:33",
        "ADDR:3000 RISEN SON BV",
        "CALL:EMS/FIRE - UNCONCIOUS/FAINTING",
        "X:VIRGINIA HILLS RD//");

    doTest("T3",
        "[1700]  17-11-337 11/20 16:02\n18088 BENT TREE RIDGE, POTT COUNTY\nFIRE - AUTOMATIC FIRE DETECTION SIGNAL\nXST: THREE BRIDGE RD//DEAD END",
        "SRC:1700",
        "ID:17-11-337",
        "DATE:11/20",
        "TIME:16:02",
        "ADDR:18088 BENT TREE RIDGE",
        "CALL:FIRE - AUTOMATIC FIRE DETECTION SIGNAL",
        "X:THREE BRIDGE RD//DEAD END");

    doTest("T4",
        "[1700]  17-11-336 11/20 15:26\n19897 BEVERLY MANOR, POTT COUNTY\nSICK PERSON - GENERIC\nXST: LONGVIEW LP//DEAD END",
        "SRC:1700",
        "ID:17-11-336",
        "DATE:11/20",
        "TIME:15:26",
        "ADDR:19897 BEVERLY MANOR",
        "CALL:SICK PERSON - GENERIC",
        "X:LONGVIEW LP//DEAD END");

    doTest("T5",
        "[1700]  17-11-334 11/20 15:19\n19900 VIRGINIA HILLS RD, POTT COUNTY\nFALLS - GENERIC\nXST: CONCORD LP//",
        "SRC:1700",
        "ID:17-11-334",
        "DATE:11/20",
        "TIME:15:19",
        "ADDR:19900 VIRGINIA HILLS RD",
        "CALL:FALLS - GENERIC",
        "X:CONCORD LP//");

    doTest("T6",
        "[1700]  17-11-333 11/19 22:07\n1102 LONGVIEW LP, POTT COUNTY\nEMS/FIRE - BREATHING PROBLEMS\nXST: VALLEY VIEW DR//GREENVIEW RD",
        "SRC:1700",
        "ID:17-11-333",
        "DATE:11/19",
        "TIME:22:07",
        "ADDR:1102 LONGVIEW LP",
        "CALL:EMS/FIRE - BREATHING PROBLEMS",
        "X:VALLEY VIEW DR//GREENVIEW RD");

    doTest("T7",
        "[1700]  17-11-332 11/19 14:21\n14186 230 ST, POTT COUNTY\nPOLE - GENERIC\nXST: CHESTNUT RD//",
        "SRC:1700",
        "ID:17-11-332",
        "DATE:11/19",
        "TIME:14:21",
        "ADDR:14186 230 ST",
        "CALL:POLE - GENERIC",
        "X:CHESTNUT RD//");

    doTest("T8",
        "[1700]  17-11-331 11/19 11:10\n21940 VINEYARD HILLS RD, POTT COUNTY\nSICK PERSON - GENERIC\nXST: EDGEWOOD RD// \n",
        "SRC:1700",
        "ID:17-11-331",
        "DATE:11/19",
        "TIME:11:10",
        "ADDR:21940 VINEYARD HILLS RD",
        "CALL:SICK PERSON - GENERIC",
        "X:EDGEWOOD RD//");
  }

 
  
  public static void main(String[] args) {
    new IAPottawattamieCountyParserTest().generateTests("T1");
  }
}