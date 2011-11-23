package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAYorkCountyBParserTest extends BaseParserTest {
  
  public PAYorkCountyBParserTest() {
    setParser(new PAYorkCountyBParser(), "YORK COUNTY", "PA");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "Rip and Run Report\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~~LEADER HEIGHTS~RD/~JOPPA~RD\nVenue:~YORK TWP\nCross Streets~\nQuadrant:~19-04\nDistrict:~19-04\n~\nCall Information:\n\nCall Number:~4326\nCall Type:~ DEBRIS REMOVAL\nSource:~DISPATCHED BY YORK COUNTY 911\nPriority:~ 4\nStatus:~IN PROGRESS\nAssigned To:~CALL TAKER 7\nCaller:~Starner,~Jeff\nCall Date/Time:~10/20/2011 22:55:13\nDispatch Date/Time:~10/20/2011 22:59:13\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2011-00001696~~GOODWILL FIRE COMPANY NO. 1 YORK TOWNSHIP\n2011-00025174~~YORK AREA REGIONAL POLICE DEPARTMENT\n~\nUnits Sent:~2\nFIRESTA19, 21-79~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/20/11 22:55:55~yes blocking\\\n10/20/11 22:56:06~yes smoking\n10/20/11 22:56:08~yes leaking\n10/20/11 22:56:17~silver Toyota\n10/20/11 22:56:42~gry car\n10/20/11 22:56:48~in the bank lot\n10/20/11 22:56:56~no overturned\n10/20/11 22:57:14~c/o saw this happen\n10/20/11 22:57:56~he was not ivolved though\n10/20/11 22:58:03~inv\n10/20/11 22:57:00~Call #: 4328 - 2 veh acc\n10/20/11 22:57:05~Call #: 4328 - blocking entire roadway\n10/20/11 22:57:14~Call #: 4328 - both vehs are sedans\n10/20/11 22:57:30~Call #: 4328 - no smoking\n10/20/11 22:57:38~Call #: 4328 - possible leaking\n10/20/11 22:58:37~he spoke to the people and they do not need EMS according to them\n10/20/11 22:59:54~Nature Of Call: Veh Leaking",
        "ADDR:LEADER HEIGHTS RD & JOPPA RD",
        "CITY:YORK TWP",
        "MAP:19-04",
        "ID:4326",
        "CALL:DEBRIS REMOVAL",
        "PRI:4",
        "NAME:Starner, Jeff",
        "DATE:10/20/2011",
        "TIME:22:55:13",
        "UNIT:FIRESTA19, 21-79",
        "INFO:yes blocking\\ / yes smoking / yes leaking / silver Toyota / gry car / in the bank lot / no overturned / c/o saw this happen / he was not ivolved though / inv / Call #: 4328 - 2 veh acc / Call #: 4328 - blocking entire roadway / Call #: 4328 - both vehs are sedans / Call #: 4328 - no smoking / Call #: 4328 - possible leaking / he spoke to the people and they do not need EMS according to them / Nature Of Call: Veh Leaking");

    doTest("T2",
        "Rip and Run Report\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~~LEADER HEIGHTS~RD/~PINE GROVE~RD\nVenue:~YORK TWP\nCross Streets~\nQuadrant:~19-04\nDistrict:~19-04\n~\nCall Information:\n\nCall Number:~8218\nCall Type:~ DEBRIS REMOVAL\nSource:~DISPATCHED BY YORK COUNTY 911\nPriority:~ 4\nStatus:~IN PROGRESS\nAssigned To:~BACK UP CALL TAKER 2\nCaller:~Winemiller,~Robert\nCall Date/Time:~10/24/2011 19:36:59\nDispatch Date/Time:~10/24/2011 19:40:19\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2011-00001705~~GOODWILL FIRE COMPANY NO. 1 YORK TOWNSHIP\n2011-00025487~~YORK AREA REGIONAL POLICE DEPARTMENT\n~\nUnits Sent:~2\nFIRESTA19, 21-81~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/24/11 19:38:09~no ot\n10/24/11 19:38:26~leaking fluids\n10/24/11 19:38:29~antifreeze\n10/24/11 19:38:45~no hazards\n10/24/11 19:39:10~both veh are blocking traffic\n10/24/11 19:39:19~in the middle of the intersection\n10/24/11 19:39:23~just occured\n10/24/11 19:39:43~veh 1: blue volzwagon passat\n10/24/11 19:39:50~veh 2: red dodge neon\n10/24/11 19:40:13~c/o has the blue veh\n10/24/11 19:40:32~Nature Of Call: fluids on roadway",
        "ADDR:LEADER HEIGHTS RD & PINE GROVE RD",
        "CITY:YORK TWP",
        "MAP:19-04",
        "ID:8218",
        "CALL:DEBRIS REMOVAL",
        "PRI:4",
        "NAME:Winemiller, Robert",
        "DATE:10/24/2011",
        "TIME:19:36:59",
        "UNIT:FIRESTA19, 21-81",
        "INFO:no ot / leaking fluids / antifreeze / no hazards / both veh are blocking traffic / in the middle of the intersection / just occured / veh 1: blue volzwagon passat / veh 2: red dodge neon / c/o has the blue veh / Nature Of Call: fluids on roadway");

    doTest("T3",
        "Rip and Run Report\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~2301~SPRINGWOOD~RD~\nVenue:~YORK TWP\nCross Streets~\nPAULINE DR / I 83 NB\nPhone:~(717) 741-2822\nQuadrant:~19-09\nDistrict:~19-09\n~\nCall Information:\n\nCall Number:~9986\nCall Type:~ FALLS CL 2\nSource:~DISPATCHED BY YORK COUNTY 911\nPriority:~ 4\nStatus:~IN PROGRESS\nAssigned To:~CALL TAKER 7\nCaller:~OnCall#Faith,~Acadian\nCall Date/Time:~10/26/2011 16:10:53\nDispatch Date/Time:~10/26/2011 16:14:53\nArrive Date/Time:~10/26/2011 16:19:44\nClear Date/Time:~\nEnroute Date/Time:~10/26/2011 16:17:09\nLatest Unit Cleared Date/Time:~10/26/2011 16:17:04\n~\nIncident Number(s)\n2011-00001710~~GOODWILL FIRE COMPANY NO. 1 YORK TOWNSHIP\n2011-00003105~~YOE FIRE CO AMBULANCE INC\n2011-00003067~~YOE FIRE COMPANY AMBULANCE SERVICE\n2011-00025631~~YORK AREA REGIONAL POLICE DEPARTMENT\n~\nUnits Sent:~5\nMICU19-2, MICU36-2, EMSSTA19, FIRESTA19, 21-89~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/26/11 16:12:49~Problem: fall-bleed from face.\\2sPatient Info: 1 patient(s); 91 Years old; Female; Conscious: Yes; Breathing: Yes;\n10/26/11 16:12:49~ProQA Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17B01; Response Text: Bravo\n10/26/11 16:12:56~no hosp preference\n10/26/11 16:13:16~lockbox on the side door-code for lock box is 2628 for key locatio\n10/26/11 16:13:27~Nature Of Call: 91 yof/\n10/26/11 16:13:35~ProQA Questionnaire Completed; Chief Complaint Number: 17; Dispatch Level: 17B01; Response Text: Bravo\n10/26/11 16:13:35~Problem: fall-bleed from face.\\2sPatient Info: 1 patient(s); 91 Years old; Female; Conscious: Yes; Breathing: Yes;\n10/26/11 16:13:37~Nature Of Call: 91 yof/unkn dest\n10/26/11 16:32:01~Nature Of Call: Non emergency for lift assist",
        "ADDR:2301 SPRINGWOOD RD",
        "CITY:YORK TWP",
        "X:PAULINE DR / I 83 NB",
        "MAP:19-09",
        "ID:9986",
        "CALL:FALLS CL 2",
        "PRI:4",
        "NAME:OnCall#Faith, Acadian",
        "DATE:10/26/2011",
        "TIME:16:10:53",
        "UNIT:MICU19-2, MICU36-2, EMSSTA19, FIRESTA19, 21-89",
        "INFO:Problem: fall-bleed from face.\\2sPatient Info: 1 patient(s); 91 Years old; Female; Conscious: Yes; Breathing: Yes; / ProQA Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17B01; Response Text: Bravo / no hosp preference / lockbox on the side door-code for lock box is 2628 for key locatio / Nature Of Call: 91 yof/ / ProQA Questionnaire Completed; Chief Complaint Number: 17; Dispatch Level: 17B01; Response Text: Bravo / Problem: fall-bleed from face.\\2sPatient Info: 1 patient(s); 91 Years old; Female; Conscious: Yes; Breathing: Yes; / Nature Of Call: 91 yof/unkn dest / Nature Of Call: Non emergency for lift assist");

    doTest("T4",
        "Rip and Run Report\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~3175~CAPE HORN~RD~\nVenue:~WINDSOR TWP\nCross Streets~\nLOMBARD RD / KIRKLAND DR\nPhone:~(717) 246-7137\nQuadrant:~36-403\nDistrict:~36-403\n~\nCall Information:\n\nCall Number:~381\nCall Type:~ FIRE AFA HIGH RISK\nSource:~DISPATCHED BY YORK COUNTY 911\nPriority:~ 4\nStatus:~IN PROGRESS\nAssigned To:~CALL TAKER 7\nCaller:~#218,~Giant\nCall Date/Time:~10/26/2011 23:15:42\nDispatch Date/Time:~10/26/2011 23:17:33\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2011-00001711~~GOODWILL FIRE COMPANY NO. 1 YORK TOWNSHIP\n2011-00001567~~LEO INDEPENDENT FIRE ENGINE COMPANY\n2011-00001510~~RESCUE FIRE COMPANY NO. 1\n2011-00001580~~YOE FIRE COMPANY\n~\nUnits Sent:~6\nFIRESTA36, T36, R36, E35-2, TK34, TK19~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/26/11 23:16:39~fire panel alarm\n10/26/11 23:16:44~no contact with premise\n10/26/11 23:16:47~will att to notify\n10/26/11 23:17:24~Nature Of Call: fire panel alarm",
        "ADDR:3175 CAPE HORN RD",
        "CITY:WINDSOR TWP",
        "X:LOMBARD RD / KIRKLAND DR",
        "MAP:36-403",
        "ID:381",
        "CALL:FIRE AFA HIGH RISK",
        "PRI:4",
        "NAME:#218, Giant",
        "DATE:10/26/2011",
        "TIME:23:15:42",
        "UNIT:FIRESTA36, T36, R36, E35-2, TK34, TK19",
        "INFO:fire panel alarm / no contact with premise / will att to notify / Nature Of Call: fire panel alarm");

    doTest("T5",
        "Rip and Run Report\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~859~E ~MAIN~ST~\nVenue:~YORK TWP\nCross Streets~\nW BROADWAY / HOLLY HILL DR\nQuadrant:~34-202\nDistrict:~34-202\n~\nCall Information:\n\nCall Number:~9871\nCall Type:~ FIRE STRUCT HR\nSource:~DISPATCHED BY YORK COUNTY 911\nPriority:~ 3\nStatus:~IN PROGRESS\nAssigned To:~CALL TAKER 4\nCaller:~Ottinger,~James\nCall Date/Time:~10/26/2011 14:18:58\nDispatch Date/Time:~10/26/2011 14:22:08\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2011-00001709~~GOODWILL FIRE COMPANY NO. 1 YORK TOWNSHIP\n2011-00001565~~LEO INDEPENDENT FIRE ENGINE COMPANY\n2011-00001509~~RESCUE FIRE COMPANY NO. 1\n2011-00001579~~YOE FIRE COMPANY\n~\nUnits Sent:~6\nFIRESTA34, T36, E35-2, TK34, E34, TK19~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/26/11 14:20:08~AutoZone\n10/26/11 14:20:15~gas leak inside\n10/26/11 14:21:25~buiding is evacuated\n10/26/11 14:21:55~columbia gas on location at this time requesting FD Response\n10/26/11 14:21:58~Nature Of Call: Gas Leak/ Building Evacuated\n10/26/11 14:22:00~caller works for autozone",
        "ADDR:859 E  MAIN ST",
        "CITY:YORK TWP",
        "X:W BROADWAY / HOLLY HILL DR",
        "MAP:34-202",
        "ID:9871",
        "CALL:FIRE STRUCT HR",
        "PRI:3",
        "NAME:Ottinger, James",
        "DATE:10/26/2011",
        "TIME:14:18:58",
        "UNIT:FIRESTA34, T36, E35-2, TK34, E34, TK19",
        "INFO:AutoZone / gas leak inside / buiding is evacuated / columbia gas on location at this time requesting FD Response / Nature Of Call: Gas Leak/ Building Evacuated / caller works for autozone");

    doTest("T6",
        "Rip and Run Report\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~150~FARM~LN~\nVenue:~YORK TWP\nCross Streets~\nCRESTVIEW DR / S QUEEN ST\nPhone:~(717) 846-7151\nQuadrant:~19-02\nDistrict:~19-02\n~\nCall Information:\n\nCall Number:~2717\nCall Type:~ FIRE AFA HIGH RISK\nSource:~DISPATCHED BY YORK COUNTY 911\nPriority:~ 4\nStatus:~IN PROGRESS\nAssigned To:~CALL TAKER 1\nCaller:~System,~Blazer,~Security\nCall Date/Time:~10/29/2011 08:39:44\nDispatch Date/Time:~10/29/2011 08:41:45\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2011-00001713~~GOODWILL FIRE COMPANY NO. 1 YORK TOWNSHIP\n~\nUnits Sent:~1\nFIRESTA19~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/29/11 08:40:17~Susquehanna Civil Incorporated is the company\n10/29/11 08:40:44~Operator Joyce\n10/29/11 08:40:54~1st fl smoke sensor\n10/29/11 08:40:57~unk structure\n10/29/11 08:41:11~c/o provided the company name\n10/29/11 08:41:39~Nature Of Call: 1st fl smoke sensor",
        "ADDR:150 FARM LN",
        "CITY:YORK TWP",
        "X:CRESTVIEW DR / S QUEEN ST",
        "MAP:19-02",
        "ID:2717",
        "CALL:FIRE AFA HIGH RISK",
        "PRI:4",
        "NAME:System, Blazer, Security",
        "DATE:10/29/2011",
        "TIME:08:39:44",
        "UNIT:FIRESTA19",
        "INFO:Susquehanna Civil Incorporated is the company / Operator Joyce / 1st fl smoke sensor / unk structure / c/o provided the company name / Nature Of Call: 1st fl smoke sensor");

    doTest("T7",
        "Rip and Run Report\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~348~BLUE RIDGE~DR~\nVenue:~YORK TWP\nCross Streets~\nRAINIER CT / RUSHMORE DR\nQuadrant:~19-03\nDistrict:~19-03\n~\nCall Information:\n\nCall Number:~2814\nCall Type:~ CARDIAC\\2sARREST CL 1\nSource:~DISPATCHED BY YORK COUNTY 911\nPriority:~ 2\nStatus:~IN PROGRESS\nAssigned To:~EMS 3 DISPATCHER\nCaller:~Hall,~Nancy\nCall Date/Time:~10/29/2011 10:33:33\nDispatch Date/Time:~10/29/2011 10:39:46\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2011-00001715~~GOODWILL FIRE COMPANY NO. 1 YORK TOWNSHIP\n2011-00001918~~JACOBUS LIONS CLUB AMBULANCE\n2011-00003084~~YOE FIRE COMPANY AMBULANCE SERVICE\n~\nUnits Sent:~3\nMICU18, EMSSTA19, FIRESTA19~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/29/11 10:34:34~74 yoa male collapsed on ground +conscious +breathing -alert\n10/29/11 10:35:14~breathing is abnormal\n10/29/11 10:35:18~chest feels rigid\n10/29/11 10:37:53~PROQA wll not fire\n10/29/11 10:38:02~CAD crashed during questioning\n10/29/11 10:38:52~c/o adv now no breathing and no pulse\n10/29/11 10:39:04~beginning CPR instructions\n10/29/11 10:39:06~PD REQING TO KNOW IF SOMEONE IS WITH PT\n10/29/11 10:39:27~DISREGARD\n10/29/11 10:39:42~Nature Of Call: 74 M / CPR started",
        "ADDR:348 BLUE RIDGE DR",
        "CITY:YORK TWP",
        "X:RAINIER CT / RUSHMORE DR",
        "MAP:19-03",
        "ID:2814",
        "CALL:CARDIAC\\2sARREST CL 1",
        "PRI:2",
        "NAME:Hall, Nancy",
        "DATE:10/29/2011",
        "TIME:10:33:33",
        "UNIT:MICU18, EMSSTA19, FIRESTA19",
        "INFO:74 yoa male collapsed on ground +conscious +breathing -alert / breathing is abnormal / chest feels rigid / PROQA wll not fire / CAD crashed during questioning / c/o adv now no breathing and no pulse / beginning CPR instructions / PD REQING TO KNOW IF SOMEONE IS WITH PT / DISREGARD / Nature Of Call: 74 M / CPR started");

    doTest("T8",
        "Rip and Run Report\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~~POWDER MILL~RD/~TYLER RUN~RD\nVenue:~YORK TWP\nCross Streets~\nQuadrant:~19-06\nDistrict:~19-06\n~\nCall Information:\n\nCall Number:~3517\nCall Type:~ FIRE POLICE\nSource:~DISPATCHED BY YORK COUNTY 911\nPriority:~ 4\nStatus:~IN PROGRESS\nAssigned To:~WEST 5\nCaller:~Ed,~Met\nCall Date/Time:~10/29/2011 14:32:44\nDispatch Date/Time:~10/29/2011 14:42:14\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2011-00001716~~GOODWILL FIRE COMPANY NO. 1 YORK TOWNSHIP\n~\nUnits Sent:~1\nFIRESTA19~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/29/11 14:33:28~c/o req to have the road barracaded due to tree's falling along Powder Mill Rd\n10/29/11 14:34:01~btwn Tyler Run and Powder Mill and also George/Manor\n10/29/11 14:42:08~Nature Of Call: shut down road for trees down",
        "ADDR:POWDER MILL RD & TYLER RUN RD",
        "CITY:YORK TWP",
        "MAP:19-06",
        "ID:3517",
        "CALL:FIRE POLICE",
        "PRI:4",
        "NAME:Ed, Met",
        "DATE:10/29/2011",
        "TIME:14:32:44",
        "UNIT:FIRESTA19",
        "INFO:c/o req to have the road barracaded due to tree's falling along Powder Mill Rd / btwn Tyler Run and Powder Mill and also George/Manor / Nature Of Call: shut down road for trees down");

    doTest("T9",
        "Rip and Run Report\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~~I~83~NB/~I~83X14LEADERHEIGHTS~NB\nVenue:~YORK TWP\nCross Streets~\nQuadrant:~19-833\nDistrict:~19-833\n~\nCall Information:\n\nCall Number:~4594\nCall Type:~ VEH ACC INJ CL 2\nSource:~DISPATCHED BY YORK COUNTY 911\nPriority:~ 2\nStatus:~IN PROGRESS\nAssigned To:~CALL TAKER 3\nCaller:~McAltin,~Rebecca\nCall Date/Time:~10/29/2011 18:13:37\nDispatch Date/Time:~10/29/2011 18:17:01\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2011-00001725~~GOODWILL FIRE COMPANY NO. 1 YORK TOWNSHIP\n2011-00001922~~JACOBUS LIONS CLUB AMBULANCE\n2011-00003091~~YOE FIRE COMPANY AMBULANCE SERVICE\n~\nUnits Sent:~5\nMICU18, MICU19-2, EMSSTA19, EMSSTA18, FIRESTA19~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/29/11 18:14:05~travelling SB\n10/29/11 18:14:34~Just north of the Leader Heights exit\n10/29/11 18:14:37~smoking\n10/29/11 18:15:47~off to side of road\n10/29/11 18:15:52~ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29B01; Response Text: Bravo\n10/29/11 18:15:52~Problem: vehicle accident.\\2sPatient Info: 1 patient(s); 36 Years old; Female; Conscious: Yes; Breathing: Yes;\n10/29/11 18:16:32~Nature Of Call: SB N of the exit/Veh smoking\n10/29/11 18:16:36~Problem: vehicle accident.\\2sPatient Info: 1 patient(s); 36 Years old; Female; Conscious: Yes; Breathing: Yes;\n10/29/11 18:16:36~ProQA Questionnaire Completed; Chief Complaint Number: 29; Dispatch Level: 29B01; Response Text: Bravo\n10/29/11 18:16:38~Nature Of Call: SB N of the exit/Veh smoking/36F/Cons\n10/29/11 18:16:53~veh Silver Dodge Caravan vs. dark SUV\n10/29/11 18:17:04~not blocking, Silver dodge on left side\n10/29/11 18:17:10~SUV on right side",
        "ADDR:I 83 NB & I 83X14LEADERHEIGHTS NB",
        "CITY:YORK TWP",
        "MAP:19-833",
        "ID:4594",
        "CALL:VEH ACC INJ CL 2",
        "PRI:2",
        "NAME:McAltin, Rebecca",
        "DATE:10/29/2011",
        "TIME:18:13:37",
        "UNIT:MICU18, MICU19-2, EMSSTA19, EMSSTA18, FIRESTA19",
        "INFO:travelling SB / Just north of the Leader Heights exit / smoking / off to side of road / ProQA Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29B01; Response Text: Bravo / Problem: vehicle accident.\\2sPatient Info: 1 patient(s); 36 Years old; Female; Conscious: Yes; Breathing: Yes; / Nature Of Call: SB N of the exit/Veh smoking / Problem: vehicle accident.\\2sPatient Info: 1 patient(s); 36 Years old; Female; Conscious: Yes; Breathing: Yes; / ProQA Questionnaire Completed; Chief Complaint Number: 29; Dispatch Level: 29B01; Response Text: Bravo / Nature Of Call: SB N of the exit/Veh smoking/36F/Cons / veh Silver Dodge Caravan vs. dark SUV / not blocking, Silver dodge on left side / SUV on right side");

    doTest("T10",
        "Rip and Run Report\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~1900~WOODLAND~DR~\nVenue:~YORK TWP\nCross Streets~\nDEAD END / RIDGEWOOD RD\nHILLCREST RD\nWATERS RD\nQuadrant:~19-06\nDistrict:~19-06\n~\nCall Information:\n\nCall Number:~4713\nCall Type:~ FIRE MISC\nSource:~DISPATCHED BY YORK COUNTY 911\nPriority:~ 4\nStatus:~IN PROGRESS\nAssigned To:~CALL TAKER 5\nCaller:~Martini,~Jack\nCall Date/Time:~10/29/2011 18:59:43\nDispatch Date/Time:~10/29/2011 19:03:50\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2011-00001727~~GOODWILL FIRE COMPANY NO. 1 YORK TOWNSHIP\n~\nUnits Sent:~1\nFIRESTA19~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/29/11 19:01:26~c/o wants someone check on son because there is no electricity and adv they are not able to leave the home due to tree fell across the door\n10/29/11 19:01:46~home is right by Channel 43\n10/29/11 19:02:45~no one is inj\n10/29/11 19:02:53~c/o wants someone to assist them in getting out of the home\n10/29/11 19:03:14~c/o was not able to vfy the municipality\n10/29/11 19:03:45~Nature Of Call: Tree down across Porch/can not get of house",
        "ADDR:1900 WOODLAND DR",
        "CITY:YORK TWP",
        "X:DEAD END / RIDGEWOOD RD",
        "MAP:19-06",
        "ID:4713",
        "CALL:FIRE MISC",
        "PRI:4",
        "NAME:Martini, Jack",
        "DATE:10/29/2011",
        "TIME:18:59:43",
        "UNIT:FIRESTA19",
        "INFO:c/o wants someone check on son because there is no electricity and adv they are not able to leave the home due to tree fell across the door / home is right by Channel 43 / no one is inj / c/o wants someone to assist them in getting out of the home / c/o was not able to vfy the municipality / Nature Of Call: Tree down across Porch/can not get of house");

    doTest("T11",
        "Rip and Run Report\nRip and Run Report\n\n~\nLocation Information:\n\nLocation:~1450~BEE TREE~RD~\nVenue:~SP GARDEN TWP\nCross Streets~\nHIGHLAND TER / SUMMIT TER\nQuadrant:~89-205\nDistrict:~89-205\n~\nCall Information:\n\nCall Number:~4892\nCall Type:~ FIRE WIRES\nSource:~DISPATCHED BY YORK COUNTY 911\nPriority:~ 4\nStatus:~IN PROGRESS\nAssigned To:~CALL TAKER 5\nCaller:~Robinson,~John\nCall Date/Time:~10/29/2011 20:27:54\nDispatch Date/Time:~10/29/2011 20:32:12\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2011-00001730~~GOODWILL FIRE COMPANY NO. 1 YORK TOWNSHIP\n2011-00003667~~YORK AREA UNITED FIRE AND RESCUE\n~\nUnits Sent:~2\nFIRESTA892, E19~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n10/29/11 20:28:39~c/o adv that they have wires sparking in the front yard\n10/29/11 20:28:45~not threatening home but near tree branches\n10/29/11 20:28:50~c/o does not have power\n10/29/11 20:28:59~do not see flames\n10/29/11 20:29:22~wires are not down, they are sparking in the air\n10/29/11 20:31:20~Nature Of Call: odor of gas outside\n10/29/11 20:32:05~Nature Of Call: wires sparking",
        "ADDR:1450 BEE TREE RD",
        "CITY:SPRING GARDEN TWP",
        "X:HIGHLAND TER / SUMMIT TER",
        "MAP:89-205",
        "ID:4892",
        "CALL:FIRE WIRES",
        "PRI:4",
        "NAME:Robinson, John",
        "DATE:10/29/2011",
        "TIME:20:27:54",
        "UNIT:FIRESTA892, E19",
        "INFO:c/o adv that they have wires sparking in the front yard / not threatening home but near tree branches / c/o does not have power / do not see flames / wires are not down, they are sparking in the air / Nature Of Call: odor of gas outside / Nature Of Call: wires sparking");

  }
  
  public static void main(String[] args) {
    new PAYorkCountyBParserTest().generateTests("T1");
  }
}
