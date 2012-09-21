package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PADelawareCountyCParserTest extends BaseParserTest {
  
  public PADelawareCountyCParserTest() {
    setParser(new PADelawareCountyCParser(), "DELAWARE COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "1 of 2\n" +
        "FRM:norwoodfireco@rcn.com\n" +
        "SUBJ:Messenger 911\n" +
        "MSG:[Update]\n" +
        "F11032765\n" +
        "06/09/2011\n" +
        "04:13\n" +
        "ASSIST\n" +
        "FD TO ASSIST EMS\n" +
        "17 ELMWOOD AV\n" +
        "S\n" +
        "(Con't) 2 of 2\n" +
        "ELMWOOD AV\n" +
        "MCKINLEY AV\n" +
        "021/M100D/M100/027B\n" +
        "~80YOM,Set Station Alarm activ\n" +
        "FD\n" +
        "FIRE\n" +
        "ANI/(End)",

        "ID:F11032765",
        "DATE:06/09/2011",
        "TIME:04:13",
        "CALL:ASSIST - FD TO ASSIST EMS",
        "ADDR:17 ELMWOOD AV",
        "MADDR:17 ELMWOOD AVE",
        "X:S ELMWOOD AV & MCKINLEY AV",
        "INFO:021/M100D/M100/027B / ~80YOM,Set Station Alarm activ / FD / FIRE / ANI/");

    doTest("T2",
        "1 of 2\n" +
        "FRM:norwoodfireco@rcn.com\n" +
        "SUBJ:Messenger 911\n" +
        "MSG:F11031554 \n" +
        "06/03/2011 \n" +
        "08:56 \n" +
        "STREET \n" +
        "STREET CLOSED \n" +
        "W ASHLAND AV & N MACDADE BLVD \n" +
        "W\n" +
        "(Con't) 2 of 2\n" +
        "ASHLAND AV \n" +
        "N MACDADE BLVD \n" +
        "M100D/STA02/STA05/STA09/STA01 \n" +
        "BETWEEN N WELLS AND MACDADE ON(End)",

        "ID:F11031554",
        "DATE:06/03/2011",
        "TIME:08:56",
        "CALL:STREET - STREET CLOSED",
        "ADDR:W ASHLAND AV & N MACDADE BLVD",
        "MADDR:W ASHLAND AVE & N MACDADE BLVD",
        "INFO:M100D/STA02/STA05/STA09/STA01 / BETWEEN N WELLS AND MACDADE ON");

    doTest("T3",
        "1 of 2\n" +
        "FRM:norwoodfireco@rcn.com\n" +
        "SUBJ:Messenger 911\n" +
        "MSG:F11031406 \n" +
        "06/02/2011 \n" +
        "14:44 \n" +
        "ACC \n" +
        "WITH INJURY REPORTED \n" +
        "8TH AV & LINCOLN AV \n" +
        "8TH\n" +
        "(Con't) 2 of 2\n" +
        "AV \n" +
        "LINCOLN AV \n" +
        "487/ENG08/027/M102A/RE08/071 \n" +
        "610-461-1539,SEE THE MAN,STRIK \n" +
        "FD \n" +
        "FIRE \n" +
        "CELL (End)",

        "ID:F11031406",
        "DATE:06/02/2011",
        "TIME:14:44",
        "CALL:ACC - WITH INJURY REPORTED",
        "ADDR:8TH AV & LINCOLN AV",
        "MADDR:8TH AVE & LINCOLN AVE",
        "INFO:487/ENG08/027/M102A/RE08/071 / 610-461-1539,SEE THE MAN,STRIK / FD / FIRE / CELL");

    doTest("T4",
        "1 of 2\n" +
        "FRM:norwoodfireco@rcn.com\n" +
        "SUBJ:Messenger 911\n" +
        "MSG:F11031265 \n" +
        "06/01/2011 \n" +
        "20:40 \n" +
        "FIRE-BLD \n" +
        "BUILDING FIRE, COMMERCIAL BLDG \n" +
        "734 CHESTER\n" +
        "(Con't) 2 of 2\n" +
        "PKE \n" +
        "PENNSYLVANIA AV \n" +
        "NASSAU BLVD \n" +
        "ENG08/021/027/SN08/RE08/076/07 \n" +
        "-075.305228 +039.883204 (End)",

        "ID:F11031265",
        "DATE:06/01/2011",
        "TIME:20:40",
        "CALL:FIRE-BLD - BUILDING FIRE, COMMERCIAL BLDG",
        "ADDR:734 CHESTER PKE",
        "X:PENNSYLVANIA AV & NASSAU BLVD",
        "INFO:ENG08/021/027/SN08/RE08/076/07 / -075.305228 +039.883204");

    doTest("T5",
        "1 of 2\n" +
        "FRM:norwoodfireco@rcn.com\n" +
        "SUBJ:Messenger 911\n" +
        "MSG:F11031005 \n" +
        "05/31/2011 \n" +
        "18:14 \n" +
        "FIRE-OTH \n" +
        "FD INVESTIGATION \n" +
        "241 W WINONA AV \n" +
        "SYLVAN\n" +
        "(Con't) 2 of 2\n" +
        "AV \n" +
        "TRITES AV \n" +
        "021 \n" +
        "-075.303855 +039.894780,~ GRIL \n" +
        "FD \n" +
        "FIRE \n" +
        "ANI/ALI \n" +
        "RACHEL - SAME \n" +
        "FIRE-OT(End)",

        "ID:F11031005",
        "DATE:05/31/2011",
        "TIME:18:14",
        "CALL:FIRE-OTH - FD INVESTIGATION",
        "ADDR:241 W WINONA AV",
        "MADDR:241 W WINONA AVE",
        "X:SYLVAN AV & TRITES AV",
        "INFO:021 / -075.303855 +039.894780,~ GRIL / FD / FIRE / ANI/ALI / RACHEL - SAME / FIRE-OT");

    doTest("T6",
        "1 of 2\n" +
        "FRM:norwoodfireco@rcn.com\n" +
        "SUBJ:Messenger 911\n" +
        "MSG:F11029356 \n" +
        "05/24/2011 \n" +
        "00:41 \n" +
        "ALARM \n" +
        "CARBON MONOXIDE ALARM \n" +
        "711 SOUTH AV \n" +
        "UNNAMED\n" +
        "(Con't) 2 of 2\n" +
        "STREET \n" +
        "QUAINT ST \n" +
        "ARID7/027/RID7B/677C/MRID7/LA4 \n" +
        "ò~3¿ \n" +
        "FD \n" +
        "FIRE \n" +
        "ANI/ALI \n" +
        "WARD MARGARET - (End)",

        "ID:F11029356",
        "DATE:05/24/2011",
        "TIME:00:41",
        "CALL:ALARM - CARBON MONOXIDE ALARM",
        "ADDR:711 SOUTH AV",
        "MADDR:711 SOUTH AVE",
        "X:UNNAMED STREET & QUAINT ST",
        "INFO:ARID7/027/RID7B/677C/MRID7/LA4 / ò~3¿ / FD / FIRE / ANI/ALI / WARD MARGARET -");

    doTest("T7",
        "1 of 2\n" +
        "FRM:norwoodfireco@rcn.com\n" +
        "SUBJ:Messenger 911\n" +
        "MSG:F11027808 \n" +
        "05/16/2011 \n" +
        "10:54 \n" +
        "FIRE-BLD \n" +
        "BUILDING FIRE, COMMERCIAL BLDG \n" +
        "701 ASHLAND AV\n" +
        "(Con't) 2 of 2\n" +
        "22 \n" +
        "DELMAR DR \n" +
        "CARPENTERS CROSSING \n" +
        "M06/012/017/027A/091/ENG05/TW0 \n" +
        "MULTIPLE BUSINESSES (End)",

        "ID:F11027808",
        "DATE:05/16/2011",
        "TIME:10:54",
        "CALL:FIRE-BLD - BUILDING FIRE, COMMERCIAL BLDG",
        "ADDR:701 ASHLAND AV 22",
        "MADDR:701 ASHLAND AVE 22",
        "X:DELMAR DR & CARPENTERS CROSSING",
        "INFO:M06/012/017/027A/091/ENG05/TW0 / MULTIPLE BUSINESSES");
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "F12029686\n" +
        "05/27/2012\n" +
        "18:54\n" +
        "ALARM\n" +
        "WATERFLOW ALARM\n" +
        "1800 MILL RD\n" +
        "BETHEL RD\n" +
        "CENTRAL AV\n" +
        "Calltaker - Verify the building (Main, North, or West) where assistance is,requested.,ESZ 405,~MAIN \n" +
        "PHONE\n" +
        "TRI M #28\n" +
        "ALARM -\n" +
        "800-877-3624",

        "ID:F12029686",
        "DATE:05/27/2012",
        "TIME:18:54",
        "CALL:ALARM - WATERFLOW ALARM",
        "ADDR:1800 MILL RD",
        "X:BETHEL RD & CENTRAL AV",
        "INFO:Calltaker - Verify the building (Main, North, or West) where assistance is,requested.,ESZ 405,~MAIN / PHONE / TRI M #28 / ALARM - / 800-877-3624");

    doTest("T2",
        "F12029450\n" +
        "05/26/2012\n" +
        "13:09\n" +
        "ACC\n" +
        "WITH INJURY/FIRE\n" +
        "CONCHESTER HWY \n" +
        "CONCHESTER HWY\n" +
        "FLORA LN\n" +
        "~ 1 VEH POSS ENGINE COMPARTMENT ON FIRE,~ INJURIES UNK,ù:ªU9(íU\n" +
        "ANI/ALI\n" +
        "BULEY,CHERYL - 901 FLORA LN\n" +
        "ACC - ACCIDENT\n" +
        "610-494-4356",

        "ID:F12029450",
        "DATE:05/26/2012",
        "TIME:13:09",
        "CALL:ACC - WITH INJURY/FIRE",
        "ADDR:CONCHESTER HWY & FLORA LN",
        "INFO:~ 1 VEH POSS ENGINE COMPARTMENT ON FIRE,~ INJURIES UNK / ANI/ALI / BULEY,CHERYL - 901 FLORA LN / ACC - ACCIDENT / 610-494-4356");

    doTest("T3",
        "F12029166\n" +
        "05/25/2012\n" +
        "01:22\n" +
        "FIRE-BLD\n" +
        "BUILDING FIRE, RES/DWELLING\n" +
        "925 CHESTNUT ST\n" +
        "W 9TH ST\n" +
        "W 10TH ST\n" +
        "~LOUD BANG FROM THE BASEMENT / FILLING WITH SMOKE,Ô>UU«¿\n" +
        "CELL PHO\n" +
        "HEWES, SHELBY - SAME\n" +
        "FIRE-BLD - BUILDING RESPONSE\n" +
        "610-800-4894",

        "ID:F12029166",
        "DATE:05/25/2012",
        "TIME:01:22",
        "CALL:FIRE-BLD - BUILDING FIRE, RES/DWELLING",
        "ADDR:925 CHESTNUT ST",
        "X:W 9TH ST & W 10TH ST",
        "INFO:~LOUD BANG FROM THE BASEMENT / FILLING WITH SMOKE / CELL PHO / HEWES, SHELBY - SAME / FIRE-BLD - BUILDING RESPONSE / 610-800-4894");

    doTest("T4",
        "F12029319\n" +
        "05/25/2012\n" +
        "18:28\n" +
        "FIRE-OTH\n" +
        "FD INVESTIGATION\n" +
        "4TH AV & OKIOLA\n" +
        "4TH AV\n" +
        "OKIOLA AV\n" +
        "~SMOKE ODOR IN THE AREA,”]\n" +
        "CELL PHO\n" +
        "ANNA JONES\n" +
        "FIRE-OTH - OTHER RESPONSE\n" +
        "610-494-6028",

        "ID:F12029319",
        "DATE:05/25/2012",
        "TIME:18:28",
        "CALL:FIRE-OTH - FD INVESTIGATION",
        "ADDR:4TH AV & OKIOLA AV",
        "MADDR:4TH AVE & OKIOLA AVE",
        "INFO:~SMOKE ODOR IN THE AREA / CELL PHO / ANNA JONES / FIRE-OTH - OTHER RESPONSE / 610-494-6028");

    doTest("T5",
        "F12029110\n" +
        "05/24/2012\n" +
        "18:44\n" +
        "FIRE-NON\n" +
        "VEHICLE FIRE\n" +
        "CONCHESTER HWY \n" +
        "CONCHESTER HWY\n" +
        "MARKET ST\n" +
        "~ON 322 JUST BEFORE 452,UNK WHAT KIND OF VEHICLE,\n" +
        "CELL PHO\n" +
        "LOFTIS,ERICA\n" +
        "FIRE-NON - NON BLDG RESPONSE\n" +
        "610-812-1574",

        "ID:F12029110",
        "DATE:05/24/2012",
        "TIME:18:44",
        "CALL:FIRE-NON - VEHICLE FIRE",
        "ADDR:CONCHESTER HWY & MARKET ST",
        "INFO:~ON 322 JUST BEFORE 452,UNK WHAT KIND OF VEHICLE, / CELL PHO / LOFTIS,ERICA / FIRE-NON - NON BLDG RESPONSE / 610-812-1574");

    doTest("T6",
        "F12029697\n" +
        "05/27/2012\n" +
        "19:32\n" +
        "FIRE-OTH\n" +
        "COVER ASSIGNMENT\n" +
        "1500 W 3RD ST\n" +
        "TILGHMAN ST\n" +
        "LOCKSLEY ST\n" +
        "610-447-7765,~FIRE CHANNEL 8,Location: 1500 W 3RD ST,2nd 68LA (If fire is in east end) RE39 SQ61,3rd\n" +
        "PHONE\n" +
        "FIRE-OTH - OTHER RESPONSE",

        "ID:F12029697",
        "DATE:05/27/2012",
        "TIME:19:32",
        "CALL:FIRE-OTH - COVER ASSIGNMENT",
        "ADDR:1500 W 3RD ST",
        "X:TILGHMAN ST & LOCKSLEY ST",
        "INFO:610-447-7765,~FIRE CHANNEL 8,Location: 1500 W 3RD ST,2nd 68LA (If fire is in east end) RE39 SQ61,3rd / PHONE / FIRE-OTH - OTHER RESPONSE");

    doTest("T7",
        "F12029084\n" +
        "05/24/2012\n" +
        "17:10\n" +
        "ALARM\n" +
        "AUTOMATIC FIRE ALARM\n" +
        "2403 6TH AV\n" +
        "OKIOLA AV\n" +
        "MEETINGHOUSE RD\n" +
        "~GENERAL,ZERBE RESIDENCE 610-494-5403,KBN,ÁõÏ•+š‚Wÿ\n" +
        "PHONE\n" +
        "PROTECT AMERICA OPER 091\n" +
        "ALARM -\n" +
        "800-443-8865",

        "ID:F12029084",
        "DATE:05/24/2012",
        "TIME:17:10",
        "CALL:ALARM - AUTOMATIC FIRE ALARM",
        "ADDR:2403 6TH AV",
        "MADDR:2403 6TH AVE",
        "X:OKIOLA AV & MEETINGHOUSE RD",
        "INFO:~GENERAL,ZERBE RESIDENCE 610-494-5403,KBN / PHONE / PROTECT AMERICA OPER 091 / ALARM - / 800-443-8865");

  }
  
  public static void main(String[] args) {
    new PADelawareCountyCParserTest().generateTests("T1");
  }
}
