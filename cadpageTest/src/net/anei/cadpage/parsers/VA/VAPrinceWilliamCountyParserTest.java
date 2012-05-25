package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.VA.VAPrinceWilliamCountyParser;

import org.junit.Test;


public class VAPrinceWilliamCountyParserTest extends BaseParserTest {
  
  public VAPrinceWilliamCountyParserTest() {
    setParser(new VAPrinceWilliamCountyParser(), "PRINCE WILLIAM COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "29-Oct-2010/11:07:25/OUTF/15742 DUMFRIES RD / 15726 CARRS BROOKE WY ,PWC /17/E517 STA17 /ON NB  DUMFRIES RD  / BTW CARRS BROOK AND TODDBURY",
        "DATE:10/29/2010",
        "TIME:11:07:25",
        "CODE:OUTF",
        "CALL:Outside Fire",
        "ADDR:15742 DUMFRIES RD",
        "X:15726 CARRS BROOKE WY",
        "BOX:17",
        "UNIT:E517 STA17",
        "INFO:ON NB  DUMFRIES RD / BTW CARRS BROOK AND TODDBURY");

    doTest("T2",
        "29-Oct-2010/10:38:09/FALARM/15750 NORRIS POINT WY ,PWC /23/E510B STA23 TW512 /LANDING AT MARKHAM  /// 703-580-8121 /  GENERAL ALARM [72]",
        "DATE:10/29/2010",
        "TIME:10:38:09",
        "CODE:FALARM",
        "CALL:Fire Alarm",
        "ADDR:15750 NORRIS POINT WY",
        "BOX:23",
        "UNIT:E510B STA23 TW512",
        "INFO:LANDING AT MARKHAM / 703-580-8121 / GENERAL ALARM",
        "ID:72");

    doTest("T3",
        "29-Oct-2010/09:41:32/INVEST/18911 FULLER HEIGHTS RD ,PWC /03F/E503B STA03F /CABLE LYING ON THE ROUND - BOTH ENDS ARE CONNECTED TO POLES - NO",
        "DATE:10/29/2010",
        "TIME:09:41:32",
        "CODE:INVEST",
        "CALL:Investigation",
        "ADDR:18911 FULLER HEIGHTS RD",
        "BOX:03F",
        "UNIT:E503B STA03F",
        "INFO:CABLE LYING ON THE ROUND - BOTH ENDS ARE CONNECTED TO POLES - NO");

    doTest("T4",
        "29-Oct-2010/02:17:37/SICA/17428 KAGERA DR ,PWC /03R/E503B M503 STA03R /DAD HAVING POSS HEART ATTACK/ [60]",
        "DATE:10/29/2010",
        "TIME:02:17:37",
        "CODE:SICA",
        "CALL:Sickness - ALS",
        "ADDR:17428 KAGERA DR",
        "BOX:03R",
        "UNIT:E503B M503 STA03R",
        "INFO:DAD HAVING POSS HEART ATTACK",
        "ID:60");

    doTest("T5",
        "29-Oct-2010/09:21:10/UNC/18303 OLD TRIANGLE RD ,PWC /03R/E503B E523 M503 STA03R female screaming something is wrong w male in t he house .",
        "DATE:10/29/2010",
        "TIME:09:21:10",
        "CODE:UNC",
        "CALL:Unconscious",
        "ADDR:18303 OLD TRIANGLE RD",
        "BOX:03R",
        "UNIT:E503B E523 M503 STA03R female screaming something is wrong w male in t he house .");

    doTest("T6",
        "28-Oct-2010/18:35:32/OUTF/CARBOROUGH ST / 19140 WINDSOR RD ,PWC /03R/E503B STA03R /BRUSH ON FIRE BESIDES THE HIGHWAY [53]",
        "DATE:10/28/2010",
        "TIME:18:35:32",
        "CODE:OUTF",
        "CALL:Outside Fire",
        "ADDR:19140 WINDSOR RD",
        "X:CARBOROUGH ST",
        "BOX:03R",
        "UNIT:E503B STA03R",
        "INFO:BRUSH ON FIRE BESIDES THE HIGHWAY",
        "ID:53");

    doTest("T7",
        "05-Nov-2010/10:08:33/FALARM/19043 FULLER HEIGHTS RD ,PWC (INSPIRATION > HOUSE DAY CARE)/03F/E503B STA03F TW512 /busn / 703 441 0997 / aud / ge",
        "DATE:11/05/2010",
        "TIME:10:08:33",
        "CODE:FALARM",
        "CALL:Fire Alarm",
        "ADDR:19043 FULLER HEIGHTS RD",
        "PLACE:INSPIRATION > HOUSE DAY CARE",
        "BOX:03F",
        "UNIT:E503B STA03F TW512",
        "INFO:busn / 703 441 0997 / aud / ge");

  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/11:29:56/STOP/8961 JASMINE CT ,MNSS /01R/BC582 E501C M501 R501 STA01R /45 YOM\n" +
        " \n" +
        " Sent by PW Alert to M501, R501, E501, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:11:29:56",
        "CODE:STOP",
        "CALL:Stoppage Of Breathing",
        "ADDR:8961 JASMINE CT",
        "CITY:MANASSAS",
        "BOX:01R",
        "UNIT:BC582 E501C M501 R501 STA01R",
        "INFO:45 YOM");

    doTest("T2",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/06:33:24/HAZARD/9230 NIKI PL ,MNSS /01R/E501C STA01R /water leaking from unit 201through bathroom ceiling of unit 101\n" +
        " \n" +
        " Sent by PW Alert to E501, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:06:33:24",
        "CODE:HAZARD",
        "CALL:Hazard",
        "ADDR:9230 NIKI PL",
        "CITY:MANASSAS",
        "BOX:01R",
        "UNIT:E501C STA01R",
        "INFO:water leaking from unit 201through bathroom ceiling of unit 101");

    doTest("T3",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/07:52:18/INJA/9114 EUCLID AV ,MNSS /01F/E501C M501 STA01F /3P // FELL OFF LADDER // NOT SURE HOW FAR\n" +
        " \n" +
        " Sent by PW Alert to M501, E501, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:07:52:18",
        "CODE:INJA",
        "CALL:Injury - ALS",
        "ADDR:9114 EUCLID AV",
        "MADDR:9114 EUCLID AVE",
        "CITY:MANASSAS",
        "BOX:01F",
        "UNIT:E501C M501 STA01F",
        "INFO:3P / FELL OFF LADDER / NOT SURE HOW FAR");

    doTest("T4",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/03:08:08/SWRES/11200 ADEN RD / 12210 NOKESVILLE RD ,PWC /05/A505B BC501X BC504Y E501C E507 M507 M525 STA05 TW525 Z507 Z507B ZS507 /OFC SEES VEH IN ALOT OF WATER POSS 2\n" +
        " \n" +
        " Sent by PW Alert to BC501X, BC504Y, E507, M507, M525, Z507, A505, C507, E501, T525, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:03:08:08",
        "CODE:SWRES",
        "CALL:Swift Water Rescue",
        "ADDR:11200 ADEN RD",
        "X:12210 NOKESVILLE RD",
        "BOX:05",
        "UNIT:A505B BC501X BC504Y E501C E507 M507 M525 STA05 TW525 Z507 Z507B ZS507",
        "INFO:OFC SEES VEH IN ALOT OF WATER POSS 2");

    doTest("T5",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/00:39:23/SWRES/12014 BALLS FORD RD / 12601 PRINCE WILLIAM PY ,PWC /11/A511B BC505 BC507F E501C E511B M511 Z503 Z517 /saab stuck w/caller in veh//\n" +
        " \n" +
        " Sent by PW Alert to BC505, BC507F, M511, Z503, Z517, A511, E501, E511, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:00:39:23",
        "CODE:SWRES",
        "CALL:Swift Water Rescue",
        "ADDR:12014 BALLS FORD RD",
        "X:12601 PRINCE WILLIAM PY",
        "BOX:11",
        "UNIT:A511B BC505 BC507F E501C E511B M511 Z503 Z517",
        "INFO:saab stuck w / caller in veh");

    doTest("T6",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/00:55:51/SWRES/11200 ADEN RD / 12210 NOKESVILLE RD ,PWC /05/A505B BC501X BC504Y E501C E525B M525 R510 TW525 Z507B /3p/703-895-0498-son armando stuck on roof of veh in h\n" +
        " \n" +
        " Sent by PW Alert to BC501X, BC504Y, M525, R510, A505, C507, E501, E525, T525, Z507, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:00:55:51",
        "CODE:SWRES",
        "CALL:Swift Water Rescue",
        "ADDR:11200 ADEN RD",
        "X:12210 NOKESVILLE RD",
        "BOX:05",
        "UNIT:A505B BC501X BC504Y E501C E525B M525 R510 TW525 Z507B",
        "INFO:3p / 703-895-0498-son armando stuck on roof of veh in h");

    doTest("T7",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/01:16:35/SWRES/12601 FOREMOST CT / 12522 ADEN RD ,PWC /05/5D A505B BC501X BC504Y E501C E505 M525 R506 STA05 Z507 /on foremost-veh is now in back yard off the creek whic\n" +
        " \n" +
        " Sent by PW Alert to BC501X, BC504Y, E505, M525, R506, Z507, A505, C507, E501, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:01:16:35",
        "CODE:SWRES",
        "CALL:Swift Water Rescue",
        "ADDR:12601 FOREMOST CT",
        "X:12522 ADEN RD",
        "BOX:05",
        "UNIT:5D A505B BC501X BC504Y E501C E505 M525 R506 STA05 Z507",
        "INFO:on foremost-veh is now in back yard off the creek whic");

    doTest("T8",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/07:11:17/SWRES/GC BRISTOW MANOR @ 11507 VALLEY VIEW DR ,PWC /05/5E BC502 BC504 E501C E505 M525 SF504 SF505 STA05 T501 Z507 /sil bmw stuck in water....someone inside of\n" +
        " \n" +
        " Sent by PW Alert to BC502, BC504, E505, M525, SF504, SF505, T501, Z507, E501, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:07:11:17",
        "CODE:SWRES",
        "CALL:Swift Water Rescue",
        "PLACE:GC BRISTOW MANOR",
        "ADDR:11507 VALLEY VIEW DR",
        "BOX:05",
        "UNIT:5E BC502 BC504 E501C E505 M525 SF504 SF505 STA05 T501 Z507",
        "INFO:sil bmw stuck in water....someone inside of");

    doTest("T9",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/06:29:45/SWRES/12298 LUCASVILLE RD / 12408 BRISTOW RD ,PWC /07/5E BC502 BC504 E505 E506B M525 STA07 T501 Z507B /MAN W/SUBMERGED VEHICLE//SITTING ON ROOF//APPROACHING BR\n" +
        " \n" +
        " Sent by PW Alert to BC502, BC504, E505, M525, T501, E506, Z507, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:06:29:45",
        "CODE:SWRES",
        "CALL:Swift Water Rescue",
        "ADDR:12298 LUCASVILLE RD",
        "X:12408 BRISTOW RD",
        "BOX:07",
        "UNIT:5E BC502 BC504 E505 E506B M525 STA07 T501 Z507B",
        "INFO:MAN W / SUBMERGED VEHICLE / SITTING ON ROOF / APPROACHING BR");

    doTest("T10",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/07:11:17/SWRES/GC BRISTOW MANOR @ 11507 VALLEY VIEW DR ,PWC /05/5E BC502 E501C E505 M525 STA05 T501 Z507 /sil bmw stuck in water....someone inside of veh.....about foot\n" +
        " \n" +
        " Sent by PW Alert to BC502, E505, M525, T501, Z507, E501, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:07:11:17",
        "CODE:SWRES",
        "CALL:Swift Water Rescue",
        "PLACE:GC BRISTOW MANOR",
        "ADDR:11507 VALLEY VIEW DR",
        "BOX:05",
        "UNIT:5E BC502 E501C E505 M525 STA05 T501 Z507",
        "INFO:sil bmw stuck in water....someone inside of veh.....about foot");

    doTest("T11",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/06:29:45/SWRES/12298 LUCASVILLE RD / 12408 BRISTOW RD ,PWC /07/5E AC506 BC504 E505 E506B E507B M525 SF504 T501 Z507B /MAN W/SUBMERGED VEHICLE//SITTING ON ROOF//APPROACH\n" +
        " \n" +
        " Sent by PW Alert to AC506, BC504, E505, M525, SF504, T501, E506, E507, Z507, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:06:29:45",
        "CODE:SWRES",
        "CALL:Swift Water Rescue",
        "ADDR:12298 LUCASVILLE RD",
        "X:12408 BRISTOW RD",
        "BOX:07",
        "UNIT:5E AC506 BC504 E505 E506B E507B M525 SF504 T501 Z507B",
        "INFO:MAN W / SUBMERGED VEHICLE / SITTING ON ROOF / APPROACH");

    doTest("T12",
        "Subject: Important message from PW-ALERT\n" +
        " 21-May-2012/21:11:17/ACCB/8800 LIBERIA AV / 8900 CENTREVILLE RD ,MNSS /01F/A511B E501C /bwt the nissan and subura car dealership-motor vehicle accident // poss 2 vehicles // one ve\n" +
        " \n" +
        " Sent by PW Alert to A511, E501, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/21/2012",
        "TIME:21:11:17",
        "CODE:ACCB",
        "CALL:Auto Accident BLS",
        "ADDR:8800 LIBERIA AV",
        "MADDR:8800 LIBERIA AVE",
        "CITY:MANASSAS",
        "X:8900 CENTREVILLE RD",
        "BOX:01F",
        "UNIT:A511B E501C",
        "INFO:bwt the nissan and subura car dealership-motor vehicle accident / poss 2 vehicles / one ve");

    doTest("T13",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/06:29:45/SWRES/12298 LUCASVILLE RD / 12408 BRISTOW RD ,PWC /07/BC502 BC504 E505 E506B M525 STA07 T501 Z507B Z517 /MAN W/SUBMERGED VEHICLE//SITTING ON ROOF//APPROACHING\n" +
        " \n" +
        " Sent by PW Alert to BC502, BC504, E505, M525, T501, Z517, E506, Z507, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:06:29:45",
        "CODE:SWRES",
        "CALL:Swift Water Rescue",
        "ADDR:12298 LUCASVILLE RD",
        "X:12408 BRISTOW RD",
        "BOX:07",
        "UNIT:BC502 BC504 E505 E506B M525 STA07 T501 Z507B Z517",
        "INFO:MAN W / SUBMERGED VEHICLE / SITTING ON ROOF / APPROACHING");

    doTest("T14",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/07:31:41/SICB/8691 PHOENIX DR ,MNSS (SUPER 8 MOTEL)/01F/E501C M509B STA01F /PHONE EXT 124//STOMACH PAINS//\n" +
        " \n" +
        " Sent by PW Alert to E501, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:07:31:41",
        "CODE:SICB",
        "CALL:Sickness - BLS",
        "ADDR:8691 PHOENIX DR",
        "CITY:MANASSAS",
        "PLACE:SUPER 8 MOTEL",
        "BOX:01F",
        "UNIT:E501C M509B STA01F",
        "INFO:PHONE EXT 124 / STOMACH PAINS");

    doTest("T15",
        "Subject: Important message from PW-ALERT\n" +
        " 21-May-2012/23:16:48/SICA/9706 ASPEN PL ,MNSS /01F/E501C M501D /42 YO MALE // IS CONS // VOMITTING BLOOD//\n" +
        " \n" +
        " Sent by PW Alert to E501, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/21/2012",
        "TIME:23:16:48",
        "CODE:SICA",
        "CALL:Sickness - ALS",
        "ADDR:9706 ASPEN PL",
        "CITY:MANASSAS",
        "BOX:01F",
        "UNIT:E501C M501D",
        "INFO:42 YO MALE / IS CONS / VOMITTING BLOOD");

    doTest("T16",
        "Subject: Important message from PW-ALERT\n" +
        " 21-May-2012/23:19:48/FALARM/8411 VIRGINIA MEADOWS DR ,PWC (WELLINGTON WASTEWATER TRMNT)/25/E501C E507B TW525 /busn; craft food 571-921-1400//duct alrm//will notify//\n" +
        " \n" +
        " Sent by PW Alert to E501, E507, T525, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/21/2012",
        "TIME:23:19:48",
        "CODE:FALARM",
        "CALL:Fire Alarm",
        "ADDR:8411 VIRGINIA MEADOWS DR",
        "PLACE:WELLINGTON WASTEWATER TRMNT",
        "BOX:25",
        "UNIT:E501C E507B TW525",
        "INFO:busn; craft food 571-921-1400 / duct alrm / will notify");

    doTest("T17",
        "Subject: Important message from PW-ALERT\n" +
        " 21-May-2012/23:44:15/HAZARD/9503 PARK ST ,MNSS /01R/E501C /water coming in thru the ceiling//\n" +
        " \n" +
        " Sent by PW Alert to E501, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/21/2012",
        "TIME:23:44:15",
        "CODE:HAZARD",
        "CALL:Hazard",
        "ADDR:9503 PARK ST",
        "CITY:MANASSAS",
        "BOX:01R",
        "UNIT:E501C",
        "INFO:water coming in thru the ceiling");

    doTest("T18",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/07:11:17/SWRES/GC BRISTOW MANOR @ 11507 VALLEY VIEW DR ,PWC /05/5E BC502 E501C E505 M525 STA05 T501 Z507 /sil bmw stuck in water....someone inside of veh.....about foot\n" +
        " \n" +
        " Sent by PW Alert to T501, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:07:11:17",
        "CODE:SWRES",
        "CALL:Swift Water Rescue",
        "PLACE:GC BRISTOW MANOR",
        "ADDR:11507 VALLEY VIEW DR",
        "BOX:05",
        "UNIT:5E BC502 E501C E505 M525 STA05 T501 Z507",
        "INFO:sil bmw stuck in water....someone inside of veh.....about foot");

    doTest("T19",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/08:21:30/FALARM/125 MARKET ST ,MNPK (CITY CENTER RES & COMM)/09/E509 STA09 T501 /COMM  CITY CENTER APTMENT...703-330-0540  AUD PULL STATION WILL ATC\n" +
        " \n" +
        " Sent by PW Alert to T501, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:08:21:30",
        "CODE:FALARM",
        "CALL:Fire Alarm",
        "ADDR:125 MARKET ST",
        "CITY:MANASSAS PARK",
        "PLACE:CITY CENTER RES & COMM",
        "BOX:09",
        "UNIT:E509 STA09 T501",
        "INFO:COMM  CITY CENTER APTMENT...703-330-0540  AUD PULL STATION WILL ATC");

    doTest("T20",
        "Subject: Important message from PW-ALERT\n" +
        " 22-May-2012/06:29:45/SWRES/12298 LUCASVILLE RD / 12408 BRISTOW RD ,PWC /07/5E AC506 BC502 BC504 E505 E506B E507B M525 STA07 T501 Z507B /MAN W/SUBMERGED VEHICLE//SITTING ON ROOF//AP\n" +
        " \n" +
        " Sent by PW Alert to AC506, BC502, BC504, E505, M525, T501, E506, E507, Z507, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/22/2012",
        "TIME:06:29:45",
        "CODE:SWRES",
        "CALL:Swift Water Rescue",
        "ADDR:12298 LUCASVILLE RD",
        "X:12408 BRISTOW RD",
        "BOX:07",
        "UNIT:5E AC506 BC502 BC504 E505 E506B E507B M525 STA07 T501 Z507B",
        "INFO:MAN W / SUBMERGED VEHICLE / SITTING ON ROOF / AP");

    doTest("T21",
        "Subject: Important message from PW-ALERT\n" +
        " 21-May-2012/19:10:42/FALARM/170 MARKET ST ,MNPK (CITY CENTER RES & COMM)/09/E509 T501 /COMM/ 703 330 0540/ AUD-GENERAL PULL STATION / WILL ATC\n" +
        " \n" +
        " Sent by PW Alert to T501, DFR CAD through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:05/21/2012",
        "TIME:19:10:42",
        "CODE:FALARM",
        "CALL:Fire Alarm",
        "ADDR:170 MARKET ST",
        "CITY:MANASSAS PARK",
        "PLACE:CITY CENTER RES & COMM",
        "BOX:09",
        "UNIT:E509 T501",
        "INFO:COMM / 703 330 0540 / AUD-GENERAL PULL STATION / WILL ATC");

  }
  
  public static void main(String[] args) {
    new VAPrinceWilliamCountyParserTest().generateTests("T1");
  }

}
