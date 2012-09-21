package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYMontgomeryCountyParserTest extends BaseParserTest {
  
  public NYMontgomeryCountyParserTest() {
    setParser(new NYMontgomeryCountyParser(), "MONTGOMERY COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:HVFD 218\n EMS - EMS CALL  14 PINE ST AMSTERDAM CITY  09/24/2011 1223\n\n\n",
        "SRC:HVFD 218",
        "CALL:EMS - EMS CALL",
        "ADDR:14 PINE ST",
        "CITY:AMSTERDAM CITY",
        "DATE:09/24/2011",
        "TIME:12:23");

    doTest("T2",
        "Subject:HVFD 218\nMOTOR VEHICLE ACCIDENT   STATE HWY 30 T AMSTERDAM AMSTERDAM COMMONS 09/25/2011 0851\n\n\n",
        "SRC:HVFD 218",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "PLACE:AMSTERDAM COMMONS",
        "ADDR:STATE HWY 30",
        "MADDR:AMSTERDAM COMMONS,STATE 30",
        "CITY:AMSTERDAM",
        "DATE:09/25/2011",
        "TIME:08:51");

    doTest("T3",
        "Subject:HVFD 218\nEMS - EMS CALL  300 HAMMOND TOWN RD AMSTERDAM  09/25/2011 1015\n\n\n",
        "SRC:HVFD 218",
        "CALL:EMS - EMS CALL",
        "ADDR:300 HAMMOND TOWN RD",
        "CITY:AMSTERDAM",
        "DATE:09/25/2011",
        "TIME:10:15");

    doTest("T4",
        "Subject:HVFD 218\nEMS - EMS CALL  106 HANNAFORD PLZ AMSTERDAM  09/25/2011 1945\n\n\n",
        "SRC:HVFD 218",
        "CALL:EMS - EMS CALL",
        "ADDR:106 HANNAFORD PLZ",
        "CITY:AMSTERDAM",
        "DATE:09/25/2011",
        "TIME:19:45");

    doTest("T5",
        "Subject:HVFD 218\nEMS - EMS CALL  5005 STATE HWY 30 AMSTERDAM  09/25/2011 2250\n\n\n",
        "SRC:HVFD 218",
        "CALL:EMS - EMS CALL",
        "ADDR:5005 STATE HWY 30",
        "MADDR:5005 STATE 30",
        "CITY:AMSTERDAM",
        "DATE:09/25/2011",
        "TIME:22:50");

    doTest("T6",
        "Subject:HVFD 218\nEMS - EMS CALL  10 MAIN ST HAGAMAN VILLAGE  09/26/2011 0759\n\n\n",
        "SRC:HVFD 218",
        "CALL:EMS - EMS CALL",
        "ADDR:10 MAIN ST",
        "CITY:HAGAMAN VILLAGE",
        "DATE:09/26/2011",
        "TIME:07:59");

    doTest("T7",
        "Subject:HVFD 218\nMOTOR VEHICLE ACCIDENT WALMART 101 SANFORD FARM SHOP CT AMSTERDAM  09/26/2011 1011\n\n\n",
        "SRC:HVFD 218",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "PLACE:WALMART",
        "ADDR:101 SANFORD FARM SHOPPING CTR",
        "CITY:AMSTERDAM",
        "DATE:09/26/2011",
        "TIME:10:11");

    doTest("T8",
        "Subject:HVFD 218\nMOTOR VEHICLE ACCIDENT RECOVERY SPORTS GRILL 5005 STHWY 30 AMSTERDAM  09/26/2011 1331\n\n\n",
        "SRC:HVFD 218",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "PLACE:RECOVERY SPORTS GRILL",
        "ADDR:5005 STHWY 30",
        "MADDR:5005 NY 30",
        "CITY:AMSTERDAM",
        "DATE:09/26/2011",
        "TIME:13:31");

    doTest("T9",
        "Subject:HVFD 218\nMOTOR VEHICLE ACCIDENT   STATE HWY 30 T AMSTERDAM AMSTERDAM COMMONS 09/25/2011 0851",
        "SRC:HVFD 218",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "PLACE:AMSTERDAM COMMONS",
        "ADDR:STATE HWY 30",
        "MADDR:AMSTERDAM COMMONS,STATE 30",
        "CITY:AMSTERDAM",
        "DATE:09/25/2011",
        "TIME:08:51");
  }
  
  @Test
  public void testKennethLabelle() {

    doTest("T1",
        "FIRE - SMOKE CALL  1788 BURTONVILLE RD CHARLESTON  01/13/2012 0533",
        "CALL:FIRE - SMOKE CALL",
        "ADDR:1788 BURTONVILLE RD",
        "CITY:CHARLESTON",
        "DATE:01/13/2012",
        "TIME:05:33");

  }
  
  @Test
  public void testPaulKrug() {

    doTest("T1",
        "EMS - EMS CALL  5 CEMETERY V FONDA  05/06/2012 2155",
        "CALL:EMS - EMS CALL",
        "ADDR:5 CEMETERY",
        "CITY:FONDA",
        "DATE:05/06/2012",
        "TIME:21:55");

    doTest("T2",
        "EMS - EMS CALL  22 RAILROAD ST V FONDA  05/03/2012 1747",
        "CALL:EMS - EMS CALL",
        "ADDR:22 RAILROAD ST",
        "CITY:FONDA",
        "DATE:05/03/2012",
        "TIME:17:47");

    doTest("T3",
        "FIRE - SERVICE NBT BANK FONDA 34 W MAIN ST FONDA  04/30/2012 0650",
        "CALL:FIRE - SERVICE",
        "PLACE:NBT BANK FONDA",
        "ADDR:34 W MAIN ST",
        "CITY:FONDA",
        "DATE:04/30/2012",
        "TIME:06:50");

    doTest("T4",
        "EMS - EMS CALL CUMBERLAND FARMS 2 W MAIN ST FONDA  04/30/2012 0532",
        "CALL:EMS - EMS CALL",
        "PLACE:CUMBERLAND FARMS",
        "ADDR:2 W MAIN ST",
        "CITY:FONDA",
        "DATE:04/30/2012",
        "TIME:05:32");

    doTest("T5",
        "FIRE - STRUCTURE  56 E MAIN ST V FONDA  04/20/2012 0145",
        "CALL:FIRE - STRUCTURE",
        "ADDR:56 E MAIN ST",
        "CITY:FONDA",
        "DATE:04/20/2012",
        "TIME:01:45");

    doTest("T6",
        "FIRE - CO CALL  21 BROADWAY V FONDA  04/18/2012 0817",
        "CALL:FIRE - CO CALL",
        "ADDR:21 BROADWAY",
        "CITY:FONDA",
        "DATE:04/18/2012",
        "TIME:08:17");
    
  }
  
  public static void main(String[] args) {
    new NYMontgomeryCountyParserTest().generateTests("T1", "SRC CALL PLACE ADDR CITY DATE TIME");
  }
}