package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CTMiddlesexCountyParserTest extends BaseParserTest {
  
  public CTMiddlesexCountyParserTest() {
    setParser(new CTMiddlesexCountyParser(), "MIDDLESEX COUNTY", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(DURHAM FIRE CALL CAD Page for CFS 061312-31) \n" +
        "http://maps.google.com/maps?q=+41.48618%20-72.65719\n" +
        "Fire Alarm\n" +
        "18 WEATHERVANE HILL\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : MAIDEN LANE \n" +
        "Caller: ADT OP YSG\n" +
        "Disp Time: 06/13/12 11:36:52",

        "ID:061312-31",
        "CALL:Fire Alarm",
        "ADDR:18 WEATHERVANE HILL",
        "CITY:DURHAM",
        "X:MAIDEN LANE",
        "NAME:ADT OP YSG",
        "DATE:06/13/12",
        "TIME:11:36:52");

    doTest("T2",
        "(DURHAM FIRE CALL CAD Page for CFS 061312-47) \n" +
        "http://maps.google.com/maps?q=+41.44852%20-72.70119\n" +
        "Fire Alarm\n" +
        "471 NEW HAVEN RD\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : SAW MILL RD * CANTERBURY DR \n" +
        "Caller: \n" +
        "Disp Time: 06/13/12 18:03:43",

        "ID:061312-47",
        "CALL:Fire Alarm",
        "ADDR:471 NEW HAVEN RD",
        "CITY:DURHAM",
        "X:SAW MILL RD & CANTERBURY DR",
        "DATE:06/13/12",
        "TIME:18:03:43");

    doTest("T3",
        "(DURHAM FIRE CALL CAD Page for CFS 061412-5) \n" +
        "http://maps.google.com/maps?q=+41.48025%20-72.66325\n" +
        "Unconcious/Unresponsive ALS\n" +
        "MAIDEN LANE and BEAR ROCK RD\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : SYCAMORE DR * MAIDEN LANE \n" +
        "Caller: ATTMO\n" +
        "Disp Time: 06/14/12 04:22:21",

        "ID:061412-5",
        "CALL:Unconcious/Unresponsive ALS",
        "ADDR:MAIDEN LANE and BEAR ROCK RD",
        "MADDR:MAIDEN LANE & BEAR ROCK RD",
        "CITY:DURHAM",
        "X:SYCAMORE DR & MAIDEN LANE",
        "NAME:ATTMO",
        "DATE:06/14/12",
        "TIME:04:22:21");

    doTest("T4",
        "(CAD Page for CFS 061512-51) \n" +
        "http://maps.google.com/maps?q=+41.43734%20-72.71928\n" +
        "Fire Alarm\n" +
        "809 NEW HAVEN RD\n" +
        "Apt: -R\n" +
        "DH       \n" +
        "Cross Streets : COE RD * FORLINE RD \n" +
        "Caller: \n" +
        "Water\\Info: SEND EMS NON-EMERGENCY ON FIRE ALARMS AT THIS LOCATION\n\n" +
        "Disp Time: 06/15/12 15:35:55",

        "ID:061512-51",
        "CALL:Fire Alarm",
        "ADDR:809 NEW HAVEN RD",
        "APT:-R",
        "CITY:DURHAM",
        "X:COE RD & FORLINE RD",
        "DATE:06/15/12",
        "TIME:15:35:55");

    doTest("T5",
        "(CAD Page for CFS 062012-32) \n" +
        "http://maps.google.com/maps?q=+41.48282%20-72.68172\n" +
        "Minor MVA -No Medic\n" +
        "310 MAIN ST\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : MAIDEN LANE * TALCOTT LANE \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Disp Time: 06/20/12 12:24:24",

        "ID:062012-32",
        "CALL:Minor MVA -No Medic",
        "ADDR:310 MAIN ST",
        "CITY:DURHAM",
        "X:MAIDEN LANE & TALCOTT LANE",
        "NAME:VERIZON WIRELESS",
        "DATE:06/20/12",
        "TIME:12:24:24");

    doTest("T6",
        "(CAD Page for CFS 062112-63) \n" +
        "http://maps.google.com/maps?q=+41.47446%20-72.68228\n" +
        "MVA Medic ALS\n" +
        "68 MAPLE AVE\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : JOHNS WAY * OLD CEMETERY RD \n" +
        "Caller: SPRINTPCS\n" +
        "Disp Time: 06/21/12 17:22:22",

        "ID:062112-63",
        "CALL:MVA Medic ALS",
        "ADDR:68 MAPLE AVE",
        "CITY:DURHAM",
        "X:JOHNS WAY & OLD CEMETERY RD",
        "NAME:SPRINTPCS",
        "DATE:06/21/12",
        "TIME:17:22:22");

    doTest("T7",
        "(CAD Page for CFS 062212-43) \n" +
        "http://maps.google.com/maps?q=+41.47400%20-72.68024\n" +
        "Minor MVA -No Medic\n" +
        "154 MAIN ST\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : FOWLER AVE * OLD CEMETERY RD \n" +
        "Caller: \n" +
        "Disp Time: 06/22/12 15:48:27",

        "ID:062212-43",
        "CALL:Minor MVA -No Medic",
        "ADDR:154 MAIN ST",
        "CITY:DURHAM",
        "X:FOWLER AVE & OLD CEMETERY RD",
        "DATE:06/22/12",
        "TIME:15:48:27");

    doTest("T8",
        "(CAD Page for CFS 062312-10) \n" +
        "http://maps.google.com/maps?q=+41.47818%20-72.68108\n" +
        "Minor MVA -No Medic\n" +
        "MAIN ST and WALLINGFORD RD\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : WALLINGFORD RD * MAIDEN LANE \n" +
        "Caller: \n" +
        "Disp Time: 06/23/12 07:42:19",

        "ID:062312-10",
        "CALL:Minor MVA -No Medic",
        "ADDR:MAIN ST and WALLINGFORD RD",
        "MADDR:MAIN ST & WALLINGFORD RD",
        "CITY:DURHAM",
        "X:WALLINGFORD RD & MAIDEN LANE",
        "DATE:06/23/12",
        "TIME:07:42:19");

    doTest("T9",
        "(CAD Page for CFS 062312-66) \n" +
        "http://maps.google.com/maps?q=+41.47828%20-72.67083\n" +
        "Wires Down -Call NU\n" +
        "135 PICKETT LANE\n" +
        "Apt: \n" +
        "DH\n" +
        "Cross Streets : MAIN ST * MAIDEN LANE \n" +
        "Caller: ATTMO\n" +
        "Disp Time: 06/23/12 21:06:27",

        "ID:062312-66",
        "CALL:Wires Down -Call NU",
        "ADDR:135 PICKETT LANE",
        "CITY:DURHAM",
        "X:MAIN ST & MAIDEN LANE",
        "NAME:ATTMO",
        "DATE:06/23/12",
        "TIME:21:06:27");

    doTest("T10",
        "(CAD Page for CFS 062412-49) \n" +
        "http://maps.google.com/maps?q=+41.47896%20-72.68120\n" +
        "Minor MVA -No Medic\n" +
        "238 MAIN ST\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : WALLINGFORD RD * MAIDEN LANE \n" +
        "Caller: ATTMO\n" +
        "Disp Time: 06/24/12 14:21:09",

        "ID:062412-49",
        "CALL:Minor MVA -No Medic",
        "ADDR:238 MAIN ST",
        "CITY:DURHAM",
        "X:WALLINGFORD RD & MAIDEN LANE",
        "NAME:ATTMO",
        "DATE:06/24/12",
        "TIME:14:21:09");

    doTest("T11",
        "(CAD Page for CFS 062512-13) \n" +
        "http://maps.google.com/maps?q=+41.33698%20-72.58493\n" +
        "Structure Fire\n" +
        "24 COW PEN HILL RD\n" +
        "Apt: \n" +
        "KW\n" +
        "Cross Streets : GREEN HILL RD * COOKS LANE \n" +
        "Caller: BROWN,ROBERT F\n" +
        "Disp Time: 06/25/12 08:30:13",

        "ID:062512-13",
        "CALL:Structure Fire",
        "ADDR:24 COW PEN HILL RD",
        "CITY:KILLINGWORTH",
        "X:GREEN HILL RD & COOKS LANE",
        "NAME:BROWN,ROBERT F",
        "DATE:06/25/12",
        "TIME:08:30:13");

    doTest("T12",
        "(CAD Page for CFS 062512-65) \n" +
        "http://maps.google.com/maps?q=+41.48772%20-72.64230\n" +
        "Fire Alarm\n" +
        "255 JOHNSON LANE\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : MAIDEN LANE * HADDAM QUARTER RD \n" +
        "Caller: adt\n" +
        "Disp Time: 06/25/12 16:21:16",

        "ID:062512-65",
        "CALL:Fire Alarm",
        "ADDR:255 JOHNSON LANE",
        "CITY:DURHAM",
        "X:MAIDEN LANE & HADDAM QUARTER RD",
        "NAME:adt",
        "DATE:06/25/12",
        "TIME:16:21:16");

    doTest("T13",
        "(CAD Page for CFS 062512-87) \n" +
        "http://maps.google.com/maps?q=+41.49094%20-72.65092\n" +
        "Electrical Fire Pole/Wire\n" +
        "HADDAM QUARTER RD and ARBUTUS ST\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : WINTERBERRY LANE * HADDAM QUARTER RD \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Disp Time: 06/25/12 20:31:21",

        "ID:062512-87",
        "CALL:Electrical Fire Pole/Wire",
        "ADDR:HADDAM QUARTER RD and ARBUTUS ST",
        "MADDR:HADDAM QUARTER RD & ARBUTUS ST",
        "CITY:DURHAM",
        "X:WINTERBERRY LANE & HADDAM QUARTER RD",
        "NAME:VERIZON WIRELESS",
        "DATE:06/25/12",
        "TIME:20:31:21");

    doTest("T14",
        "(CAD Page for CFS 062612-1) \n" +
        "http://maps.google.com/maps?q=+41.46590%20-72.67495\n" +
        "Brush Fire\n" +
        "HIGGANUM RD and CHERRY LANE\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : MADISON RD * CHERRY LANE \n" +
        "Caller: \n" +
        "Disp Time: 06/26/12 00:16:19",

        "ID:062612-1",
        "CALL:Brush Fire",
        "ADDR:HIGGANUM RD and CHERRY LANE",
        "MADDR:HIGGANUM RD & CHERRY LANE",
        "CITY:DURHAM",
        "X:MADISON RD & CHERRY LANE",
        "DATE:06/26/12",
        "TIME:00:16:19");

    doTest("T15",
        "(CAD Page for CFS 063012-41) \n" +
        "http://maps.google.com/maps?q=+41.46674%20-72.65959\n" +
        "Electrical Fire Pole/Wire\n" +
        "291 HIGGANUM RD\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : TRINITY HILL DR * BEAR ROCK RD \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Disp Time: 06/30/12 11:30:15",

        "ID:063012-41",
        "CALL:Electrical Fire Pole/Wire",
        "ADDR:291 HIGGANUM RD",
        "CITY:DURHAM",
        "X:TRINITY HILL DR & BEAR ROCK RD",
        "NAME:VERIZON WIRELESS",
        "DATE:06/30/12",
        "TIME:11:30:15");

    doTest("T16",
        "(CAD Page for CFS 070512-9) \n" +
        "http://maps.google.com/maps?q=+41.49594%20-72.64658\n" +
        "Fire Alarm\n" +
        "23 CHEYENNE TR\n" +
        "Apt: \n" +
        "DH       \n" +
        "Cross Streets : ARBUTUS ST \n" +
        "Caller: early detection\n" +
        "Disp Time: 07/05/12 07:03:07",

        "ID:070512-9",
        "CALL:Fire Alarm",
        "ADDR:23 CHEYENNE TR",  // Not mapping
        "CITY:DURHAM",
        "X:ARBUTUS ST",
        "NAME:early detection",
        "DATE:07/05/12",
        "TIME:07:03:07");

    doTest("T17",
        "(CAD Page for CFS 070712-30) \n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000\n" +
        "Public Service\n" +
        "U:OLD JOHNSON LANE AND MILBROOK\n" +
        "Apt: \n" +
        "MD\n" +
        "Caller: MD\n" +
        "Disp Time: 07/07/12 13:36:50",

        "ID:070712-30",
        "CALL:Public Service",
        "ADDR:OLD JOHNSON LANE AND MILBROOK",
        "CITY:MIDDLETOWN",
        "NAME:MD",
        "DATE:07/07/12",
        "TIME:13:36:50");

    doTest("T18",
        "(CAD Page for CFS 070712-87) \n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000\n" +
        "Structure Fire\n" +
        "U:U:ROUTE 149 AND ROUTE 16\n" +
        "Apt: \n\n" +
        "Caller: \n" +
        "Disp Time: 07/08/12 01:23:01",

        "ID:070712-87",
        "CALL:Structure Fire",
        "ADDR:ROUTE 149 AND ROUTE 16",
        "DATE:07/08/12",
        "TIME:01:23:01");

  }
  
  public static void main(String[] args) {
    new CTMiddlesexCountyParserTest().generateTests("T1");
  }
}