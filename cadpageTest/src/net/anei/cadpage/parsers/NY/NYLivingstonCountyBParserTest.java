package net.anei.cadpage.parsers.NY;

import org.junit.Test;

import net.anei.cadpage.parsers.BaseParserTest;


/*
Livingston County, NY
Contact: Active911
Agency name: Hemlock Fire Dept
Location: Hemlock, NY, United States
Sender: hemlockfd@rochester.rr.com, hemlockfire@rochester.twcbc.com 

(5870 BIG TREE RD) Dispatch ** 17:37 ** Structure ** 5870 BIG TREE RD ** LAKEVILLE PK/RUSSELL DR-NORTH ** JULIE MCGEE ** 
(7427 PLEASANT ST) Dispatch **  ** Cont. Burn ** 7427 PLEASANT ST ** MAIN ST/E DEAD END- ** STEPHEN G MOORE ** 
(7275 COY RD) Dispatch ** 22:01 ** Structure ** 7275 COY RD ** FEDERAL RD/PLANK RD- ** CARL SPENCER ** 
(HEMLOCK HONEOYE RD) Dispatch ** 20:04 ** MVA 8 ** HEMLOCK HONEOYE RD/MAIN ST ** - ** AMBER PUCKNET ** 
(7618 BIG TREE RD) Dispatch ** 02:10 ** MVA 3 ** 7618 BIG TREE RD ** CLAY ST/ONTARIO COUNTY LINE- ** ROBERT STEKL ** 
(BIG TREE RD) Dispatch **  ** MVA 3 ** BIG TREE RD/MAIN ST ** - ** JAMES S MOORE ** 
(7412 RIX HILL RD) Dispatch **  ** Fire Alarm 1 ** 7412 RIX HILL RD ** BLANK RD/HEMLOCK LAUNCH RD-ROC ** AUTODIALER ** 
(3164 PLANK RD) Dispatch ** 13:48 ** MVA 3 ** 3164 PLANK RD ** GREENE VILLAGE DR/STONE HILL R ** GABRIELLE YOUNG ** 
(5129 E LAKE RD) Dispatch ** 22:17 ** Fire Type Unk ** 5129 E LAKE RD ** HARTSON PT/HOLMES HILL RD-LAKE ** SHELTON MOYER ** 
(21 BIG TREE ST) Dispatch ** 20:57 ** Structure ** 21 BIG TREE ST ** W LIVONIA TOWN LINE/LAKE GLEN ** KEVIN DOUGHERTY ** 
(5168 MARROWBACK RD) Dispatch **  ** Cont. Burn ** 5168 MARROWBACK RD ** HARDER RD/NIVER RD- ** WILLIAM BROWN ** 
(4830 COHWY 36) Dispatch **  ** Stand By Fire ** 4830 COHWY 36 ** USHWY 20A/BRIGGS ST-HONEOYE RI ** ONTARIO COUNTY ** 
(5141 BALD HILL RD) Dispatch **  ** Wires ** 5141 BALD HILL RD ** OLD BALD HILL RD/ONTARIO COUNT **  ** 
(7412 RIX HILL RD) Dispatch **  ** Chimney ** 7412 RIX HILL RD ** BLANK RD/HEMLOCK LAUNCH RD-ROC ** HEMLOCK WATER T ** 
(4830 COHWY 36) Dispatch **  ** Stand By Fire ** 4830 COHWY 36 ** USHWY 20A/BRIGGS ST-HONEOYE RI **  ** 
(5880 STHWY 15A) Dispatch **  ** Wires ** 5880 STHWY 15A ** PURCELL HILL RD/LAWRENCE HILL ** ONTARIO CO SHER ** 
(2934 DORAN RD AREA) Dispatch **  ** Grass ** 2934 DORAN RD AREA ** CHASE RD/TOWNLINE RD- ** JESSICA ALLIET ** 
(7381 CANADICE RD) Dispatch ** 23:04 ** MVA 6 ** 7381 CANADICE RD ** REYNOLDS GULL RD/WHEATON HILL ** ONTARIO CO FIRE ** 
(5992 BIG TREE RD) Dispatch ** 08:31 ** Rescue ** 5992 BIG TREE RD ** RUSSELL DR/CAMP RUN DR- ** SHARI DURNBURG ** 
(7400 RIX HILL RD) Dispatch **  ** Service ** 7400 RIX HILL RD ** BLANK RD/HEMLOCK LAUNCH RD-HEM ** ONTARIO CO ** 
(9730 LAWRENCE HILL RD) Dispatch **  ** Fire Alarm 1 ** 9730 LAWRENCE HILL RD ** LAWRENCE HILL RD/STHWY 15A- **  ** 
(8145 S MAIN ST) Dispatch **  ** Stand By Fire ** 8145 S MAIN ST ** DEPOT RD/LIME KILN RD-S/WATER ** SPRINGWATER FIR ** 
(4830 COHWY 36) Dispatch ** 11:28 ** Stand By Fire ** 4830 COHWY 36 ** USHWY 20A/BRIGGS ST-HONEOYE RI ** ONTARIO CO FIRE ** 
(7440 BIG TREE RD) Dispatch ** 08:39 ** Cont. Burn ** 7440 BIG TREE RD ** BETTYRUTH LN/CLAY ST- ** RONALD FARLEY ** 
(5492 MIDDLE RD) Dispatch **  ** Vehicle ** 5492 MIDDLE RD ** RICHMOND TOWN LINE/CURTIS RD- ** NATHAN COOK ** 
(9486 ACE RD) Dispatch ** 11:05 ** Structure ** 9486 ACE RD ** PURCELL RD/DEAD END- ** ONTARIO CO SO ** 
(5143 BLANK RD) Dispatch **  ** Fire Alarm 1 ** 5143 BLANK RD ** HARDER RD/NIVER RD- ** ADT ** 
(ADAMS RD) Dispatch **  ** MVA 3 ** ADAMS RD/LINDSLEY RD ** - ** TONY WASHBURN ** 
(6131 BIG TREE RD) Dispatch ** 09:22 ** Structure ** 6131 BIG TREE RD ** BRONSON HILL RD/PENNEMITE RD-C ** ANN HARRIS ** 
(4872 S LIVONIA RD) Dispatch **  ** MVA 8 ** 4872 S LIVONIA RD ** PRICE RD/HAAKS PASS- ** TOM TOFFENY ** 
(STHWY 15A) Dispatch **  ** MVA 3 ** STHWY 15A/PURCELL HILL RD ** - ** BILL MARTIN ** 
(5927 STHWY 15A) Dispatch **  ** MVA 3 ** 5927 STHWY 15A ** PURCELL HILL RD/LAWRENCE HILL ** ONTARIO CO ** 
(6242 SERENITY DR) Dispatch ** 12:11 ** Structure ** 6242 SERENITY DR ** DEAD END/COHWY 37- ** LISA DUZAK ** 
(7440 BIG TREE RD) Dispatch **  ** Cont. Burn ** 7440 BIG TREE RD ** BETTYRUTH LN/CLAY ST- ** RONALD FRALEY ** 
(4213 S LIVONIA RD) Dispatch **  ** Stand By Fire ** 4213 S LIVONIA RD ** S LIVONIA VILLAGE LIMI/MEMORIA **  ** 
(7270 ADAMS RD) Dispatch **  ** Fire Alarm 1 ** 7270 ADAMS RD ** BLANK RD/MAIN ST- ** TWC ** 
(STHWY 15A) Dispatch **  ** Smoke Invest. ** STHWY 15A/PURCELL HILL RD ** - ** ONTARIO CO ** 
(3559 PEBBLE BEACH RD) Dispatch ** 11:04 ** Structure ** 3559 PEBBLE BEACH RD ** BIG TREE RD/CLUNY PT- ** SUSAN WHITMAN ** 
(1997 D"ANGELO DR) Dispatch ** 02:57 ** MVA 8 ** 1997 D"ANGELO DR ** W LAKE RD/E DEAD END-LIV CO WA ** DARCY BOOTH ** 
(4717 E LAKE RD) Dispatch ** 09:46 ** MVA 10 ** 4717 E LAKE RD ** CLEARY RD/PRICE RD- ** JASON BORDEN ** 

*/

public class NYLivingstonCountyBParserTest extends BaseParserTest {
  
  public NYLivingstonCountyBParserTest() {
    setParser(new NYLivingstonCountyBParser(), "LIVINGSTON COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(5870 BIG TREE RD) Dispatch ** 17:37 ** Structure ** 5870 BIG TREE RD ** LAKEVILLE PK/RUSSELL DR-NORTH ** JULIE MCGEE ** ",
        "TIME:17:37",
        "CALL:Structure",
        "ADDR:5870 BIG TREE RD",
        "X:LAKEVILLE PK/RUSSELL DR",
        "NAME:JULIE MCGEE");

    doTest("T2",
        "(7427 PLEASANT ST) Dispatch **  ** Cont. Burn ** 7427 PLEASANT ST ** MAIN ST/E DEAD END- ** STEPHEN G MOORE ** ",
        "CALL:Cont. Burn",
        "ADDR:7427 PLEASANT ST",
        "X:MAIN ST/E DEAD END",
        "NAME:STEPHEN G MOORE");

    doTest("T3",
        "(7275 COY RD) Dispatch ** 22:01 ** Structure ** 7275 COY RD ** FEDERAL RD/PLANK RD- ** CARL SPENCER ** ",
        "TIME:22:01",
        "CALL:Structure",
        "ADDR:7275 COY RD",
        "X:FEDERAL RD/PLANK RD",
        "NAME:CARL SPENCER");

    doTest("T4",
        "(HEMLOCK HONEOYE RD) Dispatch ** 20:04 ** MVA 8 ** HEMLOCK HONEOYE RD/MAIN ST ** - ** AMBER PUCKNET ** ",
        "TIME:20:04",
        "CALL:MVA 8",
        "ADDR:HEMLOCK HONEOYE RD & MAIN ST",
        "NAME:AMBER PUCKNET");

    doTest("T5",
        "(7618 BIG TREE RD) Dispatch ** 02:10 ** MVA 3 ** 7618 BIG TREE RD ** CLAY ST/ONTARIO COUNTY LINE- ** ROBERT STEKL ** ",
        "TIME:02:10",
        "CALL:MVA 3",
        "ADDR:7618 BIG TREE RD",
        "X:CLAY ST/ONTARIO COUNTY LINE",
        "NAME:ROBERT STEKL");

    doTest("T6",
        "(BIG TREE RD) Dispatch **  ** MVA 3 ** BIG TREE RD/MAIN ST ** - ** JAMES S MOORE ** ",
        "CALL:MVA 3",
        "ADDR:BIG TREE RD & MAIN ST",
        "NAME:JAMES S MOORE");

    doTest("T7",
        "(7412 RIX HILL RD) Dispatch **  ** Fire Alarm 1 ** 7412 RIX HILL RD ** BLANK RD/HEMLOCK LAUNCH RD-ROC ** AUTODIALER ** ",
        "CALL:Fire Alarm 1",
        "ADDR:7412 RIX HILL RD",
        "X:BLANK RD/HEMLOCK LAUNCH RD",
        "NAME:AUTODIALER");

    doTest("T8",
        "(3164 PLANK RD) Dispatch ** 13:48 ** MVA 3 ** 3164 PLANK RD ** GREENE VILLAGE DR/STONE HILL R ** GABRIELLE YOUNG ** ",
        "TIME:13:48",
        "CALL:MVA 3",
        "ADDR:3164 PLANK RD",
        "X:GREENE VILLAGE DR/STONE HILL R",
        "NAME:GABRIELLE YOUNG");

    doTest("T9",
        "(5129 E LAKE RD) Dispatch ** 22:17 ** Fire Type Unk ** 5129 E LAKE RD ** HARTSON PT/HOLMES HILL RD-LAKE ** SHELTON MOYER ** ",
        "TIME:22:17",
        "CALL:Fire Type Unk",
        "ADDR:5129 E LAKE RD",
        "X:HARTSON PT/HOLMES HILL RD",
        "NAME:SHELTON MOYER");

    doTest("T10",
        "(21 BIG TREE ST) Dispatch ** 20:57 ** Structure ** 21 BIG TREE ST ** W LIVONIA TOWN LINE/LAKE GLEN ** KEVIN DOUGHERTY ** ",
        "TIME:20:57",
        "CALL:Structure",
        "ADDR:21 BIG TREE ST",
        "X:W LIVONIA TOWN LINE/LAKE GLEN",
        "NAME:KEVIN DOUGHERTY");

    doTest("T11",
        "(5168 MARROWBACK RD) Dispatch **  ** Cont. Burn ** 5168 MARROWBACK RD ** HARDER RD/NIVER RD- ** WILLIAM BROWN ** ",
        "CALL:Cont. Burn",
        "ADDR:5168 MARROWBACK RD",
        "X:HARDER RD/NIVER RD",
        "NAME:WILLIAM BROWN");

    doTest("T12",
        "(4830 COHWY 36) Dispatch **  ** Stand By Fire ** 4830 COHWY 36 ** USHWY 20A/BRIGGS ST-HONEOYE RI ** ONTARIO COUNTY ** ",
        "CALL:Stand By Fire",
        "ADDR:4830 COHWY 36",
        "MADDR:4830 COUNTY ROAD 36", // is this NY 36? in Leicester
        "X:USHWY 20A/BRIGGS ST",
        "NAME:ONTARIO COUNTY");

    doTest("T13",
        "(5141 BALD HILL RD) Dispatch **  ** Wires ** 5141 BALD HILL RD ** OLD BALD HILL RD/ONTARIO COUNT **  ** ",
        "CALL:Wires",
        "ADDR:5141 BALD HILL RD",
        "X:OLD BALD HILL RD/ONTARIO COUNT");

    doTest("T14",
        "(7412 RIX HILL RD) Dispatch **  ** Chimney ** 7412 RIX HILL RD ** BLANK RD/HEMLOCK LAUNCH RD-ROC ** HEMLOCK WATER T ** ",
        "CALL:Chimney",
        "ADDR:7412 RIX HILL RD",
        "X:BLANK RD/HEMLOCK LAUNCH RD",
        "NAME:HEMLOCK WATER T");

    doTest("T15",
        "(4830 COHWY 36) Dispatch **  ** Stand By Fire ** 4830 COHWY 36 ** USHWY 20A/BRIGGS ST-HONEOYE RI **  ** ",
        "CALL:Stand By Fire",
        "ADDR:4830 COHWY 36",
        "MADDR:4830 COUNTY ROAD 36",
        "X:USHWY 20A/BRIGGS ST");

    doTest("T16",
        "(5880 STHWY 15A) Dispatch **  ** Wires ** 5880 STHWY 15A ** PURCELL HILL RD/LAWRENCE HILL ** ONTARIO CO SHER ** ",
        "CALL:Wires",
        "ADDR:5880 STHWY 15A", // found in Ontario County
        "X:PURCELL HILL RD/LAWRENCE HILL",
        "NAME:ONTARIO CO SHER");

    doTest("T17",
        "(2934 DORAN RD AREA) Dispatch **  ** Grass ** 2934 DORAN RD AREA ** CHASE RD/TOWNLINE RD- ** JESSICA ALLIET ** ",
        "CALL:Grass",
        "ADDR:2934 DORAN RD AREA", // word area is a bit of a problem
        "X:CHASE RD/TOWNLINE RD",
        "NAME:JESSICA ALLIET");

    doTest("T18",
        "(7381 CANADICE RD) Dispatch ** 23:04 ** MVA 6 ** 7381 CANADICE RD ** REYNOLDS GULL RD/WHEATON HILL ** ONTARIO CO FIRE ** ",
        "TIME:23:04",
        "CALL:MVA 6",
        "ADDR:7381 CANADICE RD",
        "X:REYNOLDS GULL RD/WHEATON HILL",
        "NAME:ONTARIO CO FIRE");

    doTest("T19",
        "(5992 BIG TREE RD) Dispatch ** 08:31 ** Rescue ** 5992 BIG TREE RD ** RUSSELL DR/CAMP RUN DR- ** SHARI DURNBURG ** ",
        "TIME:08:31",
        "CALL:Rescue",
        "ADDR:5992 BIG TREE RD",
        "X:RUSSELL DR/CAMP RUN DR",
        "NAME:SHARI DURNBURG");

    doTest("T20",
        "(7400 RIX HILL RD) Dispatch **  ** Service ** 7400 RIX HILL RD ** BLANK RD/HEMLOCK LAUNCH RD-HEM ** ONTARIO CO ** ",
        "CALL:Service",
        "ADDR:7400 RIX HILL RD",
        "X:BLANK RD/HEMLOCK LAUNCH RD",
        "NAME:ONTARIO CO");

    doTest("T21",
        "(9730 LAWRENCE HILL RD) Dispatch **  ** Fire Alarm 1 ** 9730 LAWRENCE HILL RD ** LAWRENCE HILL RD/STHWY 15A- **  ** ",
        "CALL:Fire Alarm 1",
        "ADDR:9730 LAWRENCE HILL RD", // appears to be in Ontario County with 3 locations: W, S and N
        "X:LAWRENCE HILL RD/STHWY 15A");

    doTest("T22",
        "(8145 S MAIN ST) Dispatch **  ** Stand By Fire ** 8145 S MAIN ST ** DEPOT RD/LIME KILN RD-S/WATER ** SPRINGWATER FIR ** ",
        "CALL:Stand By Fire",
        "ADDR:8145 S MAIN ST",
        "X:DEPOT RD/LIME KILN RD",
        "NAME:SPRINGWATER FIR");

    doTest("T23",
        "(4830 COHWY 36) Dispatch ** 11:28 ** Stand By Fire ** 4830 COHWY 36 ** USHWY 20A/BRIGGS ST-HONEOYE RI ** ONTARIO CO FIRE ** ",
        "TIME:11:28",
        "CALL:Stand By Fire",
        "ADDR:4830 COHWY 36",
        "MADDR:4830 COUNTY ROAD 36", // is this in Springwater?
        "X:USHWY 20A/BRIGGS ST",
        "NAME:ONTARIO CO FIRE");

    doTest("T24",
        "(7440 BIG TREE RD) Dispatch ** 08:39 ** Cont. Burn ** 7440 BIG TREE RD ** BETTYRUTH LN/CLAY ST- ** RONALD FARLEY ** ",
        "TIME:08:39",
        "CALL:Cont. Burn",
        "ADDR:7440 BIG TREE RD",
        "X:BETTYRUTH LN/CLAY ST",
        "NAME:RONALD FARLEY");

    doTest("T25",
        "(5492 MIDDLE RD) Dispatch **  ** Vehicle ** 5492 MIDDLE RD ** RICHMOND TOWN LINE/CURTIS RD- ** NATHAN COOK ** ",
        "CALL:Vehicle",
        "ADDR:5492 MIDDLE RD", // appears to be in Hemlock, Ontario County
        "X:RICHMOND TOWN LINE/CURTIS RD",
        "NAME:NATHAN COOK");

    doTest("T26",
        "(9486 ACE RD) Dispatch ** 11:05 ** Structure ** 9486 ACE RD ** PURCELL RD/DEAD END- ** ONTARIO CO SO ** ",
        "TIME:11:05",
        "CALL:Structure",
        "ADDR:9486 ACE RD",
        "X:PURCELL RD/DEAD END",
        "NAME:ONTARIO CO SO");

    doTest("T27",
        "(5143 BLANK RD) Dispatch **  ** Fire Alarm 1 ** 5143 BLANK RD ** HARDER RD/NIVER RD- ** ADT ** ",
        "CALL:Fire Alarm 1",
        "ADDR:5143 BLANK RD",
        "X:HARDER RD/NIVER RD",
        "NAME:ADT");

    doTest("T28",
        "(ADAMS RD) Dispatch **  ** MVA 3 ** ADAMS RD/LINDSLEY RD ** - ** TONY WASHBURN ** ",
        "CALL:MVA 3",
        "ADDR:ADAMS RD & LINDSLEY RD",
        "NAME:TONY WASHBURN");

    doTest("T29",
        "(6131 BIG TREE RD) Dispatch ** 09:22 ** Structure ** 6131 BIG TREE RD ** BRONSON HILL RD/PENNEMITE RD-C ** ANN HARRIS ** ",
        "TIME:09:22",
        "CALL:Structure",
        "ADDR:6131 BIG TREE RD",
        "X:BRONSON HILL RD/PENNEMITE RD",
        "NAME:ANN HARRIS");

    doTest("T30",
        "(4872 S LIVONIA RD) Dispatch **  ** MVA 8 ** 4872 S LIVONIA RD ** PRICE RD/HAAKS PASS- ** TOM TOFFENY ** ",
        "CALL:MVA 8",
        "ADDR:4872 S LIVONIA RD",
        "X:PRICE RD/HAAKS PASS",
        "NAME:TOM TOFFENY");

    doTest("T31",
        "(STHWY 15A) Dispatch **  ** MVA 3 ** STHWY 15A/PURCELL HILL RD ** - ** BILL MARTIN ** ",
        "CALL:MVA 3",
        "ADDR:STHWY 15A & PURCELL HILL RD", // found in Ontario County
        "NAME:BILL MARTIN");

    doTest("T32",
        "(5927 STHWY 15A) Dispatch **  ** MVA 3 ** 5927 STHWY 15A ** PURCELL HILL RD/LAWRENCE HILL ** ONTARIO CO ** ",
        "CALL:MVA 3",
        "ADDR:5927 STHWY 15A", // found in Ontario County
        "X:PURCELL HILL RD/LAWRENCE HILL",
        "NAME:ONTARIO CO");

    doTest("T33",
        "(6242 SERENITY DR) Dispatch ** 12:11 ** Structure ** 6242 SERENITY DR ** DEAD END/COHWY 37- ** LISA DUZAK ** ",
        "TIME:12:11",
        "CALL:Structure",
        "ADDR:6242 SERENITY DR", // found this in Ontario County but no street names on map
        "X:DEAD END/COHWY 37",
        "NAME:LISA DUZAK");

    doTest("T34",
        "(7440 BIG TREE RD) Dispatch **  ** Cont. Burn ** 7440 BIG TREE RD ** BETTYRUTH LN/CLAY ST- ** RONALD FRALEY ** ",
        "CALL:Cont. Burn",
        "ADDR:7440 BIG TREE RD",
        "X:BETTYRUTH LN/CLAY ST",
        "NAME:RONALD FRALEY");

    doTest("T35",
        "(4213 S LIVONIA RD) Dispatch **  ** Stand By Fire ** 4213 S LIVONIA RD ** S LIVONIA VILLAGE LIMI/MEMORIA **  ** ",
        "CALL:Stand By Fire",
        "ADDR:4213 S LIVONIA RD",
        "X:S LIVONIA VILLAGE LIMI/MEMORIA");

    doTest("T36",
        "(7270 ADAMS RD) Dispatch **  ** Fire Alarm 1 ** 7270 ADAMS RD ** BLANK RD/MAIN ST- ** TWC ** ",
        "CALL:Fire Alarm 1",
        "ADDR:7270 ADAMS RD",
        "X:BLANK RD/MAIN ST",
        "NAME:TWC");

    doTest("T37",
        "(STHWY 15A) Dispatch **  ** Smoke Invest. ** STHWY 15A/PURCELL HILL RD ** - ** ONTARIO CO ** ",
        "CALL:Smoke Invest.",
        "ADDR:STHWY 15A & PURCELL HILL RD",
        "NAME:ONTARIO CO");

    doTest("T38",
        "(3559 PEBBLE BEACH RD) Dispatch ** 11:04 ** Structure ** 3559 PEBBLE BEACH RD ** BIG TREE RD/CLUNY PT- ** SUSAN WHITMAN ** ",
        "TIME:11:04",
        "CALL:Structure",
        "ADDR:3559 PEBBLE BEACH RD",
        "X:BIG TREE RD/CLUNY PT",
        "NAME:SUSAN WHITMAN");

    doTest("T39",
        "(1997 D\"ANGELO DR) Dispatch ** 02:57 ** MVA 8 ** 1997 D\"ANGELO DR ** W LAKE RD/E DEAD END-LIV CO WA ** DARCY BOOTH ** ",
        "TIME:02:57",
        "CALL:MVA 8",
        "ADDR:1997 D\"ANGELO DR",
        "X:W LAKE RD/E DEAD END",
        "NAME:DARCY BOOTH");

    doTest("T40",
        "(4717 E LAKE RD) Dispatch ** 09:46 ** MVA 10 ** 4717 E LAKE RD ** CLEARY RD/PRICE RD- ** JASON BORDEN ** ",
        "TIME:09:46",
        "CALL:MVA 10",
        "ADDR:4717 E LAKE RD",
        "X:CLEARY RD/PRICE RD",
        "NAME:JASON BORDEN");
  
  }
  
  public static void main(String[] args) {
    new NYLivingstonCountyBParserTest().generateTests("T1");
  }
}