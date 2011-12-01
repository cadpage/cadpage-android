package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYAlbanyCountyParserTest extends BaseParserTest {
  
  public NYAlbanyCountyParserTest() {
    setParser(new NYAlbanyCountyParser(), "ALBANY COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FIRE ALARM E405,E406,RS2,E412\n54 SUNSET BL\n HIGGINS ROBERT\nMap COL VILL 12:00:30",
        "CALL:FIRE ALARM",
        "UNIT:E405,E406,RS2,E412",
        "ADDR:54 SUNSET BL",
        "PLACE:HIGGINS ROBERT",
        "MAP:COL VILL",
        "TIME:12:00:30");

    doTest("T2",
        "STRUCTURE FIRE E412,E410,RS3,E454,CVFT,TK9\n45 RAILROAD AV(FULLER)\n CNY STORM ALLSTARS\nMap FULLER 08:48:16",
        "CALL:STRUCTURE FIRE",
        "UNIT:E412,E410,RS3,E454,CVFT,TK9",
        "ADDR:45 RAILROAD AV",
        "MADDR:45 RAILROAD AVE",
        "PLACE:CNY STORM ALLSTARS",
        "MAP:FULLER",
        "TIME:08:48:16");

    doTest("T3",
        "FIRE ALARM E412,E410,RS3,E405,TK9\n1417 CENTRAL AV\nCOLONIE CENTER\nMap FULLER 08:11:21",
        "CALL:FIRE ALARM",
        "UNIT:E412,E410,RS3,E405,TK9",
        "ADDR:1417 CENTRAL AV",
        "MADDR:1417 CENTRAL AVE",
        "PLACE:COLONIE CENTER",
        "MAP:FULLER",
        "TIME:08:11:21");

    doTest("T4",
        "FIRE ALARM E437,E438,TK7,E405,RS10\n392 NEW KARNER RD\nDUNKIN DONUTS\nMap MIDWAY 14:16:56",
        "CALL:FIRE ALARM",
        "UNIT:E437,E438,TK7,E405,RS10",
        "ADDR:392 NEW KARNER RD",
        "PLACE:DUNKIN DONUTS",
        "MAP:MIDWAY",
        "TIME:14:16:56");

    doTest("T5",
        "FIRE ALARM E412,E410,RS3,E405,TK9\n1417 CENTRAL AV\nCOLONIE CENTER\nMap FULLER 08:11:21",
        "CALL:FIRE ALARM",
        "UNIT:E412,E410,RS3,E405,TK9",
        "ADDR:1417 CENTRAL AV",
        "MADDR:1417 CENTRAL AVE",
        "PLACE:COLONIE CENTER",
        "MAP:FULLER",
        "TIME:08:11:21");

    doTest("T6",
        "MEDICAL CALL A622,E405\n10 STELLA TR\nMap COL VILL 20:55:06",
        "CALL:MEDICAL CALL",
        "UNIT:A622,E405",
        "ADDR:10 STELLA TR",
        "MAP:COL VILL",
        "TIME:20:55:06");

    doTest("T7",
        "CO ALARM W/ILLNESS E405,E406,E412,FP71\n28 HIALEAH DR\nMILLER GREGORY\nMap COL VILL 07:23:37",
        "CALL:CO ALARM W/ILLNESS",
        "UNIT:E405,E406,E412,FP71",
        "ADDR:28 HIALEAH DR",
        "PLACE:MILLER GREGORY",
        "MAP:COL VILL",
        "TIME:07:23:37");

    doTest("T8",
        "CO ALARM W/O ILLNESS E405,E406,FP71\n22 LOIS CT\nMap COL VILL 09:22:59",
        "CALL:CO ALARM W/O ILLNESS",
        "UNIT:E405,E406,FP71",
        "ADDR:22 LOIS CT",
        "MAP:COL VILL",
        "TIME:09:22:59");

    doTest("T9",
        "STRUCTURE FIRE - POSSIBLE E437,E438,TK7,RS7,E405\n6 GLENMORE DR\nMap MIDWAY 14:45:27",
        "CALL:STRUCTURE FIRE - POSSIBLE",
        "UNIT:E437,E438,TK7,RS7,E405",
        "ADDR:6 GLENMORE DR",
        "MAP:MIDWAY",
        "TIME:14:45:27");

    doTest("T10",
        "BFIRE ALARM E412,E410,TK3,RS3,E405\n1425 CENTRAL AV\nSEARS\nMap FULLER 11:57:21",
        "CALL:BFIRE ALARM",
        "UNIT:E412,E410,TK3,RS3,E405",
        "ADDR:1425 CENTRAL AV",
        "MADDR:1425 CENTRAL AVE",
        "PLACE:SEARS",
        "MAP:FULLER",
        "TIME:11:57:21");

    doTest("T11",
        "MEDICAL CALL A621,CR16,E406\n1 ELM CT\nMap COL VILL 16:25:57",
        "CALL:MEDICAL CALL",
        "UNIT:A621,CR16,E406",
        "ADDR:1 ELM CT",
        "MAP:COL VILL",
        "TIME:16:25:57");
  }
  
  public static void main(String[] args) {
    new NYAlbanyCountyParserTest().generateTests("T1");
  }
}