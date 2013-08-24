package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*

Jackson County, OH
Contact: Active911
Agency name: Jackson County EMS
Location: Jackson, OH, United States
Sender: alerts@jacksonems.com

(Dispatch Alert - part 1 of 1) RC:Stroke / CVA/570 W 1ST ST APT 213//15:35/69 yo female  seton square
(Dispatch Alert - part 1 of 1) RC:Fall/15954 SR 327//11:26/94 yo female  white house
(Dispatch Alert - part 1 of 1) RC:General Sickness/77 HIGH ST//10:45/31 yo female  low b.p.
(Dispatch Alert - part 1 of 1) RC:Psychiatric / Behavioral Emergency/316 E MAIN ST//02:34/right accross west bando / matthew dobbins  21/
(Dispatch Alert - part 1 of 1) RC:Psychiatric / Behavioral Emergency/529 CARR ST//18:04/patient is suicidal and needs to be evaluated
(Dispatch Alert - part 1 of 1) RC:Chest Pain/1000 VETERNS DRIVE//16:21/patient on second floor of adena clinic complaining of chest pains
(Dispatch Alert - part 1 of 1) RC:Poison / Ingestion / Overdose/2 EAST MOUND ST//14:29/19  yo female  green house
(Dispatch Alert - part 1 of 1) RC:General Sickness/110 TILLEY LN APT C//11:23/panic attack  69 yo female
(Dispatch Alert - part 1 of 1) RC:Breathing Problems/4 W BROADWAY ST//06:29/61 YO MALE. COPD.
(Dispatch Alert - part 1 of 1) RC:Unkown Problem/WISCONSIN AND C ST//09:28/75 yo male  3rd party call
(Dispatch Alert - part 1 of 1) RC:Diabetic Problems/994 ANTIOCH RD.//21:17/Long Driveway off Antioch.
(Dispatch Alert - part 1 of 1) RC:Breathing Problems/570 W 1ST/204/10:23/FEMALE/  71
(Dispatch Alert - part 1 of 1) RC:Fall/224 CROSS ST//09:03/hip pain 92 yr old female/
(Dispatch Alert - part 1 of 1) RC:Breathing Problems/215 SETH AVE/D6/18:40/66 MALE
(Dispatch Alert - part 1 of 1) RC:Unkown Problem/7 OILER AVE//17:07/medical alarm
(Dispatch Alert - part 1 of 1) RC:Patient In Pain/529 CARR ST//10:28/lobby  leg pain
(Dispatch Alert - part 1 of 1) RC:Area Coverage/RODEO HENDERSON ARENA//22:52/coverage at henderson arena for rodeo
(Dispatch Alert - part 1 of 1) RC:General Sickness/570 W 1ST ST APT 213//12:53/elderly female  high b.p.  seaton square
(Dispatch Alert - part 1 of 1) RC:General Sickness/4066 PATTONSVILLE//04:09/male/ 46 yr old male/
(Dispatch Alert - part 1 of 1) RC:Patient In Pain/215 SETH AVE/spring 6a/02:02/81 male / left shouler pain / post fall /
(Dispatch Alert - part 1 of 1) RC:Unresponsive/1674 KEYSTONE FURNACE RD.//21:43/from fall/ hit head.  green double wide on top of hill.
(Dispatch Alert - part 1 of 1) RC:Chest Pain/710 N PENN.   #19//17:23/numbness in legs/ dif breathing.   Previous heart history.
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/SR93//10:41/in front of mikes one stop
(Dispatch Alert - part 1 of 1) RC:Chest Pain/111 W. A. STREET//16:35/shortness of breath/  mobile home behind aerosal plant.
(Dispatch Alert - part 1 of 1) RC:Abdominal Pain/1076 BROHARD RD.//18:49/Across bridge/ beige trailer on left.  Next moible after dumpster.
(Dispatch Alert - part 1 of 1) RC:Patient In Pain/385 PLEASANT GROVE RD.//18:09/cedar house on left/ blue car in drive way.  Come in back door on deck.
(Dispatch Alert - part 1 of 1) RC:Unresponsive/118 LIMERICK RD.//17:39/corner of beaver pike & limerick rd.
(Dispatch Alert - part 1 of 1) RC:Unkown Problem/WALMART//13:45/managment called said someone fell in produce area
(Dispatch Alert - part 1 of 1) RC:Breathing Problems/140 POWELL DR//09:49/building e
(Dispatch Alert - part 1 of 1) RC:Cardiac Arrest/405 N PARK AVE//07:39/EDGEWOOD MANOR
(Dispatch Alert - part 1 of 1) RC:Respiratory Arrest/4335 CH&D RD.//21:14/8 y/o.  Sharp REsidence.
(Dispatch Alert - part 1 of 1) RC:Breathing Problems/412 N. MICHIGAN AVE.//16:40/5 y/o/ asthma/ wheezing.  Red house/  dead end.
(Dispatch Alert - part 1 of 1) RC:Fall/254 E MAIN ST APT 403//14:16/the cambrian
(Dispatch Alert - part 1 of 1) RC:Breathing Problems/1 POWELL DR//12:59/59 yo male
(Dispatch Alert - part 1 of 1) RC:General Sickness/138 E SECOND ST/302/02:02/38 male/ coughing
(Dispatch Alert - part 1 of 1) RC:Chest Pain/KROGERS IN WELLSTON//22:10/CHARLES SAMMUT / ON D ST  WALKING TOWARDS KROGERS/
(Dispatch Alert - part 1 of 1) RC:Diabetic Problems/2117 FINLEY CHAPLE RD//20:23/MALE/  PATIENT
(Dispatch Alert - part 1 of 1) RC:Bleeding/WPD//19:03/WPD BLEEDING
(Dispatch Alert - part 1 of 1) RC:Chest Pain/756 NORTH PENNSANIA AVE//14:16/& headaches
(Dispatch Alert - part 1 of 1) RC:Chest Pain/215 SETH AVE//00:21/C13A
(Dispatch Alert - part 1 of 1) RC:General Sickness/12745 SR 139//16:39/turn rt on sr 139 off us 32 1st driveway on lt.
(Dispatch Alert - part 1 of 1) RC:Fall/172 ANDERSON DR//15:16/red cedar  86 yo male
(Dispatch Alert - part 1 of 1) RC:Breathing Problems/24 S LONGWORTH ST//12:37/54 yo female  yellow house green shutters
(Dispatch Alert - part 1 of 1) RC:Abdominal Pain/320 N OHIO  AVE.//21:50/white/  garage home/  grey veh out front.
(Dispatch Alert - part 1 of 1) RC:Chest Pain/35 E CHURCH ST.//18:00/white mobile home/ maroon shutters/ Coalton.
(Dispatch Alert - part 1 of 1) RC:Unkown Problem/ATHENS ST//15:11/last brick house before the overpass
(Dispatch Alert - part 1 of 1) RC:General Sickness/349 E BROADWAY ST//11:01/beige house
(Dispatch Alert - part 1 of 1) RC:General Sickness/349 E BROADWAY ST//11:01/beige house
(Dispatch Alert - part 1 of 1) RC:General Sickness/349 E BROADWAY ST//09:43/73 yo male  beige house
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/US 35 AT PATTONSVILLE RD//08:53/semi with ejection
(Dispatch Alert - part 1 of 1) RC:General Sickness/3768 VEGA RD//07:18/NUMBNESS IN LEGS. UNABLE TO WALK. 008
(Dispatch Alert - part 1 of 1) RC:General Sickness/108E. 6TH STREET//23:39/pale/weak.
(Dispatch Alert - part 1 of 1) RC:Chest Pain/110 DRIVING PARK RD.//19:58/diff breathing/  someone can meet you.
(Dispatch Alert - part 1 of 1) RC:General Sickness/818 S RHODE ISLAND AVE//15:26/swelling of the hands
(Dispatch Alert - part 1 of 1) RC:Abdominal Pain/WELLSTON PRIDE MANOR APT 109//12:45/70 yo female
(Dispatch Alert - part 1 of 1) RC:Breathing Problems/142 JENKINS MEMORIAL RD//09:16/at the clinic
(Dispatch Alert - part 1 of 1) RC:Unkown Problem/HARDING AVE//08:27/harding ave near water
(Dispatch Alert - part 1 of 1) RC:Laceration/2483 VAN FOSSAN RD//15:16/pine ridge furniture
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/LIMERICK RD//13:02/rollover
(Dispatch Alert - part 1 of 1) RC:Breathing Problems/307 GARFIELD RD//11:41/64 yo male  tan house
(Dispatch Alert - part 1 of 1) RC:Breathing Problems/132 E 2ND ST APT B//11:36/49 yo female
(Dispatch Alert - part 1 of 1) RC:Unresponsive/483 CHILLICOTHE ST//07:13/UNITED METHODIST CHURCH
(Dispatch Alert - part 1 of 1) RC:General Sickness/249 WEST 13TH ST//15:45/twisted ankle
(Dispatch Alert - part 1 of 1) RC:Chest Pain/711 S CONN AVE//12:33/010
(Dispatch Alert - part 1 of 1) RC:Poison / Ingestion / Overdose/96 N. CHESTNUT/apt B/03:44/poss overdose
(Dispatch Alert - part 1 of 1) RC:Cardiac Arrest/3325 CAMBA RD//19:30/hanging.  jcso enroute.
(Dispatch Alert - part 1 of 1) RC:Seizures/211 S. DAVID AVE. #28//18:07/hickory II apts.
(Dispatch Alert - part 1 of 1) RC:Patient In Pain/6 ORCHARD LN//16:05/oney res/  pain/tingling in arms.  dizzy.
(Dispatch Alert - part 1 of 1) RC:Chest Pain/14395 SR 93//11:32/kings daughters family practice
(Dispatch Alert - part 1 of 1) RC:Chest Pain/423 E. 4TH ST.//20:35/corner of vermont and 4th St.
(Dispatch Alert - part 1 of 1) RC:Back Pain/EAST B STREET//11:23/FD PERSONEL
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/22059 SR 93//08:06/post mvc that happened near wellston startes guardrail.
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/8196 LIMERICK RD//01:42/DRIVER COMPLAINING OF BACK PAIN.
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/US 35 @ SOUR RUN RD//00:30/SINGLE VEHICLE MVA.
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/US 35 @ SOUR RUN RD//00:30/SINGLE VEHICLE MVA.
(Dispatch Alert - part 1 of 1) RC:Fall/172 ANDERSON DRIVE//23:35/corner of anderson dr & florence ave.  Red Cedar house.
(Dispatch Alert - part 1 of 1) RC:Breathing Problems/1000 VETERANS DR//11:21/adena  2nd floor
(Dispatch Alert - part 1 of 1) RC:Unresponsive/200 TAFT ST//05:54/008
(Dispatch Alert - part 1 of 1) RC:Heart Problems/3166 FIVE POINTS RD//22:52/hypertension.  1 mile south of 32.  mobile home/ 3 mail boxes at end of drive.
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/11542 ST. RTE 139//19:57/dark veh/ over guardrail.
(Dispatch Alert - part 1 of 1) RC:fainting/280 PATTONSVILLE RD//15:22/urgent care
(Dispatch Alert - part 1 of 1) RC:Fall/25 MOUND ST//10:59/hip pain  senior citizens center
(Dispatch Alert - part 1 of 1) RC:Unconscious/343 FRIDEMAKER RD//23:35/28 yr old female /
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/327 NORTH / 2 MILES//22:39/car is in creek /
(Dispatch Alert - part 1 of 1) RC:Unresponsive/125 LOCAS ST//11:22/female / 64 yrs old/

Contact: Active911
Agency name: Wellston Fire Department 
Location: Wellston, OH, United States
Sender: alerts@jacksonems.com

(Dispatch Alert - part 1 of 1) RC:Patient In Pain/212 WEST 9TH//15:49/shoulder injury 51 yr old male
(Dispatch Alert - part 1 of 1) RC:First Responder Call/512 CHEATWOOD RD//11:22/86 yo female
(Dispatch Alert - part 1 of 1) RC:Breathing Problems/570 W 1ST/204/10:23/FEMALE/  71
(Dispatch Alert - part 1 of 1) RC:Fire Alarm/103 DRIVING PARK RD//07:09/general fire alarm
(Dispatch Alert - part 1 of 1) RC:Fire Call/710 S NEW YORK AVE//06:49/HOUSE ON FIRE/ SMOKE SHOWING /
(Dispatch Alert - part 1 of 1) RC:Chest Pain/710 N PENN.   #19//17:23/numbness in legs/ dif breathing.   Previous heart history.
(Dispatch Alert - part 1 of 1) RC:First Responder Call/249 W 13TH ST APT 12//12:55/38 yo male
(Dispatch Alert - part 1 of 1) RC:Cardiac Arrest/405 N PARK AVE//07:39/EDGEWOOD MANOR
(Dispatch Alert - part 1 of 1) RC:Fire Alarm/103 DRIVING PARK RD//04:11/008
(Dispatch Alert - part 1 of 1) RC:Fire Alarm/BROADWAY /PENNSYLVANIA AVE//20:52/assist wpd jack knifed semi
(Dispatch Alert - part 1 of 1) RC:Fire Call/410 N WISCONSIN AVE.//16:53/service call for CO check
(Dispatch Alert - part 1 of 1) RC:Fire Call/101 EAST A ST//10:13/first national bank  fire alarm
(Dispatch Alert - part 1 of 1) RC:Fire Call/429 S MINNISOTA AVE//01:41/ODOR INVESTIGATION
(Dispatch Alert - part 1 of 1) RC:First Responder Call/132 E 2ND ST APT B//11:38/49 yo female
(Dispatch Alert - part 1 of 1) RC:Fire Standby/SUPERIOR HARDWOODS//21:24/at or near this place of business
(Dispatch Alert - part 1 of 1) RC:Chest Pain/401 WEST D STREET//16:43/squad coming from hmj er alerted first responders.
(Dispatch Alert - part 1 of 1) RC:Chest Pain/401 WEST D STREET//16:43/squad coming from hmj er alerted first responders.
(Dispatch Alert - part 1 of 1) RC:Fire Call/ST 1900//11:09/ANY AVAIL FIREFIGHTER RESPOND PER 1922
(Dispatch Alert - part 1 of 1) RC:Fire Call/30 S BROADWAY IN COALTON/1 //21:46/smoke in house / base board heaters/
(Dispatch Alert - part 1 of 1) RC:Brush Fire/UNION RIDGE OFF OF US RT 50//15:35/Mutual aid with Hamden Fired Dept/ request man power and brush truck
(Dispatch Alert - part 1 of 1) RC:Unconscious/423 E 4TH//17:11/female pt / / corner / white jeep and green car /
(Dispatch Alert - part 1 of 1) RC:Chest Pain/515 E 6TH ST//23:10/female
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/1003 W 2ND ST//03:46/VEHICLE VS POLE
(Dispatch Alert - part 1 of 1) RC:Vehicle Fire/S. PENN/  ACROSS FROM WENDY'S.//21:12/across from wendys
(Dispatch Alert - part 1 of 1) RC:Brush Fire/415 E SECOND ST//16:27/caller advised / grass fire
(Dispatch Alert - part 1 of 1) RC:Brush Fire/415 E SECOND ST//16:27/caller advised / grass fire
(Dispatch Alert - part 1 of 1) RC:Patient In Pain/266 S MICHIGAN AVE//12:41/needing assistance out of bed called in by st. 8
(Dispatch Alert - part 1 of 1) RC:First Responder Call/408 N MICHIGAN AVE//12:49/tan house  boat in front yard
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/11864 ST RT 327//17:56/ROLLOVER
(Dispatch Alert - part 1 of 1) RC:Fire Call/10 EAST C ST//10:53/alarm  and smelling smoke
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/327 NEAR 14333 ST RT 327//22:25/unknown entrapment
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/3088 FAIRGREENS RD.//20:58/car into a garage.
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/945 MULGA RD//00:01/008
(Dispatch Alert - part 1 of 1) RC:Fire Standby/2 S PENN//22:46/vehical
(Dispatch Alert - part 1 of 1) RC:Seizures/WPD//12:38/CALLED IN BY WPD PRISONER HAVING SEIZURES
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/N PENNSYLVANIA AVE//01:40/ACCROSS FROM DARROW INSURANCE..008
(Dispatch Alert - part 1 of 1) RC:First Responder Call/2151 MULGA RD//12:17/laying in the road
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/N. PENN AVE. / CITY LIMITS//19:33/fluid cleanup.  post MVC
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/SOUTH PENNSYLVANIA NEAR GENERAL MILLS//10:45/truck rollover
(Dispatch Alert - part 1 of 1) RC:Fire Call/109 NORTH MINNESOTA AVE//21:26/oven fire
(Dispatch Alert - part 1 of 1) RC:Fall/662 W BROADWAY//13:02/90 yr old female/ / / drive way is on second st / / look for male standing / out side
(Dispatch Alert - part 1 of 1) RC:Chest Pain/105 MITCHELL DRIVE.//23:09/36 y/o female/  beige house/ porch light will be on. . mitchell dr.
(Dispatch Alert - part 1 of 1) RC:Fire Call/200 GOLDEN ROCKET DR//15:10/trapped in an elevator
(Dispatch Alert - part 1 of 1) RC:Chest Pain/309 E. B  STREET.//18:20/white resident/ 4 from the WFD.
(Dispatch Alert - part 1 of 1) RC:Fall/1130 PENNSYLVANIA AVE//13:00/Head injury
(Dispatch Alert - part 1 of 1) RC:Unconscious/209 NORTH PARK AVE//10:46/pt is a diabetic
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/STATE RT 327 BEFORE GLEN ROY RD//04:49/rollover in creek
(Dispatch Alert - part 1 of 1) RC:Fire Call/WEST C STREET AND MICHIGAN AVE//23:00/Caller advised appeared to be a fire on the porch
(Dispatch Alert - part 1 of 1) RC:Unresponsive/JENKINS MEMORIAL/nursing home side 121/05:57/labored beathing /
(Dispatch Alert - part 1 of 1) RC:Fire Call/5576 ST RT 788//09:55/structure fire
(Dispatch Alert - part 1 of 1) RC:Fire Call/# 8 PIKE SUB STATION//03:34/CALLED IN BY WPD / CALLER ADVISED THE NATURAL GAS SUB STATION WAS ON FIRE/SPARKING
(Dispatch Alert - part 1 of 1) RC:Fire Call/645 S DELEWARE AVE//13:37/poss electrical short
(Dispatch Alert - part 1 of 1) RC:Fire Call/1130 S PENN//20:20/Esteps Gym / beside wendys
(Dispatch Alert - part 1 of 1) RC:Chest Pain/312 EAST A ST//14:24/63 yo female  white house
(Dispatch Alert - part 1 of 1) RC:Fall/218 NORTH VERMONT AVE//11:56/white house
(Dispatch Alert - part 1 of 1) RC:Fall/WELLSTON PRIDE MANNOR WEST BROADWAY//01:06/Door may be locked. 282
(Dispatch Alert - part 1 of 1) RC:Fire Call/1ST ST AND OHIO AVE//00:58/Transformer on FIRE
(Dispatch Alert - part 1 of 1) RC:Fire Call/13TH AND DRIVING PARK RD//14:19/oil spill
(Dispatch Alert - part 1 of 1) RC:Chest Pain/425 S MISSOURI AVE//21:57/008
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/W BROADWAY//20:31/ROLLOVER MVA
(Dispatch Alert - part 1 of 1) RC:General Sickness/80 TWLIGHT DR//11:20/62 yo female  tan house maroon shutters
(Dispatch Alert - part 1 of 1) RC:Fire Call/908 JOLLY RD//13:54/henry residence
(Dispatch Alert - part 1 of 1) RC:Fire Call/NEW YORK AVE TO MULGA RD//13:41/fuel on the road
(Dispatch Alert - part 1 of 1) RC:Fire Alarm/1183 KISOR RD//07:17/REF # 322-160-160
(Dispatch Alert - part 1 of 1) RC:Unresponsive/620 S MICHIGAN//00:19/female / pt /
(Dispatch Alert - part 1 of 1) RC:Fire Call/300 GRADY LN//19:58/tree across rd
(Dispatch Alert - part 1 of 1) RC:Stroke / CVA/WISCONSIN AND 2ND STREET//00:21/Called by wpd. Possible stroke
(Dispatch Alert - part 1 of 1) RC:Fire Standby/122 W 11TH ST//05:52/SMELL OF WIRES BURNING-
(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/SR 327//15:03/by the deer farm

Contact: Active911
Agency name: Scioto Township Fire Department
Location: Jackson, OH, United States
Sender: alerts@jacksonems.com 

(Dispatch Alert - part 1 of 1) RC:Fire Call/344 ALLEN RD//22:32/tree down on aep power line/ sparks are comming from power line has not caught fire yet/ caller mark jones adv he contacted aep
(Dispatch Alert - part 1 of 1) RC:Fire Call/SR139/RIEGEL RIDGE RD//06:22/FIRE LOCATED BEHIND FARM MACHINERY BUSINESS.

 */

public class OHJacksonCountyParserTest extends BaseParserTest {
  
  public OHJacksonCountyParserTest() {
    setParser(new OHJacksonCountyParser(), "JACKSON COUNTY", "OH");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "(Dispatch Alert - part 1 of 1) RC:Stroke / CVA/570 W 1ST ST APT 213//15:35/69 yo female  seton square",
        "CALL:Stroke / CVA",
        "ADDR:570 W 1ST ST",
        "APT:213",
        "TIME:15:35",
        "INFO:69 yo female  seton square");

    doTest("T2",
        "(Dispatch Alert - part 1 of 1) RC:Fall/15954 SR 327//11:26/94 yo female  white house",
        "CALL:Fall",
        "ADDR:15954 SR 327",
        "MADDR:15954 OH 327",
        "TIME:11:26",
        "INFO:94 yo female  white house");

    doTest("T3",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/77 HIGH ST//10:45/31 yo female  low b.p.",
        "CALL:General Sickness",
        "ADDR:77 HIGH ST",
        "TIME:10:45",
        "INFO:31 yo female  low b.p.");

    doTest("T4",
        "(Dispatch Alert - part 1 of 1) RC:Psychiatric / Behavioral Emergency/316 E MAIN ST//02:34/right accross west bando / matthew dobbins  21/",
        "CALL:Psychiatric / Behavioral Emergency",
        "ADDR:316 E MAIN ST",
        "TIME:02:34",
        "INFO:right accross west bando / matthew dobbins  21");

    doTest("T5",
        "(Dispatch Alert - part 1 of 1) RC:Psychiatric / Behavioral Emergency/529 CARR ST//18:04/patient is suicidal and needs to be evaluated",
        "CALL:Psychiatric / Behavioral Emergency",
        "ADDR:529 CARR ST",
        "TIME:18:04",
        "INFO:patient is suicidal and needs to be evaluated");

    doTest("T6",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/1000 VETERNS DRIVE//16:21/patient on second floor of adena clinic complaining of chest pains",
        "CALL:Chest Pain",
        "ADDR:1000 VETERNS DRIVE",
        "TIME:16:21",
        "INFO:patient on second floor of adena clinic complaining of chest pains");

    doTest("T7",
        "(Dispatch Alert - part 1 of 1) RC:Poison / Ingestion / Overdose/2 EAST MOUND ST//14:29/19  yo female  green house",
        "CALL:Poison / Ingestion / Overdose",
        "ADDR:2 EAST MOUND ST",
        "TIME:14:29",
        "INFO:19  yo female  green house");

    doTest("T8",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/110 TILLEY LN APT C//11:23/panic attack  69 yo female",
        "CALL:General Sickness",
        "ADDR:110 TILLEY LN",
        "APT:C",
        "TIME:11:23",
        "INFO:panic attack  69 yo female");

    doTest("T9",
        "(Dispatch Alert - part 1 of 1) RC:Breathing Problems/4 W BROADWAY ST//06:29/61 YO MALE. COPD.",
        "CALL:Breathing Problems",
        "ADDR:4 W BROADWAY ST",
        "TIME:06:29",
        "INFO:61 YO MALE. COPD.");

    doTest("T10",
        "(Dispatch Alert - part 1 of 1) RC:Unkown Problem/WISCONSIN AND C ST//09:28/75 yo male  3rd party call",
        "CALL:Unkown Problem",
        "ADDR:WISCONSIN AND C ST",
        "MADDR:WISCONSIN & C ST",
        "TIME:09:28",
        "INFO:75 yo male  3rd party call");

    doTest("T11",
        "(Dispatch Alert - part 1 of 1) RC:Diabetic Problems/994 ANTIOCH RD.//21:17/Long Driveway off Antioch.",
        "CALL:Diabetic Problems",
        "ADDR:994 ANTIOCH RD",
        "TIME:21:17",
        "INFO:Long Driveway off Antioch.");

    doTest("T12",
        "(Dispatch Alert - part 1 of 1) RC:Breathing Problems/570 W 1ST/204/10:23/FEMALE/  71",
        "CALL:Breathing Problems",
        "ADDR:570 W 1ST",
        "APT:204",
        "TIME:10:23",
        "INFO:FEMALE/  71");

    doTest("T13",
        "(Dispatch Alert - part 1 of 1) RC:Fall/224 CROSS ST//09:03/hip pain 92 yr old female/",
        "CALL:Fall",
        "ADDR:224 CROSS ST",
        "TIME:09:03",
        "INFO:hip pain 92 yr old female");

    doTest("T14",
        "(Dispatch Alert - part 1 of 1) RC:Breathing Problems/215 SETH AVE/D6/18:40/66 MALE",
        "CALL:Breathing Problems",
        "ADDR:215 SETH AVE",
        "APT:D6",
        "TIME:18:40",
        "INFO:66 MALE");

    doTest("T15",
        "(Dispatch Alert - part 1 of 1) RC:Unkown Problem/7 OILER AVE//17:07/medical alarm",
        "CALL:Unkown Problem",
        "ADDR:7 OILER AVE",
        "TIME:17:07",
        "INFO:medical alarm");

    doTest("T16",
        "(Dispatch Alert - part 1 of 1) RC:Patient In Pain/529 CARR ST//10:28/lobby  leg pain",
        "CALL:Patient In Pain",
        "ADDR:529 CARR ST",
        "TIME:10:28",
        "INFO:lobby  leg pain");

    doTest("T17",
        "(Dispatch Alert - part 1 of 1) RC:Area Coverage/RODEO HENDERSON ARENA//22:52/coverage at henderson arena for rodeo",
        "CALL:Area Coverage",
        "ADDR:RODEO HENDERSON ARENA",
        "TIME:22:52",
        "INFO:coverage at henderson arena for rodeo");

    doTest("T18",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/570 W 1ST ST APT 213//12:53/elderly female  high b.p.  seaton square",
        "CALL:General Sickness",
        "ADDR:570 W 1ST ST",
        "APT:213",
        "TIME:12:53",
        "INFO:elderly female  high b.p.  seaton square");

    doTest("T19",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/4066 PATTONSVILLE//04:09/male/ 46 yr old male/",
        "CALL:General Sickness",
        "ADDR:4066 PATTONSVILLE",
        "TIME:04:09",
        "INFO:male/ 46 yr old male");

    doTest("T20",
        "(Dispatch Alert - part 1 of 1) RC:Patient In Pain/215 SETH AVE/spring 6a/02:02/81 male / left shouler pain / post fall /",
        "CALL:Patient In Pain",
        "ADDR:215 SETH AVE",
        "APT:spring 6a",
        "TIME:02:02",
        "INFO:81 male / left shouler pain / post fall /");

    doTest("T21",
        "(Dispatch Alert - part 1 of 1) RC:Unresponsive/1674 KEYSTONE FURNACE RD.//21:43/from fall/ hit head.  green double wide on top of hill.",
        "CALL:Unresponsive",
        "ADDR:1674 KEYSTONE FURNACE RD",
        "TIME:21:43",
        "INFO:from fall/ hit head.  green double wide on top of hill.");

    doTest("T22",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/710 N PENN.   #19//17:23/numbness in legs/ dif breathing.   Previous heart history.",
        "CALL:Chest Pain",
        "ADDR:710 N PENN",
        "MADDR:710 N PENNSYLVANIA",
        "APT:19",
        "TIME:17:23",
        "INFO:numbness in legs/ dif breathing.   Previous heart history.");

    doTest("T23",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/SR93//10:41/in front of mikes one stop",
        "CALL:Motor Vehicle Collision",
        "ADDR:SR93",
        "MADDR:OH 93",
        "TIME:10:41",
        "INFO:in front of mikes one stop");

    doTest("T24",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/111 W. A. STREET//16:35/shortness of breath/  mobile home behind aerosal plant.",
        "CALL:Chest Pain",
        "ADDR:111 W A STREET",
        "TIME:16:35",
        "INFO:shortness of breath/  mobile home behind aerosal plant.");

    doTest("T25",
        "(Dispatch Alert - part 1 of 1) RC:Abdominal Pain/1076 BROHARD RD.//18:49/Across bridge/ beige trailer on left.  Next moible after dumpster.",
        "CALL:Abdominal Pain",
        "ADDR:1076 BROHARD RD",
        "TIME:18:49",
        "INFO:Across bridge/ beige trailer on left.  Next moible after dumpster.");

    doTest("T26",
        "(Dispatch Alert - part 1 of 1) RC:Patient In Pain/385 PLEASANT GROVE RD.//18:09/cedar house on left/ blue car in drive way.  Come in back door on deck.",
        "CALL:Patient In Pain",
        "ADDR:385 PLEASANT GROVE RD",
        "TIME:18:09",
        "INFO:cedar house on left/ blue car in drive way.  Come in back door on deck.");

    doTest("T27",
        "(Dispatch Alert - part 1 of 1) RC:Unresponsive/118 LIMERICK RD.//17:39/corner of beaver pike & limerick rd.",
        "CALL:Unresponsive",
        "ADDR:118 LIMERICK RD",
        "TIME:17:39",
        "INFO:corner of beaver pike & limerick rd.");

    doTest("T28",
        "(Dispatch Alert - part 1 of 1) RC:Unkown Problem/WALMART//13:45/managment called said someone fell in produce area",
        "CALL:Unkown Problem",
        "ADDR:WALMART",
        "TIME:13:45",
        "INFO:managment called said someone fell in produce area");

    doTest("T29",
        "(Dispatch Alert - part 1 of 1) RC:Breathing Problems/140 POWELL DR//09:49/building e",
        "CALL:Breathing Problems",
        "ADDR:140 POWELL DR",
        "TIME:09:49",
        "INFO:building e");

    doTest("T30",
        "(Dispatch Alert - part 1 of 1) RC:Cardiac Arrest/405 N PARK AVE//07:39/EDGEWOOD MANOR",
        "CALL:Cardiac Arrest",
        "ADDR:405 N PARK AVE",
        "TIME:07:39",
        "INFO:EDGEWOOD MANOR");

    doTest("T31",
        "(Dispatch Alert - part 1 of 1) RC:Respiratory Arrest/4335 CH&D RD.//21:14/8 y/o.  Sharp REsidence.",
        "CALL:Respiratory Arrest",
        "ADDR:4335 CH & D RD",
        "MADDR:4335 CH",
        "TIME:21:14",
        "INFO:8 y / o.  Sharp REsidence.");

    doTest("T32",
        "(Dispatch Alert - part 1 of 1) RC:Breathing Problems/412 N. MICHIGAN AVE.//16:40/5 y/o/ asthma/ wheezing.  Red house/  dead end.",
        "CALL:Breathing Problems",
        "ADDR:412 N MICHIGAN AVE",
        "TIME:16:40",
        "INFO:5 y / o/ asthma/ wheezing.  Red house/  dead end.");

    doTest("T33",
        "(Dispatch Alert - part 1 of 1) RC:Fall/254 E MAIN ST APT 403//14:16/the cambrian",
        "CALL:Fall",
        "ADDR:254 E MAIN ST",
        "APT:403",
        "TIME:14:16",
        "INFO:the cambrian");

    doTest("T34",
        "(Dispatch Alert - part 1 of 1) RC:Breathing Problems/1 POWELL DR//12:59/59 yo male",
        "CALL:Breathing Problems",
        "ADDR:1 POWELL DR",
        "TIME:12:59",
        "INFO:59 yo male");

    doTest("T35",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/138 E SECOND ST/302/02:02/38 male/ coughing",
        "CALL:General Sickness",
        "ADDR:138 E SECOND ST",
        "APT:302",
        "TIME:02:02",
        "INFO:38 male/ coughing");

    doTest("T36",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/KROGERS IN WELLSTON//22:10/CHARLES SAMMUT / ON D ST  WALKING TOWARDS KROGERS/",
        "CALL:Chest Pain",
        "ADDR:KROGERS IN WELLSTON",
        "TIME:22:10",
        "INFO:CHARLES SAMMUT / ON D ST  WALKING TOWARDS KROGERS");

    doTest("T37",
        "(Dispatch Alert - part 1 of 1) RC:Diabetic Problems/2117 FINLEY CHAPLE RD//20:23/MALE/  PATIENT",
        "CALL:Diabetic Problems",
        "ADDR:2117 FINLEY CHAPLE RD",
        "TIME:20:23",
        "INFO:MALE/  PATIENT");

    doTest("T38",
        "(Dispatch Alert - part 1 of 1) RC:Bleeding/WPD//19:03/WPD BLEEDING",
        "CALL:Bleeding",
        "ADDR:WPD",
        "TIME:19:03",
        "INFO:WPD BLEEDING");

    doTest("T39",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/756 NORTH PENNSANIA AVE//14:16/& headaches",
        "CALL:Chest Pain",
        "ADDR:756 NORTH PENNSANIA AVE",
        "TIME:14:16",
        "INFO:& headaches");

    doTest("T40",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/215 SETH AVE//00:21/C13A",
        "CALL:Chest Pain",
        "ADDR:215 SETH AVE",
        "TIME:00:21",
        "INFO:C13A");

    doTest("T41",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/12745 SR 139//16:39/turn rt on sr 139 off us 32 1st driveway on lt.",
        "CALL:General Sickness",
        "ADDR:12745 SR 139",
        "MADDR:12745 OH 139",
        "TIME:16:39",
        "INFO:turn rt on sr 139 off us 32 1st driveway on lt.");

    doTest("T42",
        "(Dispatch Alert - part 1 of 1) RC:Fall/172 ANDERSON DR//15:16/red cedar  86 yo male",
        "CALL:Fall",
        "ADDR:172 ANDERSON DR",
        "TIME:15:16",
        "INFO:red cedar  86 yo male");

    doTest("T43",
        "(Dispatch Alert - part 1 of 1) RC:Breathing Problems/24 S LONGWORTH ST//12:37/54 yo female  yellow house green shutters",
        "CALL:Breathing Problems",
        "ADDR:24 S LONGWORTH ST",
        "TIME:12:37",
        "INFO:54 yo female  yellow house green shutters");

    doTest("T44",
        "(Dispatch Alert - part 1 of 1) RC:Abdominal Pain/320 N OHIO  AVE.//21:50/white/  garage home/  grey veh out front.",
        "CALL:Abdominal Pain",
        "ADDR:320 N OHIO  AVE",
        "TIME:21:50",
        "INFO:white/  garage home/  grey veh out front.");

    doTest("T45",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/35 E CHURCH ST.//18:00/white mobile home/ maroon shutters/ Coalton.",
        "CALL:Chest Pain",
        "ADDR:35 E CHURCH ST",
        "TIME:18:00",
        "INFO:white mobile home/ maroon shutters/ Coalton.");

    doTest("T46",
        "(Dispatch Alert - part 1 of 1) RC:Unkown Problem/ATHENS ST//15:11/last brick house before the overpass",
        "CALL:Unkown Problem",
        "ADDR:ATHENS ST",
        "TIME:15:11",
        "INFO:last brick house before the overpass");

    doTest("T47",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/349 E BROADWAY ST//11:01/beige house",
        "CALL:General Sickness",
        "ADDR:349 E BROADWAY ST",
        "TIME:11:01",
        "INFO:beige house");

    doTest("T48",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/349 E BROADWAY ST//11:01/beige house",
        "CALL:General Sickness",
        "ADDR:349 E BROADWAY ST",
        "TIME:11:01",
        "INFO:beige house");

    doTest("T49",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/349 E BROADWAY ST//09:43/73 yo male  beige house",
        "CALL:General Sickness",
        "ADDR:349 E BROADWAY ST",
        "TIME:09:43",
        "INFO:73 yo male  beige house");

    doTest("T50",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/US 35 AT PATTONSVILLE RD//08:53/semi with ejection",
        "CALL:Motor Vehicle Collision",
        "ADDR:US 35 AT PATTONSVILLE RD",
        "TIME:08:53",
        "INFO:semi with ejection");

    doTest("T51",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/3768 VEGA RD//07:18/NUMBNESS IN LEGS. UNABLE TO WALK. 008",
        "CALL:General Sickness",
        "ADDR:3768 VEGA RD",
        "TIME:07:18",
        "INFO:NUMBNESS IN LEGS. UNABLE TO WALK. 008");

    doTest("T52",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/108E. 6TH STREET//23:39/pale/weak.",
        "CALL:General Sickness",
        "ADDR:108E 6TH STREET",
        "TIME:23:39",
        "INFO:pale / weak.");

    doTest("T53",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/110 DRIVING PARK RD.//19:58/diff breathing/  someone can meet you.",
        "CALL:Chest Pain",
        "ADDR:110 DRIVING PARK RD",
        "TIME:19:58",
        "INFO:diff breathing/  someone can meet you.");

    doTest("T54",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/818 S RHODE ISLAND AVE//15:26/swelling of the hands",
        "CALL:General Sickness",
        "ADDR:818 S RHODE ISLAND AVE",
        "TIME:15:26",
        "INFO:swelling of the hands");

    doTest("T55",
        "(Dispatch Alert - part 1 of 1) RC:Abdominal Pain/WELLSTON PRIDE MANOR APT 109//12:45/70 yo female",
        "CALL:Abdominal Pain",
        "ADDR:WELLSTON PRIDE MANOR",
        "APT:109",
        "TIME:12:45",
        "INFO:70 yo female");

    doTest("T56",
        "(Dispatch Alert - part 1 of 1) RC:Breathing Problems/142 JENKINS MEMORIAL RD//09:16/at the clinic",
        "CALL:Breathing Problems",
        "ADDR:142 JENKINS MEMORIAL RD",
        "TIME:09:16",
        "INFO:at the clinic");

    doTest("T57",
        "(Dispatch Alert - part 1 of 1) RC:Unkown Problem/HARDING AVE//08:27/harding ave near water",
        "CALL:Unkown Problem",
        "ADDR:HARDING AVE",
        "TIME:08:27",
        "INFO:harding ave near water");

    doTest("T58",
        "(Dispatch Alert - part 1 of 1) RC:Laceration/2483 VAN FOSSAN RD//15:16/pine ridge furniture",
        "CALL:Laceration",
        "ADDR:2483 VAN FOSSAN RD",
        "TIME:15:16",
        "INFO:pine ridge furniture");

    doTest("T59",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/LIMERICK RD//13:02/rollover",
        "CALL:Motor Vehicle Collision",
        "ADDR:LIMERICK RD",
        "TIME:13:02",
        "INFO:rollover");

    doTest("T60",
        "(Dispatch Alert - part 1 of 1) RC:Breathing Problems/307 GARFIELD RD//11:41/64 yo male  tan house",
        "CALL:Breathing Problems",
        "ADDR:307 GARFIELD RD",
        "TIME:11:41",
        "INFO:64 yo male  tan house");

    doTest("T61",
        "(Dispatch Alert - part 1 of 1) RC:Breathing Problems/132 E 2ND ST APT B//11:36/49 yo female",
        "CALL:Breathing Problems",
        "ADDR:132 E 2ND ST",
        "APT:B",
        "TIME:11:36",
        "INFO:49 yo female");

    doTest("T62",
        "(Dispatch Alert - part 1 of 1) RC:Unresponsive/483 CHILLICOTHE ST//07:13/UNITED METHODIST CHURCH",
        "CALL:Unresponsive",
        "ADDR:483 CHILLICOTHE ST",
        "TIME:07:13",
        "INFO:UNITED METHODIST CHURCH");

    doTest("T63",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/249 WEST 13TH ST//15:45/twisted ankle",
        "CALL:General Sickness",
        "ADDR:249 WEST 13TH ST",
        "TIME:15:45",
        "INFO:twisted ankle");

    doTest("T64",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/711 S CONN AVE//12:33/010",
        "CALL:Chest Pain",
        "ADDR:711 S CONN AVE",
        "TIME:12:33",
        "INFO:010");

    doTest("T65",
        "(Dispatch Alert - part 1 of 1) RC:Poison / Ingestion / Overdose/96 N. CHESTNUT/apt B/03:44/poss overdose",
        "CALL:Poison / Ingestion / Overdose",
        "ADDR:96 N CHESTNUT",
        "APT:apt B",
        "TIME:03:44",
        "INFO:poss overdose");

    doTest("T66",
        "(Dispatch Alert - part 1 of 1) RC:Cardiac Arrest/3325 CAMBA RD//19:30/hanging.  jcso enroute.",
        "CALL:Cardiac Arrest",
        "ADDR:3325 CAMBA RD",
        "TIME:19:30",
        "INFO:hanging.  jcso enroute.");

    doTest("T67",
        "(Dispatch Alert - part 1 of 1) RC:Seizures/211 S. DAVID AVE. #28//18:07/hickory II apts.",
        "CALL:Seizures",
        "ADDR:211 S DAVID AVE",
        "APT:28",
        "TIME:18:07",
        "INFO:hickory II apts.");

    doTest("T68",
        "(Dispatch Alert - part 1 of 1) RC:Patient In Pain/6 ORCHARD LN//16:05/oney res/  pain/tingling in arms.  dizzy.",
        "CALL:Patient In Pain",
        "ADDR:6 ORCHARD LN",
        "TIME:16:05",
        "INFO:oney res/  pain / tingling in arms.  dizzy.");

    doTest("T69",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/14395 SR 93//11:32/kings daughters family practice",
        "CALL:Chest Pain",
        "ADDR:14395 SR 93",
        "MADDR:14395 OH 93",
        "TIME:11:32",
        "INFO:kings daughters family practice");

    doTest("T70",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/423 E. 4TH ST.//20:35/corner of vermont and 4th St.",
        "CALL:Chest Pain",
        "ADDR:423 E 4TH ST",
        "TIME:20:35",
        "INFO:corner of vermont and 4th St.");

    doTest("T71",
        "(Dispatch Alert - part 1 of 1) RC:Back Pain/EAST B STREET//11:23/FD PERSONEL",
        "CALL:Back Pain",
        "ADDR:EAST B STREET",
        "TIME:11:23",
        "INFO:FD PERSONEL");

    doTest("T72",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/22059 SR 93//08:06/post mvc that happened near wellston startes guardrail.",
        "CALL:Motor Vehicle Collision",
        "ADDR:22059 SR 93",
        "MADDR:22059 OH 93",
        "TIME:08:06",
        "INFO:post mvc that happened near wellston startes guardrail.");

    doTest("T73",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/8196 LIMERICK RD//01:42/DRIVER COMPLAINING OF BACK PAIN.",
        "CALL:Motor Vehicle Accident",
        "ADDR:8196 LIMERICK RD",
        "TIME:01:42",
        "INFO:DRIVER COMPLAINING OF BACK PAIN.");

    doTest("T74",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/US 35 @ SOUR RUN RD//00:30/SINGLE VEHICLE MVA.",
        "CALL:Motor Vehicle Accident",
        "ADDR:US 35 @ SOUR RUN RD",
        "TIME:00:30",
        "INFO:SINGLE VEHICLE MVA.");

    doTest("T75",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/US 35 @ SOUR RUN RD//00:30/SINGLE VEHICLE MVA.",
        "CALL:Motor Vehicle Accident",
        "ADDR:US 35 @ SOUR RUN RD",
        "TIME:00:30",
        "INFO:SINGLE VEHICLE MVA.");

    doTest("T76",
        "(Dispatch Alert - part 1 of 1) RC:Fall/172 ANDERSON DRIVE//23:35/corner of anderson dr & florence ave.  Red Cedar house.",
        "CALL:Fall",
        "ADDR:172 ANDERSON DRIVE",
        "TIME:23:35",
        "INFO:corner of anderson dr & florence ave.  Red Cedar house.");

    doTest("T77",
        "(Dispatch Alert - part 1 of 1) RC:Breathing Problems/1000 VETERANS DR//11:21/adena  2nd floor",
        "CALL:Breathing Problems",
        "ADDR:1000 VETERANS DR",
        "TIME:11:21",
        "INFO:adena  2nd floor");

    doTest("T78",
        "(Dispatch Alert - part 1 of 1) RC:Unresponsive/200 TAFT ST//05:54/008",
        "CALL:Unresponsive",
        "ADDR:200 TAFT ST",
        "TIME:05:54",
        "INFO:008");

    doTest("T79",
        "(Dispatch Alert - part 1 of 1) RC:Heart Problems/3166 FIVE POINTS RD//22:52/hypertension.  1 mile south of 32.  mobile home/ 3 mail boxes at end of drive.",
        "CALL:Heart Problems",
        "ADDR:3166 FIVE POINTS RD",
        "TIME:22:52",
        "INFO:hypertension.  1 mile south of 32.  mobile home/ 3 mail boxes at end of drive.");

    doTest("T80",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/11542 ST. RTE 139//19:57/dark veh/ over guardrail.",
        "CALL:Motor Vehicle Collision",
        "ADDR:11542 ST RTE 139",
        "MADDR:11542 OH 139",
        "TIME:19:57",
        "INFO:dark veh/ over guardrail.");

    doTest("T81",
        "(Dispatch Alert - part 1 of 1) RC:fainting/280 PATTONSVILLE RD//15:22/urgent care",
        "CALL:fainting",
        "ADDR:280 PATTONSVILLE RD",
        "TIME:15:22",
        "INFO:urgent care");

    doTest("T82",
        "(Dispatch Alert - part 1 of 1) RC:Fall/25 MOUND ST//10:59/hip pain  senior citizens center",
        "CALL:Fall",
        "ADDR:25 MOUND ST",
        "TIME:10:59",
        "INFO:hip pain  senior citizens center");

    doTest("T83",
        "(Dispatch Alert - part 1 of 1) RC:Unconscious/343 FRIDEMAKER RD//23:35/28 yr old female /",
        "CALL:Unconscious",
        "ADDR:343 FRIDEMAKER RD",
        "TIME:23:35",
        "INFO:28 yr old female /");

    doTest("T84",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/327 NORTH / 2 MILES//22:39/car is in creek /",
        "CALL:Motor Vehicle Collision",
        "ADDR:327 NORTH & 2 MILES",
        "MADDR:327 NORTH",
        "TIME:22:39",
        "INFO:car is in creek /");

    doTest("T85",
        "(Dispatch Alert - part 1 of 1) RC:Unresponsive/125 LOCAS ST//11:22/female / 64 yrs old/",
        "CALL:Unresponsive",
        "ADDR:125 LOCAS ST",
        "TIME:11:22",
        "INFO:female / 64 yrs old");
  }
  
  @Test
  public void testWellston() {
             
    doTest("T1",
        "(Dispatch Alert - part 1 of 1) RC:Patient In Pain/212 WEST 9TH//15:49/shoulder injury 51 yr old male",
        "CALL:Patient In Pain",
        "ADDR:212 WEST 9TH",
        "TIME:15:49",
        "INFO:shoulder injury 51 yr old male");

    doTest("T2",
        "(Dispatch Alert - part 1 of 1) RC:First Responder Call/512 CHEATWOOD RD//11:22/86 yo female",
        "CALL:First Responder Call",
        "ADDR:512 CHEATWOOD RD",
        "TIME:11:22",
        "INFO:86 yo female");

    doTest("T3",
        "(Dispatch Alert - part 1 of 1) RC:Breathing Problems/570 W 1ST/204/10:23/FEMALE/  71",
        "CALL:Breathing Problems",
        "ADDR:570 W 1ST",
        "APT:204",
        "TIME:10:23",
        "INFO:FEMALE/  71");

    doTest("T4",
        "(Dispatch Alert - part 1 of 1) RC:Fire Alarm/103 DRIVING PARK RD//07:09/general fire alarm",
        "CALL:Fire Alarm",
        "ADDR:103 DRIVING PARK RD",
        "TIME:07:09",
        "INFO:general fire alarm");

    doTest("T5",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/710 S NEW YORK AVE//06:49/HOUSE ON FIRE/ SMOKE SHOWING /",
        "CALL:Fire Call",
        "ADDR:710 S NEW YORK AVE",
        "TIME:06:49",
        "INFO:HOUSE ON FIRE/ SMOKE SHOWING /");

    doTest("T6",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/710 N PENN.   #19//17:23/numbness in legs/ dif breathing.   Previous heart history.",
        "CALL:Chest Pain",
        "ADDR:710 N PENN",
        "MADDR:710 N PENNSYLVANIA",
        "APT:19",
        "TIME:17:23",
        "INFO:numbness in legs/ dif breathing.   Previous heart history.");

    doTest("T7",
        "(Dispatch Alert - part 1 of 1) RC:First Responder Call/249 W 13TH ST APT 12//12:55/38 yo male",
        "CALL:First Responder Call",
        "ADDR:249 W 13TH ST",
        "APT:12",
        "TIME:12:55",
        "INFO:38 yo male");

    doTest("T8",
        "(Dispatch Alert - part 1 of 1) RC:Cardiac Arrest/405 N PARK AVE//07:39/EDGEWOOD MANOR",
        "CALL:Cardiac Arrest",
        "ADDR:405 N PARK AVE",
        "TIME:07:39",
        "INFO:EDGEWOOD MANOR");

    doTest("T9",
        "(Dispatch Alert - part 1 of 1) RC:Fire Alarm/103 DRIVING PARK RD//04:11/008",
        "CALL:Fire Alarm",
        "ADDR:103 DRIVING PARK RD",
        "TIME:04:11",
        "INFO:008");

    doTest("T10",
        "(Dispatch Alert - part 1 of 1) RC:Fire Alarm/BROADWAY /PENNSYLVANIA AVE//20:52/assist wpd jack knifed semi",
        "CALL:Fire Alarm",
        "ADDR:BROADWAY & PENNSYLVANIA AVE",
        "TIME:20:52",
        "INFO:assist wpd jack knifed semi");

    doTest("T11",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/410 N WISCONSIN AVE.//16:53/service call for CO check",
        "CALL:Fire Call",
        "ADDR:410 N WISCONSIN AVE",
        "TIME:16:53",
        "INFO:service call for CO check");

    doTest("T12",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/101 EAST A ST//10:13/first national bank  fire alarm",
        "CALL:Fire Call",
        "ADDR:101 EAST A ST",
        "TIME:10:13",
        "INFO:first national bank  fire alarm");

    doTest("T13",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/429 S MINNISOTA AVE//01:41/ODOR INVESTIGATION",
        "CALL:Fire Call",
        "ADDR:429 S MINNISOTA AVE",
        "TIME:01:41",
        "INFO:ODOR INVESTIGATION");

    doTest("T14",
        "(Dispatch Alert - part 1 of 1) RC:First Responder Call/132 E 2ND ST APT B//11:38/49 yo female",
        "CALL:First Responder Call",
        "ADDR:132 E 2ND ST",
        "APT:B",
        "TIME:11:38",
        "INFO:49 yo female");

    doTest("T15",
        "(Dispatch Alert - part 1 of 1) RC:Fire Standby/SUPERIOR HARDWOODS//21:24/at or near this place of business",
        "CALL:Fire Standby",
        "ADDR:SUPERIOR HARDWOODS",
        "TIME:21:24",
        "INFO:at or near this place of business");

    doTest("T16",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/401 WEST D STREET//16:43/squad coming from hmj er alerted first responders.",
        "CALL:Chest Pain",
        "ADDR:401 WEST D STREET",
        "TIME:16:43",
        "INFO:squad coming from hmj er alerted first responders.");

    doTest("T17",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/401 WEST D STREET//16:43/squad coming from hmj er alerted first responders.",
        "CALL:Chest Pain",
        "ADDR:401 WEST D STREET",
        "TIME:16:43",
        "INFO:squad coming from hmj er alerted first responders.");

    doTest("T18",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/ST 1900//11:09/ANY AVAIL FIREFIGHTER RESPOND PER 1922",
        "CALL:Fire Call",
        "ADDR:ST 1900",
        "MADDR:OH 1900",
        "TIME:11:09",
        "INFO:ANY AVAIL FIREFIGHTER RESPOND PER 1922");

    doTest("T19",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/30 S BROADWAY IN COALTON/1 //21:46/smoke in house / base board heaters/",
        "CALL:Fire Call",
        "ADDR:30 S BROADWAY IN COALTON",
        "APT:1 /",
        "TIME:21:46",
        "INFO:smoke in house / base board heaters");

    doTest("T20",
        "(Dispatch Alert - part 1 of 1) RC:Brush Fire/UNION RIDGE OFF OF US RT 50//15:35/Mutual aid with Hamden Fired Dept/ request man power and brush truck",
        "CALL:Brush Fire",
        "ADDR:UNION RIDGE OFF OF US RT 50",
        "MADDR:UNION RIDGE & OF US 50",
        "TIME:15:35",
        "INFO:Mutual aid with Hamden Fired Dept/ request man power and brush truck");

    doTest("T21",
        "(Dispatch Alert - part 1 of 1) RC:Unconscious/423 E 4TH//17:11/female pt / / corner / white jeep and green car /",
        "CALL:Unconscious",
        "ADDR:423 E 4TH",
        "TIME:17:11",
        "INFO:female pt / / corner / white jeep and green car /");

    doTest("T22",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/515 E 6TH ST//23:10/female",
        "CALL:Chest Pain",
        "ADDR:515 E 6TH ST",
        "TIME:23:10",
        "INFO:female");

    doTest("T23",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/1003 W 2ND ST//03:46/VEHICLE VS POLE",
        "CALL:Motor Vehicle Accident",
        "ADDR:1003 W 2ND ST",
        "TIME:03:46",
        "INFO:VEHICLE VS POLE");

    doTest("T24",
        "(Dispatch Alert - part 1 of 1) RC:Vehicle Fire/S. PENN/  ACROSS FROM WENDY'S.//21:12/across from wendys",
        "CALL:Vehicle Fire",
        "ADDR:S PENN & ACROSS FROM WENDY'S",
        "MADDR:S PENNSYLVANIA & ACROSS FROM WENDY'S",
        "TIME:21:12",
        "INFO:across from wendys");

    doTest("T25",
        "(Dispatch Alert - part 1 of 1) RC:Brush Fire/415 E SECOND ST//16:27/caller advised / grass fire",
        "CALL:Brush Fire",
        "ADDR:415 E SECOND ST",
        "TIME:16:27",
        "INFO:caller advised / grass fire");

    doTest("T26",
        "(Dispatch Alert - part 1 of 1) RC:Brush Fire/415 E SECOND ST//16:27/caller advised / grass fire",
        "CALL:Brush Fire",
        "ADDR:415 E SECOND ST",
        "TIME:16:27",
        "INFO:caller advised / grass fire");

    doTest("T27",
        "(Dispatch Alert - part 1 of 1) RC:Patient In Pain/266 S MICHIGAN AVE//12:41/needing assistance out of bed called in by st. 8",
        "CALL:Patient In Pain",
        "ADDR:266 S MICHIGAN AVE",
        "TIME:12:41",
        "INFO:needing assistance out of bed called in by st. 8");

    doTest("T28",
        "(Dispatch Alert - part 1 of 1) RC:First Responder Call/408 N MICHIGAN AVE//12:49/tan house  boat in front yard",
        "CALL:First Responder Call",
        "ADDR:408 N MICHIGAN AVE",
        "TIME:12:49",
        "INFO:tan house  boat in front yard");

    doTest("T29",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/11864 ST RT 327//17:56/ROLLOVER",
        "CALL:Motor Vehicle Collision",
        "ADDR:11864 ST RT 327",
        "MADDR:11864 OH 327",
        "TIME:17:56",
        "INFO:ROLLOVER");

    doTest("T30",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/10 EAST C ST//10:53/alarm  and smelling smoke",
        "CALL:Fire Call",
        "ADDR:10 EAST C ST",
        "TIME:10:53",
        "INFO:alarm  and smelling smoke");

    doTest("T31",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/327 NEAR 14333 ST RT 327//22:25/unknown entrapment",
        "CALL:Motor Vehicle Collision",
        "ADDR:327 NEAR 14333 ST RT 327",
        "MADDR:327 & 14333 OH 327",
        "TIME:22:25",
        "INFO:unknown entrapment");

    doTest("T32",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/3088 FAIRGREENS RD.//20:58/car into a garage.",
        "CALL:Motor Vehicle Collision",
        "ADDR:3088 FAIRGREENS RD",
        "TIME:20:58",
        "INFO:car into a garage.");

    doTest("T33",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/945 MULGA RD//00:01/008",
        "CALL:Motor Vehicle Accident",
        "ADDR:945 MULGA RD",
        "TIME:00:01",
        "INFO:008");

    doTest("T34",
        "(Dispatch Alert - part 1 of 1) RC:Fire Standby/2 S PENN//22:46/vehical",
        "CALL:Fire Standby",
        "ADDR:2 S PENN",
        "MADDR:2 S PENNSYLVANIA",
        "TIME:22:46",
        "INFO:vehical");

    doTest("T35",
        "(Dispatch Alert - part 1 of 1) RC:Seizures/WPD//12:38/CALLED IN BY WPD PRISONER HAVING SEIZURES",
        "CALL:Seizures",
        "ADDR:WPD",
        "TIME:12:38",
        "INFO:CALLED IN BY WPD PRISONER HAVING SEIZURES");

    doTest("T36",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/N PENNSYLVANIA AVE//01:40/ACCROSS FROM DARROW INSURANCE..008",
        "CALL:Motor Vehicle Accident",
        "ADDR:N PENNSYLVANIA AVE",
        "TIME:01:40",
        "INFO:ACCROSS FROM DARROW INSURANCE..008");

    doTest("T37",
        "(Dispatch Alert - part 1 of 1) RC:First Responder Call/2151 MULGA RD//12:17/laying in the road",
        "CALL:First Responder Call",
        "ADDR:2151 MULGA RD",
        "TIME:12:17",
        "INFO:laying in the road");

    doTest("T38",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/N. PENN AVE. / CITY LIMITS//19:33/fluid cleanup.  post MVC",
        "CALL:Motor Vehicle Collision",
        "ADDR:N PENN AVE & CITY LIMITS",
        "MADDR:N PENNSYLVANIA AVE & CITY LIMITS",
        "TIME:19:33",
        "INFO:fluid cleanup.  post MVC");

    doTest("T39",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/SOUTH PENNSYLVANIA NEAR GENERAL MILLS//10:45/truck rollover",
        "CALL:Motor Vehicle Collision",
        "ADDR:SOUTH PENNSYLVANIA NEAR GENERAL MILLS",
        "MADDR:SOUTH PENNSYLVANIA & GENERAL MILLS",
        "TIME:10:45",
        "INFO:truck rollover");

    doTest("T40",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/109 NORTH MINNESOTA AVE//21:26/oven fire",
        "CALL:Fire Call",
        "ADDR:109 NORTH MINNESOTA AVE",
        "TIME:21:26",
        "INFO:oven fire");

    doTest("T41",
        "(Dispatch Alert - part 1 of 1) RC:Fall/662 W BROADWAY//13:02/90 yr old female/ / / drive way is on second st / / look for male standing / out side",
        "CALL:Fall",
        "ADDR:662 W BROADWAY",
        "TIME:13:02",
        "INFO:90 yr old female/ / / drive way is on second st / / look for male standing / out side");

    doTest("T42",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/105 MITCHELL DRIVE.//23:09/36 y/o female/  beige house/ porch light will be on. . mitchell dr.",
        "CALL:Chest Pain",
        "ADDR:105 MITCHELL DRIVE",
        "TIME:23:09",
        "INFO:36 y / o female/  beige house/ porch light will be on. . mitchell dr.");

    doTest("T43",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/200 GOLDEN ROCKET DR//15:10/trapped in an elevator",
        "CALL:Fire Call",
        "ADDR:200 GOLDEN ROCKET DR",
        "TIME:15:10",
        "INFO:trapped in an elevator");

    doTest("T44",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/309 E. B  STREET.//18:20/white resident/ 4 from the WFD.",
        "CALL:Chest Pain",
        "ADDR:309 E B  STREET",
        "TIME:18:20",
        "INFO:white resident/ 4 from the WFD.");

    doTest("T45",
        "(Dispatch Alert - part 1 of 1) RC:Fall/1130 PENNSYLVANIA AVE//13:00/Head injury",
        "CALL:Fall",
        "ADDR:1130 PENNSYLVANIA AVE",
        "TIME:13:00",
        "INFO:Head injury");

    doTest("T46",
        "(Dispatch Alert - part 1 of 1) RC:Unconscious/209 NORTH PARK AVE//10:46/pt is a diabetic",
        "CALL:Unconscious",
        "ADDR:209 NORTH PARK AVE",
        "TIME:10:46",
        "INFO:pt is a diabetic");

    doTest("T47",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/STATE RT 327 BEFORE GLEN ROY RD//04:49/rollover in creek",
        "CALL:Motor Vehicle Collision",
        "ADDR:STATE RT 327 BEFORE GLEN ROY RD",
        "MADDR:STATE 327 BEFORE GLEN ROY RD",
        "TIME:04:49",
        "INFO:rollover in creek");

    doTest("T48",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/WEST C STREET AND MICHIGAN AVE//23:00/Caller advised appeared to be a fire on the porch",
        "CALL:Fire Call",
        "ADDR:WEST C STREET AND MICHIGAN AVE",
        "MADDR:WEST C STREET & MICHIGAN AVE",
        "TIME:23:00",
        "INFO:Caller advised appeared to be a fire on the porch");

    doTest("T49",
        "(Dispatch Alert - part 1 of 1) RC:Unresponsive/JENKINS MEMORIAL/nursing home side 121/05:57/labored beathing /",
        "CALL:Unresponsive",
        "ADDR:JENKINS MEMORIAL",
        "APT:nursing home side 121",
        "TIME:05:57",
        "INFO:labored beathing /");

    doTest("T50",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/5576 ST RT 788//09:55/structure fire",
        "CALL:Fire Call",
        "ADDR:5576 ST RT 788",
        "MADDR:5576 OH 788",
        "TIME:09:55",
        "INFO:structure fire");

    doTest("T51",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/# 8 PIKE SUB STATION//03:34/CALLED IN BY WPD / CALLER ADVISED THE NATURAL GAS SUB STATION WAS ON FIRE/SPARKING",
        "CALL:Fire Call",
        "APT:8 PIKE SUB STATION",
        "TIME:03:34",
        "INFO:CALLED IN BY WPD / CALLER ADVISED THE NATURAL GAS SUB STATION WAS ON FIRE / SPARKING");

    doTest("T52",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/645 S DELEWARE AVE//13:37/poss electrical short",
        "CALL:Fire Call",
        "ADDR:645 S DELEWARE AVE",
        "TIME:13:37",
        "INFO:poss electrical short");

    doTest("T53",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/1130 S PENN//20:20/Esteps Gym / beside wendys",
        "CALL:Fire Call",
        "ADDR:1130 S PENN",
        "MADDR:1130 S PENNSYLVANIA",
        "TIME:20:20",
        "INFO:Esteps Gym / beside wendys");

    doTest("T54",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/312 EAST A ST//14:24/63 yo female  white house",
        "CALL:Chest Pain",
        "ADDR:312 EAST A ST",
        "TIME:14:24",
        "INFO:63 yo female  white house");

    doTest("T55",
        "(Dispatch Alert - part 1 of 1) RC:Fall/218 NORTH VERMONT AVE//11:56/white house",
        "CALL:Fall",
        "ADDR:218 NORTH VERMONT AVE",
        "TIME:11:56",
        "INFO:white house");

    doTest("T56",
        "(Dispatch Alert - part 1 of 1) RC:Fall/WELLSTON PRIDE MANNOR WEST BROADWAY//01:06/Door may be locked. 282",
        "CALL:Fall",
        "ADDR:WELLSTON PRIDE MANNOR WEST BROADWAY",
        "TIME:01:06",
        "INFO:Door may be locked. 282");

    doTest("T57",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/1ST ST AND OHIO AVE//00:58/Transformer on FIRE",
        "CALL:Fire Call",
        "ADDR:1ST ST AND OHIO AVE",
        "MADDR:1ST ST & OHIO AVE",
        "TIME:00:58",
        "INFO:Transformer on FIRE");

    doTest("T58",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/13TH AND DRIVING PARK RD//14:19/oil spill",
        "CALL:Fire Call",
        "ADDR:13TH AND DRIVING PARK RD",
        "MADDR:13TH & DRIVING PARK RD",
        "TIME:14:19",
        "INFO:oil spill");

    doTest("T59",
        "(Dispatch Alert - part 1 of 1) RC:Chest Pain/425 S MISSOURI AVE//21:57/008",
        "CALL:Chest Pain",
        "ADDR:425 S MISSOURI AVE",
        "TIME:21:57",
        "INFO:008");

    doTest("T60",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Accident/W BROADWAY//20:31/ROLLOVER MVA",
        "CALL:Motor Vehicle Accident",
        "ADDR:W BROADWAY",
        "TIME:20:31",
        "INFO:ROLLOVER MVA");

    doTest("T61",
        "(Dispatch Alert - part 1 of 1) RC:General Sickness/80 TWLIGHT DR//11:20/62 yo female  tan house maroon shutters",
        "CALL:General Sickness",
        "ADDR:80 TWLIGHT DR",
        "TIME:11:20",
        "INFO:62 yo female  tan house maroon shutters");

    doTest("T62",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/908 JOLLY RD//13:54/henry residence",
        "CALL:Fire Call",
        "ADDR:908 JOLLY RD",
        "TIME:13:54",
        "INFO:henry residence");

    doTest("T63",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/NEW YORK AVE TO MULGA RD//13:41/fuel on the road",
        "CALL:Fire Call",
        "ADDR:NEW YORK AVE TO MULGA RD",
        "TIME:13:41",
        "INFO:fuel on the road");

    doTest("T64",
        "(Dispatch Alert - part 1 of 1) RC:Fire Alarm/1183 KISOR RD//07:17/REF # 322-160-160",
        "CALL:Fire Alarm",
        "ADDR:1183 KISOR RD",
        "TIME:07:17",
        "INFO:REF # 322-160-160");

    doTest("T65",
        "(Dispatch Alert - part 1 of 1) RC:Unresponsive/620 S MICHIGAN//00:19/female / pt /",
        "CALL:Unresponsive",
        "ADDR:620 S MICHIGAN",
        "TIME:00:19",
        "INFO:female / pt /");

    doTest("T66",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/300 GRADY LN//19:58/tree across rd",
        "CALL:Fire Call",
        "ADDR:300 GRADY LN",
        "TIME:19:58",
        "INFO:tree across rd");

    doTest("T67",
        "(Dispatch Alert - part 1 of 1) RC:Stroke / CVA/WISCONSIN AND 2ND STREET//00:21/Called by wpd. Possible stroke",
        "CALL:Stroke / CVA",
        "ADDR:WISCONSIN AND 2ND STREET",
        "MADDR:WISCONSIN & 2ND STREET",
        "TIME:00:21",
        "INFO:Called by wpd. Possible stroke");

    doTest("T68",
        "(Dispatch Alert - part 1 of 1) RC:Fire Standby/122 W 11TH ST//05:52/SMELL OF WIRES BURNING-",
        "CALL:Fire Standby",
        "ADDR:122 W 11TH ST",
        "TIME:05:52",
        "INFO:SMELL OF WIRES BURNING-");

    doTest("T69",
        "(Dispatch Alert - part 1 of 1) RC:Motor Vehicle Collision/SR 327//15:03/by the deer farm",
        "CALL:Motor Vehicle Collision",
        "ADDR:SR 327",
        "MADDR:OH 327",
        "TIME:15:03",
        "INFO:by the deer farm");
    
  }
  
  @Test
  public void testScioto() {
    
    doTest("T1",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/344 ALLEN RD//22:32/tree down on aep power line/ sparks are comming from power line has not caught fire yet/ caller mark jones adv he contacted aep",
        "CALL:Fire Call",
        "ADDR:344 ALLEN RD",
        "TIME:22:32",
        "INFO:tree down on aep power line/ sparks are comming from power line has not caught fire yet/ caller mark jones adv he contacted aep");

    doTest("T2",
        "(Dispatch Alert - part 1 of 1) RC:Fire Call/SR139/RIEGEL RIDGE RD//06:22/FIRE LOCATED BEHIND FARM MACHINERY BUSINESS.",
        "CALL:Fire Call",
        "ADDR:SR139 & RIEGEL RIDGE RD",
        "MADDR:OH 139 & RIEGEL RIDGE RD",
        "TIME:06:22",
        "INFO:FIRE LOCATED BEHIND FARM MACHINERY BUSINESS.");
  
  }
  
  public static void main(String[] args) {
    new OHJacksonCountyParserTest().generateTests("T1");
  }
}