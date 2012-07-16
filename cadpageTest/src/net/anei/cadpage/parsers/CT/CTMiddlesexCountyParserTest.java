package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CTMiddlesexCountyParserTest extends BaseParserTest {
  
  public CTMiddlesexCountyParserTest() {
    setParser(new CTMiddlesexCountyParser(), "MIDDLESEX COUNTY", "CT");
  }
  
  @Test
  public void testActive911A() {

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
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "(CAD Page for CFS 062212-75) \n" +
        "http://maps.google.com/maps?q=+41.28611%20-72.27805\n" +
        "Psychiatric BLS\n" +
        "63 HARTFORD AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : BOCCE LANE * MARTINO RD \n" +
        "Caller: \n" +
        "Water\\Info: HLHY 23 HARTFORD AV\n\n" +
        "Disp Time: 06/22/12 23:37:06",

        "ID:062212-75",
        "CALL:Psychiatric BLS",
        "ADDR:63 HARTFORD AVE",
        "CITY:OLD LYME",
        "X:BOCCE LANE & MARTINO RD",
        "DATE:06/22/12",
        "TIME:23:37:06");

    doTest("T2",
        "(CAD Page for CFS 062612-31) \n" +
        "http://maps.google.com/maps?q=+41.28835%20-72.27751\n" +
        "Basic Life Support \n" +
        "25 SWAN AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SHORE RD * BOCCE LANE \n" +
        "Caller: \n" +
        "Water\\Info: HLHY 36 SWAN AV\n\n" +
        "Disp Time: 06/26/12 12:58:25",

        "ID:062612-31",
        "CALL:Basic Life Support",
        "ADDR:25 SWAN AVE",
        "CITY:OLD LYME",
        "X:SHORE RD & BOCCE LANE",
        "DATE:06/26/12",
        "TIME:12:58:25");

    doTest("T3",
        "(CAD Page for CFS 062612-38) \n" +
        "http://maps.google.com/maps?q=+41.30446%20-72.25576\n" +
        "BEE STING REACTION\n" +
        "3 FOX CHASE LANE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : OAKRIDGE DR \n" +
        "Caller: \n" +
        "Water\\Info: TSFW56 21 OAKRIDGE @ BOAT LAUNCH\n\n" +
        "Disp Time: 06/26/12 14:38:18",

        "ID:062612-38",
        "CALL:BEE STING REACTION",
        "ADDR:3 FOX CHASE LANE",
        "CITY:OLD LYME",
        "X:OAKRIDGE DR",
        "DATE:06/26/12",
        "TIME:14:38:18");

    doTest("T4",
        "(CAD Page for CFS 062712-10) \n" +
        "http://maps.google.com/maps?q=+41.34336%20-72.30941\n" +
        "GENERAL WEAKNESS\n" +
        "115 SILL LANE\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : WILLS RIDGE RD * BOSTON POST RD \n" +
        "Caller: BISHOP,CRAIG\n" +
        "Disp Time: 06/27/12 08:14:33",

        "ID:062712-10",
        "CALL:GENERAL WEAKNESS",
        "ADDR:115 SILL LANE",
        "CITY:OLD LYME",
        "X:WILLS RIDGE RD & BOSTON POST RD",
        "NAME:BISHOP,CRAIG",
        "DATE:06/27/12",
        "TIME:08:14:33");

    doTest("T5",
        "(CAD Page for CFS 062812-39) \n" +
        "http://maps.google.com/maps?q=+41.35931%20-72.29515\n" +
        "Seizures ALS\n" +
        "76 GRASSY HILL RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : BOSTON POST RD * COACH DR \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: HLFW38 94 GRASSY HILL @ BOAT LAUNCH\n\n" +
        "Disp Time: 06/28/12 18:01:46",

        "ID:062812-39",
        "CALL:Seizures ALS",
        "ADDR:76 GRASSY HILL RD",
        "CITY:OLD LYME",
        "X:BOSTON POST RD & COACH DR",
        "NAME:VERIZON WIRELESS",
        "DATE:06/28/12",
        "TIME:18:01:46");

    doTest("T6",
        "(CAD Page for CFS 062912-14) \n" +
        "http://maps.google.com/maps?q=+41.30351%20-72.27782\n" +
        "Basic Life Support \n" +
        "30 WYCHWOOD RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : NOTTINGHAM DR * BROWNS LANE \n" +
        "Caller: HEAP,JOSEPH C\n" +
        "Water\\Info: TSFW49 20 THOMAS WAITE DR\n\n" +
        "Disp Time: 06/29/12 10:33:12",

        "ID:062912-14",
        "CALL:Basic Life Support",
        "ADDR:30 WYCHWOOD RD",
        "CITY:OLD LYME",
        "X:NOTTINGHAM DR & BROWNS LANE",
        "NAME:HEAP,JOSEPH C",
        "DATE:06/29/12",
        "TIME:10:33:12");

    doTest("T7",
        "(CAD Page for CFS 062912-30) \n" +
        "http://maps.google.com/maps?q=+41.30316%20-72.26485\n" +
        "ALTERED MENTAL STATUS\n" +
        "285 MILE CREEK RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : WOOD RIDGE HILLS RD * CHESTNUT HILL RD \n" +
        "Caller: \n" +
        "Water\\Info: HLFW53 304 MILE CREEK RD\n\n" +
        "Water\\Info: HLFW75 302 MILE CREEK RD\n\n" +
        "Disp Time: 06/29/12 12:57:32",

        "ID:062912-30",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:285 MILE CREEK RD",
        "CITY:OLD LYME",
        "X:WOOD RIDGE HILLS RD & CHESTNUT HILL RD",
        "DATE:06/29/12",
        "TIME:12:57:32");

    doTest("T8",
        "(CAD Page for CFS 063012-53) \n" +
        "http://maps.google.com/maps?q=+41.28296%20-72.28382\n" +
        "SYNCOPE\n" +
        "5 WEST END DR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : CENTER BEACH AVE * SIDEWALK LANE \n" +
        "Caller: GARVIN'S RENTALS\n" +
        "Water\\Info: HLFW63 CISTERN\n\n" +
        "Disp Time: 06/30/12 12:49:28",

        "ID:063012-53",
        "CALL:SYNCOPE",
        "ADDR:5 WEST END DR",
        "CITY:OLD LYME",
        "X:CENTER BEACH AVE & SIDEWALK LANE",
        "NAME:GARVIN'S RENTALS",
        "DATE:06/30/12",
        "TIME:12:49:28");

    doTest("T9",
        "(CAD Page for CFS 063012-65) \n" +
        "http://maps.google.com/maps?q=+41.31915%20-72.34690\n" +
        "MVA Medic ALS\n" +
        "2 N6970\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : RT9S TO I95N * EXIT 70 NB \n" +
        "Caller: AT&T MOBILITY\n" +
        "Water\\Info: HLHY BRIDGE * OSFD @ FILL POINT\n\n" +
        "Disp Time: 06/30/12 14:33:23",

        "ID:063012-65",
        "CALL:MVA Medic ALS",
        "ADDR:2 N6970",
        "CITY:OLD LYME",
        "X:RT9S TO I95N & EXIT 70 NB",
        "NAME:AT&T MOBILITY",
        "DATE:06/30/12",
        "TIME:14:33:23");

    doTest("T10",
        "(CAD Page for CFS 063012-90) \n" +
        "http://maps.google.com/maps?q=+41.35479%20-72.30378\n" +
        "Basic Life Support \n" +
        "54 ROGERS LAKE TR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : AVON ST * TAMIAMI TR \n" +
        "Caller: BAKOLEDIS,A\n" +
        "Water\\Info: HLFW40 5 DEVITT LOOP\n\n" +
        "Water\\Info: HLFW74 22 TOWN WOODS RD\n\n" +
        "Disp Time: 06/30/12 17:36:37",

        "ID:063012-90",
        "CALL:Basic Life Support",
        "ADDR:54 ROGERS LAKE TR",
        "CITY:OLD LYME",
        "X:AVON ST & TAMIAMI TR",
        "NAME:BAKOLEDIS,A",
        "DATE:06/30/12",
        "TIME:17:36:37");

    doTest("T11",
        "(CAD Page for CFS 063012-103) \n" +
        "http://maps.google.com/maps?q=+41.36244%20-72.29684\n" +
        "GENERAL WEAKNESS\n" +
        "55 HICKORY ST\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : AVENUE F * AVENUE G \n" +
        "Caller: WANAT,GEORGE\n" +
        "Disp Time: 06/30/12 21:09:24",

        "ID:063012-103",
        "CALL:GENERAL WEAKNESS",
        "ADDR:55 HICKORY ST",
        "CITY:OLD LYME",
        "X:AVENUE F & AVENUE G",
        "NAME:WANAT,GEORGE",
        "DATE:06/30/12",
        "TIME:21:09:24");

    doTest("T12",
        "(CAD Page for CFS 070112-44) \n" +
        "http://maps.google.com/maps?q=+41.30718%20-72.29227\n" +
        "Seizures ALS\n" +
        "5 FLAT ROCK HILL RD\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : MILE CREEK RD * BROWNS LANE \n" +
        "Caller: PEARSON,MARK & BRENDA\n" +
        "Disp Time: 07/01/12 15:55:41",

        "ID:070112-44",
        "CALL:Seizures ALS",
        "ADDR:5 FLAT ROCK HILL RD",
        "CITY:OLD LYME",
        "X:MILE CREEK RD & BROWNS LANE",
        "NAME:PEARSON,MARK & BRENDA",
        "DATE:07/01/12",
        "TIME:15:55:41");

    doTest("T13",
        "(CAD Page for CFS 070112-75) \n" +
        "http://maps.google.com/maps?q=+41.28461%20-72.27786\n" +
        "Unconcious/Unresponsive ALS\n" +
        "88 HARTFORD AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : POND RD \n" +
        "Caller: \n" +
        "Water\\Info: HLHY 23 HARTFORD AV\n\n" +
        "Disp Time: 07/01/12 17:44:58",

        "ID:070112-75",
        "CALL:Unconcious/Unresponsive ALS",
        "ADDR:88 HARTFORD AVE",
        "CITY:OLD LYME",
        "X:POND RD",
        "DATE:07/01/12",
        "TIME:17:44:58");

    doTest("T14",
        "(CAD Page for CFS 070212-31) \n" +
        "http://maps.google.com/maps?q=+41.30627%20-72.25845\n" +
        "Injured Person  BLS\n" +
        "436 SHORE RD\n" +
        "Apt: 108\n" +
        "OL       \n" +
        "Cross Streets : MILE CREEK RD * RIVERDALE LANDING \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: HLFW55 8 BANK RD MARINA\n\n" +
        "Water\\Info: HLFW53 304 MILE CREEK RD\n\n" +
        "Water\\Info: BAYBERRY MOTEL * KNOX BOX * R OF OFFICE DOOR * MASTER KEY FOR ALL ROOMS\n\n" +
        "Disp Time: 07/02/12 11:33:49",

        "ID:070212-31",
        "CALL:Injured Person  BLS",
        "ADDR:436 SHORE RD",
        "APT:108",
        "CITY:OLD LYME",
        "X:MILE CREEK RD & RIVERDALE LANDING",
        "NAME:VERIZON WIRELESS",
        "DATE:07/02/12",
        "TIME:11:33:49");

    doTest("T15",
        "(CAD Page for CFS 070212-32) \n" +
        "http://maps.google.com/maps?q=+41.30123%20-72.27529\n" +
        "Injured Person  BLS\n" +
        "3 CHANTICLEER LANE\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : WYCHWOOD RD \n" +
        "Caller: POLLACK,LITA\n" +
        "Disp Time: 07/02/12 12:16:00",

        "ID:070212-32",
        "CALL:Injured Person  BLS",
        "ADDR:3 CHANTICLEER LANE",
        "CITY:OLD LYME",
        "X:WYCHWOOD RD",
        "NAME:POLLACK,LITA",
        "DATE:07/02/12",
        "TIME:12:16:00");

    doTest("T16",
        "(CAD Page for CFS 070212-37) \n" +
        "http://maps.google.com/maps?q=+41.33535%20-72.31360\n" +
        "Respiratory Distress ALS\n" +
        "48 BOSTON POST RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : BOGGY HOLE RD * BLACKWELL LANE \n" +
        "Caller: BARBATO,CHRISTINE\n" +
        "Water\\Info: HLFW30 40 BOSTON POST RD\n\n" +
        "Disp Time: 07/02/12 13:25:45",

        "ID:070212-37",
        "CALL:Respiratory Distress ALS",
        "ADDR:48 BOSTON POST RD",
        "CITY:OLD LYME",
        "X:BOGGY HOLE RD & BLACKWELL LANE",
        "NAME:BARBATO,CHRISTINE",
        "DATE:07/02/12",
        "TIME:13:25:45");

    doTest("T17",
        "(CAD Page for CFS 070412-42) \n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000\n" +
        "Basic Life Support \n" +
        "hartford av\n" +
        "Apt: \n" +
        "ol\n" +
        "Caller: \n" +
        "Disp Time: 07/04/12 14:58:30",

        "ID:070412-42",
        "CALL:Basic Life Support",
        "ADDR:hartford av",
        "MADDR:hartford ave",
        "CITY:OLD LYME",
        "DATE:07/04/12",
        "TIME:14:58:30");

    doTest("T18",
        "(CAD Page for CFS 070412-57) \n" +
        "http://maps.google.com/maps?q=+41.28034%20-72.28979\n" +
        "Injured Person  BLS\n" +
        "100 WEST END DR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SIDEWALK LANE \n" +
        "Caller: KAYLIN,WALTER\n" +
        "Water\\Info: HLFW63 CISTERN\n\n" +
        "Disp Time: 07/04/12 18:20:14",

        "ID:070412-57",
        "CALL:Injured Person  BLS",
        "ADDR:100 WEST END DR",
        "CITY:OLD LYME",
        "X:SIDEWALK LANE",
        "NAME:KAYLIN,WALTER",
        "DATE:07/04/12",
        "TIME:18:20:14");

    doTest("T19",
        "(CAD Page for CFS 070512-31) \n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000\n" +
        "Psychiatric BLS\n" +
        "OLD SHORE RD\n" +
        "Apt: \n" +
        "OL\n" +
        "Caller: CSP\n" +
        "Disp Time: 07/05/12 11:40:22",

        "ID:070512-31",
        "CALL:Psychiatric BLS",
        "ADDR:OLD SHORE RD",
        "CITY:OLD LYME",
        "NAME:CSP",
        "DATE:07/05/12",
        "TIME:11:40:22");

    doTest("T20",
        "(CAD Page for CFS 070512-54) \n" +
        "http://maps.google.com/maps?q=+41.30798%20-72.30020\n" +
        "Psychiatric BLS\n" +
        "25 ROWLAND RD\n" +
        "Apt: -1\n" +
        "OL       \n" +
        "Cross Streets : MILE CREEK RD \n" +
        "Caller: COOK,RICHARD J\n" +
        "Water\\Info: HLFW32 70 ROWLAND RD\n\n" +
        "Disp Time: 07/05/12 15:58:07",

        "ID:070512-54",
        "CALL:Psychiatric BLS",
        "ADDR:25 ROWLAND RD",
        "APT:-1",
        "CITY:OLD LYME",
        "X:MILE CREEK RD",
        "NAME:COOK,RICHARD J",
        "DATE:07/05/12",
        "TIME:15:58:07");

    doTest("T21",
        "(CAD Page for CFS 070512-66) \n" +
        "http://maps.google.com/maps?q=+41.34836%20-72.29934\n" +
        "Injured Person  BLS\n" +
        "166 BOSTON POST RD\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : TOWN WOODS RD * BOUGHTON RD \n" +
        "Caller: AT&T MOBILITY\n" +
        "Water\\Info: HLFW84 9 BOUGHTON RD\n\n" +
        "Water\\Info: HLFW34 172 BOSTON POST RD\n\n" +
        "Disp Time: 07/05/12 20:10:31",

        "ID:070512-66",
        "CALL:Injured Person  BLS",
        "ADDR:166 BOSTON POST RD",
        "CITY:OLD LYME",
        "X:TOWN WOODS RD & BOUGHTON RD",
        "NAME:AT&T MOBILITY",
        "DATE:07/05/12",
        "TIME:20:10:31");

    doTest("T22",
        "(CAD Page for CFS 070512-68) \n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000\n" +
        "Respiratory Distress ALS\n" +
        "HAWKS nest beach rd\n" +
        "Apt: e5\n" +
        "ol\n" +
        "Caller: \n" +
        "Disp Time: 07/05/12 20:38:57",

        "ID:070512-68",
        "CALL:Respiratory Distress ALS",
        "ADDR:HAWKS nest beach rd", // Not mapping
        "APT:e5",
        "CITY:OLD LYME",
        "DATE:07/05/12",
        "TIME:20:38:57");

    doTest("T23",
        "(CAD Page for CFS 070512-75) \n" +
        "http://maps.google.com/maps?q=+41.28771%20-72.27810\n" +
        "Chest Pain ALS\n" +
        "36 HARTFORD AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SHORE RD * BOCCE LANE \n" +
        "Caller: PAPPACENO,J\n" +
        "Water\\Info: HLHY 23 HARTFORD AV\n\n" +
        "Disp Time: 07/05/12 23:32:28",

        "ID:070512-75",
        "CALL:Chest Pain ALS",
        "ADDR:36 HARTFORD AVE",
        "CITY:OLD LYME",
        "X:SHORE RD & BOCCE LANE",
        "NAME:PAPPACENO,J",
        "DATE:07/05/12",
        "TIME:23:32:28");

    doTest("T24",
        "(CAD Page for CFS 070612-8) \n" +
        "http://maps.google.com/maps?q=+41.32356%20-72.32825\n" +
        "MVA Medic ALS\n" +
        "1 S7070\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : LYME ST * NECK RD \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: TSFW50 1 ENTERPRISE DR\n\n" +
        "Disp Time: 07/06/12 08:12:48",

        "ID:070612-8",
        "CALL:MVA Medic ALS",
        "ADDR:1 S7070",
        "CITY:OLD LYME",
        "X:LYME ST & NECK RD",
        "NAME:VERIZON WIRELESS",
        "DATE:07/06/12",
        "TIME:08:12:48");

    doTest("T25",
        "(CAD Page for CFS 070612-12) \n" +
        "http://maps.google.com/maps?q=+41.28749%20-72.27522\n" +
        "Injured Person  BLS\n" +
        "33 GORTON AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : BROUGHEL AVE * MAPLE AVE \n" +
        "Caller: EPSTEIN, ELAINE\n" +
        "Water\\Info: HLHY 34 GORTON AV\n\n" +
        "Disp Time: 07/06/12 08:34:11",

        "ID:070612-12",
        "CALL:Injured Person  BLS",
        "ADDR:33 GORTON AVE",
        "CITY:OLD LYME",
        "X:BROUGHEL AVE & MAPLE AVE",
        "NAME:EPSTEIN, ELAINE",
        "DATE:07/06/12",
        "TIME:08:34:11");

    doTest("T26",
        "(CAD Page for CFS 070612-22) \n" +
        "http://maps.google.com/maps?q=+41.34414%20-72.30615\n" +
        "Respiratory Distress ALS\n" +
        "124 BOSTON POST RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SUNSET DR * APPLE TREE DR \n" +
        "Caller: EBBETS, MARGARET\n" +
        "Water\\Info: HLFW21 97 SILL LA\n\n" +
        "Disp Time: 07/06/12 10:20:39",

        "ID:070612-22",
        "CALL:Respiratory Distress ALS",
        "ADDR:124 BOSTON POST RD",
        "CITY:OLD LYME",
        "X:SUNSET DR & APPLE TREE DR",
        "NAME:EBBETS, MARGARET",
        "DATE:07/06/12",
        "TIME:10:20:39");

    doTest("T27",
        "(CAD Page for CFS 070612-32) \n" +
        "http://maps.google.com/maps?q=+41.28270%20-72.30608\n" +
        "Traumatic Injury ALS\n" +
        "9 SPRINGFIELD RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : HOWARD RD * SEASIDE LANE \n" +
        "Caller: BRADLEY W PATRICK\n" +
        "Water\\Info: HLFW48 4 GRISWOLD PT\n\n" +
        "Disp Time: 07/06/12 13:43:39",

        "ID:070612-32",
        "CALL:Traumatic Injury ALS",
        "ADDR:9 SPRINGFIELD RD",
        "CITY:OLD LYME",
        "X:HOWARD RD & SEASIDE LANE",
        "NAME:BRADLEY W PATRICK",
        "DATE:07/06/12",
        "TIME:13:43:39");

    doTest("T28",
        "(CAD Page for CFS 070612-44) \n" +
        "http://maps.google.com/maps?q=+41.30684%20-72.26255\n" +
        "Respiratory Distress ALS\n" +
        "2 ASCOT LANE\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : CHESTNUT HILL RD \n" +
        "Caller: KATZ,BARBARA\n" +
        "Disp Time: 07/06/12 15:06:14",

        "ID:070612-44",
        "CALL:Respiratory Distress ALS",
        "ADDR:2 ASCOT LANE",
        "CITY:OLD LYME",
        "X:CHESTNUT HILL RD",
        "NAME:KATZ,BARBARA",
        "DATE:07/06/12",
        "TIME:15:06:14");

    doTest("T29",
        "(CAD Page for CFS 070612-90) \n" +
        "http://maps.google.com/maps?q=+41.28541%20-72.28234\n" +
        "Traumatic Injury ALS\n" +
        "54 COLUMBUS AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : LIBERTY ST * AVENUE A \n" +
        "Caller: YOUNG,PAUL\n" +
        "Water\\Info: HLHY 244 SHORE RD\n\n" +
        "Disp Time: 07/06/12 23:13:15",

        "ID:070612-90",
        "CALL:Traumatic Injury ALS",
        "ADDR:54 COLUMBUS AVE",
        "CITY:OLD LYME",
        "X:LIBERTY ST & AVENUE A",
        "NAME:YOUNG,PAUL",
        "DATE:07/06/12",
        "TIME:23:13:15");

    doTest("T30",
        "(CAD Page for CFS 070712-31) \n" +
        "http://maps.google.com/maps?q=+41.28541%20-72.28234\n" +
        "ALTERED MENTAL STATUS\n" +
        "54 COLUMBUS AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : LIBERTY ST * AVENUE A \n" +
        "Caller: YOUNG,PAUL\n" +
        "Water\\Info: HLHY 244 SHORE RD\n\n" +
        "Disp Time: 07/07/12 13:38:33",

        "ID:070712-31",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:54 COLUMBUS AVE",
        "CITY:OLD LYME",
        "X:LIBERTY ST & AVENUE A",
        "NAME:YOUNG,PAUL",
        "DATE:07/07/12",
        "TIME:13:38:33");

    doTest("T31",
        "(CAD Page for CFS 070712-47) \n" +
        "http://maps.google.com/maps?q=+41.32367%20-72.32745\n" +
        "Respiratory Distress ALS\n" +
        "85 LYME ST\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : HALLS RD * EXIT 70 SB \n" +
        "Caller: LLC,OPEN OPPORTUNITY\n" +
        "Water\\Info: HLFW10 11 HALLS RD\n\n" +
        "Disp Time: 07/07/12 15:53:40",

        "ID:070712-47",
        "CALL:Respiratory Distress ALS",
        "ADDR:85 LYME ST",
        "CITY:OLD LYME",
        "X:HALLS RD & EXIT 70 SB",
        "NAME:LLC,OPEN OPPORTUNITY",
        "DATE:07/07/12",
        "TIME:15:53:40");

    doTest("T32",
        "(CAD Page for CFS 070912-46) \n" +
        "http://maps.google.com/maps?q=+41.30123%20-72.27529\n" +
        "Lift Assist BLS\n" +
        "3 CHANTICLEER LANE\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : WYCHWOOD RD \n" +
        "Caller: POLLACK,LITA\n" +
        "Disp Time: 07/09/12 13:53:24",

        "ID:070912-46",
        "CALL:Lift Assist BLS",
        "ADDR:3 CHANTICLEER LANE",
        "CITY:OLD LYME",
        "X:WYCHWOOD RD",
        "NAME:POLLACK,LITA",
        "DATE:07/09/12",
        "TIME:13:53:24");

    doTest("T33",
        "(CAD Page for CFS 071012-36) \n" +
        "http://maps.google.com/maps?q=+41.32120%20-72.33965\n" +
        "Psychiatric BLS\n" +
        "21 NECK RD\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : ENTR 70 SB * OLD BRIDGE RD \n" +
        "Caller: AT&T MOBILITY\n" +
        "Water\\Info: HLFW24 OL MARINA\n\n" +
        "Disp Time: 07/10/12 13:51:15",

        "ID:071012-36",
        "CALL:Psychiatric BLS",
        "ADDR:21 NECK RD",
        "CITY:OLD LYME",
        "X:ENTR 70 SB & OLD BRIDGE RD",
        "NAME:AT&T MOBILITY",
        "DATE:07/10/12",
        "TIME:13:51:15");

    doTest("T34",
        "(CAD Page for CFS 071012-61) \n" +
        "http://maps.google.com/maps?q=+41.28525%20-72.28076\n" +
        "Hazmat\n" +
        "60 CORSINO AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : LIBERTY ST * BISCAYNE BLVD \n" +
        "Caller: TROOP-F\n" +
        "Water\\Info: HLHY S6S SHORE RD\n\n" +
        "Disp Time: 07/10/12 22:53:16",

        "ID:071012-61",
        "CALL:Hazmat",
        "ADDR:60 CORSINO AVE",
        "CITY:OLD LYME",
        "X:LIBERTY ST & BISCAYNE BLVD",
        "NAME:TROOP-F",
        "DATE:07/10/12",
        "TIME:22:53:16");

    doTest("T35",
        "(CAD Page for CFS 071112-37) \n" +
        "http://maps.google.com/maps?q=+41.28551%20-72.27319\n" +
        "Injured Person  BLS\n" +
        "59 SALTAIRE DR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : BELLAIRE RD * SEA LANE \n" +
        "Caller: MARSHALL,JAMES R\n" +
        "Water\\Info: HLHY 70 SEASPRAY RD\n\n" +
        "Disp Time: 07/11/12 12:58:30",

        "ID:071112-37",
        "CALL:Injured Person  BLS",
        "ADDR:59 SALTAIRE DR",
        "CITY:OLD LYME",
        "X:BELLAIRE RD & SEA LANE",
        "NAME:MARSHALL,JAMES R",
        "DATE:07/11/12",
        "TIME:12:58:30");

    doTest("T36",
        "(CAD Page for CFS 071112-39) \n" +
        "http://maps.google.com/maps?q=+41.30741%20-72.25650\n" +
        "Advanced Life Support\n" +
        "445 SHORE RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : RIVERDALE LANDING * RIVER RD \n" +
        "Caller: csp\n" +
        "Water\\Info: HLFW55 8 BANK RD MARINA\n\n" +
        "Water\\Info: HLFW53 304 MILE CREEK RD\n\n" +
        "Disp Time: 07/11/12 13:37:00",

        "ID:071112-39",
        "CALL:Advanced Life Support",
        "ADDR:445 SHORE RD",
        "CITY:OLD LYME",
        "X:RIVERDALE LANDING & RIVER RD",
        "NAME:csp",
        "DATE:07/11/12",
        "TIME:13:37:00");

    doTest("T37",
        "(CAD Page for CFS 071112-60) \n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000\n" +
        "Marine Rescue\n" +
        "CT RIVER MARKER 7\n" +
        "Apt: \n" +
        "OL\n" +
        "Caller: OLD SAYBROOK\n" +
        "Disp Time: 07/11/12 20:48:21",

        "ID:071112-60",
        "CALL:Marine Rescue",
        "ADDR:CT RIVER MARKER 7",
        "CITY:OLD LYME",
        "NAME:OLD SAYBROOK",
        "DATE:07/11/12",
        "TIME:20:48:21");

    doTest("T38",
        "(CAD Page for CFS 071112-66) \n" +
        "http://maps.google.com/maps?q=+41.29445%20-72.25405\n" +
        "Advanced Life Support\n" +
        "53 HILLCREST RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SARGENT RD * CARRINGTON RD \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: TSFW57 BOAT BASIN\n\n" +
        "Disp Time: 07/11/12 23:53:52",

        "ID:071112-66",
        "CALL:Advanced Life Support",
        "ADDR:53 HILLCREST RD",
        "CITY:OLD LYME",
        "X:SARGENT RD & CARRINGTON RD",
        "NAME:VERIZON WIRELESS",
        "DATE:07/11/12",
        "TIME:23:53:52");

    doTest("T39",
        "(CAD Page for CFS 071212-17) \n" +
        "http://maps.google.com/maps?q=+41.28875%20-72.27919\n" +
        "Fall 10  -ALS\n" +
        "18 PORTLAND AVE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SHORE RD * BOCCE LANE \n" +
        "Caller: \n" +
        "Water\\Info: HLHY 51 PORTLAND AV\n\n" +
        "Disp Time: 07/12/12 09:57:25",

        "ID:071212-17",
        "CALL:Fall 10  -ALS",
        "ADDR:18 PORTLAND AVE",
        "CITY:OLD LYME",
        "X:SHORE RD & BOCCE LANE",
        "DATE:07/12/12",
        "TIME:09:57:25");

    doTest("T40",
        "(CAD Page for CFS 071212-35) \n" +
        "http://maps.google.com/maps?q=+41.33588%20-72.31274\n" +
        "Advanced Life Support\n" +
        "58 BOSTON POST RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : BOGGY HOLE RD * BLACKWELL LANE \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: HLFW30 40 BOSTON POST RD\n\n" +
        "Disp Time: 07/12/12 13:22:33",

        "ID:071212-35",
        "CALL:Advanced Life Support",
        "ADDR:58 BOSTON POST RD",
        "CITY:OLD LYME",
        "X:BOGGY HOLE RD & BLACKWELL LANE",
        "NAME:VERIZON WIRELESS",
        "DATE:07/12/12",
        "TIME:13:22:33");

    doTest("T41",
        "(CAD Page for CFS 071312-12) \n" +
        "http://maps.google.com/maps?q=+41.34942%20-72.28587\n" +
        "Advanced Life Support\n" +
        "249 BOSTON POST RD\n" +
        "Apt: 1\n" +
        "OL       \n" +
        "Cross Streets : LORDS MEADOW LANE * LYMEWOOD HOUSING \n" +
        "Caller: CANCRO,CARMINE\n" +
        "Water\\Info: HLFW35 245 BOSTON POST RD\n\n" +
        "Water\\Info: LYMEWOOD HOUSING * 1ST BLDG ON LEFT * KNOX BOX TO RIGHT OF FRONT DOOR\n\n" +
        "Disp Time: 07/13/12 07:34:26",

        "ID:071312-12",
        "CALL:Advanced Life Support",
        "ADDR:249 BOSTON POST RD",
        "APT:1",
        "CITY:OLD LYME",
        "X:LORDS MEADOW LANE & LYMEWOOD HOUSING",
        "NAME:CANCRO,CARMINE",
        "DATE:07/13/12",
        "TIME:07:34:26");

    doTest("T42",
        "(CAD Page for CFS 071312-32) \n" +
        "http://maps.google.com/maps?q=+41.31145%20-72.40325\n" +
        "Structure Fire\n" +
        "1 PHEASANT HILL LANE\n" +
        "Apt: \n" +
        "OS       \n" +
        "Cross Streets : INGHAM HILL RD * WILD APPLE LANE \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Disp Time: 07/13/12 11:53:06",

        "ID:071312-32",
        "CALL:Structure Fire",
        "ADDR:1 PHEASANT HILL LANE",
        "CITY:OLD SAYBROOK",
        "X:INGHAM HILL RD & WILD APPLE LANE",
        "NAME:VERIZON WIRELESS",
        "DATE:07/13/12",
        "TIME:11:53:06");

    doTest("T43",
        "(CAD Page for CFS 071312-40) \n" +
        "http://maps.google.com/maps?q=+41.34791%20-72.34145\n" +
        "Seizures ALS\n" +
        "17 COULT LANE\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : NECK RD * TANTUMMAHEAG RD \n" +
        "Caller: GEIST,MICHELE\n" +
        "Water\\Info: TSFW72 10 TANTUMMAHEAG RD\n\n" +
        "Disp Time: 07/13/12 13:02:27",

        "ID:071312-40",
        "CALL:Seizures ALS",
        "ADDR:17 COULT LANE",
        "CITY:OLD LYME",
        "X:NECK RD & TANTUMMAHEAG RD",
        "NAME:GEIST,MICHELE",
        "DATE:07/13/12",
        "TIME:13:02:27");

    doTest("T44",
        "(CAD Page for CFS 071312-65) \n" +
        "http://maps.google.com/maps?q=+41.29526%20-72.25557\n" +
        "Seizures ALS\n" +
        "33 HILLCREST RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : CONNECTICUT RD * OAK RD \n" +
        "Caller: BERG,IRENE W\n" +
        "Water\\Info: TSFW57 BOAT BASIN\n\n" +
        "Disp Time: 07/13/12 19:33:06",

        "ID:071312-65",
        "CALL:Seizures ALS",
        "ADDR:33 HILLCREST RD",
        "CITY:OLD LYME",
        "X:CONNECTICUT RD & OAK RD",
        "NAME:BERG,IRENE W",
        "DATE:07/13/12",
        "TIME:19:33:06");

    doTest("T45",
        "(CAD Page for CFS 071312-68) \n" +
        "http://maps.google.com/maps?q=+41.28572%20-72.28076\n" +
        "Chest Pain ALS\n" +
        "54 CORSINO AVE\n" +
        "Apt: \n" +
        "OL\n" +
        "Cross Streets : LIBERTY ST * BISCAYNE BLVD \n" +
        "Caller: SCHMIDT,EDWARD L\n" +
        "Disp Time: 07/13/12 20:18:46",

        "ID:071312-68",
        "CALL:Chest Pain ALS",
        "ADDR:54 CORSINO AVE",
        "CITY:OLD LYME",
        "X:LIBERTY ST & BISCAYNE BLVD",
        "NAME:SCHMIDT,EDWARD L",
        "DATE:07/13/12",
        "TIME:20:18:46");

    doTest("T46",
        "(CAD Page for CFS 071412-5) \n" +
        "http://maps.google.com/maps?q=+41.31332%20-72.33125\n" +
        "Respiratory Distress ALS\n" +
        "9 LYME ST\n" +
        "Apt: 1A\n" +
        "OL\n" +
        "Cross Streets : FERRY RD * ACADEMY LANE \n" +
        "Caller: MC*NEMER,P HASTINGS\n" +
        "Disp Time: 07/14/12 07:47:42",

        "ID:071412-5",
        "CALL:Respiratory Distress ALS",
        "ADDR:9 LYME ST",
        "APT:1A",
        "CITY:OLD LYME",
        "X:FERRY RD & ACADEMY LANE",
        "NAME:MC*NEMER,P HASTINGS",
        "DATE:07/14/12",
        "TIME:07:47:42");

    doTest("T47",
        "(CAD Page for CFS 071412-11) \n" +
        "http://maps.google.com/maps?q=+41.28548%20-72.29464\n" +
        "Abdominal Pain BLS\n" +
        "9 HAYWAGON DR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SHORE RD * CORD GRASS LANE \n" +
        "Caller: MAZZOTTA, JOHN\n" +
        "Water\\Info: HLHY 11 HAYWAGON DR\n\n" +
        "Disp Time: 07/14/12 09:37:42",

        "ID:071412-11",
        "CALL:Abdominal Pain BLS",
        "ADDR:9 HAYWAGON DR",
        "CITY:OLD LYME",
        "X:SHORE RD & CORD GRASS LANE",
        "NAME:MAZZOTTA, JOHN",
        "DATE:07/14/12",
        "TIME:09:37:42");

    doTest("T48",
        "(CAD Page for CFS 071412-79) \n" +
        "http://maps.google.com/maps?q=+41.28034%20-72.28993\n" +
        "Cardiac Arrest ALS\n" +
        "102 WEST END DR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : SIDEWALK LANE \n" +
        "Caller: MONKS, WILLIAM\n" +
        "Water\\Info: HLFW63 CISTERN\n\n" +
        "Disp Time: 07/14/12 20:56:51",

        "ID:071412-79",
        "CALL:Cardiac Arrest ALS",
        "ADDR:102 WEST END DR",
        "CITY:OLD LYME",
        "X:SIDEWALK LANE",
        "NAME:MONKS, WILLIAM",
        "DATE:07/14/12",
        "TIME:20:56:51");

    doTest("T49",
        "(CAD Page for CFS 071512-13) \n" +
        "http://maps.google.com/maps?q=+41.36070%20-72.29430\n" +
        "Injured Person  BLS\n" +
        "5 COACH DR\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : GRASSY HILL RD \n" +
        "Caller: AT&T MOBILITY\n" +
        "Water\\Info: HLFW38 94 GRASSY HILL RD\n\n" +
        "Disp Time: 07/15/12 03:57:55",

        "ID:071512-13",
        "CALL:Injured Person  BLS",
        "ADDR:5 COACH DR",
        "CITY:OLD LYME",
        "X:GRASSY HILL RD",
        "NAME:AT&T MOBILITY",
        "DATE:07/15/12",
        "TIME:03:57:55");

    doTest("T50",
        "(CAD Page for CFS 071512-16) \n" +
        "http://maps.google.com/maps?q=+41.30798%20-72.33295\n" +
        "MVA Medic ALS\n" +
        "22 SHORE RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : FERRY RD * AMTRAK \n" +
        "Caller: VERIZON WIRELESS\n" +
        "Water\\Info: HLFW07 300 FERRY RD\n\n" +
        "Disp Time: 07/15/12 08:10:45",

        "ID:071512-16",
        "CALL:MVA Medic ALS",
        "ADDR:22 SHORE RD",
        "CITY:OLD LYME",
        "X:FERRY RD & AMTRAK",
        "NAME:VERIZON WIRELESS",
        "DATE:07/15/12",
        "TIME:08:10:45");

    doTest("T51",
        "(CAD Page for CFS 071512-25) \n" +
        "http://maps.google.com/maps?q=+41.28534%20-72.27652\n" +
        "Injured Person  BLS\n" +
        "69 OLD COLONY RD\n" +
        "Apt: \n" +
        "OL       \n" +
        "Cross Streets : PURTILL AVE * HARTUNG PL \n" +
        "Caller: \n" +
        "Water\\Info: HLHY 59 OLD COLONY\n\n" +
        "Disp Time: 07/15/12 09:46:44\n\n\n",

        "ID:071512-25",
        "CALL:Injured Person  BLS",
        "ADDR:69 OLD COLONY RD",
        "CITY:OLD LYME",
        "X:PURTILL AVE & HARTUNG PL",
        "DATE:07/15/12",
        "TIME:09:46:44");

  }
  
  public static void main(String[] args) {
    new CTMiddlesexCountyParserTest().generateTests("T1");
  }
}