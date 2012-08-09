package net.anei.cadpage.parsers;

import static org.junit.Assert.*;

import org.junit.Test;

public class MessageTest {
  
  @Test
  public void testParseInfo() {
    
    doParseTest("COGarfileCounty",
        "ken@cadpage.org",
        "[1/2] CAD Page",
        "1/2\n\nEBreathing Difficulty Location  Colorado State Veterians Nursing Home851 E  5TH ST RIF RM 142",
        "ken@cadpage.org",
        "[1/2] CAD Page",
        "EBreathing Difficulty Location  Colorado State Veterians Nursing Home851 E  5TH ST RIF RM 142",
        1, 2);
    
    doParseTest("PAGloucesterCountyB",
        "ken@cadpage.org",
        "FW: Automatic R&R Notification",
        "  \r\n\r\n-----Original Message-----\r\nFrom: SPTETI@S105KD4M.CO.GLOUCESTER.NJ.US\r\n[mailto:SPTETI@S105KD4M.CO.GLOUCESTER.NJ.US] \r\nSent: Sunday, August 05, 2012 10:23 PM\r\nTo: sta281@co.gloucester.nj.us\r\nSubject: Automatic R&R Notification\r\nImportance: High\r\n\r\n\r\n  \r\n** ** ** ** ** ** ** ** ** ** ** ** FINAL REPORT ** ** ** ** ** ** ** ** **\r\n** ** **  \r\nIncident Number  : 2012-00027701                    ORI: 081528\r\nStation: 28-8  \r\nIncident Type  . : WIRE F WIRES                Priority: 3  \r\nIncident Location: 142 WOODLYNNE AVE\r\nVenue: PITMAN \r\n\r\nCall Time- 21:44:22                                Date- 08/05/2012  \r\nDispatch - 21:57:24     En-route- 22:05:55     On-scene- 22:12:16     Depart\r\n1-  \r\nArrive 2 -              Depart 2-              In-statn-\r\nCleared - 22:23:09 \r\n\r\nArea:    O              Section :    O         Beat  . :    O  \r\nGrid:  K16              Quadrant: 2802         District: 2802 \r\n\r\nPhone Number: (267) 615-8335                Call Source:  589 \r\n\r\nCaller. . . : SHARON \r\n\r\nNature of Call : 142 WOODLYNNE AVE \r\n\r\nAdditional Info\r\n  LARGE TREE ACROSS ROADWAY / POWER NOW OUT IN\r\n  THE AREA / BELIEVES KNOCKED DOWN WIRES ALSO \r\n\r\nNarrative\r\n Information on the units assigned to the call follows.  \r\n    Unit: FP28    Radio:           Ofcr 1:            Ofcr 2:  \r\n       DSP: 08/05/12  21:57:24     ENR: 08/05/12  22:05:55  \r\n       ARV: 08/05/12  22:12:16     DPT:             :  :  \r\n       QTR:             :  :       CLR: 08/05/12  22:23:09  \r\n    Unit: 28-1    Radio:           Ofcr 1:            Ofcr 2:  \r\n       DSP: 08/05/12  21:45:15     ENR: 08/05/12  21:49:51  \r\n       ARV:             :  :       DPT:             :  :  \r\n       QTR:             :  :       CLR: 08/05/12  22:23:09  \r\n The following Incidents have been linked:                    21:45:37  \r\n  081528 2012-00027702 EK, 0815281 2012-00027701 CB           21:45:37  \r\n 2800 IS IN THE AREA                               SPTETI     21:49:42  \r\n R 2811                                            WEHOLMSTRO 21:49:56  \r\n O 28302                                           WEHOLMSTRO 21:49:59  \r\n PN BT726PJ                                        SPTETI     21:50:39  \r\n IFO OF 142 WOODLYNNE                              SPTETI     21:50:54  \r\n PN21206                                           SPTETI     21:56:41  \r\n ACW3E                                             SPTETI     21:56:51  \r\n  ACE                                              SPTETI     21:56:52  \r\n ACE NOTIFIED                                      SPTETI     21:57:05  \r\n PER 2800 DISPATCH FIRE POLICE                     SPTETI     21:57:16  \r\n R 2819                                            SPTETI     22:05:50  \r\n 2802 IS RESPONDING WITH THE BARRICADES            SPTETI     22:11:46  \r\n C FP28                                            SPTETI     22:23:03 \r\n\r\nThe Call Taker is BREYER MICHAEL R\r\nThe Dispatcher is DAVIS ELLIOT SCOTT\r\n\r\n\n",
        "SPTETI@S105KD4M.CO.GLOUCESTER.NJ.US",
        "Automatic R&R Notification",
        "** ** ** ** ** ** ** ** ** ** ** ** FINAL REPORT ** ** ** ** ** ** ** ** **\n** ** **  \nIncident Number  : 2012-00027701                    ORI: 081528\nStation: 28-8  \nIncident Type  . : WIRE F WIRES                Priority: 3  \nIncident Location: 142 WOODLYNNE AVE\nVenue: PITMAN \n\nCall Time- 21:44:22                                Date- 08/05/2012  \nDispatch - 21:57:24     En-route- 22:05:55     On-scene- 22:12:16     Depart\n1-  \nArrive 2 -              Depart 2-              In-statn-\nCleared - 22:23:09 \n\nArea:    O              Section :    O         Beat  . :    O  \nGrid:  K16              Quadrant: 2802         District: 2802 \n\nPhone Number: (267) 615-8335                Call Source:  589 \n\nCaller. . . : SHARON \n\nNature of Call : 142 WOODLYNNE AVE \n\nAdditional Info\n  LARGE TREE ACROSS ROADWAY / POWER NOW OUT IN\n  THE AREA / BELIEVES KNOCKED DOWN WIRES ALSO \n\nNarrative\n Information on the units assigned to the call follows.  \n    Unit: FP28    Radio:           Ofcr 1:            Ofcr 2:  \n       DSP: 08/05/12  21:57:24     ENR: 08/05/12  22:05:55  \n       ARV: 08/05/12  22:12:16     DPT:             :  :  \n       QTR:             :  :       CLR: 08/05/12  22:23:09  \n    Unit: 28-1    Radio:           Ofcr 1:            Ofcr 2:  \n       DSP: 08/05/12  21:45:15     ENR: 08/05/12  21:49:51  \n       ARV:             :  :       DPT:             :  :  \n       QTR:             :  :       CLR: 08/05/12  22:23:09  \n The following Incidents have been linked:                    21:45:37  \n  081528 2012-00027702 EK, 0815281 2012-00027701 CB           21:45:37  \n 2800 IS IN THE AREA                               SPTETI     21:49:42  \n R 2811                                            WEHOLMSTRO 21:49:56  \n O 28302                                           WEHOLMSTRO 21:49:59  \n PN BT726PJ                                        SPTETI     21:50:39  \n IFO OF 142 WOODLYNNE                              SPTETI     21:50:54  \n PN21206                                           SPTETI     21:56:41  \n ACW3E                                             SPTETI     21:56:51  \n  ACE                                              SPTETI     21:56:52  \n ACE NOTIFIED                                      SPTETI     21:57:05  \n PER 2800 DISPATCH FIRE POLICE                     SPTETI     21:57:16  \n R 2819                                            SPTETI     22:05:50  \n 2802 IS RESPONDING WITH THE BARRICADES            SPTETI     22:11:46  \n C FP28                                            SPTETI     22:23:03 \n\nThe Call Taker is BREYER MICHAEL R\nThe Dispatcher is DAVIS ELLIOT SCOTT\n\n\n");
    
    doParseTest("PABucksCounty",
        "ken@cadpage.org",
        "",
        "FRM:Bucks RSAN\nSUBJ:1/1\nMSG:STA4 STA6:GASL\nadr:BROWNSVILLE RD/PHILADELPHIA AV ,43\nbox:04004\ntm:12:45:04 FD1210910  Run: E4 E6=",
        "Bucks RSAN",
        "",
        "STA4 STA6:GASL\nadr:BROWNSVILLE RD/PHILADELPHIA AV ,43\nbox:04004\ntm:12:45:04 FD1210910  Run: E4 E6=",
        1, 1);
    
    doParseTest("NJGloucesterCounty",
        "ken@cadpage.org",
        "FW: Automatic R&R Notification",
        "\r\n\r\n-----Original Message-----\r\nFrom: GSKLAR@S105KD4M.CO.GLOUCESTER.NJ.US\r\n[mailto:GSKLAR@S105KD4M.CO.GLOUCESTER.NJ.US] \r\nSent: Sunday, July 29, 2012 5:07 PM\r\nTo: sta281@co.gloucester.nj.us\r\nSubject: Automatic R&R Notification\r\nImportance: High\r\n\r\n\r\n  \r\n** ** ** ** ** ** ** ** ** ** ** ** FINAL REPORT ** ** ** ** ** ** ** ** **\r\n** ** **  \r\nIncident Number  : 2012-00026707                    ORI: 0815281\r\nStation: 28-1  \r\nIncident Type  . : MEDE E MED EMERG            Priority: 3  \r\nIncident Location: 9 SIMPSON CT\r\nVenue: PITMAN \r\n\r\nCall Time- 15:58:18                                Date- 07/29/2012  \r\nDispatch - 16:09:44     En-route- 16:14:33     On-scene- 16:15:33     Depart\r\n1-  \r\nArrive 2 -              Depart 2-              In-statn-\r\nCleared - 16:27:51 \r\n\r\nArea:    O              Section :    O         Beat  . :    O  \r\nGrid:  L16              Quadrant: 2802         District: 2802 \r\n\r\nPhone Number: (856) 879-5273                Call Source:  TEL \r\n\r\nCaller. . . : TIM \r\n\r\nNature of Call : 9 SIMPSON CT \r\n\r\nAdditional Info\r\n  14F DISLOCATED KNEE \r\n\r\nNarrative\r\n Information on the units assigned to the call follows.  \r\n    Unit: E8300   Radio:           Ofcr 1:     E8300  Ofcr 2:  \r\n       DSP: 07/29/12  16:16:17     ENR: 07/29/12  16:16:17  \r\n       ARV:             :  :       DPT:             :  :  \r\n       QTR:             :  :       CLR: 07/29/12  16:29:21  \r\n    Unit: E8275   Radio:           Ofcr 1:            Ofcr 2:  \r\n       DSP: 07/29/12  15:58:35     ENR: 07/29/12  16:00:32  \r\n       ARV: 07/29/12  16:05:37     DPT: 07/29/12  16:28:59  \r\n       AR2: 07/29/12  16:43:50     DP2:             :  :  \r\n       QTR:             :  :       CLR: 07/29/12  17:07:16  \r\n    Unit: E8266   Radio:           Ofcr 1:            Ofcr 2:  \r\n       DSP: 07/29/12  16:10:28     ENR: 07/29/12  16:10:28  \r\n       ARV: 07/29/12  16:11:54     DPT:             :  :  \r\n       QTR:             :  :       CLR: 07/29/12  16:30:11  \r\n    Unit: F2800   Radio:           Ofcr 1:            Ofcr 2:  \r\n       DSP: 07/29/12  16:13:50     ENR: 07/29/12  16:13:50  \r\n       ARV: 07/29/12  16:14:22     DPT:             :  :  \r\n       QTR:             :  :       CLR: 07/29/12  16:27:36  \r\n    Unit: 28-1    Radio:           Ofcr 1:            Ofcr 2:  \r\n       DSP: 07/29/12  16:09:44     ENR: 07/29/12  16:14:33  \r\n       ARV: 07/29/12  16:15:36     DPT:             :  :  \r\n       QTR:             :  :       CLR: 07/29/12  16:27:44  \r\n    Unit: F2818   Radio:           Ofcr 1:     F2818  Ofcr 2:  \r\n       DSP: 07/29/12  16:15:26     ENR: 07/29/12  16:15:26  \r\n       ARV: 07/29/12  16:15:33     DPT:             :  :  \r\n       QTR:             :  :       CLR: 07/29/12  16:27:51  \r\n UNIT: E8275   UMH                                            16:28:59 \r\n\r\nThe Call Taker is SANTILLI JOSEPH C\r\nThe Dispatcher is ZELINSKY NICK J\r\n\r\n\n",
        "GSKLAR@S105KD4M.CO.GLOUCESTER.NJ.US",
        "Automatic R&R Notification",
        "** ** ** ** ** ** ** ** ** ** ** ** FINAL REPORT ** ** ** ** ** ** ** ** **\n** ** **  \nIncident Number  : 2012-00026707                    ORI: 0815281\nStation: 28-1  \nIncident Type  . : MEDE E MED EMERG            Priority: 3  \nIncident Location: 9 SIMPSON CT\nVenue: PITMAN \n\nCall Time- 15:58:18                                Date- 07/29/2012  \nDispatch - 16:09:44     En-route- 16:14:33     On-scene- 16:15:33     Depart\n1-  \nArrive 2 -              Depart 2-              In-statn-\nCleared - 16:27:51 \n\nArea:    O              Section :    O         Beat  . :    O  \nGrid:  L16              Quadrant: 2802         District: 2802 \n\nPhone Number: (856) 879-5273                Call Source:  TEL \n\nCaller. . . : TIM \n\nNature of Call : 9 SIMPSON CT \n\nAdditional Info\n  14F DISLOCATED KNEE \n\nNarrative\n Information on the units assigned to the call follows.  \n    Unit: E8300   Radio:           Ofcr 1:     E8300  Ofcr 2:  \n       DSP: 07/29/12  16:16:17     ENR: 07/29/12  16:16:17  \n       ARV:             :  :       DPT:             :  :  \n       QTR:             :  :       CLR: 07/29/12  16:29:21  \n    Unit: E8275   Radio:           Ofcr 1:            Ofcr 2:  \n       DSP: 07/29/12  15:58:35     ENR: 07/29/12  16:00:32  \n       ARV: 07/29/12  16:05:37     DPT: 07/29/12  16:28:59  \n       AR2: 07/29/12  16:43:50     DP2:             :  :  \n       QTR:             :  :       CLR: 07/29/12  17:07:16  \n    Unit: E8266   Radio:           Ofcr 1:            Ofcr 2:  \n       DSP: 07/29/12  16:10:28     ENR: 07/29/12  16:10:28  \n       ARV: 07/29/12  16:11:54     DPT:             :  :  \n       QTR:             :  :       CLR: 07/29/12  16:30:11  \n    Unit: F2800   Radio:           Ofcr 1:            Ofcr 2:  \n       DSP: 07/29/12  16:13:50     ENR: 07/29/12  16:13:50  \n       ARV: 07/29/12  16:14:22     DPT:             :  :  \n       QTR:             :  :       CLR: 07/29/12  16:27:36  \n    Unit: 28-1    Radio:           Ofcr 1:            Ofcr 2:  \n       DSP: 07/29/12  16:09:44     ENR: 07/29/12  16:14:33  \n       ARV: 07/29/12  16:15:36     DPT:             :  :  \n       QTR:             :  :       CLR: 07/29/12  16:27:44  \n    Unit: F2818   Radio:           Ofcr 1:     F2818  Ofcr 2:  \n       DSP: 07/29/12  16:15:26     ENR: 07/29/12  16:15:26  \n       ARV: 07/29/12  16:15:33     DPT:             :  :  \n       QTR:             :  :       CLR: 07/29/12  16:27:51  \n UNIT: E8275   UMH                                            16:28:59 \n\nThe Call Taker is SANTILLI JOSEPH C\nThe Dispatcher is ZELINSKY NICK J\n\n\n");
    
    doParseTest("CODouglasCounty",
        "ken@cadpage.org",
        "FW: Dispatch",
        "-----Original Message-----\nFrom: Norris Croom [mailto:NCroom@crgov.com] \nSent: Tuesday, July 03, 2012 5:02 AM\nTo: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\nSubject: FW: Dispatch\n\n\n-------------------------------------------\nFrom: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\nSent: Tuesday, July 03, 2012 5:02:16 AM\nTo: Norris Croom\nSubject: Dispatch\nAuto forwarded by a Rule\n\nCall: F LIFT ASSIST Location: 1050 HIGHLAND RIDGE WAY 101 / Map: AH29D2 Units: E154 XXX154  HIGHLAND VISTA AVE / HIGHLAND VISTA AVE Common Name: Time: 07/03/12 05:01 Narrative:  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002042",        
        "dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]",
        "Dispatch",
        "Call: F LIFT ASSIST Location: 1050 HIGHLAND RIDGE WAY 101 / Map: AH29D2 Units: E154 XXX154  HIGHLAND VISTA AVE / HIGHLAND VISTA AVE Common Name: Time: 07/03/12 05:01 Narrative:  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002042");
    
    doParseTest("CODouglasCounty",
        "[FW: Dispatch] \n-----Original Message-----\nFrom: Norris Croom [mailto:NCroom@crgov.com] \nSent: Tuesday, July 03, 2012 5:02 AM\nTo: Mike Horn; Michael Moore; Craig Rollins; Matt Rettmer\nSubject: FW: Dispatch\n\n\n-------------------------------------------\nFrom: dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]\nSent: Tuesday, July 03, 2012 5:02:16 AM\nTo: Norris Croom\nSubject: Dispatch\nAuto forwarded by a Rule\n\nCall: F LIFT ASSIST Location: 1050 HIGHLAND RIDGE WAY 101 / Map: AH29D2 Units: E154 XXX154  HIGHLAND VISTA AVE / HIGHLAND VISTA AVE Common Name: Time: 07/03/12 05:01 Narrative:  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002042",        
        "dcso@douglas.co.us[SMTP:DCSO@DOUGLAS.CO.US]",
        "Dispatch",
        "Call: F LIFT ASSIST Location: 1050 HIGHLAND RIDGE WAY 101 / Map: AH29D2 Units: E154 XXX154  HIGHLAND VISTA AVE / HIGHLAND VISTA AVE Common Name: Time: 07/03/12 05:01 Narrative:  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=DCSO--DOUGLAS WIRELESS VERIFY PD  VE 2012-00002042");
    
    doParseTest("NJGloucvesterCountyB",
        "ken@cadpage.org",
        "FW: Automatic R&R Notification",
        "-----Original Message-----\nFrom: DDOAK@S105KD4M.CO.GLOUCESTER.NJ.US\n[mailto:DDOAK@S105KD4M.CO.GLOUCESTER.NJ.US]\nSent: Tuesday, June 12, 2012 10:33 PM\nTo: EmergencyResponse\nSubject: Automatic R&R Notification\nImportance: High\n \n** ** ** ** ** ** ** ** ** ** ** ** FINAL REPORT ** ** ** ** ** ** ** **\n** ** ** ** \nIncident Number  : 2012-00020243                    ORI: 0818102\nStation: 10-2 \nIncident Type  . : ALMC F CO ALARM             Priority: 3 \nIncident Location: 811 MARLBOROUGH ST\nVenue: WASHINGTON\nCall Time- 20:50:34                                Date- 06/12/2012 \nDispatch - 20:51:29     En-route- 20:56:10     On-scene- 20:59:16\nDepart 1- \nArrive 2 -              Depart 2-              In-statn-\nCleared - 21:37:16\nArea:   R2              Section : 1004         Beat  . :    R \nGrid:  K21              Quadrant: 1017         District: 1017\nPhone Number: (856) 481-4361                Call Source:  TEL\nCaller. . . : PAUL FISHER\nNature of Call : 811 MARLBOROUGH ST\nAdditional Info\n  CO ALARM REDING 210 REQ FD\nNarrative\n Information on the units assigned to the call follows. \n    Unit: 10-2    Radio:           Ofcr 1:            Ofcr 2: \n       DSP: 06/12/12  20:51:29     ENR: 06/12/12  20:56:10 \n       ARV: 06/12/12  20:59:16     DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  21:37:16 \n    Unit: F1032   Radio:           Ofcr 1:     F1032  Ofcr 2: \n       DSP: 06/12/12  20:54:43     ENR: 06/12/12  20:54:43 \n       ARV:             :  :       DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  20:57:12 \n    Unit: E1094   Radio:           Ofcr 1:            Ofcr 2: \n       DSP: 06/12/12  21:18:52     ENR: 06/12/12  21:19:51 \n       ARV: 06/12/12  21:22:45     DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  22:33:24 \n CALLER ADVISED TO EXIT RES                        JJVERRECCH 20:50:18 \n R 1022 W/3                                        JBLAWRENCE 20:56:27 \n R 1021 W/3                                        JBLAWRENCE 20:57:38 \n O 1021                                            JBLAWRENCE 20:59:23 \n O 1022                                            JBLAWRENCE 21:03:13 \n PROGRESS REPORT.............NEG READINGS W/       JBLAWRENCE 21:18:58 \n METERS,REQUEST 1 BLS TO CHECK HOMEOWNER           JBLAWRENCE 21:19:22\nThe Call Taker is VERRECCHIO JOHN J\nThe Dispatcher is MCGARVEY RAYMOND E\n",
        "DDOAK@S105KD4M.CO.GLOUCESTER.NJ.US",
        "Automatic R&R Notification",
        "** ** ** ** ** ** ** ** ** ** ** ** FINAL REPORT ** ** ** ** ** ** ** **\n** ** ** ** \nIncident Number  : 2012-00020243                    ORI: 0818102\nStation: 10-2 \nIncident Type  . : ALMC F CO ALARM             Priority: 3 \nIncident Location: 811 MARLBOROUGH ST\nVenue: WASHINGTON\nCall Time- 20:50:34                                Date- 06/12/2012 \nDispatch - 20:51:29     En-route- 20:56:10     On-scene- 20:59:16\nDepart 1- \nArrive 2 -              Depart 2-              In-statn-\nCleared - 21:37:16\nArea:   R2              Section : 1004         Beat  . :    R \nGrid:  K21              Quadrant: 1017         District: 1017\nPhone Number: (856) 481-4361                Call Source:  TEL\nCaller. . . : PAUL FISHER\nNature of Call : 811 MARLBOROUGH ST\nAdditional Info\n  CO ALARM REDING 210 REQ FD\nNarrative\n Information on the units assigned to the call follows. \n    Unit: 10-2    Radio:           Ofcr 1:            Ofcr 2: \n       DSP: 06/12/12  20:51:29     ENR: 06/12/12  20:56:10 \n       ARV: 06/12/12  20:59:16     DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  21:37:16 \n    Unit: F1032   Radio:           Ofcr 1:     F1032  Ofcr 2: \n       DSP: 06/12/12  20:54:43     ENR: 06/12/12  20:54:43 \n       ARV:             :  :       DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  20:57:12 \n    Unit: E1094   Radio:           Ofcr 1:            Ofcr 2: \n       DSP: 06/12/12  21:18:52     ENR: 06/12/12  21:19:51 \n       ARV: 06/12/12  21:22:45     DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  22:33:24 \n CALLER ADVISED TO EXIT RES                        JJVERRECCH 20:50:18 \n R 1022 W/3                                        JBLAWRENCE 20:56:27 \n R 1021 W/3                                        JBLAWRENCE 20:57:38 \n O 1021                                            JBLAWRENCE 20:59:23 \n O 1022                                            JBLAWRENCE 21:03:13 \n PROGRESS REPORT.............NEG READINGS W/       JBLAWRENCE 21:18:58 \n METERS,REQUEST 1 BLS TO CHECK HOMEOWNER           JBLAWRENCE 21:19:22\nThe Call Taker is VERRECCHIO JOHN J\nThe Dispatcher is MCGARVEY RAYMOND E\n");
    
    doParseTest("NJGloucvesterCountyB",
        "[FW: Automatic R&R Notification] \n-----Original Message-----\nFrom: DDOAK@S105KD4M.CO.GLOUCESTER.NJ.US\n[mailto:DDOAK@S105KD4M.CO.GLOUCESTER.NJ.US]\nSent: Tuesday, June 12, 2012 10:33 PM\nTo: EmergencyResponse\nSubject: Automatic R&R Notification\nImportance: High\n \n** ** ** ** ** ** ** ** ** ** ** ** FINAL REPORT ** ** ** ** ** ** ** **\n** ** ** ** \nIncident Number  : 2012-00020243                    ORI: 0818102\nStation: 10-2 \nIncident Type  . : ALMC F CO ALARM             Priority: 3 \nIncident Location: 811 MARLBOROUGH ST\nVenue: WASHINGTON\nCall Time- 20:50:34                                Date- 06/12/2012 \nDispatch - 20:51:29     En-route- 20:56:10     On-scene- 20:59:16\nDepart 1- \nArrive 2 -              Depart 2-              In-statn-\nCleared - 21:37:16\nArea:   R2              Section : 1004         Beat  . :    R \nGrid:  K21              Quadrant: 1017         District: 1017\nPhone Number: (856) 481-4361                Call Source:  TEL\nCaller. . . : PAUL FISHER\nNature of Call : 811 MARLBOROUGH ST\nAdditional Info\n  CO ALARM REDING 210 REQ FD\nNarrative\n Information on the units assigned to the call follows. \n    Unit: 10-2    Radio:           Ofcr 1:            Ofcr 2: \n       DSP: 06/12/12  20:51:29     ENR: 06/12/12  20:56:10 \n       ARV: 06/12/12  20:59:16     DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  21:37:16 \n    Unit: F1032   Radio:           Ofcr 1:     F1032  Ofcr 2: \n       DSP: 06/12/12  20:54:43     ENR: 06/12/12  20:54:43 \n       ARV:             :  :       DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  20:57:12 \n    Unit: E1094   Radio:           Ofcr 1:            Ofcr 2: \n       DSP: 06/12/12  21:18:52     ENR: 06/12/12  21:19:51 \n       ARV: 06/12/12  21:22:45     DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  22:33:24 \n CALLER ADVISED TO EXIT RES                        JJVERRECCH 20:50:18 \n R 1022 W/3                                        JBLAWRENCE 20:56:27 \n R 1021 W/3                                        JBLAWRENCE 20:57:38 \n O 1021                                            JBLAWRENCE 20:59:23 \n O 1022                                            JBLAWRENCE 21:03:13 \n PROGRESS REPORT.............NEG READINGS W/       JBLAWRENCE 21:18:58 \n METERS,REQUEST 1 BLS TO CHECK HOMEOWNER           JBLAWRENCE 21:19:22\nThe Call Taker is VERRECCHIO JOHN J\nThe Dispatcher is MCGARVEY RAYMOND E\n",
        "DDOAK@S105KD4M.CO.GLOUCESTER.NJ.US",
        "Automatic R&R Notification",
        "** ** ** ** ** ** ** ** ** ** ** ** FINAL REPORT ** ** ** ** ** ** ** **\n** ** ** ** \nIncident Number  : 2012-00020243                    ORI: 0818102\nStation: 10-2 \nIncident Type  . : ALMC F CO ALARM             Priority: 3 \nIncident Location: 811 MARLBOROUGH ST\nVenue: WASHINGTON\nCall Time- 20:50:34                                Date- 06/12/2012 \nDispatch - 20:51:29     En-route- 20:56:10     On-scene- 20:59:16\nDepart 1- \nArrive 2 -              Depart 2-              In-statn-\nCleared - 21:37:16\nArea:   R2              Section : 1004         Beat  . :    R \nGrid:  K21              Quadrant: 1017         District: 1017\nPhone Number: (856) 481-4361                Call Source:  TEL\nCaller. . . : PAUL FISHER\nNature of Call : 811 MARLBOROUGH ST\nAdditional Info\n  CO ALARM REDING 210 REQ FD\nNarrative\n Information on the units assigned to the call follows. \n    Unit: 10-2    Radio:           Ofcr 1:            Ofcr 2: \n       DSP: 06/12/12  20:51:29     ENR: 06/12/12  20:56:10 \n       ARV: 06/12/12  20:59:16     DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  21:37:16 \n    Unit: F1032   Radio:           Ofcr 1:     F1032  Ofcr 2: \n       DSP: 06/12/12  20:54:43     ENR: 06/12/12  20:54:43 \n       ARV:             :  :       DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  20:57:12 \n    Unit: E1094   Radio:           Ofcr 1:            Ofcr 2: \n       DSP: 06/12/12  21:18:52     ENR: 06/12/12  21:19:51 \n       ARV: 06/12/12  21:22:45     DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  22:33:24 \n CALLER ADVISED TO EXIT RES                        JJVERRECCH 20:50:18 \n R 1022 W/3                                        JBLAWRENCE 20:56:27 \n R 1021 W/3                                        JBLAWRENCE 20:57:38 \n O 1021                                            JBLAWRENCE 20:59:23 \n O 1022                                            JBLAWRENCE 21:03:13 \n PROGRESS REPORT.............NEG READINGS W/       JBLAWRENCE 21:18:58 \n METERS,REQUEST 1 BLS TO CHECK HOMEOWNER           JBLAWRENCE 21:19:22\nThe Call Taker is VERRECCHIO JOHN J\nThe Dispatcher is MCGARVEY RAYMOND E\n");
    
    doParseTest("MISaginawCounty",
        "Pagecopy-LOC:255 N MAIN DESC:RM 7-A 93/F FELL HIP PAIN APT: TYP:*M*SICK PERSON IN PROGRESS",
        "ken@cadpage.org",
        "",
        "LOC:255 N MAIN DESC:RM 7-A 93/F FELL HIP PAIN APT: TYP:*M*SICK PERSON IN PROGRESS");
    
    doParseTest("PAJeffersonCounty",
        "prvs=0518956c10=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Fire - Alarm 251 S PENN STREET EXT Punxsutawney DEAD END / CLIFF ST 20-A Snyder Hill",
        "dispatch@jeffersoncountypa.com",
        "Incident",
        "Fire - Alarm 251 S PENN STREET EXT Punxsutawney DEAD END / CLIFF ST 20-A Snyder Hill");
    
    doParseTest("NCOrangeCounty",
        "0001/0002 cadpage@orangeem.org Subject:CAD Page for CFS 062512-155\nRECD: 11:14:46\nTG: OPS 2\nINC: Auto Fire Alarm\nLOC: 555 W CAMERON AVE\n",
        "cadpage@orangeem.org",
        "CAD Page for CFS 062512-155",
        "RECD: 11:14:46\nTG: OPS 2\nINC: Auto Fire Alarm\nLOC: 555 W CAMERON AVE\n",
        1, 2);
    
    doParseTest("PAMercerCounty",
        "\"9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: N BROAD ST/LINCOLN AVE GROV EID: 2360315 TYPE CODE: MVU CALLER NAME: LARRY GRACE CALLER ADDR: 522 E MAIN ST E",
        "\"9-1-1\"@mcc.co.mercer.pa.us",
        "IPS I/Page Notification",
        "Location: N BROAD ST/LINCOLN AVE GROV EID: 2360315 TYPE CODE: MVU CALLER NAME: LARRY GRACE CALLER ADDR: 522 E MAIN ST E");
    
    doParseTest("CTTollandCounty",
        "[05/13/2012 11:28] tn@tollandcounty911.com:  TN Alert / NO DIVE IN COVENTRY TODAY. REPEAT DIVE CANCELLED!",
        "tn@tollandcounty911.com",
        "05/13/2012 11:28",
        "TN Alert / NO DIVE IN COVENTRY TODAY. REPEAT DIVE CANCELLED!");
    
    doParseTest("COWeldCounty",
        "Fr:<wrc-hiplink@weldcorcc.co\nSu:Dispatch\nTxt: 24\nTAU\nD\n37TH ST @ 38TH AVE\nEVMIA\n3751\nCAME ACROSS A TA / REQ LAW & PM'S ROUTINE\nProQA Medical Case 84958 Aborted 1. Caller hung up\n\n\nid:7",
        "wrc-hiplink@weldcorcc.co",
        "Dispatch",
        "24\nTAU\nD\n37TH ST @ 38TH AVE\nEVMIA\n3751\nCAME ACROSS A TA / REQ LAW & PM'S ROUTINE\nProQA Medical Case 84958 Aborted 1. Caller hung up\n\n\nid:7");
    
    doParseTest("OHHamiltonCounty",
        "HC@hamilton-co.org\nMSG:\nHC:ODOR OF GAS 393 PROVIDENCE WY SHRN NEXT TO TRAILER..... CHARLES SOILBACK ** SMELL OF GAS ** SEE MALE COMPL REF ODOR OF NATURAL GAS LEAK FROM A POSS 1 INCH PIPE COMIN 12:07 HFE88 HFFG2 XST: 399 TARRYTON DR XST2: 337 CAMBRIDGE DR\r\n",
        "HC@hamilton-co.org",
        "",
        "HC:ODOR OF GAS 393 PROVIDENCE WY SHRN NEXT TO TRAILER..... CHARLES SOILBACK ** SMELL OF GAS ** SEE MALE COMPL REF ODOR OF NATURAL GAS LEAK FROM A POSS 1 INCH PIPE COMIN 12:07 HFE88 HFFG2 XST: 399 TARRYTON DR XST2: 337 CAMBRIDGE DR\n");
    
    doParseTest("PAChesterCountyF",
    		"1 of 2\n FRM:paging@minquas.org\n SUBJ:21 WILLIAMS WY ,39\n MSG:EMOTIONAL DISORDER - BLS * ** 21 WILLIAMS WY ,39 ** - **  ** CALN ** HUMPTON FARMS **\n(Con't) 2 of 2\nLYNN BL & HUMPTON RD ** (End)",
        "paging@minquas.org",
        "21 WILLIAMS WY ,39",
        "EMOTIONAL DISORDER - BLS * ** 21 WILLIAMS WY ,39 ** - **  ** CALN ** HUMPTON FARMS ** LYNN BL & HUMPTON RD ** ");
    
    doParseTest("NJSomersetCounty", 
        "*3898: *messaging@iamresponding.com / 77 RESCUE / kharju:SBB-RS:12029633 :03/01/2012 23 <201223>:53:12:SICK PERSON:22 YOM: SOUTH B-SOUTHSIDE GRILL / 2 MAIN ST #10",
        "messaging@iamresponding.com",
        "",
        "/ 77 RESCUE / kharju:SBB-RS:12029633 :03/01/2012 23 <201223>:53:12:SICK PERSON:22 YOM: SOUTH B-SOUTHSIDE GRILL / 2 MAIN ST #10");
    
    doParseTest("COWeldCounty",
        " \" \" 26\nFIREV\nD\n14619 WCR 18\nFL\n26 TXT STOP to opt-out",
        "ken@cadpage.org",
        "",
        "26\nFIREV\nD\n14619 WCR 18\nFL\n26 ");
    
    doParseTest("",
        "farmersvillefd+caf_=7042218878=vtext.com@gmail.com", "",
        "12000351  FIRST RESPONDERS  901 S STATE HIGHWAY 78 IN COLLIN COUNTY  PECAN CREEK DR / COUNTY ROAD 606  [FVFD DIST: FVF1 GRID: 124",
        "farmersvillefd+caf_=7042218878=vtext.com@gmail.com", "",
        "12000351  FIRST RESPONDERS  901 S STATE HIGHWAY 78 IN COLLIN COUNTY  PECAN CREEK DR / COUNTY ROAD 606  [FVFD DIST: FVF1 GRID: 124");
        
    doParseTest("COWeldCounty",
        "Fr:<Basepage@weldcorcc.com>\nSu:Dispatch\nTxt: 27849,SI -SICK & INJ (F&A),CR 55/CR 62.37 WA,FG 5\n\n\nid:7",
        "Basepage@weldcorcc.com",
        "Dispatch",
        "27849,SI -SICK & INJ (F&A),CR 55/CR 62.37 WA,FG 5\n\n\nid:7");
    
    doParseTest("CTLitchfieldCounty",
        "S: LCD Message\nNEW HARTFORD FIRE RESPOND TO 1580 LITCHFIELD TPKE   NEW HARTFORD, , MVA- NO INJURIES- FLUID SPILL ,:08:27",
        "ken@cadpage.org",
        "LCD Message",
        "NEW HARTFORD FIRE RESPOND TO 1580 LITCHFIELD TPKE   NEW HARTFORD, , MVA- NO INJURIES- FLUID SPILL ,:08:27");
    
    doParseTest("TXGalvestonCounty",
        " .... (Santa Fe Fire) CAD:GRASS FIRE 12603 PONDEROSA DR",
        "ken@cadpage.org",
        "Santa Fe Fire",
        "CAD:GRASS FIRE 12603 PONDEROSA DR");
    
    doParseTest("NCGuilfordCounty",
        "S:summerfieldfiredist Oct17-12:45 M:summerfieldfiredist\nCAD:UNDER CONTROL;808 JAMES DOAK PKWY; G\n\n",
        "ken@cadpage.org",
        "summerfieldfiredist Oct17-12:45",
        "summerfieldfiredist\nCAD:UNDER CONTROL;808 JAMES DOAK PKWY; G\n\n");
    
    doParseTest("PANOrthamptonCounty",
        "*3750: *alert_6JP4@notifync.org /  / [f25]ODOR >ODOR / OTHER THAN SMOKE ARNDT RD FORKS Map: Grids:0,0 Cad: 2011-0000171220 <20110000171220>",
        "alert_6JP4@notifync.org",
        "f25",
        "ODOR >ODOR / OTHER THAN SMOKE ARNDT RD FORKS Map: Grids:0,0 Cad: 2011-0000171220 <20110000171220>");
    
    doParseTest("NCCarteretCounty",
        "wcfd.comm2+caf_=2522413726=vtext.com@gmail.com CEC:129 HUNTER BROWN DR CAPE CARTERET 11-113600 16:24:22 STROKE",
        "vtext.com@gmail.com",
        "",
        "CEC:129 HUNTER BROWN DR CAPE CARTERET 11-113600 16:24:22 STROKE");
    
    doParseTest("NYJeffersonCounty",
        "sentto-76513067-101-1314862564-3159559896=vtext.com@returns.groups.yahoo.com ([carthageambulance] DISPATCH:1191) FALL|1045 WEST ST:CARTHAGE(V)|83 Y/F FELL OUT OF BED BROKEN NOSE AN",
        "vtext.com@returns.groups.yahoo.com",
        "[carthageambulance] DISPATCH:1191",
        "FALL|1045 WEST ST:CARTHAGE(V)|83 Y/F FELL OUT OF BED BROKEN NOSE AN");
        
    doParseTest("NJSussexCounty",
        "KBROWN@andpd (I-2011-000118) MVA-F @ DECKER POND ROAD/SUNSET DRIVE  , GREEN TWP - CAR VS GUARDRAIL - MINOR INJURIES",
        "KBROWN@andpd",
        "I-2011-000118",
        "MVA-F @ DECKER POND ROAD/SUNSET DRIVE  , GREEN TWP - CAR VS GUARDRAIL - MINOR INJURIES");
    
    doParseTest("NCMontgomeryCounty",
        "1 of 10\nFRM:CAD@otsegocounty.com\nSUBJ:911 EVENT\nMSG:HAZARD ALL|WILBER NATIONAL BANK - COOPERS|5378 ST HWY 28   STA COOP3 XS CO HWY 26\n(Con't) 2 of 10\n/WALNUT|09:04|NARR SOUTH OF BANK MVA PDAA NEED FIR POLICE  PERSON: (COMPLAINANT) (FMLS) TIM  DONLAN\nDisclaimer:\n\nThis communication,\n(Con't 3 of 10\nincluding any attachments, may contain confidential information and is intended only for \nthe individual or entity to whom it is\n(Con't) 4 of 10\naddressed. Any review, dissemination, or copying of this communication \nby anyone other than the intended recipient is strictly\n(Con't) 5 of 10\nprohibited. If you are not the intended recipient, please \ncontact the sender by reply e-mail, delete and destroy all copies of the origi\nMore?",
        "CAD@otsegocounty.com",
        "911 EVENT",
        "HAZARD ALL|WILBER NATIONAL BANK - COOPERS|5378 ST HWY 28   STA COOP3 XS CO HWY 26 /WALNUT|09:04|NARR SOUTH OF BANK MVA PDAA NEED FIR POLICE  PERSON: (COMPLAINANT) (FMLS) TIM  DONLAN\nDisclaimer:\n\nThis communication, including any attachments, may contain confidential information and is intended only for \nthe individual or entity to whom it is addressed. Any review, dissemination, or copying of this communication \nby anyone other than the intended recipient is strictly prohibited. If you are not the intended recipient, please \ncontact the sender by reply e-mail, delete and destroy all copies of the origi");
    
    doParseTest("NCBuncombeCounty1",
        "S: M:CAD:25 REYNOLDS MOUNTAIN BLVD;B20;RM 126-A;EMERALD RIDGE;EMERALD RIDGE REHAB AND CARE C;ALLERGIES / REACTIONS;WEAVERVILLE RD",
        "ken@cadpage.org",
        "",
        "CAD:25 REYNOLDS MOUNTAIN BLVD;B20;RM 126-A;EMERALD RIDGE;EMERALD RIDGE REHAB AND CARE C;ALLERGIES / REACTIONS;WEAVERVILLE RD");
    
    doParseTest("NCBuncombeCounty2",
        "S:FIRE ALERT M:CAD:25 REYNOLDS MOUNTAIN BLVD;B20;RM 126-A;EMERALD RIDGE;EMERALD RIDGE REHAB AND CARE C;ALLERGIES / REACTIONS;WEAVERVILLE RD",
        "ken@cadpage.org",
        "FIRE ALERT",
        "CAD:25 REYNOLDS MOUNTAIN BLVD;B20;RM 126-A;EMERALD RIDGE;EMERALD RIDGE REHAB AND CARE C;ALLERGIES / REACTIONS;WEAVERVILLE RD");
    
    doParseTest("KYDaviessCounty1",
        "1 of 2\nFRM:911-CENTER@911Center@central\nMSG:\n911-CENTER:ACCINJ>ACCIDENT WITH INJURIES 3970 CRANE POND RD XS: U S HIGHWAY 231 PHILPOT JOHNS, AMY\n(Con't) 2 of 2\nMap: Grids:, Cad: 2011-0000013291 (End)",
        "911-CENTER@911Center@central",
        "",
        "911-CENTER:ACCINJ>ACCIDENT WITH INJURIES 3970 CRANE POND RD XS: U S HIGHWAY 231 PHILPOT JOHNS, AMY Map: Grids:, Cad: 2011-0000013291 ");
    
    doParseTest("KYDaviessCounty1",
        "1 of 2\nFRM:911-CENTER@911Center@central\nMSG:911-CENTER:FF >WILDLAND FIRE 12957 RED HILL-MAXWELL RD XS: E HARMONS FERRY RD UTICA PRESSON, DAVID\n(Con't) 2 of 2\nMap: Grids:, Cad: 2011-0000012778(End)",
        "911-CENTER@911Center@central",
        "",
        "911-CENTER:FF >WILDLAND FIRE 12957 RED HILL-MAXWELL RD XS: E HARMONS FERRY RD UTICA PRESSON, DAVID Map: Grids:, Cad: 2011-0000012778");
       
    
    doParseTest("MNAnokaCOunty",
        "cad.cad@co.Anoka.mn.us / / CAD MSG: *D S1 39F 7783 233 LN NE GEN SMOKE/FIRE ALRM.. INC:11001880",
        "cad.cad@co.Anoka.mn.us",
        "",
        "CAD MSG: *D S1 39F 7783 233 LN NE GEN SMOKE/FIRE ALRM.. INC:11001880");
    
    doParseTest("MILivingstonCounty",
        "Pagecopy-Fr:CAD@livingstoncounty.livco\nCAD:FYI: ;OVDOSE;4676 KENMORE DR;[Medical Priority Info] RESPONSE: P1 STA 1",
        "CAD@livingstoncounty.livco",
        "",
        "CAD:FYI: ;OVDOSE;4676 KENMORE DR;[Medical Priority Info] RESPONSE: P1 STA 1");
    
    doParseTest("MILivingstonCounty2",
        "firediver11+caf_=5176671194=vtext.com@gmail.comPagecopy-Fr:CAD@livingstoncounty.livco\nCAD:FYI: ;SEIZUR;131 STRATFORD LN;BELMONT LN;[Medical Priority Info]",
        "CAD@livingstoncounty.livco",
        "",
        "CAD:FYI: ;SEIZUR;131 STRATFORD LN;BELMONT LN;[Medical Priority Info]");
    
    doParseTest("MILivingstonCounty3",
        "Pagecopy-Fr:CAD@livingstoncounty.livco CAD:Update: ;FALL;3031 WM36;[EMS] HAS BEEN VOMITTING - DIABETIC [02/14/11 09:55:08 RLADOUCEUR] [Me",
        "CAD@livingstoncounty.livco",
        "",
        "CAD:Update: ;FALL;3031 WM36;[EMS] HAS BEEN VOMITTING - DIABETIC [02/14/11 09:55:08 RLADOUCEUR] [Me");

    
    doParseTest("MOPulaskiCounty",
        "1 of 3\n" +
        "FRM:911dispatch@embarqmail.com\n" + 
        "SUBJ:DO NOT REPLY\n" +
        "MSG:STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway\n" +
        "(Con't) 2 of 3\n" +
        "17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call\n" +
        "(Con't) 3 of 3\n" +
        "Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29(End)",
        "911dispatch@embarqmail.com",
        "DO NOT REPLY",
        "STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway 17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29");
    
    doParseTest("T0",
        "JUST A PLAIN TEXT MESSAGE",
        "ken@cadpage.org",
        "",
        "JUST A PLAIN TEXT MESSAGE");
    
    doParseTest("T1", 
        "1 of 3\n"+
        "FRM:CAD@livingstoncounty.livco\n"+
        "MSG:CAD:FYI: ;CITAF;5579 E GRAND RIVER;WILDWOOD DR;Event spawned from CITIZEN ASSIST LAW. [12/10/10\n" +
        "(Con't) 2 of 3\n" +
        "20:08:59 SPHILLIPS] CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAINBREAK [12/10/10 20:04:40 HROSSNER] CALLER ADV OF A WATER MAIN\n" +
        "(Con 3 of 3\n" +
        "BREAK(End)",
        "CAD@livingstoncounty.livco",
        "",
        "CAD:FYI: ;CITAF;5579 E GRAND RIVER;WILDWOOD DR;Event spawned from CITIZEN ASSIST LAW. [12/10/10 20:08:59 SPHILLIPS] CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAINBREAK [12/10/10 20:04:40 HROSSNER] CALLER ADV OF A WATER MAIN BREAK");
    
    doParseTest("T2",
        "1 of 3\n"+
        "FRM:911dispatch@embarqmail.com\n"+ 
        "SUBJ:DO NOT REPLY\n"+
        "MSG:STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway\n"+
        "(Con't) 2 of 3\n"+
        "17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call\n"+
        "(Con't) 3 of 3\n"+
        "Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29(End)",
        "911dispatch@embarqmail.com",
        "DO NOT REPLY",
        "STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway 17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29");
    
    doParseTest("MDPrinceGeorgesCounty",
        "FRM:e@fireblitz.com <Body%3AFRM%3Ae@fireblitz.com>\n" +
        "MSG:48: TOWNHOUSE FIRE\n" +
        "E818 BO802\n" +
        "9903 BREEZY KNOLL CT [DEAD END & GREEN HAVEN RD]\n" +
        "12/23 23:32\n" +
        "http://fireblitz.com/18/8.shtm",
        "e@fireblitz.com <Body%3AFRM%3Ae@fireblitz.com>",
        "",
        "48: TOWNHOUSE FIRE\n" +
        "E818 BO802\n" +
        "9903 BREEZY KNOLL CT [DEAD END & GREEN HAVEN RD]\n" +
        "12/23 23:32\n" +
        "http://fireblitz.com/18/8.shtm");
    
    doParseTest("MDAlleganyCounty",
        "FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 100110-96\nMSG:UNCONCIOUS/UNRESPONSIVE 91 S BROADWAY\nUnits: A53 CO16",
        "LogiSYSCAD",
        "CAD Page for CFS 100110-96",
        "UNCONCIOUS/UNRESPONSIVE 91 S BROADWAY\nUnits: A53 CO16");
    
    doParseTest("NYOneidaCounty",
        "FRM:dispatch@oc911.org\nMSG:i>¿WEVF:2010:0181Dispatched10D02-DIFFICULTY SPEAKING BETWEEN BREATHS9071 DOPP HILL RD, WESTERN (ROUTE 46/;)",
        "dispatch@oc911.org",
        "",
        "i>¿WEVF:2010:0181Dispatched10D02-DIFFICULTY SPEAKING BETWEEN BREATHS9071 DOPP HILL RD, WESTERN (ROUTE 46/;)");
    
    doParseTest("TxCyCreekComCenter",
        "CommCenter@ccems.com <Body%3ACommCenter@ccems.com> [] TAP OUT (SAL)",
        "CommCenter@ccems.com <Body%3ACommCenter@ccems.com>",
        "",
        "TAP OUT (SAL)");
    
    doParseTest("MDHarford",
        "Subject:HCCAD\n[!] EOC:F03 WIRES >WIRES/POLE SHAWNEE DR&WALTERS MILL RD XS: WALTERS MILL RD FOREST HILL NOT ENTERED Cad: 2010-000019169",
        "ken@cadpage.org",
        "HCCAD|!",
        "EOC:F03 WIRES >WIRES/POLE SHAWNEE DR&WALTERS MILL RD XS: WALTERS MILL RD FOREST HILL NOT ENTERED Cad: 2010-000019169");
    
    doParseTest("shortMsg",
        "FRM:CommCenter@ccems.com\nMSG:BAD",
        "CommCenter@ccems.com",
        "",
        "BAD");
    
    doParseTest("(sub)msg",
        "(THE SUBJECT(ID 3342)) HELLO DOLLY",
        "ken@cadpage.org",
        "THE SUBJECT(ID 3342)",
        "HELLO DOLLY");
    
    doParseTest("[sub]msg",
        "[THE SUBJECT[ID 3342]] HELLO DOLLY",
        "ken@cadpage.org",
        "THE SUBJECT[ID 3342]",
        "HELLO DOLLY");
    
    doParseTest("(s1)[s2]",
        "(SUBJECT ONE) [ SUBJECT TWO ] HELLO BABE",
        "ken@cadpage.org",
        "SUBJECT ONE|SUBJECT TWO",
        "HELLO BABE");
    
    doParseTest("VAWaynesboro",
        "Dispatch@ci.waynesboro.va.us <Body%3ADispatch@ci.waynesboro.va.us> Msg: Dispatch:2ND CALL 1001 HOPEMAN PKWY, ZAP12 INJURIES FROM PREVIOUS MVA",
        "Dispatch@ci.waynesboro.va.us <Body%3ADispatch@ci.waynesboro.va.us>",
        "",
        "Dispatch:2ND CALL 1001 HOPEMAN PKWY, ZAP12 INJURIES FROM PREVIOUS MVA");
    
    doParseTest("PABerksCounty",
        "FRM:\nSUBJ:1/2\nMSG:CAD MSG: *D TREESDWN FORGEDALE RD / CLAY VALLEY RD 0087 PSP IS REQ FIRE\nCO FOR TREE REMOVAL FROM ROADWAY // PSP NOT ON LOC BC",
        "ken@cadpage.org",
        "",
        "CAD MSG: *D TREESDWN FORGEDALE RD / CLAY VALLEY RD 0087 PSP IS REQ FIRE\nCO FOR TREE REMOVAL FROM ROADWAY // PSP NOT ON LOC BC",
        1, 2);
    
    doParseTest("MIMobileMedicalRsponse",
        "prvs=10825513db=mailghost@mobilemedical.org (<CAD> - part 1 of 1) Congratulations to Mary Remington!",
        "mailghost@mobilemedical.org",
        "<CAD> - part 1 of 1",
        "Congratulations to Mary Remington!");
    
    doParseTest("NCSurryCounty",
        "SC911-CallAlert!!@co.surry.nc.us S: M:SC911 - Call Alert!!:Call Number - 110430-103* Address - 1020 NEWSOME ST* City - MOUNT AIRY* Call Type - ACCIDENT PI* *",
        "SC911-CallAlert!!@co.surry.nc.us",
        "",
        "SC911 - Call Alert!!:Call Number - 110430-103* Address - 1020 NEWSOME ST* City - MOUNT AIRY* Call Type - ACCIDENT PI* *");

    doParseTest("KYErlanger",
        "pscc@ci.erlanger.ky.us\nSUBJ:Alert: Unconscious / Unresponsive\nMSG:\nALRM LVL: 1\nLOC:\n32 DUDLEY RD\nEDGEWOOD\nBTWN: MAPLE LN & WILDROSE DR\n\nRCVD AS E-911 Call\n\nCOM:\nSUBJ FELL IN BATHROOM\nUNK IF BREATHING\nBETWEEN THE TOILET AND BATH TUB\n\nCT:\n22-RCA at POS 03\n",
        "pscc@ci.erlanger.ky.us",
        "Alert: Unconscious / Unresponsive",
        "ALRM LVL: 1\nLOC:\n32 DUDLEY RD\nEDGEWOOD\nBTWN: MAPLE LN & WILDROSE DR\n\nRCVD AS E-911 Call\n\nCOM:\nSUBJ FELL IN BATHROOM\nUNK IF BREATHING\nBETWEEN THE TOILET AND BATH TUB\n\nCT:\n22-RCA at POS 03");
    
    doParseTest("MDAlleganyCounty",
        "LogiSYSCAD S:CAD Page for CFS 051211-55 M:SERVICE CALL",
        "LogiSYSCAD",
        "CAD Page for CFS 051211-55",
        "SERVICE CALL");
    
    doParseTest("WIKenoshaCounty",
        " ( 1 of  2) S: M:From: JDR315 #:002011089429 ALS MED at 21922 121ST ST Rem: 64 F ;HEART PROBLEM CONSCIOUS: YES ,BREATHING: YES",
        "ken@cadpage.org",
        "",
        "From: JDR315 #:002011089429 ALS MED at 21922 121ST ST Rem: 64 F ;HEART PROBLEM CONSCIOUS: YES ,BREATHING: YES", 1, 2);
    
    doParseTest("NCWataugaCounty","" +
    		"wcso911@wataugacounty.org 164 BERTON ST BOONE MDL 06D02 2011017104 01:24:25 SICK PERSON 421S-RT OLD 421S-RT BROWNS CHAPEL RD-2ND LT NORTHRDG DR-1ST RT BERTON ST",
        "wcso911@wataugacounty.org",
        "",
        "164 BERTON ST BOONE MDL 06D02 2011017104 01:24:25 SICK PERSON 421S-RT OLD 421S-RT BROWNS CHAPEL RD-2ND LT NORTHRDG DR-1ST RT BERTON ST");

  }
  
  @Test
  public void testParseBreak() {
    doParseTest("PABucksCounty",
                "alert31089@alert.bucksema.org /1/2 /STA13:FINV\nadr:INDIAN CREEK DR/INDIAN CREEK PS ,25\nbox:13005\ntm:04:27:01 FD1205233  Run: SQ13",
                "alert31089@alert.bucksema.org",
                "",
                "STA13:FINV\nadr:INDIAN CREEK DR/INDIAN CREEK PS ,25\nbox:13005\ntm:04:27:01 FD1205233  Run: SQ13", 
                1, 2);
        
    doParseTest("OHHamiltonCounty", "0002/0002 XST2: 6400 DAWSON RD",
                "ken@cadpage.org", "", "XST2: 6400 DAWSON RD", 2, 2);
    
    doParseTest("PAErieCounty", "1 of 2:ERIE911:65A >MUTUAL AID/ASSIST",
                "ken@cadpage.org", "", "ERIE911:65A >MUTUAL AID/ASSIST", 1, 2);
    
    doParseTest("HDR1", "0001/0003 THIS IS A TEST",
                "ken@cadpage.org", "", "THIS IS A TEST", 1, 3);
    
    doParseTest("HDR1-done", "0003/0003 THIS IS ANOTHER TEST",
                "ken@cadpage.org", "", "THIS IS ANOTHER TEST", 3, 3);
    
    doParseTest("HDR2", "1of3:THIS IS A TEST",
                "ken@cadpage.org", "", "THIS IS A TEST", 1, 3);
    
    doParseTest("HDR2-done", "3of3:THIS IS ANOTHER TEST",
                "ken@cadpage.org", "", "THIS IS ANOTHER TEST", 3, 3);
    
    doParseTest("HDR3", "(1/2) I LOVE MY MOTHER",
                "ken@cadpage.org", "", "I LOVE MY MOTHER", 1, 2);
    
    doParseTest("HDR3-done", "(2/2) I LOVE MY MOTHER",
                "ken@cadpage.org", "", "I LOVE MY MOTHER", 2, 2);
    
    doParseTest("HDR4", " 1/3 / BIG BAD WOLF",
                "ken@cadpage.org", "", "BIG BAD WOLF", 1, 3);
    
    doParseTest("HDR4-done", " 3/3 / BIG BAD WOLF",
                "ken@cadpage.org", "", "BIG BAD WOLF", 3, 3);
    
    doParseTest("HDR5", "Subject:1/2\nSQ814 APTF, Apartment Fire",
                "ken@cadpage.org", "", "SQ814 APTF, Apartment Fire", 1, 2);
    
    doParseTest("HDR5-done", "Subject:2/2\nSQ814 APTF, Apartment Fire",
                "ken@cadpage.org", "", "SQ814 APTF, Apartment Fire", 2, 2);
    
    doParseTest("HDR6", "( 1 of  3) S: M:HBFD PRI: 1 INC: FHB110509000117",
                "ken@cadpage.org", "", "HBFD PRI: 1 INC: FHB110509000117", 1, 3);
    
    doParseTest("HDR6", "( 3 of  3) S: M:HBFD PRI: 1 INC: FHB110509000117",
                "ken@cadpage.org", "", "HBFD PRI: 1 INC: FHB110509000117", 3, 3);
    
    doParseTest("TRL1", "WHERE IS BABY[1 of 2]",
               "ken@cadpage.org", "", "WHERE IS BABY", 1, 2);
    
    doParseTest("TRL1-done", "WHERE IS BABY[2 of 2]",
               "ken@cadpage.org", "", "WHERE IS BABY", 2, 2);
    
    doParseTest("TRL2", "WHERE IS BABY :1of2",
               "ken@cadpage.org", "", "WHERE IS BABY ", 1, 2);
    
    doParseTest("TRL2-done", "WHERE IS BABY :2of2",
               "ken@cadpage.org", "", "WHERE IS BABY ", 2, 2);
    
    doParseTest("NYSuffolkCounty",
        "(1/2)Daniel M. Agababian - Sender: paging@firerescuesystems.xohost.com\n*** 16 - Rescue *** 30 DEER SHORE SQ CS: DEER PARK AVE  / BAY SHORE RD TOA: 13:04",
        "paging@firerescuesystems.xohost.com", "","*** 16 - Rescue *** 30 DEER SHORE SQ CS: DEER PARK AVE  / BAY SHORE RD TOA: 13:04", 1, 2);
    
    doParseTest("NJGoucesterCounty",
        "Subject:1/2\n\nDispatch\n\nSta:43-2\n\nType:SERV",
        "ken@cadpage.org", "", "Dispatch\n\nSta:43-2\n\nType:SERV", 1, 2);

  }

  @Test
  public void testEscape() {
    assertEquals("BIG RED ONE", Message.escape("BIG RED ONE"));
    assertEquals("BIG RED ONE\\n\n\\tOVER THERE\\n\nSIX\\6sSPACES\\3s3", 
                 Message.escape("BIG RED ONE\n\tOVER THERE\nSIX      SPACES   3"));
    assertEquals("ODD CHARS \\t\\b\\f\\r\\n\n", Message.escape("ODD CHARS \t\b\f\r\n"));
    assertEquals("BIG\\u0001ONE\\u0005RED", Message.escape("BIG\u0001ONE\u0005RED"));
  }
  
  private void doParseTest(String title, String body, String expFrom, String expSubject, String expBody) {
    doParseTest(title, body, expFrom, expSubject, expBody, -1, -1);
  }
  
  private void doParseTest(String title, String body, String expFrom, 
                             String expSubject, String expBody, 
                             int expIndex, int expCount) {
    doParseTest(title, "ken@cadpage.org", "", body, expFrom, expSubject, expBody, expIndex, expCount);
  }
  
  private void doParseTest(String title, String from, String subject, String body, 
                             String expFrom, String expSubject, String expBody) {
    doParseTest(title, from, subject, body, expFrom, expSubject, expBody, -1, -1);
  }
  
  private void doParseTest(String title, String from, String subject, String body, 
                             String expFrom, String expSubject, String expBody, 
                             int expIndex, int expCount) {
    Message msg = new Message(true, from, subject, body);
    assertEquals(title + ":FROM", expFrom, msg.getAddress());
    assertEquals(title + ":SUBJ", expSubject, msg.getSubject());
    assertEquals(title + ":BODY", expBody, msg.getMessageBody());
    assertEquals(title + ":INDEX", expIndex, msg.getMsgIndex());
    assertEquals(title + ":COUNT", expCount, msg.getMsgCount());
  }
}
