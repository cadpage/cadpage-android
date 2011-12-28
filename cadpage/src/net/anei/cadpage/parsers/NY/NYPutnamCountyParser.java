package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Putnam County, NY 
Contact: mike miller <eightytwo247@gmail.com>
Sender: 911@putnamcountyny.gov,messaging@iamresponding.com
STRUCTURE FIRE/RESIDENTIAL||34 MOUNTAIN BROOK DR  STA 11 XS MEMORIAL DR/LEONA DR|NARR WPH1-E
(CAD) CHEST PAIN||35 OAK ST  STA 11 XS HOYT  ST/MERRITT ST|NARR PROQA SUMMARY:DELTA 10D01 CHEST PAIN PATIENT WITH CHEST PAIN. 55-YEAR-OLD  FEMALE, CONSCIOUS
AUTOMATIC FIRE ALARM|METRO NORTH MECHANICAL SHOP|PROSPECT HILL RD  STA 11 XS  |NARR GENERAL
TRAFFIC/TRANSPORTATION ACCIDEN||I 684  N STA 11 XS I-84  E|NARR MVA W/ INJURIES- FEMALE SUBJECT COMPLAINING OF NECK AND BACK PAIN
TRAFFIC/TRANSPORTATION ACCIDEN||92 FOGGINTOWN RD  STA 11 XS FARM TO MARKET RD/HAWKS LN|NARR 1 CAR PIAA/UNK INJ PERSON: (COMPLAINANT) (FMLS) CHRISTINE
.... (11 Brewster) MEDIC ALERT||4100 STONECREST DR  STA 11 XS
(2 Carmel) AUTOMATIC FIRE ALARM|CARMEL HIGH SCHOOL|30 FAIR ST  STA 12 XS VINK  DR/COUNTY CTR|NARR 845 225-8352/GE'L FIRE PERSON: (COMPLAINANT) (FMLS)

Conact: brandon timmins <btimmins33@gmail.com>
.... (18 Mahopac) PSYCHIATRIC/ABNORMAL BEHAVIOR||151 W SHORE DR  STA 18 XS FARVIEW  RD/STEBBINS RD|NARR MALE EDP, SCENE SECURE..


Station numbers FYI
11 Brewster
12 Carmel
13 Cold Spring
14 Continental Village
15 Garrison
16 Kent
17 Lake Carmel
18 Mahopac
19 Mahopac Falls
20 Nelsonville *
21 North Highlands
22 Patterson
23 Putnam Lake
24 Putnam Valley
31 Carmel Ambulance
32 Garrison Ambulance
33 Philipstown Ambulance
34 Putnam Valley Ambulance
 
 */

public class NYPutnamCountyParser extends MsgParser {


  public NYPutnamCountyParser() {
    super("PUTNAM COUNTY", "NY");
  }
  

@Override
  public String getFilter() {
    return "911@putnamcountyny.gov,messaging@iamresponding.com";
  }

@Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.contains(" STA ")) return false;
    Parser p = new Parser(body);
    data.strCall = p.get('|');
    data.strPlace = p.get('|');
    parseAddress(p.get(" STA "), data);
    data.strSource = p.get(' ');
    data.strCross = p.get('|');
    if (data.strCross.equals("XS")) data.strCross = "";
    if (data.strCross.startsWith("XS ")) data.strCross = data.strCross.substring(3).trim();
    data.strSupp = p.get();
    if (data.strSupp.startsWith("NARR ")) data.strSupp = data.strSupp.substring(5).trim();
    return true;
  }
  
}