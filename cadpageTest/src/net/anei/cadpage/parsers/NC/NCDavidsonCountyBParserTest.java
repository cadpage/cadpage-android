package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/***
Davidson County, NC
Contact: Active911
Agency name: DCEMS Base 1
Location: Lexington, NC, United States
Sender: Terry.Bailey@DavidsonCountyNC.gov

(Clear Report Incident #2012231406) Communications\r\nUser: RIPTSRV\r\n10/29/12 22:38:53\r\nEvent Report\r\nEvent ID:\r\n2012â€‘231406\r\nCall Ref #:\r\n457\r\nDate/Time Received:\r\n10/29/12 20:50:48\r\nService:\r\nRpt #:\r\n2012â€‘018630\r\nCall Source:\r\nPHONE\r\nPrime\r\n Unit:\r\nM11\r\n Services Involved\r\nEMS\r\nLocation:\r\nXâ€‘ST:\r\n250 HOSPITAL DR\r\nW MEDICAL PARK DR\r\nICU 641\r\nJur:\r\nAgency:\r\nSt/Beat:\r\nDistrict:\r\nRA:\r\nBusiness:\r\nPhone:\r\nNature:\r\nAlarm Lvl:\r\nPriority:\r\nCaller:\r\nAddr:\r\nPhone:\r\nAlarm:\r\nAlarm Type:\r\nVehicle #:\r\nDC\r\nEMS\r\nEMS\r\nB1\r\nB1\r\nLMC LEXINGTON MEDICAL\r\n(336) 248â€‘5161\r\nP33Aâ€‘TRANSFER/INTERFACâ€‘AL\r\n1\r\n3\r\nMedical Priority:\r\nJOSH\r\n250 HOSPITAL DR\r\n(   )    â€‘\r\nSt:\r\nReport Only:\r\nNo\r\nGOING TO NCBH CCU BED 4, IV, O2, MONITOR  [10/29/12 20:52:14 JCOX]\r\nNotes:\r\n10/29/12 20:50:48\r\nTimes\r\nCall Received:\r\n10/29/12 20:52:37\r\nCall Routed:\r\n10/29/12 20:52:37\r\nCall Take Finished:\r\n10/29/12 20:55:17\r\n1st Dispatch:\r\n10/29/12 20:56:53\r\n1st Enâ€‘Route:\r\n10/29/12 21:06:37\r\n1st Arrive:\r\n10/29/12 22:38:51\r\nLast Clear:\r\nTime From Call Received\r\n000:01:49\r\n000:01:49\r\n000:04:29\r\n000:06:05\r\n000:15:49\r\n001:48:03\r\nUnit Reaction:\r\nEnâ€‘Route:\r\nOnâ€‘Scene:\r\n000:11:20\r\n(1st Dispatch to 1st Arrive)\r\n000:01:36\r\n001:32:14\r\n(1st Dispatch to 1st Enâ€‘Route)\r\n(1st Arrive to Last Clear)\r\n(Time Held)\r\n(Reaction Time)\r\nGeoâ€‘Verified Addr.:\r\nYes\r\nNature Summary Code:\r\nDisposition:\r\nClose Comments:\r\nT\r\nRace:\r\nSex:\r\nAge:\r\n:\r\nJCOX\r\nCall Taker:\r\nCAD3\r\nConsole:\r\n1686\r\nGP:\r\nUnit\r\nType\r\nDescription\r\nTime Stamp\r\nComments\r\nClose\r\nCode\r\nUser\r\nRadio Log\r\nEmpl ID\r\nM11\r\nD\r\nDispatched\r\n10/29/12 20:55:17\r\nStat/Beat: B1\r\nJREYNOL\r\n0\r\nM11\r\nE\r\nEnâ€‘Route\r\n10/29/12 20:56:53\r\nJREYNOL\r\n0\r\nM11\r\nA\r\nArrived\r\n10/29/12 21:06:37\r\nJREYNOL\r\n0\r\nM11\r\nT\r\nTransport\r\n10/29/12 21:24:11\r\nTo: RT/NCBH\r\nJREYNOL\r\n0\r\nM11\r\nH\r\nAt Hospital\r\n10/29/12 21:48:41\r\nJREYNOL\r\n0\r\nM11\r\nR\r\nReturn to Qtr\r\n10/29/12 22:13:22\r\nJGRUBB\r\n0\r\nM11\r\nC\r\nCleared\r\n10/29/12 22:38:51\r\nT\r\nJREYNOL\r\nT\r\n0\r\nPage 1\r\nEvent ID:\r\n2012â€‘231406\r\nCall Ref #:\r\n457\r\nP33Aâ€‘TRANSFER/INTERFACâ€‘ALPHA at 250 HOSPITAL DR\r\nUnit\r\nType\r\nDescription\r\nTime Stamp\r\nComments\r\nClose\r\nCode\r\nUser\r\nEvent Log\r\nEmpl ID\r\nTR\r\nTime Received\r\n10/29/12 20:50:48\r\nBy: PHONE\r\nJCOX\r\nENT\r\nEntered Street\r\n10/29/12 20:51:09\r\nLEXING\r\nJCOX\r\nDLS\r\nDuplicate List\r\n10/29/12 20:51:14\r\nPotential Duplicate Events Listed (1\r\nJCOX\r\nCHG\r\nChanged Street\r\n10/29/12 20:51:16\r\nLEXING â€‘â€‘> 250 HOSPITAL DR\r\nJCOX\r\nENT\r\nEntered AddSt\r\n10/29/12 20:51:34\r\nICU 641\r\nJCOX\r\nARM\r\nAdded Remarks\r\n10/29/12 20:52:14\r\nJCOX\r\nENT\r\nEntered Remarks\r\n10/29/12 20:52:14\r\nJCOX\r\nENT\r\nEntered Nature\r\n10/29/12 20:52:22\r\nP33Aâ€‘TRANSFER/INTERFACâ€‘ALPHA\r\nJCOX\r\nENT\r\nEntered\r\n10/29/12 20:52:28\r\nJOSH\r\nJCOX\r\nFIN\r\nFinished Call Taking\r\n10/29/12 20:52:37\r\nJCOX\r\nRPT\r\nRequested Report#\r\n10/29/12 20:52:37\r\nEMS Report #2012â€‘018630\r\nJCOX\r\nREC\r\nUnit Recommendation\r\n10/29/12 20:55:17\r\nPlan: EMSD Cat: EMS Lvl: 1\r\nJREYNOL\r\nREC\r\nUnit Recommendation\r\n10/29/12 20:55:17\r\nRecmnd:M11 [EMS],  TK62 [SQUAD]\r\nJREYNOL\r\nPAG\r\nDispatch Page\r\n10/29/12 20:55:18\r\nPaged BASE1GR\r\nPAGESRV\r\nREC\r\nUnit Recommendation\r\n10/29/12 20:55:25\r\nPlan: EMSD Cat: EMS Lvl: 1\r\nJREYNOL\r\nREC\r\nUnit Recommendation\r\n10/29/12 20:55:25\r\nRecmnd:M11 [EMS],  TK62 [SQUAD]\r\nJREYNOL\r\nPage 2\r\n\r\n________________________________\r\nIf you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n\r\nDavidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n
(Clear Report Incident #2012231432) Communications\r\nUser: RIPTSRV\r\n10/29/12 22:05:59\r\nEvent Report\r\nEvent ID:\r\n2012â€‘231432\r\nCall Ref #:\r\n483\r\nDate/Time Received:\r\n10/29/12 21:37:52\r\nService:\r\nRpt #:\r\n2012â€‘018633\r\nCall Source:\r\nE911\r\nPrime\r\n Unit:\r\nM10\r\n Services Involved\r\nLAW\r\nFIRE\r\nEMS\r\nLocation:\r\nXâ€‘ST:\r\n160 LOWES BLVD\r\nCOTTON GROVE RD\r\nFAIRVIEW DR\r\n3364030812\r\nJur:\r\nAgency:\r\nSt/Beat:\r\nDistrict:\r\nRA:\r\nBusiness:\r\nPhone:\r\nNature:\r\nAlarm Lvl:\r\nPriority:\r\nCaller:\r\nAddr:\r\nPhone:\r\nAlarm:\r\nAlarm Type:\r\nVehicle #:\r\nDC\r\nEMS\r\nEMS\r\nB1\r\nB1\r\nWALMART\r\n(336) 243â€‘5648\r\nP31â€‘UNCONSCIOUS/FAINTINGâ€‘A\r\n1\r\n4\r\nMedical Priority:\r\n31A03\r\nJOHNSON, JOHN\r\n(336) 403â€‘0812\r\nSt:\r\nReport Only:\r\nNo\r\n[Medical Priority Info] PROBLEM: employee feels faint   # PATS: 1   AGE: 21   SEX: Male\r\nCONSCIOUS: Yes   BREATHING: Yes  [10/29/12 21:38:51 JGRUBB]\r\n[Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Fainting episode(s) and alert < 35\r\n(without cardiac history).\r\n1. His breathing is completely normal.\r\n2. He is completely alert (responding appropriately).\r\n3. He is not changing color.\r\n4. He has no history of heart problems.  [10/29/12 21:39:16 JGRUBB]\r\nCOME TO THE BACK OF THE BUILDING AT THE FIRE DOOR SOMEONE WILL SHOW WHERE THE SUBJECT IS\r\n[10/29/12 21:40:03 JGRUBB]\r\n[LAW] LPD ADVISED  [10/29/12 21:41:13 CBOWERS]\r\nNotes:\r\n10/29/12 21:37:52\r\nTimes\r\nCall Received:\r\n10/29/12 21:39:17\r\nCall Routed:\r\n10/29/12 21:39:17\r\nCall Take Finished:\r\n10/29/12 21:39:26\r\n1st Dispatch:\r\n10/29/12 21:42:29\r\n1st Enâ€‘Route:\r\n10/29/12 21:51:11\r\n1st Arrive:\r\n10/29/12 22:05:53\r\nLast Clear:\r\nTime From Call Received\r\n000:01:25\r\n000:01:25\r\n000:01:34\r\n000:04:37\r\n000:13:19\r\n000:28:01\r\nUnit Reaction:\r\nEnâ€‘Route:\r\nOnâ€‘Scene:\r\n000:11:45\r\n(1st Dispatch to 1st Arrive)\r\n000:03:03\r\n000:14:42\r\n(1st Dispatch to 1st Enâ€‘Route)\r\n(1st Arrive to Last Clear)\r\n(Time Held)\r\n(Reaction Time)\r\nGeoâ€‘Verified Addr.:\r\nYes\r\nNature Summary Code:\r\nDisposition:\r\nClose Comments:\r\nREF\r\nRace:\r\nSex:\r\nAge:\r\n:\r\nJGRUBB\r\nCall Taker:\r\nCAD9\r\nConsole:\r\n1685\r\nGP:\r\nUnit\r\nType\r\nDescription\r\nTime Stamp\r\nComments\r\nClose\r\nCode\r\nUser\r\nRadio Log\r\nEmpl ID\r\nPage 1\r\nEvent ID:\r\n2012â€‘231432\r\nCall Ref #:\r\n483\r\nP31â€‘UNCONSCIOUS/FAINTINGâ€‘ALPHA at 160 LOWES BLVD\r\nUnit\r\nType\r\nDescription\r\nTime Stamp\r\nComments\r\nClose\r\nCode\r\nUser\r\nRadio Log\r\nEmpl ID\r\nM10\r\nD\r\nDispatched\r\n10/29/12 21:39:26\r\nStat/Beat: B1\r\nJREYNOL\r\n0\r\nTK62\r\nD\r\nDispatched\r\n10/29/12 21:39:26\r\nStat/Beat: ST6\r\nJREYNOL\r\n0\r\nTK62\r\nC\r\nCleared\r\n10/29/12 21:40:58\r\nCAN\r\nJREYNOL\r\nCAN\r\n0\r\nM10\r\nE\r\nEnâ€‘Route\r\n10/29/12 21:42:29\r\nJREYNOL\r\n0\r\nM10\r\nA\r\nArrived\r\n10/29/12 21:51:11\r\nJREYNOL\r\n0\r\nM10\r\nC\r\nCleared\r\n10/29/12 22:05:53\r\nJGRUBB\r\nREF\r\n0\r\nUnit\r\nType\r\nDescription\r\nTime Stamp\r\nComments\r\nClose\r\nCode\r\nUser\r\nEvent Log\r\nEmpl ID\r\nTR\r\nTime Received\r\n10/29/12 21:37:52\r\nBy: E911\r\nJGRUBB\r\nENT\r\nEntered Street\r\n10/29/12 21:37:52\r\n784 MOUNT CARMEL â€‘ NE;LEX\r\nJGRUBB\r\nCHG\r\nChanged Street\r\n10/29/12 21:38:03\r\n784 MOUNT CARMEL â€‘ NE;LEX â€‘â€‘> 160\r\nJGRUBB\r\nENT\r\nEntered Nature\r\n10/29/12 21:38:17\r\nMEDICAL CALL PROQA LAUNCH\r\nJGRUBB\r\nMPS\r\nMed. Pri. Started\r\n10/29/12 21:38:17\r\nCase Started\r\nJGRUBB\r\nARM\r\nAdded Remarks\r\n10/29/12 21:38:51\r\nJGRUBB\r\nMPF\r\nMed. Pri. CE Finished\r\n10/29/12 21:38:52\r\nCase Entry Finished\r\nJGRUBB\r\nARM\r\nAdded Remarks\r\n10/29/12 21:39:16\r\nJGRUBB\r\nCHG\r\nP31â€‘UNCONSCIOUS/F\r\n10/29/12 21:39:17\r\nChanged nature\r\nJGRUBB\r\nFIN\r\nFinished Call Taking\r\n10/29/12 21:39:17\r\nJGRUBB\r\nRPT\r\nRequested Report#\r\n10/29/12 21:39:17\r\nEMS Report #2012â€‘018633\r\nJGRUBB\r\nSP\r\nSpawned\r\n10/29/12 21:39:17\r\nSpawned LAW event #2012231434\r\nJGRUBB\r\nSP\r\nSpawned\r\n10/29/12 21:39:17\r\nSpawned FIRE event #2012231435\r\nJGRUBB\r\nMPD\r\nMed. Pri. Dispatch\r\n10/29/12 21:39:19\r\nCase Dispatched\r\nJGRUBB\r\nREC\r\nUnit Recommendation\r\n10/29/12 21:39:25\r\nPlan: EMSD Cat: EMS Lvl: 1\r\nJREYNOL\r\nPAG\r\nDispatch Page\r\n10/29/12 21:39:26\r\nPaged BASE1GR\r\nPAGESRV\r\nPAG\r\nDispatch Page\r\n10/29/12 21:39:26\r\nPaged ST6MASTER\r\nPAGESRV\r\nREC\r\nUnit Recommendation\r\n10/29/12 21:39:26\r\nRecmnd:M10 [EMS],  TK62 [SQUAD]\r\nJREYNOL\r\nREC\r\nUnit Recommendation\r\n10/29/12 21:39:27\r\nPlan: EMSD Cat: EMS Lvl: 1\r\nJREYNOL\r\nREC\r\nUnit Recommendation\r\n10/29/12 21:39:27\r\nRecmnd:M10 [EMS],  TK62 [SQUAD]\r\nJREYNOL\r\nMPC\r\nMed. Pri. Complete\r\n10/29/12 21:39:35\r\nCase Completed\r\nJGRUBB\r\nCHG\r\nChanged\r\n10/29/12 21:39:42\r\nVERIZON WIRELESS â€‘â€‘> JOHNSON,\r\nJGRUBB\r\nCHG\r\nChanged CallerAddress\r\n10/29/12 21:39:43\r\n784 MOUNT CARMEL â€‘ NE;LEX â€‘â€‘>\r\nJGRUBB\r\nARM\r\nAdded Remarks\r\n10/29/12 21:40:03\r\nJGRUBB\r\nARM\r\nAdded Remarks\r\n10/29/12 21:41:13\r\nCBOWER\r\nPage 2\r\n\r\n________________________________\r\nIf you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n\r\nDavidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n
(Dispatch Report Incident #2012231432) Dispatch\r\nCommunications\r\nAddress:\r\nCross:\r\n160 LOWES BLVD\r\nCOTTON GROVE RD\r\nFAIRVIEW DR\r\nNature:\r\nP31â€‘UNCONSCIOUS/FAINTINGâ€‘ALPHA\r\nMP:\r\n31A03\r\nDate:\r\n10/29/12\r\nTime Out:\r\n21:39\r\nCity:\r\nLEX\r\n10/29/2012 14:47 1086 â€‘ LARCENY/SHOPLIFTING\r\n10/29/2012 09:37 1086 â€‘ LARCENY/SHOPLIFTING\r\n10/28/2012 16:27 1037â€‘DISTURBANCE\r\n10/28/2012 13:25 50PDâ€‘MOTOR VEH/PD ONLY\r\n10/28/2012 13:24 50PDâ€‘MOTOR VEH/PD ONLY\r\n10/28/2012 12:34 FORGERY/FRAUD\r\n10/27/2012 17:00 1086 â€‘ LARCENY/SHOPLIFTING\r\n10/27/2012 15:09 1063â€‘INVESTIGATE/SUPPLEMENTAL\r\n10/27/2012 12:22 1063â€‘INVESTIGATE/SUPPLEMENTAL\r\n10/26/2012 23:22 1037â€‘DISTURBANCE\r\nNOTIFICATION OF THE HEALTH DEPT. MAY BE NEEDED AND\r\nREQUESTED BY THE FIRE DEPT.HERE IS THE CALL ORDER IF SUCH A\r\nREQUEST IS MADE.\r\n1.  JOHN HENDREN  240â€‘0246\r\n2.  GREG HENNESSEE  787â€‘3690 OR 240â€‘0263\r\n3.  ANGELA PINYAN  775â€‘1071 OR 749â€‘3756\r\n4.  LILLIAN BARFIELD 252â€‘299â€‘0609\r\n5.  DEBRA HARMON 250â€‘9147\r\n6.  IF CAN`T GET ANYONE ABOVE CALL 242â€‘2310,\r\n     LEAVE A MESSAGE AND IT WILL ALERT ONâ€‘CALL\r\nHot Spot:\r\nPremise:\r\nWALMART\r\nBusiness:\r\nAddt Address:\r\n3364030812\r\n[Medical Priority Info] PROBLEM: employee feels faint   # PATS: 1   AGE: 21\r\nSEX: Male   CONSCIOUS: Yes   BREATHING: Yes  [10/29/12 21:38:51\r\nJGRUBB]\r\n[Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Fainting\r\nepisode(s) and alert < 35 (without cardiac history).\r\n1. His breathing is completely normal.\r\n2. He is completely alert (responding appropriately).\r\n3. He is not changing color.\r\n4. He has no history of heart problems.  [10/29/12 21:39:16 JGRUBB]\r\nNotes:\r\nDispatch\r\nCommunications\r\nM10, TK62\r\nCITY OF LEXINGTON\r\nUnits:\r\nStreet Notes:\r\nEND\r\n\r\n________________________________\r\nIf you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n\r\nDavidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n
(Dispatch Report Incident #2012231406) Dispatch\r\nCommunications\r\nAddress:\r\nCross:\r\n250 HOSPITAL DR\r\nW MEDICAL PARK DR\r\nNature:\r\nP33Aâ€‘TRANSFER/INTERFACâ€‘ALPHA\r\nDate:\r\n10/29/12\r\nTime Out:\r\n20:55\r\nCity:\r\nLEX\r\n10/29/2012 08:11 1063â€‘INVESTIGATE/SUPPLEMENTAL\r\n10/28/2012 16:55 1063â€‘INVESTIGATE/SUPPLEMENTAL\r\n10/28/2012 15:02 1086 â€‘ LARCENY/SHOPLIFTING\r\n10/28/2012 12:11 1073â€‘MENTAL SUBJECT\r\n10/28/2012 10:48 1073â€‘MENTAL SUBJECT\r\n10/28/2012 04:33 1063â€‘INVESTIGATE/SUPPLEMENTAL\r\n10/28/2012 01:00 1037â€‘DISTURBANCE\r\n10/26/2012 22:25 1073â€‘MENTAL SUBJECT\r\n10/26/2012 16:21 1073â€‘MENTAL SUBJECT\r\nNOTIFICATION OF THE HEALTH DEPT. MAY BE NEEDED AND\r\nREQUESTED BY THE FIRE DEPT.HERE IS THE CALL ORDER IF SUCH A\r\nREQUEST IS MADE.\r\n1.  JOHN HENDREN  240â€‘0246\r\n2.  GREG HENNESSEE  787â€‘3690 OR 240â€‘0263\r\n3.  ANGELA PINYAN  775â€‘1071 OR 749â€‘3756\r\n4.  LILLIAN BARFIELD 252â€‘299â€‘0609\r\n5.  DEBRA HARMON 250â€‘9147\r\n6.  IF CAN`T GET ANYONE ABOVE CALL 242â€‘2310,\r\n     LEAVE A MESSAGE AND IT WILL ALERT ONâ€‘CALL\r\nM11\r\nHot Spot:\r\nPremise:\r\nUnits:\r\nLMC LEXINGTON MEDICAL CENTER\r\nBusiness:\r\nAddt Address:\r\nICU 641\r\nGOING TO NCBH CCU BED 4, IV, O2, MONITOR  [10/29/12 20:52:14 JCOX]\r\nNotes:\r\nEND\r\n\r\n________________________________\r\nIf you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n\r\nDavidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n
(Dispatch Report Incident #2012231334) Dispatch\r\nCommunications\r\nAddress:\r\nCross:\r\n17 CORNELIA ST\r\nN TALBERT BLVD\r\nRALEIGH RD\r\nNature:\r\nP31â€‘UNCONSCIOUS/FAINTINGâ€‘DELTA\r\nMP:\r\n31D03\r\nDate:\r\n10/29/12\r\nTime Out:\r\n18:36\r\nCity:\r\nLEX\r\nNOTIFICATION OF THE HEALTH DEPT. MAY BE NEEDED AND\r\nREQUESTED BY THE FIRE DEPT.HERE IS THE CALL ORDER IF SUCH A\r\nREQUEST IS MADE.\r\n1.  JOHN HENDREN  240â€‘0246\r\n2.  GREG HENNESSEE  787â€‘3690 OR 240â€‘0263\r\n3.  ANGELA PINYAN  775â€‘1071 OR 749â€‘3756\r\n4.  LILLIAN BARFIELD 252â€‘299â€‘0609\r\n5.  DEBRA HARMON 250â€‘9147\r\n6.  IF CAN`T GET ANYONE ABOVE CALL 242â€‘2310,\r\n     LEAVE A MESSAGE AND IT WILL ALERT ONâ€‘CALL\r\nM10, ST6B\r\nCITY OF LEXINGTON\r\nPremise:\r\nUnits:\r\nStreet Notes:\r\nLEXINGTON HEALTH CARE\r\nBusiness:\r\nAddt Address:\r\n3RD HUNT\r\n[Medical Priority Info] PROBLEM: patient changes in level of conciousness   #\r\nPATS: 1   AGE: 78   SEX: Female   CONSCIOUS: Yes   BREATHING: Yes\r\n[10/29/12 18:36:21 JGRUBB]\r\n[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Not alert.\r\n1. Her breathing is not completely normal.\r\n2. She is not completely alert (not responding appropriately).\r\n3. She is changing color.\r\n4. Her color change is pale.  [10/29/12 18:36:36 JGRUBB]\r\n[Medical Priority Info] Key Questions Complete RESPONSE: Delta\r\nRESPONDER SCRIPT:\r\n5. She has a history of heart problems.  [10/29/12 18:36:42 JGRUBB]\r\nNotes:\r\nEND\r\n\r\n________________________________\r\nIf you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n\r\nDavidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n
(Dispatch Report Incident #2012231288) Dispatch\r\nCommunications\r\nAddress:\r\nCross:\r\n890 STRATFORD RD\r\nNAT CONRAD RD\r\nEMBLER RD\r\nNature:\r\nP6â€‘BREATHING PROBLEMSâ€‘DELTA\r\nMP:\r\n06D02\r\nDate:\r\n10/29/12\r\nTime Out:\r\n17:26\r\nCity:\r\nLEX\r\nM10, M2, ST6\r\nNAT CONRAD RD OFF OF HOLLY GROVE RD WEST THEN LEFT ONTO\r\nSTRATFORD RD\r\nKINGS GRANT SUBD\r\nUnits:\r\nStreet Notes:\r\nBusiness:\r\n[Medical Priority Info] PROBLEM: cant breathe   # PATS: 1   AGE: 67   SEX:\r\nMale   CONSCIOUS: Yes   BREATHING: Yes  [10/29/12 17:23:26 TPAINTER]\r\n[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: DIFFICULTY\r\nSPEAKING BETWEEN BREATHS.\r\n1. He is completely alert (responding appropriately).\r\n2. He has difficulty speaking between breaths.  [10/29/12 17:23:38 TPAINTER]\r\n[Medical Priority Info] Key Questions Complete RESPONSE: Delta\r\nRESPONDER SCRIPT:\r\n3. He is not changing color.\r\n4. He is clammy.\r\n5. He does not have asthma.\r\n6. N/A  [10/29/12 17:23:52 TPAINTER]\r\nNotes:\r\nEND\r\n\r\n________________________________\r\nIf you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n\r\nDavidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n
(Dispatch Report Incident #2012231282) Dispatch\r\nCommunications\r\nAddress:\r\nCross:\r\n164 WINTERBERRY DR\r\nE HOLLY GROVE RD\r\nNature:\r\nP17â€‘FALLâ€‘CHARLIE\r\nMP:\r\n17B03\r\nDate:\r\n10/29/12\r\nTime Out:\r\n17:18\r\nCity:\r\nTHA\r\nM10, TK52\r\nON THE N SIDE OF E HOLLY GROVE RD APPROX .34M E OF\r\nCEDARLAND DR\r\nUnits:\r\nStreet Notes:\r\nBusiness:\r\n[Medical Priority Info] PROBLEM: Fall   # PATS: 1   AGE: 72   SEX: Male\r\nCONSCIOUS: Yes   BREATHING: Yes  [10/29/12 17:17:10 CPAYNE]\r\n[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Unknown\r\nstatus/Other codes not applicable  (On the ground or floor).\r\n1. This happened now (less than 6hrs ago).\r\n2. It`s not known how far he fell.\r\n3. The reason for the fall is not known.\r\n4. It`s not known if there is SERIOUS bleeding.\r\n5. He is completely alert (responding appropriately).\r\n6. The extent of his injuries is not known.\r\n7. He is still on the floor (ground).  [10/29/12 17:17:58 CPAYNE]\r\nNotes:\r\nEND\r\n\r\n________________________________\r\nIf you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n\r\nDavidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n
(Dispatch Report Incident #2012231255) Dispatch\r\nCommunications\r\nAddress:\r\nCross:\r\n1041â€‘7 NOAHTOWN RD\r\nFANNIE PULLUM RD\r\nLAUREL DR\r\nNature:\r\nEMSâ€‘PUBLIC SERVICE\r\nMP:\r\n69D10\r\nDate:\r\n10/29/12\r\nTime Out:\r\n16:45\r\nCity:\r\nTHA\r\nM1C, M20, SRU1\r\nON E SIDE OF NEW HWY 109â€‘N ACROSS MT ZION CHURCH RD INT THEN\r\n(RUNS BETWEEN NEW HWY 109 AND BLACKBERRY RD)\r\nUnits:\r\nStreet Notes:\r\nBusiness:\r\nEvent spawned from P69D10â€‘HOUSE/MH/PORT OFC.  [10/29/2012 16:43:05\r\nBSTOSS]\r\ndog stuck in res on fire  [10/29/12 16:34:25 TPAINTER]\r\n[Fire Priority Info] PROBLEM: house fire  [10/29/12 16:34:36 TPAINTER]\r\n[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT:   0 Mobile home,\r\nhouse trailer, portable office.\r\n1. The caller is on scene (1st party).\r\n2. Both smoke and flames are visible.\r\n3. The incident involves a mobile home.\r\n4. A singleâ€‘level structure is involved.\r\n5. The caller has not indicated that there are trapped person(s).  [10/29/12\r\n16:34:48 TPAINTER]\r\n[Fire Priority Info] Key Questions Complete RESPONSE: Delta   RESPONDER\r\nSCRIPT:\r\n6. No one is trapped inside the structure.\r\n7. No one is reported to be injured.  [10/29/12 16:34:52 TPAINTER]\r\nDOG TRAPPED IN RES UNABLE TO GET HIM OUT  [10/29/12 16:35:03\r\nTPAINTER]\r\nCALLER HUNG UP AFTER TELLING ME IT WAS ON FIRE AND HIS DOG\r\nWAS INSIDE  [10/29/12 16:35:19 TPAINTER]\r\n[LAW] DCSO ADV  [10/29/12 16:37:04 CPAYNE]\r\nUDTS: Co Fire Tac3 for call  [10/29/12 16:38:06 BSTOSS]\r\n692 ENR  [10/29/12 16:39:16 BSTOSS]\r\n3243 ON SCENE SMOKE SHOWING  [10/29/12 16:41:55 BSTOSS]\r\n2843 WORKING FIRE  [10/29/12 16:42:45 BSTOSS]\r\n[FIRE] UDTS: {ENG43} working fire  [10/29/12 16:44:07 JEVERHART]\r\nNotes:\r\nEND\r\n\r\n________________________________\r\nIf you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n\r\nDavidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n
(Dispatch Report Incident #2012231244) Dispatch\r\nCommunications\r\nAddress:\r\nCross:\r\n200 HELEN YOUNG DR\r\nCHARITY LN\r\nBIG`UN DR\r\nNature:\r\nP1â€‘ABDOMINAL PAINSâ€‘ALPHA\r\nMP:\r\n01A01\r\nDate:\r\n10/29/12\r\nTime Out:\r\n16:35\r\nCity:\r\nLIN\r\nM11, ST7\r\nPVT RDâ€‘â€‘â€‘N SIDE OF CHARITY LN .1M W OF OLD WESLEY CHAPEL RD\r\nUnits:\r\nStreet Notes:\r\nBusiness:\r\n[Medical Priority Info] PROBLEM: abdominal pains, vomitting   # PATS: 1\r\nAGE: 38   SEX: Female   CONSCIOUS: Yes   BREATHING: Yes  [10/29/12\r\n16:34:58 CPAYNE]\r\n[Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Abdominal\r\npain.\r\n1. She is completely alert (responding appropriately).\r\n2. There was no mention of existing aortic aneurysm.\r\n3. She has not fainted or nearly fainted.  [10/29/12 16:35:15 CPAYNE]\r\nNotes:\r\nEND\r\n\r\n________________________________\r\nIf you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n\r\nDavidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n
(Dispatch Report Incident #2012231193) Dispatch\r\nCommunications\r\nAddress:\r\nCross:\r\n217 SANTA FE CIR\r\nCORAL LN\r\nFLAGSTONE CT\r\nNature:\r\nP6â€‘BREATHING PROBLEMSâ€‘CHARLIE\r\nMP:\r\n06C01\r\nDate:\r\n10/29/12\r\nTime Out:\r\n15:41\r\nCity:\r\nTHA\r\nM10, M6, TK51\r\nPVT RDâ€‘â€‘â€‘S SIDE OF LEXINGTON AV BETWEEN BECK RD AND MT.\r\nCALVARY RD.\r\nBEGIN OFF LEXINGTON AV AT 1407\r\nMILLSTONE MANOR\r\nUnits:\r\nStreet Notes:\r\nBusiness:\r\n[Medical Priority Info] PROBLEM: med alarm    # PATS: 1   AGE: 83   SEX:\r\nFemale   CONSCIOUS: Yes   BREATHING: Yes  [10/29/12 15:36:46\r\nTPAINTER]\r\n[Medical Priority Info] PROBLEM: med alarm    # PATS: 1   AGE: 83   SEX:\r\nFemale   CONSCIOUS: Yes   BREATHING: Yes  [10/29/12 15:36:50\r\nTPAINTER]\r\n[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Abnormal\r\nbreathing.\r\n1. It`s not known if she is completely alert (responding appropriately).\r\n2. It`s not known if she has difficulty speaking between breaths.\r\n3. It`s not known if she is changing color.\r\n4. It`s not known if she is clammy.\r\n5. It`s not known if she has asthma.\r\n6. It`s not known if she has any special equipment or instructions to treat this.\r\n[10/29/12 15:37:16 TPAINTER]\r\nNotes:\r\nEND\r\n\r\n________________________________\r\nIf you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n\r\nDavidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n
(Dispatch Report Incident #2012232025) Dispatch\r\nCommunications\r\nAddress:\r\nCross:\r\n7 NATIONAL HWY\r\nCOUNCIL ST\r\nE GUILFORD ST\r\nNature:\r\nP33Aâ€‘TRANSFER/INTERFACâ€‘ALPHA\r\nDate:\r\n10/30/12\r\nTime Out:\r\n19:37\r\nCity:\r\nTHA\r\nDR601, M20, TK53\r\n FROM SALEM ST IN THE CITY NE TO COUNTY LINE\r\n THE FOOD LION SHOPPING CENTER IS OUT OF SEQUENCE IS JUST N\r\nOF HASTY SCHOOL RD AND ACROSS FROM THE LOWE`S SHOPPING\r\nCENTER.  WILL BE IN THE CITY\r\nUnits:\r\nStreet Notes:\r\nBusiness:\r\nroutine transfer hospice house lexington 100 hospice way pos oxygen needed\r\nadv of wait for dr601  [10/30/12 18:24:26 JREYNOLDS]\r\nNotes:\r\nEND\r\n\r\n________________________________\r\nIf you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n\r\nDavidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n

***/

public class NCDavidsonCountyBParserTest extends BaseParserTest {
  
  public NCDavidsonCountyBParserTest() {
    setParser(new NCDavidsonCountyBParser(), "DAVIDSON COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Clear Report Incident #2012231406) Communications\r\n" +
        "User: RIPTSRV\r\n" +
        "10/29/12 22:38:53\r\n" +
        "Event Report\r\n" +
        "Event ID:\r\n" +
        "2012â€‘231406\r\n" +
        "Call Ref #:\r\n" +
        "457\r\n" +
        "Date/Time Received:\r\n" +
        "10/29/12 20:50:48\r\n" +
        "Service:\r\n" +
        "Rpt #:\r\n" +
        "2012â€‘018630\r\n" +
        "Call Source:\r\n" +
        "PHONE\r\n" +
        "Prime\r\n" +
        " Unit:\r\n" +
        "M11\r\n" +
        " Services Involved\r\n" +
        "EMS\r\n" +
        "Location:\r\n" +
        "Xâ€‘ST:\r\n" +
        "250 HOSPITAL DR\r\n" +
        "W MEDICAL PARK DR\r\n" +
        "ICU 641\r\n" +
        "Jur:\r\n" +
        "Agency:\r\n" +
        "St/Beat:\r\n" +
        "District:\r\n" +
        "RA:\r\n" +
        "Business:\r\n" +
        "Phone:\r\n" +
        "Nature:\r\n" +
        "Alarm Lvl:\r\n" +
        "Priority:\r\n" +
        "Caller:\r\n" +
        "Addr:\r\n" +
        "Phone:\r\n" +
        "Alarm:\r\n" +
        "Alarm Type:\r\n" +
        "Vehicle #:\r\n" +
        "DC\r\n" +
        "EMS\r\n" +
        "EMS\r\n" +
        "B1\r\n" +
        "B1\r\n" +
        "LMC LEXINGTON MEDICAL\r\n" +
        "(336) 248â€‘5161\r\n" +
        "P33Aâ€‘TRANSFER/INTERFACâ€‘AL\r\n" +
        "1\r\n" +
        "3\r\n" +
        "Medical Priority:\r\n" +
        "JOSH\r\n" +
        "250 HOSPITAL DR\r\n" +
        "(   )    â€‘\r\n" +
        "St:\r\n" +
        "Report Only:\r\n" +
        "No\r\n" +
        "GOING TO NCBH CCU BED 4, IV, O2, MONITOR  [10/29/12 20:52:14 JCOX]\r\n" +
        "Notes:\r\n" +
        "10/29/12 20:50:48\r\n" +
        "Times\r\n" +
        "Call Received:\r\n" +
        "10/29/12 20:52:37\r\n" +
        "Call Routed:\r\n" +
        "10/29/12 20:52:37\r\n" +
        "Call Take Finished:\r\n" +
        "10/29/12 20:55:17\r\n" +
        "1st Dispatch:\r\n" +
        "10/29/12 20:56:53\r\n" +
        "1st Enâ€‘Route:\r\n" +
        "10/29/12 21:06:37\r\n" +
        "1st Arrive:\r\n" +
        "10/29/12 22:38:51\r\n" +
        "Last Clear:\r\n" +
        "Time From Call Received\r\n" +
        "000:01:49\r\n" +
        "000:01:49\r\n" +
        "000:04:29\r\n" +
        "000:06:05\r\n" +
        "000:15:49\r\n" +
        "001:48:03\r\n" +
        "Unit Reaction:\r\n" +
        "Enâ€‘Route:\r\n" +
        "Onâ€‘Scene:\r\n" +
        "000:11:20\r\n" +
        "(1st Dispatch to 1st Arrive)\r\n" +
        "000:01:36\r\n" +
        "001:32:14\r\n" +
        "(1st Dispatch to 1st Enâ€‘Route)\r\n" +
        "(1st Arrive to Last Clear)\r\n" +
        "(Time Held)\r\n" +
        "(Reaction Time)\r\n" +
        "Geoâ€‘Verified Addr.:\r\n" +
        "Yes\r\n" +
        "Nature Summary Code:\r\n" +
        "Disposition:\r\n" +
        "Close Comments:\r\n" +
        "T\r\n" +
        "Race:\r\n" +
        "Sex:\r\n" +
        "Age:\r\n" +
        ":\r\n" +
        "JCOX\r\n" +
        "Call Taker:\r\n" +
        "CAD3\r\n" +
        "Console:\r\n" +
        "1686\r\n" +
        "GP:\r\n" +
        "Unit\r\n" +
        "Type\r\n" +
        "Description\r\n" +
        "Time Stamp\r\n" +
        "Comments\r\n" +
        "Close\r\n" +
        "Code\r\n" +
        "User\r\n" +
        "Radio Log\r\n" +
        "Empl ID\r\n" +
        "M11\r\n" +
        "D\r\n" +
        "Dispatched\r\n" +
        "10/29/12 20:55:17\r\n" +
        "Stat/Beat: B1\r\n" +
        "JREYNOL\r\n" +
        "0\r\n" +
        "M11\r\n" +
        "E\r\n" +
        "Enâ€‘Route\r\n" +
        "10/29/12 20:56:53\r\n" +
        "JREYNOL\r\n" +
        "0\r\n" +
        "M11\r\n" +
        "A\r\n" +
        "Arrived\r\n" +
        "10/29/12 21:06:37\r\n" +
        "JREYNOL\r\n" +
        "0\r\n" +
        "M11\r\n" +
        "T\r\n" +
        "Transport\r\n" +
        "10/29/12 21:24:11\r\n" +
        "To: RT/NCBH\r\n" +
        "JREYNOL\r\n" +
        "0\r\n" +
        "M11\r\n" +
        "H\r\n" +
        "At Hospital\r\n" +
        "10/29/12 21:48:41\r\n" +
        "JREYNOL\r\n" +
        "0\r\n" +
        "M11\r\n" +
        "R\r\n" +
        "Return to Qtr\r\n" +
        "10/29/12 22:13:22\r\n" +
        "JGRUBB\r\n" +
        "0\r\n" +
        "M11\r\n" +
        "C\r\n" +
        "Cleared\r\n" +
        "10/29/12 22:38:51\r\n" +
        "T\r\n" +
        "JREYNOL\r\n" +
        "T\r\n" +
        "0\r\n" +
        "Page 1\r\n" +
        "Event ID:\r\n" +
        "2012â€‘231406\r\n" +
        "Call Ref #:\r\n" +
        "457\r\n" +
        "P33Aâ€‘TRANSFER/INTERFACâ€‘ALPHA at 250 HOSPITAL DR\r\n" +
        "Unit\r\n" +
        "Type\r\n" +
        "Description\r\n" +
        "Time Stamp\r\n" +
        "Comments\r\n" +
        "Close\r\n" +
        "Code\r\n" +
        "User\r\n" +
        "Event Log\r\n" +
        "Empl ID\r\n" +
        "TR\r\n" +
        "Time Received\r\n" +
        "10/29/12 20:50:48\r\n" +
        "By: PHONE\r\n" +
        "JCOX\r\n" +
        "ENT\r\n" +
        "Entered Street\r\n" +
        "10/29/12 20:51:09\r\n" +
        "LEXING\r\n" +
        "JCOX\r\n" +
        "DLS\r\n" +
        "Duplicate List\r\n" +
        "10/29/12 20:51:14\r\n" +
        "Potential Duplicate Events Listed (1\r\n" +
        "JCOX\r\n" +
        "CHG\r\n" +
        "Changed Street\r\n" +
        "10/29/12 20:51:16\r\n" +
        "LEXING â€‘â€‘> 250 HOSPITAL DR\r\n" +
        "JCOX\r\n" +
        "ENT\r\n" +
        "Entered AddSt\r\n" +
        "10/29/12 20:51:34\r\n" +
        "ICU 641\r\n" +
        "JCOX\r\n" +
        "ARM\r\n" +
        "Added Remarks\r\n" +
        "10/29/12 20:52:14\r\n" +
        "JCOX\r\n" +
        "ENT\r\n" +
        "Entered Remarks\r\n" +
        "10/29/12 20:52:14\r\n" +
        "JCOX\r\n" +
        "ENT\r\n" +
        "Entered Nature\r\n" +
        "10/29/12 20:52:22\r\n" +
        "P33Aâ€‘TRANSFER/INTERFACâ€‘ALPHA\r\n" +
        "JCOX\r\n" +
        "ENT\r\n" +
        "Entered\r\n" +
        "10/29/12 20:52:28\r\n" +
        "JOSH\r\n" +
        "JCOX\r\n" +
        "FIN\r\n" +
        "Finished Call Taking\r\n" +
        "10/29/12 20:52:37\r\n" +
        "JCOX\r\n" +
        "RPT\r\n" +
        "Requested Report#\r\n" +
        "10/29/12 20:52:37\r\n" +
        "EMS Report #2012â€‘018630\r\n" +
        "JCOX\r\n" +
        "REC\r\n" +
        "Unit Recommendation\r\n" +
        "10/29/12 20:55:17\r\n" +
        "Plan: EMSD Cat: EMS Lvl: 1\r\n" +
        "JREYNOL\r\n" +
        "REC\r\n" +
        "Unit Recommendation\r\n" +
        "10/29/12 20:55:17\r\n" +
        "Recmnd:M11 [EMS],  TK62 [SQUAD]\r\n" +
        "JREYNOL\r\n" +
        "PAG\r\n" +
        "Dispatch Page\r\n" +
        "10/29/12 20:55:18\r\n" +
        "Paged BASE1GR\r\n" +
        "PAGESRV\r\n" +
        "REC\r\n" +
        "Unit Recommendation\r\n" +
        "10/29/12 20:55:25\r\n" +
        "Plan: EMSD Cat: EMS Lvl: 1\r\n" +
        "JREYNOL\r\n" +
        "REC\r\n" +
        "Unit Recommendation\r\n" +
        "10/29/12 20:55:25\r\n" +
        "Recmnd:M11 [EMS],  TK62 [SQUAD]\r\n" +
        "JREYNOL\r\n" +
        "Page 2\r\n" +
        "\r\n" +
        "________________________________\r\n" +
        "If you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n" +
        "\r\n" +
        "Davidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n",

        "ID:2012231406",
        "CALL:RUN REPORT",
        "PLACE:Communications\nUser: RIPTSRV\n10/29/12 22:38:53\nEvent Report\nEvent ID:\n2012â€‘231406\nCall Ref #:\n457\nDate/Time Received:\n10/29/12 20:50:48\nService:\nRpt #:\n2012â€‘018630\nCall Source:\nPHONE\nPrime\n Unit:\nM11\n Services Involved\nEMS\nLocation:\nXâ€‘ST:\n250 HOSPITAL DR\nW MEDICAL PARK DR\nICU 641\nJur:\nAgency:\nSt/Beat:\nDistrict:\nRA:\nBusiness:\nPhone:\nNature:\nAlarm Lvl:\nPriority:\nCaller:\nAddr:\nPhone:\nAlarm:\nAlarm Type:\nVehicle #:\nDC\nEMS\nEMS\nB1\nB1\nLMC LEXINGTON MEDICAL\n(336) 248â€‘5161\nP33Aâ€‘TRANSFER/INTERFACâ€‘AL\n1\n3\nMedical Priority:\nJOSH\n250 HOSPITAL DR\n(   )    â€‘\nSt:\nReport Only:\nNo\nGOING TO NCBH CCU BED 4, IV, O2, MONITOR  [10/29/12 20:52:14 JCOX]\nNotes:\n10/29/12 20:50:48\nTimes\nCall Received:\n10/29/12 20:52:37\nCall Routed:\n10/29/12 20:52:37\nCall Take Finished:\n10/29/12 20:55:17\n1st Dispatch:\n10/29/12 20:56:53\n1st Enâ€‘Route:\n10/29/12 21:06:37\n1st Arrive:\n10/29/12 22:38:51\nLast Clear:\nTime From Call Received\n000:01:49\n000:01:49\n000:04:29\n000:06:05\n000:15:49\n001:48:03\nUnit Reaction:\nEnâ€‘Route:\nOnâ€‘Scene:\n000:11:20\n(1st Dispatch to 1st Arrive)\n000:01:36\n001:32:14\n(1st Dispatch to 1st Enâ€‘Route)\n(1st Arrive to Last Clear)\n(Time Held)\n(Reaction Time)\nGeoâ€‘Verified Addr.:\nYes\nNature Summary Code:\nDisposition:\nClose Comments:\nT\nRace:\nSex:\nAge:\n:\nJCOX\nCall Taker:\nCAD3\nConsole:\n1686\nGP:\nUnit\nType\nDescription\nTime Stamp\nComments\nClose\nCode\nUser\nRadio Log\nEmpl ID\nM11\nD\nDispatched\n10/29/12 20:55:17\nStat/Beat: B1\nJREYNOL\n0\nM11\nE\nEnâ€‘Route\n10/29/12 20:56:53\nJREYNOL\n0\nM11\nA\nArrived\n10/29/12 21:06:37\nJREYNOL\n0\nM11\nT\nTransport\n10/29/12 21:24:11\nTo: RT/NCBH\nJREYNOL\n0\nM11\nH\nAt Hospital\n10/29/12 21:48:41\nJREYNOL\n0\nM11\nR\nReturn to Qtr\n10/29/12 22:13:22\nJGRUBB\n0\nM11\nC\nCleared\n10/29/12 22:38:51\nT\nJREYNOL\nT\n0\nPage 1\nEvent ID:\n2012â€‘231406\nCall Ref #:\n457\nP33Aâ€‘TRANSFER/INTERFACâ€‘ALPHA at 250 HOSPITAL DR\nUnit\nType\nDescription\nTime Stamp\nComments\nClose\nCode\nUser\nEvent Log\nEmpl ID\nTR\nTime Received\n10/29/12 20:50:48\nBy: PHONE\nJCOX\nENT\nEntered Street\n10/29/12 20:51:09\nLEXING\nJCOX\nDLS\nDuplicate List\n10/29/12 20:51:14\nPotential Duplicate Events Listed (1\nJCOX\nCHG\nChanged Street\n10/29/12 20:51:16\nLEXING â€‘â€‘> 250 HOSPITAL DR\nJCOX\nENT\nEntered AddSt\n10/29/12 20:51:34\nICU 641\nJCOX\nARM\nAdded Remarks\n10/29/12 20:52:14\nJCOX\nENT\nEntered Remarks\n10/29/12 20:52:14\nJCOX\nENT\nEntered Nature\n10/29/12 20:52:22\nP33Aâ€‘TRANSFER/INTERFACâ€‘ALPHA\nJCOX\nENT\nEntered\n10/29/12 20:52:28\nJOSH\nJCOX\nFIN\nFinished Call Taking\n10/29/12 20:52:37\nJCOX\nRPT\nRequested Report#\n10/29/12 20:52:37\nEMS Report #2012â€‘018630\nJCOX\nREC\nUnit Recommendation\n10/29/12 20:55:17\nPlan: EMSD Cat: EMS Lvl: 1\nJREYNOL\nREC\nUnit Recommendation\n10/29/12 20:55:17\nRecmnd:M11 [EMS],  TK62 [SQUAD]\nJREYNOL\nPAG\nDispatch Page\n10/29/12 20:55:18\nPaged BASE1GR\nPAGESRV\nREC\nUnit Recommendation\n10/29/12 20:55:25\nPlan: EMSD Cat: EMS Lvl: 1\nJREYNOL\nREC\nUnit Recommendation\n10/29/12 20:55:25\nRecmnd:M11 [EMS],  TK62 [SQUAD]\nJREYNOL\nPage 2\n\n________________________________\nIf you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\n\nDavidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us");

    doTest("T2",
        "(Clear Report Incident #2012231432) Communications\r\n" +
        "User: RIPTSRV\r\n" +
        "10/29/12 22:05:59\r\n" +
        "Event Report\r\n" +
        "Event ID:\r\n" +
        "2012â€‘231432\r\n" +
        "Call Ref #:\r\n" +
        "483\r\n" +
        "Date/Time Received:\r\n" +
        "10/29/12 21:37:52\r\n" +
        "Service:\r\n" +
        "Rpt #:\r\n" +
        "2012â€‘018633\r\n" +
        "Call Source:\r\n" +
        "E911\r\n" +
        "Prime\r\n" +
        " Unit:\r\n" +
        "M10\r\n" +
        " Services Involved\r\n" +
        "LAW\r\n" +
        "FIRE\r\n" +
        "EMS\r\n" +
        "Location:\r\n" +
        "Xâ€‘ST:\r\n" +
        "160 LOWES BLVD\r\n" +
        "COTTON GROVE RD\r\n" +
        "FAIRVIEW DR\r\n" +
        "3364030812\r\n" +
        "Jur:\r\n" +
        "Agency:\r\n" +
        "St/Beat:\r\n" +
        "District:\r\n" +
        "RA:\r\n" +
        "Business:\r\n" +
        "Phone:\r\n" +
        "Nature:\r\n" +
        "Alarm Lvl:\r\n" +
        "Priority:\r\n" +
        "Caller:\r\n" +
        "Addr:\r\n" +
        "Phone:\r\n" +
        "Alarm:\r\n" +
        "Alarm Type:\r\n" +
        "Vehicle #:\r\n" +
        "DC\r\n" +
        "EMS\r\n" +
        "EMS\r\n" +
        "B1\r\n" +
        "B1\r\n" +
        "WALMART\r\n" +
        "(336) 243â€‘5648\r\n" +
        "P31â€‘UNCONSCIOUS/FAINTINGâ€‘A\r\n" +
        "1\r\n" +
        "4\r\n" +
        "Medical Priority:\r\n" +
        "31A03\r\n" +
        "JOHNSON, JOHN\r\n" +
        "(336) 403â€‘0812\r\n" +
        "St:\r\n" +
        "Report Only:\r\n" +
        "No\r\n" +
        "[Medical Priority Info] PROBLEM: employee feels faint   # PATS: 1   AGE: 21   SEX: Male\r\n" +
        "CONSCIOUS: Yes   BREATHING: Yes  [10/29/12 21:38:51 JGRUBB]\r\n" +
        "[Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Fainting episode(s) and alert < 35\r\n" +
        "(without cardiac history).\r\n" +
        "1. His breathing is completely normal.\r\n" +
        "2. He is completely alert (responding appropriately).\r\n" +
        "3. He is not changing color.\r\n" +
        "4. He has no history of heart problems.  [10/29/12 21:39:16 JGRUBB]\r\n" +
        "COME TO THE BACK OF THE BUILDING AT THE FIRE DOOR SOMEONE WILL SHOW WHERE THE SUBJECT IS\r\n" +
        "[10/29/12 21:40:03 JGRUBB]\r\n" +
        "[LAW] LPD ADVISED  [10/29/12 21:41:13 CBOWERS]\r\n" +
        "Notes:\r\n" +
        "10/29/12 21:37:52\r\n" +
        "Times\r\n" +
        "Call Received:\r\n" +
        "10/29/12 21:39:17\r\n" +
        "Call Routed:\r\n" +
        "10/29/12 21:39:17\r\n" +
        "Call Take Finished:\r\n" +
        "10/29/12 21:39:26\r\n" +
        "1st Dispatch:\r\n" +
        "10/29/12 21:42:29\r\n" +
        "1st Enâ€‘Route:\r\n" +
        "10/29/12 21:51:11\r\n" +
        "1st Arrive:\r\n" +
        "10/29/12 22:05:53\r\n" +
        "Last Clear:\r\n" +
        "Time From Call Received\r\n" +
        "000:01:25\r\n" +
        "000:01:25\r\n" +
        "000:01:34\r\n" +
        "000:04:37\r\n" +
        "000:13:19\r\n" +
        "000:28:01\r\n" +
        "Unit Reaction:\r\n" +
        "Enâ€‘Route:\r\n" +
        "Onâ€‘Scene:\r\n" +
        "000:11:45\r\n" +
        "(1st Dispatch to 1st Arrive)\r\n" +
        "000:03:03\r\n" +
        "000:14:42\r\n" +
        "(1st Dispatch to 1st Enâ€‘Route)\r\n" +
        "(1st Arrive to Last Clear)\r\n" +
        "(Time Held)\r\n" +
        "(Reaction Time)\r\n" +
        "Geoâ€‘Verified Addr.:\r\n" +
        "Yes\r\n" +
        "Nature Summary Code:\r\n" +
        "Disposition:\r\n" +
        "Close Comments:\r\n" +
        "REF\r\n" +
        "Race:\r\n" +
        "Sex:\r\n" +
        "Age:\r\n" +
        ":\r\n" +
        "JGRUBB\r\n" +
        "Call Taker:\r\n" +
        "CAD9\r\n" +
        "Console:\r\n" +
        "1685\r\n" +
        "GP:\r\n" +
        "Unit\r\n" +
        "Type\r\n" +
        "Description\r\n" +
        "Time Stamp\r\n" +
        "Comments\r\n" +
        "Close\r\n" +
        "Code\r\n" +
        "User\r\n" +
        "Radio Log\r\n" +
        "Empl ID\r\n" +
        "Page 1\r\n" +
        "Event ID:\r\n" +
        "2012â€‘231432\r\n" +
        "Call Ref #:\r\n" +
        "483\r\n" +
        "P31â€‘UNCONSCIOUS/FAINTINGâ€‘ALPHA at 160 LOWES BLVD\r\n" +
        "Unit\r\n" +
        "Type\r\n" +
        "Description\r\n" +
        "Time Stamp\r\n" +
        "Comments\r\n" +
        "Close\r\n" +
        "Code\r\n" +
        "User\r\n" +
        "Radio Log\r\n" +
        "Empl ID\r\n" +
        "M10\r\n" +
        "D\r\n" +
        "Dispatched\r\n" +
        "10/29/12 21:39:26\r\n" +
        "Stat/Beat: B1\r\n" +
        "JREYNOL\r\n" +
        "0\r\n" +
        "TK62\r\n" +
        "D\r\n" +
        "Dispatched\r\n" +
        "10/29/12 21:39:26\r\n" +
        "Stat/Beat: ST6\r\n" +
        "JREYNOL\r\n" +
        "0\r\n" +
        "TK62\r\n" +
        "C\r\n" +
        "Cleared\r\n" +
        "10/29/12 21:40:58\r\n" +
        "CAN\r\n" +
        "JREYNOL\r\n" +
        "CAN\r\n" +
        "0\r\n" +
        "M10\r\n" +
        "E\r\n" +
        "Enâ€‘Route\r\n" +
        "10/29/12 21:42:29\r\n" +
        "JREYNOL\r\n" +
        "0\r\n" +
        "M10\r\n" +
        "A\r\n" +
        "Arrived\r\n" +
        "10/29/12 21:51:11\r\n" +
        "JREYNOL\r\n" +
        "0\r\n" +
        "M10\r\n" +
        "C\r\n" +
        "Cleared\r\n" +
        "10/29/12 22:05:53\r\n" +
        "JGRUBB\r\n" +
        "REF\r\n" +
        "0\r\n" +
        "Unit\r\n" +
        "Type\r\n" +
        "Description\r\n" +
        "Time Stamp\r\n" +
        "Comments\r\n" +
        "Close\r\n" +
        "Code\r\n" +
        "User\r\n" +
        "Event Log\r\n" +
        "Empl ID\r\n" +
        "TR\r\n" +
        "Time Received\r\n" +
        "10/29/12 21:37:52\r\n" +
        "By: E911\r\n" +
        "JGRUBB\r\n" +
        "ENT\r\n" +
        "Entered Street\r\n" +
        "10/29/12 21:37:52\r\n" +
        "784 MOUNT CARMEL â€‘ NE;LEX\r\n" +
        "JGRUBB\r\n" +
        "CHG\r\n" +
        "Changed Street\r\n" +
        "10/29/12 21:38:03\r\n" +
        "784 MOUNT CARMEL â€‘ NE;LEX â€‘â€‘> 160\r\n" +
        "JGRUBB\r\n" +
        "ENT\r\n" +
        "Entered Nature\r\n" +
        "10/29/12 21:38:17\r\n" +
        "MEDICAL CALL PROQA LAUNCH\r\n" +
        "JGRUBB\r\n" +
        "MPS\r\n" +
        "Med. Pri. Started\r\n" +
        "10/29/12 21:38:17\r\n" +
        "Case Started\r\n" +
        "JGRUBB\r\n" +
        "ARM\r\n" +
        "Added Remarks\r\n" +
        "10/29/12 21:38:51\r\n" +
        "JGRUBB\r\n" +
        "MPF\r\n" +
        "Med. Pri. CE Finished\r\n" +
        "10/29/12 21:38:52\r\n" +
        "Case Entry Finished\r\n" +
        "JGRUBB\r\n" +
        "ARM\r\n" +
        "Added Remarks\r\n" +
        "10/29/12 21:39:16\r\n" +
        "JGRUBB\r\n" +
        "CHG\r\n" +
        "P31â€‘UNCONSCIOUS/F\r\n" +
        "10/29/12 21:39:17\r\n" +
        "Changed nature\r\n" +
        "JGRUBB\r\n" +
        "FIN\r\n" +
        "Finished Call Taking\r\n" +
        "10/29/12 21:39:17\r\n" +
        "JGRUBB\r\n" +
        "RPT\r\n" +
        "Requested Report#\r\n" +
        "10/29/12 21:39:17\r\n" +
        "EMS Report #2012â€‘018633\r\n" +
        "JGRUBB\r\n" +
        "SP\r\n" +
        "Spawned\r\n" +
        "10/29/12 21:39:17\r\n" +
        "Spawned LAW event #2012231434\r\n" +
        "JGRUBB\r\n" +
        "SP\r\n" +
        "Spawned\r\n" +
        "10/29/12 21:39:17\r\n" +
        "Spawned FIRE event #2012231435\r\n" +
        "JGRUBB\r\n" +
        "MPD\r\n" +
        "Med. Pri. Dispatch\r\n" +
        "10/29/12 21:39:19\r\n" +
        "Case Dispatched\r\n" +
        "JGRUBB\r\n" +
        "REC\r\n" +
        "Unit Recommendation\r\n" +
        "10/29/12 21:39:25\r\n" +
        "Plan: EMSD Cat: EMS Lvl: 1\r\n" +
        "JREYNOL\r\n" +
        "PAG\r\n" +
        "Dispatch Page\r\n" +
        "10/29/12 21:39:26\r\n" +
        "Paged BASE1GR\r\n" +
        "PAGESRV\r\n" +
        "PAG\r\n" +
        "Dispatch Page\r\n" +
        "10/29/12 21:39:26\r\n" +
        "Paged ST6MASTER\r\n" +
        "PAGESRV\r\n" +
        "REC\r\n" +
        "Unit Recommendation\r\n" +
        "10/29/12 21:39:26\r\n" +
        "Recmnd:M10 [EMS],  TK62 [SQUAD]\r\n" +
        "JREYNOL\r\n" +
        "REC\r\n" +
        "Unit Recommendation\r\n" +
        "10/29/12 21:39:27\r\n" +
        "Plan: EMSD Cat: EMS Lvl: 1\r\n" +
        "JREYNOL\r\n" +
        "REC\r\n" +
        "Unit Recommendation\r\n" +
        "10/29/12 21:39:27\r\n" +
        "Recmnd:M10 [EMS],  TK62 [SQUAD]\r\n" +
        "JREYNOL\r\n" +
        "MPC\r\n" +
        "Med. Pri. Complete\r\n" +
        "10/29/12 21:39:35\r\n" +
        "Case Completed\r\n" +
        "JGRUBB\r\n" +
        "CHG\r\n" +
        "Changed\r\n" +
        "10/29/12 21:39:42\r\n" +
        "VERIZON WIRELESS â€‘â€‘> JOHNSON,\r\n" +
        "JGRUBB\r\n" +
        "CHG\r\n" +
        "Changed CallerAddress\r\n" +
        "10/29/12 21:39:43\r\n" +
        "784 MOUNT CARMEL â€‘ NE;LEX â€‘â€‘>\r\n" +
        "JGRUBB\r\n" +
        "ARM\r\n" +
        "Added Remarks\r\n" +
        "10/29/12 21:40:03\r\n" +
        "JGRUBB\r\n" +
        "ARM\r\n" +
        "Added Remarks\r\n" +
        "10/29/12 21:41:13\r\n" +
        "CBOWER\r\n" +
        "Page 2\r\n" +
        "\r\n" +
        "________________________________\r\n" +
        "If you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n" +
        "\r\n" +
        "Davidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n",

        "ID:2012231432",
        "CALL:RUN REPORT",
        "PLACE:Communications\nUser: RIPTSRV\n10/29/12 22:05:59\nEvent Report\nEvent ID:\n2012â€‘231432\nCall Ref #:\n483\nDate/Time Received:\n10/29/12 21:37:52\nService:\nRpt #:\n2012â€‘018633\nCall Source:\nE911\nPrime\n Unit:\nM10\n Services Involved\nLAW\nFIRE\nEMS\nLocation:\nXâ€‘ST:\n160 LOWES BLVD\nCOTTON GROVE RD\nFAIRVIEW DR\n3364030812\nJur:\nAgency:\nSt/Beat:\nDistrict:\nRA:\nBusiness:\nPhone:\nNature:\nAlarm Lvl:\nPriority:\nCaller:\nAddr:\nPhone:\nAlarm:\nAlarm Type:\nVehicle #:\nDC\nEMS\nEMS\nB1\nB1\nWALMART\n(336) 243â€‘5648\nP31â€‘UNCONSCIOUS/FAINTINGâ€‘A\n1\n4\nMedical Priority:\n31A03\nJOHNSON, JOHN\n(336) 403â€‘0812\nSt:\nReport Only:\nNo\n[Medical Priority Info] PROBLEM: employee feels faint   # PATS: 1   AGE: 21   SEX: Male\nCONSCIOUS: Yes   BREATHING: Yes  [10/29/12 21:38:51 JGRUBB]\n[Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Fainting episode(s) and alert < 35\n(without cardiac history).\n1. His breathing is completely normal.\n2. He is completely alert (responding appropriately).\n3. He is not changing color.\n4. He has no history of heart problems.  [10/29/12 21:39:16 JGRUBB]\nCOME TO THE BACK OF THE BUILDING AT THE FIRE DOOR SOMEONE WILL SHOW WHERE THE SUBJECT IS\n[10/29/12 21:40:03 JGRUBB]\n[LAW] LPD ADVISED  [10/29/12 21:41:13 CBOWERS]\nNotes:\n10/29/12 21:37:52\nTimes\nCall Received:\n10/29/12 21:39:17\nCall Routed:\n10/29/12 21:39:17\nCall Take Finished:\n10/29/12 21:39:26\n1st Dispatch:\n10/29/12 21:42:29\n1st Enâ€‘Route:\n10/29/12 21:51:11\n1st Arrive:\n10/29/12 22:05:53\nLast Clear:\nTime From Call Received\n000:01:25\n000:01:25\n000:01:34\n000:04:37\n000:13:19\n000:28:01\nUnit Reaction:\nEnâ€‘Route:\nOnâ€‘Scene:\n000:11:45\n(1st Dispatch to 1st Arrive)\n000:03:03\n000:14:42\n(1st Dispatch to 1st Enâ€‘Route)\n(1st Arrive to Last Clear)\n(Time Held)\n(Reaction Time)\nGeoâ€‘Verified Addr.:\nYes\nNature Summary Code:\nDisposition:\nClose Comments:\nREF\nRace:\nSex:\nAge:\n:\nJGRUBB\nCall Taker:\nCAD9\nConsole:\n1685\nGP:\nUnit\nType\nDescription\nTime Stamp\nComments\nClose\nCode\nUser\nRadio Log\nEmpl ID\nPage 1\nEvent ID:\n2012â€‘231432\nCall Ref #:\n483\nP31â€‘UNCONSCIOUS/FAINTINGâ€‘ALPHA at 160 LOWES BLVD\nUnit\nType\nDescription\nTime Stamp\nComments\nClose\nCode\nUser\nRadio Log\nEmpl ID\nM10\nD\nDispatched\n10/29/12 21:39:26\nStat/Beat: B1\nJREYNOL\n0\nTK62\nD\nDispatched\n10/29/12 21:39:26\nStat/Beat: ST6\nJREYNOL\n0\nTK62\nC\nCleared\n10/29/12 21:40:58\nCAN\nJREYNOL\nCAN\n0\nM10\nE\nEnâ€‘Route\n10/29/12 21:42:29\nJREYNOL\n0\nM10\nA\nArrived\n10/29/12 21:51:11\nJREYNOL\n0\nM10\nC\nCleared\n10/29/12 22:05:53\nJGRUBB\nREF\n0\nUnit\nType\nDescription\nTime Stamp\nComments\nClose\nCode\nUser\nEvent Log\nEmpl ID\nTR\nTime Received\n10/29/12 21:37:52\nBy: E911\nJGRUBB\nENT\nEntered Street\n10/29/12 21:37:52\n784 MOUNT CARMEL â€‘ NE;LEX\nJGRUBB\nCHG\nChanged Street\n10/29/12 21:38:03\n784 MOUNT CARMEL â€‘ NE;LEX â€‘â€‘> 160\nJGRUBB\nENT\nEntered Nature\n10/29/12 21:38:17\nMEDICAL CALL PROQA LAUNCH\nJGRUBB\nMPS\nMed. Pri. Started\n10/29/12 21:38:17\nCase Started\nJGRUBB\nARM\nAdded Remarks\n10/29/12 21:38:51\nJGRUBB\nMPF\nMed. Pri. CE Finished\n10/29/12 21:38:52\nCase Entry Finished\nJGRUBB\nARM\nAdded Remarks\n10/29/12 21:39:16\nJGRUBB\nCHG\nP31â€‘UNCONSCIOUS/F\n10/29/12 21:39:17\nChanged nature\nJGRUBB\nFIN\nFinished Call Taking\n10/29/12 21:39:17\nJGRUBB\nRPT\nRequested Report#\n10/29/12 21:39:17\nEMS Report #2012â€‘018633\nJGRUBB\nSP\nSpawned\n10/29/12 21:39:17\nSpawned LAW event #2012231434\nJGRUBB\nSP\nSpawned\n10/29/12 21:39:17\nSpawned FIRE event #2012231435\nJGRUBB\nMPD\nMed. Pri. Dispatch\n10/29/12 21:39:19\nCase Dispatched\nJGRUBB\nREC\nUnit Recommendation\n10/29/12 21:39:25\nPlan: EMSD Cat: EMS Lvl: 1\nJREYNOL\nPAG\nDispatch Page\n10/29/12 21:39:26\nPaged BASE1GR\nPAGESRV\nPAG\nDispatch Page\n10/29/12 21:39:26\nPaged ST6MASTER\nPAGESRV\nREC\nUnit Recommendation\n10/29/12 21:39:26\nRecmnd:M10 [EMS],  TK62 [SQUAD]\nJREYNOL\nREC\nUnit Recommendation\n10/29/12 21:39:27\nPlan: EMSD Cat: EMS Lvl: 1\nJREYNOL\nREC\nUnit Recommendation\n10/29/12 21:39:27\nRecmnd:M10 [EMS],  TK62 [SQUAD]\nJREYNOL\nMPC\nMed. Pri. Complete\n10/29/12 21:39:35\nCase Completed\nJGRUBB\nCHG\nChanged\n10/29/12 21:39:42\nVERIZON WIRELESS â€‘â€‘> JOHNSON,\nJGRUBB\nCHG\nChanged CallerAddress\n10/29/12 21:39:43\n784 MOUNT CARMEL â€‘ NE;LEX â€‘â€‘>\nJGRUBB\nARM\nAdded Remarks\n10/29/12 21:40:03\nJGRUBB\nARM\nAdded Remarks\n10/29/12 21:41:13\nCBOWER\nPage 2\n\n________________________________\nIf you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\n\nDavidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us");

    doTest("T3",
        "(Dispatch Report Incident #2012231432) Dispatch\r\n" +
        "Communications\r\n" +
        "Address:\r\n" +
        "Cross:\r\n" +
        "160 LOWES BLVD\r\n" +
        "COTTON GROVE RD\r\n" +
        "FAIRVIEW DR\r\n" +
        "Nature:\r\n" +
        "P31â€‘UNCONSCIOUS/FAINTINGâ€‘ALPHA\r\n" +
        "MP:\r\n" +
        "31A03\r\n" +
        "Date:\r\n" +
        "10/29/12\r\n" +
        "Time Out:\r\n" +
        "21:39\r\n" +
        "City:\r\n" +
        "LEX\r\n" +
        "10/29/2012 14:47 1086 â€‘ LARCENY/SHOPLIFTING\r\n" +
        "10/29/2012 09:37 1086 â€‘ LARCENY/SHOPLIFTING\r\n" +
        "10/28/2012 16:27 1037â€‘DISTURBANCE\r\n" +
        "10/28/2012 13:25 50PDâ€‘MOTOR VEH/PD ONLY\r\n" +
        "10/28/2012 13:24 50PDâ€‘MOTOR VEH/PD ONLY\r\n" +
        "10/28/2012 12:34 FORGERY/FRAUD\r\n" +
        "10/27/2012 17:00 1086 â€‘ LARCENY/SHOPLIFTING\r\n" +
        "10/27/2012 15:09 1063â€‘INVESTIGATE/SUPPLEMENTAL\r\n" +
        "10/27/2012 12:22 1063â€‘INVESTIGATE/SUPPLEMENTAL\r\n" +
        "10/26/2012 23:22 1037â€‘DISTURBANCE\r\n" +
        "NOTIFICATION OF THE HEALTH DEPT. MAY BE NEEDED AND\r\n" +
        "REQUESTED BY THE FIRE DEPT.HERE IS THE CALL ORDER IF SUCH A\r\n" +
        "REQUEST IS MADE.\r\n" +
        "1.  JOHN HENDREN  240â€‘0246\r\n" +
        "2.  GREG HENNESSEE  787â€‘3690 OR 240â€‘0263\r\n" +
        "3.  ANGELA PINYAN  775â€‘1071 OR 749â€‘3756\r\n" +
        "4.  LILLIAN BARFIELD 252â€‘299â€‘0609\r\n" +
        "5.  DEBRA HARMON 250â€‘9147\r\n" +
        "6.  IF CAN`T GET ANYONE ABOVE CALL 242â€‘2310,\r\n" +
        "     LEAVE A MESSAGE AND IT WILL ALERT ONâ€‘CALL\r\n" +
        "Hot Spot:\r\n" +
        "Premise:\r\n" +
        "WALMART\r\n" +
        "Business:\r\n" +
        "Addt Address:\r\n" +
        "3364030812\r\n" +
        "[Medical Priority Info] PROBLEM: employee feels faint   # PATS: 1   AGE: 21\r\n" +
        "SEX: Male   CONSCIOUS: Yes   BREATHING: Yes  [10/29/12 21:38:51\r\n" +
        "JGRUBB]\r\n" +
        "[Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Fainting\r\n" +
        "episode(s) and alert < 35 (without cardiac history).\r\n" +
        "1. His breathing is completely normal.\r\n" +
        "2. He is completely alert (responding appropriately).\r\n" +
        "3. He is not changing color.\r\n" +
        "4. He has no history of heart problems.  [10/29/12 21:39:16 JGRUBB]\r\n" +
        "Notes:\r\n" +
        "Dispatch\r\n" +
        "Communications\r\n" +
        "M10, TK62\r\n" +
        "CITY OF LEXINGTON\r\n" +
        "Units:\r\n" +
        "Street Notes:\r\n" +
        "END\r\n" +
        "\r\n" +
        "________________________________\r\n" +
        "If you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n" +
        "\r\n" +
        "Davidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n",

        "ID:2012231432",
        "ADDR:160 LOWES BLVD",
        "X:COTTON GROVE RD & FAIRVIEW DR",
        "CODE:P31",
        "CALL:UNCONSCIOUS/FAINTING",
        "PRI:ALPHA",
        "MAP:31A03",
        "DATE:10/29/12",
        "TIME:21:39",
        "CITY:LEXINGTON");

    doTest("T4",
        "(Dispatch Report Incident #2012231406) Dispatch\r\n" +
        "Communications\r\n" +
        "Address:\r\n" +
        "Cross:\r\n" +
        "250 HOSPITAL DR\r\n" +
        "W MEDICAL PARK DR\r\n" +
        "Nature:\r\n" +
        "P33Aâ€‘TRANSFER/INTERFACâ€‘ALPHA\r\n" +
        "Date:\r\n" +
        "10/29/12\r\n" +
        "Time Out:\r\n" +
        "20:55\r\n" +
        "City:\r\n" +
        "LEX\r\n" +
        "10/29/2012 08:11 1063â€‘INVESTIGATE/SUPPLEMENTAL\r\n" +
        "10/28/2012 16:55 1063â€‘INVESTIGATE/SUPPLEMENTAL\r\n" +
        "10/28/2012 15:02 1086 â€‘ LARCENY/SHOPLIFTING\r\n" +
        "10/28/2012 12:11 1073â€‘MENTAL SUBJECT\r\n" +
        "10/28/2012 10:48 1073â€‘MENTAL SUBJECT\r\n" +
        "10/28/2012 04:33 1063â€‘INVESTIGATE/SUPPLEMENTAL\r\n" +
        "10/28/2012 01:00 1037â€‘DISTURBANCE\r\n" +
        "10/26/2012 22:25 1073��€‘MENTAL SUBJECT\r\n" +
        "10/26/2012 16:21 1073â€‘MENTAL SUBJECT\r\n" +
        "NOTIFICATION OF THE HEALTH DEPT. MAY BE NEEDED AND\r\n" +
        "REQUESTED BY THE FIRE DEPT.HERE IS THE CALL ORDER IF SUCH A\r\n" +
        "REQUEST IS MADE.\r\n" +
        "1.  JOHN HENDREN  240â€‘0246\r\n" +
        "2.  GREG HENNESSEE  787â€‘3690 OR 240â€‘0263\r\n" +
        "3.  ANGELA PINYAN  775â€‘1071 OR 749â€‘3756\r\n" +
        "4.  LILLIAN BARFIELD 252â€‘299â€‘0609\r\n" +
        "5.  DEBRA HARMON 250â€‘9147\r\n" +
        "6.  IF CAN`T GET ANYONE ABOVE CALL 242â€‘2310,\r\n" +
        "     LEAVE A MESSAGE AND IT WILL ALERT ONâ€‘CALL\r\n" +
        "M11\r\n" +
        "Hot Spot:\r\n" +
        "Premise:\r\n" +
        "Units:\r\n" +
        "LMC LEXINGTON MEDICAL CENTER\r\n" +
        "Business:\r\n" +
        "Addt Address:\r\n" +
        "ICU 641\r\n" +
        "GOING TO NCBH CCU BED 4, IV, O2, MONITOR  [10/29/12 20:52:14 JCOX]\r\n" +
        "Notes:\r\n" +
        "END\r\n" +
        "\r\n" +
        "________________________________\r\n" +
        "If you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n" +
        "\r\n" +
        "Davidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n",

        "ID:2012231406",
        "ADDR:250 HOSPITAL DR",
        "X:W MEDICAL PARK DR",
        "CODE:P33A",
        "CALL:TRANSFER/INTERFAC",
        "PRI:ALPHA",
        "DATE:10/29/12",
        "TIME:20:55",
        "CITY:LEXINGTON");

    doTest("T5",
        "(Dispatch Report Incident #2012231334) Dispatch\r\n" +
        "Communications\r\n" +
        "Address:\r\n" +
        "Cross:\r\n" +
        "17 CORNELIA ST\r\n" +
        "N TALBERT BLVD\r\n" +
        "RALEIGH RD\r\n" +
        "Nature:\r\n" +
        "P31â€‘UNCONSCIOUS/FAINTINGâ€‘DELTA\r\n" +
        "MP:\r\n" +
        "31D03\r\n" +
        "Date:\r\n" +
        "10/29/12\r\n" +
        "Time Out:\r\n" +
        "18:36\r\n" +
        "City:\r\n" +
        "LEX\r\n" +
        "NOTIFICATION OF THE HEALTH DEPT. MAY BE NEEDED AND\r\n" +
        "REQUESTED BY THE FIRE DEPT.HERE IS THE CALL ORDER IF SUCH A\r\n" +
        "REQUEST IS MADE.\r\n" +
        "1.  JOHN HENDREN  240â€‘0246\r\n" +
        "2.  GREG HENNESSEE  787â€‘3690 OR 240â€‘0263\r\n" +
        "3.  ANGELA PINYAN  775â€‘1071 OR 749â€‘3756\r\n" +
        "4.  LILLIAN BARFIELD 252â€‘299â€‘0609\r\n" +
        "5.  DEBRA HARMON 250â€‘9147\r\n" +
        "6.  IF CAN`T GET ANYONE ABOVE CALL 242â€‘2310,\r\n" +
        "     LEAVE A MESSAGE AND IT WILL ALERT ONâ€‘CALL\r\n" +
        "M10, ST6B\r\n" +
        "CITY OF LEXINGTON\r\n" +
        "Premise:\r\n" +
        "Units:\r\n" +
        "Street Notes:\r\n" +
        "LEXINGTON HEALTH CARE\r\n" +
        "Business:\r\n" +
        "Addt Address:\r\n" +
        "3RD HUNT\r\n" +
        "[Medical Priority Info] PROBLEM: patient changes in level of conciousness   #\r\n" +
        "PATS: 1   AGE: 78   SEX: Female   CONSCIOUS: Yes   BREATHING: Yes\r\n" +
        "[10/29/12 18:36:21 JGRUBB]\r\n" +
        "[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Not alert.\r\n" +
        "1. Her breathing is not completely normal.\r\n" +
        "2. She is not completely alert (not responding appropriately).\r\n" +
        "3. She is changing color.\r\n" +
        "4. Her color change is pale.  [10/29/12 18:36:36 JGRUBB]\r\n" +
        "[Medical Priority Info] Key Questions Complete RESPONSE: Delta\r\n" +
        "RESPONDER SCRIPT:\r\n" +
        "5. She has a history of heart problems.  [10/29/12 18:36:42 JGRUBB]\r\n" +
        "Notes:\r\n" +
        "END\r\n" +
        "\r\n" +
        "________________________________\r\n" +
        "If you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n" +
        "\r\n" +
        "Davidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n",

        "ID:2012231334",
        "ADDR:17 CORNELIA ST",
        "X:N TALBERT BLVD & RALEIGH RD",
        "CODE:P31",
        "CALL:UNCONSCIOUS/FAINTING",
        "PRI:DELTA",
        "MAP:31D03",
        "DATE:10/29/12",
        "TIME:18:36",
        "CITY:LEXINGTON");

    doTest("T6",
        "(Dispatch Report Incident #2012231288) Dispatch\r\n" +
        "Communications\r\n" +
        "Address:\r\n" +
        "Cross:\r\n" +
        "890 STRATFORD RD\r\n" +
        "NAT CONRAD RD\r\n" +
        "EMBLER RD\r\n" +
        "Nature:\r\n" +
        "P6â€‘BREATHING PROBLEMSâ€‘DELTA\r\n" +
        "MP:\r\n" +
        "06D02\r\n" +
        "Date:\r\n" +
        "10/29/12\r\n" +
        "Time Out:\r\n" +
        "17:26\r\n" +
        "City:\r\n" +
        "LEX\r\n" +
        "M10, M2, ST6\r\n" +
        "NAT CONRAD RD OFF OF HOLLY GROVE RD WEST THEN LEFT ONTO\r\n" +
        "STRATFORD RD\r\n" +
        "KINGS GRANT SUBD\r\n" +
        "Units:\r\n" +
        "Street Notes:\r\n" +
        "Business:\r\n" +
        "[Medical Priority Info] PROBLEM: cant breathe   # PATS: 1   AGE: 67   SEX:\r\n" +
        "Male   CONSCIOUS: Yes   BREATHING: Yes  [10/29/12 17:23:26 TPAINTER]\r\n" +
        "[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: DIFFICULTY\r\n" +
        "SPEAKING BETWEEN BREATHS.\r\n" +
        "1. He is completely alert (responding appropriately).\r\n" +
        "2. He has difficulty speaking between breaths.  [10/29/12 17:23:38 TPAINTER]\r\n" +
        "[Medical Priority Info] Key Questions Complete RESPONSE: Delta\r\n" +
        "RESPONDER SCRIPT:\r\n" +
        "3. He is not changing color.\r\n" +
        "4. He is clammy.\r\n" +
        "5. He does not have asthma.\r\n" +
        "6. N/A  [10/29/12 17:23:52 TPAINTER]\r\n" +
        "Notes:\r\n" +
        "END\r\n" +
        "\r\n" +
        "________________________________\r\n" +
        "If you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n" +
        "\r\n" +
        "Davidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n",

        "ID:2012231288",
        "ADDR:890 STRATFORD RD",
        "X:NAT CONRAD RD & EMBLER RD",
        "CODE:P6",
        "CALL:BREATHING PROBLEMS",
        "PRI:DELTA",
        "MAP:06D02",
        "DATE:10/29/12",
        "TIME:17:26",
        "CITY:LEXINGTON");

    doTest("T7",
        "(Dispatch Report Incident #2012231282) Dispatch\r\n" +
        "Communications\r\n" +
        "Address:\r\n" +
        "Cross:\r\n" +
        "164 WINTERBERRY DR\r\n" +
        "E HOLLY GROVE RD\r\n" +
        "Nature:\r\n" +
        "P17â€‘FALLâ€‘CHARLIE\r\n" +
        "MP:\r\n" +
        "17B03\r\n" +
        "Date:\r\n" +
        "10/29/12\r\n" +
        "Time Out:\r\n" +
        "17:18\r\n" +
        "City:\r\n" +
        "THA\r\n" +
        "M10, TK52\r\n" +
        "ON THE N SIDE OF E HOLLY GROVE RD APPROX .34M E OF\r\n" +
        "CEDARLAND DR\r\n" +
        "Units:\r\n" +
        "Street Notes:\r\n" +
        "Business:\r\n" +
        "[Medical Priority Info] PROBLEM: Fall   # PATS: 1   AGE: 72   SEX: Male\r\n" +
        "CONSCIOUS: Yes   BREATHING: Yes  [10/29/12 17:17:10 CPAYNE]\r\n" +
        "[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Unknown\r\n" +
        "status/Other codes not applicable  (On the ground or floor).\r\n" +
        "1. This happened now (less than 6hrs ago).\r\n" +
        "2. It`s not known how far he fell.\r\n" +
        "3. The reason for the fall is not known.\r\n" +
        "4. It`s not known if there is SERIOUS bleeding.\r\n" +
        "5. He is completely alert (responding appropriately).\r\n" +
        "6. The extent of his injuries is not known.\r\n" +
        "7. He is still on the floor (ground).  [10/29/12 17:17:58 CPAYNE]\r\n" +
        "Notes:\r\n" +
        "END\r\n" +
        "\r\n" +
        "________________________________\r\n" +
        "If you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n" +
        "\r\n" +
        "Davidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n",

        "ID:2012231282",
        "ADDR:164 WINTERBERRY DR",
        "X:E HOLLY GROVE RD",
        "CODE:P17",
        "CALL:FALL",
        "PRI:CHARLIE",
        "MAP:17B03",
        "DATE:10/29/12",
        "TIME:17:18",
        "CITY:THOMASVILLE");

    doTest("T8",
        "(Dispatch Report Incident #2012231255) Dispatch\r\n" +
        "Communications\r\n" +
        "Address:\r\n" +
        "Cross:\r\n" +
        "1041â€‘7 NOAHTOWN RD\r\n" +
        "FANNIE PULLUM RD\r\n" +
        "LAUREL DR\r\n" +
        "Nature:\r\n" +
        "EMSâ€‘PUBLIC SERVICE\r\n" +
        "MP:\r\n" +
        "69D10\r\n" +
        "Date:\r\n" +
        "10/29/12\r\n" +
        "Time Out:\r\n" +
        "16:45\r\n" +
        "City:\r\n" +
        "THA\r\n" +
        "M1C, M20, SRU1\r\n" +
        "ON E SIDE OF NEW HWY 109â€‘N ACROSS MT ZION CHURCH RD INT THEN\r\n" +
        "(RUNS BETWEEN NEW HWY 109 AND BLACKBERRY RD)\r\n" +
        "Units:\r\n" +
        "Street Notes:\r\n" +
        "Business:\r\n" +
        "Event spawned from P69D10â€‘HOUSE/MH/PORT OFC.  [10/29/2012 16:43:05\r\n" +
        "BSTOSS]\r\n" +
        "dog stuck in res on fire  [10/29/12 16:34:25 TPAINTER]\r\n" +
        "[Fire Priority Info] PROBLEM: house fire  [10/29/12 16:34:36 TPAINTER]\r\n" +
        "[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT:   0 Mobile home,\r\n" +
        "house trailer, portable office.\r\n" +
        "1. The caller is on scene (1st party).\r\n" +
        "2. Both smoke and flames are visible.\r\n" +
        "3. The incident involves a mobile home.\r\n" +
        "4. A singleâ€‘level structure is involved.\r\n" +
        "5. The caller has not indicated that there are trapped person(s).  [10/29/12\r\n" +
        "16:34:48 TPAINTER]\r\n" +
        "[Fire Priority Info] Key Questions Complete RESPONSE: Delta   RESPONDER\r\n" +
        "SCRIPT:\r\n" +
        "6. No one is trapped inside the structure.\r\n" +
        "7. No one is reported to be injured.  [10/29/12 16:34:52 TPAINTER]\r\n" +
        "DOG TRAPPED IN RES UNABLE TO GET HIM OUT  [10/29/12 16:35:03\r\n" +
        "TPAINTER]\r\n" +
        "CALLER HUNG UP AFTER TELLING ME IT WAS ON FIRE AND HIS DOG\r\n" +
        "WAS INSIDE  [10/29/12 16:35:19 TPAINTER]\r\n" +
        "[LAW] DCSO ADV  [10/29/12 16:37:04 CPAYNE]\r\n" +
        "UDTS: Co Fire Tac3 for call  [10/29/12 16:38:06 BSTOSS]\r\n" +
        "692 ENR  [10/29/12 16:39:16 BSTOSS]\r\n" +
        "3243 ON SCENE SMOKE SHOWING  [10/29/12 16:41:55 BSTOSS]\r\n" +
        "2843 WORKING FIRE  [10/29/12 16:42:45 BSTOSS]\r\n" +
        "[FIRE] UDTS: {ENG43} working fire  [10/29/12 16:44:07 JEVERHART]\r\n" +
        "Notes:\r\n" +
        "END\r\n" +
        "\r\n" +
        "________________________________\r\n" +
        "If you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n" +
        "\r\n" +
        "Davidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n",

        "ID:2012231255",
        "ADDR:1041-7 NOAHTOWN RD",
        "MADDR:1041 NOAHTOWN RD",
        "X:FANNIE PULLUM RD & LAUREL DR",
        "CODE:EMS",
        "CALL:PUBLIC SERVICE",
        "MAP:69D10",
        "DATE:10/29/12",
        "TIME:16:45",
        "CITY:THOMASVILLE");

    doTest("T9",
        "(Dispatch Report Incident #2012231244) Dispatch\r\n" +
        "Communications\r\n" +
        "Address:\r\n" +
        "Cross:\r\n" +
        "200 HELEN YOUNG DR\r\n" +
        "CHARITY LN\r\n" +
        "BIG`UN DR\r\n" +
        "Nature:\r\n" +
        "P1â€‘ABDOMINAL PAINSâ€‘ALPHA\r\n" +
        "MP:\r\n" +
        "01A01\r\n" +
        "Date:\r\n" +
        "10/29/12\r\n" +
        "Time Out:\r\n" +
        "16:35\r\n" +
        "City:\r\n" +
        "LIN\r\n" +
        "M11, ST7\r\n" +
        "PVT RDâ€‘â€‘â€‘N SIDE OF CHARITY LN .1M W OF OLD WESLEY CHAPEL RD\r\n" +
        "Units:\r\n" +
        "Street Notes:\r\n" +
        "Business:\r\n" +
        "[Medical Priority Info] PROBLEM: abdominal pains, vomitting   # PATS: 1\r\n" +
        "AGE: 38   SEX: Female   CONSCIOUS: Yes   BREATHING: Yes  [10/29/12\r\n" +
        "16:34:58 CPAYNE]\r\n" +
        "[Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Abdominal\r\n" +
        "pain.\r\n" +
        "1. She is completely alert (responding appropriately).\r\n" +
        "2. There was no mention of existing aortic aneurysm.\r\n" +
        "3. She has not fainted or nearly fainted.  [10/29/12 16:35:15 CPAYNE]\r\n" +
        "Notes:\r\n" +
        "END\r\n" +
        "\r\n" +
        "________________________________\r\n" +
        "If you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n" +
        "\r\n" +
        "Davidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n",

        "ID:2012231244",
        "ADDR:200 HELEN YOUNG DR",
        "X:CHARITY LN & BIG`UN DR",
        "CODE:P1",
        "CALL:ABDOMINAL PAINS",
        "PRI:ALPHA",
        "MAP:01A01",
        "DATE:10/29/12",
        "TIME:16:35",
        "CITY:LINWOOD");

    doTest("T10",
        "(Dispatch Report Incident #2012231193) Dispatch\r\n" +
        "Communications\r\n" +
        "Address:\r\n" +
        "Cross:\r\n" +
        "217 SANTA FE CIR\r\n" +
        "CORAL LN\r\n" +
        "FLAGSTONE CT\r\n" +
        "Nature:\r\n" +
        "P6â€‘BREATHING PROBLEMSâ€‘CHARLIE\r\n" +
        "MP:\r\n" +
        "06C01\r\n" +
        "Date:\r\n" +
        "10/29/12\r\n" +
        "Time Out:\r\n" +
        "15:41\r\n" +
        "City:\r\n" +
        "THA\r\n" +
        "M10, M6, TK51\r\n" +
        "PVT RDâ€‘â€‘â€‘S SIDE OF LEXINGTON AV BETWEEN BECK RD AND MT.\r\n" +
        "CALVARY RD.\r\n" +
        "BEGIN OFF LEXINGTON AV AT 1407\r\n" +
        "MILLSTONE MANOR\r\n" +
        "Units:\r\n" +
        "Street Notes:\r\n" +
        "Business:\r\n" +
        "[Medical Priority Info] PROBLEM: med alarm    # PATS: 1   AGE: 83   SEX:\r\n" +
        "Female   CONSCIOUS: Yes   BREATHING: Yes  [10/29/12 15:36:46\r\n" +
        "TPAINTER]\r\n" +
        "[Medical Priority Info] PROBLEM: med alarm    # PATS: 1   AGE: 83   SEX:\r\n" +
        "Female   CONSCIOUS: Yes   BREATHING: Yes  [10/29/12 15:36:50\r\n" +
        "TPAINTER]\r\n" +
        "[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Abnormal\r\n" +
        "breathing.\r\n" +
        "1. It`s not known if she is completely alert (responding appropriately).\r\n" +
        "2. It`s not known if she has difficulty speaking between breaths.\r\n" +
        "3. It`s not known if she is changing color.\r\n" +
        "4. It`s not known if she is clammy.\r\n" +
        "5. It`s not known if she has asthma.\r\n" +
        "6. It`s not known if she has any special equipment or instructions to treat this.\r\n" +
        "[10/29/12 15:37:16 TPAINTER]\r\n" +
        "Notes:\r\n" +
        "END\r\n" +
        "\r\n" +
        "________________________________\r\n" +
        "If you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n" +
        "\r\n" +
        "Davidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n",

        "ID:2012231193",
        "ADDR:217 SANTA FE CIR",
        "X:CORAL LN & FLAGSTONE CT",
        "CODE:P6",
        "CALL:BREATHING PROBLEMS",
        "PRI:CHARLIE",
        "MAP:06C01",
        "DATE:10/29/12",
        "TIME:15:41",
        "CITY:THOMASVILLE");

    doTest("T11",
        "(Dispatch Report Incident #2012232025) Dispatch\r\n" +
        "Communications\r\n" +
        "Address:\r\n" +
        "Cross:\r\n" +
        "7 NATIONAL HWY\r\n" +
        "COUNCIL ST\r\n" +
        "E GUILFORD ST\r\n" +
        "Nature:\r\n" +
        "P33Aâ€‘TRANSFER/INTERFACâ€‘ALPHA\r\n" +
        "Date:\r\n" +
        "10/30/12\r\n" +
        "Time Out:\r\n" +
        "19:37\r\n" +
        "City:\r\n" +
        "THA\r\n" +
        "DR601, M20, TK53\r\n" +
        " FROM SALEM ST IN THE CITY NE TO COUNTY LINE\r\n" +
        " THE FOOD LION SHOPPING CENTER IS OUT OF SEQUENCE IS JUST N\r\n" +
        "OF HASTY SCHOOL RD AND ACROSS FROM THE LOWE`S SHOPPING\r\n" +
        "CENTER.  WILL BE IN THE CITY\r\n" +
        "Units:\r\n" +
        "Street Notes:\r\n" +
        "Business:\r\n" +
        "routine transfer hospice house lexington 100 hospice way pos oxygen needed\r\n" +
        "adv of wait for dr601  [10/30/12 18:24:26 JREYNOLDS]\r\n" +
        "Notes:\r\n" +
        "END\r\n" +
        "\r\n" +
        "________________________________\r\n" +
        "If you are not the intended recipient, you must destroy this message and inform the sender immediately. This electronic mail message and any attachments, as well as any electronic mail message(s) sent in response to it may be considered public record and as such subject to request and review by anyone at any time. It also may contain information which is confidential within the meaning of applicable federal and state laws.\r\n" +
        "\r\n" +
        "Davidson County Government, PO Box 1067, Lexington, NC, USA, www.co.davidson.nc.us\r\n",

        "ID:2012232025",
        "ADDR:7 NATIONAL HWY",
        "X:COUNCIL ST & E GUILFORD ST",
        "CODE:P33A",
        "CALL:TRANSFER/INTERFAC",
        "PRI:ALPHA",
        "DATE:10/30/12",
        "TIME:19:37",
        "CITY:THOMASVILLE");
   

  }
  
  public static void main(String[] args) {
    new NCDavidsonCountyBParserTest().generateTests("T1");
  }
}
