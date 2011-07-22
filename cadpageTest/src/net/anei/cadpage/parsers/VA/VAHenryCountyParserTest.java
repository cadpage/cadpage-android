package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.VA.VAHenryCountyParser;

import org.junit.Test;


public class VAHenryCountyParserTest extends BaseParserTest {
  
  public VAHenryCountyParserTest() {
    setParser(new VAHenryCountyParser(), "HENRY COUNTY", "VA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "(CAD Call) 2010094339\nR2-(1) DIFFICULTY BREATHING\n999 MORGAN FORD RD RIDGEWAY",
        "ID:2010094339",
        "UNIT:R2-(1)",
        "CALL:DIFFICULTY BREATHING",
        "ADDR:999 MORGAN FORD RD",
        "CITY:RIDGEWAY");
    
    doTest("T2",
        "(CAD Call) 2010094406\nRFA-(3) FALL / FRACTURE\n247 DEVONSHIRE DR RIDGEWAY\nALTERED MENTAL STATUS",
        "ID:2010094406",
        "UNIT:RFA-(3)",
        "CALL:FALL / FRACTURE",
        "ADDR:247 DEVONSHIRE DR",
        "CITY:RIDGEWAY",
        "INFO:ALTERED MENTAL STATUS");
    
    doTest("T3",
        "(CAD Call) 2010094372\n1 LEE FORD CAMP RD RIDGEWAY\n@ 220 - TK & SUV",
        "ID:2010094372",
        "ADDR:1 LEE FORD CAMP RD",
        "CITY:RIDGEWAY",
        "INFO:@ 220 - TK & SUV");
    
    doTest("T4",
        "(CAD Call) 2010094604\nRSI-(2) SICK UNKNOWN MEDICAL\n 89 DAYLIGHT DR RIDGEWAY",
        "ID:2010094604",
        "UNIT:RSI-(2)",
        "CALL:SICK UNKNOWN MEDICAL",
        "ADDR:89 DAYLIGHT DR",
        "CITY:RIDGEWAY");
    
    doTest("T5",
        "(CAD Call) 2010095255\nMOTOR VEHICLE CRASH\nHENRY COUNTY PLYWOOD CO. 1580 PHOSPHO SPRINGS RD RIDGEWAY",
        "ID:2010095255",
        "CALL:MOTOR VEHICLE CRASH",
        "PLACE:HENRY COUNTY PLYWOOD CO",
        "ADDR:1580 PHOSPHO SPRINGS RD",
        "CITY:RIDGEWAY");
    
    doTest("T6",
        "(CAD Call) 2010095057\nRSI-(2) SICK UNKNOWN MEDICAL\n129 KIRK ST 4 MARTINSVILLE",
        "ID:2010095057",
        "UNIT:RSI-(2)",
        "CALL:SICK UNKNOWN MEDICAL",
        "ADDR:129 KIRK ST 4",
        "CITY:MARTINSVILLE");
    
    doTest("T7",
        "(CAD Call) 2010095041\nMOTOR VEHICLE CRASH\n3 MARHILL DR RIDGEWAY",
        "ID:2010095041",
        "CALL:MOTOR VEHICLE CRASH",
        "ADDR:3 MARHILL DR",
        "CITY:RIDGEWAY");

    doTest("T8",
        "(CAD Call) 2010095011\nR2-(1) DIFFICULTY BREATHING\n999 MORGAN FORD RD RIDGEWAY",
        "ID:2010095011",
        "UNIT:R2-(1)",
        "CALL:DIFFICULTY BREATHING",
        "ADDR:999 MORGAN FORD RD",
        "CITY:RIDGEWAY");
    
    doTest("T9",
        "(CAD Call) 2010098333\nSUSPICIOUS CIRCUMSTANCES\nDOLLAR GENERAL (MOREHEAD AVE)\n390 MOREHEAD AVE RIDGEWAY\nWHT MALE, DARK SHIRT",
        "ID:2010098333",
        "CALL:SUSPICIOUS CIRCUMSTANCES",
        "PLACE:DOLLAR GENERAL (MOREHEAD AVE)",
        "ADDR:390 MOREHEAD AVE",
        "CITY:RIDGEWAY",
        "INFO:WHT MALE, DARK SHIRT");

    doTest("T10",
        "(CAD Call) 2011055772 \nF-HELICOPTER LANDING ZONE \nBLUE RIDGE REGIONAL LIBRARY - RIDGEWAY 900 VISTA VIEW LN RIDGEWAY \nFIELD A",
        "ID:2011055772",
        "CALL:F-HELICOPTER LANDING ZONE",
        "PLACE:BLUE RIDGE REGIONAL LIBRARY - RIDGEWAY",
        "ADDR:900 VISTA VIEW LN",
        "CITY:RIDGEWAY",
        "INFO:FIELD A");
   
  }
  
  public static void main(String[] args) {
    new VAHenryCountyParserTest().generateTests("T10", "ID CALL PLACE ADDR CITY INFO");
  }
}