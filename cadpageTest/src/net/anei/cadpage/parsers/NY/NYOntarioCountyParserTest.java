package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
 Ontario County, NY
 Contact: ozzy8585@frontiernet.net
 Sender: E911page@co.ontario.ny.us

 AUTO ALRM\n18:23\n5658 EAST LAKE RD\nSUNNY HOLLOW - WILLOW BEACH\nF14\nLOCUS RES - GENERAL FIRE ALARM - ATT REP\nF111890007
 CRASH UNK\n14:32\nCOUNTY ROAD 37 - ROUTE 20A\nASHLEY RD - ROUTE 20A\nE14\nMERCEDES IN THE DITCH ALSO ANOTHER CAR INVOLVED - FEMALE WAS GETTING OUT OF THE MERCE
 CRASH-PI\n13:56\nBIG TREE RD - BARNARD RD\nBARNARD RD - COUNTY LINE\nE14\nMOTORCYCLE CRASH - 1 INJURED\nE111910021
 WIRES DOWN\n15:16\nCOUNTY ROAD 37 - RASPBERRY HILL\nRASPBERRY HILL - HOWCROFT RD\nF14\nWIRE DOWN ABOUT 200 METERS SOUTH OF RASPBERRY HILL ROAD ON CR 37 CAUSING
 CO DET.\n08:20\n4910 COUNTY ROAD 36\nMASTIN DR - SANDY BOTTOM RD\nF14\nWOKE UP TO CO DETECTOR GOING OFF, NO ILLNESS, WILL WAIT OUTSIDE\nF111960002

 Contact: Chris Burt <cvfd022@hotmail.com>
 CO DET.\n15:39\nLAKE BREEZE HOME, 3101 STATE RT 21\nSTATE RT 5 - COUNTY ROAD 32\nF04\nCO DETECTOR IN BASEMENT IS GOING OFF - NO ILLNESS\nF120210009

 Contact: Active911
 Agency name: Cheshire Volunteer Fire Department
 Location: Canandaigua, NY, United States
 Sender: "Dispatch" <E911Page@co.ontario.ny.us>

 AUTO ALRM\r\n12:20\r\n3399 WEST LAKE BLV\r\nCOUNTY ROAD 16 - DEAD END\r\nF04\r\nhaas res general\r\nF122970005\r\n\r\n
 CRASH UNK\r\n23:05\r\nROUTE 5 AND 20 - PARRISH ST EXT\r\nPARRISH ST EXT - ROUTE 21\r\nE02\r\nVEH ON NORTH SIDE OF ROAD UP ON EMBANKMENT - SMOKING - ON RT 5 BETWEEN PARRISH ST EXT AND MAIN ST\r\nE122960023\r\n\r\n
 UNCON/FNT\r\n22:13\r\n5135 LAURA LN\r\nDEAD END - MIDDLE CHESHIRE RD\r\nE02\r\n31-D-3-PASSED OUT 1X-NOW SEMI ALERT\r\nE122950024\r\n\r\n
 PREG/BIRTH\r\n20:43\r\n4275 STATE RT 21\r\nGOODALE RD - BUNNELL RD\r\nE02\r\n24-A-1*POSSIBLE MISCARRAIGE-WALK IN TO CHESHIRE BASE FROM FRIEND ALISHA JOHNSON-LOOKS LIKE SERIOUS BLEEDING AND CRAMPING-HX MISCARRAIGE-KAYLA FANCETT RESD.\r\nE122930028\r\n\r\n
 AUTO ALRM\r\n00:14\r\n3090 OLD BROOKSIDE LN\r\nBUFFALO ST EXT - SUNFLOWER DR\r\nF04\r\nFIRE AND CO ALARM-UNK CAUSE\r\nF122890001\r\n\r\n
 FALLS/INJ\r\n14:04\r\n5935 MONKS RD\r\nSENECA POINT RD - ROUTE 21\r\nE02\r\n17-D-1--FELL FROM 2ND STORY OFF LADDER--56YOM --HEAD INJURY\r\nE122880029\r\n\r\n
 BACK PAIN\r\n09:54\r\n4586 MISTY HILL DR\r\nCOUNTY RD 16 - DEAD END\r\nE02\r\n5-A-1--51YOF SHARP LEFT SIDED LOW BACK PAIN--STARTED WEDNESDAY\r\nE122880016\r\n\r\n
 ASSLT/RAPE\r\n01:25\r\nBRISTOL HARBOUR CLUBHOUSE, 5410 SENECA POINT RD\r\nCOYE RD - ALMOND DR\r\nE18\r\n528 REQUESTING EMS FOR A SUBJECT THAT WAS PUNCHED IN THE HEAD\r\nE122880002\r\n\r\n
 CRASH UNK\r\n11:22\r\nROUTE 5 AND 20 - ROUTE 21\r\nROUTE 21 - BRISTOL RD\r\nE02\r\n\r\nE122870015\r\n\r\n
 AUTO ALRM\r\n07:20\r\nFERRIS HILLS, 4900 PEG RAYBURN DR\r\nCOUNTY RD 16 - FERRIS HILLS\r\nF04\r\nZONE 681 - NO ZONE DESCRIPTION\r\nF122850002\r\n\r\n
 AUTO ALRM\r\n05:30\r\nLAKE BREEZE HOME, 3101 STATE RT 21\r\nSTATE RT 5 - COUNTY ROAD 32\r\nF04\r\ngeneral alarm\r\nF122840004\r\n\r\n
 FALLS/INJ\r\n10:02\r\n4735 SOUTH MENTETH DR\r\nCOUNTY RD 16 - DEAD END\r\nE02\r\n42M C-B-A FELL FROM ROOF , 10-12 FT . LEG FRAC, PHIL WEGMAN RESID 17-B-1\r\nE122830011\r\n\r\n
 BREATHPROB\r\n03:55\r\n4625 KEAR RD\r\nKETCHAM RD - GOFF RD\r\nE02\r\n6-D-4 59F DIFF BREATHING-CLAMMY-ASTHMA HX\r\nE122830003\r\n\r\n
 AUTO ALRM\r\n20:02\r\n3427 COUNTY ROAD 16\r\nWEST LAKE BLVD - LAKEVIEW RD\r\nF04\r\nDEBBIE JOHNSTON RES--KEY PAD\r\nF122820008\r\n\r\n
 CRASH UNK\r\n12:49\r\n4991 STATE RT 21\r\nGOFF RD - COUNTY RD 16\r\nE02\r\n1 CAR IN THE DITCH UNK INJ\r\nE122810015\r\n\r\n
 FALLS/INJ\r\n12:23\r\n3914 ACORN HILL DR\r\nWYFFELS RD - WHITECLIFF DR\r\nE02\r\n17-A-1 -- RICHARDSON RESD -- 91M INJ TO RGT HIP AND LEG -- FELL OFF A STEP\r\nE122810014\r\n\r\n
 CHEST PAIN\r\n03:03\r\n5425 CRAMER RD\r\nMIDDLE CHESHIRE RD - ROCK OAK HILL RD\r\nE02\r\n10-C-2--HEART HX--ONE NITRO W- NO RELIEF\r\nE122810004\r\n\r\n
 CRASH-ROLL\r\n22:55\r\nCANANDAIGUA TOWN HALL, 5440 ROUTE 5 AND 20\r\nWEST AVE EXT - BUFFALO ST EXT\r\nE02\r\nTRUCK ROLLED OVER--4 PEOPLE\r\nE122790033\r\n\r\n
 AUTO ALRM\r\n11:17\r\nZION FELLOWSHIP CHURCH, 5188 BRISTOL RD\r\nCORNELL RD - ROUTE 5 AND 20\r\nF04\r\nGENERAL FIRE\r\nF122790002\r\n\r\n
 CHEST PAIN\r\n20:27\r\n3795 STATE RT 21\r\nHICKOX RD - NOTT RD\r\nE02\r\n10-c-1 sholder pain radiating into her jaw -- 56f dusky complexion -- not breathing normal -- just home from vasular surgery\r\nE122780039\r\n\r\n
 CONV/SEIZ\r\n18:53\r\n5481 ROCHESTER POINT DR\r\nDEAD END - COUNTY RD 16\r\nE02\r\n12-A-3-AURA OF A SEIZURE-SEIZURE HISTORY\r\nE122780036\r\n\r\n
 INJURIES\r\n09:58\r\nBRISTOL HARBOUR CLUBHOUSE, 5410 SENECA POINT RD\r\nCOYE RD - ALMOND DR\r\nE18\r\nCALLER BELIEVES HE HAS A MOWER AND OPERATOR THAT HAS GONE OVER A CLIFF ATA BOVE -- TRYING TO LOCATE THE OPERATOR NOW -- HAVE UNITS RESPOND TO THE CLUBHOUSE AND SOMEONE WILL DIRECT\r\nE122780013\r\n\r\n
 AUTO ALRM\r\n13:05\r\n1 FERRIS HILLS\r\nPEG RAYBURN DR - \r\nF04\r\nZONE 644, UNKNOWN WHERE THAT IS\r\nF122770005\r\n\r\n
 HEMOR/LACE\r\n17:02\r\nMIDDLE CHESHIRE IRA, 4301 MIDDLE CHESHIRE RD\r\nWHITECLIFF DR - CRAMER RD\r\nE02\r\n21-B-1 - IS BEING TAKING DUCALAX FOR COLONOSCOPY TOMORROW AND IS THROWING UP WHAT LOOKS LIKE BLOOD\r\nE122760032\r\n\r\n
 JAIL TRANS\r\n17:45\r\nFARMINGTON COURT, 1000 COUNTY ROAD 8\r\nMARTZ RD - COLLETT RD\r\nS54\r\n\r\nS122750101\r\n\r\n
 OD/INGEST.\r\n23:14\r\n5693 APPLEWOOD DR\r\nDEAD END - SENECA POINT RD\r\nE18\r\n23-C-2 72 YO MALE HAD ALOT OF ALCOHOL HAS BEEN IN AND OUT OF CONSCIOUSNESS\r\nE122730031\r\n\r\n
 UNCON/FNT\r\n21:16\r\n5250 FOSTER RD\r\nCOUNTY ROAD 16 - MIDDLE CHESHIRE RD\r\nE02\r\n31-a-1 38 yo male keeps passing out - is conscious - was in the hottub -\r\nE122730029\r\n\r\n
 AUTO ALRM\r\n11:45\r\nCOUNTY COURTHOUSE, 27 NORTH MAIN ST\r\nONTARIO ST - GORHAM ST\r\nF02\r\nFIRE PANEL\r\nF122730002\r\n\r\n
 FALLS/INJ\r\n11:24\r\nMILLER NURSERIES, 5060 COUNTY ROAD 16\r\nROCHESTER POINT DR - STRAWBERRY LN\r\nE02\r\n17-B-1 -- 56M POSS BROKE LEG - HEARD SNAP AT KNEE\r\nE122730012\r\n\r\n
 UNK/ALARM\r\n15:24\r\nSANDS MARVIN, 4939 COUNTY ROAD 16\r\nDEUEL RD - ROCHESTER POINT DR\r\nE02\r\n32-B-2 -- MEDICAL ALARM\r\nE122720024\r\n\r\n
 AUTO ALRM\r\n06:08\r\nFERRIS HILLS, 4900 PEG RAYBURN DR\r\nCOUNTY RD 16 - FERRIS HILLS\r\nF04\r\nINDEPENDANT S THIRD FLOOR\r\nF122720001\r\n\r\n
 CARDIAC\r\n19:44\r\n3915 ACORN HILL DR\r\nWYFFELS RD - WHITECLIFF DR\r\nE02\r\n9-E-2-WIFEE STATES HUSBAND NOT BREATHING-UNK PROBLEM\r\nE122710025\r\n\r\n
 AUTO ALRM\r\n11:54\r\nFERRIS HILLS, 4900 PEG RAYBURN DR APT 326\r\nCOUNTY RD 16 - FERRIS HILLS\r\nF04\r\nFERRIS HILLS REPORTINT THEIR FIRE PANEL HAS BEEN ACTIVATED FOR APT 326\r\nF122710003\r\n\r\n

 */
public class NYOntarioCountyParserTest extends BaseParserTest {

  public NYOntarioCountyParserTest() {
    setParser(new NYOntarioCountyParser(), "ONTARIO COUNTY", "NY");
  }

  @Test
  public void testParser() {

    doTest(
        "T1",
        "AUTO ALRM\n18:23\n5658 EAST LAKE RD\nSUNNY HOLLOW - WILLOW BEACH\nF14\nLOCUS RES - GENERAL FIRE ALARM - ATT REP\nF111890007",
        "CALL:AUTO ALRM", "ADDR:5658 EAST LAKE RD",
        "TIME:18:23",
        "X:SUNNY HOLLOW & WILLOW BEACH", "UNIT:F14",
        "INFO:LOCUS RES - GENERAL FIRE ALARM - ATT REP", "ID:F111890007");

    doTest(
        "T2",
        "CRASH UNK\n14:32\nCOUNTY ROAD 37 - ROUTE 20A\nASHLEY RD - ROUTE 20A\nE14\nMERCEDES IN THE DITCH ALSO ANOTHER CAR INVOLVED - FEMALE WAS GETTING OUT OF THE MERCE",
        "CALL:CRASH UNK",
        "TIME:14:32",
        "ADDR:COUNTY ROAD 37 & ROUTE 20A",
        "X:ASHLEY RD & ROUTE 20A",
        "UNIT:E14",
        "INFO:MERCEDES IN THE DITCH ALSO ANOTHER CAR INVOLVED - FEMALE WAS GETTING OUT OF THE MERCE");

    doTest(
        "T3",
        "CRASH-PI\n13:56\nBIG TREE RD - BARNARD RD\nBARNARD RD - COUNTY LINE\nE14\nMOTORCYCLE CRASH - 1 INJURED\nE111910021",
        "CALL:CRASH-PI", "ADDR:BIG TREE RD & BARNARD RD",
        "TIME:13:56",
        "X:BARNARD RD & COUNTY LINE", "UNIT:E14",
        "INFO:MOTORCYCLE CRASH - 1 INJURED", "ID:E111910021");

    doTest(
        "T4",
        "WIRES DOWN\n15:16\nCOUNTY ROAD 37 - RASPBERRY HILL\nRASPBERRY HILL - HOWCROFT RD\nF14\nWIRE DOWN ABOUT 200 METERS SOUTH OF RASPBERRY HILL ROAD ON CR 37 CAUSING",
        "CALL:WIRES DOWN", "ADDR:COUNTY ROAD 37 & RASPBERRY HILL",
        "TIME:15:16",
        "X:RASPBERRY HILL & HOWCROFT RD", "UNIT:F14",
        "INFO:WIRE DOWN ABOUT 200 METERS SOUTH OF RASPBERRY HILL ROAD ON CR 37 CAUSING");

    doTest(
        "T5",
        "CO DET.\n08:20\n4910 COUNTY ROAD 36\nMASTIN DR - SANDY BOTTOM RD\nF14\nWOKE UP TO CO DETECTOR GOING OFF, NO ILLNESS, WILL WAIT OUTSIDE\nF111960002",
        "CALL:CO DET.", "ADDR:4910 COUNTY ROAD 36",
        "TIME:08:20",
        "X:MASTIN DR & SANDY BOTTOM RD", "UNIT:F14",
        "INFO:WOKE UP TO CO DETECTOR GOING OFF, NO ILLNESS, WILL WAIT OUTSIDE",
        "ID:F111960002");

    doTest(
        "T6",
        "CO DET.\n15:39\nLAKE BREEZE HOME, 3101 STATE RT 21\nSTATE RT 5 - COUNTY ROAD 32\nF04\nCO DETECTOR IN BASEMENT IS GOING OFF - NO ILLNESS\nF120210009",
        "CALL:CO DET.", "PLACE:LAKE BREEZE HOME", "ADDR:3101 STATE RT 21",
        "TIME:15:39",
        "MADDR:3101 STATE 21", "X:STATE RT 5 & COUNTY ROAD 32", "UNIT:F04",
        "INFO:CO DETECTOR IN BASEMENT IS GOING OFF - NO ILLNESS",
        "ID:F120210009");
  }

  @Test
  public void testChesterFire() {

    doTest("T1",
        "AUTO ALRM\r\n12:20\r\n3399 WEST LAKE BLV\r\nCOUNTY ROAD 16 - DEAD END\r\nF04\r\nhaas res general\r\nF122970005\r\n\r\n",
        "CALL:AUTO ALRM",
        "TIME:12:20",
        "ADDR:3399 WEST LAKE BLV",
        "MADDR:3399 WEST LAKE BLVD",
        "X:COUNTY ROAD 16 & DEAD END",
        "UNIT:F04",
        "INFO:haas res general",
        "ID:F122970005");

    doTest("T2",
        "CRASH UNK\r\n" +
        "23:05\r\n" +
        "ROUTE 5 AND 20 - PARRISH ST EXT\r\n" +
        "PARRISH ST EXT - ROUTE 21\r\n" +
        "E02\r\n" +
        "VEH ON NORTH SIDE OF ROAD UP ON EMBANKMENT - SMOKING - ON RT 5 BETWEEN PARRISH ST EXT AND MAIN ST\r\n" +
        "E122960023\r\n" +
        "\r\n",

        "CALL:CRASH UNK",
        "TIME:23:05",
        "ADDR:ROUTE 5 AND 20 & PARRISH ST EXT",
        "MADDR:ROUTE 5 & PARRISH ST",
        "X:PARRISH ST EXT & ROUTE 21",
        "UNIT:E02",
        "INFO:VEH ON NORTH SIDE OF ROAD UP ON EMBANKMENT - SMOKING - ON RT 5 BETWEEN PARRISH ST EXT AND MAIN ST",
        "ID:E122960023");

    doTest("T3",
        "UNCON/FNT\r\n22:13\r\n5135 LAURA LN\r\nDEAD END - MIDDLE CHESHIRE RD\r\nE02\r\n31-D-3-PASSED OUT 1X-NOW SEMI ALERT\r\nE122950024\r\n\r\n",
        "CALL:UNCON/FNT",
        "TIME:22:13",
        "ADDR:5135 LAURA LN",
        "X:DEAD END & MIDDLE CHESHIRE RD",
        "UNIT:E02",
        "INFO:31-D-3-PASSED OUT 1X-NOW SEMI ALERT",
        "ID:E122950024");

    doTest("T4",
        "PREG/BIRTH\r\n" +
        "20:43\r\n" +
        "4275 STATE RT 21\r\n" +
        "GOODALE RD - BUNNELL RD\r\n" +
        "E02\r\n" +
        "24-A-1*POSSIBLE MISCARRAIGE-WALK IN TO CHESHIRE BASE FROM FRIEND ALISHA JOHNSON-LOOKS LIKE SERIOUS BLEEDING AND CRAMPING-HX MISCARRAIGE-KAYLA FANCETT RESD.\r\n" +
        "E122930028\r\n" +
        "\r\n",

        "CALL:PREG/BIRTH",
        "TIME:20:43",
        "ADDR:4275 STATE RT 21",
        "MADDR:4275 STATE 21",
        "X:GOODALE RD & BUNNELL RD",
        "UNIT:E02",
        "INFO:24-A-1*POSSIBLE MISCARRAIGE-WALK IN TO CHESHIRE BASE FROM FRIEND ALISHA JOHNSON-LOOKS LIKE SERIOUS BLEEDING AND CRAMPING-HX MISCARRAIGE-KAYLA FANCETT RESD.",
        "ID:E122930028");

    doTest("T5",
        "AUTO ALRM\r\n00:14\r\n3090 OLD BROOKSIDE LN\r\nBUFFALO ST EXT - SUNFLOWER DR\r\nF04\r\nFIRE AND CO ALARM-UNK CAUSE\r\nF122890001\r\n\r\n",
        "CALL:AUTO ALRM",
        "TIME:00:14",
        "ADDR:3090 OLD BROOKSIDE LN",
        "X:BUFFALO ST EXT & SUNFLOWER DR",
        "UNIT:F04",
        "INFO:FIRE AND CO ALARM-UNK CAUSE",
        "ID:F122890001");

    doTest("T6",
        "FALLS/INJ\r\n" +
        "14:04\r\n" +
        "5935 MONKS RD\r\n" +
        "SENECA POINT RD - ROUTE 21\r\n" +
        "E02\r\n" +
        "17-D-1--FELL FROM 2ND STORY OFF LADDER--56YOM --HEAD INJURY\r\n" +
        "E122880029\r\n" +
        "\r\n",

        "CALL:FALLS/INJ",
        "TIME:14:04",
        "ADDR:5935 MONKS RD",
        "X:SENECA POINT RD & ROUTE 21",
        "UNIT:E02",
        "INFO:17-D-1--FELL FROM 2ND STORY OFF LADDER--56YOM --HEAD INJURY",
        "ID:E122880029");

    doTest("T7",
        "BACK PAIN\r\n" +
        "09:54\r\n" +
        "4586 MISTY HILL DR\r\n" +
        "COUNTY RD 16 - DEAD END\r\n" +
        "E02\r\n" +
        "5-A-1--51YOF SHARP LEFT SIDED LOW BACK PAIN--STARTED WEDNESDAY\r\n" +
        "E122880016\r\n" +
        "\r\n",

        "CALL:BACK PAIN",
        "TIME:09:54",
        "ADDR:4586 MISTY HILL DR",
        "X:COUNTY RD 16 & DEAD END",
        "UNIT:E02",
        "INFO:5-A-1--51YOF SHARP LEFT SIDED LOW BACK PAIN--STARTED WEDNESDAY",
        "ID:E122880016");

    doTest("T8",
        "ASSLT/RAPE\r\n" +
        "01:25\r\n" +
        "BRISTOL HARBOUR CLUBHOUSE, 5410 SENECA POINT RD\r\n" +
        "COYE RD - ALMOND DR\r\n" +
        "E18\r\n" +
        "528 REQUESTING EMS FOR A SUBJECT THAT WAS PUNCHED IN THE HEAD\r\n" +
        "E122880002\r\n" +
        "\r\n",

        "CALL:ASSLT/RAPE",
        "TIME:01:25",
        "PLACE:BRISTOL HARBOUR CLUBHOUSE",
        "ADDR:5410 SENECA POINT RD",
        "X:COYE RD & ALMOND DR",
        "UNIT:E18",
        "INFO:528 REQUESTING EMS FOR A SUBJECT THAT WAS PUNCHED IN THE HEAD",
        "ID:E122880002");

    doTest("T9",
        "CRASH UNK\r\n11:22\r\nROUTE 5 AND 20 - ROUTE 21\r\nROUTE 21 - BRISTOL RD\r\nE02\r\n\r\nE122870015\r\n\r\n",
        "CALL:CRASH UNK",
        "TIME:11:22",
        "ADDR:ROUTE 5 AND 20 & ROUTE 21",
        "MADDR:ROUTE 21 & BRISTOL RD",
        "X:ROUTE 21 & BRISTOL RD",
        "UNIT:E02",
        "ID:E122870015");

    doTest("T10",
        "AUTO ALRM\r\n" +
        "07:20\r\n" +
        "FERRIS HILLS, 4900 PEG RAYBURN DR\r\n" +
        "COUNTY RD 16 - FERRIS HILLS\r\n" +
        "F04\r\n" +
        "ZONE 681 - NO ZONE DESCRIPTION\r\n" +
        "F122850002\r\n" +
        "\r\n",

        "CALL:AUTO ALRM",
        "TIME:07:20",
        "PLACE:FERRIS HILLS",
        "ADDR:4900 PEG RAYBURN DR",
        "X:COUNTY RD 16 & FERRIS HILLS",
        "UNIT:F04",
        "INFO:ZONE 681 - NO ZONE DESCRIPTION",
        "ID:F122850002");

    doTest("T11",
        "AUTO ALRM\r\n05:30\r\nLAKE BREEZE HOME, 3101 STATE RT 21\r\nSTATE RT 5 - COUNTY ROAD 32\r\nF04\r\ngeneral alarm\r\nF122840004\r\n\r\n",
        "CALL:AUTO ALRM",
        "TIME:05:30",
        "PLACE:LAKE BREEZE HOME",
        "ADDR:3101 STATE RT 21",
        "MADDR:3101 STATE 21",
        "X:STATE RT 5 & COUNTY ROAD 32",
        "UNIT:F04",
        "INFO:general alarm",
        "ID:F122840004");

    doTest("T12",
        "FALLS/INJ\r\n" +
        "10:02\r\n" +
        "4735 SOUTH MENTETH DR\r\n" +
        "COUNTY RD 16 - DEAD END\r\n" +
        "E02\r\n" +
        "42M C-B-A FELL FROM ROOF , 10-12 FT . LEG FRAC, PHIL WEGMAN RESID 17-B-1\r\n" +
        "E122830011\r\n" +
        "\r\n",

        "CALL:FALLS/INJ",
        "TIME:10:02",
        "ADDR:4735 SOUTH MENTETH DR",
        "X:COUNTY RD 16 & DEAD END",
        "UNIT:E02",
        "INFO:42M C-B-A FELL FROM ROOF , 10-12 FT . LEG FRAC, PHIL WEGMAN RESID 17-B-1",
        "ID:E122830011");

    doTest("T13",
        "BREATHPROB\r\n03:55\r\n4625 KEAR RD\r\nKETCHAM RD - GOFF RD\r\nE02\r\n6-D-4 59F DIFF BREATHING-CLAMMY-ASTHMA HX\r\nE122830003\r\n\r\n",
        "CALL:BREATHPROB",
        "TIME:03:55",
        "ADDR:4625 KEAR RD",
        "X:KETCHAM RD & GOFF RD",
        "UNIT:E02",
        "INFO:6-D-4 59F DIFF BREATHING-CLAMMY-ASTHMA HX",
        "ID:E122830003");

    doTest("T14",
        "AUTO ALRM\r\n20:02\r\n3427 COUNTY ROAD 16\r\nWEST LAKE BLVD - LAKEVIEW RD\r\nF04\r\nDEBBIE JOHNSTON RES--KEY PAD\r\nF122820008\r\n\r\n",
        "CALL:AUTO ALRM",
        "TIME:20:02",
        "ADDR:3427 COUNTY ROAD 16",
        "X:WEST LAKE BLVD & LAKEVIEW RD",
        "UNIT:F04",
        "INFO:DEBBIE JOHNSTON RES--KEY PAD",
        "ID:F122820008");

    doTest("T15",
        "CRASH UNK\r\n12:49\r\n4991 STATE RT 21\r\nGOFF RD - COUNTY RD 16\r\nE02\r\n1 CAR IN THE DITCH UNK INJ\r\nE122810015\r\n\r\n",
        "CALL:CRASH UNK",
        "TIME:12:49",
        "ADDR:4991 STATE RT 21",
        "MADDR:4991 STATE 21",
        "X:GOFF RD & COUNTY RD 16",
        "UNIT:E02",
        "INFO:1 CAR IN THE DITCH UNK INJ",
        "ID:E122810015");

    doTest("T16",
        "FALLS/INJ\r\n" +
        "12:23\r\n" +
        "3914 ACORN HILL DR\r\n" +
        "WYFFELS RD - WHITECLIFF DR\r\n" +
        "E02\r\n" +
        "17-A-1 -- RICHARDSON RESD -- 91M INJ TO RGT HIP AND LEG -- FELL OFF A STEP\r\n" +
        "E122810014\r\n" +
        "\r\n",

        "CALL:FALLS/INJ",
        "TIME:12:23",
        "ADDR:3914 ACORN HILL DR",
        "X:WYFFELS RD & WHITECLIFF DR",
        "UNIT:E02",
        "INFO:17-A-1 -- RICHARDSON RESD -- 91M INJ TO RGT HIP AND LEG -- FELL OFF A STEP",
        "ID:E122810014");

    doTest("T17",
        "CHEST PAIN\r\n" +
        "03:03\r\n" +
        "5425 CRAMER RD\r\n" +
        "MIDDLE CHESHIRE RD - ROCK OAK HILL RD\r\n" +
        "E02\r\n" +
        "10-C-2--HEART HX--ONE NITRO W- NO RELIEF\r\n" +
        "E122810004\r\n" +
        "\r\n",

        "CALL:CHEST PAIN",
        "TIME:03:03",
        "ADDR:5425 CRAMER RD",
        "X:MIDDLE CHESHIRE RD & ROCK OAK HILL RD",
        "UNIT:E02",
        "INFO:10-C-2--HEART HX--ONE NITRO W- NO RELIEF",
        "ID:E122810004");

    doTest("T18",
        "CRASH-ROLL\r\n" +
        "22:55\r\n" +
        "CANANDAIGUA TOWN HALL, 5440 ROUTE 5 AND 20\r\n" +
        "WEST AVE EXT - BUFFALO ST EXT\r\n" +
        "E02\r\n" +
        "TRUCK ROLLED OVER--4 PEOPLE\r\n" +
        "E122790033\r\n" +
        "\r\n",

        "CALL:CRASH-ROLL",
        "TIME:22:55",
        "PLACE:CANANDAIGUA TOWN HALL",
        "ADDR:5440 ROUTE 5 AND 20",
        "MADDR:5440 ROUTE 5",
        "X:WEST AVE EXT & BUFFALO ST EXT",
        "UNIT:E02",
        "INFO:TRUCK ROLLED OVER--4 PEOPLE",
        "ID:E122790033");

    doTest("T19",
        "AUTO ALRM\r\n11:17\r\nZION FELLOWSHIP CHURCH, 5188 BRISTOL RD\r\nCORNELL RD - ROUTE 5 AND 20\r\nF04\r\nGENERAL FIRE\r\nF122790002\r\n\r\n",
        "CALL:AUTO ALRM",
        "TIME:11:17",
        "PLACE:ZION FELLOWSHIP CHURCH",
        "ADDR:5188 BRISTOL RD",
        "X:CORNELL RD & ROUTE 5 AND 20",
        "UNIT:F04",
        "INFO:GENERAL FIRE",
        "ID:F122790002");

    doTest("T20",
        "CHEST PAIN\r\n" +
        "20:27\r\n" +
        "3795 STATE RT 21\r\n" +
        "HICKOX RD - NOTT RD\r\n" +
        "E02\r\n" +
        "10-c-1 sholder pain radiating into her jaw -- 56f dusky complexion -- not breathing normal -- just home from vasular surgery\r\n" +
        "E122780039\r\n" +
        "\r\n",

        "CALL:CHEST PAIN",
        "TIME:20:27",
        "ADDR:3795 STATE RT 21",
        "MADDR:3795 STATE 21",
        "X:HICKOX RD & NOTT RD",
        "UNIT:E02",
        "INFO:10-c-1 sholder pain radiating into her jaw -- 56f dusky complexion -- not breathing normal -- just home from vasular surgery",
        "ID:E122780039");

    doTest("T21",
        "CONV/SEIZ\r\n" +
        "18:53\r\n" +
        "5481 ROCHESTER POINT DR\r\n" +
        "DEAD END - COUNTY RD 16\r\n" +
        "E02\r\n" +
        "12-A-3-AURA OF A SEIZURE-SEIZURE HISTORY\r\n" +
        "E122780036\r\n" +
        "\r\n",

        "CALL:CONV/SEIZ",
        "TIME:18:53",
        "ADDR:5481 ROCHESTER POINT DR",
        "X:DEAD END & COUNTY RD 16",
        "UNIT:E02",
        "INFO:12-A-3-AURA OF A SEIZURE-SEIZURE HISTORY",
        "ID:E122780036");

    doTest("T22",
        "INJURIES\r\n" +
        "09:58\r\n" +
        "BRISTOL HARBOUR CLUBHOUSE, 5410 SENECA POINT RD\r\n" +
        "COYE RD - ALMOND DR\r\n" +
        "E18\r\n" +
        "CALLER BELIEVES HE HAS A MOWER AND OPERATOR THAT HAS GONE OVER A CLIFF ATA BOVE -- TRYING TO LOCATE THE OPERATOR NOW -- HAVE UNITS RESPOND TO THE CLUBHOUSE AND SOMEONE WILL DIRECT\r\n" +
        "E122780013\r\n" +
        "\r\n",

        "CALL:INJURIES",
        "TIME:09:58",
        "PLACE:BRISTOL HARBOUR CLUBHOUSE",
        "ADDR:5410 SENECA POINT RD",
        "X:COYE RD & ALMOND DR",
        "UNIT:E18",
        "INFO:CALLER BELIEVES HE HAS A MOWER AND OPERATOR THAT HAS GONE OVER A CLIFF ATA BOVE -- TRYING TO LOCATE THE OPERATOR NOW -- HAVE UNITS RESPOND TO THE CLUBHOUSE AND SOMEONE WILL DIRECT",
        "ID:E122780013");

    doTest("T23",
        "AUTO ALRM\r\n13:05\r\n1 FERRIS HILLS\r\nPEG RAYBURN DR - \r\nF04\r\nZONE 644, UNKNOWN WHERE THAT IS\r\nF122770005\r\n\r\n",
        "CALL:AUTO ALRM",
        "TIME:13:05",
        "ADDR:1 FERRIS HILLS",
        "X:PEG RAYBURN DR",
        "UNIT:F04",
        "INFO:ZONE 644, UNKNOWN WHERE THAT IS",
        "ID:F122770005");

    doTest("T24",
        "HEMOR/LACE\r\n" +
        "17:02\r\n" +
        "MIDDLE CHESHIRE IRA, 4301 MIDDLE CHESHIRE RD\r\n" +
        "WHITECLIFF DR - CRAMER RD\r\n" +
        "E02\r\n" +
        "21-B-1 - IS BEING TAKING DUCALAX FOR COLONOSCOPY TOMORROW AND IS THROWING UP WHAT LOOKS LIKE BLOOD\r\n" +
        "E122760032\r\n" +
        "\r\n",

        "CALL:HEMOR/LACE",
        "TIME:17:02",
        "PLACE:MIDDLE CHESHIRE IRA",
        "ADDR:4301 MIDDLE CHESHIRE RD",
        "X:WHITECLIFF DR & CRAMER RD",
        "UNIT:E02",
        "INFO:21-B-1 - IS BEING TAKING DUCALAX FOR COLONOSCOPY TOMORROW AND IS THROWING UP WHAT LOOKS LIKE BLOOD",
        "ID:E122760032");

    doTest("T25",
        "JAIL TRANS\r\n17:45\r\nFARMINGTON COURT, 1000 COUNTY ROAD 8\r\nMARTZ RD - COLLETT RD\r\nS54\r\n\r\nS122750101\r\n\r\n",
        "CALL:JAIL TRANS",
        "TIME:17:45",
        "PLACE:FARMINGTON COURT",
        "ADDR:1000 COUNTY ROAD 8",
        "X:MARTZ RD & COLLETT RD",
        "UNIT:S54",
        "ID:S122750101");

    doTest("T26",
        "OD/INGEST.\r\n" +
        "23:14\r\n" +
        "5693 APPLEWOOD DR\r\n" +
        "DEAD END - SENECA POINT RD\r\n" +
        "E18\r\n" +
        "23-C-2 72 YO MALE HAD ALOT OF ALCOHOL HAS BEEN IN AND OUT OF CONSCIOUSNESS\r\n" +
        "E122730031\r\n" +
        "\r\n",

        "CALL:OD/INGEST.",
        "TIME:23:14",
        "ADDR:5693 APPLEWOOD DR",
        "X:DEAD END & SENECA POINT RD",
        "UNIT:E18",
        "INFO:23-C-2 72 YO MALE HAD ALOT OF ALCOHOL HAS BEEN IN AND OUT OF CONSCIOUSNESS",
        "ID:E122730031");

    doTest("T27",
        "UNCON/FNT\r\n" +
        "21:16\r\n" +
        "5250 FOSTER RD\r\n" +
        "COUNTY ROAD 16 - MIDDLE CHESHIRE RD\r\n" +
        "E02\r\n" +
        "31-a-1 38 yo male keeps passing out - is conscious - was in the hottub -\r\n" +
        "E122730029\r\n" +
        "\r\n",

        "CALL:UNCON/FNT",
        "TIME:21:16",
        "ADDR:5250 FOSTER RD",
        "X:COUNTY ROAD 16 & MIDDLE CHESHIRE RD",
        "UNIT:E02",
        "INFO:31-a-1 38 yo male keeps passing out - is conscious - was in the hottub -",
        "ID:E122730029");

    doTest("T28",
        "AUTO ALRM\r\n11:45\r\nCOUNTY COURTHOUSE, 27 NORTH MAIN ST\r\nONTARIO ST - GORHAM ST\r\nF02\r\nFIRE PANEL\r\nF122730002\r\n\r\n",
        "CALL:AUTO ALRM",
        "TIME:11:45",
        "PLACE:COUNTY COURTHOUSE",
        "ADDR:27 NORTH MAIN ST",
        "X:ONTARIO ST & GORHAM ST",
        "UNIT:F02",
        "INFO:FIRE PANEL",
        "ID:F122730002");

    doTest("T29",
        "FALLS/INJ\r\n" +
        "11:24\r\n" +
        "MILLER NURSERIES, 5060 COUNTY ROAD 16\r\n" +
        "ROCHESTER POINT DR - STRAWBERRY LN\r\n" +
        "E02\r\n" +
        "17-B-1 -- 56M POSS BROKE LEG - HEARD SNAP AT KNEE\r\n" +
        "E122730012\r\n" +
        "\r\n",

        "CALL:FALLS/INJ",
        "TIME:11:24",
        "PLACE:MILLER NURSERIES",
        "ADDR:5060 COUNTY ROAD 16",
        "X:ROCHESTER POINT DR & STRAWBERRY LN",
        "UNIT:E02",
        "INFO:17-B-1 -- 56M POSS BROKE LEG - HEARD SNAP AT KNEE",
        "ID:E122730012");

    doTest("T30",
        "UNK/ALARM\r\n15:24\r\nSANDS MARVIN, 4939 COUNTY ROAD 16\r\nDEUEL RD - ROCHESTER POINT DR\r\nE02\r\n32-B-2 -- MEDICAL ALARM\r\nE122720024\r\n\r\n",
        "CALL:UNK/ALARM",
        "TIME:15:24",
        "PLACE:SANDS MARVIN",
        "ADDR:4939 COUNTY ROAD 16",
        "X:DEUEL RD & ROCHESTER POINT DR",
        "UNIT:E02",
        "INFO:32-B-2 -- MEDICAL ALARM",
        "ID:E122720024");

    doTest("T31",
        "AUTO ALRM\r\n06:08\r\nFERRIS HILLS, 4900 PEG RAYBURN DR\r\nCOUNTY RD 16 - FERRIS HILLS\r\nF04\r\nINDEPENDANT S THIRD FLOOR\r\nF122720001\r\n\r\n",
        "CALL:AUTO ALRM",
        "TIME:06:08",
        "PLACE:FERRIS HILLS",
        "ADDR:4900 PEG RAYBURN DR",
        "X:COUNTY RD 16 & FERRIS HILLS",
        "UNIT:F04",
        "INFO:INDEPENDANT S THIRD FLOOR",
        "ID:F122720001");

    doTest("T32",
        "CARDIAC\r\n" +
        "19:44\r\n" +
        "3915 ACORN HILL DR\r\n" +
        "WYFFELS RD - WHITECLIFF DR\r\n" +
        "E02\r\n" +
        "9-E-2-WIFEE STATES HUSBAND NOT BREATHING-UNK PROBLEM\r\n" +
        "E122710025\r\n" +
        "\r\n",

        "CALL:CARDIAC",
        "TIME:19:44",
        "ADDR:3915 ACORN HILL DR",
        "X:WYFFELS RD & WHITECLIFF DR",
        "UNIT:E02",
        "INFO:9-E-2-WIFEE STATES HUSBAND NOT BREATHING-UNK PROBLEM",
        "ID:E122710025");

    doTest("T33",
        "AUTO ALRM\r\n" +
        "11:54\r\n" +
        "FERRIS HILLS, 4900 PEG RAYBURN DR APT 326\r\n" +
        "COUNTY RD 16 - FERRIS HILLS\r\n" +
        "F04\r\n" +
        "FERRIS HILLS REPORTINT THEIR FIRE PANEL HAS BEEN ACTIVATED FOR APT 326\r\n" +
        "F122710003\r\n" +
        "\r\n",

        "CALL:AUTO ALRM",
        "TIME:11:54",
        "PLACE:FERRIS HILLS",
        "ADDR:4900 PEG RAYBURN DR",
        "APT:326",
        "X:COUNTY RD 16 & FERRIS HILLS",
        "UNIT:F04",
        "INFO:FERRIS HILLS REPORTINT THEIR FIRE PANEL HAS BEEN ACTIVATED FOR APT 326",
        "ID:F122710003");

  }

  public static void main(String[] args) {
    new NYOntarioCountyParserTest().generateTests("T1");
  }
}