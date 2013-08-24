package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Carroll County, OH
Contact: David Hess <ffhess@gmail.com>
Sender: iamresponding.com
System: Nomad Paging System

JCOM... RC:Emergency/STROKE/508 ANTIGUA RD//CARROLLTON/Possible CVA////10:53/1.7 nm///<Unknown>/Run# 9888
JCOM... RC:Emergency/Diabetic Emergency/104 ASTER RD SE//CARROLLTON/60 yom diabetic-altered LOC/911ccso////18:36/7.0 nm///<Unknown>/Run# 9169
JCOM... RC:Emergency/Heart/2081 WAYNESBURG RD NW//CARROLLTON/elderly female low pulse rate 30's////11:41/2.1 nm///<Unknown>/Run# 8516
JCOM... RC:Emergency/General Illness/Carroll Golden Age Retreat (A)/WARD/CARROLLTON/BETTY BEADNELL - WAS IN RESP DISTRESS - EMENSIS X2 - TEMP 104.1////18:23/1.4 nm///<Unknown>/Run# 8280
JCOM... RC:Emergency/STROKE/6342 LYNN RD NE//MINERVA/75 yom poss cva-pri call////19:47/4.9 nm///<Unknown>/Run# 8145
JCOM... RC:Emergency/Fall/2092 PANAMA RD//CARROLLTON/2 yom Fell / not moving his head////09:42/4.7 nm///<Unknown>/Run# 8249
JCOM... RC:Emergency/BLEEDING - UNCONTROLLED/Mercy Stat Care- Carrollton (911)//CARROLLTON/partial amputation of l thumb / 51 yom////14:59/1.2 nm///<Unknown>/Run# 40967
JCOM... RC:Emergency/BLEEDING - UNCONTROLLED/Mercy Stat Care- Carrollton (911)//CARROLLTON/partial amputation of l thumb / 51 yom////14:59/1.2 nm///<Unknown>/Run# 40967
JCOM... RC:Emergency/Pain - HIP/8240 CLOVER RD NE//MECHANICSTOWN/Hip and leg pain / right next to Fox Garage////08:05/7.8 nm///<Unknown>/Run# 41101
JCOM... RC:Emergency/General Illness/144 2ND ST NW//CARROLLTON/24yof/ poss contractions 28 weeks -- back parking lot////15:10/1.5 nm///<Unknown>/Run# 40185
JCOM... RC:Emergency/MVA/LARAMIE RD & CANTON RD NW//CARROLLTON/mva 4 car crash////09:46/4.6 nm///<Unknown>/Run# 40908
JCOM... RC:Emergency/PAIN - ABDOMINAL/4257 JADE RD NW//DELLROY/60 yom/ poss impacted bowel/ downs syndrome / car911////01:10/3.6 nm///<Unknown>/Run# 478
JCOM... RC:Emergency/Chest Pain/Mercy Stat Care- Carrollton (911)/waiting rm/CARROLLTON/male/ chest pains////07:53/1.2 nm///<Unknown>/Run# 40618
JCOM... RC:Emergency/Chest Pain/Mercy Stat Care- Carrollton (911)//CARROLLTON/46 yom chest pain/ dyspnea/ 3 baby asa given/ bradycardia////17:53/1.2 nm///<Unknown>/Run# 40076
JCOM... RC:Emergency/SEIZURES/6084 KENSINGTON RD NE//CARROLLTON/25 yom seizure / cc911////03:46/6.2 nm///<Unknown>/Run# 41972
JCOM... RC:Emergency/MVA/6118 SALINEVILLE RD//MECHANICSTOWN/Kangaroo Crossing / MVA////13:34/5.6 nm///<Unknown>/Run# 1463
JCOM... RC:Emergency/Dyspnea/5100 PINTO RD SE//CARROLLTON/chris talty sob/ in a roll off truck////14:52/6.0 nm///<Unknown>/Run# 1593
JCOM... RC:Emergency/BLEEDING - UNCONTROLLED/2292 WAYNESBURG RD NW//CARROLLTON/female/ having nose bleeds/ and coughing up blood////02:27/2.4 nm///<Unknown>/Run# 2305
JCOM... RC:Emergency/General Illness/Sunnyslope Nursing Home (A)/d 12- bed b/BOWERSTON/dark brown emensis////07:40/11.3 nm///<Unknown>/Run# 4329
JCOM... RC:Emergency/Chest Pain/66 4TH ST NE//CARROLLTON/male with chest pains/ given 81 mg baby asa given / cc911////03:42/1.5 nm///<Unknown>/Run# 639
JCOM... RC:Emergency/Psychiactric/20 N LIBERTY ST//DELLROY/Poss Suicidal Subject / Was talking on the phone with her when the phone went dead and they could not reach her / CCSO////07:49/5.3 nm///<Unknown>/Run# 1452
JCOM... RC:Emergency/BLEEDING - UNCONTROLLED/4334 LUNAR RD//CARROLLTON/Female fell off horse / South of Spring////13:39/2.1 nm///<Unknown>/Run# 4882
JCOM... RC:Emergency/Dizziness/160 ARROW RD SW//CARROLLTON/77 yom dizzy can't get out of bed - basement door / priv caller////07:08/3.2 nm///<Unknown>/Run# 4863
JCOM... RC:Emergency/General Illness/3072 CANTON RD NW//CARROLLTON/M poss non breather////12:10/1.6 nm///<Unknown>/Run# 4802
JCOM... RC:Emergency/MVA/ST HWY 43/n/o gallo rd//mva poss entrapment/ ccso////00:47/0.0 nm///<Unknown>/Run# 5344
JCOM... RC:Emergency/MVA/STATE HWY 39 & BURROW RD//CARROLLTON/1 car roll over/ poss 6 kids inj////16:41/3.8 nm///<Unknown>/Run# 3136
JCOM... RC:Emergency/UNRESPONSIVE/592 6TH ST NW/carroll lanes/CARROLLTON/restaraunt male not responding cc911////10:13/1.1 nm///<Unknown>/Run# 3553
JCOM... RC:Emergency/Chest Pain/5135 ALLIANCE RD NW//MALVERN/chest pain////04:05/7.0 nm///<Unknown>/Run# 4472
JCOM... RC:Emergency/Fall/6065 LYNN RD NE//MINERVA/female / ill/ fall still on the ground vomiting////13:17/4.7 nm///<Unknown>/Run# 2562
JCOM... RC:Emergency/SEIZURES/STATE HWY 542 & MAIN ST//DELLROY/Seizures / White crew cab work truck////08:32/5.5 nm///<Unknown>/Run# 2312

 */
public class OHCarrollCountyParserTest extends BaseParserTest {
  
  public OHCarrollCountyParserTest() {
    setParser(new OHCarrollCountyParser(), "CARROLL COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "JCOM... RC:Emergency/STROKE/508 ANTIGUA RD//CARROLLTON/Possible CVA////10:53/1.7 nm///<Unknown>/Run# 9888",
        "ID:9888",
        "CALL:STROKE",
        "ADDR:508 ANTIGUA RD",
        "CITY:CARROLLTON",
        "INFO:Possible CVA / 1.7 nm",
        "TIME:10:53");

    doTest("T2",
        "JCOM... RC:Emergency/Diabetic Emergency/104 ASTER RD SE//CARROLLTON/60 yom diabetic-altered LOC/911ccso////18:36/7.0 nm///<Unknown>/Run# 9169",
        "ID:9169",
        "CALL:Diabetic Emergency",
        "ADDR:104 ASTER RD SE",
        "CITY:CARROLLTON",
        "INFO:60 yom diabetic-altered LOC / 911ccso / 7.0 nm",
        "TIME:18:36");

    doTest("T3",
        "JCOM... RC:Emergency/Heart/2081 WAYNESBURG RD NW//CARROLLTON/elderly female low pulse rate 30's////11:41/2.1 nm///<Unknown>/Run# 8516",
        "ID:8516",
        "CALL:Heart",
        "ADDR:2081 WAYNESBURG RD NW",
        "CITY:CARROLLTON",
        "INFO:elderly female low pulse rate 30's / 2.1 nm",
        "TIME:11:41");

    doTest("T4",
        "JCOM... RC:Emergency/General Illness/Carroll Golden Age Retreat (A)/WARD/CARROLLTON/BETTY BEADNELL - WAS IN RESP DISTRESS - EMENSIS X2 - TEMP 104.1////18:23/1.4 nm///<Unknown>/Run# 8280",
        "ID:8280",
        "CALL:General Illness",
        "ADDR:Carroll Golden Age Retreat (A)",
        "MADDR:Carroll Golden Age Retreat",
        "PLACE:WARD",
        "CITY:CARROLLTON",
        "INFO:BETTY BEADNELL - WAS IN RESP DISTRESS - EMENSIS X2 - TEMP 104.1 / 1.4 nm",
        "TIME:18:23");

    doTest("T5",
        "JCOM... RC:Emergency/STROKE/6342 LYNN RD NE//MINERVA/75 yom poss cva-pri call////19:47/4.9 nm///<Unknown>/Run# 8145",
        "ID:8145",
        "CALL:STROKE",
        "ADDR:6342 LYNN RD NE",
        "CITY:MINERVA",
        "INFO:75 yom poss cva-pri call / 4.9 nm",
        "TIME:19:47");

    doTest("T6",
        "JCOM... RC:Emergency/Fall/2092 PANAMA RD//CARROLLTON/2 yom Fell / not moving his head////09:42/4.7 nm///<Unknown>/Run# 8249",
        "ID:8249",
        "CALL:Fall",
        "ADDR:2092 PANAMA RD",
        "CITY:CARROLLTON",
        "INFO:2 yom Fell / not moving his head / 4.7 nm",
        "TIME:09:42");

    doTest("T7",
        "JCOM... RC:Emergency/BLEEDING - UNCONTROLLED/Mercy Stat Care- Carrollton (911)//CARROLLTON/partial amputation of l thumb / 51 yom////14:59/1.2 nm///<Unknown>/Run# 40967",
        "ID:40967",
        "CALL:BLEEDING - UNCONTROLLED",
        "ADDR:Mercy Stat Care- Carrollton (911)",
        "MADDR:Mercy Stat Care- Carrollton",
        "CITY:CARROLLTON",
        "INFO:partial amputation of l thumb / 51 yom / 1.2 nm",
        "TIME:14:59");

    doTest("T8",
        "JCOM... RC:Emergency/BLEEDING - UNCONTROLLED/Mercy Stat Care- Carrollton (911)//CARROLLTON/partial amputation of l thumb / 51 yom////14:59/1.2 nm///<Unknown>/Run# 40967",
        "ID:40967",
        "CALL:BLEEDING - UNCONTROLLED",
        "ADDR:Mercy Stat Care- Carrollton (911)",
        "MADDR:Mercy Stat Care- Carrollton",
        "CITY:CARROLLTON",
        "INFO:partial amputation of l thumb / 51 yom / 1.2 nm",
        "TIME:14:59");

    doTest("T9",
        "JCOM... RC:Emergency/Pain - HIP/8240 CLOVER RD NE//MECHANICSTOWN/Hip and leg pain / right next to Fox Garage////08:05/7.8 nm///<Unknown>/Run# 41101",
        "ID:41101",
        "CALL:Pain - HIP",
        "ADDR:8240 CLOVER RD NE",  // Not located in MECHANICSTOWN
        "CITY:MECHANICSTOWN",
        "INFO:Hip and leg pain / right next to Fox Garage / 7.8 nm",
        "TIME:08:05");

    doTest("T10",
        "JCOM... RC:Emergency/General Illness/144 2ND ST NW//CARROLLTON/24yof/ poss contractions 28 weeks -- back parking lot////15:10/1.5 nm///<Unknown>/Run# 40185",
        "ID:40185",
        "CALL:General Illness",
        "ADDR:144 2ND ST NW",
        "CITY:CARROLLTON",
        "INFO:24yof / poss contractions 28 weeks -- back parking lot / 1.5 nm",
        "TIME:15:10");

    doTest("T11",
        "JCOM... RC:Emergency/MVA/LARAMIE RD & CANTON RD NW//CARROLLTON/mva 4 car crash////09:46/4.6 nm///<Unknown>/Run# 40908",
        "ID:40908",
        "CALL:MVA",
        "ADDR:LARAMIE RD & CANTON RD NW",
        "CITY:CARROLLTON",
        "INFO:mva 4 car crash / 4.6 nm",
        "TIME:09:46");

    doTest("T12",
        "JCOM... RC:Emergency/PAIN - ABDOMINAL/4257 JADE RD NW//DELLROY/60 yom/ poss impacted bowel/ downs syndrome / car911////01:10/3.6 nm///<Unknown>/Run# 478",
        "ID:478",
        "CALL:PAIN - ABDOMINAL",
        "ADDR:4257 JADE RD NW",
        "CITY:DELLROY",
        "INFO:60 yom / poss impacted bowel / downs syndrome / car911 / 3.6 nm",
        "TIME:01:10");

    doTest("T13",
        "JCOM... RC:Emergency/Chest Pain/Mercy Stat Care- Carrollton (911)/waiting rm/CARROLLTON/male/ chest pains////07:53/1.2 nm///<Unknown>/Run# 40618",
        "ID:40618",
        "CALL:Chest Pain",
        "ADDR:Mercy Stat Care- Carrollton (911)",
        "MADDR:Mercy Stat Care- Carrollton",
        "PLACE:waiting rm",
        "CITY:CARROLLTON",
        "INFO:male / chest pains / 1.2 nm",
        "TIME:07:53");

    doTest("T14",
        "JCOM... RC:Emergency/Chest Pain/Mercy Stat Care- Carrollton (911)//CARROLLTON/46 yom chest pain/ dyspnea/ 3 baby asa given/ bradycardia////17:53/1.2 nm///<Unknown>/Run# 40076",
        "ID:40076",
        "CALL:Chest Pain",
        "ADDR:Mercy Stat Care- Carrollton (911)",
        "MADDR:Mercy Stat Care- Carrollton",
        "CITY:CARROLLTON",
        "INFO:46 yom chest pain / dyspnea / 3 baby asa given / bradycardia / 1.2 nm",
        "TIME:17:53");

    doTest("T15",
        "JCOM... RC:Emergency/SEIZURES/6084 KENSINGTON RD NE//CARROLLTON/25 yom seizure / cc911////03:46/6.2 nm///<Unknown>/Run# 41972",
        "ID:41972",
        "CALL:SEIZURES",
        "ADDR:6084 KENSINGTON RD NE",
        "CITY:CARROLLTON",
        "INFO:25 yom seizure / cc911 / 6.2 nm",
        "TIME:03:46");

    doTest("T16",
        "JCOM... RC:Emergency/MVA/6118 SALINEVILLE RD//MECHANICSTOWN/Kangaroo Crossing / MVA////13:34/5.6 nm///<Unknown>/Run# 1463",
        "ID:1463",
        "CALL:MVA",
        "ADDR:6118 SALINEVILLE RD",
        "CITY:MECHANICSTOWN",
        "INFO:Kangaroo Crossing / MVA / 5.6 nm",
        "TIME:13:34");

    doTest("T17",
        "JCOM... RC:Emergency/Dyspnea/5100 PINTO RD SE//CARROLLTON/chris talty sob/ in a roll off truck////14:52/6.0 nm///<Unknown>/Run# 1593",
        "ID:1593",
        "CALL:Dyspnea",
        "ADDR:5100 PINTO RD SE",
        "CITY:CARROLLTON",
        "INFO:chris talty sob / in a roll off truck / 6.0 nm",
        "TIME:14:52");

    doTest("T18",
        "JCOM... RC:Emergency/BLEEDING - UNCONTROLLED/2292 WAYNESBURG RD NW//CARROLLTON/female/ having nose bleeds/ and coughing up blood////02:27/2.4 nm///<Unknown>/Run# 2305",
        "ID:2305",
        "CALL:BLEEDING - UNCONTROLLED",
        "ADDR:2292 WAYNESBURG RD NW",
        "CITY:CARROLLTON",
        "INFO:female / having nose bleeds / and coughing up blood / 2.4 nm",
        "TIME:02:27");

    doTest("T19",
        "JCOM... RC:Emergency/General Illness/Sunnyslope Nursing Home (A)/d 12- bed b/BOWERSTON/dark brown emensis////07:40/11.3 nm///<Unknown>/Run# 4329",
        "ID:4329",
        "CALL:General Illness",
        "ADDR:Sunnyslope Nursing Home (A)",
        "MADDR:Sunnyslope Nursing Home",
        "PLACE:d 12- bed b",
        "CITY:BOWERSTON",
        "INFO:dark brown emensis / 11.3 nm",
        "TIME:07:40");

    doTest("T20",
        "JCOM... RC:Emergency/Chest Pain/66 4TH ST NE//CARROLLTON/male with chest pains/ given 81 mg baby asa given / cc911////03:42/1.5 nm///<Unknown>/Run# 639",
        "ID:639",
        "CALL:Chest Pain",
        "ADDR:66 4TH ST NE",
        "CITY:CARROLLTON",
        "INFO:male with chest pains / given 81 mg baby asa given / cc911 / 1.5 nm",
        "TIME:03:42");

    doTest("T21",
        "JCOM... RC:Emergency/Psychiactric/20 N LIBERTY ST//DELLROY/Poss Suicidal Subject / Was talking on the phone with her when the phone went dead and they could not reach her / CCSO////07:49/5.3 nm///<Unknown>/Run# 1452",
        "ID:1452",
        "CALL:Psychiactric",
        "ADDR:20 N LIBERTY ST",
        "CITY:DELLROY",
        "INFO:Poss Suicidal Subject / Was talking on the phone with her when the phone went dead and they could not reach her / CCSO / 5.3 nm",
        "TIME:07:49");

    doTest("T22",
        "JCOM... RC:Emergency/BLEEDING - UNCONTROLLED/4334 LUNAR RD//CARROLLTON/Female fell off horse / South of Spring////13:39/2.1 nm///<Unknown>/Run# 4882",
        "ID:4882",
        "CALL:BLEEDING - UNCONTROLLED",
        "ADDR:4334 LUNAR RD",
        "CITY:CARROLLTON",
        "INFO:Female fell off horse / South of Spring / 2.1 nm",
        "TIME:13:39");

    doTest("T23",
        "JCOM... RC:Emergency/Dizziness/160 ARROW RD SW//CARROLLTON/77 yom dizzy can't get out of bed - basement door / priv caller////07:08/3.2 nm///<Unknown>/Run# 4863",
        "ID:4863",
        "CALL:Dizziness",
        "ADDR:160 ARROW RD SW",
        "CITY:CARROLLTON",
        "INFO:77 yom dizzy can't get out of bed - basement door / priv caller / 3.2 nm",
        "TIME:07:08");

    doTest("T24",
        "JCOM... RC:Emergency/General Illness/3072 CANTON RD NW//CARROLLTON/M poss non breather////12:10/1.6 nm///<Unknown>/Run# 4802",
        "ID:4802",
        "CALL:General Illness",
        "ADDR:3072 CANTON RD NW",
        "CITY:CARROLLTON",
        "INFO:M poss non breather / 1.6 nm",
        "TIME:12:10");

    doTest("T25",
        "JCOM... RC:Emergency/MVA/ST HWY 43/n/o gallo rd//mva poss entrapment/ ccso////00:47/0.0 nm///<Unknown>/Run# 5344",
        "ID:5344",
        "CALL:MVA",
        "ADDR:ST HWY 43",
        "MADDR:OH 43 & gallo rd",
        "X:n/o gallo rd",
        "INFO:mva poss entrapment / ccso / 0.0 nm",
        "TIME:00:47");

    doTest("T26",
        "JCOM... RC:Emergency/MVA/STATE HWY 39 & BURROW RD//CARROLLTON/1 car roll over/ poss 6 kids inj////16:41/3.8 nm///<Unknown>/Run# 3136",
        "ID:3136",
        "CALL:MVA",
        "ADDR:STATE HWY 39 & BURROW RD",
        "MADDR:STATE 39 & BURROW RD",
        "CITY:CARROLLTON",
        "INFO:1 car roll over / poss 6 kids inj / 3.8 nm",
        "TIME:16:41");

    doTest("T27",
        "JCOM... RC:Emergency/UNRESPONSIVE/592 6TH ST NW/carroll lanes/CARROLLTON/restaraunt male not responding cc911////10:13/1.1 nm///<Unknown>/Run# 3553",
        "ID:3553",
        "CALL:UNRESPONSIVE",
        "ADDR:592 6TH ST NW",
        "PLACE:carroll lanes",
        "CITY:CARROLLTON",
        "INFO:restaraunt male not responding cc911 / 1.1 nm",
        "TIME:10:13");

    doTest("T28",
        "JCOM... RC:Emergency/Chest Pain/5135 ALLIANCE RD NW//MALVERN/chest pain////04:05/7.0 nm///<Unknown>/Run# 4472",
        "ID:4472",
        "CALL:Chest Pain",
        "ADDR:5135 ALLIANCE RD NW",
        "CITY:MALVERN",
        "INFO:chest pain / 7.0 nm",
        "TIME:04:05");

    doTest("T29",
        "JCOM... RC:Emergency/Fall/6065 LYNN RD NE//MINERVA/female / ill/ fall still on the ground vomiting////13:17/4.7 nm///<Unknown>/Run# 2562",
        "ID:2562",
        "CALL:Fall",
        "ADDR:6065 LYNN RD NE",
        "CITY:MINERVA",
        "INFO:female / ill / fall still on the ground vomiting / 4.7 nm",
        "TIME:13:17");

    doTest("T30",
        "JCOM... RC:Emergency/SEIZURES/STATE HWY 542 & MAIN ST//DELLROY/Seizures / White crew cab work truck////08:32/5.5 nm///<Unknown>/Run# 2312",
        "ID:2312",
        "CALL:SEIZURES",
        "ADDR:STATE HWY 542 & MAIN ST",
        "MADDR:STATE 542 & MAIN ST",
        "CITY:DELLROY",
        "INFO:Seizures / White crew cab work truck / 5.5 nm",
        "TIME:08:32");
  
  }
  
  public static void main(String[] args) {
    new OHCarrollCountyParserTest().generateTests("T1");
  }
}