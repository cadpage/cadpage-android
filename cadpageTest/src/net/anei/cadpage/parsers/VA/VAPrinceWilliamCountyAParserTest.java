package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.VA.VAPrinceWilliamCountyAParser;

import org.junit.Test;

/*
Prince William County, VA
Contact: Rodney Fielding <rfielding@d-trs.com>
Sender: cc_message_notification@usamobility.net

29-Oct-2010/11:07:25/OUTF/15742 DUMFRIES RD / 15726 CARRS BROOKE WY ,PWC /17/E517 STA17 /ON NB  DUMFRIES RD  / BTW CARRS BROOK AND TODDBURY
29-Oct-2010/10:38:09/FALARM/15750 NORRIS POINT WY ,PWC /23/E510B STA23 TW512 /LANDING AT MARKHAM  /// 703-580-8121 /  GENERAL ALARM [72]
29-Oct-2010/09:41:32/INVEST/18911 FULLER HEIGHTS RD ,PWC /03F/E503B STA03F /CABLE LYING ON THE ROUND - BOTH ENDS ARE CONNECTED TO POLES - NO
29-Oct-2010/02:17:37/SICA/17428 KAGERA DR ,PWC /03R/E503B M503 STA03R /DAD HAVING POSS HEART ATTACK/ [60]
29-Oct-2010/09:21:10/UNC/18303 OLD TRIANGLE RD ,PWC /03R/E503B E523 M503 STA03R female screaming something is wrong w male in t he house .
28-Oct-2010/18:35:32/OUTF/CARBOROUGH ST / 19140 WINDSOR RD ,PWC /03R/E503B STA03R /BRUSH ON FIRE BESIDES THE HIGHWAY [53]
05-Nov-2010/10:08:33/FALARM/19043 FULLER HEIGHTS RD ,PWC (INSPIRATION > HOUSE DAY CARE)/03F/E503B STA03F TW512 /busn / 703 441 0997 / aud / ge

Contact:Paul Gupta <paul.n.gupta@gmail.com>
Sender: "PW-RSAN #2POO" <_2POO@rsan.pwcgov.org>
(Important message f...) dis08-Jun-2012/21:28:21/SICA/16820 FLOTILLA WY ,PWC (VICTORIA PARK APT)/23/A523 M523 /FRIEND WHITEHEAD, KATE HAS HIGH SUGAR LEVEL, SHE IS CONX // SHE IS WITH AN AIDE NOW\r\n\r\nSent by PW Alert to A523, M523, DFR CAD through Prince William County RSAN\r\r\n--\r\r\n- update your account at https://rsan1.rsan.pwcgov.org

Contact: Patrick Palacios <palacios.patrick@gmail.com>
Sender:1410000011
1 of 2\nFRM:PWRSAN\nMSG:17-Oct-2012/07:30:19/ACCB/4065 PRINCE WILLIAM PY / 13124 HILLENDALE DR ,PWC /13/A510B E513B M513B STA13 /school bus and a\n(Con't) 2 of 2\nblu suv// female is holding her chest// she looks shaken ua(End)

Contact: Judi Miller <jmiller@srxa.com>
Sender: PWRSAN
FRM:PWRSAN\nMSG:06-Jun-2013/16:19:27/SICA/MS GAIN @ 8001 LIMESTONE DR ,PWC /04/E504 M525 /7th grade female student feinted // is conc nown
1 of 2\nFRM:PWRSAN\nMSG:06-Jun-2013/13:29:05/HAZARD/13655 BRIDLEWOOD DR ,PWC /25/E525B /caller adv one of their trucks had antifreeze spill at abv\n(Con't) 2 of 2\n// adv approx 3 gallons // (End)
1 of 2FRM:PWRSANMSG:06-Jun-2013/12:46:47/FALARM/10885 MORNING GLORY CT ,PWC /11/E525B STA11 T504 /rosemary ridge apt / no number / general(Con't) 2 of 2zone 11 / said address was  7601 - 10880 morning glory  buidi (End)
1 of 2\nFRM:PWRSAN\nMSG:06-Jun-2013/10:04:57/MALA/10809 HENRY ABBOTT RD ,PWC /05/E505 M525 /RES/ HARRIS-/ PREMISE NOT LISTED/ 703 695 0369-CEL FOR\n(Con't) 2 of 2\nJUSTIN HARRIS/ AUD-MEDICAL KEY PAD ACTIVATION/ WILL ATCL(End)

Contact: support@active911.com
Sender: @rsan.pwcgov.org

Subject: Important message from PW-ALERT\n 22-May-2012/11:29:56/STOP/8961 JASMINE CT ,MNSS /01R/BC582 E501C M501 R501 STA01R /45 YOM\n \n Sent by PW Alert to M501, R501, E501, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/06:33:24/HAZARD/9230 NIKI PL ,MNSS /01R/E501C STA01R /water leaking from unit 201through bathroom ceiling of unit 101\n \n Sent by PW Alert to E501, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/07:52:18/INJA/9114 EUCLID AV ,MNSS /01F/E501C M501 STA01F /3P // FELL OFF LADDER // NOT SURE HOW FAR\n \n Sent by PW Alert to M501, E501, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/03:08:08/SWRES/11200 ADEN RD / 12210 NOKESVILLE RD ,PWC /05/A505B BC501X BC504Y E501C E507 M507 M525 STA05 TW525 Z507 Z507B ZS507 /OFC SEES VEH IN ALOT OF WATER POSS 2\n \n Sent by PW Alert to BC501X, BC504Y, E507, M507, M525, Z507, A505, C507, E501, T525, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/00:39:23/SWRES/12014 BALLS FORD RD / 12601 PRINCE WILLIAM PY ,PWC /11/A511B BC505 BC507F E501C E511B M511 Z503 Z517 /saab stuck w/caller in veh//\n \n Sent by PW Alert to BC505, BC507F, M511, Z503, Z517, A511, E501, E511, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/00:55:51/SWRES/11200 ADEN RD / 12210 NOKESVILLE RD ,PWC /05/A505B BC501X BC504Y E501C E525B M525 R510 TW525 Z507B /3p/703-895-0498-son armando stuck on roof of veh in h\n \n Sent by PW Alert to BC501X, BC504Y, M525, R510, A505, C507, E501, E525, T525, Z507, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/01:16:35/SWRES/12601 FOREMOST CT / 12522 ADEN RD ,PWC /05/5D A505B BC501X BC504Y E501C E505 M525 R506 STA05 Z507 /on foremost-veh is now in back yard off the creek whic\n \n Sent by PW Alert to BC501X, BC504Y, E505, M525, R506, Z507, A505, C507, E501, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/07:11:17/SWRES/GC BRISTOW MANOR @ 11507 VALLEY VIEW DR ,PWC /05/5E BC502 BC504 E501C E505 M525 SF504 SF505 STA05 T501 Z507 /sil bmw stuck in water....someone inside of\n \n Sent by PW Alert to BC502, BC504, E505, M525, SF504, SF505, T501, Z507, E501, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/06:29:45/SWRES/12298 LUCASVILLE RD / 12408 BRISTOW RD ,PWC /07/5E BC502 BC504 E505 E506B M525 STA07 T501 Z507B /MAN W/SUBMERGED VEHICLE//SITTING ON ROOF//APPROACHING BR\n \n Sent by PW Alert to BC502, BC504, E505, M525, T501, E506, Z507, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/07:11:17/SWRES/GC BRISTOW MANOR @ 11507 VALLEY VIEW DR ,PWC /05/5E BC502 E501C E505 M525 STA05 T501 Z507 /sil bmw stuck in water....someone inside of veh.....about foot\n \n Sent by PW Alert to BC502, E505, M525, T501, Z507, E501, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/06:29:45/SWRES/12298 LUCASVILLE RD / 12408 BRISTOW RD ,PWC /07/5E AC506 BC504 E505 E506B E507B M525 SF504 T501 Z507B /MAN W/SUBMERGED VEHICLE//SITTING ON ROOF//APPROACH\n \n Sent by PW Alert to AC506, BC504, E505, M525, SF504, T501, E506, E507, Z507, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 21-May-2012/21:11:17/ACCB/8800 LIBERIA AV / 8900 CENTREVILLE RD ,MNSS /01F/A511B E501C /bwt the nissan and subura car dealership-motor vehicle accident // poss 2 vehicles // one ve\n \n Sent by PW Alert to A511, E501, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/06:29:45/SWRES/12298 LUCASVILLE RD / 12408 BRISTOW RD ,PWC /07/BC502 BC504 E505 E506B M525 STA07 T501 Z507B Z517 /MAN W/SUBMERGED VEHICLE//SITTING ON ROOF//APPROACHING\n \n Sent by PW Alert to BC502, BC504, E505, M525, T501, Z517, E506, Z507, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/07:31:41/SICB/8691 PHOENIX DR ,MNSS (SUPER 8 MOTEL)/01F/E501C M509B STA01F /PHONE EXT 124//STOMACH PAINS//\n \n Sent by PW Alert to E501, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 21-May-2012/23:16:48/SICA/9706 ASPEN PL ,MNSS /01F/E501C M501D /42 YO MALE // IS CONS // VOMITTING BLOOD//\n \n Sent by PW Alert to E501, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 21-May-2012/23:19:48/FALARM/8411 VIRGINIA MEADOWS DR ,PWC (WELLINGTON WASTEWATER TRMNT)/25/E501C E507B TW525 /busn; craft food 571-921-1400//duct alrm//will notify//\n \n Sent by PW Alert to E501, E507, T525, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 21-May-2012/23:44:15/HAZARD/9503 PARK ST ,MNSS /01R/E501C /water coming in thru the ceiling//\n \n Sent by PW Alert to E501, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/07:11:17/SWRES/GC BRISTOW MANOR @ 11507 VALLEY VIEW DR ,PWC /05/5E BC502 E501C E505 M525 STA05 T501 Z507 /sil bmw stuck in water....someone inside of veh.....about foot\n \n Sent by PW Alert to T501, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/08:21:30/FALARM/125 MARKET ST ,MNPK (CITY CENTER RES & COMM)/09/E509 STA09 T501 /COMM  CITY CENTER APTMENT...703-330-0540  AUD PULL STATION WILL ATC\n \n Sent by PW Alert to T501, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 22-May-2012/06:29:45/SWRES/12298 LUCASVILLE RD / 12408 BRISTOW RD ,PWC /07/5E AC506 BC502 BC504 E505 E506B E507B M525 STA07 T501 Z507B /MAN W/SUBMERGED VEHICLE//SITTING ON ROOF//AP\n \n Sent by PW Alert to AC506, BC502, BC504, E505, M525, T501, E506, E507, Z507, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
Subject: Important message from PW-ALERT\n 21-May-2012/19:10:42/FALARM/170 MARKET ST ,MNPK (CITY CENTER RES & COMM)/09/E509 T501 /COMM/ 703 330 0540/ AUD-GENERAL PULL STATION / WILL ATC\n \n Sent by PW Alert to T501, DFR CAD through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org 
[Important message from PW-ALERT] 29-Jun-2012/16:42:20/COMM/7 COUNTY COMPLEX CT #ENTIRE ,PWC (PWC STADIUM COMPLEX)/MC/5D A510B BC503 BC504 E513 E514 E516 E518 E520 M513 M520 SF502 STA13 T501 TW512 TW513 /gas leak i\nSent by PW Alert to BC503, BC504, E513, E514, E516, E518, E520, M513, SF502, T501, A510, T512, T513, DFR CAD through Prince William County RSAN\n--\n- update your account at https://rsan1.rsan.pwcgov.org\n
[Important message from PW-ALERT] 29-Jun-2012/16:42:20/COMM/7 COUNTY COMPLEX CT #ENTIRE ,PWC (PWC STADIUM COMPLEX)/MC/5D A510B BC502 BC503 E513 E514 E516 E518 E520 M513 M520 R502 SF502 STA13 T501 TW512 TW513 /gas l\nSent by PW Alert to BC502, BC503, E513, E514, E516, E518, E520, M513, R502, SF502, T501, A510, T512, T513, DFR CAD through Prince William County RSAN\n--\n- update your account at https://rsan1.rsan.pwcgov.org\n
[Important message from PW-ALERT] 29-Jun-2012/16:42:20/COMM/7 COUNTY COMPLEX CT #ENTIRE ,PWC (PWC STADIUM COMPLEX)/MC/5D 5E A510B BC406 BC502 BC503 E513 E514 E516 E518 E520 FM516 FM523 M513 M520 R419 R502 RH520 SF5\nSent by PW Alert to BC502, BC503, E513, E514, E516, E518, E520, FM523, M513, R502, SF502, A510, T501, T512, T513, DFR CAD through Prince William County RSAN\n--\n- update your account at https://rsan1.rsan.pwcgov.org\n

Contact: Active911
Agency name: Manassas Vol Fire Co
Location: Manassas, VA, United States
Sender: "PW-RSAN #55RC" <PWRSAN_55RC@rsan.pwcgov.org>

(Important message from PW-ALERT) 05-Jul-2013/09:36:30/SICA/10534 CEDAR CREEK DR ,PWC /07/E507 M501 /delay due to get phn #// 477-4007 // elderly male // diff breathing //\n\nSent by PW Alert to E507, M501, DFR CAD through Prince William County RSAN\r\n--\r\n- update your account at https://rsan1.rsan.pwcgov.org
(Weekly Safety Message/Weather) Traffic violations imposed while off-duty usually means, “Points to the bad”.  Be mindful of your conduct when driving off duty and remember that it can ultimately have a negative impact on your driving privileges when on-duty.  Most Fire and Rescue organizations have developed policies that address this type of misconduct and/or offense; be aware of those policies and where to locate them.  Do not let a bad driving record jeopardize your desire in wanting to participate in a noble service.     \n  \nWeather 7-5-2013  \n  \nToday Mostly sunny, with a high near 91. South wind 7 to 11 mph. Tonight Partly cloudy, with a low around 73. Southwest wind 5 to 8 mph\n\nSent by PW Alert to FSTAFFING/SAFETY through Prince William County RSAN\r\n--\r\n- update your account at https://rsan1.rsan.pwcgov.org
(Staffing) BC582 Franzello\n\nSent by PW Alert to FSTAFFING/SAFETY through Prince William County RSAN\r\n--\r\n- update your account at https://rsan1.rsan.pwcgov.org
(Staffing) Date:  \nA: 2,7,10,11  \nM: 1,3,4,7,9,11,12,14,17,18,20,23,24,25,31,33  \nE: 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,20,23,24,25,31,32,33  \nK: 5,6,15,16  \nR: 1,4,10  \nT: 11,33  \nTW: 1,12,13  \n  \nBC 501: Forgo  \nBC 502: Crawford  \nBC 503: McCoy  \nBC 504: Shiflett  \nBC 531: Barr  \nBC 581: Holman  \nBC 582: Lupton  \n  \nDuty HM: Kieb  \n  \nFM: Culbertson  \n  \nSF: Pagano  \n  \nUFRO: Hebert\n\nSent by PW Alert to FSTAFFING/SAFETY through Prince William County RSAN\r\n--\r\n- update your account at https://rsan1.rsan.pwcgov.org
(Important message from PW-ALERT) 05-Jul-2013/05:28:35/SICB/8538 STONEWALL RD ,MNSS /01F/E501 M501 /CALLER IS HAVING HOT AND COLD FLASHED/HIGH FEVER/BLEEDING BLOOD CLOTS FROM VAGINA/SAYS THE BLOOD IS BROWN\n\nSent by PW Alert to E501, M501, DFR CAD through Prince William County RSAN\r\n--\r\n- update your account at https://rsan1.rsan.pwcgov.org
(Important message from PW-ALERT) 05-Jul-2013/00:41:56/UNC/SEVEN 11 BALLS FORD @ 11171 BALLS FORD RD ,PWC /11/A525B E511 M501C M511 /2 PEOPLE APPEARED TO BE PASSED OUT IN A RED MUSTANG HALF WAY PARKED IN THE PARKIN\n\nSent by PW Alert to E511, M511, A525, M501, DFR CAD through Prince William County RSAN\r\n--\r\n- update your account at https://rsan1.rsan.pwcgov.org
(Important message from PW-ALERT) 05-Jul-2013/00:11:50/SICA/12091 LUCASVILLE RD ,PWC /07/E507 M501 /ADULT FEMALE DIFF BREATHING\n\nSent by PW Alert to E507, M501, DFR CAD through Prince William County RSAN\r\n--\r\n- update your account at https://rsan1.rsan.pwcgov.org
(Important message from PW-ALERT) 04-Jul-2013/23:34:01/SICB/8777 DEBLANC PL ,MNSS /01F/E501 M509B /6 yo daughter screaming and shaking that her stomach hurts, won't move - going on for 1-0 min\n\nSent by PW Alert to E501, DFR CAD through Prince William County RSAN\r\n--\r\n- update your account at https://rsan1.rsan.pwcgov.org
(Important message from PW-ALERT) 04-Jul-2013/23:10:41/INJB/CITY TAVERN GRILLE @ 9405 MAIN ST ,MNSS /01F/E501 M509B /1360a is calling for a guy named Brian who hurt ankle, mid 30's and wants amb // nfi\n\nSent by PW Alert to E501, DFR CAD through Prince William County RSAN\r\n--\r\n- update your account at https://rsan1.rsan.pwcgov.org

*/

public class VAPrinceWilliamCountyAParserTest extends BaseParserTest {
  
  public VAPrinceWilliamCountyAParserTest() {
    setParser(new VAPrinceWilliamCountyAParser(), "PRINCE WILLIAM COUNTY", "VA");
  }
  
  @Test
  public void testBad() {
    doBadTest("You want me to find coverage for Sunday morning?");
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
        "CALL:Fire Alarm Sounding",
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
        "CALL:ALS - Sickness",
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
        "CALL:Fire Alarm Sounding",
        "ADDR:19043 FULLER HEIGHTS RD",
        "PLACE:INSPIRATION > HOUSE DAY CARE",
        "BOX:03F",
        "UNIT:E503B STA03F TW512",
        "INFO:busn / 703 441 0997 / aud / ge");

  }
  
  @Test
  public void testPaulGupta() {

    doTest("T1",
        "(Important message f...) dis08-Jun-2012/21:28:21/SICA/16820 FLOTILLA WY ,PWC (VICTORIA PARK APT)/23/A523 M523 /FRIEND WHITEHEAD, KATE HAS HIGH SUGAR LEVEL, SHE IS CONX // SHE IS WITH AN AIDE NOW\r\n" +
        "\r\n" +
        "Sent by PW Alert to A523, M523, DFR CAD through Prince William County RSAN\r\r\n" +
        "--\r\r\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "TIME:21:28:21",
        "CODE:SICA",
        "CALL:ALS - Sickness",
        "ADDR:16820 FLOTILLA WY",
        "PLACE:VICTORIA PARK APT",
        "BOX:23",
        "UNIT:A523 M523",
        "INFO:FRIEND WHITEHEAD, KATE HAS HIGH SUGAR LEVEL, SHE IS CONX / SHE IS WITH AN AIDE NOW");
   
  }
  
  @Test
  public void testPatrickPalacios() {

    doTest("T1",
        "1 of 2\n" +
        "FRM:PWRSAN\n" +
        "MSG:17-Oct-2012/07:30:19/ACCB/4065 PRINCE WILLIAM PY / 13124 HILLENDALE DR ,PWC /13/A510B E513B M513B STA13 /school bus and a\n" +
        "(Con't) 2 of 2\n" +
        "blu suv// female is holding her chest// she looks shaken ua(End)",

        "DATE:10/17/2012",
        "TIME:07:30:19",
        "CODE:ACCB",
        "CALL:Motor Vehicle Accident/BLS",
        "ADDR:4065 PRINCE WILLIAM PY",
        "MADDR:4065 PRINCE WILLIAM PKWY",
        "X:13124 HILLENDALE DR",
        "BOX:13",
        "UNIT:A510B E513B M513B STA13",
        "INFO:school bus and a blu suv / female is holding her chest / she looks shaken ua");

  }
  
  @Test
  public void testJudiMiller() {

    doTest("T1",
        "FRM:PWRSAN\n" +
        "MSG:06-Jun-2013/16:19:27/SICA/MS GAIN @ 8001 LIMESTONE DR ,PWC /04/E504 M525 /7th grade female student feinted // is conc nown",

        "DATE:06/06/2013",
        "TIME:16:19:27",
        "CODE:SICA",
        "CALL:ALS - Sickness",
        "ADDR:8001 LIMESTONE DR",
        "PLACE:MS GAIN",
        "BOX:04",
        "UNIT:E504 M525",
        "INFO:7th grade female student feinted / is conc nown");

    doTest("T2",
        "1 of 2\n" +
        "FRM:PWRSAN\n" +
        "MSG:06-Jun-2013/13:29:05/HAZARD/13655 BRIDLEWOOD DR ,PWC /25/E525B /caller adv one of their trucks had antifreeze spill at abv\n" +
        "(Con't) 2 of 2\n" +
        "// adv approx 3 gallons // (End)",

        "DATE:06/06/2013",
        "TIME:13:29:05",
        "CODE:HAZARD",
        "CALL:Hazardous Situation",
        "ADDR:13655 BRIDLEWOOD DR",
        "BOX:25",
        "UNIT:E525B",
        "INFO:caller adv one of their trucks had antifreeze spill at abv / adv approx 3 gallons");

    doTest("T3",
        "1 of 2FRM:PWRSANMSG:06-Jun-2013/12:46:47/FALARM/10885 MORNING GLORY CT ,PWC /11/E525B STA11 T504 /rosemary ridge apt / no number / general(Con't) 2 of 2zone 11 / said address was  7601 - 10880 morning glory  buidi (End)",
        "TIME:12:46:47",
        "CODE:FALARM",
        "CALL:Fire Alarm Sounding",
        "ADDR:10885 MORNING GLORY CT",
        "BOX:11",
        "UNIT:E525B STA11 T504",
        "INFO:rosemary ridge apt / no number / general(Con't) 2 of 2zone 11 / said address was  7601 - 10880 morning glory  buidi (End)");

    doTest("T4",
        "1 of 2\n" +
        "FRM:PWRSAN\n" +
        "MSG:06-Jun-2013/10:04:57/MALA/10809 HENRY ABBOTT RD ,PWC /05/E505 M525 /RES/ HARRIS-/ PREMISE NOT LISTED/ 703 695 0369-CEL FOR\n" +
        "(Con't) 2 of 2\n" +
        "JUSTIN HARRIS/ AUD-MEDICAL KEY PAD ACTIVATION/ WILL ATCL(End)",

        "DATE:06/06/2013",
        "TIME:10:04:57",
        "CODE:MALA",
        "CALL:Medical Alarm Sounding",
        "ADDR:10809 HENRY ABBOTT RD",
        "BOX:05",
        "UNIT:E505 M525",
        "INFO:RES / HARRIS- / PREMISE NOT LISTED / 703 695 0369-CEL FOR JUSTIN HARRIS / AUD-MEDICAL KEY PAD ACTIVATION / WILL ATCL");

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
        "CALL:Hazardous Situation",
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
        "CALL:ALS - Injury",
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
        "CALL:Motor Vehicle Accident/BLS",
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
        "CALL:BLS - Sickness",
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
        "CALL:ALS - Sickness",
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
        "CALL:Fire Alarm Sounding",
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
        "CALL:Hazardous Situation",
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
        "CALL:Fire Alarm Sounding",
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
        "CALL:Fire Alarm Sounding",
        "ADDR:170 MARKET ST",
        "CITY:MANASSAS PARK",
        "PLACE:CITY CENTER RES & COMM",
        "BOX:09",
        "UNIT:E509 T501",
        "INFO:COMM / 703 330 0540 / AUD-GENERAL PULL STATION / WILL ATC");

    doTest("T22",
        "[Important message from PW-ALERT] 29-Jun-2012/16:42:20/COMM/7 COUNTY COMPLEX CT #ENTIRE ,PWC (PWC STADIUM COMPLEX)/MC/5D A510B BC503 BC504 E513 E514 E516 E518 E520 M513 M520 SF502 STA13 T501 TW512 TW513 /gas leak i\n" +
        "Sent by PW Alert to BC503, BC504, E513, E514, E516, E518, E520, M513, SF502, T501, A510, T512, T513, DFR CAD through Prince William County RSAN\n" +
        "--\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org\n",

        "DATE:06/29/2012",
        "TIME:16:42:20",
        "CODE:COMM",
        "CALL:Commercial Fire",
        "ADDR:7 COUNTY COMPLEX CT",
        "APT:ENTIRE",
        "PLACE:PWC STADIUM COMPLEX",
        "BOX:MC",
        "UNIT:5D A510B BC503 BC504 E513 E514 E516 E518 E520 M513 M520 SF502 STA13 T501 TW512 TW513",
        "INFO:gas leak i");

    doTest("T23",
        "[Important message from PW-ALERT] 29-Jun-2012/16:42:20/COMM/7 COUNTY COMPLEX CT #ENTIRE ,PWC (PWC STADIUM COMPLEX)/MC/5D A510B BC502 BC503 E513 E514 E516 E518 E520 M513 M520 R502 SF502 STA13 T501 TW512 TW513 /gas l\n" +
        "Sent by PW Alert to BC502, BC503, E513, E514, E516, E518, E520, M513, R502, SF502, T501, A510, T512, T513, DFR CAD through Prince William County RSAN\n" +
        "--\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org\n",

        "DATE:06/29/2012",
        "TIME:16:42:20",
        "CODE:COMM",
        "CALL:Commercial Fire",
        "ADDR:7 COUNTY COMPLEX CT",
        "APT:ENTIRE",
        "PLACE:PWC STADIUM COMPLEX",
        "BOX:MC",
        "UNIT:5D A510B BC502 BC503 E513 E514 E516 E518 E520 M513 M520 R502 SF502 STA13 T501 TW512 TW513",
        "INFO:gas l");

    doTest("T24",
        "[Important message from PW-ALERT] 29-Jun-2012/16:42:20/COMM/7 COUNTY COMPLEX CT #ENTIRE ,PWC (PWC STADIUM COMPLEX)/MC/5D 5E A510B BC406 BC502 BC503 E513 E514 E516 E518 E520 FM516 FM523 M513 M520 R419 R502 RH520 SF5\n" +
        "Sent by PW Alert to BC502, BC503, E513, E514, E516, E518, E520, FM523, M513, R502, SF502, A510, T501, T512, T513, DFR CAD through Prince William County RSAN\n" +
        "--\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org\n",

        "DATE:06/29/2012",
        "TIME:16:42:20",
        "CODE:COMM",
        "CALL:Commercial Fire",
        "ADDR:7 COUNTY COMPLEX CT",
        "APT:ENTIRE",
        "PLACE:PWC STADIUM COMPLEX",
        "BOX:MC",
        "UNIT:5D 5E A510B BC406 BC502 BC503 E513 E514 E516 E518 E520 FM516 FM523 M513 M520 R419 R502 RH520 SF5");

  }
  
  @Test
  public void testManassasVolFireCo() {

    doTest("T1",
        "(Important message from PW-ALERT) 05-Jul-2013/09:36:30/SICA/10534 CEDAR CREEK DR ,PWC /07/E507 M501 /delay due to get phn #// 477-4007 // elderly male // diff breathing //\n\n" +
        "Sent by PW Alert to E507, M501, DFR CAD through Prince William County RSAN\r\n" +
        "--\r\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:07/05/2013",
        "TIME:09:36:30",
        "CODE:SICA",
        "CALL:ALS - Sickness",
        "ADDR:10534 CEDAR CREEK DR",
        "BOX:07",
        "UNIT:E507 M501",
        "INFO:delay due to get phn # / 477-4007 / elderly male / diff breathing");

    doTest("T2",
        "(Weekly Safety Message/Weather) Traffic violations imposed while off-duty usually means, “Points to the bad”.  Be mindful of your conduct when driving off duty and remember that it can ultimately have a negative impact on your driving privileges when on-duty.  Most Fire and Rescue organizations have developed policies that address this type of misconduct and/or offense; be aware of those policies and where to locate them.  Do not let a bad driving record jeopardize your desire in wanting to participate in a noble service.     \n" +
        "  \n" +
        "Weather 7-5-2013  \n" +
        "  \n" +
        "Today Mostly sunny, with a high near 91. South wind 7 to 11 mph. Tonight Partly cloudy, with a low around 73. Southwest wind 5 to 8 mph\n\n" +
        "Sent by PW Alert to FSTAFFING/SAFETY through Prince William County RSAN\r\n" +
        "--\r\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:GENERAL ALERT",
        "PLACE:(Weekly Safety Message/Weather) Traffic violations imposed while off-duty usually means, “Points to the bad”.  Be mindful of your conduct when driving off duty and remember that it can ultimately have a negative impact on your driving privileges when on-duty.  Most Fire and Rescue organizations have developed policies that address this type of misconduct and/or offense; be aware of those policies and where to locate them.  Do not let a bad driving record jeopardize your desire in wanting to participate in a noble service.     \n  \nWeather 7-5-2013  \n  \nToday Mostly sunny, with a high near 91. South wind 7 to 11 mph. Tonight Partly cloudy, with a low around 73. Southwest wind 5 to 8 mph");

    doTest("T3",
        "(Staffing) BC582 Franzello\n\n" +
        "Sent by PW Alert to FSTAFFING/SAFETY through Prince William County RSAN\r\n" +
        "--\r\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:GENERAL ALERT",
        "PLACE:(Staffing) BC582 Franzello");

    doTest("T4",
        "(Staffing) Date:  \n" +
        "A: 2,7,10,11  \n" +
        "M: 1,3,4,7,9,11,12,14,17,18,20,23,24,25,31,33  \n" +
        "E: 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,20,23,24,25,31,32,33  \n" +
        "K: 5,6,15,16  \n" +
        "R: 1,4,10  \n" +
        "T: 11,33  \n" +
        "TW: 1,12,13  \n" +
        "  \n" +
        "BC 501: Forgo  \n" +
        "BC 502: Crawford  \n" +
        "BC 503: McCoy  \n" +
        "BC 504: Shiflett  \n" +
        "BC 531: Barr  \n" +
        "BC 581: Holman  \n" +
        "BC 582: Lupton  \n" +
        "  \n" +
        "Duty HM: Kieb  \n" +
        "  \n" +
        "FM: Culbertson  \n" +
        "  \n" +
        "SF: Pagano  \n" +
        "  \n" +
        "UFRO: Hebert\n\n" +
        "Sent by PW Alert to FSTAFFING/SAFETY through Prince William County RSAN\r\n" +
        "--\r\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:GENERAL ALERT",
        "PLACE:(Staffing) Date:  \nA: 2,7,10,11  \nM: 1,3,4,7,9,11,12,14,17,18,20,23,24,25,31,33  \nE: 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,20,23,24,25,31,32,33  \nK: 5,6,15,16  \nR: 1,4,10  \nT: 11,33  \nTW: 1,12,13  \n  \nBC 501: Forgo  \nBC 502: Crawford  \nBC 503: McCoy  \nBC 504: Shiflett  \nBC 531: Barr  \nBC 581: Holman  \nBC 582: Lupton  \n  \nDuty HM: Kieb  \n  \nFM: Culbertson  \n  \nSF: Pagano  \n  \nUFRO: Hebert");

    doTest("T5",
        "(Important message from PW-ALERT) 05-Jul-2013/05:28:35/SICB/8538 STONEWALL RD ,MNSS /01F/E501 M501 /CALLER IS HAVING HOT AND COLD FLASHED/HIGH FEVER/BLEEDING BLOOD CLOTS FROM VAGINA/SAYS THE BLOOD IS BROWN\n\n" +
        "Sent by PW Alert to E501, M501, DFR CAD through Prince William County RSAN\r\n" +
        "--\r\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:07/05/2013",
        "TIME:05:28:35",
        "CODE:SICB",
        "CALL:BLS - Sickness",
        "ADDR:8538 STONEWALL RD",
        "CITY:MANASSAS",
        "BOX:01F",
        "UNIT:E501 M501",
        "INFO:CALLER IS HAVING HOT AND COLD FLASHED / HIGH FEVER / BLEEDING BLOOD CLOTS FROM VAGINA / SAYS THE BLOOD IS BROWN");

    doTest("T6",
        "(Important message from PW-ALERT) 05-Jul-2013/00:41:56/UNC/SEVEN 11 BALLS FORD @ 11171 BALLS FORD RD ,PWC /11/A525B E511 M501C M511 /2 PEOPLE APPEARED TO BE PASSED OUT IN A RED MUSTANG HALF WAY PARKED IN THE PARKIN\n\n" +
        "Sent by PW Alert to E511, M511, A525, M501, DFR CAD through Prince William County RSAN\r\n" +
        "--\r\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:07/05/2013",
        "TIME:00:41:56",
        "CODE:UNC",
        "CALL:Unconscious",
        "ADDR:11171 BALLS FORD RD",
        "PLACE:SEVEN 11 BALLS FORD",
        "BOX:11",
        "UNIT:A525B E511 M501C M511",
        "INFO:2 PEOPLE APPEARED TO BE PASSED OUT IN A RED MUSTANG HALF WAY PARKED IN THE PARKIN");

    doTest("T7",
        "(Important message from PW-ALERT) 05-Jul-2013/00:11:50/SICA/12091 LUCASVILLE RD ,PWC /07/E507 M501 /ADULT FEMALE DIFF BREATHING\n\n" +
        "Sent by PW Alert to E507, M501, DFR CAD through Prince William County RSAN\r\n" +
        "--\r\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:07/05/2013",
        "TIME:00:11:50",
        "CODE:SICA",
        "CALL:ALS - Sickness",
        "ADDR:12091 LUCASVILLE RD",
        "BOX:07",
        "UNIT:E507 M501",
        "INFO:ADULT FEMALE DIFF BREATHING");

    doTest("T8",
        "(Important message from PW-ALERT) 04-Jul-2013/23:34:01/SICB/8777 DEBLANC PL ,MNSS /01F/E501 M509B /6 yo daughter screaming and shaking that her stomach hurts, won't move - going on for 1-0 min\n\n" +
        "Sent by PW Alert to E501, DFR CAD through Prince William County RSAN\r\n" +
        "--\r\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:07/04/2013",
        "TIME:23:34:01",
        "CODE:SICB",
        "CALL:BLS - Sickness",
        "ADDR:8777 DEBLANC PL",
        "CITY:MANASSAS",
        "BOX:01F",
        "UNIT:E501 M509B",
        "INFO:6 yo daughter screaming and shaking that her stomach hurts, won't move - going on for 1-0 min");

    doTest("T9",
        "(Important message from PW-ALERT) 04-Jul-2013/23:10:41/INJB/CITY TAVERN GRILLE @ 9405 MAIN ST ,MNSS /01F/E501 M509B /1360a is calling for a guy named Brian who hurt ankle, mid 30's and wants amb // nfi\n\n" +
        "Sent by PW Alert to E501, DFR CAD through Prince William County RSAN\r\n" +
        "--\r\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "DATE:07/04/2013",
        "TIME:23:10:41",
        "CODE:INJB",
        "CALL:BLS - Injury",
        "ADDR:9405 MAIN ST",
        "CITY:MANASSAS",
        "PLACE:CITY TAVERN GRILLE",
        "BOX:01F",
        "UNIT:E501 M509B",
        "INFO:1360a is calling for a guy named Brian who hurt ankle, mid 30's and wants amb / nfi");
   
  }
  
  public static void main(String[] args) {
    new VAPrinceWilliamCountyAParserTest().generateTests("T1");
  }

}
