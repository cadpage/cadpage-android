package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Cayuga County, NY


Should be general alert
(From 911 Center) ANY MEMBER THAT CAN DEPLOY FOR SEFU ON SUNDAY CONTACT ASST. CHF SABIN ON HIS CELLPHONE ASAP

Contact: Corey <crooker1@twcny.rr.com>
Sender: cayuga911@co.cayuga.ny.us

(From 911 Center) 02/14/11 16:26 5 CEDAR LN BRUTUS Cardiac
(From 911 Center) 02/14/11 14:59 8318 W  LOOP RD MONTEZUMA General  
(From 911 Center) 02/14/11 12:19 PINE ST PARK ST PORT BYRON Collapse
(From 911 Center) 02/14/11 10:29 7 EVERGREEN LN BRUTUS Stroke

Contact: John Betts <philbert08@yahoo.com>
FRM:cayuga911@co.cayuga.ny.us\nSUBJ:From911Center\nMSG:\n04/20/11 13:51 3204 FRANKLIN STREET RD SENNETT Alarm - Fire\n

Contact: Christine Thurston <thurstce@gmail.com>
(From 911 Center) 06/15/11 00:03 215 CAYUGA ST UNION SPRINGS Cardiac  Call Number 467 was created from Call Number 462(Jun 14 2011 11:20PM)  stried the pho

Contact: Corey <crooker1@twcny.rr.com>
(From 911 Center) 08/27/11 02:10 RIVER RD RT 38 CONQUEST MVAPI  subject came into bar  bloody states car accident   pirates landing bar  mvapi   believes
(From 911 Center) 08/27/11 00:42 HEJAMADA CAMPGROUND764 MC DONALD RD MONTEZUMA General Illness  mohawk section    off to left after gate  68 yo f   left a
(From 911 Center) 08/26/11 14:49 8860 S  WILLOW ST WEEDSPORT General Illness  60 Y/O FEMALE  CALLER STATES SHE NEEDS TO GO TO ST JOES PER HER DR... ABDOME
(From 911 Center) 08/26/11 09:59 8860 S  WILLOW ST WEEDSPORT Injury from a Fall  70 FEMALE FELL YESTERDAY/DIFF AMBULATING TODAY  E911 Info - Class of Serv
(From 911 Center) 08/24/11 22:00 8750 CENTERPORT RD MENTZ Cardiac  79 Y/O FEMALE CHEST PAINS...  DERBY RESIDENCE

Contact: Mike Clark <mcceltics5@gmail.com>
Sender: messaging@iamresponding.com
FRM:messaging@iamresponding.com\nSUBJ:Owasco\nMSG:05/14/13 05:08 ONEIL RD BROADWAY RD OWASCO Structure Fire  POSS BARN FIRE

Contact: Active911
Agency name: Sennett Fire Department
Location: Sennett, NY, United States
Sender: cayuga911@nameservices.net

(From 911 Center) 04/29/13 03:32 3377 FRANKLIN STREET RD SENNETT Cardiac  HAD A HEART ATTACK 2 WEEKS AGO  61 YO FEMALE BURNING CHEST PAIN  E911 Info - Class of Service: RESD Special Response Info: CAY. CO. SHERIFF & NY ST POLICE SENNETT FD                      RURAL METRO AMBULANCE a 
(From 911 Center) 04/28/13 12:06 WEST LAKE RD/HEN COOP RD ONONDAGA COUNTY Structure Fire 
(From 911 Center) 04/27/13 09:27 3 ELSON LN/SKANEATLES ONONDAGA COUNTY Assist by Fire  STRUCTURE FIRE  OFF E LAKE RD  TANKER OUT OF SENNETT 
(From 911 Center) 04/26/13 12:55 2 JOHN SMITH AVE SENNETT Seizures  85 YO F SEIZURE 
(From 911 Center) 04/26/13 07:30 7581 PARCELL RD SENNETT Seizures  8 YO MALE ACTIVE SEIZURES 
(From 911 Center) 04/25/13 19:34 2616 MANROW RD SENNETT Cardiac  85 YO F  WARM FEELING IN CHEST 
(From 911 Center) 04/24/13 05:05 DILAJS7430 N  STREET RD SENNETT Bleeding  51 YO MALE  NOSE BLEED  ROOM 15 
(From 911 Center) 04/19/13 17:10 DEPOT RD FREEMAN RD SENNETT Hazard - Fire  EAST OF INTERSECTION  WIRE DOWN IN THE ROAD 
(From 911 Center) 04/19/13 08:00 2 JOHN SMITH AVE SENNETT Seizures 
(From 911 Center) 04/18/13 17:23 MILLER RD COUNTY LINE RD SENNETT Hazard - Fire  SORELLO RES AREA  TREE IS NOT IN ROAD BUT WIRES ARE  SOME WIRES DOWN AND PART OF A TREE  ACROSS FROM PETERS FARM  WEST ABOUT 500 FT 
(From 911 Center) 04/13/13 19:06 3377 FRANKLIN STREET RD SENNETT Cardiac  FRONT DOOR IS OPEN  FRENCH RESIDENCE  61 YO F CHEST PAINS 
(From 911 Center) 04/12/13 20:41 7822 PARCELL RD SENNETT Difficulty Breathing/SOB  77 yo  m  E911 Info - Class of Service: RESD Special Response Info: CAY. CO. SHERIFF & NY ST POLICE SENNETT FD                      WEEDSPORT AMBULANCE 
(From 911 Center) 04/10/13 14:58 ENTERPRISE RENTAL329 GRANT AVENUE RD SENNETT General Illness  80 MALE NOT FEELING  E911 Info - Class of Service: CNTX Special Response Info: CAY. CO. SHERIFF & NY ST POLICE SENNETT FD                      RURAL METRO AMBULANCE w 
(From 911 Center) 04/09/13 14:54 SHEPHERD RD WEEDSPORT SENNETT RD SENNETT MVAPI  motorcyle accident/2 people with injuries 
(From 911 Center) 05/08/13 16:21 14 WESTLAKE ST, SKANEATELES ONONDAGA COUNTY Assist by Fire  CROSS WEST GENESEE ST (RT 20)  OVEN FIRE ----ONE ENGINE FROM SENNETT
(From 911 Center) 05/07/13 21:15 7822 PARCELL RD SENNETT General Illness  78 Y/O MALE RUNNING A FEVER AND IS CONFUSED... JUST HAD LUNG SURGERY
(From 911 Center) 05/09/13 10:25 E  GENESEE STREET RD SWAMP RD SENNETT Hazard - Fire  BETWEEN SWAMP RD AND BEECH RD, LOW HANGING WIRE STRUCK BY A TRUCK
(From 911 Center) 05/08/13 11:13 3636 E GENESEE STREET RD SENNETT Unconscious Person  46 y/o male passed out cold

Contact: Active911
Agency name: Sennett Fire Department
Location: Sennett, NY, United States
Sender: dspingler@cayugacounty.us

(From 911 Center) 6 PLAZA PANERA BREADSENNETT GRANT AVENUE RD, MUTTON HILL RD / DEAD END Alarm - Fire  OPER 30  DINING ROOM SMOKE DETECTOR AND POOL STATIONS FIRE ALARM  06/12/13 22:20 2013-00000142 UAS
(From 911 Center) 3184 FRANKLIN STREET SENNETT FRANKLIN ST / PINE RIDGE RD, CHESTNUT RIDGE RD General Illness  G  92 YO MALE ALTERED LOC AND SHAKIN  STRAUSS RES  E911 Info - Class of Service: VOIP Special Response Info: VOIP CALL                       QUERY CALLER FOR LOCATION       QUERY CALLER FOR CALLBK Uncertainty:  Confidence:  06/12/13 12:22 2013-00000141 EDMUNDS HELEN
(From 911 Center) 7168 PARCELL SENNETT CALEMAD DR / CENTER STREET RD Difficulty Breathing/SOB  NO CHEST PAINS  REQUESTS NO LIGHTS OR SIREN ON APPROACH  82 YO MALE W/PAIN IN HIS LEFT ARM AND DIFF BREATHING  E911 Info - Class of Service: RESD Special Response Info: CAY. CO. SHERIFF & NY ST POLICE SENNETT FD                      S.A.V.E.S. AMBULANCE N Uncertainty:  Confidence:  06/12/13 07:40 2013-00000140 NASH ELIZABETH
(From 911 Center) TURNPIKE SENNETT Hazard - Fire  POWER LINES VERY LOW CAUSING A HAZARD  06/11/13 17:41 2013-00000139 SUNERLIS TAMMY

Contact: Active911
Agency name: Owasco Fire Dept
Location: Auburn, NY, United States
Sender: dspingler@cayugacounty.us

(From 911 Center) 5805 DUNNING FLEMING RIESTER RD, WILLOW BROOK RD / KOON RD Difficulty Breathing/SOB  to ach  89 female congestive heart failure  06/14/13 06:23 2013-00000130 johnson melissa
(From 911 Center) 5886 LAKE FLEMING POPLAR COVE / BUCK POINT RD Pain - General  LEG PAIN  69 YO MALE  06/13/13 09:28 2013-00000129 TAMBURO SAMUEL
(From 911 Center) 6 FIRE LANE 1B OWASCO ICFOWASCO E LAKE RD / LAKESHORE DR General Illness  Call Number 942 was created from Call Number 937(Jun 12 2013 10:36AM)  74 male with a mental issue was being violent to the staff is now calm.  They need transport to ACH for mental evaluation.  E911 Info - Class of Service: RESD Special Response Info: CAY. CO. SHERIFF & NY ST POLICE OWASCO FD                       OWASCO AMBULANCE T Uncertainty:  Confidence:  06/12/13 10:47 2013-00000206 Ball George
(From 911 Center) 341 POPLAR BEACH OWASCO DEAD END / E LAKE RD Cardiac  PAI  TOOK NITRO  86 YO M CHEST PAINS  LEADER RES  06/11/13 15:59 2013-00000205 LEADER JEAN

Contact: Richard Ryan <ryanrichard1103@gmail.com>
Sender: dspingler@cayugacounty.us
(From 911 Center) 13681 QUEENS FARMS STERLING FINTCHES CORNERS RD / RT 104 Allergic Reaction  HARDY RES  STATES ITS SWELLING  BIT BY BEE YESTERDAY  53 Y/O
(From 911 Center) 15369 MCINTYRE STERLING COOPER BLUFF RD / FIRE LANE 1 Injury from a Fall  #NEDINA  MCINTYRE RESIDENCE  87 YO MALE, FELL ON BATHROOM FLOO
(From 911 Center) 13681 QUEENS FARMS STERLING FINTCHES CORNERS RD / RT 104 Allergic Reaction  HARDY RES  STATES ITS SWELLING  BIT BY BEE YESTERDAY  53 Y/O
(From 911 Center) 5355 SPRING GREEN RD Difficulty Breathing/SOB  TOWN OF BUTLER  BETWEEN  WOLCOTT RD AND DEIGL RD  71 MALE DIFFICULTY
(From 911 Center) 15385 FARDEN STERLING RENAISSANCE FESTSTERLING CENTER RD, MACNIEL RD / MCFARLAND RD, JENSVOLD RD Injury from a Fall  RIGHT OUTSIDE THE M
(From 911 Center) 15385 FARDEN STERLING RENAISSANCE FESTSTERLING CENTER RD, MACNIEL RD / MCFARLAND RD, JENSVOLD RD Pain - General  ENTER THROUGH EMPLOYEE
(From 911 Center) 14280 ACRE STERLING VICTORY ST / LADUE RD, STERLING STATION RD Cardiac  72 Y/O FEMALE HAS AN INTERNAL DEFIB AND IT IS GOING OFF ... LOW
(From 911 Center) 15385 FARDEN STERLING RENAISSANCE FESTSTERLING CENTER RD, MACNIEL RD / MCFARLAND RD, JENSVOLD RD Injury from a Fall  6 Y/O FELL FEMALE F
(From 911 Center) 14948 BAY FAIR HAVEN SHADY SHORES / N HADCOCK DR Cardiac  TOOK ALL MEDS  JUST HAD COFFEE AND PBJ ON TOAST  HAS ALREADY CHEWED A BABY ASP
(From 911 Center) 624 4TH WILDWOOD CAMPGROUNDFAIR HAVEN CHURCH ST / CAYUGA ST Difficulty Breathing/SOB  64 YO FEMALE W/DIFF BREATHING  3RD SITE IN  08/11/
(From 911 Center) 14955 BAY STERLING UNKNOWN / SHADY SHORES Water Rescue  THEY ARE RIGHT AT THS SHORE  BOAT INFRONT OF SHADY SHORES CAMPGROUND ON LAKE ONT
(From 911 Center) 104A STERLING Hazard - Fire  POLE LEANING/WIRES DOWN ACROSS THE ROAD  08/09/13 04:42 2013-00000248 TAYLOR SKIP
(From 911 Center) 15576 FIRE LANE 1 STERLING FIRE LANE 1B / DEAD END Personal Injury  CCSO ON SCENE  41 F - CHECK OVER - WRIST INJ AFTER A DOMESTIC  Call
(From 911 Center) 14932 HADCOCK FAIR HAVEN W BAY RD / S HADCOCK DR, PATTY RD Cardiac  GAVE HER 4 BABY ASPIRIN, HAD HER CHEW THEM AND SWALLOW  75 YO FEMALE
(From 911 Center) 1168 104A STERLING STERLING STATION RD / TEACHOUT RD Stroke  82 YO FEMALE EXTREMELY LETHARGIC AND WEAK FOR THE LAST FEW DAYS  PRITCHARD
(From 911 Center) 13716 MARTVILLE STERLING NICHOLS RD / RT 104 Pain - General  EMD  BELOW THE NAVAL  SURG WAS EARLIER TODAY  ACH  27 YO F EXTREME PAIN AFT 
(From 911 Center) 14404 FAIR HAVEN FAIR HAVEN MAIN ST / SIMMONS RD Alarm - Fire  OPER 25476  REF 25476  DEAN SMITH INC  SMOKE DETECTOR ACTIVATION  08/06/1
(From 911 Center) 14985 STATE PARK FAIR HAVEN STATE PARKFAIR HAVEN DEAD END / 7TH ST General Illness  CHECK OUT 2 SUBJ  07/27/13 23:18 2013-00000218 GUARD

*/

public class NYCayugaCountyParserTest extends BaseParserTest {
  
  public NYCayugaCountyParserTest() {
    setParser(new NYCayugaCountyParser(), "CAYUGA COUNTY", "NY");
  }
  
  @Test
  public void testGeneralAlert() {

    doTest("T1",
        "(From 911 Center) ANY MEMBER THAT CAN DEPLOY FOR SEFU ON SUNDAY CONTACT ASST. CHF SABIN ON HIS CELLPHONE ASAP",
        "CALL:GENERAL ALERT",
        "PLACE:ANY MEMBER THAT CAN DEPLOY FOR SEFU ON SUNDAY CONTACT ASST. CHF SABIN ON HIS CELLPHONE ASAP");

  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(From 911 Center) 02/14/11 16:26 5 CEDAR LN BRUTUS Cardiac",
        "ADDR:5 CEDAR LN",
        "DATE:02/14/11", 
        "TIME:16:26",
        "CITY:BRUTUS",
        "CALL:Cardiac");

    doTest("T2",
        "(From 911 Center) 02/14/11 14:59 8318 W  LOOP RD MONTEZUMA General",
        "DATE:02/14/11",
        "TIME:14:59",
        "ADDR:8318 W LOOP RD",
        "CITY:MONTEZUMA",
        "CALL:General");

    doTest("T3",
        "(From 911 Center) 02/14/11 12:19 PINE ST & PARK ST PORT BYRON Collapse",
        "DATE:02/14/11",
        "TIME:12:19",
        "ADDR:PINE ST & PARK ST",
        "CITY:PORT BYRON",
        "CALL:Collapse");

    doTest("T4",
        "(From 911 Center) 02/14/11 10:29 7 EVERGREEN LN BRUTUS Stroke",
        "DATE:02/14/11",
        "TIME:10:29",
        "ADDR:7 EVERGREEN LN",
        "CITY:BRUTUS",
        "CALL:Stroke");

    doTest("T5",
        "FRM:cayuga911@co.cayuga.ny.us\nSUBJ:From911Center\nMSG:\n04/20/11 13:51 3204 FRANKLIN STREET RD SENNETT Alarm - Fire\n",
        "DATE:04/20/11",
        "TIME:13:51",
        "ADDR:3204 FRANKLIN STREET RD",
        "CITY:SENNETT",
        "CALL:Alarm - Fire");

    doTest("T6",
        "(From 911 Center) 06/15/11 00:03 215 CAYUGA ST UNION SPRINGS Cardiac  Call Number 467 was created from Call Number 462(Jun 14 2011 11:20PM)  stried the pho",
        "DATE:06/15/11",
        "TIME:00:03",
        "ADDR:215 CAYUGA ST",
        "CITY:UNION SPRINGS",
        "CALL:Cardiac",
        "INFO:Call Number 467 was created from Call Number 462(Jun 14 2011 11:20PM)  stried the pho");
 }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "(From 911 Center) 08/27/11 02:10 RIVER RD RT 38 CONQUEST MVAPI  subject came into bar  bloody states car accident   pirates landing bar  mvapi   believes",
        "DATE:08/27/11",
        "TIME:02:10",
        "ADDR:RIVER RD & RT 38",
        "CIT" +
        "Y:CONQUEST",
        "CALL:MVAPI", 
        "INFO:subject came into bar  bloody states car accident  pirates landing bar  mvapi  believes");

    doTest("T2",
        "(From 911 Center) 08/27/11 00:42 HEJAMADA CAMPGROUND764 MC DONALD RD MONTEZUMA General Illness  mohawk section    off to left after gate  68 yo f   left a",
        "PLACE:HEJAMADA CAMPGROUND",
        "DATE:08/27/11",
        "TIME:00:42",
        "ADDR:764 MC DONALD RD",
        "CITY:MONTEZUMA",
        "CALL:General Illness",
        "INFO:mohawk section  off to left after gate  68 yo f  left a");

    doTest("T3",
        "(From 911 Center) 08/26/11 14:49 8860 S  WILLOW ST WEEDSPORT General Illness  60 Y/O FEMALE  CALLER STATES SHE NEEDS TO GO TO ST JOES PER HER DR... ABDOME",
        "DATE:08/26/11",
        "TIME:14:49",
        "ADDR:8860 S WILLOW ST",
        "CITY:WEEDSPORT",
        "CALL:General Illness",
        "INFO:60 Y/O FEMALE  CALLER STATES SHE NEEDS TO GO TO ST JOES PER HER DR... ABDOME");

    doTest("T4",
        "(From 911 Center) 08/26/11 09:59 8860 S  WILLOW ST WEEDSPORT Injury from a Fall  70 FEMALE FELL YESTERDAY/DIFF AMBULATING TODAY  E911 Info - Class of Serv",
        "DATE:08/26/11",
        "TIME:09:59",
        "ADDR:8860 S WILLOW ST",
        "CITY:WEEDSPORT",
        "CALL:Injury from a Fall",
        "INFO:70 FEMALE FELL YESTERDAY/DIFF AMBULATING TODAY  E911 Info - Class of Serv");

    doTest("T5",
        "(From 911 Center) 08/24/11 22:00 8750 CENTERPORT RD MENTZ Cardiac  79 Y/O FEMALE CHEST PAINS...  DERBY RESIDENCE",
        "DATE:08/24/11",
        "TIME:22:00",
        "ADDR:8750 CENTERPORT RD",
        "CITY:MENTZ",
        "CALL:Cardiac",
        "INFO:79 Y/O FEMALE CHEST PAINS...  DERBY RESIDENCE");
  }
  
  @Test
  public void testMikeClark() {

    doTest("T1",
        "FRM:messaging@iamresponding.com\nSUBJ:Owasco\nMSG:05/14/13 05:08 ONEIL RD BROADWAY RD OWASCO Structure Fire  POSS BARN FIRE",
        "DATE:05/14/13",
        "TIME:05:08",
        "ADDR:ONEIL RD & BROADWAY RD",
        "CITY:OWASCO",
        "CALL:Structure Fire",
        "INFO:POSS BARN FIRE");
    
  }
  
  @Test
  public void testSennettFire() {

    doTest("T1",
        "(From 911 Center) 04/29/13 03:32 3377 FRANKLIN STREET RD SENNETT Cardiac  HAD A HEART ATTACK 2 WEEKS AGO  61 YO FEMALE BURNING CHEST PAIN  E911 Info - Class of Service: RESD Special Response Info: CAY. CO. SHERIFF & NY ST POLICE SENNETT FD                      RURAL METRO AMBULANCE a ",
        "DATE:04/29/13",
        "TIME:03:32",
        "ADDR:3377 FRANKLIN STREET RD",
        "CITY:SENNETT",
        "CALL:Cardiac",
        "INFO:HAD A HEART ATTACK 2 WEEKS AGO  61 YO FEMALE BURNING CHEST PAIN  E911 Info - Class of Service: RESD Special Response Info: CAY. CO. SHERIFF & NY ST POLICE SENNETT FD  RURAL METRO AMBULANCE a");

    doTest("T2",
        "(From 911 Center) 04/28/13 12:06 WEST LAKE RD/HEN COOP RD ONONDAGA COUNTY Structure Fire ",
        "DATE:04/28/13",
        "TIME:12:06",
        "ADDR:WEST LAKE RD & HEN COOP RD",  // Google knows this as HENCOOP RD
        "CITY:ONONDAGA COUNTY",
        "CALL:Structure Fire");

    doTest("T3",
        "(From 911 Center) 04/27/13 09:27 3 ELSON LN/SKANEATLES ONONDAGA COUNTY Assist by Fire  STRUCTURE FIRE  OFF E LAKE RD  TANKER OUT OF SENNETT ",
        "DATE:04/27/13",
        "TIME:09:27",
        "ADDR:3 ELSON LN & SKANEATLES",
        "MADDR:3 ELSON LN",
        "CITY:ONONDAGA COUNTY",
        "CALL:Assist by Fire",
        "INFO:STRUCTURE FIRE  OFF E LAKE RD  TANKER OUT OF SENNETT");

    doTest("T4",
        "(From 911 Center) 04/26/13 12:55 2 JOHN SMITH AVE SENNETT Seizures  85 YO F SEIZURE ",
        "DATE:04/26/13",
        "TIME:12:55",
        "ADDR:2 JOHN SMITH AVE",
        "CITY:SENNETT",
        "CALL:Seizures",
        "INFO:85 YO F SEIZURE");

    doTest("T5",
        "(From 911 Center) 04/26/13 07:30 7581 PARCELL RD SENNETT Seizures  8 YO MALE ACTIVE SEIZURES ",
        "DATE:04/26/13",
        "TIME:07:30",
        "ADDR:7581 PARCELL RD",
        "CITY:SENNETT",
        "CALL:Seizures",
        "INFO:8 YO MALE ACTIVE SEIZURES");

    doTest("T6",
        "(From 911 Center) 04/25/13 19:34 2616 MANROW RD SENNETT Cardiac  85 YO F  WARM FEELING IN CHEST ",
        "DATE:04/25/13",
        "TIME:19:34",
        "ADDR:2616 MANROW RD",
        "CITY:SENNETT",
        "CALL:Cardiac",
        "INFO:85 YO F  WARM FEELING IN CHEST");

    doTest("T7",
        "(From 911 Center) 04/24/13 05:05 DILAJS7430 N  STREET RD SENNETT Bleeding  51 YO MALE  NOSE BLEED  ROOM 15 ",
        "PLACE:DILAJS",
        "DATE:04/24/13",
        "TIME:05:05",
        "ADDR:7430 N STREET RD",
        "CITY:SENNETT",
        "CALL:Bleeding",
        "INFO:51 YO MALE  NOSE BLEED  ROOM 15");

    doTest("T8",
        "(From 911 Center) 04/19/13 17:10 DEPOT RD FREEMAN RD SENNETT Hazard - Fire  EAST OF INTERSECTION  WIRE DOWN IN THE ROAD ",
        "DATE:04/19/13",
        "TIME:17:10",
        "ADDR:DEPOT RD & FREEMAN RD",
        "CITY:SENNETT",
        "CALL:Hazard - Fire",
        "INFO:EAST OF INTERSECTION  WIRE DOWN IN THE ROAD");

    doTest("T9",
        "(From 911 Center) 04/19/13 08:00 2 JOHN SMITH AVE SENNETT Seizures ",
        "DATE:04/19/13",
        "TIME:08:00",
        "ADDR:2 JOHN SMITH AVE",
        "CITY:SENNETT",
        "CALL:Seizures");

    doTest("T10",
        "(From 911 Center) 04/18/13 17:23 MILLER RD COUNTY LINE RD SENNETT Hazard - Fire  SORELLO RES AREA  TREE IS NOT IN ROAD BUT WIRES ARE  SOME WIRES DOWN AND PART OF A TREE  ACROSS FROM PETERS FARM  WEST ABOUT 500 FT ",
        "DATE:04/18/13",
        "TIME:17:23",
        "ADDR:MILLER RD & COUNTY LINE RD",
        "CITY:SENNETT",
        "CALL:Hazard - Fire",
        "INFO:SORELLO RES AREA  TREE IS NOT IN ROAD BUT WIRES ARE  SOME WIRES DOWN AND PART OF A TREE  ACROSS FROM PETERS FARM  WEST ABOUT 500 FT");

    doTest("T11",
        "(From 911 Center) 04/13/13 19:06 3377 FRANKLIN STREET RD SENNETT Cardiac  FRONT DOOR IS OPEN  FRENCH RESIDENCE  61 YO F CHEST PAINS ",
        "DATE:04/13/13",
        "TIME:19:06",
        "ADDR:3377 FRANKLIN STREET RD",
        "CITY:SENNETT",
        "CALL:Cardiac",
        "INFO:FRONT DOOR IS OPEN  FRENCH RESIDENCE  61 YO F CHEST PAINS");

    doTest("T12",
        "(From 911 Center) 04/12/13 20:41 7822 PARCELL RD SENNETT Difficulty Breathing/SOB  77 yo  m  E911 Info - Class of Service: RESD Special Response Info: CAY. CO. SHERIFF & NY ST POLICE SENNETT FD                      WEEDSPORT AMBULANCE ",
        "DATE:04/12/13",
        "TIME:20:41",
        "ADDR:7822 PARCELL RD",
        "CITY:SENNETT",
        "CALL:Difficulty Breathing/SOB",
        "INFO:77 yo  m  E911 Info - Class of Service: RESD Special Response Info: CAY. CO. SHERIFF & NY ST POLICE SENNETT FD  WEEDSPORT AMBULANCE");

    doTest("T13",
        "(From 911 Center) 04/10/13 14:58 ENTERPRISE RENTAL329 GRANT AVENUE RD SENNETT General Illness  80 MALE NOT FEELING  E911 Info - Class of Service: CNTX Special Response Info: CAY. CO. SHERIFF & NY ST POLICE SENNETT FD                      RURAL METRO AMBULANCE w ",
        "DATE:04/10/13",
        "TIME:14:58",
        "PLACE:ENTERPRISE RENTAL",
        "ADDR:329 GRANT AVENUE RD",
        "CITY:SENNETT",
        "CALL:General Illness",
        "INFO:80 MALE NOT FEELING  E911 Info - Class of Service: CNTX Special Response Info: CAY. CO. SHERIFF & NY ST POLICE SENNETT FD  RURAL METRO AMBULANCE w");

    doTest("T14",
        "(From 911 Center) 04/09/13 14:54 SHEPHERD RD WEEDSPORT SENNETT RD SENNETT MVAPI  motorcyle accident/2 people with injuries ",
        "DATE:04/09/13",
        "TIME:14:54",
        "ADDR:SHEPHERD RD & WEEDSPORT SENNETT RD",
        "CITY:SENNETT",
        "CALL:MVAPI",
        "INFO:motorcyle accident/2 people with injuries");

    doTest("T15",
        "(From 911 Center) 05/08/13 16:21 14 WESTLAKE ST, SKANEATELES ONONDAGA COUNTY Assist by Fire  CROSS WEST GENESEE ST (RT 20)  OVEN FIRE ----ONE ENGINE FROM SENNETT",
        "DATE:05/08/13",
        "TIME:16:21",
        "ADDR:14 WESTLAKE ST",
        "CITY:SKANEATELES",
        "CALL:Assist by Fire",
        "INFO:CROSS WEST GENESEE ST (RT 20)  OVEN FIRE ----ONE ENGINE FROM SENNETT");

    doTest("T16",
        "(From 911 Center) 05/07/13 21:15 7822 PARCELL RD SENNETT General Illness  78 Y/O MALE RUNNING A FEVER AND IS CONFUSED... JUST HAD LUNG SURGERY",
        "DATE:05/07/13",
        "TIME:21:15",
        "ADDR:7822 PARCELL RD",
        "CITY:SENNETT",
        "CALL:General Illness",
        "INFO:78 Y/O MALE RUNNING A FEVER AND IS CONFUSED... JUST HAD LUNG SURGERY");

    doTest("T17",
        "(From 911 Center) 05/09/13 10:25 E  GENESEE STREET RD SWAMP RD SENNETT Hazard - Fire  BETWEEN SWAMP RD AND BEECH RD, LOW HANGING WIRE STRUCK BY A TRUCK",
        "DATE:05/09/13",
        "TIME:10:25",
        "ADDR:E GENESEE STREET RD & SWAMP RD",
        "CITY:SENNETT",
        "CALL:Hazard - Fire",
        "X:SWAMP RD AND BEECH RD",
        "INFO:LOW HANGING WIRE STRUCK BY A TRUCK");

    doTest("T18",
        "(From 911 Center) 05/08/13 11:13 3636 E GENESEE STREET RD SENNETT Unconscious Person  46 y/o male passed out cold",
        "DATE:05/08/13",
        "TIME:11:13",
        "ADDR:3636 E GENESEE STREET RD",
        "CITY:SENNETT",
        "CALL:Unconscious Person",
        "INFO:46 y/o male passed out cold");

  }
  
  @Test
  public void testSennettFireDepartment2() {

    doTest("T1",
        "(From 911 Center) 6 PLAZA DR PANERA BREADSENNETT GRANT AVENUE RD, MUTTON HILL RD / DEAD END Alarm - Fire  OPER 30  DINING ROOM SMOKE DETECTOR AND POOL STATIONS FIRE ALARM  06/12/13 22:20 2013-00000142 UAS",
        "ADDR:6 PLAZA DR",
        "PLACE:PANERA BREAD",
        "CITY:SENNETT",
        "X:GRANT AVENUE RD, MUTTON HILL RD / DEAD END",
        "CALL:Alarm - Fire",
        "INFO:OPER 30  DINING ROOM SMOKE DETECTOR AND POOL STATIONS FIRE ALARM",
        "DATE:06/12/13",
        "TIME:22:20",
        "ID:2013-00000142",
        "NAME:UAS");

    doTest("T2",
        "(From 911 Center) 3184 FRANKLIN STREET SENNETT FRANKLIN ST / PINE RIDGE RD, CHESTNUT RIDGE RD General Illness  G  92 YO MALE ALTERED LOC AND SHAKIN  STRAUSS RES  E911 Info - Class of Service: VOIP Special Response Info: VOIP CALL                       QUERY CALLER FOR LOCATION       QUERY CALLER FOR CALLBK Uncertainty:  Confidence:  06/12/13 12:22 2013-00000141 EDMUNDS HELEN",
        "ADDR:3184 FRANKLIN STREET",
        "CITY:SENNETT",
        "X:FRANKLIN ST / PINE RIDGE RD, CHESTNUT RIDGE RD",
        "CALL:General Illness",
        "INFO:G  92 YO MALE ALTERED LOC AND SHAKIN  STRAUSS RES  E911 Info - Class of Service: VOIP Special Response Info: VOIP CALL  QUERY CALLER FOR LOCATION  QUERY CALLER FOR CALLBK",
        "DATE:06/12/13",
        "TIME:12:22",
        "ID:2013-00000141",
        "NAME:EDMUNDS HELEN");

    doTest("T3",
        "(From 911 Center) 7168 PARCELL RD SENNETT CALEMAD DR / CENTER STREET RD Difficulty Breathing/SOB  NO CHEST PAINS  REQUESTS NO LIGHTS OR SIREN ON APPROACH  82 YO MALE W/PAIN IN HIS LEFT ARM AND DIFF BREATHING  E911 Info - Class of Service: RESD Special Response Info: CAY. CO. SHERIFF & NY ST POLICE SENNETT FD                      S.A.V.E.S. AMBULANCE N Uncertainty:  Confidence:  06/12/13 07:40 2013-00000140 NASH ELIZABETH",
        "ADDR:7168 PARCELL RD",
        "CITY:SENNETT",
        "X:CALEMAD DR / CENTER STREET RD",
        "CALL:Difficulty Breathing/SOB",
        "INFO:NO CHEST PAINS  REQUESTS NO LIGHTS OR SIREN ON APPROACH  82 YO MALE W/PAIN IN HIS LEFT ARM AND DIFF BREATHING  E911 Info - Class of Service: RESD Special Response Info: CAY. CO. SHERIFF & NY ST POLICE SENNETT FD  S.A.V.E.S. AMBULANCE N",
        "DATE:06/12/13",
        "TIME:07:40",
        "ID:2013-00000140",
        "NAME:NASH ELIZABETH");

    doTest("T4",
        "(From 911 Center) TURNPIKE SENNETT Hazard - Fire  POWER LINES VERY LOW CAUSING A HAZARD  06/11/13 17:41 2013-00000139 SUNERLIS TAMMY",
        "ADDR:TURNPIKE",
        "CITY:SENNETT",
        "CALL:Hazard - Fire",
        "INFO:POWER LINES VERY LOW CAUSING A HAZARD",
        "DATE:06/11/13",
        "TIME:17:41",
        "ID:2013-00000139",
        "NAME:SUNERLIS TAMMY");
 
  }
  
  @Test
  public void testOwascoFireDept() {

    doTest("T1",
        "(From 911 Center) 5805 DUNNING FLEMING RIESTER RD, WILLOW BROOK RD / KOON RD Difficulty Breathing/SOB  to ach  89 female congestive heart failure  06/14/13 06:23 2013-00000130 johnson melissa",
        "ADDR:5805 DUNNING",
        "CITY:FLEMING",
        "X:RIESTER RD, WILLOW BROOK RD / KOON RD",
        "CALL:Difficulty Breathing/SOB",
        "INFO:to ach  89 female congestive heart failure",
        "DATE:06/14/13",
        "TIME:06:23",
        "ID:2013-00000130",
        "NAME:johnson melissa");

    doTest("T2",
        "(From 911 Center) 5886 LAKE FLEMING POPLAR COVE / BUCK POINT RD Pain - General  LEG PAIN  69 YO MALE  06/13/13 09:28 2013-00000129 TAMBURO SAMUEL",
        "ADDR:5886 LAKE",
        "CITY:FLEMING",
        "INFO:POPLAR COVE / BUCK POINT RD Pain - General  LEG PAIN  69 YO MALE",
        "DATE:06/13/13",
        "TIME:09:28",
        "ID:2013-00000129",
        "NAME:TAMBURO SAMUEL");

    doTest("T3",
        "(From 911 Center) 6 FIRE LANE 1B OWASCO ICFOWASCO E LAKE RD / LAKESHORE DR General Illness  Call Number 942 was created from Call Number 937(Jun 12 2013 10:36AM)  74 male with a mental issue was being violent to the staff is now calm.  They need transport to ACH for mental evaluation.  E911 Info - Class of Service: RESD Special Response Info: CAY. CO. SHERIFF & NY ST POLICE OWASCO FD                       OWASCO AMBULANCE T Uncertainty:  Confidence:  06/12/13 10:47 2013-00000206 Ball George",
        "ADDR:6 FIRE LANE",
        "APT:1B",
        "CITY:OWASCO",
        "X:ICFOWASCO E LAKE RD / LAKESHORE DR",
        "CALL:General Illness",
        "INFO:Call Number 942 was created from Call Number 937(Jun 12 2013 10:36AM)  74 male with a mental issue was being violent to the staff is now calm.  They need transport to ACH for mental evaluation.  E911 Info - Class of Service: RESD Special Response Info: CAY. CO. SHERIFF & NY ST POLICE OWASCO FD  OWASCO AMBULANCE T",
        "DATE:06/12/13",
        "TIME:10:47",
        "ID:2013-00000206",
        "NAME:Ball George");

    doTest("T4",
        "(From 911 Center) 341 POPLAR BEACH OWASCO DEAD END / E LAKE RD Cardiac  PAI  TOOK NITRO  86 YO M CHEST PAINS  LEADER RES  06/11/13 15:59 2013-00000205 LEADER JEAN",
        "ADDR:341 POPLAR BEACH",
        "CITY:OWASCO",
        "X:DEAD END / E LAKE RD",
        "CALL:Cardiac",
        "INFO:PAI  TOOK NITRO  86 YO M CHEST PAINS  LEADER RES",
        "DATE:06/11/13",
        "TIME:15:59",
        "ID:2013-00000205",
        "NAME:LEADER JEAN");

  }
  
  @Test
  public void testRichardRyan() {

    doTest("T1",
        "(From 911 Center) 13681 QUEENS FARMS STERLING FINTCHES CORNERS RD / RT 104 Allergic Reaction  HARDY RES  STATES ITS SWELLING  BIT BY BEE YESTERDAY  53 Y/O",
        "ADDR:13681 QUEENS FARMS",
        "CITY:STERLING",
        "X:FINTCHES CORNERS RD / RT 104",
        "CALL:Allergic Reaction",
        "INFO:HARDY RES  STATES ITS SWELLING  BIT BY BEE YESTERDAY  53 Y/O");

    doTest("T2",
        "(From 911 Center) 15369 MCINTYRE STERLING COOPER BLUFF RD / FIRE LANE 1 Injury from a Fall  #NEDINA  MCINTYRE RESIDENCE  87 YO MALE, FELL ON BATHROOM FLOO",
        "ADDR:15369 MCINTYRE",
        "CITY:STERLING",
        "X:COOPER BLUFF RD / FIRE LANE",
        "CALL:1 Injury from a Fall",
        "INFO:#NEDINA  MCINTYRE RESIDENCE  87 YO MALE, FELL ON BATHROOM FLOO");

    doTest("T3",
        "(From 911 Center) 13681 QUEENS FARMS STERLING FINTCHES CORNERS RD / RT 104 Allergic Reaction  HARDY RES  STATES ITS SWELLING  BIT BY BEE YESTERDAY  53 Y/O",
        "ADDR:13681 QUEENS FARMS",
        "CITY:STERLING",
        "X:FINTCHES CORNERS RD / RT 104",
        "CALL:Allergic Reaction",
        "INFO:HARDY RES  STATES ITS SWELLING  BIT BY BEE YESTERDAY  53 Y/O");

    doTest("T4",
        "(From 911 Center) 5355 SPRING GREEN RD Difficulty Breathing/SOB  TOWN OF BUTLER  BETWEEN  WOLCOTT RD AND DEIGL RD  71 MALE DIFFICULTY",
        "CALL:GENERAL ALERT",
        "PLACE:5355 SPRING GREEN RD Difficulty Breathing/SOB  TOWN OF BUTLER  BETWEEN  WOLCOTT RD AND DEIGL RD  71 MALE DIFFICULTY");

    doTest("T5",
        "(From 911 Center) 15385 FARDEN STERLING RENAISSANCE FESTSTERLING CENTER RD, MACNIEL RD / MCFARLAND RD, JENSVOLD RD Injury from a Fall  RIGHT OUTSIDE THE M",
        "ADDR:15385 FARDEN",
        "CITY:STERLING",
        "X:RENAISSANCE FESTSTERLING CENTER RD, MACNIEL RD / MCFARLAND RD, JENSVOLD RD",
        "CALL:Injury from a Fall",
        "INFO:RIGHT OUTSIDE THE M");

    doTest("T6",
        "(From 911 Center) 15385 FARDEN STERLING RENAISSANCE FESTSTERLING CENTER RD, MACNIEL RD / MCFARLAND RD, JENSVOLD RD Pain - General  ENTER THROUGH EMPLOYEE",
        "ADDR:15385 FARDEN",
        "CITY:STERLING",
        "X:RENAISSANCE FESTSTERLING CENTER RD, MACNIEL RD / MCFARLAND RD, JENSVOLD RD",
        "CALL:Pain - General",
        "INFO:ENTER THROUGH EMPLOYEE");

    doTest("T7",
        "(From 911 Center) 14280 ACRE STERLING VICTORY ST / LADUE RD, STERLING STATION RD Cardiac  72 Y/O FEMALE HAS AN INTERNAL DEFIB AND IT IS GOING OFF ... LOW",
        "ADDR:14280 ACRE",
        "CITY:STERLING",
        "X:VICTORY ST / LADUE RD, STERLING STATION RD",
        "CALL:Cardiac",
        "INFO:72 Y/O FEMALE HAS AN INTERNAL DEFIB AND IT IS GOING OFF ... LOW");

    doTest("T8",
        "(From 911 Center) 15385 FARDEN STERLING RENAISSANCE FESTSTERLING CENTER RD, MACNIEL RD / MCFARLAND RD, JENSVOLD RD Injury from a Fall  6 Y/O FELL FEMALE F",
        "ADDR:15385 FARDEN",
        "CITY:STERLING",
        "X:RENAISSANCE FESTSTERLING CENTER RD, MACNIEL RD / MCFARLAND RD, JENSVOLD RD",
        "CALL:Injury from a Fall",
        "INFO:6 Y/O FELL FEMALE F");

    doTest("T9",
        "(From 911 Center) 14948 BAY FAIR HAVEN SHADY SHORES / N HADCOCK DR Cardiac  TOOK ALL MEDS  JUST HAD COFFEE AND PBJ ON TOAST  HAS ALREADY CHEWED A BABY ASP",
        "ADDR:14948 BAY",
        "CITY:FAIR HAVEN",
        "INFO:SHADY SHORES / N HADCOCK DR Cardiac  TOOK ALL MEDS  JUST HAD COFFEE AND PBJ ON TOAST  HAS ALREADY CHEWED A BABY ASP");

    doTest("T10",
        "(From 911 Center) 624 4TH WILDWOOD CAMPGROUNDFAIR HAVEN CHURCH ST / CAYUGA ST Difficulty Breathing/SOB  64 YO FEMALE W/DIFF BREATHING  3RD SITE IN  08/11/",
        "CALL:GENERAL ALERT",
        "PLACE:624 4TH WILDWOOD CAMPGROUNDFAIR HAVEN CHURCH ST / CAYUGA ST Difficulty Breathing/SOB  64 YO FEMALE W/DIFF BREATHING  3RD SITE IN  08/11/");

    doTest("T11",
        "(From 911 Center) 14955 BAY STERLING UNKNOWN / SHADY SHORES Water Rescue  THEY ARE RIGHT AT THS SHORE  BOAT INFRONT OF SHADY SHORES CAMPGROUND ON LAKE ONT",
        "ADDR:14955 BAY",
        "CITY:STERLING",
        "INFO:UNKNOWN / SHADY SHORES Water Rescue  THEY ARE RIGHT AT THS SHORE  BOAT INFRONT OF SHADY SHORES CAMPGROUND ON LAKE ONT");

    doTest("T12",
        "(From 911 Center) 104A STERLING Hazard - Fire  POLE LEANING/WIRES DOWN ACROSS THE ROAD  08/09/13 04:42 2013-00000248 TAYLOR SKIP",
        "CALL:GENERAL ALERT",
        "PLACE:104A STERLING Hazard - Fire  POLE LEANING/WIRES DOWN ACROSS THE ROAD  08/09/13 04:42 2013-00000248 TAYLOR SKIP");

    doTest("T13",
        "(From 911 Center) 15576 FIRE LANE 1 STERLING FIRE LANE 1B / DEAD END Personal Injury  CCSO ON SCENE  41 F - CHECK OVER - WRIST INJ AFTER A DOMESTIC  Call",
        "ADDR:15576 FIRE LANE",
        "APT:1",
        "CITY:STERLING",
        "X:FIRE LANE",
        "CALL:1B / DEAD END Personal Injury",
        "INFO:CCSO ON SCENE  41 F - CHECK OVER - WRIST INJ AFTER A DOMESTIC  Call");

    doTest("T14",
        "(From 911 Center) 14932 HADCOCK FAIR HAVEN W BAY RD / S HADCOCK DR, PATTY RD Cardiac  GAVE HER 4 BABY ASPIRIN, HAD HER CHEW THEM AND SWALLOW  75 YO FEMALE",
        "ADDR:14932 HADCOCK",
        "CITY:FAIR HAVEN",
        "X:W BAY RD / S HADCOCK DR, PATTY RD",
        "CALL:Cardiac",
        "INFO:GAVE HER 4 BABY ASPIRIN, HAD HER CHEW THEM AND SWALLOW  75 YO FEMALE");

    doTest("T15",
        "(From 911 Center) 1168 104A STERLING STERLING STATION RD / TEACHOUT RD Stroke  82 YO FEMALE EXTREMELY LETHARGIC AND WEAK FOR THE LAST FEW DAYS  PRITCHARD",
        "ADDR:1168 104A",
        "CITY:STERLING",
        "X:STERLING STATION RD / TEACHOUT RD",
        "CALL:Stroke",
        "INFO:82 YO FEMALE EXTREMELY LETHARGIC AND WEAK FOR THE LAST FEW DAYS  PRITCHARD");

    doTest("T16",
        "(From 911 Center) 13716 MARTVILLE STERLING NICHOLS RD / RT 104 Pain - General  EMD  BELOW THE NAVAL  SURG WAS EARLIER TODAY  ACH  27 YO F EXTREME PAIN AFT ",
        "ADDR:13716 MARTVILLE",
        "CITY:STERLING",
        "X:NICHOLS RD / RT 104",
        "CALL:Pain - General",
        "INFO:EMD  BELOW THE NAVAL  SURG WAS EARLIER TODAY  ACH  27 YO F EXTREME PAIN AFT");

    doTest("T17",
        "(From 911 Center) 14404 FAIR HAVEN FAIR HAVEN MAIN ST / SIMMONS RD Alarm - Fire  OPER 25476  REF 25476  DEAN SMITH INC  SMOKE DETECTOR ACTIVATION  08/06/1",
        "ADDR:14404 FAIR HAVEN",
        "CITY:FAIR HAVEN",
        "X:MAIN ST / SIMMONS RD",
        "CALL:Alarm - Fire",
        "INFO:OPER 25476  REF 25476  DEAN SMITH INC  SMOKE DETECTOR ACTIVATION  08/06/1");

    doTest("T18",
        "(From 911 Center) 14985 STATE PARK FAIR HAVEN STATE PARKFAIR HAVEN DEAD END / 7TH ST General Illness  CHECK OUT 2 SUBJ  07/27/13 23:18 2013-00000218 GUARD",
        "ADDR:14985 STATE PARK",
        "CITY:FAIR HAVEN",
        "INFO:STATE PARKFAIR HAVEN DEAD END / 7TH ST General Illness  CHECK OUT 2 SUBJ",
        "DATE:07/27/13",
        "TIME:23:18",
        "ID:2013-00000218",
        "NAME:GUARD");
    
  }
  
  public static void main(String[] args) {
    new NYCayugaCountyParserTest().generateTests("T1");
  }
}